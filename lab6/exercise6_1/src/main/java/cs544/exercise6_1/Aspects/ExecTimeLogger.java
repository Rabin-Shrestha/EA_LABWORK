package cs544.exercise6_1.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

/**
 * Created by Rabin Shrestha on 8/1/2017.
 */
@Aspect
public class ExecTimeLogger {

@Around("execution(public * cs544.exercise6_1.*DAO.*(..))")
public  Object recordEcecutionTime(ProceedingJoinPoint method) throws Throwable
{
    StopWatch sw=new StopWatch("execTimeLoggerWatch");
    sw.start(method.toShortString());
    Object object=method.proceed();
    sw.stop();
    System.out.println("Time to run "+method.toShortString()+" is " + sw.getLastTaskTimeMillis());
    return object;

}
}
