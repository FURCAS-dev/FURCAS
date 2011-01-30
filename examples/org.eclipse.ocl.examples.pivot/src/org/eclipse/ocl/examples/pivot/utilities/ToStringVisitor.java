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
 * $Id: ToStringVisitor.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.utilities;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
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
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Precedence;
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
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * Converts an OCL expression to a string for debugging.  This is not intended
 * to be used by client applications as an AST-to-text transformation.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 * @author Edward Willink (ewillink)
 */
public class ToStringVisitor extends AbstractVisitor2<String>
{
	/**
	 * Indicates where a required element in the AST was <code>null</code>, so
	 * that it is evident in the debugger that something was missing.  We don't
	 * want just <code>"null"</code> because that would look like the OclVoid
	 * literal.
	 */
	protected static String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	protected StringBuffer result = new StringBuffer();

	/**
	 * Initializes me.
	 */
	public ToStringVisitor() {
		super(null);
	}
	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * environment.
	 * 
	 * @param env an OCL environment
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
	 * @param element an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	@Deprecated
	public static 
	ToStringVisitor getInstance(TypedElement element) {	
		return new ToStringVisitor();
	}
	
	/**
	 * Null-safe access to the name of a named element.
	 * 
	 * @param named a named element or <code>null</code>
	 * @return a name, or the null placeholder if the named element or its name
	 *    be <code>null</code>.  i.e., <code>null</code> is never returned
	 */
	protected String getName(NamedElement named) {
		return (named == null)? NULL_PLACEHOLDER : named.getName();
	}
	
	/**
	 * Null-safe access to the name of a named element.
	 * 
	 * @param named a named element or <code>null</code>
	 * @return a name, or the null placeholder if the named element or its name
	 *    be <code>null</code>.  i.e., <code>null</code> is never returned
	 */
	protected String getName(EObject eContainer, String separator, NamedElement named) {
		if (eContainer instanceof NamedElement) {
			return getName(eContainer.eContainer(), "::", (NamedElement) eContainer) + separator + getName(named);
		}
		else {
			return getName(named);
		}
	}
    
    /**
     * Null-safe access to the qualified name of a named element.
     * 
     * @param named a named element or <code>null</code>
     * @return a qualified name, or the null placeholder if the named element
     *    or its name be <code>null</code>.  i.e., <code>null</code> is never
     *    returned
     */
    protected String getQualifiedName(NamedElement named) {
        StringBuffer result = new StringBuffer();       
        getQualifiedName(result, named);        
        return result.toString();
     }
    
    /**
     * Helper for the {@link #getQualifiedName(Object)}.
     */
    private void getQualifiedName(StringBuffer buf, NamedElement namedElement) {
        EObject container = namedElement.eContainer();
        if (container instanceof NamedElement) {
            getQualifiedName(buf, (NamedElement) container);         
            buf.append("::"); //$NON-NLS-1$
        }       
        buf.append(namedElement.getName());
        if (namedElement instanceof TemplateableElement) {
        	TemplateableElement templateableElement = (TemplateableElement)namedElement;
			appendTemplateBindings(buf, templateableElement.getTemplateBindings());
    		TemplateSignature templateSignature = templateableElement.getOwnedTemplateSignature();
    		if (templateSignature != null) {
            	appendTemplateSignature(buf, templateSignature);
    		}
        }
    }

	/**
	 * Callback for an OperationCallExp visit.
	 * 
	 * Look at the source to determine operator ( -> or . )
	 * @param oc the operation call expression
	 * @return string
	 */
    @Override
    protected String handleOperationCallExp(OperationCallExp oc,
            String sourceResult, List<String> argumentResults) {
        
//		OclExpression source = oc.getSource();
//		Type sourceType = source != null ? source.getType() : null;
		Operation oper = oc.getReferredOperation();
		
		result.append(sourceResult);
		if (oper != null) {
			result.append(oper.getFeaturingClass() instanceof CollectionType ? PivotConstants.COLLECTION_NAVIGATION_OPERATOR : PivotConstants.OBJECT_NAVIGATION_OPERATOR);
			result.append(getName(oper));
		}
		else {
			result.append(PivotConstants.OBJECT_NAVIGATION_OPERATOR);
			result.append(getName(oc));
		}
        result.append('(');
        for (Iterator<String> iter = argumentResults.iterator(); iter.hasNext();) {
			result.append(iter.next());
			if (iter.hasNext()) {
				result.append(", ");//$NON-NLS-1$
            }
		}
		result.append(')');
        maybeAtPre(oc);
        return null;
	}

