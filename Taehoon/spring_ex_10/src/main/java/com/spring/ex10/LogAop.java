package com.spring.ex10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

	/*
	@Pointcut("within(com.spring.ex10.*)")
	private void pointcutMethod() {
	}
	*/
	
	//@Around("pointcutMethod()")
	
	@Around("within(com.spring.ex10.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		String signaturStr = joinpoint.getSignature().toShortString();
		System.out.println(signaturStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signaturStr + " is finished");
			System.out.println(signaturStr + " 경과시간 : " + (et - st));
		}
	
	}
	
	@Before("within(com.spring.ex10.*)")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}
}
