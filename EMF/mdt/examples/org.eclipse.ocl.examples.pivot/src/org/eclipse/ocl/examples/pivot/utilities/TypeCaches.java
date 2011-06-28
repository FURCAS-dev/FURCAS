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
 * $Id: TypeCaches.java,v 1.10 2011/05/22 16:42:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;

import com.google.common.collect.Iterables;

public abstract class TypeCaches extends PivotStandardLibrary
{		
	private static final Logger logger = Logger.getLogger(TypeCaches.class);

	public class CompleteClassOperationsIterable
			extends CompleteElementIterable<org.eclipse.ocl.examples.pivot.Class, Operation>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static
		
		public CompleteClassOperationsIterable(Iterable<org.eclipse.ocl.examples.pivot.Class> classes, Boolean selectStatic) {
			super(classes);
			this.selectStatic = selectStatic;
		}

		@Override
		protected Iterable<Operation> getInnerIterable(org.eclipse.ocl.examples.pivot.Class model) {
			return model.getOwnedOperations();
		}

		@Override
		protected Operation getInnerValue(Operation element) {
			if (selectStatic != null) {
				if (element.isStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}
	
	public class CompleteClassPropertiesIterable
			extends CompleteElementIterable<org.eclipse.ocl.examples.pivot.Class, Property>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static
		
		public CompleteClassPropertiesIterable(Iterable<org.eclipse.ocl.examples.pivot.Class> classes, Boolean selectStatic) {
			super(classes);
			this.selectStatic = selectStatic;
		}

		@Override
		protected Iterable<Property> getInnerIterable(org.eclipse.ocl.examples.pivot.Class model) {
			return model.getOwnedAttributes();
		}

		@Override
		protected Property getInnerValue(Property element) {
			if (selectStatic != null) {
				if (element.isStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}
	
	public class CompleteClassSuperClassesIterable
			extends CompleteElementIterable<org.eclipse.ocl.examples.pivot.Class, org.eclipse.ocl.examples.pivot.Class> {

		public CompleteClassSuperClassesIterable(Iterable<org.eclipse.ocl.examples.pivot.Class> types) {
			super(types);
		}

		@Override
		protected Iterable<org.eclipse.ocl.examples.pivot.Class> getInnerIterable(org.eclipse.ocl.examples.pivot.Class model) {
			return model.getSuperClasses();
		}
	}

	public class CompleteElementConstraintsIterable
			extends CompleteElementIterable<NamedElement, Constraint> {

		public CompleteElementConstraintsIterable(Iterable<? extends NamedElement> models) {
			super(models);
		}

		@Override
		protected Iterable<Constraint> getInnerIterable(NamedElement model) {
			return model.getOwnedRules();
		}
	}

	public class CompletePackagePackagesIterable
		extends CompleteElementIterable<org.eclipse.ocl.examples.pivot.Package, org.eclipse.ocl.examples.pivot.Package> {
		
		public CompletePackagePackagesIterable(Iterable<org.eclipse.ocl.examples.pivot.Package> packages) {
			super(packages);
		}
		
		@Override
		protected Iterable<org.eclipse.ocl.examples.pivot.Package> getInnerIterable(org.eclipse.ocl.examples.pivot.Package model) {
			return model.getNestedPackages();
		}
	}
	
	public class CompletePackageTypesIterable
		extends CompleteElementIterable<org.eclipse.ocl.examples.pivot.Package, Type> {
		
		public CompletePackageTypesIterable(Iterable<org.eclipse.ocl.examples.pivot.Package> packages) {
			super(packages);
		}
		
		@Override
		protected Iterable<Type> getInnerIterable(org.eclipse.ocl.examples.pivot.Package model) {
			return model.getOwnedTypes();
		}
	}

	private static abstract class AbstractTracker<T extends Notifier> implements TypeManagedAdapter
	{
		public static void uninstall(TypeCaches typeCaches, Notifier value) {
			if (value != null) {
				Adapter tracker = EcoreUtil.getAdapter(value.eAdapters(), typeCaches);
				if (tracker != null) {
					((AbstractTracker<?>)tracker).dispose();
//					typeCaches.debugRemoveAdapter(tracker);
				}
			}
		}

		
		protected TypeCaches typeCaches;
		protected T target;
//		private int debugCount;
		
		protected AbstractTracker(TypeCaches typeCaches, T target) {
			this.typeCaches = typeCaches;
			this.target = target;
//			debugCount = typeCaches.debugAddAdapter(this);
			target.eAdapters().add(this);
//			System.out.println(debugCount + ": ctor " + target + " " + typeCaches);
		}		

		public abstract void dispose();

		public T getTarget() {
			return target;
		}

		public boolean isAdapterFor(TypeManager typeManager) {
			return typeCaches == typeManager;
		}
		
		public final boolean isAdapterForType(Object type) {
			return type == typeCaches;
		}

		public void setTarget(Notifier newTarget) {
			assert target == newTarget;
		}

		public void unsetTarget(Notifier oldTarget) {
//			System.out.println(debugCount + ": unset " + oldTarget + " " + typeCaches);
			assert target == oldTarget;
			target = null;
		}
	}

	private static class PackageTracker extends AbstractTracker<org.eclipse.ocl.examples.pivot.Package>
	{
		public static PackageTracker install(TypeCaches typeCaches, org.eclipse.ocl.examples.pivot.Package target) {
//			assert target.eAdapters().size() < 4;		// FIXME Debugging
			Adapter tracker = EcoreUtil.getAdapter(target.eAdapters(), typeCaches);
			if (tracker != null) {
				return (PackageTracker)tracker;
			}
			else {
				return new PackageTracker(typeCaches, target);
			}
		}
		
		private PackageTracker(TypeCaches typeCaches, org.eclipse.ocl.examples.pivot.Package target) {
			super(typeCaches, target);
			installPackageContent(target);
		}		

		@Override
		public void dispose() {
			if (target != null) {
				typeCaches.package2packages.remove(target.getMoniker());
			}
			target.eAdapters().remove(this);
		}

		private void installPackageContent(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
			for (Type pivotType : pivotPackage.getOwnedTypes()) {
				if (pivotType instanceof org.eclipse.ocl.examples.pivot.Class) {
					typeCaches.addClass((org.eclipse.ocl.examples.pivot.Class)pivotType);
				}
			}
			for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackages()) {
				installPackageContent(nestedPackage);
			}
		}

		public void notifyChanged(Notification notification) {
			int eventType = notification.getEventType();
			Object feature = notification.getFeature();
			if (feature == PivotPackage.Literals.PACKAGE__OWNED_TYPE) {
				switch (eventType) {
					case Notification.ADD: {
						Object value = notification.getNewValue();
						if (value instanceof org.eclipse.ocl.examples.pivot.Class) {
							typeCaches.addClass((org.eclipse.ocl.examples.pivot.Class)value);
						}
						break;
					}
					case Notification.ADD_MANY: {
						@SuppressWarnings("unchecked")
						List<Object> values = (List<Object>)notification.getNewValue();
						for (Object value : values) {
							if (value instanceof org.eclipse.ocl.examples.pivot.Class) {
								typeCaches.addClass((org.eclipse.ocl.examples.pivot.Class)value);
							}
						}
						break;
					}
					case Notification.REMOVE: {
						Object value = notification.getOldValue();
						if (value instanceof org.eclipse.ocl.examples.pivot.Class) {
							uninstall(typeCaches, (org.eclipse.ocl.examples.pivot.Class)value);
							typeCaches.removeClass((org.eclipse.ocl.examples.pivot.Class)value);
						}
						break;
					}
					case Notification.REMOVE_MANY: {
						@SuppressWarnings("unchecked")
						List<Object> values = (List<Object>)notification.getOldValue();
						for (Object value : values) {
							if (value instanceof org.eclipse.ocl.examples.pivot.Class) {
								uninstall(typeCaches, (org.eclipse.ocl.examples.pivot.Class)value);
								typeCaches.removeClass((org.eclipse.ocl.examples.pivot.Class)value);
							}
						}
						break;
					}
				}
			}
			else if (feature == PivotPackage.Literals.PACKAGE__NESTED_PACKAGE) {
				switch (eventType) {
					case Notification.ADD: {
						Object value = notification.getNewValue();
						typeCaches.addPackage((org.eclipse.ocl.examples.pivot.Package)value);
						break;
					}
					case Notification.REMOVE: {
						Object value = notification.getOldValue();
						typeCaches.removePackage((org.eclipse.ocl.examples.pivot.Package)value);
						uninstall(typeCaches, (org.eclipse.ocl.examples.pivot.Package)value);
						break;
					}
				}
			}
		}
	}

	private static class ClassTracker extends AbstractTracker<org.eclipse.ocl.examples.pivot.Class>
	{
		public static ClassTracker install(TypeCaches typeCaches, org.eclipse.ocl.examples.pivot.Class target) {
			Adapter tracker = EcoreUtil.getAdapter(target.eAdapters(), typeCaches);
			if (tracker != null) {
				return (ClassTracker)tracker;
			}
			else {
				return new ClassTracker(typeCaches, target);
			}
		}
		
		private ClassTracker(TypeCaches typeCaches, org.eclipse.ocl.examples.pivot.Class target) {
			super(typeCaches, target);
			for (Operation pivotOperation : target.getOwnedOperations()) {
				typeCaches.addOperation(pivotOperation);
			}
			for (Property pivotProperty : target.getOwnedAttributes()) {
				typeCaches.addProperty(pivotProperty);
			}
		}		

		@Override
		public void dispose() {
			if (target != null) {
				typeCaches.removeClass(target);
				target.eAdapters().remove(this);
			}
		}

		public void notifyChanged(Notification notification) {
			int eventType = notification.getEventType();
			Object feature = notification.getFeature();
			if (feature == PivotPackage.Literals.CLASS__OWNED_OPERATION) {
				switch (eventType) {
					case Notification.ADD: {
						Object value = notification.getNewValue();
						typeCaches.addOperation((Operation)value);
						break;
					}
					case Notification.ADD_MANY: {
						@SuppressWarnings("unchecked")
						List<Object> values = (List<Object>)notification.getNewValue();
						for (Object value : values) {
							typeCaches.addOperation((Operation)value);
						}
						break;
					}
					case Notification.REMOVE: {
						Object value = notification.getOldValue();
						typeCaches.removeOperation((Operation)value);
						break;
					}
					case Notification.REMOVE_MANY: {
						@SuppressWarnings("unchecked")
						List<Object> values = (List<Object>)notification.getOldValue();
						for (Object value : values) {
							typeCaches.removeOperation((Operation)value);
						}
						break;
					}
				}
			}
			else if (feature == PivotPackage.Literals.CLASS__OWNED_ATTRIBUTE) {
				switch (eventType) {
					case Notification.ADD: {
						Object value = notification.getNewValue();
						typeCaches.addProperty((Property)value);
						break;
					}
					case Notification.ADD_MANY: {
						@SuppressWarnings("unchecked")
						List<Object> values = (List<Object>)notification.getNewValue();
						for (Object value : values) {
							typeCaches.addProperty((Property)value);
						}
						break;
					}
					case Notification.REMOVE: {
						Object value = notification.getOldValue();
						typeCaches.removeProperty((Property)value);
						break;
					}
					case Notification.REMOVE_MANY: {
						@SuppressWarnings("unchecked")
						List<Object> values = (List<Object>)notification.getOldValue();
						for (Object value : values) {
							typeCaches.removeProperty((Property)value);
						}
						break;
					}
				}
			}
		}
	}
	
	public static class OrphanNode
	{
		protected final MonikeredElement element;
		protected Set<OrphanNode> dependencies = null;
		
		public OrphanNode(MonikeredElement element) {
			this.element = element;
		}

		public void addDependency(OrphanNode orphanNode) {
			if (dependencies == null) {
				dependencies = new HashSet<OrphanNode>();
			}
			dependencies.add(orphanNode);
		}

		public void dispose() {
			if (dependencies !=  null) {
				dependencies.clear();
				dependencies = null;
			}
		}
		
		/**
		 * Return the set of all orphans in cluding this one that depend on this element.
		 */
		public Set<OrphanNode> getAllDependencies(Set<OrphanNode> orphans) {
			if (orphans == null) {
				orphans = new HashSet<OrphanNode>();
				orphans.add(this);
			}
			if (dependencies != null) {
				for (OrphanNode orphan : dependencies) {
					if (orphans.add(orphan)) {
						orphan.getAllDependencies(orphans);
					}
				}
			}
			return orphans;
		}

		public MonikeredElement getElement() {
			return element;
		}
		
		@Override
		public String toString() {
			return "<orphan-node> " + element.getMoniker();
		}
	}
	
	/**
	 * Mapping from moniker to the OrphanNode that supervises orphan dependencies on
	 * the monikered element.
	 */
	private Map<String, OrphanNode> moniker2orphan = new HashMap<String, OrphanNode>();
	
	/**
	 * Map from package URI to package moniker. 
	 */
	private Map<String, String> uri2package = new HashMap<String, String>();
	
	/**
	 * Map from package moniker to the package or a list of packages to be treated as merged. 
	 */
	private Map<String, Iterable<org.eclipse.ocl.examples.pivot.Package>> package2packages
		= new HashMap<String, Iterable<org.eclipse.ocl.examples.pivot.Package>>();

	/**
	 * Map from property moniker to the property or a list of properties to be treated as merged. 
	 */
	private Map<String, Iterable<Property>> property2properties =
			new HashMap<String, Iterable<Property>>();

	/**
	 * Map from operation moniker to the operation or a list of operations to be treated as merged. 
	 */
	private Map<String, Iterable<Operation>> operation2operations =
			new HashMap<String, Iterable<Operation>>();

	/**
	 * Map from type moniker to the type or a list of types to be treated as merged. 
	 */
	private Map<String, Iterable<org.eclipse.ocl.examples.pivot.Class>> class2classes =
			new HashMap<String, Iterable<org.eclipse.ocl.examples.pivot.Class>>();

	/**
	 * Map from type moniker to map of operation moniker to operation. 
	 */
	private Map<String, Map<String, Operation>> type2operation2operation =
			new HashMap<String, Map<String, Operation>>();
	
	/**
	 * The package used as a container for orphan (specialized) classes
	 */
	private org.eclipse.ocl.examples.pivot.Package orphanagePackage = null;
	
	/**
	 * The class used as a container for orphan (specialized) operations
	 */
	private org.eclipse.ocl.examples.pivot.Class orphanageClass = null;

	protected org.eclipse.ocl.examples.pivot.Package pivotMetaModel = null;
	
	private void addClass(org.eclipse.ocl.examples.pivot.Class pivotClass) {
		if ((pivotClass instanceof LambdaType) || (pivotClass instanceof TupleType)) {	// FIXME parent not necessarily in place
			return;
		}
		String moniker = pivotClass.getMoniker();
		Iterable<org.eclipse.ocl.examples.pivot.Class> iterable = class2classes.get(moniker);
		if (iterable == null) {
			class2classes.put(moniker, pivotClass);
			ClassTracker.install(this, pivotClass);
		}
		else if (iterable instanceof org.eclipse.ocl.examples.pivot.Class) {
			if (iterable != pivotClass) {
				List<org.eclipse.ocl.examples.pivot.Class> iterables = new ArrayList<org.eclipse.ocl.examples.pivot.Class>();
				iterables.add((org.eclipse.ocl.examples.pivot.Class)iterable);
				iterables.add(pivotClass);
				class2classes.put(moniker, iterables);
				ClassTracker.install(this, pivotClass);
			}
			else {
				logger.warn("Duplicate addition of " + pivotClass);
			}
		}
		else if (iterable instanceof List<?>) {
			List<org.eclipse.ocl.examples.pivot.Class> iterables = (List<org.eclipse.ocl.examples.pivot.Class>)iterable;
			if (!iterables.contains(pivotClass)) {
				iterables.add(pivotClass);
			}
			else {
				logger.warn("Duplicate addition of " + pivotClass);
			}
		}
		else {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
	}

	private void addOperation(Operation pivotOperation) {
		String moniker = pivotOperation.getMoniker();
		Iterable<Operation> iterable = operation2operations.get(moniker);
		if (iterable == null) {
			operation2operations.put(moniker, pivotOperation);
		}
		else if (iterable instanceof Operation) {
			if (iterable != pivotOperation) {
				List<Operation> iterables = new ArrayList<Operation>();
				iterables.add((Operation)iterable);
				iterables.add(pivotOperation);
				operation2operations.put(moniker, iterables);
			}
			else {
				logger.warn("Duplicate addition of " + pivotOperation);
			}
		}
		else if (iterable instanceof List<?>) {
			List<Operation> iterables = (List<Operation>)iterable;
			if (!iterables.contains(pivotOperation)) {
				iterables.add(pivotOperation);
			}
			else {
				logger.warn("Duplicate addition of " + pivotOperation);
			}
		}
		else {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
	}
	
	public void addOrphanClass(Type pivotElement) {
		if (pivotElement.getUnspecializedElement() != null) {
			assert pivotElement.getUnspecializedElement().getUnspecializedElement() == null;
		}
		else {
			assert (pivotElement instanceof LambdaType)
				|| (pivotElement instanceof TupleType)
				|| (pivotElement instanceof UnspecifiedType);
		}
		List<TemplateBinding> templateBindings = pivotElement.getTemplateBindings();
		if (templateBindings.size() == 1) {
			List<TemplateParameterSubstitution> parameterSubstitutions = templateBindings.get(0).getParameterSubstitutions();
			if (parameterSubstitutions.size() == 1) {
				TemplateParameterSubstitution parameterSubstitution = parameterSubstitutions.get(0);
				assert parameterSubstitution.getActual().eContainer() != parameterSubstitution.getFormal();
			}
		}
		assert pivotElement.hasMoniker();
		org.eclipse.ocl.examples.pivot.Package orphans = getOrphanPackage();
		orphans.getOwnedTypes().add(pivotElement);
//		System.out.println("add-orphan " + pivotElement.eClass().getName() + "@" + Integer.toHexString(pivotElement.hashCode()) + " " + pivotElement.getMoniker());
//		if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Class) {
//			addType((org.eclipse.ocl.examples.pivot.Class)pivotElement);
//		}
		getOrphanNode(pivotElement);
	}

	public void addPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String moniker = pivotPackage.getMoniker();
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {
			@SuppressWarnings("unused")
			String existingMoniker = uri2package.put(nsURI, moniker);
//			assert (existingMoniker == null) || existingMoniker.equals(moniker) : "Duplicate package for '" + nsURI + "'";
		}
		Iterable<org.eclipse.ocl.examples.pivot.Package> iterable = package2packages.get(moniker);
		if (iterable == null) {
			package2packages.put(moniker, pivotPackage);
			PackageTracker.install(this, pivotPackage);
		}
		else if (iterable instanceof org.eclipse.ocl.examples.pivot.Package) {
			if (iterable != pivotPackage) {
				List<org.eclipse.ocl.examples.pivot.Package> iterables = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
				iterables.add((org.eclipse.ocl.examples.pivot.Package)iterable);
				iterables.add(pivotPackage);
				package2packages.put(moniker, iterables);
				PackageTracker.install(this, pivotPackage);
			}
//			else {
//				logger.warn("Duplicate addition of " + pivotPackage);
//			}
		}
		else if (iterable instanceof List<?>) {
			List<org.eclipse.ocl.examples.pivot.Package> iterables = (List<org.eclipse.ocl.examples.pivot.Package>)iterable;
			if (!iterables.contains(pivotPackage)) {
				iterables.add(pivotPackage);
				PackageTracker.install(this, pivotPackage);
			}
//			else {
//				logger.warn("Duplicate addition of " + pivotPackage);
//			}
		}
		else {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
	}

	private void addProperty(Property pivotProperty) {
		String moniker = pivotProperty.getMoniker();
		Iterable<Property> iterable = property2properties.get(moniker);
		if (iterable == null) {
			property2properties.put(moniker, pivotProperty);
		}
		else if (iterable instanceof Property) {
			if (iterable != pivotProperty) {
				List<Property> iterables = new ArrayList<Property>();
				iterables.add((Property)iterable);
				iterables.add(pivotProperty);
				property2properties.put(moniker, iterables);
			}
			else {
				logger.warn("Duplicate addition of " + pivotProperty);
			}
		}
		else if (iterable instanceof List<?>) {
			List<Property> iterables = (List<Property>)iterable;
			if (!iterables.contains(pivotProperty)) {
				iterables.add(pivotProperty);
			}
			else {
				logger.warn("Duplicate addition of " + pivotProperty);
			}
		}
		else {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
	}

	public Map<String, MonikeredElement> computeMoniker2PivotMap(
			Collection<? extends Resource> pivotResources) {
		Map<String, MonikeredElement> map = new HashMap<String, MonikeredElement>();
		for (Resource pivotResource : pivotResources) {
			for (Iterator<EObject> it = pivotResource.getAllContents(); it.hasNext();) {
				EObject eObject = it.next();
				assert eObject.eResource() == pivotResource;
				if ((eObject instanceof MonikeredElement) && (eObject != orphanagePackage)) {
					MonikeredElement newElement = (MonikeredElement) eObject;
					String moniker = newElement.getMoniker();
					assert moniker != null;
					MonikeredElement oldElement = map.get(moniker);
					if (oldElement == null) {
						map.put(moniker, newElement);
					}
					else {
						boolean newIsInOrphanage = isInOrphanage(newElement);
						boolean oldIsInOrphanage = isInOrphanage(oldElement);
						if (!newIsInOrphanage && !oldIsInOrphanage) {
							assert newElement.getClass() == oldElement.getClass();
//							assert (newElement instanceof org.eclipse.ocl.examples.pivot.Package)
//								|| (newElement instanceof org.eclipse.ocl.examples.pivot.Class)
//								|| (newElement instanceof Feature)
//								|| (newElement instanceof Parameter);
						}
						else if (newIsInOrphanage && !oldIsInOrphanage) {
							map.put(moniker, newElement);
						}
						else {
							assert oldIsInOrphanage != newIsInOrphanage;
						}
					}
				}
			}
		}
		return map;
	}

	protected abstract Resource createOrphanage(URI uri);
	
/*	@Override
	public CompletePackage getCompletePackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		CompletePackage completePackage = completePackageMap.get(pkg);
		if (completePackage != null) {
			return completePackage;
		}
		if (pkg instanceof CompletePackage) {
			return (CompletePackage)pkg;
		}
		if (pkg == null) {
			logger.warn("getCompletePackage for null");
			return null;
		}
		CompletePackage nestingCompletePackage;
		org.eclipse.ocl.examples.pivot.Package nestingPackage = pkg.getNestingPackage();
		if (nestingPackage == null) {
			nestingCompletePackage = rootCompletePackage;
		}
		else {
			nestingCompletePackage = getCompletePackage(nestingPackage);
		}
		completePackage = PivotUtil.getNamedElement(nestingCompletePackage.getCompletePackages(), pkg.getName());
		if (completePackage == null) {
			completePackage = PivotFactory.eINSTANCE.createCompletePackage();
			completePackage.setCompleteEnvironment(this);
			completePackage.setName(pkg.getName());
			completePackage.setNestingPackage(nestingCompletePackage);
		}
		addPackage(pkg);
		return completePackage;
	} */

//	public int debugAddAdapter(Adapter adapter) {
//		debugAdapters.add(adapter);
//		return debugAdapters.size();
//	}

//	public void debugRemoveAdapter(Adapter adapter) {
//		assert debugAdapters.remove(adapter);
//	}

	public void dispose() {
		if (package2packages != null) {
			ArrayList<Iterable<org.eclipse.ocl.examples.pivot.Package>> packages
				= new ArrayList<Iterable<org.eclipse.ocl.examples.pivot.Package>>(package2packages.values());
			for (Iterable<org.eclipse.ocl.examples.pivot.Package> pivotPackages : packages) {
				for (org.eclipse.ocl.examples.pivot.Package pivotPackage : pivotPackages) {
					AbstractTracker.uninstall(this, pivotPackage);
				}
			}
			package2packages.clear();
			package2packages = null;
		}
		if (class2classes != null) {
			ArrayList<Iterable<org.eclipse.ocl.examples.pivot.Class>> classes
				= new ArrayList<Iterable<org.eclipse.ocl.examples.pivot.Class>>(class2classes.values());
			for (Iterable<org.eclipse.ocl.examples.pivot.Class> pivotClasses : classes) {
				ArrayList<org.eclipse.ocl.examples.pivot.Class> pivotClasses2
				= new ArrayList<org.eclipse.ocl.examples.pivot.Class>();
				Iterables.addAll(pivotClasses2, pivotClasses);
				for (org.eclipse.ocl.examples.pivot.Class pivotClass : pivotClasses2) {
					AbstractTracker.uninstall(this, pivotClass);
				}
			}
			class2classes.clear();
			class2classes = null;
		}
		if (property2properties != null) {
			property2properties.clear();
			property2properties = null;
		}
		if (operation2operations != null) {
			operation2operations.clear();
			operation2operations = null;
		}
		if (type2operation2operation != null) {
			type2operation2operation.clear();
			type2operation2operation = null;
		}
//		assert debugAdapters.isEmpty();
	}
	
	private Set<Iteration> findModelIterationsOrNull(Type type,
			String operationName, List<Type> staticCompleteIteratorTypes,
			List<Type> staticCompleteAccumulatorTypes, List<Type> staticCompleteParameterTypes) {
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, type);
		int staticIteratorsSize = staticCompleteIteratorTypes.size();
		Set<Iteration> list = null;
		for (Iteration modelIteration : getLocalModelIterations(type, operationName)) {
//			Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions2 = PivotUtil.getAllTemplateParameterSubstitutions(null, dynamicIteration.getModel());
			List<Parameter> modelIterators = modelIteration.getOwnedIterators();
			if (staticIteratorsSize == modelIterators.size()) {
				boolean gotIt = true;
				for (int i = 0; i < staticIteratorsSize; i++) {
					Type staticCompleteIteratorType = staticCompleteIteratorTypes.get(i);
					Parameter modelIterator = modelIterators.get(i);
					Type dynamicCompleteIteratorType = getSpecializedType(modelIterator.getType(), bindings);
					if (!conformsTo(dynamicCompleteIteratorType, staticCompleteIteratorType, null)) {
						gotIt = false;
					}
				}
				if (gotIt) {
					if (list == null) {
						list = new HashSet<Iteration>();
					}
					list.add(modelIteration);
				}
			}
		}
		if (list == null) {
			for (Type completeSuperType : getSuperClasses(type)) {
				Set<Iteration> superIterations = findModelIterationsOrNull(
					completeSuperType, operationName, staticCompleteIteratorTypes,
					staticCompleteAccumulatorTypes, staticCompleteParameterTypes);
				if (superIterations != null) {
					if (list == null) {
						list = superIterations;
					} else {
						list.addAll(superIterations);
					}
				}
			}
		}
		return list;
	}

	private Set<Operation> findModelOperationsOrNull(Type type,
			String operationName, List<Type> staticCompleteTypes, Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions) {
		int staticParametersSize = staticCompleteTypes.size();
		Set<Operation> list = null;
		for (Operation modelOperation : getLocalModelOperations(type, operationName)) {
			Map<TemplateParameter, ParameterableElement> bindings = null; //PivotUtil.getAllTemplateParametersAsBindings(modelOperation);
			List<Parameter> modelParameters = modelOperation.getOwnedParameters();
			if (staticParametersSize == modelParameters.size()) {
				boolean gotIt = true;
				for (int i = 0; i < staticParametersSize; i++) {
					Type staticCompleteType = staticCompleteTypes.get(i);
					Parameter modelParameter = modelParameters.get(i);
					Type dynamicCompleteType = getSpecializedType(modelParameter.getType(), templateParameterSubstitutions);
					if (!conformsTo(dynamicCompleteType, staticCompleteType, bindings)) {
						gotIt = false;
					}
				}
				if (gotIt) {
					if (list == null) {
						list = new HashSet<Operation>();
					}
					list.add(modelOperation);
				}
			}
		}
		if (list == null) {
			for (Type completeSuperType : getSuperClasses(type)) {
				Set<Operation> superOperations = findModelOperationsOrNull(
					completeSuperType, operationName, staticCompleteTypes, templateParameterSubstitutions);
				if (superOperations != null) {
					if (list == null) {
						list = superOperations;
					} else {
						list.addAll(superOperations);
					}
				}
			}
		}
		return list;
	}

	public <T extends Type> T findOrphanClass(Class<T> unspecializedType, String moniker) {		
		List<Type> ownedSpecializations = getOrphanPackage().getOwnedTypes();
		for (Type ownedSpecialization : ownedSpecializations) {
			if (ownedSpecialization.getMoniker().equals(moniker)) {
				@SuppressWarnings("unchecked")
				T castSpecialization = (T)ownedSpecialization;	// FIXME validate
				return castSpecialization;
			}
		}
		return null;
	}

	protected <T extends Operation> T findOrphanOperation(Class<T> unspecializedOperation, String moniker) {
		List<Operation> ownedSpecializations = getOrphanClass().getOwnedOperations();
		for (Operation ownedSpecialization : ownedSpecializations) {
			if (ownedSpecialization.getMoniker().equals(moniker)) {
				@SuppressWarnings("unchecked")
				T castSpecialization = (T)ownedSpecialization;	// FIXME validate
				return castSpecialization;
			}
		}
		return null;
	}

	public Iterable<org.eclipse.ocl.examples.pivot.Class> getAllClasses(Type type) {
		Iterable<org.eclipse.ocl.examples.pivot.Class> iterable = class2classes.get(type.getMoniker());
		if (iterable != null) {
			return iterable;
		}
		else if (type instanceof TupleType) {
			return (TupleType)type;				// FIXME should TupleTypes be in type2types
		}
		else if (type.getOwningTemplateParameter() != null) {
			return iterable;
		}
		else {
//			assert PivotConstants.ORPHANAGE_NAME.equals(type.getName());
			return iterable;
		}
	}

	public Iterable<Operation> getAllOperations(Operation operation) {
		Iterable<Operation> iterable = operation2operations.get(operation.getMoniker());
		assert iterable != null;
		return iterable;
	}

	public Iterable<String> getAllPackages() {
		if (pivotMetaModel == null)  {
			lazyLoadPivotMetaModel();
		}
		return package2packages.keySet();
	}

	public Iterable<org.eclipse.ocl.examples.pivot.Package> getAllPackages(org.eclipse.ocl.examples.pivot.Package pkg) {
		if (pivotMetaModel == null)  {
			lazyLoadPivotMetaModel();
		}
		Iterable<org.eclipse.ocl.examples.pivot.Package> iterable = package2packages.get(pkg.getMoniker());
		assert iterable != null;
		return iterable;
	}

	public Iterable<Property> getAllProperties(Property property) {
		Iterable<Property> iterable = property2properties.get(property.getMoniker());
		if (iterable != null) {
			return iterable;
		}
		else if (property.getClass_() instanceof TupleType) {
			return property;				// FIXME should TupleTypes be in type2types
		}
		assert iterable != null;
		return iterable;
	}

	public Operation getDynamicOperation(Type dynamicType, Operation staticOperation) {
		String typeMoniker = dynamicType.getMoniker();
		Map<String, Operation> operation2operation = type2operation2operation.get(typeMoniker);
		if (operation2operation == null) {
			operation2operation = new HashMap<String, Operation>();
			type2operation2operation.put(typeMoniker, operation2operation);
		}
		String operationMoniker = staticOperation.getMoniker();
		Operation dynamicOperation = operation2operation.get(operationMoniker);
		if (dynamicOperation != null) {
			return dynamicOperation;
		}
		if (staticOperation instanceof Iteration) {
			return getDynamicOperationForIteration(dynamicType, (Iteration) staticOperation);
		}
		else {
			return getDynamicOperationForOperation(dynamicType, staticOperation);
		}
	}
	
	private Iteration getDynamicOperationForIteration(Type dynamicType, Iteration staticModelIteration)
	{
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, dynamicType);
//		Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions2 = PivotUtil.getAllTemplateParameterSubstitutions(null, staticIteration.getModel());
		List<Type> staticCompleteIteratorTypes = new ArrayList<Type>();
		for (Parameter staticIterator : staticModelIteration.getOwnedIterators()) {
			staticCompleteIteratorTypes.add(getSpecializedType(staticIterator.getType(), bindings));
		}
		List<Type> staticCompleteAccumulatorTypes = new ArrayList<Type>();
		for (Parameter staticAccumulator : staticModelIteration.getOwnedAccumulators()) {
			staticCompleteAccumulatorTypes.add(getSpecializedType(staticAccumulator.getType(), bindings));
		}
		List<Type> staticCompleteParameterTypes = new ArrayList<Type>();
		for (Parameter staticParameter : staticModelIteration.getOwnedParameters()) {
			staticCompleteParameterTypes.add(getSpecializedType(staticParameter.getType(), bindings));
		}
		Iteration dynamicIteration = null;
		Set<Iteration> modelIterations = findModelIterationsOrNull(dynamicType, staticModelIteration.getName(),
			staticCompleteIteratorTypes, staticCompleteAccumulatorTypes, staticCompleteParameterTypes);
		if (modelIterations != null) {
			if (modelIterations.size() == 1) {
				dynamicIteration = modelIterations.iterator().next();
			}
			else if (modelIterations.size() > 1) {
				Iteration conformantIteration = null;
				boolean ok = true;
				for (Iteration completeIteration : modelIterations) {
					if (conformantIteration == null) {
						conformantIteration = completeIteration;
					}
					else {
						org.eclipse.ocl.examples.pivot.Class completeClass = PivotUtil.getFeaturingClass(completeIteration);
						org.eclipse.ocl.examples.pivot.Class conformantClass = PivotUtil.getFeaturingClass(conformantIteration);
						if (conformsTo(completeClass, conformantClass, bindings)) {
							conformantIteration = completeIteration;
						}
						else if (!conformsTo(conformantClass, completeClass, bindings)) {
							ok = false;
						}
					}
				}
				if (ok) {
					dynamicIteration = conformantIteration;
				}
			}
		}
		return dynamicIteration;
	}

	private Operation getDynamicOperationForOperation(Type dynamicType, Operation staticModelOperation) {
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, dynamicType);
		PivotUtil.getAllTemplateParameterSubstitutions(bindings, staticModelOperation);
		List<Type> staticCompleteTypes = new ArrayList<Type>();
		for (Parameter staticParameter : staticModelOperation.getOwnedParameters()) {
			staticCompleteTypes.add(getSpecializedType(staticParameter.getType(), bindings));
		}
		Operation dynamicModelOperation = null;
		String name = staticModelOperation.getName();
		Set<Operation> modelOperations = findModelOperationsOrNull(dynamicType, name, staticCompleteTypes, bindings);
		if ((modelOperations != null) && (modelOperations.size() == 1)) {
			dynamicModelOperation = modelOperations.iterator().next();
		}
		return dynamicModelOperation;
	}

	public Iterable<Type> getLocalClasses(org.eclipse.ocl.examples.pivot.Package pkg) {
		return new CompletePackageTypesIterable(getAllPackages(pkg));
	}

	public Iterable<Constraint> getLocalConstraints(Operation operation) {
		if (operation.getOwningTemplateParameter() != null) {
			return Collections.emptyList();
		}
		else {
			return new CompleteElementConstraintsIterable(getAllOperations(operation));
		}
	}

	public Iterable<Constraint> getLocalConstraints(Property property) {
		if (property.getOwningTemplateParameter() != null) {
			return Collections.emptyList();
		}
		else {
			return new CompleteElementConstraintsIterable(getAllProperties(property));
		}
	}

	public Iterable<Constraint> getLocalConstraints(Type type) {
		if ((type == null) || (type.getOwningTemplateParameter() != null)) {
			return Collections.emptyList();
		}
		else {
			return new CompleteElementConstraintsIterable(getAllClasses(type));
		}
	}

	private Iterable<Iteration> getLocalModelIterations(Type aType, String name) {
		List<Iteration> iterations = new ArrayList<Iteration>();
		org.eclipse.ocl.examples.pivot.Class type = getPrimaryClass(aType);
//		if (type.getTemplateBindings().size() > 0) {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
//		}
		for (Operation anOperation : getLocalOperations(type, null)) {
			if ((anOperation instanceof Iteration) && name.equals(anOperation.getName())) {
				Operation iteration = getPrimaryOperation(anOperation);
				if (!iterations.contains(iteration)) {
					iterations.add((Iteration) iteration);
				}
			}
		}
		return iterations;
	}

	private Iterable<Operation> getLocalModelOperations(Type aType, String name) {	// FIXME return an iterator
		List<Operation> operations = new ArrayList<Operation>();
		org.eclipse.ocl.examples.pivot.Class type = getPrimaryClass(aType);
//		if (type.getTemplateBindings().size() > 0) {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
//		}
		for (Operation anOperation : getLocalOperations(type, null)) {
			if (!(anOperation instanceof Iteration) && name.equals(anOperation.getName())) {
				Operation operation = getPrimaryOperation(anOperation);
				if (!operations.contains(operation)) {
					operations.add(operation);
				}
			}
		}
		return operations;
	}

	public Iterable<Operation> getLocalOperations(Type type, Boolean selectStatic) {
		if ((type == null) || (type.getOwningTemplateParameter() != null)) {
			return Collections.emptyList();
		}
		else {
//			if (type.getTemplateBindings().size() > 0) {		// FIXME need lazy specialization
				type = PivotUtil.getUnspecializedTemplateableElement(type);
//			}
			return new CompleteClassOperationsIterable(getAllClasses(type), selectStatic);
		}
	}

	public Iterable<org.eclipse.ocl.examples.pivot.Package> getLocalPackages(org.eclipse.ocl.examples.pivot.Package pkg) {
		return new CompletePackagePackagesIterable(getAllPackages(pkg));
	}

	public Iterable<Property> getLocalProperties(Type type, Boolean selectStatic) {
		if ((type == null) || (type.getOwningTemplateParameter() != null)) {
			return Collections.emptyList();
		}
		else {
//			if (type.getTemplateBindings().size() > 0) {		// FIXME need lazy specialization
				type = PivotUtil.getUnspecializedTemplateableElement(type);
//			}
			return new CompleteClassPropertiesIterable(getAllClasses(type), selectStatic);
		}
	}

	public org.eclipse.ocl.examples.pivot.Class getOrphanClass() {
		if (orphanageClass == null) {
			orphanageClass = PivotFactory.eINSTANCE.createClass();
			orphanageClass.setName(PivotConstants.ORPHANAGE_NAME);
			getOrphanPackage().getOwnedTypes().add(orphanageClass);
		}
		return orphanageClass;
	}
	
	private OrphanNode getOrphanNode(MonikeredElement pivotElement) {
		if (pivotElement.eIsProxy()) {
			return null;
		}
		String moniker = pivotElement.getMoniker();
		OrphanNode thisOrphanNode = moniker2orphan.get(moniker);
		if (thisOrphanNode == null) {
			thisOrphanNode = new OrphanNode(pivotElement);
			moniker2orphan.put(moniker, thisOrphanNode);
			for (EObject eObject : pivotElement.eCrossReferences()) {
				if (eObject instanceof MonikeredElement) {
					OrphanNode thatOrphanNode = getOrphanNode((MonikeredElement) eObject);
					if (thatOrphanNode != null) {
						thatOrphanNode.addDependency(thisOrphanNode);
					}
				}
			}
		}
		return thisOrphanNode;
	}

	public org.eclipse.ocl.examples.pivot.Package getOrphanPackage() {
		if (orphanagePackage == null) {
			orphanagePackage = PivotFactory.eINSTANCE.createPackage();
			orphanagePackage.setName(PivotConstants.ORPHANAGE_NAME);
			orphanagePackage.setMoniker(PivotConstants.ORPHANAGE_NAME);
			orphanagePackage.setNsURI(PivotConstants.ORPHANAGE_URI);
			orphanagePackage.setNsPrefix(PivotConstants.ORPHANAGE_PREFIX);
			URI uri = URI.createURI(PivotConstants.ORPHANAGE_URI);
			Resource orphanage = createOrphanage(uri);
			orphanage.getContents().add(orphanagePackage);
			installResource(orphanage);
		}
		return orphanagePackage;
	}

	public String getPackageMoniker(String uri) {
		return uri2package.get(uri);
	}

	public org.eclipse.ocl.examples.pivot.Class getPrimaryClass(String moniker) {
		Iterable<org.eclipse.ocl.examples.pivot.Class> iterable = class2classes.get(moniker);
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return null;
		}
	}

	public org.eclipse.ocl.examples.pivot.Class getPrimaryClass(Type pivotClass) {
		Iterable<org.eclipse.ocl.examples.pivot.Class> iterable = class2classes.get(pivotClass.getMoniker());
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return (org.eclipse.ocl.examples.pivot.Class)pivotClass;
		}
	}

	public EObject getPrimaryElement(EObject element) {
		Iterable<? extends EObject> primaryElement = null;
		if (element instanceof Operation) {
			primaryElement = operation2operations.get(((Operation)element).getMoniker());
		}
		else if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
			primaryElement = package2packages.get(((org.eclipse.ocl.examples.pivot.Package)element).getMoniker());
		}
		else if (element instanceof Property) {
			primaryElement = property2properties.get(((Property)element).getMoniker());
		}
		else if (element instanceof Type) {
			primaryElement = class2classes.get(((Type)element).getMoniker());
		}
		if (primaryElement != null) {
			return primaryElement.iterator().next();
		}
		else {
			return element;
		}
	}

