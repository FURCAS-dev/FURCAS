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
 * $Id: EssentialOCLLabelProvider.java,v 1.3 2010/05/22 19:02:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.labeling.BaseLabelProvider;

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

	@Override
	protected void appendType(StringBuffer s, TypeCS type) {
		if (type instanceof CollectionTypeCS) {
			appendName(s, (CollectionTypeCS)type);
			s.append("<");
			appendType(s, ((CollectionTypeCS)type).getTypeCS());
			s.append(">");
		}
		else if (type instanceof TupleTypeCS) {
			appendName(s, (TupleTypeCS)type);
			s.append("Tuple<");
			String prefix = "";
			for (VariableCS part : ((TupleTypeCS)type).getPart()) {
				s.append(prefix);
				appendName(s, part);
				s.append(" : ");
				appendType(s, part.getType());
				prefix = ", ";
			}
			s.append(">");
		}
		else if (type instanceof NameExpCS) {
			appendName(s, ((NameExpCS)type).getNamedElement());
		}
		else {
			super.appendType(s, type);
		}	
	}

	protected String image(BooleanLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/BooleanLiteralExp.gif";
	}

	protected String text(BooleanLiteralExpCS ele) {
		return ele.getName();
	}

	protected String image(CollectionLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralExp.gif";
	}

	protected String text(CollectionLiteralExpCS ele) {
		StringBuffer s = new StringBuffer();
		appendType(s, ele.getTypeCS());
		return s.toString();
	}

	protected String image(CollectionLiteralPartCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralPart.gif";
	}

	protected String text(CollectionLiteralPartCS ele) {
		return null;
	}

	protected String image(CollectionTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionType.gif";
	}

	protected String image(IfExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IfExp.gif";
	}

	protected String text(IfExpCS ele) {
		return "if";
	}

	protected String image(InfixExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OperationCallExp.gif";
	}

	protected String text(InfixExpCS ele) {
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
	}

	protected String image(InvalidLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/InvalidLiteralExp.gif";
	}

	protected String text(InvalidLiteralExpCS ele) {
		return "invalid";
	}

	protected String image(LetExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LetExp.gif";
	}

	protected String text(LetExpCS ele) {
		return "let";
	}

	protected String image(NameExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String text(NestedExpCS ele) {
		return null;
	}

	protected String image(NullLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NullLiteralExp.gif";
	}

	protected String text(NullLiteralExpCS ele) {
		return "null";
	}

	protected String image(NumberLiteralExpCS ele) {
		Number number = ele.getName();
		if (number instanceof BigInteger) {
			return "/org.eclipse.ocl.edit/icons/full/obj16/IntegerLiteralExp.gif";
		}
		else {
			return "/org.eclipse.ocl.edit/icons/full/obj16/RealLiteralExp.gif";
		}
	}

	protected String text(NumberLiteralExpCS ele) {
		return ele.getName().toString();
	}

	protected String image(PrefixExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OperationCallExp.gif";
	}

	protected String text(PrefixExpCS ele) {
		return ele.getOp();
	}

	protected String image(PrimitiveTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/PrimitiveType.gif";
	}

	protected String text(RoundBracketExpCS ele) {
		return ele.getName().getNamedElement().getName() + "()";
	}

	protected String image(SelfExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String text(SelfExpCS ele) {
		return "self";
	}

	protected String image(SimpleNameExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String text(SimpleNameExpCS ele) {
		return ele.getNamedElement().getName();
	}

	protected String text(SquareBracketExpCS ele) {
		return ele.getName().getNamedElement().getName() + "[]";
	}

	protected String image(StringLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/StringLiteralExp.gif";
	}

	protected String text(StringLiteralExpCS ele) {
		List<String> names = ele.getName();
		if (names.size() == 1) {
			return names.get(0);
		}
		StringBuffer s = new StringBuffer();
		for (String name : names) {
			s.append(name);
		}
		return s.toString();
	}

	protected String image(TupleLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleLiteralExp.gif";
	}

	protected String text(TupleLiteralExpCS ele) {
		return "Tuple";
	}

	protected String image(TupleTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleType.gif";
	}

	protected String image(VariableCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/Variable.gif";
	}

	protected String text(VariableCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		return s.toString();
	}
}
