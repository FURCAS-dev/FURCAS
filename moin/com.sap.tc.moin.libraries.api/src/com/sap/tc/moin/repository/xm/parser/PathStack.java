package com.sap.tc.moin.repository.xm.parser;


/**
 * Stack of XML elements/attribute which build the path to the current parsed
 * XML element/attribute.
 * <p>
 * There exists exactly one instance per XM Parser instance.
 * <p>
 * You can store additional information which is related to a certain XML
 * element in the stack; you can assign and access string properties and model
 * element handles ({@link PModelElementHandle}) to a stack entry with a certain
 * depth. So, you can store information which you need later on during the
 * parsing.
 * 
 * @noimplement This class is not intended to be implemented by clients.
 */
public abstract class PathStack {

    /**
     * Constructor. Only the MOIN framework is allowed creating instances.
     */
    protected PathStack( ) {

    }

    /**
     * Pushes an XML element/attribute with a certain local name and normalized
     * prefix to the stack.
     * 
     * @param localName local name of the XML element/attribute
     * @param prefix namespace prefix of the XML element/attribute, the prefix
     * must be registered by the method
     * {@link XmParserHandlerAbstract#registerPrefixForNamespace(String, String)}
     * (except if the namespace is the no-namespace, then an empty string must
     * be given)
     * @param aNodeType node type
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    protected abstract void push( final String localName, final String prefix, final NodeType aNodeType );


    /**
     * Pops the last added XML element/attribute from the stack. It is assumed
     * that then the node type is {@link NodeType#Element}.
     */
    protected abstract void pop( );

    /**
     * Assigns to the top stack entry a complex type handler.
     * 
     * @param handler complex type handler
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    protected abstract void putHandler( ComplexTypeHandler handler );

    /**
     * Returns the complex type handler of the top stack entry.
     * 
     * @return complex type handler or <code>null</code>, if no handler is
     * assigned to the top stack entry
     */
    protected abstract ComplexTypeHandler getHandler( );

    /**
     * Returns the complex type handler of the stack entry with a given depth
     * level.
     * 
     * @param depth depth level of the stack
     * @return complex type handler or <code>null</code>, if no handler was
     * assigned for the stack entry with the specified depth
     */
    protected abstract ComplexTypeHandler getHandler( int depth );

    /**
     * Returns the local name of the the current parsed XML element/attribute.
     * This is the local name of the XML element/attribute in the top stack
     * entry.
     * 
     * @return local name
     */
    public abstract String getCurrentLocalName( );

    /**
     * Returns the namespace prefix of the current parsed XML element/attribute.
     * This is the prefix of the XML element/attribute in the top stack entry.
     * If the XML element/attribute has the no-namespace, then an empty string
     * is returned.
     * <p>
     * The prefix is returend which is registered for the corresponding
     * namespace by
     * {@link XmParserHandlerAbstract#registerPrefixForNamespace(String, String)}.
     * 
     * @return namespace prefix
     */
    public abstract String getCurrentPrefix( );


    /**
     * Returns the index of the current parsed XML element/attribute. This is
     * the index of the XML element/attribute in the top stack entry.
     * <p>
     * An index different from 0 can occur if a parent XML element has XML child
     * elements with the same name and namespace. For example the second child
     * element with the same name and namespace gets the index 1, the third
     * child element with ths same name and namespace the index 2, ...
     * 
     * @return index, starts from 0
     */
    public abstract int getCurrentIndex( );


    /**
     * Returns the size of the stack.
     * 
     * @return size
     */
    public abstract int size( );


    /**
     * Returns the local name of the XML element/attribute contained in a
     * certain depth of the stack.
     * 
     * @param depth stack depth, starts from 1
     * @return local name, cannot be <code>null</code>
     * @throws IndexOutOfBoundsException if <tt>depth</tt> < 1 or <tt>depth</tt>
     * > {@link #size()}
     */
    public abstract String getLocalName( int depth );

    /**
     * Returns the namespace prefix of the XML element/attribute contained in a
     * certain depth of the stack. If the XML element/attribute has the
     * no-namespace, then an empty string is returned.
     * <p>
     * The prefix is returned which is registered for the corresponding
     * namespace by
     * {@link XmParserHandlerAbstract#registerPrefixForNamespace(String, String)}.
     * 
     * @param depth stack depth, starts from 1
     * @return namespace prefix, cannot be <code>null</code>
     * @throws IndexOutOfBoundsException if <tt>depth</tt> <1 or <tt>depth</tt>
     * > {@link #size()}
     */
    public abstract String getPrefix( int depth );

    /**
     * Returns the index of the XML element/attribute contained in a certain
     * depth of the stack.
     * 
     * @param depth stack depth, starts from 1
     * @return index indicating the so far detected occurence of the XML
     * element/attribute with a certain path, starting from 0 (see
     * {@link #getCurrentIndex()}
     * @throws IndexOutOfBoundsException if <tt>depth</tt> <1 or <tt>depth</tt>
     * > {@link #size()}
     */
    public abstract int getIndex( int depth );


