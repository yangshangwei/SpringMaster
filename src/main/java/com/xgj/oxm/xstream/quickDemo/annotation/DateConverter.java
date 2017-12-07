package com.xgj.oxm.xstream.quickDemo.annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class DateConverter implements SingleValueConverter {
	
	public DateConverter() {   
		
	}  
	
	public String toString(Object obj) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			dateFormat.setLenient(true);
			return dateFormat.format(((Date)obj));
		} catch (Exception e) {
			return null;
		}
	}

	public Object fromString(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			dateFormat.setLenient(true);
			return dateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	
	public boolean canConvert(Class type) {
		return type.equals(Date.class);
	}

}
