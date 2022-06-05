package org.cnc.garden.cloud.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * org.cnc.garden.cloud.web.annotation - User
 *
 * @author tony-is-coding
 * @date 2022/6/5 20:43
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface User {
}
