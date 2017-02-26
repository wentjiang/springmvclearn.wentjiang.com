package com.wentjiang.springmvclearn.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.Date;

/**
 * Created by wentj on 2017/2/26.
 */
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditor() {
            @Override
            public void setValue(Object value) {

            }

            @Override
            public Object getValue() {
                return null;
            }

            @Override
            public boolean isPaintable() {
                return false;
            }

            @Override
            public void paintValue(Graphics gfx, Rectangle box) {

            }

            @Override
            public String getJavaInitializationString() {
                return null;
            }

            @Override
            public String getAsText() {
                return null;
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {

            }

            @Override
            public String[] getTags() {
                return new String[0];
            }

            @Override
            public Component getCustomEditor() {
                return null;
            }

            @Override
            public boolean supportsCustomEditor() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }
        });
    }
}
