/**
 * <copyright>
 *
 * Copyright (c) 2006, 2010 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 252600, 248869
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Bug 297666
 *
 * </copyright>
 *
 * $Id: OCLStandardLibraryImpl.java,v 1.11 2010/02/09 10:32:31 asanchez Exp $
 */

package org.eclipse.ocl.uml.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.ElementType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Implementation of the {@link OCLStandardLibrary} for the UML environment.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class OCLStandardLibraryImpl implements OCLStandardLibrary<Classifier> {
    private static final String NS_URI = UMLEnvironment.OCL_STANDARD_LIBRARY_NS_URI;
    
	private static final String ITERATOR_KEYWORD = "iterator"; //$NON-NLS-1$
	
	private static Classifier OCL_ANY;
	private static Classifier OCL_ELEMENT;
	private static Classifier OCL_BOOLEAN;
    private static Classifier OCL_INTEGER;
    private static Classifier OCL_UNLIMITED_NATURAL;
	private static Classifier OCL_REAL;
	private static Classifier OCL_STRING;
	private static Classifier OCL_VOID;
	private static Classifier OCL_MESSAGE;
	private static Classifier OCL_TYPE;

    private static Classifier OCL_INVALID;
	
	private static Classifier OCL_T;
	private static Classifier OCL_T2;
	
	private static Classifier OCL_SET;
	private static Classifier OCL_ORDERED_SET;
	private static Classifier OCL_BAG;
	private static Classifier OCL_SEQUENCE;
	private static Classifier OCL_COLLECTION;
	
	private static Classifier STATE;
	private static Classifier OCL_EXPRESSION;
    
    /** The shared instance of the OCL Standard Library for the UML environment. */
    public static final OCLStandardLibraryImpl INSTANCE = new OCLStandardLibraryImpl();
    
    /** The singleton instance of the <tt>OclInvalid</tt> standard library type. */
    public static Object INVALID =
        org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInstanceSpecification();

    /** The package containing the OCL Standard Library classifiers. */
	public static Package stdlibPackage = init();
	
    // not instantiable by clients
	private OCLStandardLibraryImpl() {
		super();
	}
	
	public Classifier getBoolean() {
		return OCL_BOOLEAN;
	}

	public Classifier getInteger() {
		return OCL_INTEGER;
	}

    public Classifier getUnlimitedNatural() {
        return OCL_UNLIMITED_NATURAL;
    }
    
	public Classifier getOclInvalid() {
		return OCL_INVALID;
	}

	public Classifier getReal() {
		return OCL_REAL;
	}

	public Classifier getString() {
		return OCL_STRING;
	}

	public Classifier getOclAny() {
		return OCL_ANY;
	}

	public Classifier getOclElement() {
		return OCL_ELEMENT;
	}

	public Object getInvalid() {
		return INVALID;
	}

	public Classifier getState() {
		return STATE;
	}

	public Classifier getOclMessage() {
		return OCL_MESSAGE;
	}
	
	public Classifier getOclType() {
		return OCL_TYPE;
	}

	public Classifier getOclVoid() {
		return OCL_VOID;
	}
	
	public Classifier getT() {
		return OCL_T;
	}
	
	public Classifier getT2() {
		return OCL_T2;
	}
	
	public Classifier getSet() {
		return OCL_SET;
	}
	
	public Classifier getOrderedSet() {
		return OCL_ORDERED_SET;
	}
	
	public Classifier getBag() {
		return OCL_BAG;
	}
	
	public Classifier getSequence() {
		return OCL_SEQUENCE;
	}
	
	public Classifier getCollection() {
		return OCL_COLLECTION;
	}
	
	public Classifier getOclExpression() {
		return OCL_EXPRESSION;
	}
	
    private static Package init() {
        if (stdlibPackage != null) {
            return stdlibPackage;
        }
        
        ResourceSet rset = new ResourceSetImpl();
        // Ensure that a UMLResource factory is registered for the uml extension.
        // Note that when running standalone, a registration in the global registry is not certain.
        OCL.initialize(null);
        Resource res = null;
        
        try {
            res = rset.getResource(URI.createURI(NS_URI), true);
            stdlibPackage = (Package) res.getContents().get(0);
            
            OCL_ANY = (Classifier) stdlibPackage.getOwnedType(AnyType.SINGLETON_NAME);
            OCL_ELEMENT = (Classifier) stdlibPackage.getOwnedType(ElementType.SINGLETON_NAME);
            OCL_BOOLEAN = (Classifier) stdlibPackage.getOwnedType(PrimitiveType.BOOLEAN_NAME);
            OCL_INTEGER = (Classifier) stdlibPackage.getOwnedType(PrimitiveType.INTEGER_NAME);
            OCL_UNLIMITED_NATURAL = (Classifier) stdlibPackage.getOwnedType(PrimitiveType.UNLIMITED_NATURAL_NAME);
            OCL_REAL = (Classifier) stdlibPackage.getOwnedType(PrimitiveType.REAL_NAME);
            OCL_STRING = (Classifier) stdlibPackage.getOwnedType(PrimitiveType.STRING_NAME);
            OCL_VOID = (Classifier) stdlibPackage.getOwnedType(VoidType.SINGLETON_NAME);
            OCL_MESSAGE = (Classifier) stdlibPackage.getOwnedType(MessageType.SINGLETON_NAME);

            OCL_INVALID = (Classifier) stdlibPackage.getOwnedType(InvalidType.SINGLETON_NAME);
            
            OCL_T = (Classifier) stdlibPackage.getOwnedType("T"); //$NON-NLS-1$
            OCL_T2 = (Classifier) stdlibPackage.getOwnedType("T2"); //$NON-NLS-1$
            
            OCL_TYPE = (Classifier) EcoreUtil.getObjectByType(
                    stdlibPackage.getOwnedTypes(),
                    UMLPackage.Literals.TYPE_TYPE);
            
            OCL_SET = (Classifier) EcoreUtil.getObjectByType(
                stdlibPackage.getOwnedTypes(),
                UMLPackage.Literals.SET_TYPE);
            OCL_ORDERED_SET = (Classifier) EcoreUtil.getObjectByType(
                stdlibPackage.getOwnedTypes(),
                UMLPackage.Literals.ORDERED_SET_TYPE);
            OCL_BAG = (Classifier) EcoreUtil.getObjectByType(
                stdlibPackage.getOwnedTypes(),
                UMLPackage.Literals.BAG_TYPE);
            OCL_SEQUENCE = (Classifier) EcoreUtil.getObjectByType(
                stdlibPackage.getOwnedTypes(),
                UMLPackage.Literals.SEQUENCE_TYPE);
            
            // don't use EcoreUtil because the other collection types would match
            OCL_COLLECTION = (Classifier) stdlibPackage.getOwnedType("Collection(T)"); //$NON-NLS-1$
            
            STATE = (Classifier) stdlibPackage.getOwnedType("State"); //$NON-NLS-1$
            OCL_EXPRESSION = (Classifier) stdlibPackage.getOwnedType("OclExpression"); //$NON-NLS-1$
            
            ((InstanceSpecification) INVALID).getClassifiers().add(OCL_INVALID);
            ((InstanceSpecification) INVALID).setName("invalid"); //$NON-NLS-1$
            
            addToPackageRegistry(stdlibPackage);
           
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
	private static Package build() {
		if (stdlibPackage != null) {
			return stdlibPackage;
		}
		
		stdlibPackage = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPackage();
		stdlibPackage.setName("oclstdlib"); //$NON-NLS-1$
		
		Resource res = UMLResource.Factory.INSTANCE.createResource(
				URI.createURI("http://www.eclipse.org/ocl/1.1.0/oclstdlib.uml")); //$NON-NLS-1$
		res.getContents().add(stdlibPackage);
		
        Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> old = Environment.Registry.INSTANCE.getEnvironmentFor(
            EcorePackage.Literals.ECLASS);
        
        Environment.Registry.INSTANCE.deregisterEnvironment(old);
        UMLEnvironment env =
            (UMLEnvironment) new UMLEnvironmentFactory().loadEnvironment(res);
        Environment.Registry.INSTANCE.registerEnvironment(env);
        
        OCL_ANY = UMLFactory.eINSTANCE.createAnyType();
        OCL_ELEMENT = UMLFactory.eINSTANCE.createElementType();
        OCL_BOOLEAN = UMLFactory.eINSTANCE.createPrimitiveType();
        OCL_BOOLEAN.setName(PrimitiveType.BOOLEAN_NAME);
        OCL_INTEGER = UMLFactory.eINSTANCE.createPrimitiveType();
        OCL_INTEGER.setName(PrimitiveType.INTEGER_NAME);
        OCL_UNLIMITED_NATURAL = UMLFactory.eINSTANCE.createPrimitiveType();
        OCL_UNLIMITED_NATURAL.setName(PrimitiveType.UNLIMITED_NATURAL_NAME);
        OCL_REAL = UMLFactory.eINSTANCE.createPrimitiveType();
        OCL_REAL.setName(PrimitiveType.REAL_NAME);
        OCL_STRING = UMLFactory.eINSTANCE.createPrimitiveType();
        OCL_STRING.setName(PrimitiveType.STRING_NAME);
        OCL_VOID = UMLFactory.eINSTANCE.createVoidType();
        OCL_MESSAGE = UMLFactory.eINSTANCE.createMessageType();

        OCL_INVALID = UMLFactory.eINSTANCE.createInvalidType();
        
        OCL_T = UMLFactory.eINSTANCE.createAnyType();
        OCL_T.setName("T"); //$NON-NLS-1$
        OCL_T2 = UMLFactory.eINSTANCE.createAnyType();
        OCL_T2.setName("T2"); //$NON-NLS-1$
        
        OCL_TYPE = (Classifier) OCLFactoryImpl.INSTANCE.createTypeType(OCL_T);
        OCL_SET = (Classifier) OCLFactoryImpl.INSTANCE.createSetType(OCL_T);
        OCL_ORDERED_SET = (Classifier) OCLFactoryImpl.INSTANCE.createOrderedSetType(OCL_T);
        OCL_BAG = (Classifier) OCLFactoryImpl.INSTANCE.createBagType(OCL_T);
        OCL_SEQUENCE = (Classifier) OCLFactoryImpl.INSTANCE.createSequenceType(OCL_T);
        OCL_COLLECTION = (Classifier) OCLFactoryImpl.INSTANCE.createCollectionType(OCL_T);
        
        STATE = UMLFactory.eINSTANCE.createElementType();
        STATE.setName("State"); //$NON-NLS-1$
        OCL_EXPRESSION = UMLFactory.eINSTANCE.createElementType();
        OCL_EXPRESSION.setName("OclExpression"); //$NON-NLS-1$
        
		((InstanceSpecification) INVALID).getClassifiers().add(OCL_INVALID);
		((InstanceSpecification) INVALID).setName("invalid"); //$NON-NLS-1$
		
        register(OCL_ANY).addAll(
            OCLStandardLibraryUtil.createAnyTypeOperations(env));
        register(OCL_VOID).addAll(
            OCLStandardLibraryUtil.createAnyTypeOperations(env));
        register(OCL_INVALID).addAll(
            OCLStandardLibraryUtil.createAnyTypeOperations(env));
        register(OCL_BOOLEAN).addAll(
            OCLStandardLibraryUtil.createBooleanOperations(env));
        register(OCL_INTEGER).addAll(
            OCLStandardLibraryUtil.createIntegerOperations(env));
        register(OCL_UNLIMITED_NATURAL).addAll(
            OCLStandardLibraryUtil.createUnlimitedNaturalOperations(env));
        register(OCL_REAL).addAll(
            OCLStandardLibraryUtil.createRealOperations(env));
        register(OCL_STRING).addAll(
            OCLStandardLibraryUtil.createStringOperations(env));
        register(OCL_TYPE).addAll(
            OCLStandardLibraryUtil.createTypeTypeOperations(env));
        register(OCL_MESSAGE).addAll(
            OCLStandardLibraryUtil.createMessageTypeOperations(env));
		register(OCL_ELEMENT);
		register(STATE);
		register(OCL_EXPRESSION);
        
        List<Operation> operations;
        List<Operation> iterators;
        
        operations = register(OCL_COLLECTION);
        operations.addAll(OCLStandardLibraryUtil.createCollectionOperations(env));
        iterators = OCLStandardLibraryUtil.createCollectionIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_SET);
        operations.addAll(OCLStandardLibraryUtil.createSetOperations(env));
        iterators = OCLStandardLibraryUtil.createSetIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_ORDERED_SET);
        operations.addAll(OCLStandardLibraryUtil.createOrderedSetOperations(env));
        iterators = OCLStandardLibraryUtil.createOrderedSetIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_BAG);
        operations.addAll(OCLStandardLibraryUtil.createBagOperations(env));
        iterators = OCLStandardLibraryUtil.createBagIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        operations = register(OCL_SEQUENCE);
        operations.addAll(OCLStandardLibraryUtil.createSequenceOperations(env));
        iterators = OCLStandardLibraryUtil.createSequenceIterators(env);
        stereotypeAsIterator(iterators);
        operations.addAll(iterators);
        
        register(OCL_T);  // operations already defined by OclAny
        register(OCL_T2);  // operations already defined by OclAny
        
        addToPackageRegistry(stdlibPackage);
        
        Environment.Registry.INSTANCE.registerEnvironment(old);
		
		return stdlibPackage;
	}
    
    private static void addToPackageRegistry(Package pkg) {
        // ensure that this package is registered in the EPackage registry so
        //   that looking up the OCL Standard Library resource's URI finds
        //   it there (common behaviour of all resource sets)
        EAnnotation ann = pkg.createEAnnotation(Environment.OCL_NAMESPACE_URI);
        Collection<EPackage> ecore = UMLUtil.convertToEcore(pkg, null);
        ann.getContents().addAll(ecore);
        
        if (!ecore.isEmpty()) {
            EPackage epackage = ecore.iterator().next();
            
            epackage.setNsURI(pkg.eResource().getURI().toString());
            EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
        }
    }
	
	private static List<Operation> register(Classifier stdType) {
        List<Operation> result = null;
        
        if (stdType instanceof DataType) {
            result = ((DataType) stdType).getOwnedOperations();
        } else if (stdType instanceof org.eclipse.ocl.uml.AnyType) {
            result = ((org.eclipse.ocl.uml.AnyType) stdType).getOwnedOperations();
        } else if (stdType instanceof org.eclipse.ocl.uml.InvalidType) {
            result = ((org.eclipse.ocl.uml.InvalidType) stdType).getOwnedOperations();
        } else if (stdType instanceof org.eclipse.ocl.uml.VoidType) {
            result = ((org.eclipse.ocl.uml.VoidType) stdType).getOwnedOperations();
        } else if (stdType instanceof org.eclipse.ocl.uml.MessageType) {
            result = ((org.eclipse.ocl.uml.MessageType) stdType).getOwnedOperations();
        } else if (stdType instanceof org.eclipse.ocl.uml.TypeType) {
            result = ((org.eclipse.ocl.uml.TypeType) stdType).getOwnedOperations();
        }
        
		// add the type to the standard library package
		stdlibPackage.getOwnedTypes().add(stdType);
        
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
    public static Class findShadowClass(Classifier classifier, Package pkg) {
        for (Type next : pkg.getOwnedTypes()) {
            if (next instanceof Class) {
                Class clazz = (Class) next;
                
                if (getRealClassifier(clazz) == classifier) {
                    return clazz;
                }
            }
        }
        
        return null;
    }
    
    public static Classifier getRealClassifier(Class shadow) {
        Substitution sub = shadow.getSubstitution("realOwner", null); //$NON-NLS-1$
        return (sub == null)? null : sub.getContract();
    }
    
    /**
     * Marks the specified operations as being collection iterators (as distinct
     * from ordinary operations).
     * 
     * @param operations operations to designate as iterators
     */
    public static void stereotypeAsIterator(Collection<Operation> operations) {
        for (Operation oper : operations) {
            oper.addKeyword("iterator"); //$NON-NLS-1$
        }
    }
    
    /**
     * Selects from the specified operations those that are collection iterators.
     * 
     * @param operations operations
     * @return the subset that are stereotyped as iterators
     */
    public static EList<Operation> selectIterators(Collection<Operation> operations) {
        EList<Operation> result = new BasicEList.FastCompare<Operation>();
        
        for (Operation oper : operations) {
            if (oper.hasKeyword(ITERATOR_KEYWORD)) {
                result.add(oper);
            }
        }
        
        return result;
    }
    
    public static Collection<Operation> createCollectionTypeOperations(
            Environment<?, Classifier, Operation, ?, ?, Parameter, ?, ?, ?, ?, ?, ?> env,
            CollectionKind kind) {
        
        Collection<Operation> operations;
        Collection<Operation> iterators;
        
        switch (kind) {
        case BAG_LITERAL:
            operations = OCLStandardLibraryUtil.createBagOperations(env);
            iterators = OCLStandardLibraryUtil.createBagIterators(env);
            break;
        case SET_LITERAL:
            operations = OCLStandardLibraryUtil.createSetOperations(env);
            iterators = OCLStandardLibraryUtil.createSetIterators(env);
            break;
        case ORDERED_SET_LITERAL:
            operations = OCLStandardLibraryUtil.createOrderedSetOperations(env);
            iterators = OCLStandardLibraryUtil.createOrderedSetIterators(env);
            break;
        case SEQUENCE_LITERAL:
            operations = OCLStandardLibraryUtil.createSequenceOperations(env);
            iterators = OCLStandardLibraryUtil.createSequenceIterators(env);
            break;
        default:
            operations = OCLStandardLibraryUtil.createCollectionOperations(env);
            iterators = OCLStandardLibraryUtil.createCollectionIterators(env);
            break;
        }

        for (Operation next : iterators) {
            next.addKeyword(ITERATOR_KEYWORD);
        }
        
        Collection<Operation> result = new java.util.ArrayList<Operation>(
                operations.size() + iterators.size());
        
        result.addAll(operations);
        result.addAll(iterators);
        
        return result;
    }
}