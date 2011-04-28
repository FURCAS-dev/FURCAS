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
 * $Id: OCLstdlib.java,v 1.15 2011/04/20 19:02:37 ewillink Exp $
 */
package	org.eclipse.ocl.examples.library.oclstdlib;

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
	 *	The static library loader instance
	 */
	public static final Loader LOADER = new Loader();
	
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
		StandardLibraryContribution.REGISTRY.put(STDLIB_URI, LOADER);
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
		Property symbol_79 = PivotFactory.eINSTANCE.createProperty(); // ocl::OclInvalid::oclBadProperty ocl!OclInvalid!oclBadProperty
		TemplateSignature symbol_80 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclInvalid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_81 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_82 = PivotFactory.eINSTANCE.createClass(); // ocl!OclInvalid!allInstances{OclSelf}()?OclSelf
		
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // ocl!OclMessage
		
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // ocl!OclState
		
		Class symbol_85 = PivotFactory.eINSTANCE.createClass(); // ocl!OclTuple
		
		VoidType symbol_86 = PivotFactory.eINSTANCE.createVoidType(); // ocl!OclVoid
		TemplateSignature symbol_87 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclVoid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_88 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // ocl!OclVoid!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_90 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection{T}
		TemplateSignature symbol_91 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_92 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_93 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_94 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_95 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_96 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_97 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_98 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_100 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet{T}
		TemplateSignature symbol_101 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_102 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_103 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}?T
		
		
		PrimitiveType symbol_104 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_105 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_106 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_107 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{T}(ocl!Classifier)?T
		
		
		SequenceType symbol_108 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence{T}
		TemplateSignature symbol_109 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!
		TypeTemplateParameter symbol_110 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_111 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}?T
		
		TemplateSignature symbol_112 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_113 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_114 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_115 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set{T}
		TemplateSignature symbol_116 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!
		TypeTemplateParameter symbol_117 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_118 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}?T
		
		TemplateSignature symbol_119 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_120 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_121 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_122 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_123 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection{T}
		TemplateSignature symbol_124 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_125 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_126 = PivotFactory.eINSTANCE.createClass(); // ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_127 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_128 = PivotFactory.eINSTANCE.createPackage(); // $orphanage
		Class symbol_129 = PivotFactory.eINSTANCE.createClass(); // $orphanage!$orphanage
		
		BagType symbol_130 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Collection{T}?T]
		
		BagType symbol_131 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		
		BagType symbol_132 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		BagType symbol_133 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_134 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}?T]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_140 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_141 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_142 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_143 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		LambdaType symbol_164 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_165 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedSet{T}?T()Boolean
		
		LambdaType symbol_166 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()Boolean
		
		LambdaType symbol_167 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!OclAny
		
		LambdaType symbol_168 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_169 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		
		LambdaType symbol_170 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		
		LambdaType symbol_171 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_172 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_173 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_174 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_175 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Bag{T}?T()Boolean
		
		LambdaType symbol_176 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Set{T}?T()Boolean
		
		LambdaType symbol_177 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_178 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Sequence{T}?T()Boolean
		
		LambdaType symbol_179 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_193 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_194 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_195 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_196 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_197 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_198 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_199 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_200 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_201 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_202 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_203 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_204 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_205 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_206 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_207 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_208 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		CollectionType symbol_209 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_216 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_217 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_218 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_219 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_220 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		SequenceType symbol_221 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_222 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_223 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_224 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_225 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_226 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SequenceType symbol_227 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SetType symbol_228 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier]
		
		SetType symbol_229 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_230 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		SetType symbol_231 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		SetType symbol_232 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_233 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_234 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_235 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_236 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_237 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_238 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_239 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_240 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_241 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		TupleType symbol_242 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_243 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_244 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_245 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_246 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_247 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		CollectionType symbol_248 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_249 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_250 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_251 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_252 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_253 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier]
		
		CollectionType symbol_254 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_255 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_256 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_257 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_258 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_259 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_260 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		

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
		symbol_12.getSuperClasses().add(symbol_194); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_207); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_261 = PivotFactory.eINSTANCE.createOperation();
			symbol_261.setName("<>");
			//symbol_261.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_261.setType(symbol_19);  // Boolean
			
			Parameter symbol_262 = PivotFactory.eINSTANCE.createParameter();
			symbol_262.setName("object2");
			//symbol_262.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_262.setType(symbol_71);  // ocl!OclAny
			
			symbol_261.getOwnedParameters().add(symbol_262);
			symbol_261.setPrecedence(symbol_7);
			symbol_261.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_261);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_263 = PivotFactory.eINSTANCE.createOperation();
			symbol_263.setName("=");
			//symbol_263.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_263.setType(symbol_19);  // Boolean
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("object2");
			//symbol_264.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_264.setType(symbol_71);  // ocl!OclAny
			
			symbol_263.getOwnedParameters().add(symbol_264);
			symbol_263.setPrecedence(symbol_7);
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_263);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_265 = PivotFactory.eINSTANCE.createOperation();
			symbol_265.setName("excluding");
			//symbol_265.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_265.setType(symbol_134);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_266 = PivotFactory.eINSTANCE.createParameter();
			symbol_266.setName("object");
			//symbol_266.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_266.setType(symbol_71);  // ocl!OclAny
			
			symbol_265.getOwnedParameters().add(symbol_266);
			symbol_265.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_265);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_267 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_267.setOwnedTemplateSignature(symbol_16);
			symbol_267.setName("flatten");
			//symbol_267.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_267.setType(symbol_131);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			
			symbol_267.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_267);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_268 = PivotFactory.eINSTANCE.createOperation();
			symbol_268.setName("including");
			//symbol_268.setMoniker("ocl!Bag{T}!including(T)");
			symbol_268.setType(symbol_134);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_269 = PivotFactory.eINSTANCE.createParameter();
			symbol_269.setName("object");
			//symbol_269.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_269.setType(symbol_15);  // ocl!Bag{T}?T
			
			symbol_268.getOwnedParameters().add(symbol_269);
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_268);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_270 = PivotFactory.eINSTANCE.createIteration();
			symbol_270.setName("reject");
			//symbol_270.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)");
			symbol_270.setType(symbol_134);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_271 = PivotFactory.eINSTANCE.createParameter();
			symbol_271.setName("i");
			symbol_271.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_270.getOwnedIterators().add(symbol_271);
			Parameter symbol_272 = PivotFactory.eINSTANCE.createParameter();
			symbol_272.setName("body");
			//symbol_272.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_272.setType(symbol_175);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_270.getOwnedParameters().add(symbol_272);
			symbol_270.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_270);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_273 = PivotFactory.eINSTANCE.createIteration();
			symbol_273.setName("select");
			//symbol_273.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_273.setType(symbol_134);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_274 = PivotFactory.eINSTANCE.createParameter();
			symbol_274.setName("i");
			symbol_274.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_273.getOwnedIterators().add(symbol_274);
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("body");
			//symbol_275.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_275.setType(symbol_175);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_273.getOwnedParameters().add(symbol_275);
			symbol_273.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_273);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("<>");
			//symbol_276.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_276.setType(symbol_19);  // Boolean
			
			Parameter symbol_277 = PivotFactory.eINSTANCE.createParameter();
			symbol_277.setName("object2");
			//symbol_277.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_277.setType(symbol_71);  // ocl!OclAny
			
			symbol_276.getOwnedParameters().add(symbol_277);
			symbol_276.setPrecedence(symbol_7);
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_278.setName("=");
			//symbol_278.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_278.setType(symbol_19);  // Boolean
			
			Parameter symbol_279 = PivotFactory.eINSTANCE.createParameter();
			symbol_279.setName("object2");
			//symbol_279.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_279.setType(symbol_71);  // ocl!OclAny
			
			symbol_278.getOwnedParameters().add(symbol_279);
			symbol_278.setPrecedence(symbol_7);
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances{OclSelf}()
			Operation symbol_280 = PivotFactory.eINSTANCE.createOperation();
			symbol_22.setName("OclSelf");
			symbol_21.setOwnedParameteredElement(symbol_22);
			symbol_20.getOwnedParameters().add(symbol_21);
			
			symbol_280.setOwnedTemplateSignature(symbol_20);
			symbol_280.setName("allInstances");
			//symbol_280.setMoniker("Boolean!allInstances{OclSelf}()");
			symbol_280.setType(symbol_236);  // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
			
			symbol_280.setIsStatic(true);
			symbol_280.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_280);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_281.setName("and");
			//symbol_281.setMoniker("Boolean!and(Boolean)");
			symbol_281.setType(symbol_19);  // Boolean
			
			Parameter symbol_282 = PivotFactory.eINSTANCE.createParameter();
			symbol_282.setName("b");
			//symbol_282.setMoniker("Boolean!and(Boolean)!b");
			symbol_282.setType(symbol_19);  // Boolean
			
			symbol_281.getOwnedParameters().add(symbol_282);
			symbol_281.setPrecedence(symbol_8);
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("implies");
			//symbol_283.setMoniker("Boolean!implies(Boolean)");
			symbol_283.setType(symbol_19);  // Boolean
			
			Parameter symbol_284 = PivotFactory.eINSTANCE.createParameter();
			symbol_284.setName("b");
			//symbol_284.setMoniker("Boolean!implies(Boolean)!b");
			symbol_284.setType(symbol_19);  // Boolean
			
			symbol_283.getOwnedParameters().add(symbol_284);
			symbol_283.setPrecedence(symbol_11);
			symbol_283.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_283);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("not");
			//symbol_285.setMoniker("Boolean!not()");
			symbol_285.setType(symbol_19);  // Boolean
			
			symbol_285.setPrecedence(symbol_3);
			symbol_285.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_285);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_286.setName("or");
			//symbol_286.setMoniker("Boolean!or(Boolean)");
			symbol_286.setType(symbol_19);  // Boolean
			
			Parameter symbol_287 = PivotFactory.eINSTANCE.createParameter();
			symbol_287.setName("b");
			//symbol_287.setMoniker("Boolean!or(Boolean)!b");
			symbol_287.setType(symbol_19);  // Boolean
			
			symbol_286.getOwnedParameters().add(symbol_287);
			symbol_286.setPrecedence(symbol_9);
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_288 = PivotFactory.eINSTANCE.createOperation();
			symbol_288.setName("toString");
			//symbol_288.setMoniker("Boolean!toString()");
			symbol_288.setType(symbol_122);  // String
			
			symbol_288.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_288);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_289 = PivotFactory.eINSTANCE.createOperation();
			symbol_289.setName("xor");
			//symbol_289.setMoniker("Boolean!xor(Boolean)");
			symbol_289.setType(symbol_19);  // Boolean
			
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("b");
			//symbol_290.setMoniker("Boolean!xor(Boolean)!b");
			symbol_290.setType(symbol_19);  // Boolean
			
			symbol_289.getOwnedParameters().add(symbol_290);
			symbol_289.setPrecedence(symbol_10);
			symbol_289.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_289);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl!Classifier
		//
		symbol_23.setName("Classifier");
		//symbol_23.setMoniker("ocl!Classifier");
		symbol_23.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Classifier::allInstances() ocl!Classifier!allInstances{OclSelf}()
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_26.setName("OclSelf");
			symbol_25.setOwnedParameteredElement(symbol_26);
			symbol_24.getOwnedParameters().add(symbol_25);
			
			symbol_291.setOwnedTemplateSignature(symbol_24);
			symbol_291.setName("allInstances");
			//symbol_291.setMoniker("ocl!Classifier!allInstances{OclSelf}()");
			symbol_291.setType(symbol_238);  // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
			
			symbol_291.setIsStatic(true);
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Classifier::oclContainer() ocl!Classifier!oclContainer()
			Operation symbol_292 = PivotFactory.eINSTANCE.createOperation();
			symbol_292.setName("oclContainer");
			//symbol_292.setMoniker("ocl!Classifier!oclContainer()");
			symbol_292.setType(symbol_23);  // ocl!Classifier
			
			symbol_292.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_292);
		}
		{	// ocl::Classifier::oclContents() ocl!Classifier!oclContents()
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("oclContents");
			//symbol_293.setMoniker("ocl!Classifier!oclContents()");
			symbol_293.setType(symbol_228);  // ocl!Set[ocl!Classifier]
			
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_293);
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
			Operation symbol_294 = PivotFactory.eINSTANCE.createOperation();
			symbol_294.setName("<>");
			//symbol_294.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_294.setType(symbol_19);  // Boolean
			
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("object2");
			//symbol_295.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_295.setType(symbol_71);  // ocl!OclAny
			
			symbol_294.getOwnedParameters().add(symbol_295);
			symbol_294.setPrecedence(symbol_7);
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_296 = PivotFactory.eINSTANCE.createOperation();
			symbol_296.setName("=");
			//symbol_296.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_296.setType(symbol_19);  // Boolean
			
			Parameter symbol_297 = PivotFactory.eINSTANCE.createParameter();
			symbol_297.setName("object2");
			//symbol_297.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_297.setType(symbol_71);  // ocl!OclAny
			
			symbol_296.getOwnedParameters().add(symbol_297);
			symbol_296.setPrecedence(symbol_7);
			symbol_296.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_296);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_298 = PivotFactory.eINSTANCE.createIteration();
			symbol_298.setName("any");
			//symbol_298.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_298.setType(symbol_30);  // ocl!Collection{T}?T
			
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("i");
			symbol_299.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_298.getOwnedIterators().add(symbol_299);
			Parameter symbol_300 = PivotFactory.eINSTANCE.createParameter();
			symbol_300.setName("body");
			//symbol_300.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_300.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_298.getOwnedParameters().add(symbol_300);
			symbol_298.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_298);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_301.setName("asBag");
			//symbol_301.setMoniker("ocl!Collection{T}!asBag()");
			symbol_301.setType(symbol_130);  // ocl!Bag[ocl!Collection{T}?T]
			
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_302 = PivotFactory.eINSTANCE.createOperation();
			symbol_302.setName("asOrderedSet");
			//symbol_302.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_302.setType(symbol_220);  // ocl!OrderedSet[ocl!Collection{T}?T]
			
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_303 = PivotFactory.eINSTANCE.createOperation();
			symbol_303.setName("asSequence");
			//symbol_303.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_303.setType(symbol_222);  // ocl!Sequence[ocl!Collection{T}?T]
			
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_303);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_304 = PivotFactory.eINSTANCE.createOperation();
			symbol_304.setName("asSet");
			//symbol_304.setMoniker("ocl!Collection{T}!asSet()");
			symbol_304.setType(symbol_230);  // ocl!Set[ocl!Collection{T}?T]
			
			symbol_304.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_304);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_305 = PivotFactory.eINSTANCE.createIteration();
			symbol_33.setName("V");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_305.setOwnedTemplateSignature(symbol_31);
			symbol_305.setName("collect");
			//symbol_305.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_305.setType(symbol_136);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_306 = PivotFactory.eINSTANCE.createParameter();
			symbol_306.setName("i");
			symbol_306.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_305.getOwnedIterators().add(symbol_306);
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("body");
			//symbol_307.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_307.setType(symbol_174);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_305.getOwnedParameters().add(symbol_307);
			symbol_305.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_305);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_308 = PivotFactory.eINSTANCE.createIteration();
			symbol_36.setName("V");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_308.setOwnedTemplateSignature(symbol_34);
			symbol_308.setName("collectNested");
			//symbol_308.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_308.setType(symbol_138);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_309 = PivotFactory.eINSTANCE.createParameter();
			symbol_309.setName("i");
			symbol_309.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_308.getOwnedIterators().add(symbol_309);
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("body");
			//symbol_310.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_310.setType(symbol_179);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_308.getOwnedParameters().add(symbol_310);
			symbol_308.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_308);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("count");
			//symbol_311.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_311.setType(symbol_56);  // Integer
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("object");
			//symbol_312.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_312.setType(symbol_71);  // ocl!OclAny
			
			symbol_311.getOwnedParameters().add(symbol_312);
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_313.setName("excludes");
			//symbol_313.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_313.setType(symbol_19);  // Boolean
			
			Parameter symbol_314 = PivotFactory.eINSTANCE.createParameter();
			symbol_314.setName("object");
			//symbol_314.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_314.setType(symbol_71);  // ocl!OclAny
			
			symbol_313.getOwnedParameters().add(symbol_314);
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_313);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_39.setName("T2");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_315.setOwnedTemplateSignature(symbol_37);
			symbol_315.setName("excludesAll");
			//symbol_315.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_315.setType(symbol_19);  // Boolean
			
			Parameter symbol_316 = PivotFactory.eINSTANCE.createParameter();
			symbol_316.setName("c2");
			//symbol_316.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_316.setType(symbol_149);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_315.getOwnedParameters().add(symbol_316);
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_317 = PivotFactory.eINSTANCE.createOperation();
			symbol_317.setName("excluding");
			//symbol_317.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_317.setType(symbol_138);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("object");
			//symbol_318.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_318.setType(symbol_71);  // ocl!OclAny
			
			symbol_317.getOwnedParameters().add(symbol_318);
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_317);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_319 = PivotFactory.eINSTANCE.createIteration();
			symbol_319.setName("exists");
			//symbol_319.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_319.setType(symbol_19);  // Boolean
			
			Parameter symbol_320 = PivotFactory.eINSTANCE.createParameter();
			symbol_320.setName("i");
			symbol_320.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_319.getOwnedIterators().add(symbol_320);
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("body");
			//symbol_321.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_321.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_319.getOwnedParameters().add(symbol_321);
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_319);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_322 = PivotFactory.eINSTANCE.createIteration();
			symbol_322.setName("exists");
			//symbol_322.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_322.setType(symbol_19);  // Boolean
			
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("j");
			symbol_323.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_322.getOwnedIterators().add(symbol_323);
			Parameter symbol_324 = PivotFactory.eINSTANCE.createParameter();
			symbol_324.setName("i");
			symbol_324.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_322.getOwnedIterators().add(symbol_324);
			Parameter symbol_325 = PivotFactory.eINSTANCE.createParameter();
			symbol_325.setName("body");
			//symbol_325.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_325.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_322.getOwnedParameters().add(symbol_325);
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_42.setName("T2");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_326.setOwnedTemplateSignature(symbol_40);
			symbol_326.setName("flatten");
			//symbol_326.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_326.setType(symbol_137);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_327 = PivotFactory.eINSTANCE.createIteration();
			symbol_327.setName("forAll");
			//symbol_327.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_327.setType(symbol_19);  // Boolean
			
			Parameter symbol_328 = PivotFactory.eINSTANCE.createParameter();
			symbol_328.setName("i");
			symbol_328.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_327.getOwnedIterators().add(symbol_328);
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("body");
			//symbol_329.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_329.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_327.getOwnedParameters().add(symbol_329);
			symbol_327.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_327);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_330 = PivotFactory.eINSTANCE.createIteration();
			symbol_330.setName("forAll");
			//symbol_330.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_330.setType(symbol_19);  // Boolean
			
			Parameter symbol_331 = PivotFactory.eINSTANCE.createParameter();
			symbol_331.setName("j");
			symbol_331.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_330.getOwnedIterators().add(symbol_331);
			Parameter symbol_332 = PivotFactory.eINSTANCE.createParameter();
			symbol_332.setName("i");
			symbol_332.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_330.getOwnedIterators().add(symbol_332);
			Parameter symbol_333 = PivotFactory.eINSTANCE.createParameter();
			symbol_333.setName("body");
			//symbol_333.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_333.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_330.getOwnedParameters().add(symbol_333);
			symbol_330.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_330);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_334 = PivotFactory.eINSTANCE.createOperation();
			symbol_334.setName("includes");
			//symbol_334.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_334.setType(symbol_19);  // Boolean
			
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("object");
			//symbol_335.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_335.setType(symbol_71);  // ocl!OclAny
			
			symbol_334.getOwnedParameters().add(symbol_335);
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_336 = PivotFactory.eINSTANCE.createOperation();
			symbol_45.setName("T2");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_336.setOwnedTemplateSignature(symbol_43);
			symbol_336.setName("includesAll");
			//symbol_336.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_336.setType(symbol_19);  // Boolean
			
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("c2");
			//symbol_337.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_337.setType(symbol_153);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_336.getOwnedParameters().add(symbol_337);
			symbol_336.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_336);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("including");
			//symbol_338.setMoniker("ocl!Collection{T}!including(T)");
			symbol_338.setType(symbol_138);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("object");
			//symbol_339.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_339.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_338.getOwnedParameters().add(symbol_339);
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("isEmpty");
			//symbol_340.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_340.setType(symbol_19);  // Boolean
			
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_340);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)
			Iteration symbol_341 = PivotFactory.eINSTANCE.createIteration();
			symbol_341.setName("isUnique");
			//symbol_341.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)");
			symbol_341.setType(symbol_19);  // Boolean
			
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("i");
			symbol_342.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_341.getOwnedIterators().add(symbol_342);
			Parameter symbol_343 = PivotFactory.eINSTANCE.createParameter();
			symbol_343.setName("body");
			//symbol_343.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)!body");
			symbol_343.setType(symbol_167);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_341.getOwnedParameters().add(symbol_343);
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_344 = PivotFactory.eINSTANCE.createIteration();
			symbol_48.setName("Tacc");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_344.setOwnedTemplateSignature(symbol_46);
			symbol_344.setName("iterate");
			//symbol_344.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_344.setType(symbol_48);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_345 = PivotFactory.eINSTANCE.createParameter();
			symbol_345.setName("i");
			symbol_345.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_344.getOwnedIterators().add(symbol_345);
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("acc");
			symbol_346.setType(symbol_48);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_344.getOwnedAccumulators().add(symbol_346);
			symbol_344.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_344);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("max");
			//symbol_347.setMoniker("ocl!Collection{T}!max()");
			symbol_347.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_347.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_347);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_348 = PivotFactory.eINSTANCE.createOperation();
			symbol_348.setName("min");
			//symbol_348.setMoniker("ocl!Collection{T}!min()");
			symbol_348.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_348);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_349 = PivotFactory.eINSTANCE.createOperation();
			symbol_349.setName("notEmpty");
			//symbol_349.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_349.setType(symbol_19);  // Boolean
			
			symbol_349.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_349);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_350 = PivotFactory.eINSTANCE.createIteration();
			symbol_350.setName("one");
			//symbol_350.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_350.setType(symbol_19);  // Boolean
			
			Parameter symbol_351 = PivotFactory.eINSTANCE.createParameter();
			symbol_351.setName("i");
			symbol_351.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_350.getOwnedIterators().add(symbol_351);
			Parameter symbol_352 = PivotFactory.eINSTANCE.createParameter();
			symbol_352.setName("body");
			//symbol_352.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_352.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_350.getOwnedParameters().add(symbol_352);
			symbol_350.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_350);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_353 = PivotFactory.eINSTANCE.createOperation();
			symbol_51.setName("T2");
			symbol_50.setOwnedParameteredElement(symbol_51);
			symbol_49.getOwnedParameters().add(symbol_50);
			
			symbol_353.setOwnedTemplateSignature(symbol_49);
			symbol_353.setName("product");
			//symbol_353.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_353.setType(symbol_231);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("c2");
			//symbol_354.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_354.setType(symbol_147);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			
			symbol_353.getOwnedParameters().add(symbol_354);
			symbol_353.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_353);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_355 = PivotFactory.eINSTANCE.createIteration();
			symbol_355.setName("reject");
			//symbol_355.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_355.setType(symbol_138);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_356 = PivotFactory.eINSTANCE.createParameter();
			symbol_356.setName("i");
			symbol_356.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_355.getOwnedIterators().add(symbol_356);
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("body");
			//symbol_357.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_357.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_355.getOwnedParameters().add(symbol_357);
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_355);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_358 = PivotFactory.eINSTANCE.createIteration();
			symbol_358.setName("select");
			//symbol_358.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_358.setType(symbol_138);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_359 = PivotFactory.eINSTANCE.createParameter();
			symbol_359.setName("i");
			symbol_359.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_358.getOwnedIterators().add(symbol_359);
			Parameter symbol_360 = PivotFactory.eINSTANCE.createParameter();
			symbol_360.setName("body");
			//symbol_360.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_360.setType(symbol_166);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_358.getOwnedParameters().add(symbol_360);
			symbol_358.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_358);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_361 = PivotFactory.eINSTANCE.createOperation();
			symbol_361.setName("size");
			//symbol_361.setMoniker("ocl!Collection{T}!size()");
			symbol_361.setType(symbol_56);  // Integer
			
			symbol_361.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_361);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_362 = PivotFactory.eINSTANCE.createIteration();
			symbol_362.setName("sortedBy");
			//symbol_362.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_362.setType(symbol_209);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_363 = PivotFactory.eINSTANCE.createParameter();
			symbol_363.setName("i");
			symbol_363.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_362.getOwnedIterators().add(symbol_363);
			Parameter symbol_364 = PivotFactory.eINSTANCE.createParameter();
			symbol_364.setName("body");
			//symbol_364.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_364.setType(symbol_167);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_362.getOwnedParameters().add(symbol_364);
			symbol_362.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_362);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_365 = PivotFactory.eINSTANCE.createOperation();
			symbol_365.setName("sum");
			//symbol_365.setMoniker("ocl!Collection{T}!sum()");
			symbol_365.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_365.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_365);
		}
		symbol_1.getOwnedTypes().add(symbol_27);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_52.setName("Enumeration");
		//symbol_52.setMoniker("ocl!Enumeration");
		symbol_52.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances{OclSelf}()
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_55.setName("OclSelf");
			symbol_54.setOwnedParameteredElement(symbol_55);
			symbol_53.getOwnedParameters().add(symbol_54);
			
			symbol_366.setOwnedTemplateSignature(symbol_53);
			symbol_366.setName("allInstances");
			//symbol_366.setMoniker("ocl!Enumeration!allInstances{OclSelf}()");
			symbol_366.setType(symbol_239);  // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
			
			symbol_366.setIsStatic(true);
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_52.getOwnedOperations().add(symbol_366);
		}
		symbol_1.getOwnedTypes().add(symbol_52);
		//
		// ocl::Integer Integer
		//
		symbol_56.setName("Integer");
		//symbol_56.setMoniker("Integer");
		symbol_56.getSuperClasses().add(symbol_104); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_367.setName("*");
			//symbol_367.setMoniker("Integer!*(Integer)");
			symbol_367.setType(symbol_56);  // Integer
			
			Parameter symbol_368 = PivotFactory.eINSTANCE.createParameter();
			symbol_368.setName("i");
			//symbol_368.setMoniker("Integer!*(Integer)!i");
			symbol_368.setType(symbol_56);  // Integer
			
			symbol_367.getOwnedParameters().add(symbol_368);
			symbol_367.setPrecedence(symbol_4);
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_369 = PivotFactory.eINSTANCE.createOperation();
			symbol_369.setName("+");
			//symbol_369.setMoniker("Integer!+(Integer)");
			symbol_369.setType(symbol_56);  // Integer
			
			Parameter symbol_370 = PivotFactory.eINSTANCE.createParameter();
			symbol_370.setName("i");
			//symbol_370.setMoniker("Integer!+(Integer)!i");
			symbol_370.setType(symbol_56);  // Integer
			
			symbol_369.getOwnedParameters().add(symbol_370);
			symbol_369.setPrecedence(symbol_5);
			symbol_369.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_369);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("-");
			//symbol_371.setMoniker("Integer!-()");
			symbol_371.setType(symbol_56);  // Integer
			
			symbol_371.setPrecedence(symbol_3);
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_372.setName("-");
			//symbol_372.setMoniker("Integer!-(Integer)");
			symbol_372.setType(symbol_56);  // Integer
			
			Parameter symbol_373 = PivotFactory.eINSTANCE.createParameter();
			symbol_373.setName("i");
			//symbol_373.setMoniker("Integer!-(Integer)!i");
			symbol_373.setType(symbol_56);  // Integer
			
			symbol_372.getOwnedParameters().add(symbol_373);
			symbol_372.setPrecedence(symbol_5);
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_374 = PivotFactory.eINSTANCE.createOperation();
			symbol_374.setName("/");
			//symbol_374.setMoniker("Integer!/(Integer)");
			symbol_374.setType(symbol_104);  // Real
			
			Parameter symbol_375 = PivotFactory.eINSTANCE.createParameter();
			symbol_375.setName("i");
			//symbol_375.setMoniker("Integer!/(Integer)!i");
			symbol_375.setType(symbol_56);  // Integer
			
			symbol_374.getOwnedParameters().add(symbol_375);
			symbol_374.setPrecedence(symbol_4);
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_376 = PivotFactory.eINSTANCE.createOperation();
			symbol_376.setName("abs");
			//symbol_376.setMoniker("Integer!abs()");
			symbol_376.setType(symbol_56);  // Integer
			
			symbol_376.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_376);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_377.setName("div");
			//symbol_377.setMoniker("Integer!div(Integer)");
			symbol_377.setType(symbol_56);  // Integer
			
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("i");
			//symbol_378.setMoniker("Integer!div(Integer)!i");
			symbol_378.setType(symbol_56);  // Integer
			
			symbol_377.getOwnedParameters().add(symbol_378);
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("max");
			//symbol_379.setMoniker("Integer!max(Integer)");
			symbol_379.setType(symbol_56);  // Integer
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("i");
			//symbol_380.setMoniker("Integer!max(Integer)!i");
			symbol_380.setType(symbol_56);  // Integer
			
			symbol_379.getOwnedParameters().add(symbol_380);
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_381 = PivotFactory.eINSTANCE.createOperation();
			symbol_381.setName("min");
			//symbol_381.setMoniker("Integer!min(Integer)");
			symbol_381.setType(symbol_56);  // Integer
			
			Parameter symbol_382 = PivotFactory.eINSTANCE.createParameter();
			symbol_382.setName("i");
			//symbol_382.setMoniker("Integer!min(Integer)!i");
			symbol_382.setType(symbol_56);  // Integer
			
			symbol_381.getOwnedParameters().add(symbol_382);
			symbol_381.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_381);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_383.setName("mod");
			//symbol_383.setMoniker("Integer!mod(Integer)");
			symbol_383.setType(symbol_56);  // Integer
			
			Parameter symbol_384 = PivotFactory.eINSTANCE.createParameter();
			symbol_384.setName("i");
			//symbol_384.setMoniker("Integer!mod(Integer)!i");
			symbol_384.setType(symbol_56);  // Integer
			
			symbol_383.getOwnedParameters().add(symbol_384);
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_383);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_385 = PivotFactory.eINSTANCE.createOperation();
			symbol_385.setName("toString");
			//symbol_385.setMoniker("Integer!toString()");
			symbol_385.setType(symbol_122);  // String
			
			symbol_385.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_385);
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
		symbol_57.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])
			Iteration symbol_386 = PivotFactory.eINSTANCE.createIteration();
			symbol_386.setName("closure");
			//symbol_386.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])");
			symbol_386.setType(symbol_237);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_387 = PivotFactory.eINSTANCE.createParameter();
			symbol_387.setName("i");
			symbol_387.setType(symbol_60);  // ocl!NonOrderedCollection{T}?T
			symbol_386.getOwnedIterators().add(symbol_387);
			Parameter symbol_388 = PivotFactory.eINSTANCE.createParameter();
			symbol_388.setName("body");
			//symbol_388.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])!body");
			symbol_388.setType(symbol_169);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
			
			symbol_386.getOwnedParameters().add(symbol_388);
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_389 = PivotFactory.eINSTANCE.createIteration();
			symbol_63.setName("V");
			symbol_62.setOwnedParameteredElement(symbol_63);
			symbol_61.getOwnedParameters().add(symbol_62);
			
			symbol_389.setOwnedTemplateSignature(symbol_61);
			symbol_389.setName("collect");
			//symbol_389.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_389.setType(symbol_132);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_390 = PivotFactory.eINSTANCE.createParameter();
			symbol_390.setName("i");
			symbol_390.setType(symbol_60);  // ocl!NonOrderedCollection{T}?T
			symbol_389.getOwnedIterators().add(symbol_390);
			Parameter symbol_391 = PivotFactory.eINSTANCE.createParameter();
			symbol_391.setName("body");
			//symbol_391.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_391.setType(symbol_171);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_389.getOwnedParameters().add(symbol_391);
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_389);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_392 = PivotFactory.eINSTANCE.createIteration();
			symbol_66.setName("V");
			symbol_65.setOwnedParameteredElement(symbol_66);
			symbol_64.getOwnedParameters().add(symbol_65);
			
			symbol_392.setOwnedTemplateSignature(symbol_64);
			symbol_392.setName("collectNested");
			//symbol_392.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_392.setType(symbol_133);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_393 = PivotFactory.eINSTANCE.createParameter();
			symbol_393.setName("i");
			symbol_393.setType(symbol_60);  // ocl!NonOrderedCollection{T}?T
			symbol_392.getOwnedIterators().add(symbol_393);
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("body");
			//symbol_394.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_394.setType(symbol_168);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_392.getOwnedParameters().add(symbol_394);
			symbol_392.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_392);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_395 = PivotFactory.eINSTANCE.createOperation();
			symbol_395.setName("intersection");
			//symbol_395.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_395.setType(symbol_133);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_396 = PivotFactory.eINSTANCE.createParameter();
			symbol_396.setName("bag");
			//symbol_396.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_396.setType(symbol_133);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_395.getOwnedParameters().add(symbol_396);
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_395);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_397 = PivotFactory.eINSTANCE.createOperation();
			symbol_397.setName("intersection");
			//symbol_397.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_397.setType(symbol_237);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_398 = PivotFactory.eINSTANCE.createParameter();
			symbol_398.setName("s");
			//symbol_398.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_398.setType(symbol_237);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_397.getOwnedParameters().add(symbol_398);
			symbol_397.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_397);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("union");
			//symbol_399.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_399.setType(symbol_133);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("bag");
			//symbol_400.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_400.setType(symbol_133);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_399);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("union");
			//symbol_401.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_401.setType(symbol_237);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("s");
			//symbol_402.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_402.setType(symbol_237);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_401);
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
		symbol_67.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_403 = PivotFactory.eINSTANCE.createIteration();
			symbol_403.setName("sortedBy");
			//symbol_403.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_403.setType(symbol_223);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_404 = PivotFactory.eINSTANCE.createParameter();
			symbol_404.setName("i");
			symbol_404.setType(symbol_70);  // ocl!NonUniqueCollection{T}?T
			symbol_403.getOwnedIterators().add(symbol_404);
			Parameter symbol_405 = PivotFactory.eINSTANCE.createParameter();
			symbol_405.setName("body");
			//symbol_405.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_405.setType(symbol_172);  // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
			
			symbol_403.getOwnedParameters().add(symbol_405);
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_403);
		}
		symbol_1.getOwnedTypes().add(symbol_67);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_71.setName("OclAny");
		//symbol_71.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_406.setName("<>");
			//symbol_406.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_406.setType(symbol_19);  // Boolean
			
			Parameter symbol_407 = PivotFactory.eINSTANCE.createParameter();
			symbol_407.setName("object2");
			//symbol_407.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_407.setType(symbol_71);  // ocl!OclAny
			
			symbol_406.getOwnedParameters().add(symbol_407);
			symbol_406.setPrecedence(symbol_7);
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_408 = PivotFactory.eINSTANCE.createOperation();
			symbol_408.setName("=");
			//symbol_408.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_408.setType(symbol_19);  // Boolean
			
			Parameter symbol_409 = PivotFactory.eINSTANCE.createParameter();
			symbol_409.setName("object2");
			//symbol_409.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_409.setType(symbol_71);  // ocl!OclAny
			
			symbol_408.getOwnedParameters().add(symbol_409);
			symbol_408.setPrecedence(symbol_7);
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_408);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_410 = PivotFactory.eINSTANCE.createOperation();
			symbol_74.setName("OclSelf");
			symbol_73.setOwnedParameteredElement(symbol_74);
			symbol_72.getOwnedParameters().add(symbol_73);
			
			symbol_410.setOwnedTemplateSignature(symbol_72);
			symbol_410.setName("oclAsSet");
			//symbol_410.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_410.setType(symbol_229);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			
			symbol_410.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_410);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{T}(ocl!Classifier)
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_77.setName("T");
			symbol_76.setOwnedParameteredElement(symbol_77);
			symbol_75.getOwnedParameters().add(symbol_76);
			
			symbol_411.setOwnedTemplateSignature(symbol_75);
			symbol_411.setName("oclAsType");
			//symbol_411.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)");
			symbol_411.setType(symbol_77);  // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("type");
			//symbol_412.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)!type");
			symbol_412.setType(symbol_23);  // ocl!Classifier
			
			symbol_411.getOwnedParameters().add(symbol_412);
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_413 = PivotFactory.eINSTANCE.createOperation();
			symbol_413.setName("oclIsInState");
			//symbol_413.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_413.setType(symbol_19);  // Boolean
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("statespec");
			//symbol_414.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_414.setType(symbol_84);  // ocl!OclState
			
			symbol_413.getOwnedParameters().add(symbol_414);
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_415 = PivotFactory.eINSTANCE.createOperation();
			symbol_415.setName("oclIsInvalid");
			//symbol_415.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_415.setType(symbol_19);  // Boolean
			
			symbol_415.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_415);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf(ocl!Classifier)
			Operation symbol_416 = PivotFactory.eINSTANCE.createOperation();
			symbol_416.setName("oclIsKindOf");
			//symbol_416.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)");
			symbol_416.setType(symbol_19);  // Boolean
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("type");
			//symbol_417.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)!type");
			symbol_417.setType(symbol_23);  // ocl!Classifier
			
			symbol_416.getOwnedParameters().add(symbol_417);
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("oclIsNew");
			//symbol_418.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_418.setType(symbol_19);  // Boolean
			
			symbol_418.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_418);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf(ocl!Classifier)
			Operation symbol_419 = PivotFactory.eINSTANCE.createOperation();
			symbol_419.setName("oclIsTypeOf");
			//symbol_419.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)");
			symbol_419.setType(symbol_19);  // Boolean
			
			Parameter symbol_420 = PivotFactory.eINSTANCE.createParameter();
			symbol_420.setName("type");
			//symbol_420.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)!type");
			symbol_420.setType(symbol_23);  // ocl!Classifier
			
			symbol_419.getOwnedParameters().add(symbol_420);
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("oclIsUndefined");
			//symbol_421.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_421.setType(symbol_19);  // Boolean
			
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_421);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType()
			Operation symbol_422 = PivotFactory.eINSTANCE.createOperation();
			symbol_422.setName("oclType");
			//symbol_422.setMoniker("ocl!OclAny!oclType()");
			symbol_422.setType(symbol_23);  // ocl!Classifier
			
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_422);
		}
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// ocl::OclInvalid ocl!OclInvalid
		//
		symbol_78.setName("OclInvalid");
		//symbol_78.setMoniker("ocl!OclInvalid");
		symbol_78.getSuperClasses().add(symbol_86); // ocl!OclVoid
		{ // ocl::OclInvalid::oclBadProperty ocl!OclInvalid!oclBadProperty
			symbol_79.setName("oclBadProperty");
			symbol_79.setType(symbol_78);  // ocl!OclInvalid
			
			symbol_79.setIsResolveProxies(true);
			symbol_78.getOwnedAttributes().add(symbol_79);
		}
		{	// ocl::OclInvalid::<>() ocl!OclInvalid!<>(ocl!OclAny)
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("<>");
			//symbol_423.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_423.setType(symbol_19);  // Boolean
			
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("object2");
			//symbol_424.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_424.setType(symbol_71);  // ocl!OclAny
			
			symbol_423.getOwnedParameters().add(symbol_424);
			symbol_423.setPrecedence(symbol_7);
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_423);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_425 = PivotFactory.eINSTANCE.createOperation();
			symbol_425.setName("=");
			//symbol_425.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_425.setType(symbol_19);  // Boolean
			
			Parameter symbol_426 = PivotFactory.eINSTANCE.createParameter();
			symbol_426.setName("object2");
			//symbol_426.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_426.setType(symbol_71);  // ocl!OclAny
			
			symbol_425.getOwnedParameters().add(symbol_426);
			symbol_425.setPrecedence(symbol_7);
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_425);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances{OclSelf}()
			Operation symbol_427 = PivotFactory.eINSTANCE.createOperation();
			symbol_82.setName("OclSelf");
			symbol_81.setOwnedParameteredElement(symbol_82);
			symbol_80.getOwnedParameters().add(symbol_81);
			
			symbol_427.setOwnedTemplateSignature(symbol_80);
			symbol_427.setName("allInstances");
			//symbol_427.setMoniker("ocl!OclInvalid!allInstances{OclSelf}()");
			symbol_427.setType(symbol_233);  // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
			
			symbol_427.setIsStatic(true);
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::OclInvalid::oclBadOperation() ocl!OclInvalid!oclBadOperation()
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("oclBadOperation");
			//symbol_428.setMoniker("ocl!OclInvalid!oclBadOperation()");
			symbol_428.setType(symbol_78);  // ocl!OclInvalid
			
			symbol_78.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_429 = PivotFactory.eINSTANCE.createOperation();
			symbol_429.setName("toString");
			//symbol_429.setMoniker("ocl!OclInvalid!toString()");
			symbol_429.setType(symbol_122);  // String
			
			symbol_429.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_429);
		}
		symbol_1.getOwnedTypes().add(symbol_78);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_83.setName("OclMessage");
		//symbol_83.setMoniker("ocl!OclMessage");
		symbol_83.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("hasReturned");
			//symbol_430.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_430.setType(symbol_19);  // Boolean
			
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_431 = PivotFactory.eINSTANCE.createOperation();
			symbol_431.setName("isOperationCall");
			//symbol_431.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_431.setType(symbol_19);  // Boolean
			
			symbol_431.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_431);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("isSignalSent");
			//symbol_432.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_432.setType(symbol_19);  // Boolean
			
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_433 = PivotFactory.eINSTANCE.createOperation();
			symbol_433.setName("result");
			//symbol_433.setMoniker("ocl!OclMessage!result()");
			symbol_433.setType(symbol_71);  // ocl!OclAny
			
			symbol_433.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_433);
		}
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// ocl::OclState ocl!OclState
		//
		symbol_84.setName("OclState");
		//symbol_84.setMoniker("ocl!OclState");
		symbol_84.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// ocl::OclTuple ocl!OclTuple
		//
		symbol_85.setName("OclTuple");
		//symbol_85.setMoniker("ocl!OclTuple");
		symbol_85.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::OclTuple::<>() ocl!OclTuple!<>(ocl!OclAny)
			Operation symbol_434 = PivotFactory.eINSTANCE.createOperation();
			symbol_434.setName("<>");
			//symbol_434.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_434.setType(symbol_19);  // Boolean
			
			Parameter symbol_435 = PivotFactory.eINSTANCE.createParameter();
			symbol_435.setName("object2");
			//symbol_435.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_435.setType(symbol_71);  // ocl!OclAny
			
			symbol_434.getOwnedParameters().add(symbol_435);
			symbol_434.setPrecedence(symbol_7);
			symbol_434.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_434);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_436 = PivotFactory.eINSTANCE.createOperation();
			symbol_436.setName("=");
			//symbol_436.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_436.setType(symbol_19);  // Boolean
			
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("object2");
			//symbol_437.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_437.setType(symbol_71);  // ocl!OclAny
			
			symbol_436.getOwnedParameters().add(symbol_437);
			symbol_436.setPrecedence(symbol_7);
			symbol_436.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_436);
		}
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_86.setName("OclVoid");
		//symbol_86.setMoniker("ocl!OclVoid");
		symbol_86.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("<>");
			//symbol_438.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_438.setType(symbol_19);  // Boolean
			
			Parameter symbol_439 = PivotFactory.eINSTANCE.createParameter();
			symbol_439.setName("object2");
			//symbol_439.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_439.setType(symbol_71);  // ocl!OclAny
			
			symbol_438.getOwnedParameters().add(symbol_439);
			symbol_438.setPrecedence(symbol_7);
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("=");
			//symbol_440.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_440.setType(symbol_19);  // Boolean
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("object2");
			//symbol_441.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_441.setType(symbol_71);  // ocl!OclAny
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setPrecedence(symbol_7);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances{OclSelf}()
			Operation symbol_442 = PivotFactory.eINSTANCE.createOperation();
			symbol_89.setName("OclSelf");
			symbol_88.setOwnedParameteredElement(symbol_89);
			symbol_87.getOwnedParameters().add(symbol_88);
			
			symbol_442.setOwnedTemplateSignature(symbol_87);
			symbol_442.setName("allInstances");
			//symbol_442.setMoniker("ocl!OclVoid!allInstances{OclSelf}()");
			symbol_442.setType(symbol_240);  // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
			
			symbol_442.setIsStatic(true);
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_443 = PivotFactory.eINSTANCE.createOperation();
			symbol_443.setName("and");
			//symbol_443.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_443.setType(symbol_19);  // Boolean
			
			Parameter symbol_444 = PivotFactory.eINSTANCE.createParameter();
			symbol_444.setName("b");
			//symbol_444.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_444.setType(symbol_19);  // Boolean
			
			symbol_443.getOwnedParameters().add(symbol_444);
			symbol_443.setPrecedence(symbol_8);
			symbol_443.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_443);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("implies");
			//symbol_445.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_445.setType(symbol_19);  // Boolean
			
			Parameter symbol_446 = PivotFactory.eINSTANCE.createParameter();
			symbol_446.setName("b");
			//symbol_446.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_446.setType(symbol_19);  // Boolean
			
			symbol_445.getOwnedParameters().add(symbol_446);
			symbol_445.setPrecedence(symbol_11);
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("or");
			//symbol_447.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_447.setType(symbol_19);  // Boolean
			
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("b");
			//symbol_448.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_448.setType(symbol_19);  // Boolean
			
			symbol_447.getOwnedParameters().add(symbol_448);
			symbol_447.setPrecedence(symbol_9);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_449 = PivotFactory.eINSTANCE.createOperation();
			symbol_449.setName("toString");
			//symbol_449.setMoniker("ocl!OclVoid!toString()");
			symbol_449.setType(symbol_122);  // String
			
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_449);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// ocl::OrderedCollection ocl!OrderedCollection{T}
		//
		symbol_90.setName("OrderedCollection");
		//symbol_90.setMoniker("ocl!OrderedCollection{T}");
		symbol_90.setElementType(symbol_93);
		symbol_93.setName("T");
		symbol_92.setOwnedParameteredElement(symbol_93);
		symbol_91.getOwnedParameters().add(symbol_92);
		
		symbol_90.setOwnedTemplateSignature(symbol_91);
		symbol_90.getSuperClasses().add(symbol_151); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_450 = PivotFactory.eINSTANCE.createOperation();
			symbol_450.setName("at");
			//symbol_450.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_450.setType(symbol_93);  // ocl!OrderedCollection{T}?T
			
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("index");
			//symbol_451.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_451.setType(symbol_56);  // Integer
			
			symbol_450.getOwnedParameters().add(symbol_451);
			symbol_450.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_450);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])
			Iteration symbol_452 = PivotFactory.eINSTANCE.createIteration();
			symbol_452.setName("closure");
			//symbol_452.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])");
			symbol_452.setType(symbol_217);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("i");
			symbol_453.setType(symbol_93);  // ocl!OrderedCollection{T}?T
			symbol_452.getOwnedIterators().add(symbol_453);
			Parameter symbol_454 = PivotFactory.eINSTANCE.createParameter();
			symbol_454.setName("body");
			//symbol_454.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])!body");
			symbol_454.setType(symbol_170);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
			
			symbol_452.getOwnedParameters().add(symbol_454);
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_455 = PivotFactory.eINSTANCE.createIteration();
			symbol_96.setName("V");
			symbol_95.setOwnedParameteredElement(symbol_96);
			symbol_94.getOwnedParameters().add(symbol_95);
			
			symbol_455.setOwnedTemplateSignature(symbol_94);
			symbol_455.setName("collect");
			//symbol_455.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_455.setType(symbol_224);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_456 = PivotFactory.eINSTANCE.createParameter();
			symbol_456.setName("i");
			symbol_456.setType(symbol_93);  // ocl!OrderedCollection{T}?T
			symbol_455.getOwnedIterators().add(symbol_456);
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("body");
			//symbol_457.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_457.setType(symbol_173);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_455.getOwnedParameters().add(symbol_457);
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_455);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_458 = PivotFactory.eINSTANCE.createIteration();
			symbol_99.setName("V");
			symbol_98.setOwnedParameteredElement(symbol_99);
			symbol_97.getOwnedParameters().add(symbol_98);
			
			symbol_458.setOwnedTemplateSignature(symbol_97);
			symbol_458.setName("collectNested");
			//symbol_458.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_458.setType(symbol_225);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("i");
			symbol_459.setType(symbol_93);  // ocl!OrderedCollection{T}?T
			symbol_458.getOwnedIterators().add(symbol_459);
			Parameter symbol_460 = PivotFactory.eINSTANCE.createParameter();
			symbol_460.setName("body");
			//symbol_460.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_460.setType(symbol_177);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_458.getOwnedParameters().add(symbol_460);
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_461 = PivotFactory.eINSTANCE.createOperation();
			symbol_461.setName("first");
			//symbol_461.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_461.setType(symbol_93);  // ocl!OrderedCollection{T}?T
			
			symbol_461.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_461);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("indexOf");
			//symbol_462.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_462.setType(symbol_56);  // Integer
			
			Parameter symbol_463 = PivotFactory.eINSTANCE.createParameter();
			symbol_463.setName("obj");
			//symbol_463.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_463.setType(symbol_71);  // ocl!OclAny
			
			symbol_462.getOwnedParameters().add(symbol_463);
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("last");
			//symbol_464.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_464.setType(symbol_93);  // ocl!OrderedCollection{T}?T
			
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_465 = PivotFactory.eINSTANCE.createOperation();
			symbol_465.setName("reverse");
			//symbol_465.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_465.setType(symbol_213);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			
			symbol_465.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_465);
		}
		symbol_1.getOwnedTypes().add(symbol_90);
		//
		// ocl::OrderedSet ocl!OrderedSet{T}
		//
		symbol_100.setName("OrderedSet");
		//symbol_100.setMoniker("ocl!OrderedSet{T}");
		symbol_100.setElementType(symbol_103);
		symbol_103.setName("T");
		symbol_102.setOwnedParameteredElement(symbol_103);
		symbol_101.getOwnedParameters().add(symbol_102);
		
		symbol_100.setOwnedTemplateSignature(symbol_101);
		symbol_100.getSuperClasses().add(symbol_250); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_100.getSuperClasses().add(symbol_211); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_466.setName("-");
			//symbol_466.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_466.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_467 = PivotFactory.eINSTANCE.createParameter();
			symbol_467.setName("s");
			//symbol_467.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_467.setType(symbol_235);  // ocl!Set[ocl!OclAny]
			
			symbol_466.getOwnedParameters().add(symbol_467);
			symbol_466.setPrecedence(symbol_5);
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_468 = PivotFactory.eINSTANCE.createOperation();
			symbol_468.setName("<>");
			//symbol_468.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_468.setType(symbol_19);  // Boolean
			
			Parameter symbol_469 = PivotFactory.eINSTANCE.createParameter();
			symbol_469.setName("object2");
			//symbol_469.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_469.setType(symbol_71);  // ocl!OclAny
			
			symbol_468.getOwnedParameters().add(symbol_469);
			symbol_468.setPrecedence(symbol_7);
			symbol_468.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_468);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_470 = PivotFactory.eINSTANCE.createOperation();
			symbol_470.setName("=");
			//symbol_470.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_470.setType(symbol_19);  // Boolean
			
			Parameter symbol_471 = PivotFactory.eINSTANCE.createParameter();
			symbol_471.setName("object2");
			//symbol_471.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_471.setType(symbol_71);  // ocl!OclAny
			
			symbol_470.getOwnedParameters().add(symbol_471);
			symbol_470.setPrecedence(symbol_7);
			symbol_470.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_470);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_472 = PivotFactory.eINSTANCE.createOperation();
			symbol_472.setName("append");
			//symbol_472.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_472.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_473 = PivotFactory.eINSTANCE.createParameter();
			symbol_473.setName("object");
			//symbol_473.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_473.setType(symbol_103);  // ocl!OrderedSet{T}?T
			
			symbol_472.getOwnedParameters().add(symbol_473);
			symbol_472.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_472);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_474 = PivotFactory.eINSTANCE.createOperation();
			symbol_474.setName("excluding");
			//symbol_474.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_474.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_475 = PivotFactory.eINSTANCE.createParameter();
			symbol_475.setName("object");
			//symbol_475.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_475.setType(symbol_71);  // ocl!OclAny
			
			symbol_474.getOwnedParameters().add(symbol_475);
			symbol_474.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_474);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_476 = PivotFactory.eINSTANCE.createOperation();
			symbol_476.setName("including");
			//symbol_476.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_476.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("object");
			//symbol_477.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_477.setType(symbol_103);  // ocl!OrderedSet{T}?T
			
			symbol_476.getOwnedParameters().add(symbol_477);
			symbol_476.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_476);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("insertAt");
			//symbol_478.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_478.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("index");
			//symbol_479.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_479.setType(symbol_56);  // Integer
			
			symbol_478.getOwnedParameters().add(symbol_479);
			Parameter symbol_480 = PivotFactory.eINSTANCE.createParameter();
			symbol_480.setName("object");
			//symbol_480.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_480.setType(symbol_103);  // ocl!OrderedSet{T}?T
			
			symbol_478.getOwnedParameters().add(symbol_480);
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_481 = PivotFactory.eINSTANCE.createOperation();
			symbol_481.setName("intersection");
			//symbol_481.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_481.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("o");
			//symbol_482.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_482.setType(symbol_232);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_481.getOwnedParameters().add(symbol_482);
			symbol_481.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_481);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("prepend");
			//symbol_483.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_483.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("object");
			//symbol_484.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_484.setType(symbol_103);  // ocl!OrderedSet{T}?T
			
			symbol_483.getOwnedParameters().add(symbol_484);
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_485 = PivotFactory.eINSTANCE.createIteration();
			symbol_485.setName("reject");
			//symbol_485.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_485.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_486 = PivotFactory.eINSTANCE.createParameter();
			symbol_486.setName("i");
			symbol_486.setType(symbol_103);  // ocl!OrderedSet{T}?T
			symbol_485.getOwnedIterators().add(symbol_486);
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("body");
			//symbol_487.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_487.setType(symbol_165);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_485.getOwnedParameters().add(symbol_487);
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_488 = PivotFactory.eINSTANCE.createOperation();
			symbol_488.setName("reverse");
			//symbol_488.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_488.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_489 = PivotFactory.eINSTANCE.createIteration();
			symbol_489.setName("select");
			//symbol_489.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_489.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("i");
			symbol_490.setType(symbol_103);  // ocl!OrderedSet{T}?T
			symbol_489.getOwnedIterators().add(symbol_490);
			Parameter symbol_491 = PivotFactory.eINSTANCE.createParameter();
			symbol_491.setName("body");
			//symbol_491.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_491.setType(symbol_165);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_489.getOwnedParameters().add(symbol_491);
			symbol_489.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_489);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_492 = PivotFactory.eINSTANCE.createOperation();
			symbol_492.setName("subOrderedSet");
			//symbol_492.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_492.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("lower");
			//symbol_493.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_493.setType(symbol_56);  // Integer
			
			symbol_492.getOwnedParameters().add(symbol_493);
			Parameter symbol_494 = PivotFactory.eINSTANCE.createParameter();
			symbol_494.setName("upper");
			//symbol_494.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_494.setType(symbol_56);  // Integer
			
			symbol_492.getOwnedParameters().add(symbol_494);
			symbol_492.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_492);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("symmetricDifference");
			//symbol_495.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_495.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_496 = PivotFactory.eINSTANCE.createParameter();
			symbol_496.setName("s");
			//symbol_496.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_496.setType(symbol_235);  // ocl!Set[ocl!OclAny]
			
			symbol_495.getOwnedParameters().add(symbol_496);
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_497 = PivotFactory.eINSTANCE.createOperation();
			symbol_497.setName("union");
			//symbol_497.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_497.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_498 = PivotFactory.eINSTANCE.createParameter();
			symbol_498.setName("o");
			//symbol_498.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_498.setType(symbol_219);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_497.getOwnedParameters().add(symbol_498);
			symbol_497.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_497);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_499 = PivotFactory.eINSTANCE.createOperation();
			symbol_499.setName("union");
			//symbol_499.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_499.setType(symbol_232);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("s");
			//symbol_500.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_500.setType(symbol_232);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_499.getOwnedParameters().add(symbol_500);
			symbol_499.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_499);
		}
		symbol_1.getOwnedTypes().add(symbol_100);
		//
		// ocl::Real Real
		//
		symbol_104.setName("Real");
		//symbol_104.setMoniker("Real");
		symbol_104.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("*");
			//symbol_501.setMoniker("Real!*(Real)");
			symbol_501.setType(symbol_104);  // Real
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("r");
			//symbol_502.setMoniker("Real!*(Real)!r");
			symbol_502.setType(symbol_104);  // Real
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setPrecedence(symbol_4);
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_503 = PivotFactory.eINSTANCE.createOperation();
			symbol_503.setName("+");
			//symbol_503.setMoniker("Real!+(Real)");
			symbol_503.setType(symbol_104);  // Real
			
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("r");
			//symbol_504.setMoniker("Real!+(Real)!r");
			symbol_504.setType(symbol_104);  // Real
			
			symbol_503.getOwnedParameters().add(symbol_504);
			symbol_503.setPrecedence(symbol_5);
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("-");
			//symbol_505.setMoniker("Real!-(Real)");
			symbol_505.setType(symbol_104);  // Real
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("r");
			//symbol_506.setMoniker("Real!-(Real)!r");
			symbol_506.setType(symbol_104);  // Real
			
			symbol_505.getOwnedParameters().add(symbol_506);
			symbol_505.setPrecedence(symbol_5);
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("-");
			//symbol_507.setMoniker("Real!-()");
			symbol_507.setType(symbol_104);  // Real
			
			symbol_507.setPrecedence(symbol_3);
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_508 = PivotFactory.eINSTANCE.createOperation();
			symbol_508.setName("/");
			//symbol_508.setMoniker("Real!/(Real)");
			symbol_508.setType(symbol_104);  // Real
			
			Parameter symbol_509 = PivotFactory.eINSTANCE.createParameter();
			symbol_509.setName("r");
			//symbol_509.setMoniker("Real!/(Real)!r");
			symbol_509.setType(symbol_104);  // Real
			
			symbol_508.getOwnedParameters().add(symbol_509);
			symbol_508.setPrecedence(symbol_4);
			symbol_508.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_508);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_510 = PivotFactory.eINSTANCE.createOperation();
			symbol_510.setName("<");
			//symbol_510.setMoniker("Real!<(Real)");
			symbol_510.setType(symbol_19);  // Boolean
			
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("r");
			//symbol_511.setMoniker("Real!<(Real)!r");
			symbol_511.setType(symbol_104);  // Real
			
			symbol_510.getOwnedParameters().add(symbol_511);
			symbol_510.setPrecedence(symbol_6);
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("<=");
			//symbol_512.setMoniker("Real!<=(Real)");
			symbol_512.setType(symbol_19);  // Boolean
			
			Parameter symbol_513 = PivotFactory.eINSTANCE.createParameter();
			symbol_513.setName("r");
			//symbol_513.setMoniker("Real!<=(Real)!r");
			symbol_513.setType(symbol_104);  // Real
			
			symbol_512.getOwnedParameters().add(symbol_513);
			symbol_512.setPrecedence(symbol_6);
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_512);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_514 = PivotFactory.eINSTANCE.createOperation();
			symbol_514.setName("<>");
			//symbol_514.setMoniker("Real!<>(ocl!OclAny)");
			symbol_514.setType(symbol_19);  // Boolean
			
			Parameter symbol_515 = PivotFactory.eINSTANCE.createParameter();
			symbol_515.setName("object2");
			//symbol_515.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_515.setType(symbol_71);  // ocl!OclAny
			
			symbol_514.getOwnedParameters().add(symbol_515);
			symbol_514.setPrecedence(symbol_7);
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_516 = PivotFactory.eINSTANCE.createOperation();
			symbol_516.setName("=");
			//symbol_516.setMoniker("Real!=(ocl!OclAny)");
			symbol_516.setType(symbol_19);  // Boolean
			
			Parameter symbol_517 = PivotFactory.eINSTANCE.createParameter();
			symbol_517.setName("object2");
			//symbol_517.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_517.setType(symbol_71);  // ocl!OclAny
			
			symbol_516.getOwnedParameters().add(symbol_517);
			symbol_516.setPrecedence(symbol_7);
			symbol_516.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_516);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_518 = PivotFactory.eINSTANCE.createOperation();
			symbol_518.setName(">");
			//symbol_518.setMoniker("Real!>(Real)");
			symbol_518.setType(symbol_19);  // Boolean
			
			Parameter symbol_519 = PivotFactory.eINSTANCE.createParameter();
			symbol_519.setName("r");
			//symbol_519.setMoniker("Real!>(Real)!r");
			symbol_519.setType(symbol_104);  // Real
			
			symbol_518.getOwnedParameters().add(symbol_519);
			symbol_518.setPrecedence(symbol_6);
			symbol_518.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_518);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_520 = PivotFactory.eINSTANCE.createOperation();
			symbol_520.setName(">=");
			//symbol_520.setMoniker("Real!>=(Real)");
			symbol_520.setType(symbol_19);  // Boolean
			
			Parameter symbol_521 = PivotFactory.eINSTANCE.createParameter();
			symbol_521.setName("r");
			//symbol_521.setMoniker("Real!>=(Real)!r");
			symbol_521.setType(symbol_104);  // Real
			
			symbol_520.getOwnedParameters().add(symbol_521);
			symbol_520.setPrecedence(symbol_6);
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("abs");
			//symbol_522.setMoniker("Real!abs()");
			symbol_522.setType(symbol_104);  // Real
			
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("floor");
			//symbol_523.setMoniker("Real!floor()");
			symbol_523.setType(symbol_56);  // Integer
			
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_524 = PivotFactory.eINSTANCE.createOperation();
			symbol_524.setName("max");
			//symbol_524.setMoniker("Real!max(Real)");
			symbol_524.setType(symbol_104);  // Real
			
			Parameter symbol_525 = PivotFactory.eINSTANCE.createParameter();
			symbol_525.setName("r");
			//symbol_525.setMoniker("Real!max(Real)!r");
			symbol_525.setType(symbol_104);  // Real
			
			symbol_524.getOwnedParameters().add(symbol_525);
			symbol_524.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_524);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_526 = PivotFactory.eINSTANCE.createOperation();
			symbol_526.setName("min");
			//symbol_526.setMoniker("Real!min(Real)");
			symbol_526.setType(symbol_104);  // Real
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("r");
			//symbol_527.setMoniker("Real!min(Real)!r");
			symbol_527.setType(symbol_104);  // Real
			
			symbol_526.getOwnedParameters().add(symbol_527);
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_526);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{T}(ocl!Classifier)
			Operation symbol_528 = PivotFactory.eINSTANCE.createOperation();
			symbol_107.setName("T");
			symbol_106.setOwnedParameteredElement(symbol_107);
			symbol_105.getOwnedParameters().add(symbol_106);
			
			symbol_528.setOwnedTemplateSignature(symbol_105);
			symbol_528.setName("oclAsType");
			//symbol_528.setMoniker("Real!oclAsType{T}(ocl!Classifier)");
			symbol_528.setType(symbol_107);  // Real!oclAsType{T}(ocl!Classifier)?T
			
			Parameter symbol_529 = PivotFactory.eINSTANCE.createParameter();
			symbol_529.setName("type");
			//symbol_529.setMoniker("Real!oclAsType{T}(ocl!Classifier)!type");
			symbol_529.setType(symbol_23);  // ocl!Classifier
			
			symbol_528.getOwnedParameters().add(symbol_529);
			symbol_528.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_528);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_530 = PivotFactory.eINSTANCE.createOperation();
			symbol_530.setName("round");
			//symbol_530.setMoniker("Real!round()");
			symbol_530.setType(symbol_56);  // Integer
			
			symbol_530.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_530);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_531 = PivotFactory.eINSTANCE.createOperation();
			symbol_531.setName("toString");
			//symbol_531.setMoniker("Real!toString()");
			symbol_531.setType(symbol_122);  // String
			
			symbol_531.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_531);
		}
		symbol_1.getOwnedTypes().add(symbol_104);
		//
		// ocl::Sequence ocl!Sequence{T}
		//
		symbol_108.setName("Sequence");
		//symbol_108.setMoniker("ocl!Sequence{T}");
		symbol_108.setElementType(symbol_111);
		symbol_111.setName("T");
		symbol_110.setOwnedParameteredElement(symbol_111);
		symbol_109.getOwnedParameters().add(symbol_110);
		
		symbol_108.setOwnedTemplateSignature(symbol_109);
		symbol_108.getSuperClasses().add(symbol_210); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_108.getSuperClasses().add(symbol_201); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_532 = PivotFactory.eINSTANCE.createOperation();
			symbol_532.setName("<>");
			//symbol_532.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_532.setType(symbol_19);  // Boolean
			
			Parameter symbol_533 = PivotFactory.eINSTANCE.createParameter();
			symbol_533.setName("object2");
			//symbol_533.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_533.setType(symbol_71);  // ocl!OclAny
			
			symbol_532.getOwnedParameters().add(symbol_533);
			symbol_532.setPrecedence(symbol_7);
			symbol_532.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_532);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_534 = PivotFactory.eINSTANCE.createOperation();
			symbol_534.setName("=");
			//symbol_534.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_534.setType(symbol_19);  // Boolean
			
			Parameter symbol_535 = PivotFactory.eINSTANCE.createParameter();
			symbol_535.setName("object2");
			//symbol_535.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_535.setType(symbol_71);  // ocl!OclAny
			
			symbol_534.getOwnedParameters().add(symbol_535);
			symbol_534.setPrecedence(symbol_7);
			symbol_534.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_534);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_536 = PivotFactory.eINSTANCE.createOperation();
			symbol_536.setName("append");
			//symbol_536.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_536.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_537 = PivotFactory.eINSTANCE.createParameter();
			symbol_537.setName("object");
			//symbol_537.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_537.setType(symbol_111);  // ocl!Sequence{T}?T
			
			symbol_536.getOwnedParameters().add(symbol_537);
			symbol_536.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_536);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_538 = PivotFactory.eINSTANCE.createOperation();
			symbol_538.setName("excluding");
			//symbol_538.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_538.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_539 = PivotFactory.eINSTANCE.createParameter();
			symbol_539.setName("object");
			//symbol_539.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_539.setType(symbol_71);  // ocl!OclAny
			
			symbol_538.getOwnedParameters().add(symbol_539);
			symbol_538.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_538);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_540 = PivotFactory.eINSTANCE.createOperation();
			symbol_114.setName("T2");
			symbol_113.setOwnedParameteredElement(symbol_114);
			symbol_112.getOwnedParameters().add(symbol_113);
			
			symbol_540.setOwnedTemplateSignature(symbol_112);
			symbol_540.setName("flatten");
			//symbol_540.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_540.setType(symbol_227);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			
			symbol_540.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_540);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("including");
			//symbol_541.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_541.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_542 = PivotFactory.eINSTANCE.createParameter();
			symbol_542.setName("object");
			//symbol_542.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_542.setType(symbol_111);  // ocl!Sequence{T}?T
			
			symbol_541.getOwnedParameters().add(symbol_542);
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_543 = PivotFactory.eINSTANCE.createOperation();
			symbol_543.setName("insertAt");
			//symbol_543.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_543.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_544 = PivotFactory.eINSTANCE.createParameter();
			symbol_544.setName("index");
			//symbol_544.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_544.setType(symbol_56);  // Integer
			
			symbol_543.getOwnedParameters().add(symbol_544);
			Parameter symbol_545 = PivotFactory.eINSTANCE.createParameter();
			symbol_545.setName("object");
			//symbol_545.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_545.setType(symbol_111);  // ocl!Sequence{T}?T
			
			symbol_543.getOwnedParameters().add(symbol_545);
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_543);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("prepend");
			//symbol_546.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_546.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_547 = PivotFactory.eINSTANCE.createParameter();
			symbol_547.setName("object");
			//symbol_547.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_547.setType(symbol_111);  // ocl!Sequence{T}?T
			
			symbol_546.getOwnedParameters().add(symbol_547);
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_546);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_548 = PivotFactory.eINSTANCE.createIteration();
			symbol_548.setName("reject");
			//symbol_548.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_548.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_549 = PivotFactory.eINSTANCE.createParameter();
			symbol_549.setName("i");
			symbol_549.setType(symbol_111);  // ocl!Sequence{T}?T
			symbol_548.getOwnedIterators().add(symbol_549);
			Parameter symbol_550 = PivotFactory.eINSTANCE.createParameter();
			symbol_550.setName("body");
			//symbol_550.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_550.setType(symbol_178);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_548.getOwnedParameters().add(symbol_550);
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_551 = PivotFactory.eINSTANCE.createOperation();
			symbol_551.setName("reverse");
			//symbol_551.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_551.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_551.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_551);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_552 = PivotFactory.eINSTANCE.createIteration();
			symbol_552.setName("select");
			//symbol_552.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_552.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_553 = PivotFactory.eINSTANCE.createParameter();
			symbol_553.setName("i");
			symbol_553.setType(symbol_111);  // ocl!Sequence{T}?T
			symbol_552.getOwnedIterators().add(symbol_553);
			Parameter symbol_554 = PivotFactory.eINSTANCE.createParameter();
			symbol_554.setName("body");
			//symbol_554.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_554.setType(symbol_178);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_552.getOwnedParameters().add(symbol_554);
			symbol_552.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_552);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("subSequence");
			//symbol_555.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_555.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_556 = PivotFactory.eINSTANCE.createParameter();
			symbol_556.setName("lower");
			//symbol_556.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_556.setType(symbol_56);  // Integer
			
			symbol_555.getOwnedParameters().add(symbol_556);
			Parameter symbol_557 = PivotFactory.eINSTANCE.createParameter();
			symbol_557.setName("upper");
			//symbol_557.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_557.setType(symbol_56);  // Integer
			
			symbol_555.getOwnedParameters().add(symbol_557);
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_555);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_558 = PivotFactory.eINSTANCE.createOperation();
			symbol_558.setName("union");
			//symbol_558.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_558.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_559 = PivotFactory.eINSTANCE.createParameter();
			symbol_559.setName("s");
			//symbol_559.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_559.setType(symbol_221);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_558.getOwnedParameters().add(symbol_559);
			symbol_558.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_558);
		}
		symbol_1.getOwnedTypes().add(symbol_108);
		//
		// ocl::Set ocl!Set{T}
		//
		symbol_115.setName("Set");
		//symbol_115.setMoniker("ocl!Set{T}");
		symbol_115.setElementType(symbol_118);
		symbol_118.setName("T");
		symbol_117.setOwnedParameteredElement(symbol_118);
		symbol_116.getOwnedParameters().add(symbol_117);
		
		symbol_115.setOwnedTemplateSignature(symbol_116);
		symbol_115.getSuperClasses().add(symbol_183); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_115.getSuperClasses().add(symbol_258); // ocl!UniqueCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_560 = PivotFactory.eINSTANCE.createOperation();
			symbol_560.setName("-");
			//symbol_560.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_560.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_561 = PivotFactory.eINSTANCE.createParameter();
			symbol_561.setName("s");
			//symbol_561.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_561.setType(symbol_235);  // ocl!Set[ocl!OclAny]
			
			symbol_560.getOwnedParameters().add(symbol_561);
			symbol_560.setPrecedence(symbol_5);
			symbol_560.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_560);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_562 = PivotFactory.eINSTANCE.createOperation();
			symbol_562.setName("<>");
			//symbol_562.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_562.setType(symbol_19);  // Boolean
			
			Parameter symbol_563 = PivotFactory.eINSTANCE.createParameter();
			symbol_563.setName("object2");
			//symbol_563.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_563.setType(symbol_71);  // ocl!OclAny
			
			symbol_562.getOwnedParameters().add(symbol_563);
			symbol_562.setPrecedence(symbol_7);
			symbol_562.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_562);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_564 = PivotFactory.eINSTANCE.createOperation();
			symbol_564.setName("=");
			//symbol_564.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_564.setType(symbol_19);  // Boolean
			
			Parameter symbol_565 = PivotFactory.eINSTANCE.createParameter();
			symbol_565.setName("object2");
			//symbol_565.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_565.setType(symbol_71);  // ocl!OclAny
			
			symbol_564.getOwnedParameters().add(symbol_565);
			symbol_564.setPrecedence(symbol_7);
			symbol_564.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_564);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_566 = PivotFactory.eINSTANCE.createOperation();
			symbol_566.setName("excluding");
			//symbol_566.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_566.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_567 = PivotFactory.eINSTANCE.createParameter();
			symbol_567.setName("object");
			//symbol_567.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_567.setType(symbol_71);  // ocl!OclAny
			
			symbol_566.getOwnedParameters().add(symbol_567);
			symbol_566.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_566);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_568 = PivotFactory.eINSTANCE.createOperation();
			symbol_121.setName("T2");
			symbol_120.setOwnedParameteredElement(symbol_121);
			symbol_119.getOwnedParameters().add(symbol_120);
			
			symbol_568.setOwnedTemplateSignature(symbol_119);
			symbol_568.setName("flatten");
			//symbol_568.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_568.setType(symbol_241);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			
			symbol_568.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_568);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_569 = PivotFactory.eINSTANCE.createOperation();
			symbol_569.setName("including");
			//symbol_569.setMoniker("ocl!Set{T}!including(T)");
			symbol_569.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_570 = PivotFactory.eINSTANCE.createParameter();
			symbol_570.setName("object");
			//symbol_570.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_570.setType(symbol_118);  // ocl!Set{T}?T
			
			symbol_569.getOwnedParameters().add(symbol_570);
			symbol_569.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_569);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_571 = PivotFactory.eINSTANCE.createOperation();
			symbol_571.setName("intersection");
			//symbol_571.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_571.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_572 = PivotFactory.eINSTANCE.createParameter();
			symbol_572.setName("s");
			//symbol_572.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_572.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			symbol_571.getOwnedParameters().add(symbol_572);
			symbol_571.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_571);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_573 = PivotFactory.eINSTANCE.createIteration();
			symbol_573.setName("reject");
			//symbol_573.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_573.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_574 = PivotFactory.eINSTANCE.createParameter();
			symbol_574.setName("i");
			symbol_574.setType(symbol_118);  // ocl!Set{T}?T
			symbol_573.getOwnedIterators().add(symbol_574);
			Parameter symbol_575 = PivotFactory.eINSTANCE.createParameter();
			symbol_575.setName("body");
			//symbol_575.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_575.setType(symbol_176);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_573.getOwnedParameters().add(symbol_575);
			symbol_573.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_573);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_576 = PivotFactory.eINSTANCE.createIteration();
			symbol_576.setName("select");
			//symbol_576.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_576.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_577 = PivotFactory.eINSTANCE.createParameter();
			symbol_577.setName("i");
			symbol_577.setType(symbol_118);  // ocl!Set{T}?T
			symbol_576.getOwnedIterators().add(symbol_577);
			Parameter symbol_578 = PivotFactory.eINSTANCE.createParameter();
			symbol_578.setName("body");
			//symbol_578.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_578.setType(symbol_176);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_576.getOwnedParameters().add(symbol_578);
			symbol_576.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_576);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_579 = PivotFactory.eINSTANCE.createOperation();
			symbol_579.setName("symmetricDifference");
			//symbol_579.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_579.setType(symbol_234);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_580 = PivotFactory.eINSTANCE.createParameter();
			symbol_580.setName("s");
			//symbol_580.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_580.setType(symbol_235);  // ocl!Set[ocl!OclAny]
			
			symbol_579.getOwnedParameters().add(symbol_580);
			symbol_579.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_115.getOwnedOperations().add(symbol_579);
		}
		symbol_1.getOwnedTypes().add(symbol_115);
		//
		// ocl::String String
		//
		symbol_122.setName("String");
		//symbol_122.setMoniker("String");
		symbol_122.getSuperClasses().add(symbol_71); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_581 = PivotFactory.eINSTANCE.createOperation();
			symbol_581.setName("+");
			//symbol_581.setMoniker("String!+(String)");
			symbol_581.setType(symbol_122);  // String
			
			Parameter symbol_582 = PivotFactory.eINSTANCE.createParameter();
			symbol_582.setName("s");
			//symbol_582.setMoniker("String!+(String)!s");
			symbol_582.setType(symbol_122);  // String
			
			symbol_581.getOwnedParameters().add(symbol_582);
			symbol_581.setPrecedence(symbol_5);
			symbol_581.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_581);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_583 = PivotFactory.eINSTANCE.createOperation();
			symbol_583.setName("<");
			//symbol_583.setMoniker("String!<(String)");
			symbol_583.setType(symbol_19);  // Boolean
			
			Parameter symbol_584 = PivotFactory.eINSTANCE.createParameter();
			symbol_584.setName("s");
			//symbol_584.setMoniker("String!<(String)!s");
			symbol_584.setType(symbol_122);  // String
			
			symbol_583.getOwnedParameters().add(symbol_584);
			symbol_583.setPrecedence(symbol_6);
			symbol_583.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_583);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_585 = PivotFactory.eINSTANCE.createOperation();
			symbol_585.setName("<=");
			//symbol_585.setMoniker("String!<=(String)");
			symbol_585.setType(symbol_19);  // Boolean
			
			Parameter symbol_586 = PivotFactory.eINSTANCE.createParameter();
			symbol_586.setName("s");
			//symbol_586.setMoniker("String!<=(String)!s");
			symbol_586.setType(symbol_122);  // String
			
			symbol_585.getOwnedParameters().add(symbol_586);
			symbol_585.setPrecedence(symbol_6);
			symbol_585.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_585);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_587 = PivotFactory.eINSTANCE.createOperation();
			symbol_587.setName("<>");
			//symbol_587.setMoniker("String!<>(ocl!OclAny)");
			symbol_587.setType(symbol_19);  // Boolean
			
			Parameter symbol_588 = PivotFactory.eINSTANCE.createParameter();
			symbol_588.setName("object2");
			//symbol_588.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_588.setType(symbol_71);  // ocl!OclAny
			
			symbol_587.getOwnedParameters().add(symbol_588);
			symbol_587.setPrecedence(symbol_7);
			symbol_587.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_587);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_589 = PivotFactory.eINSTANCE.createOperation();
			symbol_589.setName("=");
			//symbol_589.setMoniker("String!=(ocl!OclAny)");
			symbol_589.setType(symbol_19);  // Boolean
			
			Parameter symbol_590 = PivotFactory.eINSTANCE.createParameter();
			symbol_590.setName("object2");
			//symbol_590.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_590.setType(symbol_71);  // ocl!OclAny
			
			symbol_589.getOwnedParameters().add(symbol_590);
			symbol_589.setPrecedence(symbol_7);
			symbol_589.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_589);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_591 = PivotFactory.eINSTANCE.createOperation();
			symbol_591.setName(">");
			//symbol_591.setMoniker("String!>(String)");
			symbol_591.setType(symbol_19);  // Boolean
			
			Parameter symbol_592 = PivotFactory.eINSTANCE.createParameter();
			symbol_592.setName("s");
			//symbol_592.setMoniker("String!>(String)!s");
			symbol_592.setType(symbol_122);  // String
			
			symbol_591.getOwnedParameters().add(symbol_592);
			symbol_591.setPrecedence(symbol_6);
			symbol_591.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_591);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_593 = PivotFactory.eINSTANCE.createOperation();
			symbol_593.setName(">=");
			//symbol_593.setMoniker("String!>=(String)");
			symbol_593.setType(symbol_19);  // Boolean
			
			Parameter symbol_594 = PivotFactory.eINSTANCE.createParameter();
			symbol_594.setName("s");
			//symbol_594.setMoniker("String!>=(String)!s");
			symbol_594.setType(symbol_122);  // String
			
			symbol_593.getOwnedParameters().add(symbol_594);
			symbol_593.setPrecedence(symbol_6);
			symbol_593.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_593);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_595 = PivotFactory.eINSTANCE.createOperation();
			symbol_595.setName("at");
			//symbol_595.setMoniker("String!at(Integer)");
			symbol_595.setType(symbol_122);  // String
			
			Parameter symbol_596 = PivotFactory.eINSTANCE.createParameter();
			symbol_596.setName("i");
			//symbol_596.setMoniker("String!at(Integer)!i");
			symbol_596.setType(symbol_56);  // Integer
			
			symbol_595.getOwnedParameters().add(symbol_596);
			symbol_595.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_595);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_597 = PivotFactory.eINSTANCE.createOperation();
			symbol_597.setName("characters");
			//symbol_597.setMoniker("String!characters()");
			symbol_597.setType(symbol_226);  // ocl!Sequence[String]
			
			symbol_597.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_597);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_598 = PivotFactory.eINSTANCE.createOperation();
			symbol_598.setName("concat");
			//symbol_598.setMoniker("String!concat(String)");
			symbol_598.setType(symbol_122);  // String
			
			Parameter symbol_599 = PivotFactory.eINSTANCE.createParameter();
			symbol_599.setName("s");
			//symbol_599.setMoniker("String!concat(String)!s");
			symbol_599.setType(symbol_122);  // String
			
			symbol_598.getOwnedParameters().add(symbol_599);
			symbol_598.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_598);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_600 = PivotFactory.eINSTANCE.createOperation();
			symbol_600.setName("equalsIgnoreCase");
			//symbol_600.setMoniker("String!equalsIgnoreCase(String)");
			symbol_600.setType(symbol_19);  // Boolean
			
			Parameter symbol_601 = PivotFactory.eINSTANCE.createParameter();
			symbol_601.setName("s");
			//symbol_601.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_601.setType(symbol_122);  // String
			
			symbol_600.getOwnedParameters().add(symbol_601);
			symbol_600.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_600);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_602 = PivotFactory.eINSTANCE.createOperation();
			symbol_602.setName("indexOf");
			//symbol_602.setMoniker("String!indexOf(String)");
			symbol_602.setType(symbol_56);  // Integer
			
			Parameter symbol_603 = PivotFactory.eINSTANCE.createParameter();
			symbol_603.setName("s");
			//symbol_603.setMoniker("String!indexOf(String)!s");
			symbol_603.setType(symbol_122);  // String
			
			symbol_602.getOwnedParameters().add(symbol_603);
			symbol_602.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_602);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_604 = PivotFactory.eINSTANCE.createOperation();
			symbol_604.setName("size");
			//symbol_604.setMoniker("String!size()");
			symbol_604.setType(symbol_56);  // Integer
			
			symbol_604.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_604);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_605 = PivotFactory.eINSTANCE.createOperation();
			symbol_605.setName("substring");
			//symbol_605.setMoniker("String!substring(Integer,Integer)");
			symbol_605.setType(symbol_122);  // String
			
			Parameter symbol_606 = PivotFactory.eINSTANCE.createParameter();
			symbol_606.setName("lower");
			//symbol_606.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_606.setType(symbol_56);  // Integer
			
			symbol_605.getOwnedParameters().add(symbol_606);
			Parameter symbol_607 = PivotFactory.eINSTANCE.createParameter();
			symbol_607.setName("upper");
			//symbol_607.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_607.setType(symbol_56);  // Integer
			
			symbol_605.getOwnedParameters().add(symbol_607);
			symbol_605.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_605);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_608 = PivotFactory.eINSTANCE.createOperation();
			symbol_608.setName("toBoolean");
			//symbol_608.setMoniker("String!toBoolean()");
			symbol_608.setType(symbol_19);  // Boolean
			
			symbol_608.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_608);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_609 = PivotFactory.eINSTANCE.createOperation();
			symbol_609.setName("toInteger");
			//symbol_609.setMoniker("String!toInteger()");
			symbol_609.setType(symbol_56);  // Integer
			
			symbol_609.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_609);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_610 = PivotFactory.eINSTANCE.createOperation();
			symbol_610.setName("toLower");
			//symbol_610.setMoniker("String!toLower()");
			symbol_610.setType(symbol_122);  // String
			
			symbol_610.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_610);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_611 = PivotFactory.eINSTANCE.createOperation();
			symbol_611.setName("toLowerCase");
			//symbol_611.setMoniker("String!toLowerCase()");
			symbol_611.setType(symbol_122);  // String
			
			symbol_611.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_611);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_612 = PivotFactory.eINSTANCE.createOperation();
			symbol_612.setName("toReal");
			//symbol_612.setMoniker("String!toReal()");
			symbol_612.setType(symbol_104);  // Real
			
			symbol_612.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_612);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_613 = PivotFactory.eINSTANCE.createOperation();
			symbol_613.setName("toString");
			//symbol_613.setMoniker("String!toString()");
			symbol_613.setType(symbol_122);  // String
			
			symbol_613.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_613);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_614 = PivotFactory.eINSTANCE.createOperation();
			symbol_614.setName("toUpper");
			//symbol_614.setMoniker("String!toUpper()");
			symbol_614.setType(symbol_122);  // String
			
			symbol_614.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_614);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_615 = PivotFactory.eINSTANCE.createOperation();
			symbol_615.setName("toUpperCase");
			//symbol_615.setMoniker("String!toUpperCase()");
			symbol_615.setType(symbol_122);  // String
			
			symbol_615.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_615);
		}
		symbol_1.getOwnedTypes().add(symbol_122);
		//
		// ocl::UniqueCollection ocl!UniqueCollection{T}
		//
		symbol_123.setName("UniqueCollection");
		//symbol_123.setMoniker("ocl!UniqueCollection{T}");
		symbol_123.setElementType(symbol_126);
		symbol_126.setName("T");
		symbol_125.setOwnedParameteredElement(symbol_126);
		symbol_124.getOwnedParameters().add(symbol_125);
		
		symbol_123.setOwnedTemplateSignature(symbol_124);
		symbol_123.getSuperClasses().add(symbol_161); // ocl!Collection[ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_616 = PivotFactory.eINSTANCE.createIteration();
			symbol_616.setName("sortedBy");
			//symbol_616.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_616.setType(symbol_218);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_617 = PivotFactory.eINSTANCE.createParameter();
			symbol_617.setName("i");
			symbol_617.setType(symbol_126);  // ocl!UniqueCollection{T}?T
			symbol_616.getOwnedIterators().add(symbol_617);
			Parameter symbol_618 = PivotFactory.eINSTANCE.createParameter();
			symbol_618.setName("body");
			//symbol_618.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_618.setType(symbol_164);  // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
			
			symbol_616.getOwnedParameters().add(symbol_618);
			symbol_616.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_616);
		}
		symbol_1.getOwnedTypes().add(symbol_123);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_127.setName("UnlimitedNatural");
		//symbol_127.setMoniker("UnlimitedNatural");
		symbol_127.getSuperClasses().add(symbol_56); // Integer
		symbol_1.getOwnedTypes().add(symbol_127);
		//
		// ocl::$orphanage
		//
		symbol_128.setName("$orphanage");
		symbol_128.setMoniker("$orphanage");
		//
		// ocl::$orphanage::$orphanage $orphanage!$orphanage
		//
		symbol_129.setName("$orphanage");
		//symbol_129.setMoniker("$orphanage!$orphanage");
		symbol_128.getOwnedTypes().add(symbol_129);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_130.setName("Bag");
		//symbol_130.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_130.setElementType(symbol_30);
		{
			TemplateBinding symbol_619 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_619.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_620 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_620.setFormal(symbol_14);	
				symbol_620.setActual(symbol_30);	
				symbol_619.getParameterSubstitutions().add(symbol_620);
			}
			symbol_130.getTemplateBindings().add(symbol_619);
		}
		symbol_130.getSuperClasses().add(symbol_197); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_130.getSuperClasses().add(symbol_193); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_130);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_131.setName("Bag");
		//symbol_131.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_131.setElementType(symbol_18);
		{
			TemplateBinding symbol_621 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_621.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_622 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_622.setFormal(symbol_14);	
				symbol_622.setActual(symbol_18);	
				symbol_621.getParameterSubstitutions().add(symbol_622);
			}
			symbol_131.getTemplateBindings().add(symbol_621);
		}
		symbol_131.getSuperClasses().add(symbol_200); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_131.getSuperClasses().add(symbol_185); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_131);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_132.setName("Bag");
		//symbol_132.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_132.setElementType(symbol_63);
		{
			TemplateBinding symbol_623 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_623.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_624 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_624.setFormal(symbol_14);	
				symbol_624.setActual(symbol_63);	
				symbol_623.getParameterSubstitutions().add(symbol_624);
			}
			symbol_132.getTemplateBindings().add(symbol_623);
		}
		symbol_132.getSuperClasses().add(symbol_199); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_132.getSuperClasses().add(symbol_187); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_128.getOwnedTypes().add(symbol_132);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}?T]
		//
		symbol_133.setName("Bag");
		//symbol_133.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}?T]");
		symbol_133.setElementType(symbol_60);
		{
			TemplateBinding symbol_625 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_625.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_626 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_626.setFormal(symbol_14);	
				symbol_626.setActual(symbol_60);	
				symbol_625.getParameterSubstitutions().add(symbol_626);
			}
			symbol_133.getTemplateBindings().add(symbol_625);
		}
		symbol_133.getSuperClasses().add(symbol_192); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_133.getSuperClasses().add(symbol_203); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_133);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_134.setName("Bag");
		//symbol_134.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_134.setElementType(symbol_15);
		{
			TemplateBinding symbol_627 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_627.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_628 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_628.setFormal(symbol_14);	
				symbol_628.setActual(symbol_15);	
				symbol_627.getParameterSubstitutions().add(symbol_628);
			}
			symbol_134.getTemplateBindings().add(symbol_627);
		}
		symbol_134.getSuperClasses().add(symbol_194); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_134.getSuperClasses().add(symbol_207); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_128.getOwnedTypes().add(symbol_134);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_135.setName("Collection");
		//symbol_135.setMoniker("ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_135.setElementType(symbol_82);
		{
			TemplateBinding symbol_629 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_629.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_630 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_630.setFormal(symbol_29);	
				symbol_630.setActual(symbol_82);	
				symbol_629.getParameterSubstitutions().add(symbol_630);
			}
			symbol_135.getTemplateBindings().add(symbol_629);
		}
		symbol_135.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_135);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_136.setName("Collection");
		//symbol_136.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_136.setElementType(symbol_33);
		{
			TemplateBinding symbol_631 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_631.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_632 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_632.setFormal(symbol_29);	
				symbol_632.setActual(symbol_33);	
				symbol_631.getParameterSubstitutions().add(symbol_632);
			}
			symbol_136.getTemplateBindings().add(symbol_631);
		}
		symbol_136.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_136);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_137.setName("Collection");
		//symbol_137.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_137.setElementType(symbol_42);
		{
			TemplateBinding symbol_633 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_633.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_634 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_634.setFormal(symbol_29);	
				symbol_634.setActual(symbol_42);	
				symbol_633.getParameterSubstitutions().add(symbol_634);
			}
			symbol_137.getTemplateBindings().add(symbol_633);
		}
		symbol_137.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_137);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_138.setName("Collection");
		//symbol_138.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_138.setElementType(symbol_30);
		{
			TemplateBinding symbol_635 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_635.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_636 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_636.setFormal(symbol_29);	
				symbol_636.setActual(symbol_30);	
				symbol_635.getParameterSubstitutions().add(symbol_636);
			}
			symbol_138.getTemplateBindings().add(symbol_635);
		}
		symbol_138.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_138);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_139.setName("Collection");
		//symbol_139.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_139.setElementType(symbol_74);
		{
			TemplateBinding symbol_637 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_637.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_638 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_638.setFormal(symbol_29);	
				symbol_638.setActual(symbol_74);	
				symbol_637.getParameterSubstitutions().add(symbol_638);
			}
			symbol_139.getTemplateBindings().add(symbol_637);
		}
		symbol_139.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_139);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_140.setName("Collection");
		//symbol_140.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_140.setElementType(symbol_18);
		{
			TemplateBinding symbol_639 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_639.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_640 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_640.setFormal(symbol_29);	
				symbol_640.setActual(symbol_18);	
				symbol_639.getParameterSubstitutions().add(symbol_640);
			}
			symbol_140.getTemplateBindings().add(symbol_639);
		}
		symbol_140.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_140);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_141.setName("Collection");
		//symbol_141.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_141.setElementType(symbol_60);
		{
			TemplateBinding symbol_641 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_641.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_642 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_642.setFormal(symbol_29);	
				symbol_642.setActual(symbol_60);	
				symbol_641.getParameterSubstitutions().add(symbol_642);
			}
			symbol_141.getTemplateBindings().add(symbol_641);
		}
		symbol_141.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_141);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_142.setName("Collection");
		//symbol_142.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_142.setElementType(symbol_118);
		{
			TemplateBinding symbol_643 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_643.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_644 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_644.setFormal(symbol_29);	
				symbol_644.setActual(symbol_118);	
				symbol_643.getParameterSubstitutions().add(symbol_644);
			}
			symbol_142.getTemplateBindings().add(symbol_643);
		}
		symbol_142.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_142);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_143.setName("Collection");
		//symbol_143.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_143.setElementType(symbol_103);
		{
			TemplateBinding symbol_645 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_645.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_646 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_646.setFormal(symbol_29);	
				symbol_646.setActual(symbol_103);	
				symbol_645.getParameterSubstitutions().add(symbol_646);
			}
			symbol_143.getTemplateBindings().add(symbol_645);
		}
		symbol_143.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_143);
		//
		// ocl::$orphanage::Collection ocl!Collection[String]
		//
		symbol_144.setName("Collection");
		//symbol_144.setMoniker("ocl!Collection[String]");
		symbol_144.setElementType(symbol_122);
		{
			TemplateBinding symbol_647 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_647.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_648 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_648.setFormal(symbol_29);	
				symbol_648.setActual(symbol_122);	
				symbol_647.getParameterSubstitutions().add(symbol_648);
			}
			symbol_144.getTemplateBindings().add(symbol_647);
		}
		symbol_144.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_144);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_145.setName("Collection");
		//symbol_145.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_145.setElementType(symbol_63);
		{
			TemplateBinding symbol_649 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_649.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_650 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_650.setFormal(symbol_29);	
				symbol_650.setActual(symbol_63);	
				symbol_649.getParameterSubstitutions().add(symbol_650);
			}
			symbol_145.getTemplateBindings().add(symbol_649);
		}
		symbol_145.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_145);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_146.setName("Collection");
		//symbol_146.setMoniker("ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_146.setElementType(symbol_26);
		{
			TemplateBinding symbol_651 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_651.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_652 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_652.setFormal(symbol_29);	
				symbol_652.setActual(symbol_26);	
				symbol_651.getParameterSubstitutions().add(symbol_652);
			}
			symbol_146.getTemplateBindings().add(symbol_651);
		}
		symbol_146.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_146);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_147.setName("Collection");
		//symbol_147.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_147.setElementType(symbol_51);
		{
			TemplateBinding symbol_653 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_653.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_654 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_654.setFormal(symbol_29);	
				symbol_654.setActual(symbol_51);	
				symbol_653.getParameterSubstitutions().add(symbol_654);
			}
			symbol_147.getTemplateBindings().add(symbol_653);
		}
		symbol_147.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_147);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_148.setName("Collection");
		//symbol_148.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_148.setElementType(symbol_70);
		{
			TemplateBinding symbol_655 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_655.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_656 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_656.setFormal(symbol_29);	
				symbol_656.setActual(symbol_70);	
				symbol_655.getParameterSubstitutions().add(symbol_656);
			}
			symbol_148.getTemplateBindings().add(symbol_655);
		}
		symbol_148.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_148);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_149.setName("Collection");
		//symbol_149.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_149.setElementType(symbol_39);
		{
			TemplateBinding symbol_657 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_657.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_658 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_658.setFormal(symbol_29);	
				symbol_658.setActual(symbol_39);	
				symbol_657.getParameterSubstitutions().add(symbol_658);
			}
			symbol_149.getTemplateBindings().add(symbol_657);
		}
		symbol_149.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_149);
		//
		// ocl::$orphanage::Collection ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_150.setName("Collection");
		//symbol_150.setMoniker("ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_150.setElementType(symbol_22);
		{
			TemplateBinding symbol_659 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_659.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_660 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_660.setFormal(symbol_29);	
				symbol_660.setActual(symbol_22);	
				symbol_659.getParameterSubstitutions().add(symbol_660);
			}
			symbol_150.getTemplateBindings().add(symbol_659);
		}
		symbol_150.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_150);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_151.setName("Collection");
		//symbol_151.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_151.setElementType(symbol_93);
		{
			TemplateBinding symbol_661 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_661.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_662 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_662.setFormal(symbol_29);	
				symbol_662.setActual(symbol_93);	
				symbol_661.getParameterSubstitutions().add(symbol_662);
			}
			symbol_151.getTemplateBindings().add(symbol_661);
		}
		symbol_151.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_151);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_152.setName("Collection");
		//symbol_152.setMoniker("ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_152.setElementType(symbol_55);
		{
			TemplateBinding symbol_663 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_663.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_664 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_664.setFormal(symbol_29);	
				symbol_664.setActual(symbol_55);	
				symbol_663.getParameterSubstitutions().add(symbol_664);
			}
			symbol_152.getTemplateBindings().add(symbol_663);
		}
		symbol_152.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_152);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_153.setName("Collection");
		//symbol_153.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_153.setElementType(symbol_45);
		{
			TemplateBinding symbol_665 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_665.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_666 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_666.setFormal(symbol_29);	
				symbol_666.setActual(symbol_45);	
				symbol_665.getParameterSubstitutions().add(symbol_666);
			}
			symbol_153.getTemplateBindings().add(symbol_665);
		}
		symbol_153.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_153);
		//
		// ocl::$orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_154.setName("Collection");
		//symbol_154.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_154.setElementType(symbol_242);
		{
			TemplateBinding symbol_667 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_667.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_668 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_668.setFormal(symbol_29);	
				symbol_668.setActual(symbol_242);	
				symbol_667.getParameterSubstitutions().add(symbol_668);
			}
			symbol_154.getTemplateBindings().add(symbol_667);
		}
		symbol_154.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_154);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_155.setName("Collection");
		//symbol_155.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_155.setElementType(symbol_114);
		{
			TemplateBinding symbol_669 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_669.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_670 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_670.setFormal(symbol_29);	
				symbol_670.setActual(symbol_114);	
				symbol_669.getParameterSubstitutions().add(symbol_670);
			}
			symbol_155.getTemplateBindings().add(symbol_669);
		}
		symbol_155.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_155);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_156.setName("Collection");
		//symbol_156.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_156.setElementType(symbol_96);
		{
			TemplateBinding symbol_671 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_671.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_672 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_672.setFormal(symbol_29);	
				symbol_672.setActual(symbol_96);	
				symbol_671.getParameterSubstitutions().add(symbol_672);
			}
			symbol_156.getTemplateBindings().add(symbol_671);
		}
		symbol_156.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_156);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_157.setName("Collection");
		//symbol_157.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_157.setElementType(symbol_15);
		{
			TemplateBinding symbol_673 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_673.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_674 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_674.setFormal(symbol_29);	
				symbol_674.setActual(symbol_15);	
				symbol_673.getParameterSubstitutions().add(symbol_674);
			}
			symbol_157.getTemplateBindings().add(symbol_673);
		}
		symbol_157.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_157);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_158.setName("Collection");
		//symbol_158.setMoniker("ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_158.setElementType(symbol_89);
		{
			TemplateBinding symbol_675 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_675.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_676 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_676.setFormal(symbol_29);	
				symbol_676.setActual(symbol_89);	
				symbol_675.getParameterSubstitutions().add(symbol_676);
			}
			symbol_158.getTemplateBindings().add(symbol_675);
		}
		symbol_158.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_158);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_159.setName("Collection");
		//symbol_159.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_159.setElementType(symbol_121);
		{
			TemplateBinding symbol_677 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_677.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_678 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_678.setFormal(symbol_29);	
				symbol_678.setActual(symbol_121);	
				symbol_677.getParameterSubstitutions().add(symbol_678);
			}
			symbol_159.getTemplateBindings().add(symbol_677);
		}
		symbol_159.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_159);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier]
		//
		symbol_160.setName("Collection");
		//symbol_160.setMoniker("ocl!Collection[ocl!Classifier]");
		symbol_160.setElementType(symbol_23);
		{
			TemplateBinding symbol_679 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_679.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_680 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_680.setFormal(symbol_29);	
				symbol_680.setActual(symbol_23);	
				symbol_679.getParameterSubstitutions().add(symbol_680);
			}
			symbol_160.getTemplateBindings().add(symbol_679);
		}
		symbol_160.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_160);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_161.setName("Collection");
		//symbol_161.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_161.setElementType(symbol_126);
		{
			TemplateBinding symbol_681 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_681.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_682 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_682.setFormal(symbol_29);	
				symbol_682.setActual(symbol_126);	
				symbol_681.getParameterSubstitutions().add(symbol_682);
			}
			symbol_161.getTemplateBindings().add(symbol_681);
		}
		symbol_161.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_161);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_162.setName("Collection");
		//symbol_162.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_162.setElementType(symbol_71);
		{
			TemplateBinding symbol_683 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_683.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_684 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_684.setFormal(symbol_29);	
				symbol_684.setActual(symbol_71);	
				symbol_683.getParameterSubstitutions().add(symbol_684);
			}
			symbol_162.getTemplateBindings().add(symbol_683);
		}
		symbol_162.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_162);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_163.setName("Collection");
		//symbol_163.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_163.setElementType(symbol_111);
		{
			TemplateBinding symbol_685 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_685.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_686 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_686.setFormal(symbol_29);	
				symbol_686.setActual(symbol_111);	
				symbol_685.getParameterSubstitutions().add(symbol_686);
			}
			symbol_163.getTemplateBindings().add(symbol_685);
		}
		symbol_163.getSuperClasses().add(symbol_71); // ocl!OclAny
		symbol_128.getOwnedTypes().add(symbol_163);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		//
		symbol_164.setName("Lambda");
		//symbol_164.setMoniker("Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny");
		symbol_164.setContextType(symbol_126);
		symbol_164.setResultType(symbol_71);
		symbol_128.getOwnedTypes().add(symbol_164);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedSet{T}?T()Boolean
		//
		symbol_165.setName("Lambda");
		//symbol_165.setMoniker("Lambda~ocl!OrderedSet{T}?T()Boolean");
		symbol_165.setContextType(symbol_103);
		symbol_165.setResultType(symbol_19);
		symbol_128.getOwnedTypes().add(symbol_165);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()Boolean
		//
		symbol_166.setName("Lambda");
		//symbol_166.setMoniker("Lambda~ocl!Collection{T}?T()Boolean");
		symbol_166.setContextType(symbol_30);
		symbol_166.setResultType(symbol_19);
		symbol_128.getOwnedTypes().add(symbol_166);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!OclAny
		//
		symbol_167.setName("Lambda");
		//symbol_167.setMoniker("Lambda~ocl!Collection{T}?T()ocl!OclAny");
		symbol_167.setContextType(symbol_30);
		symbol_167.setResultType(symbol_71);
		symbol_128.getOwnedTypes().add(symbol_167);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_168.setName("Lambda");
		//symbol_168.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_168.setContextType(symbol_60);
		symbol_168.setResultType(symbol_66);
		symbol_128.getOwnedTypes().add(symbol_168);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		//
		symbol_169.setName("Lambda");
		//symbol_169.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]");
		symbol_169.setContextType(symbol_60);
		symbol_169.setResultType(symbol_237);
		symbol_128.getOwnedTypes().add(symbol_169);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		//
		symbol_170.setName("Lambda");
		//symbol_170.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]");
		symbol_170.setContextType(symbol_93);
		symbol_170.setResultType(symbol_217);
		symbol_128.getOwnedTypes().add(symbol_170);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_171.setName("Lambda");
		//symbol_171.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_171.setContextType(symbol_60);
		symbol_171.setResultType(symbol_63);
		symbol_128.getOwnedTypes().add(symbol_171);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		//
		symbol_172.setName("Lambda");
		//symbol_172.setMoniker("Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny");
		symbol_172.setContextType(symbol_70);
		symbol_172.setResultType(symbol_71);
		symbol_128.getOwnedTypes().add(symbol_172);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_173.setName("Lambda");
		//symbol_173.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_173.setContextType(symbol_93);
		symbol_173.setResultType(symbol_96);
		symbol_128.getOwnedTypes().add(symbol_173);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_174.setName("Lambda");
		//symbol_174.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_174.setContextType(symbol_30);
		symbol_174.setResultType(symbol_33);
		symbol_128.getOwnedTypes().add(symbol_174);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Bag{T}?T()Boolean
		//
		symbol_175.setName("Lambda");
		//symbol_175.setMoniker("Lambda~ocl!Bag{T}?T()Boolean");
		symbol_175.setContextType(symbol_15);
		symbol_175.setResultType(symbol_19);
		symbol_128.getOwnedTypes().add(symbol_175);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Set{T}?T()Boolean
		//
		symbol_176.setName("Lambda");
		//symbol_176.setMoniker("Lambda~ocl!Set{T}?T()Boolean");
		symbol_176.setContextType(symbol_118);
		symbol_176.setResultType(symbol_19);
		symbol_128.getOwnedTypes().add(symbol_176);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_177.setName("Lambda");
		//symbol_177.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_177.setContextType(symbol_93);
		symbol_177.setResultType(symbol_99);
		symbol_128.getOwnedTypes().add(symbol_177);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Sequence{T}?T()Boolean
		//
		symbol_178.setName("Lambda");
		//symbol_178.setMoniker("Lambda~ocl!Sequence{T}?T()Boolean");
		symbol_178.setContextType(symbol_111);
		symbol_178.setResultType(symbol_19);
		symbol_128.getOwnedTypes().add(symbol_178);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_179.setName("Lambda");
		//symbol_179.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_179.setContextType(symbol_30);
		symbol_179.setResultType(symbol_36);
		symbol_128.getOwnedTypes().add(symbol_179);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_180.setName("NonOrderedCollection");
		//symbol_180.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_180.setElementType(symbol_89);
		{
			TemplateBinding symbol_687 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_687.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_688 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_688.setFormal(symbol_59);	
				symbol_688.setActual(symbol_89);	
				symbol_687.getParameterSubstitutions().add(symbol_688);
			}
			symbol_180.getTemplateBindings().add(symbol_687);
		}
		symbol_180.getSuperClasses().add(symbol_158); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_180);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_181.setName("NonOrderedCollection");
		//symbol_181.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_181.setElementType(symbol_71);
		{
			TemplateBinding symbol_689 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_689.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_690 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_690.setFormal(symbol_59);	
				symbol_690.setActual(symbol_71);	
				symbol_689.getParameterSubstitutions().add(symbol_690);
			}
			symbol_181.getTemplateBindings().add(symbol_689);
		}
		symbol_181.getSuperClasses().add(symbol_162); // ocl!Collection[ocl!OclAny]
		symbol_128.getOwnedTypes().add(symbol_181);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_182.setName("NonOrderedCollection");
		//symbol_182.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_182.setElementType(symbol_74);
		{
			TemplateBinding symbol_691 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_691.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_692 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_692.setFormal(symbol_59);	
				symbol_692.setActual(symbol_74);	
				symbol_691.getParameterSubstitutions().add(symbol_692);
			}
			symbol_182.getTemplateBindings().add(symbol_691);
		}
		symbol_182.getSuperClasses().add(symbol_139); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_182);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_183.setName("NonOrderedCollection");
		//symbol_183.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_183.setElementType(symbol_118);
		{
			TemplateBinding symbol_693 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_693.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_694 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_694.setFormal(symbol_59);	
				symbol_694.setActual(symbol_118);	
				symbol_693.getParameterSubstitutions().add(symbol_694);
			}
			symbol_183.getTemplateBindings().add(symbol_693);
		}
		symbol_183.getSuperClasses().add(symbol_142); // ocl!Collection[ocl!Set{T}?T]
		symbol_128.getOwnedTypes().add(symbol_183);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_184.setName("NonOrderedCollection");
		//symbol_184.setMoniker("ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_184.setElementType(symbol_26);
		{
			TemplateBinding symbol_695 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_695.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_696 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_696.setFormal(symbol_59);	
				symbol_696.setActual(symbol_26);	
				symbol_695.getParameterSubstitutions().add(symbol_696);
			}
			symbol_184.getTemplateBindings().add(symbol_695);
		}
		symbol_184.getSuperClasses().add(symbol_146); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_184);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_185.setName("NonOrderedCollection");
		//symbol_185.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_185.setElementType(symbol_18);
		{
			TemplateBinding symbol_697 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_697.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_698 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_698.setFormal(symbol_59);	
				symbol_698.setActual(symbol_18);	
				symbol_697.getParameterSubstitutions().add(symbol_698);
			}
			symbol_185.getTemplateBindings().add(symbol_697);
		}
		symbol_185.getSuperClasses().add(symbol_140); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_185);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_186.setName("NonOrderedCollection");
		//symbol_186.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_186.setElementType(symbol_55);
		{
			TemplateBinding symbol_699 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_699.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_700 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_700.setFormal(symbol_59);	
				symbol_700.setActual(symbol_55);	
				symbol_699.getParameterSubstitutions().add(symbol_700);
			}
			symbol_186.getTemplateBindings().add(symbol_699);
		}
		symbol_186.getSuperClasses().add(symbol_152); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_186);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_187.setName("NonOrderedCollection");
		//symbol_187.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_187.setElementType(symbol_63);
		{
			TemplateBinding symbol_701 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_701.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_702 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_702.setFormal(symbol_59);	
				symbol_702.setActual(symbol_63);	
				symbol_701.getParameterSubstitutions().add(symbol_702);
			}
			symbol_187.getTemplateBindings().add(symbol_701);
		}
		symbol_187.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_128.getOwnedTypes().add(symbol_187);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_188.setName("NonOrderedCollection");
		//symbol_188.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_188.setElementType(symbol_82);
		{
			TemplateBinding symbol_703 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_703.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_704 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_704.setFormal(symbol_59);	
				symbol_704.setActual(symbol_82);	
				symbol_703.getParameterSubstitutions().add(symbol_704);
			}
			symbol_188.getTemplateBindings().add(symbol_703);
		}
		symbol_188.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_188);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier]
		//
		symbol_189.setName("NonOrderedCollection");
		//symbol_189.setMoniker("ocl!NonOrderedCollection[ocl!Classifier]");
		symbol_189.setElementType(symbol_23);
		{
			TemplateBinding symbol_705 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_705.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_706 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_706.setFormal(symbol_59);	
				symbol_706.setActual(symbol_23);	
				symbol_705.getParameterSubstitutions().add(symbol_706);
			}
			symbol_189.getTemplateBindings().add(symbol_705);
		}
		symbol_189.getSuperClasses().add(symbol_160); // ocl!Collection[ocl!Classifier]
		symbol_128.getOwnedTypes().add(symbol_189);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_190.setName("NonOrderedCollection");
		//symbol_190.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_190.setElementType(symbol_103);
		{
			TemplateBinding symbol_707 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_707.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_708 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_708.setFormal(symbol_59);	
				symbol_708.setActual(symbol_103);	
				symbol_707.getParameterSubstitutions().add(symbol_708);
			}
			symbol_190.getTemplateBindings().add(symbol_707);
		}
		symbol_190.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_128.getOwnedTypes().add(symbol_190);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_191.setName("NonOrderedCollection");
		//symbol_191.setMoniker("ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_191.setElementType(symbol_22);
		{
			TemplateBinding symbol_709 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_709.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_710 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_710.setFormal(symbol_59);	
				symbol_710.setActual(symbol_22);	
				symbol_709.getParameterSubstitutions().add(symbol_710);
			}
			symbol_191.getTemplateBindings().add(symbol_709);
		}
		symbol_191.getSuperClasses().add(symbol_150); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_191);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_192.setName("NonOrderedCollection");
		//symbol_192.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_192.setElementType(symbol_60);
		{
			TemplateBinding symbol_711 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_711.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_712 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_712.setFormal(symbol_59);	
				symbol_712.setActual(symbol_60);	
				symbol_711.getParameterSubstitutions().add(symbol_712);
			}
			symbol_192.getTemplateBindings().add(symbol_711);
		}
		symbol_192.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_192);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_193.setName("NonOrderedCollection");
		//symbol_193.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_193.setElementType(symbol_30);
		{
			TemplateBinding symbol_713 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_713.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_714 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_714.setFormal(symbol_59);	
				symbol_714.setActual(symbol_30);	
				symbol_713.getParameterSubstitutions().add(symbol_714);
			}
			symbol_193.getTemplateBindings().add(symbol_713);
		}
		symbol_193.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_193);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_194.setName("NonOrderedCollection");
		//symbol_194.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_194.setElementType(symbol_15);
		{
			TemplateBinding symbol_715 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_715.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_716 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_716.setFormal(symbol_59);	
				symbol_716.setActual(symbol_15);	
				symbol_715.getParameterSubstitutions().add(symbol_716);
			}
			symbol_194.getTemplateBindings().add(symbol_715);
		}
		symbol_194.getSuperClasses().add(symbol_157); // ocl!Collection[ocl!Bag{T}?T]
		symbol_128.getOwnedTypes().add(symbol_194);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_195.setName("NonOrderedCollection");
		//symbol_195.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_195.setElementType(symbol_242);
		{
			TemplateBinding symbol_717 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_717.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_718 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_718.setFormal(symbol_59);	
				symbol_718.setActual(symbol_242);	
				symbol_717.getParameterSubstitutions().add(symbol_718);
			}
			symbol_195.getTemplateBindings().add(symbol_717);
		}
		symbol_195.getSuperClasses().add(symbol_154); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_128.getOwnedTypes().add(symbol_195);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_196.setName("NonOrderedCollection");
		//symbol_196.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_196.setElementType(symbol_121);
		{
			TemplateBinding symbol_719 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_719.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_720 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_720.setFormal(symbol_59);	
				symbol_720.setActual(symbol_121);	
				symbol_719.getParameterSubstitutions().add(symbol_720);
			}
			symbol_196.getTemplateBindings().add(symbol_719);
		}
		symbol_196.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_196);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_197.setName("NonUniqueCollection");
		//symbol_197.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_197.setElementType(symbol_30);
		{
			TemplateBinding symbol_721 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_721.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_722 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_722.setFormal(symbol_69);	
				symbol_722.setActual(symbol_30);	
				symbol_721.getParameterSubstitutions().add(symbol_722);
			}
			symbol_197.getTemplateBindings().add(symbol_721);
		}
		symbol_197.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_197);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_198.setName("NonUniqueCollection");
		//symbol_198.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_198.setElementType(symbol_93);
		{
			TemplateBinding symbol_723 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_723.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_724 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_724.setFormal(symbol_69);	
				symbol_724.setActual(symbol_93);	
				symbol_723.getParameterSubstitutions().add(symbol_724);
			}
			symbol_198.getTemplateBindings().add(symbol_723);
		}
		symbol_198.getSuperClasses().add(symbol_151); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_198);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_199.setName("NonUniqueCollection");
		//symbol_199.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_199.setElementType(symbol_63);
		{
			TemplateBinding symbol_725 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_725.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_726 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_726.setFormal(symbol_69);	
				symbol_726.setActual(symbol_63);	
				symbol_725.getParameterSubstitutions().add(symbol_726);
			}
			symbol_199.getTemplateBindings().add(symbol_725);
		}
		symbol_199.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_128.getOwnedTypes().add(symbol_199);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_200.setName("NonUniqueCollection");
		//symbol_200.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_200.setElementType(symbol_18);
		{
			TemplateBinding symbol_727 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_727.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_728 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_728.setFormal(symbol_69);	
				symbol_728.setActual(symbol_18);	
				symbol_727.getParameterSubstitutions().add(symbol_728);
			}
			symbol_200.getTemplateBindings().add(symbol_727);
		}
		symbol_200.getSuperClasses().add(symbol_140); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_200);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_201.setName("NonUniqueCollection");
		//symbol_201.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_201.setElementType(symbol_111);
		{
			TemplateBinding symbol_729 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_729.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_730 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_730.setFormal(symbol_69);	
				symbol_730.setActual(symbol_111);	
				symbol_729.getParameterSubstitutions().add(symbol_730);
			}
			symbol_201.getTemplateBindings().add(symbol_729);
		}
		symbol_201.getSuperClasses().add(symbol_163); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_128.getOwnedTypes().add(symbol_201);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_202.setName("NonUniqueCollection");
		//symbol_202.setMoniker("ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_202.setElementType(symbol_70);
		{
			TemplateBinding symbol_731 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_731.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_732 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_732.setFormal(symbol_69);	
				symbol_732.setActual(symbol_70);	
				symbol_731.getParameterSubstitutions().add(symbol_732);
			}
			symbol_202.getTemplateBindings().add(symbol_731);
		}
		symbol_202.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_202);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_203.setName("NonUniqueCollection");
		//symbol_203.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_203.setElementType(symbol_60);
		{
			TemplateBinding symbol_733 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_733.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_734 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_734.setFormal(symbol_69);	
				symbol_734.setActual(symbol_60);	
				symbol_733.getParameterSubstitutions().add(symbol_734);
			}
			symbol_203.getTemplateBindings().add(symbol_733);
		}
		symbol_203.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_203);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_204.setName("NonUniqueCollection");
		//symbol_204.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_204.setElementType(symbol_96);
		{
			TemplateBinding symbol_735 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_735.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_736 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_736.setFormal(symbol_69);	
				symbol_736.setActual(symbol_96);	
				symbol_735.getParameterSubstitutions().add(symbol_736);
			}
			symbol_204.getTemplateBindings().add(symbol_735);
		}
		symbol_204.getSuperClasses().add(symbol_156); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_128.getOwnedTypes().add(symbol_204);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_205.setName("NonUniqueCollection");
		//symbol_205.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_205.setElementType(symbol_114);
		{
			TemplateBinding symbol_737 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_737.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_738 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_738.setFormal(symbol_69);	
				symbol_738.setActual(symbol_114);	
				symbol_737.getParameterSubstitutions().add(symbol_738);
			}
			symbol_205.getTemplateBindings().add(symbol_737);
		}
		symbol_205.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_205);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_206.setName("NonUniqueCollection");
		//symbol_206.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_206.setElementType(symbol_122);
		{
			TemplateBinding symbol_739 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_739.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_740 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_740.setFormal(symbol_69);	
				symbol_740.setActual(symbol_122);	
				symbol_739.getParameterSubstitutions().add(symbol_740);
			}
			symbol_206.getTemplateBindings().add(symbol_739);
		}
		symbol_206.getSuperClasses().add(symbol_144); // ocl!Collection[String]
		symbol_128.getOwnedTypes().add(symbol_206);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_207.setName("NonUniqueCollection");
		//symbol_207.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_207.setElementType(symbol_15);
		{
			TemplateBinding symbol_741 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_741.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_742 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_742.setFormal(symbol_69);	
				symbol_742.setActual(symbol_15);	
				symbol_741.getParameterSubstitutions().add(symbol_742);
			}
			symbol_207.getTemplateBindings().add(symbol_741);
		}
		symbol_207.getSuperClasses().add(symbol_157); // ocl!Collection[ocl!Bag{T}?T]
		symbol_128.getOwnedTypes().add(symbol_207);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_208.setName("OrderedCollection");
		//symbol_208.setMoniker("ocl!OrderedCollection[String]");
		symbol_208.setElementType(symbol_122);
		{
			TemplateBinding symbol_743 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_743.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_744 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_744.setFormal(symbol_92);	
				symbol_744.setActual(symbol_122);	
				symbol_743.getParameterSubstitutions().add(symbol_744);
			}
			symbol_208.getTemplateBindings().add(symbol_743);
		}
		symbol_208.getSuperClasses().add(symbol_144); // ocl!Collection[String]
		symbol_128.getOwnedTypes().add(symbol_208);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_209.setName("OrderedCollection");
		//symbol_209.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_209.setElementType(symbol_30);
		{
			TemplateBinding symbol_745 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_745.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_746 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_746.setFormal(symbol_92);	
				symbol_746.setActual(symbol_30);	
				symbol_745.getParameterSubstitutions().add(symbol_746);
			}
			symbol_209.getTemplateBindings().add(symbol_745);
		}
		symbol_209.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_209);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_210.setName("OrderedCollection");
		//symbol_210.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_210.setElementType(symbol_111);
		{
			TemplateBinding symbol_747 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_747.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_748 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_748.setFormal(symbol_92);	
				symbol_748.setActual(symbol_111);	
				symbol_747.getParameterSubstitutions().add(symbol_748);
			}
			symbol_210.getTemplateBindings().add(symbol_747);
		}
		symbol_210.getSuperClasses().add(symbol_163); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_128.getOwnedTypes().add(symbol_210);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_211.setName("OrderedCollection");
		//symbol_211.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_211.setElementType(symbol_103);
		{
			TemplateBinding symbol_749 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_749.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_750 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_750.setFormal(symbol_92);	
				symbol_750.setActual(symbol_103);	
				symbol_749.getParameterSubstitutions().add(symbol_750);
			}
			symbol_211.getTemplateBindings().add(symbol_749);
		}
		symbol_211.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_128.getOwnedTypes().add(symbol_211);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_212.setName("OrderedCollection");
		//symbol_212.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_212.setElementType(symbol_96);
		{
			TemplateBinding symbol_751 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_751.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_752 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_752.setFormal(symbol_92);	
				symbol_752.setActual(symbol_96);	
				symbol_751.getParameterSubstitutions().add(symbol_752);
			}
			symbol_212.getTemplateBindings().add(symbol_751);
		}
		symbol_212.getSuperClasses().add(symbol_156); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_128.getOwnedTypes().add(symbol_212);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_213.setName("OrderedCollection");
		//symbol_213.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_213.setElementType(symbol_93);
		{
			TemplateBinding symbol_753 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_753.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_754 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_754.setFormal(symbol_92);	
				symbol_754.setActual(symbol_93);	
				symbol_753.getParameterSubstitutions().add(symbol_754);
			}
			symbol_213.getTemplateBindings().add(symbol_753);
		}
		symbol_213.getSuperClasses().add(symbol_151); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_213);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_214.setName("OrderedCollection");
		//symbol_214.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_214.setElementType(symbol_114);
		{
			TemplateBinding symbol_755 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_755.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_756 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_756.setFormal(symbol_92);	
				symbol_756.setActual(symbol_114);	
				symbol_755.getParameterSubstitutions().add(symbol_756);
			}
			symbol_214.getTemplateBindings().add(symbol_755);
		}
		symbol_214.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_214);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_215.setName("OrderedCollection");
		//symbol_215.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_215.setElementType(symbol_70);
		{
			TemplateBinding symbol_757 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_757.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_758 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_758.setFormal(symbol_92);	
				symbol_758.setActual(symbol_70);	
				symbol_757.getParameterSubstitutions().add(symbol_758);
			}
			symbol_215.getTemplateBindings().add(symbol_757);
		}
		symbol_215.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_215);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_216.setName("OrderedCollection");
		//symbol_216.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_216.setElementType(symbol_126);
		{
			TemplateBinding symbol_759 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_759.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_760 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_760.setFormal(symbol_92);	
				symbol_760.setActual(symbol_126);	
				symbol_759.getParameterSubstitutions().add(symbol_760);
			}
			symbol_216.getTemplateBindings().add(symbol_759);
		}
		symbol_216.getSuperClasses().add(symbol_161); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_216);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_217.setName("OrderedSet");
		//symbol_217.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_217.setElementType(symbol_93);
		{
			TemplateBinding symbol_761 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_761.setSignature(symbol_101);
			{
				TemplateParameterSubstitution symbol_762 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_762.setFormal(symbol_102);	
				symbol_762.setActual(symbol_93);	
				symbol_761.getParameterSubstitutions().add(symbol_762);
			}
			symbol_217.getTemplateBindings().add(symbol_761);
		}
		symbol_217.getSuperClasses().add(symbol_245); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_217.getSuperClasses().add(symbol_213); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_217);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_218.setName("OrderedSet");
		//symbol_218.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_218.setElementType(symbol_126);
		{
			TemplateBinding symbol_763 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_763.setSignature(symbol_101);
			{
				TemplateParameterSubstitution symbol_764 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_764.setFormal(symbol_102);	
				symbol_764.setActual(symbol_126);	
				symbol_763.getParameterSubstitutions().add(symbol_764);
			}
			symbol_218.getTemplateBindings().add(symbol_763);
		}
		symbol_218.getSuperClasses().add(symbol_256); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		symbol_218.getSuperClasses().add(symbol_216); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_218);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_219.setName("OrderedSet");
		//symbol_219.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_219.setElementType(symbol_103);
		{
			TemplateBinding symbol_765 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_765.setSignature(symbol_101);
			{
				TemplateParameterSubstitution symbol_766 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_766.setFormal(symbol_102);	
				symbol_766.setActual(symbol_103);	
				symbol_765.getParameterSubstitutions().add(symbol_766);
			}
			symbol_219.getTemplateBindings().add(symbol_765);
		}
		symbol_219.getSuperClasses().add(symbol_250); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_219.getSuperClasses().add(symbol_211); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_128.getOwnedTypes().add(symbol_219);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_220.setName("OrderedSet");
		//symbol_220.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_220.setElementType(symbol_30);
		{
			TemplateBinding symbol_767 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_767.setSignature(symbol_101);
			{
				TemplateParameterSubstitution symbol_768 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_768.setFormal(symbol_102);	
				symbol_768.setActual(symbol_30);	
				symbol_767.getParameterSubstitutions().add(symbol_768);
			}
			symbol_220.getTemplateBindings().add(symbol_767);
		}
		symbol_220.getSuperClasses().add(symbol_252); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_220.getSuperClasses().add(symbol_209); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_220);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_221.setName("Sequence");
		//symbol_221.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_221.setElementType(symbol_111);
		{
			TemplateBinding symbol_769 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_769.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_770 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_770.setFormal(symbol_110);	
				symbol_770.setActual(symbol_111);	
				symbol_769.getParameterSubstitutions().add(symbol_770);
			}
			symbol_221.getTemplateBindings().add(symbol_769);
		}
		symbol_221.getSuperClasses().add(symbol_210); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_221.getSuperClasses().add(symbol_201); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_128.getOwnedTypes().add(symbol_221);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_222.setName("Sequence");
		//symbol_222.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_222.setElementType(symbol_30);
		{
			TemplateBinding symbol_771 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_771.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_772 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_772.setFormal(symbol_110);	
				symbol_772.setActual(symbol_30);	
				symbol_771.getParameterSubstitutions().add(symbol_772);
			}
			symbol_222.getTemplateBindings().add(symbol_771);
		}
		symbol_222.getSuperClasses().add(symbol_197); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_222.getSuperClasses().add(symbol_209); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_222);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_223.setName("Sequence");
		//symbol_223.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_223.setElementType(symbol_70);
		{
			TemplateBinding symbol_773 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_773.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_774 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_774.setFormal(symbol_110);	
				symbol_774.setActual(symbol_70);	
				symbol_773.getParameterSubstitutions().add(symbol_774);
			}
			symbol_223.getTemplateBindings().add(symbol_773);
		}
		symbol_223.getSuperClasses().add(symbol_202); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		symbol_223.getSuperClasses().add(symbol_215); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_223);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_224.setName("Sequence");
		//symbol_224.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_224.setElementType(symbol_96);
		{
			TemplateBinding symbol_775 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_775.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_776 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_776.setFormal(symbol_110);	
				symbol_776.setActual(symbol_96);	
				symbol_775.getParameterSubstitutions().add(symbol_776);
			}
			symbol_224.getTemplateBindings().add(symbol_775);
		}
		symbol_224.getSuperClasses().add(symbol_204); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_224.getSuperClasses().add(symbol_212); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_128.getOwnedTypes().add(symbol_224);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_225.setName("Sequence");
		//symbol_225.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_225.setElementType(symbol_93);
		{
			TemplateBinding symbol_777 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_777.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_778 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_778.setFormal(symbol_110);	
				symbol_778.setActual(symbol_93);	
				symbol_777.getParameterSubstitutions().add(symbol_778);
			}
			symbol_225.getTemplateBindings().add(symbol_777);
		}
		symbol_225.getSuperClasses().add(symbol_213); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_225.getSuperClasses().add(symbol_198); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_225);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[String]
		//
		symbol_226.setName("Sequence");
		//symbol_226.setMoniker("ocl!Sequence[String]");
		symbol_226.setElementType(symbol_122);
		{
			TemplateBinding symbol_779 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_779.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_780 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_780.setFormal(symbol_110);	
				symbol_780.setActual(symbol_122);	
				symbol_779.getParameterSubstitutions().add(symbol_780);
			}
			symbol_226.getTemplateBindings().add(symbol_779);
		}
		symbol_226.getSuperClasses().add(symbol_206); // ocl!NonUniqueCollection[String]
		symbol_226.getSuperClasses().add(symbol_208); // ocl!OrderedCollection[String]
		symbol_128.getOwnedTypes().add(symbol_226);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_227.setName("Sequence");
		//symbol_227.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_227.setElementType(symbol_114);
		{
			TemplateBinding symbol_781 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_781.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_782 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_782.setFormal(symbol_110);	
				symbol_782.setActual(symbol_114);	
				symbol_781.getParameterSubstitutions().add(symbol_782);
			}
			symbol_227.getTemplateBindings().add(symbol_781);
		}
		symbol_227.getSuperClasses().add(symbol_214); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_227.getSuperClasses().add(symbol_205); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_227);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier]
		//
		symbol_228.setName("Set");
		//symbol_228.setMoniker("ocl!Set[ocl!Classifier]");
		symbol_228.setElementType(symbol_23);
		{
			TemplateBinding symbol_783 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_783.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_784 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_784.setFormal(symbol_117);	
				symbol_784.setActual(symbol_23);	
				symbol_783.getParameterSubstitutions().add(symbol_784);
			}
			symbol_228.getTemplateBindings().add(symbol_783);
		}
		symbol_228.getSuperClasses().add(symbol_253); // ocl!UniqueCollection[ocl!Classifier]
		symbol_228.getSuperClasses().add(symbol_189); // ocl!NonOrderedCollection[ocl!Classifier]
		symbol_128.getOwnedTypes().add(symbol_228);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_229.setName("Set");
		//symbol_229.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_229.setElementType(symbol_74);
		{
			TemplateBinding symbol_785 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_785.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_786 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_786.setFormal(symbol_117);	
				symbol_786.setActual(symbol_74);	
				symbol_785.getParameterSubstitutions().add(symbol_786);
			}
			symbol_229.getTemplateBindings().add(symbol_785);
		}
		symbol_229.getSuperClasses().add(symbol_182); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_229.getSuperClasses().add(symbol_254); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_229);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_230.setName("Set");
		//symbol_230.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_230.setElementType(symbol_30);
		{
			TemplateBinding symbol_787 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_787.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_788 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_788.setFormal(symbol_117);	
				symbol_788.setActual(symbol_30);	
				symbol_787.getParameterSubstitutions().add(symbol_788);
			}
			symbol_230.getTemplateBindings().add(symbol_787);
		}
		symbol_230.getSuperClasses().add(symbol_193); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_230.getSuperClasses().add(symbol_252); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_230);
		//
		// ocl::$orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_231.setName("Set");
		//symbol_231.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_231.setElementType(symbol_242);
		{
			TemplateBinding symbol_789 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_789.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_790 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_790.setFormal(symbol_117);	
				symbol_790.setActual(symbol_242);	
				symbol_789.getParameterSubstitutions().add(symbol_790);
			}
			symbol_231.getTemplateBindings().add(symbol_789);
		}
		symbol_231.getSuperClasses().add(symbol_260); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_231.getSuperClasses().add(symbol_195); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_128.getOwnedTypes().add(symbol_231);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_232.setName("Set");
		//symbol_232.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_232.setElementType(symbol_103);
		{
			TemplateBinding symbol_791 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_791.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_792 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_792.setFormal(symbol_117);	
				symbol_792.setActual(symbol_103);	
				symbol_791.getParameterSubstitutions().add(symbol_792);
			}
			symbol_232.getTemplateBindings().add(symbol_791);
		}
		symbol_232.getSuperClasses().add(symbol_250); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_232.getSuperClasses().add(symbol_190); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_128.getOwnedTypes().add(symbol_232);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_233.setName("Set");
		//symbol_233.setMoniker("ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_233.setElementType(symbol_82);
		{
			TemplateBinding symbol_793 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_793.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_794 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_794.setFormal(symbol_117);	
				symbol_794.setActual(symbol_82);	
				symbol_793.getParameterSubstitutions().add(symbol_794);
			}
			symbol_233.getTemplateBindings().add(symbol_793);
		}
		symbol_233.getSuperClasses().add(symbol_188); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_233.getSuperClasses().add(symbol_251); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_233);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_234.setName("Set");
		//symbol_234.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_234.setElementType(symbol_118);
		{
			TemplateBinding symbol_795 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_795.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_796 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_796.setFormal(symbol_117);	
				symbol_796.setActual(symbol_118);	
				symbol_795.getParameterSubstitutions().add(symbol_796);
			}
			symbol_234.getTemplateBindings().add(symbol_795);
		}
		symbol_234.getSuperClasses().add(symbol_183); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_234.getSuperClasses().add(symbol_258); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_128.getOwnedTypes().add(symbol_234);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_235.setName("Set");
		//symbol_235.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_235.setElementType(symbol_71);
		{
			TemplateBinding symbol_797 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_797.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_798 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_798.setFormal(symbol_117);	
				symbol_798.setActual(symbol_71);	
				symbol_797.getParameterSubstitutions().add(symbol_798);
			}
			symbol_235.getTemplateBindings().add(symbol_797);
		}
		symbol_235.getSuperClasses().add(symbol_247); // ocl!UniqueCollection[ocl!OclAny]
		symbol_235.getSuperClasses().add(symbol_181); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_128.getOwnedTypes().add(symbol_235);
		//
		// ocl::$orphanage::Set ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_236.setName("Set");
		//symbol_236.setMoniker("ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_236.setElementType(symbol_22);
		{
			TemplateBinding symbol_799 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_799.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_800 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_800.setFormal(symbol_117);	
				symbol_800.setActual(symbol_22);	
				symbol_799.getParameterSubstitutions().add(symbol_800);
			}
			symbol_236.getTemplateBindings().add(symbol_799);
		}
		symbol_236.getSuperClasses().add(symbol_257); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_236.getSuperClasses().add(symbol_191); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_236);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_237.setName("Set");
		//symbol_237.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_237.setElementType(symbol_60);
		{
			TemplateBinding symbol_801 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_801.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_802 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_802.setFormal(symbol_117);	
				symbol_802.setActual(symbol_60);	
				symbol_801.getParameterSubstitutions().add(symbol_802);
			}
			symbol_237.getTemplateBindings().add(symbol_801);
		}
		symbol_237.getSuperClasses().add(symbol_248); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_237.getSuperClasses().add(symbol_192); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_237);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_238.setName("Set");
		//symbol_238.setMoniker("ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_238.setElementType(symbol_26);
		{
			TemplateBinding symbol_803 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_803.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_804 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_804.setFormal(symbol_117);	
				symbol_804.setActual(symbol_26);	
				symbol_803.getParameterSubstitutions().add(symbol_804);
			}
			symbol_238.getTemplateBindings().add(symbol_803);
		}
		symbol_238.getSuperClasses().add(symbol_249); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_238.getSuperClasses().add(symbol_184); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_238);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_239.setName("Set");
		//symbol_239.setMoniker("ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_239.setElementType(symbol_55);
		{
			TemplateBinding symbol_805 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_805.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_806 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_806.setFormal(symbol_117);	
				symbol_806.setActual(symbol_55);	
				symbol_805.getParameterSubstitutions().add(symbol_806);
			}
			symbol_239.getTemplateBindings().add(symbol_805);
		}
		symbol_239.getSuperClasses().add(symbol_246); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_239.getSuperClasses().add(symbol_186); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_239);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_240.setName("Set");
		//symbol_240.setMoniker("ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_240.setElementType(symbol_89);
		{
			TemplateBinding symbol_807 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_807.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_808 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_808.setFormal(symbol_117);	
				symbol_808.setActual(symbol_89);	
				symbol_807.getParameterSubstitutions().add(symbol_808);
			}
			symbol_240.getTemplateBindings().add(symbol_807);
		}
		symbol_240.getSuperClasses().add(symbol_255); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_240.getSuperClasses().add(symbol_180); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_240);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_241.setName("Set");
		//symbol_241.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_241.setElementType(symbol_121);
		{
			TemplateBinding symbol_809 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_809.setSignature(symbol_116);
			{
				TemplateParameterSubstitution symbol_810 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_810.setFormal(symbol_117);	
				symbol_810.setActual(symbol_121);	
				symbol_809.getParameterSubstitutions().add(symbol_810);
			}
			symbol_241.getTemplateBindings().add(symbol_809);
		}
		symbol_241.getSuperClasses().add(symbol_259); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_241.getSuperClasses().add(symbol_196); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_241);
		//
		// ocl::$orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_242.setName("Tuple");
		//symbol_242.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		{ // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_243.setName("first");
			symbol_243.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_243.setIsResolveProxies(true);
			symbol_242.getOwnedAttributes().add(symbol_243);
		}
		{ // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_244.setName("second");
			symbol_244.setType(symbol_51);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_244.setIsResolveProxies(true);
			symbol_242.getOwnedAttributes().add(symbol_244);
		}
		symbol_128.getOwnedTypes().add(symbol_242);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_245.setName("UniqueCollection");
		//symbol_245.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_245.setElementType(symbol_93);
		{
			TemplateBinding symbol_811 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_811.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_812 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_812.setFormal(symbol_125);	
				symbol_812.setActual(symbol_93);	
				symbol_811.getParameterSubstitutions().add(symbol_812);
			}
			symbol_245.getTemplateBindings().add(symbol_811);
		}
		symbol_245.getSuperClasses().add(symbol_151); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_245);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_246.setName("UniqueCollection");
		//symbol_246.setMoniker("ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_246.setElementType(symbol_55);
		{
			TemplateBinding symbol_813 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_813.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_814 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_814.setFormal(symbol_125);	
				symbol_814.setActual(symbol_55);	
				symbol_813.getParameterSubstitutions().add(symbol_814);
			}
			symbol_246.getTemplateBindings().add(symbol_813);
		}
		symbol_246.getSuperClasses().add(symbol_152); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_246);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_247.setName("UniqueCollection");
		//symbol_247.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_247.setElementType(symbol_71);
		{
			TemplateBinding symbol_815 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_815.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_816 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_816.setFormal(symbol_125);	
				symbol_816.setActual(symbol_71);	
				symbol_815.getParameterSubstitutions().add(symbol_816);
			}
			symbol_247.getTemplateBindings().add(symbol_815);
		}
		symbol_247.getSuperClasses().add(symbol_162); // ocl!Collection[ocl!OclAny]
		symbol_128.getOwnedTypes().add(symbol_247);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_248.setName("UniqueCollection");
		//symbol_248.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_248.setElementType(symbol_60);
		{
			TemplateBinding symbol_817 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_817.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_818 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_818.setFormal(symbol_125);	
				symbol_818.setActual(symbol_60);	
				symbol_817.getParameterSubstitutions().add(symbol_818);
			}
			symbol_248.getTemplateBindings().add(symbol_817);
		}
		symbol_248.getSuperClasses().add(symbol_141); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_248);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_249.setName("UniqueCollection");
		//symbol_249.setMoniker("ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_249.setElementType(symbol_26);
		{
			TemplateBinding symbol_819 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_819.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_820 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_820.setFormal(symbol_125);	
				symbol_820.setActual(symbol_26);	
				symbol_819.getParameterSubstitutions().add(symbol_820);
			}
			symbol_249.getTemplateBindings().add(symbol_819);
		}
		symbol_249.getSuperClasses().add(symbol_146); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_249);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_250.setName("UniqueCollection");
		//symbol_250.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_250.setElementType(symbol_103);
		{
			TemplateBinding symbol_821 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_821.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_822 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_822.setFormal(symbol_125);	
				symbol_822.setActual(symbol_103);	
				symbol_821.getParameterSubstitutions().add(symbol_822);
			}
			symbol_250.getTemplateBindings().add(symbol_821);
		}
		symbol_250.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_128.getOwnedTypes().add(symbol_250);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_251.setName("UniqueCollection");
		//symbol_251.setMoniker("ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_251.setElementType(symbol_82);
		{
			TemplateBinding symbol_823 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_823.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_824 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_824.setFormal(symbol_125);	
				symbol_824.setActual(symbol_82);	
				symbol_823.getParameterSubstitutions().add(symbol_824);
			}
			symbol_251.getTemplateBindings().add(symbol_823);
		}
		symbol_251.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_251);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_252.setName("UniqueCollection");
		//symbol_252.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_252.setElementType(symbol_30);
		{
			TemplateBinding symbol_825 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_825.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_826 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_826.setFormal(symbol_125);	
				symbol_826.setActual(symbol_30);	
				symbol_825.getParameterSubstitutions().add(symbol_826);
			}
			symbol_252.getTemplateBindings().add(symbol_825);
		}
		symbol_252.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Collection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_252);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier]
		//
		symbol_253.setName("UniqueCollection");
		//symbol_253.setMoniker("ocl!UniqueCollection[ocl!Classifier]");
		symbol_253.setElementType(symbol_23);
		{
			TemplateBinding symbol_827 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_827.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_828 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_828.setFormal(symbol_125);	
				symbol_828.setActual(symbol_23);	
				symbol_827.getParameterSubstitutions().add(symbol_828);
			}
			symbol_253.getTemplateBindings().add(symbol_827);
		}
		symbol_253.getSuperClasses().add(symbol_160); // ocl!Collection[ocl!Classifier]
		symbol_128.getOwnedTypes().add(symbol_253);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_254.setName("UniqueCollection");
		//symbol_254.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_254.setElementType(symbol_74);
		{
			TemplateBinding symbol_829 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_829.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_830 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_830.setFormal(symbol_125);	
				symbol_830.setActual(symbol_74);	
				symbol_829.getParameterSubstitutions().add(symbol_830);
			}
			symbol_254.getTemplateBindings().add(symbol_829);
		}
		symbol_254.getSuperClasses().add(symbol_139); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_254);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_255.setName("UniqueCollection");
		//symbol_255.setMoniker("ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_255.setElementType(symbol_89);
		{
			TemplateBinding symbol_831 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_831.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_832 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_832.setFormal(symbol_125);	
				symbol_832.setActual(symbol_89);	
				symbol_831.getParameterSubstitutions().add(symbol_832);
			}
			symbol_255.getTemplateBindings().add(symbol_831);
		}
		symbol_255.getSuperClasses().add(symbol_158); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_255);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_256.setName("UniqueCollection");
		//symbol_256.setMoniker("ocl!UniqueCollection[ocl!UniqueCollection{T}?T]");
		symbol_256.setElementType(symbol_126);
		{
			TemplateBinding symbol_833 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_833.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_834 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_834.setFormal(symbol_125);	
				symbol_834.setActual(symbol_126);	
				symbol_833.getParameterSubstitutions().add(symbol_834);
			}
			symbol_256.getTemplateBindings().add(symbol_833);
		}
		symbol_256.getSuperClasses().add(symbol_161); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_128.getOwnedTypes().add(symbol_256);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_257.setName("UniqueCollection");
		//symbol_257.setMoniker("ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_257.setElementType(symbol_22);
		{
			TemplateBinding symbol_835 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_835.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_836 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_836.setFormal(symbol_125);	
				symbol_836.setActual(symbol_22);	
				symbol_835.getParameterSubstitutions().add(symbol_836);
			}
			symbol_257.getTemplateBindings().add(symbol_835);
		}
		symbol_257.getSuperClasses().add(symbol_150); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_128.getOwnedTypes().add(symbol_257);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_258.setName("UniqueCollection");
		//symbol_258.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_258.setElementType(symbol_118);
		{
			TemplateBinding symbol_837 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_837.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_838 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_838.setFormal(symbol_125);	
				symbol_838.setActual(symbol_118);	
				symbol_837.getParameterSubstitutions().add(symbol_838);
			}
			symbol_258.getTemplateBindings().add(symbol_837);
		}
		symbol_258.getSuperClasses().add(symbol_142); // ocl!Collection[ocl!Set{T}?T]
		symbol_128.getOwnedTypes().add(symbol_258);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_259.setName("UniqueCollection");
		//symbol_259.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_259.setElementType(symbol_121);
		{
			TemplateBinding symbol_839 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_839.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_840 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_840.setFormal(symbol_125);	
				symbol_840.setActual(symbol_121);	
				symbol_839.getParameterSubstitutions().add(symbol_840);
			}
			symbol_259.getTemplateBindings().add(symbol_839);
		}
		symbol_259.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_128.getOwnedTypes().add(symbol_259);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_260.setName("UniqueCollection");
		//symbol_260.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_260.setElementType(symbol_242);
		{
			TemplateBinding symbol_841 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_841.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_842 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_842.setFormal(symbol_125);	
				symbol_842.setActual(symbol_242);	
				symbol_841.getParameterSubstitutions().add(symbol_842);
			}
			symbol_260.getTemplateBindings().add(symbol_841);
		}
		symbol_260.getSuperClasses().add(symbol_154); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_128.getOwnedTypes().add(symbol_260);
		symbol_1.getNestedPackages().add(symbol_128);
		return symbol_1;
	}
}
