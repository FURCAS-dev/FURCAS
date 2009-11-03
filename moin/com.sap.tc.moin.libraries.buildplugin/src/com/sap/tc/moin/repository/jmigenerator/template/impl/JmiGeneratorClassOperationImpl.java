package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadoc;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.shared.util.ListMap;

/**
 * The Operation
 */
public class JmiGeneratorClassOperationImpl implements JmiGeneratorClassOperation {

    private final String type;

    private final String typeParameter;

    private final String accessorName;

    private final String substituteName;

    private final List<String> body = new ArrayList<String>( );

    private final List<JmiGeneratorParameter> parameters = new ArrayList<JmiGeneratorParameter>( );

    private final ListMap<String, String> exceptions = new ListMap<String, String>( );

    private String visibility = "public"; //$NON-NLS-1$

    private boolean isMultiple = false;

    private boolean isSetter = false;

    private boolean isDerived = false;

    private String returnInitialValue = "null"; //$NON-NLS-1$

    private String featureName = ""; //$NON-NLS-1$

    private int featureIndex = -1;

    private int operationIndex = -1;

    private String variableName = ""; //$NON-NLS-1$

    private String attributeOrAssociationMofId;

    private String operationMofId;

    private boolean isQueryNeededForNavigation = false;

    private boolean isObjectTyped = false;

    private boolean isReference = false;

    private JmiGeneratorBaseTemplate typeWrapper;

    private JmiGeneratorClassImplTemplate classImplWrapper;

    private boolean wrapResult = true;

    private int endNumberOfToEnd;

    private boolean hasCoreConnection = false;

    private String referenceMofId;

    private boolean noSyncIfResolved = false;

    private boolean needsCoreConnectionInInternalInterface = true;

    private JmiGeneratorJavadoc javadoc = null;

    private Boolean needsToPassCoreConnectionInWrapper = true;

    private String linkVariableName;

    private boolean isReferencedEndComposite = false;

    private String structureTypeMofId;

    /**
     * @param theAccessorName
     * @param theType
     * @param theTypeParameter
     * @param theSubstituteName
     */
    public JmiGeneratorClassOperationImpl( String theAccessorName, String theType, String theTypeParameter, String theSubstituteName ) {

        this.accessorName = theAccessorName;
        this.type = theType;
        this.typeParameter = theTypeParameter;
        this.substituteName = theSubstituteName;
        this.exceptions.put( JmiException.class.getName( ), JmiException.class.getName( ) );
    }

    public String getAccessorName( ) {

        return this.accessorName;
    }

    public List<String> getBody( ) {

        return this.body;
    }

    public List<String> getExceptions( ) {

        return this.exceptions.values( );
    }

    public List<String> getMofExceptions( ) {

        List<String> mofExceptions = new ArrayList<String>( );
        for ( String exception : this.exceptions.values( ) ) {
            if ( !exception.equals( JmiException.class.getName( ) ) ) {
                mofExceptions.add( exception );
            }
        }
        return Collections.unmodifiableList( mofExceptions );
    }

    public List<JmiGeneratorParameter> getParameters( ) {

        return this.parameters;
    }

    public String getType( ) {

        return this.type;
    }

    public String getJavaType( ) {

        return JmiGeneratorParameterImpl.getJavaType( type );
    }

    public String getTypeParameter( ) {

        return this.typeParameter;
    }

    public JmiGeneratorJavadoc getJavadoc( ) {

        return javadoc;
    }

    public String getVisibility( ) {

        return this.visibility;
    }

    /**
     * @param actVisibility
     */
    public void setVisibility( String actVisibility ) {

        this.visibility = actVisibility;
    }

    /**
     * @param actFeatureName
     */
    public void setFeatureName( String actFeatureName ) {

        this.featureName = actFeatureName;
    }

    /**
     * @param actFeatureIndex
     */
    public void setFeatureIndex( int actFeatureIndex ) {

        this.featureIndex = actFeatureIndex;
    }

