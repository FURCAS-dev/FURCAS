package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.tools.cockpit.editor.model.properties.MOINModelBrowserPropertySourceManager;
import com.sap.mi.tools.cockpit.editor.model.properties.PropertyHelper;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A node in the Model Browser tree that represents and wraps an instance of a RefObject.
 * 
 * @author d003456
 * 
 */
public class RefObjectNode extends TreeNodeRefObject<RefObject> implements IAdaptable, ITreeNodeLabelAware {

	private PropertyHelper propertyHelper;

	/**
	 * Creates {@link RefObjectNode}.
	 * 
	 * @param parent
	 * @param refObject
	 */
	public RefObjectNode(ITreeNode<?> parent, RefObject refObject) {

		super(parent, refObject);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		this.propertyHelper = new PropertyHelper();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public final Object[] getChildren() {

		final List<ITreeNode<?>> childList = new ArrayList<ITreeNode<?>>();

		final Connection conn = getConnection();
		final JmiHelper jmiHelper = conn.getJmiHelper();
		final Map<Attribute, Object> attributesAndValues = jmiHelper.getAttributesWithValues(this.getValue(), true);

		final RefObject metaObject = this.getValue().refMetaObject();
		if (metaObject != null) {
			final MetaObjectNode metaObjectNode = new MetaObjectNode(this, metaObject);
			childList.add(metaObjectNode);
		}

		// process attributes
		if (!attributesAndValues.isEmpty()) {

			calculateChildrenForAttributes(childList, attributesAndValues);
		}

		// process associations
		calculateChildrenForAssociations(childList, jmiHelper);

		return childList.toArray(new Object[childList.size()]);
	}

	private void calculateChildrenForAssociations(List<ITreeNode<?>> childList, final JmiHelper jmiHelper) {

		final MofClass metaObj = (MofClass) this.getValue().refMetaObject();
		final Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds(metaObj, true);
		final List<AssociationEnd> sortedAssociationEnds = new ArrayList<AssociationEnd>();

		for (final AssociationEnd associationEnd : associationEnds) {
			sortedAssociationEnds.add(associationEnd);
		}

		Collections.sort(sortedAssociationEnds, new Comparator<AssociationEnd>() {
			public int compare(AssociationEnd o1, AssociationEnd o2) {

				return (getAssociationEndNodeName(o1)).compareTo(getAssociationEndNodeName(o2));
			}
		});

		for (final AssociationEnd associationEnd : sortedAssociationEnds) {

			childList.add(new AssociationEndNode(this, associationEnd));

		}

	}

	/**
	 * Calculates the label of the AssociationEndNode without "Empty" suffix. Should be used in a Comparator for AssociationEndNodes.
	 * 
	 * @param ae
	 *            an AssociationEnd
	 * @return returns the label
	 * @see MOINBrowserLabelProvider
	 */
	private String getAssociationEndNodeName(AssociationEnd ae) {

		String label = ""; //$NON-NLS-1$
		final Association ass = (Association) ae.getContainer();
		final String assName = ass.getName();
		final String otherEndName = ae.otherEnd().getName();
		label = assName + " -> " + otherEndName; //$NON-NLS-1$
		return label;

	}

	private void calculateChildrenForAttributes(List<ITreeNode<?>> childList, Map<Attribute, Object> attributesAndValues) {

		final Set<Attribute> keys = attributesAndValues.keySet();

		for (final Attribute attribute : keys) {

			if (attribute.getMultiplicity().getUpper() == 1) {

				doHandleToOneAttribute(childList, attributesAndValues, attribute);

			} else if (attribute.getMultiplicity().getUpper() != 1) {

				doHandleToNAttribute(childList, attributesAndValues, attribute);
			}
		}
	}

	private void doHandleToNAttribute(List<ITreeNode<?>> childList, Map<Attribute, Object> attributesAndValues, Attribute attribute) {

		final Collection<?> childValues = (Collection<?>) attributesAndValues.get(attribute);
		final String propValue = getLabelForCollection(attribute, childValues);

		childList.add(new CollectionNode(this, new CollectionData(childValues, propValue)));

	}

	@SuppressWarnings("nls")
	private String getLabelForCollection(Attribute attribute, Collection<?> childValues) {

		final ModelElement element = getMetaClass(attribute.getType());
		String collectionTypeName = element.getName();
		if (collectionTypeName == null) {
			collectionTypeName = MOINBrowserLabelProvider.UNKNOWN_LABEL;
		}
		final String propValue = attribute.getName() + ", " + attribute.getType().getName() + ": [" + collectionTypeName + "]"
				+ (childValues.isEmpty() ? " " + MOINBrowserLabelProvider.EMPTY_LABEL : "");
		return propValue;

	}

	private void doHandleToOneAttribute(List<ITreeNode<?>> childList, Map<Attribute, Object> attributesAndValues, Attribute attribute) {

		if (attribute.getType() instanceof PrimitiveType) {
			final String value = MOINBrowserLabelProvider.EMPTY_LABEL;
			final AttributeValuePair attrValuePair = new AttributeValuePair(attribute, value);

			final Object o = attributesAndValues.get(attribute);
			if (o != null) {
				attrValuePair.setValue(attributesAndValues.get(attribute));
			}
			createPropertyNode(childList, attrValuePair);

		} else if (attribute.getType() instanceof MofClass) {

			final Object o = attributesAndValues.get(attribute);
			final Collection<RefObject> isObject = new ArrayList<RefObject>();
			isObject.add((RefObject) o);
			final String propValue = getLabelForCollection(attribute, isObject);

			childList.add(new CollectionNode(this, new CollectionData(isObject, propValue)));

		} else if (attribute.getType() instanceof EnumerationType) {

			final String value = MOINBrowserLabelProvider.EMPTY_LABEL;
			final AttributeValuePair attrValuePair = new AttributeValuePair(attribute, value);

			final Object o = attributesAndValues.get(attribute);
			if (o != null) {
				attrValuePair.setValue(attributesAndValues.get(attribute));
			}
			createPropertyNode(childList, attrValuePair);

		} else if (attribute.getType() instanceof StructureType) {

			final String value = MOINBrowserLabelProvider.EMPTY_LABEL;
			final AttributeValuePair attrValuePair = new AttributeValuePair(attribute, value);

			final Object o = attributesAndValues.get(attribute);
			if (o != null) {
				attrValuePair.setValue(attributesAndValues.get(attribute));
			}
			childList.add(new StructureTypeNode<AttributeValuePair>(this, attrValuePair));

		} else if (attribute.getType() instanceof AliasType) {
			// later
		}
	}

	private ModelElement getMetaClass(RefBaseObject o) {

		final Object mo = o.refMetaObject();
		if (mo instanceof ModelElement)
			return (ModelElement) mo;
		return null;
	}

	private void createPropertyNode(List<ITreeNode<?>> childList, AttributeValuePair attrValuePair) {

		//final Attribute attribute = attrValuePair.getAttribute();
		String value = attrValuePair.getValue().toString();
		if (value == null) {
			value = MOINBrowserLabelProvider.EMPTY_LABEL;
			attrValuePair.setValue(value);
		}

		// String propValue = attribute.getName() + ", "
		// + attribute.getType().getName() + ": " + value;
		childList.add(new PropertyNode<AttributeValuePair>(this, attrValuePair));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	/**
	 * @return
	 */
	public RefBaseObject getMMEntity() {

		return this.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {

		if (adapter == IPropertySource.class) {
			return new MOINModelBrowserPropertySourceManager().getPropertySource(this);
		}
		return super.getAdapter(adapter);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		String finalName = this.propertyHelper.getQualifiedName(getValue());
		final String name = this.propertyHelper.tryGetUsefulName(getValue());
		if (!name.equals("")) { //$NON-NLS-1$
			finalName = finalName + name;
		}


		return finalName; // + " " +((RefObjectNode)element).getModelElement().refMofId();
	}

}