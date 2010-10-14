package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.ocl.ecore.StringLiteralExp;

public class StringParameter implements Parameter<String> {
    private StringLiteralExp param;

    public StringParameter(StringLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(String object) {
        setString((String) object);
    }

    private void setString(String s) {
        param.setStringSymbol(s);
    }

    public StringLiteralExp getLiteralExp() {
        return param;
    }

    public String get() {
        return param.getStringSymbol();
    }
}
