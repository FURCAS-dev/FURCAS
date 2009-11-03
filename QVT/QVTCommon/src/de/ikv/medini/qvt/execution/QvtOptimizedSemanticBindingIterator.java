/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.execution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclUndefined;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

import de.ikv.medini.qvt.QVTDirectedValidation;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;

/**
 * This iterator class is an optimized variant of {@link QvtSemanticBindingIterator}. {@link QvtSemanticBindingIterator} has exponential runtime behavior to the total number of
 * nested object templates of the source domains of a relation. This implementation has a runtime behavior near the possible number of bindings for a trace.
 * 
 * @author kiegeland
 * 
 */

public class QvtOptimizedSemanticBindingIterator implements Iterator {

	/**
	 * Stores the nested {@link ObjectTemplateExp} instances
	 */
	private ObjectTemplateExp[] objectTemplates;

	/**
	 * Hold iterators for the {@link ObjectTemplateExp} instances
	 */
	private Iterator[] allIterators;

	/**
	 * Maps a {@link ObjectTemplateExp} instance to a bound value
	 */
	private Map currentObjects;

	private QvtProcessorImpl processor;

	/**
	 * If <code>hasNextBinding</code> is true, there is a binding available at any case
	 */
	private boolean hasNextBinding;

	/**
	 * If <code>hasNoBinding</code> is true, there is no binding available at any case
	 */
	private boolean hasNoBinding;

	/**
	 * Save the expression for which no binding is available, for logging
	 */
	private SemanticsVisitable failedClause;

	/**
	 * Creates and initializes a new iterator instance
	 * 
	 * @param templatesToIterate
	 *            NOTE: This order is supposed: E.g. if template A is nested in template B, index(A)>index(B)
	 * @param processor
	 * @param rootValues
	 *            a mapping of the source domain variables to the trace values
	 */
	public QvtOptimizedSemanticBindingIterator(List templatesToIterate, QvtProcessorImpl processor, Map rootValues) {
		this.processor = processor;
		this.objectTemplates = (ObjectTemplateExp[]) templatesToIterate.toArray(new ObjectTemplateExp[templatesToIterate.size()]);
		this.allIterators = new Iterator[templatesToIterate.size()];
		this.currentObjects = rootValues;
		this.hasNextBinding = this.initializeIterators(0); // Note, offer one binding if no nested templates exist
		this.hasNoBinding = false;
	}

	public boolean hasNext() {
		this.failedClause = null;
		if (this.hasNextBinding) {
			return true;
		}
		if (this.hasNoBinding) {
			return false;
		}
		for (int i = this.allIterators.length - 1; i >= 0; i--) {
			while (this.allIterators[i] != null && this.allIterators[i].hasNext()) {
				this.currentObjects.put(this.objectTemplates[i], this.allIterators[i].next());
				if (this.initializeIterators(i + 1)) {
					this.hasNextBinding = true;
					return true;
				}
			}
		}
		this.hasNoBinding = true;
		return false;
	}

	public Object next() {
		if (this.hasNext()) {
			RuntimeEnvironment runtimeEnvironment = new RuntimeEnvironmentImpl();
			for (int i = 0; i < this.objectTemplates.length; i++) {
				OclAny objectTemplateValue = (OclAny) this.currentObjects.get(this.objectTemplates[i]);
				if (objectTemplateValue == null) {
					throw new RuntimeException("Internal error in QvtOptimizedSemanticBindingIterator: binding var is null");
				}
				runtimeEnvironment.setValue(this.objectTemplates[i].getBindsTo().getName(), objectTemplateValue);
			}
			this.hasNextBinding = false;
			return runtimeEnvironment;
		}
		throw new NoSuchElementException();
	}

	/**
	 * Initialized all iterators of templates "template" where index(template)>=fromIndex. An iterator is initialized with the values offered by the left side of the
	 * PropertyTemplateItem which has "template" on its right side.
	 * 
	 * @param fromIndex
	 * @return true if all created iterators can provide one value
	 */
	private boolean initializeIterators(int index) {

		if (index >= this.objectTemplates.length) {
			return true;
		}

		ObjectTemplateExp template = this.objectTemplates[index];
		if (this.allIterators[index] != null && this.allIterators[index].hasNext()) {
			throw new RuntimeException("Internal error in QvtOptimizedSemanticBindingIterator: child has still bindings");
		}
		if (template.eContainer() instanceof PropertyTemplateItem) {
			PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) template.eContainer();
			ObjectTemplateExp parentTemplate = propertyTemplateItem.getObjContainer();

			Object sourceValue = this.currentObjects.get(parentTemplate);
			List vals = QVTDirectedValidation.getValueList(sourceValue, propertyTemplateItem.getReferredProperty(), this.getQvtProcessor());

			List list = new ArrayList();
			for (Iterator iter = vals.iterator(); iter.hasNext();) {
				Object obj = iter.next();
				if (obj == null) {
					continue;
				}
				OclAny currentValue = this.processor.getStdLibAdapter().OclAny(obj);

				if (!(currentValue == null || currentValue instanceof OclUndefined) && currentValue.oclType().asJavaObject() == null) {
					throw new RuntimeException("QvtOptimizedSemanticBindingIterator: cannot retrieve RTTI");
				}
				if (!(currentValue == null || currentValue instanceof OclUndefined) && currentValue.oclType().asJavaObject() != null
				        && !((Classifier) currentValue.oclType().asJavaObject()).conformsTo(template.getType()).booleanValue()) {
					this.failedClause = template;
					continue;
				}
				list.add(currentValue);
			}
			this.allIterators[index] = list.iterator();

			while (this.allIterators[index].hasNext()) {
				this.currentObjects.put(template, this.allIterators[index].next());
				if (index + 1 == this.objectTemplates.length) {
					return true;
				} else if (this.initializeIterators(index + 1)) {
					return true;
				}
			}
			for (int w = index; w < this.objectTemplates.length; w++) {
				this.allIterators[w] = null;
			}
			if (this.failedClause == null) {
				this.failedClause = template;
			}
			return false;
		}
		throw new RuntimeException("Internal error in QvtOptimizedSemanticBindingIterator: Nested object template not part of a PropertyTemplateItem");
	}

	/**
	 * Returns the index of a template in the {@link #objectTemplates} array. Only for documentation purpose.
	 * 
	 * @param template
	 * @return
	 */
	private int index(ObjectTemplateExp template) {
		for (int i = 0; i < this.objectTemplates.length; i++) {
			if (this.objectTemplates[i] == template) {
				return i;
			}
		}
		return -1;
	}

	public QvtProcessorImpl getQvtProcessor() {
		return this.processor;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the failedClause
	 */
	public SemanticsVisitable getFailedClause() {
		return this.failedClause;
	}
}
