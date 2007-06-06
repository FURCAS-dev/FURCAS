/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: QueryUtil.java,v 1.3 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.query.impl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.impl.TypesPackageImpl;
import org.eclipse.emf.ocl.uml.impl.UMLPackageImpl;

/**
 * Utility for creating OCL queries from OCL expression strings.  Removes the
 * complexity of the OCL syntax "around" the expression, itself.
 * 
 * @author Yasser Lulu
 */
final class QueryUtil {

	static {
		//initialize the EMF packages for OCL
		ExpressionsPackageImpl.init();
		TypesPackageImpl.init();
		UMLPackageImpl.init();
	}

	/**
	 * Cannot be instantiated by clients.
	 */
	private QueryUtil() {
		//private
	}

	/**
	 * Creates an OCL query from the specified OCL expression string, for the
	 * given OCL classifier context.
	 * 
	 * @param oclExpressionString the OCL expression text
	 * @param contextEObjectType the OCL classifier context
	 * @return the compiled OCL query object
	 * 
	 * @throws RuntimeException if the OCL expression string is malformed
	 *     or the <code>contextEObjectType</code> is <code>null</code>
	 */
	static Query makeOCLQuery(String oclExpressionString,
			EClassifier contextEObjectType) {
		try {
			return QueryFactory.eINSTANCE.createQuery(
				ExpressionsUtil.createQuery(
					contextEObjectType,
					oclExpressionString,
					true));
		} catch (Exception ex) {
			OCLPlugin.catching(QueryUtil.class, "makeOCLQuery", ex); //$NON-NLS-1$
			IllegalArgumentException rtex = new IllegalArgumentException(ex
				.toString());
			OCLPlugin.throwing(QueryUtil.class, "makeOCLQuery", //$NON-NLS-1$
				rtex);
			throw rtex;
		}
	}
}
