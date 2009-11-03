package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.StringUtils;

/**
 * Represents a model element found in the XMI.
 */
class Instance extends XmiElement implements UnresolvedReferencesCounter {

    // xmi.id value
    private String xmiId;

    // number of currently unresolved references preventing creation of this
    // instance
    private int unresolvedRefsCounter;

    // flag indicating if all sub-elements are already read, i.e. endElement ()
    // method has been called
    private boolean endReached;

    // holds an unresolved reference to this instance that should be set after
    // the instance creation
    private UnresolvedReference unresolvedRef;

    // currently processed attribute or reference
    private StructuralFeatureInternal currentFeature;

    // MofClass resolved according to the name
    private MofClassInternal mofClass;

    // temporal storage for values of instance level attributes
    private Map<StructuralFeatureInternal, Object> attributesValues;

    // temporal storage for values of instance level references
    private Map referencesValues;

    private List<Object> attributeValues;

    private Map<String, Object> attributeValuesByName;

    private String mofId;

    private InstanceInfo info;

    private String uri;

    private String nameAttr;

    private String orderingAttr;

    Instance( XmiElement parent, XmiContext context, MofClassInternal mc, Attributes attrs ) {

        super( parent, context );
        uri = context.getCurrentURI( );
        mofClass = mc;
        xmiId = null;
        unresolvedRefsCounter = 0;
        endReached = false;
        unresolvedRef = null;
        attributesValues = new HashMap<StructuralFeatureInternal, Object>( );
        referencesValues = new HashMap( );
        nameAttr = null;
        orderingAttr = null;
        // process all passed XMI attributes and instance attributes
        for ( int i = 0; i < attrs.getLength( ); i++ ) {
            String attrName = attrs.getQName( i );
            String attrValue = attrs.getValue( i );
            if ( attrName.startsWith( XmiConstants.XMI_ATTRIBUTE_PREFIX ) ) {
                if ( attrName.equals( XmiConstants.XMI_ID ) ) {
                    xmiId = attrValue;
                }
            } else if ( attrName.equals( XmiConstants.ORDERING_ATTRIBUTE ) ) {
                orderingAttr = attrValue;
            } else {
                resolveAttributeValue( attrName, attrValue );
            }
            if ( attrName.equals( "name" ) ) { //$NON-NLS-1$
                nameAttr = attrValue;
            }
        }
        mofId = null;
        if ( context.isLoadingPartition( ) ) {
            // In partition mode, the XMI-ID always contains the MOF-ID.
            // (In import mode, the MOF-ID is determined differently: either a
            // new MOF-ID is created, or - in case of an incremental import -
            // the MOF-ID of the already existing model element is kept.)
            mofId = xmiId;
        }
        XmiElement myParent = parent;
        while ( !( myParent instanceof Content ) && !( myParent instanceof Instance ) ) {
            myParent = myParent.getParentElement( );
        }
        info = new InstanceInfo( uri, mofId, mofClass, ( myParent != null && myParent instanceof Instance ) ? ( (Instance) myParent ).getInfo( ) : null, xmiId );
    }

    MofClassInternal getType( ) {

        return mofClass;
    }

    String getMofId( ) {

        return mofId;
    }

    List getAttributeValues( ) {

        return attributeValues;
    }

    Map getAttributeValuesByName( ) {

        return attributeValuesByName;
    }

    String getValueOfNameAttr( ) {

        return nameAttr;
    }

    String getOrdering( ) {

        return orderingAttr;
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        if ( qName.equals( XmiConstants.XMI_EXTENSION ) ) {
            return new Extension( this, context, attrs );
        }
        Object ref = context.resolveQualifiedName( qName );
        if ( !( ref instanceof StructuralFeatureInternal ) ) {
            throw new XmiParseException( XMI.MOIN_XMI_1039, new Object[] { qName } );
        }
        currentFeature = (StructuralFeatureInternal) ref;
        if ( currentFeature instanceof Attribute ) {
            //FIXME HACK!!!
            CoreConnection connection = this.context.getSession( ) != null ? this.context.getSession( ).getConnections( ).iterator( ).next( ) : null;
            return context.resolveValue( this, currentFeature.getType( connection ), attrs );
        } else if ( currentFeature instanceof Reference ) {
            ObjectValues xmiObjectValues = new ObjectValues( this, context );
            String href = attrs.getValue( XmiConstants.XMI_HREF );
            if ( href != null ) {
                throw new MoinLocalizedBaseRuntimeException( XMI.UNEXPECTEDHREFATTRIBUTE );
            }
            return xmiObjectValues;
        }
        throw new XmiParseException( XMI.MOIN_XMI_1039, new Object[] { qName } );
    }

