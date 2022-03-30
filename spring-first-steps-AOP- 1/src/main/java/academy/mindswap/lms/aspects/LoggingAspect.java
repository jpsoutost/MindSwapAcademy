package academy.mindswap.lms.aspects;

import academy.mindswap.lms.commands.UserDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Optional;

@Aspect
@Component
public class LoggingAspect {


    @Pointcut("@annotation( academy.mindswap.lms.annotations.MindswapAnnotation)")
    public void mindswapAnnotation() {
    }

    /*@Around("mindswapAnnotation()")
    public Object logAroundAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("MindswapAnnotation - Around Before:" + proceedingJoinPoint.getSignature());
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        System.out.println("MindswapAnnotation - Around After:" + proceedingJoinPoint.getSignature());
        return result;
    }*/




   /* @Around(value="execution(* academy.mindswap.lms.services.*Service.getUserById(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around Before:" + proceedingJoinPoint.getSignature());
        Object result;
        try {
             result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        System.out.println("Around After:" + proceedingJoinPoint.getSignature());
        return result;
    }


    @Before(value="execution(*..*List<*..*UserDto> *.mindswap.lms.services.*Service.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before:" + joinPoint.getSignature());
    }

    @After(value="execution(* academy.mindswap.lms.services.*Service.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After:" + joinPoint.getSignature());
    }*/

    @AfterReturning(value="mindswapAnnotation()", returning="result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        File file = new File("src/main/resources/log.txt");

        try {
            file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.write(String.valueOf(LocalTime.now()) + " " + joinPoint.getSignature() + " " + result + "\n");
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    @AfterThrowing(value="mindswapAnnotation()", throwing="ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        File file = new File("src/main/resources/log.txt");

        try {
            file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.write(String.valueOf(LocalTime.now()) + " " + joinPoint.getSignature() + " " + ex.getClass() + " " + ex.getMessage() + "\n");
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
