package com.sap.mi.gfw.eclipse.internal.editor;

import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.impl.DimensionImpl;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.tc.moin.repository.Connection;

/**
 * 
 * can be used in the dark feature processing mode
 * 
 */
public class DiagramEditorDummy implements IDiagramEditor {

	private IDiagramTypeProvider diagramTypeProvider;

	public DiagramEditorDummy(IDiagramTypeProvider diagramTypeProvider) {
		setDiagramTypeProvider(diagramTypeProvider);
	}

	public Connection getConnection() {
		return null;
	}

	public IDimension getCurrentSize() {
		return new DimensionImpl(0, 0);
	}

	public IDiagramTypeProvider getDiagramTypeProvider() {
		return diagramTypeProvider;
	}

	public PictogramElement[] getSelectedPictogramElements() {
		return new PictogramElement[0];
	}

	public boolean isDirty() {
		return false;
	}

	public void refresh() {
	}

	public void refreshTitleToolTip() {
	}

	public void selectPictogramElements(PictogramElement[] pictogramElements) {
	}

	public void setPictogramElementForSelection(PictogramElement pictogramElement) {
	}

	public void setPictogramElementsForSelection(PictogramElement[] pictogramElements) {
	}

	protected void setDiagramTypeProvider(IDiagramTypeProvider diagramTypeProvider) {
		this.diagramTypeProvider = diagramTypeProvider;
	}

	public void refreshRenderingDecorators(PictogramElement pe) {
	}

	public void refreshPalette() {
	}
}
