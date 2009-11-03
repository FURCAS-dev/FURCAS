package com.sap.mi.gfw.eclipse.internal.view;

import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditorInput;

public class DiagramViewTransfer {

	private static DiagramViewTransfer diagramViewTransfer = null;

	private DiagramEditorInput diagramEditorInput = null;

	public static DiagramViewTransfer getInstance() {
		if (diagramViewTransfer == null) {
			diagramViewTransfer = new DiagramViewTransfer();
		}
		return diagramViewTransfer;
	}

	public DiagramEditorInput getDiagramEditorInput() {
		return diagramEditorInput;
	}

	public void setDiagramEditorInput(DiagramEditorInput diagramEditorInput) {
		this.diagramEditorInput = diagramEditorInput;
	}
}
