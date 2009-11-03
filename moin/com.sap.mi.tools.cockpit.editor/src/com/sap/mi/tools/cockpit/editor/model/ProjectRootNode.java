package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;

/**
 * @author d003456
 * 
 */
public class ProjectRootNode extends TreeNodeDomainRoot implements ITreeNodeLabelAware {

	private static String ROOT_CONTAINER_FRAGMENT = "Root"; //$NON-NLS-1$

	private final Map<RefPackage, List<RefPackage>> packageHierarchy = new HashMap<RefPackage, List<RefPackage>>();

	private ContainerFragment root = null;

	private final VIEWER_MODE mode;

	/**
	 * container path plus partition name -> ModelPartition
	 */
	private TreeMap<String, ModelPartition> allPartitions = new TreeMap<String, ModelPartition>(new ComparatorForPartitions());

	private final TreeMap<RefPackage, TreeMap<ModelElement, List<Partitionable>>> refPackageToTypesToElements = new TreeMap<RefPackage, TreeMap<ModelElement, List<Partitionable>>>(
			new Comparator<RefPackage>() {
				public int compare(RefPackage o1, RefPackage o2) {

					return (o1.toString()).compareTo(o2.toString());
				}
			});

	private TreeMap<List<String>, Partitionable> allElements = new TreeMap<List<String>, Partitionable>(new ComparatorForPackages());

	/**
	 * Creates {@link ProjectRootNode}.
	 * 
	 * @param project
	 * @param mode
	 */
	public ProjectRootNode(Object parent, IProject project, VIEWER_MODE mode) {

		super(parent, project);
		this.root = new ContainerFragment(null, ProjectRootNode.ROOT_CONTAINER_FRAGMENT);
		this.mode = mode;
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		Assert.isNotNull(mode);
	}

	public boolean hasPartitions() {

		return this.allPartitions != null && this.allPartitions.size() > 0;
	}

