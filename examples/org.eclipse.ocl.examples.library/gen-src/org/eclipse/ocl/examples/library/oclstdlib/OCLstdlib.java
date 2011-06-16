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
 * $Id$
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
		Library symbol_1 = PivotFactory.eINSTANCE.createLibrary(); // $ocl
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
		BagType symbol_12 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag{T}
		TemplateSignature symbol_13 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Bag{T}!
		TypeTemplateParameter symbol_14 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_15 = PivotFactory.eINSTANCE.createClass(); // $ocl!Bag{T}?T
		
		TemplateSignature symbol_16 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Bag{T}!flatten{T2}()!
		TypeTemplateParameter symbol_17 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_18 = PivotFactory.eINSTANCE.createClass(); // $ocl!Bag{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_19 = PivotFactory.eINSTANCE.createPrimitiveType(); // Boolean
		
		ClassifierType symbol_20 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier{T}
		TemplateSignature symbol_21 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Classifier{T}!
		TypeTemplateParameter symbol_22 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_23 = PivotFactory.eINSTANCE.createClass(); // $ocl!Classifier{T}?T
		
		TemplateSignature symbol_24 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Classifier{T}!oclContainer{U}()!
		TypeTemplateParameter symbol_25 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_26 = PivotFactory.eINSTANCE.createClass(); // $ocl!Classifier{T}!oclContainer{U}()?U
		
		TemplateSignature symbol_27 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Classifier{T}!oclContents{U}()!
		TypeTemplateParameter symbol_28 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_29 = PivotFactory.eINSTANCE.createClass(); // $ocl!Classifier{T}!oclContents{U}()?U
		
		
		CollectionType symbol_30 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection{T}
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}?T
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])!
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_46 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])!
		TypeTemplateParameter symbol_47 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2
		
		TemplateSignature symbol_49 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_50 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_52 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!product{T2}($ocl!Collection[T2])!
		TypeTemplateParameter symbol_53 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2
		
		
		Class symbol_55 = PivotFactory.eINSTANCE.createClass(); // $ocl!Enumeration
		
		PrimitiveType symbol_56 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_57 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection{T}
		TemplateSignature symbol_58 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_59 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_60 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_61 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_62 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_63 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_64 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_65 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_66 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_67 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection{T}
		TemplateSignature symbol_68 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_69 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_70 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_71 = PivotFactory.eINSTANCE.createAnyType(); // $ocl!OclAny
		TemplateSignature symbol_72 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])!
		TypeTemplateParameter symbol_73 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_74 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT
		
		TemplateSignature symbol_75 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])!
		TypeTemplateParameter symbol_76 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T
		
		TemplateSignature symbol_78 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])!
		TypeTemplateParameter symbol_79 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_80 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T
		
		
		InvalidType symbol_81 = PivotFactory.eINSTANCE.createInvalidType(); // $ocl!OclInvalid
		Property symbol_82 = PivotFactory.eINSTANCE.createProperty(); // ocl::OclInvalid::oclBadProperty $ocl!OclInvalid!oclBadProperty
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclMessage
		
		SelfType symbol_84 = PivotFactory.eINSTANCE.createSelfType(); // $ocl!OclSelf
		
		Class symbol_85 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclState
		
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclTuple
		
		VoidType symbol_87 = PivotFactory.eINSTANCE.createVoidType(); // $ocl!OclVoid
		
		CollectionType symbol_88 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection{T}
		TemplateSignature symbol_89 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_90 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_91 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_92 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_93 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_94 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_95 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_96 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_98 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet{T}
		TemplateSignature symbol_99 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_100 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_101 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedSet{T}?T
		
		TemplateSignature symbol_102 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedSet{T}!flatten{T2}()!
		TypeTemplateParameter symbol_103 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_104 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedSet{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_105 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_106 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{TT}($ocl!Classifier[TT])!
		TypeTemplateParameter symbol_107 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_108 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{TT}($ocl!Classifier[TT])?TT
		
		
		SequenceType symbol_109 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence{T}
		TemplateSignature symbol_110 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Sequence{T}!
		TypeTemplateParameter symbol_111 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_112 = PivotFactory.eINSTANCE.createClass(); // $ocl!Sequence{T}?T
		
		TemplateSignature symbol_113 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_114 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_115 = PivotFactory.eINSTANCE.createClass(); // $ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_116 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set{T}
		TemplateSignature symbol_117 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Set{T}!
		TypeTemplateParameter symbol_118 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_119 = PivotFactory.eINSTANCE.createClass(); // $ocl!Set{T}?T
		
		TemplateSignature symbol_120 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_121 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_122 = PivotFactory.eINSTANCE.createClass(); // $ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_123 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		TupleType symbol_124 = PivotFactory.eINSTANCE.createTupleType(); // $ocl!Tuple
		
		CollectionType symbol_125 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection{T}
		TemplateSignature symbol_126 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_127 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_128 = PivotFactory.eINSTANCE.createClass(); // $ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_129 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_130 = PivotFactory.eINSTANCE.createPackage(); // $$
		Class symbol_131 = PivotFactory.eINSTANCE.createClass(); // $$!$$
		
		BagType symbol_132 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!Bag{T}?T]
		
		BagType symbol_133 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_134 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!Collection{T}?T]
		
		BagType symbol_135 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]
		
		BagType symbol_136 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		ClassifierType symbol_137 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclSelf]
		
		ClassifierType symbol_138 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]
		
		ClassifierType symbol_139 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]
		
		ClassifierType symbol_140 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]
		
		ClassifierType symbol_141 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]
		
		ClassifierType symbol_142 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]
		
		ClassifierType symbol_143 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Set{T}?T]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[String]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OclSelf]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}?T]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OclAny]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Sequence{T}?T]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Bag{T}?T]
		
		LambdaType symbol_169 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_170 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_171 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]
		
		LambdaType symbol_172 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_173 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_174 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()$ocl!OclAny
		
		LambdaType symbol_175 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Bag{T}?T()Boolean
		
		LambdaType symbol_176 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Sequence{T}?T()Boolean
		
		LambdaType symbol_177 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Set{T}?T()Boolean
		
		LambdaType symbol_178 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_179 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()Boolean
		
		LambdaType symbol_180 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny
		
		LambdaType symbol_181 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_182 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedSet{T}?T()Boolean
		
		LambdaType symbol_183 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]
		
		LambdaType symbol_184 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!OclAny]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!OclSelf]
		
		CollectionType symbol_193 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_194 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_195 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		
		CollectionType symbol_196 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_197 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		
		CollectionType symbol_198 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_199 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_200 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[String]
		
		CollectionType symbol_201 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_202 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_203 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_204 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		
		CollectionType symbol_205 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_206 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_207 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_208 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_209 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[String]
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		OrderedSetType symbol_216 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_217 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		OrderedSetType symbol_218 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!Collection{T}?T]
		
		OrderedSetType symbol_219 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_220 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
		
		SequenceType symbol_221 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_222 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_223 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!Sequence{T}?T]
		
		SequenceType symbol_224 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_225 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_226 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!Collection{T}?T]
		
		SequenceType symbol_227 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[String]
		
		SetType symbol_228 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_229 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Collection{T}?T]
		
		SetType symbol_230 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		SetType symbol_231 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_232 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		SetType symbol_233 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Set{T}?T]
		
		SetType symbol_234 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!OclAny]
		
		SetType symbol_235 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!OclSelf]
		
		SetType symbol_236 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!OrderedSet{T}?T]
		
		TupleType symbol_237 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}
		Property symbol_238 = PivotFactory.eINSTANCE.createProperty(); // ocl::$$::Tuple::first Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!first
		Property symbol_239 = PivotFactory.eINSTANCE.createProperty(); // ocl::$$::Tuple::second Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_240 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_241 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_242 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		CollectionType symbol_243 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_244 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_245 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OclAny]
		
		CollectionType symbol_246 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OclSelf]
		
		CollectionType symbol_247 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_248 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_249 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_250 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Set{T}?T]
		
		

		symbol_1.setName("ocl");
		symbol_1.setMoniker("$ocl");
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
		// ocl::Bag $ocl!Bag{T}
		//
		symbol_12.setName("Bag");
		//symbol_12.setMoniker("$ocl!Bag{T}");
		symbol_12.setElementType(symbol_15);
		symbol_15.setName("T");
		symbol_14.setOwnedParameteredElement(symbol_15);
		symbol_13.getOwnedParameters().add(symbol_14);
		
		symbol_12.setOwnedTemplateSignature(symbol_13);
		symbol_12.getSuperClasses().add(symbol_197); // $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_191); // $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		{	// ocl::Bag::<>() $ocl!Bag{T}!<>($ocl!OclSelf)
			Operation symbol_251 = PivotFactory.eINSTANCE.createOperation();
			symbol_251.setName("<>");
			//symbol_251.setMoniker("$ocl!Bag{T}!<>($ocl!OclSelf)");
			symbol_251.setType(symbol_19);  // Boolean
			
			Parameter symbol_252 = PivotFactory.eINSTANCE.createParameter();
			symbol_252.setName("object2");
			//symbol_252.setMoniker("$ocl!Bag{T}!<>($ocl!OclSelf)!object2");
			symbol_252.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_251.getOwnedParameters().add(symbol_252);
			symbol_251.setPrecedence(symbol_7);
			symbol_251.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_251.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_251);
		}
		{	// ocl::Bag::=() $ocl!Bag{T}!=($ocl!OclSelf)
			Operation symbol_253 = PivotFactory.eINSTANCE.createOperation();
			symbol_253.setName("=");
			//symbol_253.setMoniker("$ocl!Bag{T}!=($ocl!OclSelf)");
			symbol_253.setType(symbol_19);  // Boolean
			
			Parameter symbol_254 = PivotFactory.eINSTANCE.createParameter();
			symbol_254.setName("object2");
			//symbol_254.setMoniker("$ocl!Bag{T}!=($ocl!OclSelf)!object2");
			symbol_254.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_253.getOwnedParameters().add(symbol_254);
			symbol_253.setPrecedence(symbol_7);
			symbol_253.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_253.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_253);
		}
		{	// ocl::Bag::excluding() $ocl!Bag{T}!excluding($ocl!OclAny)
			Operation symbol_255 = PivotFactory.eINSTANCE.createOperation();
			symbol_255.setName("excluding");
			//symbol_255.setMoniker("$ocl!Bag{T}!excluding($ocl!OclAny)");
			symbol_255.setType(symbol_132);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_256 = PivotFactory.eINSTANCE.createParameter();
			symbol_256.setName("object");
			//symbol_256.setMoniker("$ocl!Bag{T}!excluding($ocl!OclAny)!object");
			symbol_256.setType(symbol_71);  // $ocl!OclAny
			
			symbol_255.getOwnedParameters().add(symbol_256);
			symbol_255.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_255.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_255);
		}
		{	// ocl::Bag::flatten() $ocl!Bag{T}!flatten{T2}()
			Operation symbol_257 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_257.setOwnedTemplateSignature(symbol_16);
			symbol_257.setName("flatten");
			//symbol_257.setMoniker("$ocl!Bag{T}!flatten{T2}()");
			symbol_257.setType(symbol_135);  // $ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]
			
			symbol_257.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_257.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_257);
		}
		{	// ocl::Bag::including() $ocl!Bag{T}!including(T)
			Operation symbol_258 = PivotFactory.eINSTANCE.createOperation();
			symbol_258.setName("including");
			//symbol_258.setMoniker("$ocl!Bag{T}!including(T)");
			symbol_258.setType(symbol_132);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_259 = PivotFactory.eINSTANCE.createParameter();
			symbol_259.setName("object");
			//symbol_259.setMoniker("$ocl!Bag{T}!including(T)!object");
			symbol_259.setType(symbol_15);  // $ocl!Bag{T}?T
			
			symbol_258.getOwnedParameters().add(symbol_259);
			symbol_258.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_258.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_258);
		}
		{	// ocl::Bag::reject() $ocl!Bag{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_260 = PivotFactory.eINSTANCE.createIteration();
			symbol_260.setName("reject");
			//symbol_260.setMoniker("$ocl!Bag{T}!reject(T|Lambda~T()Boolean)");
			symbol_260.setType(symbol_132);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_261 = PivotFactory.eINSTANCE.createParameter();
			symbol_261.setName("i");
			symbol_261.setType(symbol_15);  // $ocl!Bag{T}?T
			symbol_260.getOwnedIterators().add(symbol_261);
			Parameter symbol_262 = PivotFactory.eINSTANCE.createParameter();
			symbol_262.setName("body");
			//symbol_262.setMoniker("$ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_262.setType(symbol_175);  // Lambda~$ocl!Bag{T}?T()Boolean
			
			symbol_260.getOwnedParameters().add(symbol_262);
			symbol_260.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Bag::select() $ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_263 = PivotFactory.eINSTANCE.createIteration();
			symbol_263.setName("select");
			//symbol_263.setMoniker("$ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_263.setType(symbol_132);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("i");
			symbol_264.setType(symbol_15);  // $ocl!Bag{T}?T
			symbol_263.getOwnedIterators().add(symbol_264);
			Parameter symbol_265 = PivotFactory.eINSTANCE.createParameter();
			symbol_265.setName("body");
			//symbol_265.setMoniker("$ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_265.setType(symbol_175);  // Lambda~$ocl!Bag{T}?T()Boolean
			
			symbol_263.getOwnedParameters().add(symbol_265);
			symbol_263.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_263);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>($ocl!OclSelf)
			Operation symbol_266 = PivotFactory.eINSTANCE.createOperation();
			symbol_266.setName("<>");
			//symbol_266.setMoniker("Boolean!<>($ocl!OclSelf)");
			symbol_266.setType(symbol_19);  // Boolean
			
			Parameter symbol_267 = PivotFactory.eINSTANCE.createParameter();
			symbol_267.setName("object2");
			//symbol_267.setMoniker("Boolean!<>($ocl!OclSelf)!object2");
			symbol_267.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_266.getOwnedParameters().add(symbol_267);
			symbol_266.setPrecedence(symbol_7);
			symbol_266.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_266.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_266);
		}
		{	// ocl::Boolean::=() Boolean!=($ocl!OclSelf)
			Operation symbol_268 = PivotFactory.eINSTANCE.createOperation();
			symbol_268.setName("=");
			//symbol_268.setMoniker("Boolean!=($ocl!OclSelf)");
			symbol_268.setType(symbol_19);  // Boolean
			
			Parameter symbol_269 = PivotFactory.eINSTANCE.createParameter();
			symbol_269.setName("object2");
			//symbol_269.setMoniker("Boolean!=($ocl!OclSelf)!object2");
			symbol_269.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_268.getOwnedParameters().add(symbol_269);
			symbol_268.setPrecedence(symbol_7);
			symbol_268.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_268);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances()
			Operation symbol_270 = PivotFactory.eINSTANCE.createOperation();
			symbol_270.setName("allInstances");
			//symbol_270.setMoniker("Boolean!allInstances()");
			symbol_270.setType(symbol_235);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_270.setIsStatic(true);
			symbol_270.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation");
			symbol_270.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_270);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_271 = PivotFactory.eINSTANCE.createOperation();
			symbol_271.setName("and");
			//symbol_271.setMoniker("Boolean!and(Boolean)");
			symbol_271.setType(symbol_19);  // Boolean
			
			Parameter symbol_272 = PivotFactory.eINSTANCE.createParameter();
			symbol_272.setName("b");
			//symbol_272.setMoniker("Boolean!and(Boolean)!b");
			symbol_272.setType(symbol_19);  // Boolean
			
			symbol_271.getOwnedParameters().add(symbol_272);
			symbol_271.setPrecedence(symbol_8);
			symbol_271.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAndOperation");
			symbol_271.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_271);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_273 = PivotFactory.eINSTANCE.createOperation();
			symbol_273.setName("implies");
			//symbol_273.setMoniker("Boolean!implies(Boolean)");
			symbol_273.setType(symbol_19);  // Boolean
			
			Parameter symbol_274 = PivotFactory.eINSTANCE.createParameter();
			symbol_274.setName("b");
			//symbol_274.setMoniker("Boolean!implies(Boolean)!b");
			symbol_274.setType(symbol_19);  // Boolean
			
			symbol_273.getOwnedParameters().add(symbol_274);
			symbol_273.setPrecedence(symbol_11);
			symbol_273.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation");
			symbol_273.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_273);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_275 = PivotFactory.eINSTANCE.createOperation();
			symbol_275.setName("not");
			//symbol_275.setMoniker("Boolean!not()");
			symbol_275.setType(symbol_19);  // Boolean
			
			symbol_275.setPrecedence(symbol_3);
			symbol_275.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanNotOperation");
			symbol_275.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_275);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("or");
			//symbol_276.setMoniker("Boolean!or(Boolean)");
			symbol_276.setType(symbol_19);  // Boolean
			
			Parameter symbol_277 = PivotFactory.eINSTANCE.createParameter();
			symbol_277.setName("b");
			//symbol_277.setMoniker("Boolean!or(Boolean)!b");
			symbol_277.setType(symbol_19);  // Boolean
			
			symbol_276.getOwnedParameters().add(symbol_277);
			symbol_276.setPrecedence(symbol_9);
			symbol_276.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanOrOperation");
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_278.setName("toString");
			//symbol_278.setMoniker("Boolean!toString()");
			symbol_278.setType(symbol_123);  // String
			
			symbol_278.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("xor");
			//symbol_279.setMoniker("Boolean!xor(Boolean)");
			symbol_279.setType(symbol_19);  // Boolean
			
			Parameter symbol_280 = PivotFactory.eINSTANCE.createParameter();
			symbol_280.setName("b");
			//symbol_280.setMoniker("Boolean!xor(Boolean)!b");
			symbol_280.setType(symbol_19);  // Boolean
			
			symbol_279.getOwnedParameters().add(symbol_280);
			symbol_279.setPrecedence(symbol_10);
			symbol_279.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanXorOperation");
			symbol_279.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_279);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier $ocl!Classifier{T}
		//
		symbol_20.setName("Classifier");
		//symbol_20.setMoniker("$ocl!Classifier{T}");
		symbol_20.setInstanceType(symbol_23);
		symbol_23.setName("T");
		symbol_22.setOwnedParameteredElement(symbol_23);
		symbol_21.getOwnedParameters().add(symbol_22);
		
		symbol_20.setOwnedTemplateSignature(symbol_21);
		symbol_20.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::Classifier::allInstances() $ocl!Classifier{T}!allInstances()
			Operation symbol_281 = PivotFactory.eINSTANCE.createOperation();
			symbol_281.setName("allInstances");
			//symbol_281.setMoniker("$ocl!Classifier{T}!allInstances()");
			symbol_281.setType(symbol_235);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_281.setIsStatic(true);
			symbol_281.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation");
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Classifier::oclContainer() $ocl!Classifier{T}!oclContainer{U}()
			Operation symbol_282 = PivotFactory.eINSTANCE.createOperation();
			symbol_26.setName("U");
			symbol_25.setOwnedParameteredElement(symbol_26);
			symbol_24.getOwnedParameters().add(symbol_25);
			
			symbol_282.setOwnedTemplateSignature(symbol_24);
			symbol_282.setName("oclContainer");
			//symbol_282.setMoniker("$ocl!Classifier{T}!oclContainer{U}()");
			symbol_282.setType(symbol_143);  // $ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]
			
			symbol_282.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation");
			symbol_282.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_282);
		}
		{	// ocl::Classifier::oclContents() $ocl!Classifier{T}!oclContents{U}()
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_29.setName("U");
			symbol_28.setOwnedParameteredElement(symbol_29);
			symbol_27.getOwnedParameters().add(symbol_28);
			
			symbol_283.setOwnedTemplateSignature(symbol_27);
			symbol_283.setName("oclContents");
			//symbol_283.setMoniker("$ocl!Classifier{T}!oclContents{U}()");
			symbol_283.setType(symbol_230);  // $ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
			
			symbol_283.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation");
			symbol_283.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_283);
		}
		symbol_1.getOwnedTypes().add(symbol_20);
		//
		// ocl::Collection $ocl!Collection{T}
		//
		symbol_30.setName("Collection");
		//symbol_30.setMoniker("$ocl!Collection{T}");
		symbol_30.setElementType(symbol_33);
		symbol_33.setName("T");
		symbol_32.setOwnedParameteredElement(symbol_33);
		symbol_31.getOwnedParameters().add(symbol_32);
		
		symbol_30.setOwnedTemplateSignature(symbol_31);
		symbol_30.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::Collection::<>() $ocl!Collection{T}!<>($ocl!OclSelf)
			Operation symbol_284 = PivotFactory.eINSTANCE.createOperation();
			symbol_284.setName("<>");
			//symbol_284.setMoniker("$ocl!Collection{T}!<>($ocl!OclSelf)");
			symbol_284.setType(symbol_19);  // Boolean
			
			Parameter symbol_285 = PivotFactory.eINSTANCE.createParameter();
			symbol_285.setName("object2");
			//symbol_285.setMoniker("$ocl!Collection{T}!<>($ocl!OclSelf)!object2");
			symbol_285.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_284.getOwnedParameters().add(symbol_285);
			symbol_284.setPrecedence(symbol_7);
			symbol_284.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_284.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_284);
		}
		{	// ocl::Collection::=() $ocl!Collection{T}!=($ocl!OclSelf)
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_286.setName("=");
			//symbol_286.setMoniker("$ocl!Collection{T}!=($ocl!OclSelf)");
			symbol_286.setType(symbol_19);  // Boolean
			
			Parameter symbol_287 = PivotFactory.eINSTANCE.createParameter();
			symbol_287.setName("object2");
			//symbol_287.setMoniker("$ocl!Collection{T}!=($ocl!OclSelf)!object2");
			symbol_287.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_286.getOwnedParameters().add(symbol_287);
			symbol_286.setPrecedence(symbol_7);
			symbol_286.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Collection::any() $ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_288 = PivotFactory.eINSTANCE.createIteration();
			symbol_288.setName("any");
			//symbol_288.setMoniker("$ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_288.setType(symbol_33);  // $ocl!Collection{T}?T
			
			Parameter symbol_289 = PivotFactory.eINSTANCE.createParameter();
			symbol_289.setName("i");
			symbol_289.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_288.getOwnedIterators().add(symbol_289);
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("body");
			//symbol_290.setMoniker("$ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_290.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_288.getOwnedParameters().add(symbol_290);
			symbol_288.setImplementationClass("org.eclipse.ocl.examples.library.iterator.AnyIteration");
			symbol_288.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_288);
		}
		{	// ocl::Collection::asBag() $ocl!Collection{T}!asBag()
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("asBag");
			//symbol_291.setMoniker("$ocl!Collection{T}!asBag()");
			symbol_291.setType(symbol_134);  // $ocl!Bag[$ocl!Collection{T}?T]
			
			symbol_291.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation");
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Collection::asOrderedSet() $ocl!Collection{T}!asOrderedSet()
			Operation symbol_292 = PivotFactory.eINSTANCE.createOperation();
			symbol_292.setName("asOrderedSet");
			//symbol_292.setMoniker("$ocl!Collection{T}!asOrderedSet()");
			symbol_292.setType(symbol_218);  // $ocl!OrderedSet[$ocl!Collection{T}?T]
			
			symbol_292.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation");
			symbol_292.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_292);
		}
		{	// ocl::Collection::asSequence() $ocl!Collection{T}!asSequence()
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("asSequence");
			//symbol_293.setMoniker("$ocl!Collection{T}!asSequence()");
			symbol_293.setType(symbol_226);  // $ocl!Sequence[$ocl!Collection{T}?T]
			
			symbol_293.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation");
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Collection::asSet() $ocl!Collection{T}!asSet()
			Operation symbol_294 = PivotFactory.eINSTANCE.createOperation();
			symbol_294.setName("asSet");
			//symbol_294.setMoniker("$ocl!Collection{T}!asSet()");
			symbol_294.setType(symbol_229);  // $ocl!Set[$ocl!Collection{T}?T]
			
			symbol_294.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation");
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Collection::collect() $ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_295 = PivotFactory.eINSTANCE.createIteration();
			symbol_36.setName("V");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_295.setOwnedTemplateSignature(symbol_34);
			symbol_295.setName("collect");
			//symbol_295.setMoniker("$ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_295.setType(symbol_161);  // $ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("i");
			symbol_296.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_295.getOwnedIterators().add(symbol_296);
			Parameter symbol_297 = PivotFactory.eINSTANCE.createParameter();
			symbol_297.setName("body");
			//symbol_297.setMoniker("$ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_297.setType(symbol_173);  // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_295.getOwnedParameters().add(symbol_297);
			symbol_295.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_295.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_295);
		}
		{	// ocl::Collection::collectNested() $ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_298 = PivotFactory.eINSTANCE.createIteration();
			symbol_39.setName("V");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_298.setOwnedTemplateSignature(symbol_37);
			symbol_298.setName("collectNested");
			//symbol_298.setMoniker("$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_298.setType(symbol_156);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("i");
			symbol_299.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_298.getOwnedIterators().add(symbol_299);
			Parameter symbol_300 = PivotFactory.eINSTANCE.createParameter();
			symbol_300.setName("body");
			//symbol_300.setMoniker("$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_300.setType(symbol_172);  // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_298.getOwnedParameters().add(symbol_300);
			symbol_298.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_298.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_298);
		}
		{	// ocl::Collection::count() $ocl!Collection{T}!count($ocl!OclAny)
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_301.setName("count");
			//symbol_301.setMoniker("$ocl!Collection{T}!count($ocl!OclAny)");
			symbol_301.setType(symbol_56);  // Integer
			
			Parameter symbol_302 = PivotFactory.eINSTANCE.createParameter();
			symbol_302.setName("object");
			//symbol_302.setMoniker("$ocl!Collection{T}!count($ocl!OclAny)!object");
			symbol_302.setType(symbol_71);  // $ocl!OclAny
			
			symbol_301.getOwnedParameters().add(symbol_302);
			symbol_301.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionCountOperation");
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Collection::excludes() $ocl!Collection{T}!excludes($ocl!OclAny)
			Operation symbol_303 = PivotFactory.eINSTANCE.createOperation();
			symbol_303.setName("excludes");
			//symbol_303.setMoniker("$ocl!Collection{T}!excludes($ocl!OclAny)");
			symbol_303.setType(symbol_19);  // Boolean
			
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("object");
			//symbol_304.setMoniker("$ocl!Collection{T}!excludes($ocl!OclAny)!object");
			symbol_304.setType(symbol_71);  // $ocl!OclAny
			
			symbol_303.getOwnedParameters().add(symbol_304);
			symbol_303.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation");
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_303);
		}
		{	// ocl::Collection::excludesAll() $ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])
			Operation symbol_305 = PivotFactory.eINSTANCE.createOperation();
			symbol_42.setName("T2");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_305.setOwnedTemplateSignature(symbol_40);
			symbol_305.setName("excludesAll");
			//symbol_305.setMoniker("$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])");
			symbol_305.setType(symbol_19);  // Boolean
			
			Parameter symbol_306 = PivotFactory.eINSTANCE.createParameter();
			symbol_306.setName("c2");
			//symbol_306.setMoniker("$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])!c2");
			symbol_306.setType(symbol_157);  // $ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]
			
			symbol_305.getOwnedParameters().add(symbol_306);
			symbol_305.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation");
			symbol_305.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_305);
		}
		{	// ocl::Collection::excluding() $ocl!Collection{T}!excluding($ocl!OclAny)
			Operation symbol_307 = PivotFactory.eINSTANCE.createOperation();
			symbol_307.setName("excluding");
			//symbol_307.setMoniker("$ocl!Collection{T}!excluding($ocl!OclAny)");
			symbol_307.setType(symbol_156);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_308 = PivotFactory.eINSTANCE.createParameter();
			symbol_308.setName("object");
			//symbol_308.setMoniker("$ocl!Collection{T}!excluding($ocl!OclAny)!object");
			symbol_308.setType(symbol_71);  // $ocl!OclAny
			
			symbol_307.getOwnedParameters().add(symbol_308);
			symbol_307.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_307.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_307);
		}
		{	// ocl::Collection::exists() $ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_309 = PivotFactory.eINSTANCE.createIteration();
			symbol_309.setName("exists");
			//symbol_309.setMoniker("$ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_309.setType(symbol_19);  // Boolean
			
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("i");
			symbol_310.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_309.getOwnedIterators().add(symbol_310);
			Parameter symbol_311 = PivotFactory.eINSTANCE.createParameter();
			symbol_311.setName("body");
			//symbol_311.setMoniker("$ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_311.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_309.getOwnedParameters().add(symbol_311);
			symbol_309.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Collection::exists() $ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_312 = PivotFactory.eINSTANCE.createIteration();
			symbol_312.setName("exists");
			//symbol_312.setMoniker("$ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_312.setType(symbol_19);  // Boolean
			
			Parameter symbol_313 = PivotFactory.eINSTANCE.createParameter();
			symbol_313.setName("i");
			symbol_313.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_312.getOwnedIterators().add(symbol_313);
			Parameter symbol_314 = PivotFactory.eINSTANCE.createParameter();
			symbol_314.setName("j");
			symbol_314.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_312.getOwnedIterators().add(symbol_314);
			Parameter symbol_315 = PivotFactory.eINSTANCE.createParameter();
			symbol_315.setName("body");
			//symbol_315.setMoniker("$ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_315.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_312.getOwnedParameters().add(symbol_315);
			symbol_312.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_312.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_312);
		}
		{	// ocl::Collection::flatten() $ocl!Collection{T}!flatten{T2}()
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_45.setName("T2");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_316.setOwnedTemplateSignature(symbol_43);
			symbol_316.setName("flatten");
			//symbol_316.setMoniker("$ocl!Collection{T}!flatten{T2}()");
			symbol_316.setType(symbol_162);  // $ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]
			
			symbol_316.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Collection::forAll() $ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_317 = PivotFactory.eINSTANCE.createIteration();
			symbol_317.setName("forAll");
			//symbol_317.setMoniker("$ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_317.setType(symbol_19);  // Boolean
			
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("i");
			symbol_318.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_317.getOwnedIterators().add(symbol_318);
			Parameter symbol_319 = PivotFactory.eINSTANCE.createParameter();
			symbol_319.setName("body");
			//symbol_319.setMoniker("$ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_319.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_317.getOwnedParameters().add(symbol_319);
			symbol_317.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_317);
		}
		{	// ocl::Collection::forAll() $ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_320 = PivotFactory.eINSTANCE.createIteration();
			symbol_320.setName("forAll");
			//symbol_320.setMoniker("$ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_320.setType(symbol_19);  // Boolean
			
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("i");
			symbol_321.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_320.getOwnedIterators().add(symbol_321);
			Parameter symbol_322 = PivotFactory.eINSTANCE.createParameter();
			symbol_322.setName("j");
			symbol_322.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_320.getOwnedIterators().add(symbol_322);
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("body");
			//symbol_323.setMoniker("$ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_323.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_320.getOwnedParameters().add(symbol_323);
			symbol_320.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_320.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_320);
		}
		{	// ocl::Collection::includes() $ocl!Collection{T}!includes($ocl!OclAny)
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_324.setName("includes");
			//symbol_324.setMoniker("$ocl!Collection{T}!includes($ocl!OclAny)");
			symbol_324.setType(symbol_19);  // Boolean
			
			Parameter symbol_325 = PivotFactory.eINSTANCE.createParameter();
			symbol_325.setName("object");
			//symbol_325.setMoniker("$ocl!Collection{T}!includes($ocl!OclAny)!object");
			symbol_325.setType(symbol_71);  // $ocl!OclAny
			
			symbol_324.getOwnedParameters().add(symbol_325);
			symbol_324.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation");
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Collection::includesAll() $ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_48.setName("T2");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_326.setOwnedTemplateSignature(symbol_46);
			symbol_326.setName("includesAll");
			//symbol_326.setMoniker("$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])");
			symbol_326.setType(symbol_19);  // Boolean
			
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("c2");
			//symbol_327.setMoniker("$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])!c2");
			symbol_327.setType(symbol_166);  // $ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]
			
			symbol_326.getOwnedParameters().add(symbol_327);
			symbol_326.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation");
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::Collection::including() $ocl!Collection{T}!including(T)
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_328.setName("including");
			//symbol_328.setMoniker("$ocl!Collection{T}!including(T)");
			symbol_328.setType(symbol_156);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("object");
			//symbol_329.setMoniker("$ocl!Collection{T}!including(T)!object");
			symbol_329.setType(symbol_33);  // $ocl!Collection{T}?T
			
			symbol_328.getOwnedParameters().add(symbol_329);
			symbol_328.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::Collection::isEmpty() $ocl!Collection{T}!isEmpty()
			Operation symbol_330 = PivotFactory.eINSTANCE.createOperation();
			symbol_330.setName("isEmpty");
			//symbol_330.setMoniker("$ocl!Collection{T}!isEmpty()");
			symbol_330.setType(symbol_19);  // Boolean
			
			symbol_330.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation");
			symbol_330.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_330);
		}
		{	// ocl::Collection::isUnique() $ocl!Collection{T}!isUnique(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_331 = PivotFactory.eINSTANCE.createIteration();
			symbol_331.setName("isUnique");
			//symbol_331.setMoniker("$ocl!Collection{T}!isUnique(T|Lambda~T()$ocl!OclAny)");
			symbol_331.setType(symbol_19);  // Boolean
			
			Parameter symbol_332 = PivotFactory.eINSTANCE.createParameter();
			symbol_332.setName("i");
			symbol_332.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_331.getOwnedIterators().add(symbol_332);
			Parameter symbol_333 = PivotFactory.eINSTANCE.createParameter();
			symbol_333.setName("body");
			//symbol_333.setMoniker("$ocl!Collection{T}!isUnique(T|Lambda~T()$ocl!OclAny)!body");
			symbol_333.setType(symbol_174);  // Lambda~$ocl!Collection{T}?T()$ocl!OclAny
			
			symbol_331.getOwnedParameters().add(symbol_333);
			symbol_331.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IsUniqueIteration");
			symbol_331.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_331);
		}
		{	// ocl::Collection::iterate() $ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_334 = PivotFactory.eINSTANCE.createIteration();
			symbol_51.setName("Tacc");
			symbol_50.setOwnedParameteredElement(symbol_51);
			symbol_49.getOwnedParameters().add(symbol_50);
			
			symbol_334.setOwnedTemplateSignature(symbol_49);
			symbol_334.setName("iterate");
			//symbol_334.setMoniker("$ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_334.setType(symbol_51);  // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("i");
			symbol_335.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_334.getOwnedIterators().add(symbol_335);
			Parameter symbol_336 = PivotFactory.eINSTANCE.createParameter();
			symbol_336.setName("acc");
			symbol_336.setType(symbol_51);  // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_334.getOwnedAccumulators().add(symbol_336);
			symbol_334.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IterateIteration");
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::Collection::max() $ocl!Collection{T}!max()
			Operation symbol_337 = PivotFactory.eINSTANCE.createOperation();
			symbol_337.setName("max");
			//symbol_337.setMoniker("$ocl!Collection{T}!max()");
			symbol_337.setType(symbol_33);  // $ocl!Collection{T}?T
			
			symbol_337.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMaxOperation");
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::Collection::min() $ocl!Collection{T}!min()
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("min");
			//symbol_338.setMoniker("$ocl!Collection{T}!min()");
			symbol_338.setType(symbol_33);  // $ocl!Collection{T}?T
			
			symbol_338.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMinOperation");
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::Collection::notEmpty() $ocl!Collection{T}!notEmpty()
			Operation symbol_339 = PivotFactory.eINSTANCE.createOperation();
			symbol_339.setName("notEmpty");
			//symbol_339.setMoniker("$ocl!Collection{T}!notEmpty()");
			symbol_339.setType(symbol_19);  // Boolean
			
			symbol_339.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation");
			symbol_339.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_339);
		}
		{	// ocl::Collection::one() $ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_340 = PivotFactory.eINSTANCE.createIteration();
			symbol_340.setName("one");
			//symbol_340.setMoniker("$ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_340.setType(symbol_19);  // Boolean
			
			Parameter symbol_341 = PivotFactory.eINSTANCE.createParameter();
			symbol_341.setName("i");
			symbol_341.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_340.getOwnedIterators().add(symbol_341);
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("body");
			//symbol_342.setMoniker("$ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_342.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_340.getOwnedParameters().add(symbol_342);
			symbol_340.setImplementationClass("org.eclipse.ocl.examples.library.iterator.OneIteration");
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_340);
		}
		{	// ocl::Collection::product() $ocl!Collection{T}!product{T2}($ocl!Collection[T2])
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_54.setName("T2");
			symbol_53.setOwnedParameteredElement(symbol_54);
			symbol_52.getOwnedParameters().add(symbol_53);
			
			symbol_343.setOwnedTemplateSignature(symbol_52);
			symbol_343.setName("product");
			//symbol_343.setMoniker("$ocl!Collection{T}!product{T2}($ocl!Collection[T2])");
			symbol_343.setType(symbol_232);  // $ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
			
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("c2");
			//symbol_344.setMoniker("$ocl!Collection{T}!product{T2}($ocl!Collection[T2])!c2");
			symbol_344.setType(symbol_158);  // $ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]
			
			symbol_343.getOwnedParameters().add(symbol_344);
			symbol_343.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionProductOperation");
			symbol_343.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_343);
		}
		{	// ocl::Collection::reject() $ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_345 = PivotFactory.eINSTANCE.createIteration();
			symbol_345.setName("reject");
			//symbol_345.setMoniker("$ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_345.setType(symbol_156);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("i");
			symbol_346.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_345.getOwnedIterators().add(symbol_346);
			Parameter symbol_347 = PivotFactory.eINSTANCE.createParameter();
			symbol_347.setName("body");
			//symbol_347.setMoniker("$ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_347.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_345.getOwnedParameters().add(symbol_347);
			symbol_345.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_345);
		}
		{	// ocl::Collection::select() $ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_348 = PivotFactory.eINSTANCE.createIteration();
			symbol_348.setName("select");
			//symbol_348.setMoniker("$ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_348.setType(symbol_156);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_349 = PivotFactory.eINSTANCE.createParameter();
			symbol_349.setName("i");
			symbol_349.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_348.getOwnedIterators().add(symbol_349);
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("body");
			//symbol_350.setMoniker("$ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_350.setType(symbol_179);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_348.getOwnedParameters().add(symbol_350);
			symbol_348.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_348);
		}
		{	// ocl::Collection::size() $ocl!Collection{T}!size()
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_351.setName("size");
			//symbol_351.setMoniker("$ocl!Collection{T}!size()");
			symbol_351.setType(symbol_56);  // Integer
			
			symbol_351.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSizeOperation");
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::Collection::sortedBy() $ocl!Collection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_352 = PivotFactory.eINSTANCE.createIteration();
			symbol_352.setName("sortedBy");
			//symbol_352.setMoniker("$ocl!Collection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)");
			symbol_352.setType(symbol_212);  // $ocl!OrderedCollection[$ocl!Collection{T}?T]
			
			Parameter symbol_353 = PivotFactory.eINSTANCE.createParameter();
			symbol_353.setName("i");
			symbol_353.setType(symbol_33);  // $ocl!Collection{T}?T
			symbol_352.getOwnedIterators().add(symbol_353);
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("body");
			//symbol_354.setMoniker("$ocl!Collection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)!body");
			symbol_354.setType(symbol_174);  // Lambda~$ocl!Collection{T}?T()$ocl!OclAny
			
			symbol_352.getOwnedParameters().add(symbol_354);
			symbol_352.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_352.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_352);
		}
		{	// ocl::Collection::sum() $ocl!Collection{T}!sum()
			Operation symbol_355 = PivotFactory.eINSTANCE.createOperation();
			symbol_355.setName("sum");
			//symbol_355.setMoniker("$ocl!Collection{T}!sum()");
			symbol_355.setType(symbol_33);  // $ocl!Collection{T}?T
			
			symbol_355.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSumOperation");
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_355);
		}
		symbol_1.getOwnedTypes().add(symbol_30);
		//
		// ocl::Enumeration $ocl!Enumeration
		//
		symbol_55.setName("Enumeration");
		//symbol_55.setMoniker("$ocl!Enumeration");
		symbol_55.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::Enumeration::allInstances() $ocl!Enumeration!allInstances()
			Operation symbol_356 = PivotFactory.eINSTANCE.createOperation();
			symbol_356.setName("allInstances");
			//symbol_356.setMoniker("$ocl!Enumeration!allInstances()");
			symbol_356.setType(symbol_235);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_356.setIsStatic(true);
			symbol_356.setImplementationClass("org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation");
			symbol_356.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_356);
		}
		symbol_1.getOwnedTypes().add(symbol_55);
		//
		// ocl::Integer Integer
		//
		symbol_56.setName("Integer");
		//symbol_56.setMoniker("Integer");
		symbol_56.getSuperClasses().add(symbol_105); // Real
		{	// ocl::Integer::*() Integer!*($ocl!OclSelf)
			Operation symbol_357 = PivotFactory.eINSTANCE.createOperation();
			symbol_357.setName("*");
			//symbol_357.setMoniker("Integer!*($ocl!OclSelf)");
			symbol_357.setType(symbol_56);  // Integer
			
			Parameter symbol_358 = PivotFactory.eINSTANCE.createParameter();
			symbol_358.setName("i");
			//symbol_358.setMoniker("Integer!*($ocl!OclSelf)!i");
			symbol_358.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_357.getOwnedParameters().add(symbol_358);
			symbol_357.setPrecedence(symbol_4);
			symbol_357.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_357.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_357);
		}
		{	// ocl::Integer::+() Integer!+($ocl!OclSelf)
			Operation symbol_359 = PivotFactory.eINSTANCE.createOperation();
			symbol_359.setName("+");
			//symbol_359.setMoniker("Integer!+($ocl!OclSelf)");
			symbol_359.setType(symbol_56);  // Integer
			
			Parameter symbol_360 = PivotFactory.eINSTANCE.createParameter();
			symbol_360.setName("i");
			//symbol_360.setMoniker("Integer!+($ocl!OclSelf)!i");
			symbol_360.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_359.getOwnedParameters().add(symbol_360);
			symbol_359.setPrecedence(symbol_5);
			symbol_359.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericPlusOperation");
			symbol_359.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_359);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_361 = PivotFactory.eINSTANCE.createOperation();
			symbol_361.setName("-");
			//symbol_361.setMoniker("Integer!-()");
			symbol_361.setType(symbol_56);  // Integer
			
			symbol_361.setPrecedence(symbol_3);
			symbol_361.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_361.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_361);
		}
		{	// ocl::Integer::-() Integer!-($ocl!OclSelf)
			Operation symbol_362 = PivotFactory.eINSTANCE.createOperation();
			symbol_362.setName("-");
			//symbol_362.setMoniker("Integer!-($ocl!OclSelf)");
			symbol_362.setType(symbol_56);  // Integer
			
			Parameter symbol_363 = PivotFactory.eINSTANCE.createParameter();
			symbol_363.setName("i");
			//symbol_363.setMoniker("Integer!-($ocl!OclSelf)!i");
			symbol_363.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_362.getOwnedParameters().add(symbol_363);
			symbol_362.setPrecedence(symbol_5);
			symbol_362.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinusOperation");
			symbol_362.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_362);
		}
		{	// ocl::Integer::/() Integer!/($ocl!OclSelf)
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("/");
			//symbol_364.setMoniker("Integer!/($ocl!OclSelf)");
			symbol_364.setType(symbol_105);  // Real
			
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("i");
			//symbol_365.setMoniker("Integer!/($ocl!OclSelf)!i");
			symbol_365.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_364.getOwnedParameters().add(symbol_365);
			symbol_364.setPrecedence(symbol_4);
			symbol_364.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_364);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_366.setName("abs");
			//symbol_366.setMoniker("Integer!abs()");
			symbol_366.setType(symbol_56);  // Integer
			
			symbol_366.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_366);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_367.setName("div");
			//symbol_367.setMoniker("Integer!div(Integer)");
			symbol_367.setType(symbol_56);  // Integer
			
			Parameter symbol_368 = PivotFactory.eINSTANCE.createParameter();
			symbol_368.setName("i");
			//symbol_368.setMoniker("Integer!div(Integer)!i");
			symbol_368.setType(symbol_56);  // Integer
			
			symbol_367.getOwnedParameters().add(symbol_368);
			symbol_367.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivOperation");
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::Integer::max() Integer!max($ocl!OclSelf)
			Operation symbol_369 = PivotFactory.eINSTANCE.createOperation();
			symbol_369.setName("max");
			//symbol_369.setMoniker("Integer!max($ocl!OclSelf)");
			symbol_369.setType(symbol_56);  // Integer
			
			Parameter symbol_370 = PivotFactory.eINSTANCE.createParameter();
			symbol_370.setName("i");
			//symbol_370.setMoniker("Integer!max($ocl!OclSelf)!i");
			symbol_370.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_369.getOwnedParameters().add(symbol_370);
			symbol_369.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_369.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_369);
		}
		{	// ocl::Integer::min() Integer!min($ocl!OclSelf)
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("min");
			//symbol_371.setMoniker("Integer!min($ocl!OclSelf)");
			symbol_371.setType(symbol_56);  // Integer
			
			Parameter symbol_372 = PivotFactory.eINSTANCE.createParameter();
			symbol_372.setName("i");
			//symbol_372.setMoniker("Integer!min($ocl!OclSelf)!i");
			symbol_372.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_371.getOwnedParameters().add(symbol_372);
			symbol_371.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_373 = PivotFactory.eINSTANCE.createOperation();
			symbol_373.setName("mod");
			//symbol_373.setMoniker("Integer!mod(Integer)");
			symbol_373.setType(symbol_56);  // Integer
			
			Parameter symbol_374 = PivotFactory.eINSTANCE.createParameter();
			symbol_374.setName("i");
			//symbol_374.setMoniker("Integer!mod(Integer)!i");
			symbol_374.setType(symbol_56);  // Integer
			
			symbol_373.getOwnedParameters().add(symbol_374);
			symbol_373.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericModOperation");
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_373);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_375 = PivotFactory.eINSTANCE.createOperation();
			symbol_375.setName("toString");
			//symbol_375.setMoniker("Integer!toString()");
			symbol_375.setType(symbol_123);  // String
			
			symbol_375.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_56.getOwnedOperations().add(symbol_375);
		}
		symbol_1.getOwnedTypes().add(symbol_56);
		//
		// ocl::NonOrderedCollection $ocl!NonOrderedCollection{T}
		//
		symbol_57.setName("NonOrderedCollection");
		//symbol_57.setMoniker("$ocl!NonOrderedCollection{T}");
		symbol_57.setElementType(symbol_60);
		symbol_60.setName("T");
		symbol_59.setOwnedParameteredElement(symbol_60);
		symbol_58.getOwnedParameters().add(symbol_59);
		
		symbol_57.setOwnedTemplateSignature(symbol_58);
		symbol_57.getSuperClasses().add(symbol_165); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() $ocl!NonOrderedCollection{T}!closure(T|Lambda~T()$ocl!Set[T])
			Iteration symbol_376 = PivotFactory.eINSTANCE.createIteration();
			symbol_376.setName("closure");
			//symbol_376.setMoniker("$ocl!NonOrderedCollection{T}!closure(T|Lambda~T()$ocl!Set[T])");
			symbol_376.setType(symbol_231);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_377 = PivotFactory.eINSTANCE.createParameter();
			symbol_377.setName("i");
			symbol_377.setType(symbol_60);  // $ocl!NonOrderedCollection{T}?T
			symbol_376.getOwnedIterators().add(symbol_377);
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("body");
			//symbol_378.setMoniker("$ocl!NonOrderedCollection{T}!closure(T|Lambda~T()$ocl!Set[T])!body");
			symbol_378.setType(symbol_171);  // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]
			
			symbol_376.getOwnedParameters().add(symbol_378);
			symbol_376.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_376.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_376);
		}
		{	// ocl::NonOrderedCollection::collect() $ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_379 = PivotFactory.eINSTANCE.createIteration();
			symbol_63.setName("V");
			symbol_62.setOwnedParameteredElement(symbol_63);
			symbol_61.getOwnedParameters().add(symbol_62);
			
			symbol_379.setOwnedTemplateSignature(symbol_61);
			symbol_379.setName("collect");
			//symbol_379.setMoniker("$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_379.setType(symbol_136);  // $ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("i");
			symbol_380.setType(symbol_60);  // $ocl!NonOrderedCollection{T}?T
			symbol_379.getOwnedIterators().add(symbol_380);
			Parameter symbol_381 = PivotFactory.eINSTANCE.createParameter();
			symbol_381.setName("body");
			//symbol_381.setMoniker("$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_381.setType(symbol_178);  // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_379.getOwnedParameters().add(symbol_381);
			symbol_379.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::NonOrderedCollection::collectNested() $ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_382 = PivotFactory.eINSTANCE.createIteration();
			symbol_66.setName("V");
			symbol_65.setOwnedParameteredElement(symbol_66);
			symbol_64.getOwnedParameters().add(symbol_65);
			
			symbol_382.setOwnedTemplateSignature(symbol_64);
			symbol_382.setName("collectNested");
			//symbol_382.setMoniker("$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_382.setType(symbol_133);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_383 = PivotFactory.eINSTANCE.createParameter();
			symbol_383.setName("i");
			symbol_383.setType(symbol_60);  // $ocl!NonOrderedCollection{T}?T
			symbol_382.getOwnedIterators().add(symbol_383);
			Parameter symbol_384 = PivotFactory.eINSTANCE.createParameter();
			symbol_384.setName("body");
			//symbol_384.setMoniker("$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_384.setType(symbol_181);  // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_382.getOwnedParameters().add(symbol_384);
			symbol_382.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_382);
		}
		{	// ocl::NonOrderedCollection::intersection() $ocl!NonOrderedCollection{T}!intersection($ocl!Bag[T])
			Operation symbol_385 = PivotFactory.eINSTANCE.createOperation();
			symbol_385.setName("intersection");
			//symbol_385.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Bag[T])");
			symbol_385.setType(symbol_133);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_386 = PivotFactory.eINSTANCE.createParameter();
			symbol_386.setName("bag");
			//symbol_386.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Bag[T])!bag");
			symbol_386.setType(symbol_133);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			symbol_385.getOwnedParameters().add(symbol_386);
			symbol_385.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_385.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_385);
		}
		{	// ocl::NonOrderedCollection::intersection() $ocl!NonOrderedCollection{T}!intersection($ocl!Set[T])
			Operation symbol_387 = PivotFactory.eINSTANCE.createOperation();
			symbol_387.setName("intersection");
			//symbol_387.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Set[T])");
			symbol_387.setType(symbol_231);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_388 = PivotFactory.eINSTANCE.createParameter();
			symbol_388.setName("s");
			//symbol_388.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Set[T])!s");
			symbol_388.setType(symbol_231);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			symbol_387.getOwnedParameters().add(symbol_388);
			symbol_387.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_387.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_387);
		}
		{	// ocl::NonOrderedCollection::union() $ocl!NonOrderedCollection{T}!union($ocl!Bag[T])
			Operation symbol_389 = PivotFactory.eINSTANCE.createOperation();
			symbol_389.setName("union");
			//symbol_389.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Bag[T])");
			symbol_389.setType(symbol_133);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_390 = PivotFactory.eINSTANCE.createParameter();
			symbol_390.setName("bag");
			//symbol_390.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Bag[T])!bag");
			symbol_390.setType(symbol_133);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			symbol_389.getOwnedParameters().add(symbol_390);
			symbol_389.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_389);
		}
		{	// ocl::NonOrderedCollection::union() $ocl!NonOrderedCollection{T}!union($ocl!Set[T])
			Operation symbol_391 = PivotFactory.eINSTANCE.createOperation();
			symbol_391.setName("union");
			//symbol_391.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Set[T])");
			symbol_391.setType(symbol_231);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("s");
			//symbol_392.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Set[T])!s");
			symbol_392.setType(symbol_231);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			symbol_391.getOwnedParameters().add(symbol_392);
			symbol_391.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_57.getOwnedOperations().add(symbol_391);
		}
		symbol_1.getOwnedTypes().add(symbol_57);
		//
		// ocl::NonUniqueCollection $ocl!NonUniqueCollection{T}
		//
		symbol_67.setName("NonUniqueCollection");
		//symbol_67.setMoniker("$ocl!NonUniqueCollection{T}");
		symbol_67.setElementType(symbol_70);
		symbol_70.setName("T");
		symbol_69.setOwnedParameteredElement(symbol_70);
		symbol_68.getOwnedParameters().add(symbol_69);
		
		symbol_67.setOwnedTemplateSignature(symbol_68);
		symbol_67.getSuperClasses().add(symbol_153); // $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() $ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_393 = PivotFactory.eINSTANCE.createIteration();
			symbol_393.setName("sortedBy");
			//symbol_393.setMoniker("$ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)");
			symbol_393.setType(symbol_221);  // $ocl!Sequence[$ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("i");
			symbol_394.setType(symbol_70);  // $ocl!NonUniqueCollection{T}?T
			symbol_393.getOwnedIterators().add(symbol_394);
			Parameter symbol_395 = PivotFactory.eINSTANCE.createParameter();
			symbol_395.setName("body");
			//symbol_395.setMoniker("$ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)!body");
			symbol_395.setType(symbol_180);  // Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny
			
			symbol_393.getOwnedParameters().add(symbol_395);
			symbol_393.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_393);
		}
		symbol_1.getOwnedTypes().add(symbol_67);
		//
		// ocl::OclAny $ocl!OclAny
		//
		symbol_71.setName("OclAny");
		//symbol_71.setMoniker("$ocl!OclAny");
		{	// ocl::OclAny::<>() $ocl!OclAny!<>($ocl!OclSelf)
			Operation symbol_396 = PivotFactory.eINSTANCE.createOperation();
			symbol_396.setName("<>");
			//symbol_396.setMoniker("$ocl!OclAny!<>($ocl!OclSelf)");
			symbol_396.setType(symbol_19);  // Boolean
			
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("object2");
			//symbol_397.setMoniker("$ocl!OclAny!<>($ocl!OclSelf)!object2");
			symbol_397.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_396.getOwnedParameters().add(symbol_397);
			symbol_396.setPrecedence(symbol_7);
			symbol_396.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_396);
		}
		{	// ocl::OclAny::=() $ocl!OclAny!=($ocl!OclSelf)
			Operation symbol_398 = PivotFactory.eINSTANCE.createOperation();
			symbol_398.setName("=");
			//symbol_398.setMoniker("$ocl!OclAny!=($ocl!OclSelf)");
			symbol_398.setType(symbol_19);  // Boolean
			
			Parameter symbol_399 = PivotFactory.eINSTANCE.createParameter();
			symbol_399.setName("object2");
			//symbol_399.setMoniker("$ocl!OclAny!=($ocl!OclSelf)!object2");
			symbol_399.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_398.getOwnedParameters().add(symbol_399);
			symbol_398.setPrecedence(symbol_7);
			symbol_398.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_398.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_398);
		}
		{	// ocl::OclAny::oclAsSet() $ocl!OclAny!oclAsSet()
			Operation symbol_400 = PivotFactory.eINSTANCE.createOperation();
			symbol_400.setName("oclAsSet");
			//symbol_400.setMoniker("$ocl!OclAny!oclAsSet()");
			symbol_400.setType(symbol_235);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_400.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation");
			symbol_400.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_400);
		}
		{	// ocl::OclAny::oclAsType() $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_74.setName("TT");
			symbol_73.setOwnedParameteredElement(symbol_74);
			symbol_72.getOwnedParameters().add(symbol_73);
			
			symbol_401.setOwnedTemplateSignature(symbol_72);
			symbol_401.setName("oclAsType");
			//symbol_401.setMoniker("$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])");
			symbol_401.setType(symbol_74);  // $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("type");
			//symbol_402.setMoniker("$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])!type");
			symbol_402.setType(symbol_138);  // $ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation");
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OclAny::oclIsInState() $ocl!OclAny!oclIsInState($ocl!OclState)
			Operation symbol_403 = PivotFactory.eINSTANCE.createOperation();
			symbol_403.setName("oclIsInState");
			//symbol_403.setMoniker("$ocl!OclAny!oclIsInState($ocl!OclState)");
			symbol_403.setType(symbol_19);  // Boolean
			
			Parameter symbol_404 = PivotFactory.eINSTANCE.createParameter();
			symbol_404.setName("statespec");
			//symbol_404.setMoniker("$ocl!OclAny!oclIsInState($ocl!OclState)!statespec");
			symbol_404.setType(symbol_85);  // $ocl!OclState
			
			symbol_403.getOwnedParameters().add(symbol_404);
			symbol_403.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation");
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_403);
		}
		{	// ocl::OclAny::oclIsInvalid() $ocl!OclAny!oclIsInvalid()
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("oclIsInvalid");
			//symbol_405.setMoniker("$ocl!OclAny!oclIsInvalid()");
			symbol_405.setType(symbol_19);  // Boolean
			
			symbol_405.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation");
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_405);
		}
		{	// ocl::OclAny::oclIsKindOf() $ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_77.setName("T");
			symbol_76.setOwnedParameteredElement(symbol_77);
			symbol_75.getOwnedParameters().add(symbol_76);
			
			symbol_406.setOwnedTemplateSignature(symbol_75);
			symbol_406.setName("oclIsKindOf");
			//symbol_406.setMoniker("$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])");
			symbol_406.setType(symbol_19);  // Boolean
			
			Parameter symbol_407 = PivotFactory.eINSTANCE.createParameter();
			symbol_407.setName("type");
			//symbol_407.setMoniker("$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])!type");
			symbol_407.setType(symbol_139);  // $ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]
			
			symbol_406.getOwnedParameters().add(symbol_407);
			symbol_406.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation");
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OclAny::oclIsNew() $ocl!OclAny!oclIsNew()
			Operation symbol_408 = PivotFactory.eINSTANCE.createOperation();
			symbol_408.setName("oclIsNew");
			//symbol_408.setMoniker("$ocl!OclAny!oclIsNew()");
			symbol_408.setType(symbol_19);  // Boolean
			
			symbol_408.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_408);
		}
		{	// ocl::OclAny::oclIsTypeOf() $ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_80.setName("T");
			symbol_79.setOwnedParameteredElement(symbol_80);
			symbol_78.getOwnedParameters().add(symbol_79);
			
			symbol_409.setOwnedTemplateSignature(symbol_78);
			symbol_409.setName("oclIsTypeOf");
			//symbol_409.setMoniker("$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])");
			symbol_409.setType(symbol_19);  // Boolean
			
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("type");
			//symbol_410.setMoniker("$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])!type");
			symbol_410.setType(symbol_141);  // $ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]
			
			symbol_409.getOwnedParameters().add(symbol_410);
			symbol_409.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation");
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::OclAny::oclIsUndefined() $ocl!OclAny!oclIsUndefined()
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_411.setName("oclIsUndefined");
			//symbol_411.setMoniker("$ocl!OclAny!oclIsUndefined()");
			symbol_411.setType(symbol_19);  // Boolean
			
			symbol_411.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation");
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OclAny::oclType() $ocl!OclAny!oclType()
			Operation symbol_412 = PivotFactory.eINSTANCE.createOperation();
			symbol_412.setName("oclType");
			//symbol_412.setMoniker("$ocl!OclAny!oclType()");
			symbol_412.setType(symbol_137);  // $ocl!Classifier[$ocl!OclSelf]
			
			symbol_412.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation");
			symbol_412.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_412);
		}
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// ocl::OclInvalid $ocl!OclInvalid
		//
		symbol_81.setName("OclInvalid");
		//symbol_81.setMoniker("$ocl!OclInvalid");
		symbol_81.getSuperClasses().add(symbol_87); // $ocl!OclVoid
		{ // ocl::OclInvalid::oclBadProperty $ocl!OclInvalid!oclBadProperty
			symbol_82.setName("oclBadProperty");
			symbol_82.setType(symbol_81);  // $ocl!OclInvalid
			
			symbol_82.setIsResolveProxies(true);
			symbol_81.getOwnedAttributes().add(symbol_82);
		}
		{	// ocl::OclInvalid::<>() $ocl!OclInvalid!<>($ocl!OclSelf)
			Operation symbol_413 = PivotFactory.eINSTANCE.createOperation();
			symbol_413.setName("<>");
			//symbol_413.setMoniker("$ocl!OclInvalid!<>($ocl!OclSelf)");
			symbol_413.setType(symbol_19);  // Boolean
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("object2");
			//symbol_414.setMoniker("$ocl!OclInvalid!<>($ocl!OclSelf)!object2");
			symbol_414.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_413.getOwnedParameters().add(symbol_414);
			symbol_413.setPrecedence(symbol_7);
			symbol_413.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::OclInvalid::=() $ocl!OclInvalid!=($ocl!OclSelf)
			Operation symbol_415 = PivotFactory.eINSTANCE.createOperation();
			symbol_415.setName("=");
			//symbol_415.setMoniker("$ocl!OclInvalid!=($ocl!OclSelf)");
			symbol_415.setType(symbol_19);  // Boolean
			
			Parameter symbol_416 = PivotFactory.eINSTANCE.createParameter();
			symbol_416.setName("object2");
			//symbol_416.setMoniker("$ocl!OclInvalid!=($ocl!OclSelf)!object2");
			symbol_416.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_415.getOwnedParameters().add(symbol_416);
			symbol_415.setPrecedence(symbol_7);
			symbol_415.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_415.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_415);
		}
		{	// ocl::OclInvalid::allInstances() $ocl!OclInvalid!allInstances()
			Operation symbol_417 = PivotFactory.eINSTANCE.createOperation();
			symbol_417.setName("allInstances");
			//symbol_417.setMoniker("$ocl!OclInvalid!allInstances()");
			symbol_417.setType(symbol_235);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_417.setIsStatic(true);
			symbol_417.setImplementationClass("org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation");
			symbol_417.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_417);
		}
		{	// ocl::OclInvalid::oclBadOperation() $ocl!OclInvalid!oclBadOperation()
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("oclBadOperation");
			//symbol_418.setMoniker("$ocl!OclInvalid!oclBadOperation()");
			symbol_418.setType(symbol_81);  // $ocl!OclInvalid
			
			symbol_81.getOwnedOperations().add(symbol_418);
		}
		{	// ocl::OclInvalid::toString() $ocl!OclInvalid!toString()
			Operation symbol_419 = PivotFactory.eINSTANCE.createOperation();
			symbol_419.setName("toString");
			//symbol_419.setMoniker("$ocl!OclInvalid!toString()");
			symbol_419.setType(symbol_123);  // String
			
			symbol_419.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_419);
		}
		symbol_1.getOwnedTypes().add(symbol_81);
		//
		// ocl::OclMessage $ocl!OclMessage
		//
		symbol_83.setName("OclMessage");
		//symbol_83.setMoniker("$ocl!OclMessage");
		symbol_83.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::OclMessage::hasReturned() $ocl!OclMessage!hasReturned()
			Operation symbol_420 = PivotFactory.eINSTANCE.createOperation();
			symbol_420.setName("hasReturned");
			//symbol_420.setMoniker("$ocl!OclMessage!hasReturned()");
			symbol_420.setType(symbol_19);  // Boolean
			
			symbol_420.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_420.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_420);
		}
		{	// ocl::OclMessage::isOperationCall() $ocl!OclMessage!isOperationCall()
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("isOperationCall");
			//symbol_421.setMoniker("$ocl!OclMessage!isOperationCall()");
			symbol_421.setType(symbol_19);  // Boolean
			
			symbol_421.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_421);
		}
		{	// ocl::OclMessage::isSignalSent() $ocl!OclMessage!isSignalSent()
			Operation symbol_422 = PivotFactory.eINSTANCE.createOperation();
			symbol_422.setName("isSignalSent");
			//symbol_422.setMoniker("$ocl!OclMessage!isSignalSent()");
			symbol_422.setType(symbol_19);  // Boolean
			
			symbol_422.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_422);
		}
		{	// ocl::OclMessage::result() $ocl!OclMessage!result()
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("result");
			//symbol_423.setMoniker("$ocl!OclMessage!result()");
			symbol_423.setType(symbol_71);  // $ocl!OclAny
			
			symbol_423.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_423);
		}
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// ocl::OclSelf $ocl!OclSelf
		//
		symbol_84.setName("OclSelf");
		//symbol_84.setMoniker("$ocl!OclSelf");
		symbol_84.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// ocl::OclState $ocl!OclState
		//
		symbol_85.setName("OclState");
		//symbol_85.setMoniker("$ocl!OclState");
		symbol_85.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// ocl::OclTuple $ocl!OclTuple
		//
		symbol_86.setName("OclTuple");
		//symbol_86.setMoniker("$ocl!OclTuple");
		symbol_86.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::OclTuple::<>() $ocl!OclTuple!<>($ocl!OclSelf)
			Operation symbol_424 = PivotFactory.eINSTANCE.createOperation();
			symbol_424.setName("<>");
			//symbol_424.setMoniker("$ocl!OclTuple!<>($ocl!OclSelf)");
			symbol_424.setType(symbol_19);  // Boolean
			
			Parameter symbol_425 = PivotFactory.eINSTANCE.createParameter();
			symbol_425.setName("object2");
			//symbol_425.setMoniker("$ocl!OclTuple!<>($ocl!OclSelf)!object2");
			symbol_425.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_424.getOwnedParameters().add(symbol_425);
			symbol_424.setPrecedence(symbol_7);
			symbol_424.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_424.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_424);
		}
		{	// ocl::OclTuple::=() $ocl!OclTuple!=($ocl!OclSelf)
			Operation symbol_426 = PivotFactory.eINSTANCE.createOperation();
			symbol_426.setName("=");
			//symbol_426.setMoniker("$ocl!OclTuple!=($ocl!OclSelf)");
			symbol_426.setType(symbol_19);  // Boolean
			
			Parameter symbol_427 = PivotFactory.eINSTANCE.createParameter();
			symbol_427.setName("object2");
			//symbol_427.setMoniker("$ocl!OclTuple!=($ocl!OclSelf)!object2");
			symbol_427.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_426.getOwnedParameters().add(symbol_427);
			symbol_426.setPrecedence(symbol_7);
			symbol_426.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_426.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_426);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// ocl::OclVoid $ocl!OclVoid
		//
		symbol_87.setName("OclVoid");
		//symbol_87.setMoniker("$ocl!OclVoid");
		symbol_87.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::OclVoid::<>() $ocl!OclVoid!<>($ocl!OclSelf)
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("<>");
			//symbol_428.setMoniker("$ocl!OclVoid!<>($ocl!OclSelf)");
			symbol_428.setType(symbol_19);  // Boolean
			
			Parameter symbol_429 = PivotFactory.eINSTANCE.createParameter();
			symbol_429.setName("object2");
			//symbol_429.setMoniker("$ocl!OclVoid!<>($ocl!OclSelf)!object2");
			symbol_429.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_428.getOwnedParameters().add(symbol_429);
			symbol_428.setPrecedence(symbol_7);
			symbol_428.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_428.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::OclVoid::=() $ocl!OclVoid!=($ocl!OclSelf)
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("=");
			//symbol_430.setMoniker("$ocl!OclVoid!=($ocl!OclSelf)");
			symbol_430.setType(symbol_19);  // Boolean
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("object2");
			//symbol_431.setMoniker("$ocl!OclVoid!=($ocl!OclSelf)!object2");
			symbol_431.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_430.getOwnedParameters().add(symbol_431);
			symbol_430.setPrecedence(symbol_7);
			symbol_430.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::OclVoid::allInstances() $ocl!OclVoid!allInstances()
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("allInstances");
			//symbol_432.setMoniker("$ocl!OclVoid!allInstances()");
			symbol_432.setType(symbol_235);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_432.setIsStatic(true);
			symbol_432.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation");
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::OclVoid::and() $ocl!OclVoid!and(Boolean)
			Operation symbol_433 = PivotFactory.eINSTANCE.createOperation();
			symbol_433.setName("and");
			//symbol_433.setMoniker("$ocl!OclVoid!and(Boolean)");
			symbol_433.setType(symbol_19);  // Boolean
			
			Parameter symbol_434 = PivotFactory.eINSTANCE.createParameter();
			symbol_434.setName("b");
			//symbol_434.setMoniker("$ocl!OclVoid!and(Boolean)!b");
			symbol_434.setType(symbol_19);  // Boolean
			
			symbol_433.getOwnedParameters().add(symbol_434);
			symbol_433.setPrecedence(symbol_8);
			symbol_433.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation");
			symbol_433.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_433);
		}
		{	// ocl::OclVoid::implies() $ocl!OclVoid!implies(Boolean)
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_435.setName("implies");
			//symbol_435.setMoniker("$ocl!OclVoid!implies(Boolean)");
			symbol_435.setType(symbol_19);  // Boolean
			
			Parameter symbol_436 = PivotFactory.eINSTANCE.createParameter();
			symbol_436.setName("b");
			//symbol_436.setMoniker("$ocl!OclVoid!implies(Boolean)!b");
			symbol_436.setType(symbol_19);  // Boolean
			
			symbol_435.getOwnedParameters().add(symbol_436);
			symbol_435.setPrecedence(symbol_11);
			symbol_435.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation");
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_435);
		}
		{	// ocl::OclVoid::or() $ocl!OclVoid!or(Boolean)
			Operation symbol_437 = PivotFactory.eINSTANCE.createOperation();
			symbol_437.setName("or");
			//symbol_437.setMoniker("$ocl!OclVoid!or(Boolean)");
			symbol_437.setType(symbol_19);  // Boolean
			
			Parameter symbol_438 = PivotFactory.eINSTANCE.createParameter();
			symbol_438.setName("b");
			//symbol_438.setMoniker("$ocl!OclVoid!or(Boolean)!b");
			symbol_438.setType(symbol_19);  // Boolean
			
			symbol_437.getOwnedParameters().add(symbol_438);
			symbol_437.setPrecedence(symbol_9);
			symbol_437.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation");
			symbol_437.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_437);
		}
		{	// ocl::OclVoid::toString() $ocl!OclVoid!toString()
			Operation symbol_439 = PivotFactory.eINSTANCE.createOperation();
			symbol_439.setName("toString");
			//symbol_439.setMoniker("$ocl!OclVoid!toString()");
			symbol_439.setType(symbol_123);  // String
			
			symbol_439.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_439.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_87.getOwnedOperations().add(symbol_439);
		}
		symbol_1.getOwnedTypes().add(symbol_87);
		//
		// ocl::OrderedCollection $ocl!OrderedCollection{T}
		//
		symbol_88.setName("OrderedCollection");
		//symbol_88.setMoniker("$ocl!OrderedCollection{T}");
		symbol_88.setElementType(symbol_91);
		symbol_91.setName("T");
		symbol_90.setOwnedParameteredElement(symbol_91);
		symbol_89.getOwnedParameters().add(symbol_90);
		
		symbol_88.setOwnedTemplateSignature(symbol_89);
		symbol_88.getSuperClasses().add(symbol_151); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() $ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("at");
			//symbol_440.setMoniker("$ocl!OrderedCollection{T}!at(Integer)");
			symbol_440.setType(symbol_91);  // $ocl!OrderedCollection{T}?T
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("index");
			//symbol_441.setMoniker("$ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_441.setType(symbol_56);  // Integer
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation");
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OrderedCollection::closure() $ocl!OrderedCollection{T}!closure(T|Lambda~T()$ocl!OrderedSet[T])
			Iteration symbol_442 = PivotFactory.eINSTANCE.createIteration();
			symbol_442.setName("closure");
			//symbol_442.setMoniker("$ocl!OrderedCollection{T}!closure(T|Lambda~T()$ocl!OrderedSet[T])");
			symbol_442.setType(symbol_219);  // $ocl!OrderedSet[$ocl!OrderedCollection{T}?T]
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("i");
			symbol_443.setType(symbol_91);  // $ocl!OrderedCollection{T}?T
			symbol_442.getOwnedIterators().add(symbol_443);
			Parameter symbol_444 = PivotFactory.eINSTANCE.createParameter();
			symbol_444.setName("body");
			//symbol_444.setMoniker("$ocl!OrderedCollection{T}!closure(T|Lambda~T()$ocl!OrderedSet[T])!body");
			symbol_444.setType(symbol_183);  // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]
			
			symbol_442.getOwnedParameters().add(symbol_444);
			symbol_442.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::OrderedCollection::collect() $ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_445 = PivotFactory.eINSTANCE.createIteration();
			symbol_94.setName("V");
			symbol_93.setOwnedParameteredElement(symbol_94);
			symbol_92.getOwnedParameters().add(symbol_93);
			
			symbol_445.setOwnedTemplateSignature(symbol_92);
			symbol_445.setName("collect");
			//symbol_445.setMoniker("$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_445.setType(symbol_225);  // $ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_446 = PivotFactory.eINSTANCE.createParameter();
			symbol_446.setName("i");
			symbol_446.setType(symbol_91);  // $ocl!OrderedCollection{T}?T
			symbol_445.getOwnedIterators().add(symbol_446);
			Parameter symbol_447 = PivotFactory.eINSTANCE.createParameter();
			symbol_447.setName("body");
			//symbol_447.setMoniker("$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_447.setType(symbol_170);  // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_445.getOwnedParameters().add(symbol_447);
			symbol_445.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::OrderedCollection::collectNested() $ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_448 = PivotFactory.eINSTANCE.createIteration();
			symbol_97.setName("V");
			symbol_96.setOwnedParameteredElement(symbol_97);
			symbol_95.getOwnedParameters().add(symbol_96);
			
			symbol_448.setOwnedTemplateSignature(symbol_95);
			symbol_448.setName("collectNested");
			//symbol_448.setMoniker("$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_448.setType(symbol_224);  // $ocl!Sequence[$ocl!OrderedCollection{T}?T]
			
			Parameter symbol_449 = PivotFactory.eINSTANCE.createParameter();
			symbol_449.setName("i");
			symbol_449.setType(symbol_91);  // $ocl!OrderedCollection{T}?T
			symbol_448.getOwnedIterators().add(symbol_449);
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("body");
			//symbol_450.setMoniker("$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_450.setType(symbol_169);  // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_448.getOwnedParameters().add(symbol_450);
			symbol_448.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_448.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_448);
		}
		{	// ocl::OrderedCollection::first() $ocl!OrderedCollection{T}!first()
			Operation symbol_451 = PivotFactory.eINSTANCE.createOperation();
			symbol_451.setName("first");
			//symbol_451.setMoniker("$ocl!OrderedCollection{T}!first()");
			symbol_451.setType(symbol_91);  // $ocl!OrderedCollection{T}?T
			
			symbol_451.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation");
			symbol_451.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_451);
		}
		{	// ocl::OrderedCollection::indexOf() $ocl!OrderedCollection{T}!indexOf($ocl!OclAny)
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_452.setName("indexOf");
			//symbol_452.setMoniker("$ocl!OrderedCollection{T}!indexOf($ocl!OclAny)");
			symbol_452.setType(symbol_56);  // Integer
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("obj");
			//symbol_453.setMoniker("$ocl!OrderedCollection{T}!indexOf($ocl!OclAny)!obj");
			symbol_453.setType(symbol_71);  // $ocl!OclAny
			
			symbol_452.getOwnedParameters().add(symbol_453);
			symbol_452.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation");
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OrderedCollection::last() $ocl!OrderedCollection{T}!last()
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("last");
			//symbol_454.setMoniker("$ocl!OrderedCollection{T}!last()");
			symbol_454.setType(symbol_91);  // $ocl!OrderedCollection{T}?T
			
			symbol_454.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation");
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::OrderedCollection::reverse() $ocl!OrderedCollection{T}!reverse()
			Operation symbol_455 = PivotFactory.eINSTANCE.createOperation();
			symbol_455.setName("reverse");
			//symbol_455.setMoniker("$ocl!OrderedCollection{T}!reverse()");
			symbol_455.setType(symbol_207);  // $ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]
			
			symbol_455.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_88.getOwnedOperations().add(symbol_455);
		}
		symbol_1.getOwnedTypes().add(symbol_88);
		//
		// ocl::OrderedSet $ocl!OrderedSet{T}
		//
		symbol_98.setName("OrderedSet");
		//symbol_98.setMoniker("$ocl!OrderedSet{T}");
		symbol_98.setElementType(symbol_101);
		symbol_101.setName("T");
		symbol_100.setOwnedParameteredElement(symbol_101);
		symbol_99.getOwnedParameters().add(symbol_100);
		
		symbol_98.setOwnedTemplateSignature(symbol_99);
		symbol_98.getSuperClasses().add(symbol_243); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		symbol_98.getSuperClasses().add(symbol_208); // $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() $ocl!OrderedSet{T}!-($ocl!Set[$ocl!OclAny])
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_456.setName("-");
			//symbol_456.setMoniker("$ocl!OrderedSet{T}!-($ocl!Set[$ocl!OclAny])");
			symbol_456.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("s");
			//symbol_457.setMoniker("$ocl!OrderedSet{T}!-($ocl!Set[$ocl!OclAny])!s");
			symbol_457.setType(symbol_234);  // $ocl!Set[$ocl!OclAny]
			
			symbol_456.getOwnedParameters().add(symbol_457);
			symbol_456.setPrecedence(symbol_5);
			symbol_456.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_456);
		}
		{	// ocl::OrderedSet::<>() $ocl!OrderedSet{T}!<>($ocl!OclSelf)
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("<>");
			//symbol_458.setMoniker("$ocl!OrderedSet{T}!<>($ocl!OclSelf)");
			symbol_458.setType(symbol_19);  // Boolean
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("object2");
			//symbol_459.setMoniker("$ocl!OrderedSet{T}!<>($ocl!OclSelf)!object2");
			symbol_459.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_458.getOwnedParameters().add(symbol_459);
			symbol_458.setPrecedence(symbol_7);
			symbol_458.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::OrderedSet::=() $ocl!OrderedSet{T}!=($ocl!OclSelf)
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("=");
			//symbol_460.setMoniker("$ocl!OrderedSet{T}!=($ocl!OclSelf)");
			symbol_460.setType(symbol_19);  // Boolean
			
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("object2");
			//symbol_461.setMoniker("$ocl!OrderedSet{T}!=($ocl!OclSelf)!object2");
			symbol_461.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_460.getOwnedParameters().add(symbol_461);
			symbol_460.setPrecedence(symbol_7);
			symbol_460.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::OrderedSet::append() $ocl!OrderedSet{T}!append(T)
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("append");
			//symbol_462.setMoniker("$ocl!OrderedSet{T}!append(T)");
			symbol_462.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_463 = PivotFactory.eINSTANCE.createParameter();
			symbol_463.setName("object");
			//symbol_463.setMoniker("$ocl!OrderedSet{T}!append(T)!object");
			symbol_463.setType(symbol_101);  // $ocl!OrderedSet{T}?T
			
			symbol_462.getOwnedParameters().add(symbol_463);
			symbol_462.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::OrderedSet::excluding() $ocl!OrderedSet{T}!excluding($ocl!OclAny)
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("excluding");
			//symbol_464.setMoniker("$ocl!OrderedSet{T}!excluding($ocl!OclAny)");
			symbol_464.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("object");
			//symbol_465.setMoniker("$ocl!OrderedSet{T}!excluding($ocl!OclAny)!object");
			symbol_465.setType(symbol_71);  // $ocl!OclAny
			
			symbol_464.getOwnedParameters().add(symbol_465);
			symbol_464.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::OrderedSet::flatten() $ocl!OrderedSet{T}!flatten{T2}()
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_104.setName("T2");
			symbol_103.setOwnedParameteredElement(symbol_104);
			symbol_102.getOwnedParameters().add(symbol_103);
			
			symbol_466.setOwnedTemplateSignature(symbol_102);
			symbol_466.setName("flatten");
			//symbol_466.setMoniker("$ocl!OrderedSet{T}!flatten{T2}()");
			symbol_466.setType(symbol_217);  // $ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]
			
			symbol_466.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::OrderedSet::including() $ocl!OrderedSet{T}!including(T)
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("including");
			//symbol_467.setMoniker("$ocl!OrderedSet{T}!including(T)");
			symbol_467.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("object");
			//symbol_468.setMoniker("$ocl!OrderedSet{T}!including(T)!object");
			symbol_468.setType(symbol_101);  // $ocl!OrderedSet{T}?T
			
			symbol_467.getOwnedParameters().add(symbol_468);
			symbol_467.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::OrderedSet::insertAt() $ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("insertAt");
			//symbol_469.setMoniker("$ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_469.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("index");
			//symbol_470.setMoniker("$ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_470.setType(symbol_56);  // Integer
			
			symbol_469.getOwnedParameters().add(symbol_470);
			Parameter symbol_471 = PivotFactory.eINSTANCE.createParameter();
			symbol_471.setName("object");
			//symbol_471.setMoniker("$ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_471.setType(symbol_101);  // $ocl!OrderedSet{T}?T
			
			symbol_469.getOwnedParameters().add(symbol_471);
			symbol_469.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::OrderedSet::intersection() $ocl!OrderedSet{T}!intersection($ocl!Set[T])
			Operation symbol_472 = PivotFactory.eINSTANCE.createOperation();
			symbol_472.setName("intersection");
			//symbol_472.setMoniker("$ocl!OrderedSet{T}!intersection($ocl!Set[T])");
			symbol_472.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_473 = PivotFactory.eINSTANCE.createParameter();
			symbol_473.setName("o");
			//symbol_473.setMoniker("$ocl!OrderedSet{T}!intersection($ocl!Set[T])!o");
			symbol_473.setType(symbol_236);  // $ocl!Set[$ocl!OrderedSet{T}?T]
			
			symbol_472.getOwnedParameters().add(symbol_473);
			symbol_472.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_472.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_472);
		}
		{	// ocl::OrderedSet::prepend() $ocl!OrderedSet{T}!prepend(T)
			Operation symbol_474 = PivotFactory.eINSTANCE.createOperation();
			symbol_474.setName("prepend");
			//symbol_474.setMoniker("$ocl!OrderedSet{T}!prepend(T)");
			symbol_474.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_475 = PivotFactory.eINSTANCE.createParameter();
			symbol_475.setName("object");
			//symbol_475.setMoniker("$ocl!OrderedSet{T}!prepend(T)!object");
			symbol_475.setType(symbol_101);  // $ocl!OrderedSet{T}?T
			
			symbol_474.getOwnedParameters().add(symbol_475);
			symbol_474.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_474.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_474);
		}
		{	// ocl::OrderedSet::reject() $ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_476 = PivotFactory.eINSTANCE.createIteration();
			symbol_476.setName("reject");
			//symbol_476.setMoniker("$ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_476.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("i");
			symbol_477.setType(symbol_101);  // $ocl!OrderedSet{T}?T
			symbol_476.getOwnedIterators().add(symbol_477);
			Parameter symbol_478 = PivotFactory.eINSTANCE.createParameter();
			symbol_478.setName("body");
			//symbol_478.setMoniker("$ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_478.setType(symbol_182);  // Lambda~$ocl!OrderedSet{T}?T()Boolean
			
			symbol_476.getOwnedParameters().add(symbol_478);
			symbol_476.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_476.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_476);
		}
		{	// ocl::OrderedSet::reverse() $ocl!OrderedSet{T}!reverse()
			Operation symbol_479 = PivotFactory.eINSTANCE.createOperation();
			symbol_479.setName("reverse");
			//symbol_479.setMoniker("$ocl!OrderedSet{T}!reverse()");
			symbol_479.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			symbol_479.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_479.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_479);
		}
		{	// ocl::OrderedSet::select() $ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_480 = PivotFactory.eINSTANCE.createIteration();
			symbol_480.setName("select");
			//symbol_480.setMoniker("$ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_480.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("i");
			symbol_481.setType(symbol_101);  // $ocl!OrderedSet{T}?T
			symbol_480.getOwnedIterators().add(symbol_481);
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("body");
			//symbol_482.setMoniker("$ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_482.setType(symbol_182);  // Lambda~$ocl!OrderedSet{T}?T()Boolean
			
			symbol_480.getOwnedParameters().add(symbol_482);
			symbol_480.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::OrderedSet::subOrderedSet() $ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("subOrderedSet");
			//symbol_483.setMoniker("$ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_483.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("lower");
			//symbol_484.setMoniker("$ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_484.setType(symbol_56);  // Integer
			
			symbol_483.getOwnedParameters().add(symbol_484);
			Parameter symbol_485 = PivotFactory.eINSTANCE.createParameter();
			symbol_485.setName("upper");
			//symbol_485.setMoniker("$ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_485.setType(symbol_56);  // Integer
			
			symbol_483.getOwnedParameters().add(symbol_485);
			symbol_483.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation");
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::OrderedSet::symmetricDifference() $ocl!OrderedSet{T}!symmetricDifference($ocl!Set[$ocl!OclAny])
			Operation symbol_486 = PivotFactory.eINSTANCE.createOperation();
			symbol_486.setName("symmetricDifference");
			//symbol_486.setMoniker("$ocl!OrderedSet{T}!symmetricDifference($ocl!Set[$ocl!OclAny])");
			symbol_486.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("s");
			//symbol_487.setMoniker("$ocl!OrderedSet{T}!symmetricDifference($ocl!Set[$ocl!OclAny])!s");
			symbol_487.setType(symbol_234);  // $ocl!Set[$ocl!OclAny]
			
			symbol_486.getOwnedParameters().add(symbol_487);
			symbol_486.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_486.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_486);
		}
		{	// ocl::OrderedSet::union() $ocl!OrderedSet{T}!union($ocl!OrderedSet[T])
			Operation symbol_488 = PivotFactory.eINSTANCE.createOperation();
			symbol_488.setName("union");
			//symbol_488.setMoniker("$ocl!OrderedSet{T}!union($ocl!OrderedSet[T])");
			symbol_488.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_489 = PivotFactory.eINSTANCE.createParameter();
			symbol_489.setName("o");
			//symbol_489.setMoniker("$ocl!OrderedSet{T}!union($ocl!OrderedSet[T])!o");
			symbol_489.setType(symbol_220);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			symbol_488.getOwnedParameters().add(symbol_489);
			symbol_488.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::OrderedSet::union() $ocl!OrderedSet{T}!union($ocl!Set[T])
			Operation symbol_490 = PivotFactory.eINSTANCE.createOperation();
			symbol_490.setName("union");
			//symbol_490.setMoniker("$ocl!OrderedSet{T}!union($ocl!Set[T])");
			symbol_490.setType(symbol_236);  // $ocl!Set[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_491 = PivotFactory.eINSTANCE.createParameter();
			symbol_491.setName("s");
			//symbol_491.setMoniker("$ocl!OrderedSet{T}!union($ocl!Set[T])!s");
			symbol_491.setType(symbol_236);  // $ocl!Set[$ocl!OrderedSet{T}?T]
			
			symbol_490.getOwnedParameters().add(symbol_491);
			symbol_490.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_490.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_490);
		}
		symbol_1.getOwnedTypes().add(symbol_98);
		//
		// ocl::Real Real
		//
		symbol_105.setName("Real");
		//symbol_105.setMoniker("Real");
		symbol_105.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::Real::*() Real!*($ocl!OclSelf)
			Operation symbol_492 = PivotFactory.eINSTANCE.createOperation();
			symbol_492.setName("*");
			//symbol_492.setMoniker("Real!*($ocl!OclSelf)");
			symbol_492.setType(symbol_105);  // Real
			
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("r");
			//symbol_493.setMoniker("Real!*($ocl!OclSelf)!r");
			symbol_493.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_492.getOwnedParameters().add(symbol_493);
			symbol_492.setPrecedence(symbol_4);
			symbol_492.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_492.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_492);
		}
		{	// ocl::Real::+() Real!+($ocl!OclSelf)
			Operation symbol_494 = PivotFactory.eINSTANCE.createOperation();
			symbol_494.setName("+");
			//symbol_494.setMoniker("Real!+($ocl!OclSelf)");
			symbol_494.setType(symbol_105);  // Real
			
			Parameter symbol_495 = PivotFactory.eINSTANCE.createParameter();
			symbol_495.setName("r");
			//symbol_495.setMoniker("Real!+($ocl!OclSelf)!r");
			symbol_495.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_494.getOwnedParameters().add(symbol_495);
			symbol_494.setPrecedence(symbol_5);
			symbol_494.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericPlusOperation");
			symbol_494.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_494);
		}
		{	// ocl::Real::-() Real!-($ocl!OclSelf)
			Operation symbol_496 = PivotFactory.eINSTANCE.createOperation();
			symbol_496.setName("-");
			//symbol_496.setMoniker("Real!-($ocl!OclSelf)");
			symbol_496.setType(symbol_105);  // Real
			
			Parameter symbol_497 = PivotFactory.eINSTANCE.createParameter();
			symbol_497.setName("r");
			//symbol_497.setMoniker("Real!-($ocl!OclSelf)!r");
			symbol_497.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_496.getOwnedParameters().add(symbol_497);
			symbol_496.setPrecedence(symbol_5);
			symbol_496.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinusOperation");
			symbol_496.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_496);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("-");
			//symbol_498.setMoniker("Real!-()");
			symbol_498.setType(symbol_105);  // Real
			
			symbol_498.setPrecedence(symbol_3);
			symbol_498.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::Real::/() Real!/($ocl!OclSelf)
			Operation symbol_499 = PivotFactory.eINSTANCE.createOperation();
			symbol_499.setName("/");
			//symbol_499.setMoniker("Real!/($ocl!OclSelf)");
			symbol_499.setType(symbol_105);  // Real
			
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("r");
			//symbol_500.setMoniker("Real!/($ocl!OclSelf)!r");
			symbol_500.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_499.getOwnedParameters().add(symbol_500);
			symbol_499.setPrecedence(symbol_4);
			symbol_499.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_499.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_499);
		}
		{	// ocl::Real::<() Real!<($ocl!OclSelf)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("<");
			//symbol_501.setMoniker("Real!<($ocl!OclSelf)");
			symbol_501.setType(symbol_19);  // Boolean
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("r");
			//symbol_502.setMoniker("Real!<($ocl!OclSelf)!r");
			symbol_502.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setPrecedence(symbol_6);
			symbol_501.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation");
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::Real::<=() Real!<=($ocl!OclSelf)
			Operation symbol_503 = PivotFactory.eINSTANCE.createOperation();
			symbol_503.setName("<=");
			//symbol_503.setMoniker("Real!<=($ocl!OclSelf)");
			symbol_503.setType(symbol_19);  // Boolean
			
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("r");
			//symbol_504.setMoniker("Real!<=($ocl!OclSelf)!r");
			symbol_504.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_503.getOwnedParameters().add(symbol_504);
			symbol_503.setPrecedence(symbol_6);
			symbol_503.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation");
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::Real::<>() Real!<>($ocl!OclSelf)
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("<>");
			//symbol_505.setMoniker("Real!<>($ocl!OclSelf)");
			symbol_505.setType(symbol_19);  // Boolean
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("object2");
			//symbol_506.setMoniker("Real!<>($ocl!OclSelf)!object2");
			symbol_506.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_505.getOwnedParameters().add(symbol_506);
			symbol_505.setPrecedence(symbol_7);
			symbol_505.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::Real::=() Real!=($ocl!OclSelf)
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("=");
			//symbol_507.setMoniker("Real!=($ocl!OclSelf)");
			symbol_507.setType(symbol_19);  // Boolean
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("object2");
			//symbol_508.setMoniker("Real!=($ocl!OclSelf)!object2");
			symbol_508.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_507.getOwnedParameters().add(symbol_508);
			symbol_507.setPrecedence(symbol_7);
			symbol_507.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::Real::>() Real!>($ocl!OclSelf)
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_509.setName(">");
			//symbol_509.setMoniker("Real!>($ocl!OclSelf)");
			symbol_509.setType(symbol_19);  // Boolean
			
			Parameter symbol_510 = PivotFactory.eINSTANCE.createParameter();
			symbol_510.setName("r");
			//symbol_510.setMoniker("Real!>($ocl!OclSelf)!r");
			symbol_510.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_509.getOwnedParameters().add(symbol_510);
			symbol_509.setPrecedence(symbol_6);
			symbol_509.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation");
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::Real::>=() Real!>=($ocl!OclSelf)
			Operation symbol_511 = PivotFactory.eINSTANCE.createOperation();
			symbol_511.setName(">=");
			//symbol_511.setMoniker("Real!>=($ocl!OclSelf)");
			symbol_511.setType(symbol_19);  // Boolean
			
			Parameter symbol_512 = PivotFactory.eINSTANCE.createParameter();
			symbol_512.setName("r");
			//symbol_512.setMoniker("Real!>=($ocl!OclSelf)!r");
			symbol_512.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_511.getOwnedParameters().add(symbol_512);
			symbol_511.setPrecedence(symbol_6);
			symbol_511.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation");
			symbol_511.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_511);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_513 = PivotFactory.eINSTANCE.createOperation();
			symbol_513.setName("abs");
			//symbol_513.setMoniker("Real!abs()");
			symbol_513.setType(symbol_105);  // Real
			
			symbol_513.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_513.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_513);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_514 = PivotFactory.eINSTANCE.createOperation();
			symbol_514.setName("floor");
			//symbol_514.setMoniker("Real!floor()");
			symbol_514.setType(symbol_56);  // Integer
			
			symbol_514.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericFloorOperation");
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::Real::max() Real!max($ocl!OclSelf)
			Operation symbol_515 = PivotFactory.eINSTANCE.createOperation();
			symbol_515.setName("max");
			//symbol_515.setMoniker("Real!max($ocl!OclSelf)");
			symbol_515.setType(symbol_105);  // Real
			
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("r");
			//symbol_516.setMoniker("Real!max($ocl!OclSelf)!r");
			symbol_516.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_515.getOwnedParameters().add(symbol_516);
			symbol_515.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_515.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_515);
		}
		{	// ocl::Real::min() Real!min($ocl!OclSelf)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("min");
			//symbol_517.setMoniker("Real!min($ocl!OclSelf)");
			symbol_517.setType(symbol_105);  // Real
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("r");
			//symbol_518.setMoniker("Real!min($ocl!OclSelf)!r");
			symbol_518.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_517.getOwnedParameters().add(symbol_518);
			symbol_517.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{TT}($ocl!Classifier[TT])
			Operation symbol_519 = PivotFactory.eINSTANCE.createOperation();
			symbol_108.setName("TT");
			symbol_107.setOwnedParameteredElement(symbol_108);
			symbol_106.getOwnedParameters().add(symbol_107);
			
			symbol_519.setOwnedTemplateSignature(symbol_106);
			symbol_519.setName("oclAsType");
			//symbol_519.setMoniker("Real!oclAsType{TT}($ocl!Classifier[TT])");
			symbol_519.setType(symbol_108);  // Real!oclAsType{TT}($ocl!Classifier[TT])?TT
			
			Parameter symbol_520 = PivotFactory.eINSTANCE.createParameter();
			symbol_520.setName("type");
			//symbol_520.setMoniker("Real!oclAsType{TT}($ocl!Classifier[TT])!type");
			symbol_520.setType(symbol_140);  // $ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]
			
			symbol_519.getOwnedParameters().add(symbol_520);
			symbol_519.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation");
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_521 = PivotFactory.eINSTANCE.createOperation();
			symbol_521.setName("round");
			//symbol_521.setMoniker("Real!round()");
			symbol_521.setType(symbol_56);  // Integer
			
			symbol_521.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericRoundOperation");
			symbol_521.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_521);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("toString");
			//symbol_522.setMoniker("Real!toString()");
			symbol_522.setType(symbol_123);  // String
			
			symbol_522.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_522);
		}
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// ocl::Sequence $ocl!Sequence{T}
		//
		symbol_109.setName("Sequence");
		//symbol_109.setMoniker("$ocl!Sequence{T}");
		symbol_109.setElementType(symbol_112);
		symbol_112.setName("T");
		symbol_111.setOwnedParameteredElement(symbol_112);
		symbol_110.getOwnedParameters().add(symbol_111);
		
		symbol_109.setOwnedTemplateSignature(symbol_110);
		symbol_109.getSuperClasses().add(symbol_204); // $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		symbol_109.getSuperClasses().add(symbol_211); // $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() $ocl!Sequence{T}!<>($ocl!OclSelf)
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("<>");
			//symbol_523.setMoniker("$ocl!Sequence{T}!<>($ocl!OclSelf)");
			symbol_523.setType(symbol_19);  // Boolean
			
			Parameter symbol_524 = PivotFactory.eINSTANCE.createParameter();
			symbol_524.setName("object2");
			//symbol_524.setMoniker("$ocl!Sequence{T}!<>($ocl!OclSelf)!object2");
			symbol_524.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_523.getOwnedParameters().add(symbol_524);
			symbol_523.setPrecedence(symbol_7);
			symbol_523.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::Sequence::=() $ocl!Sequence{T}!=($ocl!OclSelf)
			Operation symbol_525 = PivotFactory.eINSTANCE.createOperation();
			symbol_525.setName("=");
			//symbol_525.setMoniker("$ocl!Sequence{T}!=($ocl!OclSelf)");
			symbol_525.setType(symbol_19);  // Boolean
			
			Parameter symbol_526 = PivotFactory.eINSTANCE.createParameter();
			symbol_526.setName("object2");
			//symbol_526.setMoniker("$ocl!Sequence{T}!=($ocl!OclSelf)!object2");
			symbol_526.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_525.getOwnedParameters().add(symbol_526);
			symbol_525.setPrecedence(symbol_7);
			symbol_525.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_525.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_525);
		}
		{	// ocl::Sequence::append() $ocl!Sequence{T}!append(T)
			Operation symbol_527 = PivotFactory.eINSTANCE.createOperation();
			symbol_527.setName("append");
			//symbol_527.setMoniker("$ocl!Sequence{T}!append(T)");
			symbol_527.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_528 = PivotFactory.eINSTANCE.createParameter();
			symbol_528.setName("object");
			//symbol_528.setMoniker("$ocl!Sequence{T}!append(T)!object");
			symbol_528.setType(symbol_112);  // $ocl!Sequence{T}?T
			
			symbol_527.getOwnedParameters().add(symbol_528);
			symbol_527.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_527.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_527);
		}
		{	// ocl::Sequence::excluding() $ocl!Sequence{T}!excluding($ocl!OclAny)
			Operation symbol_529 = PivotFactory.eINSTANCE.createOperation();
			symbol_529.setName("excluding");
			//symbol_529.setMoniker("$ocl!Sequence{T}!excluding($ocl!OclAny)");
			symbol_529.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_530 = PivotFactory.eINSTANCE.createParameter();
			symbol_530.setName("object");
			//symbol_530.setMoniker("$ocl!Sequence{T}!excluding($ocl!OclAny)!object");
			symbol_530.setType(symbol_71);  // $ocl!OclAny
			
			symbol_529.getOwnedParameters().add(symbol_530);
			symbol_529.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_529.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_529);
		}
		{	// ocl::Sequence::flatten() $ocl!Sequence{T}!flatten{T2}()
			Operation symbol_531 = PivotFactory.eINSTANCE.createOperation();
			symbol_115.setName("T2");
			symbol_114.setOwnedParameteredElement(symbol_115);
			symbol_113.getOwnedParameters().add(symbol_114);
			
			symbol_531.setOwnedTemplateSignature(symbol_113);
			symbol_531.setName("flatten");
			//symbol_531.setMoniker("$ocl!Sequence{T}!flatten{T2}()");
			symbol_531.setType(symbol_222);  // $ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]
			
			symbol_531.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_531.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_531);
		}
		{	// ocl::Sequence::including() $ocl!Sequence{T}!including(T)
			Operation symbol_532 = PivotFactory.eINSTANCE.createOperation();
			symbol_532.setName("including");
			//symbol_532.setMoniker("$ocl!Sequence{T}!including(T)");
			symbol_532.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_533 = PivotFactory.eINSTANCE.createParameter();
			symbol_533.setName("object");
			//symbol_533.setMoniker("$ocl!Sequence{T}!including(T)!object");
			symbol_533.setType(symbol_112);  // $ocl!Sequence{T}?T
			
			symbol_532.getOwnedParameters().add(symbol_533);
			symbol_532.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_532.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_532);
		}
		{	// ocl::Sequence::insertAt() $ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_534 = PivotFactory.eINSTANCE.createOperation();
			symbol_534.setName("insertAt");
			//symbol_534.setMoniker("$ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_534.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_535 = PivotFactory.eINSTANCE.createParameter();
			symbol_535.setName("index");
			//symbol_535.setMoniker("$ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_535.setType(symbol_56);  // Integer
			
			symbol_534.getOwnedParameters().add(symbol_535);
			Parameter symbol_536 = PivotFactory.eINSTANCE.createParameter();
			symbol_536.setName("object");
			//symbol_536.setMoniker("$ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_536.setType(symbol_112);  // $ocl!Sequence{T}?T
			
			symbol_534.getOwnedParameters().add(symbol_536);
			symbol_534.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_534.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_534);
		}
		{	// ocl::Sequence::prepend() $ocl!Sequence{T}!prepend(T)
			Operation symbol_537 = PivotFactory.eINSTANCE.createOperation();
			symbol_537.setName("prepend");
			//symbol_537.setMoniker("$ocl!Sequence{T}!prepend(T)");
			symbol_537.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_538 = PivotFactory.eINSTANCE.createParameter();
			symbol_538.setName("object");
			//symbol_538.setMoniker("$ocl!Sequence{T}!prepend(T)!object");
			symbol_538.setType(symbol_112);  // $ocl!Sequence{T}?T
			
			symbol_537.getOwnedParameters().add(symbol_538);
			symbol_537.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_537.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_537);
		}
		{	// ocl::Sequence::reject() $ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_539 = PivotFactory.eINSTANCE.createIteration();
			symbol_539.setName("reject");
			//symbol_539.setMoniker("$ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_539.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_540 = PivotFactory.eINSTANCE.createParameter();
			symbol_540.setName("i");
			symbol_540.setType(symbol_112);  // $ocl!Sequence{T}?T
			symbol_539.getOwnedIterators().add(symbol_540);
			Parameter symbol_541 = PivotFactory.eINSTANCE.createParameter();
			symbol_541.setName("body");
			//symbol_541.setMoniker("$ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_541.setType(symbol_176);  // Lambda~$ocl!Sequence{T}?T()Boolean
			
			symbol_539.getOwnedParameters().add(symbol_541);
			symbol_539.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_539.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_539);
		}
		{	// ocl::Sequence::reverse() $ocl!Sequence{T}!reverse()
			Operation symbol_542 = PivotFactory.eINSTANCE.createOperation();
			symbol_542.setName("reverse");
			//symbol_542.setMoniker("$ocl!Sequence{T}!reverse()");
			symbol_542.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			symbol_542.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_542.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_542);
		}
		{	// ocl::Sequence::select() $ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_543 = PivotFactory.eINSTANCE.createIteration();
			symbol_543.setName("select");
			//symbol_543.setMoniker("$ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_543.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_544 = PivotFactory.eINSTANCE.createParameter();
			symbol_544.setName("i");
			symbol_544.setType(symbol_112);  // $ocl!Sequence{T}?T
			symbol_543.getOwnedIterators().add(symbol_544);
			Parameter symbol_545 = PivotFactory.eINSTANCE.createParameter();
			symbol_545.setName("body");
			//symbol_545.setMoniker("$ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_545.setType(symbol_176);  // Lambda~$ocl!Sequence{T}?T()Boolean
			
			symbol_543.getOwnedParameters().add(symbol_545);
			symbol_543.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_543);
		}
		{	// ocl::Sequence::subSequence() $ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("subSequence");
			//symbol_546.setMoniker("$ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_546.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_547 = PivotFactory.eINSTANCE.createParameter();
			symbol_547.setName("lower");
			//symbol_547.setMoniker("$ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_547.setType(symbol_56);  // Integer
			
			symbol_546.getOwnedParameters().add(symbol_547);
			Parameter symbol_548 = PivotFactory.eINSTANCE.createParameter();
			symbol_548.setName("upper");
			//symbol_548.setMoniker("$ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_548.setType(symbol_56);  // Integer
			
			symbol_546.getOwnedParameters().add(symbol_548);
			symbol_546.setImplementationClass("org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation");
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_546);
		}
		{	// ocl::Sequence::union() $ocl!Sequence{T}!union($ocl!Sequence[T])
			Operation symbol_549 = PivotFactory.eINSTANCE.createOperation();
			symbol_549.setName("union");
			//symbol_549.setMoniker("$ocl!Sequence{T}!union($ocl!Sequence[T])");
			symbol_549.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_550 = PivotFactory.eINSTANCE.createParameter();
			symbol_550.setName("s");
			//symbol_550.setMoniker("$ocl!Sequence{T}!union($ocl!Sequence[T])!s");
			symbol_550.setType(symbol_223);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			symbol_549.getOwnedParameters().add(symbol_550);
			symbol_549.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_549.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_109.getOwnedOperations().add(symbol_549);
		}
		symbol_1.getOwnedTypes().add(symbol_109);
		//
		// ocl::Set $ocl!Set{T}
		//
		symbol_116.setName("Set");
		//symbol_116.setMoniker("$ocl!Set{T}");
		symbol_116.setElementType(symbol_119);
		symbol_119.setName("T");
		symbol_118.setOwnedParameteredElement(symbol_119);
		symbol_117.getOwnedParameters().add(symbol_118);
		
		symbol_116.setOwnedTemplateSignature(symbol_117);
		symbol_116.getSuperClasses().add(symbol_195); // $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		symbol_116.getSuperClasses().add(symbol_250); // $ocl!UniqueCollection[$ocl!Set{T}?T]
		{	// ocl::Set::-() $ocl!Set{T}!-($ocl!Set[$ocl!OclAny])
			Operation symbol_551 = PivotFactory.eINSTANCE.createOperation();
			symbol_551.setName("-");
			//symbol_551.setMoniker("$ocl!Set{T}!-($ocl!Set[$ocl!OclAny])");
			symbol_551.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_552 = PivotFactory.eINSTANCE.createParameter();
			symbol_552.setName("s");
			//symbol_552.setMoniker("$ocl!Set{T}!-($ocl!Set[$ocl!OclAny])!s");
			symbol_552.setType(symbol_234);  // $ocl!Set[$ocl!OclAny]
			
			symbol_551.getOwnedParameters().add(symbol_552);
			symbol_551.setPrecedence(symbol_5);
			symbol_551.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_551.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_551);
		}
		{	// ocl::Set::<>() $ocl!Set{T}!<>($ocl!OclSelf)
			Operation symbol_553 = PivotFactory.eINSTANCE.createOperation();
			symbol_553.setName("<>");
			//symbol_553.setMoniker("$ocl!Set{T}!<>($ocl!OclSelf)");
			symbol_553.setType(symbol_19);  // Boolean
			
			Parameter symbol_554 = PivotFactory.eINSTANCE.createParameter();
			symbol_554.setName("object2");
			//symbol_554.setMoniker("$ocl!Set{T}!<>($ocl!OclSelf)!object2");
			symbol_554.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_553.getOwnedParameters().add(symbol_554);
			symbol_553.setPrecedence(symbol_7);
			symbol_553.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_553.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_553);
		}
		{	// ocl::Set::=() $ocl!Set{T}!=($ocl!OclSelf)
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("=");
			//symbol_555.setMoniker("$ocl!Set{T}!=($ocl!OclSelf)");
			symbol_555.setType(symbol_19);  // Boolean
			
			Parameter symbol_556 = PivotFactory.eINSTANCE.createParameter();
			symbol_556.setName("object2");
			//symbol_556.setMoniker("$ocl!Set{T}!=($ocl!OclSelf)!object2");
			symbol_556.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_555.getOwnedParameters().add(symbol_556);
			symbol_555.setPrecedence(symbol_7);
			symbol_555.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_555);
		}
		{	// ocl::Set::excluding() $ocl!Set{T}!excluding($ocl!OclAny)
			Operation symbol_557 = PivotFactory.eINSTANCE.createOperation();
			symbol_557.setName("excluding");
			//symbol_557.setMoniker("$ocl!Set{T}!excluding($ocl!OclAny)");
			symbol_557.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_558 = PivotFactory.eINSTANCE.createParameter();
			symbol_558.setName("object");
			//symbol_558.setMoniker("$ocl!Set{T}!excluding($ocl!OclAny)!object");
			symbol_558.setType(symbol_71);  // $ocl!OclAny
			
			symbol_557.getOwnedParameters().add(symbol_558);
			symbol_557.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_557.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_557);
		}
		{	// ocl::Set::flatten() $ocl!Set{T}!flatten{T2}()
			Operation symbol_559 = PivotFactory.eINSTANCE.createOperation();
			symbol_122.setName("T2");
			symbol_121.setOwnedParameteredElement(symbol_122);
			symbol_120.getOwnedParameters().add(symbol_121);
			
			symbol_559.setOwnedTemplateSignature(symbol_120);
			symbol_559.setName("flatten");
			//symbol_559.setMoniker("$ocl!Set{T}!flatten{T2}()");
			symbol_559.setType(symbol_228);  // $ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]
			
			symbol_559.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_559.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_559);
		}
		{	// ocl::Set::including() $ocl!Set{T}!including(T)
			Operation symbol_560 = PivotFactory.eINSTANCE.createOperation();
			symbol_560.setName("including");
			//symbol_560.setMoniker("$ocl!Set{T}!including(T)");
			symbol_560.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_561 = PivotFactory.eINSTANCE.createParameter();
			symbol_561.setName("object");
			//symbol_561.setMoniker("$ocl!Set{T}!including(T)!object");
			symbol_561.setType(symbol_119);  // $ocl!Set{T}?T
			
			symbol_560.getOwnedParameters().add(symbol_561);
			symbol_560.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_560.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_560);
		}
		{	// ocl::Set::intersection() $ocl!Set{T}!intersection($ocl!Set[T])
			Operation symbol_562 = PivotFactory.eINSTANCE.createOperation();
			symbol_562.setName("intersection");
			//symbol_562.setMoniker("$ocl!Set{T}!intersection($ocl!Set[T])");
			symbol_562.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_563 = PivotFactory.eINSTANCE.createParameter();
			symbol_563.setName("s");
			//symbol_563.setMoniker("$ocl!Set{T}!intersection($ocl!Set[T])!s");
			symbol_563.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			symbol_562.getOwnedParameters().add(symbol_563);
			symbol_562.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_562.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_562);
		}
		{	// ocl::Set::reject() $ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_564 = PivotFactory.eINSTANCE.createIteration();
			symbol_564.setName("reject");
			//symbol_564.setMoniker("$ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_564.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_565 = PivotFactory.eINSTANCE.createParameter();
			symbol_565.setName("i");
			symbol_565.setType(symbol_119);  // $ocl!Set{T}?T
			symbol_564.getOwnedIterators().add(symbol_565);
			Parameter symbol_566 = PivotFactory.eINSTANCE.createParameter();
			symbol_566.setName("body");
			//symbol_566.setMoniker("$ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_566.setType(symbol_177);  // Lambda~$ocl!Set{T}?T()Boolean
			
			symbol_564.getOwnedParameters().add(symbol_566);
			symbol_564.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_564.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_564);
		}
		{	// ocl::Set::select() $ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_567 = PivotFactory.eINSTANCE.createIteration();
			symbol_567.setName("select");
			//symbol_567.setMoniker("$ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_567.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_568 = PivotFactory.eINSTANCE.createParameter();
			symbol_568.setName("i");
			symbol_568.setType(symbol_119);  // $ocl!Set{T}?T
			symbol_567.getOwnedIterators().add(symbol_568);
			Parameter symbol_569 = PivotFactory.eINSTANCE.createParameter();
			symbol_569.setName("body");
			//symbol_569.setMoniker("$ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_569.setType(symbol_177);  // Lambda~$ocl!Set{T}?T()Boolean
			
			symbol_567.getOwnedParameters().add(symbol_569);
			symbol_567.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_567.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_567);
		}
		{	// ocl::Set::symmetricDifference() $ocl!Set{T}!symmetricDifference($ocl!Set[$ocl!OclAny])
			Operation symbol_570 = PivotFactory.eINSTANCE.createOperation();
			symbol_570.setName("symmetricDifference");
			//symbol_570.setMoniker("$ocl!Set{T}!symmetricDifference($ocl!Set[$ocl!OclAny])");
			symbol_570.setType(symbol_233);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_571 = PivotFactory.eINSTANCE.createParameter();
			symbol_571.setName("s");
			//symbol_571.setMoniker("$ocl!Set{T}!symmetricDifference($ocl!Set[$ocl!OclAny])!s");
			symbol_571.setType(symbol_234);  // $ocl!Set[$ocl!OclAny]
			
			symbol_570.getOwnedParameters().add(symbol_571);
			symbol_570.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_570.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_116.getOwnedOperations().add(symbol_570);
		}
		symbol_1.getOwnedTypes().add(symbol_116);
		//
		// ocl::String String
		//
		symbol_123.setName("String");
		//symbol_123.setMoniker("String");
		symbol_123.getSuperClasses().add(symbol_71); // $ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_572 = PivotFactory.eINSTANCE.createOperation();
			symbol_572.setName("+");
			//symbol_572.setMoniker("String!+(String)");
			symbol_572.setType(symbol_123);  // String
			
			Parameter symbol_573 = PivotFactory.eINSTANCE.createParameter();
			symbol_573.setName("s");
			//symbol_573.setMoniker("String!+(String)!s");
			symbol_573.setType(symbol_123);  // String
			
			symbol_572.getOwnedParameters().add(symbol_573);
			symbol_572.setPrecedence(symbol_5);
			symbol_572.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_572.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_572);
		}
		{	// ocl::String::<() String!<($ocl!OclSelf)
			Operation symbol_574 = PivotFactory.eINSTANCE.createOperation();
			symbol_574.setName("<");
			//symbol_574.setMoniker("String!<($ocl!OclSelf)");
			symbol_574.setType(symbol_19);  // Boolean
			
			Parameter symbol_575 = PivotFactory.eINSTANCE.createParameter();
			symbol_575.setName("s");
			//symbol_575.setMoniker("String!<($ocl!OclSelf)!s");
			symbol_575.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_574.getOwnedParameters().add(symbol_575);
			symbol_574.setPrecedence(symbol_6);
			symbol_574.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanOperation");
			symbol_574.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_574);
		}
		{	// ocl::String::<=() String!<=($ocl!OclSelf)
			Operation symbol_576 = PivotFactory.eINSTANCE.createOperation();
			symbol_576.setName("<=");
			//symbol_576.setMoniker("String!<=($ocl!OclSelf)");
			symbol_576.setType(symbol_19);  // Boolean
			
			Parameter symbol_577 = PivotFactory.eINSTANCE.createParameter();
			symbol_577.setName("s");
			//symbol_577.setMoniker("String!<=($ocl!OclSelf)!s");
			symbol_577.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_576.getOwnedParameters().add(symbol_577);
			symbol_576.setPrecedence(symbol_6);
			symbol_576.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation");
			symbol_576.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_576);
		}
		{	// ocl::String::<>() String!<>($ocl!OclSelf)
			Operation symbol_578 = PivotFactory.eINSTANCE.createOperation();
			symbol_578.setName("<>");
			//symbol_578.setMoniker("String!<>($ocl!OclSelf)");
			symbol_578.setType(symbol_19);  // Boolean
			
			Parameter symbol_579 = PivotFactory.eINSTANCE.createParameter();
			symbol_579.setName("object2");
			//symbol_579.setMoniker("String!<>($ocl!OclSelf)!object2");
			symbol_579.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_578.getOwnedParameters().add(symbol_579);
			symbol_578.setPrecedence(symbol_7);
			symbol_578.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_578.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_578);
		}
		{	// ocl::String::=() String!=($ocl!OclSelf)
			Operation symbol_580 = PivotFactory.eINSTANCE.createOperation();
			symbol_580.setName("=");
			//symbol_580.setMoniker("String!=($ocl!OclSelf)");
			symbol_580.setType(symbol_19);  // Boolean
			
			Parameter symbol_581 = PivotFactory.eINSTANCE.createParameter();
			symbol_581.setName("object2");
			//symbol_581.setMoniker("String!=($ocl!OclSelf)!object2");
			symbol_581.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_580.getOwnedParameters().add(symbol_581);
			symbol_580.setPrecedence(symbol_7);
			symbol_580.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_580.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_580);
		}
		{	// ocl::String::>() String!>($ocl!OclSelf)
			Operation symbol_582 = PivotFactory.eINSTANCE.createOperation();
			symbol_582.setName(">");
			//symbol_582.setMoniker("String!>($ocl!OclSelf)");
			symbol_582.setType(symbol_19);  // Boolean
			
			Parameter symbol_583 = PivotFactory.eINSTANCE.createParameter();
			symbol_583.setName("s");
			//symbol_583.setMoniker("String!>($ocl!OclSelf)!s");
			symbol_583.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_582.getOwnedParameters().add(symbol_583);
			symbol_582.setPrecedence(symbol_6);
			symbol_582.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanOperation");
			symbol_582.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_582);
		}
		{	// ocl::String::>=() String!>=($ocl!OclSelf)
			Operation symbol_584 = PivotFactory.eINSTANCE.createOperation();
			symbol_584.setName(">=");
			//symbol_584.setMoniker("String!>=($ocl!OclSelf)");
			symbol_584.setType(symbol_19);  // Boolean
			
			Parameter symbol_585 = PivotFactory.eINSTANCE.createParameter();
			symbol_585.setName("s");
			//symbol_585.setMoniker("String!>=($ocl!OclSelf)!s");
			symbol_585.setType(symbol_84);  // $ocl!OclSelf
			
			symbol_584.getOwnedParameters().add(symbol_585);
			symbol_584.setPrecedence(symbol_6);
			symbol_584.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation");
			symbol_584.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_584);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_586 = PivotFactory.eINSTANCE.createOperation();
			symbol_586.setName("at");
			//symbol_586.setMoniker("String!at(Integer)");
			symbol_586.setType(symbol_123);  // String
			
			Parameter symbol_587 = PivotFactory.eINSTANCE.createParameter();
			symbol_587.setName("i");
			//symbol_587.setMoniker("String!at(Integer)!i");
			symbol_587.setType(symbol_56);  // Integer
			
			symbol_586.getOwnedParameters().add(symbol_587);
			symbol_586.setImplementationClass("org.eclipse.ocl.examples.library.string.StringAtOperation");
			symbol_586.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_586);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_588 = PivotFactory.eINSTANCE.createOperation();
			symbol_588.setName("characters");
			//symbol_588.setMoniker("String!characters()");
			symbol_588.setType(symbol_227);  // $ocl!Sequence[String]
			
			symbol_588.setImplementationClass("org.eclipse.ocl.examples.library.string.StringCharactersOperation");
			symbol_588.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_588);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_589 = PivotFactory.eINSTANCE.createOperation();
			symbol_589.setName("concat");
			//symbol_589.setMoniker("String!concat(String)");
			symbol_589.setType(symbol_123);  // String
			
			Parameter symbol_590 = PivotFactory.eINSTANCE.createParameter();
			symbol_590.setName("s");
			//symbol_590.setMoniker("String!concat(String)!s");
			symbol_590.setType(symbol_123);  // String
			
			symbol_589.getOwnedParameters().add(symbol_590);
			symbol_589.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_589.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_589);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_591 = PivotFactory.eINSTANCE.createOperation();
			symbol_591.setName("equalsIgnoreCase");
			//symbol_591.setMoniker("String!equalsIgnoreCase(String)");
			symbol_591.setType(symbol_19);  // Boolean
			
			Parameter symbol_592 = PivotFactory.eINSTANCE.createParameter();
			symbol_592.setName("s");
			//symbol_592.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_592.setType(symbol_123);  // String
			
			symbol_591.getOwnedParameters().add(symbol_592);
			symbol_591.setImplementationClass("org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation");
			symbol_591.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_591);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_593 = PivotFactory.eINSTANCE.createOperation();
			symbol_593.setName("indexOf");
			//symbol_593.setMoniker("String!indexOf(String)");
			symbol_593.setType(symbol_56);  // Integer
			
			Parameter symbol_594 = PivotFactory.eINSTANCE.createParameter();
			symbol_594.setName("s");
			//symbol_594.setMoniker("String!indexOf(String)!s");
			symbol_594.setType(symbol_123);  // String
			
			symbol_593.getOwnedParameters().add(symbol_594);
			symbol_593.setImplementationClass("org.eclipse.ocl.examples.library.string.StringIndexOfOperation");
			symbol_593.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_593);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_595 = PivotFactory.eINSTANCE.createOperation();
			symbol_595.setName("size");
			//symbol_595.setMoniker("String!size()");
			symbol_595.setType(symbol_56);  // Integer
			
			symbol_595.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSizeOperation");
			symbol_595.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_595);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_596 = PivotFactory.eINSTANCE.createOperation();
			symbol_596.setName("substring");
			//symbol_596.setMoniker("String!substring(Integer,Integer)");
			symbol_596.setType(symbol_123);  // String
			
			Parameter symbol_597 = PivotFactory.eINSTANCE.createParameter();
			symbol_597.setName("lower");
			//symbol_597.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_597.setType(symbol_56);  // Integer
			
			symbol_596.getOwnedParameters().add(symbol_597);
			Parameter symbol_598 = PivotFactory.eINSTANCE.createParameter();
			symbol_598.setName("upper");
			//symbol_598.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_598.setType(symbol_56);  // Integer
			
			symbol_596.getOwnedParameters().add(symbol_598);
			symbol_596.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSubstringOperation");
			symbol_596.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_596);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_599 = PivotFactory.eINSTANCE.createOperation();
			symbol_599.setName("toBoolean");
			//symbol_599.setMoniker("String!toBoolean()");
			symbol_599.setType(symbol_19);  // Boolean
			
			symbol_599.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToBooleanOperation");
			symbol_599.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_599);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_600 = PivotFactory.eINSTANCE.createOperation();
			symbol_600.setName("toInteger");
			//symbol_600.setMoniker("String!toInteger()");
			symbol_600.setType(symbol_56);  // Integer
			
			symbol_600.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToIntegerOperation");
			symbol_600.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_600);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_601 = PivotFactory.eINSTANCE.createOperation();
			symbol_601.setName("toLower");
			//symbol_601.setMoniker("String!toLower()");
			symbol_601.setType(symbol_123);  // String
			
			symbol_601.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_601.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_601);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_602 = PivotFactory.eINSTANCE.createOperation();
			symbol_602.setName("toLowerCase");
			//symbol_602.setMoniker("String!toLowerCase()");
			symbol_602.setType(symbol_123);  // String
			
			symbol_602.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_602.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_602);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_603 = PivotFactory.eINSTANCE.createOperation();
			symbol_603.setName("toReal");
			//symbol_603.setMoniker("String!toReal()");
			symbol_603.setType(symbol_105);  // Real
			
			symbol_603.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToRealOperation");
			symbol_603.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_603);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_604 = PivotFactory.eINSTANCE.createOperation();
			symbol_604.setName("toString");
			//symbol_604.setMoniker("String!toString()");
			symbol_604.setType(symbol_123);  // String
			
			symbol_604.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_604.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_604);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_605 = PivotFactory.eINSTANCE.createOperation();
			symbol_605.setName("toUpper");
			//symbol_605.setMoniker("String!toUpper()");
			symbol_605.setType(symbol_123);  // String
			
			symbol_605.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_605.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_605);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_606 = PivotFactory.eINSTANCE.createOperation();
			symbol_606.setName("toUpperCase");
			//symbol_606.setMoniker("String!toUpperCase()");
			symbol_606.setType(symbol_123);  // String
			
			symbol_606.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_606.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_606);
		}
		symbol_1.getOwnedTypes().add(symbol_123);
		//
		// ocl::Tuple $ocl!Tuple
		//
		symbol_124.setName("Tuple");
		//symbol_124.setMoniker("$ocl!Tuple");
		symbol_124.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_124);
		//
		// ocl::UniqueCollection $ocl!UniqueCollection{T}
		//
		symbol_125.setName("UniqueCollection");
		//symbol_125.setMoniker("$ocl!UniqueCollection{T}");
		symbol_125.setElementType(symbol_128);
		symbol_128.setName("T");
		symbol_127.setOwnedParameteredElement(symbol_128);
		symbol_126.getOwnedParameters().add(symbol_127);
		
		symbol_125.setOwnedTemplateSignature(symbol_126);
		symbol_125.getSuperClasses().add(symbol_148); // $ocl!Collection[$ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() $ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_607 = PivotFactory.eINSTANCE.createIteration();
			symbol_607.setName("sortedBy");
			//symbol_607.setMoniker("$ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)");
			symbol_607.setType(symbol_216);  // $ocl!OrderedSet[$ocl!UniqueCollection{T}?T]
			
			Parameter symbol_608 = PivotFactory.eINSTANCE.createParameter();
			symbol_608.setName("i");
			symbol_608.setType(symbol_128);  // $ocl!UniqueCollection{T}?T
			symbol_607.getOwnedIterators().add(symbol_608);
			Parameter symbol_609 = PivotFactory.eINSTANCE.createParameter();
			symbol_609.setName("body");
			//symbol_609.setMoniker("$ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)!body");
			symbol_609.setType(symbol_184);  // Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny
			
			symbol_607.getOwnedParameters().add(symbol_609);
			symbol_607.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_607.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_607);
		}
		symbol_1.getOwnedTypes().add(symbol_125);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_129.setName("UnlimitedNatural");
		//symbol_129.setMoniker("UnlimitedNatural");
		symbol_129.getSuperClasses().add(symbol_56); // Integer
		symbol_1.getOwnedTypes().add(symbol_129);
		//
		// ocl::$$
		//
		symbol_130.setName("$$");
		symbol_130.setMoniker("$$");
		//
		// ocl::$$::$$ $$!$$
		//
		symbol_131.setName("$$");
		//symbol_131.setMoniker("$$!$$");
		symbol_130.getOwnedTypes().add(symbol_131);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!Bag{T}?T]
		//
		symbol_132.setName("Bag");
		//symbol_132.setMoniker("$ocl!Bag[$ocl!Bag{T}?T]");
		symbol_132.setElementType(symbol_15);
		symbol_132.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_610 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_610.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_611 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_611.setFormal(symbol_14);	
				symbol_611.setActual(symbol_15);	
				symbol_610.getParameterSubstitutions().add(symbol_611);
			}
			symbol_132.getTemplateBindings().add(symbol_610);
		}
		symbol_132.getSuperClasses().add(symbol_197); // $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		symbol_132.getSuperClasses().add(symbol_191); // $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		symbol_130.getOwnedTypes().add(symbol_132);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_133.setName("Bag");
		//symbol_133.setMoniker("$ocl!Bag[$ocl!NonOrderedCollection{T}?T]");
		symbol_133.setElementType(symbol_60);
		symbol_133.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_612 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_612.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_613 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_613.setFormal(symbol_14);	
				symbol_613.setActual(symbol_60);	
				symbol_612.getParameterSubstitutions().add(symbol_613);
			}
			symbol_133.getTemplateBindings().add(symbol_612);
		}
		symbol_133.getSuperClasses().add(symbol_201); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]
		symbol_133.getSuperClasses().add(symbol_57); // $ocl!NonOrderedCollection{T}
		symbol_130.getOwnedTypes().add(symbol_133);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!Collection{T}?T]
		//
		symbol_134.setName("Bag");
		//symbol_134.setMoniker("$ocl!Bag[$ocl!Collection{T}?T]");
		symbol_134.setElementType(symbol_33);
		symbol_134.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_614 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_614.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_615 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_615.setFormal(symbol_14);	
				symbol_615.setActual(symbol_33);	
				symbol_614.getParameterSubstitutions().add(symbol_615);
			}
			symbol_134.getTemplateBindings().add(symbol_614);
		}
		symbol_134.getSuperClasses().add(symbol_186); // $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		symbol_134.getSuperClasses().add(symbol_205); // $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_134);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_135.setName("Bag");
		//symbol_135.setMoniker("$ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_135.setElementType(symbol_18);
		symbol_135.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_616 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_616.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_617 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_617.setFormal(symbol_14);	
				symbol_617.setActual(symbol_18);	
				symbol_616.getParameterSubstitutions().add(symbol_617);
			}
			symbol_135.getTemplateBindings().add(symbol_616);
		}
		symbol_135.getSuperClasses().add(symbol_202); // $ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_135.getSuperClasses().add(symbol_194); // $ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_135);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_136.setName("Bag");
		//symbol_136.setMoniker("$ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_136.setElementType(symbol_63);
		symbol_136.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_618 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_618.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_619 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_619.setFormal(symbol_14);	
				symbol_619.setActual(symbol_63);	
				symbol_618.getParameterSubstitutions().add(symbol_619);
			}
			symbol_136.getTemplateBindings().add(symbol_618);
		}
		symbol_136.getSuperClasses().add(symbol_187); // $ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_136.getSuperClasses().add(symbol_198); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_136);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclSelf]
		//
		symbol_137.setName("Classifier");
		//symbol_137.setMoniker("$ocl!Classifier[$ocl!OclSelf]");
		symbol_137.setInstanceType(symbol_84);
		symbol_137.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_620 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_620.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_621 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_621.setFormal(symbol_22);	
				symbol_621.setActual(symbol_84);	
				symbol_620.getParameterSubstitutions().add(symbol_621);
			}
			symbol_137.getTemplateBindings().add(symbol_620);
		}
		symbol_137.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_137);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]
		//
		symbol_138.setName("Classifier");
		//symbol_138.setMoniker("$ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]");
		symbol_138.setInstanceType(symbol_74);
		symbol_138.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_622 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_622.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_623 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_623.setFormal(symbol_22);	
				symbol_623.setActual(symbol_74);	
				symbol_622.getParameterSubstitutions().add(symbol_623);
			}
			symbol_138.getTemplateBindings().add(symbol_622);
		}
		symbol_138.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_138);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]
		//
		symbol_139.setName("Classifier");
		//symbol_139.setMoniker("$ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]");
		symbol_139.setInstanceType(symbol_77);
		symbol_139.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_624 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_624.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_625 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_625.setFormal(symbol_22);	
				symbol_625.setActual(symbol_77);	
				symbol_624.getParameterSubstitutions().add(symbol_625);
			}
			symbol_139.getTemplateBindings().add(symbol_624);
		}
		symbol_139.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_139);
		//
		// ocl::$$::Classifier $ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]
		//
		symbol_140.setName("Classifier");
		//symbol_140.setMoniker("$ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]");
		symbol_140.setInstanceType(symbol_108);
		symbol_140.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_626 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_626.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_627 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_627.setFormal(symbol_22);	
				symbol_627.setActual(symbol_108);	
				symbol_626.getParameterSubstitutions().add(symbol_627);
			}
			symbol_140.getTemplateBindings().add(symbol_626);
		}
		symbol_140.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_140);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]
		//
		symbol_141.setName("Classifier");
		//symbol_141.setMoniker("$ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]");
		symbol_141.setInstanceType(symbol_80);
		symbol_141.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_628 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_628.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_629 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_629.setFormal(symbol_22);	
				symbol_629.setActual(symbol_80);	
				symbol_628.getParameterSubstitutions().add(symbol_629);
			}
			symbol_141.getTemplateBindings().add(symbol_628);
		}
		symbol_141.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_141);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]
		//
		symbol_142.setName("Classifier");
		//symbol_142.setMoniker("$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]");
		symbol_142.setInstanceType(symbol_29);
		symbol_142.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_630 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_630.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_631 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_631.setFormal(symbol_22);	
				symbol_631.setActual(symbol_29);	
				symbol_630.getParameterSubstitutions().add(symbol_631);
			}
			symbol_142.getTemplateBindings().add(symbol_630);
		}
		symbol_142.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_142);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]
		//
		symbol_143.setName("Classifier");
		//symbol_143.setMoniker("$ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]");
		symbol_143.setInstanceType(symbol_26);
		symbol_143.setUnspecializedElement(symbol_20);
		{
			TemplateBinding symbol_632 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_632.setSignature(symbol_21);
			{
				TemplateParameterSubstitution symbol_633 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_633.setFormal(symbol_22);	
				symbol_633.setActual(symbol_26);	
				symbol_632.getParameterSubstitutions().add(symbol_633);
			}
			symbol_143.getTemplateBindings().add(symbol_632);
		}
		symbol_143.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_143);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_144.setName("Collection");
		//symbol_144.setMoniker("$ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_144.setElementType(symbol_18);
		symbol_144.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_634 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_634.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_635 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_635.setFormal(symbol_32);	
				symbol_635.setActual(symbol_18);	
				symbol_634.getParameterSubstitutions().add(symbol_635);
			}
			symbol_144.getTemplateBindings().add(symbol_634);
		}
		symbol_144.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_144);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_145.setName("Collection");
		//symbol_145.setMoniker("$ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_145.setElementType(symbol_104);
		symbol_145.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_636 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_636.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_637 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_637.setFormal(symbol_32);	
				symbol_637.setActual(symbol_104);	
				symbol_636.getParameterSubstitutions().add(symbol_637);
			}
			symbol_145.getTemplateBindings().add(symbol_636);
		}
		symbol_145.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_145);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_146.setName("Collection");
		//symbol_146.setMoniker("$ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_146.setElementType(symbol_94);
		symbol_146.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_638 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_638.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_639 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_639.setFormal(symbol_32);	
				symbol_639.setActual(symbol_94);	
				symbol_638.getParameterSubstitutions().add(symbol_639);
			}
			symbol_146.getTemplateBindings().add(symbol_638);
		}
		symbol_146.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_146);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_147.setName("Collection");
		//symbol_147.setMoniker("$ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_147.setElementType(symbol_142);
		symbol_147.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_640 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_640.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_641 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_641.setFormal(symbol_32);	
				symbol_641.setActual(symbol_142);	
				symbol_640.getParameterSubstitutions().add(symbol_641);
			}
			symbol_147.getTemplateBindings().add(symbol_640);
		}
		symbol_147.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_147);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!UniqueCollection{T}?T]
		//
		symbol_148.setName("Collection");
		//symbol_148.setMoniker("$ocl!Collection[$ocl!UniqueCollection{T}?T]");
		symbol_148.setElementType(symbol_128);
		symbol_148.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_642 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_642.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_643 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_643.setFormal(symbol_32);	
				symbol_643.setActual(symbol_128);	
				symbol_642.getParameterSubstitutions().add(symbol_643);
			}
			symbol_148.getTemplateBindings().add(symbol_642);
		}
		symbol_148.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_148);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_149.setName("Collection");
		//symbol_149.setMoniker("$ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_149.setElementType(symbol_63);
		symbol_149.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_32);	
				symbol_645.setActual(symbol_63);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_149.getTemplateBindings().add(symbol_644);
		}
		symbol_149.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_149);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_150.setName("Collection");
		//symbol_150.setMoniker("$ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_150.setElementType(symbol_115);
		symbol_150.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_32);	
				symbol_647.setActual(symbol_115);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_150.getTemplateBindings().add(symbol_646);
		}
		symbol_150.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_150);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedCollection{T}?T]
		//
		symbol_151.setName("Collection");
		//symbol_151.setMoniker("$ocl!Collection[$ocl!OrderedCollection{T}?T]");
		symbol_151.setElementType(symbol_91);
		symbol_151.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_32);	
				symbol_649.setActual(symbol_91);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_151.getTemplateBindings().add(symbol_648);
		}
		symbol_151.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_151);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Set{T}?T]
		//
		symbol_152.setName("Collection");
		//symbol_152.setMoniker("$ocl!Collection[$ocl!Set{T}?T]");
		symbol_152.setElementType(symbol_119);
		symbol_152.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_32);	
				symbol_651.setActual(symbol_119);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_152.getTemplateBindings().add(symbol_650);
		}
		symbol_152.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_152);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		//
		symbol_153.setName("Collection");
		//symbol_153.setMoniker("$ocl!Collection[$ocl!NonUniqueCollection{T}?T]");
		symbol_153.setElementType(symbol_70);
		symbol_153.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_32);	
				symbol_653.setActual(symbol_70);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_153.getTemplateBindings().add(symbol_652);
		}
		symbol_153.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_153);
		//
		// ocl::$$::Collection $ocl!Collection[String]
		//
		symbol_154.setName("Collection");
		//symbol_154.setMoniker("$ocl!Collection[String]");
		symbol_154.setElementType(symbol_123);
		symbol_154.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_32);	
				symbol_655.setActual(symbol_123);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_154.getTemplateBindings().add(symbol_654);
		}
		symbol_154.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_154);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OclSelf]
		//
		symbol_155.setName("Collection");
		//symbol_155.setMoniker("$ocl!Collection[$ocl!OclSelf]");
		symbol_155.setElementType(symbol_84);
		symbol_155.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_32);	
				symbol_657.setActual(symbol_84);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_155.getTemplateBindings().add(symbol_656);
		}
		symbol_155.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_155);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}?T]
		//
		symbol_156.setName("Collection");
		//symbol_156.setMoniker("$ocl!Collection[$ocl!Collection{T}?T]");
		symbol_156.setElementType(symbol_33);
		symbol_156.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_32);	
				symbol_659.setActual(symbol_33);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_156.getTemplateBindings().add(symbol_658);
		}
		symbol_156.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_156);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]
		//
		symbol_157.setName("Collection");
		//symbol_157.setMoniker("$ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]");
		symbol_157.setElementType(symbol_42);
		symbol_157.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_32);	
				symbol_661.setActual(symbol_42);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_157.getTemplateBindings().add(symbol_660);
		}
		symbol_157.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_157);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]
		//
		symbol_158.setName("Collection");
		//symbol_158.setMoniker("$ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]");
		symbol_158.setElementType(symbol_54);
		symbol_158.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_32);	
				symbol_663.setActual(symbol_54);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_158.getTemplateBindings().add(symbol_662);
		}
		symbol_158.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_158);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_159.setName("Collection");
		//symbol_159.setMoniker("$ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_159.setElementType(symbol_122);
		symbol_159.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_32);	
				symbol_665.setActual(symbol_122);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_159.getTemplateBindings().add(symbol_664);
		}
		symbol_159.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_159);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OclAny]
		//
		symbol_160.setName("Collection");
		//symbol_160.setMoniker("$ocl!Collection[$ocl!OclAny]");
		symbol_160.setElementType(symbol_71);
		symbol_160.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_32);	
				symbol_667.setActual(symbol_71);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_160.getTemplateBindings().add(symbol_666);
		}
		symbol_160.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_160);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_161.setName("Collection");
		//symbol_161.setMoniker("$ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_161.setElementType(symbol_36);
		symbol_161.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_32);	
				symbol_669.setActual(symbol_36);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_161.getTemplateBindings().add(symbol_668);
		}
		symbol_161.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_161);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_162.setName("Collection");
		//symbol_162.setMoniker("$ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_162.setElementType(symbol_45);
		symbol_162.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_32);	
				symbol_671.setActual(symbol_45);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_162.getTemplateBindings().add(symbol_670);
		}
		symbol_162.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_162);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedSet{T}?T]
		//
		symbol_163.setName("Collection");
		//symbol_163.setMoniker("$ocl!Collection[$ocl!OrderedSet{T}?T]");
		symbol_163.setElementType(symbol_101);
		symbol_163.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_32);	
				symbol_673.setActual(symbol_101);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_163.getTemplateBindings().add(symbol_672);
		}
		symbol_163.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_163);
		//
		// ocl::$$::Collection $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_164.setName("Collection");
		//symbol_164.setMoniker("$ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_164.setElementType(symbol_237);
		symbol_164.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_32);	
				symbol_675.setActual(symbol_237);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_164.getTemplateBindings().add(symbol_674);
		}
		symbol_164.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_164);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_165.setName("Collection");
		//symbol_165.setMoniker("$ocl!Collection[$ocl!NonOrderedCollection{T}?T]");
		symbol_165.setElementType(symbol_60);
		symbol_165.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_32);	
				symbol_677.setActual(symbol_60);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_165.getTemplateBindings().add(symbol_676);
		}
		symbol_165.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_165);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]
		//
		symbol_166.setName("Collection");
		//symbol_166.setMoniker("$ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]");
		symbol_166.setElementType(symbol_48);
		symbol_166.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_32);	
				symbol_679.setActual(symbol_48);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_166.getTemplateBindings().add(symbol_678);
		}
		symbol_166.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_166);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Sequence{T}?T]
		//
		symbol_167.setName("Collection");
		//symbol_167.setMoniker("$ocl!Collection[$ocl!Sequence{T}?T]");
		symbol_167.setElementType(symbol_112);
		symbol_167.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_32);	
				symbol_681.setActual(symbol_112);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_167.getTemplateBindings().add(symbol_680);
		}
		symbol_167.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_167);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Bag{T}?T]
		//
		symbol_168.setName("Collection");
		//symbol_168.setMoniker("$ocl!Collection[$ocl!Bag{T}?T]");
		symbol_168.setElementType(symbol_15);
		symbol_168.setUnspecializedElement(symbol_30);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_32);	
				symbol_683.setActual(symbol_15);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_168.getTemplateBindings().add(symbol_682);
		}
		symbol_168.getSuperClasses().add(symbol_71); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_168);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_169.setName("Lambda");
		//symbol_169.setMoniker("Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_169.setContextType(symbol_91);
		symbol_169.setResultType(symbol_97);
		symbol_130.getOwnedTypes().add(symbol_169);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_170.setName("Lambda");
		//symbol_170.setMoniker("Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_170.setContextType(symbol_91);
		symbol_170.setResultType(symbol_94);
		symbol_130.getOwnedTypes().add(symbol_170);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]
		//
		symbol_171.setName("Lambda");
		//symbol_171.setMoniker("Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]");
		symbol_171.setContextType(symbol_60);
		symbol_171.setResultType(symbol_231);
		symbol_130.getOwnedTypes().add(symbol_171);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_172.setName("Lambda");
		//symbol_172.setMoniker("Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_172.setContextType(symbol_33);
		symbol_172.setResultType(symbol_39);
		symbol_130.getOwnedTypes().add(symbol_172);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_173.setName("Lambda");
		//symbol_173.setMoniker("Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_173.setContextType(symbol_33);
		symbol_173.setResultType(symbol_36);
		symbol_130.getOwnedTypes().add(symbol_173);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()$ocl!OclAny
		//
		symbol_174.setName("Lambda");
		//symbol_174.setMoniker("Lambda~$ocl!Collection{T}?T()$ocl!OclAny");
		symbol_174.setContextType(symbol_33);
		symbol_174.setResultType(symbol_71);
		symbol_130.getOwnedTypes().add(symbol_174);
		//
		// ocl::$$::Lambda Lambda~$ocl!Bag{T}?T()Boolean
		//
		symbol_175.setName("Lambda");
		//symbol_175.setMoniker("Lambda~$ocl!Bag{T}?T()Boolean");
		symbol_175.setContextType(symbol_15);
		symbol_175.setResultType(symbol_19);
		symbol_130.getOwnedTypes().add(symbol_175);
		//
		// ocl::$$::Lambda Lambda~$ocl!Sequence{T}?T()Boolean
		//
		symbol_176.setName("Lambda");
		//symbol_176.setMoniker("Lambda~$ocl!Sequence{T}?T()Boolean");
		symbol_176.setContextType(symbol_112);
		symbol_176.setResultType(symbol_19);
		symbol_130.getOwnedTypes().add(symbol_176);
		//
		// ocl::$$::Lambda Lambda~$ocl!Set{T}?T()Boolean
		//
		symbol_177.setName("Lambda");
		//symbol_177.setMoniker("Lambda~$ocl!Set{T}?T()Boolean");
		symbol_177.setContextType(symbol_119);
		symbol_177.setResultType(symbol_19);
		symbol_130.getOwnedTypes().add(symbol_177);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_178.setName("Lambda");
		//symbol_178.setMoniker("Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_178.setContextType(symbol_60);
		symbol_178.setResultType(symbol_63);
		symbol_130.getOwnedTypes().add(symbol_178);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()Boolean
		//
		symbol_179.setName("Lambda");
		//symbol_179.setMoniker("Lambda~$ocl!Collection{T}?T()Boolean");
		symbol_179.setContextType(symbol_33);
		symbol_179.setResultType(symbol_19);
		symbol_130.getOwnedTypes().add(symbol_179);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny
		//
		symbol_180.setName("Lambda");
		//symbol_180.setMoniker("Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny");
		symbol_180.setContextType(symbol_70);
		symbol_180.setResultType(symbol_71);
		symbol_130.getOwnedTypes().add(symbol_180);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_181.setName("Lambda");
		//symbol_181.setMoniker("Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_181.setContextType(symbol_60);
		symbol_181.setResultType(symbol_66);
		symbol_130.getOwnedTypes().add(symbol_181);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedSet{T}?T()Boolean
		//
		symbol_182.setName("Lambda");
		//symbol_182.setMoniker("Lambda~$ocl!OrderedSet{T}?T()Boolean");
		symbol_182.setContextType(symbol_101);
		symbol_182.setResultType(symbol_19);
		symbol_130.getOwnedTypes().add(symbol_182);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]
		//
		symbol_183.setName("Lambda");
		//symbol_183.setMoniker("Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]");
		symbol_183.setContextType(symbol_91);
		symbol_183.setResultType(symbol_219);
		symbol_130.getOwnedTypes().add(symbol_183);
		//
		// ocl::$$::Lambda Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny
		//
		symbol_184.setName("Lambda");
		//symbol_184.setMoniker("Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny");
		symbol_184.setContextType(symbol_128);
		symbol_184.setResultType(symbol_71);
		symbol_130.getOwnedTypes().add(symbol_184);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_185.setName("NonOrderedCollection");
		//symbol_185.setMoniker("$ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_185.setElementType(symbol_142);
		symbol_185.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_59);	
				symbol_685.setActual(symbol_142);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_185.getTemplateBindings().add(symbol_684);
		}
		symbol_185.getSuperClasses().add(symbol_147); // $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_130.getOwnedTypes().add(symbol_185);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		//
		symbol_186.setName("NonOrderedCollection");
		//symbol_186.setMoniker("$ocl!NonOrderedCollection[$ocl!Collection{T}?T]");
		symbol_186.setElementType(symbol_33);
		symbol_186.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_59);	
				symbol_687.setActual(symbol_33);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_186.getTemplateBindings().add(symbol_686);
		}
		symbol_186.getSuperClasses().add(symbol_30); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_186);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_187.setName("NonOrderedCollection");
		//symbol_187.setMoniker("$ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_187.setElementType(symbol_63);
		symbol_187.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_59);	
				symbol_689.setActual(symbol_63);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_187.getTemplateBindings().add(symbol_688);
		}
		symbol_187.getSuperClasses().add(symbol_149); // $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_187);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_188.setName("NonOrderedCollection");
		//symbol_188.setMoniker("$ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_188.setElementType(symbol_237);
		symbol_188.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_59);	
				symbol_691.setActual(symbol_237);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_188.getTemplateBindings().add(symbol_690);
		}
		symbol_188.getSuperClasses().add(symbol_164); // $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_130.getOwnedTypes().add(symbol_188);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!OclAny]
		//
		symbol_189.setName("NonOrderedCollection");
		//symbol_189.setMoniker("$ocl!NonOrderedCollection[$ocl!OclAny]");
		symbol_189.setElementType(symbol_71);
		symbol_189.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_59);	
				symbol_693.setActual(symbol_71);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_189.getTemplateBindings().add(symbol_692);
		}
		symbol_189.getSuperClasses().add(symbol_160); // $ocl!Collection[$ocl!OclAny]
		symbol_130.getOwnedTypes().add(symbol_189);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_190.setName("NonOrderedCollection");
		//symbol_190.setMoniker("$ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_190.setElementType(symbol_122);
		symbol_190.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_59);	
				symbol_695.setActual(symbol_122);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_190.getTemplateBindings().add(symbol_694);
		}
		symbol_190.getSuperClasses().add(symbol_159); // $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_190);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		//
		symbol_191.setName("NonOrderedCollection");
		//symbol_191.setMoniker("$ocl!NonOrderedCollection[$ocl!Bag{T}?T]");
		symbol_191.setElementType(symbol_15);
		symbol_191.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_59);	
				symbol_697.setActual(symbol_15);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_191.getTemplateBindings().add(symbol_696);
		}
		symbol_191.getSuperClasses().add(symbol_168); // $ocl!Collection[$ocl!Bag{T}?T]
		symbol_130.getOwnedTypes().add(symbol_191);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!OclSelf]
		//
		symbol_192.setName("NonOrderedCollection");
		//symbol_192.setMoniker("$ocl!NonOrderedCollection[$ocl!OclSelf]");
		symbol_192.setElementType(symbol_84);
		symbol_192.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_59);	
				symbol_699.setActual(symbol_84);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_192.getTemplateBindings().add(symbol_698);
		}
		symbol_192.getSuperClasses().add(symbol_155); // $ocl!Collection[$ocl!OclSelf]
		symbol_130.getOwnedTypes().add(symbol_192);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]
		//
		symbol_193.setName("NonOrderedCollection");
		//symbol_193.setMoniker("$ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]");
		symbol_193.setElementType(symbol_101);
		symbol_193.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_59);	
				symbol_701.setActual(symbol_101);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_193.getTemplateBindings().add(symbol_700);
		}
		symbol_193.getSuperClasses().add(symbol_163); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_193);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_194.setName("NonOrderedCollection");
		//symbol_194.setMoniker("$ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_194.setElementType(symbol_18);
		symbol_194.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_59);	
				symbol_703.setActual(symbol_18);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_194.getTemplateBindings().add(symbol_702);
		}
		symbol_194.getSuperClasses().add(symbol_144); // $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_194);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		//
		symbol_195.setName("NonOrderedCollection");
		//symbol_195.setMoniker("$ocl!NonOrderedCollection[$ocl!Set{T}?T]");
		symbol_195.setElementType(symbol_119);
		symbol_195.setUnspecializedElement(symbol_57);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_58);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_59);	
				symbol_705.setActual(symbol_119);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_195.getTemplateBindings().add(symbol_704);
		}
		symbol_195.getSuperClasses().add(symbol_152); // $ocl!Collection[$ocl!Set{T}?T]
		symbol_130.getOwnedTypes().add(symbol_195);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]
		//
		symbol_196.setName("NonUniqueCollection");
		//symbol_196.setMoniker("$ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]");
		symbol_196.setElementType(symbol_91);
		symbol_196.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_69);	
				symbol_707.setActual(symbol_91);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_196.getTemplateBindings().add(symbol_706);
		}
		symbol_196.getSuperClasses().add(symbol_151); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_196);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		//
		symbol_197.setName("NonUniqueCollection");
		//symbol_197.setMoniker("$ocl!NonUniqueCollection[$ocl!Bag{T}?T]");
		symbol_197.setElementType(symbol_15);
		symbol_197.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_69);	
				symbol_709.setActual(symbol_15);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_197.getTemplateBindings().add(symbol_708);
		}
		symbol_197.getSuperClasses().add(symbol_168); // $ocl!Collection[$ocl!Bag{T}?T]
		symbol_130.getOwnedTypes().add(symbol_197);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_198.setName("NonUniqueCollection");
		//symbol_198.setMoniker("$ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_198.setElementType(symbol_63);
		symbol_198.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_69);	
				symbol_711.setActual(symbol_63);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_198.getTemplateBindings().add(symbol_710);
		}
		symbol_198.getSuperClasses().add(symbol_149); // $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_198);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_199.setName("NonUniqueCollection");
		//symbol_199.setMoniker("$ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_199.setElementType(symbol_94);
		symbol_199.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_69);	
				symbol_713.setActual(symbol_94);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_199.getTemplateBindings().add(symbol_712);
		}
		symbol_199.getSuperClasses().add(symbol_146); // $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_199);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[String]
		//
		symbol_200.setName("NonUniqueCollection");
		//symbol_200.setMoniker("$ocl!NonUniqueCollection[String]");
		symbol_200.setElementType(symbol_123);
		symbol_200.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_69);	
				symbol_715.setActual(symbol_123);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_200.getTemplateBindings().add(symbol_714);
		}
		symbol_200.getSuperClasses().add(symbol_154); // $ocl!Collection[String]
		symbol_130.getOwnedTypes().add(symbol_200);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_201.setName("NonUniqueCollection");
		//symbol_201.setMoniker("$ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]");
		symbol_201.setElementType(symbol_60);
		symbol_201.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_69);	
				symbol_717.setActual(symbol_60);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_201.getTemplateBindings().add(symbol_716);
		}
		symbol_201.getSuperClasses().add(symbol_165); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_201);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_202.setName("NonUniqueCollection");
		//symbol_202.setMoniker("$ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_202.setElementType(symbol_18);
		symbol_202.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_69);	
				symbol_719.setActual(symbol_18);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_202.getTemplateBindings().add(symbol_718);
		}
		symbol_202.getSuperClasses().add(symbol_144); // $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_202);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_203.setName("NonUniqueCollection");
		//symbol_203.setMoniker("$ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_203.setElementType(symbol_115);
		symbol_203.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_69);	
				symbol_721.setActual(symbol_115);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_203.getTemplateBindings().add(symbol_720);
		}
		symbol_203.getSuperClasses().add(symbol_150); // $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_203);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		//
		symbol_204.setName("NonUniqueCollection");
		//symbol_204.setMoniker("$ocl!NonUniqueCollection[$ocl!Sequence{T}?T]");
		symbol_204.setElementType(symbol_112);
		symbol_204.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_69);	
				symbol_723.setActual(symbol_112);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_204.getTemplateBindings().add(symbol_722);
		}
		symbol_204.getSuperClasses().add(symbol_167); // $ocl!Collection[$ocl!Sequence{T}?T]
		symbol_130.getOwnedTypes().add(symbol_204);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		//
		symbol_205.setName("NonUniqueCollection");
		//symbol_205.setMoniker("$ocl!NonUniqueCollection[$ocl!Collection{T}?T]");
		symbol_205.setElementType(symbol_33);
		symbol_205.setUnspecializedElement(symbol_67);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_68);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_69);	
				symbol_725.setActual(symbol_33);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_205.getTemplateBindings().add(symbol_724);
		}
		symbol_205.getSuperClasses().add(symbol_30); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_205);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_206.setName("OrderedCollection");
		//symbol_206.setMoniker("$ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_206.setElementType(symbol_94);
		symbol_206.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_726 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_726.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_727 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_727.setFormal(symbol_90);	
				symbol_727.setActual(symbol_94);	
				symbol_726.getParameterSubstitutions().add(symbol_727);
			}
			symbol_206.getTemplateBindings().add(symbol_726);
		}
		symbol_206.getSuperClasses().add(symbol_146); // $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_206);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]
		//
		symbol_207.setName("OrderedCollection");
		//symbol_207.setMoniker("$ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]");
		symbol_207.setElementType(symbol_91);
		symbol_207.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_728 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_728.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_729 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_729.setFormal(symbol_90);	
				symbol_729.setActual(symbol_91);	
				symbol_728.getParameterSubstitutions().add(symbol_729);
			}
			symbol_207.getTemplateBindings().add(symbol_728);
		}
		symbol_207.getSuperClasses().add(symbol_151); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_207);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		//
		symbol_208.setName("OrderedCollection");
		//symbol_208.setMoniker("$ocl!OrderedCollection[$ocl!OrderedSet{T}?T]");
		symbol_208.setElementType(symbol_101);
		symbol_208.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_730 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_730.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_731 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_731.setFormal(symbol_90);	
				symbol_731.setActual(symbol_101);	
				symbol_730.getParameterSubstitutions().add(symbol_731);
			}
			symbol_208.getTemplateBindings().add(symbol_730);
		}
		symbol_208.getSuperClasses().add(symbol_163); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_208);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[String]
		//
		symbol_209.setName("OrderedCollection");
		//symbol_209.setMoniker("$ocl!OrderedCollection[String]");
		symbol_209.setElementType(symbol_123);
		symbol_209.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_732 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_732.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_733 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_733.setFormal(symbol_90);	
				symbol_733.setActual(symbol_123);	
				symbol_732.getParameterSubstitutions().add(symbol_733);
			}
			symbol_209.getTemplateBindings().add(symbol_732);
		}
		symbol_209.getSuperClasses().add(symbol_154); // $ocl!Collection[String]
		symbol_130.getOwnedTypes().add(symbol_209);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_210.setName("OrderedCollection");
		//symbol_210.setMoniker("$ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_210.setElementType(symbol_115);
		symbol_210.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_734 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_734.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_735 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_735.setFormal(symbol_90);	
				symbol_735.setActual(symbol_115);	
				symbol_734.getParameterSubstitutions().add(symbol_735);
			}
			symbol_210.getTemplateBindings().add(symbol_734);
		}
		symbol_210.getSuperClasses().add(symbol_150); // $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_210);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		//
		symbol_211.setName("OrderedCollection");
		//symbol_211.setMoniker("$ocl!OrderedCollection[$ocl!Sequence{T}?T]");
		symbol_211.setElementType(symbol_112);
		symbol_211.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_736 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_736.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_737 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_737.setFormal(symbol_90);	
				symbol_737.setActual(symbol_112);	
				symbol_736.getParameterSubstitutions().add(symbol_737);
			}
			symbol_211.getTemplateBindings().add(symbol_736);
		}
		symbol_211.getSuperClasses().add(symbol_167); // $ocl!Collection[$ocl!Sequence{T}?T]
		symbol_130.getOwnedTypes().add(symbol_211);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!Collection{T}?T]
		//
		symbol_212.setName("OrderedCollection");
		//symbol_212.setMoniker("$ocl!OrderedCollection[$ocl!Collection{T}?T]");
		symbol_212.setElementType(symbol_33);
		symbol_212.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_738 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_738.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_739 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_739.setFormal(symbol_90);	
				symbol_739.setActual(symbol_33);	
				symbol_738.getParameterSubstitutions().add(symbol_739);
			}
			symbol_212.getTemplateBindings().add(symbol_738);
		}
		symbol_212.getSuperClasses().add(symbol_30); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_212);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]
		//
		symbol_213.setName("OrderedCollection");
		//symbol_213.setMoniker("$ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]");
		symbol_213.setElementType(symbol_128);
		symbol_213.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_740 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_740.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_741 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_741.setFormal(symbol_90);	
				symbol_741.setActual(symbol_128);	
				symbol_740.getParameterSubstitutions().add(symbol_741);
			}
			symbol_213.getTemplateBindings().add(symbol_740);
		}
		symbol_213.getSuperClasses().add(symbol_148); // $ocl!Collection[$ocl!UniqueCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_213);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]
		//
		symbol_214.setName("OrderedCollection");
		//symbol_214.setMoniker("$ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]");
		symbol_214.setElementType(symbol_70);
		symbol_214.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_742 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_742.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_743 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_743.setFormal(symbol_90);	
				symbol_743.setActual(symbol_70);	
				symbol_742.getParameterSubstitutions().add(symbol_743);
			}
			symbol_214.getTemplateBindings().add(symbol_742);
		}
		symbol_214.getSuperClasses().add(symbol_153); // $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_214);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_215.setName("OrderedCollection");
		//symbol_215.setMoniker("$ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_215.setElementType(symbol_104);
		symbol_215.setUnspecializedElement(symbol_88);
		{
			TemplateBinding symbol_744 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_744.setSignature(symbol_89);
			{
				TemplateParameterSubstitution symbol_745 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_745.setFormal(symbol_90);	
				symbol_745.setActual(symbol_104);	
				symbol_744.getParameterSubstitutions().add(symbol_745);
			}
			symbol_215.getTemplateBindings().add(symbol_744);
		}
		symbol_215.getSuperClasses().add(symbol_145); // $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_215);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!UniqueCollection{T}?T]
		//
		symbol_216.setName("OrderedSet");
		//symbol_216.setMoniker("$ocl!OrderedSet[$ocl!UniqueCollection{T}?T]");
		symbol_216.setElementType(symbol_128);
		symbol_216.setUnspecializedElement(symbol_98);
		{
			TemplateBinding symbol_746 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_746.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_747 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_747.setFormal(symbol_100);	
				symbol_747.setActual(symbol_128);	
				symbol_746.getParameterSubstitutions().add(symbol_747);
			}
			symbol_216.getTemplateBindings().add(symbol_746);
		}
		symbol_216.getSuperClasses().add(symbol_213); // $ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]
		symbol_216.getSuperClasses().add(symbol_125); // $ocl!UniqueCollection{T}
		symbol_130.getOwnedTypes().add(symbol_216);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_217.setName("OrderedSet");
		//symbol_217.setMoniker("$ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_217.setElementType(symbol_104);
		symbol_217.setUnspecializedElement(symbol_98);
		{
			TemplateBinding symbol_748 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_748.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_749 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_749.setFormal(symbol_100);	
				symbol_749.setActual(symbol_104);	
				symbol_748.getParameterSubstitutions().add(symbol_749);
			}
			symbol_217.getTemplateBindings().add(symbol_748);
		}
		symbol_217.getSuperClasses().add(symbol_240); // $ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_217.getSuperClasses().add(symbol_215); // $ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_217);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!Collection{T}?T]
		//
		symbol_218.setName("OrderedSet");
		//symbol_218.setMoniker("$ocl!OrderedSet[$ocl!Collection{T}?T]");
		symbol_218.setElementType(symbol_33);
		symbol_218.setUnspecializedElement(symbol_98);
		{
			TemplateBinding symbol_750 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_750.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_751 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_751.setFormal(symbol_100);	
				symbol_751.setActual(symbol_33);	
				symbol_750.getParameterSubstitutions().add(symbol_751);
			}
			symbol_218.getTemplateBindings().add(symbol_750);
		}
		symbol_218.getSuperClasses().add(symbol_241); // $ocl!UniqueCollection[$ocl!Collection{T}?T]
		symbol_218.getSuperClasses().add(symbol_212); // $ocl!OrderedCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_218);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!OrderedCollection{T}?T]
		//
		symbol_219.setName("OrderedSet");
		//symbol_219.setMoniker("$ocl!OrderedSet[$ocl!OrderedCollection{T}?T]");
		symbol_219.setElementType(symbol_91);
		symbol_219.setUnspecializedElement(symbol_98);
		{
			TemplateBinding symbol_752 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_752.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_753 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_753.setFormal(symbol_100);	
				symbol_753.setActual(symbol_91);	
				symbol_752.getParameterSubstitutions().add(symbol_753);
			}
			symbol_219.getTemplateBindings().add(symbol_752);
		}
		symbol_219.getSuperClasses().add(symbol_88); // $ocl!OrderedCollection{T}
		symbol_219.getSuperClasses().add(symbol_248); // $ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_219);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
		//
		symbol_220.setName("OrderedSet");
		//symbol_220.setMoniker("$ocl!OrderedSet[$ocl!OrderedSet{T}?T]");
		symbol_220.setElementType(symbol_101);
		symbol_220.setUnspecializedElement(symbol_98);
		{
			TemplateBinding symbol_754 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_754.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_755 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_755.setFormal(symbol_100);	
				symbol_755.setActual(symbol_101);	
				symbol_754.getParameterSubstitutions().add(symbol_755);
			}
			symbol_220.getTemplateBindings().add(symbol_754);
		}
		symbol_220.getSuperClasses().add(symbol_243); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		symbol_220.getSuperClasses().add(symbol_208); // $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_220);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!NonUniqueCollection{T}?T]
		//
		symbol_221.setName("Sequence");
		//symbol_221.setMoniker("$ocl!Sequence[$ocl!NonUniqueCollection{T}?T]");
		symbol_221.setElementType(symbol_70);
		symbol_221.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_756 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_756.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_757 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_757.setFormal(symbol_111);	
				symbol_757.setActual(symbol_70);	
				symbol_756.getParameterSubstitutions().add(symbol_757);
			}
			symbol_221.getTemplateBindings().add(symbol_756);
		}
		symbol_221.getSuperClasses().add(symbol_214); // $ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]
		symbol_221.getSuperClasses().add(symbol_67); // $ocl!NonUniqueCollection{T}
		symbol_130.getOwnedTypes().add(symbol_221);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_222.setName("Sequence");
		//symbol_222.setMoniker("$ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_222.setElementType(symbol_115);
		symbol_222.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_758 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_758.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_759 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_759.setFormal(symbol_111);	
				symbol_759.setActual(symbol_115);	
				symbol_758.getParameterSubstitutions().add(symbol_759);
			}
			symbol_222.getTemplateBindings().add(symbol_758);
		}
		symbol_222.getSuperClasses().add(symbol_203); // $ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_222.getSuperClasses().add(symbol_210); // $ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_222);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!Sequence{T}?T]
		//
		symbol_223.setName("Sequence");
		//symbol_223.setMoniker("$ocl!Sequence[$ocl!Sequence{T}?T]");
		symbol_223.setElementType(symbol_112);
		symbol_223.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_760 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_760.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_761 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_761.setFormal(symbol_111);	
				symbol_761.setActual(symbol_112);	
				symbol_760.getParameterSubstitutions().add(symbol_761);
			}
			symbol_223.getTemplateBindings().add(symbol_760);
		}
		symbol_223.getSuperClasses().add(symbol_204); // $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		symbol_223.getSuperClasses().add(symbol_211); // $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		symbol_130.getOwnedTypes().add(symbol_223);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!OrderedCollection{T}?T]
		//
		symbol_224.setName("Sequence");
		//symbol_224.setMoniker("$ocl!Sequence[$ocl!OrderedCollection{T}?T]");
		symbol_224.setElementType(symbol_91);
		symbol_224.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_762 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_762.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_763 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_763.setFormal(symbol_111);	
				symbol_763.setActual(symbol_91);	
				symbol_762.getParameterSubstitutions().add(symbol_763);
			}
			symbol_224.getTemplateBindings().add(symbol_762);
		}
		symbol_224.getSuperClasses().add(symbol_88); // $ocl!OrderedCollection{T}
		symbol_224.getSuperClasses().add(symbol_196); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_224);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_225.setName("Sequence");
		//symbol_225.setMoniker("$ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_225.setElementType(symbol_94);
		symbol_225.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_764 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_764.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_765 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_765.setFormal(symbol_111);	
				symbol_765.setActual(symbol_94);	
				symbol_764.getParameterSubstitutions().add(symbol_765);
			}
			symbol_225.getTemplateBindings().add(symbol_764);
		}
		symbol_225.getSuperClasses().add(symbol_206); // $ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_225.getSuperClasses().add(symbol_199); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_225);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!Collection{T}?T]
		//
		symbol_226.setName("Sequence");
		//symbol_226.setMoniker("$ocl!Sequence[$ocl!Collection{T}?T]");
		symbol_226.setElementType(symbol_33);
		symbol_226.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_766 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_766.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_767 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_767.setFormal(symbol_111);	
				symbol_767.setActual(symbol_33);	
				symbol_766.getParameterSubstitutions().add(symbol_767);
			}
			symbol_226.getTemplateBindings().add(symbol_766);
		}
		symbol_226.getSuperClasses().add(symbol_212); // $ocl!OrderedCollection[$ocl!Collection{T}?T]
		symbol_226.getSuperClasses().add(symbol_205); // $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_226);
		//
		// ocl::$$::Sequence $ocl!Sequence[String]
		//
		symbol_227.setName("Sequence");
		//symbol_227.setMoniker("$ocl!Sequence[String]");
		symbol_227.setElementType(symbol_123);
		symbol_227.setUnspecializedElement(symbol_109);
		{
			TemplateBinding symbol_768 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_768.setSignature(symbol_110);
			{
				TemplateParameterSubstitution symbol_769 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_769.setFormal(symbol_111);	
				symbol_769.setActual(symbol_123);	
				symbol_768.getParameterSubstitutions().add(symbol_769);
			}
			symbol_227.getTemplateBindings().add(symbol_768);
		}
		symbol_227.getSuperClasses().add(symbol_200); // $ocl!NonUniqueCollection[String]
		symbol_227.getSuperClasses().add(symbol_209); // $ocl!OrderedCollection[String]
		symbol_130.getOwnedTypes().add(symbol_227);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_228.setName("Set");
		//symbol_228.setMoniker("$ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_228.setElementType(symbol_122);
		symbol_228.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_770 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_770.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_771 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_771.setFormal(symbol_118);	
				symbol_771.setActual(symbol_122);	
				symbol_770.getParameterSubstitutions().add(symbol_771);
			}
			symbol_228.getTemplateBindings().add(symbol_770);
		}
		symbol_228.getSuperClasses().add(symbol_249); // $ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_228.getSuperClasses().add(symbol_190); // $ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_228);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Collection{T}?T]
		//
		symbol_229.setName("Set");
		//symbol_229.setMoniker("$ocl!Set[$ocl!Collection{T}?T]");
		symbol_229.setElementType(symbol_33);
		symbol_229.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_772 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_772.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_773 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_773.setFormal(symbol_118);	
				symbol_773.setActual(symbol_33);	
				symbol_772.getParameterSubstitutions().add(symbol_773);
			}
			symbol_229.getTemplateBindings().add(symbol_772);
		}
		symbol_229.getSuperClasses().add(symbol_186); // $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		symbol_229.getSuperClasses().add(symbol_241); // $ocl!UniqueCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_229);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_230.setName("Set");
		//symbol_230.setMoniker("$ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_230.setElementType(symbol_142);
		symbol_230.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_774 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_774.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_775 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_775.setFormal(symbol_118);	
				symbol_775.setActual(symbol_142);	
				symbol_774.getParameterSubstitutions().add(symbol_775);
			}
			symbol_230.getTemplateBindings().add(symbol_774);
		}
		symbol_230.getSuperClasses().add(symbol_185); // $ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_230.getSuperClasses().add(symbol_247); // $ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_130.getOwnedTypes().add(symbol_230);
		//
		// ocl::$$::Set $ocl!Set[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_231.setName("Set");
		//symbol_231.setMoniker("$ocl!Set[$ocl!NonOrderedCollection{T}?T]");
		symbol_231.setElementType(symbol_60);
		symbol_231.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_776 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_776.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_777 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_777.setFormal(symbol_118);	
				symbol_777.setActual(symbol_60);	
				symbol_776.getParameterSubstitutions().add(symbol_777);
			}
			symbol_231.getTemplateBindings().add(symbol_776);
		}
		symbol_231.getSuperClasses().add(symbol_57); // $ocl!NonOrderedCollection{T}
		symbol_231.getSuperClasses().add(symbol_244); // $ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_231);
		//
		// ocl::$$::Set $ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_232.setName("Set");
		//symbol_232.setMoniker("$ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_232.setElementType(symbol_237);
		symbol_232.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_778 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_778.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_779 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_779.setFormal(symbol_118);	
				symbol_779.setActual(symbol_237);	
				symbol_778.getParameterSubstitutions().add(symbol_779);
			}
			symbol_232.getTemplateBindings().add(symbol_778);
		}
		symbol_232.getSuperClasses().add(symbol_242); // $ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_232.getSuperClasses().add(symbol_188); // $ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_130.getOwnedTypes().add(symbol_232);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Set{T}?T]
		//
		symbol_233.setName("Set");
		//symbol_233.setMoniker("$ocl!Set[$ocl!Set{T}?T]");
		symbol_233.setElementType(symbol_119);
		symbol_233.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_780 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_780.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_781 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_781.setFormal(symbol_118);	
				symbol_781.setActual(symbol_119);	
				symbol_780.getParameterSubstitutions().add(symbol_781);
			}
			symbol_233.getTemplateBindings().add(symbol_780);
		}
		symbol_233.getSuperClasses().add(symbol_195); // $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		symbol_233.getSuperClasses().add(symbol_250); // $ocl!UniqueCollection[$ocl!Set{T}?T]
		symbol_130.getOwnedTypes().add(symbol_233);
		//
		// ocl::$$::Set $ocl!Set[$ocl!OclAny]
		//
		symbol_234.setName("Set");
		//symbol_234.setMoniker("$ocl!Set[$ocl!OclAny]");
		symbol_234.setElementType(symbol_71);
		symbol_234.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_782 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_782.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_783 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_783.setFormal(symbol_118);	
				symbol_783.setActual(symbol_71);	
				symbol_782.getParameterSubstitutions().add(symbol_783);
			}
			symbol_234.getTemplateBindings().add(symbol_782);
		}
		symbol_234.getSuperClasses().add(symbol_245); // $ocl!UniqueCollection[$ocl!OclAny]
		symbol_234.getSuperClasses().add(symbol_189); // $ocl!NonOrderedCollection[$ocl!OclAny]
		symbol_130.getOwnedTypes().add(symbol_234);
		//
		// ocl::$$::Set $ocl!Set[$ocl!OclSelf]
		//
		symbol_235.setName("Set");
		//symbol_235.setMoniker("$ocl!Set[$ocl!OclSelf]");
		symbol_235.setElementType(symbol_84);
		symbol_235.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_784 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_784.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_785 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_785.setFormal(symbol_118);	
				symbol_785.setActual(symbol_84);	
				symbol_784.getParameterSubstitutions().add(symbol_785);
			}
			symbol_235.getTemplateBindings().add(symbol_784);
		}
		symbol_235.getSuperClasses().add(symbol_246); // $ocl!UniqueCollection[$ocl!OclSelf]
		symbol_235.getSuperClasses().add(symbol_192); // $ocl!NonOrderedCollection[$ocl!OclSelf]
		symbol_130.getOwnedTypes().add(symbol_235);
		//
		// ocl::$$::Set $ocl!Set[$ocl!OrderedSet{T}?T]
		//
		symbol_236.setName("Set");
		//symbol_236.setMoniker("$ocl!Set[$ocl!OrderedSet{T}?T]");
		symbol_236.setElementType(symbol_101);
		symbol_236.setUnspecializedElement(symbol_116);
		{
			TemplateBinding symbol_786 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_786.setSignature(symbol_117);
			{
				TemplateParameterSubstitution symbol_787 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_787.setFormal(symbol_118);	
				symbol_787.setActual(symbol_101);	
				symbol_786.getParameterSubstitutions().add(symbol_787);
			}
			symbol_236.getTemplateBindings().add(symbol_786);
		}
		symbol_236.getSuperClasses().add(symbol_243); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		symbol_236.getSuperClasses().add(symbol_193); // $ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_236);
		//
		// ocl::$$::Tuple Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}
		//
		symbol_237.setName("Tuple");
		//symbol_237.setMoniker("Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}");
		symbol_237.getSuperClasses().add(symbol_124); // $ocl!Tuple
		{ // ocl::$$::Tuple::first Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!first
			symbol_238.setName("first");
			symbol_238.setType(symbol_33);  // $ocl!Collection{T}?T
			
			symbol_238.setIsResolveProxies(true);
			symbol_237.getOwnedAttributes().add(symbol_238);
		}
		{ // ocl::$$::Tuple::second Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!second
			symbol_239.setName("second");
			symbol_239.setType(symbol_54);  // $ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2
			
			symbol_239.setIsResolveProxies(true);
			symbol_237.getOwnedAttributes().add(symbol_239);
		}
		symbol_130.getOwnedTypes().add(symbol_237);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_240.setName("UniqueCollection");
		//symbol_240.setMoniker("$ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_240.setElementType(symbol_104);
		symbol_240.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_788 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_788.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_789 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_789.setFormal(symbol_127);	
				symbol_789.setActual(symbol_104);	
				symbol_788.getParameterSubstitutions().add(symbol_789);
			}
			symbol_240.getTemplateBindings().add(symbol_788);
		}
		symbol_240.getSuperClasses().add(symbol_145); // $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_240);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Collection{T}?T]
		//
		symbol_241.setName("UniqueCollection");
		//symbol_241.setMoniker("$ocl!UniqueCollection[$ocl!Collection{T}?T]");
		symbol_241.setElementType(symbol_33);
		symbol_241.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_790 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_790.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_791 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_791.setFormal(symbol_127);	
				symbol_791.setActual(symbol_33);	
				symbol_790.getParameterSubstitutions().add(symbol_791);
			}
			symbol_241.getTemplateBindings().add(symbol_790);
		}
		symbol_241.getSuperClasses().add(symbol_30); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_241);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_242.setName("UniqueCollection");
		//symbol_242.setMoniker("$ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_242.setElementType(symbol_237);
		symbol_242.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_792 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_792.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_793 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_793.setFormal(symbol_127);	
				symbol_793.setActual(symbol_237);	
				symbol_792.getParameterSubstitutions().add(symbol_793);
			}
			symbol_242.getTemplateBindings().add(symbol_792);
		}
		symbol_242.getSuperClasses().add(symbol_164); // $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_130.getOwnedTypes().add(symbol_242);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		//
		symbol_243.setName("UniqueCollection");
		//symbol_243.setMoniker("$ocl!UniqueCollection[$ocl!OrderedSet{T}?T]");
		symbol_243.setElementType(symbol_101);
		symbol_243.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_794 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_794.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_795 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_795.setFormal(symbol_127);	
				symbol_795.setActual(symbol_101);	
				symbol_794.getParameterSubstitutions().add(symbol_795);
			}
			symbol_243.getTemplateBindings().add(symbol_794);
		}
		symbol_243.getSuperClasses().add(symbol_163); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_243);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_244.setName("UniqueCollection");
		//symbol_244.setMoniker("$ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]");
		symbol_244.setElementType(symbol_60);
		symbol_244.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_796 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_796.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_797 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_797.setFormal(symbol_127);	
				symbol_797.setActual(symbol_60);	
				symbol_796.getParameterSubstitutions().add(symbol_797);
			}
			symbol_244.getTemplateBindings().add(symbol_796);
		}
		symbol_244.getSuperClasses().add(symbol_165); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_244);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OclAny]
		//
		symbol_245.setName("UniqueCollection");
		//symbol_245.setMoniker("$ocl!UniqueCollection[$ocl!OclAny]");
		symbol_245.setElementType(symbol_71);
		symbol_245.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_798 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_798.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_799 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_799.setFormal(symbol_127);	
				symbol_799.setActual(symbol_71);	
				symbol_798.getParameterSubstitutions().add(symbol_799);
			}
			symbol_245.getTemplateBindings().add(symbol_798);
		}
		symbol_245.getSuperClasses().add(symbol_160); // $ocl!Collection[$ocl!OclAny]
		symbol_130.getOwnedTypes().add(symbol_245);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OclSelf]
		//
		symbol_246.setName("UniqueCollection");
		//symbol_246.setMoniker("$ocl!UniqueCollection[$ocl!OclSelf]");
		symbol_246.setElementType(symbol_84);
		symbol_246.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_800 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_800.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_801 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_801.setFormal(symbol_127);	
				symbol_801.setActual(symbol_84);	
				symbol_800.getParameterSubstitutions().add(symbol_801);
			}
			symbol_246.getTemplateBindings().add(symbol_800);
		}
		symbol_246.getSuperClasses().add(symbol_155); // $ocl!Collection[$ocl!OclSelf]
		symbol_130.getOwnedTypes().add(symbol_246);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_247.setName("UniqueCollection");
		//symbol_247.setMoniker("$ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_247.setElementType(symbol_142);
		symbol_247.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_802 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_802.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_803 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_803.setFormal(symbol_127);	
				symbol_803.setActual(symbol_142);	
				symbol_802.getParameterSubstitutions().add(symbol_803);
			}
			symbol_247.getTemplateBindings().add(symbol_802);
		}
		symbol_247.getSuperClasses().add(symbol_147); // $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_130.getOwnedTypes().add(symbol_247);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]
		//
		symbol_248.setName("UniqueCollection");
		//symbol_248.setMoniker("$ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]");
		symbol_248.setElementType(symbol_91);
		symbol_248.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_804 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_804.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_805 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_805.setFormal(symbol_127);	
				symbol_805.setActual(symbol_91);	
				symbol_804.getParameterSubstitutions().add(symbol_805);
			}
			symbol_248.getTemplateBindings().add(symbol_804);
		}
		symbol_248.getSuperClasses().add(symbol_151); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_248);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_249.setName("UniqueCollection");
		//symbol_249.setMoniker("$ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_249.setElementType(symbol_122);
		symbol_249.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_806 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_806.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_807 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_807.setFormal(symbol_127);	
				symbol_807.setActual(symbol_122);	
				symbol_806.getParameterSubstitutions().add(symbol_807);
			}
			symbol_249.getTemplateBindings().add(symbol_806);
		}
		symbol_249.getSuperClasses().add(symbol_159); // $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_249);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Set{T}?T]
		//
		symbol_250.setName("UniqueCollection");
		//symbol_250.setMoniker("$ocl!UniqueCollection[$ocl!Set{T}?T]");
		symbol_250.setElementType(symbol_119);
		symbol_250.setUnspecializedElement(symbol_125);
		{
			TemplateBinding symbol_808 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_808.setSignature(symbol_126);
			{
				TemplateParameterSubstitution symbol_809 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_809.setFormal(symbol_127);	
				symbol_809.setActual(symbol_119);	
				symbol_808.getParameterSubstitutions().add(symbol_809);
			}
			symbol_250.getTemplateBindings().add(symbol_808);
		}
		symbol_250.getSuperClasses().add(symbol_152); // $ocl!Collection[$ocl!Set{T}?T]
		symbol_130.getOwnedTypes().add(symbol_250);
		symbol_1.getNestedPackages().add(symbol_130);
		return symbol_1;
	}
}
