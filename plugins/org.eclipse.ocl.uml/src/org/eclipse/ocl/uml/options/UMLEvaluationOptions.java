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
 * $Id: UMLEvaluationOptions.java,v 1.2 2010/05/03 09:32:42 ewillink Exp $
 */

package org.eclipse.ocl.uml.options;

import org.eclipse.ocl.options.BasicOption;
import org.eclipse.ocl.options.Customizable;
import org.eclipse.ocl.options.Option;
import org.eclipse.ocl.uml.UMLEvaluationEnvironment;


/**
 * Options applicable to the {@link UMLEvaluationEnvironment} to
 * {@linkplain Customizable customize} its evaluation behaviour.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public class UMLEvaluationOptions {

    /**
     * <p>
     * Evaluation mode option determining whether we are working with M1
     * instance models ({@link EvaluationMode#INSTANCE_MODEL}, M0 objects
     * ({@link EvaluationMode#RUNTIME_OBJECTS}), or indeterminate, in which
     * last case we guess on-the-fly ({@link EvaluationMode#ADAPTIVE}).
     * </p><p>
     * For compatibility with the 1.1 release behaviour, the default value of
     * this option is {@link EvaluationMode#ADAPTIVE}.
     * </p>
     */
    public static final Option<EvaluationMode> EVALUATION_MODE = new
        BasicOption<EvaluationMode>("uml.evaluation.mode", EvaluationMode.ADAPTIVE); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private UMLEvaluationOptions() {
        super();
    }

}
