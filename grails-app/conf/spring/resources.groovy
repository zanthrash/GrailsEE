import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator

beans = {
	
/*	autoProxyCreator(AnnotationAwareAspectJAutoProxyCreator) {
		proxyTargetClass = true
	}*/
	

		
	xmlns aop:"http://www.springframework.org/schema/aop"
	
	logrAspect(grailsee.LogAspect)
	
	springMonitoringAspectInterceptor(org.springframework.aop.interceptor.PerformanceMonitorInterceptor, true){
		loggerName = "grailsee.traceLogger"
	}
	
	testAspect(grailsee.LogAspect)
	
	aop {
		config("proxy-target-class":true) {
			pointcut(id:"springMonitoringPointcut", expression:"execution(* grailsee..*.*(..))")
			aspect( id : 'tester', ref: "testAspect") {
				after method: "doSomething", "pointcut-ref":"springMonitoringPointcut"
			}
			
			advisor( 'pointcut-ref': "springMonitoringPointcut", 'advice-ref':"springMonitoringAspectInterceptor") 
		}
	}

	
}