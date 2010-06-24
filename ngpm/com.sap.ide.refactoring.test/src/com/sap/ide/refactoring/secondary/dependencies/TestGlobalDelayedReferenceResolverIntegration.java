package com.sap.ide.refactoring.secondary.dependencies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.ConnectionFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

import data.classes.SapClass;

public class TestGlobalDelayedReferenceResolverIntegration extends RefactoringBaseTest {
    
    /**
     * Rename a class that is not referenced from anywhere.
     * It is assumed, that the delayed reference resolver stays calm...
     * 
     * @throws Exception
     */
    @Test
    public void testRenamRefactoringEventTriggering() throws Exception {
	ArrayList<ChangeEvent> eventQueue = new ArrayList<ChangeEvent>();
	registerChangeListener(eventQueue);

	// Rename
	SapClass clazz = findRunletClass("ClassWithAbstractMethod");
	registerReferencesForReevaluation(clazz);
	clazz.setName("NewName");
	
	// for now, just look at the console output
    }

    private void registerChangeListener(final Collection<ChangeEvent> events) {
	final ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(final ChangeEvent event) {
		System.out.println("   >>> " + event);
		events.addAll(Collections.singleton(event));
	    }

	};
	final EventFilter filter = new ConnectionFilter(connection);
	connection.getEventRegistry().registerListener(listener, filter);
    }
    
    private void registerReferencesForReevaluation(SapClass clazz) {
	// quick'n'dirty: just open the editor. It will do the registration
	AbstractGrammarBasedEditor editor = openEditor(clazz);
	getDocument(editor); // finish initialization
    }
}
