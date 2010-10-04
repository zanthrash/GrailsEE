import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator

beans = {
	
/*	autoProxyCreator(AnnotationAwareAspectJAutoProxyCreator) {
		proxyTargetClass = true
	}*/
	

		
	xmlns aop:"http://www.springframework.org/schema/aop"
	
	logrAspect(grailsee.LogAspect)
	
		
	
	testAspect(grailsee.LogAspect)
	

	
	aop {
		config("proxy-target-class":false) {
			pointcut(id:"interceptorPointcut", expression:"execution(* grailsee..*Service.*(..))")
		
			//aspect( id : 'tester', ref: "testAspect") {
			//	after method: "doSomething", "pointcut-ref":"interceptorPointcut"
			//}
			

			advisor( 'pointcut-ref': "interceptorPointcut", 'advice-ref':"concurrencyThrottleInterceptor") 
		}
	}
	
	preformanceMonitoringInterceptorAdvice(org.springframework.aop.interceptor.PerformanceMonitorInterceptor, true){
		loggerName = "grailsee.performanceMonitor"
	}
	
	simpleTraceInterceptorAdvice(org.springframework.aop.interceptor.SimpleTraceInterceptor) {
		loggerName = "grailsee.SimpleTraceInterceptor"
	}
	
	concurrencyThrottleInterceptor(org.springframework.aop.interceptor.ConcurrencyThrottleInterceptor) {
		concurrencyLimit = 2
	}

	
}