    @Override
    XmiElement endElement( String qName ) {

        // The reading of the model element represented by this Instance object
        // is finished. If there are no unresolved references, the
        // model element is now ready for instantiation.
        endReached = true;
        if ( unresolvedRefsCounter == 0 ) {
            instanceComplete( );
            if ( !( parent instanceof Content ) ) {
                parent.receiveValue( getInfo( ) );
            }
        } else {
            if ( !( parent instanceof Content ) ) {
                unresolvedRef = new UnresolvedReference( );
                parent.receiveValue( unresolvedRef );
            }
        }
        return parent;
    }

    @Override
    @SuppressWarnings( { "unchecked" } )
    void receiveValue( Object value ) {

        if ( currentFeature instanceof AttributeInternal ) {
            if ( value instanceof List ) {
                setAttributeValues( currentFeature, (List) value );
            } else {
                setAttributeValue( currentFeature, value );
            }
        } else {
            // must be a Reference
            List list = null;
            if ( value instanceof List ) {
                list = (List) value;
            } else {
                list = new ArrayList( );
                list.add( value );
            }
            setReferenceValues( (ReferenceInternal) currentFeature, list );
        }
    }

    StructuralFeatureInternal getCurrentFeature( ) {

        return currentFeature;
    }

    /**
     * Performs an end-processing as soon as all needed references related to
     * attribute values have been resolved.
     */
    private void instanceComplete( ) {

        List attributes = context.getInstanceAttributes( mofClass );
        attributeValues = new ArrayList<Object>( );
        attributeValuesByName = new HashMap<String, Object>( );
        if ( attributes != null ) {
            // obtain list of attributes values
            for ( Iterator it = attributes.iterator( ); it.hasNext( ); ) {
                Attribute attr = (Attribute) it.next( );
                Object param = attributesValues.get( attr );
                if ( param instanceof UnresolvedReference ) {
                    param = ( (UnresolvedReference) param ).getValue( );
                } else if ( param instanceof List ) {
                    List<Object> temp = new ArrayList<Object>( );
                    for ( Iterator paramIt = ( (List) param ).iterator( ); paramIt.hasNext( ); ) {
                        Object value = paramIt.next( );
                        if ( value instanceof UnresolvedReference ) {
                            value = ( (UnresolvedReference) value ).getValue( );
                        }
                        assert value != null : "Unexpected null value encountered for multi-valued attribute: " + QualifiedName.toDotSeparatedString( attr.getQualifiedName( ) ); //$NON-NLS-1$
                        temp.add( value );
                    }
                    param = temp;
                }
                if ( param != null ) {
                    attributeValues.add( param );
                    attributeValuesByName.put( attr.getName( ), param );
                }
            }
        }
        info.setAttributeValues( attributeValues );
        info.setAttributeValuesByName( attributeValuesByName );
        context.instanceComplete( xmiId, info );
        List references = context.getReferences( mofClass );
        if ( references != null ) {
            // set resolved references, register unresolved
            for ( Iterator it = references.iterator( ); it.hasNext( ); ) {
                Reference ref = (Reference) it.next( );
                List values = (List) referencesValues.get( ref );
                if ( values != null ) {
                    new ReferenceHandler( ref, info, values, context );
                }
            }
        }
    }

    /**
     * Stores attribute value. It can be a single-value or a part of multi-value
     * as well. Thus, in case of multi-values, the method can be called several
     * times with the same attribute parameter.
     */
    @SuppressWarnings( { "unchecked" } )
    private void setAttributeValue( StructuralFeatureInternal attr, Object value ) {

        boolean isMultivalued = context.isMultiValued( attr );
        Object tempValue = attributesValues.get( attr );
        if ( !isMultivalued ) {
            if ( tempValue != null ) {
                throw new JmiException( XMI.MOIN_XMI_1036, attr.getName( ) );
            }
            attributesValues.put( attr, value );
        } else {
            if ( tempValue == null ) {
                attributesValues.put( attr, tempValue = new ArrayList( ) );
            }
            ( (List) tempValue ).add( value );
        }
    }

    /**
     * Similar to {@link #setAttributeValue(StructuralFeature, Object)}, except
     * that a list of values is passed rather than one value.
     */
    @SuppressWarnings( { "unchecked" } )
    private void setAttributeValues( StructuralFeatureInternal attr, List values ) {

        boolean isMultivalued = context.isMultiValued( attr );
        if ( !isMultivalued && ( values.size( ) == 1 ) ) {
            setAttributeValue( attr, values.get( 0 ) );
            return;
        }
        if ( !isMultivalued ) {
            throw new JmiException( XMI.MOIN_XMI_1036, attr.getName( ) );
        }
        Object tempValue = attributesValues.get( attr );
        if ( tempValue == null ) {
            attributesValues.put( attr, tempValue = new ArrayList( ) );
        }
        ( (List) tempValue ).addAll( values );
    }

