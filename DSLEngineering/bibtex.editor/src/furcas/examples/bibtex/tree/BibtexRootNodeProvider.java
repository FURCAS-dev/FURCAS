package furcas.examples.bibtex.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;

import tcs.ConcreteSyntax;

import bibtex.LiteratureDb;

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

public class BibtexRootNodeProvider implements RootNodeProvider {
    
    private static List<MofClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, Connection connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, connection,
		com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet concreteSytnaxes = connection.getMQLProcessor().execute(
		"select db from Bibtex::LiteratureDb as db", queryScopeProvider); //$NON-NLS-1$
	RefObject[] db = concreteSytnaxes.getRefObjects("db"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(db.length + 1);
	for (int i = 0; i < db.length; i++) {
	    children.add(new GenericRefObjectNode(parent, (LiteratureDb) db[i]));
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
	    topLevelModelElementTypes.add(connection.getClass(LiteratureDb.CLASS_DESCRIPTOR).refMetaObject());
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
