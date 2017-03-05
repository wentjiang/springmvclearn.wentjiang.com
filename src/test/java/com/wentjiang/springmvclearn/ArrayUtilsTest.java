package com.wentjiang.springmvclearn;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by wentj on 2017/3/5.
 */
public class ArrayUtilsTest {
    @org.junit.Test
    public void cloneTest(){
        //用于保护性拷贝
        int[] array1 = {1,2,3};
        int[] array2 = ArrayUtils.clone(array1);
        System.out.println(array2.toString());
        System.out.println(Arrays.toString(array2));
        array2[0] = 0;
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    @org.junit.Test
    public void getComponentTypeTest(){
        String str = "hahha";
        Date date = new Date();
        System.out.println(date.getClass().getComponentType());
    }
}
