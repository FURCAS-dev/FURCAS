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
 * $Id: CS2PivotConversion.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.OperationContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.PackageContentContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.TemplateBindingContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.TemplateSignatureContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot.Factory;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class CS2PivotConversion extends AbstractConversion
{	
	private static final Logger logger = Logger.getLogger(CS2PivotConversion.class);
	public static final TracingOption CONTINUATION = new TracingOption("org.eclipse.ocl.examples.xtext.base", "continuation");  //$NON-NLS-1$//$NON-NLS-2$

	protected final CS2Pivot converter;
	protected final ProblemHandler problemHandler;
	protected final TypeManager typeManager;
	protected final Map<String, MonikeredElementCS> moniker2CSmap = new HashMap<String, MonikeredElementCS>();
	
	/**
	 * The per-package Vistors
	 */
	private final Map<EPackage, BaseCSVisitor<MonikeredElement, CS2PivotConversion>> left2RightVisitorMap = new HashMap<EPackage, BaseCSVisitor<MonikeredElement, CS2PivotConversion>>();
	private final Map<EPackage, BaseCSVisitor<Continuation<?>, CS2PivotConversion>> postOrderVisitorMap = new HashMap<EPackage, BaseCSVisitor<Continuation<?>, CS2PivotConversion>>();
	private final Map<EPackage, BaseCSVisitor<Continuation<?>, CS2PivotConversion>> preOrderVisitorMap = new HashMap<EPackage, BaseCSVisitor<Continuation<?>, CS2PivotConversion>>();

	private Map<TemplateableElement, Set<TemplateableElement>> specializations = new HashMap<TemplateableElement, Set<TemplateableElement>>();

//	private Map<ClassCS, ClassSupersContinuation> classesHaveSuperClasses = new HashMap<ClassCS, ClassSupersContinuation>();
	private InterDependency<PackageContentContinuation> packagesHaveTypes = new InterDependency<PackageContentContinuation>("All unspecialized types defined", null);
	private InterDependency<TemplateSignatureContinuation> typesHaveSignatures = new InterDependency<TemplateSignatureContinuation>("All unspecialized signatures defined", packagesHaveTypes);
	private InterDependency<TemplateBindingContinuation> typesHaveSpecializations = new InterDependency<TemplateBindingContinuation>("All specialized types defined", typesHaveSignatures);
	private InterDependency<OperationContinuation<?>> operationsHaveTemplateParameters = new InterDependency<OperationContinuation<?>>("All operation template parameters defined", typesHaveSignatures);

	// CS <-> pivot pairs with identical monikers
	private Map<MonikeredElementCS, MonikeredElement> debugCheckMap = new HashMap<MonikeredElementCS, MonikeredElement>();
	// CS -> pivot pairs with possibly divergent monikers
	private Map<ElementCS, Element> debugOtherMap = new HashMap<ElementCS, Element>();
	
	public CS2PivotConversion(CS2Pivot converter, ProblemHandler problemHandler) {
		this.converter = converter;
		this.problemHandler = problemHandler;
		this.typeManager = converter.getTypeManager();
	}

	public void addDiagnostic(ModelElementCS csElement, Diagnostic diagnostic) {
		csElement.getError().add(diagnostic.getMessage());
	}

//	public void addError(ModelElementCS csElement, String message) {
//		csElement.getError().add(message);
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.ocl.examples.xtext.base.cs2pivot.DiagnosticHandler#addError(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS, java.lang.String, java.lang.Object)
	 */
	public OclExpression addBadExpressionError(ModelElementCS csElement, String message, Object... bindings) {
		String boundMessage = NLS.bind(message, bindings);
		csElement.getError().add(boundMessage);
		XtextLinkingDiagnostic diagnostic = new XtextLinkingDiagnostic(NodeModelUtils.getNode(csElement), boundMessage, "xyzzy");		// FIXME
		csElement.eResource().getErrors().add(diagnostic);
		InvalidLiteralExp invalidLiteralExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		invalidLiteralExp.setType(typeManager.getOclInvalidType());
		invalidLiteralExp.setObject(csElement);
		invalidLiteralExp.setReason(boundMessage);
		installPivotElementInternal(csElement, invalidLiteralExp);
		return invalidLiteralExp;
	}

	public InvalidType addBadTypeError(ModelElementCS csElement, String message, Object... bindings) {
		String boundMessage = NLS.bind(message, bindings);
		csElement.getError().add(boundMessage);
		XtextLinkingDiagnostic diagnostic = new XtextLinkingDiagnostic(NodeModelUtils.getNode(csElement), boundMessage, "xyzzy");		// FIXME
		csElement.eResource().getErrors().add(diagnostic);
		InvalidType invalidType = typeManager.getOclInvalidType();
		installPivotElementInternal(csElement, invalidType);
		return invalidType;
	}

//	public void addWarning(ModelElementCS csElement, String message) {
//		csElement.getError().add(message);
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.ocl.examples.xtext.base.cs2pivot.DiagnosticHandler#addWarning(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS, java.lang.String, java.lang.Object)
	 */
	public void addWarning(ModelElementCS csElement, String message, Object... bindings) {
		csElement.getError().add(NLS.bind(message, bindings));
	}

	public boolean checkForNoErrors(Collection<? extends Resource> csResources) {
		boolean hasNoErrors = true;
		for (Resource csResource : csResources) {
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					for (String error : csElement.getError()) {
						ICompositeNode node = NodeModelUtils.getNode(csElement);
						hasNoErrors = false;
						int offset = node.getOffset();
						int length = node.getLength();
						if (problemHandler != null) {				// FIXME Why null/why this check interactively
							problemHandler.analyzerProblem(Severity.ERROR, error, "CS2Pivot", offset, offset+length);
						}
						else {
							logger.error(error);
						}
					}
				}
			}
		}
		return hasNoErrors;
	}

	public void checkMonikers() {
		for (Map.Entry<MonikeredElementCS, MonikeredElement> entry : debugCheckMap.entrySet()) {
			MonikeredElementCS csElement = entry.getKey();
			MonikeredElement element = entry.getValue();
			String csMoniker = csElement.getMoniker();
			String moniker = element.getMoniker();
			assert csMoniker.equals(moniker) : "\n" + csElement.eClass().getName() + ": '" + csMoniker + "'\n"
			 + element.eClass().getName() + ": '" + moniker + "'";
		}
//		debugCheckQueue.clear();
	}
	
	public void declareAlias(Namespace pivotElement, PackageCS csElement) {
		converter.declareAlias(pivotElement, csElement);
	}

	protected void diagnoseContinuationFailure(List<BasicContinuation<?>> continuations) {
		StringBuffer s = new StringBuffer();
		int i = 0;
		for (BasicContinuation<?> continuation : continuations) {
			s.append("\n  ");
			s.append(continuation);
			for (Dependency dependency : continuation.getDependencies()) {
				s.append("\n    ");
				if (!dependency.canExecute()) {
					s.append("BLOCKED ");
					dependency.canExecute();			// FIXME debugging
				}
				s.append(dependency);					
			}
			if (++i >= 10) {
				s.append("\n  ...");
				break;
			}
		}
		logger.error("Failed to complete continuations" + s.toString());		// FIXME
	}

