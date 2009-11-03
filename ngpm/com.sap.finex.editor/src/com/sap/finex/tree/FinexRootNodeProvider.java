package com.sap.finex.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;

import structure.FinexClass;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.RootNodeProvider;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

/**
 * Computes the root nodes of the Runlet metamodel which are the deployment
 * units.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class FinexRootNodeProvider implements RootNodeProvider {

    private static List<MofClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, Connection connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, connection,
		com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet deploymentUnitSet = connection.getMQLProcessor().execute(
		"select t from structure::FinexClass as t where t.owner = null", queryScopeProvider); //$NON-NLS-1$
	RefObject[] deploymentUnit = deploymentUnitSet.getRefObjects("t"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(deploymentUnit.length + 1);
	for (int i = 0; i < deploymentUnit.length; i++) {
	    children.add(new GenericRefObjectNode(parent, deploymentUnit[i]));
	}
	return children;
    }

    @Override
    public List<MofClass> getTopLevelModelElementTypes(Connection connection) {
	if (connection == null) {
	    return Collections.emptyList();
	} 
	else if (topLevelModelElementTypes == null) {
	    List<MofClass> types = new ArrayList<MofClass>(1);
	    types.add(connection.getClass(FinexClass.CLASS_DESCRIPTOR).refMetaObject());
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
