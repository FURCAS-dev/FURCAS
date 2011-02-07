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
 * $Id: OclMetaModel.java,v 1.3 2011/01/30 11:05:02 ewillink Exp $
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
	 *	Create and return a pivot model of the Pivot Model.
	 */
	public static Package create(StandardLibrary standardLibrary)
	{
		Package symbol_1 = PivotFactory.eINSTANCE.createPackage(); // pivot
		Class symbol_2 = PivotFactory.eINSTANCE.createClass(); // pivot|Annotation
		Property symbol_3 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::ownedContent pivot|Annotation|ownedContent
		Property symbol_4 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::ownedDetail pivot|Annotation|ownedDetail
		Property symbol_5 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Annotation::reference pivot|Annotation|reference
		
		Class symbol_6 = PivotFactory.eINSTANCE.createClass(); // pivot|AnyType
		
		Class symbol_7 = PivotFactory.eINSTANCE.createClass(); // pivot|AssociationClass
		Property symbol_8 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClass::unownedAttribute pivot|AssociationClass|unownedAttribute
		
		Class symbol_9 = PivotFactory.eINSTANCE.createClass(); // pivot|AssociationClassCallExp
		Property symbol_10 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::AssociationClassCallExp::referredAssociationClass pivot|AssociationClassCallExp|referredAssociationClass
		
		Class symbol_11 = PivotFactory.eINSTANCE.createClass(); // pivot|AssociativityKind
		
		Class symbol_12 = PivotFactory.eINSTANCE.createClass(); // pivot|BagType
		
		PrimitiveType symbol_13 = standardLibrary.getBooleanType(); // pivot|Boolean
		Class symbol_14 = PivotFactory.eINSTANCE.createClass(); // pivot|BooleanLiteralExp
		Property symbol_15 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::BooleanLiteralExp::booleanSymbol pivot|BooleanLiteralExp|booleanSymbol
		
		Class symbol_16 = PivotFactory.eINSTANCE.createClass(); // pivot|CallExp
		Property symbol_17 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::implicit pivot|CallExp|implicit
		Property symbol_18 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::referredFeature pivot|CallExp|referredFeature
		Property symbol_19 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallExp::source pivot|CallExp|source
		
		Class symbol_20 = PivotFactory.eINSTANCE.createClass(); // pivot|CallOperationAction
		Property symbol_21 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CallOperationAction::operation pivot|CallOperationAction|operation
		
		Class symbol_22 = PivotFactory.eINSTANCE.createClass(); // pivot|CallableImplementation
		
		Class symbol_23 = PivotFactory.eINSTANCE.createClass(); // pivot|Class
		Property symbol_24 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::isAbstract pivot|Class|isAbstract
		Property symbol_25 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::isInterface pivot|Class|isInterface
		Property symbol_26 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::ownedAttribute pivot|Class|ownedAttribute
		Property symbol_27 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::ownedOperation pivot|Class|ownedOperation
		Property symbol_28 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::subClass pivot|Class|subClass
		Property symbol_29 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Class::superClass pivot|Class|superClass
		
		Class symbol_30 = PivotFactory.eINSTANCE.createClass(); // pivot|CollectionItem
		Property symbol_31 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionItem::item pivot|CollectionItem|item
		
		Class symbol_32 = PivotFactory.eINSTANCE.createClass(); // pivot|CollectionKind
		
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // pivot|CollectionLiteralExp
		Property symbol_34 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::kind pivot|CollectionLiteralExp|kind
		Property symbol_35 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionLiteralExp::part pivot|CollectionLiteralExp|part
		
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // pivot|CollectionLiteralPart
		
		Class symbol_37 = PivotFactory.eINSTANCE.createClass(); // pivot|CollectionRange
		Property symbol_38 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::first pivot|CollectionRange|first
		Property symbol_39 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionRange::last pivot|CollectionRange|last
		
		Class symbol_40 = PivotFactory.eINSTANCE.createClass(); // pivot|CollectionType
		Property symbol_41 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CollectionType::elementType pivot|CollectionType|elementType
		
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // pivot|Comment
		Property symbol_43 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::annotatedElement pivot|Comment|annotatedElement
		Property symbol_44 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Comment::body pivot|Comment|body
		
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // pivot|CompleteEnvironment
		
		Class symbol_46 = PivotFactory.eINSTANCE.createClass(); // pivot|CompleteIteration
		Property symbol_47 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteIteration::completeAccumulator pivot|CompleteIteration|completeAccumulator
		Property symbol_48 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteIteration::completeEnvironment pivot|CompleteIteration|completeEnvironment
		Property symbol_49 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteIteration::completeIterator pivot|CompleteIteration|completeIterator
		Property symbol_50 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteIteration::completeParameter pivot|CompleteIteration|completeParameter
		Property symbol_51 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteIteration::model pivot|CompleteIteration|model
		
		Class symbol_52 = PivotFactory.eINSTANCE.createClass(); // pivot|CompleteOperation
		Property symbol_53 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteOperation::completeEnvironment pivot|CompleteOperation|completeEnvironment
		Property symbol_54 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteOperation::completeParameter pivot|CompleteOperation|completeParameter
		Property symbol_55 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteOperation::model pivot|CompleteOperation|model
		
		Class symbol_56 = PivotFactory.eINSTANCE.createClass(); // pivot|CompletePackage
		Property symbol_57 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompletePackage::completeEnvironment pivot|CompletePackage|completeEnvironment
		Property symbol_58 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompletePackage::completePackage pivot|CompletePackage|completePackage
		Property symbol_59 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompletePackage::completeType pivot|CompletePackage|completeType
		Property symbol_60 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompletePackage::model pivot|CompletePackage|model
		
		Class symbol_61 = PivotFactory.eINSTANCE.createClass(); // pivot|CompleteProperty
		Property symbol_62 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteProperty::completeEnvironment pivot|CompleteProperty|completeEnvironment
		Property symbol_63 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteProperty::model pivot|CompleteProperty|model
		
		Class symbol_64 = PivotFactory.eINSTANCE.createClass(); // pivot|CompleteType
		Property symbol_65 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteType::completeEnvironment pivot|CompleteType|completeEnvironment
		Property symbol_66 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteType::completeOperation pivot|CompleteType|completeOperation
		Property symbol_67 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteType::completeProperty pivot|CompleteType|completeProperty
		Property symbol_68 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteType::completeSuperType pivot|CompleteType|completeSuperType
		Property symbol_69 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::CompleteType::model pivot|CompleteType|model
		
		Class symbol_70 = PivotFactory.eINSTANCE.createClass(); // pivot|Constraint
		Property symbol_71 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::constrainedElement pivot|Constraint|constrainedElement
		Property symbol_72 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::context pivot|Constraint|context
		Property symbol_73 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::specification pivot|Constraint|specification
		Property symbol_74 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Constraint::stereotype pivot|Constraint|stereotype
		
		Class symbol_75 = PivotFactory.eINSTANCE.createClass(); // pivot|DataType
		Property symbol_76 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::DataType::isSerializable pivot|DataType|isSerializable
		
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // pivot|Detail
		Property symbol_78 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Detail::value pivot|Detail|value
		
		Class symbol_79 = PivotFactory.eINSTANCE.createClass(); // pivot|Element
		Property symbol_80 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Element::ownedComment pivot|Element|ownedComment
		
		Class symbol_81 = PivotFactory.eINSTANCE.createClass(); // pivot|EnumLiteralExp
		Property symbol_82 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot|EnumLiteralExp|referredEnumLiteral
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // pivot|Enumeration
		Property symbol_84 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Enumeration::ownedLiteral pivot|Enumeration|ownedLiteral
		
		Class symbol_85 = PivotFactory.eINSTANCE.createClass(); // pivot|EnumerationLiteral
		Property symbol_86 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot|EnumerationLiteral|enumeration
		Property symbol_87 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::EnumerationLiteral::value pivot|EnumerationLiteral|value
		
		Class symbol_88 = PivotFactory.eINSTANCE.createClass(); // pivot|ExpressionInOcl
		Property symbol_89 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot|ExpressionInOcl|bodyExpression
		Property symbol_90 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot|ExpressionInOcl|contextVariable
		Property symbol_91 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot|ExpressionInOcl|parameterVariable
		Property symbol_92 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot|ExpressionInOcl|resultVariable
		
		Class symbol_93 = PivotFactory.eINSTANCE.createClass(); // pivot|Feature
		Property symbol_94 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::featuringClass pivot|Feature|featuringClass
		Property symbol_95 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementation pivot|Feature|implementation
		Property symbol_96 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Feature::implementationClass pivot|Feature|implementationClass
		
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // pivot|FeatureCallExp
		Property symbol_98 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::FeatureCallExp::isPre pivot|FeatureCallExp|isPre
		
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // pivot|IfExp
		Property symbol_100 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::condition pivot|IfExp|condition
		Property symbol_101 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::elseExpression pivot|IfExp|elseExpression
		Property symbol_102 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IfExp::thenExpression pivot|IfExp|thenExpression
		
		Class symbol_103 = PivotFactory.eINSTANCE.createClass(); // pivot|Int
		
		PrimitiveType symbol_104 = standardLibrary.getIntegerType(); // pivot|Integer
		Class symbol_105 = PivotFactory.eINSTANCE.createClass(); // pivot|IntegerLiteralExp
		Property symbol_106 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot|IntegerLiteralExp|integerSymbol
		
		Class symbol_107 = PivotFactory.eINSTANCE.createClass(); // pivot|InvalidLiteralExp
		Property symbol_108 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::InvalidLiteralExp::expression pivot|InvalidLiteralExp|expression
		Property symbol_109 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::InvalidLiteralExp::object pivot|InvalidLiteralExp|object
		Property symbol_110 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::InvalidLiteralExp::reason pivot|InvalidLiteralExp|reason
		Property symbol_111 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::InvalidLiteralExp::throwable pivot|InvalidLiteralExp|throwable
		
		Class symbol_112 = PivotFactory.eINSTANCE.createClass(); // pivot|InvalidType
		
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // pivot|IterateExp
		Property symbol_114 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::IterateExp::result pivot|IterateExp|result
		
		Class symbol_115 = PivotFactory.eINSTANCE.createClass(); // pivot|Iteration
		Property symbol_116 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedAccumulator pivot|Iteration|ownedAccumulator
		Property symbol_117 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Iteration::ownedIterator pivot|Iteration|ownedIterator
		
		Class symbol_118 = PivotFactory.eINSTANCE.createClass(); // pivot|IteratorExp
		
		Class symbol_119 = PivotFactory.eINSTANCE.createClass(); // pivot|LetExp
		Property symbol_120 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::in pivot|LetExp|in
		Property symbol_121 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LetExp::variable pivot|LetExp|variable
		
		Class symbol_122 = PivotFactory.eINSTANCE.createClass(); // pivot|Library
		
		Class symbol_123 = PivotFactory.eINSTANCE.createClass(); // pivot|LiteralExp
		
		Class symbol_124 = PivotFactory.eINSTANCE.createClass(); // pivot|LoopExp
		Property symbol_125 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::body pivot|LoopExp|body
		Property symbol_126 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::iterator pivot|LoopExp|iterator
		Property symbol_127 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::LoopExp::referredIteration pivot|LoopExp|referredIteration
		
		Class symbol_128 = PivotFactory.eINSTANCE.createClass(); // pivot|MessageExp
		Property symbol_129 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::argument pivot|MessageExp|argument
		Property symbol_130 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::calledOperation pivot|MessageExp|calledOperation
		Property symbol_131 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::sentSignal pivot|MessageExp|sentSignal
		Property symbol_132 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageExp::target pivot|MessageExp|target
		
		Class symbol_133 = PivotFactory.eINSTANCE.createClass(); // pivot|MessageType
		Property symbol_134 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredOperation pivot|MessageType|referredOperation
		Property symbol_135 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MessageType::referredSignal pivot|MessageType|referredSignal
		
		Class symbol_136 = PivotFactory.eINSTANCE.createClass(); // pivot|MonikeredElement
		Property symbol_137 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MonikeredElement::moniker pivot|MonikeredElement|moniker
		
		Class symbol_138 = PivotFactory.eINSTANCE.createClass(); // pivot|MultiplicityElement
		Property symbol_139 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot|MultiplicityElement|isOrdered
		Property symbol_140 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::isUnique pivot|MultiplicityElement|isUnique
		Property symbol_141 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::lower pivot|MultiplicityElement|lower
		Property symbol_142 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::MultiplicityElement::upper pivot|MultiplicityElement|upper
		
		Class symbol_143 = PivotFactory.eINSTANCE.createClass(); // pivot|Nameable
		
		Class symbol_144 = PivotFactory.eINSTANCE.createClass(); // pivot|NamedElement
		Property symbol_145 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::isStatic pivot|NamedElement|isStatic
		Property symbol_146 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::name pivot|NamedElement|name
		Property symbol_147 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot|NamedElement|ownedAnnotation
		Property symbol_148 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NamedElement::ownedRule pivot|NamedElement|ownedRule
		
		Class symbol_149 = PivotFactory.eINSTANCE.createClass(); // pivot|Namespace
		
		Class symbol_150 = PivotFactory.eINSTANCE.createClass(); // pivot|NavigationCallExp
		Property symbol_151 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot|NavigationCallExp|navigationSource
		Property symbol_152 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::NavigationCallExp::qualifier pivot|NavigationCallExp|qualifier
		
		Class symbol_153 = PivotFactory.eINSTANCE.createClass(); // pivot|NullLiteralExp
		
		Class symbol_154 = PivotFactory.eINSTANCE.createClass(); // pivot|NumericLiteralExp
		
		Class symbol_155 = PivotFactory.eINSTANCE.createClass(); // pivot|Object
		
		Class symbol_156 = PivotFactory.eINSTANCE.createClass(); // pivot|OclExpression
		
		Class symbol_157 = PivotFactory.eINSTANCE.createClass(); // pivot|OpaqueExpression
		Property symbol_158 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::body pivot|OpaqueExpression|body
		Property symbol_159 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OpaqueExpression::language pivot|OpaqueExpression|language
		
		Class symbol_160 = PivotFactory.eINSTANCE.createClass(); // pivot|Operation
		Property symbol_161 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::class pivot|Operation|class
		Property symbol_162 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::ownedParameter pivot|Operation|ownedParameter
		Property symbol_163 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::precedence pivot|Operation|precedence
		Property symbol_164 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Operation::raisedException pivot|Operation|raisedException
		
		Class symbol_165 = PivotFactory.eINSTANCE.createClass(); // pivot|OperationCallExp
		Property symbol_166 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::argument pivot|OperationCallExp|argument
		Property symbol_167 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::OperationCallExp::referredOperation pivot|OperationCallExp|referredOperation
		
		Class symbol_168 = PivotFactory.eINSTANCE.createClass(); // pivot|OperationTemplateParameter
		
		Class symbol_169 = PivotFactory.eINSTANCE.createClass(); // pivot|OrderedSetType
		
		Class symbol_170 = PivotFactory.eINSTANCE.createClass(); // pivot|Package
		Property symbol_171 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestedPackage pivot|Package|nestedPackage
		Property symbol_172 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nestingPackage pivot|Package|nestingPackage
		Property symbol_173 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsPrefix pivot|Package|nsPrefix
		Property symbol_174 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::nsURI pivot|Package|nsURI
		Property symbol_175 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedPrecedence pivot|Package|ownedPrecedence
		Property symbol_176 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Package::ownedType pivot|Package|ownedType
		
		Class symbol_177 = PivotFactory.eINSTANCE.createClass(); // pivot|PackageableElement
		
		Class symbol_178 = PivotFactory.eINSTANCE.createClass(); // pivot|Parameter
		Property symbol_179 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Parameter::operation pivot|Parameter|operation
		
		Class symbol_180 = PivotFactory.eINSTANCE.createClass(); // pivot|ParameterableElement
		Property symbol_181 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot|ParameterableElement|owningTemplateParameter
		Property symbol_182 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::ParameterableElement::templateParameter pivot|ParameterableElement|templateParameter
		
		Class symbol_183 = PivotFactory.eINSTANCE.createClass(); // pivot|Pivotable
		
		Class symbol_184 = PivotFactory.eINSTANCE.createClass(); // pivot|Precedence
		Property symbol_185 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::associativity pivot|Precedence|associativity
		Property symbol_186 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Precedence::order pivot|Precedence|order
		
		Class symbol_187 = PivotFactory.eINSTANCE.createClass(); // pivot|PrimitiveLiteralExp
		
		Class symbol_188 = PivotFactory.eINSTANCE.createClass(); // pivot|PrimitiveType
		
		Class symbol_189 = PivotFactory.eINSTANCE.createClass(); // pivot|Property
		Property symbol_190 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::association pivot|Property|association
		Property symbol_191 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::class pivot|Property|class
		Property symbol_192 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::default pivot|Property|default
		Property symbol_193 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::implicit pivot|Property|implicit
		Property symbol_194 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isComposite pivot|Property|isComposite
		Property symbol_195 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isDerived pivot|Property|isDerived
		Property symbol_196 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isID pivot|Property|isID
		Property symbol_197 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isReadOnly pivot|Property|isReadOnly
		Property symbol_198 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isResolveProxies pivot|Property|isResolveProxies
		Property symbol_199 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isTransient pivot|Property|isTransient
		Property symbol_200 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isUnsettable pivot|Property|isUnsettable
		Property symbol_201 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::isVolatile pivot|Property|isVolatile
		Property symbol_202 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::keys pivot|Property|keys
		Property symbol_203 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Property::opposite pivot|Property|opposite
		
		Class symbol_204 = PivotFactory.eINSTANCE.createClass(); // pivot|PropertyCallExp
		Property symbol_205 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot|PropertyCallExp|referredProperty
		
		PrimitiveType symbol_206 = standardLibrary.getRealType(); // pivot|Real
		Class symbol_207 = PivotFactory.eINSTANCE.createClass(); // pivot|RealLiteralExp
		Property symbol_208 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot|RealLiteralExp|realSymbol
		
		Class symbol_209 = PivotFactory.eINSTANCE.createClass(); // pivot|SelfType
		
		Class symbol_210 = PivotFactory.eINSTANCE.createClass(); // pivot|SendSignalAction
		Property symbol_211 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::SendSignalAction::signal pivot|SendSignalAction|signal
		
		Class symbol_212 = PivotFactory.eINSTANCE.createClass(); // pivot|SequenceType
		
		Class symbol_213 = PivotFactory.eINSTANCE.createClass(); // pivot|SetType
		
		Class symbol_214 = PivotFactory.eINSTANCE.createClass(); // pivot|Signal
		
		Class symbol_215 = PivotFactory.eINSTANCE.createClass(); // pivot|State
		
		Class symbol_216 = PivotFactory.eINSTANCE.createClass(); // pivot|StateExp
		Property symbol_217 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StateExp::referredState pivot|StateExp|referredState
		
		PrimitiveType symbol_218 = standardLibrary.getStringType(); // pivot|String
		Class symbol_219 = PivotFactory.eINSTANCE.createClass(); // pivot|StringLiteralExp
		Property symbol_220 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot|StringLiteralExp|stringSymbol
		
		Class symbol_221 = PivotFactory.eINSTANCE.createClass(); // pivot|TemplateBinding
		Property symbol_222 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::boundElement pivot|TemplateBinding|boundElement
		Property symbol_223 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot|TemplateBinding|parameterSubstitution
		Property symbol_224 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateBinding::signature pivot|TemplateBinding|signature
		
		Class symbol_225 = PivotFactory.eINSTANCE.createClass(); // pivot|TemplateParameter
		Property symbol_226 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::default pivot|TemplateParameter|default
		Property symbol_227 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot|TemplateParameter|ownedDefault
		Property symbol_228 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot|TemplateParameter|ownedParameteredElement
		Property symbol_229 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot|TemplateParameter|parameteredElement
		Property symbol_230 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameter::signature pivot|TemplateParameter|signature
		
		Class symbol_231 = PivotFactory.eINSTANCE.createClass(); // pivot|TemplateParameterSubstitution
		Property symbol_232 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot|TemplateParameterSubstitution|actual
		Property symbol_233 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot|TemplateParameterSubstitution|formal
		Property symbol_234 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot|TemplateParameterSubstitution|ownedActual
		Property symbol_235 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot|TemplateParameterSubstitution|templateBinding
		
		Class symbol_236 = PivotFactory.eINSTANCE.createClass(); // pivot|TemplateParameterType
		Property symbol_237 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateParameterType::specification pivot|TemplateParameterType|specification
		
		Class symbol_238 = PivotFactory.eINSTANCE.createClass(); // pivot|TemplateSignature
		Property symbol_239 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot|TemplateSignature|ownedParameter
		Property symbol_240 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::parameter pivot|TemplateSignature|parameter
		Property symbol_241 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateSignature::template pivot|TemplateSignature|template
		
		Class symbol_242 = PivotFactory.eINSTANCE.createClass(); // pivot|TemplateableElement
		Property symbol_243 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot|TemplateableElement|ownedTemplateSignature
		Property symbol_244 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TemplateableElement::templateBinding pivot|TemplateableElement|templateBinding
		
		Class symbol_245 = PivotFactory.eINSTANCE.createClass(); // pivot|Throwable
		
		Class symbol_246 = PivotFactory.eINSTANCE.createClass(); // pivot|TupleLiteralExp
		Property symbol_247 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralExp::part pivot|TupleLiteralExp|part
		
		Class symbol_248 = PivotFactory.eINSTANCE.createClass(); // pivot|TupleLiteralPart
		Property symbol_249 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot|TupleLiteralPart|initExpression
		
		Class symbol_250 = PivotFactory.eINSTANCE.createClass(); // pivot|TupleType
		
		Class symbol_251 = PivotFactory.eINSTANCE.createClass(); // pivot|Type
		Property symbol_252 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::instanceClassName pivot|Type|instanceClassName
		Property symbol_253 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Type::package pivot|Type|package
		
		Class symbol_254 = PivotFactory.eINSTANCE.createClass(); // pivot|TypeExp
		Property symbol_255 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeExp::referredType pivot|TypeExp|referredType
		
		Class symbol_256 = PivotFactory.eINSTANCE.createClass(); // pivot|TypeTemplateParameter
		Property symbol_257 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot|TypeTemplateParameter|allowSubstitutable
		Property symbol_258 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot|TypeTemplateParameter|constrainingType
		
		Class symbol_259 = PivotFactory.eINSTANCE.createClass(); // pivot|TypedElement
		Property symbol_260 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::TypedElement::type pivot|TypedElement|type
		
		Class symbol_261 = PivotFactory.eINSTANCE.createClass(); // pivot|TypedMultiplicityElement
		
		PrimitiveType symbol_262 = standardLibrary.getUnlimitedNaturalType(); // pivot|UnlimitedNatural
		Class symbol_263 = PivotFactory.eINSTANCE.createClass(); // pivot|UnlimitedNaturalLiteralExp
		Property symbol_264 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot|UnlimitedNaturalLiteralExp|unlimitedNaturalSymbol
		
		Class symbol_265 = PivotFactory.eINSTANCE.createClass(); // pivot|UnspecifiedValueExp
		
		Class symbol_266 = PivotFactory.eINSTANCE.createClass(); // pivot|ValueSpecification
		
		Class symbol_267 = PivotFactory.eINSTANCE.createClass(); // pivot|Variable
		Property symbol_268 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::implicit pivot|Variable|implicit
		Property symbol_269 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::initExpression pivot|Variable|initExpression
		Property symbol_270 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::Variable::representedParameter pivot|Variable|representedParameter
		
		Class symbol_271 = PivotFactory.eINSTANCE.createClass(); // pivot|VariableDeclaration
		
		Class symbol_272 = PivotFactory.eINSTANCE.createClass(); // pivot|VariableExp
		Property symbol_273 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::implicit pivot|VariableExp|implicit
		Property symbol_274 = PivotFactory.eINSTANCE.createProperty(); // pivot.ecore::pivot::VariableExp::referredVariable pivot|VariableExp|referredVariable
		
		Class symbol_275 = PivotFactory.eINSTANCE.createClass(); // pivot|Visitable
		
		Class symbol_276 = PivotFactory.eINSTANCE.createClass(); // pivot|Visitor{R,C}
		TemplateSignature symbol_277 = PivotFactory.eINSTANCE.createTemplateSignature(); // pivot|Visitor{R,C}|
		TypeTemplateParameter symbol_278 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_279 = PivotFactory.eINSTANCE.createClass(); // pivot|Visitor{R,C}?R
		TypeTemplateParameter symbol_280 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_281 = PivotFactory.eINSTANCE.createClass(); // pivot|Visitor{R,C}?C
		
		
		Class symbol_282 = PivotFactory.eINSTANCE.createClass(); // pivot|VoidType
		

		symbol_1.setName("pivot");
		symbol_1.setNsPrefix("pivot");
		symbol_1.setNsURI("http://www.eclipse.org/ocl/3.1.0/Pivot");
		//
		// pivot.ecore::pivot::Annotation pivot|Annotation
		//
		symbol_2.setName("Annotation");
		symbol_2.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::Annotation::ownedContent pivot|Annotation|ownedContent
			symbol_3.setName("ownedContent");
			symbol_3.setType(symbol_79);  // pivot|Element
			symbol_3.setLower(BigInteger.valueOf(0));
			symbol_3.setUpper(BigInteger.valueOf(-1));
			symbol_3.setIsOrdered(true);
			
			symbol_3.setIsComposite(true);
			symbol_3.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_3);
		}
		{ // pivot.ecore::pivot::Annotation::ownedDetail pivot|Annotation|ownedDetail
			symbol_4.setName("ownedDetail");
			symbol_4.setType(symbol_77);  // pivot|Detail
			symbol_4.setLower(BigInteger.valueOf(0));
			symbol_4.setUpper(BigInteger.valueOf(-1));
			symbol_4.setIsOrdered(true);
			
			symbol_4.setIsComposite(true);
			symbol_4.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_4);
		}
		{ // pivot.ecore::pivot::Annotation::reference pivot|Annotation|reference
			symbol_5.setName("reference");
			symbol_5.setType(symbol_79);  // pivot|Element
			symbol_5.setLower(BigInteger.valueOf(0));
			symbol_5.setUpper(BigInteger.valueOf(-1));
			symbol_5.setIsOrdered(true);
			
			symbol_5.setIsResolveProxies(true);
			symbol_2.getOwnedAttributes().add(symbol_5);
		}
		symbol_1.getOwnedTypes().add(symbol_2);
		//
		// pivot.ecore::pivot::AnyType pivot|AnyType
		//
		symbol_6.setName("AnyType");
		symbol_6.getSuperClasses().add(symbol_23); // pivot|Class
		symbol_1.getOwnedTypes().add(symbol_6);
		//
		// pivot.ecore::pivot::AssociationClass pivot|AssociationClass
		//
		symbol_7.setName("AssociationClass");
		symbol_7.getSuperClasses().add(symbol_23); // pivot|Class
		{ // pivot.ecore::pivot::AssociationClass::unownedAttribute pivot|AssociationClass|unownedAttribute
			symbol_8.setName("unownedAttribute");
			symbol_8.setType(symbol_189);  // pivot|Property
			symbol_8.setLower(BigInteger.valueOf(0));
			symbol_8.setUpper(BigInteger.valueOf(-1));
			
			symbol_8.setIsResolveProxies(true);
			symbol_8.setOpposite(symbol_190);
			symbol_7.getOwnedAttributes().add(symbol_8);
		}
		symbol_1.getOwnedTypes().add(symbol_7);
		//
		// pivot.ecore::pivot::AssociationClassCallExp pivot|AssociationClassCallExp
		//
		symbol_9.setName("AssociationClassCallExp");
		symbol_9.getSuperClasses().add(symbol_150); // pivot|NavigationCallExp
		{ // pivot.ecore::pivot::AssociationClassCallExp::referredAssociationClass pivot|AssociationClassCallExp|referredAssociationClass
			symbol_10.setName("referredAssociationClass");
			symbol_10.setType(symbol_7);  // pivot|AssociationClass
			symbol_10.setLower(BigInteger.valueOf(0));
			
			symbol_10.setIsResolveProxies(true);
			symbol_9.getOwnedAttributes().add(symbol_10);
		}
		symbol_1.getOwnedTypes().add(symbol_9);
		//
		// pivot.ecore::pivot::AssociativityKind pivot|AssociativityKind
		//
		symbol_11.setName("AssociativityKind");
		symbol_1.getOwnedTypes().add(symbol_11);
		//
		// pivot.ecore::pivot::BagType pivot|BagType
		//
		symbol_12.setName("BagType");
		symbol_12.getSuperClasses().add(symbol_40); // pivot|CollectionType
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// pivot.ecore::pivot::BooleanLiteralExp pivot|BooleanLiteralExp
		//
		symbol_14.setName("BooleanLiteralExp");
		symbol_14.getSuperClasses().add(symbol_187); // pivot|PrimitiveLiteralExp
		{ // pivot.ecore::pivot::BooleanLiteralExp::booleanSymbol pivot|BooleanLiteralExp|booleanSymbol
			symbol_15.setName("booleanSymbol");
			symbol_15.setType(symbol_13);  // pivot|Boolean
			
			symbol_15.setIsResolveProxies(true);
			symbol_15.setIsUnsettable(true);
			symbol_14.getOwnedAttributes().add(symbol_15);
		}
		symbol_1.getOwnedTypes().add(symbol_14);
		//
		// pivot.ecore::pivot::CallExp pivot|CallExp
		//
		symbol_16.setName("CallExp");
		symbol_16.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::CallExp::implicit pivot|CallExp|implicit
			symbol_17.setName("implicit");
			symbol_17.setType(symbol_13);  // pivot|Boolean
			symbol_17.setLower(BigInteger.valueOf(0));
			
			symbol_17.setIsResolveProxies(true);
			symbol_16.getOwnedAttributes().add(symbol_17);
		}
		{ // pivot.ecore::pivot::CallExp::referredFeature pivot|CallExp|referredFeature
			symbol_18.setName("referredFeature");
			symbol_18.setType(symbol_93);  // pivot|Feature
			symbol_18.setLower(BigInteger.valueOf(0));
			
			symbol_18.setIsDerived(true);
			symbol_18.setIsReadOnly(true);
			symbol_18.setIsTransient(true);
			symbol_18.setIsVolatile(true);
			symbol_16.getOwnedAttributes().add(symbol_18);
		}
		{ // pivot.ecore::pivot::CallExp::source pivot|CallExp|source
			symbol_19.setName("source");
			symbol_19.setType(symbol_156);  // pivot|OclExpression
			symbol_19.setLower(BigInteger.valueOf(0));
			
			symbol_19.setIsComposite(true);
			symbol_19.setIsResolveProxies(true);
			symbol_16.getOwnedAttributes().add(symbol_19);
		}
		symbol_1.getOwnedTypes().add(symbol_16);
		//
		// pivot.ecore::pivot::CallOperationAction pivot|CallOperationAction
		//
		symbol_20.setName("CallOperationAction");
		symbol_20.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::CallOperationAction::operation pivot|CallOperationAction|operation
			symbol_21.setName("operation");
			symbol_21.setType(symbol_160);  // pivot|Operation
			
			symbol_21.setIsResolveProxies(true);
			symbol_20.getOwnedAttributes().add(symbol_21);
		}
		symbol_1.getOwnedTypes().add(symbol_20);
		//
		// pivot.ecore::pivot::CallableImplementation pivot|CallableImplementation
		//
		symbol_22.setName("CallableImplementation");
		symbol_1.getOwnedTypes().add(symbol_22);
		//
		// pivot.ecore::pivot::Class pivot|Class
		//
		symbol_23.setName("Class");
		symbol_23.getSuperClasses().add(symbol_149); // pivot|Namespace
		symbol_23.getSuperClasses().add(symbol_251); // pivot|Type
		{ // pivot.ecore::pivot::Class::isAbstract pivot|Class|isAbstract
			symbol_24.setName("isAbstract");
			symbol_24.setType(symbol_13);  // pivot|Boolean
			
			symbol_24.setIsResolveProxies(true);
			symbol_23.getOwnedAttributes().add(symbol_24);
		}
		{ // pivot.ecore::pivot::Class::isInterface pivot|Class|isInterface
			symbol_25.setName("isInterface");
			symbol_25.setType(symbol_13);  // pivot|Boolean
			
			symbol_25.setIsResolveProxies(true);
			symbol_23.getOwnedAttributes().add(symbol_25);
		}
		{ // pivot.ecore::pivot::Class::ownedAttribute pivot|Class|ownedAttribute
			symbol_26.setName("ownedAttribute");
			symbol_26.setType(symbol_189);  // pivot|Property
			symbol_26.setLower(BigInteger.valueOf(0));
			symbol_26.setUpper(BigInteger.valueOf(-1));
			symbol_26.setIsOrdered(true);
			
			symbol_26.setIsComposite(true);
			symbol_26.setIsResolveProxies(true);
			symbol_26.setOpposite(symbol_191);
			symbol_23.getOwnedAttributes().add(symbol_26);
		}
		{ // pivot.ecore::pivot::Class::ownedOperation pivot|Class|ownedOperation
			symbol_27.setName("ownedOperation");
			symbol_27.setType(symbol_160);  // pivot|Operation
			symbol_27.setLower(BigInteger.valueOf(0));
			symbol_27.setUpper(BigInteger.valueOf(-1));
			symbol_27.setIsOrdered(true);
			
			symbol_27.setIsComposite(true);
			symbol_27.setIsResolveProxies(true);
			symbol_27.setOpposite(symbol_161);
			symbol_23.getOwnedAttributes().add(symbol_27);
		}
		{ // pivot.ecore::pivot::Class::subClass pivot|Class|subClass
			symbol_28.setName("subClass");
			symbol_28.setType(symbol_23);  // pivot|Class
			symbol_28.setLower(BigInteger.valueOf(0));
			symbol_28.setUpper(BigInteger.valueOf(-1));
			
			symbol_28.setIsTransient(true);
			symbol_23.getOwnedAttributes().add(symbol_28);
		}
		{ // pivot.ecore::pivot::Class::superClass pivot|Class|superClass
			symbol_29.setName("superClass");
			symbol_29.setType(symbol_23);  // pivot|Class
			symbol_29.setLower(BigInteger.valueOf(0));
			symbol_29.setUpper(BigInteger.valueOf(-1));
			
			symbol_29.setIsResolveProxies(true);
			symbol_23.getOwnedAttributes().add(symbol_29);
		}
		symbol_1.getOwnedTypes().add(symbol_23);
		//
		// pivot.ecore::pivot::CollectionItem pivot|CollectionItem
		//
		symbol_30.setName("CollectionItem");
		symbol_30.getSuperClasses().add(symbol_36); // pivot|CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionItem::item pivot|CollectionItem|item
			symbol_31.setName("item");
			symbol_31.setType(symbol_156);  // pivot|OclExpression
			
			symbol_31.setIsComposite(true);
			symbol_31.setIsResolveProxies(true);
			symbol_30.getOwnedAttributes().add(symbol_31);
		}
		symbol_1.getOwnedTypes().add(symbol_30);
		//
		// pivot.ecore::pivot::CollectionKind pivot|CollectionKind
		//
		symbol_32.setName("CollectionKind");
		symbol_1.getOwnedTypes().add(symbol_32);
		//
		// pivot.ecore::pivot::CollectionLiteralExp pivot|CollectionLiteralExp
		//
		symbol_33.setName("CollectionLiteralExp");
		symbol_33.getSuperClasses().add(symbol_123); // pivot|LiteralExp
		{ // pivot.ecore::pivot::CollectionLiteralExp::kind pivot|CollectionLiteralExp|kind
			symbol_34.setName("kind");
			symbol_34.setType(symbol_32);  // pivot|CollectionKind
			
			symbol_34.setIsResolveProxies(true);
			symbol_33.getOwnedAttributes().add(symbol_34);
		}
		{ // pivot.ecore::pivot::CollectionLiteralExp::part pivot|CollectionLiteralExp|part
			symbol_35.setName("part");
			symbol_35.setType(symbol_36);  // pivot|CollectionLiteralPart
			symbol_35.setLower(BigInteger.valueOf(0));
			symbol_35.setUpper(BigInteger.valueOf(-1));
			symbol_35.setIsOrdered(true);
			
			symbol_35.setIsComposite(true);
			symbol_35.setIsResolveProxies(true);
			symbol_33.getOwnedAttributes().add(symbol_35);
		}
		symbol_1.getOwnedTypes().add(symbol_33);
		//
		// pivot.ecore::pivot::CollectionLiteralPart pivot|CollectionLiteralPart
		//
		symbol_36.setName("CollectionLiteralPart");
		symbol_36.getSuperClasses().add(symbol_259); // pivot|TypedElement
		symbol_1.getOwnedTypes().add(symbol_36);
		//
		// pivot.ecore::pivot::CollectionRange pivot|CollectionRange
		//
		symbol_37.setName("CollectionRange");
		symbol_37.getSuperClasses().add(symbol_36); // pivot|CollectionLiteralPart
		{ // pivot.ecore::pivot::CollectionRange::first pivot|CollectionRange|first
			symbol_38.setName("first");
			symbol_38.setType(symbol_156);  // pivot|OclExpression
			
			symbol_38.setIsComposite(true);
			symbol_38.setIsResolveProxies(true);
			symbol_37.getOwnedAttributes().add(symbol_38);
		}
		{ // pivot.ecore::pivot::CollectionRange::last pivot|CollectionRange|last
			symbol_39.setName("last");
			symbol_39.setType(symbol_156);  // pivot|OclExpression
			
			symbol_39.setIsComposite(true);
			symbol_39.setIsResolveProxies(true);
			symbol_37.getOwnedAttributes().add(symbol_39);
		}
		symbol_1.getOwnedTypes().add(symbol_37);
		//
		// pivot.ecore::pivot::CollectionType pivot|CollectionType
		//
		symbol_40.setName("CollectionType");
		symbol_40.getSuperClasses().add(symbol_75); // pivot|DataType
		{ // pivot.ecore::pivot::CollectionType::elementType pivot|CollectionType|elementType
			symbol_41.setName("elementType");
			symbol_41.setType(symbol_251);  // pivot|Type
			
			symbol_41.setIsResolveProxies(true);
			symbol_40.getOwnedAttributes().add(symbol_41);
		}
		symbol_1.getOwnedTypes().add(symbol_40);
		//
		// pivot.ecore::pivot::Comment pivot|Comment
		//
		symbol_42.setName("Comment");
		symbol_42.getSuperClasses().add(symbol_79); // pivot|Element
		{ // pivot.ecore::pivot::Comment::annotatedElement pivot|Comment|annotatedElement
			symbol_43.setName("annotatedElement");
			symbol_43.setType(symbol_79);  // pivot|Element
			symbol_43.setLower(BigInteger.valueOf(0));
			symbol_43.setUpper(BigInteger.valueOf(-1));
			
			symbol_43.setIsResolveProxies(true);
			symbol_42.getOwnedAttributes().add(symbol_43);
		}
		{ // pivot.ecore::pivot::Comment::body pivot|Comment|body
			symbol_44.setName("body");
			symbol_44.setType(symbol_218);  // pivot|String
			symbol_44.setLower(BigInteger.valueOf(0));
			
			symbol_44.setIsResolveProxies(true);
			symbol_42.getOwnedAttributes().add(symbol_44);
		}
		symbol_1.getOwnedTypes().add(symbol_42);
		//
		// pivot.ecore::pivot::CompleteEnvironment pivot|CompleteEnvironment
		//
		symbol_45.setName("CompleteEnvironment");
		symbol_45.getSuperClasses().add(symbol_170); // pivot|Package
		{	// pivot.ecore::pivot::CompleteEnvironment::getCompleteIteration() pivot|CompleteEnvironment|getCompleteIteration(pivot|Iteration)
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("getCompleteIteration");
			symbol_283.setType(symbol_46);  // pivot|CompleteIteration
			
			Parameter symbol_284 = PivotFactory.eINSTANCE.createParameter();
			symbol_284.setName("model");
			symbol_284.setType(symbol_115);  // pivot|Iteration
			
			symbol_283.getOwnedParameters().add(symbol_284);
			symbol_45.getOwnedOperations().add(symbol_283);
		}
		{	// pivot.ecore::pivot::CompleteEnvironment::getCompleteOperation() pivot|CompleteEnvironment|getCompleteOperation(pivot|Operation)
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("getCompleteOperation");
			symbol_285.setType(symbol_52);  // pivot|CompleteOperation
			
			Parameter symbol_286 = PivotFactory.eINSTANCE.createParameter();
			symbol_286.setName("model");
			symbol_286.setType(symbol_160);  // pivot|Operation
			
			symbol_285.getOwnedParameters().add(symbol_286);
			symbol_45.getOwnedOperations().add(symbol_285);
		}
		{	// pivot.ecore::pivot::CompleteEnvironment::getCompletePackage() pivot|CompleteEnvironment|getCompletePackage(pivot|Package)
			Operation symbol_287 = PivotFactory.eINSTANCE.createOperation();
			symbol_287.setName("getCompletePackage");
			symbol_287.setType(symbol_56);  // pivot|CompletePackage
			
			Parameter symbol_288 = PivotFactory.eINSTANCE.createParameter();
			symbol_288.setName("model");
			symbol_288.setType(symbol_170);  // pivot|Package
			
			symbol_287.getOwnedParameters().add(symbol_288);
			symbol_45.getOwnedOperations().add(symbol_287);
		}
		{	// pivot.ecore::pivot::CompleteEnvironment::getCompleteProperty() pivot|CompleteEnvironment|getCompleteProperty(pivot|Property)
			Operation symbol_289 = PivotFactory.eINSTANCE.createOperation();
			symbol_289.setName("getCompleteProperty");
			symbol_289.setType(symbol_61);  // pivot|CompleteProperty
			
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("model");
			symbol_290.setType(symbol_189);  // pivot|Property
			
			symbol_289.getOwnedParameters().add(symbol_290);
			symbol_45.getOwnedOperations().add(symbol_289);
		}
		{	// pivot.ecore::pivot::CompleteEnvironment::getCompleteType() pivot|CompleteEnvironment|getCompleteType(pivot|Type)
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("getCompleteType");
			symbol_291.setType(symbol_64);  // pivot|CompleteType
			
			Parameter symbol_292 = PivotFactory.eINSTANCE.createParameter();
			symbol_292.setName("model");
			symbol_292.setType(symbol_251);  // pivot|Type
			
			symbol_291.getOwnedParameters().add(symbol_292);
			symbol_45.getOwnedOperations().add(symbol_291);
		}
		symbol_1.getOwnedTypes().add(symbol_45);
		//
		// pivot.ecore::pivot::CompleteIteration pivot|CompleteIteration
		//
		symbol_46.setName("CompleteIteration");
		symbol_46.getSuperClasses().add(symbol_115); // pivot|Iteration
		{ // pivot.ecore::pivot::CompleteIteration::completeAccumulator pivot|CompleteIteration|completeAccumulator
			symbol_47.setName("completeAccumulator");
			symbol_47.setType(symbol_178);  // pivot|Parameter
			symbol_47.setLower(BigInteger.valueOf(0));
			symbol_47.setUpper(BigInteger.valueOf(-1));
			
			symbol_47.setIsDerived(true);
			symbol_47.setIsReadOnly(true);
			symbol_47.setIsResolveProxies(true);
			symbol_47.setIsVolatile(true);
			symbol_46.getOwnedAttributes().add(symbol_47);
		}
		{ // pivot.ecore::pivot::CompleteIteration::completeEnvironment pivot|CompleteIteration|completeEnvironment
			symbol_48.setName("completeEnvironment");
			symbol_48.setType(symbol_45);  // pivot|CompleteEnvironment
			
			symbol_48.setIsResolveProxies(true);
			symbol_46.getOwnedAttributes().add(symbol_48);
		}
		{ // pivot.ecore::pivot::CompleteIteration::completeIterator pivot|CompleteIteration|completeIterator
			symbol_49.setName("completeIterator");
			symbol_49.setType(symbol_178);  // pivot|Parameter
			symbol_49.setLower(BigInteger.valueOf(0));
			symbol_49.setUpper(BigInteger.valueOf(-1));
			
			symbol_49.setIsDerived(true);
			symbol_49.setIsReadOnly(true);
			symbol_49.setIsResolveProxies(true);
			symbol_49.setIsVolatile(true);
			symbol_46.getOwnedAttributes().add(symbol_49);
		}
		{ // pivot.ecore::pivot::CompleteIteration::completeParameter pivot|CompleteIteration|completeParameter
			symbol_50.setName("completeParameter");
			symbol_50.setType(symbol_178);  // pivot|Parameter
			symbol_50.setLower(BigInteger.valueOf(0));
			symbol_50.setUpper(BigInteger.valueOf(-1));
			
			symbol_50.setIsDerived(true);
			symbol_50.setIsReadOnly(true);
			symbol_50.setIsResolveProxies(true);
			symbol_50.setIsVolatile(true);
			symbol_46.getOwnedAttributes().add(symbol_50);
		}
		{ // pivot.ecore::pivot::CompleteIteration::model pivot|CompleteIteration|model
			symbol_51.setName("model");
			symbol_51.setType(symbol_115);  // pivot|Iteration
			
			symbol_51.setIsResolveProxies(true);
			symbol_46.getOwnedAttributes().add(symbol_51);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// pivot.ecore::pivot::CompleteOperation pivot|CompleteOperation
		//
		symbol_52.setName("CompleteOperation");
		symbol_52.getSuperClasses().add(symbol_160); // pivot|Operation
		{ // pivot.ecore::pivot::CompleteOperation::completeEnvironment pivot|CompleteOperation|completeEnvironment
			symbol_53.setName("completeEnvironment");
			symbol_53.setType(symbol_45);  // pivot|CompleteEnvironment
			
			symbol_53.setIsResolveProxies(true);
			symbol_52.getOwnedAttributes().add(symbol_53);
		}
		{ // pivot.ecore::pivot::CompleteOperation::completeParameter pivot|CompleteOperation|completeParameter
			symbol_54.setName("completeParameter");
			symbol_54.setType(symbol_178);  // pivot|Parameter
			symbol_54.setLower(BigInteger.valueOf(0));
			symbol_54.setUpper(BigInteger.valueOf(-1));
			
			symbol_54.setIsDerived(true);
			symbol_54.setIsReadOnly(true);
			symbol_54.setIsResolveProxies(true);
			symbol_54.setIsVolatile(true);
			symbol_52.getOwnedAttributes().add(symbol_54);
		}
		{ // pivot.ecore::pivot::CompleteOperation::model pivot|CompleteOperation|model
			symbol_55.setName("model");
			symbol_55.setType(symbol_160);  // pivot|Operation
			
			symbol_55.setIsResolveProxies(true);
			symbol_52.getOwnedAttributes().add(symbol_55);
		}
		symbol_1.getOwnedTypes().add(symbol_52);
		//
		// pivot.ecore::pivot::CompletePackage pivot|CompletePackage
		//
		symbol_56.setName("CompletePackage");
		symbol_56.getSuperClasses().add(symbol_170); // pivot|Package
		{ // pivot.ecore::pivot::CompletePackage::completeEnvironment pivot|CompletePackage|completeEnvironment
			symbol_57.setName("completeEnvironment");
			symbol_57.setType(symbol_45);  // pivot|CompleteEnvironment
			
			symbol_57.setIsResolveProxies(true);
			symbol_56.getOwnedAttributes().add(symbol_57);
		}
		{ // pivot.ecore::pivot::CompletePackage::completePackage pivot|CompletePackage|completePackage
			symbol_58.setName("completePackage");
			symbol_58.setType(symbol_56);  // pivot|CompletePackage
			symbol_58.setLower(BigInteger.valueOf(0));
			symbol_58.setUpper(BigInteger.valueOf(-1));
			
			symbol_58.setIsDerived(true);
			symbol_58.setIsReadOnly(true);
			symbol_58.setIsResolveProxies(true);
			symbol_58.setIsVolatile(true);
			symbol_56.getOwnedAttributes().add(symbol_58);
		}
		{ // pivot.ecore::pivot::CompletePackage::completeType pivot|CompletePackage|completeType
			symbol_59.setName("completeType");
			symbol_59.setType(symbol_64);  // pivot|CompleteType
			symbol_59.setLower(BigInteger.valueOf(0));
			symbol_59.setUpper(BigInteger.valueOf(-1));
			
			symbol_59.setIsDerived(true);
			symbol_59.setIsReadOnly(true);
			symbol_59.setIsResolveProxies(true);
			symbol_59.setIsVolatile(true);
			symbol_56.getOwnedAttributes().add(symbol_59);
		}
		{ // pivot.ecore::pivot::CompletePackage::model pivot|CompletePackage|model
			symbol_60.setName("model");
			symbol_60.setType(symbol_170);  // pivot|Package
			
			symbol_60.setIsResolveProxies(true);
			symbol_56.getOwnedAttributes().add(symbol_60);
		}
		symbol_1.getOwnedTypes().add(symbol_56);
		//
		// pivot.ecore::pivot::CompleteProperty pivot|CompleteProperty
		//
		symbol_61.setName("CompleteProperty");
		symbol_61.getSuperClasses().add(symbol_189); // pivot|Property
		{ // pivot.ecore::pivot::CompleteProperty::completeEnvironment pivot|CompleteProperty|completeEnvironment
			symbol_62.setName("completeEnvironment");
			symbol_62.setType(symbol_45);  // pivot|CompleteEnvironment
			
			symbol_62.setIsResolveProxies(true);
			symbol_61.getOwnedAttributes().add(symbol_62);
		}
		{ // pivot.ecore::pivot::CompleteProperty::model pivot|CompleteProperty|model
			symbol_63.setName("model");
			symbol_63.setType(symbol_189);  // pivot|Property
			
			symbol_63.setIsResolveProxies(true);
			symbol_61.getOwnedAttributes().add(symbol_63);
		}
		symbol_1.getOwnedTypes().add(symbol_61);
		//
		// pivot.ecore::pivot::CompleteType pivot|CompleteType
		//
		symbol_64.setName("CompleteType");
		symbol_64.getSuperClasses().add(symbol_23); // pivot|Class
		{ // pivot.ecore::pivot::CompleteType::completeEnvironment pivot|CompleteType|completeEnvironment
			symbol_65.setName("completeEnvironment");
			symbol_65.setType(symbol_45);  // pivot|CompleteEnvironment
			
			symbol_65.setIsResolveProxies(true);
			symbol_64.getOwnedAttributes().add(symbol_65);
		}
		{ // pivot.ecore::pivot::CompleteType::completeOperation pivot|CompleteType|completeOperation
			symbol_66.setName("completeOperation");
			symbol_66.setType(symbol_52);  // pivot|CompleteOperation
			symbol_66.setLower(BigInteger.valueOf(0));
			symbol_66.setUpper(BigInteger.valueOf(-1));
			
			symbol_66.setIsDerived(true);
			symbol_66.setIsReadOnly(true);
			symbol_66.setIsResolveProxies(true);
			symbol_66.setIsVolatile(true);
			symbol_64.getOwnedAttributes().add(symbol_66);
		}
		{ // pivot.ecore::pivot::CompleteType::completeProperty pivot|CompleteType|completeProperty
			symbol_67.setName("completeProperty");
			symbol_67.setType(symbol_61);  // pivot|CompleteProperty
			symbol_67.setLower(BigInteger.valueOf(0));
			symbol_67.setUpper(BigInteger.valueOf(-1));
			
			symbol_67.setIsDerived(true);
			symbol_67.setIsReadOnly(true);
			symbol_67.setIsResolveProxies(true);
			symbol_67.setIsVolatile(true);
			symbol_64.getOwnedAttributes().add(symbol_67);
		}
		{ // pivot.ecore::pivot::CompleteType::completeSuperType pivot|CompleteType|completeSuperType
			symbol_68.setName("completeSuperType");
			symbol_68.setType(symbol_64);  // pivot|CompleteType
			symbol_68.setLower(BigInteger.valueOf(0));
			symbol_68.setUpper(BigInteger.valueOf(-1));
			
			symbol_68.setIsDerived(true);
			symbol_68.setIsReadOnly(true);
			symbol_68.setIsResolveProxies(true);
			symbol_68.setIsVolatile(true);
			symbol_64.getOwnedAttributes().add(symbol_68);
		}
		{ // pivot.ecore::pivot::CompleteType::model pivot|CompleteType|model
			symbol_69.setName("model");
			symbol_69.setType(symbol_251);  // pivot|Type
			
			symbol_69.setIsResolveProxies(true);
			symbol_64.getOwnedAttributes().add(symbol_69);
		}
		{	// pivot.ecore::pivot::CompleteType::conformsTo() pivot|CompleteType|conformsTo(pivot|CompleteType)
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("conformsTo");
			symbol_293.setType(symbol_13);  // pivot|Boolean
			
			Parameter symbol_294 = PivotFactory.eINSTANCE.createParameter();
			symbol_294.setName("aType");
			symbol_294.setType(symbol_64);  // pivot|CompleteType
			
			symbol_293.getOwnedParameters().add(symbol_294);
			symbol_64.getOwnedOperations().add(symbol_293);
		}
		{	// pivot.ecore::pivot::CompleteType::getCompleteIterations() pivot|CompleteType|getCompleteIterations(pivot|String)
			Operation symbol_295 = PivotFactory.eINSTANCE.createOperation();
			symbol_295.setName("getCompleteIterations");
			symbol_295.setType(symbol_46);  // pivot|CompleteIteration
			symbol_295.setLower(BigInteger.valueOf(0));
			symbol_295.setUpper(BigInteger.valueOf(-1));
			
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("name");
			symbol_296.setType(symbol_218);  // pivot|String
			
			symbol_295.getOwnedParameters().add(symbol_296);
			symbol_64.getOwnedOperations().add(symbol_295);
		}
		{	// pivot.ecore::pivot::CompleteType::getCompleteOperations() pivot|CompleteType|getCompleteOperations(pivot|String)
			Operation symbol_297 = PivotFactory.eINSTANCE.createOperation();
			symbol_297.setName("getCompleteOperations");
			symbol_297.setType(symbol_52);  // pivot|CompleteOperation
			symbol_297.setLower(BigInteger.valueOf(0));
			symbol_297.setUpper(BigInteger.valueOf(-1));
			
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("name");
			symbol_298.setType(symbol_218);  // pivot|String
			
			symbol_297.getOwnedParameters().add(symbol_298);
			symbol_64.getOwnedOperations().add(symbol_297);
		}
		{	// pivot.ecore::pivot::CompleteType::getDynamicIteration() pivot|CompleteType|getDynamicIteration(pivot|CompleteIteration)
			Operation symbol_299 = PivotFactory.eINSTANCE.createOperation();
			symbol_299.setName("getDynamicIteration");
			symbol_299.setType(symbol_46);  // pivot|CompleteIteration
			
			Parameter symbol_300 = PivotFactory.eINSTANCE.createParameter();
			symbol_300.setName("staticOperation");
			symbol_300.setType(symbol_46);  // pivot|CompleteIteration
			
			symbol_299.getOwnedParameters().add(symbol_300);
			symbol_64.getOwnedOperations().add(symbol_299);
		}
		{	// pivot.ecore::pivot::CompleteType::getDynamicOperation() pivot|CompleteType|getDynamicOperation(pivot|CompleteOperation)
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_301.setName("getDynamicOperation");
			symbol_301.setType(symbol_52);  // pivot|CompleteOperation
			
			Parameter symbol_302 = PivotFactory.eINSTANCE.createParameter();
			symbol_302.setName("staticOperation");
			symbol_302.setType(symbol_52);  // pivot|CompleteOperation
			
			symbol_301.getOwnedParameters().add(symbol_302);
			symbol_64.getOwnedOperations().add(symbol_301);
		}
		symbol_1.getOwnedTypes().add(symbol_64);
		//
		// pivot.ecore::pivot::Constraint pivot|Constraint
		//
		symbol_70.setName("Constraint");
		symbol_70.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::Constraint::constrainedElement pivot|Constraint|constrainedElement
			symbol_71.setName("constrainedElement");
			symbol_71.setType(symbol_79);  // pivot|Element
			symbol_71.setLower(BigInteger.valueOf(0));
			symbol_71.setUpper(BigInteger.valueOf(-1));
			symbol_71.setIsOrdered(true);
			
			symbol_71.setIsResolveProxies(true);
			symbol_70.getOwnedAttributes().add(symbol_71);
		}
		{ // pivot.ecore::pivot::Constraint::context pivot|Constraint|context
			symbol_72.setName("context");
			symbol_72.setType(symbol_144);  // pivot|NamedElement
			symbol_72.setLower(BigInteger.valueOf(0));
			
			symbol_72.setIsResolveProxies(true);
			symbol_70.getOwnedAttributes().add(symbol_72);
		}
		{ // pivot.ecore::pivot::Constraint::specification pivot|Constraint|specification
			symbol_73.setName("specification");
			symbol_73.setType(symbol_266);  // pivot|ValueSpecification
			
			symbol_73.setIsComposite(true);
			symbol_73.setIsResolveProxies(true);
			symbol_70.getOwnedAttributes().add(symbol_73);
		}
		{ // pivot.ecore::pivot::Constraint::stereotype pivot|Constraint|stereotype
			symbol_74.setName("stereotype");
			symbol_74.setType(symbol_218);  // pivot|String
			symbol_74.setLower(BigInteger.valueOf(0));
			
			symbol_74.setIsResolveProxies(true);
			symbol_70.getOwnedAttributes().add(symbol_74);
		}
		symbol_1.getOwnedTypes().add(symbol_70);
		//
		// pivot.ecore::pivot::DataType pivot|DataType
		//
		symbol_75.setName("DataType");
		symbol_75.getSuperClasses().add(symbol_23); // pivot|Class
		{ // pivot.ecore::pivot::DataType::isSerializable pivot|DataType|isSerializable
			symbol_76.setName("isSerializable");
			symbol_76.setType(symbol_13);  // pivot|Boolean
			
			symbol_76.setIsResolveProxies(true);
			symbol_75.getOwnedAttributes().add(symbol_76);
		}
		symbol_1.getOwnedTypes().add(symbol_75);
		//
		// pivot.ecore::pivot::Detail pivot|Detail
		//
		symbol_77.setName("Detail");
		symbol_77.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::Detail::value pivot|Detail|value
			symbol_78.setName("value");
			symbol_78.setType(symbol_218);  // pivot|String
			symbol_78.setUpper(BigInteger.valueOf(-1));
			
			symbol_78.setIsResolveProxies(true);
			symbol_77.getOwnedAttributes().add(symbol_78);
		}
		symbol_1.getOwnedTypes().add(symbol_77);
		//
		// pivot.ecore::pivot::Element pivot|Element
		//
		symbol_79.setName("Element");
		symbol_79.getSuperClasses().add(symbol_275); // pivot|Visitable
		{ // pivot.ecore::pivot::Element::ownedComment pivot|Element|ownedComment
			symbol_80.setName("ownedComment");
			symbol_80.setType(symbol_42);  // pivot|Comment
			symbol_80.setLower(BigInteger.valueOf(0));
			symbol_80.setUpper(BigInteger.valueOf(-1));
			
			symbol_80.setIsComposite(true);
			symbol_80.setIsResolveProxies(true);
			symbol_79.getOwnedAttributes().add(symbol_80);
		}
		symbol_1.getOwnedTypes().add(symbol_79);
		//
		// pivot.ecore::pivot::EnumLiteralExp pivot|EnumLiteralExp
		//
		symbol_81.setName("EnumLiteralExp");
		symbol_81.getSuperClasses().add(symbol_123); // pivot|LiteralExp
		{ // pivot.ecore::pivot::EnumLiteralExp::referredEnumLiteral pivot|EnumLiteralExp|referredEnumLiteral
			symbol_82.setName("referredEnumLiteral");
			symbol_82.setType(symbol_85);  // pivot|EnumerationLiteral
			symbol_82.setLower(BigInteger.valueOf(0));
			
			symbol_82.setIsResolveProxies(true);
			symbol_81.getOwnedAttributes().add(symbol_82);
		}
		symbol_1.getOwnedTypes().add(symbol_81);
		//
		// pivot.ecore::pivot::Enumeration pivot|Enumeration
		//
		symbol_83.setName("Enumeration");
		symbol_83.getSuperClasses().add(symbol_75); // pivot|DataType
		{ // pivot.ecore::pivot::Enumeration::ownedLiteral pivot|Enumeration|ownedLiteral
			symbol_84.setName("ownedLiteral");
			symbol_84.setType(symbol_85);  // pivot|EnumerationLiteral
			symbol_84.setLower(BigInteger.valueOf(0));
			symbol_84.setUpper(BigInteger.valueOf(-1));
			symbol_84.setIsOrdered(true);
			
			symbol_84.setIsComposite(true);
			symbol_84.setIsResolveProxies(true);
			symbol_84.setOpposite(symbol_86);
			symbol_83.getOwnedAttributes().add(symbol_84);
		}
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// pivot.ecore::pivot::EnumerationLiteral pivot|EnumerationLiteral
		//
		symbol_85.setName("EnumerationLiteral");
		symbol_85.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::EnumerationLiteral::enumeration pivot|EnumerationLiteral|enumeration
			symbol_86.setName("enumeration");
			symbol_86.setType(symbol_83);  // pivot|Enumeration
			symbol_86.setLower(BigInteger.valueOf(0));
			
			symbol_86.setIsResolveProxies(true);
			symbol_86.setOpposite(symbol_84);
			symbol_85.getOwnedAttributes().add(symbol_86);
		}
		{ // pivot.ecore::pivot::EnumerationLiteral::value pivot|EnumerationLiteral|value
			symbol_87.setName("value");
			symbol_87.setType(symbol_104);  // pivot|Integer
			symbol_87.setLower(BigInteger.valueOf(0));
			
			symbol_87.setIsResolveProxies(true);
			symbol_85.getOwnedAttributes().add(symbol_87);
		}
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// pivot.ecore::pivot::ExpressionInOcl pivot|ExpressionInOcl
		//
		symbol_88.setName("ExpressionInOcl");
		symbol_88.getSuperClasses().add(symbol_157); // pivot|OpaqueExpression
		{ // pivot.ecore::pivot::ExpressionInOcl::bodyExpression pivot|ExpressionInOcl|bodyExpression
			symbol_89.setName("bodyExpression");
			symbol_89.setType(symbol_156);  // pivot|OclExpression
			
			symbol_89.setIsComposite(true);
			symbol_89.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_89);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::contextVariable pivot|ExpressionInOcl|contextVariable
			symbol_90.setName("contextVariable");
			symbol_90.setType(symbol_267);  // pivot|Variable
			symbol_90.setLower(BigInteger.valueOf(0));
			
			symbol_90.setIsComposite(true);
			symbol_90.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_90);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::parameterVariable pivot|ExpressionInOcl|parameterVariable
			symbol_91.setName("parameterVariable");
			symbol_91.setType(symbol_267);  // pivot|Variable
			symbol_91.setLower(BigInteger.valueOf(0));
			symbol_91.setUpper(BigInteger.valueOf(-1));
			symbol_91.setIsOrdered(true);
			
			symbol_91.setIsComposite(true);
			symbol_91.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_91);
		}
		{ // pivot.ecore::pivot::ExpressionInOcl::resultVariable pivot|ExpressionInOcl|resultVariable
			symbol_92.setName("resultVariable");
			symbol_92.setType(symbol_267);  // pivot|Variable
			symbol_92.setLower(BigInteger.valueOf(0));
			
			symbol_92.setIsComposite(true);
			symbol_92.setIsResolveProxies(true);
			symbol_88.getOwnedAttributes().add(symbol_92);
		}
		symbol_1.getOwnedTypes().add(symbol_88);
		//
		// pivot.ecore::pivot::Feature pivot|Feature
		//
		symbol_93.setName("Feature");
		symbol_93.getSuperClasses().add(symbol_144); // pivot|NamedElement
		symbol_93.getSuperClasses().add(symbol_261); // pivot|TypedMultiplicityElement
		{ // pivot.ecore::pivot::Feature::featuringClass pivot|Feature|featuringClass
			symbol_94.setName("featuringClass");
			symbol_94.setType(symbol_23);  // pivot|Class
			symbol_94.setLower(BigInteger.valueOf(0));
			
			symbol_94.setIsDerived(true);
			symbol_94.setIsReadOnly(true);
			symbol_94.setIsTransient(true);
			symbol_94.setIsVolatile(true);
			symbol_93.getOwnedAttributes().add(symbol_94);
		}
		{ // pivot.ecore::pivot::Feature::implementation pivot|Feature|implementation
			symbol_95.setName("implementation");
			symbol_95.setType(symbol_22);  // pivot|CallableImplementation
			symbol_95.setLower(BigInteger.valueOf(0));
			
			symbol_95.setIsResolveProxies(true);
			symbol_95.setIsTransient(true);
			symbol_93.getOwnedAttributes().add(symbol_95);
		}
		{ // pivot.ecore::pivot::Feature::implementationClass pivot|Feature|implementationClass
			symbol_96.setName("implementationClass");
			symbol_96.setType(symbol_218);  // pivot|String
			symbol_96.setLower(BigInteger.valueOf(0));
			
			symbol_96.setIsResolveProxies(true);
			symbol_93.getOwnedAttributes().add(symbol_96);
		}
		symbol_1.getOwnedTypes().add(symbol_93);
		//
		// pivot.ecore::pivot::FeatureCallExp pivot|FeatureCallExp
		//
		symbol_97.setName("FeatureCallExp");
		symbol_97.getSuperClasses().add(symbol_16); // pivot|CallExp
		{ // pivot.ecore::pivot::FeatureCallExp::isPre pivot|FeatureCallExp|isPre
			symbol_98.setName("isPre");
			symbol_98.setType(symbol_13);  // pivot|Boolean
			
			symbol_98.setIsResolveProxies(true);
			symbol_97.getOwnedAttributes().add(symbol_98);
		}
		symbol_1.getOwnedTypes().add(symbol_97);
		//
		// pivot.ecore::pivot::IfExp pivot|IfExp
		//
		symbol_99.setName("IfExp");
		symbol_99.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::IfExp::condition pivot|IfExp|condition
			symbol_100.setName("condition");
			symbol_100.setType(symbol_156);  // pivot|OclExpression
			
			symbol_100.setIsComposite(true);
			symbol_100.setIsResolveProxies(true);
			symbol_99.getOwnedAttributes().add(symbol_100);
		}
		{ // pivot.ecore::pivot::IfExp::elseExpression pivot|IfExp|elseExpression
			symbol_101.setName("elseExpression");
			symbol_101.setType(symbol_156);  // pivot|OclExpression
			
			symbol_101.setIsComposite(true);
			symbol_101.setIsResolveProxies(true);
			symbol_99.getOwnedAttributes().add(symbol_101);
		}
		{ // pivot.ecore::pivot::IfExp::thenExpression pivot|IfExp|thenExpression
			symbol_102.setName("thenExpression");
			symbol_102.setType(symbol_156);  // pivot|OclExpression
			
			symbol_102.setIsComposite(true);
			symbol_102.setIsResolveProxies(true);
			symbol_99.getOwnedAttributes().add(symbol_102);
		}
		symbol_1.getOwnedTypes().add(symbol_99);
		//
		// pivot.ecore::pivot::Int pivot|Int
		//
		symbol_103.setName("Int");
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// pivot.ecore::pivot::IntegerLiteralExp pivot|IntegerLiteralExp
		//
		symbol_105.setName("IntegerLiteralExp");
		symbol_105.getSuperClasses().add(symbol_154); // pivot|NumericLiteralExp
		{ // pivot.ecore::pivot::IntegerLiteralExp::integerSymbol pivot|IntegerLiteralExp|integerSymbol
			symbol_106.setName("integerSymbol");
			symbol_106.setType(symbol_104);  // pivot|Integer
			
			symbol_106.setIsResolveProxies(true);
			symbol_105.getOwnedAttributes().add(symbol_106);
		}
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// pivot.ecore::pivot::InvalidLiteralExp pivot|InvalidLiteralExp
		//
		symbol_107.setName("InvalidLiteralExp");
		symbol_107.getSuperClasses().add(symbol_123); // pivot|LiteralExp
		{ // pivot.ecore::pivot::InvalidLiteralExp::expression pivot|InvalidLiteralExp|expression
			symbol_108.setName("expression");
			symbol_108.setType(symbol_156);  // pivot|OclExpression
			symbol_108.setLower(BigInteger.valueOf(0));
			
			symbol_108.setIsResolveProxies(true);
			symbol_107.getOwnedAttributes().add(symbol_108);
		}
		{ // pivot.ecore::pivot::InvalidLiteralExp::object pivot|InvalidLiteralExp|object
			symbol_109.setName("object");
			symbol_109.setType(symbol_155);  // pivot|Object
			symbol_109.setLower(BigInteger.valueOf(0));
			
			symbol_109.setIsResolveProxies(true);
			symbol_107.getOwnedAttributes().add(symbol_109);
		}
		{ // pivot.ecore::pivot::InvalidLiteralExp::reason pivot|InvalidLiteralExp|reason
			symbol_110.setName("reason");
			symbol_110.setType(symbol_218);  // pivot|String
			symbol_110.setLower(BigInteger.valueOf(0));
			
			symbol_110.setIsResolveProxies(true);
			symbol_107.getOwnedAttributes().add(symbol_110);
		}
		{ // pivot.ecore::pivot::InvalidLiteralExp::throwable pivot|InvalidLiteralExp|throwable
			symbol_111.setName("throwable");
			symbol_111.setType(symbol_245);  // pivot|Throwable
			symbol_111.setLower(BigInteger.valueOf(0));
			
			symbol_111.setIsResolveProxies(true);
			symbol_107.getOwnedAttributes().add(symbol_111);
		}
		symbol_1.getOwnedTypes().add(symbol_107);
		//
		// pivot.ecore::pivot::InvalidType pivot|InvalidType
		//
		symbol_112.setName("InvalidType");
		symbol_112.getSuperClasses().add(symbol_23); // pivot|Class
		symbol_1.getOwnedTypes().add(symbol_112);
		//
		// pivot.ecore::pivot::IterateExp pivot|IterateExp
		//
		symbol_113.setName("IterateExp");
		symbol_113.getSuperClasses().add(symbol_124); // pivot|LoopExp
		{ // pivot.ecore::pivot::IterateExp::result pivot|IterateExp|result
			symbol_114.setName("result");
			symbol_114.setType(symbol_267);  // pivot|Variable
			symbol_114.setLower(BigInteger.valueOf(0));
			symbol_114.setIsOrdered(true);
			
			symbol_114.setIsComposite(true);
			symbol_114.setIsResolveProxies(true);
			symbol_113.getOwnedAttributes().add(symbol_114);
		}
		symbol_1.getOwnedTypes().add(symbol_113);
		//
		// pivot.ecore::pivot::Iteration pivot|Iteration
		//
		symbol_115.setName("Iteration");
		symbol_115.getSuperClasses().add(symbol_160); // pivot|Operation
		{ // pivot.ecore::pivot::Iteration::ownedAccumulator pivot|Iteration|ownedAccumulator
			symbol_116.setName("ownedAccumulator");
			symbol_116.setType(symbol_178);  // pivot|Parameter
			symbol_116.setLower(BigInteger.valueOf(0));
			symbol_116.setUpper(BigInteger.valueOf(-1));
			
			symbol_116.setIsComposite(true);
			symbol_116.setIsResolveProxies(true);
			symbol_115.getOwnedAttributes().add(symbol_116);
		}
		{ // pivot.ecore::pivot::Iteration::ownedIterator pivot|Iteration|ownedIterator
			symbol_117.setName("ownedIterator");
			symbol_117.setType(symbol_178);  // pivot|Parameter
			symbol_117.setLower(BigInteger.valueOf(0));
			symbol_117.setUpper(BigInteger.valueOf(-1));
			
			symbol_117.setIsComposite(true);
			symbol_117.setIsResolveProxies(true);
			symbol_115.getOwnedAttributes().add(symbol_117);
		}
		symbol_1.getOwnedTypes().add(symbol_115);
		//
		// pivot.ecore::pivot::IteratorExp pivot|IteratorExp
		//
		symbol_118.setName("IteratorExp");
		symbol_118.getSuperClasses().add(symbol_124); // pivot|LoopExp
		symbol_1.getOwnedTypes().add(symbol_118);
		//
		// pivot.ecore::pivot::LetExp pivot|LetExp
		//
		symbol_119.setName("LetExp");
		symbol_119.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::LetExp::in pivot|LetExp|in
			symbol_120.setName("in");
			symbol_120.setType(symbol_156);  // pivot|OclExpression
			
			symbol_120.setIsComposite(true);
			symbol_120.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_120);
		}
		{ // pivot.ecore::pivot::LetExp::variable pivot|LetExp|variable
			symbol_121.setName("variable");
			symbol_121.setType(symbol_267);  // pivot|Variable
			
			symbol_121.setIsComposite(true);
			symbol_121.setIsResolveProxies(true);
			symbol_119.getOwnedAttributes().add(symbol_121);
		}
		symbol_1.getOwnedTypes().add(symbol_119);
		//
		// pivot.ecore::pivot::Library pivot|Library
		//
		symbol_122.setName("Library");
		symbol_122.getSuperClasses().add(symbol_170); // pivot|Package
		symbol_1.getOwnedTypes().add(symbol_122);
		//
		// pivot.ecore::pivot::LiteralExp pivot|LiteralExp
		//
		symbol_123.setName("LiteralExp");
		symbol_123.getSuperClasses().add(symbol_156); // pivot|OclExpression
		symbol_1.getOwnedTypes().add(symbol_123);
		//
		// pivot.ecore::pivot::LoopExp pivot|LoopExp
		//
		symbol_124.setName("LoopExp");
		symbol_124.getSuperClasses().add(symbol_16); // pivot|CallExp
		{ // pivot.ecore::pivot::LoopExp::body pivot|LoopExp|body
			symbol_125.setName("body");
			symbol_125.setType(symbol_156);  // pivot|OclExpression
			
			symbol_125.setIsComposite(true);
			symbol_125.setIsResolveProxies(true);
			symbol_124.getOwnedAttributes().add(symbol_125);
		}
		{ // pivot.ecore::pivot::LoopExp::iterator pivot|LoopExp|iterator
			symbol_126.setName("iterator");
			symbol_126.setType(symbol_267);  // pivot|Variable
			symbol_126.setLower(BigInteger.valueOf(0));
			symbol_126.setUpper(BigInteger.valueOf(-1));
			symbol_126.setIsOrdered(true);
			
			symbol_126.setIsComposite(true);
			symbol_126.setIsResolveProxies(true);
			symbol_124.getOwnedAttributes().add(symbol_126);
		}
		{ // pivot.ecore::pivot::LoopExp::referredIteration pivot|LoopExp|referredIteration
			symbol_127.setName("referredIteration");
			symbol_127.setType(symbol_115);  // pivot|Iteration
			symbol_127.setLower(BigInteger.valueOf(0));
			
			symbol_127.setIsResolveProxies(true);
			symbol_124.getOwnedAttributes().add(symbol_127);
		}
		symbol_1.getOwnedTypes().add(symbol_124);
		//
		// pivot.ecore::pivot::MessageExp pivot|MessageExp
		//
		symbol_128.setName("MessageExp");
		symbol_128.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::MessageExp::argument pivot|MessageExp|argument
			symbol_129.setName("argument");
			symbol_129.setType(symbol_156);  // pivot|OclExpression
			symbol_129.setLower(BigInteger.valueOf(0));
			symbol_129.setUpper(BigInteger.valueOf(-1));
			
			symbol_129.setIsComposite(true);
			symbol_129.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_129);
		}
		{ // pivot.ecore::pivot::MessageExp::calledOperation pivot|MessageExp|calledOperation
			symbol_130.setName("calledOperation");
			symbol_130.setType(symbol_20);  // pivot|CallOperationAction
			symbol_130.setLower(BigInteger.valueOf(0));
			
			symbol_130.setIsComposite(true);
			symbol_130.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_130);
		}
		{ // pivot.ecore::pivot::MessageExp::sentSignal pivot|MessageExp|sentSignal
			symbol_131.setName("sentSignal");
			symbol_131.setType(symbol_210);  // pivot|SendSignalAction
			symbol_131.setLower(BigInteger.valueOf(0));
			
			symbol_131.setIsComposite(true);
			symbol_131.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_131);
		}
		{ // pivot.ecore::pivot::MessageExp::target pivot|MessageExp|target
			symbol_132.setName("target");
			symbol_132.setType(symbol_156);  // pivot|OclExpression
			
			symbol_132.setIsComposite(true);
			symbol_132.setIsResolveProxies(true);
			symbol_128.getOwnedAttributes().add(symbol_132);
		}
		symbol_1.getOwnedTypes().add(symbol_128);
		//
		// pivot.ecore::pivot::MessageType pivot|MessageType
		//
		symbol_133.setName("MessageType");
		symbol_133.getSuperClasses().add(symbol_251); // pivot|Type
		{ // pivot.ecore::pivot::MessageType::referredOperation pivot|MessageType|referredOperation
			symbol_134.setName("referredOperation");
			symbol_134.setType(symbol_160);  // pivot|Operation
			symbol_134.setLower(BigInteger.valueOf(0));
			
			symbol_134.setIsResolveProxies(true);
			symbol_133.getOwnedAttributes().add(symbol_134);
		}
		{ // pivot.ecore::pivot::MessageType::referredSignal pivot|MessageType|referredSignal
			symbol_135.setName("referredSignal");
			symbol_135.setType(symbol_214);  // pivot|Signal
			symbol_135.setLower(BigInteger.valueOf(0));
			
			symbol_135.setIsResolveProxies(true);
			symbol_133.getOwnedAttributes().add(symbol_135);
		}
		symbol_1.getOwnedTypes().add(symbol_133);
		//
		// pivot.ecore::pivot::MonikeredElement pivot|MonikeredElement
		//
		symbol_136.setName("MonikeredElement");
		symbol_136.getSuperClasses().add(symbol_79); // pivot|Element
		{ // pivot.ecore::pivot::MonikeredElement::moniker pivot|MonikeredElement|moniker
			symbol_137.setName("moniker");
			symbol_137.setType(symbol_218);  // pivot|String
			
			symbol_137.setIsDerived(true);
			symbol_137.setIsResolveProxies(true);
			symbol_137.setIsTransient(true);
			symbol_137.setIsVolatile(true);
			symbol_136.getOwnedAttributes().add(symbol_137);
		}
		{	// pivot.ecore::pivot::MonikeredElement::hasMoniker() pivot|MonikeredElement|hasMoniker()
			Operation symbol_303 = PivotFactory.eINSTANCE.createOperation();
			symbol_303.setName("hasMoniker");
			symbol_303.setType(symbol_13);  // pivot|Boolean
			
			symbol_136.getOwnedOperations().add(symbol_303);
		}
		symbol_1.getOwnedTypes().add(symbol_136);
		//
		// pivot.ecore::pivot::MultiplicityElement pivot|MultiplicityElement
		//
		symbol_138.setName("MultiplicityElement");
		symbol_138.getSuperClasses().add(symbol_136); // pivot|MonikeredElement
		{ // pivot.ecore::pivot::MultiplicityElement::isOrdered pivot|MultiplicityElement|isOrdered
			symbol_139.setName("isOrdered");
			symbol_139.setType(symbol_13);  // pivot|Boolean
			
			symbol_139.setIsResolveProxies(true);
			symbol_138.getOwnedAttributes().add(symbol_139);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::isUnique pivot|MultiplicityElement|isUnique
			symbol_140.setName("isUnique");
			symbol_140.setType(symbol_13);  // pivot|Boolean
			
			symbol_140.setIsResolveProxies(true);
			symbol_138.getOwnedAttributes().add(symbol_140);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::lower pivot|MultiplicityElement|lower
			symbol_141.setName("lower");
			symbol_141.setType(symbol_104);  // pivot|Integer
			symbol_141.setLower(BigInteger.valueOf(0));
			
			symbol_141.setIsResolveProxies(true);
			symbol_138.getOwnedAttributes().add(symbol_141);
		}
		{ // pivot.ecore::pivot::MultiplicityElement::upper pivot|MultiplicityElement|upper
			symbol_142.setName("upper");
			symbol_142.setType(symbol_262);  // pivot|UnlimitedNatural
			symbol_142.setLower(BigInteger.valueOf(0));
			
			symbol_142.setIsResolveProxies(true);
			symbol_138.getOwnedAttributes().add(symbol_142);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesCardinality() pivot|MultiplicityElement|includesCardinality(pivot|Integer)
			Operation symbol_304 = PivotFactory.eINSTANCE.createOperation();
			symbol_304.setName("includesCardinality");
			symbol_304.setType(symbol_13);  // pivot|Boolean
			
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("C");
			symbol_305.setType(symbol_104);  // pivot|Integer
			
			symbol_304.getOwnedParameters().add(symbol_305);
			symbol_138.getOwnedOperations().add(symbol_304);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::includesMultiplicity() pivot|MultiplicityElement|includesMultiplicity(pivot|MultiplicityElement)
			Operation symbol_306 = PivotFactory.eINSTANCE.createOperation();
			symbol_306.setName("includesMultiplicity");
			symbol_306.setType(symbol_13);  // pivot|Boolean
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("M");
			symbol_307.setType(symbol_138);  // pivot|MultiplicityElement
			
			symbol_306.getOwnedParameters().add(symbol_307);
			symbol_138.getOwnedOperations().add(symbol_306);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::isMultivalued() pivot|MultiplicityElement|isMultivalued()
			Operation symbol_308 = PivotFactory.eINSTANCE.createOperation();
			symbol_308.setName("isMultivalued");
			symbol_308.setType(symbol_13);  // pivot|Boolean
			
			symbol_138.getOwnedOperations().add(symbol_308);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::lowerBound() pivot|MultiplicityElement|lowerBound()
			Operation symbol_309 = PivotFactory.eINSTANCE.createOperation();
			symbol_309.setName("lowerBound");
			symbol_309.setType(symbol_104);  // pivot|Integer
			
			symbol_138.getOwnedOperations().add(symbol_309);
		}
		{	// pivot.ecore::pivot::MultiplicityElement::upperBound() pivot|MultiplicityElement|upperBound()
			Operation symbol_310 = PivotFactory.eINSTANCE.createOperation();
			symbol_310.setName("upperBound");
			symbol_310.setType(symbol_262);  // pivot|UnlimitedNatural
			
			symbol_138.getOwnedOperations().add(symbol_310);
		}
		symbol_1.getOwnedTypes().add(symbol_138);
		//
		// pivot.ecore::pivot::Nameable pivot|Nameable
		//
		symbol_143.setName("Nameable");
		symbol_1.getOwnedTypes().add(symbol_143);
		//
		// pivot.ecore::pivot::NamedElement pivot|NamedElement
		//
		symbol_144.setName("NamedElement");
		symbol_144.getSuperClasses().add(symbol_136); // pivot|MonikeredElement
		symbol_144.getSuperClasses().add(symbol_143); // pivot|Nameable
		{ // pivot.ecore::pivot::NamedElement::isStatic pivot|NamedElement|isStatic
			symbol_145.setName("isStatic");
			symbol_145.setType(symbol_13);  // pivot|Boolean
			
			symbol_145.setIsResolveProxies(true);
			symbol_144.getOwnedAttributes().add(symbol_145);
		}
		{ // pivot.ecore::pivot::NamedElement::name pivot|NamedElement|name
			symbol_146.setName("name");
			symbol_146.setType(symbol_218);  // pivot|String
			symbol_146.setLower(BigInteger.valueOf(0));
			
			symbol_146.setIsResolveProxies(true);
			symbol_144.getOwnedAttributes().add(symbol_146);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedAnnotation pivot|NamedElement|ownedAnnotation
			symbol_147.setName("ownedAnnotation");
			symbol_147.setType(symbol_2);  // pivot|Annotation
			symbol_147.setLower(BigInteger.valueOf(0));
			symbol_147.setUpper(BigInteger.valueOf(-1));
			symbol_147.setIsOrdered(true);
			
			symbol_147.setIsComposite(true);
			symbol_147.setIsResolveProxies(true);
			symbol_144.getOwnedAttributes().add(symbol_147);
		}
		{ // pivot.ecore::pivot::NamedElement::ownedRule pivot|NamedElement|ownedRule
			symbol_148.setName("ownedRule");
			symbol_148.setType(symbol_70);  // pivot|Constraint
			symbol_148.setLower(BigInteger.valueOf(0));
			symbol_148.setUpper(BigInteger.valueOf(-1));
			
			symbol_148.setIsComposite(true);
			symbol_148.setIsResolveProxies(true);
			symbol_144.getOwnedAttributes().add(symbol_148);
		}
		symbol_1.getOwnedTypes().add(symbol_144);
		//
		// pivot.ecore::pivot::Namespace pivot|Namespace
		//
		symbol_149.setName("Namespace");
		symbol_149.getSuperClasses().add(symbol_144); // pivot|NamedElement
		symbol_1.getOwnedTypes().add(symbol_149);
		//
		// pivot.ecore::pivot::NavigationCallExp pivot|NavigationCallExp
		//
		symbol_150.setName("NavigationCallExp");
		symbol_150.getSuperClasses().add(symbol_97); // pivot|FeatureCallExp
		{ // pivot.ecore::pivot::NavigationCallExp::navigationSource pivot|NavigationCallExp|navigationSource
			symbol_151.setName("navigationSource");
			symbol_151.setType(symbol_189);  // pivot|Property
			symbol_151.setLower(BigInteger.valueOf(0));
			symbol_151.setIsOrdered(true);
			
			symbol_151.setIsResolveProxies(true);
			symbol_150.getOwnedAttributes().add(symbol_151);
		}
		{ // pivot.ecore::pivot::NavigationCallExp::qualifier pivot|NavigationCallExp|qualifier
			symbol_152.setName("qualifier");
			symbol_152.setType(symbol_156);  // pivot|OclExpression
			symbol_152.setLower(BigInteger.valueOf(0));
			symbol_152.setUpper(BigInteger.valueOf(-1));
			symbol_152.setIsOrdered(true);
			
			symbol_152.setIsResolveProxies(true);
			symbol_150.getOwnedAttributes().add(symbol_152);
		}
		symbol_1.getOwnedTypes().add(symbol_150);
		//
		// pivot.ecore::pivot::NullLiteralExp pivot|NullLiteralExp
		//
		symbol_153.setName("NullLiteralExp");
		symbol_153.getSuperClasses().add(symbol_187); // pivot|PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_153);
		//
		// pivot.ecore::pivot::NumericLiteralExp pivot|NumericLiteralExp
		//
		symbol_154.setName("NumericLiteralExp");
		symbol_154.getSuperClasses().add(symbol_187); // pivot|PrimitiveLiteralExp
		symbol_1.getOwnedTypes().add(symbol_154);
		//
		// pivot.ecore::pivot::Object pivot|Object
		//
		symbol_155.setName("Object");
		symbol_1.getOwnedTypes().add(symbol_155);
		//
		// pivot.ecore::pivot::OclExpression pivot|OclExpression
		//
		symbol_156.setName("OclExpression");
		symbol_156.getSuperClasses().add(symbol_259); // pivot|TypedElement
		symbol_1.getOwnedTypes().add(symbol_156);
		//
		// pivot.ecore::pivot::OpaqueExpression pivot|OpaqueExpression
		//
		symbol_157.setName("OpaqueExpression");
		symbol_157.getSuperClasses().add(symbol_266); // pivot|ValueSpecification
		{ // pivot.ecore::pivot::OpaqueExpression::body pivot|OpaqueExpression|body
			symbol_158.setName("body");
			symbol_158.setType(symbol_218);  // pivot|String
			symbol_158.setLower(BigInteger.valueOf(0));
			symbol_158.setUpper(BigInteger.valueOf(-1));
			symbol_158.setIsOrdered(true);
			symbol_158.setIsUnique(false);
			
			symbol_158.setIsResolveProxies(true);
			symbol_157.getOwnedAttributes().add(symbol_158);
		}
		{ // pivot.ecore::pivot::OpaqueExpression::language pivot|OpaqueExpression|language
			symbol_159.setName("language");
			symbol_159.setType(symbol_218);  // pivot|String
			symbol_159.setLower(BigInteger.valueOf(0));
			symbol_159.setUpper(BigInteger.valueOf(-1));
			symbol_159.setIsOrdered(true);
			
			symbol_159.setIsResolveProxies(true);
			symbol_157.getOwnedAttributes().add(symbol_159);
		}
		symbol_1.getOwnedTypes().add(symbol_157);
		//
		// pivot.ecore::pivot::Operation pivot|Operation
		//
		symbol_160.setName("Operation");
		symbol_160.getSuperClasses().add(symbol_149); // pivot|Namespace
		symbol_160.getSuperClasses().add(symbol_242); // pivot|TemplateableElement
		symbol_160.getSuperClasses().add(symbol_180); // pivot|ParameterableElement
		symbol_160.getSuperClasses().add(symbol_259); // pivot|TypedElement
		symbol_160.getSuperClasses().add(symbol_138); // pivot|MultiplicityElement
		symbol_160.getSuperClasses().add(symbol_93); // pivot|Feature
		{ // pivot.ecore::pivot::Operation::class pivot|Operation|class
			symbol_161.setName("class");
			symbol_161.setType(symbol_23);  // pivot|Class
			symbol_161.setLower(BigInteger.valueOf(0));
			
			symbol_161.setIsResolveProxies(true);
			symbol_161.setOpposite(symbol_27);
			symbol_160.getOwnedAttributes().add(symbol_161);
		}
		{ // pivot.ecore::pivot::Operation::ownedParameter pivot|Operation|ownedParameter
			symbol_162.setName("ownedParameter");
			symbol_162.setType(symbol_178);  // pivot|Parameter
			symbol_162.setLower(BigInteger.valueOf(0));
			symbol_162.setUpper(BigInteger.valueOf(-1));
			symbol_162.setIsOrdered(true);
			
			symbol_162.setIsComposite(true);
			symbol_162.setIsResolveProxies(true);
			symbol_162.setOpposite(symbol_179);
			symbol_160.getOwnedAttributes().add(symbol_162);
		}
		{ // pivot.ecore::pivot::Operation::precedence pivot|Operation|precedence
			symbol_163.setName("precedence");
			symbol_163.setType(symbol_184);  // pivot|Precedence
			symbol_163.setLower(BigInteger.valueOf(0));
			
			symbol_163.setIsResolveProxies(true);
			symbol_160.getOwnedAttributes().add(symbol_163);
		}
		{ // pivot.ecore::pivot::Operation::raisedException pivot|Operation|raisedException
			symbol_164.setName("raisedException");
			symbol_164.setType(symbol_251);  // pivot|Type
			symbol_164.setLower(BigInteger.valueOf(0));
			symbol_164.setUpper(BigInteger.valueOf(-1));
			
			symbol_164.setIsResolveProxies(true);
			symbol_160.getOwnedAttributes().add(symbol_164);
		}
		symbol_1.getOwnedTypes().add(symbol_160);
		//
		// pivot.ecore::pivot::OperationCallExp pivot|OperationCallExp
		//
		symbol_165.setName("OperationCallExp");
		symbol_165.getSuperClasses().add(symbol_97); // pivot|FeatureCallExp
		{ // pivot.ecore::pivot::OperationCallExp::argument pivot|OperationCallExp|argument
			symbol_166.setName("argument");
			symbol_166.setType(symbol_156);  // pivot|OclExpression
			symbol_166.setLower(BigInteger.valueOf(0));
			symbol_166.setUpper(BigInteger.valueOf(-1));
			symbol_166.setIsOrdered(true);
			
			symbol_166.setIsComposite(true);
			symbol_166.setIsResolveProxies(true);
			symbol_165.getOwnedAttributes().add(symbol_166);
		}
		{ // pivot.ecore::pivot::OperationCallExp::referredOperation pivot|OperationCallExp|referredOperation
			symbol_167.setName("referredOperation");
			symbol_167.setType(symbol_160);  // pivot|Operation
			symbol_167.setLower(BigInteger.valueOf(0));
			
			symbol_167.setIsResolveProxies(true);
			symbol_165.getOwnedAttributes().add(symbol_167);
		}
		symbol_1.getOwnedTypes().add(symbol_165);
		//
		// pivot.ecore::pivot::OperationTemplateParameter pivot|OperationTemplateParameter
		//
		symbol_168.setName("OperationTemplateParameter");
		symbol_168.getSuperClasses().add(symbol_225); // pivot|TemplateParameter
		symbol_1.getOwnedTypes().add(symbol_168);
		//
		// pivot.ecore::pivot::OrderedSetType pivot|OrderedSetType
		//
		symbol_169.setName("OrderedSetType");
		symbol_169.getSuperClasses().add(symbol_40); // pivot|CollectionType
		symbol_1.getOwnedTypes().add(symbol_169);
		//
		// pivot.ecore::pivot::Package pivot|Package
		//
		symbol_170.setName("Package");
		symbol_170.getSuperClasses().add(symbol_149); // pivot|Namespace
		symbol_170.getSuperClasses().add(symbol_242); // pivot|TemplateableElement
		{ // pivot.ecore::pivot::Package::nestedPackage pivot|Package|nestedPackage
			symbol_171.setName("nestedPackage");
			symbol_171.setType(symbol_170);  // pivot|Package
			symbol_171.setLower(BigInteger.valueOf(0));
			symbol_171.setUpper(BigInteger.valueOf(-1));
			
			symbol_171.setIsComposite(true);
			symbol_171.setIsResolveProxies(true);
			symbol_171.setOpposite(symbol_172);
			symbol_170.getOwnedAttributes().add(symbol_171);
		}
		{ // pivot.ecore::pivot::Package::nestingPackage pivot|Package|nestingPackage
			symbol_172.setName("nestingPackage");
			symbol_172.setType(symbol_170);  // pivot|Package
			symbol_172.setLower(BigInteger.valueOf(0));
			
			symbol_172.setIsResolveProxies(true);
			symbol_172.setOpposite(symbol_171);
			symbol_170.getOwnedAttributes().add(symbol_172);
		}
		{ // pivot.ecore::pivot::Package::nsPrefix pivot|Package|nsPrefix
			symbol_173.setName("nsPrefix");
			symbol_173.setType(symbol_218);  // pivot|String
			symbol_173.setLower(BigInteger.valueOf(0));
			
			symbol_173.setIsResolveProxies(true);
			symbol_170.getOwnedAttributes().add(symbol_173);
		}
		{ // pivot.ecore::pivot::Package::nsURI pivot|Package|nsURI
			symbol_174.setName("nsURI");
			symbol_174.setType(symbol_218);  // pivot|String
			symbol_174.setLower(BigInteger.valueOf(0));
			
			symbol_174.setIsResolveProxies(true);
			symbol_170.getOwnedAttributes().add(symbol_174);
		}
		{ // pivot.ecore::pivot::Package::ownedPrecedence pivot|Package|ownedPrecedence
			symbol_175.setName("ownedPrecedence");
			symbol_175.setType(symbol_184);  // pivot|Precedence
			symbol_175.setLower(BigInteger.valueOf(0));
			symbol_175.setUpper(BigInteger.valueOf(-1));
			symbol_175.setIsOrdered(true);
			
			symbol_175.setIsComposite(true);
			symbol_175.setIsResolveProxies(true);
			symbol_170.getOwnedAttributes().add(symbol_175);
		}
		{ // pivot.ecore::pivot::Package::ownedType pivot|Package|ownedType
			symbol_176.setName("ownedType");
			symbol_176.setType(symbol_251);  // pivot|Type
			symbol_176.setLower(BigInteger.valueOf(0));
			symbol_176.setUpper(BigInteger.valueOf(-1));
			
			symbol_176.setIsComposite(true);
			symbol_176.setIsResolveProxies(true);
			symbol_176.setOpposite(symbol_253);
			symbol_170.getOwnedAttributes().add(symbol_176);
		}
		symbol_1.getOwnedTypes().add(symbol_170);
		//
		// pivot.ecore::pivot::PackageableElement pivot|PackageableElement
		//
		symbol_177.setName("PackageableElement");
		symbol_177.getSuperClasses().add(symbol_180); // pivot|ParameterableElement
		symbol_1.getOwnedTypes().add(symbol_177);
		//
		// pivot.ecore::pivot::Parameter pivot|Parameter
		//
		symbol_178.setName("Parameter");
		symbol_178.getSuperClasses().add(symbol_271); // pivot|VariableDeclaration
		symbol_178.getSuperClasses().add(symbol_261); // pivot|TypedMultiplicityElement
		{ // pivot.ecore::pivot::Parameter::operation pivot|Parameter|operation
			symbol_179.setName("operation");
			symbol_179.setType(symbol_160);  // pivot|Operation
			symbol_179.setLower(BigInteger.valueOf(0));
			
			symbol_179.setIsResolveProxies(true);
			symbol_179.setOpposite(symbol_162);
			symbol_178.getOwnedAttributes().add(symbol_179);
		}
		symbol_1.getOwnedTypes().add(symbol_178);
		//
		// pivot.ecore::pivot::ParameterableElement pivot|ParameterableElement
		//
		symbol_180.setName("ParameterableElement");
		symbol_180.getSuperClasses().add(symbol_136); // pivot|MonikeredElement
		{ // pivot.ecore::pivot::ParameterableElement::owningTemplateParameter pivot|ParameterableElement|owningTemplateParameter
			symbol_181.setName("owningTemplateParameter");
			symbol_181.setType(symbol_225);  // pivot|TemplateParameter
			symbol_181.setLower(BigInteger.valueOf(0));
			
			symbol_181.setIsResolveProxies(true);
			symbol_181.setOpposite(symbol_228);
			symbol_180.getOwnedAttributes().add(symbol_181);
		}
		{ // pivot.ecore::pivot::ParameterableElement::templateParameter pivot|ParameterableElement|templateParameter
			symbol_182.setName("templateParameter");
			symbol_182.setType(symbol_225);  // pivot|TemplateParameter
			symbol_182.setLower(BigInteger.valueOf(0));
			
			symbol_182.setIsResolveProxies(true);
			symbol_182.setOpposite(symbol_229);
			symbol_180.getOwnedAttributes().add(symbol_182);
		}
		{	// pivot.ecore::pivot::ParameterableElement::isTemplateParameter() pivot|ParameterableElement|isTemplateParameter()
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("isTemplateParameter");
			symbol_311.setType(symbol_13);  // pivot|Boolean
			
			symbol_180.getOwnedOperations().add(symbol_311);
		}
		symbol_1.getOwnedTypes().add(symbol_180);
		//
		// pivot.ecore::pivot::Pivotable pivot|Pivotable
		//
		symbol_183.setName("Pivotable");
		symbol_1.getOwnedTypes().add(symbol_183);
		//
		// pivot.ecore::pivot::Precedence pivot|Precedence
		//
		symbol_184.setName("Precedence");
		symbol_184.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::Precedence::associativity pivot|Precedence|associativity
			symbol_185.setName("associativity");
			symbol_185.setType(symbol_11);  // pivot|AssociativityKind
			symbol_185.setLower(BigInteger.valueOf(0));
			
			symbol_185.setIsResolveProxies(true);
			symbol_184.getOwnedAttributes().add(symbol_185);
		}
		{ // pivot.ecore::pivot::Precedence::order pivot|Precedence|order
			symbol_186.setName("order");
			symbol_186.setType(symbol_104);  // pivot|Integer
			
			symbol_186.setIsDerived(true);
			symbol_186.setIsResolveProxies(true);
			symbol_186.setIsVolatile(true);
			symbol_184.getOwnedAttributes().add(symbol_186);
		}
		symbol_1.getOwnedTypes().add(symbol_184);
		//
		// pivot.ecore::pivot::PrimitiveLiteralExp pivot|PrimitiveLiteralExp
		//
		symbol_187.setName("PrimitiveLiteralExp");
		symbol_187.getSuperClasses().add(symbol_123); // pivot|LiteralExp
		symbol_1.getOwnedTypes().add(symbol_187);
		//
		// pivot.ecore::pivot::PrimitiveType pivot|PrimitiveType
		//
		symbol_188.setName("PrimitiveType");
		symbol_188.getSuperClasses().add(symbol_75); // pivot|DataType
		symbol_1.getOwnedTypes().add(symbol_188);
		//
		// pivot.ecore::pivot::Property pivot|Property
		//
		symbol_189.setName("Property");
		symbol_189.getSuperClasses().add(symbol_180); // pivot|ParameterableElement
		symbol_189.getSuperClasses().add(symbol_259); // pivot|TypedElement
		symbol_189.getSuperClasses().add(symbol_138); // pivot|MultiplicityElement
		symbol_189.getSuperClasses().add(symbol_93); // pivot|Feature
		{ // pivot.ecore::pivot::Property::association pivot|Property|association
			symbol_190.setName("association");
			symbol_190.setType(symbol_7);  // pivot|AssociationClass
			symbol_190.setLower(BigInteger.valueOf(0));
			
			symbol_190.setIsResolveProxies(true);
			symbol_190.setOpposite(symbol_8);
			symbol_189.getOwnedAttributes().add(symbol_190);
		}
		{ // pivot.ecore::pivot::Property::class pivot|Property|class
			symbol_191.setName("class");
			symbol_191.setType(symbol_23);  // pivot|Class
			symbol_191.setLower(BigInteger.valueOf(0));
			
			symbol_191.setIsResolveProxies(true);
			symbol_191.setOpposite(symbol_26);
			symbol_189.getOwnedAttributes().add(symbol_191);
		}
		{ // pivot.ecore::pivot::Property::default pivot|Property|default
			symbol_192.setName("default");
			symbol_192.setType(symbol_218);  // pivot|String
			symbol_192.setLower(BigInteger.valueOf(0));
			
			symbol_192.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_192);
		}
		{ // pivot.ecore::pivot::Property::implicit pivot|Property|implicit
			symbol_193.setName("implicit");
			symbol_193.setType(symbol_13);  // pivot|Boolean
			symbol_193.setLower(BigInteger.valueOf(0));
			
			symbol_193.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_193);
		}
		{ // pivot.ecore::pivot::Property::isComposite pivot|Property|isComposite
			symbol_194.setName("isComposite");
			symbol_194.setType(symbol_13);  // pivot|Boolean
			
			symbol_194.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_194);
		}
		{ // pivot.ecore::pivot::Property::isDerived pivot|Property|isDerived
			symbol_195.setName("isDerived");
			symbol_195.setType(symbol_13);  // pivot|Boolean
			
			symbol_195.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_195);
		}
		{ // pivot.ecore::pivot::Property::isID pivot|Property|isID
			symbol_196.setName("isID");
			symbol_196.setType(symbol_13);  // pivot|Boolean
			
			symbol_196.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_196);
		}
		{ // pivot.ecore::pivot::Property::isReadOnly pivot|Property|isReadOnly
			symbol_197.setName("isReadOnly");
			symbol_197.setType(symbol_13);  // pivot|Boolean
			
			symbol_197.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_197);
		}
		{ // pivot.ecore::pivot::Property::isResolveProxies pivot|Property|isResolveProxies
			symbol_198.setName("isResolveProxies");
			symbol_198.setType(symbol_13);  // pivot|Boolean
			
			symbol_198.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_198);
		}
		{ // pivot.ecore::pivot::Property::isTransient pivot|Property|isTransient
			symbol_199.setName("isTransient");
			symbol_199.setType(symbol_13);  // pivot|Boolean
			
			symbol_199.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_199);
		}
		{ // pivot.ecore::pivot::Property::isUnsettable pivot|Property|isUnsettable
			symbol_200.setName("isUnsettable");
			symbol_200.setType(symbol_13);  // pivot|Boolean
			
			symbol_200.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_200);
		}
		{ // pivot.ecore::pivot::Property::isVolatile pivot|Property|isVolatile
			symbol_201.setName("isVolatile");
			symbol_201.setType(symbol_13);  // pivot|Boolean
			
			symbol_201.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_201);
		}
		{ // pivot.ecore::pivot::Property::keys pivot|Property|keys
			symbol_202.setName("keys");
			symbol_202.setType(symbol_189);  // pivot|Property
			symbol_202.setLower(BigInteger.valueOf(0));
			symbol_202.setUpper(BigInteger.valueOf(-1));
			
			symbol_202.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_202);
		}
		{ // pivot.ecore::pivot::Property::opposite pivot|Property|opposite
			symbol_203.setName("opposite");
			symbol_203.setType(symbol_189);  // pivot|Property
			symbol_203.setLower(BigInteger.valueOf(0));
			
			symbol_203.setIsResolveProxies(true);
			symbol_189.getOwnedAttributes().add(symbol_203);
		}
		symbol_1.getOwnedTypes().add(symbol_189);
		//
		// pivot.ecore::pivot::PropertyCallExp pivot|PropertyCallExp
		//
		symbol_204.setName("PropertyCallExp");
		symbol_204.getSuperClasses().add(symbol_150); // pivot|NavigationCallExp
		{ // pivot.ecore::pivot::PropertyCallExp::referredProperty pivot|PropertyCallExp|referredProperty
			symbol_205.setName("referredProperty");
			symbol_205.setType(symbol_189);  // pivot|Property
			symbol_205.setLower(BigInteger.valueOf(0));
			
			symbol_205.setIsResolveProxies(true);
			symbol_204.getOwnedAttributes().add(symbol_205);
		}
		symbol_1.getOwnedTypes().add(symbol_204);
		//
		// pivot.ecore::pivot::RealLiteralExp pivot|RealLiteralExp
		//
		symbol_207.setName("RealLiteralExp");
		symbol_207.getSuperClasses().add(symbol_154); // pivot|NumericLiteralExp
		{ // pivot.ecore::pivot::RealLiteralExp::realSymbol pivot|RealLiteralExp|realSymbol
			symbol_208.setName("realSymbol");
			symbol_208.setType(symbol_206);  // pivot|Real
			
			symbol_208.setIsResolveProxies(true);
			symbol_207.getOwnedAttributes().add(symbol_208);
		}
		symbol_1.getOwnedTypes().add(symbol_207);
		//
		// pivot.ecore::pivot::SelfType pivot|SelfType
		//
		symbol_209.setName("SelfType");
		symbol_209.getSuperClasses().add(symbol_23); // pivot|Class
		symbol_1.getOwnedTypes().add(symbol_209);
		//
		// pivot.ecore::pivot::SendSignalAction pivot|SendSignalAction
		//
		symbol_210.setName("SendSignalAction");
		symbol_210.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::SendSignalAction::signal pivot|SendSignalAction|signal
			symbol_211.setName("signal");
			symbol_211.setType(symbol_214);  // pivot|Signal
			
			symbol_211.setIsResolveProxies(true);
			symbol_210.getOwnedAttributes().add(symbol_211);
		}
		symbol_1.getOwnedTypes().add(symbol_210);
		//
		// pivot.ecore::pivot::SequenceType pivot|SequenceType
		//
		symbol_212.setName("SequenceType");
		symbol_212.getSuperClasses().add(symbol_40); // pivot|CollectionType
		symbol_1.getOwnedTypes().add(symbol_212);
		//
		// pivot.ecore::pivot::SetType pivot|SetType
		//
		symbol_213.setName("SetType");
		symbol_213.getSuperClasses().add(symbol_40); // pivot|CollectionType
		symbol_1.getOwnedTypes().add(symbol_213);
		//
		// pivot.ecore::pivot::Signal pivot|Signal
		//
		symbol_214.setName("Signal");
		symbol_214.getSuperClasses().add(symbol_144); // pivot|NamedElement
		symbol_1.getOwnedTypes().add(symbol_214);
		//
		// pivot.ecore::pivot::State pivot|State
		//
		symbol_215.setName("State");
		symbol_215.getSuperClasses().add(symbol_144); // pivot|NamedElement
		symbol_1.getOwnedTypes().add(symbol_215);
		//
		// pivot.ecore::pivot::StateExp pivot|StateExp
		//
		symbol_216.setName("StateExp");
		symbol_216.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::StateExp::referredState pivot|StateExp|referredState
			symbol_217.setName("referredState");
			symbol_217.setType(symbol_215);  // pivot|State
			symbol_217.setLower(BigInteger.valueOf(0));
			
			symbol_217.setIsResolveProxies(true);
			symbol_216.getOwnedAttributes().add(symbol_217);
		}
		symbol_1.getOwnedTypes().add(symbol_216);
		//
		// pivot.ecore::pivot::StringLiteralExp pivot|StringLiteralExp
		//
		symbol_219.setName("StringLiteralExp");
		symbol_219.getSuperClasses().add(symbol_187); // pivot|PrimitiveLiteralExp
		{ // pivot.ecore::pivot::StringLiteralExp::stringSymbol pivot|StringLiteralExp|stringSymbol
			symbol_220.setName("stringSymbol");
			symbol_220.setType(symbol_218);  // pivot|String
			
			symbol_220.setIsResolveProxies(true);
			symbol_219.getOwnedAttributes().add(symbol_220);
		}
		symbol_1.getOwnedTypes().add(symbol_219);
		//
		// pivot.ecore::pivot::TemplateBinding pivot|TemplateBinding
		//
		symbol_221.setName("TemplateBinding");
		symbol_221.getSuperClasses().add(symbol_79); // pivot|Element
		{ // pivot.ecore::pivot::TemplateBinding::boundElement pivot|TemplateBinding|boundElement
			symbol_222.setName("boundElement");
			symbol_222.setType(symbol_242);  // pivot|TemplateableElement
			
			symbol_222.setIsResolveProxies(true);
			symbol_222.setOpposite(symbol_244);
			symbol_221.getOwnedAttributes().add(symbol_222);
		}
		{ // pivot.ecore::pivot::TemplateBinding::parameterSubstitution pivot|TemplateBinding|parameterSubstitution
			symbol_223.setName("parameterSubstitution");
			symbol_223.setType(symbol_231);  // pivot|TemplateParameterSubstitution
			symbol_223.setLower(BigInteger.valueOf(0));
			symbol_223.setUpper(BigInteger.valueOf(-1));
			
			symbol_223.setIsComposite(true);
			symbol_223.setIsResolveProxies(true);
			symbol_223.setOpposite(symbol_235);
			symbol_221.getOwnedAttributes().add(symbol_223);
		}
		{ // pivot.ecore::pivot::TemplateBinding::signature pivot|TemplateBinding|signature
			symbol_224.setName("signature");
			symbol_224.setType(symbol_238);  // pivot|TemplateSignature
			
			symbol_224.setIsResolveProxies(true);
			symbol_221.getOwnedAttributes().add(symbol_224);
		}
		symbol_1.getOwnedTypes().add(symbol_221);
		//
		// pivot.ecore::pivot::TemplateParameter pivot|TemplateParameter
		//
		symbol_225.setName("TemplateParameter");
		symbol_225.getSuperClasses().add(symbol_79); // pivot|Element
		{ // pivot.ecore::pivot::TemplateParameter::default pivot|TemplateParameter|default
			symbol_226.setName("default");
			symbol_226.setType(symbol_180);  // pivot|ParameterableElement
			symbol_226.setLower(BigInteger.valueOf(0));
			
			symbol_226.setIsResolveProxies(true);
			symbol_225.getOwnedAttributes().add(symbol_226);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedDefault pivot|TemplateParameter|ownedDefault
			symbol_227.setName("ownedDefault");
			symbol_227.setType(symbol_180);  // pivot|ParameterableElement
			symbol_227.setLower(BigInteger.valueOf(0));
			
			symbol_227.setIsComposite(true);
			symbol_227.setIsResolveProxies(true);
			symbol_225.getOwnedAttributes().add(symbol_227);
		}
		{ // pivot.ecore::pivot::TemplateParameter::ownedParameteredElement pivot|TemplateParameter|ownedParameteredElement
			symbol_228.setName("ownedParameteredElement");
			symbol_228.setType(symbol_180);  // pivot|ParameterableElement
			symbol_228.setLower(BigInteger.valueOf(0));
			
			symbol_228.setIsComposite(true);
			symbol_228.setIsResolveProxies(true);
			symbol_228.setOpposite(symbol_181);
			symbol_225.getOwnedAttributes().add(symbol_228);
		}
		{ // pivot.ecore::pivot::TemplateParameter::parameteredElement pivot|TemplateParameter|parameteredElement
			symbol_229.setName("parameteredElement");
			symbol_229.setType(symbol_180);  // pivot|ParameterableElement
			
			symbol_229.setIsResolveProxies(true);
			symbol_229.setOpposite(symbol_182);
			symbol_225.getOwnedAttributes().add(symbol_229);
		}
		{ // pivot.ecore::pivot::TemplateParameter::signature pivot|TemplateParameter|signature
			symbol_230.setName("signature");
			symbol_230.setType(symbol_238);  // pivot|TemplateSignature
			
			symbol_230.setIsResolveProxies(true);
			symbol_230.setOpposite(symbol_239);
			symbol_225.getOwnedAttributes().add(symbol_230);
		}
		symbol_1.getOwnedTypes().add(symbol_225);
		//
		// pivot.ecore::pivot::TemplateParameterSubstitution pivot|TemplateParameterSubstitution
		//
		symbol_231.setName("TemplateParameterSubstitution");
		symbol_231.getSuperClasses().add(symbol_79); // pivot|Element
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::actual pivot|TemplateParameterSubstitution|actual
			symbol_232.setName("actual");
			symbol_232.setType(symbol_180);  // pivot|ParameterableElement
			
			symbol_232.setIsResolveProxies(true);
			symbol_231.getOwnedAttributes().add(symbol_232);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::formal pivot|TemplateParameterSubstitution|formal
			symbol_233.setName("formal");
			symbol_233.setType(symbol_225);  // pivot|TemplateParameter
			
			symbol_233.setIsResolveProxies(true);
			symbol_231.getOwnedAttributes().add(symbol_233);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::ownedActual pivot|TemplateParameterSubstitution|ownedActual
			symbol_234.setName("ownedActual");
			symbol_234.setType(symbol_180);  // pivot|ParameterableElement
			symbol_234.setLower(BigInteger.valueOf(0));
			
			symbol_234.setIsComposite(true);
			symbol_234.setIsResolveProxies(true);
			symbol_231.getOwnedAttributes().add(symbol_234);
		}
		{ // pivot.ecore::pivot::TemplateParameterSubstitution::templateBinding pivot|TemplateParameterSubstitution|templateBinding
			symbol_235.setName("templateBinding");
			symbol_235.setType(symbol_221);  // pivot|TemplateBinding
			
			symbol_235.setIsResolveProxies(true);
			symbol_235.setOpposite(symbol_223);
			symbol_231.getOwnedAttributes().add(symbol_235);
		}
		symbol_1.getOwnedTypes().add(symbol_231);
		//
		// pivot.ecore::pivot::TemplateParameterType pivot|TemplateParameterType
		//
		symbol_236.setName("TemplateParameterType");
		symbol_236.getSuperClasses().add(symbol_251); // pivot|Type
		{ // pivot.ecore::pivot::TemplateParameterType::specification pivot|TemplateParameterType|specification
			symbol_237.setName("specification");
			symbol_237.setType(symbol_218);  // pivot|String
			symbol_237.setLower(BigInteger.valueOf(0));
			
			symbol_237.setIsResolveProxies(true);
			symbol_236.getOwnedAttributes().add(symbol_237);
		}
		symbol_1.getOwnedTypes().add(symbol_236);
		//
		// pivot.ecore::pivot::TemplateSignature pivot|TemplateSignature
		//
		symbol_238.setName("TemplateSignature");
		symbol_238.getSuperClasses().add(symbol_136); // pivot|MonikeredElement
		{ // pivot.ecore::pivot::TemplateSignature::ownedParameter pivot|TemplateSignature|ownedParameter
			symbol_239.setName("ownedParameter");
			symbol_239.setType(symbol_225);  // pivot|TemplateParameter
			symbol_239.setLower(BigInteger.valueOf(0));
			symbol_239.setUpper(BigInteger.valueOf(-1));
			symbol_239.setIsOrdered(true);
			
			symbol_239.setIsComposite(true);
			symbol_239.setIsResolveProxies(true);
			symbol_239.setOpposite(symbol_230);
			symbol_238.getOwnedAttributes().add(symbol_239);
		}
		{ // pivot.ecore::pivot::TemplateSignature::parameter pivot|TemplateSignature|parameter
			symbol_240.setName("parameter");
			symbol_240.setType(symbol_225);  // pivot|TemplateParameter
			symbol_240.setUpper(BigInteger.valueOf(-1));
			symbol_240.setIsOrdered(true);
			
			symbol_240.setIsResolveProxies(true);
			symbol_238.getOwnedAttributes().add(symbol_240);
		}
		{ // pivot.ecore::pivot::TemplateSignature::template pivot|TemplateSignature|template
			symbol_241.setName("template");
			symbol_241.setType(symbol_242);  // pivot|TemplateableElement
			
			symbol_241.setIsResolveProxies(true);
			symbol_241.setOpposite(symbol_243);
			symbol_238.getOwnedAttributes().add(symbol_241);
		}
		symbol_1.getOwnedTypes().add(symbol_238);
		//
		// pivot.ecore::pivot::TemplateableElement pivot|TemplateableElement
		//
		symbol_242.setName("TemplateableElement");
		symbol_242.getSuperClasses().add(symbol_136); // pivot|MonikeredElement
		{ // pivot.ecore::pivot::TemplateableElement::ownedTemplateSignature pivot|TemplateableElement|ownedTemplateSignature
			symbol_243.setName("ownedTemplateSignature");
			symbol_243.setType(symbol_238);  // pivot|TemplateSignature
			symbol_243.setLower(BigInteger.valueOf(0));
			
			symbol_243.setIsComposite(true);
			symbol_243.setIsResolveProxies(true);
			symbol_243.setOpposite(symbol_241);
			symbol_242.getOwnedAttributes().add(symbol_243);
		}
		{ // pivot.ecore::pivot::TemplateableElement::templateBinding pivot|TemplateableElement|templateBinding
			symbol_244.setName("templateBinding");
			symbol_244.setType(symbol_221);  // pivot|TemplateBinding
			symbol_244.setLower(BigInteger.valueOf(0));
			symbol_244.setUpper(BigInteger.valueOf(-1));
			
			symbol_244.setIsComposite(true);
			symbol_244.setIsResolveProxies(true);
			symbol_244.setOpposite(symbol_222);
			symbol_242.getOwnedAttributes().add(symbol_244);
		}
		{	// pivot.ecore::pivot::TemplateableElement::isTemplate() pivot|TemplateableElement|isTemplate()
			Operation symbol_312 = PivotFactory.eINSTANCE.createOperation();
			symbol_312.setName("isTemplate");
			symbol_312.setType(symbol_13);  // pivot|Boolean
			
			symbol_242.getOwnedOperations().add(symbol_312);
		}
		{	// pivot.ecore::pivot::TemplateableElement::parameterableElements() pivot|TemplateableElement|parameterableElements()
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_313.setName("parameterableElements");
			symbol_313.setType(symbol_180);  // pivot|ParameterableElement
			symbol_313.setLower(BigInteger.valueOf(0));
			symbol_313.setUpper(BigInteger.valueOf(-1));
			
			symbol_242.getOwnedOperations().add(symbol_313);
		}
		symbol_1.getOwnedTypes().add(symbol_242);
		//
		// pivot.ecore::pivot::Throwable pivot|Throwable
		//
		symbol_245.setName("Throwable");
		symbol_1.getOwnedTypes().add(symbol_245);
		//
		// pivot.ecore::pivot::TupleLiteralExp pivot|TupleLiteralExp
		//
		symbol_246.setName("TupleLiteralExp");
		symbol_246.getSuperClasses().add(symbol_123); // pivot|LiteralExp
		{ // pivot.ecore::pivot::TupleLiteralExp::part pivot|TupleLiteralExp|part
			symbol_247.setName("part");
			symbol_247.setType(symbol_248);  // pivot|TupleLiteralPart
			symbol_247.setLower(BigInteger.valueOf(0));
			symbol_247.setUpper(BigInteger.valueOf(-1));
			symbol_247.setIsOrdered(true);
			
			symbol_247.setIsComposite(true);
			symbol_247.setIsResolveProxies(true);
			symbol_246.getOwnedAttributes().add(symbol_247);
		}
		symbol_1.getOwnedTypes().add(symbol_246);
		//
		// pivot.ecore::pivot::TupleLiteralPart pivot|TupleLiteralPart
		//
		symbol_248.setName("TupleLiteralPart");
		symbol_248.getSuperClasses().add(symbol_271); // pivot|VariableDeclaration
		{ // pivot.ecore::pivot::TupleLiteralPart::initExpression pivot|TupleLiteralPart|initExpression
			symbol_249.setName("initExpression");
			symbol_249.setType(symbol_156);  // pivot|OclExpression
			symbol_249.setLower(BigInteger.valueOf(0));
			
			symbol_249.setIsComposite(true);
			symbol_249.setIsResolveProxies(true);
			symbol_248.getOwnedAttributes().add(symbol_249);
		}
		symbol_1.getOwnedTypes().add(symbol_248);
		//
		// pivot.ecore::pivot::TupleType pivot|TupleType
		//
		symbol_250.setName("TupleType");
		symbol_250.getSuperClasses().add(symbol_75); // pivot|DataType
		symbol_1.getOwnedTypes().add(symbol_250);
		//
		// pivot.ecore::pivot::Type pivot|Type
		//
		symbol_251.setName("Type");
		symbol_251.getSuperClasses().add(symbol_144); // pivot|NamedElement
		symbol_251.getSuperClasses().add(symbol_242); // pivot|TemplateableElement
		symbol_251.getSuperClasses().add(symbol_180); // pivot|ParameterableElement
		{ // pivot.ecore::pivot::Type::instanceClassName pivot|Type|instanceClassName
			symbol_252.setName("instanceClassName");
			symbol_252.setType(symbol_218);  // pivot|String
			symbol_252.setLower(BigInteger.valueOf(0));
			
			symbol_252.setIsResolveProxies(true);
			symbol_251.getOwnedAttributes().add(symbol_252);
		}
		{ // pivot.ecore::pivot::Type::package pivot|Type|package
			symbol_253.setName("package");
			symbol_253.setType(symbol_170);  // pivot|Package
			symbol_253.setLower(BigInteger.valueOf(0));
			
			symbol_253.setIsResolveProxies(true);
			symbol_253.setOpposite(symbol_176);
			symbol_251.getOwnedAttributes().add(symbol_253);
		}
		symbol_1.getOwnedTypes().add(symbol_251);
		//
		// pivot.ecore::pivot::TypeExp pivot|TypeExp
		//
		symbol_254.setName("TypeExp");
		symbol_254.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::TypeExp::referredType pivot|TypeExp|referredType
			symbol_255.setName("referredType");
			symbol_255.setType(symbol_251);  // pivot|Type
			symbol_255.setLower(BigInteger.valueOf(0));
			
			symbol_255.setIsResolveProxies(true);
			symbol_254.getOwnedAttributes().add(symbol_255);
		}
		symbol_1.getOwnedTypes().add(symbol_254);
		//
		// pivot.ecore::pivot::TypeTemplateParameter pivot|TypeTemplateParameter
		//
		symbol_256.setName("TypeTemplateParameter");
		symbol_256.getSuperClasses().add(symbol_225); // pivot|TemplateParameter
		{ // pivot.ecore::pivot::TypeTemplateParameter::allowSubstitutable pivot|TypeTemplateParameter|allowSubstitutable
			symbol_257.setName("allowSubstitutable");
			symbol_257.setType(symbol_13);  // pivot|Boolean
			
			symbol_257.setIsResolveProxies(true);
			symbol_256.getOwnedAttributes().add(symbol_257);
		}
		{ // pivot.ecore::pivot::TypeTemplateParameter::constrainingType pivot|TypeTemplateParameter|constrainingType
			symbol_258.setName("constrainingType");
			symbol_258.setType(symbol_251);  // pivot|Type
			symbol_258.setLower(BigInteger.valueOf(0));
			symbol_258.setUpper(BigInteger.valueOf(-1));
			
			symbol_258.setIsResolveProxies(true);
			symbol_256.getOwnedAttributes().add(symbol_258);
		}
		symbol_1.getOwnedTypes().add(symbol_256);
		//
		// pivot.ecore::pivot::TypedElement pivot|TypedElement
		//
		symbol_259.setName("TypedElement");
		symbol_259.getSuperClasses().add(symbol_144); // pivot|NamedElement
		{ // pivot.ecore::pivot::TypedElement::type pivot|TypedElement|type
			symbol_260.setName("type");
			symbol_260.setType(symbol_251);  // pivot|Type
			symbol_260.setLower(BigInteger.valueOf(0));
			
			symbol_260.setIsResolveProxies(true);
			symbol_259.getOwnedAttributes().add(symbol_260);
		}
		symbol_1.getOwnedTypes().add(symbol_259);
		//
		// pivot.ecore::pivot::TypedMultiplicityElement pivot|TypedMultiplicityElement
		//
		symbol_261.setName("TypedMultiplicityElement");
		symbol_261.getSuperClasses().add(symbol_259); // pivot|TypedElement
		symbol_261.getSuperClasses().add(symbol_138); // pivot|MultiplicityElement
		symbol_1.getOwnedTypes().add(symbol_261);
		//
		// pivot.ecore::pivot::UnlimitedNaturalLiteralExp pivot|UnlimitedNaturalLiteralExp
		//
		symbol_263.setName("UnlimitedNaturalLiteralExp");
		symbol_263.getSuperClasses().add(symbol_154); // pivot|NumericLiteralExp
		{ // pivot.ecore::pivot::UnlimitedNaturalLiteralExp::unlimitedNaturalSymbol pivot|UnlimitedNaturalLiteralExp|unlimitedNaturalSymbol
			symbol_264.setName("unlimitedNaturalSymbol");
			symbol_264.setType(symbol_262);  // pivot|UnlimitedNatural
			
			symbol_264.setIsResolveProxies(true);
			symbol_263.getOwnedAttributes().add(symbol_264);
		}
		symbol_1.getOwnedTypes().add(symbol_263);
		//
		// pivot.ecore::pivot::UnspecifiedValueExp pivot|UnspecifiedValueExp
		//
		symbol_265.setName("UnspecifiedValueExp");
		symbol_265.getSuperClasses().add(symbol_156); // pivot|OclExpression
		symbol_1.getOwnedTypes().add(symbol_265);
		//
		// pivot.ecore::pivot::ValueSpecification pivot|ValueSpecification
		//
		symbol_266.setName("ValueSpecification");
		symbol_266.getSuperClasses().add(symbol_180); // pivot|ParameterableElement
		symbol_266.getSuperClasses().add(symbol_259); // pivot|TypedElement
		{	// pivot.ecore::pivot::ValueSpecification::booleanValue() pivot|ValueSpecification|booleanValue()
			Operation symbol_314 = PivotFactory.eINSTANCE.createOperation();
			symbol_314.setName("booleanValue");
			symbol_314.setType(symbol_13);  // pivot|Boolean
			
			symbol_266.getOwnedOperations().add(symbol_314);
		}
		{	// pivot.ecore::pivot::ValueSpecification::integerValue() pivot|ValueSpecification|integerValue()
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_315.setName("integerValue");
			symbol_315.setType(symbol_104);  // pivot|Integer
			
			symbol_266.getOwnedOperations().add(symbol_315);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isComputable() pivot|ValueSpecification|isComputable()
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("isComputable");
			symbol_316.setType(symbol_13);  // pivot|Boolean
			
			symbol_266.getOwnedOperations().add(symbol_316);
		}
		{	// pivot.ecore::pivot::ValueSpecification::isNull() pivot|ValueSpecification|isNull()
			Operation symbol_317 = PivotFactory.eINSTANCE.createOperation();
			symbol_317.setName("isNull");
			symbol_317.setType(symbol_13);  // pivot|Boolean
			
			symbol_266.getOwnedOperations().add(symbol_317);
		}
		{	// pivot.ecore::pivot::ValueSpecification::stringValue() pivot|ValueSpecification|stringValue()
			Operation symbol_318 = PivotFactory.eINSTANCE.createOperation();
			symbol_318.setName("stringValue");
			symbol_318.setType(symbol_218);  // pivot|String
			
			symbol_266.getOwnedOperations().add(symbol_318);
		}
		{	// pivot.ecore::pivot::ValueSpecification::unlimitedValue() pivot|ValueSpecification|unlimitedValue()
			Operation symbol_319 = PivotFactory.eINSTANCE.createOperation();
			symbol_319.setName("unlimitedValue");
			symbol_319.setType(symbol_262);  // pivot|UnlimitedNatural
			
			symbol_266.getOwnedOperations().add(symbol_319);
		}
		symbol_1.getOwnedTypes().add(symbol_266);
		//
		// pivot.ecore::pivot::Variable pivot|Variable
		//
		symbol_267.setName("Variable");
		symbol_267.getSuperClasses().add(symbol_271); // pivot|VariableDeclaration
		{ // pivot.ecore::pivot::Variable::implicit pivot|Variable|implicit
			symbol_268.setName("implicit");
			symbol_268.setType(symbol_13);  // pivot|Boolean
			symbol_268.setLower(BigInteger.valueOf(0));
			
			symbol_268.setIsResolveProxies(true);
			symbol_267.getOwnedAttributes().add(symbol_268);
		}
		{ // pivot.ecore::pivot::Variable::initExpression pivot|Variable|initExpression
			symbol_269.setName("initExpression");
			symbol_269.setType(symbol_156);  // pivot|OclExpression
			symbol_269.setLower(BigInteger.valueOf(0));
			
			symbol_269.setIsComposite(true);
			symbol_269.setIsResolveProxies(true);
			symbol_267.getOwnedAttributes().add(symbol_269);
		}
		{ // pivot.ecore::pivot::Variable::representedParameter pivot|Variable|representedParameter
			symbol_270.setName("representedParameter");
			symbol_270.setType(symbol_178);  // pivot|Parameter
			symbol_270.setLower(BigInteger.valueOf(0));
			
			symbol_270.setIsResolveProxies(true);
			symbol_267.getOwnedAttributes().add(symbol_270);
		}
		symbol_1.getOwnedTypes().add(symbol_267);
		//
		// pivot.ecore::pivot::VariableDeclaration pivot|VariableDeclaration
		//
		symbol_271.setName("VariableDeclaration");
		symbol_271.getSuperClasses().add(symbol_259); // pivot|TypedElement
		symbol_1.getOwnedTypes().add(symbol_271);
		//
		// pivot.ecore::pivot::VariableExp pivot|VariableExp
		//
		symbol_272.setName("VariableExp");
		symbol_272.getSuperClasses().add(symbol_156); // pivot|OclExpression
		{ // pivot.ecore::pivot::VariableExp::implicit pivot|VariableExp|implicit
			symbol_273.setName("implicit");
			symbol_273.setType(symbol_13);  // pivot|Boolean
			symbol_273.setLower(BigInteger.valueOf(0));
			
			symbol_273.setIsResolveProxies(true);
			symbol_272.getOwnedAttributes().add(symbol_273);
		}
		{ // pivot.ecore::pivot::VariableExp::referredVariable pivot|VariableExp|referredVariable
			symbol_274.setName("referredVariable");
			symbol_274.setType(symbol_271);  // pivot|VariableDeclaration
			symbol_274.setLower(BigInteger.valueOf(0));
			
			symbol_274.setIsResolveProxies(true);
			symbol_272.getOwnedAttributes().add(symbol_274);
		}
		symbol_1.getOwnedTypes().add(symbol_272);
		//
		// pivot.ecore::pivot::Visitable pivot|Visitable
		//
		symbol_275.setName("Visitable");
		symbol_1.getOwnedTypes().add(symbol_275);
		//
		// pivot.ecore::pivot::Visitor pivot|Visitor{R,C}
		//
		symbol_276.setName("Visitor");
		symbol_279.setName("R");
		symbol_278.setOwnedParameteredElement(symbol_279);
		symbol_277.getOwnedParameters().add(symbol_278);
		symbol_281.setName("C");
		symbol_280.setOwnedParameteredElement(symbol_281);
		symbol_277.getOwnedParameters().add(symbol_280);
		
		symbol_276.setOwnedTemplateSignature(symbol_277);
		symbol_1.getOwnedTypes().add(symbol_276);
		//
		// pivot.ecore::pivot::VoidType pivot|VoidType
		//
		symbol_282.setName("VoidType");
		symbol_282.getSuperClasses().add(symbol_23); // pivot|Class
		symbol_1.getOwnedTypes().add(symbol_282);

		Class elementClass = (Class) PivotUtil.getNamedElement(symbol_1.getOwnedTypes(), "Element");
		elementClass.getSuperClasses().clear();
		elementClass.getSuperClasses().add(standardLibrary.getClassifierType());
		
		return symbol_1;
	}
}
