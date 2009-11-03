package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.PackageExtent;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.cps.parser.CoreElementImpl;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl;
import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.core.cps.SpiParserCallbackInternal;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiAttributeInfo;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;

public final class MetamodelServiceImpl implements SpiMetamodelService {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_PARTITIONS, CoreParserCallbackImpl.class );

    private final CoreMoin moin;

    private final Map<String, SpiType> resolvedTypesCache;

    private final Map<String, SpiType> mofTypesCache;

    private ExtentManager extentManager;

    private MetamodelWorkspace metamodelWorkspace;

    private SpiJmiHelper jmiHelper;

    public MetamodelServiceImpl( CoreMoin moin ) {

        this.moin = moin;
        this.resolvedTypesCache = new IdentityHashMap<String, SpiType>( );
        this.mofTypesCache = new IdentityHashMap<String, SpiType>( );
    }

    public SpiClass getClass( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI pri, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        checkTypeInfo( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( indexMode && pri.isMetaModelPartition( ) ) {
            // In the metamodel case, we know that the parser is the MOIN internal parser, and that incompatible changes of the
            // MOF meta-metamodel will never occur (=> error handling is not required). If in addition we are in index mode,
            // we can skip the resolving, since the RefBaseObject is not needed.
            return (SpiClass) getOrCreateMofType( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        }
        if ( typeMofId != null ) {
            // typeMofId was provided by parser => lookup the type in our cache first
            String _typeMofId = typeMofId.intern( );
            SpiType resultFromCache = resolvedTypesCache.get( _typeMofId );
            if ( resultFromCache != null ) {
                return (SpiClass) resultFromCache;
            }
        }
        SpiType result = (SpiType) getRefClassOrRefAssociation( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( result == null || !( result instanceof RefClass ) ) {
            result = handleUnknownType( (PartitionSerializationManagerImpl) serializationManager, typeMofId, metamodelContainer, dotSeparatedQualifiedName, callback, pri );
        }
        if ( result != null && result instanceof SpiClass ) {
            resolvedTypesCache.put( result.get___MofId( ), result );
            return (SpiClass) result;
        }
        return null;
    }

    public SpiAssociation getAssociation( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI pri, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        checkTypeInfo( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( indexMode && pri.isMetaModelPartition( ) ) {
            // In the metamodel case, we know that the parser is the MOIN internal parser, and that incompatible changes of the
            // MOF meta-metamodel will never occur (=> error handling is not required). If in addition we are in index mode,
            // we can skip the resolving, since the RefBaseObject is not needed.
            return (SpiAssociation) getOrCreateMofType( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        }
        if ( typeMofId != null ) {
            // typeMofId was provided by parser => lookup the type in our cache first
            String _typeMofId = typeMofId.intern( );
            SpiType resultFromCache = resolvedTypesCache.get( _typeMofId );
            if ( resultFromCache != null ) {
                return (SpiAssociation) resultFromCache;
            }
        }
        SpiType result = (SpiType) getRefClassOrRefAssociation( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( result == null || !( result instanceof RefAssociation ) ) {
            result = handleUnknownType( (PartitionSerializationManagerImpl) serializationManager, typeMofId, metamodelContainer, dotSeparatedQualifiedName, callback, pri );
        }
        if ( result != null && result instanceof SpiAssociation ) {
            resolvedTypesCache.put( result.get___MofId( ), result );
            return (SpiAssociation) result;
        }
        return null;
    }

    public SpiStructureType getStructureType( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI pri, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        checkTypeInfo( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( indexMode && pri.isMetaModelPartition( ) ) {
            // In the metamodel case, we know that the parser is the MOIN internal parser, and that incompatible changes of the
            // MOF meta-metamodel will never occur (=> error handling is not required). If in addition we are in index mode,
            // we can skip the resolving, since the RefBaseObject is not needed.
            return (SpiStructureType) getOrCreateMofType( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        }
        if ( typeMofId != null ) {
            // typeMofId was provided by parser => lookup the type in our cache first
            String _typeMofId = typeMofId.intern( );
            SpiType resultFromCache = resolvedTypesCache.get( _typeMofId );
            if ( resultFromCache != null ) {
                return (SpiStructureType) resultFromCache;
            }
        }
        SpiType result = getStructureTypeInternal( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( result == null ) {
            result = handleUnknownType( (PartitionSerializationManagerImpl) serializationManager, typeMofId, metamodelContainer, dotSeparatedQualifiedName, callback, pri );
        }
        if ( result != null && result instanceof SpiStructureType ) {
            resolvedTypesCache.put( result.get___MofId( ), result );
            return (SpiStructureType) result;
        }
        return null;
    }

    private SpiStructureType getStructureTypeInternal( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        if ( typeMofId != null ) {
            CorePartitionable metamodelElement = getMetamodelWorkspace( ).getMetamodelElement( typeMofId );
            if ( metamodelElement != null ) {
                if ( metamodelElement instanceof StructureType ) {
                    return new StructureTypeWrapper( (StructureType) metamodelElement );
                }
            }
        }
        // Nothing found with typeMofId, now search by container and qualified name.
        String name = dotSeparatedQualifiedName.substring( dotSeparatedQualifiedName.lastIndexOf( '.' ) + 1 );
        String qualifiedNameOfContainer = dotSeparatedQualifiedName.substring( 0, dotSeparatedQualifiedName.lastIndexOf( '.' ) );
        RefBaseObject refClassOrRefPackage = getRefClassOrRefPackage( metamodelContainer, qualifiedNameOfContainer );
        if ( refClassOrRefPackage != null ) {
            Namespace namespace = (Namespace) refClassOrRefPackage.refMetaObject( );
            Map<String, ModelElement> allContentMap = getJmiHelper( ).getAllContentMap( null /* session */, namespace );
            ModelElement modelElement = allContentMap.get( name );
            if ( modelElement instanceof StructureType ) {
                return new StructureTypeWrapper( (StructureType) modelElement );
            }
        }
        return null;
    }

    public SpiType getType( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI pri, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        checkTypeInfo( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( indexMode && pri.isMetaModelPartition( ) ) {
            // In the metamodel case, we know that the parser is the MOIN internal parser, and that incompatible changes of the
            // MOF meta-metamodel will never occur (=> error handling is not required). If in addition we are in index mode,
            // we can skip the resolving, since the RefBaseObject is not needed.
            return getOrCreateMofType( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        }
        if ( typeMofId != null ) {
            // typeMofId was provided by parser => lookup the type in our cache first
            String _typeMofId = typeMofId.intern( );
            SpiType resultFromCache = resolvedTypesCache.get( _typeMofId );
            if ( resultFromCache != null ) {
                return resultFromCache;
            }
        }
        SpiType result = (SpiType) getRefClassOrRefAssociation( typeMofId, metamodelContainer, dotSeparatedQualifiedName );
        if ( result == null ) {
            result = handleUnknownType( (PartitionSerializationManagerImpl) serializationManager, typeMofId, metamodelContainer, dotSeparatedQualifiedName, callback, pri );
        }
        if ( result != null ) {
            resolvedTypesCache.put( result.get___MofId( ), result );
        }
        return result;
    }

    public Attribute getAttribute( SpiClass mofClass, String attributeName ) {

        return ( (RefClassImpl) mofClass ).getAttribute( attributeName );
    }

    public Classifier getType( Attribute attribute ) {

        return getJmiHelper( ).getNonAliasType( null /* session */, attribute );
    }

    public String getTypeMofId( SpiStructuredValueBase structuredValue ) {

        if ( !( structuredValue instanceof RefStructImpl ) ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.ARGUMENTISNOTARESOLVEDSTRUCTURETYPE );
        }
        return ( (RefStructImpl) structuredValue ).get___MetaObject( ).refMofId( );
    }

    public SpiValueTypeEnum getValueType( Classifier type ) {

        if ( type instanceof PrimitiveType ) {
            String name = type.getName( );
            if ( name.equals( "String" ) ) { //$NON-NLS-1$
                return SpiValueTypeEnum.PRIMITIVE_TYPE_STRING;
            } else if ( name.equals( "Boolean" ) ) { //$NON-NLS-1$
                return SpiValueTypeEnum.PRIMITIVE_TYPE_BOOLEAN;
            } else if ( name.equals( "Integer" ) ) { //$NON-NLS-1$
                return SpiValueTypeEnum.PRIMITIVE_TYPE_INTEGER;
            } else if ( name.equals( "Long" ) ) { //$NON-NLS-1$
                return SpiValueTypeEnum.PRIMITIVE_TYPE_LONG;
            } else if ( name.equals( "Double" ) ) { //$NON-NLS-1$
                return SpiValueTypeEnum.PRIMITIVE_TYPE_DOUBLE;
            } else if ( name.equals( "Float" ) ) { //$NON-NLS-1$
                return SpiValueTypeEnum.PRIMITIVE_TYPE_FLOAT;
            }
        } else if ( type instanceof EnumerationType ) {
            return SpiValueTypeEnum.ENUMERATION_TYPE;
        } else if ( type instanceof StructureType ) {
            return SpiValueTypeEnum.STRUCTURE_TYPE;
        } else if ( type instanceof MofClass ) {
            return SpiValueTypeEnum.OBJECT_TYPED;
        }
        return null;
    }

    public List<StructureField> getStructureFields( SpiStructuredValueBase structuredValue ) {

        if ( !( structuredValue instanceof RefStructImpl ) ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.ARGUMENTISNOTARESOLVEDSTRUCTURETYPE );
        }
        StructureType metaObject = (StructureType) ( (RefStructImpl) structuredValue ).get___MetaObject( );
        return getJmiHelper( ).getStructureFields( null /* session */, metaObject, true /* includeSuperTypes */);
    }

    public String calculateElementMofId( SpiClass mofClass, String[] logicalKey ) {

        if ( mofClass == null ) {
            throw new MoinIllegalNullArgumentException( "mofClass" ); //$NON-NLS-1$
        }
        return RefClassImpl.calculateMofId( logicalKey, mofClass.get___MofId( ) );
    }

    public boolean handleAttributeValueOfNonExistingMofClass( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

        if ( attributeValue instanceof ElementForNonExistingMofClass ) {
            // The attribute value is an instance of a deleted MofClass. Give the error handler of the responsible metamodel the 
            // chance to perform an automatic attribute value migration.
            String metamodelContainerName = ( (ElementForNonExistingMofClass) attributeValue ).get___Type( ).get___MetamodelContainer( );
            SpiParserErrorHandler errorHandler = ( (PartitionSerializationManagerImpl) serializationManager ).getParserErrorHandler( metamodelContainerName, null /* metamodelVersion */);
            if ( errorHandler != null ) {
                return errorHandler.handleIllegalAttributeValue( callback, element, attributeName, attributeValue );
            }
        }
        return false;
    }

    public Object resolveValueForType( SpiSession session, PRI parsedPartition, Classifier type, Object value, boolean indexMode ) {

        if ( type instanceof PrimitiveType ) {
            String _value = (String) value;
            String typeName = type.getName( );
            if ( XmiConstants.STRING_TYPE.equals( typeName ) ) {
                return value;
            } else if ( XmiConstants.BOOLEAN_TYPE.equals( typeName ) ) {
                return Boolean.valueOf( _value );
            } else if ( XmiConstants.INTEGER_TYPE.equals( typeName ) ) {
                try {
                    return Integer.valueOf( _value );
                } catch ( NumberFormatException ex ) {
                    return ILLEGAL_ATTRIBUTE_VALUE;
                }
            } else if ( XmiConstants.LONG_TYPE.equals( typeName ) ) {
                try {
                    return Long.valueOf( _value );
                } catch ( NumberFormatException ex ) {
                    return ILLEGAL_ATTRIBUTE_VALUE;
                }
            } else if ( XmiConstants.DOUBLE_TYPE.equals( typeName ) ) {
                try {
                    return new Double( _value );
                } catch ( NumberFormatException ex ) {
                    return ILLEGAL_ATTRIBUTE_VALUE;
                }
            } else if ( XmiConstants.FLOAT_TYPE.equals( typeName ) ) {
                try {
                    return new Float( _value );
                } catch ( NumberFormatException ex ) {
                    return ILLEGAL_ATTRIBUTE_VALUE;
                }
            }
        } else if ( type instanceof EnumerationType ) {
            RefEnum enumLiteral = getJmiHelper( ).getEnumerationConstantsMap( session, (EnumerationType) type ).get( value );
            if ( enumLiteral == null ) {
                return ILLEGAL_ATTRIBUTE_VALUE;
            }
            return enumLiteral;
        } else if ( type instanceof StructureType ) {
            if ( value instanceof SpiStructuredValueBase ) {
                SpiStructureType valueType = ( (SpiStructuredValueBase) value ).get___Type( );
                if ( valueType == null ) {
                    // V1
                    return createRefStruct( (CoreSession) session, parsedPartition, (StructureType) type, (SpiStructuredValueBase) value, indexMode );
                }
                // V2
                return createRefStruct( (CoreSession) session, parsedPartition, ( (StructureTypeWrapper) valueType ).getType( ), (SpiStructuredValueBase) value, indexMode );
            }
            return ILLEGAL_ATTRIBUTE_VALUE;
        } else if ( type instanceof MofClass ) { // object-valued attribute
            if ( value instanceof SpiElement ) {
                // 'value' is an inner-partition RefObject
                if ( indexMode || !( value instanceof CoreElementImpl ) ) {
                    return value;
                }
                return ( (CoreElementImpl) value ).getRefObject( );
            }
            // 'value' is the LRI of an external RefObject. Return it directly.
            return value;
        }
        return ILLEGAL_ATTRIBUTE_VALUE;
    }

    public LRI createLri( String facilityId, String dataAreaName, String mofId ) {

        return moin.createLri( facilityId, dataAreaName, mofId );
    }

    public SpiAttributeInfo createAttributeInfo( String name, String mofId, SpiValueTypeEnum type, boolean isMultiValued, boolean isObjectValued ) {

        return new AttributeInfo( name, mofId, type, isMultiValued, isObjectValued );
    }

    public SpiClass getClassForNonExistingMofClass( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName, List<SpiAttributeInfo> attributeInfos ) {

        return new NonExistingMofClass( typeMofId, metamodelContainer, dotSeparatedQualifiedName, attributeInfos );
    }

    public boolean isClassForNonExistingMofClass( SpiClass mofClass ) {

        return ( mofClass instanceof NonExistingMofClass );
    }

    public SpiElement createElementForNonExistingMofClass( SpiClass mofClass, String mofId ) {

        return new ElementForNonExistingMofClass( mofClass, mofId );
    }

    public SpiType getSpiType( Classifier classifier ) {

        SpiType result = resolvedTypesCache.get( classifier.refMofId( ) );
        if ( result == null ) {
            if ( classifier instanceof StructureType ) {
                result = new StructureTypeWrapper( (StructureType) classifier );
            } else {
                result = new ResolvedType( classifier );
            }
            resolvedTypesCache.put( classifier.refMofId( ), result );
        }
        return result;
    }

    public boolean linkEndCompatible( Session session, Association association, RefObject element, int endNumber ) {

        SpiJmiHelper helper = getJmiHelper( );
        AssociationEnd end = getJmiHelper( ).getAssociationEnds( session, association ).get( endNumber );
        return ( (RefObjectImpl) element ).refIsInstanceOf( (CoreSession) session, helper.getType( session, end ), true /* considerSubtypes */);
    }

    private void checkTypeInfo( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        if ( metamodelContainer == null ) {
            throw new MoinIllegalNullArgumentException( "metamodelContainer" ); //$NON-NLS-1$
        }
        if ( dotSeparatedQualifiedName == null ) {
            throw new MoinIllegalNullArgumentException( "dotSeparatedQualifiedName" ); //$NON-NLS-1$
        }
    }

    private SpiType getOrCreateMofType( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        String _typeMofId = typeMofId.intern( );
        SpiType result = mofTypesCache.get( _typeMofId );
        if ( result != null ) {
            return result;
        }
        mofTypesCache.put( _typeMofId, result = new UnresolvedType( typeMofId, metamodelContainer, dotSeparatedQualifiedName ) );
        return result;
    }

    private RefBaseObject getRefClassOrRefAssociation( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        if ( typeMofId == null ) {
            return getRefClassOrRefAssociation( metamodelContainer, dotSeparatedQualifiedName );
        }
        Extent extent = null;
        extent = getExtentManager( ).selectExtentForPartitionReader( typeMofId, dotSeparatedQualifiedName, metamodelContainer );
        if ( extent == null ) {
            // Check if the extent has not been found due to lazy MOF ROM initialization (OCL).
            if ( !getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).isSecondStageInjected( ) && dotSeparatedQualifiedName.startsWith( WorkspaceSet.OCL_PACKAGE_NAME ) ) {
                getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).injectSecondMofRomStage( );
                // Second try
                extent = getExtentManager( ).selectExtentForPartitionReader( typeMofId, dotSeparatedQualifiedName, metamodelContainer );
            }
        }
        if ( extent == null ) {
            return null;
        }
        if ( extent instanceof RefClass || extent instanceof RefAssociation ) {
            return extent;
        }
        return null;
    }

    private RefBaseObject getRefClassOrRefAssociation( String metamodelContainer, String dotSeparatedQualifiedName ) {

        String[] qName = StringUtils.split( dotSeparatedQualifiedName, '.' );
        if ( qName.length > 1 ) {
            Extent[] extents = getExtentManager( ).selectExtents( qName );
            if ( extents.length > 1 ) {
                for ( int i = 0; i < extents.length; i++ ) {
                    if ( ( (Partitionable) ( (RefBaseObject) extents[i] ).refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( ).equals( metamodelContainer ) ) {
                        return extents[i];
                    }
                }
            } else if ( extents.length == 1 ) {
                Extent extent = extents[0];
                if ( !( extent instanceof PackageExtent ) ) {
                    if ( ( (Partitionable) ( (RefBaseObject) extent ).refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( ).equals( metamodelContainer ) ) {
                        return extent;
                    }
                }
            }
        }
        return null;
    }

    private RefBaseObject getRefClassOrRefPackage( String metamodelContainer, String dotSeparatedQualifiedName ) {

        String[] qName = StringUtils.split( dotSeparatedQualifiedName, '.' );
        Extent[] extents = getExtentManager( ).selectExtents( qName );
        if ( extents.length > 1 ) {
            for ( int i = 0; i < extents.length; i++ ) {
                if ( ( (Partitionable) ( (RefBaseObject) extents[i] ).refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( ).equals( metamodelContainer ) ) {
                    return extents[i];
                }
            }
        } else if ( extents.length == 1 ) {
            Extent extent = extents[0];
            if ( ( (Partitionable) ( (RefBaseObject) extent ).refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( ).equals( metamodelContainer ) ) {
                return extent;
            }
        }
        return null;
    }

    private SpiType handleUnknownType( PartitionSerializationManagerImpl serializationManager, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName, SpiParserCallback callback, PRI partition ) {

        SpiType result = null;
        SpiParserErrorHandler errorHandler = serializationManager.getParserErrorHandler( metamodelContainer, null /* modelVersion */);
        if ( errorHandler != null ) {
            try {
                if ( JMX_ENABLED && serializationManager.jmxNotificationsEnabled ) {
                    Map<String, String> args = new LinkedHashMap<String, String>( );
                    args.put( "PRI", partition.toString( ) ); // $NON-NLS-1$ //$NON-NLS-1$
                    args.put( "TypeMofID", String.valueOf( typeMofId ) ); // $NON-NLS-1$ //$NON-NLS-1$
                    args.put( "MetamodelContainer", metamodelContainer ); // $NON-NLS-1$ //$NON-NLS-1$
                    args.put( "QualifiedName", dotSeparatedQualifiedName ); // $NON-NLS-1$ //$NON-NLS-1$
                    serializationManager.errorHandlerStart( errorHandler, "handleUnknownType", args ); // $NON-NLS-1$ //$NON-NLS-1$
                }
                result = errorHandler.handleUnknownType( callback, typeMofId, metamodelContainer, dotSeparatedQualifiedName );
                if ( JMX_ENABLED && serializationManager.jmxNotificationsEnabled ) {
                    serializationManager.errorHandlerEnd( errorHandler, result != null, "handleUnknownType" ); // $NON-NLS-1$ //$NON-NLS-1$
                }
            } catch ( Throwable t ) {
                if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                    LOGGER.trace( t, MoinSeverity.ERROR, "Error handler {0} threw exception while parsing {1}", new Object[] { errorHandler.toString( ), partition.toString( ) } ); //$NON-NLS-1$
                }
            }
        }

        SpiParserCallbackInternal callbackInternal = (SpiParserCallbackInternal) callback;
        callbackInternal.markHadErrorsDuringLoad( );

        if ( result == null ) {
            callbackInternal.markHadUnhandledErrorsDuringLoad( );

            // Either there was no error handler, or the error handler failed to resolve the type, too. 
            // Minimal own handling: log the incident and continue 
            if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                LOGGER.trace( MoinSeverity.ERROR, "Encountered unknown type (PRI: " + partition + ", type: " + getTypeString( typeMofId, metamodelContainer, dotSeparatedQualifiedName ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return result;
    }

    private String getTypeString( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        return "[MOF id: " + typeMofId + ", metamodel: " + metamodelContainer + ", qualified name: " + dotSeparatedQualifiedName + "]"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
    }

    private MetamodelWorkspace getMetamodelWorkspace( ) {

        if ( metamodelWorkspace == null ) {
            metamodelWorkspace = moin.getMetamodelWorkspace( );
        }
        return metamodelWorkspace;
    }

    private ExtentManager getExtentManager( ) {

        if ( extentManager == null ) {
            extentManager = moin.getExtentManager( );
        }
        return extentManager;
    }

    public SpiJmiHelper getJmiHelper( ) {

        if ( jmiHelper == null ) {
            jmiHelper = getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        }
        return jmiHelper;
    }

    private Object createRefStruct( CoreSession session, PRI parsedPartition, StructureType structureType, SpiStructuredValueBase structuredValue, boolean indexMode ) {

        List<Object> fieldValues = new ArrayList<Object>( );
        List<StructureField> structureFields = getJmiHelper( ).getStructureFields( session, structureType, true /* includeSupertypes */);
        //FIXME HACK!!!
        CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
        for ( int i = 0, n = structureFields.size( ); i < n; i++ ) {
            StructureField field = structureFields.get( i );
            Classifier fieldType = getJmiHelper( ).getType( session, field );
            Object parsedValue = structuredValue.get___FieldValue( field.getName( ) );
            if ( parsedValue == null ) {
                // In the current metamodel, the StructureType has a StructureField for which the parser returned no value
                // => the StructureField must have been added later on, and we are currently parsing a legacy partition
                // This use case must be supported; we choose a corresponding default value for the StructureField.
                fieldValues.add( getJavaDefaultValue( session, fieldType ) );
            } else {
                Object _value = resolveValueForType( session, parsedPartition, fieldType, parsedValue, indexMode );
                if ( _value == ILLEGAL_ATTRIBUTE_VALUE ) {
                    return ILLEGAL_ATTRIBUTE_VALUE;
                }
                fieldValues.add( _value );
            }
        }
        Namespace namespace = ( (StructureTypeInternal) structureType ).getContainer( connection );
        RefBaseObject proxy = getExtentManager( ).getDefaultExtentForMetaObject( (GeneralizableElement) namespace );
        if ( proxy instanceof RefClass ) {
            return ( (RefClassImpl) proxy ).refCreateStruct( connection, structureType, fieldValues );
        }
        return ( (RefPackageImpl) proxy ).refCreateStruct( connection, structureType, fieldValues );
    }

    private Object getJavaDefaultValue( CoreSession session, Classifier fieldType ) {

        Classifier type = getJmiHelper( ).getNonAliasType( session, fieldType );
        if ( type instanceof PrimitiveType ) {
            String name = type.getName( );
            if ( name.equals( "Boolean" ) ) { //$NON-NLS-1$
                return false;
            } else if ( name.equals( "Integer" ) ) {//$NON-NLS-1$
                return 0;
            } else if ( name.equals( "Long" ) ) {//$NON-NLS-1$
                return 0;
            } else if ( name.equals( "Double" ) ) {//$NON-NLS-1$
                return 0;
            } else if ( name.equals( "Float" ) ) {//$NON-NLS-1$
                return 0;
            }
        }
        // For the PrimitiveType "String", EnumerationType and StructureType we return 'null'.
        return null;
    }

    private static final class UnresolvedType implements SpiClass, SpiAssociation, SpiStructureType {

        private final String mofId;

        private final String metamodelContainer;

        private final String qualifiedName;

        public UnresolvedType( String mofId, String metamodelContainer, String qualifiedName ) {

            this.mofId = mofId;
            this.metamodelContainer = metamodelContainer;
            this.qualifiedName = qualifiedName;
        }

        public String get___MofId( ) {

            return mofId;
        }

        public String get___MetamodelContainer( ) {

            return metamodelContainer;
        }

        public String get___QualifiedName( ) {

            return qualifiedName;
        }

        public String get___MetamodelVersion( ) {

            return null;
        }

        public SpiValueTypeEnum get___AttributeTypeAsEnum( String attributeName ) {

            // TODO Auto-generated method stub
            return null;
        }

        public String get___AttributeMofId( String attributeName ) {

            // TODO Auto-generated method stub
            return null;
        }

        public List<String> get___AttributeNames( ) {

            return null;
        }

        public boolean is___MultiValuedAttribute( String attributeName ) {

            return false;
        }

        public int get___CompositeEndNumber( ) {

            return -1;
        }

        public int get___OrderedEndNumber( ) {

            return -1;
        }

        public int get___StoredEndNumber( ) {

            return -1;
        }

        public Collection<String> get___ReferenceNames( ) {

            return null;
        }

        public boolean is___MultiValuedReference( String referenceName ) {

            return false;
        }

        public int get___EndNumber( String nameOfAssociationEnd ) {

            return -1;
        }

        public SpiClass get___EndType( int endNumber ) {

            return null;
        }

        public SpiType get___AttributeType( String attributeName ) {

            // TODO Auto-generated method stub
            return null;
        }

        public List<SpiType> get___AllSuperTypes( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public boolean is___ObjectValuedAttribute( String attributeName ) {

            // TODO Auto-generated method stub
            return false;
        }
    }

    private static final class StructureTypeWrapper implements SpiStructureType {

        private final StructureType type;

        public StructureTypeWrapper( StructureType structureType ) {

            this.type = structureType;
        }

        public StructureType getType( ) {

            return type;
        }

        @SuppressWarnings( "unchecked" )
        public List<SpiType> get___AllSuperTypes( ) {

            List result = null;
            List<GeneralizableElement> supertypes = ( (CorePartitionable) type ).get___JmiHelper( ).getAllSupertypes( null /* session */, type );
            if ( !supertypes.isEmpty( ) ) {
                result = new ArrayList( supertypes.size( ) );
                for ( int i = 0, n = supertypes.size( ); i < n; i++ ) {
                    result.add( new StructureTypeWrapper( (StructureType) supertypes.get( i ) ) );
                }
            }
            if ( result != null ) {
                return result;
            }
            return Collections.emptyList( );
        }

        public String get___MetamodelContainer( ) {

            return ( (CorePartitionable) type ).get___Partition( ).getPri( ).getContainerName( );
        }

        public String get___MetamodelVersion( ) {

            CoreModelPartition partition = ( (CorePartitionable) type ).get___Partition( );
            SpiMetamodelRegistry metamodelRegistry = partition.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getMetaModelRegistry( );
            CRI metaObjectCri = partition.getPri( ).getCri( );
            MetaModelVersion deployedMetaModelVersion = metamodelRegistry.getMetaModelVersion( metaObjectCri );
            if ( deployedMetaModelVersion != null ) {
                return deployedMetaModelVersion.getVersionString( );
            }

            return null;
        }

        public String get___MofId( ) {

            return type.refMofId( );
        }

        public String get___QualifiedName( ) {

            return QualifiedName.toDotSeparatedString( ( (ClassifierInternal) type ).getQualifiedName( null /* connection */) );
        }
    }

    private static final class NonExistingMofClass implements SpiClass {

        private final String mofId;

        private final String metamodelContainer;

        private final String qualifiedName;

        private final List<String> attributeNames;

        private final Map<String, SpiValueTypeEnum> attributeTypes;

        private final Map<String, String> attributeMofIds;

        private final Set<String> multiValuedAttributes;

        private final Set<String> objectValuedAttributes;

        public NonExistingMofClass( String mofId, String metamodelContainer, String qualifiedName, List<SpiAttributeInfo> attributeInfos ) {

            this.mofId = mofId;
            this.metamodelContainer = metamodelContainer;
            this.qualifiedName = qualifiedName;
            int size = attributeInfos.size( );
            int mapSize = Utilities.calcInitialCapacity( size );
            this.attributeNames = new ArrayList<String>( size );
            this.attributeTypes = new HashMap<String, SpiValueTypeEnum>( mapSize );
            this.attributeMofIds = new HashMap<String, String>( mapSize );
            this.multiValuedAttributes = new HashSet<String>( );
            this.objectValuedAttributes = new HashSet<String>( );
            for ( int i = 0; i < size; i++ ) {
                SpiAttributeInfo info = attributeInfos.get( i );
                this.attributeNames.add( info.getName( ) );
                this.attributeTypes.put( info.getName( ), info.getType( ) );
                this.attributeMofIds.put( info.getName( ), info.getMofId( ) );
                if ( info.isMultiValued( ) ) {
                    this.multiValuedAttributes.add( info.getName( ) );
                }
                if ( info.isObjectValued( ) ) {
                    this.objectValuedAttributes.add( info.getName( ) );
                }
            }
        }

        public String get___MofId( ) {

            return mofId;
        }

        public String get___MetamodelContainer( ) {

            return metamodelContainer;
        }

        public String get___QualifiedName( ) {

            return qualifiedName;
        }

        public String get___AttributeMofId( String attributeName ) {

            return attributeMofIds.get( attributeName );
        }

        public List<String> get___AttributeNames( ) {

            return attributeNames;
        }

        public SpiValueTypeEnum get___AttributeTypeAsEnum( String attributeName ) {

            return attributeTypes.get( attributeName );
        }

        public boolean is___MultiValuedAttribute( String attributeName ) {

            return multiValuedAttributes.contains( attributeName );
        }

        public String get___MetamodelVersion( ) {

            throw new MoinUnsupportedOperationException( "get___MetamodelVersion( )" ); //$NON-NLS-1$
        }

        public SpiType get___AttributeType( String attributeName ) {

            throw new MoinUnsupportedOperationException( "get___AttributeType( )" ); //$NON-NLS-1$
        }

        public List<SpiType> get___AllSuperTypes( ) {

            throw new MoinUnsupportedOperationException( "get___AllSuperTypes( )" ); //$NON-NLS-1$
        }

        public boolean is___ObjectValuedAttribute( String attributeName ) {

            SpiValueTypeEnum spiValueTypeEnum = attributeTypes.get( attributeName );
            if ( spiValueTypeEnum != null ) {
                return spiValueTypeEnum == SpiValueTypeEnum.OBJECT_TYPED;
            }

            return false;
        }
    }

    private static final class AttributeInfo implements SpiAttributeInfo {

        private final String name;

        private final String mofId;

        private final SpiValueTypeEnum type;

        private final boolean isMultivalued;

        private final boolean isObjectValued;

        public AttributeInfo( String name, String mofId, SpiValueTypeEnum type, boolean isMultivalued, boolean isObjectValued ) {

            this.name = name;
            this.mofId = mofId;
            this.type = type;
            this.isMultivalued = isMultivalued;
            this.isObjectValued = isObjectValued;
        }

        public String getMofId( ) {

            return mofId;
        }

        public String getName( ) {

            return name;
        }

        public SpiValueTypeEnum getType( ) {

            return type;
        }

        public boolean isMultiValued( ) {

            return isMultivalued;
        }

        public boolean isObjectValued( ) {

            return isObjectValued;
        }
    }

    private static final class ElementForNonExistingMofClass implements SpiElement {

        private final SpiClass mofClass;

        private final String mofId;

        private final Map<String, Object> attributeValues;

        public ElementForNonExistingMofClass( SpiClass mofClass, String mofId ) {

            this.mofClass = mofClass;
            this.mofId = mofId;
            this.attributeValues = new LinkedHashMap<String, Object>( );
        }

        public void add___ElementValue( String attributeName, SpiElement element ) {

            addOrSetAttributeValue( attributeName, element );
        }

        public void add___ExternalElementValue( String attributeName, LRI lriOfExternalElement ) {

            addOrSetAttributeValue( attributeName, lriOfExternalElement );
        }

        public void add___PrimitiveOrEnumerationValue( String attributeName, String primitiveOrEnumValue ) {

            addOrSetAttributeValue( attributeName, primitiveOrEnumValue );
        }

        public void add___StructuredValue( String attributeName, SpiStructuredValueBase structuredValue ) {

            addOrSetAttributeValue( attributeName, structuredValue );
        }

        public Object get___AttributeValue( String attributeName ) {

            return attributeValues.get( attributeName );
        }

        public String get___MofId( ) {

            return mofId;
        }

        public SpiClass get___Type( ) {

            return mofClass;
        }

        @SuppressWarnings( "unchecked" )
        private void addOrSetAttributeValue( String attributeName, Object value ) {

            Object existingValue = attributeValues.get( attributeName );
            if ( existingValue == null ) {
                attributeValues.put( attributeName, value );
            } else if ( existingValue instanceof List ) {
                ( (List) existingValue ).add( value );
            } else { // single value already exists => convert to list
                List<Object> list = new ArrayList<Object>( );
                list.add( existingValue );
                list.add( value );
                attributeValues.put( attributeName, list );
            }
        }

        @Override
        public String toString( ) {

            StringBuilder sb = new StringBuilder( "Instance of non-existing MofClass " + mofClass.get___QualifiedName( ) + ", attribute values: {" ); //$NON-NLS-1$ //$NON-NLS-2$
            for ( Iterator<Entry<String, Object>> entryIt = attributeValues.entrySet( ).iterator( ); entryIt.hasNext( ); ) {
                Entry<String, Object> entry = entryIt.next( );
                sb.append( entry.getKey( ) ).append( "=" ).append( String.valueOf( entry.getValue( ) ) ); //$NON-NLS-1$
                if ( entryIt.hasNext( ) ) {
                    sb.append( ',' );
                }
            }
            sb.append( "}" ); //$NON-NLS-1$
            return sb.toString( );
        }
    }

    private static final class ResolvedType implements SpiType {

        private final Classifier type;

        ResolvedType( Classifier type ) {

            this.type = type;
        }

        @SuppressWarnings( "unchecked" )
        public List<SpiType> get___AllSuperTypes( ) {

            List result = null;
            if ( type instanceof MofClass ) {
                SpiJmiHelper jmiHelper = ( (CorePartitionable) type ).get___JmiHelper( );
                List<GeneralizableElement> supertypes = jmiHelper.getAllSupertypes( null /* session */, type );
                if ( !supertypes.isEmpty( ) ) {
                    result = new ArrayList( supertypes.size( ) );
                    for ( int i = 0, n = supertypes.size( ); i < n; i++ ) {
                        MofClass mc = (MofClass) supertypes.get( i );
                        result.add( jmiHelper.getRefClassForMofClass( null /* session */, mc ) );
                    }
                }
            } else if ( type instanceof StructureType ) {
                List<GeneralizableElement> supertypes = ( (CorePartitionable) type ).get___JmiHelper( ).getAllSupertypes( null /* session */, type );
                if ( !supertypes.isEmpty( ) ) {
                    result = new ArrayList( supertypes.size( ) );
                    for ( int i = 0, n = supertypes.size( ); i < n; i++ ) {
                        result.add( new ResolvedType( (Classifier) supertypes.get( i ) ) );
                    }
                }
            }
            if ( result != null ) {
                return result;
            }
            return Collections.emptyList( );
        }

        public String get___MetamodelContainer( ) {

            return ( (CorePartitionable) type ).get___Partition( ).getPri( ).getContainerName( );
        }

        public String get___MetamodelVersion( ) {

            CoreModelPartition partition = ( (CorePartitionable) type ).get___Partition( );
            SpiMetamodelRegistry metamodelRegistry = partition.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getMetaModelRegistry( );
            CRI metaObjectCri = partition.getPri( ).getCri( );
            MetaModelVersion deployedMetaModelVersion = metamodelRegistry.getMetaModelVersion( metaObjectCri );
            if ( deployedMetaModelVersion != null ) {
                return deployedMetaModelVersion.getVersionString( );
            }

            return null;
        }

        public String get___MofId( ) {

            return type.refMofId( );
        }

        public String get___QualifiedName( ) {

            return QualifiedName.toDotSeparatedString( ( (ClassifierInternal) type ).getQualifiedName( /* connection */null ) );
        }
    }
}
