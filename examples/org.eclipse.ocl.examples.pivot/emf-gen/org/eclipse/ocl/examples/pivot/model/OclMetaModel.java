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
 * $Id: OclMetaModel.java,v 1.5 2011/04/20 19:02:47 ewillink Exp $
 */
package	org.eclipse.ocl.examples.pivot.model;

import java.math.BigInteger;

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
	 *	The static package-of-types pivot model of the Pivot Model.
	 */
	public static final OclMetaModel INSTANCE = new OclMetaModel();

	/**
	 *	Create and return a pivot model of the Pivot Model.
	 */
	public static Package create(StandardLibrary standardLibrary)
	{
		Package symbol_1 = PivotFactory.eINSTANCE.createPackage(); // pivot
		Class symbol_2 = PivotFactory.eINSTANCE.createClass(); // pivot!Annotation
		Property symbol_3 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::ownedContent pivot!Annotation!ownedContent
		Property symbol_4 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::ownedDetail pivot!Annotation!ownedDetail
		Property symbol_5 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::reference pivot!Annotation!reference
		
		Class symbol_6 = PivotFactory.eINSTANCE.createClass(); // pivot!AnyType
		
		Class symbol_7 = PivotFactory.eINSTANCE.createClass(); // pivot!AssociationClass
		Property symbol_8 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClass::unownedAttribute pivot!AssociationClass!unownedAttribute
		
		Class symbol_9 = PivotFactory.eINSTANCE.createClass(); // pivot!AssociationClassCallExp
		Property symbol_10 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClassCallExp::referredAssociationClass pivot!AssociationClassCallExp!referredAssociationClass
		
		Enumeration symbol_11 = PivotFactory.eINSTANCE.createEnumeration(); // pivot!AssociativityKind
		
		Class symbol_12 = PivotFactory.eINSTANCE.createClass(); // pivot!BagType
		
		PrimitiveType symbol_13 = standardLibrary.getBooleanType(); // pivot!Boolean
		Class symbol_14 = PivotFactory.eINSTANCE.createClass(); // pivot!BooleanLiteralExp
		Property symbol_15 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::BooleanLiteralExp::booleanSymbol pivot!BooleanLiteralExp!booleanSymbol
		
		Class symbol_16 = PivotFactory.eINSTANCE.createClass(); // pivot!CallExp
		Property symbol_17 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::implicit pivot!CallExp!implicit
		Property symbol_18 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::source pivot!CallExp!source
		
		Class symbol_19 = PivotFactory.eINSTANCE.createClass(); // pivot!CallOperationAction
		Property symbol_20 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallOperationAction::operation pivot!CallOperationAction!operation
		
		DataType symbol_21 = PivotFactory.eINSTANCE.createDataType(); // pivot!CallableImplementation
		
		Class symbol_22 = PivotFactory.eINSTANCE.createClass(); // pivot!Class
		Property symbol_23 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::isAbstract pivot!Class!isAbstract
		Property symbol_24 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::isInterface pivot!Class!isInterface
		Property symbol_25 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::ownedAttribute pivot!Class!ownedAttribute
		Property symbol_26 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::ownedOperation pivot!Class!ownedOperation
		Property symbol_27 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::subClass pivot!Class!subClass
		Property symbol_28 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::superClass pivot!Class!superClass
		
		Class symbol_29 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionItem
		Property symbol_30 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionItem::item pivot!CollectionItem!item
		
		Enumeration symbol_31 = PivotFactory.eINSTANCE.createEnumeration(); // pivot!CollectionKind
		
		Class symbol_32 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionLiteralExp
		Property symbol_33 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::kind pivot!CollectionLiteralExp!kind
		Property symbol_34 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::part pivot!CollectionLiteralExp!part
		
		Class symbol_35 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionLiteralPart
		
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionRange
		Property symbol_37 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::first pivot!CollectionRange!first
		Property symbol_38 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
		
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionType
		Property symbol_40 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
		
		Class symbol_41 = PivotFactory.eINSTANCE.createClass(); // pivot!Comment
		Property symbol_42 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
		Property symbol_43 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::body pivot!Comment!body
		
		Class symbol_44 = PivotFactory.eINSTANCE.createClass(); // pivot!Constraint
		Property symbol_45 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
		Property symbol_46 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
		Property symbol_47 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
		Property symbol_48 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
		
		Class symbol_49 = PivotFactory.eINSTANCE.createClass(); // pivot!DataType
		Property symbol_50 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
		Property symbol_51 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
		
		Class symbol_52 = PivotFactory.eINSTANCE.createClass(); // pivot!Detail
		Property symbol_53 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::value pivot!Detail!value
		
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // pivot!Element
		Property symbol_55 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
		
		Class symbol_56 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumLiteralExp
		Property symbol_57 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
		
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // pivot!Enumeration
		Property symbol_59 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
		
		Class symbol_60 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumerationLiteral
		Property symbol_61 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
		Property symbol_62 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
		
		Class symbol_63 = PivotFactory.eINSTANCE.createClass(); // pivot!ExpressionInOcl
		Property symbol_64 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
		Property symbol_65 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
		Property symbol_66 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
		Property symbol_67 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
		Property symbol_68 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
		
		Class symbol_69 = PivotFactory.eINSTANCE.createClass(); // pivot!Feature
		Property symbol_70 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
		Property symbol_71 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
		
		Class symbol_72 = PivotFactory.eINSTANCE.createClass(); // pivot!FeatureCallExp
		Property symbol_73 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
		
		Class symbol_74 = PivotFactory.eINSTANCE.createClass(); // pivot!IfExp
		Property symbol_75 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
		Property symbol_76 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
		Property symbol_77 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
		
		DataType symbol_78 = PivotFactory.eINSTANCE.createDataType(); // pivot!Int
		
		PrimitiveType symbol_79 = standardLibrary.getIntegerType(); // pivot!Integer
		Class symbol_80 = PivotFactory.eINSTANCE.createClass(); // pivot!IntegerLiteralExp
		Property symbol_81 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
		
		Class symbol_82 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidLiteralExp
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidType
		
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // pivot!IterateExp
		Property symbol_85 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
		
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // pivot!Iteration
		Property symbol_87 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
		Property symbol_88 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
		
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // pivot!IteratorExp
		
		Class symbol_90 = PivotFactory.eINSTANCE.createClass(); // pivot!LambdaType
		Property symbol_91 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
		Property symbol_92 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
		Property symbol_93 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
		
		Class symbol_94 = PivotFactory.eINSTANCE.createClass(); // pivot!LetExp
		Property symbol_95 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
		Property symbol_96 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
		
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // pivot!Library
		
		Class symbol_98 = PivotFactory.eINSTANCE.createClass(); // pivot!LiteralExp
		
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // pivot!LoopExp
		Property symbol_100 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
		Property symbol_101 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
		Property symbol_102 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
		
		Class symbol_103 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageExp
		Property symbol_104 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
		Property symbol_105 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
		Property symbol_106 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
		Property symbol_107 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
		
		Class symbol_108 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageType
		Property symbol_109 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
		Property symbol_110 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
		
		Class symbol_111 = PivotFactory.eINSTANCE.createClass(); // pivot!MonikeredElement
		Property symbol_112 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
		
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // pivot!MultiplicityElement
		Property symbol_114 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
		Property symbol_115 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
		Property symbol_116 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
		Property symbol_117 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
		
		Class symbol_118 = PivotFactory.eINSTANCE.createClass(); // pivot!Nameable
		
		Class symbol_119 = PivotFactory.eINSTANCE.createClass(); // pivot!NamedElement
		Property symbol_120 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
		Property symbol_121 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
		Property symbol_122 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
		Property symbol_123 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
		
		Class symbol_124 = PivotFactory.eINSTANCE.createClass(); // pivot!Namespace
		
		Class symbol_125 = PivotFactory.eINSTANCE.createClass(); // pivot!NavigationCallExp
		Property symbol_126 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
		Property symbol_127 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
		
		Class symbol_128 = PivotFactory.eINSTANCE.createClass(); // pivot!NullLiteralExp
		
		Class symbol_129 = PivotFactory.eINSTANCE.createClass(); // pivot!NumericLiteralExp
		
		DataType symbol_130 = PivotFactory.eINSTANCE.createDataType(); // pivot!Object
		
		Class symbol_131 = PivotFactory.eINSTANCE.createClass(); // pivot!OclExpression
		
		Class symbol_132 = PivotFactory.eINSTANCE.createClass(); // pivot!OpaqueExpression
		Property symbol_133 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
		Property symbol_134 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
		Property symbol_135 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
		Property symbol_136 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
		
		Class symbol_137 = PivotFactory.eINSTANCE.createClass(); // pivot!Operation
		Property symbol_138 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::class pivot!Operation!class
		Property symbol_139 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
		Property symbol_140 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
		Property symbol_141 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
		
		Class symbol_142 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationCallExp
		Property symbol_143 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
		Property symbol_144 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
		
		Class symbol_145 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationTemplateParameter
		
		Class symbol_146 = PivotFactory.eINSTANCE.createClass(); // pivot!OrderedSetType
		
		Class symbol_147 = PivotFactory.eINSTANCE.createClass(); // pivot!Package
		Property symbol_148 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
		Property symbol_149 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
		Property symbol_150 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
		Property symbol_151 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
		Property symbol_152 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
		Property symbol_153 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
		
		Class symbol_154 = PivotFactory.eINSTANCE.createClass(); // pivot!PackageableElement
		
		Class symbol_155 = PivotFactory.eINSTANCE.createClass(); // pivot!Parameter
		Property symbol_156 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
		
		Class symbol_157 = PivotFactory.eINSTANCE.createClass(); // pivot!ParameterableElement
		Property symbol_158 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
		Property symbol_159 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
		
		Class symbol_160 = PivotFactory.eINSTANCE.createClass(); // pivot!Pivotable
		
		Class symbol_161 = PivotFactory.eINSTANCE.createClass(); // pivot!Precedence
		Property symbol_162 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
		Property symbol_163 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
		
		Class symbol_164 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveLiteralExp
		
		Class symbol_165 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveType
		
		Class symbol_166 = PivotFactory.eINSTANCE.createClass(); // pivot!Property
		Property symbol_167 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::association pivot!Property!association
		Property symbol_168 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::class pivot!Property!class
		Property symbol_169 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::default pivot!Property!default
		Property symbol_170 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
		Property symbol_171 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
		Property symbol_172 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
		Property symbol_173 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isID pivot!Property!isID
		Property symbol_174 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
		Property symbol_175 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
		Property symbol_176 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
		Property symbol_177 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
		Property symbol_178 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
		Property symbol_179 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::keys pivot!Property!keys
		Property symbol_180 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
		
		Class symbol_181 = PivotFactory.eINSTANCE.createClass(); // pivot!PropertyCallExp
		Property symbol_182 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
		
		PrimitiveType symbol_183 = standardLibrary.getRealType(); // pivot!Real
		Class symbol_184 = PivotFactory.eINSTANCE.createClass(); // pivot!RealLiteralExp
		Property symbol_185 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
		
		Class symbol_186 = PivotFactory.eINSTANCE.createClass(); // pivot!SendSignalAction
		Property symbol_187 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
		
		Class symbol_188 = PivotFactory.eINSTANCE.createClass(); // pivot!SequenceType
		
		Class symbol_189 = PivotFactory.eINSTANCE.createClass(); // pivot!SetType
		
		Class symbol_190 = PivotFactory.eINSTANCE.createClass(); // pivot!Signal
		
		Class symbol_191 = PivotFactory.eINSTANCE.createClass(); // pivot!State
		
		Class symbol_192 = PivotFactory.eINSTANCE.createClass(); // pivot!StateExp
		Property symbol_193 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
		
		PrimitiveType symbol_194 = standardLibrary.getStringType(); // pivot!String
		Class symbol_195 = PivotFactory.eINSTANCE.createClass(); // pivot!StringLiteralExp
		Property symbol_196 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
		
		Class symbol_197 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateBinding
		Property symbol_198 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
		Property symbol_199 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
		Property symbol_200 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
		
		Class symbol_201 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameter
		Property symbol_202 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
		Property symbol_203 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
		Property symbol_204 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
		Property symbol_205 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
		Property symbol_206 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
		
		Class symbol_207 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterSubstitution
		Property symbol_208 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
		Property symbol_209 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
		Property symbol_210 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
		Property symbol_211 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
		
		Class symbol_212 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterType
		Property symbol_213 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
		
		Class symbol_214 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateSignature
		Property symbol_215 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
		Property symbol_216 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
		Property symbol_217 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
		
		Class symbol_218 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateableElement
		Property symbol_219 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
		Property symbol_220 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
		
		DataType symbol_221 = PivotFactory.eINSTANCE.createDataType(); // pivot!Throwable
		
		Class symbol_222 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralExp
		Property symbol_223 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
		
		Class symbol_224 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralPart
		Property symbol_225 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
		
		Class symbol_226 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleType
		
		Class symbol_227 = PivotFactory.eINSTANCE.createClass(); // pivot!Type
		Property symbol_228 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
		Property symbol_229 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::package pivot!Type!package
		
		Class symbol_230 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeExp
		Property symbol_231 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
		
		Class symbol_232 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeTemplateParameter
		Property symbol_233 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
		Property symbol_234 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
		
		Class symbol_235 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedElement
		Property symbol_236 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
		
		Class symbol_237 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedMultiplicityElement
		
		PrimitiveType symbol_238 = standardLibrary.getUnlimitedNaturalType(); // pivot!UnlimitedNatural
		Class symbol_239 = PivotFactory.eINSTANCE.createClass(); // pivot!UnlimitedNaturalLiteralExp
		Property symbol_240 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
		
		Class symbol_241 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedType
		Property symbol_242 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
		Property symbol_243 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
		
		Class symbol_244 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedValueExp
		
		Class symbol_245 = PivotFactory.eINSTANCE.createClass(); // pivot!ValueSpecification
		
		Class symbol_246 = PivotFactory.eINSTANCE.createClass(); // pivot!Variable
		Property symbol_247 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
		Property symbol_248 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
		Property symbol_249 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
		
		Class symbol_250 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableDeclaration
		
		Class symbol_251 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableExp
		Property symbol_252 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
		Property symbol_253 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
		
		Class symbol_254 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitable
		
		Class symbol_255 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}
		TemplateSignature symbol_256 = PivotFactory.eINSTANCE.createTemplateSignature(); // pivot!Visitor{R,C}!
		TypeTemplateParameter symbol_257 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_258 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?R
		TypeTemplateParameter symbol_259 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_260 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?C
		
		
		Class symbol_261 = PivotFactory.eINSTANCE.createClass(); // pivot!VoidType
		

		symbol_1.setName("pivot");
		symbol_1.setNsPrefix("pivot");
		symbol_1.setNsURI("http://www.eclipse.org/ocl/3.1.0/Pivot");
		//
		// pivot.ecore::pivot::Annotation pivot!Annotation
		//
		symbol_2.setName("Annotation");
		//symbol_2.setMoniker("pivot!Annotation");
		symbol_2.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::Annotation::ownedContent pivot!Annotation!ownedContent
			symbol_3.setName("ownedContent");
			symbol_3.setType(symbol_54);  // pivot!Element
			symbol_3.setLower(BigInteger.valueOf(0));
			symbol_3.setUpper(BigInteger.valueOf(-1));
			symbol_3.setIsOrdered(true);
			
			symbol_3.setIsComposite(true);
			symbol_3.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_3);
		}
		{ // pivot.ecore::pivot::Annotation::ownedDetail pivot!Annotation!ownedDetail
			symbol_4.setName("ownedDetail");
			symbol_4.setType(symbol_52);  // pivot!Detail
			symbol_4.setLower(BigInteger.valueOf(0));
			symbol_4.setUpper(BigInteger.valueOf(-1));
			symbol_4.setIsOrdered(true);
			
			symbol_4.setIsComposite(true);
			symbol_4.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_4);
		}
		{ // pivot.ecore::pivot::Annotation::reference pivot!Annotation!reference
			symbol_5.setName("reference");
			symbol_5.setType(symbol_54);  // pivot!Element
			symbol_5.setLower(BigInteger.valueOf(0));
			symbol_5.setUpper(BigInteger.valueOf(-1));
			symbol_5.setIsOrdered(true);
			
			symbol_5.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_5);
		}
		symbol_1.getOwnedTypes().add(symbol_2);
		//
		// pivot.ecore::pivot::AnyType pivot!AnyType
		//
		symbol_6.setName("AnyType");
		//symbol_6.setMoniker("pivot!AnyType");
		symbol_6.getSuperClasses().add(symbol_22); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_6);
		//
		// pivot.ecore::pivot::AssociationClass pivot!AssociationClass
		//
		symbol_7.setName("AssociationClass");
		//symbol_7.setMoniker("pivot!AssociationClass");
		symbol_7.getSuperClasses().add(symbol_22); // pivot!Class
		{ // pivot.ecore::pivot::AssociationClass::unownedAttribute pivot!AssociationClass!unownedAttribute
			symbol_8.setName("unownedAttribute");
			symbol_8.setType(symbol_166);  // pivot!Property
			symbol_8.setLower(BigInteger.valueOf(0));
			symbol_8.setUpper(BigInteger.valueOf(-1));
			
			symbol_8.setIsResolveProxies(true);
			symbol_8.setOpposite(symbol_167);
			symbol_7.getOwnedAttributes().add(symbol_8);
		}
		symbol_1.getOwnedTypes().add(symbol_7);
		//
		// pivot.ecore::pivot::AssociationClassCallExp pivot!AssociationClassCallExp
		//
		symbol_9.setName("AssociationClassCallExp");
		//symbol_9.setMoniker("pivot!AssociationClassCallExp");
		symbol_9.getSuperClasses().add(symbol_125); // pivot!NavigationCallExp
		{ // pivot.ecore::pivot::AssociationClassCallExp::referredAssociationClass pivot!AssociationClassCallExp!referredAssociationClass
			symbol_10.setName("referredAssociationClass");
			symbol_10.setType(symbol_7);  // pivot!AssociationClass
			symbol_10.setLower(BigInteger.valueOf(0));
			
			symbol_10.setIsResolveProxies(true);
			symbol_9.getOwnedAttributes().add(symbol_10);
		}
		symbol_1.getOwnedTypes().add(symbol_9);
		//
		// pivot.ecore::pivot::AssociativityKind pivot!AssociativityKind
		//
		symbol_11.setName("AssociativityKind");
		//symbol_11.setMoniker("pivot!AssociativityKind");
		{
			EnumerationLiteral symbol_262 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Left pivot!AssociativityKind!Left
			symbol_262.setName("Left");
			symbol_11.getOwnedLiterals().add(symbol_262);
			EnumerationLiteral symbol_263 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Right pivot!AssociativityKind!Right
			symbol_263.setName("Right");
			symbol_11.getOwnedLiterals().add(symbol_263);
		}
		
		symbol_1.getOwnedTypes().add(symbol_11);
		//
		// pivot.ecore::pivot::BagType pivot!BagType
		//
		symbol_12.setName("BagType");
		//symbol_12.setMoniker("pivot!BagType");
		symbol_12.getSuperClasses().add(symbol_39); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// pivot.ecore::pivot::BooleanLiteralExp pivot!BooleanLiteralExp
		//
		symbol_14.setName("BooleanLiteralExp");
		//symbol_14.setMoniker("pivot!BooleanLiteralExp");
		symbol_14.getSuperClasses().add(symbol_164); // pivot!PrimitiveLiteralExp
		{ // pivot.ecore::pivot::BooleanLiteralExp::booleanSymbol pivot!BooleanLiteralExp!booleanSymbol
			symbol_15.setName("booleanSymbol");
			symbol_15.setType(symbol_13);  // pivot!Boolean
			
			symbol_15.setIsResolveProxies(true);
			symbol_15.setIsUnsettable(true);
			symbol_14.getOwnedAttributes().add(symbol_15);
		}
		symbol_1.getOwnedTypes().add(symbol_14);
		//
		// pivot.ecore::pivot::CallExp pivot!CallExp
		//
		symbol_16.setName("CallExp");
		//symbol_16.setMoniker("pivot!CallExp");
		symbol_16.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::CallExp::implicit pivot!CallExp!implicit
			symbol_17.setName("implicit");
			symbol_17.setType(symbol_13);  // pivot!Boolean
			symbol_17.setLower(BigInteger.valueOf(0));
			
			symbol_17.setIsResolveProxies(true);
			symbol_16.getOwnedAttributes().add(symbol_17);
		}
		{ // pivot.ecore::pivot::CallExp::source pivot!CallExp!source
			symbol_18.setName("source");
			symbol_18.setType(symbol_131);  // pivot!OclExpression
			symbol_18.setLower(BigInteger.valueOf(0));
			
			symbol_18.setIsComposite(true);
			symbol_18.setIsResolveProxies(true);
			symbol_16.getOwnedAttributes().add(symbol_18);
		}
		symbol_1.getOwnedTypes().add(symbol_16);
		//
		// pivot.ecore::pivot::CallOperationAction pivot!CallOperationAction
		//
		symbol_19.setName("CallOperationAction");
		//symbol_19.setMoniker("pivot!CallOperationAction");
		symbol_19.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::CallOperationAction::operation pivot!CallOperationAction!operation
			symbol_20.setName("operation");
			symbol_20.setType(symbol_137);  // pivot!Operation
			
			symbol_20.setIsResolveProxies(true);
			symbol_19.getOwnedAttributes().add(symbol_20);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// pivot.ecore::pivot::CallableImplementation pivot!CallableImplementation
		//
		symbol_21.setName("CallableImplementation");
		//symbol_21.setMoniker("pivot!CallableImplementation");
		symbol_1.getOwnedTypes().add(symbol_21);
		//
		// pivot.ecore::pivot::Class pivot!Class
		//
		symbol_22.setName("Class");
		//symbol_22.setMoniker("pivot!Class");
		symbol_22.getSuperClasses().add(symbol_124); // pivot!Namespace
		symbol_22.getSuperClasses().add(symbol_227); // pivot!Type
		{ // pivot.ecore::pivot::Class::isAbstract pivot!Class!isAbstract
			symbol_23.setName("isAbstract");
			symbol_23.setType(symbol_13);  // pivot!Boolean
			
			symbol_23.setIsResolveProxies(true);
			symbol_22.getOwnedAttributes().add(symbol_23);
		}
		{ // pivot.ecore::pivot::Class::isInterface pivot!Class!isInterface
			symbol_24.setName("isInterface");
			symbol_24.setType(symbol_13);  // pivot!Boolean
			
			symbol_24.setIsResolveProxies(true);
			symbol_22.getOwnedAttributes().add(symbol_24);
		}
		{ // pivot.ecore::pivot::Class::ownedAttribute pivot!Class!ownedAttribute
			symbol_25.setName("ownedAttribute");
			symbol_25.setType(symbol_166);  // pivot!Property
			symbol_25.setLower(BigInteger.valueOf(0));
			symbol_25.setUpper(BigInteger.valueOf(-1));
			symbol_25.setIsOrdered(true);
			
			symbol_25.setIsComposite(true);
			symbol_25.setIsResolveProxies(true);
			symbol_25.setOpposite(symbol_168);
			symbol_22.getOwnedAttributes().add(symbol_25);
		}
		{ // pivot.ecore::pivot::Class::ownedOperation pivot!Class!ownedOperation
			symbol_26.setName("ownedOperation");
			symbol_26.setType(symbol_137);  // pivot!Operation
			symbol_26.setLower(BigInteger.valueOf(0));
			symbol_26.setUpper(BigInteger.valueOf(-1));
			symbol_26.setIsOrdered(true);
			
			symbol_26.setIsComposite(true);
			symbol_26.setIsResolveProxies(true);
			symbol_26.setOpposite(symbol_138);
			symbol_22.getOwnedAttributes().add(symbol_26);
		}
		{ // pivot.ecore::pivot::Class::subClass pivot!Class!subClass
			symbol_27.setName("subClass");
			symbol_27.setType(symbol_22);  // pivot!Class
			symbol_27.setLower(BigInteger.valueOf(0));
			symbol_27.setUpper(BigInteger.valueOf(-1));
			
			symbol_27.setIsTransient(true);
			symbol_22.getOwnedAttributes().add(symbol_27);
		}
		{ // pivot.ecore::pivot::Class::superClass pivot!Class!superClass
			symbol_28.setName("superClass");
			symbol_28.setType(symbol_22);  // pivot!Class
			symbol_28.setLower(BigInteger.valueOf(0));
			symbol_28.setUpper(BigInteger.valueOf(-1));
			
			symbol_28.setIsResolveProxies(true);
			symbol_22.getOwnedAttributes().add(symbol_28);
		}
		symbol_1.getOwnedTypes().add(symbol_22);
		//
		// pivot.ecore::pivot::CollectionItem pivot!CollectionItem
		//
		symbol_29.setName("CollectionItem");
		//symbol_29.setMoniker("pivot!CollectionItem");
		symbol_29.getSuperClasses().add(symbol_35); // pivot!CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionItem::item pivot!CollectionItem!item
			symbol_30.setName("item");
			symbol_30.setType(symbol_131);  // pivot!OclExpression
			
			symbol_30.setIsComposite(true);
			symbol_30.setIsResolveProxies(true);
			symbol_29.getOwnedAttributes().add(symbol_30);
		}
		symbol_1.getOwnedTypes().add(symbol_29);
		//
		// pivot.ecore::pivot::CollectionKind pivot!CollectionKind
		//
		symbol_31.setName("CollectionKind");
		//symbol_31.setMoniker("pivot!CollectionKind");
		{
			EnumerationLiteral symbol_264 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Collection pivot!CollectionKind!Collection
			symbol_264.setName("Collection");
			symbol_31.getOwnedLiterals().add(symbol_264);
			EnumerationLiteral symbol_265 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Set pivot!CollectionKind!Set
			symbol_265.setName("Set");
			symbol_31.getOwnedLiterals().add(symbol_265);
			EnumerationLiteral symbol_266 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::OrderedSet pivot!CollectionKind!OrderedSet
			symbol_266.setName("OrderedSet");
			symbol_31.getOwnedLiterals().add(symbol_266);
			EnumerationLiteral symbol_267 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Bag pivot!CollectionKind!Bag
			symbol_267.setName("Bag");
			symbol_31.getOwnedLiterals().add(symbol_267);
			EnumerationLiteral symbol_268 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Sequence pivot!CollectionKind!Sequence
			symbol_268.setName("Sequence");
			symbol_31.getOwnedLiterals().add(symbol_268);
		}
		
		symbol_1.getOwnedTypes().add(symbol_31);
		//
		// pivot.ecore::pivot::CollectionLiteralExp pivot!CollectionLiteralExp
		//
		symbol_32.setName("CollectionLiteralExp");
		//symbol_32.setMoniker("pivot!CollectionLiteralExp");
		symbol_32.getSuperClasses().add(symbol_98); // pivot!LiteralExp
		{ // pivot.ecore::pivot::CollectionLiteralExp::kind pivot!CollectionLiteralExp!kind
			symbol_33.setName("kind");
			symbol_33.setType(symbol_31);  // pivot!CollectionKind
			
			symbol_33.setIsResolveProxies(true);
			symbol_32.getOwnedAttributes().add(symbol_33);
		}
		{ // pivot.ecore::pivot::CollectionLiteralExp::part pivot!CollectionLiteralExp!part
			symbol_34.setName("part");
			symbol_34.setType(symbol_35);  // pivot!CollectionLiteralPart
			symbol_34.setLower(BigInteger.valueOf(0));
			symbol_34.setUpper(BigInteger.valueOf(-1));
			symbol_34.setIsOrdered(true);
			
			symbol_34.setIsComposite(true);
			symbol_34.setIsResolveProxies(true);
			symbol_32.getOwnedAttributes().add(symbol_34);
		}
		symbol_1.getOwnedTypes().add(symbol_32);
		//
		// pivot.ecore::pivot::CollectionLiteralPart pivot!CollectionLiteralPart
		//
		symbol_35.setName("CollectionLiteralPart");
		//symbol_35.setMoniker("pivot!CollectionLiteralPart");
		symbol_35.getSuperClasses().add(symbol_235); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_35);
		//
		// pivot.ecore::pivot::CollectionRange pivot!CollectionRange
		//
		symbol_36.setName("CollectionRange");
		//symbol_36.setMoniker("pivot!CollectionRange");
		symbol_36.getSuperClasses().add(symbol_35); // pivot!CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionRange::first pivot!CollectionRange!first
			symbol_37.setName("first");
			symbol_37.setType(symbol_131);  // pivot!OclExpression
			
			symbol_37.setIsComposite(true);
			symbol_37.setIsResolveProxies(true);
			symbol_36.getOwnedAttributes().add(symbol_37);
		}
		{ // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
			symbol_38.setName("last");
			symbol_38.setType(symbol_131);  // pivot!OclExpression
			
			symbol_38.setIsComposite(true);
			symbol_38.setIsResolveProxies(true);
			symbol_36.getOwnedAttributes().add(symbol_38);
		}
		symbol_1.getOwnedTypes().add(symbol_36);
		//
		// pivot.ecore::pivot::CollectionType pivot!CollectionType
		//
		symbol_39.setName("CollectionType");
		//symbol_39.setMoniker("pivot!CollectionType");
		symbol_39.getSuperClasses().add(symbol_49); // pivot!DataType
		{ // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
			symbol_40.setName("elementType");
			symbol_40.setType(symbol_227);  // pivot!Type
			
			symbol_40.setIsResolveProxies(true);
			symbol_39.getOwnedAttributes().add(symbol_40);
		}
		symbol_1.getOwnedTypes().add(symbol_39);
		//
		// pivot.ecore::pivot::Comment pivot!Comment
		//
		symbol_41.setName("Comment");
		//symbol_41.setMoniker("pivot!Comment");
		symbol_41.getSuperClasses().add(symbol_54); // pivot!Element
		{ // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
			symbol_42.setName("annotatedElement");
			symbol_42.setType(symbol_54);  // pivot!Element
			symbol_42.setLower(BigInteger.valueOf(0));
			symbol_42.setUpper(BigInteger.valueOf(-1));
			
			symbol_42.setIsResolveProxies(true);
			symbol_41.getOwnedAttributes().add(symbol_42);
		}
		{ // pivot.ecore::pivot::Comment::body pivot!Comment!body
			symbol_43.setName("body");
			symbol_43.setType(symbol_194);  // pivot!String
			symbol_43.setLower(BigInteger.valueOf(0));
			
			symbol_43.setIsResolveProxies(true);
			symbol_41.getOwnedAttributes().add(symbol_43);
		}
		symbol_1.getOwnedTypes().add(symbol_41);
		//
		// pivot.ecore::pivot::Constraint pivot!Constraint
		//
		symbol_44.setName("Constraint");
		//symbol_44.setMoniker("pivot!Constraint");
		symbol_44.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
			symbol_45.setName("constrainedElement");
			symbol_45.setType(symbol_54);  // pivot!Element
			symbol_45.setLower(BigInteger.valueOf(0));
			symbol_45.setUpper(BigInteger.valueOf(-1));
			symbol_45.setIsOrdered(true);
			
			symbol_45.setIsResolveProxies(true);
			symbol_44.getOwnedAttributes().add(symbol_45);
		}
		{ // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
			symbol_46.setName("context");
			symbol_46.setType(symbol_119);  // pivot!NamedElement
			symbol_46.setLower(BigInteger.valueOf(0));
			
			symbol_46.setIsResolveProxies(true);
			symbol_44.getOwnedAttributes().add(symbol_46);
		}
		{ // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
			symbol_47.setName("specification");
			symbol_47.setType(symbol_245);  // pivot!ValueSpecification
			
			symbol_47.setIsComposite(true);
			symbol_47.setIsResolveProxies(true);
			symbol_44.getOwnedAttributes().add(symbol_47);
		}
		{ // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
			symbol_48.setName("stereotype");
			symbol_48.setType(symbol_194);  // pivot!String
			symbol_48.setLower(BigInteger.valueOf(0));
			
			symbol_48.setIsResolveProxies(true);
			symbol_44.getOwnedAttributes().add(symbol_48);
		}
		symbol_1.getOwnedTypes().add(symbol_44);
		//
		// pivot.ecore::pivot::DataType pivot!DataType
		//
		symbol_49.setName("DataType");
		//symbol_49.setMoniker("pivot!DataType");
		symbol_49.getSuperClasses().add(symbol_22); // pivot!Class
		{ // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
			symbol_50.setName("behavioralType");
			symbol_50.setType(symbol_227);  // pivot!Type
			symbol_50.setLower(BigInteger.valueOf(0));
			
			symbol_50.setIsResolveProxies(true);
			symbol_49.getOwnedAttributes().add(symbol_50);
		}
		{ // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
			symbol_51.setName("isSerializable");
			symbol_51.setType(symbol_13);  // pivot!Boolean
			
			symbol_51.setIsResolveProxies(true);
			symbol_49.getOwnedAttributes().add(symbol_51);
		}
		symbol_1.getOwnedTypes().add(symbol_49);
		//
		// pivot.ecore::pivot::Detail pivot!Detail
		//
		symbol_52.setName("Detail");
		//symbol_52.setMoniker("pivot!Detail");
		symbol_52.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::Detail::value pivot!Detail!value
			symbol_53.setName("value");
			symbol_53.setType(symbol_194);  // pivot!String
			symbol_53.setUpper(BigInteger.valueOf(-1));
			
			symbol_53.setIsResolveProxies(true);
			symbol_52.getOwnedAttributes().add(symbol_53);
		}
		symbol_1.getOwnedTypes().add(symbol_52);
		//
		// pivot.ecore::pivot::Element pivot!Element
		//
		symbol_54.setName("Element");
		//symbol_54.setMoniker("pivot!Element");
		symbol_54.getSuperClasses().add(symbol_254); // pivot!Visitable
		{ // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
			symbol_55.setName("ownedComment");
			symbol_55.setType(symbol_41);  // pivot!Comment
			symbol_55.setLower(BigInteger.valueOf(0));
			symbol_55.setUpper(BigInteger.valueOf(-1));
			
			symbol_55.setIsComposite(true);
			symbol_55.setIsResolveProxies(true);
			symbol_54.getOwnedAttributes().add(symbol_55);
		}
		symbol_1.getOwnedTypes().add(symbol_54);
		//
		// pivot.ecore::pivot::EnumLiteralExp pivot!EnumLiteralExp
		//
		symbol_56.setName("EnumLiteralExp");
		//symbol_56.setMoniker("pivot!EnumLiteralExp");
		symbol_56.getSuperClasses().add(symbol_98); // pivot!LiteralExp
		{ // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
			symbol_57.setName("referredEnumLiteral");
			symbol_57.setType(symbol_60);  // pivot!EnumerationLiteral
			symbol_57.setLower(BigInteger.valueOf(0));
			
			symbol_57.setIsResolveProxies(true);
			symbol_56.getOwnedAttributes().add(symbol_57);
		}
		symbol_1.getOwnedTypes().add(symbol_56);
		//
		// pivot.ecore::pivot::Enumeration pivot!Enumeration
		//
		symbol_58.setName("Enumeration");
		//symbol_58.setMoniker("pivot!Enumeration");
		symbol_58.getSuperClasses().add(symbol_49); // pivot!DataType
		{ // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
			symbol_59.setName("ownedLiteral");
			symbol_59.setType(symbol_60);  // pivot!EnumerationLiteral
			symbol_59.setLower(BigInteger.valueOf(0));
			symbol_59.setUpper(BigInteger.valueOf(-1));
			symbol_59.setIsOrdered(true);
			
			symbol_59.setIsComposite(true);
			symbol_59.setIsResolveProxies(true);
			symbol_59.setOpposite(symbol_61);
			symbol_58.getOwnedAttributes().add(symbol_59);
		}
		symbol_1.getOwnedTypes().add(symbol_58);
		//
		// pivot.ecore::pivot::EnumerationLiteral pivot!EnumerationLiteral
		//
		symbol_60.setName("EnumerationLiteral");
		//symbol_60.setMoniker("pivot!EnumerationLiteral");
		symbol_60.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
			symbol_61.setName("enumeration");
			symbol_61.setType(symbol_58);  // pivot!Enumeration
			symbol_61.setLower(BigInteger.valueOf(0));
			
			symbol_61.setIsResolveProxies(true);
			symbol_61.setOpposite(symbol_59);
			symbol_60.getOwnedAttributes().add(symbol_61);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
			symbol_62.setName("value");
			symbol_62.setType(symbol_79);  // pivot!Integer
			symbol_62.setLower(BigInteger.valueOf(0));
			
			symbol_62.setIsResolveProxies(true);
			symbol_60.getOwnedAttributes().add(symbol_62);
		}
		symbol_1.getOwnedTypes().add(symbol_60);
		//
		// pivot.ecore::pivot::ExpressionInOcl pivot!ExpressionInOcl
		//
		symbol_63.setName("ExpressionInOcl");
		//symbol_63.setMoniker("pivot!ExpressionInOcl");
		symbol_63.getSuperClasses().add(symbol_132); // pivot!OpaqueExpression
		{ // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
			symbol_64.setName("bodyExpression");
			symbol_64.setType(symbol_131);  // pivot!OclExpression
			
			symbol_64.setIsComposite(true);
			symbol_64.setIsResolveProxies(true);
			symbol_63.getOwnedAttributes().add(symbol_64);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
			symbol_65.setName("contextVariable");
			symbol_65.setType(symbol_246);  // pivot!Variable
			symbol_65.setLower(BigInteger.valueOf(0));
			
			symbol_65.setIsComposite(true);
			symbol_65.setIsResolveProxies(true);
			symbol_63.getOwnedAttributes().add(symbol_65);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
			symbol_66.setName("messageExpression");
			symbol_66.setType(symbol_131);  // pivot!OclExpression
			symbol_66.setLower(BigInteger.valueOf(0));
			
			symbol_66.setIsComposite(true);
			symbol_66.setIsResolveProxies(true);
			symbol_63.getOwnedAttributes().add(symbol_66);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
			symbol_67.setName("parameterVariable");
			symbol_67.setType(symbol_246);  // pivot!Variable
			symbol_67.setLower(BigInteger.valueOf(0));
			symbol_67.setUpper(BigInteger.valueOf(-1));
			symbol_67.setIsOrdered(true);
			
			symbol_67.setIsComposite(true);
			symbol_67.setIsResolveProxies(true);
			symbol_63.getOwnedAttributes().add(symbol_67);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
			symbol_68.setName("resultVariable");
			symbol_68.setType(symbol_246);  // pivot!Variable
			symbol_68.setLower(BigInteger.valueOf(0));
			
			symbol_68.setIsComposite(true);
			symbol_68.setIsResolveProxies(true);
			symbol_63.getOwnedAttributes().add(symbol_68);
		}
		symbol_1.getOwnedTypes().add(symbol_63);
		//
		// pivot.ecore::pivot::Feature pivot!Feature
		//
		symbol_69.setName("Feature");
		//symbol_69.setMoniker("pivot!Feature");
		symbol_69.getSuperClasses().add(symbol_237); // pivot!TypedMultiplicityElement
		{ // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
			symbol_70.setName("implementation");
			symbol_70.setType(symbol_21);  // pivot!CallableImplementation
			symbol_70.setLower(BigInteger.valueOf(0));
			
			symbol_70.setIsResolveProxies(true);
			symbol_70.setIsTransient(true);
			symbol_69.getOwnedAttributes().add(symbol_70);
		}
		{ // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
			symbol_71.setName("implementationClass");
			symbol_71.setType(symbol_194);  // pivot!String
			symbol_71.setLower(BigInteger.valueOf(0));
			
			symbol_71.setIsResolveProxies(true);
			symbol_69.getOwnedAttributes().add(symbol_71);
		}
		symbol_1.getOwnedTypes().add(symbol_69);
		//
		// pivot.ecore::pivot::FeatureCallExp pivot!FeatureCallExp
		//
		symbol_72.setName("FeatureCallExp");
		//symbol_72.setMoniker("pivot!FeatureCallExp");
		symbol_72.getSuperClasses().add(symbol_16); // pivot!CallExp
		{ // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
			symbol_73.setName("isPre");
			symbol_73.setType(symbol_13);  // pivot!Boolean
			
			symbol_73.setIsResolveProxies(true);
			symbol_72.getOwnedAttributes().add(symbol_73);
		}
		symbol_1.getOwnedTypes().add(symbol_72);
		//
		// pivot.ecore::pivot::IfExp pivot!IfExp
		//
		symbol_74.setName("IfExp");
		//symbol_74.setMoniker("pivot!IfExp");
		symbol_74.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
			symbol_75.setName("condition");
			symbol_75.setType(symbol_131);  // pivot!OclExpression
			
			symbol_75.setIsComposite(true);
			symbol_75.setIsResolveProxies(true);
			symbol_74.getOwnedAttributes().add(symbol_75);
		}
		{ // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
			symbol_76.setName("elseExpression");
			symbol_76.setType(symbol_131);  // pivot!OclExpression
			
			symbol_76.setIsComposite(true);
			symbol_76.setIsResolveProxies(true);
			symbol_74.getOwnedAttributes().add(symbol_76);
		}
		{ // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
			symbol_77.setName("thenExpression");
			symbol_77.setType(symbol_131);  // pivot!OclExpression
			
			symbol_77.setIsComposite(true);
			symbol_77.setIsResolveProxies(true);
			symbol_74.getOwnedAttributes().add(symbol_77);
		}
		symbol_1.getOwnedTypes().add(symbol_74);
		//
		// pivot.ecore::pivot::Int pivot!Int
		//
		symbol_78.setName("Int");
		//symbol_78.setMoniker("pivot!Int");
		symbol_1.getOwnedTypes().add(symbol_78);
		//
		// pivot.ecore::pivot::IntegerLiteralExp pivot!IntegerLiteralExp
		//
		symbol_80.setName("IntegerLiteralExp");
		//symbol_80.setMoniker("pivot!IntegerLiteralExp");
		symbol_80.getSuperClasses().add(symbol_129); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
			symbol_81.setName("integerSymbol");
			symbol_81.setType(symbol_79);  // pivot!Integer
			
			symbol_81.setIsResolveProxies(true);
			symbol_80.getOwnedAttributes().add(symbol_81);
		}
		symbol_1.getOwnedTypes().add(symbol_80);
		//
		// pivot.ecore::pivot::InvalidLiteralExp pivot!InvalidLiteralExp
		//
		symbol_82.setName("InvalidLiteralExp");
		//symbol_82.setMoniker("pivot!InvalidLiteralExp");
		symbol_82.getSuperClasses().add(symbol_98); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_82);
		//
		// pivot.ecore::pivot::InvalidType pivot!InvalidType
		//
		symbol_83.setName("InvalidType");
		//symbol_83.setMoniker("pivot!InvalidType");
		symbol_83.getSuperClasses().add(symbol_22); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// pivot.ecore::pivot::IterateExp pivot!IterateExp
		//
		symbol_84.setName("IterateExp");
		//symbol_84.setMoniker("pivot!IterateExp");
		symbol_84.getSuperClasses().add(symbol_99); // pivot!LoopExp
		{ // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
			symbol_85.setName("result");
			symbol_85.setType(symbol_246);  // pivot!Variable
			symbol_85.setLower(BigInteger.valueOf(0));
			symbol_85.setIsOrdered(true);
			
			symbol_85.setIsComposite(true);
			symbol_85.setIsResolveProxies(true);
			symbol_84.getOwnedAttributes().add(symbol_85);
		}
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// pivot.ecore::pivot::Iteration pivot!Iteration
		//
		symbol_86.setName("Iteration");
		//symbol_86.setMoniker("pivot!Iteration");
		symbol_86.getSuperClasses().add(symbol_137); // pivot!Operation
		{ // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
			symbol_87.setName("ownedAccumulator");
			symbol_87.setType(symbol_155);  // pivot!Parameter
			symbol_87.setLower(BigInteger.valueOf(0));
			symbol_87.setUpper(BigInteger.valueOf(-1));
			
			symbol_87.setIsComposite(true);
			symbol_87.setIsResolveProxies(true);
			symbol_86.getOwnedAttributes().add(symbol_87);
		}
		{ // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
			symbol_88.setName("ownedIterator");
			symbol_88.setType(symbol_155);  // pivot!Parameter
			symbol_88.setLower(BigInteger.valueOf(0));
			symbol_88.setUpper(BigInteger.valueOf(-1));
			
			symbol_88.setIsComposite(true);
			symbol_88.setIsResolveProxies(true);
			symbol_86.getOwnedAttributes().add(symbol_88);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// pivot.ecore::pivot::IteratorExp pivot!IteratorExp
		//
		symbol_89.setName("IteratorExp");
		//symbol_89.setMoniker("pivot!IteratorExp");
		symbol_89.getSuperClasses().add(symbol_99); // pivot!LoopExp
		symbol_1.getOwnedTypes().add(symbol_89);
		//
		// pivot.ecore::pivot::LambdaType pivot!LambdaType
		//
		symbol_90.setName("LambdaType");
		//symbol_90.setMoniker("pivot!LambdaType");
		symbol_90.getSuperClasses().add(symbol_49); // pivot!DataType
		{ // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
			symbol_91.setName("contextType");
			symbol_91.setType(symbol_227);  // pivot!Type
			
			symbol_91.setIsResolveProxies(true);
			symbol_90.getOwnedAttributes().add(symbol_91);
		}
		{ // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
			symbol_92.setName("parameterType");
			symbol_92.setType(symbol_227);  // pivot!Type
			symbol_92.setLower(BigInteger.valueOf(0));
			symbol_92.setUpper(BigInteger.valueOf(-1));
			
			symbol_92.setIsResolveProxies(true);
			symbol_90.getOwnedAttributes().add(symbol_92);
		}
		{ // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
			symbol_93.setName("resultType");
			symbol_93.setType(symbol_227);  // pivot!Type
			
			symbol_93.setIsResolveProxies(true);
			symbol_90.getOwnedAttributes().add(symbol_93);
		}
		symbol_1.getOwnedTypes().add(symbol_90);
		//
		// pivot.ecore::pivot::LetExp pivot!LetExp
		//
		symbol_94.setName("LetExp");
		//symbol_94.setMoniker("pivot!LetExp");
		symbol_94.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
			symbol_95.setName("in");
			symbol_95.setType(symbol_131);  // pivot!OclExpression
			
			symbol_95.setIsComposite(true);
			symbol_95.setIsResolveProxies(true);
			symbol_94.getOwnedAttributes().add(symbol_95);
		}
		{ // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
			symbol_96.setName("variable");
			symbol_96.setType(symbol_246);  // pivot!Variable
			
			symbol_96.setIsComposite(true);
			symbol_96.setIsResolveProxies(true);
			symbol_94.getOwnedAttributes().add(symbol_96);
		}
		symbol_1.getOwnedTypes().add(symbol_94);
		//
		// pivot.ecore::pivot::Library pivot!Library
		//
		symbol_97.setName("Library");
		//symbol_97.setMoniker("pivot!Library");
		symbol_97.getSuperClasses().add(symbol_147); // pivot!Package
		symbol_1.getOwnedTypes().add(symbol_97);
		//
		// pivot.ecore::pivot::LiteralExp pivot!LiteralExp
		//
		symbol_98.setName("LiteralExp");
		//symbol_98.setMoniker("pivot!LiteralExp");
		symbol_98.getSuperClasses().add(symbol_131); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_98);
		//
		// pivot.ecore::pivot::LoopExp pivot!LoopExp
		//
		symbol_99.setName("LoopExp");
		//symbol_99.setMoniker("pivot!LoopExp");
		symbol_99.getSuperClasses().add(symbol_16); // pivot!CallExp
		{ // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
			symbol_100.setName("body");
			symbol_100.setType(symbol_131);  // pivot!OclExpression
			
			symbol_100.setIsComposite(true);
			symbol_100.setIsResolveProxies(true);
			symbol_99.getOwnedAttributes().add(symbol_100);
		}
		{ // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
			symbol_101.setName("iterator");
			symbol_101.setType(symbol_246);  // pivot!Variable
			symbol_101.setLower(BigInteger.valueOf(0));
			symbol_101.setUpper(BigInteger.valueOf(-1));
			symbol_101.setIsOrdered(true);
			
			symbol_101.setIsComposite(true);
			symbol_101.setIsResolveProxies(true);
			symbol_99.getOwnedAttributes().add(symbol_101);
		}
		{ // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
			symbol_102.setName("referredIteration");
			symbol_102.setType(symbol_86);  // pivot!Iteration
			symbol_102.setLower(BigInteger.valueOf(0));
			
			symbol_102.setIsResolveProxies(true);
			symbol_99.getOwnedAttributes().add(symbol_102);
		}
		symbol_1.getOwnedTypes().add(symbol_99);
		//
		// pivot.ecore::pivot::MessageExp pivot!MessageExp
		//
		symbol_103.setName("MessageExp");
		//symbol_103.setMoniker("pivot!MessageExp");
		symbol_103.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
			symbol_104.setName("argument");
			symbol_104.setType(symbol_131);  // pivot!OclExpression
			symbol_104.setLower(BigInteger.valueOf(0));
			symbol_104.setUpper(BigInteger.valueOf(-1));
			
			symbol_104.setIsComposite(true);
			symbol_104.setIsResolveProxies(true);
			symbol_103.getOwnedAttributes().add(symbol_104);
		}
		{ // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
			symbol_105.setName("calledOperation");
			symbol_105.setType(symbol_19);  // pivot!CallOperationAction
			symbol_105.setLower(BigInteger.valueOf(0));
			
			symbol_105.setIsComposite(true);
			symbol_105.setIsResolveProxies(true);
			symbol_103.getOwnedAttributes().add(symbol_105);
		}
		{ // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
			symbol_106.setName("sentSignal");
			symbol_106.setType(symbol_186);  // pivot!SendSignalAction
			symbol_106.setLower(BigInteger.valueOf(0));
			
			symbol_106.setIsComposite(true);
			symbol_106.setIsResolveProxies(true);
			symbol_103.getOwnedAttributes().add(symbol_106);
		}
		{ // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
			symbol_107.setName("target");
			symbol_107.setType(symbol_131);  // pivot!OclExpression
			
			symbol_107.setIsComposite(true);
			symbol_107.setIsResolveProxies(true);
			symbol_103.getOwnedAttributes().add(symbol_107);
		}
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// pivot.ecore::pivot::MessageType pivot!MessageType
		//
		symbol_108.setName("MessageType");
		//symbol_108.setMoniker("pivot!MessageType");
		symbol_108.getSuperClasses().add(symbol_227); // pivot!Type
		{ // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
			symbol_109.setName("referredOperation");
			symbol_109.setType(symbol_137);  // pivot!Operation
			symbol_109.setLower(BigInteger.valueOf(0));
			
			symbol_109.setIsResolveProxies(true);
			symbol_108.getOwnedAttributes().add(symbol_109);
		}
		{ // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
			symbol_110.setName("referredSignal");
			symbol_110.setType(symbol_190);  // pivot!Signal
			symbol_110.setLower(BigInteger.valueOf(0));
			
			symbol_110.setIsResolveProxies(true);
			symbol_108.getOwnedAttributes().add(symbol_110);
		}
		symbol_1.getOwnedTypes().add(symbol_108);
		//
		// pivot.ecore::pivot::MonikeredElement pivot!MonikeredElement
		//
		symbol_111.setName("MonikeredElement");
		//symbol_111.setMoniker("pivot!MonikeredElement");
		symbol_111.getSuperClasses().add(symbol_54); // pivot!Element
		{ // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
			symbol_112.setName("moniker");
			symbol_112.setType(symbol_194);  // pivot!String
			
			symbol_112.setIsDerived(true);
			symbol_112.setIsResolveProxies(true);
			symbol_112.setIsTransient(true);
			symbol_112.setIsVolatile(true);
			symbol_111.getOwnedAttributes().add(symbol_112);
		}
		{	// pivot.ecore::pivot::MonikeredElement::hasMoniker() pivot!MonikeredElement!hasMoniker()
			Operation symbol_269 = PivotFactory.eINSTANCE.createOperation();
			symbol_269.setName("hasMoniker");
			//symbol_269.setMoniker("pivot!MonikeredElement!hasMoniker()");
			symbol_269.setType(symbol_13);  // pivot!Boolean
			
			symbol_111.getOwnedOperations().add(symbol_269);
		}
		symbol_1.getOwnedTypes().add(symbol_111);
		//
		// pivot.ecore::pivot::MultiplicityElement pivot!MultiplicityElement
		//
		symbol_113.setName("MultiplicityElement");
		//symbol_113.setMoniker("pivot!MultiplicityElement");
		symbol_113.getSuperClasses().add(symbol_111); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
			symbol_114.setName("isOrdered");
			symbol_114.setType(symbol_13);  // pivot!Boolean
			
			symbol_114.setIsResolveProxies(true);
			symbol_113.getOwnedAttributes().add(symbol_114);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
			symbol_115.setName("isUnique");
			symbol_115.setType(symbol_13);  // pivot!Boolean
			
			symbol_115.setIsResolveProxies(true);
			symbol_113.getOwnedAttributes().add(symbol_115);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
			symbol_116.setName("lower");
			symbol_116.setType(symbol_79);  // pivot!Integer
			symbol_116.setLower(BigInteger.valueOf(0));
			
			symbol_116.setIsResolveProxies(true);
			symbol_113.getOwnedAttributes().add(symbol_116);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
			symbol_117.setName("upper");
			symbol_117.setType(symbol_238);  // pivot!UnlimitedNatural
			symbol_117.setLower(BigInteger.valueOf(0));
			
			symbol_117.setIsResolveProxies(true);
			symbol_113.getOwnedAttributes().add(symbol_117);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesCardinality() pivot!MultiplicityElement!includesCardinality(pivot!Integer)
			Operation symbol_270 = PivotFactory.eINSTANCE.createOperation();
			symbol_270.setName("includesCardinality");
			//symbol_270.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)");
			symbol_270.setType(symbol_13);  // pivot!Boolean
			
			Parameter symbol_271 = PivotFactory.eINSTANCE.createParameter();
			symbol_271.setName("C");
			//symbol_271.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)!C");
			symbol_271.setType(symbol_79);  // pivot!Integer
			
			symbol_270.getOwnedParameters().add(symbol_271);
			symbol_113.getOwnedOperations().add(symbol_270);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesMultiplicity() pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)
			Operation symbol_272 = PivotFactory.eINSTANCE.createOperation();
			symbol_272.setName("includesMultiplicity");
			//symbol_272.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)");
			symbol_272.setType(symbol_13);  // pivot!Boolean
			
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("M");
			//symbol_273.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)!M");
			symbol_273.setType(symbol_113);  // pivot!MultiplicityElement
			
			symbol_272.getOwnedParameters().add(symbol_273);
			symbol_113.getOwnedOperations().add(symbol_272);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::isMultivalued() pivot!MultiplicityElement!isMultivalued()
			Operation symbol_274 = PivotFactory.eINSTANCE.createOperation();
			symbol_274.setName("isMultivalued");
			//symbol_274.setMoniker("pivot!MultiplicityElement!isMultivalued()");
			symbol_274.setType(symbol_13);  // pivot!Boolean
			
			symbol_113.getOwnedOperations().add(symbol_274);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::lowerBound() pivot!MultiplicityElement!lowerBound()
			Operation symbol_275 = PivotFactory.eINSTANCE.createOperation();
			symbol_275.setName("lowerBound");
			//symbol_275.setMoniker("pivot!MultiplicityElement!lowerBound()");
			symbol_275.setType(symbol_79);  // pivot!Integer
			
			symbol_113.getOwnedOperations().add(symbol_275);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::upperBound() pivot!MultiplicityElement!upperBound()
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("upperBound");
			//symbol_276.setMoniker("pivot!MultiplicityElement!upperBound()");
			symbol_276.setType(symbol_238);  // pivot!UnlimitedNatural
			
			symbol_113.getOwnedOperations().add(symbol_276);
		}
		symbol_1.getOwnedTypes().add(symbol_113);
		//
		// pivot.ecore::pivot::Nameable pivot!Nameable
		//
		symbol_118.setName("Nameable");
		//symbol_118.setMoniker("pivot!Nameable");
		symbol_1.getOwnedTypes().add(symbol_118);
		//
		// pivot.ecore::pivot::NamedElement pivot!NamedElement
		//
		symbol_119.setName("NamedElement");
		//symbol_119.setMoniker("pivot!NamedElement");
		symbol_119.getSuperClasses().add(symbol_118); // pivot!Nameable
		symbol_119.getSuperClasses().add(symbol_111); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
			symbol_120.setName("isStatic");
			symbol_120.setType(symbol_13);  // pivot!Boolean
			
			symbol_120.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_120);
		}
		{ // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
			symbol_121.setName("name");
			symbol_121.setType(symbol_194);  // pivot!String
			symbol_121.setLower(BigInteger.valueOf(0));
			
			symbol_121.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_121);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
			symbol_122.setName("ownedAnnotation");
			symbol_122.setType(symbol_2);  // pivot!Annotation
			symbol_122.setLower(BigInteger.valueOf(0));
			symbol_122.setUpper(BigInteger.valueOf(-1));
			symbol_122.setIsOrdered(true);
			
			symbol_122.setIsComposite(true);
			symbol_122.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_122);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
			symbol_123.setName("ownedRule");
			symbol_123.setType(symbol_44);  // pivot!Constraint
			symbol_123.setLower(BigInteger.valueOf(0));
			symbol_123.setUpper(BigInteger.valueOf(-1));
			
			symbol_123.setIsComposite(true);
			symbol_123.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_123);
		}
		symbol_1.getOwnedTypes().add(symbol_119);
		//
		// pivot.ecore::pivot::Namespace pivot!Namespace
		//
		symbol_124.setName("Namespace");
		//symbol_124.setMoniker("pivot!Namespace");
		symbol_124.getSuperClasses().add(symbol_119); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_124);
		//
		// pivot.ecore::pivot::NavigationCallExp pivot!NavigationCallExp
		//
		symbol_125.setName("NavigationCallExp");
		//symbol_125.setMoniker("pivot!NavigationCallExp");
		symbol_125.getSuperClasses().add(symbol_72); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
			symbol_126.setName("navigationSource");
			symbol_126.setType(symbol_166);  // pivot!Property
			symbol_126.setLower(BigInteger.valueOf(0));
			symbol_126.setIsOrdered(true);
			
			symbol_126.setIsResolveProxies(true);
			symbol_125.getOwnedAttributes().add(symbol_126);
		}
		{ // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
			symbol_127.setName("qualifier");
			symbol_127.setType(symbol_131);  // pivot!OclExpression
			symbol_127.setLower(BigInteger.valueOf(0));
			symbol_127.setUpper(BigInteger.valueOf(-1));
			symbol_127.setIsOrdered(true);
			
			symbol_127.setIsResolveProxies(true);
			symbol_125.getOwnedAttributes().add(symbol_127);
		}
		symbol_1.getOwnedTypes().add(symbol_125);
		//
		// pivot.ecore::pivot::NullLiteralExp pivot!NullLiteralExp
		//
		symbol_128.setName("NullLiteralExp");
		//symbol_128.setMoniker("pivot!NullLiteralExp");
		symbol_128.getSuperClasses().add(symbol_164); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_128);
		//
		// pivot.ecore::pivot::NumericLiteralExp pivot!NumericLiteralExp
		//
		symbol_129.setName("NumericLiteralExp");
		//symbol_129.setMoniker("pivot!NumericLiteralExp");
		symbol_129.getSuperClasses().add(symbol_164); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_129);
		//
		// pivot.ecore::pivot::Object pivot!Object
		//
		symbol_130.setName("Object");
		//symbol_130.setMoniker("pivot!Object");
		symbol_1.getOwnedTypes().add(symbol_130);
		//
		// pivot.ecore::pivot::OclExpression pivot!OclExpression
		//
		symbol_131.setName("OclExpression");
		//symbol_131.setMoniker("pivot!OclExpression");
		symbol_131.getSuperClasses().add(symbol_235); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_131);
		//
		// pivot.ecore::pivot::OpaqueExpression pivot!OpaqueExpression
		//
		symbol_132.setName("OpaqueExpression");
		//symbol_132.setMoniker("pivot!OpaqueExpression");
		symbol_132.getSuperClasses().add(symbol_245); // pivot!ValueSpecification
		{ // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
			symbol_133.setName("body");
			symbol_133.setType(symbol_194);  // pivot!String
			symbol_133.setLower(BigInteger.valueOf(0));
			symbol_133.setUpper(BigInteger.valueOf(-1));
			symbol_133.setIsOrdered(true);
			symbol_133.setIsUnique(false);
			
			symbol_133.setIsResolveProxies(true);
			symbol_132.getOwnedAttributes().add(symbol_133);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
			symbol_134.setName("language");
			symbol_134.setType(symbol_194);  // pivot!String
			symbol_134.setLower(BigInteger.valueOf(0));
			symbol_134.setUpper(BigInteger.valueOf(-1));
			symbol_134.setIsOrdered(true);
			
			symbol_134.setIsResolveProxies(true);
			symbol_132.getOwnedAttributes().add(symbol_134);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
			symbol_135.setName("message");
			symbol_135.setType(symbol_194);  // pivot!String
			symbol_135.setLower(BigInteger.valueOf(0));
			symbol_135.setUpper(BigInteger.valueOf(-1));
			symbol_135.setIsOrdered(true);
			symbol_135.setIsUnique(false);
			
			symbol_135.setIsResolveProxies(true);
			symbol_132.getOwnedAttributes().add(symbol_135);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
			symbol_136.setName("valueExpression");
			symbol_136.setType(symbol_63);  // pivot!ExpressionInOcl
			symbol_136.setLower(BigInteger.valueOf(0));
			
			symbol_136.setIsResolveProxies(true);
			symbol_136.setIsTransient(true);
			symbol_132.getOwnedAttributes().add(symbol_136);
		}
		symbol_1.getOwnedTypes().add(symbol_132);
		//
		// pivot.ecore::pivot::Operation pivot!Operation
		//
		symbol_137.setName("Operation");
		//symbol_137.setMoniker("pivot!Operation");
		symbol_137.getSuperClasses().add(symbol_124); // pivot!Namespace
		symbol_137.getSuperClasses().add(symbol_69); // pivot!Feature
		symbol_137.getSuperClasses().add(symbol_157); // pivot!ParameterableElement
		symbol_137.getSuperClasses().add(symbol_218); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Operation::class pivot!Operation!class
			symbol_138.setName("class");
			symbol_138.setType(symbol_22);  // pivot!Class
			symbol_138.setLower(BigInteger.valueOf(0));
			
			symbol_138.setIsResolveProxies(true);
			symbol_138.setOpposite(symbol_26);
			symbol_137.getOwnedAttributes().add(symbol_138);
		}
		{ // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
			symbol_139.setName("ownedParameter");
			symbol_139.setType(symbol_155);  // pivot!Parameter
			symbol_139.setLower(BigInteger.valueOf(0));
			symbol_139.setUpper(BigInteger.valueOf(-1));
			symbol_139.setIsOrdered(true);
			
			symbol_139.setIsComposite(true);
			symbol_139.setIsResolveProxies(true);
			symbol_139.setOpposite(symbol_156);
			symbol_137.getOwnedAttributes().add(symbol_139);
		}
		{ // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
			symbol_140.setName("precedence");
			symbol_140.setType(symbol_161);  // pivot!Precedence
			symbol_140.setLower(BigInteger.valueOf(0));
			
			symbol_140.setIsResolveProxies(true);
			symbol_137.getOwnedAttributes().add(symbol_140);
		}
		{ // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
			symbol_141.setName("raisedException");
			symbol_141.setType(symbol_227);  // pivot!Type
			symbol_141.setLower(BigInteger.valueOf(0));
			symbol_141.setUpper(BigInteger.valueOf(-1));
			
			symbol_141.setIsResolveProxies(true);
			symbol_137.getOwnedAttributes().add(symbol_141);
		}
		symbol_1.getOwnedTypes().add(symbol_137);
		//
		// pivot.ecore::pivot::OperationCallExp pivot!OperationCallExp
		//
		symbol_142.setName("OperationCallExp");
		//symbol_142.setMoniker("pivot!OperationCallExp");
		symbol_142.getSuperClasses().add(symbol_72); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
			symbol_143.setName("argument");
			symbol_143.setType(symbol_131);  // pivot!OclExpression
			symbol_143.setLower(BigInteger.valueOf(0));
			symbol_143.setUpper(BigInteger.valueOf(-1));
			symbol_143.setIsOrdered(true);
			
			symbol_143.setIsComposite(true);
			symbol_143.setIsResolveProxies(true);
			symbol_142.getOwnedAttributes().add(symbol_143);
		}
		{ // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
			symbol_144.setName("referredOperation");
			symbol_144.setType(symbol_137);  // pivot!Operation
			symbol_144.setLower(BigInteger.valueOf(0));
			
			symbol_144.setIsResolveProxies(true);
			symbol_142.getOwnedAttributes().add(symbol_144);
		}
		symbol_1.getOwnedTypes().add(symbol_142);
		//
		// pivot.ecore::pivot::OperationTemplateParameter pivot!OperationTemplateParameter
		//
		symbol_145.setName("OperationTemplateParameter");
		//symbol_145.setMoniker("pivot!OperationTemplateParameter");
		symbol_145.getSuperClasses().add(symbol_201); // pivot!TemplateParameter
		symbol_1.getOwnedTypes().add(symbol_145);
		//
		// pivot.ecore::pivot::OrderedSetType pivot!OrderedSetType
		//
		symbol_146.setName("OrderedSetType");
		//symbol_146.setMoniker("pivot!OrderedSetType");
		symbol_146.getSuperClasses().add(symbol_39); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_146);
		//
		// pivot.ecore::pivot::Package pivot!Package
		//
		symbol_147.setName("Package");
		//symbol_147.setMoniker("pivot!Package");
		symbol_147.getSuperClasses().add(symbol_124); // pivot!Namespace
		symbol_147.getSuperClasses().add(symbol_218); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
			symbol_148.setName("nestedPackage");
			symbol_148.setType(symbol_147);  // pivot!Package
			symbol_148.setLower(BigInteger.valueOf(0));
			symbol_148.setUpper(BigInteger.valueOf(-1));
			
			symbol_148.setIsComposite(true);
			symbol_148.setIsResolveProxies(true);
			symbol_148.setOpposite(symbol_149);
			symbol_147.getOwnedAttributes().add(symbol_148);
		}
		{ // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
			symbol_149.setName("nestingPackage");
			symbol_149.setType(symbol_147);  // pivot!Package
			symbol_149.setLower(BigInteger.valueOf(0));
			
			symbol_149.setIsResolveProxies(true);
			symbol_149.setOpposite(symbol_148);
			symbol_147.getOwnedAttributes().add(symbol_149);
		}
		{ // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
			symbol_150.setName("nsPrefix");
			symbol_150.setType(symbol_194);  // pivot!String
			symbol_150.setLower(BigInteger.valueOf(0));
			
			symbol_150.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_150);
		}
		{ // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
			symbol_151.setName("nsURI");
			symbol_151.setType(symbol_194);  // pivot!String
			symbol_151.setLower(BigInteger.valueOf(0));
			
			symbol_151.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_151);
		}
		{ // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
			symbol_152.setName("ownedPrecedence");
			symbol_152.setType(symbol_161);  // pivot!Precedence
			symbol_152.setLower(BigInteger.valueOf(0));
			symbol_152.setUpper(BigInteger.valueOf(-1));
			symbol_152.setIsOrdered(true);
			
			symbol_152.setIsComposite(true);
			symbol_152.setIsResolveProxies(true);
			symbol_147.getOwnedAttributes().add(symbol_152);
		}
		{ // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
			symbol_153.setName("ownedType");
			symbol_153.setType(symbol_227);  // pivot!Type
			symbol_153.setLower(BigInteger.valueOf(0));
			symbol_153.setUpper(BigInteger.valueOf(-1));
			
			symbol_153.setIsComposite(true);
			symbol_153.setIsResolveProxies(true);
			symbol_153.setOpposite(symbol_229);
			symbol_147.getOwnedAttributes().add(symbol_153);
		}
		symbol_1.getOwnedTypes().add(symbol_147);
		//
		// pivot.ecore::pivot::PackageableElement pivot!PackageableElement
		//
		symbol_154.setName("PackageableElement");
		//symbol_154.setMoniker("pivot!PackageableElement");
		symbol_154.getSuperClasses().add(symbol_157); // pivot!ParameterableElement
		symbol_1.getOwnedTypes().add(symbol_154);
		//
		// pivot.ecore::pivot::Parameter pivot!Parameter
		//
		symbol_155.setName("Parameter");
		//symbol_155.setMoniker("pivot!Parameter");
		symbol_155.getSuperClasses().add(symbol_237); // pivot!TypedMultiplicityElement
		symbol_155.getSuperClasses().add(symbol_250); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
			symbol_156.setName("operation");
			symbol_156.setType(symbol_137);  // pivot!Operation
			symbol_156.setLower(BigInteger.valueOf(0));
			
			symbol_156.setIsResolveProxies(true);
			symbol_156.setOpposite(symbol_139);
			symbol_155.getOwnedAttributes().add(symbol_156);
		}
		symbol_1.getOwnedTypes().add(symbol_155);
		//
		// pivot.ecore::pivot::ParameterableElement pivot!ParameterableElement
		//
		symbol_157.setName("ParameterableElement");
		//symbol_157.setMoniker("pivot!ParameterableElement");
		symbol_157.getSuperClasses().add(symbol_111); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
			symbol_158.setName("owningTemplateParameter");
			symbol_158.setType(symbol_201);  // pivot!TemplateParameter
			symbol_158.setLower(BigInteger.valueOf(0));
			
			symbol_158.setIsResolveProxies(true);
			symbol_158.setOpposite(symbol_204);
			symbol_157.getOwnedAttributes().add(symbol_158);
		}
		{ // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
			symbol_159.setName("templateParameter");
			symbol_159.setType(symbol_201);  // pivot!TemplateParameter
			symbol_159.setLower(BigInteger.valueOf(0));
			
			symbol_159.setIsResolveProxies(true);
			symbol_159.setOpposite(symbol_205);
			symbol_157.getOwnedAttributes().add(symbol_159);
		}
		{	// pivot.ecore::pivot::ParameterableElement::isTemplateParameter() pivot!ParameterableElement!isTemplateParameter()
			Operation symbol_277 = PivotFactory.eINSTANCE.createOperation();
			symbol_277.setName("isTemplateParameter");
			//symbol_277.setMoniker("pivot!ParameterableElement!isTemplateParameter()");
			symbol_277.setType(symbol_13);  // pivot!Boolean
			
			symbol_157.getOwnedOperations().add(symbol_277);
		}
		symbol_1.getOwnedTypes().add(symbol_157);
		//
		// pivot.ecore::pivot::Pivotable pivot!Pivotable
		//
		symbol_160.setName("Pivotable");
		//symbol_160.setMoniker("pivot!Pivotable");
		symbol_1.getOwnedTypes().add(symbol_160);
		//
		// pivot.ecore::pivot::Precedence pivot!Precedence
		//
		symbol_161.setName("Precedence");
		//symbol_161.setMoniker("pivot!Precedence");
		symbol_161.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
			symbol_162.setName("associativity");
			symbol_162.setType(symbol_11);  // pivot!AssociativityKind
			symbol_162.setLower(BigInteger.valueOf(0));
			
			symbol_162.setIsResolveProxies(true);
			symbol_161.getOwnedAttributes().add(symbol_162);
		}
		{ // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
			symbol_163.setName("order");
			symbol_163.setType(symbol_79);  // pivot!Integer
			
			symbol_163.setIsDerived(true);
			symbol_163.setIsResolveProxies(true);
			symbol_163.setIsVolatile(true);
			symbol_161.getOwnedAttributes().add(symbol_163);
		}
		symbol_1.getOwnedTypes().add(symbol_161);
		//
		// pivot.ecore::pivot::PrimitiveLiteralExp pivot!PrimitiveLiteralExp
		//
		symbol_164.setName("PrimitiveLiteralExp");
		//symbol_164.setMoniker("pivot!PrimitiveLiteralExp");
		symbol_164.getSuperClasses().add(symbol_98); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_164);
		//
		// pivot.ecore::pivot::PrimitiveType pivot!PrimitiveType
		//
		symbol_165.setName("PrimitiveType");
		//symbol_165.setMoniker("pivot!PrimitiveType");
		symbol_165.getSuperClasses().add(symbol_49); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_165);
		//
		// pivot.ecore::pivot::Property pivot!Property
		//
		symbol_166.setName("Property");
		//symbol_166.setMoniker("pivot!Property");
		symbol_166.getSuperClasses().add(symbol_69); // pivot!Feature
		symbol_166.getSuperClasses().add(symbol_157); // pivot!ParameterableElement
		{ // pivot.ecore::pivot::Property::association pivot!Property!association
			symbol_167.setName("association");
			symbol_167.setType(symbol_7);  // pivot!AssociationClass
			symbol_167.setLower(BigInteger.valueOf(0));
			
			symbol_167.setIsResolveProxies(true);
			symbol_167.setOpposite(symbol_8);
			symbol_166.getOwnedAttributes().add(symbol_167);
		}
		{ // pivot.ecore::pivot::Property::class pivot!Property!class
			symbol_168.setName("class");
			symbol_168.setType(symbol_22);  // pivot!Class
			symbol_168.setLower(BigInteger.valueOf(0));
			
			symbol_168.setIsResolveProxies(true);
			symbol_168.setOpposite(symbol_25);
			symbol_166.getOwnedAttributes().add(symbol_168);
		}
		{ // pivot.ecore::pivot::Property::default pivot!Property!default
			symbol_169.setName("default");
			symbol_169.setType(symbol_194);  // pivot!String
			symbol_169.setLower(BigInteger.valueOf(0));
			
			symbol_169.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_169);
		}
		{ // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
			symbol_170.setName("implicit");
			symbol_170.setType(symbol_13);  // pivot!Boolean
			symbol_170.setLower(BigInteger.valueOf(0));
			
			symbol_170.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_170);
		}
		{ // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
			symbol_171.setName("isComposite");
			symbol_171.setType(symbol_13);  // pivot!Boolean
			
			symbol_171.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_171);
		}
		{ // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
			symbol_172.setName("isDerived");
			symbol_172.setType(symbol_13);  // pivot!Boolean
			
			symbol_172.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_172);
		}
		{ // pivot.ecore::pivot::Property::isID pivot!Property!isID
			symbol_173.setName("isID");
			symbol_173.setType(symbol_13);  // pivot!Boolean
			
			symbol_173.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_173);
		}
		{ // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
			symbol_174.setName("isReadOnly");
			symbol_174.setType(symbol_13);  // pivot!Boolean
			
			symbol_174.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_174);
		}
		{ // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
			symbol_175.setName("isResolveProxies");
			symbol_175.setType(symbol_13);  // pivot!Boolean
			
			symbol_175.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_175);
		}
		{ // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
			symbol_176.setName("isTransient");
			symbol_176.setType(symbol_13);  // pivot!Boolean
			
			symbol_176.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_176);
		}
		{ // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
			symbol_177.setName("isUnsettable");
			symbol_177.setType(symbol_13);  // pivot!Boolean
			
			symbol_177.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_177);
		}
		{ // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
			symbol_178.setName("isVolatile");
			symbol_178.setType(symbol_13);  // pivot!Boolean
			
			symbol_178.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_178);
		}
		{ // pivot.ecore::pivot::Property::keys pivot!Property!keys
			symbol_179.setName("keys");
			symbol_179.setType(symbol_166);  // pivot!Property
			symbol_179.setLower(BigInteger.valueOf(0));
			symbol_179.setUpper(BigInteger.valueOf(-1));
			
			symbol_179.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_179);
		}
		{ // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
			symbol_180.setName("opposite");
			symbol_180.setType(symbol_166);  // pivot!Property
			symbol_180.setLower(BigInteger.valueOf(0));
			
			symbol_180.setIsResolveProxies(true);
			symbol_166.getOwnedAttributes().add(symbol_180);
		}
		symbol_1.getOwnedTypes().add(symbol_166);
		//
		// pivot.ecore::pivot::PropertyCallExp pivot!PropertyCallExp
		//
		symbol_181.setName("PropertyCallExp");
		//symbol_181.setMoniker("pivot!PropertyCallExp");
		symbol_181.getSuperClasses().add(symbol_125); // pivot!NavigationCallExp
		{ // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
			symbol_182.setName("referredProperty");
			symbol_182.setType(symbol_166);  // pivot!Property
			symbol_182.setLower(BigInteger.valueOf(0));
			
			symbol_182.setIsResolveProxies(true);
			symbol_181.getOwnedAttributes().add(symbol_182);
		}
		symbol_1.getOwnedTypes().add(symbol_181);
		//
		// pivot.ecore::pivot::RealLiteralExp pivot!RealLiteralExp
		//
		symbol_184.setName("RealLiteralExp");
		//symbol_184.setMoniker("pivot!RealLiteralExp");
		symbol_184.getSuperClasses().add(symbol_129); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
			symbol_185.setName("realSymbol");
			symbol_185.setType(symbol_183);  // pivot!Real
			
			symbol_185.setIsResolveProxies(true);
			symbol_184.getOwnedAttributes().add(symbol_185);
		}
		symbol_1.getOwnedTypes().add(symbol_184);
		//
		// pivot.ecore::pivot::SendSignalAction pivot!SendSignalAction
		//
		symbol_186.setName("SendSignalAction");
		//symbol_186.setMoniker("pivot!SendSignalAction");
		symbol_186.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
			symbol_187.setName("signal");
			symbol_187.setType(symbol_190);  // pivot!Signal
			
			symbol_187.setIsResolveProxies(true);
			symbol_186.getOwnedAttributes().add(symbol_187);
		}
		symbol_1.getOwnedTypes().add(symbol_186);
		//
		// pivot.ecore::pivot::SequenceType pivot!SequenceType
		//
		symbol_188.setName("SequenceType");
		//symbol_188.setMoniker("pivot!SequenceType");
		symbol_188.getSuperClasses().add(symbol_39); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_188);
		//
		// pivot.ecore::pivot::SetType pivot!SetType
		//
		symbol_189.setName("SetType");
		//symbol_189.setMoniker("pivot!SetType");
		symbol_189.getSuperClasses().add(symbol_39); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_189);
		//
		// pivot.ecore::pivot::Signal pivot!Signal
		//
		symbol_190.setName("Signal");
		//symbol_190.setMoniker("pivot!Signal");
		symbol_190.getSuperClasses().add(symbol_119); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_190);
		//
		// pivot.ecore::pivot::State pivot!State
		//
		symbol_191.setName("State");
		//symbol_191.setMoniker("pivot!State");
		symbol_191.getSuperClasses().add(symbol_119); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_191);
		//
		// pivot.ecore::pivot::StateExp pivot!StateExp
		//
		symbol_192.setName("StateExp");
		//symbol_192.setMoniker("pivot!StateExp");
		symbol_192.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
			symbol_193.setName("referredState");
			symbol_193.setType(symbol_191);  // pivot!State
			symbol_193.setLower(BigInteger.valueOf(0));
			
			symbol_193.setIsResolveProxies(true);
			symbol_192.getOwnedAttributes().add(symbol_193);
		}
		symbol_1.getOwnedTypes().add(symbol_192);
		//
		// pivot.ecore::pivot::StringLiteralExp pivot!StringLiteralExp
		//
		symbol_195.setName("StringLiteralExp");
		//symbol_195.setMoniker("pivot!StringLiteralExp");
		symbol_195.getSuperClasses().add(symbol_164); // pivot!PrimitiveLiteralExp
		{ // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
			symbol_196.setName("stringSymbol");
			symbol_196.setType(symbol_194);  // pivot!String
			
			symbol_196.setIsResolveProxies(true);
			symbol_195.getOwnedAttributes().add(symbol_196);
		}
		symbol_1.getOwnedTypes().add(symbol_195);
		//
		// pivot.ecore::pivot::TemplateBinding pivot!TemplateBinding
		//
		symbol_197.setName("TemplateBinding");
		//symbol_197.setMoniker("pivot!TemplateBinding");
		symbol_197.getSuperClasses().add(symbol_54); // pivot!Element
		{ // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
			symbol_198.setName("boundElement");
			symbol_198.setType(symbol_218);  // pivot!TemplateableElement
			
			symbol_198.setIsResolveProxies(true);
			symbol_198.setOpposite(symbol_220);
			symbol_197.getOwnedAttributes().add(symbol_198);
		}
		{ // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
			symbol_199.setName("parameterSubstitution");
			symbol_199.setType(symbol_207);  // pivot!TemplateParameterSubstitution
			symbol_199.setLower(BigInteger.valueOf(0));
			symbol_199.setUpper(BigInteger.valueOf(-1));
			
			symbol_199.setIsComposite(true);
			symbol_199.setIsResolveProxies(true);
			symbol_199.setOpposite(symbol_211);
			symbol_197.getOwnedAttributes().add(symbol_199);
		}
		{ // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
			symbol_200.setName("signature");
			symbol_200.setType(symbol_214);  // pivot!TemplateSignature
			
			symbol_200.setIsResolveProxies(true);
			symbol_197.getOwnedAttributes().add(symbol_200);
		}
		symbol_1.getOwnedTypes().add(symbol_197);
		//
		// pivot.ecore::pivot::TemplateParameter pivot!TemplateParameter
		//
		symbol_201.setName("TemplateParameter");
		//symbol_201.setMoniker("pivot!TemplateParameter");
		symbol_201.getSuperClasses().add(symbol_54); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
			symbol_202.setName("default");
			symbol_202.setType(symbol_157);  // pivot!ParameterableElement
			symbol_202.setLower(BigInteger.valueOf(0));
			
			symbol_202.setIsResolveProxies(true);
			symbol_201.getOwnedAttributes().add(symbol_202);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
			symbol_203.setName("ownedDefault");
			symbol_203.setType(symbol_157);  // pivot!ParameterableElement
			symbol_203.setLower(BigInteger.valueOf(0));
			
			symbol_203.setIsComposite(true);
			symbol_203.setIsResolveProxies(true);
			symbol_201.getOwnedAttributes().add(symbol_203);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
			symbol_204.setName("ownedParameteredElement");
			symbol_204.setType(symbol_157);  // pivot!ParameterableElement
			symbol_204.setLower(BigInteger.valueOf(0));
			
			symbol_204.setIsComposite(true);
			symbol_204.setIsResolveProxies(true);
			symbol_204.setOpposite(symbol_158);
			symbol_201.getOwnedAttributes().add(symbol_204);
		}
		{ // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
			symbol_205.setName("parameteredElement");
			symbol_205.setType(symbol_157);  // pivot!ParameterableElement
			
			symbol_205.setIsResolveProxies(true);
			symbol_205.setOpposite(symbol_159);
			symbol_201.getOwnedAttributes().add(symbol_205);
		}
		{ // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
			symbol_206.setName("signature");
			symbol_206.setType(symbol_214);  // pivot!TemplateSignature
			
			symbol_206.setIsResolveProxies(true);
			symbol_206.setOpposite(symbol_215);
			symbol_201.getOwnedAttributes().add(symbol_206);
		}
		symbol_1.getOwnedTypes().add(symbol_201);
		//
		// pivot.ecore::pivot::TemplateParameterSubstitution pivot!TemplateParameterSubstitution
		//
		symbol_207.setName("TemplateParameterSubstitution");
		//symbol_207.setMoniker("pivot!TemplateParameterSubstitution");
		symbol_207.getSuperClasses().add(symbol_54); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
			symbol_208.setName("actual");
			symbol_208.setType(symbol_157);  // pivot!ParameterableElement
			
			symbol_208.setIsResolveProxies(true);
			symbol_207.getOwnedAttributes().add(symbol_208);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
			symbol_209.setName("formal");
			symbol_209.setType(symbol_201);  // pivot!TemplateParameter
			
			symbol_209.setIsResolveProxies(true);
			symbol_207.getOwnedAttributes().add(symbol_209);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
			symbol_210.setName("ownedActual");
			symbol_210.setType(symbol_157);  // pivot!ParameterableElement
			symbol_210.setLower(BigInteger.valueOf(0));
			
			symbol_210.setIsComposite(true);
			symbol_210.setIsResolveProxies(true);
			symbol_207.getOwnedAttributes().add(symbol_210);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
			symbol_211.setName("templateBinding");
			symbol_211.setType(symbol_197);  // pivot!TemplateBinding
			
			symbol_211.setIsResolveProxies(true);
			symbol_211.setOpposite(symbol_199);
			symbol_207.getOwnedAttributes().add(symbol_211);
		}
		symbol_1.getOwnedTypes().add(symbol_207);
		//
		// pivot.ecore::pivot::TemplateParameterType pivot!TemplateParameterType
		//
		symbol_212.setName("TemplateParameterType");
		//symbol_212.setMoniker("pivot!TemplateParameterType");
		symbol_212.getSuperClasses().add(symbol_227); // pivot!Type
		{ // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
			symbol_213.setName("specification");
			symbol_213.setType(symbol_194);  // pivot!String
			symbol_213.setLower(BigInteger.valueOf(0));
			
			symbol_213.setIsResolveProxies(true);
			symbol_212.getOwnedAttributes().add(symbol_213);
		}
		symbol_1.getOwnedTypes().add(symbol_212);
		//
		// pivot.ecore::pivot::TemplateSignature pivot!TemplateSignature
		//
		symbol_214.setName("TemplateSignature");
		//symbol_214.setMoniker("pivot!TemplateSignature");
		symbol_214.getSuperClasses().add(symbol_111); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
			symbol_215.setName("ownedParameter");
			symbol_215.setType(symbol_201);  // pivot!TemplateParameter
			symbol_215.setLower(BigInteger.valueOf(0));
			symbol_215.setUpper(BigInteger.valueOf(-1));
			symbol_215.setIsOrdered(true);
			
			symbol_215.setIsComposite(true);
			symbol_215.setIsResolveProxies(true);
			symbol_215.setOpposite(symbol_206);
			symbol_214.getOwnedAttributes().add(symbol_215);
		}
		{ // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
			symbol_216.setName("parameter");
			symbol_216.setType(symbol_201);  // pivot!TemplateParameter
			symbol_216.setUpper(BigInteger.valueOf(-1));
			symbol_216.setIsOrdered(true);
			
			symbol_216.setIsResolveProxies(true);
			symbol_214.getOwnedAttributes().add(symbol_216);
		}
		{ // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
			symbol_217.setName("template");
			symbol_217.setType(symbol_218);  // pivot!TemplateableElement
			
			symbol_217.setIsResolveProxies(true);
			symbol_217.setOpposite(symbol_219);
			symbol_214.getOwnedAttributes().add(symbol_217);
		}
		symbol_1.getOwnedTypes().add(symbol_214);
		//
		// pivot.ecore::pivot::TemplateableElement pivot!TemplateableElement
		//
		symbol_218.setName("TemplateableElement");
		//symbol_218.setMoniker("pivot!TemplateableElement");
		symbol_218.getSuperClasses().add(symbol_111); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
			symbol_219.setName("ownedTemplateSignature");
			symbol_219.setType(symbol_214);  // pivot!TemplateSignature
			symbol_219.setLower(BigInteger.valueOf(0));
			
			symbol_219.setIsComposite(true);
			symbol_219.setIsResolveProxies(true);
			symbol_219.setOpposite(symbol_217);
			symbol_218.getOwnedAttributes().add(symbol_219);
		}
		{ // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
			symbol_220.setName("templateBinding");
			symbol_220.setType(symbol_197);  // pivot!TemplateBinding
			symbol_220.setLower(BigInteger.valueOf(0));
			symbol_220.setUpper(BigInteger.valueOf(-1));
			
			symbol_220.setIsComposite(true);
			symbol_220.setIsResolveProxies(true);
			symbol_220.setOpposite(symbol_198);
			symbol_218.getOwnedAttributes().add(symbol_220);
		}
		{	// pivot.ecore::pivot::TemplateableElement::isTemplate() pivot!TemplateableElement!isTemplate()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_278.setName("isTemplate");
			//symbol_278.setMoniker("pivot!TemplateableElement!isTemplate()");
			symbol_278.setType(symbol_13);  // pivot!Boolean
			
			symbol_218.getOwnedOperations().add(symbol_278);
		}
		{	// pivot.ecore::pivot::TemplateableElement::parameterableElements() pivot!TemplateableElement!parameterableElements()
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("parameterableElements");
			//symbol_279.setMoniker("pivot!TemplateableElement!parameterableElements()");
			symbol_279.setType(symbol_157);  // pivot!ParameterableElement
			symbol_279.setLower(BigInteger.valueOf(0));
			symbol_279.setUpper(BigInteger.valueOf(-1));
			
			symbol_218.getOwnedOperations().add(symbol_279);
		}
		symbol_1.getOwnedTypes().add(symbol_218);
		//
		// pivot.ecore::pivot::Throwable pivot!Throwable
		//
		symbol_221.setName("Throwable");
		//symbol_221.setMoniker("pivot!Throwable");
		symbol_1.getOwnedTypes().add(symbol_221);
		//
		// pivot.ecore::pivot::TupleLiteralExp pivot!TupleLiteralExp
		//
		symbol_222.setName("TupleLiteralExp");
		//symbol_222.setMoniker("pivot!TupleLiteralExp");
		symbol_222.getSuperClasses().add(symbol_98); // pivot!LiteralExp
		{ // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
			symbol_223.setName("part");
			symbol_223.setType(symbol_224);  // pivot!TupleLiteralPart
			symbol_223.setLower(BigInteger.valueOf(0));
			symbol_223.setUpper(BigInteger.valueOf(-1));
			symbol_223.setIsOrdered(true);
			
			symbol_223.setIsComposite(true);
			symbol_223.setIsResolveProxies(true);
			symbol_222.getOwnedAttributes().add(symbol_223);
		}
		symbol_1.getOwnedTypes().add(symbol_222);
		//
		// pivot.ecore::pivot::TupleLiteralPart pivot!TupleLiteralPart
		//
		symbol_224.setName("TupleLiteralPart");
		//symbol_224.setMoniker("pivot!TupleLiteralPart");
		symbol_224.getSuperClasses().add(symbol_250); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
			symbol_225.setName("initExpression");
			symbol_225.setType(symbol_131);  // pivot!OclExpression
			symbol_225.setLower(BigInteger.valueOf(0));
			
			symbol_225.setIsComposite(true);
			symbol_225.setIsResolveProxies(true);
			symbol_224.getOwnedAttributes().add(symbol_225);
		}
		symbol_1.getOwnedTypes().add(symbol_224);
		//
		// pivot.ecore::pivot::TupleType pivot!TupleType
		//
		symbol_226.setName("TupleType");
		//symbol_226.setMoniker("pivot!TupleType");
		symbol_226.getSuperClasses().add(symbol_49); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_226);
		//
		// pivot.ecore::pivot::Type pivot!Type
		//
		symbol_227.setName("Type");
		//symbol_227.setMoniker("pivot!Type");
		symbol_227.getSuperClasses().add(symbol_119); // pivot!NamedElement
		symbol_227.getSuperClasses().add(symbol_157); // pivot!ParameterableElement
		symbol_227.getSuperClasses().add(symbol_218); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
			symbol_228.setName("instanceClassName");
			symbol_228.setType(symbol_194);  // pivot!String
			symbol_228.setLower(BigInteger.valueOf(0));
			
			symbol_228.setIsResolveProxies(true);
			symbol_227.getOwnedAttributes().add(symbol_228);
		}
		{ // pivot.ecore::pivot::Type::package pivot!Type!package
			symbol_229.setName("package");
			symbol_229.setType(symbol_147);  // pivot!Package
			symbol_229.setLower(BigInteger.valueOf(0));
			
			symbol_229.setIsResolveProxies(true);
			symbol_229.setOpposite(symbol_153);
			symbol_227.getOwnedAttributes().add(symbol_229);
		}
		symbol_1.getOwnedTypes().add(symbol_227);
		//
		// pivot.ecore::pivot::TypeExp pivot!TypeExp
		//
		symbol_230.setName("TypeExp");
		//symbol_230.setMoniker("pivot!TypeExp");
		symbol_230.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
			symbol_231.setName("referredType");
			symbol_231.setType(symbol_227);  // pivot!Type
			symbol_231.setLower(BigInteger.valueOf(0));
			
			symbol_231.setIsResolveProxies(true);
			symbol_230.getOwnedAttributes().add(symbol_231);
		}
		symbol_1.getOwnedTypes().add(symbol_230);
		//
		// pivot.ecore::pivot::TypeTemplateParameter pivot!TypeTemplateParameter
		//
		symbol_232.setName("TypeTemplateParameter");
		//symbol_232.setMoniker("pivot!TypeTemplateParameter");
		symbol_232.getSuperClasses().add(symbol_201); // pivot!TemplateParameter
		{ // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
			symbol_233.setName("allowSubstitutable");
			symbol_233.setType(symbol_13);  // pivot!Boolean
			
			symbol_233.setIsResolveProxies(true);
			symbol_232.getOwnedAttributes().add(symbol_233);
		}
		{ // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
			symbol_234.setName("constrainingType");
			symbol_234.setType(symbol_227);  // pivot!Type
			symbol_234.setLower(BigInteger.valueOf(0));
			symbol_234.setUpper(BigInteger.valueOf(-1));
			
			symbol_234.setIsResolveProxies(true);
			symbol_232.getOwnedAttributes().add(symbol_234);
		}
		symbol_1.getOwnedTypes().add(symbol_232);
		//
		// pivot.ecore::pivot::TypedElement pivot!TypedElement
		//
		symbol_235.setName("TypedElement");
		//symbol_235.setMoniker("pivot!TypedElement");
		symbol_235.getSuperClasses().add(symbol_119); // pivot!NamedElement
		{ // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
			symbol_236.setName("type");
			symbol_236.setType(symbol_227);  // pivot!Type
			symbol_236.setLower(BigInteger.valueOf(0));
			
			symbol_236.setIsResolveProxies(true);
			symbol_235.getOwnedAttributes().add(symbol_236);
		}
		symbol_1.getOwnedTypes().add(symbol_235);
		//
		// pivot.ecore::pivot::TypedMultiplicityElement pivot!TypedMultiplicityElement
		//
		symbol_237.setName("TypedMultiplicityElement");
		//symbol_237.setMoniker("pivot!TypedMultiplicityElement");
		symbol_237.getSuperClasses().add(symbol_235); // pivot!TypedElement
		symbol_237.getSuperClasses().add(symbol_113); // pivot!MultiplicityElement
		symbol_1.getOwnedTypes().add(symbol_237);
		//
		// pivot.ecore::pivot::UnlimitedNaturalLiteralExp pivot!UnlimitedNaturalLiteralExp
		//
		symbol_239.setName("UnlimitedNaturalLiteralExp");
		//symbol_239.setMoniker("pivot!UnlimitedNaturalLiteralExp");
		symbol_239.getSuperClasses().add(symbol_129); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
			symbol_240.setName("unlimitedNaturalSymbol");
			symbol_240.setType(symbol_238);  // pivot!UnlimitedNatural
			
			symbol_240.setIsResolveProxies(true);
			symbol_239.getOwnedAttributes().add(symbol_240);
		}
		symbol_1.getOwnedTypes().add(symbol_239);
		//
		// pivot.ecore::pivot::UnspecifiedType pivot!UnspecifiedType
		//
		symbol_241.setName("UnspecifiedType");
		//symbol_241.setMoniker("pivot!UnspecifiedType");
		symbol_241.getSuperClasses().add(symbol_22); // pivot!Class
		{ // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
			symbol_242.setName("lowerBound");
			symbol_242.setType(symbol_227);  // pivot!Type
			
			symbol_242.setIsResolveProxies(true);
			symbol_241.getOwnedAttributes().add(symbol_242);
		}
		{ // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
			symbol_243.setName("upperBound");
			symbol_243.setType(symbol_227);  // pivot!Type
			
			symbol_243.setIsResolveProxies(true);
			symbol_241.getOwnedAttributes().add(symbol_243);
		}
		symbol_1.getOwnedTypes().add(symbol_241);
		//
		// pivot.ecore::pivot::UnspecifiedValueExp pivot!UnspecifiedValueExp
		//
		symbol_244.setName("UnspecifiedValueExp");
		//symbol_244.setMoniker("pivot!UnspecifiedValueExp");
		symbol_244.getSuperClasses().add(symbol_131); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_244);
		//
		// pivot.ecore::pivot::ValueSpecification pivot!ValueSpecification
		//
		symbol_245.setName("ValueSpecification");
		//symbol_245.setMoniker("pivot!ValueSpecification");
		symbol_245.getSuperClasses().add(symbol_235); // pivot!TypedElement
		symbol_245.getSuperClasses().add(symbol_157); // pivot!ParameterableElement
		{	// pivot.ecore::pivot::ValueSpecification::booleanValue() pivot!ValueSpecification!booleanValue()
			Operation symbol_280 = PivotFactory.eINSTANCE.createOperation();
			symbol_280.setName("booleanValue");
			//symbol_280.setMoniker("pivot!ValueSpecification!booleanValue()");
			symbol_280.setType(symbol_13);  // pivot!Boolean
			
			symbol_245.getOwnedOperations().add(symbol_280);
		}
		{	// pivot.ecore::pivot::ValueSpecification::integerValue() pivot!ValueSpecification!integerValue()
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_281.setName("integerValue");
			//symbol_281.setMoniker("pivot!ValueSpecification!integerValue()");
			symbol_281.setType(symbol_79);  // pivot!Integer
			
			symbol_245.getOwnedOperations().add(symbol_281);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isComputable() pivot!ValueSpecification!isComputable()
			Operation symbol_282 = PivotFactory.eINSTANCE.createOperation();
			symbol_282.setName("isComputable");
			//symbol_282.setMoniker("pivot!ValueSpecification!isComputable()");
			symbol_282.setType(symbol_13);  // pivot!Boolean
			
			symbol_245.getOwnedOperations().add(symbol_282);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isNull() pivot!ValueSpecification!isNull()
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("isNull");
			//symbol_283.setMoniker("pivot!ValueSpecification!isNull()");
			symbol_283.setType(symbol_13);  // pivot!Boolean
			
			symbol_245.getOwnedOperations().add(symbol_283);
		}
		{	// pivot.ecore::pivot::ValueSpecification::stringValue() pivot!ValueSpecification!stringValue()
			Operation symbol_284 = PivotFactory.eINSTANCE.createOperation();
			symbol_284.setName("stringValue");
			//symbol_284.setMoniker("pivot!ValueSpecification!stringValue()");
			symbol_284.setType(symbol_194);  // pivot!String
			
			symbol_245.getOwnedOperations().add(symbol_284);
		}
		{	// pivot.ecore::pivot::ValueSpecification::unlimitedValue() pivot!ValueSpecification!unlimitedValue()
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("unlimitedValue");
			//symbol_285.setMoniker("pivot!ValueSpecification!unlimitedValue()");
			symbol_285.setType(symbol_238);  // pivot!UnlimitedNatural
			
			symbol_245.getOwnedOperations().add(symbol_285);
		}
		symbol_1.getOwnedTypes().add(symbol_245);
		//
		// pivot.ecore::pivot::Variable pivot!Variable
		//
		symbol_246.setName("Variable");
		//symbol_246.setMoniker("pivot!Variable");
		symbol_246.getSuperClasses().add(symbol_250); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
			symbol_247.setName("implicit");
			symbol_247.setType(symbol_13);  // pivot!Boolean
			symbol_247.setLower(BigInteger.valueOf(0));
			
			symbol_247.setIsResolveProxies(true);
			symbol_246.getOwnedAttributes().add(symbol_247);
		}
		{ // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
			symbol_248.setName("initExpression");
			symbol_248.setType(symbol_131);  // pivot!OclExpression
			symbol_248.setLower(BigInteger.valueOf(0));
			
			symbol_248.setIsComposite(true);
			symbol_248.setIsResolveProxies(true);
			symbol_246.getOwnedAttributes().add(symbol_248);
		}
		{ // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
			symbol_249.setName("representedParameter");
			symbol_249.setType(symbol_155);  // pivot!Parameter
			symbol_249.setLower(BigInteger.valueOf(0));
			
			symbol_249.setIsResolveProxies(true);
			symbol_246.getOwnedAttributes().add(symbol_249);
		}
		symbol_1.getOwnedTypes().add(symbol_246);
		//
		// pivot.ecore::pivot::VariableDeclaration pivot!VariableDeclaration
		//
		symbol_250.setName("VariableDeclaration");
		//symbol_250.setMoniker("pivot!VariableDeclaration");
		symbol_250.getSuperClasses().add(symbol_235); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_250);
		//
		// pivot.ecore::pivot::VariableExp pivot!VariableExp
		//
		symbol_251.setName("VariableExp");
		//symbol_251.setMoniker("pivot!VariableExp");
		symbol_251.getSuperClasses().add(symbol_131); // pivot!OclExpression
		{ // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
			symbol_252.setName("implicit");
			symbol_252.setType(symbol_13);  // pivot!Boolean
			symbol_252.setLower(BigInteger.valueOf(0));
			
			symbol_252.setIsResolveProxies(true);
			symbol_251.getOwnedAttributes().add(symbol_252);
		}
		{ // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
			symbol_253.setName("referredVariable");
			symbol_253.setType(symbol_250);  // pivot!VariableDeclaration
			symbol_253.setLower(BigInteger.valueOf(0));
			
			symbol_253.setIsResolveProxies(true);
			symbol_251.getOwnedAttributes().add(symbol_253);
		}
		symbol_1.getOwnedTypes().add(symbol_251);
		//
		// pivot.ecore::pivot::Visitable pivot!Visitable
		//
		symbol_254.setName("Visitable");
		//symbol_254.setMoniker("pivot!Visitable");
		symbol_1.getOwnedTypes().add(symbol_254);
		//
		// pivot.ecore::pivot::Visitor pivot!Visitor{R,C}
		//
		symbol_255.setName("Visitor");
		//symbol_255.setMoniker("pivot!Visitor{R,C}");
		symbol_258.setName("R");
		symbol_257.setOwnedParameteredElement(symbol_258);
		symbol_256.getOwnedParameters().add(symbol_257);
		symbol_260.setName("C");
		symbol_259.setOwnedParameteredElement(symbol_260);
		symbol_256.getOwnedParameters().add(symbol_259);
		
		symbol_255.setOwnedTemplateSignature(symbol_256);
		symbol_1.getOwnedTypes().add(symbol_255);
		//
		// pivot.ecore::pivot::VoidType pivot!VoidType
		//
		symbol_261.setName("VoidType");
		//symbol_261.setMoniker("pivot!VoidType");
		symbol_261.getSuperClasses().add(symbol_22); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_261);

		Class elementClass = (Class) PivotUtil.getNamedElement(symbol_1.getOwnedTypes(), "Element");
		elementClass.getSuperClasses().clear();
		elementClass.getSuperClasses().add(standardLibrary.getClassifierType());

		OclMetaModel resource = new OclMetaModel();
		resource.getContents().add(symbol_1);
		
		return symbol_1;
	}
}
