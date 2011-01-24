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
 *   E.D. Willink - Fix NPE in visiting operation call with null source
 *
 * </copyright>
 *
 * $Id: AbstractVisitor2.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.utilities;

import java.util.Collections;
import java.util.List;

import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;

/**
 * <p>
 * An abstract implementation of the {@link Visitor} API, in which subclasses
 * need only selectively override <code>handleXxx(...)</code> methods for
 * internal AST nodes and <code>visitXxx(...)</code> methods for leaf nodes.
 * </p><p>
 * The {@link #result} value is convenient for accumulating the result of the
 * visitation.  In the subclass, simply assign/modify the result value as
 * necessary in the overridden visitation methods, and this framework will
 * ensure that it is returned as the overall value of the
 * {@link Visitable#accept(Visitor)} call.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractVisitor2<T> extends AbstractExtendingVisitor<T, T> {
    
	private T result;
    /**
     * Initializes me.
     */
//	protected AbstractVisitor2() {
//		super();
//	}
	
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param initialValue my initial result value
	 */
	protected AbstractVisitor2(T initialValue) {
	    super(initialValue);
		result = initialValue;
	}

    /**
     * Visits the operation-call source and then its arguments.
     * Returns the result of {@link #handleOperationCallExp(OperationCallExp, Object, List)}.
     */
	@Override
	public T visitOperationCallExp(OperationCallExp callExp) {
        OclExpression source = callExp.getSource();
		T sourceResult = safeVisit(source);
        
        List<T> argumentResults;
        List<OclExpression> arguments = callExp.getArguments();
        
        if (arguments.isEmpty()) {
            argumentResults = Collections.emptyList();
        } else {
            argumentResults = new java.util.ArrayList<T>(arguments.size());
            for (OclExpression qual : arguments) {
                argumentResults.add(safeVisit(qual));
            }
        }
        
        return handleOperationCallExp(callExp, sourceResult, argumentResults);
	}
    
    /**
     * Visits the specified operation call with the results of visiting
     * its source and arguments (if any).
     * 
     * @param callExp the operation call expression
     * @param sourceResult the result of visiting the expression's source
     * @param argumentResults the results of visiting the expression's
     *     arguments, or an empty list if there are no arguments
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitOperationCallExp(OperationCallExp)
     */
    protected T handleOperationCallExp(OperationCallExp callExp,
            T sourceResult, List<T> argumentResults) {
        return result;
    }

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitVariableExp(VariableExp v) {
		return result;
	}

    /**
     * Visits the property-call source and then its qualifiers (if any).
     * Returns the result of {@link #handlePropertyCallExp(PropertyCallExp, Object, List)}.
     */
	@Override
	public T visitPropertyCallExp(PropertyCallExp callExp) {
        // source is null when the property call expression is an
        //    association class navigation qualifier
        T sourceResult = safeVisit(callExp.getSource());
        
        List<T> qualifierResults;
        List<OclExpression> qualifiers = callExp.getQualifiers();
        
        if (qualifiers.isEmpty()) {
            qualifierResults = Collections.emptyList();
        } else {
            qualifierResults = new java.util.ArrayList<T>(qualifiers.size());
            for (OclExpression qual : qualifiers) {
                qualifierResults.add(safeVisit(qual));
            }
        }
        
        return handlePropertyCallExp(callExp, sourceResult, qualifierResults);
	}
    
    /**
     * Visits the specified property call with the results of visiting
     * its source and qualifiers (if any).  Note that in the case of a property
     * call expression as a qualifier of an association class call, the
     * property call does not have a source and, therefore, the
     * <code>sourceResult</tt> will be <code>null</code> in that case.
     * 
     * @param callExp the property call expression, if there is a source
     * @param sourceResult the result of visiting the expression's source
     * @param qualifierResults the results of visiting the expression's
     *     qualifiers, or an empty list if there are no qualifiers
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitPropertyCallExp(PropertyCallExp)
     */
    protected T handlePropertyCallExp(PropertyCallExp callExp,
            T sourceResult, List<T> qualifierResults) {
        return result;
    }

    /**
     * Visits the association-class-call source and then its qualifiers (if any).
     * Returns the result of {@link #handleAssociationClassCallExp(AssociationClassCallExp, Object, List)}.
     */
	@Override
	public T visitAssociationClassCallExp(AssociationClassCallExp callExp) {
		T sourceResult = safeVisit(callExp.getSource());
		
        List<T> qualifierResults;
        List<OclExpression> qualifiers = callExp.getQualifiers();
        
        if (qualifiers.isEmpty()) {
            qualifierResults = Collections.emptyList();
        } else {
            qualifierResults = new java.util.ArrayList<T>(qualifiers.size());
    		for (OclExpression qual : qualifiers) {
    			qualifierResults.add(safeVisit(qual));
    		}
        }
        
		return handleAssociationClassCallExp(callExp, sourceResult, qualifierResults);
	}
    
    /**
     * Visits the specified association-class call with the results of visiting
     * its source and qualifiers (if any).
     * 
     * @param callExp the association-class call expression
     * @param sourceResult the result of visiting the expression's source
     * @param qualifierResults the results of visiting the expression's
     *     qualifiers, or an empty list if there are no qualifiers
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitAssociationClassCallExp(AssociationClassCallExp)
     */
    protected T handleAssociationClassCallExp(AssociationClassCallExp callExp,
            T sourceResult, List<T> qualifierResults) {
        return result;
    }

    /**
     * Visits the variable's initialization expression (if any).
     * Returns the result of {@link #handleVariable(Variable, Object)}.
     */
	@Override
	public T visitVariable(Variable variable) {
        T initResult = safeVisit(variable.getInitExpression());
		
		return handleVariable(variable, initResult);
	}
    
    /**
     * Visits the specified variable with the results of visiting
     * its initializer (if any).
     * 
     * @param variable the variable
     * @param initResult the result of visiting the expression's initializer,
     *    or <code>null</code> if it has none
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitVariable(Variable)
     */
    protected T handleVariable(Variable variable,
            T initResult) {
        return result;
    }

    /**
     * Visits the if expression's condition, then, and else expressions.
     * Returns the result of {@link #handleIfExp(IfExp, Object, Object, Object)}.
     */
	@Override
	public T visitIfExp(IfExp ifExp) {
		return handleIfExp(ifExp,
				safeVisit(ifExp.getCondition()),
				safeVisit(ifExp.getThenExpression()),
				safeVisit(ifExp.getElseExpression()));
	}
    
    /**
     * Visits the specified if expression with the results of visiting
     * its condition, then, and else expressions.
     * 
     * @param ifExp the if expression
     * @param conditionResult the result of visiting the expression's condition
     * @param thenResult the result of visiting the expression's then
     * @param elseResult the result of visiting the expression's else
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitIfExp(IfExp)
     */
    protected T handleIfExp(IfExp ifExp, T conditionResult, T thenResult,
            T elseResult) {
        return result;
    }

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitTypeExp(TypeExp t) {
		return result;
	}
	
    /**
     * Visits the message expression's target and then its arguments.
     * Returns the result of {@link #handleMessageExp(MessageExp, Object, List)}.
     */
	@Override
	public T visitMessageExp(MessageExp messageExp) {
        T targetResult = safeVisit(messageExp.getTarget());
        
        List<T> argumentResults;
        List<OclExpression> arguments = messageExp.getArguments();
        
        if (arguments.isEmpty()) {
            argumentResults = Collections.emptyList();
        } else {
            argumentResults = new java.util.ArrayList<T>(arguments.size());
            for (OclExpression qual : arguments) {
                argumentResults.add(safeVisit(qual));
            }
        }
        
        return handleMessageExp(messageExp, targetResult, argumentResults);
	}
    
    /**
     * Visits the specified message expression with the results of visiting
     * its target and arguments (if any).
     * 
     * @param messageExp the message expression
     * @param targetResult the result of visiting the expression's target
     * @param argumentResults the results of visiting the expression's
     *     arguments, or an empty list if there are no arguments
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitMessageExp(MessageExp)
     */
    protected T handleMessageExp(MessageExp messageExp,
            T targetResult, List<T> argumentResults) {
        return result;
    }
	
    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitUnspecifiedValueExp(UnspecifiedValueExp unspecExp) {
		return result;
	}

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitStateExp(StateExp stateExp) {
		return result;
	}
	
    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitIntegerLiteralExp(IntegerLiteralExp literalExp) {
		return result;
	}
    
    /**
     * Simply returns {@link #result}.
     */
    @Override
	public T visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp literalExp) {
        return result;
    }

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitRealLiteralExp(RealLiteralExp literalExp) {
		return result;
	}

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitStringLiteralExp(StringLiteralExp literalExp) {
		return result;
	}

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitBooleanLiteralExp(BooleanLiteralExp literalExp) {
		return result;
	}
	
    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitNullLiteralExp(NullLiteralExp literalExp) {
		return result;
	}
	
    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitInvalidLiteralExp(InvalidLiteralExp literalExp) {
		return result;
	}

    /**
     * Visits the tuple literal's parts.
     * Returns the result of {@link #handleTupleLiteralExp(TupleLiteralExp, List)}.
     */
	@Override
	public T visitTupleLiteralExp(TupleLiteralExp literalExp) {
        List<T> partResults;
        List<TupleLiteralPart> parts = literalExp.getParts();
        
        if (parts.isEmpty()) {
            partResults = Collections.emptyList();
        } else {
            partResults = new java.util.ArrayList<T>(parts.size());
            for (TupleLiteralPart part : parts) {
                partResults.add(safeVisit(part));
            }
        }
		
		return handleTupleLiteralExp(literalExp, partResults);
	}
    
    /**
     * Visits the specified tuple literal expression with the results of visiting
     * its parts (if any).
     * 
     * @param literalExp the tuple literal expression
     * @param partResults the results of visiting the expression's
     *     parts, or an empty list if there are no parts
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitTupleLiteralExp(TupleLiteralExp)
     */
    protected T handleTupleLiteralExp(TupleLiteralExp literalExp,
            List<T> partResults) {
        return result;
    }
	
    /**
     * Visits the tuple literal part's value, if any.
     * Returns the result of {@link #handleTupleLiteralPart(TupleLiteralPart, Object)}.
     */
	@Override
	public T visitTupleLiteralPart(TupleLiteralPart part) {
        T valueResult = safeVisit(part.getInitExpression());
		
		return handleTupleLiteralPart(part, valueResult);
	}
    
    /**
     * Visits the specified tuple literal part with the results of visiting
     * its value (if any).
     * 
     * @param part the tuple literal part
     * @param valueResult the result of visiting the expression's value, or
     *     <code>null</code> if it has no value
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitTupleLiteralPart(TupleLiteralPart)
     */
    protected T handleTupleLiteralPart(TupleLiteralPart part,
            T valueResult) {
        return result;
    }

    /**
     * Visits the let's variable declaration then its 'in' expression.
     * Returns the result of {@link #handleLetExp(LetExp, Object, Object)}.
     */
	@Override
	public T visitLetExp(LetExp letExp) {
		return handleLetExp(letExp,
				safeVisit(letExp.getVariable()),
				safeVisit(letExp.getIn()));
	}
    
    /**
     * Visits the specified let expression with the results of visiting
     * its variable and in expression.
     * 
     * @param letExp the let expression
     * @param variableResult the result of visiting the expression's variable
     * @param inResult the result of visiting the expression's in expression
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitLetExp(LetExp)
     */
    protected T handleLetExp(LetExp letExp, T variableResult, T inResult) {
        return result;
    }

    /**
     * Simply returns {@link #result}.
     */
	@Override
	public T visitEnumLiteralExp(EnumLiteralExp literalExp) {
		return result;
	}

    /**
     * Visits the collection literal's parts.
     * 
     * Returns the result of {@link #handleCollectionLiteralExp(CollectionLiteralExp, List)}.
     */
	@Override
	public T visitCollectionLiteralExp(CollectionLiteralExp literalExp) {
        List<T> partResults;
        List<CollectionLiteralPart> parts = literalExp.getParts();
        
        if (parts.isEmpty()) {
            partResults = Collections.emptyList();
        } else {
            partResults = new java.util.ArrayList<T>(parts.size());
            for (CollectionLiteralPart part : parts) {
                partResults.add(safeVisit(part));
            }
        }
        
        return handleCollectionLiteralExp(literalExp, partResults);
	}
    
    /**
     * Visits the specified collection literal expression with the results of visiting
     * its parts (if any).
     * 
     * @param literalExp the collection literal expression
     * @param partResults the results of visiting the expression's
     *     parts, or an empty list if there are no parts
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitCollectionLiteralExp(CollectionLiteralExp)
     */
    protected T handleCollectionLiteralExp(CollectionLiteralExp literalExp,
            List<T> partResults) {
        return result;
    }
    
    /**
     * Visits the item's item expression.
     * 
     * Returns the result of {@link #handleCollectionItem(CollectionItem, Object)}
     */
    @Override
	public T visitCollectionItem(CollectionItem item) {
    	T itemResult = safeVisit(item.getItem());
    	
        return handleCollectionItem(item, itemResult);
    }
    
    /**
     * Visits the specified collection item with the result of visiting
     * its item expression.
     * 
     * @param item the collection item
     * @param itemResult the result of visiting the item's item expression
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitCollectionItem(CollectionItem)
     */
    protected T handleCollectionItem(CollectionItem item, T itemResult) {
        return result;
    }
    
    /**
     * Visits the range's first and last expressions.
     * 
     * Returns the result of {@link #handleCollectionRange(CollectionRange, Object, Object)}.
     */
    @Override
	public T visitCollectionRange(CollectionRange range) {
        return handleCollectionRange(range,
        		safeVisit(range.getFirst()),
        		safeVisit(range.getLast()));
    }
    
    /**
     * Visits the specified collection range with the results of visiting
     * its first and last expressions.
     * 
     * @param range the collection range
     * @param firstResult the result of visiting the range's first expression
     * @param lastResult the result of visiting the range's last expression
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitCollectionRange(CollectionRange)
     */
    protected T handleCollectionRange(CollectionRange range, T firstResult,
            T lastResult) {
        return result;
    }

    /**
     * Visits the iterator's source, then its variables, followed by its body
     * expression.
     * Returns the result of {@link #handleIteratorExp(IteratorExp, Object, List, Object)}.
     */
	@Override
	public T visitIteratorExp(IteratorExp callExp) {
        T sourceResult = safeVisit(callExp.getSource());
        
        List<T> variableResults;
        List<Variable> variables = callExp.getIterators();
        
        if (variables.isEmpty()) {
            variableResults = Collections.emptyList();
        } else {
            variableResults = new java.util.ArrayList<T>(variables.size());
            for (Variable iterVar : variables) {
                variableResults.add(safeVisit(iterVar));
            }
        }
        
        T bodyResult = safeVisit(callExp.getBody());
        
        return handleIteratorExp(callExp, sourceResult, variableResults, bodyResult);
	}
    
    /**
     * Visits the specified iterator expression with the results of visiting
     * its source, its iterator variables, and its body expression.
     * 
     * @param callExp the iterator expression
     * @param sourceResult the result of visiting the expression's source
     * @param variableResults the results of visiting the expression's
     *     iterator variables
     * @param bodyResult the result of visiting the expression's body
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitIteratorExp(IteratorExp)
     */
    protected T handleIteratorExp(IteratorExp callExp,
            T sourceResult, List<T> variableResults, T bodyResult) {
        return result;
    }

    /**
     * Visits the iterate's source, then its iterator variables,
     * result variable, and body expression.
     * Returns the result of {@link #handleIterateExp(IterateExp, Object, List, Object, Object)}.
     */
	@Override
	public T visitIterateExp(IterateExp callExp) {
        T sourceResult = safeVisit(callExp.getSource());
        
        List<T> variableResults;
        List<Variable> variables = callExp.getIterators();
        
        if (variables.isEmpty()) {
            variableResults = Collections.emptyList();
        } else {
            variableResults = new java.util.ArrayList<T>(variables.size());
            for (Variable iterVar : variables) {
                variableResults.add(safeVisit(iterVar));
            }
        }
        
        T resultResult = safeVisit(callExp.getResult());
        T bodyResult = safeVisit(callExp.getBody());
        
        return handleIterateExp(callExp, sourceResult, variableResults,
            resultResult, bodyResult);
	}
    
    /**
     * Visits the specified iterate expression with the results of visiting
     * its source, its iterator variables, its result variable, and its body
     * expression.
     * 
     * @param callExp the iterate expression
     * @param sourceResult the result of visiting the expression's source
     * @param variableResults the results of visiting the expression's
     *     iterator variables
     * @param resultResult the result of visiting the expressions' result variable
     * @param bodyResult the result of visiting the expression's body
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitIterateExp(IterateExp)
     */
    protected T handleIterateExp(IterateExp callExp,
            T sourceResult, List<T> variableResults, T resultResult, T bodyResult) {
        return result;
    }

    /**
     * Visits the expressions context variable, its parameter variables (if any),
     * its result variable (if any), and finally its body expression.
     * 
     * Returns the result of
     * {@link #handleExpressionInOCL(ExpressionInOCL, Object, Object, List, Object)}.
     */
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
    }
    
    /**
     * Visits the specified expression-in-OCL with the results of visiting
     * its context variable, its result variable (if any), its parameter
     * variables (if any), and its body expression.
     * 
     * @param expression the expression-in-OCL
     * @param contextResult the result of visiting the expression's context variable
     * @param resultResult the result of visiting the expressions' result variable,
     *     or <code>null</code> if there is no result variable
     * @param parameterResults the results of visiting the expression's
     *     parameter variables, or an empty list if there are none
     * @param bodyResult the result of visiting the expression's body
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitExpressionInOCL(ExpressionInOCL)
     */
    protected T handleExpressionInOcl(ExpressionInOcl expression,
            T contextResult, T resultResult, List<T> parameterResults, T bodyResult) {
        return result;
    }
    
    /**
     * Visits the constraint's specification, if any (and if the
     * {@link #getSpecification(Object)} method is overridden).
     *  
     * Returns the result of {@link #handleConstraint(Object, Object)}.
     * 
     * @see #getSpecification(Object)
     */
	@Override
	public T visitConstraint(Constraint constraint) {
        T specificationResult = safeVisit(getSpecification(constraint));
		
		return handleConstraint(constraint, specificationResult);
	}
    
    /**
     * Visits the specified constraint with the results of visiting
     * its specification.
     * 
     * @param constraint the constraint
     * @param specificationResult the result of visiting the constraint's
     *     specification, or <code>null</code> if either it has none or the
     *     {@link #getSpecification(Object)} method is not overridden
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * #see {@link #getSpecification(Object)}
     * @see #visitConstraint(Object)
     */
    protected T handleConstraint(Constraint constraint, T specificationResult) {
        return result;
    }
	
    /**
     * Overridden by subclasses interested in visiting constraints, to get the
     * constraint's specification.
     * 
     * @param constraint a constraint
     * @return its specification
     * 
     * @see #visitConstraint(Object)
     */
	protected ExpressionInOcl getSpecification(Constraint constraint) {
		return null;
	}
} //VisitorImpl
