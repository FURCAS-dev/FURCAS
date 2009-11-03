package com.sap.tc.moin.repository.s2x;

import static com.sap.tc.moin.repository.spi.core.SpiJmiHelper.TRANSLATABLE_TEXT_FRAGMENT_QNAME;
import static com.sap.tc.moin.repository.spi.core.SpiJmiHelper.TRANSLATABLE_TEXT_QNAME;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sap.s2x.S2XDocument;
import com.sap.s2x.etc.TranslationUnit;
import com.sap.s2x.validation.ValidationException;
import com.sap.tc.moin.repository.shared.util.Tuple.Triple;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XTranslationUnit;

/**
 * This class serializes
 * {@link com.sap.tc.moin.textverticalization.TranslatableText translatable
 * text} attributes into the so-called SAP supported XLIFF (S2X) format.
 * <p>
 * If this serializer is called it serializes the S2X document into the provided
 * {@link OutputStream} regardless of the fact whether there are translatable
 * texts present or not. In the latter case the S2X document consists only of
 * the header part and has no body part, i.e. text content. But it is a valid
 * (quite empty) S2X document.
 * <p>
 * This behaviour is an essential part of the protocol between the serializer
 * and the persistency layer. The persistency layer is responsible for the
 * technical creation and deletion of the entity on which the output stream is
 * opened, e.g. an S2X file or a table entry.
 */
public class S2XSerializer implements SpiCustomSerializer {

    S2XSerializerJmxAdapter jmx = null;

    S2XSerializerLoggingAdapter log = null;

    SpiS2XDocument s2xDocument = null;

    SpiPartitionSerializationManager partitionSerializationManager = null;

    public S2XSerializer( SpiS2XDocument s2xDocument, SpiPartitionSerializationManager partitionSerializationManager ) {

        this.s2xDocument = s2xDocument;
        this.partitionSerializationManager = partitionSerializationManager;
        this.jmx = new S2XSerializerJmxAdapter( this );
        this.log = new S2XSerializerLoggingAdapter( );
    }

