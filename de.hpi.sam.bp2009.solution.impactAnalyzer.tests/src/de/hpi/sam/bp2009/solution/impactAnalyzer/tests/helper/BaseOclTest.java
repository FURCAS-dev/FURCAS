package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import java.awt.Rectangle;
import java.beans.Expression;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.parser.OCLParser;
import org.junit.After;
import org.junit.Before;

/**
 * Base class for all OCL tests except the metamodel import stuff
 * 
 * @author d022737
 */
public abstract class BaseOclTest extends TestCase {

    // trace setup
//    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, BaseOclTest.class );

    /**
     * This uses the company and service interactions metamodels
     */
    public static final String[] TEST_METAMODELS = { "company", "ServiceInteractions" };

    protected EPackage mofPkg;

    private OCLParser parser;

    protected ModelPackageImpl modelPackage;

    private WellformednessTests wft;

    private boolean showJmiTree = false;

    protected ModelPartition myTemporaryPartition;

    private long timeStamp;

    protected Object syncObjectForWrite;

    /**
     * See the base class
     */
    public BaseOclTest( ) {

        super( );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        this.timeStamp = System.currentTimeMillis( );

        //MoinTestHelper.setTestConfigurationFile( "nwdiTestConfiguration.properties" );
        super.beforeTestMethod( );

        this.connection = createConnection( );
        this.coreConnection = getTestHelper( ).getCoreConnection( this.connection );
        CoreModelPartition cp = coreConnection.getOrCreateTransientPartitionNonTransactional( "OclTestTransientPartition" );
        this.syncObjectForWrite = coreConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( );
        this.myJmiCreator = new JmiCreator( this.coreConnection, true, cp );
        this.mofPkg = (com.sap.tc.moin.MoinPackage) this.coreConnection.getPackage( MoinPackage.PACKAGE_DESCRIPTOR );
        this.modelPackage = (ModelPackageImpl) ( (MoinPackageImpl) this.mofPkg ).getModel( coreConnection );
        this.showJmiTree = "true".equalsIgnoreCase( System.getProperty( "OclShowJmiTree" ) );
        this.parser = OclParserFactory.create( this.myJmiCreator );
        this.wft = new WellformednessTests( coreConnection );
    }

    protected Collection<OCLExpression> parse( String string, EObject context, EPackage[] types ) {

        return this.parse( string, context, types, null );
    }

    protected Collection<OCLExpression> parse( String expression, EObject context, EPackage[] types, Map<EClassifier, Set<EStructuralFeature>> oclDefinedFeatures ) {

        Collection<OclStatement> statements = Collections.emptyList( );
        try {
            synchronized ( syncObjectForWrite ) {
                statements = this.parser.parseString( expression, context, types, oclDefinedFeatures );
            }
        } catch ( ParsingException e ) {
            // TODO remove this when only the new parser is used
            if ( expression.indexOf( ".%isUnique" ) > 0 ) {
                expression = expression.replace( ".%isUnique", ".isUnique" );
                try {
                    synchronized ( syncObjectForWrite ) {
                        statements = this.parser.parseString( expression, context, types, oclDefinedFeatures );
                    }
                } catch ( ParsingException e1 ) {
                    ProcessReport report = this.parser.getReport( );
                    this.outputReport( expression, report );
                }
            }
            ProcessReport report = this.parser.getReport( );
            this.outputReport( expression, report );
        }

        for ( Iterator<OclStatement> i = statements.iterator( ); i.hasNext( ); ) {
            OclStatement s = i.next( );
            this.wft.checkOclExpression( (OclExpressionInternal) s.getExpression( ) );
            this.showJmiTree( s.getExpression( ) );
        }
        return statements;
    }

    protected void parseFail( String expression, EObject context, EPackage[] types ) {

        try {
            synchronized ( this.syncObjectForWrite ) {
                this.parser.parseString( expression, context, types );
            }
            this.outputReport( expression, this.parser.getReport( ) );
            flop( "Expression should not parse: " + expression );
        } catch ( ParsingException e ) {
            info( "Expected parsing failure encountered" );
        } catch ( Exception e ) {
            errorAndStop( "Unexpected Exception while parsing", e );
        }

    }

    protected void showJmiTree( RefObject root ) {

        if ( this.showJmiTree ) {
            CoreConnection cconn;
            if ( connection instanceof Wrapper ) {
                cconn = (CoreConnection) ( (Wrapper) connection ).unwrap( );
            } else {
                cconn = (CoreConnection) connection;
            }
            JmiTreeViewer viewer = new JmiTreeViewer( root, cconn );
            viewer.setModal( true );
            viewer.setBounds( new Rectangle( 100, 100, 400, 500 ) );
            viewer.setVisible( true );
        }
    }

    private void outputReport( String expression, ProcessReport report ) {

        if ( report.getProcessStatus( ) == ProcessReport.FAILED ) {
            errorAndContinue( "Expression parsing failed:\n" + expression + "\n" + report.toString( ) );

        } else if ( report.getProcessStatus( ) == ProcessReport.FATAL ) {
            errorAndStop( "Expression parsing failed:\n" + expression + "\n" + report.toString( ) );
        } else {
            info( "Expression was parsed successfully:\n" + expression );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( connection != null ) {
            this.connection.close( );
        }
        this.connection = null;
        this.mofPkg = null;
        this.parser = null;
        this.modelPackage = null;
        this.wft = null;
        this.myTemporaryPartition = null;
        this.syncObjectForWrite = null;
        this.myJmiCreator = null;

        // TODO we should do without restarting MOIN, but still should call the
        // afterTestMethod of the JUnit...
        super.afterTestMethod( );

        long testTime = System.currentTimeMillis( ) - timeStamp;

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "TestTime : " + testTime + "ms" );
        }
    }
}