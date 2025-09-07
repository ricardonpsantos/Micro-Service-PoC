package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Response.ClimbingRoutes.ClimbingRouteResponseDto;
import com.example.event_managment_service.Exception.NotFoundException;
import com.example.event_managment_service.Service.ClimbingRouteService;
import com.example.event_managment_service.mapper.ClimbingRoutesMapper;
import com.example.event_managment_service.repository.ClimbingRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimbingRouteServiceImpl implements ClimbingRouteService {

    private final ClimbingRouteRepository climbingRouteRepository;
    private final ClimbingRoutesMapper climbingRoutesMapper;

    public ClimbingRouteServiceImpl(ClimbingRouteRepository climbingRouteRepository, ClimbingRoutesMapper climbingRoutesMapper) {
        this.climbingRouteRepository = climbingRouteRepository;
        this.climbingRoutesMapper = climbingRoutesMapper;
    }

    @Override
    public List<ClimbingRouteResponseDto> getAllClimbingRoutes() {
        List<ClimbingRouteResponseDto> climbingRouteResponseDtoList = climbingRouteRepository.findAll()
                .stream()
                .map(climbingRoutesMapper::entityToResponseDto)
                .toList();

        if (climbingRouteResponseDtoList.isEmpty()) {
            throw new NotFoundException("Climbing routes not found");
        }
        return climbingRouteResponseDtoList;
    }
}
