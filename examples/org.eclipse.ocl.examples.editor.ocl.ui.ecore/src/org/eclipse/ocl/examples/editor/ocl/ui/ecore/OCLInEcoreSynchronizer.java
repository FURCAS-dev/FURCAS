/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: OCLInEcoreSynchronizer.java,v 1.4 2010/03/22 01:23:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lpg.runtime.IToken;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.common.utils.TracingAdapter;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.BasicEnvironment2;
import org.eclipse.ocl.utilities.UMLReflection;

public abstract class OCLInEcoreSynchronizer extends TracingAdapter
{
	public static String getSourceText(BasicEnvironment environment, Object astNode) {
		CSTNode astMapping = environment.getASTMapping(astNode);
		IToken startToken = astMapping.getStartToken();
		IToken prevToken = startToken.getIPrsStream().getIToken(startToken.getTokenIndex()-1);
		IToken endToken = astMapping.getEndToken();
		IToken[] followingAdjuncts = endToken.getFollowingAdjuncts();
		if ((followingAdjuncts != null) && (followingAdjuncts.length > 0)) {
			endToken = followingAdjuncts[followingAdjuncts.length-1];
		}
		return startToken.getILexStream().toString(prevToken.getEndOffset()+1, endToken.getEndOffset());
	}
	
	private static final String ECORE_URI = org.eclipse.emf.ecore.EcorePackage.eNS_URI;
	private static final String OCL_URI = ECORE_URI + "/OCL";
	private static final String CONSTRAINTS_KEY = "constraints";
	private static final String BODY_KEY = "body";
	private static final String DERIVATION_KEY = "derivation";
	private static final String INITIAL_KEY = "initial";
	private static final String POSTCONDITION_KEY = "postcondition";
	private static final String PRECONDITION_KEY = "precondition";
	
	private static final UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> umlReflection =
		EcoreEnvironmentFactory.INSTANCE.createEnvironment().getUMLReflection();

	public static class Detail
	{
		protected final EAnnotation annotation;
		protected final String key;
		
		public Detail(EAnnotation annotation, String key) {
			this.annotation = annotation;
			this.key = key;
		}

		public EAnnotation getAnnotation() {
			return annotation;
		}

		public EModelElement getContainer() {
			return (EModelElement) annotation.eContainer();
		}

		public String getKey() {			
			return key;
		}
		
		@Override
		public String toString() {
			return key + " => ";
		}
	}
	
	public static class Exporter
	{
		protected void addConstraintName(EModelElement constrainedElement, String constraintName) {
			Set<String> constraintsNameSet = getConstraintNames(constrainedElement);
			constraintsNameSet.add(constraintName);
			setConstraintNames(constrainedElement, constraintsNameSet);
		}
		
		public void exportConstraint(BasicEnvironment2 environment, EModelElement constrainedElement, Constraint constraint) {
			EList<EModelElement> constrainedElements = constraint.getConstrainedElements();
			if (constrainedElements.isEmpty()) {
				return;
			}
//			EModelElement constrainedElement = constrainedElements.get(0);
			ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
			if (specification == null) {
				return;
			}
			org.eclipse.ocl.expressions.OCLExpression<?> bodyExpression = specification.getBodyExpression();
			if (bodyExpression == null) {
				return;
			}
			String text = getSourceText(environment, bodyExpression);
			EOperation ecoreInvariant;
			if ((constrainedElement instanceof EClass)
			 && ((ecoreInvariant = EcoreUtils.getEcoreInvariant((EClass)constrainedElement, constraint.getName())) != null)) {
				setEAnnotation(environment, constraint, ecoreInvariant, OCL_URI, BODY_KEY, text);
			}
			else if (constrainedElement instanceof EClassifier) {
				addConstraintName(constrainedElement, constraint.getName());
				setEAnnotation(environment, constraint, constrainedElement, OCL_URI, constraint.getName(), text);
			}
			else if (constrainedElement instanceof EOperation) {
				setEAnnotation(environment, constraint, constrainedElement, OCL_URI, BODY_KEY, text);
			}
			else if (constrainedElement instanceof EStructuralFeature) {
				setEAnnotation(environment, constraint, constrainedElement, OCL_URI, DERIVATION_KEY, text);
			}
		}

