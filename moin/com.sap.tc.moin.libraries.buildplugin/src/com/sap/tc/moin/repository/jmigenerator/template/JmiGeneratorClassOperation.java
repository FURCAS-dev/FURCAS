package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * Used to generate java operations
 */
public interface JmiGeneratorClassOperation {

    /**
     * @return one of public, protected, private, or an empty String
     */
    public String getVisibility( );

    /**
     * @return the fully qualified Java return type
     */
    public String getType( );

    /**
     * @return the fully qualified Java return type, and in case of a Java
     * primitive type the corresponding wrapper type
     */
    public String getJavaType( );

    /**
     * @return the fully qualified generic return type parameter
     */
    public String getTypeParameter( );

    /**
     * @return the Javadoc for an element
     */
    public JmiGeneratorJavadoc getJavadoc( );

    /**
     * @return the list of Parameters (may be empty)
     */
    public List<JmiGeneratorParameter> getParameters( );

    public List<JmiGeneratorParameter> getParametersExceptForCoreConnection( );

    public List<JmiGeneratorParameter> getParametersExceptForCoreConnectionAndModelPartition( );

    /**
     * @return the List of (fully qualified) Exceptions (may be empty)
     */
    public List<String> getExceptions( );

    /**
     * @return the List of (fully qualified) MOF modeled Exceptions (may be
     * empty)
     */
    public List<String> getMofExceptions( );

    /**
     * @return the operation body or <code>null</code>
     */
    public List<String> getBody( );

    /**
     * @return the operation's name in Java
     */
    public String getAccessorName( );

    /**
     * @return the substitute name
     */
    public String getSubstituteName( );

    /**
     * @return <code>true</code> if the return type is a <code>Collection</code>
     */
    public Boolean isMultiple( );

    /**
     * @return <code>true</code> if the operation is a mutator
     */
    public Boolean isSetter( );

    /**
     * @return true if the return type is void
     */
    public Boolean isVoid( );

    /**
     * @return the variable name if this operation relates to a variable
     */
    public String getVariableName( );

    /**
     * @return the feature to which this operation relates
     */
    public String getFeatureName( );

    /**
     * @return the index in the feature name mapping table
     */
    public Integer getFeatureIndex( );

    /**
     * @return the index in the operation name mapping table
     */
    public Integer getOperationIndex( );

    /**
     * @return the initial value for the return variable or null
     */
    public String getReturnInitialValue( );

    /**
     * @return <code>true</code> if the operation is "derived", i.e. relates to
     * a reference based on a derived attribute
     */
    public Boolean isDerived( );

    /**
     * @return <code>true</code> if the operation relates to an object-typed
     * attribute
     */
    public Boolean isObjectTyped( );

    /**
     * @return <code>true</code> if the operation relates to a reference
     * (instead of an attribute)
     */
    public Boolean isReference( );

    /**
     * @return the template referring to the operation's return type or
     * <code>null</code>
     */
    public JmiGeneratorBaseTemplate getTypeTemplate( );

    /**
     * @return the template referring to the operation's composite class or
     * <code>null</code>
     */
    public JmiGeneratorClassImplTemplate getClassImplTemplate( );

    public String getAttributeOrAssociationMofId( );

    public String getOperationMofId( );

    public int getEndNumberOfToEnd( );

    public String getReferenceMofId( );

    public String getStructureTypeMofId( );

    /**
     * @return <code>true</code> if a query is needed in order to navigate,
     * <code>false</code> otherwise.
     */
    public Boolean isQueryNeededForNavigation( );

    /**
     * @return <code>true</code> if the return value of the getter needs to be
     * wrapped, <code>false</code> otherwise.
     */
    public Boolean isWrapResult( );

    public Boolean isNoThreadLocal( );

    public void setHasCoreConnection( boolean hasCoreConnection );

    public Boolean isHasCoreConnection( );

    public Boolean isHasModelPartition( );

    public Boolean isNoSyncIfResolved( );

    public Boolean needsCoreConnectionInInternalInterface( );

    public Boolean isNeedsToPassCoreConnectionInWrapper( );

    public String getLinkVariableName( );

    public void setLinkVariableName( String value );

    /**
     * If the operation is a method for a MOF reference, this method returns
     * whether the referenced association end is composite.
     */
    public boolean isReferencedEndComposite( );

    public boolean isOperationForReferenceOrObjectValuedAttribute( );
}
