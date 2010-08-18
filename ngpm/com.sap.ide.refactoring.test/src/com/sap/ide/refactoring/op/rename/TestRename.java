package com.sap.ide.refactoring.op.rename;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.stream.EventFilter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.ide.refactoring.core.TextBlockChange;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.test.RefactoringBaseTest;

public class TestRename extends RefactoringBaseTest {

    /**
     * System under test
     */
    private RenameRefactoring sut;

    private RefactoringEditorFacade facade;

    private Change rename(String oldName, String newName) throws CoreException {
	facade = createEditorFacadeForRunletClass("Class1");

	sut = new RenameRefactoring(facade);
	sut.setRenameTarget(facade.getDecoratedDomainRootObject());

	assertTrue(sut.checkInitialConditions(new NullProgressMonitor()).isOK());
	assertTrue(sut.setNewModelElementName(newName).isOK());
	assertEquals(oldName, sut.getOldModelElementName());
	assertTrue(sut.checkFinalConditions(new NullProgressMonitor()).isOK());

	Change change = sut.createChange(new NullProgressMonitor());
	return change;
    }

    @Test
    public void testRenamRefactoringModelChanges() throws Exception {
	Change change = rename("Class1", "NewName");
	assertEquals("Must still have the old name", "Class1", facade.getDecoratedDomainRootObject().refGetValue("name"));
	change.perform(new NullProgressMonitor()); // apply the actual refactoring

	assertEquals("New name must be set.", "NewName", facade.getDecoratedDomainRootObject().refGetValue("name"));
    }

    @Test
    public void testRenamRefactoringTextChanges() throws Exception {
	Change change = rename("Class1", "NewName");

	assertTrue("Old name must still be present.", facade.getContentAsText().contains("Class1"));
	change.perform(new NullProgressMonitor()); // apply the actual refactoring

	assertTrue("Old name must no longer be present.", !facade.getContentAsText().contains("Class1"));
	assertTrue("New name must be set.", facade.getContentAsText().contains("NewName"));
    }

    @Test
    public void testRenamRefactoringTextNoChanges() throws Exception {
	Change change = rename("Class1", "Class1");

	assertTrue("Old name must still be present.", facade.getContentAsText().contains("Class1"));
	change.perform(new NullProgressMonitor()); // apply the actual refactoring

	assertTrue("Old name must still be present.", facade.getContentAsText().contains("Class1"));
    }

    /**
     * This is a whitebox test: We make heavy assumption on implementations interna...
     */
    @Test
    public void testRenamRefactoringPreviewChange() throws Exception {
	CompositeChange change = (CompositeChange) rename("Class1", "NewName");
	assertNotNull("Mapping must not be broken", facade.getTextBlocksModel().getRoot().getType());

	// If the following breaks we have either changed the way we return changes
	// or a block was not pretty printed as expected and therefore no change object was created.
	TextBlockChange textualChange = (TextBlockChange) ((CompositeChange) change.getChildren()[1]).getChildren()[0];


	String preview = textualChange.getPreviewContent(new NullProgressMonitor());
	String current = textualChange.getCurrentContent(new NullProgressMonitor());

	assertEquals("Current content must be the actual document", facade.getContentAsText(), current);
	textualChange.perform(new NullProgressMonitor()); // apply the actual refactoring

	assertEquals("Preview must be contain the actual changes", facade.getContentAsText(), preview);
    }

    /**
     * Rename is supposed to trigger a suitable AttributeChangeEvent.
     *
     * This test FAILS and is therefore ignored: Events are triggered
     * on undo, though the documentation denies that...
     */
    @Test
    @Ignore
    public void testRenamRefactoringEventTriggering() throws Exception {
	// setup means to handle all triggered events
	final Collection<AttributeValueChangeEvent> events = new ArrayList<AttributeValueChangeEvent>();
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		 System.out.println("   >>> " + event);
		 if (!(event instanceof AttributeValueChangeEvent)) {
		    fail("Received unexpected event " + event);
		}
		events.add((AttributeValueChangeEvent) event);
	    }

	};
	EventFilter filter = new ConnectionFilter(connection);
	connection.getEventRegistry().registerListener(listener, filter);

	// Rename
	Change change = rename("Class1", "NewName");
	change.perform(new NullProgressMonitor()); // apply the actual refactoring

	// Make sure we received events that indicate the refactorin
	for (AttributeValueChangeEvent event : events) {
	    assertEquals("Received event " + event, "Class1", event.getOldValue());
	    assertEquals("Received event " + event, "NewName", event.getNewValue());
	}
    }

}
