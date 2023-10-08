package by.academypvt.repository;

import by.academypvt.domain.entity.Position;


import java.util.List;

public interface PositionRepository {
    Position findPositionById(Long id);
    void addPosition(Position position);
    void deletePositionById(Long id);
    List<Position> updatePositions();
}
