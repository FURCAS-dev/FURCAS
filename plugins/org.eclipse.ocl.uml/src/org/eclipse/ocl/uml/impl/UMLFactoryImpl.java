/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLFactoryImpl.java,v 1.1 2007/01/25 18:39:26 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.uml.AnyType;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.ElementType;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.InvalidType;
import org.eclipse.ocl.uml.MessageType;
import org.eclipse.ocl.uml.OrderedSetType;
import org.eclipse.ocl.uml.PrimitiveType;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.TypeType;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.VoidType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLFactoryImpl extends EFactoryImpl implements UMLFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static UMLFactory init() {
        try {
            UMLFactory theUMLFactory = (UMLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/1.1.0/UML"); //$NON-NLS-1$ 
            if (theUMLFactory != null) {
                return theUMLFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new UMLFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case UMLPackage.ANY_TYPE: return createAnyType();
            case UMLPackage.VOID_TYPE: return createVoidType();
            case UMLPackage.INVALID_TYPE: return createInvalidType();
            case UMLPackage.ELEMENT_TYPE: return createElementType();
            case UMLPackage.TYPE_TYPE: return createTypeType();
            case UMLPackage.MESSAGE_TYPE: return createMessageType();
            case UMLPackage.PRIMITIVE_TYPE: return createPrimitiveType();
            case UMLPackage.COLLECTION_TYPE: return createCollectionType();
            case UMLPackage.TUPLE_TYPE: return createTupleType();
            case UMLPackage.BAG_TYPE: return createBagType();
            case UMLPackage.SET_TYPE: return createSetType();
            case UMLPackage.ORDERED_SET_TYPE: return createOrderedSetType();
            case UMLPackage.SEQUENCE_TYPE: return createSequenceType();
            case UMLPackage.EXPRESSION_IN_OCL: return createExpressionInOCL();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AnyType createAnyType() {
        AnyTypeImpl anyType = new AnyTypeImpl();
        return anyType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VoidType createVoidType() {
        VoidTypeImpl voidType = new VoidTypeImpl();
        return voidType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InvalidType createInvalidType() {
        InvalidTypeImpl invalidType = new InvalidTypeImpl();
        return invalidType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElementType createElementType() {
        ElementTypeImpl elementType = new ElementTypeImpl();
        return elementType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeType createTypeType() {
        TypeTypeImpl typeType = new TypeTypeImpl();
        return typeType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MessageType createMessageType() {
        MessageTypeImpl messageType = new MessageTypeImpl();
        return messageType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType createPrimitiveType() {
        PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CollectionType createCollectionType() {
        CollectionTypeImpl collectionType = new CollectionTypeImpl();
        return collectionType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TupleType createTupleType() {
        TupleTypeImpl tupleType = new TupleTypeImpl();
        return tupleType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BagType createBagType() {
        BagTypeImpl bagType = new BagTypeImpl();
        return bagType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetType createSetType() {
        SetTypeImpl setType = new SetTypeImpl();
        return setType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrderedSetType createOrderedSetType() {
        OrderedSetTypeImpl orderedSetType = new OrderedSetTypeImpl();
        return orderedSetType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceType createSequenceType() {
        SequenceTypeImpl sequenceType = new SequenceTypeImpl();
        return sequenceType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExpressionInOCL createExpressionInOCL() {
        ExpressionInOCLImpl expressionInOCL = new ExpressionInOCLImpl();
        return expressionInOCL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLPackage getUMLPackage() {
        return (UMLPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static UMLPackage getPackage() {
        return UMLPackage.eINSTANCE;
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.BagType<C, O> createBagType(C elementType) {
        return (org.eclipse.ocl.types.BagType<C, O>)
            new BagTypeImpl((Classifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.OrderedSetType<C, O> createOrderedSetType(C elementType) {
        return (org.eclipse.ocl.types.OrderedSetType<C, O>)
        new OrderedSetTypeImpl((Classifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.SequenceType<C, O> createSequenceType(C elementType) {
        return (org.eclipse.ocl.types.SequenceType<C, O>)
        new SequenceTypeImpl((Classifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.SetType<C, O> createSetType(C elementType) {
        return (org.eclipse.ocl.types.SetType<C, O>)
        new SetTypeImpl((Classifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.CollectionType<C, O> createCollectionType(C elementType) {
        return (org.eclipse.ocl.types.CollectionType<C, O>)
        new CollectionTypeImpl((Classifier) elementType);
    }

    public <C, O> org.eclipse.ocl.types.CollectionType<C, O> createCollectionType(
            CollectionKind kind, C elementType) {
        switch (kind) {
        case BAG_LITERAL:
            return createBagType(elementType);
        case SET_LITERAL:
            return createSetType(elementType);
        case SEQUENCE_LITERAL:
            return createSequenceType(elementType);
        case ORDERED_SET_LITERAL:
            return createOrderedSetType(elementType);
        default:
            return createCollectionType(elementType);
        }
    }

    @SuppressWarnings("unchecked")
    public <C, O, P> org.eclipse.ocl.types.MessageType<C, O, P> createOperationMessageType(O operation) {
        MessageType result = createMessageType();
        result.setReferredOperation((Operation) operation);
        result.oclProperties(); // ensure that the structural features are created
        return (org.eclipse.ocl.types.MessageType<C, O, P>) result;
    }

    @SuppressWarnings("unchecked")
    public <C, O, P> org.eclipse.ocl.types.MessageType<C, O, P> createSignalMessageType(C signal) {
        MessageType result = createMessageType();
        result.setReferredSignal((Classifier) signal);
        result.oclProperties(); // ensure that the structural features are created
        return (org.eclipse.ocl.types.MessageType<C, O, P>) result;
    }

    @SuppressWarnings("unchecked")
    public <C, O, P> org.eclipse.ocl.types.TupleType<O, P> createTupleType(
            List<? extends TypedElement<C>> parts) {
        TupleType result = createTupleType();
        
        if (!parts.isEmpty()) {
            Environment<?, C, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env =
                Environment.Registry.INSTANCE.getEnvironmentFor(parts.get(0));
            UMLReflection<?, C, O, P, ?, ?, ?, ?, ?, ?> reflection = env.getUMLReflection();
            
            EList<Property> properties = result.oclProperties();
            
            for (TypedElement<C> part : parts) {
                properties.add((Property) reflection.createProperty(
                        part.getName(), part.getType()));
            }
        }
        
        return (org.eclipse.ocl.types.TupleType<O, P>) result;
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.TypeType<C, O> createTypeType(C type) {
        return (org.eclipse.ocl.types.TypeType<C, O>)
            new TypeTypeImpl((Classifier) type);
    }

} //UMLFactoryImpl
