/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.logger;

/**
 * The interface TraceContext defines the trace context.
 * <p>
 * The context object provides some context relevant information, for example
 * MRI of the model element, etc. To provide this information, the context
 * object must implement the TraceContext interface
 * (com.sap.tc.moin.repository.shared.logger.TraceContext) - implement the
 * getMessage() method. The MOIN Logger calls this method automatically if the
 * message is printed to the log and / or trace file.
 * 
 * @author d029324
 */
public interface TraceContext {

	/**
	 * The getMessage() method returns the context relevant information (text)
	 * which should enlarge the understanding of the particular message and is
	 * reported in the MOIN-specific log and or trace file.
	 * 
	 * @return the context-related object message
	 */
	public String getMessage();
}
