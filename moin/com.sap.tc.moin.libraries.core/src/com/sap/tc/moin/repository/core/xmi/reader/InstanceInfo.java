package com.sap.tc.moin.repository.core.xmi.reader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;

import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.xmi.XmiElement;

/**
 * Represents a model element found in the XMI.
 */
public class InstanceInfo implements XmiElement, LinkEnd {

    private String uri;

    private String mofId;

    private MofClassInternal type;

    private List<Object /* attributeValue */> attributeValues;

    private Map<String /* attributeName */, Object /* attributeValue */> attributeValuesByName;

    private XmiElement parent;

    private String xmiId;

    public InstanceInfo( String uri, String mofId, MofClassInternal type, InstanceInfo parent, String xmiId ) {

        this.uri = uri;
        this.mofId = mofId;
        this.type = type;
        this.attributeValues = null;
        this.attributeValuesByName = null;
        this.parent = parent;
        this.xmiId = xmiId;
    }

    public void setAttributeValues( List<Object> attributeValues ) {

        this.attributeValues = attributeValues;
    }

    public void setAttributeValuesByName( Map<String, Object> attributeValuesByName ) {

        this.attributeValuesByName = attributeValuesByName;
    }

    public String getUri( ) {

        return uri;
    }

    public List getAttributeValues( ) {

        return attributeValues;
    }

    public Map<String, Object> getAttributeValuesByName( ) {

        return attributeValuesByName;
    }

    public XmiElement getParentElement( ) {

        return parent;
    }

    public String getMofId( ) {

        return mofId;
    }

    //FIXME Remove this method from MOIN API as element is not wrapped!!!
    public MofClass getType( ) {

        return (MofClass) type;
    }

    public void setType( MofClassInternal type ) {

        this.type = type;
    }

    public String getXmiId( ) {

        return xmiId;
    }

    @Override
    public String toString( ) {

        StringBuilder buf = new StringBuilder( );
        buf.append( QualifiedName.toDotSeparatedString( type.getQualifiedName( null ) ) );
        if ( mofId != null ) {
            buf.append( "::" + mofId ); //$NON-NLS-1$
        }
        buf.append( "[" ); //$NON-NLS-1$
        for ( Iterator it = attributeValuesByName.keySet( ).iterator( ); it.hasNext( ); ) {
            String name = (String) it.next( );
            Object value = attributeValuesByName.get( name );
            buf.append( name + "=" + value ); //$NON-NLS-1$
            if ( it.hasNext( ) ) {
                buf.append( "," ); //$NON-NLS-1$
            }
        }
        buf.append( "]" ); //$NON-NLS-1$
        return buf.toString( );
    }
}