	/**
	 * Callback for an EnumLiteralExp visit.  
	 * @param el the enumeration literal expresion
	 * @return the enumeration literal toString()
	 */
	@Override
    public String visitEnumLiteralExp(EnumLiteralExp el) {
		EnumerationLiteral l = el.getReferredEnumLiteral();
		return getQualifiedName(l);
	}

	/**
	 * Callback for a VariableExp visit.
	 * @param v the variable expression
	 * @return the variable name
	 */
	@Override
    public String visitVariableExp(VariableExp v) {
		VariableDeclaration vd = v.getReferredVariable();
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
    protected String handlePropertyCallExp(PropertyCallExp pc,
            String sourceResult, List<String> qualifierResults) {
		Property property = pc.getReferredProperty();

        if (sourceResult == null) {
			// if we are the qualifier of an association class call, then
			//   we just return our name, because our source is null (implied)
			return getName(property);
		}
		
		result.append(sourceResult);	//$NON-NLS-1$
		result.append(property.getFeaturingClass() instanceof CollectionType ? PivotConstants.COLLECTION_NAVIGATION_OPERATOR : PivotConstants.OBJECT_NAVIGATION_OPERATOR);
		result.append(getName(property));	//$NON-NLS-1$
		maybeAtPre(pc);
		
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
		return null;
	}

	/**
	 * Callback for an AssociationClassCallExp visit. 
	 * @param ac the association class expression
	 * @return string source.ref
	 */
    @Override
    protected String handleAssociationClassCallExp(
            AssociationClassCallExp ac,
            String sourceResult, List<String> qualifierResults) {

		Type ref = ac.getReferredAssociationClass();
		String name = initialLower(getName(ref));
		
		result.append(sourceResult + "." + name);	//$NON-NLS-1$
		maybeAtPre(ac);
		
		if (!qualifierResults.isEmpty()) {
			result.append('[').append(qualifierResults.get(0)).append(']');
		}
		return null;
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
    protected String handleVariable(Variable vd, String initResult) {
		String varName = vd.getName();
		
		if (varName == null) {
			varName = NULL_PLACEHOLDER;
		}
		
		Type type = vd.getType();
		String result = varName;

		if (type != null) {
			result += " : " + getName(type);//$NON-NLS-1$
		}
        
        if (vd.getInitExpression() != null) {
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
    protected String handleIfExp(IfExp ifExp, String conditionResult, String thenResult, String elseResult) {
        StringBuffer result = new StringBuffer();
        
        result.append("if ").append(conditionResult); //$NON-NLS-1$
        result.append(" then ").append(thenResult); //$NON-NLS-1$
        result.append(" else ").append(elseResult); //$NON-NLS-1$
        result.append(" endif"); //$NON-NLS-1$
        
        return result.toString();
	}

	@Override
	public String visitTupleType(TupleType object) {
		super.visitTupleType(object);
		result.append("{");
		String prefix = "";
		for (TypedElement part : object.getOwnedAttributes()) {
			result.append(prefix);
			result.append(getName(part));
			prefix = ",";
		}
		result.append("}");
		return result.toString();
	}

	@Override
    public String visitTypeExp(TypeExp t) {
		return getQualifiedName(t.getReferredType());
	}
	
	@Override
    public String visitStateExp(StateExp s) {
		return getName(s);
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 * @param uv - UnspecifiedValueExp
	 * @return the string representation
	 */
	@Override
    public String visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
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
    public String visitIntegerLiteralExp(IntegerLiteralExp il) {
    	BigInteger value = il.getIntegerSymbol();
    	if (value == null) {
    		return NULL_PLACEHOLDER;
    	}
        return value.toString();
	}
    
    /**
     * Callback for an UnlimitedNaturalLiteralExp visit. 
     * @param unl -- unlimited natural literal expression 
     * @return String
     */
    @Override
    public String visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp unl) {
    	BigInteger value = unl.getUnlimitedNaturalSymbol();
    	if (value == null) {
    		return NULL_PLACEHOLDER;
    	}
    	if (value.signum() < 0) {
            return "*"; //$NON-NLS-1$
        }
        return value.toString();
    }
    

	/**
	 * Callback for a RealLiteralExp visit.
	 * @param rl -- real literal expression
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
    public String visitRealLiteralExp(RealLiteralExp rl) {
		return (rl.getRealSymbol() == null)? NULL_PLACEHOLDER
				: rl.getRealSymbol().toString();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * @param sl -- string literal expression
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
    public String visitStringLiteralExp(StringLiteralExp sl) {
		return "'" + ((sl.getStringSymbol() == null)? NULL_PLACEHOLDER //$NON-NLS-1$
				: sl.getStringSymbol()) + "'";//$NON-NLS-1$
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * @param bl -- boolean literal expression
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
    public String visitBooleanLiteralExp(BooleanLiteralExp bl) {
    	boolean value = bl.isBooleanSymbol();
		return Boolean.toString(value);
	}

	/**
	 * Callback for LetExp visit.
	 * @param letExp a let expression
     * @return the string representation
	 */
    @Override
    protected String handleLetExp(LetExp letExp, String variableResult,
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
    protected String handleIterateExp(IterateExp callExp,
            String sourceResult, List<String> variableResults,
            String resultResult, String bodyResult) {
        
        StringBuffer result = new StringBuffer();
        
        String name = callExp.getReferredIteration().getName();
        result.append(sourceResult).append("->").append(name).append("("); //$NON-NLS-1$
        
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
    protected String handleIteratorExp(IteratorExp callExp,
            String sourceResult, List<String> variableResults, String bodyResult) {
        
        StringBuffer result = new StringBuffer();

        String name = callExp.getReferredIteration().getName();
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
    protected String handleCollectionLiteralExp(CollectionLiteralExp cl,
            List<String> partResults) {
        
        StringBuffer result = new StringBuffer();
        
		// construct the appropriate collection from the parts
		// based on the collection kind.
		CollectionKind kind = cl.getKind();

		switch (kind) {
		case SET:
			result.append("Set {");//$NON-NLS-1$
			break;
		case ORDERED_SET:
            result.append("OrderedSet {");//$NON-NLS-1$
			break;
		case BAG:
            result.append("Bag {");//$NON-NLS-1$
			break;
		case SEQUENCE:
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
    protected String handleCollectionItem(CollectionItem item,
            String itemResult) {
        return itemResult;
    }
    
    @Override
    protected String handleCollectionRange(CollectionRange range,
            String firstResult, String lastResult) {
        return firstResult + ".." + lastResult; //$NON-NLS-1$
    }

	/**
	 * Callback for a TupleLiteralExp visit.
	 * @param literalExp tuple literal expression
     * @return the string representation
	 */
    @Override
    protected String handleTupleLiteralExp(TupleLiteralExp literalExp,
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
    protected String handleTupleLiteralPart(TupleLiteralPart part,
            String valueResult) {
        
		String varName = part.getName();
		Type type = part.getType();
        
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
    protected String handleMessageExp(MessageExp messageExp,
            String targetResult, List<String> argumentResults) {
		StringBuffer result = new StringBuffer();
		
		result.append(targetResult);
		
		result.append((messageExp.getType() instanceof CollectionType)?
            "^^" : "^");  //$NON-NLS-1$//$NON-NLS-2$
	
		if (messageExp.getCalledOperation() != null) {
			result.append(getName(messageExp.getCalledOperation().getOperation()));
		} else if (messageExp.getSentSignal() != null) {
			result.append(getName(messageExp.getSentSignal().getSignal()));
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

	/**
     * Renders an ExpressionInOcl with its context variables and body.
	 */
	@Override
    public String visitExpressionInOcl(ExpressionInOcl expression) {
		return safeVisit(expression.getBodyExpression());
	}

    /**
     * Renders a constraint with its context and expression.
     */
    @Override
    public String visitConstraint(Constraint constraint) {
        StringBuffer result = new StringBuffer();
        List<? extends EObject> constrained = constraint.getConstrainedElements();
        
        if (!constrained.isEmpty()) {
            EObject elem = constrained.get(0);
            
            result.append("context "); //$NON-NLS-1$
            if (elem instanceof Type) {
                result.append(getName((NamedElement) elem));
            } else if (elem instanceof Operation) {
                Operation oper = (Operation) elem;
                appendOperationSignature(result, oper);
            } else if (elem instanceof Property) {
                Property prop = (Property) elem;
                appendPropertySignature(result, prop);
            }
            
            result.append(' ');
        }
        
        String stereo = constraint.getStereotype();
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
            
            if (elem instanceof Operation) {
                Operation oper = (Operation) elem;
                appendOperationSignature(result, oper);
            } else if (elem instanceof Property) {
                Property prop = (Property) elem;
                appendPropertySignature(result, prop);
            }
            
            result.append(" = "); //$NON-NLS-1$
        } else {
            result.append("inv "); //$NON-NLS-1$
            String name = getName(constraint);
			if (name != null) {
				result.append(name);
			}
            result.append(": "); //$NON-NLS-1$
        }
        
        result.append(safeVisit(constraint.getSpecification()));
        
        return result.toString();
    }

/*	protected List<? extends EObject> getConstrainedElements(Constraint constraint) {
		if (uml == null) {
			return Collections.emptyList();
		}
		else {
			return uml.getConstrainedElements(constraint);
		}
	}
	
	protected String getStereotype(Constraint constraint) {
		return (uml == null)? null : uml.getStereotype(constraint);
	}
	
	@Override
    protected ExpressionInOcl getSpecification(Constraint constraint) {
		return (uml == null)? null : uml.getSpecification(constraint);
	} */
	
	private void appendOperationSignature(StringBuffer buf, Operation operation) {
		buf.append(getName(operation)).append('(');
		
		boolean comma = false;
		for (java.util.Iterator<Parameter> iter = operation.getOwnedParameters().iterator(); iter.hasNext();) {
			Parameter parm = iter.next();
			
			if (comma) {
				buf.append(", "); //$NON-NLS-1$
			} else {
				comma = true;
			}
			
			buf.append(getName(parm)).append(" : "); //$NON-NLS-1$
			
			if (parm.getType() != null) {
				buf.append(getName(parm.getType()));
			} else {
				buf.append("OclVoid"); //$NON-NLS-1$
			}
		}
		
		buf.append(") :"); //$NON-NLS-1$
		if (operation.getType() != null) {
			buf.append(' ').append(getName(operation.getType()));
		}
	}
	
/*	protected Type getType(Object typedElement) {
		return (uml == null)? null : TypeUtil.resolveType(env, uml.getOCLType(typedElement));
	}
	
	protected List<Parameter> getParameters(Operation operation) {
		return (uml == null)? null : uml.getParameters(operation);
	} */

	private void appendPropertySignature(StringBuffer buf, Property property) {
		buf.append(getName(property));
		if (property.getType() != null) {
			buf.append(" : ").append(getName(property.getType())); //$NON-NLS-1$
		}
	}

	private void appendTemplateBindings(StringBuffer buf, List<TemplateBinding> templateBindings) {
		if (templateBindings.size() > 0) {
			buf.append("(");
			String prefix = ""; //$NON-NLS-1$
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
					buf.append(prefix);
					buf.append(getName((NamedElement) templateParameterSubstitution.getActual()));
					prefix = ",";
				}
			}
			buf.append(")");
		}
	}

	private void appendTemplateSignature(StringBuffer buf, TemplateSignature templateSignature) {
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		if (!templateParameters.isEmpty()) {
			buf.append("<");
			String prefix = ""; //$NON-NLS-1$
			for (TemplateParameter templateParameter : templateParameters) {
				buf.append(prefix);
				buf.append(getName((NamedElement) templateParameter.getParameteredElement()));
				prefix = ",";
			}
			buf.append(">");
		}
	}

	private void maybeAtPre(FeatureCallExp mpc) {
		if (mpc.isPre()) {
			result.append("@pre"); //$NON-NLS-1$
		}
	}

	@Override
	public String safeVisit(Visitable v) {
		StringBuffer savedResult = result;
		result = new StringBuffer();
		String nestedResult = super.safeVisit(v);
		if (nestedResult == null) {				// FIXME Eliminate tjis hybrid protocol
			nestedResult = result.toString();
		}
		result = savedResult;
		return nestedResult;
	}

	@Override
	public String visitClass(org.eclipse.ocl.examples.pivot.Class cls) {		
		EObject eContainer = cls.eContainer();
		if (cls.getOwningTemplateParameter() != null) {
			result.append(getName(eContainer, "::", cls));
		}
		else {
			result.append(getName(eContainer, "::", cls));
			List<TemplateBinding> templateBindings = cls.getTemplateBindings();
			if (templateBindings.size() > 0) {
				appendTemplateBindings(result, templateBindings);
			}
    		TemplateSignature templateSignature = cls.getOwnedTemplateSignature();
    		if (templateSignature != null) {
            	appendTemplateSignature(result, templateSignature);
    		}
		}
		return null;
	}

	@Override
	public String visitEnumerationLiteral(EnumerationLiteral el) {
		result.append(getName(el.eContainer(), "::", el));
		return null;
	}

	@Override
    public String visitInvalidLiteralExp(InvalidLiteralExp il) {
		return "invalid"; //$NON-NLS-1$
	}

	@Override
    public String visitNullLiteralExp(NullLiteralExp il) {
		return "null"; //$NON-NLS-1$
	}

	@Override
	public String visitOpaqueExpression(OpaqueExpression object) {
		String body = PivotUtil.getBody(object);
		return body != null ? body : "";
	}

	@Override
	public String visitOperation(Operation operation) {
		result.append(getName(operation.eContainer(), ".", operation));
		List<TemplateBinding> templateBindings = operation.getTemplateBindings();
		if (templateBindings.size() > 0) {
			appendTemplateBindings(result, templateBindings);
		}
		TemplateSignature templateSignature = operation.getOwnedTemplateSignature();
		if (templateSignature != null) {
        	appendTemplateSignature(result, templateSignature);
		}
		result.append('(');
		boolean isFirst = true;
		for (Parameter parameter : operation.getOwnedParameters()) {
			if (!isFirst) {
				result.append(',');
			}
			Type type = parameter.getType();
			result.append(getName(type));
			isFirst = false;
		}
		result.append(')');
		return null;
	}

	@Override
	public String visitPackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		return getName(pkg.eContainer(), "::", pkg);
	}

	@Override
	public String visitParameter(Parameter parameter) {
		return getName(parameter.eContainer(), ".", parameter);
	}

	@Override
	public String visitPrecedence(Precedence precedence) {
		return precedence.getName();
	}

	@Override
	public String visitProperty(Property property) {
		return getName(property.eContainer(), ".", property);
	}
	
	@Override
	public String visitTemplateBinding(TemplateBinding object) {
//		s.append(getQualifiedName(object.getFormal(), "/", (NamedElement) object.getActual()));
		appendTemplateBindings(result, Collections.singletonList(object));
		return null;
	}

	@Override
	public String visitTemplateParameter(TemplateParameter object) {
		return getName(object.getSignature().getTemplate(), ".", (NamedElement) object.getParameteredElement());
	}

	@Override
	public String visitTemplateParameterSubstitution(TemplateParameterSubstitution object) {
		result.append(getName((NamedElement) object.getFormal().getParameteredElement()));
		result.append("/");
		result.append((NamedElement) object.getActual());
		return null;
	}

	@Override
	public String visitTemplateSignature(TemplateSignature object) {
//		s.append(getQualifiedName(object.getFormal(), "/", (NamedElement) object.getActual()));
		appendTemplateSignature(result, object);
		return null;
	}

	public String visiting(Visitable visitable) {
		return (visitable == null)? NULL_PLACEHOLDER : visitable.getClass().getName();
	}

	@Override
	public String toString() {
		return result.toString();
	}
} // ToStringVisitorImpl
