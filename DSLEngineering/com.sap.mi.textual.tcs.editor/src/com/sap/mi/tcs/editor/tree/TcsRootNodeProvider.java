package com.sap.mi.tcs.editor.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;

import tcs.ConcreteSyntax;

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
 * Computes the root nodes of the TCS metamodel which are the deployment
 * units.
 * 
 * 
 */
public class TcsRootNodeProvider implements RootNodeProvider {

    private static List<MofClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, Connection connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, connection,
		com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet concreteSytnaxes = connection.getMQLProcessor().execute(
		"select cs from TCS::ConcreteSyntax as cs", queryScopeProvider); //$NON-NLS-1$
	RefObject[] concreteSytnax = concreteSytnaxes.getRefObjects("cs"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(concreteSytnax.length + 1);
	for (int i = 0; i < concreteSytnax.length; i++) {
	    children.add(new GenericRefObjectNode(parent, (ConcreteSyntax) concreteSytnax[i]));
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
	    topLevelModelElementTypes.add(connection.getClass(ConcreteSyntax.CLASS_DESCRIPTOR).refMetaObject());
	}
	return topLevelModelElementTypes;
    }

    @Override
    public String getPartionFolderName() {
	return "mappings";
    }

    @Override
    public String getPartitionExtension() {
	return "xmi";
    }

}
