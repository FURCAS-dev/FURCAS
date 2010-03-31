package com.sap.mi.gfw.test;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.ui.lift.LShell;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.internal.action.PrintGraphicalViewerAction;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.util.ui.UIUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IPrintFeature;
import com.sap.mi.gfw.samples.dt.IDiagramTypeConstants;

public class GfwDialogTests extends AbstractGfwTests {

	public GfwDialogTests() {
		super();
	}

	public void testPrintDialog() throws Exception {

		// check if default printer is configured, otherwise SWT throws a "no more handles" error in Printer.checkNull(..)  
		if (Printer.getDefaultPrinterData() != null) {

			final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
			
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
					IFeatureProvider fp = dtp.getFeatureProvider();
					IPrintFeature pf = fp.getPrintFeature();
					IAction createPrintGraphicalViewerAction = new PrintGraphicalViewerAction(diagramEditor.getConfigurationProvider(), diagramEditor, pf);
					createPrintGraphicalViewerAction.run();
				}
			});

			LShell child = getLShell().childShell();
			LShell preferences = null;

			try {
				preferences = getLShell().waitForShowing(child.withText("Print preview and preferences"));
				System.out.println("waited");
				Thread.sleep(2000);
				preferences.button().withText("Cancel").setFocus();
				Thread.sleep(30);
				preferences.clickOn(preferences.button().withText("Cancel")); // click
				System.out.println("Canceled");
				Thread.sleep(300);
				preferences.waitForClosed(); // wait for dialog shell dispose. }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeEditor(diagramEditor);
			}
			
		} else{
			System.out.println("!-> GfwDialogTests.testPrintDialog():  No default printer configured. Skip test.");
		}
	}

	public void testSaveDialog() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				UIUtil.startSaveAsImageDialog(diagramEditor.getGraphicalViewer());
			}
		});

		LShell child = getLShell().childShell();
		LShell preferences = null;

		try {
			preferences = getLShell().waitForShowing(child.withText("Select picture options"));
			System.out.println("waited");
			Thread.sleep(2000);
			preferences.button().withText("Cancel").setFocus();
			Thread.sleep(30);
			preferences.clickOn(preferences.button().withText("Cancel")); // click
			System.out.println("Canceled");
			Thread.sleep(300);
			preferences.waitForClosed(); // wait for dialog shell dispose. }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEditor(diagramEditor);
		}

	}
}
