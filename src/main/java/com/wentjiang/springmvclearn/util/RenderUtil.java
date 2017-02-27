package com.wentjiang.springmvclearn.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by jiangwentao on 2/27/2017 3:32 PM.
 * 直接返回工具
 */
@Slf4j
public class RenderUtil {
    //header 常量定义
    private static final String ENCODING_PREFIX = "encoding";
    private static final String NOCACHE_PREFIX = "no-cache";
    private static final String ENCODING_DEFAULT = "UTF-8";
    private static final boolean NOCACHE_DEFAULT = true;

    /**
     * 直接输出内容的简便函数.

     * eg.
     * render("text/plain", "hello", "encoding:GBK");
     * render("text/plain", "hello", "no-cache:false");
     * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
     *
     * @param headers 可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
     */
    public static void render(HttpServletResponse response, final String contentType, final String content, final String... headers) {
        try {
            //分析headers参数
            String encoding = ENCODING_DEFAULT;
            boolean noCache = NOCACHE_DEFAULT;
            for (String header : headers) {
                String headerName = StringUtils.substringBefore(header, ":");
                String headerValue = StringUtils.substringAfter(header, ":");

                if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
                    encoding = headerValue;
                } else if (StringUtils.equalsIgnoreCase(headerName, NOCACHE_PREFIX)) {
                    noCache = Boolean.parseBoolean(headerValue);
                } else
                    throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
            }
            //设置headers参数
            String fullContentType = contentType + ";charset=" + encoding;
            response.setContentType(fullContentType);
            if (noCache) {
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
            }

            response.getWriter().write(content);
            response.getWriter().flush();

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 直接输出文本.
     */
    public static void renderText(HttpServletResponse response,final String text, final String... headers) {
        render(response,"text/plain", text, headers);
    }

    /**
     * 直接输出Error文本.
     */
    public static void renderError(HttpServletResponse response,final String text, final String... headers) {
        render(response,"text/plain", "{'error':'" + text + "'}", headers);
    }

    /**
     * 直接输出HTML.
     */
    public static void renderHtml(HttpServletResponse response,final String html, final String... headers) {
        render(response,"text/html", html, headers);
    }

    /**
     * 直接输出XML.
     */
    public static void renderXml(HttpServletResponse response,final String xml, final String... headers) {
        render(response,"text/xml", xml, headers);
    }

    /**
     * 直接输出JSON.
     *
     * @param string json字符串.
     */
    public static void renderJson(HttpServletResponse response,final String string, final String... headers) {
        render(response,"application/json", string, headers);
    }

    /**
     * 直接输出JSON.
     *
     * @param map Map对象,将被转化为json字符串.
     */
    public static void renderJson(HttpServletResponse response, final Map map, final String... headers) {
        String jsonString = JSONObject.toJSONString(map);
        renderJson(response,jsonString, headers);
    }
}
