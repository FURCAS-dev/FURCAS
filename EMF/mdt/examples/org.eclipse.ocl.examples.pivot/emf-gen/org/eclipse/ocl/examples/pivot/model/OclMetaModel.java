/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.pivot/model/pivot.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateOclMetaModel.java
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateOclMetaModel.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.OclMetaModelCodeGenerator.java
 * from: org.eclipse.ocl.examples.build.GenerateOclMetaModel.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.pivot.model;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.ocl.examples.pivot.*;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * This is the http://www.eclipse.org/ocl/3.1.0/Pivot Pivot Model of the Pivot Model
 * auto-generated from /org.eclipse.ocl.examples.pivot/model/pivot.ecore.
 * It facilitates efficient model loading without the overheads of model reading.
 */
@SuppressWarnings("nls")
public class OclMetaModel extends XMLResourceImpl
{
	/**
	 *	The URI of this Standard Library.
	 */
	public static final String PIVOT_URI = "http://www.eclipse.org/ocl/3.1.0/Pivot";

	public OclMetaModel(StandardLibrary standardLibrary) {
		super(URI.createURI(PIVOT_URI));
		getContents().add(create(standardLibrary));
	}
	
	/**
	 *	Create and return a pivot model of the Pivot Model.
	 */
	public static Package create(StandardLibrary standardLibrary)
	{
		Package symbol_1 = PivotFactory.eINSTANCE.createPackage(); // pivot
		Class symbol_2 = PivotFactory.eINSTANCE.createClass(); // pivot!Annotation
		Property symbol_3 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::NamedElement pivot!Annotation!NamedElement
		Property symbol_4 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::ownedContent pivot!Annotation!ownedContent
		Property symbol_5 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::ownedDetail pivot!Annotation!ownedDetail
		Property symbol_6 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::reference pivot!Annotation!reference
		
		Class symbol_7 = PivotFactory.eINSTANCE.createClass(); // pivot!AnyType
		
		Class symbol_8 = PivotFactory.eINSTANCE.createClass(); // pivot!AssociationClass
		Property symbol_9 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClass::AssociationClassCallExp pivot!AssociationClass!AssociationClassCallExp
		Property symbol_10 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClass::unownedAttribute pivot!AssociationClass!unownedAttribute
		
		Class symbol_11 = PivotFactory.eINSTANCE.createClass(); // pivot!AssociationClassCallExp
		Property symbol_12 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClassCallExp::referredAssociationClass pivot!AssociationClassCallExp!referredAssociationClass
		
		Enumeration symbol_13 = PivotFactory.eINSTANCE.createEnumeration(); // pivot!AssociativityKind
		
		Class symbol_14 = PivotFactory.eINSTANCE.createClass(); // pivot!BagType
		
		PrimitiveType symbol_15 = standardLibrary.getBooleanType(); // pivot!Boolean
		Class symbol_16 = PivotFactory.eINSTANCE.createClass(); // pivot!BooleanLiteralExp
		Property symbol_17 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::BooleanLiteralExp::booleanSymbol pivot!BooleanLiteralExp!booleanSymbol
		
		Class symbol_18 = PivotFactory.eINSTANCE.createClass(); // pivot!CallExp
		Property symbol_19 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::implicit pivot!CallExp!implicit
		Property symbol_20 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::source pivot!CallExp!source
		
		Class symbol_21 = PivotFactory.eINSTANCE.createClass(); // pivot!CallOperationAction
		Property symbol_22 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallOperationAction::MessageExp pivot!CallOperationAction!MessageExp
		Property symbol_23 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallOperationAction::operation pivot!CallOperationAction!operation
		
		DataType symbol_24 = PivotFactory.eINSTANCE.createDataType(); // pivot!CallableImplementation
		
		Class symbol_25 = PivotFactory.eINSTANCE.createClass(); // pivot!Class
		Property symbol_26 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::Class pivot!Class!Class
		Property symbol_27 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::isAbstract pivot!Class!isAbstract
		Property symbol_28 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::isInterface pivot!Class!isInterface
		Property symbol_29 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::ownedAttribute pivot!Class!ownedAttribute
		Property symbol_30 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::ownedOperation pivot!Class!ownedOperation
		Property symbol_31 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::subClass pivot!Class!subClass
		Property symbol_32 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::superClass pivot!Class!superClass
		
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // pivot!ClassifierType
		Property symbol_34 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ClassifierType::instanceType pivot!ClassifierType!instanceType
		
		Class symbol_35 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionItem
		Property symbol_36 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionItem::item pivot!CollectionItem!item
		
		Enumeration symbol_37 = PivotFactory.eINSTANCE.createEnumeration(); // pivot!CollectionKind
		
		Class symbol_38 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionLiteralExp
		Property symbol_39 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::kind pivot!CollectionLiteralExp!kind
		Property symbol_40 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::part pivot!CollectionLiteralExp!part
		
		Class symbol_41 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionLiteralPart
		Property symbol_42 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralPart::CollectionLiteralExp pivot!CollectionLiteralPart!CollectionLiteralExp
		
		Class symbol_43 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionRange
		Property symbol_44 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::first pivot!CollectionRange!first
		Property symbol_45 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
		
		Class symbol_46 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionType
		Property symbol_47 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
		
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // pivot!Comment
		Property symbol_49 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::Element pivot!Comment!Element
		Property symbol_50 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
		Property symbol_51 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::body pivot!Comment!body
		
		Class symbol_52 = PivotFactory.eINSTANCE.createClass(); // pivot!Constraint
		Property symbol_53 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::NamedElement pivot!Constraint!NamedElement
		Property symbol_54 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
		Property symbol_55 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
		Property symbol_56 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::isCallable pivot!Constraint!isCallable
		Property symbol_57 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
		Property symbol_58 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
		
		Class symbol_59 = PivotFactory.eINSTANCE.createClass(); // pivot!DataType
		Property symbol_60 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
		Property symbol_61 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
		
		Class symbol_62 = PivotFactory.eINSTANCE.createClass(); // pivot!Detail
		Property symbol_63 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::Annotation pivot!Detail!Annotation
		Property symbol_64 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::value pivot!Detail!value
		
		Class symbol_65 = PivotFactory.eINSTANCE.createClass(); // pivot!Element
		Property symbol_66 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::Annotation pivot!Element!Annotation
		Property symbol_67 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::Comment pivot!Element!Comment
		Property symbol_68 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::Constraint pivot!Element!Constraint
		Property symbol_69 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
		
		Class symbol_70 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumLiteralExp
		Property symbol_71 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
		
		Class symbol_72 = PivotFactory.eINSTANCE.createClass(); // pivot!Enumeration
		Property symbol_73 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
		
		Class symbol_74 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumerationLiteral
		Property symbol_75 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::EnumLiteralExp pivot!EnumerationLiteral!EnumLiteralExp
		Property symbol_76 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
		Property symbol_77 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
		
		Class symbol_78 = PivotFactory.eINSTANCE.createClass(); // pivot!ExpressionInOcl
		Property symbol_79 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
		Property symbol_80 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
		Property symbol_81 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
		Property symbol_82 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
		Property symbol_83 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
		
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // pivot!Feature
		Property symbol_85 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
		Property symbol_86 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
		
		Class symbol_87 = PivotFactory.eINSTANCE.createClass(); // pivot!FeatureCallExp
		Property symbol_88 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
		
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // pivot!IfExp
		Property symbol_90 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
		Property symbol_91 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
		Property symbol_92 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
		
		DataType symbol_93 = PivotFactory.eINSTANCE.createDataType(); // pivot!Int
		
		PrimitiveType symbol_94 = standardLibrary.getIntegerType(); // pivot!Integer
		Class symbol_95 = PivotFactory.eINSTANCE.createClass(); // pivot!IntegerLiteralExp
		Property symbol_96 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
		
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidLiteralExp
		
		Class symbol_98 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidType
		
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // pivot!IterateExp
		Property symbol_100 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
		
		Class symbol_101 = PivotFactory.eINSTANCE.createClass(); // pivot!Iteration
		Property symbol_102 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::LoopExp pivot!Iteration!LoopExp
		Property symbol_103 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
		Property symbol_104 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
		
		Class symbol_105 = PivotFactory.eINSTANCE.createClass(); // pivot!IteratorExp
		
		Class symbol_106 = PivotFactory.eINSTANCE.createClass(); // pivot!LambdaType
		Property symbol_107 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
		Property symbol_108 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
		Property symbol_109 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
		
		Class symbol_110 = PivotFactory.eINSTANCE.createClass(); // pivot!LetExp
		Property symbol_111 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
		Property symbol_112 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
		
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // pivot!Library
		
		Class symbol_114 = PivotFactory.eINSTANCE.createClass(); // pivot!LiteralExp
		
		Class symbol_115 = PivotFactory.eINSTANCE.createClass(); // pivot!LoopExp
		Property symbol_116 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
		Property symbol_117 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
		Property symbol_118 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
		
		Class symbol_119 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageExp
		Property symbol_120 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
		Property symbol_121 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
		Property symbol_122 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
		Property symbol_123 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
		
		Class symbol_124 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageType
		Property symbol_125 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
		Property symbol_126 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
		
		Class symbol_127 = PivotFactory.eINSTANCE.createClass(); // pivot!MonikeredElement
		Property symbol_128 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
		
		Class symbol_129 = PivotFactory.eINSTANCE.createClass(); // pivot!MultiplicityElement
		Property symbol_130 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
		Property symbol_131 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
		Property symbol_132 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
		Property symbol_133 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
		
		Class symbol_134 = PivotFactory.eINSTANCE.createClass(); // pivot!Nameable
		
		Class symbol_135 = PivotFactory.eINSTANCE.createClass(); // pivot!NamedElement
		Property symbol_136 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::Constraint pivot!NamedElement!Constraint
		Property symbol_137 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
		Property symbol_138 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
		Property symbol_139 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
		Property symbol_140 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
		
		Class symbol_141 = PivotFactory.eINSTANCE.createClass(); // pivot!Namespace
		
		Class symbol_142 = PivotFactory.eINSTANCE.createClass(); // pivot!NavigationCallExp
		Property symbol_143 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
		Property symbol_144 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
		
		Class symbol_145 = PivotFactory.eINSTANCE.createClass(); // pivot!NullLiteralExp
		
		Class symbol_146 = PivotFactory.eINSTANCE.createClass(); // pivot!NumericLiteralExp
		
		DataType symbol_147 = PivotFactory.eINSTANCE.createDataType(); // pivot!Object
		
		Class symbol_148 = PivotFactory.eINSTANCE.createClass(); // pivot!OclExpression
		Property symbol_149 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::CallExp pivot!OclExpression!CallExp
		Property symbol_150 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::CollectionItem pivot!OclExpression!CollectionItem
		Property symbol_151 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::CollectionRange pivot!OclExpression!CollectionRange
		Property symbol_152 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::ExpressionInOcl pivot!OclExpression!ExpressionInOcl
		Property symbol_153 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::IfExp pivot!OclExpression!IfExp
		Property symbol_154 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::LetExp pivot!OclExpression!LetExp
		Property symbol_155 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::LoopExp pivot!OclExpression!LoopExp
		Property symbol_156 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::MessageExp pivot!OclExpression!MessageExp
		Property symbol_157 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::NavigationCallExp pivot!OclExpression!NavigationCallExp
		Property symbol_158 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::OperationCallExp pivot!OclExpression!OperationCallExp
		Property symbol_159 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::TupleLiteralPart pivot!OclExpression!TupleLiteralPart
		Property symbol_160 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::Variable pivot!OclExpression!Variable
		
		Class symbol_161 = PivotFactory.eINSTANCE.createClass(); // pivot!OpaqueExpression
		Property symbol_162 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
		Property symbol_163 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
		Property symbol_164 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
		Property symbol_165 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
		
		Class symbol_166 = PivotFactory.eINSTANCE.createClass(); // pivot!Operation
		Property symbol_167 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::CallOperationAction pivot!Operation!CallOperationAction
		Property symbol_168 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::MessageType pivot!Operation!MessageType
		Property symbol_169 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::OperationCallExp pivot!Operation!OperationCallExp
		Property symbol_170 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::class pivot!Operation!class
		Property symbol_171 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
		Property symbol_172 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
		Property symbol_173 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
		
		Class symbol_174 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationCallExp
		Property symbol_175 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
		Property symbol_176 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
		
		Class symbol_177 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationTemplateParameter
		
		Class symbol_178 = PivotFactory.eINSTANCE.createClass(); // pivot!OrderedSetType
		
		Class symbol_179 = PivotFactory.eINSTANCE.createClass(); // pivot!Package
		Property symbol_180 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
		Property symbol_181 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
		Property symbol_182 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
		Property symbol_183 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
		Property symbol_184 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
		Property symbol_185 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
		
		Class symbol_186 = PivotFactory.eINSTANCE.createClass(); // pivot!PackageableElement
		
		Class symbol_187 = PivotFactory.eINSTANCE.createClass(); // pivot!Parameter
		Property symbol_188 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::Iteration pivot!Parameter!Iteration
		Property symbol_189 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::Variable pivot!Parameter!Variable
		Property symbol_190 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
		
		Class symbol_191 = PivotFactory.eINSTANCE.createClass(); // pivot!ParameterableElement
		Property symbol_192 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::TemplateParameter pivot!ParameterableElement!TemplateParameter
		Property symbol_193 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::TemplateParameterSubstitution pivot!ParameterableElement!TemplateParameterSubstitution
		Property symbol_194 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
		Property symbol_195 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
		
		Class symbol_196 = PivotFactory.eINSTANCE.createClass(); // pivot!Pivotable
		
		Class symbol_197 = PivotFactory.eINSTANCE.createClass(); // pivot!Precedence
		Property symbol_198 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::Operation pivot!Precedence!Operation
		Property symbol_199 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::Package pivot!Precedence!Package
		Property symbol_200 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
		Property symbol_201 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
		
		Class symbol_202 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveLiteralExp
		
		Class symbol_203 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveType
		
		Class symbol_204 = PivotFactory.eINSTANCE.createClass(); // pivot!Property
		Property symbol_205 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::NavigationCallExp pivot!Property!NavigationCallExp
		Property symbol_206 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::Property pivot!Property!Property
		Property symbol_207 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::PropertyCallExp pivot!Property!PropertyCallExp
		Property symbol_208 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::association pivot!Property!association
		Property symbol_209 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::class pivot!Property!class
		Property symbol_210 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::default pivot!Property!default
		Property symbol_211 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
		Property symbol_212 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
		Property symbol_213 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
		Property symbol_214 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isID pivot!Property!isID
		Property symbol_215 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
		Property symbol_216 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
		Property symbol_217 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
		Property symbol_218 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
		Property symbol_219 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
		Property symbol_220 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::keys pivot!Property!keys
		Property symbol_221 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
		
		Class symbol_222 = PivotFactory.eINSTANCE.createClass(); // pivot!PropertyCallExp
		Property symbol_223 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
		
		PrimitiveType symbol_224 = standardLibrary.getRealType(); // pivot!Real
		Class symbol_225 = PivotFactory.eINSTANCE.createClass(); // pivot!RealLiteralExp
		Property symbol_226 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
		
		Class symbol_227 = PivotFactory.eINSTANCE.createClass(); // pivot!SelfType
		
		Class symbol_228 = PivotFactory.eINSTANCE.createClass(); // pivot!SendSignalAction
		Property symbol_229 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::MessageExp pivot!SendSignalAction!MessageExp
		Property symbol_230 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
		
		Class symbol_231 = PivotFactory.eINSTANCE.createClass(); // pivot!SequenceType
		
		Class symbol_232 = PivotFactory.eINSTANCE.createClass(); // pivot!SetType
		
		Class symbol_233 = PivotFactory.eINSTANCE.createClass(); // pivot!Signal
		Property symbol_234 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Signal::MessageType pivot!Signal!MessageType
		Property symbol_235 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Signal::SendSignalAction pivot!Signal!SendSignalAction
		
		Class symbol_236 = PivotFactory.eINSTANCE.createClass(); // pivot!State
		Property symbol_237 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::State::StateExp pivot!State!StateExp
		
		Class symbol_238 = PivotFactory.eINSTANCE.createClass(); // pivot!StateExp
		Property symbol_239 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
		
		PrimitiveType symbol_240 = standardLibrary.getStringType(); // pivot!String
		Class symbol_241 = PivotFactory.eINSTANCE.createClass(); // pivot!StringLiteralExp
		Property symbol_242 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
		
		Class symbol_243 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateBinding
		Property symbol_244 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
		Property symbol_245 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
		Property symbol_246 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
		
		Class symbol_247 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameter
		Property symbol_248 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::TemplateParameterSubstitution pivot!TemplateParameter!TemplateParameterSubstitution
		Property symbol_249 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::TemplateSignature pivot!TemplateParameter!TemplateSignature
		Property symbol_250 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
		Property symbol_251 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
		Property symbol_252 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
		Property symbol_253 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
		Property symbol_254 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
		
		Class symbol_255 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterSubstitution
		Property symbol_256 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
		Property symbol_257 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
		Property symbol_258 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
		Property symbol_259 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
		
		Class symbol_260 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterType
		Property symbol_261 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
		
		Class symbol_262 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateSignature
		Property symbol_263 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::TemplateBinding pivot!TemplateSignature!TemplateBinding
		Property symbol_264 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
		Property symbol_265 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
		Property symbol_266 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
		
		Class symbol_267 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateableElement
		Property symbol_268 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
		Property symbol_269 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
		Property symbol_270 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::unspecializedElement pivot!TemplateableElement!unspecializedElement
		
		DataType symbol_271 = PivotFactory.eINSTANCE.createDataType(); // pivot!Throwable
		
		Class symbol_272 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralExp
		Property symbol_273 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
		
		Class symbol_274 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralPart
		Property symbol_275 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::TupleLiteralExp pivot!TupleLiteralPart!TupleLiteralExp
		Property symbol_276 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
		
		Class symbol_277 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleType
		
		Class symbol_278 = PivotFactory.eINSTANCE.createClass(); // pivot!Type
		Property symbol_279 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::ClassifierType pivot!Type!ClassifierType
		Property symbol_280 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::CollectionType pivot!Type!CollectionType
		Property symbol_281 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::DataType pivot!Type!DataType
		Property symbol_282 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::LambdaType pivot!Type!LambdaType
		Property symbol_283 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::Operation pivot!Type!Operation
		Property symbol_284 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::TypeExp pivot!Type!TypeExp
		Property symbol_285 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::TypeTemplateParameter pivot!Type!TypeTemplateParameter
		Property symbol_286 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::TypedElement pivot!Type!TypedElement
		Property symbol_287 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::UnspecifiedType pivot!Type!UnspecifiedType
		Property symbol_288 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
		Property symbol_289 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::package pivot!Type!package
		
		Class symbol_290 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeExp
		Property symbol_291 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
		
		Class symbol_292 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeTemplateParameter
		Property symbol_293 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
		Property symbol_294 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
		
		Class symbol_295 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedElement
		Property symbol_296 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
		
		Class symbol_297 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedMultiplicityElement
		
		PrimitiveType symbol_298 = standardLibrary.getUnlimitedNaturalType(); // pivot!UnlimitedNatural
		Class symbol_299 = PivotFactory.eINSTANCE.createClass(); // pivot!UnlimitedNaturalLiteralExp
		Property symbol_300 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
		
		Class symbol_301 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedType
		Property symbol_302 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
		Property symbol_303 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
		
		Class symbol_304 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedValueExp
		
		Class symbol_305 = PivotFactory.eINSTANCE.createClass(); // pivot!ValueSpecification
		Property symbol_306 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ValueSpecification::Constraint pivot!ValueSpecification!Constraint
		
		Class symbol_307 = PivotFactory.eINSTANCE.createClass(); // pivot!Variable
		Property symbol_308 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::ExpressionInOcl pivot!Variable!ExpressionInOcl
		Property symbol_309 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::IterateExp pivot!Variable!IterateExp
		Property symbol_310 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::LetExp pivot!Variable!LetExp
		Property symbol_311 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::LoopExp pivot!Variable!LoopExp
		Property symbol_312 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
		Property symbol_313 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
		Property symbol_314 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
		
		Class symbol_315 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableDeclaration
		Property symbol_316 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableDeclaration::VariableExp pivot!VariableDeclaration!VariableExp
		
		Class symbol_317 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableExp
		Property symbol_318 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
		Property symbol_319 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
		
		Class symbol_320 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitable
		
		Class symbol_321 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}
		TemplateSignature symbol_322 = PivotFactory.eINSTANCE.createTemplateSignature(); // pivot!Visitor{R,C}!
		TypeTemplateParameter symbol_323 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_324 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?R
		TypeTemplateParameter symbol_325 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_326 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?C
		
		
		Class symbol_327 = PivotFactory.eINSTANCE.createClass(); // pivot!VoidType
		

