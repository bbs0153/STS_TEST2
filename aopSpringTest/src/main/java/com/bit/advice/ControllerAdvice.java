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
   
   //Ÿ���� �Ǵ� �޼ҵ尡 ������������ ���� �Ǿ����� �����ϴ� �����̽�
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
      System.out.println("�����̽� ������");
      System.out.println("���񽺸�:"+svname);
      System.out.println("��������:"+extype);
      
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
//      System.out.println("�����̽� �����Ͽ����ϴ�.");
//      System.out.println("���񽺸�"+svname);
//   }
   

}