package com.sap.coghead.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;

import coghead.Account;

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

public class CogheadRootNodeProvider implements RootNodeProvider {
    
    private static List<MofClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, Connection connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, connection,
		com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet accountSet = connection.getMQLProcessor().execute(
		"select acc from coghead::Account as acc", queryScopeProvider); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();
	for (RefObject acc : accountSet.getRefObjects("acc")) {
	    children.add(new GenericRefObjectNode(parent, (Account) acc));
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
	    topLevelModelElementTypes.add(connection.getClass(Account.CLASS_DESCRIPTOR).refMetaObject());
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
