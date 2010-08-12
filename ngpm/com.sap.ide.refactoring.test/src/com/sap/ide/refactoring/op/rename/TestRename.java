package com.sap.ide.refactoring.op.rename;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.junit.Test;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlockChange;
import com.sap.ide.refactoring.test.RefactoringBaseTest;

public class TestRename extends RefactoringBaseTest {

    /**
     * System under test
     */
    private RenameRefactoring sut;
    private RefactoringEditorFacade facade;

    private Change rename(String oldName, String newName) {
	facade = createEditorFacadeForRunletClass(oldName);

	sut = new RenameRefactoring(facade);
	sut.setRenameTarget(facade.getDecoratedDomainRootObject());

	assertTrue(sut.checkInitialConditions(new NullProgressMonitor()).isOK());
	assertTrue(sut.setNewModelElementName(newName).isOK());
	assertEquals(oldName, sut.getOldModelElementName());
	RefactoringStatus finalCheck = sut.checkFinalConditions(new NullProgressMonitor());
	assertTrue(finalCheck.toString(), finalCheck.isOK());
	
	Change change = sut.createChange(new NullProgressMonitor());
	return change;
    }

    @Test
    public void testRenamRefactoringModelChanges() throws Exception {
	Change change = rename("Class1", "NewName");
	assertEquals("Must still have the old name", "Class1", facade.getDecoratedDomainRootObject().refGetValue("name"));
	change.perform(new NullProgressMonitor());

	assertEquals("New name must be set.", "NewName", facade.getDecoratedDomainRootObject().refGetValue("name"));
    }

    @Test
    public void testRenamRefactoringTextChanges() throws Exception {
	Change change = rename("Class1", "NewName");

	assertTrue("Old name must still be present.", facade.getContentAsText().contains("Class1"));
	change.perform(new NullProgressMonitor());

	assertTrue("Old name must no longer be present.", !facade.getContentAsText().contains("Class1"));
	assertTrue("New name must be set.", facade.getContentAsText().contains("NewName"));
    }

    @Test
    public void testRenamRefactoringTextNoChanges() throws Exception {
	Change change = rename("Class1", "Class1");

	assertTrue("Old name must still be present.", facade.getContentAsText().contains("Class1"));
	change.perform(new NullProgressMonitor()); 

	assertTrue("Old name must still be present.", facade.getContentAsText().contains("Class1"));
    }

    /**
     * This is a whitebox test: We make heavy assumption on implementations
     * interna.... Consider rewriting it.
     */
    @Test
    public void testRenamRefactoringPreviewChange() throws Exception {
	CompositeChange compositeChange = (CompositeChange) rename("Class2", "NewName");
	assertNotNull("Mapping must not be broken", facade.getTextBlocksModel().getRoot().getType());

	// If the following breaks we have either changed the way we return
	// changes or a block was not pretty printed as expected and therefore no change
	// object was created.
	TextBlockChange textualChange = null;
	for (Change change :  ((CompositeChange) compositeChange.getChildren()[1]).getChildren()) {
	    if (change instanceof TextBlockChange && change.getModifiedElement().equals(facade.getDecoratedDomainRootObject())) {
		textualChange = (TextBlockChange) change;
	    }
	}

	String preview = textualChange.getPreviewContent(new NullProgressMonitor());
	String current = textualChange.getCurrentContent(new NullProgressMonitor());
	
	assertEquals("Current content must be the actual document", facade.getContentAsText(), current);
	compositeChange.perform(new NullProgressMonitor());

	assertEquals("Preview must be contain the actual changes", facade.getContentAsText(), preview);
    }


}
