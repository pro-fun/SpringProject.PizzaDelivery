package by.academypvt.mapper;

import by.academypvt.domain.entity.Order;
import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.order.OrderResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T13:30:49+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setOrderTime( order.getOrderTime() );
        orderResponse.setState( order.getState() );
        orderResponse.setDeliveryType( order.getDeliveryType() );
        orderResponse.setCost( order.getCost() );

        return orderResponse;
    }

    @Override
    public Order toOrder(OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderTime( orderRequest.getOrderTime() );
        order.setState( orderRequest.getState() );
        order.setDeliveryType( orderRequest.getDeliveryType() );
        order.setCost( orderRequest.getCost() );

        return order;
    }
}
