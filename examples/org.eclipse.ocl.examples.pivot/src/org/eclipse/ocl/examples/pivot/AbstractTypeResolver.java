/**
 * <copyright> 
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera - 222581 generic collection type resolution
 *
 * </copyright>
 *
 * $Id: AbstractTypeResolver.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * A partial implementation of the {@link TypeResolver} interface, useful for
 * providers of environment implementations to build their type resolvers.
 * <p>
 * It is recommended that clients extend this class to customize resolution of
 * types based on their models, rather than implementing the interface.  Simply
 * override a few protected methods for creating metamodel-specific constructs.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTypeResolver implements TypeResolver {

    protected static final String COLLECTIONS_PACKAGE = "collections"; //$NON-NLS-1$
    protected static final String MESSAGES_PACKAGE = "messages"; //$NON-NLS-1$
    protected static final String TUPLES_PACKAGE = "tuples"; //$NON-NLS-1$
    protected static final String TYPES_PACKAGE = "types"; //$NON-NLS-1$
    protected static final String ADDITIONS_PACKAGE = "additions"; //$NON-NLS-1$

//	private final TypesSwitch<C> resolveSwitch = new ResolveSwitch();
	
	private final Environment env;
    private final OCLFactory oclFactory;
    private final UMLReflection uml;
    
	private Resource resource;
	
	// whether I should dispose my resource because I created it
	private boolean shouldDisposeResource;
	
	private org.eclipse.ocl.examples.pivot.Package collectionPackage;
	private org.eclipse.ocl.examples.pivot.Package tuplePackage;
	private org.eclipse.ocl.examples.pivot.Package typePackage;
	private org.eclipse.ocl.examples.pivot.Package messagePackage;
	private org.eclipse.ocl.examples.pivot.Package additionalFeaturesPackage;
	
	private CollectionType collection;
	private SetType set;
	private OrderedSetType orderedSet;
	private BagType bag;
	private SequenceType sequence;
//	private TypeType oclType;
	private MessageType oclMessage;

	/**
	 * Initializes me with an environment.  I create my own resource for
     * persistence of model-based types.
     * 
     * @param env the environment that I persist
	 */
	public AbstractTypeResolver(Environment env) {
		this(env, null);
	}
	
	/**
	 * Initializes me with a resource in which I will persist the model-based
	 * types that I generate in my associated {@link Environment}.
	 * 
     * @param env my environment
	 * @param resource my resource
	 */
	public AbstractTypeResolver(Environment env, Resource resource) {
		this.env = env;
		this.resource = resource;
        
        oclFactory = env.getOCLFactory();
        uml = env.getUMLReflection();
	}
	
	// Documentation copied from the inherited specification
