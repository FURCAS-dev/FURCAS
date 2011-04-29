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
 * $Id: OclMetaModel.java,v 1.6 2011/04/25 09:49:15 ewillink Exp $
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
		
		Class symbol_29 = PivotFactory.eINSTANCE.createClass(); // pivot!ClassifierType
		Property symbol_30 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ClassifierType::instanceType pivot!ClassifierType!instanceType
		
		Class symbol_31 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionItem
		Property symbol_32 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionItem::item pivot!CollectionItem!item
		
		Enumeration symbol_33 = PivotFactory.eINSTANCE.createEnumeration(); // pivot!CollectionKind
		
		Class symbol_34 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionLiteralExp
		Property symbol_35 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::kind pivot!CollectionLiteralExp!kind
		Property symbol_36 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::part pivot!CollectionLiteralExp!part
		
		Class symbol_37 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionLiteralPart
		
		Class symbol_38 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionRange
		Property symbol_39 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::first pivot!CollectionRange!first
		Property symbol_40 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
		
		Class symbol_41 = PivotFactory.eINSTANCE.createClass(); // pivot!CollectionType
		Property symbol_42 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
		
		Class symbol_43 = PivotFactory.eINSTANCE.createClass(); // pivot!Comment
		Property symbol_44 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
		Property symbol_45 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::body pivot!Comment!body
		
		Class symbol_46 = PivotFactory.eINSTANCE.createClass(); // pivot!Constraint
		Property symbol_47 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
		Property symbol_48 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
		Property symbol_49 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
		Property symbol_50 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
		
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // pivot!DataType
		Property symbol_52 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
		Property symbol_53 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
		
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // pivot!Detail
		Property symbol_55 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::value pivot!Detail!value
		
		Class symbol_56 = PivotFactory.eINSTANCE.createClass(); // pivot!Element
		Property symbol_57 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
		
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumLiteralExp
		Property symbol_59 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
		
		Class symbol_60 = PivotFactory.eINSTANCE.createClass(); // pivot!Enumeration
		Property symbol_61 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
		
		Class symbol_62 = PivotFactory.eINSTANCE.createClass(); // pivot!EnumerationLiteral
		Property symbol_63 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
		Property symbol_64 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
		
		Class symbol_65 = PivotFactory.eINSTANCE.createClass(); // pivot!ExpressionInOcl
		Property symbol_66 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
		Property symbol_67 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
		Property symbol_68 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
		Property symbol_69 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
		Property symbol_70 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
		
		Class symbol_71 = PivotFactory.eINSTANCE.createClass(); // pivot!Feature
		Property symbol_72 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
		Property symbol_73 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
		
		Class symbol_74 = PivotFactory.eINSTANCE.createClass(); // pivot!FeatureCallExp
		Property symbol_75 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
		
		Class symbol_76 = PivotFactory.eINSTANCE.createClass(); // pivot!IfExp
		Property symbol_77 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
		Property symbol_78 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
		Property symbol_79 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
		
		DataType symbol_80 = PivotFactory.eINSTANCE.createDataType(); // pivot!Int
		
		PrimitiveType symbol_81 = standardLibrary.getIntegerType(); // pivot!Integer
		Class symbol_82 = PivotFactory.eINSTANCE.createClass(); // pivot!IntegerLiteralExp
		Property symbol_83 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
		
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidLiteralExp
		
		Class symbol_85 = PivotFactory.eINSTANCE.createClass(); // pivot!InvalidType
		
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // pivot!IterateExp
		Property symbol_87 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
		
		Class symbol_88 = PivotFactory.eINSTANCE.createClass(); // pivot!Iteration
		Property symbol_89 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
		Property symbol_90 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
		
		Class symbol_91 = PivotFactory.eINSTANCE.createClass(); // pivot!IteratorExp
		
		Class symbol_92 = PivotFactory.eINSTANCE.createClass(); // pivot!LambdaType
		Property symbol_93 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
		Property symbol_94 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
		Property symbol_95 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
		
		Class symbol_96 = PivotFactory.eINSTANCE.createClass(); // pivot!LetExp
		Property symbol_97 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
		Property symbol_98 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
		
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // pivot!Library
		
		Class symbol_100 = PivotFactory.eINSTANCE.createClass(); // pivot!LiteralExp
		
		Class symbol_101 = PivotFactory.eINSTANCE.createClass(); // pivot!LoopExp
		Property symbol_102 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
		Property symbol_103 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
		Property symbol_104 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
		
		Class symbol_105 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageExp
		Property symbol_106 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
		Property symbol_107 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
		Property symbol_108 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
		Property symbol_109 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
		
		Class symbol_110 = PivotFactory.eINSTANCE.createClass(); // pivot!MessageType
		Property symbol_111 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
		Property symbol_112 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
		
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // pivot!MonikeredElement
		Property symbol_114 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
		
		Class symbol_115 = PivotFactory.eINSTANCE.createClass(); // pivot!MultiplicityElement
		Property symbol_116 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
		Property symbol_117 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
		Property symbol_118 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
		Property symbol_119 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
		
		Class symbol_120 = PivotFactory.eINSTANCE.createClass(); // pivot!Nameable
		
		Class symbol_121 = PivotFactory.eINSTANCE.createClass(); // pivot!NamedElement
		Property symbol_122 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
		Property symbol_123 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
		Property symbol_124 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
		Property symbol_125 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
		
		Class symbol_126 = PivotFactory.eINSTANCE.createClass(); // pivot!Namespace
		
		Class symbol_127 = PivotFactory.eINSTANCE.createClass(); // pivot!NavigationCallExp
		Property symbol_128 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
		Property symbol_129 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
		
		Class symbol_130 = PivotFactory.eINSTANCE.createClass(); // pivot!NullLiteralExp
		
		Class symbol_131 = PivotFactory.eINSTANCE.createClass(); // pivot!NumericLiteralExp
		
		DataType symbol_132 = PivotFactory.eINSTANCE.createDataType(); // pivot!Object
		
		Class symbol_133 = PivotFactory.eINSTANCE.createClass(); // pivot!OclExpression
		
		Class symbol_134 = PivotFactory.eINSTANCE.createClass(); // pivot!OpaqueExpression
		Property symbol_135 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
		Property symbol_136 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
		Property symbol_137 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
		Property symbol_138 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
		
		Class symbol_139 = PivotFactory.eINSTANCE.createClass(); // pivot!Operation
		Property symbol_140 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::class pivot!Operation!class
		Property symbol_141 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
		Property symbol_142 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
		Property symbol_143 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
		
		Class symbol_144 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationCallExp
		Property symbol_145 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
		Property symbol_146 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
		
		Class symbol_147 = PivotFactory.eINSTANCE.createClass(); // pivot!OperationTemplateParameter
		
		Class symbol_148 = PivotFactory.eINSTANCE.createClass(); // pivot!OrderedSetType
		
		Class symbol_149 = PivotFactory.eINSTANCE.createClass(); // pivot!Package
		Property symbol_150 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
		Property symbol_151 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
		Property symbol_152 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
		Property symbol_153 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
		Property symbol_154 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
		Property symbol_155 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
		
		Class symbol_156 = PivotFactory.eINSTANCE.createClass(); // pivot!PackageableElement
		
		Class symbol_157 = PivotFactory.eINSTANCE.createClass(); // pivot!Parameter
		Property symbol_158 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
		
		Class symbol_159 = PivotFactory.eINSTANCE.createClass(); // pivot!ParameterableElement
		Property symbol_160 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
		Property symbol_161 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
		
		Class symbol_162 = PivotFactory.eINSTANCE.createClass(); // pivot!Pivotable
		
		Class symbol_163 = PivotFactory.eINSTANCE.createClass(); // pivot!Precedence
		Property symbol_164 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
		Property symbol_165 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
		
		Class symbol_166 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveLiteralExp
		
		Class symbol_167 = PivotFactory.eINSTANCE.createClass(); // pivot!PrimitiveType
		
		Class symbol_168 = PivotFactory.eINSTANCE.createClass(); // pivot!Property
		Property symbol_169 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::association pivot!Property!association
		Property symbol_170 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::class pivot!Property!class
		Property symbol_171 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::default pivot!Property!default
		Property symbol_172 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
		Property symbol_173 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
		Property symbol_174 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
		Property symbol_175 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isID pivot!Property!isID
		Property symbol_176 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
		Property symbol_177 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
		Property symbol_178 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
		Property symbol_179 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
		Property symbol_180 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
		Property symbol_181 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::keys pivot!Property!keys
		Property symbol_182 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
		
		Class symbol_183 = PivotFactory.eINSTANCE.createClass(); // pivot!PropertyCallExp
		Property symbol_184 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
		
		PrimitiveType symbol_185 = standardLibrary.getRealType(); // pivot!Real
		Class symbol_186 = PivotFactory.eINSTANCE.createClass(); // pivot!RealLiteralExp
		Property symbol_187 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
		
		Class symbol_188 = PivotFactory.eINSTANCE.createClass(); // pivot!SendSignalAction
		Property symbol_189 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
		
		Class symbol_190 = PivotFactory.eINSTANCE.createClass(); // pivot!SequenceType
		
		Class symbol_191 = PivotFactory.eINSTANCE.createClass(); // pivot!SetType
		
		Class symbol_192 = PivotFactory.eINSTANCE.createClass(); // pivot!Signal
		
		Class symbol_193 = PivotFactory.eINSTANCE.createClass(); // pivot!State
		
		Class symbol_194 = PivotFactory.eINSTANCE.createClass(); // pivot!StateExp
		Property symbol_195 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
		
		PrimitiveType symbol_196 = standardLibrary.getStringType(); // pivot!String
		Class symbol_197 = PivotFactory.eINSTANCE.createClass(); // pivot!StringLiteralExp
		Property symbol_198 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
		
		Class symbol_199 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateBinding
		Property symbol_200 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
		Property symbol_201 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
		Property symbol_202 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
		
		Class symbol_203 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameter
		Property symbol_204 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
		Property symbol_205 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
		Property symbol_206 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
		Property symbol_207 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
		Property symbol_208 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
		
		Class symbol_209 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterSubstitution
		Property symbol_210 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
		Property symbol_211 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
		Property symbol_212 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
		Property symbol_213 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
		
		Class symbol_214 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateParameterType
		Property symbol_215 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
		
		Class symbol_216 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateSignature
		Property symbol_217 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
		Property symbol_218 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
		Property symbol_219 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
		
		Class symbol_220 = PivotFactory.eINSTANCE.createClass(); // pivot!TemplateableElement
		Property symbol_221 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
		Property symbol_222 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
		
		DataType symbol_223 = PivotFactory.eINSTANCE.createDataType(); // pivot!Throwable
		
		Class symbol_224 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralExp
		Property symbol_225 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
		
		Class symbol_226 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleLiteralPart
		Property symbol_227 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
		
		Class symbol_228 = PivotFactory.eINSTANCE.createClass(); // pivot!TupleType
		
		Class symbol_229 = PivotFactory.eINSTANCE.createClass(); // pivot!Type
		Property symbol_230 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
		Property symbol_231 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::package pivot!Type!package
		
		Class symbol_232 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeExp
		Property symbol_233 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
		
		Class symbol_234 = PivotFactory.eINSTANCE.createClass(); // pivot!TypeTemplateParameter
		Property symbol_235 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
		Property symbol_236 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
		
		Class symbol_237 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedElement
		Property symbol_238 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
		
		Class symbol_239 = PivotFactory.eINSTANCE.createClass(); // pivot!TypedMultiplicityElement
		
		PrimitiveType symbol_240 = standardLibrary.getUnlimitedNaturalType(); // pivot!UnlimitedNatural
		Class symbol_241 = PivotFactory.eINSTANCE.createClass(); // pivot!UnlimitedNaturalLiteralExp
		Property symbol_242 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
		
		Class symbol_243 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedType
		Property symbol_244 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
		Property symbol_245 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
		
		Class symbol_246 = PivotFactory.eINSTANCE.createClass(); // pivot!UnspecifiedValueExp
		
		Class symbol_247 = PivotFactory.eINSTANCE.createClass(); // pivot!ValueSpecification
		
		Class symbol_248 = PivotFactory.eINSTANCE.createClass(); // pivot!Variable
		Property symbol_249 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
		Property symbol_250 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
		Property symbol_251 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
		
		Class symbol_252 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableDeclaration
		
		Class symbol_253 = PivotFactory.eINSTANCE.createClass(); // pivot!VariableExp
		Property symbol_254 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
		Property symbol_255 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
		
		Class symbol_256 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitable
		
		Class symbol_257 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}
		TemplateSignature symbol_258 = PivotFactory.eINSTANCE.createTemplateSignature(); // pivot!Visitor{R,C}!
		TypeTemplateParameter symbol_259 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_260 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?R
		TypeTemplateParameter symbol_261 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_262 = PivotFactory.eINSTANCE.createClass(); // pivot!Visitor{R,C}?C
		
		
		Class symbol_263 = PivotFactory.eINSTANCE.createClass(); // pivot!VoidType
		

		symbol_1.setName("pivot");
		symbol_1.setNsPrefix("pivot");
		symbol_1.setNsURI("http://www.eclipse.org/ocl/3.1.0/Pivot");
		//
		// pivot.ecore::pivot::Annotation pivot!Annotation
		//
		symbol_2.setName("Annotation");
		//symbol_2.setMoniker("pivot!Annotation");
		symbol_2.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::Annotation::ownedContent pivot!Annotation!ownedContent
			symbol_3.setName("ownedContent");
			symbol_3.setType(symbol_56);  // pivot!Element
			symbol_3.setLower(BigInteger.valueOf(0));
			symbol_3.setUpper(BigInteger.valueOf(-1));
			symbol_3.setIsOrdered(true);
			
			symbol_3.setIsComposite(true);
			symbol_3.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_3);
		}
		{ // pivot.ecore::pivot::Annotation::ownedDetail pivot!Annotation!ownedDetail
			symbol_4.setName("ownedDetail");
			symbol_4.setType(symbol_54);  // pivot!Detail
			symbol_4.setLower(BigInteger.valueOf(0));
			symbol_4.setUpper(BigInteger.valueOf(-1));
			symbol_4.setIsOrdered(true);
			
			symbol_4.setIsComposite(true);
			symbol_4.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_4);
		}
		{ // pivot.ecore::pivot::Annotation::reference pivot!Annotation!reference
			symbol_5.setName("reference");
			symbol_5.setType(symbol_56);  // pivot!Element
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
			symbol_8.setType(symbol_168);  // pivot!Property
			symbol_8.setLower(BigInteger.valueOf(0));
			symbol_8.setUpper(BigInteger.valueOf(-1));
			
			symbol_8.setIsResolveProxies(true);
			symbol_8.setOpposite(symbol_169);
			symbol_7.getOwnedAttributes().add(symbol_8);
		}
		symbol_1.getOwnedTypes().add(symbol_7);
		//
		// pivot.ecore::pivot::AssociationClassCallExp pivot!AssociationClassCallExp
		//
		symbol_9.setName("AssociationClassCallExp");
		//symbol_9.setMoniker("pivot!AssociationClassCallExp");
		symbol_9.getSuperClasses().add(symbol_127); // pivot!NavigationCallExp
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
			EnumerationLiteral symbol_264 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Left pivot!AssociativityKind!Left
			symbol_264.setName("Left");
			symbol_11.getOwnedLiterals().add(symbol_264);
			EnumerationLiteral symbol_265 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::AssociativityKind::Right pivot!AssociativityKind!Right
			symbol_265.setName("Right");
			symbol_11.getOwnedLiterals().add(symbol_265);
		}
		
		symbol_1.getOwnedTypes().add(symbol_11);
		//
		// pivot.ecore::pivot::BagType pivot!BagType
		//
		symbol_12.setName("BagType");
		//symbol_12.setMoniker("pivot!BagType");
		symbol_12.getSuperClasses().add(symbol_41); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// pivot.ecore::pivot::BooleanLiteralExp pivot!BooleanLiteralExp
		//
		symbol_14.setName("BooleanLiteralExp");
		//symbol_14.setMoniker("pivot!BooleanLiteralExp");
		symbol_14.getSuperClasses().add(symbol_166); // pivot!PrimitiveLiteralExp
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
		symbol_16.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::CallExp::implicit pivot!CallExp!implicit
			symbol_17.setName("implicit");
			symbol_17.setType(symbol_13);  // pivot!Boolean
			symbol_17.setLower(BigInteger.valueOf(0));
			
			symbol_17.setIsResolveProxies(true);
			symbol_16.getOwnedAttributes().add(symbol_17);
		}
		{ // pivot.ecore::pivot::CallExp::source pivot!CallExp!source
			symbol_18.setName("source");
			symbol_18.setType(symbol_133);  // pivot!OclExpression
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
		symbol_19.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::CallOperationAction::operation pivot!CallOperationAction!operation
			symbol_20.setName("operation");
			symbol_20.setType(symbol_139);  // pivot!Operation
			
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
		symbol_22.getSuperClasses().add(symbol_229); // pivot!Type
		symbol_22.getSuperClasses().add(symbol_126); // pivot!Namespace
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
			symbol_25.setType(symbol_168);  // pivot!Property
			symbol_25.setLower(BigInteger.valueOf(0));
			symbol_25.setUpper(BigInteger.valueOf(-1));
			symbol_25.setIsOrdered(true);
			
			symbol_25.setIsComposite(true);
			symbol_25.setIsResolveProxies(true);
			symbol_25.setOpposite(symbol_170);
			symbol_22.getOwnedAttributes().add(symbol_25);
		}
		{ // pivot.ecore::pivot::Class::ownedOperation pivot!Class!ownedOperation
			symbol_26.setName("ownedOperation");
			symbol_26.setType(symbol_139);  // pivot!Operation
			symbol_26.setLower(BigInteger.valueOf(0));
			symbol_26.setUpper(BigInteger.valueOf(-1));
			symbol_26.setIsOrdered(true);
			
			symbol_26.setIsComposite(true);
			symbol_26.setIsResolveProxies(true);
			symbol_26.setOpposite(symbol_140);
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
		// pivot.ecore::pivot::ClassifierType pivot!ClassifierType
		//
		symbol_29.setName("ClassifierType");
		//symbol_29.setMoniker("pivot!ClassifierType");
		symbol_29.getSuperClasses().add(symbol_51); // pivot!DataType
		{ // pivot.ecore::pivot::ClassifierType::instanceType pivot!ClassifierType!instanceType
			symbol_30.setName("instanceType");
			symbol_30.setType(symbol_229);  // pivot!Type
			
			symbol_30.setIsResolveProxies(true);
			symbol_29.getOwnedAttributes().add(symbol_30);
		}
		symbol_1.getOwnedTypes().add(symbol_29);
		//
		// pivot.ecore::pivot::CollectionItem pivot!CollectionItem
		//
		symbol_31.setName("CollectionItem");
		//symbol_31.setMoniker("pivot!CollectionItem");
		symbol_31.getSuperClasses().add(symbol_37); // pivot!CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionItem::item pivot!CollectionItem!item
			symbol_32.setName("item");
			symbol_32.setType(symbol_133);  // pivot!OclExpression
			
			symbol_32.setIsComposite(true);
			symbol_32.setIsResolveProxies(true);
			symbol_31.getOwnedAttributes().add(symbol_32);
		}
		symbol_1.getOwnedTypes().add(symbol_31);
		//
		// pivot.ecore::pivot::CollectionKind pivot!CollectionKind
		//
		symbol_33.setName("CollectionKind");
		//symbol_33.setMoniker("pivot!CollectionKind");
		{
			EnumerationLiteral symbol_266 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Collection pivot!CollectionKind!Collection
			symbol_266.setName("Collection");
			symbol_33.getOwnedLiterals().add(symbol_266);
			EnumerationLiteral symbol_267 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Set pivot!CollectionKind!Set
			symbol_267.setName("Set");
			symbol_33.getOwnedLiterals().add(symbol_267);
			EnumerationLiteral symbol_268 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::OrderedSet pivot!CollectionKind!OrderedSet
			symbol_268.setName("OrderedSet");
			symbol_33.getOwnedLiterals().add(symbol_268);
			EnumerationLiteral symbol_269 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Bag pivot!CollectionKind!Bag
			symbol_269.setName("Bag");
			symbol_33.getOwnedLiterals().add(symbol_269);
			EnumerationLiteral symbol_270 = PivotFactory.eINSTANCE.createEnumerationLiteral(); // pivot.ecore::pivot::CollectionKind::Sequence pivot!CollectionKind!Sequence
			symbol_270.setName("Sequence");
			symbol_33.getOwnedLiterals().add(symbol_270);
		}
		
		symbol_1.getOwnedTypes().add(symbol_33);
		//
		// pivot.ecore::pivot::CollectionLiteralExp pivot!CollectionLiteralExp
		//
		symbol_34.setName("CollectionLiteralExp");
		//symbol_34.setMoniker("pivot!CollectionLiteralExp");
		symbol_34.getSuperClasses().add(symbol_100); // pivot!LiteralExp
		{ // pivot.ecore::pivot::CollectionLiteralExp::kind pivot!CollectionLiteralExp!kind
			symbol_35.setName("kind");
			symbol_35.setType(symbol_33);  // pivot!CollectionKind
			
			symbol_35.setIsResolveProxies(true);
			symbol_34.getOwnedAttributes().add(symbol_35);
		}
		{ // pivot.ecore::pivot::CollectionLiteralExp::part pivot!CollectionLiteralExp!part
			symbol_36.setName("part");
			symbol_36.setType(symbol_37);  // pivot!CollectionLiteralPart
			symbol_36.setLower(BigInteger.valueOf(0));
			symbol_36.setUpper(BigInteger.valueOf(-1));
			symbol_36.setIsOrdered(true);
			
			symbol_36.setIsComposite(true);
			symbol_36.setIsResolveProxies(true);
			symbol_34.getOwnedAttributes().add(symbol_36);
		}
		symbol_1.getOwnedTypes().add(symbol_34);
		//
		// pivot.ecore::pivot::CollectionLiteralPart pivot!CollectionLiteralPart
		//
		symbol_37.setName("CollectionLiteralPart");
		//symbol_37.setMoniker("pivot!CollectionLiteralPart");
		symbol_37.getSuperClasses().add(symbol_237); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_37);
		//
		// pivot.ecore::pivot::CollectionRange pivot!CollectionRange
		//
		symbol_38.setName("CollectionRange");
		//symbol_38.setMoniker("pivot!CollectionRange");
		symbol_38.getSuperClasses().add(symbol_37); // pivot!CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionRange::first pivot!CollectionRange!first
			symbol_39.setName("first");
			symbol_39.setType(symbol_133);  // pivot!OclExpression
			
			symbol_39.setIsComposite(true);
			symbol_39.setIsResolveProxies(true);
			symbol_38.getOwnedAttributes().add(symbol_39);
		}
		{ // pivot.ecore::pivot::CollectionRange::last pivot!CollectionRange!last
			symbol_40.setName("last");
			symbol_40.setType(symbol_133);  // pivot!OclExpression
			
			symbol_40.setIsComposite(true);
			symbol_40.setIsResolveProxies(true);
			symbol_38.getOwnedAttributes().add(symbol_40);
		}
		symbol_1.getOwnedTypes().add(symbol_38);
		//
		// pivot.ecore::pivot::CollectionType pivot!CollectionType
		//
		symbol_41.setName("CollectionType");
		//symbol_41.setMoniker("pivot!CollectionType");
		symbol_41.getSuperClasses().add(symbol_51); // pivot!DataType
		{ // pivot.ecore::pivot::CollectionType::elementType pivot!CollectionType!elementType
			symbol_42.setName("elementType");
			symbol_42.setType(symbol_229);  // pivot!Type
			
			symbol_42.setIsResolveProxies(true);
			symbol_41.getOwnedAttributes().add(symbol_42);
		}
		symbol_1.getOwnedTypes().add(symbol_41);
		//
		// pivot.ecore::pivot::Comment pivot!Comment
		//
		symbol_43.setName("Comment");
		//symbol_43.setMoniker("pivot!Comment");
		symbol_43.getSuperClasses().add(symbol_56); // pivot!Element
		{ // pivot.ecore::pivot::Comment::annotatedElement pivot!Comment!annotatedElement
			symbol_44.setName("annotatedElement");
			symbol_44.setType(symbol_56);  // pivot!Element
			symbol_44.setLower(BigInteger.valueOf(0));
			symbol_44.setUpper(BigInteger.valueOf(-1));
			
			symbol_44.setIsResolveProxies(true);
			symbol_43.getOwnedAttributes().add(symbol_44);
		}
		{ // pivot.ecore::pivot::Comment::body pivot!Comment!body
			symbol_45.setName("body");
			symbol_45.setType(symbol_196);  // pivot!String
			symbol_45.setLower(BigInteger.valueOf(0));
			
			symbol_45.setIsResolveProxies(true);
			symbol_43.getOwnedAttributes().add(symbol_45);
		}
		symbol_1.getOwnedTypes().add(symbol_43);
		//
		// pivot.ecore::pivot::Constraint pivot!Constraint
		//
		symbol_46.setName("Constraint");
		//symbol_46.setMoniker("pivot!Constraint");
		symbol_46.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::Constraint::constrainedElement pivot!Constraint!constrainedElement
			symbol_47.setName("constrainedElement");
			symbol_47.setType(symbol_56);  // pivot!Element
			symbol_47.setLower(BigInteger.valueOf(0));
			symbol_47.setUpper(BigInteger.valueOf(-1));
			symbol_47.setIsOrdered(true);
			
			symbol_47.setIsResolveProxies(true);
			symbol_46.getOwnedAttributes().add(symbol_47);
		}
		{ // pivot.ecore::pivot::Constraint::context pivot!Constraint!context
			symbol_48.setName("context");
			symbol_48.setType(symbol_121);  // pivot!NamedElement
			symbol_48.setLower(BigInteger.valueOf(0));
			
			symbol_48.setIsResolveProxies(true);
			symbol_46.getOwnedAttributes().add(symbol_48);
		}
		{ // pivot.ecore::pivot::Constraint::specification pivot!Constraint!specification
			symbol_49.setName("specification");
			symbol_49.setType(symbol_247);  // pivot!ValueSpecification
			
			symbol_49.setIsComposite(true);
			symbol_49.setIsResolveProxies(true);
			symbol_46.getOwnedAttributes().add(symbol_49);
		}
		{ // pivot.ecore::pivot::Constraint::stereotype pivot!Constraint!stereotype
			symbol_50.setName("stereotype");
			symbol_50.setType(symbol_196);  // pivot!String
			symbol_50.setLower(BigInteger.valueOf(0));
			
			symbol_50.setIsResolveProxies(true);
			symbol_46.getOwnedAttributes().add(symbol_50);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// pivot.ecore::pivot::DataType pivot!DataType
		//
		symbol_51.setName("DataType");
		//symbol_51.setMoniker("pivot!DataType");
		symbol_51.getSuperClasses().add(symbol_22); // pivot!Class
		{ // pivot.ecore::pivot::DataType::behavioralType pivot!DataType!behavioralType
			symbol_52.setName("behavioralType");
			symbol_52.setType(symbol_229);  // pivot!Type
			symbol_52.setLower(BigInteger.valueOf(0));
			
			symbol_52.setIsResolveProxies(true);
			symbol_51.getOwnedAttributes().add(symbol_52);
		}
		{ // pivot.ecore::pivot::DataType::isSerializable pivot!DataType!isSerializable
			symbol_53.setName("isSerializable");
			symbol_53.setType(symbol_13);  // pivot!Boolean
			
			symbol_53.setIsResolveProxies(true);
			symbol_51.getOwnedAttributes().add(symbol_53);
		}
		symbol_1.getOwnedTypes().add(symbol_51);
		//
		// pivot.ecore::pivot::Detail pivot!Detail
		//
		symbol_54.setName("Detail");
		//symbol_54.setMoniker("pivot!Detail");
		symbol_54.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::Detail::value pivot!Detail!value
			symbol_55.setName("value");
			symbol_55.setType(symbol_196);  // pivot!String
			symbol_55.setUpper(BigInteger.valueOf(-1));
			
			symbol_55.setIsResolveProxies(true);
			symbol_54.getOwnedAttributes().add(symbol_55);
		}
		symbol_1.getOwnedTypes().add(symbol_54);
		//
		// pivot.ecore::pivot::Element pivot!Element
		//
		symbol_56.setName("Element");
		//symbol_56.setMoniker("pivot!Element");
		symbol_56.getSuperClasses().add(symbol_256); // pivot!Visitable
		{ // pivot.ecore::pivot::Element::ownedComment pivot!Element!ownedComment
			symbol_57.setName("ownedComment");
			symbol_57.setType(symbol_43);  // pivot!Comment
			symbol_57.setLower(BigInteger.valueOf(0));
			symbol_57.setUpper(BigInteger.valueOf(-1));
			
			symbol_57.setIsComposite(true);
			symbol_57.setIsResolveProxies(true);
			symbol_56.getOwnedAttributes().add(symbol_57);
		}
		symbol_1.getOwnedTypes().add(symbol_56);
		//
		// pivot.ecore::pivot::EnumLiteralExp pivot!EnumLiteralExp
		//
		symbol_58.setName("EnumLiteralExp");
		//symbol_58.setMoniker("pivot!EnumLiteralExp");
		symbol_58.getSuperClasses().add(symbol_100); // pivot!LiteralExp
		{ // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot!EnumLiteralExp!referredEnumLiteral
			symbol_59.setName("referredEnumLiteral");
			symbol_59.setType(symbol_62);  // pivot!EnumerationLiteral
			symbol_59.setLower(BigInteger.valueOf(0));
			
			symbol_59.setIsResolveProxies(true);
			symbol_58.getOwnedAttributes().add(symbol_59);
		}
		symbol_1.getOwnedTypes().add(symbol_58);
		//
		// pivot.ecore::pivot::Enumeration pivot!Enumeration
		//
		symbol_60.setName("Enumeration");
		//symbol_60.setMoniker("pivot!Enumeration");
		symbol_60.getSuperClasses().add(symbol_51); // pivot!DataType
		{ // pivot.ecore::pivot::Enumeration::ownedLiteral pivot!Enumeration!ownedLiteral
			symbol_61.setName("ownedLiteral");
			symbol_61.setType(symbol_62);  // pivot!EnumerationLiteral
			symbol_61.setLower(BigInteger.valueOf(0));
			symbol_61.setUpper(BigInteger.valueOf(-1));
			symbol_61.setIsOrdered(true);
			
			symbol_61.setIsComposite(true);
			symbol_61.setIsResolveProxies(true);
			symbol_61.setOpposite(symbol_63);
			symbol_60.getOwnedAttributes().add(symbol_61);
		}
		symbol_1.getOwnedTypes().add(symbol_60);
		//
		// pivot.ecore::pivot::EnumerationLiteral pivot!EnumerationLiteral
		//
		symbol_62.setName("EnumerationLiteral");
		//symbol_62.setMoniker("pivot!EnumerationLiteral");
		symbol_62.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot!EnumerationLiteral!enumeration
			symbol_63.setName("enumeration");
			symbol_63.setType(symbol_60);  // pivot!Enumeration
			symbol_63.setLower(BigInteger.valueOf(0));
			
			symbol_63.setIsResolveProxies(true);
			symbol_63.setOpposite(symbol_61);
			symbol_62.getOwnedAttributes().add(symbol_63);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::value pivot!EnumerationLiteral!value
			symbol_64.setName("value");
			symbol_64.setType(symbol_81);  // pivot!Integer
			symbol_64.setLower(BigInteger.valueOf(0));
			
			symbol_64.setIsResolveProxies(true);
			symbol_62.getOwnedAttributes().add(symbol_64);
		}
		symbol_1.getOwnedTypes().add(symbol_62);
		//
		// pivot.ecore::pivot::ExpressionInOcl pivot!ExpressionInOcl
		//
		symbol_65.setName("ExpressionInOcl");
		//symbol_65.setMoniker("pivot!ExpressionInOcl");
		symbol_65.getSuperClasses().add(symbol_134); // pivot!OpaqueExpression
		{ // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot!ExpressionInOcl!bodyExpression
			symbol_66.setName("bodyExpression");
			symbol_66.setType(symbol_133);  // pivot!OclExpression
			
			symbol_66.setIsComposite(true);
			symbol_66.setIsResolveProxies(true);
			symbol_65.getOwnedAttributes().add(symbol_66);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot!ExpressionInOcl!contextVariable
			symbol_67.setName("contextVariable");
			symbol_67.setType(symbol_248);  // pivot!Variable
			symbol_67.setLower(BigInteger.valueOf(0));
			
			symbol_67.setIsComposite(true);
			symbol_67.setIsResolveProxies(true);
			symbol_65.getOwnedAttributes().add(symbol_67);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::messageExpression pivot!ExpressionInOcl!messageExpression
			symbol_68.setName("messageExpression");
			symbol_68.setType(symbol_133);  // pivot!OclExpression
			symbol_68.setLower(BigInteger.valueOf(0));
			
			symbol_68.setIsComposite(true);
			symbol_68.setIsResolveProxies(true);
			symbol_65.getOwnedAttributes().add(symbol_68);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot!ExpressionInOcl!parameterVariable
			symbol_69.setName("parameterVariable");
			symbol_69.setType(symbol_248);  // pivot!Variable
			symbol_69.setLower(BigInteger.valueOf(0));
			symbol_69.setUpper(BigInteger.valueOf(-1));
			symbol_69.setIsOrdered(true);
			
			symbol_69.setIsComposite(true);
			symbol_69.setIsResolveProxies(true);
			symbol_65.getOwnedAttributes().add(symbol_69);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot!ExpressionInOcl!resultVariable
			symbol_70.setName("resultVariable");
			symbol_70.setType(symbol_248);  // pivot!Variable
			symbol_70.setLower(BigInteger.valueOf(0));
			
			symbol_70.setIsComposite(true);
			symbol_70.setIsResolveProxies(true);
			symbol_65.getOwnedAttributes().add(symbol_70);
		}
		symbol_1.getOwnedTypes().add(symbol_65);
		//
		// pivot.ecore::pivot::Feature pivot!Feature
		//
		symbol_71.setName("Feature");
		//symbol_71.setMoniker("pivot!Feature");
		symbol_71.getSuperClasses().add(symbol_239); // pivot!TypedMultiplicityElement
		{ // pivot.ecore::pivot::Feature::implementation pivot!Feature!implementation
			symbol_72.setName("implementation");
			symbol_72.setType(symbol_21);  // pivot!CallableImplementation
			symbol_72.setLower(BigInteger.valueOf(0));
			
			symbol_72.setIsResolveProxies(true);
			symbol_72.setIsTransient(true);
			symbol_71.getOwnedAttributes().add(symbol_72);
		}
		{ // pivot.ecore::pivot::Feature::implementationClass pivot!Feature!implementationClass
			symbol_73.setName("implementationClass");
			symbol_73.setType(symbol_196);  // pivot!String
			symbol_73.setLower(BigInteger.valueOf(0));
			
			symbol_73.setIsResolveProxies(true);
			symbol_71.getOwnedAttributes().add(symbol_73);
		}
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// pivot.ecore::pivot::FeatureCallExp pivot!FeatureCallExp
		//
		symbol_74.setName("FeatureCallExp");
		//symbol_74.setMoniker("pivot!FeatureCallExp");
		symbol_74.getSuperClasses().add(symbol_16); // pivot!CallExp
		{ // pivot.ecore::pivot::FeatureCallExp::isPre pivot!FeatureCallExp!isPre
			symbol_75.setName("isPre");
			symbol_75.setType(symbol_13);  // pivot!Boolean
			
			symbol_75.setIsResolveProxies(true);
			symbol_74.getOwnedAttributes().add(symbol_75);
		}
		symbol_1.getOwnedTypes().add(symbol_74);
		//
		// pivot.ecore::pivot::IfExp pivot!IfExp
		//
		symbol_76.setName("IfExp");
		//symbol_76.setMoniker("pivot!IfExp");
		symbol_76.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::IfExp::condition pivot!IfExp!condition
			symbol_77.setName("condition");
			symbol_77.setType(symbol_133);  // pivot!OclExpression
			
			symbol_77.setIsComposite(true);
			symbol_77.setIsResolveProxies(true);
			symbol_76.getOwnedAttributes().add(symbol_77);
		}
		{ // pivot.ecore::pivot::IfExp::elseExpression pivot!IfExp!elseExpression
			symbol_78.setName("elseExpression");
			symbol_78.setType(symbol_133);  // pivot!OclExpression
			
			symbol_78.setIsComposite(true);
			symbol_78.setIsResolveProxies(true);
			symbol_76.getOwnedAttributes().add(symbol_78);
		}
		{ // pivot.ecore::pivot::IfExp::thenExpression pivot!IfExp!thenExpression
			symbol_79.setName("thenExpression");
			symbol_79.setType(symbol_133);  // pivot!OclExpression
			
			symbol_79.setIsComposite(true);
			symbol_79.setIsResolveProxies(true);
			symbol_76.getOwnedAttributes().add(symbol_79);
		}
		symbol_1.getOwnedTypes().add(symbol_76);
		//
		// pivot.ecore::pivot::Int pivot!Int
		//
		symbol_80.setName("Int");
		//symbol_80.setMoniker("pivot!Int");
		symbol_1.getOwnedTypes().add(symbol_80);
		//
		// pivot.ecore::pivot::IntegerLiteralExp pivot!IntegerLiteralExp
		//
		symbol_82.setName("IntegerLiteralExp");
		//symbol_82.setMoniker("pivot!IntegerLiteralExp");
		symbol_82.getSuperClasses().add(symbol_131); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot!IntegerLiteralExp!integerSymbol
			symbol_83.setName("integerSymbol");
			symbol_83.setType(symbol_81);  // pivot!Integer
			
			symbol_83.setIsResolveProxies(true);
			symbol_82.getOwnedAttributes().add(symbol_83);
		}
		symbol_1.getOwnedTypes().add(symbol_82);
		//
		// pivot.ecore::pivot::InvalidLiteralExp pivot!InvalidLiteralExp
		//
		symbol_84.setName("InvalidLiteralExp");
		//symbol_84.setMoniker("pivot!InvalidLiteralExp");
		symbol_84.getSuperClasses().add(symbol_100); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// pivot.ecore::pivot::InvalidType pivot!InvalidType
		//
		symbol_85.setName("InvalidType");
		//symbol_85.setMoniker("pivot!InvalidType");
		symbol_85.getSuperClasses().add(symbol_22); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// pivot.ecore::pivot::IterateExp pivot!IterateExp
		//
		symbol_86.setName("IterateExp");
		//symbol_86.setMoniker("pivot!IterateExp");
		symbol_86.getSuperClasses().add(symbol_101); // pivot!LoopExp
		{ // pivot.ecore::pivot::IterateExp::result pivot!IterateExp!result
			symbol_87.setName("result");
			symbol_87.setType(symbol_248);  // pivot!Variable
			symbol_87.setLower(BigInteger.valueOf(0));
			symbol_87.setIsOrdered(true);
			
			symbol_87.setIsComposite(true);
			symbol_87.setIsResolveProxies(true);
			symbol_86.getOwnedAttributes().add(symbol_87);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// pivot.ecore::pivot::Iteration pivot!Iteration
		//
		symbol_88.setName("Iteration");
		//symbol_88.setMoniker("pivot!Iteration");
		symbol_88.getSuperClasses().add(symbol_139); // pivot!Operation
		{ // pivot.ecore::pivot::Iteration::ownedAccumulator pivot!Iteration!ownedAccumulator
			symbol_89.setName("ownedAccumulator");
			symbol_89.setType(symbol_157);  // pivot!Parameter
			symbol_89.setLower(BigInteger.valueOf(0));
			symbol_89.setUpper(BigInteger.valueOf(-1));
			
			symbol_89.setIsComposite(true);
			symbol_89.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_89);
		}
		{ // pivot.ecore::pivot::Iteration::ownedIterator pivot!Iteration!ownedIterator
			symbol_90.setName("ownedIterator");
			symbol_90.setType(symbol_157);  // pivot!Parameter
			symbol_90.setLower(BigInteger.valueOf(0));
			symbol_90.setUpper(BigInteger.valueOf(-1));
			
			symbol_90.setIsComposite(true);
			symbol_90.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_90);
		}
		symbol_1.getOwnedTypes().add(symbol_88);
		//
		// pivot.ecore::pivot::IteratorExp pivot!IteratorExp
		//
		symbol_91.setName("IteratorExp");
		//symbol_91.setMoniker("pivot!IteratorExp");
		symbol_91.getSuperClasses().add(symbol_101); // pivot!LoopExp
		symbol_1.getOwnedTypes().add(symbol_91);
		//
		// pivot.ecore::pivot::LambdaType pivot!LambdaType
		//
		symbol_92.setName("LambdaType");
		//symbol_92.setMoniker("pivot!LambdaType");
		symbol_92.getSuperClasses().add(symbol_51); // pivot!DataType
		{ // pivot.ecore::pivot::LambdaType::contextType pivot!LambdaType!contextType
			symbol_93.setName("contextType");
			symbol_93.setType(symbol_229);  // pivot!Type
			
			symbol_93.setIsResolveProxies(true);
			symbol_92.getOwnedAttributes().add(symbol_93);
		}
		{ // pivot.ecore::pivot::LambdaType::parameterType pivot!LambdaType!parameterType
			symbol_94.setName("parameterType");
			symbol_94.setType(symbol_229);  // pivot!Type
			symbol_94.setLower(BigInteger.valueOf(0));
			symbol_94.setUpper(BigInteger.valueOf(-1));
			
			symbol_94.setIsResolveProxies(true);
			symbol_92.getOwnedAttributes().add(symbol_94);
		}
		{ // pivot.ecore::pivot::LambdaType::resultType pivot!LambdaType!resultType
			symbol_95.setName("resultType");
			symbol_95.setType(symbol_229);  // pivot!Type
			
			symbol_95.setIsResolveProxies(true);
			symbol_92.getOwnedAttributes().add(symbol_95);
		}
		symbol_1.getOwnedTypes().add(symbol_92);
		//
		// pivot.ecore::pivot::LetExp pivot!LetExp
		//
		symbol_96.setName("LetExp");
		//symbol_96.setMoniker("pivot!LetExp");
		symbol_96.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::LetExp::in pivot!LetExp!in
			symbol_97.setName("in");
			symbol_97.setType(symbol_133);  // pivot!OclExpression
			
			symbol_97.setIsComposite(true);
			symbol_97.setIsResolveProxies(true);
			symbol_96.getOwnedAttributes().add(symbol_97);
		}
		{ // pivot.ecore::pivot::LetExp::variable pivot!LetExp!variable
			symbol_98.setName("variable");
			symbol_98.setType(symbol_248);  // pivot!Variable
			
			symbol_98.setIsComposite(true);
			symbol_98.setIsResolveProxies(true);
			symbol_96.getOwnedAttributes().add(symbol_98);
		}
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// pivot.ecore::pivot::Library pivot!Library
		//
		symbol_99.setName("Library");
		//symbol_99.setMoniker("pivot!Library");
		symbol_99.getSuperClasses().add(symbol_149); // pivot!Package
		symbol_1.getOwnedTypes().add(symbol_99);
		//
		// pivot.ecore::pivot::LiteralExp pivot!LiteralExp
		//
		symbol_100.setName("LiteralExp");
		//symbol_100.setMoniker("pivot!LiteralExp");
		symbol_100.getSuperClasses().add(symbol_133); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_100);
		//
		// pivot.ecore::pivot::LoopExp pivot!LoopExp
		//
		symbol_101.setName("LoopExp");
		//symbol_101.setMoniker("pivot!LoopExp");
		symbol_101.getSuperClasses().add(symbol_16); // pivot!CallExp
		{ // pivot.ecore::pivot::LoopExp::body pivot!LoopExp!body
			symbol_102.setName("body");
			symbol_102.setType(symbol_133);  // pivot!OclExpression
			
			symbol_102.setIsComposite(true);
			symbol_102.setIsResolveProxies(true);
			symbol_101.getOwnedAttributes().add(symbol_102);
		}
		{ // pivot.ecore::pivot::LoopExp::iterator pivot!LoopExp!iterator
			symbol_103.setName("iterator");
			symbol_103.setType(symbol_248);  // pivot!Variable
			symbol_103.setLower(BigInteger.valueOf(0));
			symbol_103.setUpper(BigInteger.valueOf(-1));
			symbol_103.setIsOrdered(true);
			
			symbol_103.setIsComposite(true);
			symbol_103.setIsResolveProxies(true);
			symbol_101.getOwnedAttributes().add(symbol_103);
		}
		{ // pivot.ecore::pivot::LoopExp::referredIteration pivot!LoopExp!referredIteration
			symbol_104.setName("referredIteration");
			symbol_104.setType(symbol_88);  // pivot!Iteration
			symbol_104.setLower(BigInteger.valueOf(0));
			
			symbol_104.setIsResolveProxies(true);
			symbol_101.getOwnedAttributes().add(symbol_104);
		}
		symbol_1.getOwnedTypes().add(symbol_101);
		//
		// pivot.ecore::pivot::MessageExp pivot!MessageExp
		//
		symbol_105.setName("MessageExp");
		//symbol_105.setMoniker("pivot!MessageExp");
		symbol_105.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::MessageExp::argument pivot!MessageExp!argument
			symbol_106.setName("argument");
			symbol_106.setType(symbol_133);  // pivot!OclExpression
			symbol_106.setLower(BigInteger.valueOf(0));
			symbol_106.setUpper(BigInteger.valueOf(-1));
			
			symbol_106.setIsComposite(true);
			symbol_106.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_106);
		}
		{ // pivot.ecore::pivot::MessageExp::calledOperation pivot!MessageExp!calledOperation
			symbol_107.setName("calledOperation");
			symbol_107.setType(symbol_19);  // pivot!CallOperationAction
			symbol_107.setLower(BigInteger.valueOf(0));
			
			symbol_107.setIsComposite(true);
			symbol_107.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_107);
		}
		{ // pivot.ecore::pivot::MessageExp::sentSignal pivot!MessageExp!sentSignal
			symbol_108.setName("sentSignal");
			symbol_108.setType(symbol_188);  // pivot!SendSignalAction
			symbol_108.setLower(BigInteger.valueOf(0));
			
			symbol_108.setIsComposite(true);
			symbol_108.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_108);
		}
		{ // pivot.ecore::pivot::MessageExp::target pivot!MessageExp!target
			symbol_109.setName("target");
			symbol_109.setType(symbol_133);  // pivot!OclExpression
			
			symbol_109.setIsComposite(true);
			symbol_109.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_109);
		}
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// pivot.ecore::pivot::MessageType pivot!MessageType
		//
		symbol_110.setName("MessageType");
		//symbol_110.setMoniker("pivot!MessageType");
		symbol_110.getSuperClasses().add(symbol_229); // pivot!Type
		{ // pivot.ecore::pivot::MessageType::referredOperation pivot!MessageType!referredOperation
			symbol_111.setName("referredOperation");
			symbol_111.setType(symbol_139);  // pivot!Operation
			symbol_111.setLower(BigInteger.valueOf(0));
			
			symbol_111.setIsResolveProxies(true);
			symbol_110.getOwnedAttributes().add(symbol_111);
		}
		{ // pivot.ecore::pivot::MessageType::referredSignal pivot!MessageType!referredSignal
			symbol_112.setName("referredSignal");
			symbol_112.setType(symbol_192);  // pivot!Signal
			symbol_112.setLower(BigInteger.valueOf(0));
			
			symbol_112.setIsResolveProxies(true);
			symbol_110.getOwnedAttributes().add(symbol_112);
		}
		symbol_1.getOwnedTypes().add(symbol_110);
		//
		// pivot.ecore::pivot::MonikeredElement pivot!MonikeredElement
		//
		symbol_113.setName("MonikeredElement");
		//symbol_113.setMoniker("pivot!MonikeredElement");
		symbol_113.getSuperClasses().add(symbol_56); // pivot!Element
		{ // pivot.ecore::pivot::MonikeredElement::moniker pivot!MonikeredElement!moniker
			symbol_114.setName("moniker");
			symbol_114.setType(symbol_196);  // pivot!String
			
			symbol_114.setIsDerived(true);
			symbol_114.setIsResolveProxies(true);
			symbol_114.setIsTransient(true);
			symbol_114.setIsVolatile(true);
			symbol_113.getOwnedAttributes().add(symbol_114);
		}
		{	// pivot.ecore::pivot::MonikeredElement::hasMoniker() pivot!MonikeredElement!hasMoniker()
			Operation symbol_271 = PivotFactory.eINSTANCE.createOperation();
			symbol_271.setName("hasMoniker");
			//symbol_271.setMoniker("pivot!MonikeredElement!hasMoniker()");
			symbol_271.setType(symbol_13);  // pivot!Boolean
			
			symbol_113.getOwnedOperations().add(symbol_271);
		}
		symbol_1.getOwnedTypes().add(symbol_113);
		//
		// pivot.ecore::pivot::MultiplicityElement pivot!MultiplicityElement
		//
		symbol_115.setName("MultiplicityElement");
		//symbol_115.setMoniker("pivot!MultiplicityElement");
		symbol_115.getSuperClasses().add(symbol_113); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot!MultiplicityElement!isOrdered
			symbol_116.setName("isOrdered");
			symbol_116.setType(symbol_13);  // pivot!Boolean
			
			symbol_116.setIsResolveProxies(true);
			symbol_115.getOwnedAttributes().add(symbol_116);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::isUnique pivot!MultiplicityElement!isUnique
			symbol_117.setName("isUnique");
			symbol_117.setType(symbol_13);  // pivot!Boolean
			
			symbol_117.setIsResolveProxies(true);
			symbol_115.getOwnedAttributes().add(symbol_117);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::lower pivot!MultiplicityElement!lower
			symbol_118.setName("lower");
			symbol_118.setType(symbol_81);  // pivot!Integer
			symbol_118.setLower(BigInteger.valueOf(0));
			
			symbol_118.setIsResolveProxies(true);
			symbol_115.getOwnedAttributes().add(symbol_118);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::upper pivot!MultiplicityElement!upper
			symbol_119.setName("upper");
			symbol_119.setType(symbol_240);  // pivot!UnlimitedNatural
			symbol_119.setLower(BigInteger.valueOf(0));
			
			symbol_119.setIsResolveProxies(true);
			symbol_115.getOwnedAttributes().add(symbol_119);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesCardinality() pivot!MultiplicityElement!includesCardinality(pivot!Integer)
			Operation symbol_272 = PivotFactory.eINSTANCE.createOperation();
			symbol_272.setName("includesCardinality");
			//symbol_272.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)");
			symbol_272.setType(symbol_13);  // pivot!Boolean
			
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("C");
			//symbol_273.setMoniker("pivot!MultiplicityElement!includesCardinality(pivot!Integer)!C");
			symbol_273.setType(symbol_81);  // pivot!Integer
			
			symbol_272.getOwnedParameters().add(symbol_273);
			symbol_115.getOwnedOperations().add(symbol_272);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesMultiplicity() pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)
			Operation symbol_274 = PivotFactory.eINSTANCE.createOperation();
			symbol_274.setName("includesMultiplicity");
			//symbol_274.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)");
			symbol_274.setType(symbol_13);  // pivot!Boolean
			
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("M");
			//symbol_275.setMoniker("pivot!MultiplicityElement!includesMultiplicity(pivot!MultiplicityElement)!M");
			symbol_275.setType(symbol_115);  // pivot!MultiplicityElement
			
			symbol_274.getOwnedParameters().add(symbol_275);
			symbol_115.getOwnedOperations().add(symbol_274);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::isMultivalued() pivot!MultiplicityElement!isMultivalued()
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("isMultivalued");
			//symbol_276.setMoniker("pivot!MultiplicityElement!isMultivalued()");
			symbol_276.setType(symbol_13);  // pivot!Boolean
			
			symbol_115.getOwnedOperations().add(symbol_276);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::lowerBound() pivot!MultiplicityElement!lowerBound()
			Operation symbol_277 = PivotFactory.eINSTANCE.createOperation();
			symbol_277.setName("lowerBound");
			//symbol_277.setMoniker("pivot!MultiplicityElement!lowerBound()");
			symbol_277.setType(symbol_81);  // pivot!Integer
			
			symbol_115.getOwnedOperations().add(symbol_277);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::upperBound() pivot!MultiplicityElement!upperBound()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_278.setName("upperBound");
			//symbol_278.setMoniker("pivot!MultiplicityElement!upperBound()");
			symbol_278.setType(symbol_240);  // pivot!UnlimitedNatural
			
			symbol_115.getOwnedOperations().add(symbol_278);
		}
		symbol_1.getOwnedTypes().add(symbol_115);
		//
		// pivot.ecore::pivot::Nameable pivot!Nameable
		//
		symbol_120.setName("Nameable");
		//symbol_120.setMoniker("pivot!Nameable");
		symbol_1.getOwnedTypes().add(symbol_120);
		//
		// pivot.ecore::pivot::NamedElement pivot!NamedElement
		//
		symbol_121.setName("NamedElement");
		//symbol_121.setMoniker("pivot!NamedElement");
		symbol_121.getSuperClasses().add(symbol_120); // pivot!Nameable
		symbol_121.getSuperClasses().add(symbol_113); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::NamedElement::isStatic pivot!NamedElement!isStatic
			symbol_122.setName("isStatic");
			symbol_122.setType(symbol_13);  // pivot!Boolean
			
			symbol_122.setIsResolveProxies(true);
			symbol_121.getOwnedAttributes().add(symbol_122);
		}
		{ // pivot.ecore::pivot::NamedElement::name pivot!NamedElement!name
			symbol_123.setName("name");
			symbol_123.setType(symbol_196);  // pivot!String
			symbol_123.setLower(BigInteger.valueOf(0));
			
			symbol_123.setIsResolveProxies(true);
			symbol_121.getOwnedAttributes().add(symbol_123);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot!NamedElement!ownedAnnotation
			symbol_124.setName("ownedAnnotation");
			symbol_124.setType(symbol_2);  // pivot!Annotation
			symbol_124.setLower(BigInteger.valueOf(0));
			symbol_124.setUpper(BigInteger.valueOf(-1));
			symbol_124.setIsOrdered(true);
			
			symbol_124.setIsComposite(true);
			symbol_124.setIsResolveProxies(true);
			symbol_121.getOwnedAttributes().add(symbol_124);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedRule pivot!NamedElement!ownedRule
			symbol_125.setName("ownedRule");
			symbol_125.setType(symbol_46);  // pivot!Constraint
			symbol_125.setLower(BigInteger.valueOf(0));
			symbol_125.setUpper(BigInteger.valueOf(-1));
			
			symbol_125.setIsComposite(true);
			symbol_125.setIsResolveProxies(true);
			symbol_121.getOwnedAttributes().add(symbol_125);
		}
		symbol_1.getOwnedTypes().add(symbol_121);
		//
		// pivot.ecore::pivot::Namespace pivot!Namespace
		//
		symbol_126.setName("Namespace");
		//symbol_126.setMoniker("pivot!Namespace");
		symbol_126.getSuperClasses().add(symbol_121); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_126);
		//
		// pivot.ecore::pivot::NavigationCallExp pivot!NavigationCallExp
		//
		symbol_127.setName("NavigationCallExp");
		//symbol_127.setMoniker("pivot!NavigationCallExp");
		symbol_127.getSuperClasses().add(symbol_74); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot!NavigationCallExp!navigationSource
			symbol_128.setName("navigationSource");
			symbol_128.setType(symbol_168);  // pivot!Property
			symbol_128.setLower(BigInteger.valueOf(0));
			symbol_128.setIsOrdered(true);
			
			symbol_128.setIsResolveProxies(true);
			symbol_127.getOwnedAttributes().add(symbol_128);
		}
		{ // pivot.ecore::pivot::NavigationCallExp::qualifier pivot!NavigationCallExp!qualifier
			symbol_129.setName("qualifier");
			symbol_129.setType(symbol_133);  // pivot!OclExpression
			symbol_129.setLower(BigInteger.valueOf(0));
			symbol_129.setUpper(BigInteger.valueOf(-1));
			symbol_129.setIsOrdered(true);
			
			symbol_129.setIsResolveProxies(true);
			symbol_127.getOwnedAttributes().add(symbol_129);
		}
		symbol_1.getOwnedTypes().add(symbol_127);
		//
		// pivot.ecore::pivot::NullLiteralExp pivot!NullLiteralExp
		//
		symbol_130.setName("NullLiteralExp");
		//symbol_130.setMoniker("pivot!NullLiteralExp");
		symbol_130.getSuperClasses().add(symbol_166); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_130);
		//
		// pivot.ecore::pivot::NumericLiteralExp pivot!NumericLiteralExp
		//
		symbol_131.setName("NumericLiteralExp");
		//symbol_131.setMoniker("pivot!NumericLiteralExp");
		symbol_131.getSuperClasses().add(symbol_166); // pivot!PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_131);
		//
		// pivot.ecore::pivot::Object pivot!Object
		//
		symbol_132.setName("Object");
		//symbol_132.setMoniker("pivot!Object");
		symbol_1.getOwnedTypes().add(symbol_132);
		//
		// pivot.ecore::pivot::OclExpression pivot!OclExpression
		//
		symbol_133.setName("OclExpression");
		//symbol_133.setMoniker("pivot!OclExpression");
		symbol_133.getSuperClasses().add(symbol_237); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_133);
		//
		// pivot.ecore::pivot::OpaqueExpression pivot!OpaqueExpression
		//
		symbol_134.setName("OpaqueExpression");
		//symbol_134.setMoniker("pivot!OpaqueExpression");
		symbol_134.getSuperClasses().add(symbol_247); // pivot!ValueSpecification
		{ // pivot.ecore::pivot::OpaqueExpression::body pivot!OpaqueExpression!body
			symbol_135.setName("body");
			symbol_135.setType(symbol_196);  // pivot!String
			symbol_135.setLower(BigInteger.valueOf(0));
			symbol_135.setUpper(BigInteger.valueOf(-1));
			symbol_135.setIsOrdered(true);
			symbol_135.setIsUnique(false);
			
			symbol_135.setIsResolveProxies(true);
			symbol_134.getOwnedAttributes().add(symbol_135);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::language pivot!OpaqueExpression!language
			symbol_136.setName("language");
			symbol_136.setType(symbol_196);  // pivot!String
			symbol_136.setLower(BigInteger.valueOf(0));
			symbol_136.setUpper(BigInteger.valueOf(-1));
			symbol_136.setIsOrdered(true);
			
			symbol_136.setIsResolveProxies(true);
			symbol_134.getOwnedAttributes().add(symbol_136);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::message pivot!OpaqueExpression!message
			symbol_137.setName("message");
			symbol_137.setType(symbol_196);  // pivot!String
			symbol_137.setLower(BigInteger.valueOf(0));
			symbol_137.setUpper(BigInteger.valueOf(-1));
			symbol_137.setIsOrdered(true);
			symbol_137.setIsUnique(false);
			
			symbol_137.setIsResolveProxies(true);
			symbol_134.getOwnedAttributes().add(symbol_137);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::valueExpression pivot!OpaqueExpression!valueExpression
			symbol_138.setName("valueExpression");
			symbol_138.setType(symbol_65);  // pivot!ExpressionInOcl
			symbol_138.setLower(BigInteger.valueOf(0));
			
			symbol_138.setIsResolveProxies(true);
			symbol_138.setIsTransient(true);
			symbol_134.getOwnedAttributes().add(symbol_138);
		}
		symbol_1.getOwnedTypes().add(symbol_134);
		//
		// pivot.ecore::pivot::Operation pivot!Operation
		//
		symbol_139.setName("Operation");
		//symbol_139.setMoniker("pivot!Operation");
		symbol_139.getSuperClasses().add(symbol_159); // pivot!ParameterableElement
		symbol_139.getSuperClasses().add(symbol_71); // pivot!Feature
		symbol_139.getSuperClasses().add(symbol_220); // pivot!TemplateableElement
		symbol_139.getSuperClasses().add(symbol_126); // pivot!Namespace
		{ // pivot.ecore::pivot::Operation::class pivot!Operation!class
			symbol_140.setName("class");
			symbol_140.setType(symbol_22);  // pivot!Class
			symbol_140.setLower(BigInteger.valueOf(0));
			
			symbol_140.setIsResolveProxies(true);
			symbol_140.setOpposite(symbol_26);
			symbol_139.getOwnedAttributes().add(symbol_140);
		}
		{ // pivot.ecore::pivot::Operation::ownedParameter pivot!Operation!ownedParameter
			symbol_141.setName("ownedParameter");
			symbol_141.setType(symbol_157);  // pivot!Parameter
			symbol_141.setLower(BigInteger.valueOf(0));
			symbol_141.setUpper(BigInteger.valueOf(-1));
			symbol_141.setIsOrdered(true);
			
			symbol_141.setIsComposite(true);
			symbol_141.setIsResolveProxies(true);
			symbol_141.setOpposite(symbol_158);
			symbol_139.getOwnedAttributes().add(symbol_141);
		}
		{ // pivot.ecore::pivot::Operation::precedence pivot!Operation!precedence
			symbol_142.setName("precedence");
			symbol_142.setType(symbol_163);  // pivot!Precedence
			symbol_142.setLower(BigInteger.valueOf(0));
			
			symbol_142.setIsResolveProxies(true);
			symbol_139.getOwnedAttributes().add(symbol_142);
		}
		{ // pivot.ecore::pivot::Operation::raisedException pivot!Operation!raisedException
			symbol_143.setName("raisedException");
			symbol_143.setType(symbol_229);  // pivot!Type
			symbol_143.setLower(BigInteger.valueOf(0));
			symbol_143.setUpper(BigInteger.valueOf(-1));
			
			symbol_143.setIsResolveProxies(true);
			symbol_139.getOwnedAttributes().add(symbol_143);
		}
		symbol_1.getOwnedTypes().add(symbol_139);
		//
		// pivot.ecore::pivot::OperationCallExp pivot!OperationCallExp
		//
		symbol_144.setName("OperationCallExp");
		//symbol_144.setMoniker("pivot!OperationCallExp");
		symbol_144.getSuperClasses().add(symbol_74); // pivot!FeatureCallExp
		{ // pivot.ecore::pivot::OperationCallExp::argument pivot!OperationCallExp!argument
			symbol_145.setName("argument");
			symbol_145.setType(symbol_133);  // pivot!OclExpression
			symbol_145.setLower(BigInteger.valueOf(0));
			symbol_145.setUpper(BigInteger.valueOf(-1));
			symbol_145.setIsOrdered(true);
			
			symbol_145.setIsComposite(true);
			symbol_145.setIsResolveProxies(true);
			symbol_144.getOwnedAttributes().add(symbol_145);
		}
		{ // pivot.ecore::pivot::OperationCallExp::referredOperation pivot!OperationCallExp!referredOperation
			symbol_146.setName("referredOperation");
			symbol_146.setType(symbol_139);  // pivot!Operation
			symbol_146.setLower(BigInteger.valueOf(0));
			
			symbol_146.setIsResolveProxies(true);
			symbol_144.getOwnedAttributes().add(symbol_146);
		}
		symbol_1.getOwnedTypes().add(symbol_144);
		//
		// pivot.ecore::pivot::OperationTemplateParameter pivot!OperationTemplateParameter
		//
		symbol_147.setName("OperationTemplateParameter");
		//symbol_147.setMoniker("pivot!OperationTemplateParameter");
		symbol_147.getSuperClasses().add(symbol_203); // pivot!TemplateParameter
		symbol_1.getOwnedTypes().add(symbol_147);
		//
		// pivot.ecore::pivot::OrderedSetType pivot!OrderedSetType
		//
		symbol_148.setName("OrderedSetType");
		//symbol_148.setMoniker("pivot!OrderedSetType");
		symbol_148.getSuperClasses().add(symbol_41); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_148);
		//
		// pivot.ecore::pivot::Package pivot!Package
		//
		symbol_149.setName("Package");
		//symbol_149.setMoniker("pivot!Package");
		symbol_149.getSuperClasses().add(symbol_220); // pivot!TemplateableElement
		symbol_149.getSuperClasses().add(symbol_126); // pivot!Namespace
		{ // pivot.ecore::pivot::Package::nestedPackage pivot!Package!nestedPackage
			symbol_150.setName("nestedPackage");
			symbol_150.setType(symbol_149);  // pivot!Package
			symbol_150.setLower(BigInteger.valueOf(0));
			symbol_150.setUpper(BigInteger.valueOf(-1));
			
			symbol_150.setIsComposite(true);
			symbol_150.setIsResolveProxies(true);
			symbol_150.setOpposite(symbol_151);
			symbol_149.getOwnedAttributes().add(symbol_150);
		}
		{ // pivot.ecore::pivot::Package::nestingPackage pivot!Package!nestingPackage
			symbol_151.setName("nestingPackage");
			symbol_151.setType(symbol_149);  // pivot!Package
			symbol_151.setLower(BigInteger.valueOf(0));
			
			symbol_151.setIsResolveProxies(true);
			symbol_151.setOpposite(symbol_150);
			symbol_149.getOwnedAttributes().add(symbol_151);
		}
		{ // pivot.ecore::pivot::Package::nsPrefix pivot!Package!nsPrefix
			symbol_152.setName("nsPrefix");
			symbol_152.setType(symbol_196);  // pivot!String
			symbol_152.setLower(BigInteger.valueOf(0));
			
			symbol_152.setIsResolveProxies(true);
			symbol_149.getOwnedAttributes().add(symbol_152);
		}
		{ // pivot.ecore::pivot::Package::nsURI pivot!Package!nsURI
			symbol_153.setName("nsURI");
			symbol_153.setType(symbol_196);  // pivot!String
			symbol_153.setLower(BigInteger.valueOf(0));
			
			symbol_153.setIsResolveProxies(true);
			symbol_149.getOwnedAttributes().add(symbol_153);
		}
		{ // pivot.ecore::pivot::Package::ownedPrecedence pivot!Package!ownedPrecedence
			symbol_154.setName("ownedPrecedence");
			symbol_154.setType(symbol_163);  // pivot!Precedence
			symbol_154.setLower(BigInteger.valueOf(0));
			symbol_154.setUpper(BigInteger.valueOf(-1));
			symbol_154.setIsOrdered(true);
			
			symbol_154.setIsComposite(true);
			symbol_154.setIsResolveProxies(true);
			symbol_149.getOwnedAttributes().add(symbol_154);
		}
		{ // pivot.ecore::pivot::Package::ownedType pivot!Package!ownedType
			symbol_155.setName("ownedType");
			symbol_155.setType(symbol_229);  // pivot!Type
			symbol_155.setLower(BigInteger.valueOf(0));
			symbol_155.setUpper(BigInteger.valueOf(-1));
			
			symbol_155.setIsComposite(true);
			symbol_155.setIsResolveProxies(true);
			symbol_155.setOpposite(symbol_231);
			symbol_149.getOwnedAttributes().add(symbol_155);
		}
		symbol_1.getOwnedTypes().add(symbol_149);
		//
		// pivot.ecore::pivot::PackageableElement pivot!PackageableElement
		//
		symbol_156.setName("PackageableElement");
		//symbol_156.setMoniker("pivot!PackageableElement");
		symbol_156.getSuperClasses().add(symbol_159); // pivot!ParameterableElement
		symbol_1.getOwnedTypes().add(symbol_156);
		//
		// pivot.ecore::pivot::Parameter pivot!Parameter
		//
		symbol_157.setName("Parameter");
		//symbol_157.setMoniker("pivot!Parameter");
		symbol_157.getSuperClasses().add(symbol_239); // pivot!TypedMultiplicityElement
		symbol_157.getSuperClasses().add(symbol_252); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Parameter::operation pivot!Parameter!operation
			symbol_158.setName("operation");
			symbol_158.setType(symbol_139);  // pivot!Operation
			symbol_158.setLower(BigInteger.valueOf(0));
			
			symbol_158.setIsResolveProxies(true);
			symbol_158.setOpposite(symbol_141);
			symbol_157.getOwnedAttributes().add(symbol_158);
		}
		symbol_1.getOwnedTypes().add(symbol_157);
		//
		// pivot.ecore::pivot::ParameterableElement pivot!ParameterableElement
		//
		symbol_159.setName("ParameterableElement");
		//symbol_159.setMoniker("pivot!ParameterableElement");
		symbol_159.getSuperClasses().add(symbol_113); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot!ParameterableElement!owningTemplateParameter
			symbol_160.setName("owningTemplateParameter");
			symbol_160.setType(symbol_203);  // pivot!TemplateParameter
			symbol_160.setLower(BigInteger.valueOf(0));
			
			symbol_160.setIsResolveProxies(true);
			symbol_160.setOpposite(symbol_206);
			symbol_159.getOwnedAttributes().add(symbol_160);
		}
		{ // pivot.ecore::pivot::ParameterableElement::templateParameter pivot!ParameterableElement!templateParameter
			symbol_161.setName("templateParameter");
			symbol_161.setType(symbol_203);  // pivot!TemplateParameter
			symbol_161.setLower(BigInteger.valueOf(0));
			
			symbol_161.setIsResolveProxies(true);
			symbol_161.setOpposite(symbol_207);
			symbol_159.getOwnedAttributes().add(symbol_161);
		}
		{	// pivot.ecore::pivot::ParameterableElement::isTemplateParameter() pivot!ParameterableElement!isTemplateParameter()
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("isTemplateParameter");
			//symbol_279.setMoniker("pivot!ParameterableElement!isTemplateParameter()");
			symbol_279.setType(symbol_13);  // pivot!Boolean
			
			symbol_159.getOwnedOperations().add(symbol_279);
		}
		symbol_1.getOwnedTypes().add(symbol_159);
		//
		// pivot.ecore::pivot::Pivotable pivot!Pivotable
		//
		symbol_162.setName("Pivotable");
		//symbol_162.setMoniker("pivot!Pivotable");
		symbol_1.getOwnedTypes().add(symbol_162);
		//
		// pivot.ecore::pivot::Precedence pivot!Precedence
		//
		symbol_163.setName("Precedence");
		//symbol_163.setMoniker("pivot!Precedence");
		symbol_163.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::Precedence::associativity pivot!Precedence!associativity
			symbol_164.setName("associativity");
			symbol_164.setType(symbol_11);  // pivot!AssociativityKind
			symbol_164.setLower(BigInteger.valueOf(0));
			
			symbol_164.setIsResolveProxies(true);
			symbol_163.getOwnedAttributes().add(symbol_164);
		}
		{ // pivot.ecore::pivot::Precedence::order pivot!Precedence!order
			symbol_165.setName("order");
			symbol_165.setType(symbol_81);  // pivot!Integer
			
			symbol_165.setIsDerived(true);
			symbol_165.setIsResolveProxies(true);
			symbol_165.setIsVolatile(true);
			symbol_163.getOwnedAttributes().add(symbol_165);
		}
		symbol_1.getOwnedTypes().add(symbol_163);
		//
		// pivot.ecore::pivot::PrimitiveLiteralExp pivot!PrimitiveLiteralExp
		//
		symbol_166.setName("PrimitiveLiteralExp");
		//symbol_166.setMoniker("pivot!PrimitiveLiteralExp");
		symbol_166.getSuperClasses().add(symbol_100); // pivot!LiteralExp
		symbol_1.getOwnedTypes().add(symbol_166);
		//
		// pivot.ecore::pivot::PrimitiveType pivot!PrimitiveType
		//
		symbol_167.setName("PrimitiveType");
		//symbol_167.setMoniker("pivot!PrimitiveType");
		symbol_167.getSuperClasses().add(symbol_51); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_167);
		//
		// pivot.ecore::pivot::Property pivot!Property
		//
		symbol_168.setName("Property");
		//symbol_168.setMoniker("pivot!Property");
		symbol_168.getSuperClasses().add(symbol_159); // pivot!ParameterableElement
		symbol_168.getSuperClasses().add(symbol_71); // pivot!Feature
		{ // pivot.ecore::pivot::Property::association pivot!Property!association
			symbol_169.setName("association");
			symbol_169.setType(symbol_7);  // pivot!AssociationClass
			symbol_169.setLower(BigInteger.valueOf(0));
			
			symbol_169.setIsResolveProxies(true);
			symbol_169.setOpposite(symbol_8);
			symbol_168.getOwnedAttributes().add(symbol_169);
		}
		{ // pivot.ecore::pivot::Property::class pivot!Property!class
			symbol_170.setName("class");
			symbol_170.setType(symbol_22);  // pivot!Class
			symbol_170.setLower(BigInteger.valueOf(0));
			
			symbol_170.setIsResolveProxies(true);
			symbol_170.setOpposite(symbol_25);
			symbol_168.getOwnedAttributes().add(symbol_170);
		}
		{ // pivot.ecore::pivot::Property::default pivot!Property!default
			symbol_171.setName("default");
			symbol_171.setType(symbol_196);  // pivot!String
			symbol_171.setLower(BigInteger.valueOf(0));
			
			symbol_171.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_171);
		}
		{ // pivot.ecore::pivot::Property::implicit pivot!Property!implicit
			symbol_172.setName("implicit");
			symbol_172.setType(symbol_13);  // pivot!Boolean
			symbol_172.setLower(BigInteger.valueOf(0));
			
			symbol_172.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_172);
		}
		{ // pivot.ecore::pivot::Property::isComposite pivot!Property!isComposite
			symbol_173.setName("isComposite");
			symbol_173.setType(symbol_13);  // pivot!Boolean
			
			symbol_173.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_173);
		}
		{ // pivot.ecore::pivot::Property::isDerived pivot!Property!isDerived
			symbol_174.setName("isDerived");
			symbol_174.setType(symbol_13);  // pivot!Boolean
			
			symbol_174.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_174);
		}
		{ // pivot.ecore::pivot::Property::isID pivot!Property!isID
			symbol_175.setName("isID");
			symbol_175.setType(symbol_13);  // pivot!Boolean
			
			symbol_175.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_175);
		}
		{ // pivot.ecore::pivot::Property::isReadOnly pivot!Property!isReadOnly
			symbol_176.setName("isReadOnly");
			symbol_176.setType(symbol_13);  // pivot!Boolean
			
			symbol_176.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_176);
		}
		{ // pivot.ecore::pivot::Property::isResolveProxies pivot!Property!isResolveProxies
			symbol_177.setName("isResolveProxies");
			symbol_177.setType(symbol_13);  // pivot!Boolean
			
			symbol_177.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_177);
		}
		{ // pivot.ecore::pivot::Property::isTransient pivot!Property!isTransient
			symbol_178.setName("isTransient");
			symbol_178.setType(symbol_13);  // pivot!Boolean
			
			symbol_178.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_178);
		}
		{ // pivot.ecore::pivot::Property::isUnsettable pivot!Property!isUnsettable
			symbol_179.setName("isUnsettable");
			symbol_179.setType(symbol_13);  // pivot!Boolean
			
			symbol_179.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_179);
		}
		{ // pivot.ecore::pivot::Property::isVolatile pivot!Property!isVolatile
			symbol_180.setName("isVolatile");
			symbol_180.setType(symbol_13);  // pivot!Boolean
			
			symbol_180.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_180);
		}
		{ // pivot.ecore::pivot::Property::keys pivot!Property!keys
			symbol_181.setName("keys");
			symbol_181.setType(symbol_168);  // pivot!Property
			symbol_181.setLower(BigInteger.valueOf(0));
			symbol_181.setUpper(BigInteger.valueOf(-1));
			
			symbol_181.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_181);
		}
		{ // pivot.ecore::pivot::Property::opposite pivot!Property!opposite
			symbol_182.setName("opposite");
			symbol_182.setType(symbol_168);  // pivot!Property
			symbol_182.setLower(BigInteger.valueOf(0));
			
			symbol_182.setIsResolveProxies(true);
			symbol_168.getOwnedAttributes().add(symbol_182);
		}
		symbol_1.getOwnedTypes().add(symbol_168);
		//
		// pivot.ecore::pivot::PropertyCallExp pivot!PropertyCallExp
		//
		symbol_183.setName("PropertyCallExp");
		//symbol_183.setMoniker("pivot!PropertyCallExp");
		symbol_183.getSuperClasses().add(symbol_127); // pivot!NavigationCallExp
		{ // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot!PropertyCallExp!referredProperty
			symbol_184.setName("referredProperty");
			symbol_184.setType(symbol_168);  // pivot!Property
			symbol_184.setLower(BigInteger.valueOf(0));
			
			symbol_184.setIsResolveProxies(true);
			symbol_183.getOwnedAttributes().add(symbol_184);
		}
		symbol_1.getOwnedTypes().add(symbol_183);
		//
		// pivot.ecore::pivot::RealLiteralExp pivot!RealLiteralExp
		//
		symbol_186.setName("RealLiteralExp");
		//symbol_186.setMoniker("pivot!RealLiteralExp");
		symbol_186.getSuperClasses().add(symbol_131); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot!RealLiteralExp!realSymbol
			symbol_187.setName("realSymbol");
			symbol_187.setType(symbol_185);  // pivot!Real
			
			symbol_187.setIsResolveProxies(true);
			symbol_186.getOwnedAttributes().add(symbol_187);
		}
		symbol_1.getOwnedTypes().add(symbol_186);
		//
		// pivot.ecore::pivot::SendSignalAction pivot!SendSignalAction
		//
		symbol_188.setName("SendSignalAction");
		//symbol_188.setMoniker("pivot!SendSignalAction");
		symbol_188.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::SendSignalAction::signal pivot!SendSignalAction!signal
			symbol_189.setName("signal");
			symbol_189.setType(symbol_192);  // pivot!Signal
			
			symbol_189.setIsResolveProxies(true);
			symbol_188.getOwnedAttributes().add(symbol_189);
		}
		symbol_1.getOwnedTypes().add(symbol_188);
		//
		// pivot.ecore::pivot::SequenceType pivot!SequenceType
		//
		symbol_190.setName("SequenceType");
		//symbol_190.setMoniker("pivot!SequenceType");
		symbol_190.getSuperClasses().add(symbol_41); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_190);
		//
		// pivot.ecore::pivot::SetType pivot!SetType
		//
		symbol_191.setName("SetType");
		//symbol_191.setMoniker("pivot!SetType");
		symbol_191.getSuperClasses().add(symbol_41); // pivot!CollectionType
		symbol_1.getOwnedTypes().add(symbol_191);
		//
		// pivot.ecore::pivot::Signal pivot!Signal
		//
		symbol_192.setName("Signal");
		//symbol_192.setMoniker("pivot!Signal");
		symbol_192.getSuperClasses().add(symbol_121); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_192);
		//
		// pivot.ecore::pivot::State pivot!State
		//
		symbol_193.setName("State");
		//symbol_193.setMoniker("pivot!State");
		symbol_193.getSuperClasses().add(symbol_121); // pivot!NamedElement
		symbol_1.getOwnedTypes().add(symbol_193);
		//
		// pivot.ecore::pivot::StateExp pivot!StateExp
		//
		symbol_194.setName("StateExp");
		//symbol_194.setMoniker("pivot!StateExp");
		symbol_194.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::StateExp::referredState pivot!StateExp!referredState
			symbol_195.setName("referredState");
			symbol_195.setType(symbol_193);  // pivot!State
			symbol_195.setLower(BigInteger.valueOf(0));
			
			symbol_195.setIsResolveProxies(true);
			symbol_194.getOwnedAttributes().add(symbol_195);
		}
		symbol_1.getOwnedTypes().add(symbol_194);
		//
		// pivot.ecore::pivot::StringLiteralExp pivot!StringLiteralExp
		//
		symbol_197.setName("StringLiteralExp");
		//symbol_197.setMoniker("pivot!StringLiteralExp");
		symbol_197.getSuperClasses().add(symbol_166); // pivot!PrimitiveLiteralExp
		{ // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot!StringLiteralExp!stringSymbol
			symbol_198.setName("stringSymbol");
			symbol_198.setType(symbol_196);  // pivot!String
			
			symbol_198.setIsResolveProxies(true);
			symbol_197.getOwnedAttributes().add(symbol_198);
		}
		symbol_1.getOwnedTypes().add(symbol_197);
		//
		// pivot.ecore::pivot::TemplateBinding pivot!TemplateBinding
		//
		symbol_199.setName("TemplateBinding");
		//symbol_199.setMoniker("pivot!TemplateBinding");
		symbol_199.getSuperClasses().add(symbol_56); // pivot!Element
		{ // pivot.ecore::pivot::TemplateBinding::boundElement pivot!TemplateBinding!boundElement
			symbol_200.setName("boundElement");
			symbol_200.setType(symbol_220);  // pivot!TemplateableElement
			
			symbol_200.setIsResolveProxies(true);
			symbol_200.setOpposite(symbol_222);
			symbol_199.getOwnedAttributes().add(symbol_200);
		}
		{ // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot!TemplateBinding!parameterSubstitution
			symbol_201.setName("parameterSubstitution");
			symbol_201.setType(symbol_209);  // pivot!TemplateParameterSubstitution
			symbol_201.setLower(BigInteger.valueOf(0));
			symbol_201.setUpper(BigInteger.valueOf(-1));
			
			symbol_201.setIsComposite(true);
			symbol_201.setIsResolveProxies(true);
			symbol_201.setOpposite(symbol_213);
			symbol_199.getOwnedAttributes().add(symbol_201);
		}
		{ // pivot.ecore::pivot::TemplateBinding::signature pivot!TemplateBinding!signature
			symbol_202.setName("signature");
			symbol_202.setType(symbol_216);  // pivot!TemplateSignature
			
			symbol_202.setIsResolveProxies(true);
			symbol_199.getOwnedAttributes().add(symbol_202);
		}
		symbol_1.getOwnedTypes().add(symbol_199);
		//
		// pivot.ecore::pivot::TemplateParameter pivot!TemplateParameter
		//
		symbol_203.setName("TemplateParameter");
		//symbol_203.setMoniker("pivot!TemplateParameter");
		symbol_203.getSuperClasses().add(symbol_56); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameter::default pivot!TemplateParameter!default
			symbol_204.setName("default");
			symbol_204.setType(symbol_159);  // pivot!ParameterableElement
			symbol_204.setLower(BigInteger.valueOf(0));
			
			symbol_204.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_204);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot!TemplateParameter!ownedDefault
			symbol_205.setName("ownedDefault");
			symbol_205.setType(symbol_159);  // pivot!ParameterableElement
			symbol_205.setLower(BigInteger.valueOf(0));
			
			symbol_205.setIsComposite(true);
			symbol_205.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_205);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot!TemplateParameter!ownedParameteredElement
			symbol_206.setName("ownedParameteredElement");
			symbol_206.setType(symbol_159);  // pivot!ParameterableElement
			symbol_206.setLower(BigInteger.valueOf(0));
			
			symbol_206.setIsComposite(true);
			symbol_206.setIsResolveProxies(true);
			symbol_206.setOpposite(symbol_160);
			symbol_203.getOwnedAttributes().add(symbol_206);
		}
		{ // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot!TemplateParameter!parameteredElement
			symbol_207.setName("parameteredElement");
			symbol_207.setType(symbol_159);  // pivot!ParameterableElement
			
			symbol_207.setIsResolveProxies(true);
			symbol_207.setOpposite(symbol_161);
			symbol_203.getOwnedAttributes().add(symbol_207);
		}
		{ // pivot.ecore::pivot::TemplateParameter::signature pivot!TemplateParameter!signature
			symbol_208.setName("signature");
			symbol_208.setType(symbol_216);  // pivot!TemplateSignature
			
			symbol_208.setIsResolveProxies(true);
			symbol_208.setOpposite(symbol_217);
			symbol_203.getOwnedAttributes().add(symbol_208);
		}
		symbol_1.getOwnedTypes().add(symbol_203);
		//
		// pivot.ecore::pivot::TemplateParameterSubstitution pivot!TemplateParameterSubstitution
		//
		symbol_209.setName("TemplateParameterSubstitution");
		//symbol_209.setMoniker("pivot!TemplateParameterSubstitution");
		symbol_209.getSuperClasses().add(symbol_56); // pivot!Element
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot!TemplateParameterSubstitution!actual
			symbol_210.setName("actual");
			symbol_210.setType(symbol_159);  // pivot!ParameterableElement
			
			symbol_210.setIsResolveProxies(true);
			symbol_209.getOwnedAttributes().add(symbol_210);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot!TemplateParameterSubstitution!formal
			symbol_211.setName("formal");
			symbol_211.setType(symbol_203);  // pivot!TemplateParameter
			
			symbol_211.setIsResolveProxies(true);
			symbol_209.getOwnedAttributes().add(symbol_211);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot!TemplateParameterSubstitution!ownedActual
			symbol_212.setName("ownedActual");
			symbol_212.setType(symbol_159);  // pivot!ParameterableElement
			symbol_212.setLower(BigInteger.valueOf(0));
			
			symbol_212.setIsComposite(true);
			symbol_212.setIsResolveProxies(true);
			symbol_209.getOwnedAttributes().add(symbol_212);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot!TemplateParameterSubstitution!templateBinding
			symbol_213.setName("templateBinding");
			symbol_213.setType(symbol_199);  // pivot!TemplateBinding
			
			symbol_213.setIsResolveProxies(true);
			symbol_213.setOpposite(symbol_201);
			symbol_209.getOwnedAttributes().add(symbol_213);
		}
		symbol_1.getOwnedTypes().add(symbol_209);
		//
		// pivot.ecore::pivot::TemplateParameterType pivot!TemplateParameterType
		//
		symbol_214.setName("TemplateParameterType");
		//symbol_214.setMoniker("pivot!TemplateParameterType");
		symbol_214.getSuperClasses().add(symbol_229); // pivot!Type
		{ // pivot.ecore::pivot::TemplateParameterType::specification pivot!TemplateParameterType!specification
			symbol_215.setName("specification");
			symbol_215.setType(symbol_196);  // pivot!String
			symbol_215.setLower(BigInteger.valueOf(0));
			
			symbol_215.setIsResolveProxies(true);
			symbol_214.getOwnedAttributes().add(symbol_215);
		}
		symbol_1.getOwnedTypes().add(symbol_214);
		//
		// pivot.ecore::pivot::TemplateSignature pivot!TemplateSignature
		//
		symbol_216.setName("TemplateSignature");
		//symbol_216.setMoniker("pivot!TemplateSignature");
		symbol_216.getSuperClasses().add(symbol_113); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot!TemplateSignature!ownedParameter
			symbol_217.setName("ownedParameter");
			symbol_217.setType(symbol_203);  // pivot!TemplateParameter
			symbol_217.setLower(BigInteger.valueOf(0));
			symbol_217.setUpper(BigInteger.valueOf(-1));
			symbol_217.setIsOrdered(true);
			
			symbol_217.setIsComposite(true);
			symbol_217.setIsResolveProxies(true);
			symbol_217.setOpposite(symbol_208);
			symbol_216.getOwnedAttributes().add(symbol_217);
		}
		{ // pivot.ecore::pivot::TemplateSignature::parameter pivot!TemplateSignature!parameter
			symbol_218.setName("parameter");
			symbol_218.setType(symbol_203);  // pivot!TemplateParameter
			symbol_218.setUpper(BigInteger.valueOf(-1));
			symbol_218.setIsOrdered(true);
			
			symbol_218.setIsResolveProxies(true);
			symbol_216.getOwnedAttributes().add(symbol_218);
		}
		{ // pivot.ecore::pivot::TemplateSignature::template pivot!TemplateSignature!template
			symbol_219.setName("template");
			symbol_219.setType(symbol_220);  // pivot!TemplateableElement
			
			symbol_219.setIsResolveProxies(true);
			symbol_219.setOpposite(symbol_221);
			symbol_216.getOwnedAttributes().add(symbol_219);
		}
		symbol_1.getOwnedTypes().add(symbol_216);
		//
		// pivot.ecore::pivot::TemplateableElement pivot!TemplateableElement
		//
		symbol_220.setName("TemplateableElement");
		//symbol_220.setMoniker("pivot!TemplateableElement");
		symbol_220.getSuperClasses().add(symbol_113); // pivot!MonikeredElement
		{ // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot!TemplateableElement!ownedTemplateSignature
			symbol_221.setName("ownedTemplateSignature");
			symbol_221.setType(symbol_216);  // pivot!TemplateSignature
			symbol_221.setLower(BigInteger.valueOf(0));
			
			symbol_221.setIsComposite(true);
			symbol_221.setIsResolveProxies(true);
			symbol_221.setOpposite(symbol_219);
			symbol_220.getOwnedAttributes().add(symbol_221);
		}
		{ // pivot.ecore::pivot::TemplateableElement::templateBinding pivot!TemplateableElement!templateBinding
			symbol_222.setName("templateBinding");
			symbol_222.setType(symbol_199);  // pivot!TemplateBinding
			symbol_222.setLower(BigInteger.valueOf(0));
			symbol_222.setUpper(BigInteger.valueOf(-1));
			
			symbol_222.setIsComposite(true);
			symbol_222.setIsResolveProxies(true);
			symbol_222.setOpposite(symbol_200);
			symbol_220.getOwnedAttributes().add(symbol_222);
		}
		{	// pivot.ecore::pivot::TemplateableElement::isTemplate() pivot!TemplateableElement!isTemplate()
			Operation symbol_280 = PivotFactory.eINSTANCE.createOperation();
			symbol_280.setName("isTemplate");
			//symbol_280.setMoniker("pivot!TemplateableElement!isTemplate()");
			symbol_280.setType(symbol_13);  // pivot!Boolean
			
			symbol_220.getOwnedOperations().add(symbol_280);
		}
		{	// pivot.ecore::pivot::TemplateableElement::parameterableElements() pivot!TemplateableElement!parameterableElements()
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_281.setName("parameterableElements");
			//symbol_281.setMoniker("pivot!TemplateableElement!parameterableElements()");
			symbol_281.setType(symbol_159);  // pivot!ParameterableElement
			symbol_281.setLower(BigInteger.valueOf(0));
			symbol_281.setUpper(BigInteger.valueOf(-1));
			
			symbol_220.getOwnedOperations().add(symbol_281);
		}
		symbol_1.getOwnedTypes().add(symbol_220);
		//
		// pivot.ecore::pivot::Throwable pivot!Throwable
		//
		symbol_223.setName("Throwable");
		//symbol_223.setMoniker("pivot!Throwable");
		symbol_1.getOwnedTypes().add(symbol_223);
		//
		// pivot.ecore::pivot::TupleLiteralExp pivot!TupleLiteralExp
		//
		symbol_224.setName("TupleLiteralExp");
		//symbol_224.setMoniker("pivot!TupleLiteralExp");
		symbol_224.getSuperClasses().add(symbol_100); // pivot!LiteralExp
		{ // pivot.ecore::pivot::TupleLiteralExp::part pivot!TupleLiteralExp!part
			symbol_225.setName("part");
			symbol_225.setType(symbol_226);  // pivot!TupleLiteralPart
			symbol_225.setLower(BigInteger.valueOf(0));
			symbol_225.setUpper(BigInteger.valueOf(-1));
			symbol_225.setIsOrdered(true);
			
			symbol_225.setIsComposite(true);
			symbol_225.setIsResolveProxies(true);
			symbol_224.getOwnedAttributes().add(symbol_225);
		}
		symbol_1.getOwnedTypes().add(symbol_224);
		//
		// pivot.ecore::pivot::TupleLiteralPart pivot!TupleLiteralPart
		//
		symbol_226.setName("TupleLiteralPart");
		//symbol_226.setMoniker("pivot!TupleLiteralPart");
		symbol_226.getSuperClasses().add(symbol_252); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot!TupleLiteralPart!initExpression
			symbol_227.setName("initExpression");
			symbol_227.setType(symbol_133);  // pivot!OclExpression
			symbol_227.setLower(BigInteger.valueOf(0));
			
			symbol_227.setIsComposite(true);
			symbol_227.setIsResolveProxies(true);
			symbol_226.getOwnedAttributes().add(symbol_227);
		}
		symbol_1.getOwnedTypes().add(symbol_226);
		//
		// pivot.ecore::pivot::TupleType pivot!TupleType
		//
		symbol_228.setName("TupleType");
		//symbol_228.setMoniker("pivot!TupleType");
		symbol_228.getSuperClasses().add(symbol_51); // pivot!DataType
		symbol_1.getOwnedTypes().add(symbol_228);
		//
		// pivot.ecore::pivot::Type pivot!Type
		//
		symbol_229.setName("Type");
		//symbol_229.setMoniker("pivot!Type");
		symbol_229.getSuperClasses().add(symbol_159); // pivot!ParameterableElement
		symbol_229.getSuperClasses().add(symbol_121); // pivot!NamedElement
		symbol_229.getSuperClasses().add(symbol_220); // pivot!TemplateableElement
		{ // pivot.ecore::pivot::Type::instanceClassName pivot!Type!instanceClassName
			symbol_230.setName("instanceClassName");
			symbol_230.setType(symbol_196);  // pivot!String
			symbol_230.setLower(BigInteger.valueOf(0));
			
			symbol_230.setIsResolveProxies(true);
			symbol_229.getOwnedAttributes().add(symbol_230);
		}
		{ // pivot.ecore::pivot::Type::package pivot!Type!package
			symbol_231.setName("package");
			symbol_231.setType(symbol_149);  // pivot!Package
			symbol_231.setLower(BigInteger.valueOf(0));
			
			symbol_231.setIsResolveProxies(true);
			symbol_231.setOpposite(symbol_155);
			symbol_229.getOwnedAttributes().add(symbol_231);
		}
		symbol_1.getOwnedTypes().add(symbol_229);
		//
		// pivot.ecore::pivot::TypeExp pivot!TypeExp
		//
		symbol_232.setName("TypeExp");
		//symbol_232.setMoniker("pivot!TypeExp");
		symbol_232.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::TypeExp::referredType pivot!TypeExp!referredType
			symbol_233.setName("referredType");
			symbol_233.setType(symbol_229);  // pivot!Type
			symbol_233.setLower(BigInteger.valueOf(0));
			
			symbol_233.setIsResolveProxies(true);
			symbol_232.getOwnedAttributes().add(symbol_233);
		}
		symbol_1.getOwnedTypes().add(symbol_232);
		//
		// pivot.ecore::pivot::TypeTemplateParameter pivot!TypeTemplateParameter
		//
		symbol_234.setName("TypeTemplateParameter");
		//symbol_234.setMoniker("pivot!TypeTemplateParameter");
		symbol_234.getSuperClasses().add(symbol_203); // pivot!TemplateParameter
		{ // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot!TypeTemplateParameter!allowSubstitutable
			symbol_235.setName("allowSubstitutable");
			symbol_235.setType(symbol_13);  // pivot!Boolean
			
			symbol_235.setIsResolveProxies(true);
			symbol_234.getOwnedAttributes().add(symbol_235);
		}
		{ // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot!TypeTemplateParameter!constrainingType
			symbol_236.setName("constrainingType");
			symbol_236.setType(symbol_229);  // pivot!Type
			symbol_236.setLower(BigInteger.valueOf(0));
			symbol_236.setUpper(BigInteger.valueOf(-1));
			
			symbol_236.setIsResolveProxies(true);
			symbol_234.getOwnedAttributes().add(symbol_236);
		}
		symbol_1.getOwnedTypes().add(symbol_234);
		//
		// pivot.ecore::pivot::TypedElement pivot!TypedElement
		//
		symbol_237.setName("TypedElement");
		//symbol_237.setMoniker("pivot!TypedElement");
		symbol_237.getSuperClasses().add(symbol_121); // pivot!NamedElement
		{ // pivot.ecore::pivot::TypedElement::type pivot!TypedElement!type
			symbol_238.setName("type");
			symbol_238.setType(symbol_229);  // pivot!Type
			symbol_238.setLower(BigInteger.valueOf(0));
			
			symbol_238.setIsResolveProxies(true);
			symbol_237.getOwnedAttributes().add(symbol_238);
		}
		symbol_1.getOwnedTypes().add(symbol_237);
		//
		// pivot.ecore::pivot::TypedMultiplicityElement pivot!TypedMultiplicityElement
		//
		symbol_239.setName("TypedMultiplicityElement");
		//symbol_239.setMoniker("pivot!TypedMultiplicityElement");
		symbol_239.getSuperClasses().add(symbol_115); // pivot!MultiplicityElement
		symbol_239.getSuperClasses().add(symbol_237); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_239);
		//
		// pivot.ecore::pivot::UnlimitedNaturalLiteralExp pivot!UnlimitedNaturalLiteralExp
		//
		symbol_241.setName("UnlimitedNaturalLiteralExp");
		//symbol_241.setMoniker("pivot!UnlimitedNaturalLiteralExp");
		symbol_241.getSuperClasses().add(symbol_131); // pivot!NumericLiteralExp
		{ // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot!UnlimitedNaturalLiteralExp!unlimitedNaturalSymbol
			symbol_242.setName("unlimitedNaturalSymbol");
			symbol_242.setType(symbol_240);  // pivot!UnlimitedNatural
			
			symbol_242.setIsResolveProxies(true);
			symbol_241.getOwnedAttributes().add(symbol_242);
		}
		symbol_1.getOwnedTypes().add(symbol_241);
		//
		// pivot.ecore::pivot::UnspecifiedType pivot!UnspecifiedType
		//
		symbol_243.setName("UnspecifiedType");
		//symbol_243.setMoniker("pivot!UnspecifiedType");
		symbol_243.getSuperClasses().add(symbol_22); // pivot!Class
		{ // pivot.ecore::pivot::UnspecifiedType::lowerBound pivot!UnspecifiedType!lowerBound
			symbol_244.setName("lowerBound");
			symbol_244.setType(symbol_229);  // pivot!Type
			
			symbol_244.setIsResolveProxies(true);
			symbol_243.getOwnedAttributes().add(symbol_244);
		}
		{ // pivot.ecore::pivot::UnspecifiedType::upperBound pivot!UnspecifiedType!upperBound
			symbol_245.setName("upperBound");
			symbol_245.setType(symbol_229);  // pivot!Type
			
			symbol_245.setIsResolveProxies(true);
			symbol_243.getOwnedAttributes().add(symbol_245);
		}
		symbol_1.getOwnedTypes().add(symbol_243);
		//
		// pivot.ecore::pivot::UnspecifiedValueExp pivot!UnspecifiedValueExp
		//
		symbol_246.setName("UnspecifiedValueExp");
		//symbol_246.setMoniker("pivot!UnspecifiedValueExp");
		symbol_246.getSuperClasses().add(symbol_133); // pivot!OclExpression
		symbol_1.getOwnedTypes().add(symbol_246);
		//
		// pivot.ecore::pivot::ValueSpecification pivot!ValueSpecification
		//
		symbol_247.setName("ValueSpecification");
		//symbol_247.setMoniker("pivot!ValueSpecification");
		symbol_247.getSuperClasses().add(symbol_237); // pivot!TypedElement
		symbol_247.getSuperClasses().add(symbol_159); // pivot!ParameterableElement
		{	// pivot.ecore::pivot::ValueSpecification::booleanValue() pivot!ValueSpecification!booleanValue()
			Operation symbol_282 = PivotFactory.eINSTANCE.createOperation();
			symbol_282.setName("booleanValue");
			//symbol_282.setMoniker("pivot!ValueSpecification!booleanValue()");
			symbol_282.setType(symbol_13);  // pivot!Boolean
			
			symbol_247.getOwnedOperations().add(symbol_282);
		}
		{	// pivot.ecore::pivot::ValueSpecification::integerValue() pivot!ValueSpecification!integerValue()
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("integerValue");
			//symbol_283.setMoniker("pivot!ValueSpecification!integerValue()");
			symbol_283.setType(symbol_81);  // pivot!Integer
			
			symbol_247.getOwnedOperations().add(symbol_283);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isComputable() pivot!ValueSpecification!isComputable()
			Operation symbol_284 = PivotFactory.eINSTANCE.createOperation();
			symbol_284.setName("isComputable");
			//symbol_284.setMoniker("pivot!ValueSpecification!isComputable()");
			symbol_284.setType(symbol_13);  // pivot!Boolean
			
			symbol_247.getOwnedOperations().add(symbol_284);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isNull() pivot!ValueSpecification!isNull()
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("isNull");
			//symbol_285.setMoniker("pivot!ValueSpecification!isNull()");
			symbol_285.setType(symbol_13);  // pivot!Boolean
			
			symbol_247.getOwnedOperations().add(symbol_285);
		}
		{	// pivot.ecore::pivot::ValueSpecification::stringValue() pivot!ValueSpecification!stringValue()
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_286.setName("stringValue");
			//symbol_286.setMoniker("pivot!ValueSpecification!stringValue()");
			symbol_286.setType(symbol_196);  // pivot!String
			
			symbol_247.getOwnedOperations().add(symbol_286);
		}
		{	// pivot.ecore::pivot::ValueSpecification::unlimitedValue() pivot!ValueSpecification!unlimitedValue()
			Operation symbol_287 = PivotFactory.eINSTANCE.createOperation();
			symbol_287.setName("unlimitedValue");
			//symbol_287.setMoniker("pivot!ValueSpecification!unlimitedValue()");
			symbol_287.setType(symbol_240);  // pivot!UnlimitedNatural
			
			symbol_247.getOwnedOperations().add(symbol_287);
		}
		symbol_1.getOwnedTypes().add(symbol_247);
		//
		// pivot.ecore::pivot::Variable pivot!Variable
		//
		symbol_248.setName("Variable");
		//symbol_248.setMoniker("pivot!Variable");
		symbol_248.getSuperClasses().add(symbol_252); // pivot!VariableDeclaration
		{ // pivot.ecore::pivot::Variable::implicit pivot!Variable!implicit
			symbol_249.setName("implicit");
			symbol_249.setType(symbol_13);  // pivot!Boolean
			symbol_249.setLower(BigInteger.valueOf(0));
			
			symbol_249.setIsResolveProxies(true);
			symbol_248.getOwnedAttributes().add(symbol_249);
		}
		{ // pivot.ecore::pivot::Variable::initExpression pivot!Variable!initExpression
			symbol_250.setName("initExpression");
			symbol_250.setType(symbol_133);  // pivot!OclExpression
			symbol_250.setLower(BigInteger.valueOf(0));
			
			symbol_250.setIsComposite(true);
			symbol_250.setIsResolveProxies(true);
			symbol_248.getOwnedAttributes().add(symbol_250);
		}
		{ // pivot.ecore::pivot::Variable::representedParameter pivot!Variable!representedParameter
			symbol_251.setName("representedParameter");
			symbol_251.setType(symbol_157);  // pivot!Parameter
			symbol_251.setLower(BigInteger.valueOf(0));
			
			symbol_251.setIsResolveProxies(true);
			symbol_248.getOwnedAttributes().add(symbol_251);
		}
		symbol_1.getOwnedTypes().add(symbol_248);
		//
		// pivot.ecore::pivot::VariableDeclaration pivot!VariableDeclaration
		//
		symbol_252.setName("VariableDeclaration");
		//symbol_252.setMoniker("pivot!VariableDeclaration");
		symbol_252.getSuperClasses().add(symbol_237); // pivot!TypedElement
		symbol_1.getOwnedTypes().add(symbol_252);
		//
		// pivot.ecore::pivot::VariableExp pivot!VariableExp
		//
		symbol_253.setName("VariableExp");
		//symbol_253.setMoniker("pivot!VariableExp");
		symbol_253.getSuperClasses().add(symbol_133); // pivot!OclExpression
		{ // pivot.ecore::pivot::VariableExp::implicit pivot!VariableExp!implicit
			symbol_254.setName("implicit");
			symbol_254.setType(symbol_13);  // pivot!Boolean
			symbol_254.setLower(BigInteger.valueOf(0));
			
			symbol_254.setIsResolveProxies(true);
			symbol_253.getOwnedAttributes().add(symbol_254);
		}
		{ // pivot.ecore::pivot::VariableExp::referredVariable pivot!VariableExp!referredVariable
			symbol_255.setName("referredVariable");
			symbol_255.setType(symbol_252);  // pivot!VariableDeclaration
			symbol_255.setLower(BigInteger.valueOf(0));
			
			symbol_255.setIsResolveProxies(true);
			symbol_253.getOwnedAttributes().add(symbol_255);
		}
		symbol_1.getOwnedTypes().add(symbol_253);
		//
		// pivot.ecore::pivot::Visitable pivot!Visitable
		//
		symbol_256.setName("Visitable");
		//symbol_256.setMoniker("pivot!Visitable");
		symbol_1.getOwnedTypes().add(symbol_256);
		//
		// pivot.ecore::pivot::Visitor pivot!Visitor{R,C}
		//
		symbol_257.setName("Visitor");
		//symbol_257.setMoniker("pivot!Visitor{R,C}");
		symbol_260.setName("R");
		symbol_259.setOwnedParameteredElement(symbol_260);
		symbol_258.getOwnedParameters().add(symbol_259);
		symbol_262.setName("C");
		symbol_261.setOwnedParameteredElement(symbol_262);
		symbol_258.getOwnedParameters().add(symbol_261);
		
		symbol_257.setOwnedTemplateSignature(symbol_258);
		symbol_1.getOwnedTypes().add(symbol_257);
		//
		// pivot.ecore::pivot::VoidType pivot!VoidType
		//
		symbol_263.setName("VoidType");
		//symbol_263.setMoniker("pivot!VoidType");
		symbol_263.getSuperClasses().add(symbol_22); // pivot!Class
		symbol_1.getOwnedTypes().add(symbol_263);

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
