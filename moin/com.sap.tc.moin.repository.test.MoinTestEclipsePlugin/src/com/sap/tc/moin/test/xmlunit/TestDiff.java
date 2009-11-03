package com.sap.tc.moin.test.xmlunit;

import java.io.FileReader;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.ElementQualifier;
import org.custommonkey.xmlunit.XMLTestCase;

// Referenced classes of package com.sap.tc.moin.repository.test.xml:
// XMIElementQualifier, IgnoreTestListener

@SuppressWarnings( "nls" )
public class TestDiff extends XMLTestCase {

    public TestDiff( ) {

    }

    @Override
    public void setUp( ) throws Exception {

        super.setUp( );
        file1 = new FileReader( "C:/TEMP/testUmlModel_MOINserialized.xml" );
        file2 = new FileReader( "C:/TEMP/moin_workspace/xmi/partitions/MOIN_out.xmi" );
        xmiElementQualifier = new XMIElementQualifier( );
        diffListener = new IgnoreTestListener( );
    }

    public void skiptestSimilarDiff( ) throws Exception {

        Diff diff = createDiff( file1, file2 );
        assertTrue( diff.toString( ), diff.similar( ) );
    }

    public void testSimilarDiffChangedNodeSequenceAllowed( ) throws Exception {

        Diff diff = createDiff( file1, file2 );
        int ignoreValues[] = { DifferenceConstants.CHILD_NODELIST_SEQUENCE.getId( ) };
        ( (IgnoreTestListener) diffListener ).setIgnoreValues( ignoreValues );
        diff.overrideDifferenceListener( diffListener );
        assertTrue( diff.toString( ), diff.similar( ) );
    }

    public void testSimilarDiff2( ) throws Exception {

        Diff diff = createDiff( file1, file2 );
        int ignoreValues[] = { DifferenceConstants.ATTR_SEQUENCE.getId( ), DifferenceConstants.CHILD_NODELIST_SEQUENCE.getId( ) };
        ( (IgnoreTestListener) diffListener ).setIgnoreValues( ignoreValues );
        diff.overrideDifferenceListener( diffListener );
        assertTrue( diff.toString( ), diff.similar( ) );
    }

    public void testIdentical( ) throws Exception {

        DetailedDiff detailedDiff = new DetailedDiff( createDiff( file1, file2 ) );
        List allDifferences = detailedDiff.getAllDifferences( );
        assertEquals( detailedDiff.toString( ), 0, allDifferences.size( ) );
    }

    protected Diff createDiff( FileReader file1, FileReader file2 ) throws Exception {

        Diff diff = new Diff( file1, file2 );
        diff.overrideElementQualifier( xmiElementQualifier );
        return diff;
    }

    FileReader file1;

    FileReader file2;

    ElementQualifier xmiElementQualifier;

    DifferenceListener diffListener;
}