		protected Set<String> getConstraintNames(EModelElement constrainedElement) {
			EAnnotation ecoreAnnotation = getEAnnotation(constrainedElement, ECORE_URI);
			String oldConstraintsDetails = ecoreAnnotation.getDetails().get(CONSTRAINTS_KEY);
			Set<String> constraintsNameSet = new HashSet<String>();
			if (oldConstraintsDetails != null) {
				String[] constraintsNameArray = oldConstraintsDetails.split(" ");  //$NON-NLS-1$
				for (String constraintsName : constraintsNameArray) {
					constraintsNameSet.add(constraintsName);
				}
			}
			return constraintsNameSet;
		}

		protected EAnnotation getEAnnotation(EModelElement element, String source) {
			EAnnotation ecoreAnnotation = element.getEAnnotation(source);
			if (ecoreAnnotation == null) {
				ecoreAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				ecoreAnnotation.setSource(source);
				element.getEAnnotations().add(ecoreAnnotation);
			}
			return ecoreAnnotation;
		}

		protected void removeConstraintName(EModelElement constrainedElement, String constraintName) {
			Set<String> constraintsNameSet = getConstraintNames(constrainedElement);
			constraintsNameSet.remove(constraintName);
			setConstraintNames(constrainedElement, constraintsNameSet);
		}

		protected void setEAnnotation(BasicEnvironment2 environment, Constraint constraint, EModelElement constrainedElement, String source, String key, String newValue) {
		    EAnnotation eAnnotation = getEAnnotation(constrainedElement, source);
		    EMap<String, String> details = eAnnotation.getDetails();
			String oldValue = details.get(key);
		    if (!ClassUtils.equals(oldValue, newValue)) {
		    	details.put(key, newValue);
		    }
	    	int indexOfKey = details.indexOfKey(key);
		    if (indexOfKey >= 0) { 
		    	Entry<String, String> entry = details.get(indexOfKey);
		    	CSTNode cstConstraint = environment.getASTMapping(constraint);
		    	environment.initASTMapping(entry, cstConstraint, null);
		    }	    
		}

		protected void setConstraintNames(EModelElement constrainedElement, Set<String> constraintsNameSet) {
			EAnnotation ecoreAnnotation = getEAnnotation(constrainedElement, ECORE_URI);
			String oldConstraintsDetails = ecoreAnnotation.getDetails().get(CONSTRAINTS_KEY);
			List<String> constraintNameList = new ArrayList<String>(constraintsNameSet);
			Collections.sort(constraintNameList);
			String newConstraintDetails = StringUtils.splice(constraintNameList, " "); //$NON-NLS-1$
			if (!ClassUtils.equals(oldConstraintsDetails, newConstraintDetails)) {
				ecoreAnnotation.getDetails().put(CONSTRAINTS_KEY, newConstraintDetails);
			}
		}
	}

	/**
	 * Importer creates a textual OCL document from the embedded OCL in a collection of resources.
	 * <p>
	 * The text form is available with getText()
	 * <p>
	 * A contents mapping for use during synchronization with getContents().
	 */
	public static class Importer
	{
		private StringBuffer s = new StringBuffer();
		
		/**
		 * The contents identifies every detail of every model element that contributed OCL content that needs
		 * synchronization on an export back to the ResourceSet.
		 */
		private Map<EObject, List<Detail>> contents = new HashMap<EObject, List<Detail>>();

		public Importer(Collection<? extends Resource> resources) {
			for (Resource resource : resources) {
				importEObjectList(resource.getContents());
			}
		}

		protected void appendContent(EObject eContainer, EAnnotation eAnnotation, String detailKey) {
			List<Detail> details = contents.get(eContainer);
			if (details == null) {
				details = new ArrayList<Detail>();
				contents.put(eContainer, details);
			}
			details.add(new Detail(eAnnotation, detailKey));
		}
		
