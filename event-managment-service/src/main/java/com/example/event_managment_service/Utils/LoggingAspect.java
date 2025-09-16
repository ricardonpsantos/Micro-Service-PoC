/*package com.example.event_managment_service.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final ObjectMapper objectMapper; // injeta o do Spring

    // apanha todos os controllers REST, services e repositories
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void rest() {}
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void mvc() {}
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void svc() {}
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repo() {}

    @Around("rest() || mvc() || svc() || repo()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());
        String method = pjp.getSignature().toShortString();
        log.info("▶ {} args={}", method, toJsonSafe(pjp.getArgs()));
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable ex) {
            log.info("✖ {} ex={}", m    ethod, ex.toString(), ex);
            throw ex;
        }
        log.info("◀ {} result={}", method, toJsonSafe(result));
        return result;
    }

    private String toJsonSafe(Object o) {
        if (o == null) return "null";
        try {
            if (o.getClass().isArray()) return Arrays.toString((Object[]) o);
            return objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            return "<" + o.getClass().getName() + ">";
        }
    }
}


 */