/*	public Type resolve(Type type) {
		Type result = (type == null)? type : resolveSwitch.doSwitch((EObject) type);
		
		if ((result != null) && (result != type)) {
		    // dispose the old type; it won't be used
		    ObjectUtil.dispose(type);
		}
		
		return result;
	} */
	
    /**
     * Obtains the environment that I persist.
     * 
     * @return my environment
     */
    protected final Environment getEnvironment() {
        return env;
    }
    
	// Documentation copied from the inherited specification
	public Resource getResource() {
		if (resource == null) {
		    // because we are creating the resource, we should dispose it
		    shouldDisposeResource = true;
			resource = createResource();
		}
		
		return resource;
	}
	
	/**
	 * Creates the resource that persists my generated types.  Subclasses requiring
	 * persistence must override this default implementation, as it creates a
	 * resource that does not support persistence and does not have a useful URI.
	 * A subclass could even find some other resource, such as the model on
     * which constraints are being parsed, if desired.
	 * 
	 * @return the new resource
	 */
	protected Resource createResource() {
		return new ResourceImpl(URI.createURI("ocl:///oclenv")); //$NON-NLS-1$
	}
	
	/**
	 * Obtains the package containing the collection types that I generate.
	 * 
	 * @return my collection type package
	 */
	public org.eclipse.ocl.examples.pivot.Package getCollectionPackage() {
		if (collectionPackage == null) {
			collectionPackage = findCollectionPackage();
			if (collectionPackage == null) {
				collectionPackage = createCollectionPackage();
			}
		}
		
		return collectionPackage;
	}
	
	/**
	 * Creates the package containing the collection types that I generate.
	 * 
	 * @return the new collection type package
	 */
	protected org.eclipse.ocl.examples.pivot.Package createCollectionPackage() {
	    return createPackage(COLLECTIONS_PACKAGE);
    }
	
	/**
	 * Finds the package storing collection types, if our resource already
	 * contains it.
	 * 
	 * @return the existing collection types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected org.eclipse.ocl.examples.pivot.Package findCollectionPackage() {
		return findPackage(COLLECTIONS_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public CollectionType resolveCollectionType(
			CollectionKind kind,
			Type elementType) {
		
	    CollectionType result;
	    
		if (elementType == getCollection().getElementType()) {
			switch (kind) {
				case SET :
				    result = getSet();
				    break;
				case ORDERED_SET:
				    result = getOrderedSet();
                    break;
				case SEQUENCE:
				    result = getSequence();
                    break;
				case BAG:
				    result = getBag();
                    break;
				default:
				    result = getCollection();
				    break;
			}
		} else {
    		result = findCollectionType(kind, elementType);
		}
		
		if (result == null) {
			result = createCollectionType(kind, elementType);
		}
		
		return result;
	}
	
	private CollectionType getCollection() {
		if (collection == null) {
			collection = (CollectionType) getEnvironment().getOCLStandardLibrary()
					.getCollectionType();
		}
		
		return collection;
	}
	
	private SetType getSet() {
		if (set == null) {
			set = (SetType) getEnvironment().getOCLStandardLibrary()
					.getSetType();
		}
		
		return set;
	}
	
	private OrderedSetType getOrderedSet() {
		if (orderedSet == null) {
			orderedSet = (OrderedSetType) getEnvironment().getOCLStandardLibrary()
					.getOrderedSetType();
		}
		
		return orderedSet;
	}
	
	private SequenceType getSequence() {
		if (sequence == null) {
			sequence = (SequenceType) getEnvironment().getOCLStandardLibrary()
					.getSequenceType();
		}
		
		return sequence;
	}
	
	private BagType getBag() {
		if (bag == null) {
			bag = (BagType) getEnvironment().getOCLStandardLibrary()
					.getBagType();
		}
		
		return bag;
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
	protected CollectionType createCollectionType(
			CollectionKind kind, Type elementType) {
		
		CollectionType result =
			oclFactory.createCollectionType(kind, elementType);
		addClassifier(getCollectionPackage(), (Type) result);
		
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
	protected CollectionType findCollectionType(
			CollectionKind kind, Type elementType) {
		
		for (Type next : uml.getClassifiers(getCollectionPackage())) {
            if (next instanceof CollectionType) {
    			CollectionType type = (CollectionType) next;
    			
    			if ((TypeUtil.getKind(type) == kind) &&
    					(TypeUtil.getRelationship(
    						env,
    						type.getElementType(),
    						elementType) == UMLReflection.SAME_TYPE)) {
    					return type;
    			}
            }
		}
		
		return null;
	}
	
	/**
	 * Obtains the package containing the tuple types that I generate.
	 * 
	 * @return my tuple type package
	 */
	public org.eclipse.ocl.examples.pivot.Package getTuplePackage() {
		if (tuplePackage == null) {
			tuplePackage = findTuplePackage();
			if (tuplePackage == null) {
				tuplePackage = createTuplePackage();
			}
		}
		
		return tuplePackage;
	}
	
	/**
	 * Creates the package containing the tuple types that I generate.
	 * 
	 * @return the new tuple type package
	 */
    protected org.eclipse.ocl.examples.pivot.Package createTuplePackage() {
        return createPackage(TUPLES_PACKAGE);
    }
	
	/**
	 * Finds the package storing tuple types, if our resource already
	 * contains it.
	 * 
	 * @return the existing tuple types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected org.eclipse.ocl.examples.pivot.Package findTuplePackage() {
		return findPackage(TUPLES_PACKAGE);
	}

	// Documentation copied from the inherited specification
	public TupleType resolveTupleType(EList<? extends TypedElement> parts) {
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
	protected TupleType createTupleType(EList<? extends TypedElement> parts) {
		TupleType result = oclFactory.createTupleType(parts);
		
		addClassifier(getTuplePackage(), (Type) result);
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
	protected TupleType findTupleType(EList<? extends TypedElement> parts) {
		for (Type next : uml.getClassifiers(getTuplePackage())) {
            if (next instanceof TupleType) {
    			TupleType type = (TupleType) next;
    			
    			if (type.getOwnedAttributes().size() == parts.size()) {
    			    boolean match = true;
    			    
    				for (TypedElement part : parts) {
    					Property property = env.lookupProperty((Type) type, part.getName());
    					
    					if ((property == null) ||
    							(TypeUtil.getRelationship(
    									env,
    									resolve(uml.getOCLType(property)),
    									part.getType()) != UMLReflection.SAME_TYPE)) {
    						// this isn't the tuple type we're looking for
    					    match = false;
    						break;
    					}
    				}
    				
    				if (match) {
        				// this must be the tuple type we're looking for
        				return type;
    				}
    			}
            }
		}
		
		return null;
	}
	
	/**
	 * Obtains the package containing the type types that I generate.
	 * 
	 * @return my type type package
	 */
	public org.eclipse.ocl.examples.pivot.Package getTypePackage() {
		if (typePackage == null) {
			typePackage = findTypePackage();
			if (typePackage == null) {
				typePackage = createTypePackage();
			}
		}
		
		return typePackage;
	}
	
	/**
	 * Creates the package containing the type types that I generate.
	 * 
	 * @return the new type type package
	 */
    protected org.eclipse.ocl.examples.pivot.Package createTypePackage() {
        return createPackage(TYPES_PACKAGE);
    }
	
	/**
	 * Finds the package storing type types, if our resource already
	 * contains it.
	 * 
	 * @return the existing type types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected org.eclipse.ocl.examples.pivot.Package findTypePackage() {
		return findPackage(TYPES_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
/*	public TypeType<C, O> resolveTypeType(C type) {
		if (type == getOclType().getReferredType()) {
			// this is the canonical OclType instance
			return getOclType();
		}
		
		TypeType<C, O> result = findTypeType(type);
		
		if (result == null) {
			result = createTypeType(type);
		}
		
		return result;
	} */
	
