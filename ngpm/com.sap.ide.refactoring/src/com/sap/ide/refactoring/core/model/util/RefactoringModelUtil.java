package com.sap.ide.refactoring.core.model.util;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RefactoringModelUtil {

    public static <T> T adaptObject(RefObject refObject, Class<T> targetType) {
	return ModelAdapterUI.getInstance().adaptObject(refObject, targetType);
    }
}
