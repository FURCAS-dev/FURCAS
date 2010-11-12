package org.eclipse.ocl.uml.options;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * Enumeration of evaluation modes, indicating how the UML evaluation
 * environment implementation is to interpret instances:  as instance
 * specifications in a UML model (M1 level, {@link #INSTANCE_MODEL}) or
 * as objects in the modeled system (M0 level, {@link #RUNTIME_OBJECTS}).
 * The special {@link #ADAPTIVE} value attempts to determine this mode
 * automatically from the evaluation context object (<tt>self</tt>).
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public enum EvaluationMode {
    /** Instances are modeled at the M1 level (in the user model). */
    INSTANCE_MODEL,
    /** Instances are run-time objects at the M0 (in the modeled system). */
    RUNTIME_OBJECTS,
    /**
     * Automatically determine the effective modeling level from the
     * context element.  This has problems when the context element is an
     * {@link InstanceSpecification} of some kind in the user model, because it
     * will be assumed to mean M1 level ({@link #INSTANCE_MODEL}) rather
     * than M0 level ({@link #RUNTIME_OBJECTS}) despite the fact that the
     * latter is more appropriate for expressions on the UML metamodel. 
     */
    ADAPTIVE;
}