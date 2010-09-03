package com.sap.emf.ocl.prepared;

import org.eclipse.ocl.ecore.IntegerLiteralExp;

public class IntegerParameter implements Parameter {
    private IntegerLiteralExp param;

    public IntegerParameter(IntegerLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(Object object) {
        setInteger((Integer) object);
    }

    private void setInteger(int i) {
        param.setIntegerSymbol(i);
    }
}
