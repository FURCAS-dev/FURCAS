package com.sap.mi.tools.diagnostics.test;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.sap.mi.tools.diagnostics.internal.DiagnosticsPlugin;

/**
 * Perspective supposed to facilitate UI testing.  It arranges the necessary
 * Diagnostics and properties view such that they do not overlap and acquire
 * enough space.  Also the "Tests inside IDE" view is embedded to support
 * test triggers from this view.  
 * 
 * @author d031150
 */
public class DiagnosticsTestPerspective implements IPerspectiveFactory {

	public static final String ID = "com.sap.mi.tools.diagnostics.test.perspective";
	
	private static final String ID_FOLDER_TOP_RIGHT = "topRight";
	private static final String ID_FOLDER_TOP_LEFT = "topLeft";
	private static final String ID_FOLDER_BOTTOM = "bottom";
	private static final String ID_FOLDER_BOTTOM_LEFT = "bottomLeft";
	
	private static final String ID_PROJECT_EXPLORER = "org.eclipse.ui.navigator.ProjectExplorer";
	private static final String ID_TESTS_VIEW = "com.sap.ide.junit.views.TestsView";

	public DiagnosticsTestPerspective() {
		super();
	}

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		
		// Top left: Project Browser, Navigator
		IFolderLayout topLeftFolder = layout.createFolder(ID_FOLDER_TOP_LEFT,
				IPageLayout.LEFT, 0.4f, IPageLayout.ID_EDITOR_AREA);
		topLeftFolder.addView(ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(ID_PROJECT_EXPLORER);
		topLeftFolder.addView(IPageLayout.ID_RES_NAV);
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);

		// Bottom left: Property Sheet, Problems views
		IFolderLayout bottomRightFolder = layout.createFolder(ID_FOLDER_BOTTOM_LEFT,
				IPageLayout.BOTTOM, 0.4f, ID_PROJECT_EXPLORER);
		bottomRightFolder.addView(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		
		// Bottom: Property Sheet
		IFolderLayout bottomFolder = layout.createFolder(ID_FOLDER_BOTTOM,
				IPageLayout.BOTTOM, 0.4f, IPageLayout.ID_EDITOR_AREA);
		bottomFolder.addView(DiagnosticsPlugin.ID_VIEW);
		layout.addShowViewShortcut(DiagnosticsPlugin.ID_VIEW);
		
		// Top: Tests Inside IDE view
		IFolderLayout topRightFolder = layout.createFolder(ID_FOLDER_TOP_RIGHT,
				IPageLayout.TOP, 0.6f, IPageLayout.ID_EDITOR_AREA);
		topRightFolder.addView(ID_TESTS_VIEW);
		layout.addShowViewShortcut(ID_TESTS_VIEW);
	}

}
