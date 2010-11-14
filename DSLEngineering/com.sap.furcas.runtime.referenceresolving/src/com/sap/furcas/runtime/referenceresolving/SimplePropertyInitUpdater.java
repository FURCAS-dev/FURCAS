package com.sap.furcas.runtime.referenceresolving;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.trigger.AbstractOCLBasedModelUpdater;
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
public class SimplePropertyInitUpdater extends AbstractOCLBasedModelUpdater {
    public SimplePropertyInitUpdater(LookupPropertyInit injectorAction, OppositeEndFinder oppositeEndFinder)
            throws ParserException {
        super(injectorAction.getPropertyReference().getStrucfeature(), oppositeEndFinder, new ExpressionWithContext(
                OCL.newInstance(oppositeEndFinder).createOCLHelper()
                        .createQuery(ContextAndForeachHelper.prepareOclQuery(injectorAction.getValue())),
                (EClass) ContextAndForeachHelper.getParsingContext(injectorAction.getValue(),
                        ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate())),
                        /* notifyNewContextElements */ true);
    }
}
