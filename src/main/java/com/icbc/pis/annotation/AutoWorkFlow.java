
package com.icbc.pis.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWorkFlow {
	
	String description() default "";

}
