package com.sap.emf.ocl.prepared.parameters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.ecore.OCLExpression;

public class ParameterNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 8389399628327903566L;
    private final OCLExpression e;
    private final Set<Object> parameterValuesToFindInLiterals;
    private final Set<Object> parameterValuesFound;
    
    public ParameterNotFoundException(OCLExpression e, Set<Object> parameterValuesToFindInLiterals, Set<Object> parameterValuesFound) {
        super("Couldn't find one or more parameter specification objects: "+
                new HashSet<Object>(parameterValuesToFindInLiterals).removeAll(parameterValuesFound));
        this.e = e;
        this.parameterValuesToFindInLiterals = parameterValuesToFindInLiterals;
        this.parameterValuesFound = parameterValuesFound;
    }

    public OCLExpression getE() {
        return e;
    }

    public Set<Object> getParameterValuesToFindInLiterals() {
        return parameterValuesToFindInLiterals;
    }

    public Set<Object> getParameterValuesFound() {
        return parameterValuesFound;
    }

}
