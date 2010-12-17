package com.sap.furcas.runtime.referenceresolving;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;

/**
 * Assigns a property on a model element by evaluating an OCL expression in the context of the element owning the property.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class SimplePropertyInitUpdater extends AbstractFurcasOCLBasedModelUpdater {
    private LookupPropertyInit injectorAction;

    protected SimplePropertyInitUpdater(LookupPropertyInit injectorAction, EPackage.Registry metamodelPackageRegistry, OppositeEndFinder oppositeEndFinder)
            throws ParserException {
        super(injectorAction.getPropertyReference().getStrucfeature(), metamodelPackageRegistry, oppositeEndFinder,
                        new ExpressionWithContext(
                                createOCLHelper(injectorAction.getValue(),
                                        ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate(), oppositeEndFinder)
                                        .createQuery(ContextAndForeachHelper.prepareOclQuery(injectorAction.getValue())),
                                (EClass) ContextAndForeachHelper.getParsingContext(injectorAction.getValue(),
                                        ((InjectorActionsBlock) injectorAction.eContainer()).getParentTemplate())),
                                        /* notifyNewContextElements */ true, getSelfKind(injectorAction.getValue()),
                                        ContextAndForeachHelper.getContextTag(injectorAction.getValue()));
        this.injectorAction = injectorAction;
    }
    
    @Override
    protected SequenceElement getSequenceElement() {
        return injectorAction.getInjectorActionsBlock();
    }
}
