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
 * $Id: Customizable.java,v 1.1 2007/11/06 19:47:11 cdamus Exp $
 */

package org.eclipse.ocl.options;

import java.util.Collection;
import java.util.Map;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.util.Adaptable;


/**
 * An {@linkplain Adaptable optional adapter interface} for entities whose
 * behaviour can be customized by clients by the application of {@link Option}s.
 * The primary customizable entities are parsing {@link Environment}s and
 * {@link EvaluationEnvironment}s.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public interface Customizable {
    /**
     * Obtains a copy of my map of options.
     * Options not explicitly set in an environment are inherited from the
     * parent environment, if any, otherwise they are at their
     * {@linkplain Option#getDefaultValue() default values}.
     * 
     * @return the map of options
     */
    Map<Option<?>, Object> getOptions();
    
    /**
     * Obtains the value of the specified option's setting in the my
     * options map.
     * Options not explicitly set in an environment are inherited from the
     * parent environment, if any, otherwise they are at their
     * {@linkplain Option#getDefaultValue() default values}.
     * 
     * @param option the option to query
     * 
     * @return value of the option
     */
    <T> T getValue(Option<T> option);
    
    /**
     * Queries whether the specified boolean-valued option is enabled.
     * This method essentially just puts a nice "is" name on boolean options.
     * Options not explicitly set in an environment are inherited from the
     * parent environment, if any, otherwise they are at their
     * {@linkplain Option#getDefaultValue() default values}.
     * 
     * @param option an option
     * 
     * @return whether the option is enabled
     */
    boolean isEnabled(Option<Boolean> option);
    
    /**
     * Add an option to apply to my behaviour.
     * 
     * @param option the option
     * @param value the option's value
     */
    <T> void setOption(Option<T> option, T value);
    
    /**
     * Adds options to apply to my behaviour.
     * 
     * @param options the options
     */
    <T> void putOptions(Map<? extends Option<T>, ? extends T> options);
    
    /**
     * Removes the specified option.
     * 
     * @param option the option to remove
     * 
     * @return the former value of the option
     */
    <T> T removeOption(Option<T> option);
    
    /**
     * Removes the specified options.
     * 
     * @param options the options to remove
     * 
     * @return the former values of the options
     */
    <T> Map<Option<T>, T> removeOptions(Collection<Option<T>> options);
    
    /**
     * Clears all options.
     * 
     * @return the former values of the options
     */
    Map<Option<?>, Object> clearOptions();

}
