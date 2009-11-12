package com.sap.ide.moftool.editor.graphics;

public interface IImageConstants {
	public static final String PRE = "com.sap.ide.moftool.editor.graphics."; //$NON-NLS-1$
	
	// Main objects
	public static final String IMG_CLASS = PRE + "img_class"; //$NON-NLS-1$
	public static final String IMG_ENUMERATION_TYPE = PRE + "img_enum_type"; //$NON-NLS-1$
	public static final String IMG_STRUCTURE_TYPE = PRE + "img_struc_type"; //$NON-NLS-1$
	public static final String IMG_CLASS_DIAGRAM = PRE + "img_class_diagram"; //$NON-NLS-1$
	public static final String IMG_ASSOCIATION = PRE + "img_association"; //$NON-NLS-1$
	public static final String IMG_COMPOSITION = PRE + "img_composition"; //$NON-NLS-1$
	public static final String IMG_GENERALIZATION = PRE + "img_generalization"; //$NON-NLS-1$

	// Speed buttons
	public static final String IMG_CREATE_ATTRIBUTE = PRE + "img_create_attribute"; //$NON-NLS-1$
	public static final String IMG_CREATE_OPERATION = PRE + "img_create_operation"; //$NON-NLS-1$
	public static final String IMG_NEW_SUPERCLASS = PRE + "img_new_superclass"; //$NON-NLS-1$
	
	// Empty image for compartments (compatibility with existing diagrams)
	public static final String IMG_EMPTY = PRE + "img_empty"; //$NON-NLS-1$

	
	
	// Reworked until here

	// connection
	public static final String IMG_MODIFIER_SUPCLASS_OBJ = PRE + "mod.supClass.obj"; //$NON-NLS-1$
	public static final String IMG_MODIFIER_SUBCLASS_OBJ = PRE + "mod.subClass.obj"; //$NON-NLS-1$

	// operations
	public static final String IMG_ADD_ASSOCIATION_OBJ = PRE + "mod.addAssociation.obj"; //$NON-NLS-1$

	public static final String IMG_NEWLABEL_OBJ = PRE+"mod.newLabel.obj"; //$NON-NLS-1$

	public static final String IMG_NEWSTRUCTUREFIELD_OBJ = PRE+"mod.newStructureField.obj"; //$NON-NLS-1$
}
