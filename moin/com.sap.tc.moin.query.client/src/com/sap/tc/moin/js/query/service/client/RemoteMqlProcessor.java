package com.sap.tc.moin.js.query.service.client;

import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLResultSet;


/**
 * Client API for submitting remote MQL queries to the MOIN Team Server. Closely
 * resembles {@link com.sap.tc.moin.repository.mql.MQLProcessor} with some
 * peculiar differences:
 * <ul>
 * <li>It is not possible to use
 * {@link com.sap.tc.moin.repository.mql.QueryScopeProvider}s. Instead, you have
 * to provide lists of {@link com.sap.tc.moin.repository.PRI}s,
 * {@link com.sap.tc.moin.repository.CRI}s,
 * {@link com.sap.tc.moin.repository.DataArea}s, as obtained previously from the
 * same server, plus an operation how to combine them.</li>
 * <li>Resource Identifiers (MRI, CRI, PRI, LRI, DataAreaDescriptor) return by
 * this interface are <i>only valid on the server</i>, which created them. You
 * cannot directly resolve them in your local MOIN (in Eclipse). A special
 * mapping utility class will be provided for this purpose.
 * <li>It is (currently) not possible to prepare and execute
 * {@link com.sap.tc.moin.repository.mql.MQLPreparedQuery}s.</li>
 * </ul>
 * 
 * @author D044522
 * @see com.sap.tc.moin.repository.mql.MQLProcessor
 */
public interface RemoteMqlProcessor {

    /**
     * Special value to be used for instructing the Query Service to return any
     * number of results that matches a query.
     */
    public static final int RESULTS_UNLIMITED = -1;

    /**
     * Indicates a scopeOperation to
     * {@link #execute(String, PRI[], CRI[], int, int)}. For empty CRI[] and
     * PRI[] it behaves like a global scope including the whole
     * CompoundDataArea. Otherwise the complement (everything excluding those
     * CRI[]/PRI[]) will be considered.
     */
    public static final int SCOPE_GLOBAL = 0;

    /**
     * Indicates a scopeOperation to
     * {@link #execute(String, PRI[], CRI[], int, int)}. The scope is defined by
     * the provided CRI[] plus all the partitions which are visible for the
     * provided container.
     */
    public static final int SCOPE_INCLUSIVE_VISIBLE = 1;

    /**
     * Indicates a scopeOperation to
     * {@link #execute(String, PRI[], CRI[], int, int)}. The scope is defined by
     * the union of provided CRI[]/PRI[] arguments.
     */
    public static final int SCOPE_INCLUSIVE = 2;

    /**
     * Gets available Facilities as entry point for exploring a MOIN Team
     * Server.
     * 
     * @return <tt>facilityId</tt>s of the available Facilities for later use by
     * {@link #getDataAreas(String)}.
     */
    List<String> getFacilities( );

    /**
     * Gets all DataAreas known in a MOIN Facility on the Team Server.
     * 
     * @param facilityId the queried Facility's ID as in
     * {@link com.sap.tc.moin.repository.Facility#getId()}. May be null; The
     * server's primary facility will be used instead.
     * @return descriptors of all available data areas in this Facility.
     * @throws InvalidResourceIdentifierException if the facilityId is not known
     * on the server.
     * @see com.sap.tc.moin.repository.DataArea
     */
    List<DataAreaDescriptor> getDataAreas( String facilityId ) throws InvalidResourceIdentifierException;

    /**
     * Executes an MQL Query on the configured MOIN Team Server. Note that all
     * scope information has to refer to scopes valid on the server (not the
     * client)!
     * 
     * @param pris a list of partitions. May be null.
     * @param cris a list of containers. May be null.
     * @param das DataAreas (i.e., Development Configurations in the case of
     * NWDI) to scope the query. Currently, only one DataArea is supported. If
     * <tt>null</tt>, the server's default DataArea is used (for testing
     * purposes only!).
     * @param scopeOperation one of {@link #SCOPE_GLOBAL},
     * {@link #SCOPE_INCLUSIVE}, or {@link #SCOPE_INCLUSIVE_VISIBLE}.
     * @param numberOfResults maximum number of expected results or
     * {@link #RESULTS_UNLIMITED} for all matching results, regardless of their
     * number.
     * @return regular result set as known from
     * {@link com.sap.tc.moin.repository.mql.MQLProcessor}.
     * @throws MQLExecutionException if something went wrong during query
     * execution.
     * @throws MQLFormatException if the query's format is invalid (i.e., cannot
     * be parsed correctly).
     */
    MQLResultSet execute( String query, PRI[] pris, CRI[] cris, DataAreaDescriptor[] das, int scopeOperation, int numberOfResults ) throws MQLExecutionException, MQLFormatException;

    /**
     * Obtains a facility-specific property bag for a given DataArea. This
     * information is necessary to contact the right repository, e.g., for NWDI,
     * this would yield DevConfig etc.
     * 
     * @param dataArea descriptor of the required DataArea
     * @return facility-specific key-value pairs necessary to contact the right
     * repository. See {@link QsResourceIdentifierConstants} for valid keys.
     * @throws InvalidResourceIdentifierException
     */
    Map<String, String> getDataAreaConfig( DataAreaDescriptor dataArea ) throws InvalidResourceIdentifierException;

    /**
     * Determines a MOIN DataArea according to facility-specific properties in a
     * generic form.
     * 
     * @param dataAreaConfig a facility-specific property bag for a given
     * DataArea, containing e.g., DevConfig names for NWDI. See
     * {@link QsResourceIdentifierConstants} for valid keys.
     * @return dataArea descriptor of the required DataArea
     * @throws InvalidResourceIdentifierException
     */
    DataAreaDescriptor getDataArea( Map<String, String> dataAreaConfig ) throws InvalidResourceIdentifierException;

    /**
     * ResourceIdentifierFactory capable of returning remote MRIs, CRIs, PRIs,
     * etc.
     * 
     * @return a ResourceIdentifierFactory capable of returning remote MRIs,
     * CRIs, PRIs, etc.
     */
    GenericResourceIdentifierFactory getResourceIdentifierFactory( );
}
