package com.sap.ide.refactoring.core.model;

import org.eclipse.emf.ecore.EObject;




/**
 * Base class of all model elements of the refactoring metamodel.
 * The latter opts to become a minimal, language agnostic interface shielding the
 * refactoring tooling from a specific metamodel. 
 * 
 * @author D049157
 *
 */
public interface RefactoringModelElement {

    public EObject getWrappedModelElement();
}