    /**
     * @param actOperationIndex
     */
    public void setOperationIndex( int actOperationIndex ) {

        this.operationIndex = actOperationIndex;
    }

    /**
     * @param actVariableName
     */
    public void setVariableName( String actVariableName ) {

        this.variableName = actVariableName;
    }

    /**
     * @param multiple
     */
    public void setMultiple( boolean multiple ) {

        this.isMultiple = multiple;
    }

    /**
     * @param reference
     */
    public void setReference( boolean reference ) {

        this.isReference = reference;
    }

    /**
     * @param derived
     */
    public void setDerived( boolean derived ) {

        this.isDerived = derived;
    }

    /**
     * @param setter
     */
    public void setSetter( boolean setter ) {

        this.isSetter = setter;
    }

    /**
     * @param attribute
     */
    public void setObjectTyped( boolean attribute ) {

        this.isObjectTyped = attribute;
    }

    /**
     * @param isQueryNeededForNavigation
     */
    public void setQueryNeededForNavigation( boolean isQueryNeededForNavigation ) {

        this.isQueryNeededForNavigation = isQueryNeededForNavigation;
    }

    public void setEndNumberOfToEnd( int endNumberOfToEnd ) {

        this.endNumberOfToEnd = endNumberOfToEnd;
    }

    public void setAttributeOrAssociationMofId( String mofId ) {

        this.attributeOrAssociationMofId = mofId;
    }

    public void setOperationMofId( String mofId ) {

        this.operationMofId = mofId;
    }

    public void setReferenceMofId( String referenceMofId ) {

        this.referenceMofId = referenceMofId;
    }

    public void setStructureTypeMofId( String structureTypeMofId ) {

        this.structureTypeMofId = structureTypeMofId;
    }

    public String getStructureTypeMofId( ) {

        return structureTypeMofId;
    }

    /**
     * @param theReturnInitialValue
     */
    public void setReturnInitialValue( String theReturnInitialValue ) {

        this.returnInitialValue = theReturnInitialValue;
    }

    /**
     * @param type wrapper
     */
    public void setTypeTemplate( JmiGeneratorBaseTemplate typeWrapper ) {

        this.typeWrapper = typeWrapper;
    }

    /**
     * @param class wrapper
     */
    public void setClassImplTemplate( JmiGeneratorClassImplTemplate classImplWrapper ) {

        this.classImplWrapper = classImplWrapper;
    }

    public void setAnnotation( String annotation ) {

        if ( annotation != null && annotation.length( ) != 0 ) {
            this.javadoc = new JmiGeneratorJavadocImpl( annotation );
        }
    }

    public Boolean isMultiple( ) {

        return Boolean.valueOf( this.isMultiple );
    }

    public Boolean isSetter( ) {

        return Boolean.valueOf( this.isSetter );
    }

    public String getFeatureName( ) {

        return this.featureName;
    }

    public Integer getFeatureIndex( ) {

        return Integer.valueOf( this.featureIndex );
    }

    public Integer getOperationIndex( ) {

        return Integer.valueOf( this.operationIndex );
    }

    public String getReturnInitialValue( ) {

        return this.returnInitialValue;
    }

    public String getVariableName( ) {

        return this.variableName;
    }

    public Boolean isDerived( ) {

        return Boolean.valueOf( this.isDerived );
    }

    public Boolean isObjectTyped( ) {

        return Boolean.valueOf( this.isObjectTyped );
    }

    public Boolean isQueryNeededForNavigation( ) {

        return isQueryNeededForNavigation;
    }

    public String getAttributeOrAssociationMofId( ) {

        return this.attributeOrAssociationMofId;
    }

    public String getOperationMofId( ) {

        return this.operationMofId;
    }

    public int getEndNumberOfToEnd( ) {

        return this.endNumberOfToEnd;
    }

    public String getReferenceMofId( ) {

        return this.referenceMofId;
    }

