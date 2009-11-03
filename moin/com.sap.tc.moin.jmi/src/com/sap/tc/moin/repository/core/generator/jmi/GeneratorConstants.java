package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings( { "unchecked", "nls" } )
public interface GeneratorConstants {

    public final static String GENERATOR_VERSION = "2.0"; //$NON-NLS-1$

    /**
     * JMI names of metamodel elements that should not be generated - Class
     * Element (JMI Name is javax.jmi.reflect.RefObject) in package Reflect (JMI
     * name is javax.jmi.Reflect) is used as most abstract super class of all
     * model elements. It maps to javax.jmi.reflect.RefObject and due to that
     * should not be generated. This class should only be used to create
     * "typeless" references/attributes - Classes OclAny and OclTypeClass are
     * artefacts that are used when importing metamodels which contain OCL
     * constraints in order to handle these constraints
     */
    public static final List JMI_IDENTIFIER_OF_CLASSES_TO_EXCLUDE_FROM_GENERATION = Arrays.asList( new String[] { "javax.jmi.reflect.RefObject", "OclAny", "OclTypeClass" } );

    public static final List JMI_IDENTIFIER_OF_PACKAGES_TO_EXCLUDE_FROM_GENERATION = Arrays.asList( new String[] { "javax.jmi.Reflect" } );

    public static final String NAME_PRIMITIVE_TYPES_PACKAGE = "PrimitiveTypes"; //$NON-NLS-1$

    public static final String NAME_MODEL_PACKAGE = "Model"; //$NON-NLS-1$

    public static final String NAME_OCL_PACKAGE = "OCL"; //$NON-NLS-1$

    public static final char PACKAGE_DELIMITER = '.';

    public static final String PACKAGE_PREFIX_METAMODELID = "package";

    /**
     * Name of the tag containing code for the accessor of a derived attribute
     * and for the accessor of an association end of a derived association. The
     * tag is mandatory for an association end of a derived association if the
     * end is navigable. Otherwise it is ignored.
     */
    public static final String TAG_DERIVATION_CODE = "org.omg.sap2mof.DerivationCodeJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the mutator of a derived attribute.
     * The tag is mandatory if the attribute is changeable. Otherwise it is
     * ignored.
     */
    public static final String TAG_PRODUCTION_CODE = "org.omg.sap2mof.ProductionCodeJava"; //$NON-NLS-1$

    /**
     * Name of tags containing Java or Ocl code for modelled operations.
     */
    public static final String TAG_OPERATION_CODE_JAVA = "org.omg.sap2mof.OperationCodeJava"; //$NON-NLS-1$

    public static final String TAG_OPERATION_CODE_OCL = "org.omg.sap2mof.OperationCodeOcl"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the add method of a derived
     * association The tag is mandatory if both association ends are changeable.
     * If this is not the case, no add method is generated according to the JMI
     * specification and no tag is needed (or a given tag is ignored).
     */
    public static final String TAG_OPERATION_CODE_ADD_JAVA = "org.omg.sap2mof.OperationCodeAddJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the remove method of a derived
     * association The tag is mandatory if both association ends are changeable.
     * If this is not the case, no remove method is generated according to the
     * JMI specification and no tag is needed (or a given tag is ignored).
     */
    public static final String TAG_OPERATION_CODE_REMOVE_JAVA = "org.omg.sap2mof.OperationCodeRemoveJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the exists method of a derived
     * association If the tag is not empty its content is taken as
     * implementation of the exists method. If it is empty, the exists method is
     * going to be calculated from one of the accessors. That implies that the
     * tag is mandatory if none of the association ends is navigable, because
     * then we do not have any accessor.
     */
    public static final String TAG_OPERATION_CODE_EXISTS_JAVA = "org.omg.sap2mof.OperationCodeExistsJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing package prefixes For compatibility reasons,
     * use javax.jmi.packagePrefix instead
     */
    public static final String TAG_IDL_PREFIX = "org.omg.mof.idl_prefix"; //$NON-NLS-1$
}
