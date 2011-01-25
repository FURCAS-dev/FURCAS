/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotModelManager.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

public class PivotModelManager extends LazyModelManager
{
	protected final TypeManager typeManager;
	private Ecore2Pivot ecoreConverter = null;
	
	public PivotModelManager(TypeManager typeManager, EObject context) {
		super(context);
		this.typeManager = typeManager;
	}

	// implements the inherited specification
	@Override
	protected boolean isInstance(Type requiredType, EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		Type objectType;
		if (ePackage == PivotPackage.eINSTANCE) {
			objectType = typeManager.getPivotType(eClass.getName());
		}
		else {
			Resource resource = eClass.eResource();
			Collection<EObject> roots;
			if (resource != null) {
				roots = resource.getContents();
			}
			else {
				roots = Collections.singletonList(EcoreUtil.getRootContainer(eClass));
			}
			ecoreConverter = new Ecore2Pivot(null, typeManager);
			ecoreConverter.importObjects(roots, URI.createURI("temp://eval"));
			objectType = ecoreConverter.getPivotType(eClass);
//			throw new UnsupportedOperationException();
		}
	    return typeManager.conformsTo(objectType, requiredType);
	}
}