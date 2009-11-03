package com.sap.tc.moin.repository.xmi;

import java.io.OutputStream;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * This interface enhances the standard {@link com.sap.tc.moin.repository.mmi.xmi.XmiWriter}
 * interface with methods for setting configuration options controlling the
 * serialization process.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmiWriter extends com.sap.tc.moin.repository.mmi.xmi.XmiWriter {

    /**
     * By default, the UTF-8 encoding is used. The encoding can be changed via
     * {@link #setEncoding(String)}.
     */
    public static final String DEFAULT_ENCODING = "UTF-8"; //$NON-NLS-1$

    /**
     * Writes the given collection of model elements to the OutputStream using
     * the specified XMI version. Note that this method serializes the complete
     * composition hierarchy of the model elements in the collection, as
     * required by the XMI specification. The OutputStream is left open after
     * completion.
     * 
     * @param os The OutputStream to use.
     * @param objects The collection of model elements to serialize.
     * @param xmiVersion A String containing the XMI version to use (e.g. "1.2"
     * or "2.0").
     * @throws IllegalArgumentException if the OutputStream or the collection
     * are 'null' or the collection contains objects of the wrong type.
     * @throws UnsupportedOperationException if an unsupported XMI version is
     * requested
     */
    public void write( OutputStream os, Collection objects, String xmiVersion ) throws java.io.IOException;

    /**
     * Writes a complete package extent to the given OutputStream using the
     * specified XMI version. The OutputStream is left open after completion.
     * <p>
     * A package extent contains the extents of all nested or clustered
     * packages, as well as all class extents and association extents contained
     * by all the aforementioned packages.
     * <p>
     * According to the XMI specification, the serialization of a package extent
     * is not unlike dumping an entire part of a database into an XMI document,
     * for example to replicate it into another environment. The resulting
     * document has to include all model elements, all links (including links of
     * associations for which no reference exists in the metamodel), and all
     * values of classifier-level attributes. This distinguishes it from the
     * serialization of a collection of model elements via
     * {@link #write(OutputStream, Collection, String)}, which does <em>not</em>
     * include classifier-level attributes and links not represented by
     * references.
     * 
     * @param os The OutputStream to use.
     * @param extent The package extent to serialize.
     * @param xmiVersion A String containing the XMI version to use (e.g. "1.2"
     * or "2.0").
     * @throws IllegalArgumentException if the OutputStream or the RefPackage
     * are 'null'
     * @throws UnsupportedOperationException if an unsupported XMI version is
     * requested
     */
    public void write( OutputStream os, RefPackage extent, String xmiVersion ) throws java.io.IOException;

    /**
     * This configuration option can be used for setting the encoding used
     * during the serialization process.
     * <p>
     * By default, {@link XmiWriter#DEFAULT_ENCODING} is used.
     * 
     * @param encoding the encoding to be used
     */
    public void setEncoding( String encoding );

    /**
     * Returns the encoding to be used during the serialization process.
     * 
     * @return the currently set encoding
     */
    public String getEncoding( );

    /**
     * This configuration option controls whether to add the optional
     * <code>timestamp</code> attribute to the <code>&lt;XMI&gt;</code> root
     * element. If set to <code>true</code>, the attribute will be filled with
     * the current date and time in milliseconds.
     * <p>
     * The default is <code>false</code>.
     * 
     * @param useTimestamp whether to add the timestamp attribute to the
     * <code>&lt;XMI&gt;</code> root element or not
     */
    public void setUseTimestamp( boolean useTimestamp );

    /**
     * Returns whether the optional <code>timestamp</code> attribute should be
     * added to the <code>&lt;XMI&gt;</code> root element.
     * 
     * @return whether the timestamp attribute should be added to the
     * <code>&lt;XMI&gt;</code> root element
     */
    public boolean getUseTimestamp( );

    /**
     * This configuration option controls whether to use the
     * <code>xmi.namespace</code> tags attached to the model packages or not. If
     * set to <code>true</code>, all existing <code>xmi.namespace</code> tags
     * will be used to prefix the model elements. If set to <code>false</code>,
     * the qualified names of the model elements will be used for the XMI
     * element names.
     * <p>
     * The default is <code>true</code>.
     * 
     * @param useNamespaces whether to evaluate <code>xmi.namespace</code> tags
     * attached to the model packages or not
     */
    public void setUseNamespaces( boolean useNamespaces );

    /**
     * Returns whether <code>org.omg.xmi.namespace</code> tags attached to the
     * model packages should be evaluated or not.
     * 
     * @return whether <code>org.omg.xmi.namespace</code> tags attached to the
     * model packages should be evaluated or not
     */
    public boolean getUseNamespaces( );

    /**
     * Registers an external reference provider, that is called back during
     * serialization of model elements and links.
     * <p>
     * The default implementation uses the model element's MOF-ID for the
     * XMI-ID, and a special MOIN internal <code>href</code> format.
     * 
     * @param provider the XmiReferenceProvider that should be used in
     * subsequent write operations
     */
    public void setReferenceProvider( XmiReferenceProvider provider );

    /**
     * Returns the currently registered {@link XmiReferenceProvider}.
     * 
     * @return the currently registered XmiReferenceProvider
     */
    public XmiReferenceProvider getReferenceProvider( );

    /**
     * This configuration option controls whether to indent the XMI document
     * with TAB characters or not. Note that while this option makes the
     * resulting file more readable, it will result in substantially bigger
     * files.
     * <p>
     * The default is <code>false</code>.
     * 
     * @param indent whether to use TAB character indentation or not
     */
    public void setUseIndentation( boolean indent );

    /**
     * Returns whether TAB based indentation should be used or not.
     * 
     * @return whether TAB based indentation should be used or not
     */
    public boolean getUseIndentation( );
}