/*	protected List<String> getDocumentationStrings1(CompositeNode node) {
		List<LeafNode> documentationNodes = CS2Pivot.getDocumentationNodes(node);
		if (documentationNodes == null) {
			return null;
		}
		List<String> documentationStrings = new ArrayList<String>();
		for (LeafNode documentationNode : documentationNodes) {
			String text = documentationNode.getText();
			documentationStrings.add(text.substring(3, text.length()-3).trim());
		}
		return documentationStrings;
	} */

	public BaseCSVisitor<MonikeredElement, CS2PivotConversion> getLeft2RightVisitor(EPackage ePackage) {
		BaseCSVisitor<MonikeredElement, CS2PivotConversion> left2RightVisitor = left2RightVisitorMap.get(ePackage);
		if ((left2RightVisitor == null) && !left2RightVisitorMap.containsKey(ePackage)) {
			Factory factory = converter.getFactory(ePackage);
			if (factory != null) {
				left2RightVisitor = factory.createLeft2RightVisitor(this);
				if (left2RightVisitor == null) {
					logger.error("No Left2Right Visitor created for " + ePackage.getName());
				}
			}
			else {
				logger.error("No Left2Right Visitor Factory registered for " + ePackage.getName());
			}
			left2RightVisitorMap.put(ePackage, left2RightVisitor);
		}
		return left2RightVisitor;
	}

	public InterDependency<OperationContinuation<?>> getOperationsHaveTemplateParametersInterDependency() {
		return operationsHaveTemplateParameters;
	}

	public InterDependency<PackageContentContinuation> getPackagesHaveTypesInterDependency() {
		return packagesHaveTypes;
	}

	public <T extends Element> T getPivotElement(Class<T> pivotClass, String moniker) {
		MonikeredElement nameableElement = converter.getPivotElement(moniker);
		if (nameableElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(nameableElement.getClass())) {
			logger.error("Pivot element for " + moniker + " is not a " + pivotClass.getName()); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) nameableElement;
		return castElement;
	}

	public BaseCSVisitor<Continuation<?>, CS2PivotConversion> getPostOrderVisitor(EPackage ePackage) {
		BaseCSVisitor<Continuation<?>, CS2PivotConversion> postOrderVisitor = postOrderVisitorMap.get(ePackage);
		if ((postOrderVisitor == null) && !postOrderVisitorMap.containsKey(ePackage)) {
			Factory factory = converter.getFactory(ePackage);
			if (factory != null) {
				postOrderVisitor = factory.createPostOrderVisitor(this);
				if (postOrderVisitor == null) {
					logger.error("No PostOrder Visitor created for " + ePackage.getName());
				}
			}
			else {
				logger.error("No PostOrder Visitor Factory registered for " + ePackage.getName());
			}
			postOrderVisitorMap.put(ePackage, postOrderVisitor);
		}
		return postOrderVisitor;
	}

	public BaseCSVisitor<Continuation<?>, CS2PivotConversion> getPreOrderVisitor(EPackage ePackage) {
		BaseCSVisitor<Continuation<?>, CS2PivotConversion> preOrderVisitor = preOrderVisitorMap.get(ePackage);
		if ((preOrderVisitor == null) && !preOrderVisitorMap.containsKey(ePackage)) {
			Factory factory = converter.getFactory(ePackage);
			if (factory != null) {
				preOrderVisitor = factory.createPreOrderVisitor(this);
				if (preOrderVisitor == null) {
					logger.error("No PreOrder Visitor created for " + ePackage.getName());
				}
			}
			else {
				logger.error("No PreOrder Visitor Factory registered for " + ePackage.getName());
			}
			preOrderVisitorMap.put(ePackage, preOrderVisitor);
		}
		return preOrderVisitor;
	}

	protected List<TemplateBindingCS> getTemplateBindings(ElementCS csElement) {
		List<TemplateBindingCS> csTemplateBindings;
//		EObject container = csElement.eContainer();
//		if (container instanceof ElementCS) {			
//			csTemplateBindings = getTemplateBindings((ElementCS) container);
//		}
//		else {
			csTemplateBindings = new ArrayList<TemplateBindingCS>();
//		}
		if (csElement instanceof ParameterizedTypeRefCS) {
			ParameterizedTypeRefCS csTemplateableElement = (ParameterizedTypeRefCS)csElement;
			TemplateBindingCS csTemplateBinding = csTemplateableElement.getOwnedTemplateBinding();
			if (csTemplateBinding != null) {
				csTemplateBindings.add(csTemplateBinding);
			}
		}
		return csTemplateBindings;
	}
	
	protected List<TemplateSignature> getTemplateSignatures(Element pivotElement) {
		List<TemplateSignature> pivotTemplateSignatures;
		EObject container = pivotElement.eContainer();
		if (container instanceof Element) {			
			pivotTemplateSignatures = getTemplateSignatures((Element) container);
		}
		else {
			pivotTemplateSignatures = new ArrayList<TemplateSignature>();
		}
		if (pivotElement instanceof TemplateableElement) {
			TemplateableElement templateableElement = (TemplateableElement)pivotElement;
			TemplateSignature templateSignature = templateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				pivotTemplateSignatures.add(templateSignature);
			}
		}
		return pivotTemplateSignatures;
	}

	public TypeManager getTypeManager() {
		return typeManager;
	}

	public InterDependency<TemplateSignatureContinuation> getTypesHaveSignaturesInterDependency() {
		return typesHaveSignatures;
	}

	public InterDependency<TemplateBindingContinuation> getTypesHaveSpecializationsInterDependency() {
		return typesHaveSpecializations;
	}

	public void handleVisitNamedElement(NamedElementCS csNamedElement, NamedElement pivotElement) {
		List<Annotation> pivotAnnotations = pivotElement.getOwnedAnnotations();
		List<AnnotationElementCS> csAnnotations = csNamedElement.getOwnedAnnotation();
//		if ((csAnnotations.size() <= 1) && (pivotAnnotations.size() <= 1)) {
			refreshPivotList(Annotation.class, pivotAnnotations, csAnnotations);
/*		}
		else {
			HashSet<String> names = new HashSet<String>();
			HashMap<String, List<Annotation>> pivotMap = new HashMap<String, List<Annotation>>();
			HashMap<String, List<AnnotationElementCS>> csMap = new HashMap<String, List<AnnotationElementCS>>();
			for (Annotation pivotAnnotation : pivotAnnotations) {
				String name = pivotAnnotation.getName();
				names.add(name);
				List<Annotation> pivotList = pivotMap.get(name);
				if (pivotList == null) {
					pivotList = new ArrayList<Annotation>();
					pivotMap.put(name, pivotList);
				}
				pivotList.add(pivotAnnotation);
			}
			for (AnnotationElementCS csAnnotation : csAnnotations) {
				String name = csAnnotation.getName();
				names.add(name);
				List<AnnotationElementCS> csList = csMap.get(name);
				if (csList == null) {
					csList = new ArrayList<AnnotationElementCS>();
					csMap.put(name, csList);
				}
				csList.add(csAnnotation);
			}
			for (String name : names) {
				List<Annotation> pivotList = pivotMap.get(name);
				List<AnnotationElementCS> csList = csMap.get(name);
//				refreshPivotList(Annotation.class, pivotAnnotations, csAnnotations);
				List<Annotation> newPivotAnnotations = new ArrayList<Annotation>();
				for (ModelElementCS csElement : csList) {
					Annotation pivotAnnotation = getPivotElement(Annotation.class, csElement);
					assert pivotAnnotation != null;
					if (pivotElement != null) {
						newPivotAnnotations.add(pivotAnnotation);
					}
				}
				refreshList(pivotAnnotations, newPivotAnnotations);
			}
		} */
	}

	public void installPivotElement(ModelElementCS csElement, Element newPivotElement) {
		if (csElement instanceof MonikeredElementCS) {
			assert !"NavigatingExpCS".equals(csElement.eClass().getName());		// FIXME debugging
			debugCheckMap.put((MonikeredElementCS) csElement, (MonikeredElement) newPivotElement);
		}
		else {
			debugOtherMap.put(csElement, newPivotElement);
		}
		installPivotElementInternal(csElement, newPivotElement);
	}
	
	/**
	 * Install a CS to Pivot mapping for which the CS element does not have a
	 * matching moniker. This occurs where the CS requires multiple objects for
	 * a pivot object and so only one of the CS objects can have a matching moniker.
	 * e.g. NavigationArgCS
	 */
	public void reusePivotElement(ModelElementCS csElement, Element newPivotElement) {
		if (newPivotElement != null) {
			debugOtherMap.put(csElement, newPivotElement);
			installPivotElementInternal(csElement, newPivotElement);
		}
	}

	/**
	 * Install a CS to Pivot mapping for which the CS element does not map to the
	 * pivot object. This occurs where the pivot requires multiple objects for
	 * a CS object and so only one of the pivot objects can have a matching moniker.
	 * e.g. LetExpCS
	 */
	public void usePivotElement(ModelElementCS csElement, Element newPivotElement) {
		// TODO Auto-generated method stub
		
	}
	
	private void installPivotElementInternal(ModelElementCS csElement, Element newPivotElement) {
//		logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$		
		EObject oldPivotElement = csElement.getPivot();
		/*if (newPivotElement == null) {
			if (!(csElement instanceof TemplateBindingCS)) {
				logger.warn("Missing new pivot element for " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else*/ if (oldPivotElement == null) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
		} else if (oldPivotElement != newPivotElement) {
			if (oldPivotElement.eResource() != null) {
				logger.warn("Conflicting pivot element for " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$
			}
//			else {
				assert !newPivotElement.eIsProxy();
				csElement.setPivot(newPivotElement);
//			}
		} else {
//			logger.info("Duplicate pivot element for " + csClassName + " : " + moniker); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public void installResidualMonikers(MonikeredElement monikeredElement) {
		if (!monikeredElement.hasMoniker()) {
			putPivotElement(monikeredElement);
		}
		for (TreeIterator<EObject> tit = monikeredElement.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof MonikeredElement) {
				MonikeredElement childElement = (MonikeredElement) eObject;
				if (!childElement.hasMoniker()) {
					putPivotElement(childElement);
				}
//				String moniker = Pivot2Moniker.toString(childElement);
				String moniker = childElement.getMoniker();
				MonikeredElement getElement = getPivotElement(MonikeredElement.class, moniker);
				assert getElement == childElement;
			}
		}
	}

	protected void installRootContents(Resource csResource) {
		for (EObject eObject : csResource.getContents()) {
			if (eObject instanceof Pivotable) {
				Element pivotElement = ((Pivotable)eObject).getPivot();
				if (pivotElement != null) {
					Resource pivotResource = pivotElement.eResource();
					if (pivotResource == null) {
						pivotResource = converter.getPivotResource(csResource);
						if (pivotResource != null) {
							pivotResource.getContents().add(pivotElement);
						}
					}
				}
			}
		}
	}

	/**
	 * Invoke all of the continuations that can execute, returning the list of
	 * continuations till to perform, some of which may be ones that were
	 * blocked by unsatisfied dependencies, others of which may be further
	 * continuations resulting from only partial progress. Returns null if
	 * none of the continuations could execute.
	 * 
	 * @param continuations
	 * @return continuations still to perform, null if stuck.
	 */
	protected List<BasicContinuation<?>> progressContinuations(List<BasicContinuation<?>> continuations) {
		List<BasicContinuation<?>> moreContinuations = new ArrayList<BasicContinuation<?>>();
		boolean madeProgress = false;
		boolean tracingOn = CONTINUATION.isActive();
		if (tracingOn) {
			CONTINUATION.println("-------------------------------------------------");
			CONTINUATION.println(packagesHaveTypes.toString());
			CONTINUATION.println(typesHaveSignatures.toString());
			CONTINUATION.println(typesHaveSpecializations.toString());
			CONTINUATION.println(operationsHaveTemplateParameters.toString());
		}
		for (BasicContinuation<?> continuation : continuations) {
			boolean canExecute = continuation.canExecute();
			if (tracingOn) {
				CONTINUATION.println((canExecute ? "+ " : "- ") + continuation);
			}
			if (canExecute) {
				madeProgress = true;
				BasicContinuation<?> nextContinuation = continuation.execute();
//				while ((nextContinuation != null) && nextContinuation.canExecute()) {
//					nextContinuation = nextContinuation.execute();
//				}
				if (nextContinuation != null) {
					nextContinuation.addTo(moreContinuations);
				}
			}
			else {
				moreContinuations.add(continuation);
			}
		}
		return madeProgress ? moreContinuations : null;
	}

	public void putPivotElement(MonikeredElement pivotElement) {
		converter.putPivotElement(pivotElement.getMoniker(), pivotElement);
	}

	public <T extends MonikeredElement> T refreshExpTree(Class<T> pivotClass, ModelElementCS csElement) {
		if (csElement == null) {
			return null;
		}
		MonikeredElement pivotElement = visitLeft2Right(csElement);
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
	
	public <T extends OclExpression> T refreshExpression(Class<T> pivotClass, EClass pivotEClass, MonikeredElementCS csElement) {
		T pivotElement = refreshMonikeredElement(pivotClass, pivotEClass, csElement);
		installPivotElement(csElement, pivotElement);
		return pivotElement;
	}

	public <T extends Element> void refreshList(Class<T> pivotClass, List<T> pivotElements, List<? extends MonikeredElementCS> csElements) {
		if (!pivotElements.isEmpty() ||!csElements.isEmpty()) {
			List<T> newPivotElements = new ArrayList<T>();
			for (MonikeredElementCS csElement : csElements) {
				String moniker = csElement.getMoniker();
				T pivotElement = getPivotElement(pivotClass, moniker);
				if (pivotElement != null) {
					newPivotElements.add(pivotElement);
				}
			}
			PivotUtil.refreshList(pivotElements, newPivotElements);
		}
	}

	/**
	 * Return a pivotEClass instance cast to pivotClass registered for csElement.getMoniker().
	 * <p>An existing moniker element is re-used else an new instance is created.
	 * <p>The pivot element is installed as the original object of csElement. 
	 * @param <T>
	 * @param pivotClass
	 * @param pivotEClass
	 * @param csElement
	 * @return
	 */
	public <T extends MonikeredElement> T refreshMonikeredElement(Class<T> pivotClass, EClass pivotEClass, MonikeredElementCS csElement) {
		String moniker = csElement.getMoniker();
		MonikeredElementCS oldElement = moniker2CSmap.put(moniker, csElement);
		if ((oldElement != null) && (oldElement != csElement)) {
			logger.warn("Duplicate " + moniker);
		}
		return refreshMonikeredElement(pivotClass, pivotEClass, moniker);
	}

	public <T extends MonikeredElement> T refreshMonikeredElement(Class<T> pivotClass, EClass pivotEClass, String moniker) {
		assert pivotClass == pivotEClass.getInstanceClass();
		assert moniker != null;
		MonikeredElement pivotElement = converter.getPivotElement(moniker);
		if (pivotElement == null) {
			logger.trace("Creating " + pivotEClass.getName() + " : " + moniker); //$NON-NLS-1$ //$NON-NLS-2$
			pivotElement = (MonikeredElement) PivotFactory.eINSTANCE.create(pivotEClass);
			converter.putPivotElement(moniker, pivotElement);
		}
		else {
			assert !pivotElement.hasMoniker() || moniker.equals(pivotElement.getMoniker());
			logger.trace("Reusing " + pivotEClass.getName() + " : " + moniker); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
//		installPivotElement(csElement, pivotElement);
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	public void refreshName(NamedElement pivotNamedElement, String newName) {
		String oldName = pivotNamedElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			pivotNamedElement.setName(newName);
		}
	}

	public <T extends NamedElement> T refreshNamedElement(Class<T> pivotClass,
			EClass pivotEClass, NamedElementCS csElement) {
		T pivotElement = refreshMonikeredElement(pivotClass, pivotEClass, csElement);
		installPivotElement(csElement, pivotElement);
		refreshName(pivotElement, csElement.getName());
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		if (node != null) {
			List<ILeafNode> documentationNodes = CS2Pivot.getDocumentationNodes(node);
			if (documentationNodes != null) {
				List<String> documentationStrings = new ArrayList<String>();
				for (ILeafNode documentationNode : documentationNodes) {
					String text = documentationNode.getText();
					documentationStrings.add(text.substring(3, text.length()-3).trim());
				}
				List<Comment> ownedComments = pivotElement.getOwnedComments();
				int iMax = Math.min(documentationStrings.size(), ownedComments.size());
				int i = 0;
				for (; i < iMax; i++) {
					String string = documentationStrings.get(i);
					String trimmedString = trimString(string);
					Comment comment = ownedComments.get(i);
					if (!trimmedString.equals(comment.getBody())) {
						comment.setBody(trimmedString);
					}
				}
				for ( ; i < documentationStrings.size(); i++) {
					String string = documentationStrings.get(i);
					String trimmedString = trimString(string);
					Comment comment = PivotFactory.eINSTANCE.createComment();
					comment.setBody(trimmedString);
					ownedComments.add(comment);
				}
				while (i < ownedComments.size()) {
					ownedComments.remove(ownedComments.size()-1);
				}
			}
		}
		return pivotElement;
	}
	
	public <T extends Element> void refreshPivotList(Class<T> pivotClass, List<? super T> pivotElements,
			List<? extends ModelElementCS> csElements) {
		if (pivotElements.isEmpty() && csElements.isEmpty()) {
			return;
		}
		List<T> newPivotElements = new ArrayList<T>();
		for (ModelElementCS csElement : csElements) {
			T pivotElement = PivotUtil.getPivot(pivotClass, csElement);
			if (pivotElement != null) {
				newPivotElements.add(pivotElement);
			}
			else {
				assert pivotElement != null;
			}
		}
		PivotUtil.refreshList(pivotElements, newPivotElements);
	}

	public void refreshTemplateSignature(TemplateableElementCS csTemplateableElement, TemplateableElement pivotTemplateableElement) {
		TemplateSignatureCS csTemplateSignature = csTemplateableElement.getOwnedTemplateSignature();
		if (csTemplateSignature == null) {
			if (pivotTemplateableElement.getOwnedTemplateSignature() != null) {
				pivotTemplateableElement.setOwnedTemplateSignature(null);
			}
			return;
		}
		TemplateSignature pivotTemplateSignature = refreshMonikeredElement(TemplateSignature.class, PivotPackage.Literals.TEMPLATE_SIGNATURE, csTemplateSignature);
		if (pivotTemplateableElement.getOwnedTemplateSignature() != pivotTemplateSignature) {
			pivotTemplateableElement.setOwnedTemplateSignature(pivotTemplateSignature);
		}
		installPivotElement(csTemplateSignature, pivotTemplateSignature);
		List<TemplateParameter> newPivotTemplateParameters = new ArrayList<TemplateParameter>();
		List<TemplateParameterCS> csTemplateParameters = csTemplateSignature.getOwnedTemplateParameter();
		for (TemplateParameterCS csTemplateParameter : csTemplateParameters) {
			org.eclipse.ocl.examples.pivot.Class pivotTemplateParameterClass = refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class,
				PivotPackage.Literals.CLASS, csTemplateParameter);
			TemplateParameter pivotTemplateParameter = pivotTemplateParameterClass.getOwningTemplateParameter();
			if (pivotTemplateParameter == null) {
				pivotTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
				pivotTemplateParameter.setOwnedParameteredElement(pivotTemplateParameterClass);
			}
			installPivotElement(csTemplateParameter, pivotTemplateParameterClass);
			newPivotTemplateParameters.add(pivotTemplateParameter);
		}
		PivotUtil.refreshList(pivotTemplateSignature.getOwnedParameters(), newPivotTemplateParameters);
	}
	
	public <T extends TypedMultiplicityElement> T  refreshTypedMultiplicityElement(Class<T> pivotClass,
			EClass pivotEClass, TypedElementCS csTypedElement) {
		T pivotElement = refreshNamedElement(pivotClass, pivotEClass, csTypedElement);
		List<String> qualifiers = csTypedElement.getQualifier();
		pivotElement.setIsOrdered(qualifiers.contains("ordered"));
		pivotElement.setIsUnique(qualifiers.contains("unique"));
		String multiplicity = csTypedElement.getMultiplicity();
		if (multiplicity == null) {
			pivotElement.setLower(BigInteger.valueOf(csTypedElement.getLower()));
			pivotElement.setUpper(BigInteger.valueOf(csTypedElement.getUpper()));
		}
		else if ("*".equals(multiplicity)) {
			pivotElement.setLower(BigInteger.valueOf(0));
			pivotElement.setUpper(BigInteger.valueOf(-1));
		}
		else if ("+".equals(multiplicity)) {
			pivotElement.setLower(BigInteger.valueOf(1));
			pivotElement.setUpper(BigInteger.valueOf(-1));
		}
		else if ("?".equals(multiplicity)) {
			pivotElement.setLower(BigInteger.valueOf(0));
			pivotElement.setUpper(BigInteger.valueOf(1));
		}
		return pivotElement;
	}

	public Operation resolveOperationCall(NamedElementCS csOperator, OperationCallExp pivotElement) {
		OclExpression sourceExpression = pivotElement.getSource();
		Type sourceType = sourceExpression.getType();
		String operator = pivotElement.getName();
		Operation operation;
		List<OclExpression> arguments = pivotElement.getArguments();
		if (arguments.isEmpty()) {
			operation = typeManager.resolveOperation(sourceType, operator);
		}
		else {
			OclExpression argumentExpression = arguments.get(0);
			Type rightType = argumentExpression.getType();
			operation = typeManager.resolveOperation(sourceType, operator, rightType);
		}
		if (operation == null) {
			addBadExpressionError(csOperator, OCLMessages.ErrorUnresolvedOperationCall, csOperator);
		}
		pivotElement.setReferredOperation(operation);
		return operation;
	}

	/**
	 * Set the type and so potentially satisfy some TypeOfDependency. This method ensures that
	 * type is not set to null.
	 * 
	 * @param pivotExpression
	 * @param type
	 */
	public void setType(TypedElement pivotElement, Type type) {
//		if (type == null) {
//			type = typeManager.getOclInvalidType();	// FIXME unresolved type with explanation
//		}
		if (type != pivotElement.getType()) {
			pivotElement.setType(type);
		}
	}

	/**
	 * Update a list of TemplateBinding to match a list of TemplateSignature
	 * by moving/adding/removing existing entries. Once matched each TemplateBinding.signature
	 * references the corresponding TemplateSignature, and each TemplateBinding.parameterSubstitution.formal
	 * references the corresponding TemplateSignature.ownedParameter.
	 * 
	 * @param templateBindings
	 * @param templateSignatures
	 */
	protected void specializeTemplateBindings(List<TemplateBinding> templateBindings, List<TemplateSignature> templateSignatures, List<TemplateBindingCS> csTemplateBindings) {
		int csIMax = csTemplateBindings.size();
		int pivotIMax = templateSignatures.size();
		if (csIMax != pivotIMax) {
			logger.warn("Inconsistent template bindings size for " + csTemplateBindings.get(0).getOwningTemplateBindableElement().getMoniker()); //$NON-NLS-1$
		}
		int newMax = Math.min(csIMax, pivotIMax);
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			TemplateBindingCS csTemplateBinding = csTemplateBindings.get(i);
			TemplateSignature templateSignature = templateSignatures.get(i);
			int oldMax = templateBindings.size();
			TemplateBinding templateBinding = null;;
			for (int j = i; j < oldMax; j++) {
				TemplateBinding oldTemplateBinding = templateBindings.get(j);
				if (oldTemplateBinding.getSignature() == templateSignature) {
					if (j != i) {
						templateBindings.add(i, templateBindings.remove(j));
					}
					templateBinding = oldTemplateBinding;
//					registerPivotElement(csTemplateBinding, templateBinding);
//					installPivotElement(csTemplateBinding, templateBinding);
					break;
				}
			}
			if (templateBinding == null) {
//				templateBinding = refreshMonikeredElement(TemplateBinding.class, PivotPackage.Literals.TEMPLATE_BINDING, csTemplateBinding);
				templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
				templateBinding.setSignature(templateSignature);
				if (i < oldMax) {
					templateBindings.add(i, templateBinding);
				}
				else {
					templateBindings.add(templateBinding);					
				}
			}
			installPivotElement(csTemplateBinding, templateBinding);
			specializeTemplateParameterSubstitutions(templateBinding.getParameterSubstitutions(), templateSignature.getOwnedParameters(), csTemplateBinding.getOwnedParameterSubstitution());
			assert templateSignatures.get(i) == templateBindings.get(i).getSignature();
		}
		for (int k = templateBindings.size(); k > newMax; ) {
			templateBindings.remove(--k);
		}
		assert templateSignatures.size() == templateBindings.size();
	}

	/**
	 * Update a list of TemplateParameterSubstitution to match a list of TemplateParameter
	 * by moving/adding/removing existing entries. Once matched each TemplateParameterSubstitution.formal
	 * references the corresponding TemplateParameter.
	 * @param eList 
	 * 
	 * @param templateSignature
	 * @param templateBinding
	 */
	protected void specializeTemplateParameterSubstitutions(List<TemplateParameterSubstitution> templateParameterSubstitutions,
			List<TemplateParameter> templateParameters, List<TemplateParameterSubstitutionCS> csTemplateParameterSubstitutions) {
		int csIMax = csTemplateParameterSubstitutions.size();
		int pivotIMax = templateParameters.size();
		if (csIMax != pivotIMax) {
			logger.warn("Inconsistent template parameter substitutions size"); // FIXME + csTemplateParameterSubstitutions.get(0).getOwningTemplateBinding().getMoniker()); //$NON-NLS-1$
		}
		int newMax = Math.min(csIMax, pivotIMax);
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			TemplateParameterSubstitutionCS csTemplateParameterSubstitution = csTemplateParameterSubstitutions.get(i);
			TemplateParameter templateParameter = templateParameters.get(i);
			int oldMax = templateParameterSubstitutions.size();
			TemplateParameterSubstitution templateParameterSubstitution = null;
			for (int j = i; j < oldMax; j++) {
				TemplateParameterSubstitution oldTemplateParameterSubstitution = templateParameterSubstitutions.get(j);
				if (oldTemplateParameterSubstitution.getFormal() == templateParameter) {
					if (j != i) {
						templateParameterSubstitutions.add(i, templateParameterSubstitutions.remove(j));
					}
					templateParameterSubstitution = oldTemplateParameterSubstitution;
//					registerPivotElement(csTemplateParameterSubstitution, templateParameterSubstitution);
//					installPivotElement(csTemplateParameterSubstitution, templateParameterSubstitution);
					break;
				}
			}
			if (templateParameterSubstitution == null) {
//				templateParameterSubstitution = refreshMonikeredElement(TemplateParameterSubstitution.class, PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION, csTemplateParameterSubstitution);
				templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				templateParameterSubstitution.setFormal(templateParameter);
				if (i < oldMax) {
					templateParameterSubstitutions.add(i, templateParameterSubstitution);
				}
				else {
					templateParameterSubstitutions.add(templateParameterSubstitution);
				}
			}
			ParameterableElementCS csActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
			if (csActualParameter instanceof WildcardTypeRefCS) {
				ParameterableElement pivotActualParameter = templateParameterSubstitution.getOwnedActual();
				if (pivotActualParameter == null) {
					pivotActualParameter = PivotFactory.eINSTANCE.createClass();
					templateParameterSubstitution.setOwnedActual(pivotActualParameter);
				}
				String name = PivotConstants.WILDCARD_NAME;
				if (i > 1) {
					name += i;
				}
				((NamedElement)pivotActualParameter).setName(name);
				installPivotElement(csActualParameter, pivotActualParameter);
			}
			else {
				ParameterableElement pivotActualParameter = PivotUtil.getPivot(ParameterableElement.class, csActualParameter);
				templateParameterSubstitution.setActual(pivotActualParameter);
			}
			installPivotElement(csTemplateParameterSubstitution, templateParameterSubstitution);
//			queueResolver(csTemplateParameterSubstitution);		// To resolve actuals
			assert templateParameters.get(i) == templateParameterSubstitutions.get(i).getFormal();
		}
		for (int k = templateParameterSubstitutions.size(); k > newMax; ) {
			templateParameterSubstitutions.remove(--k);
		}
		assert templateParameters.size() == templateParameterSubstitutions.size();
	}

	protected TemplateableElement specializeTemplates(/*Map<TemplateableElement, Set<TemplateableElement>> specializations,*/ TypedTypeRefCS csElement) {
		TemplateBindingCS ownedTemplateBinding = csElement.getOwnedTemplateBinding();
		assert ownedTemplateBinding != null;
		TemplateableElement unspecializedPivotElement = csElement.getType();
		String moniker = csElement.getMoniker();
		logger.trace("Specializing " + moniker); //$NON-NLS-1$
		if (unspecializedPivotElement == null) {
			logger.error("Nothing to specialize as " + moniker); //$NON-NLS-1$
			return null;
		}
		//
		//	Refresh the pivot specialization root
		//
		TemplateableElement specializedPivotElement = getPivotElement(TemplateableElement.class, moniker);
		if (specializedPivotElement == null) {
			if (unspecializedPivotElement instanceof Type) {
				EClass eClass = unspecializedPivotElement.eClass();
				@SuppressWarnings("unchecked")
				Class<? extends Type> pivotClazz = (Class<? extends Type>) eClass.getInstanceClass();
				Type pivotClass = refreshMonikeredElement(pivotClazz, eClass, csElement);
				refreshName(pivotClass, ((Type)unspecializedPivotElement).getName());
				specializedPivotElement = pivotClass;
				if (pivotClass instanceof CollectionType) {
					Type elementType = PivotUtil.getPivot(Type.class, ownedTemplateBinding.getOwnedParameterSubstitution().get(0).getOwnedActualParameter());
					((CollectionType)pivotClass).setElementType(elementType);
				}
			}
			else {							// FIXME Non-Type TemplateParameters
				logger.error("Missing support for non-type specialization " + moniker); //$NON-NLS-1$
				return null;
			}
			typeManager.addOrphanType((Type) specializedPivotElement);
		}
		installPivotElement(csElement, specializedPivotElement);
//		specializedPivotElement.toString();			// FIXME debugging
		if (specializedPivotElement == unspecializedPivotElement) {
			return null;
		}
		//
		//	Refresh the pivot specialization bindings and parameter substitutions
		//
		List<TemplateBinding> templateBindings = specializedPivotElement.getTemplateBindings();
		List<TemplateSignature> templateSignatures = getTemplateSignatures(unspecializedPivotElement);
		List<TemplateBindingCS> csTemplateBindings = getTemplateBindings(csElement);
		specializeTemplateBindings(templateBindings, templateSignatures, csTemplateBindings);
		//
		//	Cache the pivot specialization
		//
//		unspecializedPivotElement.getOwnedSpecializations().add(specializedPivotElement);
	//	String specializedMoniker = specializedPivotElement.getMoniker();
	//	assert moniker.equals(specializedMoniker) : specializedMoniker + " is not the same as " + moniker;
//		converter.putPivotElement(moniker, specializedPivotElement);
		Set<TemplateableElement> specializationList = specializations.get(unspecializedPivotElement);
		if (specializationList == null) {
			specializationList = new HashSet<TemplateableElement>();
			specializations.put(unspecializedPivotElement, specializationList);
		}
		specializationList.add(specializedPivotElement);
//		converter.putPivotElement(moniker, specializedPivotElement);
		return specializedPivotElement;
	}

	protected String trimString(String string) {
		StringBuffer s = new StringBuffer();
		String prefix = "";
		for (String line : string.split("\n")) {
			String trimmedLine = line.trim();
			if (trimmedLine.length() == 0) {
				s.append("\n");
				prefix = "";
			}
			else {
				s.append(prefix);
				s.append(trimmedLine.replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
				prefix = " ";
			}
		}
		String trimmedString = s.toString();
		return trimmedString;
	}

	/**
	 * Sequence the update passes to make the pivot match the CS.
	 * @param csResources 
	 */
	public boolean update(Collection<? extends Resource> csResources) {
		debugCheckMap.clear();
		debugOtherMap.clear();
		List<BasicContinuation<?>> continuations = new ArrayList<BasicContinuation<?>>();
		//
		//	Perform the pre-order traversal to create packages, unspecialized classes and precedences.
		//
		for (Resource csResource : csResources) {
			visitInPreOrder(csResource.getContents(), continuations);
		}
		//
		//	Put all orphan root pivot elements in their resources and ensure
		//	that aliases are defined before monikers are created.
		//
		for (Resource csResource : csResources) {
			converter.refreshAliasMap(csResource);
			installRootContents(csResource);
		}
		//
		//	Perform pre-order continuations to establish package, class containment and classifier template signatures.
		//
		Collections.reverse(continuations);
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				boolean hasNoErrors = checkForNoErrors(csResources);
				if (!hasNoErrors) {
					return false;
				}
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Load the library by loading external content or exploiting the pre-ordered content. 
		//
		Type oclAnyType = typeManager.getOclAnyType();
		if (oclAnyType == null) {
			return false;				// FIXME throw ??
		}
		//
		//	Perform the post-order traversal to create and install the bulk of non-package/class
		//	elements.
		//
		for (Resource csResource : csResources) {
			visitInPostOrder(csResource.getContents(), continuations);
		}
		boolean hasNoErrors = checkForNoErrors(csResources);
		if (!hasNoErrors) {
			return false;
		}
		//
		//	Perform post-order continuations to establish complex dependencies.
		//
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Finally resolve the base classes of template specializations
		//
		typeManager.resolveSpecializationBaseClasses();
		hasNoErrors = checkForNoErrors(csResources);
		if (!hasNoErrors) {
			return false;
		}
		checkMonikers();		
		//
		//	Set the monikers as IDs throughout the pivot model.
		//
		for (Resource csResource : csResources) {
			Resource pivotResource = converter.getPivotResource(csResource);
			TypeManager.setMonikerAsID(Collections.singletonList(pivotResource));	// FIXME purge
		}
		return true;
	}

	public MonikeredElement visitLeft2Right(EObject eObject) {
		BaseCSVisitor<MonikeredElement, CS2PivotConversion> left2RightVisitor = getLeft2RightVisitor(eObject.eClass().getEPackage());
		if ((left2RightVisitor == null) || !(eObject instanceof VisitableCS)) {
			logger.warn("Unsupported " + eObject.eClass().getName());
			return null;
		}
		else {
			return ((VisitableCS)eObject).accept(left2RightVisitor);
		}
	}

	protected void visitInPostOrder(List<? extends EObject> eObjects, List<BasicContinuation<?>> continuations) {
		for (int i = eObjects.size(); i-- > 0; ) {
			EObject eObject = eObjects.get(i);
			BaseCSVisitor<Continuation<?>, CS2PivotConversion> postOrderVisitor = getPostOrderVisitor(eObject.eClass().getEPackage());
			if ((postOrderVisitor != null) && (eObject instanceof VisitableCS)) {
				List<EObject> eContents = eObject.eContents();
				if (eContents.size() > 0) {
					visitInPostOrder(eContents, continuations);
				}
				Continuation<?> continuation = ((VisitableCS)eObject).accept(postOrderVisitor);
				if (continuation != null) {
					continuation.addTo(continuations);
				}
			}
		}
	}

	protected void visitInPreOrder(List<? extends EObject> eObjects, List<BasicContinuation<?>> continuations) {
		for (EObject eObject : eObjects) {
			BaseCSVisitor<Continuation<?>, CS2PivotConversion> preOrderVisitor = getPreOrderVisitor(eObject.eClass().getEPackage());
			if ((preOrderVisitor == null) || !(eObject instanceof VisitableCS)) {
				logger.warn("Unsupported " + eObject.eClass().getName());
			}
			else {
				Continuation<?> continuation = ((VisitableCS)eObject).accept(preOrderVisitor);
				if (continuation != null) {
					continuation.addTo(continuations);
				}
//				if ((continuation == null) || !continuation.isTerminate()) {
					List<EObject> eContents = eObject.eContents();
					if (eContents.size() > 0) {
						visitInPreOrder(eContents, continuations);
					}
//				}
			}
		}
	}
}