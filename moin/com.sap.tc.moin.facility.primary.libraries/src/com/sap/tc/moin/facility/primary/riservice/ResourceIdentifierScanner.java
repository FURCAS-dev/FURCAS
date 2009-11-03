package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * Facility internal IPI interface.
 * <p>
 * A resource identifier scanner knows about the structure of resource
 * identifiers in terms of relevant tokens and the delimiters between such
 * tokens. It provides service operations for scanning resource identifier
 * strings, meaning breaking such strings into tokens and identify illegal
 * input.
 * <p>
 * The tokens a resource identifier may consists of are reflected in the
 * interface {@link ResourceIdentifierTokens} (see @link MRI).
 * <p>
 * The separator between facility name and data area name ('<code>.</code>') as
 * well as the separator between the data area descriptor part and the rest of a
 * resource identifier ('<code>:</code>') are defined by MOIN and binding on all
 * scanners and facilities respectively. All other delimiters can be
 * individually defined.
 * 
 * @author d047015
 */
public interface ResourceIdentifierScanner {

    /**
     * Breaks (and implicitly verifies) the given String representation of a
     * {@link MRI} into tokens.
     * <p>
     * Invalid strings will be rejected with an
     * {@link InvalidResourceIdentifierException}.
     * 
     * @param mriString String representation of the {@link MRI} to scan.
     * @return A {@link ResourceIdentifierTokens} containing the parse result.
     */
    public ResourceIdentifierTokens scanMriString( String mriString );

    /**
     * Breaks (and implicitly verifies) the given string representation of a
     * {@link CRI} into tokens.
     * <p>
     * Invalid strings will be rejected with an
     * {@link InvalidResourceIdentifierException}.
     * 
     * @param criString String representation of the {@link CRI} to scan.
     * @return A {@link ResourceIdentifierTokens} containing the parse result.
     */
    public ResourceIdentifierTokens scanCriString( String criString );


    /**
     * Breaks (and implicitly verifies) the given string representation of a
     * {@link PRI} into tokens.
     * <p>
     * Invalid strings will be rejected with an
     * {@link InvalidResourceIdentifierException}.
     * 
     * @param priString String representation of the {@link PRI} to scan.
     * @return A {@link ResourceIdentifierTokens} containing the parse result.
     */
    public ResourceIdentifierTokens scanPriString( String priString );

    /**
     * Breaks (and implicitly verifies) the given string representation of a
     * {@link LRI} into tokens.
     * <p>
     * Invalid strings will be rejected with an
     * {@link InvalidResourceIdentifierException}.
     * 
     * @param lriString String representation of the {@link LRI} to scan.
     * @return A {@link ResourceIdentifierTokens} containing the parse result.
     */
    public ResourceIdentifierTokens scanLriString( String lriString );

    /**
     * Plain data structure for resource identifier string tokens.
     * <p>
     * According to the usage context not all fields have to be filled (
     * <code>!= null</code>).
     */
    public static final class ResourceIdentifierTokens {

        /** Facility id token of a resource identifier string representation. */
        public String facilityId;

        /** DataArea token of a resource identifier string representation. */
        public String dataAreaName;

        /** Container name token of a resource identifier string representation. */
        public String containerName;

        /** Partition name token of a resource identifier string representation. */
        public String partitionName;

        /** MofId token of a resource identifier string representation. */
        public String mofId;
    }

}
