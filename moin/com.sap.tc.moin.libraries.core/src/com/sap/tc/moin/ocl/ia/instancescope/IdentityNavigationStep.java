package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * Performs a trivial "identity" navigation, returning the <tt>fromObject</tt> again. This is useful when only the type
 * checking that is performed by {@link AbstractNavigationStep#navigate(CoreConnection, java.util.Set)} shall be
 * employed, such as for an <tt>oclAsType</tt> method call.<p>
 * 
 * When the source and target type have no common elements in the reflexive subclass inheritance trees,
 * this means that the step will always return an empty set. This property is analyzed during the construction
 * of this step object and cached in the {@link #alwaysEmpty} field. If <tt>true</tt>, this makes this
 * step {@link #isAbsolute() absolute}, and {@link #isAlwaysEmpty()} will return <tt>true</tt>.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class IdentityNavigationStep extends AbstractNavigationStep {
    public IdentityNavigationStep(CoreConnection connection, MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo) {
	super(sourceType, targetType, debugInfo);
	if (!AbstractNavigationStep.haveIntersectingSubclassTree(connection, sourceType, targetType)) {
	    setAlwaysEmpty();
	}
    }

    @Override
    protected Collection<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject) {
	Collection<RefObjectImpl> result = new ArrayList<RefObjectImpl>(1);
	result.add(fromObject);
	return result;
    }
    
    @Override
    public boolean isAbsolute() {
	return isAlwaysEmpty();
    }
    
    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int[] maxId, int indent) {
	return "this";
    }
}
