package com.wentjiang.springmvclearn.factory;

/**
 * Created by wentj on 2017/2/27.
 */
public class Test {
    public static void main(String[] args) {
        Displacement displacement = new Displacement2();
        FactoryInterface factory = new CarFactory(displacement);
        Compartment2 compartment2 = factory.createCompartment2();
        compartment2.show();
        compartment2.displacement();

        Compartment3 compartment3 = factory.createCompartment3();
        compartment3.show();
        compartment3.displacement();
    }
}
