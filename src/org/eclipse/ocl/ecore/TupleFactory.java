/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TupleFactory.java,v 1.3 2007/10/11 23:04:41 cdamus Exp $
 */

package org.eclipse.ocl.ecore;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.Tuple;

/**
 * A specialized factory that creates tuple instances implementing
 * value equality.
 * 
 * @author Christian W. Damus (cdamus)
 */
class TupleFactory extends EFactoryImpl {
	@Override
    protected EObject basicCreate(EClass eClass) {
		TupleInstance result = new TupleInstance();
		result.eSetClass(eClass);
		return result;
	}
	
	private static final class TupleInstance
			extends DynamicEObjectImpl
			implements Tuple<EOperation, EStructuralFeature> {
		
		@Override
        public boolean equals(Object o) {
			if (!(o instanceof TupleInstance)) {
				return false;
			}
			
			TupleInstance other = (TupleInstance) o;
			EClass otherType = other.eClass();
			
			EList<EStructuralFeature> myFeatures = eClass().getEStructuralFeatures();
			EList<EStructuralFeature> otherFeatures = otherType.getEStructuralFeatures();
			
			if (myFeatures.size() != otherFeatures.size()) {
				return false;
			}

			Iterator<EStructuralFeature> iter = myFeatures.iterator();

			boolean result = true; // assume equality unless ...
			
			while (result && iter.hasNext()) {
				EStructuralFeature next = iter.next();
				
				Object myValue = eGet(next);
				
				EStructuralFeature otherNext = otherType.getEStructuralFeature(
							next.getName());
				if (otherNext == null) {
					result = false;
				} else {
					Object otherValue = other.eGet(next);
					
					result = ObjectUtil.equal(myValue, otherValue);
				}
			}
			
			return result;
		}
		
		@Override
        public int hashCode() {
			int result = 0;
			
			for (EStructuralFeature next : eClass().getEStructuralFeatures()) {
				Object myValue = eGet(next);
				
				result = 31 * result + ObjectUtil.hashCode(myValue);
			}
			
			return result;
		}

		public TupleType<EOperation, EStructuralFeature> getTupleType() {
			return (org.eclipse.ocl.ecore.TupleType) eClass();
		}

		public Object getValue(String partName) {
			return getValue(eClass().getEStructuralFeature(partName));
		}

		public Object getValue(EStructuralFeature part) {
			return eGet(part);
		}
	}
}
