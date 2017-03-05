package com.wentjiang.springmvclearn.factory;

import lombok.Setter;

/**
 * Created by wentj on 2017/2/27.
 */
public class Car3 implements Compartment3 {

    @Setter
    private Displacement displacement;

    public Car3() {
    }

    public Car3(Displacement displacement) {
        this.displacement = displacement;
    }

    @Override
    public void show() {
        System.out.println("三厢车");
    }

    @Override
    public void displacement() {
        if (displacement != null) {
            displacement.showDisplacement();
        } else {
            System.out.println("no displacement");
        }
    }
}
