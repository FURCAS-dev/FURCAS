package com.sap.emf.ocl.prepared;

import org.eclipse.ocl.ecore.StringLiteralExp;

public class StrngParameter implements Parameter {
    private StringLiteralExp param;

    public StrngParameter(StringLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(Object object) {
        setString((String) object);
    }

    private void setString(String s) {
        param.setStringSymbol(s);
    }
}
