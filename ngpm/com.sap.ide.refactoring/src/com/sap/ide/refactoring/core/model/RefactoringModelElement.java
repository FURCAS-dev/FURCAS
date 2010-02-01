package com.sap.ide.refactoring.core.model;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Base class of all model elements of the refactoring metamodel. 
 * The latter opts to become a minimal, object-oriented metamodel suitable for
 * refactorings.
 * 
 * @author D049157
 *
 */
public interface RefactoringModelElement {

    public RefObject getOriginalElement();
}
