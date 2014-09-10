package demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MySecondAspect {
	Log log = LogFactory.getLog(MySecondAspect.class);

	@Around("(execution(* demo.MyClass.foo(..)))  ")
	public Object integrate(final ProceedingJoinPoint pjp/*
														 * , MyAnnotation
														 * myAnnotation
														 */) throws Throwable {
		log.debug("before *****:" + pjp.getSignature());
		Object res = pjp.proceed();
		log.debug("after *****:" + pjp.getSignature());
		return res;
	}
}
