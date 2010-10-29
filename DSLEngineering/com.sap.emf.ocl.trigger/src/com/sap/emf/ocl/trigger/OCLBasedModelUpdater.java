package com.sap.emf.ocl.trigger;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;


/**
 * Based on one or more {@link OCLExpression OCL expressions}, this object may update a model whenever the value
 * of this or these expression(s) change(s). The OCL Impact Analysis helps to contain the ripple effects to
 * a small superset of the objects really affected by a model change.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface OCLBasedModelUpdater extends Triggerable {
    EStructuralFeature getPropertyToUpdate();
}
