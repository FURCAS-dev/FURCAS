package com.sap.ide.refactoring.model;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Base class of all model elements of the refactoring metamodel.
 * The latter opts to become a minimal, language agnostic interface shielding the
 * refactoring tooling from a specific metamodel. 
 * 
 * @author D049157
 *
 */
public interface RefactoringModelElement {

    public RefObject getWrappedModelElement();
}
