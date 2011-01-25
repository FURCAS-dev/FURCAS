/**
 * <copyright>
 *
 * Copyright (c) 2002, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Zeligsoft - Bug 207365
 *   E.D.Willink - Bug 259818
 *   
 * </copyright>
 *
 * $Id: OCLSyntaxHelper.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ObjectUtil;
import org.eclipse.ocl.util.UnicodeSupport;

/**
 * Engine for computation of possible syntax completions at a point in the
 * an OCL expression.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
final class OCLSyntaxHelper {

	OCLSyntaxHelper(Environment env) {
	}
	
	/**
	 * Gets the name of a named <code>elem</code>ent with its initial character
	 * in lower case.
	 * 
	 * @param elem a named element
	 * @return the element's name, with an initial lower case letter
	 */
	public static String initialLower(String name) {
		StringBuffer result = new StringBuffer(name);
		
		if (result.length() > 0) {
			UnicodeSupport.setCodePointAt(
					result,
					0,
					UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(result, 0)));
		}
		
		return result.toString();
	}
	
	/**
	 * Disposes not only the specified <tt>object</tt> but all of the objects
	 * in the content tree that contains it, from the root down.
	 * 
	 * @param object an object to dispose utterly
	 * 
	 * @since 1.2
	 */
	static void disposeAll(EObject object) {
	    ObjectUtil.dispose(EcoreUtil.getRootContainer(object));
	}
}
