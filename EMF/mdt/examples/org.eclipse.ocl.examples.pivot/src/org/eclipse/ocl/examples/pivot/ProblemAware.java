/**
 * <copyright>
 *
 * Copyright (c) 2009 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ProblemAware.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * A mix-in interface indicating that implementations can provide problem
 * diagnostics.
 * 
 * @since 1.3
 * 
 * @author dvorak
 */
public interface ProblemAware {

	/**
	 * Retrieves the problems available on this problem aware object
	 * 
	 * @return the diagnostic object representing the problems or
	 *         <code>null</code> in case that no problems are available.
	 */
	Diagnostic getProblems();
}
