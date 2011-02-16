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
 * $Id: OCLstdlib.java,v 1.5 2011/02/15 10:36:59 ewillink Exp $
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
		
		TemplateSignature symbol_28 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|collect{V}(ocl|Collection{T}?T|Lambda~T()V)|
		TypeTemplateParameter symbol_29 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_30 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|collect{V}(ocl|Collection{T}?T|Lambda~T()V)?V
		
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|flatten{T2}()|
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|flatten{T2}()?T2
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)|
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Collection{T}|product{T2}(ocl|Collection[T2])|
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2
		
		
		Class symbol_46 = PivotFactory.eINSTANCE.createClass(); // ocl|Enumeration
		
		PrimitiveType symbol_47 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_48 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection{T}
		TemplateSignature symbol_49 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonOrderedCollection{T}|
		TypeTemplateParameter symbol_50 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // ocl|NonOrderedCollection{T}?T
		
		TemplateSignature symbol_52 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)|
		TypeTemplateParameter symbol_53 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V
		
		
		CollectionType symbol_55 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection{T}
		TemplateSignature symbol_56 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|NonUniqueCollection{T}|
		TypeTemplateParameter symbol_57 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // ocl|NonUniqueCollection{T}?T
		
		
		AnyType symbol_59 = PivotFactory.eINSTANCE.createAnyType(); // ocl|OclAny
		TemplateSignature symbol_60 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclAsSet{OclSelf}()|
		TypeTemplateParameter symbol_61 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_62 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_63 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclAsType{T}(ocl|Classifier)|
		TypeTemplateParameter symbol_64 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_65 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclAsType{T}(ocl|Classifier)?T
		
		TemplateSignature symbol_66 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OclAny|oclType{OclSelf}()|
		TypeTemplateParameter symbol_67 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_68 = PivotFactory.eINSTANCE.createClass(); // ocl|OclAny|oclType{OclSelf}()?OclSelf
		
		
		InvalidType symbol_69 = PivotFactory.eINSTANCE.createInvalidType(); // ocl|OclInvalid
		
		Class symbol_70 = PivotFactory.eINSTANCE.createClass(); // ocl|OclMessage
		
		Class symbol_71 = PivotFactory.eINSTANCE.createClass(); // ocl|OclState
		
		Class symbol_72 = PivotFactory.eINSTANCE.createClass(); // ocl|OclTuple
		
		VoidType symbol_73 = PivotFactory.eINSTANCE.createVoidType(); // ocl|OclVoid
		
		CollectionType symbol_74 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection{T}
		TemplateSignature symbol_75 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedCollection{T}|
		TypeTemplateParameter symbol_76 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedCollection{T}?T
		
		TemplateSignature symbol_78 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)|
		TypeTemplateParameter symbol_79 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_80 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_81 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet{T}
		TemplateSignature symbol_82 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|OrderedSet{T}|
		TypeTemplateParameter symbol_83 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // ocl|OrderedSet{T}?T
		
		
		PrimitiveType symbol_85 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_86 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real|oclAsType{T}(ocl|Classifier)|
		TypeTemplateParameter symbol_87 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_88 = PivotFactory.eINSTANCE.createClass(); // Real|oclAsType{T}(ocl|Classifier)?T
		
		
		SequenceType symbol_89 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence{T}
		TemplateSignature symbol_90 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Sequence{T}|
		TypeTemplateParameter symbol_91 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_92 = PivotFactory.eINSTANCE.createClass(); // ocl|Sequence{T}?T
		
		TemplateSignature symbol_93 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Sequence{T}|flatten{T2}()|
		TypeTemplateParameter symbol_94 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_95 = PivotFactory.eINSTANCE.createClass(); // ocl|Sequence{T}|flatten{T2}()?T2
		
		
		SetType symbol_96 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set{T}
		TemplateSignature symbol_97 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Set{T}|
		TypeTemplateParameter symbol_98 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // ocl|Set{T}?T
		
		TemplateSignature symbol_100 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|Set{T}|flatten{T2}()|
		TypeTemplateParameter symbol_101 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_102 = PivotFactory.eINSTANCE.createClass(); // ocl|Set{T}|flatten{T2}()?T2
		
		
		PrimitiveType symbol_103 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_104 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection{T}
		TemplateSignature symbol_105 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl|UniqueCollection{T}|
		TypeTemplateParameter symbol_106 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_107 = PivotFactory.eINSTANCE.createClass(); // ocl|UniqueCollection{T}?T
		
		
		PrimitiveType symbol_108 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_109 = PivotFactory.eINSTANCE.createPackage(); // ocl|orphanage
		BagType symbol_110 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
		
		BagType symbol_111 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		
		BagType symbol_112 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|NonOrderedCollection{T}?T]
		
		BagType symbol_113 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Collection{T}?T]
		
		BagType symbol_114 = PivotFactory.eINSTANCE.createBagType(); // ocl|Bag[ocl|Bag{T}?T]
		
		CollectionType symbol_115 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_116 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_117 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_118 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[Boolean]
		
		CollectionType symbol_119 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_120 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_121 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclAny]
		
		CollectionType symbol_122 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Enumeration]
		
		CollectionType symbol_123 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		
		CollectionType symbol_124 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
		
		CollectionType symbol_125 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_126 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_127 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_128 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Sequence{T}?T]
		
		CollectionType symbol_129 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_130 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclVoid]
		
		CollectionType symbol_131 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Bag{T}?T]
		
		CollectionType symbol_132 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|collect{V}(ocl|Collection{T}?T|Lambda~T()V)?V]
		
		CollectionType symbol_133 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}?T]
		
		CollectionType symbol_134 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[String]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Set{T}?T]
		
		CollectionType symbol_140 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|OclInvalid]
		
		CollectionType symbol_141 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_142 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
		
		LambdaType symbol_143 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl|Collection{T}?T()ocl|Collection{T}|collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_144 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl|NonOrderedCollection{T}?T()ocl|NonOrderedCollection{T}|collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_145 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl|OrderedCollection{T}?T()ocl|OrderedCollection{T}|collect{V}(T|Lambda~T()V)?V
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Enumeration]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclInvalid]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclVoid]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[Boolean]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OclAny]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[String]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[String]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|Collection{T}?T]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|OrderedCollection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		
		OrderedSetType symbol_182 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|UniqueCollection{T}?T]
		
		OrderedSetType symbol_183 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|Collection{T}?T]
		
		OrderedSetType symbol_184 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|OrderedSet{T}?T]
		
		OrderedSetType symbol_185 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl|OrderedSet[ocl|OrderedCollection{T}?T]
		
		SequenceType symbol_186 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[String]
		
		SequenceType symbol_187 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Sequence{T}?T]
		
		SequenceType symbol_188 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|NonUniqueCollection{T}?T]
		
		SequenceType symbol_189 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		
		SequenceType symbol_190 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
		
		SequenceType symbol_191 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|OrderedCollection{T}?T]
		
		SequenceType symbol_192 = PivotFactory.eINSTANCE.createSequenceType(); // ocl|Sequence[ocl|Collection{T}?T]
		
		SetType symbol_193 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OrderedSet{T}?T]
		
		SetType symbol_194 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclAny]
		
		SetType symbol_195 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_196 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclInvalid]
		
		SetType symbol_197 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|NonOrderedCollection{T}?T]
		
		SetType symbol_198 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		SetType symbol_199 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
		
		SetType symbol_200 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_201 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Set{T}?T]
		
		SetType symbol_202 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Enumeration]
		
		SetType symbol_203 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|Collection{T}?T]
		
		SetType symbol_204 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[Boolean]
		
		SetType symbol_205 = PivotFactory.eINSTANCE.createSetType(); // ocl|Set[ocl|OclVoid]
		
		TupleType symbol_206 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}
		Property symbol_207 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::first Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|first
		Property symbol_208 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::second Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|second
		
		CollectionType symbol_209 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Set{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclInvalid]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[Boolean]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		
		CollectionType symbol_216 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclVoid]
		
		CollectionType symbol_217 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_218 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		
		CollectionType symbol_219 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		
		CollectionType symbol_220 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Enumeration]
		
		CollectionType symbol_221 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|OclAny]
		
		CollectionType symbol_222 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		
		CollectionType symbol_223 = PivotFactory.eINSTANCE.createCollectionType(); // ocl|UniqueCollection[ocl|Collection{T}?T]
		
		

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
		symbol_12.getSuperClasses().add(symbol_164); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_155); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		{	// ocl::Bag::<>() ocl|Bag{T}|<>(ocl|OclAny)
			Operation symbol_224 = PivotFactory.eINSTANCE.createOperation();
			symbol_224.setName("<>");
			symbol_224.setType(symbol_19);  // Boolean
			symbol_224.setLower(BigInteger.valueOf(0));
			symbol_224.setIsUnique(false);
			
			Parameter symbol_225 = PivotFactory.eINSTANCE.createParameter();
			symbol_225.setName("object2");
			symbol_225.setType(symbol_59);  // ocl|OclAny
			symbol_225.setLower(BigInteger.valueOf(0));
			symbol_225.setIsUnique(false);
			
			symbol_224.getOwnedParameters().add(symbol_225);
			symbol_224.setPrecedence(symbol_7);
			symbol_224.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_224);
		}
		{	// ocl::Bag::=() ocl|Bag{T}|=(ocl|OclAny)
			Operation symbol_226 = PivotFactory.eINSTANCE.createOperation();
			symbol_226.setName("=");
			symbol_226.setType(symbol_19);  // Boolean
			symbol_226.setLower(BigInteger.valueOf(0));
			symbol_226.setIsUnique(false);
			
			Parameter symbol_227 = PivotFactory.eINSTANCE.createParameter();
			symbol_227.setName("object2");
			symbol_227.setType(symbol_59);  // ocl|OclAny
			symbol_227.setLower(BigInteger.valueOf(0));
			symbol_227.setIsUnique(false);
			
			symbol_226.getOwnedParameters().add(symbol_227);
			symbol_226.setPrecedence(symbol_7);
			symbol_226.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_226);
		}
		{	// ocl::Bag::excluding() ocl|Bag{T}|excluding(ocl|OclAny)
			Operation symbol_228 = PivotFactory.eINSTANCE.createOperation();
			symbol_228.setName("excluding");
			symbol_228.setType(symbol_114);  // ocl|Bag[ocl|Bag{T}?T]
			symbol_228.setLower(BigInteger.valueOf(0));
			symbol_228.setIsUnique(false);
			
			Parameter symbol_229 = PivotFactory.eINSTANCE.createParameter();
			symbol_229.setName("object");
			symbol_229.setType(symbol_59);  // ocl|OclAny
			symbol_229.setLower(BigInteger.valueOf(0));
			symbol_229.setIsUnique(false);
			
			symbol_228.getOwnedParameters().add(symbol_229);
			symbol_228.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_228);
		}
		{	// ocl::Bag::flatten() ocl|Bag{T}|flatten{T2}()
			Operation symbol_230 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_230.setOwnedTemplateSignature(symbol_16);
			symbol_230.setName("flatten");
			symbol_230.setType(symbol_110);  // ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
			symbol_230.setLower(BigInteger.valueOf(0));
			symbol_230.setIsUnique(false);
			
			symbol_230.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_230);
		}
		{	// ocl::Bag::including() ocl|Bag{T}|including(ocl|Bag{T}?T)
			Operation symbol_231 = PivotFactory.eINSTANCE.createOperation();
			symbol_231.setName("including");
			symbol_231.setType(symbol_114);  // ocl|Bag[ocl|Bag{T}?T]
			symbol_231.setLower(BigInteger.valueOf(0));
			symbol_231.setIsUnique(false);
			
			Parameter symbol_232 = PivotFactory.eINSTANCE.createParameter();
			symbol_232.setName("object");
			symbol_232.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_232.setLower(BigInteger.valueOf(0));
			symbol_232.setIsUnique(false);
			
			symbol_231.getOwnedParameters().add(symbol_232);
			symbol_231.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_231);
		}
		{	// ocl::Bag::reject() ocl|Bag{T}|reject(ocl|Bag{T}?T)
			Iteration symbol_233 = PivotFactory.eINSTANCE.createIteration();
			symbol_233.setName("reject");
			symbol_233.setType(symbol_114);  // ocl|Bag[ocl|Bag{T}?T]
			
			Parameter symbol_234 = PivotFactory.eINSTANCE.createParameter();
			symbol_234.setName("i");
			symbol_234.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_233.getOwnedIterators().add(symbol_234);
			symbol_233.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_233);
		}
		{	// ocl::Bag::select() ocl|Bag{T}|select(ocl|Bag{T}?T)
			Iteration symbol_235 = PivotFactory.eINSTANCE.createIteration();
			symbol_235.setName("select");
			symbol_235.setType(symbol_114);  // ocl|Bag[ocl|Bag{T}?T]
			
			Parameter symbol_236 = PivotFactory.eINSTANCE.createParameter();
			symbol_236.setName("i");
			symbol_236.setType(symbol_15);  // ocl|Bag{T}?T
			symbol_235.getOwnedIterators().add(symbol_236);
			symbol_235.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_235);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		symbol_19.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::Boolean::<>() Boolean|<>(ocl|OclAny)
			Operation symbol_237 = PivotFactory.eINSTANCE.createOperation();
			symbol_237.setName("<>");
			symbol_237.setType(symbol_19);  // Boolean
			symbol_237.setLower(BigInteger.valueOf(0));
			symbol_237.setIsUnique(false);
			
			Parameter symbol_238 = PivotFactory.eINSTANCE.createParameter();
			symbol_238.setName("object2");
			symbol_238.setType(symbol_59);  // ocl|OclAny
			symbol_238.setLower(BigInteger.valueOf(0));
			symbol_238.setIsUnique(false);
			
			symbol_237.getOwnedParameters().add(symbol_238);
			symbol_237.setPrecedence(symbol_7);
			symbol_237.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_237);
		}
		{	// ocl::Boolean::=() Boolean|=(ocl|OclAny)
			Operation symbol_239 = PivotFactory.eINSTANCE.createOperation();
			symbol_239.setName("=");
			symbol_239.setType(symbol_19);  // Boolean
			symbol_239.setLower(BigInteger.valueOf(0));
			symbol_239.setIsUnique(false);
			
			Parameter symbol_240 = PivotFactory.eINSTANCE.createParameter();
			symbol_240.setName("object2");
			symbol_240.setType(symbol_59);  // ocl|OclAny
			symbol_240.setLower(BigInteger.valueOf(0));
			symbol_240.setIsUnique(false);
			
			symbol_239.getOwnedParameters().add(symbol_240);
			symbol_239.setPrecedence(symbol_7);
			symbol_239.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_239);
		}
		{	// ocl::Boolean::allInstances() Boolean|allInstances()
			Operation symbol_241 = PivotFactory.eINSTANCE.createOperation();
			symbol_241.setName("allInstances");
			symbol_241.setType(symbol_204);  // ocl|Set[Boolean]
			symbol_241.setLower(BigInteger.valueOf(0));
			symbol_241.setIsUnique(false);
			
			symbol_241.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_241);
		}
		{	// ocl::Boolean::and() Boolean|and(Boolean)
			Operation symbol_242 = PivotFactory.eINSTANCE.createOperation();
			symbol_242.setName("and");
			symbol_242.setType(symbol_19);  // Boolean
			symbol_242.setLower(BigInteger.valueOf(0));
			symbol_242.setIsUnique(false);
			
			Parameter symbol_243 = PivotFactory.eINSTANCE.createParameter();
			symbol_243.setName("b");
			symbol_243.setType(symbol_19);  // Boolean
			symbol_243.setLower(BigInteger.valueOf(0));
			symbol_243.setIsUnique(false);
			
			symbol_242.getOwnedParameters().add(symbol_243);
			symbol_242.setPrecedence(symbol_8);
			symbol_242.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_242);
		}
		{	// ocl::Boolean::implies() Boolean|implies(Boolean)
			Operation symbol_244 = PivotFactory.eINSTANCE.createOperation();
			symbol_244.setName("implies");
			symbol_244.setType(symbol_19);  // Boolean
			symbol_244.setLower(BigInteger.valueOf(0));
			symbol_244.setIsUnique(false);
			
			Parameter symbol_245 = PivotFactory.eINSTANCE.createParameter();
			symbol_245.setName("b");
			symbol_245.setType(symbol_19);  // Boolean
			symbol_245.setLower(BigInteger.valueOf(0));
			symbol_245.setIsUnique(false);
			
			symbol_244.getOwnedParameters().add(symbol_245);
			symbol_244.setPrecedence(symbol_11);
			symbol_244.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_244);
		}
		{	// ocl::Boolean::not() Boolean|not()
			Operation symbol_246 = PivotFactory.eINSTANCE.createOperation();
			symbol_246.setName("not");
			symbol_246.setType(symbol_19);  // Boolean
			symbol_246.setLower(BigInteger.valueOf(0));
			symbol_246.setIsUnique(false);
			
			symbol_246.setPrecedence(symbol_3);
			symbol_246.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_246);
		}
		{	// ocl::Boolean::or() Boolean|or(Boolean)
			Operation symbol_247 = PivotFactory.eINSTANCE.createOperation();
			symbol_247.setName("or");
			symbol_247.setType(symbol_19);  // Boolean
			symbol_247.setLower(BigInteger.valueOf(0));
			symbol_247.setIsUnique(false);
			
			Parameter symbol_248 = PivotFactory.eINSTANCE.createParameter();
			symbol_248.setName("b");
			symbol_248.setType(symbol_19);  // Boolean
			symbol_248.setLower(BigInteger.valueOf(0));
			symbol_248.setIsUnique(false);
			
			symbol_247.getOwnedParameters().add(symbol_248);
			symbol_247.setPrecedence(symbol_9);
			symbol_247.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_247);
		}
		{	// ocl::Boolean::toString() Boolean|toString()
			Operation symbol_249 = PivotFactory.eINSTANCE.createOperation();
			symbol_249.setName("toString");
			symbol_249.setType(symbol_103);  // String
			symbol_249.setLower(BigInteger.valueOf(0));
			symbol_249.setIsUnique(false);
			
			symbol_249.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_249);
		}
		{	// ocl::Boolean::xor() Boolean|xor(Boolean)
			Operation symbol_250 = PivotFactory.eINSTANCE.createOperation();
			symbol_250.setName("xor");
			symbol_250.setType(symbol_19);  // Boolean
			symbol_250.setLower(BigInteger.valueOf(0));
			symbol_250.setIsUnique(false);
			
			Parameter symbol_251 = PivotFactory.eINSTANCE.createParameter();
			symbol_251.setName("b");
			symbol_251.setType(symbol_19);  // Boolean
			symbol_251.setLower(BigInteger.valueOf(0));
			symbol_251.setIsUnique(false);
			
			symbol_250.getOwnedParameters().add(symbol_251);
			symbol_250.setPrecedence(symbol_10);
			symbol_250.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_250);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl|Classifier
		//
		symbol_20.setName("Classifier");
		symbol_20.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::Classifier::allInstances() ocl|Classifier|allInstances{OclSelf}()
			Operation symbol_252 = PivotFactory.eINSTANCE.createOperation();
			symbol_23.setName("OclSelf");
			symbol_22.setOwnedParameteredElement(symbol_23);
			symbol_21.getOwnedParameters().add(symbol_22);
			
			symbol_252.setOwnedTemplateSignature(symbol_21);
			symbol_252.setName("allInstances");
			symbol_252.setType(symbol_195);  // ocl|Set[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
			symbol_252.setLower(BigInteger.valueOf(0));
			symbol_252.setIsUnique(false);
			
			symbol_252.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_252);
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
		symbol_24.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::Collection::<>() ocl|Collection{T}|<>(ocl|OclAny)
			Operation symbol_253 = PivotFactory.eINSTANCE.createOperation();
			symbol_253.setName("<>");
			symbol_253.setType(symbol_19);  // Boolean
			symbol_253.setLower(BigInteger.valueOf(0));
			symbol_253.setIsUnique(false);
			
			Parameter symbol_254 = PivotFactory.eINSTANCE.createParameter();
			symbol_254.setName("object2");
			symbol_254.setType(symbol_59);  // ocl|OclAny
			symbol_254.setLower(BigInteger.valueOf(0));
			symbol_254.setIsUnique(false);
			
			symbol_253.getOwnedParameters().add(symbol_254);
			symbol_253.setPrecedence(symbol_7);
			symbol_253.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_253);
		}
		{	// ocl::Collection::=() ocl|Collection{T}|=(ocl|OclAny)
			Operation symbol_255 = PivotFactory.eINSTANCE.createOperation();
			symbol_255.setName("=");
			symbol_255.setType(symbol_19);  // Boolean
			symbol_255.setLower(BigInteger.valueOf(0));
			symbol_255.setIsUnique(false);
			
			Parameter symbol_256 = PivotFactory.eINSTANCE.createParameter();
			symbol_256.setName("object2");
			symbol_256.setType(symbol_59);  // ocl|OclAny
			symbol_256.setLower(BigInteger.valueOf(0));
			symbol_256.setIsUnique(false);
			
			symbol_255.getOwnedParameters().add(symbol_256);
			symbol_255.setPrecedence(symbol_7);
			symbol_255.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_255);
		}
		{	// ocl::Collection::any() ocl|Collection{T}|any(ocl|Collection{T}?T)
			Iteration symbol_257 = PivotFactory.eINSTANCE.createIteration();
			symbol_257.setName("any");
			symbol_257.setType(symbol_27);  // ocl|Collection{T}?T
			
			Parameter symbol_258 = PivotFactory.eINSTANCE.createParameter();
			symbol_258.setName("i");
			symbol_258.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_257.getOwnedIterators().add(symbol_258);
			symbol_257.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_257);
		}
		{	// ocl::Collection::asBag() ocl|Collection{T}|asBag()
			Operation symbol_259 = PivotFactory.eINSTANCE.createOperation();
			symbol_259.setName("asBag");
			symbol_259.setType(symbol_113);  // ocl|Bag[ocl|Collection{T}?T]
			symbol_259.setLower(BigInteger.valueOf(0));
			symbol_259.setIsUnique(false);
			
			symbol_259.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_259);
		}
		{	// ocl::Collection::asOrderedSet() ocl|Collection{T}|asOrderedSet()
			Operation symbol_260 = PivotFactory.eINSTANCE.createOperation();
			symbol_260.setName("asOrderedSet");
			symbol_260.setType(symbol_183);  // ocl|OrderedSet[ocl|Collection{T}?T]
			symbol_260.setLower(BigInteger.valueOf(0));
			symbol_260.setIsUnique(false);
			
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Collection::asSequence() ocl|Collection{T}|asSequence()
			Operation symbol_261 = PivotFactory.eINSTANCE.createOperation();
			symbol_261.setName("asSequence");
			symbol_261.setType(symbol_192);  // ocl|Sequence[ocl|Collection{T}?T]
			symbol_261.setLower(BigInteger.valueOf(0));
			symbol_261.setIsUnique(false);
			
			symbol_261.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_261);
		}
		{	// ocl::Collection::asSet() ocl|Collection{T}|asSet()
			Operation symbol_262 = PivotFactory.eINSTANCE.createOperation();
			symbol_262.setName("asSet");
			symbol_262.setType(symbol_203);  // ocl|Set[ocl|Collection{T}?T]
			symbol_262.setLower(BigInteger.valueOf(0));
			symbol_262.setIsUnique(false);
			
			symbol_262.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_262);
		}
		{	// ocl::Collection::collect() ocl|Collection{T}|collect{V}(ocl|Collection{T}?T|Lambda~T()V)
			Iteration symbol_263 = PivotFactory.eINSTANCE.createIteration();
			symbol_30.setName("V");
			symbol_29.setOwnedParameteredElement(symbol_30);
			symbol_28.getOwnedParameters().add(symbol_29);
			
			symbol_263.setOwnedTemplateSignature(symbol_28);
			symbol_263.setName("collect");
			symbol_263.setType(symbol_132);  // ocl|Collection[ocl|Collection{T}|collect{V}(ocl|Collection{T}?T|Lambda~T()V)?V]
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("i");
			symbol_264.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_263.getOwnedIterators().add(symbol_264);
			Parameter symbol_265 = PivotFactory.eINSTANCE.createParameter();
			symbol_265.setName("body");
			symbol_265.setType(symbol_143);  // Lambda~ocl|Collection{T}?T()ocl|Collection{T}|collect{V}(T|Lambda~T()V)?V
			
			symbol_263.getOwnedParameters().add(symbol_265);
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_263);
		}
		{	// ocl::Collection::collectNested() ocl|Collection{T}|collectNested(ocl|Collection{T}?T)
			Iteration symbol_266 = PivotFactory.eINSTANCE.createIteration();
			symbol_266.setName("collectNested");
			symbol_266.setType(symbol_133);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_267 = PivotFactory.eINSTANCE.createParameter();
			symbol_267.setName("i");
			symbol_267.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_266.getOwnedIterators().add(symbol_267);
			symbol_266.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_266);
		}
		{	// ocl::Collection::count() ocl|Collection{T}|count(ocl|OclAny)
			Operation symbol_268 = PivotFactory.eINSTANCE.createOperation();
			symbol_268.setName("count");
			symbol_268.setType(symbol_47);  // Integer
			symbol_268.setLower(BigInteger.valueOf(0));
			symbol_268.setIsUnique(false);
			
			Parameter symbol_269 = PivotFactory.eINSTANCE.createParameter();
			symbol_269.setName("object");
			symbol_269.setType(symbol_59);  // ocl|OclAny
			symbol_269.setLower(BigInteger.valueOf(0));
			symbol_269.setIsUnique(false);
			
			symbol_268.getOwnedParameters().add(symbol_269);
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_268);
		}
		{	// ocl::Collection::excludes() ocl|Collection{T}|excludes(ocl|OclAny)
			Operation symbol_270 = PivotFactory.eINSTANCE.createOperation();
			symbol_270.setName("excludes");
			symbol_270.setType(symbol_19);  // Boolean
			symbol_270.setLower(BigInteger.valueOf(0));
			symbol_270.setIsUnique(false);
			
			Parameter symbol_271 = PivotFactory.eINSTANCE.createParameter();
			symbol_271.setName("object");
			symbol_271.setType(symbol_59);  // ocl|OclAny
			symbol_271.setLower(BigInteger.valueOf(0));
			symbol_271.setIsUnique(false);
			
			symbol_270.getOwnedParameters().add(symbol_271);
			symbol_270.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_270);
		}
		{	// ocl::Collection::excludesAll() ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])
			Operation symbol_272 = PivotFactory.eINSTANCE.createOperation();
			symbol_33.setName("T2");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_272.setOwnedTemplateSignature(symbol_31);
			symbol_272.setName("excludesAll");
			symbol_272.setType(symbol_19);  // Boolean
			symbol_272.setLower(BigInteger.valueOf(0));
			symbol_272.setIsUnique(false);
			
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("c2");
			symbol_273.setType(symbol_124);  // ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
			symbol_273.setLower(BigInteger.valueOf(0));
			symbol_273.setIsUnique(false);
			
			symbol_272.getOwnedParameters().add(symbol_273);
			symbol_272.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_272);
		}
		{	// ocl::Collection::excluding() ocl|Collection{T}|excluding(ocl|OclAny)
			Operation symbol_274 = PivotFactory.eINSTANCE.createOperation();
			symbol_274.setName("excluding");
			symbol_274.setType(symbol_133);  // ocl|Collection[ocl|Collection{T}?T]
			symbol_274.setLower(BigInteger.valueOf(0));
			symbol_274.setIsUnique(false);
			
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("object");
			symbol_275.setType(symbol_59);  // ocl|OclAny
			symbol_275.setLower(BigInteger.valueOf(0));
			symbol_275.setIsUnique(false);
			
			symbol_274.getOwnedParameters().add(symbol_275);
			symbol_274.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_274);
		}
		{	// ocl::Collection::exists() ocl|Collection{T}|exists(ocl|Collection{T}?T)
			Iteration symbol_276 = PivotFactory.eINSTANCE.createIteration();
			symbol_276.setName("exists");
			symbol_276.setType(symbol_19);  // Boolean
			
			Parameter symbol_277 = PivotFactory.eINSTANCE.createParameter();
			symbol_277.setName("i");
			symbol_277.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_276.getOwnedIterators().add(symbol_277);
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Collection::exists() ocl|Collection{T}|exists(ocl|Collection{T}?T,T)
			Iteration symbol_278 = PivotFactory.eINSTANCE.createIteration();
			symbol_278.setName("exists");
			symbol_278.setType(symbol_19);  // Boolean
			
			Parameter symbol_279 = PivotFactory.eINSTANCE.createParameter();
			symbol_279.setName("i");
			symbol_279.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_278.getOwnedIterators().add(symbol_279);
			Parameter symbol_280 = PivotFactory.eINSTANCE.createParameter();
			symbol_280.setName("j");
			symbol_280.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_278.getOwnedIterators().add(symbol_280);
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Collection::flatten() ocl|Collection{T}|flatten{T2}()
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_36.setName("T2");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_281.setOwnedTemplateSignature(symbol_34);
			symbol_281.setName("flatten");
			symbol_281.setType(symbol_142);  // ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
			symbol_281.setLower(BigInteger.valueOf(0));
			symbol_281.setIsUnique(false);
			
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Collection::forAll() ocl|Collection{T}|forAll(ocl|Collection{T}?T)
			Iteration symbol_282 = PivotFactory.eINSTANCE.createIteration();
			symbol_282.setName("forAll");
			symbol_282.setType(symbol_19);  // Boolean
			
			Parameter symbol_283 = PivotFactory.eINSTANCE.createParameter();
			symbol_283.setName("i");
			symbol_283.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_282.getOwnedIterators().add(symbol_283);
			symbol_282.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_282);
		}
		{	// ocl::Collection::forAll() ocl|Collection{T}|forAll(ocl|Collection{T}?T,T)
			Iteration symbol_284 = PivotFactory.eINSTANCE.createIteration();
			symbol_284.setName("forAll");
			symbol_284.setType(symbol_19);  // Boolean
			
			Parameter symbol_285 = PivotFactory.eINSTANCE.createParameter();
			symbol_285.setName("i");
			symbol_285.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_284.getOwnedIterators().add(symbol_285);
			Parameter symbol_286 = PivotFactory.eINSTANCE.createParameter();
			symbol_286.setName("j");
			symbol_286.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_284.getOwnedIterators().add(symbol_286);
			symbol_284.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_284);
		}
		{	// ocl::Collection::includes() ocl|Collection{T}|includes(ocl|OclAny)
			Operation symbol_287 = PivotFactory.eINSTANCE.createOperation();
			symbol_287.setName("includes");
			symbol_287.setType(symbol_19);  // Boolean
			symbol_287.setLower(BigInteger.valueOf(0));
			symbol_287.setIsUnique(false);
			
			Parameter symbol_288 = PivotFactory.eINSTANCE.createParameter();
			symbol_288.setName("object");
			symbol_288.setType(symbol_59);  // ocl|OclAny
			symbol_288.setLower(BigInteger.valueOf(0));
			symbol_288.setIsUnique(false);
			
			symbol_287.getOwnedParameters().add(symbol_288);
			symbol_287.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_287);
		}
		{	// ocl::Collection::includesAll() ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])
			Operation symbol_289 = PivotFactory.eINSTANCE.createOperation();
			symbol_39.setName("T2");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_289.setOwnedTemplateSignature(symbol_37);
			symbol_289.setName("includesAll");
			symbol_289.setType(symbol_19);  // Boolean
			symbol_289.setLower(BigInteger.valueOf(0));
			symbol_289.setIsUnique(false);
			
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("c2");
			symbol_290.setType(symbol_117);  // ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
			symbol_290.setLower(BigInteger.valueOf(0));
			symbol_290.setIsUnique(false);
			
			symbol_289.getOwnedParameters().add(symbol_290);
			symbol_289.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_289);
		}
		{	// ocl::Collection::including() ocl|Collection{T}|including(ocl|Collection{T}?T)
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("including");
			symbol_291.setType(symbol_133);  // ocl|Collection[ocl|Collection{T}?T]
			symbol_291.setLower(BigInteger.valueOf(0));
			symbol_291.setIsUnique(false);
			
			Parameter symbol_292 = PivotFactory.eINSTANCE.createParameter();
			symbol_292.setName("object");
			symbol_292.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_292.setLower(BigInteger.valueOf(0));
			symbol_292.setIsUnique(false);
			
			symbol_291.getOwnedParameters().add(symbol_292);
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Collection::isEmpty() ocl|Collection{T}|isEmpty()
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("isEmpty");
			symbol_293.setType(symbol_19);  // Boolean
			symbol_293.setLower(BigInteger.valueOf(0));
			symbol_293.setIsUnique(false);
			
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Collection::isUnique() ocl|Collection{T}|isUnique(ocl|Collection{T}?T)
			Iteration symbol_294 = PivotFactory.eINSTANCE.createIteration();
			symbol_294.setName("isUnique");
			symbol_294.setType(symbol_19);  // Boolean
			
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("i");
			symbol_295.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_294.getOwnedIterators().add(symbol_295);
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Collection::iterate() ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)
			Iteration symbol_296 = PivotFactory.eINSTANCE.createIteration();
			symbol_42.setName("Tacc");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_296.setOwnedTemplateSignature(symbol_40);
			symbol_296.setName("iterate");
			symbol_296.setType(symbol_42);  // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
			
			Parameter symbol_297 = PivotFactory.eINSTANCE.createParameter();
			symbol_297.setName("i");
			symbol_297.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_296.getOwnedIterators().add(symbol_297);
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("acc");
			symbol_298.setType(symbol_42);  // ocl|Collection{T}|iterate{Tacc}(ocl|Collection{T}?T;Tacc)?Tacc
			symbol_296.getOwnedAccumulators().add(symbol_298);
			symbol_296.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_296);
		}
		{	// ocl::Collection::max() ocl|Collection{T}|max()
			Operation symbol_299 = PivotFactory.eINSTANCE.createOperation();
			symbol_299.setName("max");
			symbol_299.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_299.setLower(BigInteger.valueOf(0));
			symbol_299.setIsUnique(false);
			
			symbol_299.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_299);
		}
		{	// ocl::Collection::min() ocl|Collection{T}|min()
			Operation symbol_300 = PivotFactory.eINSTANCE.createOperation();
			symbol_300.setName("min");
			symbol_300.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_300.setLower(BigInteger.valueOf(0));
			symbol_300.setIsUnique(false);
			
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::Collection::notEmpty() ocl|Collection{T}|notEmpty()
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_301.setName("notEmpty");
			symbol_301.setType(symbol_19);  // Boolean
			symbol_301.setLower(BigInteger.valueOf(0));
			symbol_301.setIsUnique(false);
			
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Collection::one() ocl|Collection{T}|one(ocl|Collection{T}?T)
			Iteration symbol_302 = PivotFactory.eINSTANCE.createIteration();
			symbol_302.setName("one");
			symbol_302.setType(symbol_19);  // Boolean
			
			Parameter symbol_303 = PivotFactory.eINSTANCE.createParameter();
			symbol_303.setName("i");
			symbol_303.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_302.getOwnedIterators().add(symbol_303);
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Collection::product() ocl|Collection{T}|product{T2}(ocl|Collection[T2])
			Operation symbol_304 = PivotFactory.eINSTANCE.createOperation();
			symbol_45.setName("T2");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_304.setOwnedTemplateSignature(symbol_43);
			symbol_304.setName("product");
			symbol_304.setType(symbol_198);  // ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
			symbol_304.setLower(BigInteger.valueOf(0));
			symbol_304.setIsUnique(false);
			
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("c2");
			symbol_305.setType(symbol_119);  // ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
			symbol_305.setLower(BigInteger.valueOf(0));
			symbol_305.setIsUnique(false);
			
			symbol_304.getOwnedParameters().add(symbol_305);
			symbol_304.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_304);
		}
		{	// ocl::Collection::reject() ocl|Collection{T}|reject(ocl|Collection{T}?T)
			Iteration symbol_306 = PivotFactory.eINSTANCE.createIteration();
			symbol_306.setName("reject");
			symbol_306.setType(symbol_133);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("i");
			symbol_307.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_306.getOwnedIterators().add(symbol_307);
			symbol_306.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_306);
		}
		{	// ocl::Collection::select() ocl|Collection{T}|select(ocl|Collection{T}?T)
			Iteration symbol_308 = PivotFactory.eINSTANCE.createIteration();
			symbol_308.setName("select");
			symbol_308.setType(symbol_133);  // ocl|Collection[ocl|Collection{T}?T]
			
			Parameter symbol_309 = PivotFactory.eINSTANCE.createParameter();
			symbol_309.setName("i");
			symbol_309.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_308.getOwnedIterators().add(symbol_309);
			symbol_308.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_308);
		}
		{	// ocl::Collection::size() ocl|Collection{T}|size()
			Operation symbol_310 = PivotFactory.eINSTANCE.createOperation();
			symbol_310.setName("size");
			symbol_310.setType(symbol_47);  // Integer
			symbol_310.setLower(BigInteger.valueOf(0));
			symbol_310.setIsUnique(false);
			
			symbol_310.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_310);
		}
		{	// ocl::Collection::sortedBy() ocl|Collection{T}|sortedBy(ocl|Collection{T}?T)
			Iteration symbol_311 = PivotFactory.eINSTANCE.createIteration();
			symbol_311.setName("sortedBy");
			symbol_311.setType(symbol_180);  // ocl|OrderedCollection[ocl|Collection{T}?T]
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("i");
			symbol_312.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_311.getOwnedIterators().add(symbol_312);
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Collection::sum() ocl|Collection{T}|sum()
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_313.setName("sum");
			symbol_313.setType(symbol_27);  // ocl|Collection{T}?T
			symbol_313.setLower(BigInteger.valueOf(0));
			symbol_313.setIsUnique(false);
			
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_313);
		}
		symbol_1.getOwnedTypes().add(symbol_24);
		//
		// ocl::Enumeration ocl|Enumeration
		//
		symbol_46.setName("Enumeration");
		symbol_46.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::Enumeration::allInstances() ocl|Enumeration|allInstances()
			Operation symbol_314 = PivotFactory.eINSTANCE.createOperation();
			symbol_314.setName("allInstances");
			symbol_314.setType(symbol_202);  // ocl|Set[ocl|Enumeration]
			symbol_314.setLower(BigInteger.valueOf(0));
			symbol_314.setIsUnique(false);
			
			symbol_314.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_46.getOwnedOperations().add(symbol_314);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// ocl::Integer Integer
		//
		symbol_47.setName("Integer");
		symbol_47.getSuperClasses().add(symbol_85); // Real
		{	// ocl::Integer::*() Integer|*(Integer)
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_315.setName("*");
			symbol_315.setType(symbol_47);  // Integer
			symbol_315.setLower(BigInteger.valueOf(0));
			symbol_315.setIsUnique(false);
			
			Parameter symbol_316 = PivotFactory.eINSTANCE.createParameter();
			symbol_316.setName("i");
			symbol_316.setType(symbol_47);  // Integer
			symbol_316.setLower(BigInteger.valueOf(0));
			symbol_316.setIsUnique(false);
			
			symbol_315.getOwnedParameters().add(symbol_316);
			symbol_315.setPrecedence(symbol_4);
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Integer::+() Integer|+(Integer)
			Operation symbol_317 = PivotFactory.eINSTANCE.createOperation();
			symbol_317.setName("+");
			symbol_317.setType(symbol_47);  // Integer
			symbol_317.setLower(BigInteger.valueOf(0));
			symbol_317.setIsUnique(false);
			
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("i");
			symbol_318.setType(symbol_47);  // Integer
			symbol_318.setLower(BigInteger.valueOf(0));
			symbol_318.setIsUnique(false);
			
			symbol_317.getOwnedParameters().add(symbol_318);
			symbol_317.setPrecedence(symbol_5);
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_317);
		}
		{	// ocl::Integer::-() Integer|-()
			Operation symbol_319 = PivotFactory.eINSTANCE.createOperation();
			symbol_319.setName("-");
			symbol_319.setType(symbol_47);  // Integer
			symbol_319.setLower(BigInteger.valueOf(0));
			symbol_319.setIsUnique(false);
			
			symbol_319.setPrecedence(symbol_3);
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_319);
		}
		{	// ocl::Integer::-() Integer|-(Integer)
			Operation symbol_320 = PivotFactory.eINSTANCE.createOperation();
			symbol_320.setName("-");
			symbol_320.setType(symbol_47);  // Integer
			symbol_320.setLower(BigInteger.valueOf(0));
			symbol_320.setIsUnique(false);
			
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("i");
			symbol_321.setType(symbol_47);  // Integer
			symbol_321.setLower(BigInteger.valueOf(0));
			symbol_321.setIsUnique(false);
			
			symbol_320.getOwnedParameters().add(symbol_321);
			symbol_320.setPrecedence(symbol_5);
			symbol_320.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_320);
		}
		{	// ocl::Integer::/() Integer|/(Integer)
			Operation symbol_322 = PivotFactory.eINSTANCE.createOperation();
			symbol_322.setName("/");
			symbol_322.setType(symbol_85);  // Real
			symbol_322.setLower(BigInteger.valueOf(0));
			symbol_322.setIsUnique(false);
			
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("i");
			symbol_323.setType(symbol_47);  // Integer
			symbol_323.setLower(BigInteger.valueOf(0));
			symbol_323.setIsUnique(false);
			
			symbol_322.getOwnedParameters().add(symbol_323);
			symbol_322.setPrecedence(symbol_4);
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::Integer::abs() Integer|abs()
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_324.setName("abs");
			symbol_324.setType(symbol_47);  // Integer
			symbol_324.setLower(BigInteger.valueOf(0));
			symbol_324.setIsUnique(false);
			
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Integer::div() Integer|div(Integer)
			Operation symbol_325 = PivotFactory.eINSTANCE.createOperation();
			symbol_325.setName("div");
			symbol_325.setType(symbol_47);  // Integer
			symbol_325.setLower(BigInteger.valueOf(0));
			symbol_325.setIsUnique(false);
			
			Parameter symbol_326 = PivotFactory.eINSTANCE.createParameter();
			symbol_326.setName("i");
			symbol_326.setType(symbol_47);  // Integer
			symbol_326.setLower(BigInteger.valueOf(0));
			symbol_326.setIsUnique(false);
			
			symbol_325.getOwnedParameters().add(symbol_326);
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::Integer::max() Integer|max(Integer)
			Operation symbol_327 = PivotFactory.eINSTANCE.createOperation();
			symbol_327.setName("max");
			symbol_327.setType(symbol_47);  // Integer
			symbol_327.setLower(BigInteger.valueOf(0));
			symbol_327.setIsUnique(false);
			
			Parameter symbol_328 = PivotFactory.eINSTANCE.createParameter();
			symbol_328.setName("i");
			symbol_328.setType(symbol_47);  // Integer
			symbol_328.setLower(BigInteger.valueOf(0));
			symbol_328.setIsUnique(false);
			
			symbol_327.getOwnedParameters().add(symbol_328);
			symbol_327.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_327);
		}
		{	// ocl::Integer::min() Integer|min(Integer)
			Operation symbol_329 = PivotFactory.eINSTANCE.createOperation();
			symbol_329.setName("min");
			symbol_329.setType(symbol_47);  // Integer
			symbol_329.setLower(BigInteger.valueOf(0));
			symbol_329.setIsUnique(false);
			
			Parameter symbol_330 = PivotFactory.eINSTANCE.createParameter();
			symbol_330.setName("i");
			symbol_330.setType(symbol_47);  // Integer
			symbol_330.setLower(BigInteger.valueOf(0));
			symbol_330.setIsUnique(false);
			
			symbol_329.getOwnedParameters().add(symbol_330);
			symbol_329.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_329);
		}
		{	// ocl::Integer::mod() Integer|mod(Integer)
			Operation symbol_331 = PivotFactory.eINSTANCE.createOperation();
			symbol_331.setName("mod");
			symbol_331.setType(symbol_47);  // Integer
			symbol_331.setLower(BigInteger.valueOf(0));
			symbol_331.setIsUnique(false);
			
			Parameter symbol_332 = PivotFactory.eINSTANCE.createParameter();
			symbol_332.setName("i");
			symbol_332.setType(symbol_47);  // Integer
			symbol_332.setLower(BigInteger.valueOf(0));
			symbol_332.setIsUnique(false);
			
			symbol_331.getOwnedParameters().add(symbol_332);
			symbol_331.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_331);
		}
		{	// ocl::Integer::toString() Integer|toString()
			Operation symbol_333 = PivotFactory.eINSTANCE.createOperation();
			symbol_333.setName("toString");
			symbol_333.setType(symbol_103);  // String
			symbol_333.setLower(BigInteger.valueOf(0));
			symbol_333.setIsUnique(false);
			
			symbol_333.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_333);
		}
		symbol_1.getOwnedTypes().add(symbol_47);
		//
		// ocl::NonOrderedCollection ocl|NonOrderedCollection{T}
		//
		symbol_48.setName("NonOrderedCollection");
		symbol_48.setElementType(symbol_51);
		symbol_51.setName("T");
		symbol_50.setOwnedParameteredElement(symbol_51);
		symbol_49.getOwnedParameters().add(symbol_50);
		
		symbol_48.setOwnedTemplateSignature(symbol_49);
		symbol_48.getSuperClasses().add(symbol_136); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl|NonOrderedCollection{T}|closure(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_334 = PivotFactory.eINSTANCE.createIteration();
			symbol_334.setName("closure");
			symbol_334.setType(symbol_197);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("i");
			symbol_335.setType(symbol_51);  // ocl|NonOrderedCollection{T}?T
			symbol_334.getOwnedIterators().add(symbol_335);
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::NonOrderedCollection::collect() ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)
			Iteration symbol_336 = PivotFactory.eINSTANCE.createIteration();
			symbol_54.setName("V");
			symbol_53.setOwnedParameteredElement(symbol_54);
			symbol_52.getOwnedParameters().add(symbol_53);
			
			symbol_336.setOwnedTemplateSignature(symbol_52);
			symbol_336.setName("collect");
			symbol_336.setType(symbol_111);  // ocl|Bag[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
			
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("i");
			symbol_337.setType(symbol_51);  // ocl|NonOrderedCollection{T}?T
			symbol_336.getOwnedIterators().add(symbol_337);
			Parameter symbol_338 = PivotFactory.eINSTANCE.createParameter();
			symbol_338.setName("body");
			symbol_338.setType(symbol_144);  // Lambda~ocl|NonOrderedCollection{T}?T()ocl|NonOrderedCollection{T}|collect{V}(T|Lambda~T()V)?V
			
			symbol_336.getOwnedParameters().add(symbol_338);
			symbol_336.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_336);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl|NonOrderedCollection{T}|collectNested(ocl|NonOrderedCollection{T}?T)
			Iteration symbol_339 = PivotFactory.eINSTANCE.createIteration();
			symbol_339.setName("collectNested");
			symbol_339.setType(symbol_112);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			
			Parameter symbol_340 = PivotFactory.eINSTANCE.createParameter();
			symbol_340.setName("i");
			symbol_340.setType(symbol_51);  // ocl|NonOrderedCollection{T}?T
			symbol_339.getOwnedIterators().add(symbol_340);
			symbol_339.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_339);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl|NonOrderedCollection{T}|intersection(ocl|Bag[ocl|NonOrderedCollection{T}?T])
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("intersection");
			symbol_341.setType(symbol_112);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_341.setLower(BigInteger.valueOf(0));
			symbol_341.setIsUnique(false);
			
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("bag");
			symbol_342.setType(symbol_112);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_342.setLower(BigInteger.valueOf(0));
			symbol_342.setIsUnique(false);
			
			symbol_341.getOwnedParameters().add(symbol_342);
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl|NonOrderedCollection{T}|intersection(ocl|Set[ocl|NonOrderedCollection{T}?T])
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_343.setName("intersection");
			symbol_343.setType(symbol_197);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_343.setLower(BigInteger.valueOf(0));
			symbol_343.setIsUnique(false);
			
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("s");
			symbol_344.setType(symbol_197);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_344.setLower(BigInteger.valueOf(0));
			symbol_344.setIsUnique(false);
			
			symbol_343.getOwnedParameters().add(symbol_344);
			symbol_343.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_343);
		}
		{	// ocl::NonOrderedCollection::union() ocl|NonOrderedCollection{T}|union(ocl|Bag[ocl|NonOrderedCollection{T}?T])
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_345.setName("union");
			symbol_345.setType(symbol_112);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_345.setLower(BigInteger.valueOf(0));
			symbol_345.setIsUnique(false);
			
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("bag");
			symbol_346.setType(symbol_112);  // ocl|Bag[ocl|NonOrderedCollection{T}?T]
			symbol_346.setLower(BigInteger.valueOf(0));
			symbol_346.setIsUnique(false);
			
			symbol_345.getOwnedParameters().add(symbol_346);
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_345);
		}
		{	// ocl::NonOrderedCollection::union() ocl|NonOrderedCollection{T}|union(ocl|Set[ocl|NonOrderedCollection{T}?T])
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("union");
			symbol_347.setType(symbol_197);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_347.setLower(BigInteger.valueOf(0));
			symbol_347.setIsUnique(false);
			
			Parameter symbol_348 = PivotFactory.eINSTANCE.createParameter();
			symbol_348.setName("s");
			symbol_348.setType(symbol_197);  // ocl|Set[ocl|NonOrderedCollection{T}?T]
			symbol_348.setLower(BigInteger.valueOf(0));
			symbol_348.setIsUnique(false);
			
			symbol_347.getOwnedParameters().add(symbol_348);
			symbol_347.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_347);
		}
		symbol_1.getOwnedTypes().add(symbol_48);
		//
		// ocl::NonUniqueCollection ocl|NonUniqueCollection{T}
		//
		symbol_55.setName("NonUniqueCollection");
		symbol_55.setElementType(symbol_58);
		symbol_58.setName("T");
		symbol_57.setOwnedParameteredElement(symbol_58);
		symbol_56.getOwnedParameters().add(symbol_57);
		
		symbol_55.setOwnedTemplateSignature(symbol_56);
		symbol_55.getSuperClasses().add(symbol_129); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl|NonUniqueCollection{T}|sortedBy(ocl|NonUniqueCollection{T}?T)
			Iteration symbol_349 = PivotFactory.eINSTANCE.createIteration();
			symbol_349.setName("sortedBy");
			symbol_349.setType(symbol_188);  // ocl|Sequence[ocl|NonUniqueCollection{T}?T]
			
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("i");
			symbol_350.setType(symbol_58);  // ocl|NonUniqueCollection{T}?T
			symbol_349.getOwnedIterators().add(symbol_350);
			symbol_349.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_349);
		}
		symbol_1.getOwnedTypes().add(symbol_55);
		//
		// ocl::OclAny ocl|OclAny
		//
		symbol_59.setName("OclAny");
		{	// ocl::OclAny::<>() ocl|OclAny|<>(ocl|OclAny)
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_351.setName("<>");
			symbol_351.setType(symbol_19);  // Boolean
			symbol_351.setLower(BigInteger.valueOf(0));
			symbol_351.setIsUnique(false);
			
			Parameter symbol_352 = PivotFactory.eINSTANCE.createParameter();
			symbol_352.setName("object2");
			symbol_352.setType(symbol_59);  // ocl|OclAny
			symbol_352.setLower(BigInteger.valueOf(0));
			symbol_352.setIsUnique(false);
			
			symbol_351.getOwnedParameters().add(symbol_352);
			symbol_351.setPrecedence(symbol_7);
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::OclAny::=() ocl|OclAny|=(ocl|OclAny)
			Operation symbol_353 = PivotFactory.eINSTANCE.createOperation();
			symbol_353.setName("=");
			symbol_353.setType(symbol_19);  // Boolean
			symbol_353.setLower(BigInteger.valueOf(0));
			symbol_353.setIsUnique(false);
			
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("object2");
			symbol_354.setType(symbol_59);  // ocl|OclAny
			symbol_354.setLower(BigInteger.valueOf(0));
			symbol_354.setIsUnique(false);
			
			symbol_353.getOwnedParameters().add(symbol_354);
			symbol_353.setPrecedence(symbol_7);
			symbol_353.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_353);
		}
		{	// ocl::OclAny::oclAsSet() ocl|OclAny|oclAsSet{OclSelf}()
			Operation symbol_355 = PivotFactory.eINSTANCE.createOperation();
			symbol_62.setName("OclSelf");
			symbol_61.setOwnedParameteredElement(symbol_62);
			symbol_60.getOwnedParameters().add(symbol_61);
			
			symbol_355.setOwnedTemplateSignature(symbol_60);
			symbol_355.setName("oclAsSet");
			symbol_355.setType(symbol_200);  // ocl|Set[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
			symbol_355.setLower(BigInteger.valueOf(0));
			symbol_355.setIsUnique(false);
			
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_355);
		}
		{	// ocl::OclAny::oclAsType() ocl|OclAny|oclAsType{T}(ocl|Classifier)
			Operation symbol_356 = PivotFactory.eINSTANCE.createOperation();
			symbol_65.setName("T");
			symbol_64.setOwnedParameteredElement(symbol_65);
			symbol_63.getOwnedParameters().add(symbol_64);
			
			symbol_356.setOwnedTemplateSignature(symbol_63);
			symbol_356.setName("oclAsType");
			symbol_356.setType(symbol_65);  // ocl|OclAny|oclAsType{T}(ocl|Classifier)?T
			symbol_356.setLower(BigInteger.valueOf(0));
			symbol_356.setIsUnique(false);
			
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("type");
			symbol_357.setType(symbol_20);  // ocl|Classifier
			symbol_357.setLower(BigInteger.valueOf(0));
			symbol_357.setIsUnique(false);
			
			symbol_356.getOwnedParameters().add(symbol_357);
			symbol_356.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_356);
		}
		{	// ocl::OclAny::oclIsInState() ocl|OclAny|oclIsInState(ocl|OclState)
			Operation symbol_358 = PivotFactory.eINSTANCE.createOperation();
			symbol_358.setName("oclIsInState");
			symbol_358.setType(symbol_19);  // Boolean
			symbol_358.setLower(BigInteger.valueOf(0));
			symbol_358.setIsUnique(false);
			
			Parameter symbol_359 = PivotFactory.eINSTANCE.createParameter();
			symbol_359.setName("statespec");
			symbol_359.setType(symbol_71);  // ocl|OclState
			symbol_359.setLower(BigInteger.valueOf(0));
			symbol_359.setIsUnique(false);
			
			symbol_358.getOwnedParameters().add(symbol_359);
			symbol_358.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_358);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl|OclAny|oclIsInvalid()
			Operation symbol_360 = PivotFactory.eINSTANCE.createOperation();
			symbol_360.setName("oclIsInvalid");
			symbol_360.setType(symbol_19);  // Boolean
			symbol_360.setLower(BigInteger.valueOf(0));
			symbol_360.setIsUnique(false);
			
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl|OclAny|oclIsKindOf(ocl|Classifier)
			Operation symbol_361 = PivotFactory.eINSTANCE.createOperation();
			symbol_361.setName("oclIsKindOf");
			symbol_361.setType(symbol_19);  // Boolean
			symbol_361.setLower(BigInteger.valueOf(0));
			symbol_361.setIsUnique(false);
			
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("type");
			symbol_362.setType(symbol_20);  // ocl|Classifier
			symbol_362.setLower(BigInteger.valueOf(0));
			symbol_362.setIsUnique(false);
			
			symbol_361.getOwnedParameters().add(symbol_362);
			symbol_361.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_361);
		}
		{	// ocl::OclAny::oclIsNew() ocl|OclAny|oclIsNew()
			Operation symbol_363 = PivotFactory.eINSTANCE.createOperation();
			symbol_363.setName("oclIsNew");
			symbol_363.setType(symbol_19);  // Boolean
			symbol_363.setLower(BigInteger.valueOf(0));
			symbol_363.setIsUnique(false);
			
			symbol_363.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_363);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl|OclAny|oclIsTypeOf(ocl|Classifier)
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("oclIsTypeOf");
			symbol_364.setType(symbol_19);  // Boolean
			symbol_364.setLower(BigInteger.valueOf(0));
			symbol_364.setIsUnique(false);
			
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("type");
			symbol_365.setType(symbol_20);  // ocl|Classifier
			symbol_365.setLower(BigInteger.valueOf(0));
			symbol_365.setIsUnique(false);
			
			symbol_364.getOwnedParameters().add(symbol_365);
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_364);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl|OclAny|oclIsUndefined()
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_366.setName("oclIsUndefined");
			symbol_366.setType(symbol_19);  // Boolean
			symbol_366.setLower(BigInteger.valueOf(0));
			symbol_366.setIsUnique(false);
			
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_366);
		}
		{	// ocl::OclAny::oclType() ocl|OclAny|oclType{OclSelf}()
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_68.setName("OclSelf");
			symbol_67.setOwnedParameteredElement(symbol_68);
			symbol_66.getOwnedParameters().add(symbol_67);
			
			symbol_367.setOwnedTemplateSignature(symbol_66);
			symbol_367.setName("oclType");
			symbol_367.setType(symbol_68);  // ocl|OclAny|oclType{OclSelf}()?OclSelf
			symbol_367.setLower(BigInteger.valueOf(0));
			symbol_367.setIsUnique(false);
			
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_367);
		}
		symbol_1.getOwnedTypes().add(symbol_59);
		//
		// ocl::OclInvalid ocl|OclInvalid
		//
		symbol_69.setName("OclInvalid");
		symbol_69.getSuperClasses().add(symbol_73); // ocl|OclVoid
		{	// ocl::OclInvalid::<>() ocl|OclInvalid|<>(ocl|OclAny)
			Operation symbol_368 = PivotFactory.eINSTANCE.createOperation();
			symbol_368.setName("<>");
			symbol_368.setType(symbol_19);  // Boolean
			symbol_368.setLower(BigInteger.valueOf(0));
			symbol_368.setIsUnique(false);
			
			Parameter symbol_369 = PivotFactory.eINSTANCE.createParameter();
			symbol_369.setName("object2");
			symbol_369.setType(symbol_59);  // ocl|OclAny
			symbol_369.setLower(BigInteger.valueOf(0));
			symbol_369.setIsUnique(false);
			
			symbol_368.getOwnedParameters().add(symbol_369);
			symbol_368.setPrecedence(symbol_7);
			symbol_368.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_368);
		}
		{	// ocl::OclInvalid::=() ocl|OclInvalid|=(ocl|OclAny)
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_370.setName("=");
			symbol_370.setType(symbol_19);  // Boolean
			symbol_370.setLower(BigInteger.valueOf(0));
			symbol_370.setIsUnique(false);
			
			Parameter symbol_371 = PivotFactory.eINSTANCE.createParameter();
			symbol_371.setName("object2");
			symbol_371.setType(symbol_59);  // ocl|OclAny
			symbol_371.setLower(BigInteger.valueOf(0));
			symbol_371.setIsUnique(false);
			
			symbol_370.getOwnedParameters().add(symbol_371);
			symbol_370.setPrecedence(symbol_7);
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_370);
		}
		{	// ocl::OclInvalid::allInstances() ocl|OclInvalid|allInstances()
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_372.setName("allInstances");
			symbol_372.setType(symbol_196);  // ocl|Set[ocl|OclInvalid]
			symbol_372.setLower(BigInteger.valueOf(0));
			symbol_372.setIsUnique(false);
			
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::OclInvalid::toString() ocl|OclInvalid|toString()
			Operation symbol_373 = PivotFactory.eINSTANCE.createOperation();
			symbol_373.setName("toString");
			symbol_373.setType(symbol_103);  // String
			symbol_373.setLower(BigInteger.valueOf(0));
			symbol_373.setIsUnique(false);
			
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_373);
		}
		symbol_1.getOwnedTypes().add(symbol_69);
		//
		// ocl::OclMessage ocl|OclMessage
		//
		symbol_70.setName("OclMessage");
		symbol_70.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::OclMessage::hasReturned() ocl|OclMessage|hasReturned()
			Operation symbol_374 = PivotFactory.eINSTANCE.createOperation();
			symbol_374.setName("hasReturned");
			symbol_374.setType(symbol_19);  // Boolean
			symbol_374.setLower(BigInteger.valueOf(0));
			symbol_374.setIsUnique(false);
			
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::OclMessage::isOperationCall() ocl|OclMessage|isOperationCall()
			Operation symbol_375 = PivotFactory.eINSTANCE.createOperation();
			symbol_375.setName("isOperationCall");
			symbol_375.setType(symbol_19);  // Boolean
			symbol_375.setLower(BigInteger.valueOf(0));
			symbol_375.setIsUnique(false);
			
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_375);
		}
		{	// ocl::OclMessage::isSignalSent() ocl|OclMessage|isSignalSent()
			Operation symbol_376 = PivotFactory.eINSTANCE.createOperation();
			symbol_376.setName("isSignalSent");
			symbol_376.setType(symbol_19);  // Boolean
			symbol_376.setLower(BigInteger.valueOf(0));
			symbol_376.setIsUnique(false);
			
			symbol_376.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_376);
		}
		{	// ocl::OclMessage::result() ocl|OclMessage|result()
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_377.setName("result");
			symbol_377.setType(symbol_59);  // ocl|OclAny
			symbol_377.setLower(BigInteger.valueOf(0));
			symbol_377.setIsUnique(false);
			
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_377);
		}
		symbol_1.getOwnedTypes().add(symbol_70);
		//
		// ocl::OclState ocl|OclState
		//
		symbol_71.setName("OclState");
		symbol_71.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// ocl::OclTuple ocl|OclTuple
		//
		symbol_72.setName("OclTuple");
		symbol_72.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::OclTuple::<>() ocl|OclTuple|<>(ocl|OclAny)
			Operation symbol_378 = PivotFactory.eINSTANCE.createOperation();
			symbol_378.setName("<>");
			symbol_378.setType(symbol_19);  // Boolean
			symbol_378.setLower(BigInteger.valueOf(0));
			symbol_378.setIsUnique(false);
			
			Parameter symbol_379 = PivotFactory.eINSTANCE.createParameter();
			symbol_379.setName("object2");
			symbol_379.setType(symbol_59);  // ocl|OclAny
			symbol_379.setLower(BigInteger.valueOf(0));
			symbol_379.setIsUnique(false);
			
			symbol_378.getOwnedParameters().add(symbol_379);
			symbol_378.setPrecedence(symbol_7);
			symbol_378.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_378);
		}
		{	// ocl::OclTuple::=() ocl|OclTuple|=(ocl|OclAny)
			Operation symbol_380 = PivotFactory.eINSTANCE.createOperation();
			symbol_380.setName("=");
			symbol_380.setType(symbol_19);  // Boolean
			symbol_380.setLower(BigInteger.valueOf(0));
			symbol_380.setIsUnique(false);
			
			Parameter symbol_381 = PivotFactory.eINSTANCE.createParameter();
			symbol_381.setName("object2");
			symbol_381.setType(symbol_59);  // ocl|OclAny
			symbol_381.setLower(BigInteger.valueOf(0));
			symbol_381.setIsUnique(false);
			
			symbol_380.getOwnedParameters().add(symbol_381);
			symbol_380.setPrecedence(symbol_7);
			symbol_380.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_380);
		}
		symbol_1.getOwnedTypes().add(symbol_72);
		//
		// ocl::OclVoid ocl|OclVoid
		//
		symbol_73.setName("OclVoid");
		symbol_73.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::OclVoid::<>() ocl|OclVoid|<>(ocl|OclAny)
			Operation symbol_382 = PivotFactory.eINSTANCE.createOperation();
			symbol_382.setName("<>");
			symbol_382.setType(symbol_19);  // Boolean
			symbol_382.setLower(BigInteger.valueOf(0));
			symbol_382.setIsUnique(false);
			
			Parameter symbol_383 = PivotFactory.eINSTANCE.createParameter();
			symbol_383.setName("object2");
			symbol_383.setType(symbol_59);  // ocl|OclAny
			symbol_383.setLower(BigInteger.valueOf(0));
			symbol_383.setIsUnique(false);
			
			symbol_382.getOwnedParameters().add(symbol_383);
			symbol_382.setPrecedence(symbol_7);
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_382);
		}
		{	// ocl::OclVoid::=() ocl|OclVoid|=(ocl|OclAny)
			Operation symbol_384 = PivotFactory.eINSTANCE.createOperation();
			symbol_384.setName("=");
			symbol_384.setType(symbol_19);  // Boolean
			symbol_384.setLower(BigInteger.valueOf(0));
			symbol_384.setIsUnique(false);
			
			Parameter symbol_385 = PivotFactory.eINSTANCE.createParameter();
			symbol_385.setName("object2");
			symbol_385.setType(symbol_59);  // ocl|OclAny
			symbol_385.setLower(BigInteger.valueOf(0));
			symbol_385.setIsUnique(false);
			
			symbol_384.getOwnedParameters().add(symbol_385);
			symbol_384.setPrecedence(symbol_7);
			symbol_384.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_384);
		}
		{	// ocl::OclVoid::allInstances() ocl|OclVoid|allInstances()
			Operation symbol_386 = PivotFactory.eINSTANCE.createOperation();
			symbol_386.setName("allInstances");
			symbol_386.setType(symbol_205);  // ocl|Set[ocl|OclVoid]
			symbol_386.setLower(BigInteger.valueOf(0));
			symbol_386.setIsUnique(false);
			
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::OclVoid::and() ocl|OclVoid|and(Boolean)
			Operation symbol_387 = PivotFactory.eINSTANCE.createOperation();
			symbol_387.setName("and");
			symbol_387.setType(symbol_19);  // Boolean
			symbol_387.setLower(BigInteger.valueOf(0));
			symbol_387.setIsUnique(false);
			
			Parameter symbol_388 = PivotFactory.eINSTANCE.createParameter();
			symbol_388.setName("b");
			symbol_388.setType(symbol_19);  // Boolean
			symbol_388.setLower(BigInteger.valueOf(0));
			symbol_388.setIsUnique(false);
			
			symbol_387.getOwnedParameters().add(symbol_388);
			symbol_387.setPrecedence(symbol_8);
			symbol_387.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_387);
		}
		{	// ocl::OclVoid::implies() ocl|OclVoid|implies(Boolean)
			Operation symbol_389 = PivotFactory.eINSTANCE.createOperation();
			symbol_389.setName("implies");
			symbol_389.setType(symbol_19);  // Boolean
			symbol_389.setLower(BigInteger.valueOf(0));
			symbol_389.setIsUnique(false);
			
			Parameter symbol_390 = PivotFactory.eINSTANCE.createParameter();
			symbol_390.setName("b");
			symbol_390.setType(symbol_19);  // Boolean
			symbol_390.setLower(BigInteger.valueOf(0));
			symbol_390.setIsUnique(false);
			
			symbol_389.getOwnedParameters().add(symbol_390);
			symbol_389.setPrecedence(symbol_11);
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_389);
		}
		{	// ocl::OclVoid::or() ocl|OclVoid|or(Boolean)
			Operation symbol_391 = PivotFactory.eINSTANCE.createOperation();
			symbol_391.setName("or");
			symbol_391.setType(symbol_19);  // Boolean
			symbol_391.setLower(BigInteger.valueOf(0));
			symbol_391.setIsUnique(false);
			
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("b");
			symbol_392.setType(symbol_19);  // Boolean
			symbol_392.setLower(BigInteger.valueOf(0));
			symbol_392.setIsUnique(false);
			
			symbol_391.getOwnedParameters().add(symbol_392);
			symbol_391.setPrecedence(symbol_9);
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::OclVoid::toString() ocl|OclVoid|toString()
			Operation symbol_393 = PivotFactory.eINSTANCE.createOperation();
			symbol_393.setName("toString");
			symbol_393.setType(symbol_103);  // String
			symbol_393.setLower(BigInteger.valueOf(0));
			symbol_393.setIsUnique(false);
			
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_73.getOwnedOperations().add(symbol_393);
		}
		symbol_1.getOwnedTypes().add(symbol_73);
		//
		// ocl::OrderedCollection ocl|OrderedCollection{T}
		//
		symbol_74.setName("OrderedCollection");
		symbol_74.setElementType(symbol_77);
		symbol_77.setName("T");
		symbol_76.setOwnedParameteredElement(symbol_77);
		symbol_75.getOwnedParameters().add(symbol_76);
		
		symbol_74.setOwnedTemplateSignature(symbol_75);
		symbol_74.getSuperClasses().add(symbol_126); // ocl|Collection[ocl|OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl|OrderedCollection{T}|at(Integer)
			Operation symbol_394 = PivotFactory.eINSTANCE.createOperation();
			symbol_394.setName("at");
			symbol_394.setType(symbol_77);  // ocl|OrderedCollection{T}?T
			symbol_394.setLower(BigInteger.valueOf(0));
			symbol_394.setIsUnique(false);
			
			Parameter symbol_395 = PivotFactory.eINSTANCE.createParameter();
			symbol_395.setName("index");
			symbol_395.setType(symbol_47);  // Integer
			symbol_395.setLower(BigInteger.valueOf(0));
			symbol_395.setIsUnique(false);
			
			symbol_394.getOwnedParameters().add(symbol_395);
			symbol_394.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_394);
		}
		{	// ocl::OrderedCollection::closure() ocl|OrderedCollection{T}|closure(ocl|OrderedCollection{T}?T)
			Iteration symbol_396 = PivotFactory.eINSTANCE.createIteration();
			symbol_396.setName("closure");
			symbol_396.setType(symbol_185);  // ocl|OrderedSet[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("i");
			symbol_397.setType(symbol_77);  // ocl|OrderedCollection{T}?T
			symbol_396.getOwnedIterators().add(symbol_397);
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_396);
		}
		{	// ocl::OrderedCollection::collect() ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)
			Iteration symbol_398 = PivotFactory.eINSTANCE.createIteration();
			symbol_80.setName("V");
			symbol_79.setOwnedParameteredElement(symbol_80);
			symbol_78.getOwnedParameters().add(symbol_79);
			
			symbol_398.setOwnedTemplateSignature(symbol_78);
			symbol_398.setName("collect");
			symbol_398.setType(symbol_189);  // ocl|Sequence[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
			
			Parameter symbol_399 = PivotFactory.eINSTANCE.createParameter();
			symbol_399.setName("i");
			symbol_399.setType(symbol_77);  // ocl|OrderedCollection{T}?T
			symbol_398.getOwnedIterators().add(symbol_399);
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("body");
			symbol_400.setType(symbol_145);  // Lambda~ocl|OrderedCollection{T}?T()ocl|OrderedCollection{T}|collect{V}(T|Lambda~T()V)?V
			
			symbol_398.getOwnedParameters().add(symbol_400);
			symbol_398.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_398);
		}
		{	// ocl::OrderedCollection::collectNested() ocl|OrderedCollection{T}|collectNested(ocl|OrderedCollection{T}?T)
			Iteration symbol_401 = PivotFactory.eINSTANCE.createIteration();
			symbol_401.setName("collectNested");
			symbol_401.setType(symbol_191);  // ocl|Sequence[ocl|OrderedCollection{T}?T]
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("i");
			symbol_402.setType(symbol_77);  // ocl|OrderedCollection{T}?T
			symbol_401.getOwnedIterators().add(symbol_402);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OrderedCollection::first() ocl|OrderedCollection{T}|first()
			Operation symbol_403 = PivotFactory.eINSTANCE.createOperation();
			symbol_403.setName("first");
			symbol_403.setType(symbol_77);  // ocl|OrderedCollection{T}?T
			symbol_403.setLower(BigInteger.valueOf(0));
			symbol_403.setIsUnique(false);
			
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_403);
		}
		{	// ocl::OrderedCollection::indexOf() ocl|OrderedCollection{T}|indexOf(ocl|OclAny)
			Operation symbol_404 = PivotFactory.eINSTANCE.createOperation();
			symbol_404.setName("indexOf");
			symbol_404.setType(symbol_47);  // Integer
			symbol_404.setLower(BigInteger.valueOf(0));
			symbol_404.setIsUnique(false);
			
			Parameter symbol_405 = PivotFactory.eINSTANCE.createParameter();
			symbol_405.setName("obj");
			symbol_405.setType(symbol_59);  // ocl|OclAny
			symbol_405.setLower(BigInteger.valueOf(0));
			symbol_405.setIsUnique(false);
			
			symbol_404.getOwnedParameters().add(symbol_405);
			symbol_404.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_404);
		}
		{	// ocl::OrderedCollection::last() ocl|OrderedCollection{T}|last()
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_406.setName("last");
			symbol_406.setType(symbol_77);  // ocl|OrderedCollection{T}?T
			symbol_406.setLower(BigInteger.valueOf(0));
			symbol_406.setIsUnique(false);
			
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OrderedCollection::reverse() ocl|OrderedCollection{T}|reverse()
			Operation symbol_407 = PivotFactory.eINSTANCE.createOperation();
			symbol_407.setName("reverse");
			symbol_407.setType(symbol_174);  // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
			symbol_407.setLower(BigInteger.valueOf(0));
			symbol_407.setIsUnique(false);
			
			symbol_407.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_407);
		}
		symbol_1.getOwnedTypes().add(symbol_74);
		//
		// ocl::OrderedSet ocl|OrderedSet{T}
		//
		symbol_81.setName("OrderedSet");
		symbol_81.setElementType(symbol_84);
		symbol_84.setName("T");
		symbol_83.setOwnedParameteredElement(symbol_84);
		symbol_82.getOwnedParameters().add(symbol_83);
		
		symbol_81.setOwnedTemplateSignature(symbol_82);
		symbol_81.getSuperClasses().add(symbol_210); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_81.getSuperClasses().add(symbol_173); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl|OrderedSet{T}|-(ocl|Set[ocl|OclAny])
			Operation symbol_408 = PivotFactory.eINSTANCE.createOperation();
			symbol_408.setName("-");
			symbol_408.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_408.setLower(BigInteger.valueOf(0));
			symbol_408.setIsUnique(false);
			
			Parameter symbol_409 = PivotFactory.eINSTANCE.createParameter();
			symbol_409.setName("s");
			symbol_409.setType(symbol_194);  // ocl|Set[ocl|OclAny]
			symbol_409.setLower(BigInteger.valueOf(0));
			symbol_409.setIsUnique(false);
			
			symbol_408.getOwnedParameters().add(symbol_409);
			symbol_408.setPrecedence(symbol_5);
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_408);
		}
		{	// ocl::OrderedSet::<>() ocl|OrderedSet{T}|<>(ocl|OclAny)
			Operation symbol_410 = PivotFactory.eINSTANCE.createOperation();
			symbol_410.setName("<>");
			symbol_410.setType(symbol_19);  // Boolean
			symbol_410.setLower(BigInteger.valueOf(0));
			symbol_410.setIsUnique(false);
			
			Parameter symbol_411 = PivotFactory.eINSTANCE.createParameter();
			symbol_411.setName("object2");
			symbol_411.setType(symbol_59);  // ocl|OclAny
			symbol_411.setLower(BigInteger.valueOf(0));
			symbol_411.setIsUnique(false);
			
			symbol_410.getOwnedParameters().add(symbol_411);
			symbol_410.setPrecedence(symbol_7);
			symbol_410.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_410);
		}
		{	// ocl::OrderedSet::=() ocl|OrderedSet{T}|=(ocl|OclAny)
			Operation symbol_412 = PivotFactory.eINSTANCE.createOperation();
			symbol_412.setName("=");
			symbol_412.setType(symbol_19);  // Boolean
			symbol_412.setLower(BigInteger.valueOf(0));
			symbol_412.setIsUnique(false);
			
			Parameter symbol_413 = PivotFactory.eINSTANCE.createParameter();
			symbol_413.setName("object2");
			symbol_413.setType(symbol_59);  // ocl|OclAny
			symbol_413.setLower(BigInteger.valueOf(0));
			symbol_413.setIsUnique(false);
			
			symbol_412.getOwnedParameters().add(symbol_413);
			symbol_412.setPrecedence(symbol_7);
			symbol_412.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_412);
		}
		{	// ocl::OrderedSet::append() ocl|OrderedSet{T}|append(ocl|OrderedSet{T}?T)
			Operation symbol_414 = PivotFactory.eINSTANCE.createOperation();
			symbol_414.setName("append");
			symbol_414.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_414.setLower(BigInteger.valueOf(0));
			symbol_414.setIsUnique(false);
			
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("object");
			symbol_415.setType(symbol_84);  // ocl|OrderedSet{T}?T
			symbol_415.setLower(BigInteger.valueOf(0));
			symbol_415.setIsUnique(false);
			
			symbol_414.getOwnedParameters().add(symbol_415);
			symbol_414.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_414);
		}
		{	// ocl::OrderedSet::excluding() ocl|OrderedSet{T}|excluding(ocl|OclAny)
			Operation symbol_416 = PivotFactory.eINSTANCE.createOperation();
			symbol_416.setName("excluding");
			symbol_416.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_416.setLower(BigInteger.valueOf(0));
			symbol_416.setIsUnique(false);
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("object");
			symbol_417.setType(symbol_59);  // ocl|OclAny
			symbol_417.setLower(BigInteger.valueOf(0));
			symbol_417.setIsUnique(false);
			
			symbol_416.getOwnedParameters().add(symbol_417);
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::OrderedSet::including() ocl|OrderedSet{T}|including(ocl|OrderedSet{T}?T)
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("including");
			symbol_418.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_418.setLower(BigInteger.valueOf(0));
			symbol_418.setIsUnique(false);
			
			Parameter symbol_419 = PivotFactory.eINSTANCE.createParameter();
			symbol_419.setName("object");
			symbol_419.setType(symbol_84);  // ocl|OrderedSet{T}?T
			symbol_419.setLower(BigInteger.valueOf(0));
			symbol_419.setIsUnique(false);
			
			symbol_418.getOwnedParameters().add(symbol_419);
			symbol_418.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_418);
		}
		{	// ocl::OrderedSet::insertAt() ocl|OrderedSet{T}|insertAt(Integer,ocl|OrderedSet{T}?T)
			Operation symbol_420 = PivotFactory.eINSTANCE.createOperation();
			symbol_420.setName("insertAt");
			symbol_420.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_420.setLower(BigInteger.valueOf(0));
			symbol_420.setIsUnique(false);
			
			Parameter symbol_421 = PivotFactory.eINSTANCE.createParameter();
			symbol_421.setName("index");
			symbol_421.setType(symbol_47);  // Integer
			symbol_421.setLower(BigInteger.valueOf(0));
			symbol_421.setIsUnique(false);
			
			symbol_420.getOwnedParameters().add(symbol_421);
			Parameter symbol_422 = PivotFactory.eINSTANCE.createParameter();
			symbol_422.setName("object");
			symbol_422.setType(symbol_84);  // ocl|OrderedSet{T}?T
			symbol_422.setLower(BigInteger.valueOf(0));
			symbol_422.setIsUnique(false);
			
			symbol_420.getOwnedParameters().add(symbol_422);
			symbol_420.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_420);
		}
		{	// ocl::OrderedSet::intersection() ocl|OrderedSet{T}|intersection(ocl|Set[ocl|OrderedSet{T}?T])
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("intersection");
			symbol_423.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_423.setLower(BigInteger.valueOf(0));
			symbol_423.setIsUnique(false);
			
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("o");
			symbol_424.setType(symbol_193);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_424.setLower(BigInteger.valueOf(0));
			symbol_424.setIsUnique(false);
			
			symbol_423.getOwnedParameters().add(symbol_424);
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_423);
		}
		{	// ocl::OrderedSet::prepend() ocl|OrderedSet{T}|prepend(ocl|OrderedSet{T}?T)
			Operation symbol_425 = PivotFactory.eINSTANCE.createOperation();
			symbol_425.setName("prepend");
			symbol_425.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_425.setLower(BigInteger.valueOf(0));
			symbol_425.setIsUnique(false);
			
			Parameter symbol_426 = PivotFactory.eINSTANCE.createParameter();
			symbol_426.setName("object");
			symbol_426.setType(symbol_84);  // ocl|OrderedSet{T}?T
			symbol_426.setLower(BigInteger.valueOf(0));
			symbol_426.setIsUnique(false);
			
			symbol_425.getOwnedParameters().add(symbol_426);
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_425);
		}
		{	// ocl::OrderedSet::reject() ocl|OrderedSet{T}|reject(ocl|OrderedSet{T}?T)
			Iteration symbol_427 = PivotFactory.eINSTANCE.createIteration();
			symbol_427.setName("reject");
			symbol_427.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			
			Parameter symbol_428 = PivotFactory.eINSTANCE.createParameter();
			symbol_428.setName("i");
			symbol_428.setType(symbol_84);  // ocl|OrderedSet{T}?T
			symbol_427.getOwnedIterators().add(symbol_428);
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::OrderedSet::reverse() ocl|OrderedSet{T}|reverse()
			Operation symbol_429 = PivotFactory.eINSTANCE.createOperation();
			symbol_429.setName("reverse");
			symbol_429.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_429.setLower(BigInteger.valueOf(0));
			symbol_429.setIsUnique(false);
			
			symbol_429.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_429);
		}
		{	// ocl::OrderedSet::select() ocl|OrderedSet{T}|select(ocl|OrderedSet{T}?T)
			Iteration symbol_430 = PivotFactory.eINSTANCE.createIteration();
			symbol_430.setName("select");
			symbol_430.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("i");
			symbol_431.setType(symbol_84);  // ocl|OrderedSet{T}?T
			symbol_430.getOwnedIterators().add(symbol_431);
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl|OrderedSet{T}|subOrderedSet(Integer,Integer)
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("subOrderedSet");
			symbol_432.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_432.setLower(BigInteger.valueOf(0));
			symbol_432.setIsUnique(false);
			
			Parameter symbol_433 = PivotFactory.eINSTANCE.createParameter();
			symbol_433.setName("lower");
			symbol_433.setType(symbol_47);  // Integer
			symbol_433.setLower(BigInteger.valueOf(0));
			symbol_433.setIsUnique(false);
			
			symbol_432.getOwnedParameters().add(symbol_433);
			Parameter symbol_434 = PivotFactory.eINSTANCE.createParameter();
			symbol_434.setName("upper");
			symbol_434.setType(symbol_47);  // Integer
			symbol_434.setLower(BigInteger.valueOf(0));
			symbol_434.setIsUnique(false);
			
			symbol_432.getOwnedParameters().add(symbol_434);
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl|OrderedSet{T}|symmetricDifference(ocl|Set[ocl|OclAny])
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_435.setName("symmetricDifference");
			symbol_435.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_435.setLower(BigInteger.valueOf(0));
			symbol_435.setIsUnique(false);
			
			Parameter symbol_436 = PivotFactory.eINSTANCE.createParameter();
			symbol_436.setName("s");
			symbol_436.setType(symbol_194);  // ocl|Set[ocl|OclAny]
			symbol_436.setLower(BigInteger.valueOf(0));
			symbol_436.setIsUnique(false);
			
			symbol_435.getOwnedParameters().add(symbol_436);
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_435);
		}
		{	// ocl::OrderedSet::union() ocl|OrderedSet{T}|union(ocl|OrderedSet[ocl|OrderedSet{T}?T])
			Operation symbol_437 = PivotFactory.eINSTANCE.createOperation();
			symbol_437.setName("union");
			symbol_437.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_437.setLower(BigInteger.valueOf(0));
			symbol_437.setIsUnique(false);
			
			Parameter symbol_438 = PivotFactory.eINSTANCE.createParameter();
			symbol_438.setName("o");
			symbol_438.setType(symbol_184);  // ocl|OrderedSet[ocl|OrderedSet{T}?T]
			symbol_438.setLower(BigInteger.valueOf(0));
			symbol_438.setIsUnique(false);
			
			symbol_437.getOwnedParameters().add(symbol_438);
			symbol_437.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_437);
		}
		{	// ocl::OrderedSet::union() ocl|OrderedSet{T}|union(ocl|Set[ocl|OrderedSet{T}?T])
			Operation symbol_439 = PivotFactory.eINSTANCE.createOperation();
			symbol_439.setName("union");
			symbol_439.setType(symbol_193);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_439.setLower(BigInteger.valueOf(0));
			symbol_439.setIsUnique(false);
			
			Parameter symbol_440 = PivotFactory.eINSTANCE.createParameter();
			symbol_440.setName("s");
			symbol_440.setType(symbol_193);  // ocl|Set[ocl|OrderedSet{T}?T]
			symbol_440.setLower(BigInteger.valueOf(0));
			symbol_440.setIsUnique(false);
			
			symbol_439.getOwnedParameters().add(symbol_440);
			symbol_439.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_439);
		}
		symbol_1.getOwnedTypes().add(symbol_81);
		//
		// ocl::Real Real
		//
		symbol_85.setName("Real");
		symbol_85.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::Real::*() Real|*(Real)
			Operation symbol_441 = PivotFactory.eINSTANCE.createOperation();
			symbol_441.setName("*");
			symbol_441.setType(symbol_85);  // Real
			symbol_441.setLower(BigInteger.valueOf(0));
			symbol_441.setIsUnique(false);
			
			Parameter symbol_442 = PivotFactory.eINSTANCE.createParameter();
			symbol_442.setName("r");
			symbol_442.setType(symbol_85);  // Real
			symbol_442.setLower(BigInteger.valueOf(0));
			symbol_442.setIsUnique(false);
			
			symbol_441.getOwnedParameters().add(symbol_442);
			symbol_441.setPrecedence(symbol_4);
			symbol_441.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_441);
		}
		{	// ocl::Real::+() Real|+(Real)
			Operation symbol_443 = PivotFactory.eINSTANCE.createOperation();
			symbol_443.setName("+");
			symbol_443.setType(symbol_85);  // Real
			symbol_443.setLower(BigInteger.valueOf(0));
			symbol_443.setIsUnique(false);
			
			Parameter symbol_444 = PivotFactory.eINSTANCE.createParameter();
			symbol_444.setName("r");
			symbol_444.setType(symbol_85);  // Real
			symbol_444.setLower(BigInteger.valueOf(0));
			symbol_444.setIsUnique(false);
			
			symbol_443.getOwnedParameters().add(symbol_444);
			symbol_443.setPrecedence(symbol_5);
			symbol_443.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_443);
		}
		{	// ocl::Real::-() Real|-(Real)
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("-");
			symbol_445.setType(symbol_85);  // Real
			symbol_445.setLower(BigInteger.valueOf(0));
			symbol_445.setIsUnique(false);
			
			Parameter symbol_446 = PivotFactory.eINSTANCE.createParameter();
			symbol_446.setName("r");
			symbol_446.setType(symbol_85);  // Real
			symbol_446.setLower(BigInteger.valueOf(0));
			symbol_446.setIsUnique(false);
			
			symbol_445.getOwnedParameters().add(symbol_446);
			symbol_445.setPrecedence(symbol_5);
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::Real::-() Real|-()
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("-");
			symbol_447.setType(symbol_85);  // Real
			symbol_447.setLower(BigInteger.valueOf(0));
			symbol_447.setIsUnique(false);
			
			symbol_447.setPrecedence(symbol_3);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::Real::/() Real|/(Real)
			Operation symbol_448 = PivotFactory.eINSTANCE.createOperation();
			symbol_448.setName("/");
			symbol_448.setType(symbol_85);  // Real
			symbol_448.setLower(BigInteger.valueOf(0));
			symbol_448.setIsUnique(false);
			
			Parameter symbol_449 = PivotFactory.eINSTANCE.createParameter();
			symbol_449.setName("r");
			symbol_449.setType(symbol_85);  // Real
			symbol_449.setLower(BigInteger.valueOf(0));
			symbol_449.setIsUnique(false);
			
			symbol_448.getOwnedParameters().add(symbol_449);
			symbol_448.setPrecedence(symbol_4);
			symbol_448.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_448);
		}
		{	// ocl::Real::<() Real|<(Real)
			Operation symbol_450 = PivotFactory.eINSTANCE.createOperation();
			symbol_450.setName("<");
			symbol_450.setType(symbol_19);  // Boolean
			symbol_450.setLower(BigInteger.valueOf(0));
			symbol_450.setIsUnique(false);
			
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("r");
			symbol_451.setType(symbol_85);  // Real
			symbol_451.setLower(BigInteger.valueOf(0));
			symbol_451.setIsUnique(false);
			
			symbol_450.getOwnedParameters().add(symbol_451);
			symbol_450.setPrecedence(symbol_6);
			symbol_450.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_450);
		}
		{	// ocl::Real::<=() Real|<=(Real)
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_452.setName("<=");
			symbol_452.setType(symbol_19);  // Boolean
			symbol_452.setLower(BigInteger.valueOf(0));
			symbol_452.setIsUnique(false);
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("r");
			symbol_453.setType(symbol_85);  // Real
			symbol_453.setLower(BigInteger.valueOf(0));
			symbol_453.setIsUnique(false);
			
			symbol_452.getOwnedParameters().add(symbol_453);
			symbol_452.setPrecedence(symbol_6);
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::Real::<>() Real|<>(ocl|OclAny)
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("<>");
			symbol_454.setType(symbol_19);  // Boolean
			symbol_454.setLower(BigInteger.valueOf(0));
			symbol_454.setIsUnique(false);
			
			Parameter symbol_455 = PivotFactory.eINSTANCE.createParameter();
			symbol_455.setName("object2");
			symbol_455.setType(symbol_59);  // ocl|OclAny
			symbol_455.setLower(BigInteger.valueOf(0));
			symbol_455.setIsUnique(false);
			
			symbol_454.getOwnedParameters().add(symbol_455);
			symbol_454.setPrecedence(symbol_7);
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::Real::=() Real|=(ocl|OclAny)
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_456.setName("=");
			symbol_456.setType(symbol_19);  // Boolean
			symbol_456.setLower(BigInteger.valueOf(0));
			symbol_456.setIsUnique(false);
			
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("object2");
			symbol_457.setType(symbol_59);  // ocl|OclAny
			symbol_457.setLower(BigInteger.valueOf(0));
			symbol_457.setIsUnique(false);
			
			symbol_456.getOwnedParameters().add(symbol_457);
			symbol_456.setPrecedence(symbol_7);
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_456);
		}
		{	// ocl::Real::>() Real|>(Real)
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName(">");
			symbol_458.setType(symbol_19);  // Boolean
			symbol_458.setLower(BigInteger.valueOf(0));
			symbol_458.setIsUnique(false);
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("r");
			symbol_459.setType(symbol_85);  // Real
			symbol_459.setLower(BigInteger.valueOf(0));
			symbol_459.setIsUnique(false);
			
			symbol_458.getOwnedParameters().add(symbol_459);
			symbol_458.setPrecedence(symbol_6);
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::Real::>=() Real|>=(Real)
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName(">=");
			symbol_460.setType(symbol_19);  // Boolean
			symbol_460.setLower(BigInteger.valueOf(0));
			symbol_460.setIsUnique(false);
			
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("r");
			symbol_461.setType(symbol_85);  // Real
			symbol_461.setLower(BigInteger.valueOf(0));
			symbol_461.setIsUnique(false);
			
			symbol_460.getOwnedParameters().add(symbol_461);
			symbol_460.setPrecedence(symbol_6);
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::Real::abs() Real|abs()
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("abs");
			symbol_462.setType(symbol_85);  // Real
			symbol_462.setLower(BigInteger.valueOf(0));
			symbol_462.setIsUnique(false);
			
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::Real::floor() Real|floor()
			Operation symbol_463 = PivotFactory.eINSTANCE.createOperation();
			symbol_463.setName("floor");
			symbol_463.setType(symbol_47);  // Integer
			symbol_463.setLower(BigInteger.valueOf(0));
			symbol_463.setIsUnique(false);
			
			symbol_463.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_463);
		}
		{	// ocl::Real::max() Real|max(Real)
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("max");
			symbol_464.setType(symbol_85);  // Real
			symbol_464.setLower(BigInteger.valueOf(0));
			symbol_464.setIsUnique(false);
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("r");
			symbol_465.setType(symbol_85);  // Real
			symbol_465.setLower(BigInteger.valueOf(0));
			symbol_465.setIsUnique(false);
			
			symbol_464.getOwnedParameters().add(symbol_465);
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::Real::min() Real|min(Real)
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_466.setName("min");
			symbol_466.setType(symbol_85);  // Real
			symbol_466.setLower(BigInteger.valueOf(0));
			symbol_466.setIsUnique(false);
			
			Parameter symbol_467 = PivotFactory.eINSTANCE.createParameter();
			symbol_467.setName("r");
			symbol_467.setType(symbol_85);  // Real
			symbol_467.setLower(BigInteger.valueOf(0));
			symbol_467.setIsUnique(false);
			
			symbol_466.getOwnedParameters().add(symbol_467);
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::Real::oclAsType() Real|oclAsType{T}(ocl|Classifier)
			Operation symbol_468 = PivotFactory.eINSTANCE.createOperation();
			symbol_88.setName("T");
			symbol_87.setOwnedParameteredElement(symbol_88);
			symbol_86.getOwnedParameters().add(symbol_87);
			
			symbol_468.setOwnedTemplateSignature(symbol_86);
			symbol_468.setName("oclAsType");
			symbol_468.setType(symbol_88);  // Real|oclAsType{T}(ocl|Classifier)?T
			symbol_468.setLower(BigInteger.valueOf(0));
			symbol_468.setIsUnique(false);
			
			Parameter symbol_469 = PivotFactory.eINSTANCE.createParameter();
			symbol_469.setName("type");
			symbol_469.setType(symbol_20);  // ocl|Classifier
			symbol_469.setLower(BigInteger.valueOf(0));
			symbol_469.setIsUnique(false);
			
			symbol_468.getOwnedParameters().add(symbol_469);
			symbol_468.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_468);
		}
		{	// ocl::Real::round() Real|round()
			Operation symbol_470 = PivotFactory.eINSTANCE.createOperation();
			symbol_470.setName("round");
			symbol_470.setType(symbol_47);  // Integer
			symbol_470.setLower(BigInteger.valueOf(0));
			symbol_470.setIsUnique(false);
			
			symbol_470.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_470);
		}
		{	// ocl::Real::toString() Real|toString()
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("toString");
			symbol_471.setType(symbol_103);  // String
			symbol_471.setLower(BigInteger.valueOf(0));
			symbol_471.setIsUnique(false);
			
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_471);
		}
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// ocl::Sequence ocl|Sequence{T}
		//
		symbol_89.setName("Sequence");
		symbol_89.setElementType(symbol_92);
		symbol_92.setName("T");
		symbol_91.setOwnedParameteredElement(symbol_92);
		symbol_90.getOwnedParameters().add(symbol_91);
		
		symbol_89.setOwnedTemplateSignature(symbol_90);
		symbol_89.getSuperClasses().add(symbol_167); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		symbol_89.getSuperClasses().add(symbol_178); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl|Sequence{T}|<>(ocl|OclAny)
			Operation symbol_472 = PivotFactory.eINSTANCE.createOperation();
			symbol_472.setName("<>");
			symbol_472.setType(symbol_19);  // Boolean
			symbol_472.setLower(BigInteger.valueOf(0));
			symbol_472.setIsUnique(false);
			
			Parameter symbol_473 = PivotFactory.eINSTANCE.createParameter();
			symbol_473.setName("object2");
			symbol_473.setType(symbol_59);  // ocl|OclAny
			symbol_473.setLower(BigInteger.valueOf(0));
			symbol_473.setIsUnique(false);
			
			symbol_472.getOwnedParameters().add(symbol_473);
			symbol_472.setPrecedence(symbol_7);
			symbol_472.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_472);
		}
		{	// ocl::Sequence::=() ocl|Sequence{T}|=(ocl|OclAny)
			Operation symbol_474 = PivotFactory.eINSTANCE.createOperation();
			symbol_474.setName("=");
			symbol_474.setType(symbol_19);  // Boolean
			symbol_474.setLower(BigInteger.valueOf(0));
			symbol_474.setIsUnique(false);
			
			Parameter symbol_475 = PivotFactory.eINSTANCE.createParameter();
			symbol_475.setName("object2");
			symbol_475.setType(symbol_59);  // ocl|OclAny
			symbol_475.setLower(BigInteger.valueOf(0));
			symbol_475.setIsUnique(false);
			
			symbol_474.getOwnedParameters().add(symbol_475);
			symbol_474.setPrecedence(symbol_7);
			symbol_474.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_474);
		}
		{	// ocl::Sequence::append() ocl|Sequence{T}|append(ocl|Sequence{T}?T)
			Operation symbol_476 = PivotFactory.eINSTANCE.createOperation();
			symbol_476.setName("append");
			symbol_476.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_476.setLower(BigInteger.valueOf(0));
			symbol_476.setIsUnique(false);
			
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("object");
			symbol_477.setType(symbol_92);  // ocl|Sequence{T}?T
			symbol_477.setLower(BigInteger.valueOf(0));
			symbol_477.setIsUnique(false);
			
			symbol_476.getOwnedParameters().add(symbol_477);
			symbol_476.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_476);
		}
		{	// ocl::Sequence::excluding() ocl|Sequence{T}|excluding(ocl|OclAny)
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("excluding");
			symbol_478.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_478.setLower(BigInteger.valueOf(0));
			symbol_478.setIsUnique(false);
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("object");
			symbol_479.setType(symbol_59);  // ocl|OclAny
			symbol_479.setLower(BigInteger.valueOf(0));
			symbol_479.setIsUnique(false);
			
			symbol_478.getOwnedParameters().add(symbol_479);
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::Sequence::flatten() ocl|Sequence{T}|flatten{T2}()
			Operation symbol_480 = PivotFactory.eINSTANCE.createOperation();
			symbol_95.setName("T2");
			symbol_94.setOwnedParameteredElement(symbol_95);
			symbol_93.getOwnedParameters().add(symbol_94);
			
			symbol_480.setOwnedTemplateSignature(symbol_93);
			symbol_480.setName("flatten");
			symbol_480.setType(symbol_190);  // ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
			symbol_480.setLower(BigInteger.valueOf(0));
			symbol_480.setIsUnique(false);
			
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::Sequence::including() ocl|Sequence{T}|including(ocl|Sequence{T}?T)
			Operation symbol_481 = PivotFactory.eINSTANCE.createOperation();
			symbol_481.setName("including");
			symbol_481.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_481.setLower(BigInteger.valueOf(0));
			symbol_481.setIsUnique(false);
			
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("object");
			symbol_482.setType(symbol_92);  // ocl|Sequence{T}?T
			symbol_482.setLower(BigInteger.valueOf(0));
			symbol_482.setIsUnique(false);
			
			symbol_481.getOwnedParameters().add(symbol_482);
			symbol_481.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_481);
		}
		{	// ocl::Sequence::insertAt() ocl|Sequence{T}|insertAt(Integer,ocl|Sequence{T}?T)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("insertAt");
			symbol_483.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_483.setLower(BigInteger.valueOf(0));
			symbol_483.setIsUnique(false);
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("index");
			symbol_484.setType(symbol_47);  // Integer
			symbol_484.setLower(BigInteger.valueOf(0));
			symbol_484.setIsUnique(false);
			
			symbol_483.getOwnedParameters().add(symbol_484);
			Parameter symbol_485 = PivotFactory.eINSTANCE.createParameter();
			symbol_485.setName("object");
			symbol_485.setType(symbol_92);  // ocl|Sequence{T}?T
			symbol_485.setLower(BigInteger.valueOf(0));
			symbol_485.setIsUnique(false);
			
			symbol_483.getOwnedParameters().add(symbol_485);
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::Sequence::prepend() ocl|Sequence{T}|prepend(ocl|Sequence{T}?T)
			Operation symbol_486 = PivotFactory.eINSTANCE.createOperation();
			symbol_486.setName("prepend");
			symbol_486.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_486.setLower(BigInteger.valueOf(0));
			symbol_486.setIsUnique(false);
			
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("object");
			symbol_487.setType(symbol_92);  // ocl|Sequence{T}?T
			symbol_487.setLower(BigInteger.valueOf(0));
			symbol_487.setIsUnique(false);
			
			symbol_486.getOwnedParameters().add(symbol_487);
			symbol_486.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_486);
		}
		{	// ocl::Sequence::reject() ocl|Sequence{T}|reject(ocl|Sequence{T}?T)
			Iteration symbol_488 = PivotFactory.eINSTANCE.createIteration();
			symbol_488.setName("reject");
			symbol_488.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			
			Parameter symbol_489 = PivotFactory.eINSTANCE.createParameter();
			symbol_489.setName("i");
			symbol_489.setType(symbol_92);  // ocl|Sequence{T}?T
			symbol_488.getOwnedIterators().add(symbol_489);
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::Sequence::reverse() ocl|Sequence{T}|reverse()
			Operation symbol_490 = PivotFactory.eINSTANCE.createOperation();
			symbol_490.setName("reverse");
			symbol_490.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_490.setLower(BigInteger.valueOf(0));
			symbol_490.setIsUnique(false);
			
			symbol_490.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_490);
		}
		{	// ocl::Sequence::select() ocl|Sequence{T}|select(ocl|Sequence{T}?T)
			Iteration symbol_491 = PivotFactory.eINSTANCE.createIteration();
			symbol_491.setName("select");
			symbol_491.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			
			Parameter symbol_492 = PivotFactory.eINSTANCE.createParameter();
			symbol_492.setName("i");
			symbol_492.setType(symbol_92);  // ocl|Sequence{T}?T
			symbol_491.getOwnedIterators().add(symbol_492);
			symbol_491.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_491);
		}
		{	// ocl::Sequence::subSequence() ocl|Sequence{T}|subSequence(Integer,Integer)
			Operation symbol_493 = PivotFactory.eINSTANCE.createOperation();
			symbol_493.setName("subSequence");
			symbol_493.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_493.setLower(BigInteger.valueOf(0));
			symbol_493.setIsUnique(false);
			
			Parameter symbol_494 = PivotFactory.eINSTANCE.createParameter();
			symbol_494.setName("lower");
			symbol_494.setType(symbol_47);  // Integer
			symbol_494.setLower(BigInteger.valueOf(0));
			symbol_494.setIsUnique(false);
			
			symbol_493.getOwnedParameters().add(symbol_494);
			Parameter symbol_495 = PivotFactory.eINSTANCE.createParameter();
			symbol_495.setName("upper");
			symbol_495.setType(symbol_47);  // Integer
			symbol_495.setLower(BigInteger.valueOf(0));
			symbol_495.setIsUnique(false);
			
			symbol_493.getOwnedParameters().add(symbol_495);
			symbol_493.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_493);
		}
		{	// ocl::Sequence::union() ocl|Sequence{T}|union(ocl|Sequence[ocl|Sequence{T}?T])
			Operation symbol_496 = PivotFactory.eINSTANCE.createOperation();
			symbol_496.setName("union");
			symbol_496.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_496.setLower(BigInteger.valueOf(0));
			symbol_496.setIsUnique(false);
			
			Parameter symbol_497 = PivotFactory.eINSTANCE.createParameter();
			symbol_497.setName("s");
			symbol_497.setType(symbol_187);  // ocl|Sequence[ocl|Sequence{T}?T]
			symbol_497.setLower(BigInteger.valueOf(0));
			symbol_497.setIsUnique(false);
			
			symbol_496.getOwnedParameters().add(symbol_497);
			symbol_496.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_496);
		}
		symbol_1.getOwnedTypes().add(symbol_89);
		//
		// ocl::Set ocl|Set{T}
		//
		symbol_96.setName("Set");
		symbol_96.setElementType(symbol_99);
		symbol_99.setName("T");
		symbol_98.setOwnedParameteredElement(symbol_99);
		symbol_97.getOwnedParameters().add(symbol_98);
		
		symbol_96.setOwnedTemplateSignature(symbol_97);
		symbol_96.getSuperClasses().add(symbol_211); // ocl|UniqueCollection[ocl|Set{T}?T]
		symbol_96.getSuperClasses().add(symbol_154); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		{	// ocl::Set::-() ocl|Set{T}|-(ocl|Set[ocl|OclAny])
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("-");
			symbol_498.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			symbol_498.setLower(BigInteger.valueOf(0));
			symbol_498.setIsUnique(false);
			
			Parameter symbol_499 = PivotFactory.eINSTANCE.createParameter();
			symbol_499.setName("s");
			symbol_499.setType(symbol_194);  // ocl|Set[ocl|OclAny]
			symbol_499.setLower(BigInteger.valueOf(0));
			symbol_499.setIsUnique(false);
			
			symbol_498.getOwnedParameters().add(symbol_499);
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::Set::<>() ocl|Set{T}|<>(ocl|OclAny)
			Operation symbol_500 = PivotFactory.eINSTANCE.createOperation();
			symbol_500.setName("<>");
			symbol_500.setType(symbol_19);  // Boolean
			symbol_500.setLower(BigInteger.valueOf(0));
			symbol_500.setIsUnique(false);
			
			Parameter symbol_501 = PivotFactory.eINSTANCE.createParameter();
			symbol_501.setName("object2");
			symbol_501.setType(symbol_59);  // ocl|OclAny
			symbol_501.setLower(BigInteger.valueOf(0));
			symbol_501.setIsUnique(false);
			
			symbol_500.getOwnedParameters().add(symbol_501);
			symbol_500.setPrecedence(symbol_7);
			symbol_500.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_500);
		}
		{	// ocl::Set::=() ocl|Set{T}|=(ocl|OclAny)
			Operation symbol_502 = PivotFactory.eINSTANCE.createOperation();
			symbol_502.setName("=");
			symbol_502.setType(symbol_19);  // Boolean
			symbol_502.setLower(BigInteger.valueOf(0));
			symbol_502.setIsUnique(false);
			
			Parameter symbol_503 = PivotFactory.eINSTANCE.createParameter();
			symbol_503.setName("object2");
			symbol_503.setType(symbol_59);  // ocl|OclAny
			symbol_503.setLower(BigInteger.valueOf(0));
			symbol_503.setIsUnique(false);
			
			symbol_502.getOwnedParameters().add(symbol_503);
			symbol_502.setPrecedence(symbol_7);
			symbol_502.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_502);
		}
		{	// ocl::Set::excluding() ocl|Set{T}|excluding(ocl|OclAny)
			Operation symbol_504 = PivotFactory.eINSTANCE.createOperation();
			symbol_504.setName("excluding");
			symbol_504.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			symbol_504.setLower(BigInteger.valueOf(0));
			symbol_504.setIsUnique(false);
			
			Parameter symbol_505 = PivotFactory.eINSTANCE.createParameter();
			symbol_505.setName("object");
			symbol_505.setType(symbol_59);  // ocl|OclAny
			symbol_505.setLower(BigInteger.valueOf(0));
			symbol_505.setIsUnique(false);
			
			symbol_504.getOwnedParameters().add(symbol_505);
			symbol_504.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_504);
		}
		{	// ocl::Set::flatten() ocl|Set{T}|flatten{T2}()
			Operation symbol_506 = PivotFactory.eINSTANCE.createOperation();
			symbol_102.setName("T2");
			symbol_101.setOwnedParameteredElement(symbol_102);
			symbol_100.getOwnedParameters().add(symbol_101);
			
			symbol_506.setOwnedTemplateSignature(symbol_100);
			symbol_506.setName("flatten");
			symbol_506.setType(symbol_199);  // ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
			symbol_506.setLower(BigInteger.valueOf(0));
			symbol_506.setIsUnique(false);
			
			symbol_506.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_506);
		}
		{	// ocl::Set::including() ocl|Set{T}|including(ocl|Set{T}?T)
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("including");
			symbol_507.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			symbol_507.setLower(BigInteger.valueOf(0));
			symbol_507.setIsUnique(false);
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("object");
			symbol_508.setType(symbol_99);  // ocl|Set{T}?T
			symbol_508.setLower(BigInteger.valueOf(0));
			symbol_508.setIsUnique(false);
			
			symbol_507.getOwnedParameters().add(symbol_508);
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::Set::intersection() ocl|Set{T}|intersection(ocl|Set[ocl|Set{T}?T])
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_509.setName("intersection");
			symbol_509.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			symbol_509.setLower(BigInteger.valueOf(0));
			symbol_509.setIsUnique(false);
			
			Parameter symbol_510 = PivotFactory.eINSTANCE.createParameter();
			symbol_510.setName("s");
			symbol_510.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			symbol_510.setLower(BigInteger.valueOf(0));
			symbol_510.setIsUnique(false);
			
			symbol_509.getOwnedParameters().add(symbol_510);
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::Set::reject() ocl|Set{T}|reject(ocl|Set{T}?T)
			Iteration symbol_511 = PivotFactory.eINSTANCE.createIteration();
			symbol_511.setName("reject");
			symbol_511.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			
			Parameter symbol_512 = PivotFactory.eINSTANCE.createParameter();
			symbol_512.setName("i");
			symbol_512.setType(symbol_99);  // ocl|Set{T}?T
			symbol_511.getOwnedIterators().add(symbol_512);
			symbol_511.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_511);
		}
		{	// ocl::Set::select() ocl|Set{T}|select(ocl|Set{T}?T)
			Iteration symbol_513 = PivotFactory.eINSTANCE.createIteration();
			symbol_513.setName("select");
			symbol_513.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			
			Parameter symbol_514 = PivotFactory.eINSTANCE.createParameter();
			symbol_514.setName("i");
			symbol_514.setType(symbol_99);  // ocl|Set{T}?T
			symbol_513.getOwnedIterators().add(symbol_514);
			symbol_513.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_513);
		}
		{	// ocl::Set::symmetricDifference() ocl|Set{T}|symmetricDifference(ocl|Set[ocl|OclAny])
			Operation symbol_515 = PivotFactory.eINSTANCE.createOperation();
			symbol_515.setName("symmetricDifference");
			symbol_515.setType(symbol_201);  // ocl|Set[ocl|Set{T}?T]
			symbol_515.setLower(BigInteger.valueOf(0));
			symbol_515.setIsUnique(false);
			
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("s");
			symbol_516.setType(symbol_194);  // ocl|Set[ocl|OclAny]
			symbol_516.setLower(BigInteger.valueOf(0));
			symbol_516.setIsUnique(false);
			
			symbol_515.getOwnedParameters().add(symbol_516);
			symbol_515.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_515);
		}
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// ocl::String String
		//
		symbol_103.setName("String");
		symbol_103.getSuperClasses().add(symbol_59); // ocl|OclAny
		{	// ocl::String::+() String|+(String)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("+");
			symbol_517.setType(symbol_103);  // String
			symbol_517.setLower(BigInteger.valueOf(0));
			symbol_517.setIsUnique(false);
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("s");
			symbol_518.setType(symbol_103);  // String
			symbol_518.setLower(BigInteger.valueOf(0));
			symbol_518.setIsUnique(false);
			
			symbol_517.getOwnedParameters().add(symbol_518);
			symbol_517.setPrecedence(symbol_5);
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::String::<() String|<(String)
			Operation symbol_519 = PivotFactory.eINSTANCE.createOperation();
			symbol_519.setName("<");
			symbol_519.setType(symbol_19);  // Boolean
			symbol_519.setLower(BigInteger.valueOf(0));
			symbol_519.setIsUnique(false);
			
			Parameter symbol_520 = PivotFactory.eINSTANCE.createParameter();
			symbol_520.setName("s");
			symbol_520.setType(symbol_103);  // String
			symbol_520.setLower(BigInteger.valueOf(0));
			symbol_520.setIsUnique(false);
			
			symbol_519.getOwnedParameters().add(symbol_520);
			symbol_519.setPrecedence(symbol_6);
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::String::<=() String|<=(String)
			Operation symbol_521 = PivotFactory.eINSTANCE.createOperation();
			symbol_521.setName("<=");
			symbol_521.setType(symbol_19);  // Boolean
			symbol_521.setLower(BigInteger.valueOf(0));
			symbol_521.setIsUnique(false);
			
			Parameter symbol_522 = PivotFactory.eINSTANCE.createParameter();
			symbol_522.setName("s");
			symbol_522.setType(symbol_103);  // String
			symbol_522.setLower(BigInteger.valueOf(0));
			symbol_522.setIsUnique(false);
			
			symbol_521.getOwnedParameters().add(symbol_522);
			symbol_521.setPrecedence(symbol_6);
			symbol_521.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_521);
		}
		{	// ocl::String::<>() String|<>(ocl|OclAny)
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("<>");
			symbol_523.setType(symbol_19);  // Boolean
			symbol_523.setLower(BigInteger.valueOf(0));
			symbol_523.setIsUnique(false);
			
			Parameter symbol_524 = PivotFactory.eINSTANCE.createParameter();
			symbol_524.setName("object2");
			symbol_524.setType(symbol_59);  // ocl|OclAny
			symbol_524.setLower(BigInteger.valueOf(0));
			symbol_524.setIsUnique(false);
			
			symbol_523.getOwnedParameters().add(symbol_524);
			symbol_523.setPrecedence(symbol_7);
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::String::=() String|=(ocl|OclAny)
			Operation symbol_525 = PivotFactory.eINSTANCE.createOperation();
			symbol_525.setName("=");
			symbol_525.setType(symbol_19);  // Boolean
			symbol_525.setLower(BigInteger.valueOf(0));
			symbol_525.setIsUnique(false);
			
			Parameter symbol_526 = PivotFactory.eINSTANCE.createParameter();
			symbol_526.setName("object2");
			symbol_526.setType(symbol_59);  // ocl|OclAny
			symbol_526.setLower(BigInteger.valueOf(0));
			symbol_526.setIsUnique(false);
			
			symbol_525.getOwnedParameters().add(symbol_526);
			symbol_525.setPrecedence(symbol_7);
			symbol_525.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_525);
		}
		{	// ocl::String::>() String|>(String)
			Operation symbol_527 = PivotFactory.eINSTANCE.createOperation();
			symbol_527.setName(">");
			symbol_527.setType(symbol_19);  // Boolean
			symbol_527.setLower(BigInteger.valueOf(0));
			symbol_527.setIsUnique(false);
			
			Parameter symbol_528 = PivotFactory.eINSTANCE.createParameter();
			symbol_528.setName("s");
			symbol_528.setType(symbol_103);  // String
			symbol_528.setLower(BigInteger.valueOf(0));
			symbol_528.setIsUnique(false);
			
			symbol_527.getOwnedParameters().add(symbol_528);
			symbol_527.setPrecedence(symbol_6);
			symbol_527.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_527);
		}
		{	// ocl::String::>=() String|>=(String)
			Operation symbol_529 = PivotFactory.eINSTANCE.createOperation();
			symbol_529.setName(">=");
			symbol_529.setType(symbol_19);  // Boolean
			symbol_529.setLower(BigInteger.valueOf(0));
			symbol_529.setIsUnique(false);
			
			Parameter symbol_530 = PivotFactory.eINSTANCE.createParameter();
			symbol_530.setName("s");
			symbol_530.setType(symbol_103);  // String
			symbol_530.setLower(BigInteger.valueOf(0));
			symbol_530.setIsUnique(false);
			
			symbol_529.getOwnedParameters().add(symbol_530);
			symbol_529.setPrecedence(symbol_6);
			symbol_529.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_529);
		}
		{	// ocl::String::at() String|at(Integer)
			Operation symbol_531 = PivotFactory.eINSTANCE.createOperation();
			symbol_531.setName("at");
			symbol_531.setType(symbol_103);  // String
			symbol_531.setLower(BigInteger.valueOf(0));
			symbol_531.setIsUnique(false);
			
			Parameter symbol_532 = PivotFactory.eINSTANCE.createParameter();
			symbol_532.setName("i");
			symbol_532.setType(symbol_47);  // Integer
			symbol_532.setLower(BigInteger.valueOf(0));
			symbol_532.setIsUnique(false);
			
			symbol_531.getOwnedParameters().add(symbol_532);
			symbol_531.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_531);
		}
		{	// ocl::String::characters() String|characters()
			Operation symbol_533 = PivotFactory.eINSTANCE.createOperation();
			symbol_533.setName("characters");
			symbol_533.setType(symbol_186);  // ocl|Sequence[String]
			symbol_533.setLower(BigInteger.valueOf(0));
			symbol_533.setIsUnique(false);
			
			symbol_533.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_533);
		}
		{	// ocl::String::concat() String|concat(String)
			Operation symbol_534 = PivotFactory.eINSTANCE.createOperation();
			symbol_534.setName("concat");
			symbol_534.setType(symbol_103);  // String
			symbol_534.setLower(BigInteger.valueOf(0));
			symbol_534.setIsUnique(false);
			
			Parameter symbol_535 = PivotFactory.eINSTANCE.createParameter();
			symbol_535.setName("s");
			symbol_535.setType(symbol_103);  // String
			symbol_535.setLower(BigInteger.valueOf(0));
			symbol_535.setIsUnique(false);
			
			symbol_534.getOwnedParameters().add(symbol_535);
			symbol_534.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_534);
		}
		{	// ocl::String::equalsIgnoreCase() String|equalsIgnoreCase(String)
			Operation symbol_536 = PivotFactory.eINSTANCE.createOperation();
			symbol_536.setName("equalsIgnoreCase");
			symbol_536.setType(symbol_19);  // Boolean
			symbol_536.setLower(BigInteger.valueOf(0));
			symbol_536.setIsUnique(false);
			
			Parameter symbol_537 = PivotFactory.eINSTANCE.createParameter();
			symbol_537.setName("s");
			symbol_537.setType(symbol_103);  // String
			symbol_537.setLower(BigInteger.valueOf(0));
			symbol_537.setIsUnique(false);
			
			symbol_536.getOwnedParameters().add(symbol_537);
			symbol_536.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_536);
		}
		{	// ocl::String::indexOf() String|indexOf(String)
			Operation symbol_538 = PivotFactory.eINSTANCE.createOperation();
			symbol_538.setName("indexOf");
			symbol_538.setType(symbol_47);  // Integer
			symbol_538.setLower(BigInteger.valueOf(0));
			symbol_538.setIsUnique(false);
			
			Parameter symbol_539 = PivotFactory.eINSTANCE.createParameter();
			symbol_539.setName("s");
			symbol_539.setType(symbol_103);  // String
			symbol_539.setLower(BigInteger.valueOf(0));
			symbol_539.setIsUnique(false);
			
			symbol_538.getOwnedParameters().add(symbol_539);
			symbol_538.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_538);
		}
		{	// ocl::String::size() String|size()
			Operation symbol_540 = PivotFactory.eINSTANCE.createOperation();
			symbol_540.setName("size");
			symbol_540.setType(symbol_47);  // Integer
			symbol_540.setLower(BigInteger.valueOf(0));
			symbol_540.setIsUnique(false);
			
			symbol_540.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_540);
		}
		{	// ocl::String::substring() String|substring(Integer,Integer)
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("substring");
			symbol_541.setType(symbol_103);  // String
			symbol_541.setLower(BigInteger.valueOf(0));
			symbol_541.setIsUnique(false);
			
			Parameter symbol_542 = PivotFactory.eINSTANCE.createParameter();
			symbol_542.setName("lower");
			symbol_542.setType(symbol_47);  // Integer
			symbol_542.setLower(BigInteger.valueOf(0));
			symbol_542.setIsUnique(false);
			
			symbol_541.getOwnedParameters().add(symbol_542);
			Parameter symbol_543 = PivotFactory.eINSTANCE.createParameter();
			symbol_543.setName("upper");
			symbol_543.setType(symbol_47);  // Integer
			symbol_543.setLower(BigInteger.valueOf(0));
			symbol_543.setIsUnique(false);
			
			symbol_541.getOwnedParameters().add(symbol_543);
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::String::toBoolean() String|toBoolean()
			Operation symbol_544 = PivotFactory.eINSTANCE.createOperation();
			symbol_544.setName("toBoolean");
			symbol_544.setType(symbol_19);  // Boolean
			symbol_544.setLower(BigInteger.valueOf(0));
			symbol_544.setIsUnique(false);
			
			symbol_544.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_544);
		}
		{	// ocl::String::toInteger() String|toInteger()
			Operation symbol_545 = PivotFactory.eINSTANCE.createOperation();
			symbol_545.setName("toInteger");
			symbol_545.setType(symbol_47);  // Integer
			symbol_545.setLower(BigInteger.valueOf(0));
			symbol_545.setIsUnique(false);
			
			symbol_545.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_545);
		}
		{	// ocl::String::toLowerCase() String|toLowerCase()
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("toLowerCase");
			symbol_546.setType(symbol_103);  // String
			symbol_546.setLower(BigInteger.valueOf(0));
			symbol_546.setIsUnique(false);
			
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_546);
		}
		{	// ocl::String::toReal() String|toReal()
			Operation symbol_547 = PivotFactory.eINSTANCE.createOperation();
			symbol_547.setName("toReal");
			symbol_547.setType(symbol_85);  // Real
			symbol_547.setLower(BigInteger.valueOf(0));
			symbol_547.setIsUnique(false);
			
			symbol_547.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_547);
		}
		{	// ocl::String::toString() String|toString()
			Operation symbol_548 = PivotFactory.eINSTANCE.createOperation();
			symbol_548.setName("toString");
			symbol_548.setType(symbol_103);  // String
			symbol_548.setLower(BigInteger.valueOf(0));
			symbol_548.setIsUnique(false);
			
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::String::toUpperCase() String|toUpperCase()
			Operation symbol_549 = PivotFactory.eINSTANCE.createOperation();
			symbol_549.setName("toUpperCase");
			symbol_549.setType(symbol_103);  // String
			symbol_549.setLower(BigInteger.valueOf(0));
			symbol_549.setIsUnique(false);
			
			symbol_549.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_549);
		}
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// ocl::UniqueCollection ocl|UniqueCollection{T}
		//
		symbol_104.setName("UniqueCollection");
		symbol_104.setElementType(symbol_107);
		symbol_107.setName("T");
		symbol_106.setOwnedParameteredElement(symbol_107);
		symbol_105.getOwnedParameters().add(symbol_106);
		
		symbol_104.setOwnedTemplateSignature(symbol_105);
		symbol_104.getSuperClasses().add(symbol_138); // ocl|Collection[ocl|UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl|UniqueCollection{T}|sortedBy(ocl|UniqueCollection{T}?T)
			Iteration symbol_550 = PivotFactory.eINSTANCE.createIteration();
			symbol_550.setName("sortedBy");
			symbol_550.setType(symbol_182);  // ocl|OrderedSet[ocl|UniqueCollection{T}?T]
			
			Parameter symbol_551 = PivotFactory.eINSTANCE.createParameter();
			symbol_551.setName("i");
			symbol_551.setType(symbol_107);  // ocl|UniqueCollection{T}?T
			symbol_550.getOwnedIterators().add(symbol_551);
			symbol_550.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_550);
		}
		symbol_1.getOwnedTypes().add(symbol_104);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_108.setName("UnlimitedNatural");
		symbol_108.getSuperClasses().add(symbol_47); // Integer
		symbol_1.getOwnedTypes().add(symbol_108);
		//
		// ocl::orphanage
		//
		symbol_109.setName("orphanage");
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_110.setName("Bag");
		symbol_110.setElementType(symbol_18);
		{
			TemplateBinding symbol_552 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_552.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_553 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_553.setFormal(symbol_14);	
				symbol_553.setActual(symbol_18);	
				symbol_552.getParameterSubstitutions().add(symbol_553);
			}
			symbol_110.getTemplateBindings().add(symbol_552);
		}
		symbol_110.getSuperClasses().add(symbol_163); // ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_110.getSuperClasses().add(symbol_150); // ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_110);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_111.setName("Bag");
		symbol_111.setElementType(symbol_54);
		{
			TemplateBinding symbol_554 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_554.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_555 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_555.setFormal(symbol_14);	
				symbol_555.setActual(symbol_54);	
				symbol_554.getParameterSubstitutions().add(symbol_555);
			}
			symbol_111.getTemplateBindings().add(symbol_554);
		}
		symbol_111.getSuperClasses().add(symbol_149); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_111.getSuperClasses().add(symbol_169); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_109.getOwnedTypes().add(symbol_111);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|NonOrderedCollection{T}?T]
		//
		symbol_112.setName("Bag");
		symbol_112.setElementType(symbol_51);
		{
			TemplateBinding symbol_556 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_556.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_557 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_557.setFormal(symbol_14);	
				symbol_557.setActual(symbol_51);	
				symbol_556.getParameterSubstitutions().add(symbol_557);
			}
			symbol_112.getTemplateBindings().add(symbol_556);
		}
		symbol_112.getSuperClasses().add(symbol_168); // ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		symbol_112.getSuperClasses().add(symbol_151); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_112);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Collection{T}?T]
		//
		symbol_113.setName("Bag");
		symbol_113.setElementType(symbol_27);
		{
			TemplateBinding symbol_558 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_558.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_559 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_559.setFormal(symbol_14);	
				symbol_559.setActual(symbol_27);	
				symbol_558.getParameterSubstitutions().add(symbol_559);
			}
			symbol_113.getTemplateBindings().add(symbol_558);
		}
		symbol_113.getSuperClasses().add(symbol_171); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		symbol_113.getSuperClasses().add(symbol_161); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_113);
		//
		// ocl::orphanage::Bag ocl|Bag[ocl|Bag{T}?T]
		//
		symbol_114.setName("Bag");
		symbol_114.setElementType(symbol_15);
		{
			TemplateBinding symbol_560 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_560.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_561 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_561.setFormal(symbol_14);	
				symbol_561.setActual(symbol_15);	
				symbol_560.getParameterSubstitutions().add(symbol_561);
			}
			symbol_114.getTemplateBindings().add(symbol_560);
		}
		symbol_114.getSuperClasses().add(symbol_164); // ocl|NonUniqueCollection[ocl|Bag{T}?T]
		symbol_114.getSuperClasses().add(symbol_155); // ocl|NonOrderedCollection[ocl|Bag{T}?T]
		symbol_109.getOwnedTypes().add(symbol_114);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_115.setName("Collection");
		symbol_115.setElementType(symbol_95);
		{
			TemplateBinding symbol_562 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_562.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_563 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_563.setFormal(symbol_26);	
				symbol_563.setActual(symbol_95);	
				symbol_562.getParameterSubstitutions().add(symbol_563);
			}
			symbol_115.getTemplateBindings().add(symbol_562);
		}
		symbol_115.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_115);
		//
		// ocl::orphanage::Collection ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_116.setName("Collection");
		symbol_116.setElementType(symbol_206);
		{
			TemplateBinding symbol_564 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_564.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_565 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_565.setFormal(symbol_26);	
				symbol_565.setActual(symbol_206);	
				symbol_564.getParameterSubstitutions().add(symbol_565);
			}
			symbol_116.getTemplateBindings().add(symbol_564);
		}
		symbol_116.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_116);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|includesAll{T2}(ocl|Collection[T2])?T2]
		//
		symbol_117.setName("Collection");
		symbol_117.setElementType(symbol_39);
		{
			TemplateBinding symbol_566 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_566.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_567 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_567.setFormal(symbol_26);	
				symbol_567.setActual(symbol_39);	
				symbol_566.getParameterSubstitutions().add(symbol_567);
			}
			symbol_117.getTemplateBindings().add(symbol_566);
		}
		symbol_117.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_117);
		//
		// ocl::orphanage::Collection ocl|Collection[Boolean]
		//
		symbol_118.setName("Collection");
		symbol_118.setElementType(symbol_19);
		{
			TemplateBinding symbol_568 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_568.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_569 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_569.setFormal(symbol_26);	
				symbol_569.setActual(symbol_19);	
				symbol_568.getParameterSubstitutions().add(symbol_569);
			}
			symbol_118.getTemplateBindings().add(symbol_568);
		}
		symbol_118.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_118);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2]
		//
		symbol_119.setName("Collection");
		symbol_119.setElementType(symbol_45);
		{
			TemplateBinding symbol_570 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_570.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_571 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_571.setFormal(symbol_26);	
				symbol_571.setActual(symbol_45);	
				symbol_570.getParameterSubstitutions().add(symbol_571);
			}
			symbol_119.getTemplateBindings().add(symbol_570);
		}
		symbol_119.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_119);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedSet{T}?T]
		//
		symbol_120.setName("Collection");
		symbol_120.setElementType(symbol_84);
		{
			TemplateBinding symbol_572 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_572.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_573 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_573.setFormal(symbol_26);	
				symbol_573.setActual(symbol_84);	
				symbol_572.getParameterSubstitutions().add(symbol_573);
			}
			symbol_120.getTemplateBindings().add(symbol_572);
		}
		symbol_120.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_120);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclAny]
		//
		symbol_121.setName("Collection");
		symbol_121.setElementType(symbol_59);
		{
			TemplateBinding symbol_574 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_574.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_575 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_575.setFormal(symbol_26);	
				symbol_575.setActual(symbol_59);	
				symbol_574.getParameterSubstitutions().add(symbol_575);
			}
			symbol_121.getTemplateBindings().add(symbol_574);
		}
		symbol_121.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_121);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Enumeration]
		//
		symbol_122.setName("Collection");
		symbol_122.setElementType(symbol_46);
		{
			TemplateBinding symbol_576 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_576.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_577 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_577.setFormal(symbol_26);	
				symbol_577.setActual(symbol_46);	
				symbol_576.getParameterSubstitutions().add(symbol_577);
			}
			symbol_122.getTemplateBindings().add(symbol_576);
		}
		symbol_122.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_122);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_123.setName("Collection");
		symbol_123.setElementType(symbol_80);
		{
			TemplateBinding symbol_578 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_578.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_579 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_579.setFormal(symbol_26);	
				symbol_579.setActual(symbol_80);	
				symbol_578.getParameterSubstitutions().add(symbol_579);
			}
			symbol_123.getTemplateBindings().add(symbol_578);
		}
		symbol_123.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_123);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|excludesAll{T2}(ocl|Collection[T2])?T2]
		//
		symbol_124.setName("Collection");
		symbol_124.setElementType(symbol_33);
		{
			TemplateBinding symbol_580 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_580.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_581 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_581.setFormal(symbol_26);	
				symbol_581.setActual(symbol_33);	
				symbol_580.getParameterSubstitutions().add(symbol_581);
			}
			symbol_124.getTemplateBindings().add(symbol_580);
		}
		symbol_124.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_124);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_125.setName("Collection");
		symbol_125.setElementType(symbol_102);
		{
			TemplateBinding symbol_582 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_582.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_583 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_583.setFormal(symbol_26);	
				symbol_583.setActual(symbol_102);	
				symbol_582.getParameterSubstitutions().add(symbol_583);
			}
			symbol_125.getTemplateBindings().add(symbol_582);
		}
		symbol_125.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_125);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OrderedCollection{T}?T]
		//
		symbol_126.setName("Collection");
		symbol_126.setElementType(symbol_77);
		{
			TemplateBinding symbol_584 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_584.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_585 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_585.setFormal(symbol_26);	
				symbol_585.setActual(symbol_77);	
				symbol_584.getParameterSubstitutions().add(symbol_585);
			}
			symbol_126.getTemplateBindings().add(symbol_584);
		}
		symbol_126.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_126);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_127.setName("Collection");
		symbol_127.setElementType(symbol_18);
		{
			TemplateBinding symbol_586 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_586.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_587 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_587.setFormal(symbol_26);	
				symbol_587.setActual(symbol_18);	
				symbol_586.getParameterSubstitutions().add(symbol_587);
			}
			symbol_127.getTemplateBindings().add(symbol_586);
		}
		symbol_127.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_127);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Sequence{T}?T]
		//
		symbol_128.setName("Collection");
		symbol_128.setElementType(symbol_92);
		{
			TemplateBinding symbol_588 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_588.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_589 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_589.setFormal(symbol_26);	
				symbol_589.setActual(symbol_92);	
				symbol_588.getParameterSubstitutions().add(symbol_589);
			}
			symbol_128.getTemplateBindings().add(symbol_588);
		}
		symbol_128.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_128);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_129.setName("Collection");
		symbol_129.setElementType(symbol_58);
		{
			TemplateBinding symbol_590 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_590.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_591 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_591.setFormal(symbol_26);	
				symbol_591.setActual(symbol_58);	
				symbol_590.getParameterSubstitutions().add(symbol_591);
			}
			symbol_129.getTemplateBindings().add(symbol_590);
		}
		symbol_129.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_129);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclVoid]
		//
		symbol_130.setName("Collection");
		symbol_130.setElementType(symbol_73);
		{
			TemplateBinding symbol_592 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_592.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_593 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_593.setFormal(symbol_26);	
				symbol_593.setActual(symbol_73);	
				symbol_592.getParameterSubstitutions().add(symbol_593);
			}
			symbol_130.getTemplateBindings().add(symbol_592);
		}
		symbol_130.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_130);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Bag{T}?T]
		//
		symbol_131.setName("Collection");
		symbol_131.setElementType(symbol_15);
		{
			TemplateBinding symbol_594 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_594.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_595 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_595.setFormal(symbol_26);	
				symbol_595.setActual(symbol_15);	
				symbol_594.getParameterSubstitutions().add(symbol_595);
			}
			symbol_131.getTemplateBindings().add(symbol_594);
		}
		symbol_131.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_131);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|collect{V}(ocl|Collection{T}?T|Lambda~T()V)?V]
		//
		symbol_132.setName("Collection");
		symbol_132.setElementType(symbol_30);
		{
			TemplateBinding symbol_596 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_596.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_597 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_597.setFormal(symbol_26);	
				symbol_597.setActual(symbol_30);	
				symbol_596.getParameterSubstitutions().add(symbol_597);
			}
			symbol_132.getTemplateBindings().add(symbol_596);
		}
		symbol_132.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_132);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}?T]
		//
		symbol_133.setName("Collection");
		symbol_133.setElementType(symbol_27);
		{
			TemplateBinding symbol_598 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_598.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_599 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_599.setFormal(symbol_26);	
				symbol_599.setActual(symbol_27);	
				symbol_598.getParameterSubstitutions().add(symbol_599);
			}
			symbol_133.getTemplateBindings().add(symbol_598);
		}
		symbol_133.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_133);
		//
		// ocl::orphanage::Collection ocl|Collection[String]
		//
		symbol_134.setName("Collection");
		symbol_134.setElementType(symbol_103);
		{
			TemplateBinding symbol_600 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_600.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_601 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_601.setFormal(symbol_26);	
				symbol_601.setActual(symbol_103);	
				symbol_600.getParameterSubstitutions().add(symbol_601);
			}
			symbol_134.getTemplateBindings().add(symbol_600);
		}
		symbol_134.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_134);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_135.setName("Collection");
		symbol_135.setElementType(symbol_54);
		{
			TemplateBinding symbol_602 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_602.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_603 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_603.setFormal(symbol_26);	
				symbol_603.setActual(symbol_54);	
				symbol_602.getParameterSubstitutions().add(symbol_603);
			}
			symbol_135.getTemplateBindings().add(symbol_602);
		}
		symbol_135.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_135);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_136.setName("Collection");
		symbol_136.setElementType(symbol_51);
		{
			TemplateBinding symbol_604 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_604.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_605 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_605.setFormal(symbol_26);	
				symbol_605.setActual(symbol_51);	
				symbol_604.getParameterSubstitutions().add(symbol_605);
			}
			symbol_136.getTemplateBindings().add(symbol_604);
		}
		symbol_136.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_136);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_137.setName("Collection");
		symbol_137.setElementType(symbol_62);
		{
			TemplateBinding symbol_606 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_606.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_607 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_607.setFormal(symbol_26);	
				symbol_607.setActual(symbol_62);	
				symbol_606.getParameterSubstitutions().add(symbol_607);
			}
			symbol_137.getTemplateBindings().add(symbol_606);
		}
		symbol_137.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_137);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|UniqueCollection{T}?T]
		//
		symbol_138.setName("Collection");
		symbol_138.setElementType(symbol_107);
		{
			TemplateBinding symbol_608 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_608.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_609 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_609.setFormal(symbol_26);	
				symbol_609.setActual(symbol_107);	
				symbol_608.getParameterSubstitutions().add(symbol_609);
			}
			symbol_138.getTemplateBindings().add(symbol_608);
		}
		symbol_138.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_138);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Set{T}?T]
		//
		symbol_139.setName("Collection");
		symbol_139.setElementType(symbol_99);
		{
			TemplateBinding symbol_610 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_610.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_611 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_611.setFormal(symbol_26);	
				symbol_611.setActual(symbol_99);	
				symbol_610.getParameterSubstitutions().add(symbol_611);
			}
			symbol_139.getTemplateBindings().add(symbol_610);
		}
		symbol_139.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_139);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|OclInvalid]
		//
		symbol_140.setName("Collection");
		symbol_140.setElementType(symbol_69);
		{
			TemplateBinding symbol_612 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_612.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_613 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_613.setFormal(symbol_26);	
				symbol_613.setActual(symbol_69);	
				symbol_612.getParameterSubstitutions().add(symbol_613);
			}
			symbol_140.getTemplateBindings().add(symbol_612);
		}
		symbol_140.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_140);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_141.setName("Collection");
		symbol_141.setElementType(symbol_23);
		{
			TemplateBinding symbol_614 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_614.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_615 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_615.setFormal(symbol_26);	
				symbol_615.setActual(symbol_23);	
				symbol_614.getParameterSubstitutions().add(symbol_615);
			}
			symbol_141.getTemplateBindings().add(symbol_614);
		}
		symbol_141.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_141);
		//
		// ocl::orphanage::Collection ocl|Collection[ocl|Collection{T}|flatten{T2}()?T2]
		//
		symbol_142.setName("Collection");
		symbol_142.setElementType(symbol_36);
		{
			TemplateBinding symbol_616 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_616.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_617 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_617.setFormal(symbol_26);	
				symbol_617.setActual(symbol_36);	
				symbol_616.getParameterSubstitutions().add(symbol_617);
			}
			symbol_142.getTemplateBindings().add(symbol_616);
		}
		symbol_142.getSuperClasses().add(symbol_59); // ocl|OclAny
		symbol_109.getOwnedTypes().add(symbol_142);
		//
		// ocl::orphanage::Lambda Lambda~ocl|Collection{T}?T()ocl|Collection{T}|collect{V}(T|Lambda~T()V)?V
		//
		symbol_143.setName("Lambda");
		symbol_143.setContextType(symbol_27);
		symbol_143.setResultType(symbol_30);
		symbol_109.getOwnedTypes().add(symbol_143);
		//
		// ocl::orphanage::Lambda Lambda~ocl|NonOrderedCollection{T}?T()ocl|NonOrderedCollection{T}|collect{V}(T|Lambda~T()V)?V
		//
		symbol_144.setName("Lambda");
		symbol_144.setContextType(symbol_51);
		symbol_144.setResultType(symbol_54);
		symbol_109.getOwnedTypes().add(symbol_144);
		//
		// ocl::orphanage::Lambda Lambda~ocl|OrderedCollection{T}?T()ocl|OrderedCollection{T}|collect{V}(T|Lambda~T()V)?V
		//
		symbol_145.setName("Lambda");
		symbol_145.setContextType(symbol_77);
		symbol_145.setResultType(symbol_80);
		symbol_109.getOwnedTypes().add(symbol_145);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Enumeration]
		//
		symbol_146.setName("NonOrderedCollection");
		symbol_146.setElementType(symbol_46);
		{
			TemplateBinding symbol_618 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_618.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_619 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_619.setFormal(symbol_50);	
				symbol_619.setActual(symbol_46);	
				symbol_618.getParameterSubstitutions().add(symbol_619);
			}
			symbol_146.getTemplateBindings().add(symbol_618);
		}
		symbol_146.getSuperClasses().add(symbol_122); // ocl|Collection[ocl|Enumeration]
		symbol_109.getOwnedTypes().add(symbol_146);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_147.setName("NonOrderedCollection");
		symbol_147.setElementType(symbol_23);
		{
			TemplateBinding symbol_620 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_620.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_621 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_621.setFormal(symbol_50);	
				symbol_621.setActual(symbol_23);	
				symbol_620.getParameterSubstitutions().add(symbol_621);
			}
			symbol_147.getTemplateBindings().add(symbol_620);
		}
		symbol_147.getSuperClasses().add(symbol_141); // ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_109.getOwnedTypes().add(symbol_147);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclInvalid]
		//
		symbol_148.setName("NonOrderedCollection");
		symbol_148.setElementType(symbol_69);
		{
			TemplateBinding symbol_622 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_622.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_623 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_623.setFormal(symbol_50);	
				symbol_623.setActual(symbol_69);	
				symbol_622.getParameterSubstitutions().add(symbol_623);
			}
			symbol_148.getTemplateBindings().add(symbol_622);
		}
		symbol_148.getSuperClasses().add(symbol_140); // ocl|Collection[ocl|OclInvalid]
		symbol_109.getOwnedTypes().add(symbol_148);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_149.setName("NonOrderedCollection");
		symbol_149.setElementType(symbol_54);
		{
			TemplateBinding symbol_624 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_624.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_625 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_625.setFormal(symbol_50);	
				symbol_625.setActual(symbol_54);	
				symbol_624.getParameterSubstitutions().add(symbol_625);
			}
			symbol_149.getTemplateBindings().add(symbol_624);
		}
		symbol_149.getSuperClasses().add(symbol_135); // ocl|Collection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_109.getOwnedTypes().add(symbol_149);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_150.setName("NonOrderedCollection");
		symbol_150.setElementType(symbol_18);
		{
			TemplateBinding symbol_626 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_626.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_627 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_627.setFormal(symbol_50);	
				symbol_627.setActual(symbol_18);	
				symbol_626.getParameterSubstitutions().add(symbol_627);
			}
			symbol_150.getTemplateBindings().add(symbol_626);
		}
		symbol_150.getSuperClasses().add(symbol_127); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_150);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_151.setName("NonOrderedCollection");
		symbol_151.setElementType(symbol_51);
		{
			TemplateBinding symbol_628 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_628.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_629 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_629.setFormal(symbol_50);	
				symbol_629.setActual(symbol_51);	
				symbol_628.getParameterSubstitutions().add(symbol_629);
			}
			symbol_151.getTemplateBindings().add(symbol_628);
		}
		symbol_151.getSuperClasses().add(symbol_136); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_151);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclVoid]
		//
		symbol_152.setName("NonOrderedCollection");
		symbol_152.setElementType(symbol_73);
		{
			TemplateBinding symbol_630 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_630.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_631 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_631.setFormal(symbol_50);	
				symbol_631.setActual(symbol_73);	
				symbol_630.getParameterSubstitutions().add(symbol_631);
			}
			symbol_152.getTemplateBindings().add(symbol_630);
		}
		symbol_152.getSuperClasses().add(symbol_130); // ocl|Collection[ocl|OclVoid]
		symbol_109.getOwnedTypes().add(symbol_152);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_153.setName("NonOrderedCollection");
		symbol_153.setElementType(symbol_62);
		{
			TemplateBinding symbol_632 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_632.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_633 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_633.setFormal(symbol_50);	
				symbol_633.setActual(symbol_62);	
				symbol_632.getParameterSubstitutions().add(symbol_633);
			}
			symbol_153.getTemplateBindings().add(symbol_632);
		}
		symbol_153.getSuperClasses().add(symbol_137); // ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_109.getOwnedTypes().add(symbol_153);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Set{T}?T]
		//
		symbol_154.setName("NonOrderedCollection");
		symbol_154.setElementType(symbol_99);
		{
			TemplateBinding symbol_634 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_634.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_635 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_635.setFormal(symbol_50);	
				symbol_635.setActual(symbol_99);	
				symbol_634.getParameterSubstitutions().add(symbol_635);
			}
			symbol_154.getTemplateBindings().add(symbol_634);
		}
		symbol_154.getSuperClasses().add(symbol_139); // ocl|Collection[ocl|Set{T}?T]
		symbol_109.getOwnedTypes().add(symbol_154);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Bag{T}?T]
		//
		symbol_155.setName("NonOrderedCollection");
		symbol_155.setElementType(symbol_15);
		{
			TemplateBinding symbol_636 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_636.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_637 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_637.setFormal(symbol_50);	
				symbol_637.setActual(symbol_15);	
				symbol_636.getParameterSubstitutions().add(symbol_637);
			}
			symbol_155.getTemplateBindings().add(symbol_636);
		}
		symbol_155.getSuperClasses().add(symbol_131); // ocl|Collection[ocl|Bag{T}?T]
		symbol_109.getOwnedTypes().add(symbol_155);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_156.setName("NonOrderedCollection");
		symbol_156.setElementType(symbol_102);
		{
			TemplateBinding symbol_638 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_638.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_639 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_639.setFormal(symbol_50);	
				symbol_639.setActual(symbol_102);	
				symbol_638.getParameterSubstitutions().add(symbol_639);
			}
			symbol_156.getTemplateBindings().add(symbol_638);
		}
		symbol_156.getSuperClasses().add(symbol_125); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_156);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[Boolean]
		//
		symbol_157.setName("NonOrderedCollection");
		symbol_157.setElementType(symbol_19);
		{
			TemplateBinding symbol_640 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_640.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_641 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_641.setFormal(symbol_50);	
				symbol_641.setActual(symbol_19);	
				symbol_640.getParameterSubstitutions().add(symbol_641);
			}
			symbol_157.getTemplateBindings().add(symbol_640);
		}
		symbol_157.getSuperClasses().add(symbol_118); // ocl|Collection[Boolean]
		symbol_109.getOwnedTypes().add(symbol_157);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OclAny]
		//
		symbol_158.setName("NonOrderedCollection");
		symbol_158.setElementType(symbol_59);
		{
			TemplateBinding symbol_642 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_642.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_643 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_643.setFormal(symbol_50);	
				symbol_643.setActual(symbol_59);	
				symbol_642.getParameterSubstitutions().add(symbol_643);
			}
			symbol_158.getTemplateBindings().add(symbol_642);
		}
		symbol_158.getSuperClasses().add(symbol_121); // ocl|Collection[ocl|OclAny]
		symbol_109.getOwnedTypes().add(symbol_158);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_159.setName("NonOrderedCollection");
		symbol_159.setElementType(symbol_206);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_50);	
				symbol_645.setActual(symbol_206);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_159.getTemplateBindings().add(symbol_644);
		}
		symbol_159.getSuperClasses().add(symbol_116); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_109.getOwnedTypes().add(symbol_159);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		//
		symbol_160.setName("NonOrderedCollection");
		symbol_160.setElementType(symbol_84);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_50);	
				symbol_647.setActual(symbol_84);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_160.getTemplateBindings().add(symbol_646);
		}
		symbol_160.getSuperClasses().add(symbol_120); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_109.getOwnedTypes().add(symbol_160);
		//
		// ocl::orphanage::NonOrderedCollection ocl|NonOrderedCollection[ocl|Collection{T}?T]
		//
		symbol_161.setName("NonOrderedCollection");
		symbol_161.setElementType(symbol_27);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_50);	
				symbol_649.setActual(symbol_27);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_161.getTemplateBindings().add(symbol_648);
		}
		symbol_161.getSuperClasses().add(symbol_133); // ocl|Collection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_161);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[String]
		//
		symbol_162.setName("NonUniqueCollection");
		symbol_162.setElementType(symbol_103);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_57);	
				symbol_651.setActual(symbol_103);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_162.getTemplateBindings().add(symbol_650);
		}
		symbol_162.getSuperClasses().add(symbol_134); // ocl|Collection[String]
		symbol_109.getOwnedTypes().add(symbol_162);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Bag{T}|flatten{T2}()?T2]
		//
		symbol_163.setName("NonUniqueCollection");
		symbol_163.setElementType(symbol_18);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_57);	
				symbol_653.setActual(symbol_18);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_163.getTemplateBindings().add(symbol_652);
		}
		symbol_163.getSuperClasses().add(symbol_127); // ocl|Collection[ocl|Bag{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_163);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Bag{T}?T]
		//
		symbol_164.setName("NonUniqueCollection");
		symbol_164.setElementType(symbol_15);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_57);	
				symbol_655.setActual(symbol_15);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_164.getTemplateBindings().add(symbol_654);
		}
		symbol_164.getSuperClasses().add(symbol_131); // ocl|Collection[ocl|Bag{T}?T]
		symbol_109.getOwnedTypes().add(symbol_164);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_165.setName("NonUniqueCollection");
		symbol_165.setElementType(symbol_80);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_57);	
				symbol_657.setActual(symbol_80);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_165.getTemplateBindings().add(symbol_656);
		}
		symbol_165.getSuperClasses().add(symbol_123); // ocl|Collection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_109.getOwnedTypes().add(symbol_165);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_166.setName("NonUniqueCollection");
		symbol_166.setElementType(symbol_58);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_57);	
				symbol_659.setActual(symbol_58);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_166.getTemplateBindings().add(symbol_658);
		}
		symbol_166.getSuperClasses().add(symbol_129); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_166);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		//
		symbol_167.setName("NonUniqueCollection");
		symbol_167.setElementType(symbol_92);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_57);	
				symbol_661.setActual(symbol_92);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_167.getTemplateBindings().add(symbol_660);
		}
		symbol_167.getSuperClasses().add(symbol_128); // ocl|Collection[ocl|Sequence{T}?T]
		symbol_109.getOwnedTypes().add(symbol_167);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_168.setName("NonUniqueCollection");
		symbol_168.setElementType(symbol_51);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_57);	
				symbol_663.setActual(symbol_51);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_168.getTemplateBindings().add(symbol_662);
		}
		symbol_168.getSuperClasses().add(symbol_136); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_168);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_169.setName("NonUniqueCollection");
		symbol_169.setElementType(symbol_54);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_57);	
				symbol_665.setActual(symbol_54);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_169.getTemplateBindings().add(symbol_664);
		}
		symbol_169.getSuperClasses().add(symbol_135); // ocl|Collection[ocl|NonOrderedCollection{T}|collect{V}(ocl|NonOrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_109.getOwnedTypes().add(symbol_169);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_170.setName("NonUniqueCollection");
		symbol_170.setElementType(symbol_95);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_57);	
				symbol_667.setActual(symbol_95);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_170.getTemplateBindings().add(symbol_666);
		}
		symbol_170.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_170);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|Collection{T}?T]
		//
		symbol_171.setName("NonUniqueCollection");
		symbol_171.setElementType(symbol_27);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_57);	
				symbol_669.setActual(symbol_27);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_171.getTemplateBindings().add(symbol_668);
		}
		symbol_171.getSuperClasses().add(symbol_133); // ocl|Collection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_171);
		//
		// ocl::orphanage::NonUniqueCollection ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_172.setName("NonUniqueCollection");
		symbol_172.setElementType(symbol_77);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_57);	
				symbol_671.setActual(symbol_77);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_172.getTemplateBindings().add(symbol_670);
		}
		symbol_172.getSuperClasses().add(symbol_126); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_172);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		//
		symbol_173.setName("OrderedCollection");
		symbol_173.setElementType(symbol_84);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_76);	
				symbol_673.setActual(symbol_84);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_173.getTemplateBindings().add(symbol_672);
		}
		symbol_173.getSuperClasses().add(symbol_120); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_109.getOwnedTypes().add(symbol_173);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_174.setName("OrderedCollection");
		symbol_174.setElementType(symbol_77);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_76);	
				symbol_675.setActual(symbol_77);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_174.getTemplateBindings().add(symbol_674);
		}
		symbol_174.getSuperClasses().add(symbol_126); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_174);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		//
		symbol_175.setName("OrderedCollection");
		symbol_175.setElementType(symbol_107);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_76);	
				symbol_677.setActual(symbol_107);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_175.getTemplateBindings().add(symbol_676);
		}
		symbol_175.getSuperClasses().add(symbol_138); // ocl|Collection[ocl|UniqueCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_175);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[String]
		//
		symbol_176.setName("OrderedCollection");
		symbol_176.setElementType(symbol_103);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_76);	
				symbol_679.setActual(symbol_103);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_176.getTemplateBindings().add(symbol_678);
		}
		symbol_176.getSuperClasses().add(symbol_134); // ocl|Collection[String]
		symbol_109.getOwnedTypes().add(symbol_176);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		//
		symbol_177.setName("OrderedCollection");
		symbol_177.setElementType(symbol_58);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_76);	
				symbol_681.setActual(symbol_58);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_177.getTemplateBindings().add(symbol_680);
		}
		symbol_177.getSuperClasses().add(symbol_129); // ocl|Collection[ocl|NonUniqueCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_177);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Sequence{T}?T]
		//
		symbol_178.setName("OrderedCollection");
		symbol_178.setElementType(symbol_92);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_76);	
				symbol_683.setActual(symbol_92);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_178.getTemplateBindings().add(symbol_682);
		}
		symbol_178.getSuperClasses().add(symbol_128); // ocl|Collection[ocl|Sequence{T}?T]
		symbol_109.getOwnedTypes().add(symbol_178);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_179.setName("OrderedCollection");
		symbol_179.setElementType(symbol_95);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_76);	
				symbol_685.setActual(symbol_95);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_179.getTemplateBindings().add(symbol_684);
		}
		symbol_179.getSuperClasses().add(symbol_115); // ocl|Collection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_179);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|Collection{T}?T]
		//
		symbol_180.setName("OrderedCollection");
		symbol_180.setElementType(symbol_27);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_76);	
				symbol_687.setActual(symbol_27);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_180.getTemplateBindings().add(symbol_686);
		}
		symbol_180.getSuperClasses().add(symbol_133); // ocl|Collection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_180);
		//
		// ocl::orphanage::OrderedCollection ocl|OrderedCollection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_181.setName("OrderedCollection");
		symbol_181.setElementType(symbol_80);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_75);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_76);	
				symbol_689.setActual(symbol_80);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_181.getTemplateBindings().add(symbol_688);
		}
		symbol_181.getSuperClasses().add(symbol_123); // ocl|Collection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_109.getOwnedTypes().add(symbol_181);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|UniqueCollection{T}?T]
		//
		symbol_182.setName("OrderedSet");
		symbol_182.setElementType(symbol_107);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_82);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_83);	
				symbol_691.setActual(symbol_107);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_182.getTemplateBindings().add(symbol_690);
		}
		symbol_182.getSuperClasses().add(symbol_215); // ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		symbol_182.getSuperClasses().add(symbol_175); // ocl|OrderedCollection[ocl|UniqueCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_182);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|Collection{T}?T]
		//
		symbol_183.setName("OrderedSet");
		symbol_183.setElementType(symbol_27);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_82);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_83);	
				symbol_693.setActual(symbol_27);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_183.getTemplateBindings().add(symbol_692);
		}
		symbol_183.getSuperClasses().add(symbol_180); // ocl|OrderedCollection[ocl|Collection{T}?T]
		symbol_183.getSuperClasses().add(symbol_223); // ocl|UniqueCollection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_183);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|OrderedSet{T}?T]
		//
		symbol_184.setName("OrderedSet");
		symbol_184.setElementType(symbol_84);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_82);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_83);	
				symbol_695.setActual(symbol_84);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_184.getTemplateBindings().add(symbol_694);
		}
		symbol_184.getSuperClasses().add(symbol_210); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_184.getSuperClasses().add(symbol_173); // ocl|OrderedCollection[ocl|OrderedSet{T}?T]
		symbol_109.getOwnedTypes().add(symbol_184);
		//
		// ocl::orphanage::OrderedSet ocl|OrderedSet[ocl|OrderedCollection{T}?T]
		//
		symbol_185.setName("OrderedSet");
		symbol_185.setElementType(symbol_77);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_82);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_83);	
				symbol_697.setActual(symbol_77);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_185.getTemplateBindings().add(symbol_696);
		}
		symbol_185.getSuperClasses().add(symbol_174); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		symbol_185.getSuperClasses().add(symbol_218); // ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_185);
		//
		// ocl::orphanage::Sequence ocl|Sequence[String]
		//
		symbol_186.setName("Sequence");
		symbol_186.setElementType(symbol_103);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_91);	
				symbol_699.setActual(symbol_103);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_186.getTemplateBindings().add(symbol_698);
		}
		symbol_186.getSuperClasses().add(symbol_162); // ocl|NonUniqueCollection[String]
		symbol_186.getSuperClasses().add(symbol_176); // ocl|OrderedCollection[String]
		symbol_109.getOwnedTypes().add(symbol_186);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Sequence{T}?T]
		//
		symbol_187.setName("Sequence");
		symbol_187.setElementType(symbol_92);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_91);	
				symbol_701.setActual(symbol_92);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_187.getTemplateBindings().add(symbol_700);
		}
		symbol_187.getSuperClasses().add(symbol_167); // ocl|NonUniqueCollection[ocl|Sequence{T}?T]
		symbol_187.getSuperClasses().add(symbol_178); // ocl|OrderedCollection[ocl|Sequence{T}?T]
		symbol_109.getOwnedTypes().add(symbol_187);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|NonUniqueCollection{T}?T]
		//
		symbol_188.setName("Sequence");
		symbol_188.setElementType(symbol_58);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_91);	
				symbol_703.setActual(symbol_58);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_188.getTemplateBindings().add(symbol_702);
		}
		symbol_188.getSuperClasses().add(symbol_177); // ocl|OrderedCollection[ocl|NonUniqueCollection{T}?T]
		symbol_188.getSuperClasses().add(symbol_166); // ocl|NonUniqueCollection[ocl|NonUniqueCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_188);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		//
		symbol_189.setName("Sequence");
		symbol_189.setElementType(symbol_80);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_91);	
				symbol_705.setActual(symbol_80);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_189.getTemplateBindings().add(symbol_704);
		}
		symbol_189.getSuperClasses().add(symbol_181); // ocl|OrderedCollection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_189.getSuperClasses().add(symbol_165); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}|collect{V}(ocl|OrderedCollection{T}?T|Lambda~T()V)?V]
		symbol_109.getOwnedTypes().add(symbol_189);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Sequence{T}|flatten{T2}()?T2]
		//
		symbol_190.setName("Sequence");
		symbol_190.setElementType(symbol_95);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_91);	
				symbol_707.setActual(symbol_95);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_190.getTemplateBindings().add(symbol_706);
		}
		symbol_190.getSuperClasses().add(symbol_179); // ocl|OrderedCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_190.getSuperClasses().add(symbol_170); // ocl|NonUniqueCollection[ocl|Sequence{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_190);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|OrderedCollection{T}?T]
		//
		symbol_191.setName("Sequence");
		symbol_191.setElementType(symbol_77);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_91);	
				symbol_709.setActual(symbol_77);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_191.getTemplateBindings().add(symbol_708);
		}
		symbol_191.getSuperClasses().add(symbol_174); // ocl|OrderedCollection[ocl|OrderedCollection{T}?T]
		symbol_191.getSuperClasses().add(symbol_172); // ocl|NonUniqueCollection[ocl|OrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_191);
		//
		// ocl::orphanage::Sequence ocl|Sequence[ocl|Collection{T}?T]
		//
		symbol_192.setName("Sequence");
		symbol_192.setElementType(symbol_27);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_91);	
				symbol_711.setActual(symbol_27);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_192.getTemplateBindings().add(symbol_710);
		}
		symbol_192.getSuperClasses().add(symbol_171); // ocl|NonUniqueCollection[ocl|Collection{T}?T]
		symbol_192.getSuperClasses().add(symbol_180); // ocl|OrderedCollection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_192);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OrderedSet{T}?T]
		//
		symbol_193.setName("Set");
		symbol_193.setElementType(symbol_84);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_98);	
				symbol_713.setActual(symbol_84);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_193.getTemplateBindings().add(symbol_712);
		}
		symbol_193.getSuperClasses().add(symbol_210); // ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		symbol_193.getSuperClasses().add(symbol_160); // ocl|NonOrderedCollection[ocl|OrderedSet{T}?T]
		symbol_109.getOwnedTypes().add(symbol_193);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclAny]
		//
		symbol_194.setName("Set");
		symbol_194.setElementType(symbol_59);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_98);	
				symbol_715.setActual(symbol_59);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_194.getTemplateBindings().add(symbol_714);
		}
		symbol_194.getSuperClasses().add(symbol_221); // ocl|UniqueCollection[ocl|OclAny]
		symbol_194.getSuperClasses().add(symbol_158); // ocl|NonOrderedCollection[ocl|OclAny]
		symbol_109.getOwnedTypes().add(symbol_194);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_195.setName("Set");
		symbol_195.setElementType(symbol_23);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_98);	
				symbol_717.setActual(symbol_23);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_195.getTemplateBindings().add(symbol_716);
		}
		symbol_195.getSuperClasses().add(symbol_214); // ocl|UniqueCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_195.getSuperClasses().add(symbol_147); // ocl|NonOrderedCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_109.getOwnedTypes().add(symbol_195);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclInvalid]
		//
		symbol_196.setName("Set");
		symbol_196.setElementType(symbol_69);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_98);	
				symbol_719.setActual(symbol_69);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_196.getTemplateBindings().add(symbol_718);
		}
		symbol_196.getSuperClasses().add(symbol_212); // ocl|UniqueCollection[ocl|OclInvalid]
		symbol_196.getSuperClasses().add(symbol_148); // ocl|NonOrderedCollection[ocl|OclInvalid]
		symbol_109.getOwnedTypes().add(symbol_196);
		//
		// ocl::orphanage::Set ocl|Set[ocl|NonOrderedCollection{T}?T]
		//
		symbol_197.setName("Set");
		symbol_197.setElementType(symbol_51);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_98);	
				symbol_721.setActual(symbol_51);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_197.getTemplateBindings().add(symbol_720);
		}
		symbol_197.getSuperClasses().add(symbol_151); // ocl|NonOrderedCollection[ocl|NonOrderedCollection{T}?T]
		symbol_197.getSuperClasses().add(symbol_222); // ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_197);
		//
		// ocl::orphanage::Set ocl|Set[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_198.setName("Set");
		symbol_198.setElementType(symbol_206);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_98);	
				symbol_723.setActual(symbol_206);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_198.getTemplateBindings().add(symbol_722);
		}
		symbol_198.getSuperClasses().add(symbol_159); // ocl|NonOrderedCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_198.getSuperClasses().add(symbol_209); // ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_109.getOwnedTypes().add(symbol_198);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_199.setName("Set");
		symbol_199.setElementType(symbol_102);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_98);	
				symbol_725.setActual(symbol_102);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_199.getTemplateBindings().add(symbol_724);
		}
		symbol_199.getSuperClasses().add(symbol_156); // ocl|NonOrderedCollection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_199.getSuperClasses().add(symbol_219); // ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_199);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_200.setName("Set");
		symbol_200.setElementType(symbol_62);
		{
			TemplateBinding symbol_726 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_726.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_727 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_727.setFormal(symbol_98);	
				symbol_727.setActual(symbol_62);	
				symbol_726.getParameterSubstitutions().add(symbol_727);
			}
			symbol_200.getTemplateBindings().add(symbol_726);
		}
		symbol_200.getSuperClasses().add(symbol_153); // ocl|NonOrderedCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_200.getSuperClasses().add(symbol_217); // ocl|UniqueCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_109.getOwnedTypes().add(symbol_200);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Set{T}?T]
		//
		symbol_201.setName("Set");
		symbol_201.setElementType(symbol_99);
		{
			TemplateBinding symbol_728 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_728.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_729 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_729.setFormal(symbol_98);	
				symbol_729.setActual(symbol_99);	
				symbol_728.getParameterSubstitutions().add(symbol_729);
			}
			symbol_201.getTemplateBindings().add(symbol_728);
		}
		symbol_201.getSuperClasses().add(symbol_211); // ocl|UniqueCollection[ocl|Set{T}?T]
		symbol_201.getSuperClasses().add(symbol_154); // ocl|NonOrderedCollection[ocl|Set{T}?T]
		symbol_109.getOwnedTypes().add(symbol_201);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Enumeration]
		//
		symbol_202.setName("Set");
		symbol_202.setElementType(symbol_46);
		{
			TemplateBinding symbol_730 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_730.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_731 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_731.setFormal(symbol_98);	
				symbol_731.setActual(symbol_46);	
				symbol_730.getParameterSubstitutions().add(symbol_731);
			}
			symbol_202.getTemplateBindings().add(symbol_730);
		}
		symbol_202.getSuperClasses().add(symbol_146); // ocl|NonOrderedCollection[ocl|Enumeration]
		symbol_202.getSuperClasses().add(symbol_220); // ocl|UniqueCollection[ocl|Enumeration]
		symbol_109.getOwnedTypes().add(symbol_202);
		//
		// ocl::orphanage::Set ocl|Set[ocl|Collection{T}?T]
		//
		symbol_203.setName("Set");
		symbol_203.setElementType(symbol_27);
		{
			TemplateBinding symbol_732 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_732.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_733 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_733.setFormal(symbol_98);	
				symbol_733.setActual(symbol_27);	
				symbol_732.getParameterSubstitutions().add(symbol_733);
			}
			symbol_203.getTemplateBindings().add(symbol_732);
		}
		symbol_203.getSuperClasses().add(symbol_223); // ocl|UniqueCollection[ocl|Collection{T}?T]
		symbol_203.getSuperClasses().add(symbol_161); // ocl|NonOrderedCollection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_203);
		//
		// ocl::orphanage::Set ocl|Set[Boolean]
		//
		symbol_204.setName("Set");
		symbol_204.setElementType(symbol_19);
		{
			TemplateBinding symbol_734 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_734.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_735 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_735.setFormal(symbol_98);	
				symbol_735.setActual(symbol_19);	
				symbol_734.getParameterSubstitutions().add(symbol_735);
			}
			symbol_204.getTemplateBindings().add(symbol_734);
		}
		symbol_204.getSuperClasses().add(symbol_213); // ocl|UniqueCollection[Boolean]
		symbol_204.getSuperClasses().add(symbol_157); // ocl|NonOrderedCollection[Boolean]
		symbol_109.getOwnedTypes().add(symbol_204);
		//
		// ocl::orphanage::Set ocl|Set[ocl|OclVoid]
		//
		symbol_205.setName("Set");
		symbol_205.setElementType(symbol_73);
		{
			TemplateBinding symbol_736 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_736.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_737 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_737.setFormal(symbol_98);	
				symbol_737.setActual(symbol_73);	
				symbol_736.getParameterSubstitutions().add(symbol_737);
			}
			symbol_205.getTemplateBindings().add(symbol_736);
		}
		symbol_205.getSuperClasses().add(symbol_216); // ocl|UniqueCollection[ocl|OclVoid]
		symbol_205.getSuperClasses().add(symbol_152); // ocl|NonOrderedCollection[ocl|OclVoid]
		symbol_109.getOwnedTypes().add(symbol_205);
		//
		// ocl::orphanage::Tuple Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}
		//
		symbol_206.setName("Tuple");
		{ // ocl::orphanage::Tuple::first Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|first
			symbol_207.setName("first");
			symbol_207.setType(symbol_27);  // ocl|Collection{T}?T
			
			symbol_207.setIsResolveProxies(true);
			symbol_206.getOwnedAttributes().add(symbol_207);
		}
		{ // ocl::orphanage::Tuple::second Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}|second
			symbol_208.setName("second");
			symbol_208.setType(symbol_45);  // ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2
			
			symbol_208.setIsResolveProxies(true);
			symbol_206.getOwnedAttributes().add(symbol_208);
		}
		symbol_109.getOwnedTypes().add(symbol_206);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		//
		symbol_209.setName("UniqueCollection");
		symbol_209.setElementType(symbol_206);
		{
			TemplateBinding symbol_738 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_738.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_739 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_739.setFormal(symbol_106);	
				symbol_739.setActual(symbol_206);	
				symbol_738.getParameterSubstitutions().add(symbol_739);
			}
			symbol_209.getTemplateBindings().add(symbol_738);
		}
		symbol_209.getSuperClasses().add(symbol_116); // ocl|Collection[Tuple{first:ocl|Collection{T}?T,second:ocl|Collection{T}|product{T2}(ocl|Collection[T2])?T2}]
		symbol_109.getOwnedTypes().add(symbol_209);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OrderedSet{T}?T]
		//
		symbol_210.setName("UniqueCollection");
		symbol_210.setElementType(symbol_84);
		{
			TemplateBinding symbol_740 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_740.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_741 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_741.setFormal(symbol_106);	
				symbol_741.setActual(symbol_84);	
				symbol_740.getParameterSubstitutions().add(symbol_741);
			}
			symbol_210.getTemplateBindings().add(symbol_740);
		}
		symbol_210.getSuperClasses().add(symbol_120); // ocl|Collection[ocl|OrderedSet{T}?T]
		symbol_109.getOwnedTypes().add(symbol_210);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Set{T}?T]
		//
		symbol_211.setName("UniqueCollection");
		symbol_211.setElementType(symbol_99);
		{
			TemplateBinding symbol_742 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_742.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_743 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_743.setFormal(symbol_106);	
				symbol_743.setActual(symbol_99);	
				symbol_742.getParameterSubstitutions().add(symbol_743);
			}
			symbol_211.getTemplateBindings().add(symbol_742);
		}
		symbol_211.getSuperClasses().add(symbol_139); // ocl|Collection[ocl|Set{T}?T]
		symbol_109.getOwnedTypes().add(symbol_211);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclInvalid]
		//
		symbol_212.setName("UniqueCollection");
		symbol_212.setElementType(symbol_69);
		{
			TemplateBinding symbol_744 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_744.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_745 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_745.setFormal(symbol_106);	
				symbol_745.setActual(symbol_69);	
				symbol_744.getParameterSubstitutions().add(symbol_745);
			}
			symbol_212.getTemplateBindings().add(symbol_744);
		}
		symbol_212.getSuperClasses().add(symbol_140); // ocl|Collection[ocl|OclInvalid]
		symbol_109.getOwnedTypes().add(symbol_212);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[Boolean]
		//
		symbol_213.setName("UniqueCollection");
		symbol_213.setElementType(symbol_19);
		{
			TemplateBinding symbol_746 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_746.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_747 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_747.setFormal(symbol_106);	
				symbol_747.setActual(symbol_19);	
				symbol_746.getParameterSubstitutions().add(symbol_747);
			}
			symbol_213.getTemplateBindings().add(symbol_746);
		}
		symbol_213.getSuperClasses().add(symbol_118); // ocl|Collection[Boolean]
		symbol_109.getOwnedTypes().add(symbol_213);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		//
		symbol_214.setName("UniqueCollection");
		symbol_214.setElementType(symbol_23);
		{
			TemplateBinding symbol_748 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_748.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_749 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_749.setFormal(symbol_106);	
				symbol_749.setActual(symbol_23);	
				symbol_748.getParameterSubstitutions().add(symbol_749);
			}
			symbol_214.getTemplateBindings().add(symbol_748);
		}
		symbol_214.getSuperClasses().add(symbol_141); // ocl|Collection[ocl|Classifier|allInstances{OclSelf}()?OclSelf]
		symbol_109.getOwnedTypes().add(symbol_214);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|UniqueCollection{T}?T]
		//
		symbol_215.setName("UniqueCollection");
		symbol_215.setElementType(symbol_107);
		{
			TemplateBinding symbol_750 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_750.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_751 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_751.setFormal(symbol_106);	
				symbol_751.setActual(symbol_107);	
				symbol_750.getParameterSubstitutions().add(symbol_751);
			}
			symbol_215.getTemplateBindings().add(symbol_750);
		}
		symbol_215.getSuperClasses().add(symbol_138); // ocl|Collection[ocl|UniqueCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_215);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclVoid]
		//
		symbol_216.setName("UniqueCollection");
		symbol_216.setElementType(symbol_73);
		{
			TemplateBinding symbol_752 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_752.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_753 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_753.setFormal(symbol_106);	
				symbol_753.setActual(symbol_73);	
				symbol_752.getParameterSubstitutions().add(symbol_753);
			}
			symbol_216.getTemplateBindings().add(symbol_752);
		}
		symbol_216.getSuperClasses().add(symbol_130); // ocl|Collection[ocl|OclVoid]
		symbol_109.getOwnedTypes().add(symbol_216);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_217.setName("UniqueCollection");
		symbol_217.setElementType(symbol_62);
		{
			TemplateBinding symbol_754 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_754.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_755 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_755.setFormal(symbol_106);	
				symbol_755.setActual(symbol_62);	
				symbol_754.getParameterSubstitutions().add(symbol_755);
			}
			symbol_217.getTemplateBindings().add(symbol_754);
		}
		symbol_217.getSuperClasses().add(symbol_137); // ocl|Collection[ocl|OclAny|oclAsSet{OclSelf}()?OclSelf]
		symbol_109.getOwnedTypes().add(symbol_217);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OrderedCollection{T}?T]
		//
		symbol_218.setName("UniqueCollection");
		symbol_218.setElementType(symbol_77);
		{
			TemplateBinding symbol_756 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_756.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_757 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_757.setFormal(symbol_106);	
				symbol_757.setActual(symbol_77);	
				symbol_756.getParameterSubstitutions().add(symbol_757);
			}
			symbol_218.getTemplateBindings().add(symbol_756);
		}
		symbol_218.getSuperClasses().add(symbol_126); // ocl|Collection[ocl|OrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_218);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Set{T}|flatten{T2}()?T2]
		//
		symbol_219.setName("UniqueCollection");
		symbol_219.setElementType(symbol_102);
		{
			TemplateBinding symbol_758 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_758.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_759 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_759.setFormal(symbol_106);	
				symbol_759.setActual(symbol_102);	
				symbol_758.getParameterSubstitutions().add(symbol_759);
			}
			symbol_219.getTemplateBindings().add(symbol_758);
		}
		symbol_219.getSuperClasses().add(symbol_125); // ocl|Collection[ocl|Set{T}|flatten{T2}()?T2]
		symbol_109.getOwnedTypes().add(symbol_219);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Enumeration]
		//
		symbol_220.setName("UniqueCollection");
		symbol_220.setElementType(symbol_46);
		{
			TemplateBinding symbol_760 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_760.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_761 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_761.setFormal(symbol_106);	
				symbol_761.setActual(symbol_46);	
				symbol_760.getParameterSubstitutions().add(symbol_761);
			}
			symbol_220.getTemplateBindings().add(symbol_760);
		}
		symbol_220.getSuperClasses().add(symbol_122); // ocl|Collection[ocl|Enumeration]
		symbol_109.getOwnedTypes().add(symbol_220);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|OclAny]
		//
		symbol_221.setName("UniqueCollection");
		symbol_221.setElementType(symbol_59);
		{
			TemplateBinding symbol_762 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_762.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_763 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_763.setFormal(symbol_106);	
				symbol_763.setActual(symbol_59);	
				symbol_762.getParameterSubstitutions().add(symbol_763);
			}
			symbol_221.getTemplateBindings().add(symbol_762);
		}
		symbol_221.getSuperClasses().add(symbol_121); // ocl|Collection[ocl|OclAny]
		symbol_109.getOwnedTypes().add(symbol_221);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|NonOrderedCollection{T}?T]
		//
		symbol_222.setName("UniqueCollection");
		symbol_222.setElementType(symbol_51);
		{
			TemplateBinding symbol_764 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_764.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_765 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_765.setFormal(symbol_106);	
				symbol_765.setActual(symbol_51);	
				symbol_764.getParameterSubstitutions().add(symbol_765);
			}
			symbol_222.getTemplateBindings().add(symbol_764);
		}
		symbol_222.getSuperClasses().add(symbol_136); // ocl|Collection[ocl|NonOrderedCollection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_222);
		//
		// ocl::orphanage::UniqueCollection ocl|UniqueCollection[ocl|Collection{T}?T]
		//
		symbol_223.setName("UniqueCollection");
		symbol_223.setElementType(symbol_27);
		{
			TemplateBinding symbol_766 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_766.setSignature(symbol_105);
			{
				TemplateParameterSubstitution symbol_767 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_767.setFormal(symbol_106);	
				symbol_767.setActual(symbol_27);	
				symbol_766.getParameterSubstitutions().add(symbol_767);
			}
			symbol_223.getTemplateBindings().add(symbol_766);
		}
		symbol_223.getSuperClasses().add(symbol_133); // ocl|Collection[ocl|Collection{T}?T]
		symbol_109.getOwnedTypes().add(symbol_223);
		symbol_1.getNestedPackages().add(symbol_109);
		return symbol_1;
	}
}
