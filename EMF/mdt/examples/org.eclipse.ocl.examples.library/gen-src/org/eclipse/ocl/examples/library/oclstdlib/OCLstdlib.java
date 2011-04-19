/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OCLstdlib.java,v 1.14 2011/04/01 19:55:42 ewillink Exp $
 */
package	org.eclipse.ocl.examples.library.oclstdlib;

import java.math.BigInteger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.ocl.examples.pivot.*;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;

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
		BagType symbol_12 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag{T}
		TemplateSignature symbol_13 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Bag{T}!
		TypeTemplateParameter symbol_14 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_15 = PivotFactory.eINSTANCE.createClass(); // ocl!Bag{T}?T
		
		TemplateSignature symbol_16 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Bag{T}!flatten{T2}()!
		TypeTemplateParameter symbol_17 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_18 = PivotFactory.eINSTANCE.createClass(); // ocl!Bag{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_19 = PivotFactory.eINSTANCE.createPrimitiveType(); // Boolean
		TemplateSignature symbol_20 = PivotFactory.eINSTANCE.createTemplateSignature(); // Boolean!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_21 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_22 = PivotFactory.eINSTANCE.createClass(); // Boolean!allInstances{OclSelf}()?OclSelf
		
		
		Class symbol_23 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier
		TemplateSignature symbol_24 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Classifier!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_25 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_26 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_27 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection{T}
		TemplateSignature symbol_28 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!
		TypeTemplateParameter symbol_29 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_30 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}?T
		
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_46 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_47 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_49 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_50 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
		
		
		Class symbol_52 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration
		TemplateSignature symbol_53 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Enumeration!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_54 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_55 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration!allInstances{OclSelf}()?OclSelf
		
		
		PrimitiveType symbol_56 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_57 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection{T}
		TemplateSignature symbol_58 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_59 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_60 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_61 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_62 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_63 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_64 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_65 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_66 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_67 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection{T}
		TemplateSignature symbol_68 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_69 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_70 = PivotFactory.eINSTANCE.createClass(); // ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_71 = PivotFactory.eINSTANCE.createAnyType(); // ocl!OclAny
		TemplateSignature symbol_72 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsSet{OclSelf}()!
		TypeTemplateParameter symbol_73 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_74 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_75 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_76 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
		
		
		InvalidType symbol_78 = PivotFactory.eINSTANCE.createInvalidType(); // ocl!OclInvalid
		TemplateSignature symbol_79 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclInvalid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_80 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_81 = PivotFactory.eINSTANCE.createClass(); // ocl!OclInvalid!allInstances{OclSelf}()?OclSelf
		
		
		Class symbol_82 = PivotFactory.eINSTANCE.createClass(); // ocl!OclMessage
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // ocl!OclState
		
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // ocl!OclTuple
		
		VoidType symbol_85 = PivotFactory.eINSTANCE.createVoidType(); // ocl!OclVoid
		TemplateSignature symbol_86 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclVoid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_87 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_88 = PivotFactory.eINSTANCE.createClass(); // ocl!OclVoid!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_89 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection{T}
		TemplateSignature symbol_90 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_91 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_92 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_93 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_94 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_95 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_96 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_97 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_98 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_99 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet{T}
		TemplateSignature symbol_100 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_101 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_102 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}?T
		
		
		PrimitiveType symbol_103 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_104 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_105 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_106 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{T}(ocl!Classifier)?T
		
		
		SequenceType symbol_107 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence{T}
		TemplateSignature symbol_108 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!
		TypeTemplateParameter symbol_109 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_110 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}?T
		
		TemplateSignature symbol_111 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_112 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_114 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set{T}
		TemplateSignature symbol_115 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!
		TypeTemplateParameter symbol_116 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_117 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}?T
		
		TemplateSignature symbol_118 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_119 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_120 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_121 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_122 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection{T}
		TemplateSignature symbol_123 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_124 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_125 = PivotFactory.eINSTANCE.createClass(); // ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_126 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_127 = PivotFactory.eINSTANCE.createPackage(); // orphanage
		BagType symbol_128 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Collection{T}?T]
		
		BagType symbol_129 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		BagType symbol_130 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		
		BagType symbol_131 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_132 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}?T]
		
		CollectionType symbol_133 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_134 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_140 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_141 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_142 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_143 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		LambdaType symbol_162 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_163 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_164 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_165 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_166 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Sequence{T}?T()Boolean
		
		LambdaType symbol_167 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Set{T}?T()Boolean
		
		LambdaType symbol_168 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!OclAny
		
		LambdaType symbol_169 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_170 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		
		LambdaType symbol_171 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_172 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_173 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Bag{T}?T()Boolean
		
		LambdaType symbol_174 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		
		LambdaType symbol_175 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_176 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedSet{T}?T()Boolean
		
		LambdaType symbol_177 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()Boolean
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_193 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_194 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_195 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_196 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_197 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_198 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_199 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_200 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_201 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_202 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_203 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_204 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_205 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_206 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_207 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_208 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_209 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		OrderedSetType symbol_215 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		OrderedSetType symbol_216 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_217 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_218 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		SequenceType symbol_219 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SequenceType symbol_220 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_221 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_222 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_223 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_224 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_225 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SetType symbol_226 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_227 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_228 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_229 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_230 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_231 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		SetType symbol_232 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_233 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_234 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier]
		
		SetType symbol_235 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_236 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_237 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_238 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_239 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		TupleType symbol_240 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_241 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_242 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_243 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_244 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_245 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_246 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_247 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_248 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_249 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		CollectionType symbol_250 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_251 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier]
		
		CollectionType symbol_252 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_253 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_254 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_255 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_256 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_257 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_258 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		

		symbol_1.setName("ocl");
		symbol_1.setMoniker("ocl");
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
		// ocl::Bag ocl!Bag{T}
		//
		symbol_12.setName("Bag");
		//symbol_12.setMoniker("ocl!Bag{T}");
		symbol_12.setElementType(symbol_15);
		symbol_15.setName("T");
		symbol_14.setOwnedParameteredElement(symbol_15);
		symbol_13.getOwnedParameters().add(symbol_14);
		
		symbol_12.setOwnedTemplateSignature(symbol_13);
		symbol_12.getSuperClasses().add(symbol_189); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_205); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_259 = PivotFactory.eINSTANCE.createOperation();
			symbol_259.setName("<>");
			//symbol_259.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_259.setType(symbol_19);  // Boolean
			symbol_259.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_260 = PivotFactory.eINSTANCE.createParameter();
			symbol_260.setName("object2");
			//symbol_260.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_260.setType(symbol_71);  // ocl!OclAny
			symbol_260.setLower(BigInteger.valueOf(0));
			
			symbol_259.getOwnedParameters().add(symbol_260);
			symbol_259.setPrecedence(symbol_7);
			symbol_259.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_259);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_261 = PivotFactory.eINSTANCE.createOperation();
			symbol_261.setName("=");
			//symbol_261.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_261.setType(symbol_19);  // Boolean
			symbol_261.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_262 = PivotFactory.eINSTANCE.createParameter();
			symbol_262.setName("object2");
			//symbol_262.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_262.setType(symbol_71);  // ocl!OclAny
			symbol_262.setLower(BigInteger.valueOf(0));
			
			symbol_261.getOwnedParameters().add(symbol_262);
			symbol_261.setPrecedence(symbol_7);
			symbol_261.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_261);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_263 = PivotFactory.eINSTANCE.createOperation();
			symbol_263.setName("excluding");
			//symbol_263.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_263.setType(symbol_132);  // ocl!Bag[ocl!Bag{T}?T]
			symbol_263.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("object");
			//symbol_264.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_264.setType(symbol_71);  // ocl!OclAny
			symbol_264.setLower(BigInteger.valueOf(0));
			
			symbol_263.getOwnedParameters().add(symbol_264);
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_263);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_265 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_265.setOwnedTemplateSignature(symbol_16);
			symbol_265.setName("flatten");
			//symbol_265.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_265.setType(symbol_130);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			symbol_265.setLower(BigInteger.valueOf(0));
			
			symbol_265.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_265);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_266 = PivotFactory.eINSTANCE.createOperation();
			symbol_266.setName("including");
			//symbol_266.setMoniker("ocl!Bag{T}!including(T)");
			symbol_266.setType(symbol_132);  // ocl!Bag[ocl!Bag{T}?T]
			symbol_266.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_267 = PivotFactory.eINSTANCE.createParameter();
			symbol_267.setName("object");
			//symbol_267.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_267.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_267.setLower(BigInteger.valueOf(0));
			
			symbol_266.getOwnedParameters().add(symbol_267);
			symbol_266.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_266);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_268 = PivotFactory.eINSTANCE.createIteration();
			symbol_268.setName("reject");
			//symbol_268.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)");
			symbol_268.setType(symbol_132);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_269 = PivotFactory.eINSTANCE.createParameter();
			symbol_269.setName("i");
			symbol_269.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_268.getOwnedIterators().add(symbol_269);
			Parameter symbol_270 = PivotFactory.eINSTANCE.createParameter();
			symbol_270.setName("body");
			//symbol_270.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_270.setType(symbol_173);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_268.getOwnedParameters().add(symbol_270);
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_268);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_271 = PivotFactory.eINSTANCE.createIteration();
			symbol_271.setName("select");
			//symbol_271.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_271.setType(symbol_132);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_272 = PivotFactory.eINSTANCE.createParameter();
			symbol_272.setName("i");
			symbol_272.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_271.getOwnedIterators().add(symbol_272);
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("body");
			//symbol_273.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_273.setType(symbol_173);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_271.getOwnedParameters().add(symbol_273);
			symbol_271.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_271);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_274 = PivotFactory.eINSTANCE.createOperation();
			symbol_274.setName("<>");
			//symbol_274.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_274.setType(symbol_19);  // Boolean
			symbol_274.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("object2");
			//symbol_275.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_275.setType(symbol_71);  // ocl!OclAny
			symbol_275.setLower(BigInteger.valueOf(0));
			
			symbol_274.getOwnedParameters().add(symbol_275);
			symbol_274.setPrecedence(symbol_7);
			symbol_274.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_274);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("=");
			//symbol_276.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_276.setType(symbol_19);  // Boolean
			symbol_276.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_277 = PivotFactory.eINSTANCE.createParameter();
			symbol_277.setName("object2");
			//symbol_277.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_277.setType(symbol_71);  // ocl!OclAny
			symbol_277.setLower(BigInteger.valueOf(0));
			
			symbol_276.getOwnedParameters().add(symbol_277);
			symbol_276.setPrecedence(symbol_7);
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances{OclSelf}()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_22.setName("OclSelf");
			symbol_21.setOwnedParameteredElement(symbol_22);
			symbol_20.getOwnedParameters().add(symbol_21);
			
			symbol_278.setOwnedTemplateSignature(symbol_20);
			symbol_278.setName("allInstances");
			//symbol_278.setMoniker("Boolean!allInstances{OclSelf}()");
			symbol_278.setType(symbol_235);  // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
			symbol_278.setLower(BigInteger.valueOf(0));
			
			symbol_278.setIsStatic(true);
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("and");
			//symbol_279.setMoniker("Boolean!and(Boolean)");
			symbol_279.setType(symbol_19);  // Boolean
			symbol_279.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_280 = PivotFactory.eINSTANCE.createParameter();
			symbol_280.setName("b");
			//symbol_280.setMoniker("Boolean!and(Boolean)!b");
			symbol_280.setType(symbol_19);  // Boolean
			symbol_280.setLower(BigInteger.valueOf(0));
			
			symbol_279.getOwnedParameters().add(symbol_280);
			symbol_279.setPrecedence(symbol_8);
			symbol_279.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_279);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_281.setName("implies");
			//symbol_281.setMoniker("Boolean!implies(Boolean)");
			symbol_281.setType(symbol_19);  // Boolean
			symbol_281.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_282 = PivotFactory.eINSTANCE.createParameter();
			symbol_282.setName("b");
			//symbol_282.setMoniker("Boolean!implies(Boolean)!b");
			symbol_282.setType(symbol_19);  // Boolean
			symbol_282.setLower(BigInteger.valueOf(0));
			
			symbol_281.getOwnedParameters().add(symbol_282);
			symbol_281.setPrecedence(symbol_11);
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("not");
			//symbol_283.setMoniker("Boolean!not()");
			symbol_283.setType(symbol_19);  // Boolean
			symbol_283.setLower(BigInteger.valueOf(0));
			
			symbol_283.setPrecedence(symbol_3);
			symbol_283.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_283);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_284 = PivotFactory.eINSTANCE.createOperation();
			symbol_284.setName("or");
			//symbol_284.setMoniker("Boolean!or(Boolean)");
			symbol_284.setType(symbol_19);  // Boolean
			symbol_284.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_285 = PivotFactory.eINSTANCE.createParameter();
			symbol_285.setName("b");
			//symbol_285.setMoniker("Boolean!or(Boolean)!b");
			symbol_285.setType(symbol_19);  // Boolean
			symbol_285.setLower(BigInteger.valueOf(0));
			
			symbol_284.getOwnedParameters().add(symbol_285);
			symbol_284.setPrecedence(symbol_9);
			symbol_284.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_284);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_286.setName("toString");
			//symbol_286.setMoniker("Boolean!toString()");
			symbol_286.setType(symbol_121);  // String
			symbol_286.setLower(BigInteger.valueOf(0));
			
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_287 = PivotFactory.eINSTANCE.createOperation();
			symbol_287.setName("xor");
			//symbol_287.setMoniker("Boolean!xor(Boolean)");
			symbol_287.setType(symbol_19);  // Boolean
			symbol_287.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_288 = PivotFactory.eINSTANCE.createParameter();
			symbol_288.setName("b");
			//symbol_288.setMoniker("Boolean!xor(Boolean)!b");
			symbol_288.setType(symbol_19);  // Boolean
			symbol_288.setLower(BigInteger.valueOf(0));
			
			symbol_287.getOwnedParameters().add(symbol_288);
			symbol_287.setPrecedence(symbol_10);
			symbol_287.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_287);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl!Classifier
		//
		symbol_23.setName("Classifier");
		//symbol_23.setMoniker("ocl!Classifier");
		symbol_23.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Classifier::allInstances() ocl!Classifier!allInstances{OclSelf}()
			Operation symbol_289 = PivotFactory.eINSTANCE.createOperation();
			symbol_26.setName("OclSelf");
			symbol_25.setOwnedParameteredElement(symbol_26);
			symbol_24.getOwnedParameters().add(symbol_25);
			
			symbol_289.setOwnedTemplateSignature(symbol_24);
			symbol_289.setName("allInstances");
			//symbol_289.setMoniker("ocl!Classifier!allInstances{OclSelf}()");
			symbol_289.setType(symbol_227);  // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
			symbol_289.setLower(BigInteger.valueOf(0));
			
			symbol_289.setIsStatic(true);
			symbol_289.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_289);
		}
		{	// ocl::Classifier::oclContainer() ocl!Classifier!oclContainer()
			Operation symbol_290 = PivotFactory.eINSTANCE.createOperation();
			symbol_290.setName("oclContainer");
			//symbol_290.setMoniker("ocl!Classifier!oclContainer()");
			symbol_290.setType(symbol_23);  // ocl!Classifier
			symbol_290.setLower(BigInteger.valueOf(0));
			
			symbol_290.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_290);
		}
		{	// ocl::Classifier::oclContents() ocl!Classifier!oclContents()
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("oclContents");
			//symbol_291.setMoniker("ocl!Classifier!oclContents()");
			symbol_291.setType(symbol_234);  // ocl!Set[ocl!Classifier]
			symbol_291.setLower(BigInteger.valueOf(0));
			
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_291);
		}
		symbol_1.getOwnedTypes().add(symbol_23);
		//
		// ocl::Collection ocl!Collection{T}
		//
		symbol_27.setName("Collection");
		//symbol_27.setMoniker("ocl!Collection{T}");
		symbol_27.setElementType(symbol_30);
		symbol_30.setName("T");
		symbol_29.setOwnedParameteredElement(symbol_30);
		symbol_28.getOwnedParameters().add(symbol_29);
		
		symbol_27.setOwnedTemplateSignature(symbol_28);
		symbol_27.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Collection::<>() ocl!Collection{T}!<>(ocl!OclAny)
			Operation symbol_292 = PivotFactory.eINSTANCE.createOperation();
			symbol_292.setName("<>");
			//symbol_292.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_292.setType(symbol_19);  // Boolean
			symbol_292.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_293 = PivotFactory.eINSTANCE.createParameter();
			symbol_293.setName("object2");
			//symbol_293.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_293.setType(symbol_71);  // ocl!OclAny
			symbol_293.setLower(BigInteger.valueOf(0));
			
			symbol_292.getOwnedParameters().add(symbol_293);
			symbol_292.setPrecedence(symbol_7);
			symbol_292.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_292);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_294 = PivotFactory.eINSTANCE.createOperation();
			symbol_294.setName("=");
			//symbol_294.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_294.setType(symbol_19);  // Boolean
			symbol_294.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("object2");
			//symbol_295.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_295.setType(symbol_71);  // ocl!OclAny
			symbol_295.setLower(BigInteger.valueOf(0));
			
			symbol_294.getOwnedParameters().add(symbol_295);
			symbol_294.setPrecedence(symbol_7);
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_296 = PivotFactory.eINSTANCE.createIteration();
			symbol_296.setName("any");
			//symbol_296.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_296.setType(symbol_30);  // ocl!Collection{T}?T
			
			Parameter symbol_297 = PivotFactory.eINSTANCE.createParameter();
			symbol_297.setName("i");
			symbol_297.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_296.getOwnedIterators().add(symbol_297);
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("body");
			//symbol_298.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_298.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_296.getOwnedParameters().add(symbol_298);
			symbol_296.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_296);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_299 = PivotFactory.eINSTANCE.createOperation();
			symbol_299.setName("asBag");
			//symbol_299.setMoniker("ocl!Collection{T}!asBag()");
			symbol_299.setType(symbol_128);  // ocl!Bag[ocl!Collection{T}?T]
			symbol_299.setLower(BigInteger.valueOf(0));
			
			symbol_299.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_299);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_300 = PivotFactory.eINSTANCE.createOperation();
			symbol_300.setName("asOrderedSet");
			//symbol_300.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_300.setType(symbol_215);  // ocl!OrderedSet[ocl!Collection{T}?T]
			symbol_300.setLower(BigInteger.valueOf(0));
			
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_301.setName("asSequence");
			//symbol_301.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_301.setType(symbol_221);  // ocl!Sequence[ocl!Collection{T}?T]
			symbol_301.setLower(BigInteger.valueOf(0));
			
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_302 = PivotFactory.eINSTANCE.createOperation();
			symbol_302.setName("asSet");
			//symbol_302.setMoniker("ocl!Collection{T}!asSet()");
			symbol_302.setType(symbol_231);  // ocl!Set[ocl!Collection{T}?T]
			symbol_302.setLower(BigInteger.valueOf(0));
			
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_303 = PivotFactory.eINSTANCE.createIteration();
			symbol_33.setName("V");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_303.setOwnedTemplateSignature(symbol_31);
			symbol_303.setName("collect");
			//symbol_303.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_303.setType(symbol_160);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("i");
			symbol_304.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_303.getOwnedIterators().add(symbol_304);
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("body");
			//symbol_305.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_305.setType(symbol_169);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_303.getOwnedParameters().add(symbol_305);
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_303);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_306 = PivotFactory.eINSTANCE.createIteration();
			symbol_36.setName("V");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_306.setOwnedTemplateSignature(symbol_34);
			symbol_306.setName("collectNested");
			//symbol_306.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_306.setType(symbol_145);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("i");
			symbol_307.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_306.getOwnedIterators().add(symbol_307);
			Parameter symbol_308 = PivotFactory.eINSTANCE.createParameter();
			symbol_308.setName("body");
			//symbol_308.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_308.setType(symbol_162);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_306.getOwnedParameters().add(symbol_308);
			symbol_306.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_306);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_309 = PivotFactory.eINSTANCE.createOperation();
			symbol_309.setName("count");
			//symbol_309.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_309.setType(symbol_56);  // Integer
			symbol_309.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("object");
			//symbol_310.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_310.setType(symbol_71);  // ocl!OclAny
			symbol_310.setLower(BigInteger.valueOf(0));
			
			symbol_309.getOwnedParameters().add(symbol_310);
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("excludes");
			//symbol_311.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_311.setType(symbol_19);  // Boolean
			symbol_311.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("object");
			//symbol_312.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_312.setType(symbol_71);  // ocl!OclAny
			symbol_312.setLower(BigInteger.valueOf(0));
			
			symbol_311.getOwnedParameters().add(symbol_312);
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_39.setName("T2");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_313.setOwnedTemplateSignature(symbol_37);
			symbol_313.setName("excludesAll");
			//symbol_313.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_313.setType(symbol_19);  // Boolean
			symbol_313.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_314 = PivotFactory.eINSTANCE.createParameter();
			symbol_314.setName("c2");
			//symbol_314.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_314.setType(symbol_158);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			symbol_314.setLower(BigInteger.valueOf(0));
			
			symbol_313.getOwnedParameters().add(symbol_314);
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_313);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_315.setName("excluding");
			//symbol_315.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_315.setType(symbol_145);  // ocl!Collection[ocl!Collection{T}?T]
			symbol_315.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_316 = PivotFactory.eINSTANCE.createParameter();
			symbol_316.setName("object");
			//symbol_316.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_316.setType(symbol_71);  // ocl!OclAny
			symbol_316.setLower(BigInteger.valueOf(0));
			
			symbol_315.getOwnedParameters().add(symbol_316);
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_317 = PivotFactory.eINSTANCE.createIteration();
			symbol_317.setName("exists");
			//symbol_317.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_317.setType(symbol_19);  // Boolean
			
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("i");
			symbol_318.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_317.getOwnedIterators().add(symbol_318);
			Parameter symbol_319 = PivotFactory.eINSTANCE.createParameter();
			symbol_319.setName("body");
			//symbol_319.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_319.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_317.getOwnedParameters().add(symbol_319);
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_317);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_320 = PivotFactory.eINSTANCE.createIteration();
			symbol_320.setName("exists");
			//symbol_320.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_320.setType(symbol_19);  // Boolean
			
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("i");
			symbol_321.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_320.getOwnedIterators().add(symbol_321);
			Parameter symbol_322 = PivotFactory.eINSTANCE.createParameter();
			symbol_322.setName("j");
			symbol_322.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_320.getOwnedIterators().add(symbol_322);
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("body");
			//symbol_323.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_323.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_320.getOwnedParameters().add(symbol_323);
			symbol_320.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_320);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_42.setName("T2");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_324.setOwnedTemplateSignature(symbol_40);
			symbol_324.setName("flatten");
			//symbol_324.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_324.setType(symbol_154);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			symbol_324.setLower(BigInteger.valueOf(0));
			
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_325 = PivotFactory.eINSTANCE.createIteration();
			symbol_325.setName("forAll");
			//symbol_325.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_325.setType(symbol_19);  // Boolean
			
			Parameter symbol_326 = PivotFactory.eINSTANCE.createParameter();
			symbol_326.setName("i");
			symbol_326.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_325.getOwnedIterators().add(symbol_326);
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("body");
			//symbol_327.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_327.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_325.getOwnedParameters().add(symbol_327);
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_328 = PivotFactory.eINSTANCE.createIteration();
			symbol_328.setName("forAll");
			//symbol_328.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_328.setType(symbol_19);  // Boolean
			
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("i");
			symbol_329.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_328.getOwnedIterators().add(symbol_329);
			Parameter symbol_330 = PivotFactory.eINSTANCE.createParameter();
			symbol_330.setName("j");
			symbol_330.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_328.getOwnedIterators().add(symbol_330);
			Parameter symbol_331 = PivotFactory.eINSTANCE.createParameter();
			symbol_331.setName("body");
			//symbol_331.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_331.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_328.getOwnedParameters().add(symbol_331);
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_332 = PivotFactory.eINSTANCE.createOperation();
			symbol_332.setName("includes");
			//symbol_332.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_332.setType(symbol_19);  // Boolean
			symbol_332.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_333 = PivotFactory.eINSTANCE.createParameter();
			symbol_333.setName("object");
			//symbol_333.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_333.setType(symbol_71);  // ocl!OclAny
			symbol_333.setLower(BigInteger.valueOf(0));
			
			symbol_332.getOwnedParameters().add(symbol_333);
			symbol_332.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_332);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_334 = PivotFactory.eINSTANCE.createOperation();
			symbol_45.setName("T2");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_334.setOwnedTemplateSignature(symbol_43);
			symbol_334.setName("includesAll");
			//symbol_334.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_334.setType(symbol_19);  // Boolean
			symbol_334.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("c2");
			//symbol_335.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_335.setType(symbol_139);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			symbol_335.setLower(BigInteger.valueOf(0));
			
			symbol_334.getOwnedParameters().add(symbol_335);
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_336 = PivotFactory.eINSTANCE.createOperation();
			symbol_336.setName("including");
			//symbol_336.setMoniker("ocl!Collection{T}!including(T)");
			symbol_336.setType(symbol_145);  // ocl!Collection[ocl!Collection{T}?T]
			symbol_336.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("object");
			//symbol_337.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_337.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_337.setLower(BigInteger.valueOf(0));
			
			symbol_336.getOwnedParameters().add(symbol_337);
			symbol_336.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_336);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("isEmpty");
			//symbol_338.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_338.setType(symbol_19);  // Boolean
			symbol_338.setLower(BigInteger.valueOf(0));
			
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)
			Iteration symbol_339 = PivotFactory.eINSTANCE.createIteration();
			symbol_339.setName("isUnique");
			//symbol_339.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)");
			symbol_339.setType(symbol_19);  // Boolean
			
			Parameter symbol_340 = PivotFactory.eINSTANCE.createParameter();
			symbol_340.setName("i");
			symbol_340.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_339.getOwnedIterators().add(symbol_340);
			Parameter symbol_341 = PivotFactory.eINSTANCE.createParameter();
			symbol_341.setName("body");
			//symbol_341.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)!body");
			symbol_341.setType(symbol_168);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_339.getOwnedParameters().add(symbol_341);
			symbol_339.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_339);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_342 = PivotFactory.eINSTANCE.createIteration();
			symbol_48.setName("Tacc");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_342.setOwnedTemplateSignature(symbol_46);
			symbol_342.setName("iterate");
			//symbol_342.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_342.setType(symbol_48);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_343 = PivotFactory.eINSTANCE.createParameter();
			symbol_343.setName("i");
			symbol_343.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_342.getOwnedIterators().add(symbol_343);
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("acc");
			symbol_344.setType(symbol_48);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_342.getOwnedAccumulators().add(symbol_344);
			symbol_342.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_342);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_345.setName("max");
			//symbol_345.setMoniker("ocl!Collection{T}!max()");
			symbol_345.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_345.setLower(BigInteger.valueOf(0));
			
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_345);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_346 = PivotFactory.eINSTANCE.createOperation();
			symbol_346.setName("min");
			//symbol_346.setMoniker("ocl!Collection{T}!min()");
			symbol_346.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_346.setLower(BigInteger.valueOf(0));
			
			symbol_346.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_346);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("notEmpty");
			//symbol_347.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_347.setType(symbol_19);  // Boolean
			symbol_347.setLower(BigInteger.valueOf(0));
			
			symbol_347.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_347);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_348 = PivotFactory.eINSTANCE.createIteration();
			symbol_348.setName("one");
			//symbol_348.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_348.setType(symbol_19);  // Boolean
			
			Parameter symbol_349 = PivotFactory.eINSTANCE.createParameter();
			symbol_349.setName("i");
			symbol_349.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_348.getOwnedIterators().add(symbol_349);
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("body");
			//symbol_350.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_350.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_348.getOwnedParameters().add(symbol_350);
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_348);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_51.setName("T2");
			symbol_50.setOwnedParameteredElement(symbol_51);
			symbol_49.getOwnedParameters().add(symbol_50);
			
			symbol_351.setOwnedTemplateSignature(symbol_49);
			symbol_351.setName("product");
			//symbol_351.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_351.setType(symbol_239);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			symbol_351.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_352 = PivotFactory.eINSTANCE.createParameter();
			symbol_352.setName("c2");
			//symbol_352.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_352.setType(symbol_153);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			symbol_352.setLower(BigInteger.valueOf(0));
			
			symbol_351.getOwnedParameters().add(symbol_352);
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_353 = PivotFactory.eINSTANCE.createIteration();
			symbol_353.setName("reject");
			//symbol_353.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_353.setType(symbol_145);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("i");
			symbol_354.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_353.getOwnedIterators().add(symbol_354);
			Parameter symbol_355 = PivotFactory.eINSTANCE.createParameter();
			symbol_355.setName("body");
			//symbol_355.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_355.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_353.getOwnedParameters().add(symbol_355);
			symbol_353.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_353);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_356 = PivotFactory.eINSTANCE.createIteration();
			symbol_356.setName("select");
			//symbol_356.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_356.setType(symbol_145);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("i");
			symbol_357.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_356.getOwnedIterators().add(symbol_357);
			Parameter symbol_358 = PivotFactory.eINSTANCE.createParameter();
			symbol_358.setName("body");
			//symbol_358.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_358.setType(symbol_177);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_356.getOwnedParameters().add(symbol_358);
			symbol_356.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_356);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_359 = PivotFactory.eINSTANCE.createOperation();
			symbol_359.setName("size");
			//symbol_359.setMoniker("ocl!Collection{T}!size()");
			symbol_359.setType(symbol_56);  // Integer
			symbol_359.setLower(BigInteger.valueOf(0));
			
			symbol_359.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_359);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_360 = PivotFactory.eINSTANCE.createIteration();
			symbol_360.setName("sortedBy");
			//symbol_360.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_360.setType(symbol_208);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_361 = PivotFactory.eINSTANCE.createParameter();
			symbol_361.setName("i");
			symbol_361.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_360.getOwnedIterators().add(symbol_361);
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("body");
			//symbol_362.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_362.setType(symbol_168);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_360.getOwnedParameters().add(symbol_362);
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_363 = PivotFactory.eINSTANCE.createOperation();
			symbol_363.setName("sum");
			//symbol_363.setMoniker("ocl!Collection{T}!sum()");
			symbol_363.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_363.setLower(BigInteger.valueOf(0));
			
			symbol_363.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_363);
		}
		symbol_1.getOwnedTypes().add(symbol_27);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_52.setName("Enumeration");
		//symbol_52.setMoniker("ocl!Enumeration");
		symbol_52.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances{OclSelf}()
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_55.setName("OclSelf");
			symbol_54.setOwnedParameteredElement(symbol_55);
			symbol_53.getOwnedParameters().add(symbol_54);
			
			symbol_364.setOwnedTemplateSignature(symbol_53);
			symbol_364.setName("allInstances");
			//symbol_364.setMoniker("ocl!Enumeration!allInstances{OclSelf}()");
			symbol_364.setType(symbol_232);  // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
			symbol_364.setLower(BigInteger.valueOf(0));
			
			symbol_364.setIsStatic(true);
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_52.getOwnedOperations().add(symbol_364);
		}
		symbol_1.getOwnedTypes().add(symbol_52);
		//
		// ocl::Integer Integer
		//
		symbol_56.setName("Integer");
		//symbol_56.setMoniker("Integer");
		symbol_56.getSuperClasses().add(symbol_103); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_365 = PivotFactory.eINSTANCE.createOperation();
			symbol_365.setName("*");
			//symbol_365.setMoniker("Integer!*(Integer)");
			symbol_365.setType(symbol_56);  // Integer
			symbol_365.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_366 = PivotFactory.eINSTANCE.createParameter();
			symbol_366.setName("i");
			//symbol_366.setMoniker("Integer!*(Integer)!i");
			symbol_366.setType(symbol_56);  // Integer
			symbol_366.setLower(BigInteger.valueOf(0));
			
			symbol_365.getOwnedParameters().add(symbol_366);
			symbol_365.setPrecedence(symbol_4);
			symbol_365.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_365);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_367.setName("+");
			//symbol_367.setMoniker("Integer!+(Integer)");
			symbol_367.setType(symbol_56);  // Integer
			symbol_367.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_368 = PivotFactory.eINSTANCE.createParameter();
			symbol_368.setName("i");
			//symbol_368.setMoniker("Integer!+(Integer)!i");
			symbol_368.setType(symbol_56);  // Integer
			symbol_368.setLower(BigInteger.valueOf(0));
			
			symbol_367.getOwnedParameters().add(symbol_368);
			symbol_367.setPrecedence(symbol_5);
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_369 = PivotFactory.eINSTANCE.createOperation();
			symbol_369.setName("-");
			//symbol_369.setMoniker("Integer!-()");
			symbol_369.setType(symbol_56);  // Integer
			symbol_369.setLower(BigInteger.valueOf(0));
			
			symbol_369.setPrecedence(symbol_3);
			symbol_369.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_369);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_370.setName("-");
			//symbol_370.setMoniker("Integer!-(Integer)");
			symbol_370.setType(symbol_56);  // Integer
			symbol_370.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_371 = PivotFactory.eINSTANCE.createParameter();
			symbol_371.setName("i");
			//symbol_371.setMoniker("Integer!-(Integer)!i");
			symbol_371.setType(symbol_56);  // Integer
			symbol_371.setLower(BigInteger.valueOf(0));
			
			symbol_370.getOwnedParameters().add(symbol_371);
			symbol_370.setPrecedence(symbol_5);
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_370);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_372.setName("/");
			//symbol_372.setMoniker("Integer!/(Integer)");
			symbol_372.setType(symbol_103);  // Real
			symbol_372.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_373 = PivotFactory.eINSTANCE.createParameter();
			symbol_373.setName("i");
			//symbol_373.setMoniker("Integer!/(Integer)!i");
			symbol_373.setType(symbol_56);  // Integer
			symbol_373.setLower(BigInteger.valueOf(0));
			
			symbol_372.getOwnedParameters().add(symbol_373);
			symbol_372.setPrecedence(symbol_4);
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_374 = PivotFactory.eINSTANCE.createOperation();
			symbol_374.setName("abs");
			//symbol_374.setMoniker("Integer!abs()");
			symbol_374.setType(symbol_56);  // Integer
			symbol_374.setLower(BigInteger.valueOf(0));
			
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_375 = PivotFactory.eINSTANCE.createOperation();
			symbol_375.setName("div");
			//symbol_375.setMoniker("Integer!div(Integer)");
			symbol_375.setType(symbol_56);  // Integer
			symbol_375.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("i");
			//symbol_376.setMoniker("Integer!div(Integer)!i");
			symbol_376.setType(symbol_56);  // Integer
			symbol_376.setLower(BigInteger.valueOf(0));
			
			symbol_375.getOwnedParameters().add(symbol_376);
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_375);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_377.setName("max");
			//symbol_377.setMoniker("Integer!max(Integer)");
			symbol_377.setType(symbol_56);  // Integer
			symbol_377.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("i");
			//symbol_378.setMoniker("Integer!max(Integer)!i");
			symbol_378.setType(symbol_56);  // Integer
			symbol_378.setLower(BigInteger.valueOf(0));
			
			symbol_377.getOwnedParameters().add(symbol_378);
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("min");
			//symbol_379.setMoniker("Integer!min(Integer)");
			symbol_379.setType(symbol_56);  // Integer
			symbol_379.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("i");
			//symbol_380.setMoniker("Integer!min(Integer)!i");
			symbol_380.setType(symbol_56);  // Integer
			symbol_380.setLower(BigInteger.valueOf(0));
			
			symbol_379.getOwnedParameters().add(symbol_380);
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_381 = PivotFactory.eINSTANCE.createOperation();
			symbol_381.setName("mod");
			//symbol_381.setMoniker("Integer!mod(Integer)");
			symbol_381.setType(symbol_56);  // Integer
			symbol_381.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_382 = PivotFactory.eINSTANCE.createParameter();
			symbol_382.setName("i");
			//symbol_382.setMoniker("Integer!mod(Integer)!i");
			symbol_382.setType(symbol_56);  // Integer
			symbol_382.setLower(BigInteger.valueOf(0));
			
			symbol_381.getOwnedParameters().add(symbol_382);
			symbol_381.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_381);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_383.setName("toString");
			//symbol_383.setMoniker("Integer!toString()");
			symbol_383.setType(symbol_121);  // String
			symbol_383.setLower(BigInteger.valueOf(0));
			
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_383);
		}
		symbol_1.getOwnedTypes().add(symbol_56);
		//
		// ocl::NonOrderedCollection ocl!NonOrderedCollection{T}
		//
		symbol_57.setName("NonOrderedCollection");
		//symbol_57.setMoniker("ocl!NonOrderedCollection{T}");
		symbol_57.setElementType(symbol_60);
		symbol_60.setName("T");
		symbol_59.setOwnedParameteredElement(symbol_60);
		symbol_58.getOwnedParameters().add(symbol_59);
		
		symbol_57.setOwnedTemplateSignature(symbol_58);
		symbol_57.getSuperClasses().add(symbol_142); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])
			Iteration symbol_384 = PivotFactory.eINSTANCE.createIteration();
			symbol_384.setName("closure");
			//symbol_384.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])");
			symbol_384.setType(symbol_233);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_385 = PivotFactory.eINSTANCE.createParameter();
			symbol_385.setName("i");
			symbol_385.setType(symbol_60);  // ocl!NonOrderedCollection{T}?T
			symbol_384.getOwnedIterators().add(symbol_385);
			Parameter symbol_386 = PivotFactory.eINSTANCE.createParameter();
			symbol_386.setName("body");
			//symbol_386.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])!body");
			symbol_386.setType(symbol_174);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
			
			symbol_384.getOwnedParameters().add(symbol_386);
			symbol_384.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_384);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_387 = PivotFactory.eINSTANCE.createIteration();
			symbol_63.setName("V");
			symbol_62.setOwnedParameteredElement(symbol_63);
			symbol_61.getOwnedParameters().add(symbol_62);
			
			symbol_387.setOwnedTemplateSignature(symbol_61);
			symbol_387.setName("collect");
			//symbol_387.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_387.setType(symbol_129);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_388 = PivotFactory.eINSTANCE.createParameter();
			symbol_388.setName("i");
			symbol_388.setType(symbol_60);  // ocl!NonOrderedCollection{T}?T
			symbol_387.getOwnedIterators().add(symbol_388);
			Parameter symbol_389 = PivotFactory.eINSTANCE.createParameter();
			symbol_389.setName("body");
			//symbol_389.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_389.setType(symbol_171);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_387.getOwnedParameters().add(symbol_389);
			symbol_387.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_387);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_390 = PivotFactory.eINSTANCE.createIteration();
			symbol_66.setName("V");
			symbol_65.setOwnedParameteredElement(symbol_66);
			symbol_64.getOwnedParameters().add(symbol_65);
			
			symbol_390.setOwnedTemplateSignature(symbol_64);
			symbol_390.setName("collectNested");
			//symbol_390.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_390.setType(symbol_131);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_391 = PivotFactory.eINSTANCE.createParameter();
			symbol_391.setName("i");
			symbol_391.setType(symbol_60);  // ocl!NonOrderedCollection{T}?T
			symbol_390.getOwnedIterators().add(symbol_391);
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("body");
			//symbol_392.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_392.setType(symbol_172);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_390.getOwnedParameters().add(symbol_392);
			symbol_390.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_390);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_393 = PivotFactory.eINSTANCE.createOperation();
			symbol_393.setName("intersection");
			//symbol_393.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_393.setType(symbol_131);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_393.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("bag");
			//symbol_394.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_394.setType(symbol_131);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_394.setLower(BigInteger.valueOf(0));
			
			symbol_393.getOwnedParameters().add(symbol_394);
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_393);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_395 = PivotFactory.eINSTANCE.createOperation();
			symbol_395.setName("intersection");
			//symbol_395.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_395.setType(symbol_233);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_395.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_396 = PivotFactory.eINSTANCE.createParameter();
			symbol_396.setName("s");
			//symbol_396.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_396.setType(symbol_233);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_396.setLower(BigInteger.valueOf(0));
			
			symbol_395.getOwnedParameters().add(symbol_396);
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_395);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_397 = PivotFactory.eINSTANCE.createOperation();
			symbol_397.setName("union");
			//symbol_397.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_397.setType(symbol_131);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_397.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_398 = PivotFactory.eINSTANCE.createParameter();
			symbol_398.setName("bag");
			//symbol_398.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_398.setType(symbol_131);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_398.setLower(BigInteger.valueOf(0));
			
			symbol_397.getOwnedParameters().add(symbol_398);
			symbol_397.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_397);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("union");
			//symbol_399.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_399.setType(symbol_233);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_399.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("s");
			//symbol_400.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_400.setType(symbol_233);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_400.setLower(BigInteger.valueOf(0));
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_399);
		}
		symbol_1.getOwnedTypes().add(symbol_57);
		//
		// ocl::NonUniqueCollection ocl!NonUniqueCollection{T}
		//
		symbol_67.setName("NonUniqueCollection");
		//symbol_67.setMoniker("ocl!NonUniqueCollection{T}");
		symbol_67.setElementType(symbol_70);
		symbol_70.setName("T");
		symbol_69.setOwnedParameteredElement(symbol_70);
		symbol_68.getOwnedParameters().add(symbol_69);
		
		symbol_67.setOwnedTemplateSignature(symbol_68);
		symbol_67.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_401 = PivotFactory.eINSTANCE.createIteration();
			symbol_401.setName("sortedBy");
			//symbol_401.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_401.setType(symbol_220);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("i");
			symbol_402.setType(symbol_70);  // ocl!NonUniqueCollection{T}?T
			symbol_401.getOwnedIterators().add(symbol_402);
			Parameter symbol_403 = PivotFactory.eINSTANCE.createParameter();
			symbol_403.setName("body");
			//symbol_403.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_403.setType(symbol_175);  // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
			
			symbol_401.getOwnedParameters().add(symbol_403);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_401);
		}
		symbol_1.getOwnedTypes().add(symbol_67);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_71.setName("OclAny");
		//symbol_71.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_404 = PivotFactory.eINSTANCE.createOperation();
			symbol_404.setName("<>");
			//symbol_404.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_404.setType(symbol_19);  // Boolean
			symbol_404.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_405 = PivotFactory.eINSTANCE.createParameter();
			symbol_405.setName("object2");
			//symbol_405.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_405.setType(symbol_71);  // ocl!OclAny
			symbol_405.setLower(BigInteger.valueOf(0));
			
			symbol_404.getOwnedParameters().add(symbol_405);
			symbol_404.setPrecedence(symbol_7);
			symbol_404.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_404);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_406.setName("=");
			//symbol_406.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_406.setType(symbol_19);  // Boolean
			symbol_406.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_407 = PivotFactory.eINSTANCE.createParameter();
			symbol_407.setName("object2");
			//symbol_407.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_407.setType(symbol_71);  // ocl!OclAny
			symbol_407.setLower(BigInteger.valueOf(0));
			
			symbol_406.getOwnedParameters().add(symbol_407);
			symbol_406.setPrecedence(symbol_7);
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_408 = PivotFactory.eINSTANCE.createOperation();
			symbol_74.setName("OclSelf");
			symbol_73.setOwnedParameteredElement(symbol_74);
			symbol_72.getOwnedParameters().add(symbol_73);
			
			symbol_408.setOwnedTemplateSignature(symbol_72);
			symbol_408.setName("oclAsSet");
			//symbol_408.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_408.setType(symbol_238);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			symbol_408.setLower(BigInteger.valueOf(0));
			
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_408);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{T}(ocl!Classifier)
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_77.setName("T");
			symbol_76.setOwnedParameteredElement(symbol_77);
			symbol_75.getOwnedParameters().add(symbol_76);
			
			symbol_409.setOwnedTemplateSignature(symbol_75);
			symbol_409.setName("oclAsType");
			//symbol_409.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)");
			symbol_409.setType(symbol_77);  // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
			symbol_409.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("type");
			//symbol_410.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)!type");
			symbol_410.setType(symbol_23);  // ocl!Classifier
			symbol_410.setLower(BigInteger.valueOf(0));
			
			symbol_409.getOwnedParameters().add(symbol_410);
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_411.setName("oclIsInState");
			//symbol_411.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_411.setType(symbol_19);  // Boolean
			symbol_411.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("statespec");
			//symbol_412.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_412.setType(symbol_83);  // ocl!OclState
			symbol_412.setLower(BigInteger.valueOf(0));
			
			symbol_411.getOwnedParameters().add(symbol_412);
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_413 = PivotFactory.eINSTANCE.createOperation();
			symbol_413.setName("oclIsInvalid");
			//symbol_413.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_413.setType(symbol_19);  // Boolean
			symbol_413.setLower(BigInteger.valueOf(0));
			
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf(ocl!Classifier)
			Operation symbol_414 = PivotFactory.eINSTANCE.createOperation();
			symbol_414.setName("oclIsKindOf");
			//symbol_414.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)");
			symbol_414.setType(symbol_19);  // Boolean
			symbol_414.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("type");
			//symbol_415.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)!type");
			symbol_415.setType(symbol_23);  // ocl!Classifier
			symbol_415.setLower(BigInteger.valueOf(0));
			
			symbol_414.getOwnedParameters().add(symbol_415);
			symbol_414.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_414);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_416 = PivotFactory.eINSTANCE.createOperation();
			symbol_416.setName("oclIsNew");
			//symbol_416.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_416.setType(symbol_19);  // Boolean
			symbol_416.setLower(BigInteger.valueOf(0));
			
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf(ocl!Classifier)
			Operation symbol_417 = PivotFactory.eINSTANCE.createOperation();
			symbol_417.setName("oclIsTypeOf");
			//symbol_417.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)");
			symbol_417.setType(symbol_19);  // Boolean
			symbol_417.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_418 = PivotFactory.eINSTANCE.createParameter();
			symbol_418.setName("type");
			//symbol_418.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)!type");
			symbol_418.setType(symbol_23);  // ocl!Classifier
			symbol_418.setLower(BigInteger.valueOf(0));
			
			symbol_417.getOwnedParameters().add(symbol_418);
			symbol_417.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_417);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_419 = PivotFactory.eINSTANCE.createOperation();
			symbol_419.setName("oclIsUndefined");
			//symbol_419.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_419.setType(symbol_19);  // Boolean
			symbol_419.setLower(BigInteger.valueOf(0));
			
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType()
			Operation symbol_420 = PivotFactory.eINSTANCE.createOperation();
			symbol_420.setName("oclType");
			//symbol_420.setMoniker("ocl!OclAny!oclType()");
			symbol_420.setType(symbol_23);  // ocl!Classifier
			symbol_420.setLower(BigInteger.valueOf(0));
			
			symbol_420.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_420);
		}
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// ocl::OclInvalid ocl!OclInvalid
		//
		symbol_78.setName("OclInvalid");
		//symbol_78.setMoniker("ocl!OclInvalid");
		symbol_78.getSuperClasses().add(symbol_85); // ocl!OclVoid
		{	// ocl::OclInvalid::<>() ocl!OclInvalid!<>(ocl!OclAny)
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("<>");
			//symbol_421.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_421.setType(symbol_19);  // Boolean
			symbol_421.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_422 = PivotFactory.eINSTANCE.createParameter();
			symbol_422.setName("object2");
			//symbol_422.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_422.setType(symbol_71);  // ocl!OclAny
			symbol_422.setLower(BigInteger.valueOf(0));
			
			symbol_421.getOwnedParameters().add(symbol_422);
			symbol_421.setPrecedence(symbol_7);
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_421);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("=");
			//symbol_423.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_423.setType(symbol_19);  // Boolean
			symbol_423.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("object2");
			//symbol_424.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_424.setType(symbol_71);  // ocl!OclAny
			symbol_424.setLower(BigInteger.valueOf(0));
			
			symbol_423.getOwnedParameters().add(symbol_424);
			symbol_423.setPrecedence(symbol_7);
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_423);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances{OclSelf}()
			Operation symbol_425 = PivotFactory.eINSTANCE.createOperation();
			symbol_81.setName("OclSelf");
			symbol_80.setOwnedParameteredElement(symbol_81);
			symbol_79.getOwnedParameters().add(symbol_80);
			
			symbol_425.setOwnedTemplateSignature(symbol_79);
			symbol_425.setName("allInstances");
			//symbol_425.setMoniker("ocl!OclInvalid!allInstances{OclSelf}()");
			symbol_425.setType(symbol_229);  // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
			symbol_425.setLower(BigInteger.valueOf(0));
			
			symbol_425.setIsStatic(true);
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_425);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_426 = PivotFactory.eINSTANCE.createOperation();
			symbol_426.setName("toString");
			//symbol_426.setMoniker("ocl!OclInvalid!toString()");
			symbol_426.setType(symbol_121);  // String
			symbol_426.setLower(BigInteger.valueOf(0));
			
			symbol_426.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_426);
		}
		symbol_1.getOwnedTypes().add(symbol_78);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_82.setName("OclMessage");
		//symbol_82.setMoniker("ocl!OclMessage");
		symbol_82.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_427 = PivotFactory.eINSTANCE.createOperation();
			symbol_427.setName("hasReturned");
			//symbol_427.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_427.setType(symbol_19);  // Boolean
			symbol_427.setLower(BigInteger.valueOf(0));
			
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("isOperationCall");
			//symbol_428.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_428.setType(symbol_19);  // Boolean
			symbol_428.setLower(BigInteger.valueOf(0));
			
			symbol_428.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_429 = PivotFactory.eINSTANCE.createOperation();
			symbol_429.setName("isSignalSent");
			//symbol_429.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_429.setType(symbol_19);  // Boolean
			symbol_429.setLower(BigInteger.valueOf(0));
			
			symbol_429.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_429);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("result");
			//symbol_430.setMoniker("ocl!OclMessage!result()");
			symbol_430.setType(symbol_71);  // ocl!OclAny
			symbol_430.setLower(BigInteger.valueOf(0));
			
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_430);
		}
		symbol_1.getOwnedTypes().add(symbol_82);
		//
		// ocl::OclState ocl!OclState
		//
		symbol_83.setName("OclState");
		//symbol_83.setMoniker("ocl!OclState");
		symbol_83.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// ocl::OclTuple ocl!OclTuple
		//
		symbol_84.setName("OclTuple");
		//symbol_84.setMoniker("ocl!OclTuple");
		symbol_84.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::OclTuple::<>() ocl!OclTuple!<>(ocl!OclAny)
			Operation symbol_431 = PivotFactory.eINSTANCE.createOperation();
			symbol_431.setName("<>");
			//symbol_431.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_431.setType(symbol_19);  // Boolean
			symbol_431.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_432 = PivotFactory.eINSTANCE.createParameter();
			symbol_432.setName("object2");
			//symbol_432.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_432.setType(symbol_71);  // ocl!OclAny
			symbol_432.setLower(BigInteger.valueOf(0));
			
			symbol_431.getOwnedParameters().add(symbol_432);
			symbol_431.setPrecedence(symbol_7);
			symbol_431.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_84.getOwnedOperations().add(symbol_431);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_433 = PivotFactory.eINSTANCE.createOperation();
			symbol_433.setName("=");
			//symbol_433.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_433.setType(symbol_19);  // Boolean
			symbol_433.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_434 = PivotFactory.eINSTANCE.createParameter();
			symbol_434.setName("object2");
			//symbol_434.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_434.setType(symbol_71);  // ocl!OclAny
			symbol_434.setLower(BigInteger.valueOf(0));
			
			symbol_433.getOwnedParameters().add(symbol_434);
			symbol_433.setPrecedence(symbol_7);
			symbol_433.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_84.getOwnedOperations().add(symbol_433);
		}
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_85.setName("OclVoid");
		//symbol_85.setMoniker("ocl!OclVoid");
		symbol_85.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_435.setName("<>");
			//symbol_435.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_435.setType(symbol_19);  // Boolean
			symbol_435.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_436 = PivotFactory.eINSTANCE.createParameter();
			symbol_436.setName("object2");
			//symbol_436.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_436.setType(symbol_71);  // ocl!OclAny
			symbol_436.setLower(BigInteger.valueOf(0));
			
			symbol_435.getOwnedParameters().add(symbol_436);
			symbol_435.setPrecedence(symbol_7);
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_435);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_437 = PivotFactory.eINSTANCE.createOperation();
			symbol_437.setName("=");
			//symbol_437.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_437.setType(symbol_19);  // Boolean
			symbol_437.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_438 = PivotFactory.eINSTANCE.createParameter();
			symbol_438.setName("object2");
			//symbol_438.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_438.setType(symbol_71);  // ocl!OclAny
			symbol_438.setLower(BigInteger.valueOf(0));
			
			symbol_437.getOwnedParameters().add(symbol_438);
			symbol_437.setPrecedence(symbol_7);
			symbol_437.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_437);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances{OclSelf}()
			Operation symbol_439 = PivotFactory.eINSTANCE.createOperation();
			symbol_88.setName("OclSelf");
			symbol_87.setOwnedParameteredElement(symbol_88);
			symbol_86.getOwnedParameters().add(symbol_87);
			
			symbol_439.setOwnedTemplateSignature(symbol_86);
			symbol_439.setName("allInstances");
			//symbol_439.setMoniker("ocl!OclVoid!allInstances{OclSelf}()");
			symbol_439.setType(symbol_236);  // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
			symbol_439.setLower(BigInteger.valueOf(0));
			
			symbol_439.setIsStatic(true);
			symbol_439.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_439);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("and");
			//symbol_440.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_440.setType(symbol_19);  // Boolean
			symbol_440.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("b");
			//symbol_441.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_441.setType(symbol_19);  // Boolean
			symbol_441.setLower(BigInteger.valueOf(0));
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setPrecedence(symbol_8);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_442 = PivotFactory.eINSTANCE.createOperation();
			symbol_442.setName("implies");
			//symbol_442.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_442.setType(symbol_19);  // Boolean
			symbol_442.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("b");
			//symbol_443.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_443.setType(symbol_19);  // Boolean
			symbol_443.setLower(BigInteger.valueOf(0));
			
			symbol_442.getOwnedParameters().add(symbol_443);
			symbol_442.setPrecedence(symbol_11);
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_444 = PivotFactory.eINSTANCE.createOperation();
			symbol_444.setName("or");
			//symbol_444.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_444.setType(symbol_19);  // Boolean
			symbol_444.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_445 = PivotFactory.eINSTANCE.createParameter();
			symbol_445.setName("b");
			//symbol_445.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_445.setType(symbol_19);  // Boolean
			symbol_445.setLower(BigInteger.valueOf(0));
			
			symbol_444.getOwnedParameters().add(symbol_445);
			symbol_444.setPrecedence(symbol_9);
			symbol_444.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_444);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_446 = PivotFactory.eINSTANCE.createOperation();
			symbol_446.setName("toString");
			//symbol_446.setMoniker("ocl!OclVoid!toString()");
			symbol_446.setType(symbol_121);  // String
			symbol_446.setLower(BigInteger.valueOf(0));
			
			symbol_446.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_446);
		}
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// ocl::OrderedCollection ocl!OrderedCollection{T}
		//
		symbol_89.setName("OrderedCollection");
		//symbol_89.setMoniker("ocl!OrderedCollection{T}");
		symbol_89.setElementType(symbol_92);
		symbol_92.setName("T");
		symbol_91.setOwnedParameteredElement(symbol_92);
		symbol_90.getOwnedParameters().add(symbol_91);
		
		symbol_89.setOwnedTemplateSignature(symbol_90);
		symbol_89.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("at");
			//symbol_447.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_447.setType(symbol_92);  // ocl!OrderedCollection{T}?T
			symbol_447.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("index");
			//symbol_448.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_448.setType(symbol_56);  // Integer
			symbol_448.setLower(BigInteger.valueOf(0));
			
			symbol_447.getOwnedParameters().add(symbol_448);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])
			Iteration symbol_449 = PivotFactory.eINSTANCE.createIteration();
			symbol_449.setName("closure");
			//symbol_449.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])");
			symbol_449.setType(symbol_216);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("i");
			symbol_450.setType(symbol_92);  // ocl!OrderedCollection{T}?T
			symbol_449.getOwnedIterators().add(symbol_450);
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("body");
			//symbol_451.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])!body");
			symbol_451.setType(symbol_170);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
			
			symbol_449.getOwnedParameters().add(symbol_451);
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_449);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_452 = PivotFactory.eINSTANCE.createIteration();
			symbol_95.setName("V");
			symbol_94.setOwnedParameteredElement(symbol_95);
			symbol_93.getOwnedParameters().add(symbol_94);
			
			symbol_452.setOwnedTemplateSignature(symbol_93);
			symbol_452.setName("collect");
			//symbol_452.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_452.setType(symbol_224);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("i");
			symbol_453.setType(symbol_92);  // ocl!OrderedCollection{T}?T
			symbol_452.getOwnedIterators().add(symbol_453);
			Parameter symbol_454 = PivotFactory.eINSTANCE.createParameter();
			symbol_454.setName("body");
			//symbol_454.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_454.setType(symbol_165);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_452.getOwnedParameters().add(symbol_454);
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_455 = PivotFactory.eINSTANCE.createIteration();
			symbol_98.setName("V");
			symbol_97.setOwnedParameteredElement(symbol_98);
			symbol_96.getOwnedParameters().add(symbol_97);
			
			symbol_455.setOwnedTemplateSignature(symbol_96);
			symbol_455.setName("collectNested");
			//symbol_455.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_455.setType(symbol_222);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_456 = PivotFactory.eINSTANCE.createParameter();
			symbol_456.setName("i");
			symbol_456.setType(symbol_92);  // ocl!OrderedCollection{T}?T
			symbol_455.getOwnedIterators().add(symbol_456);
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("body");
			//symbol_457.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_457.setType(symbol_164);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_455.getOwnedParameters().add(symbol_457);
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_455);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("first");
			//symbol_458.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_458.setType(symbol_92);  // ocl!OrderedCollection{T}?T
			symbol_458.setLower(BigInteger.valueOf(0));
			
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_459 = PivotFactory.eINSTANCE.createOperation();
			symbol_459.setName("indexOf");
			//symbol_459.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_459.setType(symbol_56);  // Integer
			symbol_459.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_460 = PivotFactory.eINSTANCE.createParameter();
			symbol_460.setName("obj");
			//symbol_460.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_460.setType(symbol_71);  // ocl!OclAny
			symbol_460.setLower(BigInteger.valueOf(0));
			
			symbol_459.getOwnedParameters().add(symbol_460);
			symbol_459.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_459);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_461 = PivotFactory.eINSTANCE.createOperation();
			symbol_461.setName("last");
			//symbol_461.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_461.setType(symbol_92);  // ocl!OrderedCollection{T}?T
			symbol_461.setLower(BigInteger.valueOf(0));
			
			symbol_461.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_461);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("reverse");
			//symbol_462.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_462.setType(symbol_210);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			symbol_462.setLower(BigInteger.valueOf(0));
			
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_89.getOwnedOperations().add(symbol_462);
		}
		symbol_1.getOwnedTypes().add(symbol_89);
		//
		// ocl::OrderedSet ocl!OrderedSet{T}
		//
		symbol_99.setName("OrderedSet");
		//symbol_99.setMoniker("ocl!OrderedSet{T}");
		symbol_99.setElementType(symbol_102);
		symbol_102.setName("T");
		symbol_101.setOwnedParameteredElement(symbol_102);
		symbol_100.getOwnedParameters().add(symbol_101);
		
		symbol_99.setOwnedTemplateSignature(symbol_100);
		symbol_99.getSuperClasses().add(symbol_246); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_99.getSuperClasses().add(symbol_212); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_463 = PivotFactory.eINSTANCE.createOperation();
			symbol_463.setName("-");
			//symbol_463.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_463.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_463.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_464 = PivotFactory.eINSTANCE.createParameter();
			symbol_464.setName("s");
			//symbol_464.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_464.setType(symbol_228);  // ocl!Set[ocl!OclAny]
			symbol_464.setLower(BigInteger.valueOf(0));
			
			symbol_463.getOwnedParameters().add(symbol_464);
			symbol_463.setPrecedence(symbol_5);
			symbol_463.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_463);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_465 = PivotFactory.eINSTANCE.createOperation();
			symbol_465.setName("<>");
			//symbol_465.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_465.setType(symbol_19);  // Boolean
			symbol_465.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_466 = PivotFactory.eINSTANCE.createParameter();
			symbol_466.setName("object2");
			//symbol_466.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_466.setType(symbol_71);  // ocl!OclAny
			symbol_466.setLower(BigInteger.valueOf(0));
			
			symbol_465.getOwnedParameters().add(symbol_466);
			symbol_465.setPrecedence(symbol_7);
			symbol_465.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_465);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("=");
			//symbol_467.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_467.setType(symbol_19);  // Boolean
			symbol_467.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("object2");
			//symbol_468.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_468.setType(symbol_71);  // ocl!OclAny
			symbol_468.setLower(BigInteger.valueOf(0));
			
			symbol_467.getOwnedParameters().add(symbol_468);
			symbol_467.setPrecedence(symbol_7);
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("append");
			//symbol_469.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_469.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_469.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("object");
			//symbol_470.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_470.setType(symbol_102);  // ocl!OrderedSet{T}?T
			symbol_470.setLower(BigInteger.valueOf(0));
			
			symbol_469.getOwnedParameters().add(symbol_470);
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("excluding");
			//symbol_471.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_471.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_471.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_472 = PivotFactory.eINSTANCE.createParameter();
			symbol_472.setName("object");
			//symbol_472.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_472.setType(symbol_71);  // ocl!OclAny
			symbol_472.setLower(BigInteger.valueOf(0));
			
			symbol_471.getOwnedParameters().add(symbol_472);
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_471);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName("including");
			//symbol_473.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_473.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_473.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_474 = PivotFactory.eINSTANCE.createParameter();
			symbol_474.setName("object");
			//symbol_474.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_474.setType(symbol_102);  // ocl!OrderedSet{T}?T
			symbol_474.setLower(BigInteger.valueOf(0));
			
			symbol_473.getOwnedParameters().add(symbol_474);
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_473);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_475 = PivotFactory.eINSTANCE.createOperation();
			symbol_475.setName("insertAt");
			//symbol_475.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_475.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_475.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_476 = PivotFactory.eINSTANCE.createParameter();
			symbol_476.setName("index");
			//symbol_476.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_476.setType(symbol_56);  // Integer
			symbol_476.setLower(BigInteger.valueOf(0));
			
			symbol_475.getOwnedParameters().add(symbol_476);
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("object");
			//symbol_477.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_477.setType(symbol_102);  // ocl!OrderedSet{T}?T
			symbol_477.setLower(BigInteger.valueOf(0));
			
			symbol_475.getOwnedParameters().add(symbol_477);
			symbol_475.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_475);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("intersection");
			//symbol_478.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_478.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_478.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("o");
			//symbol_479.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_479.setType(symbol_226);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_479.setLower(BigInteger.valueOf(0));
			
			symbol_478.getOwnedParameters().add(symbol_479);
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_480 = PivotFactory.eINSTANCE.createOperation();
			symbol_480.setName("prepend");
			//symbol_480.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_480.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_480.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("object");
			//symbol_481.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_481.setType(symbol_102);  // ocl!OrderedSet{T}?T
			symbol_481.setLower(BigInteger.valueOf(0));
			
			symbol_480.getOwnedParameters().add(symbol_481);
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_482 = PivotFactory.eINSTANCE.createIteration();
			symbol_482.setName("reject");
			//symbol_482.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_482.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_483 = PivotFactory.eINSTANCE.createParameter();
			symbol_483.setName("i");
			symbol_483.setType(symbol_102);  // ocl!OrderedSet{T}?T
			symbol_482.getOwnedIterators().add(symbol_483);
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("body");
			//symbol_484.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_484.setType(symbol_176);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_482.getOwnedParameters().add(symbol_484);
			symbol_482.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_482);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_485 = PivotFactory.eINSTANCE.createOperation();
			symbol_485.setName("reverse");
			//symbol_485.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_485.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_485.setLower(BigInteger.valueOf(0));
			
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_486 = PivotFactory.eINSTANCE.createIteration();
			symbol_486.setName("select");
			//symbol_486.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_486.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("i");
			symbol_487.setType(symbol_102);  // ocl!OrderedSet{T}?T
			symbol_486.getOwnedIterators().add(symbol_487);
			Parameter symbol_488 = PivotFactory.eINSTANCE.createParameter();
			symbol_488.setName("body");
			//symbol_488.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_488.setType(symbol_176);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_486.getOwnedParameters().add(symbol_488);
			symbol_486.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_486);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_489 = PivotFactory.eINSTANCE.createOperation();
			symbol_489.setName("subOrderedSet");
			//symbol_489.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_489.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_489.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("lower");
			//symbol_490.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_490.setType(symbol_56);  // Integer
			symbol_490.setLower(BigInteger.valueOf(0));
			
			symbol_489.getOwnedParameters().add(symbol_490);
			Parameter symbol_491 = PivotFactory.eINSTANCE.createParameter();
			symbol_491.setName("upper");
			//symbol_491.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_491.setType(symbol_56);  // Integer
			symbol_491.setLower(BigInteger.valueOf(0));
			
			symbol_489.getOwnedParameters().add(symbol_491);
			symbol_489.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_489);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_492 = PivotFactory.eINSTANCE.createOperation();
			symbol_492.setName("symmetricDifference");
			//symbol_492.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_492.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_492.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("s");
			//symbol_493.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_493.setType(symbol_228);  // ocl!Set[ocl!OclAny]
			symbol_493.setLower(BigInteger.valueOf(0));
			
			symbol_492.getOwnedParameters().add(symbol_493);
			symbol_492.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_492);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_494 = PivotFactory.eINSTANCE.createOperation();
			symbol_494.setName("union");
			//symbol_494.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_494.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_494.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_495 = PivotFactory.eINSTANCE.createParameter();
			symbol_495.setName("o");
			//symbol_495.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_495.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_495.setLower(BigInteger.valueOf(0));
			
			symbol_494.getOwnedParameters().add(symbol_495);
			symbol_494.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_494);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_496 = PivotFactory.eINSTANCE.createOperation();
			symbol_496.setName("union");
			//symbol_496.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_496.setType(symbol_226);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_496.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_497 = PivotFactory.eINSTANCE.createParameter();
			symbol_497.setName("s");
			//symbol_497.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_497.setType(symbol_226);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_497.setLower(BigInteger.valueOf(0));
			
			symbol_496.getOwnedParameters().add(symbol_497);
			symbol_496.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_99.getOwnedOperations().add(symbol_496);
		}
		symbol_1.getOwnedTypes().add(symbol_99);
		//
		// ocl::Real Real
		//
		symbol_103.setName("Real");
		//symbol_103.setMoniker("Real");
		symbol_103.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("*");
			//symbol_498.setMoniker("Real!*(Real)");
			symbol_498.setType(symbol_103);  // Real
			symbol_498.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_499 = PivotFactory.eINSTANCE.createParameter();
			symbol_499.setName("r");
			//symbol_499.setMoniker("Real!*(Real)!r");
			symbol_499.setType(symbol_103);  // Real
			symbol_499.setLower(BigInteger.valueOf(0));
			
			symbol_498.getOwnedParameters().add(symbol_499);
			symbol_498.setPrecedence(symbol_4);
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_500 = PivotFactory.eINSTANCE.createOperation();
			symbol_500.setName("+");
			//symbol_500.setMoniker("Real!+(Real)");
			symbol_500.setType(symbol_103);  // Real
			symbol_500.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_501 = PivotFactory.eINSTANCE.createParameter();
			symbol_501.setName("r");
			//symbol_501.setMoniker("Real!+(Real)!r");
			symbol_501.setType(symbol_103);  // Real
			symbol_501.setLower(BigInteger.valueOf(0));
			
			symbol_500.getOwnedParameters().add(symbol_501);
			symbol_500.setPrecedence(symbol_5);
			symbol_500.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_500);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_502 = PivotFactory.eINSTANCE.createOperation();
			symbol_502.setName("-");
			//symbol_502.setMoniker("Real!-(Real)");
			symbol_502.setType(symbol_103);  // Real
			symbol_502.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_503 = PivotFactory.eINSTANCE.createParameter();
			symbol_503.setName("r");
			//symbol_503.setMoniker("Real!-(Real)!r");
			symbol_503.setType(symbol_103);  // Real
			symbol_503.setLower(BigInteger.valueOf(0));
			
			symbol_502.getOwnedParameters().add(symbol_503);
			symbol_502.setPrecedence(symbol_5);
			symbol_502.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_502);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_504 = PivotFactory.eINSTANCE.createOperation();
			symbol_504.setName("-");
			//symbol_504.setMoniker("Real!-()");
			symbol_504.setType(symbol_103);  // Real
			symbol_504.setLower(BigInteger.valueOf(0));
			
			symbol_504.setPrecedence(symbol_3);
			symbol_504.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_504);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("/");
			//symbol_505.setMoniker("Real!/(Real)");
			symbol_505.setType(symbol_103);  // Real
			symbol_505.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("r");
			//symbol_506.setMoniker("Real!/(Real)!r");
			symbol_506.setType(symbol_103);  // Real
			symbol_506.setLower(BigInteger.valueOf(0));
			
			symbol_505.getOwnedParameters().add(symbol_506);
			symbol_505.setPrecedence(symbol_4);
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("<");
			//symbol_507.setMoniker("Real!<(Real)");
			symbol_507.setType(symbol_19);  // Boolean
			symbol_507.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("r");
			//symbol_508.setMoniker("Real!<(Real)!r");
			symbol_508.setType(symbol_103);  // Real
			symbol_508.setLower(BigInteger.valueOf(0));
			
			symbol_507.getOwnedParameters().add(symbol_508);
			symbol_507.setPrecedence(symbol_6);
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_509.setName("<=");
			//symbol_509.setMoniker("Real!<=(Real)");
			symbol_509.setType(symbol_19);  // Boolean
			symbol_509.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_510 = PivotFactory.eINSTANCE.createParameter();
			symbol_510.setName("r");
			//symbol_510.setMoniker("Real!<=(Real)!r");
			symbol_510.setType(symbol_103);  // Real
			symbol_510.setLower(BigInteger.valueOf(0));
			
			symbol_509.getOwnedParameters().add(symbol_510);
			symbol_509.setPrecedence(symbol_6);
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_511 = PivotFactory.eINSTANCE.createOperation();
			symbol_511.setName("<>");
			//symbol_511.setMoniker("Real!<>(ocl!OclAny)");
			symbol_511.setType(symbol_19);  // Boolean
			symbol_511.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_512 = PivotFactory.eINSTANCE.createParameter();
			symbol_512.setName("object2");
			//symbol_512.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_512.setType(symbol_71);  // ocl!OclAny
			symbol_512.setLower(BigInteger.valueOf(0));
			
			symbol_511.getOwnedParameters().add(symbol_512);
			symbol_511.setPrecedence(symbol_7);
			symbol_511.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_511);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_513 = PivotFactory.eINSTANCE.createOperation();
			symbol_513.setName("=");
			//symbol_513.setMoniker("Real!=(ocl!OclAny)");
			symbol_513.setType(symbol_19);  // Boolean
			symbol_513.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_514 = PivotFactory.eINSTANCE.createParameter();
			symbol_514.setName("object2");
			//symbol_514.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_514.setType(symbol_71);  // ocl!OclAny
			symbol_514.setLower(BigInteger.valueOf(0));
			
			symbol_513.getOwnedParameters().add(symbol_514);
			symbol_513.setPrecedence(symbol_7);
			symbol_513.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_513);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_515 = PivotFactory.eINSTANCE.createOperation();
			symbol_515.setName(">");
			//symbol_515.setMoniker("Real!>(Real)");
			symbol_515.setType(symbol_19);  // Boolean
			symbol_515.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("r");
			//symbol_516.setMoniker("Real!>(Real)!r");
			symbol_516.setType(symbol_103);  // Real
			symbol_516.setLower(BigInteger.valueOf(0));
			
			symbol_515.getOwnedParameters().add(symbol_516);
			symbol_515.setPrecedence(symbol_6);
			symbol_515.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_515);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName(">=");
			//symbol_517.setMoniker("Real!>=(Real)");
			symbol_517.setType(symbol_19);  // Boolean
			symbol_517.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("r");
			//symbol_518.setMoniker("Real!>=(Real)!r");
			symbol_518.setType(symbol_103);  // Real
			symbol_518.setLower(BigInteger.valueOf(0));
			
			symbol_517.getOwnedParameters().add(symbol_518);
			symbol_517.setPrecedence(symbol_6);
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_519 = PivotFactory.eINSTANCE.createOperation();
			symbol_519.setName("abs");
			//symbol_519.setMoniker("Real!abs()");
			symbol_519.setType(symbol_103);  // Real
			symbol_519.setLower(BigInteger.valueOf(0));
			
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_520 = PivotFactory.eINSTANCE.createOperation();
			symbol_520.setName("floor");
			//symbol_520.setMoniker("Real!floor()");
			symbol_520.setType(symbol_56);  // Integer
			symbol_520.setLower(BigInteger.valueOf(0));
			
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_521 = PivotFactory.eINSTANCE.createOperation();
			symbol_521.setName("max");
			//symbol_521.setMoniker("Real!max(Real)");
			symbol_521.setType(symbol_103);  // Real
			symbol_521.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_522 = PivotFactory.eINSTANCE.createParameter();
			symbol_522.setName("r");
			//symbol_522.setMoniker("Real!max(Real)!r");
			symbol_522.setType(symbol_103);  // Real
			symbol_522.setLower(BigInteger.valueOf(0));
			
			symbol_521.getOwnedParameters().add(symbol_522);
			symbol_521.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_521);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("min");
			//symbol_523.setMoniker("Real!min(Real)");
			symbol_523.setType(symbol_103);  // Real
			symbol_523.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_524 = PivotFactory.eINSTANCE.createParameter();
			symbol_524.setName("r");
			//symbol_524.setMoniker("Real!min(Real)!r");
			symbol_524.setType(symbol_103);  // Real
			symbol_524.setLower(BigInteger.valueOf(0));
			
			symbol_523.getOwnedParameters().add(symbol_524);
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{T}(ocl!Classifier)
			Operation symbol_525 = PivotFactory.eINSTANCE.createOperation();
			symbol_106.setName("T");
			symbol_105.setOwnedParameteredElement(symbol_106);
			symbol_104.getOwnedParameters().add(symbol_105);
			
			symbol_525.setOwnedTemplateSignature(symbol_104);
			symbol_525.setName("oclAsType");
			//symbol_525.setMoniker("Real!oclAsType{T}(ocl!Classifier)");
			symbol_525.setType(symbol_106);  // Real!oclAsType{T}(ocl!Classifier)?T
			symbol_525.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_526 = PivotFactory.eINSTANCE.createParameter();
			symbol_526.setName("type");
			//symbol_526.setMoniker("Real!oclAsType{T}(ocl!Classifier)!type");
			symbol_526.setType(symbol_23);  // ocl!Classifier
			symbol_526.setLower(BigInteger.valueOf(0));
			
			symbol_525.getOwnedParameters().add(symbol_526);
			symbol_525.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_525);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_527 = PivotFactory.eINSTANCE.createOperation();
			symbol_527.setName("round");
			//symbol_527.setMoniker("Real!round()");
			symbol_527.setType(symbol_56);  // Integer
			symbol_527.setLower(BigInteger.valueOf(0));
			
			symbol_527.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_527);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_528 = PivotFactory.eINSTANCE.createOperation();
			symbol_528.setName("toString");
			//symbol_528.setMoniker("Real!toString()");
			symbol_528.setType(symbol_121);  // String
			symbol_528.setLower(BigInteger.valueOf(0));
			
			symbol_528.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_528);
		}
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// ocl::Sequence ocl!Sequence{T}
		//
		symbol_107.setName("Sequence");
		//symbol_107.setMoniker("ocl!Sequence{T}");
		symbol_107.setElementType(symbol_110);
		symbol_110.setName("T");
		symbol_109.setOwnedParameteredElement(symbol_110);
		symbol_108.getOwnedParameters().add(symbol_109);
		
		symbol_107.setOwnedTemplateSignature(symbol_108);
		symbol_107.getSuperClasses().add(symbol_213); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_107.getSuperClasses().add(symbol_204); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_529 = PivotFactory.eINSTANCE.createOperation();
			symbol_529.setName("<>");
			//symbol_529.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_529.setType(symbol_19);  // Boolean
			symbol_529.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_530 = PivotFactory.eINSTANCE.createParameter();
			symbol_530.setName("object2");
			//symbol_530.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_530.setType(symbol_71);  // ocl!OclAny
			symbol_530.setLower(BigInteger.valueOf(0));
			
			symbol_529.getOwnedParameters().add(symbol_530);
			symbol_529.setPrecedence(symbol_7);
			symbol_529.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_529);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_531 = PivotFactory.eINSTANCE.createOperation();
			symbol_531.setName("=");
			//symbol_531.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_531.setType(symbol_19);  // Boolean
			symbol_531.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_532 = PivotFactory.eINSTANCE.createParameter();
			symbol_532.setName("object2");
			//symbol_532.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_532.setType(symbol_71);  // ocl!OclAny
			symbol_532.setLower(BigInteger.valueOf(0));
			
			symbol_531.getOwnedParameters().add(symbol_532);
			symbol_531.setPrecedence(symbol_7);
			symbol_531.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_531);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_533 = PivotFactory.eINSTANCE.createOperation();
			symbol_533.setName("append");
			//symbol_533.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_533.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_533.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_534 = PivotFactory.eINSTANCE.createParameter();
			symbol_534.setName("object");
			//symbol_534.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_534.setType(symbol_110);  // ocl!Sequence{T}?T
			symbol_534.setLower(BigInteger.valueOf(0));
			
			symbol_533.getOwnedParameters().add(symbol_534);
			symbol_533.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_533);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_535 = PivotFactory.eINSTANCE.createOperation();
			symbol_535.setName("excluding");
			//symbol_535.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_535.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_535.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_536 = PivotFactory.eINSTANCE.createParameter();
			symbol_536.setName("object");
			//symbol_536.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_536.setType(symbol_71);  // ocl!OclAny
			symbol_536.setLower(BigInteger.valueOf(0));
			
			symbol_535.getOwnedParameters().add(symbol_536);
			symbol_535.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_535);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_537 = PivotFactory.eINSTANCE.createOperation();
			symbol_113.setName("T2");
			symbol_112.setOwnedParameteredElement(symbol_113);
			symbol_111.getOwnedParameters().add(symbol_112);
			
			symbol_537.setOwnedTemplateSignature(symbol_111);
			symbol_537.setName("flatten");
			//symbol_537.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_537.setType(symbol_225);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			symbol_537.setLower(BigInteger.valueOf(0));
			
			symbol_537.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_537);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_538 = PivotFactory.eINSTANCE.createOperation();
			symbol_538.setName("including");
			//symbol_538.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_538.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_538.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_539 = PivotFactory.eINSTANCE.createParameter();
			symbol_539.setName("object");
			//symbol_539.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_539.setType(symbol_110);  // ocl!Sequence{T}?T
			symbol_539.setLower(BigInteger.valueOf(0));
			
			symbol_538.getOwnedParameters().add(symbol_539);
			symbol_538.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_538);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_540 = PivotFactory.eINSTANCE.createOperation();
			symbol_540.setName("insertAt");
			//symbol_540.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_540.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_540.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_541 = PivotFactory.eINSTANCE.createParameter();
			symbol_541.setName("index");
			//symbol_541.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_541.setType(symbol_56);  // Integer
			symbol_541.setLower(BigInteger.valueOf(0));
			
			symbol_540.getOwnedParameters().add(symbol_541);
			Parameter symbol_542 = PivotFactory.eINSTANCE.createParameter();
			symbol_542.setName("object");
			//symbol_542.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_542.setType(symbol_110);  // ocl!Sequence{T}?T
			symbol_542.setLower(BigInteger.valueOf(0));
			
			symbol_540.getOwnedParameters().add(symbol_542);
			symbol_540.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_540);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_543 = PivotFactory.eINSTANCE.createOperation();
			symbol_543.setName("prepend");
			//symbol_543.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_543.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_543.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_544 = PivotFactory.eINSTANCE.createParameter();
			symbol_544.setName("object");
			//symbol_544.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_544.setType(symbol_110);  // ocl!Sequence{T}?T
			symbol_544.setLower(BigInteger.valueOf(0));
			
			symbol_543.getOwnedParameters().add(symbol_544);
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_543);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_545 = PivotFactory.eINSTANCE.createIteration();
			symbol_545.setName("reject");
			//symbol_545.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_545.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_546 = PivotFactory.eINSTANCE.createParameter();
			symbol_546.setName("i");
			symbol_546.setType(symbol_110);  // ocl!Sequence{T}?T
			symbol_545.getOwnedIterators().add(symbol_546);
			Parameter symbol_547 = PivotFactory.eINSTANCE.createParameter();
			symbol_547.setName("body");
			//symbol_547.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_547.setType(symbol_166);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_545.getOwnedParameters().add(symbol_547);
			symbol_545.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_545);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_548 = PivotFactory.eINSTANCE.createOperation();
			symbol_548.setName("reverse");
			//symbol_548.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_548.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_548.setLower(BigInteger.valueOf(0));
			
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_549 = PivotFactory.eINSTANCE.createIteration();
			symbol_549.setName("select");
			//symbol_549.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_549.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_550 = PivotFactory.eINSTANCE.createParameter();
			symbol_550.setName("i");
			symbol_550.setType(symbol_110);  // ocl!Sequence{T}?T
			symbol_549.getOwnedIterators().add(symbol_550);
			Parameter symbol_551 = PivotFactory.eINSTANCE.createParameter();
			symbol_551.setName("body");
			//symbol_551.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_551.setType(symbol_166);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_549.getOwnedParameters().add(symbol_551);
			symbol_549.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_549);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_552 = PivotFactory.eINSTANCE.createOperation();
			symbol_552.setName("subSequence");
			//symbol_552.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_552.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_552.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_553 = PivotFactory.eINSTANCE.createParameter();
			symbol_553.setName("lower");
			//symbol_553.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_553.setType(symbol_56);  // Integer
			symbol_553.setLower(BigInteger.valueOf(0));
			
			symbol_552.getOwnedParameters().add(symbol_553);
			Parameter symbol_554 = PivotFactory.eINSTANCE.createParameter();
			symbol_554.setName("upper");
			//symbol_554.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_554.setType(symbol_56);  // Integer
			symbol_554.setLower(BigInteger.valueOf(0));
			
			symbol_552.getOwnedParameters().add(symbol_554);
			symbol_552.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_552);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("union");
			//symbol_555.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_555.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_555.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_556 = PivotFactory.eINSTANCE.createParameter();
			symbol_556.setName("s");
			//symbol_556.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_556.setType(symbol_223);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_556.setLower(BigInteger.valueOf(0));
			
			symbol_555.getOwnedParameters().add(symbol_556);
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_107.getOwnedOperations().add(symbol_555);
		}
		symbol_1.getOwnedTypes().add(symbol_107);
		//
		// ocl::Set ocl!Set{T}
		//
		symbol_114.setName("Set");
		//symbol_114.setMoniker("ocl!Set{T}");
		symbol_114.setElementType(symbol_117);
		symbol_117.setName("T");
		symbol_116.setOwnedParameteredElement(symbol_117);
		symbol_115.getOwnedParameters().add(symbol_116);
		
		symbol_114.setOwnedTemplateSignature(symbol_115);
		symbol_114.getSuperClasses().add(symbol_244); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_114.getSuperClasses().add(symbol_178); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_557 = PivotFactory.eINSTANCE.createOperation();
			symbol_557.setName("-");
			//symbol_557.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_557.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			symbol_557.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_558 = PivotFactory.eINSTANCE.createParameter();
			symbol_558.setName("s");
			//symbol_558.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_558.setType(symbol_228);  // ocl!Set[ocl!OclAny]
			symbol_558.setLower(BigInteger.valueOf(0));
			
			symbol_557.getOwnedParameters().add(symbol_558);
			symbol_557.setPrecedence(symbol_5);
			symbol_557.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_557);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_559 = PivotFactory.eINSTANCE.createOperation();
			symbol_559.setName("<>");
			//symbol_559.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_559.setType(symbol_19);  // Boolean
			symbol_559.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_560 = PivotFactory.eINSTANCE.createParameter();
			symbol_560.setName("object2");
			//symbol_560.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_560.setType(symbol_71);  // ocl!OclAny
			symbol_560.setLower(BigInteger.valueOf(0));
			
			symbol_559.getOwnedParameters().add(symbol_560);
			symbol_559.setPrecedence(symbol_7);
			symbol_559.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_559);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_561 = PivotFactory.eINSTANCE.createOperation();
			symbol_561.setName("=");
			//symbol_561.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_561.setType(symbol_19);  // Boolean
			symbol_561.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_562 = PivotFactory.eINSTANCE.createParameter();
			symbol_562.setName("object2");
			//symbol_562.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_562.setType(symbol_71);  // ocl!OclAny
			symbol_562.setLower(BigInteger.valueOf(0));
			
			symbol_561.getOwnedParameters().add(symbol_562);
			symbol_561.setPrecedence(symbol_7);
			symbol_561.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_561);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_563 = PivotFactory.eINSTANCE.createOperation();
			symbol_563.setName("excluding");
			//symbol_563.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_563.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			symbol_563.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_564 = PivotFactory.eINSTANCE.createParameter();
			symbol_564.setName("object");
			//symbol_564.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_564.setType(symbol_71);  // ocl!OclAny
			symbol_564.setLower(BigInteger.valueOf(0));
			
			symbol_563.getOwnedParameters().add(symbol_564);
			symbol_563.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_563);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_565 = PivotFactory.eINSTANCE.createOperation();
			symbol_120.setName("T2");
			symbol_119.setOwnedParameteredElement(symbol_120);
			symbol_118.getOwnedParameters().add(symbol_119);
			
			symbol_565.setOwnedTemplateSignature(symbol_118);
			symbol_565.setName("flatten");
			//symbol_565.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_565.setType(symbol_230);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			symbol_565.setLower(BigInteger.valueOf(0));
			
			symbol_565.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_565);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_566 = PivotFactory.eINSTANCE.createOperation();
			symbol_566.setName("including");
			//symbol_566.setMoniker("ocl!Set{T}!including(T)");
			symbol_566.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			symbol_566.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_567 = PivotFactory.eINSTANCE.createParameter();
			symbol_567.setName("object");
			//symbol_567.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_567.setType(symbol_117);  // ocl!Set{T}?T
			symbol_567.setLower(BigInteger.valueOf(0));
			
			symbol_566.getOwnedParameters().add(symbol_567);
			symbol_566.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_566);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_568 = PivotFactory.eINSTANCE.createOperation();
			symbol_568.setName("intersection");
			//symbol_568.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_568.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			symbol_568.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_569 = PivotFactory.eINSTANCE.createParameter();
			symbol_569.setName("s");
			//symbol_569.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_569.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			symbol_569.setLower(BigInteger.valueOf(0));
			
			symbol_568.getOwnedParameters().add(symbol_569);
			symbol_568.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_568);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_570 = PivotFactory.eINSTANCE.createIteration();
			symbol_570.setName("reject");
			//symbol_570.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_570.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_571 = PivotFactory.eINSTANCE.createParameter();
			symbol_571.setName("i");
			symbol_571.setType(symbol_117);  // ocl!Set{T}?T
			symbol_570.getOwnedIterators().add(symbol_571);
			Parameter symbol_572 = PivotFactory.eINSTANCE.createParameter();
			symbol_572.setName("body");
			//symbol_572.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_572.setType(symbol_167);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_570.getOwnedParameters().add(symbol_572);
			symbol_570.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_570);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_573 = PivotFactory.eINSTANCE.createIteration();
			symbol_573.setName("select");
			//symbol_573.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_573.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_574 = PivotFactory.eINSTANCE.createParameter();
			symbol_574.setName("i");
			symbol_574.setType(symbol_117);  // ocl!Set{T}?T
			symbol_573.getOwnedIterators().add(symbol_574);
			Parameter symbol_575 = PivotFactory.eINSTANCE.createParameter();
			symbol_575.setName("body");
			//symbol_575.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_575.setType(symbol_167);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_573.getOwnedParameters().add(symbol_575);
			symbol_573.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_573);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_576 = PivotFactory.eINSTANCE.createOperation();
			symbol_576.setName("symmetricDifference");
			//symbol_576.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_576.setType(symbol_237);  // ocl!Set[ocl!Set{T}?T]
			symbol_576.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_577 = PivotFactory.eINSTANCE.createParameter();
			symbol_577.setName("s");
			//symbol_577.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_577.setType(symbol_228);  // ocl!Set[ocl!OclAny]
			symbol_577.setLower(BigInteger.valueOf(0));
			
			symbol_576.getOwnedParameters().add(symbol_577);
			symbol_576.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_114.getOwnedOperations().add(symbol_576);
		}
		symbol_1.getOwnedTypes().add(symbol_114);
		//
		// ocl::String String
		//
		symbol_121.setName("String");
		//symbol_121.setMoniker("String");
		symbol_121.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_578 = PivotFactory.eINSTANCE.createOperation();
			symbol_578.setName("+");
			//symbol_578.setMoniker("String!+(String)");
			symbol_578.setType(symbol_121);  // String
			symbol_578.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_579 = PivotFactory.eINSTANCE.createParameter();
			symbol_579.setName("s");
			//symbol_579.setMoniker("String!+(String)!s");
			symbol_579.setType(symbol_121);  // String
			symbol_579.setLower(BigInteger.valueOf(0));
			
			symbol_578.getOwnedParameters().add(symbol_579);
			symbol_578.setPrecedence(symbol_5);
			symbol_578.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_578);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_580 = PivotFactory.eINSTANCE.createOperation();
			symbol_580.setName("<");
			//symbol_580.setMoniker("String!<(String)");
			symbol_580.setType(symbol_19);  // Boolean
			symbol_580.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_581 = PivotFactory.eINSTANCE.createParameter();
			symbol_581.setName("s");
			//symbol_581.setMoniker("String!<(String)!s");
			symbol_581.setType(symbol_121);  // String
			symbol_581.setLower(BigInteger.valueOf(0));
			
			symbol_580.getOwnedParameters().add(symbol_581);
			symbol_580.setPrecedence(symbol_6);
			symbol_580.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_580);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_582 = PivotFactory.eINSTANCE.createOperation();
			symbol_582.setName("<=");
			//symbol_582.setMoniker("String!<=(String)");
			symbol_582.setType(symbol_19);  // Boolean
			symbol_582.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_583 = PivotFactory.eINSTANCE.createParameter();
			symbol_583.setName("s");
			//symbol_583.setMoniker("String!<=(String)!s");
			symbol_583.setType(symbol_121);  // String
			symbol_583.setLower(BigInteger.valueOf(0));
			
			symbol_582.getOwnedParameters().add(symbol_583);
			symbol_582.setPrecedence(symbol_6);
			symbol_582.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_582);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_584 = PivotFactory.eINSTANCE.createOperation();
			symbol_584.setName("<>");
			//symbol_584.setMoniker("String!<>(ocl!OclAny)");
			symbol_584.setType(symbol_19);  // Boolean
			symbol_584.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_585 = PivotFactory.eINSTANCE.createParameter();
			symbol_585.setName("object2");
			//symbol_585.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_585.setType(symbol_71);  // ocl!OclAny
			symbol_585.setLower(BigInteger.valueOf(0));
			
			symbol_584.getOwnedParameters().add(symbol_585);
			symbol_584.setPrecedence(symbol_7);
			symbol_584.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_584);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_586 = PivotFactory.eINSTANCE.createOperation();
			symbol_586.setName("=");
			//symbol_586.setMoniker("String!=(ocl!OclAny)");
			symbol_586.setType(symbol_19);  // Boolean
			symbol_586.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_587 = PivotFactory.eINSTANCE.createParameter();
			symbol_587.setName("object2");
			//symbol_587.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_587.setType(symbol_71);  // ocl!OclAny
			symbol_587.setLower(BigInteger.valueOf(0));
			
			symbol_586.getOwnedParameters().add(symbol_587);
			symbol_586.setPrecedence(symbol_7);
			symbol_586.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_586);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_588 = PivotFactory.eINSTANCE.createOperation();
			symbol_588.setName(">");
			//symbol_588.setMoniker("String!>(String)");
			symbol_588.setType(symbol_19);  // Boolean
			symbol_588.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_589 = PivotFactory.eINSTANCE.createParameter();
			symbol_589.setName("s");
			//symbol_589.setMoniker("String!>(String)!s");
			symbol_589.setType(symbol_121);  // String
			symbol_589.setLower(BigInteger.valueOf(0));
			
			symbol_588.getOwnedParameters().add(symbol_589);
			symbol_588.setPrecedence(symbol_6);
			symbol_588.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_588);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_590 = PivotFactory.eINSTANCE.createOperation();
			symbol_590.setName(">=");
			//symbol_590.setMoniker("String!>=(String)");
			symbol_590.setType(symbol_19);  // Boolean
			symbol_590.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_591 = PivotFactory.eINSTANCE.createParameter();
			symbol_591.setName("s");
			//symbol_591.setMoniker("String!>=(String)!s");
			symbol_591.setType(symbol_121);  // String
			symbol_591.setLower(BigInteger.valueOf(0));
			
			symbol_590.getOwnedParameters().add(symbol_591);
			symbol_590.setPrecedence(symbol_6);
			symbol_590.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_590);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_592 = PivotFactory.eINSTANCE.createOperation();
			symbol_592.setName("at");
			//symbol_592.setMoniker("String!at(Integer)");
			symbol_592.setType(symbol_121);  // String
			symbol_592.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_593 = PivotFactory.eINSTANCE.createParameter();
			symbol_593.setName("i");
			//symbol_593.setMoniker("String!at(Integer)!i");
			symbol_593.setType(symbol_56);  // Integer
			symbol_593.setLower(BigInteger.valueOf(0));
			
			symbol_592.getOwnedParameters().add(symbol_593);
			symbol_592.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_592);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_594 = PivotFactory.eINSTANCE.createOperation();
			symbol_594.setName("characters");
			//symbol_594.setMoniker("String!characters()");
			symbol_594.setType(symbol_219);  // ocl!Sequence[String]
			symbol_594.setLower(BigInteger.valueOf(0));
			
			symbol_594.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_594);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_595 = PivotFactory.eINSTANCE.createOperation();
			symbol_595.setName("concat");
			//symbol_595.setMoniker("String!concat(String)");
			symbol_595.setType(symbol_121);  // String
			symbol_595.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_596 = PivotFactory.eINSTANCE.createParameter();
			symbol_596.setName("s");
			//symbol_596.setMoniker("String!concat(String)!s");
			symbol_596.setType(symbol_121);  // String
			symbol_596.setLower(BigInteger.valueOf(0));
			
			symbol_595.getOwnedParameters().add(symbol_596);
			symbol_595.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_595);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_597 = PivotFactory.eINSTANCE.createOperation();
			symbol_597.setName("equalsIgnoreCase");
			//symbol_597.setMoniker("String!equalsIgnoreCase(String)");
			symbol_597.setType(symbol_19);  // Boolean
			symbol_597.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_598 = PivotFactory.eINSTANCE.createParameter();
			symbol_598.setName("s");
			//symbol_598.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_598.setType(symbol_121);  // String
			symbol_598.setLower(BigInteger.valueOf(0));
			
			symbol_597.getOwnedParameters().add(symbol_598);
			symbol_597.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_597);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_599 = PivotFactory.eINSTANCE.createOperation();
			symbol_599.setName("indexOf");
			//symbol_599.setMoniker("String!indexOf(String)");
			symbol_599.setType(symbol_56);  // Integer
			symbol_599.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_600 = PivotFactory.eINSTANCE.createParameter();
			symbol_600.setName("s");
			//symbol_600.setMoniker("String!indexOf(String)!s");
			symbol_600.setType(symbol_121);  // String
			symbol_600.setLower(BigInteger.valueOf(0));
			
			symbol_599.getOwnedParameters().add(symbol_600);
			symbol_599.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_599);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_601 = PivotFactory.eINSTANCE.createOperation();
			symbol_601.setName("size");
			//symbol_601.setMoniker("String!size()");
			symbol_601.setType(symbol_56);  // Integer
			symbol_601.setLower(BigInteger.valueOf(0));
			
			symbol_601.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_601);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_602 = PivotFactory.eINSTANCE.createOperation();
			symbol_602.setName("substring");
			//symbol_602.setMoniker("String!substring(Integer,Integer)");
			symbol_602.setType(symbol_121);  // String
			symbol_602.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_603 = PivotFactory.eINSTANCE.createParameter();
			symbol_603.setName("lower");
			//symbol_603.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_603.setType(symbol_56);  // Integer
			symbol_603.setLower(BigInteger.valueOf(0));
			
			symbol_602.getOwnedParameters().add(symbol_603);
			Parameter symbol_604 = PivotFactory.eINSTANCE.createParameter();
			symbol_604.setName("upper");
			//symbol_604.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_604.setType(symbol_56);  // Integer
			symbol_604.setLower(BigInteger.valueOf(0));
			
			symbol_602.getOwnedParameters().add(symbol_604);
			symbol_602.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_602);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_605 = PivotFactory.eINSTANCE.createOperation();
			symbol_605.setName("toBoolean");
			//symbol_605.setMoniker("String!toBoolean()");
			symbol_605.setType(symbol_19);  // Boolean
			symbol_605.setLower(BigInteger.valueOf(0));
			
			symbol_605.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_605);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_606 = PivotFactory.eINSTANCE.createOperation();
			symbol_606.setName("toInteger");
			//symbol_606.setMoniker("String!toInteger()");
			symbol_606.setType(symbol_56);  // Integer
			symbol_606.setLower(BigInteger.valueOf(0));
			
			symbol_606.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_606);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_607 = PivotFactory.eINSTANCE.createOperation();
			symbol_607.setName("toLower");
			//symbol_607.setMoniker("String!toLower()");
			symbol_607.setType(symbol_121);  // String
			symbol_607.setLower(BigInteger.valueOf(0));
			
			symbol_607.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_607);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_608 = PivotFactory.eINSTANCE.createOperation();
			symbol_608.setName("toLowerCase");
			//symbol_608.setMoniker("String!toLowerCase()");
			symbol_608.setType(symbol_121);  // String
			symbol_608.setLower(BigInteger.valueOf(0));
			
			symbol_608.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_608);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_609 = PivotFactory.eINSTANCE.createOperation();
			symbol_609.setName("toReal");
			//symbol_609.setMoniker("String!toReal()");
			symbol_609.setType(symbol_103);  // Real
			symbol_609.setLower(BigInteger.valueOf(0));
			
			symbol_609.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_609);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_610 = PivotFactory.eINSTANCE.createOperation();
			symbol_610.setName("toString");
			//symbol_610.setMoniker("String!toString()");
			symbol_610.setType(symbol_121);  // String
			symbol_610.setLower(BigInteger.valueOf(0));
			
			symbol_610.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_610);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_611 = PivotFactory.eINSTANCE.createOperation();
			symbol_611.setName("toUpper");
			//symbol_611.setMoniker("String!toUpper()");
			symbol_611.setType(symbol_121);  // String
			symbol_611.setLower(BigInteger.valueOf(0));
			
			symbol_611.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_611);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_612 = PivotFactory.eINSTANCE.createOperation();
			symbol_612.setName("toUpperCase");
			//symbol_612.setMoniker("String!toUpperCase()");
			symbol_612.setType(symbol_121);  // String
			symbol_612.setLower(BigInteger.valueOf(0));
			
			symbol_612.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_121.getOwnedOperations().add(symbol_612);
		}
		symbol_1.getOwnedTypes().add(symbol_121);
		//
		// ocl::UniqueCollection ocl!UniqueCollection{T}
		//
		symbol_122.setName("UniqueCollection");
		//symbol_122.setMoniker("ocl!UniqueCollection{T}");
		symbol_122.setElementType(symbol_125);
		symbol_125.setName("T");
		symbol_124.setOwnedParameteredElement(symbol_125);
		symbol_123.getOwnedParameters().add(symbol_124);
		
		symbol_122.setOwnedTemplateSignature(symbol_123);
		symbol_122.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_613 = PivotFactory.eINSTANCE.createIteration();
			symbol_613.setName("sortedBy");
			//symbol_613.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_613.setType(symbol_218);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_614 = PivotFactory.eINSTANCE.createParameter();
			symbol_614.setName("i");
			symbol_614.setType(symbol_125);  // ocl!UniqueCollection{T}?T
			symbol_613.getOwnedIterators().add(symbol_614);
			Parameter symbol_615 = PivotFactory.eINSTANCE.createParameter();
			symbol_615.setName("body");
			//symbol_615.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_615.setType(symbol_163);  // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
			
			symbol_613.getOwnedParameters().add(symbol_615);
			symbol_613.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_613);
		}
		symbol_1.getOwnedTypes().add(symbol_122);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_126.setName("UnlimitedNatural");
		//symbol_126.setMoniker("UnlimitedNatural");
		symbol_126.getSuperClasses().add(symbol_56); // Integer
		symbol_1.getOwnedTypes().add(symbol_126);
		//
		// ocl::orphanage
		//
		symbol_127.setName("orphanage");
		symbol_127.setMoniker("orphanage");
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_128.setName("Bag");
		//symbol_128.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_128.setElementType(symbol_30);
		{
			TemplateBinding symbol_616 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_616.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_617 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_617.setFormal(symbol_14);	
				symbol_617.setActual(symbol_30);	
				symbol_616.getParameterSubstitutions().add(symbol_617);
			}
			symbol_128.getTemplateBindings().add(symbol_616);
		}
		symbol_128.getSuperClasses().add(symbol_182); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_128.getSuperClasses().add(symbol_198); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_128);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_129.setName("Bag");
		//symbol_129.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_129.setElementType(symbol_63);
		{
			TemplateBinding symbol_618 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_618.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_619 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_619.setFormal(symbol_14);	
				symbol_619.setActual(symbol_63);	
				symbol_618.getParameterSubstitutions().add(symbol_619);
			}
			symbol_129.getTemplateBindings().add(symbol_618);
		}
		symbol_129.getSuperClasses().add(symbol_200); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_129.getSuperClasses().add(symbol_181); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_127.getOwnedTypes().add(symbol_129);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_130.setName("Bag");
		//symbol_130.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_130.setElementType(symbol_18);
		{
			TemplateBinding symbol_620 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_620.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_621 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_621.setFormal(symbol_14);	
				symbol_621.setActual(symbol_18);	
				symbol_620.getParameterSubstitutions().add(symbol_621);
			}
			symbol_130.getTemplateBindings().add(symbol_620);
		}
		symbol_130.getSuperClasses().add(symbol_190); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getSuperClasses().add(symbol_203); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_130);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}?T]
		//
		symbol_131.setName("Bag");
		//symbol_131.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}?T]");
		symbol_131.setElementType(symbol_60);
		{
			TemplateBinding symbol_622 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_622.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_623 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_623.setFormal(symbol_14);	
				symbol_623.setActual(symbol_60);	
				symbol_622.getParameterSubstitutions().add(symbol_623);
			}
			symbol_131.getTemplateBindings().add(symbol_622);
		}
		symbol_131.getSuperClasses().add(symbol_192); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_131.getSuperClasses().add(symbol_196); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_131);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_132.setName("Bag");
		//symbol_132.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_132.setElementType(symbol_15);
		{
			TemplateBinding symbol_624 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_624.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_625 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_625.setFormal(symbol_14);	
				symbol_625.setActual(symbol_15);	
				symbol_624.getParameterSubstitutions().add(symbol_625);
			}
			symbol_132.getTemplateBindings().add(symbol_624);
		}
		symbol_132.getSuperClasses().add(symbol_189); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_132.getSuperClasses().add(symbol_205); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_127.getOwnedTypes().add(symbol_132);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_133.setName("Collection");
		//symbol_133.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_133.setElementType(symbol_92);
		{
			TemplateBinding symbol_626 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_626.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_627 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_627.setFormal(symbol_29);	
				symbol_627.setActual(symbol_92);	
				symbol_626.getParameterSubstitutions().add(symbol_627);
			}
			symbol_133.getTemplateBindings().add(symbol_626);
		}
		symbol_133.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_133);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_134.setName("Collection");
		//symbol_134.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_134.setElementType(symbol_120);
		{
			TemplateBinding symbol_628 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_628.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_629 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_629.setFormal(symbol_29);	
				symbol_629.setActual(symbol_120);	
				symbol_628.getParameterSubstitutions().add(symbol_629);
			}
			symbol_134.getTemplateBindings().add(symbol_628);
		}
		symbol_134.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_134);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_135.setName("Collection");
		//symbol_135.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_135.setElementType(symbol_70);
		{
			TemplateBinding symbol_630 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_630.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_631 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_631.setFormal(symbol_29);	
				symbol_631.setActual(symbol_70);	
				symbol_630.getParameterSubstitutions().add(symbol_631);
			}
			symbol_135.getTemplateBindings().add(symbol_630);
		}
		symbol_135.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_135);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_136.setName("Collection");
		//symbol_136.setMoniker("ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_136.setElementType(symbol_81);
		{
			TemplateBinding symbol_632 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_632.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_633 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_633.setFormal(symbol_29);	
				symbol_633.setActual(symbol_81);	
				symbol_632.getParameterSubstitutions().add(symbol_633);
			}
			symbol_136.getTemplateBindings().add(symbol_632);
		}
		symbol_136.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_136);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_137.setName("Collection");
		//symbol_137.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_137.setElementType(symbol_95);
		{
			TemplateBinding symbol_634 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_634.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_635 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_635.setFormal(symbol_29);	
				symbol_635.setActual(symbol_95);	
				symbol_634.getParameterSubstitutions().add(symbol_635);
			}
			symbol_137.getTemplateBindings().add(symbol_634);
		}
		symbol_137.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_137);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_138.setName("Collection");
		//symbol_138.setMoniker("ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_138.setElementType(symbol_26);
		{
			TemplateBinding symbol_636 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_636.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_637 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_637.setFormal(symbol_29);	
				symbol_637.setActual(symbol_26);	
				symbol_636.getParameterSubstitutions().add(symbol_637);
			}
			symbol_138.getTemplateBindings().add(symbol_636);
		}
		symbol_138.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_138);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_139.setName("Collection");
		//symbol_139.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_139.setElementType(symbol_45);
		{
			TemplateBinding symbol_638 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_638.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_639 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_639.setFormal(symbol_29);	
				symbol_639.setActual(symbol_45);	
				symbol_638.getParameterSubstitutions().add(symbol_639);
			}
			symbol_139.getTemplateBindings().add(symbol_638);
		}
		symbol_139.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_139);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_140.setName("Collection");
		//symbol_140.setMoniker("ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_140.setElementType(symbol_55);
		{
			TemplateBinding symbol_640 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_640.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_641 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_641.setFormal(symbol_29);	
				symbol_641.setActual(symbol_55);	
				symbol_640.getParameterSubstitutions().add(symbol_641);
			}
			symbol_140.getTemplateBindings().add(symbol_640);
		}
		symbol_140.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_140);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_141.setName("Collection");
		//symbol_141.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_141.setElementType(symbol_102);
		{
			TemplateBinding symbol_642 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_642.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_643 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_643.setFormal(symbol_29);	
				symbol_643.setActual(symbol_102);	
				symbol_642.getParameterSubstitutions().add(symbol_643);
			}
			symbol_141.getTemplateBindings().add(symbol_642);
		}
		symbol_141.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_141);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_142.setName("Collection");
		//symbol_142.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_142.setElementType(symbol_60);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_29);	
				symbol_645.setActual(symbol_60);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_142.getTemplateBindings().add(symbol_644);
		}
		symbol_142.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_142);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_143.setName("Collection");
		//symbol_143.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_143.setElementType(symbol_18);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_29);	
				symbol_647.setActual(symbol_18);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_143.getTemplateBindings().add(symbol_646);
		}
		symbol_143.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_143);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_144.setName("Collection");
		//symbol_144.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_144.setElementType(symbol_117);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_29);	
				symbol_649.setActual(symbol_117);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_144.getTemplateBindings().add(symbol_648);
		}
		symbol_144.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_144);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_145.setName("Collection");
		//symbol_145.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_145.setElementType(symbol_30);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_29);	
				symbol_651.setActual(symbol_30);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_145.getTemplateBindings().add(symbol_650);
		}
		symbol_145.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_145);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_146.setName("Collection");
		//symbol_146.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_146.setElementType(symbol_63);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_29);	
				symbol_653.setActual(symbol_63);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_146.getTemplateBindings().add(symbol_652);
		}
		symbol_146.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_146);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_147.setName("Collection");
		//symbol_147.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_147.setElementType(symbol_15);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_29);	
				symbol_655.setActual(symbol_15);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_147.getTemplateBindings().add(symbol_654);
		}
		symbol_147.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_147);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_148.setName("Collection");
		//symbol_148.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_148.setElementType(symbol_113);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_29);	
				symbol_657.setActual(symbol_113);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_148.getTemplateBindings().add(symbol_656);
		}
		symbol_148.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_148);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_149.setName("Collection");
		//symbol_149.setMoniker("ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_149.setElementType(symbol_88);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_29);	
				symbol_659.setActual(symbol_88);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_149.getTemplateBindings().add(symbol_658);
		}
		symbol_149.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_149);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_150.setName("Collection");
		//symbol_150.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_150.setElementType(symbol_71);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_29);	
				symbol_661.setActual(symbol_71);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_150.getTemplateBindings().add(symbol_660);
		}
		symbol_150.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_150);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Classifier]
		//
		symbol_151.setName("Collection");
		//symbol_151.setMoniker("ocl!Collection[ocl!Classifier]");
		symbol_151.setElementType(symbol_23);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_29);	
				symbol_663.setActual(symbol_23);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_151.getTemplateBindings().add(symbol_662);
		}
		symbol_151.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_151);
		//
		// ocl::orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_152.setName("Collection");
		//symbol_152.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_152.setElementType(symbol_240);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_29);	
				symbol_665.setActual(symbol_240);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_152.getTemplateBindings().add(symbol_664);
		}
		symbol_152.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_152);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_153.setName("Collection");
		//symbol_153.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_153.setElementType(symbol_51);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_29);	
				symbol_667.setActual(symbol_51);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_153.getTemplateBindings().add(symbol_666);
		}
		symbol_153.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_153);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_154.setName("Collection");
		//symbol_154.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_154.setElementType(symbol_42);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_29);	
				symbol_669.setActual(symbol_42);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_154.getTemplateBindings().add(symbol_668);
		}
		symbol_154.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_154);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_155.setName("Collection");
		//symbol_155.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_155.setElementType(symbol_74);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_29);	
				symbol_671.setActual(symbol_74);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_155.getTemplateBindings().add(symbol_670);
		}
		symbol_155.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_155);
		//
		// ocl::orphanage::Collection ocl!Collection[String]
		//
		symbol_156.setName("Collection");
		//symbol_156.setMoniker("ocl!Collection[String]");
		symbol_156.setElementType(symbol_121);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_29);	
				symbol_673.setActual(symbol_121);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_156.getTemplateBindings().add(symbol_672);
		}
		symbol_156.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_156);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_157.setName("Collection");
		//symbol_157.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_157.setElementType(symbol_110);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_29);	
				symbol_675.setActual(symbol_110);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_157.getTemplateBindings().add(symbol_674);
		}
		symbol_157.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_157);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_158.setName("Collection");
		//symbol_158.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_158.setElementType(symbol_39);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_29);	
				symbol_677.setActual(symbol_39);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_158.getTemplateBindings().add(symbol_676);
		}
		symbol_158.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_158);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_159.setName("Collection");
		//symbol_159.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_159.setElementType(symbol_125);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_29);	
				symbol_679.setActual(symbol_125);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_159.getTemplateBindings().add(symbol_678);
		}
		symbol_159.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_159);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_160.setName("Collection");
		//symbol_160.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_160.setElementType(symbol_33);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_29);	
				symbol_681.setActual(symbol_33);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_160.getTemplateBindings().add(symbol_680);
		}
		symbol_160.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_160);
		//
		// ocl::orphanage::Collection ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_161.setName("Collection");
		//symbol_161.setMoniker("ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_161.setElementType(symbol_22);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_29);	
				symbol_683.setActual(symbol_22);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_161.getTemplateBindings().add(symbol_682);
		}
		symbol_161.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_127.getOwnedTypes().add(symbol_161);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_162.setName("Lambda");
		//symbol_162.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_162.setContextType(symbol_30);
		symbol_162.setResultType(symbol_36);
		symbol_127.getOwnedTypes().add(symbol_162);
		//
		// ocl::orphanage::Lambda Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		//
		symbol_163.setName("Lambda");
		//symbol_163.setMoniker("Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny");
		symbol_163.setContextType(symbol_125);
		symbol_163.setResultType(symbol_71);
		symbol_127.getOwnedTypes().add(symbol_163);
		//
		// ocl::orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_164.setName("Lambda");
		//symbol_164.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_164.setContextType(symbol_92);
		symbol_164.setResultType(symbol_98);
		symbol_127.getOwnedTypes().add(symbol_164);
		//
		// ocl::orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_165.setName("Lambda");
		//symbol_165.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_165.setContextType(symbol_92);
		symbol_165.setResultType(symbol_95);
		symbol_127.getOwnedTypes().add(symbol_165);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Sequence{T}?T()Boolean
		//
		symbol_166.setName("Lambda");
		//symbol_166.setMoniker("Lambda~ocl!Sequence{T}?T()Boolean");
		symbol_166.setContextType(symbol_110);
		symbol_166.setResultType(symbol_19);
		symbol_127.getOwnedTypes().add(symbol_166);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Set{T}?T()Boolean
		//
		symbol_167.setName("Lambda");
		//symbol_167.setMoniker("Lambda~ocl!Set{T}?T()Boolean");
		symbol_167.setContextType(symbol_117);
		symbol_167.setResultType(symbol_19);
		symbol_127.getOwnedTypes().add(symbol_167);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!OclAny
		//
		symbol_168.setName("Lambda");
		//symbol_168.setMoniker("Lambda~ocl!Collection{T}?T()ocl!OclAny");
		symbol_168.setContextType(symbol_30);
		symbol_168.setResultType(symbol_71);
		symbol_127.getOwnedTypes().add(symbol_168);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_169.setName("Lambda");
		//symbol_169.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_169.setContextType(symbol_30);
		symbol_169.setResultType(symbol_33);
		symbol_127.getOwnedTypes().add(symbol_169);
		//
		// ocl::orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		//
		symbol_170.setName("Lambda");
		//symbol_170.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]");
		symbol_170.setContextType(symbol_92);
		symbol_170.setResultType(symbol_216);
		symbol_127.getOwnedTypes().add(symbol_170);
		//
		// ocl::orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_171.setName("Lambda");
		//symbol_171.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_171.setContextType(symbol_60);
		symbol_171.setResultType(symbol_63);
		symbol_127.getOwnedTypes().add(symbol_171);
		//
		// ocl::orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_172.setName("Lambda");
		//symbol_172.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_172.setContextType(symbol_60);
		symbol_172.setResultType(symbol_66);
		symbol_127.getOwnedTypes().add(symbol_172);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Bag{T}?T()Boolean
		//
		symbol_173.setName("Lambda");
		//symbol_173.setMoniker("Lambda~ocl!Bag{T}?T()Boolean");
		symbol_173.setContextType(symbol_15);
		symbol_173.setResultType(symbol_19);
		symbol_127.getOwnedTypes().add(symbol_173);
		//
		// ocl::orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		//
		symbol_174.setName("Lambda");
		//symbol_174.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]");
		symbol_174.setContextType(symbol_60);
		symbol_174.setResultType(symbol_233);
		symbol_127.getOwnedTypes().add(symbol_174);
		//
		// ocl::orphanage::Lambda Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		//
		symbol_175.setName("Lambda");
		//symbol_175.setMoniker("Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny");
		symbol_175.setContextType(symbol_70);
		symbol_175.setResultType(symbol_71);
		symbol_127.getOwnedTypes().add(symbol_175);
		//
		// ocl::orphanage::Lambda Lambda~ocl!OrderedSet{T}?T()Boolean
		//
		symbol_176.setName("Lambda");
		//symbol_176.setMoniker("Lambda~ocl!OrderedSet{T}?T()Boolean");
		symbol_176.setContextType(symbol_102);
		symbol_176.setResultType(symbol_19);
		symbol_127.getOwnedTypes().add(symbol_176);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Collection{T}?T()Boolean
		//
		symbol_177.setName("Lambda");
		//symbol_177.setMoniker("Lambda~ocl!Collection{T}?T()Boolean");
		symbol_177.setContextType(symbol_30);
		symbol_177.setResultType(symbol_19);
		symbol_127.getOwnedTypes().add(symbol_177);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_178.setName("NonOrderedCollection");
		//symbol_178.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_178.setElementType(symbol_117);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_59);	
				symbol_685.setActual(symbol_117);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_178.getTemplateBindings().add(symbol_684);
		}
		symbol_178.getSuperClasses().add(symbol_144); // ocl!Collection[ocl!Set{T}?T]
		symbol_127.getOwnedTypes().add(symbol_178);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_179.setName("NonOrderedCollection");
		//symbol_179.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_179.setElementType(symbol_55);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_59);	
				symbol_687.setActual(symbol_55);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_179.getTemplateBindings().add(symbol_686);
		}
		symbol_179.getSuperClasses().add(symbol_140); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_179);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_180.setName("NonOrderedCollection");
		//symbol_180.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_180.setElementType(symbol_71);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_59);	
				symbol_689.setActual(symbol_71);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_180.getTemplateBindings().add(symbol_688);
		}
		symbol_180.getSuperClasses().add(symbol_150); // ocl!Collection[ocl!OclAny]
		symbol_127.getOwnedTypes().add(symbol_180);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_181.setName("NonOrderedCollection");
		//symbol_181.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_181.setElementType(symbol_63);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_59);	
				symbol_691.setActual(symbol_63);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_181.getTemplateBindings().add(symbol_690);
		}
		symbol_181.getSuperClasses().add(symbol_146); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_127.getOwnedTypes().add(symbol_181);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_182.setName("NonOrderedCollection");
		//symbol_182.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_182.setElementType(symbol_30);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_59);	
				symbol_693.setActual(symbol_30);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_182.getTemplateBindings().add(symbol_692);
		}
		symbol_182.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_182);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_183.setName("NonOrderedCollection");
		//symbol_183.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_183.setElementType(symbol_120);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_59);	
				symbol_695.setActual(symbol_120);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_183.getTemplateBindings().add(symbol_694);
		}
		symbol_183.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_183);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_184.setName("NonOrderedCollection");
		//symbol_184.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_184.setElementType(symbol_240);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_59);	
				symbol_697.setActual(symbol_240);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_184.getTemplateBindings().add(symbol_696);
		}
		symbol_184.getSuperClasses().add(symbol_152); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_127.getOwnedTypes().add(symbol_184);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_185.setName("NonOrderedCollection");
		//symbol_185.setMoniker("ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_185.setElementType(symbol_22);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_59);	
				symbol_699.setActual(symbol_22);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_185.getTemplateBindings().add(symbol_698);
		}
		symbol_185.getSuperClasses().add(symbol_161); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_185);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_186.setName("NonOrderedCollection");
		//symbol_186.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_186.setElementType(symbol_88);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_59);	
				symbol_701.setActual(symbol_88);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_186.getTemplateBindings().add(symbol_700);
		}
		symbol_186.getSuperClasses().add(symbol_149); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_186);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier]
		//
		symbol_187.setName("NonOrderedCollection");
		//symbol_187.setMoniker("ocl!NonOrderedCollection[ocl!Classifier]");
		symbol_187.setElementType(symbol_23);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_59);	
				symbol_703.setActual(symbol_23);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_187.getTemplateBindings().add(symbol_702);
		}
		symbol_187.getSuperClasses().add(symbol_151); // ocl!Collection[ocl!Classifier]
		symbol_127.getOwnedTypes().add(symbol_187);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_188.setName("NonOrderedCollection");
		//symbol_188.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_188.setElementType(symbol_81);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_59);	
				symbol_705.setActual(symbol_81);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_188.getTemplateBindings().add(symbol_704);
		}
		symbol_188.getSuperClasses().add(symbol_136); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_188);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_189.setName("NonOrderedCollection");
		//symbol_189.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_189.setElementType(symbol_15);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_59);	
				symbol_707.setActual(symbol_15);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_189.getTemplateBindings().add(symbol_706);
		}
		symbol_189.getSuperClasses().add(symbol_147); // ocl!Collection[ocl!Bag{T}?T]
		symbol_127.getOwnedTypes().add(symbol_189);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_190.setName("NonOrderedCollection");
		//symbol_190.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_190.setElementType(symbol_18);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_59);	
				symbol_709.setActual(symbol_18);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_190.getTemplateBindings().add(symbol_708);
		}
		symbol_190.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_190);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_191.setName("NonOrderedCollection");
		//symbol_191.setMoniker("ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_191.setElementType(symbol_26);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_59);	
				symbol_711.setActual(symbol_26);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_191.getTemplateBindings().add(symbol_710);
		}
		symbol_191.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_191);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_192.setName("NonOrderedCollection");
		//symbol_192.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_192.setElementType(symbol_60);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_59);	
				symbol_713.setActual(symbol_60);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_192.getTemplateBindings().add(symbol_712);
		}
		symbol_192.getSuperClasses().add(symbol_142); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_192);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_193.setName("NonOrderedCollection");
		//symbol_193.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_193.setElementType(symbol_102);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_59);	
				symbol_715.setActual(symbol_102);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_193.getTemplateBindings().add(symbol_714);
		}
		symbol_193.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_127.getOwnedTypes().add(symbol_193);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_194.setName("NonOrderedCollection");
		//symbol_194.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_194.setElementType(symbol_74);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_59);	
				symbol_717.setActual(symbol_74);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_194.getTemplateBindings().add(symbol_716);
		}
		symbol_194.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_194);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_195.setName("NonUniqueCollection");
		//symbol_195.setMoniker("ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_195.setElementType(symbol_70);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_69);	
				symbol_719.setActual(symbol_70);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_195.getTemplateBindings().add(symbol_718);
		}
		symbol_195.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_195);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_196.setName("NonUniqueCollection");
		//symbol_196.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_196.setElementType(symbol_60);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_69);	
				symbol_721.setActual(symbol_60);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_196.getTemplateBindings().add(symbol_720);
		}
		symbol_196.getSuperClasses().add(symbol_142); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_196);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_197.setName("NonUniqueCollection");
		//symbol_197.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_197.setElementType(symbol_113);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_69);	
				symbol_723.setActual(symbol_113);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_197.getTemplateBindings().add(symbol_722);
		}
		symbol_197.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_197);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_198.setName("NonUniqueCollection");
		//symbol_198.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_198.setElementType(symbol_30);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_69);	
				symbol_725.setActual(symbol_30);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_198.getTemplateBindings().add(symbol_724);
		}
		symbol_198.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_198);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_199.setName("NonUniqueCollection");
		//symbol_199.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_199.setElementType(symbol_121);
		{
			TemplateBinding symbol_726 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_726.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_727 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_727.setFormal(symbol_69);	
				symbol_727.setActual(symbol_121);	
				symbol_726.getParameterSubstitutions().add(symbol_727);
			}
			symbol_199.getTemplateBindings().add(symbol_726);
		}
		symbol_199.getSuperClasses().add(symbol_156); // ocl!Collection[String]
		symbol_127.getOwnedTypes().add(symbol_199);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_200.setName("NonUniqueCollection");
		//symbol_200.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_200.setElementType(symbol_63);
		{
			TemplateBinding symbol_728 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_728.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_729 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_729.setFormal(symbol_69);	
				symbol_729.setActual(symbol_63);	
				symbol_728.getParameterSubstitutions().add(symbol_729);
			}
			symbol_200.getTemplateBindings().add(symbol_728);
		}
		symbol_200.getSuperClasses().add(symbol_146); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_127.getOwnedTypes().add(symbol_200);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_201.setName("NonUniqueCollection");
		//symbol_201.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_201.setElementType(symbol_95);
		{
			TemplateBinding symbol_730 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_730.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_731 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_731.setFormal(symbol_69);	
				symbol_731.setActual(symbol_95);	
				symbol_730.getParameterSubstitutions().add(symbol_731);
			}
			symbol_201.getTemplateBindings().add(symbol_730);
		}
		symbol_201.getSuperClasses().add(symbol_137); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_127.getOwnedTypes().add(symbol_201);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_202.setName("NonUniqueCollection");
		//symbol_202.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_202.setElementType(symbol_92);
		{
			TemplateBinding symbol_732 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_732.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_733 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_733.setFormal(symbol_69);	
				symbol_733.setActual(symbol_92);	
				symbol_732.getParameterSubstitutions().add(symbol_733);
			}
			symbol_202.getTemplateBindings().add(symbol_732);
		}
		symbol_202.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_202);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_203.setName("NonUniqueCollection");
		//symbol_203.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_203.setElementType(symbol_18);
		{
			TemplateBinding symbol_734 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_734.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_735 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_735.setFormal(symbol_69);	
				symbol_735.setActual(symbol_18);	
				symbol_734.getParameterSubstitutions().add(symbol_735);
			}
			symbol_203.getTemplateBindings().add(symbol_734);
		}
		symbol_203.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_203);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_204.setName("NonUniqueCollection");
		//symbol_204.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_204.setElementType(symbol_110);
		{
			TemplateBinding symbol_736 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_736.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_737 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_737.setFormal(symbol_69);	
				symbol_737.setActual(symbol_110);	
				symbol_736.getParameterSubstitutions().add(symbol_737);
			}
			symbol_204.getTemplateBindings().add(symbol_736);
		}
		symbol_204.getSuperClasses().add(symbol_157); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_127.getOwnedTypes().add(symbol_204);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_205.setName("NonUniqueCollection");
		//symbol_205.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_205.setElementType(symbol_15);
		{
			TemplateBinding symbol_738 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_738.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_739 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_739.setFormal(symbol_69);	
				symbol_739.setActual(symbol_15);	
				symbol_738.getParameterSubstitutions().add(symbol_739);
			}
			symbol_205.getTemplateBindings().add(symbol_738);
		}
		symbol_205.getSuperClasses().add(symbol_147); // ocl!Collection[ocl!Bag{T}?T]
		symbol_127.getOwnedTypes().add(symbol_205);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_206.setName("OrderedCollection");
		//symbol_206.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_206.setElementType(symbol_70);
		{
			TemplateBinding symbol_740 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_740.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_741 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_741.setFormal(symbol_91);	
				symbol_741.setActual(symbol_70);	
				symbol_740.getParameterSubstitutions().add(symbol_741);
			}
			symbol_206.getTemplateBindings().add(symbol_740);
		}
		symbol_206.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_206);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_207.setName("OrderedCollection");
		//symbol_207.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_207.setElementType(symbol_113);
		{
			TemplateBinding symbol_742 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_742.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_743 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_743.setFormal(symbol_91);	
				symbol_743.setActual(symbol_113);	
				symbol_742.getParameterSubstitutions().add(symbol_743);
			}
			symbol_207.getTemplateBindings().add(symbol_742);
		}
		symbol_207.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_207);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_208.setName("OrderedCollection");
		//symbol_208.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_208.setElementType(symbol_30);
		{
			TemplateBinding symbol_744 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_744.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_745 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_745.setFormal(symbol_91);	
				symbol_745.setActual(symbol_30);	
				symbol_744.getParameterSubstitutions().add(symbol_745);
			}
			symbol_208.getTemplateBindings().add(symbol_744);
		}
		symbol_208.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_208);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_209.setName("OrderedCollection");
		//symbol_209.setMoniker("ocl!OrderedCollection[String]");
		symbol_209.setElementType(symbol_121);
		{
			TemplateBinding symbol_746 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_746.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_747 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_747.setFormal(symbol_91);	
				symbol_747.setActual(symbol_121);	
				symbol_746.getParameterSubstitutions().add(symbol_747);
			}
			symbol_209.getTemplateBindings().add(symbol_746);
		}
		symbol_209.getSuperClasses().add(symbol_156); // ocl!Collection[String]
		symbol_127.getOwnedTypes().add(symbol_209);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_210.setName("OrderedCollection");
		//symbol_210.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_210.setElementType(symbol_92);
		{
			TemplateBinding symbol_748 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_748.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_749 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_749.setFormal(symbol_91);	
				symbol_749.setActual(symbol_92);	
				symbol_748.getParameterSubstitutions().add(symbol_749);
			}
			symbol_210.getTemplateBindings().add(symbol_748);
		}
		symbol_210.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_210);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_211.setName("OrderedCollection");
		//symbol_211.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_211.setElementType(symbol_125);
		{
			TemplateBinding symbol_750 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_750.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_751 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_751.setFormal(symbol_91);	
				symbol_751.setActual(symbol_125);	
				symbol_750.getParameterSubstitutions().add(symbol_751);
			}
			symbol_211.getTemplateBindings().add(symbol_750);
		}
		symbol_211.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_211);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_212.setName("OrderedCollection");
		//symbol_212.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_212.setElementType(symbol_102);
		{
			TemplateBinding symbol_752 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_752.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_753 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_753.setFormal(symbol_91);	
				symbol_753.setActual(symbol_102);	
				symbol_752.getParameterSubstitutions().add(symbol_753);
			}
			symbol_212.getTemplateBindings().add(symbol_752);
		}
		symbol_212.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_127.getOwnedTypes().add(symbol_212);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_213.setName("OrderedCollection");
		//symbol_213.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_213.setElementType(symbol_110);
		{
			TemplateBinding symbol_754 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_754.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_755 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_755.setFormal(symbol_91);	
				symbol_755.setActual(symbol_110);	
				symbol_754.getParameterSubstitutions().add(symbol_755);
			}
			symbol_213.getTemplateBindings().add(symbol_754);
		}
		symbol_213.getSuperClasses().add(symbol_157); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_127.getOwnedTypes().add(symbol_213);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_214.setName("OrderedCollection");
		//symbol_214.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_214.setElementType(symbol_95);
		{
			TemplateBinding symbol_756 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_756.setSignature(symbol_90);
			{
				TemplateParameterSubstitution symbol_757 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_757.setFormal(symbol_91);	
				symbol_757.setActual(symbol_95);	
				symbol_756.getParameterSubstitutions().add(symbol_757);
			}
			symbol_214.getTemplateBindings().add(symbol_756);
		}
		symbol_214.getSuperClasses().add(symbol_137); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_127.getOwnedTypes().add(symbol_214);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_215.setName("OrderedSet");
		//symbol_215.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_215.setElementType(symbol_30);
		{
			TemplateBinding symbol_758 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_758.setSignature(symbol_100);
			{
				TemplateParameterSubstitution symbol_759 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_759.setFormal(symbol_101);	
				symbol_759.setActual(symbol_30);	
				symbol_758.getParameterSubstitutions().add(symbol_759);
			}
			symbol_215.getTemplateBindings().add(symbol_758);
		}
		symbol_215.getSuperClasses().add(symbol_245); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_215.getSuperClasses().add(symbol_208); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_215);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_216.setName("OrderedSet");
		//symbol_216.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_216.setElementType(symbol_92);
		{
			TemplateBinding symbol_760 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_760.setSignature(symbol_100);
			{
				TemplateParameterSubstitution symbol_761 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_761.setFormal(symbol_101);	
				symbol_761.setActual(symbol_92);	
				symbol_760.getParameterSubstitutions().add(symbol_761);
			}
			symbol_216.getTemplateBindings().add(symbol_760);
		}
		symbol_216.getSuperClasses().add(symbol_210); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_216.getSuperClasses().add(symbol_253); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_216);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_217.setName("OrderedSet");
		//symbol_217.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_217.setElementType(symbol_102);
		{
			TemplateBinding symbol_762 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_762.setSignature(symbol_100);
			{
				TemplateParameterSubstitution symbol_763 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_763.setFormal(symbol_101);	
				symbol_763.setActual(symbol_102);	
				symbol_762.getParameterSubstitutions().add(symbol_763);
			}
			symbol_217.getTemplateBindings().add(symbol_762);
		}
		symbol_217.getSuperClasses().add(symbol_246); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_217.getSuperClasses().add(symbol_212); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_127.getOwnedTypes().add(symbol_217);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_218.setName("OrderedSet");
		//symbol_218.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_218.setElementType(symbol_125);
		{
			TemplateBinding symbol_764 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_764.setSignature(symbol_100);
			{
				TemplateParameterSubstitution symbol_765 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_765.setFormal(symbol_101);	
				symbol_765.setActual(symbol_125);	
				symbol_764.getParameterSubstitutions().add(symbol_765);
			}
			symbol_218.getTemplateBindings().add(symbol_764);
		}
		symbol_218.getSuperClasses().add(symbol_243); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		symbol_218.getSuperClasses().add(symbol_211); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_218);
		//
		// ocl::orphanage::Sequence ocl!Sequence[String]
		//
		symbol_219.setName("Sequence");
		//symbol_219.setMoniker("ocl!Sequence[String]");
		symbol_219.setElementType(symbol_121);
		{
			TemplateBinding symbol_766 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_766.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_767 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_767.setFormal(symbol_109);	
				symbol_767.setActual(symbol_121);	
				symbol_766.getParameterSubstitutions().add(symbol_767);
			}
			symbol_219.getTemplateBindings().add(symbol_766);
		}
		symbol_219.getSuperClasses().add(symbol_199); // ocl!NonUniqueCollection[String]
		symbol_219.getSuperClasses().add(symbol_209); // ocl!OrderedCollection[String]
		symbol_127.getOwnedTypes().add(symbol_219);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_220.setName("Sequence");
		//symbol_220.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_220.setElementType(symbol_70);
		{
			TemplateBinding symbol_768 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_768.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_769 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_769.setFormal(symbol_109);	
				symbol_769.setActual(symbol_70);	
				symbol_768.getParameterSubstitutions().add(symbol_769);
			}
			symbol_220.getTemplateBindings().add(symbol_768);
		}
		symbol_220.getSuperClasses().add(symbol_195); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		symbol_220.getSuperClasses().add(symbol_206); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_220);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_221.setName("Sequence");
		//symbol_221.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_221.setElementType(symbol_30);
		{
			TemplateBinding symbol_770 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_770.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_771 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_771.setFormal(symbol_109);	
				symbol_771.setActual(symbol_30);	
				symbol_770.getParameterSubstitutions().add(symbol_771);
			}
			symbol_221.getTemplateBindings().add(symbol_770);
		}
		symbol_221.getSuperClasses().add(symbol_198); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_221.getSuperClasses().add(symbol_208); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_221);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_222.setName("Sequence");
		//symbol_222.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_222.setElementType(symbol_92);
		{
			TemplateBinding symbol_772 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_772.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_773 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_773.setFormal(symbol_109);	
				symbol_773.setActual(symbol_92);	
				symbol_772.getParameterSubstitutions().add(symbol_773);
			}
			symbol_222.getTemplateBindings().add(symbol_772);
		}
		symbol_222.getSuperClasses().add(symbol_202); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_222.getSuperClasses().add(symbol_210); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_222);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_223.setName("Sequence");
		//symbol_223.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_223.setElementType(symbol_110);
		{
			TemplateBinding symbol_774 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_774.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_775 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_775.setFormal(symbol_109);	
				symbol_775.setActual(symbol_110);	
				symbol_774.getParameterSubstitutions().add(symbol_775);
			}
			symbol_223.getTemplateBindings().add(symbol_774);
		}
		symbol_223.getSuperClasses().add(symbol_213); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_223.getSuperClasses().add(symbol_204); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_127.getOwnedTypes().add(symbol_223);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_224.setName("Sequence");
		//symbol_224.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_224.setElementType(symbol_95);
		{
			TemplateBinding symbol_776 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_776.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_777 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_777.setFormal(symbol_109);	
				symbol_777.setActual(symbol_95);	
				symbol_776.getParameterSubstitutions().add(symbol_777);
			}
			symbol_224.getTemplateBindings().add(symbol_776);
		}
		symbol_224.getSuperClasses().add(symbol_201); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_224.getSuperClasses().add(symbol_214); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_127.getOwnedTypes().add(symbol_224);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_225.setName("Sequence");
		//symbol_225.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_225.setElementType(symbol_113);
		{
			TemplateBinding symbol_778 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_778.setSignature(symbol_108);
			{
				TemplateParameterSubstitution symbol_779 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_779.setFormal(symbol_109);	
				symbol_779.setActual(symbol_113);	
				symbol_778.getParameterSubstitutions().add(symbol_779);
			}
			symbol_225.getTemplateBindings().add(symbol_778);
		}
		symbol_225.getSuperClasses().add(symbol_197); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_225.getSuperClasses().add(symbol_207); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_225);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_226.setName("Set");
		//symbol_226.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_226.setElementType(symbol_102);
		{
			TemplateBinding symbol_780 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_780.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_781 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_781.setFormal(symbol_116);	
				symbol_781.setActual(symbol_102);	
				symbol_780.getParameterSubstitutions().add(symbol_781);
			}
			symbol_226.getTemplateBindings().add(symbol_780);
		}
		symbol_226.getSuperClasses().add(symbol_246); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_226.getSuperClasses().add(symbol_193); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_127.getOwnedTypes().add(symbol_226);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_227.setName("Set");
		//symbol_227.setMoniker("ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_227.setElementType(symbol_26);
		{
			TemplateBinding symbol_782 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_782.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_783 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_783.setFormal(symbol_116);	
				symbol_783.setActual(symbol_26);	
				symbol_782.getParameterSubstitutions().add(symbol_783);
			}
			symbol_227.getTemplateBindings().add(symbol_782);
		}
		symbol_227.getSuperClasses().add(symbol_191); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_227.getSuperClasses().add(symbol_258); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_227);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_228.setName("Set");
		//symbol_228.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_228.setElementType(symbol_71);
		{
			TemplateBinding symbol_784 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_784.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_785 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_785.setFormal(symbol_116);	
				symbol_785.setActual(symbol_71);	
				symbol_784.getParameterSubstitutions().add(symbol_785);
			}
			symbol_228.getTemplateBindings().add(symbol_784);
		}
		symbol_228.getSuperClasses().add(symbol_180); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_228.getSuperClasses().add(symbol_249); // ocl!UniqueCollection[ocl!OclAny]
		symbol_127.getOwnedTypes().add(symbol_228);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_229.setName("Set");
		//symbol_229.setMoniker("ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_229.setElementType(symbol_81);
		{
			TemplateBinding symbol_786 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_786.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_787 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_787.setFormal(symbol_116);	
				symbol_787.setActual(symbol_81);	
				symbol_786.getParameterSubstitutions().add(symbol_787);
			}
			symbol_229.getTemplateBindings().add(symbol_786);
		}
		symbol_229.getSuperClasses().add(symbol_188); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_229.getSuperClasses().add(symbol_250); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_229);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_230.setName("Set");
		//symbol_230.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_230.setElementType(symbol_120);
		{
			TemplateBinding symbol_788 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_788.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_789 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_789.setFormal(symbol_116);	
				symbol_789.setActual(symbol_120);	
				symbol_788.getParameterSubstitutions().add(symbol_789);
			}
			symbol_230.getTemplateBindings().add(symbol_788);
		}
		symbol_230.getSuperClasses().add(symbol_256); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_230.getSuperClasses().add(symbol_183); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_230);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_231.setName("Set");
		//symbol_231.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_231.setElementType(symbol_30);
		{
			TemplateBinding symbol_790 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_790.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_791 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_791.setFormal(symbol_116);	
				symbol_791.setActual(symbol_30);	
				symbol_790.getParameterSubstitutions().add(symbol_791);
			}
			symbol_231.getTemplateBindings().add(symbol_790);
		}
		symbol_231.getSuperClasses().add(symbol_182); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_231.getSuperClasses().add(symbol_245); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_231);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_232.setName("Set");
		//symbol_232.setMoniker("ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_232.setElementType(symbol_55);
		{
			TemplateBinding symbol_792 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_792.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_793 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_793.setFormal(symbol_116);	
				symbol_793.setActual(symbol_55);	
				symbol_792.getParameterSubstitutions().add(symbol_793);
			}
			symbol_232.getTemplateBindings().add(symbol_792);
		}
		symbol_232.getSuperClasses().add(symbol_248); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_232.getSuperClasses().add(symbol_179); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_232);
		//
		// ocl::orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_233.setName("Set");
		//symbol_233.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_233.setElementType(symbol_60);
		{
			TemplateBinding symbol_794 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_794.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_795 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_795.setFormal(symbol_116);	
				symbol_795.setActual(symbol_60);	
				symbol_794.getParameterSubstitutions().add(symbol_795);
			}
			symbol_233.getTemplateBindings().add(symbol_794);
		}
		symbol_233.getSuperClasses().add(symbol_192); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_233.getSuperClasses().add(symbol_252); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_233);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Classifier]
		//
		symbol_234.setName("Set");
		//symbol_234.setMoniker("ocl!Set[ocl!Classifier]");
		symbol_234.setElementType(symbol_23);
		{
			TemplateBinding symbol_796 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_796.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_797 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_797.setFormal(symbol_116);	
				symbol_797.setActual(symbol_23);	
				symbol_796.getParameterSubstitutions().add(symbol_797);
			}
			symbol_234.getTemplateBindings().add(symbol_796);
		}
		symbol_234.getSuperClasses().add(symbol_251); // ocl!UniqueCollection[ocl!Classifier]
		symbol_234.getSuperClasses().add(symbol_187); // ocl!NonOrderedCollection[ocl!Classifier]
		symbol_127.getOwnedTypes().add(symbol_234);
		//
		// ocl::orphanage::Set ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_235.setName("Set");
		//symbol_235.setMoniker("ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_235.setElementType(symbol_22);
		{
			TemplateBinding symbol_798 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_798.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_799 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_799.setFormal(symbol_116);	
				symbol_799.setActual(symbol_22);	
				symbol_798.getParameterSubstitutions().add(symbol_799);
			}
			symbol_235.getTemplateBindings().add(symbol_798);
		}
		symbol_235.getSuperClasses().add(symbol_185); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_235.getSuperClasses().add(symbol_257); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_235);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_236.setName("Set");
		//symbol_236.setMoniker("ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_236.setElementType(symbol_88);
		{
			TemplateBinding symbol_800 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_800.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_801 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_801.setFormal(symbol_116);	
				symbol_801.setActual(symbol_88);	
				symbol_800.getParameterSubstitutions().add(symbol_801);
			}
			symbol_236.getTemplateBindings().add(symbol_800);
		}
		symbol_236.getSuperClasses().add(symbol_254); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_236.getSuperClasses().add(symbol_186); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_236);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_237.setName("Set");
		//symbol_237.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_237.setElementType(symbol_117);
		{
			TemplateBinding symbol_802 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_802.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_803 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_803.setFormal(symbol_116);	
				symbol_803.setActual(symbol_117);	
				symbol_802.getParameterSubstitutions().add(symbol_803);
			}
			symbol_237.getTemplateBindings().add(symbol_802);
		}
		symbol_237.getSuperClasses().add(symbol_244); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_237.getSuperClasses().add(symbol_178); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_127.getOwnedTypes().add(symbol_237);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_238.setName("Set");
		//symbol_238.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_238.setElementType(symbol_74);
		{
			TemplateBinding symbol_804 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_804.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_805 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_805.setFormal(symbol_116);	
				symbol_805.setActual(symbol_74);	
				symbol_804.getParameterSubstitutions().add(symbol_805);
			}
			symbol_238.getTemplateBindings().add(symbol_804);
		}
		symbol_238.getSuperClasses().add(symbol_194); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_238.getSuperClasses().add(symbol_255); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_238);
		//
		// ocl::orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_239.setName("Set");
		//symbol_239.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_239.setElementType(symbol_240);
		{
			TemplateBinding symbol_806 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_806.setSignature(symbol_115);
			{
				TemplateParameterSubstitution symbol_807 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_807.setFormal(symbol_116);	
				symbol_807.setActual(symbol_240);	
				symbol_806.getParameterSubstitutions().add(symbol_807);
			}
			symbol_239.getTemplateBindings().add(symbol_806);
		}
		symbol_239.getSuperClasses().add(symbol_247); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_239.getSuperClasses().add(symbol_184); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_127.getOwnedTypes().add(symbol_239);
		//
		// ocl::orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_240.setName("Tuple");
		//symbol_240.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		{ // ocl::orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_241.setName("first");
			symbol_241.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_241.setIsResolveProxies(true);
			symbol_240.getOwnedAttributes().add(symbol_241);
		}
		{ // ocl::orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_242.setName("second");
			symbol_242.setType(symbol_51);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_242.setIsResolveProxies(true);
			symbol_240.getOwnedAttributes().add(symbol_242);
		}
		symbol_127.getOwnedTypes().add(symbol_240);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_243.setName("UniqueCollection");
		//symbol_243.setMoniker("ocl!UniqueCollection[ocl!UniqueCollection{T}?T]");
		symbol_243.setElementType(symbol_125);
		{
			TemplateBinding symbol_808 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_808.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_809 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_809.setFormal(symbol_124);	
				symbol_809.setActual(symbol_125);	
				symbol_808.getParameterSubstitutions().add(symbol_809);
			}
			symbol_243.getTemplateBindings().add(symbol_808);
		}
		symbol_243.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_243);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_244.setName("UniqueCollection");
		//symbol_244.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_244.setElementType(symbol_117);
		{
			TemplateBinding symbol_810 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_810.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_811 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_811.setFormal(symbol_124);	
				symbol_811.setActual(symbol_117);	
				symbol_810.getParameterSubstitutions().add(symbol_811);
			}
			symbol_244.getTemplateBindings().add(symbol_810);
		}
		symbol_244.getSuperClasses().add(symbol_144); // ocl!Collection[ocl!Set{T}?T]
		symbol_127.getOwnedTypes().add(symbol_244);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_245.setName("UniqueCollection");
		//symbol_245.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_245.setElementType(symbol_30);
		{
			TemplateBinding symbol_812 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_812.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_813 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_813.setFormal(symbol_124);	
				symbol_813.setActual(symbol_30);	
				symbol_812.getParameterSubstitutions().add(symbol_813);
			}
			symbol_245.getTemplateBindings().add(symbol_812);
		}
		symbol_245.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!Collection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_245);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_246.setName("UniqueCollection");
		//symbol_246.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_246.setElementType(symbol_102);
		{
			TemplateBinding symbol_814 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_814.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_815 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_815.setFormal(symbol_124);	
				symbol_815.setActual(symbol_102);	
				symbol_814.getParameterSubstitutions().add(symbol_815);
			}
			symbol_246.getTemplateBindings().add(symbol_814);
		}
		symbol_246.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_127.getOwnedTypes().add(symbol_246);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_247.setName("UniqueCollection");
		//symbol_247.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_247.setElementType(symbol_240);
		{
			TemplateBinding symbol_816 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_816.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_817 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_817.setFormal(symbol_124);	
				symbol_817.setActual(symbol_240);	
				symbol_816.getParameterSubstitutions().add(symbol_817);
			}
			symbol_247.getTemplateBindings().add(symbol_816);
		}
		symbol_247.getSuperClasses().add(symbol_152); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_127.getOwnedTypes().add(symbol_247);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_248.setName("UniqueCollection");
		//symbol_248.setMoniker("ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_248.setElementType(symbol_55);
		{
			TemplateBinding symbol_818 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_818.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_819 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_819.setFormal(symbol_124);	
				symbol_819.setActual(symbol_55);	
				symbol_818.getParameterSubstitutions().add(symbol_819);
			}
			symbol_248.getTemplateBindings().add(symbol_818);
		}
		symbol_248.getSuperClasses().add(symbol_140); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_248);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_249.setName("UniqueCollection");
		//symbol_249.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_249.setElementType(symbol_71);
		{
			TemplateBinding symbol_820 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_820.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_821 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_821.setFormal(symbol_124);	
				symbol_821.setActual(symbol_71);	
				symbol_820.getParameterSubstitutions().add(symbol_821);
			}
			symbol_249.getTemplateBindings().add(symbol_820);
		}
		symbol_249.getSuperClasses().add(symbol_150); // ocl!Collection[ocl!OclAny]
		symbol_127.getOwnedTypes().add(symbol_249);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_250.setName("UniqueCollection");
		//symbol_250.setMoniker("ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_250.setElementType(symbol_81);
		{
			TemplateBinding symbol_822 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_822.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_823 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_823.setFormal(symbol_124);	
				symbol_823.setActual(symbol_81);	
				symbol_822.getParameterSubstitutions().add(symbol_823);
			}
			symbol_250.getTemplateBindings().add(symbol_822);
		}
		symbol_250.getSuperClasses().add(symbol_136); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_250);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier]
		//
		symbol_251.setName("UniqueCollection");
		//symbol_251.setMoniker("ocl!UniqueCollection[ocl!Classifier]");
		symbol_251.setElementType(symbol_23);
		{
			TemplateBinding symbol_824 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_824.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_825 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_825.setFormal(symbol_124);	
				symbol_825.setActual(symbol_23);	
				symbol_824.getParameterSubstitutions().add(symbol_825);
			}
			symbol_251.getTemplateBindings().add(symbol_824);
		}
		symbol_251.getSuperClasses().add(symbol_151); // ocl!Collection[ocl!Classifier]
		symbol_127.getOwnedTypes().add(symbol_251);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_252.setName("UniqueCollection");
		//symbol_252.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_252.setElementType(symbol_60);
		{
			TemplateBinding symbol_826 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_826.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_827 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_827.setFormal(symbol_124);	
				symbol_827.setActual(symbol_60);	
				symbol_826.getParameterSubstitutions().add(symbol_827);
			}
			symbol_252.getTemplateBindings().add(symbol_826);
		}
		symbol_252.getSuperClasses().add(symbol_142); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_252);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_253.setName("UniqueCollection");
		//symbol_253.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_253.setElementType(symbol_92);
		{
			TemplateBinding symbol_828 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_828.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_829 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_829.setFormal(symbol_124);	
				symbol_829.setActual(symbol_92);	
				symbol_828.getParameterSubstitutions().add(symbol_829);
			}
			symbol_253.getTemplateBindings().add(symbol_828);
		}
		symbol_253.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_127.getOwnedTypes().add(symbol_253);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_254.setName("UniqueCollection");
		//symbol_254.setMoniker("ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_254.setElementType(symbol_88);
		{
			TemplateBinding symbol_830 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_830.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_831 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_831.setFormal(symbol_124);	
				symbol_831.setActual(symbol_88);	
				symbol_830.getParameterSubstitutions().add(symbol_831);
			}
			symbol_254.getTemplateBindings().add(symbol_830);
		}
		symbol_254.getSuperClasses().add(symbol_149); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_254);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_255.setName("UniqueCollection");
		//symbol_255.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_255.setElementType(symbol_74);
		{
			TemplateBinding symbol_832 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_832.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_833 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_833.setFormal(symbol_124);	
				symbol_833.setActual(symbol_74);	
				symbol_832.getParameterSubstitutions().add(symbol_833);
			}
			symbol_255.getTemplateBindings().add(symbol_832);
		}
		symbol_255.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_255);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_256.setName("UniqueCollection");
		//symbol_256.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_256.setElementType(symbol_120);
		{
			TemplateBinding symbol_834 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_834.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_835 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_835.setFormal(symbol_124);	
				symbol_835.setActual(symbol_120);	
				symbol_834.getParameterSubstitutions().add(symbol_835);
			}
			symbol_256.getTemplateBindings().add(symbol_834);
		}
		symbol_256.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_127.getOwnedTypes().add(symbol_256);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_257.setName("UniqueCollection");
		//symbol_257.setMoniker("ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_257.setElementType(symbol_22);
		{
			TemplateBinding symbol_836 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_836.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_837 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_837.setFormal(symbol_124);	
				symbol_837.setActual(symbol_22);	
				symbol_836.getParameterSubstitutions().add(symbol_837);
			}
			symbol_257.getTemplateBindings().add(symbol_836);
		}
		symbol_257.getSuperClasses().add(symbol_161); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_257);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_258.setName("UniqueCollection");
		//symbol_258.setMoniker("ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_258.setElementType(symbol_26);
		{
			TemplateBinding symbol_838 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_838.setSignature(symbol_123);
			{
				TemplateParameterSubstitution symbol_839 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_839.setFormal(symbol_124);	
				symbol_839.setActual(symbol_26);	
				symbol_838.getParameterSubstitutions().add(symbol_839);
			}
			symbol_258.getTemplateBindings().add(symbol_838);
		}
		symbol_258.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_127.getOwnedTypes().add(symbol_258);
		symbol_1.getNestedPackages().add(symbol_127);
		return symbol_1;
	}
}
