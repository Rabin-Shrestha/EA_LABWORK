package cs544.exercise6_1.Aspects;

import cs544.exercise6_1.EmailSender;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Rabin Shrestha on 8/1/2017.
 */
@Aspect
public class LoggerAspect {

    @After("execution(public * cs544.exercise6_1.EmailSender.sendEmail(String,String))&& args(email,message)")
    public void messageLogger(JoinPoint joinPoint,String email,String message)
    {
       LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime.toString()+" Method name = "+joinPoint.getSignature().getName());
        System.out.println("email :"+email);
        System.out.println("message :"+message);
        // Creating class object from joinPoint : we can use whatever function we like here
        EmailSender emailSender =(EmailSender) joinPoint.getTarget();
        System.out.println("outgoing email service :"+emailSender.getOutgoingMailServer());
    }

}
