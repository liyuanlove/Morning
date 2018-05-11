package org.pussinboots.morning.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* 项目名称：morning-common   
* 类名称：SysLog   
* 类描述：SysLog 系统日志注解   
* 创建人：陈星星   
* 创建时间：2017年6月9日 上午11:01:40   
*
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	boolean isLog() default true;
	
}
