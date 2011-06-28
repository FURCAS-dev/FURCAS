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
		
		
		ClassifierType symbol_19 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier{T}
		TemplateSignature symbol_20 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Classifier{T}!
		TypeTemplateParameter symbol_21 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_22 = PivotFactory.eINSTANCE.createClass(); // $ocl!Classifier{T}?T
		
		TemplateSignature symbol_23 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Classifier{T}!oclContainer{U}()!
		TypeTemplateParameter symbol_24 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_25 = PivotFactory.eINSTANCE.createClass(); // $ocl!Classifier{T}!oclContainer{U}()?U
		
		TemplateSignature symbol_26 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Classifier{T}!oclContents{U}()!
		TypeTemplateParameter symbol_27 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_28 = PivotFactory.eINSTANCE.createClass(); // $ocl!Classifier{T}!oclContents{U}()?U
		
		
		CollectionType symbol_29 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection{T}
		TemplateSignature symbol_30 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!
		TypeTemplateParameter symbol_31 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_32 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}?T
		
		TemplateSignature symbol_33 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_34 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_35 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_36 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_37 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_38 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_39 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])!
		TypeTemplateParameter symbol_40 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_41 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2
		
		TemplateSignature symbol_42 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_43 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_44 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_45 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])!
		TypeTemplateParameter symbol_46 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_47 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2
		
		TemplateSignature symbol_48 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_49 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_50 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_51 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Collection{T}!product{T2}($ocl!Collection[T2])!
		TypeTemplateParameter symbol_52 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_53 = PivotFactory.eINSTANCE.createClass(); // $ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2
		
		
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // $ocl!Enumeration
		
		CollectionType symbol_55 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection{T}
		TemplateSignature symbol_56 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_57 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_59 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_60 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_61 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_62 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_63 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_64 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_65 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection{T}
		TemplateSignature symbol_66 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_67 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_68 = PivotFactory.eINSTANCE.createClass(); // $ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_69 = PivotFactory.eINSTANCE.createAnyType(); // $ocl!OclAny
		TemplateSignature symbol_70 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])!
		TypeTemplateParameter symbol_71 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_72 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT
		
		TemplateSignature symbol_73 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])!
		TypeTemplateParameter symbol_74 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_75 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T
		
		TemplateSignature symbol_76 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])!
		TypeTemplateParameter symbol_77 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_78 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T
		
		
		InvalidType symbol_79 = PivotFactory.eINSTANCE.createInvalidType(); // $ocl!OclInvalid
		Property symbol_80 = PivotFactory.eINSTANCE.createProperty(); // ocl::OclInvalid::oclBadProperty $ocl!OclInvalid!oclBadProperty
		
		Class symbol_81 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclMessage
		
		SelfType symbol_82 = PivotFactory.eINSTANCE.createSelfType(); // $ocl!OclSelf
		
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclState
		
		Class symbol_84 = PivotFactory.eINSTANCE.createClass(); // $ocl!OclTuple
		
		VoidType symbol_85 = PivotFactory.eINSTANCE.createVoidType(); // $ocl!OclVoid
		
		CollectionType symbol_86 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection{T}
		TemplateSignature symbol_87 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_88 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_90 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_91 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_92 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_93 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_94 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_95 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_96 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet{T}
		TemplateSignature symbol_97 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_98 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedSet{T}?T
		
		TemplateSignature symbol_100 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!OrderedSet{T}!flatten{T2}()!
		TypeTemplateParameter symbol_101 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_102 = PivotFactory.eINSTANCE.createClass(); // $ocl!OrderedSet{T}!flatten{T2}()?T2
		
		
		SequenceType symbol_103 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence{T}
		TemplateSignature symbol_104 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Sequence{T}!
		TypeTemplateParameter symbol_105 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_106 = PivotFactory.eINSTANCE.createClass(); // $ocl!Sequence{T}?T
		
		TemplateSignature symbol_107 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_108 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_109 = PivotFactory.eINSTANCE.createClass(); // $ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_110 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set{T}
		TemplateSignature symbol_111 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Set{T}!
		TypeTemplateParameter symbol_112 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_113 = PivotFactory.eINSTANCE.createClass(); // $ocl!Set{T}?T
		
		TemplateSignature symbol_114 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_115 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_116 = PivotFactory.eINSTANCE.createClass(); // $ocl!Set{T}!flatten{T2}()?T2
		
		
		TupleType symbol_117 = PivotFactory.eINSTANCE.createTupleType(); // $ocl!Tuple
		
		CollectionType symbol_118 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection{T}
		TemplateSignature symbol_119 = PivotFactory.eINSTANCE.createTemplateSignature(); // $ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_120 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_121 = PivotFactory.eINSTANCE.createClass(); // $ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_122 = PivotFactory.eINSTANCE.createPrimitiveType(); // Boolean
		
		PrimitiveType symbol_123 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		PrimitiveType symbol_124 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_125 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{TT}($ocl!Classifier[TT])!
		TypeTemplateParameter symbol_126 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_127 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{TT}($ocl!Classifier[TT])?TT
		
		
		PrimitiveType symbol_128 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		PrimitiveType symbol_129 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_130 = PivotFactory.eINSTANCE.createPackage(); // $$
		Class symbol_131 = PivotFactory.eINSTANCE.createClass(); // $$!$$
		
		BagType symbol_132 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]
		
		BagType symbol_133 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!Bag{T}?T]
		
		BagType symbol_134 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!Collection{T}?T]
		
		BagType symbol_135 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		BagType symbol_136 = PivotFactory.eINSTANCE.createBagType(); // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
		
		ClassifierType symbol_137 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]
		
		ClassifierType symbol_138 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]
		
		ClassifierType symbol_139 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]
		
		ClassifierType symbol_140 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]
		
		ClassifierType symbol_141 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]
		
		ClassifierType symbol_142 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[$ocl!OclSelf]
		
		ClassifierType symbol_143 = PivotFactory.eINSTANCE.createClassifierType(); // $ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Bag{T}?T]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Collection{T}?T]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OclAny]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OclSelf]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Sequence{T}?T]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!Set{T}?T]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[$ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[String]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!OclAny]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!OclSelf]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!NonUniqueCollection[String]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_193 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_194 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_195 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_196 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_197 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		
		CollectionType symbol_198 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_199 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!OrderedCollection[String]
		
		OrderedSetType symbol_200 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!Collection{T}?T]
		
		OrderedSetType symbol_201 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_202 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		OrderedSetType symbol_203 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_204 = PivotFactory.eINSTANCE.createOrderedSetType(); // $ocl!OrderedSet[$ocl!UniqueCollection{T}?T]
		
		SequenceType symbol_205 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!Collection{T}?T]
		
		SequenceType symbol_206 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_207 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_208 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_209 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_210 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[$ocl!Sequence{T}?T]
		
		SequenceType symbol_211 = PivotFactory.eINSTANCE.createSequenceType(); // $ocl!Sequence[String]
		
		SetType symbol_212 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		SetType symbol_213 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Collection{T}?T]
		
		SetType symbol_214 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_215 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!OclAny]
		
		SetType symbol_216 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!OclSelf]
		
		SetType symbol_217 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!OrderedSet{T}?T]
		
		SetType symbol_218 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_219 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[$ocl!Set{T}?T]
		
		SetType symbol_220 = PivotFactory.eINSTANCE.createSetType(); // $ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		CollectionType symbol_221 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_222 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Collection{T}?T]
		
		CollectionType symbol_223 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_224 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OclAny]
		
		CollectionType symbol_225 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OclSelf]
		
		CollectionType symbol_226 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_227 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_228 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		
		CollectionType symbol_229 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_230 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[$ocl!Set{T}?T]
		
		CollectionType symbol_231 = PivotFactory.eINSTANCE.createCollectionType(); // $ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		
		LambdaType symbol_232 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Bag{T}?T()Boolean
		
		LambdaType symbol_233 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_234 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_235 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()$ocl!OclAny
		
		LambdaType symbol_236 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Collection{T}?T()Boolean
		
		LambdaType symbol_237 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_238 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_239 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]
		
		LambdaType symbol_240 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny
		
		LambdaType symbol_241 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_242 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_243 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]
		
		LambdaType symbol_244 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!OrderedSet{T}?T()Boolean
		
		LambdaType symbol_245 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Sequence{T}?T()Boolean
		
		LambdaType symbol_246 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!Set{T}?T()Boolean
		
		LambdaType symbol_247 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny
		
		TupleType symbol_248 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}
		Property symbol_249 = PivotFactory.eINSTANCE.createProperty(); // ocl::$$::Tuple::first Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!first
		Property symbol_250 = PivotFactory.eINSTANCE.createProperty(); // ocl::$$::Tuple::second Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!second
		
		

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
		symbol_12.getSuperClasses().add(symbol_181); // $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_170); // $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		{	// ocl::Bag::<>() $ocl!Bag{T}!<>($ocl!OclSelf)
			Operation symbol_251 = PivotFactory.eINSTANCE.createOperation();
			symbol_251.setName("<>");
			//symbol_251.setMoniker("$ocl!Bag{T}!<>($ocl!OclSelf)");
			symbol_251.setType(symbol_122);  // Boolean
			
			Parameter symbol_252 = PivotFactory.eINSTANCE.createParameter();
			symbol_252.setName("object2");
			//symbol_252.setMoniker("$ocl!Bag{T}!<>($ocl!OclSelf)!object2");
			symbol_252.setType(symbol_82);  // $ocl!OclSelf
			
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
			symbol_253.setType(symbol_122);  // Boolean
			
			Parameter symbol_254 = PivotFactory.eINSTANCE.createParameter();
			symbol_254.setName("object2");
			//symbol_254.setMoniker("$ocl!Bag{T}!=($ocl!OclSelf)!object2");
			symbol_254.setType(symbol_82);  // $ocl!OclSelf
			
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
			symbol_255.setType(symbol_133);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_256 = PivotFactory.eINSTANCE.createParameter();
			symbol_256.setName("object");
			//symbol_256.setMoniker("$ocl!Bag{T}!excluding($ocl!OclAny)!object");
			symbol_256.setType(symbol_69);  // $ocl!OclAny
			
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
			symbol_257.setType(symbol_132);  // $ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]
			
			symbol_257.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_257.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_257);
		}
		{	// ocl::Bag::including() $ocl!Bag{T}!including(T)
			Operation symbol_258 = PivotFactory.eINSTANCE.createOperation();
			symbol_258.setName("including");
			//symbol_258.setMoniker("$ocl!Bag{T}!including(T)");
			symbol_258.setType(symbol_133);  // $ocl!Bag[$ocl!Bag{T}?T]
			
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
			symbol_260.setType(symbol_133);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_261 = PivotFactory.eINSTANCE.createParameter();
			symbol_261.setName("i");
			symbol_261.setType(symbol_15);  // $ocl!Bag{T}?T
			symbol_260.getOwnedIterators().add(symbol_261);
			Parameter symbol_262 = PivotFactory.eINSTANCE.createParameter();
			symbol_262.setName("body");
			//symbol_262.setMoniker("$ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_262.setType(symbol_232);  // Lambda~$ocl!Bag{T}?T()Boolean
			
			symbol_260.getOwnedParameters().add(symbol_262);
			symbol_260.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Bag::select() $ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_263 = PivotFactory.eINSTANCE.createIteration();
			symbol_263.setName("select");
			//symbol_263.setMoniker("$ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_263.setType(symbol_133);  // $ocl!Bag[$ocl!Bag{T}?T]
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("i");
			symbol_264.setType(symbol_15);  // $ocl!Bag{T}?T
			symbol_263.getOwnedIterators().add(symbol_264);
			Parameter symbol_265 = PivotFactory.eINSTANCE.createParameter();
			symbol_265.setName("body");
			//symbol_265.setMoniker("$ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_265.setType(symbol_232);  // Lambda~$ocl!Bag{T}?T()Boolean
			
			symbol_263.getOwnedParameters().add(symbol_265);
			symbol_263.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_263);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Classifier $ocl!Classifier{T}
		//
		symbol_19.setName("Classifier");
		//symbol_19.setMoniker("$ocl!Classifier{T}");
		symbol_19.setInstanceType(symbol_22);
		symbol_22.setName("T");
		symbol_21.setOwnedParameteredElement(symbol_22);
		symbol_20.getOwnedParameters().add(symbol_21);
		
		symbol_19.setOwnedTemplateSignature(symbol_20);
		symbol_19.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::Classifier::allInstances() $ocl!Classifier{T}!allInstances()
			Operation symbol_266 = PivotFactory.eINSTANCE.createOperation();
			symbol_266.setName("allInstances");
			//symbol_266.setMoniker("$ocl!Classifier{T}!allInstances()");
			symbol_266.setType(symbol_216);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_266.setIsStatic(true);
			symbol_266.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation");
			symbol_266.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_266);
		}
		{	// ocl::Classifier::oclContainer() $ocl!Classifier{T}!oclContainer{U}()
			Operation symbol_267 = PivotFactory.eINSTANCE.createOperation();
			symbol_25.setName("U");
			symbol_24.setOwnedParameteredElement(symbol_25);
			symbol_23.getOwnedParameters().add(symbol_24);
			
			symbol_267.setOwnedTemplateSignature(symbol_23);
			symbol_267.setName("oclContainer");
			//symbol_267.setMoniker("$ocl!Classifier{T}!oclContainer{U}()");
			symbol_267.setType(symbol_137);  // $ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]
			
			symbol_267.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation");
			symbol_267.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_267);
		}
		{	// ocl::Classifier::oclContents() $ocl!Classifier{T}!oclContents{U}()
			Operation symbol_268 = PivotFactory.eINSTANCE.createOperation();
			symbol_28.setName("U");
			symbol_27.setOwnedParameteredElement(symbol_28);
			symbol_26.getOwnedParameters().add(symbol_27);
			
			symbol_268.setOwnedTemplateSignature(symbol_26);
			symbol_268.setName("oclContents");
			//symbol_268.setMoniker("$ocl!Classifier{T}!oclContents{U}()");
			symbol_268.setType(symbol_212);  // $ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
			
			symbol_268.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation");
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_268);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Collection $ocl!Collection{T}
		//
		symbol_29.setName("Collection");
		//symbol_29.setMoniker("$ocl!Collection{T}");
		symbol_29.setElementType(symbol_32);
		symbol_32.setName("T");
		symbol_31.setOwnedParameteredElement(symbol_32);
		symbol_30.getOwnedParameters().add(symbol_31);
		
		symbol_29.setOwnedTemplateSignature(symbol_30);
		symbol_29.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::Collection::<>() $ocl!Collection{T}!<>($ocl!OclSelf)
			Operation symbol_269 = PivotFactory.eINSTANCE.createOperation();
			symbol_269.setName("<>");
			//symbol_269.setMoniker("$ocl!Collection{T}!<>($ocl!OclSelf)");
			symbol_269.setType(symbol_122);  // Boolean
			
			Parameter symbol_270 = PivotFactory.eINSTANCE.createParameter();
			symbol_270.setName("object2");
			//symbol_270.setMoniker("$ocl!Collection{T}!<>($ocl!OclSelf)!object2");
			symbol_270.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_269.getOwnedParameters().add(symbol_270);
			symbol_269.setPrecedence(symbol_7);
			symbol_269.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_269.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_269);
		}
		{	// ocl::Collection::=() $ocl!Collection{T}!=($ocl!OclSelf)
			Operation symbol_271 = PivotFactory.eINSTANCE.createOperation();
			symbol_271.setName("=");
			//symbol_271.setMoniker("$ocl!Collection{T}!=($ocl!OclSelf)");
			symbol_271.setType(symbol_122);  // Boolean
			
			Parameter symbol_272 = PivotFactory.eINSTANCE.createParameter();
			symbol_272.setName("object2");
			//symbol_272.setMoniker("$ocl!Collection{T}!=($ocl!OclSelf)!object2");
			symbol_272.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_271.getOwnedParameters().add(symbol_272);
			symbol_271.setPrecedence(symbol_7);
			symbol_271.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_271.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_271);
		}
		{	// ocl::Collection::any() $ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_273 = PivotFactory.eINSTANCE.createIteration();
			symbol_273.setName("any");
			//symbol_273.setMoniker("$ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_273.setType(symbol_32);  // $ocl!Collection{T}?T
			
			Parameter symbol_274 = PivotFactory.eINSTANCE.createParameter();
			symbol_274.setName("i");
			symbol_274.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_273.getOwnedIterators().add(symbol_274);
			Parameter symbol_275 = PivotFactory.eINSTANCE.createParameter();
			symbol_275.setName("body");
			//symbol_275.setMoniker("$ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_275.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_273.getOwnedParameters().add(symbol_275);
			symbol_273.setImplementationClass("org.eclipse.ocl.examples.library.iterator.AnyIteration");
			symbol_273.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_273);
		}
		{	// ocl::Collection::asBag() $ocl!Collection{T}!asBag()
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("asBag");
			//symbol_276.setMoniker("$ocl!Collection{T}!asBag()");
			symbol_276.setType(symbol_134);  // $ocl!Bag[$ocl!Collection{T}?T]
			
			symbol_276.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation");
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Collection::asOrderedSet() $ocl!Collection{T}!asOrderedSet()
			Operation symbol_277 = PivotFactory.eINSTANCE.createOperation();
			symbol_277.setName("asOrderedSet");
			//symbol_277.setMoniker("$ocl!Collection{T}!asOrderedSet()");
			symbol_277.setType(symbol_200);  // $ocl!OrderedSet[$ocl!Collection{T}?T]
			
			symbol_277.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation");
			symbol_277.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_277);
		}
		{	// ocl::Collection::asSequence() $ocl!Collection{T}!asSequence()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_278.setName("asSequence");
			//symbol_278.setMoniker("$ocl!Collection{T}!asSequence()");
			symbol_278.setType(symbol_205);  // $ocl!Sequence[$ocl!Collection{T}?T]
			
			symbol_278.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation");
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Collection::asSet() $ocl!Collection{T}!asSet()
			Operation symbol_279 = PivotFactory.eINSTANCE.createOperation();
			symbol_279.setName("asSet");
			//symbol_279.setMoniker("$ocl!Collection{T}!asSet()");
			symbol_279.setType(symbol_213);  // $ocl!Set[$ocl!Collection{T}?T]
			
			symbol_279.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation");
			symbol_279.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_279);
		}
		{	// ocl::Collection::collect() $ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_280 = PivotFactory.eINSTANCE.createIteration();
			symbol_35.setName("V");
			symbol_34.setOwnedParameteredElement(symbol_35);
			symbol_33.getOwnedParameters().add(symbol_34);
			
			symbol_280.setOwnedTemplateSignature(symbol_33);
			symbol_280.setName("collect");
			//symbol_280.setMoniker("$ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_280.setType(symbol_147);  // $ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_281 = PivotFactory.eINSTANCE.createParameter();
			symbol_281.setName("i");
			symbol_281.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_280.getOwnedIterators().add(symbol_281);
			Parameter symbol_282 = PivotFactory.eINSTANCE.createParameter();
			symbol_282.setName("body");
			//symbol_282.setMoniker("$ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_282.setType(symbol_234);  // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_280.getOwnedParameters().add(symbol_282);
			symbol_280.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_280.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_280);
		}
		{	// ocl::Collection::collectNested() $ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_283 = PivotFactory.eINSTANCE.createIteration();
			symbol_38.setName("V");
			symbol_37.setOwnedParameteredElement(symbol_38);
			symbol_36.getOwnedParameters().add(symbol_37);
			
			symbol_283.setOwnedTemplateSignature(symbol_36);
			symbol_283.setName("collectNested");
			//symbol_283.setMoniker("$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_283.setType(symbol_152);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_284 = PivotFactory.eINSTANCE.createParameter();
			symbol_284.setName("i");
			symbol_284.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_283.getOwnedIterators().add(symbol_284);
			Parameter symbol_285 = PivotFactory.eINSTANCE.createParameter();
			symbol_285.setName("body");
			//symbol_285.setMoniker("$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_285.setType(symbol_233);  // Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_283.getOwnedParameters().add(symbol_285);
			symbol_283.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_283.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_283);
		}
		{	// ocl::Collection::count() $ocl!Collection{T}!count($ocl!OclAny)
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_286.setName("count");
			//symbol_286.setMoniker("$ocl!Collection{T}!count($ocl!OclAny)");
			symbol_286.setType(symbol_123);  // Integer
			
			Parameter symbol_287 = PivotFactory.eINSTANCE.createParameter();
			symbol_287.setName("object");
			//symbol_287.setMoniker("$ocl!Collection{T}!count($ocl!OclAny)!object");
			symbol_287.setType(symbol_69);  // $ocl!OclAny
			
			symbol_286.getOwnedParameters().add(symbol_287);
			symbol_286.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionCountOperation");
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Collection::excludes() $ocl!Collection{T}!excludes($ocl!OclAny)
			Operation symbol_288 = PivotFactory.eINSTANCE.createOperation();
			symbol_288.setName("excludes");
			//symbol_288.setMoniker("$ocl!Collection{T}!excludes($ocl!OclAny)");
			symbol_288.setType(symbol_122);  // Boolean
			
			Parameter symbol_289 = PivotFactory.eINSTANCE.createParameter();
			symbol_289.setName("object");
			//symbol_289.setMoniker("$ocl!Collection{T}!excludes($ocl!OclAny)!object");
			symbol_289.setType(symbol_69);  // $ocl!OclAny
			
			symbol_288.getOwnedParameters().add(symbol_289);
			symbol_288.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation");
			symbol_288.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_288);
		}
		{	// ocl::Collection::excludesAll() $ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])
			Operation symbol_290 = PivotFactory.eINSTANCE.createOperation();
			symbol_41.setName("T2");
			symbol_40.setOwnedParameteredElement(symbol_41);
			symbol_39.getOwnedParameters().add(symbol_40);
			
			symbol_290.setOwnedTemplateSignature(symbol_39);
			symbol_290.setName("excludesAll");
			//symbol_290.setMoniker("$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])");
			symbol_290.setType(symbol_122);  // Boolean
			
			Parameter symbol_291 = PivotFactory.eINSTANCE.createParameter();
			symbol_291.setName("c2");
			//symbol_291.setMoniker("$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])!c2");
			symbol_291.setType(symbol_148);  // $ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]
			
			symbol_290.getOwnedParameters().add(symbol_291);
			symbol_290.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation");
			symbol_290.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_290);
		}
		{	// ocl::Collection::excluding() $ocl!Collection{T}!excluding($ocl!OclAny)
			Operation symbol_292 = PivotFactory.eINSTANCE.createOperation();
			symbol_292.setName("excluding");
			//symbol_292.setMoniker("$ocl!Collection{T}!excluding($ocl!OclAny)");
			symbol_292.setType(symbol_152);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_293 = PivotFactory.eINSTANCE.createParameter();
			symbol_293.setName("object");
			//symbol_293.setMoniker("$ocl!Collection{T}!excluding($ocl!OclAny)!object");
			symbol_293.setType(symbol_69);  // $ocl!OclAny
			
			symbol_292.getOwnedParameters().add(symbol_293);
			symbol_292.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_292.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_292);
		}
		{	// ocl::Collection::exists() $ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_294 = PivotFactory.eINSTANCE.createIteration();
			symbol_294.setName("exists");
			//symbol_294.setMoniker("$ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_294.setType(symbol_122);  // Boolean
			
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("i");
			symbol_295.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_294.getOwnedIterators().add(symbol_295);
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("body");
			//symbol_296.setMoniker("$ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_296.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_294.getOwnedParameters().add(symbol_296);
			symbol_294.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Collection::exists() $ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_297 = PivotFactory.eINSTANCE.createIteration();
			symbol_297.setName("exists");
			//symbol_297.setMoniker("$ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_297.setType(symbol_122);  // Boolean
			
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("i");
			symbol_298.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_297.getOwnedIterators().add(symbol_298);
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("j");
			symbol_299.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_297.getOwnedIterators().add(symbol_299);
			Parameter symbol_300 = PivotFactory.eINSTANCE.createParameter();
			symbol_300.setName("body");
			//symbol_300.setMoniker("$ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_300.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_297.getOwnedParameters().add(symbol_300);
			symbol_297.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_297);
		}
		{	// ocl::Collection::flatten() $ocl!Collection{T}!flatten{T2}()
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_44.setName("T2");
			symbol_43.setOwnedParameteredElement(symbol_44);
			symbol_42.getOwnedParameters().add(symbol_43);
			
			symbol_301.setOwnedTemplateSignature(symbol_42);
			symbol_301.setName("flatten");
			//symbol_301.setMoniker("$ocl!Collection{T}!flatten{T2}()");
			symbol_301.setType(symbol_149);  // $ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]
			
			symbol_301.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Collection::forAll() $ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_302 = PivotFactory.eINSTANCE.createIteration();
			symbol_302.setName("forAll");
			//symbol_302.setMoniker("$ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_302.setType(symbol_122);  // Boolean
			
			Parameter symbol_303 = PivotFactory.eINSTANCE.createParameter();
			symbol_303.setName("i");
			symbol_303.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_302.getOwnedIterators().add(symbol_303);
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("body");
			//symbol_304.setMoniker("$ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_304.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_302.getOwnedParameters().add(symbol_304);
			symbol_302.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Collection::forAll() $ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_305 = PivotFactory.eINSTANCE.createIteration();
			symbol_305.setName("forAll");
			//symbol_305.setMoniker("$ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_305.setType(symbol_122);  // Boolean
			
			Parameter symbol_306 = PivotFactory.eINSTANCE.createParameter();
			symbol_306.setName("i");
			symbol_306.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_305.getOwnedIterators().add(symbol_306);
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("j");
			symbol_307.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_305.getOwnedIterators().add(symbol_307);
			Parameter symbol_308 = PivotFactory.eINSTANCE.createParameter();
			symbol_308.setName("body");
			//symbol_308.setMoniker("$ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_308.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_305.getOwnedParameters().add(symbol_308);
			symbol_305.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_305.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_305);
		}
		{	// ocl::Collection::includes() $ocl!Collection{T}!includes($ocl!OclAny)
			Operation symbol_309 = PivotFactory.eINSTANCE.createOperation();
			symbol_309.setName("includes");
			//symbol_309.setMoniker("$ocl!Collection{T}!includes($ocl!OclAny)");
			symbol_309.setType(symbol_122);  // Boolean
			
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("object");
			//symbol_310.setMoniker("$ocl!Collection{T}!includes($ocl!OclAny)!object");
			symbol_310.setType(symbol_69);  // $ocl!OclAny
			
			symbol_309.getOwnedParameters().add(symbol_310);
			symbol_309.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation");
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Collection::includesAll() $ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_47.setName("T2");
			symbol_46.setOwnedParameteredElement(symbol_47);
			symbol_45.getOwnedParameters().add(symbol_46);
			
			symbol_311.setOwnedTemplateSignature(symbol_45);
			symbol_311.setName("includesAll");
			//symbol_311.setMoniker("$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])");
			symbol_311.setType(symbol_122);  // Boolean
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("c2");
			//symbol_312.setMoniker("$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])!c2");
			symbol_312.setType(symbol_150);  // $ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]
			
			symbol_311.getOwnedParameters().add(symbol_312);
			symbol_311.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation");
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Collection::including() $ocl!Collection{T}!including(T)
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_313.setName("including");
			//symbol_313.setMoniker("$ocl!Collection{T}!including(T)");
			symbol_313.setType(symbol_152);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_314 = PivotFactory.eINSTANCE.createParameter();
			symbol_314.setName("object");
			//symbol_314.setMoniker("$ocl!Collection{T}!including(T)!object");
			symbol_314.setType(symbol_32);  // $ocl!Collection{T}?T
			
			symbol_313.getOwnedParameters().add(symbol_314);
			symbol_313.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_313);
		}
		{	// ocl::Collection::isEmpty() $ocl!Collection{T}!isEmpty()
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_315.setName("isEmpty");
			//symbol_315.setMoniker("$ocl!Collection{T}!isEmpty()");
			symbol_315.setType(symbol_122);  // Boolean
			
			symbol_315.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation");
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Collection::isUnique() $ocl!Collection{T}!isUnique(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_316 = PivotFactory.eINSTANCE.createIteration();
			symbol_316.setName("isUnique");
			//symbol_316.setMoniker("$ocl!Collection{T}!isUnique(T|Lambda~T()$ocl!OclAny)");
			symbol_316.setType(symbol_122);  // Boolean
			
			Parameter symbol_317 = PivotFactory.eINSTANCE.createParameter();
			symbol_317.setName("i");
			symbol_317.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_316.getOwnedIterators().add(symbol_317);
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("body");
			//symbol_318.setMoniker("$ocl!Collection{T}!isUnique(T|Lambda~T()$ocl!OclAny)!body");
			symbol_318.setType(symbol_235);  // Lambda~$ocl!Collection{T}?T()$ocl!OclAny
			
			symbol_316.getOwnedParameters().add(symbol_318);
			symbol_316.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IsUniqueIteration");
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Collection::iterate() $ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_319 = PivotFactory.eINSTANCE.createIteration();
			symbol_50.setName("Tacc");
			symbol_49.setOwnedParameteredElement(symbol_50);
			symbol_48.getOwnedParameters().add(symbol_49);
			
			symbol_319.setOwnedTemplateSignature(symbol_48);
			symbol_319.setName("iterate");
			//symbol_319.setMoniker("$ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_319.setType(symbol_50);  // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_320 = PivotFactory.eINSTANCE.createParameter();
			symbol_320.setName("i");
			symbol_320.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_319.getOwnedIterators().add(symbol_320);
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("acc");
			symbol_321.setType(symbol_50);  // $ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_319.getOwnedAccumulators().add(symbol_321);
			symbol_319.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IterateIteration");
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_319);
		}
		{	// ocl::Collection::max() $ocl!Collection{T}!max()
			Operation symbol_322 = PivotFactory.eINSTANCE.createOperation();
			symbol_322.setName("max");
			//symbol_322.setMoniker("$ocl!Collection{T}!max()");
			symbol_322.setType(symbol_32);  // $ocl!Collection{T}?T
			
			symbol_322.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMaxOperation");
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::Collection::min() $ocl!Collection{T}!min()
			Operation symbol_323 = PivotFactory.eINSTANCE.createOperation();
			symbol_323.setName("min");
			//symbol_323.setMoniker("$ocl!Collection{T}!min()");
			symbol_323.setType(symbol_32);  // $ocl!Collection{T}?T
			
			symbol_323.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMinOperation");
			symbol_323.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_323);
		}
		{	// ocl::Collection::notEmpty() $ocl!Collection{T}!notEmpty()
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_324.setName("notEmpty");
			//symbol_324.setMoniker("$ocl!Collection{T}!notEmpty()");
			symbol_324.setType(symbol_122);  // Boolean
			
			symbol_324.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation");
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Collection::one() $ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_325 = PivotFactory.eINSTANCE.createIteration();
			symbol_325.setName("one");
			//symbol_325.setMoniker("$ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_325.setType(symbol_122);  // Boolean
			
			Parameter symbol_326 = PivotFactory.eINSTANCE.createParameter();
			symbol_326.setName("i");
			symbol_326.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_325.getOwnedIterators().add(symbol_326);
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("body");
			//symbol_327.setMoniker("$ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_327.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_325.getOwnedParameters().add(symbol_327);
			symbol_325.setImplementationClass("org.eclipse.ocl.examples.library.iterator.OneIteration");
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::Collection::product() $ocl!Collection{T}!product{T2}($ocl!Collection[T2])
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_53.setName("T2");
			symbol_52.setOwnedParameteredElement(symbol_53);
			symbol_51.getOwnedParameters().add(symbol_52);
			
			symbol_328.setOwnedTemplateSignature(symbol_51);
			symbol_328.setName("product");
			//symbol_328.setMoniker("$ocl!Collection{T}!product{T2}($ocl!Collection[T2])");
			symbol_328.setType(symbol_220);  // $ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
			
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("c2");
			//symbol_329.setMoniker("$ocl!Collection{T}!product{T2}($ocl!Collection[T2])!c2");
			symbol_329.setType(symbol_151);  // $ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]
			
			symbol_328.getOwnedParameters().add(symbol_329);
			symbol_328.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionProductOperation");
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::Collection::reject() $ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_330 = PivotFactory.eINSTANCE.createIteration();
			symbol_330.setName("reject");
			//symbol_330.setMoniker("$ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_330.setType(symbol_152);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_331 = PivotFactory.eINSTANCE.createParameter();
			symbol_331.setName("i");
			symbol_331.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_330.getOwnedIterators().add(symbol_331);
			Parameter symbol_332 = PivotFactory.eINSTANCE.createParameter();
			symbol_332.setName("body");
			//symbol_332.setMoniker("$ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_332.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_330.getOwnedParameters().add(symbol_332);
			symbol_330.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_330.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_330);
		}
		{	// ocl::Collection::select() $ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_333 = PivotFactory.eINSTANCE.createIteration();
			symbol_333.setName("select");
			//symbol_333.setMoniker("$ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_333.setType(symbol_152);  // $ocl!Collection[$ocl!Collection{T}?T]
			
			Parameter symbol_334 = PivotFactory.eINSTANCE.createParameter();
			symbol_334.setName("i");
			symbol_334.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_333.getOwnedIterators().add(symbol_334);
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("body");
			//symbol_335.setMoniker("$ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_335.setType(symbol_236);  // Lambda~$ocl!Collection{T}?T()Boolean
			
			symbol_333.getOwnedParameters().add(symbol_335);
			symbol_333.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_333.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_333);
		}
		{	// ocl::Collection::size() $ocl!Collection{T}!size()
			Operation symbol_336 = PivotFactory.eINSTANCE.createOperation();
			symbol_336.setName("size");
			//symbol_336.setMoniker("$ocl!Collection{T}!size()");
			symbol_336.setType(symbol_123);  // Integer
			
			symbol_336.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSizeOperation");
			symbol_336.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_336);
		}
		{	// ocl::Collection::sortedBy() $ocl!Collection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_337 = PivotFactory.eINSTANCE.createIteration();
			symbol_337.setName("sortedBy");
			//symbol_337.setMoniker("$ocl!Collection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)");
			symbol_337.setType(symbol_190);  // $ocl!OrderedCollection[$ocl!Collection{T}?T]
			
			Parameter symbol_338 = PivotFactory.eINSTANCE.createParameter();
			symbol_338.setName("i");
			symbol_338.setType(symbol_32);  // $ocl!Collection{T}?T
			symbol_337.getOwnedIterators().add(symbol_338);
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("body");
			//symbol_339.setMoniker("$ocl!Collection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)!body");
			symbol_339.setType(symbol_235);  // Lambda~$ocl!Collection{T}?T()$ocl!OclAny
			
			symbol_337.getOwnedParameters().add(symbol_339);
			symbol_337.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::Collection::sum() $ocl!Collection{T}!sum()
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("sum");
			//symbol_340.setMoniker("$ocl!Collection{T}!sum()");
			symbol_340.setType(symbol_32);  // $ocl!Collection{T}?T
			
			symbol_340.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSumOperation");
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_29.getOwnedOperations().add(symbol_340);
		}
		symbol_1.getOwnedTypes().add(symbol_29);
		//
		// ocl::Enumeration $ocl!Enumeration
		//
		symbol_54.setName("Enumeration");
		//symbol_54.setMoniker("$ocl!Enumeration");
		symbol_54.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::Enumeration::allInstances() $ocl!Enumeration!allInstances()
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("allInstances");
			//symbol_341.setMoniker("$ocl!Enumeration!allInstances()");
			symbol_341.setType(symbol_216);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_341.setIsStatic(true);
			symbol_341.setImplementationClass("org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation");
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_341);
		}
		symbol_1.getOwnedTypes().add(symbol_54);
		//
		// ocl::NonOrderedCollection $ocl!NonOrderedCollection{T}
		//
		symbol_55.setName("NonOrderedCollection");
		//symbol_55.setMoniker("$ocl!NonOrderedCollection{T}");
		symbol_55.setElementType(symbol_58);
		symbol_58.setName("T");
		symbol_57.setOwnedParameteredElement(symbol_58);
		symbol_56.getOwnedParameters().add(symbol_57);
		
		symbol_55.setOwnedTemplateSignature(symbol_56);
		symbol_55.getSuperClasses().add(symbol_154); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() $ocl!NonOrderedCollection{T}!closure(T|Lambda~T()$ocl!Set[T])
			Iteration symbol_342 = PivotFactory.eINSTANCE.createIteration();
			symbol_342.setName("closure");
			//symbol_342.setMoniker("$ocl!NonOrderedCollection{T}!closure(T|Lambda~T()$ocl!Set[T])");
			symbol_342.setType(symbol_214);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_343 = PivotFactory.eINSTANCE.createParameter();
			symbol_343.setName("i");
			symbol_343.setType(symbol_58);  // $ocl!NonOrderedCollection{T}?T
			symbol_342.getOwnedIterators().add(symbol_343);
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("body");
			//symbol_344.setMoniker("$ocl!NonOrderedCollection{T}!closure(T|Lambda~T()$ocl!Set[T])!body");
			symbol_344.setType(symbol_239);  // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]
			
			symbol_342.getOwnedParameters().add(symbol_344);
			symbol_342.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_342.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_342);
		}
		{	// ocl::NonOrderedCollection::collect() $ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_345 = PivotFactory.eINSTANCE.createIteration();
			symbol_61.setName("V");
			symbol_60.setOwnedParameteredElement(symbol_61);
			symbol_59.getOwnedParameters().add(symbol_60);
			
			symbol_345.setOwnedTemplateSignature(symbol_59);
			symbol_345.setName("collect");
			//symbol_345.setMoniker("$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_345.setType(symbol_135);  // $ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("i");
			symbol_346.setType(symbol_58);  // $ocl!NonOrderedCollection{T}?T
			symbol_345.getOwnedIterators().add(symbol_346);
			Parameter symbol_347 = PivotFactory.eINSTANCE.createParameter();
			symbol_347.setName("body");
			//symbol_347.setMoniker("$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_347.setType(symbol_238);  // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_345.getOwnedParameters().add(symbol_347);
			symbol_345.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_345);
		}
		{	// ocl::NonOrderedCollection::collectNested() $ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_348 = PivotFactory.eINSTANCE.createIteration();
			symbol_64.setName("V");
			symbol_63.setOwnedParameteredElement(symbol_64);
			symbol_62.getOwnedParameters().add(symbol_63);
			
			symbol_348.setOwnedTemplateSignature(symbol_62);
			symbol_348.setName("collectNested");
			//symbol_348.setMoniker("$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_348.setType(symbol_136);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_349 = PivotFactory.eINSTANCE.createParameter();
			symbol_349.setName("i");
			symbol_349.setType(symbol_58);  // $ocl!NonOrderedCollection{T}?T
			symbol_348.getOwnedIterators().add(symbol_349);
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("body");
			//symbol_350.setMoniker("$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_350.setType(symbol_237);  // Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_348.getOwnedParameters().add(symbol_350);
			symbol_348.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_348);
		}
		{	// ocl::NonOrderedCollection::intersection() $ocl!NonOrderedCollection{T}!intersection($ocl!Bag[T])
			Operation symbol_351 = PivotFactory.eINSTANCE.createOperation();
			symbol_351.setName("intersection");
			//symbol_351.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Bag[T])");
			symbol_351.setType(symbol_136);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_352 = PivotFactory.eINSTANCE.createParameter();
			symbol_352.setName("bag");
			//symbol_352.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Bag[T])!bag");
			symbol_352.setType(symbol_136);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			symbol_351.getOwnedParameters().add(symbol_352);
			symbol_351.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::NonOrderedCollection::intersection() $ocl!NonOrderedCollection{T}!intersection($ocl!Set[T])
			Operation symbol_353 = PivotFactory.eINSTANCE.createOperation();
			symbol_353.setName("intersection");
			//symbol_353.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Set[T])");
			symbol_353.setType(symbol_214);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("s");
			//symbol_354.setMoniker("$ocl!NonOrderedCollection{T}!intersection($ocl!Set[T])!s");
			symbol_354.setType(symbol_214);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			symbol_353.getOwnedParameters().add(symbol_354);
			symbol_353.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_353.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_353);
		}
		{	// ocl::NonOrderedCollection::union() $ocl!NonOrderedCollection{T}!union($ocl!Bag[T])
			Operation symbol_355 = PivotFactory.eINSTANCE.createOperation();
			symbol_355.setName("union");
			//symbol_355.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Bag[T])");
			symbol_355.setType(symbol_136);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_356 = PivotFactory.eINSTANCE.createParameter();
			symbol_356.setName("bag");
			//symbol_356.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Bag[T])!bag");
			symbol_356.setType(symbol_136);  // $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
			
			symbol_355.getOwnedParameters().add(symbol_356);
			symbol_355.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_355);
		}
		{	// ocl::NonOrderedCollection::union() $ocl!NonOrderedCollection{T}!union($ocl!Set[T])
			Operation symbol_357 = PivotFactory.eINSTANCE.createOperation();
			symbol_357.setName("union");
			//symbol_357.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Set[T])");
			symbol_357.setType(symbol_214);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_358 = PivotFactory.eINSTANCE.createParameter();
			symbol_358.setName("s");
			//symbol_358.setMoniker("$ocl!NonOrderedCollection{T}!union($ocl!Set[T])!s");
			symbol_358.setType(symbol_214);  // $ocl!Set[$ocl!NonOrderedCollection{T}?T]
			
			symbol_357.getOwnedParameters().add(symbol_358);
			symbol_357.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_357.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_357);
		}
		symbol_1.getOwnedTypes().add(symbol_55);
		//
		// ocl::NonUniqueCollection $ocl!NonUniqueCollection{T}
		//
		symbol_65.setName("NonUniqueCollection");
		//symbol_65.setMoniker("$ocl!NonUniqueCollection{T}");
		symbol_65.setElementType(symbol_68);
		symbol_68.setName("T");
		symbol_67.setOwnedParameteredElement(symbol_68);
		symbol_66.getOwnedParameters().add(symbol_67);
		
		symbol_65.setOwnedTemplateSignature(symbol_66);
		symbol_65.getSuperClasses().add(symbol_155); // $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() $ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_359 = PivotFactory.eINSTANCE.createIteration();
			symbol_359.setName("sortedBy");
			//symbol_359.setMoniker("$ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)");
			symbol_359.setType(symbol_206);  // $ocl!Sequence[$ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_360 = PivotFactory.eINSTANCE.createParameter();
			symbol_360.setName("i");
			symbol_360.setType(symbol_68);  // $ocl!NonUniqueCollection{T}?T
			symbol_359.getOwnedIterators().add(symbol_360);
			Parameter symbol_361 = PivotFactory.eINSTANCE.createParameter();
			symbol_361.setName("body");
			//symbol_361.setMoniker("$ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)!body");
			symbol_361.setType(symbol_240);  // Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny
			
			symbol_359.getOwnedParameters().add(symbol_361);
			symbol_359.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_359.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_359);
		}
		symbol_1.getOwnedTypes().add(symbol_65);
		//
		// ocl::OclAny $ocl!OclAny
		//
		symbol_69.setName("OclAny");
		//symbol_69.setMoniker("$ocl!OclAny");
		{	// ocl::OclAny::<>() $ocl!OclAny!<>($ocl!OclSelf)
			Operation symbol_362 = PivotFactory.eINSTANCE.createOperation();
			symbol_362.setName("<>");
			//symbol_362.setMoniker("$ocl!OclAny!<>($ocl!OclSelf)");
			symbol_362.setType(symbol_122);  // Boolean
			
			Parameter symbol_363 = PivotFactory.eINSTANCE.createParameter();
			symbol_363.setName("object2");
			//symbol_363.setMoniker("$ocl!OclAny!<>($ocl!OclSelf)!object2");
			symbol_363.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_362.getOwnedParameters().add(symbol_363);
			symbol_362.setPrecedence(symbol_7);
			symbol_362.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_362.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_362);
		}
		{	// ocl::OclAny::=() $ocl!OclAny!=($ocl!OclSelf)
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("=");
			//symbol_364.setMoniker("$ocl!OclAny!=($ocl!OclSelf)");
			symbol_364.setType(symbol_122);  // Boolean
			
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("object2");
			//symbol_365.setMoniker("$ocl!OclAny!=($ocl!OclSelf)!object2");
			symbol_365.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_364.getOwnedParameters().add(symbol_365);
			symbol_364.setPrecedence(symbol_7);
			symbol_364.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_364);
		}
		{	// ocl::OclAny::oclAsSet() $ocl!OclAny!oclAsSet()
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_366.setName("oclAsSet");
			//symbol_366.setMoniker("$ocl!OclAny!oclAsSet()");
			symbol_366.setType(symbol_216);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_366.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation");
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_366);
		}
		{	// ocl::OclAny::oclAsType() $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_72.setName("TT");
			symbol_71.setOwnedParameteredElement(symbol_72);
			symbol_70.getOwnedParameters().add(symbol_71);
			
			symbol_367.setOwnedTemplateSignature(symbol_70);
			symbol_367.setName("oclAsType");
			//symbol_367.setMoniker("$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])");
			symbol_367.setType(symbol_72);  // $ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT
			
			Parameter symbol_368 = PivotFactory.eINSTANCE.createParameter();
			symbol_368.setName("type");
			//symbol_368.setMoniker("$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])!type");
			symbol_368.setType(symbol_139);  // $ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]
			
			symbol_367.getOwnedParameters().add(symbol_368);
			symbol_367.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation");
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::OclAny::oclIsInState() $ocl!OclAny!oclIsInState($ocl!OclState)
			Operation symbol_369 = PivotFactory.eINSTANCE.createOperation();
			symbol_369.setName("oclIsInState");
			//symbol_369.setMoniker("$ocl!OclAny!oclIsInState($ocl!OclState)");
			symbol_369.setType(symbol_122);  // Boolean
			
			Parameter symbol_370 = PivotFactory.eINSTANCE.createParameter();
			symbol_370.setName("statespec");
			//symbol_370.setMoniker("$ocl!OclAny!oclIsInState($ocl!OclState)!statespec");
			symbol_370.setType(symbol_83);  // $ocl!OclState
			
			symbol_369.getOwnedParameters().add(symbol_370);
			symbol_369.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation");
			symbol_369.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_369);
		}
		{	// ocl::OclAny::oclIsInvalid() $ocl!OclAny!oclIsInvalid()
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("oclIsInvalid");
			//symbol_371.setMoniker("$ocl!OclAny!oclIsInvalid()");
			symbol_371.setType(symbol_122);  // Boolean
			
			symbol_371.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation");
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::OclAny::oclIsKindOf() $ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_75.setName("T");
			symbol_74.setOwnedParameteredElement(symbol_75);
			symbol_73.getOwnedParameters().add(symbol_74);
			
			symbol_372.setOwnedTemplateSignature(symbol_73);
			symbol_372.setName("oclIsKindOf");
			//symbol_372.setMoniker("$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])");
			symbol_372.setType(symbol_122);  // Boolean
			
			Parameter symbol_373 = PivotFactory.eINSTANCE.createParameter();
			symbol_373.setName("type");
			//symbol_373.setMoniker("$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])!type");
			symbol_373.setType(symbol_140);  // $ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]
			
			symbol_372.getOwnedParameters().add(symbol_373);
			symbol_372.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation");
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::OclAny::oclIsNew() $ocl!OclAny!oclIsNew()
			Operation symbol_374 = PivotFactory.eINSTANCE.createOperation();
			symbol_374.setName("oclIsNew");
			//symbol_374.setMoniker("$ocl!OclAny!oclIsNew()");
			symbol_374.setType(symbol_122);  // Boolean
			
			symbol_374.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::OclAny::oclIsTypeOf() $ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])
			Operation symbol_375 = PivotFactory.eINSTANCE.createOperation();
			symbol_78.setName("T");
			symbol_77.setOwnedParameteredElement(symbol_78);
			symbol_76.getOwnedParameters().add(symbol_77);
			
			symbol_375.setOwnedTemplateSignature(symbol_76);
			symbol_375.setName("oclIsTypeOf");
			//symbol_375.setMoniker("$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])");
			symbol_375.setType(symbol_122);  // Boolean
			
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("type");
			//symbol_376.setMoniker("$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])!type");
			symbol_376.setType(symbol_141);  // $ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]
			
			symbol_375.getOwnedParameters().add(symbol_376);
			symbol_375.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation");
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_375);
		}
		{	// ocl::OclAny::oclIsUndefined() $ocl!OclAny!oclIsUndefined()
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_377.setName("oclIsUndefined");
			//symbol_377.setMoniker("$ocl!OclAny!oclIsUndefined()");
			symbol_377.setType(symbol_122);  // Boolean
			
			symbol_377.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation");
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::OclAny::oclType() $ocl!OclAny!oclType()
			Operation symbol_378 = PivotFactory.eINSTANCE.createOperation();
			symbol_378.setName("oclType");
			//symbol_378.setMoniker("$ocl!OclAny!oclType()");
			symbol_378.setType(symbol_142);  // $ocl!Classifier[$ocl!OclSelf]
			
			symbol_378.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation");
			symbol_378.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_378);
		}
		symbol_1.getOwnedTypes().add(symbol_69);
		//
		// ocl::OclInvalid $ocl!OclInvalid
		//
		symbol_79.setName("OclInvalid");
		//symbol_79.setMoniker("$ocl!OclInvalid");
		symbol_79.getSuperClasses().add(symbol_85); // $ocl!OclVoid
		{ // ocl::OclInvalid::oclBadProperty $ocl!OclInvalid!oclBadProperty
			symbol_80.setName("oclBadProperty");
			symbol_80.setType(symbol_79);  // $ocl!OclInvalid
			
			symbol_80.setIsResolveProxies(true);
			symbol_79.getOwnedAttributes().add(symbol_80);
		}
		{	// ocl::OclInvalid::<>() $ocl!OclInvalid!<>($ocl!OclSelf)
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("<>");
			//symbol_379.setMoniker("$ocl!OclInvalid!<>($ocl!OclSelf)");
			symbol_379.setType(symbol_122);  // Boolean
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("object2");
			//symbol_380.setMoniker("$ocl!OclInvalid!<>($ocl!OclSelf)!object2");
			symbol_380.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_379.getOwnedParameters().add(symbol_380);
			symbol_379.setPrecedence(symbol_7);
			symbol_379.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::OclInvalid::=() $ocl!OclInvalid!=($ocl!OclSelf)
			Operation symbol_381 = PivotFactory.eINSTANCE.createOperation();
			symbol_381.setName("=");
			//symbol_381.setMoniker("$ocl!OclInvalid!=($ocl!OclSelf)");
			symbol_381.setType(symbol_122);  // Boolean
			
			Parameter symbol_382 = PivotFactory.eINSTANCE.createParameter();
			symbol_382.setName("object2");
			//symbol_382.setMoniker("$ocl!OclInvalid!=($ocl!OclSelf)!object2");
			symbol_382.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_381.getOwnedParameters().add(symbol_382);
			symbol_381.setPrecedence(symbol_7);
			symbol_381.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_381.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_381);
		}
		{	// ocl::OclInvalid::allInstances() $ocl!OclInvalid!allInstances()
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_383.setName("allInstances");
			//symbol_383.setMoniker("$ocl!OclInvalid!allInstances()");
			symbol_383.setType(symbol_216);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_383.setIsStatic(true);
			symbol_383.setImplementationClass("org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation");
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_383);
		}
		{	// ocl::OclInvalid::oclBadOperation() $ocl!OclInvalid!oclBadOperation()
			Operation symbol_384 = PivotFactory.eINSTANCE.createOperation();
			symbol_384.setName("oclBadOperation");
			//symbol_384.setMoniker("$ocl!OclInvalid!oclBadOperation()");
			symbol_384.setType(symbol_79);  // $ocl!OclInvalid
			
			symbol_79.getOwnedOperations().add(symbol_384);
		}
		{	// ocl::OclInvalid::toString() $ocl!OclInvalid!toString()
			Operation symbol_385 = PivotFactory.eINSTANCE.createOperation();
			symbol_385.setName("toString");
			//symbol_385.setMoniker("$ocl!OclInvalid!toString()");
			symbol_385.setType(symbol_128);  // String
			
			symbol_385.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_385.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_385);
		}
		symbol_1.getOwnedTypes().add(symbol_79);
		//
		// ocl::OclMessage $ocl!OclMessage
		//
		symbol_81.setName("OclMessage");
		//symbol_81.setMoniker("$ocl!OclMessage");
		symbol_81.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::OclMessage::hasReturned() $ocl!OclMessage!hasReturned()
			Operation symbol_386 = PivotFactory.eINSTANCE.createOperation();
			symbol_386.setName("hasReturned");
			//symbol_386.setMoniker("$ocl!OclMessage!hasReturned()");
			symbol_386.setType(symbol_122);  // Boolean
			
			symbol_386.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::OclMessage::isOperationCall() $ocl!OclMessage!isOperationCall()
			Operation symbol_387 = PivotFactory.eINSTANCE.createOperation();
			symbol_387.setName("isOperationCall");
			//symbol_387.setMoniker("$ocl!OclMessage!isOperationCall()");
			symbol_387.setType(symbol_122);  // Boolean
			
			symbol_387.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_387.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_387);
		}
		{	// ocl::OclMessage::isSignalSent() $ocl!OclMessage!isSignalSent()
			Operation symbol_388 = PivotFactory.eINSTANCE.createOperation();
			symbol_388.setName("isSignalSent");
			//symbol_388.setMoniker("$ocl!OclMessage!isSignalSent()");
			symbol_388.setType(symbol_122);  // Boolean
			
			symbol_388.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_388.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_388);
		}
		{	// ocl::OclMessage::result() $ocl!OclMessage!result()
			Operation symbol_389 = PivotFactory.eINSTANCE.createOperation();
			symbol_389.setName("result");
			//symbol_389.setMoniker("$ocl!OclMessage!result()");
			symbol_389.setType(symbol_69);  // $ocl!OclAny
			
			symbol_389.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_81.getOwnedOperations().add(symbol_389);
		}
		symbol_1.getOwnedTypes().add(symbol_81);
		//
		// ocl::OclSelf $ocl!OclSelf
		//
		symbol_82.setName("OclSelf");
		//symbol_82.setMoniker("$ocl!OclSelf");
		symbol_82.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_82);
		//
		// ocl::OclState $ocl!OclState
		//
		symbol_83.setName("OclState");
		//symbol_83.setMoniker("$ocl!OclState");
		symbol_83.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// ocl::OclTuple $ocl!OclTuple
		//
		symbol_84.setName("OclTuple");
		//symbol_84.setMoniker("$ocl!OclTuple");
		symbol_84.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::OclTuple::<>() $ocl!OclTuple!<>($ocl!OclSelf)
			Operation symbol_390 = PivotFactory.eINSTANCE.createOperation();
			symbol_390.setName("<>");
			//symbol_390.setMoniker("$ocl!OclTuple!<>($ocl!OclSelf)");
			symbol_390.setType(symbol_122);  // Boolean
			
			Parameter symbol_391 = PivotFactory.eINSTANCE.createParameter();
			symbol_391.setName("object2");
			//symbol_391.setMoniker("$ocl!OclTuple!<>($ocl!OclSelf)!object2");
			symbol_391.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_390.getOwnedParameters().add(symbol_391);
			symbol_390.setPrecedence(symbol_7);
			symbol_390.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_390.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_84.getOwnedOperations().add(symbol_390);
		}
		{	// ocl::OclTuple::=() $ocl!OclTuple!=($ocl!OclSelf)
			Operation symbol_392 = PivotFactory.eINSTANCE.createOperation();
			symbol_392.setName("=");
			//symbol_392.setMoniker("$ocl!OclTuple!=($ocl!OclSelf)");
			symbol_392.setType(symbol_122);  // Boolean
			
			Parameter symbol_393 = PivotFactory.eINSTANCE.createParameter();
			symbol_393.setName("object2");
			//symbol_393.setMoniker("$ocl!OclTuple!=($ocl!OclSelf)!object2");
			symbol_393.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_392.getOwnedParameters().add(symbol_393);
			symbol_392.setPrecedence(symbol_7);
			symbol_392.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_392.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_84.getOwnedOperations().add(symbol_392);
		}
		symbol_1.getOwnedTypes().add(symbol_84);
		//
		// ocl::OclVoid $ocl!OclVoid
		//
		symbol_85.setName("OclVoid");
		//symbol_85.setMoniker("$ocl!OclVoid");
		symbol_85.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::OclVoid::<>() $ocl!OclVoid!<>($ocl!OclSelf)
			Operation symbol_394 = PivotFactory.eINSTANCE.createOperation();
			symbol_394.setName("<>");
			//symbol_394.setMoniker("$ocl!OclVoid!<>($ocl!OclSelf)");
			symbol_394.setType(symbol_122);  // Boolean
			
			Parameter symbol_395 = PivotFactory.eINSTANCE.createParameter();
			symbol_395.setName("object2");
			//symbol_395.setMoniker("$ocl!OclVoid!<>($ocl!OclSelf)!object2");
			symbol_395.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_394.getOwnedParameters().add(symbol_395);
			symbol_394.setPrecedence(symbol_7);
			symbol_394.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_394.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_394);
		}
		{	// ocl::OclVoid::=() $ocl!OclVoid!=($ocl!OclSelf)
			Operation symbol_396 = PivotFactory.eINSTANCE.createOperation();
			symbol_396.setName("=");
			//symbol_396.setMoniker("$ocl!OclVoid!=($ocl!OclSelf)");
			symbol_396.setType(symbol_122);  // Boolean
			
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("object2");
			//symbol_397.setMoniker("$ocl!OclVoid!=($ocl!OclSelf)!object2");
			symbol_397.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_396.getOwnedParameters().add(symbol_397);
			symbol_396.setPrecedence(symbol_7);
			symbol_396.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_396);
		}
		{	// ocl::OclVoid::allInstances() $ocl!OclVoid!allInstances()
			Operation symbol_398 = PivotFactory.eINSTANCE.createOperation();
			symbol_398.setName("allInstances");
			//symbol_398.setMoniker("$ocl!OclVoid!allInstances()");
			symbol_398.setType(symbol_216);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_398.setIsStatic(true);
			symbol_398.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation");
			symbol_398.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_398);
		}
		{	// ocl::OclVoid::and() $ocl!OclVoid!and(Boolean)
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("and");
			//symbol_399.setMoniker("$ocl!OclVoid!and(Boolean)");
			symbol_399.setType(symbol_122);  // Boolean
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("b");
			//symbol_400.setMoniker("$ocl!OclVoid!and(Boolean)!b");
			symbol_400.setType(symbol_122);  // Boolean
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setPrecedence(symbol_8);
			symbol_399.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation");
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_399);
		}
		{	// ocl::OclVoid::implies() $ocl!OclVoid!implies(Boolean)
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("implies");
			//symbol_401.setMoniker("$ocl!OclVoid!implies(Boolean)");
			symbol_401.setType(symbol_122);  // Boolean
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("b");
			//symbol_402.setMoniker("$ocl!OclVoid!implies(Boolean)!b");
			symbol_402.setType(symbol_122);  // Boolean
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setPrecedence(symbol_11);
			symbol_401.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation");
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OclVoid::or() $ocl!OclVoid!or(Boolean)
			Operation symbol_403 = PivotFactory.eINSTANCE.createOperation();
			symbol_403.setName("or");
			//symbol_403.setMoniker("$ocl!OclVoid!or(Boolean)");
			symbol_403.setType(symbol_122);  // Boolean
			
			Parameter symbol_404 = PivotFactory.eINSTANCE.createParameter();
			symbol_404.setName("b");
			//symbol_404.setMoniker("$ocl!OclVoid!or(Boolean)!b");
			symbol_404.setType(symbol_122);  // Boolean
			
			symbol_403.getOwnedParameters().add(symbol_404);
			symbol_403.setPrecedence(symbol_9);
			symbol_403.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation");
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_403);
		}
		{	// ocl::OclVoid::toString() $ocl!OclVoid!toString()
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("toString");
			//symbol_405.setMoniker("$ocl!OclVoid!toString()");
			symbol_405.setType(symbol_128);  // String
			
			symbol_405.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_85.getOwnedOperations().add(symbol_405);
		}
		symbol_1.getOwnedTypes().add(symbol_85);
		//
		// ocl::OrderedCollection $ocl!OrderedCollection{T}
		//
		symbol_86.setName("OrderedCollection");
		//symbol_86.setMoniker("$ocl!OrderedCollection{T}");
		symbol_86.setElementType(symbol_89);
		symbol_89.setName("T");
		symbol_88.setOwnedParameteredElement(symbol_89);
		symbol_87.getOwnedParameters().add(symbol_88);
		
		symbol_86.setOwnedTemplateSignature(symbol_87);
		symbol_86.getSuperClasses().add(symbol_159); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() $ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_406.setName("at");
			//symbol_406.setMoniker("$ocl!OrderedCollection{T}!at(Integer)");
			symbol_406.setType(symbol_89);  // $ocl!OrderedCollection{T}?T
			
			Parameter symbol_407 = PivotFactory.eINSTANCE.createParameter();
			symbol_407.setName("index");
			//symbol_407.setMoniker("$ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_407.setType(symbol_123);  // Integer
			
			symbol_406.getOwnedParameters().add(symbol_407);
			symbol_406.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation");
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OrderedCollection::closure() $ocl!OrderedCollection{T}!closure(T|Lambda~T()$ocl!OrderedSet[T])
			Iteration symbol_408 = PivotFactory.eINSTANCE.createIteration();
			symbol_408.setName("closure");
			//symbol_408.setMoniker("$ocl!OrderedCollection{T}!closure(T|Lambda~T()$ocl!OrderedSet[T])");
			symbol_408.setType(symbol_201);  // $ocl!OrderedSet[$ocl!OrderedCollection{T}?T]
			
			Parameter symbol_409 = PivotFactory.eINSTANCE.createParameter();
			symbol_409.setName("i");
			symbol_409.setType(symbol_89);  // $ocl!OrderedCollection{T}?T
			symbol_408.getOwnedIterators().add(symbol_409);
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("body");
			//symbol_410.setMoniker("$ocl!OrderedCollection{T}!closure(T|Lambda~T()$ocl!OrderedSet[T])!body");
			symbol_410.setType(symbol_243);  // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]
			
			symbol_408.getOwnedParameters().add(symbol_410);
			symbol_408.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_408);
		}
		{	// ocl::OrderedCollection::collect() $ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_411 = PivotFactory.eINSTANCE.createIteration();
			symbol_92.setName("V");
			symbol_91.setOwnedParameteredElement(symbol_92);
			symbol_90.getOwnedParameters().add(symbol_91);
			
			symbol_411.setOwnedTemplateSignature(symbol_90);
			symbol_411.setName("collect");
			//symbol_411.setMoniker("$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_411.setType(symbol_207);  // $ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("i");
			symbol_412.setType(symbol_89);  // $ocl!OrderedCollection{T}?T
			symbol_411.getOwnedIterators().add(symbol_412);
			Parameter symbol_413 = PivotFactory.eINSTANCE.createParameter();
			symbol_413.setName("body");
			//symbol_413.setMoniker("$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_413.setType(symbol_242);  // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_411.getOwnedParameters().add(symbol_413);
			symbol_411.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OrderedCollection::collectNested() $ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_414 = PivotFactory.eINSTANCE.createIteration();
			symbol_95.setName("V");
			symbol_94.setOwnedParameteredElement(symbol_95);
			symbol_93.getOwnedParameters().add(symbol_94);
			
			symbol_414.setOwnedTemplateSignature(symbol_93);
			symbol_414.setName("collectNested");
			//symbol_414.setMoniker("$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_414.setType(symbol_208);  // $ocl!Sequence[$ocl!OrderedCollection{T}?T]
			
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("i");
			symbol_415.setType(symbol_89);  // $ocl!OrderedCollection{T}?T
			symbol_414.getOwnedIterators().add(symbol_415);
			Parameter symbol_416 = PivotFactory.eINSTANCE.createParameter();
			symbol_416.setName("body");
			//symbol_416.setMoniker("$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_416.setType(symbol_241);  // Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_414.getOwnedParameters().add(symbol_416);
			symbol_414.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_414.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_414);
		}
		{	// ocl::OrderedCollection::first() $ocl!OrderedCollection{T}!first()
			Operation symbol_417 = PivotFactory.eINSTANCE.createOperation();
			symbol_417.setName("first");
			//symbol_417.setMoniker("$ocl!OrderedCollection{T}!first()");
			symbol_417.setType(symbol_89);  // $ocl!OrderedCollection{T}?T
			
			symbol_417.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation");
			symbol_417.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_417);
		}
		{	// ocl::OrderedCollection::indexOf() $ocl!OrderedCollection{T}!indexOf($ocl!OclAny)
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("indexOf");
			//symbol_418.setMoniker("$ocl!OrderedCollection{T}!indexOf($ocl!OclAny)");
			symbol_418.setType(symbol_123);  // Integer
			
			Parameter symbol_419 = PivotFactory.eINSTANCE.createParameter();
			symbol_419.setName("obj");
			//symbol_419.setMoniker("$ocl!OrderedCollection{T}!indexOf($ocl!OclAny)!obj");
			symbol_419.setType(symbol_69);  // $ocl!OclAny
			
			symbol_418.getOwnedParameters().add(symbol_419);
			symbol_418.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation");
			symbol_418.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_418);
		}
		{	// ocl::OrderedCollection::last() $ocl!OrderedCollection{T}!last()
			Operation symbol_420 = PivotFactory.eINSTANCE.createOperation();
			symbol_420.setName("last");
			//symbol_420.setMoniker("$ocl!OrderedCollection{T}!last()");
			symbol_420.setType(symbol_89);  // $ocl!OrderedCollection{T}?T
			
			symbol_420.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation");
			symbol_420.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_420);
		}
		{	// ocl::OrderedCollection::reverse() $ocl!OrderedCollection{T}!reverse()
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("reverse");
			//symbol_421.setMoniker("$ocl!OrderedCollection{T}!reverse()");
			symbol_421.setType(symbol_193);  // $ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]
			
			symbol_421.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_421);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// ocl::OrderedSet $ocl!OrderedSet{T}
		//
		symbol_96.setName("OrderedSet");
		//symbol_96.setMoniker("$ocl!OrderedSet{T}");
		symbol_96.setElementType(symbol_99);
		symbol_99.setName("T");
		symbol_98.setOwnedParameteredElement(symbol_99);
		symbol_97.getOwnedParameters().add(symbol_98);
		
		symbol_96.setOwnedTemplateSignature(symbol_97);
		symbol_96.getSuperClasses().add(symbol_228); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		symbol_96.getSuperClasses().add(symbol_195); // $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() $ocl!OrderedSet{T}!-($ocl!Set[$ocl!OclAny])
			Operation symbol_422 = PivotFactory.eINSTANCE.createOperation();
			symbol_422.setName("-");
			//symbol_422.setMoniker("$ocl!OrderedSet{T}!-($ocl!Set[$ocl!OclAny])");
			symbol_422.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_423 = PivotFactory.eINSTANCE.createParameter();
			symbol_423.setName("s");
			//symbol_423.setMoniker("$ocl!OrderedSet{T}!-($ocl!Set[$ocl!OclAny])!s");
			symbol_423.setType(symbol_215);  // $ocl!Set[$ocl!OclAny]
			
			symbol_422.getOwnedParameters().add(symbol_423);
			symbol_422.setPrecedence(symbol_5);
			symbol_422.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_422);
		}
		{	// ocl::OrderedSet::<>() $ocl!OrderedSet{T}!<>($ocl!OclSelf)
			Operation symbol_424 = PivotFactory.eINSTANCE.createOperation();
			symbol_424.setName("<>");
			//symbol_424.setMoniker("$ocl!OrderedSet{T}!<>($ocl!OclSelf)");
			symbol_424.setType(symbol_122);  // Boolean
			
			Parameter symbol_425 = PivotFactory.eINSTANCE.createParameter();
			symbol_425.setName("object2");
			//symbol_425.setMoniker("$ocl!OrderedSet{T}!<>($ocl!OclSelf)!object2");
			symbol_425.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_424.getOwnedParameters().add(symbol_425);
			symbol_424.setPrecedence(symbol_7);
			symbol_424.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_424.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_424);
		}
		{	// ocl::OrderedSet::=() $ocl!OrderedSet{T}!=($ocl!OclSelf)
			Operation symbol_426 = PivotFactory.eINSTANCE.createOperation();
			symbol_426.setName("=");
			//symbol_426.setMoniker("$ocl!OrderedSet{T}!=($ocl!OclSelf)");
			symbol_426.setType(symbol_122);  // Boolean
			
			Parameter symbol_427 = PivotFactory.eINSTANCE.createParameter();
			symbol_427.setName("object2");
			//symbol_427.setMoniker("$ocl!OrderedSet{T}!=($ocl!OclSelf)!object2");
			symbol_427.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_426.getOwnedParameters().add(symbol_427);
			symbol_426.setPrecedence(symbol_7);
			symbol_426.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_426.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_426);
		}
		{	// ocl::OrderedSet::append() $ocl!OrderedSet{T}!append(T)
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("append");
			//symbol_428.setMoniker("$ocl!OrderedSet{T}!append(T)");
			symbol_428.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_429 = PivotFactory.eINSTANCE.createParameter();
			symbol_429.setName("object");
			//symbol_429.setMoniker("$ocl!OrderedSet{T}!append(T)!object");
			symbol_429.setType(symbol_99);  // $ocl!OrderedSet{T}?T
			
			symbol_428.getOwnedParameters().add(symbol_429);
			symbol_428.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_428.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::OrderedSet::excluding() $ocl!OrderedSet{T}!excluding($ocl!OclAny)
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("excluding");
			//symbol_430.setMoniker("$ocl!OrderedSet{T}!excluding($ocl!OclAny)");
			symbol_430.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("object");
			//symbol_431.setMoniker("$ocl!OrderedSet{T}!excluding($ocl!OclAny)!object");
			symbol_431.setType(symbol_69);  // $ocl!OclAny
			
			symbol_430.getOwnedParameters().add(symbol_431);
			symbol_430.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::OrderedSet::flatten() $ocl!OrderedSet{T}!flatten{T2}()
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_102.setName("T2");
			symbol_101.setOwnedParameteredElement(symbol_102);
			symbol_100.getOwnedParameters().add(symbol_101);
			
			symbol_432.setOwnedTemplateSignature(symbol_100);
			symbol_432.setName("flatten");
			//symbol_432.setMoniker("$ocl!OrderedSet{T}!flatten{T2}()");
			symbol_432.setType(symbol_202);  // $ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]
			
			symbol_432.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::OrderedSet::including() $ocl!OrderedSet{T}!including(T)
			Operation symbol_433 = PivotFactory.eINSTANCE.createOperation();
			symbol_433.setName("including");
			//symbol_433.setMoniker("$ocl!OrderedSet{T}!including(T)");
			symbol_433.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_434 = PivotFactory.eINSTANCE.createParameter();
			symbol_434.setName("object");
			//symbol_434.setMoniker("$ocl!OrderedSet{T}!including(T)!object");
			symbol_434.setType(symbol_99);  // $ocl!OrderedSet{T}?T
			
			symbol_433.getOwnedParameters().add(symbol_434);
			symbol_433.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_433.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_433);
		}
		{	// ocl::OrderedSet::insertAt() $ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_435.setName("insertAt");
			//symbol_435.setMoniker("$ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_435.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_436 = PivotFactory.eINSTANCE.createParameter();
			symbol_436.setName("index");
			//symbol_436.setMoniker("$ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_436.setType(symbol_123);  // Integer
			
			symbol_435.getOwnedParameters().add(symbol_436);
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("object");
			//symbol_437.setMoniker("$ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_437.setType(symbol_99);  // $ocl!OrderedSet{T}?T
			
			symbol_435.getOwnedParameters().add(symbol_437);
			symbol_435.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_435);
		}
		{	// ocl::OrderedSet::intersection() $ocl!OrderedSet{T}!intersection($ocl!Set[T])
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("intersection");
			//symbol_438.setMoniker("$ocl!OrderedSet{T}!intersection($ocl!Set[T])");
			symbol_438.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_439 = PivotFactory.eINSTANCE.createParameter();
			symbol_439.setName("o");
			//symbol_439.setMoniker("$ocl!OrderedSet{T}!intersection($ocl!Set[T])!o");
			symbol_439.setType(symbol_217);  // $ocl!Set[$ocl!OrderedSet{T}?T]
			
			symbol_438.getOwnedParameters().add(symbol_439);
			symbol_438.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::OrderedSet::prepend() $ocl!OrderedSet{T}!prepend(T)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("prepend");
			//symbol_440.setMoniker("$ocl!OrderedSet{T}!prepend(T)");
			symbol_440.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("object");
			//symbol_441.setMoniker("$ocl!OrderedSet{T}!prepend(T)!object");
			symbol_441.setType(symbol_99);  // $ocl!OrderedSet{T}?T
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OrderedSet::reject() $ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_442 = PivotFactory.eINSTANCE.createIteration();
			symbol_442.setName("reject");
			//symbol_442.setMoniker("$ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_442.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("i");
			symbol_443.setType(symbol_99);  // $ocl!OrderedSet{T}?T
			symbol_442.getOwnedIterators().add(symbol_443);
			Parameter symbol_444 = PivotFactory.eINSTANCE.createParameter();
			symbol_444.setName("body");
			//symbol_444.setMoniker("$ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_444.setType(symbol_244);  // Lambda~$ocl!OrderedSet{T}?T()Boolean
			
			symbol_442.getOwnedParameters().add(symbol_444);
			symbol_442.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::OrderedSet::reverse() $ocl!OrderedSet{T}!reverse()
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("reverse");
			//symbol_445.setMoniker("$ocl!OrderedSet{T}!reverse()");
			symbol_445.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			symbol_445.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::OrderedSet::select() $ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_446 = PivotFactory.eINSTANCE.createIteration();
			symbol_446.setName("select");
			//symbol_446.setMoniker("$ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_446.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_447 = PivotFactory.eINSTANCE.createParameter();
			symbol_447.setName("i");
			symbol_447.setType(symbol_99);  // $ocl!OrderedSet{T}?T
			symbol_446.getOwnedIterators().add(symbol_447);
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("body");
			//symbol_448.setMoniker("$ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_448.setType(symbol_244);  // Lambda~$ocl!OrderedSet{T}?T()Boolean
			
			symbol_446.getOwnedParameters().add(symbol_448);
			symbol_446.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_446.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_446);
		}
		{	// ocl::OrderedSet::subOrderedSet() $ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_449 = PivotFactory.eINSTANCE.createOperation();
			symbol_449.setName("subOrderedSet");
			//symbol_449.setMoniker("$ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_449.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("lower");
			//symbol_450.setMoniker("$ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_450.setType(symbol_123);  // Integer
			
			symbol_449.getOwnedParameters().add(symbol_450);
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("upper");
			//symbol_451.setMoniker("$ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_451.setType(symbol_123);  // Integer
			
			symbol_449.getOwnedParameters().add(symbol_451);
			symbol_449.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation");
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_449);
		}
		{	// ocl::OrderedSet::symmetricDifference() $ocl!OrderedSet{T}!symmetricDifference($ocl!Set[$ocl!OclAny])
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_452.setName("symmetricDifference");
			//symbol_452.setMoniker("$ocl!OrderedSet{T}!symmetricDifference($ocl!Set[$ocl!OclAny])");
			symbol_452.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("s");
			//symbol_453.setMoniker("$ocl!OrderedSet{T}!symmetricDifference($ocl!Set[$ocl!OclAny])!s");
			symbol_453.setType(symbol_215);  // $ocl!Set[$ocl!OclAny]
			
			symbol_452.getOwnedParameters().add(symbol_453);
			symbol_452.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OrderedSet::union() $ocl!OrderedSet{T}!union($ocl!OrderedSet[T])
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("union");
			//symbol_454.setMoniker("$ocl!OrderedSet{T}!union($ocl!OrderedSet[T])");
			symbol_454.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_455 = PivotFactory.eINSTANCE.createParameter();
			symbol_455.setName("o");
			//symbol_455.setMoniker("$ocl!OrderedSet{T}!union($ocl!OrderedSet[T])!o");
			symbol_455.setType(symbol_203);  // $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
			
			symbol_454.getOwnedParameters().add(symbol_455);
			symbol_454.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::OrderedSet::union() $ocl!OrderedSet{T}!union($ocl!Set[T])
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_456.setName("union");
			//symbol_456.setMoniker("$ocl!OrderedSet{T}!union($ocl!Set[T])");
			symbol_456.setType(symbol_217);  // $ocl!Set[$ocl!OrderedSet{T}?T]
			
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("s");
			//symbol_457.setMoniker("$ocl!OrderedSet{T}!union($ocl!Set[T])!s");
			symbol_457.setType(symbol_217);  // $ocl!Set[$ocl!OrderedSet{T}?T]
			
			symbol_456.getOwnedParameters().add(symbol_457);
			symbol_456.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_456);
		}
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// ocl::Sequence $ocl!Sequence{T}
		//
		symbol_103.setName("Sequence");
		//symbol_103.setMoniker("$ocl!Sequence{T}");
		symbol_103.setElementType(symbol_106);
		symbol_106.setName("T");
		symbol_105.setOwnedParameteredElement(symbol_106);
		symbol_104.getOwnedParameters().add(symbol_105);
		
		symbol_103.setOwnedTemplateSignature(symbol_104);
		symbol_103.getSuperClasses().add(symbol_188); // $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		symbol_103.getSuperClasses().add(symbol_197); // $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() $ocl!Sequence{T}!<>($ocl!OclSelf)
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("<>");
			//symbol_458.setMoniker("$ocl!Sequence{T}!<>($ocl!OclSelf)");
			symbol_458.setType(symbol_122);  // Boolean
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("object2");
			//symbol_459.setMoniker("$ocl!Sequence{T}!<>($ocl!OclSelf)!object2");
			symbol_459.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_458.getOwnedParameters().add(symbol_459);
			symbol_458.setPrecedence(symbol_7);
			symbol_458.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::Sequence::=() $ocl!Sequence{T}!=($ocl!OclSelf)
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("=");
			//symbol_460.setMoniker("$ocl!Sequence{T}!=($ocl!OclSelf)");
			symbol_460.setType(symbol_122);  // Boolean
			
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("object2");
			//symbol_461.setMoniker("$ocl!Sequence{T}!=($ocl!OclSelf)!object2");
			symbol_461.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_460.getOwnedParameters().add(symbol_461);
			symbol_460.setPrecedence(symbol_7);
			symbol_460.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::Sequence::append() $ocl!Sequence{T}!append(T)
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("append");
			//symbol_462.setMoniker("$ocl!Sequence{T}!append(T)");
			symbol_462.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_463 = PivotFactory.eINSTANCE.createParameter();
			symbol_463.setName("object");
			//symbol_463.setMoniker("$ocl!Sequence{T}!append(T)!object");
			symbol_463.setType(symbol_106);  // $ocl!Sequence{T}?T
			
			symbol_462.getOwnedParameters().add(symbol_463);
			symbol_462.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::Sequence::excluding() $ocl!Sequence{T}!excluding($ocl!OclAny)
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("excluding");
			//symbol_464.setMoniker("$ocl!Sequence{T}!excluding($ocl!OclAny)");
			symbol_464.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("object");
			//symbol_465.setMoniker("$ocl!Sequence{T}!excluding($ocl!OclAny)!object");
			symbol_465.setType(symbol_69);  // $ocl!OclAny
			
			symbol_464.getOwnedParameters().add(symbol_465);
			symbol_464.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::Sequence::flatten() $ocl!Sequence{T}!flatten{T2}()
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_109.setName("T2");
			symbol_108.setOwnedParameteredElement(symbol_109);
			symbol_107.getOwnedParameters().add(symbol_108);
			
			symbol_466.setOwnedTemplateSignature(symbol_107);
			symbol_466.setName("flatten");
			//symbol_466.setMoniker("$ocl!Sequence{T}!flatten{T2}()");
			symbol_466.setType(symbol_209);  // $ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]
			
			symbol_466.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::Sequence::including() $ocl!Sequence{T}!including(T)
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("including");
			//symbol_467.setMoniker("$ocl!Sequence{T}!including(T)");
			symbol_467.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("object");
			//symbol_468.setMoniker("$ocl!Sequence{T}!including(T)!object");
			symbol_468.setType(symbol_106);  // $ocl!Sequence{T}?T
			
			symbol_467.getOwnedParameters().add(symbol_468);
			symbol_467.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::Sequence::insertAt() $ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("insertAt");
			//symbol_469.setMoniker("$ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_469.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("index");
			//symbol_470.setMoniker("$ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_470.setType(symbol_123);  // Integer
			
			symbol_469.getOwnedParameters().add(symbol_470);
			Parameter symbol_471 = PivotFactory.eINSTANCE.createParameter();
			symbol_471.setName("object");
			//symbol_471.setMoniker("$ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_471.setType(symbol_106);  // $ocl!Sequence{T}?T
			
			symbol_469.getOwnedParameters().add(symbol_471);
			symbol_469.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::Sequence::prepend() $ocl!Sequence{T}!prepend(T)
			Operation symbol_472 = PivotFactory.eINSTANCE.createOperation();
			symbol_472.setName("prepend");
			//symbol_472.setMoniker("$ocl!Sequence{T}!prepend(T)");
			symbol_472.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_473 = PivotFactory.eINSTANCE.createParameter();
			symbol_473.setName("object");
			//symbol_473.setMoniker("$ocl!Sequence{T}!prepend(T)!object");
			symbol_473.setType(symbol_106);  // $ocl!Sequence{T}?T
			
			symbol_472.getOwnedParameters().add(symbol_473);
			symbol_472.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_472.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_472);
		}
		{	// ocl::Sequence::reject() $ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_474 = PivotFactory.eINSTANCE.createIteration();
			symbol_474.setName("reject");
			//symbol_474.setMoniker("$ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_474.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_475 = PivotFactory.eINSTANCE.createParameter();
			symbol_475.setName("i");
			symbol_475.setType(symbol_106);  // $ocl!Sequence{T}?T
			symbol_474.getOwnedIterators().add(symbol_475);
			Parameter symbol_476 = PivotFactory.eINSTANCE.createParameter();
			symbol_476.setName("body");
			//symbol_476.setMoniker("$ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_476.setType(symbol_245);  // Lambda~$ocl!Sequence{T}?T()Boolean
			
			symbol_474.getOwnedParameters().add(symbol_476);
			symbol_474.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_474.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_474);
		}
		{	// ocl::Sequence::reverse() $ocl!Sequence{T}!reverse()
			Operation symbol_477 = PivotFactory.eINSTANCE.createOperation();
			symbol_477.setName("reverse");
			//symbol_477.setMoniker("$ocl!Sequence{T}!reverse()");
			symbol_477.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			symbol_477.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_477.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_477);
		}
		{	// ocl::Sequence::select() $ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_478 = PivotFactory.eINSTANCE.createIteration();
			symbol_478.setName("select");
			//symbol_478.setMoniker("$ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_478.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("i");
			symbol_479.setType(symbol_106);  // $ocl!Sequence{T}?T
			symbol_478.getOwnedIterators().add(symbol_479);
			Parameter symbol_480 = PivotFactory.eINSTANCE.createParameter();
			symbol_480.setName("body");
			//symbol_480.setMoniker("$ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_480.setType(symbol_245);  // Lambda~$ocl!Sequence{T}?T()Boolean
			
			symbol_478.getOwnedParameters().add(symbol_480);
			symbol_478.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::Sequence::subSequence() $ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_481 = PivotFactory.eINSTANCE.createOperation();
			symbol_481.setName("subSequence");
			//symbol_481.setMoniker("$ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_481.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("lower");
			//symbol_482.setMoniker("$ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_482.setType(symbol_123);  // Integer
			
			symbol_481.getOwnedParameters().add(symbol_482);
			Parameter symbol_483 = PivotFactory.eINSTANCE.createParameter();
			symbol_483.setName("upper");
			//symbol_483.setMoniker("$ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_483.setType(symbol_123);  // Integer
			
			symbol_481.getOwnedParameters().add(symbol_483);
			symbol_481.setImplementationClass("org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation");
			symbol_481.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_481);
		}
		{	// ocl::Sequence::union() $ocl!Sequence{T}!union($ocl!Sequence[T])
			Operation symbol_484 = PivotFactory.eINSTANCE.createOperation();
			symbol_484.setName("union");
			//symbol_484.setMoniker("$ocl!Sequence{T}!union($ocl!Sequence[T])");
			symbol_484.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			Parameter symbol_485 = PivotFactory.eINSTANCE.createParameter();
			symbol_485.setName("s");
			//symbol_485.setMoniker("$ocl!Sequence{T}!union($ocl!Sequence[T])!s");
			symbol_485.setType(symbol_210);  // $ocl!Sequence[$ocl!Sequence{T}?T]
			
			symbol_484.getOwnedParameters().add(symbol_485);
			symbol_484.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_484.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_484);
		}
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// ocl::Set $ocl!Set{T}
		//
		symbol_110.setName("Set");
		//symbol_110.setMoniker("$ocl!Set{T}");
		symbol_110.setElementType(symbol_113);
		symbol_113.setName("T");
		symbol_112.setOwnedParameteredElement(symbol_113);
		symbol_111.getOwnedParameters().add(symbol_112);
		
		symbol_110.setOwnedTemplateSignature(symbol_111);
		symbol_110.getSuperClasses().add(symbol_178); // $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		symbol_110.getSuperClasses().add(symbol_230); // $ocl!UniqueCollection[$ocl!Set{T}?T]
		{	// ocl::Set::-() $ocl!Set{T}!-($ocl!Set[$ocl!OclAny])
			Operation symbol_486 = PivotFactory.eINSTANCE.createOperation();
			symbol_486.setName("-");
			//symbol_486.setMoniker("$ocl!Set{T}!-($ocl!Set[$ocl!OclAny])");
			symbol_486.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("s");
			//symbol_487.setMoniker("$ocl!Set{T}!-($ocl!Set[$ocl!OclAny])!s");
			symbol_487.setType(symbol_215);  // $ocl!Set[$ocl!OclAny]
			
			symbol_486.getOwnedParameters().add(symbol_487);
			symbol_486.setPrecedence(symbol_5);
			symbol_486.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_486.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_486);
		}
		{	// ocl::Set::<>() $ocl!Set{T}!<>($ocl!OclSelf)
			Operation symbol_488 = PivotFactory.eINSTANCE.createOperation();
			symbol_488.setName("<>");
			//symbol_488.setMoniker("$ocl!Set{T}!<>($ocl!OclSelf)");
			symbol_488.setType(symbol_122);  // Boolean
			
			Parameter symbol_489 = PivotFactory.eINSTANCE.createParameter();
			symbol_489.setName("object2");
			//symbol_489.setMoniker("$ocl!Set{T}!<>($ocl!OclSelf)!object2");
			symbol_489.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_488.getOwnedParameters().add(symbol_489);
			symbol_488.setPrecedence(symbol_7);
			symbol_488.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::Set::=() $ocl!Set{T}!=($ocl!OclSelf)
			Operation symbol_490 = PivotFactory.eINSTANCE.createOperation();
			symbol_490.setName("=");
			//symbol_490.setMoniker("$ocl!Set{T}!=($ocl!OclSelf)");
			symbol_490.setType(symbol_122);  // Boolean
			
			Parameter symbol_491 = PivotFactory.eINSTANCE.createParameter();
			symbol_491.setName("object2");
			//symbol_491.setMoniker("$ocl!Set{T}!=($ocl!OclSelf)!object2");
			symbol_491.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_490.getOwnedParameters().add(symbol_491);
			symbol_490.setPrecedence(symbol_7);
			symbol_490.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_490.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_490);
		}
		{	// ocl::Set::excluding() $ocl!Set{T}!excluding($ocl!OclAny)
			Operation symbol_492 = PivotFactory.eINSTANCE.createOperation();
			symbol_492.setName("excluding");
			//symbol_492.setMoniker("$ocl!Set{T}!excluding($ocl!OclAny)");
			symbol_492.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("object");
			//symbol_493.setMoniker("$ocl!Set{T}!excluding($ocl!OclAny)!object");
			symbol_493.setType(symbol_69);  // $ocl!OclAny
			
			symbol_492.getOwnedParameters().add(symbol_493);
			symbol_492.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_492.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_492);
		}
		{	// ocl::Set::flatten() $ocl!Set{T}!flatten{T2}()
			Operation symbol_494 = PivotFactory.eINSTANCE.createOperation();
			symbol_116.setName("T2");
			symbol_115.setOwnedParameteredElement(symbol_116);
			symbol_114.getOwnedParameters().add(symbol_115);
			
			symbol_494.setOwnedTemplateSignature(symbol_114);
			symbol_494.setName("flatten");
			//symbol_494.setMoniker("$ocl!Set{T}!flatten{T2}()");
			symbol_494.setType(symbol_218);  // $ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]
			
			symbol_494.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_494.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_494);
		}
		{	// ocl::Set::including() $ocl!Set{T}!including(T)
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("including");
			//symbol_495.setMoniker("$ocl!Set{T}!including(T)");
			symbol_495.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_496 = PivotFactory.eINSTANCE.createParameter();
			symbol_496.setName("object");
			//symbol_496.setMoniker("$ocl!Set{T}!including(T)!object");
			symbol_496.setType(symbol_113);  // $ocl!Set{T}?T
			
			symbol_495.getOwnedParameters().add(symbol_496);
			symbol_495.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::Set::intersection() $ocl!Set{T}!intersection($ocl!Set[T])
			Operation symbol_497 = PivotFactory.eINSTANCE.createOperation();
			symbol_497.setName("intersection");
			//symbol_497.setMoniker("$ocl!Set{T}!intersection($ocl!Set[T])");
			symbol_497.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_498 = PivotFactory.eINSTANCE.createParameter();
			symbol_498.setName("s");
			//symbol_498.setMoniker("$ocl!Set{T}!intersection($ocl!Set[T])!s");
			symbol_498.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			symbol_497.getOwnedParameters().add(symbol_498);
			symbol_497.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_497.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_497);
		}
		{	// ocl::Set::reject() $ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_499 = PivotFactory.eINSTANCE.createIteration();
			symbol_499.setName("reject");
			//symbol_499.setMoniker("$ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_499.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("i");
			symbol_500.setType(symbol_113);  // $ocl!Set{T}?T
			symbol_499.getOwnedIterators().add(symbol_500);
			Parameter symbol_501 = PivotFactory.eINSTANCE.createParameter();
			symbol_501.setName("body");
			//symbol_501.setMoniker("$ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_501.setType(symbol_246);  // Lambda~$ocl!Set{T}?T()Boolean
			
			symbol_499.getOwnedParameters().add(symbol_501);
			symbol_499.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_499.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_499);
		}
		{	// ocl::Set::select() $ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_502 = PivotFactory.eINSTANCE.createIteration();
			symbol_502.setName("select");
			//symbol_502.setMoniker("$ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_502.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_503 = PivotFactory.eINSTANCE.createParameter();
			symbol_503.setName("i");
			symbol_503.setType(symbol_113);  // $ocl!Set{T}?T
			symbol_502.getOwnedIterators().add(symbol_503);
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("body");
			//symbol_504.setMoniker("$ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_504.setType(symbol_246);  // Lambda~$ocl!Set{T}?T()Boolean
			
			symbol_502.getOwnedParameters().add(symbol_504);
			symbol_502.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_502.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_502);
		}
		{	// ocl::Set::symmetricDifference() $ocl!Set{T}!symmetricDifference($ocl!Set[$ocl!OclAny])
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("symmetricDifference");
			//symbol_505.setMoniker("$ocl!Set{T}!symmetricDifference($ocl!Set[$ocl!OclAny])");
			symbol_505.setType(symbol_219);  // $ocl!Set[$ocl!Set{T}?T]
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("s");
			//symbol_506.setMoniker("$ocl!Set{T}!symmetricDifference($ocl!Set[$ocl!OclAny])!s");
			symbol_506.setType(symbol_215);  // $ocl!Set[$ocl!OclAny]
			
			symbol_505.getOwnedParameters().add(symbol_506);
			symbol_505.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_110.getOwnedOperations().add(symbol_505);
		}
		symbol_1.getOwnedTypes().add(symbol_110);
		//
		// ocl::Tuple $ocl!Tuple
		//
		symbol_117.setName("Tuple");
		//symbol_117.setMoniker("$ocl!Tuple");
		symbol_117.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_117);
		//
		// ocl::UniqueCollection $ocl!UniqueCollection{T}
		//
		symbol_118.setName("UniqueCollection");
		//symbol_118.setMoniker("$ocl!UniqueCollection{T}");
		symbol_118.setElementType(symbol_121);
		symbol_121.setName("T");
		symbol_120.setOwnedParameteredElement(symbol_121);
		symbol_119.getOwnedParameters().add(symbol_120);
		
		symbol_118.setOwnedTemplateSignature(symbol_119);
		symbol_118.getSuperClasses().add(symbol_166); // $ocl!Collection[$ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() $ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)
			Iteration symbol_507 = PivotFactory.eINSTANCE.createIteration();
			symbol_507.setName("sortedBy");
			//symbol_507.setMoniker("$ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)");
			symbol_507.setType(symbol_204);  // $ocl!OrderedSet[$ocl!UniqueCollection{T}?T]
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("i");
			symbol_508.setType(symbol_121);  // $ocl!UniqueCollection{T}?T
			symbol_507.getOwnedIterators().add(symbol_508);
			Parameter symbol_509 = PivotFactory.eINSTANCE.createParameter();
			symbol_509.setName("body");
			//symbol_509.setMoniker("$ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()$ocl!OclAny)!body");
			symbol_509.setType(symbol_247);  // Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny
			
			symbol_507.getOwnedParameters().add(symbol_509);
			symbol_507.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_507);
		}
		symbol_1.getOwnedTypes().add(symbol_118);
		//
		// ocl::Boolean Boolean
		//
		symbol_122.setName("Boolean");
		//symbol_122.setMoniker("Boolean");
		symbol_122.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>($ocl!OclSelf)
			Operation symbol_510 = PivotFactory.eINSTANCE.createOperation();
			symbol_510.setName("<>");
			//symbol_510.setMoniker("Boolean!<>($ocl!OclSelf)");
			symbol_510.setType(symbol_122);  // Boolean
			
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("object2");
			//symbol_511.setMoniker("Boolean!<>($ocl!OclSelf)!object2");
			symbol_511.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_510.getOwnedParameters().add(symbol_511);
			symbol_510.setPrecedence(symbol_7);
			symbol_510.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::Boolean::=() Boolean!=($ocl!OclSelf)
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("=");
			//symbol_512.setMoniker("Boolean!=($ocl!OclSelf)");
			symbol_512.setType(symbol_122);  // Boolean
			
			Parameter symbol_513 = PivotFactory.eINSTANCE.createParameter();
			symbol_513.setName("object2");
			//symbol_513.setMoniker("Boolean!=($ocl!OclSelf)!object2");
			symbol_513.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_512.getOwnedParameters().add(symbol_513);
			symbol_512.setPrecedence(symbol_7);
			symbol_512.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_512);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances()
			Operation symbol_514 = PivotFactory.eINSTANCE.createOperation();
			symbol_514.setName("allInstances");
			//symbol_514.setMoniker("Boolean!allInstances()");
			symbol_514.setType(symbol_216);  // $ocl!Set[$ocl!OclSelf]
			
			symbol_514.setIsStatic(true);
			symbol_514.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation");
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_515 = PivotFactory.eINSTANCE.createOperation();
			symbol_515.setName("and");
			//symbol_515.setMoniker("Boolean!and(Boolean)");
			symbol_515.setType(symbol_122);  // Boolean
			
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("b");
			//symbol_516.setMoniker("Boolean!and(Boolean)!b");
			symbol_516.setType(symbol_122);  // Boolean
			
			symbol_515.getOwnedParameters().add(symbol_516);
			symbol_515.setPrecedence(symbol_8);
			symbol_515.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAndOperation");
			symbol_515.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_515);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("implies");
			//symbol_517.setMoniker("Boolean!implies(Boolean)");
			symbol_517.setType(symbol_122);  // Boolean
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("b");
			//symbol_518.setMoniker("Boolean!implies(Boolean)!b");
			symbol_518.setType(symbol_122);  // Boolean
			
			symbol_517.getOwnedParameters().add(symbol_518);
			symbol_517.setPrecedence(symbol_11);
			symbol_517.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation");
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_519 = PivotFactory.eINSTANCE.createOperation();
			symbol_519.setName("not");
			//symbol_519.setMoniker("Boolean!not()");
			symbol_519.setType(symbol_122);  // Boolean
			
			symbol_519.setPrecedence(symbol_3);
			symbol_519.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanNotOperation");
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_520 = PivotFactory.eINSTANCE.createOperation();
			symbol_520.setName("or");
			//symbol_520.setMoniker("Boolean!or(Boolean)");
			symbol_520.setType(symbol_122);  // Boolean
			
			Parameter symbol_521 = PivotFactory.eINSTANCE.createParameter();
			symbol_521.setName("b");
			//symbol_521.setMoniker("Boolean!or(Boolean)!b");
			symbol_521.setType(symbol_122);  // Boolean
			
			symbol_520.getOwnedParameters().add(symbol_521);
			symbol_520.setPrecedence(symbol_9);
			symbol_520.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanOrOperation");
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("toString");
			//symbol_522.setMoniker("Boolean!toString()");
			symbol_522.setType(symbol_128);  // String
			
			symbol_522.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("xor");
			//symbol_523.setMoniker("Boolean!xor(Boolean)");
			symbol_523.setType(symbol_122);  // Boolean
			
			Parameter symbol_524 = PivotFactory.eINSTANCE.createParameter();
			symbol_524.setName("b");
			//symbol_524.setMoniker("Boolean!xor(Boolean)!b");
			symbol_524.setType(symbol_122);  // Boolean
			
			symbol_523.getOwnedParameters().add(symbol_524);
			symbol_523.setPrecedence(symbol_10);
			symbol_523.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanXorOperation");
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_122.getOwnedOperations().add(symbol_523);
		}
		symbol_1.getOwnedTypes().add(symbol_122);
		//
		// ocl::Integer Integer
		//
		symbol_123.setName("Integer");
		//symbol_123.setMoniker("Integer");
		symbol_123.getSuperClasses().add(symbol_124); // Real
		{	// ocl::Integer::*() Integer!*($ocl!OclSelf)
			Operation symbol_525 = PivotFactory.eINSTANCE.createOperation();
			symbol_525.setName("*");
			//symbol_525.setMoniker("Integer!*($ocl!OclSelf)");
			symbol_525.setType(symbol_123);  // Integer
			
			Parameter symbol_526 = PivotFactory.eINSTANCE.createParameter();
			symbol_526.setName("i");
			//symbol_526.setMoniker("Integer!*($ocl!OclSelf)!i");
			symbol_526.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_525.getOwnedParameters().add(symbol_526);
			symbol_525.setPrecedence(symbol_4);
			symbol_525.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_525.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_525);
		}
		{	// ocl::Integer::+() Integer!+($ocl!OclSelf)
			Operation symbol_527 = PivotFactory.eINSTANCE.createOperation();
			symbol_527.setName("+");
			//symbol_527.setMoniker("Integer!+($ocl!OclSelf)");
			symbol_527.setType(symbol_123);  // Integer
			
			Parameter symbol_528 = PivotFactory.eINSTANCE.createParameter();
			symbol_528.setName("i");
			//symbol_528.setMoniker("Integer!+($ocl!OclSelf)!i");
			symbol_528.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_527.getOwnedParameters().add(symbol_528);
			symbol_527.setPrecedence(symbol_5);
			symbol_527.setImplementationClass("org.eclipse.ocl.examples.library.integer.IntegerPlusOperation");
			symbol_527.setImplementation(org.eclipse.ocl.examples.library.integer.IntegerPlusOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_527);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_529 = PivotFactory.eINSTANCE.createOperation();
			symbol_529.setName("-");
			//symbol_529.setMoniker("Integer!-()");
			symbol_529.setType(symbol_123);  // Integer
			
			symbol_529.setPrecedence(symbol_3);
			symbol_529.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_529.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_529);
		}
		{	// ocl::Integer::-() Integer!-($ocl!OclSelf)
			Operation symbol_530 = PivotFactory.eINSTANCE.createOperation();
			symbol_530.setName("-");
			//symbol_530.setMoniker("Integer!-($ocl!OclSelf)");
			symbol_530.setType(symbol_123);  // Integer
			
			Parameter symbol_531 = PivotFactory.eINSTANCE.createParameter();
			symbol_531.setName("i");
			//symbol_531.setMoniker("Integer!-($ocl!OclSelf)!i");
			symbol_531.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_530.getOwnedParameters().add(symbol_531);
			symbol_530.setPrecedence(symbol_5);
			symbol_530.setImplementationClass("org.eclipse.ocl.examples.library.integer.IntegerMinusOperation");
			symbol_530.setImplementation(org.eclipse.ocl.examples.library.integer.IntegerMinusOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_530);
		}
		{	// ocl::Integer::/() Integer!/($ocl!OclSelf)
			Operation symbol_532 = PivotFactory.eINSTANCE.createOperation();
			symbol_532.setName("/");
			//symbol_532.setMoniker("Integer!/($ocl!OclSelf)");
			symbol_532.setType(symbol_124);  // Real
			
			Parameter symbol_533 = PivotFactory.eINSTANCE.createParameter();
			symbol_533.setName("i");
			//symbol_533.setMoniker("Integer!/($ocl!OclSelf)!i");
			symbol_533.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_532.getOwnedParameters().add(symbol_533);
			symbol_532.setPrecedence(symbol_4);
			symbol_532.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_532.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_532);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_534 = PivotFactory.eINSTANCE.createOperation();
			symbol_534.setName("abs");
			//symbol_534.setMoniker("Integer!abs()");
			symbol_534.setType(symbol_123);  // Integer
			
			symbol_534.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_534.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_534);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_535 = PivotFactory.eINSTANCE.createOperation();
			symbol_535.setName("div");
			//symbol_535.setMoniker("Integer!div(Integer)");
			symbol_535.setType(symbol_123);  // Integer
			
			Parameter symbol_536 = PivotFactory.eINSTANCE.createParameter();
			symbol_536.setName("i");
			//symbol_536.setMoniker("Integer!div(Integer)!i");
			symbol_536.setType(symbol_123);  // Integer
			
			symbol_535.getOwnedParameters().add(symbol_536);
			symbol_535.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivOperation");
			symbol_535.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_535);
		}
		{	// ocl::Integer::max() Integer!max($ocl!OclSelf)
			Operation symbol_537 = PivotFactory.eINSTANCE.createOperation();
			symbol_537.setName("max");
			//symbol_537.setMoniker("Integer!max($ocl!OclSelf)");
			symbol_537.setType(symbol_123);  // Integer
			
			Parameter symbol_538 = PivotFactory.eINSTANCE.createParameter();
			symbol_538.setName("i");
			//symbol_538.setMoniker("Integer!max($ocl!OclSelf)!i");
			symbol_538.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_537.getOwnedParameters().add(symbol_538);
			symbol_537.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_537.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_537);
		}
		{	// ocl::Integer::min() Integer!min($ocl!OclSelf)
			Operation symbol_539 = PivotFactory.eINSTANCE.createOperation();
			symbol_539.setName("min");
			//symbol_539.setMoniker("Integer!min($ocl!OclSelf)");
			symbol_539.setType(symbol_123);  // Integer
			
			Parameter symbol_540 = PivotFactory.eINSTANCE.createParameter();
			symbol_540.setName("i");
			//symbol_540.setMoniker("Integer!min($ocl!OclSelf)!i");
			symbol_540.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_539.getOwnedParameters().add(symbol_540);
			symbol_539.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_539.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_539);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("mod");
			//symbol_541.setMoniker("Integer!mod(Integer)");
			symbol_541.setType(symbol_123);  // Integer
			
			Parameter symbol_542 = PivotFactory.eINSTANCE.createParameter();
			symbol_542.setName("i");
			//symbol_542.setMoniker("Integer!mod(Integer)!i");
			symbol_542.setType(symbol_123);  // Integer
			
			symbol_541.getOwnedParameters().add(symbol_542);
			symbol_541.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericModOperation");
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_543 = PivotFactory.eINSTANCE.createOperation();
			symbol_543.setName("toString");
			//symbol_543.setMoniker("Integer!toString()");
			symbol_543.setType(symbol_128);  // String
			
			symbol_543.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_543);
		}
		symbol_1.getOwnedTypes().add(symbol_123);
		//
		// ocl::Real Real
		//
		symbol_124.setName("Real");
		//symbol_124.setMoniker("Real");
		symbol_124.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::Real::*() Real!*($ocl!OclSelf)
			Operation symbol_544 = PivotFactory.eINSTANCE.createOperation();
			symbol_544.setName("*");
			//symbol_544.setMoniker("Real!*($ocl!OclSelf)");
			symbol_544.setType(symbol_124);  // Real
			
			Parameter symbol_545 = PivotFactory.eINSTANCE.createParameter();
			symbol_545.setName("r");
			//symbol_545.setMoniker("Real!*($ocl!OclSelf)!r");
			symbol_545.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_544.getOwnedParameters().add(symbol_545);
			symbol_544.setPrecedence(symbol_4);
			symbol_544.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_544.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_544);
		}
		{	// ocl::Real::+() Real!+($ocl!OclSelf)
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("+");
			//symbol_546.setMoniker("Real!+($ocl!OclSelf)");
			symbol_546.setType(symbol_124);  // Real
			
			Parameter symbol_547 = PivotFactory.eINSTANCE.createParameter();
			symbol_547.setName("r");
			//symbol_547.setMoniker("Real!+($ocl!OclSelf)!r");
			symbol_547.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_546.getOwnedParameters().add(symbol_547);
			symbol_546.setPrecedence(symbol_5);
			symbol_546.setImplementationClass("org.eclipse.ocl.examples.library.real.RealPlusOperation");
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.real.RealPlusOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_546);
		}
		{	// ocl::Real::-() Real!-($ocl!OclSelf)
			Operation symbol_548 = PivotFactory.eINSTANCE.createOperation();
			symbol_548.setName("-");
			//symbol_548.setMoniker("Real!-($ocl!OclSelf)");
			symbol_548.setType(symbol_124);  // Real
			
			Parameter symbol_549 = PivotFactory.eINSTANCE.createParameter();
			symbol_549.setName("r");
			//symbol_549.setMoniker("Real!-($ocl!OclSelf)!r");
			symbol_549.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_548.getOwnedParameters().add(symbol_549);
			symbol_548.setPrecedence(symbol_5);
			symbol_548.setImplementationClass("org.eclipse.ocl.examples.library.real.RealMinusOperation");
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.real.RealMinusOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_550 = PivotFactory.eINSTANCE.createOperation();
			symbol_550.setName("-");
			//symbol_550.setMoniker("Real!-()");
			symbol_550.setType(symbol_124);  // Real
			
			symbol_550.setPrecedence(symbol_3);
			symbol_550.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_550.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_550);
		}
		{	// ocl::Real::/() Real!/($ocl!OclSelf)
			Operation symbol_551 = PivotFactory.eINSTANCE.createOperation();
			symbol_551.setName("/");
			//symbol_551.setMoniker("Real!/($ocl!OclSelf)");
			symbol_551.setType(symbol_124);  // Real
			
			Parameter symbol_552 = PivotFactory.eINSTANCE.createParameter();
			symbol_552.setName("r");
			//symbol_552.setMoniker("Real!/($ocl!OclSelf)!r");
			symbol_552.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_551.getOwnedParameters().add(symbol_552);
			symbol_551.setPrecedence(symbol_4);
			symbol_551.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_551.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_551);
		}
		{	// ocl::Real::<() Real!<($ocl!OclSelf)
			Operation symbol_553 = PivotFactory.eINSTANCE.createOperation();
			symbol_553.setName("<");
			//symbol_553.setMoniker("Real!<($ocl!OclSelf)");
			symbol_553.setType(symbol_122);  // Boolean
			
			Parameter symbol_554 = PivotFactory.eINSTANCE.createParameter();
			symbol_554.setName("r");
			//symbol_554.setMoniker("Real!<($ocl!OclSelf)!r");
			symbol_554.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_553.getOwnedParameters().add(symbol_554);
			symbol_553.setPrecedence(symbol_6);
			symbol_553.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation");
			symbol_553.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_553);
		}
		{	// ocl::Real::<=() Real!<=($ocl!OclSelf)
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("<=");
			//symbol_555.setMoniker("Real!<=($ocl!OclSelf)");
			symbol_555.setType(symbol_122);  // Boolean
			
			Parameter symbol_556 = PivotFactory.eINSTANCE.createParameter();
			symbol_556.setName("r");
			//symbol_556.setMoniker("Real!<=($ocl!OclSelf)!r");
			symbol_556.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_555.getOwnedParameters().add(symbol_556);
			symbol_555.setPrecedence(symbol_6);
			symbol_555.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation");
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_555);
		}
		{	// ocl::Real::<>() Real!<>($ocl!OclSelf)
			Operation symbol_557 = PivotFactory.eINSTANCE.createOperation();
			symbol_557.setName("<>");
			//symbol_557.setMoniker("Real!<>($ocl!OclSelf)");
			symbol_557.setType(symbol_122);  // Boolean
			
			Parameter symbol_558 = PivotFactory.eINSTANCE.createParameter();
			symbol_558.setName("object2");
			//symbol_558.setMoniker("Real!<>($ocl!OclSelf)!object2");
			symbol_558.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_557.getOwnedParameters().add(symbol_558);
			symbol_557.setPrecedence(symbol_7);
			symbol_557.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_557.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_557);
		}
		{	// ocl::Real::=() Real!=($ocl!OclSelf)
			Operation symbol_559 = PivotFactory.eINSTANCE.createOperation();
			symbol_559.setName("=");
			//symbol_559.setMoniker("Real!=($ocl!OclSelf)");
			symbol_559.setType(symbol_122);  // Boolean
			
			Parameter symbol_560 = PivotFactory.eINSTANCE.createParameter();
			symbol_560.setName("object2");
			//symbol_560.setMoniker("Real!=($ocl!OclSelf)!object2");
			symbol_560.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_559.getOwnedParameters().add(symbol_560);
			symbol_559.setPrecedence(symbol_7);
			symbol_559.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_559.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_559);
		}
		{	// ocl::Real::>() Real!>($ocl!OclSelf)
			Operation symbol_561 = PivotFactory.eINSTANCE.createOperation();
			symbol_561.setName(">");
			//symbol_561.setMoniker("Real!>($ocl!OclSelf)");
			symbol_561.setType(symbol_122);  // Boolean
			
			Parameter symbol_562 = PivotFactory.eINSTANCE.createParameter();
			symbol_562.setName("r");
			//symbol_562.setMoniker("Real!>($ocl!OclSelf)!r");
			symbol_562.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_561.getOwnedParameters().add(symbol_562);
			symbol_561.setPrecedence(symbol_6);
			symbol_561.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation");
			symbol_561.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_561);
		}
		{	// ocl::Real::>=() Real!>=($ocl!OclSelf)
			Operation symbol_563 = PivotFactory.eINSTANCE.createOperation();
			symbol_563.setName(">=");
			//symbol_563.setMoniker("Real!>=($ocl!OclSelf)");
			symbol_563.setType(symbol_122);  // Boolean
			
			Parameter symbol_564 = PivotFactory.eINSTANCE.createParameter();
			symbol_564.setName("r");
			//symbol_564.setMoniker("Real!>=($ocl!OclSelf)!r");
			symbol_564.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_563.getOwnedParameters().add(symbol_564);
			symbol_563.setPrecedence(symbol_6);
			symbol_563.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation");
			symbol_563.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_563);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_565 = PivotFactory.eINSTANCE.createOperation();
			symbol_565.setName("abs");
			//symbol_565.setMoniker("Real!abs()");
			symbol_565.setType(symbol_124);  // Real
			
			symbol_565.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_565.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_565);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_566 = PivotFactory.eINSTANCE.createOperation();
			symbol_566.setName("floor");
			//symbol_566.setMoniker("Real!floor()");
			symbol_566.setType(symbol_123);  // Integer
			
			symbol_566.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericFloorOperation");
			symbol_566.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_566);
		}
		{	// ocl::Real::max() Real!max($ocl!OclSelf)
			Operation symbol_567 = PivotFactory.eINSTANCE.createOperation();
			symbol_567.setName("max");
			//symbol_567.setMoniker("Real!max($ocl!OclSelf)");
			symbol_567.setType(symbol_124);  // Real
			
			Parameter symbol_568 = PivotFactory.eINSTANCE.createParameter();
			symbol_568.setName("r");
			//symbol_568.setMoniker("Real!max($ocl!OclSelf)!r");
			symbol_568.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_567.getOwnedParameters().add(symbol_568);
			symbol_567.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_567.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_567);
		}
		{	// ocl::Real::min() Real!min($ocl!OclSelf)
			Operation symbol_569 = PivotFactory.eINSTANCE.createOperation();
			symbol_569.setName("min");
			//symbol_569.setMoniker("Real!min($ocl!OclSelf)");
			symbol_569.setType(symbol_124);  // Real
			
			Parameter symbol_570 = PivotFactory.eINSTANCE.createParameter();
			symbol_570.setName("r");
			//symbol_570.setMoniker("Real!min($ocl!OclSelf)!r");
			symbol_570.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_569.getOwnedParameters().add(symbol_570);
			symbol_569.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_569.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_569);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{TT}($ocl!Classifier[TT])
			Operation symbol_571 = PivotFactory.eINSTANCE.createOperation();
			symbol_127.setName("TT");
			symbol_126.setOwnedParameteredElement(symbol_127);
			symbol_125.getOwnedParameters().add(symbol_126);
			
			symbol_571.setOwnedTemplateSignature(symbol_125);
			symbol_571.setName("oclAsType");
			//symbol_571.setMoniker("Real!oclAsType{TT}($ocl!Classifier[TT])");
			symbol_571.setType(symbol_127);  // Real!oclAsType{TT}($ocl!Classifier[TT])?TT
			
			Parameter symbol_572 = PivotFactory.eINSTANCE.createParameter();
			symbol_572.setName("type");
			//symbol_572.setMoniker("Real!oclAsType{TT}($ocl!Classifier[TT])!type");
			symbol_572.setType(symbol_143);  // $ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]
			
			symbol_571.getOwnedParameters().add(symbol_572);
			symbol_571.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation");
			symbol_571.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_571);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_573 = PivotFactory.eINSTANCE.createOperation();
			symbol_573.setName("round");
			//symbol_573.setMoniker("Real!round()");
			symbol_573.setType(symbol_123);  // Integer
			
			symbol_573.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericRoundOperation");
			symbol_573.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_573);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_574 = PivotFactory.eINSTANCE.createOperation();
			symbol_574.setName("toString");
			//symbol_574.setMoniker("Real!toString()");
			symbol_574.setType(symbol_128);  // String
			
			symbol_574.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_574.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_124.getOwnedOperations().add(symbol_574);
		}
		symbol_1.getOwnedTypes().add(symbol_124);
		//
		// ocl::String String
		//
		symbol_128.setName("String");
		//symbol_128.setMoniker("String");
		symbol_128.getSuperClasses().add(symbol_69); // $ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_575 = PivotFactory.eINSTANCE.createOperation();
			symbol_575.setName("+");
			//symbol_575.setMoniker("String!+(String)");
			symbol_575.setType(symbol_128);  // String
			
			Parameter symbol_576 = PivotFactory.eINSTANCE.createParameter();
			symbol_576.setName("s");
			//symbol_576.setMoniker("String!+(String)!s");
			symbol_576.setType(symbol_128);  // String
			
			symbol_575.getOwnedParameters().add(symbol_576);
			symbol_575.setPrecedence(symbol_5);
			symbol_575.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_575.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_575);
		}
		{	// ocl::String::<() String!<($ocl!OclSelf)
			Operation symbol_577 = PivotFactory.eINSTANCE.createOperation();
			symbol_577.setName("<");
			//symbol_577.setMoniker("String!<($ocl!OclSelf)");
			symbol_577.setType(symbol_122);  // Boolean
			
			Parameter symbol_578 = PivotFactory.eINSTANCE.createParameter();
			symbol_578.setName("s");
			//symbol_578.setMoniker("String!<($ocl!OclSelf)!s");
			symbol_578.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_577.getOwnedParameters().add(symbol_578);
			symbol_577.setPrecedence(symbol_6);
			symbol_577.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanOperation");
			symbol_577.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_577);
		}
		{	// ocl::String::<=() String!<=($ocl!OclSelf)
			Operation symbol_579 = PivotFactory.eINSTANCE.createOperation();
			symbol_579.setName("<=");
			//symbol_579.setMoniker("String!<=($ocl!OclSelf)");
			symbol_579.setType(symbol_122);  // Boolean
			
			Parameter symbol_580 = PivotFactory.eINSTANCE.createParameter();
			symbol_580.setName("s");
			//symbol_580.setMoniker("String!<=($ocl!OclSelf)!s");
			symbol_580.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_579.getOwnedParameters().add(symbol_580);
			symbol_579.setPrecedence(symbol_6);
			symbol_579.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation");
			symbol_579.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_579);
		}
		{	// ocl::String::<>() String!<>($ocl!OclSelf)
			Operation symbol_581 = PivotFactory.eINSTANCE.createOperation();
			symbol_581.setName("<>");
			//symbol_581.setMoniker("String!<>($ocl!OclSelf)");
			symbol_581.setType(symbol_122);  // Boolean
			
			Parameter symbol_582 = PivotFactory.eINSTANCE.createParameter();
			symbol_582.setName("object2");
			//symbol_582.setMoniker("String!<>($ocl!OclSelf)!object2");
			symbol_582.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_581.getOwnedParameters().add(symbol_582);
			symbol_581.setPrecedence(symbol_7);
			symbol_581.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_581.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_581);
		}
		{	// ocl::String::=() String!=($ocl!OclSelf)
			Operation symbol_583 = PivotFactory.eINSTANCE.createOperation();
			symbol_583.setName("=");
			//symbol_583.setMoniker("String!=($ocl!OclSelf)");
			symbol_583.setType(symbol_122);  // Boolean
			
			Parameter symbol_584 = PivotFactory.eINSTANCE.createParameter();
			symbol_584.setName("object2");
			//symbol_584.setMoniker("String!=($ocl!OclSelf)!object2");
			symbol_584.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_583.getOwnedParameters().add(symbol_584);
			symbol_583.setPrecedence(symbol_7);
			symbol_583.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_583.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_583);
		}
		{	// ocl::String::>() String!>($ocl!OclSelf)
			Operation symbol_585 = PivotFactory.eINSTANCE.createOperation();
			symbol_585.setName(">");
			//symbol_585.setMoniker("String!>($ocl!OclSelf)");
			symbol_585.setType(symbol_122);  // Boolean
			
			Parameter symbol_586 = PivotFactory.eINSTANCE.createParameter();
			symbol_586.setName("s");
			//symbol_586.setMoniker("String!>($ocl!OclSelf)!s");
			symbol_586.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_585.getOwnedParameters().add(symbol_586);
			symbol_585.setPrecedence(symbol_6);
			symbol_585.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanOperation");
			symbol_585.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_585);
		}
		{	// ocl::String::>=() String!>=($ocl!OclSelf)
			Operation symbol_587 = PivotFactory.eINSTANCE.createOperation();
			symbol_587.setName(">=");
			//symbol_587.setMoniker("String!>=($ocl!OclSelf)");
			symbol_587.setType(symbol_122);  // Boolean
			
			Parameter symbol_588 = PivotFactory.eINSTANCE.createParameter();
			symbol_588.setName("s");
			//symbol_588.setMoniker("String!>=($ocl!OclSelf)!s");
			symbol_588.setType(symbol_82);  // $ocl!OclSelf
			
			symbol_587.getOwnedParameters().add(symbol_588);
			symbol_587.setPrecedence(symbol_6);
			symbol_587.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation");
			symbol_587.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_587);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_589 = PivotFactory.eINSTANCE.createOperation();
			symbol_589.setName("at");
			//symbol_589.setMoniker("String!at(Integer)");
			symbol_589.setType(symbol_128);  // String
			
			Parameter symbol_590 = PivotFactory.eINSTANCE.createParameter();
			symbol_590.setName("i");
			//symbol_590.setMoniker("String!at(Integer)!i");
			symbol_590.setType(symbol_123);  // Integer
			
			symbol_589.getOwnedParameters().add(symbol_590);
			symbol_589.setImplementationClass("org.eclipse.ocl.examples.library.string.StringAtOperation");
			symbol_589.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_589);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_591 = PivotFactory.eINSTANCE.createOperation();
			symbol_591.setName("characters");
			//symbol_591.setMoniker("String!characters()");
			symbol_591.setType(symbol_211);  // $ocl!Sequence[String]
			
			symbol_591.setImplementationClass("org.eclipse.ocl.examples.library.string.StringCharactersOperation");
			symbol_591.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_591);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_592 = PivotFactory.eINSTANCE.createOperation();
			symbol_592.setName("concat");
			//symbol_592.setMoniker("String!concat(String)");
			symbol_592.setType(symbol_128);  // String
			
			Parameter symbol_593 = PivotFactory.eINSTANCE.createParameter();
			symbol_593.setName("s");
			//symbol_593.setMoniker("String!concat(String)!s");
			symbol_593.setType(symbol_128);  // String
			
			symbol_592.getOwnedParameters().add(symbol_593);
			symbol_592.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_592.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_592);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_594 = PivotFactory.eINSTANCE.createOperation();
			symbol_594.setName("equalsIgnoreCase");
			//symbol_594.setMoniker("String!equalsIgnoreCase(String)");
			symbol_594.setType(symbol_122);  // Boolean
			
			Parameter symbol_595 = PivotFactory.eINSTANCE.createParameter();
			symbol_595.setName("s");
			//symbol_595.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_595.setType(symbol_128);  // String
			
			symbol_594.getOwnedParameters().add(symbol_595);
			symbol_594.setImplementationClass("org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation");
			symbol_594.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_594);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_596 = PivotFactory.eINSTANCE.createOperation();
			symbol_596.setName("indexOf");
			//symbol_596.setMoniker("String!indexOf(String)");
			symbol_596.setType(symbol_123);  // Integer
			
			Parameter symbol_597 = PivotFactory.eINSTANCE.createParameter();
			symbol_597.setName("s");
			//symbol_597.setMoniker("String!indexOf(String)!s");
			symbol_597.setType(symbol_128);  // String
			
			symbol_596.getOwnedParameters().add(symbol_597);
			symbol_596.setImplementationClass("org.eclipse.ocl.examples.library.string.StringIndexOfOperation");
			symbol_596.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_596);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_598 = PivotFactory.eINSTANCE.createOperation();
			symbol_598.setName("size");
			//symbol_598.setMoniker("String!size()");
			symbol_598.setType(symbol_123);  // Integer
			
			symbol_598.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSizeOperation");
			symbol_598.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_598);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_599 = PivotFactory.eINSTANCE.createOperation();
			symbol_599.setName("substring");
			//symbol_599.setMoniker("String!substring(Integer,Integer)");
			symbol_599.setType(symbol_128);  // String
			
			Parameter symbol_600 = PivotFactory.eINSTANCE.createParameter();
			symbol_600.setName("lower");
			//symbol_600.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_600.setType(symbol_123);  // Integer
			
			symbol_599.getOwnedParameters().add(symbol_600);
			Parameter symbol_601 = PivotFactory.eINSTANCE.createParameter();
			symbol_601.setName("upper");
			//symbol_601.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_601.setType(symbol_123);  // Integer
			
			symbol_599.getOwnedParameters().add(symbol_601);
			symbol_599.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSubstringOperation");
			symbol_599.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_599);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_602 = PivotFactory.eINSTANCE.createOperation();
			symbol_602.setName("toBoolean");
			//symbol_602.setMoniker("String!toBoolean()");
			symbol_602.setType(symbol_122);  // Boolean
			
			symbol_602.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToBooleanOperation");
			symbol_602.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_602);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_603 = PivotFactory.eINSTANCE.createOperation();
			symbol_603.setName("toInteger");
			//symbol_603.setMoniker("String!toInteger()");
			symbol_603.setType(symbol_123);  // Integer
			
			symbol_603.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToIntegerOperation");
			symbol_603.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_603);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_604 = PivotFactory.eINSTANCE.createOperation();
			symbol_604.setName("toLower");
			//symbol_604.setMoniker("String!toLower()");
			symbol_604.setType(symbol_128);  // String
			
			symbol_604.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_604.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_604);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_605 = PivotFactory.eINSTANCE.createOperation();
			symbol_605.setName("toLowerCase");
			//symbol_605.setMoniker("String!toLowerCase()");
			symbol_605.setType(symbol_128);  // String
			
			symbol_605.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_605.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_605);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_606 = PivotFactory.eINSTANCE.createOperation();
			symbol_606.setName("toReal");
			//symbol_606.setMoniker("String!toReal()");
			symbol_606.setType(symbol_124);  // Real
			
			symbol_606.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToRealOperation");
			symbol_606.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_606);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_607 = PivotFactory.eINSTANCE.createOperation();
			symbol_607.setName("toString");
			//symbol_607.setMoniker("String!toString()");
			symbol_607.setType(symbol_128);  // String
			
			symbol_607.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_607.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_607);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_608 = PivotFactory.eINSTANCE.createOperation();
			symbol_608.setName("toUpper");
			//symbol_608.setMoniker("String!toUpper()");
			symbol_608.setType(symbol_128);  // String
			
			symbol_608.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_608.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_608);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_609 = PivotFactory.eINSTANCE.createOperation();
			symbol_609.setName("toUpperCase");
			//symbol_609.setMoniker("String!toUpperCase()");
			symbol_609.setType(symbol_128);  // String
			
			symbol_609.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_609.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_128.getOwnedOperations().add(symbol_609);
		}
		symbol_1.getOwnedTypes().add(symbol_128);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_129.setName("UnlimitedNatural");
		//symbol_129.setMoniker("UnlimitedNatural");
		symbol_129.getSuperClasses().add(symbol_123); // Integer
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
		// ocl::$$::Bag $ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_132.setName("Bag");
		//symbol_132.setMoniker("$ocl!Bag[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_132.setElementType(symbol_18);
		symbol_132.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_610 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_610.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_611 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_611.setFormal(symbol_14);	
				symbol_611.setActual(symbol_18);	
				symbol_610.getParameterSubstitutions().add(symbol_611);
			}
			symbol_132.getTemplateBindings().add(symbol_610);
		}
		symbol_132.getSuperClasses().add(symbol_180); // $ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_132.getSuperClasses().add(symbol_169); // $ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_132);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!Bag{T}?T]
		//
		symbol_133.setName("Bag");
		//symbol_133.setMoniker("$ocl!Bag[$ocl!Bag{T}?T]");
		symbol_133.setElementType(symbol_15);
		symbol_133.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_612 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_612.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_613 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_613.setFormal(symbol_14);	
				symbol_613.setActual(symbol_15);	
				symbol_612.getParameterSubstitutions().add(symbol_613);
			}
			symbol_133.getTemplateBindings().add(symbol_612);
		}
		symbol_133.getSuperClasses().add(symbol_181); // $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		symbol_133.getSuperClasses().add(symbol_170); // $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		symbol_130.getOwnedTypes().add(symbol_133);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!Collection{T}?T]
		//
		symbol_134.setName("Bag");
		//symbol_134.setMoniker("$ocl!Bag[$ocl!Collection{T}?T]");
		symbol_134.setElementType(symbol_32);
		symbol_134.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_614 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_614.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_615 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_615.setFormal(symbol_14);	
				symbol_615.setActual(symbol_32);	
				symbol_614.getParameterSubstitutions().add(symbol_615);
			}
			symbol_134.getTemplateBindings().add(symbol_614);
		}
		symbol_134.getSuperClasses().add(symbol_172); // $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		symbol_134.getSuperClasses().add(symbol_182); // $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_134);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_135.setName("Bag");
		//symbol_135.setMoniker("$ocl!Bag[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_135.setElementType(symbol_61);
		symbol_135.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_616 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_616.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_617 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_617.setFormal(symbol_14);	
				symbol_617.setActual(symbol_61);	
				symbol_616.getParameterSubstitutions().add(symbol_617);
			}
			symbol_135.getTemplateBindings().add(symbol_616);
		}
		symbol_135.getSuperClasses().add(symbol_173); // $ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_135.getSuperClasses().add(symbol_183); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_135);
		//
		// ocl::$$::Bag $ocl!Bag[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_136.setName("Bag");
		//symbol_136.setMoniker("$ocl!Bag[$ocl!NonOrderedCollection{T}?T]");
		symbol_136.setElementType(symbol_58);
		symbol_136.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_618 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_618.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_619 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_619.setFormal(symbol_14);	
				symbol_619.setActual(symbol_58);	
				symbol_618.getParameterSubstitutions().add(symbol_619);
			}
			symbol_136.getTemplateBindings().add(symbol_618);
		}
		symbol_136.getSuperClasses().add(symbol_184); // $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]
		symbol_136.getSuperClasses().add(symbol_55); // $ocl!NonOrderedCollection{T}
		symbol_130.getOwnedTypes().add(symbol_136);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]
		//
		symbol_137.setName("Classifier");
		//symbol_137.setMoniker("$ocl!Classifier[$ocl!Classifier{T}!oclContainer{U}()?U]");
		symbol_137.setInstanceType(symbol_25);
		symbol_137.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_620 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_620.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_621 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_621.setFormal(symbol_21);	
				symbol_621.setActual(symbol_25);	
				symbol_620.getParameterSubstitutions().add(symbol_621);
			}
			symbol_137.getTemplateBindings().add(symbol_620);
		}
		symbol_137.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_137);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]
		//
		symbol_138.setName("Classifier");
		//symbol_138.setMoniker("$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]");
		symbol_138.setInstanceType(symbol_28);
		symbol_138.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_622 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_622.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_623 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_623.setFormal(symbol_21);	
				symbol_623.setActual(symbol_28);	
				symbol_622.getParameterSubstitutions().add(symbol_623);
			}
			symbol_138.getTemplateBindings().add(symbol_622);
		}
		symbol_138.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_138);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]
		//
		symbol_139.setName("Classifier");
		//symbol_139.setMoniker("$ocl!Classifier[$ocl!OclAny!oclAsType{TT}($ocl!Classifier[TT])?TT]");
		symbol_139.setInstanceType(symbol_72);
		symbol_139.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_624 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_624.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_625 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_625.setFormal(symbol_21);	
				symbol_625.setActual(symbol_72);	
				symbol_624.getParameterSubstitutions().add(symbol_625);
			}
			symbol_139.getTemplateBindings().add(symbol_624);
		}
		symbol_139.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_139);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]
		//
		symbol_140.setName("Classifier");
		//symbol_140.setMoniker("$ocl!Classifier[$ocl!OclAny!oclIsKindOf{T}($ocl!Classifier[T])?T]");
		symbol_140.setInstanceType(symbol_75);
		symbol_140.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_626 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_626.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_627 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_627.setFormal(symbol_21);	
				symbol_627.setActual(symbol_75);	
				symbol_626.getParameterSubstitutions().add(symbol_627);
			}
			symbol_140.getTemplateBindings().add(symbol_626);
		}
		symbol_140.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_140);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]
		//
		symbol_141.setName("Classifier");
		//symbol_141.setMoniker("$ocl!Classifier[$ocl!OclAny!oclIsTypeOf{T}($ocl!Classifier[T])?T]");
		symbol_141.setInstanceType(symbol_78);
		symbol_141.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_628 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_628.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_629 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_629.setFormal(symbol_21);	
				symbol_629.setActual(symbol_78);	
				symbol_628.getParameterSubstitutions().add(symbol_629);
			}
			symbol_141.getTemplateBindings().add(symbol_628);
		}
		symbol_141.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_141);
		//
		// ocl::$$::Classifier $ocl!Classifier[$ocl!OclSelf]
		//
		symbol_142.setName("Classifier");
		//symbol_142.setMoniker("$ocl!Classifier[$ocl!OclSelf]");
		symbol_142.setInstanceType(symbol_82);
		symbol_142.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_630 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_630.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_631 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_631.setFormal(symbol_21);	
				symbol_631.setActual(symbol_82);	
				symbol_630.getParameterSubstitutions().add(symbol_631);
			}
			symbol_142.getTemplateBindings().add(symbol_630);
		}
		symbol_142.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_142);
		//
		// ocl::$$::Classifier $ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]
		//
		symbol_143.setName("Classifier");
		//symbol_143.setMoniker("$ocl!Classifier[Real!oclAsType{TT}($ocl!Classifier[TT])?TT]");
		symbol_143.setInstanceType(symbol_127);
		symbol_143.setUnspecializedElement(symbol_19);
		{
			TemplateBinding symbol_632 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_632.setSignature(symbol_20);
			{
				TemplateParameterSubstitution symbol_633 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_633.setFormal(symbol_21);	
				symbol_633.setActual(symbol_127);	
				symbol_632.getParameterSubstitutions().add(symbol_633);
			}
			symbol_143.getTemplateBindings().add(symbol_632);
		}
		symbol_143.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_143);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_144.setName("Collection");
		//symbol_144.setMoniker("$ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_144.setElementType(symbol_18);
		symbol_144.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_634 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_634.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_635 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_635.setFormal(symbol_31);	
				symbol_635.setActual(symbol_18);	
				symbol_634.getParameterSubstitutions().add(symbol_635);
			}
			symbol_144.getTemplateBindings().add(symbol_634);
		}
		symbol_144.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_144);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Bag{T}?T]
		//
		symbol_145.setName("Collection");
		//symbol_145.setMoniker("$ocl!Collection[$ocl!Bag{T}?T]");
		symbol_145.setElementType(symbol_15);
		symbol_145.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_636 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_636.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_637 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_637.setFormal(symbol_31);	
				symbol_637.setActual(symbol_15);	
				symbol_636.getParameterSubstitutions().add(symbol_637);
			}
			symbol_145.getTemplateBindings().add(symbol_636);
		}
		symbol_145.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_145);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_146.setName("Collection");
		//symbol_146.setMoniker("$ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_146.setElementType(symbol_138);
		symbol_146.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_638 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_638.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_639 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_639.setFormal(symbol_31);	
				symbol_639.setActual(symbol_138);	
				symbol_638.getParameterSubstitutions().add(symbol_639);
			}
			symbol_146.getTemplateBindings().add(symbol_638);
		}
		symbol_146.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_146);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_147.setName("Collection");
		//symbol_147.setMoniker("$ocl!Collection[$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_147.setElementType(symbol_35);
		symbol_147.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_640 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_640.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_641 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_641.setFormal(symbol_31);	
				symbol_641.setActual(symbol_35);	
				symbol_640.getParameterSubstitutions().add(symbol_641);
			}
			symbol_147.getTemplateBindings().add(symbol_640);
		}
		symbol_147.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_147);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]
		//
		symbol_148.setName("Collection");
		//symbol_148.setMoniker("$ocl!Collection[$ocl!Collection{T}!excludesAll{T2}($ocl!Collection[T2])?T2]");
		symbol_148.setElementType(symbol_41);
		symbol_148.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_642 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_642.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_643 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_643.setFormal(symbol_31);	
				symbol_643.setActual(symbol_41);	
				symbol_642.getParameterSubstitutions().add(symbol_643);
			}
			symbol_148.getTemplateBindings().add(symbol_642);
		}
		symbol_148.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_148);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_149.setName("Collection");
		//symbol_149.setMoniker("$ocl!Collection[$ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_149.setElementType(symbol_44);
		symbol_149.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_31);	
				symbol_645.setActual(symbol_44);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_149.getTemplateBindings().add(symbol_644);
		}
		symbol_149.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_149);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]
		//
		symbol_150.setName("Collection");
		//symbol_150.setMoniker("$ocl!Collection[$ocl!Collection{T}!includesAll{T2}($ocl!Collection[T2])?T2]");
		symbol_150.setElementType(symbol_47);
		symbol_150.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_31);	
				symbol_647.setActual(symbol_47);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_150.getTemplateBindings().add(symbol_646);
		}
		symbol_150.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_150);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]
		//
		symbol_151.setName("Collection");
		//symbol_151.setMoniker("$ocl!Collection[$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2]");
		symbol_151.setElementType(symbol_53);
		symbol_151.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_31);	
				symbol_649.setActual(symbol_53);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_151.getTemplateBindings().add(symbol_648);
		}
		symbol_151.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_151);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Collection{T}?T]
		//
		symbol_152.setName("Collection");
		//symbol_152.setMoniker("$ocl!Collection[$ocl!Collection{T}?T]");
		symbol_152.setElementType(symbol_32);
		symbol_152.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_31);	
				symbol_651.setActual(symbol_32);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_152.getTemplateBindings().add(symbol_650);
		}
		symbol_152.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_152);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_153.setName("Collection");
		//symbol_153.setMoniker("$ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_153.setElementType(symbol_61);
		symbol_153.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_31);	
				symbol_653.setActual(symbol_61);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_153.getTemplateBindings().add(symbol_652);
		}
		symbol_153.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_153);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_154.setName("Collection");
		//symbol_154.setMoniker("$ocl!Collection[$ocl!NonOrderedCollection{T}?T]");
		symbol_154.setElementType(symbol_58);
		symbol_154.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_31);	
				symbol_655.setActual(symbol_58);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_154.getTemplateBindings().add(symbol_654);
		}
		symbol_154.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_154);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		//
		symbol_155.setName("Collection");
		//symbol_155.setMoniker("$ocl!Collection[$ocl!NonUniqueCollection{T}?T]");
		symbol_155.setElementType(symbol_68);
		symbol_155.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_31);	
				symbol_657.setActual(symbol_68);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_155.getTemplateBindings().add(symbol_656);
		}
		symbol_155.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_155);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OclAny]
		//
		symbol_156.setName("Collection");
		//symbol_156.setMoniker("$ocl!Collection[$ocl!OclAny]");
		symbol_156.setElementType(symbol_69);
		symbol_156.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_31);	
				symbol_659.setActual(symbol_69);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_156.getTemplateBindings().add(symbol_658);
		}
		symbol_156.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_156);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OclSelf]
		//
		symbol_157.setName("Collection");
		//symbol_157.setMoniker("$ocl!Collection[$ocl!OclSelf]");
		symbol_157.setElementType(symbol_82);
		symbol_157.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_31);	
				symbol_661.setActual(symbol_82);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_157.getTemplateBindings().add(symbol_660);
		}
		symbol_157.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_157);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_158.setName("Collection");
		//symbol_158.setMoniker("$ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_158.setElementType(symbol_92);
		symbol_158.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_31);	
				symbol_663.setActual(symbol_92);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_158.getTemplateBindings().add(symbol_662);
		}
		symbol_158.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_158);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedCollection{T}?T]
		//
		symbol_159.setName("Collection");
		//symbol_159.setMoniker("$ocl!Collection[$ocl!OrderedCollection{T}?T]");
		symbol_159.setElementType(symbol_89);
		symbol_159.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_31);	
				symbol_665.setActual(symbol_89);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_159.getTemplateBindings().add(symbol_664);
		}
		symbol_159.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_159);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_160.setName("Collection");
		//symbol_160.setMoniker("$ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_160.setElementType(symbol_102);
		symbol_160.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_31);	
				symbol_667.setActual(symbol_102);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_160.getTemplateBindings().add(symbol_666);
		}
		symbol_160.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_160);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!OrderedSet{T}?T]
		//
		symbol_161.setName("Collection");
		//symbol_161.setMoniker("$ocl!Collection[$ocl!OrderedSet{T}?T]");
		symbol_161.setElementType(symbol_99);
		symbol_161.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_31);	
				symbol_669.setActual(symbol_99);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_161.getTemplateBindings().add(symbol_668);
		}
		symbol_161.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_161);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_162.setName("Collection");
		//symbol_162.setMoniker("$ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_162.setElementType(symbol_109);
		symbol_162.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_31);	
				symbol_671.setActual(symbol_109);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_162.getTemplateBindings().add(symbol_670);
		}
		symbol_162.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_162);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Sequence{T}?T]
		//
		symbol_163.setName("Collection");
		//symbol_163.setMoniker("$ocl!Collection[$ocl!Sequence{T}?T]");
		symbol_163.setElementType(symbol_106);
		symbol_163.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_31);	
				symbol_673.setActual(symbol_106);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_163.getTemplateBindings().add(symbol_672);
		}
		symbol_163.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_163);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_164.setName("Collection");
		//symbol_164.setMoniker("$ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_164.setElementType(symbol_116);
		symbol_164.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_31);	
				symbol_675.setActual(symbol_116);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_164.getTemplateBindings().add(symbol_674);
		}
		symbol_164.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_164);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!Set{T}?T]
		//
		symbol_165.setName("Collection");
		//symbol_165.setMoniker("$ocl!Collection[$ocl!Set{T}?T]");
		symbol_165.setElementType(symbol_113);
		symbol_165.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_31);	
				symbol_677.setActual(symbol_113);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_165.getTemplateBindings().add(symbol_676);
		}
		symbol_165.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_165);
		//
		// ocl::$$::Collection $ocl!Collection[$ocl!UniqueCollection{T}?T]
		//
		symbol_166.setName("Collection");
		//symbol_166.setMoniker("$ocl!Collection[$ocl!UniqueCollection{T}?T]");
		symbol_166.setElementType(symbol_121);
		symbol_166.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_31);	
				symbol_679.setActual(symbol_121);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_166.getTemplateBindings().add(symbol_678);
		}
		symbol_166.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_166);
		//
		// ocl::$$::Collection $ocl!Collection[String]
		//
		symbol_167.setName("Collection");
		//symbol_167.setMoniker("$ocl!Collection[String]");
		symbol_167.setElementType(symbol_128);
		symbol_167.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_31);	
				symbol_681.setActual(symbol_128);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_167.getTemplateBindings().add(symbol_680);
		}
		symbol_167.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_167);
		//
		// ocl::$$::Collection $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_168.setName("Collection");
		//symbol_168.setMoniker("$ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_168.setElementType(symbol_248);
		symbol_168.setUnspecializedElement(symbol_29);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_30);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_31);	
				symbol_683.setActual(symbol_248);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_168.getTemplateBindings().add(symbol_682);
		}
		symbol_168.getSuperClasses().add(symbol_69); // $ocl!OclAny
		symbol_130.getOwnedTypes().add(symbol_168);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_169.setName("NonOrderedCollection");
		//symbol_169.setMoniker("$ocl!NonOrderedCollection[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_169.setElementType(symbol_18);
		symbol_169.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_57);	
				symbol_685.setActual(symbol_18);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_169.getTemplateBindings().add(symbol_684);
		}
		symbol_169.getSuperClasses().add(symbol_144); // $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_169);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Bag{T}?T]
		//
		symbol_170.setName("NonOrderedCollection");
		//symbol_170.setMoniker("$ocl!NonOrderedCollection[$ocl!Bag{T}?T]");
		symbol_170.setElementType(symbol_15);
		symbol_170.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_57);	
				symbol_687.setActual(symbol_15);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_170.getTemplateBindings().add(symbol_686);
		}
		symbol_170.getSuperClasses().add(symbol_145); // $ocl!Collection[$ocl!Bag{T}?T]
		symbol_130.getOwnedTypes().add(symbol_170);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_171.setName("NonOrderedCollection");
		//symbol_171.setMoniker("$ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_171.setElementType(symbol_138);
		symbol_171.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_57);	
				symbol_689.setActual(symbol_138);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_171.getTemplateBindings().add(symbol_688);
		}
		symbol_171.getSuperClasses().add(symbol_146); // $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_130.getOwnedTypes().add(symbol_171);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		//
		symbol_172.setName("NonOrderedCollection");
		//symbol_172.setMoniker("$ocl!NonOrderedCollection[$ocl!Collection{T}?T]");
		symbol_172.setElementType(symbol_32);
		symbol_172.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_57);	
				symbol_691.setActual(symbol_32);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_172.getTemplateBindings().add(symbol_690);
		}
		symbol_172.getSuperClasses().add(symbol_29); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_172);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_173.setName("NonOrderedCollection");
		//symbol_173.setMoniker("$ocl!NonOrderedCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_173.setElementType(symbol_61);
		symbol_173.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_57);	
				symbol_693.setActual(symbol_61);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_173.getTemplateBindings().add(symbol_692);
		}
		symbol_173.getSuperClasses().add(symbol_153); // $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_173);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!OclAny]
		//
		symbol_174.setName("NonOrderedCollection");
		//symbol_174.setMoniker("$ocl!NonOrderedCollection[$ocl!OclAny]");
		symbol_174.setElementType(symbol_69);
		symbol_174.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_57);	
				symbol_695.setActual(symbol_69);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_174.getTemplateBindings().add(symbol_694);
		}
		symbol_174.getSuperClasses().add(symbol_156); // $ocl!Collection[$ocl!OclAny]
		symbol_130.getOwnedTypes().add(symbol_174);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!OclSelf]
		//
		symbol_175.setName("NonOrderedCollection");
		//symbol_175.setMoniker("$ocl!NonOrderedCollection[$ocl!OclSelf]");
		symbol_175.setElementType(symbol_82);
		symbol_175.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_57);	
				symbol_697.setActual(symbol_82);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_175.getTemplateBindings().add(symbol_696);
		}
		symbol_175.getSuperClasses().add(symbol_157); // $ocl!Collection[$ocl!OclSelf]
		symbol_130.getOwnedTypes().add(symbol_175);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]
		//
		symbol_176.setName("NonOrderedCollection");
		//symbol_176.setMoniker("$ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]");
		symbol_176.setElementType(symbol_99);
		symbol_176.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_57);	
				symbol_699.setActual(symbol_99);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_176.getTemplateBindings().add(symbol_698);
		}
		symbol_176.getSuperClasses().add(symbol_161); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_176);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_177.setName("NonOrderedCollection");
		//symbol_177.setMoniker("$ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_177.setElementType(symbol_116);
		symbol_177.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_57);	
				symbol_701.setActual(symbol_116);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_177.getTemplateBindings().add(symbol_700);
		}
		symbol_177.getSuperClasses().add(symbol_164); // $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_177);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		//
		symbol_178.setName("NonOrderedCollection");
		//symbol_178.setMoniker("$ocl!NonOrderedCollection[$ocl!Set{T}?T]");
		symbol_178.setElementType(symbol_113);
		symbol_178.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_57);	
				symbol_703.setActual(symbol_113);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_178.getTemplateBindings().add(symbol_702);
		}
		symbol_178.getSuperClasses().add(symbol_165); // $ocl!Collection[$ocl!Set{T}?T]
		symbol_130.getOwnedTypes().add(symbol_178);
		//
		// ocl::$$::NonOrderedCollection $ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_179.setName("NonOrderedCollection");
		//symbol_179.setMoniker("$ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_179.setElementType(symbol_248);
		symbol_179.setUnspecializedElement(symbol_55);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_57);	
				symbol_705.setActual(symbol_248);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_179.getTemplateBindings().add(symbol_704);
		}
		symbol_179.getSuperClasses().add(symbol_168); // $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_130.getOwnedTypes().add(symbol_179);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_180.setName("NonUniqueCollection");
		//symbol_180.setMoniker("$ocl!NonUniqueCollection[$ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_180.setElementType(symbol_18);
		symbol_180.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_67);	
				symbol_707.setActual(symbol_18);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_180.getTemplateBindings().add(symbol_706);
		}
		symbol_180.getSuperClasses().add(symbol_144); // $ocl!Collection[$ocl!Bag{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_180);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Bag{T}?T]
		//
		symbol_181.setName("NonUniqueCollection");
		//symbol_181.setMoniker("$ocl!NonUniqueCollection[$ocl!Bag{T}?T]");
		symbol_181.setElementType(symbol_15);
		symbol_181.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_67);	
				symbol_709.setActual(symbol_15);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_181.getTemplateBindings().add(symbol_708);
		}
		symbol_181.getSuperClasses().add(symbol_145); // $ocl!Collection[$ocl!Bag{T}?T]
		symbol_130.getOwnedTypes().add(symbol_181);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		//
		symbol_182.setName("NonUniqueCollection");
		//symbol_182.setMoniker("$ocl!NonUniqueCollection[$ocl!Collection{T}?T]");
		symbol_182.setElementType(symbol_32);
		symbol_182.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_67);	
				symbol_711.setActual(symbol_32);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_182.getTemplateBindings().add(symbol_710);
		}
		symbol_182.getSuperClasses().add(symbol_29); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_182);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_183.setName("NonUniqueCollection");
		//symbol_183.setMoniker("$ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_183.setElementType(symbol_61);
		symbol_183.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_67);	
				symbol_713.setActual(symbol_61);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_183.getTemplateBindings().add(symbol_712);
		}
		symbol_183.getSuperClasses().add(symbol_153); // $ocl!Collection[$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_183);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_184.setName("NonUniqueCollection");
		//symbol_184.setMoniker("$ocl!NonUniqueCollection[$ocl!NonOrderedCollection{T}?T]");
		symbol_184.setElementType(symbol_58);
		symbol_184.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_67);	
				symbol_715.setActual(symbol_58);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_184.getTemplateBindings().add(symbol_714);
		}
		symbol_184.getSuperClasses().add(symbol_154); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_184);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_185.setName("NonUniqueCollection");
		//symbol_185.setMoniker("$ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_185.setElementType(symbol_92);
		symbol_185.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_67);	
				symbol_717.setActual(symbol_92);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_185.getTemplateBindings().add(symbol_716);
		}
		symbol_185.getSuperClasses().add(symbol_158); // $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_185);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]
		//
		symbol_186.setName("NonUniqueCollection");
		//symbol_186.setMoniker("$ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]");
		symbol_186.setElementType(symbol_89);
		symbol_186.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_67);	
				symbol_719.setActual(symbol_89);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_186.getTemplateBindings().add(symbol_718);
		}
		symbol_186.getSuperClasses().add(symbol_159); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_186);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_187.setName("NonUniqueCollection");
		//symbol_187.setMoniker("$ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_187.setElementType(symbol_109);
		symbol_187.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_67);	
				symbol_721.setActual(symbol_109);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_187.getTemplateBindings().add(symbol_720);
		}
		symbol_187.getSuperClasses().add(symbol_162); // $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_187);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		//
		symbol_188.setName("NonUniqueCollection");
		//symbol_188.setMoniker("$ocl!NonUniqueCollection[$ocl!Sequence{T}?T]");
		symbol_188.setElementType(symbol_106);
		symbol_188.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_67);	
				symbol_723.setActual(symbol_106);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_188.getTemplateBindings().add(symbol_722);
		}
		symbol_188.getSuperClasses().add(symbol_163); // $ocl!Collection[$ocl!Sequence{T}?T]
		symbol_130.getOwnedTypes().add(symbol_188);
		//
		// ocl::$$::NonUniqueCollection $ocl!NonUniqueCollection[String]
		//
		symbol_189.setName("NonUniqueCollection");
		//symbol_189.setMoniker("$ocl!NonUniqueCollection[String]");
		symbol_189.setElementType(symbol_128);
		symbol_189.setUnspecializedElement(symbol_65);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_66);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_67);	
				symbol_725.setActual(symbol_128);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_189.getTemplateBindings().add(symbol_724);
		}
		symbol_189.getSuperClasses().add(symbol_167); // $ocl!Collection[String]
		symbol_130.getOwnedTypes().add(symbol_189);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!Collection{T}?T]
		//
		symbol_190.setName("OrderedCollection");
		//symbol_190.setMoniker("$ocl!OrderedCollection[$ocl!Collection{T}?T]");
		symbol_190.setElementType(symbol_32);
		symbol_190.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_726 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_726.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_727 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_727.setFormal(symbol_88);	
				symbol_727.setActual(symbol_32);	
				symbol_726.getParameterSubstitutions().add(symbol_727);
			}
			symbol_190.getTemplateBindings().add(symbol_726);
		}
		symbol_190.getSuperClasses().add(symbol_29); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_190);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]
		//
		symbol_191.setName("OrderedCollection");
		//symbol_191.setMoniker("$ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]");
		symbol_191.setElementType(symbol_68);
		symbol_191.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_728 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_728.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_729 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_729.setFormal(symbol_88);	
				symbol_729.setActual(symbol_68);	
				symbol_728.getParameterSubstitutions().add(symbol_729);
			}
			symbol_191.getTemplateBindings().add(symbol_728);
		}
		symbol_191.getSuperClasses().add(symbol_155); // $ocl!Collection[$ocl!NonUniqueCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_191);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_192.setName("OrderedCollection");
		//symbol_192.setMoniker("$ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_192.setElementType(symbol_92);
		symbol_192.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_730 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_730.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_731 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_731.setFormal(symbol_88);	
				symbol_731.setActual(symbol_92);	
				symbol_730.getParameterSubstitutions().add(symbol_731);
			}
			symbol_192.getTemplateBindings().add(symbol_730);
		}
		symbol_192.getSuperClasses().add(symbol_158); // $ocl!Collection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_192);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]
		//
		symbol_193.setName("OrderedCollection");
		//symbol_193.setMoniker("$ocl!OrderedCollection[$ocl!OrderedCollection{T}?T]");
		symbol_193.setElementType(symbol_89);
		symbol_193.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_732 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_732.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_733 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_733.setFormal(symbol_88);	
				symbol_733.setActual(symbol_89);	
				symbol_732.getParameterSubstitutions().add(symbol_733);
			}
			symbol_193.getTemplateBindings().add(symbol_732);
		}
		symbol_193.getSuperClasses().add(symbol_159); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_193);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_194.setName("OrderedCollection");
		//symbol_194.setMoniker("$ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_194.setElementType(symbol_102);
		symbol_194.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_734 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_734.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_735 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_735.setFormal(symbol_88);	
				symbol_735.setActual(symbol_102);	
				symbol_734.getParameterSubstitutions().add(symbol_735);
			}
			symbol_194.getTemplateBindings().add(symbol_734);
		}
		symbol_194.getSuperClasses().add(symbol_160); // $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_194);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		//
		symbol_195.setName("OrderedCollection");
		//symbol_195.setMoniker("$ocl!OrderedCollection[$ocl!OrderedSet{T}?T]");
		symbol_195.setElementType(symbol_99);
		symbol_195.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_736 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_736.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_737 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_737.setFormal(symbol_88);	
				symbol_737.setActual(symbol_99);	
				symbol_736.getParameterSubstitutions().add(symbol_737);
			}
			symbol_195.getTemplateBindings().add(symbol_736);
		}
		symbol_195.getSuperClasses().add(symbol_161); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_195);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_196.setName("OrderedCollection");
		//symbol_196.setMoniker("$ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_196.setElementType(symbol_109);
		symbol_196.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_738 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_738.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_739 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_739.setFormal(symbol_88);	
				symbol_739.setActual(symbol_109);	
				symbol_738.getParameterSubstitutions().add(symbol_739);
			}
			symbol_196.getTemplateBindings().add(symbol_738);
		}
		symbol_196.getSuperClasses().add(symbol_162); // $ocl!Collection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_196);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		//
		symbol_197.setName("OrderedCollection");
		//symbol_197.setMoniker("$ocl!OrderedCollection[$ocl!Sequence{T}?T]");
		symbol_197.setElementType(symbol_106);
		symbol_197.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_740 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_740.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_741 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_741.setFormal(symbol_88);	
				symbol_741.setActual(symbol_106);	
				symbol_740.getParameterSubstitutions().add(symbol_741);
			}
			symbol_197.getTemplateBindings().add(symbol_740);
		}
		symbol_197.getSuperClasses().add(symbol_163); // $ocl!Collection[$ocl!Sequence{T}?T]
		symbol_130.getOwnedTypes().add(symbol_197);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]
		//
		symbol_198.setName("OrderedCollection");
		//symbol_198.setMoniker("$ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]");
		symbol_198.setElementType(symbol_121);
		symbol_198.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_742 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_742.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_743 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_743.setFormal(symbol_88);	
				symbol_743.setActual(symbol_121);	
				symbol_742.getParameterSubstitutions().add(symbol_743);
			}
			symbol_198.getTemplateBindings().add(symbol_742);
		}
		symbol_198.getSuperClasses().add(symbol_166); // $ocl!Collection[$ocl!UniqueCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_198);
		//
		// ocl::$$::OrderedCollection $ocl!OrderedCollection[String]
		//
		symbol_199.setName("OrderedCollection");
		//symbol_199.setMoniker("$ocl!OrderedCollection[String]");
		symbol_199.setElementType(symbol_128);
		symbol_199.setUnspecializedElement(symbol_86);
		{
			TemplateBinding symbol_744 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_744.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_745 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_745.setFormal(symbol_88);	
				symbol_745.setActual(symbol_128);	
				symbol_744.getParameterSubstitutions().add(symbol_745);
			}
			symbol_199.getTemplateBindings().add(symbol_744);
		}
		symbol_199.getSuperClasses().add(symbol_167); // $ocl!Collection[String]
		symbol_130.getOwnedTypes().add(symbol_199);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!Collection{T}?T]
		//
		symbol_200.setName("OrderedSet");
		//symbol_200.setMoniker("$ocl!OrderedSet[$ocl!Collection{T}?T]");
		symbol_200.setElementType(symbol_32);
		symbol_200.setUnspecializedElement(symbol_96);
		{
			TemplateBinding symbol_746 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_746.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_747 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_747.setFormal(symbol_98);	
				symbol_747.setActual(symbol_32);	
				symbol_746.getParameterSubstitutions().add(symbol_747);
			}
			symbol_200.getTemplateBindings().add(symbol_746);
		}
		symbol_200.getSuperClasses().add(symbol_222); // $ocl!UniqueCollection[$ocl!Collection{T}?T]
		symbol_200.getSuperClasses().add(symbol_190); // $ocl!OrderedCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_200);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!OrderedCollection{T}?T]
		//
		symbol_201.setName("OrderedSet");
		//symbol_201.setMoniker("$ocl!OrderedSet[$ocl!OrderedCollection{T}?T]");
		symbol_201.setElementType(symbol_89);
		symbol_201.setUnspecializedElement(symbol_96);
		{
			TemplateBinding symbol_748 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_748.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_749 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_749.setFormal(symbol_98);	
				symbol_749.setActual(symbol_89);	
				symbol_748.getParameterSubstitutions().add(symbol_749);
			}
			symbol_201.getTemplateBindings().add(symbol_748);
		}
		symbol_201.getSuperClasses().add(symbol_86); // $ocl!OrderedCollection{T}
		symbol_201.getSuperClasses().add(symbol_226); // $ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_201);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_202.setName("OrderedSet");
		//symbol_202.setMoniker("$ocl!OrderedSet[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_202.setElementType(symbol_102);
		symbol_202.setUnspecializedElement(symbol_96);
		{
			TemplateBinding symbol_750 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_750.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_751 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_751.setFormal(symbol_98);	
				symbol_751.setActual(symbol_102);	
				symbol_750.getParameterSubstitutions().add(symbol_751);
			}
			symbol_202.getTemplateBindings().add(symbol_750);
		}
		symbol_202.getSuperClasses().add(symbol_227); // $ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_202.getSuperClasses().add(symbol_194); // $ocl!OrderedCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_202);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!OrderedSet{T}?T]
		//
		symbol_203.setName("OrderedSet");
		//symbol_203.setMoniker("$ocl!OrderedSet[$ocl!OrderedSet{T}?T]");
		symbol_203.setElementType(symbol_99);
		symbol_203.setUnspecializedElement(symbol_96);
		{
			TemplateBinding symbol_752 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_752.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_753 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_753.setFormal(symbol_98);	
				symbol_753.setActual(symbol_99);	
				symbol_752.getParameterSubstitutions().add(symbol_753);
			}
			symbol_203.getTemplateBindings().add(symbol_752);
		}
		symbol_203.getSuperClasses().add(symbol_228); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		symbol_203.getSuperClasses().add(symbol_195); // $ocl!OrderedCollection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_203);
		//
		// ocl::$$::OrderedSet $ocl!OrderedSet[$ocl!UniqueCollection{T}?T]
		//
		symbol_204.setName("OrderedSet");
		//symbol_204.setMoniker("$ocl!OrderedSet[$ocl!UniqueCollection{T}?T]");
		symbol_204.setElementType(symbol_121);
		symbol_204.setUnspecializedElement(symbol_96);
		{
			TemplateBinding symbol_754 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_754.setSignature(symbol_97);
			{
				TemplateParameterSubstitution symbol_755 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_755.setFormal(symbol_98);	
				symbol_755.setActual(symbol_121);	
				symbol_754.getParameterSubstitutions().add(symbol_755);
			}
			symbol_204.getTemplateBindings().add(symbol_754);
		}
		symbol_204.getSuperClasses().add(symbol_198); // $ocl!OrderedCollection[$ocl!UniqueCollection{T}?T]
		symbol_204.getSuperClasses().add(symbol_118); // $ocl!UniqueCollection{T}
		symbol_130.getOwnedTypes().add(symbol_204);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!Collection{T}?T]
		//
		symbol_205.setName("Sequence");
		//symbol_205.setMoniker("$ocl!Sequence[$ocl!Collection{T}?T]");
		symbol_205.setElementType(symbol_32);
		symbol_205.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_756 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_756.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_757 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_757.setFormal(symbol_105);	
				symbol_757.setActual(symbol_32);	
				symbol_756.getParameterSubstitutions().add(symbol_757);
			}
			symbol_205.getTemplateBindings().add(symbol_756);
		}
		symbol_205.getSuperClasses().add(symbol_190); // $ocl!OrderedCollection[$ocl!Collection{T}?T]
		symbol_205.getSuperClasses().add(symbol_182); // $ocl!NonUniqueCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_205);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!NonUniqueCollection{T}?T]
		//
		symbol_206.setName("Sequence");
		//symbol_206.setMoniker("$ocl!Sequence[$ocl!NonUniqueCollection{T}?T]");
		symbol_206.setElementType(symbol_68);
		symbol_206.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_758 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_758.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_759 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_759.setFormal(symbol_105);	
				symbol_759.setActual(symbol_68);	
				symbol_758.getParameterSubstitutions().add(symbol_759);
			}
			symbol_206.getTemplateBindings().add(symbol_758);
		}
		symbol_206.getSuperClasses().add(symbol_191); // $ocl!OrderedCollection[$ocl!NonUniqueCollection{T}?T]
		symbol_206.getSuperClasses().add(symbol_65); // $ocl!NonUniqueCollection{T}
		symbol_130.getOwnedTypes().add(symbol_206);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_207.setName("Sequence");
		//symbol_207.setMoniker("$ocl!Sequence[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_207.setElementType(symbol_92);
		symbol_207.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_760 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_760.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_761 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_761.setFormal(symbol_105);	
				symbol_761.setActual(symbol_92);	
				symbol_760.getParameterSubstitutions().add(symbol_761);
			}
			symbol_207.getTemplateBindings().add(symbol_760);
		}
		symbol_207.getSuperClasses().add(symbol_192); // $ocl!OrderedCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_207.getSuperClasses().add(symbol_185); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_130.getOwnedTypes().add(symbol_207);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!OrderedCollection{T}?T]
		//
		symbol_208.setName("Sequence");
		//symbol_208.setMoniker("$ocl!Sequence[$ocl!OrderedCollection{T}?T]");
		symbol_208.setElementType(symbol_89);
		symbol_208.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_762 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_762.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_763 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_763.setFormal(symbol_105);	
				symbol_763.setActual(symbol_89);	
				symbol_762.getParameterSubstitutions().add(symbol_763);
			}
			symbol_208.getTemplateBindings().add(symbol_762);
		}
		symbol_208.getSuperClasses().add(symbol_86); // $ocl!OrderedCollection{T}
		symbol_208.getSuperClasses().add(symbol_186); // $ocl!NonUniqueCollection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_208);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_209.setName("Sequence");
		//symbol_209.setMoniker("$ocl!Sequence[$ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_209.setElementType(symbol_109);
		symbol_209.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_764 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_764.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_765 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_765.setFormal(symbol_105);	
				symbol_765.setActual(symbol_109);	
				symbol_764.getParameterSubstitutions().add(symbol_765);
			}
			symbol_209.getTemplateBindings().add(symbol_764);
		}
		symbol_209.getSuperClasses().add(symbol_187); // $ocl!NonUniqueCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_209.getSuperClasses().add(symbol_196); // $ocl!OrderedCollection[$ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_209);
		//
		// ocl::$$::Sequence $ocl!Sequence[$ocl!Sequence{T}?T]
		//
		symbol_210.setName("Sequence");
		//symbol_210.setMoniker("$ocl!Sequence[$ocl!Sequence{T}?T]");
		symbol_210.setElementType(symbol_106);
		symbol_210.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_766 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_766.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_767 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_767.setFormal(symbol_105);	
				symbol_767.setActual(symbol_106);	
				symbol_766.getParameterSubstitutions().add(symbol_767);
			}
			symbol_210.getTemplateBindings().add(symbol_766);
		}
		symbol_210.getSuperClasses().add(symbol_188); // $ocl!NonUniqueCollection[$ocl!Sequence{T}?T]
		symbol_210.getSuperClasses().add(symbol_197); // $ocl!OrderedCollection[$ocl!Sequence{T}?T]
		symbol_130.getOwnedTypes().add(symbol_210);
		//
		// ocl::$$::Sequence $ocl!Sequence[String]
		//
		symbol_211.setName("Sequence");
		//symbol_211.setMoniker("$ocl!Sequence[String]");
		symbol_211.setElementType(symbol_128);
		symbol_211.setUnspecializedElement(symbol_103);
		{
			TemplateBinding symbol_768 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_768.setSignature(symbol_104);
			{
				TemplateParameterSubstitution symbol_769 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_769.setFormal(symbol_105);	
				symbol_769.setActual(symbol_128);	
				symbol_768.getParameterSubstitutions().add(symbol_769);
			}
			symbol_211.getTemplateBindings().add(symbol_768);
		}
		symbol_211.getSuperClasses().add(symbol_189); // $ocl!NonUniqueCollection[String]
		symbol_211.getSuperClasses().add(symbol_199); // $ocl!OrderedCollection[String]
		symbol_130.getOwnedTypes().add(symbol_211);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_212.setName("Set");
		//symbol_212.setMoniker("$ocl!Set[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_212.setElementType(symbol_138);
		symbol_212.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_770 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_770.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_771 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_771.setFormal(symbol_112);	
				symbol_771.setActual(symbol_138);	
				symbol_770.getParameterSubstitutions().add(symbol_771);
			}
			symbol_212.getTemplateBindings().add(symbol_770);
		}
		symbol_212.getSuperClasses().add(symbol_171); // $ocl!NonOrderedCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_212.getSuperClasses().add(symbol_221); // $ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_130.getOwnedTypes().add(symbol_212);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Collection{T}?T]
		//
		symbol_213.setName("Set");
		//symbol_213.setMoniker("$ocl!Set[$ocl!Collection{T}?T]");
		symbol_213.setElementType(symbol_32);
		symbol_213.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_772 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_772.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_773 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_773.setFormal(symbol_112);	
				symbol_773.setActual(symbol_32);	
				symbol_772.getParameterSubstitutions().add(symbol_773);
			}
			symbol_213.getTemplateBindings().add(symbol_772);
		}
		symbol_213.getSuperClasses().add(symbol_172); // $ocl!NonOrderedCollection[$ocl!Collection{T}?T]
		symbol_213.getSuperClasses().add(symbol_222); // $ocl!UniqueCollection[$ocl!Collection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_213);
		//
		// ocl::$$::Set $ocl!Set[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_214.setName("Set");
		//symbol_214.setMoniker("$ocl!Set[$ocl!NonOrderedCollection{T}?T]");
		symbol_214.setElementType(symbol_58);
		symbol_214.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_774 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_774.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_775 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_775.setFormal(symbol_112);	
				symbol_775.setActual(symbol_58);	
				symbol_774.getParameterSubstitutions().add(symbol_775);
			}
			symbol_214.getTemplateBindings().add(symbol_774);
		}
		symbol_214.getSuperClasses().add(symbol_55); // $ocl!NonOrderedCollection{T}
		symbol_214.getSuperClasses().add(symbol_223); // $ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_214);
		//
		// ocl::$$::Set $ocl!Set[$ocl!OclAny]
		//
		symbol_215.setName("Set");
		//symbol_215.setMoniker("$ocl!Set[$ocl!OclAny]");
		symbol_215.setElementType(symbol_69);
		symbol_215.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_776 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_776.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_777 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_777.setFormal(symbol_112);	
				symbol_777.setActual(symbol_69);	
				symbol_776.getParameterSubstitutions().add(symbol_777);
			}
			symbol_215.getTemplateBindings().add(symbol_776);
		}
		symbol_215.getSuperClasses().add(symbol_224); // $ocl!UniqueCollection[$ocl!OclAny]
		symbol_215.getSuperClasses().add(symbol_174); // $ocl!NonOrderedCollection[$ocl!OclAny]
		symbol_130.getOwnedTypes().add(symbol_215);
		//
		// ocl::$$::Set $ocl!Set[$ocl!OclSelf]
		//
		symbol_216.setName("Set");
		//symbol_216.setMoniker("$ocl!Set[$ocl!OclSelf]");
		symbol_216.setElementType(symbol_82);
		symbol_216.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_778 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_778.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_779 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_779.setFormal(symbol_112);	
				symbol_779.setActual(symbol_82);	
				symbol_778.getParameterSubstitutions().add(symbol_779);
			}
			symbol_216.getTemplateBindings().add(symbol_778);
		}
		symbol_216.getSuperClasses().add(symbol_225); // $ocl!UniqueCollection[$ocl!OclSelf]
		symbol_216.getSuperClasses().add(symbol_175); // $ocl!NonOrderedCollection[$ocl!OclSelf]
		symbol_130.getOwnedTypes().add(symbol_216);
		//
		// ocl::$$::Set $ocl!Set[$ocl!OrderedSet{T}?T]
		//
		symbol_217.setName("Set");
		//symbol_217.setMoniker("$ocl!Set[$ocl!OrderedSet{T}?T]");
		symbol_217.setElementType(symbol_99);
		symbol_217.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_780 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_780.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_781 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_781.setFormal(symbol_112);	
				symbol_781.setActual(symbol_99);	
				symbol_780.getParameterSubstitutions().add(symbol_781);
			}
			symbol_217.getTemplateBindings().add(symbol_780);
		}
		symbol_217.getSuperClasses().add(symbol_228); // $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		symbol_217.getSuperClasses().add(symbol_176); // $ocl!NonOrderedCollection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_217);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_218.setName("Set");
		//symbol_218.setMoniker("$ocl!Set[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_218.setElementType(symbol_116);
		symbol_218.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_782 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_782.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_783 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_783.setFormal(symbol_112);	
				symbol_783.setActual(symbol_116);	
				symbol_782.getParameterSubstitutions().add(symbol_783);
			}
			symbol_218.getTemplateBindings().add(symbol_782);
		}
		symbol_218.getSuperClasses().add(symbol_229); // $ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_218.getSuperClasses().add(symbol_177); // $ocl!NonOrderedCollection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_218);
		//
		// ocl::$$::Set $ocl!Set[$ocl!Set{T}?T]
		//
		symbol_219.setName("Set");
		//symbol_219.setMoniker("$ocl!Set[$ocl!Set{T}?T]");
		symbol_219.setElementType(symbol_113);
		symbol_219.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_784 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_784.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_785 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_785.setFormal(symbol_112);	
				symbol_785.setActual(symbol_113);	
				symbol_784.getParameterSubstitutions().add(symbol_785);
			}
			symbol_219.getTemplateBindings().add(symbol_784);
		}
		symbol_219.getSuperClasses().add(symbol_178); // $ocl!NonOrderedCollection[$ocl!Set{T}?T]
		symbol_219.getSuperClasses().add(symbol_230); // $ocl!UniqueCollection[$ocl!Set{T}?T]
		symbol_130.getOwnedTypes().add(symbol_219);
		//
		// ocl::$$::Set $ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_220.setName("Set");
		//symbol_220.setMoniker("$ocl!Set[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_220.setElementType(symbol_248);
		symbol_220.setUnspecializedElement(symbol_110);
		{
			TemplateBinding symbol_786 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_786.setSignature(symbol_111);
			{
				TemplateParameterSubstitution symbol_787 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_787.setFormal(symbol_112);	
				symbol_787.setActual(symbol_248);	
				symbol_786.getParameterSubstitutions().add(symbol_787);
			}
			symbol_220.getTemplateBindings().add(symbol_786);
		}
		symbol_220.getSuperClasses().add(symbol_231); // $ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_220.getSuperClasses().add(symbol_179); // $ocl!NonOrderedCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_130.getOwnedTypes().add(symbol_220);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_221.setName("UniqueCollection");
		//symbol_221.setMoniker("$ocl!UniqueCollection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_221.setElementType(symbol_138);
		symbol_221.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_788 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_788.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_789 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_789.setFormal(symbol_120);	
				symbol_789.setActual(symbol_138);	
				symbol_788.getParameterSubstitutions().add(symbol_789);
			}
			symbol_221.getTemplateBindings().add(symbol_788);
		}
		symbol_221.getSuperClasses().add(symbol_146); // $ocl!Collection[$ocl!Classifier[$ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_130.getOwnedTypes().add(symbol_221);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Collection{T}?T]
		//
		symbol_222.setName("UniqueCollection");
		//symbol_222.setMoniker("$ocl!UniqueCollection[$ocl!Collection{T}?T]");
		symbol_222.setElementType(symbol_32);
		symbol_222.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_790 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_790.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_791 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_791.setFormal(symbol_120);	
				symbol_791.setActual(symbol_32);	
				symbol_790.getParameterSubstitutions().add(symbol_791);
			}
			symbol_222.getTemplateBindings().add(symbol_790);
		}
		symbol_222.getSuperClasses().add(symbol_29); // $ocl!Collection{T}
		symbol_130.getOwnedTypes().add(symbol_222);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]
		//
		symbol_223.setName("UniqueCollection");
		//symbol_223.setMoniker("$ocl!UniqueCollection[$ocl!NonOrderedCollection{T}?T]");
		symbol_223.setElementType(symbol_58);
		symbol_223.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_792 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_792.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_793 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_793.setFormal(symbol_120);	
				symbol_793.setActual(symbol_58);	
				symbol_792.getParameterSubstitutions().add(symbol_793);
			}
			symbol_223.getTemplateBindings().add(symbol_792);
		}
		symbol_223.getSuperClasses().add(symbol_154); // $ocl!Collection[$ocl!NonOrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_223);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OclAny]
		//
		symbol_224.setName("UniqueCollection");
		//symbol_224.setMoniker("$ocl!UniqueCollection[$ocl!OclAny]");
		symbol_224.setElementType(symbol_69);
		symbol_224.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_794 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_794.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_795 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_795.setFormal(symbol_120);	
				symbol_795.setActual(symbol_69);	
				symbol_794.getParameterSubstitutions().add(symbol_795);
			}
			symbol_224.getTemplateBindings().add(symbol_794);
		}
		symbol_224.getSuperClasses().add(symbol_156); // $ocl!Collection[$ocl!OclAny]
		symbol_130.getOwnedTypes().add(symbol_224);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OclSelf]
		//
		symbol_225.setName("UniqueCollection");
		//symbol_225.setMoniker("$ocl!UniqueCollection[$ocl!OclSelf]");
		symbol_225.setElementType(symbol_82);
		symbol_225.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_796 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_796.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_797 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_797.setFormal(symbol_120);	
				symbol_797.setActual(symbol_82);	
				symbol_796.getParameterSubstitutions().add(symbol_797);
			}
			symbol_225.getTemplateBindings().add(symbol_796);
		}
		symbol_225.getSuperClasses().add(symbol_157); // $ocl!Collection[$ocl!OclSelf]
		symbol_130.getOwnedTypes().add(symbol_225);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]
		//
		symbol_226.setName("UniqueCollection");
		//symbol_226.setMoniker("$ocl!UniqueCollection[$ocl!OrderedCollection{T}?T]");
		symbol_226.setElementType(symbol_89);
		symbol_226.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_798 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_798.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_799 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_799.setFormal(symbol_120);	
				symbol_799.setActual(symbol_89);	
				symbol_798.getParameterSubstitutions().add(symbol_799);
			}
			symbol_226.getTemplateBindings().add(symbol_798);
		}
		symbol_226.getSuperClasses().add(symbol_159); // $ocl!Collection[$ocl!OrderedCollection{T}?T]
		symbol_130.getOwnedTypes().add(symbol_226);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_227.setName("UniqueCollection");
		//symbol_227.setMoniker("$ocl!UniqueCollection[$ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_227.setElementType(symbol_102);
		symbol_227.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_800 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_800.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_801 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_801.setFormal(symbol_120);	
				symbol_801.setActual(symbol_102);	
				symbol_800.getParameterSubstitutions().add(symbol_801);
			}
			symbol_227.getTemplateBindings().add(symbol_800);
		}
		symbol_227.getSuperClasses().add(symbol_160); // $ocl!Collection[$ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_227);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!OrderedSet{T}?T]
		//
		symbol_228.setName("UniqueCollection");
		//symbol_228.setMoniker("$ocl!UniqueCollection[$ocl!OrderedSet{T}?T]");
		symbol_228.setElementType(symbol_99);
		symbol_228.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_802 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_802.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_803 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_803.setFormal(symbol_120);	
				symbol_803.setActual(symbol_99);	
				symbol_802.getParameterSubstitutions().add(symbol_803);
			}
			symbol_228.getTemplateBindings().add(symbol_802);
		}
		symbol_228.getSuperClasses().add(symbol_161); // $ocl!Collection[$ocl!OrderedSet{T}?T]
		symbol_130.getOwnedTypes().add(symbol_228);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_229.setName("UniqueCollection");
		//symbol_229.setMoniker("$ocl!UniqueCollection[$ocl!Set{T}!flatten{T2}()?T2]");
		symbol_229.setElementType(symbol_116);
		symbol_229.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_804 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_804.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_805 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_805.setFormal(symbol_120);	
				symbol_805.setActual(symbol_116);	
				symbol_804.getParameterSubstitutions().add(symbol_805);
			}
			symbol_229.getTemplateBindings().add(symbol_804);
		}
		symbol_229.getSuperClasses().add(symbol_164); // $ocl!Collection[$ocl!Set{T}!flatten{T2}()?T2]
		symbol_130.getOwnedTypes().add(symbol_229);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[$ocl!Set{T}?T]
		//
		symbol_230.setName("UniqueCollection");
		//symbol_230.setMoniker("$ocl!UniqueCollection[$ocl!Set{T}?T]");
		symbol_230.setElementType(symbol_113);
		symbol_230.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_806 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_806.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_807 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_807.setFormal(symbol_120);	
				symbol_807.setActual(symbol_113);	
				symbol_806.getParameterSubstitutions().add(symbol_807);
			}
			symbol_230.getTemplateBindings().add(symbol_806);
		}
		symbol_230.getSuperClasses().add(symbol_165); // $ocl!Collection[$ocl!Set{T}?T]
		symbol_130.getOwnedTypes().add(symbol_230);
		//
		// ocl::$$::UniqueCollection $ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		//
		symbol_231.setName("UniqueCollection");
		//symbol_231.setMoniker("$ocl!UniqueCollection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]");
		symbol_231.setElementType(symbol_248);
		symbol_231.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_808 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_808.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_809 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_809.setFormal(symbol_120);	
				symbol_809.setActual(symbol_248);	
				symbol_808.getParameterSubstitutions().add(symbol_809);
			}
			symbol_231.getTemplateBindings().add(symbol_808);
		}
		symbol_231.getSuperClasses().add(symbol_168); // $ocl!Collection[Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}]
		symbol_130.getOwnedTypes().add(symbol_231);
		//
		// ocl::$$::Lambda Lambda~$ocl!Bag{T}?T()Boolean
		//
		symbol_232.setName("Lambda");
		//symbol_232.setMoniker("Lambda~$ocl!Bag{T}?T()Boolean");
		symbol_232.setContextType(symbol_15);
		symbol_232.setResultType(symbol_122);
		symbol_130.getOwnedTypes().add(symbol_232);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_233.setName("Lambda");
		//symbol_233.setMoniker("Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_233.setContextType(symbol_32);
		symbol_233.setResultType(symbol_38);
		symbol_130.getOwnedTypes().add(symbol_233);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_234.setName("Lambda");
		//symbol_234.setMoniker("Lambda~$ocl!Collection{T}?T()$ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_234.setContextType(symbol_32);
		symbol_234.setResultType(symbol_35);
		symbol_130.getOwnedTypes().add(symbol_234);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()$ocl!OclAny
		//
		symbol_235.setName("Lambda");
		//symbol_235.setMoniker("Lambda~$ocl!Collection{T}?T()$ocl!OclAny");
		symbol_235.setContextType(symbol_32);
		symbol_235.setResultType(symbol_69);
		symbol_130.getOwnedTypes().add(symbol_235);
		//
		// ocl::$$::Lambda Lambda~$ocl!Collection{T}?T()Boolean
		//
		symbol_236.setName("Lambda");
		//symbol_236.setMoniker("Lambda~$ocl!Collection{T}?T()Boolean");
		symbol_236.setContextType(symbol_32);
		symbol_236.setResultType(symbol_122);
		symbol_130.getOwnedTypes().add(symbol_236);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_237.setName("Lambda");
		//symbol_237.setMoniker("Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_237.setContextType(symbol_58);
		symbol_237.setResultType(symbol_64);
		symbol_130.getOwnedTypes().add(symbol_237);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_238.setName("Lambda");
		//symbol_238.setMoniker("Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_238.setContextType(symbol_58);
		symbol_238.setResultType(symbol_61);
		symbol_130.getOwnedTypes().add(symbol_238);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]
		//
		symbol_239.setName("Lambda");
		//symbol_239.setMoniker("Lambda~$ocl!NonOrderedCollection{T}?T()$ocl!Set[T]");
		symbol_239.setContextType(symbol_58);
		symbol_239.setResultType(symbol_214);
		symbol_130.getOwnedTypes().add(symbol_239);
		//
		// ocl::$$::Lambda Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny
		//
		symbol_240.setName("Lambda");
		//symbol_240.setMoniker("Lambda~$ocl!NonUniqueCollection{T}?T()$ocl!OclAny");
		symbol_240.setContextType(symbol_68);
		symbol_240.setResultType(symbol_69);
		symbol_130.getOwnedTypes().add(symbol_240);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_241.setName("Lambda");
		//symbol_241.setMoniker("Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_241.setContextType(symbol_89);
		symbol_241.setResultType(symbol_95);
		symbol_130.getOwnedTypes().add(symbol_241);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_242.setName("Lambda");
		//symbol_242.setMoniker("Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_242.setContextType(symbol_89);
		symbol_242.setResultType(symbol_92);
		symbol_130.getOwnedTypes().add(symbol_242);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]
		//
		symbol_243.setName("Lambda");
		//symbol_243.setMoniker("Lambda~$ocl!OrderedCollection{T}?T()$ocl!OrderedSet[T]");
		symbol_243.setContextType(symbol_89);
		symbol_243.setResultType(symbol_201);
		symbol_130.getOwnedTypes().add(symbol_243);
		//
		// ocl::$$::Lambda Lambda~$ocl!OrderedSet{T}?T()Boolean
		//
		symbol_244.setName("Lambda");
		//symbol_244.setMoniker("Lambda~$ocl!OrderedSet{T}?T()Boolean");
		symbol_244.setContextType(symbol_99);
		symbol_244.setResultType(symbol_122);
		symbol_130.getOwnedTypes().add(symbol_244);
		//
		// ocl::$$::Lambda Lambda~$ocl!Sequence{T}?T()Boolean
		//
		symbol_245.setName("Lambda");
		//symbol_245.setMoniker("Lambda~$ocl!Sequence{T}?T()Boolean");
		symbol_245.setContextType(symbol_106);
		symbol_245.setResultType(symbol_122);
		symbol_130.getOwnedTypes().add(symbol_245);
		//
		// ocl::$$::Lambda Lambda~$ocl!Set{T}?T()Boolean
		//
		symbol_246.setName("Lambda");
		//symbol_246.setMoniker("Lambda~$ocl!Set{T}?T()Boolean");
		symbol_246.setContextType(symbol_113);
		symbol_246.setResultType(symbol_122);
		symbol_130.getOwnedTypes().add(symbol_246);
		//
		// ocl::$$::Lambda Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny
		//
		symbol_247.setName("Lambda");
		//symbol_247.setMoniker("Lambda~$ocl!UniqueCollection{T}?T()$ocl!OclAny");
		symbol_247.setContextType(symbol_121);
		symbol_247.setResultType(symbol_69);
		symbol_130.getOwnedTypes().add(symbol_247);
		//
		// ocl::$$::Tuple Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}
		//
		symbol_248.setName("Tuple");
		//symbol_248.setMoniker("Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}");
		symbol_248.getSuperClasses().add(symbol_117); // $ocl!Tuple
		{ // ocl::$$::Tuple::first Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!first
			symbol_249.setName("first");
			symbol_249.setType(symbol_32);  // $ocl!Collection{T}?T
			
			symbol_249.setIsResolveProxies(true);
			symbol_248.getOwnedAttributes().add(symbol_249);
		}
		{ // ocl::$$::Tuple::second Tuple{first:$ocl!Collection{T}?T,second:$ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2}!second
			symbol_250.setName("second");
			symbol_250.setType(symbol_53);  // $ocl!Collection{T}!product{T2}($ocl!Collection[T2])?T2
			
			symbol_250.setIsResolveProxies(true);
			symbol_248.getOwnedAttributes().add(symbol_250);
		}
		symbol_130.getOwnedTypes().add(symbol_248);
		symbol_1.getNestedPackages().add(symbol_130);
		return symbol_1;
	}
}
