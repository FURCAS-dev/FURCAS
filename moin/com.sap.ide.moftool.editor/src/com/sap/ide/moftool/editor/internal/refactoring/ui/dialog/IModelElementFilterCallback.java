package com.sap.ide.moftool.editor.internal.refactoring.ui.dialog;

import com.sap.tc.moin.repository.mmi.model.ModelElement;

public interface IModelElementFilterCallback {

	public boolean matches(ModelElement object);

}