	public Operation getPrimaryOperation(String moniker) {
		Iterable<Operation> iterable = operation2operations.get(moniker);
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return null;
		}
	}

	public Operation getPrimaryOperation(Operation pivotOperation) {
		Iterable<Operation> iterable = operation2operations.get(pivotOperation.getMoniker());
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return pivotOperation;
		}
	}

	public org.eclipse.ocl.examples.pivot.Package getPrimaryPackage(String moniker) {
		Iterable<org.eclipse.ocl.examples.pivot.Package> iterable = package2packages.get(moniker);
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return null; //pivotMetaModel;
		}
	}

	public org.eclipse.ocl.examples.pivot.Package getPrimaryPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		Iterable<org.eclipse.ocl.examples.pivot.Package> iterable = package2packages.get(pivotPackage.getMoniker());
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return pivotPackage;
		}
	}

	public Property getPrimaryProperty(String moniker) {
		Iterable<Property> iterable = property2properties.get(moniker);
		if (iterable != null) {
			return iterable.iterator().next();
		}
		else {
			return null;
		}
	}
	
	public abstract Type getSpecializedType(Type type, Map<TemplateParameter, ParameterableElement> usageBindings);

	public Iterable<org.eclipse.ocl.examples.pivot.Class> getSuperClasses(Type pivotType) {
		return new CompleteClassSuperClassesIterable(getAllClasses(pivotType));
	}
	
