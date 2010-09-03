package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.ocl.ecore.StringLiteralExp;

public class StringParameter implements Parameter {
    private StringLiteralExp param;

    public StringParameter(StringLiteralExp param) {
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
