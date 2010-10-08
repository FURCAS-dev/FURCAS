/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.mi.textual.test.util.MOINContainerNameLookUpFactory;

/**
 * Tests grammar generation using a Moin in Eclipse connection for runtime JMI classes.
 */
public class TestMoinGrammarGenWithTCSMeta extends AbstractMoinPluginParserGenerationTest {

    private static Connection connection;
//    private static PRI nullPRI = null;
    
    private static final String DSLSAMPLEDIR = "./scenarioTestResource/";
    private static final String LANGUAGE = "TCS";
    
    @BeforeClass
    public static void setup() {
        try {
            connection = ConnectionManager.getInstance().createTransientConnection();
        } catch(IllegalStateException ex) {
            if (ex.getMessage().equals("Workspace is closed.")) {
                fail("Test can only be run as Eclipse Plugin Test.");
            } else {
                throw ex;
            }
        }
//        final IPath modelpath = new Path("src/");
//        PartitionService partitionService = PartitionService.getInstance();
//        ModelPartition mp = partitionService.getPartition(connection, project, modelpath);
//        nullPRI = partitionService.getPri(dataAreaName, containerName, null);
    }
    
    @AfterClass
    public static void tearDown() {
        if(connection != null) {
            connection.close();
        }
    
    }
  
    @Test
    @Ignore
    public void testTCSParsing() throws Exception {
        // TODO use target platform workspace for file generation and build?
        fail("Test setup does not work because launched platform uses a different classloader.");
        // else, to test, delete files in mointTest/generated (if any), and run the test twice, with a refresh on the directory in between.
        
        // generates parser by transiently creating RefObjects in transient connection
		generateParser(
				LANGUAGE,
				MOINContainerNameLookUpFactory
						.getMOINContainerNameLookUpFactory(TcsPackage.PACKAGE_DESCRIPTOR
								.getModelContainerName()), new HashSet<PRI>(),
				connection);
        
        // clear elements of transient connection
        connection.getNullPartition().deleteElements();
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapter adapter = new MOINModelAdapter(rootPkg, connection, null, null);
        DefaultTextAwareModelAdapter adapterWrapper = new DefaultTextAwareModelAdapter(adapter);
        
        InputStream charStream = new FileInputStream(DSLSAMPLEDIR + "TCS.tcs");
        
        // try parsing the language sample into transient partition
        doParseFromStream(LANGUAGE, 0, charStream, adapterWrapper);
        
        RefObject[] arrSyntax = adapter.getElementsOfType("TCS::ConcreteSyntax");
        assertEquals(1, arrSyntax.length);
//        for (int i = 0; i < arrArticle.length; i++) {
//            ConcreteSyntax syntax = (ConcreteSyntax) arrArticle[i];
//            assertNotNull(syntax);
//            assertNotNull(syntax.refGetValue("templates"));
//        }
        
//        RefObject[] arrAuthor = adapter.getElementsOfType("BibText::Author");
//        assertEquals(3, arrAuthor.length);
//        for (int i = 0; i < arrAuthor.length; i++) {
//            Author author = (Author) arrAuthor[i];
//            assertNotNull(author);
//            assertNotNull(author.getName());
//            assertNotNull(author.refGetValue("name"));
//        }
        
        // TODO test references
        
//        RefObject[] arrAsso = adapter.getElementsOfType("BibText::AuthorArticle");
//        assertEquals(3, arrAuthor.length);
//        for (int i = 0; i < arrAuthor.length; i++) {
//            AuthorArticle ref = (AuthorArticle) arrAuthor[i];
//            assertTrue(ref.getArticle());
//        }
    }
    
}
