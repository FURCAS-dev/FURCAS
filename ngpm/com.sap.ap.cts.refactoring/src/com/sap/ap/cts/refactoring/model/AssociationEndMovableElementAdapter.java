package com.sap.ap.cts.refactoring.model;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.ide.refactoring.model.move.MovableElement;
import com.sap.ide.refactoring.model.move.MovableElementTarget;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.AssociationEnd;
import data.classes.SapClass;

/**
 * A runlet specific adapter for the move refactoring, allowing
 * to move exposed association ends.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class AssociationEndMovableElementAdapter implements MovableElement {

    private final AssociationEnd associationEnd;

    public AssociationEndMovableElementAdapter(AssociationEnd associationEnd) {
	this.associationEnd = associationEnd;
    }

    @Override
    public Collection<MovableElementTarget> getPotentialMovingTargets() {
	JmiHelper jmiHelper = associationEnd.get___Connection().getJmiHelper();
	SapClass sapClass = associationEnd.otherEnd().getType().getClazz();
	RefClass refClass = jmiHelper.getRefClassForMofClass((MofClass) sapClass.refMetaObject());

	Collection<MovableElementTarget> targets = new ArrayList<MovableElementTarget>();
	for (RefObject target : refClass.refAllOfType()) {
	    targets.add(new AssociationEndMovableElementTargetAdapter((SapClass) target, associationEnd));
	}
	return targets;
    }

    @Override
    public RefObject getWrappedModelElement() {
	return associationEnd;
    }

    @Override
    public String getName() {
	return RefactoringModelUtil.getModelElementName(associationEnd);
    }

    @Override
    public String getType() {
	return RefactoringModelUtil.getModelElementType(associationEnd);
    }
}
