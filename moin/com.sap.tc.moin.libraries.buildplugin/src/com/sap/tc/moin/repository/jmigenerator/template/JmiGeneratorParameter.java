package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * Parameters have a type and a name
 */
public interface JmiGeneratorParameter {

    /**
     * @return the name
     */
    public String getName( );

    /**
     * @return the fully qualified Java type
     */
    public String getType( );

    /**
     * @return the fully qualified Java type, and in case of a Java primitive
     * type the corresponding wrapper type
     */
    public String getJavaType( );

    /**
     * @return the fully qualified generic type parameter
     */
    public String getTypeParameter( );

    /**
     * @return is the parameter an array of the Java type?
     */
    public boolean isArray( );

    /**
     * @return whether the parameter requires unwrapping in the JMI wrapper
     * layer
     */
    public boolean isNeedsToBeUnwrapped( );

    /**
     * @return the name of the parameter
     */
    public String toString( );

    /**
     * @return the operation for which this is a parameter
     */
    public JmiGeneratorClassOperation getOperation( );

    public void setNeedsToBeUnwrapped( boolean needsUnwrapping );

    public boolean isPartitionParameter( );

    public boolean isMultiple( );

    public boolean isObjectTyped( );
}
