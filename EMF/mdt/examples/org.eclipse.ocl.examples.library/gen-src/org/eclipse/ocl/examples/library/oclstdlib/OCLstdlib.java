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
 * $Id: OCLstdlib.java,v 1.12 2011/03/17 20:03:16 ewillink Exp $
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
		
		TemplateSignature symbol_34 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_35 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_36 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_37 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!flatten{T2}()!
		TypeTemplateParameter symbol_38 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_39 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!flatten{T2}()?T2
		
		TemplateSignature symbol_40 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_41 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_42 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2
		
		TemplateSignature symbol_43 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)!
		TypeTemplateParameter symbol_44 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_45 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
		
		TemplateSignature symbol_46 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])!
		TypeTemplateParameter symbol_47 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_48 = PivotFactory.eINSTANCE.createClass(); // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
		
		
		Class symbol_49 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration
		TemplateSignature symbol_50 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Enumeration!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_51 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_52 = PivotFactory.eINSTANCE.createClass(); // ocl!Enumeration!allInstances{OclSelf}()?OclSelf
		
		
		PrimitiveType symbol_53 = PivotFactory.eINSTANCE.createPrimitiveType(); // Integer
		
		CollectionType symbol_54 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection{T}
		TemplateSignature symbol_55 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!
		TypeTemplateParameter symbol_56 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_57 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}?T
		
		TemplateSignature symbol_58 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_59 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_60 = PivotFactory.eINSTANCE.createClass(); // ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		
		CollectionType symbol_61 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection{T}
		TemplateSignature symbol_62 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!NonUniqueCollection{T}!
		TypeTemplateParameter symbol_63 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_64 = PivotFactory.eINSTANCE.createClass(); // ocl!NonUniqueCollection{T}?T
		
		
		AnyType symbol_65 = PivotFactory.eINSTANCE.createAnyType(); // ocl!OclAny
		TemplateSignature symbol_66 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsSet{OclSelf}()!
		TypeTemplateParameter symbol_67 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_68 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsSet{OclSelf}()?OclSelf
		
		TemplateSignature symbol_69 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclAny!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_70 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_71 = PivotFactory.eINSTANCE.createClass(); // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
		
		
		InvalidType symbol_72 = PivotFactory.eINSTANCE.createInvalidType(); // ocl!OclInvalid
		TemplateSignature symbol_73 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclInvalid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_74 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_75 = PivotFactory.eINSTANCE.createClass(); // ocl!OclInvalid!allInstances{OclSelf}()?OclSelf
		
		
		Class symbol_76 = PivotFactory.eINSTANCE.createClass(); // ocl!OclMessage
		
		Class symbol_77 = PivotFactory.eINSTANCE.createClass(); // ocl!OclState
		
		Class symbol_78 = PivotFactory.eINSTANCE.createClass(); // ocl!OclTuple
		
		VoidType symbol_79 = PivotFactory.eINSTANCE.createVoidType(); // ocl!OclVoid
		TemplateSignature symbol_80 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OclVoid!allInstances{OclSelf}()!
		TypeTemplateParameter symbol_81 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_82 = PivotFactory.eINSTANCE.createClass(); // ocl!OclVoid!allInstances{OclSelf}()?OclSelf
		
		
		CollectionType symbol_83 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection{T}
		TemplateSignature symbol_84 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!
		TypeTemplateParameter symbol_85 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_86 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}?T
		
		TemplateSignature symbol_87 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!
		TypeTemplateParameter symbol_88 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_89 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		
		OrderedSetType symbol_90 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet{T}
		TemplateSignature symbol_91 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!OrderedSet{T}!
		TypeTemplateParameter symbol_92 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_93 = PivotFactory.eINSTANCE.createClass(); // ocl!OrderedSet{T}?T
		
		
		PrimitiveType symbol_94 = PivotFactory.eINSTANCE.createPrimitiveType(); // Real
		TemplateSignature symbol_95 = PivotFactory.eINSTANCE.createTemplateSignature(); // Real!oclAsType{T}(ocl!Classifier)!
		TypeTemplateParameter symbol_96 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_97 = PivotFactory.eINSTANCE.createClass(); // Real!oclAsType{T}(ocl!Classifier)?T
		
		
		SequenceType symbol_98 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence{T}
		TemplateSignature symbol_99 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!
		TypeTemplateParameter symbol_100 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_101 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}?T
		
		TemplateSignature symbol_102 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Sequence{T}!flatten{T2}()!
		TypeTemplateParameter symbol_103 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_104 = PivotFactory.eINSTANCE.createClass(); // ocl!Sequence{T}!flatten{T2}()?T2
		
		
		SetType symbol_105 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set{T}
		TemplateSignature symbol_106 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!
		TypeTemplateParameter symbol_107 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_108 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}?T
		
		TemplateSignature symbol_109 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!Set{T}!flatten{T2}()!
		TypeTemplateParameter symbol_110 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_111 = PivotFactory.eINSTANCE.createClass(); // ocl!Set{T}!flatten{T2}()?T2
		
		
		PrimitiveType symbol_112 = PivotFactory.eINSTANCE.createPrimitiveType(); // String
		
		CollectionType symbol_113 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection{T}
		TemplateSignature symbol_114 = PivotFactory.eINSTANCE.createTemplateSignature(); // ocl!UniqueCollection{T}!
		TypeTemplateParameter symbol_115 = PivotFactory.eINSTANCE.createTypeTemplateParameter();
		Class symbol_116 = PivotFactory.eINSTANCE.createClass(); // ocl!UniqueCollection{T}?T
		
		
		PrimitiveType symbol_117 = PivotFactory.eINSTANCE.createPrimitiveType(); // UnlimitedNatural
		
		Package symbol_118 = PivotFactory.eINSTANCE.createPackage(); // orphanage
		BagType symbol_119 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}?T]
		
		BagType symbol_120 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}?T]
		
		BagType symbol_121 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		
		BagType symbol_122 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!Collection{T}?T]
		
		BagType symbol_123 = PivotFactory.eINSTANCE.createBagType(); // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_124 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[String]
		
		CollectionType symbol_125 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_126 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}?T]
		
		CollectionType symbol_127 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_128 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_129 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_130 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_131 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_132 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_133 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}?T]
		
		CollectionType symbol_134 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_135 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_136 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_137 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny]
		
		CollectionType symbol_138 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Classifier]
		
		CollectionType symbol_139 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_140 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_141 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		
		CollectionType symbol_142 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_143 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}?T]
		
		CollectionType symbol_144 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		
		CollectionType symbol_145 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_146 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_147 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_148 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_149 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_150 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_151 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_152 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!Collection[ocl!Bag{T}?T]
		
		LambdaType symbol_153 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_154 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		LambdaType symbol_155 = PivotFactory.eINSTANCE.createLambdaType(); // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		
		CollectionType symbol_156 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny]
		
		CollectionType symbol_157 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_158 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_159 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_160 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_161 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		
		CollectionType symbol_162 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_163 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_164 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_165 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_166 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_167 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_168 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_169 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_170 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_171 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_172 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonOrderedCollection[ocl!Classifier]
		
		CollectionType symbol_173 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		
		CollectionType symbol_174 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_175 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_176 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_177 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[String]
		
		CollectionType symbol_178 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		
		CollectionType symbol_179 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		
		CollectionType symbol_180 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_181 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_182 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_183 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_184 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_185 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		CollectionType symbol_186 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_187 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[String]
		
		CollectionType symbol_188 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_189 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		
		CollectionType symbol_190 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_191 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		
		CollectionType symbol_192 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		
		OrderedSetType symbol_193 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedSet{T}?T]
		
		OrderedSetType symbol_194 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!Collection{T}?T]
		
		OrderedSetType symbol_195 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		
		OrderedSetType symbol_196 = PivotFactory.eINSTANCE.createOrderedSetType(); // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		
		SequenceType symbol_197 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}?T]
		
		SequenceType symbol_198 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		
		SequenceType symbol_199 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		
		SequenceType symbol_200 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Sequence{T}?T]
		
		SequenceType symbol_201 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		
		SequenceType symbol_202 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[ocl!Collection{T}?T]
		
		SequenceType symbol_203 = PivotFactory.eINSTANCE.createSequenceType(); // ocl!Sequence[String]
		
		SetType symbol_204 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Collection{T}?T]
		
		SetType symbol_205 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OrderedSet{T}?T]
		
		SetType symbol_206 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_207 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		
		SetType symbol_208 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_209 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Set{T}?T]
		
		SetType symbol_210 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny]
		
		SetType symbol_211 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!NonOrderedCollection{T}?T]
		
		SetType symbol_212 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		SetType symbol_213 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_214 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		SetType symbol_215 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		SetType symbol_216 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier]
		
		SetType symbol_217 = PivotFactory.eINSTANCE.createSetType(); // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		TupleType symbol_218 = PivotFactory.eINSTANCE.createTupleType(); // Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		Property symbol_219 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
		Property symbol_220 = PivotFactory.eINSTANCE.createProperty(); // ocl::orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
		
		CollectionType symbol_221 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_222 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_223 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		
		CollectionType symbol_224 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_225 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		
		CollectionType symbol_226 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		
		CollectionType symbol_227 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny]
		
		CollectionType symbol_228 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		
		CollectionType symbol_229 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Collection{T}?T]
		
		CollectionType symbol_230 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		
		CollectionType symbol_231 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier]
		
		CollectionType symbol_232 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		
		CollectionType symbol_233 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Set{T}?T]
		
		CollectionType symbol_234 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		
		CollectionType symbol_235 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		
		CollectionType symbol_236 = PivotFactory.eINSTANCE.createCollectionType(); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		
		

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
		symbol_12.getSuperClasses().add(symbol_173); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_12.getSuperClasses().add(symbol_168); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		{	// ocl::Bag::<>() ocl!Bag{T}!<>(ocl!OclAny)
			Operation symbol_237 = PivotFactory.eINSTANCE.createOperation();
			symbol_237.setName("<>");
			//symbol_237.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)");
			symbol_237.setType(symbol_19);  // Boolean
			symbol_237.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_238 = PivotFactory.eINSTANCE.createParameter();
			symbol_238.setName("object2");
			//symbol_238.setMoniker("ocl!Bag{T}!<>(ocl!OclAny)!object2");
			symbol_238.setType(symbol_65);  // ocl!OclAny
			symbol_238.setLower(BigInteger.valueOf(0));
			
			symbol_237.getOwnedParameters().add(symbol_238);
			symbol_237.setPrecedence(symbol_7);
			symbol_237.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_237);
		}
		{	// ocl::Bag::=() ocl!Bag{T}!=(ocl!OclAny)
			Operation symbol_239 = PivotFactory.eINSTANCE.createOperation();
			symbol_239.setName("=");
			//symbol_239.setMoniker("ocl!Bag{T}!=(ocl!OclAny)");
			symbol_239.setType(symbol_19);  // Boolean
			symbol_239.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_240 = PivotFactory.eINSTANCE.createParameter();
			symbol_240.setName("object2");
			//symbol_240.setMoniker("ocl!Bag{T}!=(ocl!OclAny)!object2");
			symbol_240.setType(symbol_65);  // ocl!OclAny
			symbol_240.setLower(BigInteger.valueOf(0));
			
			symbol_239.getOwnedParameters().add(symbol_240);
			symbol_239.setPrecedence(symbol_7);
			symbol_239.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_239);
		}
		{	// ocl::Bag::excluding() ocl!Bag{T}!excluding(ocl!OclAny)
			Operation symbol_241 = PivotFactory.eINSTANCE.createOperation();
			symbol_241.setName("excluding");
			//symbol_241.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)");
			symbol_241.setType(symbol_119);  // ocl!Bag[ocl!Bag{T}?T]
			symbol_241.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_242 = PivotFactory.eINSTANCE.createParameter();
			symbol_242.setName("object");
			//symbol_242.setMoniker("ocl!Bag{T}!excluding(ocl!OclAny)!object");
			symbol_242.setType(symbol_65);  // ocl!OclAny
			symbol_242.setLower(BigInteger.valueOf(0));
			
			symbol_241.getOwnedParameters().add(symbol_242);
			symbol_241.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_241);
		}
		{	// ocl::Bag::flatten() ocl!Bag{T}!flatten{T2}()
			Operation symbol_243 = PivotFactory.eINSTANCE.createOperation();
			symbol_18.setName("T2");
			symbol_17.setOwnedParameteredElement(symbol_18);
			symbol_16.getOwnedParameters().add(symbol_17);
			
			symbol_243.setOwnedTemplateSignature(symbol_16);
			symbol_243.setName("flatten");
			//symbol_243.setMoniker("ocl!Bag{T}!flatten{T2}()");
			symbol_243.setType(symbol_121);  // ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
			symbol_243.setLower(BigInteger.valueOf(0));
			
			symbol_243.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_243);
		}
		{	// ocl::Bag::including() ocl!Bag{T}!including(T)
			Operation symbol_244 = PivotFactory.eINSTANCE.createOperation();
			symbol_244.setName("including");
			//symbol_244.setMoniker("ocl!Bag{T}!including(T)");
			symbol_244.setType(symbol_119);  // ocl!Bag[ocl!Bag{T}?T]
			symbol_244.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_245 = PivotFactory.eINSTANCE.createParameter();
			symbol_245.setName("object");
			//symbol_245.setMoniker("ocl!Bag{T}!including(T)!object");
			symbol_245.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_245.setLower(BigInteger.valueOf(0));
			
			symbol_244.getOwnedParameters().add(symbol_245);
			symbol_244.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_244);
		}
		{	// ocl::Bag::reject() ocl!Bag{T}!reject(T)
			Iteration symbol_246 = PivotFactory.eINSTANCE.createIteration();
			symbol_246.setName("reject");
			//symbol_246.setMoniker("ocl!Bag{T}!reject(T)");
			symbol_246.setType(symbol_119);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_247 = PivotFactory.eINSTANCE.createParameter();
			symbol_247.setName("i");
			symbol_247.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_246.getOwnedIterators().add(symbol_247);
			symbol_246.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_246);
		}
		{	// ocl::Bag::select() ocl!Bag{T}!select(T)
			Iteration symbol_248 = PivotFactory.eINSTANCE.createIteration();
			symbol_248.setName("select");
			//symbol_248.setMoniker("ocl!Bag{T}!select(T)");
			symbol_248.setType(symbol_119);  // ocl!Bag[ocl!Bag{T}?T]
			
			Parameter symbol_249 = PivotFactory.eINSTANCE.createParameter();
			symbol_249.setName("i");
			symbol_249.setType(symbol_15);  // ocl!Bag{T}?T
			symbol_248.getOwnedIterators().add(symbol_249);
			symbol_248.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_12.getOwnedOperations().add(symbol_248);
		}
		symbol_1.getOwnedTypes().add(symbol_12);
		//
		// ocl::Boolean Boolean
		//
		symbol_19.setName("Boolean");
		//symbol_19.setMoniker("Boolean");
		symbol_19.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::Boolean::<>() Boolean!<>(ocl!OclAny)
			Operation symbol_250 = PivotFactory.eINSTANCE.createOperation();
			symbol_250.setName("<>");
			//symbol_250.setMoniker("Boolean!<>(ocl!OclAny)");
			symbol_250.setType(symbol_19);  // Boolean
			symbol_250.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_251 = PivotFactory.eINSTANCE.createParameter();
			symbol_251.setName("object2");
			//symbol_251.setMoniker("Boolean!<>(ocl!OclAny)!object2");
			symbol_251.setType(symbol_65);  // ocl!OclAny
			symbol_251.setLower(BigInteger.valueOf(0));
			
			symbol_250.getOwnedParameters().add(symbol_251);
			symbol_250.setPrecedence(symbol_7);
			symbol_250.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_250);
		}
		{	// ocl::Boolean::=() Boolean!=(ocl!OclAny)
			Operation symbol_252 = PivotFactory.eINSTANCE.createOperation();
			symbol_252.setName("=");
			//symbol_252.setMoniker("Boolean!=(ocl!OclAny)");
			symbol_252.setType(symbol_19);  // Boolean
			symbol_252.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_253 = PivotFactory.eINSTANCE.createParameter();
			symbol_253.setName("object2");
			//symbol_253.setMoniker("Boolean!=(ocl!OclAny)!object2");
			symbol_253.setType(symbol_65);  // ocl!OclAny
			symbol_253.setLower(BigInteger.valueOf(0));
			
			symbol_252.getOwnedParameters().add(symbol_253);
			symbol_252.setPrecedence(symbol_7);
			symbol_252.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_252);
		}
		{	// ocl::Boolean::allInstances() Boolean!allInstances{OclSelf}()
			Operation symbol_254 = PivotFactory.eINSTANCE.createOperation();
			symbol_22.setName("OclSelf");
			symbol_21.setOwnedParameteredElement(symbol_22);
			symbol_20.getOwnedParameters().add(symbol_21);
			
			symbol_254.setOwnedTemplateSignature(symbol_20);
			symbol_254.setName("allInstances");
			//symbol_254.setMoniker("Boolean!allInstances{OclSelf}()");
			symbol_254.setType(symbol_208);  // ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
			symbol_254.setLower(BigInteger.valueOf(0));
			
			symbol_254.setIsStatic(true);
			symbol_254.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_254);
		}
		{	// ocl::Boolean::and() Boolean!and(Boolean)
			Operation symbol_255 = PivotFactory.eINSTANCE.createOperation();
			symbol_255.setName("and");
			//symbol_255.setMoniker("Boolean!and(Boolean)");
			symbol_255.setType(symbol_19);  // Boolean
			symbol_255.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_256 = PivotFactory.eINSTANCE.createParameter();
			symbol_256.setName("b");
			//symbol_256.setMoniker("Boolean!and(Boolean)!b");
			symbol_256.setType(symbol_19);  // Boolean
			symbol_256.setLower(BigInteger.valueOf(0));
			
			symbol_255.getOwnedParameters().add(symbol_256);
			symbol_255.setPrecedence(symbol_8);
			symbol_255.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_255);
		}
		{	// ocl::Boolean::implies() Boolean!implies(Boolean)
			Operation symbol_257 = PivotFactory.eINSTANCE.createOperation();
			symbol_257.setName("implies");
			//symbol_257.setMoniker("Boolean!implies(Boolean)");
			symbol_257.setType(symbol_19);  // Boolean
			symbol_257.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_258 = PivotFactory.eINSTANCE.createParameter();
			symbol_258.setName("b");
			//symbol_258.setMoniker("Boolean!implies(Boolean)!b");
			symbol_258.setType(symbol_19);  // Boolean
			symbol_258.setLower(BigInteger.valueOf(0));
			
			symbol_257.getOwnedParameters().add(symbol_258);
			symbol_257.setPrecedence(symbol_11);
			symbol_257.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_257);
		}
		{	// ocl::Boolean::not() Boolean!not()
			Operation symbol_259 = PivotFactory.eINSTANCE.createOperation();
			symbol_259.setName("not");
			//symbol_259.setMoniker("Boolean!not()");
			symbol_259.setType(symbol_19);  // Boolean
			symbol_259.setLower(BigInteger.valueOf(0));
			
			symbol_259.setPrecedence(symbol_3);
			symbol_259.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_259);
		}
		{	// ocl::Boolean::or() Boolean!or(Boolean)
			Operation symbol_260 = PivotFactory.eINSTANCE.createOperation();
			symbol_260.setName("or");
			//symbol_260.setMoniker("Boolean!or(Boolean)");
			symbol_260.setType(symbol_19);  // Boolean
			symbol_260.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_261 = PivotFactory.eINSTANCE.createParameter();
			symbol_261.setName("b");
			//symbol_261.setMoniker("Boolean!or(Boolean)!b");
			symbol_261.setType(symbol_19);  // Boolean
			symbol_261.setLower(BigInteger.valueOf(0));
			
			symbol_260.getOwnedParameters().add(symbol_261);
			symbol_260.setPrecedence(symbol_9);
			symbol_260.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_260);
		}
		{	// ocl::Boolean::toString() Boolean!toString()
			Operation symbol_262 = PivotFactory.eINSTANCE.createOperation();
			symbol_262.setName("toString");
			//symbol_262.setMoniker("Boolean!toString()");
			symbol_262.setType(symbol_112);  // String
			symbol_262.setLower(BigInteger.valueOf(0));
			
			symbol_262.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_262);
		}
		{	// ocl::Boolean::xor() Boolean!xor(Boolean)
			Operation symbol_263 = PivotFactory.eINSTANCE.createOperation();
			symbol_263.setName("xor");
			//symbol_263.setMoniker("Boolean!xor(Boolean)");
			symbol_263.setType(symbol_19);  // Boolean
			symbol_263.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_264 = PivotFactory.eINSTANCE.createParameter();
			symbol_264.setName("b");
			//symbol_264.setMoniker("Boolean!xor(Boolean)!b");
			symbol_264.setType(symbol_19);  // Boolean
			symbol_264.setLower(BigInteger.valueOf(0));
			
			symbol_263.getOwnedParameters().add(symbol_264);
			symbol_263.setPrecedence(symbol_10);
			symbol_263.setImplementation(org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
			symbol_19.getOwnedOperations().add(symbol_263);
		}
		symbol_1.getOwnedTypes().add(symbol_19);
		//
		// ocl::Classifier ocl!Classifier
		//
		symbol_23.setName("Classifier");
		//symbol_23.setMoniker("ocl!Classifier");
		symbol_23.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::Classifier::allInstances() ocl!Classifier!allInstances{OclSelf}()
			Operation symbol_265 = PivotFactory.eINSTANCE.createOperation();
			symbol_26.setName("OclSelf");
			symbol_25.setOwnedParameteredElement(symbol_26);
			symbol_24.getOwnedParameters().add(symbol_25);
			
			symbol_265.setOwnedTemplateSignature(symbol_24);
			symbol_265.setName("allInstances");
			//symbol_265.setMoniker("ocl!Classifier!allInstances{OclSelf}()");
			symbol_265.setType(symbol_217);  // ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
			symbol_265.setLower(BigInteger.valueOf(0));
			
			symbol_265.setIsStatic(true);
			symbol_265.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_265);
		}
		{	// ocl::Classifier::oclContainer() ocl!Classifier!oclContainer()
			Operation symbol_266 = PivotFactory.eINSTANCE.createOperation();
			symbol_266.setName("oclContainer");
			//symbol_266.setMoniker("ocl!Classifier!oclContainer()");
			symbol_266.setType(symbol_23);  // ocl!Classifier
			symbol_266.setLower(BigInteger.valueOf(0));
			
			symbol_266.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_266);
		}
		{	// ocl::Classifier::oclContents() ocl!Classifier!oclContents()
			Operation symbol_267 = PivotFactory.eINSTANCE.createOperation();
			symbol_267.setName("oclContents");
			//symbol_267.setMoniker("ocl!Classifier!oclContents()");
			symbol_267.setType(symbol_216);  // ocl!Set[ocl!Classifier]
			symbol_267.setLower(BigInteger.valueOf(0));
			
			symbol_267.setImplementation(org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);
			symbol_23.getOwnedOperations().add(symbol_267);
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
		symbol_27.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::Collection::<>() ocl!Collection{T}!<>(ocl!OclAny)
			Operation symbol_268 = PivotFactory.eINSTANCE.createOperation();
			symbol_268.setName("<>");
			//symbol_268.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)");
			symbol_268.setType(symbol_19);  // Boolean
			symbol_268.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_269 = PivotFactory.eINSTANCE.createParameter();
			symbol_269.setName("object2");
			//symbol_269.setMoniker("ocl!Collection{T}!<>(ocl!OclAny)!object2");
			symbol_269.setType(symbol_65);  // ocl!OclAny
			symbol_269.setLower(BigInteger.valueOf(0));
			
			symbol_268.getOwnedParameters().add(symbol_269);
			symbol_268.setPrecedence(symbol_7);
			symbol_268.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_268);
		}
		{	// ocl::Collection::=() ocl!Collection{T}!=(ocl!OclAny)
			Operation symbol_270 = PivotFactory.eINSTANCE.createOperation();
			symbol_270.setName("=");
			//symbol_270.setMoniker("ocl!Collection{T}!=(ocl!OclAny)");
			symbol_270.setType(symbol_19);  // Boolean
			symbol_270.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_271 = PivotFactory.eINSTANCE.createParameter();
			symbol_271.setName("object2");
			//symbol_271.setMoniker("ocl!Collection{T}!=(ocl!OclAny)!object2");
			symbol_271.setType(symbol_65);  // ocl!OclAny
			symbol_271.setLower(BigInteger.valueOf(0));
			
			symbol_270.getOwnedParameters().add(symbol_271);
			symbol_270.setPrecedence(symbol_7);
			symbol_270.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_270);
		}
		{	// ocl::Collection::any() ocl!Collection{T}!any(T)
			Iteration symbol_272 = PivotFactory.eINSTANCE.createIteration();
			symbol_272.setName("any");
			//symbol_272.setMoniker("ocl!Collection{T}!any(T)");
			symbol_272.setType(symbol_30);  // ocl!Collection{T}?T
			
			Parameter symbol_273 = PivotFactory.eINSTANCE.createParameter();
			symbol_273.setName("i");
			symbol_273.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_272.getOwnedIterators().add(symbol_273);
			symbol_272.setImplementation(org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_272);
		}
		{	// ocl::Collection::asBag() ocl!Collection{T}!asBag()
			Operation symbol_274 = PivotFactory.eINSTANCE.createOperation();
			symbol_274.setName("asBag");
			//symbol_274.setMoniker("ocl!Collection{T}!asBag()");
			symbol_274.setType(symbol_122);  // ocl!Bag[ocl!Collection{T}?T]
			symbol_274.setLower(BigInteger.valueOf(0));
			
			symbol_274.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_274);
		}
		{	// ocl::Collection::asOrderedSet() ocl!Collection{T}!asOrderedSet()
			Operation symbol_275 = PivotFactory.eINSTANCE.createOperation();
			symbol_275.setName("asOrderedSet");
			//symbol_275.setMoniker("ocl!Collection{T}!asOrderedSet()");
			symbol_275.setType(symbol_194);  // ocl!OrderedSet[ocl!Collection{T}?T]
			symbol_275.setLower(BigInteger.valueOf(0));
			
			symbol_275.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_275);
		}
		{	// ocl::Collection::asSequence() ocl!Collection{T}!asSequence()
			Operation symbol_276 = PivotFactory.eINSTANCE.createOperation();
			symbol_276.setName("asSequence");
			//symbol_276.setMoniker("ocl!Collection{T}!asSequence()");
			symbol_276.setType(symbol_202);  // ocl!Sequence[ocl!Collection{T}?T]
			symbol_276.setLower(BigInteger.valueOf(0));
			
			symbol_276.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_276);
		}
		{	// ocl::Collection::asSet() ocl!Collection{T}!asSet()
			Operation symbol_277 = PivotFactory.eINSTANCE.createOperation();
			symbol_277.setName("asSet");
			//symbol_277.setMoniker("ocl!Collection{T}!asSet()");
			symbol_277.setType(symbol_204);  // ocl!Set[ocl!Collection{T}?T]
			symbol_277.setLower(BigInteger.valueOf(0));
			
			symbol_277.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_277);
		}
		{	// ocl::Collection::collect() ocl!Collection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_278 = PivotFactory.eINSTANCE.createIteration();
			symbol_33.setName("V");
			symbol_32.setOwnedParameteredElement(symbol_33);
			symbol_31.getOwnedParameters().add(symbol_32);
			
			symbol_278.setOwnedTemplateSignature(symbol_31);
			symbol_278.setName("collect");
			//symbol_278.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)");
			symbol_278.setType(symbol_135);  // ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_279 = PivotFactory.eINSTANCE.createParameter();
			symbol_279.setName("i");
			symbol_279.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_278.getOwnedIterators().add(symbol_279);
			Parameter symbol_280 = PivotFactory.eINSTANCE.createParameter();
			symbol_280.setName("body");
			//symbol_280.setMoniker("ocl!Collection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_280.setType(symbol_153);  // Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_278.getOwnedParameters().add(symbol_280);
			symbol_278.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_278);
		}
		{	// ocl::Collection::collectNested() ocl!Collection{T}!collectNested(T)
			Iteration symbol_281 = PivotFactory.eINSTANCE.createIteration();
			symbol_281.setName("collectNested");
			//symbol_281.setMoniker("ocl!Collection{T}!collectNested(T)");
			symbol_281.setType(symbol_143);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_282 = PivotFactory.eINSTANCE.createParameter();
			symbol_282.setName("i");
			symbol_282.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_281.getOwnedIterators().add(symbol_282);
			symbol_281.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_281);
		}
		{	// ocl::Collection::count() ocl!Collection{T}!count(ocl!OclAny)
			Operation symbol_283 = PivotFactory.eINSTANCE.createOperation();
			symbol_283.setName("count");
			//symbol_283.setMoniker("ocl!Collection{T}!count(ocl!OclAny)");
			symbol_283.setType(symbol_53);  // Integer
			symbol_283.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_284 = PivotFactory.eINSTANCE.createParameter();
			symbol_284.setName("object");
			//symbol_284.setMoniker("ocl!Collection{T}!count(ocl!OclAny)!object");
			symbol_284.setType(symbol_65);  // ocl!OclAny
			symbol_284.setLower(BigInteger.valueOf(0));
			
			symbol_283.getOwnedParameters().add(symbol_284);
			symbol_283.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_283);
		}
		{	// ocl::Collection::excludes() ocl!Collection{T}!excludes(ocl!OclAny)
			Operation symbol_285 = PivotFactory.eINSTANCE.createOperation();
			symbol_285.setName("excludes");
			//symbol_285.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)");
			symbol_285.setType(symbol_19);  // Boolean
			symbol_285.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_286 = PivotFactory.eINSTANCE.createParameter();
			symbol_286.setName("object");
			//symbol_286.setMoniker("ocl!Collection{T}!excludes(ocl!OclAny)!object");
			symbol_286.setType(symbol_65);  // ocl!OclAny
			symbol_286.setLower(BigInteger.valueOf(0));
			
			symbol_285.getOwnedParameters().add(symbol_286);
			symbol_285.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_285);
		}
		{	// ocl::Collection::excludesAll() ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])
			Operation symbol_287 = PivotFactory.eINSTANCE.createOperation();
			symbol_36.setName("T2");
			symbol_35.setOwnedParameteredElement(symbol_36);
			symbol_34.getOwnedParameters().add(symbol_35);
			
			symbol_287.setOwnedTemplateSignature(symbol_34);
			symbol_287.setName("excludesAll");
			//symbol_287.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])");
			symbol_287.setType(symbol_19);  // Boolean
			symbol_287.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_288 = PivotFactory.eINSTANCE.createParameter();
			symbol_288.setName("c2");
			//symbol_288.setMoniker("ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])!c2");
			symbol_288.setType(symbol_142);  // ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
			symbol_288.setLower(BigInteger.valueOf(0));
			
			symbol_287.getOwnedParameters().add(symbol_288);
			symbol_287.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_287);
		}
		{	// ocl::Collection::excluding() ocl!Collection{T}!excluding(ocl!OclAny)
			Operation symbol_289 = PivotFactory.eINSTANCE.createOperation();
			symbol_289.setName("excluding");
			//symbol_289.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)");
			symbol_289.setType(symbol_143);  // ocl!Collection[ocl!Collection{T}?T]
			symbol_289.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_290 = PivotFactory.eINSTANCE.createParameter();
			symbol_290.setName("object");
			//symbol_290.setMoniker("ocl!Collection{T}!excluding(ocl!OclAny)!object");
			symbol_290.setType(symbol_65);  // ocl!OclAny
			symbol_290.setLower(BigInteger.valueOf(0));
			
			symbol_289.getOwnedParameters().add(symbol_290);
			symbol_289.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_289);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T)
			Iteration symbol_291 = PivotFactory.eINSTANCE.createIteration();
			symbol_291.setName("exists");
			//symbol_291.setMoniker("ocl!Collection{T}!exists(T)");
			symbol_291.setType(symbol_19);  // Boolean
			
			Parameter symbol_292 = PivotFactory.eINSTANCE.createParameter();
			symbol_292.setName("i");
			symbol_292.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_291.getOwnedIterators().add(symbol_292);
			symbol_291.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_291);
		}
		{	// ocl::Collection::exists() ocl!Collection{T}!exists(T,T)
			Iteration symbol_293 = PivotFactory.eINSTANCE.createIteration();
			symbol_293.setName("exists");
			//symbol_293.setMoniker("ocl!Collection{T}!exists(T,T)");
			symbol_293.setType(symbol_19);  // Boolean
			
			Parameter symbol_294 = PivotFactory.eINSTANCE.createParameter();
			symbol_294.setName("j");
			symbol_294.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_293.getOwnedIterators().add(symbol_294);
			Parameter symbol_295 = PivotFactory.eINSTANCE.createParameter();
			symbol_295.setName("i");
			symbol_295.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_293.getOwnedIterators().add(symbol_295);
			symbol_293.setImplementation(org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_293);
		}
		{	// ocl::Collection::flatten() ocl!Collection{T}!flatten{T2}()
			Operation symbol_296 = PivotFactory.eINSTANCE.createOperation();
			symbol_39.setName("T2");
			symbol_38.setOwnedParameteredElement(symbol_39);
			symbol_37.getOwnedParameters().add(symbol_38);
			
			symbol_296.setOwnedTemplateSignature(symbol_37);
			symbol_296.setName("flatten");
			//symbol_296.setMoniker("ocl!Collection{T}!flatten{T2}()");
			symbol_296.setType(symbol_141);  // ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
			symbol_296.setLower(BigInteger.valueOf(0));
			
			symbol_296.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_296);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T)
			Iteration symbol_297 = PivotFactory.eINSTANCE.createIteration();
			symbol_297.setName("forAll");
			//symbol_297.setMoniker("ocl!Collection{T}!forAll(T)");
			symbol_297.setType(symbol_19);  // Boolean
			
			Parameter symbol_298 = PivotFactory.eINSTANCE.createParameter();
			symbol_298.setName("i");
			symbol_298.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_297.getOwnedIterators().add(symbol_298);
			symbol_297.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_297);
		}
		{	// ocl::Collection::forAll() ocl!Collection{T}!forAll(T,T)
			Iteration symbol_299 = PivotFactory.eINSTANCE.createIteration();
			symbol_299.setName("forAll");
			//symbol_299.setMoniker("ocl!Collection{T}!forAll(T,T)");
			symbol_299.setType(symbol_19);  // Boolean
			
			Parameter symbol_300 = PivotFactory.eINSTANCE.createParameter();
			symbol_300.setName("j");
			symbol_300.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_299.getOwnedIterators().add(symbol_300);
			Parameter symbol_301 = PivotFactory.eINSTANCE.createParameter();
			symbol_301.setName("i");
			symbol_301.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_299.getOwnedIterators().add(symbol_301);
			symbol_299.setImplementation(org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_299);
		}
		{	// ocl::Collection::includes() ocl!Collection{T}!includes(ocl!OclAny)
			Operation symbol_302 = PivotFactory.eINSTANCE.createOperation();
			symbol_302.setName("includes");
			//symbol_302.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)");
			symbol_302.setType(symbol_19);  // Boolean
			symbol_302.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_303 = PivotFactory.eINSTANCE.createParameter();
			symbol_303.setName("object");
			//symbol_303.setMoniker("ocl!Collection{T}!includes(ocl!OclAny)!object");
			symbol_303.setType(symbol_65);  // ocl!OclAny
			symbol_303.setLower(BigInteger.valueOf(0));
			
			symbol_302.getOwnedParameters().add(symbol_303);
			symbol_302.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_302);
		}
		{	// ocl::Collection::includesAll() ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])
			Operation symbol_304 = PivotFactory.eINSTANCE.createOperation();
			symbol_42.setName("T2");
			symbol_41.setOwnedParameteredElement(symbol_42);
			symbol_40.getOwnedParameters().add(symbol_41);
			
			symbol_304.setOwnedTemplateSignature(symbol_40);
			symbol_304.setName("includesAll");
			//symbol_304.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])");
			symbol_304.setType(symbol_19);  // Boolean
			symbol_304.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_305 = PivotFactory.eINSTANCE.createParameter();
			symbol_305.setName("c2");
			//symbol_305.setMoniker("ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])!c2");
			symbol_305.setType(symbol_132);  // ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
			symbol_305.setLower(BigInteger.valueOf(0));
			
			symbol_304.getOwnedParameters().add(symbol_305);
			symbol_304.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_304);
		}
		{	// ocl::Collection::including() ocl!Collection{T}!including(T)
			Operation symbol_306 = PivotFactory.eINSTANCE.createOperation();
			symbol_306.setName("including");
			//symbol_306.setMoniker("ocl!Collection{T}!including(T)");
			symbol_306.setType(symbol_143);  // ocl!Collection[ocl!Collection{T}?T]
			symbol_306.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_307 = PivotFactory.eINSTANCE.createParameter();
			symbol_307.setName("object");
			//symbol_307.setMoniker("ocl!Collection{T}!including(T)!object");
			symbol_307.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_307.setLower(BigInteger.valueOf(0));
			
			symbol_306.getOwnedParameters().add(symbol_307);
			symbol_306.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_306);
		}
		{	// ocl::Collection::isEmpty() ocl!Collection{T}!isEmpty()
			Operation symbol_308 = PivotFactory.eINSTANCE.createOperation();
			symbol_308.setName("isEmpty");
			//symbol_308.setMoniker("ocl!Collection{T}!isEmpty()");
			symbol_308.setType(symbol_19);  // Boolean
			symbol_308.setLower(BigInteger.valueOf(0));
			
			symbol_308.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_308);
		}
		{	// ocl::Collection::isUnique() ocl!Collection{T}!isUnique(T)
			Iteration symbol_309 = PivotFactory.eINSTANCE.createIteration();
			symbol_309.setName("isUnique");
			//symbol_309.setMoniker("ocl!Collection{T}!isUnique(T)");
			symbol_309.setType(symbol_19);  // Boolean
			
			Parameter symbol_310 = PivotFactory.eINSTANCE.createParameter();
			symbol_310.setName("i");
			symbol_310.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_309.getOwnedIterators().add(symbol_310);
			symbol_309.setImplementation(org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_309);
		}
		{	// ocl::Collection::iterate() ocl!Collection{T}!iterate{Tacc}(T;Tacc)
			Iteration symbol_311 = PivotFactory.eINSTANCE.createIteration();
			symbol_45.setName("Tacc");
			symbol_44.setOwnedParameteredElement(symbol_45);
			symbol_43.getOwnedParameters().add(symbol_44);
			
			symbol_311.setOwnedTemplateSignature(symbol_43);
			symbol_311.setName("iterate");
			//symbol_311.setMoniker("ocl!Collection{T}!iterate{Tacc}(T;Tacc)");
			symbol_311.setType(symbol_45);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			
			Parameter symbol_312 = PivotFactory.eINSTANCE.createParameter();
			symbol_312.setName("i");
			symbol_312.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_311.getOwnedIterators().add(symbol_312);
			Parameter symbol_313 = PivotFactory.eINSTANCE.createParameter();
			symbol_313.setName("acc");
			symbol_313.setType(symbol_45);  // ocl!Collection{T}!iterate{Tacc}(T;Tacc)?Tacc
			symbol_311.getOwnedAccumulators().add(symbol_313);
			symbol_311.setImplementation(org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_311);
		}
		{	// ocl::Collection::max() ocl!Collection{T}!max()
			Operation symbol_314 = PivotFactory.eINSTANCE.createOperation();
			symbol_314.setName("max");
			//symbol_314.setMoniker("ocl!Collection{T}!max()");
			symbol_314.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_314.setLower(BigInteger.valueOf(0));
			
			symbol_314.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_314);
		}
		{	// ocl::Collection::min() ocl!Collection{T}!min()
			Operation symbol_315 = PivotFactory.eINSTANCE.createOperation();
			symbol_315.setName("min");
			//symbol_315.setMoniker("ocl!Collection{T}!min()");
			symbol_315.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_315.setLower(BigInteger.valueOf(0));
			
			symbol_315.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_315);
		}
		{	// ocl::Collection::notEmpty() ocl!Collection{T}!notEmpty()
			Operation symbol_316 = PivotFactory.eINSTANCE.createOperation();
			symbol_316.setName("notEmpty");
			//symbol_316.setMoniker("ocl!Collection{T}!notEmpty()");
			symbol_316.setType(symbol_19);  // Boolean
			symbol_316.setLower(BigInteger.valueOf(0));
			
			symbol_316.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_316);
		}
		{	// ocl::Collection::one() ocl!Collection{T}!one(T)
			Iteration symbol_317 = PivotFactory.eINSTANCE.createIteration();
			symbol_317.setName("one");
			//symbol_317.setMoniker("ocl!Collection{T}!one(T)");
			symbol_317.setType(symbol_19);  // Boolean
			
			Parameter symbol_318 = PivotFactory.eINSTANCE.createParameter();
			symbol_318.setName("i");
			symbol_318.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_317.getOwnedIterators().add(symbol_318);
			symbol_317.setImplementation(org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_317);
		}
		{	// ocl::Collection::product() ocl!Collection{T}!product{T2}(ocl!Collection[T2])
			Operation symbol_319 = PivotFactory.eINSTANCE.createOperation();
			symbol_48.setName("T2");
			symbol_47.setOwnedParameteredElement(symbol_48);
			symbol_46.getOwnedParameters().add(symbol_47);
			
			symbol_319.setOwnedTemplateSignature(symbol_46);
			symbol_319.setName("product");
			//symbol_319.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])");
			symbol_319.setType(symbol_215);  // ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
			symbol_319.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_320 = PivotFactory.eINSTANCE.createParameter();
			symbol_320.setName("c2");
			//symbol_320.setMoniker("ocl!Collection{T}!product{T2}(ocl!Collection[T2])!c2");
			symbol_320.setType(symbol_144);  // ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
			symbol_320.setLower(BigInteger.valueOf(0));
			
			symbol_319.getOwnedParameters().add(symbol_320);
			symbol_319.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_319);
		}
		{	// ocl::Collection::reject() ocl!Collection{T}!reject(T)
			Iteration symbol_321 = PivotFactory.eINSTANCE.createIteration();
			symbol_321.setName("reject");
			//symbol_321.setMoniker("ocl!Collection{T}!reject(T)");
			symbol_321.setType(symbol_143);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_322 = PivotFactory.eINSTANCE.createParameter();
			symbol_322.setName("i");
			symbol_322.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_321.getOwnedIterators().add(symbol_322);
			symbol_321.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_321);
		}
		{	// ocl::Collection::select() ocl!Collection{T}!select(T)
			Iteration symbol_323 = PivotFactory.eINSTANCE.createIteration();
			symbol_323.setName("select");
			//symbol_323.setMoniker("ocl!Collection{T}!select(T)");
			symbol_323.setType(symbol_143);  // ocl!Collection[ocl!Collection{T}?T]
			
			Parameter symbol_324 = PivotFactory.eINSTANCE.createParameter();
			symbol_324.setName("i");
			symbol_324.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_323.getOwnedIterators().add(symbol_324);
			symbol_323.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_323);
		}
		{	// ocl::Collection::size() ocl!Collection{T}!size()
			Operation symbol_325 = PivotFactory.eINSTANCE.createOperation();
			symbol_325.setName("size");
			//symbol_325.setMoniker("ocl!Collection{T}!size()");
			symbol_325.setType(symbol_53);  // Integer
			symbol_325.setLower(BigInteger.valueOf(0));
			
			symbol_325.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_325);
		}
		{	// ocl::Collection::sortedBy() ocl!Collection{T}!sortedBy(T)
			Iteration symbol_326 = PivotFactory.eINSTANCE.createIteration();
			symbol_326.setName("sortedBy");
			//symbol_326.setMoniker("ocl!Collection{T}!sortedBy(T)");
			symbol_326.setType(symbol_188);  // ocl!OrderedCollection[ocl!Collection{T}?T]
			
			Parameter symbol_327 = PivotFactory.eINSTANCE.createParameter();
			symbol_327.setName("i");
			symbol_327.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_326.getOwnedIterators().add(symbol_327);
			symbol_326.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_326);
		}
		{	// ocl::Collection::sum() ocl!Collection{T}!sum()
			Operation symbol_328 = PivotFactory.eINSTANCE.createOperation();
			symbol_328.setName("sum");
			//symbol_328.setMoniker("ocl!Collection{T}!sum()");
			symbol_328.setType(symbol_30);  // ocl!Collection{T}?T
			symbol_328.setLower(BigInteger.valueOf(0));
			
			symbol_328.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
			symbol_27.getOwnedOperations().add(symbol_328);
		}
		symbol_1.getOwnedTypes().add(symbol_27);
		//
		// ocl::Enumeration ocl!Enumeration
		//
		symbol_49.setName("Enumeration");
		//symbol_49.setMoniker("ocl!Enumeration");
		symbol_49.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::Enumeration::allInstances() ocl!Enumeration!allInstances{OclSelf}()
			Operation symbol_329 = PivotFactory.eINSTANCE.createOperation();
			symbol_52.setName("OclSelf");
			symbol_51.setOwnedParameteredElement(symbol_52);
			symbol_50.getOwnedParameters().add(symbol_51);
			
			symbol_329.setOwnedTemplateSignature(symbol_50);
			symbol_329.setName("allInstances");
			//symbol_329.setMoniker("ocl!Enumeration!allInstances{OclSelf}()");
			symbol_329.setType(symbol_214);  // ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
			symbol_329.setLower(BigInteger.valueOf(0));
			
			symbol_329.setIsStatic(true);
			symbol_329.setImplementation(org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);
			symbol_49.getOwnedOperations().add(symbol_329);
		}
		symbol_1.getOwnedTypes().add(symbol_49);
		//
		// ocl::Integer Integer
		//
		symbol_53.setName("Integer");
		//symbol_53.setMoniker("Integer");
		symbol_53.getSuperClasses().add(symbol_94); // Real
		{	// ocl::Integer::*() Integer!*(Integer)
			Operation symbol_330 = PivotFactory.eINSTANCE.createOperation();
			symbol_330.setName("*");
			//symbol_330.setMoniker("Integer!*(Integer)");
			symbol_330.setType(symbol_53);  // Integer
			symbol_330.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_331 = PivotFactory.eINSTANCE.createParameter();
			symbol_331.setName("i");
			//symbol_331.setMoniker("Integer!*(Integer)!i");
			symbol_331.setType(symbol_53);  // Integer
			symbol_331.setLower(BigInteger.valueOf(0));
			
			symbol_330.getOwnedParameters().add(symbol_331);
			symbol_330.setPrecedence(symbol_4);
			symbol_330.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_330);
		}
		{	// ocl::Integer::+() Integer!+(Integer)
			Operation symbol_332 = PivotFactory.eINSTANCE.createOperation();
			symbol_332.setName("+");
			//symbol_332.setMoniker("Integer!+(Integer)");
			symbol_332.setType(symbol_53);  // Integer
			symbol_332.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_333 = PivotFactory.eINSTANCE.createParameter();
			symbol_333.setName("i");
			//symbol_333.setMoniker("Integer!+(Integer)!i");
			symbol_333.setType(symbol_53);  // Integer
			symbol_333.setLower(BigInteger.valueOf(0));
			
			symbol_332.getOwnedParameters().add(symbol_333);
			symbol_332.setPrecedence(symbol_5);
			symbol_332.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_332);
		}
		{	// ocl::Integer::-() Integer!-()
			Operation symbol_334 = PivotFactory.eINSTANCE.createOperation();
			symbol_334.setName("-");
			//symbol_334.setMoniker("Integer!-()");
			symbol_334.setType(symbol_53);  // Integer
			symbol_334.setLower(BigInteger.valueOf(0));
			
			symbol_334.setPrecedence(symbol_3);
			symbol_334.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_334);
		}
		{	// ocl::Integer::-() Integer!-(Integer)
			Operation symbol_335 = PivotFactory.eINSTANCE.createOperation();
			symbol_335.setName("-");
			//symbol_335.setMoniker("Integer!-(Integer)");
			symbol_335.setType(symbol_53);  // Integer
			symbol_335.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_336 = PivotFactory.eINSTANCE.createParameter();
			symbol_336.setName("i");
			//symbol_336.setMoniker("Integer!-(Integer)!i");
			symbol_336.setType(symbol_53);  // Integer
			symbol_336.setLower(BigInteger.valueOf(0));
			
			symbol_335.getOwnedParameters().add(symbol_336);
			symbol_335.setPrecedence(symbol_5);
			symbol_335.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_335);
		}
		{	// ocl::Integer::/() Integer!/(Integer)
			Operation symbol_337 = PivotFactory.eINSTANCE.createOperation();
			symbol_337.setName("/");
			//symbol_337.setMoniker("Integer!/(Integer)");
			symbol_337.setType(symbol_94);  // Real
			symbol_337.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_338 = PivotFactory.eINSTANCE.createParameter();
			symbol_338.setName("i");
			//symbol_338.setMoniker("Integer!/(Integer)!i");
			symbol_338.setType(symbol_53);  // Integer
			symbol_338.setLower(BigInteger.valueOf(0));
			
			symbol_337.getOwnedParameters().add(symbol_338);
			symbol_337.setPrecedence(symbol_4);
			symbol_337.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_337);
		}
		{	// ocl::Integer::abs() Integer!abs()
			Operation symbol_339 = PivotFactory.eINSTANCE.createOperation();
			symbol_339.setName("abs");
			//symbol_339.setMoniker("Integer!abs()");
			symbol_339.setType(symbol_53);  // Integer
			symbol_339.setLower(BigInteger.valueOf(0));
			
			symbol_339.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_339);
		}
		{	// ocl::Integer::div() Integer!div(Integer)
			Operation symbol_340 = PivotFactory.eINSTANCE.createOperation();
			symbol_340.setName("div");
			//symbol_340.setMoniker("Integer!div(Integer)");
			symbol_340.setType(symbol_53);  // Integer
			symbol_340.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_341 = PivotFactory.eINSTANCE.createParameter();
			symbol_341.setName("i");
			//symbol_341.setMoniker("Integer!div(Integer)!i");
			symbol_341.setType(symbol_53);  // Integer
			symbol_341.setLower(BigInteger.valueOf(0));
			
			symbol_340.getOwnedParameters().add(symbol_341);
			symbol_340.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_340);
		}
		{	// ocl::Integer::max() Integer!max(Integer)
			Operation symbol_342 = PivotFactory.eINSTANCE.createOperation();
			symbol_342.setName("max");
			//symbol_342.setMoniker("Integer!max(Integer)");
			symbol_342.setType(symbol_53);  // Integer
			symbol_342.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_343 = PivotFactory.eINSTANCE.createParameter();
			symbol_343.setName("i");
			//symbol_343.setMoniker("Integer!max(Integer)!i");
			symbol_343.setType(symbol_53);  // Integer
			symbol_343.setLower(BigInteger.valueOf(0));
			
			symbol_342.getOwnedParameters().add(symbol_343);
			symbol_342.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_342);
		}
		{	// ocl::Integer::min() Integer!min(Integer)
			Operation symbol_344 = PivotFactory.eINSTANCE.createOperation();
			symbol_344.setName("min");
			//symbol_344.setMoniker("Integer!min(Integer)");
			symbol_344.setType(symbol_53);  // Integer
			symbol_344.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_345 = PivotFactory.eINSTANCE.createParameter();
			symbol_345.setName("i");
			//symbol_345.setMoniker("Integer!min(Integer)!i");
			symbol_345.setType(symbol_53);  // Integer
			symbol_345.setLower(BigInteger.valueOf(0));
			
			symbol_344.getOwnedParameters().add(symbol_345);
			symbol_344.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_344);
		}
		{	// ocl::Integer::mod() Integer!mod(Integer)
			Operation symbol_346 = PivotFactory.eINSTANCE.createOperation();
			symbol_346.setName("mod");
			//symbol_346.setMoniker("Integer!mod(Integer)");
			symbol_346.setType(symbol_53);  // Integer
			symbol_346.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_347 = PivotFactory.eINSTANCE.createParameter();
			symbol_347.setName("i");
			//symbol_347.setMoniker("Integer!mod(Integer)!i");
			symbol_347.setType(symbol_53);  // Integer
			symbol_347.setLower(BigInteger.valueOf(0));
			
			symbol_346.getOwnedParameters().add(symbol_347);
			symbol_346.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_346);
		}
		{	// ocl::Integer::toString() Integer!toString()
			Operation symbol_348 = PivotFactory.eINSTANCE.createOperation();
			symbol_348.setName("toString");
			//symbol_348.setMoniker("Integer!toString()");
			symbol_348.setType(symbol_112);  // String
			symbol_348.setLower(BigInteger.valueOf(0));
			
			symbol_348.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_53.getOwnedOperations().add(symbol_348);
		}
		symbol_1.getOwnedTypes().add(symbol_53);
		//
		// ocl::NonOrderedCollection ocl!NonOrderedCollection{T}
		//
		symbol_54.setName("NonOrderedCollection");
		//symbol_54.setMoniker("ocl!NonOrderedCollection{T}");
		symbol_54.setElementType(symbol_57);
		symbol_57.setName("T");
		symbol_56.setOwnedParameteredElement(symbol_57);
		symbol_55.getOwnedParameters().add(symbol_56);
		
		symbol_54.setOwnedTemplateSignature(symbol_55);
		symbol_54.getSuperClasses().add(symbol_131); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		{	// ocl::NonOrderedCollection::closure() ocl!NonOrderedCollection{T}!closure(T)
			Iteration symbol_349 = PivotFactory.eINSTANCE.createIteration();
			symbol_349.setName("closure");
			//symbol_349.setMoniker("ocl!NonOrderedCollection{T}!closure(T)");
			symbol_349.setType(symbol_211);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_350 = PivotFactory.eINSTANCE.createParameter();
			symbol_350.setName("i");
			symbol_350.setType(symbol_57);  // ocl!NonOrderedCollection{T}?T
			symbol_349.getOwnedIterators().add(symbol_350);
			symbol_349.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_349);
		}
		{	// ocl::NonOrderedCollection::collect() ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_351 = PivotFactory.eINSTANCE.createIteration();
			symbol_60.setName("V");
			symbol_59.setOwnedParameteredElement(symbol_60);
			symbol_58.getOwnedParameters().add(symbol_59);
			
			symbol_351.setOwnedTemplateSignature(symbol_58);
			symbol_351.setName("collect");
			//symbol_351.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_351.setType(symbol_123);  // ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_352 = PivotFactory.eINSTANCE.createParameter();
			symbol_352.setName("i");
			symbol_352.setType(symbol_57);  // ocl!NonOrderedCollection{T}?T
			symbol_351.getOwnedIterators().add(symbol_352);
			Parameter symbol_353 = PivotFactory.eINSTANCE.createParameter();
			symbol_353.setName("body");
			//symbol_353.setMoniker("ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_353.setType(symbol_155);  // Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_351.getOwnedParameters().add(symbol_353);
			symbol_351.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_351);
		}
		{	// ocl::NonOrderedCollection::collectNested() ocl!NonOrderedCollection{T}!collectNested(T)
			Iteration symbol_354 = PivotFactory.eINSTANCE.createIteration();
			symbol_354.setName("collectNested");
			//symbol_354.setMoniker("ocl!NonOrderedCollection{T}!collectNested(T)");
			symbol_354.setType(symbol_120);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			
			Parameter symbol_355 = PivotFactory.eINSTANCE.createParameter();
			symbol_355.setName("i");
			symbol_355.setType(symbol_57);  // ocl!NonOrderedCollection{T}?T
			symbol_354.getOwnedIterators().add(symbol_355);
			symbol_354.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_354);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])
			Operation symbol_356 = PivotFactory.eINSTANCE.createOperation();
			symbol_356.setName("intersection");
			//symbol_356.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])");
			symbol_356.setType(symbol_120);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_356.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_357 = PivotFactory.eINSTANCE.createParameter();
			symbol_357.setName("bag");
			//symbol_357.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Bag[T])!bag");
			symbol_357.setType(symbol_120);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_357.setLower(BigInteger.valueOf(0));
			
			symbol_356.getOwnedParameters().add(symbol_357);
			symbol_356.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_356);
		}
		{	// ocl::NonOrderedCollection::intersection() ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])
			Operation symbol_358 = PivotFactory.eINSTANCE.createOperation();
			symbol_358.setName("intersection");
			//symbol_358.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])");
			symbol_358.setType(symbol_211);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_358.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_359 = PivotFactory.eINSTANCE.createParameter();
			symbol_359.setName("s");
			//symbol_359.setMoniker("ocl!NonOrderedCollection{T}!intersection(ocl!Set[T])!s");
			symbol_359.setType(symbol_211);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_359.setLower(BigInteger.valueOf(0));
			
			symbol_358.getOwnedParameters().add(symbol_359);
			symbol_358.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_358);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Bag[T])
			Operation symbol_360 = PivotFactory.eINSTANCE.createOperation();
			symbol_360.setName("union");
			//symbol_360.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])");
			symbol_360.setType(symbol_120);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_360.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_361 = PivotFactory.eINSTANCE.createParameter();
			symbol_361.setName("bag");
			//symbol_361.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Bag[T])!bag");
			symbol_361.setType(symbol_120);  // ocl!Bag[ocl!NonOrderedCollection{T}?T]
			symbol_361.setLower(BigInteger.valueOf(0));
			
			symbol_360.getOwnedParameters().add(symbol_361);
			symbol_360.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_360);
		}
		{	// ocl::NonOrderedCollection::union() ocl!NonOrderedCollection{T}!union(ocl!Set[T])
			Operation symbol_362 = PivotFactory.eINSTANCE.createOperation();
			symbol_362.setName("union");
			//symbol_362.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])");
			symbol_362.setType(symbol_211);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_362.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_363 = PivotFactory.eINSTANCE.createParameter();
			symbol_363.setName("s");
			//symbol_363.setMoniker("ocl!NonOrderedCollection{T}!union(ocl!Set[T])!s");
			symbol_363.setType(symbol_211);  // ocl!Set[ocl!NonOrderedCollection{T}?T]
			symbol_363.setLower(BigInteger.valueOf(0));
			
			symbol_362.getOwnedParameters().add(symbol_363);
			symbol_362.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_54.getOwnedOperations().add(symbol_362);
		}
		symbol_1.getOwnedTypes().add(symbol_54);
		//
		// ocl::NonUniqueCollection ocl!NonUniqueCollection{T}
		//
		symbol_61.setName("NonUniqueCollection");
		//symbol_61.setMoniker("ocl!NonUniqueCollection{T}");
		symbol_61.setElementType(symbol_64);
		symbol_64.setName("T");
		symbol_63.setOwnedParameteredElement(symbol_64);
		symbol_62.getOwnedParameters().add(symbol_63);
		
		symbol_61.setOwnedTemplateSignature(symbol_62);
		symbol_61.getSuperClasses().add(symbol_129); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		{	// ocl::NonUniqueCollection::sortedBy() ocl!NonUniqueCollection{T}!sortedBy(T)
			Iteration symbol_364 = PivotFactory.eINSTANCE.createIteration();
			symbol_364.setName("sortedBy");
			//symbol_364.setMoniker("ocl!NonUniqueCollection{T}!sortedBy(T)");
			symbol_364.setType(symbol_199);  // ocl!Sequence[ocl!NonUniqueCollection{T}?T]
			
			Parameter symbol_365 = PivotFactory.eINSTANCE.createParameter();
			symbol_365.setName("i");
			symbol_365.setType(symbol_64);  // ocl!NonUniqueCollection{T}?T
			symbol_364.getOwnedIterators().add(symbol_365);
			symbol_364.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_61.getOwnedOperations().add(symbol_364);
		}
		symbol_1.getOwnedTypes().add(symbol_61);
		//
		// ocl::OclAny ocl!OclAny
		//
		symbol_65.setName("OclAny");
		//symbol_65.setMoniker("ocl!OclAny");
		{	// ocl::OclAny::<>() ocl!OclAny!<>(ocl!OclAny)
			Operation symbol_366 = PivotFactory.eINSTANCE.createOperation();
			symbol_366.setName("<>");
			//symbol_366.setMoniker("ocl!OclAny!<>(ocl!OclAny)");
			symbol_366.setType(symbol_19);  // Boolean
			symbol_366.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_367 = PivotFactory.eINSTANCE.createParameter();
			symbol_367.setName("object2");
			//symbol_367.setMoniker("ocl!OclAny!<>(ocl!OclAny)!object2");
			symbol_367.setType(symbol_65);  // ocl!OclAny
			symbol_367.setLower(BigInteger.valueOf(0));
			
			symbol_366.getOwnedParameters().add(symbol_367);
			symbol_366.setPrecedence(symbol_7);
			symbol_366.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_366);
		}
		{	// ocl::OclAny::=() ocl!OclAny!=(ocl!OclAny)
			Operation symbol_368 = PivotFactory.eINSTANCE.createOperation();
			symbol_368.setName("=");
			//symbol_368.setMoniker("ocl!OclAny!=(ocl!OclAny)");
			symbol_368.setType(symbol_19);  // Boolean
			symbol_368.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_369 = PivotFactory.eINSTANCE.createParameter();
			symbol_369.setName("object2");
			//symbol_369.setMoniker("ocl!OclAny!=(ocl!OclAny)!object2");
			symbol_369.setType(symbol_65);  // ocl!OclAny
			symbol_369.setLower(BigInteger.valueOf(0));
			
			symbol_368.getOwnedParameters().add(symbol_369);
			symbol_368.setPrecedence(symbol_7);
			symbol_368.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_368);
		}
		{	// ocl::OclAny::oclAsSet() ocl!OclAny!oclAsSet{OclSelf}()
			Operation symbol_370 = PivotFactory.eINSTANCE.createOperation();
			symbol_68.setName("OclSelf");
			symbol_67.setOwnedParameteredElement(symbol_68);
			symbol_66.getOwnedParameters().add(symbol_67);
			
			symbol_370.setOwnedTemplateSignature(symbol_66);
			symbol_370.setName("oclAsSet");
			//symbol_370.setMoniker("ocl!OclAny!oclAsSet{OclSelf}()");
			symbol_370.setType(symbol_212);  // ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
			symbol_370.setLower(BigInteger.valueOf(0));
			
			symbol_370.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_370);
		}
		{	// ocl::OclAny::oclAsType() ocl!OclAny!oclAsType{T}(ocl!Classifier)
			Operation symbol_371 = PivotFactory.eINSTANCE.createOperation();
			symbol_71.setName("T");
			symbol_70.setOwnedParameteredElement(symbol_71);
			symbol_69.getOwnedParameters().add(symbol_70);
			
			symbol_371.setOwnedTemplateSignature(symbol_69);
			symbol_371.setName("oclAsType");
			//symbol_371.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)");
			symbol_371.setType(symbol_71);  // ocl!OclAny!oclAsType{T}(ocl!Classifier)?T
			symbol_371.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_372 = PivotFactory.eINSTANCE.createParameter();
			symbol_372.setName("type");
			//symbol_372.setMoniker("ocl!OclAny!oclAsType{T}(ocl!Classifier)!type");
			symbol_372.setType(symbol_23);  // ocl!Classifier
			symbol_372.setLower(BigInteger.valueOf(0));
			
			symbol_371.getOwnedParameters().add(symbol_372);
			symbol_371.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_371);
		}
		{	// ocl::OclAny::oclIsInState() ocl!OclAny!oclIsInState(ocl!OclState)
			Operation symbol_373 = PivotFactory.eINSTANCE.createOperation();
			symbol_373.setName("oclIsInState");
			//symbol_373.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)");
			symbol_373.setType(symbol_19);  // Boolean
			symbol_373.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_374 = PivotFactory.eINSTANCE.createParameter();
			symbol_374.setName("statespec");
			//symbol_374.setMoniker("ocl!OclAny!oclIsInState(ocl!OclState)!statespec");
			symbol_374.setType(symbol_77);  // ocl!OclState
			symbol_374.setLower(BigInteger.valueOf(0));
			
			symbol_373.getOwnedParameters().add(symbol_374);
			symbol_373.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_373);
		}
		{	// ocl::OclAny::oclIsInvalid() ocl!OclAny!oclIsInvalid()
			Operation symbol_375 = PivotFactory.eINSTANCE.createOperation();
			symbol_375.setName("oclIsInvalid");
			//symbol_375.setMoniker("ocl!OclAny!oclIsInvalid()");
			symbol_375.setType(symbol_19);  // Boolean
			symbol_375.setLower(BigInteger.valueOf(0));
			
			symbol_375.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_375);
		}
		{	// ocl::OclAny::oclIsKindOf() ocl!OclAny!oclIsKindOf(ocl!Classifier)
			Operation symbol_376 = PivotFactory.eINSTANCE.createOperation();
			symbol_376.setName("oclIsKindOf");
			//symbol_376.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)");
			symbol_376.setType(symbol_19);  // Boolean
			symbol_376.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_377 = PivotFactory.eINSTANCE.createParameter();
			symbol_377.setName("type");
			//symbol_377.setMoniker("ocl!OclAny!oclIsKindOf(ocl!Classifier)!type");
			symbol_377.setType(symbol_23);  // ocl!Classifier
			symbol_377.setLower(BigInteger.valueOf(0));
			
			symbol_376.getOwnedParameters().add(symbol_377);
			symbol_376.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_376);
		}
		{	// ocl::OclAny::oclIsNew() ocl!OclAny!oclIsNew()
			Operation symbol_378 = PivotFactory.eINSTANCE.createOperation();
			symbol_378.setName("oclIsNew");
			//symbol_378.setMoniker("ocl!OclAny!oclIsNew()");
			symbol_378.setType(symbol_19);  // Boolean
			symbol_378.setLower(BigInteger.valueOf(0));
			
			symbol_378.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_378);
		}
		{	// ocl::OclAny::oclIsTypeOf() ocl!OclAny!oclIsTypeOf(ocl!Classifier)
			Operation symbol_379 = PivotFactory.eINSTANCE.createOperation();
			symbol_379.setName("oclIsTypeOf");
			//symbol_379.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)");
			symbol_379.setType(symbol_19);  // Boolean
			symbol_379.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_380 = PivotFactory.eINSTANCE.createParameter();
			symbol_380.setName("type");
			//symbol_380.setMoniker("ocl!OclAny!oclIsTypeOf(ocl!Classifier)!type");
			symbol_380.setType(symbol_23);  // ocl!Classifier
			symbol_380.setLower(BigInteger.valueOf(0));
			
			symbol_379.getOwnedParameters().add(symbol_380);
			symbol_379.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_379);
		}
		{	// ocl::OclAny::oclIsUndefined() ocl!OclAny!oclIsUndefined()
			Operation symbol_381 = PivotFactory.eINSTANCE.createOperation();
			symbol_381.setName("oclIsUndefined");
			//symbol_381.setMoniker("ocl!OclAny!oclIsUndefined()");
			symbol_381.setType(symbol_19);  // Boolean
			symbol_381.setLower(BigInteger.valueOf(0));
			
			symbol_381.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_381);
		}
		{	// ocl::OclAny::oclType() ocl!OclAny!oclType()
			Operation symbol_382 = PivotFactory.eINSTANCE.createOperation();
			symbol_382.setName("oclType");
			//symbol_382.setMoniker("ocl!OclAny!oclType()");
			symbol_382.setType(symbol_23);  // ocl!Classifier
			symbol_382.setLower(BigInteger.valueOf(0));
			
			symbol_382.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
			symbol_65.getOwnedOperations().add(symbol_382);
		}
		symbol_1.getOwnedTypes().add(symbol_65);
		//
		// ocl::OclInvalid ocl!OclInvalid
		//
		symbol_72.setName("OclInvalid");
		//symbol_72.setMoniker("ocl!OclInvalid");
		symbol_72.getSuperClasses().add(symbol_79); // ocl!OclVoid
		{	// ocl::OclInvalid::<>() ocl!OclInvalid!<>(ocl!OclAny)
			Operation symbol_383 = PivotFactory.eINSTANCE.createOperation();
			symbol_383.setName("<>");
			//symbol_383.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)");
			symbol_383.setType(symbol_19);  // Boolean
			symbol_383.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_384 = PivotFactory.eINSTANCE.createParameter();
			symbol_384.setName("object2");
			//symbol_384.setMoniker("ocl!OclInvalid!<>(ocl!OclAny)!object2");
			symbol_384.setType(symbol_65);  // ocl!OclAny
			symbol_384.setLower(BigInteger.valueOf(0));
			
			symbol_383.getOwnedParameters().add(symbol_384);
			symbol_383.setPrecedence(symbol_7);
			symbol_383.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_383);
		}
		{	// ocl::OclInvalid::=() ocl!OclInvalid!=(ocl!OclAny)
			Operation symbol_385 = PivotFactory.eINSTANCE.createOperation();
			symbol_385.setName("=");
			//symbol_385.setMoniker("ocl!OclInvalid!=(ocl!OclAny)");
			symbol_385.setType(symbol_19);  // Boolean
			symbol_385.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_386 = PivotFactory.eINSTANCE.createParameter();
			symbol_386.setName("object2");
			//symbol_386.setMoniker("ocl!OclInvalid!=(ocl!OclAny)!object2");
			symbol_386.setType(symbol_65);  // ocl!OclAny
			symbol_386.setLower(BigInteger.valueOf(0));
			
			symbol_385.getOwnedParameters().add(symbol_386);
			symbol_385.setPrecedence(symbol_7);
			symbol_385.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_385);
		}
		{	// ocl::OclInvalid::allInstances() ocl!OclInvalid!allInstances{OclSelf}()
			Operation symbol_387 = PivotFactory.eINSTANCE.createOperation();
			symbol_75.setName("OclSelf");
			symbol_74.setOwnedParameteredElement(symbol_75);
			symbol_73.getOwnedParameters().add(symbol_74);
			
			symbol_387.setOwnedTemplateSignature(symbol_73);
			symbol_387.setName("allInstances");
			//symbol_387.setMoniker("ocl!OclInvalid!allInstances{OclSelf}()");
			symbol_387.setType(symbol_213);  // ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
			symbol_387.setLower(BigInteger.valueOf(0));
			
			symbol_387.setIsStatic(true);
			symbol_387.setImplementation(org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_387);
		}
		{	// ocl::OclInvalid::toString() ocl!OclInvalid!toString()
			Operation symbol_388 = PivotFactory.eINSTANCE.createOperation();
			symbol_388.setName("toString");
			//symbol_388.setMoniker("ocl!OclInvalid!toString()");
			symbol_388.setType(symbol_112);  // String
			symbol_388.setLower(BigInteger.valueOf(0));
			
			symbol_388.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_72.getOwnedOperations().add(symbol_388);
		}
		symbol_1.getOwnedTypes().add(symbol_72);
		//
		// ocl::OclMessage ocl!OclMessage
		//
		symbol_76.setName("OclMessage");
		//symbol_76.setMoniker("ocl!OclMessage");
		symbol_76.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::OclMessage::hasReturned() ocl!OclMessage!hasReturned()
			Operation symbol_389 = PivotFactory.eINSTANCE.createOperation();
			symbol_389.setName("hasReturned");
			//symbol_389.setMoniker("ocl!OclMessage!hasReturned()");
			symbol_389.setType(symbol_19);  // Boolean
			symbol_389.setLower(BigInteger.valueOf(0));
			
			symbol_389.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_389);
		}
		{	// ocl::OclMessage::isOperationCall() ocl!OclMessage!isOperationCall()
			Operation symbol_390 = PivotFactory.eINSTANCE.createOperation();
			symbol_390.setName("isOperationCall");
			//symbol_390.setMoniker("ocl!OclMessage!isOperationCall()");
			symbol_390.setType(symbol_19);  // Boolean
			symbol_390.setLower(BigInteger.valueOf(0));
			
			symbol_390.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_390);
		}
		{	// ocl::OclMessage::isSignalSent() ocl!OclMessage!isSignalSent()
			Operation symbol_391 = PivotFactory.eINSTANCE.createOperation();
			symbol_391.setName("isSignalSent");
			//symbol_391.setMoniker("ocl!OclMessage!isSignalSent()");
			symbol_391.setType(symbol_19);  // Boolean
			symbol_391.setLower(BigInteger.valueOf(0));
			
			symbol_391.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_391);
		}
		{	// ocl::OclMessage::result() ocl!OclMessage!result()
			Operation symbol_392 = PivotFactory.eINSTANCE.createOperation();
			symbol_392.setName("result");
			//symbol_392.setMoniker("ocl!OclMessage!result()");
			symbol_392.setType(symbol_65);  // ocl!OclAny
			symbol_392.setLower(BigInteger.valueOf(0));
			
			symbol_392.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
			symbol_76.getOwnedOperations().add(symbol_392);
		}
		symbol_1.getOwnedTypes().add(symbol_76);
		//
		// ocl::OclState ocl!OclState
		//
		symbol_77.setName("OclState");
		//symbol_77.setMoniker("ocl!OclState");
		symbol_77.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_1.getOwnedTypes().add(symbol_77);
		//
		// ocl::OclTuple ocl!OclTuple
		//
		symbol_78.setName("OclTuple");
		//symbol_78.setMoniker("ocl!OclTuple");
		symbol_78.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::OclTuple::<>() ocl!OclTuple!<>(ocl!OclAny)
			Operation symbol_393 = PivotFactory.eINSTANCE.createOperation();
			symbol_393.setName("<>");
			//symbol_393.setMoniker("ocl!OclTuple!<>(ocl!OclAny)");
			symbol_393.setType(symbol_19);  // Boolean
			symbol_393.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_394 = PivotFactory.eINSTANCE.createParameter();
			symbol_394.setName("object2");
			//symbol_394.setMoniker("ocl!OclTuple!<>(ocl!OclAny)!object2");
			symbol_394.setType(symbol_65);  // ocl!OclAny
			symbol_394.setLower(BigInteger.valueOf(0));
			
			symbol_393.getOwnedParameters().add(symbol_394);
			symbol_393.setPrecedence(symbol_7);
			symbol_393.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_393);
		}
		{	// ocl::OclTuple::=() ocl!OclTuple!=(ocl!OclAny)
			Operation symbol_395 = PivotFactory.eINSTANCE.createOperation();
			symbol_395.setName("=");
			//symbol_395.setMoniker("ocl!OclTuple!=(ocl!OclAny)");
			symbol_395.setType(symbol_19);  // Boolean
			symbol_395.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_396 = PivotFactory.eINSTANCE.createParameter();
			symbol_396.setName("object2");
			//symbol_396.setMoniker("ocl!OclTuple!=(ocl!OclAny)!object2");
			symbol_396.setType(symbol_65);  // ocl!OclAny
			symbol_396.setLower(BigInteger.valueOf(0));
			
			symbol_395.getOwnedParameters().add(symbol_396);
			symbol_395.setPrecedence(symbol_7);
			symbol_395.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_78.getOwnedOperations().add(symbol_395);
		}
		symbol_1.getOwnedTypes().add(symbol_78);
		//
		// ocl::OclVoid ocl!OclVoid
		//
		symbol_79.setName("OclVoid");
		//symbol_79.setMoniker("ocl!OclVoid");
		symbol_79.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::OclVoid::<>() ocl!OclVoid!<>(ocl!OclAny)
			Operation symbol_397 = PivotFactory.eINSTANCE.createOperation();
			symbol_397.setName("<>");
			//symbol_397.setMoniker("ocl!OclVoid!<>(ocl!OclAny)");
			symbol_397.setType(symbol_19);  // Boolean
			symbol_397.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_398 = PivotFactory.eINSTANCE.createParameter();
			symbol_398.setName("object2");
			//symbol_398.setMoniker("ocl!OclVoid!<>(ocl!OclAny)!object2");
			symbol_398.setType(symbol_65);  // ocl!OclAny
			symbol_398.setLower(BigInteger.valueOf(0));
			
			symbol_397.getOwnedParameters().add(symbol_398);
			symbol_397.setPrecedence(symbol_7);
			symbol_397.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_397);
		}
		{	// ocl::OclVoid::=() ocl!OclVoid!=(ocl!OclAny)
			Operation symbol_399 = PivotFactory.eINSTANCE.createOperation();
			symbol_399.setName("=");
			//symbol_399.setMoniker("ocl!OclVoid!=(ocl!OclAny)");
			symbol_399.setType(symbol_19);  // Boolean
			symbol_399.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_400 = PivotFactory.eINSTANCE.createParameter();
			symbol_400.setName("object2");
			//symbol_400.setMoniker("ocl!OclVoid!=(ocl!OclAny)!object2");
			symbol_400.setType(symbol_65);  // ocl!OclAny
			symbol_400.setLower(BigInteger.valueOf(0));
			
			symbol_399.getOwnedParameters().add(symbol_400);
			symbol_399.setPrecedence(symbol_7);
			symbol_399.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_399);
		}
		{	// ocl::OclVoid::allInstances() ocl!OclVoid!allInstances{OclSelf}()
			Operation symbol_401 = PivotFactory.eINSTANCE.createOperation();
			symbol_82.setName("OclSelf");
			symbol_81.setOwnedParameteredElement(symbol_82);
			symbol_80.getOwnedParameters().add(symbol_81);
			
			symbol_401.setOwnedTemplateSignature(symbol_80);
			symbol_401.setName("allInstances");
			//symbol_401.setMoniker("ocl!OclVoid!allInstances{OclSelf}()");
			symbol_401.setType(symbol_206);  // ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
			symbol_401.setLower(BigInteger.valueOf(0));
			
			symbol_401.setIsStatic(true);
			symbol_401.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_401);
		}
		{	// ocl::OclVoid::and() ocl!OclVoid!and(Boolean)
			Operation symbol_402 = PivotFactory.eINSTANCE.createOperation();
			symbol_402.setName("and");
			//symbol_402.setMoniker("ocl!OclVoid!and(Boolean)");
			symbol_402.setType(symbol_19);  // Boolean
			symbol_402.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_403 = PivotFactory.eINSTANCE.createParameter();
			symbol_403.setName("b");
			//symbol_403.setMoniker("ocl!OclVoid!and(Boolean)!b");
			symbol_403.setType(symbol_19);  // Boolean
			symbol_403.setLower(BigInteger.valueOf(0));
			
			symbol_402.getOwnedParameters().add(symbol_403);
			symbol_402.setPrecedence(symbol_8);
			symbol_402.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_402);
		}
		{	// ocl::OclVoid::implies() ocl!OclVoid!implies(Boolean)
			Operation symbol_404 = PivotFactory.eINSTANCE.createOperation();
			symbol_404.setName("implies");
			//symbol_404.setMoniker("ocl!OclVoid!implies(Boolean)");
			symbol_404.setType(symbol_19);  // Boolean
			symbol_404.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_405 = PivotFactory.eINSTANCE.createParameter();
			symbol_405.setName("b");
			//symbol_405.setMoniker("ocl!OclVoid!implies(Boolean)!b");
			symbol_405.setType(symbol_19);  // Boolean
			symbol_405.setLower(BigInteger.valueOf(0));
			
			symbol_404.getOwnedParameters().add(symbol_405);
			symbol_404.setPrecedence(symbol_11);
			symbol_404.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_404);
		}
		{	// ocl::OclVoid::or() ocl!OclVoid!or(Boolean)
			Operation symbol_406 = PivotFactory.eINSTANCE.createOperation();
			symbol_406.setName("or");
			//symbol_406.setMoniker("ocl!OclVoid!or(Boolean)");
			symbol_406.setType(symbol_19);  // Boolean
			symbol_406.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_407 = PivotFactory.eINSTANCE.createParameter();
			symbol_407.setName("b");
			//symbol_407.setMoniker("ocl!OclVoid!or(Boolean)!b");
			symbol_407.setType(symbol_19);  // Boolean
			symbol_407.setLower(BigInteger.valueOf(0));
			
			symbol_406.getOwnedParameters().add(symbol_407);
			symbol_406.setPrecedence(symbol_9);
			symbol_406.setImplementation(org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_406);
		}
		{	// ocl::OclVoid::toString() ocl!OclVoid!toString()
			Operation symbol_408 = PivotFactory.eINSTANCE.createOperation();
			symbol_408.setName("toString");
			//symbol_408.setMoniker("ocl!OclVoid!toString()");
			symbol_408.setType(symbol_112);  // String
			symbol_408.setLower(BigInteger.valueOf(0));
			
			symbol_408.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_79.getOwnedOperations().add(symbol_408);
		}
		symbol_1.getOwnedTypes().add(symbol_79);
		//
		// ocl::OrderedCollection ocl!OrderedCollection{T}
		//
		symbol_83.setName("OrderedCollection");
		//symbol_83.setMoniker("ocl!OrderedCollection{T}");
		symbol_83.setElementType(symbol_86);
		symbol_86.setName("T");
		symbol_85.setOwnedParameteredElement(symbol_86);
		symbol_84.getOwnedParameters().add(symbol_85);
		
		symbol_83.setOwnedTemplateSignature(symbol_84);
		symbol_83.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!OrderedCollection{T}?T]
		{	// ocl::OrderedCollection::at() ocl!OrderedCollection{T}!at(Integer)
			Operation symbol_409 = PivotFactory.eINSTANCE.createOperation();
			symbol_409.setName("at");
			//symbol_409.setMoniker("ocl!OrderedCollection{T}!at(Integer)");
			symbol_409.setType(symbol_86);  // ocl!OrderedCollection{T}?T
			symbol_409.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_410 = PivotFactory.eINSTANCE.createParameter();
			symbol_410.setName("index");
			//symbol_410.setMoniker("ocl!OrderedCollection{T}!at(Integer)!index");
			symbol_410.setType(symbol_53);  // Integer
			symbol_410.setLower(BigInteger.valueOf(0));
			
			symbol_409.getOwnedParameters().add(symbol_410);
			symbol_409.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_409);
		}
		{	// ocl::OrderedCollection::closure() ocl!OrderedCollection{T}!closure(T)
			Iteration symbol_411 = PivotFactory.eINSTANCE.createIteration();
			symbol_411.setName("closure");
			//symbol_411.setMoniker("ocl!OrderedCollection{T}!closure(T)");
			symbol_411.setType(symbol_195);  // ocl!OrderedSet[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_412 = PivotFactory.eINSTANCE.createParameter();
			symbol_412.setName("i");
			symbol_412.setType(symbol_86);  // ocl!OrderedCollection{T}?T
			symbol_411.getOwnedIterators().add(symbol_412);
			symbol_411.setImplementation(org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_411);
		}
		{	// ocl::OrderedCollection::collect() ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)
			Iteration symbol_413 = PivotFactory.eINSTANCE.createIteration();
			symbol_89.setName("V");
			symbol_88.setOwnedParameteredElement(symbol_89);
			symbol_87.getOwnedParameters().add(symbol_88);
			
			symbol_413.setOwnedTemplateSignature(symbol_87);
			symbol_413.setName("collect");
			//symbol_413.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)");
			symbol_413.setType(symbol_201);  // ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
			
			Parameter symbol_414 = PivotFactory.eINSTANCE.createParameter();
			symbol_414.setName("i");
			symbol_414.setType(symbol_86);  // ocl!OrderedCollection{T}?T
			symbol_413.getOwnedIterators().add(symbol_414);
			Parameter symbol_415 = PivotFactory.eINSTANCE.createParameter();
			symbol_415.setName("body");
			//symbol_415.setMoniker("ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)!body");
			symbol_415.setType(symbol_154);  // Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
			
			symbol_413.getOwnedParameters().add(symbol_415);
			symbol_413.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_413);
		}
		{	// ocl::OrderedCollection::collectNested() ocl!OrderedCollection{T}!collectNested(T)
			Iteration symbol_416 = PivotFactory.eINSTANCE.createIteration();
			symbol_416.setName("collectNested");
			//symbol_416.setMoniker("ocl!OrderedCollection{T}!collectNested(T)");
			symbol_416.setType(symbol_197);  // ocl!Sequence[ocl!OrderedCollection{T}?T]
			
			Parameter symbol_417 = PivotFactory.eINSTANCE.createParameter();
			symbol_417.setName("i");
			symbol_417.setType(symbol_86);  // ocl!OrderedCollection{T}?T
			symbol_416.getOwnedIterators().add(symbol_417);
			symbol_416.setImplementation(org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_416);
		}
		{	// ocl::OrderedCollection::first() ocl!OrderedCollection{T}!first()
			Operation symbol_418 = PivotFactory.eINSTANCE.createOperation();
			symbol_418.setName("first");
			//symbol_418.setMoniker("ocl!OrderedCollection{T}!first()");
			symbol_418.setType(symbol_86);  // ocl!OrderedCollection{T}?T
			symbol_418.setLower(BigInteger.valueOf(0));
			
			symbol_418.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_418);
		}
		{	// ocl::OrderedCollection::indexOf() ocl!OrderedCollection{T}!indexOf(ocl!OclAny)
			Operation symbol_419 = PivotFactory.eINSTANCE.createOperation();
			symbol_419.setName("indexOf");
			//symbol_419.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)");
			symbol_419.setType(symbol_53);  // Integer
			symbol_419.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_420 = PivotFactory.eINSTANCE.createParameter();
			symbol_420.setName("obj");
			//symbol_420.setMoniker("ocl!OrderedCollection{T}!indexOf(ocl!OclAny)!obj");
			symbol_420.setType(symbol_65);  // ocl!OclAny
			symbol_420.setLower(BigInteger.valueOf(0));
			
			symbol_419.getOwnedParameters().add(symbol_420);
			symbol_419.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_419);
		}
		{	// ocl::OrderedCollection::last() ocl!OrderedCollection{T}!last()
			Operation symbol_421 = PivotFactory.eINSTANCE.createOperation();
			symbol_421.setName("last");
			//symbol_421.setMoniker("ocl!OrderedCollection{T}!last()");
			symbol_421.setType(symbol_86);  // ocl!OrderedCollection{T}?T
			symbol_421.setLower(BigInteger.valueOf(0));
			
			symbol_421.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_421);
		}
		{	// ocl::OrderedCollection::reverse() ocl!OrderedCollection{T}!reverse()
			Operation symbol_422 = PivotFactory.eINSTANCE.createOperation();
			symbol_422.setName("reverse");
			//symbol_422.setMoniker("ocl!OrderedCollection{T}!reverse()");
			symbol_422.setType(symbol_186);  // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
			symbol_422.setLower(BigInteger.valueOf(0));
			
			symbol_422.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_83.getOwnedOperations().add(symbol_422);
		}
		symbol_1.getOwnedTypes().add(symbol_83);
		//
		// ocl::OrderedSet ocl!OrderedSet{T}
		//
		symbol_90.setName("OrderedSet");
		//symbol_90.setMoniker("ocl!OrderedSet{T}");
		symbol_90.setElementType(symbol_93);
		symbol_93.setName("T");
		symbol_92.setOwnedParameteredElement(symbol_93);
		symbol_91.getOwnedParameters().add(symbol_92);
		
		symbol_90.setOwnedTemplateSignature(symbol_91);
		symbol_90.getSuperClasses().add(symbol_184); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_90.getSuperClasses().add(symbol_234); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		{	// ocl::OrderedSet::-() ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_423 = PivotFactory.eINSTANCE.createOperation();
			symbol_423.setName("-");
			//symbol_423.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])");
			symbol_423.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_423.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_424 = PivotFactory.eINSTANCE.createParameter();
			symbol_424.setName("s");
			//symbol_424.setMoniker("ocl!OrderedSet{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_424.setType(symbol_210);  // ocl!Set[ocl!OclAny]
			symbol_424.setLower(BigInteger.valueOf(0));
			
			symbol_423.getOwnedParameters().add(symbol_424);
			symbol_423.setPrecedence(symbol_5);
			symbol_423.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_423);
		}
		{	// ocl::OrderedSet::<>() ocl!OrderedSet{T}!<>(ocl!OclAny)
			Operation symbol_425 = PivotFactory.eINSTANCE.createOperation();
			symbol_425.setName("<>");
			//symbol_425.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)");
			symbol_425.setType(symbol_19);  // Boolean
			symbol_425.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_426 = PivotFactory.eINSTANCE.createParameter();
			symbol_426.setName("object2");
			//symbol_426.setMoniker("ocl!OrderedSet{T}!<>(ocl!OclAny)!object2");
			symbol_426.setType(symbol_65);  // ocl!OclAny
			symbol_426.setLower(BigInteger.valueOf(0));
			
			symbol_425.getOwnedParameters().add(symbol_426);
			symbol_425.setPrecedence(symbol_7);
			symbol_425.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_425);
		}
		{	// ocl::OrderedSet::=() ocl!OrderedSet{T}!=(ocl!OclAny)
			Operation symbol_427 = PivotFactory.eINSTANCE.createOperation();
			symbol_427.setName("=");
			//symbol_427.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)");
			symbol_427.setType(symbol_19);  // Boolean
			symbol_427.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_428 = PivotFactory.eINSTANCE.createParameter();
			symbol_428.setName("object2");
			//symbol_428.setMoniker("ocl!OrderedSet{T}!=(ocl!OclAny)!object2");
			symbol_428.setType(symbol_65);  // ocl!OclAny
			symbol_428.setLower(BigInteger.valueOf(0));
			
			symbol_427.getOwnedParameters().add(symbol_428);
			symbol_427.setPrecedence(symbol_7);
			symbol_427.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_427);
		}
		{	// ocl::OrderedSet::append() ocl!OrderedSet{T}!append(T)
			Operation symbol_429 = PivotFactory.eINSTANCE.createOperation();
			symbol_429.setName("append");
			//symbol_429.setMoniker("ocl!OrderedSet{T}!append(T)");
			symbol_429.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_429.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_430 = PivotFactory.eINSTANCE.createParameter();
			symbol_430.setName("object");
			//symbol_430.setMoniker("ocl!OrderedSet{T}!append(T)!object");
			symbol_430.setType(symbol_93);  // ocl!OrderedSet{T}?T
			symbol_430.setLower(BigInteger.valueOf(0));
			
			symbol_429.getOwnedParameters().add(symbol_430);
			symbol_429.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_429);
		}
		{	// ocl::OrderedSet::excluding() ocl!OrderedSet{T}!excluding(ocl!OclAny)
			Operation symbol_431 = PivotFactory.eINSTANCE.createOperation();
			symbol_431.setName("excluding");
			//symbol_431.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)");
			symbol_431.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_431.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_432 = PivotFactory.eINSTANCE.createParameter();
			symbol_432.setName("object");
			//symbol_432.setMoniker("ocl!OrderedSet{T}!excluding(ocl!OclAny)!object");
			symbol_432.setType(symbol_65);  // ocl!OclAny
			symbol_432.setLower(BigInteger.valueOf(0));
			
			symbol_431.getOwnedParameters().add(symbol_432);
			symbol_431.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_431);
		}
		{	// ocl::OrderedSet::including() ocl!OrderedSet{T}!including(T)
			Operation symbol_433 = PivotFactory.eINSTANCE.createOperation();
			symbol_433.setName("including");
			//symbol_433.setMoniker("ocl!OrderedSet{T}!including(T)");
			symbol_433.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_433.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_434 = PivotFactory.eINSTANCE.createParameter();
			symbol_434.setName("object");
			//symbol_434.setMoniker("ocl!OrderedSet{T}!including(T)!object");
			symbol_434.setType(symbol_93);  // ocl!OrderedSet{T}?T
			symbol_434.setLower(BigInteger.valueOf(0));
			
			symbol_433.getOwnedParameters().add(symbol_434);
			symbol_433.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_433);
		}
		{	// ocl::OrderedSet::insertAt() ocl!OrderedSet{T}!insertAt(Integer,T)
			Operation symbol_435 = PivotFactory.eINSTANCE.createOperation();
			symbol_435.setName("insertAt");
			//symbol_435.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)");
			symbol_435.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_435.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_436 = PivotFactory.eINSTANCE.createParameter();
			symbol_436.setName("index");
			//symbol_436.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!index");
			symbol_436.setType(symbol_53);  // Integer
			symbol_436.setLower(BigInteger.valueOf(0));
			
			symbol_435.getOwnedParameters().add(symbol_436);
			Parameter symbol_437 = PivotFactory.eINSTANCE.createParameter();
			symbol_437.setName("object");
			//symbol_437.setMoniker("ocl!OrderedSet{T}!insertAt(Integer,T)!object");
			symbol_437.setType(symbol_93);  // ocl!OrderedSet{T}?T
			symbol_437.setLower(BigInteger.valueOf(0));
			
			symbol_435.getOwnedParameters().add(symbol_437);
			symbol_435.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_435);
		}
		{	// ocl::OrderedSet::intersection() ocl!OrderedSet{T}!intersection(ocl!Set[T])
			Operation symbol_438 = PivotFactory.eINSTANCE.createOperation();
			symbol_438.setName("intersection");
			//symbol_438.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])");
			symbol_438.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_438.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_439 = PivotFactory.eINSTANCE.createParameter();
			symbol_439.setName("o");
			//symbol_439.setMoniker("ocl!OrderedSet{T}!intersection(ocl!Set[T])!o");
			symbol_439.setType(symbol_205);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_439.setLower(BigInteger.valueOf(0));
			
			symbol_438.getOwnedParameters().add(symbol_439);
			symbol_438.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_438);
		}
		{	// ocl::OrderedSet::prepend() ocl!OrderedSet{T}!prepend(T)
			Operation symbol_440 = PivotFactory.eINSTANCE.createOperation();
			symbol_440.setName("prepend");
			//symbol_440.setMoniker("ocl!OrderedSet{T}!prepend(T)");
			symbol_440.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_440.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_441 = PivotFactory.eINSTANCE.createParameter();
			symbol_441.setName("object");
			//symbol_441.setMoniker("ocl!OrderedSet{T}!prepend(T)!object");
			symbol_441.setType(symbol_93);  // ocl!OrderedSet{T}?T
			symbol_441.setLower(BigInteger.valueOf(0));
			
			symbol_440.getOwnedParameters().add(symbol_441);
			symbol_440.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_440);
		}
		{	// ocl::OrderedSet::reject() ocl!OrderedSet{T}!reject(T)
			Iteration symbol_442 = PivotFactory.eINSTANCE.createIteration();
			symbol_442.setName("reject");
			//symbol_442.setMoniker("ocl!OrderedSet{T}!reject(T)");
			symbol_442.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_443 = PivotFactory.eINSTANCE.createParameter();
			symbol_443.setName("i");
			symbol_443.setType(symbol_93);  // ocl!OrderedSet{T}?T
			symbol_442.getOwnedIterators().add(symbol_443);
			symbol_442.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_442);
		}
		{	// ocl::OrderedSet::reverse() ocl!OrderedSet{T}!reverse()
			Operation symbol_444 = PivotFactory.eINSTANCE.createOperation();
			symbol_444.setName("reverse");
			//symbol_444.setMoniker("ocl!OrderedSet{T}!reverse()");
			symbol_444.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_444.setLower(BigInteger.valueOf(0));
			
			symbol_444.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_444);
		}
		{	// ocl::OrderedSet::select() ocl!OrderedSet{T}!select(T)
			Iteration symbol_445 = PivotFactory.eINSTANCE.createIteration();
			symbol_445.setName("select");
			//symbol_445.setMoniker("ocl!OrderedSet{T}!select(T)");
			symbol_445.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			
			Parameter symbol_446 = PivotFactory.eINSTANCE.createParameter();
			symbol_446.setName("i");
			symbol_446.setType(symbol_93);  // ocl!OrderedSet{T}?T
			symbol_445.getOwnedIterators().add(symbol_446);
			symbol_445.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_445);
		}
		{	// ocl::OrderedSet::subOrderedSet() ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)
			Operation symbol_447 = PivotFactory.eINSTANCE.createOperation();
			symbol_447.setName("subOrderedSet");
			//symbol_447.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)");
			symbol_447.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_447.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_448 = PivotFactory.eINSTANCE.createParameter();
			symbol_448.setName("lower");
			//symbol_448.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!lower");
			symbol_448.setType(symbol_53);  // Integer
			symbol_448.setLower(BigInteger.valueOf(0));
			
			symbol_447.getOwnedParameters().add(symbol_448);
			Parameter symbol_449 = PivotFactory.eINSTANCE.createParameter();
			symbol_449.setName("upper");
			//symbol_449.setMoniker("ocl!OrderedSet{T}!subOrderedSet(Integer,Integer)!upper");
			symbol_449.setType(symbol_53);  // Integer
			symbol_449.setLower(BigInteger.valueOf(0));
			
			symbol_447.getOwnedParameters().add(symbol_449);
			symbol_447.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_447);
		}
		{	// ocl::OrderedSet::symmetricDifference() ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_450 = PivotFactory.eINSTANCE.createOperation();
			symbol_450.setName("symmetricDifference");
			//symbol_450.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_450.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_450.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_451 = PivotFactory.eINSTANCE.createParameter();
			symbol_451.setName("s");
			//symbol_451.setMoniker("ocl!OrderedSet{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_451.setType(symbol_210);  // ocl!Set[ocl!OclAny]
			symbol_451.setLower(BigInteger.valueOf(0));
			
			symbol_450.getOwnedParameters().add(symbol_451);
			symbol_450.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_450);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!OrderedSet[T])
			Operation symbol_452 = PivotFactory.eINSTANCE.createOperation();
			symbol_452.setName("union");
			//symbol_452.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])");
			symbol_452.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_452.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_453 = PivotFactory.eINSTANCE.createParameter();
			symbol_453.setName("o");
			//symbol_453.setMoniker("ocl!OrderedSet{T}!union(ocl!OrderedSet[T])!o");
			symbol_453.setType(symbol_193);  // ocl!OrderedSet[ocl!OrderedSet{T}?T]
			symbol_453.setLower(BigInteger.valueOf(0));
			
			symbol_452.getOwnedParameters().add(symbol_453);
			symbol_452.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_452);
		}
		{	// ocl::OrderedSet::union() ocl!OrderedSet{T}!union(ocl!Set[T])
			Operation symbol_454 = PivotFactory.eINSTANCE.createOperation();
			symbol_454.setName("union");
			//symbol_454.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])");
			symbol_454.setType(symbol_205);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_454.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_455 = PivotFactory.eINSTANCE.createParameter();
			symbol_455.setName("s");
			//symbol_455.setMoniker("ocl!OrderedSet{T}!union(ocl!Set[T])!s");
			symbol_455.setType(symbol_205);  // ocl!Set[ocl!OrderedSet{T}?T]
			symbol_455.setLower(BigInteger.valueOf(0));
			
			symbol_454.getOwnedParameters().add(symbol_455);
			symbol_454.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_90.getOwnedOperations().add(symbol_454);
		}
		symbol_1.getOwnedTypes().add(symbol_90);
		//
		// ocl::Real Real
		//
		symbol_94.setName("Real");
		//symbol_94.setMoniker("Real");
		symbol_94.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::Real::*() Real!*(Real)
			Operation symbol_456 = PivotFactory.eINSTANCE.createOperation();
			symbol_456.setName("*");
			//symbol_456.setMoniker("Real!*(Real)");
			symbol_456.setType(symbol_94);  // Real
			symbol_456.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_457 = PivotFactory.eINSTANCE.createParameter();
			symbol_457.setName("r");
			//symbol_457.setMoniker("Real!*(Real)!r");
			symbol_457.setType(symbol_94);  // Real
			symbol_457.setLower(BigInteger.valueOf(0));
			
			symbol_456.getOwnedParameters().add(symbol_457);
			symbol_456.setPrecedence(symbol_4);
			symbol_456.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_456);
		}
		{	// ocl::Real::+() Real!+(Real)
			Operation symbol_458 = PivotFactory.eINSTANCE.createOperation();
			symbol_458.setName("+");
			//symbol_458.setMoniker("Real!+(Real)");
			symbol_458.setType(symbol_94);  // Real
			symbol_458.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_459 = PivotFactory.eINSTANCE.createParameter();
			symbol_459.setName("r");
			//symbol_459.setMoniker("Real!+(Real)!r");
			symbol_459.setType(symbol_94);  // Real
			symbol_459.setLower(BigInteger.valueOf(0));
			
			symbol_458.getOwnedParameters().add(symbol_459);
			symbol_458.setPrecedence(symbol_5);
			symbol_458.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_458);
		}
		{	// ocl::Real::-() Real!-(Real)
			Operation symbol_460 = PivotFactory.eINSTANCE.createOperation();
			symbol_460.setName("-");
			//symbol_460.setMoniker("Real!-(Real)");
			symbol_460.setType(symbol_94);  // Real
			symbol_460.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_461 = PivotFactory.eINSTANCE.createParameter();
			symbol_461.setName("r");
			//symbol_461.setMoniker("Real!-(Real)!r");
			symbol_461.setType(symbol_94);  // Real
			symbol_461.setLower(BigInteger.valueOf(0));
			
			symbol_460.getOwnedParameters().add(symbol_461);
			symbol_460.setPrecedence(symbol_5);
			symbol_460.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_460);
		}
		{	// ocl::Real::-() Real!-()
			Operation symbol_462 = PivotFactory.eINSTANCE.createOperation();
			symbol_462.setName("-");
			//symbol_462.setMoniker("Real!-()");
			symbol_462.setType(symbol_94);  // Real
			symbol_462.setLower(BigInteger.valueOf(0));
			
			symbol_462.setPrecedence(symbol_3);
			symbol_462.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_462);
		}
		{	// ocl::Real::/() Real!/(Real)
			Operation symbol_463 = PivotFactory.eINSTANCE.createOperation();
			symbol_463.setName("/");
			//symbol_463.setMoniker("Real!/(Real)");
			symbol_463.setType(symbol_94);  // Real
			symbol_463.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_464 = PivotFactory.eINSTANCE.createParameter();
			symbol_464.setName("r");
			//symbol_464.setMoniker("Real!/(Real)!r");
			symbol_464.setType(symbol_94);  // Real
			symbol_464.setLower(BigInteger.valueOf(0));
			
			symbol_463.getOwnedParameters().add(symbol_464);
			symbol_463.setPrecedence(symbol_4);
			symbol_463.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_463);
		}
		{	// ocl::Real::<() Real!<(Real)
			Operation symbol_465 = PivotFactory.eINSTANCE.createOperation();
			symbol_465.setName("<");
			//symbol_465.setMoniker("Real!<(Real)");
			symbol_465.setType(symbol_19);  // Boolean
			symbol_465.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_466 = PivotFactory.eINSTANCE.createParameter();
			symbol_466.setName("r");
			//symbol_466.setMoniker("Real!<(Real)!r");
			symbol_466.setType(symbol_94);  // Real
			symbol_466.setLower(BigInteger.valueOf(0));
			
			symbol_465.getOwnedParameters().add(symbol_466);
			symbol_465.setPrecedence(symbol_6);
			symbol_465.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_465);
		}
		{	// ocl::Real::<=() Real!<=(Real)
			Operation symbol_467 = PivotFactory.eINSTANCE.createOperation();
			symbol_467.setName("<=");
			//symbol_467.setMoniker("Real!<=(Real)");
			symbol_467.setType(symbol_19);  // Boolean
			symbol_467.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_468 = PivotFactory.eINSTANCE.createParameter();
			symbol_468.setName("r");
			//symbol_468.setMoniker("Real!<=(Real)!r");
			symbol_468.setType(symbol_94);  // Real
			symbol_468.setLower(BigInteger.valueOf(0));
			
			symbol_467.getOwnedParameters().add(symbol_468);
			symbol_467.setPrecedence(symbol_6);
			symbol_467.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_467);
		}
		{	// ocl::Real::<>() Real!<>(ocl!OclAny)
			Operation symbol_469 = PivotFactory.eINSTANCE.createOperation();
			symbol_469.setName("<>");
			//symbol_469.setMoniker("Real!<>(ocl!OclAny)");
			symbol_469.setType(symbol_19);  // Boolean
			symbol_469.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_470 = PivotFactory.eINSTANCE.createParameter();
			symbol_470.setName("object2");
			//symbol_470.setMoniker("Real!<>(ocl!OclAny)!object2");
			symbol_470.setType(symbol_65);  // ocl!OclAny
			symbol_470.setLower(BigInteger.valueOf(0));
			
			symbol_469.getOwnedParameters().add(symbol_470);
			symbol_469.setPrecedence(symbol_7);
			symbol_469.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_469);
		}
		{	// ocl::Real::=() Real!=(ocl!OclAny)
			Operation symbol_471 = PivotFactory.eINSTANCE.createOperation();
			symbol_471.setName("=");
			//symbol_471.setMoniker("Real!=(ocl!OclAny)");
			symbol_471.setType(symbol_19);  // Boolean
			symbol_471.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_472 = PivotFactory.eINSTANCE.createParameter();
			symbol_472.setName("object2");
			//symbol_472.setMoniker("Real!=(ocl!OclAny)!object2");
			symbol_472.setType(symbol_65);  // ocl!OclAny
			symbol_472.setLower(BigInteger.valueOf(0));
			
			symbol_471.getOwnedParameters().add(symbol_472);
			symbol_471.setPrecedence(symbol_7);
			symbol_471.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_471);
		}
		{	// ocl::Real::>() Real!>(Real)
			Operation symbol_473 = PivotFactory.eINSTANCE.createOperation();
			symbol_473.setName(">");
			//symbol_473.setMoniker("Real!>(Real)");
			symbol_473.setType(symbol_19);  // Boolean
			symbol_473.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_474 = PivotFactory.eINSTANCE.createParameter();
			symbol_474.setName("r");
			//symbol_474.setMoniker("Real!>(Real)!r");
			symbol_474.setType(symbol_94);  // Real
			symbol_474.setLower(BigInteger.valueOf(0));
			
			symbol_473.getOwnedParameters().add(symbol_474);
			symbol_473.setPrecedence(symbol_6);
			symbol_473.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_473);
		}
		{	// ocl::Real::>=() Real!>=(Real)
			Operation symbol_475 = PivotFactory.eINSTANCE.createOperation();
			symbol_475.setName(">=");
			//symbol_475.setMoniker("Real!>=(Real)");
			symbol_475.setType(symbol_19);  // Boolean
			symbol_475.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_476 = PivotFactory.eINSTANCE.createParameter();
			symbol_476.setName("r");
			//symbol_476.setMoniker("Real!>=(Real)!r");
			symbol_476.setType(symbol_94);  // Real
			symbol_476.setLower(BigInteger.valueOf(0));
			
			symbol_475.getOwnedParameters().add(symbol_476);
			symbol_475.setPrecedence(symbol_6);
			symbol_475.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_475);
		}
		{	// ocl::Real::abs() Real!abs()
			Operation symbol_477 = PivotFactory.eINSTANCE.createOperation();
			symbol_477.setName("abs");
			//symbol_477.setMoniker("Real!abs()");
			symbol_477.setType(symbol_94);  // Real
			symbol_477.setLower(BigInteger.valueOf(0));
			
			symbol_477.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_477);
		}
		{	// ocl::Real::floor() Real!floor()
			Operation symbol_478 = PivotFactory.eINSTANCE.createOperation();
			symbol_478.setName("floor");
			//symbol_478.setMoniker("Real!floor()");
			symbol_478.setType(symbol_53);  // Integer
			symbol_478.setLower(BigInteger.valueOf(0));
			
			symbol_478.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_478);
		}
		{	// ocl::Real::max() Real!max(Real)
			Operation symbol_479 = PivotFactory.eINSTANCE.createOperation();
			symbol_479.setName("max");
			//symbol_479.setMoniker("Real!max(Real)");
			symbol_479.setType(symbol_94);  // Real
			symbol_479.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_480 = PivotFactory.eINSTANCE.createParameter();
			symbol_480.setName("r");
			//symbol_480.setMoniker("Real!max(Real)!r");
			symbol_480.setType(symbol_94);  // Real
			symbol_480.setLower(BigInteger.valueOf(0));
			
			symbol_479.getOwnedParameters().add(symbol_480);
			symbol_479.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_479);
		}
		{	// ocl::Real::min() Real!min(Real)
			Operation symbol_481 = PivotFactory.eINSTANCE.createOperation();
			symbol_481.setName("min");
			//symbol_481.setMoniker("Real!min(Real)");
			symbol_481.setType(symbol_94);  // Real
			symbol_481.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_482 = PivotFactory.eINSTANCE.createParameter();
			symbol_482.setName("r");
			//symbol_482.setMoniker("Real!min(Real)!r");
			symbol_482.setType(symbol_94);  // Real
			symbol_482.setLower(BigInteger.valueOf(0));
			
			symbol_481.getOwnedParameters().add(symbol_482);
			symbol_481.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_481);
		}
		{	// ocl::Real::oclAsType() Real!oclAsType{T}(ocl!Classifier)
			Operation symbol_483 = PivotFactory.eINSTANCE.createOperation();
			symbol_97.setName("T");
			symbol_96.setOwnedParameteredElement(symbol_97);
			symbol_95.getOwnedParameters().add(symbol_96);
			
			symbol_483.setOwnedTemplateSignature(symbol_95);
			symbol_483.setName("oclAsType");
			//symbol_483.setMoniker("Real!oclAsType{T}(ocl!Classifier)");
			symbol_483.setType(symbol_97);  // Real!oclAsType{T}(ocl!Classifier)?T
			symbol_483.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_484 = PivotFactory.eINSTANCE.createParameter();
			symbol_484.setName("type");
			//symbol_484.setMoniker("Real!oclAsType{T}(ocl!Classifier)!type");
			symbol_484.setType(symbol_23);  // ocl!Classifier
			symbol_484.setLower(BigInteger.valueOf(0));
			
			symbol_483.getOwnedParameters().add(symbol_484);
			symbol_483.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericOclAsTypeOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_483);
		}
		{	// ocl::Real::round() Real!round()
			Operation symbol_485 = PivotFactory.eINSTANCE.createOperation();
			symbol_485.setName("round");
			//symbol_485.setMoniker("Real!round()");
			symbol_485.setType(symbol_53);  // Integer
			symbol_485.setLower(BigInteger.valueOf(0));
			
			symbol_485.setImplementation(org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_485);
		}
		{	// ocl::Real::toString() Real!toString()
			Operation symbol_486 = PivotFactory.eINSTANCE.createOperation();
			symbol_486.setName("toString");
			//symbol_486.setMoniker("Real!toString()");
			symbol_486.setType(symbol_112);  // String
			symbol_486.setLower(BigInteger.valueOf(0));
			
			symbol_486.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_94.getOwnedOperations().add(symbol_486);
		}
		symbol_1.getOwnedTypes().add(symbol_94);
		//
		// ocl::Sequence ocl!Sequence{T}
		//
		symbol_98.setName("Sequence");
		//symbol_98.setMoniker("ocl!Sequence{T}");
		symbol_98.setElementType(symbol_101);
		symbol_101.setName("T");
		symbol_100.setOwnedParameteredElement(symbol_101);
		symbol_99.getOwnedParameters().add(symbol_100);
		
		symbol_98.setOwnedTemplateSignature(symbol_99);
		symbol_98.getSuperClasses().add(symbol_179); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_98.getSuperClasses().add(symbol_192); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		{	// ocl::Sequence::<>() ocl!Sequence{T}!<>(ocl!OclAny)
			Operation symbol_487 = PivotFactory.eINSTANCE.createOperation();
			symbol_487.setName("<>");
			//symbol_487.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)");
			symbol_487.setType(symbol_19);  // Boolean
			symbol_487.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_488 = PivotFactory.eINSTANCE.createParameter();
			symbol_488.setName("object2");
			//symbol_488.setMoniker("ocl!Sequence{T}!<>(ocl!OclAny)!object2");
			symbol_488.setType(symbol_65);  // ocl!OclAny
			symbol_488.setLower(BigInteger.valueOf(0));
			
			symbol_487.getOwnedParameters().add(symbol_488);
			symbol_487.setPrecedence(symbol_7);
			symbol_487.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_487);
		}
		{	// ocl::Sequence::=() ocl!Sequence{T}!=(ocl!OclAny)
			Operation symbol_489 = PivotFactory.eINSTANCE.createOperation();
			symbol_489.setName("=");
			//symbol_489.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)");
			symbol_489.setType(symbol_19);  // Boolean
			symbol_489.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_490 = PivotFactory.eINSTANCE.createParameter();
			symbol_490.setName("object2");
			//symbol_490.setMoniker("ocl!Sequence{T}!=(ocl!OclAny)!object2");
			symbol_490.setType(symbol_65);  // ocl!OclAny
			symbol_490.setLower(BigInteger.valueOf(0));
			
			symbol_489.getOwnedParameters().add(symbol_490);
			symbol_489.setPrecedence(symbol_7);
			symbol_489.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_489);
		}
		{	// ocl::Sequence::append() ocl!Sequence{T}!append(T)
			Operation symbol_491 = PivotFactory.eINSTANCE.createOperation();
			symbol_491.setName("append");
			//symbol_491.setMoniker("ocl!Sequence{T}!append(T)");
			symbol_491.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_491.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_492 = PivotFactory.eINSTANCE.createParameter();
			symbol_492.setName("object");
			//symbol_492.setMoniker("ocl!Sequence{T}!append(T)!object");
			symbol_492.setType(symbol_101);  // ocl!Sequence{T}?T
			symbol_492.setLower(BigInteger.valueOf(0));
			
			symbol_491.getOwnedParameters().add(symbol_492);
			symbol_491.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_491);
		}
		{	// ocl::Sequence::excluding() ocl!Sequence{T}!excluding(ocl!OclAny)
			Operation symbol_493 = PivotFactory.eINSTANCE.createOperation();
			symbol_493.setName("excluding");
			//symbol_493.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)");
			symbol_493.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_493.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_494 = PivotFactory.eINSTANCE.createParameter();
			symbol_494.setName("object");
			//symbol_494.setMoniker("ocl!Sequence{T}!excluding(ocl!OclAny)!object");
			symbol_494.setType(symbol_65);  // ocl!OclAny
			symbol_494.setLower(BigInteger.valueOf(0));
			
			symbol_493.getOwnedParameters().add(symbol_494);
			symbol_493.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_493);
		}
		{	// ocl::Sequence::flatten() ocl!Sequence{T}!flatten{T2}()
			Operation symbol_495 = PivotFactory.eINSTANCE.createOperation();
			symbol_104.setName("T2");
			symbol_103.setOwnedParameteredElement(symbol_104);
			symbol_102.getOwnedParameters().add(symbol_103);
			
			symbol_495.setOwnedTemplateSignature(symbol_102);
			symbol_495.setName("flatten");
			//symbol_495.setMoniker("ocl!Sequence{T}!flatten{T2}()");
			symbol_495.setType(symbol_198);  // ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
			symbol_495.setLower(BigInteger.valueOf(0));
			
			symbol_495.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_495);
		}
		{	// ocl::Sequence::including() ocl!Sequence{T}!including(T)
			Operation symbol_496 = PivotFactory.eINSTANCE.createOperation();
			symbol_496.setName("including");
			//symbol_496.setMoniker("ocl!Sequence{T}!including(T)");
			symbol_496.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_496.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_497 = PivotFactory.eINSTANCE.createParameter();
			symbol_497.setName("object");
			//symbol_497.setMoniker("ocl!Sequence{T}!including(T)!object");
			symbol_497.setType(symbol_101);  // ocl!Sequence{T}?T
			symbol_497.setLower(BigInteger.valueOf(0));
			
			symbol_496.getOwnedParameters().add(symbol_497);
			symbol_496.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_496);
		}
		{	// ocl::Sequence::insertAt() ocl!Sequence{T}!insertAt(Integer,T)
			Operation symbol_498 = PivotFactory.eINSTANCE.createOperation();
			symbol_498.setName("insertAt");
			//symbol_498.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)");
			symbol_498.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_498.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_499 = PivotFactory.eINSTANCE.createParameter();
			symbol_499.setName("index");
			//symbol_499.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!index");
			symbol_499.setType(symbol_53);  // Integer
			symbol_499.setLower(BigInteger.valueOf(0));
			
			symbol_498.getOwnedParameters().add(symbol_499);
			Parameter symbol_500 = PivotFactory.eINSTANCE.createParameter();
			symbol_500.setName("object");
			//symbol_500.setMoniker("ocl!Sequence{T}!insertAt(Integer,T)!object");
			symbol_500.setType(symbol_101);  // ocl!Sequence{T}?T
			symbol_500.setLower(BigInteger.valueOf(0));
			
			symbol_498.getOwnedParameters().add(symbol_500);
			symbol_498.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_498);
		}
		{	// ocl::Sequence::prepend() ocl!Sequence{T}!prepend(T)
			Operation symbol_501 = PivotFactory.eINSTANCE.createOperation();
			symbol_501.setName("prepend");
			//symbol_501.setMoniker("ocl!Sequence{T}!prepend(T)");
			symbol_501.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_501.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_502 = PivotFactory.eINSTANCE.createParameter();
			symbol_502.setName("object");
			//symbol_502.setMoniker("ocl!Sequence{T}!prepend(T)!object");
			symbol_502.setType(symbol_101);  // ocl!Sequence{T}?T
			symbol_502.setLower(BigInteger.valueOf(0));
			
			symbol_501.getOwnedParameters().add(symbol_502);
			symbol_501.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_501);
		}
		{	// ocl::Sequence::reject() ocl!Sequence{T}!reject(T)
			Iteration symbol_503 = PivotFactory.eINSTANCE.createIteration();
			symbol_503.setName("reject");
			//symbol_503.setMoniker("ocl!Sequence{T}!reject(T)");
			symbol_503.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_504 = PivotFactory.eINSTANCE.createParameter();
			symbol_504.setName("i");
			symbol_504.setType(symbol_101);  // ocl!Sequence{T}?T
			symbol_503.getOwnedIterators().add(symbol_504);
			symbol_503.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_503);
		}
		{	// ocl::Sequence::reverse() ocl!Sequence{T}!reverse()
			Operation symbol_505 = PivotFactory.eINSTANCE.createOperation();
			symbol_505.setName("reverse");
			//symbol_505.setMoniker("ocl!Sequence{T}!reverse()");
			symbol_505.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_505.setLower(BigInteger.valueOf(0));
			
			symbol_505.setImplementation(org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_505);
		}
		{	// ocl::Sequence::select() ocl!Sequence{T}!select(T)
			Iteration symbol_506 = PivotFactory.eINSTANCE.createIteration();
			symbol_506.setName("select");
			//symbol_506.setMoniker("ocl!Sequence{T}!select(T)");
			symbol_506.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			
			Parameter symbol_507 = PivotFactory.eINSTANCE.createParameter();
			symbol_507.setName("i");
			symbol_507.setType(symbol_101);  // ocl!Sequence{T}?T
			symbol_506.getOwnedIterators().add(symbol_507);
			symbol_506.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_506);
		}
		{	// ocl::Sequence::subSequence() ocl!Sequence{T}!subSequence(Integer,Integer)
			Operation symbol_508 = PivotFactory.eINSTANCE.createOperation();
			symbol_508.setName("subSequence");
			//symbol_508.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)");
			symbol_508.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_508.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_509 = PivotFactory.eINSTANCE.createParameter();
			symbol_509.setName("lower");
			//symbol_509.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!lower");
			symbol_509.setType(symbol_53);  // Integer
			symbol_509.setLower(BigInteger.valueOf(0));
			
			symbol_508.getOwnedParameters().add(symbol_509);
			Parameter symbol_510 = PivotFactory.eINSTANCE.createParameter();
			symbol_510.setName("upper");
			//symbol_510.setMoniker("ocl!Sequence{T}!subSequence(Integer,Integer)!upper");
			symbol_510.setType(symbol_53);  // Integer
			symbol_510.setLower(BigInteger.valueOf(0));
			
			symbol_508.getOwnedParameters().add(symbol_510);
			symbol_508.setImplementation(org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_508);
		}
		{	// ocl::Sequence::union() ocl!Sequence{T}!union(ocl!Sequence[T])
			Operation symbol_511 = PivotFactory.eINSTANCE.createOperation();
			symbol_511.setName("union");
			//symbol_511.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])");
			symbol_511.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_511.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_512 = PivotFactory.eINSTANCE.createParameter();
			symbol_512.setName("s");
			//symbol_512.setMoniker("ocl!Sequence{T}!union(ocl!Sequence[T])!s");
			symbol_512.setType(symbol_200);  // ocl!Sequence[ocl!Sequence{T}?T]
			symbol_512.setLower(BigInteger.valueOf(0));
			
			symbol_511.getOwnedParameters().add(symbol_512);
			symbol_511.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);
			symbol_98.getOwnedOperations().add(symbol_511);
		}
		symbol_1.getOwnedTypes().add(symbol_98);
		//
		// ocl::Set ocl!Set{T}
		//
		symbol_105.setName("Set");
		//symbol_105.setMoniker("ocl!Set{T}");
		symbol_105.setElementType(symbol_108);
		symbol_108.setName("T");
		symbol_107.setOwnedParameteredElement(symbol_108);
		symbol_106.getOwnedParameters().add(symbol_107);
		
		symbol_105.setOwnedTemplateSignature(symbol_106);
		symbol_105.getSuperClasses().add(symbol_233); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_105.getSuperClasses().add(symbol_161); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		{	// ocl::Set::-() ocl!Set{T}!-(ocl!Set[ocl!OclAny])
			Operation symbol_513 = PivotFactory.eINSTANCE.createOperation();
			symbol_513.setName("-");
			//symbol_513.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])");
			symbol_513.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			symbol_513.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_514 = PivotFactory.eINSTANCE.createParameter();
			symbol_514.setName("s");
			//symbol_514.setMoniker("ocl!Set{T}!-(ocl!Set[ocl!OclAny])!s");
			symbol_514.setType(symbol_210);  // ocl!Set[ocl!OclAny]
			symbol_514.setLower(BigInteger.valueOf(0));
			
			symbol_513.getOwnedParameters().add(symbol_514);
			symbol_513.setPrecedence(symbol_5);
			symbol_513.setImplementation(org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_513);
		}
		{	// ocl::Set::<>() ocl!Set{T}!<>(ocl!OclAny)
			Operation symbol_515 = PivotFactory.eINSTANCE.createOperation();
			symbol_515.setName("<>");
			//symbol_515.setMoniker("ocl!Set{T}!<>(ocl!OclAny)");
			symbol_515.setType(symbol_19);  // Boolean
			symbol_515.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_516 = PivotFactory.eINSTANCE.createParameter();
			symbol_516.setName("object2");
			//symbol_516.setMoniker("ocl!Set{T}!<>(ocl!OclAny)!object2");
			symbol_516.setType(symbol_65);  // ocl!OclAny
			symbol_516.setLower(BigInteger.valueOf(0));
			
			symbol_515.getOwnedParameters().add(symbol_516);
			symbol_515.setPrecedence(symbol_7);
			symbol_515.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_515);
		}
		{	// ocl::Set::=() ocl!Set{T}!=(ocl!OclAny)
			Operation symbol_517 = PivotFactory.eINSTANCE.createOperation();
			symbol_517.setName("=");
			//symbol_517.setMoniker("ocl!Set{T}!=(ocl!OclAny)");
			symbol_517.setType(symbol_19);  // Boolean
			symbol_517.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_518 = PivotFactory.eINSTANCE.createParameter();
			symbol_518.setName("object2");
			//symbol_518.setMoniker("ocl!Set{T}!=(ocl!OclAny)!object2");
			symbol_518.setType(symbol_65);  // ocl!OclAny
			symbol_518.setLower(BigInteger.valueOf(0));
			
			symbol_517.getOwnedParameters().add(symbol_518);
			symbol_517.setPrecedence(symbol_7);
			symbol_517.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_517);
		}
		{	// ocl::Set::excluding() ocl!Set{T}!excluding(ocl!OclAny)
			Operation symbol_519 = PivotFactory.eINSTANCE.createOperation();
			symbol_519.setName("excluding");
			//symbol_519.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)");
			symbol_519.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			symbol_519.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_520 = PivotFactory.eINSTANCE.createParameter();
			symbol_520.setName("object");
			//symbol_520.setMoniker("ocl!Set{T}!excluding(ocl!OclAny)!object");
			symbol_520.setType(symbol_65);  // ocl!OclAny
			symbol_520.setLower(BigInteger.valueOf(0));
			
			symbol_519.getOwnedParameters().add(symbol_520);
			symbol_519.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_519);
		}
		{	// ocl::Set::flatten() ocl!Set{T}!flatten{T2}()
			Operation symbol_521 = PivotFactory.eINSTANCE.createOperation();
			symbol_111.setName("T2");
			symbol_110.setOwnedParameteredElement(symbol_111);
			symbol_109.getOwnedParameters().add(symbol_110);
			
			symbol_521.setOwnedTemplateSignature(symbol_109);
			symbol_521.setName("flatten");
			//symbol_521.setMoniker("ocl!Set{T}!flatten{T2}()");
			symbol_521.setType(symbol_207);  // ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
			symbol_521.setLower(BigInteger.valueOf(0));
			
			symbol_521.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_521);
		}
		{	// ocl::Set::including() ocl!Set{T}!including(T)
			Operation symbol_522 = PivotFactory.eINSTANCE.createOperation();
			symbol_522.setName("including");
			//symbol_522.setMoniker("ocl!Set{T}!including(T)");
			symbol_522.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			symbol_522.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_523 = PivotFactory.eINSTANCE.createParameter();
			symbol_523.setName("object");
			//symbol_523.setMoniker("ocl!Set{T}!including(T)!object");
			symbol_523.setType(symbol_108);  // ocl!Set{T}?T
			symbol_523.setLower(BigInteger.valueOf(0));
			
			symbol_522.getOwnedParameters().add(symbol_523);
			symbol_522.setImplementation(org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_522);
		}
		{	// ocl::Set::intersection() ocl!Set{T}!intersection(ocl!Set[T])
			Operation symbol_524 = PivotFactory.eINSTANCE.createOperation();
			symbol_524.setName("intersection");
			//symbol_524.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])");
			symbol_524.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			symbol_524.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_525 = PivotFactory.eINSTANCE.createParameter();
			symbol_525.setName("s");
			//symbol_525.setMoniker("ocl!Set{T}!intersection(ocl!Set[T])!s");
			symbol_525.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			symbol_525.setLower(BigInteger.valueOf(0));
			
			symbol_524.getOwnedParameters().add(symbol_525);
			symbol_524.setImplementation(org.eclipse.ocl.examples.library.collection.UniqueCollectionIntersectionOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_524);
		}
		{	// ocl::Set::reject() ocl!Set{T}!reject(T)
			Iteration symbol_526 = PivotFactory.eINSTANCE.createIteration();
			symbol_526.setName("reject");
			//symbol_526.setMoniker("ocl!Set{T}!reject(T)");
			symbol_526.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_527 = PivotFactory.eINSTANCE.createParameter();
			symbol_527.setName("i");
			symbol_527.setType(symbol_108);  // ocl!Set{T}?T
			symbol_526.getOwnedIterators().add(symbol_527);
			symbol_526.setImplementation(org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_526);
		}
		{	// ocl::Set::select() ocl!Set{T}!select(T)
			Iteration symbol_528 = PivotFactory.eINSTANCE.createIteration();
			symbol_528.setName("select");
			//symbol_528.setMoniker("ocl!Set{T}!select(T)");
			symbol_528.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			
			Parameter symbol_529 = PivotFactory.eINSTANCE.createParameter();
			symbol_529.setName("i");
			symbol_529.setType(symbol_108);  // ocl!Set{T}?T
			symbol_528.getOwnedIterators().add(symbol_529);
			symbol_528.setImplementation(org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_528);
		}
		{	// ocl::Set::symmetricDifference() ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])
			Operation symbol_530 = PivotFactory.eINSTANCE.createOperation();
			symbol_530.setName("symmetricDifference");
			//symbol_530.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])");
			symbol_530.setType(symbol_209);  // ocl!Set[ocl!Set{T}?T]
			symbol_530.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_531 = PivotFactory.eINSTANCE.createParameter();
			symbol_531.setName("s");
			//symbol_531.setMoniker("ocl!Set{T}!symmetricDifference(ocl!Set[ocl!OclAny])!s");
			symbol_531.setType(symbol_210);  // ocl!Set[ocl!OclAny]
			symbol_531.setLower(BigInteger.valueOf(0));
			
			symbol_530.getOwnedParameters().add(symbol_531);
			symbol_530.setImplementation(org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
			symbol_105.getOwnedOperations().add(symbol_530);
		}
		symbol_1.getOwnedTypes().add(symbol_105);
		//
		// ocl::String String
		//
		symbol_112.setName("String");
		//symbol_112.setMoniker("String");
		symbol_112.getSuperClasses().add(symbol_65); // ocl!OclAny
		{	// ocl::String::+() String!+(String)
			Operation symbol_532 = PivotFactory.eINSTANCE.createOperation();
			symbol_532.setName("+");
			//symbol_532.setMoniker("String!+(String)");
			symbol_532.setType(symbol_112);  // String
			symbol_532.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_533 = PivotFactory.eINSTANCE.createParameter();
			symbol_533.setName("s");
			//symbol_533.setMoniker("String!+(String)!s");
			symbol_533.setType(symbol_112);  // String
			symbol_533.setLower(BigInteger.valueOf(0));
			
			symbol_532.getOwnedParameters().add(symbol_533);
			symbol_532.setPrecedence(symbol_5);
			symbol_532.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_532);
		}
		{	// ocl::String::<() String!<(String)
			Operation symbol_534 = PivotFactory.eINSTANCE.createOperation();
			symbol_534.setName("<");
			//symbol_534.setMoniker("String!<(String)");
			symbol_534.setType(symbol_19);  // Boolean
			symbol_534.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_535 = PivotFactory.eINSTANCE.createParameter();
			symbol_535.setName("s");
			//symbol_535.setMoniker("String!<(String)!s");
			symbol_535.setType(symbol_112);  // String
			symbol_535.setLower(BigInteger.valueOf(0));
			
			symbol_534.getOwnedParameters().add(symbol_535);
			symbol_534.setPrecedence(symbol_6);
			symbol_534.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_534);
		}
		{	// ocl::String::<=() String!<=(String)
			Operation symbol_536 = PivotFactory.eINSTANCE.createOperation();
			symbol_536.setName("<=");
			//symbol_536.setMoniker("String!<=(String)");
			symbol_536.setType(symbol_19);  // Boolean
			symbol_536.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_537 = PivotFactory.eINSTANCE.createParameter();
			symbol_537.setName("s");
			//symbol_537.setMoniker("String!<=(String)!s");
			symbol_537.setType(symbol_112);  // String
			symbol_537.setLower(BigInteger.valueOf(0));
			
			symbol_536.getOwnedParameters().add(symbol_537);
			symbol_536.setPrecedence(symbol_6);
			symbol_536.setImplementation(org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_536);
		}
		{	// ocl::String::<>() String!<>(ocl!OclAny)
			Operation symbol_538 = PivotFactory.eINSTANCE.createOperation();
			symbol_538.setName("<>");
			//symbol_538.setMoniker("String!<>(ocl!OclAny)");
			symbol_538.setType(symbol_19);  // Boolean
			symbol_538.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_539 = PivotFactory.eINSTANCE.createParameter();
			symbol_539.setName("object2");
			//symbol_539.setMoniker("String!<>(ocl!OclAny)!object2");
			symbol_539.setType(symbol_65);  // ocl!OclAny
			symbol_539.setLower(BigInteger.valueOf(0));
			
			symbol_538.getOwnedParameters().add(symbol_539);
			symbol_538.setPrecedence(symbol_7);
			symbol_538.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_538);
		}
		{	// ocl::String::=() String!=(ocl!OclAny)
			Operation symbol_540 = PivotFactory.eINSTANCE.createOperation();
			symbol_540.setName("=");
			//symbol_540.setMoniker("String!=(ocl!OclAny)");
			symbol_540.setType(symbol_19);  // Boolean
			symbol_540.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_541 = PivotFactory.eINSTANCE.createParameter();
			symbol_541.setName("object2");
			//symbol_541.setMoniker("String!=(ocl!OclAny)!object2");
			symbol_541.setType(symbol_65);  // ocl!OclAny
			symbol_541.setLower(BigInteger.valueOf(0));
			
			symbol_540.getOwnedParameters().add(symbol_541);
			symbol_540.setPrecedence(symbol_7);
			symbol_540.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_540);
		}
		{	// ocl::String::>() String!>(String)
			Operation symbol_542 = PivotFactory.eINSTANCE.createOperation();
			symbol_542.setName(">");
			//symbol_542.setMoniker("String!>(String)");
			symbol_542.setType(symbol_19);  // Boolean
			symbol_542.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_543 = PivotFactory.eINSTANCE.createParameter();
			symbol_543.setName("s");
			//symbol_543.setMoniker("String!>(String)!s");
			symbol_543.setType(symbol_112);  // String
			symbol_543.setLower(BigInteger.valueOf(0));
			
			symbol_542.getOwnedParameters().add(symbol_543);
			symbol_542.setPrecedence(symbol_6);
			symbol_542.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_542);
		}
		{	// ocl::String::>=() String!>=(String)
			Operation symbol_544 = PivotFactory.eINSTANCE.createOperation();
			symbol_544.setName(">=");
			//symbol_544.setMoniker("String!>=(String)");
			symbol_544.setType(symbol_19);  // Boolean
			symbol_544.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_545 = PivotFactory.eINSTANCE.createParameter();
			symbol_545.setName("s");
			//symbol_545.setMoniker("String!>=(String)!s");
			symbol_545.setType(symbol_112);  // String
			symbol_545.setLower(BigInteger.valueOf(0));
			
			symbol_544.getOwnedParameters().add(symbol_545);
			symbol_544.setPrecedence(symbol_6);
			symbol_544.setImplementation(org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_544);
		}
		{	// ocl::String::at() String!at(Integer)
			Operation symbol_546 = PivotFactory.eINSTANCE.createOperation();
			symbol_546.setName("at");
			//symbol_546.setMoniker("String!at(Integer)");
			symbol_546.setType(symbol_112);  // String
			symbol_546.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_547 = PivotFactory.eINSTANCE.createParameter();
			symbol_547.setName("i");
			//symbol_547.setMoniker("String!at(Integer)!i");
			symbol_547.setType(symbol_53);  // Integer
			symbol_547.setLower(BigInteger.valueOf(0));
			
			symbol_546.getOwnedParameters().add(symbol_547);
			symbol_546.setImplementation(org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_546);
		}
		{	// ocl::String::characters() String!characters()
			Operation symbol_548 = PivotFactory.eINSTANCE.createOperation();
			symbol_548.setName("characters");
			//symbol_548.setMoniker("String!characters()");
			symbol_548.setType(symbol_203);  // ocl!Sequence[String]
			symbol_548.setLower(BigInteger.valueOf(0));
			
			symbol_548.setImplementation(org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_548);
		}
		{	// ocl::String::concat() String!concat(String)
			Operation symbol_549 = PivotFactory.eINSTANCE.createOperation();
			symbol_549.setName("concat");
			//symbol_549.setMoniker("String!concat(String)");
			symbol_549.setType(symbol_112);  // String
			symbol_549.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_550 = PivotFactory.eINSTANCE.createParameter();
			symbol_550.setName("s");
			//symbol_550.setMoniker("String!concat(String)!s");
			symbol_550.setType(symbol_112);  // String
			symbol_550.setLower(BigInteger.valueOf(0));
			
			symbol_549.getOwnedParameters().add(symbol_550);
			symbol_549.setImplementation(org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_549);
		}
		{	// ocl::String::equalsIgnoreCase() String!equalsIgnoreCase(String)
			Operation symbol_551 = PivotFactory.eINSTANCE.createOperation();
			symbol_551.setName("equalsIgnoreCase");
			//symbol_551.setMoniker("String!equalsIgnoreCase(String)");
			symbol_551.setType(symbol_19);  // Boolean
			symbol_551.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_552 = PivotFactory.eINSTANCE.createParameter();
			symbol_552.setName("s");
			//symbol_552.setMoniker("String!equalsIgnoreCase(String)!s");
			symbol_552.setType(symbol_112);  // String
			symbol_552.setLower(BigInteger.valueOf(0));
			
			symbol_551.getOwnedParameters().add(symbol_552);
			symbol_551.setImplementation(org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_551);
		}
		{	// ocl::String::indexOf() String!indexOf(String)
			Operation symbol_553 = PivotFactory.eINSTANCE.createOperation();
			symbol_553.setName("indexOf");
			//symbol_553.setMoniker("String!indexOf(String)");
			symbol_553.setType(symbol_53);  // Integer
			symbol_553.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_554 = PivotFactory.eINSTANCE.createParameter();
			symbol_554.setName("s");
			//symbol_554.setMoniker("String!indexOf(String)!s");
			symbol_554.setType(symbol_112);  // String
			symbol_554.setLower(BigInteger.valueOf(0));
			
			symbol_553.getOwnedParameters().add(symbol_554);
			symbol_553.setImplementation(org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_553);
		}
		{	// ocl::String::size() String!size()
			Operation symbol_555 = PivotFactory.eINSTANCE.createOperation();
			symbol_555.setName("size");
			//symbol_555.setMoniker("String!size()");
			symbol_555.setType(symbol_53);  // Integer
			symbol_555.setLower(BigInteger.valueOf(0));
			
			symbol_555.setImplementation(org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_555);
		}
		{	// ocl::String::substring() String!substring(Integer,Integer)
			Operation symbol_556 = PivotFactory.eINSTANCE.createOperation();
			symbol_556.setName("substring");
			//symbol_556.setMoniker("String!substring(Integer,Integer)");
			symbol_556.setType(symbol_112);  // String
			symbol_556.setLower(BigInteger.valueOf(0));
			
			Parameter symbol_557 = PivotFactory.eINSTANCE.createParameter();
			symbol_557.setName("lower");
			//symbol_557.setMoniker("String!substring(Integer,Integer)!lower");
			symbol_557.setType(symbol_53);  // Integer
			symbol_557.setLower(BigInteger.valueOf(0));
			
			symbol_556.getOwnedParameters().add(symbol_557);
			Parameter symbol_558 = PivotFactory.eINSTANCE.createParameter();
			symbol_558.setName("upper");
			//symbol_558.setMoniker("String!substring(Integer,Integer)!upper");
			symbol_558.setType(symbol_53);  // Integer
			symbol_558.setLower(BigInteger.valueOf(0));
			
			symbol_556.getOwnedParameters().add(symbol_558);
			symbol_556.setImplementation(org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_556);
		}
		{	// ocl::String::toBoolean() String!toBoolean()
			Operation symbol_559 = PivotFactory.eINSTANCE.createOperation();
			symbol_559.setName("toBoolean");
			//symbol_559.setMoniker("String!toBoolean()");
			symbol_559.setType(symbol_19);  // Boolean
			symbol_559.setLower(BigInteger.valueOf(0));
			
			symbol_559.setImplementation(org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_559);
		}
		{	// ocl::String::toInteger() String!toInteger()
			Operation symbol_560 = PivotFactory.eINSTANCE.createOperation();
			symbol_560.setName("toInteger");
			//symbol_560.setMoniker("String!toInteger()");
			symbol_560.setType(symbol_53);  // Integer
			symbol_560.setLower(BigInteger.valueOf(0));
			
			symbol_560.setImplementation(org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_560);
		}
		{	// ocl::String::toLower() String!toLower()
			Operation symbol_561 = PivotFactory.eINSTANCE.createOperation();
			symbol_561.setName("toLower");
			//symbol_561.setMoniker("String!toLower()");
			symbol_561.setType(symbol_112);  // String
			symbol_561.setLower(BigInteger.valueOf(0));
			
			symbol_561.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_561);
		}
		{	// ocl::String::toLowerCase() String!toLowerCase()
			Operation symbol_562 = PivotFactory.eINSTANCE.createOperation();
			symbol_562.setName("toLowerCase");
			//symbol_562.setMoniker("String!toLowerCase()");
			symbol_562.setType(symbol_112);  // String
			symbol_562.setLower(BigInteger.valueOf(0));
			
			symbol_562.setImplementation(org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_562);
		}
		{	// ocl::String::toReal() String!toReal()
			Operation symbol_563 = PivotFactory.eINSTANCE.createOperation();
			symbol_563.setName("toReal");
			//symbol_563.setMoniker("String!toReal()");
			symbol_563.setType(symbol_94);  // Real
			symbol_563.setLower(BigInteger.valueOf(0));
			
			symbol_563.setImplementation(org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_563);
		}
		{	// ocl::String::toString() String!toString()
			Operation symbol_564 = PivotFactory.eINSTANCE.createOperation();
			symbol_564.setName("toString");
			//symbol_564.setMoniker("String!toString()");
			symbol_564.setType(symbol_112);  // String
			symbol_564.setLower(BigInteger.valueOf(0));
			
			symbol_564.setImplementation(org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_564);
		}
		{	// ocl::String::toUpper() String!toUpper()
			Operation symbol_565 = PivotFactory.eINSTANCE.createOperation();
			symbol_565.setName("toUpper");
			//symbol_565.setMoniker("String!toUpper()");
			symbol_565.setType(symbol_112);  // String
			symbol_565.setLower(BigInteger.valueOf(0));
			
			symbol_565.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_565);
		}
		{	// ocl::String::toUpperCase() String!toUpperCase()
			Operation symbol_566 = PivotFactory.eINSTANCE.createOperation();
			symbol_566.setName("toUpperCase");
			//symbol_566.setMoniker("String!toUpperCase()");
			symbol_566.setType(symbol_112);  // String
			symbol_566.setLower(BigInteger.valueOf(0));
			
			symbol_566.setImplementation(org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
			symbol_112.getOwnedOperations().add(symbol_566);
		}
		symbol_1.getOwnedTypes().add(symbol_112);
		//
		// ocl::UniqueCollection ocl!UniqueCollection{T}
		//
		symbol_113.setName("UniqueCollection");
		//symbol_113.setMoniker("ocl!UniqueCollection{T}");
		symbol_113.setElementType(symbol_116);
		symbol_116.setName("T");
		symbol_115.setOwnedParameteredElement(symbol_116);
		symbol_114.getOwnedParameters().add(symbol_115);
		
		symbol_113.setOwnedTemplateSignature(symbol_114);
		symbol_113.getSuperClasses().add(symbol_127); // ocl!Collection[ocl!UniqueCollection{T}?T]
		{	// ocl::UniqueCollection::sortedBy() ocl!UniqueCollection{T}!sortedBy(T)
			Iteration symbol_567 = PivotFactory.eINSTANCE.createIteration();
			symbol_567.setName("sortedBy");
			//symbol_567.setMoniker("ocl!UniqueCollection{T}!sortedBy(T)");
			symbol_567.setType(symbol_196);  // ocl!OrderedSet[ocl!UniqueCollection{T}?T]
			
			Parameter symbol_568 = PivotFactory.eINSTANCE.createParameter();
			symbol_568.setName("i");
			symbol_568.setType(symbol_116);  // ocl!UniqueCollection{T}?T
			symbol_567.getOwnedIterators().add(symbol_568);
			symbol_567.setImplementation(org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
			symbol_113.getOwnedOperations().add(symbol_567);
		}
		symbol_1.getOwnedTypes().add(symbol_113);
		//
		// ocl::UnlimitedNatural UnlimitedNatural
		//
		symbol_117.setName("UnlimitedNatural");
		//symbol_117.setMoniker("UnlimitedNatural");
		symbol_117.getSuperClasses().add(symbol_53); // Integer
		symbol_1.getOwnedTypes().add(symbol_117);
		//
		// ocl::orphanage
		//
		symbol_118.setName("orphanage");
		symbol_118.setMoniker("orphanage");
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Bag{T}?T]
		//
		symbol_119.setName("Bag");
		//symbol_119.setMoniker("ocl!Bag[ocl!Bag{T}?T]");
		symbol_119.setElementType(symbol_15);
		{
			TemplateBinding symbol_569 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_569.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_570 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_570.setFormal(symbol_14);	
				symbol_570.setActual(symbol_15);	
				symbol_569.getParameterSubstitutions().add(symbol_570);
			}
			symbol_119.getTemplateBindings().add(symbol_569);
		}
		symbol_119.getSuperClasses().add(symbol_173); // ocl!NonUniqueCollection[ocl!Bag{T}?T]
		symbol_119.getSuperClasses().add(symbol_168); // ocl!NonOrderedCollection[ocl!Bag{T}?T]
		symbol_118.getOwnedTypes().add(symbol_119);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}?T]
		//
		symbol_120.setName("Bag");
		//symbol_120.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}?T]");
		symbol_120.setElementType(symbol_57);
		{
			TemplateBinding symbol_571 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_571.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_572 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_572.setFormal(symbol_14);	
				symbol_572.setActual(symbol_57);	
				symbol_571.getParameterSubstitutions().add(symbol_572);
			}
			symbol_120.getTemplateBindings().add(symbol_571);
		}
		symbol_120.getSuperClasses().add(symbol_166); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_120.getSuperClasses().add(symbol_180); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_120);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_121.setName("Bag");
		//symbol_121.setMoniker("ocl!Bag[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_121.setElementType(symbol_18);
		{
			TemplateBinding symbol_573 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_573.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_574 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_574.setFormal(symbol_14);	
				symbol_574.setActual(symbol_18);	
				symbol_573.getParameterSubstitutions().add(symbol_574);
			}
			symbol_121.getTemplateBindings().add(symbol_573);
		}
		symbol_121.getSuperClasses().add(symbol_178); // ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_121.getSuperClasses().add(symbol_160); // ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_121);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!Collection{T}?T]
		//
		symbol_122.setName("Bag");
		//symbol_122.setMoniker("ocl!Bag[ocl!Collection{T}?T]");
		symbol_122.setElementType(symbol_30);
		{
			TemplateBinding symbol_575 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_575.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_576 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_576.setFormal(symbol_14);	
				symbol_576.setActual(symbol_30);	
				symbol_575.getParameterSubstitutions().add(symbol_576);
			}
			symbol_122.getTemplateBindings().add(symbol_575);
		}
		symbol_122.getSuperClasses().add(symbol_157); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_122.getSuperClasses().add(symbol_175); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_122);
		//
		// ocl::orphanage::Bag ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_123.setName("Bag");
		//symbol_123.setMoniker("ocl!Bag[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_123.setElementType(symbol_60);
		{
			TemplateBinding symbol_577 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_577.setSignature(symbol_13);
			{
				TemplateParameterSubstitution symbol_578 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_578.setFormal(symbol_14);	
				symbol_578.setActual(symbol_60);	
				symbol_577.getParameterSubstitutions().add(symbol_578);
			}
			symbol_123.getTemplateBindings().add(symbol_577);
		}
		symbol_123.getSuperClasses().add(symbol_169); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_123.getSuperClasses().add(symbol_181); // ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_118.getOwnedTypes().add(symbol_123);
		//
		// ocl::orphanage::Collection ocl!Collection[String]
		//
		symbol_124.setName("Collection");
		//symbol_124.setMoniker("ocl!Collection[String]");
		symbol_124.setElementType(symbol_112);
		{
			TemplateBinding symbol_579 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_579.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_580 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_580.setFormal(symbol_29);	
				symbol_580.setActual(symbol_112);	
				symbol_579.getParameterSubstitutions().add(symbol_580);
			}
			symbol_124.getTemplateBindings().add(symbol_579);
		}
		symbol_124.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_124);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}?T]
		//
		symbol_125.setName("Collection");
		//symbol_125.setMoniker("ocl!Collection[ocl!OrderedCollection{T}?T]");
		symbol_125.setElementType(symbol_86);
		{
			TemplateBinding symbol_581 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_581.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_582 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_582.setFormal(symbol_29);	
				symbol_582.setActual(symbol_86);	
				symbol_581.getParameterSubstitutions().add(symbol_582);
			}
			symbol_125.getTemplateBindings().add(symbol_581);
		}
		symbol_125.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_125);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Set{T}?T]
		//
		symbol_126.setName("Collection");
		//symbol_126.setMoniker("ocl!Collection[ocl!Set{T}?T]");
		symbol_126.setElementType(symbol_108);
		{
			TemplateBinding symbol_583 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_583.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_584 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_584.setFormal(symbol_29);	
				symbol_584.setActual(symbol_108);	
				symbol_583.getParameterSubstitutions().add(symbol_584);
			}
			symbol_126.getTemplateBindings().add(symbol_583);
		}
		symbol_126.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_126);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!UniqueCollection{T}?T]
		//
		symbol_127.setName("Collection");
		//symbol_127.setMoniker("ocl!Collection[ocl!UniqueCollection{T}?T]");
		symbol_127.setElementType(symbol_116);
		{
			TemplateBinding symbol_585 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_585.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_586 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_586.setFormal(symbol_29);	
				symbol_586.setActual(symbol_116);	
				symbol_585.getParameterSubstitutions().add(symbol_586);
			}
			symbol_127.getTemplateBindings().add(symbol_585);
		}
		symbol_127.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_127);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_128.setName("Collection");
		//symbol_128.setMoniker("ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_128.setElementType(symbol_111);
		{
			TemplateBinding symbol_587 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_587.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_588 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_588.setFormal(symbol_29);	
				symbol_588.setActual(symbol_111);	
				symbol_587.getParameterSubstitutions().add(symbol_588);
			}
			symbol_128.getTemplateBindings().add(symbol_587);
		}
		symbol_128.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_128);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_129.setName("Collection");
		//symbol_129.setMoniker("ocl!Collection[ocl!NonUniqueCollection{T}?T]");
		symbol_129.setElementType(symbol_64);
		{
			TemplateBinding symbol_589 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_589.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_590 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_590.setFormal(symbol_29);	
				symbol_590.setActual(symbol_64);	
				symbol_589.getParameterSubstitutions().add(symbol_590);
			}
			symbol_129.getTemplateBindings().add(symbol_589);
		}
		symbol_129.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_129);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_130.setName("Collection");
		//symbol_130.setMoniker("ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_130.setElementType(symbol_26);
		{
			TemplateBinding symbol_591 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_591.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_592 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_592.setFormal(symbol_29);	
				symbol_592.setActual(symbol_26);	
				symbol_591.getParameterSubstitutions().add(symbol_592);
			}
			symbol_130.getTemplateBindings().add(symbol_591);
		}
		symbol_130.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_130);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_131.setName("Collection");
		//symbol_131.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}?T]");
		symbol_131.setElementType(symbol_57);
		{
			TemplateBinding symbol_593 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_593.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_594 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_594.setFormal(symbol_29);	
				symbol_594.setActual(symbol_57);	
				symbol_593.getParameterSubstitutions().add(symbol_594);
			}
			symbol_131.getTemplateBindings().add(symbol_593);
		}
		symbol_131.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_131);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_132.setName("Collection");
		//symbol_132.setMoniker("ocl!Collection[ocl!Collection{T}!includesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_132.setElementType(symbol_42);
		{
			TemplateBinding symbol_595 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_595.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_596 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_596.setFormal(symbol_29);	
				symbol_596.setActual(symbol_42);	
				symbol_595.getParameterSubstitutions().add(symbol_596);
			}
			symbol_132.getTemplateBindings().add(symbol_595);
		}
		symbol_132.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_132);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Sequence{T}?T]
		//
		symbol_133.setName("Collection");
		//symbol_133.setMoniker("ocl!Collection[ocl!Sequence{T}?T]");
		symbol_133.setElementType(symbol_101);
		{
			TemplateBinding symbol_597 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_597.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_598 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_598.setFormal(symbol_29);	
				symbol_598.setActual(symbol_101);	
				symbol_597.getParameterSubstitutions().add(symbol_598);
			}
			symbol_133.getTemplateBindings().add(symbol_597);
		}
		symbol_133.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_133);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_134.setName("Collection");
		//symbol_134.setMoniker("ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_134.setElementType(symbol_104);
		{
			TemplateBinding symbol_599 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_599.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_600 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_600.setFormal(symbol_29);	
				symbol_600.setActual(symbol_104);	
				symbol_599.getParameterSubstitutions().add(symbol_600);
			}
			symbol_134.getTemplateBindings().add(symbol_599);
		}
		symbol_134.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_134);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_135.setName("Collection");
		//symbol_135.setMoniker("ocl!Collection[ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_135.setElementType(symbol_33);
		{
			TemplateBinding symbol_601 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_601.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_602 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_602.setFormal(symbol_29);	
				symbol_602.setActual(symbol_33);	
				symbol_601.getParameterSubstitutions().add(symbol_602);
			}
			symbol_135.getTemplateBindings().add(symbol_601);
		}
		symbol_135.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_135);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_136.setName("Collection");
		//symbol_136.setMoniker("ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_136.setElementType(symbol_82);
		{
			TemplateBinding symbol_603 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_603.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_604 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_604.setFormal(symbol_29);	
				symbol_604.setActual(symbol_82);	
				symbol_603.getParameterSubstitutions().add(symbol_604);
			}
			symbol_136.getTemplateBindings().add(symbol_603);
		}
		symbol_136.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_136);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclAny]
		//
		symbol_137.setName("Collection");
		//symbol_137.setMoniker("ocl!Collection[ocl!OclAny]");
		symbol_137.setElementType(symbol_65);
		{
			TemplateBinding symbol_605 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_605.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_606 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_606.setFormal(symbol_29);	
				symbol_606.setActual(symbol_65);	
				symbol_605.getParameterSubstitutions().add(symbol_606);
			}
			symbol_137.getTemplateBindings().add(symbol_605);
		}
		symbol_137.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_137);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Classifier]
		//
		symbol_138.setName("Collection");
		//symbol_138.setMoniker("ocl!Collection[ocl!Classifier]");
		symbol_138.setElementType(symbol_23);
		{
			TemplateBinding symbol_607 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_607.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_608 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_608.setFormal(symbol_29);	
				symbol_608.setActual(symbol_23);	
				symbol_607.getParameterSubstitutions().add(symbol_608);
			}
			symbol_138.getTemplateBindings().add(symbol_607);
		}
		symbol_138.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_138);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_139.setName("Collection");
		//symbol_139.setMoniker("ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_139.setElementType(symbol_68);
		{
			TemplateBinding symbol_609 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_609.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_610 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_610.setFormal(symbol_29);	
				symbol_610.setActual(symbol_68);	
				symbol_609.getParameterSubstitutions().add(symbol_610);
			}
			symbol_139.getTemplateBindings().add(symbol_609);
		}
		symbol_139.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_139);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_140.setName("Collection");
		//symbol_140.setMoniker("ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_140.setElementType(symbol_52);
		{
			TemplateBinding symbol_611 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_611.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_612 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_612.setFormal(symbol_29);	
				symbol_612.setActual(symbol_52);	
				symbol_611.getParameterSubstitutions().add(symbol_612);
			}
			symbol_140.getTemplateBindings().add(symbol_611);
		}
		symbol_140.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_140);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]
		//
		symbol_141.setName("Collection");
		//symbol_141.setMoniker("ocl!Collection[ocl!Collection{T}!flatten{T2}()?T2]");
		symbol_141.setElementType(symbol_39);
		{
			TemplateBinding symbol_613 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_613.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_614 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_614.setFormal(symbol_29);	
				symbol_614.setActual(symbol_39);	
				symbol_613.getParameterSubstitutions().add(symbol_614);
			}
			symbol_141.getTemplateBindings().add(symbol_613);
		}
		symbol_141.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_141);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]
		//
		symbol_142.setName("Collection");
		//symbol_142.setMoniker("ocl!Collection[ocl!Collection{T}!excludesAll{T2}(ocl!Collection[T2])?T2]");
		symbol_142.setElementType(symbol_36);
		{
			TemplateBinding symbol_615 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_615.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_616 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_616.setFormal(symbol_29);	
				symbol_616.setActual(symbol_36);	
				symbol_615.getParameterSubstitutions().add(symbol_616);
			}
			symbol_142.getTemplateBindings().add(symbol_615);
		}
		symbol_142.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_142);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}?T]
		//
		symbol_143.setName("Collection");
		//symbol_143.setMoniker("ocl!Collection[ocl!Collection{T}?T]");
		symbol_143.setElementType(symbol_30);
		{
			TemplateBinding symbol_617 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_617.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_618 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_618.setFormal(symbol_29);	
				symbol_618.setActual(symbol_30);	
				symbol_617.getParameterSubstitutions().add(symbol_618);
			}
			symbol_143.getTemplateBindings().add(symbol_617);
		}
		symbol_143.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_143);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]
		//
		symbol_144.setName("Collection");
		//symbol_144.setMoniker("ocl!Collection[ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2]");
		symbol_144.setElementType(symbol_48);
		{
			TemplateBinding symbol_619 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_619.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_620 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_620.setFormal(symbol_29);	
				symbol_620.setActual(symbol_48);	
				symbol_619.getParameterSubstitutions().add(symbol_620);
			}
			symbol_144.getTemplateBindings().add(symbol_619);
		}
		symbol_144.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_144);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_145.setName("Collection");
		//symbol_145.setMoniker("ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_145.setElementType(symbol_18);
		{
			TemplateBinding symbol_621 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_621.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_622 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_622.setFormal(symbol_29);	
				symbol_622.setActual(symbol_18);	
				symbol_621.getParameterSubstitutions().add(symbol_622);
			}
			symbol_145.getTemplateBindings().add(symbol_621);
		}
		symbol_145.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_145);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_146.setName("Collection");
		//symbol_146.setMoniker("ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_146.setElementType(symbol_89);
		{
			TemplateBinding symbol_623 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_623.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_624 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_624.setFormal(symbol_29);	
				symbol_624.setActual(symbol_89);	
				symbol_623.getParameterSubstitutions().add(symbol_624);
			}
			symbol_146.getTemplateBindings().add(symbol_623);
		}
		symbol_146.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_146);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OrderedSet{T}?T]
		//
		symbol_147.setName("Collection");
		//symbol_147.setMoniker("ocl!Collection[ocl!OrderedSet{T}?T]");
		symbol_147.setElementType(symbol_93);
		{
			TemplateBinding symbol_625 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_625.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_626 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_626.setFormal(symbol_29);	
				symbol_626.setActual(symbol_93);	
				symbol_625.getParameterSubstitutions().add(symbol_626);
			}
			symbol_147.getTemplateBindings().add(symbol_625);
		}
		symbol_147.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_147);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_148.setName("Collection");
		//symbol_148.setMoniker("ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_148.setElementType(symbol_60);
		{
			TemplateBinding symbol_627 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_627.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_628 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_628.setFormal(symbol_29);	
				symbol_628.setActual(symbol_60);	
				symbol_627.getParameterSubstitutions().add(symbol_628);
			}
			symbol_148.getTemplateBindings().add(symbol_627);
		}
		symbol_148.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_148);
		//
		// ocl::orphanage::Collection ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_149.setName("Collection");
		//symbol_149.setMoniker("ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_149.setElementType(symbol_22);
		{
			TemplateBinding symbol_629 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_629.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_630 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_630.setFormal(symbol_29);	
				symbol_630.setActual(symbol_22);	
				symbol_629.getParameterSubstitutions().add(symbol_630);
			}
			symbol_149.getTemplateBindings().add(symbol_629);
		}
		symbol_149.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_149);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_150.setName("Collection");
		//symbol_150.setMoniker("ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_150.setElementType(symbol_75);
		{
			TemplateBinding symbol_631 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_631.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_632 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_632.setFormal(symbol_29);	
				symbol_632.setActual(symbol_75);	
				symbol_631.getParameterSubstitutions().add(symbol_632);
			}
			symbol_150.getTemplateBindings().add(symbol_631);
		}
		symbol_150.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_150);
		//
		// ocl::orphanage::Collection ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_151.setName("Collection");
		//symbol_151.setMoniker("ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_151.setElementType(symbol_218);
		{
			TemplateBinding symbol_633 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_633.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_634 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_634.setFormal(symbol_29);	
				symbol_634.setActual(symbol_218);	
				symbol_633.getParameterSubstitutions().add(symbol_634);
			}
			symbol_151.getTemplateBindings().add(symbol_633);
		}
		symbol_151.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_151);
		//
		// ocl::orphanage::Collection ocl!Collection[ocl!Bag{T}?T]
		//
		symbol_152.setName("Collection");
		//symbol_152.setMoniker("ocl!Collection[ocl!Bag{T}?T]");
		symbol_152.setElementType(symbol_15);
		{
			TemplateBinding symbol_635 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_635.setSignature(symbol_28);
			{
				TemplateParameterSubstitution symbol_636 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_636.setFormal(symbol_29);	
				symbol_636.setActual(symbol_15);	
				symbol_635.getParameterSubstitutions().add(symbol_636);
			}
			symbol_152.getTemplateBindings().add(symbol_635);
		}
		symbol_152.getSuperClasses().add(symbol_65); // ocl!OclAny
		symbol_118.getOwnedTypes().add(symbol_152);
		//
		// ocl::orphanage::Lambda Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_153.setName("Lambda");
		//symbol_153.setMoniker("Lambda~ocl!Collection{T}?T()ocl!Collection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_153.setContextType(symbol_30);
		symbol_153.setResultType(symbol_33);
		symbol_118.getOwnedTypes().add(symbol_153);
		//
		// ocl::orphanage::Lambda Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_154.setName("Lambda");
		//symbol_154.setMoniker("Lambda~ocl!OrderedCollection{T}?T()ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_154.setContextType(symbol_86);
		symbol_154.setResultType(symbol_89);
		symbol_118.getOwnedTypes().add(symbol_154);
		//
		// ocl::orphanage::Lambda Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V
		//
		symbol_155.setName("Lambda");
		//symbol_155.setMoniker("Lambda~ocl!NonOrderedCollection{T}?T()ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V");
		symbol_155.setContextType(symbol_57);
		symbol_155.setResultType(symbol_60);
		symbol_118.getOwnedTypes().add(symbol_155);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny]
		//
		symbol_156.setName("NonOrderedCollection");
		//symbol_156.setMoniker("ocl!NonOrderedCollection[ocl!OclAny]");
		symbol_156.setElementType(symbol_65);
		{
			TemplateBinding symbol_637 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_637.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_638 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_638.setFormal(symbol_56);	
				symbol_638.setActual(symbol_65);	
				symbol_637.getParameterSubstitutions().add(symbol_638);
			}
			symbol_156.getTemplateBindings().add(symbol_637);
		}
		symbol_156.getSuperClasses().add(symbol_137); // ocl!Collection[ocl!OclAny]
		symbol_118.getOwnedTypes().add(symbol_156);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Collection{T}?T]
		//
		symbol_157.setName("NonOrderedCollection");
		//symbol_157.setMoniker("ocl!NonOrderedCollection[ocl!Collection{T}?T]");
		symbol_157.setElementType(symbol_30);
		{
			TemplateBinding symbol_639 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_639.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_640 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_640.setFormal(symbol_56);	
				symbol_640.setActual(symbol_30);	
				symbol_639.getParameterSubstitutions().add(symbol_640);
			}
			symbol_157.getTemplateBindings().add(symbol_639);
		}
		symbol_157.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_157);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_158.setName("NonOrderedCollection");
		//symbol_158.setMoniker("ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_158.setElementType(symbol_26);
		{
			TemplateBinding symbol_641 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_641.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_642 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_642.setFormal(symbol_56);	
				symbol_642.setActual(symbol_26);	
				symbol_641.getParameterSubstitutions().add(symbol_642);
			}
			symbol_158.getTemplateBindings().add(symbol_641);
		}
		symbol_158.getSuperClasses().add(symbol_130); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_158);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_159.setName("NonOrderedCollection");
		//symbol_159.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_159.setElementType(symbol_111);
		{
			TemplateBinding symbol_643 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_643.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_644 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_644.setFormal(symbol_56);	
				symbol_644.setActual(symbol_111);	
				symbol_643.getParameterSubstitutions().add(symbol_644);
			}
			symbol_159.getTemplateBindings().add(symbol_643);
		}
		symbol_159.getSuperClasses().add(symbol_128); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_159);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_160.setName("NonOrderedCollection");
		//symbol_160.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_160.setElementType(symbol_18);
		{
			TemplateBinding symbol_645 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_645.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_646 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_646.setFormal(symbol_56);	
				symbol_646.setActual(symbol_18);	
				symbol_645.getParameterSubstitutions().add(symbol_646);
			}
			symbol_160.getTemplateBindings().add(symbol_645);
		}
		symbol_160.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_160);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Set{T}?T]
		//
		symbol_161.setName("NonOrderedCollection");
		//symbol_161.setMoniker("ocl!NonOrderedCollection[ocl!Set{T}?T]");
		symbol_161.setElementType(symbol_108);
		{
			TemplateBinding symbol_647 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_647.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_648 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_648.setFormal(symbol_56);	
				symbol_648.setActual(symbol_108);	
				symbol_647.getParameterSubstitutions().add(symbol_648);
			}
			symbol_161.getTemplateBindings().add(symbol_647);
		}
		symbol_161.getSuperClasses().add(symbol_126); // ocl!Collection[ocl!Set{T}?T]
		symbol_118.getOwnedTypes().add(symbol_161);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_162.setName("NonOrderedCollection");
		//symbol_162.setMoniker("ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_162.setElementType(symbol_68);
		{
			TemplateBinding symbol_649 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_649.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_650 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_650.setFormal(symbol_56);	
				symbol_650.setActual(symbol_68);	
				symbol_649.getParameterSubstitutions().add(symbol_650);
			}
			symbol_162.getTemplateBindings().add(symbol_649);
		}
		symbol_162.getSuperClasses().add(symbol_139); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_162);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_163.setName("NonOrderedCollection");
		//symbol_163.setMoniker("ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_163.setElementType(symbol_22);
		{
			TemplateBinding symbol_651 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_651.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_652 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_652.setFormal(symbol_56);	
				symbol_652.setActual(symbol_22);	
				symbol_651.getParameterSubstitutions().add(symbol_652);
			}
			symbol_163.getTemplateBindings().add(symbol_651);
		}
		symbol_163.getSuperClasses().add(symbol_149); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_163);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_164.setName("NonOrderedCollection");
		//symbol_164.setMoniker("ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_164.setElementType(symbol_82);
		{
			TemplateBinding symbol_653 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_653.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_654 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_654.setFormal(symbol_56);	
				symbol_654.setActual(symbol_82);	
				symbol_653.getParameterSubstitutions().add(symbol_654);
			}
			symbol_164.getTemplateBindings().add(symbol_653);
		}
		symbol_164.getSuperClasses().add(symbol_136); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_164);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_165.setName("NonOrderedCollection");
		//symbol_165.setMoniker("ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_165.setElementType(symbol_93);
		{
			TemplateBinding symbol_655 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_655.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_656 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_656.setFormal(symbol_56);	
				symbol_656.setActual(symbol_93);	
				symbol_655.getParameterSubstitutions().add(symbol_656);
			}
			symbol_165.getTemplateBindings().add(symbol_655);
		}
		symbol_165.getSuperClasses().add(symbol_147); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_118.getOwnedTypes().add(symbol_165);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_166.setName("NonOrderedCollection");
		//symbol_166.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_166.setElementType(symbol_57);
		{
			TemplateBinding symbol_657 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_657.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_658 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_658.setFormal(symbol_56);	
				symbol_658.setActual(symbol_57);	
				symbol_657.getParameterSubstitutions().add(symbol_658);
			}
			symbol_166.getTemplateBindings().add(symbol_657);
		}
		symbol_166.getSuperClasses().add(symbol_131); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_166);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_167.setName("NonOrderedCollection");
		//symbol_167.setMoniker("ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_167.setElementType(symbol_52);
		{
			TemplateBinding symbol_659 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_659.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_660 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_660.setFormal(symbol_56);	
				symbol_660.setActual(symbol_52);	
				symbol_659.getParameterSubstitutions().add(symbol_660);
			}
			symbol_167.getTemplateBindings().add(symbol_659);
		}
		symbol_167.getSuperClasses().add(symbol_140); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_167);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Bag{T}?T]
		//
		symbol_168.setName("NonOrderedCollection");
		//symbol_168.setMoniker("ocl!NonOrderedCollection[ocl!Bag{T}?T]");
		symbol_168.setElementType(symbol_15);
		{
			TemplateBinding symbol_661 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_661.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_662 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_662.setFormal(symbol_56);	
				symbol_662.setActual(symbol_15);	
				symbol_661.getParameterSubstitutions().add(symbol_662);
			}
			symbol_168.getTemplateBindings().add(symbol_661);
		}
		symbol_168.getSuperClasses().add(symbol_152); // ocl!Collection[ocl!Bag{T}?T]
		symbol_118.getOwnedTypes().add(symbol_168);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_169.setName("NonOrderedCollection");
		//symbol_169.setMoniker("ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_169.setElementType(symbol_60);
		{
			TemplateBinding symbol_663 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_663.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_664 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_664.setFormal(symbol_56);	
				symbol_664.setActual(symbol_60);	
				symbol_663.getParameterSubstitutions().add(symbol_664);
			}
			symbol_169.getTemplateBindings().add(symbol_663);
		}
		symbol_169.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_118.getOwnedTypes().add(symbol_169);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_170.setName("NonOrderedCollection");
		//symbol_170.setMoniker("ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_170.setElementType(symbol_75);
		{
			TemplateBinding symbol_665 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_665.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_666 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_666.setFormal(symbol_56);	
				symbol_666.setActual(symbol_75);	
				symbol_665.getParameterSubstitutions().add(symbol_666);
			}
			symbol_170.getTemplateBindings().add(symbol_665);
		}
		symbol_170.getSuperClasses().add(symbol_150); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_170);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_171.setName("NonOrderedCollection");
		//symbol_171.setMoniker("ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_171.setElementType(symbol_218);
		{
			TemplateBinding symbol_667 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_667.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_668 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_668.setFormal(symbol_56);	
				symbol_668.setActual(symbol_218);	
				symbol_667.getParameterSubstitutions().add(symbol_668);
			}
			symbol_171.getTemplateBindings().add(symbol_667);
		}
		symbol_171.getSuperClasses().add(symbol_151); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_118.getOwnedTypes().add(symbol_171);
		//
		// ocl::orphanage::NonOrderedCollection ocl!NonOrderedCollection[ocl!Classifier]
		//
		symbol_172.setName("NonOrderedCollection");
		//symbol_172.setMoniker("ocl!NonOrderedCollection[ocl!Classifier]");
		symbol_172.setElementType(symbol_23);
		{
			TemplateBinding symbol_669 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_669.setSignature(symbol_55);
			{
				TemplateParameterSubstitution symbol_670 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_670.setFormal(symbol_56);	
				symbol_670.setActual(symbol_23);	
				symbol_669.getParameterSubstitutions().add(symbol_670);
			}
			symbol_172.getTemplateBindings().add(symbol_669);
		}
		symbol_172.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Classifier]
		symbol_118.getOwnedTypes().add(symbol_172);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}?T]
		//
		symbol_173.setName("NonUniqueCollection");
		//symbol_173.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}?T]");
		symbol_173.setElementType(symbol_15);
		{
			TemplateBinding symbol_671 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_671.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_672 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_672.setFormal(symbol_63);	
				symbol_672.setActual(symbol_15);	
				symbol_671.getParameterSubstitutions().add(symbol_672);
			}
			symbol_173.getTemplateBindings().add(symbol_671);
		}
		symbol_173.getSuperClasses().add(symbol_152); // ocl!Collection[ocl!Bag{T}?T]
		symbol_118.getOwnedTypes().add(symbol_173);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_174.setName("NonUniqueCollection");
		//symbol_174.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_174.setElementType(symbol_89);
		{
			TemplateBinding symbol_673 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_673.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_674 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_674.setFormal(symbol_63);	
				symbol_674.setActual(symbol_89);	
				symbol_673.getParameterSubstitutions().add(symbol_674);
			}
			symbol_174.getTemplateBindings().add(symbol_673);
		}
		symbol_174.getSuperClasses().add(symbol_146); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_118.getOwnedTypes().add(symbol_174);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Collection{T}?T]
		//
		symbol_175.setName("NonUniqueCollection");
		//symbol_175.setMoniker("ocl!NonUniqueCollection[ocl!Collection{T}?T]");
		symbol_175.setElementType(symbol_30);
		{
			TemplateBinding symbol_675 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_675.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_676 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_676.setFormal(symbol_63);	
				symbol_676.setActual(symbol_30);	
				symbol_675.getParameterSubstitutions().add(symbol_676);
			}
			symbol_175.getTemplateBindings().add(symbol_675);
		}
		symbol_175.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_175);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_176.setName("NonUniqueCollection");
		//symbol_176.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_176.setElementType(symbol_104);
		{
			TemplateBinding symbol_677 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_677.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_678 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_678.setFormal(symbol_63);	
				symbol_678.setActual(symbol_104);	
				symbol_677.getParameterSubstitutions().add(symbol_678);
			}
			symbol_176.getTemplateBindings().add(symbol_677);
		}
		symbol_176.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_176);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[String]
		//
		symbol_177.setName("NonUniqueCollection");
		//symbol_177.setMoniker("ocl!NonUniqueCollection[String]");
		symbol_177.setElementType(symbol_112);
		{
			TemplateBinding symbol_679 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_679.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_680 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_680.setFormal(symbol_63);	
				symbol_680.setActual(symbol_112);	
				symbol_679.getParameterSubstitutions().add(symbol_680);
			}
			symbol_177.getTemplateBindings().add(symbol_679);
		}
		symbol_177.getSuperClasses().add(symbol_124); // ocl!Collection[String]
		symbol_118.getOwnedTypes().add(symbol_177);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]
		//
		symbol_178.setName("NonUniqueCollection");
		//symbol_178.setMoniker("ocl!NonUniqueCollection[ocl!Bag{T}!flatten{T2}()?T2]");
		symbol_178.setElementType(symbol_18);
		{
			TemplateBinding symbol_681 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_681.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_682 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_682.setFormal(symbol_63);	
				symbol_682.setActual(symbol_18);	
				symbol_681.getParameterSubstitutions().add(symbol_682);
			}
			symbol_178.getTemplateBindings().add(symbol_681);
		}
		symbol_178.getSuperClasses().add(symbol_145); // ocl!Collection[ocl!Bag{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_178);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		//
		symbol_179.setName("NonUniqueCollection");
		//symbol_179.setMoniker("ocl!NonUniqueCollection[ocl!Sequence{T}?T]");
		symbol_179.setElementType(symbol_101);
		{
			TemplateBinding symbol_683 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_683.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_684 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_684.setFormal(symbol_63);	
				symbol_684.setActual(symbol_101);	
				symbol_683.getParameterSubstitutions().add(symbol_684);
			}
			symbol_179.getTemplateBindings().add(symbol_683);
		}
		symbol_179.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_118.getOwnedTypes().add(symbol_179);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_180.setName("NonUniqueCollection");
		//symbol_180.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_180.setElementType(symbol_57);
		{
			TemplateBinding symbol_685 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_685.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_686 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_686.setFormal(symbol_63);	
				symbol_686.setActual(symbol_57);	
				symbol_685.getParameterSubstitutions().add(symbol_686);
			}
			symbol_180.getTemplateBindings().add(symbol_685);
		}
		symbol_180.getSuperClasses().add(symbol_131); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_180);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_181.setName("NonUniqueCollection");
		//symbol_181.setMoniker("ocl!NonUniqueCollection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_181.setElementType(symbol_60);
		{
			TemplateBinding symbol_687 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_687.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_688 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_688.setFormal(symbol_63);	
				symbol_688.setActual(symbol_60);	
				symbol_687.getParameterSubstitutions().add(symbol_688);
			}
			symbol_181.getTemplateBindings().add(symbol_687);
		}
		symbol_181.getSuperClasses().add(symbol_148); // ocl!Collection[ocl!NonOrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_118.getOwnedTypes().add(symbol_181);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_182.setName("NonUniqueCollection");
		//symbol_182.setMoniker("ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_182.setElementType(symbol_64);
		{
			TemplateBinding symbol_689 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_689.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_690 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_690.setFormal(symbol_63);	
				symbol_690.setActual(symbol_64);	
				symbol_689.getParameterSubstitutions().add(symbol_690);
			}
			symbol_182.getTemplateBindings().add(symbol_689);
		}
		symbol_182.getSuperClasses().add(symbol_129); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_182);
		//
		// ocl::orphanage::NonUniqueCollection ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_183.setName("NonUniqueCollection");
		//symbol_183.setMoniker("ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_183.setElementType(symbol_86);
		{
			TemplateBinding symbol_691 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_691.setSignature(symbol_62);
			{
				TemplateParameterSubstitution symbol_692 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_692.setFormal(symbol_63);	
				symbol_692.setActual(symbol_86);	
				symbol_691.getParameterSubstitutions().add(symbol_692);
			}
			symbol_183.getTemplateBindings().add(symbol_691);
		}
		symbol_183.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_183);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		//
		symbol_184.setName("OrderedCollection");
		//symbol_184.setMoniker("ocl!OrderedCollection[ocl!OrderedSet{T}?T]");
		symbol_184.setElementType(symbol_93);
		{
			TemplateBinding symbol_693 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_693.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_694 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_694.setFormal(symbol_85);	
				symbol_694.setActual(symbol_93);	
				symbol_693.getParameterSubstitutions().add(symbol_694);
			}
			symbol_184.getTemplateBindings().add(symbol_693);
		}
		symbol_184.getSuperClasses().add(symbol_147); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_118.getOwnedTypes().add(symbol_184);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_185.setName("OrderedCollection");
		//symbol_185.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_185.setElementType(symbol_89);
		{
			TemplateBinding symbol_695 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_695.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_696 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_696.setFormal(symbol_85);	
				symbol_696.setActual(symbol_89);	
				symbol_695.getParameterSubstitutions().add(symbol_696);
			}
			symbol_185.getTemplateBindings().add(symbol_695);
		}
		symbol_185.getSuperClasses().add(symbol_146); // ocl!Collection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_118.getOwnedTypes().add(symbol_185);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_186.setName("OrderedCollection");
		//symbol_186.setMoniker("ocl!OrderedCollection[ocl!OrderedCollection{T}?T]");
		symbol_186.setElementType(symbol_86);
		{
			TemplateBinding symbol_697 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_697.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_698 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_698.setFormal(symbol_85);	
				symbol_698.setActual(symbol_86);	
				symbol_697.getParameterSubstitutions().add(symbol_698);
			}
			symbol_186.getTemplateBindings().add(symbol_697);
		}
		symbol_186.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_186);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[String]
		//
		symbol_187.setName("OrderedCollection");
		//symbol_187.setMoniker("ocl!OrderedCollection[String]");
		symbol_187.setElementType(symbol_112);
		{
			TemplateBinding symbol_699 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_699.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_700 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_700.setFormal(symbol_85);	
				symbol_700.setActual(symbol_112);	
				symbol_699.getParameterSubstitutions().add(symbol_700);
			}
			symbol_187.getTemplateBindings().add(symbol_699);
		}
		symbol_187.getSuperClasses().add(symbol_124); // ocl!Collection[String]
		symbol_118.getOwnedTypes().add(symbol_187);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Collection{T}?T]
		//
		symbol_188.setName("OrderedCollection");
		//symbol_188.setMoniker("ocl!OrderedCollection[ocl!Collection{T}?T]");
		symbol_188.setElementType(symbol_30);
		{
			TemplateBinding symbol_701 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_701.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_702 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_702.setFormal(symbol_85);	
				symbol_702.setActual(symbol_30);	
				symbol_701.getParameterSubstitutions().add(symbol_702);
			}
			symbol_188.getTemplateBindings().add(symbol_701);
		}
		symbol_188.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_188);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		//
		symbol_189.setName("OrderedCollection");
		//symbol_189.setMoniker("ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]");
		symbol_189.setElementType(symbol_64);
		{
			TemplateBinding symbol_703 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_703.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_704 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_704.setFormal(symbol_85);	
				symbol_704.setActual(symbol_64);	
				symbol_703.getParameterSubstitutions().add(symbol_704);
			}
			symbol_189.getTemplateBindings().add(symbol_703);
		}
		symbol_189.getSuperClasses().add(symbol_129); // ocl!Collection[ocl!NonUniqueCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_189);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_190.setName("OrderedCollection");
		//symbol_190.setMoniker("ocl!OrderedCollection[ocl!UniqueCollection{T}?T]");
		symbol_190.setElementType(symbol_116);
		{
			TemplateBinding symbol_705 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_705.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_706 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_706.setFormal(symbol_85);	
				symbol_706.setActual(symbol_116);	
				symbol_705.getParameterSubstitutions().add(symbol_706);
			}
			symbol_190.getTemplateBindings().add(symbol_705);
		}
		symbol_190.getSuperClasses().add(symbol_127); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_190);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_191.setName("OrderedCollection");
		//symbol_191.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_191.setElementType(symbol_104);
		{
			TemplateBinding symbol_707 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_707.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_708 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_708.setFormal(symbol_85);	
				symbol_708.setActual(symbol_104);	
				symbol_707.getParameterSubstitutions().add(symbol_708);
			}
			symbol_191.getTemplateBindings().add(symbol_707);
		}
		symbol_191.getSuperClasses().add(symbol_134); // ocl!Collection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_191);
		//
		// ocl::orphanage::OrderedCollection ocl!OrderedCollection[ocl!Sequence{T}?T]
		//
		symbol_192.setName("OrderedCollection");
		//symbol_192.setMoniker("ocl!OrderedCollection[ocl!Sequence{T}?T]");
		symbol_192.setElementType(symbol_101);
		{
			TemplateBinding symbol_709 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_709.setSignature(symbol_84);
			{
				TemplateParameterSubstitution symbol_710 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_710.setFormal(symbol_85);	
				symbol_710.setActual(symbol_101);	
				symbol_709.getParameterSubstitutions().add(symbol_710);
			}
			symbol_192.getTemplateBindings().add(symbol_709);
		}
		symbol_192.getSuperClasses().add(symbol_133); // ocl!Collection[ocl!Sequence{T}?T]
		symbol_118.getOwnedTypes().add(symbol_192);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedSet{T}?T]
		//
		symbol_193.setName("OrderedSet");
		//symbol_193.setMoniker("ocl!OrderedSet[ocl!OrderedSet{T}?T]");
		symbol_193.setElementType(symbol_93);
		{
			TemplateBinding symbol_711 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_711.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_712 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_712.setFormal(symbol_92);	
				symbol_712.setActual(symbol_93);	
				symbol_711.getParameterSubstitutions().add(symbol_712);
			}
			symbol_193.getTemplateBindings().add(symbol_711);
		}
		symbol_193.getSuperClasses().add(symbol_184); // ocl!OrderedCollection[ocl!OrderedSet{T}?T]
		symbol_193.getSuperClasses().add(symbol_234); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_118.getOwnedTypes().add(symbol_193);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!Collection{T}?T]
		//
		symbol_194.setName("OrderedSet");
		//symbol_194.setMoniker("ocl!OrderedSet[ocl!Collection{T}?T]");
		symbol_194.setElementType(symbol_30);
		{
			TemplateBinding symbol_713 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_713.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_714 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_714.setFormal(symbol_92);	
				symbol_714.setActual(symbol_30);	
				symbol_713.getParameterSubstitutions().add(symbol_714);
			}
			symbol_194.getTemplateBindings().add(symbol_713);
		}
		symbol_194.getSuperClasses().add(symbol_229); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_194.getSuperClasses().add(symbol_188); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_194);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!OrderedCollection{T}?T]
		//
		symbol_195.setName("OrderedSet");
		//symbol_195.setMoniker("ocl!OrderedSet[ocl!OrderedCollection{T}?T]");
		symbol_195.setElementType(symbol_86);
		{
			TemplateBinding symbol_715 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_715.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_716 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_716.setFormal(symbol_92);	
				symbol_716.setActual(symbol_86);	
				symbol_715.getParameterSubstitutions().add(symbol_716);
			}
			symbol_195.getTemplateBindings().add(symbol_715);
		}
		symbol_195.getSuperClasses().add(symbol_186); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_195.getSuperClasses().add(symbol_225); // ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_195);
		//
		// ocl::orphanage::OrderedSet ocl!OrderedSet[ocl!UniqueCollection{T}?T]
		//
		symbol_196.setName("OrderedSet");
		//symbol_196.setMoniker("ocl!OrderedSet[ocl!UniqueCollection{T}?T]");
		symbol_196.setElementType(symbol_116);
		{
			TemplateBinding symbol_717 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_717.setSignature(symbol_91);
			{
				TemplateParameterSubstitution symbol_718 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_718.setFormal(symbol_92);	
				symbol_718.setActual(symbol_116);	
				symbol_717.getParameterSubstitutions().add(symbol_718);
			}
			symbol_196.getTemplateBindings().add(symbol_717);
		}
		symbol_196.getSuperClasses().add(symbol_190); // ocl!OrderedCollection[ocl!UniqueCollection{T}?T]
		symbol_196.getSuperClasses().add(symbol_235); // ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_196);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}?T]
		//
		symbol_197.setName("Sequence");
		//symbol_197.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}?T]");
		symbol_197.setElementType(symbol_86);
		{
			TemplateBinding symbol_719 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_719.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_720 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_720.setFormal(symbol_100);	
				symbol_720.setActual(symbol_86);	
				symbol_719.getParameterSubstitutions().add(symbol_720);
			}
			symbol_197.getTemplateBindings().add(symbol_719);
		}
		symbol_197.getSuperClasses().add(symbol_183); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}?T]
		symbol_197.getSuperClasses().add(symbol_186); // ocl!OrderedCollection[ocl!OrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_197);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]
		//
		symbol_198.setName("Sequence");
		//symbol_198.setMoniker("ocl!Sequence[ocl!Sequence{T}!flatten{T2}()?T2]");
		symbol_198.setElementType(symbol_104);
		{
			TemplateBinding symbol_721 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_721.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_722 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_722.setFormal(symbol_100);	
				symbol_722.setActual(symbol_104);	
				symbol_721.getParameterSubstitutions().add(symbol_722);
			}
			symbol_198.getTemplateBindings().add(symbol_721);
		}
		symbol_198.getSuperClasses().add(symbol_176); // ocl!NonUniqueCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_198.getSuperClasses().add(symbol_191); // ocl!OrderedCollection[ocl!Sequence{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_198);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!NonUniqueCollection{T}?T]
		//
		symbol_199.setName("Sequence");
		//symbol_199.setMoniker("ocl!Sequence[ocl!NonUniqueCollection{T}?T]");
		symbol_199.setElementType(symbol_64);
		{
			TemplateBinding symbol_723 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_723.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_724 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_724.setFormal(symbol_100);	
				symbol_724.setActual(symbol_64);	
				symbol_723.getParameterSubstitutions().add(symbol_724);
			}
			symbol_199.getTemplateBindings().add(symbol_723);
		}
		symbol_199.getSuperClasses().add(symbol_182); // ocl!NonUniqueCollection[ocl!NonUniqueCollection{T}?T]
		symbol_199.getSuperClasses().add(symbol_189); // ocl!OrderedCollection[ocl!NonUniqueCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_199);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Sequence{T}?T]
		//
		symbol_200.setName("Sequence");
		//symbol_200.setMoniker("ocl!Sequence[ocl!Sequence{T}?T]");
		symbol_200.setElementType(symbol_101);
		{
			TemplateBinding symbol_725 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_725.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_726 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_726.setFormal(symbol_100);	
				symbol_726.setActual(symbol_101);	
				symbol_725.getParameterSubstitutions().add(symbol_726);
			}
			symbol_200.getTemplateBindings().add(symbol_725);
		}
		symbol_200.getSuperClasses().add(symbol_179); // ocl!NonUniqueCollection[ocl!Sequence{T}?T]
		symbol_200.getSuperClasses().add(symbol_192); // ocl!OrderedCollection[ocl!Sequence{T}?T]
		symbol_118.getOwnedTypes().add(symbol_200);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		//
		symbol_201.setName("Sequence");
		//symbol_201.setMoniker("ocl!Sequence[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]");
		symbol_201.setElementType(symbol_89);
		{
			TemplateBinding symbol_727 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_727.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_728 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_728.setFormal(symbol_100);	
				symbol_728.setActual(symbol_89);	
				symbol_727.getParameterSubstitutions().add(symbol_728);
			}
			symbol_201.getTemplateBindings().add(symbol_727);
		}
		symbol_201.getSuperClasses().add(symbol_185); // ocl!OrderedCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_201.getSuperClasses().add(symbol_174); // ocl!NonUniqueCollection[ocl!OrderedCollection{T}!collect{V}(T|Lambda~T()V)?V]
		symbol_118.getOwnedTypes().add(symbol_201);
		//
		// ocl::orphanage::Sequence ocl!Sequence[ocl!Collection{T}?T]
		//
		symbol_202.setName("Sequence");
		//symbol_202.setMoniker("ocl!Sequence[ocl!Collection{T}?T]");
		symbol_202.setElementType(symbol_30);
		{
			TemplateBinding symbol_729 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_729.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_730 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_730.setFormal(symbol_100);	
				symbol_730.setActual(symbol_30);	
				symbol_729.getParameterSubstitutions().add(symbol_730);
			}
			symbol_202.getTemplateBindings().add(symbol_729);
		}
		symbol_202.getSuperClasses().add(symbol_175); // ocl!NonUniqueCollection[ocl!Collection{T}?T]
		symbol_202.getSuperClasses().add(symbol_188); // ocl!OrderedCollection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_202);
		//
		// ocl::orphanage::Sequence ocl!Sequence[String]
		//
		symbol_203.setName("Sequence");
		//symbol_203.setMoniker("ocl!Sequence[String]");
		symbol_203.setElementType(symbol_112);
		{
			TemplateBinding symbol_731 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_731.setSignature(symbol_99);
			{
				TemplateParameterSubstitution symbol_732 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_732.setFormal(symbol_100);	
				symbol_732.setActual(symbol_112);	
				symbol_731.getParameterSubstitutions().add(symbol_732);
			}
			symbol_203.getTemplateBindings().add(symbol_731);
		}
		symbol_203.getSuperClasses().add(symbol_187); // ocl!OrderedCollection[String]
		symbol_203.getSuperClasses().add(symbol_177); // ocl!NonUniqueCollection[String]
		symbol_118.getOwnedTypes().add(symbol_203);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Collection{T}?T]
		//
		symbol_204.setName("Set");
		//symbol_204.setMoniker("ocl!Set[ocl!Collection{T}?T]");
		symbol_204.setElementType(symbol_30);
		{
			TemplateBinding symbol_733 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_733.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_734 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_734.setFormal(symbol_107);	
				symbol_734.setActual(symbol_30);	
				symbol_733.getParameterSubstitutions().add(symbol_734);
			}
			symbol_204.getTemplateBindings().add(symbol_733);
		}
		symbol_204.getSuperClasses().add(symbol_157); // ocl!NonOrderedCollection[ocl!Collection{T}?T]
		symbol_204.getSuperClasses().add(symbol_229); // ocl!UniqueCollection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_204);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OrderedSet{T}?T]
		//
		symbol_205.setName("Set");
		//symbol_205.setMoniker("ocl!Set[ocl!OrderedSet{T}?T]");
		symbol_205.setElementType(symbol_93);
		{
			TemplateBinding symbol_735 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_735.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_736 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_736.setFormal(symbol_107);	
				symbol_736.setActual(symbol_93);	
				symbol_735.getParameterSubstitutions().add(symbol_736);
			}
			symbol_205.getTemplateBindings().add(symbol_735);
		}
		symbol_205.getSuperClasses().add(symbol_165); // ocl!NonOrderedCollection[ocl!OrderedSet{T}?T]
		symbol_205.getSuperClasses().add(symbol_234); // ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		symbol_118.getOwnedTypes().add(symbol_205);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_206.setName("Set");
		//symbol_206.setMoniker("ocl!Set[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_206.setElementType(symbol_82);
		{
			TemplateBinding symbol_737 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_737.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_738 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_738.setFormal(symbol_107);	
				symbol_738.setActual(symbol_82);	
				symbol_737.getParameterSubstitutions().add(symbol_738);
			}
			symbol_206.getTemplateBindings().add(symbol_737);
		}
		symbol_206.getSuperClasses().add(symbol_232); // ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_206.getSuperClasses().add(symbol_164); // ocl!NonOrderedCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_206);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_207.setName("Set");
		//symbol_207.setMoniker("ocl!Set[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_207.setElementType(symbol_111);
		{
			TemplateBinding symbol_739 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_739.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_740 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_740.setFormal(symbol_107);	
				symbol_740.setActual(symbol_111);	
				symbol_739.getParameterSubstitutions().add(symbol_740);
			}
			symbol_207.getTemplateBindings().add(symbol_739);
		}
		symbol_207.getSuperClasses().add(symbol_159); // ocl!NonOrderedCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_207.getSuperClasses().add(symbol_226); // ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_207);
		//
		// ocl::orphanage::Set ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_208.setName("Set");
		//symbol_208.setMoniker("ocl!Set[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_208.setElementType(symbol_22);
		{
			TemplateBinding symbol_741 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_741.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_742 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_742.setFormal(symbol_107);	
				symbol_742.setActual(symbol_22);	
				symbol_741.getParameterSubstitutions().add(symbol_742);
			}
			symbol_208.getTemplateBindings().add(symbol_741);
		}
		symbol_208.getSuperClasses().add(symbol_163); // ocl!NonOrderedCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_208.getSuperClasses().add(symbol_224); // ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_208);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Set{T}?T]
		//
		symbol_209.setName("Set");
		//symbol_209.setMoniker("ocl!Set[ocl!Set{T}?T]");
		symbol_209.setElementType(symbol_108);
		{
			TemplateBinding symbol_743 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_743.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_744 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_744.setFormal(symbol_107);	
				symbol_744.setActual(symbol_108);	
				symbol_743.getParameterSubstitutions().add(symbol_744);
			}
			symbol_209.getTemplateBindings().add(symbol_743);
		}
		symbol_209.getSuperClasses().add(symbol_233); // ocl!UniqueCollection[ocl!Set{T}?T]
		symbol_209.getSuperClasses().add(symbol_161); // ocl!NonOrderedCollection[ocl!Set{T}?T]
		symbol_118.getOwnedTypes().add(symbol_209);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclAny]
		//
		symbol_210.setName("Set");
		//symbol_210.setMoniker("ocl!Set[ocl!OclAny]");
		symbol_210.setElementType(symbol_65);
		{
			TemplateBinding symbol_745 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_745.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_746 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_746.setFormal(symbol_107);	
				symbol_746.setActual(symbol_65);	
				symbol_745.getParameterSubstitutions().add(symbol_746);
			}
			symbol_210.getTemplateBindings().add(symbol_745);
		}
		symbol_210.getSuperClasses().add(symbol_156); // ocl!NonOrderedCollection[ocl!OclAny]
		symbol_210.getSuperClasses().add(symbol_227); // ocl!UniqueCollection[ocl!OclAny]
		symbol_118.getOwnedTypes().add(symbol_210);
		//
		// ocl::orphanage::Set ocl!Set[ocl!NonOrderedCollection{T}?T]
		//
		symbol_211.setName("Set");
		//symbol_211.setMoniker("ocl!Set[ocl!NonOrderedCollection{T}?T]");
		symbol_211.setElementType(symbol_57);
		{
			TemplateBinding symbol_747 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_747.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_748 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_748.setFormal(symbol_107);	
				symbol_748.setActual(symbol_57);	
				symbol_747.getParameterSubstitutions().add(symbol_748);
			}
			symbol_211.getTemplateBindings().add(symbol_747);
		}
		symbol_211.getSuperClasses().add(symbol_223); // ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		symbol_211.getSuperClasses().add(symbol_166); // ocl!NonOrderedCollection[ocl!NonOrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_211);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_212.setName("Set");
		//symbol_212.setMoniker("ocl!Set[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_212.setElementType(symbol_68);
		{
			TemplateBinding symbol_749 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_749.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_750 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_750.setFormal(symbol_107);	
				symbol_750.setActual(symbol_68);	
				symbol_749.getParameterSubstitutions().add(symbol_750);
			}
			symbol_212.getTemplateBindings().add(symbol_749);
		}
		symbol_212.getSuperClasses().add(symbol_162); // ocl!NonOrderedCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_212.getSuperClasses().add(symbol_228); // ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_212);
		//
		// ocl::orphanage::Set ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_213.setName("Set");
		//symbol_213.setMoniker("ocl!Set[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_213.setElementType(symbol_75);
		{
			TemplateBinding symbol_751 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_751.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_752 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_752.setFormal(symbol_107);	
				symbol_752.setActual(symbol_75);	
				symbol_751.getParameterSubstitutions().add(symbol_752);
			}
			symbol_213.getTemplateBindings().add(symbol_751);
		}
		symbol_213.getSuperClasses().add(symbol_170); // ocl!NonOrderedCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_213.getSuperClasses().add(symbol_221); // ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_213);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_214.setName("Set");
		//symbol_214.setMoniker("ocl!Set[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_214.setElementType(symbol_52);
		{
			TemplateBinding symbol_753 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_753.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_754 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_754.setFormal(symbol_107);	
				symbol_754.setActual(symbol_52);	
				symbol_753.getParameterSubstitutions().add(symbol_754);
			}
			symbol_214.getTemplateBindings().add(symbol_753);
		}
		symbol_214.getSuperClasses().add(symbol_167); // ocl!NonOrderedCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_214.getSuperClasses().add(symbol_222); // ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_214);
		//
		// ocl::orphanage::Set ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_215.setName("Set");
		//symbol_215.setMoniker("ocl!Set[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_215.setElementType(symbol_218);
		{
			TemplateBinding symbol_755 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_755.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_756 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_756.setFormal(symbol_107);	
				symbol_756.setActual(symbol_218);	
				symbol_755.getParameterSubstitutions().add(symbol_756);
			}
			symbol_215.getTemplateBindings().add(symbol_755);
		}
		symbol_215.getSuperClasses().add(symbol_171); // ocl!NonOrderedCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_215.getSuperClasses().add(symbol_230); // ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_118.getOwnedTypes().add(symbol_215);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Classifier]
		//
		symbol_216.setName("Set");
		//symbol_216.setMoniker("ocl!Set[ocl!Classifier]");
		symbol_216.setElementType(symbol_23);
		{
			TemplateBinding symbol_757 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_757.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_758 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_758.setFormal(symbol_107);	
				symbol_758.setActual(symbol_23);	
				symbol_757.getParameterSubstitutions().add(symbol_758);
			}
			symbol_216.getTemplateBindings().add(symbol_757);
		}
		symbol_216.getSuperClasses().add(symbol_172); // ocl!NonOrderedCollection[ocl!Classifier]
		symbol_216.getSuperClasses().add(symbol_231); // ocl!UniqueCollection[ocl!Classifier]
		symbol_118.getOwnedTypes().add(symbol_216);
		//
		// ocl::orphanage::Set ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_217.setName("Set");
		//symbol_217.setMoniker("ocl!Set[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_217.setElementType(symbol_26);
		{
			TemplateBinding symbol_759 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_759.setSignature(symbol_106);
			{
				TemplateParameterSubstitution symbol_760 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_760.setFormal(symbol_107);	
				symbol_760.setActual(symbol_26);	
				symbol_759.getParameterSubstitutions().add(symbol_760);
			}
			symbol_217.getTemplateBindings().add(symbol_759);
		}
		symbol_217.getSuperClasses().add(symbol_236); // ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_217.getSuperClasses().add(symbol_158); // ocl!NonOrderedCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_217);
		//
		// ocl::orphanage::Tuple Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}
		//
		symbol_218.setName("Tuple");
		//symbol_218.setMoniker("Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}");
		{ // ocl::orphanage::Tuple::first Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!first
			symbol_219.setName("first");
			symbol_219.setType(symbol_30);  // ocl!Collection{T}?T
			
			symbol_219.setIsResolveProxies(true);
			symbol_218.getOwnedAttributes().add(symbol_219);
		}
		{ // ocl::orphanage::Tuple::second Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}!second
			symbol_220.setName("second");
			symbol_220.setType(symbol_48);  // ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2
			
			symbol_220.setIsResolveProxies(true);
			symbol_218.getOwnedAttributes().add(symbol_220);
		}
		symbol_118.getOwnedTypes().add(symbol_218);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_221.setName("UniqueCollection");
		//symbol_221.setMoniker("ocl!UniqueCollection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]");
		symbol_221.setElementType(symbol_75);
		{
			TemplateBinding symbol_761 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_761.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_762 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_762.setFormal(symbol_115);	
				symbol_762.setActual(symbol_75);	
				symbol_761.getParameterSubstitutions().add(symbol_762);
			}
			symbol_221.getTemplateBindings().add(symbol_761);
		}
		symbol_221.getSuperClasses().add(symbol_150); // ocl!Collection[ocl!OclInvalid!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_221);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		//
		symbol_222.setName("UniqueCollection");
		//symbol_222.setMoniker("ocl!UniqueCollection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]");
		symbol_222.setElementType(symbol_52);
		{
			TemplateBinding symbol_763 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_763.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_764 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_764.setFormal(symbol_115);	
				symbol_764.setActual(symbol_52);	
				symbol_763.getParameterSubstitutions().add(symbol_764);
			}
			symbol_222.getTemplateBindings().add(symbol_763);
		}
		symbol_222.getSuperClasses().add(symbol_140); // ocl!Collection[ocl!Enumeration!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_222);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]
		//
		symbol_223.setName("UniqueCollection");
		//symbol_223.setMoniker("ocl!UniqueCollection[ocl!NonOrderedCollection{T}?T]");
		symbol_223.setElementType(symbol_57);
		{
			TemplateBinding symbol_765 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_765.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_766 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_766.setFormal(symbol_115);	
				symbol_766.setActual(symbol_57);	
				symbol_765.getParameterSubstitutions().add(symbol_766);
			}
			symbol_223.getTemplateBindings().add(symbol_765);
		}
		symbol_223.getSuperClasses().add(symbol_131); // ocl!Collection[ocl!NonOrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_223);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]
		//
		symbol_224.setName("UniqueCollection");
		//symbol_224.setMoniker("ocl!UniqueCollection[Boolean!allInstances{OclSelf}()?OclSelf]");
		symbol_224.setElementType(symbol_22);
		{
			TemplateBinding symbol_767 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_767.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_768 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_768.setFormal(symbol_115);	
				symbol_768.setActual(symbol_22);	
				symbol_767.getParameterSubstitutions().add(symbol_768);
			}
			symbol_224.getTemplateBindings().add(symbol_767);
		}
		symbol_224.getSuperClasses().add(symbol_149); // ocl!Collection[Boolean!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_224);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedCollection{T}?T]
		//
		symbol_225.setName("UniqueCollection");
		//symbol_225.setMoniker("ocl!UniqueCollection[ocl!OrderedCollection{T}?T]");
		symbol_225.setElementType(symbol_86);
		{
			TemplateBinding symbol_769 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_769.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_770 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_770.setFormal(symbol_115);	
				symbol_770.setActual(symbol_86);	
				symbol_769.getParameterSubstitutions().add(symbol_770);
			}
			symbol_225.getTemplateBindings().add(symbol_769);
		}
		symbol_225.getSuperClasses().add(symbol_125); // ocl!Collection[ocl!OrderedCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_225);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]
		//
		symbol_226.setName("UniqueCollection");
		//symbol_226.setMoniker("ocl!UniqueCollection[ocl!Set{T}!flatten{T2}()?T2]");
		symbol_226.setElementType(symbol_111);
		{
			TemplateBinding symbol_771 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_771.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_772 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_772.setFormal(symbol_115);	
				symbol_772.setActual(symbol_111);	
				symbol_771.getParameterSubstitutions().add(symbol_772);
			}
			symbol_226.getTemplateBindings().add(symbol_771);
		}
		symbol_226.getSuperClasses().add(symbol_128); // ocl!Collection[ocl!Set{T}!flatten{T2}()?T2]
		symbol_118.getOwnedTypes().add(symbol_226);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny]
		//
		symbol_227.setName("UniqueCollection");
		//symbol_227.setMoniker("ocl!UniqueCollection[ocl!OclAny]");
		symbol_227.setElementType(symbol_65);
		{
			TemplateBinding symbol_773 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_773.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_774 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_774.setFormal(symbol_115);	
				symbol_774.setActual(symbol_65);	
				symbol_773.getParameterSubstitutions().add(symbol_774);
			}
			symbol_227.getTemplateBindings().add(symbol_773);
		}
		symbol_227.getSuperClasses().add(symbol_137); // ocl!Collection[ocl!OclAny]
		symbol_118.getOwnedTypes().add(symbol_227);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		//
		symbol_228.setName("UniqueCollection");
		//symbol_228.setMoniker("ocl!UniqueCollection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]");
		symbol_228.setElementType(symbol_68);
		{
			TemplateBinding symbol_775 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_775.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_776 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_776.setFormal(symbol_115);	
				symbol_776.setActual(symbol_68);	
				symbol_775.getParameterSubstitutions().add(symbol_776);
			}
			symbol_228.getTemplateBindings().add(symbol_775);
		}
		symbol_228.getSuperClasses().add(symbol_139); // ocl!Collection[ocl!OclAny!oclAsSet{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_228);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Collection{T}?T]
		//
		symbol_229.setName("UniqueCollection");
		//symbol_229.setMoniker("ocl!UniqueCollection[ocl!Collection{T}?T]");
		symbol_229.setElementType(symbol_30);
		{
			TemplateBinding symbol_777 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_777.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_778 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_778.setFormal(symbol_115);	
				symbol_778.setActual(symbol_30);	
				symbol_777.getParameterSubstitutions().add(symbol_778);
			}
			symbol_229.getTemplateBindings().add(symbol_777);
		}
		symbol_229.getSuperClasses().add(symbol_143); // ocl!Collection[ocl!Collection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_229);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		//
		symbol_230.setName("UniqueCollection");
		//symbol_230.setMoniker("ocl!UniqueCollection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]");
		symbol_230.setElementType(symbol_218);
		{
			TemplateBinding symbol_779 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_779.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_780 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_780.setFormal(symbol_115);	
				symbol_780.setActual(symbol_218);	
				symbol_779.getParameterSubstitutions().add(symbol_780);
			}
			symbol_230.getTemplateBindings().add(symbol_779);
		}
		symbol_230.getSuperClasses().add(symbol_151); // ocl!Collection[Tuple{first:ocl!Collection{T}?T,second:ocl!Collection{T}!product{T2}(ocl!Collection[T2])?T2}]
		symbol_118.getOwnedTypes().add(symbol_230);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier]
		//
		symbol_231.setName("UniqueCollection");
		//symbol_231.setMoniker("ocl!UniqueCollection[ocl!Classifier]");
		symbol_231.setElementType(symbol_23);
		{
			TemplateBinding symbol_781 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_781.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_782 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_782.setFormal(symbol_115);	
				symbol_782.setActual(symbol_23);	
				symbol_781.getParameterSubstitutions().add(symbol_782);
			}
			symbol_231.getTemplateBindings().add(symbol_781);
		}
		symbol_231.getSuperClasses().add(symbol_138); // ocl!Collection[ocl!Classifier]
		symbol_118.getOwnedTypes().add(symbol_231);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		//
		symbol_232.setName("UniqueCollection");
		//symbol_232.setMoniker("ocl!UniqueCollection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]");
		symbol_232.setElementType(symbol_82);
		{
			TemplateBinding symbol_783 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_783.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_784 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_784.setFormal(symbol_115);	
				symbol_784.setActual(symbol_82);	
				symbol_783.getParameterSubstitutions().add(symbol_784);
			}
			symbol_232.getTemplateBindings().add(symbol_783);
		}
		symbol_232.getSuperClasses().add(symbol_136); // ocl!Collection[ocl!OclVoid!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_232);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Set{T}?T]
		//
		symbol_233.setName("UniqueCollection");
		//symbol_233.setMoniker("ocl!UniqueCollection[ocl!Set{T}?T]");
		symbol_233.setElementType(symbol_108);
		{
			TemplateBinding symbol_785 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_785.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_786 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_786.setFormal(symbol_115);	
				symbol_786.setActual(symbol_108);	
				symbol_785.getParameterSubstitutions().add(symbol_786);
			}
			symbol_233.getTemplateBindings().add(symbol_785);
		}
		symbol_233.getSuperClasses().add(symbol_126); // ocl!Collection[ocl!Set{T}?T]
		symbol_118.getOwnedTypes().add(symbol_233);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!OrderedSet{T}?T]
		//
		symbol_234.setName("UniqueCollection");
		//symbol_234.setMoniker("ocl!UniqueCollection[ocl!OrderedSet{T}?T]");
		symbol_234.setElementType(symbol_93);
		{
			TemplateBinding symbol_787 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_787.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_788 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_788.setFormal(symbol_115);	
				symbol_788.setActual(symbol_93);	
				symbol_787.getParameterSubstitutions().add(symbol_788);
			}
			symbol_234.getTemplateBindings().add(symbol_787);
		}
		symbol_234.getSuperClasses().add(symbol_147); // ocl!Collection[ocl!OrderedSet{T}?T]
		symbol_118.getOwnedTypes().add(symbol_234);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!UniqueCollection{T}?T]
		//
		symbol_235.setName("UniqueCollection");
		//symbol_235.setMoniker("ocl!UniqueCollection[ocl!UniqueCollection{T}?T]");
		symbol_235.setElementType(symbol_116);
		{
			TemplateBinding symbol_789 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_789.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_790 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_790.setFormal(symbol_115);	
				symbol_790.setActual(symbol_116);	
				symbol_789.getParameterSubstitutions().add(symbol_790);
			}
			symbol_235.getTemplateBindings().add(symbol_789);
		}
		symbol_235.getSuperClasses().add(symbol_127); // ocl!Collection[ocl!UniqueCollection{T}?T]
		symbol_118.getOwnedTypes().add(symbol_235);
		//
		// ocl::orphanage::UniqueCollection ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		//
		symbol_236.setName("UniqueCollection");
		//symbol_236.setMoniker("ocl!UniqueCollection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]");
		symbol_236.setElementType(symbol_26);
		{
			TemplateBinding symbol_791 = PivotFactory.eINSTANCE.createTemplateBinding();
			symbol_791.setSignature(symbol_114);
			{
				TemplateParameterSubstitution symbol_792 = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				symbol_792.setFormal(symbol_115);	
				symbol_792.setActual(symbol_26);	
				symbol_791.getParameterSubstitutions().add(symbol_792);
			}
			symbol_236.getTemplateBindings().add(symbol_791);
		}
		symbol_236.getSuperClasses().add(symbol_130); // ocl!Collection[ocl!Classifier!allInstances{OclSelf}()?OclSelf]
		symbol_118.getOwnedTypes().add(symbol_236);
		symbol_1.getNestedPackages().add(symbol_118);
		return symbol_1;
	}
}
