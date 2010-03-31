/*
 * Created on 23.12.2004
 */
package com.sap.tc.moin.repository.test.core;

import java.net.URI;
import java.net.URISyntaxException;

import com.sap.tc.moin.repository.spi.facility.SpiPersistence;

/**
 * The SAP Modeling Infrastructure repository uses regular {@link URI URIs} to
 * reference model partitions or individual model elements. This helper class
 * encapsulates the knowledge about how CBS and DTR references are encoded in
 * the URI scheme, and how Software Component-absolute references have the SCV
 * encoded in the URI.
 * <p>
 * TODO Think about whether/how to encode a facility into a URI for
 * cross-facility references
 * 
 * @author d043530
 */
public class URIHelper {

    private URIHelper( ) {

    }

    /**
     * Obtains an instance of the URIHelper class
     */
    public static URIHelper getURIHelper( ) {

        if ( theHelper == null )
            theHelper = new URIHelper( );
        return theHelper;
    }

    /**
     * Tells if this URI is absolute with regard to the software component
     * version containing the model element referenced. If this URI is relative,
     * it has to be interpreted in the context of a
     * {@link DevelopmentConfigurationImpl} telling which Software Component is
     * used in which version.
     */
    public boolean isSCVAbsolute( URI uri ) {

        // TODO implement
        return false;
    }

    /**
     * In case {@link #isSCVAbsolute}==true, this operation returns the
     * {@link SoftwareComponentVersion} to which this URI contains a reference.
     * In all other cases, this operation will return <tt>null</tt>.
     */
    /* TODO: to be moved to MRI
     public SoftwareComponentVersion getSCV(URI uri) {
     // TODO implement
     return null;
     }
     */

    /**
     * If the URI references a partition, that URI is returned unchanged. If it
     * references a model element ({@link URI#getFragment uri.getFragment} !=
     * null), a new URI with the element-specific part removed is returned,
     * pointing just to the model partition.
     * <p>
     * The result of this operation can be used, e.g., to ask a persistence
     * provider ({@link SpiPersistence}) to load the contents of the partition
     * referenced into a workspace.
     * <p>
     * Postconditions: <tt>this.isSCVAbsolute()==result.isSCVAbsolute()</tt>,
     * <tt>new URI(result, this.getFragment()).equals(this)</tt>
     * 
     * @throws URISyntaxException
     */
    public URI getPartitionURI( URI uri ) throws URISyntaxException {

        URI result = null;
        if ( uri.getPath( ) != null ) {
            result = new URI( uri.getScheme( ), uri.getAuthority( ), uri.getPath( ), uri.getQuery( ), /* fragment */null );
        } else {
            result = new URI( uri.getScheme( ), uri.getSchemeSpecificPart( ), null );
        }

        return result;
    }

    /**
     * Extracts the facility id from the {@link URI} passed.
     * 
     * @param uri The URI in which to look for a facility locator specification
     * @return the facility id that is identified by the URI
     */
    public String getFacilityId( URI uri ) {

        // TODO if we know how cross-facility URIs work, implement this here...
        return null;
    }

    /**
     * If this URI is not SCV-absolute ({@link #isSCVAbsolute}==false), it is
     * returned unchanged. Otherwise, a new URI with the SCV-reference removed
     * is created and returned. For the returned URI, {@link #isSCVAbsolute} ==
     * false is guaranteed.
     * <p>
     * This operation is required when setting the URI of a model partition that
     * was loaded based on an SCV-absolute URI. A ModelPartition only knows its
     * relative URI. Versioning information will be stored separately from the
     * URI on the partition if required.
     */
    public URI getSCVRelativeURI( URI uri ) {

        // TODO implement
        return uri;
    }

    /**
     * If the URI points to a model element (and not an entire partition), then
     * the MOF ID of the model element is extracted from the URI and returned.
     * Otherwise, <tt>null</tt> is returned.
     */
    public String getMofId( URI uri ) {

        String result = uri.getFragment( );
        return result;
    }

    // ------------------------ attributes -------------------------
    /**
     * The schema name for URIs pointing to resources from DTR.
     */
    public static final String SCHEMA_DTR = "dtr";

    /**
     * The schema name for URIs pointing to resources from CBS.
     */
    public static final String SCHEMA_CBS = "cbs";

    /**
     * The helper returned by {@link #getURIHelper()}.
     */
    private static URIHelper theHelper;
}