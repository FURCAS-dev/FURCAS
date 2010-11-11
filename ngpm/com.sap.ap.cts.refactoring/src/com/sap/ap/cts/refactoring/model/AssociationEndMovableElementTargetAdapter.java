package com.sap.ap.cts.refactoring.model;

import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.ide.refactoring.model.move.MovableElementTarget;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.AssociationEnd;
import data.classes.SapClass;
import data.classes.SignatureImplementation;

/**
 * Counter part of {@link AssociationEndMovableElementAdapter}.
 * This class implements the actual move operation.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class AssociationEndMovableElementTargetAdapter implements MovableElementTarget {

    private final AssociationEnd runletAssociationEnd;
    private final SapClass target;

    public AssociationEndMovableElementTargetAdapter(SapClass target, AssociationEnd runletAssociationEnd) {
	this.target = target;
	this.runletAssociationEnd = runletAssociationEnd;
    }

    @Override
    public void movetoHere() {
	runletAssociationEnd.otherEnd().getType().setClazz(target);
	runletAssociationEnd.getAssociation().setPackage((target).getPackage());

	for (SignatureImplementation sigImpl : runletAssociationEnd.getSignatureImplementations()) {
	    sigImpl.getImplements().setOwner(target);
	}
    }

    @Override
    public RefObject getWrappedModelElement() {
	return target;
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
	return "";
    }

}
