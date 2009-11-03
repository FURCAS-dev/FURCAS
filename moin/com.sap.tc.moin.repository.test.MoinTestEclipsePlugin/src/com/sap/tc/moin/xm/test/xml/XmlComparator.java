package com.sap.tc.moin.xm.test.xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;


/**
 * Compares two XML documents.
 * <p>
 * The elements and attributes are compared. Not covered are comments,
 * processing instructions, and entity references.
 * <p>
 * If the order of the sub-elements is different than a difference is reported.
 * <p>
 * Mixed Content is not supported.
 */
public final class XmlComparator {

    /**
     * Compares the two documents and reports differences to the string builder.
     * 
     * @param xmlDoc1
     * @param xmlDoc2
     * @param differences
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public static void compare( InputStream xmlDoc1, InputStream xmlDoc2, StringBuilder differences ) {

        Map<String, String> namespace2Prefix = new HashMap<String, String>( );
        namespace2Prefix.put( XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "xsi" );
        XmlParser p1 = new XmlParser( xmlDoc1, namespace2Prefix );
        XmlParser p2 = new XmlParser( xmlDoc2, namespace2Prefix );
        XmlComparator c = new XmlComparator( p1.toList( ), p2.toList( ), differences );

        c.compare( );
    }

    private final List<XmlElement> queue1;

    private final List<XmlElement> queue2;

    private final StringBuilder differences;

    XmlComparator( List<XmlElement> aQueue1, List<XmlElement> aQueue2, StringBuilder aDifferences ) {

        if ( aQueue1 == null ) {
            throw new NullPointerException( "aQueue1 is null" );
        }
        this.queue1 = aQueue1;
        if ( aQueue2 == null ) {
            throw new NullPointerException( "aQueue2 is null" );
        }
        if ( aDifferences == null ) {
            throw new NullPointerException( "aDifferences is null" );
        }
        this.queue2 = aQueue2;
        this.differences = aDifferences;
    }

    void compare( ) {

        int length = this.queue1.size( );
        if ( this.queue2.size( ) < length ) {
            length = this.queue2.size( );
            this.addMessage( "The source and target XML document have a different number of elements" );
        }
        for ( int i = 0; i < length; i++ ) {
            XmlElement el1 = this.queue1.get( i );
            XmlElement el2 = this.queue2.get( i );
            doCompare( el1, el2 );
        }
    }

    private void doCompare( XmlElement el1, XmlElement el2 ) {

        if ( el1 == null && el2 == null ) {
            return;
        }
        if ( el1 == null ) {
            this.addMessage( "The target element " + el2.xpath + " does not have a corresponding source element" );
            return;
        }
        if ( el2 == null ) {
            this.addMessage( "The source element " + el1.xpath + " does not have a corresponding target element" );
            return;
        }
        if ( !el1.xpath.equals( el2.xpath ) ) {
            this.addMessage( "The source element " + el1.xpath + " does not have the same xpath than the target element " + el2.xpath );
            return;
        }
        // both elements are not null
        if ( !el1.value.equals( el2.value ) ) {
            this.addMessage( "The  value " + el1.value + " of the source element " + el1.xpath + " is different from the value " + el2.value + " of the corresponding target element" );
        }
        this.compareAttributes( el1, el2, true );
        // vice versa
        this.compareAttributes( el2, el1, false );
    }

    private void compareAttributes( XmlElement el1, XmlElement el2, boolean is1Source ) {

        Map<String, XmlAttribute> attrs1 = el1.attrs;
        Map<String, XmlAttribute> attrs2 = el2.attrs;
        for ( String key : attrs1.keySet( ) ) {
            if ( key.equals( "xsi:schemaLocation" ) ) {
                // ignore this attribute
                continue;
            }
            XmlAttribute attr1 = attrs1.get( key );
            XmlAttribute attr2 = attrs2.get( key );
            if ( attr2 == null ) {
                if ( is1Source ) {
                    this.addMessage( "The attribute " + key + " of element " + el1.xpath + " does not exist in the target element " );
                } else {
                    this.addMessage( "The attribute " + key + " of element " + el1.xpath + " does not exist in the source element " );
                }
            } else {
                if ( !attr1.value.equals( attr2.value ) ) {
                    if ( is1Source ) {
                        this.addMessage( "The value " + attr1.value + " of the source attribute " + key + " is different from the value " + attr2.value + " of the corresponding target attribute of the element " + el1.xpath );
                    } else {
                        this.addMessage( "The value " + attr1.value + " of the source attribute " + key + " is different from the value " + attr2.value + " of the corresponding source attribute of the element " + el1.xpath );
                    }
                }
            }
        }
    }

    private void addMessage( String s ) {

        this.differences.append( s );
        this.differences.append( "\n" );
    }



}
