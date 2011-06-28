/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrettyPrintTypeVisitor.java,v 1.7 2011/05/22 21:06:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.prettyprint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 */
public class PrettyPrintTypeVisitor extends AbstractExtendingVisitor<Object,Namespace>
{
	public static final String NULL_PLACEHOLDER = "<null>";
	public static Set<String> reservedNames = new HashSet<String>();
	public static Set<String> restrictedNames = new HashSet<String>();
	private static String[] reservedNameList = {"and", "else", "endif", "false", "if", "implies", "in", "invalid", "let", "not", "null", "or", "self", "then", "true", "xor"};
	private static String[] restrictedNameList = {"Bag", "Boolean", "Collection", "Integer", "OclAny", "OclInvalid", "OclVoid", "OrderedSet", "Real", "Sequence", "Set", "String", "Tuple", "UnlimitedNatural"};
	
	
	static {
		for (String name : reservedNameList) {
			reservedNames.add(name);
			restrictedNames.add(name);
		}
		for (String name : restrictedNameList) {
			restrictedNames.add(name);
		}
	}
	
	public static String prettyPrint(Visitable element, Namespace scope) {
		PrettyPrintTypeVisitor visitor = new PrettyPrintTypeVisitor(scope);
		try {
			visitor.safeVisit(element);
			return visitor.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return visitor.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}
	
	protected final Namespace scope = null;
	protected final StringBuffer s = new StringBuffer();

	/**
	 * Initializes me.
	 */
	public PrettyPrintTypeVisitor(Namespace scope) {
		super(scope);
	}

	protected void append(Number number) {
		if (number != null) {
			s.append(number.toString());
		}
		else {
			s.append(NULL_PLACEHOLDER);
		}
	}

	protected void append(String string) {
		if (string != null) {
			s.append(string);
		}
		else {
			s.append(NULL_PLACEHOLDER);
		}
	}

	protected void appendElement(Element element) {
		safeVisit(element);
	}

	protected void appendName(NamedElement object) {
		appendName(object, restrictedNames);
	}
		
	protected void appendName(NamedElement object, Set<String> keywords) {
		if (object == null) {
			s.append(NULL_PLACEHOLDER);
		}
		else {
			String name = object.getName();
			if ((keywords != null) && (keywords.contains(name) || !PivotUtil.isValidIdentifier(name))) {
				s.append("_'");
				s.append(PivotUtil.convertToOCLString(name));
				s.append("'");
			}
			else {
				s.append(name);
			}
		}
	}

	protected void appendParameters(Operation operation) {
		append("(");
		String prefix = ""; //$NON-NLS-1$
		if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			for (Parameter parameter : iteration.getOwnedIterators()) {
				s.append(prefix);
				appendTypedMultiplicity(parameter);
				prefix = ",";
			}
			if (iteration.getOwnedAccumulators().size() > 0) {
				prefix = ";";
				for (Parameter parameter : iteration.getOwnedAccumulators()) {
					s.append(prefix);
					appendTypedMultiplicity(parameter);
					prefix = ",";
				}
			}
			prefix = "|";
		}
		for (Parameter parameter : operation.getOwnedParameters()) {
			append(prefix);
			appendTypedMultiplicity(parameter);
			prefix = ",";
		}
		append(")");
	}

	protected void appendParent(EObject scope, Element element, String parentSeparator) {
//		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
//			append(OVERFLOW_MARKER);
//		}
		if (element == null) {
			append(NULL_PLACEHOLDER);	
		}
		else {
//			EObject parent = element.eContainer();
			EObject parent = PrettyPrintNameVisitor.getNamespace(element.eContainer());
			if ((parent instanceof org.eclipse.ocl.examples.pivot.Package) &&
					PivotConstants.ORPHANAGE_NAME.equals(((org.eclipse.ocl.examples.pivot.Package)parent).getName())) {
				return;
			}
			if ((element instanceof Operation) &&
				(parent instanceof org.eclipse.ocl.examples.pivot.Class) &&
					PivotConstants.ORPHANAGE_NAME.equals(((org.eclipse.ocl.examples.pivot.Class)parent).getName())) {
				Operation operation = (Operation)element;
				append(operation.getClass_().getName());
				appendTemplateBindings(operation);
				append(parentSeparator);
				return;
			}
			if (parent == scope) {
				return;
			}
			if (parent instanceof Visitable) {
				safeVisit((Visitable) parent);
			}
			else  {
				assert element instanceof org.eclipse.ocl.examples.pivot.Package || element instanceof ExpressionInOcl : element.eClass().getName();	
			}
		}
		append(parentSeparator);
	}
	
