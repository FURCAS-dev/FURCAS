/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class ModelReference {
	private final EObject from;
	private final EObject to;
	private final EReference reference;
	
	public ModelReference(EObject from, EObject to, EReference reference) {
		this.from = from;
		this.to = to;
		this.reference = reference;
	}
	
	public EObject getFrom() {
		return from;
	}

	public EObject getTo() {
		return to;
	}

	public EReference getReference() {
		return reference;
	}
}