		protected void appendName(ENamedElement eNamedElement) {
			appendText(eNamedElement.getName());
		}

		protected void appendQualifiedName(EOperation eOperation) {
			appendName(eOperation.getEContainingClass());
			appendText("::");
			appendName(eOperation);
		}

		protected void appendQualifiedName(EStructuralFeature eStructuralFeature) {
			appendName(eStructuralFeature.getEContainingClass());
			appendText("::");
			appendName(eStructuralFeature);
		}
		
		protected void appendText(String text) {
			s.append(text);
		}

		protected void appendTypeName(ETypedElement eTypedElement) {
			Object oclType = umlReflection.getOCLType(eTypedElement);
			appendName((ENamedElement) oclType);
		}

		public Map<EObject, List<Detail>> getContents() {
			return contents;
		}

		public String getText() {
			return s.toString();
		}
		
		protected void importEClassifier(EClassifier eClassifier) {
			String constraintsString = EcoreUtil.getAnnotation(eClassifier, ECORE_URI, CONSTRAINTS_KEY);
			if (constraintsString != null) {
				EAnnotation eAnnotation = eClassifier.getEAnnotation(OCL_URI);
				if (eAnnotation == null) {
					return;
				}
				EMap<String, String> details = eAnnotation.getDetails();
				for (String constraintName : constraintsString.split(" ")) {
					String invariant = details.get(constraintName);
					if (invariant != null) {
						appendContent(eClassifier, eAnnotation, constraintName);
						appendText("\ncontext ");
						appendName(eClassifier);
						appendText("\ninv ");
						appendText(constraintName);
						appendText(":");
						appendText(invariant);
						appendText("\n");			
					}
				}
			}
			if (eClassifier instanceof EClass) {
				for (EOperation eOperation : ((EClass)eClassifier).getEOperations()) {
					if (EcoreUtil.isInvariant(eOperation)) {
						EAnnotation eAnnotation = eOperation.getEAnnotation(OCL_URI);
						if (eAnnotation != null) {
							EMap<String, String> details = eAnnotation.getDetails();
							String invariant = details.get(BODY_KEY);
							if (invariant != null) {
								appendContent(eClassifier, eAnnotation, eOperation.getName());
								appendText("\ncontext ");
								appendName(eClassifier);
								appendText("\ninv ");
								appendName(eOperation);
								appendText(":");
								appendText(invariant);
								appendText("\n");			
							}
						}
					}
				}
				for (EStructuralFeature eStructuralFeature : ((EClass)eClassifier).getEStructuralFeatures()) {
					importEStructuralFeature(eStructuralFeature);
				}
				for (EOperation eOperation : ((EClass)eClassifier).getEOperations()) {
					if (!EcoreUtil.isInvariant(eOperation)) {
						importEOperation(eOperation);
					}
				}
			}
		}

