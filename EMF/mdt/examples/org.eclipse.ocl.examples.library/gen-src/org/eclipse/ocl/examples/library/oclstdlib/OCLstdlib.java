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
 * $Id: OCLstdlib.java,v 1.8 2011/03/03 20:09:16 ewillink Exp $
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
		
		Class symbol_20 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier
		TemplateSignature symbol_21 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Classifier!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_22 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_23 = PivotFactory.eINSTANCE.createClass(); // ocl!Classifier!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_24 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection{T}
		TemplateSignature symbol_25 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!
		TypeTemplateParameter symbol_26 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_27 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}?T
		
		TemplateSignature symbol_28 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_29 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_30 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		TemplateSignature symbol_31 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_32 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_33 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
		
		
		Class symbol_46 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration
		
		PrimitiveType symbol_47 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_48 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection{T}
		TemplateSignature symbol_49 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_50 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_51 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_52 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_53 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_54 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_55 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection{T}
		TemplateSignature symbol_56 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_57 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_58 = PivotFactory.eINSTANCE.createClass(); // ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_59 = PivotFactory.eINSTANCE.createAnyType(); // ocl!OclAny
		TemplateSignature symbol_60 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsSet{OclSelf}()!
		TypeTemplateParameter symbol_61 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_62 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_63 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_64 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_65 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
		
		
		InvalidType symbol_66 = PivotFactory.eINSTANCE.createInvalidType(); // ocl!OclInvalid
		
		Class symbol_67 = PivotFactory.eINSTANCE.createClass(); // ocl!OclMessage
		
		Class symbol_68 = PivotFactory.eINSTANCE.createClass(); // ocl!OclState
		
		Class symbol_69 = PivotFactory.eINSTANCE.createClass(); // ocl!OclTuple
		
		VoidType symbol_70 = PivotFactory.eINSTANCE.createVoidType(); // ocl!OclVoid
		
		CollectionType symbol_71 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection{T}
		TemplateSignature symbol_72 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_73 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_74 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_75 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_76 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_78 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet{T}
		TemplateSignature symbol_79 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_80 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_81 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}?T
		
		
		PrimitiveType symbol_82 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_83 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_84 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_85 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{T}(ocl!Classifier)?T
		
		
		SequenceType symbol_86 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence{T}
		TemplateSignature symbol_87 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!
		TypeTemplateParameter symbol_88 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}?T
		
		TemplateSignature symbol_90 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_91 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_92 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_93 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set{T}
		TemplateSignature symbol_94 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!
		TypeTemplateParameter symbol_95 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_96 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}?T
		
		TemplateSignature symbol_97 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_98 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_99 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_100 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_101 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection{T}
		TemplateSignature symbol_102 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_103 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_104 = PivotFactory.eINSTANCE.createClass(); // ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_105 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_106 = PivotFactory.eINSTANCE.createPackage(); // orphanage
		BagType symbol_107 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_108 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Collection{T}?T]
		
		BagType symbol_109 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		BagType symbol_110 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}?T]
		
		BagType symbol_111 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_112 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_113 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_114 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		CollectionType symbol_115 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid]
		
		CollectionType symbol_116 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_117 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_118 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_119 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_120 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_121 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_122 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_123 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_124 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		CollectionType symbol_125 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_126 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_127 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_128 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_129 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_130 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_131 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_132 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_133 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_134 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration]
		
		LambdaType symbol_140 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_141 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_142 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		CollectionType symbol_143 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_153 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_154 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_155 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration]
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		OrderedSetType symbol_179 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		OrderedSetType symbol_180 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_181 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		OrderedSetType symbol_182 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_183 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_184 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_185 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_186 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_187 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_188 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SequenceType symbol_189 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SetType symbol_190 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		SetType symbol_191 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_192 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_193 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_194 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean]
		
		SetType symbol_195 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		SetType symbol_196 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_197 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_198 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid]
		
		SetType symbol_199 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_200 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid]
		
		SetType symbol_201 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration]
		
		SetType symbol_202 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		TupleType symbol_203 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_204 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_205 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_206 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_207 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_208 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid]
		
		CollectionType symbol_209 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_210 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_211 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid]
		
		CollectionType symbol_212 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_213 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_214 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration]
		
		CollectionType symbol_215 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_216 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_217 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		CollectionType symbol_218 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_219 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean]
		
		CollectionType symbol_220 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		
		

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
		symbol_12.getSuperClasses().add(symbol_167); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_158); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_221 = PivotFactory.eINSTANCE.createOperation();
			symbol_221.setName("<>");
			//symbol_221.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_221.setType(symbol_19);  // Boolean
			symbol_221.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_222 = PivotFactory.eINSTANCE.createParameter();
			symbol_222.setName("object2");
			//symbol_222.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_222.setType(symbol_59);  // ocl!OclAny
			symbol_222.setLower(BigInteger.valueOf(0));
			
			symbol_221.getOwnedParameters().add(symbol_222);
			symbol_221.setPrecedence(symbol_7);
			symbol_221.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_221);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_223 = PivotFactory.eINSTANCE.createOperation();
			symbol_223.setName("=");
			//symbol_223.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_223.setType(symbol_19);  // Boolean
			symbol_223.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_224 = PivotFactory.eINSTANCE.createParameter();
			symbol_224.setName("object2");
			//symbol_224.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_224.setType(symbol_59);  // ocl!OclAny
			symbol_224.setLower(BigInteger.valueOf(0));
			
			symbol_223.getOwnedParameters().add(symbol_224);
			symbol_223.setPrecedence(symbol_7);
			symbol_223.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_223);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_225 = PivotFactory.eINSTANCE.createOperation();
			symbol_225.setName("excluding");
			//symbol_225.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_225.setType(symbol_110);  // ocl!Bag[ocl!Bag{T}?T]
			symbol_225.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_226 = PivotFactory.eINSTANCE.createParameter();
			symbol_226.setName("object");
			//symbol_226.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_226.setType(symbol_59);  // ocl!OclAny
			symbol_226.setLower(BigInteger.valueOf(0));
			
			symbol_225.getOwnedParameters().add(symbol_226);
			symbol_225.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_225);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_227 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_227.setOwnedTemplateSignature(symbol_16);
			symbol_227.setName("flatten");
			//symbol_227.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_227.setType(symbol_111);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			symbol_227.setLower(BigInteger.valueOf(0));
			
			symbol_227.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_227);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_228 = PivotFactory.eINSTANCE.createOperation();
			symbol_228.setName("including");
			//symbol_228.setMoniker("ocl!Bag{T}!including(T)");
			symbol_228.setType(symbol_110);  // ocl!Bag[ocl!Bag{T}?T]
			symbol_228.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_229 = PivotFactory.eINSTANCE.createParameter();
			symbol_229.setName("object");
			//symbol_229.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_229.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_229.setLower(BigInteger.valueOf(0));
			
			symbol_228.getOwnedParameters().add(symbol_229);
			symbol_228.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_228);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T)
			Iteration symbol_230 = PivotFactory.eINSTANCE.createIteration();
			symbol_230.setName("reject");
			//symbol_230.setMoniker("ocl!Bag{T}!reject(T)");
			symbol_230.setType(symbol_110);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_231 = PivotFactory.eINSTANCE.createParameter();
			symbol_231.setName("i");
			symbol_231.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_230.getOwnedIterators().add(symbol_231);
			symbol_230.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_230);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T)
			Iteration symbol_232 = PivotFactory.eINSTANCE.createIteration();
			symbol_232.setName("select");
			//symbol_232.setMoniker("ocl!Bag{T}!select(T)");
			symbol_232.setType(symbol_110);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_233 = PivotFactory.eINSTANCE.createParameter();
			symbol_233.setName("i");
			symbol_233.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_232.getOwnedIterators().add(symbol_233);
			symbol_232.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_232);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_234 = PivotFactory.eINSTANCE.createOperation();
			symbol_234.setName("<>");
			//symbol_234.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_234.setType(symbol_19);  // Boolean
			symbol_234.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_235 = PivotFactory.eINSTANCE.createParameter();
			symbol_235.setName("object2");
			//symbol_235.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_235.setType(symbol_59);  // ocl!OclAny
			symbol_235.setLower(BigInteger.valueOf(0));
			
			symbol_234.getOwnedParameters().add(symbol_235);
			symbol_234.setPrecedence(symbol_7);
			symbol_234.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_234);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_236 = PivotFactory.eINSTANCE.createOperation();
			symbol_236.setName("=");
			//symbol_236.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_236.setType(symbol_19);  // Boolean
			symbol_236.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_237 = PivotFactory.eINSTANCE.createParameter();
			symbol_237.setName("object2");
			//symbol_237.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_237.setType(symbol_59);  // ocl!OclAny
			symbol_237.setLower(BigInteger.valueOf(0));
			
			symbol_236.getOwnedParameters().add(symbol_237);
			symbol_236.setPrecedence(symbol_7);
			symbol_236.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_236);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances()
			Operation symbol_238 = PivotFactory.eINSTANCE.createOperation();
			symbol_238.setName("allInstances");
			//symbol_238.setMoniker("Boolean!allInstances()");
			symbol_238.setType(symbol_194);  // ocl!Set[Boolean]
			symbol_238.setLower(BigInteger.valueOf(0));
			
			symbol_238.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_238);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_239 = PivotFactory.eINSTANCE.createOperation();
			symbol_239.setName("and");
			//symbol_239.setMoniker("Boolean!and(Boolean)");
			symbol_239.setType(symbol_19);  // Boolean
			symbol_239.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_240 = PivotFactory.eINSTANCE.createParameter();
			symbol_240.setName("b");
			//symbol_240.setMoniker("Boolean!and(Boolean)!b");
			symbol_240.setType(symbol_19);  // Boolean
			symbol_240.setLower(BigInteger.valueOf(0));
			
			symbol_239.getOwnedParameters().add(symbol_240);
			symbol_239.setPrecedence(symbol_8);
			symbol_239.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_239);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_241 = PivotFactory.eINSTANCE.createOperation();
			symbol_241.setName("implies");
			//symbol_241.setMoniker("Boolean!implies(Boolean)");
			symbol_241.setType(symbol_19);  // Boolean
			symbol_241.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_242 = PivotFactory.eINSTANCE.createParameter();
			symbol_242.setName("b");
			//symbol_242.setMoniker("Boolean!implies(Boolean)!b");
			symbol_242.setType(symbol_19);  // Boolean
			symbol_242.setLower(BigInteger.valueOf(0));
			
			symbol_241.getOwnedParameters().add(symbol_242);
			symbol_241.setPrecedence(symbol_11);
			symbol_241.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_241);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_243 = PivotFactory.eINSTANCE.createOperation();
			symbol_243.setName("not");
			//symbol_243.setMoniker("Boolean!not()");
			symbol_243.setType(symbol_19);  // Boolean
			symbol_243.setLower(BigInteger.valueOf(0));
			
			symbol_243.setPrecedence(symbol_3);
			symbol_243.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_243);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_244 = PivotFactory.eINSTANCE.createOperation();
			symbol_244.setName("or");
			//symbol_244.setMoniker("Boolean!or(Boolean)");
			symbol_244.setType(symbol_19);  // Boolean
			symbol_244.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_245 = PivotFactory.eINSTANCE.createParameter();
			symbol_245.setName("b");
			//symbol_245.setMoniker("Boolean!or(Boolean)!b");
			symbol_245.setType(symbol_19);  // Boolean
			symbol_245.setLower(BigInteger.valueOf(0));
			
			symbol_244.getOwnedParameters().add(symbol_245);
			symbol_244.setPrecedence(symbol_9);
			symbol_244.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_244);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_246 = PivotFactory.eINSTANCE.createOperation();
			symbol_246.setName("toString");
			//symbol_246.setMoniker("Boolean!toString()");
			symbol_246.setType(symbol_100);  // String
			symbol_246.setLower(BigInteger.valueOf(0));
			
			symbol_246.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_246);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_247 = PivotFactory.eINSTANCE.createOperation();
			symbol_247.setName("xor");
			//symbol_247.setMoniker("Boolean!xor(Boolean)");
			symbol_247.setType(symbol_19);  // Boolean
			symbol_247.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_248 = PivotFactory.eINSTANCE.createParameter();
			symbol_248.setName("b");
			//symbol_248.setMoniker("Boolean!xor(Boolean)!b");
			symbol_248.setType(symbol_19);  // Boolean
			symbol_248.setLower(BigInteger.valueOf(0));
			
			symbol_247.getOwnedParameters().add(symbol_248);
			symbol_247.setPrecedence(symbol_10);
			symbol_247.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_247);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl!Classifier
		//
		symbol_20.setName("Classifier");
		//symbol_20.setMoniker("ocl!Classifier");
		symbol_20.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::Classifier::allInstances() ocl!Classifier!allInstances{OclSelf}()
			Operation symbol_249 = PivotFactory.eINSTANCE.createOperation();
			symbol_23.setName("OclSelf");
			symbol_22.setOwnedParameteredElement(symbol_23);
			symbol_21.getOwnedParameters().add(symbol_22);
			
			symbol_249.setOwnedTemplateSignature(symbol_21);
			symbol_249.setName("allInstances");
			//symbol_249.setMoniker("ocl!Classifier!allInstances{OclSelf}()");
			symbol_249.setType(symbol_192);  // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
			symbol_249.setLower(BigInteger.valueOf(0));
			
			symbol_249.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_20.getOwnedOperations().add(symbol_249);
		}
		symbol_1.getOwnedTypes().add(symbol_20);
		//
		// ocl::Collection ocl!Collection{T}
		//
		symbol_24.setName("Collection");
		//symbol_24.setMoniker("ocl!Collection{T}");
		symbol_24.setElementType(symbol_27);
		symbol_27.setName("T");
		symbol_26.setOwnedParameteredElement(symbol_27);
		symbol_25.getOwnedParameters().add(symbol_26);
		
		symbol_24.setOwnedTemplateSignature(symbol_25);
		symbol_24.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::Collection::<>() ocl!Collection{T}!<>(ocl!OclAny)
			Operation symbol_250 = PivotFactory.eINSTANCE.createOperation();
			symbol_250.setName("<>");
			//symbol_250.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_250.setType(symbol_19);  // Boolean
			symbol_250.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_251 = PivotFactory.eINSTANCE.createParameter();
			symbol_251.setName("object2");
			//symbol_251.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_251.setType(symbol_59);  // ocl!OclAny
			symbol_251.setLower(BigInteger.valueOf(0));
			
			symbol_250.getOwnedParameters().add(symbol_251);
			symbol_250.setPrecedence(symbol_7);
			symbol_250.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_250);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_252 = PivotFactory.eINSTANCE.createOperation();
			symbol_252.setName("=");
			//symbol_252.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_252.setType(symbol_19);  // Boolean
			symbol_252.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_253 = PivotFactory.eINSTANCE.createParameter();
			symbol_253.setName("object2");
			//symbol_253.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_253.setType(symbol_59);  // ocl!OclAny
			symbol_253.setLower(BigInteger.valueOf(0));
			
			symbol_252.getOwnedParameters().add(symbol_253);
			symbol_252.setPrecedence(symbol_7);
			symbol_252.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_252);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T)
			Iteration symbol_254 = PivotFactory.eINSTANCE.createIteration();
			symbol_254.setName("any");
			//symbol_254.setMoniker("ocl!Collection{T}!any(T)");
			symbol_254.setType(symbol_27);  // ocl!Collection{T}?T
			
			Parameter symbol_255 = PivotFactory.eINSTANCE.createParameter();
			symbol_255.setName("i");
			symbol_255.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_254.getOwnedIterators().add(symbol_255);
			symbol_254.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_254);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_256 = PivotFactory.eINSTANCE.createOperation();
			symbol_256.setName("asBag");
			//symbol_256.setMoniker("ocl!Collection{T}!asBag()");
			symbol_256.setType(symbol_108);  // ocl!Bag[ocl!Collection{T}?T]
			symbol_256.setLower(BigInteger.valueOf(0));
			
			symbol_256.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_256);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_257 = PivotFactory.eINSTANCE.createOperation();
			symbol_257.setName("asOrderedSet");
			//symbol_257.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_257.setType(symbol_179);  // ocl!OrderedSet[ocl!Collection{T}?T]
			symbol_257.setLower(BigInteger.valueOf(0));
			
			symbol_257.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_257);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_258 = PivotFactory.eINSTANCE.createOperation();
			symbol_258.setName("asSequence");
			//symbol_258.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_258.setType(symbol_185);  // ocl!Sequence[ocl!Collection{T}?T]
			symbol_258.setLower(BigInteger.valueOf(0));
			
			symbol_258.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_258);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_259 = PivotFactory.eINSTANCE.createOperation();
			symbol_259.setName("asSet");
			//symbol_259.setMoniker("ocl!Collection{T}!asSet()");
			symbol_259.setType(symbol_195);  // ocl!Set[ocl!Collection{T}?T]
			symbol_259.setLower(BigInteger.valueOf(0));
			
			symbol_259.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_259);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_260 = PivotFactory.eINSTANCE.createIteration();
			symbol_30.setName("V");
			symbol_29.setOwnedParameteredElement(symbol_30);
			symbol_28.getOwnedParameters().add(symbol_29);
			
			symbol_260.setOwnedTemplateSignature(symbol_28);
			symbol_260.setName("collect");
			//symbol_260.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_260.setType(symbol_130);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_261 = PivotFactory.eINSTANCE.createParameter();
			symbol_261.setName("i");
			symbol_261.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_260.getOwnedIterators().add(symbol_261);
			Parameter symbol_262 = PivotFactory.eINSTANCE.createParameter();
			symbol_262.setName("body");
			//symbol_262.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_262.setType(symbol_140);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_260.getOwnedParameters().add(symbol_262);
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested(T)
			Iteration symbol_263 = PivotFactory.eINSTANCE.createIteration();
			symbol_263.setName("collectNested");
			//symbol_263.setMoniker("ocl!Collection{T}!collectNested(T)");
			symbol_263.setType(symbol_126);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("i");
			symbol_264.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_263.getOwnedIterators().add(symbol_264);
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_263);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_265 = PivotFactory.eINSTANCE.createOperation();
			symbol_265.setName("count");
			//symbol_265.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_265.setType(symbol_47);  // Integer
			symbol_265.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_266 = PivotFactory.eINSTANCE.createParameter();
			symbol_266.setName("object");
			//symbol_266.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_266.setType(symbol_59);  // ocl!OclAny
			symbol_266.setLower(BigInteger.valueOf(0));
			
			symbol_265.getOwnedParameters().add(symbol_266);
			symbol_265.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_265);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_267 = PivotFactory.eINSTANCE.createOperation();
			symbol_267.setName("excludes");
			//symbol_267.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_267.setType(symbol_19);  // Boolean
			symbol_267.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_268 = PivotFactory.eINSTANCE.createParameter();
			symbol_268.setName("object");
			//symbol_268.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_268.setType(symbol_59);  // ocl!OclAny
			symbol_268.setLower(BigInteger.valueOf(0));
			
			symbol_267.getOwnedParameters().add(symbol_268);
			symbol_267.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_267);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_269 = PivotFactory.eINSTANCE.createOperation();
			symbol_33.setName("T2");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_269.setOwnedTemplateSignature(symbol_31);
			symbol_269.setName("excludesAll");
			//symbol_269.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_269.setType(symbol_19);  // Boolean
			symbol_269.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_270 = PivotFactory.eINSTANCE.createParameter();
			symbol_270.setName("c2");
			//symbol_270.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_270.setType(symbol_128);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			symbol_270.setLower(BigInteger.valueOf(0));
			
			symbol_269.getOwnedParameters().add(symbol_270);
			symbol_269.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_269);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_271 = PivotFactory.eINSTANCE.createOperation();
			symbol_271.setName("excluding");
			//symbol_271.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_271.setType(symbol_126);  // ocl!Collection[ocl!Collection{T}?T]
			symbol_271.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_272 = PivotFactory.eINSTANCE.createParameter();
			symbol_272.setName("object");
			//symbol_272.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_272.setType(symbol_59);  // ocl!OclAny
			symbol_272.setLower(BigInteger.valueOf(0));
			
			symbol_271.getOwnedParameters().add(symbol_272);
			symbol_271.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_271);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T)
			Iteration symbol_273 = PivotFactory.eINSTANCE.createIteration();
			symbol_273.setName("exists");
			//symbol_273.setMoniker("ocl!Collection{T}!exists(T)");
			symbol_273.setType(symbol_19);  // Boolean
			
			Parameter symbol_274 = PivotFactory.eINSTANCE.createParameter();
			symbol_274.setName("i");
			symbol_274.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_273.getOwnedIterators().add(symbol_274);
			symbol_273.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_273);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T)
			Iteration symbol_275 = PivotFactory.eINSTANCE.createIteration();
			symbol_275.setName("exists");
			//symbol_275.setMoniker("ocl!Collection{T}!exists(T,T)");
			symbol_275.setType(symbol_19);  // Boolean
			
			Parameter symbol_276 = PivotFactory.eINSTANCE.createParameter();
			symbol_276.setName("i");
			symbol_276.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_275.getOwnedIterators().add(symbol_276);
			Parameter symbol_277 = PivotFactory.eINSTANCE.createParameter();
			symbol_277.setName("j");
			symbol_277.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_275.getOwnedIterators().add(symbol_277);
			symbol_275.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_275);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_278 = PivotFactory.eINSTANCE.createOperation();
			symbol_36.setName("T2");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_278.setOwnedTemplateSignature(symbol_34);
			symbol_278.setName("flatten");
			//symbol_278.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_278.setType(symbol_122);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			symbol_278.setLower(BigInteger.valueOf(0));
			
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T)
			Iteration symbol_279 = PivotFactory.eINSTANCE.createIteration();
			symbol_279.setName("forAll");
			//symbol_279.setMoniker("ocl!Collection{T}!forAll(T)");
			symbol_279.setType(symbol_19);  // Boolean
			
			Parameter symbol_280 = PivotFactory.eINSTANCE.createParameter();
			symbol_280.setName("i");
			symbol_280.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_279.getOwnedIterators().add(symbol_280);
			symbol_279.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_279);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T)
			Iteration symbol_281 = PivotFactory.eINSTANCE.createIteration();
			symbol_281.setName("forAll");
			//symbol_281.setMoniker("ocl!Collection{T}!forAll(T,T)");
			symbol_281.setType(symbol_19);  // Boolean
			
			Parameter symbol_282 = PivotFactory.eINSTANCE.createParameter();
			symbol_282.setName("i");
			symbol_282.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_281.getOwnedIterators().add(symbol_282);
			Parameter symbol_283 = PivotFactory.eINSTANCE.createParameter();
			symbol_283.setName("j");
			symbol_283.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_281.getOwnedIterators().add(symbol_283);
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_284 = PivotFactory.eINSTANCE.createOperation();
			symbol_284.setName("includes");
			//symbol_284.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_284.setType(symbol_19);  // Boolean
			symbol_284.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_285 = PivotFactory.eINSTANCE.createParameter();
			symbol_285.setName("object");
			//symbol_285.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_285.setType(symbol_59);  // ocl!OclAny
			symbol_285.setLower(BigInteger.valueOf(0));
			
			symbol_284.getOwnedParameters().add(symbol_285);
			symbol_284.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_284);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_286 = PivotFactory.eINSTANCE.createOperation();
			symbol_39.setName("T2");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_286.setOwnedTemplateSignature(symbol_37);
			symbol_286.setName("includesAll");
			//symbol_286.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_286.setType(symbol_19);  // Boolean
			symbol_286.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_287 = PivotFactory.eINSTANCE.createParameter();
			symbol_287.setName("c2");
			//symbol_287.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_287.setType(symbol_119);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			symbol_287.setLower(BigInteger.valueOf(0));
			
			symbol_286.getOwnedParameters().add(symbol_287);
			symbol_286.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_286);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_288 = PivotFactory.eINSTANCE.createOperation();
			symbol_288.setName("including");
			//symbol_288.setMoniker("ocl!Collection{T}!including(T)");
			symbol_288.setType(symbol_126);  // ocl!Collection[ocl!Collection{T}?T]
			symbol_288.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_289 = PivotFactory.eINSTANCE.createParameter();
			symbol_289.setName("object");
			//symbol_289.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_289.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_289.setLower(BigInteger.valueOf(0));
			
			symbol_288.getOwnedParameters().add(symbol_289);
			symbol_288.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_288);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_290 = PivotFactory.eINSTANCE.createOperation();
			symbol_290.setName("isEmpty");
			//symbol_290.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_290.setType(symbol_19);  // Boolean
			symbol_290.setLower(BigInteger.valueOf(0));
			
			symbol_290.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_290);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T)
			Iteration symbol_291 = PivotFactory.eINSTANCE.createIteration();
			symbol_291.setName("isUnique");
			//symbol_291.setMoniker("ocl!Collection{T}!isUnique(T)");
			symbol_291.setType(symbol_19);  // Boolean
			
			Parameter symbol_292 = PivotFactory.eINSTANCE.createParameter();
			symbol_292.setName("i");
			symbol_292.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_291.getOwnedIterators().add(symbol_292);
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_293 = PivotFactory.eINSTANCE.createIteration();
			symbol_42.setName("Tacc");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_293.setOwnedTemplateSignature(symbol_40);
			symbol_293.setName("iterate");
			//symbol_293.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_293.setType(symbol_42);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_294 = PivotFactory.eINSTANCE.createParameter();
			symbol_294.setName("i");
			symbol_294.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_293.getOwnedIterators().add(symbol_294);
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("acc");
			symbol_295.setType(symbol_42);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_293.getOwnedAccumulators().add(symbol_295);
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_296 = PivotFactory.eINSTANCE.createOperation();
			symbol_296.setName("max");
			//symbol_296.setMoniker("ocl!Collection{T}!max()");
			symbol_296.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_296.setLower(BigInteger.valueOf(0));
			
			symbol_296.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_296);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_297 = PivotFactory.eINSTANCE.createOperation();
			symbol_297.setName("min");
			//symbol_297.setMoniker("ocl!Collection{T}!min()");
			symbol_297.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_297.setLower(BigInteger.valueOf(0));
			
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_297);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_298 = PivotFactory.eINSTANCE.createOperation();
			symbol_298.setName("notEmpty");
			//symbol_298.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_298.setType(symbol_19);  // Boolean
			symbol_298.setLower(BigInteger.valueOf(0));
			
			symbol_298.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_298);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T)
			Iteration symbol_299 = PivotFactory.eINSTANCE.createIteration();
			symbol_299.setName("one");
			//symbol_299.setMoniker("ocl!Collection{T}!one(T)");
			symbol_299.setType(symbol_19);  // Boolean
			
			Parameter symbol_300 = PivotFactory.eINSTANCE.createParameter();
			symbol_300.setName("i");
			symbol_300.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_299.getOwnedIterators().add(symbol_300);
			symbol_299.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_299);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_301 = PivotFactory.eINSTANCE.createOperation();
			symbol_45.setName("T2");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_301.setOwnedTemplateSignature(symbol_43);
			symbol_301.setName("product");
			//symbol_301.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_301.setType(symbol_190);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			symbol_301.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_302 = PivotFactory.eINSTANCE.createParameter();
			symbol_302.setName("c2");
			//symbol_302.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_302.setType(symbol_116);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			symbol_302.setLower(BigInteger.valueOf(0));
			
			symbol_301.getOwnedParameters().add(symbol_302);
			symbol_301.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_301);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T)
			Iteration symbol_303 = PivotFactory.eINSTANCE.createIteration();
			symbol_303.setName("reject");
			//symbol_303.setMoniker("ocl!Collection{T}!reject(T)");
			symbol_303.setType(symbol_126);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_304 = PivotFactory.eINSTANCE.createParameter();
			symbol_304.setName("i");
			symbol_304.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_303.getOwnedIterators().add(symbol_304);
			symbol_303.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_303);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T)
			Iteration symbol_305 = PivotFactory.eINSTANCE.createIteration();
			symbol_305.setName("select");
			//symbol_305.setMoniker("ocl!Collection{T}!select(T)");
			symbol_305.setType(symbol_126);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_306 = PivotFactory.eINSTANCE.createParameter();
			symbol_306.setName("i");
			symbol_306.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_305.getOwnedIterators().add(symbol_306);
			symbol_305.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_305);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_307 = PivotFactory.eINSTANCE.createOperation();
			symbol_307.setName("size");
			//symbol_307.setMoniker("ocl!Collection{T}!size()");
			symbol_307.setType(symbol_47);  // Integer
			symbol_307.setLower(BigInteger.valueOf(0));
			
			symbol_307.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_307);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T)
			Iteration symbol_308 = PivotFactory.eINSTANCE.createIteration();
			symbol_308.setName("sortedBy");
			//symbol_308.setMoniker("ocl!Collection{T}!sortedBy(T)");
			symbol_308.setType(symbol_174);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_309 = PivotFactory.eINSTANCE.createParameter();
			symbol_309.setName("i");
			symbol_309.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_308.getOwnedIterators().add(symbol_309);
			symbol_308.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_308);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_310 = PivotFactory.eINSTANCE.createOperation();
			symbol_310.setName("sum");
			//symbol_310.setMoniker("ocl!Collection{T}!sum()");
			symbol_310.setType(symbol_27);  // ocl!Collection{T}?T
			symbol_310.setLower(BigInteger.valueOf(0));
			
			symbol_310.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_24.getOwnedOperations().add(symbol_310);
		}
		symbol_1.getOwnedTypes().add(symbol_24);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_46.setName("Enumeration");
		//symbol_46.setMoniker("ocl!Enumeration");
		symbol_46.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances()
			Operation symbol_311 = PivotFactory.eINSTANCE.createOperation();
			symbol_311.setName("allInstances");
			//symbol_311.setMoniker("ocl!Enumeration!allInstances()");
			symbol_311.setType(symbol_201);  // ocl!Set[ocl!Enumeration]
			symbol_311.setLower(BigInteger.valueOf(0));
			
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_46.getOwnedOperations().add(symbol_311);
		}
		symbol_1.getOwnedTypes().add(symbol_46);
		//
		// ocl::Integer Integer
		//
		symbol_47.setName("Integer");
		//symbol_47.setMoniker("Integer");
		symbol_47.getSuperClasses().add(symbol_82); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_312 = PivotFactory.eINSTANCE.createOperation();
			symbol_312.setName("*");
			//symbol_312.setMoniker("Integer!*(Integer)");
			symbol_312.setType(symbol_47);  // Integer
			symbol_312.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_313 = PivotFactory.eINSTANCE.createParameter();
			symbol_313.setName("i");
			//symbol_313.setMoniker("Integer!*(Integer)!i");
			symbol_313.setType(symbol_47);  // Integer
			symbol_313.setLower(BigInteger.valueOf(0));
			
			symbol_312.getOwnedParameters().add(symbol_313);
			symbol_312.setPrecedence(symbol_4);
			symbol_312.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_312);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_314 = PivotFactory.eINSTANCE.createOperation();
			symbol_314.setName("+");
			//symbol_314.setMoniker("Integer!+(Integer)");
			symbol_314.setType(symbol_47);  // Integer
			symbol_314.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_315 = PivotFactory.eINSTANCE.createParameter();
			symbol_315.setName("i");
			//symbol_315.setMoniker("Integer!+(Integer)!i");
			symbol_315.setType(symbol_47);  // Integer
			symbol_315.setLower(BigInteger.valueOf(0));
			
			symbol_314.getOwnedParameters().add(symbol_315);
			symbol_314.setPrecedence(symbol_5);
			symbol_314.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_314);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("-");
			//symbol_316.setMoniker("Integer!-()");
			symbol_316.setType(symbol_47);  // Integer
			symbol_316.setLower(BigInteger.valueOf(0));
			
			symbol_316.setPrecedence(symbol_3);
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_317 = PivotFactory.eINSTANCE.createOperation();
			symbol_317.setName("-");
			//symbol_317.setMoniker("Integer!-(Integer)");
			symbol_317.setType(symbol_47);  // Integer
			symbol_317.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("i");
			//symbol_318.setMoniker("Integer!-(Integer)!i");
			symbol_318.setType(symbol_47);  // Integer
			symbol_318.setLower(BigInteger.valueOf(0));
			
			symbol_317.getOwnedParameters().add(symbol_318);
			symbol_317.setPrecedence(symbol_5);
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_317);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_319 = PivotFactory.eINSTANCE.createOperation();
			symbol_319.setName("/");
			//symbol_319.setMoniker("Integer!/(Integer)");
			symbol_319.setType(symbol_82);  // Real
			symbol_319.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_320 = PivotFactory.eINSTANCE.createParameter();
			symbol_320.setName("i");
			//symbol_320.setMoniker("Integer!/(Integer)!i");
			symbol_320.setType(symbol_47);  // Integer
			symbol_320.setLower(BigInteger.valueOf(0));
			
			symbol_319.getOwnedParameters().add(symbol_320);
			symbol_319.setPrecedence(symbol_4);
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_319);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_321 = PivotFactory.eINSTANCE.createOperation();
			symbol_321.setName("abs");
			//symbol_321.setMoniker("Integer!abs()");
			symbol_321.setType(symbol_47);  // Integer
			symbol_321.setLower(BigInteger.valueOf(0));
			
			symbol_321.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_321);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_322 = PivotFactory.eINSTANCE.createOperation();
			symbol_322.setName("div");
			//symbol_322.setMoniker("Integer!div(Integer)");
			symbol_322.setType(symbol_47);  // Integer
			symbol_322.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_323 = PivotFactory.eINSTANCE.createParameter();
			symbol_323.setName("i");
			//symbol_323.setMoniker("Integer!div(Integer)!i");
			symbol_323.setType(symbol_47);  // Integer
			symbol_323.setLower(BigInteger.valueOf(0));
			
			symbol_322.getOwnedParameters().add(symbol_323);
			symbol_322.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_322);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_324 = PivotFactory.eINSTANCE.createOperation();
			symbol_324.setName("max");
			//symbol_324.setMoniker("Integer!max(Integer)");
			symbol_324.setType(symbol_47);  // Integer
			symbol_324.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_325 = PivotFactory.eINSTANCE.createParameter();
			symbol_325.setName("i");
			//symbol_325.setMoniker("Integer!max(Integer)!i");
			symbol_325.setType(symbol_47);  // Integer
			symbol_325.setLower(BigInteger.valueOf(0));
			
			symbol_324.getOwnedParameters().add(symbol_325);
			symbol_324.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_324);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_326 = PivotFactory.eINSTANCE.createOperation();
			symbol_326.setName("min");
			//symbol_326.setMoniker("Integer!min(Integer)");
			symbol_326.setType(symbol_47);  // Integer
			symbol_326.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("i");
			//symbol_327.setMoniker("Integer!min(Integer)!i");
			symbol_327.setType(symbol_47);  // Integer
			symbol_327.setLower(BigInteger.valueOf(0));
			
			symbol_326.getOwnedParameters().add(symbol_327);
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_328.setName("mod");
			//symbol_328.setMoniker("Integer!mod(Integer)");
			symbol_328.setType(symbol_47);  // Integer
			symbol_328.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_329 = PivotFactory.eINSTANCE.createParameter();
			symbol_329.setName("i");
			//symbol_329.setMoniker("Integer!mod(Integer)!i");
			symbol_329.setType(symbol_47);  // Integer
			symbol_329.setLower(BigInteger.valueOf(0));
			
			symbol_328.getOwnedParameters().add(symbol_329);
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_328);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_330 = PivotFactory.eINSTANCE.createOperation();
			symbol_330.setName("toString");
			//symbol_330.setMoniker("Integer!toString()");
			symbol_330.setType(symbol_100);  // String
			symbol_330.setLower(BigInteger.valueOf(0));
			
			symbol_330.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_47.getOwnedOperations().add(symbol_330);
		}
		symbol_1.getOwnedTypes().add(symbol_47);
		//
		// ocl::NonOrderedCollection ocl!NonOrderedCollection{T}
		//
		symbol_48.setName("NonOrderedCollection");
		//symbol_48.setMoniker("ocl!NonOrderedCollection{T}");
		symbol_48.setElementType(symbol_51);
		symbol_51.setName("T");
		symbol_50.setOwnedParameteredElement(symbol_51);
		symbol_49.getOwnedParameters().add(symbol_50);
		
		symbol_48.setOwnedTemplateSignature(symbol_49);
		symbol_48.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T)
			Iteration symbol_331 = PivotFactory.eINSTANCE.createIteration();
			symbol_331.setName("closure");
			//symbol_331.setMoniker("ocl!NonOrderedCollection{T}!closure(T)");
			symbol_331.setType(symbol_193);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_332 = PivotFactory.eINSTANCE.createParameter();
			symbol_332.setName("i");
			symbol_332.setType(symbol_51);  // ocl!NonOrderedCollection{T}?T
			symbol_331.getOwnedIterators().add(symbol_332);
			symbol_331.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_331);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_333 = PivotFactory.eINSTANCE.createIteration();
			symbol_54.setName("V");
			symbol_53.setOwnedParameteredElement(symbol_54);
			symbol_52.getOwnedParameters().add(symbol_53);
			
			symbol_333.setOwnedTemplateSignature(symbol_52);
			symbol_333.setName("collect");
			//symbol_333.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_333.setType(symbol_109);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_334 = PivotFactory.eINSTANCE.createParameter();
			symbol_334.setName("i");
			symbol_334.setType(symbol_51);  // ocl!NonOrderedCollection{T}?T
			symbol_333.getOwnedIterators().add(symbol_334);
			Parameter symbol_335 = PivotFactory.eINSTANCE.createParameter();
			symbol_335.setName("body");
			//symbol_335.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_335.setType(symbol_141);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_333.getOwnedParameters().add(symbol_335);
			symbol_333.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_333);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested(T)
			Iteration symbol_336 = PivotFactory.eINSTANCE.createIteration();
			symbol_336.setName("collectNested");
			//symbol_336.setMoniker("ocl!NonOrderedCollection{T}!collectNested(T)");
			symbol_336.setType(symbol_107);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_337 = PivotFactory.eINSTANCE.createParameter();
			symbol_337.setName("i");
			symbol_337.setType(symbol_51);  // ocl!NonOrderedCollection{T}?T
			symbol_336.getOwnedIterators().add(symbol_337);
			symbol_336.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_336);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_338 = PivotFactory.eINSTANCE.createOperation();
			symbol_338.setName("intersection");
			//symbol_338.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_338.setType(symbol_107);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_338.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_339 = PivotFactory.eINSTANCE.createParameter();
			symbol_339.setName("bag");
			//symbol_339.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_339.setType(symbol_107);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_339.setLower(BigInteger.valueOf(0));
			
			symbol_338.getOwnedParameters().add(symbol_339);
			symbol_338.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_338);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("intersection");
			//symbol_340.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_340.setType(symbol_193);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_340.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_341 = PivotFactory.eINSTANCE.createParameter();
			symbol_341.setName("s");
			//symbol_341.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_341.setType(symbol_193);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_341.setLower(BigInteger.valueOf(0));
			
			symbol_340.getOwnedParameters().add(symbol_341);
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_340);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_342 = PivotFactory.eINSTANCE.createOperation();
			symbol_342.setName("union");
			//symbol_342.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_342.setType(symbol_107);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_342.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_343 = PivotFactory.eINSTANCE.createParameter();
			symbol_343.setName("bag");
			//symbol_343.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_343.setType(symbol_107);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_343.setLower(BigInteger.valueOf(0));
			
			symbol_342.getOwnedParameters().add(symbol_343);
			symbol_342.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_342);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_344 = PivotFactory.eINSTANCE.createOperation();
			symbol_344.setName("union");
			//symbol_344.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_344.setType(symbol_193);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_344.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_345 = PivotFactory.eINSTANCE.createParameter();
			symbol_345.setName("s");
			//symbol_345.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_345.setType(symbol_193);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_345.setLower(BigInteger.valueOf(0));
			
			symbol_344.getOwnedParameters().add(symbol_345);
			symbol_344.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_48.getOwnedOperations().add(symbol_344);
		}
		symbol_1.getOwnedTypes().add(symbol_48);
		//
		// ocl::NonUniqueCollection ocl!NonUniqueCollection{T}
		//
		symbol_55.setName("NonUniqueCollection");
		//symbol_55.setMoniker("ocl!NonUniqueCollection{T}");
		symbol_55.setElementType(symbol_58);
		symbol_58.setName("T");
		symbol_57.setOwnedParameteredElement(symbol_58);
		symbol_56.getOwnedParameters().add(symbol_57);
		
		symbol_55.setOwnedTemplateSignature(symbol_56);
		symbol_55.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T)
			Iteration symbol_346 = PivotFactory.eINSTANCE.createIteration();
			symbol_346.setName("sortedBy");
			//symbol_346.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T)");
			symbol_346.setType(symbol_186);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_347 = PivotFactory.eINSTANCE.createParameter();
			symbol_347.setName("i");
			symbol_347.setType(symbol_58);  // ocl!NonUniqueCollection{T}?T
			symbol_346.getOwnedIterators().add(symbol_347);
			symbol_346.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_55.getOwnedOperations().add(symbol_346);
		}
		symbol_1.getOwnedTypes().add(symbol_55);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_59.setName("OclAny");
		//symbol_59.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_348 = PivotFactory.eINSTANCE.createOperation();
			symbol_348.setName("<>");
			//symbol_348.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_348.setType(symbol_19);  // Boolean
			symbol_348.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_349 = PivotFactory.eINSTANCE.createParameter();
			symbol_349.setName("object2");
			//symbol_349.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_349.setType(symbol_59);  // ocl!OclAny
			symbol_349.setLower(BigInteger.valueOf(0));
			
			symbol_348.getOwnedParameters().add(symbol_349);
			symbol_348.setPrecedence(symbol_7);
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_348);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_350 = PivotFactory.eINSTANCE.createOperation();
			symbol_350.setName("=");
			//symbol_350.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_350.setType(symbol_19);  // Boolean
			symbol_350.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_351 = PivotFactory.eINSTANCE.createParameter();
			symbol_351.setName("object2");
			//symbol_351.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_351.setType(symbol_59);  // ocl!OclAny
			symbol_351.setLower(BigInteger.valueOf(0));
			
			symbol_350.getOwnedParameters().add(symbol_351);
			symbol_350.setPrecedence(symbol_7);
			symbol_350.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_350);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_352 = PivotFactory.eINSTANCE.createOperation();
			symbol_62.setName("OclSelf");
			symbol_61.setOwnedParameteredElement(symbol_62);
			symbol_60.getOwnedParameters().add(symbol_61);
			
			symbol_352.setOwnedTemplateSignature(symbol_60);
			symbol_352.setName("oclAsSet");
			//symbol_352.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_352.setType(symbol_202);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			symbol_352.setLower(BigInteger.valueOf(0));
			
			symbol_352.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_352);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{T}(ocl!Classifier)
			Operation symbol_353 = PivotFactory.eINSTANCE.createOperation();
			symbol_65.setName("T");
			symbol_64.setOwnedParameteredElement(symbol_65);
			symbol_63.getOwnedParameters().add(symbol_64);
			
			symbol_353.setOwnedTemplateSignature(symbol_63);
			symbol_353.setName("oclAsType");
			//symbol_353.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)");
			symbol_353.setType(symbol_65);  // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
			symbol_353.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_354 = PivotFactory.eINSTANCE.createParameter();
			symbol_354.setName("type");
			//symbol_354.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)!type");
			symbol_354.setType(symbol_20);  // ocl!Classifier
			symbol_354.setLower(BigInteger.valueOf(0));
			
			symbol_353.getOwnedParameters().add(symbol_354);
			symbol_353.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_353);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_355 = PivotFactory.eINSTANCE.createOperation();
			symbol_355.setName("oclIsInState");
			//symbol_355.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_355.setType(symbol_19);  // Boolean
			symbol_355.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_356 = PivotFactory.eINSTANCE.createParameter();
			symbol_356.setName("statespec");
			//symbol_356.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_356.setType(symbol_68);  // ocl!OclState
			symbol_356.setLower(BigInteger.valueOf(0));
			
			symbol_355.getOwnedParameters().add(symbol_356);
			symbol_355.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_355);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_357 = PivotFactory.eINSTANCE.createOperation();
			symbol_357.setName("oclIsInvalid");
			//symbol_357.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_357.setType(symbol_19);  // Boolean
			symbol_357.setLower(BigInteger.valueOf(0));
			
			symbol_357.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_357);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf(ocl!Classifier)
			Operation symbol_358 = PivotFactory.eINSTANCE.createOperation();
			symbol_358.setName("oclIsKindOf");
			//symbol_358.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)");
			symbol_358.setType(symbol_19);  // Boolean
			symbol_358.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_359 = PivotFactory.eINSTANCE.createParameter();
			symbol_359.setName("type");
			//symbol_359.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)!type");
			symbol_359.setType(symbol_20);  // ocl!Classifier
			symbol_359.setLower(BigInteger.valueOf(0));
			
			symbol_358.getOwnedParameters().add(symbol_359);
			symbol_358.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_358);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_360 = PivotFactory.eINSTANCE.createOperation();
			symbol_360.setName("oclIsNew");
			//symbol_360.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_360.setType(symbol_19);  // Boolean
			symbol_360.setLower(BigInteger.valueOf(0));
			
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf(ocl!Classifier)
			Operation symbol_361 = PivotFactory.eINSTANCE.createOperation();
			symbol_361.setName("oclIsTypeOf");
			//symbol_361.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)");
			symbol_361.setType(symbol_19);  // Boolean
			symbol_361.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_362 = PivotFactory.eINSTANCE.createParameter();
			symbol_362.setName("type");
			//symbol_362.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)!type");
			symbol_362.setType(symbol_20);  // ocl!Classifier
			symbol_362.setLower(BigInteger.valueOf(0));
			
			symbol_361.getOwnedParameters().add(symbol_362);
			symbol_361.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_361);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_363 = PivotFactory.eINSTANCE.createOperation();
			symbol_363.setName("oclIsUndefined");
			//symbol_363.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_363.setType(symbol_19);  // Boolean
			symbol_363.setLower(BigInteger.valueOf(0));
			
			symbol_363.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_363);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType()
			Operation symbol_364 = PivotFactory.eINSTANCE.createOperation();
			symbol_364.setName("oclType");
			//symbol_364.setMoniker("ocl!OclAny!oclType()");
			symbol_364.setType(symbol_20);  // ocl!Classifier
			symbol_364.setLower(BigInteger.valueOf(0));
			
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_59.getOwnedOperations().add(symbol_364);
		}
		symbol_1.getOwnedTypes().add(symbol_59);
		//
		// ocl::OclInvalid ocl!OclInvalid
		//
		symbol_66.setName("OclInvalid");
		//symbol_66.setMoniker("ocl!OclInvalid");
		symbol_66.getSuperClasses().add(symbol_70); // ocl!OclVoid
		{	// ocl::OclInvalid::<>() ocl!OclInvalid!<>(ocl!OclAny)
			Operation symbol_365 = PivotFactory.eINSTANCE.createOperation();
			symbol_365.setName("<>");
			//symbol_365.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_365.setType(symbol_19);  // Boolean
			symbol_365.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_366 = PivotFactory.eINSTANCE.createParameter();
			symbol_366.setName("object2");
			//symbol_366.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_366.setType(symbol_59);  // ocl!OclAny
			symbol_366.setLower(BigInteger.valueOf(0));
			
			symbol_365.getOwnedParameters().add(symbol_366);
			symbol_365.setPrecedence(symbol_7);
			symbol_365.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_365);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_367 = PivotFactory.eINSTANCE.createOperation();
			symbol_367.setName("=");
			//symbol_367.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_367.setType(symbol_19);  // Boolean
			symbol_367.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_368 = PivotFactory.eINSTANCE.createParameter();
			symbol_368.setName("object2");
			//symbol_368.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_368.setType(symbol_59);  // ocl!OclAny
			symbol_368.setLower(BigInteger.valueOf(0));
			
			symbol_367.getOwnedParameters().add(symbol_368);
			symbol_367.setPrecedence(symbol_7);
			symbol_367.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_367);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances()
			Operation symbol_369 = PivotFactory.eINSTANCE.createOperation();
			symbol_369.setName("allInstances");
			//symbol_369.setMoniker("ocl!OclInvalid!allInstances()");
			symbol_369.setType(symbol_198);  // ocl!Set[ocl!OclInvalid]
			symbol_369.setLower(BigInteger.valueOf(0));
			
			symbol_369.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_369);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_370.setName("toString");
			//symbol_370.setMoniker("ocl!OclInvalid!toString()");
			symbol_370.setType(symbol_100);  // String
			symbol_370.setLower(BigInteger.valueOf(0));
			
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_66.getOwnedOperations().add(symbol_370);
		}
		symbol_1.getOwnedTypes().add(symbol_66);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_67.setName("OclMessage");
		//symbol_67.setMoniker("ocl!OclMessage");
		symbol_67.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_371.setName("hasReturned");
			//symbol_371.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_371.setType(symbol_19);  // Boolean
			symbol_371.setLower(BigInteger.valueOf(0));
			
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_372 = PivotFactory.eINSTANCE.createOperation();
			symbol_372.setName("isOperationCall");
			//symbol_372.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_372.setType(symbol_19);  // Boolean
			symbol_372.setLower(BigInteger.valueOf(0));
			
			symbol_372.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_372);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_373 = PivotFactory.eINSTANCE.createOperation();
			symbol_373.setName("isSignalSent");
			//symbol_373.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_373.setType(symbol_19);  // Boolean
			symbol_373.setLower(BigInteger.valueOf(0));
			
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_373);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_374 = PivotFactory.eINSTANCE.createOperation();
			symbol_374.setName("result");
			//symbol_374.setMoniker("ocl!OclMessage!result()");
			symbol_374.setType(symbol_59);  // ocl!OclAny
			symbol_374.setLower(BigInteger.valueOf(0));
			
			symbol_374.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_67.getOwnedOperations().add(symbol_374);
		}
		symbol_1.getOwnedTypes().add(symbol_67);
		//
		// ocl::OclState ocl!OclState
		//
		symbol_68.setName("OclState");
		//symbol_68.setMoniker("ocl!OclState");
		symbol_68.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_68);
		//
		// ocl::OclTuple ocl!OclTuple
		//
		symbol_69.setName("OclTuple");
		//symbol_69.setMoniker("ocl!OclTuple");
		symbol_69.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::OclTuple::<>() ocl!OclTuple!<>(ocl!OclAny)
			Operation symbol_375 = PivotFactory.eINSTANCE.createOperation();
			symbol_375.setName("<>");
			//symbol_375.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_375.setType(symbol_19);  // Boolean
			symbol_375.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_376 = PivotFactory.eINSTANCE.createParameter();
			symbol_376.setName("object2");
			//symbol_376.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_376.setType(symbol_59);  // ocl!OclAny
			symbol_376.setLower(BigInteger.valueOf(0));
			
			symbol_375.getOwnedParameters().add(symbol_376);
			symbol_375.setPrecedence(symbol_7);
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_375);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_377 = PivotFactory.eINSTANCE.createOperation();
			symbol_377.setName("=");
			//symbol_377.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_377.setType(symbol_19);  // Boolean
			symbol_377.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_378 = PivotFactory.eINSTANCE.createParameter();
			symbol_378.setName("object2");
			//symbol_378.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_378.setType(symbol_59);  // ocl!OclAny
			symbol_378.setLower(BigInteger.valueOf(0));
			
			symbol_377.getOwnedParameters().add(symbol_378);
			symbol_377.setPrecedence(symbol_7);
			symbol_377.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_69.getOwnedOperations().add(symbol_377);
		}
		symbol_1.getOwnedTypes().add(symbol_69);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_70.setName("OclVoid");
		//symbol_70.setMoniker("ocl!OclVoid");
		symbol_70.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("<>");
			//symbol_379.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_379.setType(symbol_19);  // Boolean
			symbol_379.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("object2");
			//symbol_380.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_380.setType(symbol_59);  // ocl!OclAny
			symbol_380.setLower(BigInteger.valueOf(0));
			
			symbol_379.getOwnedParameters().add(symbol_380);
			symbol_379.setPrecedence(symbol_7);
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_381 = PivotFactory.eINSTANCE.createOperation();
			symbol_381.setName("=");
			//symbol_381.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_381.setType(symbol_19);  // Boolean
			symbol_381.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_382 = PivotFactory.eINSTANCE.createParameter();
			symbol_382.setName("object2");
			//symbol_382.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_382.setType(symbol_59);  // ocl!OclAny
			symbol_382.setLower(BigInteger.valueOf(0));
			
			symbol_381.getOwnedParameters().add(symbol_382);
			symbol_381.setPrecedence(symbol_7);
			symbol_381.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_381);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances()
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_383.setName("allInstances");
			//symbol_383.setMoniker("ocl!OclVoid!allInstances()");
			symbol_383.setType(symbol_200);  // ocl!Set[ocl!OclVoid]
			symbol_383.setLower(BigInteger.valueOf(0));
			
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_383);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_384 = PivotFactory.eINSTANCE.createOperation();
			symbol_384.setName("and");
			//symbol_384.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_384.setType(symbol_19);  // Boolean
			symbol_384.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_385 = PivotFactory.eINSTANCE.createParameter();
			symbol_385.setName("b");
			//symbol_385.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_385.setType(symbol_19);  // Boolean
			symbol_385.setLower(BigInteger.valueOf(0));
			
			symbol_384.getOwnedParameters().add(symbol_385);
			symbol_384.setPrecedence(symbol_8);
			symbol_384.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_384);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_386 = PivotFactory.eINSTANCE.createOperation();
			symbol_386.setName("implies");
			//symbol_386.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_386.setType(symbol_19);  // Boolean
			symbol_386.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_387 = PivotFactory.eINSTANCE.createParameter();
			symbol_387.setName("b");
			//symbol_387.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_387.setType(symbol_19);  // Boolean
			symbol_387.setLower(BigInteger.valueOf(0));
			
			symbol_386.getOwnedParameters().add(symbol_387);
			symbol_386.setPrecedence(symbol_11);
			symbol_386.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_386);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_388 = PivotFactory.eINSTANCE.createOperation();
			symbol_388.setName("or");
			//symbol_388.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_388.setType(symbol_19);  // Boolean
			symbol_388.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_389 = PivotFactory.eINSTANCE.createParameter();
			symbol_389.setName("b");
			//symbol_389.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_389.setType(symbol_19);  // Boolean
			symbol_389.setLower(BigInteger.valueOf(0));
			
			symbol_388.getOwnedParameters().add(symbol_389);
			symbol_388.setPrecedence(symbol_9);
			symbol_388.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_388);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_390 = PivotFactory.eINSTANCE.createOperation();
			symbol_390.setName("toString");
			//symbol_390.setMoniker("ocl!OclVoid!toString()");
			symbol_390.setType(symbol_100);  // String
			symbol_390.setLower(BigInteger.valueOf(0));
			
			symbol_390.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_70.getOwnedOperations().add(symbol_390);
		}
		symbol_1.getOwnedTypes().add(symbol_70);
		//
		// ocl::OrderedCollection ocl!OrderedCollection{T}
		//
		symbol_71.setName("OrderedCollection");
		//symbol_71.setMoniker("ocl!OrderedCollection{T}");
		symbol_71.setElementType(symbol_74);
		symbol_74.setName("T");
		symbol_73.setOwnedParameteredElement(symbol_74);
		symbol_72.getOwnedParameters().add(symbol_73);
		
		symbol_71.setOwnedTemplateSignature(symbol_72);
		symbol_71.getSuperClasses().add(symbol_118); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_391 = PivotFactory.eINSTANCE.createOperation();
			symbol_391.setName("at");
			//symbol_391.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_391.setType(symbol_74);  // ocl!OrderedCollection{T}?T
			symbol_391.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_392 = PivotFactory.eINSTANCE.createParameter();
			symbol_392.setName("index");
			//symbol_392.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_392.setType(symbol_47);  // Integer
			symbol_392.setLower(BigInteger.valueOf(0));
			
			symbol_391.getOwnedParameters().add(symbol_392);
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T)
			Iteration symbol_393 = PivotFactory.eINSTANCE.createIteration();
			symbol_393.setName("closure");
			//symbol_393.setMoniker("ocl!OrderedCollection{T}!closure(T)");
			symbol_393.setType(symbol_182);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("i");
			symbol_394.setType(symbol_74);  // ocl!OrderedCollection{T}?T
			symbol_393.getOwnedIterators().add(symbol_394);
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_393);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_395 = PivotFactory.eINSTANCE.createIteration();
			symbol_77.setName("V");
			symbol_76.setOwnedParameteredElement(symbol_77);
			symbol_75.getOwnedParameters().add(symbol_76);
			
			symbol_395.setOwnedTemplateSignature(symbol_75);
			symbol_395.setName("collect");
			//symbol_395.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_395.setType(symbol_184);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_396 = PivotFactory.eINSTANCE.createParameter();
			symbol_396.setName("i");
			symbol_396.setType(symbol_74);  // ocl!OrderedCollection{T}?T
			symbol_395.getOwnedIterators().add(symbol_396);
			Parameter symbol_397 = PivotFactory.eINSTANCE.createParameter();
			symbol_397.setName("body");
			//symbol_397.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_397.setType(symbol_142);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_395.getOwnedParameters().add(symbol_397);
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_395);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested(T)
			Iteration symbol_398 = PivotFactory.eINSTANCE.createIteration();
			symbol_398.setName("collectNested");
			//symbol_398.setMoniker("ocl!OrderedCollection{T}!collectNested(T)");
			symbol_398.setType(symbol_189);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_399 = PivotFactory.eINSTANCE.createParameter();
			symbol_399.setName("i");
			symbol_399.setType(symbol_74);  // ocl!OrderedCollection{T}?T
			symbol_398.getOwnedIterators().add(symbol_399);
			symbol_398.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_398);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_400 = PivotFactory.eINSTANCE.createOperation();
			symbol_400.setName("first");
			//symbol_400.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_400.setType(symbol_74);  // ocl!OrderedCollection{T}?T
			symbol_400.setLower(BigInteger.valueOf(0));
			
			symbol_400.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_400);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_401.setName("indexOf");
			//symbol_401.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_401.setType(symbol_47);  // Integer
			symbol_401.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_402 = PivotFactory.eINSTANCE.createParameter();
			symbol_402.setName("obj");
			//symbol_402.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_402.setType(symbol_59);  // ocl!OclAny
			symbol_402.setLower(BigInteger.valueOf(0));
			
			symbol_401.getOwnedParameters().add(symbol_402);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_403 = PivotFactory.eINSTANCE.createOperation();
			symbol_403.setName("last");
			//symbol_403.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_403.setType(symbol_74);  // ocl!OrderedCollection{T}?T
			symbol_403.setLower(BigInteger.valueOf(0));
			
			symbol_403.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_403);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_404 = PivotFactory.eINSTANCE.createOperation();
			symbol_404.setName("reverse");
			//symbol_404.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_404.setType(symbol_171);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			symbol_404.setLower(BigInteger.valueOf(0));
			
			symbol_404.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_71.getOwnedOperations().add(symbol_404);
		}
		symbol_1.getOwnedTypes().add(symbol_71);
		//
		// ocl::OrderedSet ocl!OrderedSet{T}
		//
		symbol_78.setName("OrderedSet");
		//symbol_78.setMoniker("ocl!OrderedSet{T}");
		symbol_78.setElementType(symbol_81);
		symbol_81.setName("T");
		symbol_80.setOwnedParameteredElement(symbol_81);
		symbol_79.getOwnedParameters().add(symbol_80);
		
		symbol_78.setOwnedTemplateSignature(symbol_79);
		symbol_78.getSuperClasses().add(symbol_215); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_78.getSuperClasses().add(symbol_175); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_405 = PivotFactory.eINSTANCE.createOperation();
			symbol_405.setName("-");
			//symbol_405.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_405.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_405.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_406 = PivotFactory.eINSTANCE.createParameter();
			symbol_406.setName("s");
			//symbol_406.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_406.setType(symbol_197);  // ocl!Set[ocl!OclAny]
			symbol_406.setLower(BigInteger.valueOf(0));
			
			symbol_405.getOwnedParameters().add(symbol_406);
			symbol_405.setPrecedence(symbol_5);
			symbol_405.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_405);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_407 = PivotFactory.eINSTANCE.createOperation();
			symbol_407.setName("<>");
			//symbol_407.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_407.setType(symbol_19);  // Boolean
			symbol_407.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_408 = PivotFactory.eINSTANCE.createParameter();
			symbol_408.setName("object2");
			//symbol_408.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_408.setType(symbol_59);  // ocl!OclAny
			symbol_408.setLower(BigInteger.valueOf(0));
			
			symbol_407.getOwnedParameters().add(symbol_408);
			symbol_407.setPrecedence(symbol_7);
			symbol_407.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_407);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_409.setName("=");
			//symbol_409.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_409.setType(symbol_19);  // Boolean
			symbol_409.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("object2");
			//symbol_410.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_410.setType(symbol_59);  // ocl!OclAny
			symbol_410.setLower(BigInteger.valueOf(0));
			
			symbol_409.getOwnedParameters().add(symbol_410);
			symbol_409.setPrecedence(symbol_7);
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_411 = PivotFactory.eINSTANCE.createOperation();
			symbol_411.setName("append");
			//symbol_411.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_411.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_411.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("object");
			//symbol_412.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_412.setType(symbol_81);  // ocl!OrderedSet{T}?T
			symbol_412.setLower(BigInteger.valueOf(0));
			
			symbol_411.getOwnedParameters().add(symbol_412);
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_413 = PivotFactory.eINSTANCE.createOperation();
			symbol_413.setName("excluding");
			//symbol_413.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_413.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_413.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("object");
			//symbol_414.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_414.setType(symbol_59);  // ocl!OclAny
			symbol_414.setLower(BigInteger.valueOf(0));
			
			symbol_413.getOwnedParameters().add(symbol_414);
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_415 = PivotFactory.eINSTANCE.createOperation();
			symbol_415.setName("including");
			//symbol_415.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_415.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_415.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_416 = PivotFactory.eINSTANCE.createParameter();
			symbol_416.setName("object");
			//symbol_416.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_416.setType(symbol_81);  // ocl!OrderedSet{T}?T
			symbol_416.setLower(BigInteger.valueOf(0));
			
			symbol_415.getOwnedParameters().add(symbol_416);
			symbol_415.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_415);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_417 = PivotFactory.eINSTANCE.createOperation();
			symbol_417.setName("insertAt");
			//symbol_417.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_417.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_417.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_418 = PivotFactory.eINSTANCE.createParameter();
			symbol_418.setName("index");
			//symbol_418.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_418.setType(symbol_47);  // Integer
			symbol_418.setLower(BigInteger.valueOf(0));
			
			symbol_417.getOwnedParameters().add(symbol_418);
			Parameter symbol_419 = PivotFactory.eINSTANCE.createParameter();
			symbol_419.setName("object");
			//symbol_419.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_419.setType(symbol_81);  // ocl!OrderedSet{T}?T
			symbol_419.setLower(BigInteger.valueOf(0));
			
			symbol_417.getOwnedParameters().add(symbol_419);
			symbol_417.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_417);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_420 = PivotFactory.eINSTANCE.createOperation();
			symbol_420.setName("intersection");
			//symbol_420.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_420.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_420.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_421 = PivotFactory.eINSTANCE.createParameter();
			symbol_421.setName("o");
			//symbol_421.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_421.setType(symbol_199);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_421.setLower(BigInteger.valueOf(0));
			
			symbol_420.getOwnedParameters().add(symbol_421);
			symbol_420.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_420);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_422 = PivotFactory.eINSTANCE.createOperation();
			symbol_422.setName("prepend");
			//symbol_422.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_422.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_422.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_423 = PivotFactory.eINSTANCE.createParameter();
			symbol_423.setName("object");
			//symbol_423.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_423.setType(symbol_81);  // ocl!OrderedSet{T}?T
			symbol_423.setLower(BigInteger.valueOf(0));
			
			symbol_422.getOwnedParameters().add(symbol_423);
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_422);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T)
			Iteration symbol_424 = PivotFactory.eINSTANCE.createIteration();
			symbol_424.setName("reject");
			//symbol_424.setMoniker("ocl!OrderedSet{T}!reject(T)");
			symbol_424.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_425 = PivotFactory.eINSTANCE.createParameter();
			symbol_425.setName("i");
			symbol_425.setType(symbol_81);  // ocl!OrderedSet{T}?T
			symbol_424.getOwnedIterators().add(symbol_425);
			symbol_424.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_424);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_426 = PivotFactory.eINSTANCE.createOperation();
			symbol_426.setName("reverse");
			//symbol_426.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_426.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_426.setLower(BigInteger.valueOf(0));
			
			symbol_426.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_426);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T)
			Iteration symbol_427 = PivotFactory.eINSTANCE.createIteration();
			symbol_427.setName("select");
			//symbol_427.setMoniker("ocl!OrderedSet{T}!select(T)");
			symbol_427.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_428 = PivotFactory.eINSTANCE.createParameter();
			symbol_428.setName("i");
			symbol_428.setType(symbol_81);  // ocl!OrderedSet{T}?T
			symbol_427.getOwnedIterators().add(symbol_428);
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_429 = PivotFactory.eINSTANCE.createOperation();
			symbol_429.setName("subOrderedSet");
			//symbol_429.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_429.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_429.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_430 = PivotFactory.eINSTANCE.createParameter();
			symbol_430.setName("lower");
			//symbol_430.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_430.setType(symbol_47);  // Integer
			symbol_430.setLower(BigInteger.valueOf(0));
			
			symbol_429.getOwnedParameters().add(symbol_430);
			Parameter symbol_431 = PivotFactory.eINSTANCE.createParameter();
			symbol_431.setName("upper");
			//symbol_431.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_431.setType(symbol_47);  // Integer
			symbol_431.setLower(BigInteger.valueOf(0));
			
			symbol_429.getOwnedParameters().add(symbol_431);
			symbol_429.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_429);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_432 = PivotFactory.eINSTANCE.createOperation();
			symbol_432.setName("symmetricDifference");
			//symbol_432.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_432.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_432.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_433 = PivotFactory.eINSTANCE.createParameter();
			symbol_433.setName("s");
			//symbol_433.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_433.setType(symbol_197);  // ocl!Set[ocl!OclAny]
			symbol_433.setLower(BigInteger.valueOf(0));
			
			symbol_432.getOwnedParameters().add(symbol_433);
			symbol_432.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_432);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_434 = PivotFactory.eINSTANCE.createOperation();
			symbol_434.setName("union");
			//symbol_434.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_434.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_434.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_435 = PivotFactory.eINSTANCE.createParameter();
			symbol_435.setName("o");
			//symbol_435.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_435.setType(symbol_180);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_435.setLower(BigInteger.valueOf(0));
			
			symbol_434.getOwnedParameters().add(symbol_435);
			symbol_434.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_434);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_436 = PivotFactory.eINSTANCE.createOperation();
			symbol_436.setName("union");
			//symbol_436.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_436.setType(symbol_199);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_436.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("s");
			//symbol_437.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_437.setType(symbol_199);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_437.setLower(BigInteger.valueOf(0));
			
			symbol_436.getOwnedParameters().add(symbol_437);
			symbol_436.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_436);
		}
		symbol_1.getOwnedTypes().add(symbol_78);
		//
		// ocl::Real Real
		//
		symbol_82.setName("Real");
		//symbol_82.setMoniker("Real");
		symbol_82.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("*");
			//symbol_438.setMoniker("Real!*(Real)");
			symbol_438.setType(symbol_82);  // Real
			symbol_438.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_439 = PivotFactory.eINSTANCE.createParameter();
			symbol_439.setName("r");
			//symbol_439.setMoniker("Real!*(Real)!r");
			symbol_439.setType(symbol_82);  // Real
			symbol_439.setLower(BigInteger.valueOf(0));
			
			symbol_438.getOwnedParameters().add(symbol_439);
			symbol_438.setPrecedence(symbol_4);
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("+");
			//symbol_440.setMoniker("Real!+(Real)");
			symbol_440.setType(symbol_82);  // Real
			symbol_440.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("r");
			//symbol_441.setMoniker("Real!+(Real)!r");
			symbol_441.setType(symbol_82);  // Real
			symbol_441.setLower(BigInteger.valueOf(0));
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setPrecedence(symbol_5);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_442 = PivotFactory.eINSTANCE.createOperation();
			symbol_442.setName("-");
			//symbol_442.setMoniker("Real!-(Real)");
			symbol_442.setType(symbol_82);  // Real
			symbol_442.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("r");
			//symbol_443.setMoniker("Real!-(Real)!r");
			symbol_443.setType(symbol_82);  // Real
			symbol_443.setLower(BigInteger.valueOf(0));
			
			symbol_442.getOwnedParameters().add(symbol_443);
			symbol_442.setPrecedence(symbol_5);
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_444 = PivotFactory.eINSTANCE.createOperation();
			symbol_444.setName("-");
			//symbol_444.setMoniker("Real!-()");
			symbol_444.setType(symbol_82);  // Real
			symbol_444.setLower(BigInteger.valueOf(0));
			
			symbol_444.setPrecedence(symbol_3);
			symbol_444.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_444);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_445 = PivotFactory.eINSTANCE.createOperation();
			symbol_445.setName("/");
			//symbol_445.setMoniker("Real!/(Real)");
			symbol_445.setType(symbol_82);  // Real
			symbol_445.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_446 = PivotFactory.eINSTANCE.createParameter();
			symbol_446.setName("r");
			//symbol_446.setMoniker("Real!/(Real)!r");
			symbol_446.setType(symbol_82);  // Real
			symbol_446.setLower(BigInteger.valueOf(0));
			
			symbol_445.getOwnedParameters().add(symbol_446);
			symbol_445.setPrecedence(symbol_4);
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("<");
			//symbol_447.setMoniker("Real!<(Real)");
			symbol_447.setType(symbol_19);  // Boolean
			symbol_447.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("r");
			//symbol_448.setMoniker("Real!<(Real)!r");
			symbol_448.setType(symbol_82);  // Real
			symbol_448.setLower(BigInteger.valueOf(0));
			
			symbol_447.getOwnedParameters().add(symbol_448);
			symbol_447.setPrecedence(symbol_6);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_449 = PivotFactory.eINSTANCE.createOperation();
			symbol_449.setName("<=");
			//symbol_449.setMoniker("Real!<=(Real)");
			symbol_449.setType(symbol_19);  // Boolean
			symbol_449.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_450 = PivotFactory.eINSTANCE.createParameter();
			symbol_450.setName("r");
			//symbol_450.setMoniker("Real!<=(Real)!r");
			symbol_450.setType(symbol_82);  // Real
			symbol_450.setLower(BigInteger.valueOf(0));
			
			symbol_449.getOwnedParameters().add(symbol_450);
			symbol_449.setPrecedence(symbol_6);
			symbol_449.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_449);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_451 = PivotFactory.eINSTANCE.createOperation();
			symbol_451.setName("<>");
			//symbol_451.setMoniker("Real!<>(ocl!OclAny)");
			symbol_451.setType(symbol_19);  // Boolean
			symbol_451.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_452 = PivotFactory.eINSTANCE.createParameter();
			symbol_452.setName("object2");
			//symbol_452.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_452.setType(symbol_59);  // ocl!OclAny
			symbol_452.setLower(BigInteger.valueOf(0));
			
			symbol_451.getOwnedParameters().add(symbol_452);
			symbol_451.setPrecedence(symbol_7);
			symbol_451.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_451);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_453 = PivotFactory.eINSTANCE.createOperation();
			symbol_453.setName("=");
			//symbol_453.setMoniker("Real!=(ocl!OclAny)");
			symbol_453.setType(symbol_19);  // Boolean
			symbol_453.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_454 = PivotFactory.eINSTANCE.createParameter();
			symbol_454.setName("object2");
			//symbol_454.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_454.setType(symbol_59);  // ocl!OclAny
			symbol_454.setLower(BigInteger.valueOf(0));
			
			symbol_453.getOwnedParameters().add(symbol_454);
			symbol_453.setPrecedence(symbol_7);
			symbol_453.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_453);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_455 = PivotFactory.eINSTANCE.createOperation();
			symbol_455.setName(">");
			//symbol_455.setMoniker("Real!>(Real)");
			symbol_455.setType(symbol_19);  // Boolean
			symbol_455.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_456 = PivotFactory.eINSTANCE.createParameter();
			symbol_456.setName("r");
			//symbol_456.setMoniker("Real!>(Real)!r");
			symbol_456.setType(symbol_82);  // Real
			symbol_456.setLower(BigInteger.valueOf(0));
			
			symbol_455.getOwnedParameters().add(symbol_456);
			symbol_455.setPrecedence(symbol_6);
			symbol_455.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_455);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_457 = PivotFactory.eINSTANCE.createOperation();
			symbol_457.setName(">=");
			//symbol_457.setMoniker("Real!>=(Real)");
			symbol_457.setType(symbol_19);  // Boolean
			symbol_457.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_458 = PivotFactory.eINSTANCE.createParameter();
			symbol_458.setName("r");
			//symbol_458.setMoniker("Real!>=(Real)!r");
			symbol_458.setType(symbol_82);  // Real
			symbol_458.setLower(BigInteger.valueOf(0));
			
			symbol_457.getOwnedParameters().add(symbol_458);
			symbol_457.setPrecedence(symbol_6);
			symbol_457.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_457);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_459 = PivotFactory.eINSTANCE.createOperation();
			symbol_459.setName("abs");
			//symbol_459.setMoniker("Real!abs()");
			symbol_459.setType(symbol_82);  // Real
			symbol_459.setLower(BigInteger.valueOf(0));
			
			symbol_459.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_459);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("floor");
			//symbol_460.setMoniker("Real!floor()");
			symbol_460.setType(symbol_47);  // Integer
			symbol_460.setLower(BigInteger.valueOf(0));
			
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_461 = PivotFactory.eINSTANCE.createOperation();
			symbol_461.setName("max");
			//symbol_461.setMoniker("Real!max(Real)");
			symbol_461.setType(symbol_82);  // Real
			symbol_461.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_462 = PivotFactory.eINSTANCE.createParameter();
			symbol_462.setName("r");
			//symbol_462.setMoniker("Real!max(Real)!r");
			symbol_462.setType(symbol_82);  // Real
			symbol_462.setLower(BigInteger.valueOf(0));
			
			symbol_461.getOwnedParameters().add(symbol_462);
			symbol_461.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_461);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_463 = PivotFactory.eINSTANCE.createOperation();
			symbol_463.setName("min");
			//symbol_463.setMoniker("Real!min(Real)");
			symbol_463.setType(symbol_82);  // Real
			symbol_463.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_464 = PivotFactory.eINSTANCE.createParameter();
			symbol_464.setName("r");
			//symbol_464.setMoniker("Real!min(Real)!r");
			symbol_464.setType(symbol_82);  // Real
			symbol_464.setLower(BigInteger.valueOf(0));
			
			symbol_463.getOwnedParameters().add(symbol_464);
			symbol_463.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_463);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{T}(ocl!Classifier)
			Operation symbol_465 = PivotFactory.eINSTANCE.createOperation();
			symbol_85.setName("T");
			symbol_84.setOwnedParameteredElement(symbol_85);
			symbol_83.getOwnedParameters().add(symbol_84);
			
			symbol_465.setOwnedTemplateSignature(symbol_83);
			symbol_465.setName("oclAsType");
			//symbol_465.setMoniker("Real!oclAsType{T}(ocl!Classifier)");
			symbol_465.setType(symbol_85);  // Real!oclAsType{T}(ocl!Classifier)?T
			symbol_465.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_466 = PivotFactory.eINSTANCE.createParameter();
			symbol_466.setName("type");
			//symbol_466.setMoniker("Real!oclAsType{T}(ocl!Classifier)!type");
			symbol_466.setType(symbol_20);  // ocl!Classifier
			symbol_466.setLower(BigInteger.valueOf(0));
			
			symbol_465.getOwnedParameters().add(symbol_466);
			symbol_465.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_465);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("round");
			//symbol_467.setMoniker("Real!round()");
			symbol_467.setType(symbol_47);  // Integer
			symbol_467.setLower(BigInteger.valueOf(0));
			
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_468 = PivotFactory.eINSTANCE.createOperation();
			symbol_468.setName("toString");
			//symbol_468.setMoniker("Real!toString()");
			symbol_468.setType(symbol_100);  // String
			symbol_468.setLower(BigInteger.valueOf(0));
			
			symbol_468.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_82.getOwnedOperations().add(symbol_468);
		}
		symbol_1.getOwnedTypes().add(symbol_82);
		//
		// ocl::Sequence ocl!Sequence{T}
		//
		symbol_86.setName("Sequence");
		//symbol_86.setMoniker("ocl!Sequence{T}");
		symbol_86.setElementType(symbol_89);
		symbol_89.setName("T");
		symbol_88.setOwnedParameteredElement(symbol_89);
		symbol_87.getOwnedParameters().add(symbol_88);
		
		symbol_86.setOwnedTemplateSignature(symbol_87);
		symbol_86.getSuperClasses().add(symbol_162); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_86.getSuperClasses().add(symbol_172); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("<>");
			//symbol_469.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_469.setType(symbol_19);  // Boolean
			symbol_469.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("object2");
			//symbol_470.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_470.setType(symbol_59);  // ocl!OclAny
			symbol_470.setLower(BigInteger.valueOf(0));
			
			symbol_469.getOwnedParameters().add(symbol_470);
			symbol_469.setPrecedence(symbol_7);
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("=");
			//symbol_471.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_471.setType(symbol_19);  // Boolean
			symbol_471.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_472 = PivotFactory.eINSTANCE.createParameter();
			symbol_472.setName("object2");
			//symbol_472.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_472.setType(symbol_59);  // ocl!OclAny
			symbol_472.setLower(BigInteger.valueOf(0));
			
			symbol_471.getOwnedParameters().add(symbol_472);
			symbol_471.setPrecedence(symbol_7);
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_471);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName("append");
			//symbol_473.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_473.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_473.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_474 = PivotFactory.eINSTANCE.createParameter();
			symbol_474.setName("object");
			//symbol_474.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_474.setType(symbol_89);  // ocl!Sequence{T}?T
			symbol_474.setLower(BigInteger.valueOf(0));
			
			symbol_473.getOwnedParameters().add(symbol_474);
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_473);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_475 = PivotFactory.eINSTANCE.createOperation();
			symbol_475.setName("excluding");
			//symbol_475.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_475.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_475.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_476 = PivotFactory.eINSTANCE.createParameter();
			symbol_476.setName("object");
			//symbol_476.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_476.setType(symbol_59);  // ocl!OclAny
			symbol_476.setLower(BigInteger.valueOf(0));
			
			symbol_475.getOwnedParameters().add(symbol_476);
			symbol_475.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_475);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_477 = PivotFactory.eINSTANCE.createOperation();
			symbol_92.setName("T2");
			symbol_91.setOwnedParameteredElement(symbol_92);
			symbol_90.getOwnedParameters().add(symbol_91);
			
			symbol_477.setOwnedTemplateSignature(symbol_90);
			symbol_477.setName("flatten");
			//symbol_477.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_477.setType(symbol_183);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			symbol_477.setLower(BigInteger.valueOf(0));
			
			symbol_477.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_477);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("including");
			//symbol_478.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_478.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_478.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_479 = PivotFactory.eINSTANCE.createParameter();
			symbol_479.setName("object");
			//symbol_479.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_479.setType(symbol_89);  // ocl!Sequence{T}?T
			symbol_479.setLower(BigInteger.valueOf(0));
			
			symbol_478.getOwnedParameters().add(symbol_479);
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_480 = PivotFactory.eINSTANCE.createOperation();
			symbol_480.setName("insertAt");
			//symbol_480.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_480.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_480.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_481 = PivotFactory.eINSTANCE.createParameter();
			symbol_481.setName("index");
			//symbol_481.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_481.setType(symbol_47);  // Integer
			symbol_481.setLower(BigInteger.valueOf(0));
			
			symbol_480.getOwnedParameters().add(symbol_481);
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("object");
			//symbol_482.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_482.setType(symbol_89);  // ocl!Sequence{T}?T
			symbol_482.setLower(BigInteger.valueOf(0));
			
			symbol_480.getOwnedParameters().add(symbol_482);
			symbol_480.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_480);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_483.setName("prepend");
			//symbol_483.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_483.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_483.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("object");
			//symbol_484.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_484.setType(symbol_89);  // ocl!Sequence{T}?T
			symbol_484.setLower(BigInteger.valueOf(0));
			
			symbol_483.getOwnedParameters().add(symbol_484);
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T)
			Iteration symbol_485 = PivotFactory.eINSTANCE.createIteration();
			symbol_485.setName("reject");
			//symbol_485.setMoniker("ocl!Sequence{T}!reject(T)");
			symbol_485.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_486 = PivotFactory.eINSTANCE.createParameter();
			symbol_486.setName("i");
			symbol_486.setType(symbol_89);  // ocl!Sequence{T}?T
			symbol_485.getOwnedIterators().add(symbol_486);
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_487 = PivotFactory.eINSTANCE.createOperation();
			symbol_487.setName("reverse");
			//symbol_487.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_487.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_487.setLower(BigInteger.valueOf(0));
			
			symbol_487.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_487);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T)
			Iteration symbol_488 = PivotFactory.eINSTANCE.createIteration();
			symbol_488.setName("select");
			//symbol_488.setMoniker("ocl!Sequence{T}!select(T)");
			symbol_488.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_489 = PivotFactory.eINSTANCE.createParameter();
			symbol_489.setName("i");
			symbol_489.setType(symbol_89);  // ocl!Sequence{T}?T
			symbol_488.getOwnedIterators().add(symbol_489);
			symbol_488.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_488);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_490 = PivotFactory.eINSTANCE.createOperation();
			symbol_490.setName("subSequence");
			//symbol_490.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_490.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_490.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_491 = PivotFactory.eINSTANCE.createParameter();
			symbol_491.setName("lower");
			//symbol_491.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_491.setType(symbol_47);  // Integer
			symbol_491.setLower(BigInteger.valueOf(0));
			
			symbol_490.getOwnedParameters().add(symbol_491);
			Parameter symbol_492 = PivotFactory.eINSTANCE.createParameter();
			symbol_492.setName("upper");
			//symbol_492.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_492.setType(symbol_47);  // Integer
			symbol_492.setLower(BigInteger.valueOf(0));
			
			symbol_490.getOwnedParameters().add(symbol_492);
			symbol_490.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_490);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_493 = PivotFactory.eINSTANCE.createOperation();
			symbol_493.setName("union");
			//symbol_493.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_493.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_493.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_494 = PivotFactory.eINSTANCE.createParameter();
			symbol_494.setName("s");
			//symbol_494.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_494.setType(symbol_187);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_494.setLower(BigInteger.valueOf(0));
			
			symbol_493.getOwnedParameters().add(symbol_494);
			symbol_493.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_86.getOwnedOperations().add(symbol_493);
		}
		symbol_1.getOwnedTypes().add(symbol_86);
		//
		// ocl::Set ocl!Set{T}
		//
		symbol_93.setName("Set");
		//symbol_93.setMoniker("ocl!Set{T}");
		symbol_93.setElementType(symbol_96);
		symbol_96.setName("T");
		symbol_95.setOwnedParameteredElement(symbol_96);
		symbol_94.getOwnedParameters().add(symbol_95);
		
		symbol_93.setOwnedTemplateSignature(symbol_94);
		symbol_93.getSuperClasses().add(symbol_209); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_93.getSuperClasses().add(symbol_157); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_495.setName("-");
			//symbol_495.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_495.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			symbol_495.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_496 = PivotFactory.eINSTANCE.createParameter();
			symbol_496.setName("s");
			//symbol_496.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_496.setType(symbol_197);  // ocl!Set[ocl!OclAny]
			symbol_496.setLower(BigInteger.valueOf(0));
			
			symbol_495.getOwnedParameters().add(symbol_496);
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_497 = PivotFactory.eINSTANCE.createOperation();
			symbol_497.setName("<>");
			//symbol_497.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_497.setType(symbol_19);  // Boolean
			symbol_497.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_498 = PivotFactory.eINSTANCE.createParameter();
			symbol_498.setName("object2");
			//symbol_498.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_498.setType(symbol_59);  // ocl!OclAny
			symbol_498.setLower(BigInteger.valueOf(0));
			
			symbol_497.getOwnedParameters().add(symbol_498);
			symbol_497.setPrecedence(symbol_7);
			symbol_497.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_497);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_499 = PivotFactory.eINSTANCE.createOperation();
			symbol_499.setName("=");
			//symbol_499.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_499.setType(symbol_19);  // Boolean
			symbol_499.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("object2");
			//symbol_500.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_500.setType(symbol_59);  // ocl!OclAny
			symbol_500.setLower(BigInteger.valueOf(0));
			
			symbol_499.getOwnedParameters().add(symbol_500);
			symbol_499.setPrecedence(symbol_7);
			symbol_499.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_499);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("excluding");
			//symbol_501.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_501.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			symbol_501.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("object");
			//symbol_502.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_502.setType(symbol_59);  // ocl!OclAny
			symbol_502.setLower(BigInteger.valueOf(0));
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_503 = PivotFactory.eINSTANCE.createOperation();
			symbol_99.setName("T2");
			symbol_98.setOwnedParameteredElement(symbol_99);
			symbol_97.getOwnedParameters().add(symbol_98);
			
			symbol_503.setOwnedTemplateSignature(symbol_97);
			symbol_503.setName("flatten");
			//symbol_503.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_503.setType(symbol_191);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			symbol_503.setLower(BigInteger.valueOf(0));
			
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_504 = PivotFactory.eINSTANCE.createOperation();
			symbol_504.setName("including");
			//symbol_504.setMoniker("ocl!Set{T}!including(T)");
			symbol_504.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			symbol_504.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_505 = PivotFactory.eINSTANCE.createParameter();
			symbol_505.setName("object");
			//symbol_505.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_505.setType(symbol_96);  // ocl!Set{T}?T
			symbol_505.setLower(BigInteger.valueOf(0));
			
			symbol_504.getOwnedParameters().add(symbol_505);
			symbol_504.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_504);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_506 = PivotFactory.eINSTANCE.createOperation();
			symbol_506.setName("intersection");
			//symbol_506.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_506.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			symbol_506.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_507 = PivotFactory.eINSTANCE.createParameter();
			symbol_507.setName("s");
			//symbol_507.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_507.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			symbol_507.setLower(BigInteger.valueOf(0));
			
			symbol_506.getOwnedParameters().add(symbol_507);
			symbol_506.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_506);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T)
			Iteration symbol_508 = PivotFactory.eINSTANCE.createIteration();
			symbol_508.setName("reject");
			//symbol_508.setMoniker("ocl!Set{T}!reject(T)");
			symbol_508.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_509 = PivotFactory.eINSTANCE.createParameter();
			symbol_509.setName("i");
			symbol_509.setType(symbol_96);  // ocl!Set{T}?T
			symbol_508.getOwnedIterators().add(symbol_509);
			symbol_508.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_508);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T)
			Iteration symbol_510 = PivotFactory.eINSTANCE.createIteration();
			symbol_510.setName("select");
			//symbol_510.setMoniker("ocl!Set{T}!select(T)");
			symbol_510.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_511 = PivotFactory.eINSTANCE.createParameter();
			symbol_511.setName("i");
			symbol_511.setType(symbol_96);  // ocl!Set{T}?T
			symbol_510.getOwnedIterators().add(symbol_511);
			symbol_510.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_510);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_512 = PivotFactory.eINSTANCE.createOperation();
			symbol_512.setName("symmetricDifference");
			//symbol_512.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_512.setType(symbol_196);  // ocl!Set[ocl!Set{T}?T]
			symbol_512.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_513 = PivotFactory.eINSTANCE.createParameter();
			symbol_513.setName("s");
			//symbol_513.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_513.setType(symbol_197);  // ocl!Set[ocl!OclAny]
			symbol_513.setLower(BigInteger.valueOf(0));
			
			symbol_512.getOwnedParameters().add(symbol_513);
			symbol_512.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_93.getOwnedOperations().add(symbol_512);
		}
		symbol_1.getOwnedTypes().add(symbol_93);
		//
		// ocl::String String
		//
		symbol_100.setName("String");
		//symbol_100.setMoniker("String");
		symbol_100.getSuperClasses().add(symbol_59); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_514 = PivotFactory.eINSTANCE.createOperation();
			symbol_514.setName("+");
			//symbol_514.setMoniker("String!+(String)");
			symbol_514.setType(symbol_100);  // String
			symbol_514.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_515 = PivotFactory.eINSTANCE.createParameter();
			symbol_515.setName("s");
			//symbol_515.setMoniker("String!+(String)!s");
			symbol_515.setType(symbol_100);  // String
			symbol_515.setLower(BigInteger.valueOf(0));
			
			symbol_514.getOwnedParameters().add(symbol_515);
			symbol_514.setPrecedence(symbol_5);
			symbol_514.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_514);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_516 = PivotFactory.eINSTANCE.createOperation();
			symbol_516.setName("<");
			//symbol_516.setMoniker("String!<(String)");
			symbol_516.setType(symbol_19);  // Boolean
			symbol_516.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_517 = PivotFactory.eINSTANCE.createParameter();
			symbol_517.setName("s");
			//symbol_517.setMoniker("String!<(String)!s");
			symbol_517.setType(symbol_100);  // String
			symbol_517.setLower(BigInteger.valueOf(0));
			
			symbol_516.getOwnedParameters().add(symbol_517);
			symbol_516.setPrecedence(symbol_6);
			symbol_516.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_516);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_518 = PivotFactory.eINSTANCE.createOperation();
			symbol_518.setName("<=");
			//symbol_518.setMoniker("String!<=(String)");
			symbol_518.setType(symbol_19);  // Boolean
			symbol_518.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_519 = PivotFactory.eINSTANCE.createParameter();
			symbol_519.setName("s");
			//symbol_519.setMoniker("String!<=(String)!s");
			symbol_519.setType(symbol_100);  // String
			symbol_519.setLower(BigInteger.valueOf(0));
			
			symbol_518.getOwnedParameters().add(symbol_519);
			symbol_518.setPrecedence(symbol_6);
			symbol_518.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_518);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_520 = PivotFactory.eINSTANCE.createOperation();
			symbol_520.setName("<>");
			//symbol_520.setMoniker("String!<>(ocl!OclAny)");
			symbol_520.setType(symbol_19);  // Boolean
			symbol_520.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_521 = PivotFactory.eINSTANCE.createParameter();
			symbol_521.setName("object2");
			//symbol_521.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_521.setType(symbol_59);  // ocl!OclAny
			symbol_521.setLower(BigInteger.valueOf(0));
			
			symbol_520.getOwnedParameters().add(symbol_521);
			symbol_520.setPrecedence(symbol_7);
			symbol_520.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_520);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("=");
			//symbol_522.setMoniker("String!=(ocl!OclAny)");
			symbol_522.setType(symbol_19);  // Boolean
			symbol_522.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_523 = PivotFactory.eINSTANCE.createParameter();
			symbol_523.setName("object2");
			//symbol_523.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_523.setType(symbol_59);  // ocl!OclAny
			symbol_523.setLower(BigInteger.valueOf(0));
			
			symbol_522.getOwnedParameters().add(symbol_523);
			symbol_522.setPrecedence(symbol_7);
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_524 = PivotFactory.eINSTANCE.createOperation();
			symbol_524.setName(">");
			//symbol_524.setMoniker("String!>(String)");
			symbol_524.setType(symbol_19);  // Boolean
			symbol_524.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_525 = PivotFactory.eINSTANCE.createParameter();
			symbol_525.setName("s");
			//symbol_525.setMoniker("String!>(String)!s");
			symbol_525.setType(symbol_100);  // String
			symbol_525.setLower(BigInteger.valueOf(0));
			
			symbol_524.getOwnedParameters().add(symbol_525);
			symbol_524.setPrecedence(symbol_6);
			symbol_524.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_524);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_526 = PivotFactory.eINSTANCE.createOperation();
			symbol_526.setName(">=");
			//symbol_526.setMoniker("String!>=(String)");
			symbol_526.setType(symbol_19);  // Boolean
			symbol_526.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("s");
			//symbol_527.setMoniker("String!>=(String)!s");
			symbol_527.setType(symbol_100);  // String
			symbol_527.setLower(BigInteger.valueOf(0));
			
			symbol_526.getOwnedParameters().add(symbol_527);
			symbol_526.setPrecedence(symbol_6);
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_526);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_528 = PivotFactory.eINSTANCE.createOperation();
			symbol_528.setName("at");
			//symbol_528.setMoniker("String!at(Integer)");
			symbol_528.setType(symbol_100);  // String
			symbol_528.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_529 = PivotFactory.eINSTANCE.createParameter();
			symbol_529.setName("i");
			//symbol_529.setMoniker("String!at(Integer)!i");
			symbol_529.setType(symbol_47);  // Integer
			symbol_529.setLower(BigInteger.valueOf(0));
			
			symbol_528.getOwnedParameters().add(symbol_529);
			symbol_528.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_528);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_530 = PivotFactory.eINSTANCE.createOperation();
			symbol_530.setName("characters");
			//symbol_530.setMoniker("String!characters()");
			symbol_530.setType(symbol_188);  // ocl!Sequence[String]
			symbol_530.setLower(BigInteger.valueOf(0));
			
			symbol_530.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_530);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_531 = PivotFactory.eINSTANCE.createOperation();
			symbol_531.setName("concat");
			//symbol_531.setMoniker("String!concat(String)");
			symbol_531.setType(symbol_100);  // String
			symbol_531.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_532 = PivotFactory.eINSTANCE.createParameter();
			symbol_532.setName("s");
			//symbol_532.setMoniker("String!concat(String)!s");
			symbol_532.setType(symbol_100);  // String
			symbol_532.setLower(BigInteger.valueOf(0));
			
			symbol_531.getOwnedParameters().add(symbol_532);
			symbol_531.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_531);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_533 = PivotFactory.eINSTANCE.createOperation();
			symbol_533.setName("equalsIgnoreCase");
			//symbol_533.setMoniker("String!equalsIgnoreCase(String)");
			symbol_533.setType(symbol_19);  // Boolean
			symbol_533.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_534 = PivotFactory.eINSTANCE.createParameter();
			symbol_534.setName("s");
			//symbol_534.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_534.setType(symbol_100);  // String
			symbol_534.setLower(BigInteger.valueOf(0));
			
			symbol_533.getOwnedParameters().add(symbol_534);
			symbol_533.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_533);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_535 = PivotFactory.eINSTANCE.createOperation();
			symbol_535.setName("indexOf");
			//symbol_535.setMoniker("String!indexOf(String)");
			symbol_535.setType(symbol_47);  // Integer
			symbol_535.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_536 = PivotFactory.eINSTANCE.createParameter();
			symbol_536.setName("s");
			//symbol_536.setMoniker("String!indexOf(String)!s");
			symbol_536.setType(symbol_100);  // String
			symbol_536.setLower(BigInteger.valueOf(0));
			
			symbol_535.getOwnedParameters().add(symbol_536);
			symbol_535.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_535);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_537 = PivotFactory.eINSTANCE.createOperation();
			symbol_537.setName("size");
			//symbol_537.setMoniker("String!size()");
			symbol_537.setType(symbol_47);  // Integer
			symbol_537.setLower(BigInteger.valueOf(0));
			
			symbol_537.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_537);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_538 = PivotFactory.eINSTANCE.createOperation();
			symbol_538.setName("substring");
			//symbol_538.setMoniker("String!substring(Integer,Integer)");
			symbol_538.setType(symbol_100);  // String
			symbol_538.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_539 = PivotFactory.eINSTANCE.createParameter();
			symbol_539.setName("lower");
			//symbol_539.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_539.setType(symbol_47);  // Integer
			symbol_539.setLower(BigInteger.valueOf(0));
			
			symbol_538.getOwnedParameters().add(symbol_539);
			Parameter symbol_540 = PivotFactory.eINSTANCE.createParameter();
			symbol_540.setName("upper");
			//symbol_540.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_540.setType(symbol_47);  // Integer
			symbol_540.setLower(BigInteger.valueOf(0));
			
			symbol_538.getOwnedParameters().add(symbol_540);
			symbol_538.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_538);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_541 = PivotFactory.eINSTANCE.createOperation();
			symbol_541.setName("toBoolean");
			//symbol_541.setMoniker("String!toBoolean()");
			symbol_541.setType(symbol_19);  // Boolean
			symbol_541.setLower(BigInteger.valueOf(0));
			
			symbol_541.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_541);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_542 = PivotFactory.eINSTANCE.createOperation();
			symbol_542.setName("toInteger");
			//symbol_542.setMoniker("String!toInteger()");
			symbol_542.setType(symbol_47);  // Integer
			symbol_542.setLower(BigInteger.valueOf(0));
			
			symbol_542.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_542);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_543 = PivotFactory.eINSTANCE.createOperation();
			symbol_543.setName("toLowerCase");
			//symbol_543.setMoniker("String!toLowerCase()");
			symbol_543.setType(symbol_100);  // String
			symbol_543.setLower(BigInteger.valueOf(0));
			
			symbol_543.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_543);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_544 = PivotFactory.eINSTANCE.createOperation();
			symbol_544.setName("toReal");
			//symbol_544.setMoniker("String!toReal()");
			symbol_544.setType(symbol_82);  // Real
			symbol_544.setLower(BigInteger.valueOf(0));
			
			symbol_544.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_544);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_545 = PivotFactory.eINSTANCE.createOperation();
			symbol_545.setName("toString");
			//symbol_545.setMoniker("String!toString()");
			symbol_545.setType(symbol_100);  // String
			symbol_545.setLower(BigInteger.valueOf(0));
			
			symbol_545.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_545);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("toUpperCase");
			//symbol_546.setMoniker("String!toUpperCase()");
			symbol_546.setType(symbol_100);  // String
			symbol_546.setLower(BigInteger.valueOf(0));
			
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_100.getOwnedOperations().add(symbol_546);
		}
		symbol_1.getOwnedTypes().add(symbol_100);
		//
		// ocl::UniqueCollection ocl!UniqueCollection{T}
		//
		symbol_101.setName("UniqueCollection");
		//symbol_101.setMoniker("ocl!UniqueCollection{T}");
		symbol_101.setElementType(symbol_104);
		symbol_104.setName("T");
		symbol_103.setOwnedParameteredElement(symbol_104);
		symbol_102.getOwnedParameters().add(symbol_103);
		
		symbol_101.setOwnedTemplateSignature(symbol_102);
		symbol_101.getSuperClasses().add(symbol_129); // ocl!Collection[ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl!UniqueCollection{T}!sortedBy(T)
			Iteration symbol_547 = PivotFactory.eINSTANCE.createIteration();
			symbol_547.setName("sortedBy");
			//symbol_547.setMoniker("ocl!UniqueCollection{T}!sortedBy(T)");
			symbol_547.setType(symbol_181);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_548 = PivotFactory.eINSTANCE.createParameter();
			symbol_548.setName("i");
			symbol_548.setType(symbol_104);  // ocl!UniqueCollection{T}?T
			symbol_547.getOwnedIterators().add(symbol_548);
			symbol_547.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_101.getOwnedOperations().add(symbol_547);
		}
		symbol_1.getOwnedTypes().add(symbol_101);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_105.setName("UnlimitedNatural");
		//symbol_105.setMoniker("UnlimitedNatural");
		symbol_105.getSuperClasses().add(symbol_47); // Integer
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// ocl::orphanage
		//
		symbol_106.setName("orphanage");
		symbol_106.setMoniker("orphanage");
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}?T]
		//
		symbol_107.setName("Bag");
		//symbol_107.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}?T]");
		symbol_107.setElementType(symbol_51);
		{
			TemplateBinding symbol_549 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_549.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_550 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_550.setFormal(symbol_14);	
				symbol_550.setActual(symbol_51);	
				symbol_549.getParameterSubstitutions().add(symbol_550);
			}
			symbol_107.getTemplateBindings().add(symbol_549);
		}
		symbol_107.getSuperClasses().add(symbol_159); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_107.getSuperClasses().add(symbol_152); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_107);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_108.setName("Bag");
		//symbol_108.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_108.setElementType(symbol_27);
		{
			TemplateBinding symbol_551 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_551.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_552 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_552.setFormal(symbol_14);	
				symbol_552.setActual(symbol_27);	
				symbol_551.getParameterSubstitutions().add(symbol_552);
			}
			symbol_108.getTemplateBindings().add(symbol_551);
		}
		symbol_108.getSuperClasses().add(symbol_168); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_108.getSuperClasses().add(symbol_144); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_108);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_109.setName("Bag");
		//symbol_109.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_109.setElementType(symbol_54);
		{
			TemplateBinding symbol_553 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_553.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_554 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_554.setFormal(symbol_14);	
				symbol_554.setActual(symbol_54);	
				symbol_553.getParameterSubstitutions().add(symbol_554);
			}
			symbol_109.getTemplateBindings().add(symbol_553);
		}
		symbol_109.getSuperClasses().add(symbol_161); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_109.getSuperClasses().add(symbol_154); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_106.getOwnedTypes().add(symbol_109);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_110.setName("Bag");
		//symbol_110.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_110.setElementType(symbol_15);
		{
			TemplateBinding symbol_555 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_555.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_556 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_556.setFormal(symbol_14);	
				symbol_556.setActual(symbol_15);	
				symbol_555.getParameterSubstitutions().add(symbol_556);
			}
			symbol_110.getTemplateBindings().add(symbol_555);
		}
		symbol_110.getSuperClasses().add(symbol_167); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_110.getSuperClasses().add(symbol_158); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_106.getOwnedTypes().add(symbol_110);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_111.setName("Bag");
		//symbol_111.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_111.setElementType(symbol_18);
		{
			TemplateBinding symbol_557 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_557.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_558 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_558.setFormal(symbol_14);	
				symbol_558.setActual(symbol_18);	
				symbol_557.getParameterSubstitutions().add(symbol_558);
			}
			symbol_111.getTemplateBindings().add(symbol_557);
		}
		symbol_111.getSuperClasses().add(symbol_143); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_111.getSuperClasses().add(symbol_169); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_111);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_112.setName("Collection");
		//symbol_112.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_112.setElementType(symbol_77);
		{
			TemplateBinding symbol_559 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_559.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_560 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_560.setFormal(symbol_26);	
				symbol_560.setActual(symbol_77);	
				symbol_559.getParameterSubstitutions().add(symbol_560);
			}
			symbol_112.getTemplateBindings().add(symbol_559);
		}
		symbol_112.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_112);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_113.setName("Collection");
		//symbol_113.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_113.setElementType(symbol_62);
		{
			TemplateBinding symbol_561 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_561.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_562 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_562.setFormal(symbol_26);	
				symbol_562.setActual(symbol_62);	
				symbol_561.getParameterSubstitutions().add(symbol_562);
			}
			symbol_113.getTemplateBindings().add(symbol_561);
		}
		symbol_113.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_113);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_114.setName("Collection");
		//symbol_114.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_114.setElementType(symbol_15);
		{
			TemplateBinding symbol_563 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_563.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_564 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_564.setFormal(symbol_26);	
				symbol_564.setActual(symbol_15);	
				symbol_563.getParameterSubstitutions().add(symbol_564);
			}
			symbol_114.getTemplateBindings().add(symbol_563);
		}
		symbol_114.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_114);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclVoid]
		//
		symbol_115.setName("Collection");
		//symbol_115.setMoniker("ocl!Collection[ocl!OclVoid]");
		symbol_115.setElementType(symbol_70);
		{
			TemplateBinding symbol_565 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_565.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_566 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_566.setFormal(symbol_26);	
				symbol_566.setActual(symbol_70);	
				symbol_565.getParameterSubstitutions().add(symbol_566);
			}
			symbol_115.getTemplateBindings().add(symbol_565);
		}
		symbol_115.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_115);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_116.setName("Collection");
		//symbol_116.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_116.setElementType(symbol_45);
		{
			TemplateBinding symbol_567 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_567.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_568 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_568.setFormal(symbol_26);	
				symbol_568.setActual(symbol_45);	
				symbol_567.getParameterSubstitutions().add(symbol_568);
			}
			symbol_116.getTemplateBindings().add(symbol_567);
		}
		symbol_116.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_116);
		//
		// ocl::orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_117.setName("Collection");
		//symbol_117.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_117.setElementType(symbol_203);
		{
			TemplateBinding symbol_569 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_569.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_570 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_570.setFormal(symbol_26);	
				symbol_570.setActual(symbol_203);	
				symbol_569.getParameterSubstitutions().add(symbol_570);
			}
			symbol_117.getTemplateBindings().add(symbol_569);
		}
		symbol_117.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_117);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_118.setName("Collection");
		//symbol_118.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_118.setElementType(symbol_74);
		{
			TemplateBinding symbol_571 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_571.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_572 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_572.setFormal(symbol_26);	
				symbol_572.setActual(symbol_74);	
				symbol_571.getParameterSubstitutions().add(symbol_572);
			}
			symbol_118.getTemplateBindings().add(symbol_571);
		}
		symbol_118.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_118);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_119.setName("Collection");
		//symbol_119.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_119.setElementType(symbol_39);
		{
			TemplateBinding symbol_573 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_573.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_574 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_574.setFormal(symbol_26);	
				symbol_574.setActual(symbol_39);	
				symbol_573.getParameterSubstitutions().add(symbol_574);
			}
			symbol_119.getTemplateBindings().add(symbol_573);
		}
		symbol_119.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_119);
		//
		// ocl::orphanage::Collection ocl!Collection[String]
		//
		symbol_120.setName("Collection");
		//symbol_120.setMoniker("ocl!Collection[String]");
		symbol_120.setElementType(symbol_100);
		{
			TemplateBinding symbol_575 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_575.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_576 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_576.setFormal(symbol_26);	
				symbol_576.setActual(symbol_100);	
				symbol_575.getParameterSubstitutions().add(symbol_576);
			}
			symbol_120.getTemplateBindings().add(symbol_575);
		}
		symbol_120.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_120);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_121.setName("Collection");
		//symbol_121.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_121.setElementType(symbol_96);
		{
			TemplateBinding symbol_577 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_577.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_578 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_578.setFormal(symbol_26);	
				symbol_578.setActual(symbol_96);	
				symbol_577.getParameterSubstitutions().add(symbol_578);
			}
			symbol_121.getTemplateBindings().add(symbol_577);
		}
		symbol_121.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_121);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_122.setName("Collection");
		//symbol_122.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_122.setElementType(symbol_36);
		{
			TemplateBinding symbol_579 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_579.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_580 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_580.setFormal(symbol_26);	
				symbol_580.setActual(symbol_36);	
				symbol_579.getParameterSubstitutions().add(symbol_580);
			}
			symbol_122.getTemplateBindings().add(symbol_579);
		}
		symbol_122.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_122);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_123.setName("Collection");
		//symbol_123.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_123.setElementType(symbol_59);
		{
			TemplateBinding symbol_581 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_581.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_582 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_582.setFormal(symbol_26);	
				symbol_582.setActual(symbol_59);	
				symbol_581.getParameterSubstitutions().add(symbol_582);
			}
			symbol_123.getTemplateBindings().add(symbol_581);
		}
		symbol_123.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_123);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_124.setName("Collection");
		//symbol_124.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_124.setElementType(symbol_89);
		{
			TemplateBinding symbol_583 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_583.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_584 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_584.setFormal(symbol_26);	
				symbol_584.setActual(symbol_89);	
				symbol_583.getParameterSubstitutions().add(symbol_584);
			}
			symbol_124.getTemplateBindings().add(symbol_583);
		}
		symbol_124.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_124);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_125.setName("Collection");
		//symbol_125.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_125.setElementType(symbol_51);
		{
			TemplateBinding symbol_585 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_585.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_586 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_586.setFormal(symbol_26);	
				symbol_586.setActual(symbol_51);	
				symbol_585.getParameterSubstitutions().add(symbol_586);
			}
			symbol_125.getTemplateBindings().add(symbol_585);
		}
		symbol_125.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_125);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_126.setName("Collection");
		//symbol_126.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_126.setElementType(symbol_27);
		{
			TemplateBinding symbol_587 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_587.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_588 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_588.setFormal(symbol_26);	
				symbol_588.setActual(symbol_27);	
				symbol_587.getParameterSubstitutions().add(symbol_588);
			}
			symbol_126.getTemplateBindings().add(symbol_587);
		}
		symbol_126.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_126);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_127.setName("Collection");
		//symbol_127.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_127.setElementType(symbol_81);
		{
			TemplateBinding symbol_589 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_589.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_590 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_590.setFormal(symbol_26);	
				symbol_590.setActual(symbol_81);	
				symbol_589.getParameterSubstitutions().add(symbol_590);
			}
			symbol_127.getTemplateBindings().add(symbol_589);
		}
		symbol_127.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_127);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_128.setName("Collection");
		//symbol_128.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_128.setElementType(symbol_33);
		{
			TemplateBinding symbol_591 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_591.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_592 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_592.setFormal(symbol_26);	
				symbol_592.setActual(symbol_33);	
				symbol_591.getParameterSubstitutions().add(symbol_592);
			}
			symbol_128.getTemplateBindings().add(symbol_591);
		}
		symbol_128.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_128);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_129.setName("Collection");
		//symbol_129.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_129.setElementType(symbol_104);
		{
			TemplateBinding symbol_593 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_593.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_594 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_594.setFormal(symbol_26);	
				symbol_594.setActual(symbol_104);	
				symbol_593.getParameterSubstitutions().add(symbol_594);
			}
			symbol_129.getTemplateBindings().add(symbol_593);
		}
		symbol_129.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_129);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_130.setName("Collection");
		//symbol_130.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_130.setElementType(symbol_30);
		{
			TemplateBinding symbol_595 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_595.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_596 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_596.setFormal(symbol_26);	
				symbol_596.setActual(symbol_30);	
				symbol_595.getParameterSubstitutions().add(symbol_596);
			}
			symbol_130.getTemplateBindings().add(symbol_595);
		}
		symbol_130.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_130);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_131.setName("Collection");
		//symbol_131.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_131.setElementType(symbol_54);
		{
			TemplateBinding symbol_597 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_597.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_598 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_598.setFormal(symbol_26);	
				symbol_598.setActual(symbol_54);	
				symbol_597.getParameterSubstitutions().add(symbol_598);
			}
			symbol_131.getTemplateBindings().add(symbol_597);
		}
		symbol_131.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_131);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_132.setName("Collection");
		//symbol_132.setMoniker("ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_132.setElementType(symbol_23);
		{
			TemplateBinding symbol_599 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_599.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_600 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_600.setFormal(symbol_26);	
				symbol_600.setActual(symbol_23);	
				symbol_599.getParameterSubstitutions().add(symbol_600);
			}
			symbol_132.getTemplateBindings().add(symbol_599);
		}
		symbol_132.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_132);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_133.setName("Collection");
		//symbol_133.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_133.setElementType(symbol_18);
		{
			TemplateBinding symbol_601 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_601.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_602 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_602.setFormal(symbol_26);	
				symbol_602.setActual(symbol_18);	
				symbol_601.getParameterSubstitutions().add(symbol_602);
			}
			symbol_133.getTemplateBindings().add(symbol_601);
		}
		symbol_133.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_133);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_134.setName("Collection");
		//symbol_134.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_134.setElementType(symbol_58);
		{
			TemplateBinding symbol_603 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_603.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_604 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_604.setFormal(symbol_26);	
				symbol_604.setActual(symbol_58);	
				symbol_603.getParameterSubstitutions().add(symbol_604);
			}
			symbol_134.getTemplateBindings().add(symbol_603);
		}
		symbol_134.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_134);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclInvalid]
		//
		symbol_135.setName("Collection");
		//symbol_135.setMoniker("ocl!Collection[ocl!OclInvalid]");
		symbol_135.setElementType(symbol_66);
		{
			TemplateBinding symbol_605 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_605.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_606 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_606.setFormal(symbol_26);	
				symbol_606.setActual(symbol_66);	
				symbol_605.getParameterSubstitutions().add(symbol_606);
			}
			symbol_135.getTemplateBindings().add(symbol_605);
		}
		symbol_135.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_135);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_136.setName("Collection");
		//symbol_136.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_136.setElementType(symbol_99);
		{
			TemplateBinding symbol_607 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_607.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_608 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_608.setFormal(symbol_26);	
				symbol_608.setActual(symbol_99);	
				symbol_607.getParameterSubstitutions().add(symbol_608);
			}
			symbol_136.getTemplateBindings().add(symbol_607);
		}
		symbol_136.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_136);
		//
		// ocl::orphanage::Collection ocl!Collection[Boolean]
		//
		symbol_137.setName("Collection");
		//symbol_137.setMoniker("ocl!Collection[Boolean]");
		symbol_137.setElementType(symbol_19);
		{
			TemplateBinding symbol_609 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_609.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_610 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_610.setFormal(symbol_26);	
				symbol_610.setActual(symbol_19);	
				symbol_609.getParameterSubstitutions().add(symbol_610);
			}
			symbol_137.getTemplateBindings().add(symbol_609);
		}
		symbol_137.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_137);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_138.setName("Collection");
		//symbol_138.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_138.setElementType(symbol_92);
		{
			TemplateBinding symbol_611 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_611.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_612 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_612.setFormal(symbol_26);	
				symbol_612.setActual(symbol_92);	
				symbol_611.getParameterSubstitutions().add(symbol_612);
			}
			symbol_138.getTemplateBindings().add(symbol_611);
		}
		symbol_138.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_138);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Enumeration]
		//
		symbol_139.setName("Collection");
		//symbol_139.setMoniker("ocl!Collection[ocl!Enumeration]");
		symbol_139.setElementType(symbol_46);
		{
			TemplateBinding symbol_613 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_613.setSignature(symbol_25);
			{
				TemplateParameterSubstitution symbol_614 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_614.setFormal(symbol_26);	
				symbol_614.setActual(symbol_46);	
				symbol_613.getParameterSubstitutions().add(symbol_614);
			}
			symbol_139.getTemplateBindings().add(symbol_613);
		}
		symbol_139.getSuperClasses().add(symbol_59); // ocl!OclAny
		symbol_106.getOwnedTypes().add(symbol_139);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_140.setName("Lambda");
		//symbol_140.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_140.setContextType(symbol_27);
		symbol_140.setResultType(symbol_30);
		symbol_106.getOwnedTypes().add(symbol_140);
		//
		// ocl::orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_141.setName("Lambda");
		//symbol_141.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_141.setContextType(symbol_51);
		symbol_141.setResultType(symbol_54);
		symbol_106.getOwnedTypes().add(symbol_141);
		//
		// ocl::orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_142.setName("Lambda");
		//symbol_142.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_142.setContextType(symbol_74);
		symbol_142.setResultType(symbol_77);
		symbol_106.getOwnedTypes().add(symbol_142);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_143.setName("NonOrderedCollection");
		//symbol_143.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_143.setElementType(symbol_18);
		{
			TemplateBinding symbol_615 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_615.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_616 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_616.setFormal(symbol_50);	
				symbol_616.setActual(symbol_18);	
				symbol_615.getParameterSubstitutions().add(symbol_616);
			}
			symbol_143.getTemplateBindings().add(symbol_615);
		}
		symbol_143.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_143);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_144.setName("NonOrderedCollection");
		//symbol_144.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_144.setElementType(symbol_27);
		{
			TemplateBinding symbol_617 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_617.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_618 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_618.setFormal(symbol_50);	
				symbol_618.setActual(symbol_27);	
				symbol_617.getParameterSubstitutions().add(symbol_618);
			}
			symbol_144.getTemplateBindings().add(symbol_617);
		}
		symbol_144.getSuperClasses().add(symbol_126); // ocl!Collection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_144);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_145.setName("NonOrderedCollection");
		//symbol_145.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_145.setElementType(symbol_59);
		{
			TemplateBinding symbol_619 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_619.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_620 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_620.setFormal(symbol_50);	
				symbol_620.setActual(symbol_59);	
				symbol_619.getParameterSubstitutions().add(symbol_620);
			}
			symbol_145.getTemplateBindings().add(symbol_619);
		}
		symbol_145.getSuperClasses().add(symbol_123); // ocl!Collection[ocl!OclAny]
		symbol_106.getOwnedTypes().add(symbol_145);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_146.setName("NonOrderedCollection");
		//symbol_146.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_146.setElementType(symbol_62);
		{
			TemplateBinding symbol_621 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_621.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_622 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_622.setFormal(symbol_50);	
				symbol_622.setActual(symbol_62);	
				symbol_621.getParameterSubstitutions().add(symbol_622);
			}
			symbol_146.getTemplateBindings().add(symbol_621);
		}
		symbol_146.getSuperClasses().add(symbol_113); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_106.getOwnedTypes().add(symbol_146);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid]
		//
		symbol_147.setName("NonOrderedCollection");
		//symbol_147.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid]");
		symbol_147.setElementType(symbol_70);
		{
			TemplateBinding symbol_623 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_623.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_624 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_624.setFormal(symbol_50);	
				symbol_624.setActual(symbol_70);	
				symbol_623.getParameterSubstitutions().add(symbol_624);
			}
			symbol_147.getTemplateBindings().add(symbol_623);
		}
		symbol_147.getSuperClasses().add(symbol_115); // ocl!Collection[ocl!OclVoid]
		symbol_106.getOwnedTypes().add(symbol_147);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_148.setName("NonOrderedCollection");
		//symbol_148.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_148.setElementType(symbol_203);
		{
			TemplateBinding symbol_625 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_625.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_626 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_626.setFormal(symbol_50);	
				symbol_626.setActual(symbol_203);	
				symbol_625.getParameterSubstitutions().add(symbol_626);
			}
			symbol_148.getTemplateBindings().add(symbol_625);
		}
		symbol_148.getSuperClasses().add(symbol_117); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_106.getOwnedTypes().add(symbol_148);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean]
		//
		symbol_149.setName("NonOrderedCollection");
		//symbol_149.setMoniker("ocl!NonOrderedCollection[Boolean]");
		symbol_149.setElementType(symbol_19);
		{
			TemplateBinding symbol_627 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_627.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_628 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_628.setFormal(symbol_50);	
				symbol_628.setActual(symbol_19);	
				symbol_627.getParameterSubstitutions().add(symbol_628);
			}
			symbol_149.getTemplateBindings().add(symbol_627);
		}
		symbol_149.getSuperClasses().add(symbol_137); // ocl!Collection[Boolean]
		symbol_106.getOwnedTypes().add(symbol_149);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_150.setName("NonOrderedCollection");
		//symbol_150.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_150.setElementType(symbol_99);
		{
			TemplateBinding symbol_629 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_629.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_630 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_630.setFormal(symbol_50);	
				symbol_630.setActual(symbol_99);	
				symbol_629.getParameterSubstitutions().add(symbol_630);
			}
			symbol_150.getTemplateBindings().add(symbol_629);
		}
		symbol_150.getSuperClasses().add(symbol_136); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_150);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_151.setName("NonOrderedCollection");
		//symbol_151.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_151.setElementType(symbol_81);
		{
			TemplateBinding symbol_631 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_631.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_632 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_632.setFormal(symbol_50);	
				symbol_632.setActual(symbol_81);	
				symbol_631.getParameterSubstitutions().add(symbol_632);
			}
			symbol_151.getTemplateBindings().add(symbol_631);
		}
		symbol_151.getSuperClasses().add(symbol_127); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_106.getOwnedTypes().add(symbol_151);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_152.setName("NonOrderedCollection");
		//symbol_152.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_152.setElementType(symbol_51);
		{
			TemplateBinding symbol_633 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_633.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_634 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_634.setFormal(symbol_50);	
				symbol_634.setActual(symbol_51);	
				symbol_633.getParameterSubstitutions().add(symbol_634);
			}
			symbol_152.getTemplateBindings().add(symbol_633);
		}
		symbol_152.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_152);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_153.setName("NonOrderedCollection");
		//symbol_153.setMoniker("ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_153.setElementType(symbol_23);
		{
			TemplateBinding symbol_635 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_635.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_636 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_636.setFormal(symbol_50);	
				symbol_636.setActual(symbol_23);	
				symbol_635.getParameterSubstitutions().add(symbol_636);
			}
			symbol_153.getTemplateBindings().add(symbol_635);
		}
		symbol_153.getSuperClasses().add(symbol_132); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_106.getOwnedTypes().add(symbol_153);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_154.setName("NonOrderedCollection");
		//symbol_154.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_154.setElementType(symbol_54);
		{
			TemplateBinding symbol_637 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_637.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_638 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_638.setFormal(symbol_50);	
				symbol_638.setActual(symbol_54);	
				symbol_637.getParameterSubstitutions().add(symbol_638);
			}
			symbol_154.getTemplateBindings().add(symbol_637);
		}
		symbol_154.getSuperClasses().add(symbol_131); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_106.getOwnedTypes().add(symbol_154);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration]
		//
		symbol_155.setName("NonOrderedCollection");
		//symbol_155.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration]");
		symbol_155.setElementType(symbol_46);
		{
			TemplateBinding symbol_639 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_639.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_640 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_640.setFormal(symbol_50);	
				symbol_640.setActual(symbol_46);	
				symbol_639.getParameterSubstitutions().add(symbol_640);
			}
			symbol_155.getTemplateBindings().add(symbol_639);
		}
		symbol_155.getSuperClasses().add(symbol_139); // ocl!Collection[ocl!Enumeration]
		symbol_106.getOwnedTypes().add(symbol_155);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid]
		//
		symbol_156.setName("NonOrderedCollection");
		//symbol_156.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid]");
		symbol_156.setElementType(symbol_66);
		{
			TemplateBinding symbol_641 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_641.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_642 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_642.setFormal(symbol_50);	
				symbol_642.setActual(symbol_66);	
				symbol_641.getParameterSubstitutions().add(symbol_642);
			}
			symbol_156.getTemplateBindings().add(symbol_641);
		}
		symbol_156.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!OclInvalid]
		symbol_106.getOwnedTypes().add(symbol_156);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_157.setName("NonOrderedCollection");
		//symbol_157.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_157.setElementType(symbol_96);
		{
			TemplateBinding symbol_643 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_643.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_644 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_644.setFormal(symbol_50);	
				symbol_644.setActual(symbol_96);	
				symbol_643.getParameterSubstitutions().add(symbol_644);
			}
			symbol_157.getTemplateBindings().add(symbol_643);
		}
		symbol_157.getSuperClasses().add(symbol_121); // ocl!Collection[ocl!Set{T}?T]
		symbol_106.getOwnedTypes().add(symbol_157);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_158.setName("NonOrderedCollection");
		//symbol_158.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_158.setElementType(symbol_15);
		{
			TemplateBinding symbol_645 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_645.setSignature(symbol_49);
			{
				TemplateParameterSubstitution symbol_646 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_646.setFormal(symbol_50);	
				symbol_646.setActual(symbol_15);	
				symbol_645.getParameterSubstitutions().add(symbol_646);
			}
			symbol_158.getTemplateBindings().add(symbol_645);
		}
		symbol_158.getSuperClasses().add(symbol_114); // ocl!Collection[ocl!Bag{T}?T]
		symbol_106.getOwnedTypes().add(symbol_158);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_159.setName("NonUniqueCollection");
		//symbol_159.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_159.setElementType(symbol_51);
		{
			TemplateBinding symbol_647 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_647.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_648 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_648.setFormal(symbol_57);	
				symbol_648.setActual(symbol_51);	
				symbol_647.getParameterSubstitutions().add(symbol_648);
			}
			symbol_159.getTemplateBindings().add(symbol_647);
		}
		symbol_159.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_159);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_160.setName("NonUniqueCollection");
		//symbol_160.setMoniker("ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_160.setElementType(symbol_58);
		{
			TemplateBinding symbol_649 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_649.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_650 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_650.setFormal(symbol_57);	
				symbol_650.setActual(symbol_58);	
				symbol_649.getParameterSubstitutions().add(symbol_650);
			}
			symbol_160.getTemplateBindings().add(symbol_649);
		}
		symbol_160.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_160);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_161.setName("NonUniqueCollection");
		//symbol_161.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_161.setElementType(symbol_54);
		{
			TemplateBinding symbol_651 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_651.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_652 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_652.setFormal(symbol_57);	
				symbol_652.setActual(symbol_54);	
				symbol_651.getParameterSubstitutions().add(symbol_652);
			}
			symbol_161.getTemplateBindings().add(symbol_651);
		}
		symbol_161.getSuperClasses().add(symbol_131); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_106.getOwnedTypes().add(symbol_161);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_162.setName("NonUniqueCollection");
		//symbol_162.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_162.setElementType(symbol_89);
		{
			TemplateBinding symbol_653 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_653.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_654 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_654.setFormal(symbol_57);	
				symbol_654.setActual(symbol_89);	
				symbol_653.getParameterSubstitutions().add(symbol_654);
			}
			symbol_162.getTemplateBindings().add(symbol_653);
		}
		symbol_162.getSuperClasses().add(symbol_124); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_106.getOwnedTypes().add(symbol_162);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_163.setName("NonUniqueCollection");
		//symbol_163.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_163.setElementType(symbol_77);
		{
			TemplateBinding symbol_655 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_655.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_656 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_656.setFormal(symbol_57);	
				symbol_656.setActual(symbol_77);	
				symbol_655.getParameterSubstitutions().add(symbol_656);
			}
			symbol_163.getTemplateBindings().add(symbol_655);
		}
		symbol_163.getSuperClasses().add(symbol_112); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_106.getOwnedTypes().add(symbol_163);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_164.setName("NonUniqueCollection");
		//symbol_164.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_164.setElementType(symbol_100);
		{
			TemplateBinding symbol_657 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_657.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_658 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_658.setFormal(symbol_57);	
				symbol_658.setActual(symbol_100);	
				symbol_657.getParameterSubstitutions().add(symbol_658);
			}
			symbol_164.getTemplateBindings().add(symbol_657);
		}
		symbol_164.getSuperClasses().add(symbol_120); // ocl!Collection[String]
		symbol_106.getOwnedTypes().add(symbol_164);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_165.setName("NonUniqueCollection");
		//symbol_165.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_165.setElementType(symbol_74);
		{
			TemplateBinding symbol_659 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_659.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_660 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_660.setFormal(symbol_57);	
				symbol_660.setActual(symbol_74);	
				symbol_659.getParameterSubstitutions().add(symbol_660);
			}
			symbol_165.getTemplateBindings().add(symbol_659);
		}
		symbol_165.getSuperClasses().add(symbol_118); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_165);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_166.setName("NonUniqueCollection");
		//symbol_166.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_166.setElementType(symbol_92);
		{
			TemplateBinding symbol_661 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_661.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_662 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_662.setFormal(symbol_57);	
				symbol_662.setActual(symbol_92);	
				symbol_661.getParameterSubstitutions().add(symbol_662);
			}
			symbol_166.getTemplateBindings().add(symbol_661);
		}
		symbol_166.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_166);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_167.setName("NonUniqueCollection");
		//symbol_167.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_167.setElementType(symbol_15);
		{
			TemplateBinding symbol_663 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_663.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_664 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_664.setFormal(symbol_57);	
				symbol_664.setActual(symbol_15);	
				symbol_663.getParameterSubstitutions().add(symbol_664);
			}
			symbol_167.getTemplateBindings().add(symbol_663);
		}
		symbol_167.getSuperClasses().add(symbol_114); // ocl!Collection[ocl!Bag{T}?T]
		symbol_106.getOwnedTypes().add(symbol_167);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_168.setName("NonUniqueCollection");
		//symbol_168.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_168.setElementType(symbol_27);
		{
			TemplateBinding symbol_665 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_665.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_666 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_666.setFormal(symbol_57);	
				symbol_666.setActual(symbol_27);	
				symbol_665.getParameterSubstitutions().add(symbol_666);
			}
			symbol_168.getTemplateBindings().add(symbol_665);
		}
		symbol_168.getSuperClasses().add(symbol_126); // ocl!Collection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_168);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_169.setName("NonUniqueCollection");
		//symbol_169.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_169.setElementType(symbol_18);
		{
			TemplateBinding symbol_667 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_667.setSignature(symbol_56);
			{
				TemplateParameterSubstitution symbol_668 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_668.setFormal(symbol_57);	
				symbol_668.setActual(symbol_18);	
				symbol_667.getParameterSubstitutions().add(symbol_668);
			}
			symbol_169.getTemplateBindings().add(symbol_667);
		}
		symbol_169.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_169);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_170.setName("OrderedCollection");
		//symbol_170.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_170.setElementType(symbol_77);
		{
			TemplateBinding symbol_669 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_669.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_670 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_670.setFormal(symbol_73);	
				symbol_670.setActual(symbol_77);	
				symbol_669.getParameterSubstitutions().add(symbol_670);
			}
			symbol_170.getTemplateBindings().add(symbol_669);
		}
		symbol_170.getSuperClasses().add(symbol_112); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_106.getOwnedTypes().add(symbol_170);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_171.setName("OrderedCollection");
		//symbol_171.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_171.setElementType(symbol_74);
		{
			TemplateBinding symbol_671 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_671.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_672 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_672.setFormal(symbol_73);	
				symbol_672.setActual(symbol_74);	
				symbol_671.getParameterSubstitutions().add(symbol_672);
			}
			symbol_171.getTemplateBindings().add(symbol_671);
		}
		symbol_171.getSuperClasses().add(symbol_118); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_171);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_172.setName("OrderedCollection");
		//symbol_172.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_172.setElementType(symbol_89);
		{
			TemplateBinding symbol_673 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_673.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_674 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_674.setFormal(symbol_73);	
				symbol_674.setActual(symbol_89);	
				symbol_673.getParameterSubstitutions().add(symbol_674);
			}
			symbol_172.getTemplateBindings().add(symbol_673);
		}
		symbol_172.getSuperClasses().add(symbol_124); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_106.getOwnedTypes().add(symbol_172);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_173.setName("OrderedCollection");
		//symbol_173.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_173.setElementType(symbol_58);
		{
			TemplateBinding symbol_675 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_675.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_676 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_676.setFormal(symbol_73);	
				symbol_676.setActual(symbol_58);	
				symbol_675.getParameterSubstitutions().add(symbol_676);
			}
			symbol_173.getTemplateBindings().add(symbol_675);
		}
		symbol_173.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_173);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_174.setName("OrderedCollection");
		//symbol_174.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_174.setElementType(symbol_27);
		{
			TemplateBinding symbol_677 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_677.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_678 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_678.setFormal(symbol_73);	
				symbol_678.setActual(symbol_27);	
				symbol_677.getParameterSubstitutions().add(symbol_678);
			}
			symbol_174.getTemplateBindings().add(symbol_677);
		}
		symbol_174.getSuperClasses().add(symbol_126); // ocl!Collection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_174);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_175.setName("OrderedCollection");
		//symbol_175.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_175.setElementType(symbol_81);
		{
			TemplateBinding symbol_679 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_679.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_680 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_680.setFormal(symbol_73);	
				symbol_680.setActual(symbol_81);	
				symbol_679.getParameterSubstitutions().add(symbol_680);
			}
			symbol_175.getTemplateBindings().add(symbol_679);
		}
		symbol_175.getSuperClasses().add(symbol_127); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_106.getOwnedTypes().add(symbol_175);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_176.setName("OrderedCollection");
		//symbol_176.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_176.setElementType(symbol_104);
		{
			TemplateBinding symbol_681 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_681.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_682 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_682.setFormal(symbol_73);	
				symbol_682.setActual(symbol_104);	
				symbol_681.getParameterSubstitutions().add(symbol_682);
			}
			symbol_176.getTemplateBindings().add(symbol_681);
		}
		symbol_176.getSuperClasses().add(symbol_129); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_176);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_177.setName("OrderedCollection");
		//symbol_177.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_177.setElementType(symbol_92);
		{
			TemplateBinding symbol_683 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_683.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_684 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_684.setFormal(symbol_73);	
				symbol_684.setActual(symbol_92);	
				symbol_683.getParameterSubstitutions().add(symbol_684);
			}
			symbol_177.getTemplateBindings().add(symbol_683);
		}
		symbol_177.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_177);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_178.setName("OrderedCollection");
		//symbol_178.setMoniker("ocl!OrderedCollection[String]");
		symbol_178.setElementType(symbol_100);
		{
			TemplateBinding symbol_685 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_685.setSignature(symbol_72);
			{
				TemplateParameterSubstitution symbol_686 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_686.setFormal(symbol_73);	
				symbol_686.setActual(symbol_100);	
				symbol_685.getParameterSubstitutions().add(symbol_686);
			}
			symbol_178.getTemplateBindings().add(symbol_685);
		}
		symbol_178.getSuperClasses().add(symbol_120); // ocl!Collection[String]
		symbol_106.getOwnedTypes().add(symbol_178);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_179.setName("OrderedSet");
		//symbol_179.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_179.setElementType(symbol_27);
		{
			TemplateBinding symbol_687 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_687.setSignature(symbol_79);
			{
				TemplateParameterSubstitution symbol_688 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_688.setFormal(symbol_80);	
				symbol_688.setActual(symbol_27);	
				symbol_687.getParameterSubstitutions().add(symbol_688);
			}
			symbol_179.getTemplateBindings().add(symbol_687);
		}
		symbol_179.getSuperClasses().add(symbol_212); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_179.getSuperClasses().add(symbol_174); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_179);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_180.setName("OrderedSet");
		//symbol_180.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_180.setElementType(symbol_81);
		{
			TemplateBinding symbol_689 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_689.setSignature(symbol_79);
			{
				TemplateParameterSubstitution symbol_690 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_690.setFormal(symbol_80);	
				symbol_690.setActual(symbol_81);	
				symbol_689.getParameterSubstitutions().add(symbol_690);
			}
			symbol_180.getTemplateBindings().add(symbol_689);
		}
		symbol_180.getSuperClasses().add(symbol_215); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_180.getSuperClasses().add(symbol_175); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_106.getOwnedTypes().add(symbol_180);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_181.setName("OrderedSet");
		//symbol_181.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_181.setElementType(symbol_104);
		{
			TemplateBinding symbol_691 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_691.setSignature(symbol_79);
			{
				TemplateParameterSubstitution symbol_692 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_692.setFormal(symbol_80);	
				symbol_692.setActual(symbol_104);	
				symbol_691.getParameterSubstitutions().add(symbol_692);
			}
			symbol_181.getTemplateBindings().add(symbol_691);
		}
		symbol_181.getSuperClasses().add(symbol_176); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_181.getSuperClasses().add(symbol_220); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_181);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_182.setName("OrderedSet");
		//symbol_182.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_182.setElementType(symbol_74);
		{
			TemplateBinding symbol_693 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_693.setSignature(symbol_79);
			{
				TemplateParameterSubstitution symbol_694 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_694.setFormal(symbol_80);	
				symbol_694.setActual(symbol_74);	
				symbol_693.getParameterSubstitutions().add(symbol_694);
			}
			symbol_182.getTemplateBindings().add(symbol_693);
		}
		symbol_182.getSuperClasses().add(symbol_210); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_182.getSuperClasses().add(symbol_171); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_182);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_183.setName("Sequence");
		//symbol_183.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_183.setElementType(symbol_92);
		{
			TemplateBinding symbol_695 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_695.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_696 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_696.setFormal(symbol_88);	
				symbol_696.setActual(symbol_92);	
				symbol_695.getParameterSubstitutions().add(symbol_696);
			}
			symbol_183.getTemplateBindings().add(symbol_695);
		}
		symbol_183.getSuperClasses().add(symbol_166); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_183.getSuperClasses().add(symbol_177); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_183);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_184.setName("Sequence");
		//symbol_184.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_184.setElementType(symbol_77);
		{
			TemplateBinding symbol_697 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_697.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_698 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_698.setFormal(symbol_88);	
				symbol_698.setActual(symbol_77);	
				symbol_697.getParameterSubstitutions().add(symbol_698);
			}
			symbol_184.getTemplateBindings().add(symbol_697);
		}
		symbol_184.getSuperClasses().add(symbol_170); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_184.getSuperClasses().add(symbol_163); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_106.getOwnedTypes().add(symbol_184);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_185.setName("Sequence");
		//symbol_185.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_185.setElementType(symbol_27);
		{
			TemplateBinding symbol_699 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_699.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_700 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_700.setFormal(symbol_88);	
				symbol_700.setActual(symbol_27);	
				symbol_699.getParameterSubstitutions().add(symbol_700);
			}
			symbol_185.getTemplateBindings().add(symbol_699);
		}
		symbol_185.getSuperClasses().add(symbol_168); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_185.getSuperClasses().add(symbol_174); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_185);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_186.setName("Sequence");
		//symbol_186.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_186.setElementType(symbol_58);
		{
			TemplateBinding symbol_701 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_701.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_702 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_702.setFormal(symbol_88);	
				symbol_702.setActual(symbol_58);	
				symbol_701.getParameterSubstitutions().add(symbol_702);
			}
			symbol_186.getTemplateBindings().add(symbol_701);
		}
		symbol_186.getSuperClasses().add(symbol_173); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_186.getSuperClasses().add(symbol_160); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_186);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_187.setName("Sequence");
		//symbol_187.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_187.setElementType(symbol_89);
		{
			TemplateBinding symbol_703 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_703.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_704 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_704.setFormal(symbol_88);	
				symbol_704.setActual(symbol_89);	
				symbol_703.getParameterSubstitutions().add(symbol_704);
			}
			symbol_187.getTemplateBindings().add(symbol_703);
		}
		symbol_187.getSuperClasses().add(symbol_162); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_187.getSuperClasses().add(symbol_172); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_106.getOwnedTypes().add(symbol_187);
		//
		// ocl::orphanage::Sequence ocl!Sequence[String]
		//
		symbol_188.setName("Sequence");
		//symbol_188.setMoniker("ocl!Sequence[String]");
		symbol_188.setElementType(symbol_100);
		{
			TemplateBinding symbol_705 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_705.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_706 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_706.setFormal(symbol_88);	
				symbol_706.setActual(symbol_100);	
				symbol_705.getParameterSubstitutions().add(symbol_706);
			}
			symbol_188.getTemplateBindings().add(symbol_705);
		}
		symbol_188.getSuperClasses().add(symbol_178); // ocl!OrderedCollection[String]
		symbol_188.getSuperClasses().add(symbol_164); // ocl!NonUniqueCollection[String]
		symbol_106.getOwnedTypes().add(symbol_188);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_189.setName("Sequence");
		//symbol_189.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_189.setElementType(symbol_74);
		{
			TemplateBinding symbol_707 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_707.setSignature(symbol_87);
			{
				TemplateParameterSubstitution symbol_708 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_708.setFormal(symbol_88);	
				symbol_708.setActual(symbol_74);	
				symbol_707.getParameterSubstitutions().add(symbol_708);
			}
			symbol_189.getTemplateBindings().add(symbol_707);
		}
		symbol_189.getSuperClasses().add(symbol_165); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_189.getSuperClasses().add(symbol_171); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_189);
		//
		// ocl::orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_190.setName("Set");
		//symbol_190.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_190.setElementType(symbol_203);
		{
			TemplateBinding symbol_709 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_709.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_710 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_710.setFormal(symbol_95);	
				symbol_710.setActual(symbol_203);	
				symbol_709.getParameterSubstitutions().add(symbol_710);
			}
			symbol_190.getTemplateBindings().add(symbol_709);
		}
		symbol_190.getSuperClasses().add(symbol_216); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_190.getSuperClasses().add(symbol_148); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_106.getOwnedTypes().add(symbol_190);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_191.setName("Set");
		//symbol_191.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_191.setElementType(symbol_99);
		{
			TemplateBinding symbol_711 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_711.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_712 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_712.setFormal(symbol_95);	
				symbol_712.setActual(symbol_99);	
				symbol_711.getParameterSubstitutions().add(symbol_712);
			}
			symbol_191.getTemplateBindings().add(symbol_711);
		}
		symbol_191.getSuperClasses().add(symbol_150); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_191.getSuperClasses().add(symbol_207); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_191);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_192.setName("Set");
		//symbol_192.setMoniker("ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_192.setElementType(symbol_23);
		{
			TemplateBinding symbol_713 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_713.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_714 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_714.setFormal(symbol_95);	
				symbol_714.setActual(symbol_23);	
				symbol_713.getParameterSubstitutions().add(symbol_714);
			}
			symbol_192.getTemplateBindings().add(symbol_713);
		}
		symbol_192.getSuperClasses().add(symbol_206); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_192.getSuperClasses().add(symbol_153); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_106.getOwnedTypes().add(symbol_192);
		//
		// ocl::orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_193.setName("Set");
		//symbol_193.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_193.setElementType(symbol_51);
		{
			TemplateBinding symbol_715 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_715.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_716 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_716.setFormal(symbol_95);	
				symbol_716.setActual(symbol_51);	
				symbol_715.getParameterSubstitutions().add(symbol_716);
			}
			symbol_193.getTemplateBindings().add(symbol_715);
		}
		symbol_193.getSuperClasses().add(symbol_213); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_193.getSuperClasses().add(symbol_152); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_193);
		//
		// ocl::orphanage::Set ocl!Set[Boolean]
		//
		symbol_194.setName("Set");
		//symbol_194.setMoniker("ocl!Set[Boolean]");
		symbol_194.setElementType(symbol_19);
		{
			TemplateBinding symbol_717 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_717.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_718 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_718.setFormal(symbol_95);	
				symbol_718.setActual(symbol_19);	
				symbol_717.getParameterSubstitutions().add(symbol_718);
			}
			symbol_194.getTemplateBindings().add(symbol_717);
		}
		symbol_194.getSuperClasses().add(symbol_219); // ocl!UniqueCollection[Boolean]
		symbol_194.getSuperClasses().add(symbol_149); // ocl!NonOrderedCollection[Boolean]
		symbol_106.getOwnedTypes().add(symbol_194);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_195.setName("Set");
		//symbol_195.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_195.setElementType(symbol_27);
		{
			TemplateBinding symbol_719 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_719.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_720 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_720.setFormal(symbol_95);	
				symbol_720.setActual(symbol_27);	
				symbol_719.getParameterSubstitutions().add(symbol_720);
			}
			symbol_195.getTemplateBindings().add(symbol_719);
		}
		symbol_195.getSuperClasses().add(symbol_212); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_195.getSuperClasses().add(symbol_144); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_195);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_196.setName("Set");
		//symbol_196.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_196.setElementType(symbol_96);
		{
			TemplateBinding symbol_721 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_721.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_722 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_722.setFormal(symbol_95);	
				symbol_722.setActual(symbol_96);	
				symbol_721.getParameterSubstitutions().add(symbol_722);
			}
			symbol_196.getTemplateBindings().add(symbol_721);
		}
		symbol_196.getSuperClasses().add(symbol_209); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_196.getSuperClasses().add(symbol_157); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_106.getOwnedTypes().add(symbol_196);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_197.setName("Set");
		//symbol_197.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_197.setElementType(symbol_59);
		{
			TemplateBinding symbol_723 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_723.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_724 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_724.setFormal(symbol_95);	
				symbol_724.setActual(symbol_59);	
				symbol_723.getParameterSubstitutions().add(symbol_724);
			}
			symbol_197.getTemplateBindings().add(symbol_723);
		}
		symbol_197.getSuperClasses().add(symbol_145); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_197.getSuperClasses().add(symbol_217); // ocl!UniqueCollection[ocl!OclAny]
		symbol_106.getOwnedTypes().add(symbol_197);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclInvalid]
		//
		symbol_198.setName("Set");
		//symbol_198.setMoniker("ocl!Set[ocl!OclInvalid]");
		symbol_198.setElementType(symbol_66);
		{
			TemplateBinding symbol_725 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_725.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_726 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_726.setFormal(symbol_95);	
				symbol_726.setActual(symbol_66);	
				symbol_725.getParameterSubstitutions().add(symbol_726);
			}
			symbol_198.getTemplateBindings().add(symbol_725);
		}
		symbol_198.getSuperClasses().add(symbol_208); // ocl!UniqueCollection[ocl!OclInvalid]
		symbol_198.getSuperClasses().add(symbol_156); // ocl!NonOrderedCollection[ocl!OclInvalid]
		symbol_106.getOwnedTypes().add(symbol_198);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_199.setName("Set");
		//symbol_199.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_199.setElementType(symbol_81);
		{
			TemplateBinding symbol_727 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_727.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_728 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_728.setFormal(symbol_95);	
				symbol_728.setActual(symbol_81);	
				symbol_727.getParameterSubstitutions().add(symbol_728);
			}
			symbol_199.getTemplateBindings().add(symbol_727);
		}
		symbol_199.getSuperClasses().add(symbol_151); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_199.getSuperClasses().add(symbol_215); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_106.getOwnedTypes().add(symbol_199);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclVoid]
		//
		symbol_200.setName("Set");
		//symbol_200.setMoniker("ocl!Set[ocl!OclVoid]");
		symbol_200.setElementType(symbol_70);
		{
			TemplateBinding symbol_729 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_729.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_730 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_730.setFormal(symbol_95);	
				symbol_730.setActual(symbol_70);	
				symbol_729.getParameterSubstitutions().add(symbol_730);
			}
			symbol_200.getTemplateBindings().add(symbol_729);
		}
		symbol_200.getSuperClasses().add(symbol_211); // ocl!UniqueCollection[ocl!OclVoid]
		symbol_200.getSuperClasses().add(symbol_147); // ocl!NonOrderedCollection[ocl!OclVoid]
		symbol_106.getOwnedTypes().add(symbol_200);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Enumeration]
		//
		symbol_201.setName("Set");
		//symbol_201.setMoniker("ocl!Set[ocl!Enumeration]");
		symbol_201.setElementType(symbol_46);
		{
			TemplateBinding symbol_731 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_731.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_732 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_732.setFormal(symbol_95);	
				symbol_732.setActual(symbol_46);	
				symbol_731.getParameterSubstitutions().add(symbol_732);
			}
			symbol_201.getTemplateBindings().add(symbol_731);
		}
		symbol_201.getSuperClasses().add(symbol_214); // ocl!UniqueCollection[ocl!Enumeration]
		symbol_201.getSuperClasses().add(symbol_155); // ocl!NonOrderedCollection[ocl!Enumeration]
		symbol_106.getOwnedTypes().add(symbol_201);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_202.setName("Set");
		//symbol_202.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_202.setElementType(symbol_62);
		{
			TemplateBinding symbol_733 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_733.setSignature(symbol_94);
			{
				TemplateParameterSubstitution symbol_734 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_734.setFormal(symbol_95);	
				symbol_734.setActual(symbol_62);	
				symbol_733.getParameterSubstitutions().add(symbol_734);
			}
			symbol_202.getTemplateBindings().add(symbol_733);
		}
		symbol_202.getSuperClasses().add(symbol_218); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_202.getSuperClasses().add(symbol_146); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_106.getOwnedTypes().add(symbol_202);
		//
		// ocl::orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_203.setName("Tuple");
		//symbol_203.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		{ // ocl::orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_204.setName("first");
			symbol_204.setType(symbol_27);  // ocl!Collection{T}?T
			
			symbol_204.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_204);
		}
		{ // ocl::orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_205.setName("second");
			symbol_205.setType(symbol_45);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_205.setIsResolveProxies(true);
			symbol_203.getOwnedAttributes().add(symbol_205);
		}
		symbol_106.getOwnedTypes().add(symbol_203);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_206.setName("UniqueCollection");
		//symbol_206.setMoniker("ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_206.setElementType(symbol_23);
		{
			TemplateBinding symbol_735 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_735.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_736 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_736.setFormal(symbol_103);	
				symbol_736.setActual(symbol_23);	
				symbol_735.getParameterSubstitutions().add(symbol_736);
			}
			symbol_206.getTemplateBindings().add(symbol_735);
		}
		symbol_206.getSuperClasses().add(symbol_132); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_106.getOwnedTypes().add(symbol_206);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_207.setName("UniqueCollection");
		//symbol_207.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_207.setElementType(symbol_99);
		{
			TemplateBinding symbol_737 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_737.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_738 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_738.setFormal(symbol_103);	
				symbol_738.setActual(symbol_99);	
				symbol_737.getParameterSubstitutions().add(symbol_738);
			}
			symbol_207.getTemplateBindings().add(symbol_737);
		}
		symbol_207.getSuperClasses().add(symbol_136); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_106.getOwnedTypes().add(symbol_207);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid]
		//
		symbol_208.setName("UniqueCollection");
		//symbol_208.setMoniker("ocl!UniqueCollection[ocl!OclInvalid]");
		symbol_208.setElementType(symbol_66);
		{
			TemplateBinding symbol_739 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_739.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_740 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_740.setFormal(symbol_103);	
				symbol_740.setActual(symbol_66);	
				symbol_739.getParameterSubstitutions().add(symbol_740);
			}
			symbol_208.getTemplateBindings().add(symbol_739);
		}
		symbol_208.getSuperClasses().add(symbol_135); // ocl!Collection[ocl!OclInvalid]
		symbol_106.getOwnedTypes().add(symbol_208);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_209.setName("UniqueCollection");
		//symbol_209.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_209.setElementType(symbol_96);
		{
			TemplateBinding symbol_741 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_741.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_742 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_742.setFormal(symbol_103);	
				symbol_742.setActual(symbol_96);	
				symbol_741.getParameterSubstitutions().add(symbol_742);
			}
			symbol_209.getTemplateBindings().add(symbol_741);
		}
		symbol_209.getSuperClasses().add(symbol_121); // ocl!Collection[ocl!Set{T}?T]
		symbol_106.getOwnedTypes().add(symbol_209);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_210.setName("UniqueCollection");
		//symbol_210.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_210.setElementType(symbol_74);
		{
			TemplateBinding symbol_743 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_743.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_744 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_744.setFormal(symbol_103);	
				symbol_744.setActual(symbol_74);	
				symbol_743.getParameterSubstitutions().add(symbol_744);
			}
			symbol_210.getTemplateBindings().add(symbol_743);
		}
		symbol_210.getSuperClasses().add(symbol_118); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_210);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid]
		//
		symbol_211.setName("UniqueCollection");
		//symbol_211.setMoniker("ocl!UniqueCollection[ocl!OclVoid]");
		symbol_211.setElementType(symbol_70);
		{
			TemplateBinding symbol_745 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_745.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_746 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_746.setFormal(symbol_103);	
				symbol_746.setActual(symbol_70);	
				symbol_745.getParameterSubstitutions().add(symbol_746);
			}
			symbol_211.getTemplateBindings().add(symbol_745);
		}
		symbol_211.getSuperClasses().add(symbol_115); // ocl!Collection[ocl!OclVoid]
		symbol_106.getOwnedTypes().add(symbol_211);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_212.setName("UniqueCollection");
		//symbol_212.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_212.setElementType(symbol_27);
		{
			TemplateBinding symbol_747 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_747.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_748 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_748.setFormal(symbol_103);	
				symbol_748.setActual(symbol_27);	
				symbol_747.getParameterSubstitutions().add(symbol_748);
			}
			symbol_212.getTemplateBindings().add(symbol_747);
		}
		symbol_212.getSuperClasses().add(symbol_126); // ocl!Collection[ocl!Collection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_212);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_213.setName("UniqueCollection");
		//symbol_213.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_213.setElementType(symbol_51);
		{
			TemplateBinding symbol_749 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_749.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_750 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_750.setFormal(symbol_103);	
				symbol_750.setActual(symbol_51);	
				symbol_749.getParameterSubstitutions().add(symbol_750);
			}
			symbol_213.getTemplateBindings().add(symbol_749);
		}
		symbol_213.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_213);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration]
		//
		symbol_214.setName("UniqueCollection");
		//symbol_214.setMoniker("ocl!UniqueCollection[ocl!Enumeration]");
		symbol_214.setElementType(symbol_46);
		{
			TemplateBinding symbol_751 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_751.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_752 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_752.setFormal(symbol_103);	
				symbol_752.setActual(symbol_46);	
				symbol_751.getParameterSubstitutions().add(symbol_752);
			}
			symbol_214.getTemplateBindings().add(symbol_751);
		}
		symbol_214.getSuperClasses().add(symbol_139); // ocl!Collection[ocl!Enumeration]
		symbol_106.getOwnedTypes().add(symbol_214);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_215.setName("UniqueCollection");
		//symbol_215.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_215.setElementType(symbol_81);
		{
			TemplateBinding symbol_753 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_753.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_754 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_754.setFormal(symbol_103);	
				symbol_754.setActual(symbol_81);	
				symbol_753.getParameterSubstitutions().add(symbol_754);
			}
			symbol_215.getTemplateBindings().add(symbol_753);
		}
		symbol_215.getSuperClasses().add(symbol_127); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_106.getOwnedTypes().add(symbol_215);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_216.setName("UniqueCollection");
		//symbol_216.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_216.setElementType(symbol_203);
		{
			TemplateBinding symbol_755 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_755.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_756 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_756.setFormal(symbol_103);	
				symbol_756.setActual(symbol_203);	
				symbol_755.getParameterSubstitutions().add(symbol_756);
			}
			symbol_216.getTemplateBindings().add(symbol_755);
		}
		symbol_216.getSuperClasses().add(symbol_117); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_106.getOwnedTypes().add(symbol_216);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_217.setName("UniqueCollection");
		//symbol_217.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_217.setElementType(symbol_59);
		{
			TemplateBinding symbol_757 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_757.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_758 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_758.setFormal(symbol_103);	
				symbol_758.setActual(symbol_59);	
				symbol_757.getParameterSubstitutions().add(symbol_758);
			}
			symbol_217.getTemplateBindings().add(symbol_757);
		}
		symbol_217.getSuperClasses().add(symbol_123); // ocl!Collection[ocl!OclAny]
		symbol_106.getOwnedTypes().add(symbol_217);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_218.setName("UniqueCollection");
		//symbol_218.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_218.setElementType(symbol_62);
		{
			TemplateBinding symbol_759 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_759.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_760 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_760.setFormal(symbol_103);	
				symbol_760.setActual(symbol_62);	
				symbol_759.getParameterSubstitutions().add(symbol_760);
			}
			symbol_218.getTemplateBindings().add(symbol_759);
		}
		symbol_218.getSuperClasses().add(symbol_113); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_106.getOwnedTypes().add(symbol_218);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[Boolean]
		//
		symbol_219.setName("UniqueCollection");
		//symbol_219.setMoniker("ocl!UniqueCollection[Boolean]");
		symbol_219.setElementType(symbol_19);
		{
			TemplateBinding symbol_761 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_761.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_762 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_762.setFormal(symbol_103);	
				symbol_762.setActual(symbol_19);	
				symbol_761.getParameterSubstitutions().add(symbol_762);
			}
			symbol_219.getTemplateBindings().add(symbol_761);
		}
		symbol_219.getSuperClasses().add(symbol_137); // ocl!Collection[Boolean]
		symbol_106.getOwnedTypes().add(symbol_219);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_220.setName("UniqueCollection");
		//symbol_220.setMoniker("ocl!UniqueCollection[ocl!UniqueCollection{T}?T]");
		symbol_220.setElementType(symbol_104);
		{
			TemplateBinding symbol_763 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_763.setSignature(symbol_102);
			{
				TemplateParameterSubstitution symbol_764 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_764.setFormal(symbol_103);	
				symbol_764.setActual(symbol_104);	
				symbol_763.getParameterSubstitutions().add(symbol_764);
			}
			symbol_220.getTemplateBindings().add(symbol_763);
		}
		symbol_220.getSuperClasses().add(symbol_129); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_106.getOwnedTypes().add(symbol_220);
		symbol_1.getNestedPackages().add(symbol_106);
		return symbol_1;
	}
}
