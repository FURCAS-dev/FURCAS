/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: TupleFactory.java,v 1.1 2006/04/04 18:09:05 cdamus Exp $
 */

package org.eclipse.emf.ocl.utilities.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;

/**
 * A specialized factory that creates tuple instances implementing
 * value equality.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TupleFactory extends EFactoryImpl {
	protected EObject basicCreate(EClass eClass) {
		TupleInstance result = new TupleInstance();
		result.eSetClass(eClass);
		return result;
	}
	
	private static class TupleInstance extends EObjectImpl {
		public boolean equals(Object o) {
			if (!(o instanceof TupleInstance)) {
				return false;
			}
			
			TupleInstance other = (TupleInstance) o;
			EClass otherType = other.eClass();
			
			EList myFeatures = eClass().getEStructuralFeatures();
			EList otherFeatures = otherType.getEStructuralFeatures();
			
			if (myFeatures.size() != otherFeatures.size()) {
				return false;
			}

			Iterator iter = myFeatures.iterator();

			boolean result = true; // assume equality unless ...
			
			while (result && iter.hasNext()) {
				EStructuralFeature next = (EStructuralFeature) iter.next();
				
				Object myValue = eGet(next);
				
				EStructuralFeature otherNext =
					(EStructuralFeature) otherType.getEStructuralFeature(
							next.getName());
				if (otherNext == null) {
					result = false;
				} else {
					Object otherValue = other.eGet(next);
					
					result = AnyTypeImpl.equal(myValue, otherValue);
				}
			}
			
			return result;
		}
		
		public int hashCode() {
			int result = 0;
			
			EList myFeatures = eClass().getEStructuralFeatures();
			
			Iterator iter = myFeatures.iterator();

			while (iter.hasNext()) {
				EStructuralFeature next = (EStructuralFeature) iter.next();
				
				Object myValue = eGet(next);
				
				result = 31 * result + AnyTypeImpl.hashCode(myValue);
			}
			
			return result;
		}
	}
}
