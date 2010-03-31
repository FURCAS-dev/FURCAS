package com.sap.tc.moin.facility.primary.test.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimIndexQueryService;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;


public class TestIndexIQLPartitionScope extends IndexTestCase {

    protected MRI c2MMri;

    protected MRI b2MMri;

    protected MRI d2MMri;

    protected MRI assoc;

    protected MRI wrongAssoc;

    protected MRI unknownAssoc;

    private ModelPartition mp1;

    private ModelPartition mp2;

    private ModelPartition mp3;

    private ModelPartition mp4;

    private PRI pri1;

    private PRI pri2;

    private PRI pri3;

    private PRI pri4;

    protected SpiFacilitySlimIndexQueryService iql;

    private Object[][] combinations;

    private int numOfCombs;

    private C2 c2_1;

    private C2 c2_2;

    private B2 b2_1;

    private final Collection<MRI> EXCEPTION = new ArrayList<MRI>( 0 );

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.iql = (SpiFacilitySlimIndexQueryService) super.index;
        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );
        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }
        this.saveConnectionOne( );
        super.deleteAllNonMetamodelsFromIndex( );

        c2MMri = ( (Partitionable) this.case002Package.getC2( ).refMetaObject( ) ).get___Mri( );
        b2MMri = ( (Partitionable) this.case002Package.getB2( ).refMetaObject( ) ).get___Mri( );
        d2MMri = ( (Partitionable) this.case002Package.getD2( ).refMetaObject( ) ).get___Mri( );

        assoc = ( (Partitionable) this.testcasesPackage.getCase002( ).getAreferencesB( ).refMetaObject( ) ).get___Mri( );
        wrongAssoc = ( (Partitionable) this.testcasesPackage.getCase001( ).getAreferencesB( ).refMetaObject( ) ).get___Mri( );
        unknownAssoc = wrongAssoc.getPri( ).createMri( fakeMofId );

        this.mp1 = this.createPartitionOne( );
        this.mp2 = this.createPartitionTwo( );
        this.mp3 = this.createPartitionThree( );
        this.mp4 = this.createPartitionFour( );
        this.pri1 = mp1.getPri( );
        this.pri2 = mp2.getPri( );
        this.pri3 = mp3.getPri( );
        this.pri4 = mp4.getPri( );

        this.c2_1 = this.createC2( );
        this.c2_2 = this.createC2( );
        this.b2_1 = this.createB2( );

        this.c2_2.setB( b2_1 );

        mp1.assignElement( c2_1 );
        mp1.assignElement( b2_1 );
        mp2.assignElement( c2_2 );

        saveConnectionOne( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.mp1.delete( );
        this.mp2.delete( );
        this.mp3.delete( );
        this.mp4.delete( );
        this.saveConnectionOne( );

        super.afterTestMethod( );
    }

    @Test
    public void testGetInstances( ) throws Exception {

        this.initGetInstanceCombinations( );

        for ( int i = 0; i < this.numOfCombs; i++ ) {
            Object[] var = this.combinations[i];

            ClientSpec[] cs = (ClientSpec[]) var[0];
            Collection<PRI> pris = (Collection<PRI>) var[1];
            Boolean incl = (Boolean) var[2];
            MRI[] types = (MRI[]) var[3];
            Collection<MRI> toBe = (Collection<MRI>) var[4];

            Scope scope = new Scope( cs, pris, incl );
            Collection<MRI> instances = null;
            try {
                try {
                    instances = this.iql.getInstances( scope, types );
                    this.verify( instances, toBe );
                } catch ( IllegalArgumentException iae ) {
                    if ( !( toBe == EXCEPTION ) ) {
                        throw iae;
                    }
                }
            } catch ( Exception e ) {
                Collection<MRI> typesColl = Arrays.asList( types );
                String message = String.format( "Position: %d\nClientSpecs: %s\nScope: %s\nInclusive: %s\nTypes: %s\nToBe: %s\nResult: %s\n\nError: %s", i, Arrays.deepToString( cs ), ( pris != null ) ? pris.toString( ) : "null", incl.toString( ), this.makeReadableMri( typesColl ), this
                    .makeReadableMri( toBe ), this.makeReadableMri( instances ), e.getMessage( ) );
                System.err.println( message );
                fail( message );
            }
        }
    }

    @Test
    public void testGetPartitionsOfInstances( ) throws Exception {

        this.initGetPartitionsOfInstanceCombinations( );

        for ( int i = 0; i < this.numOfCombs; i++ ) {
            Object[] var = this.combinations[i];

            ClientSpec[] cs = (ClientSpec[]) var[0];
            Collection<PRI> pris = (Collection<PRI>) var[1];
            Boolean incl = (Boolean) var[2];
            MRI type = (MRI) var[3];
            Collection<PRI> toBe = (Collection<PRI>) var[4];

            Scope scope = new Scope( cs, pris, incl );
            Collection<PRI> partitions = null;

            try {
                partitions = this.iql.getPartitionsOfInstances( scope, new MRI[] { type } );
                this.verify( partitions, toBe );
            } catch ( Exception e ) {
                Collection<MRI> typesColl = Arrays.asList( type );
                String message = String.format( "Position: %d\nClientSpecs: %s\nScope: %s\nInclusive: %s\nType: %s\nToBe: %s\nResult: %s\n\nError: %s", i, Arrays.deepToString( cs ), ( pris != null ) ? this.makeReadablePri( pris ) : "null", incl.toString( ), this.makeReadableMri( typesColl ), this
                    .makeReadablePri( toBe ), this.makeReadablePri( partitions ), e.getMessage( ) );
                System.err.println( message );
                fail( message );
            }

        }
    }

    @Test
    public void testGetLinkedPartitions( ) throws Exception {

        // additional setup
        C2 c2_3 = this.createC2( );
        C2 c2_31 = this.createC2( );
        B2 b2_4 = this.createB2( );
        B2 b2_11 = this.createB2( );

        c2_3.setB( b2_4 );
        c2_31.setB( b2_11 );

        this.mp1.assignElement( b2_11 );
        this.mp4.assignElement( b2_4 );
        this.mp3.assignElement( c2_3 );
        this.mp3.assignElement( c2_31 );

        MRI[] assocs = new MRI[] { assoc, wrongAssoc, unknownAssoc };

        saveConnectionOne( );

        this.initGetLinkedPartitionsCombinations( );

        for ( int j = 0; j < assocs.length; j++ ) {
            MRI association = assocs[j];
            for ( int i = 0; i < this.numOfCombs; i++ ) {
                Object[] var = this.combinations[i];

                ClientSpec[] cs = (ClientSpec[]) var[0];
                Collection<PRI> pris = (Collection<PRI>) var[1];
                Boolean incl = (Boolean) var[2];
                PRI from = (PRI) var[3];
                Collection<PRI> toBe = ( association == this.assoc ) ? (Collection<PRI>) var[4] : Collections.EMPTY_SET;

                Scope scope = new Scope( cs, pris, incl );
                Collection<PRI> partitions = null;

                try {
                    partitions = this.iql.getLinkedPartitions( scope, from, association );
                    this.verify( partitions, toBe );
                } catch ( Exception e ) {
                    Collection<PRI> fromColl = Arrays.asList( from );
                    String message = String.format( "Position: %d\nClientSpecs: %s\nScope: %s\nInclusive: %s\nFromPRI: %s\nAssoc: %s\nToBe: %s\nResult: %s\n\nError: %s", i, Arrays.deepToString( cs ), ( pris != null ) ? this.makeReadablePri( pris ) : "null", incl.toString( ), this
                        .makeReadablePri( fromColl ), this.makeReadableMri( Arrays.asList( association ) ), this.makeReadablePri( toBe ), this.makeReadablePri( partitions ), e.getMessage( ) );
                    System.err.println( message );
                    fail( message );
                }
            }
        }
    }

    // ########### PRIVATE Methods #############

    private String makeReadableMri( Collection<MRI> collection ) {

        Collection<String> result = new ArrayList<String>( );
        for ( MRI mri : collection ) {
            if ( mri == this.getMri( this.c2_1 ) ) {
                result.add( "c2_1" );
            } else if ( mri == this.getMri( this.c2_2 ) ) {
                result.add( "c2_2" );
            } else if ( mri == this.getMri( this.b2_1 ) ) {
                result.add( "b2_1" );
            } else if ( mri == c2MMri ) {
                result.add( "c2mmri" );
            } else if ( mri == b2MMri ) {
                result.add( "b2mmri" );
            } else if ( mri == assoc ) {
                result.add( "assoc" );
            } else if ( mri == unknownAssoc ) {
                result.add( "unknownAssoc" );
            } else if ( mri == wrongAssoc ) {
                result.add( "wrongAssoc" );
            } else {

                result.add( mri.toString( ) );
            }
        }
        return result.toString( );
    }

    private String makeReadablePri( Collection<PRI> collection ) {

        Collection<String> result = new ArrayList<String>( );
        for ( PRI pri : collection ) {
            if ( pri == pri1 ) {
                result.add( "pri1" );
            } else if ( pri == pri2 ) {
                result.add( "pri2" );
            } else if ( pri == pri3 ) {
                result.add( "pri3" );
            } else if ( pri == pri4 ) {
                result.add( "pri4" );
            } else {
                result.add( pri.toString( ) );
            }
        }
        return result.toString( );
    }

    private void verify( Collection is, Collection toBe ) {

        for ( Object each : is ) {
            if ( !toBe.contains( each ) ) {
                throw new RuntimeException( "Element " + each.toString( ) + " should not be in result " + toBe.toString( ) );
            }
        }
        for ( Object each : toBe ) {
            if ( !is.contains( each ) ) {
                throw new RuntimeException( "Element " + each.toString( ) + " not found in " + is.toString( ) );
            }
        }
    }

    private final class Scope implements SpiFacilityQueryClientScope {

        private ClientSpec[] cs;

        private Set<PRI> scope;

        private boolean inclusive;

        public Scope( ClientSpec[] cs, Collection<PRI> scope, Boolean inclusive ) {

            this.cs = cs;
            if ( scope != null ) {
                this.scope = new HashSet<PRI>( scope );
            } else {
                this.scope = Collections.emptySet( );
            }
            this.inclusive = inclusive.booleanValue( );
        }

        public Set<PRI> getPartitionsScope( ) {

            return scope;
        }

        public ClientSpec[] getQueryClientScope( ) {

            return cs;
        }

        public boolean isPartitionScopeInclusive( ) {

            return inclusive;
        }

    }

    private void initGetInstanceCombinations( ) {

        this.combinations = new Object[][] {
        // 0=clientspecs, 1=priscope, 2=inclusive, 3=getInstanceTypeScope, 4=getInstanceResult
            { this.localClientSpecs, null, false, this.getNonMofClass( ), EXCEPTION },//
            { this.localClientSpecs, null, false, this.getC2MofClass( ), this.getC2Instances( ) },//
            { this.localClientSpecs, null, false, this.getB2MofClass( ), this.getB2Instances( ) },
            { this.localClientSpecs, null, false, this.getAllMofClasses( ), this.getAllInstances( ) },

            { this.localClientSpecs, null, true, this.getNonMofClass( ), Collections.EMPTY_SET },//
            { this.localClientSpecs, null, true, this.getC2MofClass( ), Collections.EMPTY_SET },//
            { this.localClientSpecs, null, true, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.localClientSpecs, null, true, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.localClientSpecs, this.getPri1( ), true, this.getNonMofClass( ), this.getAllInstancesP1( ) },//
            { this.localClientSpecs, this.getPri1( ), true, this.getC2MofClass( ), this.getC2_1( ) },//
            { this.localClientSpecs, this.getPri1( ), true, this.getB2MofClass( ), this.getB2_1( ) },//
            { this.localClientSpecs, this.getPri1( ), true, this.getAllMofClasses( ), this.getAllInstancesP1( ) },

            { this.localClientSpecs, this.getPri1( ), false, this.getNonMofClass( ), EXCEPTION },//
            { this.localClientSpecs, this.getPri1( ), false, this.getC2MofClass( ), this.getC2_2( ) },
            { this.localClientSpecs, this.getPri1( ), false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.localClientSpecs, this.getPri1( ), false, this.getAllMofClasses( ), this.getC2_2( ) },

            { this.localClientSpecs, this.getAllPris( ), true, this.getNonMofClass( ), this.getAllInstances( ) },
            { this.localClientSpecs, this.getAllPris( ), true, this.getC2MofClass( ), this.getC2Instances( ) },//
            { this.localClientSpecs, this.getAllPris( ), true, this.getB2MofClass( ), this.getB2Instances( ) },//
            { this.localClientSpecs, this.getAllPris( ), true, this.getAllMofClasses( ), this.getAllInstances( ) },

            { this.localClientSpecs, this.getAllPris( ), false, this.getNonMofClass( ), EXCEPTION },//
            { this.localClientSpecs, this.getAllPris( ), false, this.getC2MofClass( ), Collections.EMPTY_SET },
            { this.localClientSpecs, this.getAllPris( ), false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.localClientSpecs, this.getAllPris( ), false, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.metamodelClientSpecs, null, false, this.getNonMofClass( ), EXCEPTION },//
            { this.metamodelClientSpecs, null, false, this.getC2MofClass( ), Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, null, false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, null, false, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.metamodelClientSpecs, null, true, this.getNonMofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, null, true, this.getC2MofClass( ), Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, null, true, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, null, true, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getPri1( ), true, this.getNonMofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getPri1( ), true, this.getC2MofClass( ), Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1( ), true, this.getB2MofClass( ), Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1( ), true, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getPri1( ), false, this.getNonMofClass( ), EXCEPTION },//
            { this.metamodelClientSpecs, this.getPri1( ), false, this.getC2MofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getPri1( ), false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getPri1( ), false, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getAllPris( ), true, this.getNonMofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getAllPris( ), true, this.getC2MofClass( ), Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), true, this.getB2MofClass( ), Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), true, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getAllPris( ), false, this.getNonMofClass( ), EXCEPTION },//
            { this.metamodelClientSpecs, this.getAllPris( ), false, this.getC2MofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getAllPris( ), false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getAllPris( ), false, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.allClientSpecs, null, false, this.getNonMofClass( ), EXCEPTION },//
            { this.allClientSpecs, null, false, this.getC2MofClass( ), this.getC2Instances( ) },//
            { this.allClientSpecs, null, false, this.getB2MofClass( ), this.getB2Instances( ) },
            { this.allClientSpecs, null, false, this.getAllMofClasses( ), this.getAllInstances( ) },

            { this.allClientSpecs, null, true, this.getNonMofClass( ), Collections.EMPTY_SET },
            { this.allClientSpecs, null, true, this.getC2MofClass( ), Collections.EMPTY_SET },//
            { this.allClientSpecs, null, true, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.allClientSpecs, null, true, this.getAllMofClasses( ), Collections.EMPTY_SET },

            { this.allClientSpecs, this.getPri1( ), true, this.getNonMofClass( ), this.getAllInstancesP1( ) },
            { this.allClientSpecs, this.getPri1( ), true, this.getC2MofClass( ), this.getC2_1( ) },//
            { this.allClientSpecs, this.getPri1( ), true, this.getB2MofClass( ), this.getB2_1( ) },//
            { this.allClientSpecs, this.getPri1( ), true, this.getAllMofClasses( ), this.getAllInstancesP1( ) },

            { this.allClientSpecs, this.getPri1( ), false, this.getNonMofClass( ), EXCEPTION },//
            { this.allClientSpecs, this.getPri1( ), false, this.getC2MofClass( ), this.getC2_2( ) },
            { this.allClientSpecs, this.getPri1( ), false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.allClientSpecs, this.getPri1( ), false, this.getAllMofClasses( ), this.getC2_2( ) },

            { this.allClientSpecs, this.getAllPris( ), true, this.getNonMofClass( ), this.getAllInstances( ) },
            { this.allClientSpecs, this.getAllPris( ), true, this.getC2MofClass( ), this.getC2Instances( ) },//
            { this.allClientSpecs, this.getAllPris( ), true, this.getB2MofClass( ), this.getB2Instances( ) },//
            { this.allClientSpecs, this.getAllPris( ), true, this.getAllMofClasses( ), this.getAllInstances( ) },

            { this.allClientSpecs, this.getAllPris( ), false, this.getNonMofClass( ), EXCEPTION },//
            { this.allClientSpecs, this.getAllPris( ), false, this.getC2MofClass( ), Collections.EMPTY_SET },
            { this.allClientSpecs, this.getAllPris( ), false, this.getB2MofClass( ), Collections.EMPTY_SET },
            { this.allClientSpecs, this.getAllPris( ), false, this.getAllMofClasses( ), Collections.EMPTY_SET } };

        this.numOfCombs = this.combinations.length;
    }

    private void initGetPartitionsOfInstanceCombinations( ) {

        this.combinations = new Object[][] {
        // 0=clientspecs, 1=priscope, 2=inclusive, 3=TypeScope, 4=Result
            { this.localClientSpecs, null, false, c2MMri, this.getPri1Pri2( ) },//
            { this.localClientSpecs, null, false, b2MMri, this.getPri1( ) },

            { this.localClientSpecs, null, true, c2MMri, Collections.EMPTY_SET },//
            { this.localClientSpecs, null, true, b2MMri, Collections.EMPTY_SET },

            { this.localClientSpecs, this.getPri1( ), true, c2MMri, this.getPri1( ) },//
            { this.localClientSpecs, this.getPri1( ), true, b2MMri, this.getPri1( ) },//

            { this.localClientSpecs, this.getPri1( ), false, c2MMri, this.getPri2( ) },
            { this.localClientSpecs, this.getPri1( ), false, b2MMri, Collections.EMPTY_SET },

            { this.localClientSpecs, this.getAllPris( ), true, c2MMri, this.getPri1Pri2( ) },//
            { this.localClientSpecs, this.getAllPris( ), true, b2MMri, this.getPri1( ) },//

            { this.localClientSpecs, this.getAllPris( ), false, c2MMri, Collections.EMPTY_SET },
            { this.localClientSpecs, this.getAllPris( ), false, b2MMri, Collections.EMPTY_SET },

            { this.metamodelClientSpecs, null, false, c2MMri, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, null, false, b2MMri, Collections.EMPTY_SET },

            { this.metamodelClientSpecs, null, true, c2MMri, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, null, true, b2MMri, Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getPri1( ), true, c2MMri, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1( ), true, b2MMri, Collections.EMPTY_SET },//

            { this.metamodelClientSpecs, this.getPri1( ), false, c2MMri, Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getPri1( ), false, b2MMri, Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getAllPris( ), true, c2MMri, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), true, b2MMri, Collections.EMPTY_SET },//

            { this.metamodelClientSpecs, this.getAllPris( ), false, c2MMri, Collections.EMPTY_SET },
            { this.metamodelClientSpecs, this.getAllPris( ), false, b2MMri, Collections.EMPTY_SET },

            { this.allClientSpecs, null, false, c2MMri, this.getPri1Pri2( ) },//
            { this.allClientSpecs, null, false, b2MMri, this.getPri1( ) },

            { this.allClientSpecs, null, true, c2MMri, Collections.EMPTY_SET },//
            { this.allClientSpecs, null, true, b2MMri, Collections.EMPTY_SET },

            { this.allClientSpecs, this.getPri1( ), true, c2MMri, this.getPri1( ) },//
            { this.allClientSpecs, this.getPri1( ), true, b2MMri, this.getPri1( ) },//

            { this.allClientSpecs, this.getPri1( ), false, c2MMri, this.getPri2( ) },
            { this.allClientSpecs, this.getPri1( ), false, b2MMri, Collections.EMPTY_SET },

            { this.allClientSpecs, this.getAllPris( ), true, c2MMri, this.getPri1Pri2( ) },//
            { this.allClientSpecs, this.getAllPris( ), true, b2MMri, this.getPri1( ) },//

            { this.allClientSpecs, this.getAllPris( ), false, c2MMri, Collections.EMPTY_SET },
            { this.allClientSpecs, this.getAllPris( ), false, b2MMri, Collections.EMPTY_SET } };

        this.numOfCombs = this.combinations.length;
    }

    private void initGetLinkedPartitionsCombinations( ) {

        this.combinations = new Object[][] {
        // 0=clientspecs, 1=priscope, 2=inclusive, 3=FromPri, 4=Result
            { this.localClientSpecs, null, false, pri3, this.getPri1Pri4( ) },//
            { this.localClientSpecs, null, false, pri2, this.getPri1( ) },
            { this.localClientSpecs, null, false, pri1, Collections.EMPTY_SET },

            { this.localClientSpecs, null, true, pri3, Collections.EMPTY_SET },//
            { this.localClientSpecs, null, true, pri2, Collections.EMPTY_SET },
            { this.localClientSpecs, null, true, pri1, Collections.EMPTY_SET },

            { this.localClientSpecs, this.getPri1Pri2( ), true, pri3, Collections.EMPTY_SET },//
            { this.localClientSpecs, this.getPri1Pri2( ), true, pri2, this.getPri1( ) },//
            { this.localClientSpecs, this.getPri1Pri2( ), true, pri1, Collections.EMPTY_SET },//

            { this.localClientSpecs, this.getPri1Pri2( ), false, pri3, this.getPri4( ) },//
            { this.localClientSpecs, this.getPri1Pri2( ), false, pri2, Collections.EMPTY_SET },//
            { this.localClientSpecs, this.getPri1Pri2( ), false, pri1, Collections.EMPTY_SET },//

            { this.localClientSpecs, this.getAllPris( ), true, pri3, this.getPri1Pri4( ) },//
            { this.localClientSpecs, this.getAllPris( ), true, pri2, this.getPri1( ) },//
            { this.localClientSpecs, this.getAllPris( ), true, pri1, Collections.EMPTY_SET },//

            { this.localClientSpecs, this.getAllPris( ), false, pri3, Collections.EMPTY_SET },//
            { this.localClientSpecs, this.getAllPris( ), false, pri2, Collections.EMPTY_SET },//
            { this.localClientSpecs, this.getAllPris( ), false, pri1, Collections.EMPTY_SET },//

            { this.metamodelClientSpecs, null, false, pri3, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, null, false, pri2, Collections.EMPTY_SET },
            { this.metamodelClientSpecs, null, false, pri1, Collections.EMPTY_SET },

            { this.metamodelClientSpecs, null, true, pri3, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, null, true, pri2, Collections.EMPTY_SET },
            { this.metamodelClientSpecs, null, true, pri1, Collections.EMPTY_SET },

            { this.metamodelClientSpecs, this.getPri1Pri2( ), true, pri3, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1Pri2( ), true, pri2, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1Pri2( ), true, pri1, Collections.EMPTY_SET },//

            { this.metamodelClientSpecs, this.getPri1Pri2( ), false, pri3, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1Pri2( ), false, pri2, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getPri1Pri2( ), false, pri1, Collections.EMPTY_SET },//

            { this.metamodelClientSpecs, this.getAllPris( ), true, pri3, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), true, pri2, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), true, pri1, Collections.EMPTY_SET },//

            { this.metamodelClientSpecs, this.getAllPris( ), false, pri3, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), false, pri2, Collections.EMPTY_SET },//
            { this.metamodelClientSpecs, this.getAllPris( ), false, pri1, Collections.EMPTY_SET },//

            { this.allClientSpecs, null, false, pri3, this.getPri1Pri4( ) },//
            { this.allClientSpecs, null, false, pri2, this.getPri1( ) },
            { this.allClientSpecs, null, false, pri1, Collections.EMPTY_SET },

            { this.allClientSpecs, null, true, pri3, Collections.EMPTY_SET },//
            { this.allClientSpecs, null, true, pri2, Collections.EMPTY_SET },
            { this.allClientSpecs, null, true, pri1, Collections.EMPTY_SET },

            { this.allClientSpecs, this.getPri1Pri2( ), true, pri3, Collections.EMPTY_SET },//
            { this.allClientSpecs, this.getPri1Pri2( ), true, pri2, this.getPri1( ) },//
            { this.allClientSpecs, this.getPri1Pri2( ), true, pri1, Collections.EMPTY_SET },//

            { this.allClientSpecs, this.getPri1Pri2( ), false, pri3, this.getPri4( ) },//
            { this.allClientSpecs, this.getPri1Pri2( ), false, pri2, Collections.EMPTY_SET },//
            { this.allClientSpecs, this.getPri1Pri2( ), false, pri1, Collections.EMPTY_SET },//

            { this.allClientSpecs, this.getAllPris( ), true, pri3, this.getPri1Pri4( ) },//
            { this.allClientSpecs, this.getAllPris( ), true, pri2, this.getPri1( ) },//
            { this.allClientSpecs, this.getAllPris( ), true, pri1, Collections.EMPTY_SET },//

            { this.allClientSpecs, this.getAllPris( ), false, pri3, Collections.EMPTY_SET },//
            { this.allClientSpecs, this.getAllPris( ), false, pri2, Collections.EMPTY_SET },//
            { this.allClientSpecs, this.getAllPris( ), false, pri1, Collections.EMPTY_SET } };

        this.numOfCombs = this.combinations.length;
    }

    private MRI[] getC2MofClass( ) {

        return new MRI[] { this.c2MMri };
    }

    private MRI[] getB2MofClass( ) {

        return new MRI[] { this.b2MMri };
    }

    private MRI[] getAllMofClasses( ) {

        return new MRI[] { this.b2MMri, this.c2MMri, this.d2MMri };
    }

    private MRI[] getNonMofClass( ) {

        return new MRI[0];
    }

    private MRI getMri( Object o ) {

        return ( (Partitionable) o ).get___Mri( );
    }

    private Collection<MRI> getC2_1( ) {

        Collection<MRI> result = new ArrayList<MRI>( );
        result.add( ( (Partitionable) this.c2_1 ).get___Mri( ) );
        return result;
    }

    private Collection<MRI> getC2_2( ) {

        Collection<MRI> result = new ArrayList<MRI>( );
        result.add( ( (Partitionable) this.c2_2 ).get___Mri( ) );
        return result;
    }

    private Collection<MRI> getC2Instances( ) {

        Collection<MRI> result = new ArrayList<MRI>( );
        result.add( ( (Partitionable) this.c2_1 ).get___Mri( ) );
        result.add( ( (Partitionable) this.c2_2 ).get___Mri( ) );
        return result;
    }

    private Collection<MRI> getB2_1( ) {

        Collection<MRI> result = new ArrayList<MRI>( );
        result.add( ( (Partitionable) this.b2_1 ).get___Mri( ) );
        return result;
    }

    private Collection<MRI> getB2Instances( ) {

        return getB2_1( );
    }

    private Collection<MRI> getAllInstances( ) {

        Collection<MRI> result = new ArrayList<MRI>( );
        result.add( ( (Partitionable) this.c2_1 ).get___Mri( ) );
        result.add( ( (Partitionable) this.c2_2 ).get___Mri( ) );
        result.add( ( (Partitionable) this.b2_1 ).get___Mri( ) );
        return result;
    }

    private Collection<MRI> getAllInstancesP1( ) {

        Collection<MRI> result = new ArrayList<MRI>( );
        result.add( ( (Partitionable) this.c2_1 ).get___Mri( ) );
        result.add( ( (Partitionable) this.b2_1 ).get___Mri( ) );
        return result;
    }

    private Collection<PRI> getPri1( ) {

        Collection<PRI> result = new ArrayList<PRI>( 1 );
        result.add( this.pri1 );
        return result;
    }

    private Collection<PRI> getPri2( ) {

        Collection<PRI> result = new ArrayList<PRI>( 1 );
        result.add( this.pri2 );
        return result;
    }

    private Collection<PRI> getPri4( ) {

        Collection<PRI> result = new ArrayList<PRI>( 1 );
        result.add( this.pri4 );
        return result;
    }

    private Collection<PRI> getAllPris( ) {

        Collection<PRI> result = new ArrayList<PRI>( 4 );
        result.add( this.pri1 );
        result.add( this.pri2 );
        result.add( this.pri3 );
        result.add( this.pri4 );
        return result;
    }

    private Collection<PRI> getPri1Pri2( ) {

        Collection<PRI> result = new ArrayList<PRI>( 2 );
        result.add( this.pri1 );
        result.add( this.pri2 );
        return result;
    }

    private Collection<PRI> getPri1Pri4( ) {

        Collection<PRI> result = new ArrayList<PRI>( 2 );
        result.add( this.pri1 );
        result.add( this.pri4 );
        return result;
    }

    private ModelPartition createPartitionOne( ) {

        return this.createPartition( "mp1" );
    }

    private ModelPartition createPartitionTwo( ) {

        return this.createPartition( "mp2" );
    }

    private ModelPartition createPartitionThree( ) {

        return this.createPartition( "mp3" );
    }

    private ModelPartition createPartitionFour( ) {

        return this.createPartition( "mp4" );
    }

    private ModelPartition createPartition( String name ) {

        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( name );
        mp.deleteElements( );
        return mp;
    }
}
