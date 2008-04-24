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
 *   Adolfo Sánchez-Barbudo Herrera - 222581 generic collection type resolution
 *
 * </copyright>
 *
 * $Id: AbstractTypeResolver.java,v 1.12 2008/04/24 23:37:20 cdamus Exp $
 */
package org.eclipse.ocl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.util.TypesSwitch;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;


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
public abstract class AbstractTypeResolver<PK, C, O, P, PM>
	implements TypeResolver<C, O, P> {

    protected static final String COLLECTIONS_PACKAGE = "collections"; //$NON-NLS-1$
    protected static final String MESSAGES_PACKAGE = "messages"; //$NON-NLS-1$
    protected static final String TUPLES_PACKAGE = "tuples"; //$NON-NLS-1$
    protected static final String TYPES_PACKAGE = "types"; //$NON-NLS-1$
    protected static final String ADDITIONS_PACKAGE = "additions"; //$NON-NLS-1$

	private final TypesSwitch<C> resolveSwitch = new ResolveSwitch();
	
	private final Environment<PK, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> env;
    private final OCLFactory oclFactory;
    private final UMLReflection<PK, C, O, P, ?, PM, ?, ?, ?, ?> uml;
    
	private Resource resource;
	
	// whether I should dispose my resource because I created it
	private boolean shouldDisposeResource;
	
	private PK collectionPackage;
	private PK tuplePackage;
	private PK typePackage;
	private PK messagePackage;
	private PK additionalFeaturesPackage;
	
	private CollectionType<C, O> collection;
	private SetType<C, O> set;
	private OrderedSetType<C, O> orderedSet;
	private BagType<C, O> bag;
	private SequenceType<C, O> sequence;
	private TypeType<C, O> oclType;
	private MessageType<C, O, P> oclMessage;

	/**
	 * Initializes me with an environment.  I create my own resource for
     * persistence of model-based types.
     * 
     * @param env the environment that I persist
	 */
	public AbstractTypeResolver(
            Environment<PK, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> env) {
		this(env, null);
	}
	
	/**
	 * Initializes me with a resource in which I will persist the model-based
	 * types that I generate in my associated {@link Environment}.
	 * 
     * @param env my environment
	 * @param resource my resource
	 */
	public AbstractTypeResolver(
            Environment<PK, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> env,
            Resource resource) {
		this.env = env;
		this.resource = resource;
        
        oclFactory = env.getOCLFactory();
        uml = env.getUMLReflection();
	}
	
	// Documentation copied from the inherited specification
	public C resolve(C type) {
		C result = (type == null)? type : resolveSwitch.doSwitch((EObject) type);
		
		if ((result != null) && (result != type)) {
		    // dispose the old type; it won't be used
		    ObjectUtil.dispose(type);
		}
		
		return result;
	}
	
    /**
     * Obtains the environment that I persist.
     * 
     * @return my environment
     */
    protected final Environment<PK, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> getEnvironment() {
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
	public PK getCollectionPackage() {
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
	protected PK createCollectionPackage() {
	    return createPackage(COLLECTIONS_PACKAGE);
    }
	
	/**
	 * Finds the package storing collection types, if our resource already
	 * contains it.
	 * 
	 * @return the existing collection types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected PK findCollectionPackage() {
		return findPackage(COLLECTIONS_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public CollectionType<C, O> resolveCollectionType(
			CollectionKind kind,
			C elementType) {
		
	    CollectionType<C, O> result;
	    
		if (elementType == getCollection().getElementType()) {
			switch (kind) {
				case SET_LITERAL :
				    result = getSet();
				    break;
				case ORDERED_SET_LITERAL:
				    result = getOrderedSet();
                    break;
				case SEQUENCE_LITERAL:
				    result = getSequence();
                    break;
				case BAG_LITERAL:
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
	
	@SuppressWarnings("unchecked")
	private CollectionType<C, O> getCollection() {
		if (collection == null) {
			collection = (CollectionType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getCollection();
		}
		
		return collection;
	}
	
	@SuppressWarnings("unchecked")
	private SetType<C, O> getSet() {
		if (set == null) {
			set = (SetType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getSet();
		}
		
		return set;
	}
	
	@SuppressWarnings("unchecked")
	private OrderedSetType<C, O> getOrderedSet() {
		if (orderedSet == null) {
			orderedSet = (OrderedSetType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getOrderedSet();
		}
		
		return orderedSet;
	}
	
	@SuppressWarnings("unchecked")
	private SequenceType<C, O> getSequence() {
		if (sequence == null) {
			sequence = (SequenceType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getSequence();
		}
		
		return sequence;
	}
	
	@SuppressWarnings("unchecked")
	private BagType<C, O> getBag() {
		if (bag == null) {
			bag = (BagType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getBag();
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
    @SuppressWarnings("unchecked")
	protected CollectionType<C, O> createCollectionType(
			CollectionKind kind, C elementType) {
		
		CollectionType<C, O> result =
			oclFactory.createCollectionType(kind, elementType);
		addClassifier(getCollectionPackage(), (C) result);
		
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
	protected CollectionType<C, O> findCollectionType(
			CollectionKind kind, C elementType) {
		
		for (C next : uml.getClassifiers(getCollectionPackage())) {
            if (next instanceof CollectionType) {
    			@SuppressWarnings("unchecked")
    			CollectionType<C, O> type =
    				(CollectionType<C, O>) next;
    			
    			if ((type.getKind() == kind) &&
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
	public PK getTuplePackage() {
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
    protected PK createTuplePackage() {
        return createPackage(TUPLES_PACKAGE);
    }
	
	/**
	 * Finds the package storing tuple types, if our resource already
	 * contains it.
	 * 
	 * @return the existing tuple types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected PK findTuplePackage() {
		return findPackage(TUPLES_PACKAGE);
	}

	// Documentation copied from the inherited specification
	public TupleType<O, P> resolveTupleType(
			EList<? extends TypedElement<C>> parts) {
		TupleType<O, P> result = findTupleType(parts);
		
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
    @SuppressWarnings("unchecked")
	protected TupleType<O, P> createTupleType(
			EList<? extends TypedElement<C>> parts) {
		TupleType<O, P> result =
			oclFactory.createTupleType(parts);
		
		addClassifier(getTuplePackage(), (C) result);
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
	protected TupleType<O, P> findTupleType(
			EList<? extends TypedElement<C>> parts) {
		for (C next : uml.getClassifiers(getTuplePackage())) {
            if (next instanceof TupleType) {
    			@SuppressWarnings("unchecked")
    			TupleType<O, P> type =
    				(TupleType<O, P>) next;
    			
    			if (type.oclProperties().size() == parts.size()) {
    			    boolean match = true;
    			    
    				for (TypedElement<C> part : parts) {
                        @SuppressWarnings("unchecked")
    					P property = env.lookupProperty((C) type, part.getName());
    					
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
	public PK getTypePackage() {
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
    protected PK createTypePackage() {
        return createPackage(TYPES_PACKAGE);
    }
	
	/**
	 * Finds the package storing type types, if our resource already
	 * contains it.
	 * 
	 * @return the existing type types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected PK findTypePackage() {
		return findPackage(TYPES_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public TypeType<C, O> resolveTypeType(C type) {
		if (type == getOclType().getReferredType()) {
			// this is the canonical OclType instance
			return getOclType();
		}
		
		TypeType<C, O> result = findTypeType(type);
		
		if (result == null) {
			result = createTypeType(type);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private TypeType<C, O> getOclType() {
		if (oclType == null) {
			oclType = (TypeType<C, O>) getEnvironment().getOCLStandardLibrary()
					.getOclType();
		}
		
		return oclType;
	}
	
	/**
	 * Creates a new type type for the specified <code>type</code>,
	 * assuming that it does not already exist.
	 * 
	 * @param type the referenced model type
	 * 
	 * @return the new type type
	 */
    @SuppressWarnings("unchecked")
	protected TypeType<C, O> createTypeType(C type) {
		TypeType<C, O> result = oclFactory.createTypeType(type);
		
		addClassifier(getTypePackage(), (C) result);
		
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
	protected TypeType<C, O> findTypeType(C type) {
		for (C next : uml.getClassifiers(getTypePackage())) {
            if (next instanceof TypeType) {
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
	}
	
	/**
	 * Obtains the package containing the message types that I generate.
	 * 
	 * @return my message type package
	 */
	public PK getMessagePackage() {
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
    protected PK createMessagePackage() {
        return createPackage(MESSAGES_PACKAGE);
    }
	
	/**
	 * Finds the package storing message types, if our resource already
	 * contains it.
	 * 
	 * @return the existing message types package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected PK findMessagePackage() {
		return findPackage(MESSAGES_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public MessageType<C, O, P> resolveOperationMessageType(O operation) {
		if (operation == getOclMessage().getReferredOperation()) {
			// this is the canonical OclMessage type
			return getOclMessage();
		}
		
		MessageType<C, O, P> result = findMessageType(operation);
		
		if (result == null) {
			result = createOperationMessageType(operation);
		}
		
		return result;
	}
	
	// Documentation copied from the inherited specification
	public MessageType<C, O, P> resolveSignalMessageType(C signal) {
		if (signal == getOclMessage().getReferredSignal()) {
			// this is the canonical OclMessage type
			return getOclMessage();
		}
		
		MessageType<C, O, P> result = findMessageType(signal);
		
		if (result == null) {
			result = createSignalMessageType(signal);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private MessageType<C, O, P> getOclMessage() {
		if (oclMessage == null) {
			oclMessage = (MessageType<C, O, P>) getEnvironment().getOCLStandardLibrary()
					.getOclMessage();
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
    @SuppressWarnings("unchecked")
	protected MessageType<C, O, P> createOperationMessageType(O operation) {
		MessageType<C, O, P> result =
			oclFactory.createOperationMessageType(operation);
		addClassifier(getMessagePackage(), (C) result);
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
    @SuppressWarnings("unchecked")
	protected MessageType<C, O, P> createSignalMessageType(C signal) {
		MessageType<C, O, P> result =
			oclFactory.createSignalMessageType(signal);
		addClassifier(getMessagePackage(), (C) result);
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
	protected MessageType<C, O, P> findMessageType(Object element) {
		for (C next : uml.getClassifiers(getMessagePackage())) {
            if (next instanceof MessageType) {
    			@SuppressWarnings("unchecked")
    			MessageType<C, O, P> type =
    				(MessageType<C, O, P>) next;
    			
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
	public PK getAdditionalFeaturesPackage() {
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
    protected PK createAdditionalFeaturesPackage() {
        return createPackage(ADDITIONS_PACKAGE);
    }
    
	/**
	 * Finds the package storing additional features, if our resource already
	 * contains it.
	 * 
	 * @return the existing additional features package, or <code>null</code>
	 *    if it does not yet exist
	 */
	protected PK findAdditionalFeaturesPackage() {
		return findPackage(ADDITIONS_PACKAGE);
	}
	
	// Documentation copied from the inherited specification
	public O resolveAdditionalOperation(C owner, O operation) {
		C shadow = getShadowClass(owner);
		
		O result = findMatchingOperation(shadow, operation);
		if (result == null) {
			result = operation;
			addOperation(shadow, result);
		}
		
		return result;
	}
	
	public List<O> getAdditionalOperations(C owner) {
        if (hasAdditionalFeatures()) {
    		C shadow = findShadowClass(owner);
    		
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
	protected O findMatchingOperation(C shadow, O operation) {
        String operationName = uml.getName(operation);
        
		for (O next : uml.getOperations(shadow)) {
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
	private boolean matchParameters(O a, O b) {
		List<PM> aparms = uml.getParameters(a);
		List<PM> bparms = uml.getParameters(b);
		
		if (aparms.size() == bparms.size()) {
			int count = aparms.size();
			
			for (int i = 0; i < count; i++) {
				PM aparm = aparms.get(i);
				PM bparm = bparms.get(i);
				
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
	protected P findMatchingProperty(C shadow, P property) {
        String propertyName = uml.getName(property);
        
		for (P next : uml.getAttributes(shadow)) {
			if ((next == property) || uml.getName(next).equals(propertyName)) {
				return next;
			}
		}
		
		return null;
	}
	
	// Documentation copied from the inherited specification
	public P resolveAdditionalAttribute(C owner, P property) {
		C shadow = getShadowClass(owner);
		
		P result = findMatchingProperty(shadow, property);
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
    
	public List<P> getAdditionalAttributes(C owner) {
        if (hasAdditionalFeatures()) {
    		C shadow = findShadowClass(owner);
    		
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
	protected abstract C createShadowClass(C type);
	
    /**
     * Adds the specified property to a classifier.
     * 
     * @param owner the classifier to own the property
     * @param property the property to add to the classifier
     */
    protected abstract void addProperty(C owner, P property);
    
    /**
     * Adds the specified operation to a classifier.
     * 
     * @param owner the classifier to own the operation
     * @param operation the operation to add to the classifier
     */
    protected abstract void addOperation(C owner, O operation);
    
	/**
	 * Finds the shadow class to contain additional features defined for the
	 * specified OCL <code>type</code>, if it already exists.
	 * 
	 * @param type an OCL type
	 * 
	 * @return the class containing its additional features, or <code>null</code>
	 *      if not found
	 */
	protected C findShadowClass(C type) {
        PK pkg = hasAdditionalFeatures()? getAdditionalFeaturesPackage() : null;
        
        if (pkg != null) {
    		for (C next : uml.getClassifiers(pkg)) {
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
	protected abstract C getShadowedClassifier(C shadow);
	
    /**
     * Obtains the shadow class for the specified model classifier, creating
     * it if necessary.  The shadow class will store attributes and operations
     * on behalf of this model classifier.
     * 
     * @param type a classifier in the model 
     * @return its shadow
     */
	protected C getShadowClass(C type) {
		C result = findShadowClass(type);
		
		if (result == null) {
			result = createShadowClass(type);
            
            PK pkg = getAdditionalFeaturesPackage();
            
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
    protected abstract PK createPackage(String name);
    
    /**
     * Finds the existing package with the specified name in my resource.
     * This will be one of the packages that I would create for storing
     * OCL-generated types.
     * 
     * @param name the package to seek
     * @return the package, or <code>null</code> if none
     */
    protected abstract PK findPackage(String name);
    
    /**
     * Adds a classifier to the specified package, which is one that I use to
     * store OCL-generated types.
     * 
     * @param pkg one of my packages
     * @param classifier a classifier to add to it
     */
    protected abstract void addClassifier(PK pkg, C classifier);
	
	/**
	 * A type switch that resolves types against my resolver's environment.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
    @SuppressWarnings("unchecked")
	private class ResolveSwitch extends TypesSwitch<C> {
		@Override
		public <C1, O1> C caseCollectionType(CollectionType<C1, O1> object) {
			return (C) resolveCollectionType(object.getKind(),
				resolve((C) object.getElementType()));
		}
		
		@Override
		public <O1, P1> C caseTupleType(TupleType<O1, P1> object) {
			return (C) resolveTupleType(createTupleParts(
                (EList<P>) object.oclProperties()));
		}
		
		@Override
		public <C1, O1> C caseTypeType(TypeType<C1, O1> object) {
			return (C) resolveTypeType(resolve((C) object.getReferredType()));
		}
		
		@Override
		public <C1, O1, P1> C caseMessageType(MessageType<C1, O1, P1> object) {
			if (object.getReferredOperation() != null) {
				return (C) resolveOperationMessageType((O) object.getReferredOperation());
			} else if (object.getReferredSignal() != null) {
				return (C) resolveSignalMessageType((C) object.getReferredSignal());
			}
			
			return null;
		}
		
        /**
         * In the default case, the classifier is defined by the user model or
         * by the OCL Standard Library, so it isn't persisted in the environment.
         * 
         * @param object a classifier
         * @return the same classifier
         */
		@Override
        public C defaultCase(EObject object) {
			return (C) object;
		}
		
		private EList<Variable<C, PM>> createTupleParts(
				Collection<P> properties) {
			EList<Variable<C, PM>> result =
                new BasicEList.FastCompare<Variable<C, PM>>();
			
			OCLFactory oclFactory = env.getOCLFactory();
			
			for (P next : properties) {
				Variable<C, PM> v = oclFactory.createVariable();
				uml.setName(v, uml.getName(next));
				uml.setType(v, resolve(uml.getOCLType(next)));
				result.add(v);
			}
			
			return result;
		}
	}
    
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
