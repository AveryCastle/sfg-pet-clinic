package practice.springframework.sfgpetclinic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class Performance {

    @Around("execution(* practice.springframework.sfgpetclinic.services.*.*(*))")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long finish = System.currentTimeMillis();
            System.out.println(String.format("running time (%d)", finish - start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
