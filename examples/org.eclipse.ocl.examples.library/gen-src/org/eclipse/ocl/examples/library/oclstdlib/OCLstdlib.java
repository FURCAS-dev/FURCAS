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
 * $Id: OCLstdlib.java,v 1.17 2011/04/27 06:20:07 ewillink Exp $
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
		
		
		ClassifierType symbol_23 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier{T}
		TemplateSignature symbol_24 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Classifier{T}!
		TypeTemplateParameter symbol_25 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_26 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier{T}?T
		
		TemplateSignature symbol_27 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Classifier{T}!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_28 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_29 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf
		
		TemplateSignature symbol_30 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Classifier{T}!oclContainer{U}()!
		TypeTemplateParameter symbol_31 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_32 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier{T}!oclContainer{U}()?U
		
		TemplateSignature symbol_33 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Classifier{T}!oclContents{U}()!
		TypeTemplateParameter symbol_34 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_35 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier{T}!oclContents{U}()?U
		
		
		CollectionType symbol_36 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection{T}
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}?T
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_46 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_47 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_49 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_50 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_52 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_53 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_55 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_56 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_57 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_58 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_59 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_60 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
		
		
		Class symbol_61 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration
		TemplateSignature symbol_62 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Enumeration!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_63 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_64 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration!allInstances{OclSelf}()?OclSelf
		
		
		PrimitiveType symbol_65 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_66 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection{T}
		TemplateSignature symbol_67 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_68 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_69 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_70 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_71 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_72 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_73 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_74 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_75 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_76 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection{T}
		TemplateSignature symbol_77 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_78 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_79 = PivotFactory.eINSTANCE.createClass(); // ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_80 = PivotFactory.eINSTANCE.createAnyType(); // ocl!OclAny
		TemplateSignature symbol_81 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsSet{OclSelf}()!
		TypeTemplateParameter symbol_82 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_84 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])!
		TypeTemplateParameter symbol_85 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT
		
		TemplateSignature symbol_87 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])!
		TypeTemplateParameter symbol_88 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T
		
		TemplateSignature symbol_90 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])!
		TypeTemplateParameter symbol_91 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_92 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T
		
		TemplateSignature symbol_93 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclType{OclSelf}()!
		TypeTemplateParameter symbol_94 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_95 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclType{OclSelf}()?OclSelf
		
		
		InvalidType symbol_96 = PivotFactory.eINSTANCE.createInvalidType(); // ocl!OclInvalid
		Property symbol_97 = PivotFactory.eINSTANCE.createProperty(); // ocl::OclInvalid::oclBadProperty ocl!OclInvalid!oclBadProperty
		TemplateSignature symbol_98 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclInvalid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_99 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_100 = PivotFactory.eINSTANCE.createClass(); // ocl!OclInvalid!allInstances{OclSelf}()?OclSelf
		
		
		Class symbol_101 = PivotFactory.eINSTANCE.createClass(); // ocl!OclMessage
		
		Class symbol_102 = PivotFactory.eINSTANCE.createClass(); // ocl!OclState
		
		Class symbol_103 = PivotFactory.eINSTANCE.createClass(); // ocl!OclTuple
		
		VoidType symbol_104 = PivotFactory.eINSTANCE.createVoidType(); // ocl!OclVoid
		TemplateSignature symbol_105 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclVoid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_106 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_107 = PivotFactory.eINSTANCE.createClass(); // ocl!OclVoid!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_108 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection{T}
		TemplateSignature symbol_109 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_110 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_111 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_112 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_113 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_114 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_115 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_116 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_117 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_118 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet{T}
		TemplateSignature symbol_119 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_120 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_121 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}?T
		
		TemplateSignature symbol_122 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!flatten{T2}()!
		TypeTemplateParameter symbol_123 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_124 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_125 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_126 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{TT}(ocl!Classifier[TT])!
		TypeTemplateParameter symbol_127 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_128 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{TT}(ocl!Classifier[TT])?TT
		
		
		SequenceType symbol_129 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence{T}
		TemplateSignature symbol_130 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!
		TypeTemplateParameter symbol_131 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_132 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}?T
		
		TemplateSignature symbol_133 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_134 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_135 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_136 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set{T}
		TemplateSignature symbol_137 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!
		TypeTemplateParameter symbol_138 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_139 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}?T
		
		TemplateSignature symbol_140 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_141 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_142 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_143 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		TupleType symbol_144 = PivotFactory.eINSTANCE.createTupleType(); // ocl!Tuple
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection{T}
		TemplateSignature symbol_146 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_147 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_148 = PivotFactory.eINSTANCE.createClass(); // ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_149 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_150 = PivotFactory.eINSTANCE.createPackage(); // $orphanage
		Class symbol_151 = PivotFactory.eINSTANCE.createClass(); // $orphanage!$orphanage
		
		BagType symbol_152 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_153 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		
		BagType symbol_154 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		BagType symbol_155 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Collection{T}?T]
		
		BagType symbol_156 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}?T]
		
		ClassifierType symbol_157 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]
		
		ClassifierType symbol_158 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]
		
		ClassifierType symbol_159 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]
		
		ClassifierType symbol_160 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
		
		ClassifierType symbol_161 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]
		
		ClassifierType symbol_162 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
		
		ClassifierType symbol_163 = PivotFactory.eINSTANCE.createClassifierType(); // ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_193 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		
		LambdaType symbol_194 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_195 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		
		LambdaType symbol_196 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_197 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		
		LambdaType symbol_198 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Set{T}?T()Boolean
		
		LambdaType symbol_199 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedSet{T}?T()Boolean
		
		LambdaType symbol_200 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_201 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_202 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Sequence{T}?T()Boolean
		
		LambdaType symbol_203 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!OclAny
		
		LambdaType symbol_204 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_205 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Bag{T}?T()Boolean
		
		LambdaType symbol_206 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_207 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()Boolean
		
		LambdaType symbol_208 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_209 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_216 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_217 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_218 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_219 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_220 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_221 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_222 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_223 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_224 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_225 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_226 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_227 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_228 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_229 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_230 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_231 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_232 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_233 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_234 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_235 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_236 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_237 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_238 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_239 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_240 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_241 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_242 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_243 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		CollectionType symbol_244 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_245 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_246 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_247 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		OrderedSetType symbol_248 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_249 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_250 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_251 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		OrderedSetType symbol_252 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		SequenceType symbol_253 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_254 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_255 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SequenceType symbol_256 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_257 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_258 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_259 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SetType symbol_260 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		SetType symbol_261 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_262 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_263 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_264 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		SetType symbol_265 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_266 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_267 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_268 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_269 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_270 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_271 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_272 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_273 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		TupleType symbol_274 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_275 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_276 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_277 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_278 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_279 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_280 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_281 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_282 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_283 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_284 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_285 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_286 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_287 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_288 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_289 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_290 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_291 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_292 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_293 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		

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
		symbol_12.getSuperClasses().add(symbol_237); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_213); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_294 = PivotFactory.eINSTANCE.createOperation();
			symbol_294.setName("<>");
			//symbol_294.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_294.setType(symbol_19);  // Boolean
			
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("object2");
			//symbol_295.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_295.setType(symbol_80);  // ocl!OclAny
			
			symbol_294.getOwnedParameters().add(symbol_295);
			symbol_294.setPrecedence(symbol_7);
			symbol_294.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_296 = PivotFactory.eINSTANCE.createOperation();
			symbol_296.setName("=");
			//symbol_296.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_296.setType(symbol_19);  // Boolean
			
			Parameter symbol_297 = PivotFactory.eINSTANCE.createParameter();
			symbol_297.setName("object2");
			//symbol_297.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_297.setType(symbol_80);  // ocl!OclAny
			
			symbol_296.getOwnedParameters().add(symbol_297);
			symbol_296.setPrecedence(symbol_7);
			symbol_296.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_296.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_296);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_298 = PivotFactory.eINSTANCE.createOperation();
			symbol_298.setName("excluding");
			//symbol_298.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_298.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("object");
			//symbol_299.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_299.setType(symbol_80);  // ocl!OclAny
			
			symbol_298.getOwnedParameters().add(symbol_299);
			symbol_298.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_298.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_298);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_300 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_300.setOwnedTemplateSignature(symbol_16);
			symbol_300.setName("flatten");
			//symbol_300.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_300.setType(symbol_153);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			
			symbol_300.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_301.setName("including");
			//symbol_301.setMoniker("ocl!Bag{T}!including(T)");
			symbol_301.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_302 = PivotFactory.eINSTANCE.createParameter();
			symbol_302.setName("object");
			//symbol_302.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_302.setType(symbol_15);  // ocl!Bag{T}?T
			
			symbol_301.getOwnedParameters().add(symbol_302);
			symbol_301.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_303 = PivotFactory.eINSTANCE.createIteration();
			symbol_303.setName("reject");
			//symbol_303.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)");
			symbol_303.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("i");
			symbol_304.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_303.getOwnedIterators().add(symbol_304);
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("body");
			//symbol_305.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_305.setType(symbol_205);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_303.getOwnedParameters().add(symbol_305);
			symbol_303.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_303);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_306 = PivotFactory.eINSTANCE.createIteration();
			symbol_306.setName("select");
			//symbol_306.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_306.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("i");
			symbol_307.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_306.getOwnedIterators().add(symbol_307);
			Parameter symbol_308 = PivotFactory.eINSTANCE.createParameter();
			symbol_308.setName("body");
			//symbol_308.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_308.setType(symbol_205);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_306.getOwnedParameters().add(symbol_308);
			symbol_306.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_306.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_306);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_309 = PivotFactory.eINSTANCE.createOperation();
			symbol_309.setName("<>");
			//symbol_309.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_309.setType(symbol_19);  // Boolean
			
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("object2");
			//symbol_310.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_310.setType(symbol_80);  // ocl!OclAny
			
			symbol_309.getOwnedParameters().add(symbol_310);
			symbol_309.setPrecedence(symbol_7);
			symbol_309.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("=");
			//symbol_311.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_311.setType(symbol_19);  // Boolean
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("object2");
			//symbol_312.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_312.setType(symbol_80);  // ocl!OclAny
			
			symbol_311.getOwnedParameters().add(symbol_312);
			symbol_311.setPrecedence(symbol_7);
			symbol_311.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances{OclSelf}()
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_22.setName("OclSelf");
			symbol_21.setOwnedParameteredElement(symbol_22);
			symbol_20.getOwnedParameters().add(symbol_21);
			
			symbol_313.setOwnedTemplateSignature(symbol_20);
			symbol_313.setName("allInstances");
			//symbol_313.setMoniker("Boolean!allInstances{OclSelf}()");
			symbol_313.setType(symbol_269);  // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
			
			symbol_313.setIsStatic(true);
			symbol_313.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation");
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_313);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_314 = PivotFactory.eINSTANCE.createOperation();
			symbol_314.setName("and");
			//symbol_314.setMoniker("Boolean!and(Boolean)");
			symbol_314.setType(symbol_19);  // Boolean
			
			Parameter symbol_315 = PivotFactory.eINSTANCE.createParameter();
			symbol_315.setName("b");
			//symbol_315.setMoniker("Boolean!and(Boolean)!b");
			symbol_315.setType(symbol_19);  // Boolean
			
			symbol_314.getOwnedParameters().add(symbol_315);
			symbol_314.setPrecedence(symbol_8);
			symbol_314.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAndOperation");
			symbol_314.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_314);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("implies");
			//symbol_316.setMoniker("Boolean!implies(Boolean)");
			symbol_316.setType(symbol_19);  // Boolean
			
			Parameter symbol_317 = PivotFactory.eINSTANCE.createParameter();
			symbol_317.setName("b");
			//symbol_317.setMoniker("Boolean!implies(Boolean)!b");
			symbol_317.setType(symbol_19);  // Boolean
			
			symbol_316.getOwnedParameters().add(symbol_317);
			symbol_316.setPrecedence(symbol_11);
			symbol_316.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation");
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_318 = PivotFactory.eINSTANCE.createOperation();
			symbol_318.setName("not");
			//symbol_318.setMoniker("Boolean!not()");
			symbol_318.setType(symbol_19);  // Boolean
			
			symbol_318.setPrecedence(symbol_3);
			symbol_318.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanNotOperation");
			symbol_318.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_318);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_319 = PivotFactory.eINSTANCE.createOperation();
			symbol_319.setName("or");
			//symbol_319.setMoniker("Boolean!or(Boolean)");
			symbol_319.setType(symbol_19);  // Boolean
			
			Parameter symbol_320 = PivotFactory.eINSTANCE.createParameter();
			symbol_320.setName("b");
			//symbol_320.setMoniker("Boolean!or(Boolean)!b");
			symbol_320.setType(symbol_19);  // Boolean
			
			symbol_319.getOwnedParameters().add(symbol_320);
			symbol_319.setPrecedence(symbol_9);
			symbol_319.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanOrOperation");
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_319);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_321 = PivotFactory.eINSTANCE.createOperation();
			symbol_321.setName("toString");
			//symbol_321.setMoniker("Boolean!toString()");
			symbol_321.setType(symbol_143);  // String
			
			symbol_321.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_321.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_321);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_322 = PivotFactory.eINSTANCE.createOperation();
			symbol_322.setName("xor");
			//symbol_322.setMoniker("Boolean!xor(Boolean)");
			symbol_322.setType(symbol_19);  // Boolean
			
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("b");
			//symbol_323.setMoniker("Boolean!xor(Boolean)!b");
			symbol_323.setType(symbol_19);  // Boolean
			
			symbol_322.getOwnedParameters().add(symbol_323);
			symbol_322.setPrecedence(symbol_10);
			symbol_322.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanXorOperation");
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_322);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl!Classifier{T}
		//
		symbol_23.setName("Classifier");
		//symbol_23.setMoniker("ocl!Classifier{T}");
		symbol_23.setInstanceType(symbol_26);
		symbol_26.setName("T");
		symbol_25.setOwnedParameteredElement(symbol_26);
		symbol_24.getOwnedParameters().add(symbol_25);
		
		symbol_23.setOwnedTemplateSignature(symbol_24);
		symbol_23.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Classifier::allInstances() ocl!Classifier{T}!allInstances{OclSelf}()
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_29.setName("OclSelf");
			symbol_28.setOwnedParameteredElement(symbol_29);
			symbol_27.getOwnedParameters().add(symbol_28);
			
			symbol_324.setOwnedTemplateSignature(symbol_27);
			symbol_324.setName("allInstances");
			//symbol_324.setMoniker("ocl!Classifier{T}!allInstances{OclSelf}()");
			symbol_324.setType(symbol_267);  // ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
			
			symbol_324.setIsStatic(true);
			symbol_324.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation");
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Classifier::oclContainer() ocl!Classifier{T}!oclContainer{U}()
			Operation symbol_325 = PivotFactory.eINSTANCE.createOperation();
			symbol_32.setName("U");
			symbol_31.setOwnedParameteredElement(symbol_32);
			symbol_30.getOwnedParameters().add(symbol_31);
			
			symbol_325.setOwnedTemplateSignature(symbol_30);
			symbol_325.setName("oclContainer");
			//symbol_325.setMoniker("ocl!Classifier{T}!oclContainer{U}()");
			symbol_325.setType(symbol_159);  // ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]
			
			symbol_325.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation");
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::Classifier::oclContents() ocl!Classifier{T}!oclContents{U}()
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_35.setName("U");
			symbol_34.setOwnedParameteredElement(symbol_35);
			symbol_33.getOwnedParameters().add(symbol_34);
			
			symbol_326.setOwnedTemplateSignature(symbol_33);
			symbol_326.setName("oclContents");
			//symbol_326.setMoniker("ocl!Classifier{T}!oclContents{U}()");
			symbol_326.setType(symbol_264);  // ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
			
			symbol_326.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation");
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_326);
		}
		symbol_1.getOwnedTypes().add(symbol_23);
		//
		// ocl::Collection ocl!Collection{T}
		//
		symbol_36.setName("Collection");
		//symbol_36.setMoniker("ocl!Collection{T}");
		symbol_36.setElementType(symbol_39);
		symbol_39.setName("T");
		symbol_38.setOwnedParameteredElement(symbol_39);
		symbol_37.getOwnedParameters().add(symbol_38);
		
		symbol_36.setOwnedTemplateSignature(symbol_37);
		symbol_36.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Collection::<>() ocl!Collection{T}!<>(ocl!OclAny)
			Operation symbol_327 = PivotFactory.eINSTANCE.createOperation();
			symbol_327.setName("<>");
			//symbol_327.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_327.setType(symbol_19);  // Boolean
			
			Parameter symbol_328 = PivotFactory.eINSTANCE.createParameter();
			symbol_328.setName("object2");
			//symbol_328.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_328.setType(symbol_80);  // ocl!OclAny
			
			symbol_327.getOwnedParameters().add(symbol_328);
			symbol_327.setPrecedence(symbol_7);
			symbol_327.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_327.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_327);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_329 = PivotFactory.eINSTANCE.createOperation();
			symbol_329.setName("=");
			//symbol_329.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_329.setType(symbol_19);  // Boolean
			
			Parameter symbol_330 = PivotFactory.eINSTANCE.createParameter();
			symbol_330.setName("object2");
			//symbol_330.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_330.setType(symbol_80);  // ocl!OclAny
			
			symbol_329.getOwnedParameters().add(symbol_330);
			symbol_329.setPrecedence(symbol_7);
			symbol_329.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_329.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_329);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_331 = PivotFactory.eINSTANCE.createIteration();
			symbol_331.setName("any");
			//symbol_331.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_331.setType(symbol_39);  // ocl!Collection{T}?T
			
			Parameter symbol_332 = PivotFactory.eINSTANCE.createParameter();
			symbol_332.setName("i");
			symbol_332.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_331.getOwnedIterators().add(symbol_332);
			Parameter symbol_333 = PivotFactory.eINSTANCE.createParameter();
			symbol_333.setName("body");
			//symbol_333.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_333.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_331.getOwnedParameters().add(symbol_333);
			symbol_331.setImplementationClass("org.eclipse.ocl.examples.library.iterator.AnyIteration");
			symbol_331.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_331);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_334 = PivotFactory.eINSTANCE.createOperation();
			symbol_334.setName("asBag");
			//symbol_334.setMoniker("ocl!Collection{T}!asBag()");
			symbol_334.setType(symbol_155);  // ocl!Bag[ocl!Collection{T}?T]
			
			symbol_334.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation");
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_335 = PivotFactory.eINSTANCE.createOperation();
			symbol_335.setName("asOrderedSet");
			//symbol_335.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_335.setType(symbol_251);  // ocl!OrderedSet[ocl!Collection{T}?T]
			
			symbol_335.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation");
			symbol_335.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_335);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_336 = PivotFactory.eINSTANCE.createOperation();
			symbol_336.setName("asSequence");
			//symbol_336.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_336.setType(symbol_257);  // ocl!Sequence[ocl!Collection{T}?T]
			
			symbol_336.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation");
			symbol_336.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_336);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_337 = PivotFactory.eINSTANCE.createOperation();
			symbol_337.setName("asSet");
			//symbol_337.setMoniker("ocl!Collection{T}!asSet()");
			symbol_337.setType(symbol_273);  // ocl!Set[ocl!Collection{T}?T]
			
			symbol_337.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation");
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_338 = PivotFactory.eINSTANCE.createIteration();
			symbol_42.setName("V");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_338.setOwnedTemplateSignature(symbol_40);
			symbol_338.setName("collect");
			//symbol_338.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_338.setType(symbol_169);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("i");
			symbol_339.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_338.getOwnedIterators().add(symbol_339);
			Parameter symbol_340 = PivotFactory.eINSTANCE.createParameter();
			symbol_340.setName("body");
			//symbol_340.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_340.setType(symbol_201);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_338.getOwnedParameters().add(symbol_340);
			symbol_338.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_341 = PivotFactory.eINSTANCE.createIteration();
			symbol_45.setName("V");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_341.setOwnedTemplateSignature(symbol_43);
			symbol_341.setName("collectNested");
			//symbol_341.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_341.setType(symbol_173);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("i");
			symbol_342.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_341.getOwnedIterators().add(symbol_342);
			Parameter symbol_343 = PivotFactory.eINSTANCE.createParameter();
			symbol_343.setName("body");
			//symbol_343.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_343.setType(symbol_200);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_341.getOwnedParameters().add(symbol_343);
			symbol_341.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_344 = PivotFactory.eINSTANCE.createOperation();
			symbol_344.setName("count");
			//symbol_344.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_344.setType(symbol_65);  // Integer
			
			Parameter symbol_345 = PivotFactory.eINSTANCE.createParameter();
			symbol_345.setName("object");
			//symbol_345.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_345.setType(symbol_80);  // ocl!OclAny
			
			symbol_344.getOwnedParameters().add(symbol_345);
			symbol_344.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionCountOperation");
			symbol_344.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_344);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_346 = PivotFactory.eINSTANCE.createOperation();
			symbol_346.setName("excludes");
			//symbol_346.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_346.setType(symbol_19);  // Boolean
			
			Parameter symbol_347 = PivotFactory.eINSTANCE.createParameter();
			symbol_347.setName("object");
			//symbol_347.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_347.setType(symbol_80);  // ocl!OclAny
			
			symbol_346.getOwnedParameters().add(symbol_347);
			symbol_346.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation");
			symbol_346.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_346);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_348 = PivotFactory.eINSTANCE.createOperation();
			symbol_48.setName("T2");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_348.setOwnedTemplateSignature(symbol_46);
			symbol_348.setName("excludesAll");
			//symbol_348.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_348.setType(symbol_19);  // Boolean
			
			Parameter symbol_349 = PivotFactory.eINSTANCE.createParameter();
			symbol_349.setName("c2");
			//symbol_349.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_349.setType(symbol_172);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_348.getOwnedParameters().add(symbol_349);
			symbol_348.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation");
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_348);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_350 = PivotFactory.eINSTANCE.createOperation();
			symbol_350.setName("excluding");
			//symbol_350.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_350.setType(symbol_173);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_351 = PivotFactory.eINSTANCE.createParameter();
			symbol_351.setName("object");
			//symbol_351.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_351.setType(symbol_80);  // ocl!OclAny
			
			symbol_350.getOwnedParameters().add(symbol_351);
			symbol_350.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_350.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_350);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_352 = PivotFactory.eINSTANCE.createIteration();
			symbol_352.setName("exists");
			//symbol_352.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_352.setType(symbol_19);  // Boolean
			
			Parameter symbol_353 = PivotFactory.eINSTANCE.createParameter();
			symbol_353.setName("i");
			symbol_353.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_352.getOwnedIterators().add(symbol_353);
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("body");
			//symbol_354.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_354.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_352.getOwnedParameters().add(symbol_354);
			symbol_352.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_352.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_352);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_355 = PivotFactory.eINSTANCE.createIteration();
			symbol_355.setName("exists");
			//symbol_355.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_355.setType(symbol_19);  // Boolean
			
			Parameter symbol_356 = PivotFactory.eINSTANCE.createParameter();
			symbol_356.setName("j");
			symbol_356.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_355.getOwnedIterators().add(symbol_356);
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("i");
			symbol_357.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_355.getOwnedIterators().add(symbol_357);
			Parameter symbol_358 = PivotFactory.eINSTANCE.createParameter();
			symbol_358.setName("body");
			//symbol_358.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_358.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_355.getOwnedParameters().add(symbol_358);
			symbol_355.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_355);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_359 = PivotFactory.eINSTANCE.createOperation();
			symbol_51.setName("T2");
			symbol_50.setOwnedParameteredElement(symbol_51);
			symbol_49.getOwnedParameters().add(symbol_50);
			
			symbol_359.setOwnedTemplateSignature(symbol_49);
			symbol_359.setName("flatten");
			//symbol_359.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_359.setType(symbol_184);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			
			symbol_359.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_359.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_359);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_360 = PivotFactory.eINSTANCE.createIteration();
			symbol_360.setName("forAll");
			//symbol_360.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_360.setType(symbol_19);  // Boolean
			
			Parameter symbol_361 = PivotFactory.eINSTANCE.createParameter();
			symbol_361.setName("i");
			symbol_361.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_360.getOwnedIterators().add(symbol_361);
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("body");
			//symbol_362.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_362.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_360.getOwnedParameters().add(symbol_362);
			symbol_360.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_363 = PivotFactory.eINSTANCE.createIteration();
			symbol_363.setName("forAll");
			//symbol_363.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_363.setType(symbol_19);  // Boolean
			
			Parameter symbol_364 = PivotFactory.eINSTANCE.createParameter();
			symbol_364.setName("i");
			symbol_364.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_363.getOwnedIterators().add(symbol_364);
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("j");
			symbol_365.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_363.getOwnedIterators().add(symbol_365);
			Parameter symbol_366 = PivotFactory.eINSTANCE.createParameter();
			symbol_366.setName("body");
			//symbol_366.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_366.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_363.getOwnedParameters().add(symbol_366);
			symbol_363.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_363.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_363);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_367.setName("includes");
			//symbol_367.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_367.setType(symbol_19);  // Boolean
			
			Parameter symbol_368 = PivotFactory.eINSTANCE.createParameter();
			symbol_368.setName("object");
			//symbol_368.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_368.setType(symbol_80);  // ocl!OclAny
			
			symbol_367.getOwnedParameters().add(symbol_368);
			symbol_367.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation");
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_369 = PivotFactory.eINSTANCE.createOperation();
			symbol_54.setName("T2");
			symbol_53.setOwnedParameteredElement(symbol_54);
			symbol_52.getOwnedParameters().add(symbol_53);
			
			symbol_369.setOwnedTemplateSignature(symbol_52);
			symbol_369.setName("includesAll");
			//symbol_369.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_369.setType(symbol_19);  // Boolean
			
			Parameter symbol_370 = PivotFactory.eINSTANCE.createParameter();
			symbol_370.setName("c2");
			//symbol_370.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_370.setType(symbol_188);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_369.getOwnedParameters().add(symbol_370);
			symbol_369.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation");
			symbol_369.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_369);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("including");
			//symbol_371.setMoniker("ocl!Collection{T}!including(T)");
			symbol_371.setType(symbol_173);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_372 = PivotFactory.eINSTANCE.createParameter();
			symbol_372.setName("object");
			//symbol_372.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_372.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_371.getOwnedParameters().add(symbol_372);
			symbol_371.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_373 = PivotFactory.eINSTANCE.createOperation();
			symbol_373.setName("isEmpty");
			//symbol_373.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_373.setType(symbol_19);  // Boolean
			
			symbol_373.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation");
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_373);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)
			Iteration symbol_374 = PivotFactory.eINSTANCE.createIteration();
			symbol_374.setName("isUnique");
			//symbol_374.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)");
			symbol_374.setType(symbol_19);  // Boolean
			
			Parameter symbol_375 = PivotFactory.eINSTANCE.createParameter();
			symbol_375.setName("i");
			symbol_375.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_374.getOwnedIterators().add(symbol_375);
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("body");
			//symbol_376.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)!body");
			symbol_376.setType(symbol_203);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_374.getOwnedParameters().add(symbol_376);
			symbol_374.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IsUniqueIteration");
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_377 = PivotFactory.eINSTANCE.createIteration();
			symbol_57.setName("Tacc");
			symbol_56.setOwnedParameteredElement(symbol_57);
			symbol_55.getOwnedParameters().add(symbol_56);
			
			symbol_377.setOwnedTemplateSignature(symbol_55);
			symbol_377.setName("iterate");
			//symbol_377.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_377.setType(symbol_57);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("i");
			symbol_378.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_377.getOwnedIterators().add(symbol_378);
			Parameter symbol_379 = PivotFactory.eINSTANCE.createParameter();
			symbol_379.setName("acc");
			symbol_379.setType(symbol_57);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_377.getOwnedAccumulators().add(symbol_379);
			symbol_377.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IterateIteration");
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_380 = PivotFactory.eINSTANCE.createOperation();
			symbol_380.setName("max");
			//symbol_380.setMoniker("ocl!Collection{T}!max()");
			symbol_380.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_380.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMaxOperation");
			symbol_380.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_380);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_381 = PivotFactory.eINSTANCE.createOperation();
			symbol_381.setName("min");
			//symbol_381.setMoniker("ocl!Collection{T}!min()");
			symbol_381.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_381.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMinOperation");
			symbol_381.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_381);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_382 = PivotFactory.eINSTANCE.createOperation();
			symbol_382.setName("notEmpty");
			//symbol_382.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_382.setType(symbol_19);  // Boolean
			
			symbol_382.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation");
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_382);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_383 = PivotFactory.eINSTANCE.createIteration();
			symbol_383.setName("one");
			//symbol_383.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_383.setType(symbol_19);  // Boolean
			
			Parameter symbol_384 = PivotFactory.eINSTANCE.createParameter();
			symbol_384.setName("i");
			symbol_384.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_383.getOwnedIterators().add(symbol_384);
			Parameter symbol_385 = PivotFactory.eINSTANCE.createParameter();
			symbol_385.setName("body");
			//symbol_385.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_385.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_383.getOwnedParameters().add(symbol_385);
			symbol_383.setImplementationClass("org.eclipse.ocl.examples.library.iterator.OneIteration");
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_383);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_386 = PivotFactory.eINSTANCE.createOperation();
			symbol_60.setName("T2");
			symbol_59.setOwnedParameteredElement(symbol_60);
			symbol_58.getOwnedParameters().add(symbol_59);
			
			symbol_386.setOwnedTemplateSignature(symbol_58);
			symbol_386.setName("product");
			//symbol_386.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_386.setType(symbol_260);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			
			Parameter symbol_387 = PivotFactory.eINSTANCE.createParameter();
			symbol_387.setName("c2");
			//symbol_387.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_387.setType(symbol_193);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			
			symbol_386.getOwnedParameters().add(symbol_387);
			symbol_386.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionProductOperation");
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_388 = PivotFactory.eINSTANCE.createIteration();
			symbol_388.setName("reject");
			//symbol_388.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_388.setType(symbol_173);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_389 = PivotFactory.eINSTANCE.createParameter();
			symbol_389.setName("i");
			symbol_389.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_388.getOwnedIterators().add(symbol_389);
			Parameter symbol_390 = PivotFactory.eINSTANCE.createParameter();
			symbol_390.setName("body");
			//symbol_390.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_390.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_388.getOwnedParameters().add(symbol_390);
			symbol_388.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_388.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_388);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_391 = PivotFactory.eINSTANCE.createIteration();
			symbol_391.setName("select");
			//symbol_391.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_391.setType(symbol_173);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("i");
			symbol_392.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_391.getOwnedIterators().add(symbol_392);
			Parameter symbol_393 = PivotFactory.eINSTANCE.createParameter();
			symbol_393.setName("body");
			//symbol_393.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_393.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_391.getOwnedParameters().add(symbol_393);
			symbol_391.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_394 = PivotFactory.eINSTANCE.createOperation();
			symbol_394.setName("size");
			//symbol_394.setMoniker("ocl!Collection{T}!size()");
			symbol_394.setType(symbol_65);  // Integer
			
			symbol_394.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSizeOperation");
			symbol_394.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_394);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_395 = PivotFactory.eINSTANCE.createIteration();
			symbol_395.setName("sortedBy");
			//symbol_395.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_395.setType(symbol_239);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_396 = PivotFactory.eINSTANCE.createParameter();
			symbol_396.setName("i");
			symbol_396.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_395.getOwnedIterators().add(symbol_396);
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("body");
			//symbol_397.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_397.setType(symbol_203);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_395.getOwnedParameters().add(symbol_397);
			symbol_395.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_395);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_398 = PivotFactory.eINSTANCE.createOperation();
			symbol_398.setName("sum");
			//symbol_398.setMoniker("ocl!Collection{T}!sum()");
			symbol_398.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_398.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSumOperation");
			symbol_398.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_398);
		}
		symbol_1.getOwnedTypes().add(symbol_36);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_61.setName("Enumeration");
		//symbol_61.setMoniker("ocl!Enumeration");
		symbol_61.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances{OclSelf}()
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_64.setName("OclSelf");
			symbol_63.setOwnedParameteredElement(symbol_64);
			symbol_62.getOwnedParameters().add(symbol_63);
			
			symbol_399.setOwnedTemplateSignature(symbol_62);
			symbol_399.setName("allInstances");
			//symbol_399.setMoniker("ocl!Enumeration!allInstances{OclSelf}()");
			symbol_399.setType(symbol_262);  // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
			
			symbol_399.setIsStatic(true);
			symbol_399.setImplementationClass("org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation");
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_61.getOwnedOperations().add(symbol_399);
		}
		symbol_1.getOwnedTypes().add(symbol_61);
		//
		// ocl::Integer Integer
		//
		symbol_65.setName("Integer");
		//symbol_65.setMoniker("Integer");
		symbol_65.getSuperClasses().add(symbol_125); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_400 = PivotFactory.eINSTANCE.createOperation();
			symbol_400.setName("*");
			//symbol_400.setMoniker("Integer!*(Integer)");
			symbol_400.setType(symbol_65);  // Integer
			
			Parameter symbol_401 = PivotFactory.eINSTANCE.createParameter();
			symbol_401.setName("i");
			//symbol_401.setMoniker("Integer!*(Integer)!i");
			symbol_401.setType(symbol_65);  // Integer
			
			symbol_400.getOwnedParameters().add(symbol_401);
			symbol_400.setPrecedence(symbol_4);
			symbol_400.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_400.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_400);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_402 = PivotFactory.eINSTANCE.createOperation();
			symbol_402.setName("+");
			//symbol_402.setMoniker("Integer!+(Integer)");
			symbol_402.setType(symbol_65);  // Integer
			
			Parameter symbol_403 = PivotFactory.eINSTANCE.createParameter();
			symbol_403.setName("i");
			//symbol_403.setMoniker("Integer!+(Integer)!i");
			symbol_403.setType(symbol_65);  // Integer
			
			symbol_402.getOwnedParameters().add(symbol_403);
			symbol_402.setPrecedence(symbol_5);
			symbol_402.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericPlusOperation");
			symbol_402.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_402);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_404 = PivotFactory.eINSTANCE.createOperation();
			symbol_404.setName("-");
			//symbol_404.setMoniker("Integer!-()");
			symbol_404.setType(symbol_65);  // Integer
			
			symbol_404.setPrecedence(symbol_3);
			symbol_404.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_404.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_404);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("-");
			//symbol_405.setMoniker("Integer!-(Integer)");
			symbol_405.setType(symbol_65);  // Integer
			
			Parameter symbol_406 = PivotFactory.eINSTANCE.createParameter();
			symbol_406.setName("i");
			//symbol_406.setMoniker("Integer!-(Integer)!i");
			symbol_406.setType(symbol_65);  // Integer
			
			symbol_405.getOwnedParameters().add(symbol_406);
			symbol_405.setPrecedence(symbol_5);
			symbol_405.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinusOperation");
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_405);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_407 = PivotFactory.eINSTANCE.createOperation();
			symbol_407.setName("/");
			//symbol_407.setMoniker("Integer!/(Integer)");
			symbol_407.setType(symbol_125);  // Real
			
			Parameter symbol_408 = PivotFactory.eINSTANCE.createParameter();
			symbol_408.setName("i");
			//symbol_408.setMoniker("Integer!/(Integer)!i");
			symbol_408.setType(symbol_65);  // Integer
			
			symbol_407.getOwnedParameters().add(symbol_408);
			symbol_407.setPrecedence(symbol_4);
			symbol_407.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_407.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_407);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_409.setName("abs");
			//symbol_409.setMoniker("Integer!abs()");
			symbol_409.setType(symbol_65);  // Integer
			
			symbol_409.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_410 = PivotFactory.eINSTANCE.createOperation();
			symbol_410.setName("div");
			//symbol_410.setMoniker("Integer!div(Integer)");
			symbol_410.setType(symbol_65);  // Integer
			
			Parameter symbol_411 = PivotFactory.eINSTANCE.createParameter();
			symbol_411.setName("i");
			//symbol_411.setMoniker("Integer!div(Integer)!i");
			symbol_411.setType(symbol_65);  // Integer
			
			symbol_410.getOwnedParameters().add(symbol_411);
			symbol_410.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivOperation");
			symbol_410.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_410);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_412 = PivotFactory.eINSTANCE.createOperation();
			symbol_412.setName("max");
			//symbol_412.setMoniker("Integer!max(Integer)");
			symbol_412.setType(symbol_65);  // Integer
			
			Parameter symbol_413 = PivotFactory.eINSTANCE.createParameter();
			symbol_413.setName("i");
			//symbol_413.setMoniker("Integer!max(Integer)!i");
			symbol_413.setType(symbol_65);  // Integer
			
			symbol_412.getOwnedParameters().add(symbol_413);
			symbol_412.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_412.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_412);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_414 = PivotFactory.eINSTANCE.createOperation();
			symbol_414.setName("min");
			//symbol_414.setMoniker("Integer!min(Integer)");
			symbol_414.setType(symbol_65);  // Integer
			
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("i");
			//symbol_415.setMoniker("Integer!min(Integer)!i");
			symbol_415.setType(symbol_65);  // Integer
			
			symbol_414.getOwnedParameters().add(symbol_415);
			symbol_414.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_414.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_414);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_416 = PivotFactory.eINSTANCE.createOperation();
			symbol_416.setName("mod");
			//symbol_416.setMoniker("Integer!mod(Integer)");
			symbol_416.setType(symbol_65);  // Integer
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("i");
			//symbol_417.setMoniker("Integer!mod(Integer)!i");
			symbol_417.setType(symbol_65);  // Integer
			
			symbol_416.getOwnedParameters().add(symbol_417);
			symbol_416.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericModOperation");
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("toString");
			//symbol_418.setMoniker("Integer!toString()");
			symbol_418.setType(symbol_143);  // String
			
			symbol_418.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_418.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_418);
		}
		symbol_1.getOwnedTypes().add(symbol_65);
		//
		// ocl::NonOrderedCollection ocl!NonOrderedCollection{T}
		//
		symbol_66.setName("NonOrderedCollection");
		//symbol_66.setMoniker("ocl!NonOrderedCollection{T}");
		symbol_66.setElementType(symbol_69);
		symbol_69.setName("T");
		symbol_68.setOwnedParameteredElement(symbol_69);
		symbol_67.getOwnedParameters().add(symbol_68);
		
		symbol_66.setOwnedTemplateSignature(symbol_67);
		symbol_66.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])
			Iteration symbol_419 = PivotFactory.eINSTANCE.createIteration();
			symbol_419.setName("closure");
			//symbol_419.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])");
			symbol_419.setType(symbol_268);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_420 = PivotFactory.eINSTANCE.createParameter();
			symbol_420.setName("i");
			symbol_420.setType(symbol_69);  // ocl!NonOrderedCollection{T}?T
			symbol_419.getOwnedIterators().add(symbol_420);
			Parameter symbol_421 = PivotFactory.eINSTANCE.createParameter();
			symbol_421.setName("body");
			//symbol_421.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])!body");
			symbol_421.setType(symbol_197);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
			
			symbol_419.getOwnedParameters().add(symbol_421);
			symbol_419.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_422 = PivotFactory.eINSTANCE.createIteration();
			symbol_72.setName("V");
			symbol_71.setOwnedParameteredElement(symbol_72);
			symbol_70.getOwnedParameters().add(symbol_71);
			
			symbol_422.setOwnedTemplateSignature(symbol_70);
			symbol_422.setName("collect");
			//symbol_422.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_422.setType(symbol_154);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_423 = PivotFactory.eINSTANCE.createParameter();
			symbol_423.setName("i");
			symbol_423.setType(symbol_69);  // ocl!NonOrderedCollection{T}?T
			symbol_422.getOwnedIterators().add(symbol_423);
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("body");
			//symbol_424.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_424.setType(symbol_204);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_422.getOwnedParameters().add(symbol_424);
			symbol_422.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_422);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_425 = PivotFactory.eINSTANCE.createIteration();
			symbol_75.setName("V");
			symbol_74.setOwnedParameteredElement(symbol_75);
			symbol_73.getOwnedParameters().add(symbol_74);
			
			symbol_425.setOwnedTemplateSignature(symbol_73);
			symbol_425.setName("collectNested");
			//symbol_425.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_425.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_426 = PivotFactory.eINSTANCE.createParameter();
			symbol_426.setName("i");
			symbol_426.setType(symbol_69);  // ocl!NonOrderedCollection{T}?T
			symbol_425.getOwnedIterators().add(symbol_426);
			Parameter symbol_427 = PivotFactory.eINSTANCE.createParameter();
			symbol_427.setName("body");
			//symbol_427.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_427.setType(symbol_196);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_425.getOwnedParameters().add(symbol_427);
			symbol_425.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_425);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_428 = PivotFactory.eINSTANCE.createOperation();
			symbol_428.setName("intersection");
			//symbol_428.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_428.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_429 = PivotFactory.eINSTANCE.createParameter();
			symbol_429.setName("bag");
			//symbol_429.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_429.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_428.getOwnedParameters().add(symbol_429);
			symbol_428.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_428.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_428);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("intersection");
			//symbol_430.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_430.setType(symbol_268);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("s");
			//symbol_431.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_431.setType(symbol_268);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_430.getOwnedParameters().add(symbol_431);
			symbol_430.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("union");
			//symbol_432.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_432.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_433 = PivotFactory.eINSTANCE.createParameter();
			symbol_433.setName("bag");
			//symbol_433.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_433.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_432.getOwnedParameters().add(symbol_433);
			symbol_432.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_434 = PivotFactory.eINSTANCE.createOperation();
			symbol_434.setName("union");
			//symbol_434.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_434.setType(symbol_268);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_435 = PivotFactory.eINSTANCE.createParameter();
			symbol_435.setName("s");
			//symbol_435.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_435.setType(symbol_268);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_434.getOwnedParameters().add(symbol_435);
			symbol_434.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_434.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_434);
		}
		symbol_1.getOwnedTypes().add(symbol_66);
		//
		// ocl::NonUniqueCollection ocl!NonUniqueCollection{T}
		//
		symbol_76.setName("NonUniqueCollection");
		//symbol_76.setMoniker("ocl!NonUniqueCollection{T}");
		symbol_76.setElementType(symbol_79);
		symbol_79.setName("T");
		symbol_78.setOwnedParameteredElement(symbol_79);
		symbol_77.getOwnedParameters().add(symbol_78);
		
		symbol_76.setOwnedTemplateSignature(symbol_77);
		symbol_76.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_436 = PivotFactory.eINSTANCE.createIteration();
			symbol_436.setName("sortedBy");
			//symbol_436.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_436.setType(symbol_253);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("i");
			symbol_437.setType(symbol_79);  // ocl!NonUniqueCollection{T}?T
			symbol_436.getOwnedIterators().add(symbol_437);
			Parameter symbol_438 = PivotFactory.eINSTANCE.createParameter();
			symbol_438.setName("body");
			//symbol_438.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_438.setType(symbol_194);  // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
			
			symbol_436.getOwnedParameters().add(symbol_438);
			symbol_436.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_436.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_436);
		}
		symbol_1.getOwnedTypes().add(symbol_76);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_80.setName("OclAny");
		//symbol_80.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_439 = PivotFactory.eINSTANCE.createOperation();
			symbol_439.setName("<>");
			//symbol_439.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_439.setType(symbol_19);  // Boolean
			
			Parameter symbol_440 = PivotFactory.eINSTANCE.createParameter();
			symbol_440.setName("object2");
			//symbol_440.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_440.setType(symbol_80);  // ocl!OclAny
			
			symbol_439.getOwnedParameters().add(symbol_440);
			symbol_439.setPrecedence(symbol_7);
			symbol_439.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_439.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_439);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_441 = PivotFactory.eINSTANCE.createOperation();
			symbol_441.setName("=");
			//symbol_441.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_441.setType(symbol_19);  // Boolean
			
			Parameter symbol_442 = PivotFactory.eINSTANCE.createParameter();
			symbol_442.setName("object2");
			//symbol_442.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_442.setType(symbol_80);  // ocl!OclAny
			
			symbol_441.getOwnedParameters().add(symbol_442);
			symbol_441.setPrecedence(symbol_7);
			symbol_441.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_441.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_441);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_443 = PivotFactory.eINSTANCE.createOperation();
			symbol_83.setName("OclSelf");
			symbol_82.setOwnedParameteredElement(symbol_83);
			symbol_81.getOwnedParameters().add(symbol_82);
			
			symbol_443.setOwnedTemplateSignature(symbol_81);
			symbol_443.setName("oclAsSet");
			//symbol_443.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_443.setType(symbol_261);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			
			symbol_443.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation");
			symbol_443.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_443);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])
			Operation symbol_444 = PivotFactory.eINSTANCE.createOperation();
			symbol_86.setName("TT");
			symbol_85.setOwnedParameteredElement(symbol_86);
			symbol_84.getOwnedParameters().add(symbol_85);
			
			symbol_444.setOwnedTemplateSignature(symbol_84);
			symbol_444.setName("oclAsType");
			//symbol_444.setMoniker("ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])");
			symbol_444.setType(symbol_86);  // ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT
			
			Parameter symbol_445 = PivotFactory.eINSTANCE.createParameter();
			symbol_445.setName("type");
			//symbol_445.setMoniker("ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])!type");
			symbol_445.setType(symbol_161);  // ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]
			
			symbol_444.getOwnedParameters().add(symbol_445);
			symbol_444.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation");
			symbol_444.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_444);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_446 = PivotFactory.eINSTANCE.createOperation();
			symbol_446.setName("oclIsInState");
			//symbol_446.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_446.setType(symbol_19);  // Boolean
			
			Parameter symbol_447 = PivotFactory.eINSTANCE.createParameter();
			symbol_447.setName("statespec");
			//symbol_447.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_447.setType(symbol_102);  // ocl!OclState
			
			symbol_446.getOwnedParameters().add(symbol_447);
			symbol_446.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation");
			symbol_446.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_446);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_448 = PivotFactory.eINSTANCE.createOperation();
			symbol_448.setName("oclIsInvalid");
			//symbol_448.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_448.setType(symbol_19);  // Boolean
			
			symbol_448.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation");
			symbol_448.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_448);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])
			Operation symbol_449 = PivotFactory.eINSTANCE.createOperation();
			symbol_89.setName("T");
			symbol_88.setOwnedParameteredElement(symbol_89);
			symbol_87.getOwnedParameters().add(symbol_88);
			
			symbol_449.setOwnedTemplateSignature(symbol_87);
			symbol_449.setName("oclIsKindOf");
			//symbol_449.setMoniker("ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])");
			symbol_449.setType(symbol_19);  // Boolean
			
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("type");
			//symbol_450.setMoniker("ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])!type");
			symbol_450.setType(symbol_162);  // ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
			
			symbol_449.getOwnedParameters().add(symbol_450);
			symbol_449.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation");
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_449);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_451 = PivotFactory.eINSTANCE.createOperation();
			symbol_451.setName("oclIsNew");
			//symbol_451.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_451.setType(symbol_19);  // Boolean
			
			symbol_451.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_451.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_451);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_92.setName("T");
			symbol_91.setOwnedParameteredElement(symbol_92);
			symbol_90.getOwnedParameters().add(symbol_91);
			
			symbol_452.setOwnedTemplateSignature(symbol_90);
			symbol_452.setName("oclIsTypeOf");
			//symbol_452.setMoniker("ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])");
			symbol_452.setType(symbol_19);  // Boolean
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("type");
			//symbol_453.setMoniker("ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])!type");
			symbol_453.setType(symbol_163);  // ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
			
			symbol_452.getOwnedParameters().add(symbol_453);
			symbol_452.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation");
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("oclIsUndefined");
			//symbol_454.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_454.setType(symbol_19);  // Boolean
			
			symbol_454.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation");
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType{OclSelf}()
			Operation symbol_455 = PivotFactory.eINSTANCE.createOperation();
			symbol_95.setName("OclSelf");
			symbol_94.setOwnedParameteredElement(symbol_95);
			symbol_93.getOwnedParameters().add(symbol_94);
			
			symbol_455.setOwnedTemplateSignature(symbol_93);
			symbol_455.setName("oclType");
			//symbol_455.setMoniker("ocl!OclAny!oclType{OclSelf}()");
			symbol_455.setType(symbol_160);  // ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
			
			symbol_455.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation");
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_455);
		}
		symbol_1.getOwnedTypes().add(symbol_80);
		//
		// ocl::OclInvalid ocl!OclInvalid
		//
		symbol_96.setName("OclInvalid");
		//symbol_96.setMoniker("ocl!OclInvalid");
		symbol_96.getSuperClasses().add(symbol_104); // ocl!OclVoid
		{ // ocl::OclInvalid::oclBadProperty ocl!OclInvalid!oclBadProperty
			symbol_97.setName("oclBadProperty");
			symbol_97.setType(symbol_96);  // ocl!OclInvalid
			
			symbol_97.setIsResolveProxies(true);
			symbol_96.getOwnedAttributes().add(symbol_97);
		}
		{	// ocl::OclInvalid::<>() ocl!OclInvalid!<>(ocl!OclAny)
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_456.setName("<>");
			//symbol_456.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_456.setType(symbol_19);  // Boolean
			
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("object2");
			//symbol_457.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_457.setType(symbol_80);  // ocl!OclAny
			
			symbol_456.getOwnedParameters().add(symbol_457);
			symbol_456.setPrecedence(symbol_7);
			symbol_456.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_456);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("=");
			//symbol_458.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_458.setType(symbol_19);  // Boolean
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("object2");
			//symbol_459.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_459.setType(symbol_80);  // ocl!OclAny
			
			symbol_458.getOwnedParameters().add(symbol_459);
			symbol_458.setPrecedence(symbol_7);
			symbol_458.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances{OclSelf}()
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_100.setName("OclSelf");
			symbol_99.setOwnedParameteredElement(symbol_100);
			symbol_98.getOwnedParameters().add(symbol_99);
			
			symbol_460.setOwnedTemplateSignature(symbol_98);
			symbol_460.setName("allInstances");
			//symbol_460.setMoniker("ocl!OclInvalid!allInstances{OclSelf}()");
			symbol_460.setType(symbol_271);  // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
			
			symbol_460.setIsStatic(true);
			symbol_460.setImplementationClass("org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation");
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::OclInvalid::oclBadOperation() ocl!OclInvalid!oclBadOperation()
			Operation symbol_461 = PivotFactory.eINSTANCE.createOperation();
			symbol_461.setName("oclBadOperation");
			//symbol_461.setMoniker("ocl!OclInvalid!oclBadOperation()");
			symbol_461.setType(symbol_96);  // ocl!OclInvalid
			
			symbol_96.getOwnedOperations().add(symbol_461);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("toString");
			//symbol_462.setMoniker("ocl!OclInvalid!toString()");
			symbol_462.setType(symbol_143);  // String
			
			symbol_462.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_462);
		}
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_101.setName("OclMessage");
		//symbol_101.setMoniker("ocl!OclMessage");
		symbol_101.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_463 = PivotFactory.eINSTANCE.createOperation();
			symbol_463.setName("hasReturned");
			//symbol_463.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_463.setType(symbol_19);  // Boolean
			
			symbol_463.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_463.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_463);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("isOperationCall");
			//symbol_464.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_464.setType(symbol_19);  // Boolean
			
			symbol_464.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_465 = PivotFactory.eINSTANCE.createOperation();
			symbol_465.setName("isSignalSent");
			//symbol_465.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_465.setType(symbol_19);  // Boolean
			
			symbol_465.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_465.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_465);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_466.setName("result");
			//symbol_466.setMoniker("ocl!OclMessage!result()");
			symbol_466.setType(symbol_80);  // ocl!OclAny
			
			symbol_466.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_466);
		}
		symbol_1.getOwnedTypes().add(symbol_101);
		//
		// ocl::OclState ocl!OclState
		//
		symbol_102.setName("OclState");
		//symbol_102.setMoniker("ocl!OclState");
		symbol_102.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_102);
		//
		// ocl::OclTuple ocl!OclTuple
		//
		symbol_103.setName("OclTuple");
		//symbol_103.setMoniker("ocl!OclTuple");
		symbol_103.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::OclTuple::<>() ocl!OclTuple!<>(ocl!OclAny)
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("<>");
			//symbol_467.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_467.setType(symbol_19);  // Boolean
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("object2");
			//symbol_468.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_468.setType(symbol_80);  // ocl!OclAny
			
			symbol_467.getOwnedParameters().add(symbol_468);
			symbol_467.setPrecedence(symbol_7);
			symbol_467.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("=");
			//symbol_469.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_469.setType(symbol_19);  // Boolean
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("object2");
			//symbol_470.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_470.setType(symbol_80);  // ocl!OclAny
			
			symbol_469.getOwnedParameters().add(symbol_470);
			symbol_469.setPrecedence(symbol_7);
			symbol_469.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_469);
		}
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_104.setName("OclVoid");
		//symbol_104.setMoniker("ocl!OclVoid");
		symbol_104.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("<>");
			//symbol_471.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_471.setType(symbol_19);  // Boolean
			
			Parameter symbol_472 = PivotFactory.eINSTANCE.createParameter();
			symbol_472.setName("object2");
			//symbol_472.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_472.setType(symbol_80);  // ocl!OclAny
			
			symbol_471.getOwnedParameters().add(symbol_472);
			symbol_471.setPrecedence(symbol_7);
			symbol_471.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_471);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName("=");
			//symbol_473.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_473.setType(symbol_19);  // Boolean
			
			Parameter symbol_474 = PivotFactory.eINSTANCE.createParameter();
			symbol_474.setName("object2");
			//symbol_474.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_474.setType(symbol_80);  // ocl!OclAny
			
			symbol_473.getOwnedParameters().add(symbol_474);
			symbol_473.setPrecedence(symbol_7);
			symbol_473.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_473);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances{OclSelf}()
			Operation symbol_475 = PivotFactory.eINSTANCE.createOperation();
			symbol_107.setName("OclSelf");
			symbol_106.setOwnedParameteredElement(symbol_107);
			symbol_105.getOwnedParameters().add(symbol_106);
			
			symbol_475.setOwnedTemplateSignature(symbol_105);
			symbol_475.setName("allInstances");
			//symbol_475.setMoniker("ocl!OclVoid!allInstances{OclSelf}()");
			symbol_475.setType(symbol_266);  // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
			
			symbol_475.setIsStatic(true);
			symbol_475.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation");
			symbol_475.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_475);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_476 = PivotFactory.eINSTANCE.createOperation();
			symbol_476.setName("and");
			//symbol_476.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_476.setType(symbol_19);  // Boolean
			
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("b");
			//symbol_477.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_477.setType(symbol_19);  // Boolean
			
			symbol_476.getOwnedParameters().add(symbol_477);
			symbol_476.setPrecedence(symbol_8);
			symbol_476.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation");
			symbol_476.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_476);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("implies");
			//symbol_478.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_478.setType(symbol_19);  // Boolean
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("b");
			//symbol_479.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_479.setType(symbol_19);  // Boolean
			
			symbol_478.getOwnedParameters().add(symbol_479);
			symbol_478.setPrecedence(symbol_11);
			symbol_478.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation");
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_480 = PivotFactory.eINSTANCE.createOperation();
			symbol_480.setName("or");
			//symbol_480.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_480.setType(symbol_19);  // Boolean
			
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("b");
			//symbol_481.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_481.setType(symbol_19);  // Boolean
			
			symbol_480.getOwnedParameters().add(symbol_481);
			symbol_480.setPrecedence(symbol_9);
			symbol_480.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation");
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_482 = PivotFactory.eINSTANCE.createOperation();
			symbol_482.setName("toString");
			//symbol_482.setMoniker("ocl!OclVoid!toString()");
			symbol_482.setType(symbol_143);  // String
			
			symbol_482.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_482.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_482);
		}
		symbol_1.getOwnedTypes().add(symbol_104);
		//
		// ocl::OrderedCollection ocl!OrderedCollection{T}
		//
		symbol_108.setName("OrderedCollection");
		//symbol_108.setMoniker("ocl!OrderedCollection{T}");
		symbol_108.setElementType(symbol_111);
		symbol_111.setName("T");
		symbol_110.setOwnedParameteredElement(symbol_111);
		symbol_109.getOwnedParameters().add(symbol_110);
		
		symbol_108.setOwnedTemplateSignature(symbol_109);
		symbol_108.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("at");
			//symbol_483.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_483.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("index");
			//symbol_484.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_484.setType(symbol_65);  // Integer
			
			symbol_483.getOwnedParameters().add(symbol_484);
			symbol_483.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation");
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])
			Iteration symbol_485 = PivotFactory.eINSTANCE.createIteration();
			symbol_485.setName("closure");
			//symbol_485.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])");
			symbol_485.setType(symbol_249);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_486 = PivotFactory.eINSTANCE.createParameter();
			symbol_486.setName("i");
			symbol_486.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			symbol_485.getOwnedIterators().add(symbol_486);
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("body");
			//symbol_487.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])!body");
			symbol_487.setType(symbol_195);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
			
			symbol_485.getOwnedParameters().add(symbol_487);
			symbol_485.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_488 = PivotFactory.eINSTANCE.createIteration();
			symbol_114.setName("V");
			symbol_113.setOwnedParameteredElement(symbol_114);
			symbol_112.getOwnedParameters().add(symbol_113);
			
			symbol_488.setOwnedTemplateSignature(symbol_112);
			symbol_488.setName("collect");
			//symbol_488.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_488.setType(symbol_259);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_489 = PivotFactory.eINSTANCE.createParameter();
			symbol_489.setName("i");
			symbol_489.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			symbol_488.getOwnedIterators().add(symbol_489);
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("body");
			//symbol_490.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_490.setType(symbol_206);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_488.getOwnedParameters().add(symbol_490);
			symbol_488.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_491 = PivotFactory.eINSTANCE.createIteration();
			symbol_117.setName("V");
			symbol_116.setOwnedParameteredElement(symbol_117);
			symbol_115.getOwnedParameters().add(symbol_116);
			
			symbol_491.setOwnedTemplateSignature(symbol_115);
			symbol_491.setName("collectNested");
			//symbol_491.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_491.setType(symbol_258);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_492 = PivotFactory.eINSTANCE.createParameter();
			symbol_492.setName("i");
			symbol_492.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			symbol_491.getOwnedIterators().add(symbol_492);
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("body");
			//symbol_493.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_493.setType(symbol_209);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_491.getOwnedParameters().add(symbol_493);
			symbol_491.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_491.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_491);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_494 = PivotFactory.eINSTANCE.createOperation();
			symbol_494.setName("first");
			//symbol_494.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_494.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			
			symbol_494.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation");
			symbol_494.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_494);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("indexOf");
			//symbol_495.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_495.setType(symbol_65);  // Integer
			
			Parameter symbol_496 = PivotFactory.eINSTANCE.createParameter();
			symbol_496.setName("obj");
			//symbol_496.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_496.setType(symbol_80);  // ocl!OclAny
			
			symbol_495.getOwnedParameters().add(symbol_496);
			symbol_495.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation");
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_497 = PivotFactory.eINSTANCE.createOperation();
			symbol_497.setName("last");
			//symbol_497.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_497.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			
			symbol_497.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation");
			symbol_497.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_497);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("reverse");
			//symbol_498.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_498.setType(symbol_246);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			
			symbol_498.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_498);
		}
		symbol_1.getOwnedTypes().add(symbol_108);
		//
		// ocl::OrderedSet ocl!OrderedSet{T}
		//
		symbol_118.setName("OrderedSet");
		//symbol_118.setMoniker("ocl!OrderedSet{T}");
		symbol_118.setElementType(symbol_121);
		symbol_121.setName("T");
		symbol_120.setOwnedParameteredElement(symbol_121);
		symbol_119.getOwnedParameters().add(symbol_120);
		
		symbol_118.setOwnedTemplateSignature(symbol_119);
		symbol_118.getSuperClasses().add(symbol_244); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_118.getSuperClasses().add(symbol_285); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_499 = PivotFactory.eINSTANCE.createOperation();
			symbol_499.setName("-");
			//symbol_499.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_499.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("s");
			//symbol_500.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_500.setType(symbol_265);  // ocl!Set[ocl!OclAny]
			
			symbol_499.getOwnedParameters().add(symbol_500);
			symbol_499.setPrecedence(symbol_5);
			symbol_499.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_499.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_499);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("<>");
			//symbol_501.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_501.setType(symbol_19);  // Boolean
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("object2");
			//symbol_502.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_502.setType(symbol_80);  // ocl!OclAny
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setPrecedence(symbol_7);
			symbol_501.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_503 = PivotFactory.eINSTANCE.createOperation();
			symbol_503.setName("=");
			//symbol_503.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_503.setType(symbol_19);  // Boolean
			
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("object2");
			//symbol_504.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_504.setType(symbol_80);  // ocl!OclAny
			
			symbol_503.getOwnedParameters().add(symbol_504);
			symbol_503.setPrecedence(symbol_7);
			symbol_503.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("append");
			//symbol_505.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_505.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_506 = PivotFactory.eINSTANCE.createParameter();
			symbol_506.setName("object");
			//symbol_506.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_506.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_505.getOwnedParameters().add(symbol_506);
			symbol_505.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("excluding");
			//symbol_507.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_507.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("object");
			//symbol_508.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_508.setType(symbol_80);  // ocl!OclAny
			
			symbol_507.getOwnedParameters().add(symbol_508);
			symbol_507.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::OrderedSet::flatten() ocl!OrderedSet{T}!flatten{T2}()
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_124.setName("T2");
			symbol_123.setOwnedParameteredElement(symbol_124);
			symbol_122.getOwnedParameters().add(symbol_123);
			
			symbol_509.setOwnedTemplateSignature(symbol_122);
			symbol_509.setName("flatten");
			//symbol_509.setMoniker("ocl!OrderedSet{T}!flatten{T2}()");
			symbol_509.setType(symbol_252);  // ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
			
			symbol_509.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_510 = PivotFactory.eINSTANCE.createOperation();
			symbol_510.setName("including");
			//symbol_510.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_510.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("object");
			//symbol_511.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_511.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_510.getOwnedParameters().add(symbol_511);
			symbol_510.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("insertAt");
			//symbol_512.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_512.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_513 = PivotFactory.eINSTANCE.createParameter();
			symbol_513.setName("index");
			//symbol_513.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_513.setType(symbol_65);  // Integer
			
			symbol_512.getOwnedParameters().add(symbol_513);
			Parameter symbol_514 = PivotFactory.eINSTANCE.createParameter();
			symbol_514.setName("object");
			//symbol_514.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_514.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_512.getOwnedParameters().add(symbol_514);
			symbol_512.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_512);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_515 = PivotFactory.eINSTANCE.createOperation();
			symbol_515.setName("intersection");
			//symbol_515.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_515.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("o");
			//symbol_516.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_516.setType(symbol_272);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_515.getOwnedParameters().add(symbol_516);
			symbol_515.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_515.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_515);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("prepend");
			//symbol_517.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_517.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("object");
			//symbol_518.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_518.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_517.getOwnedParameters().add(symbol_518);
			symbol_517.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_519 = PivotFactory.eINSTANCE.createIteration();
			symbol_519.setName("reject");
			//symbol_519.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_519.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_520 = PivotFactory.eINSTANCE.createParameter();
			symbol_520.setName("i");
			symbol_520.setType(symbol_121);  // ocl!OrderedSet{T}?T
			symbol_519.getOwnedIterators().add(symbol_520);
			Parameter symbol_521 = PivotFactory.eINSTANCE.createParameter();
			symbol_521.setName("body");
			//symbol_521.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_521.setType(symbol_199);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_519.getOwnedParameters().add(symbol_521);
			symbol_519.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("reverse");
			//symbol_522.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_522.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_522.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_523 = PivotFactory.eINSTANCE.createIteration();
			symbol_523.setName("select");
			//symbol_523.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_523.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_524 = PivotFactory.eINSTANCE.createParameter();
			symbol_524.setName("i");
			symbol_524.setType(symbol_121);  // ocl!OrderedSet{T}?T
			symbol_523.getOwnedIterators().add(symbol_524);
			Parameter symbol_525 = PivotFactory.eINSTANCE.createParameter();
			symbol_525.setName("body");
			//symbol_525.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_525.setType(symbol_199);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_523.getOwnedParameters().add(symbol_525);
			symbol_523.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_526 = PivotFactory.eINSTANCE.createOperation();
			symbol_526.setName("subOrderedSet");
			//symbol_526.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_526.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("lower");
			//symbol_527.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_527.setType(symbol_65);  // Integer
			
			symbol_526.getOwnedParameters().add(symbol_527);
			Parameter symbol_528 = PivotFactory.eINSTANCE.createParameter();
			symbol_528.setName("upper");
			//symbol_528.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_528.setType(symbol_65);  // Integer
			
			symbol_526.getOwnedParameters().add(symbol_528);
			symbol_526.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation");
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_526);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_529 = PivotFactory.eINSTANCE.createOperation();
			symbol_529.setName("symmetricDifference");
			//symbol_529.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_529.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_530 = PivotFactory.eINSTANCE.createParameter();
			symbol_530.setName("s");
			//symbol_530.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_530.setType(symbol_265);  // ocl!Set[ocl!OclAny]
			
			symbol_529.getOwnedParameters().add(symbol_530);
			symbol_529.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_529.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_529);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_531 = PivotFactory.eINSTANCE.createOperation();
			symbol_531.setName("union");
			//symbol_531.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_531.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_532 = PivotFactory.eINSTANCE.createParameter();
			symbol_532.setName("o");
			//symbol_532.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_532.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_531.getOwnedParameters().add(symbol_532);
			symbol_531.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_531.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_531);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_533 = PivotFactory.eINSTANCE.createOperation();
			symbol_533.setName("union");
			//symbol_533.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_533.setType(symbol_272);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			Parameter symbol_534 = PivotFactory.eINSTANCE.createParameter();
			symbol_534.setName("s");
			//symbol_534.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_534.setType(symbol_272);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_533.getOwnedParameters().add(symbol_534);
			symbol_533.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_533.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_533);
		}
		symbol_1.getOwnedTypes().add(symbol_118);
		//
		// ocl::Real Real
		//
		symbol_125.setName("Real");
		//symbol_125.setMoniker("Real");
		symbol_125.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_535 = PivotFactory.eINSTANCE.createOperation();
			symbol_535.setName("*");
			//symbol_535.setMoniker("Real!*(Real)");
			symbol_535.setType(symbol_125);  // Real
			
			Parameter symbol_536 = PivotFactory.eINSTANCE.createParameter();
			symbol_536.setName("r");
			//symbol_536.setMoniker("Real!*(Real)!r");
			symbol_536.setType(symbol_125);  // Real
			
			symbol_535.getOwnedParameters().add(symbol_536);
			symbol_535.setPrecedence(symbol_4);
			symbol_535.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_535.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_535);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_537 = PivotFactory.eINSTANCE.createOperation();
			symbol_537.setName("+");
			//symbol_537.setMoniker("Real!+(Real)");
			symbol_537.setType(symbol_125);  // Real
			
			Parameter symbol_538 = PivotFactory.eINSTANCE.createParameter();
			symbol_538.setName("r");
			//symbol_538.setMoniker("Real!+(Real)!r");
			symbol_538.setType(symbol_125);  // Real
			
			symbol_537.getOwnedParameters().add(symbol_538);
			symbol_537.setPrecedence(symbol_5);
			symbol_537.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericPlusOperation");
			symbol_537.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_537);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_539 = PivotFactory.eINSTANCE.createOperation();
			symbol_539.setName("-");
			//symbol_539.setMoniker("Real!-(Real)");
			symbol_539.setType(symbol_125);  // Real
			
			Parameter symbol_540 = PivotFactory.eINSTANCE.createParameter();
			symbol_540.setName("r");
			//symbol_540.setMoniker("Real!-(Real)!r");
			symbol_540.setType(symbol_125);  // Real
			
			symbol_539.getOwnedParameters().add(symbol_540);
			symbol_539.setPrecedence(symbol_5);
			symbol_539.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinusOperation");
			symbol_539.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_539);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("-");
			//symbol_541.setMoniker("Real!-()");
			symbol_541.setType(symbol_125);  // Real
			
			symbol_541.setPrecedence(symbol_3);
			symbol_541.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_542 = PivotFactory.eINSTANCE.createOperation();
			symbol_542.setName("/");
			//symbol_542.setMoniker("Real!/(Real)");
			symbol_542.setType(symbol_125);  // Real
			
			Parameter symbol_543 = PivotFactory.eINSTANCE.createParameter();
			symbol_543.setName("r");
			//symbol_543.setMoniker("Real!/(Real)!r");
			symbol_543.setType(symbol_125);  // Real
			
			symbol_542.getOwnedParameters().add(symbol_543);
			symbol_542.setPrecedence(symbol_4);
			symbol_542.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_542.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_542);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_544 = PivotFactory.eINSTANCE.createOperation();
			symbol_544.setName("<");
			//symbol_544.setMoniker("Real!<(Real)");
			symbol_544.setType(symbol_19);  // Boolean
			
			Parameter symbol_545 = PivotFactory.eINSTANCE.createParameter();
			symbol_545.setName("r");
			//symbol_545.setMoniker("Real!<(Real)!r");
			symbol_545.setType(symbol_125);  // Real
			
			symbol_544.getOwnedParameters().add(symbol_545);
			symbol_544.setPrecedence(symbol_6);
			symbol_544.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation");
			symbol_544.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_544);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("<=");
			//symbol_546.setMoniker("Real!<=(Real)");
			symbol_546.setType(symbol_19);  // Boolean
			
			Parameter symbol_547 = PivotFactory.eINSTANCE.createParameter();
			symbol_547.setName("r");
			//symbol_547.setMoniker("Real!<=(Real)!r");
			symbol_547.setType(symbol_125);  // Real
			
			symbol_546.getOwnedParameters().add(symbol_547);
			symbol_546.setPrecedence(symbol_6);
			symbol_546.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation");
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_546);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_548 = PivotFactory.eINSTANCE.createOperation();
			symbol_548.setName("<>");
			//symbol_548.setMoniker("Real!<>(ocl!OclAny)");
			symbol_548.setType(symbol_19);  // Boolean
			
			Parameter symbol_549 = PivotFactory.eINSTANCE.createParameter();
			symbol_549.setName("object2");
			//symbol_549.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_549.setType(symbol_80);  // ocl!OclAny
			
			symbol_548.getOwnedParameters().add(symbol_549);
			symbol_548.setPrecedence(symbol_7);
			symbol_548.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_550 = PivotFactory.eINSTANCE.createOperation();
			symbol_550.setName("=");
			//symbol_550.setMoniker("Real!=(ocl!OclAny)");
			symbol_550.setType(symbol_19);  // Boolean
			
			Parameter symbol_551 = PivotFactory.eINSTANCE.createParameter();
			symbol_551.setName("object2");
			//symbol_551.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_551.setType(symbol_80);  // ocl!OclAny
			
			symbol_550.getOwnedParameters().add(symbol_551);
			symbol_550.setPrecedence(symbol_7);
			symbol_550.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_550.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_550);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_552 = PivotFactory.eINSTANCE.createOperation();
			symbol_552.setName(">");
			//symbol_552.setMoniker("Real!>(Real)");
			symbol_552.setType(symbol_19);  // Boolean
			
			Parameter symbol_553 = PivotFactory.eINSTANCE.createParameter();
			symbol_553.setName("r");
			//symbol_553.setMoniker("Real!>(Real)!r");
			symbol_553.setType(symbol_125);  // Real
			
			symbol_552.getOwnedParameters().add(symbol_553);
			symbol_552.setPrecedence(symbol_6);
			symbol_552.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation");
			symbol_552.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_552);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_554 = PivotFactory.eINSTANCE.createOperation();
			symbol_554.setName(">=");
			//symbol_554.setMoniker("Real!>=(Real)");
			symbol_554.setType(symbol_19);  // Boolean
			
			Parameter symbol_555 = PivotFactory.eINSTANCE.createParameter();
			symbol_555.setName("r");
			//symbol_555.setMoniker("Real!>=(Real)!r");
			symbol_555.setType(symbol_125);  // Real
			
			symbol_554.getOwnedParameters().add(symbol_555);
			symbol_554.setPrecedence(symbol_6);
			symbol_554.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation");
			symbol_554.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_554);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_556 = PivotFactory.eINSTANCE.createOperation();
			symbol_556.setName("abs");
			//symbol_556.setMoniker("Real!abs()");
			symbol_556.setType(symbol_125);  // Real
			
			symbol_556.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_556.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_556);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_557 = PivotFactory.eINSTANCE.createOperation();
			symbol_557.setName("floor");
			//symbol_557.setMoniker("Real!floor()");
			symbol_557.setType(symbol_65);  // Integer
			
			symbol_557.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericFloorOperation");
			symbol_557.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_557);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_558 = PivotFactory.eINSTANCE.createOperation();
			symbol_558.setName("max");
			//symbol_558.setMoniker("Real!max(Real)");
			symbol_558.setType(symbol_125);  // Real
			
			Parameter symbol_559 = PivotFactory.eINSTANCE.createParameter();
			symbol_559.setName("r");
			//symbol_559.setMoniker("Real!max(Real)!r");
			symbol_559.setType(symbol_125);  // Real
			
			symbol_558.getOwnedParameters().add(symbol_559);
			symbol_558.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_558.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_558);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_560 = PivotFactory.eINSTANCE.createOperation();
			symbol_560.setName("min");
			//symbol_560.setMoniker("Real!min(Real)");
			symbol_560.setType(symbol_125);  // Real
			
			Parameter symbol_561 = PivotFactory.eINSTANCE.createParameter();
			symbol_561.setName("r");
			//symbol_561.setMoniker("Real!min(Real)!r");
			symbol_561.setType(symbol_125);  // Real
			
			symbol_560.getOwnedParameters().add(symbol_561);
			symbol_560.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_560.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_560);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{TT}(ocl!Classifier[TT])
			Operation symbol_562 = PivotFactory.eINSTANCE.createOperation();
			symbol_128.setName("TT");
			symbol_127.setOwnedParameteredElement(symbol_128);
			symbol_126.getOwnedParameters().add(symbol_127);
			
			symbol_562.setOwnedTemplateSignature(symbol_126);
			symbol_562.setName("oclAsType");
			//symbol_562.setMoniker("Real!oclAsType{TT}(ocl!Classifier[TT])");
			symbol_562.setType(symbol_128);  // Real!oclAsType{TT}(ocl!Classifier[TT])?TT
			
			Parameter symbol_563 = PivotFactory.eINSTANCE.createParameter();
			symbol_563.setName("type");
			//symbol_563.setMoniker("Real!oclAsType{TT}(ocl!Classifier[TT])!type");
			symbol_563.setType(symbol_158);  // ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]
			
			symbol_562.getOwnedParameters().add(symbol_563);
			symbol_562.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation");
			symbol_562.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_562);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_564 = PivotFactory.eINSTANCE.createOperation();
			symbol_564.setName("round");
			//symbol_564.setMoniker("Real!round()");
			symbol_564.setType(symbol_65);  // Integer
			
			symbol_564.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericRoundOperation");
			symbol_564.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_564);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_565 = PivotFactory.eINSTANCE.createOperation();
			symbol_565.setName("toString");
			//symbol_565.setMoniker("Real!toString()");
			symbol_565.setType(symbol_143);  // String
			
			symbol_565.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_565.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_565);
		}
		symbol_1.getOwnedTypes().add(symbol_125);
		//
		// ocl::Sequence ocl!Sequence{T}
		//
		symbol_129.setName("Sequence");
		//symbol_129.setMoniker("ocl!Sequence{T}");
		symbol_129.setElementType(symbol_132);
		symbol_132.setName("T");
		symbol_131.setOwnedParameteredElement(symbol_132);
		symbol_130.getOwnedParameters().add(symbol_131);
		
		symbol_129.setOwnedTemplateSignature(symbol_130);
		symbol_129.getSuperClasses().add(symbol_242); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_129.getSuperClasses().add(symbol_227); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_566 = PivotFactory.eINSTANCE.createOperation();
			symbol_566.setName("<>");
			//symbol_566.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_566.setType(symbol_19);  // Boolean
			
			Parameter symbol_567 = PivotFactory.eINSTANCE.createParameter();
			symbol_567.setName("object2");
			//symbol_567.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_567.setType(symbol_80);  // ocl!OclAny
			
			symbol_566.getOwnedParameters().add(symbol_567);
			symbol_566.setPrecedence(symbol_7);
			symbol_566.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_566.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_566);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_568 = PivotFactory.eINSTANCE.createOperation();
			symbol_568.setName("=");
			//symbol_568.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_568.setType(symbol_19);  // Boolean
			
			Parameter symbol_569 = PivotFactory.eINSTANCE.createParameter();
			symbol_569.setName("object2");
			//symbol_569.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_569.setType(symbol_80);  // ocl!OclAny
			
			symbol_568.getOwnedParameters().add(symbol_569);
			symbol_568.setPrecedence(symbol_7);
			symbol_568.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_568.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_568);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_570 = PivotFactory.eINSTANCE.createOperation();
			symbol_570.setName("append");
			//symbol_570.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_570.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_571 = PivotFactory.eINSTANCE.createParameter();
			symbol_571.setName("object");
			//symbol_571.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_571.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_570.getOwnedParameters().add(symbol_571);
			symbol_570.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_570.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_570);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_572 = PivotFactory.eINSTANCE.createOperation();
			symbol_572.setName("excluding");
			//symbol_572.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_572.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_573 = PivotFactory.eINSTANCE.createParameter();
			symbol_573.setName("object");
			//symbol_573.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_573.setType(symbol_80);  // ocl!OclAny
			
			symbol_572.getOwnedParameters().add(symbol_573);
			symbol_572.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_572.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_572);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_574 = PivotFactory.eINSTANCE.createOperation();
			symbol_135.setName("T2");
			symbol_134.setOwnedParameteredElement(symbol_135);
			symbol_133.getOwnedParameters().add(symbol_134);
			
			symbol_574.setOwnedTemplateSignature(symbol_133);
			symbol_574.setName("flatten");
			//symbol_574.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_574.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			
			symbol_574.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_574.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_574);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_575 = PivotFactory.eINSTANCE.createOperation();
			symbol_575.setName("including");
			//symbol_575.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_575.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_576 = PivotFactory.eINSTANCE.createParameter();
			symbol_576.setName("object");
			//symbol_576.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_576.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_575.getOwnedParameters().add(symbol_576);
			symbol_575.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_575.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_575);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_577 = PivotFactory.eINSTANCE.createOperation();
			symbol_577.setName("insertAt");
			//symbol_577.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_577.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_578 = PivotFactory.eINSTANCE.createParameter();
			symbol_578.setName("index");
			//symbol_578.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_578.setType(symbol_65);  // Integer
			
			symbol_577.getOwnedParameters().add(symbol_578);
			Parameter symbol_579 = PivotFactory.eINSTANCE.createParameter();
			symbol_579.setName("object");
			//symbol_579.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_579.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_577.getOwnedParameters().add(symbol_579);
			symbol_577.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_577.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_577);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_580 = PivotFactory.eINSTANCE.createOperation();
			symbol_580.setName("prepend");
			//symbol_580.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_580.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_581 = PivotFactory.eINSTANCE.createParameter();
			symbol_581.setName("object");
			//symbol_581.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_581.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_580.getOwnedParameters().add(symbol_581);
			symbol_580.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_580.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_580);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_582 = PivotFactory.eINSTANCE.createIteration();
			symbol_582.setName("reject");
			//symbol_582.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_582.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_583 = PivotFactory.eINSTANCE.createParameter();
			symbol_583.setName("i");
			symbol_583.setType(symbol_132);  // ocl!Sequence{T}?T
			symbol_582.getOwnedIterators().add(symbol_583);
			Parameter symbol_584 = PivotFactory.eINSTANCE.createParameter();
			symbol_584.setName("body");
			//symbol_584.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_584.setType(symbol_202);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_582.getOwnedParameters().add(symbol_584);
			symbol_582.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_582.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_582);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_585 = PivotFactory.eINSTANCE.createOperation();
			symbol_585.setName("reverse");
			//symbol_585.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_585.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_585.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_585.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_585);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_586 = PivotFactory.eINSTANCE.createIteration();
			symbol_586.setName("select");
			//symbol_586.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_586.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_587 = PivotFactory.eINSTANCE.createParameter();
			symbol_587.setName("i");
			symbol_587.setType(symbol_132);  // ocl!Sequence{T}?T
			symbol_586.getOwnedIterators().add(symbol_587);
			Parameter symbol_588 = PivotFactory.eINSTANCE.createParameter();
			symbol_588.setName("body");
			//symbol_588.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_588.setType(symbol_202);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_586.getOwnedParameters().add(symbol_588);
			symbol_586.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_586.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_586);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_589 = PivotFactory.eINSTANCE.createOperation();
			symbol_589.setName("subSequence");
			//symbol_589.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_589.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_590 = PivotFactory.eINSTANCE.createParameter();
			symbol_590.setName("lower");
			//symbol_590.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_590.setType(symbol_65);  // Integer
			
			symbol_589.getOwnedParameters().add(symbol_590);
			Parameter symbol_591 = PivotFactory.eINSTANCE.createParameter();
			symbol_591.setName("upper");
			//symbol_591.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_591.setType(symbol_65);  // Integer
			
			symbol_589.getOwnedParameters().add(symbol_591);
			symbol_589.setImplementationClass("org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation");
			symbol_589.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_589);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_592 = PivotFactory.eINSTANCE.createOperation();
			symbol_592.setName("union");
			//symbol_592.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_592.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_593 = PivotFactory.eINSTANCE.createParameter();
			symbol_593.setName("s");
			//symbol_593.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_593.setType(symbol_256);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_592.getOwnedParameters().add(symbol_593);
			symbol_592.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_592.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_592);
		}
		symbol_1.getOwnedTypes().add(symbol_129);
		//
		// ocl::Set ocl!Set{T}
		//
		symbol_136.setName("Set");
		//symbol_136.setMoniker("ocl!Set{T}");
		symbol_136.setElementType(symbol_139);
		symbol_139.setName("T");
		symbol_138.setOwnedParameteredElement(symbol_139);
		symbol_137.getOwnedParameters().add(symbol_138);
		
		symbol_136.setOwnedTemplateSignature(symbol_137);
		symbol_136.getSuperClasses().add(symbol_282); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_136.getSuperClasses().add(symbol_211); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_594 = PivotFactory.eINSTANCE.createOperation();
			symbol_594.setName("-");
			//symbol_594.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_594.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_595 = PivotFactory.eINSTANCE.createParameter();
			symbol_595.setName("s");
			//symbol_595.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_595.setType(symbol_265);  // ocl!Set[ocl!OclAny]
			
			symbol_594.getOwnedParameters().add(symbol_595);
			symbol_594.setPrecedence(symbol_5);
			symbol_594.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_594.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_594);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_596 = PivotFactory.eINSTANCE.createOperation();
			symbol_596.setName("<>");
			//symbol_596.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_596.setType(symbol_19);  // Boolean
			
			Parameter symbol_597 = PivotFactory.eINSTANCE.createParameter();
			symbol_597.setName("object2");
			//symbol_597.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_597.setType(symbol_80);  // ocl!OclAny
			
			symbol_596.getOwnedParameters().add(symbol_597);
			symbol_596.setPrecedence(symbol_7);
			symbol_596.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_596.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_596);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_598 = PivotFactory.eINSTANCE.createOperation();
			symbol_598.setName("=");
			//symbol_598.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_598.setType(symbol_19);  // Boolean
			
			Parameter symbol_599 = PivotFactory.eINSTANCE.createParameter();
			symbol_599.setName("object2");
			//symbol_599.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_599.setType(symbol_80);  // ocl!OclAny
			
			symbol_598.getOwnedParameters().add(symbol_599);
			symbol_598.setPrecedence(symbol_7);
			symbol_598.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_598.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_598);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_600 = PivotFactory.eINSTANCE.createOperation();
			symbol_600.setName("excluding");
			//symbol_600.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_600.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_601 = PivotFactory.eINSTANCE.createParameter();
			symbol_601.setName("object");
			//symbol_601.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_601.setType(symbol_80);  // ocl!OclAny
			
			symbol_600.getOwnedParameters().add(symbol_601);
			symbol_600.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_600.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_600);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_602 = PivotFactory.eINSTANCE.createOperation();
			symbol_142.setName("T2");
			symbol_141.setOwnedParameteredElement(symbol_142);
			symbol_140.getOwnedParameters().add(symbol_141);
			
			symbol_602.setOwnedTemplateSignature(symbol_140);
			symbol_602.setName("flatten");
			//symbol_602.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_602.setType(symbol_263);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			
			symbol_602.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_602.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_602);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_603 = PivotFactory.eINSTANCE.createOperation();
			symbol_603.setName("including");
			//symbol_603.setMoniker("ocl!Set{T}!including(T)");
			symbol_603.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_604 = PivotFactory.eINSTANCE.createParameter();
			symbol_604.setName("object");
			//symbol_604.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_604.setType(symbol_139);  // ocl!Set{T}?T
			
			symbol_603.getOwnedParameters().add(symbol_604);
			symbol_603.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_603.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_603);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_605 = PivotFactory.eINSTANCE.createOperation();
			symbol_605.setName("intersection");
			//symbol_605.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_605.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_606 = PivotFactory.eINSTANCE.createParameter();
			symbol_606.setName("s");
			//symbol_606.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_606.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			symbol_605.getOwnedParameters().add(symbol_606);
			symbol_605.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_605.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_605);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_607 = PivotFactory.eINSTANCE.createIteration();
			symbol_607.setName("reject");
			//symbol_607.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_607.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_608 = PivotFactory.eINSTANCE.createParameter();
			symbol_608.setName("i");
			symbol_608.setType(symbol_139);  // ocl!Set{T}?T
			symbol_607.getOwnedIterators().add(symbol_608);
			Parameter symbol_609 = PivotFactory.eINSTANCE.createParameter();
			symbol_609.setName("body");
			//symbol_609.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_609.setType(symbol_198);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_607.getOwnedParameters().add(symbol_609);
			symbol_607.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_607.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_607);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_610 = PivotFactory.eINSTANCE.createIteration();
			symbol_610.setName("select");
			//symbol_610.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_610.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_611 = PivotFactory.eINSTANCE.createParameter();
			symbol_611.setName("i");
			symbol_611.setType(symbol_139);  // ocl!Set{T}?T
			symbol_610.getOwnedIterators().add(symbol_611);
			Parameter symbol_612 = PivotFactory.eINSTANCE.createParameter();
			symbol_612.setName("body");
			//symbol_612.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_612.setType(symbol_198);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_610.getOwnedParameters().add(symbol_612);
			symbol_610.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_610.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_610);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_613 = PivotFactory.eINSTANCE.createOperation();
			symbol_613.setName("symmetricDifference");
			//symbol_613.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_613.setType(symbol_270);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_614 = PivotFactory.eINSTANCE.createParameter();
			symbol_614.setName("s");
			//symbol_614.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_614.setType(symbol_265);  // ocl!Set[ocl!OclAny]
			
			symbol_613.getOwnedParameters().add(symbol_614);
			symbol_613.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_613.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_613);
		}
		symbol_1.getOwnedTypes().add(symbol_136);
		//
		// ocl::String String
		//
		symbol_143.setName("String");
		//symbol_143.setMoniker("String");
		symbol_143.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_615 = PivotFactory.eINSTANCE.createOperation();
			symbol_615.setName("+");
			//symbol_615.setMoniker("String!+(String)");
			symbol_615.setType(symbol_143);  // String
			
			Parameter symbol_616 = PivotFactory.eINSTANCE.createParameter();
			symbol_616.setName("s");
			//symbol_616.setMoniker("String!+(String)!s");
			symbol_616.setType(symbol_143);  // String
			
			symbol_615.getOwnedParameters().add(symbol_616);
			symbol_615.setPrecedence(symbol_5);
			symbol_615.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_615.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_615);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_617 = PivotFactory.eINSTANCE.createOperation();
			symbol_617.setName("<");
			//symbol_617.setMoniker("String!<(String)");
			symbol_617.setType(symbol_19);  // Boolean
			
			Parameter symbol_618 = PivotFactory.eINSTANCE.createParameter();
			symbol_618.setName("s");
			//symbol_618.setMoniker("String!<(String)!s");
			symbol_618.setType(symbol_143);  // String
			
			symbol_617.getOwnedParameters().add(symbol_618);
			symbol_617.setPrecedence(symbol_6);
			symbol_617.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanOperation");
			symbol_617.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_617);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_619 = PivotFactory.eINSTANCE.createOperation();
			symbol_619.setName("<=");
			//symbol_619.setMoniker("String!<=(String)");
			symbol_619.setType(symbol_19);  // Boolean
			
			Parameter symbol_620 = PivotFactory.eINSTANCE.createParameter();
			symbol_620.setName("s");
			//symbol_620.setMoniker("String!<=(String)!s");
			symbol_620.setType(symbol_143);  // String
			
			symbol_619.getOwnedParameters().add(symbol_620);
			symbol_619.setPrecedence(symbol_6);
			symbol_619.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation");
			symbol_619.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_619);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_621 = PivotFactory.eINSTANCE.createOperation();
			symbol_621.setName("<>");
			//symbol_621.setMoniker("String!<>(ocl!OclAny)");
			symbol_621.setType(symbol_19);  // Boolean
			
			Parameter symbol_622 = PivotFactory.eINSTANCE.createParameter();
			symbol_622.setName("object2");
			//symbol_622.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_622.setType(symbol_80);  // ocl!OclAny
			
			symbol_621.getOwnedParameters().add(symbol_622);
			symbol_621.setPrecedence(symbol_7);
			symbol_621.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_621.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_621);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_623 = PivotFactory.eINSTANCE.createOperation();
			symbol_623.setName("=");
			//symbol_623.setMoniker("String!=(ocl!OclAny)");
			symbol_623.setType(symbol_19);  // Boolean
			
			Parameter symbol_624 = PivotFactory.eINSTANCE.createParameter();
			symbol_624.setName("object2");
			//symbol_624.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_624.setType(symbol_80);  // ocl!OclAny
			
			symbol_623.getOwnedParameters().add(symbol_624);
			symbol_623.setPrecedence(symbol_7);
			symbol_623.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_623.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_623);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_625 = PivotFactory.eINSTANCE.createOperation();
			symbol_625.setName(">");
			//symbol_625.setMoniker("String!>(String)");
			symbol_625.setType(symbol_19);  // Boolean
			
			Parameter symbol_626 = PivotFactory.eINSTANCE.createParameter();
			symbol_626.setName("s");
			//symbol_626.setMoniker("String!>(String)!s");
			symbol_626.setType(symbol_143);  // String
			
			symbol_625.getOwnedParameters().add(symbol_626);
			symbol_625.setPrecedence(symbol_6);
			symbol_625.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanOperation");
			symbol_625.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_625);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_627 = PivotFactory.eINSTANCE.createOperation();
			symbol_627.setName(">=");
			//symbol_627.setMoniker("String!>=(String)");
			symbol_627.setType(symbol_19);  // Boolean
			
			Parameter symbol_628 = PivotFactory.eINSTANCE.createParameter();
			symbol_628.setName("s");
			//symbol_628.setMoniker("String!>=(String)!s");
			symbol_628.setType(symbol_143);  // String
			
			symbol_627.getOwnedParameters().add(symbol_628);
			symbol_627.setPrecedence(symbol_6);
			symbol_627.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation");
			symbol_627.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_627);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_629 = PivotFactory.eINSTANCE.createOperation();
			symbol_629.setName("at");
			//symbol_629.setMoniker("String!at(Integer)");
			symbol_629.setType(symbol_143);  // String
			
			Parameter symbol_630 = PivotFactory.eINSTANCE.createParameter();
			symbol_630.setName("i");
			//symbol_630.setMoniker("String!at(Integer)!i");
			symbol_630.setType(symbol_65);  // Integer
			
			symbol_629.getOwnedParameters().add(symbol_630);
			symbol_629.setImplementationClass("org.eclipse.ocl.examples.library.string.StringAtOperation");
			symbol_629.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_629);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_631 = PivotFactory.eINSTANCE.createOperation();
			symbol_631.setName("characters");
			//symbol_631.setMoniker("String!characters()");
			symbol_631.setType(symbol_255);  // ocl!Sequence[String]
			
			symbol_631.setImplementationClass("org.eclipse.ocl.examples.library.string.StringCharactersOperation");
			symbol_631.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_631);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_632 = PivotFactory.eINSTANCE.createOperation();
			symbol_632.setName("concat");
			//symbol_632.setMoniker("String!concat(String)");
			symbol_632.setType(symbol_143);  // String
			
			Parameter symbol_633 = PivotFactory.eINSTANCE.createParameter();
			symbol_633.setName("s");
			//symbol_633.setMoniker("String!concat(String)!s");
			symbol_633.setType(symbol_143);  // String
			
			symbol_632.getOwnedParameters().add(symbol_633);
			symbol_632.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_632.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_632);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_634 = PivotFactory.eINSTANCE.createOperation();
			symbol_634.setName("equalsIgnoreCase");
			//symbol_634.setMoniker("String!equalsIgnoreCase(String)");
			symbol_634.setType(symbol_19);  // Boolean
			
			Parameter symbol_635 = PivotFactory.eINSTANCE.createParameter();
			symbol_635.setName("s");
			//symbol_635.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_635.setType(symbol_143);  // String
			
			symbol_634.getOwnedParameters().add(symbol_635);
			symbol_634.setImplementationClass("org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation");
			symbol_634.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_634);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_636 = PivotFactory.eINSTANCE.createOperation();
			symbol_636.setName("indexOf");
			//symbol_636.setMoniker("String!indexOf(String)");
			symbol_636.setType(symbol_65);  // Integer
			
			Parameter symbol_637 = PivotFactory.eINSTANCE.createParameter();
			symbol_637.setName("s");
			//symbol_637.setMoniker("String!indexOf(String)!s");
			symbol_637.setType(symbol_143);  // String
			
			symbol_636.getOwnedParameters().add(symbol_637);
			symbol_636.setImplementationClass("org.eclipse.ocl.examples.library.string.StringIndexOfOperation");
			symbol_636.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_636);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_638 = PivotFactory.eINSTANCE.createOperation();
			symbol_638.setName("size");
			//symbol_638.setMoniker("String!size()");
			symbol_638.setType(symbol_65);  // Integer
			
			symbol_638.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSizeOperation");
			symbol_638.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_638);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_639 = PivotFactory.eINSTANCE.createOperation();
			symbol_639.setName("substring");
			//symbol_639.setMoniker("String!substring(Integer,Integer)");
			symbol_639.setType(symbol_143);  // String
			
			Parameter symbol_640 = PivotFactory.eINSTANCE.createParameter();
			symbol_640.setName("lower");
			//symbol_640.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_640.setType(symbol_65);  // Integer
			
			symbol_639.getOwnedParameters().add(symbol_640);
			Parameter symbol_641 = PivotFactory.eINSTANCE.createParameter();
			symbol_641.setName("upper");
			//symbol_641.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_641.setType(symbol_65);  // Integer
			
			symbol_639.getOwnedParameters().add(symbol_641);
			symbol_639.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSubstringOperation");
			symbol_639.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_639);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_642 = PivotFactory.eINSTANCE.createOperation();
			symbol_642.setName("toBoolean");
			//symbol_642.setMoniker("String!toBoolean()");
			symbol_642.setType(symbol_19);  // Boolean
			
			symbol_642.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToBooleanOperation");
			symbol_642.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_642);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_643 = PivotFactory.eINSTANCE.createOperation();
			symbol_643.setName("toInteger");
			//symbol_643.setMoniker("String!toInteger()");
			symbol_643.setType(symbol_65);  // Integer
			
			symbol_643.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToIntegerOperation");
			symbol_643.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_643);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_644 = PivotFactory.eINSTANCE.createOperation();
			symbol_644.setName("toLower");
			//symbol_644.setMoniker("String!toLower()");
			symbol_644.setType(symbol_143);  // String
			
			symbol_644.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_644.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_644);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_645 = PivotFactory.eINSTANCE.createOperation();
			symbol_645.setName("toLowerCase");
			//symbol_645.setMoniker("String!toLowerCase()");
			symbol_645.setType(symbol_143);  // String
			
			symbol_645.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_645.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_645);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_646 = PivotFactory.eINSTANCE.createOperation();
			symbol_646.setName("toReal");
			//symbol_646.setMoniker("String!toReal()");
			symbol_646.setType(symbol_125);  // Real
			
			symbol_646.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToRealOperation");
			symbol_646.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_646);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_647 = PivotFactory.eINSTANCE.createOperation();
			symbol_647.setName("toString");
			//symbol_647.setMoniker("String!toString()");
			symbol_647.setType(symbol_143);  // String
			
			symbol_647.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_647.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_647);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_648 = PivotFactory.eINSTANCE.createOperation();
			symbol_648.setName("toUpper");
			//symbol_648.setMoniker("String!toUpper()");
			symbol_648.setType(symbol_143);  // String
			
			symbol_648.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_648.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_648);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_649 = PivotFactory.eINSTANCE.createOperation();
			symbol_649.setName("toUpperCase");
			//symbol_649.setMoniker("String!toUpperCase()");
			symbol_649.setType(symbol_143);  // String
			
			symbol_649.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_649.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_649);
		}
		symbol_1.getOwnedTypes().add(symbol_143);
		//
		// ocl::Tuple ocl!Tuple
		//
		symbol_144.setName("Tuple");
		//symbol_144.setMoniker("ocl!Tuple");
		symbol_144.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_144);
		//
		// ocl::UniqueCollection ocl!UniqueCollection{T}
		//
		symbol_145.setName("UniqueCollection");
		//symbol_145.setMoniker("ocl!UniqueCollection{T}");
		symbol_145.setElementType(symbol_148);
		symbol_148.setName("T");
		symbol_147.setOwnedParameteredElement(symbol_148);
		symbol_146.getOwnedParameters().add(symbol_147);
		
		symbol_145.setOwnedTemplateSignature(symbol_146);
		symbol_145.getSuperClasses().add(symbol_181); // ocl!Collection[ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_650 = PivotFactory.eINSTANCE.createIteration();
			symbol_650.setName("sortedBy");
			//symbol_650.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_650.setType(symbol_248);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_651 = PivotFactory.eINSTANCE.createParameter();
			symbol_651.setName("i");
			symbol_651.setType(symbol_148);  // ocl!UniqueCollection{T}?T
			symbol_650.getOwnedIterators().add(symbol_651);
			Parameter symbol_652 = PivotFactory.eINSTANCE.createParameter();
			symbol_652.setName("body");
			//symbol_652.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_652.setType(symbol_208);  // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
			
			symbol_650.getOwnedParameters().add(symbol_652);
			symbol_650.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_650.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_145.getOwnedOperations().add(symbol_650);
		}
		symbol_1.getOwnedTypes().add(symbol_145);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_149.setName("UnlimitedNatural");
		//symbol_149.setMoniker("UnlimitedNatural");
		symbol_149.getSuperClasses().add(symbol_65); // Integer
		symbol_1.getOwnedTypes().add(symbol_149);
		//
		// ocl::$orphanage
		//
		symbol_150.setName("$orphanage");
		symbol_150.setMoniker("$orphanage");
		//
		// ocl::$orphanage::$orphanage $orphanage!$orphanage
		//
		symbol_151.setName("$orphanage");
		//symbol_151.setMoniker("$orphanage!$orphanage");
		symbol_150.getOwnedTypes().add(symbol_151);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}?T]
		//
		symbol_152.setName("Bag");
		//symbol_152.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}?T]");
		symbol_152.setElementType(symbol_69);
		{
			TemplateBinding symbol_653 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_653.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_654 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_654.setFormal(symbol_14);	
				symbol_654.setActual(symbol_69);	
				symbol_653.getParameterSubstitutions().add(symbol_654);
			}
			symbol_152.getTemplateBindings().add(symbol_653);
		}
		symbol_152.getSuperClasses().add(symbol_223); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_152.getSuperClasses().add(symbol_228); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_152);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_153.setName("Bag");
		//symbol_153.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_153.setElementType(symbol_18);
		{
			TemplateBinding symbol_655 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_655.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_656 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_656.setFormal(symbol_14);	
				symbol_656.setActual(symbol_18);	
				symbol_655.getParameterSubstitutions().add(symbol_656);
			}
			symbol_153.getTemplateBindings().add(symbol_655);
		}
		symbol_153.getSuperClasses().add(symbol_212); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_153.getSuperClasses().add(symbol_230); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_153);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_154.setName("Bag");
		//symbol_154.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_154.setElementType(symbol_72);
		{
			TemplateBinding symbol_657 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_657.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_658 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_658.setFormal(symbol_14);	
				symbol_658.setActual(symbol_72);	
				symbol_657.getParameterSubstitutions().add(symbol_658);
			}
			symbol_154.getTemplateBindings().add(symbol_657);
		}
		symbol_154.getSuperClasses().add(symbol_214); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_154.getSuperClasses().add(symbol_233); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_154);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_155.setName("Bag");
		//symbol_155.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_155.setElementType(symbol_39);
		{
			TemplateBinding symbol_659 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_659.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_660 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_660.setFormal(symbol_14);	
				symbol_660.setActual(symbol_39);	
				symbol_659.getParameterSubstitutions().add(symbol_660);
			}
			symbol_155.getTemplateBindings().add(symbol_659);
		}
		symbol_155.getSuperClasses().add(symbol_219); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_155.getSuperClasses().add(symbol_236); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_155);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_156.setName("Bag");
		//symbol_156.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_156.setElementType(symbol_15);
		{
			TemplateBinding symbol_661 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_661.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_662 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_662.setFormal(symbol_14);	
				symbol_662.setActual(symbol_15);	
				symbol_661.getParameterSubstitutions().add(symbol_662);
			}
			symbol_156.getTemplateBindings().add(symbol_661);
		}
		symbol_156.getSuperClasses().add(symbol_237); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_156.getSuperClasses().add(symbol_213); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_150.getOwnedTypes().add(symbol_156);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]
		//
		symbol_157.setName("Classifier");
		//symbol_157.setMoniker("ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]");
		symbol_157.setInstanceType(symbol_35);
		{
			TemplateBinding symbol_663 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_663.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_664 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_664.setFormal(symbol_25);	
				symbol_664.setActual(symbol_35);	
				symbol_663.getParameterSubstitutions().add(symbol_664);
			}
			symbol_157.getTemplateBindings().add(symbol_663);
		}
		symbol_157.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_157);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]
		//
		symbol_158.setName("Classifier");
		//symbol_158.setMoniker("ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]");
		symbol_158.setInstanceType(symbol_128);
		{
			TemplateBinding symbol_665 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_665.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_666 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_666.setFormal(symbol_25);	
				symbol_666.setActual(symbol_128);	
				symbol_665.getParameterSubstitutions().add(symbol_666);
			}
			symbol_158.getTemplateBindings().add(symbol_665);
		}
		symbol_158.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_158);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]
		//
		symbol_159.setName("Classifier");
		//symbol_159.setMoniker("ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]");
		symbol_159.setInstanceType(symbol_32);
		{
			TemplateBinding symbol_667 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_667.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_668 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_668.setFormal(symbol_25);	
				symbol_668.setActual(symbol_32);	
				symbol_667.getParameterSubstitutions().add(symbol_668);
			}
			symbol_159.getTemplateBindings().add(symbol_667);
		}
		symbol_159.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_159);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
		//
		symbol_160.setName("Classifier");
		//symbol_160.setMoniker("ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]");
		symbol_160.setInstanceType(symbol_95);
		{
			TemplateBinding symbol_669 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_669.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_670 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_670.setFormal(symbol_25);	
				symbol_670.setActual(symbol_95);	
				symbol_669.getParameterSubstitutions().add(symbol_670);
			}
			symbol_160.getTemplateBindings().add(symbol_669);
		}
		symbol_160.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_160);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]
		//
		symbol_161.setName("Classifier");
		//symbol_161.setMoniker("ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]");
		symbol_161.setInstanceType(symbol_86);
		{
			TemplateBinding symbol_671 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_671.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_672 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_672.setFormal(symbol_25);	
				symbol_672.setActual(symbol_86);	
				symbol_671.getParameterSubstitutions().add(symbol_672);
			}
			symbol_161.getTemplateBindings().add(symbol_671);
		}
		symbol_161.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_161);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
		//
		symbol_162.setName("Classifier");
		//symbol_162.setMoniker("ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]");
		symbol_162.setInstanceType(symbol_89);
		{
			TemplateBinding symbol_673 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_673.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_674 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_674.setFormal(symbol_25);	
				symbol_674.setActual(symbol_89);	
				symbol_673.getParameterSubstitutions().add(symbol_674);
			}
			symbol_162.getTemplateBindings().add(symbol_673);
		}
		symbol_162.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_162);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
		//
		symbol_163.setName("Classifier");
		//symbol_163.setMoniker("ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]");
		symbol_163.setInstanceType(symbol_92);
		{
			TemplateBinding symbol_675 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_675.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_676 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_676.setFormal(symbol_25);	
				symbol_676.setActual(symbol_92);	
				symbol_675.getParameterSubstitutions().add(symbol_676);
			}
			symbol_163.getTemplateBindings().add(symbol_675);
		}
		symbol_163.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_163);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_164.setName("Collection");
		//symbol_164.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_164.setElementType(symbol_18);
		{
			TemplateBinding symbol_677 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_677.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_678 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_678.setFormal(symbol_38);	
				symbol_678.setActual(symbol_18);	
				symbol_677.getParameterSubstitutions().add(symbol_678);
			}
			symbol_164.getTemplateBindings().add(symbol_677);
		}
		symbol_164.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_164);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_165.setName("Collection");
		//symbol_165.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_165.setElementType(symbol_132);
		{
			TemplateBinding symbol_679 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_679.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_680 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_680.setFormal(symbol_38);	
				symbol_680.setActual(symbol_132);	
				symbol_679.getParameterSubstitutions().add(symbol_680);
			}
			symbol_165.getTemplateBindings().add(symbol_679);
		}
		symbol_165.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_165);
		//
		// ocl::$orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_166.setName("Collection");
		//symbol_166.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_166.setElementType(symbol_274);
		{
			TemplateBinding symbol_681 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_681.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_682 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_682.setFormal(symbol_38);	
				symbol_682.setActual(symbol_274);	
				symbol_681.getParameterSubstitutions().add(symbol_682);
			}
			symbol_166.getTemplateBindings().add(symbol_681);
		}
		symbol_166.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_166);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_167.setName("Collection");
		//symbol_167.setMoniker("ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_167.setElementType(symbol_64);
		{
			TemplateBinding symbol_683 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_683.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_684 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_684.setFormal(symbol_38);	
				symbol_684.setActual(symbol_64);	
				symbol_683.getParameterSubstitutions().add(symbol_684);
			}
			symbol_167.getTemplateBindings().add(symbol_683);
		}
		symbol_167.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_167);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_168.setName("Collection");
		//symbol_168.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_168.setElementType(symbol_80);
		{
			TemplateBinding symbol_685 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_685.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_686 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_686.setFormal(symbol_38);	
				symbol_686.setActual(symbol_80);	
				symbol_685.getParameterSubstitutions().add(symbol_686);
			}
			symbol_168.getTemplateBindings().add(symbol_685);
		}
		symbol_168.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_168);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_169.setName("Collection");
		//symbol_169.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_169.setElementType(symbol_42);
		{
			TemplateBinding symbol_687 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_687.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_688 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_688.setFormal(symbol_38);	
				symbol_688.setActual(symbol_42);	
				symbol_687.getParameterSubstitutions().add(symbol_688);
			}
			symbol_169.getTemplateBindings().add(symbol_687);
		}
		symbol_169.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_169);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_170.setName("Collection");
		//symbol_170.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_170.setElementType(symbol_121);
		{
			TemplateBinding symbol_689 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_689.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_690 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_690.setFormal(symbol_38);	
				symbol_690.setActual(symbol_121);	
				symbol_689.getParameterSubstitutions().add(symbol_690);
			}
			symbol_170.getTemplateBindings().add(symbol_689);
		}
		symbol_170.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_170);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_171.setName("Collection");
		//symbol_171.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_171.setElementType(symbol_135);
		{
			TemplateBinding symbol_691 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_691.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_692 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_692.setFormal(symbol_38);	
				symbol_692.setActual(symbol_135);	
				symbol_691.getParameterSubstitutions().add(symbol_692);
			}
			symbol_171.getTemplateBindings().add(symbol_691);
		}
		symbol_171.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_171);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_172.setName("Collection");
		//symbol_172.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_172.setElementType(symbol_48);
		{
			TemplateBinding symbol_693 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_693.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_694 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_694.setFormal(symbol_38);	
				symbol_694.setActual(symbol_48);	
				symbol_693.getParameterSubstitutions().add(symbol_694);
			}
			symbol_172.getTemplateBindings().add(symbol_693);
		}
		symbol_172.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_172);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_173.setName("Collection");
		//symbol_173.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_173.setElementType(symbol_39);
		{
			TemplateBinding symbol_695 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_695.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_696 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_696.setFormal(symbol_38);	
				symbol_696.setActual(symbol_39);	
				symbol_695.getParameterSubstitutions().add(symbol_696);
			}
			symbol_173.getTemplateBindings().add(symbol_695);
		}
		symbol_173.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_173);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_174.setName("Collection");
		//symbol_174.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_174.setElementType(symbol_15);
		{
			TemplateBinding symbol_697 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_697.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_698 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_698.setFormal(symbol_38);	
				symbol_698.setActual(symbol_15);	
				symbol_697.getParameterSubstitutions().add(symbol_698);
			}
			symbol_174.getTemplateBindings().add(symbol_697);
		}
		symbol_174.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_174);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_175.setName("Collection");
		//symbol_175.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_175.setElementType(symbol_79);
		{
			TemplateBinding symbol_699 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_699.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_700 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_700.setFormal(symbol_38);	
				symbol_700.setActual(symbol_79);	
				symbol_699.getParameterSubstitutions().add(symbol_700);
			}
			symbol_175.getTemplateBindings().add(symbol_699);
		}
		symbol_175.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_175);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_176.setName("Collection");
		//symbol_176.setMoniker("ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_176.setElementType(symbol_100);
		{
			TemplateBinding symbol_701 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_701.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_702 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_702.setFormal(symbol_38);	
				symbol_702.setActual(symbol_100);	
				symbol_701.getParameterSubstitutions().add(symbol_702);
			}
			symbol_176.getTemplateBindings().add(symbol_701);
		}
		symbol_176.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_176);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_177.setName("Collection");
		//symbol_177.setMoniker("ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_177.setElementType(symbol_157);
		{
			TemplateBinding symbol_703 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_703.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_704 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_704.setFormal(symbol_38);	
				symbol_704.setActual(symbol_157);	
				symbol_703.getParameterSubstitutions().add(symbol_704);
			}
			symbol_177.getTemplateBindings().add(symbol_703);
		}
		symbol_177.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_177);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_178.setName("Collection");
		//symbol_178.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_178.setElementType(symbol_72);
		{
			TemplateBinding symbol_705 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_705.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_706 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_706.setFormal(symbol_38);	
				symbol_706.setActual(symbol_72);	
				symbol_705.getParameterSubstitutions().add(symbol_706);
			}
			symbol_178.getTemplateBindings().add(symbol_705);
		}
		symbol_178.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_178);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_179.setName("Collection");
		//symbol_179.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_179.setElementType(symbol_114);
		{
			TemplateBinding symbol_707 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_707.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_708 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_708.setFormal(symbol_38);	
				symbol_708.setActual(symbol_114);	
				symbol_707.getParameterSubstitutions().add(symbol_708);
			}
			symbol_179.getTemplateBindings().add(symbol_707);
		}
		symbol_179.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_179);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_180.setName("Collection");
		//symbol_180.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_180.setElementType(symbol_139);
		{
			TemplateBinding symbol_709 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_709.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_710 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_710.setFormal(symbol_38);	
				symbol_710.setActual(symbol_139);	
				symbol_709.getParameterSubstitutions().add(symbol_710);
			}
			symbol_180.getTemplateBindings().add(symbol_709);
		}
		symbol_180.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_180);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_181.setName("Collection");
		//symbol_181.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_181.setElementType(symbol_148);
		{
			TemplateBinding symbol_711 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_711.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_712 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_712.setFormal(symbol_38);	
				symbol_712.setActual(symbol_148);	
				symbol_711.getParameterSubstitutions().add(symbol_712);
			}
			symbol_181.getTemplateBindings().add(symbol_711);
		}
		symbol_181.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_181);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_182.setName("Collection");
		//symbol_182.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_182.setElementType(symbol_142);
		{
			TemplateBinding symbol_713 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_713.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_714 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_714.setFormal(symbol_38);	
				symbol_714.setActual(symbol_142);	
				symbol_713.getParameterSubstitutions().add(symbol_714);
			}
			symbol_182.getTemplateBindings().add(symbol_713);
		}
		symbol_182.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_182);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_183.setName("Collection");
		//symbol_183.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_183.setElementType(symbol_111);
		{
			TemplateBinding symbol_715 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_715.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_716 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_716.setFormal(symbol_38);	
				symbol_716.setActual(symbol_111);	
				symbol_715.getParameterSubstitutions().add(symbol_716);
			}
			symbol_183.getTemplateBindings().add(symbol_715);
		}
		symbol_183.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_183);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_184.setName("Collection");
		//symbol_184.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_184.setElementType(symbol_51);
		{
			TemplateBinding symbol_717 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_717.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_718 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_718.setFormal(symbol_38);	
				symbol_718.setActual(symbol_51);	
				symbol_717.getParameterSubstitutions().add(symbol_718);
			}
			symbol_184.getTemplateBindings().add(symbol_717);
		}
		symbol_184.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_184);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_185.setName("Collection");
		//symbol_185.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_185.setElementType(symbol_69);
		{
			TemplateBinding symbol_719 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_719.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_720 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_720.setFormal(symbol_38);	
				symbol_720.setActual(symbol_69);	
				symbol_719.getParameterSubstitutions().add(symbol_720);
			}
			symbol_185.getTemplateBindings().add(symbol_719);
		}
		symbol_185.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_185);
		//
		// ocl::$orphanage::Collection ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_186.setName("Collection");
		//symbol_186.setMoniker("ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_186.setElementType(symbol_22);
		{
			TemplateBinding symbol_721 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_721.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_722 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_722.setFormal(symbol_38);	
				symbol_722.setActual(symbol_22);	
				symbol_721.getParameterSubstitutions().add(symbol_722);
			}
			symbol_186.getTemplateBindings().add(symbol_721);
		}
		symbol_186.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_186);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_187.setName("Collection");
		//symbol_187.setMoniker("ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_187.setElementType(symbol_124);
		{
			TemplateBinding symbol_723 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_723.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_724 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_724.setFormal(symbol_38);	
				symbol_724.setActual(symbol_124);	
				symbol_723.getParameterSubstitutions().add(symbol_724);
			}
			symbol_187.getTemplateBindings().add(symbol_723);
		}
		symbol_187.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_187);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_188.setName("Collection");
		//symbol_188.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_188.setElementType(symbol_54);
		{
			TemplateBinding symbol_725 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_725.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_726 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_726.setFormal(symbol_38);	
				symbol_726.setActual(symbol_54);	
				symbol_725.getParameterSubstitutions().add(symbol_726);
			}
			symbol_188.getTemplateBindings().add(symbol_725);
		}
		symbol_188.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_188);
		//
		// ocl::$orphanage::Collection ocl!Collection[String]
		//
		symbol_189.setName("Collection");
		//symbol_189.setMoniker("ocl!Collection[String]");
		symbol_189.setElementType(symbol_143);
		{
			TemplateBinding symbol_727 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_727.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_728 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_728.setFormal(symbol_38);	
				symbol_728.setActual(symbol_143);	
				symbol_727.getParameterSubstitutions().add(symbol_728);
			}
			symbol_189.getTemplateBindings().add(symbol_727);
		}
		symbol_189.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_189);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_190.setName("Collection");
		//symbol_190.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_190.setElementType(symbol_83);
		{
			TemplateBinding symbol_729 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_729.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_730 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_730.setFormal(symbol_38);	
				symbol_730.setActual(symbol_83);	
				symbol_729.getParameterSubstitutions().add(symbol_730);
			}
			symbol_190.getTemplateBindings().add(symbol_729);
		}
		symbol_190.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_190);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_191.setName("Collection");
		//symbol_191.setMoniker("ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_191.setElementType(symbol_29);
		{
			TemplateBinding symbol_731 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_731.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_732 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_732.setFormal(symbol_38);	
				symbol_732.setActual(symbol_29);	
				symbol_731.getParameterSubstitutions().add(symbol_732);
			}
			symbol_191.getTemplateBindings().add(symbol_731);
		}
		symbol_191.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_191);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_192.setName("Collection");
		//symbol_192.setMoniker("ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_192.setElementType(symbol_107);
		{
			TemplateBinding symbol_733 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_733.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_734 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_734.setFormal(symbol_38);	
				symbol_734.setActual(symbol_107);	
				symbol_733.getParameterSubstitutions().add(symbol_734);
			}
			symbol_192.getTemplateBindings().add(symbol_733);
		}
		symbol_192.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_192);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_193.setName("Collection");
		//symbol_193.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_193.setElementType(symbol_60);
		{
			TemplateBinding symbol_735 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_735.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_736 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_736.setFormal(symbol_38);	
				symbol_736.setActual(symbol_60);	
				symbol_735.getParameterSubstitutions().add(symbol_736);
			}
			symbol_193.getTemplateBindings().add(symbol_735);
		}
		symbol_193.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_193);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		//
		symbol_194.setName("Lambda");
		//symbol_194.setMoniker("Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny");
		symbol_194.setContextType(symbol_79);
		symbol_194.setResultType(symbol_80);
		symbol_150.getOwnedTypes().add(symbol_194);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		//
		symbol_195.setName("Lambda");
		//symbol_195.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]");
		symbol_195.setContextType(symbol_111);
		symbol_195.setResultType(symbol_249);
		symbol_150.getOwnedTypes().add(symbol_195);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_196.setName("Lambda");
		//symbol_196.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_196.setContextType(symbol_69);
		symbol_196.setResultType(symbol_75);
		symbol_150.getOwnedTypes().add(symbol_196);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		//
		symbol_197.setName("Lambda");
		//symbol_197.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]");
		symbol_197.setContextType(symbol_69);
		symbol_197.setResultType(symbol_268);
		symbol_150.getOwnedTypes().add(symbol_197);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Set{T}?T()Boolean
		//
		symbol_198.setName("Lambda");
		//symbol_198.setMoniker("Lambda~ocl!Set{T}?T()Boolean");
		symbol_198.setContextType(symbol_139);
		symbol_198.setResultType(symbol_19);
		symbol_150.getOwnedTypes().add(symbol_198);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedSet{T}?T()Boolean
		//
		symbol_199.setName("Lambda");
		//symbol_199.setMoniker("Lambda~ocl!OrderedSet{T}?T()Boolean");
		symbol_199.setContextType(symbol_121);
		symbol_199.setResultType(symbol_19);
		symbol_150.getOwnedTypes().add(symbol_199);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_200.setName("Lambda");
		//symbol_200.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_200.setContextType(symbol_39);
		symbol_200.setResultType(symbol_45);
		symbol_150.getOwnedTypes().add(symbol_200);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_201.setName("Lambda");
		//symbol_201.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_201.setContextType(symbol_39);
		symbol_201.setResultType(symbol_42);
		symbol_150.getOwnedTypes().add(symbol_201);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Sequence{T}?T()Boolean
		//
		symbol_202.setName("Lambda");
		//symbol_202.setMoniker("Lambda~ocl!Sequence{T}?T()Boolean");
		symbol_202.setContextType(symbol_132);
		symbol_202.setResultType(symbol_19);
		symbol_150.getOwnedTypes().add(symbol_202);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!OclAny
		//
		symbol_203.setName("Lambda");
		//symbol_203.setMoniker("Lambda~ocl!Collection{T}?T()ocl!OclAny");
		symbol_203.setContextType(symbol_39);
		symbol_203.setResultType(symbol_80);
		symbol_150.getOwnedTypes().add(symbol_203);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_204.setName("Lambda");
		//symbol_204.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_204.setContextType(symbol_69);
		symbol_204.setResultType(symbol_72);
		symbol_150.getOwnedTypes().add(symbol_204);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Bag{T}?T()Boolean
		//
		symbol_205.setName("Lambda");
		//symbol_205.setMoniker("Lambda~ocl!Bag{T}?T()Boolean");
		symbol_205.setContextType(symbol_15);
		symbol_205.setResultType(symbol_19);
		symbol_150.getOwnedTypes().add(symbol_205);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_206.setName("Lambda");
		//symbol_206.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_206.setContextType(symbol_111);
		symbol_206.setResultType(symbol_114);
		symbol_150.getOwnedTypes().add(symbol_206);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()Boolean
		//
		symbol_207.setName("Lambda");
		//symbol_207.setMoniker("Lambda~ocl!Collection{T}?T()Boolean");
		symbol_207.setContextType(symbol_39);
		symbol_207.setResultType(symbol_19);
		symbol_150.getOwnedTypes().add(symbol_207);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		//
		symbol_208.setName("Lambda");
		//symbol_208.setMoniker("Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny");
		symbol_208.setContextType(symbol_148);
		symbol_208.setResultType(symbol_80);
		symbol_150.getOwnedTypes().add(symbol_208);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_209.setName("Lambda");
		//symbol_209.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_209.setContextType(symbol_111);
		symbol_209.setResultType(symbol_117);
		symbol_150.getOwnedTypes().add(symbol_209);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_210.setName("NonOrderedCollection");
		//symbol_210.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_210.setElementType(symbol_100);
		{
			TemplateBinding symbol_737 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_737.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_738 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_738.setFormal(symbol_68);	
				symbol_738.setActual(symbol_100);	
				symbol_737.getParameterSubstitutions().add(symbol_738);
			}
			symbol_210.getTemplateBindings().add(symbol_737);
		}
		symbol_210.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_210);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_211.setName("NonOrderedCollection");
		//symbol_211.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_211.setElementType(symbol_139);
		{
			TemplateBinding symbol_739 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_739.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_740 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_740.setFormal(symbol_68);	
				symbol_740.setActual(symbol_139);	
				symbol_739.getParameterSubstitutions().add(symbol_740);
			}
			symbol_211.getTemplateBindings().add(symbol_739);
		}
		symbol_211.getSuperClasses().add(symbol_180); // ocl!Collection[ocl!Set{T}?T]
		symbol_150.getOwnedTypes().add(symbol_211);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_212.setName("NonOrderedCollection");
		//symbol_212.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_212.setElementType(symbol_18);
		{
			TemplateBinding symbol_741 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_741.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_742 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_742.setFormal(symbol_68);	
				symbol_742.setActual(symbol_18);	
				symbol_741.getParameterSubstitutions().add(symbol_742);
			}
			symbol_212.getTemplateBindings().add(symbol_741);
		}
		symbol_212.getSuperClasses().add(symbol_164); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_212);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_213.setName("NonOrderedCollection");
		//symbol_213.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_213.setElementType(symbol_15);
		{
			TemplateBinding symbol_743 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_743.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_744 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_744.setFormal(symbol_68);	
				symbol_744.setActual(symbol_15);	
				symbol_743.getParameterSubstitutions().add(symbol_744);
			}
			symbol_213.getTemplateBindings().add(symbol_743);
		}
		symbol_213.getSuperClasses().add(symbol_174); // ocl!Collection[ocl!Bag{T}?T]
		symbol_150.getOwnedTypes().add(symbol_213);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_214.setName("NonOrderedCollection");
		//symbol_214.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_214.setElementType(symbol_72);
		{
			TemplateBinding symbol_745 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_745.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_746 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_746.setFormal(symbol_68);	
				symbol_746.setActual(symbol_72);	
				symbol_745.getParameterSubstitutions().add(symbol_746);
			}
			symbol_214.getTemplateBindings().add(symbol_745);
		}
		symbol_214.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_214);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_215.setName("NonOrderedCollection");
		//symbol_215.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_215.setElementType(symbol_274);
		{
			TemplateBinding symbol_747 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_747.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_748 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_748.setFormal(symbol_68);	
				symbol_748.setActual(symbol_274);	
				symbol_747.getParameterSubstitutions().add(symbol_748);
			}
			symbol_215.getTemplateBindings().add(symbol_747);
		}
		symbol_215.getSuperClasses().add(symbol_166); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_150.getOwnedTypes().add(symbol_215);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_216.setName("NonOrderedCollection");
		//symbol_216.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_216.setElementType(symbol_64);
		{
			TemplateBinding symbol_749 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_749.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_750 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_750.setFormal(symbol_68);	
				symbol_750.setActual(symbol_64);	
				symbol_749.getParameterSubstitutions().add(symbol_750);
			}
			symbol_216.getTemplateBindings().add(symbol_749);
		}
		symbol_216.getSuperClasses().add(symbol_167); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_216);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_217.setName("NonOrderedCollection");
		//symbol_217.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_217.setElementType(symbol_107);
		{
			TemplateBinding symbol_751 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_751.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_752 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_752.setFormal(symbol_68);	
				symbol_752.setActual(symbol_107);	
				symbol_751.getParameterSubstitutions().add(symbol_752);
			}
			symbol_217.getTemplateBindings().add(symbol_751);
		}
		symbol_217.getSuperClasses().add(symbol_192); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_217);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_218.setName("NonOrderedCollection");
		//symbol_218.setMoniker("ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_218.setElementType(symbol_22);
		{
			TemplateBinding symbol_753 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_753.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_754 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_754.setFormal(symbol_68);	
				symbol_754.setActual(symbol_22);	
				symbol_753.getParameterSubstitutions().add(symbol_754);
			}
			symbol_218.getTemplateBindings().add(symbol_753);
		}
		symbol_218.getSuperClasses().add(symbol_186); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_218);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_219.setName("NonOrderedCollection");
		//symbol_219.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_219.setElementType(symbol_39);
		{
			TemplateBinding symbol_755 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_755.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_756 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_756.setFormal(symbol_68);	
				symbol_756.setActual(symbol_39);	
				symbol_755.getParameterSubstitutions().add(symbol_756);
			}
			symbol_219.getTemplateBindings().add(symbol_755);
		}
		symbol_219.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_219);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_220.setName("NonOrderedCollection");
		//symbol_220.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_220.setElementType(symbol_80);
		{
			TemplateBinding symbol_757 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_757.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_758 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_758.setFormal(symbol_68);	
				symbol_758.setActual(symbol_80);	
				symbol_757.getParameterSubstitutions().add(symbol_758);
			}
			symbol_220.getTemplateBindings().add(symbol_757);
		}
		symbol_220.getSuperClasses().add(symbol_168); // ocl!Collection[ocl!OclAny]
		symbol_150.getOwnedTypes().add(symbol_220);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_221.setName("NonOrderedCollection");
		//symbol_221.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_221.setElementType(symbol_142);
		{
			TemplateBinding symbol_759 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_759.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_760 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_760.setFormal(symbol_68);	
				symbol_760.setActual(symbol_142);	
				symbol_759.getParameterSubstitutions().add(symbol_760);
			}
			symbol_221.getTemplateBindings().add(symbol_759);
		}
		symbol_221.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_221);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_222.setName("NonOrderedCollection");
		//symbol_222.setMoniker("ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_222.setElementType(symbol_29);
		{
			TemplateBinding symbol_761 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_761.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_762 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_762.setFormal(symbol_68);	
				symbol_762.setActual(symbol_29);	
				symbol_761.getParameterSubstitutions().add(symbol_762);
			}
			symbol_222.getTemplateBindings().add(symbol_761);
		}
		symbol_222.getSuperClasses().add(symbol_191); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_222);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_223.setName("NonOrderedCollection");
		//symbol_223.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_223.setElementType(symbol_69);
		{
			TemplateBinding symbol_763 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_763.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_764 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_764.setFormal(symbol_68);	
				symbol_764.setActual(symbol_69);	
				symbol_763.getParameterSubstitutions().add(symbol_764);
			}
			symbol_223.getTemplateBindings().add(symbol_763);
		}
		symbol_223.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_223);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_224.setName("NonOrderedCollection");
		//symbol_224.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_224.setElementType(symbol_121);
		{
			TemplateBinding symbol_765 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_765.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_766 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_766.setFormal(symbol_68);	
				symbol_766.setActual(symbol_121);	
				symbol_765.getParameterSubstitutions().add(symbol_766);
			}
			symbol_224.getTemplateBindings().add(symbol_765);
		}
		symbol_224.getSuperClasses().add(symbol_170); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_224);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_225.setName("NonOrderedCollection");
		//symbol_225.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_225.setElementType(symbol_83);
		{
			TemplateBinding symbol_767 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_767.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_768 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_768.setFormal(symbol_68);	
				symbol_768.setActual(symbol_83);	
				symbol_767.getParameterSubstitutions().add(symbol_768);
			}
			symbol_225.getTemplateBindings().add(symbol_767);
		}
		symbol_225.getSuperClasses().add(symbol_190); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_225);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_226.setName("NonOrderedCollection");
		//symbol_226.setMoniker("ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_226.setElementType(symbol_157);
		{
			TemplateBinding symbol_769 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_769.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_770 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_770.setFormal(symbol_68);	
				symbol_770.setActual(symbol_157);	
				symbol_769.getParameterSubstitutions().add(symbol_770);
			}
			symbol_226.getTemplateBindings().add(symbol_769);
		}
		symbol_226.getSuperClasses().add(symbol_177); // ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_150.getOwnedTypes().add(symbol_226);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_227.setName("NonUniqueCollection");
		//symbol_227.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_227.setElementType(symbol_132);
		{
			TemplateBinding symbol_771 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_771.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_772 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_772.setFormal(symbol_78);	
				symbol_772.setActual(symbol_132);	
				symbol_771.getParameterSubstitutions().add(symbol_772);
			}
			symbol_227.getTemplateBindings().add(symbol_771);
		}
		symbol_227.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_150.getOwnedTypes().add(symbol_227);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_228.setName("NonUniqueCollection");
		//symbol_228.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_228.setElementType(symbol_69);
		{
			TemplateBinding symbol_773 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_773.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_774 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_774.setFormal(symbol_78);	
				symbol_774.setActual(symbol_69);	
				symbol_773.getParameterSubstitutions().add(symbol_774);
			}
			symbol_228.getTemplateBindings().add(symbol_773);
		}
		symbol_228.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_228);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_229.setName("NonUniqueCollection");
		//symbol_229.setMoniker("ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_229.setElementType(symbol_79);
		{
			TemplateBinding symbol_775 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_775.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_776 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_776.setFormal(symbol_78);	
				symbol_776.setActual(symbol_79);	
				symbol_775.getParameterSubstitutions().add(symbol_776);
			}
			symbol_229.getTemplateBindings().add(symbol_775);
		}
		symbol_229.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_229);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_230.setName("NonUniqueCollection");
		//symbol_230.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_230.setElementType(symbol_18);
		{
			TemplateBinding symbol_777 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_777.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_778 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_778.setFormal(symbol_78);	
				symbol_778.setActual(symbol_18);	
				symbol_777.getParameterSubstitutions().add(symbol_778);
			}
			symbol_230.getTemplateBindings().add(symbol_777);
		}
		symbol_230.getSuperClasses().add(symbol_164); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_230);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_231.setName("NonUniqueCollection");
		//symbol_231.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_231.setElementType(symbol_135);
		{
			TemplateBinding symbol_779 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_779.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_780 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_780.setFormal(symbol_78);	
				symbol_780.setActual(symbol_135);	
				symbol_779.getParameterSubstitutions().add(symbol_780);
			}
			symbol_231.getTemplateBindings().add(symbol_779);
		}
		symbol_231.getSuperClasses().add(symbol_171); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_231);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_232.setName("NonUniqueCollection");
		//symbol_232.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_232.setElementType(symbol_143);
		{
			TemplateBinding symbol_781 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_781.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_782 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_782.setFormal(symbol_78);	
				symbol_782.setActual(symbol_143);	
				symbol_781.getParameterSubstitutions().add(symbol_782);
			}
			symbol_232.getTemplateBindings().add(symbol_781);
		}
		symbol_232.getSuperClasses().add(symbol_189); // ocl!Collection[String]
		symbol_150.getOwnedTypes().add(symbol_232);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_233.setName("NonUniqueCollection");
		//symbol_233.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_233.setElementType(symbol_72);
		{
			TemplateBinding symbol_783 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_783.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_784 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_784.setFormal(symbol_78);	
				symbol_784.setActual(symbol_72);	
				symbol_783.getParameterSubstitutions().add(symbol_784);
			}
			symbol_233.getTemplateBindings().add(symbol_783);
		}
		symbol_233.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_233);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_234.setName("NonUniqueCollection");
		//symbol_234.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_234.setElementType(symbol_111);
		{
			TemplateBinding symbol_785 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_785.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_786 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_786.setFormal(symbol_78);	
				symbol_786.setActual(symbol_111);	
				symbol_785.getParameterSubstitutions().add(symbol_786);
			}
			symbol_234.getTemplateBindings().add(symbol_785);
		}
		symbol_234.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_234);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_235.setName("NonUniqueCollection");
		//symbol_235.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_235.setElementType(symbol_114);
		{
			TemplateBinding symbol_787 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_787.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_788 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_788.setFormal(symbol_78);	
				symbol_788.setActual(symbol_114);	
				symbol_787.getParameterSubstitutions().add(symbol_788);
			}
			symbol_235.getTemplateBindings().add(symbol_787);
		}
		symbol_235.getSuperClasses().add(symbol_179); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_235);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_236.setName("NonUniqueCollection");
		//symbol_236.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_236.setElementType(symbol_39);
		{
			TemplateBinding symbol_789 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_789.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_790 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_790.setFormal(symbol_78);	
				symbol_790.setActual(symbol_39);	
				symbol_789.getParameterSubstitutions().add(symbol_790);
			}
			symbol_236.getTemplateBindings().add(symbol_789);
		}
		symbol_236.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_236);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_237.setName("NonUniqueCollection");
		//symbol_237.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_237.setElementType(symbol_15);
		{
			TemplateBinding symbol_791 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_791.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_792 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_792.setFormal(symbol_78);	
				symbol_792.setActual(symbol_15);	
				symbol_791.getParameterSubstitutions().add(symbol_792);
			}
			symbol_237.getTemplateBindings().add(symbol_791);
		}
		symbol_237.getSuperClasses().add(symbol_174); // ocl!Collection[ocl!Bag{T}?T]
		symbol_150.getOwnedTypes().add(symbol_237);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_238.setName("OrderedCollection");
		//symbol_238.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_238.setElementType(symbol_135);
		{
			TemplateBinding symbol_793 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_793.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_794 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_794.setFormal(symbol_110);	
				symbol_794.setActual(symbol_135);	
				symbol_793.getParameterSubstitutions().add(symbol_794);
			}
			symbol_238.getTemplateBindings().add(symbol_793);
		}
		symbol_238.getSuperClasses().add(symbol_171); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_238);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_239.setName("OrderedCollection");
		//symbol_239.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_239.setElementType(symbol_39);
		{
			TemplateBinding symbol_795 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_795.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_796 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_796.setFormal(symbol_110);	
				symbol_796.setActual(symbol_39);	
				symbol_795.getParameterSubstitutions().add(symbol_796);
			}
			symbol_239.getTemplateBindings().add(symbol_795);
		}
		symbol_239.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_239);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_240.setName("OrderedCollection");
		//symbol_240.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_240.setElementType(symbol_114);
		{
			TemplateBinding symbol_797 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_797.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_798 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_798.setFormal(symbol_110);	
				symbol_798.setActual(symbol_114);	
				symbol_797.getParameterSubstitutions().add(symbol_798);
			}
			symbol_240.getTemplateBindings().add(symbol_797);
		}
		symbol_240.getSuperClasses().add(symbol_179); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_240);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_241.setName("OrderedCollection");
		//symbol_241.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_241.setElementType(symbol_124);
		{
			TemplateBinding symbol_799 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_799.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_800 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_800.setFormal(symbol_110);	
				symbol_800.setActual(symbol_124);	
				symbol_799.getParameterSubstitutions().add(symbol_800);
			}
			symbol_241.getTemplateBindings().add(symbol_799);
		}
		symbol_241.getSuperClasses().add(symbol_187); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_241);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_242.setName("OrderedCollection");
		//symbol_242.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_242.setElementType(symbol_132);
		{
			TemplateBinding symbol_801 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_801.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_802 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_802.setFormal(symbol_110);	
				symbol_802.setActual(symbol_132);	
				symbol_801.getParameterSubstitutions().add(symbol_802);
			}
			symbol_242.getTemplateBindings().add(symbol_801);
		}
		symbol_242.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_150.getOwnedTypes().add(symbol_242);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_243.setName("OrderedCollection");
		//symbol_243.setMoniker("ocl!OrderedCollection[String]");
		symbol_243.setElementType(symbol_143);
		{
			TemplateBinding symbol_803 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_803.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_804 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_804.setFormal(symbol_110);	
				symbol_804.setActual(symbol_143);	
				symbol_803.getParameterSubstitutions().add(symbol_804);
			}
			symbol_243.getTemplateBindings().add(symbol_803);
		}
		symbol_243.getSuperClasses().add(symbol_189); // ocl!Collection[String]
		symbol_150.getOwnedTypes().add(symbol_243);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_244.setName("OrderedCollection");
		//symbol_244.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_244.setElementType(symbol_121);
		{
			TemplateBinding symbol_805 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_805.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_806 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_806.setFormal(symbol_110);	
				symbol_806.setActual(symbol_121);	
				symbol_805.getParameterSubstitutions().add(symbol_806);
			}
			symbol_244.getTemplateBindings().add(symbol_805);
		}
		symbol_244.getSuperClasses().add(symbol_170); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_244);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_245.setName("OrderedCollection");
		//symbol_245.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_245.setElementType(symbol_148);
		{
			TemplateBinding symbol_807 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_807.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_808 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_808.setFormal(symbol_110);	
				symbol_808.setActual(symbol_148);	
				symbol_807.getParameterSubstitutions().add(symbol_808);
			}
			symbol_245.getTemplateBindings().add(symbol_807);
		}
		symbol_245.getSuperClasses().add(symbol_181); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_245);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_246.setName("OrderedCollection");
		//symbol_246.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_246.setElementType(symbol_111);
		{
			TemplateBinding symbol_809 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_809.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_810 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_810.setFormal(symbol_110);	
				symbol_810.setActual(symbol_111);	
				symbol_809.getParameterSubstitutions().add(symbol_810);
			}
			symbol_246.getTemplateBindings().add(symbol_809);
		}
		symbol_246.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_246);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_247.setName("OrderedCollection");
		//symbol_247.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_247.setElementType(symbol_79);
		{
			TemplateBinding symbol_811 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_811.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_812 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_812.setFormal(symbol_110);	
				symbol_812.setActual(symbol_79);	
				symbol_811.getParameterSubstitutions().add(symbol_812);
			}
			symbol_247.getTemplateBindings().add(symbol_811);
		}
		symbol_247.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_247);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_248.setName("OrderedSet");
		//symbol_248.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_248.setElementType(symbol_148);
		{
			TemplateBinding symbol_813 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_813.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_814 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_814.setFormal(symbol_120);	
				symbol_814.setActual(symbol_148);	
				symbol_813.getParameterSubstitutions().add(symbol_814);
			}
			symbol_248.getTemplateBindings().add(symbol_813);
		}
		symbol_248.getSuperClasses().add(symbol_287); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		symbol_248.getSuperClasses().add(symbol_245); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_248);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_249.setName("OrderedSet");
		//symbol_249.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_249.setElementType(symbol_111);
		{
			TemplateBinding symbol_815 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_815.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_816 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_816.setFormal(symbol_120);	
				symbol_816.setActual(symbol_111);	
				symbol_815.getParameterSubstitutions().add(symbol_816);
			}
			symbol_249.getTemplateBindings().add(symbol_815);
		}
		symbol_249.getSuperClasses().add(symbol_284); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_249.getSuperClasses().add(symbol_246); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_249);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_250.setName("OrderedSet");
		//symbol_250.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_250.setElementType(symbol_121);
		{
			TemplateBinding symbol_817 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_817.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_818 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_818.setFormal(symbol_120);	
				symbol_818.setActual(symbol_121);	
				symbol_817.getParameterSubstitutions().add(symbol_818);
			}
			symbol_250.getTemplateBindings().add(symbol_817);
		}
		symbol_250.getSuperClasses().add(symbol_244); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_250.getSuperClasses().add(symbol_285); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_250);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_251.setName("OrderedSet");
		//symbol_251.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_251.setElementType(symbol_39);
		{
			TemplateBinding symbol_819 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_819.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_820 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_820.setFormal(symbol_120);	
				symbol_820.setActual(symbol_39);	
				symbol_819.getParameterSubstitutions().add(symbol_820);
			}
			symbol_251.getTemplateBindings().add(symbol_819);
		}
		symbol_251.getSuperClasses().add(symbol_239); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_251.getSuperClasses().add(symbol_279); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_251);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_252.setName("OrderedSet");
		//symbol_252.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_252.setElementType(symbol_124);
		{
			TemplateBinding symbol_821 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_821.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_822 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_822.setFormal(symbol_120);	
				symbol_822.setActual(symbol_124);	
				symbol_821.getParameterSubstitutions().add(symbol_822);
			}
			symbol_252.getTemplateBindings().add(symbol_821);
		}
		symbol_252.getSuperClasses().add(symbol_241); // ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_252.getSuperClasses().add(symbol_277); // ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_252);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_253.setName("Sequence");
		//symbol_253.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_253.setElementType(symbol_79);
		{
			TemplateBinding symbol_823 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_823.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_824 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_824.setFormal(symbol_131);	
				symbol_824.setActual(symbol_79);	
				symbol_823.getParameterSubstitutions().add(symbol_824);
			}
			symbol_253.getTemplateBindings().add(symbol_823);
		}
		symbol_253.getSuperClasses().add(symbol_247); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_253.getSuperClasses().add(symbol_229); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_253);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_254.setName("Sequence");
		//symbol_254.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_254.setElementType(symbol_135);
		{
			TemplateBinding symbol_825 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_825.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_826 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_826.setFormal(symbol_131);	
				symbol_826.setActual(symbol_135);	
				symbol_825.getParameterSubstitutions().add(symbol_826);
			}
			symbol_254.getTemplateBindings().add(symbol_825);
		}
		symbol_254.getSuperClasses().add(symbol_238); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_254.getSuperClasses().add(symbol_231); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_254);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[String]
		//
		symbol_255.setName("Sequence");
		//symbol_255.setMoniker("ocl!Sequence[String]");
		symbol_255.setElementType(symbol_143);
		{
			TemplateBinding symbol_827 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_827.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_828 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_828.setFormal(symbol_131);	
				symbol_828.setActual(symbol_143);	
				symbol_827.getParameterSubstitutions().add(symbol_828);
			}
			symbol_255.getTemplateBindings().add(symbol_827);
		}
		symbol_255.getSuperClasses().add(symbol_243); // ocl!OrderedCollection[String]
		symbol_255.getSuperClasses().add(symbol_232); // ocl!NonUniqueCollection[String]
		symbol_150.getOwnedTypes().add(symbol_255);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_256.setName("Sequence");
		//symbol_256.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_256.setElementType(symbol_132);
		{
			TemplateBinding symbol_829 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_829.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_830 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_830.setFormal(symbol_131);	
				symbol_830.setActual(symbol_132);	
				symbol_829.getParameterSubstitutions().add(symbol_830);
			}
			symbol_256.getTemplateBindings().add(symbol_829);
		}
		symbol_256.getSuperClasses().add(symbol_242); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_256.getSuperClasses().add(symbol_227); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_150.getOwnedTypes().add(symbol_256);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_257.setName("Sequence");
		//symbol_257.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_257.setElementType(symbol_39);
		{
			TemplateBinding symbol_831 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_831.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_832 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_832.setFormal(symbol_131);	
				symbol_832.setActual(symbol_39);	
				symbol_831.getParameterSubstitutions().add(symbol_832);
			}
			symbol_257.getTemplateBindings().add(symbol_831);
		}
		symbol_257.getSuperClasses().add(symbol_239); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_257.getSuperClasses().add(symbol_236); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_257);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_258.setName("Sequence");
		//symbol_258.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_258.setElementType(symbol_111);
		{
			TemplateBinding symbol_833 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_833.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_834 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_834.setFormal(symbol_131);	
				symbol_834.setActual(symbol_111);	
				symbol_833.getParameterSubstitutions().add(symbol_834);
			}
			symbol_258.getTemplateBindings().add(symbol_833);
		}
		symbol_258.getSuperClasses().add(symbol_246); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_258.getSuperClasses().add(symbol_234); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_258);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_259.setName("Sequence");
		//symbol_259.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_259.setElementType(symbol_114);
		{
			TemplateBinding symbol_835 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_835.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_836 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_836.setFormal(symbol_131);	
				symbol_836.setActual(symbol_114);	
				symbol_835.getParameterSubstitutions().add(symbol_836);
			}
			symbol_259.getTemplateBindings().add(symbol_835);
		}
		symbol_259.getSuperClasses().add(symbol_235); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_259.getSuperClasses().add(symbol_240); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_259);
		//
		// ocl::$orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_260.setName("Set");
		//symbol_260.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_260.setElementType(symbol_274);
		{
			TemplateBinding symbol_837 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_837.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_838 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_838.setFormal(symbol_138);	
				symbol_838.setActual(symbol_274);	
				symbol_837.getParameterSubstitutions().add(symbol_838);
			}
			symbol_260.getTemplateBindings().add(symbol_837);
		}
		symbol_260.getSuperClasses().add(symbol_283); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_260.getSuperClasses().add(symbol_215); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_150.getOwnedTypes().add(symbol_260);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_261.setName("Set");
		//symbol_261.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_261.setElementType(symbol_83);
		{
			TemplateBinding symbol_839 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_839.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_840 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_840.setFormal(symbol_138);	
				symbol_840.setActual(symbol_83);	
				symbol_839.getParameterSubstitutions().add(symbol_840);
			}
			symbol_261.getTemplateBindings().add(symbol_839);
		}
		symbol_261.getSuperClasses().add(symbol_288); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_261.getSuperClasses().add(symbol_225); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_261);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_262.setName("Set");
		//symbol_262.setMoniker("ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_262.setElementType(symbol_64);
		{
			TemplateBinding symbol_841 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_841.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_842 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_842.setFormal(symbol_138);	
				symbol_842.setActual(symbol_64);	
				symbol_841.getParameterSubstitutions().add(symbol_842);
			}
			symbol_262.getTemplateBindings().add(symbol_841);
		}
		symbol_262.getSuperClasses().add(symbol_216); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_262.getSuperClasses().add(symbol_278); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_262);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_263.setName("Set");
		//symbol_263.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_263.setElementType(symbol_142);
		{
			TemplateBinding symbol_843 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_843.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_844 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_844.setFormal(symbol_138);	
				symbol_844.setActual(symbol_142);	
				symbol_843.getParameterSubstitutions().add(symbol_844);
			}
			symbol_263.getTemplateBindings().add(symbol_843);
		}
		symbol_263.getSuperClasses().add(symbol_286); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_263.getSuperClasses().add(symbol_221); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_263);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_264.setName("Set");
		//symbol_264.setMoniker("ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_264.setElementType(symbol_157);
		{
			TemplateBinding symbol_845 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_845.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_846 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_846.setFormal(symbol_138);	
				symbol_846.setActual(symbol_157);	
				symbol_845.getParameterSubstitutions().add(symbol_846);
			}
			symbol_264.getTemplateBindings().add(symbol_845);
		}
		symbol_264.getSuperClasses().add(symbol_226); // ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_264.getSuperClasses().add(symbol_289); // ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_150.getOwnedTypes().add(symbol_264);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_265.setName("Set");
		//symbol_265.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_265.setElementType(symbol_80);
		{
			TemplateBinding symbol_847 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_847.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_848 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_848.setFormal(symbol_138);	
				symbol_848.setActual(symbol_80);	
				symbol_847.getParameterSubstitutions().add(symbol_848);
			}
			symbol_265.getTemplateBindings().add(symbol_847);
		}
		symbol_265.getSuperClasses().add(symbol_220); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_265.getSuperClasses().add(symbol_293); // ocl!UniqueCollection[ocl!OclAny]
		symbol_150.getOwnedTypes().add(symbol_265);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_266.setName("Set");
		//symbol_266.setMoniker("ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_266.setElementType(symbol_107);
		{
			TemplateBinding symbol_849 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_849.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_850 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_850.setFormal(symbol_138);	
				symbol_850.setActual(symbol_107);	
				symbol_849.getParameterSubstitutions().add(symbol_850);
			}
			symbol_266.getTemplateBindings().add(symbol_849);
		}
		symbol_266.getSuperClasses().add(symbol_292); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_266.getSuperClasses().add(symbol_217); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_266);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_267.setName("Set");
		//symbol_267.setMoniker("ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_267.setElementType(symbol_29);
		{
			TemplateBinding symbol_851 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_851.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_852 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_852.setFormal(symbol_138);	
				symbol_852.setActual(symbol_29);	
				symbol_851.getParameterSubstitutions().add(symbol_852);
			}
			symbol_267.getTemplateBindings().add(symbol_851);
		}
		symbol_267.getSuperClasses().add(symbol_222); // ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_267.getSuperClasses().add(symbol_280); // ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_267);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_268.setName("Set");
		//symbol_268.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_268.setElementType(symbol_69);
		{
			TemplateBinding symbol_853 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_853.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_854 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_854.setFormal(symbol_138);	
				symbol_854.setActual(symbol_69);	
				symbol_853.getParameterSubstitutions().add(symbol_854);
			}
			symbol_268.getTemplateBindings().add(symbol_853);
		}
		symbol_268.getSuperClasses().add(symbol_291); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_268.getSuperClasses().add(symbol_223); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_268);
		//
		// ocl::$orphanage::Set ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_269.setName("Set");
		//symbol_269.setMoniker("ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_269.setElementType(symbol_22);
		{
			TemplateBinding symbol_855 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_855.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_856 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_856.setFormal(symbol_138);	
				symbol_856.setActual(symbol_22);	
				symbol_855.getParameterSubstitutions().add(symbol_856);
			}
			symbol_269.getTemplateBindings().add(symbol_855);
		}
		symbol_269.getSuperClasses().add(symbol_290); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_269.getSuperClasses().add(symbol_218); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_269);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_270.setName("Set");
		//symbol_270.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_270.setElementType(symbol_139);
		{
			TemplateBinding symbol_857 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_857.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_858 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_858.setFormal(symbol_138);	
				symbol_858.setActual(symbol_139);	
				symbol_857.getParameterSubstitutions().add(symbol_858);
			}
			symbol_270.getTemplateBindings().add(symbol_857);
		}
		symbol_270.getSuperClasses().add(symbol_282); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_270.getSuperClasses().add(symbol_211); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_150.getOwnedTypes().add(symbol_270);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_271.setName("Set");
		//symbol_271.setMoniker("ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_271.setElementType(symbol_100);
		{
			TemplateBinding symbol_859 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_859.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_860 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_860.setFormal(symbol_138);	
				symbol_860.setActual(symbol_100);	
				symbol_859.getParameterSubstitutions().add(symbol_860);
			}
			symbol_271.getTemplateBindings().add(symbol_859);
		}
		symbol_271.getSuperClasses().add(symbol_281); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_271.getSuperClasses().add(symbol_210); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_271);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_272.setName("Set");
		//symbol_272.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_272.setElementType(symbol_121);
		{
			TemplateBinding symbol_861 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_861.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_862 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_862.setFormal(symbol_138);	
				symbol_862.setActual(symbol_121);	
				symbol_861.getParameterSubstitutions().add(symbol_862);
			}
			symbol_272.getTemplateBindings().add(symbol_861);
		}
		symbol_272.getSuperClasses().add(symbol_285); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_272.getSuperClasses().add(symbol_224); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_272);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_273.setName("Set");
		//symbol_273.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_273.setElementType(symbol_39);
		{
			TemplateBinding symbol_863 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_863.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_864 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_864.setFormal(symbol_138);	
				symbol_864.setActual(symbol_39);	
				symbol_863.getParameterSubstitutions().add(symbol_864);
			}
			symbol_273.getTemplateBindings().add(symbol_863);
		}
		symbol_273.getSuperClasses().add(symbol_219); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_273.getSuperClasses().add(symbol_279); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_273);
		//
		// ocl::$orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_274.setName("Tuple");
		//symbol_274.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		symbol_274.getSuperClasses().add(symbol_144); // ocl!Tuple
		{ // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_275.setName("first");
			symbol_275.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_275.setIsResolveProxies(true);
			symbol_274.getOwnedAttributes().add(symbol_275);
		}
		{ // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_276.setName("second");
			symbol_276.setType(symbol_60);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_276.setIsResolveProxies(true);
			symbol_274.getOwnedAttributes().add(symbol_276);
		}
		symbol_150.getOwnedTypes().add(symbol_274);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_277.setName("UniqueCollection");
		//symbol_277.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_277.setElementType(symbol_124);
		{
			TemplateBinding symbol_865 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_865.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_866 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_866.setFormal(symbol_147);	
				symbol_866.setActual(symbol_124);	
				symbol_865.getParameterSubstitutions().add(symbol_866);
			}
			symbol_277.getTemplateBindings().add(symbol_865);
		}
		symbol_277.getSuperClasses().add(symbol_187); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_277);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_278.setName("UniqueCollection");
		//symbol_278.setMoniker("ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_278.setElementType(symbol_64);
		{
			TemplateBinding symbol_867 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_867.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_868 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_868.setFormal(symbol_147);	
				symbol_868.setActual(symbol_64);	
				symbol_867.getParameterSubstitutions().add(symbol_868);
			}
			symbol_278.getTemplateBindings().add(symbol_867);
		}
		symbol_278.getSuperClasses().add(symbol_167); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_278);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_279.setName("UniqueCollection");
		//symbol_279.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_279.setElementType(symbol_39);
		{
			TemplateBinding symbol_869 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_869.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_870 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_870.setFormal(symbol_147);	
				symbol_870.setActual(symbol_39);	
				symbol_869.getParameterSubstitutions().add(symbol_870);
			}
			symbol_279.getTemplateBindings().add(symbol_869);
		}
		symbol_279.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_279);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_280.setName("UniqueCollection");
		//symbol_280.setMoniker("ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_280.setElementType(symbol_29);
		{
			TemplateBinding symbol_871 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_871.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_872 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_872.setFormal(symbol_147);	
				symbol_872.setActual(symbol_29);	
				symbol_871.getParameterSubstitutions().add(symbol_872);
			}
			symbol_280.getTemplateBindings().add(symbol_871);
		}
		symbol_280.getSuperClasses().add(symbol_191); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_280);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_281.setName("UniqueCollection");
		//symbol_281.setMoniker("ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_281.setElementType(symbol_100);
		{
			TemplateBinding symbol_873 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_873.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_874 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_874.setFormal(symbol_147);	
				symbol_874.setActual(symbol_100);	
				symbol_873.getParameterSubstitutions().add(symbol_874);
			}
			symbol_281.getTemplateBindings().add(symbol_873);
		}
		symbol_281.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_281);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_282.setName("UniqueCollection");
		//symbol_282.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_282.setElementType(symbol_139);
		{
			TemplateBinding symbol_875 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_875.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_876 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_876.setFormal(symbol_147);	
				symbol_876.setActual(symbol_139);	
				symbol_875.getParameterSubstitutions().add(symbol_876);
			}
			symbol_282.getTemplateBindings().add(symbol_875);
		}
		symbol_282.getSuperClasses().add(symbol_180); // ocl!Collection[ocl!Set{T}?T]
		symbol_150.getOwnedTypes().add(symbol_282);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_283.setName("UniqueCollection");
		//symbol_283.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_283.setElementType(symbol_274);
		{
			TemplateBinding symbol_877 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_877.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_878 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_878.setFormal(symbol_147);	
				symbol_878.setActual(symbol_274);	
				symbol_877.getParameterSubstitutions().add(symbol_878);
			}
			symbol_283.getTemplateBindings().add(symbol_877);
		}
		symbol_283.getSuperClasses().add(symbol_166); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_150.getOwnedTypes().add(symbol_283);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_284.setName("UniqueCollection");
		//symbol_284.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_284.setElementType(symbol_111);
		{
			TemplateBinding symbol_879 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_879.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_880 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_880.setFormal(symbol_147);	
				symbol_880.setActual(symbol_111);	
				symbol_879.getParameterSubstitutions().add(symbol_880);
			}
			symbol_284.getTemplateBindings().add(symbol_879);
		}
		symbol_284.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_284);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_285.setName("UniqueCollection");
		//symbol_285.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_285.setElementType(symbol_121);
		{
			TemplateBinding symbol_881 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_881.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_882 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_882.setFormal(symbol_147);	
				symbol_882.setActual(symbol_121);	
				symbol_881.getParameterSubstitutions().add(symbol_882);
			}
			symbol_285.getTemplateBindings().add(symbol_881);
		}
		symbol_285.getSuperClasses().add(symbol_170); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_285);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_286.setName("UniqueCollection");
		//symbol_286.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_286.setElementType(symbol_142);
		{
			TemplateBinding symbol_883 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_883.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_884 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_884.setFormal(symbol_147);	
				symbol_884.setActual(symbol_142);	
				symbol_883.getParameterSubstitutions().add(symbol_884);
			}
			symbol_286.getTemplateBindings().add(symbol_883);
		}
		symbol_286.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_286);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_287.setName("UniqueCollection");
		//symbol_287.setMoniker("ocl!UniqueCollection[ocl!UniqueCollection{T}?T]");
		symbol_287.setElementType(symbol_148);
		{
			TemplateBinding symbol_885 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_885.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_886 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_886.setFormal(symbol_147);	
				symbol_886.setActual(symbol_148);	
				symbol_885.getParameterSubstitutions().add(symbol_886);
			}
			symbol_287.getTemplateBindings().add(symbol_885);
		}
		symbol_287.getSuperClasses().add(symbol_181); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_287);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_288.setName("UniqueCollection");
		//symbol_288.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_288.setElementType(symbol_83);
		{
			TemplateBinding symbol_887 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_887.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_888 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_888.setFormal(symbol_147);	
				symbol_888.setActual(symbol_83);	
				symbol_887.getParameterSubstitutions().add(symbol_888);
			}
			symbol_288.getTemplateBindings().add(symbol_887);
		}
		symbol_288.getSuperClasses().add(symbol_190); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_288);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_289.setName("UniqueCollection");
		//symbol_289.setMoniker("ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_289.setElementType(symbol_157);
		{
			TemplateBinding symbol_889 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_889.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_890 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_890.setFormal(symbol_147);	
				symbol_890.setActual(symbol_157);	
				symbol_889.getParameterSubstitutions().add(symbol_890);
			}
			symbol_289.getTemplateBindings().add(symbol_889);
		}
		symbol_289.getSuperClasses().add(symbol_177); // ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_150.getOwnedTypes().add(symbol_289);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_290.setName("UniqueCollection");
		//symbol_290.setMoniker("ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_290.setElementType(symbol_22);
		{
			TemplateBinding symbol_891 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_891.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_892 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_892.setFormal(symbol_147);	
				symbol_892.setActual(symbol_22);	
				symbol_891.getParameterSubstitutions().add(symbol_892);
			}
			symbol_290.getTemplateBindings().add(symbol_891);
		}
		symbol_290.getSuperClasses().add(symbol_186); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_290);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_291.setName("UniqueCollection");
		//symbol_291.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_291.setElementType(symbol_69);
		{
			TemplateBinding symbol_893 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_893.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_894 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_894.setFormal(symbol_147);	
				symbol_894.setActual(symbol_69);	
				symbol_893.getParameterSubstitutions().add(symbol_894);
			}
			symbol_291.getTemplateBindings().add(symbol_893);
		}
		symbol_291.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_291);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_292.setName("UniqueCollection");
		//symbol_292.setMoniker("ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_292.setElementType(symbol_107);
		{
			TemplateBinding symbol_895 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_895.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_896 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_896.setFormal(symbol_147);	
				symbol_896.setActual(symbol_107);	
				symbol_895.getParameterSubstitutions().add(symbol_896);
			}
			symbol_292.getTemplateBindings().add(symbol_895);
		}
		symbol_292.getSuperClasses().add(symbol_192); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_292);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_293.setName("UniqueCollection");
		//symbol_293.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_293.setElementType(symbol_80);
		{
			TemplateBinding symbol_897 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_897.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_898 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_898.setFormal(symbol_147);	
				symbol_898.setActual(symbol_80);	
				symbol_897.getParameterSubstitutions().add(symbol_898);
			}
			symbol_293.getTemplateBindings().add(symbol_897);
		}
		symbol_293.getSuperClasses().add(symbol_168); // ocl!Collection[ocl!OclAny]
		symbol_150.getOwnedTypes().add(symbol_293);
		symbol_1.getNestedPackages().add(symbol_150);
		return symbol_1;
	}
}
