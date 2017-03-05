package com.wentjiang.springmvclearn.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wentj on 2017/3/5.
 */
public class LoggerTest {



    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        logger.info("hahahah");
    }
}
