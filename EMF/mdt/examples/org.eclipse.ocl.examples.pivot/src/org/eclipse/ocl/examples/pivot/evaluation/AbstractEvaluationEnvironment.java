/**
 * <copyright>
 *
 * Copyright (c) 2007,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: AbstractEvaluationEnvironment.java,v 1.5 2011/02/21 08:37:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.Adaptable;
import org.eclipse.ocl.examples.pivot.Customizable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.InvalidEvaluationException;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OCLUtil;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.options.Option;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.NullValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * A partial implementation of the {@link EvaluationEnvironment} interface,
 * providing some useful common behaviors.  Implementors of metamodel-specific
 * environments are encourage to extend this class rather than implement
 * an evaluation environment "from scratch."
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p><p>
 * Since the 1.2 release, this interface is {@link Adaptable} to support the
 * optional adapter protocols such as {@link EvaluationEnvironment.Enumerations}
 * and {@link Customizable}.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEvaluationEnvironment
		implements EvaluationEnvironment, Adaptable, Customizable {
	
    protected final TypeManager typeManager;

	private final EvaluationEnvironment parent;
    private final Map<VariableDeclaration, Value> variableValues = new HashMap<VariableDeclaration, Value>();

    private final Map<Option<?>, Object> options = new HashMap<Option<?>, Object>();
    
    protected AbstractEvaluationEnvironment(TypeManager typeManager) {
    	this.typeManager = typeManager;
    	this.parent = null;
    }
    
    protected AbstractEvaluationEnvironment(EvaluationEnvironment parent) {	
    	this.typeManager = parent.getTypeManager();
    	this.parent = parent;
    }
    
    /**
     * Obtains my parent (nesting) environment.
     * 
     * @return my parent environment, or <code>null</code> if none
     */
    protected EvaluationEnvironment getParent() {
    	return parent;
    }
    
	public TypeManager getTypeManager() {
		return typeManager;
	}
    
    /**
     * Returns the value associated with the supplied name
     * 
     * @param name
     *            the name whose value is to be returned
     * @return the value associated with the name
     */
	public Value getValueOf(VariableDeclaration referredVariable) {
    	if (referredVariable instanceof Variable) {
    		assert ((Variable)referredVariable).getRepresentedParameter() == null;
    	}
    	Value object = variableValues.get(referredVariable);
        if ((object == null) && (parent != null) && !variableValues.containsKey(referredVariable)) {
        	object = parent.getValueOf(referredVariable);
        }
        return object;
	}

    /**
     * Replaces the current value of the supplied name with the supplied value.
     * 
     * @param name
     *            the name
     * @param value
     *            the new value
     */
    public void replace(VariableDeclaration referredVariable, Value value) {
    	if (referredVariable instanceof Variable) {
    		assert ((Variable)referredVariable).getRepresentedParameter() == null;
    	}
    	variableValues.put(referredVariable, value);
    }

    /**
     * Adds the supplied name and value binding to the environment
     * 
     * @param name
     *            the name to add
     * @param value
     *            the associated binding
     */
    public void add(VariableDeclaration referredVariable, Value value) {
    	if (referredVariable instanceof Variable) {
    		assert ((Variable)referredVariable).getRepresentedParameter() == null;
    	}
        if (variableValues.containsKey(referredVariable)) {
            String message = OCLMessages.bind(
            		OCLMessages.BindingExist_ERROR_,
            		referredVariable,
            		variableValues.get(referredVariable));
            throw new IllegalArgumentException(message);
        }
        variableValues.put(referredVariable, value);
    }

    /**
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
    @Deprecated
    public Value remove(VariableDeclaration referredVariable) {
    	if (referredVariable instanceof Variable) {
    		assert ((Variable)referredVariable).getRepresentedParameter() == null;
    	}
    	return variableValues.remove(referredVariable);
    }

    /**
     * Clears the environment of variables.
     */
    public void clear() {
    	variableValues.clear();
    }

    /**
     * Returns a string representation of the bindings
     */
    @Override
    public String toString() {
        return variableValues.toString();
    }
    
    /**
     * By default, a subclass will not support overriding the operations defined
     * by the OCL Standard Library.  This implementation delegates to the
     * parent environment (if any), otherwise returns <code>false</code>.
     */
    public boolean overrides(Operation operation, int opcode) {
    	return (getParent() != null)? getParent().overrides(operation, opcode) : false;
    }

    /**
     * Implements the inherited method by attempting to find an appropriate
     * Java method in the actual type of the <tt>source</tt> object and invoking
     * it.  On failure to find or invoke the method (e.g., an exception), the
     * <tt>OclInvalid</tt> result is returned.
     * 
     * @return the result of the Java method invocation, or <tt>OclInvalid</tt>
     *    on failure of the method invocation
     *
    public Object callOperation(Operation operation, int opcode, Object source, Object[] args)
    
		throws IllegalArgumentException {
    	
    	if (getParent() != null) {
    		return getParent().callOperation(operation, opcode, source, args);
    	}
    	
    	Method method = getJavaMethodFor(operation, source);
    	
    	if (method != null) {
    		try {
    		    // coerce any collection arguments to EList as necessary
    		    Class<?>[] parmTypes = method.getParameterTypes();
    		    for (int i = 0; i < parmTypes.length; i++) {
    		        if (EList.class.isAssignableFrom(parmTypes[i])) {
    		            if (args[i] == null) {
    		                args[i] = ECollections.EMPTY_ELIST;
    		            } else if (!(args[i] instanceof Collection<?>)) {
    		                EList<Object> list = new BasicEList.FastCompare<Object>(1);
    		                list.add(args[i]);
    		                args[i] = list;
    		            } else if (!(args[i] instanceof EList<?>)) {
    		                args[i] = new BasicEList.FastCompare<Object>((Collection<?>) args[i]);
    		            }
    		        }
    		    }
    		    
				return method.invoke(source, args);
			} catch (Exception e) {
				OCLPlugin.catching(getClass(), "callOperation", e);//$NON-NLS-1$
				OCLPlugin.log(
					Diagnostic.ERROR,
					OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					OCLMessages.bind(
						OCLMessages.ErrorMessage_ERROR_,
						"calloperation", //$NON-NLS-1$
						e.getLocalizedMessage()),
					e);
				return getInvalidResult();
			}
    	}
    	
    	// maybe it's a comparison operation that is implemented implicitly
    	// via the Comparable interface?
    	switch (opcode) {
    	    case PredefinedType.LESS_THAN:
    	    case PredefinedType.GREATER_THAN:
    	    case PredefinedType.LESS_THAN_EQUAL:
    	    case PredefinedType.GREATER_THAN_EQUAL:
            if ((source instanceof Comparable<?>) && (args.length == 1)) {
                @SuppressWarnings("unchecked")
                Comparable<Object> comparable = (Comparable<Object>) source;
                Object other = args[0];
                
            	switch (opcode) {
                    case PredefinedType.LESS_THAN:
                        return comparable.compareTo(other) < 0;
                    case PredefinedType.GREATER_THAN:
                        return comparable.compareTo(other) > 0;
                    case PredefinedType.LESS_THAN_EQUAL:
                        return comparable.compareTo(other) <= 0;
                    case PredefinedType.GREATER_THAN_EQUAL:
                        return comparable.compareTo(other) >= 0;
            	}
            }
            break;
    	}
    	
    	throw new IllegalArgumentException();
    } */
    
	/**
	 * Returns the java method that corresponds to the supplied
	 * <code>EOperation</code>
	 * 
	 * @param operation
	 *            the operation
	 * @return a java method
	 */
