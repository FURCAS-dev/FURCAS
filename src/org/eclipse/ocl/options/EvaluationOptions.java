/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: EvaluationOptions.java,v 1.1 2007/11/06 19:47:11 cdamus Exp $
 */

package org.eclipse.ocl.options;

import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.util.OCLUtil;


/**
 * Options applicable to {@link EvaluationEnvironment}s to
 * {@linkplain Customizable customize} their evaluation behaviour.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public class EvaluationOptions {

    /**
     * <p>
     * Evaluation option indicating whether to implement lax handling of null
     * values in certain <tt>OclAny</tt>-defined operations.  When <tt>true</tt>,
     * the <tt>null.oclIsKindOf(OclType)</tt> and <tt>null.oclIsTypeof(OclType)</tt>
     * operations will return <tt>false</tt> for any OCL type instead of
     * returning <tt>Oclinvalid</tt>.  Similarly, <tt>null.oclAsType(OclType)</tt>
     * will return <tt>null</tt> for any OCL type instead of <tt>OclInvalid</tt>
     * as prescribed by the OCL 2.0 Specification.
     * </p><p>
     * For backward compatibility with the 1.1 release behaviour, the default
     * value of this option is <tt>true</tt>.  For strict conformance to the
     * specification, use <tt>false</tt>.
     * </p>
     * 
     * @since 1.2
     */
    public static final Option<Boolean> LAX_NULL_HANDLING = new BasicOption<Boolean>(
            "lax.null.handling", true); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private EvaluationOptions() {
        super();
    }

    /**
     * Add an option to apply to the specified environment, adapting it as
     * necessary to the {@link Customizable} API.
     * 
     * @param env an evaluation environment on which to set an option
     * @param option the option
     * @param value the option's value
     * 
     * @see Cusotmizable#setOption(Option, Object)
     */
    public static <T> void setOption(EvaluationEnvironment<?, ?, ?, ?, ?> env,
            Option<T> option, T value) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom != null) {
            custom.setOption(option, value);
        }
    }

    /**
     * Obtains the value of the specified option's setting in the the given
     * environment's options map, adapting the environment as necessary to the
     * {@link Customizable} API.  If not already set, return the option's
     * {@linkplain #getDefaultValue() default value}.
     * 
     * @param env an evaluation environment on which to query an option
     * @param option an option to query
     * 
     * @return value of the option
     * 
     * @see Customizable#getValue(Option)
     */
    public static <T> T getValue(EvaluationEnvironment<?, ?, ?, ?, ?> env,
            Option<T> option) {
        
        Customizable custom = OCLUtil.getAdapter(env, Customizable.class);
        if (custom != null) {
            return custom.getValue(option);
        }
        
        return option.getDefaultValue();
    }

}
