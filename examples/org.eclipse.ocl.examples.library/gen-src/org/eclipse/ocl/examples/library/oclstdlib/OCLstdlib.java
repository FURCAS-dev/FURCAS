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
 * $Id: OCLstdlib.java,v 1.4 2011/02/08 17:47:34 ewillink Exp $
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
		TemplateSignature symbol_21 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Classifier|allInstances{OclSelf}()|
		TypeTemplateParameter symbol_22 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_23 = PivotFactory.eINSTANCE.createClass(); // ocl|Classifier|allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_24 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection{T}
		TemplateSignature symbol_25 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|
		TypeTemplateParameter symbol_26 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_27 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}?T
		
		TemplateSignature symbol_28 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_29 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_30 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2
		
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|flatten{T2}()|
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|flatten{T2}()?T2
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)|
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|product{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2
		
		
		Class symbol_43 = PivotFactory.eINSTANCE.createClass(); // ocl|Enumeration
		
		PrimitiveType symbol_44 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_45 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection{T}
		TemplateSignature symbol_46 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonOrderedCollection{T}|
		TypeTemplateParameter symbol_47 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // ocl|NonOrderedCollection{T}?T
		
		
		CollectionType symbol_49 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection{T}
		TemplateSignature symbol_50 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonUniqueCollection{T}|
		TypeTemplateParameter symbol_51 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_52 = PivotFactory.eINSTANCE.createClass(); // ocl|NonUniqueCollection{T}?T
		
		
		AnyType symbol_53 = PivotFactory.eINSTANCE.createAnyType(); // ocl|OclAny
		TemplateSignature symbol_54 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclAsSet{OclSelf}()|
		TypeTemplateParameter symbol_55 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_56 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_57 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclAsType{T}(ocl|Classifier)|
		TypeTemplateParameter symbol_58 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_59 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclAsType{T}(ocl|Classifier)?T
		
		TemplateSignature symbol_60 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclType{OclSelf}()|
		TypeTemplateParameter symbol_61 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_62 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclType{OclSelf}()?OclSelf
		
		
		InvalidType symbol_63 = PivotFactory.eINSTANCE.createInvalidType(); // ocl|OclInvalid
		
		Class symbol_64 = PivotFactory.eINSTANCE.createClass(); // ocl|OclMessage
		
		Class symbol_65 = PivotFactory.eINSTANCE.createClass(); // ocl|OclState
		
		Class symbol_66 = PivotFactory.eINSTANCE.createClass(); // ocl|OclTuple
		
		VoidType symbol_67 = PivotFactory.eINSTANCE.createVoidType(); // ocl|OclVoid
		
		CollectionType symbol_68 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection{T}
		TemplateSignature symbol_69 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedCollection{T}|
		TypeTemplateParameter symbol_70 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_71 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedCollection{T}?T
		
		
		OrderedSetType symbol_72 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet{T}
		TemplateSignature symbol_73 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedSet{T}|
		TypeTemplateParameter symbol_74 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_75 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedSet{T}?T
		
		
		PrimitiveType symbol_76 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_77 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real|oclAsType{T}(ocl|Classifier)|
		TypeTemplateParameter symbol_78 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_79 = PivotFactory.eINSTANCE.createClass(); // Real|oclAsType{T}(ocl|Classifier)?T
		
		
		SequenceType symbol_80 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence{T}
		TemplateSignature symbol_81 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Sequence{T}|
		TypeTemplateParameter symbol_82 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // ocl|Sequence{T}?T
		
		TemplateSignature symbol_84 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Sequence{T}|flatten{T2}()|
		TypeTemplateParameter symbol_85 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // ocl|Sequence{T}|flatten{T2}()?T2
		
		
		SetType symbol_87 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set{T}
		TemplateSignature symbol_88 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Set{T}|
		TypeTemplateParameter symbol_89 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_90 = PivotFactory.eINSTANCE.createClass(); // ocl|Set{T}?T
		
		TemplateSignature symbol_91 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Set{T}|flatten{T2}()|
		TypeTemplateParameter symbol_92 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_93 = PivotFactory.eINSTANCE.createClass(); // ocl|Set{T}|flatten{T2}()?T2
		
		
		PrimitiveType symbol_94 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_95 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection{T}
		TemplateSignature symbol_96 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|UniqueCollection{T}|
		TypeTemplateParameter symbol_97 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_98 = PivotFactory.eINSTANCE.createClass(); // ocl|UniqueCollection{T}?T
		
		
		PrimitiveType symbol_99 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_100 = PivotFactory.eINSTANCE.createPackage(); // ocl|orphanage
		BagType symbol_101 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|NonOrderedCollection{T}?T]
		
		BagType symbol_102 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Collection{T}?T]
		
		BagType symbol_103 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
		
		BagType symbol_104 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Bag{T}?T]
		
		CollectionType symbol_105 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
		
		CollectionType symbol_106 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_107 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Bag{T}?T]
		
		CollectionType symbol_108 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_109 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Set{T}?T]
		
		CollectionType symbol_110 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_111 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Enumeration]
		
		CollectionType symbol_112 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_113 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_114 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_115 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}?T]
		
		CollectionType symbol_116 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_117 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_118 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclAny]
		
		CollectionType symbol_119 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_120 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[String]
		
		CollectionType symbol_121 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_122 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_123 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_124 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_125 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclInvalid]
		
		CollectionType symbol_126 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Sequence{T}?T]
		
		CollectionType symbol_127 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclVoid]
		
		CollectionType symbol_128 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[Boolean]
		
		CollectionType symbol_129 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_130 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_131 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		
		CollectionType symbol_132 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_133 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_134 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Enumeration]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclVoid]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclAny]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[Boolean]
		
		CollectionType symbol_140 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_141 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_142 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_143 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclInvalid]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[String]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[String]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		OrderedSetType symbol_162 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|OrderedSet{T}?T]
		
		OrderedSetType symbol_163 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|OrderedCollection{T}?T]
		
		OrderedSetType symbol_164 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|Collection{T}?T]
		
		OrderedSetType symbol_165 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|UniqueCollection{T}?T]
		
		SequenceType symbol_166 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|NonUniqueCollection{T}?T]
		
		SequenceType symbol_167 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Collection{T}?T]
		
		SequenceType symbol_168 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|OrderedCollection{T}?T]
		
		SequenceType symbol_169 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[String]
		
		SequenceType symbol_170 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
		
		SequenceType symbol_171 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Sequence{T}?T]
		
		SetType symbol_172 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		SetType symbol_173 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Collection{T}?T]
		
		SetType symbol_174 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
		
		SetType symbol_175 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclVoid]
		
		SetType symbol_176 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OrderedSet{T}?T]
		
		SetType symbol_177 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclAny]
		
		SetType symbol_178 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Set{T}?T]
		
		SetType symbol_179 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_180 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[Boolean]
		
		SetType symbol_181 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Enumeration]
		
		SetType symbol_182 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_183 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|NonOrderedCollection{T}?T]
		
		SetType symbol_184 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclInvalid]
		
		TupleType symbol_185 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}
		Property symbol_186 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::first Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|first
		Property symbol_187 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::second Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|second
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_193 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Set{T}?T]
		
		CollectionType symbol_194 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_195 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclVoid]
		
		CollectionType symbol_196 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[Boolean]
		
		CollectionType symbol_197 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_198 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_199 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Enumeration]
		
		CollectionType symbol_200 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_201 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclAny]
		
		CollectionType symbol_202 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclInvalid]
		
		

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
		symbol_12.getSuperClasses().add(symbol_143); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_153); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		{	// ocl::Bag::<>() ocl|Bag{T}|<>(ocl|OclAny)
			Operation symbol_203 = PivotFactory.eINSTANCE.createOperation();
			symbol_203.setName("<>");
			symbol_203.setType(symbol_19);  // Boolean
			symbol_203.setLower(BigInteger.valueOf(0));
			symbol_203.setIsUnique(false);
			
			Parameter symbol_204 = PivotFactory.eINSTANCE.createParameter();
			symbol_204.setName("object2");
			symbol_204.setType(symbol_53);  // ocl|OclAny
			symbol_204.setLower(BigInteger.valueOf(0));
			symbol_204.setIsUnique(false);
			
			symbol_203.getOwnedParameters().add(symbol_204);
			symbol_203.setPrecedence(symbol_7);
			symbol_203.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_203);
		}
		{	// ocl::Bag::=() ocl|Bag{T}|=(ocl|OclAny)
			Operation symbol_205 = PivotFactory.eINSTANCE.createOperation();
			symbol_205.setName("=");
			symbol_205.setType(symbol_19);  // Boolean
			symbol_205.setLower(BigInteger.valueOf(0));
			symbol_205.setIsUnique(false);
			
			Parameter symbol_206 = PivotFactory.eINSTANCE.createParameter();
			symbol_206.setName("object2");
			symbol_206.setType(symbol_53);  // ocl|OclAny
			symbol_206.setLower(BigInteger.valueOf(0));
			symbol_206.setIsUnique(false);
			
			symbol_205.getOwnedParameters().add(symbol_206);
			symbol_205.setPrecedence(symbol_7);
			symbol_205.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_205);
		}
		{	// ocl::Bag::excluding() ocl|Bag{T}|excluding(ocl|OclAny)
			Operation symbol_207 = PivotFactory.eINSTANCE.createOperation();
			symbol_207.setName("excluding");
			symbol_207.setType(symbol_104);  // ocl|Bag[ocl|Bag{T}?T]
			symbol_207.setLower(BigInteger.valueOf(0));
			symbol_207.setIsUnique(false);
			
			Parameter symbol_208 = PivotFactory.eINSTANCE.createParameter();
			symbol_208.setName("object");
			symbol_208.setType(symbol_53);  // ocl|OclAny
			symbol_208.setLower(BigInteger.valueOf(0));
			symbol_208.setIsUnique(false);
			
			symbol_207.getOwnedParameters().add(symbol_208);
			symbol_207.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_207);
		}
		{	// ocl::Bag::flatten() ocl|Bag{T}|flatten{T2}()
			Operation symbol_209 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_209.setOwnedTemplateSignature(symbol_16);
			symbol_209.setName("flatten");
			symbol_209.setType(symbol_103);  // ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
			symbol_209.setLower(BigInteger.valueOf(0));
			symbol_209.setIsUnique(false);
			
			symbol_209.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_209);
		}
		{	// ocl::Bag::including() ocl|Bag{T}|including(ocl|Bag{T}?T)
			Operation symbol_210 = PivotFactory.eINSTANCE.createOperation();
			symbol_210.setName("including");
			symbol_210.setType(symbol_104);  // ocl|Bag[ocl|Bag{T}?T]
			symbol_210.setLower(BigInteger.valueOf(0));
			symbol_210.setIsUnique(false);
			
			Parameter symbol_211 = PivotFactory.eINSTANCE.createParameter();
			symbol_211.setName("object");
			symbol_211.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_211.setLower(BigInteger.valueOf(0));
			symbol_211.setIsUnique(false);
			
			symbol_210.getOwnedParameters().add(symbol_211);
			symbol_210.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_210);
		}
		{	// ocl::Bag::reject() ocl|Bag{T}|reject(ocl|Bag{T}?T)
			Iteration symbol_212 = PivotFactory.eINSTANCE.createIteration();
			symbol_212.setName("reject");
			symbol_212.setType(symbol_104);  // ocl|Bag[ocl|Bag{T}?T]
			
			Parameter symbol_213 = PivotFactory.eINSTANCE.createParameter();
			symbol_213.setName("i");
			symbol_213.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_212.getOwnedIterators().add(symbol_213);
			symbol_212.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_212);
		}
		{	// ocl::Bag::select() ocl|Bag{T}|select(ocl|Bag{T}?T)
			Iteration symbol_214 = PivotFactory.eINSTANCE.createIteration();
			symbol_214.setName("select");
			symbol_214.setType(symbol_104);  // ocl|Bag[ocl|Bag{T}?T]
			
			Parameter symbol_215 = PivotFactory.eINSTANCE.createParameter();
			symbol_215.setName("i");
			symbol_215.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_214.getOwnedIterators().add(symbol_215);
			symbol_214.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_214);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		symbol_19.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::Boolean::<>() Boolean|<>(ocl|OclAny)
			Operation symbol_216 = PivotFactory.eINSTANCE.createOperation();
			symbol_216.setName("<>");
			symbol_216.setType(symbol_19);  // Boolean
			symbol_216.setLower(BigInteger.valueOf(0));
			symbol_216.setIsUnique(false);
			
			Parameter symbol_217 = PivotFactory.eINSTANCE.createParameter();
			symbol_217.setName("object2");
			symbol_217.setType(symbol_53);  // ocl|OclAny
			symbol_217.setLower(BigInteger.valueOf(0));
			symbol_217.setIsUnique(false);
			
			symbol_216.getOwnedParameters().add(symbol_217);
			symbol_216.setPrecedence(symbol_7);
			symbol_216.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_216);
		}
		{	// ocl::Boolean::=() Boolean|=(ocl|OclAny)
			Operation symbol_218 = PivotFactory.eINSTANCE.createOperation();
			symbol_218.setName("=");
			symbol_218.setType(symbol_19);  // Boolean
			symbol_218.setLower(BigInteger.valueOf(0));
			symbol_218.setIsUnique(false);
			
			Parameter symbol_219 = PivotFactory.eINSTANCE.createParameter();
			symbol_219.setName("object2");
			symbol_219.setType(symbol_53);  // ocl|OclAny
			symbol_219.setLower(BigInteger.valueOf(0));
			symbol_219.setIsUnique(false);
			
			symbol_218.getOwnedParameters().add(symbol_219);
			symbol_218.setPrecedence(symbol_7);
			symbol_218.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_218);
		}
		{	// ocl::Boolean::allInstances() Boolean|allInstances()
			Operation symbol_220 = PivotFactory.eINSTANCE.createOperation();
			symbol_220.setName("allInstances");
			symbol_220.setType(symbol_180);  // ocl|Set[Boolean]
			symbol_220.setLower(BigInteger.valueOf(0));
			symbol_220.setIsUnique(false);
			
			symbol_220.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_220);
		}
		{	// ocl::Boolean::and() Boolean|and(Boolean)
			Operation symbol_221 = PivotFactory.eINSTANCE.createOperation();
			symbol_221.setName("and");
			symbol_221.setType(symbol_19);  // Boolean
			symbol_221.setLower(BigInteger.valueOf(0));
			symbol_221.setIsUnique(false);
			
			Parameter symbol_222 = PivotFactory.eINSTANCE.createParameter();
			symbol_222.setName("b");
			symbol_222.setType(symbol_19);  // Boolean
			symbol_222.setLower(BigInteger.valueOf(0));
			symbol_222.setIsUnique(false);
			
			symbol_221.getOwnedParameters().add(symbol_222);
			symbol_221.setPrecedence(symbol_8);
			symbol_221.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_221);
		}
		{	// ocl::Boolean::implies() Boolean|implies(Boolean)
			Operation symbol_223 = PivotFactory.eINSTANCE.createOperation();
			symbol_223.setName("implies");
			symbol_223.setType(symbol_19);  // Boolean
			symbol_223.setLower(BigInteger.valueOf(0));
			symbol_223.setIsUnique(false);
			
			Parameter symbol_224 = PivotFactory.eINSTANCE.createParameter();
			symbol_224.setName("b");
			symbol_224.setType(symbol_19);  // Boolean
			symbol_224.setLower(BigInteger.valueOf(0));
			symbol_224.setIsUnique(false);
			
			symbol_223.getOwnedParameters().add(symbol_224);
			symbol_223.setPrecedence(symbol_11);
			symbol_223.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_223);
		}
		{	// ocl::Boolean::not() Boolean|not()
			Operation symbol_225 = PivotFactory.eINSTANCE.createOperation();
			symbol_225.setName("not");
			symbol_225.setType(symbol_19);  // Boolean
			symbol_225.setLower(BigInteger.valueOf(0));
			symbol_225.setIsUnique(false);
			
			symbol_225.setPrecedence(symbol_3);
			symbol_225.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_225);
		}
		{	// ocl::Boolean::or() Boolean|or(Boolean)
			Operation symbol_226 = PivotFactory.eINSTANCE.createOperation();
			symbol_226.setName("or");
			symbol_226.setType(symbol_19);  // Boolean
			symbol_226.setLower(BigInteger.valueOf(0));
			symbol_226.setIsUnique(false);
			
			Parameter symbol_227 = PivotFactory.eINSTANCE.createParameter();
			symbol_227.setName("b");
			symbol_227.setType(symbol_19);  // Boolean
			symbol_227.setLower(BigInteger.valueOf(0));
			symbol_227.setIsUnique(false);
			
			symbol_226.getOwnedParameters().add(symbol_227);
			symbol_226.setPrecedence(symbol_9);
			symbol_226.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_226);
		}
		{	// ocl::Boolean::toString() Boolean|toString()
			Operation symbol_228 = PivotFactory.eINSTANCE.createOperation();
			symbol_228.setName("toString");
			symbol_228.setType(symbol_94);  // String
			symbol_228.setLower(BigInteger.valueOf(0));
			symbol_228.setIsUnique(false);
			
			symbol_228.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_228);
		}
		{	// ocl::Boolean::xor() Boolean|xor(Boolean)
			Operation symbol_229 = PivotFactory.eINSTANCE.createOperation();
			symbol_229.setName("xor");
			symbol_229.setType(symbol_19);  // Boolean
			symbol_229.setLower(BigInteger.valueOf(0));
			symbol_229.setIsUnique(false);
			
			Parameter symbol_230 = PivotFactory.eINSTANCE.createParameter();
			symbol_230.setName("b");
			symbol_230.setType(symbol_19);  // Boolean
			symbol_230.setLower(BigInteger.valueOf(0));
			symbol_230.setIsUnique(false);
			
			symbol_229.getOwnedParameters().add(symbol_230);
			symbol_229.setPrecedence(symbol_10);
			symbol_229.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_229);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl|Classifier
		//
		symbol_20.setName("Classifier");
		symbol_20.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::Classifier::allInstances() ocl|Classifier|allInstances{OclSelf}()
			Operation symbol_231 = PivotFactory.eINSTANCE.createOperation();
			symbol_23.setName("OclSelf");
			symbol_22.setOwnedParameteredElement(symbol_23);
			symbol_21.getOwnedParameters().add(symbol_22);
			
			symbol_231.setOwnedTemplateSignature(symbol_21);
			symbol_231.setName("allInstances");
			symbol_231.setType(symbol_179);  // ocl|Set[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
			symbol_231.setLower(BigInteger.valueOf(0));
			symbol_231.setIsUnique(false);
			
			symbol_231.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_231);
		}
		symbol_1.getOwnedTypes().add(symbol_20);
		//
		// ocl::Collection ocl|Collection{T}
		//
		symbol_24.setName("Collection");
		symbol_24.setElementType(symbol_27);
		symbol_27.setName("T");
		symbol_26.setOwnedParameteredElement(symbol_27);
		symbol_25.getOwnedParameters().add(symbol_26);
		
		symbol_24.setOwnedTemplateSignature(symbol_25);
		symbol_24.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::Collection::<>() ocl|Collection{T}|<>(ocl|OclAny)
			Operation symbol_232 = PivotFactory.eINSTANCE.createOperation();
			symbol_232.setName("<>");
			symbol_232.setType(symbol_19);  // Boolean
			symbol_232.setLower(BigInteger.valueOf(0));
			symbol_232.setIsUnique(false);
			
			Parameter symbol_233 = PivotFactory.eINSTANCE.createParameter();
			symbol_233.setName("object2");
			symbol_233.setType(symbol_53);  // ocl|OclAny
			symbol_233.setLower(BigInteger.valueOf(0));
			symbol_233.setIsUnique(false);
			
			symbol_232.getOwnedParameters().add(symbol_233);
			symbol_232.setPrecedence(symbol_7);
			symbol_232.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_232);
		}
		{	// ocl::Collection::=() ocl|Collection{T}|=(ocl|OclAny)
			Operation symbol_234 = PivotFactory.eINSTANCE.createOperation();
			symbol_234.setName("=");
			symbol_234.setType(symbol_19);  // Boolean
			symbol_234.setLower(BigInteger.valueOf(0));
			symbol_234.setIsUnique(false);
			
			Parameter symbol_235 = PivotFactory.eINSTANCE.createParameter();
			symbol_235.setName("object2");
			symbol_235.setType(symbol_53);  // ocl|OclAny
			symbol_235.setLower(BigInteger.valueOf(0));
			symbol_235.setIsUnique(false);
			
			symbol_234.getOwnedParameters().add(symbol_235);
			symbol_234.setPrecedence(symbol_7);
			symbol_234.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_234);
		}
		{	// ocl::Collection::any() ocl|Collection{T}|any(ocl|Collection{T}?T)
			Iteration symbol_236 = PivotFactory.eINSTANCE.createIteration();
			symbol_236.setName("any");
			symbol_236.setType(symbol_27);  // ocl|Collection{T}?T
			
			Parameter symbol_237 = PivotFactory.eINSTANCE.createParameter();
			symbol_237.setName("i");
			symbol_237.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_236.getOwnedIterators().add(symbol_237);
			symbol_236.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_236);
		}
		{	// ocl::Collection::asBag() ocl|Collection{T}|asBag()
			Operation symbol_238 = PivotFactory.eINSTANCE.createOperation();
			symbol_238.setName("asBag");
			symbol_238.setType(symbol_102);  // ocl|Bag[ocl|Collection{T}?T]
			symbol_238.setLower(BigInteger.valueOf(0));
			symbol_238.setIsUnique(false);
			
			symbol_238.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_238);
		}
		{	// ocl::Collection::asOrderedSet() ocl|Collection{T}|asOrderedSet()
			Operation symbol_239 = PivotFactory.eINSTANCE.createOperation();
			symbol_239.setName("asOrderedSet");
			symbol_239.setType(symbol_164);  // ocl|OrderedSet[ocl|Collection{T}?T]
			symbol_239.setLower(BigInteger.valueOf(0));
			symbol_239.setIsUnique(false);
			
			symbol_239.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_239);
		}
		{	// ocl::Collection::asSequence() ocl|Collection{T}|asSequence()
			Operation symbol_240 = PivotFactory.eINSTANCE.createOperation();
			symbol_240.setName("asSequence");
			symbol_240.setType(symbol_167);  // ocl|Sequence[ocl|Collection{T}?T]
			symbol_240.setLower(BigInteger.valueOf(0));
			symbol_240.setIsUnique(false);
			
			symbol_240.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_240);
		}
		{	// ocl::Collection::asSet() ocl|Collection{T}|asSet()
			Operation symbol_241 = PivotFactory.eINSTANCE.createOperation();
			symbol_241.setName("asSet");
			symbol_241.setType(symbol_173);  // ocl|Set[ocl|Collection{T}?T]
			symbol_241.setLower(BigInteger.valueOf(0));
			symbol_241.setIsUnique(false);
			
			symbol_241.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_241);
		}
		{	// ocl::Collection::collect() ocl|Collection{T}|collect(ocl|Collection{T}?T)
			Iteration symbol_242 = PivotFactory.eINSTANCE.createIteration();
			symbol_242.setName("collect");
			symbol_242.setType(symbol_115);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_243 = PivotFactory.eINSTANCE.createParameter();
			symbol_243.setName("i");
			symbol_243.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_242.getOwnedIterators().add(symbol_243);
			symbol_242.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_242);
		}
		{	// ocl::Collection::collectNested() ocl|Collection{T}|collectNested(ocl|Collection{T}?T)
			Iteration symbol_244 = PivotFactory.eINSTANCE.createIteration();
			symbol_244.setName("collectNested");
			symbol_244.setType(symbol_115);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_245 = PivotFactory.eINSTANCE.createParameter();
			symbol_245.setName("i");
			symbol_245.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_244.getOwnedIterators().add(symbol_245);
			symbol_244.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_244);
		}
		{	// ocl::Collection::count() ocl|Collection{T}|count(ocl|OclAny)
			Operation symbol_246 = PivotFactory.eINSTANCE.createOperation();
			symbol_246.setName("count");
			symbol_246.setType(symbol_44);  // Integer
			symbol_246.setLower(BigInteger.valueOf(0));
			symbol_246.setIsUnique(false);
			
			Parameter symbol_247 = PivotFactory.eINSTANCE.createParameter();
			symbol_247.setName("object");
			symbol_247.setType(symbol_53);  // ocl|OclAny
			symbol_247.setLower(BigInteger.valueOf(0));
			symbol_247.setIsUnique(false);
			
			symbol_246.getOwnedParameters().add(symbol_247);
			symbol_246.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_246);
		}
		{	// ocl::Collection::excludes() ocl|Collection{T}|excludes(ocl|OclAny)
			Operation symbol_248 = PivotFactory.eINSTANCE.createOperation();
			symbol_248.setName("excludes");
			symbol_248.setType(symbol_19);  // Boolean
			symbol_248.setLower(BigInteger.valueOf(0));
			symbol_248.setIsUnique(false);
			
			Parameter symbol_249 = PivotFactory.eINSTANCE.createParameter();
			symbol_249.setName("object");
			symbol_249.setType(symbol_53);  // ocl|OclAny
			symbol_249.setLower(BigInteger.valueOf(0));
			symbol_249.setIsUnique(false);
			
			symbol_248.getOwnedParameters().add(symbol_249);
			symbol_248.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_248);
		}
		{	// ocl::Collection::excludesAll() ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])
			Operation symbol_250 = PivotFactory.eINSTANCE.createOperation();
			symbol_30.setName("T2");
			symbol_29.setOwnedParameteredElement(symbol_30);
			symbol_28.getOwnedParameters().add(symbol_29);
			
			symbol_250.setOwnedTemplateSignature(symbol_28);
			symbol_250.setName("excludesAll");
			symbol_250.setType(symbol_19);  // Boolean
			symbol_250.setLower(BigInteger.valueOf(0));
			symbol_250.setIsUnique(false);
			
			Parameter symbol_251 = PivotFactory.eINSTANCE.createParameter();
			symbol_251.setName("c2");
			symbol_251.setType(symbol_110);  // ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
			symbol_251.setLower(BigInteger.valueOf(0));
			symbol_251.setIsUnique(false);
			
			symbol_250.getOwnedParameters().add(symbol_251);
			symbol_250.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_250);
		}
		{	// ocl::Collection::excluding() ocl|Collection{T}|excluding(ocl|OclAny)
			Operation symbol_252 = PivotFactory.eINSTANCE.createOperation();
			symbol_252.setName("excluding");
			symbol_252.setType(symbol_115);  // ocl|Collection[ocl|Collection{T}?T]
			symbol_252.setLower(BigInteger.valueOf(0));
			symbol_252.setIsUnique(false);
			
			Parameter symbol_253 = PivotFactory.eINSTANCE.createParameter();
			symbol_253.setName("object");
			symbol_253.setType(symbol_53);  // ocl|OclAny
			symbol_253.setLower(BigInteger.valueOf(0));
			symbol_253.setIsUnique(false);
			
			symbol_252.getOwnedParameters().add(symbol_253);
			symbol_252.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_252);
		}
		{	// ocl::Collection::exists() ocl|Collection{T}|exists(ocl|Collection{T}?T)
			Iteration symbol_254 = PivotFactory.eINSTANCE.createIteration();
			symbol_254.setName("exists");
			symbol_254.setType(symbol_19);  // Boolean
			
			Parameter symbol_255 = PivotFactory.eINSTANCE.createParameter();
			symbol_255.setName("i");
			symbol_255.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_254.getOwnedIterators().add(symbol_255);
			symbol_254.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_254);
		}
		{	// ocl::Collection::exists() ocl|Collection{T}|exists(ocl|Collection{T}?T,T)
			Iteration symbol_256 = PivotFactory.eINSTANCE.createIteration();
			symbol_256.setName("exists");
			symbol_256.setType(symbol_19);  // Boolean
			
			Parameter symbol_257 = PivotFactory.eINSTANCE.createParameter();
			symbol_257.setName("j");
			symbol_257.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_256.getOwnedIterators().add(symbol_257);
			Parameter symbol_258 = PivotFactory.eINSTANCE.createParameter();
			symbol_258.setName("i");
			symbol_258.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_256.getOwnedIterators().add(symbol_258);
			symbol_256.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_256);
		}
		{	// ocl::Collection::flatten() ocl|Collection{T}|flatten{T2}()
			Operation symbol_259 = PivotFactory.eINSTANCE.createOperation();
			symbol_33.setName("T2");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_259.setOwnedTemplateSignature(symbol_31);
			symbol_259.setName("flatten");
			symbol_259.setType(symbol_105);  // ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
			symbol_259.setLower(BigInteger.valueOf(0));
			symbol_259.setIsUnique(false);
			
			symbol_259.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_259);
		}
		{	// ocl::Collection::forAll() ocl|Collection{T}|forAll(ocl|Collection{T}?T)
			Iteration symbol_260 = PivotFactory.eINSTANCE.createIteration();
			symbol_260.setName("forAll");
			symbol_260.setType(symbol_19);  // Boolean
			
			Parameter symbol_261 = PivotFactory.eINSTANCE.createParameter();
			symbol_261.setName("i");
			symbol_261.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_260.getOwnedIterators().add(symbol_261);
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Collection::forAll() ocl|Collection{T}|forAll(ocl|Collection{T}?T,T)
			Iteration symbol_262 = PivotFactory.eINSTANCE.createIteration();
			symbol_262.setName("forAll");
			symbol_262.setType(symbol_19);  // Boolean
			
			Parameter symbol_263 = PivotFactory.eINSTANCE.createParameter();
			symbol_263.setName("j");
			symbol_263.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_262.getOwnedIterators().add(symbol_263);
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("i");
			symbol_264.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_262.getOwnedIterators().add(symbol_264);
			symbol_262.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_262);
		}
		{	// ocl::Collection::includes() ocl|Collection{T}|includes(ocl|OclAny)
			Operation symbol_265 = PivotFactory.eINSTANCE.createOperation();
			symbol_265.setName("includes");
			symbol_265.setType(symbol_19);  // Boolean
			symbol_265.setLower(BigInteger.valueOf(0));
			symbol_265.setIsUnique(false);
			
			Parameter symbol_266 = PivotFactory.eINSTANCE.createParameter();
			symbol_266.setName("object");
			symbol_266.setType(symbol_53);  // ocl|OclAny
			symbol_266.setLower(BigInteger.valueOf(0));
			symbol_266.setIsUnique(false);
			
			symbol_265.getOwnedParameters().add(symbol_266);
			symbol_265.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_265);
		}
		{	// ocl::Collection::includesAll() ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])
			Operation symbol_267 = PivotFactory.eINSTANCE.createOperation();
			symbol_36.setName("T2");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_267.setOwnedTemplateSignature(symbol_34);
			symbol_267.setName("includesAll");
			symbol_267.setType(symbol_19);  // Boolean
			symbol_267.setLower(BigInteger.valueOf(0));
			symbol_267.setIsUnique(false);
			
			Parameter symbol_268 = PivotFactory.eINSTANCE.createParameter();
			symbol_268.setName("c2");
			symbol_268.setType(symbol_112);  // ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
			symbol_268.setLower(BigInteger.valueOf(0));
			symbol_268.setIsUnique(false);
			
			symbol_267.getOwnedParameters().add(symbol_268);
			symbol_267.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_267);
		}
		{	// ocl::Collection::including() ocl|Collection{T}|including(ocl|Collection{T}?T)
			Operation symbol_269 = PivotFactory.eINSTANCE.createOperation();
			symbol_269.setName("including");
			symbol_269.setType(symbol_115);  // ocl|Collection[ocl|Collection{T}?T]
			symbol_269.setLower(BigInteger.valueOf(0));
			symbol_269.setIsUnique(false);
			
			Parameter symbol_270 = PivotFactory.eINSTANCE.createParameter();
			symbol_270.setName("object");
			symbol_270.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_270.setLower(BigInteger.valueOf(0));
			symbol_270.setIsUnique(false);
			
			symbol_269.getOwnedParameters().add(symbol_270);
			symbol_269.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_269);
		}
		{	// ocl::Collection::isEmpty() ocl|Collection{T}|isEmpty()
			Operation symbol_271 = PivotFactory.eINSTANCE.createOperation();
			symbol_271.setName("isEmpty");
			symbol_271.setType(symbol_19);  // Boolean
			symbol_271.setLower(BigInteger.valueOf(0));
			symbol_271.setIsUnique(false);
			
			symbol_271.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_271);
		}
		{	// ocl::Collection::isUnique() ocl|Collection{T}|isUnique(ocl|Collection{T}?T)
			Iteration symbol_272 = PivotFactory.eINSTANCE.createIteration();
			symbol_272.setName("isUnique");
			symbol_272.setType(symbol_19);  // Boolean
			
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("i");
			symbol_273.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_272.getOwnedIterators().add(symbol_273);
			symbol_272.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_272);
		}
		{	// ocl::Collection::iterate() ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)
			Iteration symbol_274 = PivotFactory.eINSTANCE.createIteration();
			symbol_39.setName("Tacc");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_274.setOwnedTemplateSignature(symbol_37);
			symbol_274.setName("iterate");
			symbol_274.setType(symbol_39);  // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
			
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("i");
			symbol_275.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_274.getOwnedIterators().add(symbol_275);
			Parameter symbol_276 = PivotFactory.eINSTANCE.createParameter();
			symbol_276.setName("acc");
			symbol_276.setType(symbol_39);  // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
			symbol_274.getOwnedAccumulators().add(symbol_276);
			symbol_274.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_274);
		}
		{	// ocl::Collection::max() ocl|Collection{T}|max()
			Operation symbol_277 = PivotFactory.eINSTANCE.createOperation();
			symbol_277.setName("max");
			symbol_277.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_277.setLower(BigInteger.valueOf(0));
			symbol_277.setIsUnique(false);
			
			symbol_277.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_277);
		}
		{	// ocl::Collection::min() ocl|Collection{T}|min()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_278.setName("min");
			symbol_278.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_278.setLower(BigInteger.valueOf(0));
			symbol_278.setIsUnique(false);
			
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Collection::notEmpty() ocl|Collection{T}|notEmpty()
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("notEmpty");
			symbol_279.setType(symbol_19);  // Boolean
			symbol_279.setLower(BigInteger.valueOf(0));
			symbol_279.setIsUnique(false);
			
			symbol_279.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_279);
		}
		{	// ocl::Collection::one() ocl|Collection{T}|one(ocl|Collection{T}?T)
			Iteration symbol_280 = PivotFactory.eINSTANCE.createIteration();
			symbol_280.setName("one");
			symbol_280.setType(symbol_19);  // Boolean
			
			Parameter symbol_281 = PivotFactory.eINSTANCE.createParameter();
			symbol_281.setName("i");
			symbol_281.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_280.getOwnedIterators().add(symbol_281);
			symbol_280.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_280);
		}
		{	// ocl::Collection::product() ocl|Collection{T}|product{T2}(ocl|Collection[T2])
			Operation symbol_282 = PivotFactory.eINSTANCE.createOperation();
			symbol_42.setName("T2");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_282.setOwnedTemplateSignature(symbol_40);
			symbol_282.setName("product");
			symbol_282.setType(symbol_172);  // ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
			symbol_282.setLower(BigInteger.valueOf(0));
			symbol_282.setIsUnique(false);
			
			Parameter symbol_283 = PivotFactory.eINSTANCE.createParameter();
			symbol_283.setName("c2");
			symbol_283.setType(symbol_124);  // ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
			symbol_283.setLower(BigInteger.valueOf(0));
			symbol_283.setIsUnique(false);
			
			symbol_282.getOwnedParameters().add(symbol_283);
			symbol_282.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_282);
		}
		{	// ocl::Collection::reject() ocl|Collection{T}|reject(ocl|Collection{T}?T)
			Iteration symbol_284 = PivotFactory.eINSTANCE.createIteration();
			symbol_284.setName("reject");
			symbol_284.setType(symbol_115);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_285 = PivotFactory.eINSTANCE.createParameter();
			symbol_285.setName("i");
			symbol_285.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_284.getOwnedIterators().add(symbol_285);
			symbol_284.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_284);
		}
		{	// ocl::Collection::select() ocl|Collection{T}|select(ocl|Collection{T}?T)
			Iteration symbol_286 = PivotFactory.eINSTANCE.createIteration();
			symbol_286.setName("select");
			symbol_286.setType(symbol_115);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_287 = PivotFactory.eINSTANCE.createParameter();
			symbol_287.setName("i");
			symbol_287.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_286.getOwnedIterators().add(symbol_287);
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Collection::size() ocl|Collection{T}|size()
			Operation symbol_288 = PivotFactory.eINSTANCE.createOperation();
			symbol_288.setName("size");
			symbol_288.setType(symbol_44);  // Integer
			symbol_288.setLower(BigInteger.valueOf(0));
			symbol_288.setIsUnique(false);
			
			symbol_288.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_288);
		}
		{	// ocl::Collection::sortedBy() ocl|Collection{T}|sortedBy(ocl|Collection{T}?T)
			Iteration symbol_289 = PivotFactory.eINSTANCE.createIteration();
			symbol_289.setName("sortedBy");
			symbol_289.setType(symbol_159);  // ocl|OrderedCollection[ocl|Collection{T}?T]
			
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("i");
			symbol_290.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_289.getOwnedIterators().add(symbol_290);
			symbol_289.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_289);
		}
		{	// ocl::Collection::sum() ocl|Collection{T}|sum()
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("sum");
			symbol_291.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_291.setLower(BigInteger.valueOf(0));
			symbol_291.setIsUnique(false);
			
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_291);
		}
		symbol_1.getOwnedTypes().add(symbol_24);
		//
		// ocl::Enumeration ocl|Enumeration
		//
		symbol_43.setName("Enumeration");
		symbol_43.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::Enumeration::allInstances() ocl|Enumeration|allInstances()
			Operation symbol_292 = PivotFactory.eINSTANCE.createOperation();
			symbol_292.setName("allInstances");
			symbol_292.setType(symbol_181);  // ocl|Set[ocl|Enumeration]
			symbol_292.setLower(BigInteger.valueOf(0));
			symbol_292.setIsUnique(false);
			
			symbol_292.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_43.getOwnedOperations().add(symbol_292);
		}
		symbol_1.getOwnedTypes().add(symbol_43);
		//
		// ocl::Integer Integer
		//
		symbol_44.setName("Integer");
		symbol_44.getSuperClasses().add(symbol_76); // Real
		{	// ocl::Integer::*() Integer|*(Integer)
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("*");
			symbol_293.setType(symbol_44);  // Integer
			symbol_293.setLower(BigInteger.valueOf(0));
			symbol_293.setIsUnique(false);
			
			Parameter symbol_294 = PivotFactory.eINSTANCE.createParameter();
			symbol_294.setName("i");
			symbol_294.setType(symbol_44);  // Integer
			symbol_294.setLower(BigInteger.valueOf(0));
			symbol_294.setIsUnique(false);
			
			symbol_293.getOwnedParameters().add(symbol_294);
			symbol_293.setPrecedence(symbol_4);
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Integer::+() Integer|+(Integer)
			Operation symbol_295 = PivotFactory.eINSTANCE.createOperation();
			symbol_295.setName("+");
			symbol_295.setType(symbol_44);  // Integer
			symbol_295.setLower(BigInteger.valueOf(0));
			symbol_295.setIsUnique(false);
			
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("i");
			symbol_296.setType(symbol_44);  // Integer
			symbol_296.setLower(BigInteger.valueOf(0));
			symbol_296.setIsUnique(false);
			
			symbol_295.getOwnedParameters().add(symbol_296);
			symbol_295.setPrecedence(symbol_5);
			symbol_295.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_295);
		}
		{	// ocl::Integer::-() Integer|-()
			Operation symbol_297 = PivotFactory.eINSTANCE.createOperation();
			symbol_297.setName("-");
			symbol_297.setType(symbol_44);  // Integer
			symbol_297.setLower(BigInteger.valueOf(0));
			symbol_297.setIsUnique(false);
			
			symbol_297.setPrecedence(symbol_3);
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_297);
		}
		{	// ocl::Integer::-() Integer|-(Integer)
			Operation symbol_298 = PivotFactory.eINSTANCE.createOperation();
			symbol_298.setName("-");
			symbol_298.setType(symbol_44);  // Integer
			symbol_298.setLower(BigInteger.valueOf(0));
			symbol_298.setIsUnique(false);
			
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("i");
			symbol_299.setType(symbol_44);  // Integer
			symbol_299.setLower(BigInteger.valueOf(0));
			symbol_299.setIsUnique(false);
			
			symbol_298.getOwnedParameters().add(symbol_299);
			symbol_298.setPrecedence(symbol_5);
			symbol_298.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_298);
		}
		{	// ocl::Integer::/() Integer|/(Integer)
			Operation symbol_300 = PivotFactory.eINSTANCE.createOperation();
			symbol_300.setName("/");
			symbol_300.setType(symbol_76);  // Real
			symbol_300.setLower(BigInteger.valueOf(0));
			symbol_300.setIsUnique(false);
			
			Parameter symbol_301 = PivotFactory.eINSTANCE.createParameter();
			symbol_301.setName("i");
			symbol_301.setType(symbol_44);  // Integer
			symbol_301.setLower(BigInteger.valueOf(0));
			symbol_301.setIsUnique(false);
			
			symbol_300.getOwnedParameters().add(symbol_301);
			symbol_300.setPrecedence(symbol_4);
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::Integer::abs() Integer|abs()
			Operation symbol_302 = PivotFactory.eINSTANCE.createOperation();
			symbol_302.setName("abs");
			symbol_302.setType(symbol_44);  // Integer
			symbol_302.setLower(BigInteger.valueOf(0));
			symbol_302.setIsUnique(false);
			
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Integer::div() Integer|div(Integer)
			Operation symbol_303 = PivotFactory.eINSTANCE.createOperation();
			symbol_303.setName("div");
			symbol_303.setType(symbol_44);  // Integer
			symbol_303.setLower(BigInteger.valueOf(0));
			symbol_303.setIsUnique(false);
			
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("i");
			symbol_304.setType(symbol_44);  // Integer
			symbol_304.setLower(BigInteger.valueOf(0));
			symbol_304.setIsUnique(false);
			
			symbol_303.getOwnedParameters().add(symbol_304);
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_303);
		}
		{	// ocl::Integer::max() Integer|max(Integer)
			Operation symbol_305 = PivotFactory.eINSTANCE.createOperation();
			symbol_305.setName("max");
			symbol_305.setType(symbol_44);  // Integer
			symbol_305.setLower(BigInteger.valueOf(0));
			symbol_305.setIsUnique(false);
			
			Parameter symbol_306 = PivotFactory.eINSTANCE.createParameter();
			symbol_306.setName("i");
			symbol_306.setType(symbol_44);  // Integer
			symbol_306.setLower(BigInteger.valueOf(0));
			symbol_306.setIsUnique(false);
			
			symbol_305.getOwnedParameters().add(symbol_306);
			symbol_305.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_305);
		}
		{	// ocl::Integer::min() Integer|min(Integer)
			Operation symbol_307 = PivotFactory.eINSTANCE.createOperation();
			symbol_307.setName("min");
			symbol_307.setType(symbol_44);  // Integer
			symbol_307.setLower(BigInteger.valueOf(0));
			symbol_307.setIsUnique(false);
			
			Parameter symbol_308 = PivotFactory.eINSTANCE.createParameter();
			symbol_308.setName("i");
			symbol_308.setType(symbol_44);  // Integer
			symbol_308.setLower(BigInteger.valueOf(0));
			symbol_308.setIsUnique(false);
			
			symbol_307.getOwnedParameters().add(symbol_308);
			symbol_307.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_307);
		}
		{	// ocl::Integer::mod() Integer|mod(Integer)
			Operation symbol_309 = PivotFactory.eINSTANCE.createOperation();
			symbol_309.setName("mod");
			symbol_309.setType(symbol_44);  // Integer
			symbol_309.setLower(BigInteger.valueOf(0));
			symbol_309.setIsUnique(false);
			
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("i");
			symbol_310.setType(symbol_44);  // Integer
			symbol_310.setLower(BigInteger.valueOf(0));
			symbol_310.setIsUnique(false);
			
			symbol_309.getOwnedParameters().add(symbol_310);
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Integer::toString() Integer|toString()
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("toString");
			symbol_311.setType(symbol_94);  // String
			symbol_311.setLower(BigInteger.valueOf(0));
			symbol_311.setIsUnique(false);
			
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_44.getOwnedOperations().add(symbol_311);
		}
		symbol_1.getOwnedTypes().add(symbol_44);
		//
		// ocl::NonOrderedCollection ocl|NonOrderedCollection{T}
		//
		symbol_45.setName("NonOrderedCollection");
		symbol_45.setElementType(symbol_48);
		symbol_48.setName("T");
		symbol_47.setOwnedParameteredElement(symbol_48);
		symbol_46.getOwnedParameters().add(symbol_47);
		
		symbol_45.setOwnedTemplateSignature(symbol_46);
		symbol_45.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl|NonOrderedCollection{T}|closure(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_312 = PivotFactory.eINSTANCE.createIteration();
			symbol_312.setName("closure");
			symbol_312.setType(symbol_183);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_313 = PivotFactory.eINSTANCE.createParameter();
			symbol_313.setName("i");
			symbol_313.setType(symbol_48);  // ocl|NonOrderedCollection{T}?T
			symbol_312.getOwnedIterators().add(symbol_313);
			symbol_312.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_312);
		}
		{	// ocl::NonOrderedCollection::collect() ocl|NonOrderedCollection{T}|collect(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_314 = PivotFactory.eINSTANCE.createIteration();
			symbol_314.setName("collect");
			symbol_314.setType(symbol_101);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_315 = PivotFactory.eINSTANCE.createParameter();
			symbol_315.setName("i");
			symbol_315.setType(symbol_48);  // ocl|NonOrderedCollection{T}?T
			symbol_314.getOwnedIterators().add(symbol_315);
			symbol_314.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_314);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl|NonOrderedCollection{T}|collectNested(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_316 = PivotFactory.eINSTANCE.createIteration();
			symbol_316.setName("collectNested");
			symbol_316.setType(symbol_101);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_317 = PivotFactory.eINSTANCE.createParameter();
			symbol_317.setName("i");
			symbol_317.setType(symbol_48);  // ocl|NonOrderedCollection{T}?T
			symbol_316.getOwnedIterators().add(symbol_317);
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl|NonOrderedCollection{T}|intersection(ocl|Bag[ocl|NonOrderedCollection{T}?T])
			Operation symbol_318 = PivotFactory.eINSTANCE.createOperation();
			symbol_318.setName("intersection");
			symbol_318.setType(symbol_101);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_318.setLower(BigInteger.valueOf(0));
			symbol_318.setIsUnique(false);
			
			Parameter symbol_319 = PivotFactory.eINSTANCE.createParameter();
			symbol_319.setName("bag");
			symbol_319.setType(symbol_101);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_319.setLower(BigInteger.valueOf(0));
			symbol_319.setIsUnique(false);
			
			symbol_318.getOwnedParameters().add(symbol_319);
			symbol_318.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_318);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl|NonOrderedCollection{T}|intersection(ocl|Set[ocl|NonOrderedCollection{T}?T])
			Operation symbol_320 = PivotFactory.eINSTANCE.createOperation();
			symbol_320.setName("intersection");
			symbol_320.setType(symbol_183);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_320.setLower(BigInteger.valueOf(0));
			symbol_320.setIsUnique(false);
			
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("s");
			symbol_321.setType(symbol_183);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_321.setLower(BigInteger.valueOf(0));
			symbol_321.setIsUnique(false);
			
			symbol_320.getOwnedParameters().add(symbol_321);
			symbol_320.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_320);
		}
		{	// ocl::NonOrderedCollection::union() ocl|NonOrderedCollection{T}|union(ocl|Bag[ocl|NonOrderedCollection{T}?T])
			Operation symbol_322 = PivotFactory.eINSTANCE.createOperation();
			symbol_322.setName("union");
			symbol_322.setType(symbol_101);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_322.setLower(BigInteger.valueOf(0));
			symbol_322.setIsUnique(false);
			
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("bag");
			symbol_323.setType(symbol_101);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_323.setLower(BigInteger.valueOf(0));
			symbol_323.setIsUnique(false);
			
			symbol_322.getOwnedParameters().add(symbol_323);
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::NonOrderedCollection::union() ocl|NonOrderedCollection{T}|union(ocl|Set[ocl|NonOrderedCollection{T}?T])
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_324.setName("union");
			symbol_324.setType(symbol_183);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_324.setLower(BigInteger.valueOf(0));
			symbol_324.setIsUnique(false);
			
			Parameter symbol_325 = PivotFactory.eINSTANCE.createParameter();
			symbol_325.setName("s");
			symbol_325.setType(symbol_183);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_325.setLower(BigInteger.valueOf(0));
			symbol_325.setIsUnique(false);
			
			symbol_324.getOwnedParameters().add(symbol_325);
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_45.getOwnedOperations().add(symbol_324);
		}
		symbol_1.getOwnedTypes().add(symbol_45);
		//
		// ocl::NonUniqueCollection ocl|NonUniqueCollection{T}
		//
		symbol_49.setName("NonUniqueCollection");
		symbol_49.setElementType(symbol_52);
		symbol_52.setName("T");
		symbol_51.setOwnedParameteredElement(symbol_52);
		symbol_50.getOwnedParameters().add(symbol_51);
		
		symbol_49.setOwnedTemplateSignature(symbol_50);
		symbol_49.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl|NonUniqueCollection{T}|sortedBy(ocl|NonUniqueCollection{T}?T)
			Iteration symbol_326 = PivotFactory.eINSTANCE.createIteration();
			symbol_326.setName("sortedBy");
			symbol_326.setType(symbol_166);  // ocl|Sequence[ocl|NonUniqueCollection{T}?T]
			
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("i");
			symbol_327.setType(symbol_52);  // ocl|NonUniqueCollection{T}?T
			symbol_326.getOwnedIterators().add(symbol_327);
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_49.getOwnedOperations().add(symbol_326);
		}
		symbol_1.getOwnedTypes().add(symbol_49);
		//
		// ocl::OclAny ocl|OclAny
		//
		symbol_53.setName("OclAny");
		{	// ocl::OclAny::<>() ocl|OclAny|<>(ocl|OclAny)
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_328.setName("<>");
			symbol_328.setType(symbol_19);  // Boolean
			symbol_328.setLower(BigInteger.valueOf(0));
			symbol_328.setIsUnique(false);
			
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("object2");
			symbol_329.setType(symbol_53);  // ocl|OclAny
			symbol_329.setLower(BigInteger.valueOf(0));
			symbol_329.setIsUnique(false);
			
			symbol_328.getOwnedParameters().add(symbol_329);
			symbol_328.setPrecedence(symbol_7);
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::OclAny::=() ocl|OclAny|=(ocl|OclAny)
			Operation symbol_330 = PivotFactory.eINSTANCE.createOperation();
			symbol_330.setName("=");
			symbol_330.setType(symbol_19);  // Boolean
			symbol_330.setLower(BigInteger.valueOf(0));
			symbol_330.setIsUnique(false);
			
			Parameter symbol_331 = PivotFactory.eINSTANCE.createParameter();
			symbol_331.setName("object2");
			symbol_331.setType(symbol_53);  // ocl|OclAny
			symbol_331.setLower(BigInteger.valueOf(0));
			symbol_331.setIsUnique(false);
			
			symbol_330.getOwnedParameters().add(symbol_331);
			symbol_330.setPrecedence(symbol_7);
			symbol_330.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_330);
		}
		{	// ocl::OclAny::oclAsSet() ocl|OclAny|oclAsSet{OclSelf}()
			Operation symbol_332 = PivotFactory.eINSTANCE.createOperation();
			symbol_56.setName("OclSelf");
			symbol_55.setOwnedParameteredElement(symbol_56);
			symbol_54.getOwnedParameters().add(symbol_55);
			
			symbol_332.setOwnedTemplateSignature(symbol_54);
			symbol_332.setName("oclAsSet");
			symbol_332.setType(symbol_182);  // ocl|Set[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
			symbol_332.setLower(BigInteger.valueOf(0));
			symbol_332.setIsUnique(false);
			
			symbol_332.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_332);
		}
		{	// ocl::OclAny::oclAsType() ocl|OclAny|oclAsType{T}(ocl|Classifier)
			Operation symbol_333 = PivotFactory.eINSTANCE.createOperation();
			symbol_59.setName("T");
			symbol_58.setOwnedParameteredElement(symbol_59);
			symbol_57.getOwnedParameters().add(symbol_58);
			
			symbol_333.setOwnedTemplateSignature(symbol_57);
			symbol_333.setName("oclAsType");
			symbol_333.setType(symbol_59);  // ocl|OclAny|oclAsType{T}(ocl|Classifier)?T
			symbol_333.setLower(BigInteger.valueOf(0));
			symbol_333.setIsUnique(false);
			
			Parameter symbol_334 = PivotFactory.eINSTANCE.createParameter();
			symbol_334.setName("type");
			symbol_334.setType(symbol_20);  // ocl|Classifier
			symbol_334.setLower(BigInteger.valueOf(0));
			symbol_334.setIsUnique(false);
			
			symbol_333.getOwnedParameters().add(symbol_334);
			symbol_333.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_333);
		}
		{	// ocl::OclAny::oclIsInState() ocl|OclAny|oclIsInState(ocl|OclState)
			Operation symbol_335 = PivotFactory.eINSTANCE.createOperation();
			symbol_335.setName("oclIsInState");
			symbol_335.setType(symbol_19);  // Boolean
			symbol_335.setLower(BigInteger.valueOf(0));
			symbol_335.setIsUnique(false);
			
			Parameter symbol_336 = PivotFactory.eINSTANCE.createParameter();
			symbol_336.setName("statespec");
			symbol_336.setType(symbol_65);  // ocl|OclState
			symbol_336.setLower(BigInteger.valueOf(0));
			symbol_336.setIsUnique(false);
			
			symbol_335.getOwnedParameters().add(symbol_336);
			symbol_335.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_335);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl|OclAny|oclIsInvalid()
			Operation symbol_337 = PivotFactory.eINSTANCE.createOperation();
			symbol_337.setName("oclIsInvalid");
			symbol_337.setType(symbol_19);  // Boolean
			symbol_337.setLower(BigInteger.valueOf(0));
			symbol_337.setIsUnique(false);
			
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl|OclAny|oclIsKindOf(ocl|Classifier)
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("oclIsKindOf");
			symbol_338.setType(symbol_19);  // Boolean
			symbol_338.setLower(BigInteger.valueOf(0));
			symbol_338.setIsUnique(false);
			
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("type");
			symbol_339.setType(symbol_20);  // ocl|Classifier
			symbol_339.setLower(BigInteger.valueOf(0));
			symbol_339.setIsUnique(false);
			
			symbol_338.getOwnedParameters().add(symbol_339);
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::OclAny::oclIsNew() ocl|OclAny|oclIsNew()
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("oclIsNew");
			symbol_340.setType(symbol_19);  // Boolean
			symbol_340.setLower(BigInteger.valueOf(0));
			symbol_340.setIsUnique(false);
			
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_340);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl|OclAny|oclIsTypeOf(ocl|Classifier)
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("oclIsTypeOf");
			symbol_341.setType(symbol_19);  // Boolean
			symbol_341.setLower(BigInteger.valueOf(0));
			symbol_341.setIsUnique(false);
			
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("type");
			symbol_342.setType(symbol_20);  // ocl|Classifier
			symbol_342.setLower(BigInteger.valueOf(0));
			symbol_342.setIsUnique(false);
			
			symbol_341.getOwnedParameters().add(symbol_342);
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl|OclAny|oclIsUndefined()
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_343.setName("oclIsUndefined");
			symbol_343.setType(symbol_19);  // Boolean
			symbol_343.setLower(BigInteger.valueOf(0));
			symbol_343.setIsUnique(false);
			
			symbol_343.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_343);
		}
		{	// ocl::OclAny::oclType() ocl|OclAny|oclType{OclSelf}()
			Operation symbol_344 = PivotFactory.eINSTANCE.createOperation();
			symbol_62.setName("OclSelf");
			symbol_61.setOwnedParameteredElement(symbol_62);
			symbol_60.getOwnedParameters().add(symbol_61);
			
			symbol_344.setOwnedTemplateSignature(symbol_60);
			symbol_344.setName("oclType");
			symbol_344.setType(symbol_62);  // ocl|OclAny|oclType{OclSelf}()?OclSelf
			symbol_344.setLower(BigInteger.valueOf(0));
			symbol_344.setIsUnique(false);
			
			symbol_344.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_344);
		}
		symbol_1.getOwnedTypes().add(symbol_53);
		//
		// ocl::OclInvalid ocl|OclInvalid
		//
		symbol_63.setName("OclInvalid");
		symbol_63.getSuperClasses().add(symbol_67); // ocl|OclVoid
		{	// ocl::OclInvalid::<>() ocl|OclInvalid|<>(ocl|OclAny)
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_345.setName("<>");
			symbol_345.setType(symbol_19);  // Boolean
			symbol_345.setLower(BigInteger.valueOf(0));
			symbol_345.setIsUnique(false);
			
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("object2");
			symbol_346.setType(symbol_53);  // ocl|OclAny
			symbol_346.setLower(BigInteger.valueOf(0));
			symbol_346.setIsUnique(false);
			
			symbol_345.getOwnedParameters().add(symbol_346);
			symbol_345.setPrecedence(symbol_7);
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_63.getOwnedOperations().add(symbol_345);
		}
		{	// ocl::OclInvalid::=() ocl|OclInvalid|=(ocl|OclAny)
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("=");
			symbol_347.setType(symbol_19);  // Boolean
			symbol_347.setLower(BigInteger.valueOf(0));
			symbol_347.setIsUnique(false);
			
			Parameter symbol_348 = PivotFactory.eINSTANCE.createParameter();
			symbol_348.setName("object2");
			symbol_348.setType(symbol_53);  // ocl|OclAny
			symbol_348.setLower(BigInteger.valueOf(0));
			symbol_348.setIsUnique(false);
			
			symbol_347.getOwnedParameters().add(symbol_348);
			symbol_347.setPrecedence(symbol_7);
			symbol_347.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_63.getOwnedOperations().add(symbol_347);
		}
		{	// ocl::OclInvalid::allInstances() ocl|OclInvalid|allInstances()
			Operation symbol_349 = PivotFactory.eINSTANCE.createOperation();
			symbol_349.setName("allInstances");
			symbol_349.setType(symbol_184);  // ocl|Set[ocl|OclInvalid]
			symbol_349.setLower(BigInteger.valueOf(0));
			symbol_349.setIsUnique(false);
			
			symbol_349.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_63.getOwnedOperations().add(symbol_349);
		}
		{	// ocl::OclInvalid::toString() ocl|OclInvalid|toString()
			Operation symbol_350 = PivotFactory.eINSTANCE.createOperation();
			symbol_350.setName("toString");
			symbol_350.setType(symbol_94);  // String
			symbol_350.setLower(BigInteger.valueOf(0));
			symbol_350.setIsUnique(false);
			
			symbol_350.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_63.getOwnedOperations().add(symbol_350);
		}
		symbol_1.getOwnedTypes().add(symbol_63);
		//
		// ocl::OclMessage ocl|OclMessage
		//
		symbol_64.setName("OclMessage");
		symbol_64.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::OclMessage::hasReturned() ocl|OclMessage|hasReturned()
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_351.setName("hasReturned");
			symbol_351.setType(symbol_19);  // Boolean
			symbol_351.setLower(BigInteger.valueOf(0));
			symbol_351.setIsUnique(false);
			
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::OclMessage::isOperationCall() ocl|OclMessage|isOperationCall()
			Operation symbol_352 = PivotFactory.eINSTANCE.createOperation();
			symbol_352.setName("isOperationCall");
			symbol_352.setType(symbol_19);  // Boolean
			symbol_352.setLower(BigInteger.valueOf(0));
			symbol_352.setIsUnique(false);
			
			symbol_352.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_352);
		}
		{	// ocl::OclMessage::isSignalSent() ocl|OclMessage|isSignalSent()
			Operation symbol_353 = PivotFactory.eINSTANCE.createOperation();
			symbol_353.setName("isSignalSent");
			symbol_353.setType(symbol_19);  // Boolean
			symbol_353.setLower(BigInteger.valueOf(0));
			symbol_353.setIsUnique(false);
			
			symbol_353.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_353);
		}
		{	// ocl::OclMessage::result() ocl|OclMessage|result()
			Operation symbol_354 = PivotFactory.eINSTANCE.createOperation();
			symbol_354.setName("result");
			symbol_354.setType(symbol_53);  // ocl|OclAny
			symbol_354.setLower(BigInteger.valueOf(0));
			symbol_354.setIsUnique(false);
			
			symbol_354.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_64.getOwnedOperations().add(symbol_354);
		}
		symbol_1.getOwnedTypes().add(symbol_64);
		//
		// ocl::OclState ocl|OclState
		//
		symbol_65.setName("OclState");
		symbol_65.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_1.getOwnedTypes().add(symbol_65);
		//
		// ocl::OclTuple ocl|OclTuple
		//
		symbol_66.setName("OclTuple");
		symbol_66.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::OclTuple::<>() ocl|OclTuple|<>(ocl|OclAny)
			Operation symbol_355 = PivotFactory.eINSTANCE.createOperation();
			symbol_355.setName("<>");
			symbol_355.setType(symbol_19);  // Boolean
			symbol_355.setLower(BigInteger.valueOf(0));
			symbol_355.setIsUnique(false);
			
			Parameter symbol_356 = PivotFactory.eINSTANCE.createParameter();
			symbol_356.setName("object2");
			symbol_356.setType(symbol_53);  // ocl|OclAny
			symbol_356.setLower(BigInteger.valueOf(0));
			symbol_356.setIsUnique(false);
			
			symbol_355.getOwnedParameters().add(symbol_356);
			symbol_355.setPrecedence(symbol_7);
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_355);
		}
		{	// ocl::OclTuple::=() ocl|OclTuple|=(ocl|OclAny)
			Operation symbol_357 = PivotFactory.eINSTANCE.createOperation();
			symbol_357.setName("=");
			symbol_357.setType(symbol_19);  // Boolean
			symbol_357.setLower(BigInteger.valueOf(0));
			symbol_357.setIsUnique(false);
			
			Parameter symbol_358 = PivotFactory.eINSTANCE.createParameter();
			symbol_358.setName("object2");
			symbol_358.setType(symbol_53);  // ocl|OclAny
			symbol_358.setLower(BigInteger.valueOf(0));
			symbol_358.setIsUnique(false);
			
			symbol_357.getOwnedParameters().add(symbol_358);
			symbol_357.setPrecedence(symbol_7);
			symbol_357.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_357);
		}
		symbol_1.getOwnedTypes().add(symbol_66);
		//
		// ocl::OclVoid ocl|OclVoid
		//
		symbol_67.setName("OclVoid");
		symbol_67.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::OclVoid::<>() ocl|OclVoid|<>(ocl|OclAny)
			Operation symbol_359 = PivotFactory.eINSTANCE.createOperation();
			symbol_359.setName("<>");
			symbol_359.setType(symbol_19);  // Boolean
			symbol_359.setLower(BigInteger.valueOf(0));
			symbol_359.setIsUnique(false);
			
			Parameter symbol_360 = PivotFactory.eINSTANCE.createParameter();
			symbol_360.setName("object2");
			symbol_360.setType(symbol_53);  // ocl|OclAny
			symbol_360.setLower(BigInteger.valueOf(0));
			symbol_360.setIsUnique(false);
			
			symbol_359.getOwnedParameters().add(symbol_360);
			symbol_359.setPrecedence(symbol_7);
			symbol_359.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_359);
		}
		{	// ocl::OclVoid::=() ocl|OclVoid|=(ocl|OclAny)
			Operation symbol_361 = PivotFactory.eINSTANCE.createOperation();
			symbol_361.setName("=");
			symbol_361.setType(symbol_19);  // Boolean
			symbol_361.setLower(BigInteger.valueOf(0));
			symbol_361.setIsUnique(false);
			
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("object2");
			symbol_362.setType(symbol_53);  // ocl|OclAny
			symbol_362.setLower(BigInteger.valueOf(0));
			symbol_362.setIsUnique(false);
			
			symbol_361.getOwnedParameters().add(symbol_362);
			symbol_361.setPrecedence(symbol_7);
			symbol_361.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_361);
		}
		{	// ocl::OclVoid::allInstances() ocl|OclVoid|allInstances()
			Operation symbol_363 = PivotFactory.eINSTANCE.createOperation();
			symbol_363.setName("allInstances");
			symbol_363.setType(symbol_175);  // ocl|Set[ocl|OclVoid]
			symbol_363.setLower(BigInteger.valueOf(0));
			symbol_363.setIsUnique(false);
			
			symbol_363.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_363);
		}
		{	// ocl::OclVoid::and() ocl|OclVoid|and(Boolean)
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("and");
			symbol_364.setType(symbol_19);  // Boolean
			symbol_364.setLower(BigInteger.valueOf(0));
			symbol_364.setIsUnique(false);
			
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("b");
			symbol_365.setType(symbol_19);  // Boolean
			symbol_365.setLower(BigInteger.valueOf(0));
			symbol_365.setIsUnique(false);
			
			symbol_364.getOwnedParameters().add(symbol_365);
			symbol_364.setPrecedence(symbol_8);
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_364);
		}
		{	// ocl::OclVoid::implies() ocl|OclVoid|implies(Boolean)
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_366.setName("implies");
			symbol_366.setType(symbol_19);  // Boolean
			symbol_366.setLower(BigInteger.valueOf(0));
			symbol_366.setIsUnique(false);
			
			Parameter symbol_367 = PivotFactory.eINSTANCE.createParameter();
			symbol_367.setName("b");
			symbol_367.setType(symbol_19);  // Boolean
			symbol_367.setLower(BigInteger.valueOf(0));
			symbol_367.setIsUnique(false);
			
			symbol_366.getOwnedParameters().add(symbol_367);
			symbol_366.setPrecedence(symbol_11);
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_366);
		}
		{	// ocl::OclVoid::or() ocl|OclVoid|or(Boolean)
			Operation symbol_368 = PivotFactory.eINSTANCE.createOperation();
			symbol_368.setName("or");
			symbol_368.setType(symbol_19);  // Boolean
			symbol_368.setLower(BigInteger.valueOf(0));
			symbol_368.setIsUnique(false);
			
			Parameter symbol_369 = PivotFactory.eINSTANCE.createParameter();
			symbol_369.setName("b");
			symbol_369.setType(symbol_19);  // Boolean
			symbol_369.setLower(BigInteger.valueOf(0));
			symbol_369.setIsUnique(false);
			
			symbol_368.getOwnedParameters().add(symbol_369);
			symbol_368.setPrecedence(symbol_9);
			symbol_368.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_368);
		}
		{	// ocl::OclVoid::toString() ocl|OclVoid|toString()
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_370.setName("toString");
			symbol_370.setType(symbol_94);  // String
			symbol_370.setLower(BigInteger.valueOf(0));
			symbol_370.setIsUnique(false);
			
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_370);
		}
		symbol_1.getOwnedTypes().add(symbol_67);
		//
		// ocl::OrderedCollection ocl|OrderedCollection{T}
		//
		symbol_68.setName("OrderedCollection");
		symbol_68.setElementType(symbol_71);
		symbol_71.setName("T");
		symbol_70.setOwnedParameteredElement(symbol_71);
		symbol_69.getOwnedParameters().add(symbol_70);
		
		symbol_68.setOwnedTemplateSignature(symbol_69);
		symbol_68.getSuperClasses().add(symbol_121); // ocl|Collection[ocl|OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl|OrderedCollection{T}|at(Integer)
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("at");
			symbol_371.setType(symbol_71);  // ocl|OrderedCollection{T}?T
			symbol_371.setLower(BigInteger.valueOf(0));
			symbol_371.setIsUnique(false);
			
			Parameter symbol_372 = PivotFactory.eINSTANCE.createParameter();
			symbol_372.setName("index");
			symbol_372.setType(symbol_44);  // Integer
			symbol_372.setLower(BigInteger.valueOf(0));
			symbol_372.setIsUnique(false);
			
			symbol_371.getOwnedParameters().add(symbol_372);
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::OrderedCollection::closure() ocl|OrderedCollection{T}|closure(ocl|OrderedCollection{T}?T)
			Iteration symbol_373 = PivotFactory.eINSTANCE.createIteration();
			symbol_373.setName("closure");
			symbol_373.setType(symbol_163);  // ocl|OrderedSet[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_374 = PivotFactory.eINSTANCE.createParameter();
			symbol_374.setName("i");
			symbol_374.setType(symbol_71);  // ocl|OrderedCollection{T}?T
			symbol_373.getOwnedIterators().add(symbol_374);
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_373);
		}
		{	// ocl::OrderedCollection::collect() ocl|OrderedCollection{T}|collect(ocl|OrderedCollection{T}?T)
			Iteration symbol_375 = PivotFactory.eINSTANCE.createIteration();
			symbol_375.setName("collect");
			symbol_375.setType(symbol_168);  // ocl|Sequence[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("i");
			symbol_376.setType(symbol_71);  // ocl|OrderedCollection{T}?T
			symbol_375.getOwnedIterators().add(symbol_376);
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_375);
		}
		{	// ocl::OrderedCollection::collectNested() ocl|OrderedCollection{T}|collectNested(ocl|OrderedCollection{T}?T)
			Iteration symbol_377 = PivotFactory.eINSTANCE.createIteration();
			symbol_377.setName("collectNested");
			symbol_377.setType(symbol_168);  // ocl|Sequence[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("i");
			symbol_378.setType(symbol_71);  // ocl|OrderedCollection{T}?T
			symbol_377.getOwnedIterators().add(symbol_378);
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::OrderedCollection::first() ocl|OrderedCollection{T}|first()
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("first");
			symbol_379.setType(symbol_71);  // ocl|OrderedCollection{T}?T
			symbol_379.setLower(BigInteger.valueOf(0));
			symbol_379.setIsUnique(false);
			
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::OrderedCollection::indexOf() ocl|OrderedCollection{T}|indexOf(ocl|OclAny)
			Operation symbol_380 = PivotFactory.eINSTANCE.createOperation();
			symbol_380.setName("indexOf");
			symbol_380.setType(symbol_44);  // Integer
			symbol_380.setLower(BigInteger.valueOf(0));
			symbol_380.setIsUnique(false);
			
			Parameter symbol_381 = PivotFactory.eINSTANCE.createParameter();
			symbol_381.setName("obj");
			symbol_381.setType(symbol_53);  // ocl|OclAny
			symbol_381.setLower(BigInteger.valueOf(0));
			symbol_381.setIsUnique(false);
			
			symbol_380.getOwnedParameters().add(symbol_381);
			symbol_380.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_380);
		}
		{	// ocl::OrderedCollection::last() ocl|OrderedCollection{T}|last()
			Operation symbol_382 = PivotFactory.eINSTANCE.createOperation();
			symbol_382.setName("last");
			symbol_382.setType(symbol_71);  // ocl|OrderedCollection{T}?T
			symbol_382.setLower(BigInteger.valueOf(0));
			symbol_382.setIsUnique(false);
			
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_382);
		}
		{	// ocl::OrderedCollection::reverse() ocl|OrderedCollection{T}|reverse()
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_383.setName("reverse");
			symbol_383.setType(symbol_156);  // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
			symbol_383.setLower(BigInteger.valueOf(0));
			symbol_383.setIsUnique(false);
			
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_68.getOwnedOperations().add(symbol_383);
		}
		symbol_1.getOwnedTypes().add(symbol_68);
		//
		// ocl::OrderedSet ocl|OrderedSet{T}
		//
		symbol_72.setName("OrderedSet");
		symbol_72.setElementType(symbol_75);
		symbol_75.setName("T");
		symbol_74.setOwnedParameteredElement(symbol_75);
		symbol_73.getOwnedParameters().add(symbol_74);
		
		symbol_72.setOwnedTemplateSignature(symbol_73);
		symbol_72.getSuperClasses().add(symbol_200); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_72.getSuperClasses().add(symbol_160); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl|OrderedSet{T}|-(ocl|Set[ocl|OclAny])
			Operation symbol_384 = PivotFactory.eINSTANCE.createOperation();
			symbol_384.setName("-");
			symbol_384.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_384.setLower(BigInteger.valueOf(0));
			symbol_384.setIsUnique(false);
			
			Parameter symbol_385 = PivotFactory.eINSTANCE.createParameter();
			symbol_385.setName("s");
			symbol_385.setType(symbol_177);  // ocl|Set[ocl|OclAny]
			symbol_385.setLower(BigInteger.valueOf(0));
			symbol_385.setIsUnique(false);
			
			symbol_384.getOwnedParameters().add(symbol_385);
			symbol_384.setPrecedence(symbol_5);
			symbol_384.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_384);
		}
		{	// ocl::OrderedSet::<>() ocl|OrderedSet{T}|<>(ocl|OclAny)
			Operation symbol_386 = PivotFactory.eINSTANCE.createOperation();
			symbol_386.setName("<>");
			symbol_386.setType(symbol_19);  // Boolean
			symbol_386.setLower(BigInteger.valueOf(0));
			symbol_386.setIsUnique(false);
			
			Parameter symbol_387 = PivotFactory.eINSTANCE.createParameter();
			symbol_387.setName("object2");
			symbol_387.setType(symbol_53);  // ocl|OclAny
			symbol_387.setLower(BigInteger.valueOf(0));
			symbol_387.setIsUnique(false);
			
			symbol_386.getOwnedParameters().add(symbol_387);
			symbol_386.setPrecedence(symbol_7);
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::OrderedSet::=() ocl|OrderedSet{T}|=(ocl|OclAny)
			Operation symbol_388 = PivotFactory.eINSTANCE.createOperation();
			symbol_388.setName("=");
			symbol_388.setType(symbol_19);  // Boolean
			symbol_388.setLower(BigInteger.valueOf(0));
			symbol_388.setIsUnique(false);
			
			Parameter symbol_389 = PivotFactory.eINSTANCE.createParameter();
			symbol_389.setName("object2");
			symbol_389.setType(symbol_53);  // ocl|OclAny
			symbol_389.setLower(BigInteger.valueOf(0));
			symbol_389.setIsUnique(false);
			
			symbol_388.getOwnedParameters().add(symbol_389);
			symbol_388.setPrecedence(symbol_7);
			symbol_388.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_388);
		}
		{	// ocl::OrderedSet::append() ocl|OrderedSet{T}|append(ocl|OrderedSet{T}?T)
			Operation symbol_390 = PivotFactory.eINSTANCE.createOperation();
			symbol_390.setName("append");
			symbol_390.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_390.setLower(BigInteger.valueOf(0));
			symbol_390.setIsUnique(false);
			
			Parameter symbol_391 = PivotFactory.eINSTANCE.createParameter();
			symbol_391.setName("object");
			symbol_391.setType(symbol_75);  // ocl|OrderedSet{T}?T
			symbol_391.setLower(BigInteger.valueOf(0));
			symbol_391.setIsUnique(false);
			
			symbol_390.getOwnedParameters().add(symbol_391);
			symbol_390.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_390);
		}
		{	// ocl::OrderedSet::excluding() ocl|OrderedSet{T}|excluding(ocl|OclAny)
			Operation symbol_392 = PivotFactory.eINSTANCE.createOperation();
			symbol_392.setName("excluding");
			symbol_392.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_392.setLower(BigInteger.valueOf(0));
			symbol_392.setIsUnique(false);
			
			Parameter symbol_393 = PivotFactory.eINSTANCE.createParameter();
			symbol_393.setName("object");
			symbol_393.setType(symbol_53);  // ocl|OclAny
			symbol_393.setLower(BigInteger.valueOf(0));
			symbol_393.setIsUnique(false);
			
			symbol_392.getOwnedParameters().add(symbol_393);
			symbol_392.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_392);
		}
		{	// ocl::OrderedSet::including() ocl|OrderedSet{T}|including(ocl|OrderedSet{T}?T)
			Operation symbol_394 = PivotFactory.eINSTANCE.createOperation();
			symbol_394.setName("including");
			symbol_394.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_394.setLower(BigInteger.valueOf(0));
			symbol_394.setIsUnique(false);
			
			Parameter symbol_395 = PivotFactory.eINSTANCE.createParameter();
			symbol_395.setName("object");
			symbol_395.setType(symbol_75);  // ocl|OrderedSet{T}?T
			symbol_395.setLower(BigInteger.valueOf(0));
			symbol_395.setIsUnique(false);
			
			symbol_394.getOwnedParameters().add(symbol_395);
			symbol_394.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_394);
		}
		{	// ocl::OrderedSet::insertAt() ocl|OrderedSet{T}|insertAt(Integer,ocl|OrderedSet{T}?T)
			Operation symbol_396 = PivotFactory.eINSTANCE.createOperation();
			symbol_396.setName("insertAt");
			symbol_396.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_396.setLower(BigInteger.valueOf(0));
			symbol_396.setIsUnique(false);
			
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("index");
			symbol_397.setType(symbol_44);  // Integer
			symbol_397.setLower(BigInteger.valueOf(0));
			symbol_397.setIsUnique(false);
			
			symbol_396.getOwnedParameters().add(symbol_397);
			Parameter symbol_398 = PivotFactory.eINSTANCE.createParameter();
			symbol_398.setName("object");
			symbol_398.setType(symbol_75);  // ocl|OrderedSet{T}?T
			symbol_398.setLower(BigInteger.valueOf(0));
			symbol_398.setIsUnique(false);
			
			symbol_396.getOwnedParameters().add(symbol_398);
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_396);
		}
		{	// ocl::OrderedSet::intersection() ocl|OrderedSet{T}|intersection(ocl|Set[ocl|OrderedSet{T}?T])
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("intersection");
			symbol_399.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_399.setLower(BigInteger.valueOf(0));
			symbol_399.setIsUnique(false);
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("o");
			symbol_400.setType(symbol_176);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_400.setLower(BigInteger.valueOf(0));
			symbol_400.setIsUnique(false);
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_399);
		}
		{	// ocl::OrderedSet::prepend() ocl|OrderedSet{T}|prepend(ocl|OrderedSet{T}?T)
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("prepend");
			symbol_401.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_401.setLower(BigInteger.valueOf(0));
			symbol_401.setIsUnique(false);
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("object");
			symbol_402.setType(symbol_75);  // ocl|OrderedSet{T}?T
			symbol_402.setLower(BigInteger.valueOf(0));
			symbol_402.setIsUnique(false);
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OrderedSet::reject() ocl|OrderedSet{T}|reject(ocl|OrderedSet{T}?T)
			Iteration symbol_403 = PivotFactory.eINSTANCE.createIteration();
			symbol_403.setName("reject");
			symbol_403.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			
			Parameter symbol_404 = PivotFactory.eINSTANCE.createParameter();
			symbol_404.setName("i");
			symbol_404.setType(symbol_75);  // ocl|OrderedSet{T}?T
			symbol_403.getOwnedIterators().add(symbol_404);
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_403);
		}
		{	// ocl::OrderedSet::reverse() ocl|OrderedSet{T}|reverse()
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("reverse");
			symbol_405.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_405.setLower(BigInteger.valueOf(0));
			symbol_405.setIsUnique(false);
			
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_405);
		}
		{	// ocl::OrderedSet::select() ocl|OrderedSet{T}|select(ocl|OrderedSet{T}?T)
			Iteration symbol_406 = PivotFactory.eINSTANCE.createIteration();
			symbol_406.setName("select");
			symbol_406.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			
			Parameter symbol_407 = PivotFactory.eINSTANCE.createParameter();
			symbol_407.setName("i");
			symbol_407.setType(symbol_75);  // ocl|OrderedSet{T}?T
			symbol_406.getOwnedIterators().add(symbol_407);
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl|OrderedSet{T}|subOrderedSet(Integer,Integer)
			Operation symbol_408 = PivotFactory.eINSTANCE.createOperation();
			symbol_408.setName("subOrderedSet");
			symbol_408.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_408.setLower(BigInteger.valueOf(0));
			symbol_408.setIsUnique(false);
			
			Parameter symbol_409 = PivotFactory.eINSTANCE.createParameter();
			symbol_409.setName("lower");
			symbol_409.setType(symbol_44);  // Integer
			symbol_409.setLower(BigInteger.valueOf(0));
			symbol_409.setIsUnique(false);
			
			symbol_408.getOwnedParameters().add(symbol_409);
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("upper");
			symbol_410.setType(symbol_44);  // Integer
			symbol_410.setLower(BigInteger.valueOf(0));
			symbol_410.setIsUnique(false);
			
			symbol_408.getOwnedParameters().add(symbol_410);
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_408);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl|OrderedSet{T}|symmetricDifference(ocl|Set[ocl|OclAny])
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_411.setName("symmetricDifference");
			symbol_411.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_411.setLower(BigInteger.valueOf(0));
			symbol_411.setIsUnique(false);
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("s");
			symbol_412.setType(symbol_177);  // ocl|Set[ocl|OclAny]
			symbol_412.setLower(BigInteger.valueOf(0));
			symbol_412.setIsUnique(false);
			
			symbol_411.getOwnedParameters().add(symbol_412);
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OrderedSet::union() ocl|OrderedSet{T}|union(ocl|OrderedSet[ocl|OrderedSet{T}?T])
			Operation symbol_413 = PivotFactory.eINSTANCE.createOperation();
			symbol_413.setName("union");
			symbol_413.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_413.setLower(BigInteger.valueOf(0));
			symbol_413.setIsUnique(false);
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("o");
			symbol_414.setType(symbol_162);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_414.setLower(BigInteger.valueOf(0));
			symbol_414.setIsUnique(false);
			
			symbol_413.getOwnedParameters().add(symbol_414);
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::OrderedSet::union() ocl|OrderedSet{T}|union(ocl|Set[ocl|OrderedSet{T}?T])
			Operation symbol_415 = PivotFactory.eINSTANCE.createOperation();
			symbol_415.setName("union");
			symbol_415.setType(symbol_176);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_415.setLower(BigInteger.valueOf(0));
			symbol_415.setIsUnique(false);
			
			Parameter symbol_416 = PivotFactory.eINSTANCE.createParameter();
			symbol_416.setName("s");
			symbol_416.setType(symbol_176);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_416.setLower(BigInteger.valueOf(0));
			symbol_416.setIsUnique(false);
			
			symbol_415.getOwnedParameters().add(symbol_416);
			symbol_415.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_415);
		}
		symbol_1.getOwnedTypes().add(symbol_72);
		//
		// ocl::Real Real
		//
		symbol_76.setName("Real");
		symbol_76.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::Real::*() Real|*(Real)
			Operation symbol_417 = PivotFactory.eINSTANCE.createOperation();
			symbol_417.setName("*");
			symbol_417.setType(symbol_76);  // Real
			symbol_417.setLower(BigInteger.valueOf(0));
			symbol_417.setIsUnique(false);
			
			Parameter symbol_418 = PivotFactory.eINSTANCE.createParameter();
			symbol_418.setName("r");
			symbol_418.setType(symbol_76);  // Real
			symbol_418.setLower(BigInteger.valueOf(0));
			symbol_418.setIsUnique(false);
			
			symbol_417.getOwnedParameters().add(symbol_418);
			symbol_417.setPrecedence(symbol_4);
			symbol_417.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_417);
		}
		{	// ocl::Real::+() Real|+(Real)
			Operation symbol_419 = PivotFactory.eINSTANCE.createOperation();
			symbol_419.setName("+");
			symbol_419.setType(symbol_76);  // Real
			symbol_419.setLower(BigInteger.valueOf(0));
			symbol_419.setIsUnique(false);
			
			Parameter symbol_420 = PivotFactory.eINSTANCE.createParameter();
			symbol_420.setName("r");
			symbol_420.setType(symbol_76);  // Real
			symbol_420.setLower(BigInteger.valueOf(0));
			symbol_420.setIsUnique(false);
			
			symbol_419.getOwnedParameters().add(symbol_420);
			symbol_419.setPrecedence(symbol_5);
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::Real::-() Real|-(Real)
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("-");
			symbol_421.setType(symbol_76);  // Real
			symbol_421.setLower(BigInteger.valueOf(0));
			symbol_421.setIsUnique(false);
			
			Parameter symbol_422 = PivotFactory.eINSTANCE.createParameter();
			symbol_422.setName("r");
			symbol_422.setType(symbol_76);  // Real
			symbol_422.setLower(BigInteger.valueOf(0));
			symbol_422.setIsUnique(false);
			
			symbol_421.getOwnedParameters().add(symbol_422);
			symbol_421.setPrecedence(symbol_5);
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_421);
		}
		{	// ocl::Real::-() Real|-()
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("-");
			symbol_423.setType(symbol_76);  // Real
			symbol_423.setLower(BigInteger.valueOf(0));
			symbol_423.setIsUnique(false);
			
			symbol_423.setPrecedence(symbol_3);
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_423);
		}
		{	// ocl::Real::/() Real|/(Real)
			Operation symbol_424 = PivotFactory.eINSTANCE.createOperation();
			symbol_424.setName("/");
			symbol_424.setType(symbol_76);  // Real
			symbol_424.setLower(BigInteger.valueOf(0));
			symbol_424.setIsUnique(false);
			
			Parameter symbol_425 = PivotFactory.eINSTANCE.createParameter();
			symbol_425.setName("r");
			symbol_425.setType(symbol_76);  // Real
			symbol_425.setLower(BigInteger.valueOf(0));
			symbol_425.setIsUnique(false);
			
			symbol_424.getOwnedParameters().add(symbol_425);
			symbol_424.setPrecedence(symbol_4);
			symbol_424.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_424);
		}
		{	// ocl::Real::<() Real|<(Real)
			Operation symbol_426 = PivotFactory.eINSTANCE.createOperation();
			symbol_426.setName("<");
			symbol_426.setType(symbol_19);  // Boolean
			symbol_426.setLower(BigInteger.valueOf(0));
			symbol_426.setIsUnique(false);
			
			Parameter symbol_427 = PivotFactory.eINSTANCE.createParameter();
			symbol_427.setName("r");
			symbol_427.setType(symbol_76);  // Real
			symbol_427.setLower(BigInteger.valueOf(0));
			symbol_427.setIsUnique(false);
			
			symbol_426.getOwnedParameters().add(symbol_427);
			symbol_426.setPrecedence(symbol_6);
			symbol_426.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_426);
		}
		{	// ocl::Real::<=() Real|<=(Real)
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("<=");
			symbol_428.setType(symbol_19);  // Boolean
			symbol_428.setLower(BigInteger.valueOf(0));
			symbol_428.setIsUnique(false);
			
			Parameter symbol_429 = PivotFactory.eINSTANCE.createParameter();
			symbol_429.setName("r");
			symbol_429.setType(symbol_76);  // Real
			symbol_429.setLower(BigInteger.valueOf(0));
			symbol_429.setIsUnique(false);
			
			symbol_428.getOwnedParameters().add(symbol_429);
			symbol_428.setPrecedence(symbol_6);
			symbol_428.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::Real::<>() Real|<>(ocl|OclAny)
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("<>");
			symbol_430.setType(symbol_19);  // Boolean
			symbol_430.setLower(BigInteger.valueOf(0));
			symbol_430.setIsUnique(false);
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("object2");
			symbol_431.setType(symbol_53);  // ocl|OclAny
			symbol_431.setLower(BigInteger.valueOf(0));
			symbol_431.setIsUnique(false);
			
			symbol_430.getOwnedParameters().add(symbol_431);
			symbol_430.setPrecedence(symbol_7);
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::Real::=() Real|=(ocl|OclAny)
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("=");
			symbol_432.setType(symbol_19);  // Boolean
			symbol_432.setLower(BigInteger.valueOf(0));
			symbol_432.setIsUnique(false);
			
			Parameter symbol_433 = PivotFactory.eINSTANCE.createParameter();
			symbol_433.setName("object2");
			symbol_433.setType(symbol_53);  // ocl|OclAny
			symbol_433.setLower(BigInteger.valueOf(0));
			symbol_433.setIsUnique(false);
			
			symbol_432.getOwnedParameters().add(symbol_433);
			symbol_432.setPrecedence(symbol_7);
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::Real::>() Real|>(Real)
			Operation symbol_434 = PivotFactory.eINSTANCE.createOperation();
			symbol_434.setName(">");
			symbol_434.setType(symbol_19);  // Boolean
			symbol_434.setLower(BigInteger.valueOf(0));
			symbol_434.setIsUnique(false);
			
			Parameter symbol_435 = PivotFactory.eINSTANCE.createParameter();
			symbol_435.setName("r");
			symbol_435.setType(symbol_76);  // Real
			symbol_435.setLower(BigInteger.valueOf(0));
			symbol_435.setIsUnique(false);
			
			symbol_434.getOwnedParameters().add(symbol_435);
			symbol_434.setPrecedence(symbol_6);
			symbol_434.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_434);
		}
		{	// ocl::Real::>=() Real|>=(Real)
			Operation symbol_436 = PivotFactory.eINSTANCE.createOperation();
			symbol_436.setName(">=");
			symbol_436.setType(symbol_19);  // Boolean
			symbol_436.setLower(BigInteger.valueOf(0));
			symbol_436.setIsUnique(false);
			
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("r");
			symbol_437.setType(symbol_76);  // Real
			symbol_437.setLower(BigInteger.valueOf(0));
			symbol_437.setIsUnique(false);
			
			symbol_436.getOwnedParameters().add(symbol_437);
			symbol_436.setPrecedence(symbol_6);
			symbol_436.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_436);
		}
		{	// ocl::Real::abs() Real|abs()
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("abs");
			symbol_438.setType(symbol_76);  // Real
			symbol_438.setLower(BigInteger.valueOf(0));
			symbol_438.setIsUnique(false);
			
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::Real::floor() Real|floor()
			Operation symbol_439 = PivotFactory.eINSTANCE.createOperation();
			symbol_439.setName("floor");
			symbol_439.setType(symbol_44);  // Integer
			symbol_439.setLower(BigInteger.valueOf(0));
			symbol_439.setIsUnique(false);
			
			symbol_439.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_439);
		}
		{	// ocl::Real::max() Real|max(Real)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("max");
			symbol_440.setType(symbol_76);  // Real
			symbol_440.setLower(BigInteger.valueOf(0));
			symbol_440.setIsUnique(false);
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("r");
			symbol_441.setType(symbol_76);  // Real
			symbol_441.setLower(BigInteger.valueOf(0));
			symbol_441.setIsUnique(false);
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::Real::min() Real|min(Real)
			Operation symbol_442 = PivotFactory.eINSTANCE.createOperation();
			symbol_442.setName("min");
			symbol_442.setType(symbol_76);  // Real
			symbol_442.setLower(BigInteger.valueOf(0));
			symbol_442.setIsUnique(false);
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("r");
			symbol_443.setType(symbol_76);  // Real
			symbol_443.setLower(BigInteger.valueOf(0));
			symbol_443.setIsUnique(false);
			
			symbol_442.getOwnedParameters().add(symbol_443);
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::Real::oclAsType() Real|oclAsType{T}(ocl|Classifier)
			Operation symbol_444 = PivotFactory.eINSTANCE.createOperation();
			symbol_79.setName("T");
			symbol_78.setOwnedParameteredElement(symbol_79);
			symbol_77.getOwnedParameters().add(symbol_78);
			
			symbol_444.setOwnedTemplateSignature(symbol_77);
			symbol_444.setName("oclAsType");
			symbol_444.setType(symbol_79);  // Real|oclAsType{T}(ocl|Classifier)?T
			symbol_444.setLower(BigInteger.valueOf(0));
			symbol_444.setIsUnique(false);
			
			Parameter symbol_445 = PivotFactory.eINSTANCE.createParameter();
			symbol_445.setName("type");
			symbol_445.setType(symbol_20);  // ocl|Classifier
			symbol_445.setLower(BigInteger.valueOf(0));
			symbol_445.setIsUnique(false);
			
			symbol_444.getOwnedParameters().add(symbol_445);
			symbol_444.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_444);
		}
		{	// ocl::Real::round() Real|round()
			Operation symbol_446 = PivotFactory.eINSTANCE.createOperation();
			symbol_446.setName("round");
			symbol_446.setType(symbol_44);  // Integer
			symbol_446.setLower(BigInteger.valueOf(0));
			symbol_446.setIsUnique(false);
			
			symbol_446.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_446);
		}
		{	// ocl::Real::toString() Real|toString()
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("toString");
			symbol_447.setType(symbol_94);  // String
			symbol_447.setLower(BigInteger.valueOf(0));
			symbol_447.setIsUnique(false);
			
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_447);
		}
		symbol_1.getOwnedTypes().add(symbol_76);
		//
		// ocl::Sequence ocl|Sequence{T}
		//
		symbol_80.setName("Sequence");
		symbol_80.setElementType(symbol_83);
		symbol_83.setName("T");
		symbol_82.setOwnedParameteredElement(symbol_83);
		symbol_81.getOwnedParameters().add(symbol_82);
		
		symbol_80.setOwnedTemplateSignature(symbol_81);
		symbol_80.getSuperClasses().add(symbol_150); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		symbol_80.getSuperClasses().add(symbol_158); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl|Sequence{T}|<>(ocl|OclAny)
			Operation symbol_448 = PivotFactory.eINSTANCE.createOperation();
			symbol_448.setName("<>");
			symbol_448.setType(symbol_19);  // Boolean
			symbol_448.setLower(BigInteger.valueOf(0));
			symbol_448.setIsUnique(false);
			
			Parameter symbol_449 = PivotFactory.eINSTANCE.createParameter();
			symbol_449.setName("object2");
			symbol_449.setType(symbol_53);  // ocl|OclAny
			symbol_449.setLower(BigInteger.valueOf(0));
			symbol_449.setIsUnique(false);
			
			symbol_448.getOwnedParameters().add(symbol_449);
			symbol_448.setPrecedence(symbol_7);
			symbol_448.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_448);
		}
		{	// ocl::Sequence::=() ocl|Sequence{T}|=(ocl|OclAny)
			Operation symbol_450 = PivotFactory.eINSTANCE.createOperation();
			symbol_450.setName("=");
			symbol_450.setType(symbol_19);  // Boolean
			symbol_450.setLower(BigInteger.valueOf(0));
			symbol_450.setIsUnique(false);
			
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("object2");
			symbol_451.setType(symbol_53);  // ocl|OclAny
			symbol_451.setLower(BigInteger.valueOf(0));
			symbol_451.setIsUnique(false);
			
			symbol_450.getOwnedParameters().add(symbol_451);
			symbol_450.setPrecedence(symbol_7);
			symbol_450.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_450);
		}
		{	// ocl::Sequence::append() ocl|Sequence{T}|append(ocl|Sequence{T}?T)
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_452.setName("append");
			symbol_452.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_452.setLower(BigInteger.valueOf(0));
			symbol_452.setIsUnique(false);
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("object");
			symbol_453.setType(symbol_83);  // ocl|Sequence{T}?T
			symbol_453.setLower(BigInteger.valueOf(0));
			symbol_453.setIsUnique(false);
			
			symbol_452.getOwnedParameters().add(symbol_453);
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::Sequence::excluding() ocl|Sequence{T}|excluding(ocl|OclAny)
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("excluding");
			symbol_454.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_454.setLower(BigInteger.valueOf(0));
			symbol_454.setIsUnique(false);
			
			Parameter symbol_455 = PivotFactory.eINSTANCE.createParameter();
			symbol_455.setName("object");
			symbol_455.setType(symbol_53);  // ocl|OclAny
			symbol_455.setLower(BigInteger.valueOf(0));
			symbol_455.setIsUnique(false);
			
			symbol_454.getOwnedParameters().add(symbol_455);
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::Sequence::flatten() ocl|Sequence{T}|flatten{T2}()
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_86.setName("T2");
			symbol_85.setOwnedParameteredElement(symbol_86);
			symbol_84.getOwnedParameters().add(symbol_85);
			
			symbol_456.setOwnedTemplateSignature(symbol_84);
			symbol_456.setName("flatten");
			symbol_456.setType(symbol_170);  // ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
			symbol_456.setLower(BigInteger.valueOf(0));
			symbol_456.setIsUnique(false);
			
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_456);
		}
		{	// ocl::Sequence::including() ocl|Sequence{T}|including(ocl|Sequence{T}?T)
			Operation symbol_457 = PivotFactory.eINSTANCE.createOperation();
			symbol_457.setName("including");
			symbol_457.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_457.setLower(BigInteger.valueOf(0));
			symbol_457.setIsUnique(false);
			
			Parameter symbol_458 = PivotFactory.eINSTANCE.createParameter();
			symbol_458.setName("object");
			symbol_458.setType(symbol_83);  // ocl|Sequence{T}?T
			symbol_458.setLower(BigInteger.valueOf(0));
			symbol_458.setIsUnique(false);
			
			symbol_457.getOwnedParameters().add(symbol_458);
			symbol_457.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_457);
		}
		{	// ocl::Sequence::insertAt() ocl|Sequence{T}|insertAt(Integer,ocl|Sequence{T}?T)
			Operation symbol_459 = PivotFactory.eINSTANCE.createOperation();
			symbol_459.setName("insertAt");
			symbol_459.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_459.setLower(BigInteger.valueOf(0));
			symbol_459.setIsUnique(false);
			
			Parameter symbol_460 = PivotFactory.eINSTANCE.createParameter();
			symbol_460.setName("index");
			symbol_460.setType(symbol_44);  // Integer
			symbol_460.setLower(BigInteger.valueOf(0));
			symbol_460.setIsUnique(false);
			
			symbol_459.getOwnedParameters().add(symbol_460);
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("object");
			symbol_461.setType(symbol_83);  // ocl|Sequence{T}?T
			symbol_461.setLower(BigInteger.valueOf(0));
			symbol_461.setIsUnique(false);
			
			symbol_459.getOwnedParameters().add(symbol_461);
			symbol_459.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_459);
		}
		{	// ocl::Sequence::prepend() ocl|Sequence{T}|prepend(ocl|Sequence{T}?T)
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("prepend");
			symbol_462.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_462.setLower(BigInteger.valueOf(0));
			symbol_462.setIsUnique(false);
			
			Parameter symbol_463 = PivotFactory.eINSTANCE.createParameter();
			symbol_463.setName("object");
			symbol_463.setType(symbol_83);  // ocl|Sequence{T}?T
			symbol_463.setLower(BigInteger.valueOf(0));
			symbol_463.setIsUnique(false);
			
			symbol_462.getOwnedParameters().add(symbol_463);
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::Sequence::reject() ocl|Sequence{T}|reject(ocl|Sequence{T}?T)
			Iteration symbol_464 = PivotFactory.eINSTANCE.createIteration();
			symbol_464.setName("reject");
			symbol_464.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("i");
			symbol_465.setType(symbol_83);  // ocl|Sequence{T}?T
			symbol_464.getOwnedIterators().add(symbol_465);
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::Sequence::reverse() ocl|Sequence{T}|reverse()
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_466.setName("reverse");
			symbol_466.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_466.setLower(BigInteger.valueOf(0));
			symbol_466.setIsUnique(false);
			
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::Sequence::select() ocl|Sequence{T}|select(ocl|Sequence{T}?T)
			Iteration symbol_467 = PivotFactory.eINSTANCE.createIteration();
			symbol_467.setName("select");
			symbol_467.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("i");
			symbol_468.setType(symbol_83);  // ocl|Sequence{T}?T
			symbol_467.getOwnedIterators().add(symbol_468);
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::Sequence::subSequence() ocl|Sequence{T}|subSequence(Integer,Integer)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("subSequence");
			symbol_469.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_469.setLower(BigInteger.valueOf(0));
			symbol_469.setIsUnique(false);
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("lower");
			symbol_470.setType(symbol_44);  // Integer
			symbol_470.setLower(BigInteger.valueOf(0));
			symbol_470.setIsUnique(false);
			
			symbol_469.getOwnedParameters().add(symbol_470);
			Parameter symbol_471 = PivotFactory.eINSTANCE.createParameter();
			symbol_471.setName("upper");
			symbol_471.setType(symbol_44);  // Integer
			symbol_471.setLower(BigInteger.valueOf(0));
			symbol_471.setIsUnique(false);
			
			symbol_469.getOwnedParameters().add(symbol_471);
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::Sequence::union() ocl|Sequence{T}|union(ocl|Sequence[ocl|Sequence{T}?T])
			Operation symbol_472 = PivotFactory.eINSTANCE.createOperation();
			symbol_472.setName("union");
			symbol_472.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_472.setLower(BigInteger.valueOf(0));
			symbol_472.setIsUnique(false);
			
			Parameter symbol_473 = PivotFactory.eINSTANCE.createParameter();
			symbol_473.setName("s");
			symbol_473.setType(symbol_171);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_473.setLower(BigInteger.valueOf(0));
			symbol_473.setIsUnique(false);
			
			symbol_472.getOwnedParameters().add(symbol_473);
			symbol_472.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_472);
		}
		symbol_1.getOwnedTypes().add(symbol_80);
		//
		// ocl::Set ocl|Set{T}
		//
		symbol_87.setName("Set");
		symbol_87.setElementType(symbol_90);
		symbol_90.setName("T");
		symbol_89.setOwnedParameteredElement(symbol_90);
		symbol_88.getOwnedParameters().add(symbol_89);
		
		symbol_87.setOwnedTemplateSignature(symbol_88);
		symbol_87.getSuperClasses().add(symbol_193); // ocl|UniqueCollection[ocl|Set{T}?T]
		symbol_87.getSuperClasses().add(symbol_131); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		{	// ocl::Set::-() ocl|Set{T}|-(ocl|Set[ocl|OclAny])
			Operation symbol_474 = PivotFactory.eINSTANCE.createOperation();
			symbol_474.setName("-");
			symbol_474.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			symbol_474.setLower(BigInteger.valueOf(0));
			symbol_474.setIsUnique(false);
			
			Parameter symbol_475 = PivotFactory.eINSTANCE.createParameter();
			symbol_475.setName("s");
			symbol_475.setType(symbol_177);  // ocl|Set[ocl|OclAny]
			symbol_475.setLower(BigInteger.valueOf(0));
			symbol_475.setIsUnique(false);
			
			symbol_474.getOwnedParameters().add(symbol_475);
			symbol_474.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_474);
		}
		{	// ocl::Set::<>() ocl|Set{T}|<>(ocl|OclAny)
			Operation symbol_476 = PivotFactory.eINSTANCE.createOperation();
			symbol_476.setName("<>");
			symbol_476.setType(symbol_19);  // Boolean
			symbol_476.setLower(BigInteger.valueOf(0));
			symbol_476.setIsUnique(false);
			
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("object2");
			symbol_477.setType(symbol_53);  // ocl|OclAny
			symbol_477.setLower(BigInteger.valueOf(0));
			symbol_477.setIsUnique(false);
			
			symbol_476.getOwnedParameters().add(symbol_477);
			symbol_476.setPrecedence(symbol_7);
			symbol_476.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_476);
		}
		{	// ocl::Set::=() ocl|Set{T}|=(ocl|OclAny)
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("=");
			symbol_478.setType(symbol_19);  // Boolean
			symbol_478.setLower(BigInteger.valueOf(0));
			symbol_478.setIsUnique(false);
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("object2");
			symbol_479.setType(symbol_53);  // ocl|OclAny
			symbol_479.setLower(BigInteger.valueOf(0));
			symbol_479.setIsUnique(false);
			
			symbol_478.getOwnedParameters().add(symbol_479);
			symbol_478.setPrecedence(symbol_7);
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::Set::excluding() ocl|Set{T}|excluding(ocl|OclAny)
			Operation symbol_480 = PivotFactory.eINSTANCE.createOperation();
			symbol_480.setName("excluding");
			symbol_480.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			symbol_480.setLower(BigInteger.valueOf(0));
			symbol_480.setIsUnique(false);
			
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("object");
			symbol_481.setType(symbol_53);  // ocl|OclAny
			symbol_481.setLower(BigInteger.valueOf(0));
			symbol_481.setIsUnique(false);
			
			symbol_480.getOwnedParameters().add(symbol_481);
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::Set::flatten() ocl|Set{T}|flatten{T2}()
			Operation symbol_482 = PivotFactory.eINSTANCE.createOperation();
			symbol_93.setName("T2");
			symbol_92.setOwnedParameteredElement(symbol_93);
			symbol_91.getOwnedParameters().add(symbol_92);
			
			symbol_482.setOwnedTemplateSignature(symbol_91);
			symbol_482.setName("flatten");
			symbol_482.setType(symbol_174);  // ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
			symbol_482.setLower(BigInteger.valueOf(0));
			symbol_482.setIsUnique(false);
			
			symbol_482.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_482);
		}
		{	// ocl::Set::including() ocl|Set{T}|including(ocl|Set{T}?T)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("including");
			symbol_483.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			symbol_483.setLower(BigInteger.valueOf(0));
			symbol_483.setIsUnique(false);
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("object");
			symbol_484.setType(symbol_90);  // ocl|Set{T}?T
			symbol_484.setLower(BigInteger.valueOf(0));
			symbol_484.setIsUnique(false);
			
			symbol_483.getOwnedParameters().add(symbol_484);
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::Set::intersection() ocl|Set{T}|intersection(ocl|Set[ocl|Set{T}?T])
			Operation symbol_485 = PivotFactory.eINSTANCE.createOperation();
			symbol_485.setName("intersection");
			symbol_485.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			symbol_485.setLower(BigInteger.valueOf(0));
			symbol_485.setIsUnique(false);
			
			Parameter symbol_486 = PivotFactory.eINSTANCE.createParameter();
			symbol_486.setName("s");
			symbol_486.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			symbol_486.setLower(BigInteger.valueOf(0));
			symbol_486.setIsUnique(false);
			
			symbol_485.getOwnedParameters().add(symbol_486);
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::Set::reject() ocl|Set{T}|reject(ocl|Set{T}?T)
			Iteration symbol_487 = PivotFactory.eINSTANCE.createIteration();
			symbol_487.setName("reject");
			symbol_487.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			
			Parameter symbol_488 = PivotFactory.eINSTANCE.createParameter();
			symbol_488.setName("i");
			symbol_488.setType(symbol_90);  // ocl|Set{T}?T
			symbol_487.getOwnedIterators().add(symbol_488);
			symbol_487.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_487);
		}
		{	// ocl::Set::select() ocl|Set{T}|select(ocl|Set{T}?T)
			Iteration symbol_489 = PivotFactory.eINSTANCE.createIteration();
			symbol_489.setName("select");
			symbol_489.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("i");
			symbol_490.setType(symbol_90);  // ocl|Set{T}?T
			symbol_489.getOwnedIterators().add(symbol_490);
			symbol_489.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_489);
		}
		{	// ocl::Set::symmetricDifference() ocl|Set{T}|symmetricDifference(ocl|Set[ocl|OclAny])
			Operation symbol_491 = PivotFactory.eINSTANCE.createOperation();
			symbol_491.setName("symmetricDifference");
			symbol_491.setType(symbol_178);  // ocl|Set[ocl|Set{T}?T]
			symbol_491.setLower(BigInteger.valueOf(0));
			symbol_491.setIsUnique(false);
			
			Parameter symbol_492 = PivotFactory.eINSTANCE.createParameter();
			symbol_492.setName("s");
			symbol_492.setType(symbol_177);  // ocl|Set[ocl|OclAny]
			symbol_492.setLower(BigInteger.valueOf(0));
			symbol_492.setIsUnique(false);
			
			symbol_491.getOwnedParameters().add(symbol_492);
			symbol_491.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_491);
		}
		symbol_1.getOwnedTypes().add(symbol_87);
		//
		// ocl::String String
		//
		symbol_94.setName("String");
		symbol_94.getSuperClasses().add(symbol_53); // ocl|OclAny
		{	// ocl::String::+() String|+(String)
			Operation symbol_493 = PivotFactory.eINSTANCE.createOperation();
			symbol_493.setName("+");
			symbol_493.setType(symbol_94);  // String
			symbol_493.setLower(BigInteger.valueOf(0));
			symbol_493.setIsUnique(false);
			
			Parameter symbol_494 = PivotFactory.eINSTANCE.createParameter();
			symbol_494.setName("s");
			symbol_494.setType(symbol_94);  // String
			symbol_494.setLower(BigInteger.valueOf(0));
			symbol_494.setIsUnique(false);
			
			symbol_493.getOwnedParameters().add(symbol_494);
			symbol_493.setPrecedence(symbol_5);
			symbol_493.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_493);
		}
		{	// ocl::String::<() String|<(String)
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("<");
			symbol_495.setType(symbol_19);  // Boolean
			symbol_495.setLower(BigInteger.valueOf(0));
			symbol_495.setIsUnique(false);
			
			Parameter symbol_496 = PivotFactory.eINSTANCE.createParameter();
			symbol_496.setName("s");
			symbol_496.setType(symbol_94);  // String
			symbol_496.setLower(BigInteger.valueOf(0));
			symbol_496.setIsUnique(false);
			
			symbol_495.getOwnedParameters().add(symbol_496);
			symbol_495.setPrecedence(symbol_6);
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::String::<=() String|<=(String)
			Operation symbol_497 = PivotFactory.eINSTANCE.createOperation();
			symbol_497.setName("<=");
			symbol_497.setType(symbol_19);  // Boolean
			symbol_497.setLower(BigInteger.valueOf(0));
			symbol_497.setIsUnique(false);
			
			Parameter symbol_498 = PivotFactory.eINSTANCE.createParameter();
			symbol_498.setName("s");
			symbol_498.setType(symbol_94);  // String
			symbol_498.setLower(BigInteger.valueOf(0));
			symbol_498.setIsUnique(false);
			
			symbol_497.getOwnedParameters().add(symbol_498);
			symbol_497.setPrecedence(symbol_6);
			symbol_497.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_497);
		}
		{	// ocl::String::<>() String|<>(ocl|OclAny)
			Operation symbol_499 = PivotFactory.eINSTANCE.createOperation();
			symbol_499.setName("<>");
			symbol_499.setType(symbol_19);  // Boolean
			symbol_499.setLower(BigInteger.valueOf(0));
			symbol_499.setIsUnique(false);
			
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("object2");
			symbol_500.setType(symbol_53);  // ocl|OclAny
			symbol_500.setLower(BigInteger.valueOf(0));
			symbol_500.setIsUnique(false);
			
			symbol_499.getOwnedParameters().add(symbol_500);
			symbol_499.setPrecedence(symbol_7);
			symbol_499.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_499);
		}
		{	// ocl::String::=() String|=(ocl|OclAny)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("=");
			symbol_501.setType(symbol_19);  // Boolean
			symbol_501.setLower(BigInteger.valueOf(0));
			symbol_501.setIsUnique(false);
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("object2");
			symbol_502.setType(symbol_53);  // ocl|OclAny
			symbol_502.setLower(BigInteger.valueOf(0));
			symbol_502.setIsUnique(false);
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setPrecedence(symbol_7);
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::String::>() String|>(String)
			Operation symbol_503 = PivotFactory.eINSTANCE.createOperation();
			symbol_503.setName(">");
			symbol_503.setType(symbol_19);  // Boolean
			symbol_503.setLower(BigInteger.valueOf(0));
			symbol_503.setIsUnique(false);
			
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("s");
			symbol_504.setType(symbol_94);  // String
			symbol_504.setLower(BigInteger.valueOf(0));
			symbol_504.setIsUnique(false);
			
			symbol_503.getOwnedParameters().add(symbol_504);
			symbol_503.setPrecedence(symbol_6);
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::String::>=() String|>=(String)
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName(">=");
			symbol_505.setType(symbol_19);  // Boolean
			symbol_505.setLower(BigInteger.valueOf(0));
			symbol_505.setIsUnique(false);
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("s");
			symbol_506.setType(symbol_94);  // String
			symbol_506.setLower(BigInteger.valueOf(0));
			symbol_506.setIsUnique(false);
			
			symbol_505.getOwnedParameters().add(symbol_506);
			symbol_505.setPrecedence(symbol_6);
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::String::at() String|at(Integer)
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("at");
			symbol_507.setType(symbol_94);  // String
			symbol_507.setLower(BigInteger.valueOf(0));
			symbol_507.setIsUnique(false);
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("i");
			symbol_508.setType(symbol_44);  // Integer
			symbol_508.setLower(BigInteger.valueOf(0));
			symbol_508.setIsUnique(false);
			
			symbol_507.getOwnedParameters().add(symbol_508);
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::String::characters() String|characters()
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_509.setName("characters");
			symbol_509.setType(symbol_169);  // ocl|Sequence[String]
			symbol_509.setLower(BigInteger.valueOf(0));
			symbol_509.setIsUnique(false);
			
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::String::concat() String|concat(String)
			Operation symbol_510 = PivotFactory.eINSTANCE.createOperation();
			symbol_510.setName("concat");
			symbol_510.setType(symbol_94);  // String
			symbol_510.setLower(BigInteger.valueOf(0));
			symbol_510.setIsUnique(false);
			
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("s");
			symbol_511.setType(symbol_94);  // String
			symbol_511.setLower(BigInteger.valueOf(0));
			symbol_511.setIsUnique(false);
			
			symbol_510.getOwnedParameters().add(symbol_511);
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::String::equalsIgnoreCase() String|equalsIgnoreCase(String)
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("equalsIgnoreCase");
			symbol_512.setType(symbol_19);  // Boolean
			symbol_512.setLower(BigInteger.valueOf(0));
			symbol_512.setIsUnique(false);
			
			Parameter symbol_513 = PivotFactory.eINSTANCE.createParameter();
			symbol_513.setName("s");
			symbol_513.setType(symbol_94);  // String
			symbol_513.setLower(BigInteger.valueOf(0));
			symbol_513.setIsUnique(false);
			
			symbol_512.getOwnedParameters().add(symbol_513);
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_512);
		}
		{	// ocl::String::indexOf() String|indexOf(String)
			Operation symbol_514 = PivotFactory.eINSTANCE.createOperation();
			symbol_514.setName("indexOf");
			symbol_514.setType(symbol_44);  // Integer
			symbol_514.setLower(BigInteger.valueOf(0));
			symbol_514.setIsUnique(false);
			
			Parameter symbol_515 = PivotFactory.eINSTANCE.createParameter();
			symbol_515.setName("s");
			symbol_515.setType(symbol_94);  // String
			symbol_515.setLower(BigInteger.valueOf(0));
			symbol_515.setIsUnique(false);
			
			symbol_514.getOwnedParameters().add(symbol_515);
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::String::size() String|size()
			Operation symbol_516 = PivotFactory.eINSTANCE.createOperation();
			symbol_516.setName("size");
			symbol_516.setType(symbol_44);  // Integer
			symbol_516.setLower(BigInteger.valueOf(0));
			symbol_516.setIsUnique(false);
			
			symbol_516.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_516);
		}
		{	// ocl::String::substring() String|substring(Integer,Integer)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("substring");
			symbol_517.setType(symbol_94);  // String
			symbol_517.setLower(BigInteger.valueOf(0));
			symbol_517.setIsUnique(false);
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("lower");
			symbol_518.setType(symbol_44);  // Integer
			symbol_518.setLower(BigInteger.valueOf(0));
			symbol_518.setIsUnique(false);
			
			symbol_517.getOwnedParameters().add(symbol_518);
			Parameter symbol_519 = PivotFactory.eINSTANCE.createParameter();
			symbol_519.setName("upper");
			symbol_519.setType(symbol_44);  // Integer
			symbol_519.setLower(BigInteger.valueOf(0));
			symbol_519.setIsUnique(false);
			
			symbol_517.getOwnedParameters().add(symbol_519);
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::String::toBoolean() String|toBoolean()
			Operation symbol_520 = PivotFactory.eINSTANCE.createOperation();
			symbol_520.setName("toBoolean");
			symbol_520.setType(symbol_19);  // Boolean
			symbol_520.setLower(BigInteger.valueOf(0));
			symbol_520.setIsUnique(false);
			
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::String::toInteger() String|toInteger()
			Operation symbol_521 = PivotFactory.eINSTANCE.createOperation();
			symbol_521.setName("toInteger");
			symbol_521.setType(symbol_44);  // Integer
			symbol_521.setLower(BigInteger.valueOf(0));
			symbol_521.setIsUnique(false);
			
			symbol_521.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_521);
		}
		{	// ocl::String::toLowerCase() String|toLowerCase()
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("toLowerCase");
			symbol_522.setType(symbol_94);  // String
			symbol_522.setLower(BigInteger.valueOf(0));
			symbol_522.setIsUnique(false);
			
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::String::toReal() String|toReal()
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("toReal");
			symbol_523.setType(symbol_76);  // Real
			symbol_523.setLower(BigInteger.valueOf(0));
			symbol_523.setIsUnique(false);
			
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::String::toString() String|toString()
			Operation symbol_524 = PivotFactory.eINSTANCE.createOperation();
			symbol_524.setName("toString");
			symbol_524.setType(symbol_94);  // String
			symbol_524.setLower(BigInteger.valueOf(0));
			symbol_524.setIsUnique(false);
			
			symbol_524.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_524);
		}
		{	// ocl::String::toUpperCase() String|toUpperCase()
			Operation symbol_525 = PivotFactory.eINSTANCE.createOperation();
			symbol_525.setName("toUpperCase");
			symbol_525.setType(symbol_94);  // String
			symbol_525.setLower(BigInteger.valueOf(0));
			symbol_525.setIsUnique(false);
			
			symbol_525.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_525);
		}
		symbol_1.getOwnedTypes().add(symbol_94);
		//
		// ocl::UniqueCollection ocl|UniqueCollection{T}
		//
		symbol_95.setName("UniqueCollection");
		symbol_95.setElementType(symbol_98);
		symbol_98.setName("T");
		symbol_97.setOwnedParameteredElement(symbol_98);
		symbol_96.getOwnedParameters().add(symbol_97);
		
		symbol_95.setOwnedTemplateSignature(symbol_96);
		symbol_95.getSuperClasses().add(symbol_116); // ocl|Collection[ocl|UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl|UniqueCollection{T}|sortedBy(ocl|UniqueCollection{T}?T)
			Iteration symbol_526 = PivotFactory.eINSTANCE.createIteration();
			symbol_526.setName("sortedBy");
			symbol_526.setType(symbol_165);  // ocl|OrderedSet[ocl|UniqueCollection{T}?T]
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("i");
			symbol_527.setType(symbol_98);  // ocl|UniqueCollection{T}?T
			symbol_526.getOwnedIterators().add(symbol_527);
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_95.getOwnedOperations().add(symbol_526);
		}
		symbol_1.getOwnedTypes().add(symbol_95);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_99.setName("UnlimitedNatural");
		symbol_99.getSuperClasses().add(symbol_44); // Integer
		symbol_1.getOwnedTypes().add(symbol_99);
		//
		// ocl::orphanage
		//
		symbol_100.setName("orphanage");
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|NonOrderedCollection{T}?T]
		//
		symbol_101.setName("Bag");
		symbol_101.setElementType(symbol_48);
		{
			TemplateBinding symbol_528 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_528.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_529 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_529.setFormal(symbol_14);	
				symbol_529.setActual(symbol_48);	
				symbol_528.getParameterSubstitutions().add(symbol_529);
			}
			symbol_101.getTemplateBindings().add(symbol_528);
		}
		symbol_101.getSuperClasses().add(symbol_133); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		symbol_101.getSuperClasses().add(symbol_151); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_101);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Collection{T}?T]
		//
		symbol_102.setName("Bag");
		symbol_102.setElementType(symbol_27);
		{
			TemplateBinding symbol_530 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_530.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_531 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_531.setFormal(symbol_14);	
				symbol_531.setActual(symbol_27);	
				symbol_530.getParameterSubstitutions().add(symbol_531);
			}
			symbol_102.getTemplateBindings().add(symbol_530);
		}
		symbol_102.getSuperClasses().add(symbol_146); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		symbol_102.getSuperClasses().add(symbol_142); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_102);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_103.setName("Bag");
		symbol_103.setElementType(symbol_18);
		{
			TemplateBinding symbol_532 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_532.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_533 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_533.setFormal(symbol_14);	
				symbol_533.setActual(symbol_18);	
				symbol_532.getParameterSubstitutions().add(symbol_533);
			}
			symbol_103.getTemplateBindings().add(symbol_532);
		}
		symbol_103.getSuperClasses().add(symbol_140); // ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_103.getSuperClasses().add(symbol_147); // ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_103);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Bag{T}?T]
		//
		symbol_104.setName("Bag");
		symbol_104.setElementType(symbol_15);
		{
			TemplateBinding symbol_534 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_534.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_535 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_535.setFormal(symbol_14);	
				symbol_535.setActual(symbol_15);	
				symbol_534.getParameterSubstitutions().add(symbol_535);
			}
			symbol_104.getTemplateBindings().add(symbol_534);
		}
		symbol_104.getSuperClasses().add(symbol_143); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		symbol_104.getSuperClasses().add(symbol_153); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		symbol_100.getOwnedTypes().add(symbol_104);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
		//
		symbol_105.setName("Collection");
		symbol_105.setElementType(symbol_33);
		{
			TemplateBinding symbol_536 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_536.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_537 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_537.setFormal(symbol_26);	
				symbol_537.setActual(symbol_33);	
				symbol_536.getParameterSubstitutions().add(symbol_537);
			}
			symbol_105.getTemplateBindings().add(symbol_536);
		}
		symbol_105.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_105);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_106.setName("Collection");
		symbol_106.setElementType(symbol_18);
		{
			TemplateBinding symbol_538 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_538.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_539 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_539.setFormal(symbol_26);	
				symbol_539.setActual(symbol_18);	
				symbol_538.getParameterSubstitutions().add(symbol_539);
			}
			symbol_106.getTemplateBindings().add(symbol_538);
		}
		symbol_106.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_106);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Bag{T}?T]
		//
		symbol_107.setName("Collection");
		symbol_107.setElementType(symbol_15);
		{
			TemplateBinding symbol_540 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_540.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_541 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_541.setFormal(symbol_26);	
				symbol_541.setActual(symbol_15);	
				symbol_540.getParameterSubstitutions().add(symbol_541);
			}
			symbol_107.getTemplateBindings().add(symbol_540);
		}
		symbol_107.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_107);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_108.setName("Collection");
		symbol_108.setElementType(symbol_93);
		{
			TemplateBinding symbol_542 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_542.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_543 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_543.setFormal(symbol_26);	
				symbol_543.setActual(symbol_93);	
				symbol_542.getParameterSubstitutions().add(symbol_543);
			}
			symbol_108.getTemplateBindings().add(symbol_542);
		}
		symbol_108.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_108);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Set{T}?T]
		//
		symbol_109.setName("Collection");
		symbol_109.setElementType(symbol_90);
		{
			TemplateBinding symbol_544 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_544.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_545 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_545.setFormal(symbol_26);	
				symbol_545.setActual(symbol_90);	
				symbol_544.getParameterSubstitutions().add(symbol_545);
			}
			symbol_109.getTemplateBindings().add(symbol_544);
		}
		symbol_109.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_109);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
		//
		symbol_110.setName("Collection");
		symbol_110.setElementType(symbol_30);
		{
			TemplateBinding symbol_546 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_546.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_547 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_547.setFormal(symbol_26);	
				symbol_547.setActual(symbol_30);	
				symbol_546.getParameterSubstitutions().add(symbol_547);
			}
			symbol_110.getTemplateBindings().add(symbol_546);
		}
		symbol_110.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_110);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Enumeration]
		//
		symbol_111.setName("Collection");
		symbol_111.setElementType(symbol_43);
		{
			TemplateBinding symbol_548 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_548.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_549 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_549.setFormal(symbol_26);	
				symbol_549.setActual(symbol_43);	
				symbol_548.getParameterSubstitutions().add(symbol_549);
			}
			symbol_111.getTemplateBindings().add(symbol_548);
		}
		symbol_111.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_111);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
		//
		symbol_112.setName("Collection");
		symbol_112.setElementType(symbol_36);
		{
			TemplateBinding symbol_550 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_550.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_551 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_551.setFormal(symbol_26);	
				symbol_551.setActual(symbol_36);	
				symbol_550.getParameterSubstitutions().add(symbol_551);
			}
			symbol_112.getTemplateBindings().add(symbol_550);
		}
		symbol_112.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_112);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_113.setName("Collection");
		symbol_113.setElementType(symbol_86);
		{
			TemplateBinding symbol_552 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_552.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_553 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_553.setFormal(symbol_26);	
				symbol_553.setActual(symbol_86);	
				symbol_552.getParameterSubstitutions().add(symbol_553);
			}
			symbol_113.getTemplateBindings().add(symbol_552);
		}
		symbol_113.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_113);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_114.setName("Collection");
		symbol_114.setElementType(symbol_48);
		{
			TemplateBinding symbol_554 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_554.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_555 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_555.setFormal(symbol_26);	
				symbol_555.setActual(symbol_48);	
				symbol_554.getParameterSubstitutions().add(symbol_555);
			}
			symbol_114.getTemplateBindings().add(symbol_554);
		}
		symbol_114.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_114);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}?T]
		//
		symbol_115.setName("Collection");
		symbol_115.setElementType(symbol_27);
		{
			TemplateBinding symbol_556 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_556.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_557 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_557.setFormal(symbol_26);	
				symbol_557.setActual(symbol_27);	
				symbol_556.getParameterSubstitutions().add(symbol_557);
			}
			symbol_115.getTemplateBindings().add(symbol_556);
		}
		symbol_115.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_115);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|UniqueCollection{T}?T]
		//
		symbol_116.setName("Collection");
		symbol_116.setElementType(symbol_98);
		{
			TemplateBinding symbol_558 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_558.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_559 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_559.setFormal(symbol_26);	
				symbol_559.setActual(symbol_98);	
				symbol_558.getParameterSubstitutions().add(symbol_559);
			}
			symbol_116.getTemplateBindings().add(symbol_558);
		}
		symbol_116.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_116);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_117.setName("Collection");
		symbol_117.setElementType(symbol_52);
		{
			TemplateBinding symbol_560 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_560.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_561 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_561.setFormal(symbol_26);	
				symbol_561.setActual(symbol_52);	
				symbol_560.getParameterSubstitutions().add(symbol_561);
			}
			symbol_117.getTemplateBindings().add(symbol_560);
		}
		symbol_117.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_117);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclAny]
		//
		symbol_118.setName("Collection");
		symbol_118.setElementType(symbol_53);
		{
			TemplateBinding symbol_562 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_562.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_563 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_563.setFormal(symbol_26);	
				symbol_563.setActual(symbol_53);	
				symbol_562.getParameterSubstitutions().add(symbol_563);
			}
			symbol_118.getTemplateBindings().add(symbol_562);
		}
		symbol_118.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_118);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_119.setName("Collection");
		symbol_119.setElementType(symbol_23);
		{
			TemplateBinding symbol_564 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_564.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_565 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_565.setFormal(symbol_26);	
				symbol_565.setActual(symbol_23);	
				symbol_564.getParameterSubstitutions().add(symbol_565);
			}
			symbol_119.getTemplateBindings().add(symbol_564);
		}
		symbol_119.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_119);
		//
		// ocl::orphanage::Collection ocl|Collection[String]
		//
		symbol_120.setName("Collection");
		symbol_120.setElementType(symbol_94);
		{
			TemplateBinding symbol_566 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_566.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_567 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_567.setFormal(symbol_26);	
				symbol_567.setActual(symbol_94);	
				symbol_566.getParameterSubstitutions().add(symbol_567);
			}
			symbol_120.getTemplateBindings().add(symbol_566);
		}
		symbol_120.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_120);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedCollection{T}?T]
		//
		symbol_121.setName("Collection");
		symbol_121.setElementType(symbol_71);
		{
			TemplateBinding symbol_568 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_568.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_569 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_569.setFormal(symbol_26);	
				symbol_569.setActual(symbol_71);	
				symbol_568.getParameterSubstitutions().add(symbol_569);
			}
			symbol_121.getTemplateBindings().add(symbol_568);
		}
		symbol_121.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_121);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedSet{T}?T]
		//
		symbol_122.setName("Collection");
		symbol_122.setElementType(symbol_75);
		{
			TemplateBinding symbol_570 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_570.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_571 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_571.setFormal(symbol_26);	
				symbol_571.setActual(symbol_75);	
				symbol_570.getParameterSubstitutions().add(symbol_571);
			}
			symbol_122.getTemplateBindings().add(symbol_570);
		}
		symbol_122.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_122);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_123.setName("Collection");
		symbol_123.setElementType(symbol_56);
		{
			TemplateBinding symbol_572 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_572.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_573 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_573.setFormal(symbol_26);	
				symbol_573.setActual(symbol_56);	
				symbol_572.getParameterSubstitutions().add(symbol_573);
			}
			symbol_123.getTemplateBindings().add(symbol_572);
		}
		symbol_123.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_123);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
		//
		symbol_124.setName("Collection");
		symbol_124.setElementType(symbol_42);
		{
			TemplateBinding symbol_574 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_574.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_575 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_575.setFormal(symbol_26);	
				symbol_575.setActual(symbol_42);	
				symbol_574.getParameterSubstitutions().add(symbol_575);
			}
			symbol_124.getTemplateBindings().add(symbol_574);
		}
		symbol_124.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_124);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclInvalid]
		//
		symbol_125.setName("Collection");
		symbol_125.setElementType(symbol_63);
		{
			TemplateBinding symbol_576 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_576.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_577 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_577.setFormal(symbol_26);	
				symbol_577.setActual(symbol_63);	
				symbol_576.getParameterSubstitutions().add(symbol_577);
			}
			symbol_125.getTemplateBindings().add(symbol_576);
		}
		symbol_125.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_125);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Sequence{T}?T]
		//
		symbol_126.setName("Collection");
		symbol_126.setElementType(symbol_83);
		{
			TemplateBinding symbol_578 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_578.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_579 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_579.setFormal(symbol_26);	
				symbol_579.setActual(symbol_83);	
				symbol_578.getParameterSubstitutions().add(symbol_579);
			}
			symbol_126.getTemplateBindings().add(symbol_578);
		}
		symbol_126.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_126);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclVoid]
		//
		symbol_127.setName("Collection");
		symbol_127.setElementType(symbol_67);
		{
			TemplateBinding symbol_580 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_580.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_581 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_581.setFormal(symbol_26);	
				symbol_581.setActual(symbol_67);	
				symbol_580.getParameterSubstitutions().add(symbol_581);
			}
			symbol_127.getTemplateBindings().add(symbol_580);
		}
		symbol_127.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_127);
		//
		// ocl::orphanage::Collection ocl|Collection[Boolean]
		//
		symbol_128.setName("Collection");
		symbol_128.setElementType(symbol_19);
		{
			TemplateBinding symbol_582 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_582.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_583 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_583.setFormal(symbol_26);	
				symbol_583.setActual(symbol_19);	
				symbol_582.getParameterSubstitutions().add(symbol_583);
			}
			symbol_128.getTemplateBindings().add(symbol_582);
		}
		symbol_128.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_128);
		//
		// ocl::orphanage::Collection ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_129.setName("Collection");
		symbol_129.setElementType(symbol_185);
		{
			TemplateBinding symbol_584 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_584.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_585 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_585.setFormal(symbol_26);	
				symbol_585.setActual(symbol_185);	
				symbol_584.getParameterSubstitutions().add(symbol_585);
			}
			symbol_129.getTemplateBindings().add(symbol_584);
		}
		symbol_129.getSuperClasses().add(symbol_53); // ocl|OclAny
		symbol_100.getOwnedTypes().add(symbol_129);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		//
		symbol_130.setName("NonOrderedCollection");
		symbol_130.setElementType(symbol_75);
		{
			TemplateBinding symbol_586 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_586.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_587 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_587.setFormal(symbol_47);	
				symbol_587.setActual(symbol_75);	
				symbol_586.getParameterSubstitutions().add(symbol_587);
			}
			symbol_130.getTemplateBindings().add(symbol_586);
		}
		symbol_130.getSuperClasses().add(symbol_122); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_100.getOwnedTypes().add(symbol_130);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Set{T}?T]
		//
		symbol_131.setName("NonOrderedCollection");
		symbol_131.setElementType(symbol_90);
		{
			TemplateBinding symbol_588 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_588.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_589 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_589.setFormal(symbol_47);	
				symbol_589.setActual(symbol_90);	
				symbol_588.getParameterSubstitutions().add(symbol_589);
			}
			symbol_131.getTemplateBindings().add(symbol_588);
		}
		symbol_131.getSuperClasses().add(symbol_109); // ocl|Collection[ocl|Set{T}?T]
		symbol_100.getOwnedTypes().add(symbol_131);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_132.setName("NonOrderedCollection");
		symbol_132.setElementType(symbol_185);
		{
			TemplateBinding symbol_590 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_590.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_591 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_591.setFormal(symbol_47);	
				symbol_591.setActual(symbol_185);	
				symbol_590.getParameterSubstitutions().add(symbol_591);
			}
			symbol_132.getTemplateBindings().add(symbol_590);
		}
		symbol_132.getSuperClasses().add(symbol_129); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_100.getOwnedTypes().add(symbol_132);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_133.setName("NonOrderedCollection");
		symbol_133.setElementType(symbol_48);
		{
			TemplateBinding symbol_592 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_592.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_593 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_593.setFormal(symbol_47);	
				symbol_593.setActual(symbol_48);	
				symbol_592.getParameterSubstitutions().add(symbol_593);
			}
			symbol_133.getTemplateBindings().add(symbol_592);
		}
		symbol_133.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_133);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_134.setName("NonOrderedCollection");
		symbol_134.setElementType(symbol_93);
		{
			TemplateBinding symbol_594 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_594.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_595 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_595.setFormal(symbol_47);	
				symbol_595.setActual(symbol_93);	
				symbol_594.getParameterSubstitutions().add(symbol_595);
			}
			symbol_134.getTemplateBindings().add(symbol_594);
		}
		symbol_134.getSuperClasses().add(symbol_108); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_134);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Enumeration]
		//
		symbol_135.setName("NonOrderedCollection");
		symbol_135.setElementType(symbol_43);
		{
			TemplateBinding symbol_596 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_596.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_597 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_597.setFormal(symbol_47);	
				symbol_597.setActual(symbol_43);	
				symbol_596.getParameterSubstitutions().add(symbol_597);
			}
			symbol_135.getTemplateBindings().add(symbol_596);
		}
		symbol_135.getSuperClasses().add(symbol_111); // ocl|Collection[ocl|Enumeration]
		symbol_100.getOwnedTypes().add(symbol_135);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_136.setName("NonOrderedCollection");
		symbol_136.setElementType(symbol_23);
		{
			TemplateBinding symbol_598 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_598.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_599 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_599.setFormal(symbol_47);	
				symbol_599.setActual(symbol_23);	
				symbol_598.getParameterSubstitutions().add(symbol_599);
			}
			symbol_136.getTemplateBindings().add(symbol_598);
		}
		symbol_136.getSuperClasses().add(symbol_119); // ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_100.getOwnedTypes().add(symbol_136);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclVoid]
		//
		symbol_137.setName("NonOrderedCollection");
		symbol_137.setElementType(symbol_67);
		{
			TemplateBinding symbol_600 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_600.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_601 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_601.setFormal(symbol_47);	
				symbol_601.setActual(symbol_67);	
				symbol_600.getParameterSubstitutions().add(symbol_601);
			}
			symbol_137.getTemplateBindings().add(symbol_600);
		}
		symbol_137.getSuperClasses().add(symbol_127); // ocl|Collection[ocl|OclVoid]
		symbol_100.getOwnedTypes().add(symbol_137);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclAny]
		//
		symbol_138.setName("NonOrderedCollection");
		symbol_138.setElementType(symbol_53);
		{
			TemplateBinding symbol_602 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_602.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_603 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_603.setFormal(symbol_47);	
				symbol_603.setActual(symbol_53);	
				symbol_602.getParameterSubstitutions().add(symbol_603);
			}
			symbol_138.getTemplateBindings().add(symbol_602);
		}
		symbol_138.getSuperClasses().add(symbol_118); // ocl|Collection[ocl|OclAny]
		symbol_100.getOwnedTypes().add(symbol_138);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[Boolean]
		//
		symbol_139.setName("NonOrderedCollection");
		symbol_139.setElementType(symbol_19);
		{
			TemplateBinding symbol_604 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_604.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_605 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_605.setFormal(symbol_47);	
				symbol_605.setActual(symbol_19);	
				symbol_604.getParameterSubstitutions().add(symbol_605);
			}
			symbol_139.getTemplateBindings().add(symbol_604);
		}
		symbol_139.getSuperClasses().add(symbol_128); // ocl|Collection[Boolean]
		symbol_100.getOwnedTypes().add(symbol_139);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_140.setName("NonOrderedCollection");
		symbol_140.setElementType(symbol_18);
		{
			TemplateBinding symbol_606 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_606.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_607 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_607.setFormal(symbol_47);	
				symbol_607.setActual(symbol_18);	
				symbol_606.getParameterSubstitutions().add(symbol_607);
			}
			symbol_140.getTemplateBindings().add(symbol_606);
		}
		symbol_140.getSuperClasses().add(symbol_106); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_140);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_141.setName("NonOrderedCollection");
		symbol_141.setElementType(symbol_56);
		{
			TemplateBinding symbol_608 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_608.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_609 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_609.setFormal(symbol_47);	
				symbol_609.setActual(symbol_56);	
				symbol_608.getParameterSubstitutions().add(symbol_609);
			}
			symbol_141.getTemplateBindings().add(symbol_608);
		}
		symbol_141.getSuperClasses().add(symbol_123); // ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_100.getOwnedTypes().add(symbol_141);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Collection{T}?T]
		//
		symbol_142.setName("NonOrderedCollection");
		symbol_142.setElementType(symbol_27);
		{
			TemplateBinding symbol_610 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_610.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_611 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_611.setFormal(symbol_47);	
				symbol_611.setActual(symbol_27);	
				symbol_610.getParameterSubstitutions().add(symbol_611);
			}
			symbol_142.getTemplateBindings().add(symbol_610);
		}
		symbol_142.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_142);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Bag{T}?T]
		//
		symbol_143.setName("NonOrderedCollection");
		symbol_143.setElementType(symbol_15);
		{
			TemplateBinding symbol_612 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_612.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_613 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_613.setFormal(symbol_47);	
				symbol_613.setActual(symbol_15);	
				symbol_612.getParameterSubstitutions().add(symbol_613);
			}
			symbol_143.getTemplateBindings().add(symbol_612);
		}
		symbol_143.getSuperClasses().add(symbol_107); // ocl|Collection[ocl|Bag{T}?T]
		symbol_100.getOwnedTypes().add(symbol_143);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclInvalid]
		//
		symbol_144.setName("NonOrderedCollection");
		symbol_144.setElementType(symbol_63);
		{
			TemplateBinding symbol_614 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_614.setSignature(symbol_46);
			{
				TemplateParameterSubstitution symbol_615 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_615.setFormal(symbol_47);	
				symbol_615.setActual(symbol_63);	
				symbol_614.getParameterSubstitutions().add(symbol_615);
			}
			symbol_144.getTemplateBindings().add(symbol_614);
		}
		symbol_144.getSuperClasses().add(symbol_125); // ocl|Collection[ocl|OclInvalid]
		symbol_100.getOwnedTypes().add(symbol_144);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_145.setName("NonUniqueCollection");
		symbol_145.setElementType(symbol_52);
		{
			TemplateBinding symbol_616 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_616.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_617 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_617.setFormal(symbol_51);	
				symbol_617.setActual(symbol_52);	
				symbol_616.getParameterSubstitutions().add(symbol_617);
			}
			symbol_145.getTemplateBindings().add(symbol_616);
		}
		symbol_145.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_145);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Collection{T}?T]
		//
		symbol_146.setName("NonUniqueCollection");
		symbol_146.setElementType(symbol_27);
		{
			TemplateBinding symbol_618 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_618.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_619 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_619.setFormal(symbol_51);	
				symbol_619.setActual(symbol_27);	
				symbol_618.getParameterSubstitutions().add(symbol_619);
			}
			symbol_146.getTemplateBindings().add(symbol_618);
		}
		symbol_146.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_146);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_147.setName("NonUniqueCollection");
		symbol_147.setElementType(symbol_18);
		{
			TemplateBinding symbol_620 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_620.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_621 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_621.setFormal(symbol_51);	
				symbol_621.setActual(symbol_18);	
				symbol_620.getParameterSubstitutions().add(symbol_621);
			}
			symbol_147.getTemplateBindings().add(symbol_620);
		}
		symbol_147.getSuperClasses().add(symbol_106); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_147);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_148.setName("NonUniqueCollection");
		symbol_148.setElementType(symbol_71);
		{
			TemplateBinding symbol_622 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_622.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_623 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_623.setFormal(symbol_51);	
				symbol_623.setActual(symbol_71);	
				symbol_622.getParameterSubstitutions().add(symbol_623);
			}
			symbol_148.getTemplateBindings().add(symbol_622);
		}
		symbol_148.getSuperClasses().add(symbol_121); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_148);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[String]
		//
		symbol_149.setName("NonUniqueCollection");
		symbol_149.setElementType(symbol_94);
		{
			TemplateBinding symbol_624 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_624.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_625 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_625.setFormal(symbol_51);	
				symbol_625.setActual(symbol_94);	
				symbol_624.getParameterSubstitutions().add(symbol_625);
			}
			symbol_149.getTemplateBindings().add(symbol_624);
		}
		symbol_149.getSuperClasses().add(symbol_120); // ocl|Collection[String]
		symbol_100.getOwnedTypes().add(symbol_149);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		//
		symbol_150.setName("NonUniqueCollection");
		symbol_150.setElementType(symbol_83);
		{
			TemplateBinding symbol_626 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_626.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_627 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_627.setFormal(symbol_51);	
				symbol_627.setActual(symbol_83);	
				symbol_626.getParameterSubstitutions().add(symbol_627);
			}
			symbol_150.getTemplateBindings().add(symbol_626);
		}
		symbol_150.getSuperClasses().add(symbol_126); // ocl|Collection[ocl|Sequence{T}?T]
		symbol_100.getOwnedTypes().add(symbol_150);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_151.setName("NonUniqueCollection");
		symbol_151.setElementType(symbol_48);
		{
			TemplateBinding symbol_628 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_628.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_629 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_629.setFormal(symbol_51);	
				symbol_629.setActual(symbol_48);	
				symbol_628.getParameterSubstitutions().add(symbol_629);
			}
			symbol_151.getTemplateBindings().add(symbol_628);
		}
		symbol_151.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_151);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_152.setName("NonUniqueCollection");
		symbol_152.setElementType(symbol_86);
		{
			TemplateBinding symbol_630 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_630.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_631 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_631.setFormal(symbol_51);	
				symbol_631.setActual(symbol_86);	
				symbol_630.getParameterSubstitutions().add(symbol_631);
			}
			symbol_152.getTemplateBindings().add(symbol_630);
		}
		symbol_152.getSuperClasses().add(symbol_113); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_152);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Bag{T}?T]
		//
		symbol_153.setName("NonUniqueCollection");
		symbol_153.setElementType(symbol_15);
		{
			TemplateBinding symbol_632 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_632.setSignature(symbol_50);
			{
				TemplateParameterSubstitution symbol_633 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_633.setFormal(symbol_51);	
				symbol_633.setActual(symbol_15);	
				symbol_632.getParameterSubstitutions().add(symbol_633);
			}
			symbol_153.getTemplateBindings().add(symbol_632);
		}
		symbol_153.getSuperClasses().add(symbol_107); // ocl|Collection[ocl|Bag{T}?T]
		symbol_100.getOwnedTypes().add(symbol_153);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[String]
		//
		symbol_154.setName("OrderedCollection");
		symbol_154.setElementType(symbol_94);
		{
			TemplateBinding symbol_634 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_634.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_635 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_635.setFormal(symbol_70);	
				symbol_635.setActual(symbol_94);	
				symbol_634.getParameterSubstitutions().add(symbol_635);
			}
			symbol_154.getTemplateBindings().add(symbol_634);
		}
		symbol_154.getSuperClasses().add(symbol_120); // ocl|Collection[String]
		symbol_100.getOwnedTypes().add(symbol_154);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		//
		symbol_155.setName("OrderedCollection");
		symbol_155.setElementType(symbol_98);
		{
			TemplateBinding symbol_636 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_636.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_637 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_637.setFormal(symbol_70);	
				symbol_637.setActual(symbol_98);	
				symbol_636.getParameterSubstitutions().add(symbol_637);
			}
			symbol_155.getTemplateBindings().add(symbol_636);
		}
		symbol_155.getSuperClasses().add(symbol_116); // ocl|Collection[ocl|UniqueCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_155);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_156.setName("OrderedCollection");
		symbol_156.setElementType(symbol_71);
		{
			TemplateBinding symbol_638 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_638.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_639 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_639.setFormal(symbol_70);	
				symbol_639.setActual(symbol_71);	
				symbol_638.getParameterSubstitutions().add(symbol_639);
			}
			symbol_156.getTemplateBindings().add(symbol_638);
		}
		symbol_156.getSuperClasses().add(symbol_121); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_156);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_157.setName("OrderedCollection");
		symbol_157.setElementType(symbol_52);
		{
			TemplateBinding symbol_640 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_640.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_641 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_641.setFormal(symbol_70);	
				symbol_641.setActual(symbol_52);	
				symbol_640.getParameterSubstitutions().add(symbol_641);
			}
			symbol_157.getTemplateBindings().add(symbol_640);
		}
		symbol_157.getSuperClasses().add(symbol_117); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_157);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Sequence{T}?T]
		//
		symbol_158.setName("OrderedCollection");
		symbol_158.setElementType(symbol_83);
		{
			TemplateBinding symbol_642 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_642.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_643 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_643.setFormal(symbol_70);	
				symbol_643.setActual(symbol_83);	
				symbol_642.getParameterSubstitutions().add(symbol_643);
			}
			symbol_158.getTemplateBindings().add(symbol_642);
		}
		symbol_158.getSuperClasses().add(symbol_126); // ocl|Collection[ocl|Sequence{T}?T]
		symbol_100.getOwnedTypes().add(symbol_158);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Collection{T}?T]
		//
		symbol_159.setName("OrderedCollection");
		symbol_159.setElementType(symbol_27);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_70);	
				symbol_645.setActual(symbol_27);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_159.getTemplateBindings().add(symbol_644);
		}
		symbol_159.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_159);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		//
		symbol_160.setName("OrderedCollection");
		symbol_160.setElementType(symbol_75);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_70);	
				symbol_647.setActual(symbol_75);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_160.getTemplateBindings().add(symbol_646);
		}
		symbol_160.getSuperClasses().add(symbol_122); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_100.getOwnedTypes().add(symbol_160);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_161.setName("OrderedCollection");
		symbol_161.setElementType(symbol_86);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_69);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_70);	
				symbol_649.setActual(symbol_86);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_161.getTemplateBindings().add(symbol_648);
		}
		symbol_161.getSuperClasses().add(symbol_113); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_161);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|OrderedSet{T}?T]
		//
		symbol_162.setName("OrderedSet");
		symbol_162.setElementType(symbol_75);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_74);	
				symbol_651.setActual(symbol_75);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_162.getTemplateBindings().add(symbol_650);
		}
		symbol_162.getSuperClasses().add(symbol_200); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_162.getSuperClasses().add(symbol_160); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		symbol_100.getOwnedTypes().add(symbol_162);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|OrderedCollection{T}?T]
		//
		symbol_163.setName("OrderedSet");
		symbol_163.setElementType(symbol_71);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_74);	
				symbol_653.setActual(symbol_71);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_163.getTemplateBindings().add(symbol_652);
		}
		symbol_163.getSuperClasses().add(symbol_188); // ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		symbol_163.getSuperClasses().add(symbol_156); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_163);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|Collection{T}?T]
		//
		symbol_164.setName("OrderedSet");
		symbol_164.setElementType(symbol_27);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_74);	
				symbol_655.setActual(symbol_27);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_164.getTemplateBindings().add(symbol_654);
		}
		symbol_164.getSuperClasses().add(symbol_190); // ocl|UniqueCollection[ocl|Collection{T}?T]
		symbol_164.getSuperClasses().add(symbol_159); // ocl|OrderedCollection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_164);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|UniqueCollection{T}?T]
		//
		symbol_165.setName("OrderedSet");
		symbol_165.setElementType(symbol_98);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_73);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_74);	
				symbol_657.setActual(symbol_98);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_165.getTemplateBindings().add(symbol_656);
		}
		symbol_165.getSuperClasses().add(symbol_197); // ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		symbol_165.getSuperClasses().add(symbol_155); // ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_165);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|NonUniqueCollection{T}?T]
		//
		symbol_166.setName("Sequence");
		symbol_166.setElementType(symbol_52);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_81);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_82);	
				symbol_659.setActual(symbol_52);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_166.getTemplateBindings().add(symbol_658);
		}
		symbol_166.getSuperClasses().add(symbol_157); // ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		symbol_166.getSuperClasses().add(symbol_145); // ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_166);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Collection{T}?T]
		//
		symbol_167.setName("Sequence");
		symbol_167.setElementType(symbol_27);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_81);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_82);	
				symbol_661.setActual(symbol_27);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_167.getTemplateBindings().add(symbol_660);
		}
		symbol_167.getSuperClasses().add(symbol_146); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		symbol_167.getSuperClasses().add(symbol_159); // ocl|OrderedCollection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_167);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|OrderedCollection{T}?T]
		//
		symbol_168.setName("Sequence");
		symbol_168.setElementType(symbol_71);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_81);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_82);	
				symbol_663.setActual(symbol_71);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_168.getTemplateBindings().add(symbol_662);
		}
		symbol_168.getSuperClasses().add(symbol_148); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		symbol_168.getSuperClasses().add(symbol_156); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_168);
		//
		// ocl::orphanage::Sequence ocl|Sequence[String]
		//
		symbol_169.setName("Sequence");
		symbol_169.setElementType(symbol_94);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_81);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_82);	
				symbol_665.setActual(symbol_94);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_169.getTemplateBindings().add(symbol_664);
		}
		symbol_169.getSuperClasses().add(symbol_154); // ocl|OrderedCollection[String]
		symbol_169.getSuperClasses().add(symbol_149); // ocl|NonUniqueCollection[String]
		symbol_100.getOwnedTypes().add(symbol_169);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_170.setName("Sequence");
		symbol_170.setElementType(symbol_86);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_81);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_82);	
				symbol_667.setActual(symbol_86);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_170.getTemplateBindings().add(symbol_666);
		}
		symbol_170.getSuperClasses().add(symbol_161); // ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_170.getSuperClasses().add(symbol_152); // ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_170);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Sequence{T}?T]
		//
		symbol_171.setName("Sequence");
		symbol_171.setElementType(symbol_83);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_81);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_82);	
				symbol_669.setActual(symbol_83);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_171.getTemplateBindings().add(symbol_668);
		}
		symbol_171.getSuperClasses().add(symbol_150); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		symbol_171.getSuperClasses().add(symbol_158); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		symbol_100.getOwnedTypes().add(symbol_171);
		//
		// ocl::orphanage::Set ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_172.setName("Set");
		symbol_172.setElementType(symbol_185);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_89);	
				symbol_671.setActual(symbol_185);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_172.getTemplateBindings().add(symbol_670);
		}
		symbol_172.getSuperClasses().add(symbol_132); // ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_172.getSuperClasses().add(symbol_198); // ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_100.getOwnedTypes().add(symbol_172);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Collection{T}?T]
		//
		symbol_173.setName("Set");
		symbol_173.setElementType(symbol_27);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_89);	
				symbol_673.setActual(symbol_27);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_173.getTemplateBindings().add(symbol_672);
		}
		symbol_173.getSuperClasses().add(symbol_190); // ocl|UniqueCollection[ocl|Collection{T}?T]
		symbol_173.getSuperClasses().add(symbol_142); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_173);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_174.setName("Set");
		symbol_174.setElementType(symbol_93);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_89);	
				symbol_675.setActual(symbol_93);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_174.getTemplateBindings().add(symbol_674);
		}
		symbol_174.getSuperClasses().add(symbol_191); // ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_174.getSuperClasses().add(symbol_134); // ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_174);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclVoid]
		//
		symbol_175.setName("Set");
		symbol_175.setElementType(symbol_67);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_89);	
				symbol_677.setActual(symbol_67);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_175.getTemplateBindings().add(symbol_676);
		}
		symbol_175.getSuperClasses().add(symbol_137); // ocl|NonOrderedCollection[ocl|OclVoid]
		symbol_175.getSuperClasses().add(symbol_195); // ocl|UniqueCollection[ocl|OclVoid]
		symbol_100.getOwnedTypes().add(symbol_175);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OrderedSet{T}?T]
		//
		symbol_176.setName("Set");
		symbol_176.setElementType(symbol_75);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_89);	
				symbol_679.setActual(symbol_75);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_176.getTemplateBindings().add(symbol_678);
		}
		symbol_176.getSuperClasses().add(symbol_200); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_176.getSuperClasses().add(symbol_130); // ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		symbol_100.getOwnedTypes().add(symbol_176);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclAny]
		//
		symbol_177.setName("Set");
		symbol_177.setElementType(symbol_53);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_89);	
				symbol_681.setActual(symbol_53);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_177.getTemplateBindings().add(symbol_680);
		}
		symbol_177.getSuperClasses().add(symbol_138); // ocl|NonOrderedCollection[ocl|OclAny]
		symbol_177.getSuperClasses().add(symbol_201); // ocl|UniqueCollection[ocl|OclAny]
		symbol_100.getOwnedTypes().add(symbol_177);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Set{T}?T]
		//
		symbol_178.setName("Set");
		symbol_178.setElementType(symbol_90);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_89);	
				symbol_683.setActual(symbol_90);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_178.getTemplateBindings().add(symbol_682);
		}
		symbol_178.getSuperClasses().add(symbol_193); // ocl|UniqueCollection[ocl|Set{T}?T]
		symbol_178.getSuperClasses().add(symbol_131); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		symbol_100.getOwnedTypes().add(symbol_178);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_179.setName("Set");
		symbol_179.setElementType(symbol_23);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_89);	
				symbol_685.setActual(symbol_23);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_179.getTemplateBindings().add(symbol_684);
		}
		symbol_179.getSuperClasses().add(symbol_136); // ocl|NonOrderedCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_179.getSuperClasses().add(symbol_192); // ocl|UniqueCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_100.getOwnedTypes().add(symbol_179);
		//
		// ocl::orphanage::Set ocl|Set[Boolean]
		//
		symbol_180.setName("Set");
		symbol_180.setElementType(symbol_19);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_89);	
				symbol_687.setActual(symbol_19);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_180.getTemplateBindings().add(symbol_686);
		}
		symbol_180.getSuperClasses().add(symbol_196); // ocl|UniqueCollection[Boolean]
		symbol_180.getSuperClasses().add(symbol_139); // ocl|NonOrderedCollection[Boolean]
		symbol_100.getOwnedTypes().add(symbol_180);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Enumeration]
		//
		symbol_181.setName("Set");
		symbol_181.setElementType(symbol_43);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_89);	
				symbol_689.setActual(symbol_43);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_181.getTemplateBindings().add(symbol_688);
		}
		symbol_181.getSuperClasses().add(symbol_135); // ocl|NonOrderedCollection[ocl|Enumeration]
		symbol_181.getSuperClasses().add(symbol_199); // ocl|UniqueCollection[ocl|Enumeration]
		symbol_100.getOwnedTypes().add(symbol_181);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_182.setName("Set");
		symbol_182.setElementType(symbol_56);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_89);	
				symbol_691.setActual(symbol_56);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_182.getTemplateBindings().add(symbol_690);
		}
		symbol_182.getSuperClasses().add(symbol_141); // ocl|NonOrderedCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_182.getSuperClasses().add(symbol_194); // ocl|UniqueCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_100.getOwnedTypes().add(symbol_182);
		//
		// ocl::orphanage::Set ocl|Set[ocl|NonOrderedCollection{T}?T]
		//
		symbol_183.setName("Set");
		symbol_183.setElementType(symbol_48);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_89);	
				symbol_693.setActual(symbol_48);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_183.getTemplateBindings().add(symbol_692);
		}
		symbol_183.getSuperClasses().add(symbol_133); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		symbol_183.getSuperClasses().add(symbol_189); // ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_183);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclInvalid]
		//
		symbol_184.setName("Set");
		symbol_184.setElementType(symbol_63);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_88);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_89);	
				symbol_695.setActual(symbol_63);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_184.getTemplateBindings().add(symbol_694);
		}
		symbol_184.getSuperClasses().add(symbol_144); // ocl|NonOrderedCollection[ocl|OclInvalid]
		symbol_184.getSuperClasses().add(symbol_202); // ocl|UniqueCollection[ocl|OclInvalid]
		symbol_100.getOwnedTypes().add(symbol_184);
		//
		// ocl::orphanage::Tuple Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}
		//
		symbol_185.setName("Tuple");
		{ // ocl::orphanage::Tuple::first Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|first
			symbol_186.setName("first");
			symbol_186.setType(symbol_27);  // ocl|Collection{T}?T
			
			symbol_186.setIsResolveProxies(true);
			symbol_185.getOwnedAttributes().add(symbol_186);
		}
		{ // ocl::orphanage::Tuple::second Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|second
			symbol_187.setName("second");
			symbol_187.setType(symbol_42);  // ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2
			
			symbol_187.setIsResolveProxies(true);
			symbol_185.getOwnedAttributes().add(symbol_187);
		}
		symbol_100.getOwnedTypes().add(symbol_185);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_188.setName("UniqueCollection");
		symbol_188.setElementType(symbol_71);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_97);	
				symbol_697.setActual(symbol_71);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_188.getTemplateBindings().add(symbol_696);
		}
		symbol_188.getSuperClasses().add(symbol_121); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_188);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_189.setName("UniqueCollection");
		symbol_189.setElementType(symbol_48);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_97);	
				symbol_699.setActual(symbol_48);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_189.getTemplateBindings().add(symbol_698);
		}
		symbol_189.getSuperClasses().add(symbol_114); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_189);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Collection{T}?T]
		//
		symbol_190.setName("UniqueCollection");
		symbol_190.setElementType(symbol_27);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_97);	
				symbol_701.setActual(symbol_27);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_190.getTemplateBindings().add(symbol_700);
		}
		symbol_190.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Collection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_190);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_191.setName("UniqueCollection");
		symbol_191.setElementType(symbol_93);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_97);	
				symbol_703.setActual(symbol_93);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_191.getTemplateBindings().add(symbol_702);
		}
		symbol_191.getSuperClasses().add(symbol_108); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_100.getOwnedTypes().add(symbol_191);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_192.setName("UniqueCollection");
		symbol_192.setElementType(symbol_23);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_97);	
				symbol_705.setActual(symbol_23);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_192.getTemplateBindings().add(symbol_704);
		}
		symbol_192.getSuperClasses().add(symbol_119); // ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_100.getOwnedTypes().add(symbol_192);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Set{T}?T]
		//
		symbol_193.setName("UniqueCollection");
		symbol_193.setElementType(symbol_90);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_97);	
				symbol_707.setActual(symbol_90);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_193.getTemplateBindings().add(symbol_706);
		}
		symbol_193.getSuperClasses().add(symbol_109); // ocl|Collection[ocl|Set{T}?T]
		symbol_100.getOwnedTypes().add(symbol_193);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_194.setName("UniqueCollection");
		symbol_194.setElementType(symbol_56);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_97);	
				symbol_709.setActual(symbol_56);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_194.getTemplateBindings().add(symbol_708);
		}
		symbol_194.getSuperClasses().add(symbol_123); // ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_100.getOwnedTypes().add(symbol_194);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclVoid]
		//
		symbol_195.setName("UniqueCollection");
		symbol_195.setElementType(symbol_67);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_97);	
				symbol_711.setActual(symbol_67);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_195.getTemplateBindings().add(symbol_710);
		}
		symbol_195.getSuperClasses().add(symbol_127); // ocl|Collection[ocl|OclVoid]
		symbol_100.getOwnedTypes().add(symbol_195);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[Boolean]
		//
		symbol_196.setName("UniqueCollection");
		symbol_196.setElementType(symbol_19);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_97);	
				symbol_713.setActual(symbol_19);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_196.getTemplateBindings().add(symbol_712);
		}
		symbol_196.getSuperClasses().add(symbol_128); // ocl|Collection[Boolean]
		symbol_100.getOwnedTypes().add(symbol_196);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		//
		symbol_197.setName("UniqueCollection");
		symbol_197.setElementType(symbol_98);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_97);	
				symbol_715.setActual(symbol_98);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_197.getTemplateBindings().add(symbol_714);
		}
		symbol_197.getSuperClasses().add(symbol_116); // ocl|Collection[ocl|UniqueCollection{T}?T]
		symbol_100.getOwnedTypes().add(symbol_197);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_198.setName("UniqueCollection");
		symbol_198.setElementType(symbol_185);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_97);	
				symbol_717.setActual(symbol_185);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_198.getTemplateBindings().add(symbol_716);
		}
		symbol_198.getSuperClasses().add(symbol_129); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_100.getOwnedTypes().add(symbol_198);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Enumeration]
		//
		symbol_199.setName("UniqueCollection");
		symbol_199.setElementType(symbol_43);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_97);	
				symbol_719.setActual(symbol_43);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_199.getTemplateBindings().add(symbol_718);
		}
		symbol_199.getSuperClasses().add(symbol_111); // ocl|Collection[ocl|Enumeration]
		symbol_100.getOwnedTypes().add(symbol_199);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		//
		symbol_200.setName("UniqueCollection");
		symbol_200.setElementType(symbol_75);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_97);	
				symbol_721.setActual(symbol_75);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_200.getTemplateBindings().add(symbol_720);
		}
		symbol_200.getSuperClasses().add(symbol_122); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_100.getOwnedTypes().add(symbol_200);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclAny]
		//
		symbol_201.setName("UniqueCollection");
		symbol_201.setElementType(symbol_53);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_97);	
				symbol_723.setActual(symbol_53);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_201.getTemplateBindings().add(symbol_722);
		}
		symbol_201.getSuperClasses().add(symbol_118); // ocl|Collection[ocl|OclAny]
		symbol_100.getOwnedTypes().add(symbol_201);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclInvalid]
		//
		symbol_202.setName("UniqueCollection");
		symbol_202.setElementType(symbol_63);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_96);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_97);	
				symbol_725.setActual(symbol_63);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_202.getTemplateBindings().add(symbol_724);
		}
		symbol_202.getSuperClasses().add(symbol_125); // ocl|Collection[ocl|OclInvalid]
		symbol_100.getOwnedTypes().add(symbol_202);
		symbol_1.getNestedPackages().add(symbol_100);
		return symbol_1;
	}
}
