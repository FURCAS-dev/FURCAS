/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: OCLFactoryImpl.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;

/**
 * Implementation of the {@link OCLFactory} API for the Ecore binding.
 *
 * @author Christian W. Damus (cdamus)
 */
public class OCLFactoryImpl implements OCLFactory {
    public static OCLFactory INSTANCE = new OCLFactoryImpl();
    
    private OCLFactoryImpl() {
        super();
    }

    public BagType createBagType(Type elementType) {
        BagType result = PivotFactory.eINSTANCE.createBagType();
        result.setElementType(elementType);       
        return result;
    }

    public OrderedSetType createOrderedSetType(Type elementType) {
        OrderedSetType result = PivotFactory.eINSTANCE.createOrderedSetType();
        result.setElementType(elementType);      
        return result;
    }

    public SequenceType createSequenceType(Type elementType) {
        SequenceType result = PivotFactory.eINSTANCE.createSequenceType();
        result.setElementType(elementType);
        return result;
    }

    public SetType createSetType(Type elementType) {
        SetType result = PivotFactory.eINSTANCE.createSetType();
        result.setElementType(elementType);
        return result;
    }

    public CollectionType createCollectionType(Type elementType) {
        CollectionType result = PivotFactory.eINSTANCE.createCollectionType();
        result.setElementType(elementType);        
        return result;
    }

    public CollectionType createCollectionType(CollectionKind kind, Type elementType) {
        switch (kind) {
        case BAG:
            return createBagType(elementType);
        case SET:
            return createSetType(elementType);
        case SEQUENCE:
            return createSequenceType(elementType);
        case ORDERED_SET:
            return createOrderedSetType(elementType);
        default:
            return createCollectionType(elementType);
        }
    }

    public MessageType createOperationMessageType(Operation operation) {
        MessageType result = PivotFactory.eINSTANCE.createMessageType();
        result.setReferredOperation(operation);
//        result.oclProperties(); // ensure that the structural features are created
        return result;
    }

    public MessageType createSignalMessageType(Signal signal) {
        MessageType result = PivotFactory.eINSTANCE.createMessageType();
        result.setReferredSignal(signal);
//        result.oclProperties(); // ensure that the structural features are created
        return result;
    }

    public TupleType createTupleType(List<? extends TypedElement> parts) {
        TupleType result = PivotFactory.eINSTANCE.createTupleType();
        if (!parts.isEmpty()) {
            Environment env =
                Environment.Registry.INSTANCE.getEnvironmentFor(parts.get(0));
            UMLReflection uml = env.getUMLReflection();
            List<Property> properties = result.getOwnedAttributes();
            for (TypedElement part : parts) {
                properties.add(uml.createProperty(part.getName(), part.getType()));
            }
        }      
        return result;
    }

    public AssociationClassCallExp createAssociationClassCallExp() {
        return PivotFactory.eINSTANCE.createAssociationClassCallExp();
    }

    public BooleanLiteralExp createBooleanLiteralExp() {
        return PivotFactory.eINSTANCE.createBooleanLiteralExp();
    }

    public CollectionItem createCollectionItem() {
        return PivotFactory.eINSTANCE.createCollectionItem();
    }

    public CollectionLiteralExp createCollectionLiteralExp() {
        return PivotFactory.eINSTANCE.createCollectionLiteralExp();
    }

    public CollectionRange createCollectionRange() {
        return PivotFactory.eINSTANCE.createCollectionRange();
    }

    public EnumLiteralExp createEnumLiteralExp() {
        return PivotFactory.eINSTANCE.createEnumLiteralExp();
    }

    public IfExp createIfExp() {
        return PivotFactory.eINSTANCE.createIfExp();
    }

    public IntegerLiteralExp createIntegerLiteralExp() {
        return PivotFactory.eINSTANCE.createIntegerLiteralExp();
    }

    public InvalidLiteralExp createInvalidLiteralExp() {
        return PivotFactory.eINSTANCE.createInvalidLiteralExp();
    }

    public LetExp createLetExp() {
        return PivotFactory.eINSTANCE.createLetExp();
    }

    public MessageExp createMessageExp() {
        return PivotFactory.eINSTANCE.createMessageExp();
    }

    public NullLiteralExp createNullLiteralExp() {
        return PivotFactory.eINSTANCE.createNullLiteralExp();
    }

    public OperationCallExp createOperationCallExp() {
        return PivotFactory.eINSTANCE.createOperationCallExp();
    }

    public PropertyCallExp createPropertyCallExp() {
        return PivotFactory.eINSTANCE.createPropertyCallExp();
    }

    public RealLiteralExp createRealLiteralExp() {
        return PivotFactory.eINSTANCE.createRealLiteralExp();
    }

    public StateExp createStateExp() {
        return PivotFactory.eINSTANCE.createStateExp();
    }

    public StringLiteralExp createStringLiteralExp() {
        return (StringLiteralExp)
            PivotFactory.eINSTANCE.createStringLiteralExp();
    }

    public TupleLiteralExp createTupleLiteralExp() {
        return PivotFactory.eINSTANCE.createTupleLiteralExp();
    }

    public TupleLiteralPart createTupleLiteralPart() {
        return PivotFactory.eINSTANCE.createTupleLiteralPart();
    }

    public TypeExp createTypeExp() {
        return PivotFactory.eINSTANCE.createTypeExp();
    }

    public UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp() {
        return PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
    }

    public UnspecifiedValueExp createUnspecifiedValueExp() {
        return PivotFactory.eINSTANCE.createUnspecifiedValueExp();
    }

    public Variable createVariable() {
        return PivotFactory.eINSTANCE.createVariable();
    }

    public VariableExp createVariableExp() {
        return PivotFactory.eINSTANCE.createVariableExp();
    }
}
