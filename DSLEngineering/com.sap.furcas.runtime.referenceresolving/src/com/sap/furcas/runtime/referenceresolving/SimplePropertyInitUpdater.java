package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;

public class SimplePropertyInitUpdater implements OCLBasedModelUpdater {
    private final InjectorAction injectorAction;
    private final ExpressionWithContext expressionWithContext;
    private final OppositeEndFinder oppositeEndFinder;

    public SimplePropertyInitUpdater(LookupPropertyInit injectorAction, OppositeEndFinder oppositeEndFinder) throws ParserException {
        this.injectorAction = injectorAction;
        this.oppositeEndFinder = oppositeEndFinder;
        Template template = ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate();
        OCLExpression expression = OCLWithHiddenOpposites.newInstance().createOCLHelper().createQuery(
                injectorAction.getValue());
        EClassifier contextClassifier = ContextAndForeachHelper.getParsingContext(injectorAction.getValue(), template);
        EClass contextClass = (EClass) contextClassifier;
        expressionWithContext = new ExpressionWithContext(expression, contextClass, /* notifyNewContextElements */ false);
    }

    @Override
    public Collection<ExpressionWithContext> getTriggerExpressions() {
        return Collections.singleton(expressionWithContext);
    }

    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder) {
        // TODO Implement Triggerable.notify(...)
        
    }
}
