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
 * $Id: PivotUtil.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class PivotUtil
{	
	private static final Logger logger = Logger.getLogger(PivotUtil.class);

	/**
	 * 'Highest' precedence first
	 */
	public static class PrecedenceComparator implements Comparator<Precedence>
	{
		public static final PrecedenceComparator INSTANCE = new PrecedenceComparator();

		public int compare(Precedence p1, Precedence p2) {
			int o1 = p1 != null ? p1.getOrder().intValue() : -1;
			int o2 = p2 != null ? p2.getOrder().intValue() : -1;
			return o1 - o2; // NB least positive is highest precedence
		}
	}

	/**
	 * In TemplateSignature order.
	 */
	public static class TemplateParameterSubstitutionComparator
		implements Comparator<TemplateParameterSubstitution>
	{
		public static Comparator<? super TemplateParameterSubstitution> INSTANCE =
			new TemplateParameterSubstitutionComparator();

		public int compare(TemplateParameterSubstitution o1, TemplateParameterSubstitution o2) {
			TemplateParameter f1 = o1.getFormal();
			TemplateParameter f2 = o2.getFormal();
			int i1 = f1.getSignature().getParameters().indexOf(f1);
			int i2 = f2.getSignature().getParameters().indexOf(f2);
			return i1 - i2;
		}
	}


	public static boolean conformsTo(EStructuralFeature eStructuralFeature, EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	public static <T> T getAdapter(Class<T> adapterClass, List<Adapter> eAdapters) {
		return getAdapter(adapterClass, eAdapters, adapterClass);
	}

	public static <T> T getAdapter(Class<T> adapterClass, Notifier notifier) {
		return getAdapter(adapterClass, notifier, adapterClass);
	}

	public static <T> T getAdapter(Class<T> adapterClass, Notifier notifier, Object adapterType) {
		return getAdapter(adapterClass, notifier.eAdapters(), adapterType);
	}

	public static <T> T getAdapter(Class<T> adapterClass, List<Adapter> eAdapters, Object adapterType) {
		Adapter adapter = EcoreUtil.getAdapter(eAdapters, adapterType);
		if (adapter == null) {
			return null;
		}
		if (!adapterClass.isAssignableFrom(adapter.getClass())) {
			logger.error("Expected " + adapterClass.getName() +
				" rather than " + adapter.getClass().getName());
		}
		@SuppressWarnings("unchecked")
		T castAdapter = (T) adapter;
		return castAdapter;
	}

	public static List<TemplateParameter> getAllTemplateParameters(Collection<TemplateBinding> templateBindings) {
		List<TemplateParameter> list = null;
		for (TemplateBinding templateBinding : templateBindings) {	// FIXME Establish ordering
			TemplateSignature templateSignature = templateBinding.getSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameters();
				if (templateParameters.size() > 0) {
					if (list == null) {
						list = new ArrayList<TemplateParameter>();
					}
					list.addAll(templateParameters);
				}
			}
		}
		return list != null ? list : Collections.<TemplateParameter>emptyList();
	}

	public static List<TemplateParameter> getAllTemplateParameters(TemplateableElement templateableElement) {
		List<TemplateParameter> list = null;
		for (EObject eObject = templateableElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				TemplateSignature ownedTemplateSignature = ((TemplateableElement)eObject).getOwnedTemplateSignature();
				if (ownedTemplateSignature != null) {
					List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
					if (templateParameters.size() > 0) {
						if (list == null) {
							list = new ArrayList<TemplateParameter>();
						}
						list.addAll(templateParameters);
					}
				}
			}
		}
		return list;
	}

	public static Map<TemplateParameter, ParameterableElement> getAllTemplateParameterSubstitutions(Map<TemplateParameter, ParameterableElement> map,
			TemplateableElement templateableElement) {
		for (EObject eObject = templateableElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				for (TemplateBinding templateBinding : ((TemplateableElement) eObject).getTemplateBindings()) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
						if (map == null) {
							map = new HashMap<TemplateParameter, ParameterableElement>();
						}
						map.put(templateParameterSubstitution.getFormal(), templateParameterSubstitution.getActual());
					}
				}
			}
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Class) {
				for (org.eclipse.ocl.examples.pivot.Class superType : ((org.eclipse.ocl.examples.pivot.Class)eObject).getSuperClasses()) {
					map = getAllTemplateParameterSubstitutions(map, superType);
				}		
			}
		}
		return map;
	}

	public static String getBody(OpaqueExpression specification) {
		List<String> bodies = specification.getBodies();
		List<String> languages = specification.getLanguages();
		if ((bodies == null) || (languages == null)) {
			return null;
		}
		int iMax = Math.min(bodies.size(), languages.size());
		for (int i = 0; i < iMax; i++) {
			if (PivotConstants.OCL_LANGUAGE.equalsIgnoreCase(languages.get(i))) {
				return bodies.get(i);
			}
		}
		return null;
	}

	public static <T extends NamedElement> T getNamedElement(Collection<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}

	public static org.eclipse.ocl.examples.pivot.Package getPackage(EObject object) {
		for (EObject eObject = object; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (org.eclipse.ocl.examples.pivot.Package)eObject;
			}
		}
		return null;
	}

	public static <T extends Element> T getPivot(Class<T> pivotClass, Pivotable pivotableElement) {
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			logger.error("Pivot '" + pivotElement.getClass().getName() + "' element is not a '" + pivotClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	public static Operation getReferredOperation(CallExp callExp) {
		Operation operation;
		if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		else {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		return operation;
	}

	public static String getResourceErrorsString(Resource resource, String prefix) {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() <= 0) {
			return null;
		}
		StringBuffer s = new StringBuffer();
		s.append(prefix);
		for (Resource.Diagnostic conversionError : errors) {
			s.append("\n");
			s.append(conversionError.getMessage());
		}
		return s.toString();
	}

	public static List<TemplateParameter> getTemplateParameters(TemplateableElement templateableElement) {
		if (templateableElement != null) {
			TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				return ownedTemplateSignature.getParameters();
			}
		}
		return Collections.emptyList();
	}

	public static List<ParameterableElement> getTemplateParameterables(TemplateableElement templateableElement) {
		if (templateableElement == null) {
			return Collections.emptyList();
		}
		TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
		if (ownedTemplateSignature == null) {
			return Collections.emptyList();
		}
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
		if (templateParameters.size() == 0) {
			return Collections.emptyList();
		}
		if (templateParameters.size() == 1) {
			return Collections.singletonList(templateParameters.get(0).getParameteredElement());
		}
		List<ParameterableElement> results = new ArrayList<ParameterableElement>(templateParameters.size());
		for (TemplateParameter templateParameter : templateParameters) {
			results.add(templateParameter.getParameteredElement());
		}
		return results;
	}

	public static TypeManager getTypeManager(Resource resource) {
		TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(resource, null);
		TypeManager typeManager = adapter.getTypeManager();
		assert typeManager != null;
		return typeManager;
	}

	public static List<Type> getTypeTemplateParameterables(TemplateableElement templateableElement) {
		if (templateableElement == null) {
			return Collections.emptyList();
		}
		TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
		if (ownedTemplateSignature == null) {
			return Collections.emptyList();
		}
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
		if (templateParameters.size() == 0) {
			return Collections.emptyList();
		}
		if (templateParameters.size() == 1) {
			return Collections.singletonList((Type)templateParameters.get(0).getParameteredElement());
		}
		List<Type> results = new ArrayList<Type>(templateParameters.size());
		for (TemplateParameter templateParameter : templateParameters) {
			results.add((Type) templateParameter.getParameteredElement());
		}
		return results;
	}

//	public static org.eclipse.ocl.examples.pivot.Class getTemplateableClass(org.eclipse.ocl.examples.pivot.Class object) {
//		TemplateBinding templateBinding = object.getTemplateBindings().get(0);
//		TemplateSignature templateSignature = templateBinding.getSignature();
//		TemplateableElement unspecializedClass = templateSignature.getTemplate();
//		return (org.eclipse.ocl.examples.pivot.Class)unspecializedClass;
//	}

	public static <T extends TemplateableElement> T getUnspecializedTemplateableElement(T templateableElement) {
		List<TemplateBinding> templateBindings = templateableElement.getTemplateBindings();
		if (templateBindings.size() <= 0) {
			return templateableElement;			
		}
		TemplateBinding templateBinding = templateBindings.get(templateBindings.size()-1);		// FIXME ordering so that most derived is last
		TemplateSignature templateSignature = templateBinding.getSignature();
		@SuppressWarnings("unchecked")
		T unspecializedTemplateableElement = (T) templateSignature.getTemplate();
		return unspecializedTemplateableElement;
	}

	public static <T> void refreshList(List<? super T> elements, List<? extends T> newElements) {
		int newMax = newElements.size();
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			T newElement = newElements.get(i);
			int oldMax = elements.size();
			boolean reused = false;;
			for (int j = i; j < oldMax; j++) {
				Object oldElement = elements.get(j);
				if (oldElement == newElement) {
					if (j != i) {
						elements.remove(j);
						elements.add(i, newElement);
					}
					reused = true;
					break;
				}
			}
			if (!reused) {
				if (i < oldMax) {
					elements.add(i, newElement);
				}
				else {
					elements.add(newElement);
				}
			}
			assert newElements.get(i) == elements.get(i);
		}
		for (int k = elements.size(); k > newMax; ) {
			elements.remove(--k);
		}
		assert newElements.size() == elements.size();
	}

	public static <T> void refreshSet(List<? super T> oldElements, Collection<? extends T> newElements) {
		for (int i = oldElements.size(); i-- > 0;) {	// Remove any oldElements not in newElements
			Object oldElement = oldElements.get(i);
			if (!newElements.contains(oldElement)) {
				oldElements.remove(i);
			}
		}
		for (T newElement : newElements) {				// Add any newElements not in oldElements
			if (!oldElements.contains(newElement)) {
				oldElements.add(newElement);
			}
		}
	}

	public static ExpressionInOcl resolveSpecification(TypeManager typeManager, NamedElement specificationContext, String expression) {
		InputStream inputStream = new ByteArrayInputStream(expression.getBytes());
		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
			URI uri = URI.createURI("test2.essentialocl");
			Resource resource = resourceSet.createResource(uri);
			TypeManagerResourceAdapter.getAdapter(resource, typeManager);
			if (resource instanceof EvaluationContext) {
				((EvaluationContext)resource).setSpecificationContext(specificationContext);
			}
			resource.load(inputStream, null);
//				checkResourceErrors("Errors in '" + expression + "'", resource);
			List<EObject> contents = resource.getContents();
			int size = contents.size();
			if (size == 0) {
				return null;
			}
			if (size > 1) {
//					logger.warn("Extra returns ignored");
			}
			EObject csObject = contents.get(0);
			if (csObject instanceof Pivotable) {
				Element pivotElement = ((Pivotable)csObject).getPivot();
				if (pivotElement instanceof ExpressionInOcl) {
					return (ExpressionInOcl) pivotElement;
				}
			}
//				logger.warn("Non-expression ignored");
		} catch (IOException e) {
//				throw new ParserException("Failed to load expression", e);
			ExpressionInOcl specification = PivotFactory.eINSTANCE.createExpressionInOcl();
			OclExpression invalidValueBody = typeManager.createInvalidExpression(specificationContext, "Failed to load expression", e);
			specification.setBodyExpression(invalidValueBody);
			return specification;
		}			
		return null;
	}

	public static <T extends MonikeredElement> List<T> sortByMoniker(List<T> list) {
		Collections.sort(list, new Comparator<MonikeredElement>()
		{
			public int compare(MonikeredElement o1, MonikeredElement o2) {
				return o1.getMoniker().compareTo(o2.getMoniker());
			}
		});
		return list;
	}
}
