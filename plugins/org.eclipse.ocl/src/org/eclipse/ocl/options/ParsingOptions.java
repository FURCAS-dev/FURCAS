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
 * $Id: ParsingOptions.java,v 1.1 2007/11/06 19:47:11 cdamus Exp $
 */

package org.eclipse.ocl.options;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.util.OCLUtil;



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
