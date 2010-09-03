package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.ocl.ecore.BooleanLiteralExp;

public class BooleanParameter implements Parameter {
    private BooleanLiteralExp param;

    public BooleanParameter(BooleanLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(Object object) {
        setBoolean((Boolean) object);
    }

    private void setBoolean(boolean b) {
        param.setBooleanSymbol(b);
    }
}
