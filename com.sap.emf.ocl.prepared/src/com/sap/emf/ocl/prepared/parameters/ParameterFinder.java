package com.sap.emf.ocl.prepared.parameters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StringLiteralExp;

import com.sap.emf.ocl.hiddenopposites.AbstractVisitorWithHiddenOpposites;

/**
 * Finds values in the symbol specification of the literal expressions in an {@link OCLExpression} by
 * walking the expression tree. Each such symbol found is turned into a corresponding {@link Parameter}
 * specification. If a symbol is found multiple times, an exception is thrown. If a value is not found,
 * an exception is thrown as well.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class ParameterFinder extends AbstractVisitorWithHiddenOpposites<Set<Parameter>> {
    private Set<Object> parameterValuesToFindInLiterals;
    private Map<Object, Parameter> parameterForFoundValues;
    private ParameterFactory paramFactory = ParameterFactory.INSTANCE;

    public ParameterFinder(Object... parameterValuesToFindInLiterals) {
        super(new HashSet<Parameter>());
        this.parameterForFoundValues = new HashMap<Object, Parameter>();
        this.parameterValuesToFindInLiterals = new HashSet<Object>(Arrays.asList(parameterValuesToFindInLiterals));
    }
    
    @Override
    public Set<Parameter> visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {
        Integer symbol = literalExp.getIntegerSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitIntegerLiteralExp(literalExp);
    }

    @Override
    public Set<Parameter> visitRealLiteralExp(RealLiteralExp<EClassifier> literalExp) {
        Double symbol = literalExp.getRealSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitRealLiteralExp(literalExp);
    }

    @Override
    public Set<Parameter> visitStringLiteralExp(StringLiteralExp<EClassifier> literalExp) {
        String symbol = literalExp.getStringSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitStringLiteralExp(literalExp);
    }

    @Override
    public Set<Parameter> visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> literalExp) {
        Boolean symbol = literalExp.getBooleanSymbol();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitBooleanLiteralExp(literalExp);
    }

    @Override
    public Set<Parameter> visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> literalExp) {
        EEnumLiteral symbol = literalExp.getReferredEnumLiteral();
        lookupSymbolAndEnterInfoResultIfMatch(literalExp, symbol);
        return super.visitEnumLiteralExp(literalExp);
    }

    private void lookupSymbolAndEnterInfoResultIfMatch(LiteralExp<EClassifier> literalExp, Object symbol) {
        if (parameterValuesToFindInLiterals.contains(symbol)) {
            if (parameterForFoundValues.containsKey(symbol)) {
                throw new DuplicateParameterValueException(
                        parameterForFoundValues.get(symbol),
                        literalExp);
            }
            result.add(paramFactory.getParameterFor(literalExp));
        }
    }
}
