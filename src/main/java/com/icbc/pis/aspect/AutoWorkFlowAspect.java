package com.icbc.pis.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jbpm.api.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icbc.pis.workflow.service.ExecutionServiceProxy;
import org.springframework.web.context.request.RequestContextHolder;  
import org.springframework.web.context.request.ServletRequestAttributes; 
@Aspect
@Component("AutoWorkFlowAspect")  
public class AutoWorkFlowAspect {
	
	@Autowired 
	private ExecutionServiceProxy executionServiceProxy;
	
    @Pointcut("@annotation(com.icbc.pis.annotation.AutoWorkFlow)")  
    public void WorkFlowAspect() {
    	
    }   
    
    @Before(" WorkFlowAspect()")
    public void doBefore(JoinPoint joinPoint){
    	System.out.println("=====前置通知开始=====");  
    }
    
    @After(" WorkFlowAspect()")
    public void doAfter(JoinPoint joinPoint){
    	
    	System.out.println("=====work flow engine proceed next step=====");  
    	
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String taskId = request.getParameter("WKF_TASK_ID");
    	String productId = request.getParameter("WKF_RPODUCT_ID");
    	System.out.println("=====WorkFlowAspect : " + taskId ); 
    	this.executionServiceProxy.Proceed("before_invest", productId,taskId);
    	
    
    }
    
    @AfterReturning(pointcut = " WorkFlowAspect()", returning = "result")  
    public void doAfterReturning(String result) {  
        System.out.println("=====后置通知=====");  
        System.out.println("---" + result + "---");  
    }  

    @AfterThrowing(pointcut = "WorkFlowAspect()", throwing = "e")  
    public void doAfterThrowing(Exception e) {  
        System.out.println("=====例外通知=====");  
        System.out.println(e.getMessage());  
    }  
    
}
