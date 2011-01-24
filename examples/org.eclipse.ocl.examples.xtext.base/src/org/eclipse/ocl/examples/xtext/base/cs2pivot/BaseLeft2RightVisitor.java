/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseLeft2RightVisitor.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BaseLeft2RightVisitor extends AbstractExtendingBaseCSVisitor<MonikeredElement, CS2PivotConversion>
{
	private static final Logger logger = Logger.getLogger(BaseLeft2RightVisitor.class);

	public BaseLeft2RightVisitor(CS2PivotConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	@Override
	public MonikeredElement visitAnnotationCS(AnnotationCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitClassifierCS(ClassifierCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitConstraintCS(ConstraintCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitDetailCS(DetailCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitOperationCS(OperationCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitParameterCS(ParameterCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitStructuralFeatureCS(StructuralFeatureCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTemplateBindingCS(TemplateBindingCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTemplateParameterCS(TemplateParameterCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTemplateSignatureCS(TemplateSignatureCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTuplePartCS(TuplePartCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTupleTypeCS(TupleTypeCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitTypeRefCS(TypeRefCS object) {
		return null;
	}

	public MonikeredElement visiting(VisitableCS visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}
}