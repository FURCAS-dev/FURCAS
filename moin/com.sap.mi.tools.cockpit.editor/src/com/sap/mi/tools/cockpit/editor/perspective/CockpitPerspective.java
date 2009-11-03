package com.sap.mi.tools.cockpit.editor.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author d003456
 * 
 */
public class CockpitPerspective implements IPerspectiveFactory {

	private static final String PERSPECTIVE_ID_DEBUG = "org.eclipse.debug.ui.DebugPerspective"; //$NON-NLS-1$

	private static final String TOP_LEFT = "topLeft"; //$NON-NLS-1$

	private static final String TOP_RIGHT = "topRight"; //$NON-NLS-1$

	private static final String BOTTOM_RIGHT = "bottomRight"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {

		defineActions(layout);
		defineLayout(layout);

	}

	private void defineActions(IPageLayout layout) {

		// layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");

		// views shortcuts
		layout.addShowViewShortcut("com.sap.mi.tools.diagnostics.viewer"); //$NON-NLS-1$
		layout.addShowViewShortcut("com.sap.mi.views.MmDeployment"); //$NON-NLS-1$
		layout.addShowViewShortcut("com.sap.mi.tools.cockpit.mql.ui.view.QueryConsoleView"); //$NON-NLS-1$
		layout.addShowViewShortcut("com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView"); //$NON-NLS-1$
		layout.addShowViewShortcut("com.sap.mi.tools.oclevalview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
		layout.addShowViewShortcut(IPageLayout.ID_BOOKMARKS);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);

		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_PROGRESS_VIEW);

		// perspective shortcuts
		layout.addPerspectiveShortcut("com.sap.glx.ide.ui.GalaxyPerspective"); //$NON-NLS-1$
		layout.addPerspectiveShortcut(CockpitPerspective.PERSPECTIVE_ID_DEBUG);
	}

	private void defineLayout(IPageLayout layout) {

		final String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);

		final IFolderLayout topLeft = layout.createFolder(CockpitPerspective.TOP_LEFT, IPageLayout.LEFT, 0.3f, editorArea);
		topLeft.addView("com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView"); //$NON-NLS-1$
		topLeft.addView("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
		topLeft.addView(IPageLayout.ID_RES_NAV);
		topLeft.addPlaceholder(IPageLayout.ID_BOOKMARKS);

		final IFolderLayout topRight = layout.createFolder(CockpitPerspective.TOP_RIGHT, 2, 0.65F, editorArea);
		topRight.addView("com.sap.mi.views.MmDeployment"); //$NON-NLS-1$
		topRight.addView("com.sap.mi.tools.diagnostics.viewer"); //$NON-NLS-1$
		topRight.addView("com.sap.mi.tools.cockpit.mql.ui.view.QueryConsoleView"); //$NON-NLS-1$

		final IFolderLayout bottomRight = layout.createFolder(CockpitPerspective.BOTTOM_RIGHT, 4, 0.5F, CockpitPerspective.TOP_RIGHT);
		bottomRight.addView("com.sap.mi.tools.oclevalview"); //$NON-NLS-1$
		bottomRight.addView(IPageLayout.ID_PROP_SHEET);

	}

}
