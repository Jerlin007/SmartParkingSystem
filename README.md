# Smart Parking — Deployment Guide

## 1. Docker (Simplest way to run)

Place `Dockerfile` and `docker-compose.yml` in the root of your project.

```bash
# Build and start both app and MySQL
docker-compose up --build

# Stop
docker-compose down
```

App runs at: http://localhost:8080

---

## 2. Kubernetes

Requirements: Docker Desktop with Kubernetes enabled, or Minikube.

```bash
# Step 1 — Build Docker image first
docker build -t smartparking-app:latest .

# Step 2 — Apply MySQL
kubectl apply -f k8s/mysql-deployment.yml

# Step 3 — Wait for MySQL to be ready
kubectl get pods

# Step 4 — Apply app
kubectl apply -f k8s/app-deployment.yml

# Step 5 — Check everything running
kubectl get pods
kubectl get services
```

App runs at: http://localhost:30080

```bash
# To stop/delete everything
kubectl delete -f k8s/app-deployment.yml
kubectl delete -f k8s/mysql-deployment.yml
```

---

## 3. Jenkins CI/CD

Requirements: Jenkins installed with Maven, JDK17, Docker and kubectl configured.

Steps:
1. Open Jenkins → New Item → Pipeline
2. Set Pipeline script from SCM → Git → your repo URL
3. Set Script Path: `Jenkinsfile`
4. Save and click Build Now

Pipeline does:
- Checkout code
- Build with Maven
- Run all JUnit tests
- Build Docker image
- Deploy to Kubernetes

---

## File placement in your project

```
smartparkingmanagementsys/
    Dockerfile          ← root of project
    docker-compose.yml  ← root of project
    Jenkinsfile         ← root of project
    k8s/
        mysql-deployment.yml
        app-deployment.yml
    src/
        ...
    pom.xml
```
