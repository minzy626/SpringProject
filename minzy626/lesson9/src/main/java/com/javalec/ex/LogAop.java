package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + " is start.");//공통기능 실행
		long st = System.currentTimeMillis();//현재시스템시간 구해오기
		
		try {
			Object obj = joinpoint.proceed();//핵심기능 실행
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));//핵심기능 실행후 실행
		}
		
	}
	
}
