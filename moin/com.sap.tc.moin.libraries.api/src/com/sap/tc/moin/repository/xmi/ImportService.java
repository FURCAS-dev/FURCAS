package com.sap.tc.moin.repository.xmi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;

/**
 * The {@link ImportService} interface is used by the
 * {@link com.sap.tc.moin.repository.xmi.XmiReader} in <em>import mode</em> to
 * query all information needed for a successful (either initial or incremental)
 * import. This for example includes resolving a URI to an InputStream, or the
 * mapping of XMI documents to {@link com.sap.tc.moin.repository.ModelPartition
 * model partitions}.
 * <p>
 * When XMI documents are being imported (as opposed to the loading of model
 * partitions already stored in the repository) using one of
 * {@link com.sap.tc.moin.repository.xmi.XmiReader XmiReader's}
 * <code>read</code> methods, by default no partition mapping is performed. This
 * means that all imported model elements are assigned to the current
 * {@link com.sap.tc.moin.repository.Connection connection}'s so-called
 * <em>no-partition</em>, which is never persisted. Then, after the import, the
 * caller is able to change the partition assignment by himself, and persist the
 * resulting partitions.
 * <p>
 * This approach seems appropriate for "one-shot" imports. However, if the same
 * set of XMI documents needs to be imported over and over again after some
 * changes have been made, the need for an incremental import arises. The most
 * prominent use case is the use of some third-party modeling tool, which is
 * used to create and maintain MOF metamodels, and which offers an XMI export
 * interface. Then, from time to time, the current version of the metamodel
 * should be imported into the MOIN repository. In order not to break existing
 * M1-level models, on the one hand the metamodel changes should of course be
 * compatible, but on the other hand the XmiReader needs to follow an overwrite
 * strategy that keeps the existing MOF-IDs of the metamodel elements stable.
 * <p>
 * Note that the incremental import is not restricted to metamodels, though.
 * However, the use case "maintain and incrementally import an M1-level model"
 * is anticipated to occur much less frequently than the metamodel use case.
 * <p>
 * In order to perform incremental imports, some strict rules have to be obeyed
 * by the modeler:
 * <ul>
 * <li>There has to be a stable 1:1 mapping of XMI documents to model
 * partitions. As soon as the initial import has been performed, the specified
 * partition mapping must not be changed any more if future incremental imports
 * are anticipated. The decision not to enable the importer to make use of the
 * full partitioning flexibility greatly reduces the complexity of the import,
 * while not being considered to be a too strong restriction.</li>
 * <li>The partition contents must not be changed manually after the import, for
 * example by federating or splitting partitions, or by adding new model
 * elements. Following the single-source paradigm, in the incremental import
 * scenario the external modeling tool is considered to be the master system
 * where all changes are made. Thus, any subsequent change by a different tool
 * will inevitably be overwritten during the next import.</li>
 * </ul>
 * If these rules are obeyed and an incremental import needs to be performed,
 * the caller is expected to register an instance of {@link ImportService} via
 * {@link com.sap.tc.moin.repository.xmi.XmiReader#setImportService(ImportService)}
 * , before calling one of the importing <code>read</code> methods defined in
 * the {@link com.sap.tc.moin.repository.xmi.XmiReader} interface. In his
 * implementation he has to specify:
 * <ul>
 * <li>how to obtain an InputStream from a given URI, and how relative URIs
 * resolve against the URI of the main XMI document (see
 * {@link #createInputStream(String)} and {@link #resolveUri(String, String)})</li>
 * <li>which XMI document maps to which model partition ("first-level mapping",
 * see {@link #getMappedPartition(String)})</li>
 * <li>inside each XMI document, which XMI element maps to which model element
 * in the mapped model partition ("second-level mapping", see
 * {@link #getMappingId(String, XmiElement)} and
 * {@link #getMappingId(RefObject)})</li>
 * <li>how to obtain an InputStream and OutputStream for a mapping table, in
 * case a direct mapping between XMI elements and model elements is not possible
 * (see {@link #createOutputStreamForMappingTable(String)} and
 * {@link #createInputStreamForMappingTable(String)})</li>
 * <li>for each XMI document, whether it acts as "active" or "passive" during
 * the import (see {@link #isSource(String)})</li>
 * </ul>
 * <p>
 * <b>Element mapping strategies</b>
 * <p>
 * Note that the MOF-ID usually cannot be used for the key, because XMI
 * documents exported by external tools usually do not contain MOF-IDs at all,
 * or compute their own universally unique identifier. Thus, usually a different
 * criterion is required for comparison.
 * <p>
 * For example, the MOF meta-metamodel has a concept of "qualified names". An
 * {@link ImportService} implementation for incrementally importing a MOF
 * metamodel could therefore compute and return the qualified name for both a
 * model element and an XMI element, and the mapping is complete.
 * <p>
 * If a <em>direct</em> mapping from XMI element to model element is not
 * possible (like in the above mentioned qualified name case), there is still
 * the possibility to persist a mapping table, and to provide this mapping table
 * to the XmiReader on each incremental import. If you for example know that the
 * external modeling tool provides stable XMI-IDs, you could map an XMI
 * element's XMI-ID to the MOF-ID of the corresponding model element in the
 * mapped model partition, and persist this mapping using
 * {@link #createOutputStreamForMappingTable(String)} and
 * {@link #createInputStreamForMappingTable(String)}.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface ImportService {

    /**
     * Creates and returns an InputStream for the given URI. Note that the
     * stream <b>must</b> be provided, i.e. returning <code>null</code> will
     * result in the immediate failure of the XmiReader. The XmiReader will
     * close the stream after processing.
     * 
     * @param uriOfXmiDocument The URI denoting the location of the requested
     * XMI document.
     * @return an InputStream for the given URI
     * @throws IOException if there is an I/O error
     */
    public InputStream createInputStream( String uriOfXmiDocument ) throws IOException;

    /**
     * Resolves the <code>uriToResolve</code> against the <code>baseUri</code>
     * and returns the String representation of the resulting URI.
     * <p>
     * <b>Example: </b> <code>baseUri="file:/C:/someDir/MyMetamodel.xml"</code>,
     * and during parsing a <code>href</code> attribute pointing to
     * <code>"MyPackage.xml"</code> is encountered (= <code>uriToResolve</code>
     * ). If the corresponding file is stored in the same folder, the correct
     * return value of this method would be
     * <code>"file:/C:/someDir/MyPackage.xml"</code>.
     * 
     * @param uriToResolve the relative URI to be resolved against the base URI
     * @param baseUri the URI to resolve against
     * @return the String representation of the resulting URI
     */
    public String resolveUri( String uriToResolve, String baseUri );

    /**
     * Creates and returns an OutputStream where the XmiReader can store the
     * mapping from XMI elements to model elements for the given XMI document.
     * Note that the IDs stored in that file are determined by calls to
     * {@link #getMappingId(String, XmiElement)} and
     * {@link #getMappingId(RefObject)}.
     * <p>
     * The storage of a mapping table is optional. If no mapping table is
     * required, return <code>null</code>.
     * 
     * @param uriOfXmiDocument the URI of the XMI document
     * @return the created OutputStream, or <code>null</code> if no mapping
     * table is required
     */
    public OutputStream createOutputStreamForMappingTable( String uriOfXmiDocument );

    /**
     * Creates and returns an InputStream from where the XmiReader can load the
     * mapping from XMI elements to model elements for the given XMI document.
     * Note that the IDs stored in that file have been determined by calls to
     * {@link #getMappingId(String, XmiElement)} and
     * {@link #getMappingId(RefObject)}.
     * <p>
     * The storage of a mapping table is optional. If no mapping table is
     * required, return <code>null</code>.
     * 
     * @param uriOfXmiDocument the URI of the XMI document
     * @return the created InputStream, or <code>null</code> if no mapping table
     * is required
     */
    public InputStream createInputStreamForMappingTable( String uriOfXmiDocument );

    /**
     * If the XMI document with the given URI is currently being imported, this
     * method is called back by the {@link XmiReader} to determine to which
     * model partition (represented by its {@link PRI}) the document should be
     * mapped. Depending on the return value of {@link #isSource(String)}, the
     * mapped model partition will either be created, loaded, or merged with the
     * content of the XMI document during the import.
     * 
     * @param uriOfXmiDocument the URI of the XMI document
     * @return the PRI to which the XMI document should be mapped
     */
    public PRI getMappedPartition( String uriOfXmiDocument );

    /**
     * In this method, the implementor has to return whether the
     * {@link XmiReader} should consider the XMI document with the given URI as
     * being "active" in a sense that the contained model elements should be
     * created or merged, or as "passive". This method is important in the case
     * of metamodel re-use: XMI documents should only be marked as
     * <code>isSource=true</code> by the owner of the corresponding metamodel,
     * while all re-used XMI documents should be marked as
     * <code>isSource=false</code>.
     * <p>
     * If <code>true</code> is returned, the {@link XmiReader} will create the
     * corresponding model partition if it does not exist yet, or merge the
     * contents of the XMI document and the model partition if it already
     * exists. On the other hand, if <code>false</code> is returned, the
     * corresponding model partition as defined in
     * {@link #getMappedPartition(String)} will be loaded but never modified.
     * 
     * @param uriOfXmiDocument the URI of the XMI document
     * @return whether the specified XMI document should be treated as "active"
     * or "passive"
     */
    public boolean isSource( String uriOfXmiDocument );

    /**
     * Returns a String uniquely identifying the given XMI element within the
     * given XMI document. This ID should be <b>stable</b> across changes of the
     * XMI document.
     * <p>
     * Concrete implementations that perform a partition mapping could for
     * example return <code>xmiElement.getXmiId()</code> if the document
     * contains stable XMI-IDs for each model element.
     * <p>
     * If the XMI document contains a MOF metamodel, the qualified name could be
     * used, which can be easily be computed by successive calls to
     * {@link XmiElement#getParentElement()}.
     * 
     * @param uriOfXmiDocument the URI of the XMI document
     * @param xmiElement the XmiElement for which a stable ID is requested
     * @return the stable ID
     */
    public String getMappingId( String uriOfXmiDocument, XmiElement xmiElement );

    /**
     * Returns a String uniquely identifying the given model element within its
     * model partition.
     * <p>
     * If the model partition contains a MOF metamodel, the qualified name could
     * be used. Another alternative could be the MOF-ID.
     * 
     * @param modelElement the model element for which a stable ID is requested
     * @return the stable ID
     */
    public String getMappingId( RefObject modelElement );
}