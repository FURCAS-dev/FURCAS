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
 * $Id: UtilitiesTest.java,v 1.1 2007/01/25 18:41:56 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.ocl.uml.util.OCLUMLUtil;


/**
 * Tests the {@link OCLUMLUtil} class.
 *
 * @author Christian W. Damus (cdamus)
 */
public class UtilitiesTest extends AbstractTestSuite {

	public UtilitiesTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(UtilitiesTest.class,
			"OCLUMLUtil Utility Class Tests"); //$NON-NLS-1$
	}

    /**
     * Tests the <code>getMetaclass(Element)</code> method.
     */
    public void test_getMetaclass() {
        // no resource set ==> no metaclass
        assertNull(OCLUMLUtil.getMetaclass(umlf.createActivity()));
        
        assertSame(getMetaclass("Class"), //$NON-NLS-1$
            OCLUMLUtil.getMetaclass(fruit));
        assertSame(getMetaclass("AssociationClass"), //$NON-NLS-1$
            OCLUMLUtil.getMetaclass(stem));
        assertSame(getMetaclass("Property"), //$NON-NLS-1$
            OCLUMLUtil.getMetaclass(apple_label));
        assertSame(getMetaclass("Operation"), //$NON-NLS-1$
            OCLUMLUtil.getMetaclass(fruit_preferredColor));
        assertSame(getMetaclass("EnumerationLiteral"), //$NON-NLS-1$
            OCLUMLUtil.getMetaclass(color_black));
        assertSame(getMetaclass("Package"), //$NON-NLS-1$
            OCLUMLUtil.getMetaclass(fruitPackage));
    }
}
