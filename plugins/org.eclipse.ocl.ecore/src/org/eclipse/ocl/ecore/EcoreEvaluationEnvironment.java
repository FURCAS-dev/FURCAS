/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EcoreEvaluationEnvironment.java,v 1.1 2007/01/25 18:29:09 cdamus Exp $
 */

package org.eclipse.ocl.ecore;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LazyExtentMap;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of
 * OCL expressions on instances of Ecore models (i.e., on M0 models).
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEvaluationEnvironment
		extends AbstractEvaluationEnvironment<
			EClassifier, EOperation, EStructuralFeature, EClass, EObject> {

    /**
     * Initializes me.
     */
    public EcoreEvaluationEnvironment() {
        super();
    }
    
    /**
     * Initializes me with my parent evaluation environment (nesting scope).
     * 
     * @param parent my parent (nesting scope); must not be <code>null</code>
     */
    public EcoreEvaluationEnvironment(
    		EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
    	super(parent);
    }
    
    // implements the inherited specification
	protected Method getJavaMethodFor(EOperation operation, Object receiver) {
		Method result = null;

		// in the case of infix operators, we need to replace the name with
		//    a valid Java name.  We will choose the legacy OCL parser names
		//    which some clients already depend on
		String operName = operation.getName();
		int opcode = OCLStandardLibraryUtil.getOperationCode(operName);
		switch (opcode) {
		case PredefinedType.PLUS:
			operName = "plus"; //$NON-NLS-1$
			break;
		case PredefinedType.MINUS:
			operName = "minus"; //$NON-NLS-1$
			break;
		case PredefinedType.TIMES:
			operName = "times"; //$NON-NLS-1$
			break;
		case PredefinedType.DIVIDE:
			operName = "divide"; //$NON-NLS-1$
			break;
		case PredefinedType.LESS_THAN:
			operName = "lessThan"; //$NON-NLS-1$
			break;
		case PredefinedType.LESS_THAN_EQUAL:
			operName = "lessThanEqual"; //$NON-NLS-1$
			break;
		case PredefinedType.GREATER_THAN:
			operName = "greaterThan"; //$NON-NLS-1$
			break;
		case PredefinedType.GREATER_THAN_EQUAL:
			operName = "greaterThanEqual"; //$NON-NLS-1$
			break;
		}
		
		// get containing class for the operation
		EClass container = operation.getEContainingClass();

		// get the corresponding java instance class
		Class<?> containerClass = container.getInstanceClass();

		// get the parameter types as java classes
		EList<EParameter> parms = operation.getEParameters();
		Class<?>[] javaParms = new Class[parms.size()];
		for (int i = 0, n = parms.size(); i < n; i++) {
			EParameter parm = (EParameter) parms.get(i);
			
			if (parm.isMany()) {
				javaParms[i] = EList.class; // TODO: EList could be suppressed
			} else {
				javaParms[i] = parm.getEType().getInstanceClass();
			}
		}

		// lookup the method on the java class
		try {
			result = containerClass.getMethod(operName, javaParms);
		} catch (NoSuchMethodException e) {
			//do nothing
		}

		return result;
	}
	
    // implements the inherited specification
	@Override
	protected Object getInvalidResult() {
		return OCLStandardLibraryImpl.OCL_INVALID;
	}
    
    // implements the inherited specification
    public Object navigateProperty(
    		EStructuralFeature property,
    		List<?> qualifiers,
    		Object target) throws IllegalArgumentException {
    	
    	if (target instanceof EObject) {
    		EObject etarget = (EObject) target;
    		
    		if (etarget.eClass().getEAllStructuralFeatures().contains(property)) {
    			return etarget.eGet(property);
    		}
    	}
    	
    	throw new IllegalArgumentException();
    }

    // implements the inherited specification
    public Object navigateAssociationClass(
    		EClassifier associationClass,
    		EStructuralFeature navigationSource,
    		Object target)
    		throws IllegalArgumentException {

    	if (target instanceof EObject) {
    		EObject etarget = (EObject) target;
    		
	    	EReference ref = getAssociationClassReference(
				etarget, (EClass) associationClass);
	
	    	if (etarget.eClass().getEAllStructuralFeatures().contains(ref)) {
	    		return etarget.eGet(ref);
	    	}
    	}
    	
    	throw new IllegalArgumentException();
	}

	/**
	 * Retrieves the reference feature in the specified context object that
	 * references the specified association class.
	 * 
	 * @param context the context object
	 * @param associationClass the association class that it references
	 * @return the reference in question
	 */
	private EReference getAssociationClassReference(
			EObject context, EClass associationClass) {
		EReference result = null;
		
		StringBuffer nameBuf = new StringBuffer(associationClass.getName());
		UnicodeSupport.setCodePointAt(
				nameBuf,
				0,
				UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(nameBuf, 0)));
		String name = nameBuf.toString();
		
		for (EReference next : context.eClass().getEAllReferences()) {
			if (name.equals(next.getName()) && (associationClass == next.getEReferenceType())) {
				result = next;
				break;
			}
		}
		
		return result;
	}
    
    // implements the inherited specification
    public Tuple<EOperation, EStructuralFeature> createTuple(
    		EClassifier type, Map<EStructuralFeature, Object> values) {
    	
    	EClass tupleType = (EClass) type;
    	
    	EObject tuple = tupleType.getEPackage().getEFactoryInstance().create(tupleType);
    	
    	for (Map.Entry<EStructuralFeature, Object> value : values.entrySet()) {
    		tuple.eSet(value.getKey(), value.getValue());
    	}
    	
    	@SuppressWarnings("unchecked")
    	Tuple<EOperation, EStructuralFeature> result = 
    		(Tuple<EOperation, EStructuralFeature>) tuple;
    	
    	return result;
    }
	
    // implements the inherited specification
	public Map<EClass, Set<EObject>> createExtentMap(Object object) {
		if (object instanceof EObject) {
			return new LazyExtentMap<EClass, EObject>((EObject) object) {
                // implements the inherited specification
				@Override
				protected boolean isInstance(EClass cls, EObject element) {
					return cls.isInstance(element);
				}};
		}
		
		return Collections.emptyMap();
	}

    // implements the inherited specification
	public boolean isKindOf(Object object, EClassifier classifier) {
		// special case for Integer/UnlimitedNatural and Real which
        //   are not related types in java but are in OCL
		if ((object.getClass() == Integer.class)
				&& (classifier.getInstanceClass() == Double.class)) {
			return Boolean.TRUE;
		}
		
		return classifier.isInstance(object);
	}
    
    // implements the inherited specification
	public boolean isTypeOf(Object object, EClassifier classifier) {
		if (classifier instanceof EClass && object instanceof EObject) {
			return ((EObject) object).eClass() == classifier;
		} else if (!(object instanceof EObject) && !(classifier instanceof EClass)) {
			return object.getClass() == classifier.getInstanceClass();
		}
		
		return false;
	}
}