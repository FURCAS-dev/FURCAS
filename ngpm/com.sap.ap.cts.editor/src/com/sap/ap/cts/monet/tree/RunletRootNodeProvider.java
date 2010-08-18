package com.sap.ap.cts.monet.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelmanagement.deploymentunits.DeploymentUnit;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

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
	MQLResultSet deploymentUnitSet = connection.getMQLProcessor().execute(
		"select du from modelmanagement::deploymentunits::DeploymentUnit as du", queryScopeProvider); //$NON-NLS-1$
	EObject[] deploymentUnit = deploymentUnitSet.getRefObjects("du"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(deploymentUnit.length + 1);
	for (int i = 0; i < deploymentUnit.length; i++) {
	    children.add(new GenericRefObjectNode(parent, deploymentUnit[i]));
	}
	return children;
    }

    @Override
    public List<EClass> getTopLevelModelElementTypes(ResourceSet connection) {
	if (connection == null) {
	    return Collections.emptyList();
	} 
	else if (topLevelModelElementTypes == null) {
	    List<EClass> types = new ArrayList<EClass>(1);
	    types.add(connection.getClass(DeploymentUnit.CLASS_DESCRIPTOR).refMetaObject());
	    topLevelModelElementTypes = types;
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
