package com.xgj.oxm.xstream.quickDemo.convert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {

	private Locale locale;

	public DateConverter(Locale locale) {
		super();
		this.locale = locale;
	}

	/**
	 * 重写该方法，判断需要转换的类型
	 */
	@Override
	public boolean canConvert(Class type) {
		return Date.class.isAssignableFrom(type);
	}

	/**
	 * 重写该方法，编写Java 到 XML 的转换逻辑
	 */
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		
		// DateFormat format = DateFormat.getDateInstance(DateFormat.DATE_FIELD,
		// this.locale);
		
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", this.locale);

		writer.setValue(format.format(source));

	}

	/**
	 * 重写该方法，编写XML 到 Java 的转换逻辑
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {

		GregorianCalendar calendar = new GregorianCalendar();

		// DateFormat format = DateFormat.getDateInstance(DateFormat.DATE_FIELD,
		// this.locale);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				this.locale);

		try {
			calendar.setTime(format.parse(reader.getValue()));
		} catch (Exception e) {
			throw new ConversionException(e.getMessage(), e);
		}

		return calendar.getGregorianChange();
	}

}
