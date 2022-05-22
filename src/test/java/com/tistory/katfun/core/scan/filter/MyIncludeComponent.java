package com.tistory.katfun.core.scan.filter;

import net.bytebuddy.matcher.ElementMatcher;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
