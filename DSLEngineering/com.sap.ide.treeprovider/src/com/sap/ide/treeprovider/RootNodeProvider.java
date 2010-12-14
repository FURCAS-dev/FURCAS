package com.sap.ide.treeprovider;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;



public interface RootNodeProvider {
    /**
     * Return a list of children tree nodes with <code>parent</code> set as parent.
     * @param parent
     * @param project
     * @param connection
     * @return
     */
    List<ITreeNode<?>> getChildren(Object parent, IProject project, ResourceSet connection);
    
    /**
     * Returns a list of {@link MofClass}es of which instances are allowed on 
     * top level.
     * @return List of {@link MofClass}es.
     */
    List<EClass> getTopLevelModelElementTypes(ResourceSet connection);
    
    /**
     * FIXME: HACK - remove once we have found a viable solution for the PRI creation problem
     * @return
     */
    String getPartionFolderName(); 
    
    /**
     * FIXME: HACK - remove once we have found a viable solution for the PRI creation problem
     * @return
     */
    String getPartitionExtension();

}
