package com.wentjiang.springmvclearn.service.impl;

import com.wentjiang.springmvclearn.service.IndexService;
import org.springframework.stereotype.Service;

/**
 * Created by wentj on 2017/2/25.
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public void index() {
        System.out.println("hello world");
    }
}
