package by.academypvt.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut(value = "execution(* by.academypvt.controller.OrderController.*(..))")
    public void logOrder() {
    }

    @Before(value = "logOrder()")
    public void beforeLogging() {
        log.info("Начало запроса из контроллера заказов (OrderController)");
    }

    @Around(value = "logOrder()")
    public Object loggingOrderController(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = null;
        try {
            log.info("Начат запрос из контроллера OrderController, Время: {}", LocalDateTime.now());
            object = joinPoint.proceed();
            log.info("Завершен запрос из контроллера OrderController , Время: {}", LocalDateTime.now());
        }
        catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return object;
    }

    @AfterThrowing(value = "logOrder()", throwing = "ex")
    public void afterLogging(Throwable ex) {
        log.error(ex.getMessage(), ex);
    }
}
