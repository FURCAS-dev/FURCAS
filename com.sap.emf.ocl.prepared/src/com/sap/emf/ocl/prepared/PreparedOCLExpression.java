package com.sap.emf.ocl.prepared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.prepared.parameters.DuplicateParameterValueException;
import com.sap.emf.ocl.prepared.parameters.Parameter;
import com.sap.emf.ocl.prepared.parameters.ParameterFactory;
import com.sap.emf.ocl.prepared.parameters.ParameterFinder;
import com.sap.emf.ocl.prepared.parameters.ParameterNotFoundException;
import com.sap.emf.ocl.util.OclHelper;

/**
 * Similar to a JDBC prepared statement, where parameters can be set to specific values before executing it,
 * a prepared OCL expression can have a number of parameters which are substituted by values before
 * evaluating the expression. Only {@link LiteralExp} expressions can be configured using parameters. The
 * {@link LiteralExp} expressions to be made parameterizable can either be specified explicitly (see
 * {@link #PreparedOCLExpression(OCLExpression, LiteralExp...)}) or indirectly by means of specifying the
 * literal's value (see {@link #PreparedOCLExpression(OCLExpression, Object...)}). In the latter case, a
 * visitor traverses the expression tree and looks for {@link LiteralExp} expressions such as string
 * constants or enumeration literals, and compares them to the objects passed to the constructor. If a match
 * is found, that literal expression is made parameterizable. 
 * <p>
 * 
 * The expression that is parameterized will be modified upon evaluation. Therefore, evaluation is
 * synchronized on this prepared expression object so that no race conditions may occur when multiple
 * threads evaluate the same parameterized expression for different parameter values.<p>
 * 
 * For evaluation, an {@link OCLWithHiddenOpposites} environment is used which adds support for
 * {@link OppositePropertyCallExp} expressions.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class PreparedOCLExpression {
    private final OCLExpression expression;
    private final List<Parameter<?>> params;
    private final Map<Object, Parameter<?>> paramsByIdentifyingSymbols;
    private OppositeEndFinder oppositeEndFinder;
    private EcoreEnvironmentFactoryWithHiddenOpposites environmentFactory;
    
    public class ParameterValue<T> {
        private final Parameter<T> param;
        private final T value;
        
        public ParameterValue(Parameter<T> param, T value) {
            this.param = param;
            this.value = value;
        }

        public Parameter<T> getParameter() {
            return param;
        }

        T getValue() {
            return value;
        }

        /**
         * Replaces the parameterized literal's symbol by the value stored in this object
         */
        void set() {
            getParameter().set(getValue());
        }

        ParameterValue<T> getUndo() {
            return new ParameterValue<T>(getParameter(), getParameter().get());
        }
    }

    /**
     * The <code>params</code> subexpressions which are expected to be contained in <code>expression</code>'s
     * expression tree are marked as the parameters of the resulting {@link PreparedOCLExpression}. When
     * {@link PreparedOCLExpression#evaluate(Object, ParameterValue...)} is called, the parameter values
     * will be substituted in order for the <code>params</code>' literal objects.
     */
    public PreparedOCLExpression(OCLExpression expression, LiteralExp... params) {
        for (LiteralExp param : params) {
            if (OclHelper.getRootExpression(param) != expression) {
                throw new RuntimeException("Parameter expression from wrong root expression: "+
                        "Should be "+expression+" but was "+OclHelper.getRootExpression(param));
            }
        }
        this.expression = expression;
        this.params = new ArrayList<Parameter<?>>(params.length);
        this.paramsByIdentifyingSymbols = new HashMap<Object, Parameter<?>>();
        ParameterFactory factory = ParameterFactory.INSTANCE;
        for (LiteralExp param : params) {
            Parameter<?> p = factory.getParameterFor(param);
            this.params.add(p);
            paramsByIdentifyingSymbols.put(p.get(), p);
        }
    }

    /**
     * Finds {@link LiteralExp} expressions contained in <code>expression</code> that have any of the <code>paramValues</code> as
     * their literal symbol and initializes the parameters accordingly, such that they refer to the respective literal
     * expressions.
     * 
     * @param paramValues
     *            a sequence of unique values to be found in {@link LiteralExp} expressions' symbols occurring inside
     *            <code>expression</code>
     * 
     * @throws DuplicateParameterValueException
     *             if any of <code>paramValues</code> occurs in more than one literal expression inside <code>expression</code>
     * @throws ParameterNotFoundException
     *             if one or more of the <code>paramValues</code> are not found in any literal expression inside
     *             <code>expression</code>
     * @throws IllegalArgumentException
     *             in case <code>paramValues</code> contains duplicates considering the definition of <code>equals</code> on these
     *             objects
     */
    public PreparedOCLExpression(OCLExpression expression, Object... paramValues) throws ParameterNotFoundException,
            DuplicateParameterValueException, IllegalArgumentException {
        ParameterFinder finder = new ParameterFinder(paramValues);
        paramsByIdentifyingSymbols = finder.visit(expression);
        Parameter<?>[] paramsArray = new Parameter<?>[paramValues.length];
        List<Object> paramValuesAsList = Arrays.asList(paramValues);
        for (Parameter<?> p : paramsByIdentifyingSymbols.values()) {
            paramsArray[paramValuesAsList.indexOf(p.get())] = p;
        }
        this.params = Arrays.asList(paramsArray);
        this.expression = expression;
    }

    /**
     * Like {@link #PreparedOCLExpression(OCLExpression, LiteralExp...)}, but allows clients to specify a specific OCL environment
     * factory to be used for expression evaluation.
     */
    public PreparedOCLExpression(EcoreEnvironmentFactoryWithHiddenOpposites environmentFactory,
            OCLExpression expression, LiteralExp... params) {
        this(expression, params);
        this.environmentFactory = environmentFactory;
    }
    
    /**
     * Like {@link #PreparedOCLExpression(OCLExpression, LiteralExp...)}, but allows clients to provide
     * a specific {@link OppositeEndFinder} to be used during expression evaluation.
     */
    public PreparedOCLExpression(OppositeEndFinder oppositeEndFinder,
            OCLExpression expression, LiteralExp... params) {
        this(expression, params);
        this.oppositeEndFinder = oppositeEndFinder;
    }
    
    @SuppressWarnings("unchecked")
    public <T> ParameterValue<T> createParameterValue(T originalValue, T newValue) {
        return new ParameterValue<T>((Parameter<T>) paramsByIdentifyingSymbols.get(originalValue), newValue);
    }
    
    /**
     * Positions are assigned according to the order of values or literal expressions passed to
     * the respective constructor.
     */
    @SuppressWarnings("unchecked")
    public <T> ParameterValue<T> createPositionalParameterValue(int i, T newValue) {
        return new ParameterValue<T>((Parameter<T>) params.get(i), newValue);
    }

    /**
     * Sets the parameter values according to <code>parameterValues</code>, evaluates the parameterized
     * expression and then resets the parameterized literals to their original symbols.
     * @param context evaluation context; see also {@link OCL#evaluate(Object, org.eclipse.ocl.expressions.OCLExpression)}.
     */
    public synchronized Object evaluate(Object context, ParameterValue<?>... parameterValues) {
        Set<ParameterValue<?>> originalValues = new HashSet<ParameterValue<?>>();
        try {
            for (ParameterValue<?> pv : parameterValues) {
                originalValues.add(pv.getUndo());
                pv.set();
            }
            return getOCL().evaluate(context, expression);
        } finally {
            for (ParameterValue<?> originalValue : originalValues) {
                originalValue.set();
            }
        }
    }

    private OCL getOCL() {
        if (oppositeEndFinder != null) {
            return OCLWithHiddenOpposites.newInstance(oppositeEndFinder);
        } else {
            if (environmentFactory != null) {
                return OCLWithHiddenOpposites.newInstance(environmentFactory);
            } else {
                return OCLWithHiddenOpposites.newInstance();
            }
        }
    }
}
