package com.sap.mi.fwk.ui.test.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.ide.metamodel.webdynpro.WebDynproPackage;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeContentProvider;
import com.sap.tc.moin.repository.Connection;

/**
 * Provides all existing Web Dynpro Components. Input is a <code>IProject</code>
 * instance. Tree Structure: NodeRoot - WDComponent
 * 
 * @author d022960
 */
public class EditorTreeContentProvider extends TreeNodeContentProvider {

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof WebDynproPackage) {
			NodeWebDynproPackageRoot root = new NodeWebDynproPackageRoot((WebDynproPackage) parentElement);
			return new Object[] { root };
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
				EditorTreeEventingTest.CONTAINER_NAME_WEBDYNPRO, EditorTreeEventingTest.TYPE_NAME_COMPONENT);
		return components;
	}

	private static class NodeWebDynproPackageRoot extends TreeNode<WebDynproPackage> {
		NodeWebDynproPackageRoot(WebDynproPackage webDynproPackage) {
			super(webDynproPackage, webDynproPackage);
		}

		public Object[] getChildren() {
			List<Component> components = EditorTreeContentProvider.getComponents(ModelAdapter.getInstance().getConnection(getValue()));
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
			return "WebDynproPackageRoot";
		}
	}

	private static class NodeComponent extends TreeNodeRefObject<Component> {
		NodeComponent(Object parent, Component modelElement) {
			super(parent, modelElement);
		}

		public Object[] getChildren() {
			return ITreeNode.EMPTY_ARRAY;
		}

		public boolean hasChildren() {
			return false;
		}

		@Override
		public String toString() {
			return getValue().getName();
		}
	}
}
