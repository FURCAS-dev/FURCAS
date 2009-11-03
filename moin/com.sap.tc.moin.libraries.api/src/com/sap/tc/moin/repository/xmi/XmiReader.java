package com.sap.tc.moin.repository.xmi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException;

/**
 * This interface is an extension of the {@link com.sap.tc.moin.repository.mmi.xmi.XmiReader}
 * interface as defined in the JMI 1.0 specification. In addition to the two
 * <code>read</code> methods defined in that standard interface, it offers a
 * second set of <code>read</code> methods taking an array of package extents as
 * input parameter, as well as methods for setting configuration options
 * affecting the deserialization process.
 * <p>
 * Note that in all the <code>read</code> methods in this interface, an error
 * during the repository update leads to a
 * {@link com.sap.tc.moin.repository.Connection#revert()} on the connection.
 * Therefore, to prevent loss of unsaved changes, it is strongly recommended to
 * use a new, exclusive connection for a call to these methods.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmiReader extends com.sap.tc.moin.repository.mmi.xmi.XmiReader {

    /**
     * Reads an XMI document from the location given by the URI String, using
     * the specified package extent for metamodel lookups.
     * <p>
     * For obtaining the InputStream, the XmiReader will pass the URI to the
     * currently registered {@link com.sap.tc.moin.repository.xmi.ImportService}
     * via
     * {@link com.sap.tc.moin.repository.xmi.ImportService#createInputStream(String)}
     * . An IOException will be thrown if no InputStream could be obtained.
     * <p>
     * The package extent passed in the <code>extent</code> parameter is used
     * for metamodel lookups during the deserialization, and therefore has to
     * contain all metamodels required for reading the given XMI document(s).
     * Any model element found in the XMI document(s) whose metamodel is not
     * available in this package extent will cause the XmiReader to fail.
     * <p>
     * Note that in the case of an error during the repository update, a
     * {@link com.sap.tc.moin.repository.Connection#revert()} on the connection
     * is performed. Therefore, to prevent loss of unsaved changes, it is
     * strongly recommended to use a new, exclusive connection for a call to
     * this method.
     * 
     * @param uriOfXmiDocument The String representation of the URI where the
     * XMI document is located.
     * @param extent The package extent used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     * @return XMI requires complete composition hierarchies to be stored in one
     * document, from the root element down to all leaves. What is returned by a
     * call to this method is the collection of all such composition roots (i.e.
     * <em>not</em> the collection of <em>all</em> model elements).
     */
    public Collection read( String uriOfXmiDocument, RefPackage extent ) throws IOException, MalformedXMIException;

    /**
     * Reads an XMI document from the location given by the URI String, using
     * the specified array of package extents for metamodel lookups.
     * <p>
     * For obtaining the InputStream, the XmiReader will pass the URI to the
     * currently registered {@link com.sap.tc.moin.repository.xmi.ImportService}
     * via
     * {@link com.sap.tc.moin.repository.xmi.ImportService#createInputStream(String)}
     * . An IOException will be thrown if no InputStream could be obtained.
     * <p>
     * The package extents passed in the <code>extents</code> parameter are used
     * for metamodel lookups during the deserialization, and therefore have to
     * contain all metamodels required for reading the given XMI document(s).
     * Any model element found in the XMI document(s) whose metamodel is not
     * available in one of these package extents will cause the XmiReader to
     * fail.
     * <p>
     * Note that in the case of an error during the repository update, a
     * {@link com.sap.tc.moin.repository.Connection#revert()} on the connection
     * is performed. Therefore, to prevent loss of unsaved changes, it is
     * strongly recommended to use a new, exclusive connection for a call to
     * this method.
     * 
     * @param uriOfXmiDocument The String representation of the URI where the
     * XMI document is located.
     * @param extents The array of package extents used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     * @return XMI requires complete composition hierarchies to be stored in one
     * document, from the root element down to all leaves. What is returned by a
     * call to this method is the collection of all such composition roots (i.e.
     * <em>not</em> the collection of <em>all</em> model elements).
     */
    public Collection read( String uriOfXmiDocument, RefPackage[] extents ) throws IOException, MalformedXMIException;

    /**
     * Reads an XMI document from the given InputStream, using the specified
     * package extent for metamodel lookups.
     * <p>
     * The <code>uriOfXmiDocument</code> parameter has to contain the URI of the
     * XMI document behind the InputStream, and is used for resolving relative
     * links to other XMI documents that might be found during parsing.
     * <p>
     * The package extent passed in the <code>extent</code> parameter is used
     * for metamodel lookups during the deserialization, and therefore has to
     * contain all metamodels required for reading the given XMI document(s).
     * Any model element found in the XMI document(s) whose metamodel is not
     * available in this package extent will cause the XmiReader to fail.
     * <p>
     * Note that in the case of an error during the repository update, a
     * {@link com.sap.tc.moin.repository.Connection#revert()} on the connection
     * is performed. Therefore, to prevent loss of unsaved changes, it is
     * strongly recommended to use a new, exclusive connection for a call to
     * this method.
     * 
     * @param stream The InputStream from which the XMI document is read.
     * @param uriOfXmiDocument The String representation of the URI behind the
     * InputStream.
     * @param extent The package extent used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     * @return XMI requires complete composition hierarchies to be stored in one
     * document, from the root element down to all leaves. What is returned by a
     * call to this method is the collection of all such composition roots (i.e.
     * <em>not</em> the collection of <em>all</em> model elements).
     */
    public Collection read( InputStream stream, String uriOfXmiDocument, RefPackage extent ) throws IOException, MalformedXMIException;

    /**
     * Reads an XMI document from the given InputStream, using the specified
     * array of package extents for metamodel lookups.
     * <p>
     * The <code>uriOfXmiDocument</code> parameter has to contain the URI of the
     * XMI document behind the InputStream, and is used for resolving relative
     * links to other XMI documents that might be found during parsing.
     * <p>
     * The package extents passed in the <code>extents</code> parameter are used
     * for metamodel lookups during the deserialization, and therefore have to
     * contain all metamodels required for reading the given XMI document(s).
     * Any model element found in the XMI document(s) whose metamodel is not
     * available in one of these package extents will cause the XmiReader to
     * fail.
     * <p>
     * Note that in the case of an error during the repository update, a
     * {@link com.sap.tc.moin.repository.Connection#revert()} on the connection
     * is performed. Therefore, to prevent loss of unsaved changes, it is
     * strongly recommended to use a new, exclusive connection for a call to
     * this method.
     * 
     * @param stream The InputStream from which the XMI document is read.
     * @param uriOfXmiDocument The String representation of the URI behind the
     * InputStream.
     * @param extents The array of package extents used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     * @return XMI requires complete composition hierarchies to be stored in one
     * document, from the root element down to all leaves. What is returned by a
     * call to this method is the collection of all such composition roots (i.e.
     * <em>not</em> the collection of <em>all</em> model elements).
     */
    public Collection read( InputStream stream, String uriOfXmiDocument, RefPackage[] extents ) throws IOException, MalformedXMIException;

    /**
     * This configuration option allows to set an {@link ImportService}, which
     * is used by the {@link XmiReader} during a read operation to query all
     * relevant information about the import.
     * <p>
     * If not explicitly set, a default implementation will be used (see
     * {@link DefaultImportService} for details on its behaviour).
     * 
     * @param importService the ImportService to be used for subsequent imports
     */
    public void setImportService( ImportService importService );

    /**
     * Returns the currently registered {@link ImportService}.
     * 
     * @return the currently registered ImportService
     */
    public ImportService getImportService( );
}