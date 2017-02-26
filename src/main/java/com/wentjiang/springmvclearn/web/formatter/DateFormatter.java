package com.wentjiang.springmvclearn.web.formatter;


import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wentj on 2017/2/26.
 */
public class DateFormatter implements Formatter<Date> {
    private String datePattern = "MM-dd-yyyy";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return simpleDateFormat.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return simpleDateFormat.format(date);
    }
}
