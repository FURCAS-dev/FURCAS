package com.sap.tc.moin.repository.xm.serializer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.ModelElementHandle;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.parser.XmApiMessages;

/**
 * XM Serializer which serializes model elements to an output stream in XML
 * format. This abstract class provides helper methods for writing XML
 * constructs to the output stream and for accessing model elements.
 * <p>
 * This class is intended to be sub-classed by clients.
 */
public abstract class XmCustomSerializerAbstract implements XmCustomSerializer {

    private final Map<String, String> prefix2Namespace = new HashMap<String, String>( );

    private final Map<String, String> namespace2Prefix = new HashMap<String, String>( );

    private SerializerHelper helper;

    private boolean areNsPrefixesNotAdded = true;

    /**
     * Constructor.
     */
    public XmCustomSerializerAbstract( ) {

    }

    /**
     * Sets the helper object to an internal variable and forwards the call to
     * the method {@link #execute()}.
     * 
     * @param aHelper helper object, cannot be <code>null</code>
     * @throws XmException if the method {@link #execute()} throws such an
     * exception
     */
    public final void execute( final SerializerHelper aHelper ) throws XmException {

        this.areNsPrefixesNotAdded = true;
        this.helper = aHelper;
        this.execute( );
    }

    /**
     * Executes the serialization.
     * 
     * @throws XmException for error handling
     */
    protected abstract void execute( ) throws XmException;

    /**
     * Registers a prefix for a namespace. A unique prefix must be registered
     * for all namespaces which should occur in the namespace definition of the
     * root XML element .
     * 
     * @param namespace namespace; must not be null or the empty string
     * @param prefix unique prefix for the namespace
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if a parameter is the empty string, or
     * if already another namespace has been registered with the same prefix, or
     * if more than one prefix shall be registered for one namespace
     */
    protected final void registerPrefixForNamespace( final String namespace, final String prefix ) {

        if ( namespace == null ) {
            throw new MoinNullPointerException( "namespace" ); //$NON-NLS-1$
        }
        if ( prefix == null ) {
            throw new MoinNullPointerException( "prefix" ); //$NON-NLS-1$
        }
        if ( namespace.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( XmApiMessages.STRINGPARAMETEREMPTY, "namespace" ); //$NON-NLS-1$
        }
        if ( prefix.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( XmApiMessages.STRINGPARAMETEREMPTY, "prefix" ); //$NON-NLS-1$
        }

        final String alreadyRegisteredNs = this.prefix2Namespace.get( prefix );
        if ( alreadyRegisteredNs != null && !alreadyRegisteredNs.equals( namespace ) ) {
            throw new MoinIllegalArgumentException( XmApiMessages.PREFIXALREADYREGISTERED, new Object[] { prefix, alreadyRegisteredNs, namespace } );
        }
        final String alreadyRegisterdPrefix = this.namespace2Prefix.get( namespace );
        if ( alreadyRegisterdPrefix != null && !alreadyRegisterdPrefix.equals( prefix ) ) {
            throw new MoinIllegalArgumentException( XmApiMessages.SECONDFORNAMESPACE, new Object[] { namespace, alreadyRegisterdPrefix, prefix } );
        }
        this.namespace2Prefix.put( namespace, prefix );
        this.prefix2Namespace.put( prefix, namespace );
    }

    /**
     * Returns the prefix to namespace map which contains the entries which have
     * been registered via the method
     * {@link #registerPrefixForNamespace(String, String)}.
     * 
     * @return prefix to namespace map, cannot be <code>null</code>
     */
    protected final Map<String, String> getPrefixToNamesapceMap( ) {

        return this.prefix2Namespace;
    }

    /**
     * Returns the serializer helper.
     * 
     * @return serializer helper, or <code>null</code> if the method
     * {@link #execute(SerializerHelper)} has not been called before.
     */
    protected final SerializerHelper getHelper( ) {

        return this.helper;
    }

