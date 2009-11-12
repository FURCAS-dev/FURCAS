package com.sap.ide.moftool.editor.core;

public interface MOFToolConstants {

	/**
	 * The diagram type ID for MOF class diagrams
	 */
	public static final String CLASS_DIAGRAM_TYPE_ID = "com.sap.ide.moftool.class"; //$NON-NLS-1$

	/**
	 * General property value (used for various of the following properties
	 */
	public static final String VALUE_YES = "yes"; //$NON-NLS-1$
	public static final String VALUE_NO = "no"; //$NON-NLS-1$

	/**
	 * Property to set for a connection that indicates that the decorators should
	 * be visible or not. Possible values are {@link #VALUE_YES} and {@link #VALUE_NO}.
	 * Used for connections of type association and composition.
	 */
	public static final String PROPERTY_DECORATORS_VISIBLE = "visible"; //$NON-NLS-1$

	/**
	 * Name of link property for name text decorator associated with a connection (association or
	 * composition name). The value does not matter.
	 */
	public static final String ASSOCIATION_NAME = "associationName"; //$NON-NLS-1$

	/**
	 * Name of link property for name text decorator associated with a connection end (association
	 * or composition end name). The value does not matter.
	 */
	public static final String ASSOCIATION_END_NAME = "associationEndName"; //$NON-NLS-1$

	/**
	 * Name of link property for multiplicity text decorator associated with a connection end
	 * (association or composition end multiplicity). The value does not matter.
	 */
	public static final String MULTIPLICITY = "multiplicity"; //$NON-NLS-1$

	/**
	 * Name of property for the decorator displaying the navigation status of a
	 * connection end. Possible values are {@link #VALUE_YES} and {@link #VALUE_NO}.
	 * Used for associations and compositions
	 */
	public static final String NAVIGABLE = "navigable"; //$NON-NLS-1$

	/**
	 * Name of property for the decorator displaying the composition status of a
	 * connection end. Possible values are {@link #VALUE_YES} and {@link #VALUE_NO}.
	 * Used for associations and compositions.
	 */
	public static final String COMPOSITE = "composite"; //$NON-NLS-1$
	
	/**
	 * Name of property for the decorator displaying the storage status of a
	 * connection end. Possible values are {@link #VALUE_YES} and {@link #VALUE_NO}.
	 * Used for associations and compositions.
	 */
	public static final String STORAGE = "storage"; //$NON-NLS-1$

	/**
	 * Name of property to identify the different compartments used in the MOF editor
	 * compartment pattern. Currently only one special compartment exists, namely the
	 * header compartment; all others (attributes and operations for classes, fields for
	 * structure types, labels for enumerations) are standard compartments without any special
	 * marking. Nevertheless these other compartments are numbered
	 */
	public static final String PROPERTY_COMPARTMENT_TYPE = "COMPARTMENT_TYPE"; //$NON-NLS-1$
	
	/**
	 * The header compartment type identification property. See {@link #PROPERTY_COMPARTMENT_TYPE}.
	 */
	public static final String COMPARTMENT_TYPE_HEADER = "compartmentTypeHeader"; //$NON-NLS-1$
	
	/**
	 * Name of property to define the number of a compartment in the MOF editor 
	 * compartment pattern.
	 */
	public static final String COMPARTMENT_NUMBER = "compartmentNumber"; //$NON-NLS-1$

	/**
	 * Property name for storing at the generalization connection
	 */
	public static final String CON_PROPERTY_GENERALIZATION = "generalization"; //$NON-NLS-1$
	
	public static final String VOID_RETURN_TYPE = "void"; //$NON-NLS-1$
	public static final String COLLAPSE_FEATURE = "collapseStructuralFeature"; //$NON-NLS-1$
	public static final String EMPTY_SHAPE = "emptyShape"; //$NON-NLS-1$
}
