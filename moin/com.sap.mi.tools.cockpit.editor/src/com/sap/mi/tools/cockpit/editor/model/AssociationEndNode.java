package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public final class AssociationEndNode extends TreeNodeRefObject<AssociationEnd> implements ITreeNodeLabelAware {

	private final static String NO_PARENT_ERROR_MESSAGE_PART = "No parent as RefObject found for AssociationEnd: "; //$NON-NLS-1$

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MODELBROWSER);

	/**
	 * Create {@link AssociationEndNode}.
	 * 
	 * @param parentNode
	 * @param associationEnd
	 */
	public AssociationEndNode(ITreeNode<?> parentNode, AssociationEnd associationEnd) {

		super(parentNode, associationEnd);
		Assert.isNotNull(getParent());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		final List<ITreeNode<?>> childList = new ArrayList<ITreeNode<?>>();

		getOtherSideObjects(childList);

		return childList.toArray();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return getChildren().length > 0;
	}

	private void getOtherSideObjects(List<ITreeNode<?>> childList) {

		final Object oParent = getParent();
		RefObject parent = null;
		if (oParent instanceof IAdaptable) {
			parent = (RefObject) ((IAdaptable) oParent).getAdapter(RefObject.class);
		}
		if (parent != null) {
			final Association association = (Association) getValue().getContainer();
			final RefAssociation refAssociation = getConnection().getJmiHelper().getRefAssociationForAssociation(association);
			Collection<RefObject> otherSideObjects = null;
			if (refAssociation != null) {
				try {
					otherSideObjects = refAssociation.refQuery(getValue(), parent);
					for (final RefObject refObject : otherSideObjects) {
						childList.add(new RefObjectNode(this, refObject));
					}
				}
				catch (final Exception e) {
					childList = Collections.emptyList();
					AssociationEndNode.tracer.error(e.getMessage(), e);
				}
			}

		} else {
			throw new IllegalStateException(AssociationEndNode.NO_PARENT_ERROR_MESSAGE_PART + getValue().getName());
		}
	}

	public int getCardinality() {

		return getValue().otherEnd().getMultiplicity().getUpper();

	}

	public boolean isComposite() {

		boolean isComposite = false;
		final Association ass = (Association) getValue().getContainer();
		if (this.getConnection().getJmiHelper().getCompositeAssociationEnd(ass) != null) {
			isComposite = true;
		}
		return isComposite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		String label = ""; //$NON-NLS-1$
		final AssociationEnd ae = getValue();
		final Association ass = (Association) ae.getContainer();
		final String assName = ass.getName();
		final String otherEndName = ae.otherEnd().getName();
		label = assName + " -> " + otherEndName; //$NON-NLS-1$
		if (!hasChildren()) {
			label = label + " " + MOINBrowserLabelProvider.EMPTY_LABEL; //$NON-NLS-1$ 
		}
		return label;
	}

}
