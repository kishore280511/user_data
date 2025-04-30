package com.gdc.Rating_Review_System.Repository;
import com.gdc.Rating_Review_System.Entitys.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    boolean existsByLicenseNumber(String licenseNumber);
    boolean existsByVehicleNumber(String vehicleNumber);
}