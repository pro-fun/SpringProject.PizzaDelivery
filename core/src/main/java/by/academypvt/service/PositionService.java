package by.academypvt.service;

import by.academypvt.domain.entity.Position;
import java.util.List;

public interface PositionService {
    Position findPositionById(Long id);
    void addPosition(Position position);
    void deletePositionById(Long id);
    List<Position> updatePositions();
}
