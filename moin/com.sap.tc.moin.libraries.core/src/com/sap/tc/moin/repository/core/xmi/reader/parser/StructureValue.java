package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.shared.util.QualifiedName;

/**
 * Represents the value of a StructureType.
 */
class StructureValue extends XmiElement implements UnresolvedReferencesCounter {

    private static final String MOF13_MULTIPLICITY_TYPE_IS_UNIQUE = "is_unique"; //$NON-NLS-1$

    private static final String MOF14_MULTIPLICITY_TYPE_IS_UNIQUE = "isUnique"; //$NON-NLS-1$

    private static final String MOF13_MULTIPLICITY_TYPE_IS_ORDERED = "is_ordered"; //$NON-NLS-1$

    private static final String MOF14_MULTIPLICITY_TYPE_IS_ORDERED = "isOrdered"; //$NON-NLS-1$

    // type of this structure value
    private StructureTypeInternal structType;

    // structure's fields, i.e. a list of StructureFields
    private List fields;

    /*
     * this iterator is used if oldFormat == true, it iterates trough all
     * elements in @link #fields current field in iterator is related to
     * currently read field value
     */
    private Iterator fieldsIterator;

    // field related to the currently read value
    private StructureField currentField;

    // storage for already read fields' values
    private Map<StructureField, Object /* fieldValue */> fieldsValues;

    /**
     * If <code>true</code>, the StructureType was serialized using
     * <code>&lt;XMI.field&gt;</code> elements as specified in XMI 1.0 and 1.1.
     * Since XMI 1.2, serialization is similar to that of RefObject instances.
     */
    private boolean isOldFormat;

    // number of currently unresolved references preventing creation of this
    // structure
    private int counter;

    // flag indicating if all sub-elements are already read, i.e. endElement ()
    // method has been called
    private boolean endReached;

    // holds an unresolved reference to this structure that should be set after
    // the instance creation
    private UnresolvedReference unresolvedRef;

    StructureValue( XmiElement parent, XmiContext context, StructureTypeInternal type, Attributes attrs, boolean oldFormat ) {

        super( parent, context );
        structType = type;
        isOldFormat = oldFormat;
        fieldsValues = new HashMap<StructureField, Object>( );
        counter = 0;
        endReached = false;
        unresolvedRef = null;
        fields = context.getStructureFields( structType );
        if ( oldFormat ) {
            // In XMI 1.0/1.1 format, the structure fields are serialized as
            // sub-elements. For now, only store an iterator on the fields.
            fieldsIterator = fields.iterator( );
        } else {
            // In XMI 1.2, the structure fields are serialized as normal XML
            // attributes; so we can read them in immediately. However, we have
            // to consider that between MOF 1.3 and MOF 1.4 the XML attribute
            // names of MultiplicityType.isOrdered and MultiplicityType.isUnique
            // have changed. They are migrated on the fly.
            //FIXME HACK!!!
            CoreConnection connection = this.context.getSession( ) != null ? this.context.getSession( ).getConnections( ).iterator( ).next( ) : null;
            boolean isMultiplicityType = QualifiedName.toDotSeparatedString( structType.getQualifiedName( connection ) ).equals( "Model.MultiplicityType" ); //$NON-NLS-1$
            String fieldName, fieldValue;
            for ( int i = 0; i < attrs.getLength( ); i++ ) {
                fieldName = attrs.getQName( i );
                // MOF 1.3 compatibility for MultiplicityType
                if ( isMultiplicityType ) {
                    if ( fieldName.equals( MOF13_MULTIPLICITY_TYPE_IS_ORDERED ) ) {
                        fieldName = MOF14_MULTIPLICITY_TYPE_IS_ORDERED;
                    } else if ( fieldName.equals( MOF13_MULTIPLICITY_TYPE_IS_UNIQUE ) ) {
                        fieldName = MOF14_MULTIPLICITY_TYPE_IS_UNIQUE;
                    }
                }
                fieldValue = attrs.getValue( i );
                resolveFieldValue( fieldName, fieldValue );
            }
        }
    }

    public void increaseUnresolvedRefs( ) {

        counter++;
    }

