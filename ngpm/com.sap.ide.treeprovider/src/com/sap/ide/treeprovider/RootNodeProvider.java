package com.sap.ide.treeprovider;

import java.util.List;

import org.eclipse.core.resources.IProject;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public interface RootNodeProvider {
    /**
     * Return a list of children tree nodes with <code>parent</code> set as parent.
     * @param parent
     * @param project
     * @param connection
     * @return
     */
    List<ITreeNode<?>> getChildren(Object parent, IProject project, Connection connection);
    
    /**
     * Returns a list of {@link MofClass}es of which instances are allowed on 
     * top level.
     * @return List of {@link MofClass}es.
     */
    List<MofClass> getTopLevelModelElementTypes(Connection connection);
    
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
