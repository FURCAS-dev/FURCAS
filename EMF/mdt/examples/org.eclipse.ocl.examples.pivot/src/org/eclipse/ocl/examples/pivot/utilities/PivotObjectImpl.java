/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: PivotObjectImpl.java,v 1.3 2011/03/01 08:47:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public abstract class PivotObjectImpl extends EObjectImpl implements PivotObject, Adapter.Internal
{
	private EObject target;
	
	public EObject getETarget() {
		return target;
	}
	
	public EObject getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type == PivotObject.class;
	}
	
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	public void setTarget(Notifier newTarget) {
		target = (EObject) newTarget;
	}

	public void unsetTarget(Notifier oldTarget) {
		target = null;
	}
}
