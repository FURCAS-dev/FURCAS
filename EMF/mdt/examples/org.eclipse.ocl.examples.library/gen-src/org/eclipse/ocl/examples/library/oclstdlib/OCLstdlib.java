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
 * $Id: OCLstdlib.java,v 1.18 2011/05/02 15:38:42 ewillink Exp $
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
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
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
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_216 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_217 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_218 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_219 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_220 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_221 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_222 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_223 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_224 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_225 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_226 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_227 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_228 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_229 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_230 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_231 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_232 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_233 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_234 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_235 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_236 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_237 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_238 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_239 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_240 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_241 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_242 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		CollectionType symbol_243 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_244 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_245 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		OrderedSetType symbol_246 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_247 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_248 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_249 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		OrderedSetType symbol_250 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		SequenceType symbol_251 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_252 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_253 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SequenceType symbol_254 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_255 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_256 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_257 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SetType symbol_258 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		SetType symbol_259 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_260 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_261 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_262 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		SetType symbol_263 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_264 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_265 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_266 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_267 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_268 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_269 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_270 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_271 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		TupleType symbol_272 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_273 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_274 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_275 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_276 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_277 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_278 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		CollectionType symbol_279 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_280 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_281 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_282 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_283 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_284 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_285 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_286 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_287 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		
		CollectionType symbol_288 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_289 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_290 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		

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
		symbol_12.getSuperClasses().add(symbol_235); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_214); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_291.setName("<>");
			//symbol_291.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_291.setType(symbol_19);  // Boolean
			
			Parameter symbol_292 = PivotFactory.eINSTANCE.createParameter();
			symbol_292.setName("object2");
			//symbol_292.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_292.setType(symbol_80);  // ocl!OclAny
			
			symbol_291.getOwnedParameters().add(symbol_292);
			symbol_291.setPrecedence(symbol_7);
			symbol_291.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_293 = PivotFactory.eINSTANCE.createOperation();
			symbol_293.setName("=");
			//symbol_293.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_293.setType(symbol_19);  // Boolean
			
			Parameter symbol_294 = PivotFactory.eINSTANCE.createParameter();
			symbol_294.setName("object2");
			//symbol_294.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_294.setType(symbol_80);  // ocl!OclAny
			
			symbol_293.getOwnedParameters().add(symbol_294);
			symbol_293.setPrecedence(symbol_7);
			symbol_293.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_295 = PivotFactory.eINSTANCE.createOperation();
			symbol_295.setName("excluding");
			//symbol_295.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_295.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("object");
			//symbol_296.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_296.setType(symbol_80);  // ocl!OclAny
			
			symbol_295.getOwnedParameters().add(symbol_296);
			symbol_295.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_295.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_295);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_297 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_297.setOwnedTemplateSignature(symbol_16);
			symbol_297.setName("flatten");
			//symbol_297.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_297.setType(symbol_153);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			
			symbol_297.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_297);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_298 = PivotFactory.eINSTANCE.createOperation();
			symbol_298.setName("including");
			//symbol_298.setMoniker("ocl!Bag{T}!including(T)");
			symbol_298.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("object");
			//symbol_299.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_299.setType(symbol_15);  // ocl!Bag{T}?T
			
			symbol_298.getOwnedParameters().add(symbol_299);
			symbol_298.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_298.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_298);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_300 = PivotFactory.eINSTANCE.createIteration();
			symbol_300.setName("reject");
			//symbol_300.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)");
			symbol_300.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_301 = PivotFactory.eINSTANCE.createParameter();
			symbol_301.setName("i");
			symbol_301.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_300.getOwnedIterators().add(symbol_301);
			Parameter symbol_302 = PivotFactory.eINSTANCE.createParameter();
			symbol_302.setName("body");
			//symbol_302.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_302.setType(symbol_205);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_300.getOwnedParameters().add(symbol_302);
			symbol_300.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_303 = PivotFactory.eINSTANCE.createIteration();
			symbol_303.setName("select");
			//symbol_303.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_303.setType(symbol_156);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("i");
			symbol_304.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_303.getOwnedIterators().add(symbol_304);
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("body");
			//symbol_305.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_305.setType(symbol_205);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_303.getOwnedParameters().add(symbol_305);
			symbol_303.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_303);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_306 = PivotFactory.eINSTANCE.createOperation();
			symbol_306.setName("<>");
			//symbol_306.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_306.setType(symbol_19);  // Boolean
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("object2");
			//symbol_307.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_307.setType(symbol_80);  // ocl!OclAny
			
			symbol_306.getOwnedParameters().add(symbol_307);
			symbol_306.setPrecedence(symbol_7);
			symbol_306.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_306.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_306);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_308 = PivotFactory.eINSTANCE.createOperation();
			symbol_308.setName("=");
			//symbol_308.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_308.setType(symbol_19);  // Boolean
			
			Parameter symbol_309 = PivotFactory.eINSTANCE.createParameter();
			symbol_309.setName("object2");
			//symbol_309.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_309.setType(symbol_80);  // ocl!OclAny
			
			symbol_308.getOwnedParameters().add(symbol_309);
			symbol_308.setPrecedence(symbol_7);
			symbol_308.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_308.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_308);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances{OclSelf}()
			Operation symbol_310 = PivotFactory.eINSTANCE.createOperation();
			symbol_22.setName("OclSelf");
			symbol_21.setOwnedParameteredElement(symbol_22);
			symbol_20.getOwnedParameters().add(symbol_21);
			
			symbol_310.setOwnedTemplateSignature(symbol_20);
			symbol_310.setName("allInstances");
			//symbol_310.setMoniker("Boolean!allInstances{OclSelf}()");
			symbol_310.setType(symbol_267);  // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
			
			symbol_310.setIsStatic(true);
			symbol_310.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation");
			symbol_310.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_310);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("and");
			//symbol_311.setMoniker("Boolean!and(Boolean)");
			symbol_311.setType(symbol_19);  // Boolean
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("b");
			//symbol_312.setMoniker("Boolean!and(Boolean)!b");
			symbol_312.setType(symbol_19);  // Boolean
			
			symbol_311.getOwnedParameters().add(symbol_312);
			symbol_311.setPrecedence(symbol_8);
			symbol_311.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanAndOperation");
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_313.setName("implies");
			//symbol_313.setMoniker("Boolean!implies(Boolean)");
			symbol_313.setType(symbol_19);  // Boolean
			
			Parameter symbol_314 = PivotFactory.eINSTANCE.createParameter();
			symbol_314.setName("b");
			//symbol_314.setMoniker("Boolean!implies(Boolean)!b");
			symbol_314.setType(symbol_19);  // Boolean
			
			symbol_313.getOwnedParameters().add(symbol_314);
			symbol_313.setPrecedence(symbol_11);
			symbol_313.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation");
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_313);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_315.setName("not");
			//symbol_315.setMoniker("Boolean!not()");
			symbol_315.setType(symbol_19);  // Boolean
			
			symbol_315.setPrecedence(symbol_3);
			symbol_315.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanNotOperation");
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("or");
			//symbol_316.setMoniker("Boolean!or(Boolean)");
			symbol_316.setType(symbol_19);  // Boolean
			
			Parameter symbol_317 = PivotFactory.eINSTANCE.createParameter();
			symbol_317.setName("b");
			//symbol_317.setMoniker("Boolean!or(Boolean)!b");
			symbol_317.setType(symbol_19);  // Boolean
			
			symbol_316.getOwnedParameters().add(symbol_317);
			symbol_316.setPrecedence(symbol_9);
			symbol_316.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanOrOperation");
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_318 = PivotFactory.eINSTANCE.createOperation();
			symbol_318.setName("toString");
			//symbol_318.setMoniker("Boolean!toString()");
			symbol_318.setType(symbol_143);  // String
			
			symbol_318.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_318.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_318);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_319 = PivotFactory.eINSTANCE.createOperation();
			symbol_319.setName("xor");
			//symbol_319.setMoniker("Boolean!xor(Boolean)");
			symbol_319.setType(symbol_19);  // Boolean
			
			Parameter symbol_320 = PivotFactory.eINSTANCE.createParameter();
			symbol_320.setName("b");
			//symbol_320.setMoniker("Boolean!xor(Boolean)!b");
			symbol_320.setType(symbol_19);  // Boolean
			
			symbol_319.getOwnedParameters().add(symbol_320);
			symbol_319.setPrecedence(symbol_10);
			symbol_319.setImplementationClass("org.eclipse.ocl.examples.library.logical.BooleanXorOperation");
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_319);
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
			Operation symbol_321 = PivotFactory.eINSTANCE.createOperation();
			symbol_29.setName("OclSelf");
			symbol_28.setOwnedParameteredElement(symbol_29);
			symbol_27.getOwnedParameters().add(symbol_28);
			
			symbol_321.setOwnedTemplateSignature(symbol_27);
			symbol_321.setName("allInstances");
			//symbol_321.setMoniker("ocl!Classifier{T}!allInstances{OclSelf}()");
			symbol_321.setType(symbol_265);  // ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
			
			symbol_321.setIsStatic(true);
			symbol_321.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation");
			symbol_321.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_321);
		}
		{	// ocl::Classifier::oclContainer() ocl!Classifier{T}!oclContainer{U}()
			Operation symbol_322 = PivotFactory.eINSTANCE.createOperation();
			symbol_32.setName("U");
			symbol_31.setOwnedParameteredElement(symbol_32);
			symbol_30.getOwnedParameters().add(symbol_31);
			
			symbol_322.setOwnedTemplateSignature(symbol_30);
			symbol_322.setName("oclContainer");
			//symbol_322.setMoniker("ocl!Classifier{T}!oclContainer{U}()");
			symbol_322.setType(symbol_159);  // ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]
			
			symbol_322.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation");
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::Classifier::oclContents() ocl!Classifier{T}!oclContents{U}()
			Operation symbol_323 = PivotFactory.eINSTANCE.createOperation();
			symbol_35.setName("U");
			symbol_34.setOwnedParameteredElement(symbol_35);
			symbol_33.getOwnedParameters().add(symbol_34);
			
			symbol_323.setOwnedTemplateSignature(symbol_33);
			symbol_323.setName("oclContents");
			//symbol_323.setMoniker("ocl!Classifier{T}!oclContents{U}()");
			symbol_323.setType(symbol_262);  // ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
			
			symbol_323.setImplementationClass("org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation");
			symbol_323.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_323);
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
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_324.setName("<>");
			//symbol_324.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_324.setType(symbol_19);  // Boolean
			
			Parameter symbol_325 = PivotFactory.eINSTANCE.createParameter();
			symbol_325.setName("object2");
			//symbol_325.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_325.setType(symbol_80);  // ocl!OclAny
			
			symbol_324.getOwnedParameters().add(symbol_325);
			symbol_324.setPrecedence(symbol_7);
			symbol_324.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_326.setName("=");
			//symbol_326.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_326.setType(symbol_19);  // Boolean
			
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("object2");
			//symbol_327.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_327.setType(symbol_80);  // ocl!OclAny
			
			symbol_326.getOwnedParameters().add(symbol_327);
			symbol_326.setPrecedence(symbol_7);
			symbol_326.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_328 = PivotFactory.eINSTANCE.createIteration();
			symbol_328.setName("any");
			//symbol_328.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_328.setType(symbol_39);  // ocl!Collection{T}?T
			
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("i");
			symbol_329.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_328.getOwnedIterators().add(symbol_329);
			Parameter symbol_330 = PivotFactory.eINSTANCE.createParameter();
			symbol_330.setName("body");
			//symbol_330.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_330.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_328.getOwnedParameters().add(symbol_330);
			symbol_328.setImplementationClass("org.eclipse.ocl.examples.library.iterator.AnyIteration");
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_331 = PivotFactory.eINSTANCE.createOperation();
			symbol_331.setName("asBag");
			//symbol_331.setMoniker("ocl!Collection{T}!asBag()");
			symbol_331.setType(symbol_155);  // ocl!Bag[ocl!Collection{T}?T]
			
			symbol_331.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation");
			symbol_331.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_331);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_332 = PivotFactory.eINSTANCE.createOperation();
			symbol_332.setName("asOrderedSet");
			//symbol_332.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_332.setType(symbol_249);  // ocl!OrderedSet[ocl!Collection{T}?T]
			
			symbol_332.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation");
			symbol_332.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_332);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_333 = PivotFactory.eINSTANCE.createOperation();
			symbol_333.setName("asSequence");
			//symbol_333.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_333.setType(symbol_255);  // ocl!Sequence[ocl!Collection{T}?T]
			
			symbol_333.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation");
			symbol_333.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_333);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_334 = PivotFactory.eINSTANCE.createOperation();
			symbol_334.setName("asSet");
			//symbol_334.setMoniker("ocl!Collection{T}!asSet()");
			symbol_334.setType(symbol_271);  // ocl!Set[ocl!Collection{T}?T]
			
			symbol_334.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation");
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_335 = PivotFactory.eINSTANCE.createIteration();
			symbol_42.setName("V");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_335.setOwnedTemplateSignature(symbol_40);
			symbol_335.setName("collect");
			//symbol_335.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_335.setType(symbol_170);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_336 = PivotFactory.eINSTANCE.createParameter();
			symbol_336.setName("i");
			symbol_336.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_335.getOwnedIterators().add(symbol_336);
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("body");
			//symbol_337.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_337.setType(symbol_201);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_335.getOwnedParameters().add(symbol_337);
			symbol_335.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_335.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_335);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_338 = PivotFactory.eINSTANCE.createIteration();
			symbol_45.setName("V");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_338.setOwnedTemplateSignature(symbol_43);
			symbol_338.setName("collectNested");
			//symbol_338.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_338.setType(symbol_172);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("i");
			symbol_339.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_338.getOwnedIterators().add(symbol_339);
			Parameter symbol_340 = PivotFactory.eINSTANCE.createParameter();
			symbol_340.setName("body");
			//symbol_340.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_340.setType(symbol_200);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_338.getOwnedParameters().add(symbol_340);
			symbol_338.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("count");
			//symbol_341.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_341.setType(symbol_65);  // Integer
			
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("object");
			//symbol_342.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_342.setType(symbol_80);  // ocl!OclAny
			
			symbol_341.getOwnedParameters().add(symbol_342);
			symbol_341.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionCountOperation");
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_343 = PivotFactory.eINSTANCE.createOperation();
			symbol_343.setName("excludes");
			//symbol_343.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_343.setType(symbol_19);  // Boolean
			
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("object");
			//symbol_344.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_344.setType(symbol_80);  // ocl!OclAny
			
			symbol_343.getOwnedParameters().add(symbol_344);
			symbol_343.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation");
			symbol_343.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_343);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_345 = PivotFactory.eINSTANCE.createOperation();
			symbol_48.setName("T2");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_345.setOwnedTemplateSignature(symbol_46);
			symbol_345.setName("excludesAll");
			//symbol_345.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_345.setType(symbol_19);  // Boolean
			
			Parameter symbol_346 = PivotFactory.eINSTANCE.createParameter();
			symbol_346.setName("c2");
			//symbol_346.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_346.setType(symbol_171);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_345.getOwnedParameters().add(symbol_346);
			symbol_345.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation");
			symbol_345.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_345);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_347 = PivotFactory.eINSTANCE.createOperation();
			symbol_347.setName("excluding");
			//symbol_347.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_347.setType(symbol_172);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_348 = PivotFactory.eINSTANCE.createParameter();
			symbol_348.setName("object");
			//symbol_348.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_348.setType(symbol_80);  // ocl!OclAny
			
			symbol_347.getOwnedParameters().add(symbol_348);
			symbol_347.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_347.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_347);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_349 = PivotFactory.eINSTANCE.createIteration();
			symbol_349.setName("exists");
			//symbol_349.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_349.setType(symbol_19);  // Boolean
			
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("i");
			symbol_350.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_349.getOwnedIterators().add(symbol_350);
			Parameter symbol_351 = PivotFactory.eINSTANCE.createParameter();
			symbol_351.setName("body");
			//symbol_351.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_351.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_349.getOwnedParameters().add(symbol_351);
			symbol_349.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_349.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_349);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_352 = PivotFactory.eINSTANCE.createIteration();
			symbol_352.setName("exists");
			//symbol_352.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_352.setType(symbol_19);  // Boolean
			
			Parameter symbol_353 = PivotFactory.eINSTANCE.createParameter();
			symbol_353.setName("j");
			symbol_353.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_352.getOwnedIterators().add(symbol_353);
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("i");
			symbol_354.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_352.getOwnedIterators().add(symbol_354);
			Parameter symbol_355 = PivotFactory.eINSTANCE.createParameter();
			symbol_355.setName("body");
			//symbol_355.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_355.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_352.getOwnedParameters().add(symbol_355);
			symbol_352.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ExistsIteration");
			symbol_352.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_352);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_356 = PivotFactory.eINSTANCE.createOperation();
			symbol_51.setName("T2");
			symbol_50.setOwnedParameteredElement(symbol_51);
			symbol_49.getOwnedParameters().add(symbol_50);
			
			symbol_356.setOwnedTemplateSignature(symbol_49);
			symbol_356.setName("flatten");
			//symbol_356.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_356.setType(symbol_183);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			
			symbol_356.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_356.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_356);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_357 = PivotFactory.eINSTANCE.createIteration();
			symbol_357.setName("forAll");
			//symbol_357.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_357.setType(symbol_19);  // Boolean
			
			Parameter symbol_358 = PivotFactory.eINSTANCE.createParameter();
			symbol_358.setName("i");
			symbol_358.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_357.getOwnedIterators().add(symbol_358);
			Parameter symbol_359 = PivotFactory.eINSTANCE.createParameter();
			symbol_359.setName("body");
			//symbol_359.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_359.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_357.getOwnedParameters().add(symbol_359);
			symbol_357.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_357.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_357);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_360 = PivotFactory.eINSTANCE.createIteration();
			symbol_360.setName("forAll");
			//symbol_360.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_360.setType(symbol_19);  // Boolean
			
			Parameter symbol_361 = PivotFactory.eINSTANCE.createParameter();
			symbol_361.setName("j");
			symbol_361.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_360.getOwnedIterators().add(symbol_361);
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("i");
			symbol_362.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_360.getOwnedIterators().add(symbol_362);
			Parameter symbol_363 = PivotFactory.eINSTANCE.createParameter();
			symbol_363.setName("body");
			//symbol_363.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_363.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_360.getOwnedParameters().add(symbol_363);
			symbol_360.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ForAllIteration");
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("includes");
			//symbol_364.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_364.setType(symbol_19);  // Boolean
			
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("object");
			//symbol_365.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_365.setType(symbol_80);  // ocl!OclAny
			
			symbol_364.getOwnedParameters().add(symbol_365);
			symbol_364.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation");
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_364);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_54.setName("T2");
			symbol_53.setOwnedParameteredElement(symbol_54);
			symbol_52.getOwnedParameters().add(symbol_53);
			
			symbol_366.setOwnedTemplateSignature(symbol_52);
			symbol_366.setName("includesAll");
			//symbol_366.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_366.setType(symbol_19);  // Boolean
			
			Parameter symbol_367 = PivotFactory.eINSTANCE.createParameter();
			symbol_367.setName("c2");
			//symbol_367.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_367.setType(symbol_189);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_366.getOwnedParameters().add(symbol_367);
			symbol_366.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation");
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_366);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_368 = PivotFactory.eINSTANCE.createOperation();
			symbol_368.setName("including");
			//symbol_368.setMoniker("ocl!Collection{T}!including(T)");
			symbol_368.setType(symbol_172);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_369 = PivotFactory.eINSTANCE.createParameter();
			symbol_369.setName("object");
			//symbol_369.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_369.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_368.getOwnedParameters().add(symbol_369);
			symbol_368.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_368.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_368);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_370.setName("isEmpty");
			//symbol_370.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_370.setType(symbol_19);  // Boolean
			
			symbol_370.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation");
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_370);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)
			Iteration symbol_371 = PivotFactory.eINSTANCE.createIteration();
			symbol_371.setName("isUnique");
			//symbol_371.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)");
			symbol_371.setType(symbol_19);  // Boolean
			
			Parameter symbol_372 = PivotFactory.eINSTANCE.createParameter();
			symbol_372.setName("i");
			symbol_372.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_371.getOwnedIterators().add(symbol_372);
			Parameter symbol_373 = PivotFactory.eINSTANCE.createParameter();
			symbol_373.setName("body");
			//symbol_373.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)!body");
			symbol_373.setType(symbol_203);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_371.getOwnedParameters().add(symbol_373);
			symbol_371.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IsUniqueIteration");
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_374 = PivotFactory.eINSTANCE.createIteration();
			symbol_57.setName("Tacc");
			symbol_56.setOwnedParameteredElement(symbol_57);
			symbol_55.getOwnedParameters().add(symbol_56);
			
			symbol_374.setOwnedTemplateSignature(symbol_55);
			symbol_374.setName("iterate");
			//symbol_374.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_374.setType(symbol_57);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_375 = PivotFactory.eINSTANCE.createParameter();
			symbol_375.setName("i");
			symbol_375.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_374.getOwnedIterators().add(symbol_375);
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("acc");
			symbol_376.setType(symbol_57);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_374.getOwnedAccumulators().add(symbol_376);
			symbol_374.setImplementationClass("org.eclipse.ocl.examples.library.iterator.IterateIteration");
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_377.setName("max");
			//symbol_377.setMoniker("ocl!Collection{T}!max()");
			symbol_377.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_377.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMaxOperation");
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_378 = PivotFactory.eINSTANCE.createOperation();
			symbol_378.setName("min");
			//symbol_378.setMoniker("ocl!Collection{T}!min()");
			symbol_378.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_378.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionMinOperation");
			symbol_378.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_378);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("notEmpty");
			//symbol_379.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_379.setType(symbol_19);  // Boolean
			
			symbol_379.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation");
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_380 = PivotFactory.eINSTANCE.createIteration();
			symbol_380.setName("one");
			//symbol_380.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_380.setType(symbol_19);  // Boolean
			
			Parameter symbol_381 = PivotFactory.eINSTANCE.createParameter();
			symbol_381.setName("i");
			symbol_381.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_380.getOwnedIterators().add(symbol_381);
			Parameter symbol_382 = PivotFactory.eINSTANCE.createParameter();
			symbol_382.setName("body");
			//symbol_382.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_382.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_380.getOwnedParameters().add(symbol_382);
			symbol_380.setImplementationClass("org.eclipse.ocl.examples.library.iterator.OneIteration");
			symbol_380.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_380);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_60.setName("T2");
			symbol_59.setOwnedParameteredElement(symbol_60);
			symbol_58.getOwnedParameters().add(symbol_59);
			
			symbol_383.setOwnedTemplateSignature(symbol_58);
			symbol_383.setName("product");
			//symbol_383.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_383.setType(symbol_258);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			
			Parameter symbol_384 = PivotFactory.eINSTANCE.createParameter();
			symbol_384.setName("c2");
			//symbol_384.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_384.setType(symbol_193);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			
			symbol_383.getOwnedParameters().add(symbol_384);
			symbol_383.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionProductOperation");
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_383);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_385 = PivotFactory.eINSTANCE.createIteration();
			symbol_385.setName("reject");
			//symbol_385.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_385.setType(symbol_172);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_386 = PivotFactory.eINSTANCE.createParameter();
			symbol_386.setName("i");
			symbol_386.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_385.getOwnedIterators().add(symbol_386);
			Parameter symbol_387 = PivotFactory.eINSTANCE.createParameter();
			symbol_387.setName("body");
			//symbol_387.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_387.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_385.getOwnedParameters().add(symbol_387);
			symbol_385.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_385.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_385);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_388 = PivotFactory.eINSTANCE.createIteration();
			symbol_388.setName("select");
			//symbol_388.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_388.setType(symbol_172);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_389 = PivotFactory.eINSTANCE.createParameter();
			symbol_389.setName("i");
			symbol_389.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_388.getOwnedIterators().add(symbol_389);
			Parameter symbol_390 = PivotFactory.eINSTANCE.createParameter();
			symbol_390.setName("body");
			//symbol_390.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_390.setType(symbol_207);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_388.getOwnedParameters().add(symbol_390);
			symbol_388.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_388.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_388);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_391 = PivotFactory.eINSTANCE.createOperation();
			symbol_391.setName("size");
			//symbol_391.setMoniker("ocl!Collection{T}!size()");
			symbol_391.setType(symbol_65);  // Integer
			
			symbol_391.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSizeOperation");
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_392 = PivotFactory.eINSTANCE.createIteration();
			symbol_392.setName("sortedBy");
			//symbol_392.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_392.setType(symbol_237);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_393 = PivotFactory.eINSTANCE.createParameter();
			symbol_393.setName("i");
			symbol_393.setType(symbol_39);  // ocl!Collection{T}?T
			symbol_392.getOwnedIterators().add(symbol_393);
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("body");
			//symbol_394.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_394.setType(symbol_203);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_392.getOwnedParameters().add(symbol_394);
			symbol_392.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_392.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_392);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_395 = PivotFactory.eINSTANCE.createOperation();
			symbol_395.setName("sum");
			//symbol_395.setMoniker("ocl!Collection{T}!sum()");
			symbol_395.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_395.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionSumOperation");
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_36.getOwnedOperations().add(symbol_395);
		}
		symbol_1.getOwnedTypes().add(symbol_36);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_61.setName("Enumeration");
		//symbol_61.setMoniker("ocl!Enumeration");
		symbol_61.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances{OclSelf}()
			Operation symbol_396 = PivotFactory.eINSTANCE.createOperation();
			symbol_64.setName("OclSelf");
			symbol_63.setOwnedParameteredElement(symbol_64);
			symbol_62.getOwnedParameters().add(symbol_63);
			
			symbol_396.setOwnedTemplateSignature(symbol_62);
			symbol_396.setName("allInstances");
			//symbol_396.setMoniker("ocl!Enumeration!allInstances{OclSelf}()");
			symbol_396.setType(symbol_260);  // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
			
			symbol_396.setIsStatic(true);
			symbol_396.setImplementationClass("org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation");
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_61.getOwnedOperations().add(symbol_396);
		}
		symbol_1.getOwnedTypes().add(symbol_61);
		//
		// ocl::Integer Integer
		//
		symbol_65.setName("Integer");
		//symbol_65.setMoniker("Integer");
		symbol_65.getSuperClasses().add(symbol_125); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_397 = PivotFactory.eINSTANCE.createOperation();
			symbol_397.setName("*");
			//symbol_397.setMoniker("Integer!*(Integer)");
			symbol_397.setType(symbol_65);  // Integer
			
			Parameter symbol_398 = PivotFactory.eINSTANCE.createParameter();
			symbol_398.setName("i");
			//symbol_398.setMoniker("Integer!*(Integer)!i");
			symbol_398.setType(symbol_65);  // Integer
			
			symbol_397.getOwnedParameters().add(symbol_398);
			symbol_397.setPrecedence(symbol_4);
			symbol_397.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_397.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_397);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("+");
			//symbol_399.setMoniker("Integer!+(Integer)");
			symbol_399.setType(symbol_65);  // Integer
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("i");
			//symbol_400.setMoniker("Integer!+(Integer)!i");
			symbol_400.setType(symbol_65);  // Integer
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setPrecedence(symbol_5);
			symbol_399.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericPlusOperation");
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_399);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("-");
			//symbol_401.setMoniker("Integer!-()");
			symbol_401.setType(symbol_65);  // Integer
			
			symbol_401.setPrecedence(symbol_3);
			symbol_401.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_402 = PivotFactory.eINSTANCE.createOperation();
			symbol_402.setName("-");
			//symbol_402.setMoniker("Integer!-(Integer)");
			symbol_402.setType(symbol_65);  // Integer
			
			Parameter symbol_403 = PivotFactory.eINSTANCE.createParameter();
			symbol_403.setName("i");
			//symbol_403.setMoniker("Integer!-(Integer)!i");
			symbol_403.setType(symbol_65);  // Integer
			
			symbol_402.getOwnedParameters().add(symbol_403);
			symbol_402.setPrecedence(symbol_5);
			symbol_402.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinusOperation");
			symbol_402.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_402);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_404 = PivotFactory.eINSTANCE.createOperation();
			symbol_404.setName("/");
			//symbol_404.setMoniker("Integer!/(Integer)");
			symbol_404.setType(symbol_125);  // Real
			
			Parameter symbol_405 = PivotFactory.eINSTANCE.createParameter();
			symbol_405.setName("i");
			//symbol_405.setMoniker("Integer!/(Integer)!i");
			symbol_405.setType(symbol_65);  // Integer
			
			symbol_404.getOwnedParameters().add(symbol_405);
			symbol_404.setPrecedence(symbol_4);
			symbol_404.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_404.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_404);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_406.setName("abs");
			//symbol_406.setMoniker("Integer!abs()");
			symbol_406.setType(symbol_65);  // Integer
			
			symbol_406.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_407 = PivotFactory.eINSTANCE.createOperation();
			symbol_407.setName("div");
			//symbol_407.setMoniker("Integer!div(Integer)");
			symbol_407.setType(symbol_65);  // Integer
			
			Parameter symbol_408 = PivotFactory.eINSTANCE.createParameter();
			symbol_408.setName("i");
			//symbol_408.setMoniker("Integer!div(Integer)!i");
			symbol_408.setType(symbol_65);  // Integer
			
			symbol_407.getOwnedParameters().add(symbol_408);
			symbol_407.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivOperation");
			symbol_407.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_407);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_409.setName("max");
			//symbol_409.setMoniker("Integer!max(Integer)");
			symbol_409.setType(symbol_65);  // Integer
			
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("i");
			//symbol_410.setMoniker("Integer!max(Integer)!i");
			symbol_410.setType(symbol_65);  // Integer
			
			symbol_409.getOwnedParameters().add(symbol_410);
			symbol_409.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_411.setName("min");
			//symbol_411.setMoniker("Integer!min(Integer)");
			symbol_411.setType(symbol_65);  // Integer
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("i");
			//symbol_412.setMoniker("Integer!min(Integer)!i");
			symbol_412.setType(symbol_65);  // Integer
			
			symbol_411.getOwnedParameters().add(symbol_412);
			symbol_411.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_413 = PivotFactory.eINSTANCE.createOperation();
			symbol_413.setName("mod");
			//symbol_413.setMoniker("Integer!mod(Integer)");
			symbol_413.setType(symbol_65);  // Integer
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("i");
			//symbol_414.setMoniker("Integer!mod(Integer)!i");
			symbol_414.setType(symbol_65);  // Integer
			
			symbol_413.getOwnedParameters().add(symbol_414);
			symbol_413.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericModOperation");
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_415 = PivotFactory.eINSTANCE.createOperation();
			symbol_415.setName("toString");
			//symbol_415.setMoniker("Integer!toString()");
			symbol_415.setType(symbol_143);  // String
			
			symbol_415.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_415.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_415);
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
		symbol_66.getSuperClasses().add(symbol_186); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])
			Iteration symbol_416 = PivotFactory.eINSTANCE.createIteration();
			symbol_416.setName("closure");
			//symbol_416.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])");
			symbol_416.setType(symbol_266);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("i");
			symbol_417.setType(symbol_69);  // ocl!NonOrderedCollection{T}?T
			symbol_416.getOwnedIterators().add(symbol_417);
			Parameter symbol_418 = PivotFactory.eINSTANCE.createParameter();
			symbol_418.setName("body");
			//symbol_418.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])!body");
			symbol_418.setType(symbol_197);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
			
			symbol_416.getOwnedParameters().add(symbol_418);
			symbol_416.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_419 = PivotFactory.eINSTANCE.createIteration();
			symbol_72.setName("V");
			symbol_71.setOwnedParameteredElement(symbol_72);
			symbol_70.getOwnedParameters().add(symbol_71);
			
			symbol_419.setOwnedTemplateSignature(symbol_70);
			symbol_419.setName("collect");
			//symbol_419.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_419.setType(symbol_154);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_420 = PivotFactory.eINSTANCE.createParameter();
			symbol_420.setName("i");
			symbol_420.setType(symbol_69);  // ocl!NonOrderedCollection{T}?T
			symbol_419.getOwnedIterators().add(symbol_420);
			Parameter symbol_421 = PivotFactory.eINSTANCE.createParameter();
			symbol_421.setName("body");
			//symbol_421.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_421.setType(symbol_204);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_419.getOwnedParameters().add(symbol_421);
			symbol_419.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_422 = PivotFactory.eINSTANCE.createIteration();
			symbol_75.setName("V");
			symbol_74.setOwnedParameteredElement(symbol_75);
			symbol_73.getOwnedParameters().add(symbol_74);
			
			symbol_422.setOwnedTemplateSignature(symbol_73);
			symbol_422.setName("collectNested");
			//symbol_422.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_422.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_423 = PivotFactory.eINSTANCE.createParameter();
			symbol_423.setName("i");
			symbol_423.setType(symbol_69);  // ocl!NonOrderedCollection{T}?T
			symbol_422.getOwnedIterators().add(symbol_423);
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("body");
			//symbol_424.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_424.setType(symbol_196);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_422.getOwnedParameters().add(symbol_424);
			symbol_422.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_422);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_425 = PivotFactory.eINSTANCE.createOperation();
			symbol_425.setName("intersection");
			//symbol_425.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_425.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_426 = PivotFactory.eINSTANCE.createParameter();
			symbol_426.setName("bag");
			//symbol_426.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_426.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_425.getOwnedParameters().add(symbol_426);
			symbol_425.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_425);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_427 = PivotFactory.eINSTANCE.createOperation();
			symbol_427.setName("intersection");
			//symbol_427.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_427.setType(symbol_266);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_428 = PivotFactory.eINSTANCE.createParameter();
			symbol_428.setName("s");
			//symbol_428.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_428.setType(symbol_266);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_427.getOwnedParameters().add(symbol_428);
			symbol_427.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_429 = PivotFactory.eINSTANCE.createOperation();
			symbol_429.setName("union");
			//symbol_429.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_429.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_430 = PivotFactory.eINSTANCE.createParameter();
			symbol_430.setName("bag");
			//symbol_430.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_430.setType(symbol_152);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_429.getOwnedParameters().add(symbol_430);
			symbol_429.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_429.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_429);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_431 = PivotFactory.eINSTANCE.createOperation();
			symbol_431.setName("union");
			//symbol_431.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_431.setType(symbol_266);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_432 = PivotFactory.eINSTANCE.createParameter();
			symbol_432.setName("s");
			//symbol_432.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_432.setType(symbol_266);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_431.getOwnedParameters().add(symbol_432);
			symbol_431.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_431.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_431);
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
		symbol_76.getSuperClasses().add(symbol_174); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_433 = PivotFactory.eINSTANCE.createIteration();
			symbol_433.setName("sortedBy");
			//symbol_433.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_433.setType(symbol_251);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_434 = PivotFactory.eINSTANCE.createParameter();
			symbol_434.setName("i");
			symbol_434.setType(symbol_79);  // ocl!NonUniqueCollection{T}?T
			symbol_433.getOwnedIterators().add(symbol_434);
			Parameter symbol_435 = PivotFactory.eINSTANCE.createParameter();
			symbol_435.setName("body");
			//symbol_435.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_435.setType(symbol_194);  // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
			
			symbol_433.getOwnedParameters().add(symbol_435);
			symbol_433.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_433.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_433);
		}
		symbol_1.getOwnedTypes().add(symbol_76);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_80.setName("OclAny");
		//symbol_80.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_436 = PivotFactory.eINSTANCE.createOperation();
			symbol_436.setName("<>");
			//symbol_436.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_436.setType(symbol_19);  // Boolean
			
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("object2");
			//symbol_437.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_437.setType(symbol_80);  // ocl!OclAny
			
			symbol_436.getOwnedParameters().add(symbol_437);
			symbol_436.setPrecedence(symbol_7);
			symbol_436.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_436.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_436);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("=");
			//symbol_438.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_438.setType(symbol_19);  // Boolean
			
			Parameter symbol_439 = PivotFactory.eINSTANCE.createParameter();
			symbol_439.setName("object2");
			//symbol_439.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_439.setType(symbol_80);  // ocl!OclAny
			
			symbol_438.getOwnedParameters().add(symbol_439);
			symbol_438.setPrecedence(symbol_7);
			symbol_438.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_83.setName("OclSelf");
			symbol_82.setOwnedParameteredElement(symbol_83);
			symbol_81.getOwnedParameters().add(symbol_82);
			
			symbol_440.setOwnedTemplateSignature(symbol_81);
			symbol_440.setName("oclAsSet");
			//symbol_440.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_440.setType(symbol_259);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			
			symbol_440.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation");
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])
			Operation symbol_441 = PivotFactory.eINSTANCE.createOperation();
			symbol_86.setName("TT");
			symbol_85.setOwnedParameteredElement(symbol_86);
			symbol_84.getOwnedParameters().add(symbol_85);
			
			symbol_441.setOwnedTemplateSignature(symbol_84);
			symbol_441.setName("oclAsType");
			//symbol_441.setMoniker("ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])");
			symbol_441.setType(symbol_86);  // ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT
			
			Parameter symbol_442 = PivotFactory.eINSTANCE.createParameter();
			symbol_442.setName("type");
			//symbol_442.setMoniker("ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])!type");
			symbol_442.setType(symbol_161);  // ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]
			
			symbol_441.getOwnedParameters().add(symbol_442);
			symbol_441.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation");
			symbol_441.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_441);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_443 = PivotFactory.eINSTANCE.createOperation();
			symbol_443.setName("oclIsInState");
			//symbol_443.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_443.setType(symbol_19);  // Boolean
			
			Parameter symbol_444 = PivotFactory.eINSTANCE.createParameter();
			symbol_444.setName("statespec");
			//symbol_444.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_444.setType(symbol_102);  // ocl!OclState
			
			symbol_443.getOwnedParameters().add(symbol_444);
			symbol_443.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation");
			symbol_443.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_443);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("oclIsInvalid");
			//symbol_445.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_445.setType(symbol_19);  // Boolean
			
			symbol_445.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation");
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])
			Operation symbol_446 = PivotFactory.eINSTANCE.createOperation();
			symbol_89.setName("T");
			symbol_88.setOwnedParameteredElement(symbol_89);
			symbol_87.getOwnedParameters().add(symbol_88);
			
			symbol_446.setOwnedTemplateSignature(symbol_87);
			symbol_446.setName("oclIsKindOf");
			//symbol_446.setMoniker("ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])");
			symbol_446.setType(symbol_19);  // Boolean
			
			Parameter symbol_447 = PivotFactory.eINSTANCE.createParameter();
			symbol_447.setName("type");
			//symbol_447.setMoniker("ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])!type");
			symbol_447.setType(symbol_162);  // ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
			
			symbol_446.getOwnedParameters().add(symbol_447);
			symbol_446.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation");
			symbol_446.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_446);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_448 = PivotFactory.eINSTANCE.createOperation();
			symbol_448.setName("oclIsNew");
			//symbol_448.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_448.setType(symbol_19);  // Boolean
			
			symbol_448.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_448.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_448);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])
			Operation symbol_449 = PivotFactory.eINSTANCE.createOperation();
			symbol_92.setName("T");
			symbol_91.setOwnedParameteredElement(symbol_92);
			symbol_90.getOwnedParameters().add(symbol_91);
			
			symbol_449.setOwnedTemplateSignature(symbol_90);
			symbol_449.setName("oclIsTypeOf");
			//symbol_449.setMoniker("ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])");
			symbol_449.setType(symbol_19);  // Boolean
			
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("type");
			//symbol_450.setMoniker("ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])!type");
			symbol_450.setType(symbol_163);  // ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
			
			symbol_449.getOwnedParameters().add(symbol_450);
			symbol_449.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation");
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_449);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_451 = PivotFactory.eINSTANCE.createOperation();
			symbol_451.setName("oclIsUndefined");
			//symbol_451.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_451.setType(symbol_19);  // Boolean
			
			symbol_451.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation");
			symbol_451.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_451);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType{OclSelf}()
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_95.setName("OclSelf");
			symbol_94.setOwnedParameteredElement(symbol_95);
			symbol_93.getOwnedParameters().add(symbol_94);
			
			symbol_452.setOwnedTemplateSignature(symbol_93);
			symbol_452.setName("oclType");
			//symbol_452.setMoniker("ocl!OclAny!oclType{OclSelf}()");
			symbol_452.setType(symbol_160);  // ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
			
			symbol_452.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation");
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_80.getOwnedOperations().add(symbol_452);
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
			Operation symbol_453 = PivotFactory.eINSTANCE.createOperation();
			symbol_453.setName("<>");
			//symbol_453.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_453.setType(symbol_19);  // Boolean
			
			Parameter symbol_454 = PivotFactory.eINSTANCE.createParameter();
			symbol_454.setName("object2");
			//symbol_454.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_454.setType(symbol_80);  // ocl!OclAny
			
			symbol_453.getOwnedParameters().add(symbol_454);
			symbol_453.setPrecedence(symbol_7);
			symbol_453.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_453.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_453);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_455 = PivotFactory.eINSTANCE.createOperation();
			symbol_455.setName("=");
			//symbol_455.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_455.setType(symbol_19);  // Boolean
			
			Parameter symbol_456 = PivotFactory.eINSTANCE.createParameter();
			symbol_456.setName("object2");
			//symbol_456.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_456.setType(symbol_80);  // ocl!OclAny
			
			symbol_455.getOwnedParameters().add(symbol_456);
			symbol_455.setPrecedence(symbol_7);
			symbol_455.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_455);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances{OclSelf}()
			Operation symbol_457 = PivotFactory.eINSTANCE.createOperation();
			symbol_100.setName("OclSelf");
			symbol_99.setOwnedParameteredElement(symbol_100);
			symbol_98.getOwnedParameters().add(symbol_99);
			
			symbol_457.setOwnedTemplateSignature(symbol_98);
			symbol_457.setName("allInstances");
			//symbol_457.setMoniker("ocl!OclInvalid!allInstances{OclSelf}()");
			symbol_457.setType(symbol_269);  // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
			
			symbol_457.setIsStatic(true);
			symbol_457.setImplementationClass("org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation");
			symbol_457.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_457);
		}
		{	// ocl::OclInvalid::oclBadOperation() ocl!OclInvalid!oclBadOperation()
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("oclBadOperation");
			//symbol_458.setMoniker("ocl!OclInvalid!oclBadOperation()");
			symbol_458.setType(symbol_96);  // ocl!OclInvalid
			
			symbol_96.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_459 = PivotFactory.eINSTANCE.createOperation();
			symbol_459.setName("toString");
			//symbol_459.setMoniker("ocl!OclInvalid!toString()");
			symbol_459.setType(symbol_143);  // String
			
			symbol_459.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_459.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_96.getOwnedOperations().add(symbol_459);
		}
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_101.setName("OclMessage");
		//symbol_101.setMoniker("ocl!OclMessage");
		symbol_101.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("hasReturned");
			//symbol_460.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_460.setType(symbol_19);  // Boolean
			
			symbol_460.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_461 = PivotFactory.eINSTANCE.createOperation();
			symbol_461.setName("isOperationCall");
			//symbol_461.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_461.setType(symbol_19);  // Boolean
			
			symbol_461.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_461.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_461);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("isSignalSent");
			//symbol_462.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_462.setType(symbol_19);  // Boolean
			
			symbol_462.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_463 = PivotFactory.eINSTANCE.createOperation();
			symbol_463.setName("result");
			//symbol_463.setMoniker("ocl!OclMessage!result()");
			symbol_463.setType(symbol_80);  // ocl!OclAny
			
			symbol_463.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation");
			symbol_463.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_463);
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
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("<>");
			//symbol_464.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_464.setType(symbol_19);  // Boolean
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("object2");
			//symbol_465.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_465.setType(symbol_80);  // ocl!OclAny
			
			symbol_464.getOwnedParameters().add(symbol_465);
			symbol_464.setPrecedence(symbol_7);
			symbol_464.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_466.setName("=");
			//symbol_466.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_466.setType(symbol_19);  // Boolean
			
			Parameter symbol_467 = PivotFactory.eINSTANCE.createParameter();
			symbol_467.setName("object2");
			//symbol_467.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_467.setType(symbol_80);  // ocl!OclAny
			
			symbol_466.getOwnedParameters().add(symbol_467);
			symbol_466.setPrecedence(symbol_7);
			symbol_466.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_103.getOwnedOperations().add(symbol_466);
		}
		symbol_1.getOwnedTypes().add(symbol_103);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_104.setName("OclVoid");
		//symbol_104.setMoniker("ocl!OclVoid");
		symbol_104.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_468 = PivotFactory.eINSTANCE.createOperation();
			symbol_468.setName("<>");
			//symbol_468.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_468.setType(symbol_19);  // Boolean
			
			Parameter symbol_469 = PivotFactory.eINSTANCE.createParameter();
			symbol_469.setName("object2");
			//symbol_469.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_469.setType(symbol_80);  // ocl!OclAny
			
			symbol_468.getOwnedParameters().add(symbol_469);
			symbol_468.setPrecedence(symbol_7);
			symbol_468.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_468.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_468);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_470 = PivotFactory.eINSTANCE.createOperation();
			symbol_470.setName("=");
			//symbol_470.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_470.setType(symbol_19);  // Boolean
			
			Parameter symbol_471 = PivotFactory.eINSTANCE.createParameter();
			symbol_471.setName("object2");
			//symbol_471.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_471.setType(symbol_80);  // ocl!OclAny
			
			symbol_470.getOwnedParameters().add(symbol_471);
			symbol_470.setPrecedence(symbol_7);
			symbol_470.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_470.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_470);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances{OclSelf}()
			Operation symbol_472 = PivotFactory.eINSTANCE.createOperation();
			symbol_107.setName("OclSelf");
			symbol_106.setOwnedParameteredElement(symbol_107);
			symbol_105.getOwnedParameters().add(symbol_106);
			
			symbol_472.setOwnedTemplateSignature(symbol_105);
			symbol_472.setName("allInstances");
			//symbol_472.setMoniker("ocl!OclVoid!allInstances{OclSelf}()");
			symbol_472.setType(symbol_264);  // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
			
			symbol_472.setIsStatic(true);
			symbol_472.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation");
			symbol_472.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_472);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName("and");
			//symbol_473.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_473.setType(symbol_19);  // Boolean
			
			Parameter symbol_474 = PivotFactory.eINSTANCE.createParameter();
			symbol_474.setName("b");
			//symbol_474.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_474.setType(symbol_19);  // Boolean
			
			symbol_473.getOwnedParameters().add(symbol_474);
			symbol_473.setPrecedence(symbol_8);
			symbol_473.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation");
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_473);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_475 = PivotFactory.eINSTANCE.createOperation();
			symbol_475.setName("implies");
			//symbol_475.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_475.setType(symbol_19);  // Boolean
			
			Parameter symbol_476 = PivotFactory.eINSTANCE.createParameter();
			symbol_476.setName("b");
			//symbol_476.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_476.setType(symbol_19);  // Boolean
			
			symbol_475.getOwnedParameters().add(symbol_476);
			symbol_475.setPrecedence(symbol_11);
			symbol_475.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation");
			symbol_475.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_475);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_477 = PivotFactory.eINSTANCE.createOperation();
			symbol_477.setName("or");
			//symbol_477.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_477.setType(symbol_19);  // Boolean
			
			Parameter symbol_478 = PivotFactory.eINSTANCE.createParameter();
			symbol_478.setName("b");
			//symbol_478.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_478.setType(symbol_19);  // Boolean
			
			symbol_477.getOwnedParameters().add(symbol_478);
			symbol_477.setPrecedence(symbol_9);
			symbol_477.setImplementationClass("org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation");
			symbol_477.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_477);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_479 = PivotFactory.eINSTANCE.createOperation();
			symbol_479.setName("toString");
			//symbol_479.setMoniker("ocl!OclVoid!toString()");
			symbol_479.setType(symbol_143);  // String
			
			symbol_479.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_479.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_104.getOwnedOperations().add(symbol_479);
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
		symbol_108.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_480 = PivotFactory.eINSTANCE.createOperation();
			symbol_480.setName("at");
			//symbol_480.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_480.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("index");
			//symbol_481.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_481.setType(symbol_65);  // Integer
			
			symbol_480.getOwnedParameters().add(symbol_481);
			symbol_480.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation");
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])
			Iteration symbol_482 = PivotFactory.eINSTANCE.createIteration();
			symbol_482.setName("closure");
			//symbol_482.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])");
			symbol_482.setType(symbol_247);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_483 = PivotFactory.eINSTANCE.createParameter();
			symbol_483.setName("i");
			symbol_483.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			symbol_482.getOwnedIterators().add(symbol_483);
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("body");
			//symbol_484.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])!body");
			symbol_484.setType(symbol_195);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
			
			symbol_482.getOwnedParameters().add(symbol_484);
			symbol_482.setImplementationClass("org.eclipse.ocl.examples.library.iterator.ClosureIteration");
			symbol_482.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_482);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_485 = PivotFactory.eINSTANCE.createIteration();
			symbol_114.setName("V");
			symbol_113.setOwnedParameteredElement(symbol_114);
			symbol_112.getOwnedParameters().add(symbol_113);
			
			symbol_485.setOwnedTemplateSignature(symbol_112);
			symbol_485.setName("collect");
			//symbol_485.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_485.setType(symbol_257);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_486 = PivotFactory.eINSTANCE.createParameter();
			symbol_486.setName("i");
			symbol_486.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			symbol_485.getOwnedIterators().add(symbol_486);
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("body");
			//symbol_487.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_487.setType(symbol_206);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_485.getOwnedParameters().add(symbol_487);
			symbol_485.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectIteration");
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_488 = PivotFactory.eINSTANCE.createIteration();
			symbol_117.setName("V");
			symbol_116.setOwnedParameteredElement(symbol_117);
			symbol_115.getOwnedParameters().add(symbol_116);
			
			symbol_488.setOwnedTemplateSignature(symbol_115);
			symbol_488.setName("collectNested");
			//symbol_488.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_488.setType(symbol_256);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_489 = PivotFactory.eINSTANCE.createParameter();
			symbol_489.setName("i");
			symbol_489.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			symbol_488.getOwnedIterators().add(symbol_489);
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("body");
			//symbol_490.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_490.setType(symbol_209);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_488.getOwnedParameters().add(symbol_490);
			symbol_488.setImplementationClass("org.eclipse.ocl.examples.library.iterator.CollectNestedIteration");
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_491 = PivotFactory.eINSTANCE.createOperation();
			symbol_491.setName("first");
			//symbol_491.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_491.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			
			symbol_491.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation");
			symbol_491.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_491);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_492 = PivotFactory.eINSTANCE.createOperation();
			symbol_492.setName("indexOf");
			//symbol_492.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_492.setType(symbol_65);  // Integer
			
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("obj");
			//symbol_493.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_493.setType(symbol_80);  // ocl!OclAny
			
			symbol_492.getOwnedParameters().add(symbol_493);
			symbol_492.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation");
			symbol_492.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_492);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_494 = PivotFactory.eINSTANCE.createOperation();
			symbol_494.setName("last");
			//symbol_494.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_494.setType(symbol_111);  // ocl!OrderedCollection{T}?T
			
			symbol_494.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation");
			symbol_494.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_494);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("reverse");
			//symbol_495.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_495.setType(symbol_243);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			
			symbol_495.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_108.getOwnedOperations().add(symbol_495);
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
		symbol_118.getSuperClasses().add(symbol_241); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_118.getSuperClasses().add(symbol_284); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_496 = PivotFactory.eINSTANCE.createOperation();
			symbol_496.setName("-");
			//symbol_496.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_496.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_497 = PivotFactory.eINSTANCE.createParameter();
			symbol_497.setName("s");
			//symbol_497.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_497.setType(symbol_263);  // ocl!Set[ocl!OclAny]
			
			symbol_496.getOwnedParameters().add(symbol_497);
			symbol_496.setPrecedence(symbol_5);
			symbol_496.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_496.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_496);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("<>");
			//symbol_498.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_498.setType(symbol_19);  // Boolean
			
			Parameter symbol_499 = PivotFactory.eINSTANCE.createParameter();
			symbol_499.setName("object2");
			//symbol_499.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_499.setType(symbol_80);  // ocl!OclAny
			
			symbol_498.getOwnedParameters().add(symbol_499);
			symbol_498.setPrecedence(symbol_7);
			symbol_498.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_500 = PivotFactory.eINSTANCE.createOperation();
			symbol_500.setName("=");
			//symbol_500.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_500.setType(symbol_19);  // Boolean
			
			Parameter symbol_501 = PivotFactory.eINSTANCE.createParameter();
			symbol_501.setName("object2");
			//symbol_501.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_501.setType(symbol_80);  // ocl!OclAny
			
			symbol_500.getOwnedParameters().add(symbol_501);
			symbol_500.setPrecedence(symbol_7);
			symbol_500.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_500.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_500);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_502 = PivotFactory.eINSTANCE.createOperation();
			symbol_502.setName("append");
			//symbol_502.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_502.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_503 = PivotFactory.eINSTANCE.createParameter();
			symbol_503.setName("object");
			//symbol_503.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_503.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_502.getOwnedParameters().add(symbol_503);
			symbol_502.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_502.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_502);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_504 = PivotFactory.eINSTANCE.createOperation();
			symbol_504.setName("excluding");
			//symbol_504.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_504.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_505 = PivotFactory.eINSTANCE.createParameter();
			symbol_505.setName("object");
			//symbol_505.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_505.setType(symbol_80);  // ocl!OclAny
			
			symbol_504.getOwnedParameters().add(symbol_505);
			symbol_504.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_504.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_504);
		}
		{	// ocl::OrderedSet::flatten() ocl!OrderedSet{T}!flatten{T2}()
			Operation symbol_506 = PivotFactory.eINSTANCE.createOperation();
			symbol_124.setName("T2");
			symbol_123.setOwnedParameteredElement(symbol_124);
			symbol_122.getOwnedParameters().add(symbol_123);
			
			symbol_506.setOwnedTemplateSignature(symbol_122);
			symbol_506.setName("flatten");
			//symbol_506.setMoniker("ocl!OrderedSet{T}!flatten{T2}()");
			symbol_506.setType(symbol_250);  // ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
			
			symbol_506.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_506.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_506);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_507 = PivotFactory.eINSTANCE.createOperation();
			symbol_507.setName("including");
			//symbol_507.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_507.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_508 = PivotFactory.eINSTANCE.createParameter();
			symbol_508.setName("object");
			//symbol_508.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_508.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_507.getOwnedParameters().add(symbol_508);
			symbol_507.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_507.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_507);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_509 = PivotFactory.eINSTANCE.createOperation();
			symbol_509.setName("insertAt");
			//symbol_509.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_509.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_510 = PivotFactory.eINSTANCE.createParameter();
			symbol_510.setName("index");
			//symbol_510.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_510.setType(symbol_65);  // Integer
			
			symbol_509.getOwnedParameters().add(symbol_510);
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("object");
			//symbol_511.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_511.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_509.getOwnedParameters().add(symbol_511);
			symbol_509.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_509.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_509);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("intersection");
			//symbol_512.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_512.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_513 = PivotFactory.eINSTANCE.createParameter();
			symbol_513.setName("o");
			//symbol_513.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_513.setType(symbol_270);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_512.getOwnedParameters().add(symbol_513);
			symbol_512.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_512);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_514 = PivotFactory.eINSTANCE.createOperation();
			symbol_514.setName("prepend");
			//symbol_514.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_514.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_515 = PivotFactory.eINSTANCE.createParameter();
			symbol_515.setName("object");
			//symbol_515.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_515.setType(symbol_121);  // ocl!OrderedSet{T}?T
			
			symbol_514.getOwnedParameters().add(symbol_515);
			symbol_514.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_516 = PivotFactory.eINSTANCE.createIteration();
			symbol_516.setName("reject");
			//symbol_516.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_516.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_517 = PivotFactory.eINSTANCE.createParameter();
			symbol_517.setName("i");
			symbol_517.setType(symbol_121);  // ocl!OrderedSet{T}?T
			symbol_516.getOwnedIterators().add(symbol_517);
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("body");
			//symbol_518.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_518.setType(symbol_199);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_516.getOwnedParameters().add(symbol_518);
			symbol_516.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_516.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_516);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_519 = PivotFactory.eINSTANCE.createOperation();
			symbol_519.setName("reverse");
			//symbol_519.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_519.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_519.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_520 = PivotFactory.eINSTANCE.createIteration();
			symbol_520.setName("select");
			//symbol_520.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_520.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_521 = PivotFactory.eINSTANCE.createParameter();
			symbol_521.setName("i");
			symbol_521.setType(symbol_121);  // ocl!OrderedSet{T}?T
			symbol_520.getOwnedIterators().add(symbol_521);
			Parameter symbol_522 = PivotFactory.eINSTANCE.createParameter();
			symbol_522.setName("body");
			//symbol_522.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_522.setType(symbol_199);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_520.getOwnedParameters().add(symbol_522);
			symbol_520.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_523 = PivotFactory.eINSTANCE.createOperation();
			symbol_523.setName("subOrderedSet");
			//symbol_523.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_523.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_524 = PivotFactory.eINSTANCE.createParameter();
			symbol_524.setName("lower");
			//symbol_524.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_524.setType(symbol_65);  // Integer
			
			symbol_523.getOwnedParameters().add(symbol_524);
			Parameter symbol_525 = PivotFactory.eINSTANCE.createParameter();
			symbol_525.setName("upper");
			//symbol_525.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_525.setType(symbol_65);  // Integer
			
			symbol_523.getOwnedParameters().add(symbol_525);
			symbol_523.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation");
			symbol_523.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_523);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_526 = PivotFactory.eINSTANCE.createOperation();
			symbol_526.setName("symmetricDifference");
			//symbol_526.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_526.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("s");
			//symbol_527.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_527.setType(symbol_263);  // ocl!Set[ocl!OclAny]
			
			symbol_526.getOwnedParameters().add(symbol_527);
			symbol_526.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_526);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_528 = PivotFactory.eINSTANCE.createOperation();
			symbol_528.setName("union");
			//symbol_528.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_528.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_529 = PivotFactory.eINSTANCE.createParameter();
			symbol_529.setName("o");
			//symbol_529.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_529.setType(symbol_248);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_528.getOwnedParameters().add(symbol_529);
			symbol_528.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_528.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_528);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_530 = PivotFactory.eINSTANCE.createOperation();
			symbol_530.setName("union");
			//symbol_530.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_530.setType(symbol_270);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			Parameter symbol_531 = PivotFactory.eINSTANCE.createParameter();
			symbol_531.setName("s");
			//symbol_531.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_531.setType(symbol_270);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_530.getOwnedParameters().add(symbol_531);
			symbol_530.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_530.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_118.getOwnedOperations().add(symbol_530);
		}
		symbol_1.getOwnedTypes().add(symbol_118);
		//
		// ocl::Real Real
		//
		symbol_125.setName("Real");
		//symbol_125.setMoniker("Real");
		symbol_125.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_532 = PivotFactory.eINSTANCE.createOperation();
			symbol_532.setName("*");
			//symbol_532.setMoniker("Real!*(Real)");
			symbol_532.setType(symbol_125);  // Real
			
			Parameter symbol_533 = PivotFactory.eINSTANCE.createParameter();
			symbol_533.setName("r");
			//symbol_533.setMoniker("Real!*(Real)!r");
			symbol_533.setType(symbol_125);  // Real
			
			symbol_532.getOwnedParameters().add(symbol_533);
			symbol_532.setPrecedence(symbol_4);
			symbol_532.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericTimesOperation");
			symbol_532.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_532);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_534 = PivotFactory.eINSTANCE.createOperation();
			symbol_534.setName("+");
			//symbol_534.setMoniker("Real!+(Real)");
			symbol_534.setType(symbol_125);  // Real
			
			Parameter symbol_535 = PivotFactory.eINSTANCE.createParameter();
			symbol_535.setName("r");
			//symbol_535.setMoniker("Real!+(Real)!r");
			symbol_535.setType(symbol_125);  // Real
			
			symbol_534.getOwnedParameters().add(symbol_535);
			symbol_534.setPrecedence(symbol_5);
			symbol_534.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericPlusOperation");
			symbol_534.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_534);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_536 = PivotFactory.eINSTANCE.createOperation();
			symbol_536.setName("-");
			//symbol_536.setMoniker("Real!-(Real)");
			symbol_536.setType(symbol_125);  // Real
			
			Parameter symbol_537 = PivotFactory.eINSTANCE.createParameter();
			symbol_537.setName("r");
			//symbol_537.setMoniker("Real!-(Real)!r");
			symbol_537.setType(symbol_125);  // Real
			
			symbol_536.getOwnedParameters().add(symbol_537);
			symbol_536.setPrecedence(symbol_5);
			symbol_536.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinusOperation");
			symbol_536.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_536);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_538 = PivotFactory.eINSTANCE.createOperation();
			symbol_538.setName("-");
			//symbol_538.setMoniker("Real!-()");
			symbol_538.setType(symbol_125);  // Real
			
			symbol_538.setPrecedence(symbol_3);
			symbol_538.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericNegateOperation");
			symbol_538.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_538);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_539 = PivotFactory.eINSTANCE.createOperation();
			symbol_539.setName("/");
			//symbol_539.setMoniker("Real!/(Real)");
			symbol_539.setType(symbol_125);  // Real
			
			Parameter symbol_540 = PivotFactory.eINSTANCE.createParameter();
			symbol_540.setName("r");
			//symbol_540.setMoniker("Real!/(Real)!r");
			symbol_540.setType(symbol_125);  // Real
			
			symbol_539.getOwnedParameters().add(symbol_540);
			symbol_539.setPrecedence(symbol_4);
			symbol_539.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericDivideOperation");
			symbol_539.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_539);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("<");
			//symbol_541.setMoniker("Real!<(Real)");
			symbol_541.setType(symbol_19);  // Boolean
			
			Parameter symbol_542 = PivotFactory.eINSTANCE.createParameter();
			symbol_542.setName("r");
			//symbol_542.setMoniker("Real!<(Real)!r");
			symbol_542.setType(symbol_125);  // Real
			
			symbol_541.getOwnedParameters().add(symbol_542);
			symbol_541.setPrecedence(symbol_6);
			symbol_541.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation");
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_543 = PivotFactory.eINSTANCE.createOperation();
			symbol_543.setName("<=");
			//symbol_543.setMoniker("Real!<=(Real)");
			symbol_543.setType(symbol_19);  // Boolean
			
			Parameter symbol_544 = PivotFactory.eINSTANCE.createParameter();
			symbol_544.setName("r");
			//symbol_544.setMoniker("Real!<=(Real)!r");
			symbol_544.setType(symbol_125);  // Real
			
			symbol_543.getOwnedParameters().add(symbol_544);
			symbol_543.setPrecedence(symbol_6);
			symbol_543.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation");
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_543);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_545 = PivotFactory.eINSTANCE.createOperation();
			symbol_545.setName("<>");
			//symbol_545.setMoniker("Real!<>(ocl!OclAny)");
			symbol_545.setType(symbol_19);  // Boolean
			
			Parameter symbol_546 = PivotFactory.eINSTANCE.createParameter();
			symbol_546.setName("object2");
			//symbol_546.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_546.setType(symbol_80);  // ocl!OclAny
			
			symbol_545.getOwnedParameters().add(symbol_546);
			symbol_545.setPrecedence(symbol_7);
			symbol_545.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_545.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_545);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_547 = PivotFactory.eINSTANCE.createOperation();
			symbol_547.setName("=");
			//symbol_547.setMoniker("Real!=(ocl!OclAny)");
			symbol_547.setType(symbol_19);  // Boolean
			
			Parameter symbol_548 = PivotFactory.eINSTANCE.createParameter();
			symbol_548.setName("object2");
			//symbol_548.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_548.setType(symbol_80);  // ocl!OclAny
			
			symbol_547.getOwnedParameters().add(symbol_548);
			symbol_547.setPrecedence(symbol_7);
			symbol_547.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_547.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_547);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_549 = PivotFactory.eINSTANCE.createOperation();
			symbol_549.setName(">");
			//symbol_549.setMoniker("Real!>(Real)");
			symbol_549.setType(symbol_19);  // Boolean
			
			Parameter symbol_550 = PivotFactory.eINSTANCE.createParameter();
			symbol_550.setName("r");
			//symbol_550.setMoniker("Real!>(Real)!r");
			symbol_550.setType(symbol_125);  // Real
			
			symbol_549.getOwnedParameters().add(symbol_550);
			symbol_549.setPrecedence(symbol_6);
			symbol_549.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation");
			symbol_549.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_549);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_551 = PivotFactory.eINSTANCE.createOperation();
			symbol_551.setName(">=");
			//symbol_551.setMoniker("Real!>=(Real)");
			symbol_551.setType(symbol_19);  // Boolean
			
			Parameter symbol_552 = PivotFactory.eINSTANCE.createParameter();
			symbol_552.setName("r");
			//symbol_552.setMoniker("Real!>=(Real)!r");
			symbol_552.setType(symbol_125);  // Real
			
			symbol_551.getOwnedParameters().add(symbol_552);
			symbol_551.setPrecedence(symbol_6);
			symbol_551.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation");
			symbol_551.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_551);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_553 = PivotFactory.eINSTANCE.createOperation();
			symbol_553.setName("abs");
			//symbol_553.setMoniker("Real!abs()");
			symbol_553.setType(symbol_125);  // Real
			
			symbol_553.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericAbsOperation");
			symbol_553.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_553);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_554 = PivotFactory.eINSTANCE.createOperation();
			symbol_554.setName("floor");
			//symbol_554.setMoniker("Real!floor()");
			symbol_554.setType(symbol_65);  // Integer
			
			symbol_554.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericFloorOperation");
			symbol_554.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_554);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("max");
			//symbol_555.setMoniker("Real!max(Real)");
			symbol_555.setType(symbol_125);  // Real
			
			Parameter symbol_556 = PivotFactory.eINSTANCE.createParameter();
			symbol_556.setName("r");
			//symbol_556.setMoniker("Real!max(Real)!r");
			symbol_556.setType(symbol_125);  // Real
			
			symbol_555.getOwnedParameters().add(symbol_556);
			symbol_555.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMaxOperation");
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_555);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_557 = PivotFactory.eINSTANCE.createOperation();
			symbol_557.setName("min");
			//symbol_557.setMoniker("Real!min(Real)");
			symbol_557.setType(symbol_125);  // Real
			
			Parameter symbol_558 = PivotFactory.eINSTANCE.createParameter();
			symbol_558.setName("r");
			//symbol_558.setMoniker("Real!min(Real)!r");
			symbol_558.setType(symbol_125);  // Real
			
			symbol_557.getOwnedParameters().add(symbol_558);
			symbol_557.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericMinOperation");
			symbol_557.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_557);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{TT}(ocl!Classifier[TT])
			Operation symbol_559 = PivotFactory.eINSTANCE.createOperation();
			symbol_128.setName("TT");
			symbol_127.setOwnedParameteredElement(symbol_128);
			symbol_126.getOwnedParameters().add(symbol_127);
			
			symbol_559.setOwnedTemplateSignature(symbol_126);
			symbol_559.setName("oclAsType");
			//symbol_559.setMoniker("Real!oclAsType{TT}(ocl!Classifier[TT])");
			symbol_559.setType(symbol_128);  // Real!oclAsType{TT}(ocl!Classifier[TT])?TT
			
			Parameter symbol_560 = PivotFactory.eINSTANCE.createParameter();
			symbol_560.setName("type");
			//symbol_560.setMoniker("Real!oclAsType{TT}(ocl!Classifier[TT])!type");
			symbol_560.setType(symbol_158);  // ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]
			
			symbol_559.getOwnedParameters().add(symbol_560);
			symbol_559.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation");
			symbol_559.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_559);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_561 = PivotFactory.eINSTANCE.createOperation();
			symbol_561.setName("round");
			//symbol_561.setMoniker("Real!round()");
			symbol_561.setType(symbol_65);  // Integer
			
			symbol_561.setImplementationClass("org.eclipse.ocl.examples.library.numeric.NumericRoundOperation");
			symbol_561.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_561);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_562 = PivotFactory.eINSTANCE.createOperation();
			symbol_562.setName("toString");
			//symbol_562.setMoniker("Real!toString()");
			symbol_562.setType(symbol_143);  // String
			
			symbol_562.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_562.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_125.getOwnedOperations().add(symbol_562);
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
		symbol_129.getSuperClasses().add(symbol_239); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_129.getSuperClasses().add(symbol_226); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_563 = PivotFactory.eINSTANCE.createOperation();
			symbol_563.setName("<>");
			//symbol_563.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_563.setType(symbol_19);  // Boolean
			
			Parameter symbol_564 = PivotFactory.eINSTANCE.createParameter();
			symbol_564.setName("object2");
			//symbol_564.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_564.setType(symbol_80);  // ocl!OclAny
			
			symbol_563.getOwnedParameters().add(symbol_564);
			symbol_563.setPrecedence(symbol_7);
			symbol_563.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_563.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_563);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_565 = PivotFactory.eINSTANCE.createOperation();
			symbol_565.setName("=");
			//symbol_565.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_565.setType(symbol_19);  // Boolean
			
			Parameter symbol_566 = PivotFactory.eINSTANCE.createParameter();
			symbol_566.setName("object2");
			//symbol_566.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_566.setType(symbol_80);  // ocl!OclAny
			
			symbol_565.getOwnedParameters().add(symbol_566);
			symbol_565.setPrecedence(symbol_7);
			symbol_565.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_565.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_565);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_567 = PivotFactory.eINSTANCE.createOperation();
			symbol_567.setName("append");
			//symbol_567.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_567.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_568 = PivotFactory.eINSTANCE.createParameter();
			symbol_568.setName("object");
			//symbol_568.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_568.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_567.getOwnedParameters().add(symbol_568);
			symbol_567.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation");
			symbol_567.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_567);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_569 = PivotFactory.eINSTANCE.createOperation();
			symbol_569.setName("excluding");
			//symbol_569.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_569.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_570 = PivotFactory.eINSTANCE.createParameter();
			symbol_570.setName("object");
			//symbol_570.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_570.setType(symbol_80);  // ocl!OclAny
			
			symbol_569.getOwnedParameters().add(symbol_570);
			symbol_569.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_569.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_569);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_571 = PivotFactory.eINSTANCE.createOperation();
			symbol_135.setName("T2");
			symbol_134.setOwnedParameteredElement(symbol_135);
			symbol_133.getOwnedParameters().add(symbol_134);
			
			symbol_571.setOwnedTemplateSignature(symbol_133);
			symbol_571.setName("flatten");
			//symbol_571.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_571.setType(symbol_252);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			
			symbol_571.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_571.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_571);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_572 = PivotFactory.eINSTANCE.createOperation();
			symbol_572.setName("including");
			//symbol_572.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_572.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_573 = PivotFactory.eINSTANCE.createParameter();
			symbol_573.setName("object");
			//symbol_573.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_573.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_572.getOwnedParameters().add(symbol_573);
			symbol_572.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_572.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_572);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_574 = PivotFactory.eINSTANCE.createOperation();
			symbol_574.setName("insertAt");
			//symbol_574.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_574.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_575 = PivotFactory.eINSTANCE.createParameter();
			symbol_575.setName("index");
			//symbol_575.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_575.setType(symbol_65);  // Integer
			
			symbol_574.getOwnedParameters().add(symbol_575);
			Parameter symbol_576 = PivotFactory.eINSTANCE.createParameter();
			symbol_576.setName("object");
			//symbol_576.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_576.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_574.getOwnedParameters().add(symbol_576);
			symbol_574.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation");
			symbol_574.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_574);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_577 = PivotFactory.eINSTANCE.createOperation();
			symbol_577.setName("prepend");
			//symbol_577.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_577.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_578 = PivotFactory.eINSTANCE.createParameter();
			symbol_578.setName("object");
			//symbol_578.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_578.setType(symbol_132);  // ocl!Sequence{T}?T
			
			symbol_577.getOwnedParameters().add(symbol_578);
			symbol_577.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation");
			symbol_577.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_577);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_579 = PivotFactory.eINSTANCE.createIteration();
			symbol_579.setName("reject");
			//symbol_579.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_579.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_580 = PivotFactory.eINSTANCE.createParameter();
			symbol_580.setName("i");
			symbol_580.setType(symbol_132);  // ocl!Sequence{T}?T
			symbol_579.getOwnedIterators().add(symbol_580);
			Parameter symbol_581 = PivotFactory.eINSTANCE.createParameter();
			symbol_581.setName("body");
			//symbol_581.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_581.setType(symbol_202);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_579.getOwnedParameters().add(symbol_581);
			symbol_579.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_579.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_579);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_582 = PivotFactory.eINSTANCE.createOperation();
			symbol_582.setName("reverse");
			//symbol_582.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_582.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_582.setImplementationClass("org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation");
			symbol_582.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_582);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_583 = PivotFactory.eINSTANCE.createIteration();
			symbol_583.setName("select");
			//symbol_583.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_583.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_584 = PivotFactory.eINSTANCE.createParameter();
			symbol_584.setName("i");
			symbol_584.setType(symbol_132);  // ocl!Sequence{T}?T
			symbol_583.getOwnedIterators().add(symbol_584);
			Parameter symbol_585 = PivotFactory.eINSTANCE.createParameter();
			symbol_585.setName("body");
			//symbol_585.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_585.setType(symbol_202);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_583.getOwnedParameters().add(symbol_585);
			symbol_583.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_583.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_583);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_586 = PivotFactory.eINSTANCE.createOperation();
			symbol_586.setName("subSequence");
			//symbol_586.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_586.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_587 = PivotFactory.eINSTANCE.createParameter();
			symbol_587.setName("lower");
			//symbol_587.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_587.setType(symbol_65);  // Integer
			
			symbol_586.getOwnedParameters().add(symbol_587);
			Parameter symbol_588 = PivotFactory.eINSTANCE.createParameter();
			symbol_588.setName("upper");
			//symbol_588.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_588.setType(symbol_65);  // Integer
			
			symbol_586.getOwnedParameters().add(symbol_588);
			symbol_586.setImplementationClass("org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation");
			symbol_586.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_586);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_589 = PivotFactory.eINSTANCE.createOperation();
			symbol_589.setName("union");
			//symbol_589.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_589.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_590 = PivotFactory.eINSTANCE.createParameter();
			symbol_590.setName("s");
			//symbol_590.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_590.setType(symbol_254);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_589.getOwnedParameters().add(symbol_590);
			symbol_589.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionUnionOperation");
			symbol_589.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_129.getOwnedOperations().add(symbol_589);
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
		symbol_136.getSuperClasses().add(symbol_281); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_136.getSuperClasses().add(symbol_211); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_591 = PivotFactory.eINSTANCE.createOperation();
			symbol_591.setName("-");
			//symbol_591.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_591.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_592 = PivotFactory.eINSTANCE.createParameter();
			symbol_592.setName("s");
			//symbol_592.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_592.setType(symbol_263);  // ocl!Set[ocl!OclAny]
			
			symbol_591.getOwnedParameters().add(symbol_592);
			symbol_591.setPrecedence(symbol_5);
			symbol_591.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetMinusOperation");
			symbol_591.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_591);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_593 = PivotFactory.eINSTANCE.createOperation();
			symbol_593.setName("<>");
			//symbol_593.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_593.setType(symbol_19);  // Boolean
			
			Parameter symbol_594 = PivotFactory.eINSTANCE.createParameter();
			symbol_594.setName("object2");
			//symbol_594.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_594.setType(symbol_80);  // ocl!OclAny
			
			symbol_593.getOwnedParameters().add(symbol_594);
			symbol_593.setPrecedence(symbol_7);
			symbol_593.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_593.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_593);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_595 = PivotFactory.eINSTANCE.createOperation();
			symbol_595.setName("=");
			//symbol_595.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_595.setType(symbol_19);  // Boolean
			
			Parameter symbol_596 = PivotFactory.eINSTANCE.createParameter();
			symbol_596.setName("object2");
			//symbol_596.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_596.setType(symbol_80);  // ocl!OclAny
			
			symbol_595.getOwnedParameters().add(symbol_596);
			symbol_595.setPrecedence(symbol_7);
			symbol_595.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_595.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_595);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_597 = PivotFactory.eINSTANCE.createOperation();
			symbol_597.setName("excluding");
			//symbol_597.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_597.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_598 = PivotFactory.eINSTANCE.createParameter();
			symbol_598.setName("object");
			//symbol_598.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_598.setType(symbol_80);  // ocl!OclAny
			
			symbol_597.getOwnedParameters().add(symbol_598);
			symbol_597.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation");
			symbol_597.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_597);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_599 = PivotFactory.eINSTANCE.createOperation();
			symbol_142.setName("T2");
			symbol_141.setOwnedParameteredElement(symbol_142);
			symbol_140.getOwnedParameters().add(symbol_141);
			
			symbol_599.setOwnedTemplateSignature(symbol_140);
			symbol_599.setName("flatten");
			//symbol_599.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_599.setType(symbol_261);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			
			symbol_599.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation");
			symbol_599.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_599);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_600 = PivotFactory.eINSTANCE.createOperation();
			symbol_600.setName("including");
			//symbol_600.setMoniker("ocl!Set{T}!including(T)");
			symbol_600.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_601 = PivotFactory.eINSTANCE.createParameter();
			symbol_601.setName("object");
			//symbol_601.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_601.setType(symbol_139);  // ocl!Set{T}?T
			
			symbol_600.getOwnedParameters().add(symbol_601);
			symbol_600.setImplementationClass("org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation");
			symbol_600.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_600);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_602 = PivotFactory.eINSTANCE.createOperation();
			symbol_602.setName("intersection");
			//symbol_602.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_602.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_603 = PivotFactory.eINSTANCE.createParameter();
			symbol_603.setName("s");
			//symbol_603.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_603.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			symbol_602.getOwnedParameters().add(symbol_603);
			symbol_602.setImplementationClass("org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation");
			symbol_602.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_602);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_604 = PivotFactory.eINSTANCE.createIteration();
			symbol_604.setName("reject");
			//symbol_604.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_604.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_605 = PivotFactory.eINSTANCE.createParameter();
			symbol_605.setName("i");
			symbol_605.setType(symbol_139);  // ocl!Set{T}?T
			symbol_604.getOwnedIterators().add(symbol_605);
			Parameter symbol_606 = PivotFactory.eINSTANCE.createParameter();
			symbol_606.setName("body");
			//symbol_606.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_606.setType(symbol_198);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_604.getOwnedParameters().add(symbol_606);
			symbol_604.setImplementationClass("org.eclipse.ocl.examples.library.iterator.RejectIteration");
			symbol_604.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_604);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_607 = PivotFactory.eINSTANCE.createIteration();
			symbol_607.setName("select");
			//symbol_607.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_607.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_608 = PivotFactory.eINSTANCE.createParameter();
			symbol_608.setName("i");
			symbol_608.setType(symbol_139);  // ocl!Set{T}?T
			symbol_607.getOwnedIterators().add(symbol_608);
			Parameter symbol_609 = PivotFactory.eINSTANCE.createParameter();
			symbol_609.setName("body");
			//symbol_609.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_609.setType(symbol_198);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_607.getOwnedParameters().add(symbol_609);
			symbol_607.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SelectIteration");
			symbol_607.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_607);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_610 = PivotFactory.eINSTANCE.createOperation();
			symbol_610.setName("symmetricDifference");
			//symbol_610.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_610.setType(symbol_268);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_611 = PivotFactory.eINSTANCE.createParameter();
			symbol_611.setName("s");
			//symbol_611.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_611.setType(symbol_263);  // ocl!Set[ocl!OclAny]
			
			symbol_610.getOwnedParameters().add(symbol_611);
			symbol_610.setImplementationClass("org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation");
			symbol_610.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_136.getOwnedOperations().add(symbol_610);
		}
		symbol_1.getOwnedTypes().add(symbol_136);
		//
		// ocl::String String
		//
		symbol_143.setName("String");
		//symbol_143.setMoniker("String");
		symbol_143.getSuperClasses().add(symbol_80); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_612 = PivotFactory.eINSTANCE.createOperation();
			symbol_612.setName("+");
			//symbol_612.setMoniker("String!+(String)");
			symbol_612.setType(symbol_143);  // String
			
			Parameter symbol_613 = PivotFactory.eINSTANCE.createParameter();
			symbol_613.setName("s");
			//symbol_613.setMoniker("String!+(String)!s");
			symbol_613.setType(symbol_143);  // String
			
			symbol_612.getOwnedParameters().add(symbol_613);
			symbol_612.setPrecedence(symbol_5);
			symbol_612.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_612.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_612);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_614 = PivotFactory.eINSTANCE.createOperation();
			symbol_614.setName("<");
			//symbol_614.setMoniker("String!<(String)");
			symbol_614.setType(symbol_19);  // Boolean
			
			Parameter symbol_615 = PivotFactory.eINSTANCE.createParameter();
			symbol_615.setName("s");
			//symbol_615.setMoniker("String!<(String)!s");
			symbol_615.setType(symbol_143);  // String
			
			symbol_614.getOwnedParameters().add(symbol_615);
			symbol_614.setPrecedence(symbol_6);
			symbol_614.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanOperation");
			symbol_614.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_614);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_616 = PivotFactory.eINSTANCE.createOperation();
			symbol_616.setName("<=");
			//symbol_616.setMoniker("String!<=(String)");
			symbol_616.setType(symbol_19);  // Boolean
			
			Parameter symbol_617 = PivotFactory.eINSTANCE.createParameter();
			symbol_617.setName("s");
			//symbol_617.setMoniker("String!<=(String)!s");
			symbol_617.setType(symbol_143);  // String
			
			symbol_616.getOwnedParameters().add(symbol_617);
			symbol_616.setPrecedence(symbol_6);
			symbol_616.setImplementationClass("org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation");
			symbol_616.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_616);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_618 = PivotFactory.eINSTANCE.createOperation();
			symbol_618.setName("<>");
			//symbol_618.setMoniker("String!<>(ocl!OclAny)");
			symbol_618.setType(symbol_19);  // Boolean
			
			Parameter symbol_619 = PivotFactory.eINSTANCE.createParameter();
			symbol_619.setName("object2");
			//symbol_619.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_619.setType(symbol_80);  // ocl!OclAny
			
			symbol_618.getOwnedParameters().add(symbol_619);
			symbol_618.setPrecedence(symbol_7);
			symbol_618.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation");
			symbol_618.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_618);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_620 = PivotFactory.eINSTANCE.createOperation();
			symbol_620.setName("=");
			//symbol_620.setMoniker("String!=(ocl!OclAny)");
			symbol_620.setType(symbol_19);  // Boolean
			
			Parameter symbol_621 = PivotFactory.eINSTANCE.createParameter();
			symbol_621.setName("object2");
			//symbol_621.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_621.setType(symbol_80);  // ocl!OclAny
			
			symbol_620.getOwnedParameters().add(symbol_621);
			symbol_620.setPrecedence(symbol_7);
			symbol_620.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation");
			symbol_620.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_620);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_622 = PivotFactory.eINSTANCE.createOperation();
			symbol_622.setName(">");
			//symbol_622.setMoniker("String!>(String)");
			symbol_622.setType(symbol_19);  // Boolean
			
			Parameter symbol_623 = PivotFactory.eINSTANCE.createParameter();
			symbol_623.setName("s");
			//symbol_623.setMoniker("String!>(String)!s");
			symbol_623.setType(symbol_143);  // String
			
			symbol_622.getOwnedParameters().add(symbol_623);
			symbol_622.setPrecedence(symbol_6);
			symbol_622.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanOperation");
			symbol_622.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_622);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_624 = PivotFactory.eINSTANCE.createOperation();
			symbol_624.setName(">=");
			//symbol_624.setMoniker("String!>=(String)");
			symbol_624.setType(symbol_19);  // Boolean
			
			Parameter symbol_625 = PivotFactory.eINSTANCE.createParameter();
			symbol_625.setName("s");
			//symbol_625.setMoniker("String!>=(String)!s");
			symbol_625.setType(symbol_143);  // String
			
			symbol_624.getOwnedParameters().add(symbol_625);
			symbol_624.setPrecedence(symbol_6);
			symbol_624.setImplementationClass("org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation");
			symbol_624.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_624);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_626 = PivotFactory.eINSTANCE.createOperation();
			symbol_626.setName("at");
			//symbol_626.setMoniker("String!at(Integer)");
			symbol_626.setType(symbol_143);  // String
			
			Parameter symbol_627 = PivotFactory.eINSTANCE.createParameter();
			symbol_627.setName("i");
			//symbol_627.setMoniker("String!at(Integer)!i");
			symbol_627.setType(symbol_65);  // Integer
			
			symbol_626.getOwnedParameters().add(symbol_627);
			symbol_626.setImplementationClass("org.eclipse.ocl.examples.library.string.StringAtOperation");
			symbol_626.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_626);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_628 = PivotFactory.eINSTANCE.createOperation();
			symbol_628.setName("characters");
			//symbol_628.setMoniker("String!characters()");
			symbol_628.setType(symbol_253);  // ocl!Sequence[String]
			
			symbol_628.setImplementationClass("org.eclipse.ocl.examples.library.string.StringCharactersOperation");
			symbol_628.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_628);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_629 = PivotFactory.eINSTANCE.createOperation();
			symbol_629.setName("concat");
			//symbol_629.setMoniker("String!concat(String)");
			symbol_629.setType(symbol_143);  // String
			
			Parameter symbol_630 = PivotFactory.eINSTANCE.createParameter();
			symbol_630.setName("s");
			//symbol_630.setMoniker("String!concat(String)!s");
			symbol_630.setType(symbol_143);  // String
			
			symbol_629.getOwnedParameters().add(symbol_630);
			symbol_629.setImplementationClass("org.eclipse.ocl.examples.library.string.StringConcatOperation");
			symbol_629.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_629);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_631 = PivotFactory.eINSTANCE.createOperation();
			symbol_631.setName("equalsIgnoreCase");
			//symbol_631.setMoniker("String!equalsIgnoreCase(String)");
			symbol_631.setType(symbol_19);  // Boolean
			
			Parameter symbol_632 = PivotFactory.eINSTANCE.createParameter();
			symbol_632.setName("s");
			//symbol_632.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_632.setType(symbol_143);  // String
			
			symbol_631.getOwnedParameters().add(symbol_632);
			symbol_631.setImplementationClass("org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation");
			symbol_631.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_631);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_633 = PivotFactory.eINSTANCE.createOperation();
			symbol_633.setName("indexOf");
			//symbol_633.setMoniker("String!indexOf(String)");
			symbol_633.setType(symbol_65);  // Integer
			
			Parameter symbol_634 = PivotFactory.eINSTANCE.createParameter();
			symbol_634.setName("s");
			//symbol_634.setMoniker("String!indexOf(String)!s");
			symbol_634.setType(symbol_143);  // String
			
			symbol_633.getOwnedParameters().add(symbol_634);
			symbol_633.setImplementationClass("org.eclipse.ocl.examples.library.string.StringIndexOfOperation");
			symbol_633.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_633);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_635 = PivotFactory.eINSTANCE.createOperation();
			symbol_635.setName("size");
			//symbol_635.setMoniker("String!size()");
			symbol_635.setType(symbol_65);  // Integer
			
			symbol_635.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSizeOperation");
			symbol_635.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_635);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_636 = PivotFactory.eINSTANCE.createOperation();
			symbol_636.setName("substring");
			//symbol_636.setMoniker("String!substring(Integer,Integer)");
			symbol_636.setType(symbol_143);  // String
			
			Parameter symbol_637 = PivotFactory.eINSTANCE.createParameter();
			symbol_637.setName("lower");
			//symbol_637.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_637.setType(symbol_65);  // Integer
			
			symbol_636.getOwnedParameters().add(symbol_637);
			Parameter symbol_638 = PivotFactory.eINSTANCE.createParameter();
			symbol_638.setName("upper");
			//symbol_638.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_638.setType(symbol_65);  // Integer
			
			symbol_636.getOwnedParameters().add(symbol_638);
			symbol_636.setImplementationClass("org.eclipse.ocl.examples.library.string.StringSubstringOperation");
			symbol_636.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_636);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_639 = PivotFactory.eINSTANCE.createOperation();
			symbol_639.setName("toBoolean");
			//symbol_639.setMoniker("String!toBoolean()");
			symbol_639.setType(symbol_19);  // Boolean
			
			symbol_639.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToBooleanOperation");
			symbol_639.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_639);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_640 = PivotFactory.eINSTANCE.createOperation();
			symbol_640.setName("toInteger");
			//symbol_640.setMoniker("String!toInteger()");
			symbol_640.setType(symbol_65);  // Integer
			
			symbol_640.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToIntegerOperation");
			symbol_640.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_640);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_641 = PivotFactory.eINSTANCE.createOperation();
			symbol_641.setName("toLower");
			//symbol_641.setMoniker("String!toLower()");
			symbol_641.setType(symbol_143);  // String
			
			symbol_641.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_641.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_641);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_642 = PivotFactory.eINSTANCE.createOperation();
			symbol_642.setName("toLowerCase");
			//symbol_642.setMoniker("String!toLowerCase()");
			symbol_642.setType(symbol_143);  // String
			
			symbol_642.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation");
			symbol_642.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_642);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_643 = PivotFactory.eINSTANCE.createOperation();
			symbol_643.setName("toReal");
			//symbol_643.setMoniker("String!toReal()");
			symbol_643.setType(symbol_125);  // Real
			
			symbol_643.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToRealOperation");
			symbol_643.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_643);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_644 = PivotFactory.eINSTANCE.createOperation();
			symbol_644.setName("toString");
			//symbol_644.setMoniker("String!toString()");
			symbol_644.setType(symbol_143);  // String
			
			symbol_644.setImplementationClass("org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation");
			symbol_644.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_644);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_645 = PivotFactory.eINSTANCE.createOperation();
			symbol_645.setName("toUpper");
			//symbol_645.setMoniker("String!toUpper()");
			symbol_645.setType(symbol_143);  // String
			
			symbol_645.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_645.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_645);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_646 = PivotFactory.eINSTANCE.createOperation();
			symbol_646.setName("toUpperCase");
			//symbol_646.setMoniker("String!toUpperCase()");
			symbol_646.setType(symbol_143);  // String
			
			symbol_646.setImplementationClass("org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation");
			symbol_646.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_143.getOwnedOperations().add(symbol_646);
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
			Iteration symbol_647 = PivotFactory.eINSTANCE.createIteration();
			symbol_647.setName("sortedBy");
			//symbol_647.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_647.setType(symbol_246);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_648 = PivotFactory.eINSTANCE.createParameter();
			symbol_648.setName("i");
			symbol_648.setType(symbol_148);  // ocl!UniqueCollection{T}?T
			symbol_647.getOwnedIterators().add(symbol_648);
			Parameter symbol_649 = PivotFactory.eINSTANCE.createParameter();
			symbol_649.setName("body");
			//symbol_649.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_649.setType(symbol_208);  // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
			
			symbol_647.getOwnedParameters().add(symbol_649);
			symbol_647.setImplementationClass("org.eclipse.ocl.examples.library.iterator.SortedByIteration");
			symbol_647.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_145.getOwnedOperations().add(symbol_647);
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
		symbol_152.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_14);	
				symbol_651.setActual(symbol_69);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_152.getTemplateBindings().add(symbol_650);
		}
		symbol_152.getSuperClasses().add(symbol_232); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_152.getSuperClasses().add(symbol_66); // ocl!NonOrderedCollection{T}
		symbol_150.getOwnedTypes().add(symbol_152);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_153.setName("Bag");
		//symbol_153.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_153.setElementType(symbol_18);
		symbol_153.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_14);	
				symbol_653.setActual(symbol_18);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_153.getTemplateBindings().add(symbol_652);
		}
		symbol_153.getSuperClasses().add(symbol_212); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_153.getSuperClasses().add(symbol_228); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_153);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_154.setName("Bag");
		//symbol_154.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_154.setElementType(symbol_72);
		symbol_154.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_14);	
				symbol_655.setActual(symbol_72);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_154.getTemplateBindings().add(symbol_654);
		}
		symbol_154.getSuperClasses().add(symbol_221); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_154.getSuperClasses().add(symbol_229); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_154);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_155.setName("Bag");
		//symbol_155.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_155.setElementType(symbol_39);
		symbol_155.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_14);	
				symbol_657.setActual(symbol_39);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_155.getTemplateBindings().add(symbol_656);
		}
		symbol_155.getSuperClasses().add(symbol_218); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_155.getSuperClasses().add(symbol_234); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_155);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_156.setName("Bag");
		//symbol_156.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_156.setElementType(symbol_15);
		symbol_156.setUnspecializedElement(symbol_12);
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_14);	
				symbol_659.setActual(symbol_15);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_156.getTemplateBindings().add(symbol_658);
		}
		symbol_156.getSuperClasses().add(symbol_235); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_156.getSuperClasses().add(symbol_214); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_150.getOwnedTypes().add(symbol_156);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]
		//
		symbol_157.setName("Classifier");
		//symbol_157.setMoniker("ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]");
		symbol_157.setInstanceType(symbol_35);
		symbol_157.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_25);	
				symbol_661.setActual(symbol_35);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_157.getTemplateBindings().add(symbol_660);
		}
		symbol_157.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_157);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]
		//
		symbol_158.setName("Classifier");
		//symbol_158.setMoniker("ocl!Classifier[Real!oclAsType{TT}(ocl!Classifier[TT])?TT]");
		symbol_158.setInstanceType(symbol_128);
		symbol_158.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_25);	
				symbol_663.setActual(symbol_128);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_158.getTemplateBindings().add(symbol_662);
		}
		symbol_158.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_158);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]
		//
		symbol_159.setName("Classifier");
		//symbol_159.setMoniker("ocl!Classifier[ocl!Classifier{T}!oclContainer{U}()?U]");
		symbol_159.setInstanceType(symbol_32);
		symbol_159.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_25);	
				symbol_665.setActual(symbol_32);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_159.getTemplateBindings().add(symbol_664);
		}
		symbol_159.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_159);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
		//
		symbol_160.setName("Classifier");
		//symbol_160.setMoniker("ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]");
		symbol_160.setInstanceType(symbol_95);
		symbol_160.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_25);	
				symbol_667.setActual(symbol_95);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_160.getTemplateBindings().add(symbol_666);
		}
		symbol_160.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_160);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]
		//
		symbol_161.setName("Classifier");
		//symbol_161.setMoniker("ocl!Classifier[ocl!OclAny!oclAsType{TT}(ocl!Classifier[TT])?TT]");
		symbol_161.setInstanceType(symbol_86);
		symbol_161.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_25);	
				symbol_669.setActual(symbol_86);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_161.getTemplateBindings().add(symbol_668);
		}
		symbol_161.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_161);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
		//
		symbol_162.setName("Classifier");
		//symbol_162.setMoniker("ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]");
		symbol_162.setInstanceType(symbol_89);
		symbol_162.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_25);	
				symbol_671.setActual(symbol_89);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_162.getTemplateBindings().add(symbol_670);
		}
		symbol_162.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_162);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
		//
		symbol_163.setName("Classifier");
		//symbol_163.setMoniker("ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]");
		symbol_163.setInstanceType(symbol_92);
		symbol_163.setUnspecializedElement(symbol_23);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_25);	
				symbol_673.setActual(symbol_92);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_163.getTemplateBindings().add(symbol_672);
		}
		symbol_163.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_163);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_164.setName("Collection");
		//symbol_164.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_164.setElementType(symbol_139);
		symbol_164.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_38);	
				symbol_675.setActual(symbol_139);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_164.getTemplateBindings().add(symbol_674);
		}
		symbol_164.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_164);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_165.setName("Collection");
		//symbol_165.setMoniker("ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_165.setElementType(symbol_157);
		symbol_165.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_38);	
				symbol_677.setActual(symbol_157);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_165.getTemplateBindings().add(symbol_676);
		}
		symbol_165.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_165);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_166.setName("Collection");
		//symbol_166.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_166.setElementType(symbol_132);
		symbol_166.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_38);	
				symbol_679.setActual(symbol_132);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_166.getTemplateBindings().add(symbol_678);
		}
		symbol_166.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_166);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_167.setName("Collection");
		//symbol_167.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_167.setElementType(symbol_83);
		symbol_167.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_38);	
				symbol_681.setActual(symbol_83);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_167.getTemplateBindings().add(symbol_680);
		}
		symbol_167.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_167);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_168.setName("Collection");
		//symbol_168.setMoniker("ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_168.setElementType(symbol_100);
		symbol_168.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_38);	
				symbol_683.setActual(symbol_100);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_168.getTemplateBindings().add(symbol_682);
		}
		symbol_168.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_168);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_169.setName("Collection");
		//symbol_169.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_169.setElementType(symbol_142);
		symbol_169.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_38);	
				symbol_685.setActual(symbol_142);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_169.getTemplateBindings().add(symbol_684);
		}
		symbol_169.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_169);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_170.setName("Collection");
		//symbol_170.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_170.setElementType(symbol_42);
		symbol_170.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_38);	
				symbol_687.setActual(symbol_42);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_170.getTemplateBindings().add(symbol_686);
		}
		symbol_170.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_170);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_171.setName("Collection");
		//symbol_171.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_171.setElementType(symbol_48);
		symbol_171.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_38);	
				symbol_689.setActual(symbol_48);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_171.getTemplateBindings().add(symbol_688);
		}
		symbol_171.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_171);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_172.setName("Collection");
		//symbol_172.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_172.setElementType(symbol_39);
		symbol_172.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_38);	
				symbol_691.setActual(symbol_39);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_172.getTemplateBindings().add(symbol_690);
		}
		symbol_172.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_172);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_173.setName("Collection");
		//symbol_173.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_173.setElementType(symbol_15);
		symbol_173.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_38);	
				symbol_693.setActual(symbol_15);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_173.getTemplateBindings().add(symbol_692);
		}
		symbol_173.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_173);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_174.setName("Collection");
		//symbol_174.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_174.setElementType(symbol_79);
		symbol_174.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_38);	
				symbol_695.setActual(symbol_79);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_174.getTemplateBindings().add(symbol_694);
		}
		symbol_174.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_174);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_175.setName("Collection");
		//symbol_175.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_175.setElementType(symbol_18);
		symbol_175.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_38);	
				symbol_697.setActual(symbol_18);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_175.getTemplateBindings().add(symbol_696);
		}
		symbol_175.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_175);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_176.setName("Collection");
		//symbol_176.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_176.setElementType(symbol_80);
		symbol_176.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_38);	
				symbol_699.setActual(symbol_80);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_176.getTemplateBindings().add(symbol_698);
		}
		symbol_176.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_176);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_177.setName("Collection");
		//symbol_177.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_177.setElementType(symbol_72);
		symbol_177.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_38);	
				symbol_701.setActual(symbol_72);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_177.getTemplateBindings().add(symbol_700);
		}
		symbol_177.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_177);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_178.setName("Collection");
		//symbol_178.setMoniker("ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_178.setElementType(symbol_107);
		symbol_178.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_38);	
				symbol_703.setActual(symbol_107);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_178.getTemplateBindings().add(symbol_702);
		}
		symbol_178.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_178);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_179.setName("Collection");
		//symbol_179.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_179.setElementType(symbol_135);
		symbol_179.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_38);	
				symbol_705.setActual(symbol_135);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_179.getTemplateBindings().add(symbol_704);
		}
		symbol_179.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_179);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_180.setName("Collection");
		//symbol_180.setMoniker("ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_180.setElementType(symbol_29);
		symbol_180.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_38);	
				symbol_707.setActual(symbol_29);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_180.getTemplateBindings().add(symbol_706);
		}
		symbol_180.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_180);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_181.setName("Collection");
		//symbol_181.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_181.setElementType(symbol_148);
		symbol_181.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_38);	
				symbol_709.setActual(symbol_148);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_181.getTemplateBindings().add(symbol_708);
		}
		symbol_181.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_181);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_182.setName("Collection");
		//symbol_182.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_182.setElementType(symbol_111);
		symbol_182.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_38);	
				symbol_711.setActual(symbol_111);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_182.getTemplateBindings().add(symbol_710);
		}
		symbol_182.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_182);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_183.setName("Collection");
		//symbol_183.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_183.setElementType(symbol_51);
		symbol_183.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_38);	
				symbol_713.setActual(symbol_51);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_183.getTemplateBindings().add(symbol_712);
		}
		symbol_183.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_183);
		//
		// ocl::$orphanage::Collection ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_184.setName("Collection");
		//symbol_184.setMoniker("ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_184.setElementType(symbol_22);
		symbol_184.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_38);	
				symbol_715.setActual(symbol_22);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_184.getTemplateBindings().add(symbol_714);
		}
		symbol_184.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_184);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_185.setName("Collection");
		//symbol_185.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_185.setElementType(symbol_121);
		symbol_185.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_38);	
				symbol_717.setActual(symbol_121);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_185.getTemplateBindings().add(symbol_716);
		}
		symbol_185.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_185);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_186.setName("Collection");
		//symbol_186.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_186.setElementType(symbol_69);
		symbol_186.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_38);	
				symbol_719.setActual(symbol_69);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_186.getTemplateBindings().add(symbol_718);
		}
		symbol_186.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_186);
		//
		// ocl::$orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_187.setName("Collection");
		//symbol_187.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_187.setElementType(symbol_272);
		symbol_187.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_38);	
				symbol_721.setActual(symbol_272);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_187.getTemplateBindings().add(symbol_720);
		}
		symbol_187.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_187);
		//
		// ocl::$orphanage::Collection ocl!Collection[String]
		//
		symbol_188.setName("Collection");
		//symbol_188.setMoniker("ocl!Collection[String]");
		symbol_188.setElementType(symbol_143);
		symbol_188.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_38);	
				symbol_723.setActual(symbol_143);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_188.getTemplateBindings().add(symbol_722);
		}
		symbol_188.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_188);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_189.setName("Collection");
		//symbol_189.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_189.setElementType(symbol_54);
		symbol_189.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_38);	
				symbol_725.setActual(symbol_54);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_189.getTemplateBindings().add(symbol_724);
		}
		symbol_189.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_189);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_190.setName("Collection");
		//symbol_190.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_190.setElementType(symbol_114);
		symbol_190.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_726 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_726.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_727 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_727.setFormal(symbol_38);	
				symbol_727.setActual(symbol_114);	
				symbol_726.getParameterSubstitutions().add(symbol_727);
			}
			symbol_190.getTemplateBindings().add(symbol_726);
		}
		symbol_190.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_190);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_191.setName("Collection");
		//symbol_191.setMoniker("ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_191.setElementType(symbol_64);
		symbol_191.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_728 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_728.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_729 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_729.setFormal(symbol_38);	
				symbol_729.setActual(symbol_64);	
				symbol_728.getParameterSubstitutions().add(symbol_729);
			}
			symbol_191.getTemplateBindings().add(symbol_728);
		}
		symbol_191.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_191);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_192.setName("Collection");
		//symbol_192.setMoniker("ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_192.setElementType(symbol_124);
		symbol_192.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_730 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_730.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_731 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_731.setFormal(symbol_38);	
				symbol_731.setActual(symbol_124);	
				symbol_730.getParameterSubstitutions().add(symbol_731);
			}
			symbol_192.getTemplateBindings().add(symbol_730);
		}
		symbol_192.getSuperClasses().add(symbol_80); // ocl!OclAny
		symbol_150.getOwnedTypes().add(symbol_192);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_193.setName("Collection");
		//symbol_193.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_193.setElementType(symbol_60);
		symbol_193.setUnspecializedElement(symbol_36);
		{
			TemplateBinding symbol_732 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_732.setSignature(symbol_37);
			{
				TemplateParameterSubstitution symbol_733 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_733.setFormal(symbol_38);	
				symbol_733.setActual(symbol_60);	
				symbol_732.getParameterSubstitutions().add(symbol_733);
			}
			symbol_193.getTemplateBindings().add(symbol_732);
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
		symbol_195.setResultType(symbol_247);
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
		symbol_197.setResultType(symbol_266);
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
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_210.setName("NonOrderedCollection");
		//symbol_210.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_210.setElementType(symbol_107);
		symbol_210.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_734 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_734.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_735 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_735.setFormal(symbol_68);	
				symbol_735.setActual(symbol_107);	
				symbol_734.getParameterSubstitutions().add(symbol_735);
			}
			symbol_210.getTemplateBindings().add(symbol_734);
		}
		symbol_210.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_210);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_211.setName("NonOrderedCollection");
		//symbol_211.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_211.setElementType(symbol_139);
		symbol_211.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_736 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_736.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_737 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_737.setFormal(symbol_68);	
				symbol_737.setActual(symbol_139);	
				symbol_736.getParameterSubstitutions().add(symbol_737);
			}
			symbol_211.getTemplateBindings().add(symbol_736);
		}
		symbol_211.getSuperClasses().add(symbol_164); // ocl!Collection[ocl!Set{T}?T]
		symbol_150.getOwnedTypes().add(symbol_211);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_212.setName("NonOrderedCollection");
		//symbol_212.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_212.setElementType(symbol_18);
		symbol_212.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_738 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_738.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_739 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_739.setFormal(symbol_68);	
				symbol_739.setActual(symbol_18);	
				symbol_738.getParameterSubstitutions().add(symbol_739);
			}
			symbol_212.getTemplateBindings().add(symbol_738);
		}
		symbol_212.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_212);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_213.setName("NonOrderedCollection");
		//symbol_213.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_213.setElementType(symbol_142);
		symbol_213.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_740 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_740.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_741 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_741.setFormal(symbol_68);	
				symbol_741.setActual(symbol_142);	
				symbol_740.getParameterSubstitutions().add(symbol_741);
			}
			symbol_213.getTemplateBindings().add(symbol_740);
		}
		symbol_213.getSuperClasses().add(symbol_169); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_213);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_214.setName("NonOrderedCollection");
		//symbol_214.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_214.setElementType(symbol_15);
		symbol_214.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_742 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_742.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_743 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_743.setFormal(symbol_68);	
				symbol_743.setActual(symbol_15);	
				symbol_742.getParameterSubstitutions().add(symbol_743);
			}
			symbol_214.getTemplateBindings().add(symbol_742);
		}
		symbol_214.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Bag{T}?T]
		symbol_150.getOwnedTypes().add(symbol_214);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_215.setName("NonOrderedCollection");
		//symbol_215.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_215.setElementType(symbol_272);
		symbol_215.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_744 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_744.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_745 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_745.setFormal(symbol_68);	
				symbol_745.setActual(symbol_272);	
				symbol_744.getParameterSubstitutions().add(symbol_745);
			}
			symbol_215.getTemplateBindings().add(symbol_744);
		}
		symbol_215.getSuperClasses().add(symbol_187); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_150.getOwnedTypes().add(symbol_215);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_216.setName("NonOrderedCollection");
		//symbol_216.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_216.setElementType(symbol_64);
		symbol_216.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_746 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_746.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_747 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_747.setFormal(symbol_68);	
				symbol_747.setActual(symbol_64);	
				symbol_746.getParameterSubstitutions().add(symbol_747);
			}
			symbol_216.getTemplateBindings().add(symbol_746);
		}
		symbol_216.getSuperClasses().add(symbol_191); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_216);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_217.setName("NonOrderedCollection");
		//symbol_217.setMoniker("ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_217.setElementType(symbol_22);
		symbol_217.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_748 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_748.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_749 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_749.setFormal(symbol_68);	
				symbol_749.setActual(symbol_22);	
				symbol_748.getParameterSubstitutions().add(symbol_749);
			}
			symbol_217.getTemplateBindings().add(symbol_748);
		}
		symbol_217.getSuperClasses().add(symbol_184); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_217);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_218.setName("NonOrderedCollection");
		//symbol_218.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_218.setElementType(symbol_39);
		symbol_218.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_750 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_750.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_751 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_751.setFormal(symbol_68);	
				symbol_751.setActual(symbol_39);	
				symbol_750.getParameterSubstitutions().add(symbol_751);
			}
			symbol_218.getTemplateBindings().add(symbol_750);
		}
		symbol_218.getSuperClasses().add(symbol_36); // ocl!Collection{T}
		symbol_150.getOwnedTypes().add(symbol_218);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_219.setName("NonOrderedCollection");
		//symbol_219.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_219.setElementType(symbol_121);
		symbol_219.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_752 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_752.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_753 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_753.setFormal(symbol_68);	
				symbol_753.setActual(symbol_121);	
				symbol_752.getParameterSubstitutions().add(symbol_753);
			}
			symbol_219.getTemplateBindings().add(symbol_752);
		}
		symbol_219.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_219);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_220.setName("NonOrderedCollection");
		//symbol_220.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_220.setElementType(symbol_80);
		symbol_220.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_754 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_754.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_755 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_755.setFormal(symbol_68);	
				symbol_755.setActual(symbol_80);	
				symbol_754.getParameterSubstitutions().add(symbol_755);
			}
			symbol_220.getTemplateBindings().add(symbol_754);
		}
		symbol_220.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OclAny]
		symbol_150.getOwnedTypes().add(symbol_220);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_221.setName("NonOrderedCollection");
		//symbol_221.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_221.setElementType(symbol_72);
		symbol_221.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_756 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_756.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_757 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_757.setFormal(symbol_68);	
				symbol_757.setActual(symbol_72);	
				symbol_756.getParameterSubstitutions().add(symbol_757);
			}
			symbol_221.getTemplateBindings().add(symbol_756);
		}
		symbol_221.getSuperClasses().add(symbol_177); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_221);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_222.setName("NonOrderedCollection");
		//symbol_222.setMoniker("ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_222.setElementType(symbol_29);
		symbol_222.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_758 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_758.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_759 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_759.setFormal(symbol_68);	
				symbol_759.setActual(symbol_29);	
				symbol_758.getParameterSubstitutions().add(symbol_759);
			}
			symbol_222.getTemplateBindings().add(symbol_758);
		}
		symbol_222.getSuperClasses().add(symbol_180); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_222);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_223.setName("NonOrderedCollection");
		//symbol_223.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_223.setElementType(symbol_100);
		symbol_223.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_760 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_760.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_761 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_761.setFormal(symbol_68);	
				symbol_761.setActual(symbol_100);	
				symbol_760.getParameterSubstitutions().add(symbol_761);
			}
			symbol_223.getTemplateBindings().add(symbol_760);
		}
		symbol_223.getSuperClasses().add(symbol_168); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_223);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_224.setName("NonOrderedCollection");
		//symbol_224.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_224.setElementType(symbol_83);
		symbol_224.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_762 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_762.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_763 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_763.setFormal(symbol_68);	
				symbol_763.setActual(symbol_83);	
				symbol_762.getParameterSubstitutions().add(symbol_763);
			}
			symbol_224.getTemplateBindings().add(symbol_762);
		}
		symbol_224.getSuperClasses().add(symbol_167); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_224);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_225.setName("NonOrderedCollection");
		//symbol_225.setMoniker("ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_225.setElementType(symbol_157);
		symbol_225.setUnspecializedElement(symbol_66);
		{
			TemplateBinding symbol_764 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_764.setSignature(symbol_67);
			{
				TemplateParameterSubstitution symbol_765 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_765.setFormal(symbol_68);	
				symbol_765.setActual(symbol_157);	
				symbol_764.getParameterSubstitutions().add(symbol_765);
			}
			symbol_225.getTemplateBindings().add(symbol_764);
		}
		symbol_225.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_150.getOwnedTypes().add(symbol_225);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_226.setName("NonUniqueCollection");
		//symbol_226.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_226.setElementType(symbol_132);
		symbol_226.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_766 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_766.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_767 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_767.setFormal(symbol_78);	
				symbol_767.setActual(symbol_132);	
				symbol_766.getParameterSubstitutions().add(symbol_767);
			}
			symbol_226.getTemplateBindings().add(symbol_766);
		}
		symbol_226.getSuperClasses().add(symbol_166); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_150.getOwnedTypes().add(symbol_226);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_227.setName("NonUniqueCollection");
		//symbol_227.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_227.setElementType(symbol_135);
		symbol_227.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_768 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_768.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_769 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_769.setFormal(symbol_78);	
				symbol_769.setActual(symbol_135);	
				symbol_768.getParameterSubstitutions().add(symbol_769);
			}
			symbol_227.getTemplateBindings().add(symbol_768);
		}
		symbol_227.getSuperClasses().add(symbol_179); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_227);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_228.setName("NonUniqueCollection");
		//symbol_228.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_228.setElementType(symbol_18);
		symbol_228.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_770 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_770.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_771 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_771.setFormal(symbol_78);	
				symbol_771.setActual(symbol_18);	
				symbol_770.getParameterSubstitutions().add(symbol_771);
			}
			symbol_228.getTemplateBindings().add(symbol_770);
		}
		symbol_228.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_228);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_229.setName("NonUniqueCollection");
		//symbol_229.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_229.setElementType(symbol_72);
		symbol_229.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_772 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_772.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_773 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_773.setFormal(symbol_78);	
				symbol_773.setActual(symbol_72);	
				symbol_772.getParameterSubstitutions().add(symbol_773);
			}
			symbol_229.getTemplateBindings().add(symbol_772);
		}
		symbol_229.getSuperClasses().add(symbol_177); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_229);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_230.setName("NonUniqueCollection");
		//symbol_230.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_230.setElementType(symbol_111);
		symbol_230.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_774 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_774.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_775 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_775.setFormal(symbol_78);	
				symbol_775.setActual(symbol_111);	
				symbol_774.getParameterSubstitutions().add(symbol_775);
			}
			symbol_230.getTemplateBindings().add(symbol_774);
		}
		symbol_230.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_230);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_231.setName("NonUniqueCollection");
		//symbol_231.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_231.setElementType(symbol_114);
		symbol_231.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_776 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_776.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_777 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_777.setFormal(symbol_78);	
				symbol_777.setActual(symbol_114);	
				symbol_776.getParameterSubstitutions().add(symbol_777);
			}
			symbol_231.getTemplateBindings().add(symbol_776);
		}
		symbol_231.getSuperClasses().add(symbol_190); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_231);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_232.setName("NonUniqueCollection");
		//symbol_232.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_232.setElementType(symbol_69);
		symbol_232.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_778 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_778.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_779 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_779.setFormal(symbol_78);	
				symbol_779.setActual(symbol_69);	
				symbol_778.getParameterSubstitutions().add(symbol_779);
			}
			symbol_232.getTemplateBindings().add(symbol_778);
		}
		symbol_232.getSuperClasses().add(symbol_186); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_232);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_233.setName("NonUniqueCollection");
		//symbol_233.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_233.setElementType(symbol_143);
		symbol_233.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_780 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_780.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_781 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_781.setFormal(symbol_78);	
				symbol_781.setActual(symbol_143);	
				symbol_780.getParameterSubstitutions().add(symbol_781);
			}
			symbol_233.getTemplateBindings().add(symbol_780);
		}
		symbol_233.getSuperClasses().add(symbol_188); // ocl!Collection[String]
		symbol_150.getOwnedTypes().add(symbol_233);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_234.setName("NonUniqueCollection");
		//symbol_234.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_234.setElementType(symbol_39);
		symbol_234.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_782 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_782.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_783 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_783.setFormal(symbol_78);	
				symbol_783.setActual(symbol_39);	
				symbol_782.getParameterSubstitutions().add(symbol_783);
			}
			symbol_234.getTemplateBindings().add(symbol_782);
		}
		symbol_234.getSuperClasses().add(symbol_36); // ocl!Collection{T}
		symbol_150.getOwnedTypes().add(symbol_234);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_235.setName("NonUniqueCollection");
		//symbol_235.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_235.setElementType(symbol_15);
		symbol_235.setUnspecializedElement(symbol_76);
		{
			TemplateBinding symbol_784 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_784.setSignature(symbol_77);
			{
				TemplateParameterSubstitution symbol_785 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_785.setFormal(symbol_78);	
				symbol_785.setActual(symbol_15);	
				symbol_784.getParameterSubstitutions().add(symbol_785);
			}
			symbol_235.getTemplateBindings().add(symbol_784);
		}
		symbol_235.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Bag{T}?T]
		symbol_150.getOwnedTypes().add(symbol_235);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_236.setName("OrderedCollection");
		//symbol_236.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_236.setElementType(symbol_79);
		symbol_236.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_786 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_786.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_787 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_787.setFormal(symbol_110);	
				symbol_787.setActual(symbol_79);	
				symbol_786.getParameterSubstitutions().add(symbol_787);
			}
			symbol_236.getTemplateBindings().add(symbol_786);
		}
		symbol_236.getSuperClasses().add(symbol_174); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_236);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_237.setName("OrderedCollection");
		//symbol_237.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_237.setElementType(symbol_39);
		symbol_237.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_788 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_788.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_789 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_789.setFormal(symbol_110);	
				symbol_789.setActual(symbol_39);	
				symbol_788.getParameterSubstitutions().add(symbol_789);
			}
			symbol_237.getTemplateBindings().add(symbol_788);
		}
		symbol_237.getSuperClasses().add(symbol_36); // ocl!Collection{T}
		symbol_150.getOwnedTypes().add(symbol_237);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_238.setName("OrderedCollection");
		//symbol_238.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_238.setElementType(symbol_148);
		symbol_238.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_790 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_790.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_791 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_791.setFormal(symbol_110);	
				symbol_791.setActual(symbol_148);	
				symbol_790.getParameterSubstitutions().add(symbol_791);
			}
			symbol_238.getTemplateBindings().add(symbol_790);
		}
		symbol_238.getSuperClasses().add(symbol_181); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_238);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_239.setName("OrderedCollection");
		//symbol_239.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_239.setElementType(symbol_132);
		symbol_239.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_792 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_792.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_793 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_793.setFormal(symbol_110);	
				symbol_793.setActual(symbol_132);	
				symbol_792.getParameterSubstitutions().add(symbol_793);
			}
			symbol_239.getTemplateBindings().add(symbol_792);
		}
		symbol_239.getSuperClasses().add(symbol_166); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_150.getOwnedTypes().add(symbol_239);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_240.setName("OrderedCollection");
		//symbol_240.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_240.setElementType(symbol_124);
		symbol_240.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_794 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_794.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_795 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_795.setFormal(symbol_110);	
				symbol_795.setActual(symbol_124);	
				symbol_794.getParameterSubstitutions().add(symbol_795);
			}
			symbol_240.getTemplateBindings().add(symbol_794);
		}
		symbol_240.getSuperClasses().add(symbol_192); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_240);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_241.setName("OrderedCollection");
		//symbol_241.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_241.setElementType(symbol_121);
		symbol_241.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_796 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_796.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_797 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_797.setFormal(symbol_110);	
				symbol_797.setActual(symbol_121);	
				symbol_796.getParameterSubstitutions().add(symbol_797);
			}
			symbol_241.getTemplateBindings().add(symbol_796);
		}
		symbol_241.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_241);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_242.setName("OrderedCollection");
		//symbol_242.setMoniker("ocl!OrderedCollection[String]");
		symbol_242.setElementType(symbol_143);
		symbol_242.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_798 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_798.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_799 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_799.setFormal(symbol_110);	
				symbol_799.setActual(symbol_143);	
				symbol_798.getParameterSubstitutions().add(symbol_799);
			}
			symbol_242.getTemplateBindings().add(symbol_798);
		}
		symbol_242.getSuperClasses().add(symbol_188); // ocl!Collection[String]
		symbol_150.getOwnedTypes().add(symbol_242);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_243.setName("OrderedCollection");
		//symbol_243.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_243.setElementType(symbol_111);
		symbol_243.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_800 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_800.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_801 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_801.setFormal(symbol_110);	
				symbol_801.setActual(symbol_111);	
				symbol_800.getParameterSubstitutions().add(symbol_801);
			}
			symbol_243.getTemplateBindings().add(symbol_800);
		}
		symbol_243.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_243);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_244.setName("OrderedCollection");
		//symbol_244.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_244.setElementType(symbol_135);
		symbol_244.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_802 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_802.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_803 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_803.setFormal(symbol_110);	
				symbol_803.setActual(symbol_135);	
				symbol_802.getParameterSubstitutions().add(symbol_803);
			}
			symbol_244.getTemplateBindings().add(symbol_802);
		}
		symbol_244.getSuperClasses().add(symbol_179); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_244);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_245.setName("OrderedCollection");
		//symbol_245.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_245.setElementType(symbol_114);
		symbol_245.setUnspecializedElement(symbol_108);
		{
			TemplateBinding symbol_804 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_804.setSignature(symbol_109);
			{
				TemplateParameterSubstitution symbol_805 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_805.setFormal(symbol_110);	
				symbol_805.setActual(symbol_114);	
				symbol_804.getParameterSubstitutions().add(symbol_805);
			}
			symbol_245.getTemplateBindings().add(symbol_804);
		}
		symbol_245.getSuperClasses().add(symbol_190); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_245);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_246.setName("OrderedSet");
		//symbol_246.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_246.setElementType(symbol_148);
		symbol_246.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_806 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_806.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_807 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_807.setFormal(symbol_120);	
				symbol_807.setActual(symbol_148);	
				symbol_806.getParameterSubstitutions().add(symbol_807);
			}
			symbol_246.getTemplateBindings().add(symbol_806);
		}
		symbol_246.getSuperClasses().add(symbol_238); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_246.getSuperClasses().add(symbol_145); // ocl!UniqueCollection{T}
		symbol_150.getOwnedTypes().add(symbol_246);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_247.setName("OrderedSet");
		//symbol_247.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_247.setElementType(symbol_111);
		symbol_247.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_808 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_808.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_809 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_809.setFormal(symbol_120);	
				symbol_809.setActual(symbol_111);	
				symbol_808.getParameterSubstitutions().add(symbol_809);
			}
			symbol_247.getTemplateBindings().add(symbol_808);
		}
		symbol_247.getSuperClasses().add(symbol_108); // ocl!OrderedCollection{T}
		symbol_247.getSuperClasses().add(symbol_283); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_247);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_248.setName("OrderedSet");
		//symbol_248.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_248.setElementType(symbol_121);
		symbol_248.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_810 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_810.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_811 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_811.setFormal(symbol_120);	
				symbol_811.setActual(symbol_121);	
				symbol_810.getParameterSubstitutions().add(symbol_811);
			}
			symbol_248.getTemplateBindings().add(symbol_810);
		}
		symbol_248.getSuperClasses().add(symbol_241); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_248.getSuperClasses().add(symbol_284); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_248);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_249.setName("OrderedSet");
		//symbol_249.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_249.setElementType(symbol_39);
		symbol_249.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_812 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_812.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_813 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_813.setFormal(symbol_120);	
				symbol_813.setActual(symbol_39);	
				symbol_812.getParameterSubstitutions().add(symbol_813);
			}
			symbol_249.getTemplateBindings().add(symbol_812);
		}
		symbol_249.getSuperClasses().add(symbol_237); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_249.getSuperClasses().add(symbol_277); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_249);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_250.setName("OrderedSet");
		//symbol_250.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_250.setElementType(symbol_124);
		symbol_250.setUnspecializedElement(symbol_118);
		{
			TemplateBinding symbol_814 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_814.setSignature(symbol_119);
			{
				TemplateParameterSubstitution symbol_815 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_815.setFormal(symbol_120);	
				symbol_815.setActual(symbol_124);	
				symbol_814.getParameterSubstitutions().add(symbol_815);
			}
			symbol_250.getTemplateBindings().add(symbol_814);
		}
		symbol_250.getSuperClasses().add(symbol_240); // ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_250.getSuperClasses().add(symbol_290); // ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_250);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_251.setName("Sequence");
		//symbol_251.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_251.setElementType(symbol_79);
		symbol_251.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_816 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_816.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_817 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_817.setFormal(symbol_131);	
				symbol_817.setActual(symbol_79);	
				symbol_816.getParameterSubstitutions().add(symbol_817);
			}
			symbol_251.getTemplateBindings().add(symbol_816);
		}
		symbol_251.getSuperClasses().add(symbol_236); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_251.getSuperClasses().add(symbol_76); // ocl!NonUniqueCollection{T}
		symbol_150.getOwnedTypes().add(symbol_251);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_252.setName("Sequence");
		//symbol_252.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_252.setElementType(symbol_135);
		symbol_252.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_818 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_818.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_819 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_819.setFormal(symbol_131);	
				symbol_819.setActual(symbol_135);	
				symbol_818.getParameterSubstitutions().add(symbol_819);
			}
			symbol_252.getTemplateBindings().add(symbol_818);
		}
		symbol_252.getSuperClasses().add(symbol_227); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_252.getSuperClasses().add(symbol_244); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_252);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[String]
		//
		symbol_253.setName("Sequence");
		//symbol_253.setMoniker("ocl!Sequence[String]");
		symbol_253.setElementType(symbol_143);
		symbol_253.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_820 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_820.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_821 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_821.setFormal(symbol_131);	
				symbol_821.setActual(symbol_143);	
				symbol_820.getParameterSubstitutions().add(symbol_821);
			}
			symbol_253.getTemplateBindings().add(symbol_820);
		}
		symbol_253.getSuperClasses().add(symbol_233); // ocl!NonUniqueCollection[String]
		symbol_253.getSuperClasses().add(symbol_242); // ocl!OrderedCollection[String]
		symbol_150.getOwnedTypes().add(symbol_253);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_254.setName("Sequence");
		//symbol_254.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_254.setElementType(symbol_132);
		symbol_254.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_822 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_822.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_823 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_823.setFormal(symbol_131);	
				symbol_823.setActual(symbol_132);	
				symbol_822.getParameterSubstitutions().add(symbol_823);
			}
			symbol_254.getTemplateBindings().add(symbol_822);
		}
		symbol_254.getSuperClasses().add(symbol_239); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_254.getSuperClasses().add(symbol_226); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_150.getOwnedTypes().add(symbol_254);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_255.setName("Sequence");
		//symbol_255.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_255.setElementType(symbol_39);
		symbol_255.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_824 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_824.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_825 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_825.setFormal(symbol_131);	
				symbol_825.setActual(symbol_39);	
				symbol_824.getParameterSubstitutions().add(symbol_825);
			}
			symbol_255.getTemplateBindings().add(symbol_824);
		}
		symbol_255.getSuperClasses().add(symbol_237); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_255.getSuperClasses().add(symbol_234); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_255);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_256.setName("Sequence");
		//symbol_256.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_256.setElementType(symbol_111);
		symbol_256.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_826 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_826.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_827 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_827.setFormal(symbol_131);	
				symbol_827.setActual(symbol_111);	
				symbol_826.getParameterSubstitutions().add(symbol_827);
			}
			symbol_256.getTemplateBindings().add(symbol_826);
		}
		symbol_256.getSuperClasses().add(symbol_230); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_256.getSuperClasses().add(symbol_108); // ocl!OrderedCollection{T}
		symbol_150.getOwnedTypes().add(symbol_256);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_257.setName("Sequence");
		//symbol_257.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_257.setElementType(symbol_114);
		symbol_257.setUnspecializedElement(symbol_129);
		{
			TemplateBinding symbol_828 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_828.setSignature(symbol_130);
			{
				TemplateParameterSubstitution symbol_829 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_829.setFormal(symbol_131);	
				symbol_829.setActual(symbol_114);	
				symbol_828.getParameterSubstitutions().add(symbol_829);
			}
			symbol_257.getTemplateBindings().add(symbol_828);
		}
		symbol_257.getSuperClasses().add(symbol_245); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_257.getSuperClasses().add(symbol_231); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_150.getOwnedTypes().add(symbol_257);
		//
		// ocl::$orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_258.setName("Set");
		//symbol_258.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_258.setElementType(symbol_272);
		symbol_258.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_830 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_830.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_831 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_831.setFormal(symbol_138);	
				symbol_831.setActual(symbol_272);	
				symbol_830.getParameterSubstitutions().add(symbol_831);
			}
			symbol_258.getTemplateBindings().add(symbol_830);
		}
		symbol_258.getSuperClasses().add(symbol_282); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_258.getSuperClasses().add(symbol_215); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_150.getOwnedTypes().add(symbol_258);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_259.setName("Set");
		//symbol_259.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_259.setElementType(symbol_83);
		symbol_259.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_832 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_832.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_833 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_833.setFormal(symbol_138);	
				symbol_833.setActual(symbol_83);	
				symbol_832.getParameterSubstitutions().add(symbol_833);
			}
			symbol_259.getTemplateBindings().add(symbol_832);
		}
		symbol_259.getSuperClasses().add(symbol_224); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_259.getSuperClasses().add(symbol_275); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_259);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_260.setName("Set");
		//symbol_260.setMoniker("ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_260.setElementType(symbol_64);
		symbol_260.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_834 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_834.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_835 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_835.setFormal(symbol_138);	
				symbol_835.setActual(symbol_64);	
				symbol_834.getParameterSubstitutions().add(symbol_835);
			}
			symbol_260.getTemplateBindings().add(symbol_834);
		}
		symbol_260.getSuperClasses().add(symbol_216); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_260.getSuperClasses().add(symbol_276); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_260);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_261.setName("Set");
		//symbol_261.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_261.setElementType(symbol_142);
		symbol_261.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_836 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_836.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_837 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_837.setFormal(symbol_138);	
				symbol_837.setActual(symbol_142);	
				symbol_836.getParameterSubstitutions().add(symbol_837);
			}
			symbol_261.getTemplateBindings().add(symbol_836);
		}
		symbol_261.getSuperClasses().add(symbol_213); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_261.getSuperClasses().add(symbol_285); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_261);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_262.setName("Set");
		//symbol_262.setMoniker("ocl!Set[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_262.setElementType(symbol_157);
		symbol_262.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_838 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_838.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_839 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_839.setFormal(symbol_138);	
				symbol_839.setActual(symbol_157);	
				symbol_838.getParameterSubstitutions().add(symbol_839);
			}
			symbol_262.getTemplateBindings().add(symbol_838);
		}
		symbol_262.getSuperClasses().add(symbol_225); // ocl!NonOrderedCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_262.getSuperClasses().add(symbol_287); // ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_150.getOwnedTypes().add(symbol_262);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_263.setName("Set");
		//symbol_263.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_263.setElementType(symbol_80);
		symbol_263.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_840 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_840.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_841 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_841.setFormal(symbol_138);	
				symbol_841.setActual(symbol_80);	
				symbol_840.getParameterSubstitutions().add(symbol_841);
			}
			symbol_263.getTemplateBindings().add(symbol_840);
		}
		symbol_263.getSuperClasses().add(symbol_220); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_263.getSuperClasses().add(symbol_278); // ocl!UniqueCollection[ocl!OclAny]
		symbol_150.getOwnedTypes().add(symbol_263);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_264.setName("Set");
		//symbol_264.setMoniker("ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_264.setElementType(symbol_107);
		symbol_264.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_842 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_842.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_843 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_843.setFormal(symbol_138);	
				symbol_843.setActual(symbol_107);	
				symbol_842.getParameterSubstitutions().add(symbol_843);
			}
			symbol_264.getTemplateBindings().add(symbol_842);
		}
		symbol_264.getSuperClasses().add(symbol_280); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_264.getSuperClasses().add(symbol_210); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_264);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_265.setName("Set");
		//symbol_265.setMoniker("ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_265.setElementType(symbol_29);
		symbol_265.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_844 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_844.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_845 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_845.setFormal(symbol_138);	
				symbol_845.setActual(symbol_29);	
				symbol_844.getParameterSubstitutions().add(symbol_845);
			}
			symbol_265.getTemplateBindings().add(symbol_844);
		}
		symbol_265.getSuperClasses().add(symbol_222); // ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_265.getSuperClasses().add(symbol_279); // ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_265);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_266.setName("Set");
		//symbol_266.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_266.setElementType(symbol_69);
		symbol_266.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_846 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_846.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_847 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_847.setFormal(symbol_138);	
				symbol_847.setActual(symbol_69);	
				symbol_846.getParameterSubstitutions().add(symbol_847);
			}
			symbol_266.getTemplateBindings().add(symbol_846);
		}
		symbol_266.getSuperClasses().add(symbol_289); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_266.getSuperClasses().add(symbol_66); // ocl!NonOrderedCollection{T}
		symbol_150.getOwnedTypes().add(symbol_266);
		//
		// ocl::$orphanage::Set ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_267.setName("Set");
		//symbol_267.setMoniker("ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_267.setElementType(symbol_22);
		symbol_267.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_848 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_848.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_849 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_849.setFormal(symbol_138);	
				symbol_849.setActual(symbol_22);	
				symbol_848.getParameterSubstitutions().add(symbol_849);
			}
			symbol_267.getTemplateBindings().add(symbol_848);
		}
		symbol_267.getSuperClasses().add(symbol_288); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_267.getSuperClasses().add(symbol_217); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_267);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_268.setName("Set");
		//symbol_268.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_268.setElementType(symbol_139);
		symbol_268.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_850 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_850.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_851 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_851.setFormal(symbol_138);	
				symbol_851.setActual(symbol_139);	
				symbol_850.getParameterSubstitutions().add(symbol_851);
			}
			symbol_268.getTemplateBindings().add(symbol_850);
		}
		symbol_268.getSuperClasses().add(symbol_281); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_268.getSuperClasses().add(symbol_211); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_150.getOwnedTypes().add(symbol_268);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_269.setName("Set");
		//symbol_269.setMoniker("ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_269.setElementType(symbol_100);
		symbol_269.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_852 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_852.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_853 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_853.setFormal(symbol_138);	
				symbol_853.setActual(symbol_100);	
				symbol_852.getParameterSubstitutions().add(symbol_853);
			}
			symbol_269.getTemplateBindings().add(symbol_852);
		}
		symbol_269.getSuperClasses().add(symbol_286); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_269.getSuperClasses().add(symbol_223); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_269);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_270.setName("Set");
		//symbol_270.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_270.setElementType(symbol_121);
		symbol_270.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_854 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_854.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_855 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_855.setFormal(symbol_138);	
				symbol_855.setActual(symbol_121);	
				symbol_854.getParameterSubstitutions().add(symbol_855);
			}
			symbol_270.getTemplateBindings().add(symbol_854);
		}
		symbol_270.getSuperClasses().add(symbol_219); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_270.getSuperClasses().add(symbol_284); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_270);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_271.setName("Set");
		//symbol_271.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_271.setElementType(symbol_39);
		symbol_271.setUnspecializedElement(symbol_136);
		{
			TemplateBinding symbol_856 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_856.setSignature(symbol_137);
			{
				TemplateParameterSubstitution symbol_857 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_857.setFormal(symbol_138);	
				symbol_857.setActual(symbol_39);	
				symbol_856.getParameterSubstitutions().add(symbol_857);
			}
			symbol_271.getTemplateBindings().add(symbol_856);
		}
		symbol_271.getSuperClasses().add(symbol_218); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_271.getSuperClasses().add(symbol_277); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_271);
		//
		// ocl::$orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_272.setName("Tuple");
		//symbol_272.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		symbol_272.getSuperClasses().add(symbol_144); // ocl!Tuple
		{ // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_273.setName("first");
			symbol_273.setType(symbol_39);  // ocl!Collection{T}?T
			
			symbol_273.setIsResolveProxies(true);
			symbol_272.getOwnedAttributes().add(symbol_273);
		}
		{ // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_274.setName("second");
			symbol_274.setType(symbol_60);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_274.setIsResolveProxies(true);
			symbol_272.getOwnedAttributes().add(symbol_274);
		}
		symbol_150.getOwnedTypes().add(symbol_272);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_275.setName("UniqueCollection");
		//symbol_275.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_275.setElementType(symbol_83);
		symbol_275.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_858 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_858.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_859 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_859.setFormal(symbol_147);	
				symbol_859.setActual(symbol_83);	
				symbol_858.getParameterSubstitutions().add(symbol_859);
			}
			symbol_275.getTemplateBindings().add(symbol_858);
		}
		symbol_275.getSuperClasses().add(symbol_167); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_275);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_276.setName("UniqueCollection");
		//symbol_276.setMoniker("ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_276.setElementType(symbol_64);
		symbol_276.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_860 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_860.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_861 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_861.setFormal(symbol_147);	
				symbol_861.setActual(symbol_64);	
				symbol_860.getParameterSubstitutions().add(symbol_861);
			}
			symbol_276.getTemplateBindings().add(symbol_860);
		}
		symbol_276.getSuperClasses().add(symbol_191); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_276);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_277.setName("UniqueCollection");
		//symbol_277.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_277.setElementType(symbol_39);
		symbol_277.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_862 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_862.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_863 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_863.setFormal(symbol_147);	
				symbol_863.setActual(symbol_39);	
				symbol_862.getParameterSubstitutions().add(symbol_863);
			}
			symbol_277.getTemplateBindings().add(symbol_862);
		}
		symbol_277.getSuperClasses().add(symbol_36); // ocl!Collection{T}
		symbol_150.getOwnedTypes().add(symbol_277);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_278.setName("UniqueCollection");
		//symbol_278.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_278.setElementType(symbol_80);
		symbol_278.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_864 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_864.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_865 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_865.setFormal(symbol_147);	
				symbol_865.setActual(symbol_80);	
				symbol_864.getParameterSubstitutions().add(symbol_865);
			}
			symbol_278.getTemplateBindings().add(symbol_864);
		}
		symbol_278.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OclAny]
		symbol_150.getOwnedTypes().add(symbol_278);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_279.setName("UniqueCollection");
		//symbol_279.setMoniker("ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_279.setElementType(symbol_29);
		symbol_279.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_866 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_866.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_867 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_867.setFormal(symbol_147);	
				symbol_867.setActual(symbol_29);	
				symbol_866.getParameterSubstitutions().add(symbol_867);
			}
			symbol_279.getTemplateBindings().add(symbol_866);
		}
		symbol_279.getSuperClasses().add(symbol_180); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_279);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_280.setName("UniqueCollection");
		//symbol_280.setMoniker("ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_280.setElementType(symbol_107);
		symbol_280.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_868 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_868.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_869 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_869.setFormal(symbol_147);	
				symbol_869.setActual(symbol_107);	
				symbol_868.getParameterSubstitutions().add(symbol_869);
			}
			symbol_280.getTemplateBindings().add(symbol_868);
		}
		symbol_280.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_280);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_281.setName("UniqueCollection");
		//symbol_281.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_281.setElementType(symbol_139);
		symbol_281.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_870 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_870.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_871 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_871.setFormal(symbol_147);	
				symbol_871.setActual(symbol_139);	
				symbol_870.getParameterSubstitutions().add(symbol_871);
			}
			symbol_281.getTemplateBindings().add(symbol_870);
		}
		symbol_281.getSuperClasses().add(symbol_164); // ocl!Collection[ocl!Set{T}?T]
		symbol_150.getOwnedTypes().add(symbol_281);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_282.setName("UniqueCollection");
		//symbol_282.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_282.setElementType(symbol_272);
		symbol_282.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_872 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_872.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_873 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_873.setFormal(symbol_147);	
				symbol_873.setActual(symbol_272);	
				symbol_872.getParameterSubstitutions().add(symbol_873);
			}
			symbol_282.getTemplateBindings().add(symbol_872);
		}
		symbol_282.getSuperClasses().add(symbol_187); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_150.getOwnedTypes().add(symbol_282);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_283.setName("UniqueCollection");
		//symbol_283.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_283.setElementType(symbol_111);
		symbol_283.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_874 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_874.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_875 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_875.setFormal(symbol_147);	
				symbol_875.setActual(symbol_111);	
				symbol_874.getParameterSubstitutions().add(symbol_875);
			}
			symbol_283.getTemplateBindings().add(symbol_874);
		}
		symbol_283.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_283);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_284.setName("UniqueCollection");
		//symbol_284.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_284.setElementType(symbol_121);
		symbol_284.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_876 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_876.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_877 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_877.setFormal(symbol_147);	
				symbol_877.setActual(symbol_121);	
				symbol_876.getParameterSubstitutions().add(symbol_877);
			}
			symbol_284.getTemplateBindings().add(symbol_876);
		}
		symbol_284.getSuperClasses().add(symbol_185); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_150.getOwnedTypes().add(symbol_284);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_285.setName("UniqueCollection");
		//symbol_285.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_285.setElementType(symbol_142);
		symbol_285.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_878 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_878.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_879 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_879.setFormal(symbol_147);	
				symbol_879.setActual(symbol_142);	
				symbol_878.getParameterSubstitutions().add(symbol_879);
			}
			symbol_285.getTemplateBindings().add(symbol_878);
		}
		symbol_285.getSuperClasses().add(symbol_169); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_285);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_286.setName("UniqueCollection");
		//symbol_286.setMoniker("ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_286.setElementType(symbol_100);
		symbol_286.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_880 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_880.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_881 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_881.setFormal(symbol_147);	
				symbol_881.setActual(symbol_100);	
				symbol_880.getParameterSubstitutions().add(symbol_881);
			}
			symbol_286.getTemplateBindings().add(symbol_880);
		}
		symbol_286.getSuperClasses().add(symbol_168); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_286);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		//
		symbol_287.setName("UniqueCollection");
		//symbol_287.setMoniker("ocl!UniqueCollection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]");
		symbol_287.setElementType(symbol_157);
		symbol_287.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_882 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_882.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_883 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_883.setFormal(symbol_147);	
				symbol_883.setActual(symbol_157);	
				symbol_882.getParameterSubstitutions().add(symbol_883);
			}
			symbol_287.getTemplateBindings().add(symbol_882);
		}
		symbol_287.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!Classifier[ocl!Classifier{T}!oclContents{U}()?U]]
		symbol_150.getOwnedTypes().add(symbol_287);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_288.setName("UniqueCollection");
		//symbol_288.setMoniker("ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_288.setElementType(symbol_22);
		symbol_288.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_884 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_884.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_885 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_885.setFormal(symbol_147);	
				symbol_885.setActual(symbol_22);	
				symbol_884.getParameterSubstitutions().add(symbol_885);
			}
			symbol_288.getTemplateBindings().add(symbol_884);
		}
		symbol_288.getSuperClasses().add(symbol_184); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_150.getOwnedTypes().add(symbol_288);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_289.setName("UniqueCollection");
		//symbol_289.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_289.setElementType(symbol_69);
		symbol_289.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_886 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_886.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_887 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_887.setFormal(symbol_147);	
				symbol_887.setActual(symbol_69);	
				symbol_886.getParameterSubstitutions().add(symbol_887);
			}
			symbol_289.getTemplateBindings().add(symbol_886);
		}
		symbol_289.getSuperClasses().add(symbol_186); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_150.getOwnedTypes().add(symbol_289);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_290.setName("UniqueCollection");
		//symbol_290.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_290.setElementType(symbol_124);
		symbol_290.setUnspecializedElement(symbol_145);
		{
			TemplateBinding symbol_888 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_888.setSignature(symbol_146);
			{
				TemplateParameterSubstitution symbol_889 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_889.setFormal(symbol_147);	
				symbol_889.setActual(symbol_124);	
				symbol_888.getParameterSubstitutions().add(symbol_889);
			}
			symbol_290.getTemplateBindings().add(symbol_888);
		}
		symbol_290.getSuperClasses().add(symbol_192); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_150.getOwnedTypes().add(symbol_290);
		symbol_1.getNestedPackages().add(symbol_150);
		return symbol_1;
	}
}
