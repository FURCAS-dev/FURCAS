/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.common.util.EList;


/**
 * author edith
 */
/**
 * model
 */
public interface OclMessageExp  extends OclExpression{
	/**
	 * @model
	 */
	public OclExpression getTarget();
	

	/*****ordered***/
	/**
	 * @model type="OclMessageArg" lowerBound=0
	 */
	public EList getArguments();
	
	/**
	 * lowerBound=0
	 */
	// tk -- need to make CallAction -- add @model above
	//public CallAction getCalledOperation();
	

	/**
	 * lowerBound=0
	 */
	// tk -- need to make SendAction -- add @model above
	//public SendAction getSentSignal();

}
