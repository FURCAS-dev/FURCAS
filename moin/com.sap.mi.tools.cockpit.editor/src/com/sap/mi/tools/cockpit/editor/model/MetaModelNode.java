package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * @author d003456
 * 
 */
public class MetaModelNode extends TreeNode<String> implements ITreeNodeLabelAware {

	private final VIEWER_MODE mode;

	/**
	 * Creates {@link MetaModelNode}.
	 * 
	 * @param parent
	 * @param metaModelName
	 * @param mode
	 */
	public MetaModelNode(Object parent, String metaModelName, VIEWER_MODE mode) {

		super(parent, metaModelName);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		Assert.isNotNull(mode);
		this.mode = mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		if (this.mode == VIEWER_MODE.PARTITION_BASED) {
			return getChildrenForPartition();
		}
		else {
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

		final ModelPartitionNode parentNode = (ModelPartitionNode) getParent();
		final List<TypeNode> childList = new ArrayList<TypeNode>();
		final List<Partitionable> elementsProMetamodel = parentNode.getRootElementsProMetaModel(getValue());

		if (elementsProMetamodel != null) {
			TreeMap<ModelElement, List<Partitionable>> elementsProMetaObject = new TreeMap<ModelElement, List<Partitionable>>();
			elementsProMetaObject = getElementsProType(elementsProMetamodel);

			for (final Map.Entry<ModelElement, List<Partitionable>> e : elementsProMetaObject.entrySet()) {
				childList.add(new TypeNode(this, e.getKey(), e.getValue(), this.mode));
			}
		}

		return childList.toArray();
	}

	private TreeMap<ModelElement, List<Partitionable>> getElementsProType(Collection<Partitionable> res) {

		final TreeMap<ModelElement, List<Partitionable>> elementsToMetaObjects = new TreeMap<ModelElement, List<Partitionable>>(
				new Comparator<ModelElement>() {
					public int compare(ModelElement o1, ModelElement o2) {

						return (o1.getName() + o1.refMofId()).compareTo(o2.getName() + o2.refMofId());
					}
				});

		for (final Partitionable partitionable : res) {
			List<Partitionable> partElem = new ArrayList<Partitionable>();
			final ModelElement element = getMetaClass((RefBaseObject) partitionable);

			if (element != null) {

				if (elementsToMetaObjects.containsKey(element)) {
					partElem = elementsToMetaObjects.get(element);
					elementsToMetaObjects.remove(element);
				}

				partElem.add(partitionable);
				elementsToMetaObjects.put(element, partElem);

			}
		}

		return elementsToMetaObjects;
	}

	public Collection<Partitionable> getElements(ModelElement key) {

		final ModelPartitionNode parent = (ModelPartitionNode) getParent();
		final Collection<Partitionable> elementsProMetamodel = parent.getElementsProMetamodel(getValue());

		return getElementsProType(elementsProMetamodel).get(key);
	}

	private ModelElement getMetaClass(RefBaseObject o) {

		final Object mo = o.refMetaObject();
		if (mo instanceof ModelElement)
			return (ModelElement) mo;
		return null;
	}

	private Object[] getChildrenForMetaModel() {

		final List<RefPackageNode> childList = new ArrayList<RefPackageNode>();
		final List<RefPackage> packages = getTopLevelPackages();

		for (final RefPackage refPackage : packages) {
			childList.add(new RefPackageNode(this, refPackage, this.mode));
		}
		return childList.toArray();
	}

	private List<RefPackage> getTopLevelPackages() {

		final List<RefPackage> result = new ArrayList<RefPackage>();
		final List<RefPackage> topLevelPackages = ((ProjectRootNode) getParent()).getPackageHierarchy().get(null);

		for (final RefPackage refPackage : topLevelPackages) {
			final ModelElement mEl = getMetaClass(refPackage);
			final String metaModelName = ((Partitionable) mEl).get___Partition().getPri().getContainerName();
			if (metaModelName.equals(getValue()) && !result.contains(metaModelName)) {
				result.add(refPackage);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		return getValue();
	}
}
