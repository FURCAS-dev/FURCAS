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
 * $Id: BasicContinuation.java,v 1.3 2011/02/11 20:59:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * A BasicContinuation defines a conversion activity that needs to be performed once
 * its dependencies have been satisfied. All BasicContinuations are implicitly dependent
 * on the end of the pre and posrt order traversals.
 *
 * @param <T>
 */
public abstract class BasicContinuation<T> implements Continuation<T>
{
	static final Logger logger = Logger.getLogger(BasicContinuation.class);

	protected final CS2PivotConversion context;
	protected final Element pivotParent;
	protected final EStructuralFeature pivotFeature;	
	protected final T csElement;
	protected final Dependency[] dependencies;
	
	public BasicContinuation(CS2PivotConversion context,
			Element pivotParent, EStructuralFeature pivotFeature,
			T csElement, Dependency... dependencies) {
		this.context = context;
		this.pivotParent = pivotParent;
		this.pivotFeature = pivotFeature;
		this.csElement = csElement;
		this.dependencies = dependencies;
	}

	public void addError(String message) {
		if (csElement instanceof ModelElementCS) {
			ModelElementCS csModelElement = (ModelElementCS) csElement;
			INode node = NodeModelUtils.getNode(csModelElement);
			Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, message);
			csModelElement.eResource().getErrors().add(resourceDiagnostic);
		}
		else {
			logger.error(message);
		}
	}
	
	public void addTo(List<BasicContinuation<?>> simpleContinuations) {
		simpleContinuations.add(this);
	}

	public boolean canExecute() {
		for (Dependency dependency : dependencies) {
			if (!dependency.canExecute()) {
				return false;
			}
		}
		return true;
	}		

	public abstract BasicContinuation<?> execute();

	public Dependency[] getDependencies() {
		return dependencies;
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(getClass().getSimpleName());		
		s.append(" : ");		
		if (pivotParent != null) {
			s.append(pivotParent.eClass().getName());		
		}
		else if (csElement instanceof EObject) {
			s.append(((EObject) csElement).eClass().getName());		
		}
		else {
			s.append("???");		
		}
		s.append(".");
		s.append(pivotFeature != null ? pivotFeature.getName() : "*");
		s.append(" : ");
		String elementName = null;
		if (csElement instanceof MonikeredElementCS) {
			MonikeredElementCS csMonikeredElement = (MonikeredElementCS) csElement;
			if (csMonikeredElement.hasMoniker()) {
				elementName = csMonikeredElement.getMoniker();
			}
		}
		if (elementName == null) {
			elementName = csElement.toString();
		}
		s.append(elementName);
		return s.toString();
	}
}