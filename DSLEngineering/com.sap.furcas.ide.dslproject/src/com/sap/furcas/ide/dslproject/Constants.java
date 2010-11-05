package com.sap.furcas.ide.dslproject;

/**
 * primitive constants for multiple use within other java code.
 * 
 * @author C5107456
 */
public interface Constants {

    /**
     * Extention for files which the builder will attempt to handle when
     * changed.
     */
    String TCS_EXTENSION = ".tcs";

    /** qualifier for all project persistent properties. */
    String METAMODEL_PERSISTENT_PROPERTY_QUALIFIER = "metamodelQualifier";

    /** key for referring to a deployed metamodel by its container name. */
    String DEPLOYED_METAMODEL_CONTAINER_NAME_KEY = "metamodelProperty";

    /** key for referring to a referred project in the workspace by name. */
    String REFERRED_PROJECT_NAME_KEY = "metamodelProperty";

    /**
     * used to configure a project to use a certain way of referring to a
     * metamodel.
     */
    String PROJECT_METAREF_PROPERTY = "MetaModelRefProperty";

    /** The Constant MOIN_METAMODEL_NATURE_ID. */
    String MOIN_METAMODEL_NATURE_ID = "com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelNature";

}
