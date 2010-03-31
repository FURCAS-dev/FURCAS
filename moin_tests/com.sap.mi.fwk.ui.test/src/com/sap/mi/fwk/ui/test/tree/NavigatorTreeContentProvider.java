package com.sap.mi.fwk.ui.test.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeCopyHandler;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeNavigatorContentProvider;
import com.sap.tc.moin.repository.Connection;

/**
 * Provides all existing Web Dynpro Components. Input is a <code>IProject</code>
 * instance. Tree Structure: NodeRoot - WDComponent
 * 
 * @author d022960
 */
public class NavigatorTreeContentProvider extends TreeNodeNavigatorContentProvider {

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject) {
			IProject project = (IProject) parentElement;
			NodeProjectRoot root = new NodeProjectRoot(project);
			return new Object[] { root };
		}
		if (parentElement instanceof NodeProjectRoot) {
			if (!initializeConnectionDeferred((NodeProjectRoot) parentElement)) {
				// initialization not finished (yet), so return place holder
				// once a connection is available the tree will be refreshed
				return new Object[] { ITreeNode.LOADING_DATA_NODE };
			}
		}
		return super.getChildren(parentElement);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	private static List<Component> getComponents(Connection connection) {
		IPartitionScopeProvider scopeProvider = PartitionService.getInstance()
				.getPartitionScopeProvider(connection, PartitionScope.VISIBLE);
		List<Component> components = QueryService.getInstance().queryInstances(connection, scopeProvider,
				NavigatorTreeEventingTest.CONTAINER_NAME_WEBDYNPRO, NavigatorTreeEventingTest.TYPE_NAME_COMPONENT);
		return components;
	}

	public class NodeProjectRoot extends TreeNodeDomainRoot {
		NodeProjectRoot(IProject project) {
			super(project, project);
		}

		public Object[] getChildren() {
			List<Component> components = NavigatorTreeContentProvider.getComponents(getConnection());
			List<NodeComponent> componentNodes = new ArrayList<NodeComponent>();
			for (Iterator<Component> iterator = components.iterator(); iterator.hasNext();) {
				Component component = (Component) iterator.next();
				componentNodes.add(new NodeComponent(this, component));
			}
			return componentNodes.toArray();
		}

		public boolean hasChildren() {
			return true;
		}

		@Override
		public String toString() {
			return getValue().getName();
		}
	}

	/**
	 * Must be public static so it can be loaded be the extension point for enabling
	 * handlers
	 */
	public static class NodeComponent extends TreeNodeRefObject<Component> implements ITreeNodeTransferHandler, ITreeNodeCopyHandler {
		public ITreeNodeTransfer allowedTr;
		public ITreeNodeTransfer handleTr;
		public ITreeNodeTransfer copyTr;

		NodeComponent(Object parent, Component modelElement) {
			super(parent, modelElement);
		}

		public Object[] getChildren() {
			return ITreeNode.EMPTY_ARRAY;
		}

		public boolean hasChildren() {
			return false;
		}

		public String toString() {
			return getValue().getName();
		}

		public boolean handleTransfer(Object target, ITreeNodeTransfer transfer) {
			handleTr = transfer;
			return true;
		}

		public boolean isTransferAllowed(Object target, ITreeNodeTransfer transfer) {
			allowedTr = transfer;
			return true;
		}

		public boolean handleCopy(Object source, ITreeNodeTransfer transfer) {
			copyTr = transfer;
			return true;
		}
	}
}
