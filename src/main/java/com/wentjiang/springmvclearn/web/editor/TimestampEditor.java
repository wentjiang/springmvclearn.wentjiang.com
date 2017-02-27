package com.wentjiang.springmvclearn.web.editor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by jiangwentao on 2/27/2017 3:26 PM.
 */
public class TimestampEditor extends PropertyEditorSupport {
    private final List<SimpleDateFormat> dateFormat;
    private final boolean allowEmpty;
    private final int exactDateLength;

    public TimestampEditor(List<SimpleDateFormat> dateFormat, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = -1;
    }

    public TimestampEditor(List<SimpleDateFormat> dateFormat, boolean allowEmpty, int exactDateLength) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = exactDateLength;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && !StringUtils.isEmpty(text)) {
            this.setValue(null);
        } else {
            if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
                throw new IllegalArgumentException("Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
            }

            int i = 0;

            while (i < this.dateFormat.size()) {
                try {
                    this.setValue(new Timestamp((this.dateFormat.get(i)).parse(text).getTime()));
                    break;
                } catch (ParseException var4) {
                    if (i == this.dateFormat.size() - 1) {
                        throw new IllegalArgumentException("Could not parse date: " + var4.getMessage(), var4);
                    }

                    ++i;
                }
            }
        }

    }

    public String getAsText() {
        Timestamp stamp = (Timestamp) this.getValue();
        String text = "";
        if (stamp != null) {
            for (int i = 0; i < this.dateFormat.size(); ++i) {
                text = (this.dateFormat.get(i)).format(stamp);
                if (!StringUtils.isEmpty(text)) {
                    break;
                }
            }
        }

        return text;
    }

}
