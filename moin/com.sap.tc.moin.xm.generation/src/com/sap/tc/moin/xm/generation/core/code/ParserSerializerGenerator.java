package com.sap.tc.moin.xm.generation.core.code;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDAttributeUse;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFeature;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.XmGenerationMessages;
import com.sap.tc.moin.xm.generation.core.XmGenerationProtocolImpl;
import com.sap.tc.moin.xm.generation.core.code.parser.XmParserGenerator;
import com.sap.tc.moin.xm.generation.core.code.parser.impl.XmHandlerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.code.parser.impl.XmParserHandlerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.XmSerializerGenerator;
import com.sap.tc.moin.xm.generation.core.code.serializer.impl.ComplexTypeMethodImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.impl.ElementMethodNameAndParameterTypeImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.impl.QualifiedNameImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.impl.SubstitutionGroupMethodImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.impl.XmSerializerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.util.HandlerAndComplexTypeMethodData;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;
import com.sap.tc.moin.xm.generation.core.code.util.PrefixAndNamespace;
import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.code.util.XsdKind;
import com.sap.tc.moin.xm.generation.core.metamodel.XmMetaModelGenerator;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmClass;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmReference;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmStructuralFeature;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmXsdComponentKind;

/**
 * Generates the parser and serializer java classes. The main principle is that
 * for each MOIN class an inner class representing a handler is generated in the
 * parser class and that for each MOIN class a method is generated in the
 * serializer class.
 */
