package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;

/**
 * Assigns a property on a model element by evaluating an OCL expression in the context of the element owning the property.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class SimplePropertyInitUpdater extends AbstractFurcasOCLBasedModelUpdater {
    private LookupPropertyInit injectorAction;

    public SimplePropertyInitUpdater(LookupPropertyInit injectorAction, OppositeEndFinder oppositeEndFinder)
            throws ParserException {
        super(injectorAction.getPropertyReference().getStrucfeature(), oppositeEndFinder, new ExpressionWithContext(
                createOCLHelper(injectorAction, oppositeEndFinder)
                        .createQuery(ContextAndForeachHelper.prepareOclQuery(injectorAction.getValue())),
                (EClass) ContextAndForeachHelper.getParsingContext(injectorAction.getValue(),
                        ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate())),
                        /* notifyNewContextElements */ true);
        this.injectorAction = injectorAction;
    }
    
    private static Helper createOCLHelper(LookupPropertyInit propInit, OppositeEndFinder oppositeEndFinder) {
        Helper result = OCL.newInstance(oppositeEndFinder).createOCLHelper();
        result.setContext(propInit.getInjectorActionsBlock().getParentTemplate().getMetaReference());
        return result;
    }

    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder) {
        // TODO once the TextblockDefinition.parseRule property is set by the TCSParser, enable the following:
        // Collection<TextBlock> affectedTextBlocks = getTextBlocksInChosenAlternativeForInjectorAction(injectorAction);
        injectorAction.eAdapters(); // TODO remove this phony usage...
        super.notify(expression, affectedContextObjects, oppositeEndFinder);
    }
}
