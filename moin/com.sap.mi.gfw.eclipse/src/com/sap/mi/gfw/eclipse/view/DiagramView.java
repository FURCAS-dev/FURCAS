package com.sap.mi.gfw.eclipse.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditorInput;
import com.sap.mi.gfw.eclipse.internal.view.DiagramEditorSite;
import com.sap.mi.gfw.eclipse.internal.view.DiagramViewTransfer;

public class DiagramView extends ViewPart {

	private DiagramEditor editor;

	public DiagramView() {
		setEditor(new DiagramEditor());
	}

	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		setSite(site);
		DiagramEditorSite editorSite = new DiagramEditorSite(site);
		DiagramEditorInput editorInput = DiagramViewTransfer.getInstance().getDiagramEditorInput();

		if (memento != null) { // called while workbench starts?

			// IMementoData data = MementoHandler.getData(memento);

			// if (data != null) {
			// editorInput.setComponentModelObject(data.getComponentModelObject());
			// editorInput.setNavigationLevel(data.getNavigationLevel());
			// }
		}

		getEditor().init(editorSite, editorInput);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		init(site, null);
	}

	@Override
	public void createPartControl(Composite parent) {
		getEditor().createPartControl(parent);
	}

	@Override
	public void setFocus() {
		getEditor().setFocus();
	}

	@Override
	public void dispose() {
		// getEditor().doSave(null);
		getEditor().dispose();
		// VdmEditorInput.getInstance().resetInput();
		super.dispose();
	}

	protected DiagramEditor getEditor() {
		return editor;
	}

	protected void setEditor(DiagramEditor editor) {
		this.editor = editor;
	}
}
