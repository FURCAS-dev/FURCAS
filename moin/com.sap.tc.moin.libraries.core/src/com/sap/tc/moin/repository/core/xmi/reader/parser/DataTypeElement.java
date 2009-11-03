package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;

/**
 * This class is instantiated if &lt;Model:DataType&gt; (or
 * &lt;Model.DataType&gt;, respectively), containing Corba type definitions, was
 * found in the XMI. This can only occur during the import of a legacy MOF 1.3
 * metamodel, because in MOF 1.4 the DataType class was made abstract.
 * <p>
 * This class performs an automatic migration of the contained Corba type
 * definitions to the datatypes defined in the MOF 1.4 type system
 * (PrimitiveType, AliasType, EnumerationType, StructureType). The MOF 1.4
 * CollectionType is currently not supported.
 */
class DataTypeElement extends XmiElement {

    private static Map<String /* corbaTypeCode */, String /* primitiveTypeName */> corbaPrimitiveTypeCodes;

    private static Map<String /* primitiveTypeName */, String /* primitiveTypeMri */> mofPrimitiveTypesMRIs;

    static {
        corbaPrimitiveTypeCodes = new HashMap<String, String>( );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcShort, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcLong, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcUShort, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcULong, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcChar, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcWChar, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcOctet, XmiConstants.INTEGER_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcFloat, XmiConstants.FLOAT_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcDouble, XmiConstants.DOUBLE_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcLongDouble, XmiConstants.DOUBLE_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcBoolean, XmiConstants.BOOLEAN_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcString, XmiConstants.STRING_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcWString, XmiConstants.STRING_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcLongLong, XmiConstants.LONG_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcULongLong, XmiConstants.LONG_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcULongLong, XmiConstants.LONG_TYPE );
        corbaPrimitiveTypeCodes.put( XmiConstants.XMICorbaTcAny, XmiConstants.ANY_TYPE );
        mofPrimitiveTypesMRIs = new HashMap<String, String>( );
        String mriPrefix = "PF.MetaModelDataArea:" + MoinMofRomServicesImpl.MOFROM_MODELPARTITIONS_PREFIX + "PrimitiveTypes." + MetaModelCatalog.META_MODEL_EXTENSION + "#"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        mofPrimitiveTypesMRIs.put( "PrimitiveTypes", mriPrefix + "45ED2E2A9B676E5825E742FD3D27AC08D5F6FAF0" ); //$NON-NLS-1$  //$NON-NLS-2$
        mofPrimitiveTypesMRIs.put( XmiConstants.BOOLEAN_TYPE, mriPrefix + "45ED2E2ABBF58675823844DE052F9021020D6080" ); //$NON-NLS-1$
        mofPrimitiveTypesMRIs.put( XmiConstants.INTEGER_TYPE, mriPrefix + "45ED2E2AF04E629AF53140CA2A2CAC07493531C9" ); //$NON-NLS-1$
        mofPrimitiveTypesMRIs.put( XmiConstants.STRING_TYPE, mriPrefix + "45ED2E2A31B10AA5EF924C3A3316F6D2078D4CF4" ); //$NON-NLS-1$
        mofPrimitiveTypesMRIs.put( XmiConstants.LONG_TYPE, mriPrefix + "45ED2E2AFC07FF42BE3044B03ECDC5DE2DC6E2BF" ); //$NON-NLS-1$
        mofPrimitiveTypesMRIs.put( XmiConstants.DOUBLE_TYPE, mriPrefix + "45ED2E2AD36C3F6E412642672D19FD075222ADA2" ); //$NON-NLS-1$
        mofPrimitiveTypesMRIs.put( XmiConstants.FLOAT_TYPE, mriPrefix + "45ED2E2AD30EAAD3F45945B03D5095FE7AFB9CF2" ); //$NON-NLS-1$
    }

    // indicates if the typeCode attribute is currently processed
    private boolean typeCodeReading;

    // stores current node when tree structure of XMI elements is being created
    private CorbaNode node;

    // possibly stores xmi.id of this DataType value
    private String xmiId;

    private String dataTypeName;

    // the annotation of the type
    private String annotation;

    // a StringBuilder for the type's annotation in case it's serialized as a nested element <Model:ModelElement.annotation>
    private StringBuilder annotationBuilder;

    /**
     * The InstanceInfo instance that will ultimately be returned in the
     * ParserResult.
     */
    private InstanceInfo info;

    DataTypeElement( XmiElement parent, XmiContext context, Attributes attrs ) {

        super( parent, context );
        xmiId = attrs.getValue( XmiConstants.XMI_ID );
        dataTypeName = attrs.getValue( "name" ); //$NON-NLS-1$
        annotation = attrs.getValue( "annotation" ); //$NON-NLS-1$
        node = null;
        typeCodeReading = false;
        annotationBuilder = null;
        info = null;
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        if ( !typeCodeReading ) {
            if ( qName.endsWith( "typeCode" ) ) { //$NON-NLS-1$
                typeCodeReading = true;
            } else if ( qName.equals( "Model:ModelElement.annotation" ) || qName.equals( "Model.ModelElement.annotation" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                annotationBuilder = new StringBuilder( );
            }
            return this;
        }
        if ( ( node == null ) && ( !( qName.equals( XmiConstants.XMI_CORBA_TYPE_CODE ) ) ) ) {
            throw new XmiParseException( XMI.MOIN_XMI_1038, new Object[] { qName } );
        }
        node = new CorbaNode( qName, attrs, annotation, node );
        return this;
    }

    @Override
    void characters( char[] buf, int offset, int len ) {

        if ( annotationBuilder != null ) {
            annotationBuilder.append( new String( buf, offset, len ) );
        }
    }

    @Override
    XmiElement endElement( String qName ) {

        if ( annotationBuilder != null ) {
            annotation = annotationBuilder.toString( );
            annotationBuilder = null;
        }
        if ( typeCodeReading ) {
            if ( node.parent != null ) {
                node = node.parent;
            } else {
                typeCodeReading = false;
            }
            return this;
        }
        if ( !( qName.endsWith( ":DataType" ) ) && !( qName.endsWith( ".DataType" ) ) ) { //$NON-NLS-1$ //$NON-NLS-2$
            return this;
        }
        info = resolveCorbaType( node, false /* nestedCall */);
        if ( !( parent instanceof Content ) ) {
            parent.receiveValue( info );
        }
        return parent;
    }

    /**
     * The main dispatching method for analyzing a CorbaNode tree.
     */
    private InstanceInfo resolveCorbaType( CorbaNode node, boolean nestedCall ) {

        CorbaNode subNode = node.firstSubNode( );
        String typeName = subNode.getName( );
        InstanceInfo result = null;
        if ( corbaPrimitiveTypeCodes.containsKey( typeName ) ) {
            result = resolveCorbaPrimitive( subNode, nestedCall );
        } else if ( typeName.equals( XmiConstants.XMICorbaTcEnum ) ) {
            result = resolveCorbaEnum( subNode );
        } else if ( typeName.equals( XmiConstants.XMICorbaTcAlias ) ) {
            result = resolveCorbaAlias( subNode );
        } else if ( typeName.equals( XmiConstants.XMICorbaTcStruct ) ) {
            result = resolveCorbaStruct( subNode );
        } else {
            throw new XmiParseException( XMI.MOIN_XMI_1065, new Object[] { typeName } );
        }
        if ( !nestedCall ) {
            context.instanceComplete( xmiId, result );
        }
        return result;
    }

    /**
     * Handles &lt;XMI.CorbaTcEnum&gt;.
     */
    private InstanceInfo resolveCorbaEnum( CorbaNode node ) {

        List<String> enumLabels = new ArrayList<String>( );
        for ( Iterator it = node.getSubnodes( ).iterator( ); it.hasNext( ); ) {
            CorbaNode labelNode = (CorbaNode) it.next( );
            if ( labelNode.getName( ).equals( XmiConstants.XMICorbaTcEnumLabel ) ) {
                enumLabels.add( labelNode.getTcName( ) );
            }
        }
        return createEnumerationType( dataTypeName, annotation, enumLabels );
    }

    /**
     * Handles Corba primitive types like &lt;XMI.CorbaTcBoolean&gt;,
     * &lt;XMI.CorbaTcString&gt;, etc.
     */
    private InstanceInfo resolveCorbaPrimitive( CorbaNode node, boolean nestedCall ) {

        String mappedMofPrimitiveType = corbaPrimitiveTypeCodes.get( node.getName( ) );
        if ( nestedCall ) {
            InstanceInfo result = createPrimitiveType( mappedMofPrimitiveType, node.getAnnotation( ), true /* linkOnly */);
            createPrimitiveTypesImport( );
            return result;
        } else {
            // Determine the DataTypes's qualified name.
            StringBuilder buf = new StringBuilder( );
            buf.insert( 0, dataTypeName );
            XmiElement parentElement = getParentElement( );
            while ( parentElement != null ) {
                if ( parentElement instanceof Instance ) {
                    buf.insert( 0, '.' );
                    buf.insert( 0, ( (Instance) parentElement ).getValueOfNameAttr( ) );
                }
                parentElement = parentElement.getParentElement( );
            }
            String qualifiedName = buf.toString( );
            if ( qualifiedName.equals( "PrimitiveTypes." + dataTypeName ) || qualifiedName.equals( "CorbaIdlTypes." + dataTypeName ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                if ( context.isMofMode( ) ) {
                    return createPrimitiveType( dataTypeName, node.getAnnotation( ), false /* linkOnly */);
                } else {
                    return createPrimitiveType( mappedMofPrimitiveType, node.getAnnotation( ), true /* linkOnly */);
                }
            } else {
                if ( mappedMofPrimitiveType.equals( XmiConstants.ANY_TYPE ) ) {
                    return createPrimitiveType( dataTypeName, node.getAnnotation( ), false /* linkOnly */);
                } else {
                    InstanceInfo primitiveType = createPrimitiveType( mappedMofPrimitiveType, node.getAnnotation( ), true /* linkOnly */);
                    createPrimitiveTypesImport( );
                    return createAliasType( mappedMofPrimitiveType, node.getAnnotation( ), primitiveType );
                }
            }
        }
    }

    /**
     * Handles &lt;XMI.CorbaTcAlias&gt;. Note that only those Corba aliases are
     * supported which are aliases to primitive types.
     */
    private InstanceInfo resolveCorbaAlias( CorbaNode node ) {

        String name = node.getTcName( );
        InstanceInfo type = resolveCorbaType( node.firstSubNode( ), true /* nestedCall */);
        if ( !type.getType( ).getName( ).equals( "PrimitiveType" ) ) { //$NON-NLS-1$
            throw new XmiParseException( XMI.MOIN_XMI_1066, new Object[] { node.firstSubNode( ).firstSubNode( ).getName( ) } );
        }
        return createAliasType( name, node.getAnnotation( ), type );
    }

    /**
     * Handles &lt;XMI.CorbaTcStruct&gt;. Note that only those Corba structures
     * are supported whose fields are primitively typed.
     */
    private InstanceInfo resolveCorbaStruct( CorbaNode node ) {

        InstanceInfo fieldType;
        String name = node.getTcName( );
        InstanceInfo structureTypeInfo = createStructureType( name, node.getAnnotation( ) );
        for ( Iterator it = node.getSubnodes( ).iterator( ); it.hasNext( ); ) {
            CorbaNode fieldNode = (CorbaNode) it.next( );
            String fieldName = fieldNode.getTcName( );
            fieldType = resolveCorbaType( fieldNode.firstSubNode( ), true );
            if ( !fieldType.getType( ).getName( ).equals( "PrimitiveType" ) ) { //$NON-NLS-1$
                throw new XmiParseException( XMI.MOIN_XMI_1067, new Object[] { fieldNode.firstSubNode( ).firstSubNode( ).getName( ) } );
            }
            createStructureField( fieldName, structureTypeInfo, fieldType );
        }
        return structureTypeInfo;
    }

    /**
     * Creates an InstanceInfo representing a MOF 1.4 PrimitiveType.
     */
    private InstanceInfo createPrimitiveType( String name, String annotation, boolean linkOnly ) {

        InstanceInfo result = null;
        // name, annotation, isRoot, isLeaf, isAbstract, visibility
        List<Object> attributeValues = new ArrayList<Object>( 6 );
        Map<String, Object> attributeValuesByName = new HashMap<String, Object>( );
        attributeValues.add( name ); // name
        attributeValuesByName.put( "name", name ); //$NON-NLS-1$
        attributeValues.add( annotation ); // annotation
        attributeValuesByName.put( "annotation", annotation ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isRoot
        attributeValuesByName.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isLeaf
        attributeValuesByName.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isAbstract
        attributeValuesByName.put( "isAbstract", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( VisibilityKindEnum.PUBLIC_VIS );
        attributeValuesByName.put( "visibility", VisibilityKindEnum.PUBLIC_VIS ); //$NON-NLS-1$
        XmiElement parentModelElement = getParentModelElement( );
        InstanceInfo parentInfo = ( parentModelElement != null && parentModelElement instanceof Instance ) ? ( (Instance) parentModelElement ).getInfo( ) : null;
        MofClassInternal primitiveTypeClass = (MofClassInternal) context.resolveQualifiedName( "Model.PrimitiveType" ); //$NON-NLS-1$
        if ( !linkOnly ) {
            result = new InstanceInfo( context.getCurrentURI( ), null /* mofId */, primitiveTypeClass, parentInfo, xmiId );
        } else {
            result = new InstanceInfo( context.getCurrentURI( ), mofPrimitiveTypesMRIs.get( name ) /* mofId */, primitiveTypeClass, parentInfo, xmiId );
        }
        result.setAttributeValues( attributeValues );
        result.setAttributeValuesByName( attributeValuesByName );
        return result;
    }

    /**
     * Creates an InstanceInfo representing a MOF 1.4 EnumerationType.
     */
    private InstanceInfo createEnumerationType( String name, String annotation, List labels ) {

        // name, annotation, isRoot, isLeaf, isAbstract, visibility, labels
        List<Object> attributeValues = new ArrayList<Object>( 7 );
        Map<String, Object> attributesByName = new HashMap<String, Object>( );
        attributeValues.add( dataTypeName ); // name
        attributesByName.put( "name", dataTypeName ); //$NON-NLS-1$
        attributeValues.add( annotation ); // annotation
        attributesByName.put( "annotation", annotation ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isRoot
        attributesByName.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isLeaf
        attributesByName.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isAbstract
        attributesByName.put( "isAbstract", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( VisibilityKindEnum.PUBLIC_VIS );
        attributesByName.put( "visibility", VisibilityKindEnum.PUBLIC_VIS ); //$NON-NLS-1$
        attributeValues.add( labels ); // labels
        attributesByName.put( "labels", labels ); //$NON-NLS-1$
        MofClassInternal type = (MofClassInternal) context.resolveQualifiedName( "Model.EnumerationType" ); //$NON-NLS-1$
        XmiElement parentModelElement = getParentModelElement( );
        InstanceInfo parentInfo = ( parentModelElement != null && parentModelElement instanceof Instance ) ? ( (Instance) parentModelElement ).getInfo( ) : null;
        InstanceInfo info = new InstanceInfo( context.getCurrentURI( ), null, type, parentInfo, xmiId );
        info.setAttributeValues( attributeValues );
        info.setAttributeValuesByName( attributesByName );
        return info;
    }

    /**
     * Creates an InstanceInfo representing a MOF 1.4 AliasType.
     */
    private InstanceInfo createAliasType( String name, String annotation, InstanceInfo classifier ) {

        // name, annotation, isRoot, isLeaf, isAbstract, visibility
        List<Object> attributeValues = new ArrayList<Object>( 6 );
        Map<String, Object> attributesByName = new HashMap<String, Object>( );
        attributeValues.add( name ); // name
        attributesByName.put( "name", name ); //$NON-NLS-1$
        attributeValues.add( annotation ); // annotation
        attributesByName.put( "annotation", annotation ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isRoot
        attributesByName.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isLeaf
        attributesByName.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isAbstract
        attributesByName.put( "isAbstract", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( VisibilityKindEnum.PUBLIC_VIS );
        attributesByName.put( "visibility", VisibilityKindEnum.PUBLIC_VIS ); //$NON-NLS-1$
        MofClassInternal aliasTypeClass = (MofClassInternal) context.resolveQualifiedName( "Model.AliasType" ); //$NON-NLS-1$
        XmiElement parentModelElement = getParentModelElement( );
        InstanceInfo parentInfo = ( parentModelElement != null && parentModelElement instanceof Instance ) ? ( (Instance) parentModelElement ).getInfo( ) : null;
        InstanceInfo info = new InstanceInfo( context.getCurrentURI( ), null, aliasTypeClass, parentInfo, xmiId );
        info.setAttributeValues( attributeValues );
        info.setAttributeValuesByName( attributesByName );
        // Create a link of the IsOfType association to the given classifier.
        AssociationInternal isOfType = (AssociationInternal) context.resolveQualifiedName( "Model.IsOfType" ); //$NON-NLS-1$
        context.linkComplete( isOfType, classifier, info );
        return info;
    }

    /**
     * Creates an InstanceInfo representing a MOF 1.4 Import to the
     * PrimitiveTypes package.
     */
    private void createPrimitiveTypesImport( ) {

        InstanceInfo packageInfo = getImmediatePackage( );
        if ( context.hasPrimitiveTypesImport( packageInfo ) ) {
            return;
        }
        // name, annotation, visibility, isClustered
        List<Object> attributeValues = new ArrayList<Object>( 4 );
        Map<String, Object> attributesByName = new HashMap<String, Object>( );
        attributeValues.add( "PrimitiveTypes" ); // name //$NON-NLS-1$
        attributesByName.put( "name", "PrimitiveTypes" ); //$NON-NLS-1$ //$NON-NLS-2$
        attributeValues.add( "" ); //$NON-NLS-1$ annotation
        attributesByName.put( "annotation", "" ); //$NON-NLS-1$  //$NON-NLS-2$
        attributeValues.add( VisibilityKindEnum.PUBLIC_VIS );
        attributesByName.put( "visibility", VisibilityKindEnum.PUBLIC_VIS ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isClustered
        attributesByName.put( "isClustered", Boolean.FALSE ); //$NON-NLS-1$
        MofClassInternal type = (MofClassInternal) context.resolveQualifiedName( "Model.Import" ); //$NON-NLS-1$
        InstanceInfo importInfo = new InstanceInfo( context.getCurrentURI( ), null /* mofId */, type, packageInfo, xmiId );
        importInfo.setAttributeValues( attributeValues );
        importInfo.setAttributeValuesByName( attributesByName );
        context.addPrimitiveTypesImport( packageInfo, importInfo );
        AssociationInternal contains = (AssociationInternal) context.resolveQualifiedName( "Model.Contains" ); //$NON-NLS-1$
        context.linkComplete( contains, packageInfo, importInfo );
        AssociationInternal aliases = (AssociationInternal) context.resolveQualifiedName( "Model.Aliases" ); //$NON-NLS-1$
        InstanceInfo ptpInfo = createPrimitiveTypesPackage( );
        context.linkComplete( aliases, importInfo, ptpInfo );
    }

    /**
     * Creates an InstanceInfo representing the MOF 1.4 PrimitiveTypes package.
     */
    private InstanceInfo createPrimitiveTypesPackage( ) {

        // name, annotation, isRoot, isLeaf, isAbstract, visibility
        List<Object> attributeValues = new ArrayList<Object>( 6 );
        Map<String, Object> attributesByName = new HashMap<String, Object>( );
        attributeValues.add( "PrimitiveTypes" ); // name //$NON-NLS-1$
        attributesByName.put( "name", "PrimitiveTypes" ); //$NON-NLS-1$ //$NON-NLS-2$
        attributeValues.add( annotation ); // annotation
        attributesByName.put( "annotation", "" ); //$NON-NLS-1$  //$NON-NLS-2$
        attributeValues.add( Boolean.FALSE ); // isRoot
        attributesByName.put( "isRoot", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isLeaf
        attributesByName.put( "isLeaf", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isAbstract
        attributesByName.put( "isAbstract", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( VisibilityKindEnum.PUBLIC_VIS );
        attributesByName.put( "visibility", VisibilityKindEnum.PUBLIC_VIS ); //$NON-NLS-1$
        MofClassInternal packageClass = (MofClassInternal) context.resolveQualifiedName( "Model.Package" ); //$NON-NLS-1$
        // TODO get the correct uri for the primitive types package
        InstanceInfo info = new InstanceInfo( "PrimitiveTypes.xml", mofPrimitiveTypesMRIs.get( "PrimitiveTypes" ), packageClass, null /* parent */, xmiId ); //$NON-NLS-1$ //$NON-NLS-2$
        info.setAttributeValues( attributeValues );
        info.setAttributeValuesByName( attributesByName );
        return info;
    }

    /**
     * Creates an InstanceInfo representing a MOF 1.4 StructureType.
     */
    private InstanceInfo createStructureType( String name, String annotation ) {

        // name, annotation, isRoot, isLeaf, isAbstract, visibility
        List<Object> attributeValues = new ArrayList<Object>( 6 );
        Map<String, Object> attributesByName = new HashMap<String, Object>( );
        attributeValues.add( name ); // name
        attributesByName.put( "name", name ); //$NON-NLS-1$
        attributeValues.add( annotation ); // annotation
        attributesByName.put( "annotation", "" ); //$NON-NLS-1$  //$NON-NLS-2$
        attributeValues.add( Boolean.TRUE ); // isRoot
        attributesByName.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.TRUE ); // isLeaf
        attributesByName.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
        attributeValues.add( Boolean.FALSE ); // isAbstract
        attributesByName.put( "isAbstract", Boolean.FALSE ); //$NON-NLS-1$
        attributeValues.add( VisibilityKindEnum.PUBLIC_VIS );
        attributesByName.put( "visibility", VisibilityKindEnum.PUBLIC_VIS ); //$NON-NLS-1$
        MofClassInternal structureTypeClass = (MofClassInternal) context.resolveQualifiedName( "Model.StructureType" ); //$NON-NLS-1$
        XmiElement parentModelElement = getParentModelElement( );
        InstanceInfo parentInfo = ( parentModelElement != null && parentModelElement instanceof Instance ) ? ( (Instance) parentModelElement ).getInfo( ) : null;
        InstanceInfo info = new InstanceInfo( context.getCurrentURI( ), null /* mofId */, structureTypeClass, parentInfo, xmiId );
        info.setAttributeValues( attributeValues );
        info.setAttributeValuesByName( attributesByName );
        return info;
    }

    /**
     * Creates an InstanceInfo representing a MOF 1.4 StructureField.
     */
    private InstanceInfo createStructureField( String name, InstanceInfo structureTypeInfo, InstanceInfo fieldTypeInfo ) {

        // name, annotation
        List<Object> attributeValues = new ArrayList<Object>( 2 );
        Map<String, Object> attributesByName = new HashMap<String, Object>( );
        attributeValues.add( name ); // name
        attributesByName.put( "name", name ); //$NON-NLS-1$
        attributeValues.add( "" ); //$NON-NLS-1$ annotation
        attributesByName.put( "annotation", "" ); //$NON-NLS-1$  //$NON-NLS-2$
        MofClassInternal structureFieldClass = (MofClassInternal) context.resolveQualifiedName( "Model.StructureField" ); //$NON-NLS-1$
        String xmiId = structureTypeInfo.getXmiId( ) + name;
        InstanceInfo structureFieldInfo = new InstanceInfo( context.getCurrentURI( ), null, structureFieldClass, structureTypeInfo, xmiId );
        structureFieldInfo.setAttributeValues( attributeValues );
        structureFieldInfo.setAttributeValuesByName( attributesByName );
        context.instanceComplete( xmiId, structureFieldInfo );
        AssociationInternal isOfType = (AssociationInternal) context.resolveQualifiedName( "Model.IsOfType" ); //$NON-NLS-1$
        context.linkComplete( isOfType, fieldTypeInfo, structureFieldInfo );
        AssociationInternal contains = (AssociationInternal) context.resolveQualifiedName( "Model.Contains" ); //$NON-NLS-1$
        context.linkComplete( contains, structureTypeInfo, structureFieldInfo );
        return structureFieldInfo;
    }

    /**
     * Returns the first parent XMI element that represents a model element
     * (i.e. an XmiElement of type {@link Instance}).
     */
    private XmiElement getParentModelElement( ) {

        XmiElement parentModelElement = parent;
        while ( !( parentModelElement instanceof Content ) && !( parentModelElement instanceof Instance ) ) {
            parentModelElement = parentModelElement.getParentElement( );
        }
        return parentModelElement;
    }

    /**
     * Walks up the XMI element hierarchy until an {@link Instance} representing
     * a MOF package is found, and returns it.
     */
    private InstanceInfo getImmediatePackage( ) {

        XmiElement parentPackage = parent;
        while ( true ) {
            if ( parentPackage instanceof Content ) {
                return null;
            }
            if ( parentPackage instanceof Instance ) {
                MofClassInternal mc = ( (Instance) parentPackage ).getType( );
                if ( mc.getName( ).equals( "Package" ) ) { //$NON-NLS-1$
                    break;
                }
            }
            parentPackage = parentPackage.getParentElement( );
        }
        return ( (Instance) parentPackage ).getInfo( );
    }

    /**
     * Returns the {@link InstanceInfo} of this DataType element.
     */
    InstanceInfo getInfo( ) {

        return info;
    }

    /**
     * Small helper class that represents a tree of Corba type definitions found
     * in the XMI.
     */
    private static class CorbaNode {

        // parent node of this node, null in case of a root
        CorbaNode parent;

        // list of all direct sub-nodes
        List<CorbaNode> subnodes = new ArrayList<CorbaNode>( );

        // name of this XMI element
        String name;

        // value of xmi.tcName attribute (if present, otherwise null)
        String tcName;

        // the annotation of the type
        String annotation;

        CorbaNode( String name, Attributes attrs, String annotation, CorbaNode parent ) {

            this.parent = parent;
            this.name = name;
            this.annotation = annotation;
            tcName = attrs.getValue( XmiConstants.XMI_TCNAME );
            if ( parent != null ) {
                parent.addSubNode( this );
            }
        }

        void addSubNode( CorbaNode subNode ) {

            subnodes.add( subNode );
        }

        String getName( ) {

            return name;
        }

        CorbaNode firstSubNode( ) {

            return subnodes.get( 0 );
        }

        String getAnnotation( ) {

            return annotation;
        }

        List getSubnodes( ) {

            return subnodes;
        }

        String getTcName( ) {

            return tcName;
        }
    }
}
