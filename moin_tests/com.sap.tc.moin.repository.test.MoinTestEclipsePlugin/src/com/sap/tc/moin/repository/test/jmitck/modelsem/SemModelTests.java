package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.lib.MultiTest;

/**
 * Defines tests covering JMI's semantic features. Subtypes implement one or
 * more public methods that take no parameters and return a <code>Status</code>
 * object. Each of these methods must be registered in the
 * <code>tests.properties</code> file. These methods cannot exercise the
 * metamodel-specific, generated interfaces, unless java reflection is employed.
 * code in this package must not have compilation dependencies on generated
 * interfaces.
 */
@SuppressWarnings( "nls" )
public class SemModelTests extends MultiTest {

    private static String instanceFactoryImplName;

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, SemModelTests.class );

    /**
     * Factory for creating datatype values and RefBaseObject instances.
     */
    public InstanceFactory instanceFactory;

    protected RefPackage rp;

    protected List<RefPackage> refPackageList;

    protected PrintWriter trOut;

    protected String prefix;

    protected boolean isStrReflectiveTest;

    protected boolean isObjReflectiveTest;

    protected XmiReader xmiReader;

    private ClassLoader loader;

    private TestDescription td;

    /**
     * Initializes this instance, in preparation for executing one test.
     * 
     * @param loader the current class loader for the test
     * @param td the <code>TestDescription</code> which defines the current test
     * @param trOut the <code>PrintWriter</code> for writing out script
     * messages. These messages will be availiable within the test harness.
     * @param refPackageList one or more RefPackage instances defining the
     * extent for this test. Multiple RefPackages only used in rare cases.
     * @param prefix the package prefix used to generate the code for the main
     * extent. An example would be "com.sap.tc.moin.repository.test.jmitck.tst"
     * @param xmiReader an instance of <code>XmiReader</code>, for use in
     * creating objects for tests by reading in XMI
     */
    public void init( ClassLoader loader, TestDescription td, PrintWriter trOut, List<RefPackage> refPackageList, String prefix, XmiReader xmiReader ) {

        this.loader = loader;
        this.td = td;
        this.trOut = trOut;
        this.refPackageList = refPackageList;
        this.prefix = prefix;
        this.xmiReader = xmiReader;
        this.isStrReflectiveTest = getBooleanParam( "strReflectiveTest", false );
        this.isObjReflectiveTest = getBooleanParam( "objReflectiveTest", false );
        if ( isStrReflectiveTest && isObjReflectiveTest ) {
            throw new TestErrorException( "Illegal test description: test " + "cannot be both strReflectiveTest and " + "strReflectiveTest" );
        }
        rp = refPackageList.get( 0 ); // primary
        instanceFactory = createInstanceFactory( rp );
    }

    /**
     * Returns the classloader in use for the current test
     * 
     * @return the current <code>ClassLoader</code>
     */
    public ClassLoader getClassLoader( ) {

        return loader;
    }

    /**
     * Sets the classloader to use for the current test
     * 
     * @param classLoader a <code>ClassLoader</code> value
     */
    public void setClassLoader( ClassLoader classLoader ) {

        loader = classLoader;
    }

    protected String getParam( String key, boolean required ) {

        String value = td.getParameter( key );
        if ( ( value == null ) && required ) {
            throw new TestErrorException( "Test requires parameter " + key + " defined in test " + td.getId( ) );
        }
        if ( ( value != null ) && value.equals( "&nbsp;" ) ) {
            value = "";
        }
        return value;
    }

    protected int getIntParam( String key, boolean required ) {

        String str = getParam( key, required );
        if ( str == null ) {
            return -1;
        }
        try {
            return Integer.parseInt( str );
        } catch ( NumberFormatException nfe ) {
            throw new TestErrorException( "Test " + td.getId( ) + " requires parameter " + key + " to be an integer; illegal value: " + str );
        }
    }

    protected boolean getBooleanParam( String key, boolean required ) {

        String str = getParam( key, required );
        return Boolean.valueOf( str ).booleanValue( );
    }

    protected List<String> getParamList( String key, boolean required ) {

        String str = getParam( key, required );
        List<String> answer = new ArrayList<String>( );
        if ( ( str != null ) && !str.equals( "[none]" ) && !str.equals( "&nbsp;" ) ) {
            StringTokenizer st = new StringTokenizer( str, "," );
            while ( st.hasMoreTokens( ) ) {
                answer.add( st.nextToken( ).trim( ) );
            }
        }
        return answer;
    }

    protected String getTestId( ) {

        return td.getId( );
    }

    private InstanceFactory createInstanceFactory( RefPackage rp ) {

        if ( instanceFactoryImplName == null ) {
            //         instanceFactoryImplName = 
            //            MetamodelLoader.getInstance().getProperty("lifecycleInstanceFactory");
            //         if (instanceFactoryImplName == null) {
            instanceFactoryImplName = StdInstanceFactory.class.getName( );
            //         }       
        }
        try {
            InstanceFactory instfac = (InstanceFactory) Class.forName( instanceFactoryImplName ).newInstance( );
            instfac.init( rp );
            return instfac;
        } catch ( ClassNotFoundException cnfe ) {
            log.trace( cnfe, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "The specified alternate Instance " + "factory implementation class for " + "non-life-cyle implementations, " + instanceFactoryImplName + " not found" );
        } catch ( InstantiationException ie ) {
            log.trace( ie, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not create an instance of " + instanceFactoryImplName );
        } catch ( IllegalAccessException iae ) {
            log.trace( iae, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not create an instance of " + instanceFactoryImplName );
        } catch ( ClassCastException cce ) {
            log.trace( cce, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "The supplied class " + instanceFactoryImplName + " is not an implementation of " + InstanceFactory.class.getName( ) );
        }
    }

    // slightly more convenient & readable
    protected boolean isReflectiveTest( ) {

        return ( isStrReflectiveTest || isObjReflectiveTest );
    }

}
