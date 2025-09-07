package com.example.user_managment_service.Config.mdc;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;


public class MdcInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final var header = request.getHeader("requestId");
        MDC.put("requestId",
                header != null && !header.isEmpty() ? header : getUuid());
        return true;
    }

    public String getUuid(){
        return UUID.randomUUID().toString();
    }
}
