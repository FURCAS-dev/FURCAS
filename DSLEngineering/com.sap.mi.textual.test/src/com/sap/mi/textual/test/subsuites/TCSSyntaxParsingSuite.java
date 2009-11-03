/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.mi.textual.test.tcf2emf.TestATLSample;
import com.sap.mi.textual.test.tcf2emf.TestBibTextSample;
import com.sap.mi.textual.test.tcf2emf.TestEnumSample;
import com.sap.mi.textual.test.tcf2emf.TestInvalidSyntaxes;
import com.sap.mi.textual.test.tcf2emf.TestLOTOSSample;

@RunWith (Suite.class)
@SuiteClasses ( { 
    TestBibTextSample.class,
    TestATLSample.class,
    TestLOTOSSample.class,
    TestEnumSample.class,
    TestInvalidSyntaxes.class
    
    } )

public class TCSSyntaxParsingSuite {

// empty class, no properties, no methods, nothing!!

}