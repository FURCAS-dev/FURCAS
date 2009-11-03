package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofExceptionInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAttributeDeclaration;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperationDervied;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadoc;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorTypedElementInitialization;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassInterfaceInternalTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassInterfaceTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassOperationImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassProxyImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassProxyInterfaceInternalTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassProxyInterfaceTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassProxyWrapperTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassWrapperTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorFeatureImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorParameterImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorTypedElementInitializationImpl;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Wraps a MofClass
 */
public class JmiGeneratorClassWrapper extends JmiGeneratorClassOrPackageWrapper {

    private final static String EXTENSION_CLASS = "Class"; //$NON-NLS-1$

    private final class JmiGeneratorClassOperationDerived implements JmiGeneratorClassOperationDervied {

        private final String accessor;

        private final String assocType;

        private final String assocEndName;

        private final Boolean multiple;

        private final String type;

        private final String typeParameter;

        private final String featureName;

        private int featureIndex = -1;

        private List<String> exceptions = new ArrayList<String>( );

        private boolean hasCoreConnection = false;

        private List<JmiGeneratorParameter> parameters = new ArrayList<JmiGeneratorParameter>( );

        private ReferenceInternal reference;

        private final String assocImplType;

        private boolean needsCoreConnectionInInternalInterface = true;

        protected JmiGeneratorClassOperationDerived( String actAccessor, String actAssocType, String actAssocImplType, String assocEndName, Boolean multiple, String type, String typeParameter, String featureName, Reference reference ) {

            this.accessor = actAccessor;
            this.assocType = actAssocType;
            this.assocImplType = actAssocImplType;
            this.assocEndName = assocEndName;
            this.multiple = multiple;
            this.type = type;
            this.typeParameter = typeParameter;
            this.featureName = featureName;
            this.reference = (ReferenceInternal) reference;
        }

        public Boolean isSetter( ) {

            return Boolean.FALSE;
        }

        public Boolean isMultiple( ) {

            return this.multiple;
        }

        public String getVisibility( ) {

            return "public"; //$NON-NLS-1$
        }

        public String getVariableName( ) {

            return null;
        }

        public String getType( ) {

            return this.type;
        }

        public String getJavaType( ) {

            return null;
        }

        public String getTypeParameter( ) {

            return this.typeParameter;
        }

        public JmiGeneratorJavadoc getJavadoc( ) {

            return null;
        }

        public String getReturnInitialValue( ) {

            return null;
        }

        public List<JmiGeneratorParameter> getParameters( ) {

            return this.parameters;
        }

        public String getFeatureName( ) {

            return this.featureName;
        }

        public void setFeatureIndex( int actFeatureIndex ) {

            this.featureIndex = actFeatureIndex;
        }

        public Integer getFeatureIndex( ) {

            return Integer.valueOf( this.featureIndex );
        }

        public Integer getOperationIndex( ) {

            return null;
        }

        public List<String> getExceptions( ) {

            return this.exceptions;
        }

        public List<String> getMofExceptions( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public List<String> getBody( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public String getAccessorName( ) {

            return this.accessor;
        }

        public String getAssociationType( ) {

            return this.assocType;
        }

        public String getAssociationImplementationType( ) {

            return this.assocImplType;
        }

        public String getAssociationEndName( ) {

            return this.assocEndName;
        }

        public Boolean isDerived( ) {

            return Boolean.TRUE;
        }

        public Boolean isObjectTyped( ) {

            // TODO Auto-generated method stub
            return Boolean.FALSE;
        }

        public Boolean isReference( ) {

            return Boolean.TRUE;
        }

        public JmiGeneratorBaseTemplate getTypeTemplate( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public JmiGeneratorClassImplTemplate getClassImplTemplate( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public String getSubstituteName( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public Boolean isQueryNeededForNavigation( ) {

            // TODO Auto-generated method stub
            return Boolean.FALSE;
        }

        public Boolean isVoid( ) {

            return Boolean.valueOf( this.type.equals( "void" ) ); //$NON-NLS-1$
        }

        public Boolean isWrapResult( ) {

            return Boolean.TRUE;
        }

        public Boolean isNoThreadLocal( ) {

            return Boolean.TRUE;
        }

        public void setHasCoreConnection( boolean hasCoreConnection ) {

            this.hasCoreConnection = hasCoreConnection;
        }

        public Boolean isHasCoreConnection( ) {

            return this.hasCoreConnection;
        }

        public List<JmiGeneratorParameter> getParametersExceptForCoreConnection( ) {

            return Collections.emptyList( );
        }

        public List<JmiGeneratorParameter> getParametersExceptForCoreConnectionAndModelPartition( ) {

            return Collections.emptyList( );
        }

        public String getAttributeOrAssociationMofId( ) {

            return ( (AssociationEndInternal) this.reference.getReferencedEnd( connection ) ).getContainer( connection ).refMofId( );
        }

        public int getEndNumberOfToEnd( ) {

            throw new MoinUnsupportedOperationException( JmiGeneratorTraces.GETENDNUMBEROFTOENDNOTSUPPORTED );
        }

        public String getReferenceMofId( ) {

            return this.reference.refMofId( );
        }

        public String getOperationMofId( ) {

            return null;
        }

        public Boolean isNoSyncIfResolved( ) {

            return Boolean.FALSE;
        }

        public Boolean needsCoreConnectionInInternalInterface( ) {

            return this.needsCoreConnectionInInternalInterface;
        }

        public void setNeedsCoreConnectionInInternalInterface( boolean value ) {

            this.needsCoreConnectionInInternalInterface = value;
        }

        public Boolean isHasModelPartition( ) {

            return Boolean.FALSE;
        }

        public Boolean isNeedsToPassCoreConnectionInWrapper( ) {

            return Boolean.TRUE;
        }

        public String getLinkVariableName( ) {

            // not relevant
            return null;
        }

        public void setLinkVariableName( String value ) {

            // not relevant
        }

        public boolean isReferencedEndComposite( ) {

            // not relevant
            return false;
        }

        public String getStructureTypeMofId( ) {

            // not relevant
            return null;
        }

        public boolean isOperationForReferenceOrObjectValuedAttribute( ) {

            // not relevant
            return false;
        }
    }

    private final MofClassInternal wrappedClass;

    /**
     * @param connection
     * @param metamodelName
     * @param theClass
     * @param generator
     */
    public JmiGeneratorClassWrapper( CoreConnection connection, String metamodelName, MofClass theClass, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, theClass, null, generator );
        this.wrappedClass = (MofClassInternal) theClass;
    }

    @Override
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified ) {

        StringBuilder sb = new StringBuilder( );
        if ( qualified ) {
            sb.append( getJavaPackageNameQualified( genKind ) );
            sb.append( Utilities.JAVA_PACKAGE_DELIMITER );
        }
        switch ( genKind ) {
            case CLASS:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_IMPLEMENTATION );
                return sb.toString( );

            case INTERFACE:
                sb.append( getJMIIdentifier( ) );
                return sb.toString( );

            case WRAPPER:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_WRAPPER );
                return sb.toString( );

            default:
                throw new MoinUnsupportedOperationException( "getJavaClassName" ); //$NON-NLS-1$
        }
    }

    /**
     * @param genKind
     * @param qualified
     * @return the Java class name for the class proxy
     */
    public String getJavaProxyClassName( JmiGenerationKind genKind, boolean qualified ) {

        StringBuilder sb = new StringBuilder( );
        if ( qualified ) {
            sb.append( getJavaPackageNameQualified( genKind ) );
            sb.append( Utilities.JAVA_PACKAGE_DELIMITER );
        }
        switch ( genKind ) {
            case CLASS:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_CLASS );
                sb.append( EXTENSION_IMPLEMENTATION );
                return sb.toString( );

            case INTERFACE:
                if ( JmiGeneratorBaseWrapper.noClassProxy( ) ) {
                    return CLASS_REFCLASSAPI;
                }
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_CLASS );
                return sb.toString( );


            case WRAPPER:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_CLASS );
                sb.append( EXTENSION_WRAPPER );
                return sb.toString( );

