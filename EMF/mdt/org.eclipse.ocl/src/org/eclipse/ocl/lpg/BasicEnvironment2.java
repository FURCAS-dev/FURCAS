/**
 * <copyright>
 *
 * Copyright (c) 2008 E.D.Willink, Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Zeligsoft - Bug 242236
 *
 * </copyright>
 *
 * $Id: BasicEnvironment2.java,v 1.1 2008/12/30 11:48:35 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import org.eclipse.ocl.cst.CSTNode;

/**
 * A <code>BasicEnvironment2</code> provides an extended environment interface
 * to support asymmetric as well as symmetric mappings between CST and AST.
 * 
 * @since 1.3
 */
public interface BasicEnvironment2
		extends BasicEnvironment {

	/**
	 * Initialize the asymmetric mapping of an object (typically an astNode) to
	 * its originating cstNode, and of a cstNode to its consequent object
	 * (typically an astNode) so that AST-based analysis may report error
	 * messages exploiting the CST context, or to support incremental AST/CST
	 * update. Any pre-existing mapping is preserved. Each mapping involving a
	 * null object is ignored, so that for instance the toAstNode may be set
	 * null to establish only the fromAstNode to cstNode mapping.
	 * 
	 * @param fromAstNode
	 *            source of the AST-to-CST mapping
	 * @param cstNode
	 *            target of the AST-to-CST mapping and source of the CST-to-AST
	 *            mapping
	 * @param toAstNode
	 *            target of the CST-to-AST mapping
	 */
	void initASTMapping(Object fromAstNode, CSTNode cstNode, Object toAstNode);
}