    /**
     * Stores values of a reference.
     */
    @SuppressWarnings( { "unchecked" } )
    private void setReferenceValues( ReferenceInternal ref, List values ) {

        boolean isMultivalued = context.isMultiValued( ref );
        Object tempValue = referencesValues.get( ref );
        if ( !isMultivalued ) {
            boolean multiplicityError = false;
            if ( values.size( ) > 1 ) {
                multiplicityError = true;
            } else {
                if ( tempValue != null ) {
                    multiplicityError = true;
                    // check equality
                    if ( values.size( ) > 0 ) {
                        if ( tempValue instanceof List ) {
                            List l = (List) tempValue;
                            if ( l.get( 0 ).equals( values.get( 0 ) ) ) {
                                multiplicityError = false;
                            }
                        } else {
                            if ( tempValue.equals( values.get( 0 ) ) ) {
                                multiplicityError = false;
                            }
                        }
                    }
                }
            }
            if ( multiplicityError ) {
                //FIXME HACK!!!
                CoreConnection connection = context.getSession( ) != null ? context.getSession( ).getConnections( ).iterator( ).next( ) : null;
                throw new XmiParseException( XMI.MOIN_XMI_1040, new Object[] { QualifiedName.toDotSeparatedString( ref.getQualifiedName( connection ) ) } );
            }
            referencesValues.put( ref, values );
            return;
        }
        if ( tempValue == null ) {
            tempValue = new ArrayList( );
            referencesValues.put( ref, tempValue );
        }
        ( (List) tempValue ).addAll( values );
    }



    /**
     * Resolves attribute value stored as XMI element attribute (example:
     * <Model:Class name='Person'/> ).
     */
    @SuppressWarnings( { "unchecked" } )
    private void resolveAttributeValue( String attrName, String attrValue ) {

        StructuralFeatureInternal feature = context.getStructuralFeature( mofClass, attrName );
        if ( feature != null ) {
            ClassifierInternal type = context.getNonAliasType( feature );
            Object value = null;
            if ( type instanceof PrimitiveTypeInternal ) {
                value = context.resolvePrimitiveValue( (PrimitiveTypeInternal) type, attrValue );
                setAttributeValue( feature, value );
            } else if ( type instanceof EnumerationType ) {
                value = context.getEnumerationValue( (EnumerationTypeInternal) type, attrValue );
                setAttributeValue( feature, value );
            } else if ( type instanceof MofClass ) {
                boolean isReference = ( feature instanceof Reference );
                List list = new ArrayList( );
                String[] idrefs = StringUtils.split( attrValue, ' ' );
                for ( int i = 0; i < idrefs.length; i++ ) {
                    String xmiId = idrefs[i];
                    Object obj = context.getReferencedObject( xmiId );
                    if ( obj == null ) {
                        // reference not known yet
                        if ( isReference ) {
                            obj = new UnresolvedReference( );
                        } else {
                            obj = new UnresolvedReference( this );
                        }
                        context.registerUnresolvedRef( xmiId, (UnresolvedReference) obj );
                    }
                    list.add( obj );
                }
                if ( isReference ) {
                    setReferenceValues( (ReferenceInternal) feature, list );
                } else {
                    setAttributeValues( feature, list );
                }
            } else {
                String typeName;
                if ( type == null ) {
                    typeName = "null"; //$NON-NLS-1$
                } else {
                    //FIXME HACK!!!
                    CoreConnection connection = context.getSession( ) != null ? context.getSession( ).getConnections( ).iterator( ).next( ) : null;
                    typeName = QualifiedName.toDotSeparatedString( type.getQualifiedName( connection ) );
                }
                throw new XmiParseException( XMI.MOIN_XMI_1041, new Object[] { attrName, typeName } );
            }
        } else {
            // TODO log occurence of unknown feature
        }
    }

    InstanceInfo getInfo( ) {

        return info;
    }

    // ReferencesCounter interface .........................................

    public void increaseUnresolvedRefs( ) {

        unresolvedRefsCounter++;
    }

    public void decreaseUnresolvedRefs( ) {

        unresolvedRefsCounter--;
        if ( endReached && ( unresolvedRefsCounter == 0 ) ) {
            instanceComplete( );
            // RefObject instance = createInstance();
            if ( unresolvedRef != null ) {
                unresolvedRef.referenceResolved( getInfo( ) );
            }
        }
    }
}
