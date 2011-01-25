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
 * $Id: Pivot2EcoreTypeRefVisitor.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Pivot2EcoreTypeRefVisitor
	extends AbstractExtendingVisitor<EObject, Pivot2Ecore>
{
	public static final Logger logger = Logger.getLogger(Pivot2EcoreTypeRefVisitor.class);

	public Pivot2EcoreTypeRefVisitor(Pivot2Ecore context) {
		super(context);
	}

	public EGenericType resolveEGenericType(Type type) {
		EObject eType = safeVisit(type);
		if (eType instanceof EGenericType) {
			return (EGenericType) eType;
		}
		else {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setEClassifier((EClassifier) eType);
			return eGenericType;
		}
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	public EClassifier visiting(Visitable visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

	@Override
	public EClassifier visitPrimitiveType(PrimitiveType pivotType) {
		if (pivotType == context.getTypeManager().getBooleanType()) {
			return EcorePackage.Literals.EBOOLEAN;
		}
		else if (pivotType == context.getTypeManager().getIntegerType()) {
			return EcorePackage.Literals.EBIG_INTEGER;
		}
		else if (pivotType == context.getTypeManager().getRealType()) {
			return EcorePackage.Literals.EBIG_DECIMAL;
		}
		else if (pivotType == context.getTypeManager().getStringType()) {
			return EcorePackage.Literals.ESTRING;
		}
		else if (pivotType == context.getTypeManager().getUnlimitedNaturalType()) {
			return EcorePackage.Literals.EBIG_INTEGER;
		}
		else {
			logger.error("Unsupported primitive type '" + pivotType + "' in pass2");
			return null;
		}
	}

	@Override
	public EObject visitTemplateBinding(TemplateBinding object) {
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		return eGenericType;
	}

	@Override
	public EObject visitTemplateParameterSubstitution(TemplateParameterSubstitution pivotTemplateParameterSubstitution) {
		EObject actualType = safeVisit(pivotTemplateParameterSubstitution.getActual());
		if (actualType instanceof EGenericType) {
			return actualType;
		}
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setEClassifier((EClassifier) actualType);
		return eGenericType;
	}

	@Override
	public EObject visitType(Type pivotType) {
		TemplateParameter templateParameter = pivotType.getTemplateParameter();
		if (templateParameter != null) {
			ETypeParameter eTypeParameter = context.getCreated(ETypeParameter.class, templateParameter);
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setETypeParameter(eTypeParameter);
			return eGenericType;
		}
		List<TemplateBinding> templateBindings = pivotType.getTemplateBindings();
		if (templateBindings.size() == 0) {
			EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
			if (eClassifier != null) {
				return eClassifier;
			}
			return ((TypeImpl)pivotType).getTarget();
		}
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		EObject rawType = safeVisit(PivotUtil.getUnspecializedTemplateableElement(pivotType));
		eGenericType.setEClassifier((EClassifier) rawType);
		// FIXME signature ordering, multiple bindings
		safeVisitAll(eGenericType.getETypeArguments(), templateBindings.get(0).getParameterSubstitutions());
		return eGenericType;
	}	
}