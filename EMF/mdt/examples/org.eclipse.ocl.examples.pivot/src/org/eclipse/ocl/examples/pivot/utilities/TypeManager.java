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
 * $Id: TypeManager.java,v 1.24 2011/05/27 09:28:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.lang.reflect.Field;
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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl;
import org.eclipse.ocl.examples.pivot.library.ConstrainedOperation;
import org.eclipse.ocl.examples.pivot.library.ConstrainedProperty;
import org.eclipse.ocl.examples.pivot.library.ExplicitNavigationProperty;
import org.eclipse.ocl.examples.pivot.library.ImplicitCompositionProperty;
import org.eclipse.ocl.examples.pivot.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.library.TuplePartProperty;
import org.eclipse.ocl.examples.pivot.library.UnimplementedOperation;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;
import org.eclipse.ocl.examples.pivot.uml.UML2Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.util.Nameable;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.osgi.util.NLS;

/**
 * A TypeManager adapts a ResourceSet to provide facilities for the pivot
 * model.
 * <p>
 * An PivotURI entry is maintained for each non-null EPackage.nsURI to
 * facilitate lookup, detect duplicates, and domain (Ecore/UML - Pivot - CS)
 * mappings.
 * <p>
 * An PivotPrefix entry is maintained for each non-null EPackage.nsPrefix to
 * facilitate alias generation for monikers.
 */
public class TypeManager extends TypeCaches implements Adapter
{	
/*	private static class ResourceTracker extends AbstractTracker<Resource>
	{
		public static ResourceTracker install(TypeCaches typeCaches, Resource target) {
			return new ResourceTracker(typeCaches, target);
		}

		public static  void uninstall(TypeCaches typeCaches, Resource target) {
			ResourceTracker tracker = PivotUtil.getAdapter(ResourceTracker.class, target);
			if (tracker != null) {
				tracker.dispose();
			}
		}
		
		private ResourceTracker(TypeCaches typeCaches, Resource target) {
			super(typeCaches, target);
		}		

		@Override
		public void dispose() {
			unsetTarget(target);
		}
		
		public boolean isAdapterForType(Object type) {
			return type == ResourceTracker.class;
		}

		public void notifyChanged(Notification notification) {
			int featureID = notification.getFeatureID(ResourceSet.class);
			if (featureID == Resource.RESOURCE__CONTENTS) {
				int eventType = notification.getEventType();
				switch (eventType) {
					case Notification.ADD: {
						Object value = notification.getNewValue();
						ResourceTracker.install(typeCaches, (Resource)value);
						break;
					}
					case Notification.REMOVE: {
						Object value = notification.getOldValue();
						ResourceTracker.uninstall(typeCaches, (Resource)value);
						break;
					}
				}
			}
		}
	} */
	
	public static class TuplePart extends TypedElementImpl
	{
		public TuplePart(String name, Type type) {
			setName(name);
			setType(type);
		}
	}
	
	public static interface Factory	// FIXME Support this via an extension point
	{
		/**
		 * Return true if this factory can handle creatio of a Pivot resource from the
		 * available resource.
		 */
		boolean canHandle(Resource resource);
		
		/**
		 * Configure the TypeManager's external ResourceSet. Implementations may install
		 * any required extension or content to factory mappinmgs in the resource factory registry.
		 * @param resourceSet
		 */
		void configure(ResourceSet resourceSet);
		
		/**
		 * Return the root element in the Pivot resource resulting from import of the available
		 * resource. 
		 * @param uriFragment 
		 */
		Element importFromResource(TypeManager typeManager, Resource resource, String uriFragment);
	}
	
	private static Set<Factory> factoryMap = new HashSet<Factory>();
	
	public static void addFactory(Factory factory) {
		factoryMap.add(factory);
	}
	
	static {
		Ecore2Pivot.FACTORY.getClass();
		UML2Ecore2Pivot.FACTORY.getClass();
	}
	
	private static final Logger logger = Logger.getLogger(TypeManager.class);

	// public static final String OMG_OCL_LANG1 = "omg.ocl.lang";
	// public static final String OMG_OCL_STDLIB1 = "omg.ocl.stdlib";

	public static TypeManager findAdapter(ResourceSet resourceSet) {
		if (resourceSet == null) {
			return null;
		}
		return PivotUtil.getAdapter(TypeManager.class, resourceSet);
	}

	public static TypeManager getAdapter(ResourceSet resourceSet) {
		if (resourceSet == null) {
			return null;
		}
		List<Adapter> eAdapters = resourceSet.eAdapters();
		TypeManager adapter = PivotUtil.getAdapter(TypeManager.class, eAdapters);
		if (adapter == null) {
			adapter = new TypeManager(resourceSet);
			eAdapters.add(adapter);
		}
		return adapter;
	}

	public static void initializePivotResourceSet(ResourceSet pivotResourceSet) {
		Registry resourceFactoryRegistry = pivotResourceSet.getResourceFactoryRegistry();
		Map<String, Object> contentTypeToFactoryMap = resourceFactoryRegistry.getContentTypeToFactoryMap();
		contentTypeToFactoryMap.put(PivotResource.CONTENT_TYPE, new PivotResourceFactoryImpl()); //$NON-NLS-1$
		Map<String, Object> extensionToFactoryMap = resourceFactoryRegistry.getExtensionToFactoryMap();
		extensionToFactoryMap.put("*", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		extensionToFactoryMap.put(PivotResource.FILE_EXTENSION, new PivotResourceFactoryImpl()); //$NON-NLS-1$
		org.eclipse.emf.ecore.EPackage.Registry packageRegistry = pivotResourceSet.getPackageRegistry();
		packageRegistry.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
	}

	public static boolean isLibraryType(Type type) {	// FIXME cf PivotSaver.isOrphanType
		if (type instanceof LambdaType) {
			return false;
		}
		else if (type instanceof TupleType) {
			return ((TupleType)type).getOwnedAttributes().isEmpty();			
		}
		else {
			return type.getTemplateBindings().isEmpty();			
		}
	}

	/**
	 * Install the moniker of each nameable pivot element as its xmi:id.
	 * 
	 * @param pivotResources
	 */
	public static void setMonikerAsID(Collection<? extends Resource> resources) {
		for (Resource resource : resources) {
			if (resource instanceof XMLResource) {
				XMLResource xmlResource = (XMLResource) resource;
				for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
					EObject eObject = it.next();
					if (eObject instanceof MonikeredElement) {
						String moniker = ((MonikeredElement) eObject).getMoniker();
						String id = moniker.replaceAll("<", "&lt;"); // Workaround for Bug 322704 //$NON-NLS-1$ //$NON-NLS-2$
						xmlResource.setID(eObject, id);
					} else if (eObject instanceof TemplateParameter) {
						String moniker = ((TemplateParameter) eObject).getParameteredElement().getMoniker() + ".";
						String id = moniker.replaceAll("<", "&lt;"); // Workaround for Bug 322704 //$NON-NLS-1$ //$NON-NLS-2$
						xmlResource.setID(eObject, id);
					}
				}
			} else {
				logger.warn("Resource '" + resource.getURI() + "' is not an XMLResource"); //$NON-NLS-1$//$NON-NLS-2$
			}
		}
	}

	protected final ResourceSet pivotResourceSet;
	
	/**
	 * All Library packages imported intio the current type managed domain. All libraries
	 * share the same URI, which for supplementary libraries may be null.
	 */
	protected List<Library> pivotLibraries = new ArrayList<Library>();	

	/**
	 * The resource of the first of the pivotLibraries. Set once actually loaded.
	 */
	protected Resource pivotLibraryResource = null;

	protected ResourceSetImpl externalResourceSet = null;

	/**
	 * Map of precedence name to precedence objects. Multiple precedence objects
	 * may be associated with a single name since alternate contributions
	 * provide independent lists that must be successfully interleaved so that
	 * all same-named precedence objects get the same compiled ordering.
	 * <p>
	 * e.g. <tt> precedence A B D</tt> and <tt>precedence B C D</tt> merge to
	 * <tt>A B C D</tt> with duplicate precedence objects for B and D.
	 */
	private Map<String, List<Precedence>> nameToPrecedencesMap = null;

	private Map<String, String> infixToPrecedenceNameMap = null;

	private Map<String, String> prefixToPrecedenceNameMap = null;
	
	private Map<String, Namespace> globalNamespaces = new HashMap<String, Namespace>();
	private Set<Type> globalTypes = new HashSet<Type>();

	private int unspecifiedTypeCount = 0;
	
	/**
	 * Map of URI to extertnal resource converter.
	 */
	private Map<URI, External2Pivot> external2PivotMap = new HashMap<URI, External2Pivot>();
	
	/**
	 * Map of arbitrary user context to the associated URI used for the concrete syntax
	 * of an expression. The map is used by getResourceIdentifier to cache URIs for contexts
	 * that are not MonikeredElements. Any object may be used, possibly the OCL string itself,
	 * provided the object has exactly one associated OCL expression.
	 */
	private Map<Object,URI> uriMap = null;

