package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.ocl.ecore.RealLiteralExp;

public class RealParameter implements Parameter {
    private RealLiteralExp param;

    public RealParameter(RealLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(Object object) {
        setReal((Double) object);
    }

    private void setReal(double r) {
        param.setRealSymbol(r);
    }

    public RealLiteralExp getLiteralExp() {
        return param;
    }
}