	protected void appendTemplateBindings(TemplateableElement typeRef) {
		boolean useParentheses = typeRef instanceof CollectionType;
		List<TemplateBinding> templateBindings = typeRef.getTemplateBindings();
		if (!templateBindings.isEmpty()) {
			append(useParentheses ? "(" : "<");
			String prefix = ""; //$NON-NLS-1$
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
					append(prefix);
					appendElement(templateParameterSubstitution.getActual());
					prefix = ", ";
				}
			}
			append(useParentheses ? ")" : ">");
		}
	}

	public void appendTemplateParameters(TemplateableElement templateableElement) {
		boolean useParentheses = templateableElement instanceof CollectionType;
		TemplateSignature templateSignature = templateableElement.getOwnedTemplateSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (!templateParameters.isEmpty()) {
				s.append(useParentheses ? "(" : "<");
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					s.append(prefix);
//					emittedTemplateParameter(templateParameter);
					appendName((NamedElement) templateParameter.getParameteredElement(), restrictedNames);
					prefix = ", ";
				}
				s.append(useParentheses ? ")" : ">");
			}
		}
	}

	public void appendTypedMultiplicity(TypedMultiplicityElement object) {
		int lower = object.getLower().intValue();
		int upper = object.getUpper().intValue();
		if (upper != 1) {
			if (object.isOrdered()) {
				if (object.isUnique()) {
					append("OrderedSet<");
				}
				else {
					append("Sequence<");
				}
			}
			else {
				if (object.isUnique()) {
					append("Set<");
				}
				else {
					append("Bag<");
				}
			}
			appendElement(object.getType());
			if ((lower > 0) || (upper >= 0)) {
				PivotUtil.appendMultiplicity(s, lower, upper);
			}
			append(">");
		}
		else {
			appendElement(object.getType());
			PivotUtil.appendMultiplicity(s, lower, upper);
		}
	}

	@Override
	public String toString() {
		return s.toString();
	}

	@Override
	public Object visitLambdaType(LambdaType object) {
//		appendParent(object.eContainer(), object, "::");
		appendName(object, restrictedNames);
		s.append(" ");
		appendElement(object.getContextType());
		append("(");
		String prefix = ""; //$NON-NLS-1$
		for (Type parameterType : object.getParameterTypes()) {
			append(prefix);
			appendElement(parameterType);
//			appendMultiplicity(parameter);
			prefix = ",";
		}
		append(") : ");
		appendElement(object.getResultType());
		return null;
	}

	@Override
	public String visitNamedElement(NamedElement object) {
		appendParent(null, object, "::");
		appendName(object, reservedNames);
		return null;
	}

	@Override
	public Object visitOperation(Operation operation) {
		appendParent(null, operation, "::");
		appendName(operation, reservedNames);
		appendTemplateParameters(operation);
		appendTemplateBindings(operation);
		append("(");
		String prefix = ""; //$NON-NLS-1$
		if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			for (Parameter parameter : iteration.getOwnedIterators()) {
				s.append(prefix);
				appendTypedMultiplicity(parameter);
				prefix = ",";
			}
			if (iteration.getOwnedAccumulators().size() > 0) {
				prefix = ";";
				for (Parameter parameter : iteration.getOwnedAccumulators()) {
					s.append(prefix);
					appendTypedMultiplicity(parameter);
					prefix = ",";
				}
			}
			prefix = "|";
		}
		for (Parameter parameter : operation.getOwnedParameters()) {
			append(prefix);
			appendTypedMultiplicity(parameter);
			prefix = ",";
		}
		append(")");
		return null;
	}

	@Override
	public Object visitTemplateParameter(TemplateParameter object) {
		appendName((NamedElement) object.getParameteredElement(), restrictedNames);
		return null;
	}

	@Override
	public Object visitTupleType(TupleType object) {
//		appendParent(object.eContainer(), object, "::");
		appendName(object, null);
		s.append("(");
		List<Property> tupleParts = object.getOwnedAttributes();
		if (!tupleParts.isEmpty()) {
			String prefix = ""; //$NON-NLS-1$
			for (Property tuplePart : tupleParts) {
				append(prefix);
				appendName(tuplePart, restrictedNames);
				append(" : ");
				appendElement(tuplePart.getType());
				prefix = ", ";
			}
		}
		s.append(")");
		return null;
	}

	@Override
	public Object visitType(Type object) {
		appendParent(object.eContainer(), object, "::");
		appendName(object, reservedNames);
		appendTemplateParameters(object);
		appendTemplateBindings(object);
		return null;
	}

	@Override
	public Object visitTypedElement(TypedElement object) {
		appendParent(object.eContainer(), object, "::");
		appendElement(object.getType());
		return null;
	}

	@Override
	public Object visitTypedMultiplicityElement(TypedMultiplicityElement object) {
		appendParent(object.eContainer(), object, "::");
		appendTypedMultiplicity(object);
		return null;
	}

	public String visiting(Visitable visitable) {
		return (visitable == null)? NULL_PLACEHOLDER : visitable.getClass().getName();
	}
}
