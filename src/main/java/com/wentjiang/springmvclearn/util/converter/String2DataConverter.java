package com.wentjiang.springmvclearn.util.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wentj on 2017/2/25.
 */
public class String2DataConverter implements Converter<String, Date> {
    private String datePattern = "MM-dd-yyyy";

    public String2DataConverter() {
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date format");
        }
    }
}