		symbol_1.setName("pivot");
		symbol_1.setNsPrefix("pivot");
		symbol_1.setNsURI("http://www.eclipse.org/ocl/3.1.0/Pivot");
		//
		// pivot.ecore::pivot::Annotation pivot!Annotation
		//
		symbol_2.setName("Annotation");
		//symbol_2.setMoniker("pivot!Annotation");
		symbol_2.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::Annotation::NamedElement pivot!Annotation!NamedElement
			symbol_3.setName("NamedElement");
			symbol_3.setType(symbol_135);  // pivot!NamedElement
			symbol_3.setLower(BigInteger.valueOf(0));
			
			symbol_3.setImplicit(true);
			symbol_3.setIsResolveProxies(true);
			symbol_3.setOpposite(symbol_139);
			symbol_2.getOwnedAttributes().add(symbol_3);
		}
		{ // pivot.ecore::pivot::Annotation::ownedContent pivot!Annotation!ownedContent
			symbol_4.setName("ownedContent");
			symbol_4.setType(symbol_65);  // pivot!Element
			symbol_4.setLower(BigInteger.valueOf(0));
			symbol_4.setUpper(BigInteger.valueOf(-1));
			symbol_4.setIsOrdered(true);
			
			symbol_4.setIsComposite(true);
			symbol_4.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_4);
		}
		{ // pivot.ecore::pivot::Annotation::ownedDetail pivot!Annotation!ownedDetail
			symbol_5.setName("ownedDetail");
			symbol_5.setType(symbol_62);  // pivot!Detail
			symbol_5.setLower(BigInteger.valueOf(0));
			symbol_5.setUpper(BigInteger.valueOf(-1));
			symbol_5.setIsOrdered(true);
			
			symbol_5.setIsComposite(true);
			symbol_5.setIsResolveProxies(true);
			symbol_5.setOpposite(symbol_63);
			symbol_2.getOwnedAttributes().add(symbol_5);
		}
		{ // pivot.ecore::pivot::Annotation::reference pivot!Annotation!reference
			symbol_6.setName("reference");
			symbol_6.setType(symbol_65);  // pivot!Element
			symbol_6.setLower(BigInteger.valueOf(0));
			symbol_6.setUpper(BigInteger.valueOf(-1));
			symbol_6.setIsOrdered(true);
			
			symbol_6.setIsResolveProxies(true);
			symbol_6.setOpposite(symbol_66);
			symbol_2.getOwnedAttributes().add(symbol_6);
		}
		symbol_1.getOwnedTypes().add(symbol_2);
		//
		// pivot.ecore::pivot::AnyType pivot!AnyType
		//
		symbol_7.setName("AnyType");
		//symbol_7.setMoniker("pivot!AnyType");
		symbol_7.getSuperClasses().add(symbol_25); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_7);
		//
		// pivot.ecore::pivot::AssociationClass pivot!AssociationClass
		//
		symbol_8.setName("AssociationClass");
		//symbol_8.setMoniker("pivot!AssociationClass");
		symbol_8.getSuperClasses().add(symbol_25); // pivot!Class
		{ // pivot.ecore::pivot::AssociationClass::AssociationClassCallExp pivot!AssociationClass!AssociationClassCallExp
			symbol_9.setName("AssociationClassCallExp");
			symbol_9.setType(symbol_11);  // pivot!AssociationClassCallExp
			symbol_9.setLower(BigInteger.valueOf(0));
			symbol_9.setUpper(BigInteger.valueOf(-1));
			
			symbol_9.setImplicit(true);
			symbol_9.setIsResolveProxies(true);
			symbol_9.setOpposite(symbol_12);
			symbol_8.getOwnedAttributes().add(symbol_9);
		}
		{ // pivot.ecore::pivot::AssociationClass::unownedAttribute pivot!AssociationClass!unownedAttribute
			symbol_10.setName("unownedAttribute");
			symbol_10.setType(symbol_204);  // pivot!Property
			symbol_10.setLower(BigInteger.valueOf(0));
			symbol_10.setUpper(BigInteger.valueOf(-1));
			
			symbol_10.setIsResolveProxies(true);
			symbol_10.setOpposite(symbol_208);
			symbol_8.getOwnedAttributes().add(symbol_10);
		}
		symbol_1.getOwnedTypes().add(symbol_8);
		//
		// pivot.ecore::pivot::AssociationClassCallExp pivot!AssociationClassCallExp
		//
		symbol_11.setName("AssociationClassCallExp");
		//symbol_11.setMoniker("pivot!AssociationClassCallExp");
		symbol_11.getSuperClasses().add(symbol_142); // pivot!NavigationCallExp
		{ // pivot.ecore::pivot::AssociationClassCallExp::referredAssociationClass pivot!AssociationClassCallExp!referredAssociationClass
			symbol_12.setName("referredAssociationClass");
			symbol_12.setType(symbol_8);  // pivot!AssociationClass
			symbol_12.setLower(BigInteger.valueOf(0));
			
			symbol_12.setIsResolveProxies(true);
			symbol_12.setOpposite(symbol_9);
			symbol_11.getOwnedAttributes().add(symbol_12);
		}
		symbol_1.getOwnedTypes().add(symbol_11);
		//
		// pivot.ecore::pivot::AssociativityKind pivot!AssociativityKind
		//
		symbol_13.setName("AssociativityKind");
		//symbol_13.setMoniker("pivot!AssociativityKind");
		{
			EnumerationLiteral symbol_328 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Left pivot!AssociativityKind!Left
			symbol_328.setName("Left");
			symbol_13.getOwnedLiterals().add(symbol_328);
			EnumerationLiteral symbol_329 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Right pivot!AssociativityKind!Right
			symbol_329.setName("Right");
			symbol_13.getOwnedLiterals().add(symbol_329);
		}
		
		symbol_1.getOwnedTypes().add(symbol_13);
		//
		// pivot.ecore::pivot::BagType pivot!BagType
		//
		symbol_14.setName("BagType");
		//symbol_14.setMoniker("pivot!BagType");
		symbol_14.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_14);
		//
		// pivot.ecore::pivot::BooleanLiteralExp pivot!BooleanLiteralExp
		//
		symbol_16.setName("BooleanLiteralExp");
		//symbol_16.setMoniker("pivot!BooleanLiteralExp");
		symbol_16.getSuperClasses().add(symbol_202); // pivot!PrimitiveLiteralExp
		{ // pivot.ecore::pivot::BooleanLiteralExp::booleanSymbol pivot!BooleanLiteralExp!booleanSymbol
			symbol_17.setName("booleanSymbol");
			symbol_17.setType(symbol_15);  // pivot!Boolean
			
			symbol_17.setIsResolveProxies(true);
			symbol_17.setIsUnsettable(true);
			symbol_16.getOwnedAttributes().add(symbol_17);
		}
		symbol_1.getOwnedTypes().add(symbol_16);
		//
		// pivot.ecore::pivot::CallExp pivot!CallExp
		//
		symbol_18.setName("CallExp");
		//symbol_18.setMoniker("pivot!CallExp");
		symbol_18.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::CallExp::implicit pivot!CallExp!implicit
			symbol_19.setName("implicit");
			symbol_19.setType(symbol_15);  // pivot!Boolean
			symbol_19.setLower(BigInteger.valueOf(0));
			
			symbol_19.setIsResolveProxies(true);
			symbol_18.getOwnedAttributes().add(symbol_19);
		}
		{ // pivot.ecore::pivot::CallExp::source pivot!CallExp!source
			symbol_20.setName("source");
			symbol_20.setType(symbol_148);  // pivot!OclExpression
			symbol_20.setLower(BigInteger.valueOf(0));
			
			symbol_20.setIsComposite(true);
			symbol_20.setIsResolveProxies(true);
			symbol_20.setOpposite(symbol_149);
			symbol_18.getOwnedAttributes().add(symbol_20);
		}
		symbol_1.getOwnedTypes().add(symbol_18);
		//
		// pivot.ecore::pivot::CallOperationAction pivot!CallOperationAction
		//
		symbol_21.setName("CallOperationAction");
		//symbol_21.setMoniker("pivot!CallOperationAction");
		symbol_21.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::CallOperationAction::MessageExp pivot!CallOperationAction!MessageExp
			symbol_22.setName("MessageExp");
			symbol_22.setType(symbol_119);  // pivot!MessageExp
			symbol_22.setLower(BigInteger.valueOf(0));
			
			symbol_22.setImplicit(true);
			symbol_22.setIsResolveProxies(true);
			symbol_22.setOpposite(symbol_121);
			symbol_21.getOwnedAttributes().add(symbol_22);
		}
		{ // pivot.ecore::pivot::CallOperationAction::operation pivot!CallOperationAction!operation
			symbol_23.setName("operation");
			symbol_23.setType(symbol_166);  // pivot!Operation
			
			symbol_23.setIsResolveProxies(true);
			symbol_23.setOpposite(symbol_167);
			symbol_21.getOwnedAttributes().add(symbol_23);
		}
		symbol_1.getOwnedTypes().add(symbol_21);
		//
		// pivot.ecore::pivot::CallableImplementation pivot!CallableImplementation
		//
		symbol_24.setName("CallableImplementation");
		//symbol_24.setMoniker("pivot!CallableImplementation");
		symbol_1.getOwnedTypes().add(symbol_24);
		//
		// pivot.ecore::pivot::Class pivot!Class
		//
		symbol_25.setName("Class");
		//symbol_25.setMoniker("pivot!Class");
		symbol_25.getSuperClasses().add(symbol_141); // pivot!Namespace
		symbol_25.getSuperClasses().add(symbol_278); // pivot!Type
		{ // pivot.ecore::pivot::Class::Class pivot!Class!Class
			symbol_26.setName("Class");
			symbol_26.setType(symbol_25);  // pivot!Class
			symbol_26.setLower(BigInteger.valueOf(0));
			symbol_26.setUpper(BigInteger.valueOf(-1));
			
			symbol_26.setImplicit(true);
			symbol_26.setIsResolveProxies(true);
			symbol_26.setOpposite(symbol_32);
			symbol_25.getOwnedAttributes().add(symbol_26);
		}
		{ // pivot.ecore::pivot::Class::isAbstract pivot!Class!isAbstract
			symbol_27.setName("isAbstract");
			symbol_27.setType(symbol_15);  // pivot!Boolean
			
			symbol_27.setIsResolveProxies(true);
			symbol_25.getOwnedAttributes().add(symbol_27);
		}
		{ // pivot.ecore::pivot::Class::isInterface pivot!Class!isInterface
			symbol_28.setName("isInterface");
			symbol_28.setType(symbol_15);  // pivot!Boolean
			
			symbol_28.setIsResolveProxies(true);
			symbol_25.getOwnedAttributes().add(symbol_28);
		}
		{ // pivot.ecore::pivot::Class::ownedAttribute pivot!Class!ownedAttribute
			symbol_29.setName("ownedAttribute");
			symbol_29.setType(symbol_204);  // pivot!Property
			symbol_29.setLower(BigInteger.valueOf(0));
			symbol_29.setUpper(BigInteger.valueOf(-1));
			symbol_29.setIsOrdered(true);
			
			symbol_29.setIsComposite(true);
			symbol_29.setIsResolveProxies(true);
			symbol_29.setOpposite(symbol_209);
			symbol_25.getOwnedAttributes().add(symbol_29);
		}
		{ // pivot.ecore::pivot::Class::ownedOperation pivot!Class!ownedOperation
			symbol_30.setName("ownedOperation");
			symbol_30.setType(symbol_166);  // pivot!Operation
			symbol_30.setLower(BigInteger.valueOf(0));
			symbol_30.setUpper(BigInteger.valueOf(-1));
			symbol_30.setIsOrdered(true);
			
			symbol_30.setIsComposite(true);
			symbol_30.setIsResolveProxies(true);
			symbol_30.setOpposite(symbol_170);
			symbol_25.getOwnedAttributes().add(symbol_30);
		}
		{ // pivot.ecore::pivot::Class::subClass pivot!Class!subClass
			symbol_31.setName("subClass");
			symbol_31.setType(symbol_25);  // pivot!Class
			symbol_31.setLower(BigInteger.valueOf(0));
			symbol_31.setUpper(BigInteger.valueOf(-1));
			
			symbol_31.setIsTransient(true);
			symbol_25.getOwnedAttributes().add(symbol_31);
		}
		{ // pivot.ecore::pivot::Class::superClass pivot!Class!superClass
			symbol_32.setName("superClass");
			symbol_32.setType(symbol_25);  // pivot!Class
			symbol_32.setLower(BigInteger.valueOf(0));
			symbol_32.setUpper(BigInteger.valueOf(-1));
			
			symbol_32.setIsResolveProxies(true);
			symbol_32.setOpposite(symbol_26);
			symbol_25.getOwnedAttributes().add(symbol_32);
		}
		symbol_1.getOwnedTypes().add(symbol_25);
		//
		// pivot.ecore::pivot::ClassifierType pivot!ClassifierType
		//
		symbol_33.setName("ClassifierType");
		//symbol_33.setMoniker("pivot!ClassifierType");
		symbol_33.getSuperClasses().add(symbol_59); // pivot!DataType
		{ // pivot.ecore::pivot::ClassifierType::instanceType pivot!ClassifierType!instanceType
			symbol_34.setName("instanceType");
			symbol_34.setType(symbol_278);  // pivot!Type
			
			symbol_34.setIsResolveProxies(true);
			symbol_34.setOpposite(symbol_279);
			symbol_33.getOwnedAttributes().add(symbol_34);
		}
		symbol_1.getOwnedTypes().add(symbol_33);
		//
		// pivot.ecore::pivot::CollectionItem pivot!CollectionItem
		//
		symbol_35.setName("CollectionItem");
		//symbol_35.setMoniker("pivot!CollectionItem");
		symbol_35.getSuperClasses().add(symbol_41); // pivot!CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionItem::item pivot!CollectionItem!item
			symbol_36.setName("item");
			symbol_36.setType(symbol_148);  // pivot!OclExpression
			
			symbol_36.setIsComposite(true);
			symbol_36.setIsResolveProxies(true);
			symbol_36.setOpposite(symbol_150);
			symbol_35.getOwnedAttributes().add(symbol_36);
		}
		symbol_1.getOwnedTypes().add(symbol_35);
		//
		// pivot.ecore::pivot::CollectionKind pivot!CollectionKind
		//
		symbol_37.setName("CollectionKind");
		//symbol_37.setMoniker("pivot!CollectionKind");
		{
			EnumerationLiteral symbol_330 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Collection pivot!CollectionKind!Collection
			symbol_330.setName("Collection");
			symbol_37.getOwnedLiterals().add(symbol_330);
			EnumerationLiteral symbol_331 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Set pivot!CollectionKind!Set
			symbol_331.setName("Set");
			symbol_37.getOwnedLiterals().add(symbol_331);
			EnumerationLiteral symbol_332 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::OrderedSet pivot!CollectionKind!OrderedSet
			symbol_332.setName("OrderedSet");
			symbol_37.getOwnedLiterals().add(symbol_332);
			EnumerationLiteral symbol_333 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Bag pivot!CollectionKind!Bag
			symbol_333.setName("Bag");
			symbol_37.getOwnedLiterals().add(symbol_333);
			EnumerationLiteral symbol_334 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Sequence pivot!CollectionKind!Sequence
			symbol_334.setName("Sequence");
			symbol_37.getOwnedLiterals().add(symbol_334);
		}
		
		symbol_1.getOwnedTypes().add(symbol_37);
		//
		// pivot.ecore::pivot::CollectionLiteralExp pivot!CollectionLiteralExp
		//
		symbol_38.setName("CollectionLiteralExp");
		//symbol_38.setMoniker("pivot!CollectionLiteralExp");
		symbol_38.getSuperClasses().add(symbol_114); // pivot!LiteralExp
		{ // pivot.ecore::pivot::CollectionLiteralExp::kind pivot!CollectionLiteralExp!kind
			symbol_39.setName("kind");
			symbol_39.setType(symbol_37);  // pivot!CollectionKind
			
			symbol_39.setIsResolveProxies(true);
			symbol_38.getOwnedAttributes().add(symbol_39);
		}
		{ // pivot.ecore::pivot::CollectionLiteralExp::part pivot!CollectionLiteralExp!part
			symbol_40.setName("part");
			symbol_40.setType(symbol_41);  // pivot!CollectionLiteralPart
			symbol_40.setLower(BigInteger.valueOf(0));
			symbol_40.setUpper(BigInteger.valueOf(-1));
			symbol_40.setIsOrdered(true);
			
			symbol_40.setIsComposite(true);
			symbol_40.setIsResolveProxies(true);
			symbol_40.setOpposite(symbol_42);
			symbol_38.getOwnedAttributes().add(symbol_40);
		}
		symbol_1.getOwnedTypes().add(symbol_38);
		//
		// pivot.ecore::pivot::CollectionLiteralPart pivot!CollectionLiteralPart
		//
		symbol_41.setName("CollectionLiteralPart");
		//symbol_41.setMoniker("pivot!CollectionLiteralPart");
		symbol_41.getSuperClasses().add(symbol_295); // pivot!TypedElement
		{ // pivot.ecore::pivot::CollectionLiteralPart::CollectionLiteralExp pivot!CollectionLiteralPart!CollectionLiteralExp
			symbol_42.setName("CollectionLiteralExp");
			symbol_42.setType(symbol_38);  // pivot!CollectionLiteralExp
			symbol_42.setLower(BigInteger.valueOf(0));
			
			symbol_42.setImplicit(true);
			symbol_42.setIsResolveProxies(true);
			symbol_42.setOpposite(symbol_40);
			symbol_41.getOwnedAttributes().add(symbol_42);
		}
		symbol_1.getOwnedTypes().add(symbol_41);
		//
		// pivot.ecore::pivot::CollectionRange pivot!CollectionRange
		//
		symbol_43.setName("CollectionRange");
		//symbol_43.setMoniker("pivot!CollectionRange");
		symbol_43.getSuperClasses().add(symbol_41); // pivot!CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionRange::first pivot!CollectionRange!first
			symbol_44.setName("first");
			symbol_44.setType(symbol_148);  // pivot!OclExpression
			
			symbol_44.setIsComposite(true);
			symbol_44.setIsResolveProxies(true);
			symbol_44.setOpposite(symbol_151);
			symbol_43.getOwnedAttributes().add(symbol_44);
		}
		{ // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
			symbol_45.setName("last");
			symbol_45.setType(symbol_148);  // pivot!OclExpression
			
			symbol_45.setIsComposite(true);
			symbol_45.setIsResolveProxies(true);
			symbol_43.getOwnedAttributes().add(symbol_45);
		}
		symbol_1.getOwnedTypes().add(symbol_43);
		//
		// pivot.ecore::pivot::CollectionType pivot!CollectionType
		//
		symbol_46.setName("CollectionType");
		//symbol_46.setMoniker("pivot!CollectionType");
		symbol_46.getSuperClasses().add(symbol_59); // pivot!DataType
		{ // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
			symbol_47.setName("elementType");
			symbol_47.setType(symbol_278);  // pivot!Type
			
			symbol_47.setIsResolveProxies(true);
			symbol_47.setOpposite(symbol_280);
			symbol_46.getOwnedAttributes().add(symbol_47);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// pivot.ecore::pivot::Comment pivot!Comment
		//
		symbol_48.setName("Comment");
		//symbol_48.setMoniker("pivot!Comment");
		symbol_48.getSuperClasses().add(symbol_65); // pivot!Element
		{ // pivot.ecore::pivot::Comment::Element pivot!Comment!Element
			symbol_49.setName("Element");
			symbol_49.setType(symbol_65);  // pivot!Element
			symbol_49.setLower(BigInteger.valueOf(0));
			
			symbol_49.setImplicit(true);
			symbol_49.setIsResolveProxies(true);
			symbol_49.setOpposite(symbol_69);
			symbol_48.getOwnedAttributes().add(symbol_49);
		}
		{ // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
			symbol_50.setName("annotatedElement");
			symbol_50.setType(symbol_65);  // pivot!Element
			symbol_50.setLower(BigInteger.valueOf(0));
			symbol_50.setUpper(BigInteger.valueOf(-1));
			
			symbol_50.setIsResolveProxies(true);
			symbol_50.setOpposite(symbol_67);
			symbol_48.getOwnedAttributes().add(symbol_50);
		}
		{ // pivot.ecore::pivot::Comment::body pivot!Comment!body
			symbol_51.setName("body");
			symbol_51.setType(symbol_240);  // pivot!String
			symbol_51.setLower(BigInteger.valueOf(0));
			
			symbol_51.setIsResolveProxies(true);
			symbol_48.getOwnedAttributes().add(symbol_51);
		}
		symbol_1.getOwnedTypes().add(symbol_48);
		//
		// pivot.ecore::pivot::Constraint pivot!Constraint
		//
		symbol_52.setName("Constraint");
		//symbol_52.setMoniker("pivot!Constraint");
		symbol_52.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::Constraint::NamedElement pivot!Constraint!NamedElement
			symbol_53.setName("NamedElement");
			symbol_53.setType(symbol_135);  // pivot!NamedElement
			symbol_53.setLower(BigInteger.valueOf(0));
			
			symbol_53.setImplicit(true);
			symbol_53.setIsResolveProxies(true);
			symbol_53.setOpposite(symbol_140);
			symbol_52.getOwnedAttributes().add(symbol_53);
		}
		{ // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
			symbol_54.setName("constrainedElement");
			symbol_54.setType(symbol_65);  // pivot!Element
			symbol_54.setLower(BigInteger.valueOf(0));
			symbol_54.setUpper(BigInteger.valueOf(-1));
			symbol_54.setIsOrdered(true);
			
			symbol_54.setIsResolveProxies(true);
			symbol_54.setOpposite(symbol_68);
			symbol_52.getOwnedAttributes().add(symbol_54);
		}
		{ // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
			symbol_55.setName("context");
			symbol_55.setType(symbol_135);  // pivot!NamedElement
			symbol_55.setLower(BigInteger.valueOf(0));
			
			symbol_55.setIsResolveProxies(true);
			symbol_55.setOpposite(symbol_136);
			symbol_52.getOwnedAttributes().add(symbol_55);
		}
		{ // pivot.ecore::pivot::Constraint::isCallable pivot!Constraint!isCallable
			symbol_56.setName("isCallable");
			symbol_56.setType(symbol_15);  // pivot!Boolean
			
			symbol_56.setIsResolveProxies(true);
			symbol_52.getOwnedAttributes().add(symbol_56);
		}
		{ // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
			symbol_57.setName("specification");
			symbol_57.setType(symbol_305);  // pivot!ValueSpecification
			
			symbol_57.setIsComposite(true);
			symbol_57.setIsResolveProxies(true);
			symbol_57.setOpposite(symbol_306);
			symbol_52.getOwnedAttributes().add(symbol_57);
		}
		{ // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
			symbol_58.setName("stereotype");
			symbol_58.setType(symbol_240);  // pivot!String
			symbol_58.setLower(BigInteger.valueOf(0));
			
			symbol_58.setIsResolveProxies(true);
			symbol_52.getOwnedAttributes().add(symbol_58);
		}
		symbol_1.getOwnedTypes().add(symbol_52);
		//
		// pivot.ecore::pivot::DataType pivot!DataType
		//
		symbol_59.setName("DataType");
		//symbol_59.setMoniker("pivot!DataType");
		symbol_59.getSuperClasses().add(symbol_25); // pivot!Class
		{ // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
			symbol_60.setName("behavioralType");
			symbol_60.setType(symbol_278);  // pivot!Type
			symbol_60.setLower(BigInteger.valueOf(0));
			
			symbol_60.setIsResolveProxies(true);
			symbol_60.setOpposite(symbol_281);
			symbol_59.getOwnedAttributes().add(symbol_60);
		}
		{ // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
			symbol_61.setName("isSerializable");
			symbol_61.setType(symbol_15);  // pivot!Boolean
			
			symbol_61.setIsResolveProxies(true);
			symbol_59.getOwnedAttributes().add(symbol_61);
		}
		symbol_1.getOwnedTypes().add(symbol_59);
		//
		// pivot.ecore::pivot::Detail pivot!Detail
		//
		symbol_62.setName("Detail");
		//symbol_62.setMoniker("pivot!Detail");
		symbol_62.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::Detail::Annotation pivot!Detail!Annotation
			symbol_63.setName("Annotation");
			symbol_63.setType(symbol_2);  // pivot!Annotation
			symbol_63.setLower(BigInteger.valueOf(0));
			
			symbol_63.setImplicit(true);
			symbol_63.setIsResolveProxies(true);
			symbol_63.setOpposite(symbol_5);
			symbol_62.getOwnedAttributes().add(symbol_63);
		}
		{ // pivot.ecore::pivot::Detail::value pivot!Detail!value
			symbol_64.setName("value");
			symbol_64.setType(symbol_240);  // pivot!String
			symbol_64.setUpper(BigInteger.valueOf(-1));
			
			symbol_64.setIsResolveProxies(true);
			symbol_62.getOwnedAttributes().add(symbol_64);
		}
		symbol_1.getOwnedTypes().add(symbol_62);
		//
		// pivot.ecore::pivot::Element pivot!Element
		//
		symbol_65.setName("Element");
		//symbol_65.setMoniker("pivot!Element");
		symbol_65.getSuperClasses().add(symbol_320); // pivot!Visitable
		{ // pivot.ecore::pivot::Element::Annotation pivot!Element!Annotation
			symbol_66.setName("Annotation");
			symbol_66.setType(symbol_2);  // pivot!Annotation
			symbol_66.setLower(BigInteger.valueOf(0));
			symbol_66.setUpper(BigInteger.valueOf(-1));
			
			symbol_66.setImplicit(true);
			symbol_66.setIsResolveProxies(true);
			symbol_65.getOwnedAttributes().add(symbol_66);
		}
		{ // pivot.ecore::pivot::Element::Comment pivot!Element!Comment
			symbol_67.setName("Comment");
			symbol_67.setType(symbol_48);  // pivot!Comment
			symbol_67.setLower(BigInteger.valueOf(0));
			symbol_67.setUpper(BigInteger.valueOf(-1));
			
			symbol_67.setImplicit(true);
			symbol_67.setIsResolveProxies(true);
			symbol_67.setOpposite(symbol_50);
			symbol_65.getOwnedAttributes().add(symbol_67);
		}
		{ // pivot.ecore::pivot::Element::Constraint pivot!Element!Constraint
			symbol_68.setName("Constraint");
			symbol_68.setType(symbol_52);  // pivot!Constraint
			symbol_68.setLower(BigInteger.valueOf(0));
			symbol_68.setUpper(BigInteger.valueOf(-1));
			
			symbol_68.setImplicit(true);
			symbol_68.setIsResolveProxies(true);
			symbol_68.setOpposite(symbol_54);
			symbol_65.getOwnedAttributes().add(symbol_68);
		}
		{ // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
			symbol_69.setName("ownedComment");
			symbol_69.setType(symbol_48);  // pivot!Comment
			symbol_69.setLower(BigInteger.valueOf(0));
			symbol_69.setUpper(BigInteger.valueOf(-1));
			
			symbol_69.setIsComposite(true);
			symbol_69.setIsResolveProxies(true);
			symbol_69.setOpposite(symbol_49);
			symbol_65.getOwnedAttributes().add(symbol_69);
		}
		symbol_1.getOwnedTypes().add(symbol_65);
		//
		// pivot.ecore::pivot::EnumLiteralExp pivot!EnumLiteralExp
		//
		symbol_70.setName("EnumLiteralExp");
		//symbol_70.setMoniker("pivot!EnumLiteralExp");
		symbol_70.getSuperClasses().add(symbol_114); // pivot!LiteralExp
		{ // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
			symbol_71.setName("referredEnumLiteral");
			symbol_71.setType(symbol_74);  // pivot!EnumerationLiteral
			symbol_71.setLower(BigInteger.valueOf(0));
			
			symbol_71.setIsResolveProxies(true);
			symbol_71.setOpposite(symbol_75);
			symbol_70.getOwnedAttributes().add(symbol_71);
		}
		symbol_1.getOwnedTypes().add(symbol_70);
		//
		// pivot.ecore::pivot::Enumeration pivot!Enumeration
		//
		symbol_72.setName("Enumeration");
		//symbol_72.setMoniker("pivot!Enumeration");
		symbol_72.getSuperClasses().add(symbol_59); // pivot!DataType
		{ // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
			symbol_73.setName("ownedLiteral");
			symbol_73.setType(symbol_74);  // pivot!EnumerationLiteral
			symbol_73.setLower(BigInteger.valueOf(0));
			symbol_73.setUpper(BigInteger.valueOf(-1));
			symbol_73.setIsOrdered(true);
			
			symbol_73.setIsComposite(true);
			symbol_73.setIsResolveProxies(true);
			symbol_73.setOpposite(symbol_76);
			symbol_72.getOwnedAttributes().add(symbol_73);
		}
		symbol_1.getOwnedTypes().add(symbol_72);
		//
		// pivot.ecore::pivot::EnumerationLiteral pivot!EnumerationLiteral
		//
		symbol_74.setName("EnumerationLiteral");
		//symbol_74.setMoniker("pivot!EnumerationLiteral");
		symbol_74.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::EnumerationLiteral::EnumLiteralExp pivot!EnumerationLiteral!EnumLiteralExp
			symbol_75.setName("EnumLiteralExp");
			symbol_75.setType(symbol_70);  // pivot!EnumLiteralExp
			symbol_75.setLower(BigInteger.valueOf(0));
			symbol_75.setUpper(BigInteger.valueOf(-1));
			
			symbol_75.setImplicit(true);
			symbol_75.setIsResolveProxies(true);
			symbol_75.setOpposite(symbol_71);
			symbol_74.getOwnedAttributes().add(symbol_75);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
			symbol_76.setName("enumeration");
			symbol_76.setType(symbol_72);  // pivot!Enumeration
			symbol_76.setLower(BigInteger.valueOf(0));
			
			symbol_76.setIsResolveProxies(true);
			symbol_76.setOpposite(symbol_73);
			symbol_74.getOwnedAttributes().add(symbol_76);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
			symbol_77.setName("value");
			symbol_77.setType(symbol_94);  // pivot!Integer
			symbol_77.setLower(BigInteger.valueOf(0));
			
			symbol_77.setIsResolveProxies(true);
			symbol_74.getOwnedAttributes().add(symbol_77);
		}
		symbol_1.getOwnedTypes().add(symbol_74);
		//
		// pivot.ecore::pivot::ExpressionInOcl pivot!ExpressionInOcl
		//
		symbol_78.setName("ExpressionInOcl");
		//symbol_78.setMoniker("pivot!ExpressionInOcl");
		symbol_78.getSuperClasses().add(symbol_161); // pivot!OpaqueExpression
		{ // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
			symbol_79.setName("bodyExpression");
			symbol_79.setType(symbol_148);  // pivot!OclExpression
			
			symbol_79.setIsComposite(true);
			symbol_79.setIsResolveProxies(true);
			symbol_79.setOpposite(symbol_152);
			symbol_78.getOwnedAttributes().add(symbol_79);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
			symbol_80.setName("contextVariable");
			symbol_80.setType(symbol_307);  // pivot!Variable
			symbol_80.setLower(BigInteger.valueOf(0));
			
			symbol_80.setIsComposite(true);
			symbol_80.setIsResolveProxies(true);
			symbol_78.getOwnedAttributes().add(symbol_80);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
			symbol_81.setName("messageExpression");
			symbol_81.setType(symbol_148);  // pivot!OclExpression
			symbol_81.setLower(BigInteger.valueOf(0));
			
			symbol_81.setIsComposite(true);
			symbol_81.setIsResolveProxies(true);
			symbol_78.getOwnedAttributes().add(symbol_81);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
			symbol_82.setName("parameterVariable");
			symbol_82.setType(symbol_307);  // pivot!Variable
			symbol_82.setLower(BigInteger.valueOf(0));
			symbol_82.setUpper(BigInteger.valueOf(-1));
			symbol_82.setIsOrdered(true);
			
			symbol_82.setIsComposite(true);
			symbol_82.setIsResolveProxies(true);
			symbol_78.getOwnedAttributes().add(symbol_82);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
			symbol_83.setName("resultVariable");
			symbol_83.setType(symbol_307);  // pivot!Variable
			symbol_83.setLower(BigInteger.valueOf(0));
			
			symbol_83.setIsComposite(true);
			symbol_83.setIsResolveProxies(true);
			symbol_83.setOpposite(symbol_308);
			symbol_78.getOwnedAttributes().add(symbol_83);
		}
		symbol_1.getOwnedTypes().add(symbol_78);
		//
		// pivot.ecore::pivot::Feature pivot!Feature
		//
		symbol_84.setName("Feature");
		//symbol_84.setMoniker("pivot!Feature");
		symbol_84.getSuperClasses().add(symbol_297); // pivot!TypedMultiplicityElement
		{ // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
			symbol_85.setName("implementation");
			symbol_85.setType(symbol_24);  // pivot!CallableImplementation
			symbol_85.setLower(BigInteger.valueOf(0));
			
			symbol_85.setIsResolveProxies(true);
			symbol_85.setIsTransient(true);
			symbol_84.getOwnedAttributes().add(symbol_85);
		}
		{ // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
			symbol_86.setName("implementationClass");
			symbol_86.setType(symbol_240);  // pivot!String
			symbol_86.setLower(BigInteger.valueOf(0));
			
			symbol_86.setIsResolveProxies(true);
			symbol_84.getOwnedAttributes().add(symbol_86);
		}
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// pivot.ecore::pivot::FeatureCallExp pivot!FeatureCallExp
		//
		symbol_87.setName("FeatureCallExp");
		//symbol_87.setMoniker("pivot!FeatureCallExp");
		symbol_87.getSuperClasses().add(symbol_18); // pivot!CallExp
		{ // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
			symbol_88.setName("isPre");
			symbol_88.setType(symbol_15);  // pivot!Boolean
			
			symbol_88.setIsResolveProxies(true);
			symbol_87.getOwnedAttributes().add(symbol_88);
		}
		symbol_1.getOwnedTypes().add(symbol_87);
		//
		// pivot.ecore::pivot::IfExp pivot!IfExp
		//
		symbol_89.setName("IfExp");
		//symbol_89.setMoniker("pivot!IfExp");
		symbol_89.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
			symbol_90.setName("condition");
			symbol_90.setType(symbol_148);  // pivot!OclExpression
			
			symbol_90.setIsComposite(true);
			symbol_90.setIsResolveProxies(true);
			symbol_89.getOwnedAttributes().add(symbol_90);
		}
		{ // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
			symbol_91.setName("elseExpression");
			symbol_91.setType(symbol_148);  // pivot!OclExpression
			
			symbol_91.setIsComposite(true);
			symbol_91.setIsResolveProxies(true);
			symbol_89.getOwnedAttributes().add(symbol_91);
		}
		{ // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
			symbol_92.setName("thenExpression");
			symbol_92.setType(symbol_148);  // pivot!OclExpression
			
			symbol_92.setIsComposite(true);
			symbol_92.setIsResolveProxies(true);
			symbol_92.setOpposite(symbol_153);
			symbol_89.getOwnedAttributes().add(symbol_92);
		}
		symbol_1.getOwnedTypes().add(symbol_89);
		//
		// pivot.ecore::pivot::Int pivot!Int
		//
		symbol_93.setName("Int");
		//symbol_93.setMoniker("pivot!Int");
		symbol_1.getOwnedTypes().add(symbol_93);
		//
		// pivot.ecore::pivot::IntegerLiteralExp pivot!IntegerLiteralExp
		//
		symbol_95.setName("IntegerLiteralExp");
		//symbol_95.setMoniker("pivot!IntegerLiteralExp");
		symbol_95.getSuperClasses().add(symbol_146); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
			symbol_96.setName("integerSymbol");
			symbol_96.setType(symbol_94);  // pivot!Integer
			
			symbol_96.setIsResolveProxies(true);
			symbol_95.getOwnedAttributes().add(symbol_96);
		}
		symbol_1.getOwnedTypes().add(symbol_95);
		//
		// pivot.ecore::pivot::InvalidLiteralExp pivot!InvalidLiteralExp
		//
		symbol_97.setName("InvalidLiteralExp");
		//symbol_97.setMoniker("pivot!InvalidLiteralExp");
		symbol_97.getSuperClasses().add(symbol_114); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_97);
		//
		// pivot.ecore::pivot::InvalidType pivot!InvalidType
		//
		symbol_98.setName("InvalidType");
		//symbol_98.setMoniker("pivot!InvalidType");
		symbol_98.getSuperClasses().add(symbol_25); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_98);
		//
		// pivot.ecore::pivot::IterateExp pivot!IterateExp
		//
		symbol_99.setName("IterateExp");
		//symbol_99.setMoniker("pivot!IterateExp");
		symbol_99.getSuperClasses().add(symbol_115); // pivot!LoopExp
		{ // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
			symbol_100.setName("result");
			symbol_100.setType(symbol_307);  // pivot!Variable
			symbol_100.setLower(BigInteger.valueOf(0));
			symbol_100.setIsOrdered(true);
			
			symbol_100.setIsComposite(true);
			symbol_100.setIsResolveProxies(true);
			symbol_100.setOpposite(symbol_309);
			symbol_99.getOwnedAttributes().add(symbol_100);
		}
		symbol_1.getOwnedTypes().add(symbol_99);
		//
		// pivot.ecore::pivot::Iteration pivot!Iteration
		//
		symbol_101.setName("Iteration");
		//symbol_101.setMoniker("pivot!Iteration");
		symbol_101.getSuperClasses().add(symbol_166); // pivot!Operation
		{ // pivot.ecore::pivot::Iteration::LoopExp pivot!Iteration!LoopExp
			symbol_102.setName("LoopExp");
			symbol_102.setType(symbol_115);  // pivot!LoopExp
			symbol_102.setLower(BigInteger.valueOf(0));
			symbol_102.setUpper(BigInteger.valueOf(-1));
			
			symbol_102.setImplicit(true);
			symbol_102.setIsResolveProxies(true);
			symbol_102.setOpposite(symbol_118);
			symbol_101.getOwnedAttributes().add(symbol_102);
		}
		{ // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
			symbol_103.setName("ownedAccumulator");
			symbol_103.setType(symbol_187);  // pivot!Parameter
			symbol_103.setLower(BigInteger.valueOf(0));
			symbol_103.setUpper(BigInteger.valueOf(-1));
			
			symbol_103.setIsComposite(true);
			symbol_103.setIsResolveProxies(true);
			symbol_101.getOwnedAttributes().add(symbol_103);
		}
		{ // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
			symbol_104.setName("ownedIterator");
			symbol_104.setType(symbol_187);  // pivot!Parameter
			symbol_104.setLower(BigInteger.valueOf(0));
			symbol_104.setUpper(BigInteger.valueOf(-1));
			
			symbol_104.setIsComposite(true);
			symbol_104.setIsResolveProxies(true);
			symbol_104.setOpposite(symbol_188);
			symbol_101.getOwnedAttributes().add(symbol_104);
		}
		symbol_1.getOwnedTypes().add(symbol_101);
		//
		// pivot.ecore::pivot::IteratorExp pivot!IteratorExp
		//
		symbol_105.setName("IteratorExp");
		//symbol_105.setMoniker("pivot!IteratorExp");
		symbol_105.getSuperClasses().add(symbol_115); // pivot!LoopExp
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// pivot.ecore::pivot::LambdaType pivot!LambdaType
		//
		symbol_106.setName("LambdaType");
		//symbol_106.setMoniker("pivot!LambdaType");
		symbol_106.getSuperClasses().add(symbol_59); // pivot!DataType
		{ // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
			symbol_107.setName("contextType");
			symbol_107.setType(symbol_278);  // pivot!Type
			
			symbol_107.setIsResolveProxies(true);
			symbol_107.setOpposite(symbol_282);
			symbol_106.getOwnedAttributes().add(symbol_107);
		}
		{ // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
			symbol_108.setName("parameterType");
			symbol_108.setType(symbol_278);  // pivot!Type
			symbol_108.setLower(BigInteger.valueOf(0));
			symbol_108.setUpper(BigInteger.valueOf(-1));
			
			symbol_108.setIsResolveProxies(true);
			symbol_106.getOwnedAttributes().add(symbol_108);
		}
		{ // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
			symbol_109.setName("resultType");
			symbol_109.setType(symbol_278);  // pivot!Type
			
			symbol_109.setIsResolveProxies(true);
			symbol_106.getOwnedAttributes().add(symbol_109);
		}
		symbol_1.getOwnedTypes().add(symbol_106);
		//
		// pivot.ecore::pivot::LetExp pivot!LetExp
		//
		symbol_110.setName("LetExp");
		//symbol_110.setMoniker("pivot!LetExp");
		symbol_110.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
			symbol_111.setName("in");
			symbol_111.setType(symbol_148);  // pivot!OclExpression
			
			symbol_111.setIsComposite(true);
			symbol_111.setIsResolveProxies(true);
			symbol_111.setOpposite(symbol_154);
			symbol_110.getOwnedAttributes().add(symbol_111);
		}
		{ // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
			symbol_112.setName("variable");
			symbol_112.setType(symbol_307);  // pivot!Variable
			
			symbol_112.setIsComposite(true);
			symbol_112.setIsResolveProxies(true);
			symbol_112.setOpposite(symbol_310);
			symbol_110.getOwnedAttributes().add(symbol_112);
		}
		symbol_1.getOwnedTypes().add(symbol_110);
		//
		// pivot.ecore::pivot::Library pivot!Library
		//
		symbol_113.setName("Library");
		//symbol_113.setMoniker("pivot!Library");
		symbol_113.getSuperClasses().add(symbol_179); // pivot!Package
		symbol_1.getOwnedTypes().add(symbol_113);
		//
		// pivot.ecore::pivot::LiteralExp pivot!LiteralExp
		//
		symbol_114.setName("LiteralExp");
		//symbol_114.setMoniker("pivot!LiteralExp");
		symbol_114.getSuperClasses().add(symbol_148); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_114);
		//
		// pivot.ecore::pivot::LoopExp pivot!LoopExp
		//
		symbol_115.setName("LoopExp");
		//symbol_115.setMoniker("pivot!LoopExp");
		symbol_115.getSuperClasses().add(symbol_18); // pivot!CallExp
		{ // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
			symbol_116.setName("body");
			symbol_116.setType(symbol_148);  // pivot!OclExpression
			
			symbol_116.setIsComposite(true);
			symbol_116.setIsResolveProxies(true);
			symbol_116.setOpposite(symbol_155);
			symbol_115.getOwnedAttributes().add(symbol_116);
		}
		{ // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
			symbol_117.setName("iterator");
			symbol_117.setType(symbol_307);  // pivot!Variable
			symbol_117.setLower(BigInteger.valueOf(0));
			symbol_117.setUpper(BigInteger.valueOf(-1));
			symbol_117.setIsOrdered(true);
			
			symbol_117.setIsComposite(true);
			symbol_117.setIsResolveProxies(true);
			symbol_117.setOpposite(symbol_311);
			symbol_115.getOwnedAttributes().add(symbol_117);
		}
		{ // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
			symbol_118.setName("referredIteration");
			symbol_118.setType(symbol_101);  // pivot!Iteration
			symbol_118.setLower(BigInteger.valueOf(0));
			
			symbol_118.setIsResolveProxies(true);
			symbol_118.setOpposite(symbol_102);
			symbol_115.getOwnedAttributes().add(symbol_118);
		}
		symbol_1.getOwnedTypes().add(symbol_115);
		//
		// pivot.ecore::pivot::MessageExp pivot!MessageExp
		//
		symbol_119.setName("MessageExp");
		//symbol_119.setMoniker("pivot!MessageExp");
		symbol_119.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
			symbol_120.setName("argument");
			symbol_120.setType(symbol_148);  // pivot!OclExpression
			symbol_120.setLower(BigInteger.valueOf(0));
			symbol_120.setUpper(BigInteger.valueOf(-1));
			symbol_120.setIsOrdered(true);
			
			symbol_120.setIsComposite(true);
			symbol_120.setIsResolveProxies(true);
			symbol_120.setOpposite(symbol_156);
			symbol_119.getOwnedAttributes().add(symbol_120);
		}
		{ // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
			symbol_121.setName("calledOperation");
			symbol_121.setType(symbol_21);  // pivot!CallOperationAction
			symbol_121.setLower(BigInteger.valueOf(0));
			
			symbol_121.setIsComposite(true);
			symbol_121.setIsResolveProxies(true);
			symbol_121.setOpposite(symbol_22);
			symbol_119.getOwnedAttributes().add(symbol_121);
		}
		{ // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
			symbol_122.setName("sentSignal");
			symbol_122.setType(symbol_228);  // pivot!SendSignalAction
			symbol_122.setLower(BigInteger.valueOf(0));
			
			symbol_122.setIsComposite(true);
			symbol_122.setIsResolveProxies(true);
			symbol_122.setOpposite(symbol_229);
			symbol_119.getOwnedAttributes().add(symbol_122);
		}
		{ // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
			symbol_123.setName("target");
			symbol_123.setType(symbol_148);  // pivot!OclExpression
			
			symbol_123.setIsComposite(true);
			symbol_123.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_123);
		}
		symbol_1.getOwnedTypes().add(symbol_119);
		//
		// pivot.ecore::pivot::MessageType pivot!MessageType
		//
		symbol_124.setName("MessageType");
		//symbol_124.setMoniker("pivot!MessageType");
		symbol_124.getSuperClasses().add(symbol_278); // pivot!Type
		{ // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
			symbol_125.setName("referredOperation");
			symbol_125.setType(symbol_166);  // pivot!Operation
			symbol_125.setLower(BigInteger.valueOf(0));
			
			symbol_125.setIsResolveProxies(true);
			symbol_125.setOpposite(symbol_168);
			symbol_124.getOwnedAttributes().add(symbol_125);
		}
		{ // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
			symbol_126.setName("referredSignal");
			symbol_126.setType(symbol_233);  // pivot!Signal
			symbol_126.setLower(BigInteger.valueOf(0));
			
			symbol_126.setIsResolveProxies(true);
			symbol_126.setOpposite(symbol_234);
			symbol_124.getOwnedAttributes().add(symbol_126);
		}
		symbol_1.getOwnedTypes().add(symbol_124);
		//
		// pivot.ecore::pivot::MonikeredElement pivot!MonikeredElement
		//
		symbol_127.setName("MonikeredElement");
		//symbol_127.setMoniker("pivot!MonikeredElement");
		symbol_127.getSuperClasses().add(symbol_65); // pivot!Element
		{ // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
			symbol_128.setName("moniker");
			symbol_128.setType(symbol_240);  // pivot!String
			
			symbol_128.setIsDerived(true);
			symbol_128.setIsResolveProxies(true);
			symbol_128.setIsTransient(true);
			symbol_128.setIsVolatile(true);
			symbol_127.getOwnedAttributes().add(symbol_128);
		}
		{	// pivot.ecore::pivot::MonikeredElement::hasMoniker() pivot!MonikeredElement!hasMoniker()
			Operation symbol_335 = PivotFactory.eINSTANCE.createOperation();
			symbol_335.setName("hasMoniker");
			//symbol_335.setMoniker("pivot!MonikeredElement!hasMoniker()");
			symbol_335.setType(symbol_15);  // pivot!Boolean
			
			symbol_127.getOwnedOperations().add(symbol_335);
		}
		symbol_1.getOwnedTypes().add(symbol_127);
		//
		// pivot.ecore::pivot::MultiplicityElement pivot!MultiplicityElement
		//
		symbol_129.setName("MultiplicityElement");
		//symbol_129.setMoniker("pivot!MultiplicityElement");
		symbol_129.getSuperClasses().add(symbol_127); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
			symbol_130.setName("isOrdered");
			symbol_130.setType(symbol_15);  // pivot!Boolean
			
			symbol_130.setIsResolveProxies(true);
			symbol_129.getOwnedAttributes().add(symbol_130);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
			symbol_131.setName("isUnique");
			symbol_131.setType(symbol_15);  // pivot!Boolean
			
			symbol_131.setIsResolveProxies(true);
			symbol_129.getOwnedAttributes().add(symbol_131);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
			symbol_132.setName("lower");
			symbol_132.setType(symbol_94);  // pivot!Integer
			symbol_132.setLower(BigInteger.valueOf(0));
			
			symbol_132.setIsResolveProxies(true);
			symbol_129.getOwnedAttributes().add(symbol_132);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
			symbol_133.setName("upper");
			symbol_133.setType(symbol_298);  // pivot!UnlimitedNatural
			symbol_133.setLower(BigInteger.valueOf(0));
			
			symbol_133.setIsResolveProxies(true);
			symbol_129.getOwnedAttributes().add(symbol_133);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesCardinality() pivot!MultiplicityElement!includesCardinality(pivot!Integer)
			Operation symbol_336 = PivotFactory.eINSTANCE.createOperation();
			symbol_336.setName("includesCardinality");
			//symbol_336.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)");
			symbol_336.setType(symbol_15);  // pivot!Boolean
			
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("C");
			//symbol_337.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)!C");
			symbol_337.setType(symbol_94);  // pivot!Integer
			
			symbol_336.getOwnedParameters().add(symbol_337);
			symbol_129.getOwnedOperations().add(symbol_336);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesMultiplicity() pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("includesMultiplicity");
			//symbol_338.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)");
			symbol_338.setType(symbol_15);  // pivot!Boolean
			
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("M");
			//symbol_339.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)!M");
			symbol_339.setType(symbol_129);  // pivot!MultiplicityElement
			
			symbol_338.getOwnedParameters().add(symbol_339);
			symbol_129.getOwnedOperations().add(symbol_338);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::isMultivalued() pivot!MultiplicityElement!isMultivalued()
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("isMultivalued");
			//symbol_340.setMoniker("pivot!MultiplicityElement!isMultivalued()");
			symbol_340.setType(symbol_15);  // pivot!Boolean
			
			symbol_129.getOwnedOperations().add(symbol_340);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::lowerBound() pivot!MultiplicityElement!lowerBound()
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("lowerBound");
			//symbol_341.setMoniker("pivot!MultiplicityElement!lowerBound()");
			symbol_341.setType(symbol_94);  // pivot!Integer
			
			symbol_129.getOwnedOperations().add(symbol_341);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::upperBound() pivot!MultiplicityElement!upperBound()
			Operation symbol_342 = PivotFactory.eINSTANCE.createOperation();
			symbol_342.setName("upperBound");
			//symbol_342.setMoniker("pivot!MultiplicityElement!upperBound()");
			symbol_342.setType(symbol_298);  // pivot!UnlimitedNatural
			
			symbol_129.getOwnedOperations().add(symbol_342);
		}
		symbol_1.getOwnedTypes().add(symbol_129);
		//
		// pivot.ecore::pivot::Nameable pivot!Nameable
		//
		symbol_134.setName("Nameable");
		//symbol_134.setMoniker("pivot!Nameable");
		symbol_1.getOwnedTypes().add(symbol_134);
		//
		// pivot.ecore::pivot::NamedElement pivot!NamedElement
		//
		symbol_135.setName("NamedElement");
		//symbol_135.setMoniker("pivot!NamedElement");
		symbol_135.getSuperClasses().add(symbol_127); // pivot!MonikeredElement
		symbol_135.getSuperClasses().add(symbol_134); // pivot!Nameable
		{ // pivot.ecore::pivot::NamedElement::Constraint pivot!NamedElement!Constraint
			symbol_136.setName("Constraint");
			symbol_136.setType(symbol_52);  // pivot!Constraint
			symbol_136.setLower(BigInteger.valueOf(0));
			symbol_136.setUpper(BigInteger.valueOf(-1));
			
			symbol_136.setImplicit(true);
			symbol_136.setIsResolveProxies(true);
			symbol_136.setOpposite(symbol_55);
			symbol_135.getOwnedAttributes().add(symbol_136);
		}
		{ // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
			symbol_137.setName("isStatic");
			symbol_137.setType(symbol_15);  // pivot!Boolean
			
			symbol_137.setIsResolveProxies(true);
			symbol_135.getOwnedAttributes().add(symbol_137);
		}
		{ // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
			symbol_138.setName("name");
			symbol_138.setType(symbol_240);  // pivot!String
			symbol_138.setLower(BigInteger.valueOf(0));
			
			symbol_138.setIsResolveProxies(true);
			symbol_135.getOwnedAttributes().add(symbol_138);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
			symbol_139.setName("ownedAnnotation");
			symbol_139.setType(symbol_2);  // pivot!Annotation
			symbol_139.setLower(BigInteger.valueOf(0));
			symbol_139.setUpper(BigInteger.valueOf(-1));
			symbol_139.setIsOrdered(true);
			
			symbol_139.setIsComposite(true);
			symbol_139.setIsResolveProxies(true);
			symbol_139.setOpposite(symbol_3);
			symbol_135.getOwnedAttributes().add(symbol_139);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
			symbol_140.setName("ownedRule");
			symbol_140.setType(symbol_52);  // pivot!Constraint
			symbol_140.setLower(BigInteger.valueOf(0));
			symbol_140.setUpper(BigInteger.valueOf(-1));
			
			symbol_140.setIsComposite(true);
			symbol_140.setIsResolveProxies(true);
			symbol_140.setOpposite(symbol_53);
			symbol_135.getOwnedAttributes().add(symbol_140);
		}
		symbol_1.getOwnedTypes().add(symbol_135);
		//
		// pivot.ecore::pivot::Namespace pivot!Namespace
		//
		symbol_141.setName("Namespace");
		//symbol_141.setMoniker("pivot!Namespace");
		symbol_141.getSuperClasses().add(symbol_135); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_141);
		//
		// pivot.ecore::pivot::NavigationCallExp pivot!NavigationCallExp
		//
		symbol_142.setName("NavigationCallExp");
		//symbol_142.setMoniker("pivot!NavigationCallExp");
		symbol_142.getSuperClasses().add(symbol_87); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
			symbol_143.setName("navigationSource");
			symbol_143.setType(symbol_204);  // pivot!Property
			symbol_143.setLower(BigInteger.valueOf(0));
			symbol_143.setIsOrdered(true);
			
			symbol_143.setIsResolveProxies(true);
			symbol_143.setOpposite(symbol_205);
			symbol_142.getOwnedAttributes().add(symbol_143);
		}
		{ // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
			symbol_144.setName("qualifier");
			symbol_144.setType(symbol_148);  // pivot!OclExpression
			symbol_144.setLower(BigInteger.valueOf(0));
			symbol_144.setUpper(BigInteger.valueOf(-1));
			symbol_144.setIsOrdered(true);
			
			symbol_144.setIsResolveProxies(true);
			symbol_144.setOpposite(symbol_157);
			symbol_142.getOwnedAttributes().add(symbol_144);
		}
		symbol_1.getOwnedTypes().add(symbol_142);
		//
		// pivot.ecore::pivot::NullLiteralExp pivot!NullLiteralExp
		//
		symbol_145.setName("NullLiteralExp");
		//symbol_145.setMoniker("pivot!NullLiteralExp");
		symbol_145.getSuperClasses().add(symbol_202); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_145);
		//
		// pivot.ecore::pivot::NumericLiteralExp pivot!NumericLiteralExp
		//
		symbol_146.setName("NumericLiteralExp");
		//symbol_146.setMoniker("pivot!NumericLiteralExp");
		symbol_146.getSuperClasses().add(symbol_202); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_146);
		//
		// pivot.ecore::pivot::Object pivot!Object
		//
		symbol_147.setName("Object");
		//symbol_147.setMoniker("pivot!Object");
		symbol_1.getOwnedTypes().add(symbol_147);
		//
		// pivot.ecore::pivot::OclExpression pivot!OclExpression
		//
		symbol_148.setName("OclExpression");
		//symbol_148.setMoniker("pivot!OclExpression");
		symbol_148.getSuperClasses().add(symbol_295); // pivot!TypedElement
		{ // pivot.ecore::pivot::OclExpression::CallExp pivot!OclExpression!CallExp
			symbol_149.setName("CallExp");
			symbol_149.setType(symbol_18);  // pivot!CallExp
			symbol_149.setLower(BigInteger.valueOf(0));
			
			symbol_149.setImplicit(true);
			symbol_149.setIsResolveProxies(true);
			symbol_149.setOpposite(symbol_20);
			symbol_148.getOwnedAttributes().add(symbol_149);
		}
		{ // pivot.ecore::pivot::OclExpression::CollectionItem pivot!OclExpression!CollectionItem
			symbol_150.setName("CollectionItem");
			symbol_150.setType(symbol_35);  // pivot!CollectionItem
			symbol_150.setLower(BigInteger.valueOf(0));
			
			symbol_150.setImplicit(true);
			symbol_150.setIsResolveProxies(true);
			symbol_150.setOpposite(symbol_36);
			symbol_148.getOwnedAttributes().add(symbol_150);
		}
		{ // pivot.ecore::pivot::OclExpression::CollectionRange pivot!OclExpression!CollectionRange
			symbol_151.setName("CollectionRange");
			symbol_151.setType(symbol_43);  // pivot!CollectionRange
			symbol_151.setLower(BigInteger.valueOf(0));
			symbol_151.setUpper(BigInteger.valueOf(-1));
			
			symbol_151.setImplicit(true);
			symbol_151.setIsResolveProxies(true);
			symbol_148.getOwnedAttributes().add(symbol_151);
		}
		{ // pivot.ecore::pivot::OclExpression::ExpressionInOcl pivot!OclExpression!ExpressionInOcl
			symbol_152.setName("ExpressionInOcl");
			symbol_152.setType(symbol_78);  // pivot!ExpressionInOcl
			symbol_152.setLower(BigInteger.valueOf(0));
			symbol_152.setUpper(BigInteger.valueOf(-1));
			
			symbol_152.setImplicit(true);
			symbol_152.setIsResolveProxies(true);
			symbol_148.getOwnedAttributes().add(symbol_152);
		}
		{ // pivot.ecore::pivot::OclExpression::IfExp pivot!OclExpression!IfExp
			symbol_153.setName("IfExp");
			symbol_153.setType(symbol_89);  // pivot!IfExp
			symbol_153.setLower(BigInteger.valueOf(0));
			symbol_153.setUpper(BigInteger.valueOf(-1));
			
			symbol_153.setImplicit(true);
			symbol_153.setIsResolveProxies(true);
			symbol_148.getOwnedAttributes().add(symbol_153);
		}
		{ // pivot.ecore::pivot::OclExpression::LetExp pivot!OclExpression!LetExp
			symbol_154.setName("LetExp");
			symbol_154.setType(symbol_110);  // pivot!LetExp
			symbol_154.setLower(BigInteger.valueOf(0));
			
			symbol_154.setImplicit(true);
			symbol_154.setIsResolveProxies(true);
			symbol_154.setOpposite(symbol_111);
			symbol_148.getOwnedAttributes().add(symbol_154);
		}
		{ // pivot.ecore::pivot::OclExpression::LoopExp pivot!OclExpression!LoopExp
			symbol_155.setName("LoopExp");
			symbol_155.setType(symbol_115);  // pivot!LoopExp
			symbol_155.setLower(BigInteger.valueOf(0));
			
			symbol_155.setImplicit(true);
			symbol_155.setIsResolveProxies(true);
			symbol_155.setOpposite(symbol_116);
			symbol_148.getOwnedAttributes().add(symbol_155);
		}
		{ // pivot.ecore::pivot::OclExpression::MessageExp pivot!OclExpression!MessageExp
			symbol_156.setName("MessageExp");
			symbol_156.setType(symbol_119);  // pivot!MessageExp
			symbol_156.setLower(BigInteger.valueOf(0));
			symbol_156.setUpper(BigInteger.valueOf(-1));
			
			symbol_156.setImplicit(true);
			symbol_156.setIsResolveProxies(true);
			symbol_148.getOwnedAttributes().add(symbol_156);
		}
		{ // pivot.ecore::pivot::OclExpression::NavigationCallExp pivot!OclExpression!NavigationCallExp
			symbol_157.setName("NavigationCallExp");
			symbol_157.setType(symbol_142);  // pivot!NavigationCallExp
			symbol_157.setLower(BigInteger.valueOf(0));
			symbol_157.setUpper(BigInteger.valueOf(-1));
			
			symbol_157.setImplicit(true);
			symbol_157.setIsResolveProxies(true);
			symbol_157.setOpposite(symbol_144);
			symbol_148.getOwnedAttributes().add(symbol_157);
		}
		{ // pivot.ecore::pivot::OclExpression::OperationCallExp pivot!OclExpression!OperationCallExp
			symbol_158.setName("OperationCallExp");
			symbol_158.setType(symbol_174);  // pivot!OperationCallExp
			symbol_158.setLower(BigInteger.valueOf(0));
			
			symbol_158.setImplicit(true);
			symbol_158.setIsResolveProxies(true);
			symbol_158.setOpposite(symbol_175);
			symbol_148.getOwnedAttributes().add(symbol_158);
		}
		{ // pivot.ecore::pivot::OclExpression::TupleLiteralPart pivot!OclExpression!TupleLiteralPart
			symbol_159.setName("TupleLiteralPart");
			symbol_159.setType(symbol_274);  // pivot!TupleLiteralPart
			symbol_159.setLower(BigInteger.valueOf(0));
			
			symbol_159.setImplicit(true);
			symbol_159.setIsResolveProxies(true);
			symbol_159.setOpposite(symbol_276);
			symbol_148.getOwnedAttributes().add(symbol_159);
		}
		{ // pivot.ecore::pivot::OclExpression::Variable pivot!OclExpression!Variable
			symbol_160.setName("Variable");
			symbol_160.setType(symbol_307);  // pivot!Variable
			symbol_160.setLower(BigInteger.valueOf(0));
			
			symbol_160.setImplicit(true);
			symbol_160.setIsResolveProxies(true);
			symbol_160.setOpposite(symbol_313);
			symbol_148.getOwnedAttributes().add(symbol_160);
		}
		symbol_1.getOwnedTypes().add(symbol_148);
		//
		// pivot.ecore::pivot::OpaqueExpression pivot!OpaqueExpression
		//
		symbol_161.setName("OpaqueExpression");
		//symbol_161.setMoniker("pivot!OpaqueExpression");
		symbol_161.getSuperClasses().add(symbol_305); // pivot!ValueSpecification
		{ // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
			symbol_162.setName("body");
			symbol_162.setType(symbol_240);  // pivot!String
			symbol_162.setLower(BigInteger.valueOf(0));
			symbol_162.setUpper(BigInteger.valueOf(-1));
			symbol_162.setIsOrdered(true);
			symbol_162.setIsUnique(false);
			
			symbol_162.setIsResolveProxies(true);
			symbol_161.getOwnedAttributes().add(symbol_162);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
			symbol_163.setName("language");
			symbol_163.setType(symbol_240);  // pivot!String
			symbol_163.setLower(BigInteger.valueOf(0));
			symbol_163.setUpper(BigInteger.valueOf(-1));
			symbol_163.setIsOrdered(true);
			
			symbol_163.setIsResolveProxies(true);
			symbol_161.getOwnedAttributes().add(symbol_163);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
			symbol_164.setName("message");
			symbol_164.setType(symbol_240);  // pivot!String
			symbol_164.setLower(BigInteger.valueOf(0));
			symbol_164.setUpper(BigInteger.valueOf(-1));
			symbol_164.setIsOrdered(true);
			symbol_164.setIsUnique(false);
			
			symbol_164.setIsResolveProxies(true);
			symbol_161.getOwnedAttributes().add(symbol_164);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
			symbol_165.setName("valueExpression");
			symbol_165.setType(symbol_78);  // pivot!ExpressionInOcl
			symbol_165.setLower(BigInteger.valueOf(0));
			
			symbol_165.setIsResolveProxies(true);
			symbol_165.setIsTransient(true);
			symbol_161.getOwnedAttributes().add(symbol_165);
		}
		symbol_1.getOwnedTypes().add(symbol_161);
		//
		// pivot.ecore::pivot::Operation pivot!Operation
		//
		symbol_166.setName("Operation");
		//symbol_166.setMoniker("pivot!Operation");
		symbol_166.getSuperClasses().add(symbol_141); // pivot!Namespace
		symbol_166.getSuperClasses().add(symbol_191); // pivot!ParameterableElement
		symbol_166.getSuperClasses().add(symbol_84); // pivot!Feature
		symbol_166.getSuperClasses().add(symbol_267); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Operation::CallOperationAction pivot!Operation!CallOperationAction
			symbol_167.setName("CallOperationAction");
			symbol_167.setType(symbol_21);  // pivot!CallOperationAction
			symbol_167.setLower(BigInteger.valueOf(0));
			symbol_167.setUpper(BigInteger.valueOf(-1));
			
			symbol_167.setImplicit(true);
			symbol_167.setIsResolveProxies(true);
			symbol_167.setOpposite(symbol_23);
			symbol_166.getOwnedAttributes().add(symbol_167);
		}
		{ // pivot.ecore::pivot::Operation::MessageType pivot!Operation!MessageType
			symbol_168.setName("MessageType");
			symbol_168.setType(symbol_124);  // pivot!MessageType
			symbol_168.setLower(BigInteger.valueOf(0));
			symbol_168.setUpper(BigInteger.valueOf(-1));
			
			symbol_168.setImplicit(true);
			symbol_168.setIsResolveProxies(true);
			symbol_168.setOpposite(symbol_125);
			symbol_166.getOwnedAttributes().add(symbol_168);
		}
		{ // pivot.ecore::pivot::Operation::OperationCallExp pivot!Operation!OperationCallExp
			symbol_169.setName("OperationCallExp");
			symbol_169.setType(symbol_174);  // pivot!OperationCallExp
			symbol_169.setLower(BigInteger.valueOf(0));
			symbol_169.setUpper(BigInteger.valueOf(-1));
			
			symbol_169.setImplicit(true);
			symbol_169.setIsResolveProxies(true);
			symbol_169.setOpposite(symbol_176);
			symbol_166.getOwnedAttributes().add(symbol_169);
		}
		{ // pivot.ecore::pivot::Operation::class pivot!Operation!class
			symbol_170.setName("class");
			symbol_170.setType(symbol_25);  // pivot!Class
			symbol_170.setLower(BigInteger.valueOf(0));
			
			symbol_170.setIsResolveProxies(true);
			symbol_170.setOpposite(symbol_30);
			symbol_166.getOwnedAttributes().add(symbol_170);
		}
		{ // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
			symbol_171.setName("ownedParameter");
			symbol_171.setType(symbol_187);  // pivot!Parameter
			symbol_171.setLower(BigInteger.valueOf(0));
			symbol_171.setUpper(BigInteger.valueOf(-1));
			symbol_171.setIsOrdered(true);
			
			symbol_171.setIsComposite(true);
			symbol_171.setIsResolveProxies(true);
			symbol_171.setOpposite(symbol_190);
			symbol_166.getOwnedAttributes().add(symbol_171);
		}
		{ // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
			symbol_172.setName("precedence");
			symbol_172.setType(symbol_197);  // pivot!Precedence
			symbol_172.setLower(BigInteger.valueOf(0));
			
			symbol_172.setIsResolveProxies(true);
			symbol_172.setOpposite(symbol_198);
			symbol_166.getOwnedAttributes().add(symbol_172);
		}
		{ // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
			symbol_173.setName("raisedException");
			symbol_173.setType(symbol_278);  // pivot!Type
			symbol_173.setLower(BigInteger.valueOf(0));
			symbol_173.setUpper(BigInteger.valueOf(-1));
			
			symbol_173.setIsResolveProxies(true);
			symbol_173.setOpposite(symbol_283);
			symbol_166.getOwnedAttributes().add(symbol_173);
		}
		symbol_1.getOwnedTypes().add(symbol_166);
		//
		// pivot.ecore::pivot::OperationCallExp pivot!OperationCallExp
		//
		symbol_174.setName("OperationCallExp");
		//symbol_174.setMoniker("pivot!OperationCallExp");
		symbol_174.getSuperClasses().add(symbol_87); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
			symbol_175.setName("argument");
			symbol_175.setType(symbol_148);  // pivot!OclExpression
			symbol_175.setLower(BigInteger.valueOf(0));
			symbol_175.setUpper(BigInteger.valueOf(-1));
			symbol_175.setIsOrdered(true);
			
			symbol_175.setIsComposite(true);
			symbol_175.setIsResolveProxies(true);
			symbol_175.setOpposite(symbol_158);
			symbol_174.getOwnedAttributes().add(symbol_175);
		}
		{ // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
			symbol_176.setName("referredOperation");
			symbol_176.setType(symbol_166);  // pivot!Operation
			symbol_176.setLower(BigInteger.valueOf(0));
			
			symbol_176.setIsResolveProxies(true);
			symbol_176.setOpposite(symbol_169);
			symbol_174.getOwnedAttributes().add(symbol_176);
		}
		symbol_1.getOwnedTypes().add(symbol_174);
		//
		// pivot.ecore::pivot::OperationTemplateParameter pivot!OperationTemplateParameter
		//
		symbol_177.setName("OperationTemplateParameter");
		//symbol_177.setMoniker("pivot!OperationTemplateParameter");
		symbol_177.getSuperClasses().add(symbol_247); // pivot!TemplateParameter
		symbol_1.getOwnedTypes().add(symbol_177);
		//
		// pivot.ecore::pivot::OrderedSetType pivot!OrderedSetType
		//
		symbol_178.setName("OrderedSetType");
		//symbol_178.setMoniker("pivot!OrderedSetType");
		symbol_178.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_178);
		//
		// pivot.ecore::pivot::Package pivot!Package
		//
		symbol_179.setName("Package");
		//symbol_179.setMoniker("pivot!Package");
		symbol_179.getSuperClasses().add(symbol_141); // pivot!Namespace
		symbol_179.getSuperClasses().add(symbol_267); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
			symbol_180.setName("nestedPackage");
			symbol_180.setType(symbol_179);  // pivot!Package
			symbol_180.setLower(BigInteger.valueOf(0));
			symbol_180.setUpper(BigInteger.valueOf(-1));
			
			symbol_180.setIsComposite(true);
			symbol_180.setIsResolveProxies(true);
			symbol_180.setOpposite(symbol_181);
			symbol_179.getOwnedAttributes().add(symbol_180);
		}
		{ // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
			symbol_181.setName("nestingPackage");
			symbol_181.setType(symbol_179);  // pivot!Package
			symbol_181.setLower(BigInteger.valueOf(0));
			
			symbol_181.setIsResolveProxies(true);
			symbol_181.setOpposite(symbol_180);
			symbol_179.getOwnedAttributes().add(symbol_181);
		}
		{ // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
			symbol_182.setName("nsPrefix");
			symbol_182.setType(symbol_240);  // pivot!String
			symbol_182.setLower(BigInteger.valueOf(0));
			
			symbol_182.setIsResolveProxies(true);
			symbol_179.getOwnedAttributes().add(symbol_182);
		}
		{ // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
			symbol_183.setName("nsURI");
			symbol_183.setType(symbol_240);  // pivot!String
			symbol_183.setLower(BigInteger.valueOf(0));
			
			symbol_183.setIsResolveProxies(true);
			symbol_179.getOwnedAttributes().add(symbol_183);
		}
		{ // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
			symbol_184.setName("ownedPrecedence");
			symbol_184.setType(symbol_197);  // pivot!Precedence
			symbol_184.setLower(BigInteger.valueOf(0));
			symbol_184.setUpper(BigInteger.valueOf(-1));
			symbol_184.setIsOrdered(true);
			
			symbol_184.setIsComposite(true);
			symbol_184.setIsResolveProxies(true);
			symbol_184.setOpposite(symbol_199);
			symbol_179.getOwnedAttributes().add(symbol_184);
		}
		{ // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
			symbol_185.setName("ownedType");
			symbol_185.setType(symbol_278);  // pivot!Type
			symbol_185.setLower(BigInteger.valueOf(0));
			symbol_185.setUpper(BigInteger.valueOf(-1));
			
			symbol_185.setIsComposite(true);
			symbol_185.setIsResolveProxies(true);
			symbol_185.setOpposite(symbol_289);
			symbol_179.getOwnedAttributes().add(symbol_185);
		}
		symbol_1.getOwnedTypes().add(symbol_179);
		//
		// pivot.ecore::pivot::PackageableElement pivot!PackageableElement
		//
		symbol_186.setName("PackageableElement");
		//symbol_186.setMoniker("pivot!PackageableElement");
		symbol_186.getSuperClasses().add(symbol_191); // pivot!ParameterableElement
		symbol_1.getOwnedTypes().add(symbol_186);
		//
		// pivot.ecore::pivot::Parameter pivot!Parameter
		//
		symbol_187.setName("Parameter");
		//symbol_187.setMoniker("pivot!Parameter");
		symbol_187.getSuperClasses().add(symbol_297); // pivot!TypedMultiplicityElement
		symbol_187.getSuperClasses().add(symbol_315); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Parameter::Iteration pivot!Parameter!Iteration
			symbol_188.setName("Iteration");
			symbol_188.setType(symbol_101);  // pivot!Iteration
			symbol_188.setLower(BigInteger.valueOf(0));
			symbol_188.setUpper(BigInteger.valueOf(-1));
			
			symbol_188.setImplicit(true);
			symbol_188.setIsResolveProxies(true);
			symbol_187.getOwnedAttributes().add(symbol_188);
		}
		{ // pivot.ecore::pivot::Parameter::Variable pivot!Parameter!Variable
			symbol_189.setName("Variable");
			symbol_189.setType(symbol_307);  // pivot!Variable
			symbol_189.setLower(BigInteger.valueOf(0));
			symbol_189.setUpper(BigInteger.valueOf(-1));
			
			symbol_189.setImplicit(true);
			symbol_189.setIsResolveProxies(true);
			symbol_189.setOpposite(symbol_314);
			symbol_187.getOwnedAttributes().add(symbol_189);
		}
		{ // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
			symbol_190.setName("operation");
			symbol_190.setType(symbol_166);  // pivot!Operation
			symbol_190.setLower(BigInteger.valueOf(0));
			
			symbol_190.setIsResolveProxies(true);
			symbol_190.setOpposite(symbol_171);
			symbol_187.getOwnedAttributes().add(symbol_190);
		}
		symbol_1.getOwnedTypes().add(symbol_187);
		//
		// pivot.ecore::pivot::ParameterableElement pivot!ParameterableElement
		//
		symbol_191.setName("ParameterableElement");
		//symbol_191.setMoniker("pivot!ParameterableElement");
		symbol_191.getSuperClasses().add(symbol_127); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::ParameterableElement::TemplateParameter pivot!ParameterableElement!TemplateParameter
			symbol_192.setName("TemplateParameter");
			symbol_192.setType(symbol_247);  // pivot!TemplateParameter
			symbol_192.setLower(BigInteger.valueOf(0));
			symbol_192.setUpper(BigInteger.valueOf(-1));
			
			symbol_192.setImplicit(true);
			symbol_192.setIsResolveProxies(true);
			symbol_191.getOwnedAttributes().add(symbol_192);
		}
		{ // pivot.ecore::pivot::ParameterableElement::TemplateParameterSubstitution pivot!ParameterableElement!TemplateParameterSubstitution
			symbol_193.setName("TemplateParameterSubstitution");
			symbol_193.setType(symbol_255);  // pivot!TemplateParameterSubstitution
			symbol_193.setLower(BigInteger.valueOf(0));
			symbol_193.setUpper(BigInteger.valueOf(-1));
			
			symbol_193.setImplicit(true);
			symbol_193.setIsResolveProxies(true);
			symbol_191.getOwnedAttributes().add(symbol_193);
		}
		{ // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
			symbol_194.setName("owningTemplateParameter");
			symbol_194.setType(symbol_247);  // pivot!TemplateParameter
			symbol_194.setLower(BigInteger.valueOf(0));
			
			symbol_194.setIsResolveProxies(true);
			symbol_194.setOpposite(symbol_252);
			symbol_191.getOwnedAttributes().add(symbol_194);
		}
		{ // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
			symbol_195.setName("templateParameter");
			symbol_195.setType(symbol_247);  // pivot!TemplateParameter
			symbol_195.setLower(BigInteger.valueOf(0));
			
			symbol_195.setIsResolveProxies(true);
			symbol_195.setOpposite(symbol_253);
			symbol_191.getOwnedAttributes().add(symbol_195);
		}
		{	// pivot.ecore::pivot::ParameterableElement::isTemplateParameter() pivot!ParameterableElement!isTemplateParameter()
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_343.setName("isTemplateParameter");
			//symbol_343.setMoniker("pivot!ParameterableElement!isTemplateParameter()");
			symbol_343.setType(symbol_15);  // pivot!Boolean
			
			symbol_191.getOwnedOperations().add(symbol_343);
		}
		symbol_1.getOwnedTypes().add(symbol_191);
		//
		// pivot.ecore::pivot::Pivotable pivot!Pivotable
		//
		symbol_196.setName("Pivotable");
		//symbol_196.setMoniker("pivot!Pivotable");
		symbol_1.getOwnedTypes().add(symbol_196);
		//
		// pivot.ecore::pivot::Precedence pivot!Precedence
		//
		symbol_197.setName("Precedence");
		//symbol_197.setMoniker("pivot!Precedence");
		symbol_197.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::Precedence::Operation pivot!Precedence!Operation
			symbol_198.setName("Operation");
			symbol_198.setType(symbol_166);  // pivot!Operation
			symbol_198.setLower(BigInteger.valueOf(0));
			symbol_198.setUpper(BigInteger.valueOf(-1));
			
			symbol_198.setImplicit(true);
			symbol_198.setIsResolveProxies(true);
			symbol_198.setOpposite(symbol_172);
			symbol_197.getOwnedAttributes().add(symbol_198);
		}
		{ // pivot.ecore::pivot::Precedence::Package pivot!Precedence!Package
			symbol_199.setName("Package");
			symbol_199.setType(symbol_179);  // pivot!Package
			symbol_199.setLower(BigInteger.valueOf(0));
			
			symbol_199.setImplicit(true);
			symbol_199.setIsResolveProxies(true);
			symbol_199.setOpposite(symbol_184);
			symbol_197.getOwnedAttributes().add(symbol_199);
		}
		{ // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
			symbol_200.setName("associativity");
			symbol_200.setType(symbol_13);  // pivot!AssociativityKind
			symbol_200.setLower(BigInteger.valueOf(0));
			
			symbol_200.setIsResolveProxies(true);
			symbol_197.getOwnedAttributes().add(symbol_200);
		}
		{ // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
			symbol_201.setName("order");
			symbol_201.setType(symbol_94);  // pivot!Integer
			
			symbol_201.setIsDerived(true);
			symbol_201.setIsResolveProxies(true);
			symbol_201.setIsVolatile(true);
			symbol_197.getOwnedAttributes().add(symbol_201);
		}
		symbol_1.getOwnedTypes().add(symbol_197);
		//
		// pivot.ecore::pivot::PrimitiveLiteralExp pivot!PrimitiveLiteralExp
		//
		symbol_202.setName("PrimitiveLiteralExp");
		//symbol_202.setMoniker("pivot!PrimitiveLiteralExp");
		symbol_202.getSuperClasses().add(symbol_114); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_202);
		//
		// pivot.ecore::pivot::PrimitiveType pivot!PrimitiveType
		//
		symbol_203.setName("PrimitiveType");
		//symbol_203.setMoniker("pivot!PrimitiveType");
		symbol_203.getSuperClasses().add(symbol_59); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_203);
		//
		// pivot.ecore::pivot::Property pivot!Property
		//
		symbol_204.setName("Property");
		//symbol_204.setMoniker("pivot!Property");
		symbol_204.getSuperClasses().add(symbol_191); // pivot!ParameterableElement
		symbol_204.getSuperClasses().add(symbol_84); // pivot!Feature
		{ // pivot.ecore::pivot::Property::NavigationCallExp pivot!Property!NavigationCallExp
			symbol_205.setName("NavigationCallExp");
			symbol_205.setType(symbol_142);  // pivot!NavigationCallExp
			symbol_205.setLower(BigInteger.valueOf(0));
			symbol_205.setUpper(BigInteger.valueOf(-1));
			
			symbol_205.setImplicit(true);
			symbol_205.setIsResolveProxies(true);
			symbol_205.setOpposite(symbol_143);
			symbol_204.getOwnedAttributes().add(symbol_205);
		}
		{ // pivot.ecore::pivot::Property::Property pivot!Property!Property
			symbol_206.setName("Property");
			symbol_206.setType(symbol_204);  // pivot!Property
			symbol_206.setLower(BigInteger.valueOf(0));
			symbol_206.setUpper(BigInteger.valueOf(-1));
			
			symbol_206.setImplicit(true);
			symbol_206.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_206);
		}
		{ // pivot.ecore::pivot::Property::PropertyCallExp pivot!Property!PropertyCallExp
			symbol_207.setName("PropertyCallExp");
			symbol_207.setType(symbol_222);  // pivot!PropertyCallExp
			symbol_207.setLower(BigInteger.valueOf(0));
			symbol_207.setUpper(BigInteger.valueOf(-1));
			
			symbol_207.setImplicit(true);
			symbol_207.setIsResolveProxies(true);
			symbol_207.setOpposite(symbol_223);
			symbol_204.getOwnedAttributes().add(symbol_207);
		}
		{ // pivot.ecore::pivot::Property::association pivot!Property!association
			symbol_208.setName("association");
			symbol_208.setType(symbol_8);  // pivot!AssociationClass
			symbol_208.setLower(BigInteger.valueOf(0));
			
			symbol_208.setIsResolveProxies(true);
			symbol_208.setOpposite(symbol_10);
			symbol_204.getOwnedAttributes().add(symbol_208);
		}
		{ // pivot.ecore::pivot::Property::class pivot!Property!class
			symbol_209.setName("class");
			symbol_209.setType(symbol_25);  // pivot!Class
			symbol_209.setLower(BigInteger.valueOf(0));
			
			symbol_209.setIsResolveProxies(true);
			symbol_209.setOpposite(symbol_29);
			symbol_204.getOwnedAttributes().add(symbol_209);
		}
		{ // pivot.ecore::pivot::Property::default pivot!Property!default
			symbol_210.setName("default");
			symbol_210.setType(symbol_240);  // pivot!String
			symbol_210.setLower(BigInteger.valueOf(0));
			
			symbol_210.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_210);
		}
		{ // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
			symbol_211.setName("implicit");
			symbol_211.setType(symbol_15);  // pivot!Boolean
			symbol_211.setLower(BigInteger.valueOf(0));
			
			symbol_211.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_211);
		}
		{ // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
			symbol_212.setName("isComposite");
			symbol_212.setType(symbol_15);  // pivot!Boolean
			
			symbol_212.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_212);
		}
		{ // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
			symbol_213.setName("isDerived");
			symbol_213.setType(symbol_15);  // pivot!Boolean
			
			symbol_213.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_213);
		}
		{ // pivot.ecore::pivot::Property::isID pivot!Property!isID
			symbol_214.setName("isID");
			symbol_214.setType(symbol_15);  // pivot!Boolean
			
			symbol_214.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_214);
		}
		{ // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
			symbol_215.setName("isReadOnly");
			symbol_215.setType(symbol_15);  // pivot!Boolean
			
			symbol_215.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_215);
		}
		{ // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
			symbol_216.setName("isResolveProxies");
			symbol_216.setType(symbol_15);  // pivot!Boolean
			
			symbol_216.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_216);
		}
		{ // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
			symbol_217.setName("isTransient");
			symbol_217.setType(symbol_15);  // pivot!Boolean
			
			symbol_217.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_217);
		}
		{ // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
			symbol_218.setName("isUnsettable");
			symbol_218.setType(symbol_15);  // pivot!Boolean
			
			symbol_218.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_218);
		}
		{ // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
			symbol_219.setName("isVolatile");
			symbol_219.setType(symbol_15);  // pivot!Boolean
			
			symbol_219.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_219);
		}
		{ // pivot.ecore::pivot::Property::keys pivot!Property!keys
			symbol_220.setName("keys");
			symbol_220.setType(symbol_204);  // pivot!Property
			symbol_220.setLower(BigInteger.valueOf(0));
			symbol_220.setUpper(BigInteger.valueOf(-1));
			
			symbol_220.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_220);
		}
		{ // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
			symbol_221.setName("opposite");
			symbol_221.setType(symbol_204);  // pivot!Property
			symbol_221.setLower(BigInteger.valueOf(0));
			
			symbol_221.setIsResolveProxies(true);
			symbol_221.setOpposite(symbol_206);
			symbol_204.getOwnedAttributes().add(symbol_221);
		}
		symbol_1.getOwnedTypes().add(symbol_204);
		//
		// pivot.ecore::pivot::PropertyCallExp pivot!PropertyCallExp
		//
		symbol_222.setName("PropertyCallExp");
		//symbol_222.setMoniker("pivot!PropertyCallExp");
		symbol_222.getSuperClasses().add(symbol_142); // pivot!NavigationCallExp
		{ // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
			symbol_223.setName("referredProperty");
			symbol_223.setType(symbol_204);  // pivot!Property
			symbol_223.setLower(BigInteger.valueOf(0));
			
			symbol_223.setIsResolveProxies(true);
			symbol_223.setOpposite(symbol_207);
			symbol_222.getOwnedAttributes().add(symbol_223);
		}
		symbol_1.getOwnedTypes().add(symbol_222);
		//
		// pivot.ecore::pivot::RealLiteralExp pivot!RealLiteralExp
		//
		symbol_225.setName("RealLiteralExp");
		//symbol_225.setMoniker("pivot!RealLiteralExp");
		symbol_225.getSuperClasses().add(symbol_146); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
			symbol_226.setName("realSymbol");
			symbol_226.setType(symbol_224);  // pivot!Real
			
			symbol_226.setIsResolveProxies(true);
			symbol_225.getOwnedAttributes().add(symbol_226);
		}
		symbol_1.getOwnedTypes().add(symbol_225);
		//
		// pivot.ecore::pivot::SelfType pivot!SelfType
		//
		symbol_227.setName("SelfType");
		//symbol_227.setMoniker("pivot!SelfType");
		symbol_227.getSuperClasses().add(symbol_25); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_227);
		//
		// pivot.ecore::pivot::SendSignalAction pivot!SendSignalAction
		//
		symbol_228.setName("SendSignalAction");
		//symbol_228.setMoniker("pivot!SendSignalAction");
		symbol_228.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::SendSignalAction::MessageExp pivot!SendSignalAction!MessageExp
			symbol_229.setName("MessageExp");
			symbol_229.setType(symbol_119);  // pivot!MessageExp
			symbol_229.setLower(BigInteger.valueOf(0));
			
			symbol_229.setImplicit(true);
			symbol_229.setIsResolveProxies(true);
			symbol_229.setOpposite(symbol_122);
			symbol_228.getOwnedAttributes().add(symbol_229);
		}
		{ // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
			symbol_230.setName("signal");
			symbol_230.setType(symbol_233);  // pivot!Signal
			
			symbol_230.setIsResolveProxies(true);
			symbol_230.setOpposite(symbol_235);
			symbol_228.getOwnedAttributes().add(symbol_230);
		}
		symbol_1.getOwnedTypes().add(symbol_228);
		//
		// pivot.ecore::pivot::SequenceType pivot!SequenceType
		//
		symbol_231.setName("SequenceType");
		//symbol_231.setMoniker("pivot!SequenceType");
		symbol_231.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_231);
		//
		// pivot.ecore::pivot::SetType pivot!SetType
		//
		symbol_232.setName("SetType");
		//symbol_232.setMoniker("pivot!SetType");
		symbol_232.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_232);
		//
		// pivot.ecore::pivot::Signal pivot!Signal
		//
		symbol_233.setName("Signal");
		//symbol_233.setMoniker("pivot!Signal");
		symbol_233.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::Signal::MessageType pivot!Signal!MessageType
			symbol_234.setName("MessageType");
			symbol_234.setType(symbol_124);  // pivot!MessageType
			symbol_234.setLower(BigInteger.valueOf(0));
			symbol_234.setUpper(BigInteger.valueOf(-1));
			
			symbol_234.setImplicit(true);
			symbol_234.setIsResolveProxies(true);
			symbol_234.setOpposite(symbol_126);
			symbol_233.getOwnedAttributes().add(symbol_234);
		}
		{ // pivot.ecore::pivot::Signal::SendSignalAction pivot!Signal!SendSignalAction
			symbol_235.setName("SendSignalAction");
			symbol_235.setType(symbol_228);  // pivot!SendSignalAction
			symbol_235.setLower(BigInteger.valueOf(0));
			symbol_235.setUpper(BigInteger.valueOf(-1));
			
			symbol_235.setImplicit(true);
			symbol_235.setIsResolveProxies(true);
			symbol_235.setOpposite(symbol_230);
			symbol_233.getOwnedAttributes().add(symbol_235);
		}
		symbol_1.getOwnedTypes().add(symbol_233);
		//
		// pivot.ecore::pivot::State pivot!State
		//
		symbol_236.setName("State");
		//symbol_236.setMoniker("pivot!State");
		symbol_236.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::State::StateExp pivot!State!StateExp
			symbol_237.setName("StateExp");
			symbol_237.setType(symbol_238);  // pivot!StateExp
			symbol_237.setLower(BigInteger.valueOf(0));
			symbol_237.setUpper(BigInteger.valueOf(-1));
			
			symbol_237.setImplicit(true);
			symbol_237.setIsResolveProxies(true);
			symbol_237.setOpposite(symbol_239);
			symbol_236.getOwnedAttributes().add(symbol_237);
		}
		symbol_1.getOwnedTypes().add(symbol_236);
		//
		// pivot.ecore::pivot::StateExp pivot!StateExp
		//
		symbol_238.setName("StateExp");
		//symbol_238.setMoniker("pivot!StateExp");
		symbol_238.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
			symbol_239.setName("referredState");
			symbol_239.setType(symbol_236);  // pivot!State
			symbol_239.setLower(BigInteger.valueOf(0));
			
			symbol_239.setIsResolveProxies(true);
			symbol_239.setOpposite(symbol_237);
			symbol_238.getOwnedAttributes().add(symbol_239);
		}
		symbol_1.getOwnedTypes().add(symbol_238);
		//
		// pivot.ecore::pivot::StringLiteralExp pivot!StringLiteralExp
		//
		symbol_241.setName("StringLiteralExp");
		//symbol_241.setMoniker("pivot!StringLiteralExp");
		symbol_241.getSuperClasses().add(symbol_202); // pivot!PrimitiveLiteralExp
		{ // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
			symbol_242.setName("stringSymbol");
			symbol_242.setType(symbol_240);  // pivot!String
			
			symbol_242.setIsResolveProxies(true);
			symbol_241.getOwnedAttributes().add(symbol_242);
		}
		symbol_1.getOwnedTypes().add(symbol_241);
		//
		// pivot.ecore::pivot::TemplateBinding pivot!TemplateBinding
		//
		symbol_243.setName("TemplateBinding");
		//symbol_243.setMoniker("pivot!TemplateBinding");
		symbol_243.getSuperClasses().add(symbol_65); // pivot!Element
		{ // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
			symbol_244.setName("boundElement");
			symbol_244.setType(symbol_267);  // pivot!TemplateableElement
			
			symbol_244.setIsResolveProxies(true);
			symbol_244.setOpposite(symbol_269);
			symbol_243.getOwnedAttributes().add(symbol_244);
		}
		{ // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
			symbol_245.setName("parameterSubstitution");
			symbol_245.setType(symbol_255);  // pivot!TemplateParameterSubstitution
			symbol_245.setLower(BigInteger.valueOf(0));
			symbol_245.setUpper(BigInteger.valueOf(-1));
			
			symbol_245.setIsComposite(true);
			symbol_245.setIsResolveProxies(true);
			symbol_245.setOpposite(symbol_259);
			symbol_243.getOwnedAttributes().add(symbol_245);
		}
		{ // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
			symbol_246.setName("signature");
			symbol_246.setType(symbol_262);  // pivot!TemplateSignature
			
			symbol_246.setIsResolveProxies(true);
			symbol_246.setOpposite(symbol_263);
			symbol_243.getOwnedAttributes().add(symbol_246);
		}
		symbol_1.getOwnedTypes().add(symbol_243);
		//
		// pivot.ecore::pivot::TemplateParameter pivot!TemplateParameter
		//
		symbol_247.setName("TemplateParameter");
		//symbol_247.setMoniker("pivot!TemplateParameter");
		symbol_247.getSuperClasses().add(symbol_65); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameter::TemplateParameterSubstitution pivot!TemplateParameter!TemplateParameterSubstitution
			symbol_248.setName("TemplateParameterSubstitution");
			symbol_248.setType(symbol_255);  // pivot!TemplateParameterSubstitution
			symbol_248.setLower(BigInteger.valueOf(0));
			symbol_248.setUpper(BigInteger.valueOf(-1));
			
			symbol_248.setImplicit(true);
			symbol_248.setIsResolveProxies(true);
			symbol_248.setOpposite(symbol_257);
			symbol_247.getOwnedAttributes().add(symbol_248);
		}
		{ // pivot.ecore::pivot::TemplateParameter::TemplateSignature pivot!TemplateParameter!TemplateSignature
			symbol_249.setName("TemplateSignature");
			symbol_249.setType(symbol_262);  // pivot!TemplateSignature
			symbol_249.setLower(BigInteger.valueOf(0));
			symbol_249.setUpper(BigInteger.valueOf(-1));
			
			symbol_249.setImplicit(true);
			symbol_249.setIsResolveProxies(true);
			symbol_249.setOpposite(symbol_265);
			symbol_247.getOwnedAttributes().add(symbol_249);
		}
		{ // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
			symbol_250.setName("default");
			symbol_250.setType(symbol_191);  // pivot!ParameterableElement
			symbol_250.setLower(BigInteger.valueOf(0));
			
			symbol_250.setIsResolveProxies(true);
			symbol_247.getOwnedAttributes().add(symbol_250);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
			symbol_251.setName("ownedDefault");
			symbol_251.setType(symbol_191);  // pivot!ParameterableElement
			symbol_251.setLower(BigInteger.valueOf(0));
			
			symbol_251.setIsComposite(true);
			symbol_251.setIsResolveProxies(true);
			symbol_251.setOpposite(symbol_192);
			symbol_247.getOwnedAttributes().add(symbol_251);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
			symbol_252.setName("ownedParameteredElement");
			symbol_252.setType(symbol_191);  // pivot!ParameterableElement
			symbol_252.setLower(BigInteger.valueOf(0));
			
			symbol_252.setIsComposite(true);
			symbol_252.setIsResolveProxies(true);
			symbol_252.setOpposite(symbol_194);
			symbol_247.getOwnedAttributes().add(symbol_252);
		}
		{ // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
			symbol_253.setName("parameteredElement");
			symbol_253.setType(symbol_191);  // pivot!ParameterableElement
			
			symbol_253.setIsResolveProxies(true);
			symbol_253.setOpposite(symbol_195);
			symbol_247.getOwnedAttributes().add(symbol_253);
		}
		{ // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
			symbol_254.setName("signature");
			symbol_254.setType(symbol_262);  // pivot!TemplateSignature
			
			symbol_254.setIsResolveProxies(true);
			symbol_254.setOpposite(symbol_264);
			symbol_247.getOwnedAttributes().add(symbol_254);
		}
		symbol_1.getOwnedTypes().add(symbol_247);
		//
		// pivot.ecore::pivot::TemplateParameterSubstitution pivot!TemplateParameterSubstitution
		//
		symbol_255.setName("TemplateParameterSubstitution");
		//symbol_255.setMoniker("pivot!TemplateParameterSubstitution");
		symbol_255.getSuperClasses().add(symbol_65); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
			symbol_256.setName("actual");
			symbol_256.setType(symbol_191);  // pivot!ParameterableElement
			
			symbol_256.setIsResolveProxies(true);
			symbol_256.setOpposite(symbol_193);
			symbol_255.getOwnedAttributes().add(symbol_256);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
			symbol_257.setName("formal");
			symbol_257.setType(symbol_247);  // pivot!TemplateParameter
			
			symbol_257.setIsResolveProxies(true);
			symbol_257.setOpposite(symbol_248);
			symbol_255.getOwnedAttributes().add(symbol_257);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
			symbol_258.setName("ownedActual");
			symbol_258.setType(symbol_191);  // pivot!ParameterableElement
			symbol_258.setLower(BigInteger.valueOf(0));
			
			symbol_258.setIsComposite(true);
			symbol_258.setIsResolveProxies(true);
			symbol_255.getOwnedAttributes().add(symbol_258);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
			symbol_259.setName("templateBinding");
			symbol_259.setType(symbol_243);  // pivot!TemplateBinding
			
			symbol_259.setIsResolveProxies(true);
			symbol_259.setOpposite(symbol_245);
			symbol_255.getOwnedAttributes().add(symbol_259);
		}
		symbol_1.getOwnedTypes().add(symbol_255);
		//
		// pivot.ecore::pivot::TemplateParameterType pivot!TemplateParameterType
		//
		symbol_260.setName("TemplateParameterType");
		//symbol_260.setMoniker("pivot!TemplateParameterType");
		symbol_260.getSuperClasses().add(symbol_278); // pivot!Type
		{ // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
			symbol_261.setName("specification");
			symbol_261.setType(symbol_240);  // pivot!String
			symbol_261.setLower(BigInteger.valueOf(0));
			
			symbol_261.setIsResolveProxies(true);
			symbol_260.getOwnedAttributes().add(symbol_261);
		}
		symbol_1.getOwnedTypes().add(symbol_260);
		//
		// pivot.ecore::pivot::TemplateSignature pivot!TemplateSignature
		//
		symbol_262.setName("TemplateSignature");
		//symbol_262.setMoniker("pivot!TemplateSignature");
		symbol_262.getSuperClasses().add(symbol_127); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateSignature::TemplateBinding pivot!TemplateSignature!TemplateBinding
			symbol_263.setName("TemplateBinding");
			symbol_263.setType(symbol_243);  // pivot!TemplateBinding
			symbol_263.setLower(BigInteger.valueOf(0));
			symbol_263.setUpper(BigInteger.valueOf(-1));
			
			symbol_263.setImplicit(true);
			symbol_263.setIsResolveProxies(true);
			symbol_263.setOpposite(symbol_246);
			symbol_262.getOwnedAttributes().add(symbol_263);
		}
		{ // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
			symbol_264.setName("ownedParameter");
			symbol_264.setType(symbol_247);  // pivot!TemplateParameter
			symbol_264.setLower(BigInteger.valueOf(0));
			symbol_264.setUpper(BigInteger.valueOf(-1));
			symbol_264.setIsOrdered(true);
			
			symbol_264.setIsComposite(true);
			symbol_264.setIsResolveProxies(true);
			symbol_264.setOpposite(symbol_254);
			symbol_262.getOwnedAttributes().add(symbol_264);
		}
		{ // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
			symbol_265.setName("parameter");
			symbol_265.setType(symbol_247);  // pivot!TemplateParameter
			symbol_265.setUpper(BigInteger.valueOf(-1));
			symbol_265.setIsOrdered(true);
			
			symbol_265.setIsResolveProxies(true);
			symbol_265.setOpposite(symbol_249);
			symbol_262.getOwnedAttributes().add(symbol_265);
		}
		{ // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
			symbol_266.setName("template");
			symbol_266.setType(symbol_267);  // pivot!TemplateableElement
			
			symbol_266.setIsResolveProxies(true);
			symbol_266.setOpposite(symbol_268);
			symbol_262.getOwnedAttributes().add(symbol_266);
		}
		symbol_1.getOwnedTypes().add(symbol_262);
		//
		// pivot.ecore::pivot::TemplateableElement pivot!TemplateableElement
		//
		symbol_267.setName("TemplateableElement");
		//symbol_267.setMoniker("pivot!TemplateableElement");
		symbol_267.getSuperClasses().add(symbol_127); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
			symbol_268.setName("ownedTemplateSignature");
			symbol_268.setType(symbol_262);  // pivot!TemplateSignature
			symbol_268.setLower(BigInteger.valueOf(0));
			
			symbol_268.setIsComposite(true);
			symbol_268.setIsResolveProxies(true);
			symbol_268.setOpposite(symbol_266);
			symbol_267.getOwnedAttributes().add(symbol_268);
		}
		{ // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
			symbol_269.setName("templateBinding");
			symbol_269.setType(symbol_243);  // pivot!TemplateBinding
			symbol_269.setLower(BigInteger.valueOf(0));
			symbol_269.setUpper(BigInteger.valueOf(-1));
			
			symbol_269.setIsComposite(true);
			symbol_269.setIsResolveProxies(true);
			symbol_269.setOpposite(symbol_244);
			symbol_267.getOwnedAttributes().add(symbol_269);
		}
		{ // pivot.ecore::pivot::TemplateableElement::unspecializedElement pivot!TemplateableElement!unspecializedElement
			symbol_270.setName("unspecializedElement");
			symbol_270.setType(symbol_267);  // pivot!TemplateableElement
			symbol_270.setLower(BigInteger.valueOf(0));
			
			symbol_270.setIsTransient(true);
			symbol_267.getOwnedAttributes().add(symbol_270);
		}
		{	// pivot.ecore::pivot::TemplateableElement::isTemplate() pivot!TemplateableElement!isTemplate()
			Operation symbol_344 = PivotFactory.eINSTANCE.createOperation();
			symbol_344.setName("isTemplate");
			//symbol_344.setMoniker("pivot!TemplateableElement!isTemplate()");
			symbol_344.setType(symbol_15);  // pivot!Boolean
			
			symbol_267.getOwnedOperations().add(symbol_344);
		}
		{	// pivot.ecore::pivot::TemplateableElement::parameterableElements() pivot!TemplateableElement!parameterableElements()
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_345.setName("parameterableElements");
			//symbol_345.setMoniker("pivot!TemplateableElement!parameterableElements()");
			symbol_345.setType(symbol_191);  // pivot!ParameterableElement
			symbol_345.setLower(BigInteger.valueOf(0));
			symbol_345.setUpper(BigInteger.valueOf(-1));
			
			symbol_267.getOwnedOperations().add(symbol_345);
		}
		symbol_1.getOwnedTypes().add(symbol_267);
		//
		// pivot.ecore::pivot::Throwable pivot!Throwable
		//
		symbol_271.setName("Throwable");
		//symbol_271.setMoniker("pivot!Throwable");
		symbol_1.getOwnedTypes().add(symbol_271);
		//
		// pivot.ecore::pivot::TupleLiteralExp pivot!TupleLiteralExp
		//
		symbol_272.setName("TupleLiteralExp");
		//symbol_272.setMoniker("pivot!TupleLiteralExp");
		symbol_272.getSuperClasses().add(symbol_114); // pivot!LiteralExp
		{ // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
			symbol_273.setName("part");
			symbol_273.setType(symbol_274);  // pivot!TupleLiteralPart
			symbol_273.setLower(BigInteger.valueOf(0));
			symbol_273.setUpper(BigInteger.valueOf(-1));
			symbol_273.setIsOrdered(true);
			
			symbol_273.setIsComposite(true);
			symbol_273.setIsResolveProxies(true);
			symbol_273.setOpposite(symbol_275);
			symbol_272.getOwnedAttributes().add(symbol_273);
		}
		symbol_1.getOwnedTypes().add(symbol_272);
		//
		// pivot.ecore::pivot::TupleLiteralPart pivot!TupleLiteralPart
		//
		symbol_274.setName("TupleLiteralPart");
		//symbol_274.setMoniker("pivot!TupleLiteralPart");
		symbol_274.getSuperClasses().add(symbol_315); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::TupleLiteralPart::TupleLiteralExp pivot!TupleLiteralPart!TupleLiteralExp
			symbol_275.setName("TupleLiteralExp");
			symbol_275.setType(symbol_272);  // pivot!TupleLiteralExp
			symbol_275.setLower(BigInteger.valueOf(0));
			
			symbol_275.setImplicit(true);
			symbol_275.setIsResolveProxies(true);
			symbol_275.setOpposite(symbol_273);
			symbol_274.getOwnedAttributes().add(symbol_275);
		}
		{ // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
			symbol_276.setName("initExpression");
			symbol_276.setType(symbol_148);  // pivot!OclExpression
			symbol_276.setLower(BigInteger.valueOf(0));
			
			symbol_276.setIsComposite(true);
			symbol_276.setIsResolveProxies(true);
			symbol_276.setOpposite(symbol_159);
			symbol_274.getOwnedAttributes().add(symbol_276);
		}
		symbol_1.getOwnedTypes().add(symbol_274);
		//
		// pivot.ecore::pivot::TupleType pivot!TupleType
		//
		symbol_277.setName("TupleType");
		//symbol_277.setMoniker("pivot!TupleType");
		symbol_277.getSuperClasses().add(symbol_59); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_277);
		//
		// pivot.ecore::pivot::Type pivot!Type
		//
		symbol_278.setName("Type");
		//symbol_278.setMoniker("pivot!Type");
		symbol_278.getSuperClasses().add(symbol_191); // pivot!ParameterableElement
		symbol_278.getSuperClasses().add(symbol_267); // pivot!TemplateableElement
		symbol_278.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::Type::ClassifierType pivot!Type!ClassifierType
			symbol_279.setName("ClassifierType");
			symbol_279.setType(symbol_33);  // pivot!ClassifierType
			symbol_279.setLower(BigInteger.valueOf(0));
			symbol_279.setUpper(BigInteger.valueOf(-1));
			
			symbol_279.setImplicit(true);
			symbol_279.setIsResolveProxies(true);
			symbol_279.setOpposite(symbol_34);
			symbol_278.getOwnedAttributes().add(symbol_279);
		}
		{ // pivot.ecore::pivot::Type::CollectionType pivot!Type!CollectionType
			symbol_280.setName("CollectionType");
			symbol_280.setType(symbol_46);  // pivot!CollectionType
			symbol_280.setLower(BigInteger.valueOf(0));
			symbol_280.setUpper(BigInteger.valueOf(-1));
			
			symbol_280.setImplicit(true);
			symbol_280.setIsResolveProxies(true);
			symbol_280.setOpposite(symbol_47);
			symbol_278.getOwnedAttributes().add(symbol_280);
		}
		{ // pivot.ecore::pivot::Type::DataType pivot!Type!DataType
			symbol_281.setName("DataType");
			symbol_281.setType(symbol_59);  // pivot!DataType
			symbol_281.setLower(BigInteger.valueOf(0));
			symbol_281.setUpper(BigInteger.valueOf(-1));
			
			symbol_281.setImplicit(true);
			symbol_281.setIsResolveProxies(true);
			symbol_281.setOpposite(symbol_60);
			symbol_278.getOwnedAttributes().add(symbol_281);
		}
		{ // pivot.ecore::pivot::Type::LambdaType pivot!Type!LambdaType
			symbol_282.setName("LambdaType");
			symbol_282.setType(symbol_106);  // pivot!LambdaType
			symbol_282.setLower(BigInteger.valueOf(0));
			symbol_282.setUpper(BigInteger.valueOf(-1));
			
			symbol_282.setImplicit(true);
			symbol_282.setIsResolveProxies(true);
			symbol_278.getOwnedAttributes().add(symbol_282);
		}
		{ // pivot.ecore::pivot::Type::Operation pivot!Type!Operation
			symbol_283.setName("Operation");
			symbol_283.setType(symbol_166);  // pivot!Operation
			symbol_283.setLower(BigInteger.valueOf(0));
			symbol_283.setUpper(BigInteger.valueOf(-1));
			
			symbol_283.setImplicit(true);
			symbol_283.setIsResolveProxies(true);
			symbol_283.setOpposite(symbol_173);
			symbol_278.getOwnedAttributes().add(symbol_283);
		}
		{ // pivot.ecore::pivot::Type::TypeExp pivot!Type!TypeExp
			symbol_284.setName("TypeExp");
			symbol_284.setType(symbol_290);  // pivot!TypeExp
			symbol_284.setLower(BigInteger.valueOf(0));
			symbol_284.setUpper(BigInteger.valueOf(-1));
			
			symbol_284.setImplicit(true);
			symbol_284.setIsResolveProxies(true);
			symbol_284.setOpposite(symbol_291);
			symbol_278.getOwnedAttributes().add(symbol_284);
		}
		{ // pivot.ecore::pivot::Type::TypeTemplateParameter pivot!Type!TypeTemplateParameter
			symbol_285.setName("TypeTemplateParameter");
			symbol_285.setType(symbol_292);  // pivot!TypeTemplateParameter
			symbol_285.setLower(BigInteger.valueOf(0));
			symbol_285.setUpper(BigInteger.valueOf(-1));
			
			symbol_285.setImplicit(true);
			symbol_285.setIsResolveProxies(true);
			symbol_285.setOpposite(symbol_294);
			symbol_278.getOwnedAttributes().add(symbol_285);
		}
		{ // pivot.ecore::pivot::Type::TypedElement pivot!Type!TypedElement
			symbol_286.setName("TypedElement");
			symbol_286.setType(symbol_295);  // pivot!TypedElement
			symbol_286.setLower(BigInteger.valueOf(0));
			symbol_286.setUpper(BigInteger.valueOf(-1));
			
			symbol_286.setImplicit(true);
			symbol_286.setIsResolveProxies(true);
			symbol_286.setOpposite(symbol_296);
			symbol_278.getOwnedAttributes().add(symbol_286);
		}
		{ // pivot.ecore::pivot::Type::UnspecifiedType pivot!Type!UnspecifiedType
			symbol_287.setName("UnspecifiedType");
			symbol_287.setType(symbol_301);  // pivot!UnspecifiedType
			symbol_287.setLower(BigInteger.valueOf(0));
			symbol_287.setUpper(BigInteger.valueOf(-1));
			
			symbol_287.setImplicit(true);
			symbol_287.setIsResolveProxies(true);
			symbol_278.getOwnedAttributes().add(symbol_287);
		}
		{ // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
			symbol_288.setName("instanceClassName");
			symbol_288.setType(symbol_240);  // pivot!String
			symbol_288.setLower(BigInteger.valueOf(0));
			
			symbol_288.setIsResolveProxies(true);
			symbol_278.getOwnedAttributes().add(symbol_288);
		}
		{ // pivot.ecore::pivot::Type::package pivot!Type!package
			symbol_289.setName("package");
			symbol_289.setType(symbol_179);  // pivot!Package
			symbol_289.setLower(BigInteger.valueOf(0));
			
			symbol_289.setIsResolveProxies(true);
			symbol_289.setOpposite(symbol_185);
			symbol_278.getOwnedAttributes().add(symbol_289);
		}
		symbol_1.getOwnedTypes().add(symbol_278);
		//
		// pivot.ecore::pivot::TypeExp pivot!TypeExp
		//
		symbol_290.setName("TypeExp");
		//symbol_290.setMoniker("pivot!TypeExp");
		symbol_290.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
			symbol_291.setName("referredType");
			symbol_291.setType(symbol_278);  // pivot!Type
			symbol_291.setLower(BigInteger.valueOf(0));
			
			symbol_291.setIsResolveProxies(true);
			symbol_291.setOpposite(symbol_284);
			symbol_290.getOwnedAttributes().add(symbol_291);
		}
		symbol_1.getOwnedTypes().add(symbol_290);
		//
		// pivot.ecore::pivot::TypeTemplateParameter pivot!TypeTemplateParameter
		//
		symbol_292.setName("TypeTemplateParameter");
		//symbol_292.setMoniker("pivot!TypeTemplateParameter");
		symbol_292.getSuperClasses().add(symbol_247); // pivot!TemplateParameter
		{ // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
			symbol_293.setName("allowSubstitutable");
			symbol_293.setType(symbol_15);  // pivot!Boolean
			
			symbol_293.setIsResolveProxies(true);
			symbol_292.getOwnedAttributes().add(symbol_293);
		}
		{ // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
			symbol_294.setName("constrainingType");
			symbol_294.setType(symbol_278);  // pivot!Type
			symbol_294.setLower(BigInteger.valueOf(0));
			symbol_294.setUpper(BigInteger.valueOf(-1));
			
			symbol_294.setIsResolveProxies(true);
			symbol_294.setOpposite(symbol_285);
			symbol_292.getOwnedAttributes().add(symbol_294);
		}
		symbol_1.getOwnedTypes().add(symbol_292);
		//
		// pivot.ecore::pivot::TypedElement pivot!TypedElement
		//
		symbol_295.setName("TypedElement");
		//symbol_295.setMoniker("pivot!TypedElement");
		symbol_295.getSuperClasses().add(symbol_135); // pivot!NamedElement
		{ // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
			symbol_296.setName("type");
			symbol_296.setType(symbol_278);  // pivot!Type
			symbol_296.setLower(BigInteger.valueOf(0));
			
			symbol_296.setIsResolveProxies(true);
			symbol_296.setOpposite(symbol_286);
			symbol_295.getOwnedAttributes().add(symbol_296);
		}
		symbol_1.getOwnedTypes().add(symbol_295);
		//
		// pivot.ecore::pivot::TypedMultiplicityElement pivot!TypedMultiplicityElement
		//
		symbol_297.setName("TypedMultiplicityElement");
		//symbol_297.setMoniker("pivot!TypedMultiplicityElement");
		symbol_297.getSuperClasses().add(symbol_295); // pivot!TypedElement
		symbol_297.getSuperClasses().add(symbol_129); // pivot!MultiplicityElement
		symbol_1.getOwnedTypes().add(symbol_297);
		//
		// pivot.ecore::pivot::UnlimitedNaturalLiteralExp pivot!UnlimitedNaturalLiteralExp
		//
		symbol_299.setName("UnlimitedNaturalLiteralExp");
		//symbol_299.setMoniker("pivot!UnlimitedNaturalLiteralExp");
		symbol_299.getSuperClasses().add(symbol_146); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
			symbol_300.setName("unlimitedNaturalSymbol");
			symbol_300.setType(symbol_298);  // pivot!UnlimitedNatural
			
			symbol_300.setIsResolveProxies(true);
			symbol_299.getOwnedAttributes().add(symbol_300);
		}
		symbol_1.getOwnedTypes().add(symbol_299);
		//
		// pivot.ecore::pivot::UnspecifiedType pivot!UnspecifiedType
		//
		symbol_301.setName("UnspecifiedType");
		//symbol_301.setMoniker("pivot!UnspecifiedType");
		symbol_301.getSuperClasses().add(symbol_25); // pivot!Class
		{ // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
			symbol_302.setName("lowerBound");
			symbol_302.setType(symbol_278);  // pivot!Type
			
			symbol_302.setIsResolveProxies(true);
			symbol_301.getOwnedAttributes().add(symbol_302);
		}
		{ // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
			symbol_303.setName("upperBound");
			symbol_303.setType(symbol_278);  // pivot!Type
			
			symbol_303.setIsResolveProxies(true);
			symbol_303.setOpposite(symbol_287);
			symbol_301.getOwnedAttributes().add(symbol_303);
		}
		symbol_1.getOwnedTypes().add(symbol_301);
		//
		// pivot.ecore::pivot::UnspecifiedValueExp pivot!UnspecifiedValueExp
		//
		symbol_304.setName("UnspecifiedValueExp");
		//symbol_304.setMoniker("pivot!UnspecifiedValueExp");
		symbol_304.getSuperClasses().add(symbol_148); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_304);
		//
		// pivot.ecore::pivot::ValueSpecification pivot!ValueSpecification
		//
		symbol_305.setName("ValueSpecification");
		//symbol_305.setMoniker("pivot!ValueSpecification");
		symbol_305.getSuperClasses().add(symbol_191); // pivot!ParameterableElement
		symbol_305.getSuperClasses().add(symbol_295); // pivot!TypedElement
		{ // pivot.ecore::pivot::ValueSpecification::Constraint pivot!ValueSpecification!Constraint
			symbol_306.setName("Constraint");
			symbol_306.setType(symbol_52);  // pivot!Constraint
			symbol_306.setLower(BigInteger.valueOf(0));
			
			symbol_306.setImplicit(true);
			symbol_306.setIsResolveProxies(true);
			symbol_306.setOpposite(symbol_57);
			symbol_305.getOwnedAttributes().add(symbol_306);
		}
		{	// pivot.ecore::pivot::ValueSpecification::booleanValue() pivot!ValueSpecification!booleanValue()
			Operation symbol_346 = PivotFactory.eINSTANCE.createOperation();
			symbol_346.setName("booleanValue");
			//symbol_346.setMoniker("pivot!ValueSpecification!booleanValue()");
			symbol_346.setType(symbol_15);  // pivot!Boolean
			
			symbol_305.getOwnedOperations().add(symbol_346);
		}
		{	// pivot.ecore::pivot::ValueSpecification::integerValue() pivot!ValueSpecification!integerValue()
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("integerValue");
			//symbol_347.setMoniker("pivot!ValueSpecification!integerValue()");
			symbol_347.setType(symbol_94);  // pivot!Integer
			
			symbol_305.getOwnedOperations().add(symbol_347);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isComputable() pivot!ValueSpecification!isComputable()
			Operation symbol_348 = PivotFactory.eINSTANCE.createOperation();
			symbol_348.setName("isComputable");
			//symbol_348.setMoniker("pivot!ValueSpecification!isComputable()");
			symbol_348.setType(symbol_15);  // pivot!Boolean
			
			symbol_305.getOwnedOperations().add(symbol_348);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isNull() pivot!ValueSpecification!isNull()
			Operation symbol_349 = PivotFactory.eINSTANCE.createOperation();
			symbol_349.setName("isNull");
			//symbol_349.setMoniker("pivot!ValueSpecification!isNull()");
			symbol_349.setType(symbol_15);  // pivot!Boolean
			
			symbol_305.getOwnedOperations().add(symbol_349);
		}
		{	// pivot.ecore::pivot::ValueSpecification::stringValue() pivot!ValueSpecification!stringValue()
			Operation symbol_350 = PivotFactory.eINSTANCE.createOperation();
			symbol_350.setName("stringValue");
			//symbol_350.setMoniker("pivot!ValueSpecification!stringValue()");
			symbol_350.setType(symbol_240);  // pivot!String
			
			symbol_305.getOwnedOperations().add(symbol_350);
		}
		{	// pivot.ecore::pivot::ValueSpecification::unlimitedValue() pivot!ValueSpecification!unlimitedValue()
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_351.setName("unlimitedValue");
			//symbol_351.setMoniker("pivot!ValueSpecification!unlimitedValue()");
			symbol_351.setType(symbol_298);  // pivot!UnlimitedNatural
			
			symbol_305.getOwnedOperations().add(symbol_351);
		}
		symbol_1.getOwnedTypes().add(symbol_305);
		//
		// pivot.ecore::pivot::Variable pivot!Variable
		//
		symbol_307.setName("Variable");
		//symbol_307.setMoniker("pivot!Variable");
		symbol_307.getSuperClasses().add(symbol_315); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Variable::ExpressionInOcl pivot!Variable!ExpressionInOcl
			symbol_308.setName("ExpressionInOcl");
			symbol_308.setType(symbol_78);  // pivot!ExpressionInOcl
			symbol_308.setLower(BigInteger.valueOf(0));
			symbol_308.setUpper(BigInteger.valueOf(-1));
			
			symbol_308.setImplicit(true);
			symbol_308.setIsResolveProxies(true);
			symbol_307.getOwnedAttributes().add(symbol_308);
		}
		{ // pivot.ecore::pivot::Variable::IterateExp pivot!Variable!IterateExp
			symbol_309.setName("IterateExp");
			symbol_309.setType(symbol_99);  // pivot!IterateExp
			symbol_309.setLower(BigInteger.valueOf(0));
			
			symbol_309.setImplicit(true);
			symbol_309.setIsResolveProxies(true);
			symbol_309.setOpposite(symbol_100);
			symbol_307.getOwnedAttributes().add(symbol_309);
		}
		{ // pivot.ecore::pivot::Variable::LetExp pivot!Variable!LetExp
			symbol_310.setName("LetExp");
			symbol_310.setType(symbol_110);  // pivot!LetExp
			symbol_310.setLower(BigInteger.valueOf(0));
			
			symbol_310.setImplicit(true);
			symbol_310.setIsResolveProxies(true);
			symbol_310.setOpposite(symbol_112);
			symbol_307.getOwnedAttributes().add(symbol_310);
		}
		{ // pivot.ecore::pivot::Variable::LoopExp pivot!Variable!LoopExp
			symbol_311.setName("LoopExp");
			symbol_311.setType(symbol_115);  // pivot!LoopExp
			symbol_311.setLower(BigInteger.valueOf(0));
			
			symbol_311.setImplicit(true);
			symbol_311.setIsResolveProxies(true);
			symbol_311.setOpposite(symbol_117);
			symbol_307.getOwnedAttributes().add(symbol_311);
		}
		{ // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
			symbol_312.setName("implicit");
			symbol_312.setType(symbol_15);  // pivot!Boolean
			symbol_312.setLower(BigInteger.valueOf(0));
			
			symbol_312.setIsResolveProxies(true);
			symbol_307.getOwnedAttributes().add(symbol_312);
		}
		{ // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
			symbol_313.setName("initExpression");
			symbol_313.setType(symbol_148);  // pivot!OclExpression
			symbol_313.setLower(BigInteger.valueOf(0));
			
			symbol_313.setIsComposite(true);
			symbol_313.setIsResolveProxies(true);
			symbol_313.setOpposite(symbol_160);
			symbol_307.getOwnedAttributes().add(symbol_313);
		}
		{ // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
			symbol_314.setName("representedParameter");
			symbol_314.setType(symbol_187);  // pivot!Parameter
			symbol_314.setLower(BigInteger.valueOf(0));
			
			symbol_314.setIsResolveProxies(true);
			symbol_314.setOpposite(symbol_189);
			symbol_307.getOwnedAttributes().add(symbol_314);
		}
		symbol_1.getOwnedTypes().add(symbol_307);
		//
		// pivot.ecore::pivot::VariableDeclaration pivot!VariableDeclaration
		//
		symbol_315.setName("VariableDeclaration");
		//symbol_315.setMoniker("pivot!VariableDeclaration");
		symbol_315.getSuperClasses().add(symbol_295); // pivot!TypedElement
		{ // pivot.ecore::pivot::VariableDeclaration::VariableExp pivot!VariableDeclaration!VariableExp
			symbol_316.setName("VariableExp");
			symbol_316.setType(symbol_317);  // pivot!VariableExp
			symbol_316.setLower(BigInteger.valueOf(0));
			symbol_316.setUpper(BigInteger.valueOf(-1));
			
			symbol_316.setImplicit(true);
			symbol_316.setIsResolveProxies(true);
			symbol_316.setOpposite(symbol_319);
			symbol_315.getOwnedAttributes().add(symbol_316);
		}
		symbol_1.getOwnedTypes().add(symbol_315);
		//
		// pivot.ecore::pivot::VariableExp pivot!VariableExp
		//
		symbol_317.setName("VariableExp");
		//symbol_317.setMoniker("pivot!VariableExp");
		symbol_317.getSuperClasses().add(symbol_148); // pivot!OclExpression
		{ // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
			symbol_318.setName("implicit");
			symbol_318.setType(symbol_15);  // pivot!Boolean
			symbol_318.setLower(BigInteger.valueOf(0));
			
			symbol_318.setIsResolveProxies(true);
			symbol_317.getOwnedAttributes().add(symbol_318);
		}
		{ // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
			symbol_319.setName("referredVariable");
			symbol_319.setType(symbol_315);  // pivot!VariableDeclaration
			symbol_319.setLower(BigInteger.valueOf(0));
			
			symbol_319.setIsResolveProxies(true);
			symbol_319.setOpposite(symbol_316);
			symbol_317.getOwnedAttributes().add(symbol_319);
		}
		symbol_1.getOwnedTypes().add(symbol_317);
		//
		// pivot.ecore::pivot::Visitable pivot!Visitable
		//
		symbol_320.setName("Visitable");
		//symbol_320.setMoniker("pivot!Visitable");
		symbol_1.getOwnedTypes().add(symbol_320);
		//
		// pivot.ecore::pivot::Visitor pivot!Visitor{R,C}
		//
		symbol_321.setName("Visitor");
		//symbol_321.setMoniker("pivot!Visitor{R,C}");
		symbol_324.setName("R");
		symbol_323.setOwnedParameteredElement(symbol_324);
		symbol_322.getOwnedParameters().add(symbol_323);
		symbol_326.setName("C");
		symbol_325.setOwnedParameteredElement(symbol_326);
		symbol_322.getOwnedParameters().add(symbol_325);
		
		symbol_321.setOwnedTemplateSignature(symbol_322);
		symbol_1.getOwnedTypes().add(symbol_321);
		//
		// pivot.ecore::pivot::VoidType pivot!VoidType
		//
		symbol_327.setName("VoidType");
		//symbol_327.setMoniker("pivot!VoidType");
		symbol_327.getSuperClasses().add(symbol_25); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_327);

		Class elementClass = (Class) PivotUtil.getNamedElement(symbol_1.getOwnedTypes(), "Element");
		elementClass.getSuperClasses().clear();
		for (Type pivotClass : symbol_1.getOwnedTypes()) {
			if (pivotClass instanceof Enumeration) {
				List<Class> superClasses = ((Enumeration) pivotClass).getSuperClasses();
				if (superClasses.isEmpty()) {
					superClasses.add(standardLibrary.getEnumerationType());
				}
			}
			else if (pivotClass instanceof Class) {
				List<Class> superClasses = ((Class) pivotClass).getSuperClasses();
				if (superClasses.isEmpty()) {
					superClasses.add(standardLibrary.getClassifierType());
				}
			}
		}
		
		return symbol_1;
	}
}
