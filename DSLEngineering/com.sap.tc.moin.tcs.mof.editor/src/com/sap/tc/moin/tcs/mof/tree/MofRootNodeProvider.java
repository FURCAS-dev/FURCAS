package com.sap.tc.moin.tcs.mof.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.RootNodeProvider;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
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
public class MofRootNodeProvider implements RootNodeProvider {

    private static List<MofClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, Connection connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project,
		connection, com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	final QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet deploymentUnitSet = connection.getMQLProcessor().execute(
		"select pkg from Model::Package as pkg", queryScopeProvider); //$NON-NLS-1$
	RefObject[] pkgs = deploymentUnitSet.getRefObjects("pkg"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(pkgs.length + 1);
	for (int i = 0; i < pkgs.length; i++) {
	    children.add(new GenericRefObjectNode(parent, pkgs[i]));
	}
	return children;
    }

    @Override
    public List<MofClass> getTopLevelModelElementTypes(Connection connection) {
	if (connection == null) {
	    return Collections.emptyList();
	} 
	else if (topLevelModelElementTypes == null) {
	    topLevelModelElementTypes = new ArrayList<MofClass>(1);
	    topLevelModelElementTypes.add(connection.getClass(MofPackage.CLASS_DESCRIPTOR).refMetaObject());
	}
	return topLevelModelElementTypes;
    }

    @Override
    public String getPartionFolderName() {
	return "moin/meta";
    }

    @Override
    public String getPartitionExtension() {
	return "moinmm";
    }

}
