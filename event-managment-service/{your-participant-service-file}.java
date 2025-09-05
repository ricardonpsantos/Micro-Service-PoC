public List<ParticipantsResponseDto> getAllParticipants() {
    List<ParticipantsResponseDto> allParticipants = participantRepository.findAll().stream()
        .map(participantsMapper::roleEntityToResponseDTO)
        .toList();

    allParticipants.forEach(System.out::println);

    return allParticipants;
}
