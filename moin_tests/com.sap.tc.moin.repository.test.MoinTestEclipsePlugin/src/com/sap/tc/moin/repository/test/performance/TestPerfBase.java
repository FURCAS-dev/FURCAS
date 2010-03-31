package com.sap.tc.moin.repository.test.performance;

import org.eclipse.test.performance.Dimension;
import org.eclipse.test.performance.Performance;
import org.eclipse.test.performance.PerformanceMeter;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.test.fw.ModelDataInstantiator;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Base class for performance test cases providing common functionality like
 * import of the synthetic MetaModel, access to test data creation, access to
 * the the MoinPeformanceMeter, etc. Generally the performance run itself looks
 * like this: initialize performance, meter start, meter execute code to
 * measure, stop meter, commit meter, dispose meter.
 */
public class TestPerfBase extends MoinTestCase {

    protected static final String MOIN_TEST_ID_PREFIX = "MOIN ";

    protected static final String MOIN_MEMORY_SUFFIX = "(Mem)";

    private static final String IS_MEMORY_TEST = "moin.test.performance.memory";

    private static MoinLogger testLogger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, TestPerfBase.class );

    private static ModelDataInstantiator mdi;

    /**
     * IMPORTANT: The performance meter must be unique. It is not allowed to
     * hold static references or to reuse a PerformanceMeter by assigning a new
     * scenarioId.
     */
    private Performance _performance;

    /**
     * The performance measurements according to the Eclipse Performance API,
     * which are stored in the performance database.
     */
    public static final Dimension MEASUREMENTS[] = new Dimension[] { Dimension.CPU_TIME };

    public TestPerfBase( ) {

        //initialize performance measurement and performance meter
        _performance = Performance.getDefault( );

        if ( mdi == null ) {
            mdi = new ModelDataInstantiator( getTestHelper( ).getDefaultTestClient( false ) );
        }
    }

    protected ModelDataInstantiator getModelDataInstantiator( ) {

        return mdi;
    }

    protected MoinLogger getLogger( ) {

        return testLogger;
    }

    /**
     * Returns the instance of {@link Performance}, which can be used in this
     * test. It is initialized in the constructor.
     * 
     * @return The instance of {@link Performance}, which can be used in this
     * test.
     */
    protected Performance getPerformance( ) {

        return _performance;
    }

    /**
     * This method ends the measurements of a {@link PerformanceMeter}. First
     * the PerformanceMeter is committed. Then it asserts that the results are
     * in the predefined range [-100%, +10%] compared to a previous measurement
     * and throws a Runtime Exception otherwise.
     * 
     * @param performanceMeter The PerformanceMeter to end.
     * @param assertPerformance If true, then the results must be in the
     * predefined range.
     */
    protected void endPerformanceMeasurement( PerformanceMeter performanceMeter, boolean assertPerformance ) {

        performanceMeter.commit( );
        for ( int i = 0; i < MEASUREMENTS.length; i++ ) {
            // the performance may be 100% faster, but only 10% slower
            getPerformance( ).assertPerformanceInRelativeBand( performanceMeter, MEASUREMENTS[i], -100, +30 );
        }
    }

    /**
     * Generic method to create a PerformanceMeter.
     * 
     * @param scenarioId scenario id which must be unique since reruns are
     * identified via this id
     * @param shortName a short (shorter than 35 characters) descriptive name of
     * the scenario
     * @param globalSummary If true, then the PerformanceMeter is marked as
     * having global importance, meaning it is contained in the overview
     * evaluations.
     * @param commentText the comment (shorter than 400 characters) for the
     * scenario
     * @return The created PerformanceMeter.
     * @deprecated
     */
    @Deprecated
    protected PerformanceMeter createPerformanceMeter( String scenarioId, String shortName, boolean globalSummary, String comment ) {

        // assert valid scenarioId: not null and length < 256 character
        checkParameterForNull( scenarioId, "scenarioId" );
        checkParameterLength( scenarioId, "scenarioId", 256 );

        // assert valid shortName: not null and length < 40 character
        checkParameterForNull( shortName, "shortName" );
        checkParameterLength( shortName, "shortName", 40 );

        // assert valid comment: not null and length < 400 character
        checkParameterForNull( comment, "comment" );
        checkParameterLength( comment, "comment", 400 );

        PerformanceMeter performanceMeter = getPerformance( ).createPerformanceMeter( scenarioId );
        if ( globalSummary ) {
            getPerformance( ).tagAsGlobalSummary( performanceMeter, shortName, MEASUREMENTS );
        } else {
            getPerformance( ).tagAsSummary( performanceMeter, shortName, MEASUREMENTS );
        }
        getPerformance( ).setComment( performanceMeter, Performance.EXPLAINS_DEGRADATION_COMMENT, comment );
        return performanceMeter;
    }

    /**
     * Generic method to create a PerformanceMeter.
     * 
     * @param shortName a short (shorter than 35 characters) descriptive name of
     * the scenario
     * @param globalSummary If true, then the PerformanceMeter is marked as
     * having global importance, meaning it is contained in the overview
     * evaluations.
     * @param commentText the comment (shorter than 400 characters) for the
     * scenario
     * @return The created PerformanceMeter.
     */
    protected PerformanceMeter createPerformanceMeter( String descriptiveId, boolean globalSummary, String comment ) {

        // Format: MOIN_TEST_ID_PREFIX + shortName + "[" +className+ "#" +testName+ "()" +"]"
        StringBuilder idBuilder = new StringBuilder( );
        idBuilder.append( MOIN_TEST_ID_PREFIX );
        idBuilder.append( descriptiveId );

        if ( "true".equalsIgnoreCase( System.getProperty( IS_MEMORY_TEST ) ) ) {
            idBuilder.append( MOIN_MEMORY_SUFFIX );
        }

        return createPerformanceMeter( idBuilder.toString( ), idBuilder.toString( ), globalSummary, comment );
    }

    /**
     * @param param Parameter to be checked for null
     * @param paramName Name of the parameter to be used in the
     * IllegalArgumentException message
     * @throws IllegalArgumentException
     */
    private void checkParameterForNull( Object param, String paramName ) {

        if ( param == null ) {
            throw new IllegalArgumentException( "Parameter " + paramName + " must not be null" );
        }
    }

    /**
     * @param param
     * @param paramName
     * @param lengthLimit
     */
    private void checkParameterLength( String param, String paramName, int lengthLimit ) {

        checkParameterForNull( param, paramName );
        if ( param.length( ) >= lengthLimit ) {
            throw new IllegalArgumentException( "Parameter " + paramName + " must be shorter than " + lengthLimit + " characters. Parameter: " + paramName + ", length: " + param.length( ) );
        }
    }

    protected static void setUp( ) throws Exception {

        if ( mdi != null ) {
            mdi.createData( );
        }
    }

    protected static void tearDown( ) throws Exception {

        if ( mdi != null ) {
            mdi.shutdown( );
        }
        mdi = null;
    }
}
