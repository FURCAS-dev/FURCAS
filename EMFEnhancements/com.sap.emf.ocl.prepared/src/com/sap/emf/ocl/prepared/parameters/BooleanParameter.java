package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.ocl.ecore.BooleanLiteralExp;

public class BooleanParameter implements Parameter<Boolean> {
    private BooleanLiteralExp param;

    public BooleanParameter(BooleanLiteralExp param) {
        this.param = param;
    }

    public void set(Boolean object) {
        setBoolean((Boolean) object);
    }

    private void setBoolean(boolean b) {
        param.setBooleanSymbol(b);
    }

    public BooleanLiteralExp getLiteralExp() {
        return param;
    }
    
    public Boolean get() {
        return param.getBooleanSymbol();
    }
}
