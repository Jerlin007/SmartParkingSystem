package com.wip.smartparkingmanagementsys.tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wip.smartparkingmanagementsys.dto.VehicleDto;
import com.wip.smartparkingmanagementsys.entity.User;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.UserRepository;
import com.wip.smartparkingmanagementsys.repository.VehicleRepository;
import com.wip.smartparkingmanagementsys.service.VehicleServiceImpl;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock private VehicleRepository vehicleRepository;
    @Mock private UserRepository userRepository;
    @InjectMocks private VehicleServiceImpl vehicleService;

    @Test
    void addVehicle_validData_savesAndReturnsDto() {
        User user = new User();
        user.setUser_id(1L);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);
        vehicle.setVehicle_number("TN01AB1234");
        vehicle.setVehicle_Type("CAR");
        vehicle.setOwner_name("Ram");
        vehicle.setMobile_number("9876543210");
        vehicle.setUser(user);

        VehicleDto dto = new VehicleDto();
        dto.setVehicle_number("TN01AB1234");
        dto.setVehicle_Type("CAR");
        dto.setOwner_name("Ram");
        dto.setMobile_number("9876543210");
        dto.setUser_id(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(vehicleRepository.save(any())).thenReturn(vehicle);

        VehicleDto result = vehicleService.addVehicle(dto);

        assertNotNull(result);
        assertEquals("TN01AB1234", result.getVehicle_number());
    }

    @Test
    void getByUser_returnsVehicleList() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);
        vehicle.setVehicle_number("TN01AB1234");
        vehicle.setVehicle_Type("CAR");
        vehicle.setOwner_name("Ram");
        vehicle.setMobile_number("9876543210");

        User user = new User();
        user.setUser_id(1L);
        vehicle.setUser(user);

        when(vehicleRepository.findByUserUserId(1L)).thenReturn(List.of(vehicle));

        List<VehicleDto> result = vehicleService.getByUser(1L);

        assertFalse(result.isEmpty());
        assertEquals("TN01AB1234", result.get(0).getVehicle_number());
    }

    @Test
    void getById_vehicleNotFound_throwsException() {
        when(vehicleRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> vehicleService.getById(99L));
    }
}