    /**
     * Returns the type of the XML element/attribute contained in the top stack
     * entry.
     * 
     * @return node type, cannot be <code>null</code>
     */
    public abstract NodeType getNodeType( );

    /**
     * Returns a unique path for the current parsed XML element/attribute. The
     * resulting string is composed by the prefixes, the XML element/attribute
     * local names, and the indexes of the XML elements (if the index is greater
     * than 0) contained in the stack. Different depth levels are separated by
     * '/'. Attribute local names get the prefix "@". The top stack entry local
     * name is added at the end.
     * <p>
     * Example: "customers/customer[1]/@name"
     * 
     * @return unique path
     */
    public abstract String getUniquePath( );

    /**
     * Adds a model element handle with a certain key to the stack entry with a
     * certain depth level. If the entry does already contain a model element
     * handle with the same key, then the handle is overwritten with the new
     * value.
     * 
     * @param depth stack depth, starts from 1
     * @param key key for the model element handle
     * @param value model element handle instance
     * @throws NullPointerException if <tt>key</tt> or <tt>value</tt> is
     * <code>null</code>
     * @throws IndexOutOfBoundsException if <tt>depth</tt> <1 or <tt>depth</tt>
     * > {@link #size()}
     */
    public abstract void putModelElement( int depth, String key, PModelElementHandle value );

    /**
     * Returns the model element handle with a certain key which is contained in
     * a stack entry with a certain depth.
     * 
     * @param depth stack depth, starts from 1
     * @param key key for the model element handle
     * @param model element handle or <code>null</code> if a value for the given
     * key could not be found in the given depth
     * @throws NullPointerException if <tt>key</tt> is <code>null</code>
     * @throws IndexOutOfBoundsException if <tt>currentDepth</tt> <1 or
     * <tt>depth</tt> > {@link #size()}
     */
    public abstract PModelElementHandle getModelElement( int depth, String key );

    /**
     * Adds a model element handle with a certain key to the top stack entry. If
     * the entry does already contain a model element handle with the same key,
     * then the model element handle is overwritten with the new value.
     * 
     * @param key key for the model element handle
     * @param value model element handle
     * @throws NullPointerException if <tt>key</tt> or <tt>value</tt> is
     * <code>null</code>
     * @throws IndexOutOfBoundsException if {@link #size()} == 0
     */
    public abstract void putModelElement( String key, PModelElementHandle value );

    /**
     * Returns the model element handle with a certain key which is contained in
     * the top stack entry.
     * 
     * @param key key for the model element handle
     * @param model element handle or <code>null</code> if a model element
     * handle could not be found for the given key
     * @throws NullPointerException if <tt>key</tt> is <code>null</code>
     * @throws IndexOutOfBoundsException if {@link #size()} == 0
     */
    public abstract PModelElementHandle getModelElement( String key );

    /**
     * Adds a string property with a certain key to the stack entry with a
     * certain depth level. If the entry does already contain a property with
     * the same key, then the property value is overwritten.
     * 
     * @param depth stack depth, starts from 1
     * @param key key of the property
     * @param value value of the property
     * @throws NullPointerException if <tt>key</tt> or <tt>value</tt> is
     * <code>null</code>
     * @throws IndexOutOfBoundsException if <tt>depth</tt> <1 or <tt>depth</tt>
     * > {@link #size()}
     */
    public abstract void putProperty( int depth, String key, String value );

    /**
     * Returns the string property value with a certain key which is contained
     * in a stack entry with a certain depth.
     * 
     * @param depth stack depth, starts from 1
     * @param key key of the property
     * @param property value or <code>null</code> if the property could not be
     * found for the given key in the given depth
     * @throws NullPointerException if <tt>key</tt> is <code>null</code>
     * @throws IndexOutOfBoundsException if <tt>depth</tt> <1 or <tt>depth</tt>
     * > {@link #size()}
     */
    public abstract String getProperty( int depth, String key );


    /**
     * Adds a string property with a certain key to the top stack entry. If the
     * entry does already contain a property with the same key, then the
     * property value is overwritten.
     * <p>
     * The the stack entry is popped then the property can no longer be
     * accessed.
     * 
     * @param key key of the property
     * @param value value of the property
     * @throws NullPointerException if <tt>key</tt> or <tt>value</tt> is
     * <code>null</code>
     * @throws IndexOutOfBoundsException if {@link #size()} == 0
     */
    public abstract void putProperty( String key, String value );

    /**
     * Returns the string property value with a certain key which is contained
     * in the top stack entry.
     * 
     * @param key key of the property
     * @param property value or <code>null</code> if the property could not be
     * found for the given key
     * @throws NullPointerException if <tt>key</tt> is <code>null</code>
     * @throws IndexOutOfBoundsException if {@link #size()} == 0
     */
    public abstract String getProperty( String key );
}
