package com.sap.tc.moin.repository.test.ocl.base;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.__impl.MoinPackageImpl;
import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.parser.treeviewer.JmiTreeViewer;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Base class for all OCL tests except the metamodel import stuff
 * 
 * @author d022737
 */
public abstract class BaseOclTest extends CoreMoinTest {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, BaseOclTest.class );

    /**
     * This uses the company and service interactions metamodels
     */
    public static final String[] TEST_METAMODELS = { TestMetaModels.COMPANY, TestMetaModels.SERVICE_INTERACTIONS };

    protected MoinPackage mofPkg;

    private IOclParser parser;

    protected ModelPackageImpl modelPackage;

    private WellformednessTests wft;

    private boolean showJmiTree = false;

    protected ModelPartition myTemporaryPartition;

    protected Connection connection;

    private long timeStamp;

    protected Object syncObjectForWrite;

    protected CoreConnection coreConnection;

    protected MoinJmiCreator myJmiCreator;

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

    protected Collection<OclStatement> parse( String string, RefObject context, RefPackage[] types ) {

        return this.parse( string, context, types, null );
    }

    protected Collection<OclStatement> parse( String expression, RefObject context, RefPackage[] types, Map<Classifier, Set<Feature>> oclDefinedFeatures ) {

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

    protected void parseFail( String expression, RefObject context, RefPackage[] types ) {

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