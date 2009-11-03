package com.sap.mi.gfw.eclipse.platform;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditorInput;
import com.sap.mi.gfw.eclipse.internal.view.DiagramViewTransfer;
import com.sap.mi.gfw.eclipse.view.DiagramView;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;

public class PlatformUtil {

	/**
	 * Opens the given diagram in the diagram editor. A new moin connection will be created.
	 * 
	 * @param diagram
	 *            which should be opened
	 * @return the editor instance
	 */
	public static IDiagramEditor openDiagramEditor(Diagram diagram) {
		return openDiagramEditor(diagram, null);
	}

	/**
	 * Opens the given diagram in the diagram editor. The given moin connection will be used. If the connection is null, a new moin
	 * connection will be created.
	 * 
	 * @param diagram
	 *            which should be opened
	 * @param connection
	 *            a valid MOIN connection or null
	 * @return the editor instance
	 */
	public static IDiagramEditor openDiagramEditor(Diagram diagram, Connection connection) {
		IDiagramEditor ret = null;

		String diagramTypeProviders[] = GfwUtil.getExtensionManager().getDiagramTypeProviderExtensionIds(diagram.getDiagramTypeId());
		if (diagramTypeProviders != null && diagramTypeProviders.length > 0) {
			// TODO handle if more then one DTPs are available
			String providerId = diagramTypeProviders[0];
			ret = openDiagramEditor(diagram, connection, providerId);
		}

		return ret;
	}

	/**
	 * Opens the given diagram in the diagram editor. The given moin connection will be used. If the connection is null, a new moin
	 * connection will be created.
	 * 
	 * @param diagram
	 *            which should be opened
	 * @param connection
	 *            a valid MOIN connection or null
	 * @param providerId
	 *            the unique provider id of a diagram type provider which will be used by the editor.
	 * @return the editor instance
	 */
	public static IDiagramEditor openDiagramEditor(Diagram diagram, Connection connection, String providerId) {
		IDiagramEditor ret = null;

		DiagramEditorInput diagramEditorInput = new DiagramEditorInput(diagram, connection, providerId);
		IWorkbenchPage workbenchPage = GraphicsPlugin.getActivePage();
		try {
			IEditorPart editorPart = IDE.openEditor(workbenchPage, diagramEditorInput, GraphicsPlugin.DIAGRAM_EDITOR_ID);
			if (editorPart instanceof IDiagramEditor) {
				ret = (IDiagramEditor) editorPart;
			}
		} catch (PartInitException e) {
			// $JL-EXC$
			T.racer().error(e.toString());
		}

		return ret;
	}

	/**
	 * Opens the given diagram in the diagram view. A new moin connection will be created.
	 * 
	 * @param diagram
	 *            which should be opened
	 */
	public static void openDiagramView(String viewId, Diagram diagram) {
		openDiagramView(viewId, diagram, null);
	}

	/**
	 * Opens the given diagram in the diagram view. The given moin connection will be used. If the connection is null, a new moin connection
	 * will be created.
	 * 
	 * @param diagram
	 *            which should be opened
	 * @param connection
	 *            a valid MOIN connection or null
	 */
	public static void openDiagramView(String viewId, Diagram diagram, Connection connection) {
		String diagramTypeProviders[] = GfwUtil.getExtensionManager().getDiagramTypeProviderExtensionIds(diagram.getDiagramTypeId());
		if (diagramTypeProviders != null && diagramTypeProviders.length > 0) {
			// TODO handle if more then one DTPs are available
			String providerId = diagramTypeProviders[0];
			openDiagramView(viewId, diagram, connection, providerId);
		}
	}

	/**
	 * Opens the given diagram in the diagram view. The given moin connection will be used. If the connection is null, a new moin connection
	 * will be created.
	 * 
	 * @param diagram
	 *            which should be opened
	 * @param connection
	 *            a valid MOIN connection or null
	 * @param providerId
	 *            the unique provider id of a diagram type provider which will be used by the editor.
	 */
	public static void openDiagramView(String viewId, Diagram diagram, Connection connection, String providerId) {
		// prepare the input for the editor
		DiagramEditorInput diagramEditorInput = new DiagramEditorInput(diagram, connection, providerId);
		DiagramViewTransfer.getInstance().setDiagramEditorInput(diagramEditorInput);

		IWorkbenchPage workbenchPage = GraphicsPlugin.getActivePage();
		if (workbenchPage != null) {
			try {
				IViewPart viewPart = workbenchPage.showView(viewId);

				if (viewPart != null && (viewPart instanceof DiagramView)) {
					// DiagramView view = (DiagramView) viewPart;
					// view.navigate();
				}

			} catch (PartInitException e) {
				// $JL-EXC$
				T.racer().error(e.toString());
			}
		}
	}
}
