package com.sap.ide.cts.editor.deepcopy;

import static com.sap.ide.cts.editor.deepcopy.DeepCopyHelper.getAssociationEnds;
import static com.sap.ide.cts.editor.deepcopy.DeepCopyHelper.getElementsForRefAssociation;
import static com.sap.ide.cts.editor.deepcopy.DeepCopyHelper.getRefAssociationForEnd;
import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.OperationCanceledException;

import textblocks.DocumentNode;
import textblocks.TextblocksPackage;

import com.sap.mi.fwk.ui.dnd.DefaultModelTransferTarget;
import com.sap.mi.fwk.ui.dnd.IModelTransferExtender;
import com.sap.mi.fwk.ui.dnd.IModelTransferLog;
import com.sap.mi.fwk.ui.dnd.IModelTransferTarget;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyMappingEntry;
import com.sap.tc.moin.repository.DeepCopyPolicy;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.DeepCopyPolicy.DeepCopyPolicyOption;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A strategy combining several deep copy, drag&drop and copy&paste related
 * algorithms. This class is intended to be subclassed to add metamodel
 * specific behavior.
 * <p>
 * To automatically use your subclass instead of this generic implementation,
 * adapt RefObject and GenericRefObjectNode for your metamodel to
 * {@link IModelTransferExtender} and {@link IModelTransferTarget}.  
 * </p>
 * 
 * The generic implementation will copy model compositions and
 * dependent linked composition as well as the decorating root TextBlocks.
 * 
 * Dependent refers to the fact that an association with fixed upper
 * multiplicity on a full-copied association end also requires a full copy of
 * the other end. If the other side would not be copied and only referenced, a
 * link would need to be establish between the referenced and the copied
 * element. This could violate the multiplicity constraints as there is already
 * a link between the referenced and the original element.
 * <p>
 * <b>Attention:</b> This copy policy can lead to intrusive model changes in the source
 * model due to link establishment.
 * </p>
 * @author D049157
 * 
 */
