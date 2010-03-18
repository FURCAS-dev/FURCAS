package com.sap.ide.cts.editor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import modelmanagement.Package;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsHistoryDocument;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;
import com.sap.ide.cts.editor.junitcreate.SnapshotVersion;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;

import data.classes.SapClass;

public class FailingEditingActions extends RunletEditorTest {

    /**
     * (from TestCtsHistoryDocument)
     * 
     * This testcase fails due to a potential bug in MOIN. For a problem
     * description see {@link DocumentHistory#persistSnapshot(String)}
     * 
     * Only real difference to the existing testcase in TestCtsHistoryDocument
     * is that here we only create one snapshot per iteration
     */
    @Test
    public void testCopyPersistSeriesWithContainerCheck() throws Exception {
	int SERIES_COUNT = 3;

	final SapClass clazz = findClass("Class2");
	assertNotNull(clazz);
	AbstractGrammarBasedEditor editor = openEditor(clazz);
	CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
	saveAll(editor); // hack to run on migrated tokens / fixed mapping
	failOnError(editor);

	DocumentHistory history = new DocumentHistory(document, getProject());
	document.setAndActivateDocumentHistoryForTesting(history);

	Collection<SapClass> classes = new ArrayList<SapClass>(SERIES_COUNT + 1);
	classes.add(clazz);
	for (int i = 1; i <= SERIES_COUNT; i++) {
	    String s = "Iteration " + i + ": ";

	    Boolean success = history.createNewSnapshot(new NullProgressMonitor());
	    assertTrue(success);
	    // history.hack();

	    MRI mri = history.persistSnapshot("TestCopyPersistSeries" + i, SnapshotVersion.COMPLETED);
	    assertNotNull(s + "Check for internal errros", mri);

	    assertTrue(history.isActive());

	    SapClass copy = (SapClass) connection.getElement(mri);
	    assertNotNull(s + "Element lookup with loading into memory", copy);
	    assertNull(copy.refVerifyConstraints(true));

	    ModelPartition partition = copy.get___Partition();
	    assertFalse(partition.isDirty());
	    assertFalse(partition.hadUnhandledErrorsDuringLoad());

	    assertNull(copy.refVerifyConstraints(true));

	    // Assert correct composition hierarchy
	    classes.add(copy);
	    Package pkg = clazz.getPackage();
	    assertNotNull(pkg);
	    assertEquals(s + "Copy must know its package", pkg, copy.getPackage());
	    assertTrue(s + "Package must know the copy", pkg.getClasses().contains(copy));
	    assertTrue(s + "Package must know its classes", pkg.getClasses().containsAll(classes));
	}

	assertNull(clazz.refVerifyConstraints(true));
	close(editor);
    }

    

}