	/**
	 * Elements protected from garbage collection
	 */
	private Set<Element> lockedElements = new HashSet<Element>();;
	
	public TypeManager() {
		this(new ResourceSetImpl());
		initializePivotResourceSet(pivotResourceSet);
	}

	public TypeManager(ResourceSet pivotResourceSet) {
//		System.out.println("ctor " + this);
		this.pivotResourceSet = pivotResourceSet;
		pivotResourceSet.eAdapters().add(this);
//		System.out.println(Thread.currentThread().getName() + " Create " + getClass().getSimpleName() + "@" + hashCode()
//			+ " " + pivotResourceSet.getClass().getSimpleName() + "@" + pivotResourceSet.hashCode());		
	}

	public void addExternalResource(External2Pivot external2Pivot) {
		external2PivotMap.put(external2Pivot.getURI(), external2Pivot);
	}

	public Namespace addGlobalNamespace(String name, Namespace namespace) {
		return globalNamespaces.put(name, namespace);
	}

	public boolean addGlobalTypes(Collection<Type> types) {
		return globalTypes.addAll(types);
	}

	public boolean addLockedElement(Element lockedElement) {
		return lockedElements.add(lockedElement);
	}

//	public void addPackage(String key, Package pivotPackage) {
//		packageMap.put(key, pivotPackage);
//	}

	/**
	 * Return -ve if match1 is inferior to match2, +ve if match2 is inferior to match1, or
	 * zero if both matches are of equal validity.
	 */
	public int compareOperationMatches(Operation reference, Map<TemplateParameter, ParameterableElement> referenceBindings,
			Operation candidate, Map<TemplateParameter, ParameterableElement> candidateBindings) {
		if ((reference instanceof Iteration) && (candidate instanceof Iteration)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterators().size() - ((Iteration)reference).getOwnedIterators().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			org.eclipse.ocl.examples.pivot.Class referenceType = PivotUtil.getFeaturingClass((Iteration)reference);
			org.eclipse.ocl.examples.pivot.Class candidateType = PivotUtil.getFeaturingClass((Iteration)candidate);
			Type specializedReferenceType = getSpecializedType(referenceType, referenceBindings);
			Type specializedCandidateType = getSpecializedType(candidateType, candidateBindings);
			if (referenceType != candidateType) {
				if (conformsTo(specializedReferenceType, specializedCandidateType, null)) {
					return 1;
				}
				else if (conformsTo(specializedCandidateType, specializedReferenceType, null)) {
					return -1;
				}
			}
		}
		return 0;
	}

	/**
	 * Interleave the ownedPrecedences of the rootPackages to establish a merged
	 * ordering and assign the index in that ordering to each
	 * rootPackages.ownedPrecedences. Any inconsistent ordering and
	 * associativity is diagnosed.
	 */
	public List<String> compilePrecedences(
			Collection<? extends org.eclipse.ocl.examples.pivot.Package> rootPackages) {
		List<String> errors = new ArrayList<String>();
		List<String> orderedPrecedences = new ArrayList<String>();
		nameToPrecedencesMap = new HashMap<String, List<Precedence>>();
		infixToPrecedenceNameMap = new HashMap<String, String>();
		prefixToPrecedenceNameMap = new HashMap<String, String>();
		for (org.eclipse.ocl.examples.pivot.Package rootPackage : rootPackages) {
			List<Precedence> precedences = rootPackage.getOwnedPrecedences();
			if (precedences.size() > 0) {
				compilePrecedencePackage(rootPackage);
				int prevIndex = -1;
				List<Precedence> list = null;
				String name = null;
				for (Precedence precedence : precedences) {
					name = precedence.getName();
					int index = orderedPrecedences.indexOf(name);
					if (index < 0) {
						index = prevIndex < 0
							? orderedPrecedences.size()
							: prevIndex + 1;
						orderedPrecedences.add(index, name);
						list = new ArrayList<Precedence>();
						nameToPrecedencesMap.put(name, list);
					} else {
						list = nameToPrecedencesMap.get(name);
						if (index <= prevIndex) {
							errors.add("Inconsistent precedence ordering for '"
								+ name + "'");
						} else if ((prevIndex >= 0) && (index != prevIndex + 1)) {
							errors.add("Ambiguous precedence ordering for '"
								+ name + "'");
						}
						if (precedence.getAssociativity() != list.get(0)
							.getAssociativity()) {
							errors
								.add("Inconsistent precedence associativity for '"
									+ name + "'");
						}
					}
					prevIndex = index;
					list.add(precedence);
				}
				if ((list != null) && (list.size() == 1)
					&& (prevIndex != orderedPrecedences.size() - 1)) {
					errors.add("Ambiguous precedence ordering for '" + name
						+ "' at tail");
				}
			}
		}
		for (int i = 0; i < orderedPrecedences.size(); i++) {
			String name = orderedPrecedences.get(i);
			BigInteger order = BigInteger.valueOf(i);
			for (Precedence precedence : nameToPrecedencesMap.get(name)) {
				precedence.setOrder(order);
			}
		}
		return errors;
	}

	protected void compilePrecedenceOperation(Operation operation) {
		Precedence precedence = operation.getPrecedence();
		if (precedence != null) {
			List<Parameter> parameters = operation.getOwnedParameters();
			if (parameters.size() == 0) {
				String newName = precedence.getName();
				String operatorName = operation.getName();
				String oldName = prefixToPrecedenceNameMap.put(operatorName,
					newName);
				if ((oldName != null) && !oldName.equals(newName)) {
					logger
						.warn("Conflicting precedences for prefix operation '"
							+ operatorName + "'");
				}
			} else if (parameters.size() == 1) {
				String newName = precedence.getName();
				String operatorName = operation.getName();
				String oldName = infixToPrecedenceNameMap.put(operatorName,
					newName);
				if ((oldName != null) && !oldName.equals(newName)) {
					logger.warn("Conflicting precedences for infix operation '"
						+ operatorName + "'");
				}
			}
		}
	}

