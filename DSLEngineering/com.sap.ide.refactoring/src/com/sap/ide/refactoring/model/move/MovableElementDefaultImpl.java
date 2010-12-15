package com.sap.ide.refactoring.model.move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.ide.refactoring.model.RefactoringModelUtil;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class MovableElementDefaultImpl implements MovableElement {

    protected final RefObject wrapped;

    public MovableElementDefaultImpl(RefObject wrapped) {
	this.wrapped = wrapped;
    }

    @Override
    public Collection<MovableElementTarget> getPotentialMovingTargets() {
	Map<Association, Collection<RefObject>> potentialParents = getPotentialCompositeParents(wrapped);

	Collection<MovableElementTarget> targets = new ArrayList<MovableElementTarget>();
	for (Entry<Association, Collection<RefObject>> entry : potentialParents.entrySet()) {
	    for (RefObject target : entry.getValue()) {
		targets.add(new MovableElementTargetDefaultImpl(target, wrapped, entry.getKey()));
	    }
	}
	return targets;
    }

    /**
     * For a given class <tt>child</tt>, finds all associations where instances of
     * <tt>child</tt> can act as composite child. For the respective opposite end,
     * finds all concrete classes whose instances can act as composite parent
     * on that opposite end. Those classes are returned.
     */
    protected Map<Association, Collection<RefObject>> getPotentialCompositeParents(RefObject childModelElement) {
	Map<Association, Collection<RefObject>> result = new LinkedHashMap<Association, Collection<RefObject>>();
	JmiHelper jmiHelper = childModelElement.get___Connection().getJmiHelper();

	for (AssociationEnd childEnd : jmiHelper.getAssociationEnds((MofClass) childModelElement.refMetaObject(), /*includeSupertype*/true)) {
	    Collection<RefObject> potentialParents = new ArrayList<RefObject>();
	    AssociationEnd parentEnd = childEnd.otherEnd();
	   
	    if (parentEnd.getAggregation().equals(AggregationKindEnum.COMPOSITE)) {
		MofClass parentClass = (MofClass) parentEnd.getType();
		RefClass refClassOfAssocEnd =  jmiHelper.getRefClassForMofClass(parentClass);
		potentialParents.addAll(refClassOfAssocEnd.refAllOfType());
		result.put((Association) childEnd.getContainer(), potentialParents);
	    }
	}
	return result;
    }
    
    @Override
    public RefObject getWrappedModelElement() {
	return this.wrapped;
    }

    @Override
    public String getName() {
	return RefactoringModelUtil.getModelElementName(wrapped);
    }

    @Override
    public String getType() {
	return RefactoringModelUtil.getModelElementType(wrapped);
    }

}
