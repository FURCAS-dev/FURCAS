/**
 * 
 */
package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.IPackageFilterCallback;
import com.sap.mi.gfw.mm.pictograms.Diagram;

public class SameContainerDiagramFilterer implements IPackageFilterCallback {
	private final Diagram value;

	public SameContainerDiagramFilterer(Diagram value) {
		this.value = value;
	}

	public boolean matches(MofPackage pack) {
		return DiagramService.getDiagramPackage(value) != pack;
	}

}