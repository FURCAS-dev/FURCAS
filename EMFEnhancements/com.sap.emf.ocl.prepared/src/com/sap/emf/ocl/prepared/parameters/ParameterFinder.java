package com.sap.emf.ocl.prepared.parameters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.utilities.AbstractVisitor;

/**
 * Finds values in the symbol specification of the literal expressions in an {@link OCLExpression} by
 * walking the expression tree. Each such symbol found is turned into a corresponding {@link Parameter}
 * specification. If a symbol is found multiple times, an exception is thrown. If a value is not found,
 * an exception is thrown as well.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class ParameterFinder extends AbstractVisitor<Map<Object, Parameter<?>>, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
    private Set<Object> parameterValuesToFindInLiterals;
    private ParameterFactory paramFactory = ParameterFactory.INSTANCE;

    /**
     * Throws an {@link IllegalArgumentException} if the values in <code>parameteValuesToFindInLiterals</code>
     * is not unique considering the relation defined by their <code>equals</code> method.
     */
    public ParameterFinder(Object... parameterValuesToFindInLiterals) {
        super(new HashMap<Object, Parameter<?>>());
        this.parameterValuesToFindInLiterals = new HashSet<Object>(Arrays.asList(parameterValuesToFindInLiterals));
        if (this.parameterValuesToFindInLiterals.size() < parameterValuesToFindInLiterals.length) {
            throw new IllegalArgumentException("Parameter values in "+Arrays.toString(parameterValuesToFindInLiterals)+
                    " not unique");
        }
    }
    
    @Override
    public Map<Object, Parameter<?>> visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {
        Integer symbol = literalExp.getIntegerSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitIntegerLiteralExp(literalExp);
    }

    @Override
    public Map<Object, Parameter<?>> visitRealLiteralExp(RealLiteralExp<EClassifier> literalExp) {
        Double symbol = literalExp.getRealSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitRealLiteralExp(literalExp);
    }

    @Override
    public Map<Object, Parameter<?>> visitStringLiteralExp(StringLiteralExp<EClassifier> literalExp) {
        String symbol = literalExp.getStringSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitStringLiteralExp(literalExp);
    }

    @Override
    public Map<Object, Parameter<?>> visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> literalExp) {
        Boolean symbol = literalExp.getBooleanSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitBooleanLiteralExp(literalExp);
    }

    @Override
    public Map<Object, Parameter<?>> visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> literalExp) {
        EEnumLiteral symbol = literalExp.getReferredEnumLiteral();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitEnumLiteralExp(literalExp);
    }

    private void lookupSymbolAndEnterInfoResultIfMatch(LiteralExp<EClassifier> literalExp, Object symbol) {
        if (parameterValuesToFindInLiterals.contains(symbol)) {
            if (result.containsKey(symbol)) {
                throw new DuplicateParameterValueException(
                        result.get(symbol),
                        literalExp);
            }
            result.put(symbol, paramFactory.getParameterFor(literalExp));
        }
    }
    
    public Map<Object, Parameter<?>> visit(OCLExpression e) {
        Map<Object, Parameter<?>> resultCandidate = safeVisit(e);
        if (result.size() < parameterValuesToFindInLiterals.size()) {
            throw new ParameterNotFoundException(e, parameterValuesToFindInLiterals, result.keySet());
        }
        return resultCandidate;
    }
}
