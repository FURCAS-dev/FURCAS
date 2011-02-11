/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D. Willink - Robustness enhancements (null-proofing)
 *   Adolfo Sanchez- Barbudo Herrera - 228841 Fix NPE in VariableExp
 *
 * </copyright>
 *
 * $Id: ToStringVisitor.java,v 1.5 2011/02/11 20:00:28 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.utilities;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.CompleteIteration;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 * @author Edward Willink (ewillink)
 */
public class ToStringVisitor extends AbstractExtendingVisitor<String, String>
{
	/**
	 * Indicates where a required element in the AST was <code>null</code>, so
	 * that it is evident in the debugger that something was missing. We don't
	 * want just <code>"null"</code> because that would look like the OclVoid
	 * literal.
	 */
	protected static String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * environment.
	 * 
	 * @param env
	 *            an OCL environment
	 * 
	 * @return the corresponding instance
	 */
	@Deprecated
	public static ToStringVisitor getInstance(Environment env) {
		return new ToStringVisitor();
	}

	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * expression or other typed element.
	 * 
	 * @param element
	 *            an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	@Deprecated
	public static ToStringVisitor getInstance(TypedElement element) {
		return new ToStringVisitor();
	}

	protected StringBuffer result = new StringBuffer();

	/**
	 * Initializes me.
	 */
	public ToStringVisitor() {
		super(null);
	}

	/*
	 * protected List<? extends EObject> getConstrainedElements(Constraint
	 * constraint) { if (uml == null) { return Collections.emptyList(); } else {
	 * return uml.getConstrainedElements(constraint); } }
	 * 
	 * protected String getStereotype(Constraint constraint) { return (uml ==
	 * null)? null : uml.getStereotype(constraint); }
	 * 
	 * @Override protected ExpressionInOcl getSpecification(Constraint
	 * constraint) { return (uml == null)? null :
	 * uml.getSpecification(constraint); }
	 */

	protected void append(Number number) {
		if (number != null) {
			result.append(number.toString());
		}
		else {
			result.append(NULL_PLACEHOLDER);
		}
	}

	protected void append(String string) {
		if (string != null) {
			result.append(string);
		}
		else {
			result.append(NULL_PLACEHOLDER);
		}
	}

	protected void appendAtPre(FeatureCallExp mpc) {
		if (mpc.isPre()) {
			append("@pre"); //$NON-NLS-1$
		}
	}

	protected void appendName(NamedElement object) {
		if (object == null) {
			result.append(NULL_PLACEHOLDER);
		}
		else {
			result.append(object.getName());
		}
	}

	protected void appendQualifiedName(NamedElement object) {
		if (object == null) {
			result.append(NULL_PLACEHOLDER);
		}
		else {
			EObject container = object.eContainer();
			if (container instanceof NamedElement) {
				appendQualifiedName((NamedElement) container);
				append("::"); //$NON-NLS-1$
			}
			appendName(object);
			if (object instanceof TemplateableElement) {
				TemplateableElement templateableElement = (TemplateableElement) object;
				appendTemplateBindings(templateableElement.getTemplateBindings());
				appendTemplateSignature(templateableElement.getOwnedTemplateSignature());
			}
		}
	}

	protected void appendQualifiedName(NamedElement parent, String separator, NamedElement child) {
		if (parent != null) {
			appendQualifiedName(parent);
			append(separator);
		}
		appendName(child);
	}

	protected void appendOperationSignature(Operation operation) {
		appendName(operation);
		append("(");
		boolean comma = false;
		for (java.util.Iterator<Parameter> iter = operation
			.getOwnedParameters().iterator(); iter.hasNext();) {
			Parameter parm = iter.next();

			if (comma) {
				append(", "); //$NON-NLS-1$
			} else {
				comma = true;
			}

			appendName(parm);
			append(" : "); //$NON-NLS-1$

			if (parm.getType() != null) {
				appendName(parm.getType());
			} else {
				append("OclVoid"); //$NON-NLS-1$
			}
		}

		append(") :"); //$NON-NLS-1$
		if (operation.getType() != null) {
			append(" ");
			appendName(operation.getType());
		}
	}

