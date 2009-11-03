package com.sap.river.metadata.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.SapClass;

public class CreateSaveLoadTest extends TestCase {
    private Moin moin;
    
    public void setUp() {
	moin = MoinFactory.getMoinInstance();
    }
    
    private Connection getConnection() {
	CompoundDataAreaManager cdam = moin.getCompoundDataAreaManager();
	Session session = moin.createSession(cdam.getCompoundClientSpecTransientOnly());
	return session.createConnection("CreatesaveLoadTest");
    }
    
    public void testNgpmStdlibPresence() {
	IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("LocalDevelopment~LocalDevelopment~ngpm.stdlib~demo.sap.com");
	try {
	    project.open(/* progress monitor */ null);
	    Connection conn = ModelManager.getConnectionManager().createConnection(project);
	    Collection<RefObject> allClasses = conn.getClass(SapClass.CLASS_DESCRIPTOR).refAllOfClass();
	    List<String> expectedTypes = new ArrayList<String>(Arrays.asList( "Boolean", "String", "Number", "Binary" ));
	    for (RefObject ro:allClasses) {
		assertTrue(ro instanceof SapClass);
		expectedTypes.remove(((SapClass) ro).getName());
	    }
	    assertEquals(0, expectedTypes.size());
	} catch (CoreException e) {
	    throw new RuntimeException(e);
	}
    }
    
    public void testFindMetamodel() {
	Connection conn = getConnection();
	SapClass clazz = conn.createElement(SapClass.CLASS_DESCRIPTOR);
	clazz.setName("MyFirstClass");
	assertEquals("MyFirstClass", clazz.getName());
    }
    
    public void testStore() {
	IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("LocalDevelopment~LocalDevelopment~ngpm.stdlib~demo.sap.com");
	try {
	    project.open(/* progress monitor */ null);
	    Connection conn = ModelManager.getConnectionManager().createConnection(project);
	    PRI pri = moin.getFacilityById("PF").getRIFactory().createPri(
		    "PF.LocalDevelopment[local]:DCs/demo.sap.com/ngpm.stdlib/_comp/src/testpartition.types");
	    if (conn.partitionExists(pri)) {
		conn.getPartition(pri).delete();
	    }
	    ModelPartition partition = conn.createPartition(pri);
	    SapClass clazz = conn.createElement(SapClass.CLASS_DESCRIPTOR);
	    clazz.setName("MySecondClass");
	    partition.assignElementIncludingChildren(clazz);
	    conn.save();
	    conn = ModelManager.getConnectionManager().createConnection(project);
	    ModelPartition loadedPartition = conn.getPartition(pri);
	    assertEquals(1, loadedPartition.getElements().size());
	    boolean found = false;
	    for (Partitionable p:loadedPartition.getElements()) {
		if (p.equals(clazz)) {
		    found = true;
		}
	    }
	    assertTrue(found);
	    loadedPartition.delete();
	    conn.save();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
}
