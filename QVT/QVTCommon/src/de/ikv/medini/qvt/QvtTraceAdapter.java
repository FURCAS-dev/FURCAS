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

package de.ikv.medini.qvt;

import java.util.Collection;

import de.ikv.medini.qvt.model.qvtbase.Transformation;

/**
 * The QVT trace adapter is needed by the QVT engine to handle traces resulting from transformations executions.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public interface QvtTraceAdapter {

	/**
	 * Sets the QVT processor executing the transformation.
	 * 
	 * @param qvtProcessor
	 *            the QVT processor executing the transformation.
	 */
	void setQvtProcessor(QvtProcessorImpl qvtProcessor);

	/**
	 * Sets the transformation that is being executed.
	 * 
	 * @param transformation
	 *            the transformation being executed.
	 * @deprecated use {@link #setAllTransormations(Collection)}
	 */
	void setTransormation(Transformation transformation);

	/**
	 * Sets all transformations including the executed and imported ones. The executed transformation should be the first in the list.
	 * 
	 * @param allTransformations
	 *            all transformations including the executed and imported ones.
	 */
	void setAllTransormations(Collection allTransformations);

	/**
	 * Loads the traces of the previous transformation execution.
	 * 
	 * @return a collection of {@link Trace}s of the previous transformation execution. The collection is empty if no traces exist.
	 */
	Collection loadTraces();

	/**
	 * Stores the given traces of the transformation execution.
	 * 
	 * @param traces
	 *            the traces to store.
	 */
	void storeTraces(Collection traces);

}
