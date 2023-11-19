package by.academypvt.mapper;

import by.academypvt.domain.entity.SauceOrder;
import by.academypvt.dto.order.SauceOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SauceOrderMapper {
    SauceMapper sauceMapper = new SauceMapperImpl();
    public SauceOrderResponse toResponse(SauceOrder sauceOrder) {
        SauceOrderResponse sauceOrderResponse = new SauceOrderResponse();
        sauceOrderResponse.setSauce(sauceMapper.toResponse(sauceOrder.getSauce()));
        sauceOrderResponse.setCount(sauceOrder.getCount());
        return sauceOrderResponse;
    }
}
