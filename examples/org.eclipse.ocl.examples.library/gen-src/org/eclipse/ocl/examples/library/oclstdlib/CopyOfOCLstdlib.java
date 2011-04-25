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
 * $Id: CopyOfOCLstdlib.java,v 1.1 2011/04/25 09:48:57 ewillink Exp $
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
public class CopyOfOCLstdlib extends XMLResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Standard Library.
	 */
	public static final CopyOfOCLstdlib INSTANCE = new CopyOfOCLstdlib();
	
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
	
	private CopyOfOCLstdlib() {
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
		
		
		CollectionType symbol_30 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection{T}
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}?T
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_46 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_47 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_49 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_50 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_52 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_53 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
		
		
		Class symbol_55 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration
		TemplateSignature symbol_56 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Enumeration!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_57 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration!allInstances{OclSelf}()?OclSelf
		
		
		PrimitiveType symbol_59 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_60 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection{T}
		TemplateSignature symbol_61 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_62 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_63 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_64 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_65 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_66 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_67 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_68 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_69 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_70 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection{T}
		TemplateSignature symbol_71 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_72 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_73 = PivotFactory.eINSTANCE.createClass(); // ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_74 = PivotFactory.eINSTANCE.createAnyType(); // ocl!OclAny
		TemplateSignature symbol_75 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsSet{OclSelf}()!
		TypeTemplateParameter symbol_76 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_78 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsType{T}(ocl!Classifier[T])!
		TypeTemplateParameter symbol_79 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_80 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsType{T}(ocl!Classifier[T])?T
		
		TemplateSignature symbol_81 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])!
		TypeTemplateParameter symbol_82 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_83 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T
		
		TemplateSignature symbol_84 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])!
		TypeTemplateParameter symbol_85 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T
		
		TemplateSignature symbol_87 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclType{OclSelf}()!
		TypeTemplateParameter symbol_88 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclType{OclSelf}()?OclSelf
		
		
		InvalidType symbol_90 = PivotFactory.eINSTANCE.createInvalidType(); // ocl!OclInvalid
		Property symbol_91 = PivotFactory.eINSTANCE.createProperty(); // ocl::OclInvalid::oclBadProperty ocl!OclInvalid!oclBadProperty
		TemplateSignature symbol_92 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclInvalid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_93 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_94 = PivotFactory.eINSTANCE.createClass(); // ocl!OclInvalid!allInstances{OclSelf}()?OclSelf
		
		
		Class symbol_95 = PivotFactory.eINSTANCE.createClass(); // ocl!OclMessage
		
		Class symbol_96 = PivotFactory.eINSTANCE.createClass(); // ocl!OclState
		
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // ocl!OclTuple
		
		VoidType symbol_98 = PivotFactory.eINSTANCE.createVoidType(); // ocl!OclVoid
		TemplateSignature symbol_99 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclVoid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_100 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_101 = PivotFactory.eINSTANCE.createClass(); // ocl!OclVoid!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_102 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection{T}
		TemplateSignature symbol_103 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_104 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_105 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_106 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_107 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_108 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_109 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_110 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_111 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_112 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet{T}
		TemplateSignature symbol_113 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_114 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_115 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}?T
		
		TemplateSignature symbol_116 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!flatten{T2}()!
		TypeTemplateParameter symbol_117 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_118 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_119 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_120 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{T}(ocl!Classifier[T])!
		TypeTemplateParameter symbol_121 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_122 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{T}(ocl!Classifier[T])?T
		
		
		SequenceType symbol_123 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence{T}
		TemplateSignature symbol_124 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!
		TypeTemplateParameter symbol_125 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_126 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}?T
		
		TemplateSignature symbol_127 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_128 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_129 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_130 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set{T}
		TemplateSignature symbol_131 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!
		TypeTemplateParameter symbol_132 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_133 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}?T
		
		TemplateSignature symbol_134 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_135 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_136 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_137 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection{T}
		TemplateSignature symbol_139 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_140 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_141 = PivotFactory.eINSTANCE.createClass(); // ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_142 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_143 = PivotFactory.eINSTANCE.createPackage(); // $orphanage
		Class symbol_144 = PivotFactory.eINSTANCE.createClass(); // $orphanage!$orphanage
		
		BagType symbol_145 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_146 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}?T]
		
		BagType symbol_147 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Collection{T}?T]
		
		BagType symbol_148 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		BagType symbol_149 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		
		Class symbol_150 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
		
		Class symbol_151 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier[ocl!OclAny!oclAsType{T}(ocl!Classifier[T])?T]
		
		Class symbol_152 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
		
		Class symbol_153 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
		
		Class symbol_154 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier[Real!oclAsType{T}(ocl!Classifier[T])?T]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier{T}]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		LambdaType symbol_185 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Sequence{T}?T()Boolean
		
		LambdaType symbol_186 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_187 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedSet{T}?T()Boolean
		
		LambdaType symbol_188 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_189 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		
		LambdaType symbol_190 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_191 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_192 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()Boolean
		
		LambdaType symbol_193 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_194 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Bag{T}?T()Boolean
		
		LambdaType symbol_195 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_196 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		
		LambdaType symbol_197 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_198 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		
		LambdaType symbol_199 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Set{T}?T()Boolean
		
		LambdaType symbol_200 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!OclAny
		
		CollectionType symbol_201 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_202 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_203 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_204 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier{T}]
		
		CollectionType symbol_205 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_206 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_207 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_208 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_209 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_216 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_217 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_218 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_219 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_220 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_221 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_222 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_223 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_224 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_225 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_226 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_227 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_228 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_229 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_230 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		CollectionType symbol_231 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_232 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_233 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_234 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_235 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_236 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_237 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_238 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_239 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		OrderedSetType symbol_240 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_241 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_242 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		OrderedSetType symbol_243 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		SequenceType symbol_244 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_245 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_246 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_247 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_248 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_249 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_250 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SetType symbol_251 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_252 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_253 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_254 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_255 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		SetType symbol_256 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		SetType symbol_257 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_258 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_259 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_260 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_261 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_262 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier{T}]
		
		SetType symbol_263 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_264 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		TupleType symbol_265 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_266 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_267 = PivotFactory.eINSTANCE.createProperty(); // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_268 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_269 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		CollectionType symbol_270 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_271 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_272 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_273 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_274 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier{T}]
		
		CollectionType symbol_275 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_276 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_277 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_278 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		
		CollectionType symbol_279 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_280 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_281 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_282 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_283 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_284 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		

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
		symbol_12.getSuperClasses().add(symbol_216); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_219); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("<>");
			//symbol_285.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_285.setType(symbol_19);  // Boolean
			
			Parameter symbol_286 = PivotFactory.eINSTANCE.createParameter();
			symbol_286.setName("object2");
			//symbol_286.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_286.setType(symbol_74);  // ocl!OclAny
			
			symbol_285.getOwnedParameters().add(symbol_286);
			symbol_285.setPrecedence(symbol_7);
			symbol_285.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_285);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_287 = PivotFactory.eINSTANCE.createOperation();
			symbol_287.setName("=");
			//symbol_287.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_287.setType(symbol_19);  // Boolean
			
			Parameter symbol_288 = PivotFactory.eINSTANCE.createParameter();
			symbol_288.setName("object2");
			//symbol_288.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_288.setType(symbol_74);  // ocl!OclAny
			
			symbol_287.getOwnedParameters().add(symbol_288);
			symbol_287.setPrecedence(symbol_7);
			symbol_287.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_287);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_289 = PivotFactory.eINSTANCE.createOperation();
			symbol_289.setName("excluding");
			//symbol_289.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_289.setType(symbol_146);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("object");
			//symbol_290.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_290.setType(symbol_74);  // ocl!OclAny
			
			symbol_289.getOwnedParameters().add(symbol_290);
			symbol_289.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_289);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_291 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_291.setOwnedTemplateSignature(symbol_16);
			symbol_291.setName("flatten");
			//symbol_291.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_291.setType(symbol_149);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_292 = PivotFactory.eINSTANCE.createOperation();
			symbol_292.setName("including");
			//symbol_292.setMoniker("ocl!Bag{T}!including(T)");
			symbol_292.setType(symbol_146);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_293 = PivotFactory.eINSTANCE.createParameter();
			symbol_293.setName("object");
			//symbol_293.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_293.setType(symbol_15);  // ocl!Bag{T}?T
			
			symbol_292.getOwnedParameters().add(symbol_293);
			symbol_292.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_292);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_294 = PivotFactory.eINSTANCE.createIteration();
			symbol_294.setName("reject");
			//symbol_294.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)");
			symbol_294.setType(symbol_146);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("i");
			symbol_295.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_294.getOwnedIterators().add(symbol_295);
			Parameter symbol_296 = PivotFactory.eINSTANCE.createParameter();
			symbol_296.setName("body");
			//symbol_296.setMoniker("ocl!Bag{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_296.setType(symbol_194);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_294.getOwnedParameters().add(symbol_296);
			symbol_294.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_294);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_297 = PivotFactory.eINSTANCE.createIteration();
			symbol_297.setName("select");
			//symbol_297.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)");
			symbol_297.setType(symbol_146);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("i");
			symbol_298.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_297.getOwnedIterators().add(symbol_298);
			Parameter symbol_299 = PivotFactory.eINSTANCE.createParameter();
			symbol_299.setName("body");
			//symbol_299.setMoniker("ocl!Bag{T}!select(T|Lambda~T()Boolean)!body");
			symbol_299.setType(symbol_194);  // Lambda~ocl!Bag{T}?T()Boolean
			
			symbol_297.getOwnedParameters().add(symbol_299);
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_297);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_300 = PivotFactory.eINSTANCE.createOperation();
			symbol_300.setName("<>");
			//symbol_300.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_300.setType(symbol_19);  // Boolean
			
			Parameter symbol_301 = PivotFactory.eINSTANCE.createParameter();
			symbol_301.setName("object2");
			//symbol_301.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_301.setType(symbol_74);  // ocl!OclAny
			
			symbol_300.getOwnedParameters().add(symbol_301);
			symbol_300.setPrecedence(symbol_7);
			symbol_300.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_300);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_302 = PivotFactory.eINSTANCE.createOperation();
			symbol_302.setName("=");
			//symbol_302.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_302.setType(symbol_19);  // Boolean
			
			Parameter symbol_303 = PivotFactory.eINSTANCE.createParameter();
			symbol_303.setName("object2");
			//symbol_303.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_303.setType(symbol_74);  // ocl!OclAny
			
			symbol_302.getOwnedParameters().add(symbol_303);
			symbol_302.setPrecedence(symbol_7);
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances{OclSelf}()
			Operation symbol_304 = PivotFactory.eINSTANCE.createOperation();
			symbol_22.setName("OclSelf");
			symbol_21.setOwnedParameteredElement(symbol_22);
			symbol_20.getOwnedParameters().add(symbol_21);
			
			symbol_304.setOwnedTemplateSignature(symbol_20);
			symbol_304.setName("allInstances");
			//symbol_304.setMoniker("Boolean!allInstances{OclSelf}()");
			symbol_304.setType(symbol_251);  // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
			
			symbol_304.setIsStatic(true);
			symbol_304.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_304);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_305 = PivotFactory.eINSTANCE.createOperation();
			symbol_305.setName("and");
			//symbol_305.setMoniker("Boolean!and(Boolean)");
			symbol_305.setType(symbol_19);  // Boolean
			
			Parameter symbol_306 = PivotFactory.eINSTANCE.createParameter();
			symbol_306.setName("b");
			//symbol_306.setMoniker("Boolean!and(Boolean)!b");
			symbol_306.setType(symbol_19);  // Boolean
			
			symbol_305.getOwnedParameters().add(symbol_306);
			symbol_305.setPrecedence(symbol_8);
			symbol_305.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_305);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_307 = PivotFactory.eINSTANCE.createOperation();
			symbol_307.setName("implies");
			//symbol_307.setMoniker("Boolean!implies(Boolean)");
			symbol_307.setType(symbol_19);  // Boolean
			
			Parameter symbol_308 = PivotFactory.eINSTANCE.createParameter();
			symbol_308.setName("b");
			//symbol_308.setMoniker("Boolean!implies(Boolean)!b");
			symbol_308.setType(symbol_19);  // Boolean
			
			symbol_307.getOwnedParameters().add(symbol_308);
			symbol_307.setPrecedence(symbol_11);
			symbol_307.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_307);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_309 = PivotFactory.eINSTANCE.createOperation();
			symbol_309.setName("not");
			//symbol_309.setMoniker("Boolean!not()");
			symbol_309.setType(symbol_19);  // Boolean
			
			symbol_309.setPrecedence(symbol_3);
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_310 = PivotFactory.eINSTANCE.createOperation();
			symbol_310.setName("or");
			//symbol_310.setMoniker("Boolean!or(Boolean)");
			symbol_310.setType(symbol_19);  // Boolean
			
			Parameter symbol_311 = PivotFactory.eINSTANCE.createParameter();
			symbol_311.setName("b");
			//symbol_311.setMoniker("Boolean!or(Boolean)!b");
			symbol_311.setType(symbol_19);  // Boolean
			
			symbol_310.getOwnedParameters().add(symbol_311);
			symbol_310.setPrecedence(symbol_9);
			symbol_310.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_310);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_312 = PivotFactory.eINSTANCE.createOperation();
			symbol_312.setName("toString");
			//symbol_312.setMoniker("Boolean!toString()");
			symbol_312.setType(symbol_137);  // String
			
			symbol_312.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_312);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_313 = PivotFactory.eINSTANCE.createOperation();
			symbol_313.setName("xor");
			//symbol_313.setMoniker("Boolean!xor(Boolean)");
			symbol_313.setType(symbol_19);  // Boolean
			
			Parameter symbol_314 = PivotFactory.eINSTANCE.createParameter();
			symbol_314.setName("b");
			//symbol_314.setMoniker("Boolean!xor(Boolean)!b");
			symbol_314.setType(symbol_19);  // Boolean
			
			symbol_313.getOwnedParameters().add(symbol_314);
			symbol_313.setPrecedence(symbol_10);
			symbol_313.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_313);
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
		symbol_23.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::Classifier::allInstances() ocl!Classifier{T}!allInstances{OclSelf}()
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_29.setName("OclSelf");
			symbol_28.setOwnedParameteredElement(symbol_29);
			symbol_27.getOwnedParameters().add(symbol_28);
			
			symbol_315.setOwnedTemplateSignature(symbol_27);
			symbol_315.setName("allInstances");
			//symbol_315.setMoniker("ocl!Classifier{T}!allInstances{OclSelf}()");
			symbol_315.setType(symbol_258);  // ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
			
			symbol_315.setIsStatic(true);
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Classifier::oclContainer() ocl!Classifier{T}!oclContainer()
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("oclContainer");
			//symbol_316.setMoniker("ocl!Classifier{T}!oclContainer()");
			symbol_316.setType(symbol_23);  // ocl!Classifier{T}
			
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Classifier::oclContents() ocl!Classifier{T}!oclContents()
			Operation symbol_317 = PivotFactory.eINSTANCE.createOperation();
			symbol_317.setName("oclContents");
			//symbol_317.setMoniker("ocl!Classifier{T}!oclContents()");
			symbol_317.setType(symbol_262);  // ocl!Set[ocl!Classifier{T}]
			
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_317);
		}
		symbol_1.getOwnedTypes().add(symbol_23);
		//
		// ocl::Collection ocl!Collection{T}
		//
		symbol_30.setName("Collection");
		//symbol_30.setMoniker("ocl!Collection{T}");
		symbol_30.setElementType(symbol_33);
		symbol_33.setName("T");
		symbol_32.setOwnedParameteredElement(symbol_33);
		symbol_31.getOwnedParameters().add(symbol_32);
		
		symbol_30.setOwnedTemplateSignature(symbol_31);
		symbol_30.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::Collection::<>() ocl!Collection{T}!<>(ocl!OclAny)
			Operation symbol_318 = PivotFactory.eINSTANCE.createOperation();
			symbol_318.setName("<>");
			//symbol_318.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_318.setType(symbol_19);  // Boolean
			
			Parameter symbol_319 = PivotFactory.eINSTANCE.createParameter();
			symbol_319.setName("object2");
			//symbol_319.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_319.setType(symbol_74);  // ocl!OclAny
			
			symbol_318.getOwnedParameters().add(symbol_319);
			symbol_318.setPrecedence(symbol_7);
			symbol_318.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_318);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_320 = PivotFactory.eINSTANCE.createOperation();
			symbol_320.setName("=");
			//symbol_320.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_320.setType(symbol_19);  // Boolean
			
			Parameter symbol_321 = PivotFactory.eINSTANCE.createParameter();
			symbol_321.setName("object2");
			//symbol_321.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_321.setType(symbol_74);  // ocl!OclAny
			
			symbol_320.getOwnedParameters().add(symbol_321);
			symbol_320.setPrecedence(symbol_7);
			symbol_320.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_320);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T|Lambda~T()Boolean)
			Iteration symbol_322 = PivotFactory.eINSTANCE.createIteration();
			symbol_322.setName("any");
			//symbol_322.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)");
			symbol_322.setType(symbol_33);  // ocl!Collection{T}?T
			
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("i");
			symbol_323.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_322.getOwnedIterators().add(symbol_323);
			Parameter symbol_324 = PivotFactory.eINSTANCE.createParameter();
			symbol_324.setName("body");
			//symbol_324.setMoniker("ocl!Collection{T}!any(T|Lambda~T()Boolean)!body");
			symbol_324.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_322.getOwnedParameters().add(symbol_324);
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_325 = PivotFactory.eINSTANCE.createOperation();
			symbol_325.setName("asBag");
			//symbol_325.setMoniker("ocl!Collection{T}!asBag()");
			symbol_325.setType(symbol_147);  // ocl!Bag[ocl!Collection{T}?T]
			
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_326.setName("asOrderedSet");
			//symbol_326.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_326.setType(symbol_239);  // ocl!OrderedSet[ocl!Collection{T}?T]
			
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_327 = PivotFactory.eINSTANCE.createOperation();
			symbol_327.setName("asSequence");
			//symbol_327.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_327.setType(symbol_249);  // ocl!Sequence[ocl!Collection{T}?T]
			
			symbol_327.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_327);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_328.setName("asSet");
			//symbol_328.setMoniker("ocl!Collection{T}!asSet()");
			symbol_328.setType(symbol_255);  // ocl!Set[ocl!Collection{T}?T]
			
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_329 = PivotFactory.eINSTANCE.createIteration();
			symbol_36.setName("V");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_329.setOwnedTemplateSignature(symbol_34);
			symbol_329.setName("collect");
			//symbol_329.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_329.setType(symbol_181);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_330 = PivotFactory.eINSTANCE.createParameter();
			symbol_330.setName("i");
			symbol_330.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_329.getOwnedIterators().add(symbol_330);
			Parameter symbol_331 = PivotFactory.eINSTANCE.createParameter();
			symbol_331.setName("body");
			//symbol_331.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_331.setType(symbol_193);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_329.getOwnedParameters().add(symbol_331);
			symbol_329.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_329);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_332 = PivotFactory.eINSTANCE.createIteration();
			symbol_39.setName("V");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_332.setOwnedTemplateSignature(symbol_37);
			symbol_332.setName("collectNested");
			//symbol_332.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_332.setType(symbol_183);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_333 = PivotFactory.eINSTANCE.createParameter();
			symbol_333.setName("i");
			symbol_333.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_332.getOwnedIterators().add(symbol_333);
			Parameter symbol_334 = PivotFactory.eINSTANCE.createParameter();
			symbol_334.setName("body");
			//symbol_334.setMoniker("ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_334.setType(symbol_195);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_332.getOwnedParameters().add(symbol_334);
			symbol_332.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_332);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_335 = PivotFactory.eINSTANCE.createOperation();
			symbol_335.setName("count");
			//symbol_335.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_335.setType(symbol_59);  // Integer
			
			Parameter symbol_336 = PivotFactory.eINSTANCE.createParameter();
			symbol_336.setName("object");
			//symbol_336.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_336.setType(symbol_74);  // ocl!OclAny
			
			symbol_335.getOwnedParameters().add(symbol_336);
			symbol_335.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_335);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_337 = PivotFactory.eINSTANCE.createOperation();
			symbol_337.setName("excludes");
			//symbol_337.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_337.setType(symbol_19);  // Boolean
			
			Parameter symbol_338 = PivotFactory.eINSTANCE.createParameter();
			symbol_338.setName("object");
			//symbol_338.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_338.setType(symbol_74);  // ocl!OclAny
			
			symbol_337.getOwnedParameters().add(symbol_338);
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_339 = PivotFactory.eINSTANCE.createOperation();
			symbol_42.setName("T2");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_339.setOwnedTemplateSignature(symbol_40);
			symbol_339.setName("excludesAll");
			//symbol_339.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_339.setType(symbol_19);  // Boolean
			
			Parameter symbol_340 = PivotFactory.eINSTANCE.createParameter();
			symbol_340.setName("c2");
			//symbol_340.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_340.setType(symbol_177);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_339.getOwnedParameters().add(symbol_340);
			symbol_339.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_339);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_341 = PivotFactory.eINSTANCE.createOperation();
			symbol_341.setName("excluding");
			//symbol_341.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_341.setType(symbol_183);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_342 = PivotFactory.eINSTANCE.createParameter();
			symbol_342.setName("object");
			//symbol_342.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_342.setType(symbol_74);  // ocl!OclAny
			
			symbol_341.getOwnedParameters().add(symbol_342);
			symbol_341.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_341);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T|Lambda~T()Boolean)
			Iteration symbol_343 = PivotFactory.eINSTANCE.createIteration();
			symbol_343.setName("exists");
			//symbol_343.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)");
			symbol_343.setType(symbol_19);  // Boolean
			
			Parameter symbol_344 = PivotFactory.eINSTANCE.createParameter();
			symbol_344.setName("i");
			symbol_344.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_343.getOwnedIterators().add(symbol_344);
			Parameter symbol_345 = PivotFactory.eINSTANCE.createParameter();
			symbol_345.setName("body");
			//symbol_345.setMoniker("ocl!Collection{T}!exists(T|Lambda~T()Boolean)!body");
			symbol_345.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_343.getOwnedParameters().add(symbol_345);
			symbol_343.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_343);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)
			Iteration symbol_346 = PivotFactory.eINSTANCE.createIteration();
			symbol_346.setName("exists");
			//symbol_346.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)");
			symbol_346.setType(symbol_19);  // Boolean
			
			Parameter symbol_347 = PivotFactory.eINSTANCE.createParameter();
			symbol_347.setName("i");
			symbol_347.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_346.getOwnedIterators().add(symbol_347);
			Parameter symbol_348 = PivotFactory.eINSTANCE.createParameter();
			symbol_348.setName("j");
			symbol_348.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_346.getOwnedIterators().add(symbol_348);
			Parameter symbol_349 = PivotFactory.eINSTANCE.createParameter();
			symbol_349.setName("body");
			//symbol_349.setMoniker("ocl!Collection{T}!exists(T,T|Lambda~T()Boolean)!body");
			symbol_349.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_346.getOwnedParameters().add(symbol_349);
			symbol_346.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_346);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_350 = PivotFactory.eINSTANCE.createOperation();
			symbol_45.setName("T2");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_350.setOwnedTemplateSignature(symbol_43);
			symbol_350.setName("flatten");
			//symbol_350.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_350.setType(symbol_158);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			
			symbol_350.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_350);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T|Lambda~T()Boolean)
			Iteration symbol_351 = PivotFactory.eINSTANCE.createIteration();
			symbol_351.setName("forAll");
			//symbol_351.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)");
			symbol_351.setType(symbol_19);  // Boolean
			
			Parameter symbol_352 = PivotFactory.eINSTANCE.createParameter();
			symbol_352.setName("i");
			symbol_352.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_351.getOwnedIterators().add(symbol_352);
			Parameter symbol_353 = PivotFactory.eINSTANCE.createParameter();
			symbol_353.setName("body");
			//symbol_353.setMoniker("ocl!Collection{T}!forAll(T|Lambda~T()Boolean)!body");
			symbol_353.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_351.getOwnedParameters().add(symbol_353);
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)
			Iteration symbol_354 = PivotFactory.eINSTANCE.createIteration();
			symbol_354.setName("forAll");
			//symbol_354.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)");
			symbol_354.setType(symbol_19);  // Boolean
			
			Parameter symbol_355 = PivotFactory.eINSTANCE.createParameter();
			symbol_355.setName("j");
			symbol_355.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_354.getOwnedIterators().add(symbol_355);
			Parameter symbol_356 = PivotFactory.eINSTANCE.createParameter();
			symbol_356.setName("i");
			symbol_356.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_354.getOwnedIterators().add(symbol_356);
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("body");
			//symbol_357.setMoniker("ocl!Collection{T}!forAll(T,T|Lambda~T()Boolean)!body");
			symbol_357.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_354.getOwnedParameters().add(symbol_357);
			symbol_354.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_354);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_358 = PivotFactory.eINSTANCE.createOperation();
			symbol_358.setName("includes");
			//symbol_358.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_358.setType(symbol_19);  // Boolean
			
			Parameter symbol_359 = PivotFactory.eINSTANCE.createParameter();
			symbol_359.setName("object");
			//symbol_359.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_359.setType(symbol_74);  // ocl!OclAny
			
			symbol_358.getOwnedParameters().add(symbol_359);
			symbol_358.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_358);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_360 = PivotFactory.eINSTANCE.createOperation();
			symbol_48.setName("T2");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_360.setOwnedTemplateSignature(symbol_46);
			symbol_360.setName("includesAll");
			//symbol_360.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_360.setType(symbol_19);  // Boolean
			
			Parameter symbol_361 = PivotFactory.eINSTANCE.createParameter();
			symbol_361.setName("c2");
			//symbol_361.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_361.setType(symbol_171);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			
			symbol_360.getOwnedParameters().add(symbol_361);
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_362 = PivotFactory.eINSTANCE.createOperation();
			symbol_362.setName("including");
			//symbol_362.setMoniker("ocl!Collection{T}!including(T)");
			symbol_362.setType(symbol_183);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_363 = PivotFactory.eINSTANCE.createParameter();
			symbol_363.setName("object");
			//symbol_363.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_363.setType(symbol_33);  // ocl!Collection{T}?T
			
			symbol_362.getOwnedParameters().add(symbol_363);
			symbol_362.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_362);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("isEmpty");
			//symbol_364.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_364.setType(symbol_19);  // Boolean
			
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_364);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)
			Iteration symbol_365 = PivotFactory.eINSTANCE.createIteration();
			symbol_365.setName("isUnique");
			//symbol_365.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)");
			symbol_365.setType(symbol_19);  // Boolean
			
			Parameter symbol_366 = PivotFactory.eINSTANCE.createParameter();
			symbol_366.setName("i");
			symbol_366.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_365.getOwnedIterators().add(symbol_366);
			Parameter symbol_367 = PivotFactory.eINSTANCE.createParameter();
			symbol_367.setName("body");
			//symbol_367.setMoniker("ocl!Collection{T}!isUnique(T|Lambda~T()ocl!OclAny)!body");
			symbol_367.setType(symbol_200);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_365.getOwnedParameters().add(symbol_367);
			symbol_365.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_365);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_368 = PivotFactory.eINSTANCE.createIteration();
			symbol_51.setName("Tacc");
			symbol_50.setOwnedParameteredElement(symbol_51);
			symbol_49.getOwnedParameters().add(symbol_50);
			
			symbol_368.setOwnedTemplateSignature(symbol_49);
			symbol_368.setName("iterate");
			//symbol_368.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_368.setType(symbol_51);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_369 = PivotFactory.eINSTANCE.createParameter();
			symbol_369.setName("i");
			symbol_369.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_368.getOwnedIterators().add(symbol_369);
			Parameter symbol_370 = PivotFactory.eINSTANCE.createParameter();
			symbol_370.setName("acc");
			symbol_370.setType(symbol_51);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_368.getOwnedAccumulators().add(symbol_370);
			symbol_368.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_368);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("max");
			//symbol_371.setMoniker("ocl!Collection{T}!max()");
			symbol_371.setType(symbol_33);  // ocl!Collection{T}?T
			
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_372.setName("min");
			//symbol_372.setMoniker("ocl!Collection{T}!min()");
			symbol_372.setType(symbol_33);  // ocl!Collection{T}?T
			
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_373 = PivotFactory.eINSTANCE.createOperation();
			symbol_373.setName("notEmpty");
			//symbol_373.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_373.setType(symbol_19);  // Boolean
			
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_373);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T|Lambda~T()Boolean)
			Iteration symbol_374 = PivotFactory.eINSTANCE.createIteration();
			symbol_374.setName("one");
			//symbol_374.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)");
			symbol_374.setType(symbol_19);  // Boolean
			
			Parameter symbol_375 = PivotFactory.eINSTANCE.createParameter();
			symbol_375.setName("i");
			symbol_375.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_374.getOwnedIterators().add(symbol_375);
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("body");
			//symbol_376.setMoniker("ocl!Collection{T}!one(T|Lambda~T()Boolean)!body");
			symbol_376.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_374.getOwnedParameters().add(symbol_376);
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_374);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_54.setName("T2");
			symbol_53.setOwnedParameteredElement(symbol_54);
			symbol_52.getOwnedParameters().add(symbol_53);
			
			symbol_377.setOwnedTemplateSignature(symbol_52);
			symbol_377.setName("product");
			//symbol_377.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_377.setType(symbol_256);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("c2");
			//symbol_378.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_378.setType(symbol_160);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			
			symbol_377.getOwnedParameters().add(symbol_378);
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_377);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_379 = PivotFactory.eINSTANCE.createIteration();
			symbol_379.setName("reject");
			//symbol_379.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)");
			symbol_379.setType(symbol_183);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("i");
			symbol_380.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_379.getOwnedIterators().add(symbol_380);
			Parameter symbol_381 = PivotFactory.eINSTANCE.createParameter();
			symbol_381.setName("body");
			//symbol_381.setMoniker("ocl!Collection{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_381.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_379.getOwnedParameters().add(symbol_381);
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_382 = PivotFactory.eINSTANCE.createIteration();
			symbol_382.setName("select");
			//symbol_382.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)");
			symbol_382.setType(symbol_183);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_383 = PivotFactory.eINSTANCE.createParameter();
			symbol_383.setName("i");
			symbol_383.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_382.getOwnedIterators().add(symbol_383);
			Parameter symbol_384 = PivotFactory.eINSTANCE.createParameter();
			symbol_384.setName("body");
			//symbol_384.setMoniker("ocl!Collection{T}!select(T|Lambda~T()Boolean)!body");
			symbol_384.setType(symbol_192);  // Lambda~ocl!Collection{T}?T()Boolean
			
			symbol_382.getOwnedParameters().add(symbol_384);
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_382);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_385 = PivotFactory.eINSTANCE.createOperation();
			symbol_385.setName("size");
			//symbol_385.setMoniker("ocl!Collection{T}!size()");
			symbol_385.setType(symbol_59);  // Integer
			
			symbol_385.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_385);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_386 = PivotFactory.eINSTANCE.createIteration();
			symbol_386.setName("sortedBy");
			//symbol_386.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_386.setType(symbol_233);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_387 = PivotFactory.eINSTANCE.createParameter();
			symbol_387.setName("i");
			symbol_387.setType(symbol_33);  // ocl!Collection{T}?T
			symbol_386.getOwnedIterators().add(symbol_387);
			Parameter symbol_388 = PivotFactory.eINSTANCE.createParameter();
			symbol_388.setName("body");
			//symbol_388.setMoniker("ocl!Collection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_388.setType(symbol_200);  // Lambda~ocl!Collection{T}?T()ocl!OclAny
			
			symbol_386.getOwnedParameters().add(symbol_388);
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_389 = PivotFactory.eINSTANCE.createOperation();
			symbol_389.setName("sum");
			//symbol_389.setMoniker("ocl!Collection{T}!sum()");
			symbol_389.setType(symbol_33);  // ocl!Collection{T}?T
			
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_30.getOwnedOperations().add(symbol_389);
		}
		symbol_1.getOwnedTypes().add(symbol_30);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_55.setName("Enumeration");
		//symbol_55.setMoniker("ocl!Enumeration");
		symbol_55.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances{OclSelf}()
			Operation symbol_390 = PivotFactory.eINSTANCE.createOperation();
			symbol_58.setName("OclSelf");
			symbol_57.setOwnedParameteredElement(symbol_58);
			symbol_56.getOwnedParameters().add(symbol_57);
			
			symbol_390.setOwnedTemplateSignature(symbol_56);
			symbol_390.setName("allInstances");
			//symbol_390.setMoniker("ocl!Enumeration!allInstances{OclSelf}()");
			symbol_390.setType(symbol_254);  // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
			
			symbol_390.setIsStatic(true);
			symbol_390.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_390);
		}
		symbol_1.getOwnedTypes().add(symbol_55);
		//
		// ocl::Integer Integer
		//
		symbol_59.setName("Integer");
		//symbol_59.setMoniker("Integer");
		symbol_59.getSuperClasses().add(symbol_119); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_391 = PivotFactory.eINSTANCE.createOperation();
			symbol_391.setName("*");
			//symbol_391.setMoniker("Integer!*(Integer)");
			symbol_391.setType(symbol_59);  // Integer
			
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("i");
			//symbol_392.setMoniker("Integer!*(Integer)!i");
			symbol_392.setType(symbol_59);  // Integer
			
			symbol_391.getOwnedParameters().add(symbol_392);
			symbol_391.setPrecedence(symbol_4);
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_393 = PivotFactory.eINSTANCE.createOperation();
			symbol_393.setName("+");
			//symbol_393.setMoniker("Integer!+(Integer)");
			symbol_393.setType(symbol_59);  // Integer
			
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("i");
			//symbol_394.setMoniker("Integer!+(Integer)!i");
			symbol_394.setType(symbol_59);  // Integer
			
			symbol_393.getOwnedParameters().add(symbol_394);
			symbol_393.setPrecedence(symbol_5);
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_393);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_395 = PivotFactory.eINSTANCE.createOperation();
			symbol_395.setName("-");
			//symbol_395.setMoniker("Integer!-()");
			symbol_395.setType(symbol_59);  // Integer
			
			symbol_395.setPrecedence(symbol_3);
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_395);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_396 = PivotFactory.eINSTANCE.createOperation();
			symbol_396.setName("-");
			//symbol_396.setMoniker("Integer!-(Integer)");
			symbol_396.setType(symbol_59);  // Integer
			
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("i");
			//symbol_397.setMoniker("Integer!-(Integer)!i");
			symbol_397.setType(symbol_59);  // Integer
			
			symbol_396.getOwnedParameters().add(symbol_397);
			symbol_396.setPrecedence(symbol_5);
			symbol_396.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_396);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_398 = PivotFactory.eINSTANCE.createOperation();
			symbol_398.setName("/");
			//symbol_398.setMoniker("Integer!/(Integer)");
			symbol_398.setType(symbol_119);  // Real
			
			Parameter symbol_399 = PivotFactory.eINSTANCE.createParameter();
			symbol_399.setName("i");
			//symbol_399.setMoniker("Integer!/(Integer)!i");
			symbol_399.setType(symbol_59);  // Integer
			
			symbol_398.getOwnedParameters().add(symbol_399);
			symbol_398.setPrecedence(symbol_4);
			symbol_398.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_398);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_400 = PivotFactory.eINSTANCE.createOperation();
			symbol_400.setName("abs");
			//symbol_400.setMoniker("Integer!abs()");
			symbol_400.setType(symbol_59);  // Integer
			
			symbol_400.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_400);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("div");
			//symbol_401.setMoniker("Integer!div(Integer)");
			symbol_401.setType(symbol_59);  // Integer
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("i");
			//symbol_402.setMoniker("Integer!div(Integer)!i");
			symbol_402.setType(symbol_59);  // Integer
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_403 = PivotFactory.eINSTANCE.createOperation();
			symbol_403.setName("max");
			//symbol_403.setMoniker("Integer!max(Integer)");
			symbol_403.setType(symbol_59);  // Integer
			
			Parameter symbol_404 = PivotFactory.eINSTANCE.createParameter();
			symbol_404.setName("i");
			//symbol_404.setMoniker("Integer!max(Integer)!i");
			symbol_404.setType(symbol_59);  // Integer
			
			symbol_403.getOwnedParameters().add(symbol_404);
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_403);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("min");
			//symbol_405.setMoniker("Integer!min(Integer)");
			symbol_405.setType(symbol_59);  // Integer
			
			Parameter symbol_406 = PivotFactory.eINSTANCE.createParameter();
			symbol_406.setName("i");
			//symbol_406.setMoniker("Integer!min(Integer)!i");
			symbol_406.setType(symbol_59);  // Integer
			
			symbol_405.getOwnedParameters().add(symbol_406);
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_405);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_407 = PivotFactory.eINSTANCE.createOperation();
			symbol_407.setName("mod");
			//symbol_407.setMoniker("Integer!mod(Integer)");
			symbol_407.setType(symbol_59);  // Integer
			
			Parameter symbol_408 = PivotFactory.eINSTANCE.createParameter();
			symbol_408.setName("i");
			//symbol_408.setMoniker("Integer!mod(Integer)!i");
			symbol_408.setType(symbol_59);  // Integer
			
			symbol_407.getOwnedParameters().add(symbol_408);
			symbol_407.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_407);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_409.setName("toString");
			//symbol_409.setMoniker("Integer!toString()");
			symbol_409.setType(symbol_137);  // String
			
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_409);
		}
		symbol_1.getOwnedTypes().add(symbol_59);
		//
		// ocl::NonOrderedCollection ocl!NonOrderedCollection{T}
		//
		symbol_60.setName("NonOrderedCollection");
		//symbol_60.setMoniker("ocl!NonOrderedCollection{T}");
		symbol_60.setElementType(symbol_63);
		symbol_63.setName("T");
		symbol_62.setOwnedParameteredElement(symbol_63);
		symbol_61.getOwnedParameters().add(symbol_62);
		
		symbol_60.setOwnedTemplateSignature(symbol_61);
		symbol_60.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])
			Iteration symbol_410 = PivotFactory.eINSTANCE.createIteration();
			symbol_410.setName("closure");
			//symbol_410.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])");
			symbol_410.setType(symbol_252);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_411 = PivotFactory.eINSTANCE.createParameter();
			symbol_411.setName("i");
			symbol_411.setType(symbol_63);  // ocl!NonOrderedCollection{T}?T
			symbol_410.getOwnedIterators().add(symbol_411);
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("body");
			//symbol_412.setMoniker("ocl!NonOrderedCollection{T}!closure(T|Lambda~T()ocl!Set[T])!body");
			symbol_412.setType(symbol_198);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
			
			symbol_410.getOwnedParameters().add(symbol_412);
			symbol_410.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_410);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_413 = PivotFactory.eINSTANCE.createIteration();
			symbol_66.setName("V");
			symbol_65.setOwnedParameteredElement(symbol_66);
			symbol_64.getOwnedParameters().add(symbol_65);
			
			symbol_413.setOwnedTemplateSignature(symbol_64);
			symbol_413.setName("collect");
			//symbol_413.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_413.setType(symbol_148);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("i");
			symbol_414.setType(symbol_63);  // ocl!NonOrderedCollection{T}?T
			symbol_413.getOwnedIterators().add(symbol_414);
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("body");
			//symbol_415.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_415.setType(symbol_186);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_413.getOwnedParameters().add(symbol_415);
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_416 = PivotFactory.eINSTANCE.createIteration();
			symbol_69.setName("V");
			symbol_68.setOwnedParameteredElement(symbol_69);
			symbol_67.getOwnedParameters().add(symbol_68);
			
			symbol_416.setOwnedTemplateSignature(symbol_67);
			symbol_416.setName("collectNested");
			//symbol_416.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_416.setType(symbol_145);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("i");
			symbol_417.setType(symbol_63);  // ocl!NonOrderedCollection{T}?T
			symbol_416.getOwnedIterators().add(symbol_417);
			Parameter symbol_418 = PivotFactory.eINSTANCE.createParameter();
			symbol_418.setName("body");
			//symbol_418.setMoniker("ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_418.setType(symbol_191);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_416.getOwnedParameters().add(symbol_418);
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_419 = PivotFactory.eINSTANCE.createOperation();
			symbol_419.setName("intersection");
			//symbol_419.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_419.setType(symbol_145);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_420 = PivotFactory.eINSTANCE.createParameter();
			symbol_420.setName("bag");
			//symbol_420.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_420.setType(symbol_145);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_419.getOwnedParameters().add(symbol_420);
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("intersection");
			//symbol_421.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_421.setType(symbol_252);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_422 = PivotFactory.eINSTANCE.createParameter();
			symbol_422.setName("s");
			//symbol_422.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_422.setType(symbol_252);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_421.getOwnedParameters().add(symbol_422);
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_421);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("union");
			//symbol_423.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_423.setType(symbol_145);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("bag");
			//symbol_424.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_424.setType(symbol_145);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			symbol_423.getOwnedParameters().add(symbol_424);
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_423);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_425 = PivotFactory.eINSTANCE.createOperation();
			symbol_425.setName("union");
			//symbol_425.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_425.setType(symbol_252);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_426 = PivotFactory.eINSTANCE.createParameter();
			symbol_426.setName("s");
			//symbol_426.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_426.setType(symbol_252);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			symbol_425.getOwnedParameters().add(symbol_426);
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_60.getOwnedOperations().add(symbol_425);
		}
		symbol_1.getOwnedTypes().add(symbol_60);
		//
		// ocl::NonUniqueCollection ocl!NonUniqueCollection{T}
		//
		symbol_70.setName("NonUniqueCollection");
		//symbol_70.setMoniker("ocl!NonUniqueCollection{T}");
		symbol_70.setElementType(symbol_73);
		symbol_73.setName("T");
		symbol_72.setOwnedParameteredElement(symbol_73);
		symbol_71.getOwnedParameters().add(symbol_72);
		
		symbol_70.setOwnedTemplateSignature(symbol_71);
		symbol_70.getSuperClasses().add(symbol_169); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_427 = PivotFactory.eINSTANCE.createIteration();
			symbol_427.setName("sortedBy");
			//symbol_427.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_427.setType(symbol_246);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_428 = PivotFactory.eINSTANCE.createParameter();
			symbol_428.setName("i");
			symbol_428.setType(symbol_73);  // ocl!NonUniqueCollection{T}?T
			symbol_427.getOwnedIterators().add(symbol_428);
			Parameter symbol_429 = PivotFactory.eINSTANCE.createParameter();
			symbol_429.setName("body");
			//symbol_429.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_429.setType(symbol_196);  // Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
			
			symbol_427.getOwnedParameters().add(symbol_429);
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_427);
		}
		symbol_1.getOwnedTypes().add(symbol_70);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_74.setName("OclAny");
		//symbol_74.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_430 = PivotFactory.eINSTANCE.createOperation();
			symbol_430.setName("<>");
			//symbol_430.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_430.setType(symbol_19);  // Boolean
			
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("object2");
			//symbol_431.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_431.setType(symbol_74);  // ocl!OclAny
			
			symbol_430.getOwnedParameters().add(symbol_431);
			symbol_430.setPrecedence(symbol_7);
			symbol_430.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_430);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("=");
			//symbol_432.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_432.setType(symbol_19);  // Boolean
			
			Parameter symbol_433 = PivotFactory.eINSTANCE.createParameter();
			symbol_433.setName("object2");
			//symbol_433.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_433.setType(symbol_74);  // ocl!OclAny
			
			symbol_432.getOwnedParameters().add(symbol_433);
			symbol_432.setPrecedence(symbol_7);
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_434 = PivotFactory.eINSTANCE.createOperation();
			symbol_77.setName("OclSelf");
			symbol_76.setOwnedParameteredElement(symbol_77);
			symbol_75.getOwnedParameters().add(symbol_76);
			
			symbol_434.setOwnedTemplateSignature(symbol_75);
			symbol_434.setName("oclAsSet");
			//symbol_434.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_434.setType(symbol_263);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			
			symbol_434.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_434);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{T}(ocl!Classifier[T])
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_80.setName("T");
			symbol_79.setOwnedParameteredElement(symbol_80);
			symbol_78.getOwnedParameters().add(symbol_79);
			
			symbol_435.setOwnedTemplateSignature(symbol_78);
			symbol_435.setName("oclAsType");
			//symbol_435.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier[T])");
			symbol_435.setType(symbol_80);  // ocl!OclAny!oclAsType{T}(ocl!Classifier[T])?T
			
			Parameter symbol_436 = PivotFactory.eINSTANCE.createParameter();
			symbol_436.setName("type");
			//symbol_436.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier[T])!type");
			symbol_436.setType(symbol_151);  // ocl!Classifier[ocl!OclAny!oclAsType{T}(ocl!Classifier[T])?T]
			
			symbol_435.getOwnedParameters().add(symbol_436);
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_435);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_437 = PivotFactory.eINSTANCE.createOperation();
			symbol_437.setName("oclIsInState");
			//symbol_437.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_437.setType(symbol_19);  // Boolean
			
			Parameter symbol_438 = PivotFactory.eINSTANCE.createParameter();
			symbol_438.setName("statespec");
			//symbol_438.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_438.setType(symbol_96);  // ocl!OclState
			
			symbol_437.getOwnedParameters().add(symbol_438);
			symbol_437.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_437);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_439 = PivotFactory.eINSTANCE.createOperation();
			symbol_439.setName("oclIsInvalid");
			//symbol_439.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_439.setType(symbol_19);  // Boolean
			
			symbol_439.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_439);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_83.setName("T");
			symbol_82.setOwnedParameteredElement(symbol_83);
			symbol_81.getOwnedParameters().add(symbol_82);
			
			symbol_440.setOwnedTemplateSignature(symbol_81);
			symbol_440.setName("oclIsKindOf");
			//symbol_440.setMoniker("ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])");
			symbol_440.setType(symbol_19);  // Boolean
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("type");
			//symbol_441.setMoniker("ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])!type");
			symbol_441.setType(symbol_152);  // ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_442 = PivotFactory.eINSTANCE.createOperation();
			symbol_442.setName("oclIsNew");
			//symbol_442.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_442.setType(symbol_19);  // Boolean
			
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])
			Operation symbol_443 = PivotFactory.eINSTANCE.createOperation();
			symbol_86.setName("T");
			symbol_85.setOwnedParameteredElement(symbol_86);
			symbol_84.getOwnedParameters().add(symbol_85);
			
			symbol_443.setOwnedTemplateSignature(symbol_84);
			symbol_443.setName("oclIsTypeOf");
			//symbol_443.setMoniker("ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])");
			symbol_443.setType(symbol_19);  // Boolean
			
			Parameter symbol_444 = PivotFactory.eINSTANCE.createParameter();
			symbol_444.setName("type");
			//symbol_444.setMoniker("ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])!type");
			symbol_444.setType(symbol_153);  // ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
			
			symbol_443.getOwnedParameters().add(symbol_444);
			symbol_443.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_443);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("oclIsUndefined");
			//symbol_445.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_445.setType(symbol_19);  // Boolean
			
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType{OclSelf}()
			Operation symbol_446 = PivotFactory.eINSTANCE.createOperation();
			symbol_89.setName("OclSelf");
			symbol_88.setOwnedParameteredElement(symbol_89);
			symbol_87.getOwnedParameters().add(symbol_88);
			
			symbol_446.setOwnedTemplateSignature(symbol_87);
			symbol_446.setName("oclType");
			//symbol_446.setMoniker("ocl!OclAny!oclType{OclSelf}()");
			symbol_446.setType(symbol_150);  // ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
			
			symbol_446.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_74.getOwnedOperations().add(symbol_446);
		}
		symbol_1.getOwnedTypes().add(symbol_74);
		//
		// ocl::OclInvalid ocl!OclInvalid
		//
		symbol_90.setName("OclInvalid");
		//symbol_90.setMoniker("ocl!OclInvalid");
		symbol_90.getSuperClasses().add(symbol_98); // ocl!OclVoid
		{ // ocl::OclInvalid::oclBadProperty ocl!OclInvalid!oclBadProperty
			symbol_91.setName("oclBadProperty");
			symbol_91.setType(symbol_90);  // ocl!OclInvalid
			
			symbol_91.setIsResolveProxies(true);
			symbol_90.getOwnedAttributes().add(symbol_91);
		}
		{	// ocl::OclInvalid::<>() ocl!OclInvalid!<>(ocl!OclAny)
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("<>");
			//symbol_447.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_447.setType(symbol_19);  // Boolean
			
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("object2");
			//symbol_448.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_448.setType(symbol_74);  // ocl!OclAny
			
			symbol_447.getOwnedParameters().add(symbol_448);
			symbol_447.setPrecedence(symbol_7);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_449 = PivotFactory.eINSTANCE.createOperation();
			symbol_449.setName("=");
			//symbol_449.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_449.setType(symbol_19);  // Boolean
			
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("object2");
			//symbol_450.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_450.setType(symbol_74);  // ocl!OclAny
			
			symbol_449.getOwnedParameters().add(symbol_450);
			symbol_449.setPrecedence(symbol_7);
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_449);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances{OclSelf}()
			Operation symbol_451 = PivotFactory.eINSTANCE.createOperation();
			symbol_94.setName("OclSelf");
			symbol_93.setOwnedParameteredElement(symbol_94);
			symbol_92.getOwnedParameters().add(symbol_93);
			
			symbol_451.setOwnedTemplateSignature(symbol_92);
			symbol_451.setName("allInstances");
			//symbol_451.setMoniker("ocl!OclInvalid!allInstances{OclSelf}()");
			symbol_451.setType(symbol_264);  // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
			
			symbol_451.setIsStatic(true);
			symbol_451.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_451);
		}
		{	// ocl::OclInvalid::oclBadOperation() ocl!OclInvalid!oclBadOperation()
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_452.setName("oclBadOperation");
			//symbol_452.setMoniker("ocl!OclInvalid!oclBadOperation()");
			symbol_452.setType(symbol_90);  // ocl!OclInvalid
			
			symbol_90.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_453 = PivotFactory.eINSTANCE.createOperation();
			symbol_453.setName("toString");
			//symbol_453.setMoniker("ocl!OclInvalid!toString()");
			symbol_453.setType(symbol_137);  // String
			
			symbol_453.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_453);
		}
		symbol_1.getOwnedTypes().add(symbol_90);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_95.setName("OclMessage");
		//symbol_95.setMoniker("ocl!OclMessage");
		symbol_95.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("hasReturned");
			//symbol_454.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_454.setType(symbol_19);  // Boolean
			
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_95.getOwnedOperations().add(symbol_454);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_455 = PivotFactory.eINSTANCE.createOperation();
			symbol_455.setName("isOperationCall");
			//symbol_455.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_455.setType(symbol_19);  // Boolean
			
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_95.getOwnedOperations().add(symbol_455);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_456.setName("isSignalSent");
			//symbol_456.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_456.setType(symbol_19);  // Boolean
			
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_95.getOwnedOperations().add(symbol_456);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_457 = PivotFactory.eINSTANCE.createOperation();
			symbol_457.setName("result");
			//symbol_457.setMoniker("ocl!OclMessage!result()");
			symbol_457.setType(symbol_74);  // ocl!OclAny
			
			symbol_457.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_95.getOwnedOperations().add(symbol_457);
		}
		symbol_1.getOwnedTypes().add(symbol_95);
		//
		// ocl::OclState ocl!OclState
		//
		symbol_96.setName("OclState");
		//symbol_96.setMoniker("ocl!OclState");
		symbol_96.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_96);
		//
		// ocl::OclTuple ocl!OclTuple
		//
		symbol_97.setName("OclTuple");
		//symbol_97.setMoniker("ocl!OclTuple");
		symbol_97.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::OclTuple::<>() ocl!OclTuple!<>(ocl!OclAny)
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("<>");
			//symbol_458.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_458.setType(symbol_19);  // Boolean
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("object2");
			//symbol_459.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_459.setType(symbol_74);  // ocl!OclAny
			
			symbol_458.getOwnedParameters().add(symbol_459);
			symbol_458.setPrecedence(symbol_7);
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_97.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("=");
			//symbol_460.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_460.setType(symbol_19);  // Boolean
			
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("object2");
			//symbol_461.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_461.setType(symbol_74);  // ocl!OclAny
			
			symbol_460.getOwnedParameters().add(symbol_461);
			symbol_460.setPrecedence(symbol_7);
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_97.getOwnedOperations().add(symbol_460);
		}
		symbol_1.getOwnedTypes().add(symbol_97);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_98.setName("OclVoid");
		//symbol_98.setMoniker("ocl!OclVoid");
		symbol_98.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("<>");
			//symbol_462.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_462.setType(symbol_19);  // Boolean
			
			Parameter symbol_463 = PivotFactory.eINSTANCE.createParameter();
			symbol_463.setName("object2");
			//symbol_463.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_463.setType(symbol_74);  // ocl!OclAny
			
			symbol_462.getOwnedParameters().add(symbol_463);
			symbol_462.setPrecedence(symbol_7);
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_464 = PivotFactory.eINSTANCE.createOperation();
			symbol_464.setName("=");
			//symbol_464.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_464.setType(symbol_19);  // Boolean
			
			Parameter symbol_465 = PivotFactory.eINSTANCE.createParameter();
			symbol_465.setName("object2");
			//symbol_465.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_465.setType(symbol_74);  // ocl!OclAny
			
			symbol_464.getOwnedParameters().add(symbol_465);
			symbol_464.setPrecedence(symbol_7);
			symbol_464.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_464);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances{OclSelf}()
			Operation symbol_466 = PivotFactory.eINSTANCE.createOperation();
			symbol_101.setName("OclSelf");
			symbol_100.setOwnedParameteredElement(symbol_101);
			symbol_99.getOwnedParameters().add(symbol_100);
			
			symbol_466.setOwnedTemplateSignature(symbol_99);
			symbol_466.setName("allInstances");
			//symbol_466.setMoniker("ocl!OclVoid!allInstances{OclSelf}()");
			symbol_466.setType(symbol_253);  // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
			
			symbol_466.setIsStatic(true);
			symbol_466.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_466);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("and");
			//symbol_467.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_467.setType(symbol_19);  // Boolean
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("b");
			//symbol_468.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_468.setType(symbol_19);  // Boolean
			
			symbol_467.getOwnedParameters().add(symbol_468);
			symbol_467.setPrecedence(symbol_8);
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("implies");
			//symbol_469.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_469.setType(symbol_19);  // Boolean
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("b");
			//symbol_470.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_470.setType(symbol_19);  // Boolean
			
			symbol_469.getOwnedParameters().add(symbol_470);
			symbol_469.setPrecedence(symbol_11);
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("or");
			//symbol_471.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_471.setType(symbol_19);  // Boolean
			
			Parameter symbol_472 = PivotFactory.eINSTANCE.createParameter();
			symbol_472.setName("b");
			//symbol_472.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_472.setType(symbol_19);  // Boolean
			
			symbol_471.getOwnedParameters().add(symbol_472);
			symbol_471.setPrecedence(symbol_9);
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_471);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName("toString");
			//symbol_473.setMoniker("ocl!OclVoid!toString()");
			symbol_473.setType(symbol_137);  // String
			
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_473);
		}
		symbol_1.getOwnedTypes().add(symbol_98);
		//
		// ocl::OrderedCollection ocl!OrderedCollection{T}
		//
		symbol_102.setName("OrderedCollection");
		//symbol_102.setMoniker("ocl!OrderedCollection{T}");
		symbol_102.setElementType(symbol_105);
		symbol_105.setName("T");
		symbol_104.setOwnedParameteredElement(symbol_105);
		symbol_103.getOwnedParameters().add(symbol_104);
		
		symbol_102.setOwnedTemplateSignature(symbol_103);
		symbol_102.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_474 = PivotFactory.eINSTANCE.createOperation();
			symbol_474.setName("at");
			//symbol_474.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_474.setType(symbol_105);  // ocl!OrderedCollection{T}?T
			
			Parameter symbol_475 = PivotFactory.eINSTANCE.createParameter();
			symbol_475.setName("index");
			//symbol_475.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_475.setType(symbol_59);  // Integer
			
			symbol_474.getOwnedParameters().add(symbol_475);
			symbol_474.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_474);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])
			Iteration symbol_476 = PivotFactory.eINSTANCE.createIteration();
			symbol_476.setName("closure");
			//symbol_476.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])");
			symbol_476.setType(symbol_240);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_477 = PivotFactory.eINSTANCE.createParameter();
			symbol_477.setName("i");
			symbol_477.setType(symbol_105);  // ocl!OrderedCollection{T}?T
			symbol_476.getOwnedIterators().add(symbol_477);
			Parameter symbol_478 = PivotFactory.eINSTANCE.createParameter();
			symbol_478.setName("body");
			//symbol_478.setMoniker("ocl!OrderedCollection{T}!closure(T|Lambda~T()ocl!OrderedSet[T])!body");
			symbol_478.setType(symbol_189);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
			
			symbol_476.getOwnedParameters().add(symbol_478);
			symbol_476.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_476);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_479 = PivotFactory.eINSTANCE.createIteration();
			symbol_108.setName("V");
			symbol_107.setOwnedParameteredElement(symbol_108);
			symbol_106.getOwnedParameters().add(symbol_107);
			
			symbol_479.setOwnedTemplateSignature(symbol_106);
			symbol_479.setName("collect");
			//symbol_479.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_479.setType(symbol_247);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_480 = PivotFactory.eINSTANCE.createParameter();
			symbol_480.setName("i");
			symbol_480.setType(symbol_105);  // ocl!OrderedCollection{T}?T
			symbol_479.getOwnedIterators().add(symbol_480);
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("body");
			//symbol_481.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_481.setType(symbol_197);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_479.getOwnedParameters().add(symbol_481);
			symbol_479.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_479);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)
			Iteration symbol_482 = PivotFactory.eINSTANCE.createIteration();
			symbol_111.setName("V");
			symbol_110.setOwnedParameteredElement(symbol_111);
			symbol_109.getOwnedParameters().add(symbol_110);
			
			symbol_482.setOwnedTemplateSignature(symbol_109);
			symbol_482.setName("collectNested");
			//symbol_482.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)");
			symbol_482.setType(symbol_245);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_483 = PivotFactory.eINSTANCE.createParameter();
			symbol_483.setName("i");
			symbol_483.setType(symbol_105);  // ocl!OrderedCollection{T}?T
			symbol_482.getOwnedIterators().add(symbol_483);
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("body");
			//symbol_484.setMoniker("ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)!body");
			symbol_484.setType(symbol_188);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
			
			symbol_482.getOwnedParameters().add(symbol_484);
			symbol_482.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_482);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_485 = PivotFactory.eINSTANCE.createOperation();
			symbol_485.setName("first");
			//symbol_485.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_485.setType(symbol_105);  // ocl!OrderedCollection{T}?T
			
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_486 = PivotFactory.eINSTANCE.createOperation();
			symbol_486.setName("indexOf");
			//symbol_486.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_486.setType(symbol_59);  // Integer
			
			Parameter symbol_487 = PivotFactory.eINSTANCE.createParameter();
			symbol_487.setName("obj");
			//symbol_487.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_487.setType(symbol_74);  // ocl!OclAny
			
			symbol_486.getOwnedParameters().add(symbol_487);
			symbol_486.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_486);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_488 = PivotFactory.eINSTANCE.createOperation();
			symbol_488.setName("last");
			//symbol_488.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_488.setType(symbol_105);  // ocl!OrderedCollection{T}?T
			
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_489 = PivotFactory.eINSTANCE.createOperation();
			symbol_489.setName("reverse");
			//symbol_489.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_489.setType(symbol_235);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			
			symbol_489.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_102.getOwnedOperations().add(symbol_489);
		}
		symbol_1.getOwnedTypes().add(symbol_102);
		//
		// ocl::OrderedSet ocl!OrderedSet{T}
		//
		symbol_112.setName("OrderedSet");
		//symbol_112.setMoniker("ocl!OrderedSet{T}");
		symbol_112.setElementType(symbol_115);
		symbol_115.setName("T");
		symbol_114.setOwnedParameteredElement(symbol_115);
		symbol_113.getOwnedParameters().add(symbol_114);
		
		symbol_112.setOwnedTemplateSignature(symbol_113);
		symbol_112.getSuperClasses().add(symbol_268); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_112.getSuperClasses().add(symbol_231); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_490 = PivotFactory.eINSTANCE.createOperation();
			symbol_490.setName("-");
			//symbol_490.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_490.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_491 = PivotFactory.eINSTANCE.createParameter();
			symbol_491.setName("s");
			//symbol_491.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_491.setType(symbol_259);  // ocl!Set[ocl!OclAny]
			
			symbol_490.getOwnedParameters().add(symbol_491);
			symbol_490.setPrecedence(symbol_5);
			symbol_490.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_490);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_492 = PivotFactory.eINSTANCE.createOperation();
			symbol_492.setName("<>");
			//symbol_492.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_492.setType(symbol_19);  // Boolean
			
			Parameter symbol_493 = PivotFactory.eINSTANCE.createParameter();
			symbol_493.setName("object2");
			//symbol_493.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_493.setType(symbol_74);  // ocl!OclAny
			
			symbol_492.getOwnedParameters().add(symbol_493);
			symbol_492.setPrecedence(symbol_7);
			symbol_492.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_492);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_494 = PivotFactory.eINSTANCE.createOperation();
			symbol_494.setName("=");
			//symbol_494.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_494.setType(symbol_19);  // Boolean
			
			Parameter symbol_495 = PivotFactory.eINSTANCE.createParameter();
			symbol_495.setName("object2");
			//symbol_495.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_495.setType(symbol_74);  // ocl!OclAny
			
			symbol_494.getOwnedParameters().add(symbol_495);
			symbol_494.setPrecedence(symbol_7);
			symbol_494.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_494);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_496 = PivotFactory.eINSTANCE.createOperation();
			symbol_496.setName("append");
			//symbol_496.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_496.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_497 = PivotFactory.eINSTANCE.createParameter();
			symbol_497.setName("object");
			//symbol_497.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_497.setType(symbol_115);  // ocl!OrderedSet{T}?T
			
			symbol_496.getOwnedParameters().add(symbol_497);
			symbol_496.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_496);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("excluding");
			//symbol_498.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_498.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_499 = PivotFactory.eINSTANCE.createParameter();
			symbol_499.setName("object");
			//symbol_499.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_499.setType(symbol_74);  // ocl!OclAny
			
			symbol_498.getOwnedParameters().add(symbol_499);
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::OrderedSet::flatten() ocl!OrderedSet{T}!flatten{T2}()
			Operation symbol_500 = PivotFactory.eINSTANCE.createOperation();
			symbol_118.setName("T2");
			symbol_117.setOwnedParameteredElement(symbol_118);
			symbol_116.getOwnedParameters().add(symbol_117);
			
			symbol_500.setOwnedTemplateSignature(symbol_116);
			symbol_500.setName("flatten");
			//symbol_500.setMoniker("ocl!OrderedSet{T}!flatten{T2}()");
			symbol_500.setType(symbol_242);  // ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
			
			symbol_500.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_500);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("including");
			//symbol_501.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_501.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("object");
			//symbol_502.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_502.setType(symbol_115);  // ocl!OrderedSet{T}?T
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_503 = PivotFactory.eINSTANCE.createOperation();
			symbol_503.setName("insertAt");
			//symbol_503.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_503.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("index");
			//symbol_504.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_504.setType(symbol_59);  // Integer
			
			symbol_503.getOwnedParameters().add(symbol_504);
			Parameter symbol_505 = PivotFactory.eINSTANCE.createParameter();
			symbol_505.setName("object");
			//symbol_505.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_505.setType(symbol_115);  // ocl!OrderedSet{T}?T
			
			symbol_503.getOwnedParameters().add(symbol_505);
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_506 = PivotFactory.eINSTANCE.createOperation();
			symbol_506.setName("intersection");
			//symbol_506.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_506.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_507 = PivotFactory.eINSTANCE.createParameter();
			symbol_507.setName("o");
			//symbol_507.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_507.setType(symbol_257);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_506.getOwnedParameters().add(symbol_507);
			symbol_506.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_506);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_508 = PivotFactory.eINSTANCE.createOperation();
			symbol_508.setName("prepend");
			//symbol_508.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_508.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_509 = PivotFactory.eINSTANCE.createParameter();
			symbol_509.setName("object");
			//symbol_509.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_509.setType(symbol_115);  // ocl!OrderedSet{T}?T
			
			symbol_508.getOwnedParameters().add(symbol_509);
			symbol_508.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_508);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_510 = PivotFactory.eINSTANCE.createIteration();
			symbol_510.setName("reject");
			//symbol_510.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)");
			symbol_510.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("i");
			symbol_511.setType(symbol_115);  // ocl!OrderedSet{T}?T
			symbol_510.getOwnedIterators().add(symbol_511);
			Parameter symbol_512 = PivotFactory.eINSTANCE.createParameter();
			symbol_512.setName("body");
			//symbol_512.setMoniker("ocl!OrderedSet{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_512.setType(symbol_187);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_510.getOwnedParameters().add(symbol_512);
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_513 = PivotFactory.eINSTANCE.createOperation();
			symbol_513.setName("reverse");
			//symbol_513.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_513.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_513.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_513);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_514 = PivotFactory.eINSTANCE.createIteration();
			symbol_514.setName("select");
			//symbol_514.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)");
			symbol_514.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_515 = PivotFactory.eINSTANCE.createParameter();
			symbol_515.setName("i");
			symbol_515.setType(symbol_115);  // ocl!OrderedSet{T}?T
			symbol_514.getOwnedIterators().add(symbol_515);
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("body");
			//symbol_516.setMoniker("ocl!OrderedSet{T}!select(T|Lambda~T()Boolean)!body");
			symbol_516.setType(symbol_187);  // Lambda~ocl!OrderedSet{T}?T()Boolean
			
			symbol_514.getOwnedParameters().add(symbol_516);
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("subOrderedSet");
			//symbol_517.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_517.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("lower");
			//symbol_518.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_518.setType(symbol_59);  // Integer
			
			symbol_517.getOwnedParameters().add(symbol_518);
			Parameter symbol_519 = PivotFactory.eINSTANCE.createParameter();
			symbol_519.setName("upper");
			//symbol_519.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_519.setType(symbol_59);  // Integer
			
			symbol_517.getOwnedParameters().add(symbol_519);
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_520 = PivotFactory.eINSTANCE.createOperation();
			symbol_520.setName("symmetricDifference");
			//symbol_520.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_520.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_521 = PivotFactory.eINSTANCE.createParameter();
			symbol_521.setName("s");
			//symbol_521.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_521.setType(symbol_259);  // ocl!Set[ocl!OclAny]
			
			symbol_520.getOwnedParameters().add(symbol_521);
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("union");
			//symbol_522.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_522.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_523 = PivotFactory.eINSTANCE.createParameter();
			symbol_523.setName("o");
			//symbol_523.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_523.setType(symbol_243);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			symbol_522.getOwnedParameters().add(symbol_523);
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_524 = PivotFactory.eINSTANCE.createOperation();
			symbol_524.setName("union");
			//symbol_524.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_524.setType(symbol_257);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			Parameter symbol_525 = PivotFactory.eINSTANCE.createParameter();
			symbol_525.setName("s");
			//symbol_525.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_525.setType(symbol_257);  // ocl!Set[ocl!OrderedSet{T}?T]
			
			symbol_524.getOwnedParameters().add(symbol_525);
			symbol_524.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_524);
		}
		symbol_1.getOwnedTypes().add(symbol_112);
		//
		// ocl::Real Real
		//
		symbol_119.setName("Real");
		//symbol_119.setMoniker("Real");
		symbol_119.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_526 = PivotFactory.eINSTANCE.createOperation();
			symbol_526.setName("*");
			//symbol_526.setMoniker("Real!*(Real)");
			symbol_526.setType(symbol_119);  // Real
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("r");
			//symbol_527.setMoniker("Real!*(Real)!r");
			symbol_527.setType(symbol_119);  // Real
			
			symbol_526.getOwnedParameters().add(symbol_527);
			symbol_526.setPrecedence(symbol_4);
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_526);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_528 = PivotFactory.eINSTANCE.createOperation();
			symbol_528.setName("+");
			//symbol_528.setMoniker("Real!+(Real)");
			symbol_528.setType(symbol_119);  // Real
			
			Parameter symbol_529 = PivotFactory.eINSTANCE.createParameter();
			symbol_529.setName("r");
			//symbol_529.setMoniker("Real!+(Real)!r");
			symbol_529.setType(symbol_119);  // Real
			
			symbol_528.getOwnedParameters().add(symbol_529);
			symbol_528.setPrecedence(symbol_5);
			symbol_528.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_528);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_530 = PivotFactory.eINSTANCE.createOperation();
			symbol_530.setName("-");
			//symbol_530.setMoniker("Real!-(Real)");
			symbol_530.setType(symbol_119);  // Real
			
			Parameter symbol_531 = PivotFactory.eINSTANCE.createParameter();
			symbol_531.setName("r");
			//symbol_531.setMoniker("Real!-(Real)!r");
			symbol_531.setType(symbol_119);  // Real
			
			symbol_530.getOwnedParameters().add(symbol_531);
			symbol_530.setPrecedence(symbol_5);
			symbol_530.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_530);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_532 = PivotFactory.eINSTANCE.createOperation();
			symbol_532.setName("-");
			//symbol_532.setMoniker("Real!-()");
			symbol_532.setType(symbol_119);  // Real
			
			symbol_532.setPrecedence(symbol_3);
			symbol_532.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_532);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_533 = PivotFactory.eINSTANCE.createOperation();
			symbol_533.setName("/");
			//symbol_533.setMoniker("Real!/(Real)");
			symbol_533.setType(symbol_119);  // Real
			
			Parameter symbol_534 = PivotFactory.eINSTANCE.createParameter();
			symbol_534.setName("r");
			//symbol_534.setMoniker("Real!/(Real)!r");
			symbol_534.setType(symbol_119);  // Real
			
			symbol_533.getOwnedParameters().add(symbol_534);
			symbol_533.setPrecedence(symbol_4);
			symbol_533.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_533);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_535 = PivotFactory.eINSTANCE.createOperation();
			symbol_535.setName("<");
			//symbol_535.setMoniker("Real!<(Real)");
			symbol_535.setType(symbol_19);  // Boolean
			
			Parameter symbol_536 = PivotFactory.eINSTANCE.createParameter();
			symbol_536.setName("r");
			//symbol_536.setMoniker("Real!<(Real)!r");
			symbol_536.setType(symbol_119);  // Real
			
			symbol_535.getOwnedParameters().add(symbol_536);
			symbol_535.setPrecedence(symbol_6);
			symbol_535.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_535);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_537 = PivotFactory.eINSTANCE.createOperation();
			symbol_537.setName("<=");
			//symbol_537.setMoniker("Real!<=(Real)");
			symbol_537.setType(symbol_19);  // Boolean
			
			Parameter symbol_538 = PivotFactory.eINSTANCE.createParameter();
			symbol_538.setName("r");
			//symbol_538.setMoniker("Real!<=(Real)!r");
			symbol_538.setType(symbol_119);  // Real
			
			symbol_537.getOwnedParameters().add(symbol_538);
			symbol_537.setPrecedence(symbol_6);
			symbol_537.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_537);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_539 = PivotFactory.eINSTANCE.createOperation();
			symbol_539.setName("<>");
			//symbol_539.setMoniker("Real!<>(ocl!OclAny)");
			symbol_539.setType(symbol_19);  // Boolean
			
			Parameter symbol_540 = PivotFactory.eINSTANCE.createParameter();
			symbol_540.setName("object2");
			//symbol_540.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_540.setType(symbol_74);  // ocl!OclAny
			
			symbol_539.getOwnedParameters().add(symbol_540);
			symbol_539.setPrecedence(symbol_7);
			symbol_539.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_539);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("=");
			//symbol_541.setMoniker("Real!=(ocl!OclAny)");
			symbol_541.setType(symbol_19);  // Boolean
			
			Parameter symbol_542 = PivotFactory.eINSTANCE.createParameter();
			symbol_542.setName("object2");
			//symbol_542.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_542.setType(symbol_74);  // ocl!OclAny
			
			symbol_541.getOwnedParameters().add(symbol_542);
			symbol_541.setPrecedence(symbol_7);
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_543 = PivotFactory.eINSTANCE.createOperation();
			symbol_543.setName(">");
			//symbol_543.setMoniker("Real!>(Real)");
			symbol_543.setType(symbol_19);  // Boolean
			
			Parameter symbol_544 = PivotFactory.eINSTANCE.createParameter();
			symbol_544.setName("r");
			//symbol_544.setMoniker("Real!>(Real)!r");
			symbol_544.setType(symbol_119);  // Real
			
			symbol_543.getOwnedParameters().add(symbol_544);
			symbol_543.setPrecedence(symbol_6);
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_543);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_545 = PivotFactory.eINSTANCE.createOperation();
			symbol_545.setName(">=");
			//symbol_545.setMoniker("Real!>=(Real)");
			symbol_545.setType(symbol_19);  // Boolean
			
			Parameter symbol_546 = PivotFactory.eINSTANCE.createParameter();
			symbol_546.setName("r");
			//symbol_546.setMoniker("Real!>=(Real)!r");
			symbol_546.setType(symbol_119);  // Real
			
			symbol_545.getOwnedParameters().add(symbol_546);
			symbol_545.setPrecedence(symbol_6);
			symbol_545.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_545);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_547 = PivotFactory.eINSTANCE.createOperation();
			symbol_547.setName("abs");
			//symbol_547.setMoniker("Real!abs()");
			symbol_547.setType(symbol_119);  // Real
			
			symbol_547.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_547);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_548 = PivotFactory.eINSTANCE.createOperation();
			symbol_548.setName("floor");
			//symbol_548.setMoniker("Real!floor()");
			symbol_548.setType(symbol_59);  // Integer
			
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_549 = PivotFactory.eINSTANCE.createOperation();
			symbol_549.setName("max");
			//symbol_549.setMoniker("Real!max(Real)");
			symbol_549.setType(symbol_119);  // Real
			
			Parameter symbol_550 = PivotFactory.eINSTANCE.createParameter();
			symbol_550.setName("r");
			//symbol_550.setMoniker("Real!max(Real)!r");
			symbol_550.setType(symbol_119);  // Real
			
			symbol_549.getOwnedParameters().add(symbol_550);
			symbol_549.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_549);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_551 = PivotFactory.eINSTANCE.createOperation();
			symbol_551.setName("min");
			//symbol_551.setMoniker("Real!min(Real)");
			symbol_551.setType(symbol_119);  // Real
			
			Parameter symbol_552 = PivotFactory.eINSTANCE.createParameter();
			symbol_552.setName("r");
			//symbol_552.setMoniker("Real!min(Real)!r");
			symbol_552.setType(symbol_119);  // Real
			
			symbol_551.getOwnedParameters().add(symbol_552);
			symbol_551.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_551);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{T}(ocl!Classifier[T])
			Operation symbol_553 = PivotFactory.eINSTANCE.createOperation();
			symbol_122.setName("T");
			symbol_121.setOwnedParameteredElement(symbol_122);
			symbol_120.getOwnedParameters().add(symbol_121);
			
			symbol_553.setOwnedTemplateSignature(symbol_120);
			symbol_553.setName("oclAsType");
			//symbol_553.setMoniker("Real!oclAsType{T}(ocl!Classifier[T])");
			symbol_553.setType(symbol_122);  // Real!oclAsType{T}(ocl!Classifier[T])?T
			
			Parameter symbol_554 = PivotFactory.eINSTANCE.createParameter();
			symbol_554.setName("type");
			//symbol_554.setMoniker("Real!oclAsType{T}(ocl!Classifier[T])!type");
			symbol_554.setType(symbol_154);  // ocl!Classifier[Real!oclAsType{T}(ocl!Classifier[T])?T]
			
			symbol_553.getOwnedParameters().add(symbol_554);
			symbol_553.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_553);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("round");
			//symbol_555.setMoniker("Real!round()");
			symbol_555.setType(symbol_59);  // Integer
			
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_555);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_556 = PivotFactory.eINSTANCE.createOperation();
			symbol_556.setName("toString");
			//symbol_556.setMoniker("Real!toString()");
			symbol_556.setType(symbol_137);  // String
			
			symbol_556.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_119.getOwnedOperations().add(symbol_556);
		}
		symbol_1.getOwnedTypes().add(symbol_119);
		//
		// ocl::Sequence ocl!Sequence{T}
		//
		symbol_123.setName("Sequence");
		//symbol_123.setMoniker("ocl!Sequence{T}");
		symbol_123.setElementType(symbol_126);
		symbol_126.setName("T");
		symbol_125.setOwnedParameteredElement(symbol_126);
		symbol_124.getOwnedParameters().add(symbol_125);
		
		symbol_123.setOwnedTemplateSignature(symbol_124);
		symbol_123.getSuperClasses().add(symbol_234); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_123.getSuperClasses().add(symbol_226); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_557 = PivotFactory.eINSTANCE.createOperation();
			symbol_557.setName("<>");
			//symbol_557.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_557.setType(symbol_19);  // Boolean
			
			Parameter symbol_558 = PivotFactory.eINSTANCE.createParameter();
			symbol_558.setName("object2");
			//symbol_558.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_558.setType(symbol_74);  // ocl!OclAny
			
			symbol_557.getOwnedParameters().add(symbol_558);
			symbol_557.setPrecedence(symbol_7);
			symbol_557.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_557);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_559 = PivotFactory.eINSTANCE.createOperation();
			symbol_559.setName("=");
			//symbol_559.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_559.setType(symbol_19);  // Boolean
			
			Parameter symbol_560 = PivotFactory.eINSTANCE.createParameter();
			symbol_560.setName("object2");
			//symbol_560.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_560.setType(symbol_74);  // ocl!OclAny
			
			symbol_559.getOwnedParameters().add(symbol_560);
			symbol_559.setPrecedence(symbol_7);
			symbol_559.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_559);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_561 = PivotFactory.eINSTANCE.createOperation();
			symbol_561.setName("append");
			//symbol_561.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_561.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_562 = PivotFactory.eINSTANCE.createParameter();
			symbol_562.setName("object");
			//symbol_562.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_562.setType(symbol_126);  // ocl!Sequence{T}?T
			
			symbol_561.getOwnedParameters().add(symbol_562);
			symbol_561.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_561);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_563 = PivotFactory.eINSTANCE.createOperation();
			symbol_563.setName("excluding");
			//symbol_563.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_563.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_564 = PivotFactory.eINSTANCE.createParameter();
			symbol_564.setName("object");
			//symbol_564.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_564.setType(symbol_74);  // ocl!OclAny
			
			symbol_563.getOwnedParameters().add(symbol_564);
			symbol_563.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_563);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_565 = PivotFactory.eINSTANCE.createOperation();
			symbol_129.setName("T2");
			symbol_128.setOwnedParameteredElement(symbol_129);
			symbol_127.getOwnedParameters().add(symbol_128);
			
			symbol_565.setOwnedTemplateSignature(symbol_127);
			symbol_565.setName("flatten");
			//symbol_565.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_565.setType(symbol_248);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			
			symbol_565.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_565);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_566 = PivotFactory.eINSTANCE.createOperation();
			symbol_566.setName("including");
			//symbol_566.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_566.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_567 = PivotFactory.eINSTANCE.createParameter();
			symbol_567.setName("object");
			//symbol_567.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_567.setType(symbol_126);  // ocl!Sequence{T}?T
			
			symbol_566.getOwnedParameters().add(symbol_567);
			symbol_566.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_566);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_568 = PivotFactory.eINSTANCE.createOperation();
			symbol_568.setName("insertAt");
			//symbol_568.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_568.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_569 = PivotFactory.eINSTANCE.createParameter();
			symbol_569.setName("index");
			//symbol_569.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_569.setType(symbol_59);  // Integer
			
			symbol_568.getOwnedParameters().add(symbol_569);
			Parameter symbol_570 = PivotFactory.eINSTANCE.createParameter();
			symbol_570.setName("object");
			//symbol_570.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_570.setType(symbol_126);  // ocl!Sequence{T}?T
			
			symbol_568.getOwnedParameters().add(symbol_570);
			symbol_568.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_568);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_571 = PivotFactory.eINSTANCE.createOperation();
			symbol_571.setName("prepend");
			//symbol_571.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_571.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_572 = PivotFactory.eINSTANCE.createParameter();
			symbol_572.setName("object");
			//symbol_572.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_572.setType(symbol_126);  // ocl!Sequence{T}?T
			
			symbol_571.getOwnedParameters().add(symbol_572);
			symbol_571.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_571);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_573 = PivotFactory.eINSTANCE.createIteration();
			symbol_573.setName("reject");
			//symbol_573.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)");
			symbol_573.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_574 = PivotFactory.eINSTANCE.createParameter();
			symbol_574.setName("i");
			symbol_574.setType(symbol_126);  // ocl!Sequence{T}?T
			symbol_573.getOwnedIterators().add(symbol_574);
			Parameter symbol_575 = PivotFactory.eINSTANCE.createParameter();
			symbol_575.setName("body");
			//symbol_575.setMoniker("ocl!Sequence{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_575.setType(symbol_185);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_573.getOwnedParameters().add(symbol_575);
			symbol_573.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_573);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_576 = PivotFactory.eINSTANCE.createOperation();
			symbol_576.setName("reverse");
			//symbol_576.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_576.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_576.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_576);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_577 = PivotFactory.eINSTANCE.createIteration();
			symbol_577.setName("select");
			//symbol_577.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)");
			symbol_577.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_578 = PivotFactory.eINSTANCE.createParameter();
			symbol_578.setName("i");
			symbol_578.setType(symbol_126);  // ocl!Sequence{T}?T
			symbol_577.getOwnedIterators().add(symbol_578);
			Parameter symbol_579 = PivotFactory.eINSTANCE.createParameter();
			symbol_579.setName("body");
			//symbol_579.setMoniker("ocl!Sequence{T}!select(T|Lambda~T()Boolean)!body");
			symbol_579.setType(symbol_185);  // Lambda~ocl!Sequence{T}?T()Boolean
			
			symbol_577.getOwnedParameters().add(symbol_579);
			symbol_577.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_577);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_580 = PivotFactory.eINSTANCE.createOperation();
			symbol_580.setName("subSequence");
			//symbol_580.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_580.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_581 = PivotFactory.eINSTANCE.createParameter();
			symbol_581.setName("lower");
			//symbol_581.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_581.setType(symbol_59);  // Integer
			
			symbol_580.getOwnedParameters().add(symbol_581);
			Parameter symbol_582 = PivotFactory.eINSTANCE.createParameter();
			symbol_582.setName("upper");
			//symbol_582.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_582.setType(symbol_59);  // Integer
			
			symbol_580.getOwnedParameters().add(symbol_582);
			symbol_580.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_580);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_583 = PivotFactory.eINSTANCE.createOperation();
			symbol_583.setName("union");
			//symbol_583.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_583.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_584 = PivotFactory.eINSTANCE.createParameter();
			symbol_584.setName("s");
			//symbol_584.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_584.setType(symbol_244);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			symbol_583.getOwnedParameters().add(symbol_584);
			symbol_583.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_123.getOwnedOperations().add(symbol_583);
		}
		symbol_1.getOwnedTypes().add(symbol_123);
		//
		// ocl::Set ocl!Set{T}
		//
		symbol_130.setName("Set");
		//symbol_130.setMoniker("ocl!Set{T}");
		symbol_130.setElementType(symbol_133);
		symbol_133.setName("T");
		symbol_132.setOwnedParameteredElement(symbol_133);
		symbol_131.getOwnedParameters().add(symbol_132);
		
		symbol_130.setOwnedTemplateSignature(symbol_131);
		symbol_130.getSuperClasses().add(symbol_215); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_130.getSuperClasses().add(symbol_276); // ocl!UniqueCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_585 = PivotFactory.eINSTANCE.createOperation();
			symbol_585.setName("-");
			//symbol_585.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_585.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_586 = PivotFactory.eINSTANCE.createParameter();
			symbol_586.setName("s");
			//symbol_586.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_586.setType(symbol_259);  // ocl!Set[ocl!OclAny]
			
			symbol_585.getOwnedParameters().add(symbol_586);
			symbol_585.setPrecedence(symbol_5);
			symbol_585.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_585);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_587 = PivotFactory.eINSTANCE.createOperation();
			symbol_587.setName("<>");
			//symbol_587.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_587.setType(symbol_19);  // Boolean
			
			Parameter symbol_588 = PivotFactory.eINSTANCE.createParameter();
			symbol_588.setName("object2");
			//symbol_588.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_588.setType(symbol_74);  // ocl!OclAny
			
			symbol_587.getOwnedParameters().add(symbol_588);
			symbol_587.setPrecedence(symbol_7);
			symbol_587.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_587);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_589 = PivotFactory.eINSTANCE.createOperation();
			symbol_589.setName("=");
			//symbol_589.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_589.setType(symbol_19);  // Boolean
			
			Parameter symbol_590 = PivotFactory.eINSTANCE.createParameter();
			symbol_590.setName("object2");
			//symbol_590.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_590.setType(symbol_74);  // ocl!OclAny
			
			symbol_589.getOwnedParameters().add(symbol_590);
			symbol_589.setPrecedence(symbol_7);
			symbol_589.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_589);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_591 = PivotFactory.eINSTANCE.createOperation();
			symbol_591.setName("excluding");
			//symbol_591.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_591.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_592 = PivotFactory.eINSTANCE.createParameter();
			symbol_592.setName("object");
			//symbol_592.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_592.setType(symbol_74);  // ocl!OclAny
			
			symbol_591.getOwnedParameters().add(symbol_592);
			symbol_591.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_591);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_593 = PivotFactory.eINSTANCE.createOperation();
			symbol_136.setName("T2");
			symbol_135.setOwnedParameteredElement(symbol_136);
			symbol_134.getOwnedParameters().add(symbol_135);
			
			symbol_593.setOwnedTemplateSignature(symbol_134);
			symbol_593.setName("flatten");
			//symbol_593.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_593.setType(symbol_261);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			
			symbol_593.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_593);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_594 = PivotFactory.eINSTANCE.createOperation();
			symbol_594.setName("including");
			//symbol_594.setMoniker("ocl!Set{T}!including(T)");
			symbol_594.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_595 = PivotFactory.eINSTANCE.createParameter();
			symbol_595.setName("object");
			//symbol_595.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_595.setType(symbol_133);  // ocl!Set{T}?T
			
			symbol_594.getOwnedParameters().add(symbol_595);
			symbol_594.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_594);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_596 = PivotFactory.eINSTANCE.createOperation();
			symbol_596.setName("intersection");
			//symbol_596.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_596.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_597 = PivotFactory.eINSTANCE.createParameter();
			symbol_597.setName("s");
			//symbol_597.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_597.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			symbol_596.getOwnedParameters().add(symbol_597);
			symbol_596.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_596);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T|Lambda~T()Boolean)
			Iteration symbol_598 = PivotFactory.eINSTANCE.createIteration();
			symbol_598.setName("reject");
			//symbol_598.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)");
			symbol_598.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_599 = PivotFactory.eINSTANCE.createParameter();
			symbol_599.setName("i");
			symbol_599.setType(symbol_133);  // ocl!Set{T}?T
			symbol_598.getOwnedIterators().add(symbol_599);
			Parameter symbol_600 = PivotFactory.eINSTANCE.createParameter();
			symbol_600.setName("body");
			//symbol_600.setMoniker("ocl!Set{T}!reject(T|Lambda~T()Boolean)!body");
			symbol_600.setType(symbol_199);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_598.getOwnedParameters().add(symbol_600);
			symbol_598.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_598);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T|Lambda~T()Boolean)
			Iteration symbol_601 = PivotFactory.eINSTANCE.createIteration();
			symbol_601.setName("select");
			//symbol_601.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)");
			symbol_601.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_602 = PivotFactory.eINSTANCE.createParameter();
			symbol_602.setName("i");
			symbol_602.setType(symbol_133);  // ocl!Set{T}?T
			symbol_601.getOwnedIterators().add(symbol_602);
			Parameter symbol_603 = PivotFactory.eINSTANCE.createParameter();
			symbol_603.setName("body");
			//symbol_603.setMoniker("ocl!Set{T}!select(T|Lambda~T()Boolean)!body");
			symbol_603.setType(symbol_199);  // Lambda~ocl!Set{T}?T()Boolean
			
			symbol_601.getOwnedParameters().add(symbol_603);
			symbol_601.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_601);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_604 = PivotFactory.eINSTANCE.createOperation();
			symbol_604.setName("symmetricDifference");
			//symbol_604.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_604.setType(symbol_260);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_605 = PivotFactory.eINSTANCE.createParameter();
			symbol_605.setName("s");
			//symbol_605.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_605.setType(symbol_259);  // ocl!Set[ocl!OclAny]
			
			symbol_604.getOwnedParameters().add(symbol_605);
			symbol_604.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_130.getOwnedOperations().add(symbol_604);
		}
		symbol_1.getOwnedTypes().add(symbol_130);
		//
		// ocl::String String
		//
		symbol_137.setName("String");
		//symbol_137.setMoniker("String");
		symbol_137.getSuperClasses().add(symbol_74); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_606 = PivotFactory.eINSTANCE.createOperation();
			symbol_606.setName("+");
			//symbol_606.setMoniker("String!+(String)");
			symbol_606.setType(symbol_137);  // String
			
			Parameter symbol_607 = PivotFactory.eINSTANCE.createParameter();
			symbol_607.setName("s");
			//symbol_607.setMoniker("String!+(String)!s");
			symbol_607.setType(symbol_137);  // String
			
			symbol_606.getOwnedParameters().add(symbol_607);
			symbol_606.setPrecedence(symbol_5);
			symbol_606.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_606);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_608 = PivotFactory.eINSTANCE.createOperation();
			symbol_608.setName("<");
			//symbol_608.setMoniker("String!<(String)");
			symbol_608.setType(symbol_19);  // Boolean
			
			Parameter symbol_609 = PivotFactory.eINSTANCE.createParameter();
			symbol_609.setName("s");
			//symbol_609.setMoniker("String!<(String)!s");
			symbol_609.setType(symbol_137);  // String
			
			symbol_608.getOwnedParameters().add(symbol_609);
			symbol_608.setPrecedence(symbol_6);
			symbol_608.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_608);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_610 = PivotFactory.eINSTANCE.createOperation();
			symbol_610.setName("<=");
			//symbol_610.setMoniker("String!<=(String)");
			symbol_610.setType(symbol_19);  // Boolean
			
			Parameter symbol_611 = PivotFactory.eINSTANCE.createParameter();
			symbol_611.setName("s");
			//symbol_611.setMoniker("String!<=(String)!s");
			symbol_611.setType(symbol_137);  // String
			
			symbol_610.getOwnedParameters().add(symbol_611);
			symbol_610.setPrecedence(symbol_6);
			symbol_610.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_610);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_612 = PivotFactory.eINSTANCE.createOperation();
			symbol_612.setName("<>");
			//symbol_612.setMoniker("String!<>(ocl!OclAny)");
			symbol_612.setType(symbol_19);  // Boolean
			
			Parameter symbol_613 = PivotFactory.eINSTANCE.createParameter();
			symbol_613.setName("object2");
			//symbol_613.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_613.setType(symbol_74);  // ocl!OclAny
			
			symbol_612.getOwnedParameters().add(symbol_613);
			symbol_612.setPrecedence(symbol_7);
			symbol_612.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_612);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_614 = PivotFactory.eINSTANCE.createOperation();
			symbol_614.setName("=");
			//symbol_614.setMoniker("String!=(ocl!OclAny)");
			symbol_614.setType(symbol_19);  // Boolean
			
			Parameter symbol_615 = PivotFactory.eINSTANCE.createParameter();
			symbol_615.setName("object2");
			//symbol_615.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_615.setType(symbol_74);  // ocl!OclAny
			
			symbol_614.getOwnedParameters().add(symbol_615);
			symbol_614.setPrecedence(symbol_7);
			symbol_614.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_614);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_616 = PivotFactory.eINSTANCE.createOperation();
			symbol_616.setName(">");
			//symbol_616.setMoniker("String!>(String)");
			symbol_616.setType(symbol_19);  // Boolean
			
			Parameter symbol_617 = PivotFactory.eINSTANCE.createParameter();
			symbol_617.setName("s");
			//symbol_617.setMoniker("String!>(String)!s");
			symbol_617.setType(symbol_137);  // String
			
			symbol_616.getOwnedParameters().add(symbol_617);
			symbol_616.setPrecedence(symbol_6);
			symbol_616.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_616);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_618 = PivotFactory.eINSTANCE.createOperation();
			symbol_618.setName(">=");
			//symbol_618.setMoniker("String!>=(String)");
			symbol_618.setType(symbol_19);  // Boolean
			
			Parameter symbol_619 = PivotFactory.eINSTANCE.createParameter();
			symbol_619.setName("s");
			//symbol_619.setMoniker("String!>=(String)!s");
			symbol_619.setType(symbol_137);  // String
			
			symbol_618.getOwnedParameters().add(symbol_619);
			symbol_618.setPrecedence(symbol_6);
			symbol_618.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_618);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_620 = PivotFactory.eINSTANCE.createOperation();
			symbol_620.setName("at");
			//symbol_620.setMoniker("String!at(Integer)");
			symbol_620.setType(symbol_137);  // String
			
			Parameter symbol_621 = PivotFactory.eINSTANCE.createParameter();
			symbol_621.setName("i");
			//symbol_621.setMoniker("String!at(Integer)!i");
			symbol_621.setType(symbol_59);  // Integer
			
			symbol_620.getOwnedParameters().add(symbol_621);
			symbol_620.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_620);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_622 = PivotFactory.eINSTANCE.createOperation();
			symbol_622.setName("characters");
			//symbol_622.setMoniker("String!characters()");
			symbol_622.setType(symbol_250);  // ocl!Sequence[String]
			
			symbol_622.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_622);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_623 = PivotFactory.eINSTANCE.createOperation();
			symbol_623.setName("concat");
			//symbol_623.setMoniker("String!concat(String)");
			symbol_623.setType(symbol_137);  // String
			
			Parameter symbol_624 = PivotFactory.eINSTANCE.createParameter();
			symbol_624.setName("s");
			//symbol_624.setMoniker("String!concat(String)!s");
			symbol_624.setType(symbol_137);  // String
			
			symbol_623.getOwnedParameters().add(symbol_624);
			symbol_623.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_623);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_625 = PivotFactory.eINSTANCE.createOperation();
			symbol_625.setName("equalsIgnoreCase");
			//symbol_625.setMoniker("String!equalsIgnoreCase(String)");
			symbol_625.setType(symbol_19);  // Boolean
			
			Parameter symbol_626 = PivotFactory.eINSTANCE.createParameter();
			symbol_626.setName("s");
			//symbol_626.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_626.setType(symbol_137);  // String
			
			symbol_625.getOwnedParameters().add(symbol_626);
			symbol_625.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_625);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_627 = PivotFactory.eINSTANCE.createOperation();
			symbol_627.setName("indexOf");
			//symbol_627.setMoniker("String!indexOf(String)");
			symbol_627.setType(symbol_59);  // Integer
			
			Parameter symbol_628 = PivotFactory.eINSTANCE.createParameter();
			symbol_628.setName("s");
			//symbol_628.setMoniker("String!indexOf(String)!s");
			symbol_628.setType(symbol_137);  // String
			
			symbol_627.getOwnedParameters().add(symbol_628);
			symbol_627.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_627);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_629 = PivotFactory.eINSTANCE.createOperation();
			symbol_629.setName("size");
			//symbol_629.setMoniker("String!size()");
			symbol_629.setType(symbol_59);  // Integer
			
			symbol_629.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_629);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_630 = PivotFactory.eINSTANCE.createOperation();
			symbol_630.setName("substring");
			//symbol_630.setMoniker("String!substring(Integer,Integer)");
			symbol_630.setType(symbol_137);  // String
			
			Parameter symbol_631 = PivotFactory.eINSTANCE.createParameter();
			symbol_631.setName("lower");
			//symbol_631.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_631.setType(symbol_59);  // Integer
			
			symbol_630.getOwnedParameters().add(symbol_631);
			Parameter symbol_632 = PivotFactory.eINSTANCE.createParameter();
			symbol_632.setName("upper");
			//symbol_632.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_632.setType(symbol_59);  // Integer
			
			symbol_630.getOwnedParameters().add(symbol_632);
			symbol_630.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_630);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_633 = PivotFactory.eINSTANCE.createOperation();
			symbol_633.setName("toBoolean");
			//symbol_633.setMoniker("String!toBoolean()");
			symbol_633.setType(symbol_19);  // Boolean
			
			symbol_633.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_633);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_634 = PivotFactory.eINSTANCE.createOperation();
			symbol_634.setName("toInteger");
			//symbol_634.setMoniker("String!toInteger()");
			symbol_634.setType(symbol_59);  // Integer
			
			symbol_634.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_634);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_635 = PivotFactory.eINSTANCE.createOperation();
			symbol_635.setName("toLower");
			//symbol_635.setMoniker("String!toLower()");
			symbol_635.setType(symbol_137);  // String
			
			symbol_635.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_635);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_636 = PivotFactory.eINSTANCE.createOperation();
			symbol_636.setName("toLowerCase");
			//symbol_636.setMoniker("String!toLowerCase()");
			symbol_636.setType(symbol_137);  // String
			
			symbol_636.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_636);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_637 = PivotFactory.eINSTANCE.createOperation();
			symbol_637.setName("toReal");
			//symbol_637.setMoniker("String!toReal()");
			symbol_637.setType(symbol_119);  // Real
			
			symbol_637.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_637);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_638 = PivotFactory.eINSTANCE.createOperation();
			symbol_638.setName("toString");
			//symbol_638.setMoniker("String!toString()");
			symbol_638.setType(symbol_137);  // String
			
			symbol_638.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_638);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_639 = PivotFactory.eINSTANCE.createOperation();
			symbol_639.setName("toUpper");
			//symbol_639.setMoniker("String!toUpper()");
			symbol_639.setType(symbol_137);  // String
			
			symbol_639.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_639);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_640 = PivotFactory.eINSTANCE.createOperation();
			symbol_640.setName("toUpperCase");
			//symbol_640.setMoniker("String!toUpperCase()");
			symbol_640.setType(symbol_137);  // String
			
			symbol_640.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_137.getOwnedOperations().add(symbol_640);
		}
		symbol_1.getOwnedTypes().add(symbol_137);
		//
		// ocl::UniqueCollection ocl!UniqueCollection{T}
		//
		symbol_138.setName("UniqueCollection");
		//symbol_138.setMoniker("ocl!UniqueCollection{T}");
		symbol_138.setElementType(symbol_141);
		symbol_141.setName("T");
		symbol_140.setOwnedParameteredElement(symbol_141);
		symbol_139.getOwnedParameters().add(symbol_140);
		
		symbol_138.setOwnedTemplateSignature(symbol_139);
		symbol_138.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)
			Iteration symbol_641 = PivotFactory.eINSTANCE.createIteration();
			symbol_641.setName("sortedBy");
			//symbol_641.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)");
			symbol_641.setType(symbol_241);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_642 = PivotFactory.eINSTANCE.createParameter();
			symbol_642.setName("i");
			symbol_642.setType(symbol_141);  // ocl!UniqueCollection{T}?T
			symbol_641.getOwnedIterators().add(symbol_642);
			Parameter symbol_643 = PivotFactory.eINSTANCE.createParameter();
			symbol_643.setName("body");
			//symbol_643.setMoniker("ocl!UniqueCollection{T}!sortedBy(T|Lambda~T()ocl!OclAny)!body");
			symbol_643.setType(symbol_190);  // Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
			
			symbol_641.getOwnedParameters().add(symbol_643);
			symbol_641.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_138.getOwnedOperations().add(symbol_641);
		}
		symbol_1.getOwnedTypes().add(symbol_138);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_142.setName("UnlimitedNatural");
		//symbol_142.setMoniker("UnlimitedNatural");
		symbol_142.getSuperClasses().add(symbol_59); // Integer
		symbol_1.getOwnedTypes().add(symbol_142);
		//
		// ocl::$orphanage
		//
		symbol_143.setName("$orphanage");
		symbol_143.setMoniker("$orphanage");
		//
		// ocl::$orphanage::$orphanage $orphanage!$orphanage
		//
		symbol_144.setName("$orphanage");
		//symbol_144.setMoniker("$orphanage!$orphanage");
		symbol_143.getOwnedTypes().add(symbol_144);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}?T]
		//
		symbol_145.setName("Bag");
		//symbol_145.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}?T]");
		symbol_145.setElementType(symbol_63);
		{
			TemplateBinding symbol_644 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_644.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_645 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_645.setFormal(symbol_14);	
				symbol_645.setActual(symbol_63);	
				symbol_644.getParameterSubstitutions().add(symbol_645);
			}
			symbol_145.getTemplateBindings().add(symbol_644);
		}
		symbol_145.getSuperClasses().add(symbol_218); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_145.getSuperClasses().add(symbol_206); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_145);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_146.setName("Bag");
		//symbol_146.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_146.setElementType(symbol_15);
		{
			TemplateBinding symbol_646 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_646.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_647 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_647.setFormal(symbol_14);	
				symbol_647.setActual(symbol_15);	
				symbol_646.getParameterSubstitutions().add(symbol_647);
			}
			symbol_146.getTemplateBindings().add(symbol_646);
		}
		symbol_146.getSuperClasses().add(symbol_216); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_146.getSuperClasses().add(symbol_219); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_143.getOwnedTypes().add(symbol_146);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_147.setName("Bag");
		//symbol_147.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_147.setElementType(symbol_33);
		{
			TemplateBinding symbol_648 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_648.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_649 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_649.setFormal(symbol_14);	
				symbol_649.setActual(symbol_33);	
				symbol_648.getParameterSubstitutions().add(symbol_649);
			}
			symbol_147.getTemplateBindings().add(symbol_648);
		}
		symbol_147.getSuperClasses().add(symbol_202); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_147.getSuperClasses().add(symbol_222); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_147);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_148.setName("Bag");
		//symbol_148.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_148.setElementType(symbol_66);
		{
			TemplateBinding symbol_650 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_650.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_651 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_651.setFormal(symbol_14);	
				symbol_651.setActual(symbol_66);	
				symbol_650.getParameterSubstitutions().add(symbol_651);
			}
			symbol_148.getTemplateBindings().add(symbol_650);
		}
		symbol_148.getSuperClasses().add(symbol_227); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_148.getSuperClasses().add(symbol_213); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_143.getOwnedTypes().add(symbol_148);
		//
		// ocl::$orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_149.setName("Bag");
		//symbol_149.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_149.setElementType(symbol_18);
		{
			TemplateBinding symbol_652 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_652.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_653 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_653.setFormal(symbol_14);	
				symbol_653.setActual(symbol_18);	
				symbol_652.getParameterSubstitutions().add(symbol_653);
			}
			symbol_149.getTemplateBindings().add(symbol_652);
		}
		symbol_149.getSuperClasses().add(symbol_225); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_149.getSuperClasses().add(symbol_203); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_149);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]
		//
		symbol_150.setName("Classifier");
		//symbol_150.setMoniker("ocl!Classifier[ocl!OclAny!oclType{OclSelf}()?OclSelf]");
		{
			TemplateBinding symbol_654 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_654.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_655 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_655.setFormal(symbol_25);	
				symbol_655.setActual(symbol_89);	
				symbol_654.getParameterSubstitutions().add(symbol_655);
			}
			symbol_150.getTemplateBindings().add(symbol_654);
		}
		symbol_150.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_150);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclAsType{T}(ocl!Classifier[T])?T]
		//
		symbol_151.setName("Classifier");
		//symbol_151.setMoniker("ocl!Classifier[ocl!OclAny!oclAsType{T}(ocl!Classifier[T])?T]");
		{
			TemplateBinding symbol_656 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_656.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_657 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_657.setFormal(symbol_25);	
				symbol_657.setActual(symbol_80);	
				symbol_656.getParameterSubstitutions().add(symbol_657);
			}
			symbol_151.getTemplateBindings().add(symbol_656);
		}
		symbol_151.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_151);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]
		//
		symbol_152.setName("Classifier");
		//symbol_152.setMoniker("ocl!Classifier[ocl!OclAny!oclIsKindOf{T}(ocl!Classifier[T])?T]");
		{
			TemplateBinding symbol_658 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_658.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_659 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_659.setFormal(symbol_25);	
				symbol_659.setActual(symbol_83);	
				symbol_658.getParameterSubstitutions().add(symbol_659);
			}
			symbol_152.getTemplateBindings().add(symbol_658);
		}
		symbol_152.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_152);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]
		//
		symbol_153.setName("Classifier");
		//symbol_153.setMoniker("ocl!Classifier[ocl!OclAny!oclIsTypeOf{T}(ocl!Classifier[T])?T]");
		{
			TemplateBinding symbol_660 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_660.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_661 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_661.setFormal(symbol_25);	
				symbol_661.setActual(symbol_86);	
				symbol_660.getParameterSubstitutions().add(symbol_661);
			}
			symbol_153.getTemplateBindings().add(symbol_660);
		}
		symbol_153.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_153);
		//
		// ocl::$orphanage::Classifier ocl!Classifier[Real!oclAsType{T}(ocl!Classifier[T])?T]
		//
		symbol_154.setName("Classifier");
		//symbol_154.setMoniker("ocl!Classifier[Real!oclAsType{T}(ocl!Classifier[T])?T]");
		{
			TemplateBinding symbol_662 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_662.setSignature(symbol_24);
			{
				TemplateParameterSubstitution symbol_663 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_663.setFormal(symbol_25);	
				symbol_663.setActual(symbol_122);	
				symbol_662.getParameterSubstitutions().add(symbol_663);
			}
			symbol_154.getTemplateBindings().add(symbol_662);
		}
		symbol_154.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_154);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_155.setName("Collection");
		//symbol_155.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_155.setElementType(symbol_141);
		{
			TemplateBinding symbol_664 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_664.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_665 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_665.setFormal(symbol_32);	
				symbol_665.setActual(symbol_141);	
				symbol_664.getParameterSubstitutions().add(symbol_665);
			}
			symbol_155.getTemplateBindings().add(symbol_664);
		}
		symbol_155.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_155);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_156.setName("Collection");
		//symbol_156.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_156.setElementType(symbol_66);
		{
			TemplateBinding symbol_666 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_666.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_667 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_667.setFormal(symbol_32);	
				symbol_667.setActual(symbol_66);	
				symbol_666.getParameterSubstitutions().add(symbol_667);
			}
			symbol_156.getTemplateBindings().add(symbol_666);
		}
		symbol_156.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_156);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_157.setName("Collection");
		//symbol_157.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_157.setElementType(symbol_77);
		{
			TemplateBinding symbol_668 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_668.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_669 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_669.setFormal(symbol_32);	
				symbol_669.setActual(symbol_77);	
				symbol_668.getParameterSubstitutions().add(symbol_669);
			}
			symbol_157.getTemplateBindings().add(symbol_668);
		}
		symbol_157.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_157);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_158.setName("Collection");
		//symbol_158.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_158.setElementType(symbol_45);
		{
			TemplateBinding symbol_670 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_670.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_671 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_671.setFormal(symbol_32);	
				symbol_671.setActual(symbol_45);	
				symbol_670.getParameterSubstitutions().add(symbol_671);
			}
			symbol_158.getTemplateBindings().add(symbol_670);
		}
		symbol_158.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_158);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_159.setName("Collection");
		//symbol_159.setMoniker("ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_159.setElementType(symbol_94);
		{
			TemplateBinding symbol_672 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_672.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_673 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_673.setFormal(symbol_32);	
				symbol_673.setActual(symbol_94);	
				symbol_672.getParameterSubstitutions().add(symbol_673);
			}
			symbol_159.getTemplateBindings().add(symbol_672);
		}
		symbol_159.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_159);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_160.setName("Collection");
		//symbol_160.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_160.setElementType(symbol_54);
		{
			TemplateBinding symbol_674 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_674.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_675 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_675.setFormal(symbol_32);	
				symbol_675.setActual(symbol_54);	
				symbol_674.getParameterSubstitutions().add(symbol_675);
			}
			symbol_160.getTemplateBindings().add(symbol_674);
		}
		symbol_160.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_160);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_161.setName("Collection");
		//symbol_161.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_161.setElementType(symbol_74);
		{
			TemplateBinding symbol_676 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_676.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_677 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_677.setFormal(symbol_32);	
				symbol_677.setActual(symbol_74);	
				symbol_676.getParameterSubstitutions().add(symbol_677);
			}
			symbol_161.getTemplateBindings().add(symbol_676);
		}
		symbol_161.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_161);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_162.setName("Collection");
		//symbol_162.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_162.setElementType(symbol_108);
		{
			TemplateBinding symbol_678 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_678.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_679 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_679.setFormal(symbol_32);	
				symbol_679.setActual(symbol_108);	
				symbol_678.getParameterSubstitutions().add(symbol_679);
			}
			symbol_162.getTemplateBindings().add(symbol_678);
		}
		symbol_162.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_162);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_163.setName("Collection");
		//symbol_163.setMoniker("ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_163.setElementType(symbol_58);
		{
			TemplateBinding symbol_680 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_680.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_681 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_681.setFormal(symbol_32);	
				symbol_681.setActual(symbol_58);	
				symbol_680.getParameterSubstitutions().add(symbol_681);
			}
			symbol_163.getTemplateBindings().add(symbol_680);
		}
		symbol_163.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_163);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_164.setName("Collection");
		//symbol_164.setMoniker("ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_164.setElementType(symbol_29);
		{
			TemplateBinding symbol_682 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_682.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_683 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_683.setFormal(symbol_32);	
				symbol_683.setActual(symbol_29);	
				symbol_682.getParameterSubstitutions().add(symbol_683);
			}
			symbol_164.getTemplateBindings().add(symbol_682);
		}
		symbol_164.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_164);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_165.setName("Collection");
		//symbol_165.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_165.setElementType(symbol_115);
		{
			TemplateBinding symbol_684 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_684.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_685 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_685.setFormal(symbol_32);	
				symbol_685.setActual(symbol_115);	
				symbol_684.getParameterSubstitutions().add(symbol_685);
			}
			symbol_165.getTemplateBindings().add(symbol_684);
		}
		symbol_165.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_165);
		//
		// ocl::$orphanage::Collection ocl!Collection[String]
		//
		symbol_166.setName("Collection");
		//symbol_166.setMoniker("ocl!Collection[String]");
		symbol_166.setElementType(symbol_137);
		{
			TemplateBinding symbol_686 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_686.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_687 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_687.setFormal(symbol_32);	
				symbol_687.setActual(symbol_137);	
				symbol_686.getParameterSubstitutions().add(symbol_687);
			}
			symbol_166.getTemplateBindings().add(symbol_686);
		}
		symbol_166.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_166);
		//
		// ocl::$orphanage::Collection ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_167.setName("Collection");
		//symbol_167.setMoniker("ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_167.setElementType(symbol_22);
		{
			TemplateBinding symbol_688 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_688.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_689 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_689.setFormal(symbol_32);	
				symbol_689.setActual(symbol_22);	
				symbol_688.getParameterSubstitutions().add(symbol_689);
			}
			symbol_167.getTemplateBindings().add(symbol_688);
		}
		symbol_167.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_167);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_168.setName("Collection");
		//symbol_168.setMoniker("ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_168.setElementType(symbol_118);
		{
			TemplateBinding symbol_690 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_690.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_691 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_691.setFormal(symbol_32);	
				symbol_691.setActual(symbol_118);	
				symbol_690.getParameterSubstitutions().add(symbol_691);
			}
			symbol_168.getTemplateBindings().add(symbol_690);
		}
		symbol_168.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_168);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_169.setName("Collection");
		//symbol_169.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_169.setElementType(symbol_73);
		{
			TemplateBinding symbol_692 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_692.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_693 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_693.setFormal(symbol_32);	
				symbol_693.setActual(symbol_73);	
				symbol_692.getParameterSubstitutions().add(symbol_693);
			}
			symbol_169.getTemplateBindings().add(symbol_692);
		}
		symbol_169.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_169);
		//
		// ocl::$orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_170.setName("Collection");
		//symbol_170.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_170.setElementType(symbol_265);
		{
			TemplateBinding symbol_694 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_694.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_695 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_695.setFormal(symbol_32);	
				symbol_695.setActual(symbol_265);	
				symbol_694.getParameterSubstitutions().add(symbol_695);
			}
			symbol_170.getTemplateBindings().add(symbol_694);
		}
		symbol_170.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_170);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_171.setName("Collection");
		//symbol_171.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_171.setElementType(symbol_48);
		{
			TemplateBinding symbol_696 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_696.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_697 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_697.setFormal(symbol_32);	
				symbol_697.setActual(symbol_48);	
				symbol_696.getParameterSubstitutions().add(symbol_697);
			}
			symbol_171.getTemplateBindings().add(symbol_696);
		}
		symbol_171.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_171);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Classifier{T}]
		//
		symbol_172.setName("Collection");
		//symbol_172.setMoniker("ocl!Collection[ocl!Classifier{T}]");
		symbol_172.setElementType(symbol_23);
		{
			TemplateBinding symbol_698 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_698.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_699 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_699.setFormal(symbol_32);	
				symbol_699.setActual(symbol_23);	
				symbol_698.getParameterSubstitutions().add(symbol_699);
			}
			symbol_172.getTemplateBindings().add(symbol_698);
		}
		symbol_172.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_172);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_173.setName("Collection");
		//symbol_173.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_173.setElementType(symbol_15);
		{
			TemplateBinding symbol_700 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_700.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_701 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_701.setFormal(symbol_32);	
				symbol_701.setActual(symbol_15);	
				symbol_700.getParameterSubstitutions().add(symbol_701);
			}
			symbol_173.getTemplateBindings().add(symbol_700);
		}
		symbol_173.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_173);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_174.setName("Collection");
		//symbol_174.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_174.setElementType(symbol_18);
		{
			TemplateBinding symbol_702 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_702.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_703 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_703.setFormal(symbol_32);	
				symbol_703.setActual(symbol_18);	
				symbol_702.getParameterSubstitutions().add(symbol_703);
			}
			symbol_174.getTemplateBindings().add(symbol_702);
		}
		symbol_174.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_174);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_175.setName("Collection");
		//symbol_175.setMoniker("ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_175.setElementType(symbol_101);
		{
			TemplateBinding symbol_704 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_704.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_705 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_705.setFormal(symbol_32);	
				symbol_705.setActual(symbol_101);	
				symbol_704.getParameterSubstitutions().add(symbol_705);
			}
			symbol_175.getTemplateBindings().add(symbol_704);
		}
		symbol_175.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_175);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_176.setName("Collection");
		//symbol_176.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_176.setElementType(symbol_105);
		{
			TemplateBinding symbol_706 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_706.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_707 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_707.setFormal(symbol_32);	
				symbol_707.setActual(symbol_105);	
				symbol_706.getParameterSubstitutions().add(symbol_707);
			}
			symbol_176.getTemplateBindings().add(symbol_706);
		}
		symbol_176.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_176);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_177.setName("Collection");
		//symbol_177.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_177.setElementType(symbol_42);
		{
			TemplateBinding symbol_708 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_708.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_709 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_709.setFormal(symbol_32);	
				symbol_709.setActual(symbol_42);	
				symbol_708.getParameterSubstitutions().add(symbol_709);
			}
			symbol_177.getTemplateBindings().add(symbol_708);
		}
		symbol_177.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_177);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_178.setName("Collection");
		//symbol_178.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_178.setElementType(symbol_63);
		{
			TemplateBinding symbol_710 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_710.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_711 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_711.setFormal(symbol_32);	
				symbol_711.setActual(symbol_63);	
				symbol_710.getParameterSubstitutions().add(symbol_711);
			}
			symbol_178.getTemplateBindings().add(symbol_710);
		}
		symbol_178.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_178);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_179.setName("Collection");
		//symbol_179.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_179.setElementType(symbol_129);
		{
			TemplateBinding symbol_712 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_712.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_713 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_713.setFormal(symbol_32);	
				symbol_713.setActual(symbol_129);	
				symbol_712.getParameterSubstitutions().add(symbol_713);
			}
			symbol_179.getTemplateBindings().add(symbol_712);
		}
		symbol_179.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_179);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_180.setName("Collection");
		//symbol_180.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_180.setElementType(symbol_133);
		{
			TemplateBinding symbol_714 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_714.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_715 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_715.setFormal(symbol_32);	
				symbol_715.setActual(symbol_133);	
				symbol_714.getParameterSubstitutions().add(symbol_715);
			}
			symbol_180.getTemplateBindings().add(symbol_714);
		}
		symbol_180.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_180);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_181.setName("Collection");
		//symbol_181.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_181.setElementType(symbol_36);
		{
			TemplateBinding symbol_716 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_716.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_717 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_717.setFormal(symbol_32);	
				symbol_717.setActual(symbol_36);	
				symbol_716.getParameterSubstitutions().add(symbol_717);
			}
			symbol_181.getTemplateBindings().add(symbol_716);
		}
		symbol_181.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_181);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_182.setName("Collection");
		//symbol_182.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_182.setElementType(symbol_126);
		{
			TemplateBinding symbol_718 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_718.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_719 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_719.setFormal(symbol_32);	
				symbol_719.setActual(symbol_126);	
				symbol_718.getParameterSubstitutions().add(symbol_719);
			}
			symbol_182.getTemplateBindings().add(symbol_718);
		}
		symbol_182.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_182);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_183.setName("Collection");
		//symbol_183.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_183.setElementType(symbol_33);
		{
			TemplateBinding symbol_720 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_720.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_721 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_721.setFormal(symbol_32);	
				symbol_721.setActual(symbol_33);	
				symbol_720.getParameterSubstitutions().add(symbol_721);
			}
			symbol_183.getTemplateBindings().add(symbol_720);
		}
		symbol_183.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_183);
		//
		// ocl::$orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_184.setName("Collection");
		//symbol_184.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_184.setElementType(symbol_136);
		{
			TemplateBinding symbol_722 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_722.setSignature(symbol_31);
			{
				TemplateParameterSubstitution symbol_723 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_723.setFormal(symbol_32);	
				symbol_723.setActual(symbol_136);	
				symbol_722.getParameterSubstitutions().add(symbol_723);
			}
			symbol_184.getTemplateBindings().add(symbol_722);
		}
		symbol_184.getSuperClasses().add(symbol_74); // ocl!OclAny
		symbol_143.getOwnedTypes().add(symbol_184);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Sequence{T}?T()Boolean
		//
		symbol_185.setName("Lambda");
		//symbol_185.setMoniker("Lambda~ocl!Sequence{T}?T()Boolean");
		symbol_185.setContextType(symbol_126);
		symbol_185.setResultType(symbol_19);
		symbol_143.getOwnedTypes().add(symbol_185);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_186.setName("Lambda");
		//symbol_186.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_186.setContextType(symbol_63);
		symbol_186.setResultType(symbol_66);
		symbol_143.getOwnedTypes().add(symbol_186);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedSet{T}?T()Boolean
		//
		symbol_187.setName("Lambda");
		//symbol_187.setMoniker("Lambda~ocl!OrderedSet{T}?T()Boolean");
		symbol_187.setContextType(symbol_115);
		symbol_187.setResultType(symbol_19);
		symbol_143.getOwnedTypes().add(symbol_187);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_188.setName("Lambda");
		//symbol_188.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_188.setContextType(symbol_105);
		symbol_188.setResultType(symbol_111);
		symbol_143.getOwnedTypes().add(symbol_188);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]
		//
		symbol_189.setName("Lambda");
		//symbol_189.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedSet[T]");
		symbol_189.setContextType(symbol_105);
		symbol_189.setResultType(symbol_240);
		symbol_143.getOwnedTypes().add(symbol_189);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny
		//
		symbol_190.setName("Lambda");
		//symbol_190.setMoniker("Lambda~ocl!UniqueCollection{T}?T()ocl!OclAny");
		symbol_190.setContextType(symbol_141);
		symbol_190.setResultType(symbol_74);
		symbol_143.getOwnedTypes().add(symbol_190);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_191.setName("Lambda");
		//symbol_191.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_191.setContextType(symbol_63);
		symbol_191.setResultType(symbol_69);
		symbol_143.getOwnedTypes().add(symbol_191);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()Boolean
		//
		symbol_192.setName("Lambda");
		//symbol_192.setMoniker("Lambda~ocl!Collection{T}?T()Boolean");
		symbol_192.setContextType(symbol_33);
		symbol_192.setResultType(symbol_19);
		symbol_143.getOwnedTypes().add(symbol_192);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_193.setName("Lambda");
		//symbol_193.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_193.setContextType(symbol_33);
		symbol_193.setResultType(symbol_36);
		symbol_143.getOwnedTypes().add(symbol_193);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Bag{T}?T()Boolean
		//
		symbol_194.setName("Lambda");
		//symbol_194.setMoniker("Lambda~ocl!Bag{T}?T()Boolean");
		symbol_194.setContextType(symbol_15);
		symbol_194.setResultType(symbol_19);
		symbol_143.getOwnedTypes().add(symbol_194);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V
		//
		symbol_195.setName("Lambda");
		//symbol_195.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collectNested{V}(T|Lambda~T()V)?V");
		symbol_195.setContextType(symbol_33);
		symbol_195.setResultType(symbol_39);
		symbol_143.getOwnedTypes().add(symbol_195);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny
		//
		symbol_196.setName("Lambda");
		//symbol_196.setMoniker("Lambda~ocl!NonUniqueCollection{T}?T()ocl!OclAny");
		symbol_196.setContextType(symbol_73);
		symbol_196.setResultType(symbol_74);
		symbol_143.getOwnedTypes().add(symbol_196);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_197.setName("Lambda");
		//symbol_197.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_197.setContextType(symbol_105);
		symbol_197.setResultType(symbol_108);
		symbol_143.getOwnedTypes().add(symbol_197);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]
		//
		symbol_198.setName("Lambda");
		//symbol_198.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!Set[T]");
		symbol_198.setContextType(symbol_63);
		symbol_198.setResultType(symbol_252);
		symbol_143.getOwnedTypes().add(symbol_198);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Set{T}?T()Boolean
		//
		symbol_199.setName("Lambda");
		//symbol_199.setMoniker("Lambda~ocl!Set{T}?T()Boolean");
		symbol_199.setContextType(symbol_133);
		symbol_199.setResultType(symbol_19);
		symbol_143.getOwnedTypes().add(symbol_199);
		//
		// ocl::$orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!OclAny
		//
		symbol_200.setName("Lambda");
		//symbol_200.setMoniker("Lambda~ocl!Collection{T}?T()ocl!OclAny");
		symbol_200.setContextType(symbol_33);
		symbol_200.setResultType(symbol_74);
		symbol_143.getOwnedTypes().add(symbol_200);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_201.setName("NonOrderedCollection");
		//symbol_201.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_201.setElementType(symbol_58);
		{
			TemplateBinding symbol_724 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_724.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_725 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_725.setFormal(symbol_62);	
				symbol_725.setActual(symbol_58);	
				symbol_724.getParameterSubstitutions().add(symbol_725);
			}
			symbol_201.getTemplateBindings().add(symbol_724);
		}
		symbol_201.getSuperClasses().add(symbol_163); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_201);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_202.setName("NonOrderedCollection");
		//symbol_202.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_202.setElementType(symbol_33);
		{
			TemplateBinding symbol_726 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_726.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_727 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_727.setFormal(symbol_62);	
				symbol_727.setActual(symbol_33);	
				symbol_726.getParameterSubstitutions().add(symbol_727);
			}
			symbol_202.getTemplateBindings().add(symbol_726);
		}
		symbol_202.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_202);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_203.setName("NonOrderedCollection");
		//symbol_203.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_203.setElementType(symbol_18);
		{
			TemplateBinding symbol_728 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_728.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_729 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_729.setFormal(symbol_62);	
				symbol_729.setActual(symbol_18);	
				symbol_728.getParameterSubstitutions().add(symbol_729);
			}
			symbol_203.getTemplateBindings().add(symbol_728);
		}
		symbol_203.getSuperClasses().add(symbol_174); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_203);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier{T}]
		//
		symbol_204.setName("NonOrderedCollection");
		//symbol_204.setMoniker("ocl!NonOrderedCollection[ocl!Classifier{T}]");
		symbol_204.setElementType(symbol_23);
		{
			TemplateBinding symbol_730 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_730.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_731 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_731.setFormal(symbol_62);	
				symbol_731.setActual(symbol_23);	
				symbol_730.getParameterSubstitutions().add(symbol_731);
			}
			symbol_204.getTemplateBindings().add(symbol_730);
		}
		symbol_204.getSuperClasses().add(symbol_172); // ocl!Collection[ocl!Classifier{T}]
		symbol_143.getOwnedTypes().add(symbol_204);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_205.setName("NonOrderedCollection");
		//symbol_205.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_205.setElementType(symbol_136);
		{
			TemplateBinding symbol_732 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_732.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_733 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_733.setFormal(symbol_62);	
				symbol_733.setActual(symbol_136);	
				symbol_732.getParameterSubstitutions().add(symbol_733);
			}
			symbol_205.getTemplateBindings().add(symbol_732);
		}
		symbol_205.getSuperClasses().add(symbol_184); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_205);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_206.setName("NonOrderedCollection");
		//symbol_206.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_206.setElementType(symbol_63);
		{
			TemplateBinding symbol_734 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_734.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_735 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_735.setFormal(symbol_62);	
				symbol_735.setActual(symbol_63);	
				symbol_734.getParameterSubstitutions().add(symbol_735);
			}
			symbol_206.getTemplateBindings().add(symbol_734);
		}
		symbol_206.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_206);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_207.setName("NonOrderedCollection");
		//symbol_207.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_207.setElementType(symbol_74);
		{
			TemplateBinding symbol_736 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_736.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_737 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_737.setFormal(symbol_62);	
				symbol_737.setActual(symbol_74);	
				symbol_736.getParameterSubstitutions().add(symbol_737);
			}
			symbol_207.getTemplateBindings().add(symbol_736);
		}
		symbol_207.getSuperClasses().add(symbol_161); // ocl!Collection[ocl!OclAny]
		symbol_143.getOwnedTypes().add(symbol_207);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_208.setName("NonOrderedCollection");
		//symbol_208.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_208.setElementType(symbol_94);
		{
			TemplateBinding symbol_738 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_738.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_739 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_739.setFormal(symbol_62);	
				symbol_739.setActual(symbol_94);	
				symbol_738.getParameterSubstitutions().add(symbol_739);
			}
			symbol_208.getTemplateBindings().add(symbol_738);
		}
		symbol_208.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_208);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_209.setName("NonOrderedCollection");
		//symbol_209.setMoniker("ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_209.setElementType(symbol_29);
		{
			TemplateBinding symbol_740 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_740.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_741 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_741.setFormal(symbol_62);	
				symbol_741.setActual(symbol_29);	
				symbol_740.getParameterSubstitutions().add(symbol_741);
			}
			symbol_209.getTemplateBindings().add(symbol_740);
		}
		symbol_209.getSuperClasses().add(symbol_164); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_209);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_210.setName("NonOrderedCollection");
		//symbol_210.setMoniker("ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_210.setElementType(symbol_22);
		{
			TemplateBinding symbol_742 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_742.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_743 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_743.setFormal(symbol_62);	
				symbol_743.setActual(symbol_22);	
				symbol_742.getParameterSubstitutions().add(symbol_743);
			}
			symbol_210.getTemplateBindings().add(symbol_742);
		}
		symbol_210.getSuperClasses().add(symbol_167); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_210);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_211.setName("NonOrderedCollection");
		//symbol_211.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_211.setElementType(symbol_115);
		{
			TemplateBinding symbol_744 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_744.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_745 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_745.setFormal(symbol_62);	
				symbol_745.setActual(symbol_115);	
				symbol_744.getParameterSubstitutions().add(symbol_745);
			}
			symbol_211.getTemplateBindings().add(symbol_744);
		}
		symbol_211.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_143.getOwnedTypes().add(symbol_211);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_212.setName("NonOrderedCollection");
		//symbol_212.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_212.setElementType(symbol_265);
		{
			TemplateBinding symbol_746 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_746.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_747 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_747.setFormal(symbol_62);	
				symbol_747.setActual(symbol_265);	
				symbol_746.getParameterSubstitutions().add(symbol_747);
			}
			symbol_212.getTemplateBindings().add(symbol_746);
		}
		symbol_212.getSuperClasses().add(symbol_170); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_143.getOwnedTypes().add(symbol_212);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_213.setName("NonOrderedCollection");
		//symbol_213.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_213.setElementType(symbol_66);
		{
			TemplateBinding symbol_748 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_748.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_749 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_749.setFormal(symbol_62);	
				symbol_749.setActual(symbol_66);	
				symbol_748.getParameterSubstitutions().add(symbol_749);
			}
			symbol_213.getTemplateBindings().add(symbol_748);
		}
		symbol_213.getSuperClasses().add(symbol_156); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_143.getOwnedTypes().add(symbol_213);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_214.setName("NonOrderedCollection");
		//symbol_214.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_214.setElementType(symbol_101);
		{
			TemplateBinding symbol_750 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_750.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_751 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_751.setFormal(symbol_62);	
				symbol_751.setActual(symbol_101);	
				symbol_750.getParameterSubstitutions().add(symbol_751);
			}
			symbol_214.getTemplateBindings().add(symbol_750);
		}
		symbol_214.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_214);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_215.setName("NonOrderedCollection");
		//symbol_215.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_215.setElementType(symbol_133);
		{
			TemplateBinding symbol_752 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_752.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_753 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_753.setFormal(symbol_62);	
				symbol_753.setActual(symbol_133);	
				symbol_752.getParameterSubstitutions().add(symbol_753);
			}
			symbol_215.getTemplateBindings().add(symbol_752);
		}
		symbol_215.getSuperClasses().add(symbol_180); // ocl!Collection[ocl!Set{T}?T]
		symbol_143.getOwnedTypes().add(symbol_215);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_216.setName("NonOrderedCollection");
		//symbol_216.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_216.setElementType(symbol_15);
		{
			TemplateBinding symbol_754 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_754.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_755 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_755.setFormal(symbol_62);	
				symbol_755.setActual(symbol_15);	
				symbol_754.getParameterSubstitutions().add(symbol_755);
			}
			symbol_216.getTemplateBindings().add(symbol_754);
		}
		symbol_216.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Bag{T}?T]
		symbol_143.getOwnedTypes().add(symbol_216);
		//
		// ocl::$orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_217.setName("NonOrderedCollection");
		//symbol_217.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_217.setElementType(symbol_77);
		{
			TemplateBinding symbol_756 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_756.setSignature(symbol_61);
			{
				TemplateParameterSubstitution symbol_757 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_757.setFormal(symbol_62);	
				symbol_757.setActual(symbol_77);	
				symbol_756.getParameterSubstitutions().add(symbol_757);
			}
			symbol_217.getTemplateBindings().add(symbol_756);
		}
		symbol_217.getSuperClasses().add(symbol_157); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_217);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_218.setName("NonUniqueCollection");
		//symbol_218.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_218.setElementType(symbol_63);
		{
			TemplateBinding symbol_758 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_758.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_759 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_759.setFormal(symbol_72);	
				symbol_759.setActual(symbol_63);	
				symbol_758.getParameterSubstitutions().add(symbol_759);
			}
			symbol_218.getTemplateBindings().add(symbol_758);
		}
		symbol_218.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_218);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_219.setName("NonUniqueCollection");
		//symbol_219.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_219.setElementType(symbol_15);
		{
			TemplateBinding symbol_760 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_760.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_761 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_761.setFormal(symbol_72);	
				symbol_761.setActual(symbol_15);	
				symbol_760.getParameterSubstitutions().add(symbol_761);
			}
			symbol_219.getTemplateBindings().add(symbol_760);
		}
		symbol_219.getSuperClasses().add(symbol_173); // ocl!Collection[ocl!Bag{T}?T]
		symbol_143.getOwnedTypes().add(symbol_219);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_220.setName("NonUniqueCollection");
		//symbol_220.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_220.setElementType(symbol_105);
		{
			TemplateBinding symbol_762 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_762.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_763 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_763.setFormal(symbol_72);	
				symbol_763.setActual(symbol_105);	
				symbol_762.getParameterSubstitutions().add(symbol_763);
			}
			symbol_220.getTemplateBindings().add(symbol_762);
		}
		symbol_220.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_220);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_221.setName("NonUniqueCollection");
		//symbol_221.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_221.setElementType(symbol_129);
		{
			TemplateBinding symbol_764 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_764.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_765 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_765.setFormal(symbol_72);	
				symbol_765.setActual(symbol_129);	
				symbol_764.getParameterSubstitutions().add(symbol_765);
			}
			symbol_221.getTemplateBindings().add(symbol_764);
		}
		symbol_221.getSuperClasses().add(symbol_179); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_221);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_222.setName("NonUniqueCollection");
		//symbol_222.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_222.setElementType(symbol_33);
		{
			TemplateBinding symbol_766 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_766.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_767 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_767.setFormal(symbol_72);	
				symbol_767.setActual(symbol_33);	
				symbol_766.getParameterSubstitutions().add(symbol_767);
			}
			symbol_222.getTemplateBindings().add(symbol_766);
		}
		symbol_222.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_222);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_223.setName("NonUniqueCollection");
		//symbol_223.setMoniker("ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_223.setElementType(symbol_73);
		{
			TemplateBinding symbol_768 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_768.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_769 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_769.setFormal(symbol_72);	
				symbol_769.setActual(symbol_73);	
				symbol_768.getParameterSubstitutions().add(symbol_769);
			}
			symbol_223.getTemplateBindings().add(symbol_768);
		}
		symbol_223.getSuperClasses().add(symbol_169); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_223);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_224.setName("NonUniqueCollection");
		//symbol_224.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_224.setElementType(symbol_137);
		{
			TemplateBinding symbol_770 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_770.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_771 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_771.setFormal(symbol_72);	
				symbol_771.setActual(symbol_137);	
				symbol_770.getParameterSubstitutions().add(symbol_771);
			}
			symbol_224.getTemplateBindings().add(symbol_770);
		}
		symbol_224.getSuperClasses().add(symbol_166); // ocl!Collection[String]
		symbol_143.getOwnedTypes().add(symbol_224);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_225.setName("NonUniqueCollection");
		//symbol_225.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_225.setElementType(symbol_18);
		{
			TemplateBinding symbol_772 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_772.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_773 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_773.setFormal(symbol_72);	
				symbol_773.setActual(symbol_18);	
				symbol_772.getParameterSubstitutions().add(symbol_773);
			}
			symbol_225.getTemplateBindings().add(symbol_772);
		}
		symbol_225.getSuperClasses().add(symbol_174); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_225);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_226.setName("NonUniqueCollection");
		//symbol_226.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_226.setElementType(symbol_126);
		{
			TemplateBinding symbol_774 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_774.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_775 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_775.setFormal(symbol_72);	
				symbol_775.setActual(symbol_126);	
				symbol_774.getParameterSubstitutions().add(symbol_775);
			}
			symbol_226.getTemplateBindings().add(symbol_774);
		}
		symbol_226.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_143.getOwnedTypes().add(symbol_226);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_227.setName("NonUniqueCollection");
		//symbol_227.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_227.setElementType(symbol_66);
		{
			TemplateBinding symbol_776 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_776.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_777 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_777.setFormal(symbol_72);	
				symbol_777.setActual(symbol_66);	
				symbol_776.getParameterSubstitutions().add(symbol_777);
			}
			symbol_227.getTemplateBindings().add(symbol_776);
		}
		symbol_227.getSuperClasses().add(symbol_156); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_143.getOwnedTypes().add(symbol_227);
		//
		// ocl::$orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_228.setName("NonUniqueCollection");
		//symbol_228.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_228.setElementType(symbol_108);
		{
			TemplateBinding symbol_778 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_778.setSignature(symbol_71);
			{
				TemplateParameterSubstitution symbol_779 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_779.setFormal(symbol_72);	
				symbol_779.setActual(symbol_108);	
				symbol_778.getParameterSubstitutions().add(symbol_779);
			}
			symbol_228.getTemplateBindings().add(symbol_778);
		}
		symbol_228.getSuperClasses().add(symbol_162); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_143.getOwnedTypes().add(symbol_228);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_229.setName("OrderedCollection");
		//symbol_229.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_229.setElementType(symbol_73);
		{
			TemplateBinding symbol_780 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_780.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_781 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_781.setFormal(symbol_104);	
				symbol_781.setActual(symbol_73);	
				symbol_780.getParameterSubstitutions().add(symbol_781);
			}
			symbol_229.getTemplateBindings().add(symbol_780);
		}
		symbol_229.getSuperClasses().add(symbol_169); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_229);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_230.setName("OrderedCollection");
		//symbol_230.setMoniker("ocl!OrderedCollection[String]");
		symbol_230.setElementType(symbol_137);
		{
			TemplateBinding symbol_782 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_782.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_783 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_783.setFormal(symbol_104);	
				symbol_783.setActual(symbol_137);	
				symbol_782.getParameterSubstitutions().add(symbol_783);
			}
			symbol_230.getTemplateBindings().add(symbol_782);
		}
		symbol_230.getSuperClasses().add(symbol_166); // ocl!Collection[String]
		symbol_143.getOwnedTypes().add(symbol_230);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_231.setName("OrderedCollection");
		//symbol_231.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_231.setElementType(symbol_115);
		{
			TemplateBinding symbol_784 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_784.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_785 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_785.setFormal(symbol_104);	
				symbol_785.setActual(symbol_115);	
				symbol_784.getParameterSubstitutions().add(symbol_785);
			}
			symbol_231.getTemplateBindings().add(symbol_784);
		}
		symbol_231.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_143.getOwnedTypes().add(symbol_231);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_232.setName("OrderedCollection");
		//symbol_232.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_232.setElementType(symbol_118);
		{
			TemplateBinding symbol_786 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_786.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_787 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_787.setFormal(symbol_104);	
				symbol_787.setActual(symbol_118);	
				symbol_786.getParameterSubstitutions().add(symbol_787);
			}
			symbol_232.getTemplateBindings().add(symbol_786);
		}
		symbol_232.getSuperClasses().add(symbol_168); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_232);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_233.setName("OrderedCollection");
		//symbol_233.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_233.setElementType(symbol_33);
		{
			TemplateBinding symbol_788 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_788.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_789 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_789.setFormal(symbol_104);	
				symbol_789.setActual(symbol_33);	
				symbol_788.getParameterSubstitutions().add(symbol_789);
			}
			symbol_233.getTemplateBindings().add(symbol_788);
		}
		symbol_233.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_233);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_234.setName("OrderedCollection");
		//symbol_234.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_234.setElementType(symbol_126);
		{
			TemplateBinding symbol_790 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_790.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_791 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_791.setFormal(symbol_104);	
				symbol_791.setActual(symbol_126);	
				symbol_790.getParameterSubstitutions().add(symbol_791);
			}
			symbol_234.getTemplateBindings().add(symbol_790);
		}
		symbol_234.getSuperClasses().add(symbol_182); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_143.getOwnedTypes().add(symbol_234);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_235.setName("OrderedCollection");
		//symbol_235.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_235.setElementType(symbol_105);
		{
			TemplateBinding symbol_792 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_792.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_793 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_793.setFormal(symbol_104);	
				symbol_793.setActual(symbol_105);	
				symbol_792.getParameterSubstitutions().add(symbol_793);
			}
			symbol_235.getTemplateBindings().add(symbol_792);
		}
		symbol_235.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_235);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_236.setName("OrderedCollection");
		//symbol_236.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_236.setElementType(symbol_108);
		{
			TemplateBinding symbol_794 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_794.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_795 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_795.setFormal(symbol_104);	
				symbol_795.setActual(symbol_108);	
				symbol_794.getParameterSubstitutions().add(symbol_795);
			}
			symbol_236.getTemplateBindings().add(symbol_794);
		}
		symbol_236.getSuperClasses().add(symbol_162); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_143.getOwnedTypes().add(symbol_236);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_237.setName("OrderedCollection");
		//symbol_237.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_237.setElementType(symbol_129);
		{
			TemplateBinding symbol_796 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_796.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_797 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_797.setFormal(symbol_104);	
				symbol_797.setActual(symbol_129);	
				symbol_796.getParameterSubstitutions().add(symbol_797);
			}
			symbol_237.getTemplateBindings().add(symbol_796);
		}
		symbol_237.getSuperClasses().add(symbol_179); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_237);
		//
		// ocl::$orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_238.setName("OrderedCollection");
		//symbol_238.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_238.setElementType(symbol_141);
		{
			TemplateBinding symbol_798 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_798.setSignature(symbol_103);
			{
				TemplateParameterSubstitution symbol_799 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_799.setFormal(symbol_104);	
				symbol_799.setActual(symbol_141);	
				symbol_798.getParameterSubstitutions().add(symbol_799);
			}
			symbol_238.getTemplateBindings().add(symbol_798);
		}
		symbol_238.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_238);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_239.setName("OrderedSet");
		//symbol_239.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_239.setElementType(symbol_33);
		{
			TemplateBinding symbol_800 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_800.setSignature(symbol_113);
			{
				TemplateParameterSubstitution symbol_801 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_801.setFormal(symbol_114);	
				symbol_801.setActual(symbol_33);	
				symbol_800.getParameterSubstitutions().add(symbol_801);
			}
			symbol_239.getTemplateBindings().add(symbol_800);
		}
		symbol_239.getSuperClasses().add(symbol_233); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_239.getSuperClasses().add(symbol_283); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_239);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_240.setName("OrderedSet");
		//symbol_240.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_240.setElementType(symbol_105);
		{
			TemplateBinding symbol_802 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_802.setSignature(symbol_113);
			{
				TemplateParameterSubstitution symbol_803 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_803.setFormal(symbol_114);	
				symbol_803.setActual(symbol_105);	
				symbol_802.getParameterSubstitutions().add(symbol_803);
			}
			symbol_240.getTemplateBindings().add(symbol_802);
		}
		symbol_240.getSuperClasses().add(symbol_277); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_240.getSuperClasses().add(symbol_235); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_240);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_241.setName("OrderedSet");
		//symbol_241.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_241.setElementType(symbol_141);
		{
			TemplateBinding symbol_804 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_804.setSignature(symbol_113);
			{
				TemplateParameterSubstitution symbol_805 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_805.setFormal(symbol_114);	
				symbol_805.setActual(symbol_141);	
				symbol_804.getParameterSubstitutions().add(symbol_805);
			}
			symbol_241.getTemplateBindings().add(symbol_804);
		}
		symbol_241.getSuperClasses().add(symbol_238); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_241.getSuperClasses().add(symbol_273); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_241);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_242.setName("OrderedSet");
		//symbol_242.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_242.setElementType(symbol_118);
		{
			TemplateBinding symbol_806 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_806.setSignature(symbol_113);
			{
				TemplateParameterSubstitution symbol_807 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_807.setFormal(symbol_114);	
				symbol_807.setActual(symbol_118);	
				symbol_806.getParameterSubstitutions().add(symbol_807);
			}
			symbol_242.getTemplateBindings().add(symbol_806);
		}
		symbol_242.getSuperClasses().add(symbol_232); // ocl!OrderedCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_242.getSuperClasses().add(symbol_278); // ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_242);
		//
		// ocl::$orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_243.setName("OrderedSet");
		//symbol_243.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_243.setElementType(symbol_115);
		{
			TemplateBinding symbol_808 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_808.setSignature(symbol_113);
			{
				TemplateParameterSubstitution symbol_809 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_809.setFormal(symbol_114);	
				symbol_809.setActual(symbol_115);	
				symbol_808.getParameterSubstitutions().add(symbol_809);
			}
			symbol_243.getTemplateBindings().add(symbol_808);
		}
		symbol_243.getSuperClasses().add(symbol_268); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_243.getSuperClasses().add(symbol_231); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_143.getOwnedTypes().add(symbol_243);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_244.setName("Sequence");
		//symbol_244.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_244.setElementType(symbol_126);
		{
			TemplateBinding symbol_810 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_810.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_811 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_811.setFormal(symbol_125);	
				symbol_811.setActual(symbol_126);	
				symbol_810.getParameterSubstitutions().add(symbol_811);
			}
			symbol_244.getTemplateBindings().add(symbol_810);
		}
		symbol_244.getSuperClasses().add(symbol_234); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_244.getSuperClasses().add(symbol_226); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_143.getOwnedTypes().add(symbol_244);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_245.setName("Sequence");
		//symbol_245.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_245.setElementType(symbol_105);
		{
			TemplateBinding symbol_812 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_812.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_813 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_813.setFormal(symbol_125);	
				symbol_813.setActual(symbol_105);	
				symbol_812.getParameterSubstitutions().add(symbol_813);
			}
			symbol_245.getTemplateBindings().add(symbol_812);
		}
		symbol_245.getSuperClasses().add(symbol_220); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_245.getSuperClasses().add(symbol_235); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_245);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_246.setName("Sequence");
		//symbol_246.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_246.setElementType(symbol_73);
		{
			TemplateBinding symbol_814 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_814.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_815 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_815.setFormal(symbol_125);	
				symbol_815.setActual(symbol_73);	
				symbol_814.getParameterSubstitutions().add(symbol_815);
			}
			symbol_246.getTemplateBindings().add(symbol_814);
		}
		symbol_246.getSuperClasses().add(symbol_229); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_246.getSuperClasses().add(symbol_223); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_246);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_247.setName("Sequence");
		//symbol_247.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_247.setElementType(symbol_108);
		{
			TemplateBinding symbol_816 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_816.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_817 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_817.setFormal(symbol_125);	
				symbol_817.setActual(symbol_108);	
				symbol_816.getParameterSubstitutions().add(symbol_817);
			}
			symbol_247.getTemplateBindings().add(symbol_816);
		}
		symbol_247.getSuperClasses().add(symbol_236); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_247.getSuperClasses().add(symbol_228); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_143.getOwnedTypes().add(symbol_247);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_248.setName("Sequence");
		//symbol_248.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_248.setElementType(symbol_129);
		{
			TemplateBinding symbol_818 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_818.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_819 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_819.setFormal(symbol_125);	
				symbol_819.setActual(symbol_129);	
				symbol_818.getParameterSubstitutions().add(symbol_819);
			}
			symbol_248.getTemplateBindings().add(symbol_818);
		}
		symbol_248.getSuperClasses().add(symbol_221); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_248.getSuperClasses().add(symbol_237); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_248);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_249.setName("Sequence");
		//symbol_249.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_249.setElementType(symbol_33);
		{
			TemplateBinding symbol_820 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_820.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_821 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_821.setFormal(symbol_125);	
				symbol_821.setActual(symbol_33);	
				symbol_820.getParameterSubstitutions().add(symbol_821);
			}
			symbol_249.getTemplateBindings().add(symbol_820);
		}
		symbol_249.getSuperClasses().add(symbol_222); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_249.getSuperClasses().add(symbol_233); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_249);
		//
		// ocl::$orphanage::Sequence ocl!Sequence[String]
		//
		symbol_250.setName("Sequence");
		//symbol_250.setMoniker("ocl!Sequence[String]");
		symbol_250.setElementType(symbol_137);
		{
			TemplateBinding symbol_822 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_822.setSignature(symbol_124);
			{
				TemplateParameterSubstitution symbol_823 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_823.setFormal(symbol_125);	
				symbol_823.setActual(symbol_137);	
				symbol_822.getParameterSubstitutions().add(symbol_823);
			}
			symbol_250.getTemplateBindings().add(symbol_822);
		}
		symbol_250.getSuperClasses().add(symbol_230); // ocl!OrderedCollection[String]
		symbol_250.getSuperClasses().add(symbol_224); // ocl!NonUniqueCollection[String]
		symbol_143.getOwnedTypes().add(symbol_250);
		//
		// ocl::$orphanage::Set ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_251.setName("Set");
		//symbol_251.setMoniker("ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_251.setElementType(symbol_22);
		{
			TemplateBinding symbol_824 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_824.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_825 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_825.setFormal(symbol_132);	
				symbol_825.setActual(symbol_22);	
				symbol_824.getParameterSubstitutions().add(symbol_825);
			}
			symbol_251.getTemplateBindings().add(symbol_824);
		}
		symbol_251.getSuperClasses().add(symbol_210); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_251.getSuperClasses().add(symbol_284); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_251);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_252.setName("Set");
		//symbol_252.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_252.setElementType(symbol_63);
		{
			TemplateBinding symbol_826 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_826.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_827 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_827.setFormal(symbol_132);	
				symbol_827.setActual(symbol_63);	
				symbol_826.getParameterSubstitutions().add(symbol_827);
			}
			symbol_252.getTemplateBindings().add(symbol_826);
		}
		symbol_252.getSuperClasses().add(symbol_281); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_252.getSuperClasses().add(symbol_206); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_252);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_253.setName("Set");
		//symbol_253.setMoniker("ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_253.setElementType(symbol_101);
		{
			TemplateBinding symbol_828 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_828.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_829 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_829.setFormal(symbol_132);	
				symbol_829.setActual(symbol_101);	
				symbol_828.getParameterSubstitutions().add(symbol_829);
			}
			symbol_253.getTemplateBindings().add(symbol_828);
		}
		symbol_253.getSuperClasses().add(symbol_270); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_253.getSuperClasses().add(symbol_214); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_253);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_254.setName("Set");
		//symbol_254.setMoniker("ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_254.setElementType(symbol_58);
		{
			TemplateBinding symbol_830 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_830.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_831 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_831.setFormal(symbol_132);	
				symbol_831.setActual(symbol_58);	
				symbol_830.getParameterSubstitutions().add(symbol_831);
			}
			symbol_254.getTemplateBindings().add(symbol_830);
		}
		symbol_254.getSuperClasses().add(symbol_201); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_254.getSuperClasses().add(symbol_271); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_254);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_255.setName("Set");
		//symbol_255.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_255.setElementType(symbol_33);
		{
			TemplateBinding symbol_832 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_832.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_833 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_833.setFormal(symbol_132);	
				symbol_833.setActual(symbol_33);	
				symbol_832.getParameterSubstitutions().add(symbol_833);
			}
			symbol_255.getTemplateBindings().add(symbol_832);
		}
		symbol_255.getSuperClasses().add(symbol_202); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_255.getSuperClasses().add(symbol_283); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_255);
		//
		// ocl::$orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_256.setName("Set");
		//symbol_256.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_256.setElementType(symbol_265);
		{
			TemplateBinding symbol_834 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_834.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_835 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_835.setFormal(symbol_132);	
				symbol_835.setActual(symbol_265);	
				symbol_834.getParameterSubstitutions().add(symbol_835);
			}
			symbol_256.getTemplateBindings().add(symbol_834);
		}
		symbol_256.getSuperClasses().add(symbol_275); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_256.getSuperClasses().add(symbol_212); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_143.getOwnedTypes().add(symbol_256);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_257.setName("Set");
		//symbol_257.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_257.setElementType(symbol_115);
		{
			TemplateBinding symbol_836 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_836.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_837 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_837.setFormal(symbol_132);	
				symbol_837.setActual(symbol_115);	
				symbol_836.getParameterSubstitutions().add(symbol_837);
			}
			symbol_257.getTemplateBindings().add(symbol_836);
		}
		symbol_257.getSuperClasses().add(symbol_268); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_257.getSuperClasses().add(symbol_211); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_143.getOwnedTypes().add(symbol_257);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_258.setName("Set");
		//symbol_258.setMoniker("ocl!Set[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_258.setElementType(symbol_29);
		{
			TemplateBinding symbol_838 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_838.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_839 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_839.setFormal(symbol_132);	
				symbol_839.setActual(symbol_29);	
				symbol_838.getParameterSubstitutions().add(symbol_839);
			}
			symbol_258.getTemplateBindings().add(symbol_838);
		}
		symbol_258.getSuperClasses().add(symbol_280); // ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_258.getSuperClasses().add(symbol_209); // ocl!NonOrderedCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_258);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_259.setName("Set");
		//symbol_259.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_259.setElementType(symbol_74);
		{
			TemplateBinding symbol_840 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_840.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_841 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_841.setFormal(symbol_132);	
				symbol_841.setActual(symbol_74);	
				symbol_840.getParameterSubstitutions().add(symbol_841);
			}
			symbol_259.getTemplateBindings().add(symbol_840);
		}
		symbol_259.getSuperClasses().add(symbol_269); // ocl!UniqueCollection[ocl!OclAny]
		symbol_259.getSuperClasses().add(symbol_207); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_143.getOwnedTypes().add(symbol_259);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_260.setName("Set");
		//symbol_260.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_260.setElementType(symbol_133);
		{
			TemplateBinding symbol_842 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_842.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_843 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_843.setFormal(symbol_132);	
				symbol_843.setActual(symbol_133);	
				symbol_842.getParameterSubstitutions().add(symbol_843);
			}
			symbol_260.getTemplateBindings().add(symbol_842);
		}
		symbol_260.getSuperClasses().add(symbol_215); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_260.getSuperClasses().add(symbol_276); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_143.getOwnedTypes().add(symbol_260);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_261.setName("Set");
		//symbol_261.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_261.setElementType(symbol_136);
		{
			TemplateBinding symbol_844 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_844.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_845 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_845.setFormal(symbol_132);	
				symbol_845.setActual(symbol_136);	
				symbol_844.getParameterSubstitutions().add(symbol_845);
			}
			symbol_261.getTemplateBindings().add(symbol_844);
		}
		symbol_261.getSuperClasses().add(symbol_205); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_261.getSuperClasses().add(symbol_272); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_261);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!Classifier{T}]
		//
		symbol_262.setName("Set");
		//symbol_262.setMoniker("ocl!Set[ocl!Classifier{T}]");
		symbol_262.setElementType(symbol_23);
		{
			TemplateBinding symbol_846 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_846.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_847 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_847.setFormal(symbol_132);	
				symbol_847.setActual(symbol_23);	
				symbol_846.getParameterSubstitutions().add(symbol_847);
			}
			symbol_262.getTemplateBindings().add(symbol_846);
		}
		symbol_262.getSuperClasses().add(symbol_274); // ocl!UniqueCollection[ocl!Classifier{T}]
		symbol_262.getSuperClasses().add(symbol_204); // ocl!NonOrderedCollection[ocl!Classifier{T}]
		symbol_143.getOwnedTypes().add(symbol_262);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_263.setName("Set");
		//symbol_263.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_263.setElementType(symbol_77);
		{
			TemplateBinding symbol_848 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_848.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_849 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_849.setFormal(symbol_132);	
				symbol_849.setActual(symbol_77);	
				symbol_848.getParameterSubstitutions().add(symbol_849);
			}
			symbol_263.getTemplateBindings().add(symbol_848);
		}
		symbol_263.getSuperClasses().add(symbol_282); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_263.getSuperClasses().add(symbol_217); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_263);
		//
		// ocl::$orphanage::Set ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_264.setName("Set");
		//symbol_264.setMoniker("ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_264.setElementType(symbol_94);
		{
			TemplateBinding symbol_850 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_850.setSignature(symbol_131);
			{
				TemplateParameterSubstitution symbol_851 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_851.setFormal(symbol_132);	
				symbol_851.setActual(symbol_94);	
				symbol_850.getParameterSubstitutions().add(symbol_851);
			}
			symbol_264.getTemplateBindings().add(symbol_850);
		}
		symbol_264.getSuperClasses().add(symbol_279); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_264.getSuperClasses().add(symbol_208); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_264);
		//
		// ocl::$orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_265.setName("Tuple");
		//symbol_265.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		{ // ocl::$orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_266.setName("first");
			symbol_266.setType(symbol_33);  // ocl!Collection{T}?T
			
			symbol_266.setIsResolveProxies(true);
			symbol_265.getOwnedAttributes().add(symbol_266);
		}
		{ // ocl::$orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_267.setName("second");
			symbol_267.setType(symbol_54);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_267.setIsResolveProxies(true);
			symbol_265.getOwnedAttributes().add(symbol_267);
		}
		symbol_143.getOwnedTypes().add(symbol_265);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_268.setName("UniqueCollection");
		//symbol_268.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_268.setElementType(symbol_115);
		{
			TemplateBinding symbol_852 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_852.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_853 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_853.setFormal(symbol_140);	
				symbol_853.setActual(symbol_115);	
				symbol_852.getParameterSubstitutions().add(symbol_853);
			}
			symbol_268.getTemplateBindings().add(symbol_852);
		}
		symbol_268.getSuperClasses().add(symbol_165); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_143.getOwnedTypes().add(symbol_268);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_269.setName("UniqueCollection");
		//symbol_269.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_269.setElementType(symbol_74);
		{
			TemplateBinding symbol_854 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_854.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_855 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_855.setFormal(symbol_140);	
				symbol_855.setActual(symbol_74);	
				symbol_854.getParameterSubstitutions().add(symbol_855);
			}
			symbol_269.getTemplateBindings().add(symbol_854);
		}
		symbol_269.getSuperClasses().add(symbol_161); // ocl!Collection[ocl!OclAny]
		symbol_143.getOwnedTypes().add(symbol_269);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_270.setName("UniqueCollection");
		//symbol_270.setMoniker("ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_270.setElementType(symbol_101);
		{
			TemplateBinding symbol_856 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_856.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_857 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_857.setFormal(symbol_140);	
				symbol_857.setActual(symbol_101);	
				symbol_856.getParameterSubstitutions().add(symbol_857);
			}
			symbol_270.getTemplateBindings().add(symbol_856);
		}
		symbol_270.getSuperClasses().add(symbol_175); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_270);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_271.setName("UniqueCollection");
		//symbol_271.setMoniker("ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_271.setElementType(symbol_58);
		{
			TemplateBinding symbol_858 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_858.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_859 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_859.setFormal(symbol_140);	
				symbol_859.setActual(symbol_58);	
				symbol_858.getParameterSubstitutions().add(symbol_859);
			}
			symbol_271.getTemplateBindings().add(symbol_858);
		}
		symbol_271.getSuperClasses().add(symbol_163); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_271);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_272.setName("UniqueCollection");
		//symbol_272.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_272.setElementType(symbol_136);
		{
			TemplateBinding symbol_860 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_860.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_861 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_861.setFormal(symbol_140);	
				symbol_861.setActual(symbol_136);	
				symbol_860.getParameterSubstitutions().add(symbol_861);
			}
			symbol_272.getTemplateBindings().add(symbol_860);
		}
		symbol_272.getSuperClasses().add(symbol_184); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_272);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_273.setName("UniqueCollection");
		//symbol_273.setMoniker("ocl!UniqueCollection[ocl!UniqueCollection{T}?T]");
		symbol_273.setElementType(symbol_141);
		{
			TemplateBinding symbol_862 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_862.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_863 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_863.setFormal(symbol_140);	
				symbol_863.setActual(symbol_141);	
				symbol_862.getParameterSubstitutions().add(symbol_863);
			}
			symbol_273.getTemplateBindings().add(symbol_862);
		}
		symbol_273.getSuperClasses().add(symbol_155); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_273);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier{T}]
		//
		symbol_274.setName("UniqueCollection");
		//symbol_274.setMoniker("ocl!UniqueCollection[ocl!Classifier{T}]");
		symbol_274.setElementType(symbol_23);
		{
			TemplateBinding symbol_864 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_864.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_865 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_865.setFormal(symbol_140);	
				symbol_865.setActual(symbol_23);	
				symbol_864.getParameterSubstitutions().add(symbol_865);
			}
			symbol_274.getTemplateBindings().add(symbol_864);
		}
		symbol_274.getSuperClasses().add(symbol_172); // ocl!Collection[ocl!Classifier{T}]
		symbol_143.getOwnedTypes().add(symbol_274);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_275.setName("UniqueCollection");
		//symbol_275.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_275.setElementType(symbol_265);
		{
			TemplateBinding symbol_866 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_866.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_867 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_867.setFormal(symbol_140);	
				symbol_867.setActual(symbol_265);	
				symbol_866.getParameterSubstitutions().add(symbol_867);
			}
			symbol_275.getTemplateBindings().add(symbol_866);
		}
		symbol_275.getSuperClasses().add(symbol_170); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_143.getOwnedTypes().add(symbol_275);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_276.setName("UniqueCollection");
		//symbol_276.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_276.setElementType(symbol_133);
		{
			TemplateBinding symbol_868 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_868.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_869 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_869.setFormal(symbol_140);	
				symbol_869.setActual(symbol_133);	
				symbol_868.getParameterSubstitutions().add(symbol_869);
			}
			symbol_276.getTemplateBindings().add(symbol_868);
		}
		symbol_276.getSuperClasses().add(symbol_180); // ocl!Collection[ocl!Set{T}?T]
		symbol_143.getOwnedTypes().add(symbol_276);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_277.setName("UniqueCollection");
		//symbol_277.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_277.setElementType(symbol_105);
		{
			TemplateBinding symbol_870 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_870.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_871 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_871.setFormal(symbol_140);	
				symbol_871.setActual(symbol_105);	
				symbol_870.getParameterSubstitutions().add(symbol_871);
			}
			symbol_277.getTemplateBindings().add(symbol_870);
		}
		symbol_277.getSuperClasses().add(symbol_176); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_277);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		//
		symbol_278.setName("UniqueCollection");
		//symbol_278.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}!flatten{T2}()?T2]");
		symbol_278.setElementType(symbol_118);
		{
			TemplateBinding symbol_872 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_872.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_873 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_873.setFormal(symbol_140);	
				symbol_873.setActual(symbol_118);	
				symbol_872.getParameterSubstitutions().add(symbol_873);
			}
			symbol_278.getTemplateBindings().add(symbol_872);
		}
		symbol_278.getSuperClasses().add(symbol_168); // ocl!Collection[ocl!OrderedSet{T}!flatten{T2}()?T2]
		symbol_143.getOwnedTypes().add(symbol_278);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_279.setName("UniqueCollection");
		//symbol_279.setMoniker("ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_279.setElementType(symbol_94);
		{
			TemplateBinding symbol_874 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_874.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_875 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_875.setFormal(symbol_140);	
				symbol_875.setActual(symbol_94);	
				symbol_874.getParameterSubstitutions().add(symbol_875);
			}
			symbol_279.getTemplateBindings().add(symbol_874);
		}
		symbol_279.getSuperClasses().add(symbol_159); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_279);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		//
		symbol_280.setName("UniqueCollection");
		//symbol_280.setMoniker("ocl!UniqueCollection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]");
		symbol_280.setElementType(symbol_29);
		{
			TemplateBinding symbol_876 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_876.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_877 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_877.setFormal(symbol_140);	
				symbol_877.setActual(symbol_29);	
				symbol_876.getParameterSubstitutions().add(symbol_877);
			}
			symbol_280.getTemplateBindings().add(symbol_876);
		}
		symbol_280.getSuperClasses().add(symbol_164); // ocl!Collection[ocl!Classifier{T}!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_280);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_281.setName("UniqueCollection");
		//symbol_281.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_281.setElementType(symbol_63);
		{
			TemplateBinding symbol_878 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_878.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_879 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_879.setFormal(symbol_140);	
				symbol_879.setActual(symbol_63);	
				symbol_878.getParameterSubstitutions().add(symbol_879);
			}
			symbol_281.getTemplateBindings().add(symbol_878);
		}
		symbol_281.getSuperClasses().add(symbol_178); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_281);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_282.setName("UniqueCollection");
		//symbol_282.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_282.setElementType(symbol_77);
		{
			TemplateBinding symbol_880 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_880.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_881 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_881.setFormal(symbol_140);	
				symbol_881.setActual(symbol_77);	
				symbol_880.getParameterSubstitutions().add(symbol_881);
			}
			symbol_282.getTemplateBindings().add(symbol_880);
		}
		symbol_282.getSuperClasses().add(symbol_157); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_282);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_283.setName("UniqueCollection");
		//symbol_283.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_283.setElementType(symbol_33);
		{
			TemplateBinding symbol_882 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_882.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_883 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_883.setFormal(symbol_140);	
				symbol_883.setActual(symbol_33);	
				symbol_882.getParameterSubstitutions().add(symbol_883);
			}
			symbol_283.getTemplateBindings().add(symbol_882);
		}
		symbol_283.getSuperClasses().add(symbol_183); // ocl!Collection[ocl!Collection{T}?T]
		symbol_143.getOwnedTypes().add(symbol_283);
		//
		// ocl::$orphanage::UniqueCollection ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_284.setName("UniqueCollection");
		//symbol_284.setMoniker("ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_284.setElementType(symbol_22);
		{
			TemplateBinding symbol_884 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_884.setSignature(symbol_139);
			{
				TemplateParameterSubstitution symbol_885 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_885.setFormal(symbol_140);	
				symbol_885.setActual(symbol_22);	
				symbol_884.getParameterSubstitutions().add(symbol_885);
			}
			symbol_284.getTemplateBindings().add(symbol_884);
		}
		symbol_284.getSuperClasses().add(symbol_167); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_143.getOwnedTypes().add(symbol_284);
		symbol_1.getNestedPackages().add(symbol_143);
		return symbol_1;
	}
}
