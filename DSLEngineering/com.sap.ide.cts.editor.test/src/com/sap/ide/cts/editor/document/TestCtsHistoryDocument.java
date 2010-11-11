package com.sap.ide.cts.editor.document;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import modelmanagement.Package;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;
import com.sap.ide.cts.editor.junitcreate.NoSuchSnapshotException;
import com.sap.ide.cts.editor.junitcreate.SnapshotVersion;
import com.sap.ide.cts.editor.test.RunletEditorTest;

import data.classes.SapClass;


/**
 * Tests related to {@link CtsHistoryDocument} and its {@link DocumentHistory}.
 * 
 * @author D049157
 *
 */
public class TestCtsHistoryDocument extends RunletEditorTest {
	
	/** fixed loop counts are stupid in tests, anyway it is needed
	 * to assure that snapshot session do no overlap */
	private final Integer SERIES_COUNT = 5;
	
	private DocumentHistory createProjectSpecificHistoryOn(CtsHistoryDocument doc) {
		DocumentHistory hist = new DocumentHistory(doc, getProject());
		doc.setAndActivateDocumentHistoryForTesting(hist);
		return hist;
	}
	
	@Test
	public void testSetupForTesting() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		createProjectSpecificHistoryOn(document);
		
		assertTrue(document.getDocumentHistory().isActive());
		assertTrue(document.hasActiveDocumentHistory());
		close(editor);
	}

	@Test
	public void testKeylistener() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		assertTrue(document.hasActiveDocumentHistory());
		
		assertEquals("Completed shall be empty", 0, history.getHistory(SnapshotVersion.COMPLETED).size());
		document.replace(0, 1, "c");
		document.replace(0, 2, "cl");
		assertEquals("Completed shall still be empty", 0, history.getHistory(SnapshotVersion.COMPLETED).size());
		
		saveAll(editor); // current session -> completed session 
		assertEquals(2, history.getHistory(SnapshotVersion.COMPLETED).size());
		
		saveAll(editor);
		assertEquals(0, history.getHistory(SnapshotVersion.COMPLETED).size());
		
		assertTrue(history.isActive());
		failOnError(editor);
		close(editor);
	}

	@Test(expected=NoSuchSnapshotException.class)
	public void testSnapshotNeeded() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		close(editor);
		
		history.persistSnapshot("testSnapshotNeeded", SnapshotVersion.COMPLETED);
	}
	
	@Test
	public void testEditorSaveTriggersSnapshotCreation() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		saveAll(editor);
		close(editor);
		
		URI mri = history.persistSnapshot("testEditorSaveTriggersSnapshotCreation", SnapshotVersion.COMPLETED);
		connection.getElement(mri);
	}

	@Test
	public void testNoFailOnSaveAfterClose() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		createProjectSpecificHistoryOn(document);
		
		close(editor);
		saveAll(editor);
	}

	@Test
	public void testSnapshotSeries() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		
		for (int i=0; i<SERIES_COUNT; i++) {
			Boolean success = history.createNewSnapshot(new NullProgressMonitor());
			assertTrue(success);
		}
		assertFalse(connection.isDirty());
		assertTrue(history.isActive());	
		close(editor);
	}
	
	@Test
	public void testCopyPersistSingle() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		
		Boolean success = history.createNewSnapshot(new NullProgressMonitor());
		assertTrue(success);
		URI mri = history.persistSnapshot("TestCopyPersistSingle", SnapshotVersion.COMPLETED);
		assertNotNull("Check for internal errros", mri);
		assertTrue(history.isActive());
		
		assertTrue("Without loading into memory", connection.elementExists(mri));
		EObject copy = (EObject) connection.getElement(mri);
		assertNotNull("With loading into memory", copy);
		
		assertFalse(connection.isDirty());
		Resource partition = copy.get___Partition();
		assertFalse(partition.isDirty());
		assertFalse(partition.hadUnhandledErrorsDuringLoad());
		
		assertNull(copy.refVerifyConstraints(true));
		assertNull(clazz.refVerifyConstraints(true));
		
		close(editor);
	}
	
	@Test
	public void testCopyPersistAndOpen() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		
		// snapshot
		Boolean success = history.createNewSnapshot(new NullProgressMonitor());
		assertTrue(success);
		URI mri = history.persistSnapshot("TestCopyPersistAndOpen", SnapshotVersion.COMPLETED);
		assertNotNull("Check for internal errros", mri);
		assertTrue(history.isActive());
		
		// get and open editor on copy
		SapClass clazzCopy = (SapClass) connection.getElement(mri);
		assertNotNull(clazzCopy);
		AbstractGrammarBasedEditor editorCopy = openEditor(clazzCopy);
		CtsHistoryDocument documentCopy = (CtsHistoryDocument) getDocument(editorCopy);
		failOnError(editorCopy);
		
		assertEquals("Equal textual representation", document.get().replace("Class2", "ClCpy0"), documentCopy.get());
		saveAll(editorCopy);
		failOnError(editorCopy);
				
		close(editor);
		close(editorCopy);
	}
	
	@Test
	public void testDoubleCopyPersistSeriesWithContainerCheck() throws Exception {
		final SapClass clazz = findClass("Class2");
		assertNotNull(clazz);
		AbstractGrammarBasedEditor editor = openEditor(clazz);
		CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
		saveAll(editor); // hack to run on migrated tokens / fixed mapping
		failOnError(editor);
		
		DocumentHistory history = createProjectSpecificHistoryOn(document);
		
		Collection<SapClass> classes = new ArrayList<SapClass>(SERIES_COUNT+1);
		classes.add(clazz);
		for (int i=0; i<SERIES_COUNT; i++) {
			String s = "Iteration " + i +  ": ";
			
			Boolean success = history.createNewSnapshot(new NullProgressMonitor());
			assertTrue(success);
			// calling createNewSnapshot a second time.
			// See testCopyPersistSeries
			success = history.createNewSnapshot(new NullProgressMonitor());
			assertTrue(success);
			
			URI mri = history.persistSnapshot("TestCopyPersistSeries"+i, SnapshotVersion.COMPLETED);
			assertNotNull(s + "Check for internal errros", mri);
			assertTrue(history.isActive());
									
			SapClass copy = (SapClass) connection.getElement(mri);
			assertNotNull(s + "Element lookup with loading into memory", copy);
			assertNull(copy.refVerifyConstraints(true));
			
			Resource partition = copy.get___Partition();
			assertFalse(partition.isDirty());
			assertFalse(partition.hadUnhandledErrorsDuringLoad());
			
			assertNull(copy.refVerifyConstraints(true));
			
			// Assert correct composition hierarchy
			classes.add(copy);
			Package pkg = clazz.getPackage_();
			assertNotNull(pkg);	
			assertEquals(s + "Copy must know its package", pkg, copy.getPackage_());
			assertTrue(s + "Package must know the copy", pkg.getClasses().contains(copy));
			assertTrue(s + "Package must know its classes", pkg.getClasses().containsAll(classes));
		}
		
		assertNull(clazz.refVerifyConstraints(true));		
		close(editor);
	}
	
		
	/**
	 * Keep this test at the end. It triggers yet another MQL query and will fail
	 * if the partitions modified in the previous tests cannot be loaded.
	 * 
	 */
	@Test
	public void testLastAllPartitionsStillLoadable() {
		findClass("Class1");
	}	
}
