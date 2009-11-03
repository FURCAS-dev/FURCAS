package com.sap.tc.moin.xm.generation.core.metamodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.xml.XMLConstants;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeGroupDefinition;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeContent;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDConstraint;
import org.eclipse.xsd.XSDContentTypeCategory;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.XSDVariety;
import org.eclipse.xsd.XSDWildcard;
import org.eclipse.xsd.util.XSDConstants;

import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.XmGenerationMessages;
import com.sap.tc.moin.xm.generation.core.XmGenerationProtocolImpl;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmAttribute;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmClass;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmPackage;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmPrimitiveType;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmReference;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmRootPackage;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmStructuralFeature;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmXsdComponentKind;
import com.sap.tc.moin.xm.generation.core.metamodel.util.XmMofNameBuilder;

/**
 * Importer of an XML Schema. An XML schema is transformed to an internal MOIN
 * like representation (see package <tt>om</tt>) of meta model. The basic
 * concept is that
 * <ul>
 * <li>a MOIN class with name "DocumentRoot" is created which gets attributes
 * for global element declarations with simple type definition and associations
 * to the MOIN classes which correspond to the complex type definitions o global
 * element declarations</li>
 * <li>a MOIN class is created for each complex type definition</li>
 * <li>an element declaration with simple type definition is transformed to a
 * MOIN attribute</li>
 * <li>an attribute declaration is transformed to a MOIN attribute</li>
 * <li>an element declaration with complex type definition which is referenced
 * by a complex type definition is transformed into a MOIN reference and MOIN
 * association between the two MOIN classes corresponding to the two complex
 * type definitions</li>
 * <ul>
 */
