package by.academypvt.service.impl;

import by.academypvt.domain.entity.Position;
import by.academypvt.repository.PositionRepository;
import by.academypvt.service.PositionService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PositionServiceJpa implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public Position findPositionById(Long id) {
        return positionRepository.findPositionById(id);
    }

    @Override
    public void addPosition(Position position) {
        positionRepository.addPosition(position);
    }

    @Override
    public void deletePositionById(Long id) {
        positionRepository.deletePositionById(id);
    }

    @Override
    public List<Position> updatePositions() {
        return positionRepository.updatePositions();
    }
}
