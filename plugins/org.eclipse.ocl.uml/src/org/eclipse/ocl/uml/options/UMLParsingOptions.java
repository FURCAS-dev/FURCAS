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
 * $Id: UMLParsingOptions.java,v 1.1 2007/11/06 19:47:01 cdamus Exp $
 */

package org.eclipse.ocl.uml.options;

import org.eclipse.ocl.options.BasicOption;
import org.eclipse.ocl.options.Customizable;
import org.eclipse.ocl.options.Option;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Extension;


/**
 * Options applicable to the {@link UMLEnvironment} to
 * {@linkplain Customizable customize} its parsing behaviour.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public class UMLParsingOptions {

    /**
     * Option determining which UML metaclass to consider as the OCL notion of
     * <tt>Association Class</tt>.  The default is the UML {@link AssociationClass}
     * metaclass for a strict interpretation, as the OCL Specification is not
     * aware of the fact that all UML associations are classifiers.  The
     * other logical choice is {@link Association}, which encompasses all
     * associations (including association-classes proper) and even metaclass
     * {@link Extension}s in profiles.
     * 
     * @since 1.2
     */
    public static final Option<java.lang.Class<? extends Association>> ASSOCIATION_CLASS_TYPE =
            new BasicOption<java.lang.Class<? extends Association>>(
                    "association.class.type", AssociationClass.class); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private UMLParsingOptions() {
        super();
    }

}
