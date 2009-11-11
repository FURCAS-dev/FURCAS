/**
 * 
 */
package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.IPackageFilterCallback;

public class SameContainerFilterer implements IPackageFilterCallback {
	private final ModelElement value;

	public SameContainerFilterer(ModelElement value) {
		this.value = value;
	}

	public boolean matches(MofPackage pack) {
		return value.getContainer() != pack;
	}

}