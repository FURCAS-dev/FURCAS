/**
 * <copyright>
 *
 * Copyright (c) 2007, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 295166
 *   Borland - Bug 242880
 *
 * </copyright>
 *
 * $Id: ParsingOptions.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.options;

import org.eclipse.ocl.examples.pivot.BasicEnvironment;
import org.eclipse.ocl.examples.pivot.Customizable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.OCLUtil;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * Options applicable to {@link Environment}s to
 * {@linkplain Customizable customize} their parsing behaviour.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public class ParsingOptions {

    /**
     * <p>
     * Parsing option indicating whether to reference the defined property or
     * operation in a <tt>def:</tt> expression as a constrained element of the
     * constraint, in addition to the context classifier.  The well-formedness
     * rules for definition constraints in the OCL 2.0 Specification require
     * that a definition constraint reference only its context classifier as
     * a constrained element.
     * </p><p>
     * The default value of this option is <tt>false</tt>.  For compatibility
     * with the 1.1 release behaviour, set this option <tt>true</tt>.  Note
     * that this is not necessary for loading and processing constraints
     * created by the 1.1 release, only for persisting constraints that will be
     * consumed by the 1.1 release.
     * </p>
     */
    public static final Option<Boolean> DEFINITION_CONSTRAINS_FEATURE =
        new BasicOption<Boolean>("definition.constraints.feature", false); //$NON-NLS-1$

    /**
     * <p>
     * Parsing option indicating whether to interpolate {@literal <},
     * {@literal <=}, {@literal >}, and {@literal >=} operations when a model
     * type defines a Java-style <tt>compareTo(...)</tt> operation.
     * </p><p>
     * The default value of this option is <tt>false</tt>.  For compatibility
     * with the 1.1 release behaviour, set this option <tt>true</tt>.
     * </p>
     */
    public static final Option<Boolean> USE_COMPARE_TO_OPERATION =
        new BasicOption<Boolean>("use.compare.to.operation", false); //$NON-NLS-1$

    /**
     * <p>
     * Parsing option indicating whether to generate a warning when the
     * OCL 2.1 parsing of distinct xor, or, and precedences leads to a different
     * parse to the OCL 2.0 specification of all levels equal.
     * The default value of this option is <tt>false</tt>.  To diagnose
     * compatibility with the OCL 2.0  behaviour in the MDT-OCL 1.x release,
     * set this option <tt>true</tt>.
     * </p>
     * @since 3.0
     */
    public static final Option<Boolean> WARN_OF_XOR_OR_AND_PRECEDENCE_CHANGE =
        new BasicOption<Boolean>("warn.of.xor.or.and.precedence.change", false); //$NON-NLS-1$

    /**
     * <p>
     * Static instance for the implicit-root-class option token.  It is returned
     * via an unchecked cast by the {@link #implicitRootClass()} method.
     * </p>
     */
    public static final Option<?> IMPLICIT_ROOT_CLASS =
        new BasicOption<Object>("implict.root.class", null); //$NON-NLS-1$

	/**
	 * <p>
	 * Parsing option indicating whether to process backslash escape sequences (
	 * <tt>\n</tt>, <tt>\r</tt>, etc.) as specified by OMG Issue 14357 for OCL 2.3.
	 * </p>
	 * <p>
	 * The default value of this option is <tt>true</tt>. To disable
	 * backslash escaping support, set this option <tt>false</tt>.
	 * </p>
	 * 
	 * @since 1.3
	 */
    public static final Option<Boolean> USE_BACKSLASH_ESCAPE_PROCESSING =
        new BasicOption<Boolean>("use.backslash.escape.processing", true); //$NON-NLS-1$

    /**
     * <p>
     * A parsing option specifying a class that's assumed to be the implicit
     * root of the subject model's class hierarchy.  Note that this excludes
     * datatypes defined by OCL such as the collections and tuples, and also those
     * defined by the subject model.  This option is only used in accessing operations
     * and attributes; for other characteristics of a classifier, a specialized
     * environment implementation is required.
     * </p><p>
     * This option is commonly used to provide access to operations and attributes
     * defined by an implicit root extends class in Ecore-based models, for example,
     * such as <tt>EObject</tt>, that is not explicitly referenced in the subject model.
     * </p><p>
     * The default value of this option is <tt>null</tt>.
     * </p>
     * 
     * @param <C> the type representing classes in the target metamodel, consistent with
     *    the current {@link Environment} implementation
     * 
     * @param env the environment to which this option is to be applied
     * 
     * @return the option token
     */
    @SuppressWarnings("unchecked")
    public static Option<Type> implicitRootClass(
            Environment env) {
        return (Option<Type>) IMPLICIT_ROOT_CLASS;
    }

    /**
     * <p>
     * Parsing option indicating whether to accept <tt>static</tt> as part of a
     * definition constraint. <tt>static</tt> are a proposed cpability of OCL 2.1,
     * however they are only available for meta-models that implement the
     * {@link UMLReflection#setIsStatic(Object, boolean)} method. Therefore use of <tt>static</tt> constraints
     * will generate an error message on the Ecore binding regardless of this setting.
     * </p><p>
     * The default value of this option is <tt>true</tt>.  For stricter compatibility
     * with OCL 2.0, set this option <tt>false</tt>.
     * </p>
     * @since 3.0
     * 
     * @see UMLReflection#setIsStatic(Object, boolean)
     */
    public static final Option<Boolean> SUPPORT_STATIC_FEATURES =
        new BasicOption<Boolean>("support.static.features", true); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private ParsingOptions() {
        super();
    }

    /**
     * Add an option to apply to the specified environment, adapting it as
     * necessary to the {@link Customizable} API.
     * 
     * @param env an environment on which to set an option
     * @param option the option
     * @param value the option's value
     * 
     * @see Cusotmizable#setOption(Option, Object)
     */
    public static <T> void setOption(Environment env,
            Option<T> option, T value) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom == null) {
            // go for the external basic-environment adapter that we provide
            custom = OCLUtil.getAdapter(env, BasicEnvironment.class);
        }
        
        custom.setOption(option, value);
    }

    /**
     * Obtains the value of the specified option's setting in the the given
     * environment's options map, adapting the environment as necessary to the
     * {@link Customizable} API.  If not already set, return the option's
     * {@linkplain #getDefaultValue() default value}.
     * 
     * @param env an environment on which to query an option
     * @param option an option to query
     * 
     * @return value of the option
     * 
     * @see Customizable#getValue(Option)
     */
    public static <T> T getValue(Environment env,
            Option<T> option) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom == null) {
            // go for the external basic-environment adapter that we provide
            custom = OCLUtil.getAdapter(env, BasicEnvironment.class);
        }
        
        return custom.getValue(option);
    }

}
