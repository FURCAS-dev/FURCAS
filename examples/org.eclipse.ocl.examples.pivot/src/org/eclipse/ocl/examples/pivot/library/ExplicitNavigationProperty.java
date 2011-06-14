/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: ExplicitNavigationProperty.java,v 1.2 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class ExplicitNavigationProperty extends AbstractCallableImplementation
{
	public static final ExplicitNavigationProperty INSTANCE = new ExplicitNavigationProperty();

	public Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp callExp) {
		ValueFactory valueFactory = evaluationVisitor.getValueFactory();
		TypeManager typeManager = evaluationVisitor.getTypeManager();
		PropertyCallExp propertyCall = (PropertyCallExp) callExp;
		Property property = propertyCall.getReferredProperty();
		Object object = sourceValue.asObject();
		if ((object instanceof ClassifierType) && !(property.getClass_() instanceof ClassifierType)) {
			object = ((ClassifierType)object).getInstanceType();	
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject)object;
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = eClass.getEStructuralFeature(property.getName());
			// A specialized property such as CollectionType.elementType is returned from the specialized type
			// An unspecialized property such as CollectionType.ownedOperation is returned from the unspecialized type
			if ((eObject instanceof Type) && !eObject.eIsSet(eFeature)) {
				TemplateableElement rawType = ((Type)eObject).getUnspecializedElement();
				if (rawType != null) {
					eObject = rawType;
				}
			}
			Object eValue = eObject.eGet(eFeature);
			if (eValue instanceof Enumerator) {
				Enumerator eEnumerator = (Enumerator) eValue;
				EClassifier eEnum = eFeature.getEType();
				org.eclipse.ocl.examples.pivot.Enumeration pivotEnum = typeManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Enumeration.class, eEnum);
				EnumerationLiteral pivotEnumLiteral = PivotUtil.getNamedElement(pivotEnum.getOwnedLiterals(), eEnumerator.getName());
				return valueFactory.createElementValue(pivotEnumLiteral);
			}
			else {
				return valueFactory.valueOf(eValue, eFeature);
			}
		}
		else {
			return evaluationVisitor.throwInvalidEvaluation(null, callExp, sourceValue, EvaluatorMessages.MissingSourceValue);
		}
	}
}