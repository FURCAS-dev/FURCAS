/*******************************************************************************
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.label;

import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class ModelTreeNodeLabelGenerator extends AbstractLabelGenerator<ModelTreeNode>
{
	public static void initialize(Registry registry) {
		registry.install(ModelTreeNode.class, new ModelTreeNodeLabelGenerator());		
	}
	
	public ModelTreeNodeLabelGenerator() {
		super(ModelTreeNode.class);
	}

	public void buildLabelFor(Builder s, ModelTreeNode object) {
		s.appendString("[");
		s.appendObject(object.getASTNode());
		s.appendString("]");
	}
}