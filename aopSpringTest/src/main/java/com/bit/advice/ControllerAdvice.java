package com.bit.advice;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.bit.db.ExceptionManager;

@Aspect
public class ControllerAdvice {
   
   @Pointcut("execution(public * com.bit.aopspring..*(..))")
   public void cAdvice() {}
   
   //타깃이 되는 메소드가 비정상적으로 종료 되었을때 동작하는 어드바이스
   @AfterThrowing(pointcut="cAdvice()",throwing="ex")
   public void afterThrowing(JoinPoint joinPoint, Throwable ex)
   {
      String svname="";
      String extype = ex.getMessage();
      Object []objs = joinPoint.getArgs();
      for(Object obj : objs)
      {
         if( obj instanceof HttpServletRequest)
         {
            svname = ((HttpServletRequest)obj).getRequestURI();
         }
      }
      System.out.println("어드바이스 동작함");
      System.out.println("서비스명:"+svname);
      System.out.println("예외종류:"+extype);
      
      Map map = new HashMap();
      map.put("svname", svname);
      map.put("extype", extype);
      
      ExceptionManager.insert(map);
   }
   
//   @Before("cAdvice()")
//   public void before(JoinPoint joinPoint)
//   {
//      String svname="";
//      Object []objs = joinPoint.getArgs();
//      for(Object obj : objs)
//      {
//         if( obj instanceof HttpServletRequest)
//         {
//            svname = ((HttpServletRequest)obj).getRequestURI();
//         }
//      }
//      System.out.println("어드바이스 동작하였습니다.");
//      System.out.println("서비스명"+svname);
//   }
   

}