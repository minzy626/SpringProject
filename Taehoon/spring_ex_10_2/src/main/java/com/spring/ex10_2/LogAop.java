package com.spring.ex10_2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

//	@Pointcut("execution(public void get*(..))")
//	@Pointcut("execution(* com.spring.ex10_2.*.*())")
//	@Pointcut("execution(* com.spring.ex10_2..*.*())")
//	@Pointcut("execution(* com.spring.ex10_2.Worker.*())")
//	
//	@Pointcut("within(com.spring.ex10_2.*)")
//	@Pointcut("within(com.spring.ex10_2..*)")
//	@Pointcut("within(com.spring.ex10_2.Worker)")
//	
//	@Pointcut("bean(student)")
	@Pointcut("bean(*ker)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " ����ð� : " + (et - st));
		}
		
	}
	
	@Before("pointcutMethod()")
	public void beforAdvice() {
		System.out.println("beforeAdvice()");
	}
}