	public boolean hasElements() {

		return this.allElements != null && this.allElements.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		if (this.mode == VIEWER_MODE.PARTITION_BASED) {
			return getChildrenForPartition();
		} else {
			return getChildrenForMetaModel();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	private Object[] getChildrenForPartition() {

		// to react on MOIN events, read everything new
		this.allPartitions.clear();
		this.allPartitions = getAllPartitions();

		// flat view: insert ModelPArtitionNode for each partition
		if (!MOINBrowserView.isContainerPresentationHierarchical) {
			final List<ModelPartitionNode> childListFlat = new ArrayList<ModelPartitionNode>();
			for (final Map.Entry<String, ModelPartition> e : this.allPartitions.entrySet()) {
				final String name = e.getKey();
				final ModelPartitionNode childNode = new ModelPartitionNode(this, this.allPartitions.get(name), this.mode);
				childListFlat.add(childNode);
			}
			return childListFlat.toArray();
		} else {
			final List<ITreeNode<?>> childList = new ArrayList<ITreeNode<?>>();
			// do not insert elements for each refresh again
			if (this.root.getChildren().length > 0) {
				this.root = new ContainerFragment(null, ProjectRootNode.ROOT_CONTAINER_FRAGMENT);
			}

			// create tree with all containers for calculation purposes
			for (final Map.Entry<String, ModelPartition> e : this.allPartitions.entrySet()) {
				final String name = e.getKey();
				this.root.insertNewString(name, name);
			}

			// calculate fragmented container paths
			final List<ContainerFragment> cf = this.root.getCompactedChildren();
			for (final ContainerFragment containerFragment : cf) {
				if (containerFragment.isLeaf()) {
					childList.add(new ModelPartitionNode(this, this.allPartitions.get(containerFragment.getKey()), this.mode));
				} else {
					childList.add(new ModelPartitionSubPathNode(this, containerFragment, this.mode));
				}
			}
			return childList.toArray();
		}

	}

	private TreeMap<String, ModelPartition> getAllPartitions() {

		final Connection conn = getConnection();
		final Collection<PRI> partitions = PartitionService.getInstance().getPartitions(conn, getValue());

		for (final Iterator<PRI> iterator = partitions.iterator(); iterator.hasNext();) {
			final PRI pri = iterator.next();
			final ModelPartition mp = conn.getPartition(pri);

			if (mp != null && mp.isAlive()) {
				final String pName = mp.getPri().getPartitionName();
				this.allPartitions.put(pName, mp);
			}
		}
		return this.allPartitions;

	}

	public TreeMap<String, ModelPartition> getPartitinsOfProject() {

		if (this.allPartitions == null || this.allPartitions.size() < 1) {
			getAllPartitions();
		}
		return this.allPartitions;
	}

	private void maintainPackageHierarchy(Partitionable element) {

		final RefPackage child = ((RefBaseObject) element).refImmediatePackage();
		final RefPackage parent = child.refImmediatePackage();

		addFromChildToTopLevelPackage(child, parent);
		// ----------------------------------------------
		final ModelElement mEl = getMetaClass((RefBaseObject) element);
		if (this.refPackageToTypesToElements.containsKey(child)) {
			final TreeMap<ModelElement, List<Partitionable>> modElementToPart = this.refPackageToTypesToElements.get(child);
			if (modElementToPart.containsKey(mEl)) {
				final List<Partitionable> elements = modElementToPart.get(mEl);
				elements.add(element);
			} else {
				final List<Partitionable> elements = new ArrayList<Partitionable>();
				elements.add(element);
				modElementToPart.put(mEl, elements);
			}
		} else {
			final List<Partitionable> elements = new ArrayList<Partitionable>();
			elements.add(element);
			final TreeMap<ModelElement, List<Partitionable>> modElementToPart = new TreeMap<ModelElement, List<Partitionable>>(
					new Comparator<ModelElement>() {
						public int compare(ModelElement o1, ModelElement o2) {

							return (o1.getName() + o1.refMofId()).compareTo(o2.getName() + o2.refMofId());
						}
					});
			modElementToPart.put(mEl, elements);
			this.refPackageToTypesToElements.put(child, modElementToPart);
		}

	}

	private void addFromChildToTopLevelPackage(RefPackage child, RefPackage parent) {

		if (!childExists(child)) {
			if (this.packageHierarchy.containsKey(parent)) {
				final List<RefPackage> childs = this.packageHierarchy.get(parent);
				childs.add(child);
			} else {
				final List<RefPackage> childList = new ArrayList<RefPackage>();
				childList.add(child);
				this.packageHierarchy.put(parent, childList);
			}
		}

		child = parent;
		if (child != null) {
			parent = child.refImmediatePackage();
			addFromChildToTopLevelPackage(child, parent);
		}

	}

	private boolean childExists(RefPackage refPackage) {

		final Collection<List<RefPackage>> values = this.packageHierarchy.values();
		for (final List<RefPackage> list : values) {
			if (list.contains(refPackage)) {
				return true;
			}
		}
		return false;
	}

	private Object[] getChildrenForMetaModel() {

		final List<MetaModelNode> childList = new ArrayList<MetaModelNode>();

		// to react on MOIN events, read everything new
		this.allElements.clear();
		// r
		this.allElements = getAllElements();

		final List<String> metaModelnames = getMetaModelNames();
		for (final String metaModelName : metaModelnames) {
			childList.add(new MetaModelNode(this, metaModelName, this.mode));
		}

		return childList.toArray();

	}

	private List<String> getMetaModelNames() {

		List<String> result = new ArrayList<String>();

		if (this.packageHierarchy != null && this.packageHierarchy.size() > 0 && this.packageHierarchy.containsKey(null)) {

			final List<RefPackage> topLevelPackages = this.packageHierarchy.get(null);
			for (final RefPackage refPackage : topLevelPackages) {
				final ModelElement mEl = getMetaClass(refPackage);
				final String metaModelName = ((Partitionable) mEl).get___Partition().getPri().getContainerName();
				if (!result.contains(metaModelName)) {
					result.add(metaModelName);
				}
			}
			Collections.sort(result);

		} else {
			result = Collections.emptyList();
		}

		return result;

	}

	private TreeMap<List<String>, Partitionable> getAllElements() {

		final TreeMap<List<String>, Partitionable> allElements = new TreeMap<List<String>, Partitionable>(new ComparatorForPackages());

		// to react on MOIN events, read everything new
		this.allPartitions.clear();
		this.allPartitions = getAllPartitions();

		for (final Map.Entry<String, ModelPartition> e : this.allPartitions.entrySet()) {
			final Collection<Partitionable> elements = e.getValue().getElements();

			for (final Partitionable partitionable : elements) {
				maintainPackageHierarchy(partitionable);

				final List<String> packagePath = new ArrayList<String>();
				final ModelElement mEl = getMetaClass((RefBaseObject) partitionable);
				final String metaModelName = ((Partitionable) mEl).get___Partition().getPri().getContainerName();
				packagePath.add(metaModelName);
				packagePath.addAll(1, mEl.getQualifiedName());
				packagePath.add(partitionable.refMofId());

				allElements.put(packagePath, partitionable);
			}
		}
		return allElements;
	}

	public Collection<Partitionable> getAllElementsOfProject() {

		Collection<Partitionable> allElementsOfProject = new ArrayList<Partitionable>();
		
		if (this.allElements == null || this.allElements.size() < 1) {
			getAllPartitions();
		}
		for (final Map.Entry<String, ModelPartition> e : this.allPartitions.entrySet()) {
			final Collection<Partitionable> elements = e.getValue().getElements();
			allElementsOfProject.addAll(elements);
		}
		return allElementsOfProject;
	}

	private ModelElement getMetaClass(RefBaseObject o) {

		final Object mo = o.refMetaObject();
		if (mo instanceof ModelElement)
			return (ModelElement) mo;
		return null;
	}

	public Map<RefPackage, List<RefPackage>> getPackageHierarchy() {

		return this.packageHierarchy;
	}

	public TreeMap<RefPackage, TreeMap<ModelElement, List<Partitionable>>> getRefPackageToTypesToElements() {

		return this.refPackageToTypesToElements;
	}

	public ModelPartition getModelPartitionByName(String key) {

		return this.allPartitions.get(key);
	}

	/**
	 * @return the root
	 */
	public ContainerFragment getRoot() {

		return this.root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		final IProject project = getValue();
		final String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
				project.getName(), project);

		if (decoratedProjectName != null && decoratedProjectName.length() > 0) {
			return decoratedProjectName;
		}
		return project.getName();

	}

}
