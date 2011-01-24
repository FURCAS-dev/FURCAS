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
 * $Id: EssentialOCLLabelProvider.java,v 1.4 2011/01/24 21:30:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;

import com.google.inject.Inject;

/**
 * Provides labels for EssentialOCL objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class EssentialOCLLabelProvider extends BaseLabelProvider
{
	@Inject
	public EssentialOCLLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected void appendTemplateParameter(StringBuffer s, TemplateParameterCS templateParameter) {
		appendName(s, templateParameter);
	}

	@Override
	protected void appendType(StringBuffer s, Type type) {
		if (type instanceof CollectionTypeCS) {
			appendName(s, (CollectionTypeCS)type);
			s.append("<");
			appendType(s, ((CollectionTypeCS)type).getOwnedType());
			s.append(">");
		}
		else if (type instanceof TupleTypeCS) {
			appendName(s, (TupleTypeCS)type);
			s.append("Tuple<");
			String prefix = "";
			for (TuplePartCS part : ((TupleTypeCS)type).getOwnedParts()) {
				s.append(prefix);
				appendName(s, part);
				s.append(" : ");
				appendType(s, part.getOwnedType());
				prefix = ", ";
			}
			s.append(">");
		}
		else if (type instanceof NameExpCS) {
//			appendName(s, ((NameExpCS)type).getNamedElement());
		}
		else {
			super.appendType(s, type);
		}	
	}

/*	protected String text(InfixExpCS ele) {
		String op = ele.getOp();
		if (!".".equals(op) &&  !"->".equals(op)) {
			return op;
		}
	StringBuffer s = new StringBuffer();
	appendString(s, op);
	ExpCS argument = ele.getArgument();
	if (argument instanceof NamedExpCS) {
		s.append(" ");
		appendName(s, ((NamedExpCS)argument).getName().getNamedElement());
		if (((NamedExpCS) argument).isPre()) {
			s.append(" @pre");
		}
	}
	return s.toString();
	} */

}
