package by.academypvt.mapper;

import by.academypvt.domain.entity.Sauce;
import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SauceMapper {
    SauceResponse toResponse(Sauce sauce);
    Sauce toEntity(SauceRequest sauceRequest);
}
