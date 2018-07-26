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
		System.out.println(methoName + "����");
		long start = System.currentTimeMillis();

		obj = joinPoint.proceed();

		System.out.println(methoName + "����");
		long end = System.currentTimeMillis();
		System.out.println("�ɸ��ð�: " + (end - start));
		return obj;

	}

}
