package com.wentjiang.springmvclearn.factory;

import lombok.Setter;

/**
 * Created by wentj on 2017/2/27.
 */
public class Car2 implements Compartment2 {

    @Setter
    private Displacement displacement;

    public Car2() {
    }

    public Car2(Displacement displacement) {
        this.displacement = displacement;
    }

    @Override
    public void show() {
        System.out.println("两厢车");
    }

    @Override
    public void displacement() {
        if (displacement != null){
            displacement.showDisplacement();
        }else {
            System.out.println("no displacement");
        }
    }


}
