package tn.si2.projectsi2.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectCla {
    private static final Logger l = LogManager.getLogger(AspectCla.class);
    @Around("execution(* tn.si2.projectsi2.Services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        l.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
