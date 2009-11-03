package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * Represents the <code>&lt;XMI.content&gt;</code> element.
 */
class Content extends XmiElement {

    // Since the <XMI.content> element encloses class-level attribute value
    // elements, it handles collecting and setting them.

    // a class-scoped attribute whose (multi-)value is being currently read
    private AttributeInternal attr;

    // owning MofClass of the currently read classifier-level attribute
    private MofClassInternal mofClass;

    // stores currently read (multi-)value(s) of a class-scoped attribute
    private List<Object> values;

    Content( XmiElement parent, XmiContext context ) {

        super( parent, context );
        attr = null;
        mofClass = null;
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        ModelElementInternal element = context.resolveQualifiedName( qName );
        if ( element instanceof MofClassInternal ) {
            return context.resolveInstanceOrXmiReference( this, qName, attrs );
        }
        if ( element instanceof AttributeInternal ) {
            // classifier-level attribute
            MofClassInternal readMofClass = (MofClassInternal) context.resolveQualifiedName( qName.substring( 0, qName.lastIndexOf( XmiConstants.DOT_SEPARATOR ) ) );
            if ( ( element != attr ) || ( mofClass != readMofClass ) ) {
                // the first value element related to the first or the next
                // classifier-level attribute
                if ( attr != null ) {
                    // it is the next attribute, not the first one; set the
                    // previously obtained value ...
                    setAttributeValue( );
                }
                attr = (AttributeInternal) element;
                mofClass = readMofClass;
                values = new ArrayList<Object>( );
            }
            return new ClassLevelAttribute( this, context, attr );
        } else if ( element instanceof AssociationInternal ) {
            return new AssociationElement( this, context, (AssociationInternal) element );
        }
        // an unexpected element
        throw new XmiParseException( XMI.MOIN_XMI_1037, new Object[] { qName } );
    }

    @Override
    XmiElement endElement( String qName ) {

        if ( attr != null ) {
            // end of Content has been encountered and there is still a
            // previously collected (multi-)value of a classifier-level
            // attribute that has to be set
            setAttributeValue( );
        }
        return parent;
    }

    @Override
    @SuppressWarnings( { "unchecked" } )
    void receiveValue( Object value ) {

        // collects parts of (multi-)value of a class-scoped attribute
        if ( attr == null ) {
            throw new XmiParseException( XMI.MOIN_XMI_1034 );
        }
        if ( value instanceof List ) {
            values.addAll( (List) value );
        } else {
            values.add( value );
        }
    }

    private void setAttributeValue( ) {

        List<Object> list = new ArrayList<Object>( );
        Object value;
        for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
            value = it.next( );
            if ( value instanceof UnresolvedReference ) {
                value = ( (UnresolvedReference) value ).getValue( );
                if ( value == null ) {
                    throw new XmiParseException( XMI.MOIN_XMI_1035, new Object[] { attr.getName( ) } );
                }
            }
            list.add( value );
        }
        if ( context.isMultiValued( attr ) ) {
            value = list;
        } else {
            if ( !( list.size( ) == 1 ) ) {
                throw new XmiParseException( XMI.MOIN_XMI_1036, new Object[] { attr.getName( ) } );
            }
            value = list.get( 0 );
        }
        context.staticAttributeComplete( attr, value );
        attr = null;
        mofClass = null;
        values = null;
    }
}