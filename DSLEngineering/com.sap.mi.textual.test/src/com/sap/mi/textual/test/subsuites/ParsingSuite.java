/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.furcas.runtime.common.interfaces.MultiplicityBeanTest;
import com.sap.mi.textual.parsing.BibTextMetaLookUpTest;
import com.sap.mi.textual.parsing.MofStubTest;
import com.sap.mi.textual.parsing.TextLocationTest;
import com.sap.mi.textual.parsing.XPathTextMetaLookUpTest;


@RunWith (Suite.class)
@SuiteClasses ( {
    BibTextMetaLookUpTest.class,
    MofStubTest.class,
    MultiplicityBeanTest.class,
    TextLocationTest.class,
    XPathTextMetaLookUpTest.class
})

public class ParsingSuite {

// empty class, no properties, no methods, nothing!!

}