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
 * $Id: OclMetaModel.java,v 1.7 2011/05/02 15:38:53 ewillink Exp $
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
		Property symbol_56 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
		Property symbol_57 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
		
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // pivot!DataType
		Property symbol_59 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
		Property symbol_60 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
		
		Class symbol_61 = PivotFactory.eINSTANCE.createClass(); // pivot!Detail
		Property symbol_62 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::Annotation pivot!Detail!Annotation
		Property symbol_63 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::value pivot!Detail!value
		
		Class symbol_64 = PivotFactory.eINSTANCE.createClass(); // pivot!Element
		Property symbol_65 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::Annotation pivot!Element!Annotation
		Property symbol_66 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::Comment pivot!Element!Comment
		Property symbol_67 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::Constraint pivot!Element!Constraint
		Property symbol_68 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
		
		Class symbol_69 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumLiteralExp
		Property symbol_70 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
		
		Class symbol_71 = PivotFactory.eINSTANCE.createClass(); // pivot!Enumeration
		Property symbol_72 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
		
		Class symbol_73 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumerationLiteral
		Property symbol_74 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::EnumLiteralExp pivot!EnumerationLiteral!EnumLiteralExp
		Property symbol_75 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
		Property symbol_76 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
		
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // pivot!ExpressionInOcl
		Property symbol_78 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
		Property symbol_79 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
		Property symbol_80 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
		Property symbol_81 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
		Property symbol_82 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // pivot!Feature
		Property symbol_84 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
		Property symbol_85 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
		
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // pivot!FeatureCallExp
		Property symbol_87 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
		
		Class symbol_88 = PivotFactory.eINSTANCE.createClass(); // pivot!IfExp
		Property symbol_89 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
		Property symbol_90 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
		Property symbol_91 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
		
		DataType symbol_92 = PivotFactory.eINSTANCE.createDataType(); // pivot!Int
		
		PrimitiveType symbol_93 = standardLibrary.getIntegerType(); // pivot!Integer
		Class symbol_94 = PivotFactory.eINSTANCE.createClass(); // pivot!IntegerLiteralExp
		Property symbol_95 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
		
		Class symbol_96 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidLiteralExp
		
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidType
		
		Class symbol_98 = PivotFactory.eINSTANCE.createClass(); // pivot!IterateExp
		Property symbol_99 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
		
		Class symbol_100 = PivotFactory.eINSTANCE.createClass(); // pivot!Iteration
		Property symbol_101 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::LoopExp pivot!Iteration!LoopExp
		Property symbol_102 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
		Property symbol_103 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
		
		Class symbol_104 = PivotFactory.eINSTANCE.createClass(); // pivot!IteratorExp
		
		Class symbol_105 = PivotFactory.eINSTANCE.createClass(); // pivot!LambdaType
		Property symbol_106 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
		Property symbol_107 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
		Property symbol_108 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
		
		Class symbol_109 = PivotFactory.eINSTANCE.createClass(); // pivot!LetExp
		Property symbol_110 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
		Property symbol_111 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
		
		Class symbol_112 = PivotFactory.eINSTANCE.createClass(); // pivot!Library
		
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // pivot!LiteralExp
		
		Class symbol_114 = PivotFactory.eINSTANCE.createClass(); // pivot!LoopExp
		Property symbol_115 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
		Property symbol_116 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
		Property symbol_117 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
		
		Class symbol_118 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageExp
		Property symbol_119 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
		Property symbol_120 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
		Property symbol_121 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
		Property symbol_122 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
		
		Class symbol_123 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageType
		Property symbol_124 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
		Property symbol_125 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
		
		Class symbol_126 = PivotFactory.eINSTANCE.createClass(); // pivot!MonikeredElement
		Property symbol_127 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
		
		Class symbol_128 = PivotFactory.eINSTANCE.createClass(); // pivot!MultiplicityElement
		Property symbol_129 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
		Property symbol_130 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
		Property symbol_131 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
		Property symbol_132 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
		
		Class symbol_133 = PivotFactory.eINSTANCE.createClass(); // pivot!Nameable
		
		Class symbol_134 = PivotFactory.eINSTANCE.createClass(); // pivot!NamedElement
		Property symbol_135 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::Constraint pivot!NamedElement!Constraint
		Property symbol_136 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
		Property symbol_137 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
		Property symbol_138 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
		Property symbol_139 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
		
		Class symbol_140 = PivotFactory.eINSTANCE.createClass(); // pivot!Namespace
		
		Class symbol_141 = PivotFactory.eINSTANCE.createClass(); // pivot!NavigationCallExp
		Property symbol_142 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
		Property symbol_143 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
		
		Class symbol_144 = PivotFactory.eINSTANCE.createClass(); // pivot!NullLiteralExp
		
		Class symbol_145 = PivotFactory.eINSTANCE.createClass(); // pivot!NumericLiteralExp
		
		DataType symbol_146 = PivotFactory.eINSTANCE.createDataType(); // pivot!Object
		
		Class symbol_147 = PivotFactory.eINSTANCE.createClass(); // pivot!OclExpression
		Property symbol_148 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::CallExp pivot!OclExpression!CallExp
		Property symbol_149 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::CollectionItem pivot!OclExpression!CollectionItem
		Property symbol_150 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::CollectionRange pivot!OclExpression!CollectionRange
		Property symbol_151 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::ExpressionInOcl pivot!OclExpression!ExpressionInOcl
		Property symbol_152 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::IfExp pivot!OclExpression!IfExp
		Property symbol_153 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::LetExp pivot!OclExpression!LetExp
		Property symbol_154 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::LoopExp pivot!OclExpression!LoopExp
		Property symbol_155 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::MessageExp pivot!OclExpression!MessageExp
		Property symbol_156 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::NavigationCallExp pivot!OclExpression!NavigationCallExp
		Property symbol_157 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::OperationCallExp pivot!OclExpression!OperationCallExp
		Property symbol_158 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::TupleLiteralPart pivot!OclExpression!TupleLiteralPart
		Property symbol_159 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OclExpression::Variable pivot!OclExpression!Variable
		
		Class symbol_160 = PivotFactory.eINSTANCE.createClass(); // pivot!OpaqueExpression
		Property symbol_161 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
		Property symbol_162 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
		Property symbol_163 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
		Property symbol_164 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
		
		Class symbol_165 = PivotFactory.eINSTANCE.createClass(); // pivot!Operation
		Property symbol_166 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::CallOperationAction pivot!Operation!CallOperationAction
		Property symbol_167 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::MessageType pivot!Operation!MessageType
		Property symbol_168 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::OperationCallExp pivot!Operation!OperationCallExp
		Property symbol_169 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::class pivot!Operation!class
		Property symbol_170 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
		Property symbol_171 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
		Property symbol_172 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
		
		Class symbol_173 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationCallExp
		Property symbol_174 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
		Property symbol_175 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
		
		Class symbol_176 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationTemplateParameter
		
		Class symbol_177 = PivotFactory.eINSTANCE.createClass(); // pivot!OrderedSetType
		
		Class symbol_178 = PivotFactory.eINSTANCE.createClass(); // pivot!Package
		Property symbol_179 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
		Property symbol_180 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
		Property symbol_181 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
		Property symbol_182 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
		Property symbol_183 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
		Property symbol_184 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
		
		Class symbol_185 = PivotFactory.eINSTANCE.createClass(); // pivot!PackageableElement
		
		Class symbol_186 = PivotFactory.eINSTANCE.createClass(); // pivot!Parameter
		Property symbol_187 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::Iteration pivot!Parameter!Iteration
		Property symbol_188 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::Variable pivot!Parameter!Variable
		Property symbol_189 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
		
		Class symbol_190 = PivotFactory.eINSTANCE.createClass(); // pivot!ParameterableElement
		Property symbol_191 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::TemplateParameter pivot!ParameterableElement!TemplateParameter
		Property symbol_192 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::TemplateParameterSubstitution pivot!ParameterableElement!TemplateParameterSubstitution
		Property symbol_193 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
		Property symbol_194 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
		
		Class symbol_195 = PivotFactory.eINSTANCE.createClass(); // pivot!Pivotable
		
		Class symbol_196 = PivotFactory.eINSTANCE.createClass(); // pivot!Precedence
		Property symbol_197 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::Operation pivot!Precedence!Operation
		Property symbol_198 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::Package pivot!Precedence!Package
		Property symbol_199 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
		Property symbol_200 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
		
		Class symbol_201 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveLiteralExp
		
		Class symbol_202 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveType
		
		Class symbol_203 = PivotFactory.eINSTANCE.createClass(); // pivot!Property
		Property symbol_204 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::NavigationCallExp pivot!Property!NavigationCallExp
		Property symbol_205 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::Property pivot!Property!Property
		Property symbol_206 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::PropertyCallExp pivot!Property!PropertyCallExp
		Property symbol_207 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::association pivot!Property!association
		Property symbol_208 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::class pivot!Property!class
		Property symbol_209 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::default pivot!Property!default
		Property symbol_210 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
		Property symbol_211 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
		Property symbol_212 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
		Property symbol_213 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isID pivot!Property!isID
		Property symbol_214 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
		Property symbol_215 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
		Property symbol_216 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
		Property symbol_217 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
		Property symbol_218 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
		Property symbol_219 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::keys pivot!Property!keys
		Property symbol_220 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
		
		Class symbol_221 = PivotFactory.eINSTANCE.createClass(); // pivot!PropertyCallExp
		Property symbol_222 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
		
		PrimitiveType symbol_223 = standardLibrary.getRealType(); // pivot!Real
		Class symbol_224 = PivotFactory.eINSTANCE.createClass(); // pivot!RealLiteralExp
		Property symbol_225 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
		
		Class symbol_226 = PivotFactory.eINSTANCE.createClass(); // pivot!SendSignalAction
		Property symbol_227 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::MessageExp pivot!SendSignalAction!MessageExp
		Property symbol_228 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
		
		Class symbol_229 = PivotFactory.eINSTANCE.createClass(); // pivot!SequenceType
		
		Class symbol_230 = PivotFactory.eINSTANCE.createClass(); // pivot!SetType
		
		Class symbol_231 = PivotFactory.eINSTANCE.createClass(); // pivot!Signal
		Property symbol_232 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Signal::MessageType pivot!Signal!MessageType
		Property symbol_233 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Signal::SendSignalAction pivot!Signal!SendSignalAction
		
		Class symbol_234 = PivotFactory.eINSTANCE.createClass(); // pivot!State
		Property symbol_235 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::State::StateExp pivot!State!StateExp
		
		Class symbol_236 = PivotFactory.eINSTANCE.createClass(); // pivot!StateExp
		Property symbol_237 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
		
		PrimitiveType symbol_238 = standardLibrary.getStringType(); // pivot!String
		Class symbol_239 = PivotFactory.eINSTANCE.createClass(); // pivot!StringLiteralExp
		Property symbol_240 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
		
		Class symbol_241 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateBinding
		Property symbol_242 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
		Property symbol_243 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
		Property symbol_244 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
		
		Class symbol_245 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameter
		Property symbol_246 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::TemplateParameterSubstitution pivot!TemplateParameter!TemplateParameterSubstitution
		Property symbol_247 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::TemplateSignature pivot!TemplateParameter!TemplateSignature
		Property symbol_248 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
		Property symbol_249 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
		Property symbol_250 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
		Property symbol_251 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
		Property symbol_252 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
		
		Class symbol_253 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterSubstitution
		Property symbol_254 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
		Property symbol_255 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
		Property symbol_256 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
		Property symbol_257 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
		
		Class symbol_258 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterType
		Property symbol_259 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
		
		Class symbol_260 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateSignature
		Property symbol_261 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::TemplateBinding pivot!TemplateSignature!TemplateBinding
		Property symbol_262 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
		Property symbol_263 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
		Property symbol_264 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
		
		Class symbol_265 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateableElement
		Property symbol_266 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
		Property symbol_267 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
		Property symbol_268 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::unspecializedElement pivot!TemplateableElement!unspecializedElement
		
		DataType symbol_269 = PivotFactory.eINSTANCE.createDataType(); // pivot!Throwable
		
		Class symbol_270 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralExp
		Property symbol_271 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
		
		Class symbol_272 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralPart
		Property symbol_273 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::TupleLiteralExp pivot!TupleLiteralPart!TupleLiteralExp
		Property symbol_274 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
		
		Class symbol_275 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleType
		
		Class symbol_276 = PivotFactory.eINSTANCE.createClass(); // pivot!Type
		Property symbol_277 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::ClassifierType pivot!Type!ClassifierType
		Property symbol_278 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::CollectionType pivot!Type!CollectionType
		Property symbol_279 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::DataType pivot!Type!DataType
		Property symbol_280 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::LambdaType pivot!Type!LambdaType
		Property symbol_281 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::Operation pivot!Type!Operation
		Property symbol_282 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::TypeExp pivot!Type!TypeExp
		Property symbol_283 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::TypeTemplateParameter pivot!Type!TypeTemplateParameter
		Property symbol_284 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::TypedElement pivot!Type!TypedElement
		Property symbol_285 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::UnspecifiedType pivot!Type!UnspecifiedType
		Property symbol_286 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
		Property symbol_287 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::package pivot!Type!package
		
		Class symbol_288 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeExp
		Property symbol_289 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
		
		Class symbol_290 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeTemplateParameter
		Property symbol_291 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
		Property symbol_292 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
		
		Class symbol_293 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedElement
		Property symbol_294 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
		
		Class symbol_295 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedMultiplicityElement
		
		PrimitiveType symbol_296 = standardLibrary.getUnlimitedNaturalType(); // pivot!UnlimitedNatural
		Class symbol_297 = PivotFactory.eINSTANCE.createClass(); // pivot!UnlimitedNaturalLiteralExp
		Property symbol_298 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
		
		Class symbol_299 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedType
		Property symbol_300 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
		Property symbol_301 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
		
		Class symbol_302 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedValueExp
		
		Class symbol_303 = PivotFactory.eINSTANCE.createClass(); // pivot!ValueSpecification
		Property symbol_304 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ValueSpecification::Constraint pivot!ValueSpecification!Constraint
		
		Class symbol_305 = PivotFactory.eINSTANCE.createClass(); // pivot!Variable
		Property symbol_306 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::ExpressionInOcl pivot!Variable!ExpressionInOcl
		Property symbol_307 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::IterateExp pivot!Variable!IterateExp
		Property symbol_308 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::LetExp pivot!Variable!LetExp
		Property symbol_309 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::LoopExp pivot!Variable!LoopExp
		Property symbol_310 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
		Property symbol_311 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
		Property symbol_312 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
		
		Class symbol_313 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableDeclaration
		Property symbol_314 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableDeclaration::VariableExp pivot!VariableDeclaration!VariableExp
		
		Class symbol_315 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableExp
		Property symbol_316 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
		Property symbol_317 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
		
		Class symbol_318 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitable
		
		Class symbol_319 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}
		TemplateSignature symbol_320 = PivotFactory.eINSTANCE.createTemplateSignature(); // pivot!Visitor{R,C}!
		TypeTemplateParameter symbol_321 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_322 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?R
		TypeTemplateParameter symbol_323 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_324 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?C
		
		
		Class symbol_325 = PivotFactory.eINSTANCE.createClass(); // pivot!VoidType
		

		symbol_1.setName("pivot");
		symbol_1.setNsPrefix("pivot");
		symbol_1.setNsURI("http://www.eclipse.org/ocl/3.1.0/Pivot");
		//
		// pivot.ecore::pivot::Annotation pivot!Annotation
		//
		symbol_2.setName("Annotation");
		//symbol_2.setMoniker("pivot!Annotation");
		symbol_2.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::Annotation::NamedElement pivot!Annotation!NamedElement
			symbol_3.setName("NamedElement");
			symbol_3.setType(symbol_134);  // pivot!NamedElement
			symbol_3.setLower(BigInteger.valueOf(0));
			
			symbol_3.setImplicit(true);
			symbol_3.setIsResolveProxies(true);
			symbol_3.setOpposite(symbol_138);
			symbol_2.getOwnedAttributes().add(symbol_3);
		}
		{ // pivot.ecore::pivot::Annotation::ownedContent pivot!Annotation!ownedContent
			symbol_4.setName("ownedContent");
			symbol_4.setType(symbol_64);  // pivot!Element
			symbol_4.setLower(BigInteger.valueOf(0));
			symbol_4.setUpper(BigInteger.valueOf(-1));
			symbol_4.setIsOrdered(true);
			
			symbol_4.setIsComposite(true);
			symbol_4.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_4);
		}
		{ // pivot.ecore::pivot::Annotation::ownedDetail pivot!Annotation!ownedDetail
			symbol_5.setName("ownedDetail");
			symbol_5.setType(symbol_61);  // pivot!Detail
			symbol_5.setLower(BigInteger.valueOf(0));
			symbol_5.setUpper(BigInteger.valueOf(-1));
			symbol_5.setIsOrdered(true);
			
			symbol_5.setIsComposite(true);
			symbol_5.setIsResolveProxies(true);
			symbol_5.setOpposite(symbol_62);
			symbol_2.getOwnedAttributes().add(symbol_5);
		}
		{ // pivot.ecore::pivot::Annotation::reference pivot!Annotation!reference
			symbol_6.setName("reference");
			symbol_6.setType(symbol_64);  // pivot!Element
			symbol_6.setLower(BigInteger.valueOf(0));
			symbol_6.setUpper(BigInteger.valueOf(-1));
			symbol_6.setIsOrdered(true);
			
			symbol_6.setIsResolveProxies(true);
			symbol_6.setOpposite(symbol_65);
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
			symbol_10.setType(symbol_203);  // pivot!Property
			symbol_10.setLower(BigInteger.valueOf(0));
			symbol_10.setUpper(BigInteger.valueOf(-1));
			
			symbol_10.setIsResolveProxies(true);
			symbol_10.setOpposite(symbol_207);
			symbol_8.getOwnedAttributes().add(symbol_10);
		}
		symbol_1.getOwnedTypes().add(symbol_8);
		//
		// pivot.ecore::pivot::AssociationClassCallExp pivot!AssociationClassCallExp
		//
		symbol_11.setName("AssociationClassCallExp");
		//symbol_11.setMoniker("pivot!AssociationClassCallExp");
		symbol_11.getSuperClasses().add(symbol_141); // pivot!NavigationCallExp
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
			EnumerationLiteral symbol_326 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Left pivot!AssociativityKind!Left
			symbol_326.setName("Left");
			symbol_13.getOwnedLiterals().add(symbol_326);
			EnumerationLiteral symbol_327 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Right pivot!AssociativityKind!Right
			symbol_327.setName("Right");
			symbol_13.getOwnedLiterals().add(symbol_327);
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
		symbol_16.getSuperClasses().add(symbol_201); // pivot!PrimitiveLiteralExp
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
		symbol_18.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::CallExp::implicit pivot!CallExp!implicit
			symbol_19.setName("implicit");
			symbol_19.setType(symbol_15);  // pivot!Boolean
			symbol_19.setLower(BigInteger.valueOf(0));
			
			symbol_19.setIsResolveProxies(true);
			symbol_18.getOwnedAttributes().add(symbol_19);
		}
		{ // pivot.ecore::pivot::CallExp::source pivot!CallExp!source
			symbol_20.setName("source");
			symbol_20.setType(symbol_147);  // pivot!OclExpression
			symbol_20.setLower(BigInteger.valueOf(0));
			
			symbol_20.setIsComposite(true);
			symbol_20.setIsResolveProxies(true);
			symbol_20.setOpposite(symbol_148);
			symbol_18.getOwnedAttributes().add(symbol_20);
		}
		symbol_1.getOwnedTypes().add(symbol_18);
		//
		// pivot.ecore::pivot::CallOperationAction pivot!CallOperationAction
		//
		symbol_21.setName("CallOperationAction");
		//symbol_21.setMoniker("pivot!CallOperationAction");
		symbol_21.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::CallOperationAction::MessageExp pivot!CallOperationAction!MessageExp
			symbol_22.setName("MessageExp");
			symbol_22.setType(symbol_118);  // pivot!MessageExp
			symbol_22.setLower(BigInteger.valueOf(0));
			
			symbol_22.setImplicit(true);
			symbol_22.setIsResolveProxies(true);
			symbol_22.setOpposite(symbol_120);
			symbol_21.getOwnedAttributes().add(symbol_22);
		}
		{ // pivot.ecore::pivot::CallOperationAction::operation pivot!CallOperationAction!operation
			symbol_23.setName("operation");
			symbol_23.setType(symbol_165);  // pivot!Operation
			
			symbol_23.setIsResolveProxies(true);
			symbol_23.setOpposite(symbol_166);
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
		symbol_25.getSuperClasses().add(symbol_140); // pivot!Namespace
		symbol_25.getSuperClasses().add(symbol_276); // pivot!Type
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
			symbol_29.setType(symbol_203);  // pivot!Property
			symbol_29.setLower(BigInteger.valueOf(0));
			symbol_29.setUpper(BigInteger.valueOf(-1));
			symbol_29.setIsOrdered(true);
			
			symbol_29.setIsComposite(true);
			symbol_29.setIsResolveProxies(true);
			symbol_29.setOpposite(symbol_208);
			symbol_25.getOwnedAttributes().add(symbol_29);
		}
		{ // pivot.ecore::pivot::Class::ownedOperation pivot!Class!ownedOperation
			symbol_30.setName("ownedOperation");
			symbol_30.setType(symbol_165);  // pivot!Operation
			symbol_30.setLower(BigInteger.valueOf(0));
			symbol_30.setUpper(BigInteger.valueOf(-1));
			symbol_30.setIsOrdered(true);
			
			symbol_30.setIsComposite(true);
			symbol_30.setIsResolveProxies(true);
			symbol_30.setOpposite(symbol_169);
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
		symbol_33.getSuperClasses().add(symbol_58); // pivot!DataType
		{ // pivot.ecore::pivot::ClassifierType::instanceType pivot!ClassifierType!instanceType
			symbol_34.setName("instanceType");
			symbol_34.setType(symbol_276);  // pivot!Type
			
			symbol_34.setIsResolveProxies(true);
			symbol_34.setOpposite(symbol_277);
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
			symbol_36.setType(symbol_147);  // pivot!OclExpression
			
			symbol_36.setIsComposite(true);
			symbol_36.setIsResolveProxies(true);
			symbol_36.setOpposite(symbol_149);
			symbol_35.getOwnedAttributes().add(symbol_36);
		}
		symbol_1.getOwnedTypes().add(symbol_35);
		//
		// pivot.ecore::pivot::CollectionKind pivot!CollectionKind
		//
		symbol_37.setName("CollectionKind");
		//symbol_37.setMoniker("pivot!CollectionKind");
		{
			EnumerationLiteral symbol_328 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Collection pivot!CollectionKind!Collection
			symbol_328.setName("Collection");
			symbol_37.getOwnedLiterals().add(symbol_328);
			EnumerationLiteral symbol_329 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Set pivot!CollectionKind!Set
			symbol_329.setName("Set");
			symbol_37.getOwnedLiterals().add(symbol_329);
			EnumerationLiteral symbol_330 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::OrderedSet pivot!CollectionKind!OrderedSet
			symbol_330.setName("OrderedSet");
			symbol_37.getOwnedLiterals().add(symbol_330);
			EnumerationLiteral symbol_331 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Bag pivot!CollectionKind!Bag
			symbol_331.setName("Bag");
			symbol_37.getOwnedLiterals().add(symbol_331);
			EnumerationLiteral symbol_332 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Sequence pivot!CollectionKind!Sequence
			symbol_332.setName("Sequence");
			symbol_37.getOwnedLiterals().add(symbol_332);
		}
		
		symbol_1.getOwnedTypes().add(symbol_37);
		//
		// pivot.ecore::pivot::CollectionLiteralExp pivot!CollectionLiteralExp
		//
		symbol_38.setName("CollectionLiteralExp");
		//symbol_38.setMoniker("pivot!CollectionLiteralExp");
		symbol_38.getSuperClasses().add(symbol_113); // pivot!LiteralExp
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
		symbol_41.getSuperClasses().add(symbol_293); // pivot!TypedElement
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
			symbol_44.setType(symbol_147);  // pivot!OclExpression
			
			symbol_44.setIsComposite(true);
			symbol_44.setIsResolveProxies(true);
			symbol_43.getOwnedAttributes().add(symbol_44);
		}
		{ // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
			symbol_45.setName("last");
			symbol_45.setType(symbol_147);  // pivot!OclExpression
			
			symbol_45.setIsComposite(true);
			symbol_45.setIsResolveProxies(true);
			symbol_45.setOpposite(symbol_150);
			symbol_43.getOwnedAttributes().add(symbol_45);
		}
		symbol_1.getOwnedTypes().add(symbol_43);
		//
		// pivot.ecore::pivot::CollectionType pivot!CollectionType
		//
		symbol_46.setName("CollectionType");
		//symbol_46.setMoniker("pivot!CollectionType");
		symbol_46.getSuperClasses().add(symbol_58); // pivot!DataType
		{ // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
			symbol_47.setName("elementType");
			symbol_47.setType(symbol_276);  // pivot!Type
			
			symbol_47.setIsResolveProxies(true);
			symbol_47.setOpposite(symbol_278);
			symbol_46.getOwnedAttributes().add(symbol_47);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// pivot.ecore::pivot::Comment pivot!Comment
		//
		symbol_48.setName("Comment");
		//symbol_48.setMoniker("pivot!Comment");
		symbol_48.getSuperClasses().add(symbol_64); // pivot!Element
		{ // pivot.ecore::pivot::Comment::Element pivot!Comment!Element
			symbol_49.setName("Element");
			symbol_49.setType(symbol_64);  // pivot!Element
			symbol_49.setLower(BigInteger.valueOf(0));
			
			symbol_49.setImplicit(true);
			symbol_49.setIsResolveProxies(true);
			symbol_49.setOpposite(symbol_68);
			symbol_48.getOwnedAttributes().add(symbol_49);
		}
		{ // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
			symbol_50.setName("annotatedElement");
			symbol_50.setType(symbol_64);  // pivot!Element
			symbol_50.setLower(BigInteger.valueOf(0));
			symbol_50.setUpper(BigInteger.valueOf(-1));
			
			symbol_50.setIsResolveProxies(true);
			symbol_50.setOpposite(symbol_66);
			symbol_48.getOwnedAttributes().add(symbol_50);
		}
		{ // pivot.ecore::pivot::Comment::body pivot!Comment!body
			symbol_51.setName("body");
			symbol_51.setType(symbol_238);  // pivot!String
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
		symbol_52.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::Constraint::NamedElement pivot!Constraint!NamedElement
			symbol_53.setName("NamedElement");
			symbol_53.setType(symbol_134);  // pivot!NamedElement
			symbol_53.setLower(BigInteger.valueOf(0));
			
			symbol_53.setImplicit(true);
			symbol_53.setIsResolveProxies(true);
			symbol_53.setOpposite(symbol_139);
			symbol_52.getOwnedAttributes().add(symbol_53);
		}
		{ // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
			symbol_54.setName("constrainedElement");
			symbol_54.setType(symbol_64);  // pivot!Element
			symbol_54.setLower(BigInteger.valueOf(0));
			symbol_54.setUpper(BigInteger.valueOf(-1));
			symbol_54.setIsOrdered(true);
			
			symbol_54.setIsResolveProxies(true);
			symbol_54.setOpposite(symbol_67);
			symbol_52.getOwnedAttributes().add(symbol_54);
		}
		{ // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
			symbol_55.setName("context");
			symbol_55.setType(symbol_134);  // pivot!NamedElement
			symbol_55.setLower(BigInteger.valueOf(0));
			
			symbol_55.setIsResolveProxies(true);
			symbol_55.setOpposite(symbol_135);
			symbol_52.getOwnedAttributes().add(symbol_55);
		}
		{ // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
			symbol_56.setName("specification");
			symbol_56.setType(symbol_303);  // pivot!ValueSpecification
			
			symbol_56.setIsComposite(true);
			symbol_56.setIsResolveProxies(true);
			symbol_56.setOpposite(symbol_304);
			symbol_52.getOwnedAttributes().add(symbol_56);
		}
		{ // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
			symbol_57.setName("stereotype");
			symbol_57.setType(symbol_238);  // pivot!String
			symbol_57.setLower(BigInteger.valueOf(0));
			
			symbol_57.setIsResolveProxies(true);
			symbol_52.getOwnedAttributes().add(symbol_57);
		}
		symbol_1.getOwnedTypes().add(symbol_52);
		//
		// pivot.ecore::pivot::DataType pivot!DataType
		//
		symbol_58.setName("DataType");
		//symbol_58.setMoniker("pivot!DataType");
		symbol_58.getSuperClasses().add(symbol_25); // pivot!Class
		{ // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
			symbol_59.setName("behavioralType");
			symbol_59.setType(symbol_276);  // pivot!Type
			symbol_59.setLower(BigInteger.valueOf(0));
			
			symbol_59.setIsResolveProxies(true);
			symbol_59.setOpposite(symbol_279);
			symbol_58.getOwnedAttributes().add(symbol_59);
		}
		{ // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
			symbol_60.setName("isSerializable");
			symbol_60.setType(symbol_15);  // pivot!Boolean
			
			symbol_60.setIsResolveProxies(true);
			symbol_58.getOwnedAttributes().add(symbol_60);
		}
		symbol_1.getOwnedTypes().add(symbol_58);
		//
		// pivot.ecore::pivot::Detail pivot!Detail
		//
		symbol_61.setName("Detail");
		//symbol_61.setMoniker("pivot!Detail");
		symbol_61.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::Detail::Annotation pivot!Detail!Annotation
			symbol_62.setName("Annotation");
			symbol_62.setType(symbol_2);  // pivot!Annotation
			symbol_62.setLower(BigInteger.valueOf(0));
			
			symbol_62.setImplicit(true);
			symbol_62.setIsResolveProxies(true);
			symbol_62.setOpposite(symbol_5);
			symbol_61.getOwnedAttributes().add(symbol_62);
		}
		{ // pivot.ecore::pivot::Detail::value pivot!Detail!value
			symbol_63.setName("value");
			symbol_63.setType(symbol_238);  // pivot!String
			symbol_63.setUpper(BigInteger.valueOf(-1));
			
			symbol_63.setIsResolveProxies(true);
			symbol_61.getOwnedAttributes().add(symbol_63);
		}
		symbol_1.getOwnedTypes().add(symbol_61);
		//
		// pivot.ecore::pivot::Element pivot!Element
		//
		symbol_64.setName("Element");
		//symbol_64.setMoniker("pivot!Element");
		symbol_64.getSuperClasses().add(symbol_318); // pivot!Visitable
		{ // pivot.ecore::pivot::Element::Annotation pivot!Element!Annotation
			symbol_65.setName("Annotation");
			symbol_65.setType(symbol_2);  // pivot!Annotation
			symbol_65.setLower(BigInteger.valueOf(0));
			symbol_65.setUpper(BigInteger.valueOf(-1));
			
			symbol_65.setImplicit(true);
			symbol_65.setIsResolveProxies(true);
			symbol_64.getOwnedAttributes().add(symbol_65);
		}
		{ // pivot.ecore::pivot::Element::Comment pivot!Element!Comment
			symbol_66.setName("Comment");
			symbol_66.setType(symbol_48);  // pivot!Comment
			symbol_66.setLower(BigInteger.valueOf(0));
			symbol_66.setUpper(BigInteger.valueOf(-1));
			
			symbol_66.setImplicit(true);
			symbol_66.setIsResolveProxies(true);
			symbol_66.setOpposite(symbol_50);
			symbol_64.getOwnedAttributes().add(symbol_66);
		}
		{ // pivot.ecore::pivot::Element::Constraint pivot!Element!Constraint
			symbol_67.setName("Constraint");
			symbol_67.setType(symbol_52);  // pivot!Constraint
			symbol_67.setLower(BigInteger.valueOf(0));
			symbol_67.setUpper(BigInteger.valueOf(-1));
			
			symbol_67.setImplicit(true);
			symbol_67.setIsResolveProxies(true);
			symbol_67.setOpposite(symbol_54);
			symbol_64.getOwnedAttributes().add(symbol_67);
		}
		{ // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
			symbol_68.setName("ownedComment");
			symbol_68.setType(symbol_48);  // pivot!Comment
			symbol_68.setLower(BigInteger.valueOf(0));
			symbol_68.setUpper(BigInteger.valueOf(-1));
			
			symbol_68.setIsComposite(true);
			symbol_68.setIsResolveProxies(true);
			symbol_68.setOpposite(symbol_49);
			symbol_64.getOwnedAttributes().add(symbol_68);
		}
		symbol_1.getOwnedTypes().add(symbol_64);
		//
		// pivot.ecore::pivot::EnumLiteralExp pivot!EnumLiteralExp
		//
		symbol_69.setName("EnumLiteralExp");
		//symbol_69.setMoniker("pivot!EnumLiteralExp");
		symbol_69.getSuperClasses().add(symbol_113); // pivot!LiteralExp
		{ // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
			symbol_70.setName("referredEnumLiteral");
			symbol_70.setType(symbol_73);  // pivot!EnumerationLiteral
			symbol_70.setLower(BigInteger.valueOf(0));
			
			symbol_70.setIsResolveProxies(true);
			symbol_70.setOpposite(symbol_74);
			symbol_69.getOwnedAttributes().add(symbol_70);
		}
		symbol_1.getOwnedTypes().add(symbol_69);
		//
		// pivot.ecore::pivot::Enumeration pivot!Enumeration
		//
		symbol_71.setName("Enumeration");
		//symbol_71.setMoniker("pivot!Enumeration");
		symbol_71.getSuperClasses().add(symbol_58); // pivot!DataType
		{ // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
			symbol_72.setName("ownedLiteral");
			symbol_72.setType(symbol_73);  // pivot!EnumerationLiteral
			symbol_72.setLower(BigInteger.valueOf(0));
			symbol_72.setUpper(BigInteger.valueOf(-1));
			symbol_72.setIsOrdered(true);
			
			symbol_72.setIsComposite(true);
			symbol_72.setIsResolveProxies(true);
			symbol_72.setOpposite(symbol_75);
			symbol_71.getOwnedAttributes().add(symbol_72);
		}
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// pivot.ecore::pivot::EnumerationLiteral pivot!EnumerationLiteral
		//
		symbol_73.setName("EnumerationLiteral");
		//symbol_73.setMoniker("pivot!EnumerationLiteral");
		symbol_73.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::EnumerationLiteral::EnumLiteralExp pivot!EnumerationLiteral!EnumLiteralExp
			symbol_74.setName("EnumLiteralExp");
			symbol_74.setType(symbol_69);  // pivot!EnumLiteralExp
			symbol_74.setLower(BigInteger.valueOf(0));
			symbol_74.setUpper(BigInteger.valueOf(-1));
			
			symbol_74.setImplicit(true);
			symbol_74.setIsResolveProxies(true);
			symbol_74.setOpposite(symbol_70);
			symbol_73.getOwnedAttributes().add(symbol_74);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
			symbol_75.setName("enumeration");
			symbol_75.setType(symbol_71);  // pivot!Enumeration
			symbol_75.setLower(BigInteger.valueOf(0));
			
			symbol_75.setIsResolveProxies(true);
			symbol_75.setOpposite(symbol_72);
			symbol_73.getOwnedAttributes().add(symbol_75);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
			symbol_76.setName("value");
			symbol_76.setType(symbol_93);  // pivot!Integer
			symbol_76.setLower(BigInteger.valueOf(0));
			
			symbol_76.setIsResolveProxies(true);
			symbol_73.getOwnedAttributes().add(symbol_76);
		}
		symbol_1.getOwnedTypes().add(symbol_73);
		//
		// pivot.ecore::pivot::ExpressionInOcl pivot!ExpressionInOcl
		//
		symbol_77.setName("ExpressionInOcl");
		//symbol_77.setMoniker("pivot!ExpressionInOcl");
		symbol_77.getSuperClasses().add(symbol_160); // pivot!OpaqueExpression
		{ // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
			symbol_78.setName("bodyExpression");
			symbol_78.setType(symbol_147);  // pivot!OclExpression
			
			symbol_78.setIsComposite(true);
			symbol_78.setIsResolveProxies(true);
			symbol_77.getOwnedAttributes().add(symbol_78);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
			symbol_79.setName("contextVariable");
			symbol_79.setType(symbol_305);  // pivot!Variable
			symbol_79.setLower(BigInteger.valueOf(0));
			
			symbol_79.setIsComposite(true);
			symbol_79.setIsResolveProxies(true);
			symbol_79.setOpposite(symbol_306);
			symbol_77.getOwnedAttributes().add(symbol_79);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
			symbol_80.setName("messageExpression");
			symbol_80.setType(symbol_147);  // pivot!OclExpression
			symbol_80.setLower(BigInteger.valueOf(0));
			
			symbol_80.setIsComposite(true);
			symbol_80.setIsResolveProxies(true);
			symbol_80.setOpposite(symbol_151);
			symbol_77.getOwnedAttributes().add(symbol_80);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
			symbol_81.setName("parameterVariable");
			symbol_81.setType(symbol_305);  // pivot!Variable
			symbol_81.setLower(BigInteger.valueOf(0));
			symbol_81.setUpper(BigInteger.valueOf(-1));
			symbol_81.setIsOrdered(true);
			
			symbol_81.setIsComposite(true);
			symbol_81.setIsResolveProxies(true);
			symbol_77.getOwnedAttributes().add(symbol_81);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
			symbol_82.setName("resultVariable");
			symbol_82.setType(symbol_305);  // pivot!Variable
			symbol_82.setLower(BigInteger.valueOf(0));
			
			symbol_82.setIsComposite(true);
			symbol_82.setIsResolveProxies(true);
			symbol_77.getOwnedAttributes().add(symbol_82);
		}
		symbol_1.getOwnedTypes().add(symbol_77);
		//
		// pivot.ecore::pivot::Feature pivot!Feature
		//
		symbol_83.setName("Feature");
		//symbol_83.setMoniker("pivot!Feature");
		symbol_83.getSuperClasses().add(symbol_295); // pivot!TypedMultiplicityElement
		{ // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
			symbol_84.setName("implementation");
			symbol_84.setType(symbol_24);  // pivot!CallableImplementation
			symbol_84.setLower(BigInteger.valueOf(0));
			
			symbol_84.setIsResolveProxies(true);
			symbol_84.setIsTransient(true);
			symbol_83.getOwnedAttributes().add(symbol_84);
		}
		{ // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
			symbol_85.setName("implementationClass");
			symbol_85.setType(symbol_238);  // pivot!String
			symbol_85.setLower(BigInteger.valueOf(0));
			
			symbol_85.setIsResolveProxies(true);
			symbol_83.getOwnedAttributes().add(symbol_85);
		}
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// pivot.ecore::pivot::FeatureCallExp pivot!FeatureCallExp
		//
		symbol_86.setName("FeatureCallExp");
		//symbol_86.setMoniker("pivot!FeatureCallExp");
		symbol_86.getSuperClasses().add(symbol_18); // pivot!CallExp
		{ // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
			symbol_87.setName("isPre");
			symbol_87.setType(symbol_15);  // pivot!Boolean
			
			symbol_87.setIsResolveProxies(true);
			symbol_86.getOwnedAttributes().add(symbol_87);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// pivot.ecore::pivot::IfExp pivot!IfExp
		//
		symbol_88.setName("IfExp");
		//symbol_88.setMoniker("pivot!IfExp");
		symbol_88.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
			symbol_89.setName("condition");
			symbol_89.setType(symbol_147);  // pivot!OclExpression
			
			symbol_89.setIsComposite(true);
			symbol_89.setIsResolveProxies(true);
			symbol_89.setOpposite(symbol_152);
			symbol_88.getOwnedAttributes().add(symbol_89);
		}
		{ // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
			symbol_90.setName("elseExpression");
			symbol_90.setType(symbol_147);  // pivot!OclExpression
			
			symbol_90.setIsComposite(true);
			symbol_90.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_90);
		}
		{ // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
			symbol_91.setName("thenExpression");
			symbol_91.setType(symbol_147);  // pivot!OclExpression
			
			symbol_91.setIsComposite(true);
			symbol_91.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_91);
		}
		symbol_1.getOwnedTypes().add(symbol_88);
		//
		// pivot.ecore::pivot::Int pivot!Int
		//
		symbol_92.setName("Int");
		//symbol_92.setMoniker("pivot!Int");
		symbol_1.getOwnedTypes().add(symbol_92);
		//
		// pivot.ecore::pivot::IntegerLiteralExp pivot!IntegerLiteralExp
		//
		symbol_94.setName("IntegerLiteralExp");
		//symbol_94.setMoniker("pivot!IntegerLiteralExp");
		symbol_94.getSuperClasses().add(symbol_145); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
			symbol_95.setName("integerSymbol");
			symbol_95.setType(symbol_93);  // pivot!Integer
			
			symbol_95.setIsResolveProxies(true);
			symbol_94.getOwnedAttributes().add(symbol_95);
		}
		symbol_1.getOwnedTypes().add(symbol_94);
		//
		// pivot.ecore::pivot::InvalidLiteralExp pivot!InvalidLiteralExp
		//
		symbol_96.setName("InvalidLiteralExp");
		//symbol_96.setMoniker("pivot!InvalidLiteralExp");
		symbol_96.getSuperClasses().add(symbol_113); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// pivot.ecore::pivot::InvalidType pivot!InvalidType
		//
		symbol_97.setName("InvalidType");
		//symbol_97.setMoniker("pivot!InvalidType");
		symbol_97.getSuperClasses().add(symbol_25); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_97);
		//
		// pivot.ecore::pivot::IterateExp pivot!IterateExp
		//
		symbol_98.setName("IterateExp");
		//symbol_98.setMoniker("pivot!IterateExp");
		symbol_98.getSuperClasses().add(symbol_114); // pivot!LoopExp
		{ // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
			symbol_99.setName("result");
			symbol_99.setType(symbol_305);  // pivot!Variable
			symbol_99.setLower(BigInteger.valueOf(0));
			symbol_99.setIsOrdered(true);
			
			symbol_99.setIsComposite(true);
			symbol_99.setIsResolveProxies(true);
			symbol_99.setOpposite(symbol_307);
			symbol_98.getOwnedAttributes().add(symbol_99);
		}
		symbol_1.getOwnedTypes().add(symbol_98);
		//
		// pivot.ecore::pivot::Iteration pivot!Iteration
		//
		symbol_100.setName("Iteration");
		//symbol_100.setMoniker("pivot!Iteration");
		symbol_100.getSuperClasses().add(symbol_165); // pivot!Operation
		{ // pivot.ecore::pivot::Iteration::LoopExp pivot!Iteration!LoopExp
			symbol_101.setName("LoopExp");
			symbol_101.setType(symbol_114);  // pivot!LoopExp
			symbol_101.setLower(BigInteger.valueOf(0));
			symbol_101.setUpper(BigInteger.valueOf(-1));
			
			symbol_101.setImplicit(true);
			symbol_101.setIsResolveProxies(true);
			symbol_101.setOpposite(symbol_117);
			symbol_100.getOwnedAttributes().add(symbol_101);
		}
		{ // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
			symbol_102.setName("ownedAccumulator");
			symbol_102.setType(symbol_186);  // pivot!Parameter
			symbol_102.setLower(BigInteger.valueOf(0));
			symbol_102.setUpper(BigInteger.valueOf(-1));
			
			symbol_102.setIsComposite(true);
			symbol_102.setIsResolveProxies(true);
			symbol_102.setOpposite(symbol_187);
			symbol_100.getOwnedAttributes().add(symbol_102);
		}
		{ // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
			symbol_103.setName("ownedIterator");
			symbol_103.setType(symbol_186);  // pivot!Parameter
			symbol_103.setLower(BigInteger.valueOf(0));
			symbol_103.setUpper(BigInteger.valueOf(-1));
			
			symbol_103.setIsComposite(true);
			symbol_103.setIsResolveProxies(true);
			symbol_100.getOwnedAttributes().add(symbol_103);
		}
		symbol_1.getOwnedTypes().add(symbol_100);
		//
		// pivot.ecore::pivot::IteratorExp pivot!IteratorExp
		//
		symbol_104.setName("IteratorExp");
		//symbol_104.setMoniker("pivot!IteratorExp");
		symbol_104.getSuperClasses().add(symbol_114); // pivot!LoopExp
		symbol_1.getOwnedTypes().add(symbol_104);
		//
		// pivot.ecore::pivot::LambdaType pivot!LambdaType
		//
		symbol_105.setName("LambdaType");
		//symbol_105.setMoniker("pivot!LambdaType");
		symbol_105.getSuperClasses().add(symbol_58); // pivot!DataType
		{ // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
			symbol_106.setName("contextType");
			symbol_106.setType(symbol_276);  // pivot!Type
			
			symbol_106.setIsResolveProxies(true);
			symbol_106.setOpposite(symbol_280);
			symbol_105.getOwnedAttributes().add(symbol_106);
		}
		{ // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
			symbol_107.setName("parameterType");
			symbol_107.setType(symbol_276);  // pivot!Type
			symbol_107.setLower(BigInteger.valueOf(0));
			symbol_107.setUpper(BigInteger.valueOf(-1));
			
			symbol_107.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_107);
		}
		{ // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
			symbol_108.setName("resultType");
			symbol_108.setType(symbol_276);  // pivot!Type
			
			symbol_108.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_108);
		}
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// pivot.ecore::pivot::LetExp pivot!LetExp
		//
		symbol_109.setName("LetExp");
		//symbol_109.setMoniker("pivot!LetExp");
		symbol_109.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
			symbol_110.setName("in");
			symbol_110.setType(symbol_147);  // pivot!OclExpression
			
			symbol_110.setIsComposite(true);
			symbol_110.setIsResolveProxies(true);
			symbol_110.setOpposite(symbol_153);
			symbol_109.getOwnedAttributes().add(symbol_110);
		}
		{ // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
			symbol_111.setName("variable");
			symbol_111.setType(symbol_305);  // pivot!Variable
			
			symbol_111.setIsComposite(true);
			symbol_111.setIsResolveProxies(true);
			symbol_111.setOpposite(symbol_308);
			symbol_109.getOwnedAttributes().add(symbol_111);
		}
		symbol_1.getOwnedTypes().add(symbol_109);
		//
		// pivot.ecore::pivot::Library pivot!Library
		//
		symbol_112.setName("Library");
		//symbol_112.setMoniker("pivot!Library");
		symbol_112.getSuperClasses().add(symbol_178); // pivot!Package
		symbol_1.getOwnedTypes().add(symbol_112);
		//
		// pivot.ecore::pivot::LiteralExp pivot!LiteralExp
		//
		symbol_113.setName("LiteralExp");
		//symbol_113.setMoniker("pivot!LiteralExp");
		symbol_113.getSuperClasses().add(symbol_147); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_113);
		//
		// pivot.ecore::pivot::LoopExp pivot!LoopExp
		//
		symbol_114.setName("LoopExp");
		//symbol_114.setMoniker("pivot!LoopExp");
		symbol_114.getSuperClasses().add(symbol_18); // pivot!CallExp
		{ // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
			symbol_115.setName("body");
			symbol_115.setType(symbol_147);  // pivot!OclExpression
			
			symbol_115.setIsComposite(true);
			symbol_115.setIsResolveProxies(true);
			symbol_115.setOpposite(symbol_154);
			symbol_114.getOwnedAttributes().add(symbol_115);
		}
		{ // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
			symbol_116.setName("iterator");
			symbol_116.setType(symbol_305);  // pivot!Variable
			symbol_116.setLower(BigInteger.valueOf(0));
			symbol_116.setUpper(BigInteger.valueOf(-1));
			symbol_116.setIsOrdered(true);
			
			symbol_116.setIsComposite(true);
			symbol_116.setIsResolveProxies(true);
			symbol_116.setOpposite(symbol_309);
			symbol_114.getOwnedAttributes().add(symbol_116);
		}
		{ // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
			symbol_117.setName("referredIteration");
			symbol_117.setType(symbol_100);  // pivot!Iteration
			symbol_117.setLower(BigInteger.valueOf(0));
			
			symbol_117.setIsResolveProxies(true);
			symbol_117.setOpposite(symbol_101);
			symbol_114.getOwnedAttributes().add(symbol_117);
		}
		symbol_1.getOwnedTypes().add(symbol_114);
		//
		// pivot.ecore::pivot::MessageExp pivot!MessageExp
		//
		symbol_118.setName("MessageExp");
		//symbol_118.setMoniker("pivot!MessageExp");
		symbol_118.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
			symbol_119.setName("argument");
			symbol_119.setType(symbol_147);  // pivot!OclExpression
			symbol_119.setLower(BigInteger.valueOf(0));
			symbol_119.setUpper(BigInteger.valueOf(-1));
			
			symbol_119.setIsComposite(true);
			symbol_119.setIsResolveProxies(true);
			symbol_118.getOwnedAttributes().add(symbol_119);
		}
		{ // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
			symbol_120.setName("calledOperation");
			symbol_120.setType(symbol_21);  // pivot!CallOperationAction
			symbol_120.setLower(BigInteger.valueOf(0));
			
			symbol_120.setIsComposite(true);
			symbol_120.setIsResolveProxies(true);
			symbol_120.setOpposite(symbol_22);
			symbol_118.getOwnedAttributes().add(symbol_120);
		}
		{ // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
			symbol_121.setName("sentSignal");
			symbol_121.setType(symbol_226);  // pivot!SendSignalAction
			symbol_121.setLower(BigInteger.valueOf(0));
			
			symbol_121.setIsComposite(true);
			symbol_121.setIsResolveProxies(true);
			symbol_121.setOpposite(symbol_227);
			symbol_118.getOwnedAttributes().add(symbol_121);
		}
		{ // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
			symbol_122.setName("target");
			symbol_122.setType(symbol_147);  // pivot!OclExpression
			
			symbol_122.setIsComposite(true);
			symbol_122.setIsResolveProxies(true);
			symbol_122.setOpposite(symbol_155);
			symbol_118.getOwnedAttributes().add(symbol_122);
		}
		symbol_1.getOwnedTypes().add(symbol_118);
		//
		// pivot.ecore::pivot::MessageType pivot!MessageType
		//
		symbol_123.setName("MessageType");
		//symbol_123.setMoniker("pivot!MessageType");
		symbol_123.getSuperClasses().add(symbol_276); // pivot!Type
		{ // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
			symbol_124.setName("referredOperation");
			symbol_124.setType(symbol_165);  // pivot!Operation
			symbol_124.setLower(BigInteger.valueOf(0));
			
			symbol_124.setIsResolveProxies(true);
			symbol_124.setOpposite(symbol_167);
			symbol_123.getOwnedAttributes().add(symbol_124);
		}
		{ // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
			symbol_125.setName("referredSignal");
			symbol_125.setType(symbol_231);  // pivot!Signal
			symbol_125.setLower(BigInteger.valueOf(0));
			
			symbol_125.setIsResolveProxies(true);
			symbol_125.setOpposite(symbol_232);
			symbol_123.getOwnedAttributes().add(symbol_125);
		}
		symbol_1.getOwnedTypes().add(symbol_123);
		//
		// pivot.ecore::pivot::MonikeredElement pivot!MonikeredElement
		//
		symbol_126.setName("MonikeredElement");
		//symbol_126.setMoniker("pivot!MonikeredElement");
		symbol_126.getSuperClasses().add(symbol_64); // pivot!Element
		{ // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
			symbol_127.setName("moniker");
			symbol_127.setType(symbol_238);  // pivot!String
			
			symbol_127.setIsDerived(true);
			symbol_127.setIsResolveProxies(true);
			symbol_127.setIsTransient(true);
			symbol_127.setIsVolatile(true);
			symbol_126.getOwnedAttributes().add(symbol_127);
		}
		{	// pivot.ecore::pivot::MonikeredElement::hasMoniker() pivot!MonikeredElement!hasMoniker()
			Operation symbol_333 = PivotFactory.eINSTANCE.createOperation();
			symbol_333.setName("hasMoniker");
			//symbol_333.setMoniker("pivot!MonikeredElement!hasMoniker()");
			symbol_333.setType(symbol_15);  // pivot!Boolean
			
			symbol_126.getOwnedOperations().add(symbol_333);
		}
		symbol_1.getOwnedTypes().add(symbol_126);
		//
		// pivot.ecore::pivot::MultiplicityElement pivot!MultiplicityElement
		//
		symbol_128.setName("MultiplicityElement");
		//symbol_128.setMoniker("pivot!MultiplicityElement");
		symbol_128.getSuperClasses().add(symbol_126); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
			symbol_129.setName("isOrdered");
			symbol_129.setType(symbol_15);  // pivot!Boolean
			
			symbol_129.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_129);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
			symbol_130.setName("isUnique");
			symbol_130.setType(symbol_15);  // pivot!Boolean
			
			symbol_130.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_130);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
			symbol_131.setName("lower");
			symbol_131.setType(symbol_93);  // pivot!Integer
			symbol_131.setLower(BigInteger.valueOf(0));
			
			symbol_131.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_131);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
			symbol_132.setName("upper");
			symbol_132.setType(symbol_296);  // pivot!UnlimitedNatural
			symbol_132.setLower(BigInteger.valueOf(0));
			
			symbol_132.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_132);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesCardinality() pivot!MultiplicityElement!includesCardinality(pivot!Integer)
			Operation symbol_334 = PivotFactory.eINSTANCE.createOperation();
			symbol_334.setName("includesCardinality");
			//symbol_334.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)");
			symbol_334.setType(symbol_15);  // pivot!Boolean
			
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("C");
			//symbol_335.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)!C");
			symbol_335.setType(symbol_93);  // pivot!Integer
			
			symbol_334.getOwnedParameters().add(symbol_335);
			symbol_128.getOwnedOperations().add(symbol_334);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesMultiplicity() pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)
			Operation symbol_336 = PivotFactory.eINSTANCE.createOperation();
			symbol_336.setName("includesMultiplicity");
			//symbol_336.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)");
			symbol_336.setType(symbol_15);  // pivot!Boolean
			
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("M");
			//symbol_337.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)!M");
			symbol_337.setType(symbol_128);  // pivot!MultiplicityElement
			
			symbol_336.getOwnedParameters().add(symbol_337);
			symbol_128.getOwnedOperations().add(symbol_336);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::isMultivalued() pivot!MultiplicityElement!isMultivalued()
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("isMultivalued");
			//symbol_338.setMoniker("pivot!MultiplicityElement!isMultivalued()");
			symbol_338.setType(symbol_15);  // pivot!Boolean
			
			symbol_128.getOwnedOperations().add(symbol_338);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::lowerBound() pivot!MultiplicityElement!lowerBound()
			Operation symbol_339 = PivotFactory.eINSTANCE.createOperation();
			symbol_339.setName("lowerBound");
			//symbol_339.setMoniker("pivot!MultiplicityElement!lowerBound()");
			symbol_339.setType(symbol_93);  // pivot!Integer
			
			symbol_128.getOwnedOperations().add(symbol_339);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::upperBound() pivot!MultiplicityElement!upperBound()
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("upperBound");
			//symbol_340.setMoniker("pivot!MultiplicityElement!upperBound()");
			symbol_340.setType(symbol_296);  // pivot!UnlimitedNatural
			
			symbol_128.getOwnedOperations().add(symbol_340);
		}
		symbol_1.getOwnedTypes().add(symbol_128);
		//
		// pivot.ecore::pivot::Nameable pivot!Nameable
		//
		symbol_133.setName("Nameable");
		//symbol_133.setMoniker("pivot!Nameable");
		symbol_1.getOwnedTypes().add(symbol_133);
		//
		// pivot.ecore::pivot::NamedElement pivot!NamedElement
		//
		symbol_134.setName("NamedElement");
		//symbol_134.setMoniker("pivot!NamedElement");
		symbol_134.getSuperClasses().add(symbol_126); // pivot!MonikeredElement
		symbol_134.getSuperClasses().add(symbol_133); // pivot!Nameable
		{ // pivot.ecore::pivot::NamedElement::Constraint pivot!NamedElement!Constraint
			symbol_135.setName("Constraint");
			symbol_135.setType(symbol_52);  // pivot!Constraint
			symbol_135.setLower(BigInteger.valueOf(0));
			symbol_135.setUpper(BigInteger.valueOf(-1));
			
			symbol_135.setImplicit(true);
			symbol_135.setIsResolveProxies(true);
			symbol_135.setOpposite(symbol_55);
			symbol_134.getOwnedAttributes().add(symbol_135);
		}
		{ // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
			symbol_136.setName("isStatic");
			symbol_136.setType(symbol_15);  // pivot!Boolean
			
			symbol_136.setIsResolveProxies(true);
			symbol_134.getOwnedAttributes().add(symbol_136);
		}
		{ // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
			symbol_137.setName("name");
			symbol_137.setType(symbol_238);  // pivot!String
			symbol_137.setLower(BigInteger.valueOf(0));
			
			symbol_137.setIsResolveProxies(true);
			symbol_134.getOwnedAttributes().add(symbol_137);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
			symbol_138.setName("ownedAnnotation");
			symbol_138.setType(symbol_2);  // pivot!Annotation
			symbol_138.setLower(BigInteger.valueOf(0));
			symbol_138.setUpper(BigInteger.valueOf(-1));
			symbol_138.setIsOrdered(true);
			
			symbol_138.setIsComposite(true);
			symbol_138.setIsResolveProxies(true);
			symbol_138.setOpposite(symbol_3);
			symbol_134.getOwnedAttributes().add(symbol_138);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
			symbol_139.setName("ownedRule");
			symbol_139.setType(symbol_52);  // pivot!Constraint
			symbol_139.setLower(BigInteger.valueOf(0));
			symbol_139.setUpper(BigInteger.valueOf(-1));
			
			symbol_139.setIsComposite(true);
			symbol_139.setIsResolveProxies(true);
			symbol_139.setOpposite(symbol_53);
			symbol_134.getOwnedAttributes().add(symbol_139);
		}
		symbol_1.getOwnedTypes().add(symbol_134);
		//
		// pivot.ecore::pivot::Namespace pivot!Namespace
		//
		symbol_140.setName("Namespace");
		//symbol_140.setMoniker("pivot!Namespace");
		symbol_140.getSuperClasses().add(symbol_134); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_140);
		//
		// pivot.ecore::pivot::NavigationCallExp pivot!NavigationCallExp
		//
		symbol_141.setName("NavigationCallExp");
		//symbol_141.setMoniker("pivot!NavigationCallExp");
		symbol_141.getSuperClasses().add(symbol_86); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
			symbol_142.setName("navigationSource");
			symbol_142.setType(symbol_203);  // pivot!Property
			symbol_142.setLower(BigInteger.valueOf(0));
			symbol_142.setIsOrdered(true);
			
			symbol_142.setIsResolveProxies(true);
			symbol_142.setOpposite(symbol_204);
			symbol_141.getOwnedAttributes().add(symbol_142);
		}
		{ // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
			symbol_143.setName("qualifier");
			symbol_143.setType(symbol_147);  // pivot!OclExpression
			symbol_143.setLower(BigInteger.valueOf(0));
			symbol_143.setUpper(BigInteger.valueOf(-1));
			symbol_143.setIsOrdered(true);
			
			symbol_143.setIsResolveProxies(true);
			symbol_143.setOpposite(symbol_156);
			symbol_141.getOwnedAttributes().add(symbol_143);
		}
		symbol_1.getOwnedTypes().add(symbol_141);
		//
		// pivot.ecore::pivot::NullLiteralExp pivot!NullLiteralExp
		//
		symbol_144.setName("NullLiteralExp");
		//symbol_144.setMoniker("pivot!NullLiteralExp");
		symbol_144.getSuperClasses().add(symbol_201); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_144);
		//
		// pivot.ecore::pivot::NumericLiteralExp pivot!NumericLiteralExp
		//
		symbol_145.setName("NumericLiteralExp");
		//symbol_145.setMoniker("pivot!NumericLiteralExp");
		symbol_145.getSuperClasses().add(symbol_201); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_145);
		//
		// pivot.ecore::pivot::Object pivot!Object
		//
		symbol_146.setName("Object");
		//symbol_146.setMoniker("pivot!Object");
		symbol_1.getOwnedTypes().add(symbol_146);
		//
		// pivot.ecore::pivot::OclExpression pivot!OclExpression
		//
		symbol_147.setName("OclExpression");
		//symbol_147.setMoniker("pivot!OclExpression");
		symbol_147.getSuperClasses().add(symbol_293); // pivot!TypedElement
		{ // pivot.ecore::pivot::OclExpression::CallExp pivot!OclExpression!CallExp
			symbol_148.setName("CallExp");
			symbol_148.setType(symbol_18);  // pivot!CallExp
			symbol_148.setLower(BigInteger.valueOf(0));
			
			symbol_148.setImplicit(true);
			symbol_148.setIsResolveProxies(true);
			symbol_148.setOpposite(symbol_20);
			symbol_147.getOwnedAttributes().add(symbol_148);
		}
		{ // pivot.ecore::pivot::OclExpression::CollectionItem pivot!OclExpression!CollectionItem
			symbol_149.setName("CollectionItem");
			symbol_149.setType(symbol_35);  // pivot!CollectionItem
			symbol_149.setLower(BigInteger.valueOf(0));
			
			symbol_149.setImplicit(true);
			symbol_149.setIsResolveProxies(true);
			symbol_149.setOpposite(symbol_36);
			symbol_147.getOwnedAttributes().add(symbol_149);
		}
		{ // pivot.ecore::pivot::OclExpression::CollectionRange pivot!OclExpression!CollectionRange
			symbol_150.setName("CollectionRange");
			symbol_150.setType(symbol_43);  // pivot!CollectionRange
			symbol_150.setLower(BigInteger.valueOf(0));
			symbol_150.setUpper(BigInteger.valueOf(-1));
			
			symbol_150.setImplicit(true);
			symbol_150.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_150);
		}
		{ // pivot.ecore::pivot::OclExpression::ExpressionInOcl pivot!OclExpression!ExpressionInOcl
			symbol_151.setName("ExpressionInOcl");
			symbol_151.setType(symbol_77);  // pivot!ExpressionInOcl
			symbol_151.setLower(BigInteger.valueOf(0));
			symbol_151.setUpper(BigInteger.valueOf(-1));
			
			symbol_151.setImplicit(true);
			symbol_151.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_151);
		}
		{ // pivot.ecore::pivot::OclExpression::IfExp pivot!OclExpression!IfExp
			symbol_152.setName("IfExp");
			symbol_152.setType(symbol_88);  // pivot!IfExp
			symbol_152.setLower(BigInteger.valueOf(0));
			symbol_152.setUpper(BigInteger.valueOf(-1));
			
			symbol_152.setImplicit(true);
			symbol_152.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_152);
		}
		{ // pivot.ecore::pivot::OclExpression::LetExp pivot!OclExpression!LetExp
			symbol_153.setName("LetExp");
			symbol_153.setType(symbol_109);  // pivot!LetExp
			symbol_153.setLower(BigInteger.valueOf(0));
			
			symbol_153.setImplicit(true);
			symbol_153.setIsResolveProxies(true);
			symbol_153.setOpposite(symbol_110);
			symbol_147.getOwnedAttributes().add(symbol_153);
		}
		{ // pivot.ecore::pivot::OclExpression::LoopExp pivot!OclExpression!LoopExp
			symbol_154.setName("LoopExp");
			symbol_154.setType(symbol_114);  // pivot!LoopExp
			symbol_154.setLower(BigInteger.valueOf(0));
			
			symbol_154.setImplicit(true);
			symbol_154.setIsResolveProxies(true);
			symbol_154.setOpposite(symbol_115);
			symbol_147.getOwnedAttributes().add(symbol_154);
		}
		{ // pivot.ecore::pivot::OclExpression::MessageExp pivot!OclExpression!MessageExp
			symbol_155.setName("MessageExp");
			symbol_155.setType(symbol_118);  // pivot!MessageExp
			symbol_155.setLower(BigInteger.valueOf(0));
			symbol_155.setUpper(BigInteger.valueOf(-1));
			
			symbol_155.setImplicit(true);
			symbol_155.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_155);
		}
		{ // pivot.ecore::pivot::OclExpression::NavigationCallExp pivot!OclExpression!NavigationCallExp
			symbol_156.setName("NavigationCallExp");
			symbol_156.setType(symbol_141);  // pivot!NavigationCallExp
			symbol_156.setLower(BigInteger.valueOf(0));
			symbol_156.setUpper(BigInteger.valueOf(-1));
			
			symbol_156.setImplicit(true);
			symbol_156.setIsResolveProxies(true);
			symbol_156.setOpposite(symbol_143);
			symbol_147.getOwnedAttributes().add(symbol_156);
		}
		{ // pivot.ecore::pivot::OclExpression::OperationCallExp pivot!OclExpression!OperationCallExp
			symbol_157.setName("OperationCallExp");
			symbol_157.setType(symbol_173);  // pivot!OperationCallExp
			symbol_157.setLower(BigInteger.valueOf(0));
			
			symbol_157.setImplicit(true);
			symbol_157.setIsResolveProxies(true);
			symbol_157.setOpposite(symbol_174);
			symbol_147.getOwnedAttributes().add(symbol_157);
		}
		{ // pivot.ecore::pivot::OclExpression::TupleLiteralPart pivot!OclExpression!TupleLiteralPart
			symbol_158.setName("TupleLiteralPart");
			symbol_158.setType(symbol_272);  // pivot!TupleLiteralPart
			symbol_158.setLower(BigInteger.valueOf(0));
			
			symbol_158.setImplicit(true);
			symbol_158.setIsResolveProxies(true);
			symbol_158.setOpposite(symbol_274);
			symbol_147.getOwnedAttributes().add(symbol_158);
		}
		{ // pivot.ecore::pivot::OclExpression::Variable pivot!OclExpression!Variable
			symbol_159.setName("Variable");
			symbol_159.setType(symbol_305);  // pivot!Variable
			symbol_159.setLower(BigInteger.valueOf(0));
			
			symbol_159.setImplicit(true);
			symbol_159.setIsResolveProxies(true);
			symbol_159.setOpposite(symbol_311);
			symbol_147.getOwnedAttributes().add(symbol_159);
		}
		symbol_1.getOwnedTypes().add(symbol_147);
		//
		// pivot.ecore::pivot::OpaqueExpression pivot!OpaqueExpression
		//
		symbol_160.setName("OpaqueExpression");
		//symbol_160.setMoniker("pivot!OpaqueExpression");
		symbol_160.getSuperClasses().add(symbol_303); // pivot!ValueSpecification
		{ // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
			symbol_161.setName("body");
			symbol_161.setType(symbol_238);  // pivot!String
			symbol_161.setLower(BigInteger.valueOf(0));
			symbol_161.setUpper(BigInteger.valueOf(-1));
			symbol_161.setIsOrdered(true);
			symbol_161.setIsUnique(false);
			
			symbol_161.setIsResolveProxies(true);
			symbol_160.getOwnedAttributes().add(symbol_161);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
			symbol_162.setName("language");
			symbol_162.setType(symbol_238);  // pivot!String
			symbol_162.setLower(BigInteger.valueOf(0));
			symbol_162.setUpper(BigInteger.valueOf(-1));
			symbol_162.setIsOrdered(true);
			
			symbol_162.setIsResolveProxies(true);
			symbol_160.getOwnedAttributes().add(symbol_162);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
			symbol_163.setName("message");
			symbol_163.setType(symbol_238);  // pivot!String
			symbol_163.setLower(BigInteger.valueOf(0));
			symbol_163.setUpper(BigInteger.valueOf(-1));
			symbol_163.setIsOrdered(true);
			symbol_163.setIsUnique(false);
			
			symbol_163.setIsResolveProxies(true);
			symbol_160.getOwnedAttributes().add(symbol_163);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
			symbol_164.setName("valueExpression");
			symbol_164.setType(symbol_77);  // pivot!ExpressionInOcl
			symbol_164.setLower(BigInteger.valueOf(0));
			
			symbol_164.setIsResolveProxies(true);
			symbol_164.setIsTransient(true);
			symbol_160.getOwnedAttributes().add(symbol_164);
		}
		symbol_1.getOwnedTypes().add(symbol_160);
		//
		// pivot.ecore::pivot::Operation pivot!Operation
		//
		symbol_165.setName("Operation");
		//symbol_165.setMoniker("pivot!Operation");
		symbol_165.getSuperClasses().add(symbol_190); // pivot!ParameterableElement
		symbol_165.getSuperClasses().add(symbol_140); // pivot!Namespace
		symbol_165.getSuperClasses().add(symbol_83); // pivot!Feature
		symbol_165.getSuperClasses().add(symbol_265); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Operation::CallOperationAction pivot!Operation!CallOperationAction
			symbol_166.setName("CallOperationAction");
			symbol_166.setType(symbol_21);  // pivot!CallOperationAction
			symbol_166.setLower(BigInteger.valueOf(0));
			symbol_166.setUpper(BigInteger.valueOf(-1));
			
			symbol_166.setImplicit(true);
			symbol_166.setIsResolveProxies(true);
			symbol_166.setOpposite(symbol_23);
			symbol_165.getOwnedAttributes().add(symbol_166);
		}
		{ // pivot.ecore::pivot::Operation::MessageType pivot!Operation!MessageType
			symbol_167.setName("MessageType");
			symbol_167.setType(symbol_123);  // pivot!MessageType
			symbol_167.setLower(BigInteger.valueOf(0));
			symbol_167.setUpper(BigInteger.valueOf(-1));
			
			symbol_167.setImplicit(true);
			symbol_167.setIsResolveProxies(true);
			symbol_167.setOpposite(symbol_124);
			symbol_165.getOwnedAttributes().add(symbol_167);
		}
		{ // pivot.ecore::pivot::Operation::OperationCallExp pivot!Operation!OperationCallExp
			symbol_168.setName("OperationCallExp");
			symbol_168.setType(symbol_173);  // pivot!OperationCallExp
			symbol_168.setLower(BigInteger.valueOf(0));
			symbol_168.setUpper(BigInteger.valueOf(-1));
			
			symbol_168.setImplicit(true);
			symbol_168.setIsResolveProxies(true);
			symbol_168.setOpposite(symbol_175);
			symbol_165.getOwnedAttributes().add(symbol_168);
		}
		{ // pivot.ecore::pivot::Operation::class pivot!Operation!class
			symbol_169.setName("class");
			symbol_169.setType(symbol_25);  // pivot!Class
			symbol_169.setLower(BigInteger.valueOf(0));
			
			symbol_169.setIsResolveProxies(true);
			symbol_169.setOpposite(symbol_30);
			symbol_165.getOwnedAttributes().add(symbol_169);
		}
		{ // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
			symbol_170.setName("ownedParameter");
			symbol_170.setType(symbol_186);  // pivot!Parameter
			symbol_170.setLower(BigInteger.valueOf(0));
			symbol_170.setUpper(BigInteger.valueOf(-1));
			symbol_170.setIsOrdered(true);
			
			symbol_170.setIsComposite(true);
			symbol_170.setIsResolveProxies(true);
			symbol_170.setOpposite(symbol_189);
			symbol_165.getOwnedAttributes().add(symbol_170);
		}
		{ // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
			symbol_171.setName("precedence");
			symbol_171.setType(symbol_196);  // pivot!Precedence
			symbol_171.setLower(BigInteger.valueOf(0));
			
			symbol_171.setIsResolveProxies(true);
			symbol_171.setOpposite(symbol_197);
			symbol_165.getOwnedAttributes().add(symbol_171);
		}
		{ // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
			symbol_172.setName("raisedException");
			symbol_172.setType(symbol_276);  // pivot!Type
			symbol_172.setLower(BigInteger.valueOf(0));
			symbol_172.setUpper(BigInteger.valueOf(-1));
			
			symbol_172.setIsResolveProxies(true);
			symbol_172.setOpposite(symbol_281);
			symbol_165.getOwnedAttributes().add(symbol_172);
		}
		symbol_1.getOwnedTypes().add(symbol_165);
		//
		// pivot.ecore::pivot::OperationCallExp pivot!OperationCallExp
		//
		symbol_173.setName("OperationCallExp");
		//symbol_173.setMoniker("pivot!OperationCallExp");
		symbol_173.getSuperClasses().add(symbol_86); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
			symbol_174.setName("argument");
			symbol_174.setType(symbol_147);  // pivot!OclExpression
			symbol_174.setLower(BigInteger.valueOf(0));
			symbol_174.setUpper(BigInteger.valueOf(-1));
			symbol_174.setIsOrdered(true);
			
			symbol_174.setIsComposite(true);
			symbol_174.setIsResolveProxies(true);
			symbol_174.setOpposite(symbol_157);
			symbol_173.getOwnedAttributes().add(symbol_174);
		}
		{ // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
			symbol_175.setName("referredOperation");
			symbol_175.setType(symbol_165);  // pivot!Operation
			symbol_175.setLower(BigInteger.valueOf(0));
			
			symbol_175.setIsResolveProxies(true);
			symbol_175.setOpposite(symbol_168);
			symbol_173.getOwnedAttributes().add(symbol_175);
		}
		symbol_1.getOwnedTypes().add(symbol_173);
		//
		// pivot.ecore::pivot::OperationTemplateParameter pivot!OperationTemplateParameter
		//
		symbol_176.setName("OperationTemplateParameter");
		//symbol_176.setMoniker("pivot!OperationTemplateParameter");
		symbol_176.getSuperClasses().add(symbol_245); // pivot!TemplateParameter
		symbol_1.getOwnedTypes().add(symbol_176);
		//
		// pivot.ecore::pivot::OrderedSetType pivot!OrderedSetType
		//
		symbol_177.setName("OrderedSetType");
		//symbol_177.setMoniker("pivot!OrderedSetType");
		symbol_177.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_177);
		//
		// pivot.ecore::pivot::Package pivot!Package
		//
		symbol_178.setName("Package");
		//symbol_178.setMoniker("pivot!Package");
		symbol_178.getSuperClasses().add(symbol_140); // pivot!Namespace
		symbol_178.getSuperClasses().add(symbol_265); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
			symbol_179.setName("nestedPackage");
			symbol_179.setType(symbol_178);  // pivot!Package
			symbol_179.setLower(BigInteger.valueOf(0));
			symbol_179.setUpper(BigInteger.valueOf(-1));
			
			symbol_179.setIsComposite(true);
			symbol_179.setIsResolveProxies(true);
			symbol_179.setOpposite(symbol_180);
			symbol_178.getOwnedAttributes().add(symbol_179);
		}
		{ // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
			symbol_180.setName("nestingPackage");
			symbol_180.setType(symbol_178);  // pivot!Package
			symbol_180.setLower(BigInteger.valueOf(0));
			
			symbol_180.setIsResolveProxies(true);
			symbol_180.setOpposite(symbol_179);
			symbol_178.getOwnedAttributes().add(symbol_180);
		}
		{ // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
			symbol_181.setName("nsPrefix");
			symbol_181.setType(symbol_238);  // pivot!String
			symbol_181.setLower(BigInteger.valueOf(0));
			
			symbol_181.setIsResolveProxies(true);
			symbol_178.getOwnedAttributes().add(symbol_181);
		}
		{ // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
			symbol_182.setName("nsURI");
			symbol_182.setType(symbol_238);  // pivot!String
			symbol_182.setLower(BigInteger.valueOf(0));
			
			symbol_182.setIsResolveProxies(true);
			symbol_178.getOwnedAttributes().add(symbol_182);
		}
		{ // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
			symbol_183.setName("ownedPrecedence");
			symbol_183.setType(symbol_196);  // pivot!Precedence
			symbol_183.setLower(BigInteger.valueOf(0));
			symbol_183.setUpper(BigInteger.valueOf(-1));
			symbol_183.setIsOrdered(true);
			
			symbol_183.setIsComposite(true);
			symbol_183.setIsResolveProxies(true);
			symbol_183.setOpposite(symbol_198);
			symbol_178.getOwnedAttributes().add(symbol_183);
		}
		{ // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
			symbol_184.setName("ownedType");
			symbol_184.setType(symbol_276);  // pivot!Type
			symbol_184.setLower(BigInteger.valueOf(0));
			symbol_184.setUpper(BigInteger.valueOf(-1));
			
			symbol_184.setIsComposite(true);
			symbol_184.setIsResolveProxies(true);
			symbol_184.setOpposite(symbol_287);
			symbol_178.getOwnedAttributes().add(symbol_184);
		}
		symbol_1.getOwnedTypes().add(symbol_178);
		//
		// pivot.ecore::pivot::PackageableElement pivot!PackageableElement
		//
		symbol_185.setName("PackageableElement");
		//symbol_185.setMoniker("pivot!PackageableElement");
		symbol_185.getSuperClasses().add(symbol_190); // pivot!ParameterableElement
		symbol_1.getOwnedTypes().add(symbol_185);
		//
		// pivot.ecore::pivot::Parameter pivot!Parameter
		//
		symbol_186.setName("Parameter");
		//symbol_186.setMoniker("pivot!Parameter");
		symbol_186.getSuperClasses().add(symbol_295); // pivot!TypedMultiplicityElement
		symbol_186.getSuperClasses().add(symbol_313); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Parameter::Iteration pivot!Parameter!Iteration
			symbol_187.setName("Iteration");
			symbol_187.setType(symbol_100);  // pivot!Iteration
			symbol_187.setLower(BigInteger.valueOf(0));
			symbol_187.setUpper(BigInteger.valueOf(-1));
			
			symbol_187.setImplicit(true);
			symbol_187.setIsResolveProxies(true);
			symbol_186.getOwnedAttributes().add(symbol_187);
		}
		{ // pivot.ecore::pivot::Parameter::Variable pivot!Parameter!Variable
			symbol_188.setName("Variable");
			symbol_188.setType(symbol_305);  // pivot!Variable
			symbol_188.setLower(BigInteger.valueOf(0));
			symbol_188.setUpper(BigInteger.valueOf(-1));
			
			symbol_188.setImplicit(true);
			symbol_188.setIsResolveProxies(true);
			symbol_188.setOpposite(symbol_312);
			symbol_186.getOwnedAttributes().add(symbol_188);
		}
		{ // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
			symbol_189.setName("operation");
			symbol_189.setType(symbol_165);  // pivot!Operation
			symbol_189.setLower(BigInteger.valueOf(0));
			
			symbol_189.setIsResolveProxies(true);
			symbol_189.setOpposite(symbol_170);
			symbol_186.getOwnedAttributes().add(symbol_189);
		}
		symbol_1.getOwnedTypes().add(symbol_186);
		//
		// pivot.ecore::pivot::ParameterableElement pivot!ParameterableElement
		//
		symbol_190.setName("ParameterableElement");
		//symbol_190.setMoniker("pivot!ParameterableElement");
		symbol_190.getSuperClasses().add(symbol_126); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::ParameterableElement::TemplateParameter pivot!ParameterableElement!TemplateParameter
			symbol_191.setName("TemplateParameter");
			symbol_191.setType(symbol_245);  // pivot!TemplateParameter
			symbol_191.setLower(BigInteger.valueOf(0));
			symbol_191.setUpper(BigInteger.valueOf(-1));
			
			symbol_191.setImplicit(true);
			symbol_191.setIsResolveProxies(true);
			symbol_190.getOwnedAttributes().add(symbol_191);
		}
		{ // pivot.ecore::pivot::ParameterableElement::TemplateParameterSubstitution pivot!ParameterableElement!TemplateParameterSubstitution
			symbol_192.setName("TemplateParameterSubstitution");
			symbol_192.setType(symbol_253);  // pivot!TemplateParameterSubstitution
			symbol_192.setLower(BigInteger.valueOf(0));
			symbol_192.setUpper(BigInteger.valueOf(-1));
			
			symbol_192.setImplicit(true);
			symbol_192.setIsResolveProxies(true);
			symbol_190.getOwnedAttributes().add(symbol_192);
		}
		{ // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
			symbol_193.setName("owningTemplateParameter");
			symbol_193.setType(symbol_245);  // pivot!TemplateParameter
			symbol_193.setLower(BigInteger.valueOf(0));
			
			symbol_193.setIsResolveProxies(true);
			symbol_193.setOpposite(symbol_250);
			symbol_190.getOwnedAttributes().add(symbol_193);
		}
		{ // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
			symbol_194.setName("templateParameter");
			symbol_194.setType(symbol_245);  // pivot!TemplateParameter
			symbol_194.setLower(BigInteger.valueOf(0));
			
			symbol_194.setIsResolveProxies(true);
			symbol_194.setOpposite(symbol_251);
			symbol_190.getOwnedAttributes().add(symbol_194);
		}
		{	// pivot.ecore::pivot::ParameterableElement::isTemplateParameter() pivot!ParameterableElement!isTemplateParameter()
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("isTemplateParameter");
			//symbol_341.setMoniker("pivot!ParameterableElement!isTemplateParameter()");
			symbol_341.setType(symbol_15);  // pivot!Boolean
			
			symbol_190.getOwnedOperations().add(symbol_341);
		}
		symbol_1.getOwnedTypes().add(symbol_190);
		//
		// pivot.ecore::pivot::Pivotable pivot!Pivotable
		//
		symbol_195.setName("Pivotable");
		//symbol_195.setMoniker("pivot!Pivotable");
		symbol_1.getOwnedTypes().add(symbol_195);
		//
		// pivot.ecore::pivot::Precedence pivot!Precedence
		//
		symbol_196.setName("Precedence");
		//symbol_196.setMoniker("pivot!Precedence");
		symbol_196.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::Precedence::Operation pivot!Precedence!Operation
			symbol_197.setName("Operation");
			symbol_197.setType(symbol_165);  // pivot!Operation
			symbol_197.setLower(BigInteger.valueOf(0));
			symbol_197.setUpper(BigInteger.valueOf(-1));
			
			symbol_197.setImplicit(true);
			symbol_197.setIsResolveProxies(true);
			symbol_197.setOpposite(symbol_171);
			symbol_196.getOwnedAttributes().add(symbol_197);
		}
		{ // pivot.ecore::pivot::Precedence::Package pivot!Precedence!Package
			symbol_198.setName("Package");
			symbol_198.setType(symbol_178);  // pivot!Package
			symbol_198.setLower(BigInteger.valueOf(0));
			
			symbol_198.setImplicit(true);
			symbol_198.setIsResolveProxies(true);
			symbol_198.setOpposite(symbol_183);
			symbol_196.getOwnedAttributes().add(symbol_198);
		}
		{ // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
			symbol_199.setName("associativity");
			symbol_199.setType(symbol_13);  // pivot!AssociativityKind
			symbol_199.setLower(BigInteger.valueOf(0));
			
			symbol_199.setIsResolveProxies(true);
			symbol_196.getOwnedAttributes().add(symbol_199);
		}
		{ // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
			symbol_200.setName("order");
			symbol_200.setType(symbol_93);  // pivot!Integer
			
			symbol_200.setIsDerived(true);
			symbol_200.setIsResolveProxies(true);
			symbol_200.setIsVolatile(true);
			symbol_196.getOwnedAttributes().add(symbol_200);
		}
		symbol_1.getOwnedTypes().add(symbol_196);
		//
		// pivot.ecore::pivot::PrimitiveLiteralExp pivot!PrimitiveLiteralExp
		//
		symbol_201.setName("PrimitiveLiteralExp");
		//symbol_201.setMoniker("pivot!PrimitiveLiteralExp");
		symbol_201.getSuperClasses().add(symbol_113); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_201);
		//
		// pivot.ecore::pivot::PrimitiveType pivot!PrimitiveType
		//
		symbol_202.setName("PrimitiveType");
		//symbol_202.setMoniker("pivot!PrimitiveType");
		symbol_202.getSuperClasses().add(symbol_58); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_202);
		//
		// pivot.ecore::pivot::Property pivot!Property
		//
		symbol_203.setName("Property");
		//symbol_203.setMoniker("pivot!Property");
		symbol_203.getSuperClasses().add(symbol_190); // pivot!ParameterableElement
		symbol_203.getSuperClasses().add(symbol_83); // pivot!Feature
		{ // pivot.ecore::pivot::Property::NavigationCallExp pivot!Property!NavigationCallExp
			symbol_204.setName("NavigationCallExp");
			symbol_204.setType(symbol_141);  // pivot!NavigationCallExp
			symbol_204.setLower(BigInteger.valueOf(0));
			symbol_204.setUpper(BigInteger.valueOf(-1));
			
			symbol_204.setImplicit(true);
			symbol_204.setIsResolveProxies(true);
			symbol_204.setOpposite(symbol_142);
			symbol_203.getOwnedAttributes().add(symbol_204);
		}
		{ // pivot.ecore::pivot::Property::Property pivot!Property!Property
			symbol_205.setName("Property");
			symbol_205.setType(symbol_203);  // pivot!Property
			symbol_205.setLower(BigInteger.valueOf(0));
			symbol_205.setUpper(BigInteger.valueOf(-1));
			
			symbol_205.setImplicit(true);
			symbol_205.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_205);
		}
		{ // pivot.ecore::pivot::Property::PropertyCallExp pivot!Property!PropertyCallExp
			symbol_206.setName("PropertyCallExp");
			symbol_206.setType(symbol_221);  // pivot!PropertyCallExp
			symbol_206.setLower(BigInteger.valueOf(0));
			symbol_206.setUpper(BigInteger.valueOf(-1));
			
			symbol_206.setImplicit(true);
			symbol_206.setIsResolveProxies(true);
			symbol_206.setOpposite(symbol_222);
			symbol_203.getOwnedAttributes().add(symbol_206);
		}
		{ // pivot.ecore::pivot::Property::association pivot!Property!association
			symbol_207.setName("association");
			symbol_207.setType(symbol_8);  // pivot!AssociationClass
			symbol_207.setLower(BigInteger.valueOf(0));
			
			symbol_207.setIsResolveProxies(true);
			symbol_207.setOpposite(symbol_10);
			symbol_203.getOwnedAttributes().add(symbol_207);
		}
		{ // pivot.ecore::pivot::Property::class pivot!Property!class
			symbol_208.setName("class");
			symbol_208.setType(symbol_25);  // pivot!Class
			symbol_208.setLower(BigInteger.valueOf(0));
			
			symbol_208.setIsResolveProxies(true);
			symbol_208.setOpposite(symbol_29);
			symbol_203.getOwnedAttributes().add(symbol_208);
		}
		{ // pivot.ecore::pivot::Property::default pivot!Property!default
			symbol_209.setName("default");
			symbol_209.setType(symbol_238);  // pivot!String
			symbol_209.setLower(BigInteger.valueOf(0));
			
			symbol_209.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_209);
		}
		{ // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
			symbol_210.setName("implicit");
			symbol_210.setType(symbol_15);  // pivot!Boolean
			symbol_210.setLower(BigInteger.valueOf(0));
			
			symbol_210.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_210);
		}
		{ // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
			symbol_211.setName("isComposite");
			symbol_211.setType(symbol_15);  // pivot!Boolean
			
			symbol_211.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_211);
		}
		{ // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
			symbol_212.setName("isDerived");
			symbol_212.setType(symbol_15);  // pivot!Boolean
			
			symbol_212.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_212);
		}
		{ // pivot.ecore::pivot::Property::isID pivot!Property!isID
			symbol_213.setName("isID");
			symbol_213.setType(symbol_15);  // pivot!Boolean
			
			symbol_213.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_213);
		}
		{ // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
			symbol_214.setName("isReadOnly");
			symbol_214.setType(symbol_15);  // pivot!Boolean
			
			symbol_214.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_214);
		}
		{ // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
			symbol_215.setName("isResolveProxies");
			symbol_215.setType(symbol_15);  // pivot!Boolean
			
			symbol_215.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_215);
		}
		{ // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
			symbol_216.setName("isTransient");
			symbol_216.setType(symbol_15);  // pivot!Boolean
			
			symbol_216.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_216);
		}
		{ // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
			symbol_217.setName("isUnsettable");
			symbol_217.setType(symbol_15);  // pivot!Boolean
			
			symbol_217.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_217);
		}
		{ // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
			symbol_218.setName("isVolatile");
			symbol_218.setType(symbol_15);  // pivot!Boolean
			
			symbol_218.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_218);
		}
		{ // pivot.ecore::pivot::Property::keys pivot!Property!keys
			symbol_219.setName("keys");
			symbol_219.setType(symbol_203);  // pivot!Property
			symbol_219.setLower(BigInteger.valueOf(0));
			symbol_219.setUpper(BigInteger.valueOf(-1));
			
			symbol_219.setIsResolveProxies(true);
			symbol_219.setOpposite(symbol_205);
			symbol_203.getOwnedAttributes().add(symbol_219);
		}
		{ // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
			symbol_220.setName("opposite");
			symbol_220.setType(symbol_203);  // pivot!Property
			symbol_220.setLower(BigInteger.valueOf(0));
			
			symbol_220.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_220);
		}
		symbol_1.getOwnedTypes().add(symbol_203);
		//
		// pivot.ecore::pivot::PropertyCallExp pivot!PropertyCallExp
		//
		symbol_221.setName("PropertyCallExp");
		//symbol_221.setMoniker("pivot!PropertyCallExp");
		symbol_221.getSuperClasses().add(symbol_141); // pivot!NavigationCallExp
		{ // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
			symbol_222.setName("referredProperty");
			symbol_222.setType(symbol_203);  // pivot!Property
			symbol_222.setLower(BigInteger.valueOf(0));
			
			symbol_222.setIsResolveProxies(true);
			symbol_222.setOpposite(symbol_206);
			symbol_221.getOwnedAttributes().add(symbol_222);
		}
		symbol_1.getOwnedTypes().add(symbol_221);
		//
		// pivot.ecore::pivot::RealLiteralExp pivot!RealLiteralExp
		//
		symbol_224.setName("RealLiteralExp");
		//symbol_224.setMoniker("pivot!RealLiteralExp");
		symbol_224.getSuperClasses().add(symbol_145); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
			symbol_225.setName("realSymbol");
			symbol_225.setType(symbol_223);  // pivot!Real
			
			symbol_225.setIsResolveProxies(true);
			symbol_224.getOwnedAttributes().add(symbol_225);
		}
		symbol_1.getOwnedTypes().add(symbol_224);
		//
		// pivot.ecore::pivot::SendSignalAction pivot!SendSignalAction
		//
		symbol_226.setName("SendSignalAction");
		//symbol_226.setMoniker("pivot!SendSignalAction");
		symbol_226.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::SendSignalAction::MessageExp pivot!SendSignalAction!MessageExp
			symbol_227.setName("MessageExp");
			symbol_227.setType(symbol_118);  // pivot!MessageExp
			symbol_227.setLower(BigInteger.valueOf(0));
			
			symbol_227.setImplicit(true);
			symbol_227.setIsResolveProxies(true);
			symbol_227.setOpposite(symbol_121);
			symbol_226.getOwnedAttributes().add(symbol_227);
		}
		{ // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
			symbol_228.setName("signal");
			symbol_228.setType(symbol_231);  // pivot!Signal
			
			symbol_228.setIsResolveProxies(true);
			symbol_228.setOpposite(symbol_233);
			symbol_226.getOwnedAttributes().add(symbol_228);
		}
		symbol_1.getOwnedTypes().add(symbol_226);
		//
		// pivot.ecore::pivot::SequenceType pivot!SequenceType
		//
		symbol_229.setName("SequenceType");
		//symbol_229.setMoniker("pivot!SequenceType");
		symbol_229.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_229);
		//
		// pivot.ecore::pivot::SetType pivot!SetType
		//
		symbol_230.setName("SetType");
		//symbol_230.setMoniker("pivot!SetType");
		symbol_230.getSuperClasses().add(symbol_46); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_230);
		//
		// pivot.ecore::pivot::Signal pivot!Signal
		//
		symbol_231.setName("Signal");
		//symbol_231.setMoniker("pivot!Signal");
		symbol_231.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::Signal::MessageType pivot!Signal!MessageType
			symbol_232.setName("MessageType");
			symbol_232.setType(symbol_123);  // pivot!MessageType
			symbol_232.setLower(BigInteger.valueOf(0));
			symbol_232.setUpper(BigInteger.valueOf(-1));
			
			symbol_232.setImplicit(true);
			symbol_232.setIsResolveProxies(true);
			symbol_232.setOpposite(symbol_125);
			symbol_231.getOwnedAttributes().add(symbol_232);
		}
		{ // pivot.ecore::pivot::Signal::SendSignalAction pivot!Signal!SendSignalAction
			symbol_233.setName("SendSignalAction");
			symbol_233.setType(symbol_226);  // pivot!SendSignalAction
			symbol_233.setLower(BigInteger.valueOf(0));
			symbol_233.setUpper(BigInteger.valueOf(-1));
			
			symbol_233.setImplicit(true);
			symbol_233.setIsResolveProxies(true);
			symbol_233.setOpposite(symbol_228);
			symbol_231.getOwnedAttributes().add(symbol_233);
		}
		symbol_1.getOwnedTypes().add(symbol_231);
		//
		// pivot.ecore::pivot::State pivot!State
		//
		symbol_234.setName("State");
		//symbol_234.setMoniker("pivot!State");
		symbol_234.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::State::StateExp pivot!State!StateExp
			symbol_235.setName("StateExp");
			symbol_235.setType(symbol_236);  // pivot!StateExp
			symbol_235.setLower(BigInteger.valueOf(0));
			symbol_235.setUpper(BigInteger.valueOf(-1));
			
			symbol_235.setImplicit(true);
			symbol_235.setIsResolveProxies(true);
			symbol_235.setOpposite(symbol_237);
			symbol_234.getOwnedAttributes().add(symbol_235);
		}
		symbol_1.getOwnedTypes().add(symbol_234);
		//
		// pivot.ecore::pivot::StateExp pivot!StateExp
		//
		symbol_236.setName("StateExp");
		//symbol_236.setMoniker("pivot!StateExp");
		symbol_236.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
			symbol_237.setName("referredState");
			symbol_237.setType(symbol_234);  // pivot!State
			symbol_237.setLower(BigInteger.valueOf(0));
			
			symbol_237.setIsResolveProxies(true);
			symbol_237.setOpposite(symbol_235);
			symbol_236.getOwnedAttributes().add(symbol_237);
		}
		symbol_1.getOwnedTypes().add(symbol_236);
		//
		// pivot.ecore::pivot::StringLiteralExp pivot!StringLiteralExp
		//
		symbol_239.setName("StringLiteralExp");
		//symbol_239.setMoniker("pivot!StringLiteralExp");
		symbol_239.getSuperClasses().add(symbol_201); // pivot!PrimitiveLiteralExp
		{ // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
			symbol_240.setName("stringSymbol");
			symbol_240.setType(symbol_238);  // pivot!String
			
			symbol_240.setIsResolveProxies(true);
			symbol_239.getOwnedAttributes().add(symbol_240);
		}
		symbol_1.getOwnedTypes().add(symbol_239);
		//
		// pivot.ecore::pivot::TemplateBinding pivot!TemplateBinding
		//
		symbol_241.setName("TemplateBinding");
		//symbol_241.setMoniker("pivot!TemplateBinding");
		symbol_241.getSuperClasses().add(symbol_64); // pivot!Element
		{ // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
			symbol_242.setName("boundElement");
			symbol_242.setType(symbol_265);  // pivot!TemplateableElement
			
			symbol_242.setIsResolveProxies(true);
			symbol_242.setOpposite(symbol_267);
			symbol_241.getOwnedAttributes().add(symbol_242);
		}
		{ // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
			symbol_243.setName("parameterSubstitution");
			symbol_243.setType(symbol_253);  // pivot!TemplateParameterSubstitution
			symbol_243.setLower(BigInteger.valueOf(0));
			symbol_243.setUpper(BigInteger.valueOf(-1));
			
			symbol_243.setIsComposite(true);
			symbol_243.setIsResolveProxies(true);
			symbol_243.setOpposite(symbol_257);
			symbol_241.getOwnedAttributes().add(symbol_243);
		}
		{ // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
			symbol_244.setName("signature");
			symbol_244.setType(symbol_260);  // pivot!TemplateSignature
			
			symbol_244.setIsResolveProxies(true);
			symbol_244.setOpposite(symbol_261);
			symbol_241.getOwnedAttributes().add(symbol_244);
		}
		symbol_1.getOwnedTypes().add(symbol_241);
		//
		// pivot.ecore::pivot::TemplateParameter pivot!TemplateParameter
		//
		symbol_245.setName("TemplateParameter");
		//symbol_245.setMoniker("pivot!TemplateParameter");
		symbol_245.getSuperClasses().add(symbol_64); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameter::TemplateParameterSubstitution pivot!TemplateParameter!TemplateParameterSubstitution
			symbol_246.setName("TemplateParameterSubstitution");
			symbol_246.setType(symbol_253);  // pivot!TemplateParameterSubstitution
			symbol_246.setLower(BigInteger.valueOf(0));
			symbol_246.setUpper(BigInteger.valueOf(-1));
			
			symbol_246.setImplicit(true);
			symbol_246.setIsResolveProxies(true);
			symbol_246.setOpposite(symbol_255);
			symbol_245.getOwnedAttributes().add(symbol_246);
		}
		{ // pivot.ecore::pivot::TemplateParameter::TemplateSignature pivot!TemplateParameter!TemplateSignature
			symbol_247.setName("TemplateSignature");
			symbol_247.setType(symbol_260);  // pivot!TemplateSignature
			symbol_247.setLower(BigInteger.valueOf(0));
			symbol_247.setUpper(BigInteger.valueOf(-1));
			
			symbol_247.setImplicit(true);
			symbol_247.setIsResolveProxies(true);
			symbol_247.setOpposite(symbol_263);
			symbol_245.getOwnedAttributes().add(symbol_247);
		}
		{ // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
			symbol_248.setName("default");
			symbol_248.setType(symbol_190);  // pivot!ParameterableElement
			symbol_248.setLower(BigInteger.valueOf(0));
			
			symbol_248.setIsResolveProxies(true);
			symbol_245.getOwnedAttributes().add(symbol_248);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
			symbol_249.setName("ownedDefault");
			symbol_249.setType(symbol_190);  // pivot!ParameterableElement
			symbol_249.setLower(BigInteger.valueOf(0));
			
			symbol_249.setIsComposite(true);
			symbol_249.setIsResolveProxies(true);
			symbol_249.setOpposite(symbol_191);
			symbol_245.getOwnedAttributes().add(symbol_249);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
			symbol_250.setName("ownedParameteredElement");
			symbol_250.setType(symbol_190);  // pivot!ParameterableElement
			symbol_250.setLower(BigInteger.valueOf(0));
			
			symbol_250.setIsComposite(true);
			symbol_250.setIsResolveProxies(true);
			symbol_250.setOpposite(symbol_193);
			symbol_245.getOwnedAttributes().add(symbol_250);
		}
		{ // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
			symbol_251.setName("parameteredElement");
			symbol_251.setType(symbol_190);  // pivot!ParameterableElement
			
			symbol_251.setIsResolveProxies(true);
			symbol_251.setOpposite(symbol_194);
			symbol_245.getOwnedAttributes().add(symbol_251);
		}
		{ // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
			symbol_252.setName("signature");
			symbol_252.setType(symbol_260);  // pivot!TemplateSignature
			
			symbol_252.setIsResolveProxies(true);
			symbol_252.setOpposite(symbol_262);
			symbol_245.getOwnedAttributes().add(symbol_252);
		}
		symbol_1.getOwnedTypes().add(symbol_245);
		//
		// pivot.ecore::pivot::TemplateParameterSubstitution pivot!TemplateParameterSubstitution
		//
		symbol_253.setName("TemplateParameterSubstitution");
		//symbol_253.setMoniker("pivot!TemplateParameterSubstitution");
		symbol_253.getSuperClasses().add(symbol_64); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
			symbol_254.setName("actual");
			symbol_254.setType(symbol_190);  // pivot!ParameterableElement
			
			symbol_254.setIsResolveProxies(true);
			symbol_253.getOwnedAttributes().add(symbol_254);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
			symbol_255.setName("formal");
			symbol_255.setType(symbol_245);  // pivot!TemplateParameter
			
			symbol_255.setIsResolveProxies(true);
			symbol_255.setOpposite(symbol_246);
			symbol_253.getOwnedAttributes().add(symbol_255);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
			symbol_256.setName("ownedActual");
			symbol_256.setType(symbol_190);  // pivot!ParameterableElement
			symbol_256.setLower(BigInteger.valueOf(0));
			
			symbol_256.setIsComposite(true);
			symbol_256.setIsResolveProxies(true);
			symbol_256.setOpposite(symbol_192);
			symbol_253.getOwnedAttributes().add(symbol_256);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
			symbol_257.setName("templateBinding");
			symbol_257.setType(symbol_241);  // pivot!TemplateBinding
			
			symbol_257.setIsResolveProxies(true);
			symbol_257.setOpposite(symbol_243);
			symbol_253.getOwnedAttributes().add(symbol_257);
		}
		symbol_1.getOwnedTypes().add(symbol_253);
		//
		// pivot.ecore::pivot::TemplateParameterType pivot!TemplateParameterType
		//
		symbol_258.setName("TemplateParameterType");
		//symbol_258.setMoniker("pivot!TemplateParameterType");
		symbol_258.getSuperClasses().add(symbol_276); // pivot!Type
		{ // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
			symbol_259.setName("specification");
			symbol_259.setType(symbol_238);  // pivot!String
			symbol_259.setLower(BigInteger.valueOf(0));
			
			symbol_259.setIsResolveProxies(true);
			symbol_258.getOwnedAttributes().add(symbol_259);
		}
		symbol_1.getOwnedTypes().add(symbol_258);
		//
		// pivot.ecore::pivot::TemplateSignature pivot!TemplateSignature
		//
		symbol_260.setName("TemplateSignature");
		//symbol_260.setMoniker("pivot!TemplateSignature");
		symbol_260.getSuperClasses().add(symbol_126); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateSignature::TemplateBinding pivot!TemplateSignature!TemplateBinding
			symbol_261.setName("TemplateBinding");
			symbol_261.setType(symbol_241);  // pivot!TemplateBinding
			symbol_261.setLower(BigInteger.valueOf(0));
			symbol_261.setUpper(BigInteger.valueOf(-1));
			
			symbol_261.setImplicit(true);
			symbol_261.setIsResolveProxies(true);
			symbol_261.setOpposite(symbol_244);
			symbol_260.getOwnedAttributes().add(symbol_261);
		}
		{ // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
			symbol_262.setName("ownedParameter");
			symbol_262.setType(symbol_245);  // pivot!TemplateParameter
			symbol_262.setLower(BigInteger.valueOf(0));
			symbol_262.setUpper(BigInteger.valueOf(-1));
			symbol_262.setIsOrdered(true);
			
			symbol_262.setIsComposite(true);
			symbol_262.setIsResolveProxies(true);
			symbol_262.setOpposite(symbol_252);
			symbol_260.getOwnedAttributes().add(symbol_262);
		}
		{ // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
			symbol_263.setName("parameter");
			symbol_263.setType(symbol_245);  // pivot!TemplateParameter
			symbol_263.setUpper(BigInteger.valueOf(-1));
			symbol_263.setIsOrdered(true);
			
			symbol_263.setIsResolveProxies(true);
			symbol_263.setOpposite(symbol_247);
			symbol_260.getOwnedAttributes().add(symbol_263);
		}
		{ // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
			symbol_264.setName("template");
			symbol_264.setType(symbol_265);  // pivot!TemplateableElement
			
			symbol_264.setIsResolveProxies(true);
			symbol_264.setOpposite(symbol_266);
			symbol_260.getOwnedAttributes().add(symbol_264);
		}
		symbol_1.getOwnedTypes().add(symbol_260);
		//
		// pivot.ecore::pivot::TemplateableElement pivot!TemplateableElement
		//
		symbol_265.setName("TemplateableElement");
		//symbol_265.setMoniker("pivot!TemplateableElement");
		symbol_265.getSuperClasses().add(symbol_126); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
			symbol_266.setName("ownedTemplateSignature");
			symbol_266.setType(symbol_260);  // pivot!TemplateSignature
			symbol_266.setLower(BigInteger.valueOf(0));
			
			symbol_266.setIsComposite(true);
			symbol_266.setIsResolveProxies(true);
			symbol_266.setOpposite(symbol_264);
			symbol_265.getOwnedAttributes().add(symbol_266);
		}
		{ // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
			symbol_267.setName("templateBinding");
			symbol_267.setType(symbol_241);  // pivot!TemplateBinding
			symbol_267.setLower(BigInteger.valueOf(0));
			symbol_267.setUpper(BigInteger.valueOf(-1));
			
			symbol_267.setIsComposite(true);
			symbol_267.setIsResolveProxies(true);
			symbol_267.setOpposite(symbol_242);
			symbol_265.getOwnedAttributes().add(symbol_267);
		}
		{ // pivot.ecore::pivot::TemplateableElement::unspecializedElement pivot!TemplateableElement!unspecializedElement
			symbol_268.setName("unspecializedElement");
			symbol_268.setType(symbol_265);  // pivot!TemplateableElement
			symbol_268.setLower(BigInteger.valueOf(0));
			
			symbol_268.setIsTransient(true);
			symbol_265.getOwnedAttributes().add(symbol_268);
		}
		{	// pivot.ecore::pivot::TemplateableElement::isTemplate() pivot!TemplateableElement!isTemplate()
			Operation symbol_342 = PivotFactory.eINSTANCE.createOperation();
			symbol_342.setName("isTemplate");
			//symbol_342.setMoniker("pivot!TemplateableElement!isTemplate()");
			symbol_342.setType(symbol_15);  // pivot!Boolean
			
			symbol_265.getOwnedOperations().add(symbol_342);
		}
		{	// pivot.ecore::pivot::TemplateableElement::parameterableElements() pivot!TemplateableElement!parameterableElements()
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_343.setName("parameterableElements");
			//symbol_343.setMoniker("pivot!TemplateableElement!parameterableElements()");
			symbol_343.setType(symbol_190);  // pivot!ParameterableElement
			symbol_343.setLower(BigInteger.valueOf(0));
			symbol_343.setUpper(BigInteger.valueOf(-1));
			
			symbol_265.getOwnedOperations().add(symbol_343);
		}
		symbol_1.getOwnedTypes().add(symbol_265);
		//
		// pivot.ecore::pivot::Throwable pivot!Throwable
		//
		symbol_269.setName("Throwable");
		//symbol_269.setMoniker("pivot!Throwable");
		symbol_1.getOwnedTypes().add(symbol_269);
		//
		// pivot.ecore::pivot::TupleLiteralExp pivot!TupleLiteralExp
		//
		symbol_270.setName("TupleLiteralExp");
		//symbol_270.setMoniker("pivot!TupleLiteralExp");
		symbol_270.getSuperClasses().add(symbol_113); // pivot!LiteralExp
		{ // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
			symbol_271.setName("part");
			symbol_271.setType(symbol_272);  // pivot!TupleLiteralPart
			symbol_271.setLower(BigInteger.valueOf(0));
			symbol_271.setUpper(BigInteger.valueOf(-1));
			symbol_271.setIsOrdered(true);
			
			symbol_271.setIsComposite(true);
			symbol_271.setIsResolveProxies(true);
			symbol_271.setOpposite(symbol_273);
			symbol_270.getOwnedAttributes().add(symbol_271);
		}
		symbol_1.getOwnedTypes().add(symbol_270);
		//
		// pivot.ecore::pivot::TupleLiteralPart pivot!TupleLiteralPart
		//
		symbol_272.setName("TupleLiteralPart");
		//symbol_272.setMoniker("pivot!TupleLiteralPart");
		symbol_272.getSuperClasses().add(symbol_313); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::TupleLiteralPart::TupleLiteralExp pivot!TupleLiteralPart!TupleLiteralExp
			symbol_273.setName("TupleLiteralExp");
			symbol_273.setType(symbol_270);  // pivot!TupleLiteralExp
			symbol_273.setLower(BigInteger.valueOf(0));
			
			symbol_273.setImplicit(true);
			symbol_273.setIsResolveProxies(true);
			symbol_273.setOpposite(symbol_271);
			symbol_272.getOwnedAttributes().add(symbol_273);
		}
		{ // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
			symbol_274.setName("initExpression");
			symbol_274.setType(symbol_147);  // pivot!OclExpression
			symbol_274.setLower(BigInteger.valueOf(0));
			
			symbol_274.setIsComposite(true);
			symbol_274.setIsResolveProxies(true);
			symbol_274.setOpposite(symbol_158);
			symbol_272.getOwnedAttributes().add(symbol_274);
		}
		symbol_1.getOwnedTypes().add(symbol_272);
		//
		// pivot.ecore::pivot::TupleType pivot!TupleType
		//
		symbol_275.setName("TupleType");
		//symbol_275.setMoniker("pivot!TupleType");
		symbol_275.getSuperClasses().add(symbol_58); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_275);
		//
		// pivot.ecore::pivot::Type pivot!Type
		//
		symbol_276.setName("Type");
		//symbol_276.setMoniker("pivot!Type");
		symbol_276.getSuperClasses().add(symbol_190); // pivot!ParameterableElement
		symbol_276.getSuperClasses().add(symbol_134); // pivot!NamedElement
		symbol_276.getSuperClasses().add(symbol_265); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Type::ClassifierType pivot!Type!ClassifierType
			symbol_277.setName("ClassifierType");
			symbol_277.setType(symbol_33);  // pivot!ClassifierType
			symbol_277.setLower(BigInteger.valueOf(0));
			symbol_277.setUpper(BigInteger.valueOf(-1));
			
			symbol_277.setImplicit(true);
			symbol_277.setIsResolveProxies(true);
			symbol_277.setOpposite(symbol_34);
			symbol_276.getOwnedAttributes().add(symbol_277);
		}
		{ // pivot.ecore::pivot::Type::CollectionType pivot!Type!CollectionType
			symbol_278.setName("CollectionType");
			symbol_278.setType(symbol_46);  // pivot!CollectionType
			symbol_278.setLower(BigInteger.valueOf(0));
			symbol_278.setUpper(BigInteger.valueOf(-1));
			
			symbol_278.setImplicit(true);
			symbol_278.setIsResolveProxies(true);
			symbol_278.setOpposite(symbol_47);
			symbol_276.getOwnedAttributes().add(symbol_278);
		}
		{ // pivot.ecore::pivot::Type::DataType pivot!Type!DataType
			symbol_279.setName("DataType");
			symbol_279.setType(symbol_58);  // pivot!DataType
			symbol_279.setLower(BigInteger.valueOf(0));
			symbol_279.setUpper(BigInteger.valueOf(-1));
			
			symbol_279.setImplicit(true);
			symbol_279.setIsResolveProxies(true);
			symbol_279.setOpposite(symbol_59);
			symbol_276.getOwnedAttributes().add(symbol_279);
		}
		{ // pivot.ecore::pivot::Type::LambdaType pivot!Type!LambdaType
			symbol_280.setName("LambdaType");
			symbol_280.setType(symbol_105);  // pivot!LambdaType
			symbol_280.setLower(BigInteger.valueOf(0));
			symbol_280.setUpper(BigInteger.valueOf(-1));
			
			symbol_280.setImplicit(true);
			symbol_280.setIsResolveProxies(true);
			symbol_276.getOwnedAttributes().add(symbol_280);
		}
		{ // pivot.ecore::pivot::Type::Operation pivot!Type!Operation
			symbol_281.setName("Operation");
			symbol_281.setType(symbol_165);  // pivot!Operation
			symbol_281.setLower(BigInteger.valueOf(0));
			symbol_281.setUpper(BigInteger.valueOf(-1));
			
			symbol_281.setImplicit(true);
			symbol_281.setIsResolveProxies(true);
			symbol_281.setOpposite(symbol_172);
			symbol_276.getOwnedAttributes().add(symbol_281);
		}
		{ // pivot.ecore::pivot::Type::TypeExp pivot!Type!TypeExp
			symbol_282.setName("TypeExp");
			symbol_282.setType(symbol_288);  // pivot!TypeExp
			symbol_282.setLower(BigInteger.valueOf(0));
			symbol_282.setUpper(BigInteger.valueOf(-1));
			
			symbol_282.setImplicit(true);
			symbol_282.setIsResolveProxies(true);
			symbol_282.setOpposite(symbol_289);
			symbol_276.getOwnedAttributes().add(symbol_282);
		}
		{ // pivot.ecore::pivot::Type::TypeTemplateParameter pivot!Type!TypeTemplateParameter
			symbol_283.setName("TypeTemplateParameter");
			symbol_283.setType(symbol_290);  // pivot!TypeTemplateParameter
			symbol_283.setLower(BigInteger.valueOf(0));
			symbol_283.setUpper(BigInteger.valueOf(-1));
			
			symbol_283.setImplicit(true);
			symbol_283.setIsResolveProxies(true);
			symbol_283.setOpposite(symbol_292);
			symbol_276.getOwnedAttributes().add(symbol_283);
		}
		{ // pivot.ecore::pivot::Type::TypedElement pivot!Type!TypedElement
			symbol_284.setName("TypedElement");
			symbol_284.setType(symbol_293);  // pivot!TypedElement
			symbol_284.setLower(BigInteger.valueOf(0));
			symbol_284.setUpper(BigInteger.valueOf(-1));
			
			symbol_284.setImplicit(true);
			symbol_284.setIsResolveProxies(true);
			symbol_284.setOpposite(symbol_294);
			symbol_276.getOwnedAttributes().add(symbol_284);
		}
		{ // pivot.ecore::pivot::Type::UnspecifiedType pivot!Type!UnspecifiedType
			symbol_285.setName("UnspecifiedType");
			symbol_285.setType(symbol_299);  // pivot!UnspecifiedType
			symbol_285.setLower(BigInteger.valueOf(0));
			symbol_285.setUpper(BigInteger.valueOf(-1));
			
			symbol_285.setImplicit(true);
			symbol_285.setIsResolveProxies(true);
			symbol_276.getOwnedAttributes().add(symbol_285);
		}
		{ // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
			symbol_286.setName("instanceClassName");
			symbol_286.setType(symbol_238);  // pivot!String
			symbol_286.setLower(BigInteger.valueOf(0));
			
			symbol_286.setIsResolveProxies(true);
			symbol_276.getOwnedAttributes().add(symbol_286);
		}
		{ // pivot.ecore::pivot::Type::package pivot!Type!package
			symbol_287.setName("package");
			symbol_287.setType(symbol_178);  // pivot!Package
			symbol_287.setLower(BigInteger.valueOf(0));
			
			symbol_287.setIsResolveProxies(true);
			symbol_287.setOpposite(symbol_184);
			symbol_276.getOwnedAttributes().add(symbol_287);
		}
		symbol_1.getOwnedTypes().add(symbol_276);
		//
		// pivot.ecore::pivot::TypeExp pivot!TypeExp
		//
		symbol_288.setName("TypeExp");
		//symbol_288.setMoniker("pivot!TypeExp");
		symbol_288.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
			symbol_289.setName("referredType");
			symbol_289.setType(symbol_276);  // pivot!Type
			symbol_289.setLower(BigInteger.valueOf(0));
			
			symbol_289.setIsResolveProxies(true);
			symbol_289.setOpposite(symbol_282);
			symbol_288.getOwnedAttributes().add(symbol_289);
		}
		symbol_1.getOwnedTypes().add(symbol_288);
		//
		// pivot.ecore::pivot::TypeTemplateParameter pivot!TypeTemplateParameter
		//
		symbol_290.setName("TypeTemplateParameter");
		//symbol_290.setMoniker("pivot!TypeTemplateParameter");
		symbol_290.getSuperClasses().add(symbol_245); // pivot!TemplateParameter
		{ // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
			symbol_291.setName("allowSubstitutable");
			symbol_291.setType(symbol_15);  // pivot!Boolean
			
			symbol_291.setIsResolveProxies(true);
			symbol_290.getOwnedAttributes().add(symbol_291);
		}
		{ // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
			symbol_292.setName("constrainingType");
			symbol_292.setType(symbol_276);  // pivot!Type
			symbol_292.setLower(BigInteger.valueOf(0));
			symbol_292.setUpper(BigInteger.valueOf(-1));
			
			symbol_292.setIsResolveProxies(true);
			symbol_292.setOpposite(symbol_283);
			symbol_290.getOwnedAttributes().add(symbol_292);
		}
		symbol_1.getOwnedTypes().add(symbol_290);
		//
		// pivot.ecore::pivot::TypedElement pivot!TypedElement
		//
		symbol_293.setName("TypedElement");
		//symbol_293.setMoniker("pivot!TypedElement");
		symbol_293.getSuperClasses().add(symbol_134); // pivot!NamedElement
		{ // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
			symbol_294.setName("type");
			symbol_294.setType(symbol_276);  // pivot!Type
			symbol_294.setLower(BigInteger.valueOf(0));
			
			symbol_294.setIsResolveProxies(true);
			symbol_294.setOpposite(symbol_284);
			symbol_293.getOwnedAttributes().add(symbol_294);
		}
		symbol_1.getOwnedTypes().add(symbol_293);
		//
		// pivot.ecore::pivot::TypedMultiplicityElement pivot!TypedMultiplicityElement
		//
		symbol_295.setName("TypedMultiplicityElement");
		//symbol_295.setMoniker("pivot!TypedMultiplicityElement");
		symbol_295.getSuperClasses().add(symbol_128); // pivot!MultiplicityElement
		symbol_295.getSuperClasses().add(symbol_293); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_295);
		//
		// pivot.ecore::pivot::UnlimitedNaturalLiteralExp pivot!UnlimitedNaturalLiteralExp
		//
		symbol_297.setName("UnlimitedNaturalLiteralExp");
		//symbol_297.setMoniker("pivot!UnlimitedNaturalLiteralExp");
		symbol_297.getSuperClasses().add(symbol_145); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
			symbol_298.setName("unlimitedNaturalSymbol");
			symbol_298.setType(symbol_296);  // pivot!UnlimitedNatural
			
			symbol_298.setIsResolveProxies(true);
			symbol_297.getOwnedAttributes().add(symbol_298);
		}
		symbol_1.getOwnedTypes().add(symbol_297);
		//
		// pivot.ecore::pivot::UnspecifiedType pivot!UnspecifiedType
		//
		symbol_299.setName("UnspecifiedType");
		//symbol_299.setMoniker("pivot!UnspecifiedType");
		symbol_299.getSuperClasses().add(symbol_25); // pivot!Class
		{ // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
			symbol_300.setName("lowerBound");
			symbol_300.setType(symbol_276);  // pivot!Type
			
			symbol_300.setIsResolveProxies(true);
			symbol_300.setOpposite(symbol_285);
			symbol_299.getOwnedAttributes().add(symbol_300);
		}
		{ // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
			symbol_301.setName("upperBound");
			symbol_301.setType(symbol_276);  // pivot!Type
			
			symbol_301.setIsResolveProxies(true);
			symbol_299.getOwnedAttributes().add(symbol_301);
		}
		symbol_1.getOwnedTypes().add(symbol_299);
		//
		// pivot.ecore::pivot::UnspecifiedValueExp pivot!UnspecifiedValueExp
		//
		symbol_302.setName("UnspecifiedValueExp");
		//symbol_302.setMoniker("pivot!UnspecifiedValueExp");
		symbol_302.getSuperClasses().add(symbol_147); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_302);
		//
		// pivot.ecore::pivot::ValueSpecification pivot!ValueSpecification
		//
		symbol_303.setName("ValueSpecification");
		//symbol_303.setMoniker("pivot!ValueSpecification");
		symbol_303.getSuperClasses().add(symbol_190); // pivot!ParameterableElement
		symbol_303.getSuperClasses().add(symbol_293); // pivot!TypedElement
		{ // pivot.ecore::pivot::ValueSpecification::Constraint pivot!ValueSpecification!Constraint
			symbol_304.setName("Constraint");
			symbol_304.setType(symbol_52);  // pivot!Constraint
			symbol_304.setLower(BigInteger.valueOf(0));
			
			symbol_304.setImplicit(true);
			symbol_304.setIsResolveProxies(true);
			symbol_304.setOpposite(symbol_56);
			symbol_303.getOwnedAttributes().add(symbol_304);
		}
		{	// pivot.ecore::pivot::ValueSpecification::booleanValue() pivot!ValueSpecification!booleanValue()
			Operation symbol_344 = PivotFactory.eINSTANCE.createOperation();
			symbol_344.setName("booleanValue");
			//symbol_344.setMoniker("pivot!ValueSpecification!booleanValue()");
			symbol_344.setType(symbol_15);  // pivot!Boolean
			
			symbol_303.getOwnedOperations().add(symbol_344);
		}
		{	// pivot.ecore::pivot::ValueSpecification::integerValue() pivot!ValueSpecification!integerValue()
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_345.setName("integerValue");
			//symbol_345.setMoniker("pivot!ValueSpecification!integerValue()");
			symbol_345.setType(symbol_93);  // pivot!Integer
			
			symbol_303.getOwnedOperations().add(symbol_345);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isComputable() pivot!ValueSpecification!isComputable()
			Operation symbol_346 = PivotFactory.eINSTANCE.createOperation();
			symbol_346.setName("isComputable");
			//symbol_346.setMoniker("pivot!ValueSpecification!isComputable()");
			symbol_346.setType(symbol_15);  // pivot!Boolean
			
			symbol_303.getOwnedOperations().add(symbol_346);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isNull() pivot!ValueSpecification!isNull()
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("isNull");
			//symbol_347.setMoniker("pivot!ValueSpecification!isNull()");
			symbol_347.setType(symbol_15);  // pivot!Boolean
			
			symbol_303.getOwnedOperations().add(symbol_347);
		}
		{	// pivot.ecore::pivot::ValueSpecification::stringValue() pivot!ValueSpecification!stringValue()
			Operation symbol_348 = PivotFactory.eINSTANCE.createOperation();
			symbol_348.setName("stringValue");
			//symbol_348.setMoniker("pivot!ValueSpecification!stringValue()");
			symbol_348.setType(symbol_238);  // pivot!String
			
			symbol_303.getOwnedOperations().add(symbol_348);
		}
		{	// pivot.ecore::pivot::ValueSpecification::unlimitedValue() pivot!ValueSpecification!unlimitedValue()
			Operation symbol_349 = PivotFactory.eINSTANCE.createOperation();
			symbol_349.setName("unlimitedValue");
			//symbol_349.setMoniker("pivot!ValueSpecification!unlimitedValue()");
			symbol_349.setType(symbol_296);  // pivot!UnlimitedNatural
			
			symbol_303.getOwnedOperations().add(symbol_349);
		}
		symbol_1.getOwnedTypes().add(symbol_303);
		//
		// pivot.ecore::pivot::Variable pivot!Variable
		//
		symbol_305.setName("Variable");
		//symbol_305.setMoniker("pivot!Variable");
		symbol_305.getSuperClasses().add(symbol_313); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Variable::ExpressionInOcl pivot!Variable!ExpressionInOcl
			symbol_306.setName("ExpressionInOcl");
			symbol_306.setType(symbol_77);  // pivot!ExpressionInOcl
			symbol_306.setLower(BigInteger.valueOf(0));
			symbol_306.setUpper(BigInteger.valueOf(-1));
			
			symbol_306.setImplicit(true);
			symbol_306.setIsResolveProxies(true);
			symbol_305.getOwnedAttributes().add(symbol_306);
		}
		{ // pivot.ecore::pivot::Variable::IterateExp pivot!Variable!IterateExp
			symbol_307.setName("IterateExp");
			symbol_307.setType(symbol_98);  // pivot!IterateExp
			symbol_307.setLower(BigInteger.valueOf(0));
			
			symbol_307.setImplicit(true);
			symbol_307.setIsResolveProxies(true);
			symbol_307.setOpposite(symbol_99);
			symbol_305.getOwnedAttributes().add(symbol_307);
		}
		{ // pivot.ecore::pivot::Variable::LetExp pivot!Variable!LetExp
			symbol_308.setName("LetExp");
			symbol_308.setType(symbol_109);  // pivot!LetExp
			symbol_308.setLower(BigInteger.valueOf(0));
			
			symbol_308.setImplicit(true);
			symbol_308.setIsResolveProxies(true);
			symbol_308.setOpposite(symbol_111);
			symbol_305.getOwnedAttributes().add(symbol_308);
		}
		{ // pivot.ecore::pivot::Variable::LoopExp pivot!Variable!LoopExp
			symbol_309.setName("LoopExp");
			symbol_309.setType(symbol_114);  // pivot!LoopExp
			symbol_309.setLower(BigInteger.valueOf(0));
			
			symbol_309.setImplicit(true);
			symbol_309.setIsResolveProxies(true);
			symbol_309.setOpposite(symbol_116);
			symbol_305.getOwnedAttributes().add(symbol_309);
		}
		{ // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
			symbol_310.setName("implicit");
			symbol_310.setType(symbol_15);  // pivot!Boolean
			symbol_310.setLower(BigInteger.valueOf(0));
			
			symbol_310.setIsResolveProxies(true);
			symbol_305.getOwnedAttributes().add(symbol_310);
		}
		{ // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
			symbol_311.setName("initExpression");
			symbol_311.setType(symbol_147);  // pivot!OclExpression
			symbol_311.setLower(BigInteger.valueOf(0));
			
			symbol_311.setIsComposite(true);
			symbol_311.setIsResolveProxies(true);
			symbol_311.setOpposite(symbol_159);
			symbol_305.getOwnedAttributes().add(symbol_311);
		}
		{ // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
			symbol_312.setName("representedParameter");
			symbol_312.setType(symbol_186);  // pivot!Parameter
			symbol_312.setLower(BigInteger.valueOf(0));
			
			symbol_312.setIsResolveProxies(true);
			symbol_312.setOpposite(symbol_188);
			symbol_305.getOwnedAttributes().add(symbol_312);
		}
		symbol_1.getOwnedTypes().add(symbol_305);
		//
		// pivot.ecore::pivot::VariableDeclaration pivot!VariableDeclaration
		//
		symbol_313.setName("VariableDeclaration");
		//symbol_313.setMoniker("pivot!VariableDeclaration");
		symbol_313.getSuperClasses().add(symbol_293); // pivot!TypedElement
		{ // pivot.ecore::pivot::VariableDeclaration::VariableExp pivot!VariableDeclaration!VariableExp
			symbol_314.setName("VariableExp");
			symbol_314.setType(symbol_315);  // pivot!VariableExp
			symbol_314.setLower(BigInteger.valueOf(0));
			symbol_314.setUpper(BigInteger.valueOf(-1));
			
			symbol_314.setImplicit(true);
			symbol_314.setIsResolveProxies(true);
			symbol_314.setOpposite(symbol_317);
			symbol_313.getOwnedAttributes().add(symbol_314);
		}
		symbol_1.getOwnedTypes().add(symbol_313);
		//
		// pivot.ecore::pivot::VariableExp pivot!VariableExp
		//
		symbol_315.setName("VariableExp");
		//symbol_315.setMoniker("pivot!VariableExp");
		symbol_315.getSuperClasses().add(symbol_147); // pivot!OclExpression
		{ // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
			symbol_316.setName("implicit");
			symbol_316.setType(symbol_15);  // pivot!Boolean
			symbol_316.setLower(BigInteger.valueOf(0));
			
			symbol_316.setIsResolveProxies(true);
			symbol_315.getOwnedAttributes().add(symbol_316);
		}
		{ // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
			symbol_317.setName("referredVariable");
			symbol_317.setType(symbol_313);  // pivot!VariableDeclaration
			symbol_317.setLower(BigInteger.valueOf(0));
			
			symbol_317.setIsResolveProxies(true);
			symbol_317.setOpposite(symbol_314);
			symbol_315.getOwnedAttributes().add(symbol_317);
		}
		symbol_1.getOwnedTypes().add(symbol_315);
		//
		// pivot.ecore::pivot::Visitable pivot!Visitable
		//
		symbol_318.setName("Visitable");
		//symbol_318.setMoniker("pivot!Visitable");
		symbol_1.getOwnedTypes().add(symbol_318);
		//
		// pivot.ecore::pivot::Visitor pivot!Visitor{R,C}
		//
		symbol_319.setName("Visitor");
		//symbol_319.setMoniker("pivot!Visitor{R,C}");
		symbol_322.setName("R");
		symbol_321.setOwnedParameteredElement(symbol_322);
		symbol_320.getOwnedParameters().add(symbol_321);
		symbol_324.setName("C");
		symbol_323.setOwnedParameteredElement(symbol_324);
		symbol_320.getOwnedParameters().add(symbol_323);
		
		symbol_319.setOwnedTemplateSignature(symbol_320);
		symbol_1.getOwnedTypes().add(symbol_319);
		//
		// pivot.ecore::pivot::VoidType pivot!VoidType
		//
		symbol_325.setName("VoidType");
		//symbol_325.setMoniker("pivot!VoidType");
		symbol_325.getSuperClasses().add(symbol_25); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_325);

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
