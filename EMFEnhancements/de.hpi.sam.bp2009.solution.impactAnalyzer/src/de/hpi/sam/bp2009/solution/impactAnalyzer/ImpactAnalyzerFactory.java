package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.opposites.OppositeEndFinder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCLExpression;


import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerFactoryImpl;

public interface ImpactAnalyzerFactory {
    static final ImpactAnalyzerFactory INSTANCE = new ImpactAnalyzerFactoryImpl();

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is inferred from any occurrence
     * of <code>self</code> in the expression. If no <code>self</code> occurrence can be found, an exception will be thrown. The
     * configuration is taken from the default {@link OptimizationActivation#getOption()}.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type and its subtypes or not. (Creation here means that the object is added to a resource in the
     *            {@link ResourceSet} observed by the {@link EventManager} used for handling change events.) Registering for
     *            element creation on the context type is useful for invariants / constraints because when a new element is
     *            created, validating the constraint may be useful. For other use cases, registering for element creation may not
     *            be so useful. For example, when a type inferencer defines its rules using OCL, it only wants to receive
     *            <em>update</em> events after the element has been fully initialized from those OCL expressions. In those cases,
     *            some framework may be responsible for the initial evaluation of those OCL expressions on new element, and
     *            therefore, context element creation events are not of interest.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type specification. Use this factory
     * method if <code>expression</code> does not contain any reference to <code>self</code>. The configuration is taken from the
     * default {@link OptimizationActivation#getOption()}.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type and its subtypes or not. (Creation here means that the object is added to a resource in the
     *            {@link ResourceSet} observed by the {@link EventManager} used for handling change events.) Registering for
     *            element creation on the context type is useful for invariants / constraints because when a new element is
     *            created, validating the constraint may be useful. For other use cases, registering for element creation may not
     *            be so useful. For example, when a type inferencer defines its rules using OCL, it only wants to receive
     *            <em>update</em> events after the element has been fully initialized from those OCL expressions. In those cases,
     *            some framework may be responsible for the initial evaluation of those OCL expressions on new element, and
     *            therefore, context element creation events are not of interest.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type specification. Use this factory
     * method if <code>expression</code> does not contain any reference to <code>self</code>. The configuration is taken from the
     * default {@link OptimizationActivation#getOption()}.
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements,
            OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is inferred from any occurrence
     * of <code>self</code> in the expression. If no <code>self</code> occurrence can be found, an exception will be thrown. The
     * configuration is taken from the default {@link OptimizationActivation#getOption()}.
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements,
            OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is inferred from any occurrence
     * of <code>self</code> in the expression. If no <code>self</code> occurrence can be found, an exception will be thrown.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements,
            OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type specification. Use this factory
     * method if <code>expression</code> does not contain any reference to <code>self</code>.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements,
            OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type specification. Use this factory
     * method if <code>expression</code> does not contain any reference to <code>self</code>.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements,
            ActivationOption configuration, OCLFactory oclFactory);

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is inferred from any occurrence
     * of <code>self</code> in the expression. If no <code>self</code> occurrence can be found, an exception will be thrown.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements,
            ActivationOption configuration, OCLFactory oclFactory);
}
