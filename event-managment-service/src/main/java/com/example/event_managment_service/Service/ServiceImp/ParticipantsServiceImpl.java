package com.example.event_managment_service.Service.ServiceImp;

import com.example.event_managment_service.Controller.Dto.Response.ParticipantsResponseDto;
import com.example.event_managment_service.Service.ParticipantsService;
import com.example.event_managment_service.mapper.ParticipantsMapper;
import com.example.event_managment_service.repository.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {
    private static final Logger logger = LoggerFactory.getLogger(ParticipantsServiceImpl.class);
    private final ParticipantRepository participantRepository;
    private final ParticipantsMapper participantsMapper;

    public ParticipantsServiceImpl(ParticipantRepository participantRepository, ParticipantsMapper participantsMapper) {
        this.participantRepository = participantRepository;
        this.participantsMapper = participantsMapper;
    }

    public List<ParticipantsResponseDto> getAllParticipants() {
        List<ParticipantsResponseDto> allParticipants = participantRepository.
                findAll()
                .stream()
                .filter(s -> !s.getName().isBlank())
                .map(participantsMapper::roleEntityToResponseDTO)
                .toList();

        return allParticipants;
    }
}
