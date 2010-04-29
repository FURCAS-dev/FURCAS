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
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.ocl.utilities.OCLFactory;
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

    private WellformednessTests wft;

    private boolean showJmiTree = false;

    private long timeStamp;

    /**
     * See the base class
     */
    public BaseOclTest( ) {

        super( );
    }

    @Override
    @Before
    public void setUp() {

        this.timeStamp = System.currentTimeMillis( );

        //MoinTestHelper.setTestConfigurationFile( "nwdiTestConfiguration.properties" );
        try {
            super.setUp();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
      
        this.showJmiTree = "true".equalsIgnoreCase( System.getProperty( "OclShowJmiTree" ) );
        try {
            this.parser = OCLParser.class.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.wft = new WellformednessTests( );
    }

    protected Collection<OCLExpression> parse( String string, EObject context, EPackage[] types ) {

        return this.parse( string, context, types, null );
    }

    protected Collection<OCLExpression> parse( String expression, EObject context, EPackage[] types, Map<EClassifier, Set<EStructuralFeature>> oclDefinedFeatures ) {

        Collection<OCLExpression> statements = Collections.emptyList( );
        try {         
             statements = this.parser.parseString( expression, context, types, oclDefinedFeatures );
            
        } catch ( ParsingException e ) {
            // TODO remove this when only the new parser is used
            if ( expression.indexOf( ".%isUnique" ) > 0 ) {
                expression = expression.replace( ".%isUnique", ".isUnique" );
                try {
                    
                     statements = this.parser.parseString( expression, context, types, oclDefinedFeatures );
                    
                } catch ( ParsingException e1 ) {
                    ProcessReport report = this.parser.getReport( );
                    this.outputReport( expression, report );
                }
            }
            ProcessReport report = this.parser.getReport( );
            this.outputReport( expression, report );
        }

        for ( Iterator<OCLExpression> i = statements.iterator( ); i.hasNext( ); ) {
            OCLExpression s = i.next( );
            this.wft.checkOclExpression( s );
//            this.showJmiTree( s.getExpression( ) );
        }
        return statements;
    }

    protected void parseFail( String expression, EObject context, EPackage[] types ) {

        try {
            
            this.parser.parseString( expression, context, types );
            
            this.outputReport( expression, this.parser.getReport( ) );
            fail( "Expression should not parse: " + expression );
        } catch ( ParsingException e ) {
            fail( "Expected parsing failure encountered" );
        } catch ( Exception e ) {
            errorAndStop( "Unexpected Exception while parsing", e );
        }

    }

    protected void showJmiTree( EObject root ) {

        if ( this.showJmiTree ) {
            //TODO if necessary show AST
            System.out.println("Currently no Tree Viewer provided!");
//            JmiTreeViewer viewer = new JmiTreeViewer( root );
//            viewer.setModal( true );
//            viewer.setBounds( new Rectangle( 100, 100, 400, 500 ) );
//            viewer.setVisible( true );
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
    public void tearDown() {

        this.mofPkg = null;
        this.parser = null;
        this.wft = null;

        // TODO we should do without restarting MOIN, but still should call the
        // afterTestMethod of the JUnit...
        try {
            super.tearDown();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long testTime = System.currentTimeMillis( ) - timeStamp;

        
        System.out.println( "TestTime : " + testTime + "ms" );
    }
}