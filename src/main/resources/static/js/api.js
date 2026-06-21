const BASE_URL = "";

function getToken()   { return localStorage.getItem("token"); }
function getRole()    { return localStorage.getItem("role"); }
function isLoggedIn() { return !!getToken(); }

function logout() {
  localStorage.clear();
  window.location.href = "/pages/login.html";
}

function requireAuth() {
  if (!isLoggedIn()) window.location.href = "/pages/login.html";
}

function requireAdmin() {
  if (!isLoggedIn()) { window.location.href = "/pages/login.html"; return; }
  if (getRole() !== "ADMIN") window.location.href = "/pages/dashboard.html";
}

function redirectIfLoggedIn() {
  if (!isLoggedIn()) return;
  window.location.href = getRole() === "ADMIN" ? "/pages/admin.html" : "/pages/dashboard.html";
}

async function apiFetch(endpoint, method = "GET", body = null) {
  const headers = { "Content-Type": "application/json" };
  const token = getToken();
  if (token) headers["Authorization"] = "Bearer " + token;

  const options = { method, headers };
  if (body) options.body = JSON.stringify(body);

  let res;
  try {
    res = await fetch(BASE_URL + endpoint, options);
  } catch {
    return { ok: false, status: 0, data: "Network error - is the server running?" };
  }

  // Only logout on 401 (token invalid), NOT on 403 (forbidden)
  // 403 just means the operation failed, not that the session is invalid
  if (res.status === 401) {
    alert("Session expired. Please login again.");
    logout();
    return null;
  }

  const text = await res.text();
  let data;
  try { data = JSON.parse(text); } catch { data = text; }
  return { ok: res.ok, status: res.status, data };
}

function showMsg(id, text, type) {
  const el = document.getElementById(id);
  if (!el) return;
  el.textContent = text;
  el.className = "msg " + type;
}

function clearMsg(id) {
  const el = document.getElementById(id);
  if (el) el.className = "msg";
}

function switchTab(name, btn) {
  document.querySelectorAll(".tab-content").forEach(t => t.classList.remove("active"));
  document.querySelectorAll(".tab-btn").forEach(b => b.classList.remove("active"));
  document.getElementById("tab-" + name).classList.add("active");
  btn.classList.add("active");
}

function statusBadge(status) {
  if (!status) return "-";
  const s = status.toUpperCase();
  if (["AVAILABLE", "ACTIVE", "COMPLETED", "PAID"].includes(s))
    return `<span class="badge badge-green">${status}</span>`;
  if (["OCCUPIED", "CANCELLED", "UNPAID"].includes(s))
    return `<span class="badge badge-red">${status}</span>`;
  if (["RESERVED", "PENDING"].includes(s))
    return `<span class="badge badge-yellow">${status}</span>`;
  return `<span class="badge badge-gray">${status}</span>`;
}

function fmt(dt) {
  if (!dt) return "-";
  return String(dt).replace("T", " ").substring(0, 16);
}
