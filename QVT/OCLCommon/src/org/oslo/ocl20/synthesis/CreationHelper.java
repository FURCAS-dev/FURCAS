package org.oslo.ocl20.synthesis;

import java.util.Iterator;
import java.util.List;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;
import org.oslo.ocl20.semantics.bridge.Parameter;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ContextsFactory;
import org.oslo.ocl20.semantics.model.contexts.DefinedOperation;
import org.oslo.ocl20.semantics.model.contexts.DefinedProperty;
import org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl;
import org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.CollectionKind;
import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.ExpressionsFactory;
import org.oslo.ocl20.semantics.model.expressions.IfExp;
import org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.IterateExp;
import org.oslo.ocl20.semantics.model.expressions.IteratorExp;
import org.oslo.ocl20.semantics.model.expressions.LetExp;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.PropertyCallExp;
import org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;

public class CreationHelper {

	private static ExpressionsFactory expressionsFactory = ExpressionsFactory.eINSTANCE;

	private static ContextsFactory contextsFactory = ContextsFactory.eINSTANCE;

	private static BridgeFactory bridgeFactory = BridgeFactory.eINSTANCE;

	// TODO find a better way
	// TODOMWA !!!
	private CreationHelper() {
	}

	public static LetExp createLetExp(String name, Boolean isMarkedPre) {
		LetExp letExp = CreationHelper.expressionsFactory.createLetExp();
		letExp.setName(name);
		letExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return letExp;
	}

	public static PropertyCallExp createPropertyCallExp(String name, Boolean isMarkedPre) {
		PropertyCallExp propertyCallExp = CreationHelper.expressionsFactory.createPropertyCallExp();
		propertyCallExp.setName(name);
		propertyCallExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return propertyCallExp;
	}

	public static OperationCallExp createOperationCallExp(String name, Boolean isMarkedPre) {
		OperationCallExp operationCallExp = CreationHelper.expressionsFactory.createOperationCallExp();
		operationCallExp.setName(name);
		operationCallExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return operationCallExp;
	}

	public static IteratorExp createIteratorExp(String name, Boolean isMarkedPre) {
		IteratorExp iteratorExp = CreationHelper.expressionsFactory.createIteratorExp();
		iteratorExp.setName(name);
		iteratorExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return iteratorExp;
	}

	public static IntegerLiteralExp createIntegerLiteralExp() {
		return CreationHelper.expressionsFactory.createIntegerLiteralExp();
	}

	public static VariableExp createVariableExp() {
		return CreationHelper.expressionsFactory.createVariableExp();
	}

	public static VariableExp createVariableExp(String name, Boolean isMarkedPre) {
		VariableExp variableExp = CreationHelper.expressionsFactory.createVariableExp();
		variableExp.setName(name);
		variableExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return variableExp;
	}

	public static VariableDeclaration createVariableDeclaration(String name) {
		VariableDeclaration variableDeclaration = CreationHelper.expressionsFactory.createVariableDeclaration();
		variableDeclaration.setName(name);
		return variableDeclaration;
	}

	public static IfExp createIfExp() {
		IfExp ifExp = CreationHelper.expressionsFactory.createIfExp();
		return ifExp;
	}

	public static CollectionLiteralExp createCollectionLiteralExp() {
		CollectionLiteralExp collectionLiteralExp = CreationHelper.expressionsFactory.createCollectionLiteralExp();
		return collectionLiteralExp;
	}

	public static IterateExp createIterateExp(String name, Boolean isMarkedPre) {
		IterateExp iterateExp = CreationHelper.expressionsFactory.createIterateExp();
		iterateExp.setName(name);
		iterateExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return iterateExp;
	}

	public static CollectionLiteralExp createCollectionLiteralExp(String name, Boolean isMarkedPre, CollectionKind kind) {
		CollectionLiteralExp collectionLiteralExp = CreationHelper.expressionsFactory.createCollectionLiteralExp();
		collectionLiteralExp.setName(name);
		collectionLiteralExp.setIsMarkedPre(isMarkedPre.booleanValue());
		collectionLiteralExp.setKind(kind);
		return collectionLiteralExp;
	}

