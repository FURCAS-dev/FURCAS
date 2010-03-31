package com.sap.tc.moin.repository.test.jmigenerator.standalone;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.sap.junit.MoinParameterizedRunner;
import com.sap.junit.MoinParameterizedRunner.ParametersDescription;
import com.sap.tc.moin.test.fw.TestMetaModels;

@RunWith( MoinParameterizedRunner.class )
public class TestGenerateMoinMetamodelsStandaloneSmoke extends TestGenerateMoinMetamodelsStandalone {

    public TestGenerateMoinMetamodelsStandaloneSmoke( String aMetamodelContainerName ) throws IllegalArgumentException {

        super( aMetamodelContainerName );
    }

    @Override
    @Test
    // overwrites the currently ignored test from super class
    public void testGenerationAndCompilation( ) throws Exception {

        super.testGenerationAndCompilation( );
    }

    @Parameters
    public static List<String[]> getMetamodelContainerNames( ) throws Exception {

        List<String[]> metamodelContainerNames = new ArrayList<String[]>( );
        metamodelContainerNames.add( new String[] { TestMetaModels.MOIN_MOF_CN } );
//        metamodelContainerNames.add( new String[] { TestMetaModels.TESTCASES_CN } );
        return metamodelContainerNames;
    }

    @ParametersDescription
    public static List<String> getMetamodelContainerNameDescriptions( ) throws Exception {
        List<String> metamodelContainerNameDescriptions = new ArrayList<String>( );
        metamodelContainerNameDescriptions.add( TestMetaModels.MOIN_MOF_CN );
//        metamodelContainerNameDescriptions.add(TestMetaModels.TESTCASES_CN);
        return metamodelContainerNameDescriptions;
    }

}
