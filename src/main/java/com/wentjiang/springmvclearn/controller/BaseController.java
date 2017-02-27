package com.wentjiang.springmvclearn.controller;

import com.wentjiang.springmvclearn.web.editor.DateTimeEditor;
import com.wentjiang.springmvclearn.web.editor.TimestampEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wentj on 2017/2/26.
 */
public class BaseController {

    protected static final String REDIRECT = "redirect:";
    protected static final String FORWARD = "forward:";

    private static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_FORMATTER_2 = "yyyy-MM-dd HH:mm";
    private static final String DATE_FORMATTER = "yyyy-MM-dd";

    String redirectTo(String url) {
        return REDIRECT + url;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        // date time editor
        SimpleDateFormat datetimeFormat = new SimpleDateFormat(DATE_TIME_FORMATTER);
        datetimeFormat.setLenient(false);
        SimpleDateFormat datetimeFormat2 = new SimpleDateFormat(DATE_TIME_FORMATTER_2);
        datetimeFormat2.setLenient(false);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTER);
        dateFormat.setLenient(false);

        List<SimpleDateFormat> formatters = new ArrayList<>();
        formatters.add(datetimeFormat);
        formatters.add(datetimeFormat2);
        formatters.add(dateFormat);

        binder.registerCustomEditor(Date.class, new DateTimeEditor(formatters, true));
        binder.registerCustomEditor(Timestamp.class, new TimestampEditor(formatters, true));

    }
}
