package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * @author d003456
 * 
 */
public final class ModelPartitionNode extends TreeNode<ModelPartition> implements ITreeNodeLabelAware {

	private final VIEWER_MODE mode;

	/**
	 * Creates {@link ModelPartitionNode}.
	 * 
	 * @param parent
	 * @param modelPartition
	 * @param mode
	 */
	public ModelPartitionNode(ITreeNode<?> parent, ModelPartition modelPartition, VIEWER_MODE mode) {

		super(parent, modelPartition);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		Assert.isNotNull(mode);
		this.mode = mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public final Object[] getChildren() {

		Map<String, List<Partitionable>> elementsProMetaModel = new TreeMap<String, List<Partitionable>>();
		final List<MetaModelNode> childList = new ArrayList<MetaModelNode>();

		Collection<Partitionable> res = Collections.emptyList();
		try {
			res = PartitionService.getInstance().getRootElements(getValue());
			// res = ((ModelPartition)getUnderlyingObject()).getElements();
		}
		catch (final Exception ex) { // class Cast Exception , wrong MOIN
			// implementation
			res = Collections.emptyList();
		}

		elementsProMetaModel = getElementsProMetaModel(res);

		for (final Map.Entry<String, List<Partitionable>> e : elementsProMetaModel.entrySet()) {
			childList.add(new MetaModelNode(this, e.getKey(), this.mode));
		}

		return childList.toArray(new Object[childList.size()]);
	}

	private Map<String, List<Partitionable>> getElementsProMetaModel(Collection<Partitionable> res) {

		final Map<String, List<Partitionable>> elementsProMetaModell = new HashMap<String, List<Partitionable>>();

		for (final Partitionable partitionable : res) {
			List<Partitionable> partitionElement = new ArrayList<Partitionable>();
			final ModelElement mEl = getMetaClass((RefBaseObject) partitionable);
			final String metaModelName = ((Partitionable) mEl).get___Partition().getPri().getContainerName();

			if (metaModelName != null) {

				if (elementsProMetaModell.containsKey(metaModelName)) {
					partitionElement = elementsProMetaModell.get(metaModelName);
					elementsProMetaModell.remove(metaModelName);
				}

				partitionElement.add(partitionable);
				elementsProMetaModell.put(metaModelName, partitionElement);

			}
		}

		return elementsProMetaModell;
	}

	public Collection<Partitionable> getElementsProMetamodel(String key) {

		Collection<Partitionable> res = Collections.emptyList();
		res = getValue().getElements();

		return getElementsProMetaModel(res).get(key);
	}

	public List<Partitionable> getRootElementsProMetaModel(String key) {

		Collection<Partitionable> res = Collections.emptyList();
		try {
			res = PartitionService.getInstance().getRootElements(getValue());
			// res = ((ModelPartition)getUnderlyingObject()).getElements();
		}
		catch (final Exception ex) { // class Cast Exception , wrong MOIN
			// implementation
			res = Collections.emptyList();
		}
		return getElementsProMetaModel(res).get(key);

	}

	private ModelElement getMetaClass(RefBaseObject o) {

		final Object mo = o.refMetaObject();
		if (mo instanceof ModelElement)
			return (ModelElement) mo;
		return null;
	}

	public PRI getPri() {

		if (getValue() == null)
			return null;
		return getValue().getPri();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		String label = MOINBrowserLabelProvider.UNKNOWN_LABEL;
		label = getValue().getPri().getPartitionName();
		if (MOINBrowserView.isContainerPresentationHierarchical) {
			label = label.substring(label.lastIndexOf("/") + 1); //$NON-NLS-1$
		}
		return label;
	}
}
