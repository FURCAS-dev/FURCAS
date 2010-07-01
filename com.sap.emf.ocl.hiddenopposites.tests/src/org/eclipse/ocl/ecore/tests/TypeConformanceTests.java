/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 Stefan Schulze, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Stefan Schulze - Initial API and implementation
 *   Zeligsoft - Bug 245619
 * 
 * </copyright>
 * 
 * $Id: TypeConformanceTests.java,v 1.2 2009/10/07 20:39:29 ewillink Exp $
 */
package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

/**
 * Tests consistency of the conversion of user-defined types to OCL primitive
 * types in a variety of contexts in which they were formerly missed.
 * 
 * @author Stefan Schulze
 */
@SuppressWarnings("nls")
public class TypeConformanceTests
		extends AbstractTestSuite {

	EDataType dt;
	EClass cl;
	EOperation op3;
	EPackage p;

	@Override
	protected void setUp() {
		super.setUp();
		EcoreFactory f = EcoreFactory.eINSTANCE;
		p = f.createEPackage();
		dt = f.createEDataType();
		dt.setName("OwnInteger");
		dt.setInstanceClassName("java.lang.Integer");
		p.getEClassifiers().add(dt);

		EEnum e = f.createEEnum();
		e.setName("TestEnum");
		EEnumLiteral lit1 = f.createEEnumLiteral();
		lit1.setName("EnumLiteral");
		e.getELiterals().add(lit1);
		p.getEClassifiers().add(e);

		cl = f.createEClass();
		cl.setName("ClassName");
		p.getEClassifiers().add(cl);
		EOperation op1 = f.createEOperation();
		cl.getEOperations().add(op1);
		op1.setName("fooOwnInteger");
		EParameter param = f.createEParameter();
		param.setName("p");
		param.setEType(dt);
		op1.getEParameters().add(param);

		EOperation op2 = f.createEOperation();
		cl.getEOperations().add(op2);
		op2.setName("fooInteger");
		param = f.createEParameter();
		param.setName("p");
		param.setEType(ocl.getEnvironment().getOCLStandardLibrary()
			.getInteger());
		op2.getEParameters().add(param);

		op3 = f.createEOperation();
		cl.getEOperations().add(op3);
		op3.setName("enumMethod");
		param = f.createEParameter();
		param.setName("p");
		param.setEType(e);
		op3.getEParameters().add(param);

		helper.setContext(cl);
	}

	public void testLetVariableTypeConformance()
			throws Exception {
		OCLExpression<EClassifier> expr = helper
			.createQuery("let i:OwnInteger=5 in i");
		Object result = ocl.evaluate(null, expr);
		assertEquals(5, result);
	}

	public void testIterateVariableTypeConformance()
			throws Exception {
		OCLExpression<EClassifier> expr = helper
			.createQuery("Set{1,2}->iterate(i:Integer; acc:OwnInteger=5 | acc)");
		Object result = ocl.evaluate(null, expr);
		assertEquals(5, result);
	}

	public void testOperationMatchOwnerTypeConformance()
			throws Exception {
		defineVariable("i", dt, 1);
		helper.createQuery("i+2");
		helper.createQuery("2+2");
	}

	public void testOperationMatchParameterTypeConformance1()
			throws Exception {
		defineVariable("i", dt, 1);
		helper.createQuery("2+2");
		helper.createQuery("2+i");
	}

	public void testOperationMatchParameterTypeConformance2()
			throws Exception {
		defineVariable("i", dt, 1);
		helper.setContext(cl);
		helper.createQuery("self.fooOwnInteger(2)");
		helper.createQuery("self.fooInteger(i)");
	}

	public void testEnumMethod()
			throws Exception {
		helper.setContext(cl);
		final OCLExpression<EClassifier> query = helper
			.createQuery("self.enumMethod(TestEnum::EnumLiteral)");
		assertSame(op3, ((OperationCallExp) query).getReferredOperation());
		EObject eo = p.getEFactoryInstance().create(cl);
		helper.getOCL().evaluate(eo, query);
	}

	private void defineVariable(String name, EClassifier type, Object value) {
		Variable<EClassifier, EParameter> contextVar = ExpressionsFactory.eINSTANCE
			.createVariable();
		contextVar.setName(name);
		contextVar.setType(type);
		ocl.getEnvironment().addElement(name, contextVar, true);
		ocl.getEvaluationEnvironment().add(name, value);
	}
}