    public void decreaseUnresolvedRefs( ) {

        counter--;
        if ( endReached && ( counter == 0 ) ) {
            // As soon as all references are resolved, instantiate the
            // StructureType.
            RefStruct instance = createStructure( );
            if ( unresolvedRef != null ) {
                unresolvedRef.referenceResolved( instance );
            }
        }
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        if ( isOldFormat ) {
            if ( !( fieldsIterator.hasNext( ) ) ) {
                throw new XmiParseException( XMI.MOIN_XMI_1042, new Object[] { structType.getName( ) } );
            }
            currentField = (StructureField) fieldsIterator.next( );
        } else {
            currentField = (StructureField) context.resolveQualifiedName( qName );
        }
        return context.resolveValue( this, currentField.getType( ), attrs );
    }

    @Override
    void receiveValue( Object value ) {

        if ( value instanceof List ) {
            List values = (List) value;
            if ( values.size( ) != 1 ) {
                throw new XmiParseException( XMI.MOIN_XMI_1044, new Object[] { currentField.getName( ), structType.getName( ) } );
            }
            value = values.get( 0 );
        }
        if ( value instanceof UnresolvedReference ) {
            ( (UnresolvedReference) value ).setOwner( this );
        }
        setFieldValue( currentField, value );
    }

    private void setFieldValue( StructureField field, Object value ) {

        if ( fieldsValues.containsKey( field ) ) {
            throw new XmiParseException( XMI.MOIN_XMI_1043, new Object[] { structType.getName( ) } );
        }
        fieldsValues.put( field, value );
    }

    private void resolveFieldValue( String fieldName, String fieldValue ) {

        //FIXME HACK!!!
        CoreConnection connection = this.context.getSession( ) != null ? this.context.getSession( ).getConnections( ).iterator( ).next( ) : null;
        StructureField field;
        try {
            field = (StructureField) structType.lookupElement( connection, fieldName );
        } catch ( NameNotFoundException e ) {
            throw new XmiParseException( XMI.MOIN_XMI_1045, new Object[] { structType.getName( ), fieldName } );
        }
        Classifier type = context.getSession( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getNonAliasType( context.getSession( ), field );
        Object value = null;
        if ( type instanceof PrimitiveTypeInternal ) {
            value = context.resolvePrimitiveValue( (PrimitiveTypeInternal) type, fieldValue );
        } else if ( type instanceof EnumerationTypeInternal ) {
            value = context.getEnumerationValue( (EnumerationTypeInternal) type, fieldValue );
        } else if ( type instanceof MofClass ) {
            // TODO check correctness of object-valued structure field handling
            String xmiId = fieldValue.trim( );
            Object obj = context.getReferencedObject( xmiId );
            if ( obj == null ) {
                // reference not known yet
                obj = new UnresolvedReference( this );
                context.registerUnresolvedRef( xmiId, (UnresolvedReference) obj );
                value = obj;
            }
        } else {
            throw new XmiParseException( XMI.MOIN_XMI_1046, new Object[] { type.getName( ) } );
        }
        setFieldValue( field, value );
    }

    private RefStruct createStructure( ) {

        // First obtain list of fields values.
        List<Object> fieldValues = new ArrayList<Object>( );
        for ( Iterator it = fields.iterator( ); it.hasNext( ); ) {
            StructureField field = (StructureField) it.next( );
            Object param = fieldsValues.get( field );
            if ( param instanceof UnresolvedReference ) {
                param = ( (UnresolvedReference) param ).getValue( );
            }
            if ( param != null ) {
                fieldValues.add( param );
            }
        }
        // Finally, create the Structure.
        return context.createStructure( structType, fieldValues );
    }

    @Override
    XmiElement endElement( String qName ) {

        endReached = true;
        if ( counter == 0 ) {
            RefStruct instance = createStructure( );
            if ( !( parent instanceof Content ) ) {
                parent.receiveValue( instance );
            }
        } else {
            if ( !( parent instanceof Content ) ) {
                unresolvedRef = new UnresolvedReference( );
                parent.receiveValue( unresolvedRef );
            }
        }
        if ( isOldFormat ) {
            // A PATCH - see comment in StructureValues.startSubElement ()
            // method.
            return parent.endElement( qName );
        }
        return parent;
    }
}
