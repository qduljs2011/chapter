package com.baobaotao.study.stream;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter{
	private Locale locale;
	public DateConverter(Locale locale){
		super();
		this.locale=locale;
	}
	
	@Override
	public boolean canConvert(Class type) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		DateFormat formatter=DateFormat.getDateInstance(DateFormat.DATE_FIELD, this.locale);
		writer.setValue(formatter.format(source));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		GregorianCalendar calendar=new GregorianCalendar();
		DateFormat formatter=DateFormat.getDateInstance(DateFormat.DATE_FIELD, this.locale);
		try {
			calendar.setTime(formatter.parse(reader.getValue()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ConversionException(e.getMessage(), e);
		}
		return calendar.getGregorianChange();
	}

}
