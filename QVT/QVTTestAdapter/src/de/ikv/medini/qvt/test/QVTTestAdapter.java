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

package de.ikv.medini.qvt.test;

import java.util.List;

/**
 * Interface which is used by QVT test cases and which must be implemented by concrete technologies as e.g. EMF.
 */
public interface QVTTestAdapter extends de.ikv.medini.ocl.test.OCLTestAdapter {

	static String QVTTESTADAPTER_INPLACE = "inplace";

	static String QVTTESTADAPTER_TWOSOURCEMODELS = "twoSourceModels";

	static final String PROP_DISABLE_TRACES = "traces";

	static String QVTTESTADAPTER_THREEDOMAINS = "threeDomains";

	/**
	 * Evaluates the given QVT script in the given direction.
	 * 
	 * @param qvtFile
	 *            the qvtFile.
	 * @param transformationName
	 *            the transformation name.
	 * @param enforce
	 *            the enforcement mode.
	 * @param direction
	 *            the execution direction.
	 */
	void evaluateQVT(String qvtFile, String transformationName, boolean enforce, String direction);

	void evaluateQVTBackward(String qvtFile, String transformationName, boolean enforce, String direction);

	List evaluateOnTarget(String string);

	List evaluateOnSource(String string);

	/**
	 * Creates a model element of the given <code>modelElementType</code>.
	 * 
	 * @param modelElementType
	 *            the model element type.
	 * @return the newly created object.
	 */
	Object createModelElementInTarget(String modelElementType);

	Object createModelElementInModel(String modelElementType, int modelIndex);

	Object getCreateOclAnyModelElementCount();

	/**
	 * Sets the given property of the QVT engine.
	 * 
	 * @param name
	 *            the property name.
	 * @param value
	 *            the property value.
	 */
	void setQvtProperty(String name, String value);

	boolean supportsMetaModels(String[] metamodelIDs);

	Object getQvtProcessor();

	boolean supportsRandomMode();
}
