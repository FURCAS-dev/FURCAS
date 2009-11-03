package com.sap.mi.tools.cockpit.editor.model;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.properties.PropertyHelper;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserContentProvider;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public final class RefObjectNodeSearcher {

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MODELBROWSER);

	private final static String PROJECT_ROOT_NODE_NOT_FOUND = "ProjectRootNode not found for "; //$NON-NLS-1$

	private final static String START_RUNNABLE = "Start IRunnableWithProgress for "; //$NON-NLS-1$

	private final static String META_MODEL_NODE_NOT_FOUND = "MetaModelNode not found for "; //$NON-NLS-1$

	private final static String TYPE_NODE_NOT_FOUND = "TypeNode not found for "; //$NON-NLS-1$

	private final static String MODEL_PARTITION_NODE_NOT_FOUND = "ModelPartitionNode not found for "; //$NON-NLS-1$

	private final static String MODEL_PARTITION_NOT_FOUND = "Model Partition not found for "; //$NON-NLS-1$

	private final static String PROJECT_NOT_FOUND = "Project not found for "; //$NON-NLS-1$

	private final static String CONTENT_PROVIDER_NULL = "Content  provider is null."; //$NON-NLS-1$

	private final static String REF_OBJECT_NODE_NOT_FOUND = "RefObjectNode not found for "; //$NON-NLS-1$

	private final MOINBrowserView viewer;

	private ProjectRootNode projectRootNodeToSearch;

	private RefObjectNode refObjectNodeToSearch;

	private final PropertyHelper propHelper;

	/**
	 * Creates {@link RefObjectNodeSearcher}.
	 * 
	 * @param viewer
	 *            the {@link MOINBrowserView} viewer
	 */
	public RefObjectNodeSearcher(MOINBrowserView viewer) {

		Assert.isNotNull(viewer);
		this.viewer = viewer;
		this.propHelper = new PropertyHelper();
	}

	/**
	 * Reveals an {@link RefObjectNode} in Model Browser and sets focus on it.
	 * 
	 * @param refObject
	 *            underlying {@link RefObject} of {@link RefObjectNode}
	 * @return <code>true</code>, if node could be revealed, otherwise <code>false</code>
	 */
	public synchronized boolean revealRefObjectNodeinModelTree(final RefObject refObj) {

		boolean revealed = false;
		this.projectRootNodeToSearch = null;
		// can be the outermost composite (parent)
		final RefObject refObject = refObj;
		this.refObjectNodeToSearch = null;

		this.projectRootNodeToSearch = findProjectRootNode(refObject);
		if (this.projectRootNodeToSearch == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.PROJECT_ROOT_NODE_NOT_FOUND + this.propHelper.getQualifiedName(refObject);
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "revealRefObjectNodeinModelTree", msg); //$NON-NLS-1$
			return false;
		}

		String msg = ""; //$NON-NLS-1$
		if (RefObjectNodeSearcher.tracer.debug()) {
			msg = RefObjectNodeSearcher.START_RUNNABLE + this.propHelper.getQualifiedName(refObject);
		}
		RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "revealRefObjectNodeinModelTree", msg); //$NON-NLS-1$

		// now search RefObjectNode
		final IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {

				if (monitor != null) {
					final String progressMonitorLabel = Messages.RefObjectNodeSearcher_0_Xfld;
					monitor.beginTask(MessageFormat.format(progressMonitorLabel, new Object[] {
							RefObjectNodeSearcher.this.propHelper.getQualifiedName(refObj),
							RefObjectNodeSearcher.this.propHelper.tryGetUsefulName(refObj) }), IProgressMonitor.UNKNOWN);
					RefObjectNodeSearcher.this.refObjectNodeToSearch = doFindRefObjectNode(refObj, refObject);
					monitor.done();
				}
			}
		};
		final IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		}
		catch (final InvocationTargetException e) {
			RefObjectNodeSearcher.tracer.error(e.getMessage(), e);
			return false;
		}
		catch (final InterruptedException e) {
			RefObjectNodeSearcher.tracer.error(e.getMessage(), e);
			return false;
		}

		if (this.refObjectNodeToSearch != null) {
			this.viewer.getTreeViewer().setSelection(new StructuredSelection(this.refObjectNodeToSearch), true);
			this.viewer.setFocus();
			revealed = isNodeRevealed(revealed, this.refObjectNodeToSearch);
		}
		return revealed;
	}

	private boolean isNodeRevealed(boolean revealed, RefObjectNode refObjectNode) {

		final ISelection sel = this.viewer.getTreeViewer().getSelection();
		if (!((IStructuredSelection) sel).isEmpty()) {
			final Object obj = ((IStructuredSelection) sel).getFirstElement();
			if (obj instanceof RefObjectNode && refObjectNode.equals(obj)) {
				revealed = true;
			}
		}
		return revealed;
	}

	private RefObjectNode doFindRefObjectNode(RefObject refObj, RefObject refObject) {

		RefObjectNode refObjectNode;
		boolean isComposite = false;

		if (MOINBrowserView.isTopLevelNodePartition && MOINBrowserView.isContainerPresentationHierarchical && !isRootObject(refObject)) {
			isComposite = true;
			refObject = (RefObject) refObject.refOutermostComposite();
		}

		if (MOINBrowserView.isTopLevelNodePartition) {
			if (!this.projectRootNodeToSearch.hasPartitions()) {
				this.projectRootNodeToSearch.getChildren();
			}
			refObjectNode = findRefObjectNodeInPartitionHierarchy(refObj, isComposite, refObject, this.projectRootNodeToSearch);
		} else {
			if (!this.projectRootNodeToSearch.hasElements()) {
				this.projectRootNodeToSearch.getChildren();
			}
			refObjectNode = findRefObjectNodeInMetaModelPackageHierarchy(refObject, this.projectRootNodeToSearch);
		}
		return refObjectNode;
	}

	private RefObjectNode findRefObjectNodeInMetaModelPackageHierarchy(RefObject refObject, ProjectRootNode projectRootNode) {

		final String metaModelName = this.propHelper.getMetaModelName(refObject);
		final MetaModelNode metaModelNode = findMetaModelNode(projectRootNode, metaModelName);
		if (metaModelNode == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.META_MODEL_NODE_NOT_FOUND + metaModelName;
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInMetaModelPackageHierarchy", msg); //$NON-NLS-1$
			return null;
		}

		final List<String> qualifiedName = this.propHelper.getMetaClass(refObject).getContainer().getQualifiedName();
		final List<String> packagePath = new ArrayList<String>(qualifiedName.size());
		for (final String string : qualifiedName) {
			packagePath.add(string);
		}

		final TypeNode typeNode = findTypeNode(metaModelNode, this.propHelper.getMetaClass(refObject), packagePath);
		if (typeNode == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.TYPE_NODE_NOT_FOUND + this.propHelper.getMetaClass(refObject).getName();
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInMetaModelPackageHierarchy", msg); //$NON-NLS-1$
			return null;
		}

		return findRefObjectNode(typeNode, refObject, false, null);
	}

	private RefObjectNode findRefObjectNodeInPartitionHierarchy(RefObject refObj, boolean isComposite, RefObject refObject,
			ProjectRootNode projectRootNode) {

		final String partitionName = this.propHelper.getPartitionName(refObject);
		// essential find criteria is PRI now, not partitionNAme
		final PRI pri = this.propHelper.getPRI(refObject);

		if (projectRootNode.getModelPartitionByName(partitionName) == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.MODEL_PARTITION_NOT_FOUND + partitionName;
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInPartitionHierarchy", msg); //$NON-NLS-1$
			return null;
		}

		final ModelPartitionNode modelPartitionNode = findModelPartitionNode(pri, projectRootNode);
		if (modelPartitionNode == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.MODEL_PARTITION_NODE_NOT_FOUND + partitionName;
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInPartitionHierarchy", msg); //$NON-NLS-1$
			return null;
		}

		final String metaModelName = this.propHelper.getMetaModelName(refObject);
		final MetaModelNode metaModelNode = findMetaModelNode(modelPartitionNode, metaModelName);
		if (metaModelNode == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.META_MODEL_NODE_NOT_FOUND + metaModelName;
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInPartitionHierarchy", msg); //$NON-NLS-1$
			return null;
		}

		final TypeNode typeNode = findTypeNode(metaModelNode, this.propHelper.getMetaClass(refObject), null);
		if (typeNode == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.TYPE_NODE_NOT_FOUND + this.propHelper.getMetaClass(refObject).getName();
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInPartitionHierarchy", msg); //$NON-NLS-1$
			return null;
		}

		return findRefObjectNode(typeNode, refObject, isComposite, refObj);

	}

	private boolean isRootObject(RefObject refObject) {

		final ModelPartition partition = ((Partitionable) refObject).get___Partition();
		final Partitionable parent = refObject.refImmediateComposite();
		if (parent == null || !partition.equals(parent.get___Partition())) {
			return true;
		}
		return false;

	}

	private ProjectRootNode findProjectRootNode(RefObject refObject) {

		ProjectRootNode projectRootNode = null;
		final IProject project = ModelAdapterUI.getInstance().getProject(refObject);
		if (project == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.PROJECT_NOT_FOUND + this.propHelper.getQualifiedName(refObject);
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findProjectRootNode", msg); //$NON-NLS-1$
			return null;
		}
		final IContentProvider conProv = this.viewer.getTreeViewer().getContentProvider();
		if (conProv == null) {
			String msg = ""; //$NON-NLS-1$
			if (RefObjectNodeSearcher.tracer.debug()) {
				msg = RefObjectNodeSearcher.CONTENT_PROVIDER_NULL;
			}
			RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findProjectRootNode", msg); //$NON-NLS-1$
			return null;
		}

		final List<ProjectRootNode> rootNodes = ((MOINBrowserContentProvider) conProv).getRootNodes();
		if (rootNodes != null && rootNodes.size() > 0) {
			for (final ProjectRootNode rootNode : rootNodes) {
				final Connection conn = (Connection) rootNode.getAdapter(Connection.class);
				if (conn != null && conn.isAlive()) {
					if (ModelAdapterUI.getInstance().getProject(conn).equals(project)) {
						projectRootNode = rootNode;
						break;
					}
				}
			}
		}
		return projectRootNode;
	}

	private ModelPartitionNode findModelPartitionNode(PRI pri, ITreeNode<?> treeNode) {

		ModelPartitionNode node = null;
		List<ContainerFragment> compactedChildList = null;
		Object[] childList = null;

		if (treeNode instanceof ProjectRootNode) {
			childList = ((ProjectRootNode) treeNode).getChildren();
			final ContainerFragment root = ((ProjectRootNode) treeNode).getRoot();
			if (MOINBrowserView.isContainerPresentationHierarchical) {
				compactedChildList = root.getCompactedChildren();
			}
		}

		if (treeNode instanceof ModelPartitionSubPathNode) {
			childList = ((ModelPartitionSubPathNode) treeNode).getChildren();
			final ContainerFragment root = ((ModelPartitionSubPathNode) treeNode).getValue();
			compactedChildList = root.getCompactedChildren();
		}

		for (int i = 0; i < childList.length; i++) {
			final Object object = childList[i];
			final ITreeNode<?> n = (ITreeNode<?>) object;

			if (!MOINBrowserView.isContainerPresentationHierarchical) {// no recursion
				if (n instanceof ModelPartitionNode) {
					if (((ModelPartitionNode) n).getPri().equals(pri)) {
						return node = (ModelPartitionNode) n;
					}
				}
			} else if (compactedChildList.get(i).isLeaf()) {
				if (n instanceof ModelPartitionNode) {
					if (((ModelPartitionNode) n).getPri().equals(pri)) {// found it
						return node = (ModelPartitionNode) n;
					}
				}
			} else {
				if (n instanceof ModelPartitionSubPathNode) {
					if (pri.getPartitionName().contains(((ModelPartitionSubPathNode) n).getLabel())) {
						return node = findModelPartitionNode(pri, n);
					}
				}
			}
		}
		return node;
	}

	private MetaModelNode findMetaModelNode(ProjectRootNode projectRootNode, String metaModelName) {

		Object[] childList = null;
		childList = projectRootNode.getChildren();

		if (childList != null && childList.length > 0) {
			for (int i = 0; i < childList.length; i++) {
				final Object object = childList[i];
				if (object instanceof MetaModelNode && ((MetaModelNode) object).getLabel().equals(metaModelName)) {
					return (MetaModelNode) object;
				}
			}
		}
		return null;

	}

	private MetaModelNode findMetaModelNode(ModelPartitionNode modelPartitionNode, String metaModelName) {

		Object[] childList = null;
		childList = modelPartitionNode.getChildren();

		if (childList != null && childList.length > 0) {
			for (int i = 0; i < childList.length; i++) {
				final Object object = childList[i];
				if (object instanceof MetaModelNode && ((MetaModelNode) object).getLabel().equals(metaModelName)) {
					return (MetaModelNode) object;
				}
			}
		}
		return null;

	}

	private TypeNode findTypeNode(ITreeNode<?> treeNode, ModelElement type, List<String> packagePath) {

		Object[] childList = null;

		if (treeNode instanceof MetaModelNode) {
			childList = ((MetaModelNode) treeNode).getChildren();
		}
		if (treeNode instanceof RefPackageNode) {
			childList = ((RefPackageNode) treeNode).getChildren();
		}

		if (childList != null && childList.length > 0) {
			for (int i = 0; i < childList.length; i++) {
				final Object object = childList[i];
				if (object instanceof TypeNode) {
					final ModelElement typeNode = ((TypeNode) object).getValue();
					// String typeNodeName = typeNode.getName();
					if (typeNode.equals(type)) {
						return (TypeNode) object;
					}
				}
				if (object instanceof RefPackageNode) {
					final RefPackageNode refPackageNode = (RefPackageNode) object;
					if (packagePath != null && !packagePath.isEmpty() && packagePath.get(0).equals(refPackageNode.getLabel())) {
						packagePath.remove(0);
						return findTypeNode(refPackageNode, type, packagePath);
					}
				}
			}
		}
		return null;

	}

	private RefObjectNode findRefObjectNode(TypeNode typeNode, RefObject refObject, boolean isComposite, RefObject composite) {

		Object[] childList = null;
		RefObjectNode outerMostComp = null;
		childList = typeNode.getChildren();

		if (childList != null && childList.length > 0) {
			for (int i = 0; i < childList.length; i++) {
				final Object object = childList[i];
				if (object instanceof RefObjectNode && ((RefObjectNode) object).getValue().equals(refObject)) {
					if (!isComposite) {
						return (RefObjectNode) object;
					} else {
						outerMostComp = (RefObjectNode) object;
						break;
					}
				}
			}
			if (outerMostComp != null) {
				final TreePath path = findTreePath(refObject, composite, TreePath.EMPTY);
				for (int i = 0; i < path.getSegmentCount(); i++) {
					final Object object = path.getSegment(i);
					outerMostComp = findRefObjectNodeInCollectionAndCompositeAssociation((RefObject) object, outerMostComp);
				}
				if (outerMostComp != null) {
					return outerMostComp;
				}
			}
		}
		return null;
	}

	private RefObjectNode findRefObjectNodeInCollectionAndCompositeAssociation(RefObject refObject, RefObjectNode refObjectNode) {

		final Object[] childList = refObjectNode.getChildren();
		;

		if (childList != null && childList.length > 0) {
			for (int i = 0; i < childList.length; i++) {
				final Object object = childList[i];

				// single- and multiple-valued (object) properties are always in ColectionNode
				if (object instanceof CollectionNode) {
					final CollectionNode collNode = (CollectionNode) object;
					final Object[] cList = collNode.getChildren();
					final RefObjectNode node = findRefObjectInChildList(refObject, cList);
					if (node != null) {
						return node;
					}
				}
				if (object instanceof AssociationEndNode && ((AssociationEndNode) object).isComposite()) {
					final AssociationEndNode ass = (AssociationEndNode) object;
					final Object[] cList = ass.getChildren();
					final RefObjectNode node = findRefObjectInChildList(refObject, cList);
					if (node != null) {
						return node;
					}
				}
			}
		}
		String msg = ""; //$NON-NLS-1$
		if (RefObjectNodeSearcher.tracer.debug()) {
			msg = RefObjectNodeSearcher.REF_OBJECT_NODE_NOT_FOUND + this.propHelper.getQualifiedName(refObject);
		}
		RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectNodeInCollectionAndCompositeAssociation", msg); //$NON-NLS-1$
		return null;
	}

	private RefObjectNode findRefObjectInChildList(RefObject refObject, Object[] cList) {

		if (cList != null && cList.length > 0) {
			for (int j = 0; j < cList.length; j++) {
				final Object obj = cList[j];
				if (obj instanceof RefObjectNode && ((RefObjectNode) obj).getValue().equals(refObject)) {
					return (RefObjectNode) obj;
				}
			}
		}
		String msg = ""; //$NON-NLS-1$
		if (RefObjectNodeSearcher.tracer.debug()) {
			msg = RefObjectNodeSearcher.REF_OBJECT_NODE_NOT_FOUND + this.propHelper.getQualifiedName(refObject);
		}
		RefObjectNodeSearcher.tracer.debug(RefObjectNodeSearcher.class, "findRefObjectInChildList", msg); //$NON-NLS-1$
		return null;

	}

	private TreePath findTreePath(RefObject outerMost, RefObject refObj, TreePath treePath) {

		if (refObj.equals(outerMost)) {
			return treePath;
		} else {
			treePath = findTreePath(outerMost, (RefObject) refObj.refImmediateComposite(), treePath);
			return treePath.createChildPath(refObj);
		}

	}
}