	protected void compilePrecedencePackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackages()) {
			compilePrecedencePackage(nestedPackage);
		}
		for (Type type : pivotPackage.getOwnedTypes()) {
			if (isLibraryType(type)) {
				compilePrecedenceType(type);
			}
		}
	}

	protected void compilePrecedenceType(Type pivotType) {
		defineLibraryType(pivotType);
		if (pivotType instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (Operation operation : ((org.eclipse.ocl.examples.pivot.Class) pivotType)
				.getOwnedOperations()) {
				compilePrecedenceOperation(operation);
			}
		}
	}

	protected CallableImplementation computeOperationImplementation(Operation operation) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		CallableImplementation implementation = operation.getImplementation();
		String implementationClassName = operation.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				Class<?> theClass = Class.forName(implementationClassName);
				Field field = theClass.getField("INSTANCE");
				return (CallableImplementation) field.get(null);
			}
		}
		for (Constraint constraint : getLocalConstraints(operation)) {
			if (UMLReflection.BODY.equals(constraint.getStereotype())) {
				ValueSpecification specification = constraint.getSpecification();
				if (specification instanceof ExpressionInOcl) {
					return new ConstrainedOperation((ExpressionInOcl) specification);
				}
			}
		}
		return UnimplementedOperation.INSTANCE;
	}

	public Collection<org.eclipse.ocl.examples.pivot.Package> computePivotRootPackages() {
		Set<org.eclipse.ocl.examples.pivot.Package> rootPackages =
			new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		if (pivotLibraryResource != null) {
			for (EObject eObject : pivotLibraryResource.getContents()) {
				if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					rootPackages.add((org.eclipse.ocl.examples.pivot.Package) eObject);
				}
			}
		}
		for (Resource pivotResource : pivotResourceSet.getResources()) {
			for (EObject eObject : pivotResource.getContents()) {
				if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					rootPackages.add((org.eclipse.ocl.examples.pivot.Package) eObject);
				}
			}
		}
		return rootPackages;
	}

	protected CallableImplementation computePropertyImplementation(Property property) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		CallableImplementation implementation = property.getImplementation();
		String implementationClassName = property.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				Class<?> theClass = Class.forName(implementationClassName);
				Field field = theClass.getField("INSTANCE");
				return (CallableImplementation) field.get(null);
			}
		}
		for (Constraint constraint : getLocalConstraints(property)) {
			if (UMLReflection.BODY.equals(constraint.getStereotype())) {
				ValueSpecification specification = constraint.getSpecification();
				if (specification instanceof ExpressionInOcl) {
					return new ConstrainedProperty((ExpressionInOcl) specification);
				}
			}
		}
		if (property.isImplicit()) {
			Property opposite = property.getOpposite();
			if (opposite.isComposite()) {
				return ImplicitCompositionProperty.INSTANCE;
			}
			else {
				return ImplicitNonCompositionProperty.INSTANCE;
			}
		}
		else if (property.getClass_() instanceof TupleType){
			return TuplePartProperty.INSTANCE;
		}
		else {
			return ExplicitNavigationProperty.INSTANCE;
		}
	}

	@Deprecated
	public boolean conformsTo(Type firstType, Type secondType) {
		return conformsTo(firstType, secondType, null);
	}

	public boolean conformsTo(Type firstType, Type secondType, Map<TemplateParameter, ParameterableElement> bindings) {
		if ((firstType == null) || (secondType == null)) {
			return false;
		}
		if (bindings != null) {
			TemplateParameter firstTemplateParameter = firstType.getOwningTemplateParameter();
			if (firstTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(firstTemplateParameter);
				if (parameterableElement instanceof Type) {
					firstType = (Type) parameterableElement;
				}
			}
			TemplateParameter secondTemplateParameter = secondType.getOwningTemplateParameter();
			if (secondTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(secondTemplateParameter);
				if (parameterableElement instanceof Type) {
					secondType = (Type) parameterableElement;
				}
				else if ((parameterableElement == null) && bindings.containsKey(secondTemplateParameter)) {
					bindings.put(secondTemplateParameter, firstType);
					return true;
				}
			}
		}
		if (firstType == secondType) {
			return true;
		}
//		firstType = getModelType(firstType);
//		secondType = getModelType(secondType);
		firstType = getPrimaryClass(firstType);
		secondType = getPrimaryClass(secondType);
		if (firstType == secondType) {
			return true;
		}
		if (secondType instanceof AnyType) {			// FIXME Shouldn't the library model definitions apply here too
			return true;
		}
		else if (firstType instanceof AnyType) {
			return false;
		}
		else if (firstType instanceof InvalidType) {
			return true;
		}
		else if (secondType instanceof InvalidType) {
			return false;
		}
		else if (firstType instanceof VoidType) {
			return true;
		}
		else if (secondType instanceof VoidType) {
			return false;
		}
		else if (firstType instanceof ClassifierType) {
			if (secondType instanceof ClassifierType) {
				return conformsToClassifierType((ClassifierType)firstType, (ClassifierType)secondType, bindings);
			}
			return false;
		}
		else if (firstType instanceof CollectionType) {
			if (secondType instanceof CollectionType) {
				return conformsToCollectionType((CollectionType)firstType, (CollectionType)secondType, bindings);
			}
			return false;
		}
		else if (firstType instanceof LambdaType) {
			if (secondType instanceof LambdaType) {
				return conformsToLambdaType((LambdaType)firstType, (LambdaType)secondType, bindings);
			}
			return false;
		}
		else if (firstType instanceof TupleType) {
			if (secondType instanceof TupleType) {
				return conformsToTupleType((TupleType)firstType, (TupleType)secondType, bindings);
			}
			return false;
		}
		else if (firstType instanceof org.eclipse.ocl.examples.pivot.Class) {
			if (secondType instanceof org.eclipse.ocl.examples.pivot.Class) {
				org.eclipse.ocl.examples.pivot.Class firstClass = (org.eclipse.ocl.examples.pivot.Class)firstType;
				org.eclipse.ocl.examples.pivot.Class secondClass = (org.eclipse.ocl.examples.pivot.Class)secondType;
				for (org.eclipse.ocl.examples.pivot.Class superClass : firstClass.getSuperClasses()) {
					if (conformsTo(superClass, secondClass, bindings)) {
						return true;
					}
				}
//				List<TemplateBinding> templateBindings = actualType.getTemplateBindings();
//				if (templateBindings.size() > 0) {
//					TemplateableElement template = PivotUtil.getUnspecializedTemplateableElement(actualType);
//					return conformsToClass((org.eclipse.ocl.examples.pivot.Class)template, requiredType);
//				}
			}
			return false;
		}
		else {
			return false;
		}
	}

	protected boolean conformsToClassifierType(ClassifierType firstType, ClassifierType secondType,
			Map<TemplateParameter, ParameterableElement> bindings) {
		Type firstElementType = firstType.getInstanceType();
		Type secondElementType = secondType.getInstanceType();
		if (bindings != null) {
			TemplateParameter firstTemplateParameter = firstElementType.getOwningTemplateParameter();
			if (firstTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(firstTemplateParameter);
				if (parameterableElement instanceof Type) {
					firstElementType = (Type) parameterableElement;
				}
			}
			TemplateParameter secondTemplateParameter = secondElementType.getOwningTemplateParameter();
			if (secondTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(secondTemplateParameter);
				if (parameterableElement instanceof Type) {
					secondElementType = (Type) parameterableElement;
				}
				else if ((parameterableElement == null) && bindings.containsKey(secondTemplateParameter)) {
					bindings.put(secondTemplateParameter, firstElementType);
					return true;
				}
			}
		}
		if (firstElementType instanceof UnspecifiedType) {
			Type lowerBound = ((UnspecifiedType)firstElementType).getLowerBound();
			if (conformsTo(secondElementType, lowerBound, bindings)) {
				((UnspecifiedType)firstElementType).setLowerBound(secondElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else if (secondElementType instanceof UnspecifiedType) {
			Type upperBound = ((UnspecifiedType)secondElementType).getUpperBound();
			if (conformsTo(upperBound, firstElementType, bindings)) {
				((UnspecifiedType)secondElementType).setUpperBound(firstElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return conformsTo(firstElementType, secondElementType, bindings);
		}
	}

	protected boolean conformsToLambdaType(LambdaType firstType, LambdaType secondType,
			Map<TemplateParameter, ParameterableElement> bindings) {
		throw new UnsupportedOperationException();
	}

	protected boolean conformsToCollectionType(CollectionType firstType, CollectionType secondType,
			Map<TemplateParameter, ParameterableElement> bindings) {
		CollectionType unspecializedFirstType = PivotUtil.getUnspecializedTemplateableElement(firstType);
		CollectionType unspecializedSecondType = PivotUtil.getUnspecializedTemplateableElement(secondType);
		if (!isSuperClassOf(unspecializedSecondType, unspecializedFirstType)) {
			return false;
		}
		Type firstElementType = firstType.getElementType();
		Type secondElementType = secondType.getElementType();
		if (bindings != null) {
			if (firstElementType != null) {
				TemplateParameter firstTemplateParameter = firstElementType.getOwningTemplateParameter();
				if (firstTemplateParameter != null) {
					ParameterableElement parameterableElement = bindings.get(firstTemplateParameter);
					if (parameterableElement instanceof Type) {
						firstElementType = (Type) parameterableElement;
					}
				}
			}
			if (secondElementType != null) {
				TemplateParameter secondTemplateParameter = secondElementType.getOwningTemplateParameter();
				if (secondTemplateParameter != null) {
					ParameterableElement parameterableElement = bindings.get(secondTemplateParameter);
					if (parameterableElement instanceof Type) {
						secondElementType = (Type) parameterableElement;
					}
					else if ((parameterableElement == null) && bindings.containsKey(secondTemplateParameter)) {
						bindings.put(secondTemplateParameter, firstElementType);
						return true;
					}
				}
			}
		}
		if (firstElementType instanceof UnspecifiedType) {
			Type lowerBound = ((UnspecifiedType)firstElementType).getLowerBound();
			if (conformsTo(secondElementType, lowerBound, bindings)) {
				((UnspecifiedType)firstElementType).setLowerBound(secondElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else if (secondElementType instanceof UnspecifiedType) {
			Type upperBound = ((UnspecifiedType)secondElementType).getUpperBound();
			if (conformsTo(upperBound, firstElementType, bindings)) {
				((UnspecifiedType)secondElementType).setUpperBound(firstElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return conformsTo(firstElementType, secondElementType, bindings);
		}
	}

	protected boolean conformsToTupleType(TupleType actualType, TupleType requiredType,
			Map<TemplateParameter, ParameterableElement> bindings) {
		List<Property> actualProperties = actualType.getOwnedAttributes();
		List<Property> requiredProperties = requiredType.getOwnedAttributes();
		if (actualProperties.size() != requiredProperties.size()) {
			return false;
		}
		for (Property actualProperty : actualProperties) {
			Property requiredProperty = PivotUtil.getNamedElement(requiredProperties, actualProperty.getName());
			if (requiredProperty == null) {
				return false;
			}
			if (!conformsTo(actualProperty.getType(), requiredProperty.getType(), bindings)) {
				return false;
			}
		}
		return true;
	}

	public InvalidLiteralExp createInvalidExpression(/*Object object, String boundMessage, Throwable e*/) {
		InvalidLiteralExp invalidLiteralExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		invalidLiteralExp.setType(getOclInvalidType());
//		invalidLiteralExp.setObject(object);
//		invalidLiteralExp.setReason(boundMessage);
//		invalidLiteralExp.setThrowable(e);
		return invalidLiteralExp;
	}

	@Override
	protected Resource createOrphanage(URI uri) {
		return pivotResourceSet.createResource(uri);
	}

	public org.eclipse.ocl.examples.pivot.Package createPackage(String string, String nsURI) {
		return createPackage(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, string, nsURI);
	}

	public <T extends org.eclipse.ocl.examples.pivot.Package> T createPackage(Class<T> pivotClass,
			EClass pivotEClass, String name, String nsURI) {
		@SuppressWarnings("unchecked")
		T pivotPackage = (T) PivotFactory.eINSTANCE.create(pivotEClass);
		pivotPackage.setName(name);
		pivotPackage.setNsURI(nsURI);
		installPackageMoniker(pivotPackage, true);
//		installPackage(pivotPackage);
		return pivotPackage;
	}

	public Resource createResource(URI uri, String contentType) {
		return pivotResourceSet.createResource(uri, contentType);
	}

	public UnspecifiedType createUnspecifiedType() {
		String value = "<unspecified:" + unspecifiedTypeCount++ + ">";
		UnspecifiedType unspecifiedType = PivotFactory.eINSTANCE.createUnspecifiedType();
		unspecifiedType.setName(value);
		unspecifiedType.setLowerBound(getOclAnyType());
		unspecifiedType.setUpperBound(getOclVoidType());
		unspecifiedType.setMoniker(value);
		addOrphanClass(unspecifiedType);
		return unspecifiedType;
	}
	
	@Override
	public void dispose() {
		super.dispose();
//		for (Adapter adapter : debugAdapters) {
//			assert adapter.getTarget() == null;
//		}
	}

	public ClassifierType getClassifierType(Type type) {
		return getLibraryType(getClassifierType(), Collections.singletonList(type), true);
	}

	public CollectionType getCollectionType(boolean isOrdered, boolean isUnique) {
		if (isOrdered) {
			if (isUnique) {
				return getOrderedSetType();
			}
			else {
				return getSequenceType();
			}
		}
		else {
			if (isUnique) {
				return getSetType();
			}
			else {
				return getBagType();
			}
		}
	}

	public CollectionType getCollectionType(boolean isOrdered, boolean isUnique, Type elementType) {
		return getLibraryType(getCollectionType(isOrdered, isUnique), Collections.singletonList(elementType), true);
	}

	public Type getCollectionType(String collectionTypeName, Type elementType) {
		if ((elementType == null) || elementType.eIsProxy()) {
			return getOclInvalidType();
		}
		return getLibraryType(collectionTypeName, Collections.singletonList(elementType));
	}
	
	public List<org.eclipse.ocl.examples.pivot.Class> getCommonClasses(org.eclipse.ocl.examples.pivot.Class leftClass,
		org.eclipse.ocl.examples.pivot.Class rightClass) {
		List<org.eclipse.ocl.examples.pivot.Class> commonClasses = null;
		if (conformsTo(rightClass, leftClass, null)) {
			commonClasses = new ArrayList<org.eclipse.ocl.examples.pivot.Class>();
			commonClasses.add(leftClass);
		}
		for (org.eclipse.ocl.examples.pivot.Class superClass : leftClass.getSuperClasses()) {
			List<org.eclipse.ocl.examples.pivot.Class> commonSuperClasses = getCommonClasses(superClass, rightClass);
			if (commonSuperClasses != null) {
				if (commonClasses == null) {
					commonClasses = commonSuperClasses;
				}
				else {
					commonClasses.addAll(commonSuperClasses);
				}
			}
		}
		return commonClasses;
	}

    public Type getCommonTupleType(TupleType leftType, TupleType rightType,
    		Map<TemplateParameter, ParameterableElement> bindings) {
		List<Property> leftProperties = leftType.getOwnedAttributes();
		List<Property> rightProperties = rightType.getOwnedAttributes();
		if (leftProperties.size() != rightProperties.size()) {
			return null;
		}
		boolean isLeft = true;
		boolean isRight = true;
		List<TypedElement> commonProperties = new ArrayList<TypedElement>(leftProperties.size());
		for (Property leftProperty : leftProperties) {
			Property rightProperty = PivotUtil.getNamedElement(rightProperties, leftProperty.getName());
			Type leftPropertyType = leftProperty.getType();
			Type rightPropertyType = rightProperty.getType();
			TypedElement commonProperty = null;
			Type commonType = getCommonType(leftPropertyType, rightPropertyType, bindings);
			if (commonType == null) {
				return null;
			}
			if (commonType != leftPropertyType) {
				isLeft = false;
			}
			else {
				commonProperty = leftProperty;
			}
			if (commonType != rightPropertyType) {
				isRight = false;
			}
			else {
				commonProperty = rightProperty;
			}
			if (commonProperty == null) {
				commonProperty = new TypeManager.TuplePart(leftProperty.getName(), commonType);
			}
			commonProperties.add(commonProperty);
		}
		if (isLeft) {
			return leftType;
		}
		else if (isRight) {
			return rightType;
		}
		else {
			return getTupleType(leftType.getName(), commonProperties, bindings, null);
		}
	}

    @Deprecated
	public Type getCommonType(Type leftType, Type rightType) {
		return getCommonType(leftType, rightType, null);
	}
	
	public Type getCommonType(Type leftType, Type rightType, Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions) {
//        System.out.println(leftType.getMoniker() + " : " + rightType.getMoniker());
		if (leftType instanceof UnspecifiedType) {
			((UnspecifiedType)leftType).setUpperBound(rightType);
			return rightType;
		}
		if (rightType instanceof UnspecifiedType) {
			((UnspecifiedType)rightType).setUpperBound(leftType);
			return leftType;
		}
		if ((leftType instanceof TupleType) && (rightType instanceof TupleType)) {
			return getCommonTupleType((TupleType)leftType, (TupleType)rightType, templateParameterSubstitutions);
		}
		if (conformsTo(leftType, rightType, templateParameterSubstitutions)) {
			return rightType;
		}
		if (conformsTo(rightType, leftType, templateParameterSubstitutions)) {
			return leftType;
		}
		if (!(leftType instanceof org.eclipse.ocl.examples.pivot.Class)
		 || !(rightType instanceof org.eclipse.ocl.examples.pivot.Class)) {
			return null;
		}
		List<org.eclipse.ocl.examples.pivot.Class> commonClasses = getCommonClasses((org.eclipse.ocl.examples.pivot.Class)leftType, (org.eclipse.ocl.examples.pivot.Class)rightType);
		if (commonClasses == null) {
			return null;
		}
		// FIXME If there are two different common types neither is inherently better
		org.eclipse.ocl.examples.pivot.Class mostConformant = null;
		for (org.eclipse.ocl.examples.pivot.Class commonClass : commonClasses) {
			if (mostConformant == null) {
				mostConformant = commonClass;
			}
			else if (conformsTo(commonClass, mostConformant, templateParameterSubstitutions)) {
				mostConformant = commonClass;
			}
		}
		return mostConformant;
	}

//	public CompleteType getCompleteType(Type type) {
//		return completeEnvironmentManager.getCompleteType(type);
//	}

	/**
	 * Return the CompleteEnvironmentManager, which is null if none yet created.
	 * Invoke useCompleteEnvironmentManager to create one when required.
	 */
//	public CompleteEnvironmentManager getCompleteEnvironmentManager() {
//		return completeEnvironmentManager;
//	}

//	public CompletePackage getCompletePackage(
//			org.eclipse.ocl.examples.pivot.Package type) {
//		return completeEnvironmentManager.getCompletePackage(type);
//	}

	public String getDefaultStandardLibraryURI() {
		return defaultStandardLibraryURI;
	}

	public ResourceSet getExternalResourceSet() {
		if (externalResourceSet == null) {
			externalResourceSet = new ResourceSetImpl();
			TypeManagerResourceSetAdapter.getAdapter(externalResourceSet, this);
			for (Factory factory : factoryMap) {
				factory.configure(externalResourceSet);
			}
		}
		return externalResourceSet;
	}

//	public Collection<Resource> getExternalResources() {
//		return externalResources != null
//			? externalResources.values()
//			: Collections.<Resource> emptySet();
//	}

	public Set<Map.Entry<String, Namespace>> getGlobalNamespaces() {
		return globalNamespaces.entrySet();
	}

	public Iterable<Type> getGlobalTypes() {
		return globalTypes;
	}

	/**
	 * Return the implementation of a feature.
	 * 
	 * @param feature to be implemented.
	 * @return the implementation, or null if the feature has no implementation
	 * as is the case for a normal model feature
	 * @throws ClassNotFoundException if the implementation class realising
	 * the implementation is not loadable 
	 * @throws NoSuchFieldException if the implementation class realising
	 * the implementation does not provide a static INSTANCE field
	 * @throws SecurityException if the implementation class is not accessible
	 * @throws IllegalAccessException if the implementation class is not accessible
	 * @throws IllegalArgumentException if the implementation class is not accessible
	 */
	public CallableImplementation getImplementation(Feature feature) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		CallableImplementation implementation = feature.getImplementation();
		if (implementation == null) {
			String implementationClassName = feature.getImplementationClass();
			if (implementationClassName != null) {
				Class<?> theClass = Class.forName(implementationClassName);
				Field field = theClass.getField("INSTANCE");
				implementation = (CallableImplementation) field.get(null);
			}
		}
		return implementation;
	}
	public CallableImplementation getImplementation(Operation operation) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		CallableImplementation implementation = operation.getImplementation();
		if (implementation == null) {
			implementation = computeOperationImplementation(operation);
			operation.setImplementation(implementation);
		}
		return implementation;
	}
	public CallableImplementation getImplementation(Property property) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		CallableImplementation implementation = property.getImplementation();
		if (implementation == null) {
			implementation = computePropertyImplementation(property);
			property.setImplementation(implementation);
		}
		return implementation;
	}

	public Precedence getInfixPrecedence(String operatorName) {
		if (infixToPrecedenceNameMap == null) {
			compilePrecedences(computePivotRootPackages());
		}
		String precedenceName = infixToPrecedenceNameMap.get(operatorName);
		if (precedenceName == null) {
			return null;
		}
		List<Precedence> precedences = nameToPrecedencesMap.get(precedenceName);
		if (precedences == null) {
			return null;
		}
		return precedences.get(0);
	}
	   
	public LambdaType getLambdaType(String typeName, Type contextType, List<? extends Type> parameterTypes, Type resultType,
			Map<TemplateParameter, ParameterableElement> bindings, String moniker) {
		if (moniker == null) {
			Pivot2Moniker s = new Pivot2Moniker(null);
			s.append(typeName);
			s.appendLambdaType(contextType, parameterTypes, resultType, bindings);
			moniker = s.toString();
		}
		LambdaType existingLambdaType = findOrphanClass(LambdaType.class, moniker);
		if (existingLambdaType != null) {
			return existingLambdaType;
		}
		LambdaType lambdaType = PivotFactory.eINSTANCE.createLambdaType();
		lambdaType.setName(typeName);
		lambdaType.setContextType(getSpecializedType(contextType, bindings));
		for (Type parameterType : parameterTypes) {
			lambdaType.getParameterTypes().add(getSpecializedType(parameterType, bindings));
		}
		lambdaType.setResultType(getSpecializedType(resultType, bindings));
		if (bindings != null) {
			TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
			for (Map.Entry<TemplateParameter, ParameterableElement> binding : bindings.entrySet()) {
				TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				templateParameterSubstitution.setFormal(binding.getKey());
				templateParameterSubstitution.setActual(binding.getValue());
				templateBinding.getParameterSubstitutions().add(templateParameterSubstitution);
			}
			lambdaType.getTemplateBindings().add(templateBinding);
		}
		lambdaType.setMoniker(moniker);
		addOrphanClass(lambdaType);
		return lambdaType;
	}
	
	public List<Library> getLibraries() { return pivotLibraries; }
	public Resource getLibraryResource() { return pivotLibraryResource; }

	public Type getLibraryType(String string, List<? extends ParameterableElement> templateArguments) {
		Type libraryType = getRequiredLibraryType(string);
		if (libraryType == null) {
			return null;
		}
		return getLibraryType(libraryType, templateArguments, true);
	}

	public <T extends Type> T getLibraryType(T libraryType, List<? extends ParameterableElement> templateArguments, boolean resolveSuperClasses) {
		assert libraryType == PivotUtil.getUnspecializedTemplateableElement(libraryType);
		if ((libraryType == getClassifierType()) && (templateArguments != null) && (templateArguments.size() == 1) && (templateArguments.get(0) == libraryType)) {
			return libraryType;
		}
		TemplateSignature templateSignature = libraryType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature != null ? templateSignature.getParameters() : Collections.<TemplateParameter>emptyList();
		if (templateParameters.isEmpty()) {
			return libraryType;
		}
		if ((templateArguments == null) || (templateArguments.size() != templateParameters.size())) {
			throw new IllegalArgumentException(
				"Incorrect template bindings for template type");
		}
		boolean isUnspecialized = isUnspecialized(templateParameters, templateArguments);
		if (isUnspecialized) {
			return libraryType;	
		}
		String moniker = getSpecializedMoniker(libraryType, templateArguments);
		org.eclipse.ocl.examples.pivot.Class existingSpecializedType1 = getPrimaryClass(moniker);
		Class<T> requiredClass = ClassUtils.getClass(libraryType);
		if (existingSpecializedType1 != null) {
			if (requiredClass.isAssignableFrom(existingSpecializedType1.getClass())) {
				@SuppressWarnings("unchecked")
				T castExistingSpecializedType1 = (T) existingSpecializedType1;
				return castExistingSpecializedType1;
			}
		}
		T existingSpecializedType = findOrphanClass(requiredClass, moniker);
		if (existingSpecializedType != null) {
			return existingSpecializedType;
		}
		EClass eClass = libraryType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		@SuppressWarnings("unchecked")
		T specializedType = (T) eFactoryInstance.create(eClass);
		specializedType.setName(libraryType.getName());
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		templateBinding.setSignature(templateSignature);
		Map<TemplateParameter, ParameterableElement> allBindings = new HashMap<TemplateParameter, ParameterableElement>();
		for (int i = 0; i < templateParameters.size(); i++) {
			TemplateParameter formalParameter = templateParameters.get(i);
			ParameterableElement actualType = templateArguments.get(i);
			allBindings.put(formalParameter, templateArguments.get(i));
			TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
			templateParameterSubstitution.setFormal(formalParameter);
			if ((actualType != null) && (actualType.eContainer() == null)) {
				templateParameterSubstitution.setOwnedActual(actualType);
			}
			else {
				templateParameterSubstitution.setActual(actualType);
			}
			templateBinding.getParameterSubstitutions().add(templateParameterSubstitution);
		}
		specializedType.getTemplateBindings().add(templateBinding);
		if (resolveSuperClasses && (libraryType instanceof org.eclipse.ocl.examples.pivot.Class)) {
			org.eclipse.ocl.examples.pivot.Class libraryClass = (org.eclipse.ocl.examples.pivot.Class)libraryType;
			org.eclipse.ocl.examples.pivot.Class specializedClass = (org.eclipse.ocl.examples.pivot.Class)specializedType;
			resolveSuperClasses(specializedClass, libraryClass, allBindings);
		}
		if (specializedType instanceof CollectionType) {
			((CollectionType)specializedType).setElementType((Type) templateArguments.get(0));
		}
		else if (specializedType instanceof TupleType) {
			((TupleType)specializedType).getSuperClasses().add(getOclAnyType());
		}
		else if (specializedType instanceof ClassifierType) {		// FIXME make this algorithmic
			ParameterableElement templateArgument = templateArguments.get(0);
			ClassifierType specializedClassifierType = (ClassifierType)specializedType;
			specializedClassifierType.setInstanceType((Type)templateArgument);
			if (templateArgument instanceof org.eclipse.ocl.examples.pivot.Enumeration) {
				specializedClassifierType.getSuperClasses().add(getEnumerationType());
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("Enumeration"));
				specializedClassifierType.getSuperClasses().remove(getOclAnyType());
			}
			else if (templateArgument instanceof InvalidType) {
				specializedClassifierType.getSuperClasses().add(getOclInvalidType());
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("InvalidType"));
				specializedClassifierType.getSuperClasses().remove(getOclAnyType());
			}
			else if (templateArgument instanceof VoidType) {
				specializedClassifierType.getSuperClasses().add(getOclVoidType());
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("VoidType"));
				specializedClassifierType.getSuperClasses().remove(getOclAnyType());
			}
			else if (templateArgument instanceof PrimitiveType) {
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("PrimitiveType"));
				specializedClassifierType.getSuperClasses().remove(getOclAnyType());
			}
			else if (templateArgument instanceof CollectionType) {
				specializedClassifierType.getSuperClasses().add(getCollectionType());
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("CollectionType"));
				specializedClassifierType.getSuperClasses().remove(getOclAnyType());
			}
			else if (templateArgument instanceof AnyType) {	
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("Class"));
			}
			else if (templateArgument instanceof TupleType) {
				specializedClassifierType.getSuperClasses().add(getTupleType());
				specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("TupleType"));
				specializedClassifierType.getSuperClasses().remove(getOclAnyType());
			}
			else {
				ClassifierType classifierType = getClassifierType(getClassifierType());
				if (classifierType != specializedClassifierType) {
					specializedClassifierType.getSuperClasses().add(classifierType);
					specializedClassifierType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("Class"));
					specializedClassifierType.getSuperClasses().remove(getOclAnyType());
				}
			}
		}
		specializedType.setUnspecializedElement(libraryType);
		specializedType.setMoniker(moniker);
		addOrphanClass(specializedType);
		return specializedType;
	}

	public Set<? extends Element> getLockedElements() {
		return lockedElements ;
	}
	
	public org.eclipse.ocl.examples.pivot.Package getPivotMetaModel() {
		if (pivotMetaModel == null) {
			AnyType oclAnyType = getOclAnyType();
			if (oclAnyType != null) {
				OclMetaModel metaModelResource = new OclMetaModel(this);
				pivotMetaModel = (org.eclipse.ocl.examples.pivot.Package)metaModelResource.getContents().get(0);
				pivotMetaModel.setName(oclAnyType.getPackage().getName());		// FIXME JUNO Change name for Juno
				pivotMetaModel.setMoniker(oclAnyType.getPackage().getMoniker());
				addPackage(pivotMetaModel);
			}
		}
		return pivotMetaModel;
	}

	public <T extends NamedElement> T getPivotOfEcore(Class<T> pivotClass, EObject eObject) {
		Resource metaModel = eObject.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(metaModel, this);
		return ecore2Pivot.getCreated(pivotClass, eObject);
	}

	public ResourceSet getPivotResourceSet() {
		return pivotResourceSet;
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	public Type getPivotType(String className) {
		Package pivotMetaModel = getPivotMetaModel();
		if (pivotMetaModel == null) {
			return null;
		}
		return PivotUtil.getNamedElement(pivotMetaModel.getOwnedTypes(), className);
	}	

	public Iterable<? extends Nameable> getPrecedences(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		return pivotPackage.getOwnedPrecedences(); // FIXME make package independent
	}

	public Precedence getPrefixPrecedence(String operatorName) {
		if (prefixToPrecedenceNameMap == null) {
			compilePrecedences(computePivotRootPackages());
		}
		String precedenceName = prefixToPrecedenceNameMap.get(operatorName);
		if (precedenceName == null) {
			return null;
		}
		List<Precedence> precedences = nameToPrecedencesMap.get(precedenceName);
		if (precedences == null) {
			return null;
		}
		return precedences.get(0);
	}

	// public String getPrefixPrecedenceName(String operatorName) {
	// return prefixToPrecedenceNameMap.get(operatorName);
	// }
	
	/**
	 * Return the URI to be used for a concrete syntax resource for an expression associated
	 * with a uniqueContext. If uniqueContext is a MonikeredElement the moniker is used as
	 * part of the URI, otherwise a unique value is created and cached for reuse.
	 */
	public URI getResourceIdentifier(Object uniqueContext, String subContext) {
		if (subContext == null) {
			subContext = "";
		}
		URI uri;
		if (uniqueContext instanceof MonikeredElement) {
			uri = URI.createURI(((MonikeredElement) uniqueContext).getMoniker() + subContext + ".essentialocl");
		}
		else {
			if (uriMap == null) {
				uriMap = new HashMap<Object,URI>();
			}
			uri = uriMap.get(uniqueContext);
			if (uri == null) {
				uri = URI.createURI(EcoreUtil.generateUUID() + subContext + ".essentialocl");
				uriMap.put(uniqueContext, uri);
			}
		}
		return uri;
	}

	public CollectionType getSetType(Type elementType) {
		return getLibraryType(getSetType(), Collections.singletonList(elementType), true);
	}

	protected String getSpecializedMoniker(Type libraryType, List<? extends ParameterableElement> templateArguments) {
		Pivot2Moniker s = new Pivot2Moniker(null);
		s.appendElement((Element) libraryType.eContainer());
		s.append(PivotConstants.MONIKER_SCOPE_SEPARATOR);
		s.append(libraryType.getName());
		s.appendTemplateArguments(templateArguments, null);
		String moniker = s.toString();
		return moniker;
	}

	@Override
	public Type getSpecializedType(Type type, Map<TemplateParameter, ParameterableElement> usageBindings) {
		TemplateParameter owningTemplateParameter = type.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			if (usageBindings == null) {
				return type;
			}
			ParameterableElement parameterableElement = usageBindings.get(owningTemplateParameter);
			return parameterableElement instanceof Type ? (Type) parameterableElement : type;
		}
		else if (usageBindings == null) {
			return type;
		}
		else if (type instanceof TupleType) {
			return getSpecializedTupleType((TupleType) type, usageBindings);
		}
		else if (type instanceof LambdaType) {
			return getSpecializedLambdaType((LambdaType)type, usageBindings);
		}
		else {
			//
			//	Get the bindings of the type.
			//
			Type unspecializedType = PivotUtil.getUnspecializedTemplateableElement(type);
	//		List<TemplateParameter> templateParameters = PivotUtil.getAllTemplateParameters(type);
			Map<TemplateParameter, ParameterableElement> typeBindings = PivotUtil.getAllTemplateParametersAsBindings(type);
			PivotUtil.getAllTemplateParameterSubstitutions(typeBindings, type);
			if ((typeBindings != null) && !typeBindings.isEmpty()) {
				//
				//	Re-bind the type bindings to use those of the usage.
				//
				for (TemplateParameter templateParameter : typeBindings.keySet()) {
					ParameterableElement parameterableElement = typeBindings.get(templateParameter);
					if (parameterableElement != null) {
						TemplateParameter aTemplateParameter = parameterableElement.getOwningTemplateParameter();
						if (aTemplateParameter != null) {
							ParameterableElement aParameterableElement = usageBindings.get(aTemplateParameter);
							if (aParameterableElement != null) {
								typeBindings.put(templateParameter, aParameterableElement);
							}
						}
						else if (parameterableElement instanceof SelfType) {
							ParameterableElement aParameterableElement = usageBindings.get(null);
							if (aParameterableElement != null) {
								typeBindings.put(templateParameter, aParameterableElement);
							}
						}
					}
				}
				//
				//	Prepare the template argument list, one template argument per template parameter.
				//
//				Set<TemplateParameter> templateParameters = typeBindings1.keySet();
				List<TemplateParameter> templateParameters = PivotUtil.getAllTemplateParameters(unspecializedType);
				List<ParameterableElement> templateArguments = new ArrayList<ParameterableElement>(templateParameters.size());
//				boolean isSubstituted = false;
				for (TemplateParameter templateParameter : templateParameters) {
					ParameterableElement templateArgument = typeBindings.get(templateParameter);
					if (templateArgument != null) {
//						isSubstituted = true;
					}
					else {
						templateArgument = templateParameter.getParameteredElement();
					}
					if (templateArgument instanceof Type) {
						templateArgument = getSpecializedType((Type)templateArgument, usageBindings);
//						isSubstituted = true;
					}
					templateArguments.add(templateArgument);
				}
//				if (!isSubstituted) {
//					return type;
//				}
				return getLibraryType(unspecializedType, templateArguments, true);
			}
		}
		return type;
	}

	protected Type getSpecializedLambdaType(LambdaType type, Map<TemplateParameter, ParameterableElement> usageBindings) {
		LambdaType specializedLambdaType = getLambdaType(type.getName(), type.getContextType(), type.getParameterTypes(), type.getResultType(), usageBindings, null);
		return specializedLambdaType;
	}

	protected Type getSpecializedTupleType(TupleType type, Map<TemplateParameter, ParameterableElement> usageBindings) {
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		for (Property property : specializedTupleType.getOwnedAttributes()) {
			Type propertyType = getTypeWithMultiplicity(property);
			Type resolvedPropertyType = getSpecializedType(propertyType, usageBindings);
			if (resolvedPropertyType != propertyType) {
				if (resolutions == null) {
					resolutions = new HashMap<String, Type>();
				}
				resolutions.put(property.getName(), resolvedPropertyType);
			}
		}
		if (resolutions != null) {
			List<TypedElement> parts = new ArrayList<TypedElement>();
			for (Property property : specializedTupleType.getOwnedAttributes()) {
				TypedElement part = property;
				Type resolvedPropertyType = resolutions.get(property.getName());
				if (resolvedPropertyType != null) {
					part = new TypeManager.TuplePart(property.getName(), resolvedPropertyType);
				}
				parts.add(part);
			}
			specializedTupleType = getTupleType(type.getName(), parts, usageBindings, null);
		}
		return specializedTupleType;
	}

	public ResourceSet getTarget() {
		return pivotResourceSet;
	}
	   
    /**
     * Creates a new tuple instance.
     * 
     * @param type the type (a {@link TupleType}) of the tuple to be created
     * @param values a mapping of the tuple parts
     * @return the new tuple instance
     */
	public TupleType getTupleType(String typeName, Collection<? extends TypedElement> parts,
			Map<TemplateParameter, ParameterableElement> bindings, String moniker) {
		if (moniker == null) {
			Pivot2Moniker s = new Pivot2Moniker(null);
			s.append(typeName);
			s.appendTupleType(parts);
			moniker = s.toString();
		}
		TupleType existingTupleType = findOrphanClass(TupleType.class, moniker);
		if (existingTupleType != null) {
			return existingTupleType;
		}
		TupleType tupleType = PivotFactory.eINSTANCE.createTupleType();
		tupleType.setName(typeName);
		for (TypedElement part : parts) {
			Property tuplePart = PivotFactory.eINSTANCE.createProperty();
			tuplePart.setName(part.getName());
			tuplePart.setType(getSpecializedType(part.getType(), bindings));
			tupleType.getOwnedAttributes().add(tuplePart);
		}
		tupleType.setMoniker(moniker);
		tupleType.getSuperClasses().add(getTupleType());
//		tupleType.getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)getPivotType("TupleType"));
		addOrphanClass(tupleType);
		return tupleType;
	}

	public Type getTypeWithMultiplicity(TypedMultiplicityElement element) {
		Type elementType = PivotUtil.getBehavioralType(element.getType());
		int upperBound = element.getUpper().intValue();
		boolean isMany = (upperBound < 0) || (1 < upperBound);
		if (!isMany) {
			return elementType;
		}
		boolean isOrdered = element.isOrdered();
		boolean isUnique = element.isUnique();
		Type collectionType;
		if (isOrdered) {
			if (isUnique) {
				collectionType = getOrderedSetType();
			}
			else {
				collectionType = getSequenceType();
			}
		}
		else {
			if (isUnique) {
				collectionType = getSetType();
			}
			else {
				collectionType = getBagType();
			}
		}
		return getLibraryType(collectionType, Collections.singletonList(elementType), true);
	}

	public ValueFactory getValueFactory() {
		return ValueFactory.INSTANCE;
	}

	protected void installLibrary(Library pivotLibrary) {
		String uri = pivotLibrary.getNsURI();
		if (pivotLibraries.isEmpty()) {
			if (uri == null) {
				throw new IllegalLibraryException(OCLMessages.MissingLibraryURI_ERROR_);
			}
			setDefaultStandardLibraryURI(uri);
			pivotLibraries.add(pivotLibrary);
		}
		else if (!pivotLibraries.contains(pivotLibrary)) {
			String libraryURI = getDefaultStandardLibraryURI();
			if ((uri != null) && !uri.equals(libraryURI)) {
				throw new IllegalLibraryException(NLS.bind(OCLMessages.ImportedLibraryURI_ERROR_, uri , libraryURI));
			}
			pivotLibraries.add(pivotLibrary);
		}
	}

	public void installPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		if (pivotPackage instanceof Library) {
			installLibrary((Library)pivotPackage);
		}
		addPackage(pivotPackage);
	}

	@Override
	public void installResource(Resource pivotResource) {
		for (EObject eObject : pivotResource.getContents()) {
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				org.eclipse.ocl.examples.pivot.Package pivotPackage = (org.eclipse.ocl.examples.pivot.Package)eObject;
				installPackage(pivotPackage);
//				installPackageContent(pivotPackage);
			}
		}
	}

	public boolean isAdapterForType(Object type) {
		return type == TypeManager.class;
	}

	public boolean isSuperClassOf(Type unspecializedFirstType, org.eclipse.ocl.examples.pivot.Class secondType) {
		Type unspecializedSecondType = PivotUtil.getUnspecializedTemplateableElement(secondType);
		if (unspecializedFirstType == unspecializedSecondType) {
			return true;
		}
		org.eclipse.ocl.examples.pivot.Class secondClass = (org.eclipse.ocl.examples.pivot.Class)secondType;
		for (org.eclipse.ocl.examples.pivot.Class superClass : secondClass.getSuperClasses()) {
			if (isSuperClassOf(unspecializedFirstType, superClass)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retyurn true if this type involves an UnspecifiedType.
	 */
	public boolean isUnderspecified(ParameterableElement type) {
		if (type == null) {
			return false;
		}
		if (type instanceof TemplateableElement) {
			for (TemplateBinding templateBinding : ((TemplateableElement)type).getTemplateBindings()) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
					if (isUnderspecified((Type) templateParameterSubstitution.getActual())) {
						return true;
					}
				}
			}
		}
		if (type instanceof UnspecifiedType) {
			return true;
		}
		if (type instanceof CollectionType) {
			return isUnderspecified(((CollectionType)type).getElementType());
		}
		if (type instanceof TupleType) {
			for (Property part : ((TupleType)type).getOwnedAttributes()) {
				if (isUnderspecified(part.getType())) {
					return true;
				}
			}
		}
		if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			if (isUnderspecified(lambdaType.getContextType())) {
				return true;
			}
			for (Type parameterType : lambdaType.getParameterTypes()) {
				if (isUnderspecified(parameterType)) {
					return true;
				}
			}
			if (isUnderspecified(lambdaType.getResultType())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isUnspecialized(List<TemplateParameter> templateParameters,
			List<? extends ParameterableElement> templateArguments) {
		int iMax = templateParameters.size();
		assert templateArguments.size() == iMax;
		boolean isUnspecialized = true;
		for (int i = 0; i < iMax; i++) {
			if (templateArguments.get(i) != templateParameters.get(i).getParameteredElement()) {
				isUnspecialized = false;
			}
		}
		return isUnspecialized;
	}

	@Override
	protected void lazyLoadPivotMetaModel() {
		if (!pivotLibraries.isEmpty()) {
			loadPivotMetaModel(pivotLibraries.get(0));
		}
	}

	@Override
	protected Resource loadDefaultLibrary(String uri) {
		if (!pivotLibraries.isEmpty() && (pivotLibraryResource == null)) {
			loadLibrary(pivotLibraries.get(0).eResource());
			return pivotLibraryResource;
		}
		if (uri == null) {
			return null;
		}
		StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(uri);
		if (contribution == null) {
			return null;
		}
		Resource resource = contribution.getResource();
		loadLibrary(resource);
		return resource;
	}

	public void loadLibrary(Resource pivotResource) {
		assert (pivotLibraryResource == null) || (pivotLibraryResource == pivotResource);
		if (pivotResource != null) {
			pivotLibraryResource = pivotResource;
			installResource(pivotResource);
		}
		for (org.eclipse.ocl.examples.pivot.Package rootPackage : computePivotRootPackages()) {
			if (rootPackage instanceof Library) {
				pivotLibraries.add((Library) rootPackage);
				loadLibraryPackage(rootPackage);
			}
		}
	}

	protected void loadLibraryPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackages()) {
			loadLibraryPackage(nestedPackage);
		}
		for (Type type : pivotPackage.getOwnedTypes()) {
			if (isLibraryType(type)) {
				defineLibraryType(type);
			}
		}
	}

	public Element loadResource(URI uri, String alias) {
		// if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
		// return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		Resource resource;
		URI resourceURI = uri.trimFragment();
		String resourceURIstring = resourceURI.toString();
		if (resourceURIstring.equals(defaultStandardLibraryURI)) {
			resource = loadDefaultLibrary(resourceURIstring);
		}
		else {
			StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(resourceURIstring);
			if (contribution != null) {
				resource = contribution.getResource();
			}
			else {
				External2Pivot external2Pivot = external2PivotMap.get(uri);
				if (external2Pivot != null) {
					resource = external2Pivot.getResource();
				}
				else {
					ResourceSet resourceSet = getExternalResourceSet();
					try {
						resource = resourceSet.getResource(resourceURI, true);
					}
					catch (RuntimeException e) {
						resource = resourceSet.getResource(resourceURI, false);
						if (resource != null) {
							resourceSet.getResources().remove(resource);
							resource = null;
						}
						throw e;
					}
//					if (resource != null) {
//						if (externalResources == null) {
//							externalResources = new HashMap<URI, Resource>();
//						}
//						externalResources.put(uri, resource);
//					}
					//
					//	If this resource already loaded under its internal URI reuse old one
					//
					if (resource != null) { 
						List<EObject> contents = resource.getContents();
						if (contents.size() > 0) {
							EObject firstContent = contents.get(0);
							if (firstContent instanceof EPackage) {
								String firstURI = ((EPackage)firstContent).getNsURI();
								if (firstURI != null) {
									External2Pivot external2Pivot2 = external2PivotMap.get(URI.createURI(firstURI));
									if (external2Pivot2 != null) {
										resource = external2Pivot2.getResource();
									}
								}
							}
						}
					}
				}
			}
		}
		if (resource != null) {
			for (Factory factory : factoryMap) {
				if (factory.canHandle(resource)) {
					return factory.importFromResource(this, resource, uri.fragment());
				}
			}
			throw new IllegalArgumentException("Cannot ccreate pivot from '" + uri + "'");
//			logger.warn("Cannot convert to pivot for package with URI '" + uri + "'");
		}
		logger.warn("Cannot load package with URI '" + uri + "'");
		return null;
	}

	public void notifyChanged(Notification notification) {
	}

	public void resolveSpecializationBaseClasses() {
		List<Type> orphanTypes = getOrphanPackage().getOwnedTypes();
		for (int i = 0; i < orphanTypes.size(); i++) {	// Avoids CMEs from new bases
			Type orphanType = orphanTypes.get(i);
			if (orphanType instanceof org.eclipse.ocl.examples.pivot.Class) {
				resolveSuperClasses((org.eclipse.ocl.examples.pivot.Class)orphanType);
				if (orphanType instanceof CollectionType) {
					((CollectionType)orphanType).setElementType((Type) orphanType.getTemplateBindings().get(0).getParameterSubstitutions().get(0).getActual());
				}
				else if (orphanType instanceof ClassifierType) {
					((ClassifierType)orphanType).setInstanceType((Type) orphanType.getTemplateBindings().get(0).getParameterSubstitutions().get(0).getActual());
				}
			}
		}
	}

	/**
	 * Update a specializedClass so that its superclasses correspond to the specializations
	 * of the specializations of the superclasses of the class that specializedClass specializes. 

	 * @param specializedClass to update superclasses of
	 */
	public void resolveSuperClasses(org.eclipse.ocl.examples.pivot.Class specializedClass) {
		List<org.eclipse.ocl.examples.pivot.Class> oldSuperClasses = specializedClass.getSuperClasses();
		if (oldSuperClasses.size() > 0) {
			return;
		}
		org.eclipse.ocl.examples.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(specializedClass);
		if (unspecializedType == null) {
			return;							// LambdaType
		}
		Map<TemplateParameter, ParameterableElement> specializedBindings = PivotUtil.getAllTemplateParameterSubstitutions(null, specializedClass);
		List<org.eclipse.ocl.examples.pivot.Class> newSuperClasses = new ArrayList<org.eclipse.ocl.examples.pivot.Class>();
		for (org.eclipse.ocl.examples.pivot.Class unspecializedSuper : unspecializedType.getSuperClasses()) {
			List<ParameterableElement> templateArguments = null;
			List<TemplateBinding> unboundSuperTemplateBindings = unspecializedSuper.getTemplateBindings();
			if (unboundSuperTemplateBindings.size() > 0) {					
				Map<TemplateParameter, ParameterableElement> superBindings = PivotUtil.getAllTemplateParameterSubstitutions(null, unspecializedSuper);
				List<TemplateParameter> unspecializedSuperTemplateParameters = PivotUtil.getAllTemplateParameters(unboundSuperTemplateBindings);
				templateArguments = new ArrayList<ParameterableElement>(unspecializedSuperTemplateParameters.size());
				for (TemplateParameter unspecializedSuperTemplateParameter : unspecializedSuperTemplateParameters) {
					ParameterableElement templateArgument = null;
					if (superBindings != null) {
						ParameterableElement unspecializedActual = superBindings.get(unspecializedSuperTemplateParameter);
						if (unspecializedActual != null) {
							TemplateParameter unspecializedFormal = unspecializedActual.getOwningTemplateParameter();
							if ((unspecializedFormal != null) && (specializedBindings != null)) {
								templateArgument = specializedBindings.get(unspecializedFormal);
							}
						}
					}
					if (templateArgument == null) {
						templateArgument = unspecializedSuperTemplateParameter.getParameteredElement();
					}
					templateArguments.add(templateArgument);
				}								
			}
			org.eclipse.ocl.examples.pivot.Class unspecializedSuperType = PivotUtil.getUnspecializedTemplateableElement(unspecializedSuper);
			org.eclipse.ocl.examples.pivot.Class specializedSuperType = getLibraryType(unspecializedSuperType, templateArguments, false);	// FIXME This is sole false call
			if ((specializedSuperType != null) && !newSuperClasses.contains(specializedSuperType)) {
				newSuperClasses.add(specializedSuperType);
			}
		}
		PivotUtil.refreshList(oldSuperClasses, newSuperClasses);
	}

	// FIXME Lose this duplication
	public void resolveSuperClasses(org.eclipse.ocl.examples.pivot.Class specializedClass,
			org.eclipse.ocl.examples.pivot.Class libraryClass, Map<TemplateParameter, ParameterableElement> allBindings) {
		for (org.eclipse.ocl.examples.pivot.Class superClass : libraryClass.getSuperClasses()) {
			List<ParameterableElement> superTemplateArguments = null;
			List<TemplateBinding> superTemplateBindings = superClass.getTemplateBindings();
			if (superTemplateBindings.size() > 0) {
				superTemplateArguments = new ArrayList<ParameterableElement>();
				for (TemplateBinding superTemplateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution superTemplateParameterSubstitution : superTemplateBinding.getParameterSubstitutions()) {
						ParameterableElement superActual = superTemplateParameterSubstitution.getActual();
						ParameterableElement actualActual = allBindings.get(superActual.getTemplateParameter());
						superTemplateArguments.add(actualActual);
					}
				}
			}
			org.eclipse.ocl.examples.pivot.Class unspecializedSuperClass = PivotUtil.getUnspecializedTemplateableElement(superClass);
			specializedClass.getSuperClasses().add(getLibraryType(unspecializedSuperClass, superTemplateArguments, true));
		}
	}

	public Operation resolveOperation(Type leftType, String operationName, Type... rightTypes) {
		if (!(leftType instanceof org.eclipse.ocl.examples.pivot.Class)) {
			return null;
		}
		Set<Operation> candidateOperations = resolveOperations(
			(org.eclipse.ocl.examples.pivot.Class) leftType, operationName,
			rightTypes);
		if (candidateOperations == null) {
			return null;
		}
		if (candidateOperations.size() > 1) {
			logger.warn("Ambiguous operation '" + operationName + "'");
		}
		return candidateOperations.iterator().next();
	}

	public Set<Operation> resolveOperations(org.eclipse.ocl.examples.pivot.Class pivotClass,
			String operationName, Type... pivotArguments) {
		@SuppressWarnings("unused")
		Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, pivotClass);
		Set<Operation> pivotOperations = resolveLocalOperation(pivotClass, operationName, pivotArguments);
		for (TemplateBinding templateBinding : pivotClass.getTemplateBindings()) {
			TemplateSignature signature = templateBinding.getSignature();
			TemplateableElement template = signature.getTemplate();
			if (template instanceof org.eclipse.ocl.examples.pivot.Class) {
				Set<Operation> morePivotOperations = resolveLocalOperation((org.eclipse.ocl.examples.pivot.Class) template,
					operationName, pivotArguments);
				if (morePivotOperations != null) {
					if (pivotOperations == null) {
						pivotOperations = morePivotOperations;
					}
					else {
						pivotOperations.addAll(morePivotOperations);
					}
				}
			}
		}
		if (pivotOperations == null) {
			List<org.eclipse.ocl.examples.pivot.Class> superClasses = pivotClass.getSuperClasses();
			if (!superClasses.isEmpty()) {
				for (org.eclipse.ocl.examples.pivot.Class superClass : superClasses) {
					Set<Operation> superOperations = resolveOperations(superClass,
						operationName, pivotArguments);
					if (superOperations != null) {
						if (pivotOperations == null) {
							pivotOperations = superOperations;
						} else {
							pivotOperations.addAll(superOperations);
						}
					}
				}
			}
			else {
				AnyType oclAnyType = getOclAnyType();
				if (pivotClass != oclAnyType) {		// Typically a template parameter type
					pivotOperations = resolveOperations(oclAnyType, operationName, pivotArguments);
				}
			}
		}
		return pivotOperations;
	}

	/**
	 * Add a resource-specific map of elements to preferred aliases, updating
	 * the internal pivot-resource-set-wide map of elements to pivot-aliases
	 * and vice-versa.
	 * <b>
	 * Note that pivot aliases are unique and used only for monikers.
	 * 
	 * @param resource
	 * @param newAliasMap
	 * @return
	 *
	public Map<Element, String> putAliasMap(Resource resource, Map<Element, String> newAliasMap) {
		Map<Element, String> oldAliasMap = aliasMaps.put(resource, newAliasMap);
		if (oldAliasMap != null) {
			for (Element key : oldAliasMap.keySet()) {
				pivot2alias.remove(key);
				alias2pivot.remove(key);
			}
		}
		if (newAliasMap != null) {
			for (Element key : newAliasMap.keySet()) {
				String baseString = newAliasMap.get(key);
				String alias = PivotConstants.MONIKER_SCOPE_SEPARATOR + baseString;
				int index = 0;
				while (alias2pivot.containsKey(alias)) {
					alias = PivotConstants.MONIKER_SCOPE_SEPARATOR + index++ + PivotConstants.MONIKER_OPERATOR_SEPARATOR + baseString;
				}
				pivot2alias.put(key, alias);
				alias2pivot.put(alias, key);
			}
		}
		return oldAliasMap;
	} */

	public Set<Operation> resolveLocalOperation(org.eclipse.ocl.examples.pivot.Class pivotClass,
			String operationName, Type... pivotArguments) {
		Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = null; 	// FIXME
		Set<Operation> pivotOperations = null;
		for (Operation pivotOperation : pivotClass.getOwnedOperations()) {
			if (operationName.equals(pivotOperation.getName())) {
				List<Parameter> pivotParameters = pivotOperation.getOwnedParameters();
				if (pivotArguments.length == pivotParameters.size()) {
					boolean typesConform = true;
					for (int i = 0; i < pivotArguments.length; i++) {
						Type argumentType = pivotArguments[i];
						Parameter pivotParameter = pivotParameters.get(i);
						Type parameterType = getTypeWithMultiplicity(pivotParameter);
						if (parameterType instanceof SelfType) {
							parameterType = pivotOperation.getClass_();
						}
						if (!conformsTo(argumentType, parameterType, templateParameterSubstitutions)) {
							typesConform = false;
							break;
						}
					}
					if (typesConform) {
						if (pivotOperations == null) {
							pivotOperations = new HashSet<Operation>();
						}
						pivotOperations.add(pivotOperation);
					}
				}
			}
		}
		return pivotOperations;
	}

	public void setDefaultStandardLibraryURI(String defaultStandardLibraryURI) {
		this.defaultStandardLibraryURI = defaultStandardLibraryURI;
	}

	public void setTarget(Notifier newTarget) {
		assert newTarget == pivotResourceSet;
	}
}