/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
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
 * $Id: ToStringVisitor.java,v 1.8 2008/04/26 16:24:08 cdamus Exp $
 */

package org.eclipse.ocl.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitable;

/**
 * Converts an OCL expression to a string for debugging.  This is not intended
 * to be used by client applications as an AST-to-text transformation.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 * @author Edward Willink (ewillink)
 */
public class ToStringVisitor<C, O, P, EL, PM, S, COA, SSA, CT>
	extends AbstractVisitor<String, C, O, P, EL, PM, S, COA, SSA, CT> {

    private final Environment<?, C, O, P, EL, PM, S, COA, SSA, CT, ?, ?> env;
    private final UMLReflection<?, C, O, P, EL, PM, S, COA, SSA, CT> uml;

	
	/**
	 * Indicates where a required element in the AST was <code>null</code>, so
	 * that it is evident in the debugger that something was missing.  We don't
	 * want just <code>"null"</code> because that would look like the OclVoid
	 * literal.
	 */
	protected static String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	/**
	 * Initializes me with my environment.
	 * 
	 * @param env my environment
	 */
	protected ToStringVisitor(Environment<?, C, O, P, EL, PM, S, COA, SSA, CT, ?, ?> env) {
	    this.env = env;
		this.uml = (env == null)? null : env.getUMLReflection();
	}
	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * environment.
	 * 
	 * @param env an OCL environment
	 * 
	 * @return the corresponding instance
	 */
	public static <C, O, P, EL, PM, S, COA, SSA, CT>
	ToStringVisitor<C, O, P, EL, PM, S, COA, SSA, CT> getInstance(
			Environment<?, C, O, P, EL, PM, S, COA, SSA, CT, ?, ?> env) {
		
		return new ToStringVisitor<C, O, P, EL, PM, S, COA, SSA, CT>(env);
	}
	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * expression or other typed element.
	 * 
	 * @param element an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	@SuppressWarnings("unchecked")
	public static <C, O, P, EL, PM, S, COA, SSA, CT>
	ToStringVisitor<C, O, P, EL, PM, S, COA, SSA, CT> getInstance(
			TypedElement<C> element) {
		
		return new ToStringVisitor<C, O, P, EL, PM, S, COA, SSA, CT>(
				(Environment<?, C, O, P, EL, PM, S, COA, SSA, CT, ?, ?>)
					Environment.Registry.INSTANCE.getEnvironmentFor(element));
	}
	
	/**
	 * Null-safe access to the name of a named element.
	 * 
	 * @param named a named element or <code>null</code>
	 * @return a name, or the null placeholder if the named element or its name
	 *    be <code>null</code>.  i.e., <code>null</code> is never returned
	 */
	protected String getName(Object named) {
		return (uml == null)? NULL_PLACEHOLDER : uml.getName(named);
	}
    
    /**
     * Null-safe access to the qualified name of a named element.
     * 
     * @param named a named element or <code>null</code>
     * @return a qualified name, or the null placeholder if the named element
     *    or its name be <code>null</code>.  i.e., <code>null</code> is never
     *    returned
     */
    protected String getQualifiedName(Object named) {
        return (uml == null)? NULL_PLACEHOLDER : uml.getQualifiedName(named);
    }

	/**
	 * Callback for an OperationCallExp visit.
	 * 
	 * Look at the source to determine operator ( -> or . )
	 * @param oc the operation call expression
	 * @return string
	 */
    @Override
    protected String handleOperationCallExp(OperationCallExp<C,O> oc,
            String sourceResult, List<String> argumentResults) {
        
		OCLExpression<C> source = oc.getSource();
		C sourceType = source != null ? source.getType() : null;
		O oper = oc.getReferredOperation();
		
		StringBuffer result = new StringBuffer();
		result.append(sourceResult);
		result.append(sourceType instanceof CollectionType ? "->" : "."); //$NON-NLS-1$ //$NON-NLS-2$
		result.append(getName(oper));
		
        result.append('(');
        for (Iterator<String> iter = argumentResults.iterator(); iter.hasNext();) {
			result.append(iter.next());
			if (iter.hasNext()) {
				result.append(", ");//$NON-NLS-1$
            }
		}
		result.append(')');
        
		return maybeAtPre(oc, result.toString());
	}

	/**
	 * Callback for an EnumLiteralExp visit.  
	 * @param el the enumeration literal expresion
	 * @return the enumeration literal toString()
	 */
	@Override
    public String visitEnumLiteralExp(EnumLiteralExp<C, EL> el) {
		EL l = el.getReferredEnumLiteral();
		return getQualifiedName(l);
	}

	/**
	 * Callback for a VariableExp visit.
	 * @param v the variable expression
	 * @return the variable name
	 */
	@Override
    public String visitVariableExp(VariableExp<C, PM> v) {
		Variable<C, PM> vd = v.getReferredVariable();
		String result = (vd == null) ? null : vd.getName();
		
		if (result == null) {
			result = NULL_PLACEHOLDER;
		}
		
		return result;
	}

	/**
	 * Callback for an AssociationEndCallExp visit. 
	 * @param pc the property call expression
	 * @return string source.ref
	 */
    @Override
    protected String handlePropertyCallExp(PropertyCallExp<C,P> pc,
            String sourceResult, List<String> qualifierResults) {
		P property = pc.getReferredProperty();

        if (sourceResult == null) {
			// if we are the qualifier of an association class call, then
			//   we just return our name, because our source is null (implied)
			return getName(property);
		}
		
		StringBuffer result = new StringBuffer(
			maybeAtPre(pc, sourceResult + "." + getName(property)));//$NON-NLS-1$
		
		if (!qualifierResults.isEmpty()) {
			result.append('[');
			
			for (Iterator<String> iter = qualifierResults.iterator(); iter.hasNext();) {
				result.append(iter.next());
				
				if (iter.hasNext()) {
					result.append(", "); //$NON-NLS-1$
				}
			}
			
			result.append(']');
		}
		
		return result.toString();
	}

	/**
	 * Callback for an AssociationClassCallExp visit. 
	 * @param ac the association class expression
	 * @return string source.ref
	 */
    @Override
    protected String handleAssociationClassCallExp(
            AssociationClassCallExp<C,P> ac,
            String sourceResult, List<String> qualifierResults) {

		C ref = ac.getReferredAssociationClass();
		String name = initialLower(getName(ref));
		
		StringBuffer result = new StringBuffer(
			maybeAtPre(ac, sourceResult + "." + name));//$NON-NLS-1$
		
		if (!qualifierResults.isEmpty()) {
			result.append('[').append(qualifierResults.get(0)).append(']');
		}
		
		return result.toString();
	}
	
	protected String initialLower(String name) {
		if (name == null || name.length() == 0) {
			return name;
		}
		
		StringBuffer result = new StringBuffer(name);
		result.setCharAt(0, Character.toLowerCase(result.charAt(0)));
		return result.toString();
	}

	/**
	 * Callback for the Variable visit.
	 * @param vd the variable declaration
	 * @return string
	 */
    @Override
    protected String handleVariable(Variable<C,PM> vd, String initResult) {
		String varName = vd.getName();
		
		if (varName == null) {
			varName = NULL_PLACEHOLDER;
		}
		
		C type = vd.getType();
		String result = varName;

		if (type != null) {
			result += " : " + getName(type);//$NON-NLS-1$
		}
        
        if (initResult != null) {
			result += " = " + initResult;//$NON-NLS-1$
        }
        
		return result;
	}

	/**
	 * Callback for an IfExp visit.
	 * @param ifExp an IfExp
     * @return the string representation
	 */
    @Override
    protected String handleIfExp(IfExp<C> ifExp, String conditionResult, String thenResult, String elseResult) {
        StringBuffer result = new StringBuffer();
        
        result.append("if ").append(conditionResult); //$NON-NLS-1$
        result.append(" then ").append(thenResult); //$NON-NLS-1$
        result.append(" else ").append(elseResult); //$NON-NLS-1$
        result.append(" endif"); //$NON-NLS-1$
        
        return result.toString();
	}

	@Override
    public String visitTypeExp(TypeExp<C> t) {
		return getQualifiedName(t.getReferredType());
	}
	
	@Override
    public String visitStateExp(StateExp<C, S> s) {
		return getName(s);
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 * @param uv - UnspecifiedValueExp
	 * @return the string representation
	 */
	@Override
    public String visitUnspecifiedValueExp(UnspecifiedValueExp<C> uv) {
		StringBuffer result = new StringBuffer();
		result.append("?"); //$NON-NLS-1$
		if (uv.getType() != null && !(uv.getType() instanceof VoidType)) {
			result.append(" : "); //$NON-NLS-1$
			result.append(getName(uv.getType()));
		}

		return result.toString();
	}

	/**
	 * Callback for an IntegerLiteralExp visit. 
	 * @param il -- integer literal expression 
	 * @return String
	 */
	@Override
    public String visitIntegerLiteralExp(IntegerLiteralExp<C> il) {
		return (il.getIntegerSymbol() == null)? NULL_PLACEHOLDER
				: il.getIntegerSymbol().toString();
	}
    
    /**
     * Callback for an UnlimitedNaturalLiteralExp visit. 
     * @param unl -- unlimited natural literal expression 
     * @return String
     */
    @Override
    public String visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> unl) {
        if (unl.isUnlimited()) {
            return "*"; //$NON-NLS-1$
        }
        
        return (unl.getIntegerSymbol() == null)? NULL_PLACEHOLDER
                : unl.getIntegerSymbol().toString();
    }
    

	/**
	 * Callback for a RealLiteralExp visit.
	 * @param rl -- real literal expression
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
    public String visitRealLiteralExp(RealLiteralExp<C> rl) {
		return (rl.getRealSymbol() == null)? NULL_PLACEHOLDER
				: rl.getRealSymbol().toString();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * @param sl -- string literal expression
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
    public String visitStringLiteralExp(StringLiteralExp<C> sl) {
		return "'" + ((sl.getStringSymbol() == null)? NULL_PLACEHOLDER //$NON-NLS-1$
				: sl.getStringSymbol()) + "'";//$NON-NLS-1$
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * @param bl -- boolean literal expression
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
    public String visitBooleanLiteralExp(BooleanLiteralExp<C> bl) {
		return (bl.getBooleanSymbol() == null)? NULL_PLACEHOLDER
				: bl.getBooleanSymbol().toString();
	}

	/**
	 * Callback for LetExp visit.
	 * @param letExp a let expression
     * @return the string representation
	 */
    @Override
    protected String handleLetExp(LetExp<C,PM> letExp, String variableResult,
            String inResult) {
        
        StringBuffer result = new StringBuffer();
		result.append("let ").append(variableResult); //$NON-NLS-1$
        result.append(" in ").append(inResult); //$NON-NLS-1$
        
		return result.toString();

	}

	/**
	 *  Callback for an IterateExp visit.
	 * @param callExp an iterate expression
     * @return the string representation
	 */
    @Override
    protected String handleIterateExp(IterateExp<C,PM> callExp,
            String sourceResult, List<String> variableResults,
            String resultResult, String bodyResult) {
        
        StringBuffer result = new StringBuffer();
        
        result.append(sourceResult).append("->iterate("); //$NON-NLS-1$
        
		for (Iterator<String> iter = variableResults.iterator(); iter.hasNext();) {
			result.append(iter.next());
			if (iter.hasNext()) {
				result.append(", ");//$NON-NLS-1$
            }
		}
        
		result.append("; ").append(resultResult).append(" | ");//$NON-NLS-2$//$NON-NLS-1$

		result.append(bodyResult).append(')');

		return result.toString();
	}

	/**
	 * Callback for an IteratorExp visit.
	 * @param callExp an iterator expression
     * @return the string representation
	 */
    @Override
    protected String handleIteratorExp(IteratorExp<C,PM> callExp,
            String sourceResult, List<String> variableResults, String bodyResult) {
        
        StringBuffer result = new StringBuffer();

        String name = callExp.getName();
        result.append(sourceResult).append("->").append(name).append('('); //$NON-NLS-1$
        
        for (Iterator<String> iter = variableResults.iterator(); iter.hasNext();) {
            result.append(iter.next());
            if (iter.hasNext()) {
                result.append(", ");//$NON-NLS-1$
            }
        }
        
        result.append(" | ").append(bodyResult).append(')');//$NON-NLS-1$

        return result.toString();
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 * @param cl collection literal expression
	 * @return String
	 */
    @Override
    protected String handleCollectionLiteralExp(CollectionLiteralExp<C> cl,
            List<String> partResults) {
        
        StringBuffer result = new StringBuffer();
        
		// construct the appropriate collection from the parts
		// based on the collection kind.
		CollectionKind kind = cl.getKind();

		switch (kind) {
		case SET_LITERAL:
			result.append("Set {");//$NON-NLS-1$
			break;
		case ORDERED_SET_LITERAL:
            result.append("OrderedSet {");//$NON-NLS-1$
			break;
		case BAG_LITERAL:
            result.append("Bag {");//$NON-NLS-1$
			break;
		case SEQUENCE_LITERAL:
            result.append("Sequence {");//$NON-NLS-1$
			break;
		default:
            result.append("Collection {");//$NON-NLS-1$
			break;
		}

		for (Iterator<String> iter = partResults.iterator(); iter.hasNext();) {
			result.append(iter.next());
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
            }
		}
        
		result.append('}');
        
        return result.toString();
	}
    
    @Override
    protected String handleCollectionItem(CollectionItem<C> item,
            String itemResult) {
        return itemResult;
    }
    
    @Override
    protected String handleCollectionRange(CollectionRange<C> range,
            String firstResult, String lastResult) {
        return firstResult + ".." + lastResult; //$NON-NLS-1$
    }

	/**
	 * Callback for a TupleLiteralExp visit.
	 * @param literalExp tuple literal expression
     * @return the string representation
	 */
    @Override
    protected String handleTupleLiteralExp(TupleLiteralExp<C,P> literalExp,
            List<String> partResults) {
        
		// construct the appropriate collection from the parts
		// based on the collection kind.
		StringBuffer result = new StringBuffer();
        result.append("Tuple{");//$NON-NLS-1$
        
		for (Iterator<String> iter = partResults.iterator(); iter.hasNext();) {
			result.append(iter.next());
            
			if (iter.hasNext()) {
				result.append(", ");//$NON-NLS-1$
            }
		}
        
		result.append('}');
        
        return result.toString();
	}
	
    @Override
    protected String handleTupleLiteralPart(TupleLiteralPart<C, P> part,
            String valueResult) {
        
		String varName = part.getName();
		C type = part.getType();
        
		StringBuffer result = new StringBuffer();
        
        result.append(varName);

		if (type != null) {
			result.append(" : ").append(getName(type));//$NON-NLS-1$
		}
		
		if (valueResult != null) {
			result.append(" = ").append(valueResult);//$NON-NLS-1$
		}
		
		return result.toString();
	}
	
    @Override
    protected String handleMessageExp(MessageExp<C, COA, SSA> messageExp,
            String targetResult, List<String> argumentResults) {
		StringBuffer result = new StringBuffer();
		
		result.append(targetResult);
		
		result.append((messageExp.getType() instanceof CollectionType)?
            "^^" : "^");  //$NON-NLS-1$//$NON-NLS-2$
	
		if (messageExp.getCalledOperation() != null) {
			result.append(getName(getOperation(messageExp.getCalledOperation())));
		} else if (messageExp.getSentSignal() != null) {
			result.append(getName(getSignal(messageExp.getSentSignal())));
		}
		
		result.append('(');
		
		for (Iterator<String> iter = argumentResults.iterator(); iter.hasNext();) {
			result.append(iter.next());
			
			if (iter.hasNext()) {
				result.append(", ");  //$NON-NLS-1$
			}
		}
		
		result.append(')');
		
		return result.toString();
	}
	
	protected O getOperation(COA callOperationAction) {
		return (uml == null)? null : uml.getOperation(callOperationAction);
	}
	
	protected C getSignal(SSA sendSignalAction) {
		return (uml == null)? null : uml.getSignal(sendSignalAction);
	}

	/**
     * Renders an ExpressionInOcl with its context variables and body.
	 */
	@Override
    public String visitExpressionInOCL(ExpressionInOCL<C, PM> expression) {
		return expression.getBodyExpression().accept(this);
	}

    /**
     * Renders a constraint with its context and expression.
     */
    @Override
    public String visitConstraint(CT constraint) {
        StringBuffer result = new StringBuffer();
        
        List<EObject> constrained = getConstrainedElements(constraint);
        
        if (!constrained.isEmpty()) {
            EObject elem = constrained.get(0);
            
            result.append("context "); //$NON-NLS-1$
            if (isClassifier(elem)) {
                result.append(getName(elem));
            } else if (isOperation(elem)) {
                @SuppressWarnings("unchecked")
                O oper = (O) elem;
                appendOperationSignature(result, oper);
            } else if (isProperty(elem)) {
                @SuppressWarnings("unchecked")
                P prop = (P) elem;
                appendPropertySignature(result, prop);
            }
            
            result.append(' ');
        }
        
        String stereo = getStereotype(constraint);
        if (UMLReflection.PRECONDITION.equals(stereo)) {
            result.append("pre: "); //$NON-NLS-1$
        } else if (UMLReflection.POSTCONDITION.equals(stereo)) {
            result.append("post: "); //$NON-NLS-1$
        } else if (UMLReflection.BODY.equals(stereo)) {
            result.append("body: "); //$NON-NLS-1$
        } else if (UMLReflection.INITIAL.equals(stereo)) {
            result.append("init: "); //$NON-NLS-1$
        } else if (UMLReflection.DERIVATION.equals(stereo)) {
            result.append("derive: "); //$NON-NLS-1$
        } else if (UMLReflection.POSTCONDITION.equals(stereo)) {
            result.append("def: "); //$NON-NLS-1$
            
            EObject elem = constrained.get(1);
            
            if (isOperation(elem)) {
                @SuppressWarnings("unchecked")
                O oper = (O) elem;
                appendOperationSignature(result, oper);
            } else if (isProperty(elem)) {
                @SuppressWarnings("unchecked")
                P prop = (P) elem;
                appendPropertySignature(result, prop);
            }
            
            result.append(" = "); //$NON-NLS-1$
        } else {
            result.append("inv: "); //$NON-NLS-1$
        }
        
        result.append(visit(getSpecification(constraint)));
        
        return result.toString();
    }
	
	protected boolean isClassifier(Object element) {
		return (uml == null)? null : uml.isClassifier(element);
	}
	
	protected boolean isOperation(Object element) {
		return (uml == null)? null : uml.isOperation(element);
	}
	
	protected boolean isProperty(Object element) {
		return (uml == null)? null : uml.isProperty(element);
	}
	
	protected List<EObject> getConstrainedElements(CT constraint) {
		return (uml == null)? null : uml.getConstrainedElements(constraint);
	}
	
	protected String getStereotype(CT constraint) {
		return (uml == null)? null : uml.getStereotype(constraint);
	}
	
	@Override
    protected ExpressionInOCL<C, PM> getSpecification(CT constraint) {
		return (uml == null)? null : uml.getSpecification(constraint);
	}
	
	private void appendOperationSignature(StringBuffer buf, O operation) {
		buf.append(getName(operation)).append('(');
		
		boolean comma = false;
		for (Iterator<PM> iter = getParameters(operation).iterator(); iter.hasNext();) {
			PM parm = iter.next();
			
			if (comma) {
				buf.append(", "); //$NON-NLS-1$
			} else {
				comma = true;
			}
			
			buf.append(getName(parm)).append(" : "); //$NON-NLS-1$
			
			if (getType(parm) != null) {
				buf.append(getName(getType(parm)));
			} else {
				buf.append("OclVoid"); //$NON-NLS-1$
			}
		}
		
		buf.append(") :"); //$NON-NLS-1$
		if (getType(operation) != null) {
			buf.append(' ').append(getName(getType(operation)));
		}
	}
	
	protected C getType(Object typedElement) {
		return (uml == null)? null : TypeUtil.resolveType(env, uml.getOCLType(typedElement));
	}
	
	protected List<PM> getParameters(O operation) {
		return (uml == null)? null : uml.getParameters(operation);
	}

	private void appendPropertySignature(StringBuffer buf, P property) {
		buf.append(getName(property));
		if (getType(property) != null) {
			buf.append(" : ").append(getName(getType(property))); //$NON-NLS-1$
		}
	}

	private String maybeAtPre(FeatureCallExp<C> mpc, String base) {
		return mpc.isMarkedPre() ? base + "@pre" : base; //$NON-NLS-1$
	}

	@Override
    public String visitInvalidLiteralExp(InvalidLiteralExp<C> il) {
		return "OclInvalid"; //$NON-NLS-1$
	}

	@Override
    public String visitNullLiteralExp(NullLiteralExp<C> il) {
		return "null"; //$NON-NLS-1$
	}
	
	private String visit(Visitable visitable) {
		return (visitable == null)? NULL_PLACEHOLDER : (String) visitable.accept(this);
	}
} // ToStringVisitorImpl
