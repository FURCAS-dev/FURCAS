package com.sap.mi.fwk.ui.tree.nodes;

import org.eclipse.core.resources.IProject;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeNavigatorContentProvider;
import com.sap.tc.moin.repository.Connection;

/**
 * Tree node for wrapping an <code>IProject</code> reference. The node returns
 * the default connection for the corresponding <code>IProject</code> instance.<br>
 * 
 * @see #getConnection() for details.
 * 
 * @author d022960
 */
public abstract class TreeNodeDomainRoot extends TreeNode<IProject> {
	/**
	 * The default connection of the corresponding project.
	 */
	private Connection mConnection;

	/**
	 * Construction.
	 * 
	 * @param value
	 *            the corresponding project instance this root node belongs to.
	 */
	protected TreeNodeDomainRoot(Object parent, IProject value) {

		super(parent, value);
	}

	@Override
	public Object getAdapter(Class adapter) {

		if (Connection.class.isAssignableFrom(adapter)) {
			return getConnection();
		}
		return super.getAdapter(adapter);
	}

	/**
	 * Returns the default connection for the project wrapped by this tree node
	 * instance.<br>
	 * Note: This method will not create a default connection.
	 * 
	 * @return The default connection or <code>null</code> in case the default
	 *         connection for the corresponding project not been initialized.<br>
	 * 
	 * @see ConnectionManager#getDefaultConnection(IProject, boolean) for
	 *      further details.
	 * 
	 * @see TreeNodeNavigatorContentProvider for further details.
	 */
	final protected Connection getConnection() {
		if (mConnection == null) {
			mConnection = ConnectionManager.getInstance().getExistingDefaultConnection(getValue());
		}
		return mConnection;
	}
}
