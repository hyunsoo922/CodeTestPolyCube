package kr.co.polycube.backendtest;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    private final HttpServletRequest httpServletRequest;

    public UserAspect(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Before("execution(* kr.co.polycube.backendtest.UserController.*(..))")
    public void log(JoinPoint joinPoint)
    {
        String clientAgent = httpServletRequest.getHeader("Client-Agent");
        System.out.println("Client-Agent "+clientAgent);
    }
}
