/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: OCLStandardLibraryImpl.java,v 1.5 2008/01/03 20:20:56 cdamus Exp $
 */

package org.eclipse.ocl.ecore.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.ElementType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * Implementation of the {@link OCLStandardLibrary} for the Ecore environment.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class OCLStandardLibraryImpl implements OCLStandardLibrary<EClassifier> {
    private static final String NS_URI = "http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore"; //$NON-NLS-1$
    
	private static EClassifier OCL_ANY;
	private static EClassifier OCL_ELEMENT;
	private static EClassifier OCL_BOOLEAN;
	private static EClassifier OCL_INTEGER;
    private static EClassifier OCL_UNLIMITED_NATURAL;
	private static EClassifier OCL_REAL;
	private static EClassifier OCL_STRING;
	private static EClassifier OCL_VOID;
	private static EClassifier OCL_MESSAGE;
	private static EClassifier OCL_TYPE;

	private static EClassifier INVALID;
	
	private static EClassifier OCL_T;
	private static EClassifier OCL_T2;
	
	private static EClassifier OCL_SET;
	private static EClassifier OCL_ORDERED_SET;
	private static EClassifier OCL_BAG;
	private static EClassifier OCL_SEQUENCE;
	private static EClassifier OCL_COLLECTION;
	
	private static EClassifier STATE;
	private static EClassifier OCL_EXPRESSION;
    
    // this must be initialized ahead of stdlibPackage, which depends on it
    /** The shared instance of the OCL Standard Library for the UML environment. */
    public static final OCLStandardLibraryImpl INSTANCE = new OCLStandardLibraryImpl();

    /** The package containing the OCL Standard Library classifiers. */
	public static EPackage stdlibPackage = init();
    
    /** The singleton instance of the <tt>Invalid</tt> standard library type. */
    public static final EObject OCL_INVALID = stdlibPackage.getEFactoryInstance().create(
        (EClass) stdlibPackage.getEClassifier("Invalid_Class")); //$NON-NLS-1$
    
    // not instantiable by clients
	private OCLStandardLibraryImpl() {
		super();
	}
	
	public EClassifier getBoolean() {
		return OCL_BOOLEAN;
	}

	public EClassifier getInteger() {
		return OCL_INTEGER;
	}

    public EClassifier getUnlimitedNatural() {
        return OCL_UNLIMITED_NATURAL;
    }
    
	public EClassifier getInvalid() {
		return INVALID;
	}

	public EClassifier getReal() {
		return OCL_REAL;
	}

	public EClassifier getString() {
		return OCL_STRING;
	}

	public EClassifier getOclAny() {
		return OCL_ANY;
	}

	public EClassifier getOclElement() {
		return OCL_ELEMENT;
	}

	public Object getOclInvalid() {
		return OCL_INVALID;
	}

	public EClassifier getState() {
		return STATE;
	}

	public EClassifier getOclMessage() {
		return OCL_MESSAGE;
	}
	
	public EClassifier getOclType() {
		return OCL_TYPE;
	}

	public EClassifier getOclVoid() {
		return OCL_VOID;
	}
	
	public EClassifier getT() {
		return OCL_T;
	}
	
	public EClassifier getT2() {
		return OCL_T2;
	}
	
	public EClassifier getSet() {
		return OCL_SET;
	}
	
	public EClassifier getOrderedSet() {
		return OCL_ORDERED_SET;
	}
	
	public EClassifier getBag() {
		return OCL_BAG;
	}
	
	public EClassifier getSequence() {
		return OCL_SEQUENCE;
	}
	
	public EClassifier getCollection() {
		return OCL_COLLECTION;
	}
	
	public EClassifier getOclExpression() {
		return OCL_EXPRESSION;
	}
	
    private static EPackage init() {
        if (stdlibPackage != null) {
            return stdlibPackage;
        }
        
        ResourceSet rset = new ResourceSetImpl();
        Resource res = null;
        
        try {
            Resource load = rset.getResource(URI.createURI(NS_URI), true);
            
            // transfer the loaded resource contents to a new resource that
            //    decodes URI fragments when resolving objects 
            res = OCLEcorePlugin.getEcoreResourceFactory().createResource(load.getURI());
            res.getContents().addAll(load.getContents());
            
            stdlibPackage = (EPackage) res.getContents().get(0);
            
            OCL_ANY = stdlibPackage.getEClassifier(AnyType.SINGLETON_NAME);
            OCL_ELEMENT = stdlibPackage.getEClassifier(ElementType.SINGLETON_NAME);
            OCL_BOOLEAN = stdlibPackage.getEClassifier(PrimitiveType.BOOLEAN_NAME);
            OCL_INTEGER = stdlibPackage.getEClassifier(PrimitiveType.INTEGER_NAME);
            OCL_UNLIMITED_NATURAL = stdlibPackage.getEClassifier(PrimitiveType.UNLIMITED_NATURAL_NAME);
            OCL_REAL = stdlibPackage.getEClassifier(PrimitiveType.REAL_NAME);
            OCL_STRING = stdlibPackage.getEClassifier(PrimitiveType.STRING_NAME);
            OCL_VOID = stdlibPackage.getEClassifier(VoidType.SINGLETON_NAME);
            OCL_MESSAGE = stdlibPackage.getEClassifier(MessageType.SINGLETON_NAME);

            INVALID = stdlibPackage.getEClassifier(InvalidType.SINGLETON_NAME);
            
            OCL_T = stdlibPackage.getEClassifier("T"); //$NON-NLS-1$
            OCL_T2 = stdlibPackage.getEClassifier("T2"); //$NON-NLS-1$
            
            OCL_TYPE = (EClassifier) EcoreUtil.getObjectByType(
                    stdlibPackage.getEClassifiers(),
                    EcorePackage.Literals.TYPE_TYPE);
            
            OCL_SET = (EClassifier) EcoreUtil.getObjectByType(
                stdlibPackage.getEClassifiers(),
                EcorePackage.Literals.SET_TYPE);
            OCL_ORDERED_SET = (EClassifier) EcoreUtil.getObjectByType(
                stdlibPackage.getEClassifiers(),
                EcorePackage.Literals.ORDERED_SET_TYPE);
            OCL_BAG = (EClassifier) EcoreUtil.getObjectByType(
                stdlibPackage.getEClassifiers(),
                EcorePackage.Literals.BAG_TYPE);
            OCL_SEQUENCE = (EClassifier) EcoreUtil.getObjectByType(
                stdlibPackage.getEClassifiers(),
                EcorePackage.Literals.SEQUENCE_TYPE);
            
            // don't use EcoreUtil because the other collection types would match
            OCL_COLLECTION = stdlibPackage.getEClassifier("Collection(T)"); //$NON-NLS-1$
            
            STATE = stdlibPackage.getEClassifier("State"); //$NON-NLS-1$
            OCL_EXPRESSION = stdlibPackage.getEClassifier("OclExpression"); //$NON-NLS-1$
            
            EPackage.Registry.INSTANCE.put(stdlibPackage.getNsURI(), stdlibPackage);
            
            return stdlibPackage;
        } catch (Exception e) {
            // normal case: the library file isn't there because we are
            //    generating it on the fly.  Let's do that, then
            
            return build();
        } finally {
            if (res != null) {
                // don't want this resource to be in a resource set
                rset.getResources().remove(res);
            }
        }
    }
    
    // this method is used to build the standard library when not loading it
    //   from file
	private static EPackage build() {
		if (stdlibPackage != null) {
			return stdlibPackage;
		}
		
        Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> old = Environment.Registry.INSTANCE.getEnvironmentFor(
            EcorePackage.Literals.ANY_TYPE);
        
		stdlibPackage = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
		stdlibPackage.setName("oclstdlib"); //$NON-NLS-1$
		stdlibPackage.setNsPrefix("oclstdlib"); //$NON-NLS-1$
		stdlibPackage.setNsURI(NS_URI);
		
		Resource.Factory factory = OCLEcorePlugin.getEcoreResourceFactory();
        Resource res = factory.createResource(URI.createURI(stdlibPackage.getNsURI()));
		res.getContents().add(stdlibPackage);
		
        Environment.Registry.INSTANCE.deregisterEnvironment(old);
        EcoreEnvironment env =
            (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.loadEnvironment(
                res);
        Environment.Registry.INSTANCE.registerEnvironment(env);
        
        OCL_ANY = EcoreFactory.eINSTANCE.createAnyType();
        OCL_ELEMENT = EcoreFactory.eINSTANCE.createElementType();
        OCL_BOOLEAN = EcoreFactory.eINSTANCE.createPrimitiveType();
        OCL_BOOLEAN.setName(PrimitiveType.BOOLEAN_NAME);
        OCL_INTEGER = EcoreFactory.eINSTANCE.createPrimitiveType();
        OCL_INTEGER.setName(PrimitiveType.INTEGER_NAME);
        OCL_UNLIMITED_NATURAL = EcoreFactory.eINSTANCE.createPrimitiveType();
        OCL_UNLIMITED_NATURAL.setName(PrimitiveType.UNLIMITED_NATURAL_NAME);
        OCL_REAL = EcoreFactory.eINSTANCE.createPrimitiveType();
        OCL_REAL.setName(PrimitiveType.REAL_NAME);
        OCL_STRING = EcoreFactory.eINSTANCE.createPrimitiveType();
        OCL_STRING.setName(PrimitiveType.STRING_NAME);
        OCL_VOID = EcoreFactory.eINSTANCE.createVoidType();
        OCL_MESSAGE = EcoreFactory.eINSTANCE.createMessageType();

        INVALID = EcoreFactory.eINSTANCE.createInvalidType();
        
        OCL_T = EcoreFactory.eINSTANCE.createAnyType();
        OCL_T.setName("T"); //$NON-NLS-1$
        OCL_T2 = EcoreFactory.eINSTANCE.createAnyType();
        OCL_T2.setName("T2"); //$NON-NLS-1$
        
        OCL_TYPE = (EClassifier) OCLFactoryImpl.INSTANCE.createTypeType(OCL_T);
        OCL_SET = (EClassifier) OCLFactoryImpl.INSTANCE.createSetType(OCL_T);
        OCL_ORDERED_SET = (EClassifier) OCLFactoryImpl.INSTANCE.createOrderedSetType(OCL_T);
        OCL_BAG = (EClassifier) OCLFactoryImpl.INSTANCE.createBagType(OCL_T);
        OCL_SEQUENCE = (EClassifier) OCLFactoryImpl.INSTANCE.createSequenceType(OCL_T);
        OCL_COLLECTION = (EClassifier) OCLFactoryImpl.INSTANCE.createCollectionType(OCL_T);
        
        STATE = EcoreFactory.eINSTANCE.createElementType();
        STATE.setName("State"); //$NON-NLS-1$
        OCL_EXPRESSION = EcoreFactory.eINSTANCE.createElementType();
		OCL_EXPRESSION.setName("OclExpression"); //$NON-NLS-1$
		
		OCL_BOOLEAN.setInstanceClass(Boolean.class);
		OCL_STRING.setInstanceClass(String.class);
		OCL_INTEGER.setInstanceClass(Integer.class);
		OCL_REAL.setInstanceClass(Double.class);
		
		register(OCL_ANY).getEOperations().addAll(
            OCLStandardLibraryUtil.createAnyTypeOperations(env));
		register(OCL_VOID).getEOperations().addAll(
            OCLStandardLibraryUtil.createAnyTypeOperations(env));
		register(INVALID).getEOperations().addAll(
            OCLStandardLibraryUtil.createAnyTypeOperations(env));
		register(OCL_BOOLEAN).getEOperations().addAll(
            OCLStandardLibraryUtil.createBooleanOperations(env));
		register(OCL_INTEGER).getEOperations().addAll(
            OCLStandardLibraryUtil.createIntegerOperations(env));
        register(OCL_UNLIMITED_NATURAL).getEOperations().addAll(
            OCLStandardLibraryUtil.createUnlimitedNaturalOperations(env));
		register(OCL_REAL).getEOperations().addAll(
            OCLStandardLibraryUtil.createRealOperations(env));
		register(OCL_STRING).getEOperations().addAll(
            OCLStandardLibraryUtil.createStringOperations(env));
		register(OCL_TYPE).getEOperations().addAll(
            OCLStandardLibraryUtil.createTypeTypeOperations(env));
		register(OCL_MESSAGE).getEOperations().addAll(
            OCLStandardLibraryUtil.createMessageTypeOperations(env));
		register(OCL_ELEMENT);
		register(STATE);
        register(OCL_EXPRESSION);
		
        List<EOperation> operations;
        List<EOperation> iterators;
        
		operations = register(OCL_COLLECTION).getEOperations();
        operations.addAll(OCLStandardLibraryUtil.createCollectionOperations(env));
        iterators = OCLStandardLibraryUtil.createCollectionIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_SET).getEOperations();
        operations.addAll(OCLStandardLibraryUtil.createSetOperations(env));
        iterators = OCLStandardLibraryUtil.createSetIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_ORDERED_SET).getEOperations();
        operations.addAll(OCLStandardLibraryUtil.createOrderedSetOperations(env));
        iterators = OCLStandardLibraryUtil.createOrderedSetIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_BAG).getEOperations();
        operations.addAll(OCLStandardLibraryUtil.createBagOperations(env));
        iterators = OCLStandardLibraryUtil.createBagIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_SEQUENCE).getEOperations();
        operations.addAll(OCLStandardLibraryUtil.createSequenceOperations(env));
        iterators = OCLStandardLibraryUtil.createSequenceIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
		
		register(OCL_T);  // operations already defined by OclAny
		register(OCL_T2);  // operations already defined by OclAny
		
		EPackage.Registry.INSTANCE.put(stdlibPackage.getNsURI(), stdlibPackage);
		
        Environment.Registry.INSTANCE.registerEnvironment(old);
        
		return stdlibPackage;
	}
	
	private static EClass register(EClassifier stdType) {
        EClass result = (stdType instanceof EClass)? (EClass) stdType : null;
        
		// add the type to the standard library package
		stdlibPackage.getEClassifiers().add(stdType);
		
		if ((stdType instanceof PredefinedType) && !(stdType instanceof EClass)) {
			// an EClass would store its own operations; this cannot.
			//    Create a shadow class to store the operations
			result = createShadowClass(stdType);
            
			stdlibPackage.getEClassifiers().add(result);
		}
        
        return result;
	}
	
	public static EClassifier getOwner(EOperation operation) {
		EClass ownerClass = operation.getEContainingClass();
		EClassifier result = ownerClass;
		
		if (ownerClass != null) {
			EClassifier shadowed = getRealClassifier(ownerClass);
			
			if (shadowed != null) {
				result = shadowed;
			}
		}
		
		return result;
	}
    
    public static EClassifier getOwner(EStructuralFeature property) {
        EClass ownerClass = property.getEContainingClass();
        EClassifier result = ownerClass;
        
        if (ownerClass != null) {
            EClassifier shadowed = getRealClassifier(ownerClass);
            
            if (shadowed != null) {
                result = shadowed;
            }
        }
        
        return result;
    }
	
	/**
	 * Creates the shadow class to contain features that an Ecore classifier
	 * cannot contain for itself.
	 * 
	 * @param classifier an Ecore classifier
	 * 
	 * @return the class containing its features
	 */
	public static EClass createShadowClass(EClassifier classifier) {
		// the features may have invalid characters in their names
		EClass result = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
		result.setName(classifier.getName() + "_Class"); //$NON-NLS-1$
		
		EAnnotation ann = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAnnotation();
		ann.setSource(Environment.OCL_NAMESPACE_URI);
		ann.getReferences().add(classifier);
		result.getEAnnotations().add(ann);
		
		return result;
	}
	
	/**
	 * Finds the shadow class to contain features defined for the
	 * specified OCL <code>type</code>, if it already exists.
	 * 
	 * @param classifier an Ecore classifier
	 * @param pkg the package in which to look for the shadow class
	 * 
	 * @return the class containing its features, or <code>null</code> if not
	 *    found
	 */
	public static EClass findShadowClass(EClassifier classifier, EPackage pkg) {
		for (EClassifier next : pkg.getEClassifiers()) {
            if (next instanceof EClass) {
    			EClass eclass = (EClass) next;
    			
    			EAnnotation ann = eclass.getEAnnotation(
                    Environment.OCL_NAMESPACE_URI);
    			if ((ann != null) && ann.getReferences().contains(classifier)) {
    				return eclass;
    			}
            }
		}
		
		return null;
	}
	
	public static EClassifier getRealClassifier(EClass shadowClass) {
		EClassifier result = null;
		
		EAnnotation ann = shadowClass.getEAnnotation(
            Environment.OCL_NAMESPACE_URI);
		if ((ann != null) && !ann.getReferences().isEmpty()) {
			result = (EClassifier) ann.getReferences().get(0);
		}
		
		return result;
	}
    
    /**
     * Obtains the existing operations of the specified type, stored in it
     * or in a shadow class.  <b>Note</b> that this method returns
     * <code>null</code>, not an empty list, if none are found.
     * 
     * @param type an OCL pre-defined type
     * @return its existing operations, or <code>null</code> if none are found
     */
    public static EList<EOperation> getExistingOperations(EClassifier type) {
        EList<EOperation> result = null;
        
        if (type instanceof EClass) {
            result = ((EClass) type).getEOperations();
        } else {
            EPackage pkg = type.getEPackage();
            if (pkg != null) {
                EClass shadow = findShadowClass(type, pkg);
                if (shadow != null) {
                    result = shadow.getEOperations();
                }
            }
        }
        
        return (result == null)? ECollections.<EOperation>emptyEList() : result;
    }
    
    /**
     * Marks the specified operations as being collection iterators (as distinct
     * from ordinary operations).
     * 
     * @param operations operations to designate as iterators
     */
    public static void stereotypeAsIterator(Collection<EOperation> operations) {
        for (EOperation oper : operations) {
            EAnnotation ann = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAnnotation();
            ann.setSource(Environment.OCL_NAMESPACE_URI);
            ann.getDetails().put("keywords", "iterator"); //$NON-NLS-1$ //$NON-NLS-2$
            oper.getEAnnotations().add(ann);
        }
    }
    
    /**
     * Selects from the specified operations those that are collection iterators.
     * 
     * @param operations operations
     * @return the subset that are stereotyped as iterators
     */
    public static EList<EOperation> selectIterators(Collection<EOperation> operations) {
        EList<EOperation> result = new BasicEList.FastCompare<EOperation>();
        
        for (EOperation oper : operations) {
            EAnnotation ann = oper.getEAnnotation(Environment.OCL_NAMESPACE_URI);
            if ((ann != null) && "iterator".equals(ann.getDetails().get( //$NON-NLS-1$
                    "keywords"))) { //$NON-NLS-1$
                result.add(oper);
            }
        }
        
        return result;
    }
}