public final class ParserSerializerGenerator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, ParserSerializerGenerator.class );

    private final XmGeneratorInput input;

    private final XmGenerationProtocolImpl protocol;

    private final XmParserHandlerTemplateImpl parserTemplate;

    private final XmSerializerTemplateImpl serializerTemplate;

    private final Map<XSDFeature, XmStructuralFeature> xsdFeatureToMoinStructualFeature;

    private final Map<XSDComplexTypeDefinition, XmClass> xsdComplexTypeToMoinClass;

    private final XmClass documentRootClass;

    private final Map<XSDElementDeclaration, XmStructuralFeature> globalElementDecToDocumentRootFeature;

    private String parserCode;

    private String serializerCode;

    /**
     * Constructor.
     * 
     * @param metaModelGenerator
     * @param aInput
     * @param aProtocol
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public ParserSerializerGenerator( final XmMetaModelGenerator metaModelGenerator, final XmGeneratorInput aInput, final XmGenerationProtocolImpl aProtocol ) {

        if ( metaModelGenerator == null ) {
            throw new MoinNullPointerException( "metaModelGenerator" ); //$NON-NLS-1$
        }
        if ( aInput == null ) {
            throw new MoinNullPointerException( "input" ); //$NON-NLS-1$
        }
        if ( aProtocol == null ) {
            throw new MoinNullPointerException( "aProtocol" ); //$NON-NLS-1$
        }
        this.input = aInput;
        this.documentRootClass = metaModelGenerator.getDocumentRootClass( );
        this.globalElementDecToDocumentRootFeature = metaModelGenerator.getGlobalElementToDocumentRootFeatureMap( );
        this.xsdFeatureToMoinStructualFeature = metaModelGenerator.getXsdFeatureToModelElementMap( );
        this.xsdComplexTypeToMoinClass = metaModelGenerator.getXsdComplexTypeDefToXmClass( );
        this.protocol = aProtocol;

        final String qualifiedRootDocumentJmiClassName = XmParserSerializerTemplateImpl.getQualifiedJmiClassName( this.documentRootClass.getNamespace( ), this.documentRootClass.getMofName( ) );
        this.parserTemplate = new XmParserHandlerTemplateImpl( input.getParserClassName( ), input.getParserPackageName( ), getSchemaName( input.getSchema( ) ), qualifiedRootDocumentJmiClassName );
        this.serializerTemplate = new XmSerializerTemplateImpl( input.getSerializerClassName( ), input.getSerializerPackageName( ), getSchemaName( input.getSchema( ) ) );
        int i = 1;
        for ( final String targetNamespace : metaModelGenerator.getNamespaces( ) ) {
            if ( XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001.equals( targetNamespace ) ) {
                this.parserTemplate.addPrefix( "xsd", targetNamespace ); //$NON-NLS-1$
            } else if ( XSDConstants.SCHEMA_FOR_SCHEMA_URI_2000_10.equals( targetNamespace ) ) {
                this.parserTemplate.addPrefix( "xs1", targetNamespace ); //$NON-NLS-1$
            } else if ( XSDConstants.SCHEMA_FOR_SCHEMA_URI_1999.equals( targetNamespace ) ) {
                this.parserTemplate.addPrefix( "xs", targetNamespace ); //$NON-NLS-1$
            } else {
                this.parserTemplate.addPrefix( "ns" + i, targetNamespace ); //$NON-NLS-1$
                i++;
            }
        }
        for ( final PrefixAndNamespace prefixAndNs : this.parserTemplate.getPrefixes( ) ) {
            this.serializerTemplate.addPrefix( prefixAndNs.getPrefix( ), prefixAndNs.getNamespace( ) );
        }
    }


    private String getSchemaName( XSDSchema schema ) {

        if ( schema.getSchemaLocation( ) != null ) {
            return schema.getSchemaLocation( );
        } else if ( schema.getTargetNamespace( ) != null ) {
            return schema.getTargetNamespace( );
        } else {
            return "no-namespace"; //$NON-NLS-1$
        }
    }


    /**
     * Generates the parser and serializer class.
     */
    public void execute( ) {

        LOGGER.trace( MoinSeverity.INFO, "Generation of XM Parser class {0} and Serializer class {1} started", new Object[] { this.input.getParserClassName( ), this.input.getSerializerClassName( ) } ); //$NON-NLS-1$
        LOGGER.trace( MoinSeverity.DEBUG, "Prefix to namespace {0}", this.parserTemplate.getPrefixes( ) ); //$NON-NLS-1$
        this.generateTemplates( );
        // code generation
        if ( input.generateParser( ) ) {
            parserCode = new XmParserGenerator( ).createCode( this.parserTemplate );
        } else {
            parserCode = null;
        }
        if ( input.generateSerializer( ) ) {
            serializerCode = new XmSerializerGenerator( ).createCode( this.serializerTemplate );
        } else {
            serializerCode = null;
        }
        LOGGER.trace( MoinSeverity.INFO, "Generation of XM Parser class {0} and Serializer class {1} finished", new Object[] { this.input.getParserClassName( ), this.input.getSerializerClassName( ) } ); //$NON-NLS-1$
    }

    /**
     * Returns the parser code.
     * 
     * @return parser code, or <code>null</code> if the generation of the parser
     * code was not requested or the method {@link #execute()} has not been
     * called before
     */
    public String getParserCode( ) {

        return this.parserCode;
    }

    /**
     * Returns the serializer code.
     * 
     * @return serializer code, or <code>null</code> if the generation of the
     * parser code was not requested or the method {@link #execute()} has not
     * been called before
     */
    public String getSerializerCode( ) {

        return this.serializerCode;
    }

    private void generateTemplates( ) {

        final HandlerAndComplexTypeMethodData documentRootComplexTypeData = PSUtil.getHandlerAndComplexTypeMethodData( this.documentRootClass, this.parserTemplate.getPrefix( this.documentRootClass.getXsdNamespace( ) ) );
        final ComplexTypeMethodImpl documentRootComplexTypeMethod = new ComplexTypeMethodImpl( documentRootComplexTypeData );
        this.serializerTemplate.addComplexTypeMethod( documentRootComplexTypeMethod );
        this.serializerTemplate.setRootMethod( documentRootComplexTypeMethod.getMethodName( ) );

        // Treat document root: A global element declaration is either mapped to a reference or attribute.
        // And the complex types of the global elements are treated in method "treatComplexTypeDef"
        for ( final XSDElementDeclaration globalElDec : this.globalElementDecToDocumentRootFeature.keySet( ) ) {

            final QualifiedName qName = this.getQName( globalElDec );
            this.parserTemplate.addElementLocalName( qName.getLocalPart( ) );
            final XmStructuralFeature feature = this.globalElementDecToDocumentRootFeature.get( globalElDec );
            final XmClass moinClass = this.xsdComplexTypeToMoinClass.get( globalElDec.getTypeDefinition( ) );

            /// serializer
            this.serializerTemplate.addElementQName( qName );

            if ( moinClass != null ) {
                // global element with complex type
                final HandlerAndComplexTypeMethodData handlerAndMethodData = PSUtil.getHandlerAndComplexTypeMethodData( moinClass, this.parserTemplate.getPrefix( moinClass.getXsdNamespace( ) ) );
                this.parserTemplate.addRootHandler( qName.getPrefix( ), qName.getLocalPart( ), handlerAndMethodData.getHandlerClassName( ) );
                final XmReference ref = (XmReference) feature;
                this.parserTemplate.addChildAssociation( qName, ref.getAssociation( ) );

                // serializer
                final HandlerAndComplexTypeMethodData referencedMethodData = PSUtil.getHandlerAndComplexTypeMethodData( ref.getReferencedClass( ), this.parserTemplate.getPrefix( ref.getReferencedClass( ).getXsdNamespace( ) ) );
                documentRootComplexTypeMethod.addComplexXmlElement( qName, ref.getAssociation( ), referencedMethodData.getMethodName( ) );

                // treat complex type of global element declaration
                treatComplexTypeDef( (XSDComplexTypeDefinition) globalElDec.getTypeDefinition( ), handlerAndMethodData );

            } else {
                // global element with simple type
                this.parserTemplate.addXmlSimpleRootElement( qName.getLocalPart( ), qName.getPrefix( ), feature.getMofName( ) );
                documentRootComplexTypeMethod.addSimpleXmlElement( qName, documentRootComplexTypeMethod.getQualifiedClassNameOfParameter( ), feature.getMofName( ) );
            }
        }
    }

    private void treatComplexTypeDef( final XSDComplexTypeDefinition complexType, final HandlerAndComplexTypeMethodData handlerAndMethodData ) {

        // do not import contents if restriction of other type then anyType
        if ( complexType.getDerivationMethod( ) != XSDDerivationMethod.RESTRICTION_LITERAL || XSDConstants.isAnyType( complexType.getBaseTypeDefinition( ) ) ) {

            final XmHandlerTemplateImpl handler = new XmHandlerTemplateImpl( handlerAndMethodData );
            this.parserTemplate.addHandler( handler.getClassName( ), handler );

            final ComplexTypeMethodImpl complexTypeMethod = new ComplexTypeMethodImpl( handlerAndMethodData );
            this.serializerTemplate.addComplexTypeMethod( complexTypeMethod );

            /* import attributes */
            final EList<XSDAttributeUse> attributeUseList = complexType.getAttributeUses( );
            for ( final XSDAttributeUse attributeUse : attributeUseList ) {
                // remark: attributes of the super types are not reused
                final XSDAttributeDeclaration attrDec = attributeUse.getAttributeDeclaration( );
                final QualifiedName attrQName = this.getQName( attrDec );
                handler.addXmlAttribute( attrQName, xsdFeatureToMoinStructualFeature.get( attrDec ).getMofName( ) );
                complexTypeMethod.addXmlAttribute( attrQName, XmParserSerializerTemplateImpl.getQualifiedJmiClassName( handlerAndMethodData.getMoinClass( ).getNamespace( ), handlerAndMethodData.getMoinClass( ).getMofName( ) ), xsdFeatureToMoinStructualFeature.get( attrDec ).getMofName( ) );
                this.parserTemplate.addAttributeLocalName( attrQName.getLocalPart( ) );
                this.serializerTemplate.addAttributeQName( attrQName );
            }

            // import particle 
            if ( complexType.getComplexType( ) != null ) {
                assignParticleToXMLElement( handler, complexTypeMethod, complexType.getComplexType( ) );
            }

        } else {
            //restriction of other type then anyType --> treat base type
            // restriction of a complex type definition must always be a complex type definition --> therefore cast is possible
            this.treatComplexTypeDef( (XSDComplexTypeDefinition) complexType.getBaseType( ), handlerAndMethodData );
        }
    }


    private QualifiedName getQName( final XSDAttributeDeclaration attrDec ) {

        // Remark to the difference to getQName( final XSDElementDeclaration elementDec ):
        // We know that the provided attribute declaration is either local or an attribute reference. 
        // There we do not need the check whether the provided attribute declaration is global.

        // qualify?
        boolean qualifyAttribute = false;
        final XSDSchema schema = attrDec.getSchema( );
        if ( schema != null && schema.isSetAttributeFormDefault( ) && schema.getAttributeFormDefault( ) == XSDForm.QUALIFIED_LITERAL ) {
            qualifyAttribute = true;
        }
        if ( attrDec.isSetForm( ) ) {
            qualifyAttribute = attrDec.getForm( ) == XSDForm.QUALIFIED_LITERAL;
        }

        final String name = attrDec.getResolvedAttributeDeclaration( ).getName( );
        final QualifiedNameImpl result;
        if ( attrDec.isAttributeDeclarationReference( ) ) {
            final String ns = attrDec.getResolvedAttributeDeclaration( ).getTargetNamespace( );
            result = new QualifiedNameImpl( name, ns, this.parserTemplate.getPrefix( ns ) );
        } else {
            final String ns = qualifyAttribute ? attrDec.getResolvedAttributeDeclaration( ).getTargetNamespace( ) : ""; //$NON-NLS-1$
            final String prefix = qualifyAttribute ? this.parserTemplate.getPrefix( ns ) : ""; //$NON-NLS-1$
            result = new QualifiedNameImpl( name, ns, prefix );
        }
        return result;
    }

    private QualifiedName getQName( final XSDElementDeclaration elementDec ) {

        // qualify?
        boolean qualifyElement;
        if ( elementDec.isGlobal( ) ) {
            qualifyElement = true;
        } else {
            qualifyElement = false;
            final XSDSchema schema = elementDec.getSchema( );
            if ( schema != null && schema.isSetElementFormDefault( ) && schema.getElementFormDefault( ) == XSDForm.QUALIFIED_LITERAL ) {
                qualifyElement = true;
            }
            if ( elementDec.isSetForm( ) ) {
                qualifyElement = elementDec.getForm( ) == XSDForm.QUALIFIED_LITERAL;
            }
        }

        final String name = elementDec.getResolvedElementDeclaration( ).getName( );
        final QualifiedNameImpl result;
        if ( elementDec.isElementDeclarationReference( ) ) {
            final String ns = elementDec.getResolvedElementDeclaration( ).getTargetNamespace( );
            result = new QualifiedNameImpl( name, ns, this.parserTemplate.getPrefix( ns ) );
        } else {
            final String ns = qualifyElement ? elementDec.getResolvedElementDeclaration( ).getTargetNamespace( ) : ""; //$NON-NLS-1$
            final String prefix = qualifyElement ? this.parserTemplate.getPrefix( ns ) : ""; //$NON-NLS-1$
            result = new QualifiedNameImpl( name, ns, prefix );
        }
        return result;
    }

    private void assignParticleToXMLElement( final XmHandlerTemplateImpl parentHandler, final ComplexTypeMethodImpl parentMethod, final XSDParticle particle ) {

        final XSDParticleContent particleContent = particle.getContent( );
        if ( particleContent instanceof XSDModelGroup ) {
            // modelGroup
            for ( final XSDParticle childParticle : ( (XSDModelGroup) particleContent ).getParticles( ) ) {
                assignParticleToXMLElement( parentHandler, parentMethod, childParticle );
            }
        } else if ( particleContent instanceof XSDModelGroupDefinition ) {
            // modelGroupDefinition
            final XSDModelGroup modelGroup = ( (XSDModelGroupDefinition) particleContent ).getResolvedModelGroupDefinition( ).getModelGroup( );
            for ( final XSDParticle childParticle : modelGroup.getParticles( ) ) {
                assignParticleToXMLElement( parentHandler, parentMethod, childParticle );
            }
        } else if ( particleContent instanceof XSDElementDeclaration ) {
            // elementDeclaration
            treatLocalElementOrElementReference( (XSDElementDeclaration) particleContent, parentHandler, parentMethod );
        } else {
            // wildcard
            // do nothing
        }

    }

    private void treatLocalElementOrElementReference( final XSDElementDeclaration elementDec, final XmHandlerTemplateImpl parentHandler, final ComplexTypeMethodImpl parentMethod ) {

        if ( elementDec.isElementDeclarationReference( ) ) {
            // reference to global element
            treatElementReference( elementDec, parentHandler, parentMethod );
        } else {
            // local element
            treatLocalElement( elementDec, parentHandler, parentMethod );
        }
    }

    private void treatElementReference( final XSDElementDeclaration elementDec, final XmHandlerTemplateImpl parentHandler, final ComplexTypeMethodImpl parentMethod ) {


        if ( elementDec.getResolvedElementDeclaration( ).getSubstitutionGroup( ).size( ) == 1 ) {
            // not a substitution group head
            if ( !elementDec.getResolvedElementDeclaration( ).isSetAbstract( ) ) {
                // not abstract
                if ( elementDec.getResolvedElementDeclaration( ).getTypeDefinition( ) instanceof XSDComplexTypeDefinition ) {
                    // complex type
                    treatElementRefToNonAbstractElWithComplexType( elementDec, parentHandler, parentMethod, (XSDComplexTypeDefinition) elementDec.getResolvedElementDeclaration( ).getTypeDefinition( ) );
                } else {
                    // simple type
                    final QualifiedName qName = this.getQName( elementDec );
                    // parser
                    parentHandler.addSimpleXmlElement( qName, xsdFeatureToMoinStructualFeature.get( elementDec ).getMofName( ) );
                    // serializer
                    parentMethod.addSimpleXmlElement( qName, parentMethod.getQualifiedClassNameOfParameter( ), xsdFeatureToMoinStructualFeature.get( elementDec ).getMofName( ) );
                    this.parserTemplate.addElementLocalName( qName.getLocalPart( ) );
                    this.serializerTemplate.addElementQName( qName );
                }
            }
        } else {
            // substitutionGroup
            if ( xsdFeatureToMoinStructualFeature.get( elementDec ) instanceof XmReference ) {
                // substitution group with complex type
                treatSubstitutionGroupWithComplexType( elementDec, parentHandler, parentMethod );
            } else {
                // substitution group with simple type ignored
                this.protocol.addWarning( XmGenerationMessages.SIMPLETYPESUBSTITUTIONGROUPIGNORED, elementDec.getResolvedElementDeclaration( ).getAliasURI( ) );
                //final XmAttribute xmAttributeOfSubstitutionGroupHead = (XmAttribute) xsdFeatureToMoinStructualFeature.get( elementDec );
            }
        }
    }

    private void treatSubstitutionGroupWithComplexType( final XSDElementDeclaration elementRefToSubstitutionGroupHead, final XmHandlerTemplateImpl parentHandler, final ComplexTypeMethodImpl parentMethod ) {

        final QualifiedName substitutionHeadQName = this.getQName( elementRefToSubstitutionGroupHead );
        final EList<XSDElementDeclaration> substitutiveElementDecs = elementRefToSubstitutionGroupHead.getResolvedElementDeclaration( ).getSubstitutionGroup( );
        final XmReference xmRefForSubstituionHead = (XmReference) xsdFeatureToMoinStructualFeature.get( elementRefToSubstitutionGroupHead );
        // serializer
        final String methodNameOfReferencedSubstitutionHead = PSUtil.getMethodOrClassName( substitutionHeadQName.getLocalPart( ), substitutionHeadQName.getPrefix( ), XmXsdComponentKind.SubstitutionGroupHead, true );
        parentMethod.addSubstitutionGroupHead( substitutionHeadQName, xmRefForSubstituionHead.getAssociation( ), methodNameOfReferencedSubstitutionHead );

        SubstitutionGroupMethodImpl methodOfSubstitutionHead = this.serializerTemplate.getSubstitutionGroupMethodMap( ).get( methodNameOfReferencedSubstitutionHead );
        final boolean subsitituionGroupMethodAlreadyBuilt;
        if ( methodOfSubstitutionHead == null ) {
            methodOfSubstitutionHead = new SubstitutionGroupMethodImpl( methodNameOfReferencedSubstitutionHead, substitutionHeadQName );
            this.serializerTemplate.addSubstitutionGroupMethod( methodOfSubstitutionHead );
            subsitituionGroupMethodAlreadyBuilt = false;
        } else {
            subsitituionGroupMethodAlreadyBuilt = true;
        }
        for ( final XSDElementDeclaration substitutiveElDec : substitutiveElementDecs ) {
            if ( !substitutiveElDec.isAbstract( ) ) {
                // non-abstract substitutive element or head element
                final QualifiedName subsitutiveQName = this.getQName( substitutiveElDec );

                final XmClass substitutiveMoinClass = this.xsdComplexTypeToMoinClass.get( substitutiveElDec.getTypeDefinition( ) );
                final HandlerAndComplexTypeMethodData handlerAndMethodData = PSUtil.getHandlerAndComplexTypeMethodData( substitutiveMoinClass, this.parserTemplate.getPrefix( substitutiveMoinClass.getXsdNamespace( ) ) );

                // parser
                parentHandler.addChild( subsitutiveQName, handlerAndMethodData.getHandlerClassName( ) );
                parentHandler.addChildAssociation( subsitutiveQName, xmRefForSubstituionHead.getAssociation( ) );
                this.parserTemplate.addElementLocalName( subsitutiveQName.getLocalPart( ) );

                // serializer
                if ( !subsitituionGroupMethodAlreadyBuilt ) {
                    methodOfSubstitutionHead.getMethodCalls( ).add( new ElementMethodNameAndParameterTypeImpl( subsitutiveQName, handlerAndMethodData.getMethodName( ), handlerAndMethodData.getQualifiedJavaClassNameOfMoinClass( ) ) );
                }

                this.serializerTemplate.addElementQName( subsitutiveQName );

                // it is assumed that substitutive element declarations are always global
                if ( this.parserTemplate.existsSubHandler( handlerAndMethodData.getHandlerClassName( ) ) ) {
                    // do nothing, handler already exists, to avoid recursion
                } else {
                    // type of substitutive element must be a complex type definition, because substitution group head has complex type definition, therefore cast is possible
                    treatComplexTypeDef( (XSDComplexTypeDefinition) substitutiveElDec.getTypeDefinition( ), handlerAndMethodData );
                }
            }
        }
    }

    private void treatElementRefToNonAbstractElWithComplexType( final XSDElementDeclaration elementDec, final XmHandlerTemplateImpl parentHandler, final ComplexTypeMethodImpl parentMethod, final XSDComplexTypeDefinition typeDef ) {

        final QualifiedName qName = this.getQName( elementDec );

        // modelElement is a MOIN Reference, if the local element declaration references a global element with complex type !
        final XmReference moinReference = (XmReference) xsdFeatureToMoinStructualFeature.get( elementDec );
        final HandlerAndComplexTypeMethodData handlerAndMethodData = PSUtil.getHandlerAndComplexTypeMethodData( moinReference.getReferencedClass( ), this.parserTemplate.getPrefix( moinReference.getReferencedClass( ).getXsdNamespace( ) ) );
        //parser
        parentHandler.addChild( qName, handlerAndMethodData.getHandlerClassName( ) );
        parentHandler.addChildAssociation( qName, moinReference.getAssociation( ) );

        // serializer
        // element method for the referenced global element
        parentMethod.addComplexXmlElement( qName, moinReference.getAssociation( ), handlerAndMethodData.getMethodName( ) );

        if ( this.parserTemplate.existsSubHandler( handlerAndMethodData.getHandlerClassName( ) ) ) {
            // do nothing, handler already exists, to avoid recursion
        } else {
            treatComplexTypeDef( typeDef, handlerAndMethodData );
        }
        this.parserTemplate.addElementLocalName( qName.getLocalPart( ) );
        this.serializerTemplate.addElementQName( qName );
    }

    private void treatLocalElement( final XSDElementDeclaration elementDec, final XmHandlerTemplateImpl parentHandler, final ComplexTypeMethodImpl parentMethod ) {

        final XSDTypeDefinition typeDef = elementDec.getResolvedElementDeclaration( ).getTypeDefinition( );
        final QualifiedName qName = this.getQName( elementDec );
        this.serializerTemplate.addElementQName( qName );
        this.parserTemplate.addElementLocalName( qName.getLocalPart( ) );
        // name and prefix for element
        if ( typeDef.getName( ) != null && typeDef instanceof XSDComplexTypeDefinition ) {
            // has a global complex type definition --> node reference to global complex type
            final XmReference moinReference = (XmReference) xsdFeatureToMoinStructualFeature.get( elementDec );
            final XmClass moinClass = moinReference.getReferencedClass( );

            final HandlerAndComplexTypeMethodData handlerAndMethodData = PSUtil.getHandlerAndComplexTypeMethodData( moinClass, this.parserTemplate.getPrefix( moinClass.getXsdNamespace( ) ) );

            // serializer
            parentMethod.addComplexXmlElement( qName, moinReference.getAssociation( ), handlerAndMethodData.getMethodName( ) );

            // parser: handler for complex type definition:
            parentHandler.addChild( qName, handlerAndMethodData.getHandlerClassName( ) );
            parentHandler.addChildAssociation( qName, moinReference.getAssociation( ) );


            if ( this.parserTemplate.existsSubHandler( handlerAndMethodData.getHandlerClassName( ) ) ) {
                // do nothing, handler already exists, to avoid recursion, should be the same as mapping != null
            } else {
                treatComplexTypeDef( (XSDComplexTypeDefinition) typeDef, handlerAndMethodData );
            }
        } else {
            // has either an anonymous complex type definition or a simple type definition
            if ( typeDef instanceof XSDComplexTypeDefinition ) {
                // anonymous complex type definition
                final XmReference moinReference = (XmReference) xsdFeatureToMoinStructualFeature.get( elementDec );

                // build a concatenated unique name for the local element with anonymous complex type
                final boolean startClassNameWithL = parentHandler.getClassName( ).startsWith( "L" ); //$NON-NLS-1$
                final String handlerClassName = ( startClassNameWithL ? "" : "L" ) + parentHandler.getClassName( ) + "_L_" + this.firstCharacterToUpperCase( qName.getPrefix( ) ) + this.firstCharacterToUpperCase( elementDec.getName( ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

                final HandlerAndComplexTypeMethodData handlerInfo = new HandlerAndComplexTypeMethodData( XsdKind.LOCAL_ELEMENT, qName.getLocalPart( ), qName.getNamespace( ), PSUtil.replaceNonJavaCharacters( handlerClassName ), moinReference.getReferencedClass( ) );

                // serializer
                parentMethod.addComplexXmlElement( qName, moinReference.getAssociation( ), handlerInfo.getMethodName( ) );

                // parser 
                parentHandler.addChild( qName, handlerInfo.getHandlerClassName( ) );
                parentHandler.addChildAssociation( qName, moinReference.getAssociation( ) );

                treatComplexTypeDef( (XSDComplexTypeDefinition) typeDef, handlerInfo );
            } else {
                // simple type definition
                parentHandler.addSimpleXmlElement( qName, xsdFeatureToMoinStructualFeature.get( elementDec ).getMofName( ) );
                parentMethod.addSimpleXmlElement( qName, parentMethod.getQualifiedClassNameOfParameter( ), xsdFeatureToMoinStructualFeature.get( elementDec ).getMofName( ) );
            }
        }
    }

    private String firstCharacterToUpperCase( final String s ) {

        if ( s == null ) {
            throw new MoinNullPointerException( "s" ); //$NON-NLS-1$
        }
        if ( s.length( ) == 0 ) {
            return s;
        }
        final char first = s.charAt( 0 );
        if ( Character.isUpperCase( first ) ) {
            return s;
        } else {
            final StringBuilder sb = new StringBuilder( );
            sb.append( Character.toUpperCase( first ) );
            if ( s.length( ) > 1 ) {
                sb.append( s.substring( 1 ) );
            }
            return sb.toString( );
        }
    }
}
