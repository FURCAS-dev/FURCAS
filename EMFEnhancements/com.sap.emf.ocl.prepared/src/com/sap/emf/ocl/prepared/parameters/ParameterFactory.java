package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.LiteralExp;

public interface ParameterFactory {
    static final ParameterFactory INSTANCE = new ParameterFactoryImpl();
    
    Parameter<?> getParameterFor(LiteralExp<EClassifier> literalExp);
}
