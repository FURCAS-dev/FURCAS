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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclSet;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

import de.ikv.medini.qvt.QvtProcessorImpl;

/**
 * This class implements the {@link Iterator} interface, iterating over the cross product of sets, which are computed by calling <code>allInstances</code> for the type of each
 * nested object template in the relation's source domains. For every tuple of the cross product, {@link #next()} retrieves a {@link RuntimeEnvironment} instance binding the
 * variables to values.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */

public class QvtSemanticBindingIterator implements Iterator {

	/**
	 * Holds the variable declarations of the object templates
	 */
	private VariableDeclaration[] variableDeclarations;

	/**
	 * Array of <code>allInstances</code> sets corresponding to {@link #variableDeclarations}
	 */
	private Collection[] allInstances;

	/**
	 * Array of iterators iterating over the corresponding sets in {@link #allInstances}
	 */
	private Iterator[] allIterators;

	/**
	 * Array of current objects retrieved by the corresponding iterator in {@link #allIterators}
	 */
	private OclAny[] currentObjects;

	/**
	 * Instantiates a new iterator, calculating <code>allInstances</code> for the passed variables.
	 * 
	 * @param variablesToIterate
	 *            The variable declarations of the nested object templates
	 * @param processor
	 */
	// TODO make it better -> collection template
	public QvtSemanticBindingIterator(List variablesToIterate, QvtProcessorImpl processor) {
		this.allInstances = new Collection[variablesToIterate.size()];
		this.variableDeclarations = new VariableDeclaration[variablesToIterate.size()];
		int current = 0;
		boolean isEmpty = false;
		for (Iterator iter = variablesToIterate.iterator(); iter.hasNext();) {
			VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iter.next();
			this.variableDeclarations[current] = currentVariableDeclaration;
			OclSet currentAllInstances = processor.getModelEvaluationAdapter().OclType_allInstances(processor.getStdLibAdapter().Type(currentVariableDeclaration.getType()));
			Collection allJavaInstances = (Collection) currentAllInstances.getImplementation();
			this.allInstances[current] = allJavaInstances;
			current++;
			if (allJavaInstances.isEmpty()) {
				isEmpty = true;
			}
		}
		if (isEmpty) {
			this.allInstances = new Collection[0];
		}
	}

	/**
	 * Determines whether there is a binding available.
	 */
	public boolean hasNext() {

		if (this.allInstances.length == 0) {
			if (this.allIterators == null) {
				return true;
			}
			return false;
		}

		if (this.allIterators == null) {
			this.allIterators = new Iterator[this.allInstances.length];
			for (int i = 0; i < this.allInstances.length; i++) {
				Collection currentAllInstances = this.allInstances[i];
				this.allIterators[i] = currentAllInstances.iterator();
			}
		}
		for (int i = 0; i < this.allIterators.length; i++) {
			if (this.allIterators[i].hasNext()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the binding as {@link RuntimeEnvironment} instance
	 */
	public Object next() {

		if (this.allInstances.length == 0) {
			if (this.allIterators == null) {
				this.allIterators = new Iterator[0];
				return new RuntimeEnvironmentImpl();
			}
			throw new NoSuchElementException();
		}

		if (this.hasNext()) {
			if (this.currentObjects == null) {
				this.currentObjects = new OclAny[this.allInstances.length];
				for (int i = 0; i < this.allIterators.length; i++) {
					this.currentObjects[i] = (OclAny) this.allIterators[i].next();
				}
			} else {
				boolean goOn = true;
				for (int i = this.allIterators.length - 1; i >= 0 && goOn; i--) {
					if (this.allIterators[i].hasNext()) {
						this.currentObjects[i] = (OclAny) this.allIterators[i].next();
						goOn = false;
					} else {
						this.allIterators[i] = this.allInstances[i].iterator();
						this.currentObjects[i] = (OclAny) this.allIterators[i].next();
					}
				}
			}
			RuntimeEnvironment runtimeEnvironment = new RuntimeEnvironmentImpl();
			for (int i = 0; i < this.variableDeclarations.length; i++) {
				runtimeEnvironment.setValue(this.variableDeclarations[i].getName(), this.currentObjects[i]);
			}
			return runtimeEnvironment;
		}
		throw new NoSuchElementException();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
