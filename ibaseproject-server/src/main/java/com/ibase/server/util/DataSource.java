package com.ibase.server.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  
public @interface DataSource {
	DataSourceType dbType();
}