    /**
     * Adds a starting tag to the output stream.
     * <p>
     * Further, adds the namespace prefix definitions to the output stream. This
     * is only done for the first call of this method or of the method
     * {@link #addElement(String, SModelElementHandle, AttributeDescriptor)}.
     * Definitions for all prefixes which have been registered via the method
     * {@link #registerPrefixForNamespace(String, String)} are written to the
     * output stream.
     * 
     * @param tagName qualified name of an element, for example "ns1:customer",
     * "ns1" is the namespace prefix; this prefix must be registered via the
     * method {@link #registerPrefixForNamespace(String, String)}.
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    protected final void startTag( final String tagName ) {

        this.helper.getOutputHandler( ).startTag( tagName );
        if ( areNsPrefixesNotAdded ) {
            this.helper.addNamespacePrefixDeclarations( this.prefix2Namespace );
            this.areNsPrefixesNotAdded = false;
        }
    }

    /**
     * Closes the last open tag. For example if the tag "&lt;ns1:customer&gt;"
     * was started by the method {@link #startTag(String)} and not yet closed,
     * this method will add "&lt;/ns1:customer&gt;".
     * 
     * @throws IllegalStateException if there is not any open tag
     */
    protected final void closeTag( ) {

        this.helper.getOutputHandler( ).closeTag( );
    }

/**
     * Adds an XML element and its value to the output stream. The value is
     * determined from the attribute value of a MOIN model element. The
     * attribute value must be of primitive type.
     * <p>
     * The start tag, the value, and the end tag are written. For example
     * &lt;ns1:customer&gt;value&lt;/ns1:customer&gt;
     * <p>
     * Further, the namespace prefix definitions are added to the output stream.
     * This is only done for the first call of this method or of the method
     * {@link #startTag(String)}. All prefixes which have been registered via
     * the method {@link #registerPrefixForNamespace(String, String)} are
     * written to the output stream after the start tag.
     * <p>
     * If the MOIN attribute is multi-valued then an element is written to the
     * output stream for each value.
     * <p>
     * If the MOIN attribute value is <code>null</code>, then no XML element is
     * written to the output stream. In this case it is assumed, that the
     * element is optional.
     * <p>
     * An escaping is executed on the attribute value(s); see
     * {@link XmlOutputHandler}.
     * 
     * @param tagName qualified name of the XML element, for example
     * "ns1:customer", "ns1" is the namespace prefix; this prefix must be
     * registered via the method
     * {@link #registerPrefixForNamespace(String, String)}.
     * @param modelElement MOIN model element
     * @param attributeDescriptor descriptor of the MOIN attribute
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws ClassCastException if the attribute value(s) is not of primitive
     * type (object attribute, structure type attribute)
     * @throws IllegalArgumentException if <tt>modelElement</tt> has not been
     * retrieved by the methods
     * {@link SerializerHelper#getModelElement(ClassDescriptor, String...)} ,
     * {@link SerializerHelper#getModelElements(ClassDescriptor), or
     * @link SerializerHelper#getLinks(SModelElementHandle,
     * AssociationDescriptor, String)}
     * @throws IllegalArgumentException if the attribute descriptor denotes an
     * attribute which is not defined in the type of the model element
     */
    protected final void addElement( final String tagName, final SModelElementHandle modelElement, final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor ) {

        final Object value = modelElement.getAttribute( attributeDescriptor );
        if ( value == null ) {
            // do nothing
        } else if ( String.class == value.getClass( ) ) {
            this.addElement( tagName, value );
        } else {
            // multi-valued
            for ( final Object v : (Collection<?>) value ) {
                if ( v != null ) {
                    this.addElement( tagName, (String) v );
                }
            }
        }
    }

    /**
     * In contrast to {@link XmlOutputHandler#addElement(String, Object)}, this
     * method checks also if the namespace declaration has been already added.
     * If this is not the case the namespace declarations are added.
     * 
     * @param tagName tag name of the element
     * @param value value of the element
     */
    private void addElement( final String tagName, final Object value ) {

        this.startTag( tagName );
        this.helper.getOutputHandler( ).putValue( value );
        this.closeTag( );
    }

