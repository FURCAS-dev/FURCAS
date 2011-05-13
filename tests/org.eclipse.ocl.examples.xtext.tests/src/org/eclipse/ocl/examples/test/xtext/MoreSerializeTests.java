/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: MoreSerializeTests.java,v 1.1 2011/05/13 19:16:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class MoreSerializeTests extends SerializeTests
{	
// FIXME fails due to Bug 286558
	public void testEcoreSerialize() throws Exception {
		doSerialize("Ecore");
	}

	//	public void testMarkupSerialize() throws Exception {
//		doSerialize("Markup");
//	}

//	public void test_model_uml_Serialize() throws Exception {
//		doSerializeUML("model");
//	}

	public void test_Fruit_uml_Serialize() throws Exception {
		doSerializeUML("Fruit");
	}

	public void testOCLSerialize() throws Exception {
		doSerialize("OCL");
	}

	public void testOCLEcoreSerialize() throws Exception {
		doSerialize("OCLEcore");
	}

	public void testXMLTypeSerialize() throws Exception {
		doSerialize("XMLType");
	}

	public void testOCLTestSerialize() throws Exception {
		doSerialize("OCLTest");
	}	
}
