/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLLabelProvider.java,v 1.1 2010/03/11 14:52:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.imp;

import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.examples.editor.ocl.ui.OCLPlugin;
import org.eclipse.ocl.examples.editor.ui.imp.CommonLabelProvider;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonPlugin;

public class OCLLabelProvider extends CommonLabelProvider
{
	@Override
	protected String formatEnum(Enum<?> object) {
		if (object instanceof DotOrArrowEnum) {
			switch (((DotOrArrowEnum)object).getValue()) {
			case DotOrArrowEnum.DOT: return ".";
			case DotOrArrowEnum.ARROW: return "->";
			case DotOrArrowEnum.NONE: return "";
			}
		}
		return super.formatEnum(object);
	}

	@Override
	protected String formatObject(Object node) {
		if (node instanceof IsMarkedPreCS) {
			return " @pre";
		}
		if (node instanceof BooleanLiteralExpCS) {
			BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)node;
			Boolean booleanSymbol = booleanLiteralExpCS.getBooleanSymbol();
			return (booleanSymbol != null) && booleanSymbol ? "true" : "false";
		}
		return super.formatObject(node);
	}

	@Override
	protected ICommonPlugin getPlugin() {
		return OCLPlugin.getInstance();
	}
}
