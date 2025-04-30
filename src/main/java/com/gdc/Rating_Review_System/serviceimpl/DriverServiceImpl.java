package com.gdc.Rating_Review_System.serviceimpl;
import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Mapper.DriverMapper;
import com.gdc.Rating_Review_System.Repository.DriverRepository;
import com.gdc.Rating_Review_System.Repository.UserRepository;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final UserRepository userRepository;

    @Override
    public DriverResponseDTO createDriver(DriverRequestDTO requestDTO) {
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + requestDTO.getUserId()));

        Driver driver = DriverMapper.toEntity(requestDTO, user);
        Driver savedDriver = driverRepository.save(driver);
        return DriverMapper.toDTO(savedDriver);
    }

    @Override
    public DriverResponseDTO getDriverById(UUID id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with ID: " + id));
        return DriverMapper.toDTO(driver);
    }
}
