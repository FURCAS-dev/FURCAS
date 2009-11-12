package com.sap.ide.moftool.editor.internal.refactoring.ui.dialog;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

public interface IPackageFilterCallback {
	
	public boolean matches(MofPackage object);

}