//	@Deprecated
//	protected abstract Method getJavaMethodFor(Operation operation, Object receiver);
	
	/**
	 * Obtains the language-binding-specific representation of the predefined
	 * <tt>OclInvalid</tt> object.
	 * 
	 * @return <tt>OclInvalid</tt>
	 */
//	@Deprecated
//	protected abstract Object getInvalidResult();
	
	/**
	 * Implements the interface method by testing whether I am an instance of
	 * the requested adapter type.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		T result;
		
		if (adapterType.isInstance(this)) {
			result = (T) this;
		} else {
			result = null;
		}
		
		return result;
	}
    
    protected Map<Option<?>, Object> basicGetOptions() {
        return options;
    }
    
    public Map<Option<?>, Object> getOptions() {
        Customizable parent = (getParent() != null)?
            OCLUtil.getAdapter(getParent(), Customizable.class) : null;
            
        Map<Option<?>, Object> result = (parent != null)
        	? new java.util.HashMap<Option<?>, Object>(parent.getOptions())
            : new java.util.HashMap<Option<?>, Object>();
        
        result.putAll(basicGetOptions());
        
        return result;
    }
    
    public <T> void setOption(Option<T> option, T value) {
        basicGetOptions().put(option, value);
    }
    
    public <T> void putOptions(Map<? extends Option<T>, ? extends T> options) {
        Map<Option<?>, Object> myOptions = basicGetOptions();
        
        myOptions.clear();
        myOptions.putAll(options);
    }
    
    public <T> T removeOption(Option<T> option) {
        T result = getValue(option);
        
        basicGetOptions().remove(option);
        
        return result;
    }
    
    public <T> Map<Option<T>, T> removeOptions(Collection<Option<T>> options) {
        Map<Option<T>, T> result = new java.util.HashMap<Option<T>, T>();
        
        Map<Option<?>, Object> myOptions = basicGetOptions();
        
        for (Option<T> next : options) {
            result.put(next, getValue(next));
            myOptions.remove(next);
        }
        
        return result;
    }
    
    public Map<Option<?>, Object> clearOptions() {
        Map<Option<?>, Object> myOptions = basicGetOptions();
        
        Map<Option<?>, Object> result = new java.util.HashMap<Option<?>, Object>(
                myOptions);
        
        myOptions.clear();
        
        return result;
    }
    
    public boolean isEnabled(Option<Boolean> option) {
        Boolean result = getValue(option);
        return (result == null)? false : result.booleanValue();
    }
    
    public <T> T getValue(Option<T> option) {
        @SuppressWarnings("unchecked")
        T result = (T) getOptions().get(option);
        
        if (result == null) {
            Customizable parent = (getParent() != null)?
                OCLUtil.getAdapter(getParent(), Customizable.class) : null;
                
            result = (parent != null)? parent.getValue(option)
                : option.getDefaultValue();
        }
        
        return result;
    }

/*	public NullValue throwInvalidEvaluation(Object value, OclExpression expression,
			String message, Object object)
			throws InvalidEvaluationException {
		// TODO Auto-generated method stub
		return null;
	} */

	public NullValue throwInvalidEvaluation(InvalidValueException e) throws InvalidEvaluationException {
		throw new InvalidEvaluationException(this, e);
	}

	public NullValue throwInvalidEvaluation(String message) throws InvalidEvaluationException {
		throw new InvalidEvaluationException(this, message, null, null, null);
	}

	public NullValue throwInvalidEvaluation(String message, OclExpression expression) throws InvalidEvaluationException {
		throw new InvalidEvaluationException(this, message, null, expression, null);
	}

	public NullValue throwInvalidEvaluation(String message, OclExpression expression, Object context) throws InvalidEvaluationException {
		throw new InvalidEvaluationException(this, message, null, expression, context);
	}

	public NullValue throwInvalidEvaluation(String message, Throwable e, OclExpression expression, Object context) throws InvalidEvaluationException {
		throw new InvalidEvaluationException(this, message, e, expression, context);
	}
}
