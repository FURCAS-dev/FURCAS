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

import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class IStructuredSelectionLabelGenerator extends AbstractLabelGenerator<IStructuredSelection>
{
	public static void initialize(Registry registry) {
		registry.install(IStructuredSelection.class, new IStructuredSelectionLabelGenerator());		
	}
	
	public IStructuredSelectionLabelGenerator() {
		super(IStructuredSelection.class);
	}

	public void buildLabelFor(Builder s, IStructuredSelection object) {
		if (object == null)
			s.appendString("<null-selection>");
		else if (object.size() == 0)
			s.appendString("<empty-selection>");
		else {
			Boolean first = true;
			s.appendString("{");
			for (Iterator<?> i = object.iterator(); i.hasNext(); ) {
				if (!first)
					s.appendString(",");
				else
					first = false;
				s.buildLabelFor(i.next());
			}
			s.appendString("}");
		}
	}
}