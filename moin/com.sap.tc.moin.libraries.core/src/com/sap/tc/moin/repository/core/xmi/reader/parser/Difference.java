package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * Represents a <code>&lt;XMI.difference&gt;</code> element. 
 */
class Difference extends XmiElement {

    // link defining a target the differences apply on
    private String href;

    // true if one of Add, Delete or Replace sub-elements is being currently
    // read
    private boolean diffReading;

    // read sub-element
    private Diff currentDiff;

    // storage of all Add, Delete, Replace sub-elements
    private Map<String, List<Diff>> diffs = new HashMap<String, List<Diff>>( );

    private int timeStamp = 1;

    Difference( XmiElement parent, XmiContext context, Attributes attrs ) {

        super( parent, context );
        href = attrs.getValue( XmiConstants.XMI_HREF );
        if ( href == null ) {
            throw new XmiParseException( XMI.MOIN_XMI_1047 );
        }
        diffReading = false;
    }

    XmiElement startElement( String qName, Attributes attrs ) {

        if ( !diffReading ) {
            if ( qName.equals( XmiConstants.XMI_DIFFERENCE ) ) {
                throw new XmiParseException( XMI.MOIN_XMI_1048 );
            }
            int kind = Diff.ADD;
            if ( qName.equals( XmiConstants.XMI_DELETE ) ) {
                kind = Diff.DELETE;
            } else if ( qName.equals( XmiConstants.XMI_REPLACE ) ) {
                kind = Diff.REPLACE;
            }
            String localHref = attrs.getValue( XmiConstants.XMI_HREF );
            int index = localHref.lastIndexOf( "|" ); //$NON-NLS-1$
            if ( index == -1 ) {
                index = localHref.lastIndexOf( "#" ); //$NON-NLS-1$
            }
            String id = localHref.substring( index + 1, localHref.length( ) );
            String posString = attrs.getValue( XmiConstants.XMI_POSITION );
            int pos = 1; // default value
            if ( posString != null ) {
                try {
                    pos = Integer.parseInt( posString );
                } catch ( NumberFormatException e ) {
                    throw new XmiParseException( XMI.MOIN_XMI_1049, new Object[] { posString } );
                }
            }
            if ( pos < 0 ) {
                throw new XmiParseException( XMI.MOIN_XMI_1050, new Object[] { posString } );
            }
            currentDiff = new Diff( kind, id, pos, timeStamp );
            timeStamp++;
            diffReading = true;
        } else { // diffReading == true
            currentDiff.items.add( new Item( qName, attrs ) );
        }
        return this;
    }

    void characters( char buf[], int offset, int len ) {

        if ( diffReading && buf != null && len > 0 ) {
            currentDiff.items.add( new String( buf, offset, len ) );
        }
    }

    XmiElement endElement( String qName ) {

        if ( diffReading ) {
            if ( ( qName.equals( XmiConstants.XMI_ADD ) ) || ( qName.equals( XmiConstants.XMI_DELETE ) ) || ( qName.equals( XmiConstants.XMI_REPLACE ) ) ) {
                diffReading = false;
                List<Diff> list = diffs.get( currentDiff.xmiId );
                if ( list == null ) {
                    diffs.put( currentDiff.xmiId, list = new ArrayList<Diff>( ) );
                }
                if ( currentDiff.kind == Diff.DELETE ) {
                    list.add( 0, currentDiff );
                } else {
                    list.add( list.size( ) - 1, currentDiff );
                }
            } else {
                currentDiff.items.add( new Item( qName ) );
            }
            return this;
        }
        // context.resolveDifferences(href, diffs);
        return parent;
    }

    // stores data related to one difference (add, delete or replace)
    public static class Diff {

        // constants for kind of difference
        public static final int ADD = 0;

        public static final int DELETE = 1;

        public static final int REPLACE = 2;

        // kind of this difference
        public int kind;

        // optional position parameter, not relevant in case of Delete
        // difference
        public int position;

        // xmi id of an elemenet the difference applays on
        public String xmiId;

        // content stored as a sequence of events represented by items or a
        // String in case
        // of a characters event
        public List<Object> items = new ArrayList<Object>( );

        public int timeStamp;

        public Diff( int kind, String xmiId, int position, int timeStamp ) {

            this.kind = kind;
            this.xmiId = xmiId;
            this.position = position;
            this.timeStamp = timeStamp;
        }

    }

    // stores one start element or end element event
    public static class Item {

        // if true, represents start of an element
        public boolean isStart;

        // element name
        public String qName;

        // related attributes (in case of start of element)
        public Attributes attrs;

        // end element event
        public Item( String qName ) {

            this.qName = qName;
            isStart = false;
        }

        // start element event
        public Item( String qName, Attributes attrs ) {

            this.qName = qName;
            // attributes cannot be stored directly, they have to be copied
            this.attrs = new AttributesImpl( attrs );
            isStart = true;
        }
    }

}
