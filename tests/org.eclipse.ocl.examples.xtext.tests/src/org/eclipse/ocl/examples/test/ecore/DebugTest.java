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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DebugTest.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.ecore;

import org.eclipse.ocl.examples.test.generic.GenericDebugTest;

/**
 * The JUnit4 GUI does not support re-running individual tests in isolation.
 * 
 * This dummy test is therefore a debugging placeHolder for re-use while debugging.
 */
@SuppressWarnings("nls")
public class DebugTest extends GenericDebugTest {

	@Override
	public PivotTestReflection getStaticReflection() {
		return new PivotTestReflection(typeManager);
	}
	
	public org.eclipse.ocl.examples.pivot.Package pkg1;

    @Override
    protected void setUp() {
        super.setUp();
        pkg1 = reflection.createPackage("pkg1");
        helper.setContext(getMetaclass(denormalize("%Package")));
    }

	/**
	 * Tests that dot notation can be used successively to navigate multiple
	 * collection-type references.
	 */
	public void testDebug() {
//		assertQueryFalse(null, "Sequence{4, 5, 'test'} = OrderedSet{4, 5, 'test', 5}");
/*		helper.setContext(EcorePackage.Literals.EPACKAGE);

		try {
			OCLExpression<EClassifier> expr = helper
				.createQuery("self.eClassifiers->union(self.eSubpackages.eClassifiers->asSet())->asSet()");

			assertEquals(new java.util.HashSet<EClassifier>(
				ExpressionsPackage.eINSTANCE.getEClassifiers()), ocl.evaluate(
				ExpressionsPackage.eINSTANCE, expr));
		} catch (Exception exc) {
			fail("Failed to parse or evaluate: " + exc.getLocalizedMessage());
		} */
	}
}
