package com.sap.ide.moftool.editor.core.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	private static final String ID_FOLDER_TOP_LEFT = "topLeft"; //$NON-NLS-1$
	private static final String ID_FOLDER_BOTTOM_LEFT = "bottomLeft"; //$NON-NLS-1$
	private static final String ID_FOLDER_BOTTOM_RIGHT = "bottomRight"; //$NON-NLS-1$

	private static final String ID_PROJECT_EXPLORER = "org.eclipse.ui.navigator.ProjectExplorer"; //$NON-NLS-1$

	public Perspective() {
		super();
	}

	public void createInitialLayout(IPageLayout layout) {
		// top left: project browser, navigator
		IFolderLayout topLeftFolder = layout.createFolder(ID_FOLDER_TOP_LEFT, IPageLayout.LEFT, 0.25f, IPageLayout.ID_EDITOR_AREA);
		topLeftFolder.addView(ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(ID_PROJECT_EXPLORER);
		topLeftFolder.addView(IPageLayout.ID_RES_NAV);
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);

		// bottom left: miniature view
		IFolderLayout bottomLeft = layout.createFolder(ID_FOLDER_BOTTOM_LEFT, IPageLayout.BOTTOM, 0.5f, ID_FOLDER_TOP_LEFT);
		bottomLeft.addView("com.sap.mi.gfw.eclipse.internal.editor.thumbnailview");

		// bottom right: property sheet, problem view
		IFolderLayout bottomFolder = layout.createFolder(ID_FOLDER_BOTTOM_RIGHT, IPageLayout.BOTTOM, 0.7f, IPageLayout.ID_EDITOR_AREA);
		bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		bottomFolder.addView(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
	}

}
