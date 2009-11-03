package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * This is the abstraction from the MOF "Structural feature", i.e. attributes
 * and references
 */
public interface JmiGeneratorFeature {

    /**
     * @return the feature's name (by which is can be referred to by the
     * reflective methods
     */
    public String getName( );

    /**
     * Some features (e.g. Exception Parameters) don't have names that should
     * not be used in certain JMI fragments, e.g. parameter names. This gives a
     * "corrected" name for these features
     * 
     * @return the corrected name
     */
    public String getJmiName( );

    /**
     * @return the fully qualified Java type of the feature in the interface
     */
    public String getJavaInterfaceType( );

    /**
     * @return the fully qualified Java type of the feature in the
     * implementation
     */
    public String getJavaImplementationType( );

    /**
     * @return <code>true</code> if the feature is multiple
     */
    public Boolean isMultiple( );

    /**
     * @return the Java wrapper type if the type of this feature is primitive,
     * or the interface type
     */
    public String getJavaType( );

    /**
     * @return the fully qualified generic type parameter
     */
    public String getJavaTypeParameter( );

    /**
     * @return <code>true</code> if this feature is changeable via public
     * methods
     */
    public Boolean isChangeable( );

    /**
     * @return the public accessor name (something like getFeatureName)
     */
    public String getAccessorName( );

    /**
     * @return the internal accessor name (something like get__FeatureName)
     */
    public String getAccessorNameInternal( );

    /**
     * @return the public mutator name (something like setFeatureName)
     */
    public String getMutatorName( );

    /**
     * @return the internal mutator name (something like set__FeatureName)
     */
    public String getMutatorNameInternal( );

    /**
     * @return the reference or <code>null</code>
     */
    public JmiGeneratorReference getReference( );

    /**
     * @return the attribute or <code>null</code>
     */
    public JmiGeneratorAttribute getAttribute( );

    /**
     * @return the index in the feature name mapping table
     */
    public Integer getFeatureIndex( );

    /**
     * @return the operation or <code>null</code>
     */
    public JmiGeneratorClassOperation getOperation( );

    /**
     * @return <code>true</code> if the feature is object typed
     */
    public Boolean isObjectTyped( );

    public String getAttributeOrAssociationMofId( );

    public int getToEndNumber( );

    public String getReferenceMofId( );

    public Boolean isSingleValuedNonObjectTyped( );
}
