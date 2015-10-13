package koreatech.cse.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class AopTester {
    @Before("execution(* koreatech.cse.service.UserService.signup(..))") //포인트컷
    public void beforeMethod(JoinPoint joinPoint) { //어드바이스
        System.out.println("Before " + joinPoint.getSignature().getName() + ": " + new Date());
    }

    @After("execution(* koreatech.cse.service.UserService.signup(..))")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("After " + joinPoint.getSignature().getName() + ": " + new Date());
    }

    @AfterReturning(pointcut = "execution(* koreatech.cse.service.UserService.signup(..))",
            returning= "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning " + joinPoint.getSignature().getName()
                + ": " + new Date() + ", Value = " + result);
    }

    @AfterReturning(pointcut = "execution(* koreatech.cse.service.UserService.delete(..))",
            returning= "result")
    public void afterDelete(JoinPoint joinPoint, Object result) {
        System.out.println("After Delete " + joinPoint.getSignature().getName()
                + ": " + new Date() + ", Value = " + result);
    }
}