public final class XmMetaModelGenerator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmMetaModelGenerator.class );

    private final XmGeneratorInput input;

    private final XmGenerationProtocolImpl protocol;

    /*
     * Map between the root package names and the root packages. A meta model
     * can have several root packages. The first entry of the linked map
     * corresponds to the target namespace of the root schema.
     */
    private final Map<String, XmRootPackage> rootPackages = new LinkedHashMap<String, XmRootPackage>( );

    private final Map<String, XmPrimitiveType> xsdSimpleTypesToDataTypes;

    private final Map<XSDSimpleTypeDefinition, XmPrimitiveType> xsdSimpleTypeDefToMoinPrimitiveType = new HashMap<XSDSimpleTypeDefinition, XmPrimitiveType>( );

    /*
     * The following map for the classes of complex type definitions is a
     * LinkedHashMap! First the class hierarchy according to the base type
     * hierarchy of the complex type definitions is built without filling the
     * contents of the classes. The super classes are added first to the map.
     * Then the contents by iterating over the entries of the map are filled;
     * this means that the contents of the super classes are filled first. This
     * is necessary because a sub-class must not contain attributes or
     * references which have the same MOF name as an attribute or reference of
     * any super class.
     */
    private final Map<XSDComplexTypeDefinition, XmClass> xsdComplexTypeToMoinClass = new LinkedHashMap<XSDComplexTypeDefinition, XmClass>( );

    // contains either MOIN attributes or MOIN references
    private final Map<XSDFeature, XmStructuralFeature> xsdFeatureToModelElement = new HashMap<XSDFeature, XmStructuralFeature>( );

    private XmClass documentRootClass;

    // maps the global element declarations (which are not abstract) to the features of the document root
    private final Map<XSDElementDeclaration, XmStructuralFeature> featuresOfDocumentRoot = new LinkedHashMap<XSDElementDeclaration, XmStructuralFeature>( );;

    /*
     * Namespace to package map. The key values are sorted. Does not contain the
     * no-namespace!
     */
    private final Map<String, XmPackage> namespaceToPackage = new LinkedHashMap<String, XmPackage>( );

    public XmMetaModelGenerator( final XmGeneratorInput aInput, final XmGenerationProtocolImpl aProtocol ) {

        if ( aInput == null ) {
            throw new MoinNullPointerException( "aInput" ); //$NON-NLS-1$
        }
        if ( aProtocol == null ) {
            throw new MoinNullPointerException( "aProtocol" ); //$NON-NLS-1$
        }
        this.input = aInput;
        this.protocol = aProtocol;
        xsdSimpleTypesToDataTypes = initPrimitiveTypes( );
    }

    /**
     * Generates an internal representation of the meta-model (see package
     * <tt>om</tt>) and then the MOIN meta-model if requested by the input.
     * <p>
     * In more detail, the following steps are executed:
     * <ul>
     * <li>1. Create XmPackages for the target namespaces</li>
     * <li>2. Create XmClasses for global complex type definitions without
     * mapping the content of the Complex Type Definitions and set inheritance
     * relations</li>
     * <li>3. Map the anonymous complex type definitions of global element
     * declarations to XmClasses (without mapping the content of the complex
     * type definitions), set inheritance relations, and create the XmReference
     * and XmAssociation with the Document Root class</li>
     * <li>4. Map the contents of the Complex Type Definitions</li>
     * <li>5. Create the MOF metamodel elements, if requested</li>
     * </ul>
     * The importing of complex content is skipped in step 2 and 3 to avoid
     * cycles if two complex type definitions are related to each other.
     */
    public void createMetaModel( ) {

        LOGGER.trace( MoinSeverity.INFO, "Generation of intermediate metamodel started" ); //$NON-NLS-1$
        if ( this.input.generateMetamodel( ) ) {
            this.clearPartition( );
        }
        this.createPackages( );
        this.createDocumentRootClass( );
        this.importGlobalXSDComponents( );
        this.importClassContents( );
        LOGGER.trace( MoinSeverity.INFO, "Generation of intermediate metamodel finished" ); //$NON-NLS-1$
        if ( this.input.generateMetamodel( ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Generation of metamodel in partition {0} started", this.input.getMetamodelPartition( ) ); //$NON-NLS-1$
            this.createMofElements( );
        }
        LOGGER.trace( MoinSeverity.DEBUG, "Simple type definition to MOF primitive type: {0} ", this.xsdSimpleTypeDefToMoinPrimitiveType ); //$NON-NLS-1$
        if ( this.input.generateMetamodel( ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Generation of metamodel in partition {0} finished", this.input.getMetamodelPartition( ) ); //$NON-NLS-1$
        }
    }

    private void createDocumentRootClass( ) {

        // first root package is root package of document root
        final XmRootPackage rootPackage = this.rootPackages.values( ).iterator( ).next( );
        this.documentRootClass = new XmClass( this.input, "DocumentRoot", rootPackage.getTargetNamespace( ), rootPackage, false, XmXsdComponentKind.DocumentRoot, XSDContentTypeCategory.ELEMENT_ONLY_LITERAL ); //$NON-NLS-1$
    }

    private void createDocumentRootClassFeature( final XSDElementDeclaration elDec ) {

        if ( elDec.isAbstract( ) ) {
            // abstract element declaration must not be added to the document root, because they
            // do not define a root element.
            return;
        }
        if ( this.featuresOfDocumentRoot.get( elDec ) == null ) {
            if ( elDec.getTypeDefinition( ) instanceof XSDSimpleTypeDefinition ) {
                final XmPrimitiveType dataType = importSimpleTypeDefinition( (XSDSimpleTypeDefinition) elDec.getTypeDefinition( ) );
                final XmAttribute attribute = new XmAttribute( this.input, elDec.getName( ), this.documentRootClass, 0, 1, dataType, true, XmXsdComponentKind.GlobalElement );
                LOGGER.trace( MoinSeverity.DEBUG, "Attribute {0} created in Document Root class for global element declaration {1}", new Object[] { attribute.getMofName( ), elDec.getAliasURI( ) } ); //$NON-NLS-1$
                this.featuresOfDocumentRoot.put( elDec, attribute );
            } else {
                // with complex type
                final XmClass referencedClass = this.xsdComplexTypeToMoinClass.get( elDec.getTypeDefinition( ) );
                final XmReference reference = new XmReference( this.input, elDec.getName( ), this.documentRootClass, 0, 1, referencedClass, XmXsdComponentKind.GlobalElement );
                LOGGER.trace( MoinSeverity.DEBUG, "Reference {0} created in Document Root class for global element declaration {1}", new Object[] { reference.getMofName( ), elDec.getAliasURI( ) } ); //$NON-NLS-1$
                this.featuresOfDocumentRoot.put( elDec, reference );
            }
        }
    }

    /**
     * Removes all model elements from the meta model partition, without
     * deleting the links pointing into the model partition. Remark: The
     * following situation can occur: Suppose an external link points to a
     * meta-model element before the generation, and the meta-model element is
     * deleted after the generation. So we get a dangling link. We do not delete
     * this dangling link.
     */
    private void clearPartition( ) {

        final RefObjectUtil util = UtilitiesFactory.getRefObjectUtil( );
        for ( final Partitionable el : this.input.getMetamodelPartition( ).getElements( ) ) {
            util.deleteIsolated( (RefObject) el );
        }
    }

    /**
     * For each target namespace a package is created. If a target namespace
     * starts like another target namespace then the package of the target
     * namespace gets the package of the other target namespace as parent
     * package.
     * <p>
     * If the schema has no namespace and no imports then a root package is
     * calculated from the schema file uri.
     */
    private void createPackages( ) {

        // determine target namespaces without no-namespace, if the root schema has a target namespace different 
        // from the no-namespace than the first entry of the set is this target namespace
        final Set<String> targetNamespaces = XmMofNameBuilder.getTargetNamespaces( input.getSchema( ) );
        if ( targetNamespaces.size( ) == 0 ) {
            // only no-namespace
            this.createRootPackageFromFileUri( );
            LOGGER.trace( MoinSeverity.DEBUG, "No namespace maps to root package {0}", this.rootPackages.values( ).iterator( ).next( ) ); //$NON-NLS-1$ 
        } else {
            if ( this.input.getSchema( ).getTargetNamespace( ) == null || this.input.getSchema( ).getTargetNamespace( ).length( ) == 0 ) {
                // target namespace of root schema is no-namespace --> add first this no-namespace to root packages
                this.createRootPackageFromFileUri( );
                LOGGER.trace( MoinSeverity.DEBUG, "No namespace maps to root package {0}", this.rootPackages.values( ).iterator( ).next( ) ); //$NON-NLS-1$
            }
            this.createPackages( targetNamespaces );
            LOGGER.trace( MoinSeverity.DEBUG, "Namespace to package map: {0}", this.namespaceToPackage ); //$NON-NLS-1$
        }
    }

    private void createPackages( final Set<String> targetNamespaces ) {

        if ( targetNamespaces == null ) {
            throw new MoinNullPointerException( "targetNamespaces" ); //$NON-NLS-1$
        }
        if ( targetNamespaces.size( ) == 0 ) {
            throw new MoinIllegalArgumentException( "targetNamespaces", "" ); //$NON-NLS-1$//$NON-NLS-2$
        }
        final List<String> nsList = new ArrayList<String>( );
        nsList.addAll( targetNamespaces );
        Collections.sort( nsList );
        for ( final String ns : nsList ) {
            if ( this.namespaceToPackage.size( ) == 0 ) {
                // --> root package, you cannot check here  this.rootPackages.size(), 
                // because  this.rootPackages may already contain one entry for the no-namespace              
                this.createRootPackage( ns );
            } else {
                final List<String> nsOfExistingPackages = new ArrayList<String>( );
                nsOfExistingPackages.addAll( this.namespaceToPackage.keySet( ) );
                Collections.reverse( nsOfExistingPackages );
                String namespaceOfParent = null;
                for ( final String nsOfExistingPackage : nsOfExistingPackages ) {
                    if ( ns.startsWith( nsOfExistingPackage ) ) {
                        namespaceOfParent = nsOfExistingPackage;
                        break;
                    }
                }
                if ( namespaceOfParent != null ) {
                    // build sub-package of existing package
                    final XmPackage parentPackage = this.namespaceToPackage.get( namespaceOfParent );
                    String packageName = XmMofNameBuilder.buildMofPackageName( ns.substring( namespaceOfParent.length( ) ) );
                    if ( packageName.length( ) == 0 ) {
                        // sub-package must have a name, use "package"
                        packageName = XmMofNameBuilder.PACKAGE;
                    }
                    final XmPackage xmPackage = new XmPackage( this.input, packageName, parentPackage );
                    namespaceToPackage.put( ns, xmPackage );
                } else {
                    // build root-package
                    this.createRootPackage( ns );
                }
            }
        }
    }


    /**
     * Returns the target namespaces of the XML schema after the call of method
     * {@link #createMetaModel()}.
     * 
     * @return set of namespaces, cannot be <code>null</code>, the no-namespace
     * is not contained
     */
    public Set<String> getNamespaces( ) {

        return this.namespaceToPackage.keySet( );
    }

    /**
     * Returns the class for the document root.
     * 
     * @return class for the document root, is not <code>null</code> if the
     * method {@lind #createMetaModel()} was called before
     */
    public XmClass getDocumentRootClass( ) {

        return this.documentRootClass;
    }

    /**
     * Returns the map containing the global element declarations and the
     * corresponding MOIN features of the document root class.
     * 
     * @return map, cannot be <code>null</code>
     */
    public Map<XSDElementDeclaration, XmStructuralFeature> getGlobalElementToDocumentRootFeatureMap( ) {

        return this.featuresOfDocumentRoot;
    }


    /**
     * Returns the map containing the mapping from the XSD features to the MOIN
     * model elements after the call of method {@link #createMetaModel()}.
     * 
     * @return map, cannot be <code>null</code>
     */
    public Map<XSDFeature, XmStructuralFeature> getXsdFeatureToModelElementMap( ) {

        return this.xsdFeatureToModelElement;
    }

    /**
     * Returns the map containing the mapping from the XSD complex type
     * definitions to the MOIN classes.
     * 
     * @return map, cannot be <code>null</code>
     */
    public Map<XSDComplexTypeDefinition, XmClass> getXsdComplexTypeDefToXmClass( ) {

        return this.xsdComplexTypeToMoinClass;
    }

    private HashMap<String, XmPrimitiveType> initPrimitiveTypes( ) {

        final XmPrimitiveType stringXmPrimitiveType = new XmPrimitiveType( this.input, "String" );//$NON-NLS-1$
        final XmPrimitiveType integerXmPrimitiveType = new XmPrimitiveType( this.input, "Integer" ); //$NON-NLS-1$
        final XmPrimitiveType booleanXmPrimitiveType = new XmPrimitiveType( this.input, "Boolean" ); //$NON-NLS-1$
        final XmPrimitiveType doubleXmPrimitiveType = new XmPrimitiveType( this.input, "Double" ); //$NON-NLS-1$
        final XmPrimitiveType floatXmPrimitiveType = new XmPrimitiveType( this.input, "Float" ); //$NON-NLS-1$
        final XmPrimitiveType longXmPrimitiveType = new XmPrimitiveType( this.input, "Long" ); //$NON-NLS-1$

        final HashMap<String, XmPrimitiveType> xsdTypesToPrimitiveTypesMap = new HashMap<String, XmPrimitiveType>( );

        xsdTypesToPrimitiveTypesMap.put( "long", longXmPrimitiveType ); //$NON-NLS-1$
        xsdTypesToPrimitiveTypesMap.put( "int", integerXmPrimitiveType ); //$NON-NLS-1$
        xsdTypesToPrimitiveTypesMap.put( "boolean", booleanXmPrimitiveType ); //$NON-NLS-1$
        xsdTypesToPrimitiveTypesMap.put( "float", floatXmPrimitiveType ); //$NON-NLS-1$
        xsdTypesToPrimitiveTypesMap.put( "double", doubleXmPrimitiveType ); //$NON-NLS-1$
        xsdTypesToPrimitiveTypesMap.put( "string", stringXmPrimitiveType ); //$NON-NLS-1$

        return xsdTypesToPrimitiveTypesMap;
    }



    /**
     * Returns the XM primitive type corresponding to a XSD build-in type.
     * 
     * @param typeDefinition XSD built-in type
     * @return XM primitive type
     */
    private XmPrimitiveType getMoinPrimitiveTypeForXsdBuildInType( final XSDSimpleTypeDefinition typeDefinition ) {

        final String name = typeDefinition.getName( );
        XmPrimitiveType dataType = xsdSimpleTypesToDataTypes.get( name );
        if ( dataType == null ) {
            if ( name.equals( "short" ) ) { //$NON-NLS-1$
                dataType = xsdSimpleTypesToDataTypes.get( "int" ); //$NON-NLS-1$
            } else if ( name.equals( "byte" ) ) { //$NON-NLS-1$
                dataType = xsdSimpleTypesToDataTypes.get( "int" ); //$NON-NLS-1$
            } else if ( name.equals( "unsignedInt" ) ) { //$NON-NLS-1$
                dataType = xsdSimpleTypesToDataTypes.get( "long" ); //$NON-NLS-1$
            } else if ( name.equals( "unsignedShort" ) ) { //$NON-NLS-1$
                dataType = xsdSimpleTypesToDataTypes.get( "int" ); //$NON-NLS-1$
            } else if ( name.equals( "unsignedByte" ) ) { //$NON-NLS-1$
                dataType = xsdSimpleTypesToDataTypes.get( "int" ); //$NON-NLS-1$
            } else {
                dataType = xsdSimpleTypesToDataTypes.get( "string" ); //$NON-NLS-1$
            }
            xsdSimpleTypesToDataTypes.put( name, dataType );
        }
        return dataType;
    }


    private static final Pattern V_NUMBER_PATTERN = Pattern.compile( "v[0-9]*" ); //$NON-NLS-1$

    /**
     * Calculates form a target namespace a MOIN root package.
     * 
     * @param targetNamespace
     * @return root package
     * @throws NullPointerException if the parameter is <code>null</code>
     * @throws IllegalArgumentException if the parameter is an empty string or
     * no URI
     */
    private void createRootPackage( final String targetNamespace ) {

        if ( targetNamespace == null ) {
            throw new MoinNullPointerException( "targetNamespace" );//$NON-NLS-1$
        }
        if ( targetNamespace.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "targetNamespace", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        final List<String> uriAsList = this.getUriAsList( targetNamespace );
        if ( !uriAsList.isEmpty( ) ) {
            // get root package name
            String rootPackageName = null;
            int indexOfRootPackageName = -1;
            int lastNotEmptyPartIndex = -1;
            int index = -1;
            String lastNotEmptyPart = null;
            for ( String part : uriAsList ) {
                index++;
                part = XmMofNameBuilder.buildMofPackageName( part );
                if ( V_NUMBER_PATTERN.matcher( part ).matches( ) ) {
                    // the v at the beginning must be introduced in the pattern, because MofNameBuilder.buildMofPackageName() adds
                    // a v to a part which consists only of numbers; do nothing
                } else {
                    // not only numbers
                    if ( part.length( ) > 0 ) {
                        // part not empty
                        rootPackageName = part;
                        indexOfRootPackageName = index;
                    }
                }
                if ( part.length( ) > 0 ) {
                    lastNotEmptyPart = part;
                    lastNotEmptyPartIndex = index;
                }
            }

            if ( indexOfRootPackageName == -1 ) {
                // target namespace consists only of numbers or not allowed characters
                // use last part
                rootPackageName = lastNotEmptyPart;
                indexOfRootPackageName = lastNotEmptyPartIndex;
            }

            // java prefix (do not add the root package name)
            final StringBuilder javaPrefix = new StringBuilder( );
            for ( int i = 0; i < uriAsList.size( ); i++ ) {
                final String part = XmMofNameBuilder.buildMofPackageName( uriAsList.get( i ) );
                if ( i != indexOfRootPackageName && !( part.length( ) == 0 ) ) {
                    if ( javaPrefix.length( ) > 0 ) {
                        javaPrefix.append( '.' );
                    }
                    javaPrefix.append( part );
                }
            }
            if ( rootPackageName == null || rootPackageName.length( ) == 0 ) {
                // can happen when the target namespace contains only not allowed characters
                if ( javaPrefix.toString( ).length( ) == 0 ) {
                    // MOFIDs of meta-model elements are calculated from their qualified names.
                    // Use a GUID in the name to ensure uniqueness of the MOFIDs.
                    rootPackageName = XmMofNameBuilder.getPackageNameWithGuid( );
                } else {
                    // Use constant "package"
                    rootPackageName = XmMofNameBuilder.PACKAGE;
                }
            }

            final XmRootPackage rootPackage = new XmRootPackage( this.input, this.getUniqueRootPackageName( rootPackageName ), javaPrefix.toString( ), targetNamespace );
            this.rootPackages.put( rootPackage.getMofName( ), rootPackage );
            this.namespaceToPackage.put( targetNamespace, rootPackage );
        } else {
            throw new MoinIllegalArgumentException( XmGenerationMessages.TARGETNAMESPACENOTURI, targetNamespace );
        }
    }


    private String getUniqueRootPackageName( final String proposedRootPackageName ) {

        if ( proposedRootPackageName == null ) {
            throw new MoinNullPointerException( "proposedRootPackageName" ); //$NON-NLS-1$
        }
        String proposedName = proposedRootPackageName;
        for ( int i = 1; rootPackages.containsKey( proposedName ); i++ ) {
            proposedName = proposedRootPackageName + i;
        }
        return proposedName;
    }

    /**
     * Creates root package from the file URI of the root schema.
     */
    private void createRootPackageFromFileUri( ) {

        String packageName = null;
        if ( input.getSchema( ).eResource( ) != null && input.getSchema( ).eResource( ).getURI( ) != null && input.getSchema( ).eResource( ).getURI( ).lastSegment( ) != null ) {
            final String fileName = input.getSchema( ).eResource( ).getURI( ).lastSegment( );
            final int i = fileName.lastIndexOf( "." ); //$NON-NLS-1$
            if ( i > 0 ) {
                packageName = fileName.substring( 0, i );
            } else {
                packageName = fileName;
            }
        }
        if ( packageName == null || packageName.length( ) == 0 ) {
            packageName = ""; //$NON-NLS-1$
        }
        packageName = XmMofNameBuilder.buildMofPackageName( packageName );
        if ( packageName.length( ) == 0 ) {
            // after the transformation the package name can be empty
            packageName = XmMofNameBuilder.getPackageNameWithGuid( );
        }
        final XmRootPackage rootPackage = new XmRootPackage( this.input, this.getUniqueRootPackageName( packageName ), "", XMLConstants.NULL_NS_URI );//$NON-NLS-1$
        this.rootPackages.put( rootPackage.getMofName( ), rootPackage );
    }

    private static final List<String> DOMAINS = Arrays.asList( new String[] { "COM", "com", "ORG", "org" } ); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$

    /**
     * Returns the important parts of the URI as list. The domain part is
     * reverted. For example, if the URI contains the domain "sap.com", then in
     * the list [com,sap] is returned.
     * 
     * @param namespace namespace uri, can be <code>null</code>
     * @return list of strings cannot be <code>null</code>, the list is empty if
     * the entered namespace is <code>null</code>
     */
    private List<String> getUriAsList( final String namespace ) {

        if ( namespace == null || namespace.length( ) == 0 ) {
            return Collections.emptyList( );
        }
        final URI uri = URI.createURI( namespace );
        final List<String> parsedName = new ArrayList<String>( );
        if ( uri.isHierarchical( ) ) {
            String host = uri.host( );
            if ( host != null && host.startsWith( "www." ) ) { //$NON-NLS-1$
                host = host.substring( 4 );
            }
            if ( host != null ) {
                parsedName.addAll( Arrays.asList( host.split( "\\." ) ) ); //$NON-NLS-1$
                Collections.reverse( parsedName );
            }
            final String path = uri.trimFileExtension( ).path( );
            if ( path != null ) {
                parsedName.addAll( Arrays.asList( path.split( "/" ) ) ); //$NON-NLS-1$
            }
        } else {
            String opaquePart = uri.opaquePart( );
            if ( opaquePart != null && opaquePart.startsWith( "www." ) ) { //$NON-NLS-1$
                opaquePart = opaquePart.substring( 4 );
            }
            if ( opaquePart != null ) {
                final int index = opaquePart.indexOf( ":" ); //$NON-NLS-1$
                if ( index != -1 && "urn".equalsIgnoreCase( uri.scheme( ) ) ) { //$NON-NLS-1$
                    parsedName.addAll( Arrays.asList( opaquePart.substring( 0, index ).split( "-" ) ) ); //$NON-NLS-1$
                    if ( parsedName.size( ) > 0 && DOMAINS.contains( parsedName.get( parsedName.size( ) - 1 ) ) ) {
                        Collections.reverse( parsedName );
                    }
                    for ( final String s : opaquePart.substring( index + 1 ).split( ":" ) ) { //$NON-NLS-1$
                        if ( s.length( ) > 0 ) {
                            parsedName.addAll( Arrays.asList( s.split( "/" ) ) ); //$NON-NLS-1$
                        }
                    }
                } else {
                    parsedName.addAll( Arrays.asList( opaquePart.split( "/" ) ) ); //$NON-NLS-1$
                }
            }
        }
        return parsedName;
    }

    /**
     * Imports the global type definitions and the global element declarations
     * with complex type definitions. It is important that first the MOF classes
     * for the global complex type definitions are build and then the global
     * element declarations are imported.
     */
    private void importGlobalXSDComponents( ) {

        // type definitions
        final EList<XSDTypeDefinition> typeDefList = input.getSchema( ).getTypeDefinitions( );
        for ( final XSDTypeDefinition typeDef : typeDefList ) {
            if ( typeDef instanceof XSDComplexTypeDefinition ) {
                // complex
                importGlobalComplexType( (XSDComplexTypeDefinition) typeDef );
            } else {
                // simple
                importSimpleTypeDefinition( (XSDSimpleTypeDefinition) typeDef );
            }
        }
        // element declarations
        for ( final XSDElementDeclaration elementDeclaration : input.getSchema( ).getElementDeclarations( ) ) {
            importGlobalElement( elementDeclaration );
        }
    }

    /**
     * @param typeDefinition
     * @return MOIN class corresponding to the complex type definition cannot be
     * <code>null</code>
     */
    private XmClass importGlobalComplexType( final XSDComplexTypeDefinition typeDefinition ) {

        XmClass moinClass = xsdComplexTypeToMoinClass.get( typeDefinition );
        // type not imported yet
        if ( moinClass == null ) {
            final XmPackage namespace = getMoinPackageForComponent( typeDefinition );
            final String name = typeDefinition.getName( );
            final boolean isAbstract = typeDefinition.isSetAbstract( ) ? typeDefinition.isAbstract( ) : false;

            // create class
            moinClass = new XmClass( this.input, name, typeDefinition.getTargetNamespace( ), namespace, isAbstract, XmXsdComponentKind.GlobalComplexType, typeDefinition.getContentTypeCategory( ) );
            LOGGER.trace( MoinSeverity.DEBUG, "MOF class {0} created for complex type definition with name {1} and namespace {2}", new Object[] { moinClass.getMofName( ), name, typeDefinition.getTargetNamespace( ) } ); //$NON-NLS-1$
            final XSDTypeDefinition baseTypeDefinition = typeDefinition.getBaseTypeDefinition( );
            setParent( moinClass, baseTypeDefinition );

            // it is important to add the sub type after the super type
            xsdComplexTypeToMoinClass.put( typeDefinition, moinClass );

            // log warning: mixed content ignored
            this.logWarningMixedContentAndAttributeWildcard( typeDefinition );
        }
        return moinClass;
    }

    private void logWarningMixedContentAndAttributeWildcard( final XSDComplexTypeDefinition type ) {

        if ( type.isMixed( ) ) {
            this.protocol.addWarning( XmGenerationMessages.MIXEDIGNORED, type.getAliasURI( ) );
        }
        if ( type.getAttributeWildcard( ) != null ) {
            this.protocol.addWarning( XmGenerationMessages.ATTRIBUTEWILDCARDIGNORED, new Object[] { type.getAttributeWildcard( ), type.getAliasURI( ) } );
        }
    }

    /**
     * Returns null for element declarations with simple type definition,
     * returns the MOIN class corresponding to the complex type definition for
     * element declarations with complex type definition.
     * 
     * @param elementDec
     * @return
     */
    private XmClass importGlobalElement( final XSDElementDeclaration elementDec ) {

        XmClass result;
        if ( elementDec.getTypeDefinition( ) instanceof XSDSimpleTypeDefinition ) {
            // global elements with simple type definitions will be treated in createDocumentRootClassFeature, see below
            result = null;
        } else {
            // with complex type
            XmClass moinClass = this.xsdComplexTypeToMoinClass.get( elementDec.getTypeDefinition( ) );
            if ( moinClass == null ) {
                final XSDComplexTypeDefinition anonymousType = (XSDComplexTypeDefinition) elementDec.getAnonymousTypeDefinition( );
                if ( anonymousType != null ) {
                    final boolean isAbstract = elementDec.isSetAbstract( ) ? elementDec.isAbstract( ) : false;
                    moinClass = new XmClass( this.input, elementDec.getName( ), elementDec.getTargetNamespace( ), getMoinPackageForComponent( elementDec ), isAbstract, XmXsdComponentKind.GlobalElement, anonymousType.getContentTypeCategory( ) );
                    LOGGER.trace( MoinSeverity.DEBUG, "MOF class {0} created for anonymous complex type {1}", new Object[] { moinClass.getMofName( ), anonymousType.getAliasURI( ) } ); //$NON-NLS-1$

                    setParent( moinClass, anonymousType.getBaseTypeDefinition( ) );
                    xsdComplexTypeToMoinClass.put( anonymousType, moinClass );
                    // log warning: mixed content ignored
                    this.logWarningMixedContentAndAttributeWildcard( anonymousType );
                } else {
                    // global element declaration must have an anonymous type otherwise it would be of any type.
                    if ( XSDConstants.isAnyType( elementDec.getTypeDefinition( ) ) ) {
                        // global element declaration with any type
                        this.protocol.addWarning( XmGenerationMessages.ELEMENTWITHTYPE, new Object[] { elementDec.getAliasURI( ), "anyType" } ); //$NON-NLS-1$
                        // calculate MOIN class for any type
                        moinClass = this.importGlobalComplexType( (XSDComplexTypeDefinition) elementDec.getTypeDefinition( ) );
                    } else {
                        // global element declaration with no type --> inconsistent (should never occur)
                        // If the global element has a non-anonymous complex type definition, then this.xsdComplexTypeToMoinClass.get( elementDec.getTypeDefinition( ) ) will deliver a value!
                        LOGGER.trace( MoinSeverity.ERROR, XmGenerationMessages.GLOBALELEMENTWITHICONSISTENTTYPE, new Object[] { elementDec.getAliasURI( ), elementDec.getTypeDefinition( ) } );
                        throw new MoinIllegalStateException( XmGenerationMessages.GLOBALELEMENTWITHICONSISTENTTYPE, new Object[] { elementDec.getAliasURI( ), elementDec.getTypeDefinition( ) } );
                    }
                }
            }

            result = moinClass;
        }
        this.createDocumentRootClassFeature( elementDec );
        return result;

    }

    private XmPrimitiveType importSimpleTypeDefitionOfAttributeDeclaration( final XSDAttributeDeclaration attrDec ) {

        if ( attrDec.getTypeDefinition( ) != null ) {
            final XmPrimitiveType result = importSimpleTypeDefinition( attrDec.getTypeDefinition( ) );
            if ( XSDConstants.isAnySimpleType( attrDec.getTypeDefinition( ) ) ) {
                this.protocol.addWarning( XmGenerationMessages.DATATYPEFORTYPEOFATTRIBUTE, new Object[] { "string", "anyStimpleType", attrDec.getAliasURI( ) } ); //$NON-NLS-1$//$NON-NLS-2$
            }
            return result;
        } else {
            this.protocol.addWarning( XmGenerationMessages.ATTRIBUTEWITHOUTTYPE, new Object[] { attrDec.getAliasURI( ), "string" } ); //$NON-NLS-1$
            // be tolerant return string as type
            return this.xsdSimpleTypesToDataTypes.get( "string" ); //$NON-NLS-1$           
        }
    }

    private boolean isXmlSchemaNamespace( final String targetNamespace ) {

        return input.getSchema( ).getSchemaForSchema( ).getTargetNamespace( ).equals( targetNamespace );
    }

    /**
     * Imports the class contents of the global complex type definition and
     * anonymous complex type definitions of global element declarations.
     */
    private void importClassContents( ) {

        // complex type definitions
        // the new array list is necessary otherwise ConcurrentModificationException can occur, because
        // during the loop additional entries can be added
        for ( final XSDComplexTypeDefinition complexTypeDefinition : new ArrayList<XSDComplexTypeDefinition>( xsdComplexTypeToMoinClass.keySet( ) ) ) {
            importClassContent( xsdComplexTypeToMoinClass.get( complexTypeDefinition ), complexTypeDefinition );
        }
    }

    private void importClassContent( final XmClass moinClass, final XSDComplexTypeDefinition complexType ) {

        // do not import contents if a restriction of other type then anyType
        if ( complexType.getDerivationMethod( ) != XSDDerivationMethod.RESTRICTION_LITERAL || XSDConstants.isAnyType( complexType.getBaseTypeDefinition( ) ) ) {

            final XSDComplexTypeContent complexTypeContent = complexType.getContent( );

            if ( complexTypeContent instanceof XSDParticle ) {
                /* import particle */
                final XSDParticle particle = (XSDParticle) complexTypeContent;
                importParticle( particle, moinClass, particle.getMinOccurs( ), particle.getMaxOccurs( ) );
            } else if ( complexTypeContent instanceof XSDSimpleTypeDefinition ) {
                /* import simple content */
                final XmPrimitiveType dataType = importSimpleTypeDefinition( (XSDSimpleTypeDefinition) complexTypeContent );
                new XmAttribute( this.input, "value", moinClass, 0, 1, dataType, true, XmXsdComponentKind.SimpleContent ); //$NON-NLS-1$
                LOGGER.trace( MoinSeverity.DEBUG, "Attribute \"value\" added to class {0} for complex type {1} with simple content", new Object[] { moinClass.getMofName( ), complexType.getAliasURI( ) } ); //$NON-NLS-1$
            }

            /* import attributes */
            final List<XSDAttributeGroupDefinition> attrGroups = PSUtil.getAttributeGroups( complexType );
            for ( final XSDAttributeUse attributeUse : complexType.getAttributeUses( ) ) {
                if ( attributeUse.eContainer( ) == complexType || attrGroups.contains( attributeUse.eContainer( ) ) ) {
                    // attribute is not defined in a parent type
                    importLocalAttributeDeclaration( attributeUse, moinClass );
                }
            }
        } else {
            // restriction of a non-urtype
            this.protocol.addWarning( XmGenerationMessages.RESTRICTIONSOFCOMPLEXTYPEIGNORED, complexType.getAliasURI( ) );
        }
    }

    /**
     * @param particle
     * @param moinClass
     * @param lower the summed up lower boundary of the multiplicity
     * @param upper the summed up upper boundary of the multiplicity
     */
    private void importParticle( final XSDParticle particle, final XmClass moinClass, final int lower, final int upper ) {

        final XSDParticleContent particleContent = particle.getContent( );
        if ( particleContent instanceof XSDModelGroup ) {
            // modelGroup
            final XSDModelGroup modelGroup = (XSDModelGroup) particleContent;
            importModelGroup( modelGroup, lower, upper, moinClass );
            if ( particle.getMinOccurs( ) != 1 || particle.getMaxOccurs( ) != 1 ) {
                // repeating model group!
                this.protocol.addWarning( XmGenerationMessages.REPEATINGMODELGROUP, new Object[] { modelGroup.getCompositor( ).getLiteral( ), particle.getMinOccurs( ) + ".." + ( particle.getMaxOccurs( ) == XSDParticle.UNBOUNDED ? "unbounded" : particle.getMaxOccurs( ) ) } ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        } else if ( particleContent instanceof XSDModelGroupDefinition ) {
            // modelGroupDefinition
            final XSDModelGroupDefinition modelGroupDef = ( (XSDModelGroupDefinition) particleContent ).getResolvedModelGroupDefinition( );
            importModelGroup( modelGroupDef.getModelGroup( ), lower, upper, moinClass );
            if ( particle.getMinOccurs( ) != 1 || particle.getMaxOccurs( ) != 1 ) {
                // repeating model group!
                this.protocol.addWarning( XmGenerationMessages.REFERENCETOREPEATINGMODELGROUPDEF, new Object[] { modelGroupDef.getAliasURI( ), particle.getMinOccurs( ) + ".." + ( particle.getMaxOccurs( ) == XSDParticle.UNBOUNDED ? "unbounded" : particle.getMaxOccurs( ) ) } ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        } else if ( particleContent instanceof XSDElementDeclaration ) {
            // elementDeclaration
            importElementDec( (XSDElementDeclaration) particleContent, lower, upper, moinClass );
        } else if ( particleContent instanceof XSDWildcard ) {
            //  wildcard
            this.protocol.addWarning( XmGenerationMessages.WILDCARDIGNORED, particleContent );
        } else {
            if ( particleContent != null ) {
                throw new MoinIllegalStateException( XmGenerationMessages.UNEXPECTEDPARTICLECONTENTTYPE, particleContent.getClass( ) );
            }
        }
    }


    private void importModelGroup( final XSDModelGroup modelGroup, final int lower, final int upper, final XmClass moinClass ) {

        for ( final XSDParticle childParticle : modelGroup.getParticles( ) ) {

            int upperNew = upper;
            int lowerNew = lower;

            switch ( modelGroup.getCompositor( ).getValue( ) ) {
                case XSDCompositor.SEQUENCE:
                    int upperChild = childParticle.getMaxOccurs( );
                    if ( upperChild < 0 || upperNew < 0 ) {
                        upperNew = -1;
                    } else {
                        upperNew = upperNew * upperChild;
                    }
                    lowerNew = lowerNew * childParticle.getMinOccurs( );
                    break;
                case XSDCompositor.CHOICE:
                    upperChild = childParticle.getMaxOccurs( );
                    if ( upperChild < 0 || upperNew < 0 ) {
                        upperNew = -1;
                    } else {
                        upperNew = upperNew * upperChild;
                    }
                    lowerNew = 0;
                    break;
                case XSDCompositor.ALL:
                    upperNew = 1;
                    lowerNew = childParticle.getMinOccurs( );
                    break;
            }
            importParticle( childParticle, moinClass, lowerNew, upperNew );
        }
    }

    private void importElementDec( final XSDElementDeclaration elementDec, final int lower, final int upper, final XmClass moinClass ) {

        final String elementName = elementDec.getResolvedElementDeclaration( ).getName( );

        final XSDTypeDefinition typeDef = elementDec.getResolvedElementDeclaration( ).getTypeDefinition( );

        XmXsdComponentKind kind;
        if ( elementDec.isElementDeclarationReference( ) ) {
            // reference to global element
            kind = XmXsdComponentKind.GlobalElement;
        } else {
            kind = XmXsdComponentKind.LocalElement;
        }

        if ( typeDef instanceof XSDSimpleTypeDefinition ) {
            // SimpleTypeDefinition -> MOIN Attribute
            boolean changeable = true;
            final XSDConstraint constraint = elementDec.getConstraint( );
            if ( constraint != null && constraint == XSDConstraint.FIXED_LITERAL ) {
                changeable = false;
            }
            final XmPrimitiveType dataType = importSimpleTypeDefinition( (XSDSimpleTypeDefinition) typeDef );
            if ( XSDConstants.isAnySimpleType( typeDef ) ) {
                this.protocol.addWarning( XmGenerationMessages.DATATYPEFORTYPEOFELEMENT, new Object[] { "string", "anyStimpleType", elementDec.getAliasURI( ) } ); //$NON-NLS-1$//$NON-NLS-2$
            }
            final XmAttribute attribute = new XmAttribute( this.input, elementName, moinClass, lower, upper, dataType, changeable, kind );
            LOGGER.trace( MoinSeverity.DEBUG, "Attribute {0} added to class {1} for element declaration {2} with simple type definition", new Object[] { attribute.getMofName( ), moinClass.getMofName( ), elementDec.getResolvedElementDeclaration( ).getAliasURI( ) } ); //$NON-NLS-1$
            xsdFeatureToModelElement.put( elementDec, attribute );
        } else {
            // complex type definition
            if ( elementDec.isElementDeclarationReference( ) ) {
                // reference to global element
                final XmClass referencedClass = this.importGlobalElement( elementDec.getResolvedElementDeclaration( ) );
                final XmReference reference = new XmReference( this.input, elementName, moinClass, lower, upper, referencedClass, kind );
                LOGGER.trace( MoinSeverity.DEBUG, "Reference {0} added to class {1} for element declaration reference {2}", new Object[] { reference.getMofName( ), moinClass.getMofName( ), elementDec.getResolvedElementDeclaration( ).getAliasURI( ) } ); //$NON-NLS-1$
                xsdFeatureToModelElement.put( elementDec, reference );
            } else {
                // local element
                XmClass referencedClass;
                if ( elementDec.getAnonymousTypeDefinition( ) != null ) {
                    // anonymous type --> create own class for local element 
                    final boolean isAbstract = false; //a local element or its anonymous type cannot be abstract
                    final XSDComplexTypeDefinition ct = (XSDComplexTypeDefinition) elementDec.getAnonymousTypeDefinition( );
                    referencedClass = new XmClass( this.input, elementName, null, moinClass.getPackage( ), isAbstract, kind, ct.getContentTypeCategory( ) );
                    LOGGER.trace( MoinSeverity.DEBUG, "MOF class {0} created for anonymous complex type definition of local element declaration {1}", new Object[] { referencedClass.getMofName( ), elementDec.getAliasURI( ) } ); //$NON-NLS-1$
                    this.xsdComplexTypeToMoinClass.put( ct, referencedClass );
                    this.logWarningMixedContentAndAttributeWildcard( ct );
                } else {
                    // global type -->MOIN class of global complex type
                    if ( XSDConstants.isAnyType( typeDef ) ) {
                        // element declaration with any type --> log warning
                        this.protocol.addWarning( XmGenerationMessages.ELEMENTWITHTYPE, new Object[] { elementDec.getAliasURI( ), "anyType" } ); //$NON-NLS-1$
                    }
                    referencedClass = this.importGlobalComplexType( (XSDComplexTypeDefinition) typeDef );
                }
                handleComplexTypeOfElementDec( elementDec, referencedClass, true );

                final XmReference reference = new XmReference( this.input, elementName, moinClass, lower, upper, referencedClass, kind );
                LOGGER.trace( MoinSeverity.DEBUG, "Reference {0} added to class {1} for local element declaration {2}", new Object[] { reference.getMofName( ), moinClass.getMofName( ), elementDec.getAliasURI( ) } ); //$NON-NLS-1$
                xsdFeatureToModelElement.put( elementDec, reference );
            }
        }
    }

    /**
     * Element Declaration must have complex type.
     * 
     * @param elementDeclaration
     * @param moinClassForType
     */
    private void handleComplexTypeOfElementDec( final XSDElementDeclaration elementDec, final XmClass moinClassForType, final boolean doImportClassContent ) {

        final XSDTypeDefinition anonymousTypeDef = elementDec.getResolvedElementDeclaration( ).getAnonymousTypeDefinition( );

        if ( anonymousTypeDef != null ) {
            // anonymusTypeDefinition
            final XSDComplexTypeDefinition complexTypeDef = (XSDComplexTypeDefinition) anonymousTypeDef;
            if ( complexTypeDef.getDerivationMethod( ) != XSDDerivationMethod.RESTRICTION_LITERAL || XSDConstants.isAnyType( complexTypeDef.getBaseTypeDefinition( ) ) ) {
                // anonymous type definition is an extension
                if ( doImportClassContent ) {
                    importClassContent( moinClassForType, (XSDComplexTypeDefinition) anonymousTypeDef );
                }
                setParent( moinClassForType, anonymousTypeDef.getBaseType( ) );
            } else {
                setParent( moinClassForType, anonymousTypeDef.getBaseType( ) );
            }
        }
    }


    private XmAttribute importLocalAttributeDeclaration( final XSDAttributeUse attributeUse, final XmClass moinClass ) {

        final XSDAttributeDeclaration attrDec = attributeUse.getAttributeDeclaration( ).getResolvedAttributeDeclaration( );

        final XmPrimitiveType dataType = this.importSimpleTypeDefitionOfAttributeDeclaration( attrDec );

        int lower = 0;
        if ( attributeUse.isRequired( ) ) {
            lower = 1;
        }

        final boolean changeable;
        if ( attributeUse.isSetConstraint( ) && attributeUse.getConstraint( ) == XSDConstraint.FIXED_LITERAL ) {
            changeable = false;
        } else {
            changeable = true;
        }

        final XmAttribute attribute = new XmAttribute( this.input, attrDec.getName( ), moinClass, lower, 1, dataType, changeable, XmXsdComponentKind.LocalAttribute );
        LOGGER.trace( MoinSeverity.DEBUG, "Attribute {0} added to class {1} for attribute declaration {2}", new Object[] { attribute.getMofName( ), moinClass.getMofName( ), attrDec.getAliasURI( ) } ); //$NON-NLS-1$
        xsdFeatureToModelElement.put( attrDec, attribute );
        return attribute;
    }

    private void createMofElements( ) {

        LOGGER.trace( MoinSeverity.DEBUG, "Creating MOF elements started" ); //$NON-NLS-1$
        for ( final XmRootPackage rootPackage : rootPackages.values( ) ) {
            rootPackage.createModelElement( );
        }
        LOGGER.trace( MoinSeverity.DEBUG, "Creating MOF elements finished" ); //$NON-NLS-1$
    }


    private void setParent( final XmClass moinClass, final XSDTypeDefinition baseTypeDefinition ) {

        if ( !XSDConstants.isAnyType( baseTypeDefinition ) ) {
            // basetype != anyType
            if ( baseTypeDefinition instanceof XSDComplexTypeDefinition ) {

                XmClass superClass = xsdComplexTypeToMoinClass.get( baseTypeDefinition );
                if ( superClass == null ) {
                    superClass = importGlobalComplexType( (XSDComplexTypeDefinition) baseTypeDefinition );
                }
                if ( moinClass != superClass ) {
                    moinClass.addSuperClass( superClass );
                }
            }
        }
    }


    private XmPrimitiveType importSimpleTypeDefinition( final XSDSimpleTypeDefinition typeDefinition ) {

        if ( typeDefinition == null ) {
            throw new MoinNullPointerException( "typeDefinition" ); //$NON-NLS-1$
        }

        XmPrimitiveType result = xsdSimpleTypeDefToMoinPrimitiveType.get( typeDefinition );

        if ( result == null ) {
            if ( this.isXmlSchemaNamespace( typeDefinition.getTargetNamespace( ) ) ) {
                // build-in type simple type
                result = getMoinPrimitiveTypeForXsdBuildInType( typeDefinition );
            } else {
                // self-defined simple type
                if ( typeDefinition.getVariety( ) == XSDVariety.LIST_LITERAL ) {
                    //List
                    // return string primitive type, do not care about multiplicity, because importer can also not treat this case
                    this.protocol.addWarning( XmGenerationMessages.CREATINGDATATYPEFORSIMPLETYPE, new Object[] { "string", typeDefinition.getAliasURI( ), "list" } ); //$NON-NLS-1$ //$NON-NLS-2$
                    result = this.xsdSimpleTypesToDataTypes.get( "string" ); //$NON-NLS-1$
                } else if ( typeDefinition.getVariety( ) == XSDVariety.UNION_LITERAL ) {
                    //Union
                    this.protocol.addWarning( XmGenerationMessages.CREATINGDATATYPEFORSIMPLETYPE, new Object[] { "string", typeDefinition.getAliasURI( ), "union" } ); //$NON-NLS-1$ //$NON-NLS-2$
                    // return "string" primitive type
                    result = this.xsdSimpleTypesToDataTypes.get( "string" ); //$NON-NLS-1$
                } else if ( typeDefinition.getVariety( ) == XSDVariety.ATOMIC_LITERAL ) {
                    //Atomic (Restriction)
                    XSDSimpleTypeDefinition baseTypeDefinition = typeDefinition.getBaseTypeDefinition( );
                    if ( baseTypeDefinition.isCircular( ) ) {
                        // be tolerant: return "string" primitive type, circular is not allowed in a valid XML schema
                        result = this.xsdSimpleTypesToDataTypes.get( "string" ); //$NON-NLS-1$
                    } else {
                        // find base type definition which is a build-in type
                        for ( ; baseTypeDefinition != null && !this.isXmlSchemaNamespace( baseTypeDefinition.getTargetNamespace( ) ); ) {
                            baseTypeDefinition = baseTypeDefinition.getBaseTypeDefinition( );
                        }
                        if ( baseTypeDefinition == null ) {
                            // be tolerant: "string" primitive type
                            this.protocol.addWarning( XmGenerationMessages.NOBUILDINTYPEFORSIMPLETYPE, new Object[] { typeDefinition.getAliasURI( ), "string" } ); //$NON-NLS-1$
                            result = this.xsdSimpleTypesToDataTypes.get( "string" ); //$NON-NLS-1$
                        } else {
                            // build-in type
                            result = getMoinPrimitiveTypeForXsdBuildInType( baseTypeDefinition );
                        }
                    }
                }
            }
            xsdSimpleTypeDefToMoinPrimitiveType.put( typeDefinition, result );
        }
        return result;
    }

    private XmPackage getMoinPackageForComponent( final XSDConcreteComponent component ) {

        return this.getMoinPackageForSchema( component.getSchema( ) );
    }


    private XmPackage getMoinPackageForSchema( final XSDSchema schema ) {

        XmPackage result;
        final String targetNamespace = schema.getTargetNamespace( );
        if ( targetNamespace == null || targetNamespace.length( ) == 0 ) {
            // no-namespace --> return first root package
            result = this.rootPackages.values( ).iterator( ).next( );
        } else {
            result = namespaceToPackage.get( targetNamespace );
        }

        if ( result == null ) {
            if ( this.isXmlSchemaNamespace( targetNamespace ) ) {
                // can occur if an element declaration has as type definition the ur-type (anyType)
                // --> create new package with name "xsd" for the XML schema namespace as sub package of the first package
                result = new XmPackage( this.input, "xsd", this.rootPackages.values( ).iterator( ).next( ) ); //$NON-NLS-1$
                namespaceToPackage.put( targetNamespace, result );
            } else {
                throw new MoinIllegalStateException( XmGenerationMessages.NOMOINPACKAGEFORNAMESPACE, targetNamespace );
            }
        }
        return result;
    }
}
