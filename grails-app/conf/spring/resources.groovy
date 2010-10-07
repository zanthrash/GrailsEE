import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator

beans = {

	xmlns aop:"http://www.springframework.org/schema/aop"
	
	logrAspect(grailsee.LogAspect)
	testAspect(grailsee.LogAspect)
	
	aop {
		config("proxy-target-class":true) {
			pointcut(id:"interceptorPointcut", expression:"execution(* grailsee.*Service.*(..))")
			advisor( 'pointcut-ref': "interceptorPointcut", 'advice-ref':"debugInterceptorAdvice") 
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

	debugInterceptorAdvice(org.springframework.aop.interceptor.DebugInterceptor)
	
}