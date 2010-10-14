package org.eclipse.emf.query2.librarytest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { LibraryTransformation.class, IndexQueryCountTest.class })
public class LibraryTestSuite extends QueryTestCase {

}
