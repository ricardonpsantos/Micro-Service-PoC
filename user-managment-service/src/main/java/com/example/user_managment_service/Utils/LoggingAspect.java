package com.example.user_managment_service.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    /*

    @Pointcut("execution(* com.example.user_managment_service.Controller..*(..)) || " +
            "execution(* com.example.user_managment_service.Service..*(..)) || " +
            "execution(* com.example.user_managment_service.Repository..*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void logMethodBefore(JoinPoint joinPoint) {
        List<String> args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).toList();
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        if (!joinPoint.getTarget().getClass().toString().contains("jdk")){
            logger.info(String.valueOf(args));
        }
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void logMethodAfterReturning(JoinPoint joinPoint, Object result) {

        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("AFTER RETURNING");
        // Log dos argumentos
        List<String> args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).toList();
        logger.info("Arguments: {}", args);

        // Log do retorno
        if (result != null) {
            logger.info("Returned: {}", result.toString());
        } else {
            logger.info("Returned: null");
        }
    }


     */

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Pointcut: apenas métodos das camadas Controller, Service e Repository
    @Pointcut("execution(* com.example.user_managment_service.Controller..*(..)) || " +
            "execution(* com.example.user_managment_service.Service..*(..)) || " +
            "execution(* com.example.user_managment_service.Repository..*(..))")
    public void appLayers() {
    }


    @Before("appLayers()")
    public void addRequestId() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String requestId = request.getHeader("X-Request-Id");
        if (requestId == null || requestId.isBlank()) {
            requestId = UUID.randomUUID().toString();
        }
        MDC.put("requestId", requestId);
    }

    @Before("appLayers()")
    public void logMethodBefore(JoinPoint joinPoint) throws JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String methodName = joinPoint.getSignature().toShortString();
        String argsJson = objectMapper.writeValueAsString(joinPoint.getArgs());
        logger.info("Before -> Method: {} | Args: {}", methodName, argsJson);
    }


    @AfterReturning(pointcut = "appLayers()", returning = "result")
    public void logMethodAfterReturning(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String methodName = joinPoint.getSignature().toShortString();

        String resultJson = result != null ? objectMapper.writeValueAsString(result) : "null";
        logger.info("After Returning -> Method: {} | Returned: {}", methodName, resultJson);
    }

    @After("appLayers()")
    public void clearMDC() {
        MDC.remove("requestId");
    }
}





