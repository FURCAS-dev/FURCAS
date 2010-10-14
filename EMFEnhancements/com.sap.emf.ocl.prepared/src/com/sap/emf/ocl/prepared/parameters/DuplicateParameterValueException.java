package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.LiteralExp;

public class DuplicateParameterValueException extends RuntimeException {
    private static final long serialVersionUID = 7742879551082319000L;
    private final Parameter<?> parameter;
    private final LiteralExp<EClassifier> literalExp;
    
    public DuplicateParameterValueException(Parameter<?> parameter, LiteralExp<EClassifier> literalExp) {
        super("Non-unique literal value not allowed for parameter identification. "+
                "Found second literal "+literalExp+" after previously finding "+parameter.getLiteralExp());
        this.parameter = parameter;
        this.literalExp = literalExp;
    }

    public Parameter<?> getParameter() {
        return parameter;
    }

    public LiteralExp<EClassifier> getLiteralExp() {
        return literalExp;
    }
    
}
