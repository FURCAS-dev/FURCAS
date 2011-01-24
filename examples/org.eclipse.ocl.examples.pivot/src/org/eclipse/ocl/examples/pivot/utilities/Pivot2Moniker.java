/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: Pivot2Moniker.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.ParameterableElement;

public class Pivot2Moniker extends Abstract2Moniker
{
	public static String toString(MonikeredElement pivotElement) {
		Pivot2Moniker moniker = new Pivot2Moniker(pivotElement);
		moniker.appendElement(pivotElement);
		String string = moniker.toString();
		if (TRACE_MONIKERS.isActive()) {
			TRACE_MONIKERS.println(pivotElement.eClass().getName() + " ==> " + string);
		}
		assert !"".equals(string);
		return string;
	}

	public Pivot2Moniker(Element target) {
		super(target);
	}

	public void appendTemplateArguments(List<? extends ParameterableElement> templateArguments) {
		if (!templateArguments.isEmpty()) {
			append(TEMPLATE_BINDING_PREFIX);
			String prefix = ""; //$NON-NLS-1$
			for (ParameterableElement templateArgument : templateArguments) {
				append(prefix);
				appendElement(templateArgument);
				prefix = TEMPLATE_BINDING_SEPARATOR;
			}
			append(TEMPLATE_BINDING_SUFFIX);
		}
	}
}