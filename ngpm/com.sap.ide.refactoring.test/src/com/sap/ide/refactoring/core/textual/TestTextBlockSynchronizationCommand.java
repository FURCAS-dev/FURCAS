package com.sap.ide.refactoring.core.textual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Ignore;
import org.junit.Test;

import textblocks.TextBlock;

import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor.ChangeType;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A few Pretty Printer smoke tests.
 * 
 */
public class TestTextBlockSynchronizationCommand extends RefactoringBaseTest {

    /**
     * System under test
     */
    private TextBlocksSynchronizationCommand sut;

    private RefactoringEditorFacade facade;

    /**
     * Initialize a sync command which will prettyprint and and shortpretty
     * print the given class.
     * 
     * @param className
     */
    private void initializeForPrettyPrintingOfClass(String className) {
	facade = createEditorFacadeForRunletClass(className);

	Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingPrettyPrinting = new HashMap<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>>();

	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();
	RefObject rootObject = facade.getDecoratedDomainRootObject();

	RootElementTextBlockTuple rootTuple = new RootElementTextBlockTuple(rootObject, rootBlock);
	ModelElementDocumentNodeChangeDescriptor changeDescriptor = new ModelElementDocumentNodeChangeDescriptor(rootObject, rootBlock, ChangeType.CHANGED);
	ArrayList<ModelElementDocumentNodeChangeDescriptor> changeDescriptors = new ArrayList<ModelElementDocumentNodeChangeDescriptor>();
	changeDescriptors.add(changeDescriptor);
	textBlocksNeedingPrettyPrinting.put(rootTuple, changeDescriptors);

	sut = new TextBlocksSynchronizationCommand(facade, textBlocksNeedingPrettyPrinting, textBlocksNeedingPrettyPrinting, new NullProgressMonitor());
    }
    
    private void runAndAssumeNothingChanged(String className) {
	sut.execute();
	
	assertTrue(className, sut.getSynchronizationStatus().isOK());
	assertEquals(className, 1, sut.getTextBlockChanges().size());

	TextBlockChange change = sut.getTextBlockChanges().iterator().next();
	//RefactoringAssertionUtil.assertEqualsIgnoreWhitespacesAndDefaultMultiplicity
	assertEquals(className + " was unchanged; result must be the same", change
	    .getCurrentContent(new NullProgressMonitor()), change.getPreviewContent(new NullProgressMonitor()));
    }

    @Test
    @Ignore // only works once re-parsed
    public void testPrettyPrintSimpleClasses() {
	for (String className : new String[] { "Class2", "Class1", "ClassWithAbstractMethod"}) {
	    initializeForPrettyPrintingOfClass(className);
	    runAndAssumeNothingChanged(className);
	}
    }
    
    @Test
    @Ignore // only works once re-parsed
    public void testPrettyPrintAssocClasses() {
	for (String className : new String[] { "Address", "Person", "City"}) {
	    initializeForPrettyPrintingOfClass(className);
	    runAndAssumeNothingChanged(className);
	}
    }

    @Test
    @Ignore // only works once re-parsed
    public void testPrettyPrintPrimitiveTypeClasses() {
	for (String className : new String[] {"Number", "String", "Binary"}) {
	    initializeForPrettyPrintingOfClass(className);
	    runAndAssumeNothingChanged(className);
	}
    }

}
