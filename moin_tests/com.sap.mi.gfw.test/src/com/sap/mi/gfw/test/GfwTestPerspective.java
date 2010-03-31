package com.sap.mi.gfw.test;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * This class is used for testing of GFW. Its purpose is to show all relevant views (if possible next to each other).
 */
public class GfwTestPerspective implements IPerspectiveFactory {

	/**
	 * Creates the layout
	 * <ul>
	 * <li>top-left: "Graphics Framework Test View"</li>
	 * <li>middle-left: "Outline"</li>
	 * <li>bottom-left: "Miniature View"</li>
	 * <li>top-right: editor</li>
	 * <li>middle-right: "Properties"</li>
	 * <li>bottom-right: several test views</li>
	 * </ul>
	 */
	public void createInitialLayout(IPageLayout layout) {
		// top-left
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, (float) 0.25, IPageLayout.ID_EDITOR_AREA);
		topLeft.addView("com.sap.mi.gfw.samples.testview.MoinView");
		topLeft.addPlaceholder(IPageLayout.ID_RES_NAV);
		topLeft.addPlaceholder("org.eclipse.ui.navigator.ProjectExplorer");
		topLeft.addPlaceholder("org.eclipse.jdt.ui.PackageExplorer");

		// middle-left
		IFolderLayout middleLeft = layout.createFolder("middleLeft", IPageLayout.BOTTOM, (float) 0.40, "topLeft");
		middleLeft.addView(IPageLayout.ID_OUTLINE);

		// bottom-left
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, (float) 0.50, "middleLeft");
		bottomLeft.addView("com.sap.mi.gfw.eclipse.internal.editor.thumbnailview");

		// middle-right
		IFolderLayout middleRight = layout.createFolder("middleRight", IPageLayout.BOTTOM, (float) 0.55, IPageLayout.ID_EDITOR_AREA);
		middleRight.addView(IPageLayout.ID_PROP_SHEET);

		// bottom-right
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, (float) 0.40, "middleRight");
		bottomRight.addView("com.sap.ide.junit.views.TestsView");
		bottomRight.addView("org.eclipse.pde.runtime.LogView");
		bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottomRight.addView("com.sap.ide.dii05.ui.internal.views.logview.InfrastructureConsoleView");
	}
}