/*	@SuppressWarnings("unchecked")
	private TypeType<C, O> getOclType() {
		if (oclType == null) {
			oclType = (TypeType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getOclType();
		}
		
		return oclType;
	} */
	
	/**
	 * Creates a new type type for the specified <code>type</code>,
	 * assuming that it does not already exist.
	 * 
	 * @param type the referenced model type
	 * 
	 * @return the new type type
	 */
/*    @SuppressWarnings("unchecked")
	protected TypeType<C, O> createTypeType(C type) {
		TypeType<C, O> result = oclFactory.createTypeType(type);
		
		addClassifier(getTypePackage(), (C) result);
		
		return result;
	} */
	
	/**
	 * Finds an existing type type matching the specified <code>type</code>,
	 * if any has already been created.
	 * 
	 * @param type the referenced model type
	 * 
	 * @return the existing type type, or <code>null</code> if none found
	 *
	protected TypeType<C, O> findTypeType(C type) {
		for (C next : uml.getClassifiers(getTypePackage())) {
            if (next instanceof TypeType<?, ?>) {
    			@SuppressWarnings("unchecked")
    			TypeType<C, O> typeType =
    				(TypeType<C, O>) next;
    			
    			if (TypeUtil.getRelationship(
    					env,
    					typeType.getReferredType(),
    					type) == UMLReflection.SAME_TYPE) {
    				
    				return typeType;
    			}
            }
		}
		
		return null;
	} */
	
	/**
	 * Obtains the package containing the message types that I generate.
	 * 
	 * @return my message type package
	 */
	public org.eclipse.ocl.examples.pivot.Package getMessagePackage() {
		if (messagePackage == null) {
			messagePackage = findMessagePackage();
			if (messagePackage == null) {
				messagePackage = createMessagePackage();
			}
		}
		
		return messagePackage;
	}
	
	/**
	 * Creates the package containing the message types that I generate.
	 * 
	 * @return the new message type package
	 */
    protected org.eclipse.ocl.examples.pivot.Package createMessagePackage() {
        return createPackage(MESSAGES_PACKAGE);
    }
	
	/**
	 * Finds the package storing message types, if our resource already
	 * contains it.
	 * 
	 * @return the existing message types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected org.eclipse.ocl.examples.pivot.Package findMessagePackage() {
		return findPackage(MESSAGES_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public MessageType resolveOperationMessageType(Operation operation) {
		if (operation == getOclMessage().getReferredOperation()) {
			// this is the canonical OclMessage type
			return getOclMessage();
		}
		
		MessageType result = findMessageType(operation);
		
		if (result == null) {
			result = createOperationMessageType(operation);
		}
		
		return result;
	}
	
	// Documentation copied from the inherited specification
	public MessageType resolveSignalMessageType(Signal signal) {
		if (signal == getOclMessage().getReferredSignal()) {
			// this is the canonical OclMessage type
			return getOclMessage();
		}
		
		MessageType result = findMessageType(signal);
		
		if (result == null) {
			result = createSignalMessageType(signal);
		}
		
		return result;
	}
	
	private MessageType getOclMessage() {
		if (oclMessage == null) {
			oclMessage = (MessageType) getEnvironment().getOCLStandardLibrary()
					.getOclMessageType();
		}
		
		return oclMessage;
	}
	
	/**
	 * Creates a new message type for the specified <code>element</code>,
	 * assuming that it does not already exist.
	 * 
	 * @param operation the operation referenced by the message type
	 * 
	 * @return the new message type
	 */
	protected MessageType createOperationMessageType(Operation operation) {
		MessageType result = oclFactory.createOperationMessageType(operation);
		addClassifier(getMessagePackage(), (Type) result);
		return result;
	}
	
	/**
	 * Creates a new message type for the specified <code>element</code>,
	 * assuming that it does not already exist.
	 * 
	 * @param signal the signal referenced by the message type
	 * 
	 * @return the new message type
	 */
	protected MessageType createSignalMessageType(Signal signal) {
		MessageType result = oclFactory.createSignalMessageType(signal);
		addClassifier(getMessagePackage(), (Type) result);
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
	protected MessageType findMessageType(Object element) {
		for (Type next : uml.getClassifiers(getMessagePackage())) {
            if (next instanceof MessageType) {
    			MessageType type = (MessageType) next;
    			
    			if ((type.getReferredOperation() == element)
    					|| (type.getReferredSignal() == element)) {
    				
    				return type;
    			}
            }
		}
		
		return null;
	}
	
	/**
	 * Obtains the package containing the additional operations and properties
	 * parsed in my environment.
	 * 
	 * @return my additional features package
	 */
	public org.eclipse.ocl.examples.pivot.Package getAdditionalFeaturesPackage() {
		if (additionalFeaturesPackage == null) {
			additionalFeaturesPackage = findAdditionalFeaturesPackage();
			if (additionalFeaturesPackage == null) {
				additionalFeaturesPackage = createAdditionalFeaturesPackage();
			}
		}
		
		return additionalFeaturesPackage;
	}
	
	/**
	 * Creates the package containing the additional operations and properties
	 * parsed in my environment.
	 * 
	 * @return the new additional features package
	 */
    protected org.eclipse.ocl.examples.pivot.Package createAdditionalFeaturesPackage() {
        return createPackage(ADDITIONS_PACKAGE);
    }
    
	/**
	 * Finds the package storing additional features, if our resource already
	 * contains it.
	 * 
	 * @return the existing additional features package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected org.eclipse.ocl.examples.pivot.Package findAdditionalFeaturesPackage() {
		return findPackage(ADDITIONS_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public Operation resolveAdditionalOperation(Type owner, Operation operation) {
		Type shadow = getShadowClass(owner);
		
		Operation result = findMatchingOperation(shadow, operation);
		if (result == null) {
			result = operation;
			addOperation(shadow, result);
		}
		
		return result;
	}
	
	public List<Operation> getAdditionalOperations(Type owner) {
        if (hasAdditionalFeatures()) {
    		Type shadow = findShadowClass(owner);
    		
    		if (shadow != null) {
    			return uml.getOperations(shadow);
    		}
        }
        
		return ECollections.emptyEList();
	}
	
	/**
	 * Finds an operation already existing in the specified <code>shadow</code>
	 * class that matches the specified <code>operation</code> signature.
	 * 
	 * @param shadow the shadow class to search
	 * @param operation the operation to match
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	protected Operation findMatchingOperation(Type shadow, Operation operation) {
        String operationName = uml.getName(operation);
        
		for (Operation next : uml.getOperations(shadow)) {
			if ((next == operation)
					|| (uml.getName(next).equals(operationName)
							&& matchParameters(next, operation))) {
				return next;
			}
		}
		
		return null;
	}
	
    /**
     * Determines whether two operations have the same parameter signature.
     * 
     * @param a an operation
     * @param b another operation
     * 
     * @return <code>true</code> if they have the same formal parameters in the
     *    same order; <code>false</code>, otherwise
     */
	private boolean matchParameters(Operation a, Operation b) {
		List<Parameter> aparms = uml.getParameters(a);
		List<Parameter> bparms = uml.getParameters(b);
		
		if (aparms.size() == bparms.size()) {
			int count = aparms.size();
			
			for (int i = 0; i < count; i++) {
				Parameter aparm = aparms.get(i);
				Parameter bparm = bparms.get(i);
				
				if (!uml.getName(aparm).equals(uml.getName(bparm))
						|| TypeUtil.getRelationship(
								env,
								resolve(uml.getOCLType(aparm)),
								resolve(uml.getOCLType(bparm)))
							!= UMLReflection.SAME_TYPE) {
					
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Finds a property already existing in the specified <code>shadow</code>
	 * class that matches the specified <code>property</code> signature.
	 * 
	 * @param shadow the shadow class to search
	 * @param property the property to match
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	protected Property findMatchingProperty(Type shadow, Property property) {
        String propertyName = uml.getName(property);
        
		for (Property next : uml.getAttributes(shadow)) {
			if ((next == property) || uml.getName(next).equals(propertyName)) {
				return next;
			}
		}
		
		return null;
	}
	
	// Documentation copied from the inherited specification
	public Property resolveAdditionalAttribute(Type owner, Property property) {
		Type shadow = getShadowClass(owner);
		
		Property result = findMatchingProperty(shadow, property);
		if (result == null) {
			result = property;
			addProperty(shadow, result);
		}
		
		return result;
	}
	
    /**
     * Queries whether the current environment has any additional features
     * defined at all.
     * 
     * @return whether I have any additional features 
     */
    protected boolean hasAdditionalFeatures() {
        // if I was loaded from an existing resource, I may not yet have looked
        // for my additional-features package
        return (additionalFeaturesPackage != null)
            || (findAdditionalFeaturesPackage() != null);
    }
    
	public List<Property> getAdditionalAttributes(Type owner) {
        if (hasAdditionalFeatures()) {
    		Type shadow = findShadowClass(owner);
    		
    		if (shadow != null) {
    			return uml.getAttributes(shadow);
    		}
        }
        
		return ECollections.emptyEList();
	}
	
	/**
	 * Creates the shadow class to contain additional features defined for the
	 * specified OCL <code>type</code>.
	 * 
	 * @param type an OCL type
	 * 
	 * @return the class containing its additional features
	 */
	protected abstract Type createShadowClass(Type type);
	
    /**
     * Adds the specified property to a classifier.
     * 
     * @param owner the classifier to own the property
     * @param property the property to add to the classifier
     */
    protected abstract void addProperty(Type owner, Property property);
    
    /**
     * Adds the specified operation to a classifier.
     * 
     * @param owner the classifier to own the operation
     * @param operation the operation to add to the classifier
     */
    protected abstract void addOperation(Type owner, Operation operation);
    
	/**
	 * Finds the shadow class to contain additional features defined for the
	 * specified OCL <code>type</code>, if it already exists.
	 * 
	 * @param type an OCL type
	 * 
	 * @return the class containing its additional features, or <code>null</code>
	 *      if not found
	 */
	protected Type findShadowClass(Type type) {
        org.eclipse.ocl.examples.pivot.Package pkg = hasAdditionalFeatures()? getAdditionalFeaturesPackage() : null;
        
        if (pkg != null) {
    		for (Type next : uml.getClassifiers(pkg)) {
    			if (getShadowedClassifier(next) == type) {
    				return next;
    			}
    		}
        }
        
		return null;
	}
	
    /**
     * Obtains the classifier for which the specified shadow stores additional
     * features.
     * 
     * @param shadow a class originally created to shadow a model classifier
     * 
     * @return the model classifier that it supports
     * 
     * @see #createShadowClass(Object)
     * @see #getShadowClass(Object)
     */
	protected abstract Type getShadowedClassifier(Type shadow);
	
    /**
     * Obtains the shadow class for the specified model classifier, creating
     * it if necessary.  The shadow class will store attributes and operations
     * on behalf of this model classifier.
     * 
     * @param type a classifier in the model 
     * @return its shadow
     */
	protected Type getShadowClass(Type type) {
		Type result = findShadowClass(type);
		
		if (result == null) {
			result = createShadowClass(type);
            
            org.eclipse.ocl.examples.pivot.Package pkg = getAdditionalFeaturesPackage();
            
            if (pkg != null) {
                addClassifier(pkg, result);
            }
		}
		
		return result;
	}
    
    /**
     * Creates a package with the specified name.  This puts the new package
     * in an appropriate place in my {@linkplain #getResource() resource}.
     * 
     * @param name the package name
     * @return the new package, persisted in my resource
     */
    protected abstract org.eclipse.ocl.examples.pivot.Package createPackage(String name);
    
    /**
     * Finds the existing package with the specified name in my resource.
     * This will be one of the packages that I would create for storing
     * OCL-generated types.
     * 
     * @param name the package to seek
     * @return the package, or <code>null</code> if none
     */
    protected abstract org.eclipse.ocl.examples.pivot.Package findPackage(String name);
    
    /**
     * Adds a classifier to the specified package, which is one that I use to
     * store OCL-generated types.
     * 
     * @param pkg one of my packages
     * @param classifier a classifier to add to it
     */
    protected abstract void addClassifier(org.eclipse.ocl.examples.pivot.Package pkg, Type classifier);
	
	/**
	 * A type switch that resolves types against my resolver's environment.
	 * 
	 * @author Christian W. Damus (cdamus)
	 *
    @SuppressWarnings("unchecked")
	private class ResolveSwitch extends TypesSwitch<Type> {
		@Override
		public Type caseCollectionType(CollectionType object) {
			return (Type) resolveCollectionType(object.getKind(),
				resolve((Type) object.getElementType()));
		}
		
		@Override
		public Type caseTupleType(TupleType object) {
			return (Type) resolveTupleType(createTupleParts(
                (EList<Property>) object.oclProperties()));
		}
		
		@Override
		public Type caseTypeType(TypeType object) {
			return (Type) resolveTypeType(resolve((Type) object.getReferredType()));
		}
		
		@Override
		public Type caseMessageType(MessageType object) {
			if (object.getReferredOperation() != null) {
				return (Type) resolveOperationMessageType((Operation) object.getReferredOperation());
			} else if (object.getReferredSignal() != null) {
				return (Type) resolveSignalMessageType((Type) object.getReferredSignal());
			}
			
			return null;
		}
		
        /**
         * In the default case, the classifier is defined by the user model or
         * by the OCL Standard Library, so it isn't persisted in the environment.
         * 
         * @param object a classifier
         * @return the same classifier
         * /
		@Override
        public Type defaultCase(EObject object) {
			return (Type) object;
		}
		
		private EList<Variable> createTupleParts(Collection<Property> properties) {
			EList<Variable> result = new BasicEList.FastCompare<Variable>();
			
			OCLFactory oclFactory = env.getOCLFactory();
			
			for (Property next : properties) {
				Variable v = oclFactory.createVariable();
				uml.setName(v, uml.getName(next));
				uml.setType(v, resolve(uml.getOCLType(next)));
				result.add(v);
			}
			
			return result;
		}
	} */
    
    /**
     * Disposes me by unloading my resource, if and only if I created it in
     * the first place.  If I was loaded from an existing resource, then it is
     * the client's responsibility to manage it.
     * 
     * @since 1.2
     */
    public void dispose() {
        if (shouldDisposeResource && (resource != null)) {
            if (resource.isLoaded()) {
                resource.unload();
            }
            
            if (resource.getResourceSet() != null) {
                resource.getResourceSet().getResources().remove(resource);
            }
            
            resource = null;
        }
    }
}
