package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * The Constant
 */
public interface JmiGeneratorConstant {

    /**
     * @return one of public, protected, private, or empty String
     */
    public String getVisibility( );

    /**
     * @return the fully qualified Java type
     */
    public String getType( );

    /**
     * @return the Java name
     */
    public String getName( );

    /**
     * @return the value as String
     */
    public String getValue( );

    /**
     * @return the Javadoc for an element
     */
    public JmiGeneratorJavadoc getJavadoc( );

    /**
     * @return <code>true</code> if the constant is of type String
     */
    public boolean isString( );
}
