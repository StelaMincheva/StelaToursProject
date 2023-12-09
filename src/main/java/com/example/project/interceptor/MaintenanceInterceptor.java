package com.example.project.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalTime;

@Component
public class MaintenanceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        LocalTime timeNow = LocalTime.now();
        if(timeNow.isAfter(LocalTime.of(23, 59)) && timeNow.isBefore(LocalTime.of(0, 30))) {
            String requestUrl = request.getRequestURL().toString();

            if (!requestUrl.endsWith("/maintenance")) {
                response.sendRedirect("/maintenance");
                return false;
            }
        }
            return true;
    }
}