    /**
     * Adds an XML attribute to the output stream with a value which is
     * determined from a MOIN attribute.
     * <p>
     * If the MOIN attribute value is <code>null</code> then no XML attribute is
     * written to the output stream. In this case, it is assumed that the
     * attribute is optional.
     * <p>
     * Otherwise the toString method is called on the MOIN attribute value to
     * determine the XML attribute value and an escaping is executed on this
     * value (see {@link XmlOutputHandler}).
     * 
     * @param name qualified name of the XML attribute, for example
     * "ns1:customer"; "ns1" is the namespace prefix, this prefix must be
     * registered via the method
     * {@link XmCustomSerializerAbstract#registerPrefixForNamespace(String, String)}
     * .
     * @param modelElement MOIN model element
     * @param attributeDescriptor descriptor of the MOIN attribute
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalArgumentException if <tt>modelElement</tt> has not been
     * retrieved by the methods
     * {@link SerializerHelper#getModelElement(ClassDescriptor, String...)} ,
     * {@link SerializerHelper#getModelElements(ClassDescriptor)}, or
     * {@link SerializerHelper#getLinks(SModelElementHandle, AssociationDescriptor, String)}
     * @throws IllegalArgumentException if the attribute descriptor denotes an
     * attribute which is not defined in the type of the model element
     */
    protected final void addAttribute( final String name, final SModelElementHandle modelElement, final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor ) {

        final Object value = modelElement.getAttribute( attributeDescriptor );
        if ( value != null ) {
            this.helper.getOutputHandler( ).addAttribute( name, value );
        }
    }

    /**
     * Adds an element value which is determined from a MOIN attribute to the
     * current open element in the output-stream. If the element does already
     * have a value, the new value is concatenated to the old one.
     * <p>
     * The toString method is called on the value and an escaping is executed
     * (see {@link XmlOutputHandler}).
     * <p>
     * If the MOIN attribute value is <code>null</code> nothing is done.
     * 
     * @param modelElement MOIN model element
     * @param attributeDescriptor descriptor of the MOIN attribute
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalArgumentException if <tt>modelElement</tt> has not been
     * retrieved by the methods
     * {@link SerializerHelper#getModelElement(ClassDescriptor, String[])} ,
     * {@link SerializerHelper#getModelElement(ClassDescriptor)}, or
     * {@link SerializerHelper#getLinks(ModelElementHandle, AssociationDescriptor, String)}
     * @throws IllegalArgumentException if the attribute descriptor denotes an
     * attribute which is not defined in the type of the model element
     */
    protected final void putValue( final SModelElementHandle modelElement, final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor ) {

        final Object value = modelElement.getAttribute( attributeDescriptor );
        if ( value != null ) {
            this.helper.getOutputHandler( ).putValue( value );
        }
    }

    /**
     * Returns handles for all model elements of a MOF class contained in the
     * model partition which is serialized.
     * 
     * @param classDescriptor MOF class descriptor
     * @return model element handles, or an empty collection if there is not any
     * model element of the specified type contained in the model partition to
     * be serialized
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    protected final Collection<SModelElementHandle> getModelElements( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor ) {

        return this.helper.getModelElements( classDescriptor );
    }

    /**
     * Returns a handle for a model element of a certain type and with a certain
     * logical key which is contained in the model partition which is
     * serialized.
     * 
     * @param classDescriptor MOF class descriptor
     * @param logicalKey logical key specifying the model element
     * @return handle for the specified model element, or <code>null</code> if a
     * model element for the specified logical key does not exist in the model
     * partition to be serialized
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalStateException if the array <tt>logicalKey</tt> is empty
     */
    protected final SModelElementHandle getModelElement( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String... logicalKey ) {

        return this.helper.getModelElement( classDescriptor, logicalKey );
    }

    /**
     * Returns the model elements which are linked to a specified model element
     * via a certain association. Not only those instances are returned which
     * are in the partition to be serialized (inner-partition links) but also
     * those instances which are in other partitions (inter-partition links).
     * 
     * @param endInputModelElement handle for the input model element
     * @param associationDescriptor association descriptor
     * @param endOutputName name of the association end which contains the
     * returned model elements
     * @return collection of all the links, or an empty collection if there are
     * not any links for the specified model element and the specified
     * association
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if the end output name is not correct or
     * if the type of the input model element does not fit to the input end of
     * the association
     */
    protected final Collection<SModelElementHandle> getLinks( final SModelElementHandle endInputModelElement, final AssociationDescriptor<? extends RefAssociation> associationDescriptor, final String endOutputName ) {

        return this.helper.getLinks( endInputModelElement, associationDescriptor, endOutputName );
    }

}