		protected void importEObjectList(EList<? extends EObject> contents) {
			for (EObject eObject : contents) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage)eObject;
					importEPackage(ePackage);					
					EList<EPackage> eSubpackages = ePackage.getESubpackages();
					if (!eSubpackages.isEmpty()) {
						appendText("\n");
					}
					importEObjectList(eSubpackages);
				}
			}
		}

		protected void importEOperation(EOperation eOperation) {
			EAnnotation eAnnotation = eOperation.getEAnnotation(OCL_URI);
			if (eAnnotation == null) {
				return;
			}
			EMap<String, String> details = eAnnotation.getDetails();
			String pre = details.get(PRECONDITION_KEY);
			String body = details.get(BODY_KEY);
			String post = details.get(POSTCONDITION_KEY);
			if ((pre != null) || (body != null) || (post != null)) {
				appendText("\ncontext ");
				appendQualifiedName(eOperation);
				appendText("(");
				String prefix = "";
				for (EParameter eParameter : eOperation.getEParameters()) {
					appendText(prefix);
					appendName(eParameter);
					appendText(" : ");
					appendTypeName(eParameter);
					prefix = ", ";
				}
				appendText(") : ");
				appendTypeName(eOperation);
				appendText("\n");
			}
			if (pre != null) {
				appendContent(eOperation, eAnnotation, PRECONDITION_KEY);
				appendText("pre:");
				appendText(pre);
				appendText("\n");			
			}
			if (body != null) {
				appendContent(eOperation, eAnnotation, BODY_KEY);
				appendText("body:");
				appendText(body);
				appendText("\n");			
			}
			if (post != null) {
				appendContent(eOperation, eAnnotation, POSTCONDITION_KEY);
				appendText("post:");
				appendText(post);
				appendText("\n");			
			}		
		}

		protected void importEPackage(EPackage ePackage) {
			List<String> delegates = new ArrayList<String>();
			delegates.addAll(EcoreUtil.getInvocationDelegates(ePackage));
			delegates.addAll(EcoreUtil.getSettingDelegates(ePackage));
			delegates.addAll(EcoreUtil.getValidationDelegates(ePackage));
			if (!delegates.contains(OCL_URI)) {
				return;
			}
			appendText("package ");
			appendName(ePackage);
			ResourceSet resourceSet = ePackage.eResource().getResourceSet();
			resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
			appendText("\n");
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				importEClassifier(eClassifier);
			}
			appendText("\nendpackage\n");			
		}

		protected void importEStructuralFeature(EStructuralFeature eStructuralFeature) {
			EAnnotation eAnnotation = eStructuralFeature.getEAnnotation(OCL_URI);
			if (eAnnotation == null) {
				return;
			}
			EMap<String, String> details = eAnnotation.getDetails();
			String derivation = details.get(DERIVATION_KEY);
			String initial = details.get(INITIAL_KEY);
			if ((derivation != null) || (initial != null)) {
				appendText("\ncontext ");
				appendQualifiedName(eStructuralFeature);
				appendText(" : ");
				appendTypeName(eStructuralFeature);
				appendText("\n");			
			}
			if (initial != null) {
				appendContent(eStructuralFeature, eAnnotation, INITIAL_KEY);
				appendText("init:");
				appendText(initial);
				appendText("\n");			
			}
			if (derivation != null) {
				appendContent(eStructuralFeature, eAnnotation, DERIVATION_KEY);
				appendText("derive:");
				appendText(derivation);
				appendText("\n");			
			}
		}
	}
	
	public class ResourceWatcher extends TracingAdapter
	{
		@Override
		protected void handleNotification(Notification notification) {
		    int featureID = notification.getFeatureID(Resource.class);
		    if (featureID == Resource.RESOURCE__IS_MODIFIED) {
				if (notification.getEventType() == Notification.SET) {
					importFromResources();
				}
		    }
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ResourceWatcher.class;
		}		
	}

	public static OCLInEcoreSynchronizer getAdapter(ResourceSet resourceSet) {
		return EcoreUtils.getAdapter(resourceSet.eAdapters(), OCLInEcoreSynchronizer.class);
	}

	private Exporter exporter = null;		// Non-null while export in progress
	private Importer importer = null;		// Non-null while import in progress	
	/**
	 * The contents identifies every detail of every model element that contributed OCL content that needs
	 * synchronization on an export back to the ResourceSet.
	 */
	private Map<EObject, List<Detail>> contents = new HashMap<EObject, List<Detail>>();

	protected void addWatcher(Object object) {
		if (object instanceof Resource) {
			Resource resource = (Resource)object;
			resource.setTrackingModification(true);
			ResourceWatcher watcher = EcoreUtils.getAdapter(resource, ResourceWatcher.class);
			if (watcher == null) {
				resource.eAdapters().add(new ResourceWatcher());
			}
		}
	}

	public void exportConstraintsToResource(BasicEnvironment2 environment, List<Constraint> constraints) {
		try {
			exporter = new Exporter();
			Set<Detail> residualDetails = new HashSet<Detail>();
			for (List<Detail> details : contents.values()) {
				residualDetails.addAll(details);
			}
			//
			//	First export the constraints that align with imported details.
			//
			List<Constraint> residualConstraints = new ArrayList<Constraint>();
			for (Constraint constraint : constraints) {
				EList<EModelElement> constrainedElements = constraint.getConstrainedElements();
				if (!constrainedElements.isEmpty()) {
					EModelElement constrainedElement = constrainedElements.get(0);
					String key = constrainedElement instanceof EClassifier ? constraint.getName() :  constraint.getStereotype();
					List<Detail> details = contents.get(constrainedElement);
					if (details != null) {
						for (Detail detail : details){
							if (key.equals(detail.getKey())) {
								residualDetails.remove(detail);
								exporter.exportConstraint(environment, detail.getContainer(), constraint);
								constrainedElement = null;
								break;
							}
						}
					}						
					if (constrainedElement != null) {
						residualConstraints.add(constraint);
					}
				}
			}
			//
			//	Now export the residual constraints by aligning the unmatched details in
			//	sequential order element-wise.
			//
			for (Constraint constraint : residualConstraints) {
				EList<EModelElement> constrainedElements = constraint.getConstrainedElements();
				EModelElement constrainedElement = constrainedElements.get(0);
				List<Detail> details = contents.get(constrainedElement);
				if (details != null) {
					for (Detail detail : details) {
//						if (!residualDetails.contains(detail)) {
//							residualDetails.remove(detail);
//							break;
//						}
						exporter.exportConstraint(environment, detail.getContainer(), constraint);
					}
				}
			}
			//
			//	Finally delete the obsolete details
			//
			for (Detail detail : residualDetails) {
				EAnnotation eAnnotation = detail.getAnnotation();
				EObject eObject = eAnnotation.eContainer();
				if (eObject instanceof EClassifier) {
					exporter.removeConstraintName((EClassifier)eObject, detail.getKey());
				}
				eAnnotation.getDetails().remove(detail.getKey());
			}
		} finally {
			exporter = null;
		}
		importFromResources();
	}

	@Override
	public ResourceSet getTarget() {
		return (ResourceSet) super.getTarget();
	}

	@Override
	protected void handleNotification(Notification notification) {
	    int featureID = notification.getFeatureID(ResourceSet.class);
	    if (featureID == ResourceSet.RESOURCE_SET__RESOURCES)
	    {
		    int eventType = notification.getEventType();
		    if (eventType == Notification.ADD) {
		    	addWatcher(notification.getNewValue());
		    }
		    else if (eventType == Notification.ADD_MANY) {
		    	for (Object resource : (List<?>)notification.getNewValue()) {
			    	addWatcher(resource);
		    	}
		    }
		    else if (eventType == Notification.REMOVE) {
		    	removeWatcher(notification.getOldValue());
		    }
		    else if (eventType == Notification.REMOVE_MANY) {
		    	for (Object resource : (List<?>)notification.getOldValue()) {
			    	removeWatcher(resource);
		    	}
		    }
	    }
	}

	public void importFromResources() {
		if (exporter != null) {
			return;
		}
		try {
			importer = new Importer(getTarget().getResources());
			contents = importer.getContents();
			String newText = importer.getText();
			updateDocument(newText);
		} finally {
			importer = null;
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == OCLInEcoreSynchronizer.class;
	}

	protected void removeWatcher(Object object) {
		if (object instanceof Resource) {
			Resource resource = (Resource)object;
			ResourceWatcher watcher = EcoreUtils.getAdapter(resource, ResourceWatcher.class);
			if (watcher != null) {
				resource.eAdapters().remove(watcher);
			}
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		if (getTarget() != null) {
			for (Resource resource : getTarget().getResources()) {
				removeWatcher(resource);
			}
		}
		if (newTarget != null) {
			for (Resource resource : ((ResourceSet)newTarget).getResources()) {
				addWatcher(resource);
			}
		}
		super.setTarget(newTarget);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		if (oldTarget != null) {
			for (Resource resource : ((ResourceSet)oldTarget).getResources()) {
				removeWatcher(resource);
			}
		}
		super.unsetTarget(oldTarget);
	}

	protected abstract void updateDocument(String newText);
}