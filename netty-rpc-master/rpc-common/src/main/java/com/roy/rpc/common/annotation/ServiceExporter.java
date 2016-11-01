package com.roy.rpc.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation for service provider.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ServiceExporter {
	// 服务发现用的唯一标识，用于服务自动寻址
	String value() default "";

	// 防止实现类实现了多个接口
	Class<?> targetInterface();

	String debugAddress() default "";
}
