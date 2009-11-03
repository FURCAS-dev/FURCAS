package com.sap.mi.gfw.eclipse.platform;

import com.sap.mi.gfw.platform.IPlatformImageConstants;

public class PlatformImageProvider extends AbstractImageProvider {

	private static final String ROOT_FOLDER_FOR_IMG = "icons/"; //$NON-NLS-1$

	public final static String ID = "com.sap.mi.gfw.eclipse.platform.PlatformImageProvider"; //$NON-NLS-1$

	public PlatformImageProvider() {
		super();
	}

	@Override
	protected void addAvailableImages() {
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_COLLAPSE, ROOT_FOLDER_FOR_IMG + "edit/collapse.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_COLLAPSEALL, ROOT_FOLDER_FOR_IMG + "edit/collapseall.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_EXPAND, ROOT_FOLDER_FOR_IMG + "edit/expand.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_EXPANDALL, ROOT_FOLDER_FOR_IMG + "edit/expandall.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_REFRESH, ROOT_FOLDER_FOR_IMG + "edit/refresh.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_DELETE, ROOT_FOLDER_FOR_IMG + "edit/delete.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_EDIT_REMOVE, ROOT_FOLDER_FOR_IMG + "edit/remove.gif"); //$NON-NLS-1$

		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_ERROR, ROOT_FOLDER_FOR_IMG + "eclipse/error.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK, ROOT_FOLDER_FOR_IMG + "eclipse/error_tsk.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_INFORMATION, ROOT_FOLDER_FOR_IMG + "eclipse/information.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_INFORMATION_TSK, ROOT_FOLDER_FOR_IMG + "eclipse/info_tsk.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_QUICKASSIST, ROOT_FOLDER_FOR_IMG + "eclipse/quickassist.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_WARNING, ROOT_FOLDER_FOR_IMG + "eclipse/warning.gif"); //$NON-NLS-1$
		addImageFilePath(IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK, ROOT_FOLDER_FOR_IMG + "eclipse/warn_tsk.gif"); //$NON-NLS-1$

		addImageFilePath(IPlatformImageConstants.IMG_DIAGRAM, ROOT_FOLDER_FOR_IMG + "diagram.gif"); //$NON-NLS-1$
	}
}
