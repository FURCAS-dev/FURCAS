package com.sap.tc.moin.ocl.parser.treeviewer;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * This class provides a JTree to view an JMI-graph. When the window is showed,
 * the execution is blocked and will only continue when the window is closed.
 * 
 * @author Thomas Hettel (t.hettel@sap.com)
 */
public class JmiTreeViewer extends JDialog {

    private static final long serialVersionUID = 1L;

    private final JTree tree;

    private transient final TreeNode root;

    /**
     * Creates a JmiTreeViewer
     * 
     * @param obj the root of the graph
     * @param connection the connection
     */
    public JmiTreeViewer( RefObject obj, CoreConnection connection ) {

        super( );
        this.root = new JmiTreeNode( obj, "Root", null, connection ); //$NON-NLS-1$
        DefaultTreeModel model = new DefaultTreeModel( this.root );
        this.tree = new JTree( model );

        JScrollPane scrollPane = new JScrollPane( );
        scrollPane.getViewport( ).add( this.tree );
        getContentPane( ).add( scrollPane );
        setTitle( "JMI Browser" ); //$NON-NLS-1$
    }

}
