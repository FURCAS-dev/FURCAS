package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.ocl.ecore.EnumLiteralExp;

public class EnumParameter implements Parameter<EEnumLiteral> {
    private EnumLiteralExp param;

    public EnumParameter(EnumLiteralExp param) {
        this.param = param;
    }

    public void set(EEnumLiteral object) {
        setLiteral((EEnumLiteral) object);
    }

    private void setLiteral(EEnumLiteral value) {
        param.setReferredEnumLiteral(value);
    }

    public EnumLiteralExp getLiteralExp() {
        return param;
    }

    public EEnumLiteral get() {
        return param.getReferredEnumLiteral();
    }
}
