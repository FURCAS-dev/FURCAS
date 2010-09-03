package com.sap.emf.ocl.prepared.parameters;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.expressions.LiteralExp;

public class ParameterFactoryImpl implements ParameterFactory {
    /**
     * Factory method that creates the appropriate {@link Parameter} implementation instance
     * for the parameterizable literal expression <code>param</code>.
     */
    public Parameter getParameterFor(LiteralExp<EClassifier> param) {
        Parameter result;
        switch (param.eClass().getClassifierID()) {
        case EcorePackage.BOOLEAN_LITERAL_EXP:
            result = new BooleanParameter((BooleanLiteralExp) param);
            break;
        case EcorePackage.INTEGER_LITERAL_EXP:
            result = new IntegerParameter((IntegerLiteralExp) param);
            break;
        case EcorePackage.REAL_LITERAL_EXP:
            result = new RealParameter((RealLiteralExp) param);
            break;
        case EcorePackage.STRING_LITERAL_EXP:
            result = new StringParameter((StringLiteralExp) param);
            break;
        case EcorePackage.ENUM_LITERAL_EXP:
            result = new EnumParameter((EnumLiteralExp) param);
            break;
        default:
            throw new RuntimeException("Unknown literal expression type "+param.getClass().getName());
        }
        return result;
    }


}
