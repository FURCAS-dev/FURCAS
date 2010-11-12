/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.label;

import org.eclipse.ocl.examples.common.label.ILabelGenerator;
import org.eclipse.ocl.examples.common.label.LabelGeneratorRegistry;

public class EditorLabelGeneratorRegistry extends LabelGeneratorRegistry
{
	public static void initialize(ILabelGenerator.Registry manager) {
		LabelGeneratorRegistry.initialize(manager);
		IStructuredSelectionLabelGenerator.initialize(manager);
		ModelTreeNodeLabelGenerator.initialize(manager);
	}
}