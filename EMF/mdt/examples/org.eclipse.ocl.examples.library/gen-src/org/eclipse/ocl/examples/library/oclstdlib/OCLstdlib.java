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
 * from: /org.eclipse.ocl.examples.library/model/OCL-2.4.oclstdlib
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateOCLstdlib
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateOCLstdlib.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.OCLstdlibCodeGenerator
 * from: org.eclipse.ocl.examples.build.GenerateOCLstdlibModel.mwe2
 *
 * Do not edit it.
 *
 * $Id: OCLstdlib.java,v 1.3 2011/01/30 11:07:11 ewillink Exp $
 */
package	org.eclipse.ocl.examples.library.oclstdlib;

import java.math.BigInteger;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.ocl.examples.pivot.*;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.utilities.PivotAliasCreator;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * This is the http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib Standard Library
 * auto-generated from /org.eclipse.ocl.examples.library/model/OCL-2.4.oclstdlib.
 * It facilitates efficient library loading without the overheads of model reading.
 * <p>
 * This Standard Library may be registered as the definition of a Standard Library for
 * the OCL evaluation framework by invoking {@link #install}.
 * <p>
 * The Standard Library is normally activated when the TypeManager attempts
 * to locate a library type when its default Standard Library URI is the same
 * as this Standard Library.
 */
@SuppressWarnings("nls")
public class OCLstdlib extends XMLResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Standard Library.
	 */
	public static final OCLstdlib INSTANCE = new OCLstdlib();
	
	/**
	 *	The URI of this Standard Library.
	 */
	public static final String STDLIB_URI = "http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib";

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}.
	 * This method may be invoked by standalone applications to replicate
	 * the registration that should appear as a standard_library plugin
	 * extension when running within Eclipse. 
	 */
	public static void install() {
		StandardLibraryContribution.REGISTRY.put(STDLIB_URI, new Loader());
	}
	
	/**
	 * The Loader shares the Standard Library instance whenever this default library
	 * is loaded from the registry of Standard Libraries populated by the standard_library 
	 * extension point.
	 */
	public static class Loader implements StandardLibraryContribution
	{
		public StandardLibraryContribution getContribution() {
			return this;
		}
		
		public Resource getResource() {
			return INSTANCE;
		}
	}
	
	private OCLstdlib() {
		super(URI.createURI(STDLIB_URI));
		getContents().add(create());
		PivotAliasCreator.refreshPackageAliases(this);
		TypeManager.setMonikerAsID(Collections.singletonList(this));
	}

	/**
	 *	Create and return a package-of-packages-of-types pivot model of the OCL standard library.
	 *  This static definition auto-generated from /org.eclipse.ocl.examples.library/model/OCL-2.4.oclstdlib
	 *  is used as the default when no overriding copy is registered. 
	 */
	public static Library create()
	{
		Library symbol_1 = PivotFactory.eINSTANCE.createLibrary(); // ocl
		Precedence symbol_2 = PivotFactory.eINSTANCE.createPrecedence(); // NAVIGATION
		Precedence symbol_3 = PivotFactory.eINSTANCE.createPrecedence(); // UNARY
		Precedence symbol_4 = PivotFactory.eINSTANCE.createPrecedence(); // MULTIPLICATIVE
		Precedence symbol_5 = PivotFactory.eINSTANCE.createPrecedence(); // ADDITIVE
		Precedence symbol_6 = PivotFactory.eINSTANCE.createPrecedence(); // RELATIONAL
		Precedence symbol_7 = PivotFactory.eINSTANCE.createPrecedence(); // EQUALITY
		Precedence symbol_8 = PivotFactory.eINSTANCE.createPrecedence(); // AND
		Precedence symbol_9 = PivotFactory.eINSTANCE.createPrecedence(); // OR
		Precedence symbol_10 = PivotFactory.eINSTANCE.createPrecedence(); // XOR
		Precedence symbol_11 = PivotFactory.eINSTANCE.createPrecedence(); // IMPLIES
		BagType symbol_12 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag{T}
		TemplateSignature symbol_13 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Bag{T}|
		TypeTemplateParameter symbol_14 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_15 = PivotFactory.eINSTANCE.createClass(); // ocl|Bag{T}?T
		
		TemplateSignature symbol_16 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Bag{T}|flatten{T2}()|
		TypeTemplateParameter symbol_17 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_18 = PivotFactory.eINSTANCE.createClass(); // ocl|Bag{T}|flatten{T2}()?T2
		
		
		PrimitiveType symbol_19 = PivotFactory.eINSTANCE.createPrimitiveType(); // Boolean
		
		Class symbol_20 = PivotFactory.eINSTANCE.createClass(); // ocl|Classifier
		
		CollectionType symbol_21 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection{T}
		TemplateSignature symbol_22 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|
		TypeTemplateParameter symbol_23 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_24 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}?T
		
		TemplateSignature symbol_25 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_26 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_27 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2
		
		TemplateSignature symbol_28 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|flatten{T2}()|
		TypeTemplateParameter symbol_29 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_30 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|flatten{T2}()?T2
		
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)|
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|product{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2
		
		
		Class symbol_40 = PivotFactory.eINSTANCE.createClass(); // ocl|Enumeration
		
		PrimitiveType symbol_41 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_42 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection{T}
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonOrderedCollection{T}|
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl|NonOrderedCollection{T}?T
		
		
		CollectionType symbol_46 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection{T}
		TemplateSignature symbol_47 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonUniqueCollection{T}|
		TypeTemplateParameter symbol_48 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_49 = PivotFactory.eINSTANCE.createClass(); // ocl|NonUniqueCollection{T}?T
		
		
		AnyType symbol_50 = PivotFactory.eINSTANCE.createAnyType(); // ocl|OclAny
		TemplateSignature symbol_51 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclAsType{T}(ocl|Classifier)|
		TypeTemplateParameter symbol_52 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_53 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclAsType{T}(ocl|Classifier)?T
		
		
		InvalidType symbol_54 = PivotFactory.eINSTANCE.createInvalidType(); // ocl|OclInvalid
		
		Class symbol_55 = PivotFactory.eINSTANCE.createClass(); // ocl|OclMessage
		
		SelfType symbol_56 = PivotFactory.eINSTANCE.createSelfType(); // ocl|OclSelf
		
		Class symbol_57 = PivotFactory.eINSTANCE.createClass(); // ocl|OclState
		
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // ocl|OclTuple
		
		VoidType symbol_59 = PivotFactory.eINSTANCE.createVoidType(); // ocl|OclVoid
		
		CollectionType symbol_60 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection{T}
		TemplateSignature symbol_61 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedCollection{T}|
		TypeTemplateParameter symbol_62 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_63 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedCollection{T}?T
		
		
		OrderedSetType symbol_64 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet{T}
		TemplateSignature symbol_65 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedSet{T}|
		TypeTemplateParameter symbol_66 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_67 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedSet{T}?T
		
		
		PrimitiveType symbol_68 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_69 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real|oclAsType{T}(ocl|Classifier)|
		TypeTemplateParameter symbol_70 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_71 = PivotFactory.eINSTANCE.createClass(); // Real|oclAsType{T}(ocl|Classifier)?T
		
		
		SequenceType symbol_72 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence{T}
		TemplateSignature symbol_73 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Sequence{T}|
		TypeTemplateParameter symbol_74 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_75 = PivotFactory.eINSTANCE.createClass(); // ocl|Sequence{T}?T
		
		TemplateSignature symbol_76 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Sequence{T}|flatten{T2}()|
		TypeTemplateParameter symbol_77 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_78 = PivotFactory.eINSTANCE.createClass(); // ocl|Sequence{T}|flatten{T2}()?T2
		
		
		SetType symbol_79 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set{T}
		TemplateSignature symbol_80 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Set{T}|
		TypeTemplateParameter symbol_81 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_82 = PivotFactory.eINSTANCE.createClass(); // ocl|Set{T}?T
		
		TemplateSignature symbol_83 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Set{T}|flatten{T2}()|
		TypeTemplateParameter symbol_84 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_85 = PivotFactory.eINSTANCE.createClass(); // ocl|Set{T}|flatten{T2}()?T2
		
		
		PrimitiveType symbol_86 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_87 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection{T}
		TemplateSignature symbol_88 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|UniqueCollection{T}|
		TypeTemplateParameter symbol_89 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_90 = PivotFactory.eINSTANCE.createClass(); // ocl|UniqueCollection{T}?T
		
		
		PrimitiveType symbol_91 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_92 = PivotFactory.eINSTANCE.createPackage(); // ocl|orphanage
		BagType symbol_93 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|NonOrderedCollection{T}?T]
		
		BagType symbol_94 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Collection{T}?T]
		
		BagType symbol_95 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
		
		BagType symbol_96 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Bag{T}?T]
		
		CollectionType symbol_97 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_98 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_99 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[Boolean]
		
		CollectionType symbol_100 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclAny]
		
		CollectionType symbol_101 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_102 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_103 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_104 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_105 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Set{T}?T]
		
		CollectionType symbol_106 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_107 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclSelf]
		
		CollectionType symbol_108 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclVoid]
		
		CollectionType symbol_109 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Bag{T}?T]
		
		CollectionType symbol_110 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_111 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_112 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
		
		CollectionType symbol_113 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Enumeration]
		
		CollectionType symbol_114 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}?T]
		
		CollectionType symbol_115 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Sequence{T}?T]
		
		CollectionType symbol_116 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_117 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_118 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclInvalid]
		
		CollectionType symbol_119 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_120 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[String]
		
		CollectionType symbol_121 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_122 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclVoid]
		
		CollectionType symbol_123 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[Boolean]
		
		CollectionType symbol_124 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_125 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclSelf]
		
		CollectionType symbol_126 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclInvalid]
		
		CollectionType symbol_127 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		
		CollectionType symbol_128 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_129 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_130 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclAny]
		
		CollectionType symbol_131 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Enumeration]
		
		CollectionType symbol_132 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_133 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_134 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[String]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_140 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_141 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		
		CollectionType symbol_142 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_143 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[String]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		OrderedSetType symbol_152 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|UniqueCollection{T}?T]
		
		OrderedSetType symbol_153 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|OrderedCollection{T}?T]
		
		OrderedSetType symbol_154 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|Collection{T}?T]
		
		OrderedSetType symbol_155 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|OrderedSet{T}?T]
		
		SequenceType symbol_156 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
		
		SequenceType symbol_157 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Collection{T}?T]
		
		SequenceType symbol_158 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[String]
		
		SequenceType symbol_159 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|NonUniqueCollection{T}?T]
		
		SequenceType symbol_160 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Sequence{T}?T]
		
		SequenceType symbol_161 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|OrderedCollection{T}?T]
		
		SetType symbol_162 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclAny]
		
		SetType symbol_163 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		SetType symbol_164 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|NonOrderedCollection{T}?T]
		
		SetType symbol_165 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OrderedSet{T}?T]
		
		SetType symbol_166 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclSelf]
		
		SetType symbol_167 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
		
		SetType symbol_168 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Set{T}?T]
		
		SetType symbol_169 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[Boolean]
		
		SetType symbol_170 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Enumeration]
		
		SetType symbol_171 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclInvalid]
		
		SetType symbol_172 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Collection{T}?T]
		
		SetType symbol_173 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclVoid]
		
		TupleType symbol_174 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}
		Property symbol_175 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::first Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|first
		Property symbol_176 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::second Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|second
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclAny]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclInvalid]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Set{T}?T]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[Boolean]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Enumeration]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclSelf]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclVoid]
		
		

		symbol_1.setName("ocl");
		symbol_1.setNsPrefix("ocl");
		symbol_1.setNsURI("http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib");
		symbol_2.setName("NAVIGATION");
		symbol_2.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_2);
		symbol_3.setName("UNARY");
		symbol_3.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_3);
		symbol_4.setName("MULTIPLICATIVE");
		symbol_4.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_4);
		symbol_5.setName("ADDITIVE");
		symbol_5.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_5);
		symbol_6.setName("RELATIONAL");
		symbol_6.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_6);
		symbol_7.setName("EQUALITY");
		symbol_7.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_7);
		symbol_8.setName("AND");
		symbol_8.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_8);
		symbol_9.setName("OR");
		symbol_9.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_9);
		symbol_10.setName("XOR");
		symbol_10.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_10);
		symbol_11.setName("IMPLIES");
		symbol_11.setAssociativity(AssociativityKind.LEFT);
		symbol_1.getOwnedPrecedences().add(symbol_11);
		//
		// ocl::Bag ocl|Bag{T}
		//
		symbol_12.setName("Bag");
		symbol_12.setElementType(symbol_15);
		symbol_15.setName("T");
		symbol_14.setOwnedParameteredElement(symbol_15);
		symbol_13.getOwnedParameters().add(symbol_14);
		
		symbol_12.setOwnedTemplateSignature(symbol_13);
		symbol_12.getSuperClasses().add(symbol_127); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_137); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		{	// ocl::Bag::<>() ocl|Bag{T}|<>(ocl|OclAny)
			Operation symbol_191 = PivotFactory.eINSTANCE.createOperation();
			symbol_191.setName("<>");
			symbol_191.setType(symbol_19);  // Boolean
			symbol_191.setLower(BigInteger.valueOf(0));
			symbol_191.setIsUnique(false);
			
			Parameter symbol_192 = PivotFactory.eINSTANCE.createParameter();
			symbol_192.setName("object2");
			symbol_192.setType(symbol_50);  // ocl|OclAny
			symbol_192.setLower(BigInteger.valueOf(0));
			symbol_192.setIsUnique(false);
			
			symbol_191.getOwnedParameters().add(symbol_192);
			symbol_191.setPrecedence(symbol_7);
			symbol_191.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_191);
		}
		{	// ocl::Bag::=() ocl|Bag{T}|=(ocl|OclAny)
			Operation symbol_193 = PivotFactory.eINSTANCE.createOperation();
			symbol_193.setName("=");
			symbol_193.setType(symbol_19);  // Boolean
			symbol_193.setLower(BigInteger.valueOf(0));
			symbol_193.setIsUnique(false);
			
			Parameter symbol_194 = PivotFactory.eINSTANCE.createParameter();
			symbol_194.setName("object2");
			symbol_194.setType(symbol_50);  // ocl|OclAny
			symbol_194.setLower(BigInteger.valueOf(0));
			symbol_194.setIsUnique(false);
			
			symbol_193.getOwnedParameters().add(symbol_194);
			symbol_193.setPrecedence(symbol_7);
			symbol_193.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_193);
		}
		{	// ocl::Bag::excluding() ocl|Bag{T}|excluding(ocl|OclAny)
			Operation symbol_195 = PivotFactory.eINSTANCE.createOperation();
			symbol_195.setName("excluding");
			symbol_195.setType(symbol_96);  // ocl|Bag[ocl|Bag{T}?T]
			symbol_195.setLower(BigInteger.valueOf(0));
			symbol_195.setIsUnique(false);
			
			Parameter symbol_196 = PivotFactory.eINSTANCE.createParameter();
			symbol_196.setName("object");
			symbol_196.setType(symbol_50);  // ocl|OclAny
			symbol_196.setLower(BigInteger.valueOf(0));
			symbol_196.setIsUnique(false);
			
			symbol_195.getOwnedParameters().add(symbol_196);
			symbol_195.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_195);
		}
		{	// ocl::Bag::flatten() ocl|Bag{T}|flatten{T2}()
			Operation symbol_197 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_197.setOwnedTemplateSignature(symbol_16);
			symbol_197.setName("flatten");
			symbol_197.setType(symbol_95);  // ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
			symbol_197.setLower(BigInteger.valueOf(0));
			symbol_197.setIsUnique(false);
			
			symbol_197.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_197);
		}
		{	// ocl::Bag::including() ocl|Bag{T}|including(ocl|Bag{T}?T)
			Operation symbol_198 = PivotFactory.eINSTANCE.createOperation();
			symbol_198.setName("including");
			symbol_198.setType(symbol_96);  // ocl|Bag[ocl|Bag{T}?T]
			symbol_198.setLower(BigInteger.valueOf(0));
			symbol_198.setIsUnique(false);
			
			Parameter symbol_199 = PivotFactory.eINSTANCE.createParameter();
			symbol_199.setName("object");
			symbol_199.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_199.setLower(BigInteger.valueOf(0));
			symbol_199.setIsUnique(false);
			
			symbol_198.getOwnedParameters().add(symbol_199);
			symbol_198.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_198);
		}
		{	// ocl::Bag::reject() ocl|Bag{T}|reject(ocl|Bag{T}?T)
			Iteration symbol_200 = PivotFactory.eINSTANCE.createIteration();
			symbol_200.setName("reject");
			symbol_200.setType(symbol_96);  // ocl|Bag[ocl|Bag{T}?T]
			
			Parameter symbol_201 = PivotFactory.eINSTANCE.createParameter();
			symbol_201.setName("i");
			symbol_201.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_200.getOwnedIterators().add(symbol_201);
			symbol_200.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_200);
		}
		{	// ocl::Bag::select() ocl|Bag{T}|select(ocl|Bag{T}?T)
			Iteration symbol_202 = PivotFactory.eINSTANCE.createIteration();
			symbol_202.setName("select");
			symbol_202.setType(symbol_96);  // ocl|Bag[ocl|Bag{T}?T]
			
			Parameter symbol_203 = PivotFactory.eINSTANCE.createParameter();
			symbol_203.setName("i");
			symbol_203.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_202.getOwnedIterators().add(symbol_203);
			symbol_202.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_202);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		symbol_19.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::Boolean::<>() Boolean|<>(ocl|OclAny)
			Operation symbol_204 = PivotFactory.eINSTANCE.createOperation();
			symbol_204.setName("<>");
			symbol_204.setType(symbol_19);  // Boolean
			symbol_204.setLower(BigInteger.valueOf(0));
			symbol_204.setIsUnique(false);
			
			Parameter symbol_205 = PivotFactory.eINSTANCE.createParameter();
			symbol_205.setName("object2");
			symbol_205.setType(symbol_50);  // ocl|OclAny
			symbol_205.setLower(BigInteger.valueOf(0));
			symbol_205.setIsUnique(false);
			
			symbol_204.getOwnedParameters().add(symbol_205);
			symbol_204.setPrecedence(symbol_7);
			symbol_204.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_204);
		}
		{	// ocl::Boolean::=() Boolean|=(ocl|OclAny)
			Operation symbol_206 = PivotFactory.eINSTANCE.createOperation();
			symbol_206.setName("=");
			symbol_206.setType(symbol_19);  // Boolean
			symbol_206.setLower(BigInteger.valueOf(0));
			symbol_206.setIsUnique(false);
			
			Parameter symbol_207 = PivotFactory.eINSTANCE.createParameter();
			symbol_207.setName("object2");
			symbol_207.setType(symbol_50);  // ocl|OclAny
			symbol_207.setLower(BigInteger.valueOf(0));
			symbol_207.setIsUnique(false);
			
			symbol_206.getOwnedParameters().add(symbol_207);
			symbol_206.setPrecedence(symbol_7);
			symbol_206.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_206);
		}
		{	// ocl::Boolean::allInstances() Boolean|allInstances()
			Operation symbol_208 = PivotFactory.eINSTANCE.createOperation();
			symbol_208.setName("allInstances");
			symbol_208.setType(symbol_169);  // ocl|Set[Boolean]
			symbol_208.setLower(BigInteger.valueOf(0));
			symbol_208.setIsUnique(false);
			
			symbol_208.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_208);
		}
		{	// ocl::Boolean::and() Boolean|and(Boolean)
			Operation symbol_209 = PivotFactory.eINSTANCE.createOperation();
			symbol_209.setName("and");
			symbol_209.setType(symbol_19);  // Boolean
			symbol_209.setLower(BigInteger.valueOf(0));
			symbol_209.setIsUnique(false);
			
			Parameter symbol_210 = PivotFactory.eINSTANCE.createParameter();
			symbol_210.setName("b");
			symbol_210.setType(symbol_19);  // Boolean
			symbol_210.setLower(BigInteger.valueOf(0));
			symbol_210.setIsUnique(false);
			
			symbol_209.getOwnedParameters().add(symbol_210);
			symbol_209.setPrecedence(symbol_8);
			symbol_209.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_209);
		}
		{	// ocl::Boolean::implies() Boolean|implies(Boolean)
			Operation symbol_211 = PivotFactory.eINSTANCE.createOperation();
			symbol_211.setName("implies");
			symbol_211.setType(symbol_19);  // Boolean
			symbol_211.setLower(BigInteger.valueOf(0));
			symbol_211.setIsUnique(false);
			
			Parameter symbol_212 = PivotFactory.eINSTANCE.createParameter();
			symbol_212.setName("b");
			symbol_212.setType(symbol_19);  // Boolean
			symbol_212.setLower(BigInteger.valueOf(0));
			symbol_212.setIsUnique(false);
			
			symbol_211.getOwnedParameters().add(symbol_212);
			symbol_211.setPrecedence(symbol_11);
			symbol_211.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_211);
		}
		{	// ocl::Boolean::not() Boolean|not()
			Operation symbol_213 = PivotFactory.eINSTANCE.createOperation();
			symbol_213.setName("not");
			symbol_213.setType(symbol_19);  // Boolean
			symbol_213.setLower(BigInteger.valueOf(0));
			symbol_213.setIsUnique(false);
			
			symbol_213.setPrecedence(symbol_3);
			symbol_213.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_213);
		}
		{	// ocl::Boolean::or() Boolean|or(Boolean)
			Operation symbol_214 = PivotFactory.eINSTANCE.createOperation();
			symbol_214.setName("or");
			symbol_214.setType(symbol_19);  // Boolean
			symbol_214.setLower(BigInteger.valueOf(0));
			symbol_214.setIsUnique(false);
			
			Parameter symbol_215 = PivotFactory.eINSTANCE.createParameter();
			symbol_215.setName("b");
			symbol_215.setType(symbol_19);  // Boolean
			symbol_215.setLower(BigInteger.valueOf(0));
			symbol_215.setIsUnique(false);
			
			symbol_214.getOwnedParameters().add(symbol_215);
			symbol_214.setPrecedence(symbol_9);
			symbol_214.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_214);
		}
		{	// ocl::Boolean::toString() Boolean|toString()
			Operation symbol_216 = PivotFactory.eINSTANCE.createOperation();
			symbol_216.setName("toString");
			symbol_216.setType(symbol_86);  // String
			symbol_216.setLower(BigInteger.valueOf(0));
			symbol_216.setIsUnique(false);
			
			symbol_216.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_216);
		}
		{	// ocl::Boolean::xor() Boolean|xor(Boolean)
			Operation symbol_217 = PivotFactory.eINSTANCE.createOperation();
			symbol_217.setName("xor");
			symbol_217.setType(symbol_19);  // Boolean
			symbol_217.setLower(BigInteger.valueOf(0));
			symbol_217.setIsUnique(false);
			
			Parameter symbol_218 = PivotFactory.eINSTANCE.createParameter();
			symbol_218.setName("b");
			symbol_218.setType(symbol_19);  // Boolean
			symbol_218.setLower(BigInteger.valueOf(0));
			symbol_218.setIsUnique(false);
			
			symbol_217.getOwnedParameters().add(symbol_218);
			symbol_217.setPrecedence(symbol_10);
			symbol_217.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_217);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl|Classifier
		//
		symbol_20.setName("Classifier");
		symbol_20.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::Classifier::allInstances() ocl|Classifier|allInstances()
			Operation symbol_219 = PivotFactory.eINSTANCE.createOperation();
			symbol_219.setName("allInstances");
			symbol_219.setType(symbol_166);  // ocl|Set[ocl|OclSelf]
			symbol_219.setLower(BigInteger.valueOf(0));
			symbol_219.setIsUnique(false);
			
			symbol_219.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_219);
		}
		symbol_1.getOwnedTypes().add(symbol_20);
		//
		// ocl::Collection ocl|Collection{T}
		//
		symbol_21.setName("Collection");
		symbol_21.setElementType(symbol_24);
		symbol_24.setName("T");
		symbol_23.setOwnedParameteredElement(symbol_24);
		symbol_22.getOwnedParameters().add(symbol_23);
		
		symbol_21.setOwnedTemplateSignature(symbol_22);
		symbol_21.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::Collection::<>() ocl|Collection{T}|<>(ocl|OclAny)
			Operation symbol_220 = PivotFactory.eINSTANCE.createOperation();
			symbol_220.setName("<>");
			symbol_220.setType(symbol_19);  // Boolean
			symbol_220.setLower(BigInteger.valueOf(0));
			symbol_220.setIsUnique(false);
			
			Parameter symbol_221 = PivotFactory.eINSTANCE.createParameter();
			symbol_221.setName("object2");
			symbol_221.setType(symbol_50);  // ocl|OclAny
			symbol_221.setLower(BigInteger.valueOf(0));
			symbol_221.setIsUnique(false);
			
			symbol_220.getOwnedParameters().add(symbol_221);
			symbol_220.setPrecedence(symbol_7);
			symbol_220.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_220);
		}
		{	// ocl::Collection::=() ocl|Collection{T}|=(ocl|OclAny)
			Operation symbol_222 = PivotFactory.eINSTANCE.createOperation();
			symbol_222.setName("=");
			symbol_222.setType(symbol_19);  // Boolean
			symbol_222.setLower(BigInteger.valueOf(0));
			symbol_222.setIsUnique(false);
			
			Parameter symbol_223 = PivotFactory.eINSTANCE.createParameter();
			symbol_223.setName("object2");
			symbol_223.setType(symbol_50);  // ocl|OclAny
			symbol_223.setLower(BigInteger.valueOf(0));
			symbol_223.setIsUnique(false);
			
			symbol_222.getOwnedParameters().add(symbol_223);
			symbol_222.setPrecedence(symbol_7);
			symbol_222.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_222);
		}
		{	// ocl::Collection::any() ocl|Collection{T}|any(ocl|Collection{T}?T)
			Iteration symbol_224 = PivotFactory.eINSTANCE.createIteration();
			symbol_224.setName("any");
			symbol_224.setType(symbol_24);  // ocl|Collection{T}?T
			
			Parameter symbol_225 = PivotFactory.eINSTANCE.createParameter();
			symbol_225.setName("i");
			symbol_225.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_224.getOwnedIterators().add(symbol_225);
			symbol_224.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_224);
		}
		{	// ocl::Collection::asBag() ocl|Collection{T}|asBag()
			Operation symbol_226 = PivotFactory.eINSTANCE.createOperation();
			symbol_226.setName("asBag");
			symbol_226.setType(symbol_94);  // ocl|Bag[ocl|Collection{T}?T]
			symbol_226.setLower(BigInteger.valueOf(0));
			symbol_226.setIsUnique(false);
			
			symbol_226.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_226);
		}
		{	// ocl::Collection::asOrderedSet() ocl|Collection{T}|asOrderedSet()
			Operation symbol_227 = PivotFactory.eINSTANCE.createOperation();
			symbol_227.setName("asOrderedSet");
			symbol_227.setType(symbol_154);  // ocl|OrderedSet[ocl|Collection{T}?T]
			symbol_227.setLower(BigInteger.valueOf(0));
			symbol_227.setIsUnique(false);
			
			symbol_227.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_227);
		}
		{	// ocl::Collection::asSequence() ocl|Collection{T}|asSequence()
			Operation symbol_228 = PivotFactory.eINSTANCE.createOperation();
			symbol_228.setName("asSequence");
			symbol_228.setType(symbol_157);  // ocl|Sequence[ocl|Collection{T}?T]
			symbol_228.setLower(BigInteger.valueOf(0));
			symbol_228.setIsUnique(false);
			
			symbol_228.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_228);
		}
		{	// ocl::Collection::asSet() ocl|Collection{T}|asSet()
			Operation symbol_229 = PivotFactory.eINSTANCE.createOperation();
			symbol_229.setName("asSet");
			symbol_229.setType(symbol_172);  // ocl|Set[ocl|Collection{T}?T]
			symbol_229.setLower(BigInteger.valueOf(0));
			symbol_229.setIsUnique(false);
			
			symbol_229.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_229);
		}
		{	// ocl::Collection::collect() ocl|Collection{T}|collect(ocl|Collection{T}?T)
			Iteration symbol_230 = PivotFactory.eINSTANCE.createIteration();
			symbol_230.setName("collect");
			symbol_230.setType(symbol_114);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_231 = PivotFactory.eINSTANCE.createParameter();
			symbol_231.setName("i");
			symbol_231.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_230.getOwnedIterators().add(symbol_231);
			symbol_230.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_230);
		}
		{	// ocl::Collection::collectNested() ocl|Collection{T}|collectNested(ocl|Collection{T}?T)
			Iteration symbol_232 = PivotFactory.eINSTANCE.createIteration();
			symbol_232.setName("collectNested");
			symbol_232.setType(symbol_114);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_233 = PivotFactory.eINSTANCE.createParameter();
			symbol_233.setName("i");
			symbol_233.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_232.getOwnedIterators().add(symbol_233);
			symbol_232.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_232);
		}
		{	// ocl::Collection::count() ocl|Collection{T}|count(ocl|OclAny)
			Operation symbol_234 = PivotFactory.eINSTANCE.createOperation();
			symbol_234.setName("count");
			symbol_234.setType(symbol_41);  // Integer
			symbol_234.setLower(BigInteger.valueOf(0));
			symbol_234.setIsUnique(false);
			
			Parameter symbol_235 = PivotFactory.eINSTANCE.createParameter();
			symbol_235.setName("object");
			symbol_235.setType(symbol_50);  // ocl|OclAny
			symbol_235.setLower(BigInteger.valueOf(0));
			symbol_235.setIsUnique(false);
			
			symbol_234.getOwnedParameters().add(symbol_235);
			symbol_234.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_234);
		}
		{	// ocl::Collection::excludes() ocl|Collection{T}|excludes(ocl|OclAny)
			Operation symbol_236 = PivotFactory.eINSTANCE.createOperation();
			symbol_236.setName("excludes");
			symbol_236.setType(symbol_19);  // Boolean
			symbol_236.setLower(BigInteger.valueOf(0));
			symbol_236.setIsUnique(false);
			
			Parameter symbol_237 = PivotFactory.eINSTANCE.createParameter();
			symbol_237.setName("object");
			symbol_237.setType(symbol_50);  // ocl|OclAny
			symbol_237.setLower(BigInteger.valueOf(0));
			symbol_237.setIsUnique(false);
			
			symbol_236.getOwnedParameters().add(symbol_237);
			symbol_236.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_236);
		}
		{	// ocl::Collection::excludesAll() ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])
			Operation symbol_238 = PivotFactory.eINSTANCE.createOperation();
			symbol_27.setName("T2");
			symbol_26.setOwnedParameteredElement(symbol_27);
			symbol_25.getOwnedParameters().add(symbol_26);
			
			symbol_238.setOwnedTemplateSignature(symbol_25);
			symbol_238.setName("excludesAll");
			symbol_238.setType(symbol_19);  // Boolean
			symbol_238.setLower(BigInteger.valueOf(0));
			symbol_238.setIsUnique(false);
			
			Parameter symbol_239 = PivotFactory.eINSTANCE.createParameter();
			symbol_239.setName("c2");
			symbol_239.setType(symbol_116);  // ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
			symbol_239.setLower(BigInteger.valueOf(0));
			symbol_239.setIsUnique(false);
			
			symbol_238.getOwnedParameters().add(symbol_239);
			symbol_238.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_238);
		}
		{	// ocl::Collection::excluding() ocl|Collection{T}|excluding(ocl|OclAny)
			Operation symbol_240 = PivotFactory.eINSTANCE.createOperation();
			symbol_240.setName("excluding");
			symbol_240.setType(symbol_114);  // ocl|Collection[ocl|Collection{T}?T]
			symbol_240.setLower(BigInteger.valueOf(0));
			symbol_240.setIsUnique(false);
			
			Parameter symbol_241 = PivotFactory.eINSTANCE.createParameter();
			symbol_241.setName("object");
			symbol_241.setType(symbol_50);  // ocl|OclAny
			symbol_241.setLower(BigInteger.valueOf(0));
			symbol_241.setIsUnique(false);
			
			symbol_240.getOwnedParameters().add(symbol_241);
			symbol_240.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_240);
		}
		{	// ocl::Collection::exists() ocl|Collection{T}|exists(ocl|Collection{T}?T)
			Iteration symbol_242 = PivotFactory.eINSTANCE.createIteration();
			symbol_242.setName("exists");
			symbol_242.setType(symbol_19);  // Boolean
			
			Parameter symbol_243 = PivotFactory.eINSTANCE.createParameter();
			symbol_243.setName("i");
			symbol_243.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_242.getOwnedIterators().add(symbol_243);
			symbol_242.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_242);
		}
		{	// ocl::Collection::exists() ocl|Collection{T}|exists(ocl|Collection{T}?T,T)
			Iteration symbol_244 = PivotFactory.eINSTANCE.createIteration();
			symbol_244.setName("exists");
			symbol_244.setType(symbol_19);  // Boolean
			
			Parameter symbol_245 = PivotFactory.eINSTANCE.createParameter();
			symbol_245.setName("i");
			symbol_245.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_244.getOwnedIterators().add(symbol_245);
			Parameter symbol_246 = PivotFactory.eINSTANCE.createParameter();
			symbol_246.setName("j");
			symbol_246.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_244.getOwnedIterators().add(symbol_246);
			symbol_244.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_244);
		}
		{	// ocl::Collection::flatten() ocl|Collection{T}|flatten{T2}()
			Operation symbol_247 = PivotFactory.eINSTANCE.createOperation();
			symbol_30.setName("T2");
			symbol_29.setOwnedParameteredElement(symbol_30);
			symbol_28.getOwnedParameters().add(symbol_29);
			
			symbol_247.setOwnedTemplateSignature(symbol_28);
			symbol_247.setName("flatten");
			symbol_247.setType(symbol_112);  // ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
			symbol_247.setLower(BigInteger.valueOf(0));
			symbol_247.setIsUnique(false);
			
			symbol_247.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_247);
		}
		{	// ocl::Collection::forAll() ocl|Collection{T}|forAll(ocl|Collection{T}?T)
			Iteration symbol_248 = PivotFactory.eINSTANCE.createIteration();
			symbol_248.setName("forAll");
			symbol_248.setType(symbol_19);  // Boolean
			
			Parameter symbol_249 = PivotFactory.eINSTANCE.createParameter();
			symbol_249.setName("i");
			symbol_249.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_248.getOwnedIterators().add(symbol_249);
			symbol_248.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_248);
		}
		{	// ocl::Collection::forAll() ocl|Collection{T}|forAll(ocl|Collection{T}?T,T)
			Iteration symbol_250 = PivotFactory.eINSTANCE.createIteration();
			symbol_250.setName("forAll");
			symbol_250.setType(symbol_19);  // Boolean
			
			Parameter symbol_251 = PivotFactory.eINSTANCE.createParameter();
			symbol_251.setName("j");
			symbol_251.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_250.getOwnedIterators().add(symbol_251);
			Parameter symbol_252 = PivotFactory.eINSTANCE.createParameter();
			symbol_252.setName("i");
			symbol_252.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_250.getOwnedIterators().add(symbol_252);
			symbol_250.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_250);
		}
		{	// ocl::Collection::includes() ocl|Collection{T}|includes(ocl|OclAny)
			Operation symbol_253 = PivotFactory.eINSTANCE.createOperation();
			symbol_253.setName("includes");
			symbol_253.setType(symbol_19);  // Boolean
			symbol_253.setLower(BigInteger.valueOf(0));
			symbol_253.setIsUnique(false);
			
			Parameter symbol_254 = PivotFactory.eINSTANCE.createParameter();
			symbol_254.setName("object");
			symbol_254.setType(symbol_50);  // ocl|OclAny
			symbol_254.setLower(BigInteger.valueOf(0));
			symbol_254.setIsUnique(false);
			
			symbol_253.getOwnedParameters().add(symbol_254);
			symbol_253.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_253);
		}
		{	// ocl::Collection::includesAll() ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])
			Operation symbol_255 = PivotFactory.eINSTANCE.createOperation();
			symbol_33.setName("T2");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_255.setOwnedTemplateSignature(symbol_31);
			symbol_255.setName("includesAll");
			symbol_255.setType(symbol_19);  // Boolean
			symbol_255.setLower(BigInteger.valueOf(0));
			symbol_255.setIsUnique(false);
			
			Parameter symbol_256 = PivotFactory.eINSTANCE.createParameter();
			symbol_256.setName("c2");
			symbol_256.setType(symbol_110);  // ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
			symbol_256.setLower(BigInteger.valueOf(0));
			symbol_256.setIsUnique(false);
			
			symbol_255.getOwnedParameters().add(symbol_256);
			symbol_255.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_255);
		}
		{	// ocl::Collection::including() ocl|Collection{T}|including(ocl|Collection{T}?T)
			Operation symbol_257 = PivotFactory.eINSTANCE.createOperation();
			symbol_257.setName("including");
			symbol_257.setType(symbol_114);  // ocl|Collection[ocl|Collection{T}?T]
			symbol_257.setLower(BigInteger.valueOf(0));
			symbol_257.setIsUnique(false);
			
			Parameter symbol_258 = PivotFactory.eINSTANCE.createParameter();
			symbol_258.setName("object");
			symbol_258.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_258.setLower(BigInteger.valueOf(0));
			symbol_258.setIsUnique(false);
			
			symbol_257.getOwnedParameters().add(symbol_258);
			symbol_257.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_257);
		}
		{	// ocl::Collection::isEmpty() ocl|Collection{T}|isEmpty()
			Operation symbol_259 = PivotFactory.eINSTANCE.createOperation();
			symbol_259.setName("isEmpty");
			symbol_259.setType(symbol_19);  // Boolean
			symbol_259.setLower(BigInteger.valueOf(0));
			symbol_259.setIsUnique(false);
			
			symbol_259.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_259);
		}
		{	// ocl::Collection::isUnique() ocl|Collection{T}|isUnique(ocl|Collection{T}?T)
			Iteration symbol_260 = PivotFactory.eINSTANCE.createIteration();
			symbol_260.setName("isUnique");
			symbol_260.setType(symbol_19);  // Boolean
			
			Parameter symbol_261 = PivotFactory.eINSTANCE.createParameter();
			symbol_261.setName("i");
			symbol_261.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_260.getOwnedIterators().add(symbol_261);
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Collection::iterate() ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)
			Iteration symbol_262 = PivotFactory.eINSTANCE.createIteration();
			symbol_36.setName("Tacc");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_262.setOwnedTemplateSignature(symbol_34);
			symbol_262.setName("iterate");
			symbol_262.setType(symbol_36);  // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
			
			Parameter symbol_263 = PivotFactory.eINSTANCE.createParameter();
			symbol_263.setName("i");
			symbol_263.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_262.getOwnedIterators().add(symbol_263);
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("acc");
			symbol_264.setType(symbol_36);  // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
			symbol_262.getOwnedAccumulators().add(symbol_264);
			symbol_262.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_262);
		}
		{	// ocl::Collection::max() ocl|Collection{T}|max()
			Operation symbol_265 = PivotFactory.eINSTANCE.createOperation();
			symbol_265.setName("max");
			symbol_265.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_265.setLower(BigInteger.valueOf(0));
			symbol_265.setIsUnique(false);
			
			symbol_265.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_265);
		}
		{	// ocl::Collection::min() ocl|Collection{T}|min()
			Operation symbol_266 = PivotFactory.eINSTANCE.createOperation();
			symbol_266.setName("min");
			symbol_266.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_266.setLower(BigInteger.valueOf(0));
			symbol_266.setIsUnique(false);
			
			symbol_266.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_266);
		}
		{	// ocl::Collection::notEmpty() ocl|Collection{T}|notEmpty()
			Operation symbol_267 = PivotFactory.eINSTANCE.createOperation();
			symbol_267.setName("notEmpty");
			symbol_267.setType(symbol_19);  // Boolean
			symbol_267.setLower(BigInteger.valueOf(0));
			symbol_267.setIsUnique(false);
			
			symbol_267.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_267);
		}
		{	// ocl::Collection::one() ocl|Collection{T}|one(ocl|Collection{T}?T)
			Iteration symbol_268 = PivotFactory.eINSTANCE.createIteration();
			symbol_268.setName("one");
			symbol_268.setType(symbol_19);  // Boolean
			
			Parameter symbol_269 = PivotFactory.eINSTANCE.createParameter();
			symbol_269.setName("i");
			symbol_269.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_268.getOwnedIterators().add(symbol_269);
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_268);
		}
		{	// ocl::Collection::product() ocl|Collection{T}|product{T2}(ocl|Collection[T2])
			Operation symbol_270 = PivotFactory.eINSTANCE.createOperation();
			symbol_39.setName("T2");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_270.setOwnedTemplateSignature(symbol_37);
			symbol_270.setName("product");
			symbol_270.setType(symbol_163);  // ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
			symbol_270.setLower(BigInteger.valueOf(0));
			symbol_270.setIsUnique(false);
			
			Parameter symbol_271 = PivotFactory.eINSTANCE.createParameter();
			symbol_271.setName("c2");
			symbol_271.setType(symbol_111);  // ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
			symbol_271.setLower(BigInteger.valueOf(0));
			symbol_271.setIsUnique(false);
			
			symbol_270.getOwnedParameters().add(symbol_271);
			symbol_270.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_270);
		}
		{	// ocl::Collection::reject() ocl|Collection{T}|reject(ocl|Collection{T}?T)
			Iteration symbol_272 = PivotFactory.eINSTANCE.createIteration();
			symbol_272.setName("reject");
			symbol_272.setType(symbol_114);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("i");
			symbol_273.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_272.getOwnedIterators().add(symbol_273);
			symbol_272.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_272);
		}
		{	// ocl::Collection::select() ocl|Collection{T}|select(ocl|Collection{T}?T)
			Iteration symbol_274 = PivotFactory.eINSTANCE.createIteration();
			symbol_274.setName("select");
			symbol_274.setType(symbol_114);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("i");
			symbol_275.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_274.getOwnedIterators().add(symbol_275);
			symbol_274.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_274);
		}
		{	// ocl::Collection::size() ocl|Collection{T}|size()
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("size");
			symbol_276.setType(symbol_41);  // Integer
			symbol_276.setLower(BigInteger.valueOf(0));
			symbol_276.setIsUnique(false);
			
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Collection::sortedBy() ocl|Collection{T}|sortedBy(ocl|Collection{T}?T)
			Iteration symbol_277 = PivotFactory.eINSTANCE.createIteration();
			symbol_277.setName("sortedBy");
			symbol_277.setType(symbol_150);  // ocl|OrderedCollection[ocl|Collection{T}?T]
			
			Parameter symbol_278 = PivotFactory.eINSTANCE.createParameter();
			symbol_278.setName("i");
			symbol_278.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_277.getOwnedIterators().add(symbol_278);
			symbol_277.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_277);
		}
		{	// ocl::Collection::sum() ocl|Collection{T}|sum()
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("sum");
			symbol_279.setType(symbol_24);  // ocl|Collection{T}?T
			symbol_279.setLower(BigInteger.valueOf(0));
			symbol_279.setIsUnique(false);
			
			symbol_279.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_21.getOwnedOperations().add(symbol_279);
		}
		symbol_1.getOwnedTypes().add(symbol_21);
		//
		// ocl::Enumeration ocl|Enumeration
		//
		symbol_40.setName("Enumeration");
		symbol_40.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::Enumeration::allInstances() ocl|Enumeration|allInstances()
			Operation symbol_280 = PivotFactory.eINSTANCE.createOperation();
			symbol_280.setName("allInstances");
			symbol_280.setType(symbol_170);  // ocl|Set[ocl|Enumeration]
			symbol_280.setLower(BigInteger.valueOf(0));
			symbol_280.setIsUnique(false);
			
			symbol_280.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_40.getOwnedOperations().add(symbol_280);
		}
		symbol_1.getOwnedTypes().add(symbol_40);
		//
		// ocl::Integer Integer
		//
		symbol_41.setName("Integer");
		symbol_41.getSuperClasses().add(symbol_68); // Real
		{	// ocl::Integer::*() Integer|*(Integer)
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_281.setName("*");
			symbol_281.setType(symbol_41);  // Integer
			symbol_281.setLower(BigInteger.valueOf(0));
			symbol_281.setIsUnique(false);
			
			Parameter symbol_282 = PivotFactory.eINSTANCE.createParameter();
			symbol_282.setName("i");
			symbol_282.setType(symbol_41);  // Integer
			symbol_282.setLower(BigInteger.valueOf(0));
			symbol_282.setIsUnique(false);
			
			symbol_281.getOwnedParameters().add(symbol_282);
			symbol_281.setPrecedence(symbol_4);
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Integer::+() Integer|+(Integer)
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("+");
			symbol_283.setType(symbol_41);  // Integer
			symbol_283.setLower(BigInteger.valueOf(0));
			symbol_283.setIsUnique(false);
			
			Parameter symbol_284 = PivotFactory.eINSTANCE.createParameter();
			symbol_284.setName("i");
			symbol_284.setType(symbol_41);  // Integer
			symbol_284.setLower(BigInteger.valueOf(0));
			symbol_284.setIsUnique(false);
			
			symbol_283.getOwnedParameters().add(symbol_284);
			symbol_283.setPrecedence(symbol_5);
			symbol_283.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_283);
		}
		{	// ocl::Integer::-() Integer|-()
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("-");
			symbol_285.setType(symbol_41);  // Integer
			symbol_285.setLower(BigInteger.valueOf(0));
			symbol_285.setIsUnique(false);
			
			symbol_285.setPrecedence(symbol_3);
			symbol_285.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_285);
		}
		{	// ocl::Integer::-() Integer|-(Integer)
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_286.setName("-");
			symbol_286.setType(symbol_41);  // Integer
			symbol_286.setLower(BigInteger.valueOf(0));
			symbol_286.setIsUnique(false);
			
			Parameter symbol_287 = PivotFactory.eINSTANCE.createParameter();
			symbol_287.setName("i");
			symbol_287.setType(symbol_41);  // Integer
			symbol_287.setLower(BigInteger.valueOf(0));
			symbol_287.setIsUnique(false);
			
			symbol_286.getOwnedParameters().add(symbol_287);
			symbol_286.setPrecedence(symbol_5);
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Integer::/() Integer|/(Integer)
			Operation symbol_288 = PivotFactory.eINSTANCE.createOperation();
			symbol_288.setName("/");
			symbol_288.setType(symbol_68);  // Real
			symbol_288.setLower(BigInteger.valueOf(0));
			symbol_288.setIsUnique(false);
			
			Parameter symbol_289 = PivotFactory.eINSTANCE.createParameter();
			symbol_289.setName("i");
			symbol_289.setType(symbol_41);  // Integer
			symbol_289.setLower(BigInteger.valueOf(0));
			symbol_289.setIsUnique(false);
			
			symbol_288.getOwnedParameters().add(symbol_289);
			symbol_288.setPrecedence(symbol_4);
			symbol_288.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_288);
		}
		{	// ocl::Integer::abs() Integer|abs()
			Operation symbol_290 = PivotFactory.eINSTANCE.createOperation();
			symbol_290.setName("abs");
			symbol_290.setType(symbol_41);  // Integer
			symbol_290.setLower(BigInteger.valueOf(0));
			symbol_290.setIsUnique(false);
			
			symbol_290.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_290);
		}
		{	// ocl::Integer::div() Integer|div(Integer)
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("div");
			symbol_291.setType(symbol_41);  // Integer
			symbol_291.setLower(BigInteger.valueOf(0));
			symbol_291.setIsUnique(false);
			
			Parameter symbol_292 = PivotFactory.eINSTANCE.createParameter();
			symbol_292.setName("i");
			symbol_292.setType(symbol_41);  // Integer
			symbol_292.setLower(BigInteger.valueOf(0));
			symbol_292.setIsUnique(false);
			
			symbol_291.getOwnedParameters().add(symbol_292);
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Integer::max() Integer|max(Integer)
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("max");
			symbol_293.setType(symbol_41);  // Integer
			symbol_293.setLower(BigInteger.valueOf(0));
			symbol_293.setIsUnique(false);
			
			Parameter symbol_294 = PivotFactory.eINSTANCE.createParameter();
			symbol_294.setName("i");
			symbol_294.setType(symbol_41);  // Integer
			symbol_294.setLower(BigInteger.valueOf(0));
			symbol_294.setIsUnique(false);
			
			symbol_293.getOwnedParameters().add(symbol_294);
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Integer::min() Integer|min(Integer)
			Operation symbol_295 = PivotFactory.eINSTANCE.createOperation();
			symbol_295.setName("min");
			symbol_295.setType(symbol_41);  // Integer
			symbol_295.setLower(BigInteger.valueOf(0));
			symbol_295.setIsUnique(false);
			
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("i");
			symbol_296.setType(symbol_41);  // Integer
			symbol_296.setLower(BigInteger.valueOf(0));
			symbol_296.setIsUnique(false);
			
			symbol_295.getOwnedParameters().add(symbol_296);
			symbol_295.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_295);
		}
		{	// ocl::Integer::mod() Integer|mod(Integer)
			Operation symbol_297 = PivotFactory.eINSTANCE.createOperation();
			symbol_297.setName("mod");
			symbol_297.setType(symbol_41);  // Integer
			symbol_297.setLower(BigInteger.valueOf(0));
			symbol_297.setIsUnique(false);
			
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("i");
			symbol_298.setType(symbol_41);  // Integer
			symbol_298.setLower(BigInteger.valueOf(0));
			symbol_298.setIsUnique(false);
			
			symbol_297.getOwnedParameters().add(symbol_298);
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_297);
		}
		{	// ocl::Integer::toString() Integer|toString()
			Operation symbol_299 = PivotFactory.eINSTANCE.createOperation();
			symbol_299.setName("toString");
			symbol_299.setType(symbol_86);  // String
			symbol_299.setLower(BigInteger.valueOf(0));
			symbol_299.setIsUnique(false);
			
			symbol_299.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_41.getOwnedOperations().add(symbol_299);
		}
		symbol_1.getOwnedTypes().add(symbol_41);
		//
		// ocl::NonOrderedCollection ocl|NonOrderedCollection{T}
		//
		symbol_42.setName("NonOrderedCollection");
		symbol_42.setElementType(symbol_45);
		symbol_45.setName("T");
		symbol_44.setOwnedParameteredElement(symbol_45);
		symbol_43.getOwnedParameters().add(symbol_44);
		
		symbol_42.setOwnedTemplateSignature(symbol_43);
		symbol_42.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl|NonOrderedCollection{T}|closure(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_300 = PivotFactory.eINSTANCE.createIteration();
			symbol_300.setName("closure");
			symbol_300.setType(symbol_164);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_301 = PivotFactory.eINSTANCE.createParameter();
			symbol_301.setName("i");
			symbol_301.setType(symbol_45);  // ocl|NonOrderedCollection{T}?T
			symbol_300.getOwnedIterators().add(symbol_301);
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::NonOrderedCollection::collect() ocl|NonOrderedCollection{T}|collect(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_302 = PivotFactory.eINSTANCE.createIteration();
			symbol_302.setName("collect");
			symbol_302.setType(symbol_93);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_303 = PivotFactory.eINSTANCE.createParameter();
			symbol_303.setName("i");
			symbol_303.setType(symbol_45);  // ocl|NonOrderedCollection{T}?T
			symbol_302.getOwnedIterators().add(symbol_303);
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl|NonOrderedCollection{T}|collectNested(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_304 = PivotFactory.eINSTANCE.createIteration();
			symbol_304.setName("collectNested");
			symbol_304.setType(symbol_93);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("i");
			symbol_305.setType(symbol_45);  // ocl|NonOrderedCollection{T}?T
			symbol_304.getOwnedIterators().add(symbol_305);
			symbol_304.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_304);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl|NonOrderedCollection{T}|intersection(ocl|Bag[ocl|NonOrderedCollection{T}?T])
			Operation symbol_306 = PivotFactory.eINSTANCE.createOperation();
			symbol_306.setName("intersection");
			symbol_306.setType(symbol_93);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_306.setLower(BigInteger.valueOf(0));
			symbol_306.setIsUnique(false);
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("bag");
			symbol_307.setType(symbol_93);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_307.setLower(BigInteger.valueOf(0));
			symbol_307.setIsUnique(false);
			
			symbol_306.getOwnedParameters().add(symbol_307);
			symbol_306.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_306);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl|NonOrderedCollection{T}|intersection(ocl|Set[ocl|NonOrderedCollection{T}?T])
			Operation symbol_308 = PivotFactory.eINSTANCE.createOperation();
			symbol_308.setName("intersection");
			symbol_308.setType(symbol_164);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_308.setLower(BigInteger.valueOf(0));
			symbol_308.setIsUnique(false);
			
			Parameter symbol_309 = PivotFactory.eINSTANCE.createParameter();
			symbol_309.setName("s");
			symbol_309.setType(symbol_164);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_309.setLower(BigInteger.valueOf(0));
			symbol_309.setIsUnique(false);
			
			symbol_308.getOwnedParameters().add(symbol_309);
			symbol_308.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_308);
		}
		{	// ocl::NonOrderedCollection::union() ocl|NonOrderedCollection{T}|union(ocl|Bag[ocl|NonOrderedCollection{T}?T])
			Operation symbol_310 = PivotFactory.eINSTANCE.createOperation();
			symbol_310.setName("union");
			symbol_310.setType(symbol_93);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_310.setLower(BigInteger.valueOf(0));
			symbol_310.setIsUnique(false);
			
			Parameter symbol_311 = PivotFactory.eINSTANCE.createParameter();
			symbol_311.setName("bag");
			symbol_311.setType(symbol_93);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_311.setLower(BigInteger.valueOf(0));
			symbol_311.setIsUnique(false);
			
			symbol_310.getOwnedParameters().add(symbol_311);
			symbol_310.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_310);
		}
		{	// ocl::NonOrderedCollection::union() ocl|NonOrderedCollection{T}|union(ocl|Set[ocl|NonOrderedCollection{T}?T])
			Operation symbol_312 = PivotFactory.eINSTANCE.createOperation();
			symbol_312.setName("union");
			symbol_312.setType(symbol_164);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_312.setLower(BigInteger.valueOf(0));
			symbol_312.setIsUnique(false);
			
			Parameter symbol_313 = PivotFactory.eINSTANCE.createParameter();
			symbol_313.setName("s");
			symbol_313.setType(symbol_164);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_313.setLower(BigInteger.valueOf(0));
			symbol_313.setIsUnique(false);
			
			symbol_312.getOwnedParameters().add(symbol_313);
			symbol_312.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_42.getOwnedOperations().add(symbol_312);
		}
		symbol_1.getOwnedTypes().add(symbol_42);
		//
		// ocl::NonUniqueCollection ocl|NonUniqueCollection{T}
		//
		symbol_46.setName("NonUniqueCollection");
		symbol_46.setElementType(symbol_49);
		symbol_49.setName("T");
		symbol_48.setOwnedParameteredElement(symbol_49);
		symbol_47.getOwnedParameters().add(symbol_48);
		
		symbol_46.setOwnedTemplateSignature(symbol_47);
		symbol_46.getSuperClasses().add(symbol_98); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl|NonUniqueCollection{T}|sortedBy(ocl|NonUniqueCollection{T}?T)
			Iteration symbol_314 = PivotFactory.eINSTANCE.createIteration();
			symbol_314.setName("sortedBy");
			symbol_314.setType(symbol_159);  // ocl|Sequence[ocl|NonUniqueCollection{T}?T]
			
			Parameter symbol_315 = PivotFactory.eINSTANCE.createParameter();
			symbol_315.setName("i");
			symbol_315.setType(symbol_49);  // ocl|NonUniqueCollection{T}?T
			symbol_314.getOwnedIterators().add(symbol_315);
			symbol_314.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_46.getOwnedOperations().add(symbol_314);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// ocl::OclAny ocl|OclAny
		//
		symbol_50.setName("OclAny");
		{	// ocl::OclAny::<>() ocl|OclAny|<>(ocl|OclAny)
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("<>");
			symbol_316.setType(symbol_19);  // Boolean
			symbol_316.setLower(BigInteger.valueOf(0));
			symbol_316.setIsUnique(false);
			
			Parameter symbol_317 = PivotFactory.eINSTANCE.createParameter();
			symbol_317.setName("object2");
			symbol_317.setType(symbol_50);  // ocl|OclAny
			symbol_317.setLower(BigInteger.valueOf(0));
			symbol_317.setIsUnique(false);
			
			symbol_316.getOwnedParameters().add(symbol_317);
			symbol_316.setPrecedence(symbol_7);
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::OclAny::=() ocl|OclAny|=(ocl|OclAny)
			Operation symbol_318 = PivotFactory.eINSTANCE.createOperation();
			symbol_318.setName("=");
			symbol_318.setType(symbol_19);  // Boolean
			symbol_318.setLower(BigInteger.valueOf(0));
			symbol_318.setIsUnique(false);
			
			Parameter symbol_319 = PivotFactory.eINSTANCE.createParameter();
			symbol_319.setName("object2");
			symbol_319.setType(symbol_50);  // ocl|OclAny
			symbol_319.setLower(BigInteger.valueOf(0));
			symbol_319.setIsUnique(false);
			
			symbol_318.getOwnedParameters().add(symbol_319);
			symbol_318.setPrecedence(symbol_7);
			symbol_318.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_318);
		}
		{	// ocl::OclAny::oclAsSet() ocl|OclAny|oclAsSet()
			Operation symbol_320 = PivotFactory.eINSTANCE.createOperation();
			symbol_320.setName("oclAsSet");
			symbol_320.setType(symbol_162);  // ocl|Set[ocl|OclAny]
			symbol_320.setLower(BigInteger.valueOf(0));
			symbol_320.setIsUnique(false);
			
			symbol_320.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_320);
		}
		{	// ocl::OclAny::oclAsType() ocl|OclAny|oclAsType{T}(ocl|Classifier)
			Operation symbol_321 = PivotFactory.eINSTANCE.createOperation();
			symbol_53.setName("T");
			symbol_52.setOwnedParameteredElement(symbol_53);
			symbol_51.getOwnedParameters().add(symbol_52);
			
			symbol_321.setOwnedTemplateSignature(symbol_51);
			symbol_321.setName("oclAsType");
			symbol_321.setType(symbol_53);  // ocl|OclAny|oclAsType{T}(ocl|Classifier)?T
			symbol_321.setLower(BigInteger.valueOf(0));
			symbol_321.setIsUnique(false);
			
			Parameter symbol_322 = PivotFactory.eINSTANCE.createParameter();
			symbol_322.setName("type");
			symbol_322.setType(symbol_20);  // ocl|Classifier
			symbol_322.setLower(BigInteger.valueOf(0));
			symbol_322.setIsUnique(false);
			
			symbol_321.getOwnedParameters().add(symbol_322);
			symbol_321.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_321);
		}
		{	// ocl::OclAny::oclIsInState() ocl|OclAny|oclIsInState(ocl|OclState)
			Operation symbol_323 = PivotFactory.eINSTANCE.createOperation();
			symbol_323.setName("oclIsInState");
			symbol_323.setType(symbol_19);  // Boolean
			symbol_323.setLower(BigInteger.valueOf(0));
			symbol_323.setIsUnique(false);
			
			Parameter symbol_324 = PivotFactory.eINSTANCE.createParameter();
			symbol_324.setName("statespec");
			symbol_324.setType(symbol_57);  // ocl|OclState
			symbol_324.setLower(BigInteger.valueOf(0));
			symbol_324.setIsUnique(false);
			
			symbol_323.getOwnedParameters().add(symbol_324);
			symbol_323.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_323);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl|OclAny|oclIsInvalid()
			Operation symbol_325 = PivotFactory.eINSTANCE.createOperation();
			symbol_325.setName("oclIsInvalid");
			symbol_325.setType(symbol_19);  // Boolean
			symbol_325.setLower(BigInteger.valueOf(0));
			symbol_325.setIsUnique(false);
			
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl|OclAny|oclIsKindOf(ocl|Classifier)
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_326.setName("oclIsKindOf");
			symbol_326.setType(symbol_19);  // Boolean
			symbol_326.setLower(BigInteger.valueOf(0));
			symbol_326.setIsUnique(false);
			
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("type");
			symbol_327.setType(symbol_20);  // ocl|Classifier
			symbol_327.setLower(BigInteger.valueOf(0));
			symbol_327.setIsUnique(false);
			
			symbol_326.getOwnedParameters().add(symbol_327);
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::OclAny::oclIsNew() ocl|OclAny|oclIsNew()
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_328.setName("oclIsNew");
			symbol_328.setType(symbol_19);  // Boolean
			symbol_328.setLower(BigInteger.valueOf(0));
			symbol_328.setIsUnique(false);
			
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl|OclAny|oclIsTypeOf(ocl|Classifier)
			Operation symbol_329 = PivotFactory.eINSTANCE.createOperation();
			symbol_329.setName("oclIsTypeOf");
			symbol_329.setType(symbol_19);  // Boolean
			symbol_329.setLower(BigInteger.valueOf(0));
			symbol_329.setIsUnique(false);
			
			Parameter symbol_330 = PivotFactory.eINSTANCE.createParameter();
			symbol_330.setName("type");
			symbol_330.setType(symbol_20);  // ocl|Classifier
			symbol_330.setLower(BigInteger.valueOf(0));
			symbol_330.setIsUnique(false);
			
			symbol_329.getOwnedParameters().add(symbol_330);
			symbol_329.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_329);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl|OclAny|oclIsUndefined()
			Operation symbol_331 = PivotFactory.eINSTANCE.createOperation();
			symbol_331.setName("oclIsUndefined");
			symbol_331.setType(symbol_19);  // Boolean
			symbol_331.setLower(BigInteger.valueOf(0));
			symbol_331.setIsUnique(false);
			
			symbol_331.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_331);
		}
		{	// ocl::OclAny::oclType() ocl|OclAny|oclType()
			Operation symbol_332 = PivotFactory.eINSTANCE.createOperation();
			symbol_332.setName("oclType");
			symbol_332.setType(symbol_56);  // ocl|OclSelf
			symbol_332.setLower(BigInteger.valueOf(0));
			symbol_332.setIsUnique(false);
			
			symbol_332.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_50.getOwnedOperations().add(symbol_332);
		}
		symbol_1.getOwnedTypes().add(symbol_50);
		//
		// ocl::OclInvalid ocl|OclInvalid
		//
		symbol_54.setName("OclInvalid");
		symbol_54.getSuperClasses().add(symbol_59); // ocl|OclVoid
		{	// ocl::OclInvalid::<>() ocl|OclInvalid|<>(ocl|OclAny)
			Operation symbol_333 = PivotFactory.eINSTANCE.createOperation();
			symbol_333.setName("<>");
			symbol_333.setType(symbol_19);  // Boolean
			symbol_333.setLower(BigInteger.valueOf(0));
			symbol_333.setIsUnique(false);
			
			Parameter symbol_334 = PivotFactory.eINSTANCE.createParameter();
			symbol_334.setName("object2");
			symbol_334.setType(symbol_50);  // ocl|OclAny
			symbol_334.setLower(BigInteger.valueOf(0));
			symbol_334.setIsUnique(false);
			
			symbol_333.getOwnedParameters().add(symbol_334);
			symbol_333.setPrecedence(symbol_7);
			symbol_333.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_333);
		}
		{	// ocl::OclInvalid::=() ocl|OclInvalid|=(ocl|OclAny)
			Operation symbol_335 = PivotFactory.eINSTANCE.createOperation();
			symbol_335.setName("=");
			symbol_335.setType(symbol_19);  // Boolean
			symbol_335.setLower(BigInteger.valueOf(0));
			symbol_335.setIsUnique(false);
			
			Parameter symbol_336 = PivotFactory.eINSTANCE.createParameter();
			symbol_336.setName("object2");
			symbol_336.setType(symbol_50);  // ocl|OclAny
			symbol_336.setLower(BigInteger.valueOf(0));
			symbol_336.setIsUnique(false);
			
			symbol_335.getOwnedParameters().add(symbol_336);
			symbol_335.setPrecedence(symbol_7);
			symbol_335.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_335);
		}
		{	// ocl::OclInvalid::allInstances() ocl|OclInvalid|allInstances()
			Operation symbol_337 = PivotFactory.eINSTANCE.createOperation();
			symbol_337.setName("allInstances");
			symbol_337.setType(symbol_171);  // ocl|Set[ocl|OclInvalid]
			symbol_337.setLower(BigInteger.valueOf(0));
			symbol_337.setIsUnique(false);
			
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::OclInvalid::toString() ocl|OclInvalid|toString()
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("toString");
			symbol_338.setType(symbol_86);  // String
			symbol_338.setLower(BigInteger.valueOf(0));
			symbol_338.setIsUnique(false);
			
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_338);
		}
		symbol_1.getOwnedTypes().add(symbol_54);
		//
		// ocl::OclMessage ocl|OclMessage
		//
		symbol_55.setName("OclMessage");
		symbol_55.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::OclMessage::hasReturned() ocl|OclMessage|hasReturned()
			Operation symbol_339 = PivotFactory.eINSTANCE.createOperation();
			symbol_339.setName("hasReturned");
			symbol_339.setType(symbol_19);  // Boolean
			symbol_339.setLower(BigInteger.valueOf(0));
			symbol_339.setIsUnique(false);
			
			symbol_339.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_339);
		}
		{	// ocl::OclMessage::isOperationCall() ocl|OclMessage|isOperationCall()
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("isOperationCall");
			symbol_340.setType(symbol_19);  // Boolean
			symbol_340.setLower(BigInteger.valueOf(0));
			symbol_340.setIsUnique(false);
			
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_340);
		}
		{	// ocl::OclMessage::isSignalSent() ocl|OclMessage|isSignalSent()
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("isSignalSent");
			symbol_341.setType(symbol_19);  // Boolean
			symbol_341.setLower(BigInteger.valueOf(0));
			symbol_341.setIsUnique(false);
			
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::OclMessage::result() ocl|OclMessage|result()
			Operation symbol_342 = PivotFactory.eINSTANCE.createOperation();
			symbol_342.setName("result");
			symbol_342.setType(symbol_50);  // ocl|OclAny
			symbol_342.setLower(BigInteger.valueOf(0));
			symbol_342.setIsUnique(false);
			
			symbol_342.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_342);
		}
		symbol_1.getOwnedTypes().add(symbol_55);
		//
		// ocl::OclSelf ocl|OclSelf
		//
		symbol_56.setName("OclSelf");
		symbol_56.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_1.getOwnedTypes().add(symbol_56);
		//
		// ocl::OclState ocl|OclState
		//
		symbol_57.setName("OclState");
		symbol_57.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_1.getOwnedTypes().add(symbol_57);
		//
		// ocl::OclTuple ocl|OclTuple
		//
		symbol_58.setName("OclTuple");
		symbol_58.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::OclTuple::<>() ocl|OclTuple|<>(ocl|OclAny)
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_343.setName("<>");
			symbol_343.setType(symbol_19);  // Boolean
			symbol_343.setLower(BigInteger.valueOf(0));
			symbol_343.setIsUnique(false);
			
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("object2");
			symbol_344.setType(symbol_50);  // ocl|OclAny
			symbol_344.setLower(BigInteger.valueOf(0));
			symbol_344.setIsUnique(false);
			
			symbol_343.getOwnedParameters().add(symbol_344);
			symbol_343.setPrecedence(symbol_7);
			symbol_343.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_58.getOwnedOperations().add(symbol_343);
		}
		{	// ocl::OclTuple::=() ocl|OclTuple|=(ocl|OclAny)
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_345.setName("=");
			symbol_345.setType(symbol_19);  // Boolean
			symbol_345.setLower(BigInteger.valueOf(0));
			symbol_345.setIsUnique(false);
			
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("object2");
			symbol_346.setType(symbol_50);  // ocl|OclAny
			symbol_346.setLower(BigInteger.valueOf(0));
			symbol_346.setIsUnique(false);
			
			symbol_345.getOwnedParameters().add(symbol_346);
			symbol_345.setPrecedence(symbol_7);
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_58.getOwnedOperations().add(symbol_345);
		}
		symbol_1.getOwnedTypes().add(symbol_58);
		//
		// ocl::OclVoid ocl|OclVoid
		//
		symbol_59.setName("OclVoid");
		symbol_59.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::OclVoid::<>() ocl|OclVoid|<>(ocl|OclAny)
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("<>");
			symbol_347.setType(symbol_19);  // Boolean
			symbol_347.setLower(BigInteger.valueOf(0));
			symbol_347.setIsUnique(false);
			
			Parameter symbol_348 = PivotFactory.eINSTANCE.createParameter();
			symbol_348.setName("object2");
			symbol_348.setType(symbol_50);  // ocl|OclAny
			symbol_348.setLower(BigInteger.valueOf(0));
			symbol_348.setIsUnique(false);
			
			symbol_347.getOwnedParameters().add(symbol_348);
			symbol_347.setPrecedence(symbol_7);
			symbol_347.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_347);
		}
		{	// ocl::OclVoid::=() ocl|OclVoid|=(ocl|OclAny)
			Operation symbol_349 = PivotFactory.eINSTANCE.createOperation();
			symbol_349.setName("=");
			symbol_349.setType(symbol_19);  // Boolean
			symbol_349.setLower(BigInteger.valueOf(0));
			symbol_349.setIsUnique(false);
			
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("object2");
			symbol_350.setType(symbol_50);  // ocl|OclAny
			symbol_350.setLower(BigInteger.valueOf(0));
			symbol_350.setIsUnique(false);
			
			symbol_349.getOwnedParameters().add(symbol_350);
			symbol_349.setPrecedence(symbol_7);
			symbol_349.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_349);
		}
		{	// ocl::OclVoid::allInstances() ocl|OclVoid|allInstances()
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_351.setName("allInstances");
			symbol_351.setType(symbol_173);  // ocl|Set[ocl|OclVoid]
			symbol_351.setLower(BigInteger.valueOf(0));
			symbol_351.setIsUnique(false);
			
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::OclVoid::and() ocl|OclVoid|and(Boolean)
			Operation symbol_352 = PivotFactory.eINSTANCE.createOperation();
			symbol_352.setName("and");
			symbol_352.setType(symbol_19);  // Boolean
			symbol_352.setLower(BigInteger.valueOf(0));
			symbol_352.setIsUnique(false);
			
			Parameter symbol_353 = PivotFactory.eINSTANCE.createParameter();
			symbol_353.setName("b");
			symbol_353.setType(symbol_19);  // Boolean
			symbol_353.setLower(BigInteger.valueOf(0));
			symbol_353.setIsUnique(false);
			
			symbol_352.getOwnedParameters().add(symbol_353);
			symbol_352.setPrecedence(symbol_8);
			symbol_352.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_352);
		}
		{	// ocl::OclVoid::implies() ocl|OclVoid|implies(Boolean)
			Operation symbol_354 = PivotFactory.eINSTANCE.createOperation();
			symbol_354.setName("implies");
			symbol_354.setType(symbol_19);  // Boolean
			symbol_354.setLower(BigInteger.valueOf(0));
			symbol_354.setIsUnique(false);
			
			Parameter symbol_355 = PivotFactory.eINSTANCE.createParameter();
			symbol_355.setName("b");
			symbol_355.setType(symbol_19);  // Boolean
			symbol_355.setLower(BigInteger.valueOf(0));
			symbol_355.setIsUnique(false);
			
			symbol_354.getOwnedParameters().add(symbol_355);
			symbol_354.setPrecedence(symbol_11);
			symbol_354.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_354);
		}
		{	// ocl::OclVoid::or() ocl|OclVoid|or(Boolean)
			Operation symbol_356 = PivotFactory.eINSTANCE.createOperation();
			symbol_356.setName("or");
			symbol_356.setType(symbol_19);  // Boolean
			symbol_356.setLower(BigInteger.valueOf(0));
			symbol_356.setIsUnique(false);
			
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("b");
			symbol_357.setType(symbol_19);  // Boolean
			symbol_357.setLower(BigInteger.valueOf(0));
			symbol_357.setIsUnique(false);
			
			symbol_356.getOwnedParameters().add(symbol_357);
			symbol_356.setPrecedence(symbol_9);
			symbol_356.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_356);
		}
		{	// ocl::OclVoid::toString() ocl|OclVoid|toString()
			Operation symbol_358 = PivotFactory.eINSTANCE.createOperation();
			symbol_358.setName("toString");
			symbol_358.setType(symbol_86);  // String
			symbol_358.setLower(BigInteger.valueOf(0));
			symbol_358.setIsUnique(false);
			
			symbol_358.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_358);
		}
		symbol_1.getOwnedTypes().add(symbol_59);
		//
		// ocl::OrderedCollection ocl|OrderedCollection{T}
		//
		symbol_60.setName("OrderedCollection");
		symbol_60.setElementType(symbol_63);
		symbol_63.setName("T");
		symbol_62.setOwnedParameteredElement(symbol_63);
		symbol_61.getOwnedParameters().add(symbol_62);
		
		symbol_60.setOwnedTemplateSignature(symbol_61);
		symbol_60.getSuperClasses().add(symbol_106); // ocl|Collection[ocl|OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl|OrderedCollection{T}|at(Integer)
			Operation symbol_359 = PivotFactory.eINSTANCE.createOperation();
			symbol_359.setName("at");
			symbol_359.setType(symbol_63);  // ocl|OrderedCollection{T}?T
			symbol_359.setLower(BigInteger.valueOf(0));
			symbol_359.setIsUnique(false);
			
			Parameter symbol_360 = PivotFactory.eINSTANCE.createParameter();
			symbol_360.setName("index");
			symbol_360.setType(symbol_41);  // Integer
			symbol_360.setLower(BigInteger.valueOf(0));
			symbol_360.setIsUnique(false);
			
			symbol_359.getOwnedParameters().add(symbol_360);
			symbol_359.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_359);
		}
		{	// ocl::OrderedCollection::closure() ocl|OrderedCollection{T}|closure(ocl|OrderedCollection{T}?T)
			Iteration symbol_361 = PivotFactory.eINSTANCE.createIteration();
			symbol_361.setName("closure");
			symbol_361.setType(symbol_153);  // ocl|OrderedSet[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("i");
			symbol_362.setType(symbol_63);  // ocl|OrderedCollection{T}?T
			symbol_361.getOwnedIterators().add(symbol_362);
			symbol_361.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_361);
		}
		{	// ocl::OrderedCollection::collect() ocl|OrderedCollection{T}|collect(ocl|OrderedCollection{T}?T)
			Iteration symbol_363 = PivotFactory.eINSTANCE.createIteration();
			symbol_363.setName("collect");
			symbol_363.setType(symbol_161);  // ocl|Sequence[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_364 = PivotFactory.eINSTANCE.createParameter();
			symbol_364.setName("i");
			symbol_364.setType(symbol_63);  // ocl|OrderedCollection{T}?T
			symbol_363.getOwnedIterators().add(symbol_364);
			symbol_363.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_363);
		}
		{	// ocl::OrderedCollection::collectNested() ocl|OrderedCollection{T}|collectNested(ocl|OrderedCollection{T}?T)
			Iteration symbol_365 = PivotFactory.eINSTANCE.createIteration();
			symbol_365.setName("collectNested");
			symbol_365.setType(symbol_161);  // ocl|Sequence[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_366 = PivotFactory.eINSTANCE.createParameter();
			symbol_366.setName("i");
			symbol_366.setType(symbol_63);  // ocl|OrderedCollection{T}?T
			symbol_365.getOwnedIterators().add(symbol_366);
			symbol_365.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_365);
		}
		{	// ocl::OrderedCollection::first() ocl|OrderedCollection{T}|first()
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_367.setName("first");
			symbol_367.setType(symbol_63);  // ocl|OrderedCollection{T}?T
			symbol_367.setLower(BigInteger.valueOf(0));
			symbol_367.setIsUnique(false);
			
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::OrderedCollection::indexOf() ocl|OrderedCollection{T}|indexOf(ocl|OclAny)
			Operation symbol_368 = PivotFactory.eINSTANCE.createOperation();
			symbol_368.setName("indexOf");
			symbol_368.setType(symbol_41);  // Integer
			symbol_368.setLower(BigInteger.valueOf(0));
			symbol_368.setIsUnique(false);
			
			Parameter symbol_369 = PivotFactory.eINSTANCE.createParameter();
			symbol_369.setName("obj");
			symbol_369.setType(symbol_50);  // ocl|OclAny
			symbol_369.setLower(BigInteger.valueOf(0));
			symbol_369.setIsUnique(false);
			
			symbol_368.getOwnedParameters().add(symbol_369);
			symbol_368.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_368);
		}
		{	// ocl::OrderedCollection::last() ocl|OrderedCollection{T}|last()
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_370.setName("last");
			symbol_370.setType(symbol_63);  // ocl|OrderedCollection{T}?T
			symbol_370.setLower(BigInteger.valueOf(0));
			symbol_370.setIsUnique(false);
			
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_370);
		}
		{	// ocl::OrderedCollection::reverse() ocl|OrderedCollection{T}|reverse()
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("reverse");
			symbol_371.setType(symbol_146);  // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
			symbol_371.setLower(BigInteger.valueOf(0));
			symbol_371.setIsUnique(false);
			
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_371);
		}
		symbol_1.getOwnedTypes().add(symbol_60);
		//
		// ocl::OrderedSet ocl|OrderedSet{T}
		//
		symbol_64.setName("OrderedSet");
		symbol_64.setElementType(symbol_67);
		symbol_67.setName("T");
		symbol_66.setOwnedParameteredElement(symbol_67);
		symbol_65.getOwnedParameters().add(symbol_66);
		
		symbol_64.setOwnedTemplateSignature(symbol_65);
		symbol_64.getSuperClasses().add(symbol_144); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		symbol_64.getSuperClasses().add(symbol_181); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl|OrderedSet{T}|-(ocl|Set[ocl|OclAny])
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_372.setName("-");
			symbol_372.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_372.setLower(BigInteger.valueOf(0));
			symbol_372.setIsUnique(false);
			
			Parameter symbol_373 = PivotFactory.eINSTANCE.createParameter();
			symbol_373.setName("s");
			symbol_373.setType(symbol_162);  // ocl|Set[ocl|OclAny]
			symbol_373.setLower(BigInteger.valueOf(0));
			symbol_373.setIsUnique(false);
			
			symbol_372.getOwnedParameters().add(symbol_373);
			symbol_372.setPrecedence(symbol_5);
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::OrderedSet::<>() ocl|OrderedSet{T}|<>(ocl|OclAny)
			Operation symbol_374 = PivotFactory.eINSTANCE.createOperation();
			symbol_374.setName("<>");
			symbol_374.setType(symbol_19);  // Boolean
			symbol_374.setLower(BigInteger.valueOf(0));
			symbol_374.setIsUnique(false);
			
			Parameter symbol_375 = PivotFactory.eINSTANCE.createParameter();
			symbol_375.setName("object2");
			symbol_375.setType(symbol_50);  // ocl|OclAny
			symbol_375.setLower(BigInteger.valueOf(0));
			symbol_375.setIsUnique(false);
			
			symbol_374.getOwnedParameters().add(symbol_375);
			symbol_374.setPrecedence(symbol_7);
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::OrderedSet::=() ocl|OrderedSet{T}|=(ocl|OclAny)
			Operation symbol_376 = PivotFactory.eINSTANCE.createOperation();
			symbol_376.setName("=");
			symbol_376.setType(symbol_19);  // Boolean
			symbol_376.setLower(BigInteger.valueOf(0));
			symbol_376.setIsUnique(false);
			
			Parameter symbol_377 = PivotFactory.eINSTANCE.createParameter();
			symbol_377.setName("object2");
			symbol_377.setType(symbol_50);  // ocl|OclAny
			symbol_377.setLower(BigInteger.valueOf(0));
			symbol_377.setIsUnique(false);
			
			symbol_376.getOwnedParameters().add(symbol_377);
			symbol_376.setPrecedence(symbol_7);
			symbol_376.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_376);
		}
		{	// ocl::OrderedSet::append() ocl|OrderedSet{T}|append(ocl|OrderedSet{T}?T)
			Operation symbol_378 = PivotFactory.eINSTANCE.createOperation();
			symbol_378.setName("append");
			symbol_378.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_378.setLower(BigInteger.valueOf(0));
			symbol_378.setIsUnique(false);
			
			Parameter symbol_379 = PivotFactory.eINSTANCE.createParameter();
			symbol_379.setName("object");
			symbol_379.setType(symbol_67);  // ocl|OrderedSet{T}?T
			symbol_379.setLower(BigInteger.valueOf(0));
			symbol_379.setIsUnique(false);
			
			symbol_378.getOwnedParameters().add(symbol_379);
			symbol_378.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_378);
		}
		{	// ocl::OrderedSet::excluding() ocl|OrderedSet{T}|excluding(ocl|OclAny)
			Operation symbol_380 = PivotFactory.eINSTANCE.createOperation();
			symbol_380.setName("excluding");
			symbol_380.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_380.setLower(BigInteger.valueOf(0));
			symbol_380.setIsUnique(false);
			
			Parameter symbol_381 = PivotFactory.eINSTANCE.createParameter();
			symbol_381.setName("object");
			symbol_381.setType(symbol_50);  // ocl|OclAny
			symbol_381.setLower(BigInteger.valueOf(0));
			symbol_381.setIsUnique(false);
			
			symbol_380.getOwnedParameters().add(symbol_381);
			symbol_380.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_380);
		}
		{	// ocl::OrderedSet::including() ocl|OrderedSet{T}|including(ocl|OrderedSet{T}?T)
			Operation symbol_382 = PivotFactory.eINSTANCE.createOperation();
			symbol_382.setName("including");
			symbol_382.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_382.setLower(BigInteger.valueOf(0));
			symbol_382.setIsUnique(false);
			
			Parameter symbol_383 = PivotFactory.eINSTANCE.createParameter();
			symbol_383.setName("object");
			symbol_383.setType(symbol_67);  // ocl|OrderedSet{T}?T
			symbol_383.setLower(BigInteger.valueOf(0));
			symbol_383.setIsUnique(false);
			
			symbol_382.getOwnedParameters().add(symbol_383);
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_382);
		}
		{	// ocl::OrderedSet::insertAt() ocl|OrderedSet{T}|insertAt(Integer,ocl|OrderedSet{T}?T)
			Operation symbol_384 = PivotFactory.eINSTANCE.createOperation();
			symbol_384.setName("insertAt");
			symbol_384.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_384.setLower(BigInteger.valueOf(0));
			symbol_384.setIsUnique(false);
			
			Parameter symbol_385 = PivotFactory.eINSTANCE.createParameter();
			symbol_385.setName("index");
			symbol_385.setType(symbol_41);  // Integer
			symbol_385.setLower(BigInteger.valueOf(0));
			symbol_385.setIsUnique(false);
			
			symbol_384.getOwnedParameters().add(symbol_385);
			Parameter symbol_386 = PivotFactory.eINSTANCE.createParameter();
			symbol_386.setName("object");
			symbol_386.setType(symbol_67);  // ocl|OrderedSet{T}?T
			symbol_386.setLower(BigInteger.valueOf(0));
			symbol_386.setIsUnique(false);
			
			symbol_384.getOwnedParameters().add(symbol_386);
			symbol_384.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_384);
		}
		{	// ocl::OrderedSet::intersection() ocl|OrderedSet{T}|intersection(ocl|Set[ocl|OrderedSet{T}?T])
			Operation symbol_387 = PivotFactory.eINSTANCE.createOperation();
			symbol_387.setName("intersection");
			symbol_387.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_387.setLower(BigInteger.valueOf(0));
			symbol_387.setIsUnique(false);
			
			Parameter symbol_388 = PivotFactory.eINSTANCE.createParameter();
			symbol_388.setName("o");
			symbol_388.setType(symbol_165);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_388.setLower(BigInteger.valueOf(0));
			symbol_388.setIsUnique(false);
			
			symbol_387.getOwnedParameters().add(symbol_388);
			symbol_387.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_387);
		}
		{	// ocl::OrderedSet::prepend() ocl|OrderedSet{T}|prepend(ocl|OrderedSet{T}?T)
			Operation symbol_389 = PivotFactory.eINSTANCE.createOperation();
			symbol_389.setName("prepend");
			symbol_389.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_389.setLower(BigInteger.valueOf(0));
			symbol_389.setIsUnique(false);
			
			Parameter symbol_390 = PivotFactory.eINSTANCE.createParameter();
			symbol_390.setName("object");
			symbol_390.setType(symbol_67);  // ocl|OrderedSet{T}?T
			symbol_390.setLower(BigInteger.valueOf(0));
			symbol_390.setIsUnique(false);
			
			symbol_389.getOwnedParameters().add(symbol_390);
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_389);
		}
		{	// ocl::OrderedSet::reject() ocl|OrderedSet{T}|reject(ocl|OrderedSet{T}?T)
			Iteration symbol_391 = PivotFactory.eINSTANCE.createIteration();
			symbol_391.setName("reject");
			symbol_391.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("i");
			symbol_392.setType(symbol_67);  // ocl|OrderedSet{T}?T
			symbol_391.getOwnedIterators().add(symbol_392);
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::OrderedSet::reverse() ocl|OrderedSet{T}|reverse()
			Operation symbol_393 = PivotFactory.eINSTANCE.createOperation();
			symbol_393.setName("reverse");
			symbol_393.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_393.setLower(BigInteger.valueOf(0));
			symbol_393.setIsUnique(false);
			
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_393);
		}
		{	// ocl::OrderedSet::select() ocl|OrderedSet{T}|select(ocl|OrderedSet{T}?T)
			Iteration symbol_394 = PivotFactory.eINSTANCE.createIteration();
			symbol_394.setName("select");
			symbol_394.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			
			Parameter symbol_395 = PivotFactory.eINSTANCE.createParameter();
			symbol_395.setName("i");
			symbol_395.setType(symbol_67);  // ocl|OrderedSet{T}?T
			symbol_394.getOwnedIterators().add(symbol_395);
			symbol_394.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_394);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl|OrderedSet{T}|subOrderedSet(Integer,Integer)
			Operation symbol_396 = PivotFactory.eINSTANCE.createOperation();
			symbol_396.setName("subOrderedSet");
			symbol_396.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_396.setLower(BigInteger.valueOf(0));
			symbol_396.setIsUnique(false);
			
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("lower");
			symbol_397.setType(symbol_41);  // Integer
			symbol_397.setLower(BigInteger.valueOf(0));
			symbol_397.setIsUnique(false);
			
			symbol_396.getOwnedParameters().add(symbol_397);
			Parameter symbol_398 = PivotFactory.eINSTANCE.createParameter();
			symbol_398.setName("upper");
			symbol_398.setType(symbol_41);  // Integer
			symbol_398.setLower(BigInteger.valueOf(0));
			symbol_398.setIsUnique(false);
			
			symbol_396.getOwnedParameters().add(symbol_398);
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_396);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl|OrderedSet{T}|symmetricDifference(ocl|Set[ocl|OclAny])
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("symmetricDifference");
			symbol_399.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_399.setLower(BigInteger.valueOf(0));
			symbol_399.setIsUnique(false);
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("s");
			symbol_400.setType(symbol_162);  // ocl|Set[ocl|OclAny]
			symbol_400.setLower(BigInteger.valueOf(0));
			symbol_400.setIsUnique(false);
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_399);
		}
		{	// ocl::OrderedSet::union() ocl|OrderedSet{T}|union(ocl|OrderedSet[ocl|OrderedSet{T}?T])
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("union");
			symbol_401.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_401.setLower(BigInteger.valueOf(0));
			symbol_401.setIsUnique(false);
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("o");
			symbol_402.setType(symbol_155);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_402.setLower(BigInteger.valueOf(0));
			symbol_402.setIsUnique(false);
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OrderedSet::union() ocl|OrderedSet{T}|union(ocl|Set[ocl|OrderedSet{T}?T])
			Operation symbol_403 = PivotFactory.eINSTANCE.createOperation();
			symbol_403.setName("union");
			symbol_403.setType(symbol_165);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_403.setLower(BigInteger.valueOf(0));
			symbol_403.setIsUnique(false);
			
			Parameter symbol_404 = PivotFactory.eINSTANCE.createParameter();
			symbol_404.setName("s");
			symbol_404.setType(symbol_165);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_404.setLower(BigInteger.valueOf(0));
			symbol_404.setIsUnique(false);
			
			symbol_403.getOwnedParameters().add(symbol_404);
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_403);
		}
		symbol_1.getOwnedTypes().add(symbol_64);
		//
		// ocl::Real Real
		//
		symbol_68.setName("Real");
		symbol_68.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::Real::*() Real|*(Real)
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("*");
			symbol_405.setType(symbol_68);  // Real
			symbol_405.setLower(BigInteger.valueOf(0));
			symbol_405.setIsUnique(false);
			
			Parameter symbol_406 = PivotFactory.eINSTANCE.createParameter();
			symbol_406.setName("r");
			symbol_406.setType(symbol_68);  // Real
			symbol_406.setLower(BigInteger.valueOf(0));
			symbol_406.setIsUnique(false);
			
			symbol_405.getOwnedParameters().add(symbol_406);
			symbol_405.setPrecedence(symbol_4);
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_405);
		}
		{	// ocl::Real::+() Real|+(Real)
			Operation symbol_407 = PivotFactory.eINSTANCE.createOperation();
			symbol_407.setName("+");
			symbol_407.setType(symbol_68);  // Real
			symbol_407.setLower(BigInteger.valueOf(0));
			symbol_407.setIsUnique(false);
			
			Parameter symbol_408 = PivotFactory.eINSTANCE.createParameter();
			symbol_408.setName("r");
			symbol_408.setType(symbol_68);  // Real
			symbol_408.setLower(BigInteger.valueOf(0));
			symbol_408.setIsUnique(false);
			
			symbol_407.getOwnedParameters().add(symbol_408);
			symbol_407.setPrecedence(symbol_5);
			symbol_407.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_407);
		}
		{	// ocl::Real::-() Real|-(Real)
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_409.setName("-");
			symbol_409.setType(symbol_68);  // Real
			symbol_409.setLower(BigInteger.valueOf(0));
			symbol_409.setIsUnique(false);
			
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("r");
			symbol_410.setType(symbol_68);  // Real
			symbol_410.setLower(BigInteger.valueOf(0));
			symbol_410.setIsUnique(false);
			
			symbol_409.getOwnedParameters().add(symbol_410);
			symbol_409.setPrecedence(symbol_5);
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::Real::-() Real|-()
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_411.setName("-");
			symbol_411.setType(symbol_68);  // Real
			symbol_411.setLower(BigInteger.valueOf(0));
			symbol_411.setIsUnique(false);
			
			symbol_411.setPrecedence(symbol_3);
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::Real::/() Real|/(Real)
			Operation symbol_412 = PivotFactory.eINSTANCE.createOperation();
			symbol_412.setName("/");
			symbol_412.setType(symbol_68);  // Real
			symbol_412.setLower(BigInteger.valueOf(0));
			symbol_412.setIsUnique(false);
			
			Parameter symbol_413 = PivotFactory.eINSTANCE.createParameter();
			symbol_413.setName("r");
			symbol_413.setType(symbol_68);  // Real
			symbol_413.setLower(BigInteger.valueOf(0));
			symbol_413.setIsUnique(false);
			
			symbol_412.getOwnedParameters().add(symbol_413);
			symbol_412.setPrecedence(symbol_4);
			symbol_412.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_412);
		}
		{	// ocl::Real::<() Real|<(Real)
			Operation symbol_414 = PivotFactory.eINSTANCE.createOperation();
			symbol_414.setName("<");
			symbol_414.setType(symbol_19);  // Boolean
			symbol_414.setLower(BigInteger.valueOf(0));
			symbol_414.setIsUnique(false);
			
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("r");
			symbol_415.setType(symbol_68);  // Real
			symbol_415.setLower(BigInteger.valueOf(0));
			symbol_415.setIsUnique(false);
			
			symbol_414.getOwnedParameters().add(symbol_415);
			symbol_414.setPrecedence(symbol_6);
			symbol_414.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_414);
		}
		{	// ocl::Real::<=() Real|<=(Real)
			Operation symbol_416 = PivotFactory.eINSTANCE.createOperation();
			symbol_416.setName("<=");
			symbol_416.setType(symbol_19);  // Boolean
			symbol_416.setLower(BigInteger.valueOf(0));
			symbol_416.setIsUnique(false);
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("r");
			symbol_417.setType(symbol_68);  // Real
			symbol_417.setLower(BigInteger.valueOf(0));
			symbol_417.setIsUnique(false);
			
			symbol_416.getOwnedParameters().add(symbol_417);
			symbol_416.setPrecedence(symbol_6);
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::Real::<>() Real|<>(ocl|OclAny)
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("<>");
			symbol_418.setType(symbol_19);  // Boolean
			symbol_418.setLower(BigInteger.valueOf(0));
			symbol_418.setIsUnique(false);
			
			Parameter symbol_419 = PivotFactory.eINSTANCE.createParameter();
			symbol_419.setName("object2");
			symbol_419.setType(symbol_50);  // ocl|OclAny
			symbol_419.setLower(BigInteger.valueOf(0));
			symbol_419.setIsUnique(false);
			
			symbol_418.getOwnedParameters().add(symbol_419);
			symbol_418.setPrecedence(symbol_7);
			symbol_418.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_418);
		}
		{	// ocl::Real::=() Real|=(ocl|OclAny)
			Operation symbol_420 = PivotFactory.eINSTANCE.createOperation();
			symbol_420.setName("=");
			symbol_420.setType(symbol_19);  // Boolean
			symbol_420.setLower(BigInteger.valueOf(0));
			symbol_420.setIsUnique(false);
			
			Parameter symbol_421 = PivotFactory.eINSTANCE.createParameter();
			symbol_421.setName("object2");
			symbol_421.setType(symbol_50);  // ocl|OclAny
			symbol_421.setLower(BigInteger.valueOf(0));
			symbol_421.setIsUnique(false);
			
			symbol_420.getOwnedParameters().add(symbol_421);
			symbol_420.setPrecedence(symbol_7);
			symbol_420.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_420);
		}
		{	// ocl::Real::>() Real|>(Real)
			Operation symbol_422 = PivotFactory.eINSTANCE.createOperation();
			symbol_422.setName(">");
			symbol_422.setType(symbol_19);  // Boolean
			symbol_422.setLower(BigInteger.valueOf(0));
			symbol_422.setIsUnique(false);
			
			Parameter symbol_423 = PivotFactory.eINSTANCE.createParameter();
			symbol_423.setName("r");
			symbol_423.setType(symbol_68);  // Real
			symbol_423.setLower(BigInteger.valueOf(0));
			symbol_423.setIsUnique(false);
			
			symbol_422.getOwnedParameters().add(symbol_423);
			symbol_422.setPrecedence(symbol_6);
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_422);
		}
		{	// ocl::Real::>=() Real|>=(Real)
			Operation symbol_424 = PivotFactory.eINSTANCE.createOperation();
			symbol_424.setName(">=");
			symbol_424.setType(symbol_19);  // Boolean
			symbol_424.setLower(BigInteger.valueOf(0));
			symbol_424.setIsUnique(false);
			
			Parameter symbol_425 = PivotFactory.eINSTANCE.createParameter();
			symbol_425.setName("r");
			symbol_425.setType(symbol_68);  // Real
			symbol_425.setLower(BigInteger.valueOf(0));
			symbol_425.setIsUnique(false);
			
			symbol_424.getOwnedParameters().add(symbol_425);
			symbol_424.setPrecedence(symbol_6);
			symbol_424.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_424);
		}
		{	// ocl::Real::abs() Real|abs()
			Operation symbol_426 = PivotFactory.eINSTANCE.createOperation();
			symbol_426.setName("abs");
			symbol_426.setType(symbol_68);  // Real
			symbol_426.setLower(BigInteger.valueOf(0));
			symbol_426.setIsUnique(false);
			
			symbol_426.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_426);
		}
		{	// ocl::Real::floor() Real|floor()
			Operation symbol_427 = PivotFactory.eINSTANCE.createOperation();
			symbol_427.setName("floor");
			symbol_427.setType(symbol_41);  // Integer
			symbol_427.setLower(BigInteger.valueOf(0));
			symbol_427.setIsUnique(false);
			
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::Real::max() Real|max(Real)
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("max");
			symbol_428.setType(symbol_68);  // Real
			symbol_428.setLower(BigInteger.valueOf(0));
			symbol_428.setIsUnique(false);
			
			Parameter symbol_429 = PivotFactory.eINSTANCE.createParameter();
			symbol_429.setName("r");
			symbol_429.setType(symbol_68);  // Real
			symbol_429.setLower(BigInteger.valueOf(0));
			symbol_429.setIsUnique(false);
			
			symbol_428.getOwnedParameters().add(symbol_429);
			symbol_428.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::Real::min() Real|min(Real)
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("min");
			symbol_430.setType(symbol_68);  // Real
			symbol_430.setLower(BigInteger.valueOf(0));
			symbol_430.setIsUnique(false);
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("r");
			symbol_431.setType(symbol_68);  // Real
			symbol_431.setLower(BigInteger.valueOf(0));
			symbol_431.setIsUnique(false);
			
			symbol_430.getOwnedParameters().add(symbol_431);
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::Real::oclAsType() Real|oclAsType{T}(ocl|Classifier)
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_71.setName("T");
			symbol_70.setOwnedParameteredElement(symbol_71);
			symbol_69.getOwnedParameters().add(symbol_70);
			
			symbol_432.setOwnedTemplateSignature(symbol_69);
			symbol_432.setName("oclAsType");
			symbol_432.setType(symbol_71);  // Real|oclAsType{T}(ocl|Classifier)?T
			symbol_432.setLower(BigInteger.valueOf(0));
			symbol_432.setIsUnique(false);
			
			Parameter symbol_433 = PivotFactory.eINSTANCE.createParameter();
			symbol_433.setName("type");
			symbol_433.setType(symbol_20);  // ocl|Classifier
			symbol_433.setLower(BigInteger.valueOf(0));
			symbol_433.setIsUnique(false);
			
			symbol_432.getOwnedParameters().add(symbol_433);
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::Real::round() Real|round()
			Operation symbol_434 = PivotFactory.eINSTANCE.createOperation();
			symbol_434.setName("round");
			symbol_434.setType(symbol_41);  // Integer
			symbol_434.setLower(BigInteger.valueOf(0));
			symbol_434.setIsUnique(false);
			
			symbol_434.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_434);
		}
		{	// ocl::Real::toString() Real|toString()
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_435.setName("toString");
			symbol_435.setType(symbol_86);  // String
			symbol_435.setLower(BigInteger.valueOf(0));
			symbol_435.setIsUnique(false);
			
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_435);
		}
		symbol_1.getOwnedTypes().add(symbol_68);
		//
		// ocl::Sequence ocl|Sequence{T}
		//
		symbol_72.setName("Sequence");
		symbol_72.setElementType(symbol_75);
		symbol_75.setName("T");
		symbol_74.setOwnedParameteredElement(symbol_75);
		symbol_73.getOwnedParameters().add(symbol_74);
		
		symbol_72.setOwnedTemplateSignature(symbol_73);
		symbol_72.getSuperClasses().add(symbol_141); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		symbol_72.getSuperClasses().add(symbol_147); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl|Sequence{T}|<>(ocl|OclAny)
			Operation symbol_436 = PivotFactory.eINSTANCE.createOperation();
			symbol_436.setName("<>");
			symbol_436.setType(symbol_19);  // Boolean
			symbol_436.setLower(BigInteger.valueOf(0));
			symbol_436.setIsUnique(false);
			
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("object2");
			symbol_437.setType(symbol_50);  // ocl|OclAny
			symbol_437.setLower(BigInteger.valueOf(0));
			symbol_437.setIsUnique(false);
			
			symbol_436.getOwnedParameters().add(symbol_437);
			symbol_436.setPrecedence(symbol_7);
			symbol_436.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_436);
		}
		{	// ocl::Sequence::=() ocl|Sequence{T}|=(ocl|OclAny)
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("=");
			symbol_438.setType(symbol_19);  // Boolean
			symbol_438.setLower(BigInteger.valueOf(0));
			symbol_438.setIsUnique(false);
			
			Parameter symbol_439 = PivotFactory.eINSTANCE.createParameter();
			symbol_439.setName("object2");
			symbol_439.setType(symbol_50);  // ocl|OclAny
			symbol_439.setLower(BigInteger.valueOf(0));
			symbol_439.setIsUnique(false);
			
			symbol_438.getOwnedParameters().add(symbol_439);
			symbol_438.setPrecedence(symbol_7);
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::Sequence::append() ocl|Sequence{T}|append(ocl|Sequence{T}?T)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("append");
			symbol_440.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_440.setLower(BigInteger.valueOf(0));
			symbol_440.setIsUnique(false);
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("object");
			symbol_441.setType(symbol_75);  // ocl|Sequence{T}?T
			symbol_441.setLower(BigInteger.valueOf(0));
			symbol_441.setIsUnique(false);
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::Sequence::excluding() ocl|Sequence{T}|excluding(ocl|OclAny)
			Operation symbol_442 = PivotFactory.eINSTANCE.createOperation();
			symbol_442.setName("excluding");
			symbol_442.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_442.setLower(BigInteger.valueOf(0));
			symbol_442.setIsUnique(false);
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("object");
			symbol_443.setType(symbol_50);  // ocl|OclAny
			symbol_443.setLower(BigInteger.valueOf(0));
			symbol_443.setIsUnique(false);
			
			symbol_442.getOwnedParameters().add(symbol_443);
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::Sequence::flatten() ocl|Sequence{T}|flatten{T2}()
			Operation symbol_444 = PivotFactory.eINSTANCE.createOperation();
			symbol_78.setName("T2");
			symbol_77.setOwnedParameteredElement(symbol_78);
			symbol_76.getOwnedParameters().add(symbol_77);
			
			symbol_444.setOwnedTemplateSignature(symbol_76);
			symbol_444.setName("flatten");
			symbol_444.setType(symbol_156);  // ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
			symbol_444.setLower(BigInteger.valueOf(0));
			symbol_444.setIsUnique(false);
			
			symbol_444.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_444);
		}
		{	// ocl::Sequence::including() ocl|Sequence{T}|including(ocl|Sequence{T}?T)
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("including");
			symbol_445.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_445.setLower(BigInteger.valueOf(0));
			symbol_445.setIsUnique(false);
			
			Parameter symbol_446 = PivotFactory.eINSTANCE.createParameter();
			symbol_446.setName("object");
			symbol_446.setType(symbol_75);  // ocl|Sequence{T}?T
			symbol_446.setLower(BigInteger.valueOf(0));
			symbol_446.setIsUnique(false);
			
			symbol_445.getOwnedParameters().add(symbol_446);
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::Sequence::insertAt() ocl|Sequence{T}|insertAt(Integer,ocl|Sequence{T}?T)
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("insertAt");
			symbol_447.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_447.setLower(BigInteger.valueOf(0));
			symbol_447.setIsUnique(false);
			
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("index");
			symbol_448.setType(symbol_41);  // Integer
			symbol_448.setLower(BigInteger.valueOf(0));
			symbol_448.setIsUnique(false);
			
			symbol_447.getOwnedParameters().add(symbol_448);
			Parameter symbol_449 = PivotFactory.eINSTANCE.createParameter();
			symbol_449.setName("object");
			symbol_449.setType(symbol_75);  // ocl|Sequence{T}?T
			symbol_449.setLower(BigInteger.valueOf(0));
			symbol_449.setIsUnique(false);
			
			symbol_447.getOwnedParameters().add(symbol_449);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::Sequence::prepend() ocl|Sequence{T}|prepend(ocl|Sequence{T}?T)
			Operation symbol_450 = PivotFactory.eINSTANCE.createOperation();
			symbol_450.setName("prepend");
			symbol_450.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_450.setLower(BigInteger.valueOf(0));
			symbol_450.setIsUnique(false);
			
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("object");
			symbol_451.setType(symbol_75);  // ocl|Sequence{T}?T
			symbol_451.setLower(BigInteger.valueOf(0));
			symbol_451.setIsUnique(false);
			
			symbol_450.getOwnedParameters().add(symbol_451);
			symbol_450.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_450);
		}
		{	// ocl::Sequence::reject() ocl|Sequence{T}|reject(ocl|Sequence{T}?T)
			Iteration symbol_452 = PivotFactory.eINSTANCE.createIteration();
			symbol_452.setName("reject");
			symbol_452.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("i");
			symbol_453.setType(symbol_75);  // ocl|Sequence{T}?T
			symbol_452.getOwnedIterators().add(symbol_453);
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::Sequence::reverse() ocl|Sequence{T}|reverse()
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("reverse");
			symbol_454.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_454.setLower(BigInteger.valueOf(0));
			symbol_454.setIsUnique(false);
			
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::Sequence::select() ocl|Sequence{T}|select(ocl|Sequence{T}?T)
			Iteration symbol_455 = PivotFactory.eINSTANCE.createIteration();
			symbol_455.setName("select");
			symbol_455.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			
			Parameter symbol_456 = PivotFactory.eINSTANCE.createParameter();
			symbol_456.setName("i");
			symbol_456.setType(symbol_75);  // ocl|Sequence{T}?T
			symbol_455.getOwnedIterators().add(symbol_456);
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_455);
		}
		{	// ocl::Sequence::subSequence() ocl|Sequence{T}|subSequence(Integer,Integer)
			Operation symbol_457 = PivotFactory.eINSTANCE.createOperation();
			symbol_457.setName("subSequence");
			symbol_457.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_457.setLower(BigInteger.valueOf(0));
			symbol_457.setIsUnique(false);
			
			Parameter symbol_458 = PivotFactory.eINSTANCE.createParameter();
			symbol_458.setName("lower");
			symbol_458.setType(symbol_41);  // Integer
			symbol_458.setLower(BigInteger.valueOf(0));
			symbol_458.setIsUnique(false);
			
			symbol_457.getOwnedParameters().add(symbol_458);
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("upper");
			symbol_459.setType(symbol_41);  // Integer
			symbol_459.setLower(BigInteger.valueOf(0));
			symbol_459.setIsUnique(false);
			
			symbol_457.getOwnedParameters().add(symbol_459);
			symbol_457.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_457);
		}
		{	// ocl::Sequence::union() ocl|Sequence{T}|union(ocl|Sequence[ocl|Sequence{T}?T])
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("union");
			symbol_460.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_460.setLower(BigInteger.valueOf(0));
			symbol_460.setIsUnique(false);
			
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("s");
			symbol_461.setType(symbol_160);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_461.setLower(BigInteger.valueOf(0));
			symbol_461.setIsUnique(false);
			
			symbol_460.getOwnedParameters().add(symbol_461);
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_460);
		}
		symbol_1.getOwnedTypes().add(symbol_72);
		//
		// ocl::Set ocl|Set{T}
		//
		symbol_79.setName("Set");
		symbol_79.setElementType(symbol_82);
		symbol_82.setName("T");
		symbol_81.setOwnedParameteredElement(symbol_82);
		symbol_80.getOwnedParameters().add(symbol_81);
		
		symbol_79.setOwnedTemplateSignature(symbol_80);
		symbol_79.getSuperClasses().add(symbol_134); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		symbol_79.getSuperClasses().add(symbol_183); // ocl|UniqueCollection[ocl|Set{T}?T]
		{	// ocl::Set::-() ocl|Set{T}|-(ocl|Set[ocl|OclAny])
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("-");
			symbol_462.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			symbol_462.setLower(BigInteger.valueOf(0));
			symbol_462.setIsUnique(false);
			
			Parameter symbol_463 = PivotFactory.eINSTANCE.createParameter();
			symbol_463.setName("s");
			symbol_463.setType(symbol_162);  // ocl|Set[ocl|OclAny]
			symbol_463.setLower(BigInteger.valueOf(0));
			symbol_463.setIsUnique(false);
			
			symbol_462.getOwnedParameters().add(symbol_463);
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::Set::<>() ocl|Set{T}|<>(ocl|OclAny)
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("<>");
			symbol_464.setType(symbol_19);  // Boolean
			symbol_464.setLower(BigInteger.valueOf(0));
			symbol_464.setIsUnique(false);
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("object2");
			symbol_465.setType(symbol_50);  // ocl|OclAny
			symbol_465.setLower(BigInteger.valueOf(0));
			symbol_465.setIsUnique(false);
			
			symbol_464.getOwnedParameters().add(symbol_465);
			symbol_464.setPrecedence(symbol_7);
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::Set::=() ocl|Set{T}|=(ocl|OclAny)
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_466.setName("=");
			symbol_466.setType(symbol_19);  // Boolean
			symbol_466.setLower(BigInteger.valueOf(0));
			symbol_466.setIsUnique(false);
			
			Parameter symbol_467 = PivotFactory.eINSTANCE.createParameter();
			symbol_467.setName("object2");
			symbol_467.setType(symbol_50);  // ocl|OclAny
			symbol_467.setLower(BigInteger.valueOf(0));
			symbol_467.setIsUnique(false);
			
			symbol_466.getOwnedParameters().add(symbol_467);
			symbol_466.setPrecedence(symbol_7);
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::Set::excluding() ocl|Set{T}|excluding(ocl|OclAny)
			Operation symbol_468 = PivotFactory.eINSTANCE.createOperation();
			symbol_468.setName("excluding");
			symbol_468.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			symbol_468.setLower(BigInteger.valueOf(0));
			symbol_468.setIsUnique(false);
			
			Parameter symbol_469 = PivotFactory.eINSTANCE.createParameter();
			symbol_469.setName("object");
			symbol_469.setType(symbol_50);  // ocl|OclAny
			symbol_469.setLower(BigInteger.valueOf(0));
			symbol_469.setIsUnique(false);
			
			symbol_468.getOwnedParameters().add(symbol_469);
			symbol_468.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_468);
		}
		{	// ocl::Set::flatten() ocl|Set{T}|flatten{T2}()
			Operation symbol_470 = PivotFactory.eINSTANCE.createOperation();
			symbol_85.setName("T2");
			symbol_84.setOwnedParameteredElement(symbol_85);
			symbol_83.getOwnedParameters().add(symbol_84);
			
			symbol_470.setOwnedTemplateSignature(symbol_83);
			symbol_470.setName("flatten");
			symbol_470.setType(symbol_167);  // ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
			symbol_470.setLower(BigInteger.valueOf(0));
			symbol_470.setIsUnique(false);
			
			symbol_470.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_470);
		}
		{	// ocl::Set::including() ocl|Set{T}|including(ocl|Set{T}?T)
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("including");
			symbol_471.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			symbol_471.setLower(BigInteger.valueOf(0));
			symbol_471.setIsUnique(false);
			
			Parameter symbol_472 = PivotFactory.eINSTANCE.createParameter();
			symbol_472.setName("object");
			symbol_472.setType(symbol_82);  // ocl|Set{T}?T
			symbol_472.setLower(BigInteger.valueOf(0));
			symbol_472.setIsUnique(false);
			
			symbol_471.getOwnedParameters().add(symbol_472);
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_471);
		}
		{	// ocl::Set::intersection() ocl|Set{T}|intersection(ocl|Set[ocl|Set{T}?T])
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName("intersection");
			symbol_473.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			symbol_473.setLower(BigInteger.valueOf(0));
			symbol_473.setIsUnique(false);
			
			Parameter symbol_474 = PivotFactory.eINSTANCE.createParameter();
			symbol_474.setName("s");
			symbol_474.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			symbol_474.setLower(BigInteger.valueOf(0));
			symbol_474.setIsUnique(false);
			
			symbol_473.getOwnedParameters().add(symbol_474);
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_473);
		}
		{	// ocl::Set::reject() ocl|Set{T}|reject(ocl|Set{T}?T)
			Iteration symbol_475 = PivotFactory.eINSTANCE.createIteration();
			symbol_475.setName("reject");
			symbol_475.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			
			Parameter symbol_476 = PivotFactory.eINSTANCE.createParameter();
			symbol_476.setName("i");
			symbol_476.setType(symbol_82);  // ocl|Set{T}?T
			symbol_475.getOwnedIterators().add(symbol_476);
			symbol_475.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_475);
		}
		{	// ocl::Set::select() ocl|Set{T}|select(ocl|Set{T}?T)
			Iteration symbol_477 = PivotFactory.eINSTANCE.createIteration();
			symbol_477.setName("select");
			symbol_477.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			
			Parameter symbol_478 = PivotFactory.eINSTANCE.createParameter();
			symbol_478.setName("i");
			symbol_478.setType(symbol_82);  // ocl|Set{T}?T
			symbol_477.getOwnedIterators().add(symbol_478);
			symbol_477.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_477);
		}
		{	// ocl::Set::symmetricDifference() ocl|Set{T}|symmetricDifference(ocl|Set[ocl|OclAny])
			Operation symbol_479 = PivotFactory.eINSTANCE.createOperation();
			symbol_479.setName("symmetricDifference");
			symbol_479.setType(symbol_168);  // ocl|Set[ocl|Set{T}?T]
			symbol_479.setLower(BigInteger.valueOf(0));
			symbol_479.setIsUnique(false);
			
			Parameter symbol_480 = PivotFactory.eINSTANCE.createParameter();
			symbol_480.setName("s");
			symbol_480.setType(symbol_162);  // ocl|Set[ocl|OclAny]
			symbol_480.setLower(BigInteger.valueOf(0));
			symbol_480.setIsUnique(false);
			
			symbol_479.getOwnedParameters().add(symbol_480);
			symbol_479.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_479);
		}
		symbol_1.getOwnedTypes().add(symbol_79);
		//
		// ocl::String String
		//
		symbol_86.setName("String");
		symbol_86.getSuperClasses().add(symbol_50); // ocl|OclAny
		{	// ocl::String::+() String|+(String)
			Operation symbol_481 = PivotFactory.eINSTANCE.createOperation();
			symbol_481.setName("+");
			symbol_481.setType(symbol_86);  // String
			symbol_481.setLower(BigInteger.valueOf(0));
			symbol_481.setIsUnique(false);
			
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("s");
			symbol_482.setType(symbol_86);  // String
			symbol_482.setLower(BigInteger.valueOf(0));
			symbol_482.setIsUnique(false);
			
			symbol_481.getOwnedParameters().add(symbol_482);
			symbol_481.setPrecedence(symbol_5);
			symbol_481.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_481);
		}
		{	// ocl::String::<() String|<(String)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("<");
			symbol_483.setType(symbol_19);  // Boolean
			symbol_483.setLower(BigInteger.valueOf(0));
			symbol_483.setIsUnique(false);
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("s");
			symbol_484.setType(symbol_86);  // String
			symbol_484.setLower(BigInteger.valueOf(0));
			symbol_484.setIsUnique(false);
			
			symbol_483.getOwnedParameters().add(symbol_484);
			symbol_483.setPrecedence(symbol_6);
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::String::<=() String|<=(String)
			Operation symbol_485 = PivotFactory.eINSTANCE.createOperation();
			symbol_485.setName("<=");
			symbol_485.setType(symbol_19);  // Boolean
			symbol_485.setLower(BigInteger.valueOf(0));
			symbol_485.setIsUnique(false);
			
			Parameter symbol_486 = PivotFactory.eINSTANCE.createParameter();
			symbol_486.setName("s");
			symbol_486.setType(symbol_86);  // String
			symbol_486.setLower(BigInteger.valueOf(0));
			symbol_486.setIsUnique(false);
			
			symbol_485.getOwnedParameters().add(symbol_486);
			symbol_485.setPrecedence(symbol_6);
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::String::<>() String|<>(ocl|OclAny)
			Operation symbol_487 = PivotFactory.eINSTANCE.createOperation();
			symbol_487.setName("<>");
			symbol_487.setType(symbol_19);  // Boolean
			symbol_487.setLower(BigInteger.valueOf(0));
			symbol_487.setIsUnique(false);
			
			Parameter symbol_488 = PivotFactory.eINSTANCE.createParameter();
			symbol_488.setName("object2");
			symbol_488.setType(symbol_50);  // ocl|OclAny
			symbol_488.setLower(BigInteger.valueOf(0));
			symbol_488.setIsUnique(false);
			
			symbol_487.getOwnedParameters().add(symbol_488);
			symbol_487.setPrecedence(symbol_7);
			symbol_487.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_487);
		}
		{	// ocl::String::=() String|=(ocl|OclAny)
			Operation symbol_489 = PivotFactory.eINSTANCE.createOperation();
			symbol_489.setName("=");
			symbol_489.setType(symbol_19);  // Boolean
			symbol_489.setLower(BigInteger.valueOf(0));
			symbol_489.setIsUnique(false);
			
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("object2");
			symbol_490.setType(symbol_50);  // ocl|OclAny
			symbol_490.setLower(BigInteger.valueOf(0));
			symbol_490.setIsUnique(false);
			
			symbol_489.getOwnedParameters().add(symbol_490);
			symbol_489.setPrecedence(symbol_7);
			symbol_489.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_489);
		}
		{	// ocl::String::>() String|>(String)
			Operation symbol_491 = PivotFactory.eINSTANCE.createOperation();
			symbol_491.setName(">");
			symbol_491.setType(symbol_19);  // Boolean
			symbol_491.setLower(BigInteger.valueOf(0));
			symbol_491.setIsUnique(false);
			
			Parameter symbol_492 = PivotFactory.eINSTANCE.createParameter();
			symbol_492.setName("s");
			symbol_492.setType(symbol_86);  // String
			symbol_492.setLower(BigInteger.valueOf(0));
			symbol_492.setIsUnique(false);
			
			symbol_491.getOwnedParameters().add(symbol_492);
			symbol_491.setPrecedence(symbol_6);
			symbol_491.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_491);
		}
		{	// ocl::String::>=() String|>=(String)
			Operation symbol_493 = PivotFactory.eINSTANCE.createOperation();
			symbol_493.setName(">=");
			symbol_493.setType(symbol_19);  // Boolean
			symbol_493.setLower(BigInteger.valueOf(0));
			symbol_493.setIsUnique(false);
			
			Parameter symbol_494 = PivotFactory.eINSTANCE.createParameter();
			symbol_494.setName("s");
			symbol_494.setType(symbol_86);  // String
			symbol_494.setLower(BigInteger.valueOf(0));
			symbol_494.setIsUnique(false);
			
			symbol_493.getOwnedParameters().add(symbol_494);
			symbol_493.setPrecedence(symbol_6);
			symbol_493.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_493);
		}
		{	// ocl::String::at() String|at(Integer)
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("at");
			symbol_495.setType(symbol_86);  // String
			symbol_495.setLower(BigInteger.valueOf(0));
			symbol_495.setIsUnique(false);
			
			Parameter symbol_496 = PivotFactory.eINSTANCE.createParameter();
			symbol_496.setName("i");
			symbol_496.setType(symbol_41);  // Integer
			symbol_496.setLower(BigInteger.valueOf(0));
			symbol_496.setIsUnique(false);
			
			symbol_495.getOwnedParameters().add(symbol_496);
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::String::characters() String|characters()
			Operation symbol_497 = PivotFactory.eINSTANCE.createOperation();
			symbol_497.setName("characters");
			symbol_497.setType(symbol_158);  // ocl|Sequence[String]
			symbol_497.setLower(BigInteger.valueOf(0));
			symbol_497.setIsUnique(false);
			
			symbol_497.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_497);
		}
		{	// ocl::String::concat() String|concat(String)
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("concat");
			symbol_498.setType(symbol_86);  // String
			symbol_498.setLower(BigInteger.valueOf(0));
			symbol_498.setIsUnique(false);
			
			Parameter symbol_499 = PivotFactory.eINSTANCE.createParameter();
			symbol_499.setName("s");
			symbol_499.setType(symbol_86);  // String
			symbol_499.setLower(BigInteger.valueOf(0));
			symbol_499.setIsUnique(false);
			
			symbol_498.getOwnedParameters().add(symbol_499);
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::String::equalsIgnoreCase() String|equalsIgnoreCase(String)
			Operation symbol_500 = PivotFactory.eINSTANCE.createOperation();
			symbol_500.setName("equalsIgnoreCase");
			symbol_500.setType(symbol_19);  // Boolean
			symbol_500.setLower(BigInteger.valueOf(0));
			symbol_500.setIsUnique(false);
			
			Parameter symbol_501 = PivotFactory.eINSTANCE.createParameter();
			symbol_501.setName("s");
			symbol_501.setType(symbol_86);  // String
			symbol_501.setLower(BigInteger.valueOf(0));
			symbol_501.setIsUnique(false);
			
			symbol_500.getOwnedParameters().add(symbol_501);
			symbol_500.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_500);
		}
		{	// ocl::String::indexOf() String|indexOf(String)
			Operation symbol_502 = PivotFactory.eINSTANCE.createOperation();
			symbol_502.setName("indexOf");
			symbol_502.setType(symbol_41);  // Integer
			symbol_502.setLower(BigInteger.valueOf(0));
			symbol_502.setIsUnique(false);
			
			Parameter symbol_503 = PivotFactory.eINSTANCE.createParameter();
			symbol_503.setName("s");
			symbol_503.setType(symbol_86);  // String
			symbol_503.setLower(BigInteger.valueOf(0));
			symbol_503.setIsUnique(false);
			
			symbol_502.getOwnedParameters().add(symbol_503);
			symbol_502.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_502);
		}
		{	// ocl::String::size() String|size()
			Operation symbol_504 = PivotFactory.eINSTANCE.createOperation();
			symbol_504.setName("size");
			symbol_504.setType(symbol_41);  // Integer
			symbol_504.setLower(BigInteger.valueOf(0));
			symbol_504.setIsUnique(false);
			
			symbol_504.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_504);
		}
		{	// ocl::String::substring() String|substring(Integer,Integer)
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("substring");
			symbol_505.setType(symbol_86);  // String
			symbol_505.setLower(BigInteger.valueOf(0));
			symbol_505.setIsUnique(false);
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("lower");
			symbol_506.setType(symbol_41);  // Integer
			symbol_506.setLower(BigInteger.valueOf(0));
			symbol_506.setIsUnique(false);
			
			symbol_505.getOwnedParameters().add(symbol_506);
			Parameter symbol_507 = PivotFactory.eINSTANCE.createParameter();
			symbol_507.setName("upper");
			symbol_507.setType(symbol_41);  // Integer
			symbol_507.setLower(BigInteger.valueOf(0));
			symbol_507.setIsUnique(false);
			
			symbol_505.getOwnedParameters().add(symbol_507);
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::String::toBoolean() String|toBoolean()
			Operation symbol_508 = PivotFactory.eINSTANCE.createOperation();
			symbol_508.setName("toBoolean");
			symbol_508.setType(symbol_19);  // Boolean
			symbol_508.setLower(BigInteger.valueOf(0));
			symbol_508.setIsUnique(false);
			
			symbol_508.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_508);
		}
		{	// ocl::String::toInteger() String|toInteger()
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_509.setName("toInteger");
			symbol_509.setType(symbol_41);  // Integer
			symbol_509.setLower(BigInteger.valueOf(0));
			symbol_509.setIsUnique(false);
			
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::String::toLowerCase() String|toLowerCase()
			Operation symbol_510 = PivotFactory.eINSTANCE.createOperation();
			symbol_510.setName("toLowerCase");
			symbol_510.setType(symbol_86);  // String
			symbol_510.setLower(BigInteger.valueOf(0));
			symbol_510.setIsUnique(false);
			
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::String::toReal() String|toReal()
			Operation symbol_511 = PivotFactory.eINSTANCE.createOperation();
			symbol_511.setName("toReal");
			symbol_511.setType(symbol_68);  // Real
			symbol_511.setLower(BigInteger.valueOf(0));
			symbol_511.setIsUnique(false);
			
			symbol_511.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_511);
		}
		{	// ocl::String::toString() String|toString()
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("toString");
			symbol_512.setType(symbol_86);  // String
			symbol_512.setLower(BigInteger.valueOf(0));
			symbol_512.setIsUnique(false);
			
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_512);
		}
		{	// ocl::String::toUpperCase() String|toUpperCase()
			Operation symbol_513 = PivotFactory.eINSTANCE.createOperation();
			symbol_513.setName("toUpperCase");
			symbol_513.setType(symbol_86);  // String
			symbol_513.setLower(BigInteger.valueOf(0));
			symbol_513.setIsUnique(false);
			
			symbol_513.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_513);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// ocl::UniqueCollection ocl|UniqueCollection{T}
		//
		symbol_87.setName("UniqueCollection");
		symbol_87.setElementType(symbol_90);
		symbol_90.setName("T");
		symbol_89.setOwnedParameteredElement(symbol_90);
		symbol_88.getOwnedParameters().add(symbol_89);
		
		symbol_87.setOwnedTemplateSignature(symbol_88);
		symbol_87.getSuperClasses().add(symbol_104); // ocl|Collection[ocl|UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl|UniqueCollection{T}|sortedBy(ocl|UniqueCollection{T}?T)
			Iteration symbol_514 = PivotFactory.eINSTANCE.createIteration();
			symbol_514.setName("sortedBy");
			symbol_514.setType(symbol_152);  // ocl|OrderedSet[ocl|UniqueCollection{T}?T]
			
			Parameter symbol_515 = PivotFactory.eINSTANCE.createParameter();
			symbol_515.setName("i");
			symbol_515.setType(symbol_90);  // ocl|UniqueCollection{T}?T
			symbol_514.getOwnedIterators().add(symbol_515);
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_514);
		}
		symbol_1.getOwnedTypes().add(symbol_87);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_91.setName("UnlimitedNatural");
		symbol_91.getSuperClasses().add(symbol_41); // Integer
		symbol_1.getOwnedTypes().add(symbol_91);
		//
		// ocl::orphanage
		//
		symbol_92.setName("orphanage");
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|NonOrderedCollection{T}?T]
		//
		symbol_93.setName("Bag");
		symbol_93.setElementType(symbol_45);
		{
			TemplateBinding symbol_516 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_516.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_517 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_517.setFormal(symbol_14);	
				symbol_517.setActual(symbol_45);	
				symbol_516.getParameterSubstitutions().add(symbol_517);
			}
			symbol_93.getTemplateBindings().add(symbol_516);
		}
		symbol_93.getSuperClasses().add(symbol_136); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		symbol_93.getSuperClasses().add(symbol_121); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_93);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Collection{T}?T]
		//
		symbol_94.setName("Bag");
		symbol_94.setElementType(symbol_24);
		{
			TemplateBinding symbol_518 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_518.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_519 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_519.setFormal(symbol_14);	
				symbol_519.setActual(symbol_24);	
				symbol_518.getParameterSubstitutions().add(symbol_519);
			}
			symbol_94.getTemplateBindings().add(symbol_518);
		}
		symbol_94.getSuperClasses().add(symbol_135); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		symbol_94.getSuperClasses().add(symbol_132); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_94);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_95.setName("Bag");
		symbol_95.setElementType(symbol_18);
		{
			TemplateBinding symbol_520 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_520.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_521 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_521.setFormal(symbol_14);	
				symbol_521.setActual(symbol_18);	
				symbol_520.getParameterSubstitutions().add(symbol_521);
			}
			symbol_95.getTemplateBindings().add(symbol_520);
		}
		symbol_95.getSuperClasses().add(symbol_140); // ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_95.getSuperClasses().add(symbol_128); // ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_95);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Bag{T}?T]
		//
		symbol_96.setName("Bag");
		symbol_96.setElementType(symbol_15);
		{
			TemplateBinding symbol_522 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_522.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_523 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_523.setFormal(symbol_14);	
				symbol_523.setActual(symbol_15);	
				symbol_522.getParameterSubstitutions().add(symbol_523);
			}
			symbol_96.getTemplateBindings().add(symbol_522);
		}
		symbol_96.getSuperClasses().add(symbol_127); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		symbol_96.getSuperClasses().add(symbol_137); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		symbol_92.getOwnedTypes().add(symbol_96);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedSet{T}?T]
		//
		symbol_97.setName("Collection");
		symbol_97.setElementType(symbol_67);
		{
			TemplateBinding symbol_524 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_524.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_525 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_525.setFormal(symbol_23);	
				symbol_525.setActual(symbol_67);	
				symbol_524.getParameterSubstitutions().add(symbol_525);
			}
			symbol_97.getTemplateBindings().add(symbol_524);
		}
		symbol_97.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_97);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_98.setName("Collection");
		symbol_98.setElementType(symbol_49);
		{
			TemplateBinding symbol_526 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_526.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_527 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_527.setFormal(symbol_23);	
				symbol_527.setActual(symbol_49);	
				symbol_526.getParameterSubstitutions().add(symbol_527);
			}
			symbol_98.getTemplateBindings().add(symbol_526);
		}
		symbol_98.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_98);
		//
		// ocl::orphanage::Collection ocl|Collection[Boolean]
		//
		symbol_99.setName("Collection");
		symbol_99.setElementType(symbol_19);
		{
			TemplateBinding symbol_528 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_528.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_529 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_529.setFormal(symbol_23);	
				symbol_529.setActual(symbol_19);	
				symbol_528.getParameterSubstitutions().add(symbol_529);
			}
			symbol_99.getTemplateBindings().add(symbol_528);
		}
		symbol_99.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_99);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclAny]
		//
		symbol_100.setName("Collection");
		symbol_100.setElementType(symbol_50);
		{
			TemplateBinding symbol_530 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_530.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_531 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_531.setFormal(symbol_23);	
				symbol_531.setActual(symbol_50);	
				symbol_530.getParameterSubstitutions().add(symbol_531);
			}
			symbol_100.getTemplateBindings().add(symbol_530);
		}
		symbol_100.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_100);
		//
		// ocl::orphanage::Collection ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_101.setName("Collection");
		symbol_101.setElementType(symbol_174);
		{
			TemplateBinding symbol_532 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_532.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_533 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_533.setFormal(symbol_23);	
				symbol_533.setActual(symbol_174);	
				symbol_532.getParameterSubstitutions().add(symbol_533);
			}
			symbol_101.getTemplateBindings().add(symbol_532);
		}
		symbol_101.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_101);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_102.setName("Collection");
		symbol_102.setElementType(symbol_18);
		{
			TemplateBinding symbol_534 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_534.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_535 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_535.setFormal(symbol_23);	
				symbol_535.setActual(symbol_18);	
				symbol_534.getParameterSubstitutions().add(symbol_535);
			}
			symbol_102.getTemplateBindings().add(symbol_534);
		}
		symbol_102.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_102);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_103.setName("Collection");
		symbol_103.setElementType(symbol_85);
		{
			TemplateBinding symbol_536 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_536.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_537 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_537.setFormal(symbol_23);	
				symbol_537.setActual(symbol_85);	
				symbol_536.getParameterSubstitutions().add(symbol_537);
			}
			symbol_103.getTemplateBindings().add(symbol_536);
		}
		symbol_103.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_103);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|UniqueCollection{T}?T]
		//
		symbol_104.setName("Collection");
		symbol_104.setElementType(symbol_90);
		{
			TemplateBinding symbol_538 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_538.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_539 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_539.setFormal(symbol_23);	
				symbol_539.setActual(symbol_90);	
				symbol_538.getParameterSubstitutions().add(symbol_539);
			}
			symbol_104.getTemplateBindings().add(symbol_538);
		}
		symbol_104.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_104);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Set{T}?T]
		//
		symbol_105.setName("Collection");
		symbol_105.setElementType(symbol_82);
		{
			TemplateBinding symbol_540 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_540.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_541 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_541.setFormal(symbol_23);	
				symbol_541.setActual(symbol_82);	
				symbol_540.getParameterSubstitutions().add(symbol_541);
			}
			symbol_105.getTemplateBindings().add(symbol_540);
		}
		symbol_105.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_105);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedCollection{T}?T]
		//
		symbol_106.setName("Collection");
		symbol_106.setElementType(symbol_63);
		{
			TemplateBinding symbol_542 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_542.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_543 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_543.setFormal(symbol_23);	
				symbol_543.setActual(symbol_63);	
				symbol_542.getParameterSubstitutions().add(symbol_543);
			}
			symbol_106.getTemplateBindings().add(symbol_542);
		}
		symbol_106.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_106);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclSelf]
		//
		symbol_107.setName("Collection");
		symbol_107.setElementType(symbol_56);
		{
			TemplateBinding symbol_544 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_544.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_545 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_545.setFormal(symbol_23);	
				symbol_545.setActual(symbol_56);	
				symbol_544.getParameterSubstitutions().add(symbol_545);
			}
			symbol_107.getTemplateBindings().add(symbol_544);
		}
		symbol_107.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_107);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclVoid]
		//
		symbol_108.setName("Collection");
		symbol_108.setElementType(symbol_59);
		{
			TemplateBinding symbol_546 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_546.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_547 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_547.setFormal(symbol_23);	
				symbol_547.setActual(symbol_59);	
				symbol_546.getParameterSubstitutions().add(symbol_547);
			}
			symbol_108.getTemplateBindings().add(symbol_546);
		}
		symbol_108.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_108);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Bag{T}?T]
		//
		symbol_109.setName("Collection");
		symbol_109.setElementType(symbol_15);
		{
			TemplateBinding symbol_548 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_548.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_549 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_549.setFormal(symbol_23);	
				symbol_549.setActual(symbol_15);	
				symbol_548.getParameterSubstitutions().add(symbol_549);
			}
			symbol_109.getTemplateBindings().add(symbol_548);
		}
		symbol_109.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_109);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
		//
		symbol_110.setName("Collection");
		symbol_110.setElementType(symbol_33);
		{
			TemplateBinding symbol_550 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_550.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_551 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_551.setFormal(symbol_23);	
				symbol_551.setActual(symbol_33);	
				symbol_550.getParameterSubstitutions().add(symbol_551);
			}
			symbol_110.getTemplateBindings().add(symbol_550);
		}
		symbol_110.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_110);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
		//
		symbol_111.setName("Collection");
		symbol_111.setElementType(symbol_39);
		{
			TemplateBinding symbol_552 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_552.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_553 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_553.setFormal(symbol_23);	
				symbol_553.setActual(symbol_39);	
				symbol_552.getParameterSubstitutions().add(symbol_553);
			}
			symbol_111.getTemplateBindings().add(symbol_552);
		}
		symbol_111.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_111);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
		//
		symbol_112.setName("Collection");
		symbol_112.setElementType(symbol_30);
		{
			TemplateBinding symbol_554 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_554.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_555 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_555.setFormal(symbol_23);	
				symbol_555.setActual(symbol_30);	
				symbol_554.getParameterSubstitutions().add(symbol_555);
			}
			symbol_112.getTemplateBindings().add(symbol_554);
		}
		symbol_112.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_112);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Enumeration]
		//
		symbol_113.setName("Collection");
		symbol_113.setElementType(symbol_40);
		{
			TemplateBinding symbol_556 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_556.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_557 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_557.setFormal(symbol_23);	
				symbol_557.setActual(symbol_40);	
				symbol_556.getParameterSubstitutions().add(symbol_557);
			}
			symbol_113.getTemplateBindings().add(symbol_556);
		}
		symbol_113.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_113);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}?T]
		//
		symbol_114.setName("Collection");
		symbol_114.setElementType(symbol_24);
		{
			TemplateBinding symbol_558 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_558.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_559 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_559.setFormal(symbol_23);	
				symbol_559.setActual(symbol_24);	
				symbol_558.getParameterSubstitutions().add(symbol_559);
			}
			symbol_114.getTemplateBindings().add(symbol_558);
		}
		symbol_114.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_114);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Sequence{T}?T]
		//
		symbol_115.setName("Collection");
		symbol_115.setElementType(symbol_75);
		{
			TemplateBinding symbol_560 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_560.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_561 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_561.setFormal(symbol_23);	
				symbol_561.setActual(symbol_75);	
				symbol_560.getParameterSubstitutions().add(symbol_561);
			}
			symbol_115.getTemplateBindings().add(symbol_560);
		}
		symbol_115.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_115);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
		//
		symbol_116.setName("Collection");
		symbol_116.setElementType(symbol_27);
		{
			TemplateBinding symbol_562 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_562.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_563 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_563.setFormal(symbol_23);	
				symbol_563.setActual(symbol_27);	
				symbol_562.getParameterSubstitutions().add(symbol_563);
			}
			symbol_116.getTemplateBindings().add(symbol_562);
		}
		symbol_116.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_116);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_117.setName("Collection");
		symbol_117.setElementType(symbol_45);
		{
			TemplateBinding symbol_564 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_564.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_565 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_565.setFormal(symbol_23);	
				symbol_565.setActual(symbol_45);	
				symbol_564.getParameterSubstitutions().add(symbol_565);
			}
			symbol_117.getTemplateBindings().add(symbol_564);
		}
		symbol_117.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_117);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclInvalid]
		//
		symbol_118.setName("Collection");
		symbol_118.setElementType(symbol_54);
		{
			TemplateBinding symbol_566 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_566.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_567 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_567.setFormal(symbol_23);	
				symbol_567.setActual(symbol_54);	
				symbol_566.getParameterSubstitutions().add(symbol_567);
			}
			symbol_118.getTemplateBindings().add(symbol_566);
		}
		symbol_118.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_118);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_119.setName("Collection");
		symbol_119.setElementType(symbol_78);
		{
			TemplateBinding symbol_568 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_568.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_569 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_569.setFormal(symbol_23);	
				symbol_569.setActual(symbol_78);	
				symbol_568.getParameterSubstitutions().add(symbol_569);
			}
			symbol_119.getTemplateBindings().add(symbol_568);
		}
		symbol_119.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_119);
		//
		// ocl::orphanage::Collection ocl|Collection[String]
		//
		symbol_120.setName("Collection");
		symbol_120.setElementType(symbol_86);
		{
			TemplateBinding symbol_570 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_570.setSignature(symbol_22);
			{
				TemplateParameterSubstitution symbol_571 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_571.setFormal(symbol_23);	
				symbol_571.setActual(symbol_86);	
				symbol_570.getParameterSubstitutions().add(symbol_571);
			}
			symbol_120.getTemplateBindings().add(symbol_570);
		}
		symbol_120.getSuperClasses().add(symbol_50); // ocl|OclAny
		symbol_92.getOwnedTypes().add(symbol_120);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_121.setName("NonOrderedCollection");
		symbol_121.setElementType(symbol_45);
		{
			TemplateBinding symbol_572 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_572.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_573 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_573.setFormal(symbol_44);	
				symbol_573.setActual(symbol_45);	
				symbol_572.getParameterSubstitutions().add(symbol_573);
			}
			symbol_121.getTemplateBindings().add(symbol_572);
		}
		symbol_121.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_121);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclVoid]
		//
		symbol_122.setName("NonOrderedCollection");
		symbol_122.setElementType(symbol_59);
		{
			TemplateBinding symbol_574 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_574.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_575 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_575.setFormal(symbol_44);	
				symbol_575.setActual(symbol_59);	
				symbol_574.getParameterSubstitutions().add(symbol_575);
			}
			symbol_122.getTemplateBindings().add(symbol_574);
		}
		symbol_122.getSuperClasses().add(symbol_108); // ocl|Collection[ocl|OclVoid]
		symbol_92.getOwnedTypes().add(symbol_122);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[Boolean]
		//
		symbol_123.setName("NonOrderedCollection");
		symbol_123.setElementType(symbol_19);
		{
			TemplateBinding symbol_576 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_576.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_577 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_577.setFormal(symbol_44);	
				symbol_577.setActual(symbol_19);	
				symbol_576.getParameterSubstitutions().add(symbol_577);
			}
			symbol_123.getTemplateBindings().add(symbol_576);
		}
		symbol_123.getSuperClasses().add(symbol_99); // ocl|Collection[Boolean]
		symbol_92.getOwnedTypes().add(symbol_123);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		//
		symbol_124.setName("NonOrderedCollection");
		symbol_124.setElementType(symbol_67);
		{
			TemplateBinding symbol_578 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_578.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_579 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_579.setFormal(symbol_44);	
				symbol_579.setActual(symbol_67);	
				symbol_578.getParameterSubstitutions().add(symbol_579);
			}
			symbol_124.getTemplateBindings().add(symbol_578);
		}
		symbol_124.getSuperClasses().add(symbol_97); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_92.getOwnedTypes().add(symbol_124);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclSelf]
		//
		symbol_125.setName("NonOrderedCollection");
		symbol_125.setElementType(symbol_56);
		{
			TemplateBinding symbol_580 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_580.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_581 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_581.setFormal(symbol_44);	
				symbol_581.setActual(symbol_56);	
				symbol_580.getParameterSubstitutions().add(symbol_581);
			}
			symbol_125.getTemplateBindings().add(symbol_580);
		}
		symbol_125.getSuperClasses().add(symbol_107); // ocl|Collection[ocl|OclSelf]
		symbol_92.getOwnedTypes().add(symbol_125);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclInvalid]
		//
		symbol_126.setName("NonOrderedCollection");
		symbol_126.setElementType(symbol_54);
		{
			TemplateBinding symbol_582 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_582.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_583 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_583.setFormal(symbol_44);	
				symbol_583.setActual(symbol_54);	
				symbol_582.getParameterSubstitutions().add(symbol_583);
			}
			symbol_126.getTemplateBindings().add(symbol_582);
		}
		symbol_126.getSuperClasses().add(symbol_118); // ocl|Collection[ocl|OclInvalid]
		symbol_92.getOwnedTypes().add(symbol_126);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Bag{T}?T]
		//
		symbol_127.setName("NonOrderedCollection");
		symbol_127.setElementType(symbol_15);
		{
			TemplateBinding symbol_584 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_584.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_585 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_585.setFormal(symbol_44);	
				symbol_585.setActual(symbol_15);	
				symbol_584.getParameterSubstitutions().add(symbol_585);
			}
			symbol_127.getTemplateBindings().add(symbol_584);
		}
		symbol_127.getSuperClasses().add(symbol_109); // ocl|Collection[ocl|Bag{T}?T]
		symbol_92.getOwnedTypes().add(symbol_127);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_128.setName("NonOrderedCollection");
		symbol_128.setElementType(symbol_18);
		{
			TemplateBinding symbol_586 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_586.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_587 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_587.setFormal(symbol_44);	
				symbol_587.setActual(symbol_18);	
				symbol_586.getParameterSubstitutions().add(symbol_587);
			}
			symbol_128.getTemplateBindings().add(symbol_586);
		}
		symbol_128.getSuperClasses().add(symbol_102); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_128);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_129.setName("NonOrderedCollection");
		symbol_129.setElementType(symbol_85);
		{
			TemplateBinding symbol_588 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_588.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_589 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_589.setFormal(symbol_44);	
				symbol_589.setActual(symbol_85);	
				symbol_588.getParameterSubstitutions().add(symbol_589);
			}
			symbol_129.getTemplateBindings().add(symbol_588);
		}
		symbol_129.getSuperClasses().add(symbol_103); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_129);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclAny]
		//
		symbol_130.setName("NonOrderedCollection");
		symbol_130.setElementType(symbol_50);
		{
			TemplateBinding symbol_590 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_590.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_591 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_591.setFormal(symbol_44);	
				symbol_591.setActual(symbol_50);	
				symbol_590.getParameterSubstitutions().add(symbol_591);
			}
			symbol_130.getTemplateBindings().add(symbol_590);
		}
		symbol_130.getSuperClasses().add(symbol_100); // ocl|Collection[ocl|OclAny]
		symbol_92.getOwnedTypes().add(symbol_130);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Enumeration]
		//
		symbol_131.setName("NonOrderedCollection");
		symbol_131.setElementType(symbol_40);
		{
			TemplateBinding symbol_592 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_592.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_593 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_593.setFormal(symbol_44);	
				symbol_593.setActual(symbol_40);	
				symbol_592.getParameterSubstitutions().add(symbol_593);
			}
			symbol_131.getTemplateBindings().add(symbol_592);
		}
		symbol_131.getSuperClasses().add(symbol_113); // ocl|Collection[ocl|Enumeration]
		symbol_92.getOwnedTypes().add(symbol_131);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Collection{T}?T]
		//
		symbol_132.setName("NonOrderedCollection");
		symbol_132.setElementType(symbol_24);
		{
			TemplateBinding symbol_594 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_594.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_595 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_595.setFormal(symbol_44);	
				symbol_595.setActual(symbol_24);	
				symbol_594.getParameterSubstitutions().add(symbol_595);
			}
			symbol_132.getTemplateBindings().add(symbol_594);
		}
		symbol_132.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_132);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_133.setName("NonOrderedCollection");
		symbol_133.setElementType(symbol_174);
		{
			TemplateBinding symbol_596 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_596.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_597 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_597.setFormal(symbol_44);	
				symbol_597.setActual(symbol_174);	
				symbol_596.getParameterSubstitutions().add(symbol_597);
			}
			symbol_133.getTemplateBindings().add(symbol_596);
		}
		symbol_133.getSuperClasses().add(symbol_101); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_92.getOwnedTypes().add(symbol_133);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Set{T}?T]
		//
		symbol_134.setName("NonOrderedCollection");
		symbol_134.setElementType(symbol_82);
		{
			TemplateBinding symbol_598 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_598.setSignature(symbol_43);
			{
				TemplateParameterSubstitution symbol_599 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_599.setFormal(symbol_44);	
				symbol_599.setActual(symbol_82);	
				symbol_598.getParameterSubstitutions().add(symbol_599);
			}
			symbol_134.getTemplateBindings().add(symbol_598);
		}
		symbol_134.getSuperClasses().add(symbol_105); // ocl|Collection[ocl|Set{T}?T]
		symbol_92.getOwnedTypes().add(symbol_134);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Collection{T}?T]
		//
		symbol_135.setName("NonUniqueCollection");
		symbol_135.setElementType(symbol_24);
		{
			TemplateBinding symbol_600 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_600.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_601 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_601.setFormal(symbol_48);	
				symbol_601.setActual(symbol_24);	
				symbol_600.getParameterSubstitutions().add(symbol_601);
			}
			symbol_135.getTemplateBindings().add(symbol_600);
		}
		symbol_135.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_135);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_136.setName("NonUniqueCollection");
		symbol_136.setElementType(symbol_45);
		{
			TemplateBinding symbol_602 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_602.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_603 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_603.setFormal(symbol_48);	
				symbol_603.setActual(symbol_45);	
				symbol_602.getParameterSubstitutions().add(symbol_603);
			}
			symbol_136.getTemplateBindings().add(symbol_602);
		}
		symbol_136.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_136);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Bag{T}?T]
		//
		symbol_137.setName("NonUniqueCollection");
		symbol_137.setElementType(symbol_15);
		{
			TemplateBinding symbol_604 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_604.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_605 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_605.setFormal(symbol_48);	
				symbol_605.setActual(symbol_15);	
				symbol_604.getParameterSubstitutions().add(symbol_605);
			}
			symbol_137.getTemplateBindings().add(symbol_604);
		}
		symbol_137.getSuperClasses().add(symbol_109); // ocl|Collection[ocl|Bag{T}?T]
		symbol_92.getOwnedTypes().add(symbol_137);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[String]
		//
		symbol_138.setName("NonUniqueCollection");
		symbol_138.setElementType(symbol_86);
		{
			TemplateBinding symbol_606 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_606.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_607 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_607.setFormal(symbol_48);	
				symbol_607.setActual(symbol_86);	
				symbol_606.getParameterSubstitutions().add(symbol_607);
			}
			symbol_138.getTemplateBindings().add(symbol_606);
		}
		symbol_138.getSuperClasses().add(symbol_120); // ocl|Collection[String]
		symbol_92.getOwnedTypes().add(symbol_138);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_139.setName("NonUniqueCollection");
		symbol_139.setElementType(symbol_63);
		{
			TemplateBinding symbol_608 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_608.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_609 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_609.setFormal(symbol_48);	
				symbol_609.setActual(symbol_63);	
				symbol_608.getParameterSubstitutions().add(symbol_609);
			}
			symbol_139.getTemplateBindings().add(symbol_608);
		}
		symbol_139.getSuperClasses().add(symbol_106); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_139);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_140.setName("NonUniqueCollection");
		symbol_140.setElementType(symbol_18);
		{
			TemplateBinding symbol_610 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_610.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_611 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_611.setFormal(symbol_48);	
				symbol_611.setActual(symbol_18);	
				symbol_610.getParameterSubstitutions().add(symbol_611);
			}
			symbol_140.getTemplateBindings().add(symbol_610);
		}
		symbol_140.getSuperClasses().add(symbol_102); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_140);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		//
		symbol_141.setName("NonUniqueCollection");
		symbol_141.setElementType(symbol_75);
		{
			TemplateBinding symbol_612 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_612.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_613 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_613.setFormal(symbol_48);	
				symbol_613.setActual(symbol_75);	
				symbol_612.getParameterSubstitutions().add(symbol_613);
			}
			symbol_141.getTemplateBindings().add(symbol_612);
		}
		symbol_141.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Sequence{T}?T]
		symbol_92.getOwnedTypes().add(symbol_141);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_142.setName("NonUniqueCollection");
		symbol_142.setElementType(symbol_78);
		{
			TemplateBinding symbol_614 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_614.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_615 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_615.setFormal(symbol_48);	
				symbol_615.setActual(symbol_78);	
				symbol_614.getParameterSubstitutions().add(symbol_615);
			}
			symbol_142.getTemplateBindings().add(symbol_614);
		}
		symbol_142.getSuperClasses().add(symbol_119); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_142);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_143.setName("NonUniqueCollection");
		symbol_143.setElementType(symbol_49);
		{
			TemplateBinding symbol_616 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_616.setSignature(symbol_47);
			{
				TemplateParameterSubstitution symbol_617 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_617.setFormal(symbol_48);	
				symbol_617.setActual(symbol_49);	
				symbol_616.getParameterSubstitutions().add(symbol_617);
			}
			symbol_143.getTemplateBindings().add(symbol_616);
		}
		symbol_143.getSuperClasses().add(symbol_98); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_143);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		//
		symbol_144.setName("OrderedCollection");
		symbol_144.setElementType(symbol_67);
		{
			TemplateBinding symbol_618 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_618.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_619 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_619.setFormal(symbol_62);	
				symbol_619.setActual(symbol_67);	
				symbol_618.getParameterSubstitutions().add(symbol_619);
			}
			symbol_144.getTemplateBindings().add(symbol_618);
		}
		symbol_144.getSuperClasses().add(symbol_97); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_92.getOwnedTypes().add(symbol_144);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[String]
		//
		symbol_145.setName("OrderedCollection");
		symbol_145.setElementType(symbol_86);
		{
			TemplateBinding symbol_620 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_620.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_621 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_621.setFormal(symbol_62);	
				symbol_621.setActual(symbol_86);	
				symbol_620.getParameterSubstitutions().add(symbol_621);
			}
			symbol_145.getTemplateBindings().add(symbol_620);
		}
		symbol_145.getSuperClasses().add(symbol_120); // ocl|Collection[String]
		symbol_92.getOwnedTypes().add(symbol_145);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_146.setName("OrderedCollection");
		symbol_146.setElementType(symbol_63);
		{
			TemplateBinding symbol_622 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_622.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_623 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_623.setFormal(symbol_62);	
				symbol_623.setActual(symbol_63);	
				symbol_622.getParameterSubstitutions().add(symbol_623);
			}
			symbol_146.getTemplateBindings().add(symbol_622);
		}
		symbol_146.getSuperClasses().add(symbol_106); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_146);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Sequence{T}?T]
		//
		symbol_147.setName("OrderedCollection");
		symbol_147.setElementType(symbol_75);
		{
			TemplateBinding symbol_624 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_624.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_625 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_625.setFormal(symbol_62);	
				symbol_625.setActual(symbol_75);	
				symbol_624.getParameterSubstitutions().add(symbol_625);
			}
			symbol_147.getTemplateBindings().add(symbol_624);
		}
		symbol_147.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Sequence{T}?T]
		symbol_92.getOwnedTypes().add(symbol_147);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_148.setName("OrderedCollection");
		symbol_148.setElementType(symbol_49);
		{
			TemplateBinding symbol_626 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_626.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_627 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_627.setFormal(symbol_62);	
				symbol_627.setActual(symbol_49);	
				symbol_626.getParameterSubstitutions().add(symbol_627);
			}
			symbol_148.getTemplateBindings().add(symbol_626);
		}
		symbol_148.getSuperClasses().add(symbol_98); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_148);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		//
		symbol_149.setName("OrderedCollection");
		symbol_149.setElementType(symbol_90);
		{
			TemplateBinding symbol_628 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_628.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_629 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_629.setFormal(symbol_62);	
				symbol_629.setActual(symbol_90);	
				symbol_628.getParameterSubstitutions().add(symbol_629);
			}
			symbol_149.getTemplateBindings().add(symbol_628);
		}
		symbol_149.getSuperClasses().add(symbol_104); // ocl|Collection[ocl|UniqueCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_149);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Collection{T}?T]
		//
		symbol_150.setName("OrderedCollection");
		symbol_150.setElementType(symbol_24);
		{
			TemplateBinding symbol_630 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_630.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_631 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_631.setFormal(symbol_62);	
				symbol_631.setActual(symbol_24);	
				symbol_630.getParameterSubstitutions().add(symbol_631);
			}
			symbol_150.getTemplateBindings().add(symbol_630);
		}
		symbol_150.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_150);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_151.setName("OrderedCollection");
		symbol_151.setElementType(symbol_78);
		{
			TemplateBinding symbol_632 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_632.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_633 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_633.setFormal(symbol_62);	
				symbol_633.setActual(symbol_78);	
				symbol_632.getParameterSubstitutions().add(symbol_633);
			}
			symbol_151.getTemplateBindings().add(symbol_632);
		}
		symbol_151.getSuperClasses().add(symbol_119); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_151);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|UniqueCollection{T}?T]
		//
		symbol_152.setName("OrderedSet");
		symbol_152.setElementType(symbol_90);
		{
			TemplateBinding symbol_634 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_634.setSignature(symbol_65);
			{
				TemplateParameterSubstitution symbol_635 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_635.setFormal(symbol_66);	
				symbol_635.setActual(symbol_90);	
				symbol_634.getParameterSubstitutions().add(symbol_635);
			}
			symbol_152.getTemplateBindings().add(symbol_634);
		}
		symbol_152.getSuperClasses().add(symbol_185); // ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		symbol_152.getSuperClasses().add(symbol_149); // ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_152);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|OrderedCollection{T}?T]
		//
		symbol_153.setName("OrderedSet");
		symbol_153.setElementType(symbol_63);
		{
			TemplateBinding symbol_636 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_636.setSignature(symbol_65);
			{
				TemplateParameterSubstitution symbol_637 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_637.setFormal(symbol_66);	
				symbol_637.setActual(symbol_63);	
				symbol_636.getParameterSubstitutions().add(symbol_637);
			}
			symbol_153.getTemplateBindings().add(symbol_636);
		}
		symbol_153.getSuperClasses().add(symbol_146); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		symbol_153.getSuperClasses().add(symbol_179); // ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_153);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|Collection{T}?T]
		//
		symbol_154.setName("OrderedSet");
		symbol_154.setElementType(symbol_24);
		{
			TemplateBinding symbol_638 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_638.setSignature(symbol_65);
			{
				TemplateParameterSubstitution symbol_639 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_639.setFormal(symbol_66);	
				symbol_639.setActual(symbol_24);	
				symbol_638.getParameterSubstitutions().add(symbol_639);
			}
			symbol_154.getTemplateBindings().add(symbol_638);
		}
		symbol_154.getSuperClasses().add(symbol_180); // ocl|UniqueCollection[ocl|Collection{T}?T]
		symbol_154.getSuperClasses().add(symbol_150); // ocl|OrderedCollection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_154);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|OrderedSet{T}?T]
		//
		symbol_155.setName("OrderedSet");
		symbol_155.setElementType(symbol_67);
		{
			TemplateBinding symbol_640 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_640.setSignature(symbol_65);
			{
				TemplateParameterSubstitution symbol_641 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_641.setFormal(symbol_66);	
				symbol_641.setActual(symbol_67);	
				symbol_640.getParameterSubstitutions().add(symbol_641);
			}
			symbol_155.getTemplateBindings().add(symbol_640);
		}
		symbol_155.getSuperClasses().add(symbol_144); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		symbol_155.getSuperClasses().add(symbol_181); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_92.getOwnedTypes().add(symbol_155);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_156.setName("Sequence");
		symbol_156.setElementType(symbol_78);
		{
			TemplateBinding symbol_642 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_642.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_643 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_643.setFormal(symbol_74);	
				symbol_643.setActual(symbol_78);	
				symbol_642.getParameterSubstitutions().add(symbol_643);
			}
			symbol_156.getTemplateBindings().add(symbol_642);
		}
		symbol_156.getSuperClasses().add(symbol_142); // ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_156.getSuperClasses().add(symbol_151); // ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_156);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Collection{T}?T]
		//
		symbol_157.setName("Sequence");
		symbol_157.setElementType(symbol_24);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_74);	
				symbol_645.setActual(symbol_24);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_157.getTemplateBindings().add(symbol_644);
		}
		symbol_157.getSuperClasses().add(symbol_135); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		symbol_157.getSuperClasses().add(symbol_150); // ocl|OrderedCollection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_157);
		//
		// ocl::orphanage::Sequence ocl|Sequence[String]
		//
		symbol_158.setName("Sequence");
		symbol_158.setElementType(symbol_86);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_74);	
				symbol_647.setActual(symbol_86);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_158.getTemplateBindings().add(symbol_646);
		}
		symbol_158.getSuperClasses().add(symbol_145); // ocl|OrderedCollection[String]
		symbol_158.getSuperClasses().add(symbol_138); // ocl|NonUniqueCollection[String]
		symbol_92.getOwnedTypes().add(symbol_158);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|NonUniqueCollection{T}?T]
		//
		symbol_159.setName("Sequence");
		symbol_159.setElementType(symbol_49);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_74);	
				symbol_649.setActual(symbol_49);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_159.getTemplateBindings().add(symbol_648);
		}
		symbol_159.getSuperClasses().add(symbol_143); // ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		symbol_159.getSuperClasses().add(symbol_148); // ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_159);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Sequence{T}?T]
		//
		symbol_160.setName("Sequence");
		symbol_160.setElementType(symbol_75);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_74);	
				symbol_651.setActual(symbol_75);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_160.getTemplateBindings().add(symbol_650);
		}
		symbol_160.getSuperClasses().add(symbol_141); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		symbol_160.getSuperClasses().add(symbol_147); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		symbol_92.getOwnedTypes().add(symbol_160);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|OrderedCollection{T}?T]
		//
		symbol_161.setName("Sequence");
		symbol_161.setElementType(symbol_63);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_74);	
				symbol_653.setActual(symbol_63);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_161.getTemplateBindings().add(symbol_652);
		}
		symbol_161.getSuperClasses().add(symbol_146); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		symbol_161.getSuperClasses().add(symbol_139); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_161);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclAny]
		//
		symbol_162.setName("Set");
		symbol_162.setElementType(symbol_50);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_81);	
				symbol_655.setActual(symbol_50);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_162.getTemplateBindings().add(symbol_654);
		}
		symbol_162.getSuperClasses().add(symbol_130); // ocl|NonOrderedCollection[ocl|OclAny]
		symbol_162.getSuperClasses().add(symbol_177); // ocl|UniqueCollection[ocl|OclAny]
		symbol_92.getOwnedTypes().add(symbol_162);
		//
		// ocl::orphanage::Set ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_163.setName("Set");
		symbol_163.setElementType(symbol_174);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_81);	
				symbol_657.setActual(symbol_174);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_163.getTemplateBindings().add(symbol_656);
		}
		symbol_163.getSuperClasses().add(symbol_133); // ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_163.getSuperClasses().add(symbol_186); // ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_92.getOwnedTypes().add(symbol_163);
		//
		// ocl::orphanage::Set ocl|Set[ocl|NonOrderedCollection{T}?T]
		//
		symbol_164.setName("Set");
		symbol_164.setElementType(symbol_45);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_81);	
				symbol_659.setActual(symbol_45);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_164.getTemplateBindings().add(symbol_658);
		}
		symbol_164.getSuperClasses().add(symbol_178); // ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		symbol_164.getSuperClasses().add(symbol_121); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_164);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OrderedSet{T}?T]
		//
		symbol_165.setName("Set");
		symbol_165.setElementType(symbol_67);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_81);	
				symbol_661.setActual(symbol_67);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_165.getTemplateBindings().add(symbol_660);
		}
		symbol_165.getSuperClasses().add(symbol_181); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_165.getSuperClasses().add(symbol_124); // ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		symbol_92.getOwnedTypes().add(symbol_165);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclSelf]
		//
		symbol_166.setName("Set");
		symbol_166.setElementType(symbol_56);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_81);	
				symbol_663.setActual(symbol_56);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_166.getTemplateBindings().add(symbol_662);
		}
		symbol_166.getSuperClasses().add(symbol_125); // ocl|NonOrderedCollection[ocl|OclSelf]
		symbol_166.getSuperClasses().add(symbol_189); // ocl|UniqueCollection[ocl|OclSelf]
		symbol_92.getOwnedTypes().add(symbol_166);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_167.setName("Set");
		symbol_167.setElementType(symbol_85);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_81);	
				symbol_665.setActual(symbol_85);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_167.getTemplateBindings().add(symbol_664);
		}
		symbol_167.getSuperClasses().add(symbol_129); // ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_167.getSuperClasses().add(symbol_187); // ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_167);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Set{T}?T]
		//
		symbol_168.setName("Set");
		symbol_168.setElementType(symbol_82);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_81);	
				symbol_667.setActual(symbol_82);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_168.getTemplateBindings().add(symbol_666);
		}
		symbol_168.getSuperClasses().add(symbol_134); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		symbol_168.getSuperClasses().add(symbol_183); // ocl|UniqueCollection[ocl|Set{T}?T]
		symbol_92.getOwnedTypes().add(symbol_168);
		//
		// ocl::orphanage::Set ocl|Set[Boolean]
		//
		symbol_169.setName("Set");
		symbol_169.setElementType(symbol_19);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_81);	
				symbol_669.setActual(symbol_19);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_169.getTemplateBindings().add(symbol_668);
		}
		symbol_169.getSuperClasses().add(symbol_123); // ocl|NonOrderedCollection[Boolean]
		symbol_169.getSuperClasses().add(symbol_184); // ocl|UniqueCollection[Boolean]
		symbol_92.getOwnedTypes().add(symbol_169);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Enumeration]
		//
		symbol_170.setName("Set");
		symbol_170.setElementType(symbol_40);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_81);	
				symbol_671.setActual(symbol_40);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_170.getTemplateBindings().add(symbol_670);
		}
		symbol_170.getSuperClasses().add(symbol_188); // ocl|UniqueCollection[ocl|Enumeration]
		symbol_170.getSuperClasses().add(symbol_131); // ocl|NonOrderedCollection[ocl|Enumeration]
		symbol_92.getOwnedTypes().add(symbol_170);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclInvalid]
		//
		symbol_171.setName("Set");
		symbol_171.setElementType(symbol_54);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_81);	
				symbol_673.setActual(symbol_54);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_171.getTemplateBindings().add(symbol_672);
		}
		symbol_171.getSuperClasses().add(symbol_126); // ocl|NonOrderedCollection[ocl|OclInvalid]
		symbol_171.getSuperClasses().add(symbol_182); // ocl|UniqueCollection[ocl|OclInvalid]
		symbol_92.getOwnedTypes().add(symbol_171);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Collection{T}?T]
		//
		symbol_172.setName("Set");
		symbol_172.setElementType(symbol_24);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_81);	
				symbol_675.setActual(symbol_24);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_172.getTemplateBindings().add(symbol_674);
		}
		symbol_172.getSuperClasses().add(symbol_180); // ocl|UniqueCollection[ocl|Collection{T}?T]
		symbol_172.getSuperClasses().add(symbol_132); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_172);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclVoid]
		//
		symbol_173.setName("Set");
		symbol_173.setElementType(symbol_59);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_80);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_81);	
				symbol_677.setActual(symbol_59);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_173.getTemplateBindings().add(symbol_676);
		}
		symbol_173.getSuperClasses().add(symbol_122); // ocl|NonOrderedCollection[ocl|OclVoid]
		symbol_173.getSuperClasses().add(symbol_190); // ocl|UniqueCollection[ocl|OclVoid]
		symbol_92.getOwnedTypes().add(symbol_173);
		//
		// ocl::orphanage::Tuple Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}
		//
		symbol_174.setName("Tuple");
		{ // ocl::orphanage::Tuple::first Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|first
			symbol_175.setName("first");
			symbol_175.setType(symbol_24);  // ocl|Collection{T}?T
			
			symbol_175.setIsResolveProxies(true);
			symbol_174.getOwnedAttributes().add(symbol_175);
		}
		{ // ocl::orphanage::Tuple::second Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|second
			symbol_176.setName("second");
			symbol_176.setType(symbol_39);  // ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2
			
			symbol_176.setIsResolveProxies(true);
			symbol_174.getOwnedAttributes().add(symbol_176);
		}
		symbol_92.getOwnedTypes().add(symbol_174);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclAny]
		//
		symbol_177.setName("UniqueCollection");
		symbol_177.setElementType(symbol_50);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_89);	
				symbol_679.setActual(symbol_50);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_177.getTemplateBindings().add(symbol_678);
		}
		symbol_177.getSuperClasses().add(symbol_100); // ocl|Collection[ocl|OclAny]
		symbol_92.getOwnedTypes().add(symbol_177);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_178.setName("UniqueCollection");
		symbol_178.setElementType(symbol_45);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_89);	
				symbol_681.setActual(symbol_45);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_178.getTemplateBindings().add(symbol_680);
		}
		symbol_178.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_178);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_179.setName("UniqueCollection");
		symbol_179.setElementType(symbol_63);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_89);	
				symbol_683.setActual(symbol_63);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_179.getTemplateBindings().add(symbol_682);
		}
		symbol_179.getSuperClasses().add(symbol_106); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_179);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Collection{T}?T]
		//
		symbol_180.setName("UniqueCollection");
		symbol_180.setElementType(symbol_24);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_89);	
				symbol_685.setActual(symbol_24);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_180.getTemplateBindings().add(symbol_684);
		}
		symbol_180.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|Collection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_180);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		//
		symbol_181.setName("UniqueCollection");
		symbol_181.setElementType(symbol_67);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_89);	
				symbol_687.setActual(symbol_67);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_181.getTemplateBindings().add(symbol_686);
		}
		symbol_181.getSuperClasses().add(symbol_97); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_92.getOwnedTypes().add(symbol_181);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclInvalid]
		//
		symbol_182.setName("UniqueCollection");
		symbol_182.setElementType(symbol_54);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_89);	
				symbol_689.setActual(symbol_54);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_182.getTemplateBindings().add(symbol_688);
		}
		symbol_182.getSuperClasses().add(symbol_118); // ocl|Collection[ocl|OclInvalid]
		symbol_92.getOwnedTypes().add(symbol_182);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Set{T}?T]
		//
		symbol_183.setName("UniqueCollection");
		symbol_183.setElementType(symbol_82);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_89);	
				symbol_691.setActual(symbol_82);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_183.getTemplateBindings().add(symbol_690);
		}
		symbol_183.getSuperClasses().add(symbol_105); // ocl|Collection[ocl|Set{T}?T]
		symbol_92.getOwnedTypes().add(symbol_183);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[Boolean]
		//
		symbol_184.setName("UniqueCollection");
		symbol_184.setElementType(symbol_19);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_89);	
				symbol_693.setActual(symbol_19);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_184.getTemplateBindings().add(symbol_692);
		}
		symbol_184.getSuperClasses().add(symbol_99); // ocl|Collection[Boolean]
		symbol_92.getOwnedTypes().add(symbol_184);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		//
		symbol_185.setName("UniqueCollection");
		symbol_185.setElementType(symbol_90);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_89);	
				symbol_695.setActual(symbol_90);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_185.getTemplateBindings().add(symbol_694);
		}
		symbol_185.getSuperClasses().add(symbol_104); // ocl|Collection[ocl|UniqueCollection{T}?T]
		symbol_92.getOwnedTypes().add(symbol_185);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_186.setName("UniqueCollection");
		symbol_186.setElementType(symbol_174);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_89);	
				symbol_697.setActual(symbol_174);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_186.getTemplateBindings().add(symbol_696);
		}
		symbol_186.getSuperClasses().add(symbol_101); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_92.getOwnedTypes().add(symbol_186);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_187.setName("UniqueCollection");
		symbol_187.setElementType(symbol_85);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_89);	
				symbol_699.setActual(symbol_85);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_187.getTemplateBindings().add(symbol_698);
		}
		symbol_187.getSuperClasses().add(symbol_103); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_92.getOwnedTypes().add(symbol_187);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Enumeration]
		//
		symbol_188.setName("UniqueCollection");
		symbol_188.setElementType(symbol_40);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_89);	
				symbol_701.setActual(symbol_40);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_188.getTemplateBindings().add(symbol_700);
		}
		symbol_188.getSuperClasses().add(symbol_113); // ocl|Collection[ocl|Enumeration]
		symbol_92.getOwnedTypes().add(symbol_188);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclSelf]
		//
		symbol_189.setName("UniqueCollection");
		symbol_189.setElementType(symbol_56);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_89);	
				symbol_703.setActual(symbol_56);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_189.getTemplateBindings().add(symbol_702);
		}
		symbol_189.getSuperClasses().add(symbol_107); // ocl|Collection[ocl|OclSelf]
		symbol_92.getOwnedTypes().add(symbol_189);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclVoid]
		//
		symbol_190.setName("UniqueCollection");
		symbol_190.setElementType(symbol_59);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_89);	
				symbol_705.setActual(symbol_59);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_190.getTemplateBindings().add(symbol_704);
		}
		symbol_190.getSuperClasses().add(symbol_108); // ocl|Collection[ocl|OclVoid]
		symbol_92.getOwnedTypes().add(symbol_190);
		symbol_1.getNestedPackages().add(symbol_92);
		return symbol_1;
	}
}
