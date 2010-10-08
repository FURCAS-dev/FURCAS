package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Tests generation of TCS Parsers using metamodel in MOIN.
 * uses scenarioTestResource/TCS.tcs to generate a new TCS Parser, and then parses other Syntax definitions for testing. 
 */
public class TCSMoinTest extends ExtendedGeneratedParserBasedTest {

    private static final String DSLSAMPLEDIR = "./scenarioTestResource/";
    
    private static final String LANGUAGE = "TCS";
    
    private static com.sap.furcas.runtime.parser.IModelAdapter adapter;

     
    @BeforeClass
	public static void setupParser() throws Exception {
    	initMetamodelId("demo.sap.com/tcsmeta");
		Set<PRI> priList = MOINTCSMetaConnectionProvider
				.getPartitionsOfMetamodel(metamodelId);
		RefPackage tcsPack = connection
				.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
		adapter = new DefaultTextAwareModelAdapter(new MOINModelAdapter(
				tcsPack, connection, priList, null));
		
		
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		generateParserForLanguage(LANGUAGE);
	}
    
  @Test
  public void testTCS() throws Exception {
      
   
      
      parseFile("TCS.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
      ConcreteSyntax syntax = getTransientSyntax("TCS");
      // TODO do more asserts on syntax, even if no exception is already not bad
  }

  @Test
  public void testKM3() throws Exception {
      parseFile("KM3.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
      ConcreteSyntax syntax = getTransientSyntax("KM3");
      // TODO do more asserts on syntax, even if no exception is already not bad      
  }

  @Test
  public void testLOTOS() throws Exception {
      parseFile("LOTOS.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
      ConcreteSyntax syntax = getTransientSyntax("LOTOS");
      // TODO do more asserts on syntax, even if no exception is already not bad
  }

  @Test
  public void testATL() throws Exception {
      parseFile("ATL.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
      ConcreteSyntax syntax = getTransientSyntax("ATL");
      // TODO do more asserts on syntax, even if no exception is already not bad
  }

  
/**
 * @param name 
 * @return
 */
  private static ConcreteSyntax getTransientSyntax(String name) {
      Collection<RefObject> syntaxList2 = connection.getClass(ConcreteSyntax.CLASS_DESCRIPTOR).refAllOfClass();
      ArrayList<ConcreteSyntax> syntaxList = new ArrayList<ConcreteSyntax>();
    // search result for correct name
      for (Iterator<RefObject> iterator = syntaxList2.iterator(); iterator.hasNext();) {
        RefObject refObject = iterator.next();
        
        if (connection.getTransientPartitions().contains(((Partitionable)refObject).get___Partition())) {
            syntaxList.add((ConcreteSyntax) refObject);
        }
    }
      
      assertNotNull(syntaxList);
      assertEquals(1, syntaxList.size());
      RefObject syntaxRef = syntaxList.iterator().next();
      ConcreteSyntax syntax = null;
      if (syntaxRef instanceof ConcreteSyntax) {
          syntax = (ConcreteSyntax) syntaxRef;
      } else {
          fail("BUG");
      }
      return syntaxList.get(0);
  }


    @Test
    public void testBibTextTCS() throws Exception {
        parseFile("Bibtext.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("Bibtext");
        // TODO do more asserts on syntax, even if no exception is already not bad
    }

    @Test
    public void testBibTextLowerTCS() throws Exception {
        parseFile("BibtextForcedLower.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("BibtextForcedLower");
        // TODO do more asserts on syntax, even if no exception is already not bad
    }
    
    @Test
    public void testBibTextFunctionsTCS() throws Exception {
        parseFile("BibtextWithFunction.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("BibtextWithFunction");
        // TODO do more asserts on syntax, even if no exception is already not bad
    }
    
    @Test
    public void testEnumTCS() throws Exception {
        parseFile("EnumTest.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("EnumTest");
        // TODO do more asserts on syntax, even if no exception is already not bad
//        assertEquals(4, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
//        assertEquals(4, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testExpression() throws Exception {
        parseFile("Expression.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("Expression");
        // TODO do more asserts on syntax, even if no exception is already not bad
//        assertEquals(6, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
//        assertEquals(2, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
//        assertEquals(12, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    
    @Test
    public void testFPath() throws Exception {
        parseFile("FPath.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("FPath");
        // TODO do more asserts on syntax, even if no exception is already not bad
//        assertEquals(10, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
//        assertEquals(3, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
//        assertEquals(13, stubModelHandler.getElementsbyType("TCS::Sequence").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::EnumerationTemplate").size());
    }
    
    @Test
    public void testPeople() throws Exception {
        parseFile("People.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("People");
        // TODO do more asserts on syntax, even if no exception is already not bad
//        assertEquals(10, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
//        assertEquals(3, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
//        assertEquals(13, stubModelHandler.getElementsbyType("TCS::Sequence").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::EnumerationTemplate").size());
    }
    
    @Test
    public void testMultiPackage() throws Exception {
        parseFile("MultiPackage.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("MultiPackage");
        // TODO do more asserts on syntax, even if no exception is already not bad
//        assertEquals(3, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
//        assertEquals(2, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
//        assertEquals(3, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }
    

    
    @Test
    public void testXPath() throws Exception {
        parseFile("XPath.tcs", LANGUAGE, DSLSAMPLEDIR, 0, adapter);
        ConcreteSyntax syntax = getTransientSyntax("XPath");
        // TODO do more asserts on syntax, even if no exception is already not bad
//        assertEquals(28, stubModelHandler.getElementsbyType("TCS::ClassTemplate").size());
//        assertEquals(4, stubModelHandler.getElementsbyType("TCS::PrimitiveTemplate").size());
//        assertEquals(1, stubModelHandler.getElementsbyType("TCS::ConcreteSyntax").size());
//        assertEquals(36, stubModelHandler.getElementsbyType("TCS::Sequence").size());
    }


    
}