            default:
                throw new MoinUnsupportedOperationException( "getJavaProxyClassName" ); //$NON-NLS-1$
        }
    }

    @Override
    public JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName ) {

        switch ( genKind ) {
            case INTERFACE:
                if ( templateName.equals( "ClassProxyInterface" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorClassProxyInterfaceTemplateImpl( this );
                }
                return new JmiGeneratorClassInterfaceTemplateImpl( this );
            case CLASS:
                if ( templateName.equals( "ClassProxyImpl" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorClassProxyImplTemplateImpl( this );
                } else if ( templateName.equals( "ClassInterfaceInternal" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorClassInterfaceInternalTemplateImpl( this );
                } else if ( templateName.equals( "ClassProxyInterfaceInternal" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorClassProxyInterfaceInternalTemplateImpl( this );
                }
                return new JmiGeneratorClassImplTemplateImpl( this );
            case WRAPPER:
                if ( templateName.equals( "ClassProxyWrapper" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorClassProxyWrapperTemplateImpl( this );
                }
                return new JmiGeneratorClassWrapperTemplateImpl( this );

            default:
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
        }
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        return this.getExtends( genKind, qualified, false );
    }

    /**
     * @param genKind
     * @param qualified
     * @param proxy
     * @return the fully qualified base class
     */
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified, boolean proxy ) {

        List<String> result = new ArrayList<String>( );
        if ( proxy ) {
            switch ( genKind ) {
                case INTERFACE:
                    result.add( CLASS_REFCLASSAPI );
                    break;

                case CLASS:
                    result.add( CLASS_REFCLASSIMPL );
                    break;

                default:
                    throw new MoinUnsupportedOperationException( "getExtends" ); //$NON-NLS-1$
            }
        } else {
            switch ( genKind ) {
                case CLASS:
                    if ( qualified ) {
                        result.add( CLASS_REFOBJIMPL );
                    } else {
                        result.add( CLASS_REFOBJIMPL.substring( CLASS_REFOBJIMPL.lastIndexOf( '.' ) + 1 ) );
                    }
                    break;
                case INTERFACE:
                    List<String> qnames = new ArrayList<String>( );
                    JmiList<ModelElement> stypes = (JmiList) ( (MofClassInternal) this.wrappedClass ).getSupertypes( this.connection );
                    for ( Iterator<ModelElement> iterator = stypes.iteratorReadOnly( this.connection.getSession( ) ); iterator.hasNext( ); ) {
                        ModelElementInternal st = (ModelElementInternal) iterator.next( );
                        qnames.add( ( (JmiGeneratorClassWrapper) getOrCreateWrapper( st ) ).getJavaClassName( JmiGenerationKind.INTERFACE, true ) );
                    }
                    if ( qnames.isEmpty( ) ) {
                        qnames.add( CLASS_REFOBJAPI );
                    }
                    if ( qualified ) {
                        result.addAll( qnames );
                    } else {
                        for ( String qname : qnames ) {
                            result.add( qname.substring( qname.lastIndexOf( '.' ) + 1 ) );
                        }
                    }
                    break;
                default:
                    throw new MoinUnsupportedOperationException( "getExtends" ); //$NON-NLS-1$
            }
        }
        return result;
    }

    /**
     * @param genKind
     * @param staticOnly
     * @return the feature IDs for the generated JMI class
     */
    public List<String> getFeatureIds( JmiGenerationKind genKind, boolean classifierLevel ) {

        List<String> result = new ArrayList<String>( );

        Iterator<ModelElement> iterator;
        switch ( genKind ) {
            case INTERFACE:
                iterator = getContent( );
                break;

            case CLASS:
                iterator = getAllContent( );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getFeatureIds" ); //$NON-NLS-1$
        }

        for ( ; iterator.hasNext( ); ) {

            ModelElement child = iterator.next( );
            if ( child instanceof StructuralFeature ) {
                StructuralFeature structuralFeature = (StructuralFeature) child;
                boolean isClassifierLevel = structuralFeature.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( isClassifierLevel != classifierLevel ) {
                    continue;
                }
                result.add( child.getName( ) );
            }
        }

        return result;
    }

    /**
     * @param genKind
     * @param staticOnly
     * @return the operation IDs for the generated JMI class
     */
    public List<String> getOperationIds( JmiGenerationKind genKind, boolean classifierLevel ) {

        List<String> result = new ArrayList<String>( );

        Iterator<ModelElement> iterator;
        switch ( genKind ) {
            case INTERFACE:
                iterator = this.getContent( );
                break;
            case CLASS:
                iterator = this.getAllContent( );
                break;
            case WRAPPER:
                iterator = this.getAllContent( );
                break;
            default:
                throw new MoinUnsupportedOperationException( "getOperationIds" ); //$NON-NLS-1$
        }

        for ( ; iterator.hasNext( ); ) {
            ModelElement child = iterator.next( );
            if ( child instanceof Operation ) {
                Operation operation = (Operation) child;
                boolean isClassifierLevel = operation.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( isClassifierLevel != classifierLevel ) {
                    continue;
                }
                result.add( child.getName( ) );
            }
        }
        return result;
    }

    /**
     * @param genKind
     * @param staticOnly
     * @return the features
     */
    public List<JmiGeneratorFeature> getFeatures( JmiGenerationKind genKind, boolean staticOnly ) {

        List<JmiGeneratorFeature> result = new ArrayList<JmiGeneratorFeature>( );
        Iterator<ModelElement> myChildren;

        switch ( genKind ) {
            case INTERFACE:
                myChildren = this.getContent( );
                break;

            case CLASS:
                myChildren = this.getAllContent( );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getFeatures" ); //$NON-NLS-1$
        }

        List<String> featureIds = getFeatureIds( genKind, staticOnly );

        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal child = (ModelElementInternal) myChildren.next( );
            if ( child instanceof AttributeInternal ) {
                boolean isStatic = ( (AttributeInternal) child ).getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( isStatic != staticOnly ) {
                    continue;
                }
                JmiGeneratorFeatureImpl feature = new JmiGeneratorFeatureImpl( (JmiGeneratorAttributeWrapper) getOrCreateWrapper( child ) );

                feature.setIndex( featureIds.indexOf( feature.getName( ) ) );
                result.add( feature );
            } else if ( child instanceof Reference ) {
                boolean isStatic = ( (Reference) child ).getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( isStatic != staticOnly ) {
                    continue;
                }
                JmiGeneratorFeatureImpl feature = new JmiGeneratorFeatureImpl( (JmiGeneratorReferenceWrapper) getOrCreateWrapper( child ) );
                feature.setIndex( featureIds.indexOf( feature.getName( ) ) );
                result.add( feature );
            }
        }

        return result;
    }

    @Override
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified ) {

        return this.getImplements( genKind, qualified, false );
    }

    /**
     * @param genKind
     * @param qualified
     * @param proxy
     * @return the fully qualified implemented interfaces
     */
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified, boolean proxy ) {

        List<String> result = new ArrayList<String>( );
        if ( genKind == JmiGenerationKind.CLASS ) {
            if ( proxy ) {
                if ( isMofModelElement( ) ) {
                    result.add( getJavaProxyClassName( JmiGenerationKind.INTERFACE, qualified ) ); // FIXME MOF Impls must not implement JMI interfaces!
                    String nameOfInternalInterface = getJavaProxyClassName( JmiGenerationKind.CLASS, qualified );
                    nameOfInternalInterface = nameOfInternalInterface.substring( 0, nameOfInternalInterface.lastIndexOf( "Impl" ) ) + "Internal"; //$NON-NLS-1$  //$NON-NLS-2$
                    result.add( nameOfInternalInterface );
                }
            } else {
                if ( isMofModelElement( ) ) {
                    result.add( getJavaClassName( JmiGenerationKind.INTERFACE, qualified ) ); // // FIXME MOF Impls must not implement JMI interfaces!
                    String nameOfInternalInterface = getJavaClassName( JmiGenerationKind.CLASS, qualified );
                    nameOfInternalInterface = nameOfInternalInterface.substring( 0, nameOfInternalInterface.lastIndexOf( "Impl" ) ) + "Internal"; //$NON-NLS-1$  //$NON-NLS-2$
                    result.add( nameOfInternalInterface );
                }
            }
        } else if ( genKind == JmiGenerationKind.INTERFACE ) {
            // nothing
        } else {
            throw new MoinUnsupportedOperationException( "getImplements" ); //$NON-NLS-1$
        }
        return result;
    }

    /**
     * @param genKind
     * @param getStatic
     * @return the attributes
     */
    public List<JmiGeneratorClassOperation> getAttributeOperations( JmiGenerationKind genKind, boolean getStatic ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        Iterator<ModelElement> iterator;
        List<String> featureIds = getFeatureIds( genKind, getStatic );

        switch ( genKind ) {
            case INTERFACE:
                if ( getStatic ) {
                    iterator = this.getAllContent( );
                } else {
                    iterator = this.getContent( );
                }
                break;

            case CLASS:
                iterator = this.getAllContent( );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getAttributeOperations" ); //$NON-NLS-1$
        }

        switch ( genKind ) {
            case INTERFACE:
                for ( ; iterator.hasNext( ); ) {
                    ModelElement me = iterator.next( );
                    if ( me instanceof AttributeInternal ) {
                        AttributeInternal attribute = (AttributeInternal) me;
                        String annotation = attribute.getAnnotation( );
                        if ( !attribute.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                            continue;
                        }
                        boolean isStatic = attribute.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                        if ( getStatic != isStatic ) {
                            continue;
                        }
                        // Accessor
                        String accessor = getAccessorNameForTypedElement( attribute );
                        String substituteName = getSubstituteIdentifier( attribute );
                        final String type = getAttributeType( attribute );
                        String typeParameter = getStructuralFeatureTypeParameter( attribute );
                        Classifier nonAliasType = getJmiHelper( ).getNonAliasType( this.connection.getSession( ), attribute.getType( connection ) );
                        JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 && ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) ) {
                            op.setWrapResult( false );
                            op.setNoSyncIfResolved( true );
                            op.setNeedsCoreConnectionInInternalInterface( false );
                            op.setNeedsToPassCoreConnectionInWrapper( false );
                        }
                        op.setAnnotation( annotation );
                        result.add( op );
                        // mutator
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            String mutator = getMutatorNameForTypedElement( attribute );
                            op = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                            op.setSetter( true );
                            JmiGeneratorParameterImpl param = new JmiGeneratorParameterImpl( "newValue", type, null ); //$NON-NLS-1$
                            if ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) {
                                param.setNeedsToBeUnwrapped( false );
                            }
                            op.getParameters( ).add( param );
                            op.setAnnotation( annotation );
                            result.add( op );
                        }
                    }
                }
                break;
            case CLASS:
                for ( ; iterator.hasNext( ); ) {
                    ModelElement me = iterator.next( );
                    if ( me instanceof Attribute ) {
                        AttributeInternal attribute = (AttributeInternal) me;
                        boolean isStatic = attribute.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                        if ( getStatic != isStatic ) {
                            continue;
                        }
                        // accessor
                        String visibility = mapVisibilityToJava( attribute );
                        String accessor = getAccessorNameForTypedElement( attribute );
                        String substituteName = getSubstituteIdentifier( attribute );

                        String type = getAttributeType( attribute );
                        String typeParameter = getStructuralFeatureTypeParameter( attribute );
                        ClassifierInternal classifier = (ClassifierInternal) attribute.getType( connection );
                        ClassifierInternal nonAliasType = (ClassifierInternal) getJmiHelper( ).getNonAliasType( this.connection.getSession( ), (Classifier) classifier );

                        boolean mofAndDerivedAndCodeFromTag = false;
                        if ( attribute.isDerived( ) ) {
                            JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                            op.setDerived( true );
                            op.setFeatureName( attribute.getName( ) );
                            op.setFeatureIndex( featureIds.indexOf( attribute.getName( ) ) );
                            op.setAttributeOrAssociationMofId( attribute.refMofId( ) );
                            op.setEndNumberOfToEnd( getToEndNumber( attribute ) );
                            op.setVisibility( visibility );
                            List<String> body = op.getBody( );
                            Tag bodyTag = getTag( attribute, TAG_DERIVATION_CODE );
                            if ( bodyTag != null ) {
                                if ( isMofElement( attribute ) ) {
                                    body.add( 0, GET_CURRENT_CONNECTION_STATEMENT );
                                    mofAndDerivedAndCodeFromTag = true;
                                }
                                body.add( "// begin of implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                                body.add( bodyTag.getValues( ).get( 0 ) );
                                body.add( "// end of implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                            } else {
                                body.add( type + " result = " + getJavaReturnInitialValueByType( type ) + ";" ); //$NON-NLS-1$ //$NON-NLS-2$
                                body.add( "// missing an implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                                body.add( "return result;" ); //$NON-NLS-1$
                            }
                            if ( attribute.getMultiplicity( ).getUpper( ) == 1 && ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) ) {
                                op.setWrapResult( false );
                            }
                            result.add( op );
                            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                            op2.setDerived( op.isDerived( ) );
                            op2.setFeatureName( op.getFeatureName( ) );
                            op2.setFeatureIndex( op.getFeatureIndex( ) );
                            op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                            op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                            op2.setVisibility( op.getVisibility( ) );
                            op2.getBody( ).addAll( op.getBody( ) );
                            if ( mofAndDerivedAndCodeFromTag ) {
                                op2.getBody( ).remove( 0 );
                                mofAndDerivedAndCodeFromTag = false;
                            }
                            op2.setWrapResult( op.isWrapResult( ) );
                            addCoreConnectionParameter( op2.getParameters( ) );
                            op2.setHasCoreConnection( true );
                            result.add( op2 );
                        } else { // non-derived attribute

                            if ( classifier instanceof MofClass ) {
                                accessor = getAccessorNameForTypedElement( attribute );
                                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                                op.setFeatureName( attribute.getName( ) );
                                op.setFeatureIndex( featureIds.indexOf( attribute.getName( ) ) );
                                op.setAttributeOrAssociationMofId( attribute.refMofId( ) );
                                op.setEndNumberOfToEnd( getToEndNumber( attribute ) );
                                op.setMultiple( attribute.getMultiplicity( ).getUpper( ) != 1 );
                                op.setQueryNeededForNavigation( isQueryNeededForNavigation( attribute ) );
                                op.setObjectTyped( true );
                                op.setLinkVariableName( "__" + attribute.getName( ) ); //$NON-NLS-1$
                                result.add( op );
                                JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                                op2.setFeatureName( op.getFeatureName( ) );
                                op2.setFeatureIndex( op.getFeatureIndex( ) );
                                op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                                op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                                op2.setMultiple( op.isMultiple( ) );
                                op2.setQueryNeededForNavigation( op.isQueryNeededForNavigation( ) );
                                op2.setObjectTyped( op.isObjectTyped( ) );
                                addCoreConnectionParameter( op2.getParameters( ) );
                                op2.setHasCoreConnection( true );
                                op2.setLinkVariableName( op.getLinkVariableName( ) );
                                result.add( op2 );
                            } else {

                                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                                String variableName = composeVariableName( StringUtils.convertFirstCharToLower( getJMIIdentifier( attribute ) ) );
                                op.setVariableName( variableName );
                                op.setFeatureName( attribute.getName( ) );
                                op.setFeatureIndex( featureIds.indexOf( attribute.getName( ) ) );
                                op.setAttributeOrAssociationMofId( attribute.refMofId( ) );
                                op.setEndNumberOfToEnd( getToEndNumber( attribute ) );
                                op.setMultiple( attribute.getMultiplicity( ).getUpper( ) != 1 );
                                op.setQueryNeededForNavigation( isQueryNeededForNavigation( attribute ) );
                                op.setReturnInitialValue( getJavaReturnInitialValueByType( type ) );
                                if ( attribute.getMultiplicity( ).getUpper( ) == 1 && ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) ) {
                                    op.setWrapResult( false );
                                    op.setNoSyncIfResolved( true );
                                    op.setNeedsToPassCoreConnectionInWrapper( false );
                                }
                                result.add( op );
                                if ( op.isWrapResult( ) ) { // no connection-aware method for primitive attributes
                                    JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                                    op2.setVariableName( op.getVariableName( ) );
                                    op2.setFeatureName( op.getFeatureName( ) );
                                    op2.setFeatureIndex( op.getFeatureIndex( ) );
                                    op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                                    op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                                    op2.setMultiple( op.isMultiple( ) );
                                    op2.setQueryNeededForNavigation( op.isQueryNeededForNavigation( ) );
                                    op2.setReturnInitialValue( op.getReturnInitialValue( ) );
                                    op2.setWrapResult( op.isWrapResult( ) );
                                    op2.setNeedsToPassCoreConnectionInWrapper( op.isNeedsToPassCoreConnectionInWrapper( ) );
                                    op2.setNoSyncIfResolved( op.isNoSyncIfResolved( ) );
                                    addCoreConnectionParameter( op2.getParameters( ) );
                                    op2.setHasCoreConnection( true );
                                    result.add( op2 );
                                }
                            }
                        }

                        // mutator
                        if ( classifier instanceof MofClass ) {
                            String mutator = getMutatorNameForTypedElement( attribute );
                            final String pType = getJMIIdentifierQualified( classifier );
                            JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                            String variableName = composeVariableName( StringUtils.convertFirstCharToLower( getJMIIdentifier( attribute ) ) );
                            op.setVariableName( variableName );
                            op.setFeatureName( attribute.getName( ) );
                            op.setFeatureIndex( featureIds.indexOf( attribute.getName( ) ) );
                            op.setAttributeOrAssociationMofId( attribute.refMofId( ) );
                            op.setEndNumberOfToEnd( getToEndNumber( attribute ) );
                            op.setSetter( true );
                            op.setObjectTyped( true );
                            op.setMultiple( attribute.getMultiplicity( ).getUpper( ) != 1 );
                            op.setQueryNeededForNavigation( isQueryNeededForNavigation( attribute ) );
                            op.setDerived( attribute.isDerived( ) );
                            op.getParameters( ).add( new JmiGeneratorParameterImpl( op, "newValue", pType, null, false, true ) ); //$NON-NLS-1$
                            result.add( op );
                            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                            op2.setVariableName( op.getVariableName( ) );
                            op2.setFeatureName( op.getFeatureName( ) );
                            op2.setFeatureIndex( op.getFeatureIndex( ) );
                            op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                            op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                            op2.setSetter( op.isSetter( ) );
                            op2.setObjectTyped( op.isObjectTyped( ) );
                            op2.setMultiple( op.isMultiple( ) );
                            op2.setQueryNeededForNavigation( op.isQueryNeededForNavigation( ) );
                            op2.setDerived( op.isDerived( ) );
                            addCoreConnectionParameter( op2.getParameters( ) );
                            op2.getParameters( ).addAll( op.getParameters( ) );
                            op2.setHasCoreConnection( true );
                            result.add( op2 );
                        } else {
                            String mutator = getMutatorNameForTypedElement( attribute );
                            final String pType = type;
                            JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                            String variableName = composeVariableName( StringUtils.convertFirstCharToLower( getJMIIdentifier( attribute ) ) );
                            op.setVariableName( variableName );
                            op.setFeatureName( attribute.getName( ) );
                            op.setFeatureIndex( featureIds.indexOf( attribute.getName( ) ) );
                            op.setAttributeOrAssociationMofId( attribute.refMofId( ) );
                            op.setEndNumberOfToEnd( getToEndNumber( attribute ) );
                            op.setSetter( true );
                            op.setMultiple( attribute.getMultiplicity( ).getUpper( ) != 1 );
                            op.setQueryNeededForNavigation( isQueryNeededForNavigation( attribute ) );
                            if ( attribute.isDerived( ) ) {
                                op.setDerived( true );

                                List<String> body = op.getBody( );
                                Tag bodyTag = getTag( attribute, TAG_PRODUCTION_CODE );
                                if ( bodyTag != null ) {
                                    body.add( "// begin of implementation provided in tag " + TAG_PRODUCTION_CODE ); //$NON-NLS-1$
                                    body.add( bodyTag.getValues( ).get( 0 ) );
                                    body.add( "// end of implementation provided in tag " + TAG_PRODUCTION_CODE ); //$NON-NLS-1$
                                } else {
                                    body.add( "  // missing an implementation provided in tag " + TAG_PRODUCTION_CODE ); //$NON-NLS-1$
                                }
                            }
                            JmiGeneratorParameterImpl param = new JmiGeneratorParameterImpl( op, "newValue", pType, null, false, false ); //$NON-NLS-1$
                            if ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) {
                                param.setNeedsToBeUnwrapped( false );
                            }
                            op.getParameters( ).add( param );
                            result.add( op );
                            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                            op2.setVariableName( op.getVariableName( ) );
                            op2.setFeatureName( op.getFeatureName( ) );
                            op2.setFeatureIndex( op.getFeatureIndex( ) );
                            op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                            op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                            op2.setSetter( op.isSetter( ) );
                            op2.setMultiple( op.isMultiple( ) );
                            op2.setQueryNeededForNavigation( op.isQueryNeededForNavigation( ) );
                            op2.setDerived( op.isDerived( ) );
                            addCoreConnectionParameter( op2.getParameters( ) );
                            op2.getParameters( ).addAll( op.getParameters( ) );
                            op2.setHasCoreConnection( true );
                            result.add( op2 );
                        }
                    }
                }
                break;

            default:
                break;
        }
        return result;
    }

    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( JmiGenerationKind genKind, boolean getStatic ) {

        List<JmiGeneratorAttributeDeclaration> result = new ArrayList<JmiGeneratorAttributeDeclaration>( );
        switch ( genKind ) {
            case INTERFACE:
                return result;
            case CLASS:
                for ( Iterator<ModelElement> iterator = getAllContent( ); iterator.hasNext( ); ) {
                    ModelElement me = iterator.next( );
                    if ( me instanceof AttributeInternal ) {
                        final AttributeInternal attribute = (AttributeInternal) me;
                        if ( attribute.isDerived( ) || attribute.getType( connection ) instanceof MofClass ) {
                            continue;
                        }
                        boolean isStatic = attribute.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                        if ( getStatic != isStatic ) {
                            continue;
                        }
                        final String type = getAttributeType( attribute );
                        final String typeParameter = getStructuralFeatureTypeParameter( attribute );
                        final String variableName = composeVariableName( StringUtils.convertFirstCharToLower( getJMIIdentifier( attribute ) ) );
                        String value = "null"; //$NON-NLS-1$
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            if ( attribute.getMultiplicity( ).getLower( ) == 0 ) {
                                value = "null"; //$NON-NLS-1$
                            } else if ( attribute.getMultiplicity( ).getLower( ) == 1 ) {
                                if ( isJavaType( type ) ) {
                                    value = ( getJavaReturnInitialValueByType( type ) );
                                }
                            }
                        }
                        final String actValue = value;
                        result.add( new JmiGeneratorAttributeDeclaration( ) {

                            public String getType( ) {

                                return type;
                            }

                            public String getTypeParameter( ) {

                                return typeParameter;
                            }

                            public String getName( ) {

                                return variableName;
                            }

                            public String getValue( ) {

                                return actValue;
                            }

                            public boolean isArray( ) {

                                return false;
                            }

                            public String getJavaType( ) {

                                return type;
                            }

                            public boolean isNeedsToBeUnwrapped( ) {

                                // Not relevant for variable declarations
                                return false;
                            }

                            public JmiGeneratorClassOperation getOperation( ) {

                                // Not relevant for variable declarations
                                return null;
                            }

                            public void setNeedsToBeUnwrapped( boolean needsUnwrapping ) {

                                // Not relevant for variable declarations
                            }

                            public boolean isPartitionParameter( ) {

                                return false;
                            }

                            public boolean isMultiple( ) {

                                // Not relevant for variable declarations
                                return false;
                            }

                            public boolean isObjectTyped( ) {

                                // Not relevant for variable declarations
                                return false;
                            }
                        } );
                    }
                }
                break;
            default:
                throw new MoinUnsupportedOperationException( "getAttributeDeclarations" ); //$NON-NLS-1$
        }
        return result;
    }

    public List<JmiGeneratorTypedElementInitialization> getAttributeInitializations( JmiGenerationKind genKind, boolean getStatic ) {

        List<JmiGeneratorTypedElementInitialization> result = new ArrayList<JmiGeneratorTypedElementInitialization>( );
        switch ( genKind ) {
            case INTERFACE:
                return result;
            case CLASS:
                // extract the initializer constraints for attributes, also consider the inherited ones
                Map<String, String> initConstraintValuesForAttributes = new HashMap<String, String>( );
                Iterator<ModelElement> allContent = getAllContent( );
                for ( ; allContent.hasNext( ); ) {
                    ModelElement me = allContent.next( );
                    if ( me instanceof Constraint && ( (Constraint) me ).getLanguage( ).equals( "OCLInit" ) ) { //$NON-NLS-1$
                        OclStatement attributeInitialStatement = getInitializerStatementFromConstraint( (ConstraintInternal) me, this.wrappedClass );
                        if ( attributeInitialStatement != null ) {
                            String value = evaluateConstantValueFromInitializerStatement( attributeInitialStatement.getExpression( ) );
                            if ( value != null ) {
                                initConstraintValuesForAttributes.put( ( (Attribute) attributeInitialStatement.getContext( ) ).getName( ), value );
                            }
                        }
                    }
                }
                allContent = getAllContent( );
                for ( ; allContent.hasNext( ); ) {
                    ModelElement me = allContent.next( );
                    if ( me instanceof AttributeInternal ) {
                        AttributeInternal attribute = (AttributeInternal) me;
                        if ( attribute.isDerived( ) || attribute.getType( connection ) instanceof MofClass ) {
                            continue;
                        }
                        boolean isStatic = attribute.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                        if ( getStatic != isStatic ) {
                            continue;
                        }
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            String value = initConstraintValuesForAttributes.get( attribute.getName( ) );
                            if ( value != null ) {
                                if ( isJavaStringType( getAttributeType( attribute ) ) ) {
                                    // surround with two "
                                    value = "\"" + value + "\""; //$NON-NLS-1$  //$NON-NLS-2$
                                }
                                JmiGeneratorTypedElementInitializationImpl init = new JmiGeneratorTypedElementInitializationImpl( );
                                String internalMutator = null;
                                String accessorNameFragment = StringUtils.convertFirstCharToUpper( getJMIIdentifier( attribute ) );
                                if ( accessorNameFragment.toLowerCase( Locale.ENGLISH ).startsWith( "is" ) ) { //$NON-NLS-1$
                                    internalMutator = INTERNAL_SETTER_PREFIX + accessorNameFragment.substring( 2 );
                                } else {
                                    internalMutator = INTERNAL_SETTER_PREFIX + accessorNameFragment;
                                }
                                init.setInitializationCode( internalMutator + "(" + value + ")" ); //$NON-NLS-1$  //$NON-NLS-2$
                                result.add( init );
                            }
                        }
                    }
                }
                break;
            default:
                throw new MoinUnsupportedOperationException( "getAttributeInitializations" ); //$NON-NLS-1$
        }
        return result;
    }

    /**
     * @param genKind
     * @param staticOnly
     * @return setters that must only be generated in the implementation
     */
    public List<JmiGeneratorFeature> getInternalSetterFeatures( JmiGenerationKind genKind, boolean staticOnly ) {

        List<String> features = getFeatureIds( genKind, staticOnly );
        List<JmiGeneratorFeature> result = new ArrayList<JmiGeneratorFeature>( );
        if ( genKind != JmiGenerationKind.CLASS ) {
            return result;
        }

        for ( Iterator<ModelElement> iterator = this.getAllContent( ); iterator.hasNext( ); ) {
            ModelElement me = iterator.next( );
            if ( me instanceof ReferenceInternal ) {

                ReferenceInternal reference = (ReferenceInternal) me;

                boolean isStatic = reference.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( isStatic != staticOnly ) {
                    continue;
                }

                AssociationEndInternal associationEnd = (AssociationEndInternal) reference.getReferencedEnd( connection );
                AssociationInternal association = (AssociationInternal) associationEnd.getContainer( connection );

                if ( association.isDerived( ) && reference.getMultiplicity( ).getUpper( ) == 1 ) {
                    String accessorNameFragment = StringUtils.convertFirstCharToUpper( getJMIIdentifier( reference ) );
                    String internalMutator = INTERNAL_SETTER_PREFIX + accessorNameFragment;
                    final String refType = getReferenceType( reference );
                    String asssocJavaInterfaceName = getOrCreateWrapper( association ).getJavaClassName( JmiGenerationKind.INTERFACE, true );
                    JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( internalMutator, "void", null, null ); //$NON-NLS-1$
                    op.setVisibility( "private" ); //$NON-NLS-1$
                    op.getParameters( ).add( new JmiGeneratorParameterImpl( "newValue", refType, null ) ); //$NON-NLS-1$
                    JmiGeneratorAssociationWrapper assocwrapper = (JmiGeneratorAssociationWrapper) getOrCreateWrapper( association );
                    List<String> body = op.getBody( );
                    if ( assocwrapper.getEnd0( ).isChangeable( ) && assocwrapper.getEnd1( ).isChangeable( ) ) {
                        body.add( "com.sap.tc.moin.repository.mmi.model.AssociationEnd associationEnd = (com.sap.tc.moin.repository.mmi.model.AssociationEnd)get___AttributeOrAssociationEndByName(\"" + reference.getName( ) + "\"); //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$
                        body.add( "com.sap.tc.moin.repository.mmi.model.Reference reference = (com.sap.tc.moin.repository.mmi.model.Reference)get___AttributeOrReferenceByName(\"" + reference.getName( ) + "\"); //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$
                        body.add( "com.sap.tc.moin.repository.mmi.model.Association association = (com.sap.tc.moin.repository.mmi.model.Association)associationEnd.getContainer();" ); //$NON-NLS-1$
                        body.add( asssocJavaInterfaceName + " associationExtent = (" + asssocJavaInterfaceName + ")get___Workspace().getWorkspaceSet().getExtentManager().getExtent(((com.sap.tc.moin.repository.Partitionable)association).get___Mri());" ); //$NON-NLS-1$ //$NON-NLS-2$
                        if ( associationEnd.getName( ).equals( assocwrapper.getEnd0( ).getName( ) ) ) {
                            body.add( "((com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension)associationExtent).add___AssociationEnds(newValue, this, reference);" ); //$NON-NLS-1$
                        } else {
                            body.add( "((com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension)associationExtent).add___AssociationEnds(this, newValue, reference);" ); //$NON-NLS-1$
                        }
                    } else {
                        body.add( "// can not set reference, both association ends have to be changeable " + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    JmiGeneratorReferenceWrapper wrapper = (JmiGeneratorReferenceWrapper) getOrCreateWrapper( reference );
                    JmiGeneratorFeatureImpl feature = new JmiGeneratorFeatureImpl( wrapper );
                    feature.setOperation( op );
                    feature.setIndex( features.indexOf( feature.getName( ) ) );
                    result.add( feature );
                }
            }

            if ( me instanceof AttributeInternal ) {
                AttributeInternal attribute = (AttributeInternal) me;

                boolean isStatic = attribute.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( isStatic != staticOnly ) {
                    continue;
                }

                // internalSetters

                String accessorNameFragment = StringUtils.convertFirstCharToUpper( getJMIIdentifier( attribute ) );
                String internalMutator = INTERNAL_SETTER_PREFIX + accessorNameFragment;
                String type = getAttributeType( attribute );
                String substituteName = getSubstituteIdentifier( attribute );
                boolean multiple = attribute.getMultiplicity( ).getUpper( ) != 1;

                JmiGeneratorAttributeWrapper wrapper = (JmiGeneratorAttributeWrapper) getOrCreateWrapper( attribute );

                JmiGeneratorFeatureImpl feature = new JmiGeneratorFeatureImpl( wrapper );

                if ( attribute.isDerived( ) ) {
                    if ( multiple ) {
                        continue;
                    }
                    final String pType = type;
                    JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( internalMutator, "void", null, substituteName ); //$NON-NLS-1$
                    // TODO this is private, the old generator does not add the exception
                    op.clearExceptions( );
                    op.setVisibility( "private" ); //$NON-NLS-1$
                    op.setDerived( true );
                    op.getParameters( ).add( new JmiGeneratorParameterImpl( "newValue", pType, null ) ); //$NON-NLS-1$
                    List<String> body = op.getBody( );
                    Tag bodyTag = getTag( attribute, TAG_PRODUCTION_CODE );
                    if ( bodyTag != null ) {
                        body.add( "// begin of implementation provided in tag " + TAG_PRODUCTION_CODE ); //$NON-NLS-1$
                        body.add( bodyTag.getValues( ).get( 0 ) );
                        body.add( "// end of implementation provided in tag " + TAG_PRODUCTION_CODE ); //$NON-NLS-1$
                    } else {
                        body.add( "// missing an implementation provided in tag " + TAG_PRODUCTION_CODE ); //$NON-NLS-1$
                    }
                    feature.setOperation( op );
                }
                feature.setIndex( features.indexOf( feature.getName( ) ) );
                result.add( feature );
            }
        }
        return result;
    }

    /**
     * @param genKind
     * @return the References
     */
    public List<JmiGeneratorClassOperation> getReferenceOperations( JmiGenerationKind genKind ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        Iterator<ModelElement> iterator;
        List<String> featureIds = getFeatureIds( genKind, false );

        switch ( genKind ) {
            case INTERFACE:
                iterator = getContent( );
                break;

            case CLASS:
                iterator = getAllContent( );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getReferenceOperations" ); //$NON-NLS-1$
        }

        switch ( genKind ) {
            case INTERFACE:
                for ( ; iterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) iterator.next( );
                    if ( me instanceof ReferenceInternal ) {
                        final ReferenceInternal reference = (ReferenceInternal) me;
                        String annotation = reference.getAnnotation( );
                        if ( !reference.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                            continue;
                        }
                        if ( !reference.getScope( ).equals( ScopeKindEnum.INSTANCE_LEVEL ) ) {
                            continue;
                        }
                        String substituteName = getSubstituteIdentifier( reference );
                        // accessor
                        String accessor = getAccessorNameForTypedElement( reference );
                        final String type = getReferenceType( reference );
                        String typeParameter = getStructuralFeatureTypeParameter( reference );
                        JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                        op.setAnnotation( annotation );
                        result.add( op );
                        // mutator
                        if ( reference.getMultiplicity( ).getUpper( ) == 1 ) {
                            String mutator = getMutatorNameForTypedElement( reference );
                            op = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                            op.getParameters( ).add( new JmiGeneratorParameterImpl( "newValue", type, null ) ); //$NON-NLS-1$
                            op.setAnnotation( annotation );
                            result.add( op );
                        }
                    }
                }
                break;

            case CLASS:
                for ( ; iterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) iterator.next( );
                    if ( me instanceof ReferenceInternal ) {
                        ReferenceInternal reference = (ReferenceInternal) me;
                        if ( !reference.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                            continue;
                        }
                        if ( !reference.getScope( ).equals( ScopeKindEnum.INSTANCE_LEVEL ) ) {
                            continue;
                        }
                        final String accessor = getAccessorNameForTypedElement( reference );

                        boolean derived = ( (AssociationInternal) ( (AssociationEndInternal) reference.getReferencedEnd( connection ) ).getContainer( connection ) ).isDerived( );
                        final String type = getReferenceType( reference );
                        String typeParameter = getStructuralFeatureTypeParameter( reference );
                        final String substituteName = getSubstituteIdentifier( reference );
                        final Boolean multiple = Boolean.valueOf( reference.getMultiplicity( ).getUpper( ) != 1 );
                        final String featureName = reference.getName( );

                        if ( derived ) {
                            final String assocEndName = StringUtils.convertFirstCharToUpper( reference.getReferencedEnd( connection ).getName( ) );
                            JmiGeneratorBaseWrapper aw = getOrCreateWrapper( (NamespaceInternal) ( (AssociationEndInternal) reference.getReferencedEnd( connection ) ).getContainer( connection ) );
                            final String assocType = aw.getJavaClassName( JmiGenerationKind.INTERFACE, true );
                            final String assocImplType = aw.getJavaClassName( JmiGenerationKind.CLASS, true );
                            JmiGeneratorClassOperationDervied op = new JmiGeneratorClassOperationDerived( accessor, assocType, assocImplType, assocEndName, multiple, type, typeParameter, featureName, (Reference) reference );
                            op.getExceptions( ).add( JmiException.class.getName( ) );
                            result.add( op );
                            JmiGeneratorClassOperationDervied op2 = new JmiGeneratorClassOperationDerived( accessor, assocType, assocImplType, assocEndName, multiple, type, typeParameter, featureName, (Reference) reference );
                            op2.getExceptions( ).add( JmiException.class.getName( ) );
                            addCoreConnectionParameter( op2.getParameters( ) );
                            op2.setHasCoreConnection( true );
                            result.add( op2 );
                        } else {
                            JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                            op.setQueryNeededForNavigation( isQueryNeededForNavigation( reference ) );
                            op.setMultiple( reference.getMultiplicity( ).getUpper( ) != 1 );
                            op.setFeatureName( reference.getName( ) );
                            op.setFeatureIndex( featureIds.indexOf( reference.getName( ) ) );
                            op.setAttributeOrAssociationMofId( getAssociation( reference ).refMofId( ) );
                            op.setReferenceMofId( reference.refMofId( ) );
                            op.setEndNumberOfToEnd( getEndNumber( (AssociationEndInternal) reference.getReferencedEnd( connection ) ) );
                            op.setReference( true );
                            AssociationEndInternal end = (AssociationEndInternal) reference.getReferencedEnd( connection );
                            if ( getJmiHelper( ).isEndStored( this.connection.getSession( ), end.otherEnd( connection ) ) ) {
                                op.setLinkVariableName( "__" + end.getContainer( connection ).getName( ) + "_" + end.getName( ) + "_" + end.refMofId( ) ); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
                            }
                            if ( end.getAggregation( ) == AggregationKindEnum.COMPOSITE ) {
                                op.setReferencedEndComposite( true );
                            }
                            op.setObjectTyped( true );
                            result.add( op );
                            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, substituteName );
                            op2.setQueryNeededForNavigation( op.isQueryNeededForNavigation( ) );
                            op2.setMultiple( op.isMultiple( ) );
                            op2.setFeatureName( op.getFeatureName( ) );
                            op2.setFeatureIndex( op.getFeatureIndex( ) );
                            op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                            op2.setReferenceMofId( op.getReferenceMofId( ) );
                            op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                            op2.setReference( op.isReference( ) );
                            op2.setReferencedEndComposite( op.isReferencedEndComposite( ) );
                            addCoreConnectionParameter( op2.getParameters( ) );
                            op2.setHasCoreConnection( true );
                            op2.setLinkVariableName( op.getLinkVariableName( ) );
                            op2.setObjectTyped( op.isObjectTyped( ) );
                            result.add( op2 );
                        }

                        // mutators
                        String mutator = getMutatorNameForTypedElement( reference );

                        JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                        op.setMultiple( reference.getMultiplicity( ).getUpper( ) != 1 );
                        op.setQueryNeededForNavigation( isQueryNeededForNavigation( reference ) );
                        op.setFeatureName( reference.getName( ) );
                        op.setFeatureIndex( featureIds.indexOf( reference.getName( ) ) );
                        op.setAttributeOrAssociationMofId( getAssociation( reference ).refMofId( ) );
                        op.setReferenceMofId( reference.refMofId( ) );
                        op.setEndNumberOfToEnd( getEndNumber( (AssociationEndInternal) reference.getReferencedEnd( connection ) ) );
                        op.setSetter( true );
                        op.setReference( true );
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( op, "newValue", type, null, false, true ) ); //$NON-NLS-1$
                        result.add( op );
                        JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( mutator, "void", null, substituteName ); //$NON-NLS-1$
                        op2.setMultiple( op.isMultiple( ) );
                        op2.setQueryNeededForNavigation( op.isQueryNeededForNavigation( ) );
                        op2.setFeatureName( op.getFeatureName( ) );
                        op2.setFeatureIndex( op.getFeatureIndex( ) );
                        op2.setAttributeOrAssociationMofId( op.getAttributeOrAssociationMofId( ) );
                        op2.setReferenceMofId( op.getReferenceMofId( ) );
                        op2.setEndNumberOfToEnd( op.getEndNumberOfToEnd( ) );
                        op2.setSetter( op.isSetter( ) );
                        op2.setReference( op.isReference( ) );
                        addCoreConnectionParameter( op2.getParameters( ) );
                        op2.getParameters( ).addAll( op.getParameters( ) );
                        op2.setHasCoreConnection( true );
                        result.add( op2 );
                    }
                }
                break;

            default:
                break;
        }
        return result;
    }

    /**
     * @param genKind
     * @param forProxy
     * @return the Operations
     */
    public List<JmiGeneratorClassOperation> getOperations( JmiGenerationKind genKind, boolean forProxy ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        List<String> operationIds = getOperationIds( genKind, forProxy );

        Iterator<ModelElement> myChildren;
        if ( genKind == JmiGenerationKind.INTERFACE ) {
            myChildren = getContent( );
        } else if ( genKind == JmiGenerationKind.CLASS || genKind == JmiGenerationKind.WRAPPER ) {
            myChildren = getAllContent( );
        } else {
            throw new MoinUnsupportedOperationException( "getOperations" ); //$NON-NLS-1$
        }

        List<OperationInternal> contentsOperations = new ArrayList<OperationInternal>( );
        // remember most derived element only for each operation signature,
        // keeping depth-first order as in contentsAll:
        LinkedHashMap<Object, OperationInternal> mostDerivedOnly = new LinkedHashMap<Object, OperationInternal>( );
        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal me = (ModelElementInternal) myChildren.next( );
            if ( me instanceof OperationInternal ) {
                OperationInternal op = (OperationInternal) me;
                mostDerivedOnly.put( convertOperation2Signature( op ), op );
            }
        }
        contentsOperations.addAll( mostDerivedOnly.values( ) );

        if ( genKind == JmiGenerationKind.INTERFACE ) {
            for ( OperationInternal operation : contentsOperations ) {
                String annotation = operation.getAnnotation( );
                if ( !operation.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                    continue;
                }
                boolean isStatic = operation.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( forProxy != isStatic ) {
                    continue;
                }
                List<ParameterInternal> parameters = new ArrayList<ParameterInternal>( );
                List<MofExceptionInternal> exceptions = new ArrayList<MofExceptionInternal>( );
                ParameterInternal pReturn = null;
                for ( Iterator<ModelElement> iterator = getAllContent( operation ); iterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) iterator.next( );
                    if ( me instanceof ParameterInternal ) {
                        ParameterInternal p = (ParameterInternal) me;
                        if ( p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                            pReturn = p;
                        } else {
                            parameters.add( p );
                        }
                    } else if ( me instanceof MofExceptionInternal ) {
                        MofExceptionInternal e = (MofExceptionInternal) me;
                        exceptions.add( e );
                    }
                }
                String type = VOID;
                String typeParameter = null;
                if ( pReturn != null ) {
                    type = getParameterType( pReturn );
                    typeParameter = getParameterTypeParameter( pReturn );
                }
                List<String> body = new ArrayList<String>( );
                body.add( ";" ); //$NON-NLS-1$

                JmiList<MofException> operationExceptions = (JmiList) ( (OperationInternal) operation ).getExceptions( this.connection );
                for ( Iterator<MofException> iterator = operationExceptions.iteratorReadOnly( this.connection.getSession( ) ); iterator.hasNext( ); ) {
                    exceptions.add( (MofExceptionInternal) iterator.next( ) );
                }

                List<String> exceptionTypes = new ArrayList<String>( );
                for ( MofExceptionInternal me : exceptions ) {
                    exceptionTypes.add( getJMIIdentifierQualified( me ) );
                }
                String accessor = getOperationNameForOperation( operation );
                List<JmiGeneratorParameter> params = new ArrayList<JmiGeneratorParameter>( );
                for ( ParameterInternal param : parameters ) {
                    String ptype = getParameterType( param );
                    String ptypeParameter = getParameterTypeParameter( param );
                    String pname = StringUtils.convertFirstCharToLower( getJMIIdentifier( param ) );
                    JmiGeneratorParameterImpl jmiGenParam = new JmiGeneratorParameterImpl( pname, ptype, ptypeParameter );
                    if ( param.getDirection( ).equals( DirectionKindEnum.OUT_DIR ) || param.getDirection( ).equals( DirectionKindEnum.INOUT_DIR ) ) {
                        jmiGenParam.setArray( true );
                    }
                    params.add( jmiGenParam );
                }
                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, getSubstituteIdentifier( operation ) );
                op.setSetter( !operation.isQuery( ) );
                op.getParameters( ).addAll( params );
                op.addExceptions( exceptionTypes );
                op.setFeatureName( operation.getName( ) );
                op.getBody( ).addAll( body );
                op.setAnnotation( annotation );
                if ( pReturn != null ) {
                    Classifier nonAliasType = getJmiHelper( ).getNonAliasType( this.connection.getSession( ), (Parameter) pReturn );
                    if ( pReturn.getMultiplicity( ).getUpper( ) == 1 && ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) ) {
                        op.setWrapResult( false );
                    }
                }
                result.add( op );

            }
        } else if ( genKind == JmiGenerationKind.WRAPPER || ( genKind == JmiGenerationKind.CLASS && isMofModelElement( ) ) ) {
            for ( OperationInternal operation : contentsOperations ) {
                if ( !operation.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                    continue;
                }
                boolean isStatic = operation.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
                if ( forProxy != isStatic ) {
                    continue;
                }
                String accessor = getOperationNameForOperation( operation );
                List<ParameterInternal> parameters = new ArrayList<ParameterInternal>( );
                List<MofExceptionInternal> exceptions = new ArrayList<MofExceptionInternal>( );
                ParameterInternal pReturn = null;
                for ( Iterator<ModelElement> iterator = getAllContent( operation ); iterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) iterator.next( );
                    if ( me instanceof ParameterInternal ) {
                        ParameterInternal p = (ParameterInternal) me;
                        if ( p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                            pReturn = p;
                        } else {
                            parameters.add( p );
                        }
                    } else if ( me instanceof MofExceptionInternal ) {
                        MofExceptionInternal e = (MofExceptionInternal) me;
                        exceptions.add( e );

                    }
                }
                String type = VOID;
                String typeParameter = null;
                if ( pReturn != null ) {
                    type = getParameterType( pReturn );
                    typeParameter = getParameterTypeParameter( pReturn );
                }
                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, getSubstituteIdentifier( operation ) );
                List<JmiGeneratorParameter> params = new ArrayList<JmiGeneratorParameter>( );
                for ( ParameterInternal param : parameters ) {
                    String ptype = getParameterType( param );
                    String ptypeParameter = getParameterTypeParameter( param );
                    String pname = StringUtils.convertFirstCharToLower( getJMIIdentifier( param ) );
                    JmiGeneratorParameterImpl jmiGenParam = new JmiGeneratorParameterImpl( pname, ptype, ptypeParameter );
                    if ( param.getDirection( ).equals( DirectionKindEnum.OUT_DIR ) || param.getDirection( ).equals( DirectionKindEnum.INOUT_DIR ) ) {
                        jmiGenParam.setArray( true );
                    }
                    params.add( jmiGenParam );
                }
                List<String> body = new ArrayList<String>( );
                boolean mofAndCodeFromTag = false;
                if ( isMofElement( operation ) ) {
                    mofAndCodeFromTag = true;
                    body.add( GET_CURRENT_CONNECTION_STATEMENT );
                }
                String internalOperationCallParamString = CONNECTION_VARIABLE_NAME;
                if ( params.size( ) != 0 ) {
                    internalOperationCallParamString += ", "; //$NON-NLS-1$
                    for ( Iterator<JmiGeneratorParameter> iterator = params.iterator( ); iterator.hasNext( ); ) {
                        JmiGeneratorParameter param = iterator.next( );
                        internalOperationCallParamString += param.getName( );
                        if ( iterator.hasNext( ) ) {
                            internalOperationCallParamString += ", "; //$NON-NLS-1$
                        }
                    }
                }
                if ( type.compareTo( VOID ) != 0 ) {
                    body.add( "return " + getInternalOperationNameForOperation( operation ) + "(" + internalOperationCallParamString + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                } else {
                    body.add( getInternalOperationNameForOperation( operation ) + "(" + internalOperationCallParamString + ");" ); //$NON-NLS-1$ //$NON-NLS-2$
                }

                JmiList<MofException> operationExceptions = (JmiList) ( (OperationInternal) operation ).getExceptions( this.connection );
                for ( Iterator<MofException> iterator = operationExceptions.iteratorReadOnly( this.connection.getSession( ) ); iterator.hasNext( ); ) {
                    exceptions.add( (MofExceptionInternal) iterator.next( ) );
                }

                List<String> exceptionTypes = new ArrayList<String>( );
                for ( MofExceptionInternal me : exceptions ) {
                    exceptionTypes.add( getJMIIdentifierQualified( me ) );
                }
                op.setOperationIndex( operationIds.indexOf( operation.getName( ) ) );
                op.setOperationMofId( operation.refMofId( ) );
                op.setSetter( !operation.isQuery( ) );
                op.getParameters( ).addAll( params );
                if ( !exceptionTypes.isEmpty( ) ) {
                    op.addExceptions( 0, exceptionTypes );
                }
                op.setFeatureName( operation.getName( ) );
                op.getBody( ).addAll( body );
                if ( pReturn != null ) {
                    Classifier nonAliasType = getJmiHelper( ).getNonAliasType( this.connection.getSession( ), (Parameter) pReturn );
                    if ( pReturn.getMultiplicity( ).getUpper( ) == 1 && ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) ) {
                        op.setWrapResult( false );
                    }
                }
                result.add( op );
                // clone operation and add the core connection parameter to the signature
                JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( op.getAccessorName( ), op.getType( ), op.getTypeParameter( ), op.getSubstituteName( ) );
                op2.setOperationIndex( op.getOperationIndex( ) );
                op2.setOperationMofId( op.getOperationMofId( ) );
                op2.setSetter( op.isSetter( ) );
                addCoreConnectionParameter( op2.getParameters( ) );
                op2.getParameters( ).addAll( params );
                if ( !exceptionTypes.isEmpty( ) ) {
                    op2.addExceptions( op.getExceptions( ) );
                }
                op2.setFeatureName( op.getFeatureName( ) );
                op2.getBody( ).addAll( body );
                if ( mofAndCodeFromTag ) {
                    op2.getBody( ).remove( 0 );
                    mofAndCodeFromTag = false;
                }
                op2.setWrapResult( op.isWrapResult( ) );
                op2.setHasCoreConnection( true );
                result.add( op2 );
            }
        }

        return result;
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( JmiGenerationKind genKind, boolean forProxy ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );
        if ( genKind == JmiGenerationKind.INTERFACE ) {
            return result;
        }
        List<String> operationIds = getOperationIds( genKind, forProxy );
        Iterator<ModelElement> myChildren = getAllContent( );
        List<OperationInternal> contentsOperations = new ArrayList<OperationInternal>( );
        // remember most derived element only for each operation signature, keeping depth-first order as in contentsAll
        LinkedHashMap<Object, OperationInternal> mostDerivedOnly = new LinkedHashMap<Object, OperationInternal>( );
        for ( ; myChildren.hasNext( ); ) {
            ModelElement me = myChildren.next( );
            if ( me instanceof OperationInternal ) {
                OperationInternal op = (OperationInternal) me;
                mostDerivedOnly.put( convertOperation2Signature( op ), op );
            }
        }
        contentsOperations.addAll( mostDerivedOnly.values( ) );
        for ( OperationInternal operation : contentsOperations ) {
            if ( !operation.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                continue;
            }
            boolean isStatic = operation.getScope( ).equals( ScopeKindEnum.CLASSIFIER_LEVEL );
            if ( forProxy != isStatic ) {
                continue;
            }
            List<ParameterInternal> parameters = new ArrayList<ParameterInternal>( );
            List<MofExceptionInternal> exceptions = new ArrayList<MofExceptionInternal>( );
            ParameterInternal pReturn = null;
            for ( Iterator<ModelElement> iterator = getAllContent( operation ); iterator.hasNext( ); ) {
                ModelElement me = iterator.next( );
                if ( me instanceof ParameterInternal ) {
                    ParameterInternal p = (ParameterInternal) me;
                    if ( p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                        pReturn = p;
                    } else {
                        parameters.add( p );
                    }
                } else if ( me instanceof MofExceptionInternal ) {
                    MofExceptionInternal e = (MofExceptionInternal) me;
                    exceptions.add( e );
                }
            }
            String type = VOID;
            String typeParameter = null;
            if ( pReturn != null ) {
                type = getParameterType( pReturn );
                typeParameter = getParameterTypeParameter( pReturn );
            }
            List<String> body = new ArrayList<String>( );
            Tag tagJavaCoding = getTag( operation, TAG_OPERATION_CODE_JAVA );
            // fetching operation code tag for Ocl
            Tag tagOclCoding = getTag( operation, TAG_OPERATION_CODE_OCL );
            if ( tagOclCoding != null ) {
                body.add( "try {" ); //$NON-NLS-1$
                body.add( "    // delegating to the OCL service " + TAG_OPERATION_CODE_OCL ); //$NON-NLS-1$
                if ( tagOclCoding.getValues( ).isEmpty( ) ) {
                    // return default type
                    body.add( "    // implementation provided in tag " + TAG_OPERATION_CODE_OCL + "is empty" ); //$NON-NLS-1$ //$NON-NLS-2$
                    if ( type.compareTo( VOID ) != 0 ) {
                        body.add( "    return " + getJavaReturnInitialValueByType( type ) + ";" ); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                } else {
                    body.add( "    java.util.Map operationParameters = new java.util.HashMap();" ); //$NON-NLS-1$
                    Iterator<ParameterInternal> iter = parameters.iterator( );
                    while ( iter.hasNext( ) ) {
                        ParameterInternal p = iter.next( );
                        if ( genKind == JmiGenerationKind.WRAPPER ) {
                            body.add( "    operationParameters.put(\"" + p.getName( ) + "\", " + "unwrapArg(" + getJavaTypeAsObject( getParameterType( p ), StringUtils.convertFirstCharToLower( getJMIIdentifier( p ) ) ) + "));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        } else {
                            body.add( "    operationParameters.put(\"" + p.getName( ) + "\", " + getJavaTypeAsObject( getParameterType( p ), StringUtils.convertFirstCharToLower( getJMIIdentifier( p ) ) ) + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        }
                    }
                    String thisPointer = ( genKind == JmiGenerationKind.WRAPPER ? "getCastWrappedObject( )" : "this" ); //$NON-NLS-1$ //$NON-NLS-2$
                    String oclServiceCall = "connection.getSession().getOclService().evaluateOclBodyExpression(connection, \"" + operation.getName( ) + "\", " + thisPointer + ", operationParameters)"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    if ( genKind == JmiGenerationKind.WRAPPER ) {
                        oclServiceCall = "wrapResult(" + oclServiceCall + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                    }
                    if ( type.compareTo( VOID ) != 0 ) {
                        String str = getJavaTypeGetValue( type );
                        if ( str != null ) {
                            body.add( "    return " + "((" + getJavaTypeClass( type ) + ")" + oclServiceCall + ")." + str + ";" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                        } else {
                            body.add( "    return " + "(" + getJavaTypeClass( type ) + ")" + oclServiceCall + ";" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        }
                    } else {
                        body.add( "    " + oclServiceCall + ";" ); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                }
                body.add( "    // end of implementation provided in tag " + TAG_OPERATION_CODE_OCL ); //$NON-NLS-1$
                body.add( "} catch(com.sap.tc.moin.repository.exception.MoinBaseException ex) {" ); //$NON-NLS-1$
                body.add( "        throw new com.sap.tc.moin.repository.mmi.reflect.JmiException(ex);" ); //$NON-NLS-1$
                body.add( "}" ); //$NON-NLS-1$
            } else if ( tagJavaCoding != null ) {
                body.add( "// begin of implementation provided in tag " + TAG_OPERATION_CODE_JAVA ); //$NON-NLS-1$
                List<String> list = tagJavaCoding.getValues( );
                if ( list == null ) {
                    // return
                    body.add( "// implementation provided in tag " + TAG_OPERATION_CODE_JAVA + "is empty" ); //$NON-NLS-1$  //$NON-NLS-2$
                    if ( type.compareTo( VOID ) != 0 ) {
                        body.add( "return " + getJavaReturnInitialValueByType( type ) + ";" ); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                } else {
                    body.addAll( list );
                }
                body.add( "// end of implementation provided in tag " + TAG_OPERATION_CODE_JAVA ); //$NON-NLS-1$
            } else {
                // return default type
                body.add( "// missing an implementation provided in either tag " + TAG_OPERATION_CODE_JAVA + " or " + TAG_OPERATION_CODE_OCL ); //$NON-NLS-1$  //$NON-NLS-2$
                if ( type.compareTo( VOID ) != 0 ) {
                    body.add( "return " + getJavaReturnInitialValueByType( type ) + ";" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }

            JmiList<MofException> operationExceptions = (JmiList) ( (OperationInternal) operation ).getExceptions( this.connection );
            for ( Iterator<MofException> iterator = operationExceptions.iteratorReadOnly( this.connection.getSession( ) ); iterator.hasNext( ); ) {
                exceptions.add( (MofExceptionInternal) iterator.next( ) );
            }

            List<String> exceptionTypes = new ArrayList<String>( );
            for ( MofExceptionInternal me : exceptions ) {
                exceptionTypes.add( getJMIIdentifierQualified( me ) );
            }
            String accessor = getInternalOperationNameForOperation( operation );
            List<JmiGeneratorParameter> params = new ArrayList<JmiGeneratorParameter>( );
            for ( ParameterInternal param : parameters ) {
                String ptype = getParameterType( param );
                String ptypeParameter = getParameterTypeParameter( param );
                String pname = StringUtils.convertFirstCharToLower( getJMIIdentifier( param ) );
                JmiGeneratorParameterImpl jmiGenParam = new JmiGeneratorParameterImpl( pname, ptype, ptypeParameter );
                if ( param.getDirection( ).equals( DirectionKindEnum.OUT_DIR ) || param.getDirection( ).equals( DirectionKindEnum.INOUT_DIR ) ) {
                    jmiGenParam.setArray( true );
                }
                params.add( jmiGenParam );
            }
            JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, typeParameter, getSubstituteIdentifier( operation ) );
            op.setVisibility( "private" ); //$NON-NLS-1$
            op.setFeatureIndex( operationIds.indexOf( operation.getName( ) ) );
            op.setSetter( !operation.isQuery( ) );
            addCoreConnectionParameter( op.getParameters( ) );
            op.getParameters( ).addAll( params );
            if ( !exceptionTypes.isEmpty( ) ) {
                op.addExceptions( 0, exceptionTypes );
            }
            op.setFeatureName( operation.getName( ) );
            op.getBody( ).addAll( body );
            if ( pReturn != null ) {
                ClassifierInternal nonAliasType = (ClassifierInternal) getJmiHelper( ).getNonAliasType( this.connection.getSession( ), (Parameter) pReturn );
                if ( pReturn.getMultiplicity( ).getUpper( ) == 1 && ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) ) {
                    op.setWrapResult( false );
                }
            }
            op.setHasCoreConnection( true );
            result.add( op );
        }
        return result;
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.CLASS;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );
        if ( genKind == JmiGenerationKind.CLASS ) {
            if ( !this.wrappedClass.isAbstract( ) ) {
                result.add( "ClassImpl" ); //$NON-NLS-1$
            }
            if ( !JmiGeneratorBaseWrapper.noClassProxy( ) ) {
                result.add( "ClassProxyImpl" ); //$NON-NLS-1$
            }

            if ( isMofModelElement( ) ) {
                result.add( "ClassInterfaceInternal" ); //$NON-NLS-1$
                if ( !JmiGeneratorBaseWrapper.noClassProxy( ) ) {
                    result.add( "ClassProxyInterfaceInternal" ); //$NON-NLS-1$
                }

            }
        } else if ( genKind == JmiGenerationKind.INTERFACE ) {
            result.add( "ClassInterface" ); //$NON-NLS-1$
            if ( !JmiGeneratorBaseWrapper.noClassProxy( ) ) {
                result.add( "ClassProxyInterface" ); //$NON-NLS-1$
            }
        } else if ( genKind == JmiGenerationKind.WRAPPER ) {
            if ( !this.wrappedClass.isAbstract( ) ) {
                result.add( "ClassWrapper" ); //$NON-NLS-1$
            }
            if ( !JmiGeneratorBaseWrapper.noClassProxy( ) ) {
                result.add( "ClassProxyWrapper" ); //$NON-NLS-1$
            }

        }
        return result;
    }

    public boolean isAbstract( ) {

        return this.wrappedClass.isAbstract( );
    }

    public boolean isSingleton( ) {

        return this.wrappedClass.isSingleton( );
    }

    @Override
    protected synchronized void initChildren( ) {

        if ( !this.childrenInitialized ) {
            Iterator<ModelElement> myChildren = this.getAllContent( );
            for ( ; myChildren.hasNext( ); ) {
                ModelElementInternal me = (ModelElementInternal) myChildren.next( );
                if ( me instanceof MofException ) {
                    JmiGeneratorExceptionWrapper child = (JmiGeneratorExceptionWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
            }
            this.childrenInitialized = true;
        }

    }

    private String getParameterTypeParameter( ParameterInternal p ) {

        if ( p.getMultiplicity( ).getUpper( ) != 1 ) {
            return getJavaTypeClass( getType( p.getType( connection ) ) );
        } else {
            return null;
        }
    }

    private String getParameterType( ParameterInternal p ) {

        String type = null;
        if ( isJavaType( p.getType( connection ).getName( ) ) ) {
            // MOF PrimitiveType
            if ( p.getMultiplicity( ).getLower( ) == 0 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                type = getJavaTypeClass( getType( p.getType( connection ) ) );
            } else if ( p.getMultiplicity( ).getLower( ) == 1 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                type = getType( p.getType( connection ) );
            } else {
                if ( p.getMultiplicity( ).isOrdered( ) ) {
                    type = "java.util.List"; //$NON-NLS-1$
                } else {
                    type = "java.util.Collection"; //$NON-NLS-1$
                }
            }
        } else {
            // NOT MOF PrimitiveType
            if ( p.getMultiplicity( ).getLower( ) == 0 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                type = getType( p.getType( connection ) );
            } else if ( p.getMultiplicity( ).getLower( ) == 1 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                type = getType( p.getType( connection ) );
            } else {
                if ( p.getMultiplicity( ).isOrdered( ) ) {
                    type = "java.util.List"; //$NON-NLS-1$
                } else {
                    type = "java.util.Collection"; //$NON-NLS-1$
                }
            }
        }
        return type;
    }

    /**
     * @param genKind
     * @return the constructors
     */
    public List<JmiGeneratorClassOperation> getClassConstructors( JmiGenerationKind genKind ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        if ( this.wrappedClass.isAbstract( ) ) {
            return result;
        }
        // empty creator
        String accessor = "create" + getJavaClassName( JmiGenerationKind.INTERFACE, false ); //$NON-NLS-1$
        String type = getJavaClassName( JmiGenerationKind.INTERFACE, true );

        JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, null, null );
        op.setSetter( true );
        op.setClassImplTemplate( new JmiGeneratorClassImplTemplateImpl( this ) );
        result.add( op );
        if ( genKind == JmiGenerationKind.CLASS ) {
            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor, type, null, null );
            op2.setSetter( true );
            addCoreConnectionParameter( op2.getParameters( ) );
            op2.setHasCoreConnection( true );
            op2.setClassImplTemplate( new JmiGeneratorClassImplTemplateImpl( this ) );
            result.add( op2 );
        }

        // "empty" creator with partition parameter
        op = new JmiGeneratorClassOperationImpl( accessor + "InPartition", type, null, null ); //$NON-NLS-1$
        op.setSetter( true );
        op.getParameters( ).add( new JmiGeneratorParameterImpl( "partition", ModelPartition.class.getName( ), null ) ); //$NON-NLS-1$
        op.setClassImplTemplate( new JmiGeneratorClassImplTemplateImpl( this ) );
        result.add( op );
        if ( genKind == JmiGenerationKind.CLASS ) {
            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor + "InPartition", type, null, null ); //$NON-NLS-1$
            op2.setSetter( true );
            addCoreConnectionParameter( op2.getParameters( ) );
            op2.getParameters( ).addAll( op.getParameters( ) );
            op2.setHasCoreConnection( true );
            op2.setClassImplTemplate( new JmiGeneratorClassImplTemplateImpl( this ) );
            result.add( op2 );
        }

        // specific creator
        op = new JmiGeneratorClassOperationImpl( accessor, type, null, null );
        op.setSetter( true );

        final List<JmiGeneratorParameter> params = op.getParameters( );

        for ( Iterator<ModelElement> iterator = this.getAllContent( ); iterator.hasNext( ); ) {
            ModelElement me = iterator.next( );
            if ( me instanceof Attribute ) {
                final AttributeInternal attr = (AttributeInternal) me;
                final String parameterName = getJMIIdentifier( attr );
                if ( attr.getType( connection ) != null && !attr.isDerived( ) && attr.getScope( ).equals( ScopeKindEnum.INSTANCE_LEVEL ) ) {
                    final String attType = getAttributeType( attr );
                    final String attTypeParameter = getStructuralFeatureTypeParameter( attr );
                    Classifier nonAliasType = getJmiHelper( ).getNonAliasType( this.connection.getSession( ), attr.getType( connection ) );
                    JmiGeneratorParameterImpl param = new JmiGeneratorParameterImpl( op, parameterName, attType, attTypeParameter, attr.getMultiplicity( ).getUpper( ) != 1, nonAliasType instanceof MofClass );
                    if ( nonAliasType instanceof PrimitiveType || nonAliasType instanceof EnumerationType || nonAliasType instanceof StructureType ) {
                        param.setNeedsToBeUnwrapped( false );
                    }
                    params.add( param );
                }
            }
        }

        // typed constructor
        if ( !op.getParameters( ).isEmpty( ) ) {
            result.add( op );
            if ( genKind == JmiGenerationKind.CLASS ) {
                JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( accessor, type, null, null );
                op2.setSetter( true );
                addCoreConnectionParameter( op2.getParameters( ) );
                op2.getParameters( ).addAll( op.getParameters( ) );
                op2.setHasCoreConnection( true );
                result.add( op2 );
            }

            // typed constructor with partition parameter
            JmiGeneratorClassOperationImpl op3 = new JmiGeneratorClassOperationImpl( accessor + "InPartition", type, null, null ); //$NON-NLS-1$
            op3.setSetter( true );
            op3.getParameters( ).addAll( op.getParameters( ) );
            op3.getParameters( ).add( new JmiGeneratorParameterImpl( "partition", ModelPartition.class.getName( ), null ) ); //$NON-NLS-1$
            result.add( op3 );

            if ( genKind == JmiGenerationKind.CLASS ) {
                JmiGeneratorClassOperationImpl op4 = new JmiGeneratorClassOperationImpl( accessor + "InPartition", type, null, null ); //$NON-NLS-1$
                op4.setSetter( true );
                addCoreConnectionParameter( op4.getParameters( ) );
                op4.getParameters( ).addAll( op3.getParameters( ) );
                op4.setHasCoreConnection( true );
                result.add( op4 );
            }
        }

        return result;
    }

    /**
     * @param genKind
     * @return the Structures
     */
    public List<JmiGeneratorParameter> getStructs( JmiGenerationKind genKind ) {

        List<JmiGeneratorParameter> result = new ArrayList<JmiGeneratorParameter>( );

        switch ( genKind ) {
            case CLASS:
                Iterator<ModelElement> iterator = getContent( );

                for ( ; iterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) iterator.next( );
                    if ( me instanceof StructureTypeInternal ) {
                        final String type = getOrCreateWrapper( me ).getJavaClassName( JmiGenerationKind.CLASS, true );
                        final String name = me.getName( );
                        JmiGeneratorParameter p = new JmiGeneratorParameterImpl( name, type, null );
                        result.add( p );
                    }
                }
                break;

            default:
                break;
        }
        return result;
    }

    private boolean isQueryNeededForNavigation( ReferenceInternal reference ) {

        return getJmiHelper( ).isQueryNeededForNavigation( this.connection.getSession( ), (Association) ( (AssociationEndInternal) reference.getReferencedEnd( connection ) ).getContainer( connection ), getFromEndNumber( (AssociationEndInternal) reference.getReferencedEnd( connection ) ) );
    }

    private boolean isQueryNeededForNavigation( AttributeInternal attribute ) {

        return getJmiHelper( ).isQueryNeededForNavigation( (Attribute) attribute );
    }

    private int getFromEndNumber( AssociationEndInternal referencedAssociationEnd ) {

        return 1 - getJmiHelper( ).getAssociationEndNumber( this.connection.getSession( ), (AssociationEnd) referencedAssociationEnd );
    }

    private int getToEndNumber( AttributeInternal attribute ) {

        return getJmiHelper( ).getAttributeToEndNumber( (Attribute) attribute );
    }

    private int getEndNumber( AssociationEndInternal associationEnd ) {

        return getJmiHelper( ).getAssociationEndNumber( this.connection.getSession( ), (AssociationEnd) associationEnd );
    }

    private Association getAssociation( ReferenceInternal reference ) {

        AssociationEndInternal referencedEnd = (AssociationEndInternal) reference.getReferencedEnd( connection );
        return (Association) referencedEnd.getContainer( connection );
    }

    /**
     * @return the constant for the class extent descriptor
     */
    public JmiGeneratorDescriptorConstant getClassExtentDescriptorConstant( ) {

        String type = "com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor<"; //$NON-NLS-1$
        type += getJavaProxyClassName( JmiGenerationKind.INTERFACE, true );
        type += ", "; //$NON-NLS-1$
        type += getJavaClassName( JmiGenerationKind.INTERFACE, true );
        type += ">"; //$NON-NLS-1$

        return getExtentDescriptorConstant( "CLASS_DESCRIPTOR", type ); //$NON-NLS-1$
    }

    public Set<AssociationEnd> getStoredAssociationEndsMultiplicityOne( ) {

        SpiJmiHelper jmiHelper = getJmiHelper( );
        Set<AssociationEnd> ends = jmiHelper.getAssociationEnds( this.connection.getSession( ), (MofClass) this.wrappedClass, true /* includeSupertypes */);
        Set<AssociationEnd> result = new LinkedHashSet<AssociationEnd>( );
        for ( AssociationEnd end : ends ) {
            AssociationEnd otherEnd = ( (AssociationEndInternal) end ).otherEnd( connection );
            if ( otherEnd.getMultiplicity( ).getUpper( ) == 1 && jmiHelper.isEndStored( this.connection.getSession( ), end ) ) {
                result.add( otherEnd );
            }
        }
        return result;
    }

    public Set<AssociationEnd> getStoredAssociationEndsMultiplicityMany( ) {

        SpiJmiHelper jmiHelper = getJmiHelper( );
        Set<AssociationEnd> ends = jmiHelper.getAssociationEnds( this.connection.getSession( ), (MofClass) this.wrappedClass, true /* includeSupertypes */);
        Set<AssociationEnd> result = new LinkedHashSet<AssociationEnd>( );
        for ( AssociationEnd end : ends ) {
            AssociationEnd otherEnd = ( (AssociationEndInternal) end ).otherEnd( connection );
            if ( otherEnd.getMultiplicity( ).getUpper( ) != 1 && jmiHelper.isEndStored( this.connection.getSession( ), end ) ) {
                result.add( otherEnd );
            }
        }
        return result;
    }

    public List<Attribute> getObjectValuedAttributesMultiplicityOne( ) {

        SpiJmiHelper jmiHelper = getJmiHelper( );
        List<Attribute> attributes = jmiHelper.getAttributes( this.connection.getSession( ), (MofClass) this.wrappedClass, true /* includeSupertypes */);
        List<Attribute> result = new ArrayList<Attribute>( );
        for ( Attribute attr : attributes ) {
            if ( jmiHelper.getNonAliasType( this.connection.getSession( ), attr ) instanceof MofClass && attr.getMultiplicity( ).getUpper( ) == 1 ) {
                result.add( attr );
            }
        }
        return result;
    }

    public List<Attribute> getObjectValuedAttributesMultiplicityMany( ) {

        SpiJmiHelper jmiHelper = getJmiHelper( );
        List<Attribute> attributes = jmiHelper.getAttributes( this.connection.getSession( ), (MofClass) this.wrappedClass, true /* includeSupertypes */);
        List<Attribute> result = new ArrayList<Attribute>( );
        for ( Attribute attr : attributes ) {
            if ( jmiHelper.getNonAliasType( this.connection.getSession( ), attr ) instanceof MofClass && attr.getMultiplicity( ).getUpper( ) != 1 ) {
                result.add( attr );
            }
        }
        return result;
    }

    public Set<Attribute> getObjectValuedAttributesTypedAsThisClass( ) {

        Set<Attribute> result = new LinkedHashSet<Attribute>( );
        IsOfType isOfType = ( (Partitionable) this.wrappedClass ).get___Connection( ).getAssociation( IsOfType.ASSOCIATION_DESCRIPTOR );
        Collection<TypedElement> typedElements = isOfType.getTypedElements( (MofClass) this.wrappedClass );
        for ( TypedElement typedElement : typedElements ) {
            if ( typedElement instanceof Attribute ) {
                result.add( (Attribute) typedElement );
            }
        }
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public String getDescriptorsBody( ) {

        StringBuilder sb = new StringBuilder( );
        SpiJmiHelper jmiHelper = getJmiHelper( );
        List metamodelElements = new ArrayList( );
        metamodelElements.addAll( jmiHelper.getAttributes( this.connection.getSession( ), (MofClass) this.wrappedClass, true /* includeSupertypes */) );
        metamodelElements.addAll( jmiHelper.getReferences( this.connection.getSession( ), (MofClass) this.wrappedClass, true /* includeSupertypes */) );
        List<ModelElement> allContent = getJmiHelper( ).getAllContent( this.connection, (MofClass) this.wrappedClass );
        for ( int i = 0, n = allContent.size( ); i < n; i++ ) {
            ModelElement me = allContent.get( i );
            if ( me instanceof Operation ) {
                metamodelElements.add( me );
            }
        }
        for ( int i = 0, n = metamodelElements.size( ); i < n; i++ ) {
            ModelElementInternal me = (ModelElementInternal) metamodelElements.get( i );
            String descriptorClass = null;
            String featureTypeForJavaDoc = null;
            Namespace container = me.getContainer( this.connection );
            boolean isOwnFeature = container.equals( this.wrappedClass );
            if ( me instanceof AttributeInternal ) {
                if ( ( (Attribute) me ).isDerived( ) ) {
                    continue;
                }
                descriptorClass = "com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor<com.sap.tc.moin.repository.mmi.model.Attribute,"; //$NON-NLS-1$
                if ( isOwnFeature ) {
                    descriptorClass += getJMIIdentifierQualified( this.wrappedClass ) + "," + getAttributeTypeGenerified( (AttributeInternal) me ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                } else {
                    descriptorClass += getJMIIdentifierQualified( (NamespaceInternal) me.getContainer( connection ) ) + "," + getAttributeTypeGenerified( (AttributeInternal) me ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                }
                featureTypeForJavaDoc = "attribute"; //$NON-NLS-1$
            } else if ( me instanceof ReferenceInternal ) {
                descriptorClass = "com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor<com.sap.tc.moin.repository.mmi.model.Reference,"; //$NON-NLS-1$
                if ( isOwnFeature ) {
                    descriptorClass += getJMIIdentifierQualified( this.wrappedClass ) + "," + getReferenceTypeGenerified( (ReferenceInternal) me ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                } else {
                    descriptorClass += getJMIIdentifierQualified( (NamespaceInternal) me.getContainer( connection ) ) + "," + getReferenceTypeGenerified( (ReferenceInternal) me ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                }
                featureTypeForJavaDoc = "reference"; //$NON-NLS-1$
            } else if ( me instanceof OperationInternal ) {
                descriptorClass = "com.sap.tc.moin.repository.mmi.descriptors.OperationDescriptor<com.sap.tc.moin.repository.mmi.model.Operation,"; //$NON-NLS-1$
                if ( isOwnFeature ) {
                    descriptorClass += getJMIIdentifierQualified( this.wrappedClass ) + "," + getOperationReturnTypeGenerified( (OperationInternal) me ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                } else {
                    descriptorClass += getJMIIdentifierQualified( (NamespaceInternal) me.getContainer( connection ) ) + "," + getOperationReturnTypeGenerified( (OperationInternal) me ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                }
                featureTypeForJavaDoc = "operation"; //$NON-NLS-1$
            }
            String identifier = jmiHelper.getJMIIdentifier( this.connection, (ModelElement) me );
            String upperCaseIdentifier = StringUtils.unCamelize( identifier, "_" ).toUpperCase( Locale.ENGLISH ); //$NON-NLS-1$
            if ( isOwnFeature ) {
                // Only generate __-variables for my own features, not those of my supertypes.
                sb.append( "private " ).append( descriptorClass ).append( " __" ); //$NON-NLS-1$  //$NON-NLS-2$
                sb.append( identifier ).append( ";\n" ); //$NON-NLS-1$
            }
            sb.append( "/**\n" ); //$NON-NLS-1$
            sb.append( " * Returns the descriptor for the <code>" ).append( identifier ).append( "</code> " ).append( featureTypeForJavaDoc ).append( ".\n" ); //$NON-NLS-1$ //$NON-NLS-2$  //$NON-NLS-3$
            sb.append( " * @return  the descriptor for the <code>" ).append( identifier ).append( "</code> " ).append( featureTypeForJavaDoc ).append( "\n" ); //$NON-NLS-1$ //$NON-NLS-2$  //$NON-NLS-3$
            sb.append( " */\n" ); //$NON-NLS-1$
            if ( isOwnFeature ) {
                sb.append( "public synchronized " ); //$NON-NLS-1$
            } else {
                sb.append( "public " ); //$NON-NLS-1$
            }
            sb.append( descriptorClass ).append( " " ).append( upperCaseIdentifier ).append( "( ) {\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( !isOwnFeature ) {
                String jmiInterfaceName = jmiHelper.getJmiInterfaceName( this.connection, container );
                sb.append( "    return " ).append( jmiInterfaceName ).append( ".DESCRIPTORS." ).append( upperCaseIdentifier ).append( "( );\n" ); //$NON-NLS-1$  //$NON-NLS-2$ //$NON-NLS-3$
            } else {
                sb.append( "    if ( __" ).append( identifier ).append( " == null ) {\n" ); //$NON-NLS-1$  //$NON-NLS-2$
                sb.append( "        __" ).append( identifier ).append( " = new " ).append( descriptorClass ).append( "( " ); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
                sb
                    .append( "\"" ).append( me.refMofId( ) ).append( "\", \"" ).append( getMetamodelName( ) ).append( "\", " ).append( getQualifiedNameAsStringArrayInitializer( me ) ).append( " ); " ).append( getNonNls( ( (ModelElementInternal) me ).getQualifiedName( connection ).size( ) + 2 ) ).append( "\n" ); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$   //$NON-NLS-4$ //$NON-NLS-5$
                sb.append( "    }\n" ); //$NON-NLS-1$
                sb.append( "    return __" ).append( identifier ).append( ";\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            sb.append( "}" ); //$NON-NLS-1$
            if ( i < n - 1 ) {
                sb.append( "\n" ); //$NON-NLS-1$
            }
        }
        return sb.toString( );
    }

    private String getOperationReturnTypeGenerified( OperationInternal operation ) {

        ParameterInternal returnParam = null;
        for ( Iterator<ModelElement> iterator = getAllContent( operation ); iterator.hasNext( ); ) {
            ModelElement me = iterator.next( );
            if ( me instanceof ParameterInternal ) {
                ParameterInternal p = (ParameterInternal) me;
                if ( p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                    returnParam = p;
                    break;
                }
            }
        }
        String type = "java.lang.Void"; //$NON-NLS-1$
        if ( returnParam != null ) {
            if ( isJavaType( returnParam.getType( connection ).getName( ) ) ) {
                // MOF PrimitiveType
                if ( returnParam.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = getJavaTypeClass( getType( returnParam.getType( connection ) ) );
                } else {
                    if ( returnParam.getMultiplicity( ).isOrdered( ) ) {
                        type = "java.util.List"; //$NON-NLS-1$
                    } else {
                        type = "java.util.Collection"; //$NON-NLS-1$
                    }
                    type += "<" + getParameterTypeParameter( returnParam ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                }
            } else {
                // NOT MOF PrimitiveType
                if ( returnParam.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = getType( returnParam.getType( connection ) );
                } else {
                    if ( returnParam.getMultiplicity( ).isOrdered( ) ) {
                        type = "java.util.List"; //$NON-NLS-1$
                    } else {
                        type = "java.util.Collection"; //$NON-NLS-1$
                    }
                    type += "<" + getParameterTypeParameter( returnParam ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
                }
            }
        }
        return type;
    }

}