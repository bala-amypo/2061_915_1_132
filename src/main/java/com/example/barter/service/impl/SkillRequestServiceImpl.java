@Override
public SkillRequest createRequest(SkillRequest request) {
    if (request == null) throw new ResourceNotFoundException("Request not found"); // [cite: 87, 105]
    if (request.getSkillName() == null || request.getSkillName().length() < 5) {
        throw new BadRequestException("Skill name must be at least 5 characters"); // [cite: 78, 105]
    }
    return requestRepository.save(request); // 
}