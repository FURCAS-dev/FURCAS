package com.sap.mi.tcs.editor.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.RootNodeProvider;


/**
 * Computes the root nodes of the TCS metamodel which are the deployment
 * units.
 * 
 * 
 */
public class TcsRootNodeProvider implements RootNodeProvider {

    private static List<EClass> topLevelModelElementTypes;

    @Override
    public List<ITreeNode<?>> getChildren(Object parent, IProject project, ResourceSet connection) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, connection,
		com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet concreteSytnaxes = connection.getMQLProcessor().execute(
		"select cs from TCS::ConcreteSyntax as cs", queryScopeProvider); //$NON-NLS-1$
	EObject[] concreteSytnax = concreteSytnaxes.getRefObjects("cs"); //$NON-NLS-1$
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>(concreteSytnax.length + 1);
	for (int i = 0; i < concreteSytnax.length; i++) {
	    children.add(new GenericRefObjectNode(parent, (ConcreteSyntax) concreteSytnax[i]));
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
