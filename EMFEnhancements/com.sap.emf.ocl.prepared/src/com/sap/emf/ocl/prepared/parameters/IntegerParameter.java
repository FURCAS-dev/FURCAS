package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.ocl.ecore.IntegerLiteralExp;

public class IntegerParameter implements Parameter<Integer> {
    private IntegerLiteralExp param;

    public IntegerParameter(IntegerLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(Integer object) {
        setInteger((Integer) object);
    }

    private void setInteger(int i) {
        param.setIntegerSymbol(i);
    }

    public IntegerLiteralExp getLiteralExp() {
        return param;
    }

    public Integer get() {
        return param.getIntegerSymbol();
    }
}
