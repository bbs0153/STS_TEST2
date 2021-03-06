package com.bit.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BitAdvice {
	
	@Pointcut("execution(public * com.bit.dao..*(..))")
	private void daoPointCut(){}
	
	@Around("daoPointCut()")
	public Object pro(ProceedingJoinPoint joinPoint) throws Throwable {

		Object obj = null;

		String methoName = joinPoint.getSignature().toShortString();
		System.out.println(methoName + "시작");
		long start = System.currentTimeMillis();

		obj = joinPoint.proceed();

		System.out.println(methoName + "종료");
		long end = System.currentTimeMillis();
		System.out.println("걸린시간: " + (end - start));
		return obj;

	}

}
