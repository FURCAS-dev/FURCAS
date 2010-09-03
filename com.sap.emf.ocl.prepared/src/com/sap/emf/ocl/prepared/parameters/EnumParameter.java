package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.ocl.ecore.EnumLiteralExp;

public class EnumParameter implements Parameter {
    private EnumLiteralExp param;

    public EnumParameter(EnumLiteralExp param) {
        this.param = param;
    }

    @Override
    public void set(Object object) {
        setLiteral((EEnumLiteral) object);
    }

    private void setLiteral(EEnumLiteral value) {
        param.setReferredEnumLiteral(value);
    }
}
