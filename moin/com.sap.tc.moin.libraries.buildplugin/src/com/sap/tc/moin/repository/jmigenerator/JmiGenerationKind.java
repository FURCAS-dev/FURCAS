package com.sap.tc.moin.repository.jmigenerator;

/**
 * Indicates the kind of code to be generated
 */
public enum JmiGenerationKind {
    /**
     * Implementations
     */
    CLASS,
    /**
     * Interfaces
     */
    INTERFACE,
    /**
     * Wrappers
     */
    WRAPPER;

    /**
     * @return a filter to generate interfaces only
     */
    public static JmiGenerationKind[] interfaceFilter( ) {

        return new JmiGenerationKind[] { INTERFACE };
    }

    /**
     * @return a filter to generate implementations only
     */
    public static JmiGenerationKind[] implementationFilter( ) {

        return new JmiGenerationKind[] { CLASS };
    }

    /**
     * @return a filter to generate wrappers only
     */
    public static JmiGenerationKind[] wrapperFilter( ) {

        return new JmiGenerationKind[] { WRAPPER };
    }
}
