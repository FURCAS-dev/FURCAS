package com.sap.tc.moin.repository.jmigenerator.template;


/**
 * Packages can import features
 */
public interface JmiGeneratorPackageFeature extends JmiGeneratorFeature {

    /**
     * @return <code>true</code> if the feature is imported
     */
    public Boolean isImported( );

    /**
     * @return the interface type of the feature's proxy
     */
    public String getJavaProxyInterfaceType( );

    /**
     * @return the implementation type of the feature's proxy
     */
    public String getJavaProxyImplementationType( );

    /**
     * @return <code>true</code> if the result is to be wrapped (i.e. not a
     * primitive type)
     */
    public Boolean isWrapResult( );

    // TEMPORARY !!!
    public Boolean isNoThreadLocal( );

    public Boolean isNeedsToPassCoreConnectionInWrapper( );

    /**
     * @return the fully qualified Java return type
     */
    public String getType( );

    /**
     * @return the fully qualified generic return type parameter
     */
    public String getTypeParameter( );
}
