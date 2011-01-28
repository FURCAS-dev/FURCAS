package com.sap.furcas.emf.stubs;

import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;

/**
 *
 */
public class ForcedLowerPArgStub extends PargStub implements ForcedLowerPArg {

    private final int value;

    public ForcedLowerPArgStub(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(Integer value) {
        // TODO Auto-generated method stub

    }
}