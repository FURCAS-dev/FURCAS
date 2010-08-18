package com.sap.ide.refactoring.core.model.util;

import org.eclipse.emf.ecore.EObject;


public class RefactoringModelUtil {

    public static <T> T adaptObject(EObject refObject, Class<T> targetType) {
	return ModelAdapterUI.getInstance().adaptObject(refObject, targetType);
    }
}
