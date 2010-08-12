package com.sap.ide.refactoring.model.move;

import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class MovableElementTargetDefaultImpl implements MovableElementTarget {

    /**
     * Composite parent where elementToMove shall be moved under
     */
    protected final RefObject target;
    protected final RefObject elementToMove;
    protected final Association association;

    public MovableElementTargetDefaultImpl(RefObject target, RefObject elementToMove, Association association) {
	this.elementToMove = elementToMove;
	this.target = target;
	this.association = association;
    }

    @Override
    public String getName() {
	return RefactoringModelUtil.getModelElementName(target);
    }

    @Override
    public String getType() {
	return RefactoringModelUtil.getModelElementType(target);
    }

    @Override
    public String getRole() {
	JmiHelper helper = target.get___Connection().getJmiHelper();
	return helper.getCompositeAssociationEnd(association).getName();
    }

    @Override
    public RefObject getWrappedModelElement() {
	return this.target;
    }

    @Override
    public void movetoHere() {
	removeLinkFromCompositeParent(elementToMove);
	addCompositeLinkBetween(target, elementToMove, association);
    }

    protected void removeLinkFromCompositeParent(RefObject child) {
	JmiHelper helper = child.get___Connection().getJmiHelper();
	RefObject parent = (RefObject) child.refImmediateComposite();
	if (parent == null) {
	    return;
	}

	for (Association assoc : helper.getCompositeAssociations((MofClass) parent.refMetaObject(), (MofClass) child.refMetaObject())) {
	    RefAssociation refAssoc = helper.getRefAssociationForAssociation(assoc);
	    AssociationEnd compAssocEnd = helper.getCompositeAssociationEnd(assoc);
	    if (helper.isFirstAssociationEnd(assoc, compAssocEnd) && refAssoc.refLinkExists(parent, child)) {
		refAssoc.refRemoveLink(parent, child);
	    } else if (helper.isFirstAssociationEnd(assoc, compAssocEnd.otherEnd()) && refAssoc.refLinkExists(child, parent)) {
		refAssoc.refRemoveLink(child, parent);
	    }
	}
    }

    protected void addCompositeLinkBetween(RefObject target, RefObject elementToMove, Association assoc) {
	JmiHelper helper = target.get___Connection().getJmiHelper();
	RefAssociation refAssoc = helper.getRefAssociationForAssociation(assoc);

	AssociationEnd compAssocEnd = helper.getCompositeAssociationEnd(assoc);

	if (helper.isFirstAssociationEnd(assoc, compAssocEnd)) {
	    refAssoc.refAddLink(target, elementToMove);
	} else if (helper.isFirstAssociationEnd(assoc, compAssocEnd.otherEnd())) {
	    refAssoc.refAddLink(elementToMove, target);
	}
    }

    @Override
    public String toString() {
	return "Target: " + getName() + " (" + getType() + ")" + " as " + getRole();
    }

}