public class GenericModelCopyStrategy extends DefaultModelTransferTarget implements DeepCopyPolicyHandler,
	IModelTransferExtender<RefBaseObject> {

    /**
     * Returns the copy policy as defined by this class
     */
    @Override
    public DeepCopyPolicyHandler getDeepCopyPolicyHandler() {
	return this;
    }

    @Override
    public DeepCopyPolicy getDeepCopyingPolicy(RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap) {
	Connection co = sourceElement.get___Connection();

	// ask subclass
	DeepCopyPolicy customPolicy = getMetaModelSpecificMapping(sourceElement, copyMap);
	if (customPolicy != null) {
	    return customPolicy;
	}

	// Always copy composite elements as proposed
	if (defaultPolicy.getDeepCopyPolicyOption() == DeepCopyPolicyOption.FULL_COPY) {
	    return defaultPolicy;
	}

	// for all association ends
	for (AssociationEnd elemAssocEnd : getAssociationEnds(co, sourceElement)) {

	    // if there is a reference
	    RefAssociation sourceAssoc = getRefAssociationForEnd(co, elemAssocEnd);
	    if (sourceAssoc != null) {

		// for all linked elements
		Collection<RefObject> elements = getElementsForRefAssociation(co, sourceAssoc, elemAssocEnd, sourceElement);
		for (RefObject associatedElement : elements) {

		    // if element has already been visited
		    if (copyMap.containsKey(associatedElement)) {
			DeepCopyMappingEntry entry = copyMap.get(associatedElement);
			DeepCopyPolicyOption associatedElementPolicy = entry.getModifiedPolicy().getDeepCopyPolicyOption();

			// prevent constraint errors due to fixed upper mulitiplicity
			if (associatedElementPolicy == DeepCopyPolicyOption.FULL_COPY
				&& !(elemAssocEnd.otherEnd().getMultiplicity().getUpper() == MULTIPLICITY_BOUND_INFINITE)) {

			    // storage MIGHT indicate how to resolve the error situation
			    if (co.getJmiHelper().isEndStored(elemAssocEnd.otherEnd())) {
				// System.out.println("COPY due to MULT-STORAGE: + sourceElement.getClass().getName() + " as " + elemAssocEnd.getName() + " via FULL_COPY of " + associatedElement.getClass().getName());
				return new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
			    } else {
				// System.out.println("STOP due to MULTIPLICITY: " + sourceElement.getClass().getName() + " as " + elemAssocEnd.getName() + " via FULL_COPY of " + associatedElement.getClass().getName());
				return new DeepCopyPolicy(DeepCopyPolicyOption.STOP, null);
			    }
			}
		    }
		}
	    } else {
		System.err.println("No RefAssoc for " + sourceElement.getClass().getName() + " on " + elemAssocEnd.getName());
	    }
	}
	return defaultPolicy;
    }

    /**
     * Template method for metamodel specific behavior. Called by
     * {@link GenericModelCopyStrategy#getDeepCopyingPolicy(RefObject, DeepCopyPolicy, DeepCopyMap)}
     * 
     * @param sourceElement
     * @param copyMap
     * @return
     */
    protected DeepCopyPolicy getMetaModelSpecificMapping(RefObject sourceElement, DeepCopyMap copyMap) {
	return null;
    }

    /**
     * Template method for metamodel specific behavior. Used to prepare a copy
     * before it is hooked into the composite parent structure of the target element.
     * 
     * This class is not called during a deep copy operation but only afterwards.
     * It can be used to e.g rename a ModelElement to avoid name clashes.
     * 
     * @param identifier, unique identifier that can be used within the target environment
     * 		to create unique names
     * @param target
     * @param copy
     * @return false if the given copy should NOT be linked
     */
    public Boolean prepareLinkingToCompositeParent(String identifier, RefBaseObject target, RefBaseObject copy) {
	return true;
    }

    /**
     * <p>
     * A hook for custom logic in the paste step of a copy/paste operation or on
     * drop. Typically this includes inserting the transferred objects to a
     * composition hierarchy and a partition.
     * </p>
     * <p>
     * The default implementation tries to add the given objects to the given
     * target as composite children, if this one is a {@link RefObject}. If
     * multiple matching {@link Association associations} are available, the
     * user is asked to choose one.
     * </p>
     * <b>Mind:</b> By default this method does not make use of
     * {@link #prepareLinkingToCompositeParent(String, RefBaseObject, RefBaseObject)}
     */
    @Override
    public Collection<ModelPartition> handleTransfer(Object target, RefBaseObject[] objectsToTransfer, IModelTransferLog log)
	    throws OperationCanceledException {
	return super.handleTransfer(target, objectsToTransfer, log);
    }

    /**
     * Called by copy&paste and drag&drop code and is required to include
     * TextBlocks of underlying model elements of copied tree nodes.
     * <p>
     * Extends the original set of objects to transfer. Called for each object
     * of the set that has a matching type. If e.g. an extender is registered
     * for Mof classes, it will be called once for each class in the set.
     * Duplicate results are merged. The <code>originalObjects</code> set,
     * however, stays the same.
     * </p>
     * @param toExtend
     *            the object for which additional objects can be returned
     * @param originalObjects
     *            the original objects, usually a selection in the workbench
     * 
     * @return additional objects to be included in the transfer set
     */
    @Override
    public RefBaseObject[] getAdditionalObjects(RefBaseObject toExtend, RefBaseObject[] originalObjects) {
	if (toExtend instanceof RefObject) {
	    RefObject refObj = (RefObject) toExtend;
	    Connection con = refObj.get___Connection();
	    TextblocksPackage tbPackage = con.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	    Collection<DocumentNode> nodes = tbPackage.getDocumentNodeReferencesCorrespondingModelElement()
	    	.getDocumentNode(refObj);

	    Collection<RefBaseObject> rootNodes = new ArrayList<RefBaseObject>();
	    for (DocumentNode node : nodes) {
		// Only include root TextBlocks
		if (node.refImmediateComposite() == null) {
		    rootNodes.add(node);
		}
	    }
	    return rootNodes.toArray(new RefBaseObject[rootNodes.size()]);
	}
	return new RefBaseObject[] {};
    }
}