	public static BooleanLiteralExp createBooleanLiteralExp(String name, Boolean isMarkedPre, Boolean booleanSymbol) {
		BooleanLiteralExp booleanLiteralExp = CreationHelper.expressionsFactory.createBooleanLiteralExp();
		booleanLiteralExp.setName(name);
		booleanLiteralExp.setIsMarkedPre(isMarkedPre.booleanValue());
		booleanLiteralExp.setBooleanSymbol(booleanSymbol.booleanValue());
		return booleanLiteralExp;
	}

	public static OperationCallExp createOperationCallExp() {
		OperationCallExp operationCallExp = CreationHelper.expressionsFactory.createOperationCallExp();
		return operationCallExp;
	}

	public static TupleLiteralExp createTupleLiteralExp(String name, Boolean isMarkedPre) {
		TupleLiteralExp tupleLiteralExp = CreationHelper.expressionsFactory.createTupleLiteralExp();
		tupleLiteralExp.setName(name);
		tupleLiteralExp.setIsMarkedPre(isMarkedPre.booleanValue());
		return tupleLiteralExp;
	}

	public static TypeLiteralExp createTypeLiteralExp(String name, Boolean isMarkedPre, Classifier litType) {
		TypeLiteralExp typeLiteralExp = CreationHelper.expressionsFactory.createTypeLiteralExp();
		typeLiteralExp.setName(name);
		typeLiteralExp.setIsMarkedPre(isMarkedPre.booleanValue());
		typeLiteralExp.setLiteralType(litType);
		return typeLiteralExp;
	}

	public static DefinedProperty createDefinedProperty(String name, Classifier type, Constraint def) {
		DefinedProperty definedProperty = CreationHelper.contextsFactory.createDefinedProperty();
		definedProperty.setName(name);
		definedProperty.setType(type);
		definedProperty.setDefinition(def);
		return definedProperty;
	}

	public static PropertyContextDecl createPropertyContextDecl() {
		PropertyContextDecl propertyContextDecl = CreationHelper.contextsFactory.createPropertyContextDecl();
		return propertyContextDecl;
	}

	public static DefinedOperation createDefinedOperation(String name, Classifier retType, List pTypes, List pNames, Constraint def) {
		DefinedOperation definedOperation = CreationHelper.contextsFactory.createDefinedOperation();
		definedOperation.setName(name);
		definedOperation.setReturnType(retType);
		// definedOperation.getParameterTypes().addAll(pTypes);
		// definedOperation.getParameterNames().addAll(pNames);

		for (Iterator nameIter = pNames.iterator(), typeIter = pTypes.iterator(); nameIter.hasNext() && typeIter.hasNext();) {
			String currentParameterName = (String) nameIter.next();
			Classifier currentParameterType = (Classifier) typeIter.next();
			Parameter parameter = CreationHelper.bridgeFactory.createParameter();
			parameter.setName(currentParameterName);
			parameter.setType(currentParameterType);
			definedOperation.getOwnedParameter().add(parameter);
		}
		definedOperation.setDefinition(def);
		return definedOperation;
	}

	public static VariableDeclaration createVariableDeclaration() {
		VariableDeclaration variableDeclaration = CreationHelper.expressionsFactory.createVariableDeclaration();
		return variableDeclaration;
	}

	public static Classifier createClassifier(OclProcessor processor) {
		Classifier classifier = CreationHelper.bridgeFactory.createClassifier();
		classifier.setProcessor(processor);
		return classifier;
	}

	public static NamedElement createNamedElement(String name, ModelElement referredElement, Boolean mayBeImplicit) {
		NamedElement namedElement = CreationHelper.bridgeFactory.createNamedElement();
		namedElement.setName(name);
		namedElement.setMayBeImplicit(mayBeImplicit);
		namedElement.setReferredElement(referredElement);
		return namedElement;
	}

	public static Environment createEnvironment(org.oslo.ocl20.semantics.factories.BridgeFactory aBridgeFactory) {
		Environment environment = CreationHelper.bridgeFactory.createEnvironment();
		environment.setBridgeFactory(aBridgeFactory);
		return environment;
	}
}
