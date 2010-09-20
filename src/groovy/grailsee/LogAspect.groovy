package grailsee

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint
import org.springframework.stereotype.Component;
import org.apache.log4j.*


@Aspect
@Component("logAspect")
public class LogAspect {
	def logger = Logger.getLogger("grailsee.LogAspect")
	
	@Pointcut("execution(@grailsee.Logr * *(..))")
	public void loggingOpperation() {}
	
	@AfterReturning(pointcut="grailsee.LogAspect.loggingOpperation()", returning="message")
	public void logr(String message) {
		logger.error message
		
	}
	
	@Before("loggingOpperation()")
	public void beforePrintMethods(JoinPoint joinPoint){
		logger.error "logger Before: " + joinPoint.getTarget()
 	}
	
	@After("loggingOpperation()")
	public void afterPrintMethods(JoinPoint joinPoint) {
		logger.error "logger After: " + joinPoint.getTarget()
		joinPoint.getArgs().each {
			logger.error "\t $it"
		}
	}
	
	void doSomething() {
		logger.error "aspect fired from doSomething method"
	}
	
}