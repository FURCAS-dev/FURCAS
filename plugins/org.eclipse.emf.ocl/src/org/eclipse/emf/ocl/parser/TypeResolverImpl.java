/**
 * <copyright> 
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TypeResolverImpl.java,v 1.1 2006/04/28 14:46:29 cdamus Exp $
 */
package org.eclipse.emf.ocl.parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.impl.TypeTypeImpl;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.types.util.TypesSwitch;
import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.impl.TupleFactory;


/**
 * Default implementation of the {@link TypeResolver} interface, storing the types
 * that it generates in the a resource to support persistence of
 * {@link OCLExpression}s referencing these types.
 * <p>
 * It is recommended that clients extend this class to customize resolution of
 * types based on their models, rather than implementing the interface.  Simply
 * override the protected <code>createXyzPackage()</code> methods to determine
 * where the resolved types are stored and the <code>resolveXyzType()</code>
 * methods to create or find types are required.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TypeResolverImpl
	implements TypeResolver {

	private final TypesSwitch resolveSwitch = new ResolveSwitch();
	
	private Resource resource;
	private EPackage collectionPackage;
	private EPackage tuplePackage;
	private EPackage typePackage;
	private EPackage messagePackage;
	
	/**
	 * Initializes me.  I create my own resource for persistence of model-based
	 * types.
	 */
	public TypeResolverImpl() {
		super();
	}
	
	/**
	 * Initializes me with a resource in which I will persist the model-based
	 * types that I generate in my associated {@link Environment}.
	 * 
	 * @param resource my resource
	 */
	public TypeResolverImpl(Resource resource) {
		this.resource = resource;
	}
	
	// Documentation copied from the inherited specification
	public EClassifier resolve(EClassifier type) {
		return (type == null)? type : (EClassifier) resolveSwitch.doSwitch(type);
	}
	
	// Documentation copied from the inherited specification
	public Resource getResource() {
		if (resource == null) {
			resource = createResource();
		}
		
		return resource;
	}
	
	/**
	 * Creates the resource that persists my generated types.  Subclasses requiring
	 * persistence must override this default implementation, as it creates a
	 * resource that does not support persistence and does not have a useful URI.
	 * A subclass could even find some other resource, such as that which will store
	 * the expressions parsed in this environment.
	 * 
	 * @return the new resource
	 */
	protected Resource createResource() {
		Resource result = new ResourceImpl() {
			public EObject getEObject(String uriFragment) {
				// our default package implementation encodes type names because
				//    they may contain spaces or other bad characters
				return super.getEObject(URI.decode(uriFragment));
			}};
		
		result.setURI(URI.createURI("ocltypes:///")); //$NON-NLS-1$
		return result;
	}
	
	/**
	 * Obtains the package containing the collection types that I generate.
	 * 
	 * @return my collection type package
	 */
	public EPackage getCollectionPackage() {
		if (collectionPackage == null) {
			collectionPackage = createCollectionPackage();
		}
		
		return collectionPackage;
	}
	
	/**
	 * Creates the package containing the collection types that I generate.
	 * 
	 * @return the new collection type package
	 */
	protected EPackage createCollectionPackage() {
		EPackage result = new EncodingPackage();
		
		result.setName("collections"); //$NON-NLS-1$
		getResource().getContents().add(result);
		
		return result;
	}
	
	// Documentation copied from the inherited specification
	public CollectionType getCollectionType(CollectionKind kind,
			EClassifier elementType) {
		CollectionType result = findCollectionType(kind, elementType);
		
		if (result == null) {
			result = createCollectionType(kind, elementType);
		}
		
		return result;
	}
	
	/**
	 * Creates a new collection type of the specified <code>kind</code> and element
	 * type, assuming that it does not already exist.
	 * 
	 * @param kind the kind of collection to create
	 * @param elementType the collection's element type
	 * 
	 * @return the new collection type
	 */
	protected CollectionType createCollectionType(CollectionKind kind, EClassifier elementType) {
		CollectionType result = TypesFactory.eINSTANCE.createCollectionType(kind, elementType);
		getCollectionPackage().getEClassifiers().add(result);
		return result;
	}
	
	/**
	 * Finds an existing collection type matching the specified <code>kind</code> and
	 * element type, if any has already been created.
	 * 
	 * @param kind the element kind to search for
	 * @param elementType the element type to search for
	 * 
	 * @return the existing collection type, or <code>null</code> if none found
	 */
	protected CollectionType findCollectionType(CollectionKind kind, EClassifier elementType) {
		for (Iterator iter = getCollectionPackage().getEClassifiers().iterator(); iter.hasNext();) {
			CollectionType type = (CollectionType) iter.next();
			
			if ((type.getKind() == kind) &&
					(TypeUtil.getRelationship(
						type.getElementType(),
						elementType) == PredefinedType.SAME_TYPE)) {
					return type;
			}
		}
		
		return null;
	}
	
	/**
	 * Obtains the package containing the tuple types that I generate.
	 * 
	 * @return my tuple type package
	 */
	public EPackage getTuplePackage() {
		if (tuplePackage == null) {
			tuplePackage = createTuplePackage();
		}
		
		return tuplePackage;
	}
	
	/**
	 * Creates the package containing the tuple types that I generate.
	 * 
	 * @return the new tuple type package
	 */
	protected EPackage createTuplePackage() {
		EPackage result = new EncodingPackage();
		
		result.setName("tuples"); //$NON-NLS-1$
		result.setEFactoryInstance(new TupleFactory());
		getResource().getContents().add(result);
		
		return result;
	}

	// Documentation copied from the inherited specification
	public TupleType getTupleType(List parts) {
		TupleType result = findTupleType(parts);
		
		if (result == null) {
			result = createTupleType(parts);
		}
		
		return result;
	}
	
	/**
	 * Creates a new tuple type from the specified <code>parts</code>, assuming that
	 * it does not already exist.
	 * 
	 * @param parts the {@link TypedElement}s describing the tuple parts
	 * 
	 * @return the new tuple type
	 */
	protected TupleType createTupleType(List parts) {
		TupleType result = TypesFactory.eINSTANCE.createTupleType(parts);
		getTuplePackage().getEClassifiers().add(result);
		return result;
	}
	
	/**
	 * Finds an existing tuple type matching the specified <code>parts</code>, if any
	 * has already been created.
	 * 
	 * @param parts the {@link TypedElement}s describing the tuple parts
	 * 
	 * @return the existing tuple type, or <code>null</code> if none found
	 */
	protected TupleType findTupleType(List parts) {
		for (Iterator iter = getTuplePackage().getEClassifiers().iterator(); iter.hasNext();) {
			TupleType type = (TupleType) iter.next();
			
			if (type.getEStructuralFeatures().size() == parts.size()) {
				for (Iterator jter = parts.iterator(); jter.hasNext();) {
					TypedElement part = (TypedElement) jter.next();
					EStructuralFeature property = type.getEStructuralFeature(part.getName());
					
					if ((property == null) ||
							(TypeUtil.getRelationship(
								property.getEType(),
								part.getType()) != PredefinedType.SAME_TYPE)) {
						// this isn't the tuple type we're looking for
						break;
					}
				}
				
				// this must be the tuple type we're looking for
				return type;
			}
		}
		
		return null;
	}
	
	/**
	 * Obtains the package containing the type types that I generate.
	 * 
	 * @return my type type package
	 */
	public EPackage getTypePackage() {
		if (typePackage == null) {
			typePackage = createTypePackage();
		}
		
		return typePackage;
	}
	
	/**
	 * Creates the package containing the type types that I generate.
	 * 
	 * @return the new type type package
	 */
	protected EPackage createTypePackage() {
		EPackage result = new EncodingPackage();
		
		result.setName("types"); //$NON-NLS-1$
		getResource().getContents().add(result);
		
		return result;
	}
	
	// Documentation copied from the inherited specification
	public TypeType getTypeType(EClassifier type) {
		TypeType result = findTypeType(type);
		
		if (result == null) {
			result = createTypeType(type);
		}
		
		return result;
	}
	
	/**
	 * Creates a new type type for the specified <code>type</code>,
	 * assuming that it does not already exist.
	 * 
	 * @param type the referenced model type
	 * 
	 * @return the new type type
	 */
	protected TypeType createTypeType(EClassifier type) {
		TypeType result = TypesFactory.eINSTANCE.createTypeType(type);
		getTypePackage().getEClassifiers().add(result);
		return result;
	}
	
	/**
	 * Finds an existing type type matching the specified <code>type</code>,
	 * if any has already been created.
	 * 
	 * @param type the referenced model type
	 * 
	 * @return the existing type type, or <code>null</code> if none found
	 */
	protected TypeType findTypeType(EClassifier type) {
		for (Iterator iter = getTypePackage().getEClassifiers().iterator(); iter.hasNext();) {
			TypeTypeImpl typeType = (TypeTypeImpl) iter.next();
			
			if (TypeUtil.getRelationship(
						typeType.getReferredType(),
						type) == PredefinedType.SAME_TYPE) {
					return typeType;
			}
		}
		
		return null;
	}
	
	/**
	 * Obtains the package containing the message types that I generate.
	 * 
	 * @return my message type package
	 */
	public EPackage getMessagePackage() {
		if (messagePackage == null) {
			messagePackage = createMessagePackage();
		}
		
		return messagePackage;
	}
	
	/**
	 * Creates the package containing the message types that I generate.
	 * 
	 * @return the new message type package
	 */
	protected EPackage createMessagePackage() {
		EPackage result = new EncodingPackage();
		
		result.setName("messages"); //$NON-NLS-1$
		getResource().getContents().add(result);
		
		return result;
	}
	
	// Documentation copied from the inherited specification
	public MessageType getMessageType(EOperation operation) {
		MessageType result = findMessageType(operation);
		
		if (result == null) {
			result = createMessageType(operation);
		}
		
		return result;
	}
	
	// Documentation copied from the inherited specification
	public MessageType getMessageType(EClass signal) {
		MessageType result = findMessageType(signal);
		
		if (result == null) {
			result = createMessageType(signal);
		}
		
		return result;
	}
	
	/**
	 * Creates a new message type for the specified <code>element</code>,
	 * assuming that it does not already exist.
	 * 
	 * @param element the operation or signal referenced by the message type
	 * 
	 * @return the new message type
	 */
	protected MessageType createMessageType(ENamedElement element) {
		MessageType result = TypesFactory.eINSTANCE.createMessageType(element);
		getMessagePackage().getEClassifiers().add(result);
		return result;
	}
	
	/**
	 * Finds an existing message type matching the specified <code>element</code>,
	 * if any has already been created.
	 * 
	 * @param element the referenced model element
	 * 
	 * @return the existing message type, or <code>null</code> if none found
	 */
	protected MessageType findMessageType(ENamedElement element) {
		for (Iterator iter = getMessagePackage().getEClassifiers().iterator(); iter.hasNext();) {
			MessageType type = (MessageType) iter.next();
			
			if ((type.getReferredOperation() == element)
					|| (type.getReferredSignal() == element)) {
				
				return type;
			}
		}
		
		return null;
	}
	
	/**
	 * A type switch that resolves types against my resolver's environment.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class ResolveSwitch extends TypesSwitch {
		public Object caseCollectionType(CollectionType object) {
			return getCollectionType(
				object.getKind(),
				resolve(object.getElementType()));
		}
		
		public Object caseTupleType(TupleType object) {
			return getTupleType(createTupleParts(
				object.getEStructuralFeatures()));
		}
		
		public Object caseTypeType(TypeType object) {
			return getTypeType(
				resolve(((TypeTypeImpl) object).getReferredType()));
		}
		
		public Object caseMessageType(MessageType object) {
			if (object.getReferredOperation() != null) {
				return getMessageType(object.getReferredOperation());
			} else if (object.getReferredSignal() != null) {
				return getMessageType(object.getReferredSignal());
			}
			
			return null;
		}
		
		public Object defaultCase(EObject object) {
			return object;
		}
		
		private List createTupleParts(Collection features) {
			List result = new java.util.ArrayList();
			
			for (Iterator iter = features.iterator(); iter.hasNext();) {
				EStructuralFeature next = (EStructuralFeature) iter.next();
				
				Variable v = ExpressionsFactory.eINSTANCE.createVariable();
				v.setName(next.getName());
				v.setType(resolve(next.getEType()));
				result.add(v);
			}
			
			return result;
		}
	}
	
	/**
	 * A package that encodes the classifier names that it contains, for
	 * serialization of URI fragments.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class EncodingPackage extends EPackageImpl {
		public String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
			String result = super.eURIFragmentSegment(eStructuralFeature, eObject);
			return URI.encodeFragment(result, false);
		}
	}
}
