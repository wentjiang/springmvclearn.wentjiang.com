package com.wentjiang.springmvclearn.factory;

import lombok.Setter;

/**
 * Created by wentj on 2017/2/27.
 */
public class CarFactory implements FactoryInterface {

    @Setter
    private Displacement displacement;

    public CarFactory(Displacement displacement) {
        this.displacement = displacement;
    }

    @Override
    public Compartment2 createCompartment2() {
        return new Car2(displacement);
    }

    @Override
    public Compartment3 createCompartment3() {
        return new Car3(displacement);
    }
}