/*	public Iterable<org.eclipse.ocl.examples.pivot.Class> getSuperTypes(Type type)
	{
		if (completeSuperTypes == null)
		{
			completeSuperTypes = new EObjectResolvingEList<CompleteType>(CompleteType.class, this, PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE);
//			for (Type superType : getSuperClasses()) {
//				completeSuperTypes.add(completeEnvironment.getCompleteType(superType));
//			}
			for (Type model : models) {
				if (model instanceof org.eclipse.ocl.examples.pivot.Class) {
					org.eclipse.ocl.examples.pivot.Class thisModelClass = (org.eclipse.ocl.examples.pivot.Class)model;
					if (thisModelClass.getTemplateBindings().size() > 0) {
	//					thisModelClass = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class)model);
					}
					for (Type superType : thisModelClass.getSuperClasses()) {
						completeSuperTypes.add(completeEnvironment.getCompleteType(superType));
					}
				}
			}
		}
		return completeSuperTypes;
	} */

	public void installPackageMoniker(org.eclipse.ocl.examples.pivot.Package pivotPackage, boolean installTrackers) {
		String name = pivotPackage.getName();		// FIXME rewrite this
		if (name == null) {
			name = PivotConstants.NULL_ROOT;
		}
		String packageMoniker = name;
		if (pivotPackage instanceof Library) {
			pivotPackage.setMoniker(PivotConstants.LIBRARY_MONIKER_PREFIX + packageMoniker);	// Keep built-in library distinct from user library-like packages
			if (installTrackers) {
				addPackage(pivotPackage);
			}
		}
		else {
			int suffix = 0;
			String nsURI = pivotPackage.getNsURI();
			while (true) {
				Iterable<org.eclipse.ocl.examples.pivot.Package> existingPackage = package2packages.get(packageMoniker);
				if (existingPackage == null) {
					break;
				}
				if ((nsURI != null) && nsURI.equals(existingPackage.iterator().next().getNsURI())) {
					break;
				}
				packageMoniker = name + "_" + ++suffix;
			}
			pivotPackage.setMoniker(packageMoniker);
			if (installTrackers) {
				addPackage(pivotPackage);
			}
			if ((suffix > 0) && (name != PivotConstants.NULL_ROOT) && (nsURI == null)) {
				logger.warn("Conflicting package " + pivotPackage);
			}
		}
	}
	
	/**
	 * Create implicit an opposite property if there is no explicit opposite.
	 */
	public void installPropertyDeclaration(Property thisProperty) {
		if (thisProperty.isTransient() || thisProperty.isVolatile() || thisProperty.isDerived()) {
			return;
		}
		Property opposite = thisProperty.getOpposite();
		if (opposite != null) {
			return;
		}
		org.eclipse.ocl.examples.pivot.Class thatType = (org.eclipse.ocl.examples.pivot.Class)thisProperty.getType();
		if ((thatType == null) || (thatType instanceof DataType)) {
			return;
		}
		org.eclipse.ocl.examples.pivot.Class thisType = thisProperty.getClass_();
		String name = thisType.getName();
		// If there is an explicit property with the implicit name do nothing.
		for (Property thatProperty : thatType.getOwnedAttributes()) {
			if (name.equals(thatProperty.getName())) {
				if (!thatProperty.isImplicit()) {
					return;
				}
				opposite = thatProperty;
			}
		}
		// If there is an implicit property with the implicit name, set its opposite null
		//   and do no more; result one name with no opposites
		if (opposite != null) {
			opposite.setOpposite(null);
			thisProperty.setOpposite(null);
			opposite.setUpper(BigInteger.valueOf(-1));
			return;
		}
		// If there is no implicit property with the implicit name, create one
		//   result a pair of mutual opposites		
		opposite = PivotFactory.eINSTANCE.createProperty();
		opposite.setImplicit(true);
		opposite.setName(name);
		opposite.setType(thisType);
		opposite.setLower(BigInteger.valueOf(0));
		if (thisProperty.isComposite()) {
			opposite.setUpper(BigInteger.valueOf(1));
		}
		else {
			opposite.setUpper(BigInteger.valueOf(-1));
		}
		opposite.setOpposite(thisProperty);
		thisProperty.setOpposite(opposite);
		thatType.getOwnedAttributes().add(opposite);
	}

	protected abstract void installResource(Resource resource);

	protected boolean isInOrphanage(EObject eObject) {
		for (EObject eContainer = eObject; eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer == orphanagePackage) {
				return true;
			}
		}
		return false;
	}

	protected abstract void lazyLoadPivotMetaModel();

	protected void loadPivotMetaModel(Library pivotLibrary) {
		for (org.eclipse.ocl.examples.pivot.Package libPackage : package2packages.get(pivotLibrary.getMoniker())) {
			if (PivotUtil.getNamedElement(libPackage.getOwnedTypes(), PivotPackage.Literals.ELEMENT.getName()) != null) {
				pivotMetaModel = libPackage;	// Custom meta-model
				return;
			}
		}
		OclMetaModel metaModelResource = new OclMetaModel(this);		// Standard meta-model
		pivotMetaModel = (org.eclipse.ocl.examples.pivot.Package)metaModelResource.getContents().get(0);
		pivotMetaModel.setName(pivotLibrary.getName());		// FIXME JUNO Change name for Juno
		pivotMetaModel.setMoniker(pivotLibrary.getMoniker());
		addPackage(pivotMetaModel);
	}

	private void removeClass(org.eclipse.ocl.examples.pivot.Class pivotClass) {
		String moniker = pivotClass.getMoniker();
		Iterable<org.eclipse.ocl.examples.pivot.Class> iterable = class2classes.get(moniker);
		if (iterable == pivotClass) {
			class2classes.remove(moniker);
		}
		else if (iterable instanceof List<?>) {
			List<org.eclipse.ocl.examples.pivot.Class> iterables = (List<org.eclipse.ocl.examples.pivot.Class>)iterable;
			iterables.remove(pivotClass);
			if (iterables.size() == 0) {
				class2classes.remove(moniker);
			}
			else if (iterables.size() == 1) {
				class2classes.put(moniker, iterables.get(0));
			}
		}
		else if (iterable != null) {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
		removeOrphan(pivotClass);
		for (Operation operation : new ArrayList<Operation>(pivotClass.getOwnedOperations())) {
			removeOperation(operation);
		}
		for (Property property : new ArrayList<Property>(pivotClass.getOwnedAttributes())) {
			removeProperty(property);
		}
	}

	private void removeOperation(Operation pivotOperation) {
		String moniker = pivotOperation.getMoniker();
		Iterable<Operation> iterable = operation2operations.get(moniker);
		if (iterable == pivotOperation) {
			operation2operations.remove(moniker);
		}
		else if (iterable instanceof List<?>) {
			List<Operation> iterables = (List<Operation>)iterable;
			iterables.remove(pivotOperation);
			if (iterables.size() == 0) {
				operation2operations.remove(moniker);
			}
			else if (iterables.size() == 1) {
				operation2operations.put(moniker, iterables.get(0));
			}
		}
		else if (iterable != null) {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
		removeOrphan(pivotOperation);
	}
	
	private void removeOrphan(MonikeredElement pivotElement) {
		String moniker = pivotElement.getMoniker();
		OrphanNode thisOrphanNode = moniker2orphan.get(moniker);
		if (thisOrphanNode != null) {
			Set<OrphanNode> orphans = thisOrphanNode.getAllDependencies(null);
			for (OrphanNode orphan : orphans) {
				MonikeredElement element = orphan.getElement();
				if (element instanceof Operation) {
					org.eclipse.ocl.examples.pivot.Class orphanClass = getOrphanClass();
					if (orphanClass.getOwnedOperations().remove(element)) {
//						System.out.println("remove-orphan " + element.eClass().getName() + "@" + Integer.toHexString(element.hashCode()) + " " + element.getMoniker());
					}
					else {
//						System.out.println("remove-orphan-node " + element.eClass().getName() + "@" + Integer.toHexString(element.hashCode()) + " " + element.getMoniker());
					}
				}
				else if (element instanceof org.eclipse.ocl.examples.pivot.Class) {
					org.eclipse.ocl.examples.pivot.Package orphanPackage = getOrphanPackage();
					if (orphanPackage.getOwnedTypes().remove(element)) {
//						System.out.println("remove-orphan " + element.eClass().getName() + "@" + Integer.toHexString(element.hashCode()) + " " + element.getMoniker());
					}
					else {
//						System.out.println("remove-orphan-node " + element.eClass().getName() + "@" + Integer.toHexString(element.hashCode()) + " " + element.getMoniker());
					}
				}
				orphan.dispose();
			}
		}
	}

	private void removePackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String moniker = pivotPackage.getMoniker();
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {
			uri2package.remove(nsURI);
		}
		Iterable<org.eclipse.ocl.examples.pivot.Package> iterable = package2packages.get(moniker);
		if (iterable == pivotPackage) {
			package2packages.remove(moniker);
		}
		else if (iterable instanceof List<?>) {
			List<org.eclipse.ocl.examples.pivot.Package> iterables = (List<org.eclipse.ocl.examples.pivot.Package>)iterable;
			iterables.remove(pivotPackage);
			if (iterables.size() == 0) {
				package2packages.remove(moniker);
			}
			else if (iterables.size() == 1) {
				package2packages.put(moniker, iterables.get(0));
			}
		}
		else if (iterable != null) {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
		removeOrphan(pivotPackage);
	}

	private void removeProperty(Property pivotProperty) {
		String moniker = pivotProperty.getMoniker();
		Iterable<Property> iterable = property2properties.get(moniker);
		if (iterable == pivotProperty) {
			property2properties.remove(moniker);
		}
		else if (iterable instanceof List<?>) {
			List<Property> iterables = (List<Property>)iterable;
			iterables.remove(pivotProperty);
			if (iterables.size() == 0) {
				property2properties.remove(moniker);
			}
			else if (iterables.size() == 1) {
				property2properties.put(moniker, iterables.get(0));
			}
		}
		else if (iterable != null) {
			assert false : "Unknown iterable " + iterable.getClass().getName();
		}
		removeOrphan(pivotProperty);
	}
}