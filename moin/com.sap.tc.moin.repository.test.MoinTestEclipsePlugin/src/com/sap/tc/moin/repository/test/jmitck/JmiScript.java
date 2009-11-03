package com.sap.tc.moin.repository.test.jmitck;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.javatest.Script;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment;

/**
 * Basic JMI Script. Currently doesn't do a lot. May refactor stuff up here, or
 * get rid of it.
 */
@SuppressWarnings( "nls" )
public abstract class JmiScript extends Script {

    /*
     * NOTE: Code was lifted from the provided JCK example, JCKScript.java
     */

    public static final String TEST_TITLE = "title";

    public static final String METAMODEL = "metamodel";

    public static final String TEST_TYPE = "testType";

    public static final String EXECUTE_ARGS = "executeArgs";

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, JmiScript.class );

    protected String testTitle;

    protected String testType;

    protected List<String> metamodelList;

    protected String exeClass;

    protected String exeArgs;

    /**
     * Script subclass for JMI Tests. SubClassed further by test category.
     */
    @Override
    public void initTestDescription( TestDescription td ) {

        super.initTestDescription( td );
        testTitle = td.getParameter( TEST_TITLE );
        metamodelList = getParamList( METAMODEL );
        testType = td.getParameter( TEST_TYPE );

        exeArgs = td.getParameter( EXECUTE_ARGS );
    }

    protected ClassLoader getClassLoader( ) {

        return loader;
    }

    protected void setClassLoader( ClassLoader classLoader ) {

        loader = classLoader;
    }

    @Override
    public Status run( String[] args, TestDescription td, TestEnvironment env ) {

        //      log.info("=== Executing test " + td.getRootRelativePath() + "/" + td.getId() + " >>>>");
        log.trace( MoinSeverity.INFO, "=== Executing test " + td.getRootRelativePath( ) + "/" + td.getId( ) + " >>>>" );
        Status result = null;
        try {
            result = runScript( args, td, env );
        } catch ( TestErrorException tee ) {
            result = Status.error( tee.getMessage( ) );
        }
        log.trace( MoinSeverity.INFO, "=== Test Completed  (" + td.getRootRelativePath( ) + "/" + td.getId( ) + ") <<<<" );

        return result;
    }

    protected abstract Status runScript( String[] args, TestDescription td, TestEnvironment env );

    protected List<String> getParamList( String key ) {

        String str = td.getParameter( key );
        List<String> answer = new ArrayList<String>( );
        if ( ( str != null ) && !str.equals( "[none]" ) && !str.equals( "&nbsp;" ) ) {
            StringTokenizer st = new StringTokenizer( str, "," );
            while ( st.hasMoreTokens( ) ) {
                answer.add( st.nextToken( ).trim( ) );
            }
        }
        return answer;
    }

}
