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
 * $Id: ParsingOptions.java,v 1.9 2010/02/09 21:04:08 ewillink Exp $
 */

package org.eclipse.ocl.options;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.UMLReflection;



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
	 * The alternative strategies for resolving the package name at the start of
	 * a path name. The default LOOKUP_PACKAGE_BY_NAME strategy supports the
	 * OMG 2.2 specification. The alternate strategies support a potential extension
	 * for 'import' statements.
	 * 
	 * @since 3.1
	 */
    public static enum PACKAGE_LOOKUP_STRATEGIES {
		/**
		 * <tt>LOOKUP_PACKAGE_BY_NAME</tt> is the default and traditional
		 * behavior whereby the first package name is resolved by recursive
		 * search from names in the current environment to parent environments.
		 * Once all these search possibilities have been exhausted, the package
		 * registry for the root environment is searched for an already resolved
		 * package whose name matches the first package name. Unresolved package
		 * descriptors are not resolved during this process which also means
		 * that packages contained by yet unresolved in the registry will not be
		 * found.
		 * <p>
		 * The outward direction of this search allows inner environments to
		 * occlude outer definitions and in some cases may make outer
		 * definitions inaccessible.
		 */
    	LOOKUP_PACKAGE_BY_NAME,
    	/**
		 * <tt>LOOKUP_PACKAGE_BY_ALIAS</tt> ignores hierarchical context and just
		 * looks up the first package name as the 'nsURI' key in the package registry
		 * of the root environment. For this to give useful results, the package
		 * registry should be populated with a mapping from package name aliases to packages.
		 * <p>
		 * This strategy therefore supports a possible import syntax such as:
		 * <pre>  import OclEcore 'http://www.eclipse.org/ocl/1.1.0/Ecore'</pre>
		 * in which <tt>OclEcore</tt> is defined as an alias for the OCL Ecore package.
		 * <p>
		 * More than one 'alias' may map to the same package.
		 * <p>
		 * This strategy is only supported for the Ecore binding.
		 */
    	LOOKUP_PACKAGE_BY_ALIAS,
		/**
		 * <tt>LOOKUP_PACKAGE_BY_ALIAS_THEN_NAME</tt> combines the alias and
		 * traditional strategies. If the first package name can be located as
		 * an alias, then the alias resolution is used, otherwise the recursive
		 * environment search proceeds.
		 * <p>
		 * This strategy ensures that package name aliases cannot be occluded.
		 * <p>
		 * In order to use this strategy and avoid cluttering a registry of
		 * packages that may serve other purposes, it is recommended that the
		 * root environment is created with a fresh
		 * {@link EPackageRegistryImpl#EPackageRegistryImpl() registry} that is
		 * populated with the packages required, e.g., by copying all contents
		 * of the {@link EPackage.Registry#INSTANCE default package registry}
		 * using {@link java.util.Map#putAll(java.util.Map)}. Note, that this
		 * will copy unresolved package descriptors to the new registry without
		 * resolving them.
		 * <p>
		 * This strategy is only supported for the Ecore binding.
		 */
    	LOOKUP_PACKAGE_BY_ALIAS_THEN_NAME
    };
    
    /**
     * <p>
     * Static instance for the lookup-package-by-aliase option token.  It is returned
     * via an unchecked cast by the {@link #implicitRootClass()} method.
     * </p>
     * @since 3.1
     */
    public static final Option<PACKAGE_LOOKUP_STRATEGIES> PACKAGE_LOOKUP_STRATEGY =
        new BasicOption<PACKAGE_LOOKUP_STRATEGIES>("lookup.package.by.alias", PACKAGE_LOOKUP_STRATEGIES.LOOKUP_PACKAGE_BY_NAME); //$NON-NLS-1$

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
    public static <C> Option<C> implicitRootClass(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env) {
        return (Option<C>) IMPLICIT_ROOT_CLASS;
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
    public static <T> void setOption(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env,
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
    public static <T> T getValue(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env,
            Option<T> option) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom == null) {
            // go for the external basic-environment adapter that we provide
            custom = OCLUtil.getAdapter(env, BasicEnvironment.class);
        }
        
        return custom.getValue(option);
    }

}
