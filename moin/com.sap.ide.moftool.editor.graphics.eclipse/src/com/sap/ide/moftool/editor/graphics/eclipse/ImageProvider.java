package com.sap.ide.moftool.editor.graphics.eclipse;

import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.mi.gfw.eclipse.platform.AbstractImageProvider;

public class ImageProvider extends AbstractImageProvider {

	private static final String LOCAL_ROOT_FOLDER_FOR_IMG = "icons/"; //$NON-NLS-1$

	public ImageProvider() {
		super();
	}

	@Override
	protected void addAvailableImages() {
		// Main objects
		addImageFilePath(IImageConstants.IMG_CLASS, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/Class.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_ENUMERATION_TYPE, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/EnumerationType.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_STRUCTURE_TYPE, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/StructureType.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_CLASS_DIAGRAM, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/ClassDiagram.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_ASSOCIATION, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/Association.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_COMPOSITION, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/Composition.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_GENERALIZATION, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "mainobjects/Generalization.gif"); //$NON-NLS-1$

		// Speed buttons
		addImageFilePath(IImageConstants.IMG_CREATE_ATTRIBUTE, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "speedButtons/CreateAttribute.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_CREATE_OPERATION, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "speedButtons/CreateOperation.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_NEW_SUPERCLASS, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "speedButtons/NewSuperclass.gif"); //$NON-NLS-1$

		// Empty image for compartments (compatibility with existing diagrams)
		addImageFilePath(IImageConstants.IMG_EMPTY, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "Dot.gif"); //$NON-NLS-1$


		// reworked until here
		addImageFilePath(IImageConstants.IMG_MODIFIER_SUPCLASS_OBJ, LOCAL_ROOT_FOLDER_FOR_IMG
 				+ "general/super_class.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_MODIFIER_SUBCLASS_OBJ, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "general/sub_class.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_ADD_ASSOCIATION_OBJ, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "general/addAssociation.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_NEWLABEL_OBJ, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "general/newlabel.gif"); //$NON-NLS-1$
		addImageFilePath(IImageConstants.IMG_NEWSTRUCTUREFIELD_OBJ, LOCAL_ROOT_FOLDER_FOR_IMG
				+ "general/newstrucfield.gif"); //$NON-NLS-1$

	}
}
