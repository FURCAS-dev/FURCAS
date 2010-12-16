package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
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
                createOCLHelper(injectorAction.getValue(),
                        ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate(), oppositeEndFinder)
                        .createQuery(ContextAndForeachHelper.prepareOclQuery(injectorAction.getValue())),
                (EClass) ContextAndForeachHelper.getParsingContext(injectorAction.getValue(),
                        ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate())),
                        /* notifyNewContextElements */ true, getSelfKind(injectorAction.getValue()));
        this.injectorAction = injectorAction;
    }
    
    /**
     * The <code>aggectedContextObjects</code> are the elements that are the context of the OCL expressions
     * that may have changed their values. We now have to find out on which element to assign the evaluation
     * result to the property identified by the {@link #injectorAction} through its
     * {@link LookupPropertyInit#getPropertyReference() property reference}. How this has to happen is encapsulated
     * in {@link AbstractFurcasOCLBasedModelUpdater#getSelf(EObject).
     */
    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder) {
        // TODO once the TextblockDefinition.parseRule property is set by the TCSParser, enable the following:
        // Collection<TextBlock> affectedTextBlocks = getTextBlocksInChosenAlternativeForInjectorAction(injectorAction);
        for (EObject eo : affectedContextObjects) {
            Object elementToUpdate = getElementToUpdate(eo, injectorAction);
            System.out.println(elementToUpdate); // TODO remove this again when done with debugging
        }
        super.notify(expression, affectedContextObjects, oppositeEndFinder);
    }
}
