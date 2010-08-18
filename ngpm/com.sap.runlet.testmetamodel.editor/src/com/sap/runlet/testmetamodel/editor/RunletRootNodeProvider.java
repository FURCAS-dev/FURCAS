package com.sap.runlet.testmetamodel.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import runlettest.RunletTest;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.RootNodeProvider;


/**
 * Computes the root nodes of the Runlet metamodel which are the deployment
 * units.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class RunletRootNodeProvider implements RootNodeProvider {

    private static List<EClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, ResourceSet connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, connection,
		com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet runletTestTest = connection.getMQLProcessor().execute(
		"select rt from runlettest::RunletTest as rt", queryScopeProvider); //$NON-NLS-1$
	EObject[] runletTest = runletTestTest.getRefObjects("rt"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(runletTest.length + 1);
	for (int i = 0; i < runletTest.length; i++) {
	    children.add(new GenericRefObjectNode(parent, runletTest[i]));
	}
	return children;
    }

    @Override
    public List<EClass> getTopLevelModelElementTypes(ResourceSet connection) {
	if (connection == null) {
	    return Collections.emptyList();
	} 
	else if (topLevelModelElementTypes == null) {
	    topLevelModelElementTypes = new ArrayList<EClass>(1);
	    topLevelModelElementTypes.add(connection.getClass(RunletTest.CLASS_DESCRIPTOR).refMetaObject());
	}
	return topLevelModelElementTypes;
    }

    @Override
    public String getPartionFolderName() {
	return "src";
    }

    @Override
    public String getPartitionExtension() {
	return "types";
    }

}
