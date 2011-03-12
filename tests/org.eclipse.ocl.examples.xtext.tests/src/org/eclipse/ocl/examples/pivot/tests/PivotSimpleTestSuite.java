/**
 * <copyright>
 * 
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotSimpleTestSuite.java,v 1.1 2011/03/12 13:22:51 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

/**
 * Test suite with a simple model.
 */
@SuppressWarnings("nls")
public abstract class PivotSimpleTestSuite extends PivotTestSuite
{
	org.eclipse.ocl.examples.pivot.Package pkg1;
	org.eclipse.ocl.examples.pivot.Package pkg2;
	org.eclipse.ocl.examples.pivot.Package pkg3;
	org.eclipse.ocl.examples.pivot.Package pkg4;
	org.eclipse.ocl.examples.pivot.Package pkg5;
	org.eclipse.ocl.examples.pivot.Package jim;
	org.eclipse.ocl.examples.pivot.Package bob;
	org.eclipse.ocl.examples.pivot.Package george;

    @Override
    protected void setUp() {
        super.setUp();
		typeManager.addGlobalNamespace("pivot", typeManager.getPivotPackage());

        // need a metamodel that has a reflexive EReference.
        // Ecore will do nicely. Create the following structure:
        // pkg1
        //  pkg2
        //   jim
        //  bob
        //  pkg3
        //   pkg4
        //   pkg5
        //    george

        pkg1 = typeManager.createPackage("pkg1");
        pkg2 = createNestedPackage(pkg1, "pkg2");
        jim = createNestedPackage(pkg2, "jim");
        bob = createNestedPackage(pkg1, "bob");
        pkg3 = createNestedPackage(pkg1, "pkg3");
        pkg4 = createNestedPackage(pkg3, "pkg4");
        pkg5 = createNestedPackage(pkg3, "pkg5");
        george = createNestedPackage(pkg5, "george");
    }
}
