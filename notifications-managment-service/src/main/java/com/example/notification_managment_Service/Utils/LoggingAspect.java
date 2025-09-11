/*package com.example.notification_managment_Service.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@within(org.springframework.stereotype.Service) || "
            + "@annotation(org.springframework.web.bind.annotation.GetMapping) || "
            + "@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        // Correlation ID

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String correlationId = UUID.randomUUID().toString();
        MDC.put("correlationId", correlationId);
        MDC.put("method", className + "." + methodName);

        // Logger dinâmico baseado na classe alvo
        Logger targetLogger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        // Serializar argumentos para JSON
        String jsonArgs;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonArgs = mapper.writeValueAsString(joinPoint.getArgs());
        } catch (JsonProcessingException e) {
            jsonArgs = "[Erro ao serializar argumentos]";
        }

        long start = System.currentTimeMillis();
        targetLogger.info("➡️ Start {}.{} with args {}", className, methodName, jsonArgs);

        Object result = joinPoint.proceed();

        try {
            jsonArgs = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            jsonArgs = "[Erro ao serializar argumentos]";
        }
        long elapsed = System.currentTimeMillis() - start;
        targetLogger.info("⬅️ End {}.{} with result {} ({} ms)", className, methodName, jsonArgs, elapsed);

        MDC.remove("correlationId");
        return result;
    }
}


 */