    public void serialize( OutputStream outputStream, SpiSerializerCallback moinCallback ) throws RuntimeException {

        long t1 = System.nanoTime( );
        log.s2XSerializerStart( moinCallback.getPri( ), s2xDocument.getLanguage( ), s2xDocument.getDevelContact( ) );
        jmx.s2XSerializerStart( moinCallback.getPri( ), s2xDocument.getLanguage( ), s2xDocument.getDevelContact( ) );
        Map<String, TranslationUnit> translationUnits = new LinkedHashMap<String, TranslationUnit>( );
        // get all translatable texts
        List<Triple<SpiElement, String, SpiStructuredValue>> translatableTextFragments = getTranslatableTextFragmentValues( moinCallback );
        // transform them into translation units
        for ( Triple<SpiElement, String, SpiStructuredValue> translatableTextFragment : translatableTextFragments ) {
            SpiElement parent = translatableTextFragment.getA( );
            String attributeName = translatableTextFragment.getB( );
            SpiStructuredValue attributeValue = translatableTextFragment.getC( );
            String originalText = null;
            if ( attributeValue != null && ( originalText = (String) attributeValue.get___FieldValue( "originalText" ) ) != null && originalText.length( ) != 0 ) { //$NON-NLS-1$
                // only not empty texts make sense to be serialized into S2X
                TranslationUnit translationUnit = new TranslationUnit( );
                // the original text is always set by MOIN itself because it does not make sense to change it in the callback handler
                translationUnit.setSource( originalText );
                // the translation unit ID is always set by MOIN itself because it identifies the translatable text in MOIN
                translationUnit.setID( (String) attributeValue.get___FieldValue( "transUnitId" ) ); //$NON-NLS-1$
                // also the following text attributes can not be set by the callback handler
                translationUnit.setRestype( (String) attributeValue.get___FieldValue( "resType" ) ); //$NON-NLS-1$
                translationUnit.setMaxwidth( (String) attributeValue.get___FieldValue( "maxWidth" ) ); //$NON-NLS-1$
                translationUnit.setTranslate( ( (String) attributeValue.get___FieldValue( "translate" ) ).equals( Boolean.TRUE.toString( ) ) ? "yes" : "no" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                // for TranslatableTexts the resource name comes from the instance itself
                // for TranslatableTextFragments the resource name comes from a custom callback handler
                if ( !isTranslatableText( parent.get___Type( ).get___AttributeTypeAsEnum( attributeName ), attributeValue.get___Type( ) ) ) {
                    // "pure" TranslatableTextFragment instances have to have a callback handler
                    // these are instances that inherit from TranslatableTextFragment and not from TranslatableText
                    // let the callback handler fill the resource name
                    SpiS2XSerializerCustomCallback customS2XSerilizerCallback = partitionSerializationManager.getCustomS2XSerializerCallback( attributeValue.get___Type( ).get___MetamodelContainer( ) );
                    if ( customS2XSerilizerCallback != null ) {
                        long t2 = System.nanoTime( );
                        SpiS2XTranslationUnit s2XTranslationUnit = null;
                        try {
                            s2XTranslationUnit = customS2XSerilizerCallback.getTranslationUnit( parent, attributeName, attributeValue );
                        } catch ( RuntimeException runtimeEx ) {
                            log.s2XSerializerException( runtimeEx );
                            jmx.s2XSerializerException( runtimeEx );
                            throw runtimeEx;
                        }
                        long duration = ( System.nanoTime( ) - t2 ) / 1000000;
                        if ( s2XTranslationUnit != null ) {
                            log.s2XSerializerCallback( parent, attributeName, attributeValue, s2XTranslationUnit, duration );
                            jmx.s2XSerializerCallback( parent, attributeName, attributeValue, s2XTranslationUnit, duration );
                            // the callback handler can only set the resource name
                            translationUnit.setResname( s2XTranslationUnit.getResName( ) );
                        } else {
                            S2XSerializerException s2xSerializerEx = new S2XSerializerException( S2XSerializerMessages.TRANSLATIONUNITISNULL, customS2XSerilizerCallback.getClass( ).getCanonicalName( ) );
                            log.s2XSerializerException( s2xSerializerEx );
                            jmx.s2XSerializerException( s2xSerializerEx );
                            throw s2xSerializerEx;
                        }
                    } else {
                        S2XSerializerException s2xSerializerEx = new S2XSerializerException( S2XSerializerMessages.SERIALIZATIONCALLBACKHANDLERISNULL );
                        log.s2XSerializerException( s2xSerializerEx );
                        jmx.s2XSerializerException( s2xSerializerEx );
                        throw s2xSerializerEx;
                    }
                } else {
                    // fill the resource name from the TranslatableText instance itself
                    translationUnit.setResname( (String) attributeValue.get___FieldValue( "resName" ) ); //$NON-NLS-1$
                }
                // avoid duplicates
                translationUnits.put( translationUnit.getID( ), translationUnit );
            }
        }
        // create the S2X document
        // Even if we don't have any texts we write a (quite empty but valid) S2X document.
        // This behaviour is an essential part of the protocol between the serializer and the persistency layer
        S2XDocument s2xDocument;
        try {
            s2xDocument = createS2XDocument( );
        } catch ( Exception exception ) {
            log.s2XSerializerException( exception );
            jmx.s2XSerializerException( exception );
            throw new RuntimeException( exception );
        }
        int numberOfTexts = 0;
        try {
            // store the texts into the S2X document
            for ( TranslationUnit translationUnit : translationUnits.values( ) ) {
                log.s2XSerializerAddTranslationUnit( translationUnit );
                jmx.s2XSerializerAddTranslationUnit( translationUnit );
                s2xDocument.addText( translationUnit );
                numberOfTexts++;
            }
            // store the S2X document
            s2xDocument.store( outputStream );
        } catch ( Exception exception ) {
            log.s2XSerializerException( exception );
            jmx.s2XSerializerException( exception );
            throw new RuntimeException( exception );
        }
        long duration = ( System.nanoTime( ) - t1 ) / 1000000;
        log.s2XSerializerEnd( duration, numberOfTexts );
        jmx.s2XSerializerEnd( outputStream, duration, numberOfTexts );
    }

    private List<Triple<SpiElement, String, SpiStructuredValue>> getTranslatableTextFragmentValues( SpiSerializerCallback moinCallback ) {

        List<Triple<SpiElement, String, SpiStructuredValue>> result = new ArrayList<Triple<SpiElement, String, SpiStructuredValue>>( );
        Collection<SpiElement> elements = moinCallback.getElements( );
        for ( SpiElement element : elements ) {
            SpiClass clazz = element.get___Type( );
            for ( String attributeName : clazz.get___AttributeNames( ) ) {
                if ( isTranslatableTextFragment( clazz.get___AttributeTypeAsEnum( attributeName ), clazz.get___AttributeType( attributeName ) ) ) {
                    // we have a TranslatableTextFragment attribute here
                    if ( clazz.is___MultiValuedAttribute( attributeName ) ) {
                        // attribute is multi-valued, take every value
                        Collection<?> structuredValues = (Collection<?>) element.get___AttributeValue( attributeName );
                        if ( structuredValues != null ) {
                            for ( Object structuredValue : structuredValues ) {
                                result.add( new Triple<SpiElement, String, SpiStructuredValue>( element, attributeName, (SpiStructuredValue) structuredValue ) );
                            }
                        } else {
                            // for symmetry reasons
                            result.add( new Triple<SpiElement, String, SpiStructuredValue>( element, attributeName, null ) );
                        }
                    } else {
                        // attribute is single-valued
                        SpiStructuredValue structuredValue = (SpiStructuredValue) element.get___AttributeValue( attributeName );
                        result.add( new Triple<SpiElement, String, SpiStructuredValue>( element, attributeName, structuredValue ) );
                    }
                }
            }
        }
        return result;
    }

    private S2XDocument createS2XDocument( ) throws ValidationException, ParserConfigurationException, IOException, SAXException {

        String language = s2xDocument.getLanguage( ) == null ? "en" : s2xDocument.getLanguage( ); //$NON-NLS-1$
        String develContact = s2xDocument.getDevelContact( ) == null ? "" : s2xDocument.getDevelContact( ); //$NON-NLS-1$
        S2XDocument s2xDocument = new S2XDocument( false );
        s2xDocument.setTool( "MOIN S2X File Generator" ); //$NON-NLS-1$
        s2xDocument.setOriginal( "self" ); //$NON-NLS-1$
        s2xDocument.setSourceLanguage( language );
        // TODO INSPECT: the product name should be application specific, what should be taken here, the metamodel name perhaps?
        // TODO INSPECT: check prefix concern, @@...
        s2xDocument.setProductname( "MOIN S2X File Generator" ); //$NON-NLS-1$
//      s2xDocument.setDatatype( "javaPropertyResourceBundle" );
        s2xDocument.setDatatype( "s2x" ); //$NON-NLS-1$
        s2xDocument.setDevelContact( develContact ); // email address of the developer or CSN component
        s2xDocument.setOriginalLocale( language );
        s2xDocument.setMaxLength( "255" ); //$NON-NLS-1$
        return s2xDocument;
    }

    private boolean isTranslatableTextFragment( SpiValueTypeEnum attributeTypeEnum, SpiType attributeType ) {

        if ( attributeTypeEnum == SpiValueTypeEnum.STRUCTURE_TYPE ) {
            // for performance optimizations check type enum first
            // convert supertype hierarchy to qName list
            List<SpiType> superTypes = attributeType.get___AllSuperTypes( );
            List<String> superTypesQNames = new ArrayList<String>( superTypes.size( ) );
            for ( SpiType superType : superTypes ) {
                superTypesQNames.add( superType.get___QualifiedName( ) );
            }
            if ( attributeType.get___QualifiedName( ).equals( TRANSLATABLE_TEXT_FRAGMENT_QNAME ) || superTypesQNames.contains( TRANSLATABLE_TEXT_FRAGMENT_QNAME ) ) {
                return true;
            }
        }
        return false;
    }

    private boolean isTranslatableText( SpiValueTypeEnum attributeTypeEnum, SpiType attributeType ) {

        if ( attributeTypeEnum == SpiValueTypeEnum.STRUCTURE_TYPE ) {
            // for performance optimizations check type enum first
            // convert supertype hierarchy to qName list
            List<SpiType> superTypes = attributeType.get___AllSuperTypes( );
            List<String> superTypesQNames = new ArrayList<String>( superTypes.size( ) );
            for ( SpiType superType : superTypes ) {
                superTypesQNames.add( superType.get___QualifiedName( ) );
            }
            if ( attributeType.get___QualifiedName( ).equals( TRANSLATABLE_TEXT_QNAME ) || superTypesQNames.contains( TRANSLATABLE_TEXT_QNAME ) ) {
                return true;
            }
        }
        return false;
    }
}
