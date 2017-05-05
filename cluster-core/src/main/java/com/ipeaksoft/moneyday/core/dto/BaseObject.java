package com.ipeaksoft.moneyday.core.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class BaseObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE, false);
	}
}
