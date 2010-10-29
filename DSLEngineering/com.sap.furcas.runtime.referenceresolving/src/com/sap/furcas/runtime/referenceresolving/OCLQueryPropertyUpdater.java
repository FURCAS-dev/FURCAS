package com.sap.furcas.runtime.referenceresolving;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ParserException;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.AbstractOCLBasedModelUpdater;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * Represents an OCL "query" used to find an existing element in the model to assign to a property. The query is based on a
 * parameter whose value is taken from a token in the text blocks model.
 * <p>
 * 
 * The tricky part about this type of updater, from the perspective of the OCL Impact Analysis, is that its parameterized OCL
 * expression must contain some subexpression for the parameter usage. This must not be a literal expression because then the
 * impact analysis may be able to evaluate it and cut short the impact analysis process. For example, were the parameter
 * expression represented as a string literal <code>'???'</code> in an expression <code>...-&gt;select(i.x = '???')</code> then
 * the impact analysis may try a partial evaluation of <code>i.x = '???'</code> for the pre-change and post-change models. If both
 * values of <code>i.x</code> are not equal to <code>'???'</code> (which is of course very likely) then the impact analysis would
 * infer that no change to the overall expression's value has happened. However, this may not be true depending on the actual
 * value used for the parameter at the time of evaluation.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class OCLQueryPropertyUpdater extends AbstractOCLBasedModelUpdater {

    protected OCLQueryPropertyUpdater(Property propertyInit, OppositeEndFinder oppositeEndFinder) throws ParserException {
        super(propertyInit.getPropertyReference().getStrucfeature(), oppositeEndFinder, new ExpressionWithContext(
                OCLWithHiddenOpposites.newInstance(oppositeEndFinder).createOCLHelper()
                .createQuery(ContextAndForeachHelper.prepareOclQuery(getExpressionString(propertyInit))),
        (EClass) ContextAndForeachHelper.getParsingContext(getExpressionString(propertyInit),
                propertyInit.getParentTemplate())),
                /* notifyNewContextElements */ true);
        // TODO handle parameterization of query expression
//      ref.setGenericReference(true);
    }

    private static String getExpressionString(Property propertyInit) {
        QueryPArg qarg = TcsUtil.getQueryPArg(propertyInit);
        FilterPArg filter = TcsUtil.getFilterPArg(propertyInit);
        if (qarg == null) {
            throw new RuntimeException("Didn't find a query argument in rule for property "+propertyInit.getPropertyReference().getStrucfeature());
        }
        return qarg.getQuery() + (filter != null ? filter.getQuery() : "");
    }
}