	protected void appendPropertySignature(Property property) {
		appendName(property);
		if (property.getType() != null) {
			append(" : ");
			appendName(property.getType()); //$NON-NLS-1$
		}
	}

	protected void appendTemplateBindings(List<TemplateBinding> templateBindings) {
		if (templateBindings.size() > 0) {
			append("<");
			String prefix = ""; //$NON-NLS-1$
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding
					.getParameterSubstitutions()) {
					append(prefix);
					safeVisit(templateParameterSubstitution.getActual());
					prefix = ",";
				}
			}
			append(">");
		}
	}

	protected void appendTemplateSignature(TemplateSignature templateSignature) {
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (!templateParameters.isEmpty()) {
				append("<");
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					append(prefix);
					safeVisit(templateParameter.getParameteredElement());
					prefix = ",";
				}
				append(">");
			}
		}
	}

	@Override
	public String toString() {
		return result.toString();
	}

	/**
	 * Callback for an AssociationClassCallExp visit.
	 * 
	 * @param ac
	 *            the association class expression
	 * @return string source.ref
	 */
	@Override
	public String visitAssociationClassCallExp(AssociationClassCallExp ac) {
		safeVisit(ac.getSource());
		append("."); //$NON-NLS-1$
		appendName(ac.getReferredAssociationClass()); //$NON-NLS-1$
		appendAtPre(ac);
        List<OclExpression> qualifiers = ac.getQualifiers();
		if (!qualifiers.isEmpty()) {
			append("[");
			safeVisit(qualifiers.get(0));
			append("]");
		}
		return null;
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * 
	 * @param bl
	 *            -- boolean literal expression
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
	public String visitBooleanLiteralExp(BooleanLiteralExp bl) {
		append(Boolean.toString(bl.isBooleanSymbol()));
		return null;
	}

	@Override
	public String visitClass(org.eclipse.ocl.examples.pivot.Class cls) {
		TemplateParameter owningTemplateParameter = cls.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			appendName(cls);
		}
		else {
			appendQualifiedName(cls.getPackage(), "::", cls);
			appendTemplateBindings(cls.getTemplateBindings());
			appendTemplateSignature(cls.getOwnedTemplateSignature());
		}
		return null;
	}
    
    /**
     * Visits the item's item expression.
     * 
     * Returns the result of {@link #handleCollectionItem(CollectionItem, Object)}
     */
    @Override
	public String visitCollectionItem(CollectionItem item) {
    	safeVisit(item.getItem());  	
        return null;
    }

    /**
     * Visits the collection literal's parts.
     * 
     * Returns the result of {@link #handleCollectionLiteralExp(CollectionLiteralExp, List)}.
     */
	@Override
	public String visitCollectionLiteralExp(CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		switch (cl.getKind()) {
			case SET :
				append("Set {");//$NON-NLS-1$
				break;
			case ORDERED_SET :
				append("OrderedSet {");//$NON-NLS-1$
				break;
			case BAG :
				append("Bag {");//$NON-NLS-1$
				break;
			case SEQUENCE :
				append("Sequence {");//$NON-NLS-1$
				break;
			default :
				append("Collection {");//$NON-NLS-1$
				break;
		}
        boolean isFirst = true;
		for (CollectionLiteralPart part : cl.getParts()) {
			if (!isFirst) {
				append(", ");
			}
            safeVisit(part);
			isFirst = false;
		}
		append("}");
		return null;
	}
    
    /**
     * Visits the range's first and last expressions.
     * 
     * Returns the result of {@link #handleCollectionRange(CollectionRange, Object, Object)}.
     */
    @Override
	public String visitCollectionRange(CollectionRange range) {
        safeVisit(range.getFirst());
        append(" .. ");
        safeVisit(range.getLast());
        return null;
    }

	@Override
	public String visitCollectionType(CollectionType object) {
		appendName(object);
		appendTemplateBindings(object.getTemplateBindings());
		appendTemplateSignature(object.getOwnedTemplateSignature());
		return null;
	}

	@Override
	public String visitCompleteIteration(CompleteIteration object) {
		safeVisit(object.getModel());
		return null;
	}

	@Override
	public String visitCompleteOperation(CompleteOperation object) {
		safeVisit(object.getModel());
		return null;
	}

	@Override
	public String visitCompletePackage(CompletePackage object) {
		safeVisit(object.getModel());
		return null;
	}

	@Override
	public String visitCompleteProperty(CompleteProperty object) {
		safeVisit(object.getModel());
		return null;
	}

	@Override
	public String visitCompleteType(CompleteType object) {
		safeVisit(object.getModel());
		return null;
	}

	/**
	 * Renders a constraint with its context and expression.
	 */
	@Override
	public String visitConstraint(Constraint constraint) {
		List<? extends EObject> constrained = constraint.getConstrainedElements();
		if (!constrained.isEmpty()) {
			EObject elem = constrained.get(0);
			append("context "); //$NON-NLS-1$
			if (elem instanceof Type) {
				appendName((NamedElement) elem);
			} else if (elem instanceof Operation) {
				Operation oper = (Operation) elem;
				appendOperationSignature(oper);
			} else if (elem instanceof Property) {
				Property prop = (Property) elem;
				appendPropertySignature(prop);
			}
			append(" ");
		}

		String stereo = constraint.getStereotype();
		append(stereo); //$NON-NLS-1$
		String name = constraint.getName();
		if (name != null) {
			append(" "); //$NON-NLS-1$
			append(name);
		}
		append(": "); //$NON-NLS-1$
/* FIXME def context
		EObject elem = constrained.get(1);
		if (elem instanceof Operation) {
			appendOperationSignature((Operation) elem);
		} else if (elem instanceof Property) {
			appendPropertySignature((Property) elem);
		}
		append(" = "); //$NON-NLS-1$
*/
		safeVisit(constraint.getSpecification());
		return null;
	}

	/**
	 * Callback for an EnumLiteralExp visit.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal toString()
	 */
	@Override
	public String visitEnumLiteralExp(EnumLiteralExp el) {
		appendQualifiedName(el.getReferredEnumLiteral());
		return null;
	}

	@Override
	public String visitEnumerationLiteral(EnumerationLiteral el) {
		appendQualifiedName(el.getEnumeration(), "::", el);
		return null;
	}

	/**
	 * Renders an ExpressionInOcl with its context variables and body.
	 */
	@Override
	public String visitExpressionInOcl(ExpressionInOcl expression) {
		return safeVisit(expression.getBodyExpression());
	}

    /**
     * Visits the expressions context variable, its parameter variables (if any),
     * its result variable (if any), and finally its body expression.
     * 
     * Returns the result of
     * {@link #handleExpressionInOCL(ExpressionInOCL, Object, Object, List, Object)}.
     *
    @Override
	public T visitExpressionInOcl(ExpressionInOcl expression) {
        T contextResult = safeVisit(expression.getContextVariable());
        
        Variable resultVar = expression.getResultVariable();
        T resultResult = safeVisit(resultVar);
        
        List<T> parameterResults;
        List<Variable> parameters = expression.getParameterVariables();
        
        if (parameters.isEmpty()) {
            parameterResults = Collections.emptyList();
        } else {
            parameterResults = new java.util.ArrayList<T>(parameters.size());
            for (Variable iterVar : parameters) {
                parameterResults.add(safeVisit(iterVar));
            }
        }
        
        T bodyResult = safeVisit(expression.getBodyExpression());
        
        return handleExpressionInOcl(expression, contextResult, resultResult,
            parameterResults, bodyResult);
    } */

	/**
	 * Callback for an IfExp visit.
	 * 
	 * @param ifExp
	 *            an IfExp
	 * @return the string representation
	 */
	@Override
	public String visitIfExp(IfExp ifExp) {
		append("if ");  //$NON-NLS-1$
		safeVisit(ifExp.getCondition());
		append(" then "); //$NON-NLS-1$
		safeVisit(ifExp.getThenExpression());
		append(" else "); //$NON-NLS-1$
		safeVisit(ifExp.getElseExpression());
		append(" endif"); //$NON-NLS-1$
		return null;
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 * 
	 * @param il
	 *            -- integer literal expression
	 * @return String
	 */
	@Override
	public String visitIntegerLiteralExp(IntegerLiteralExp il) {
		append(il.getIntegerSymbol());
		return null;
	}

	@Override
	public String visitInvalidLiteralExp(InvalidLiteralExp il) {
		append("invalid");
		return null;
	}

	/**
	 * Callback for an IterateExp visit.
	 * 
	 * @param callExp
	 *            an iterate expression
	 * @return the string representation
	 */
	@Override
	public String visitIterateExp(IterateExp callExp) {
		safeVisit(callExp.getSource());
		append("->");
		appendName(callExp.getReferredIteration());
		append("("); //$NON-NLS-1$
		boolean isFirst = true;
		for (Variable variable : callExp.getIterators()) {
			if (!isFirst) {
				append(", ");
			}
            safeVisit(variable);
			isFirst = false;
		}
		append("; ");
		safeVisit(callExp.getResult());
		append(" | ");
		safeVisit(callExp.getBody());
		append(")");//$NON-NLS-1$
		return null;        
	}

	@Override
	public String visitIteration(Iteration iteration) {
		appendQualifiedName(iteration.getClass_(), ".", iteration);
		appendTemplateBindings(iteration.getTemplateBindings());
		appendTemplateSignature(iteration.getOwnedTemplateSignature());
		append("(");
		boolean isFirst = true;
		for (Parameter parameter : iteration.getOwnedIterators()) {
			if (!isFirst) {
				append(", ");
			}
			appendQualifiedName(parameter.getType());
			isFirst = false;
		}
		isFirst = true;
		for (Parameter parameter : iteration.getOwnedAccumulators()) {
			if (!isFirst) {
				append(", ");
			}
			else {
				append("; ");
			}
			appendQualifiedName(parameter.getType());
			isFirst = false;
		}
		append(")");
		return null;
	}

	/**
	 * Callback for an IteratorExp visit.
	 * 
	 * @param callExp
	 *            an iterator expression
	 * @return the string representation
	 */
	@Override
	public String visitIteratorExp(IteratorExp callExp) {
		safeVisit(callExp.getSource());
		append("->");
		appendName(callExp.getReferredIteration());
		append("("); //$NON-NLS-1$
		boolean isFirst = true;
		for (Variable variable : callExp.getIterators()) {
			if (!isFirst) {
				append(", ");
			}
            safeVisit(variable);
			isFirst = false;
		}
		append(" | ");
		safeVisit(callExp.getBody());
		append(")");//$NON-NLS-1$
		return null;        
	}

	/**
	 * Callback for LetExp visit.
	 * 
	 * @param letExp
	 *            a let expression
	 * @return the string representation
	 */
	@Override
	public String visitLetExp(LetExp letExp) {
		append("let "); //$NON-NLS-1$
		safeVisit(letExp.getVariable());
		append(" in "); //$NON-NLS-1$
		safeVisit(letExp.getIn());
		return null;
	}
	
    /**
     * Visits the message expression's target and then its arguments.
     * Returns the result of {@link #handleMessageExp(MessageExp, Object, List)}.
     */
	@Override
	public String visitMessageExp(MessageExp messageExp) {
		safeVisit(messageExp.getTarget());
		append((messageExp.getType() instanceof CollectionType) ? "^^" : "^"); //$NON-NLS-1$//$NON-NLS-2$
		if (messageExp.getCalledOperation() != null) {
			appendName(messageExp.getCalledOperation().getOperation());
		} else if (messageExp.getSentSignal() != null) {
			appendName(messageExp.getSentSignal().getSignal());
		}
		append("(");
		String prefix = "";
		for (OclExpression argument : messageExp.getArguments()) {
			append(prefix);
            safeVisit(argument);
            prefix = ", "; //$NON-NLS-1$
		}
		append(")");
		return null;
	}

	@Override
	public String visitNullLiteralExp(NullLiteralExp il) {
		append("null");
		return null;
	}

	@Override
	public String visitOpaqueExpression(OpaqueExpression object) {
		String body = PivotUtil.getBody(object);
		if (body != null) {
			append(body);
		}
		return null;
	}

	@Override
	public String visitOperation(Operation operation) {
		appendQualifiedName(operation.getClass_(), ".", operation);
		appendTemplateBindings(operation.getTemplateBindings());
		appendTemplateSignature(operation.getOwnedTemplateSignature());
		append("(");
		boolean isFirst = true;
		for (Parameter parameter : operation.getOwnedParameters()) {
			if (!isFirst) {
				append(",");
			}
			appendQualifiedName(parameter.getType());
			isFirst = false;
		}
		append(")");
		return null;
	}

	/**
	 * Callback for an OperationCallExp visit.
	 * 
	 * Look at the source to determine operator ( -> or . )
	 * 
	 * @param oc
	 *            the operation call expression
	 * @return string
	 */
	@Override
	public String visitOperationCallExp(OperationCallExp oc) {
        safeVisit(oc.getSource());
		Operation oper = oc.getReferredOperation();
		if (oper != null) {
			append(PivotUtil.getFeaturingClass(oper) instanceof CollectionType
					? PivotConstants.COLLECTION_NAVIGATION_OPERATOR
					: PivotConstants.OBJECT_NAVIGATION_OPERATOR);
			appendName(oper);
		} else {
			append(PivotConstants.OBJECT_NAVIGATION_OPERATOR);
			appendName(oc);
		}
		append("(");
		String prefix = "";//$NON-NLS-1$
		for (OclExpression argument : oc.getArguments()) {
			append(prefix);
			safeVisit(argument);
			prefix = ", ";//$NON-NLS-1$
		}
		append(")");
		appendAtPre(oc);
		return null;
	}

	@Override
	public String visitPackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		appendQualifiedName(pkg.getNestingPackage(), "::", pkg);
		return null;
	}

	@Override
	public String visitParameter(Parameter parameter) {
		appendQualifiedName((NamedElement) parameter.eContainer(), ".", parameter);
		return null;
	}

	@Override
	public String visitPrecedence(Precedence precedence) {
		appendName(precedence);
		return null;
	}

	@Override
	public String visitPrimitiveType(PrimitiveType object) {
		appendName(object);
		return null;
	}

	@Override
	public String visitProperty(Property property) {
		appendQualifiedName(property.getClass_(), ".", property);
		return null;
	}

	/**
	 * Callback for an AssociationEndCallExp visit.
	 * 
	 * @param pc
	 *            the property call expression
	 * @return string source.ref
	 */
	@Override
	public String visitPropertyCallExp(PropertyCallExp pc) {
        // source is null when the property call expression is an
        //    association class navigation qualifier
		safeVisit(pc.getSource());
		Property property = pc.getReferredProperty();
		result
			.append(PivotUtil.getFeaturingClass(property) instanceof CollectionType
				? PivotConstants.COLLECTION_NAVIGATION_OPERATOR
				: PivotConstants.OBJECT_NAVIGATION_OPERATOR);
		appendName(property);
		appendAtPre(pc);
        List<OclExpression> qualifiers = pc.getQualifiers();
		if (!qualifiers.isEmpty()) {
			append("["); //$NON-NLS-1$
			String prefix = ""; //$NON-NLS-1$
			for (OclExpression qualifier : qualifiers) {
				append(prefix);
				safeVisit(qualifier);
				prefix = ", "; //$NON-NLS-1$
			}
			append("]");
		}
		return null;
	}

	/**
	 * Callback for a RealLiteralExp visit.
	 * 
	 * @param rl
	 *            -- real literal expression
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
	public String visitRealLiteralExp(RealLiteralExp rl) {
		append(rl.getRealSymbol());
		return null;
	}

	@Override
	public String visitStateExp(StateExp s) {
		appendName(s);
		return null;
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * 
	 * @param sl
	 *            -- string literal expression
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
	public String visitStringLiteralExp(StringLiteralExp sl) {
		append("'");
		append(sl.getStringSymbol());
		append("'");
		return null;
	}

	@Override
	public String visitTemplateBinding(TemplateBinding object) {
		// s.append(getQualifiedName(object.getFormal(), "/", (NamedElement)
		// object.getActual()));
		appendTemplateBindings(Collections.singletonList(object));
		return null;
	}

	@Override
	public String visitTemplateParameter(TemplateParameter object) {
		appendName((NamedElement) object.getSignature().getTemplate());
		append(".");
		appendName((NamedElement) object.getParameteredElement());
		return null;
	}

	@Override
	public String visitTemplateParameterSubstitution(
			TemplateParameterSubstitution object) {
		appendName((NamedElement) object.getFormal().getParameteredElement());
		append("/");
		appendName((NamedElement) object.getActual());
		return null;
	}

	@Override
	public String visitTemplateSignature(TemplateSignature object) {
		// s.append(getQualifiedName(object.getFormal(), "/", (NamedElement)
		// object.getActual()));
		appendTemplateSignature(object);
		return null;
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * 
	 * @param literalExp
	 *            tuple literal expression
	 * @return the string representation
	 */
	@Override
	public String visitTupleLiteralExp(TupleLiteralExp literalExp) {
		append("Tuple{");//$NON-NLS-1$
		String prefix = "";
		for (TupleLiteralPart part : literalExp.getParts()) {
			append(prefix);
            safeVisit(part);
			prefix = ", ";//$NON-NLS-1$
		}
		append("}");
		return null;
	}
	
    /**
     * Visits the tuple literal part's value, if any.
     */
	@Override
	public String visitTupleLiteralPart(TupleLiteralPart part) {
		appendName(part);
		Type type = part.getType();
		if (type != null) {
			append(" : ");
			appendName(type);
		}
		OclExpression initExpression = part.getInitExpression();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public String visitTupleType(TupleType object) {
		super.visitTupleType(object);
		append("{");
		String prefix = "";
		for (TypedElement part : object.getOwnedAttributes()) {
			append(prefix);
			appendName(part);
			prefix = ",";
		}
		append("}");
		return null;
	}

	@Override
	public String visitTypeExp(TypeExp t) {
		appendQualifiedName(t.getReferredType());
		return null;
	}

	/**
	 * Callback for an UnlimitedNaturalLiteralExp visit.
	 * 
	 * @param unl
	 *            -- unlimited natural literal expression
	 * @return String
	 */
	@Override
	public String visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp unl) {
		BigInteger symbol = unl.getUnlimitedNaturalSymbol();
		if (symbol.signum() < 0) {
			append("*");
		}
		else {
			append(symbol);
		}
		return null;
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 * 
	 * @param uv
	 *            - UnspecifiedValueExp
	 * @return the string representation
	 */
	@Override
	public String visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		append("?"); //$NON-NLS-1$
		if (uv.getType() != null && !(uv.getType() instanceof VoidType)) {
			append(" : "); //$NON-NLS-1$
			appendName(uv.getType());
		}
		return null;
	}

    /**
     * Visits the variable's initialization expression (if any).
     * Returns the result of {@link #handleVariable(Variable, Object)}.
     */
	@Override
	public String visitVariable(Variable variable) {
		appendName(variable);
		Type type = variable.getType();
		if (type != null) {
			append(" : ");
			safeVisit(type);
		}
		OclExpression initExpression = variable.getInitExpression();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	/**
	 * Callback for a VariableExp visit.
	 * 
	 * @param v
	 *            the variable expression
	 * @return the variable name
	 */
	@Override
	public String visitVariableExp(VariableExp v) {
		appendName(v.getReferredVariable());
		return null;
	}

	public String visiting(Visitable visitable) {
		return (visitable == null)
			? NULL_PLACEHOLDER
			: visitable.getClass().getName();
	}
} // ToStringVisitorImpl
