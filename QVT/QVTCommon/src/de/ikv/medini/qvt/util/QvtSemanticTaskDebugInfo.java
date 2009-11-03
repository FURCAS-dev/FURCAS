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

package de.ikv.medini.qvt.util;

import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;

import de.ikv.medini.qvt.QvtModelManipulationAdapter;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

/**
 * @author ekine
 * 
 */
public class QvtSemanticTaskDebugInfo {

	/**
	 * If the task failed, stores the failing "when" clause for better debugging.
	 */
	public SemanticsVisitable failedClause = null;

	/**
	 * Counts how often {@link QvtModelManipulationAdapter#setOrAddValueForFeauture(OclAnyModelElement, Property, OclAny)} is called.
	 */
	public static int setOrAddValueForFeautureCount = 0;

	/**
	 * Counts how often {@link QvtModelManipulationAdapter#createOclAnyModelElement(OclModelElementType, TypedModel)} is called. This information is e.g. useful when
	 * re-transforming into some direction, expecting no new model elements to be created.
	 */
	public static int createOclAnyModelElementCount = 0;

	public int succussfullBindings = 0;

	public int unsuccussfullBindings = 0;

	public static int getTotalModificationCount() {
		return QvtSemanticTaskDebugInfo.createOclAnyModelElementCount + QvtSemanticTaskDebugInfo.setOrAddValueForFeautureCount;
	}
}
