package org.pussinboots.morning.cms.common.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.pussinboots.morning.cms.common.security.AuthorizingUser;
import org.pussinboots.morning.cms.common.util.ServletUtils;
import org.pussinboots.morning.common.annotation.SysLog;
import org.pussinboots.morning.system.entity.Log;
import org.pussinboots.morning.system.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
* 项目名称：morning-cms-web Maven Webapp   
* 类名称：SysLogAspect   
* 类描述：SysLogAspect 系统日记记录   
* 创建人：陈星星   
* 创建时间：2017年6月9日 上午10:47:15   
*
 */
@Aspect
@Component
public class SysLogAspect {
	
	private static final Logger LOGGER = LogManager.getLogger(SysLogAspect.class);
	
	/**
	 * 开始时间
	 */
	private long startTime = 0L;
	/**
	 * 结束时间
	 */
	private long endTime = 0L;
	
	@Autowired
	private ILogService logService;
	
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void cutController() {}
	
	@Before("cutController()")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		LOGGER.debug("doBeforeInServiceLayer");
		startTime = System.currentTimeMillis();
	}

	@After("cutController()")
	public void doAfterInServiceLayer(JoinPoint joinPoint) {
		LOGGER.debug("doAfterInServiceLayer");
	}
	
	@Around("cutController()")
	public Object recordSysLog(ProceedingJoinPoint joinPoint) throws Throwable {
		// 请求的方法名
		String strMethodName = joinPoint.getSignature().getName();
		// 请求的类名
		String strClassName = joinPoint.getTarget().getClass().getName();
		// 请求的参数
		Object[] params = joinPoint.getArgs();
		StringBuffer bfParams = new StringBuffer();
		Enumeration<String> paraNames = null;
		HttpServletRequest request = null;
		if (params != null && params.length > 0) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			paraNames = request.getParameterNames();
			String key;
			String value;
			while (paraNames.hasMoreElements()) {
				// 遍历请求参数
				key = paraNames.nextElement();
				value = request.getParameter(key);
				bfParams.append(key).append("=").append(value).append("&");
			}
			if (StringUtils.isBlank(bfParams)) {
				// 如果请求参数为空,返回url路径后面的查询字符串
				bfParams.append(request.getQueryString());
			}
		}

		String strMessage = String.format("[类名]:%s,[方法]:%s,[参数]:%s", strClassName, strMethodName, bfParams.toString());
		LOGGER.info(strMessage);

		// 环绕通知 ProceedingJoinPoint执行proceed方法的作用是让目标方法执行，这也是环绕通知和前置、后置通知方法的一个最大区别。
		Object result = joinPoint.proceed();
		endTime = System.currentTimeMillis();
		LOGGER.debug("doAround>>>result={},耗时：{}", result, endTime - startTime);

		// 判断是否需要日记记录
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if (syslog == null || syslog.isLog()) {
			Subject currentUser = SecurityUtils.getSubject();
			AuthorizingUser user = (AuthorizingUser) currentUser.getPrincipal();
			if (null != user) {
				Log sysLog = new Log();
				sysLog.setCreateTime(new Date());
				sysLog.setUserId(user.getUserId());
				sysLog.setOptContent(strMessage);
				sysLog.setUserIp(ServletUtils.getIpAddr());
				sysLog.setUrl(request.getRequestURI());
				sysLog.setMethod(request.getMethod());
				sysLog.setUserAgent(request.getHeader("User-Agent"));
				sysLog.setSpendTime((int) (endTime - startTime));
				logService.insert(sysLog);
			}
		}
		return result;
	}
}