    public Boolean isReference( ) {

        return Boolean.valueOf( this.isReference );
    }

    public boolean isReferencedEndComposite( ) {

        return isReferencedEndComposite;
    }

    public void setReferencedEndComposite( boolean value ) {

        isReferencedEndComposite = value;
    }

    public JmiGeneratorBaseTemplate getTypeTemplate( ) {

        return this.typeWrapper;
    }

    public JmiGeneratorClassImplTemplate getClassImplTemplate( ) {

        return this.classImplWrapper;
    }

    public String getSubstituteName( ) {

        return this.substituteName;
    }

    public Boolean isVoid( ) {

        return Boolean.valueOf( this.type.equals( "void" ) ); //$NON-NLS-1$
    }

    public Boolean isWrapResult( ) {

        return this.wrapResult;
    }

    public void setWrapResult( boolean wrapResult ) {

        this.wrapResult = wrapResult;
    }

    public Boolean isNoThreadLocal( ) {

        return true;
    }

    public void setHasCoreConnection( boolean hasCoreConnection ) {

        this.hasCoreConnection = hasCoreConnection;
    }

    public Boolean isHasCoreConnection( ) {

        return hasCoreConnection;
    }

    public List<JmiGeneratorParameter> getParametersExceptForCoreConnection( ) {

        List<JmiGeneratorParameter> result = new ArrayList<JmiGeneratorParameter>( getParameters( ) );
        if ( hasCoreConnection ) {
            result.remove( 0 );
        }
        return result;
    }

    public List<JmiGeneratorParameter> getParametersExceptForCoreConnectionAndModelPartition( ) {

        List<JmiGeneratorParameter> result = new ArrayList<JmiGeneratorParameter>( getParameters( ) );
        if ( hasCoreConnection ) {
            result.remove( 0 );
        }
        for ( Iterator<JmiGeneratorParameter> it = result.iterator( ); it.hasNext( ); ) {
            JmiGeneratorParameter param = it.next( );
            if ( param.getJavaType( ).equals( ModelPartition.class.getName( ) ) ) {
                it.remove( );
            }
        }
        return result;
    }

    public Boolean isHasModelPartition( ) {

        for ( Iterator<JmiGeneratorParameter> it = getParameters( ).iterator( ); it.hasNext( ); ) {
            JmiGeneratorParameter param = it.next( );
            if ( param.getJavaType( ).equals( ModelPartition.class.getName( ) ) ) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Boolean isNoSyncIfResolved( ) {

        return this.noSyncIfResolved;
    }

    public void setNoSyncIfResolved( boolean noSyncIfResolved ) {

        this.noSyncIfResolved = noSyncIfResolved;
    }

    public Boolean needsCoreConnectionInInternalInterface( ) {

        return needsCoreConnectionInInternalInterface;
    }

    public void setNeedsCoreConnectionInInternalInterface( boolean value ) {

        needsCoreConnectionInInternalInterface = value;
    }

    public Boolean isNeedsToPassCoreConnectionInWrapper( ) {

        return needsToPassCoreConnectionInWrapper;
    }

    public void setNeedsToPassCoreConnectionInWrapper( boolean value ) {

        needsToPassCoreConnectionInWrapper = value;
    }

    public String getLinkVariableName( ) {

        return linkVariableName;
    }

    public void setLinkVariableName( String value ) {

        linkVariableName = value;
    }

    public void clearExceptions( ) {

        this.exceptions.clear( );
    }

    public void addExceptions( List<String> exceptions ) {

        for ( String exception : exceptions ) {
            this.exceptions.put( exception, exception );
        }
    }

    public void addExceptions( int index, List<String> exceptions ) {

        for ( String exception : exceptions ) {
            this.exceptions.put( index++, exception, exception );
        }
    }

    public boolean isOperationForReferenceOrObjectValuedAttribute( ) {

        return isReference( ) || isObjectTyped( );
    }
}
