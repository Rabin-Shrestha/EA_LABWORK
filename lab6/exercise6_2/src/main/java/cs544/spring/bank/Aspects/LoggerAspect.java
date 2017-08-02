package cs544.spring.bank.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

/**
 * Created by Rabin Shrestha on 8/1/2017.
 */
@Aspect
public class LoggerAspect {
    @After("execution(public * cs544.spring.bank.dao.*.*(..))")
    public void methodLogger(JoinPoint joinPoint)
    {
        System.out.println(LocalDateTime.now().toString()+" : Method called => "+joinPoint.getSignature().getName());

    }
    @Around("execution(public * cs544.spring.bank.service.*.*(..))")
    public Object execTimeLogger(ProceedingJoinPoint joinPoint) throws Throwable
    {
        StopWatch sw=new StopWatch("serviceMethodsWatcher");
        sw.start(joinPoint.toShortString());
        Object result=joinPoint.proceed();
        sw.stop();
        System.out.println("Total execution time of method "+joinPoint.getSignature().getName().toString()+" is ==> "+sw.getLastTaskTimeMillis()+" ms");
        return result;

    }
    @After("execution(public * cs544.spring.bank.jms.JMSSender.sendJMSMessage(String)) && args(msg)")
    public void jmsLogger(JoinPoint joinPoint,String msg)
    {
        System.out.println("The message is : ==> "+msg);
    }
}
