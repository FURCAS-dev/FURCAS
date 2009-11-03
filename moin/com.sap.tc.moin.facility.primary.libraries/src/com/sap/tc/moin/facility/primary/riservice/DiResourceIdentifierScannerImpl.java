package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;


/**
 * This Di specific resource identifier scanner knows about the structure of Di
 * resource identifiers in terms of relevant tokens and the delimiters between
 * such tokens.
 * 
 * @author D047015
 */
public class DiResourceIdentifierScannerImpl implements ResourceIdentifierScanner {

    public DiResourceIdentifierScannerImpl( ) {

    }

    public ResourceIdentifierTokens scanCriString( String criString ) {

        int[] pos = this.parseSeparatorPositions( criString );

        // precondition checks for CRI
        if ( pos[2] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMEPREFIXMISSINGINCRI, DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR, criString );
        }
        if ( pos[3] != -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMESUFFIXNOTALLOWEDINCRI, DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX, criString );
        }
        if ( pos[4] != -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.MOFSEPARATORNOTALLOWEDINCRI, DiResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR, criString );
        }

        ResourceIdentifierTokens record = new ResourceIdentifierTokens( );

        // FIXME: Do not ignore/replace the actual input facility id!
        record.facilityId = PrimaryFacility.FACILITY_ID;
        record.dataAreaName = criString.substring( pos[0] + 1, pos[1] );
        record.containerName = criString.substring( pos[2] + 4 );

        this.checkRecord( record, criString );

        return record;
    }

    public ResourceIdentifierTokens scanPriString( String priString ) {

        int[] pos = this.parseSeparatorPositions( priString );

        // precondition checks for PRI
        if ( pos[2] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMEPREFIXMISSINGPRI, DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR, priString );
        }
        if ( pos[3] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMESUFFIXMISSINGPRI, DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX, DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, priString );
        }
        if ( pos[4] != -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.MOFSEPARATORNOTALLOWEDPRI, DiResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR, priString );
        }

        ResourceIdentifierTokens record = new ResourceIdentifierTokens( );

        // FIXME: Do not ignore/replace the actual input facility id!
        record.facilityId = PrimaryFacility.FACILITY_ID;
        record.dataAreaName = priString.substring( pos[0] + 1, pos[1] );
        record.containerName = priString.substring( pos[2] + 4, pos[3] );
        record.partitionName = priString.substring( pos[3] + 7 );

        this.checkRecord( record, priString );

        return record;
    }

    public ResourceIdentifierTokens scanMriString( String mriString ) {

        int[] pos = this.parseSeparatorPositions( mriString );

        // precondition checks for MRI
        if ( pos[2] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMEPREFIXMISSINGMRI, DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR, mriString );
        }
        if ( pos[3] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMESUFFIXMISSINGMRI, DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX, DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, mriString );
        }
        if ( pos[4] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.MOFIDSEPARATORMISSINGMRI, DiResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR, DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX, mriString );
        }

        ResourceIdentifierTokens record = new ResourceIdentifierTokens( );

        // FIXME: Do not ignore/replace the actual input facility id!
        record.facilityId = PrimaryFacility.FACILITY_ID;
        record.dataAreaName = mriString.substring( pos[0] + 1, pos[1] );
        record.containerName = mriString.substring( pos[2] + 4, pos[3] );
        record.partitionName = mriString.substring( pos[3] + 7, pos[4] );
        record.mofId = mriString.substring( pos[4] + 1 );

        this.checkRecord( record, mriString );

        return record;
    }

    public ResourceIdentifierTokens scanLriString( String lriString ) {

        int[] pos = this.parseSeparatorPositions( lriString );

        // precondition checks for LRI
        if ( pos[2] != -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMEPREFIXNOTALLOWEDINLRI, DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, lriString );
        }
        if ( pos[3] != -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMESUFFIXNOTALLOWEDINLRI, DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX, lriString );
        }
        if ( pos[4] != -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.MOFIDSEPARATORNOTALLOWEDINLRI, DiResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR, lriString );
        }

        ResourceIdentifierTokens record = new ResourceIdentifierTokens( );

        // FIXME: Do not ignore/replace the actual input facility id!
        record.facilityId = PrimaryFacility.FACILITY_ID;
        record.dataAreaName = lriString.substring( pos[0] + 1, pos[1] );
        record.mofId = lriString.substring( pos[1] + 1 );

        this.checkRecord( record, lriString );

        return record;
    }

    /**
     * Parses the given resource identifier string for all known separators and
     * returns their position in the string. Throws
     * {@link InvalidResourceIdentifierException} if no facility id separator or
     * DataArea name separator was found, or if the facility id is wrong.
     * 
     * @param string Resource identifier string to parse.
     * @return <code>int[5]</code> array of positions of the separators.
     * Contains the positions in the string or -1 if not found<br>
     * int[0] = FACILITY_INSTANCE_SEPARATOR<br>
     * int[1] = FACILITY_PART_SEPARATOR<br>
     * int[2] = DC_NAME_PART_PREFIX<br>
     * int[3] = DC_NAME_PART_SUFFIX<br>
     * int[4] = MOF_ID_SEPARATION_CHAR
     */
    private int[] parseSeparatorPositions( String string ) {

        int[] positions = new int[5];

        // find separator of facility id and DataArea name , check if it's even there and if the facility id is valid for our facility 
        positions[0] = string.indexOf( DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
        if ( positions[0] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.FACILITYIDSEPARATORMISSING, DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR, string );
        }
        if ( !PrimaryFacility.FACILITY_ID.equals( string.substring( 0, positions[0] ) ) ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.NONWDIRESOURCEIDENTIFIER, string.substring( 0, positions[0] ), string );
        }

        // find separator of DataArea name and container name and check if it's there
        positions[1] = string.indexOf( DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR, positions[0] );
        if ( positions[1] == -1 ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.DATAAREANAMESEPARATORMISSING, DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR, string );
        }

        // find prefix of container name 
        positions[2] = string.indexOf( DiResourceIdentifierConstants.DC_NAME_PART_PREFIX, positions[1] );

        // find separator of container name and partition name
        positions[3] = string.indexOf( DiResourceIdentifierConstants.DC_NAME_PART_SUFFIX, positions[2] );

        // find separator of partition name and mof id
        positions[4] = string.indexOf( DiResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR, positions[3] );

        return positions;
    }

    /**
     * Checks if all set names in the {@link ResourceIdentifierRecord} are
     * valid, i.e. have at least one character.
     * 
     * @param record
     * @param string the original string where the record is created from.
     */
    private void checkRecord( ResourceIdentifierTokens record, String string ) {

        // Facility id is not tested, since always set to fix value PrimaryFacility.FACILITY_ID

        if ( record.dataAreaName != null ) {
            if ( record.dataAreaName.length( ) == 0 ) {
                throw new InvalidResourceIdentifierException( RiServiceMessages.DATAAREAMISSING, string );
            }
        }
        if ( record.containerName != null ) {
            if ( record.containerName.length( ) == 0 ) {
                throw new InvalidResourceIdentifierException( RiServiceMessages.CONTAINERNAMEMISSING, string );
            }
        }
        if ( record.partitionName != null ) {
            if ( record.partitionName.length( ) == 0 ) {
                throw new InvalidResourceIdentifierException( RiServiceMessages.PARTITIONNAMEMISSING, string );
            }
        }
        if ( record.mofId != null ) {
            if ( record.mofId.length( ) == 0 ) {
                throw new InvalidResourceIdentifierException( RiServiceMessages.MOFIDMISSING, string );
            }
        }
    }

}
