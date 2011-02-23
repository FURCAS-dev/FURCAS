/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case004.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package;

import org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case002.Case002Package;

import org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case003.Case003Package;

import org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case004.A4Sub;
import org.eclipse.emf.query2.test.mm.testcases.case004.B4HasConstant;
import org.eclipse.emf.query2.test.mm.testcases.case004.C4Sub;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Factory;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.D4Sub;
import org.eclipse.emf.query2.test.mm.testcases.case004.F4Sub;
import org.eclipse.emf.query2.test.mm.testcases.case004.composesB;
import org.eclipse.emf.query2.test.mm.testcases.case004.composesCs;
import org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered;
import org.eclipse.emf.query2.test.mm.testcases.case004.hasCs;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.P1Package;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.impl.P1PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.p2.P2Package;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.p2.impl.P2PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case005.p3.P3Package;

import org.eclipse.emf.query2.test.mm.testcases.case005.p3.impl.P3PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.P4Package;

import org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.P4PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case006.Case006Package;

import org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.base.BasePackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.top.TopPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopPackage;

import org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package;

import org.eclipse.emf.query2.test.mm.testcases.case008.impl.Case008PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritancePackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case009.Case009Package;

import org.eclipse.emf.query2.test.mm.testcases.case009.impl.Case009PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package;

import org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case011.Case011Package;

import org.eclipse.emf.query2.test.mm.testcases.case011.impl.Case011PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case012.Case012Package;

import org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package;

import org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case014.Case014Package;

import org.eclipse.emf.query2.test.mm.testcases.case014.impl.Case014PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case015.Case015Package;

import org.eclipse.emf.query2.test.mm.testcases.case015.impl.Case015PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case016.Case016Package;

import org.eclipse.emf.query2.test.mm.testcases.case016.impl.Case016PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case017.Case017Package;

import org.eclipse.emf.query2.test.mm.testcases.case017.impl.Case017PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package;

import org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case019.Case019Package;

import org.eclipse.emf.query2.test.mm.testcases.case019.impl.Case019PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage;

import org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case019.translatabletexts.TranslatabletextsPackage;

import org.eclipse.emf.query2.test.mm.testcases.case019.translatabletexts.impl.TranslatabletextsPackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package;

import org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case021.Case021Package;

import org.eclipse.emf.query2.test.mm.testcases.case021.impl.Case021PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case022.Case022Package;

import org.eclipse.emf.query2.test.mm.testcases.case022.impl.Case022PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package;

import org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case024.Case024Package;

import org.eclipse.emf.query2.test.mm.testcases.case024.impl.Case024PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case025.Case025Package;

import org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl;

import org.eclipse.emf.query2.test.mm.testcases.case026.Case026Package;

import org.eclipse.emf.query2.test.mm.testcases.case026.impl.Case026PackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.Case001fPackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.Case003fPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.Case003fPackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.Case004fPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.impl.Case004fPackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsPackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.Case005fPackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.StructurebasedtextsPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.StructurebasedtextsPackageImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextverticalizationfPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextverticalizationfPackageImpl;

import org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Case004PackageImpl extends EPackageImpl implements Case004Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass a4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b4HasConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass c4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass d4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass f4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass a4SubEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass d4SubEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass c4SubEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass f4SubEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasCsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composesCsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composesBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composesCsOrderedEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Case004PackageImpl() {
		super(eNS_URI, Case004Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Case004Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Case004Package init() {
		if (isInited) return (Case004Package)EPackage.Registry.INSTANCE.getEPackage(Case004Package.eNS_URI);

		// Obtain or create and register package
		Case004PackageImpl theCase004Package = (Case004PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Case004PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Case004PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TextverticalizationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Case001PackageImpl theCase001Package = (Case001PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case001Package.eNS_URI) instanceof Case001PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case001Package.eNS_URI) : Case001Package.eINSTANCE);
		Case002PackageImpl theCase002Package = (Case002PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case002Package.eNS_URI) instanceof Case002PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case002Package.eNS_URI) : Case002Package.eINSTANCE);
		Case003PackageImpl theCase003Package = (Case003PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case003Package.eNS_URI) instanceof Case003PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case003Package.eNS_URI) : Case003Package.eINSTANCE);
		P1PackageImpl theP1Package = (P1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(P1Package.eNS_URI) instanceof P1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(P1Package.eNS_URI) : P1Package.eINSTANCE);
		P2PackageImpl theP2Package = (P2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(P2Package.eNS_URI) instanceof P2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(P2Package.eNS_URI) : P2Package.eINSTANCE);
		P3PackageImpl theP3Package = (P3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(P3Package.eNS_URI) instanceof P3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(P3Package.eNS_URI) : P3Package.eINSTANCE);
		P4PackageImpl theP4Package = (P4PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(P4Package.eNS_URI) instanceof P4PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(P4Package.eNS_URI) : P4Package.eINSTANCE);
		Case006PackageImpl theCase006Package = (Case006PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case006Package.eNS_URI) instanceof Case006PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case006Package.eNS_URI) : Case006Package.eINSTANCE);
		Case008PackageImpl theCase008Package = (Case008PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case008Package.eNS_URI) instanceof Case008PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case008Package.eNS_URI) : Case008Package.eINSTANCE);
		InheritancePackageImpl theInheritancePackage = (InheritancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InheritancePackage.eNS_URI) instanceof InheritancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InheritancePackage.eNS_URI) : InheritancePackage.eINSTANCE);
		Case009PackageImpl theCase009Package = (Case009PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case009Package.eNS_URI) instanceof Case009PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case009Package.eNS_URI) : Case009Package.eINSTANCE);
		Case010PackageImpl theCase010Package = (Case010PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case010Package.eNS_URI) instanceof Case010PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case010Package.eNS_URI) : Case010Package.eINSTANCE);
		Case011PackageImpl theCase011Package = (Case011PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case011Package.eNS_URI) instanceof Case011PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case011Package.eNS_URI) : Case011Package.eINSTANCE);
		Case012PackageImpl theCase012Package = (Case012PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case012Package.eNS_URI) instanceof Case012PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case012Package.eNS_URI) : Case012Package.eINSTANCE);
		Case013PackageImpl theCase013Package = (Case013PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case013Package.eNS_URI) instanceof Case013PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case013Package.eNS_URI) : Case013Package.eINSTANCE);
		Case014PackageImpl theCase014Package = (Case014PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case014Package.eNS_URI) instanceof Case014PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case014Package.eNS_URI) : Case014Package.eINSTANCE);
		Case015PackageImpl theCase015Package = (Case015PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case015Package.eNS_URI) instanceof Case015PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case015Package.eNS_URI) : Case015Package.eINSTANCE);
		Case016PackageImpl theCase016Package = (Case016PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case016Package.eNS_URI) instanceof Case016PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case016Package.eNS_URI) : Case016Package.eINSTANCE);
		Case017PackageImpl theCase017Package = (Case017PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case017Package.eNS_URI) instanceof Case017PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case017Package.eNS_URI) : Case017Package.eINSTANCE);
		Case018PackageImpl theCase018Package = (Case018PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case018Package.eNS_URI) instanceof Case018PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case018Package.eNS_URI) : Case018Package.eINSTANCE);
		Case019PackageImpl theCase019Package = (Case019PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case019Package.eNS_URI) instanceof Case019PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case019Package.eNS_URI) : Case019Package.eINSTANCE);
		SerializationcallbackPackageImpl theSerializationcallbackPackage = (SerializationcallbackPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializationcallbackPackage.eNS_URI) instanceof SerializationcallbackPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializationcallbackPackage.eNS_URI) : SerializationcallbackPackage.eINSTANCE);
		TranslatabletextsPackageImpl theTranslatabletextsPackage = (TranslatabletextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TranslatabletextsPackage.eNS_URI) instanceof TranslatabletextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TranslatabletextsPackage.eNS_URI) : TranslatabletextsPackage.eINSTANCE);
		Case020PackageImpl theCase020Package = (Case020PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case020Package.eNS_URI) instanceof Case020PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case020Package.eNS_URI) : Case020Package.eINSTANCE);
		Case021PackageImpl theCase021Package = (Case021PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case021Package.eNS_URI) instanceof Case021PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case021Package.eNS_URI) : Case021Package.eINSTANCE);
		Case022PackageImpl theCase022Package = (Case022PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case022Package.eNS_URI) instanceof Case022PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case022Package.eNS_URI) : Case022Package.eINSTANCE);
		ClusteredPackageImpl theClusteredPackage = (ClusteredPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClusteredPackage.eNS_URI) instanceof ClusteredPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClusteredPackage.eNS_URI) : ClusteredPackage.eINSTANCE);
		NestedOfClusteredPackageImpl theNestedOfClusteredPackage = (NestedOfClusteredPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NestedOfClusteredPackage.eNS_URI) instanceof NestedOfClusteredPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NestedOfClusteredPackage.eNS_URI) : NestedOfClusteredPackage.eINSTANCE);
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		TopPackageImpl theTopPackage = (TopPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopPackage.eNS_URI) instanceof TopPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopPackage.eNS_URI) : TopPackage.eINSTANCE);
		NestedOfTopPackageImpl theNestedOfTopPackage = (NestedOfTopPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NestedOfTopPackage.eNS_URI) instanceof NestedOfTopPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NestedOfTopPackage.eNS_URI) : NestedOfTopPackage.eINSTANCE);
		ClusterPackageImpl theClusterPackage = (ClusterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClusterPackage.eNS_URI) instanceof ClusterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClusterPackage.eNS_URI) : ClusterPackage.eINSTANCE);
		ImporterPackageImpl theImporterPackage = (ImporterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ImporterPackage.eNS_URI) instanceof ImporterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ImporterPackage.eNS_URI) : ImporterPackage.eINSTANCE);
		ImportedPackageImpl theImportedPackage = (ImportedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ImportedPackage.eNS_URI) instanceof ImportedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ImportedPackage.eNS_URI) : ImportedPackage.eINSTANCE);
		Case023PackageImpl theCase023Package = (Case023PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case023Package.eNS_URI) instanceof Case023PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case023Package.eNS_URI) : Case023Package.eINSTANCE);
		Case024PackageImpl theCase024Package = (Case024PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case024Package.eNS_URI) instanceof Case024PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case024Package.eNS_URI) : Case024Package.eINSTANCE);
		Case025PackageImpl theCase025Package = (Case025PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case025Package.eNS_URI) instanceof Case025PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case025Package.eNS_URI) : Case025Package.eINSTANCE);
		Case026PackageImpl theCase026Package = (Case026PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case026Package.eNS_URI) instanceof Case026PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case026Package.eNS_URI) : Case026Package.eINSTANCE);
		Case001fPackageImpl theCase001fPackage = (Case001fPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case001fPackage.eNS_URI) instanceof Case001fPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case001fPackage.eNS_URI) : Case001fPackage.eINSTANCE);
		Case003fPackageImpl theCase003fPackage = (Case003fPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case003fPackage.eNS_URI) instanceof Case003fPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case003fPackage.eNS_URI) : Case003fPackage.eINSTANCE);
		Case004fPackageImpl theCase004fPackage = (Case004fPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case004fPackage.eNS_URI) instanceof Case004fPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case004fPackage.eNS_URI) : Case004fPackage.eINSTANCE);
		Case005fPackageImpl theCase005fPackage = (Case005fPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Case005fPackage.eNS_URI) instanceof Case005fPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Case005fPackage.eNS_URI) : Case005fPackage.eINSTANCE);
		StructurebasedtextsPackageImpl theStructurebasedtextsPackage = (StructurebasedtextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurebasedtextsPackage.eNS_URI) instanceof StructurebasedtextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurebasedtextsPackage.eNS_URI) : StructurebasedtextsPackage.eINSTANCE);
		ClassbasedtextsPackageImpl theClassbasedtextsPackage = (ClassbasedtextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassbasedtextsPackage.eNS_URI) instanceof ClassbasedtextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassbasedtextsPackage.eNS_URI) : ClassbasedtextsPackage.eINSTANCE);
		TextverticalizationfPackageImpl theTextverticalizationfPackage = (TextverticalizationfPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextverticalizationfPackage.eNS_URI) instanceof TextverticalizationfPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextverticalizationfPackage.eNS_URI) : TextverticalizationfPackage.eINSTANCE);

		// Create package meta-data objects
		theCase004Package.createPackageContents();
		theCase001Package.createPackageContents();
		theCase002Package.createPackageContents();
		theCase003Package.createPackageContents();
		theP1Package.createPackageContents();
		theP2Package.createPackageContents();
		theP3Package.createPackageContents();
		theP4Package.createPackageContents();
		theCase006Package.createPackageContents();
		theCase008Package.createPackageContents();
		theInheritancePackage.createPackageContents();
		theCase009Package.createPackageContents();
		theCase010Package.createPackageContents();
		theCase011Package.createPackageContents();
		theCase012Package.createPackageContents();
		theCase013Package.createPackageContents();
		theCase014Package.createPackageContents();
		theCase015Package.createPackageContents();
		theCase016Package.createPackageContents();
		theCase017Package.createPackageContents();
		theCase018Package.createPackageContents();
		theCase019Package.createPackageContents();
		theSerializationcallbackPackage.createPackageContents();
		theTranslatabletextsPackage.createPackageContents();
		theCase020Package.createPackageContents();
		theCase021Package.createPackageContents();
		theCase022Package.createPackageContents();
		theClusteredPackage.createPackageContents();
		theNestedOfClusteredPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theTopPackage.createPackageContents();
		theNestedOfTopPackage.createPackageContents();
		theClusterPackage.createPackageContents();
		theImporterPackage.createPackageContents();
		theImportedPackage.createPackageContents();
		theCase023Package.createPackageContents();
		theCase024Package.createPackageContents();
		theCase025Package.createPackageContents();
		theCase026Package.createPackageContents();
		theCase001fPackage.createPackageContents();
		theCase003fPackage.createPackageContents();
		theCase004fPackage.createPackageContents();
		theCase005fPackage.createPackageContents();
		theStructurebasedtextsPackage.createPackageContents();
		theClassbasedtextsPackage.createPackageContents();
		theTextverticalizationfPackage.createPackageContents();

		// Initialize created meta-data
		theCase004Package.initializePackageContents();
		theCase001Package.initializePackageContents();
		theCase002Package.initializePackageContents();
		theCase003Package.initializePackageContents();
		theP1Package.initializePackageContents();
		theP2Package.initializePackageContents();
		theP3Package.initializePackageContents();
		theP4Package.initializePackageContents();
		theCase006Package.initializePackageContents();
		theCase008Package.initializePackageContents();
		theInheritancePackage.initializePackageContents();
		theCase009Package.initializePackageContents();
		theCase010Package.initializePackageContents();
		theCase011Package.initializePackageContents();
		theCase012Package.initializePackageContents();
		theCase013Package.initializePackageContents();
		theCase014Package.initializePackageContents();
		theCase015Package.initializePackageContents();
		theCase016Package.initializePackageContents();
		theCase017Package.initializePackageContents();
		theCase018Package.initializePackageContents();
		theCase019Package.initializePackageContents();
		theSerializationcallbackPackage.initializePackageContents();
		theTranslatabletextsPackage.initializePackageContents();
		theCase020Package.initializePackageContents();
		theCase021Package.initializePackageContents();
		theCase022Package.initializePackageContents();
		theClusteredPackage.initializePackageContents();
		theNestedOfClusteredPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theTopPackage.initializePackageContents();
		theNestedOfTopPackage.initializePackageContents();
		theClusterPackage.initializePackageContents();
		theImporterPackage.initializePackageContents();
		theImportedPackage.initializePackageContents();
		theCase023Package.initializePackageContents();
		theCase024Package.initializePackageContents();
		theCase025Package.initializePackageContents();
		theCase026Package.initializePackageContents();
		theCase001fPackage.initializePackageContents();
		theCase003fPackage.initializePackageContents();
		theCase004fPackage.initializePackageContents();
		theCase005fPackage.initializePackageContents();
		theStructurebasedtextsPackage.initializePackageContents();
		theClassbasedtextsPackage.initializePackageContents();
		theTextverticalizationfPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCase004Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Case004Package.eNS_URI, theCase004Package);
		return theCase004Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getA4() {
		return a4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_OnePrimitive() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_OnePrimitiveOptional() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_OnePrimitiveNotChangeable() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitive() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveDouble() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveUnique() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveOptional() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveNotChangeable() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveOrdered() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveOrderedUnique() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getA4_ManyPrimitiveOrderedNotChangeable() {
		return (EAttribute)a4EClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_OneBChangeable() {
		return (EReference)a4EClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_OneBNotChangeable() {
		return (EReference)a4EClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_OneBOptional() {
		return (EReference)a4EClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBs() {
		return (EReference)a4EClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBsUnique() {
		return (EReference)a4EClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBsNotUnique() {
		return (EReference)a4EClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBsOrdered() {
		return (EReference)a4EClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBsOrderedUnique() {
		return (EReference)a4EClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBsNotOrdered() {
		return (EReference)a4EClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA4_ManyBsNotChangeable() {
		return (EReference)a4EClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB4HasConstant() {
		return b4HasConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getC4() {
		return c4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getC4_Primitive() {
		return (EAttribute)c4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getC4_Complex() {
		return (EReference)c4EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getD4() {
		return d4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeBoolean() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeBooleanOptional() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeDouble() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeDoubleOptional() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeFloat() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeFloatOptional() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeInteger() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeIntegerOptional() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeLong() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeLongOptional() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeString() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getD4_AttributeStringOptional() {
		return (EAttribute)d4EClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB4() {
		return b4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB4_OnePrimitive() {
		return (EAttribute)b4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getF4() {
		return f4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getF4_OneC() {
		return (EReference)f4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getF4_ManyCs() {
		return (EReference)f4EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getF4_ManyCsOrdered() {
		return (EReference)f4EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getA4Sub() {
		return a4SubEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getD4Sub() {
		return d4SubEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getC4Sub() {
		return c4SubEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getF4Sub() {
		return f4SubEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gethasCs() {
		return hasCsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gethasCs_F() {
		return (EReference)hasCsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gethasCs_C() {
		return (EReference)hasCsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcomposesCs() {
		return composesCsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcomposesCs_MyF() {
		return (EReference)composesCsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcomposesCs_MyCs() {
		return (EReference)composesCsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcomposesB() {
		return composesBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcomposesB_MyB() {
		return (EReference)composesBEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcomposesB_MyF() {
		return (EReference)composesBEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcomposesCsOrdered() {
		return composesCsOrderedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcomposesCsOrdered_MyF() {
		return (EReference)composesCsOrderedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcomposesCsOrdered_MyCsOrdered() {
		return (EReference)composesCsOrderedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case004Factory getCase004Factory() {
		return (Case004Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		a4EClass = createEClass(A4);
		createEAttribute(a4EClass, A4__ONE_PRIMITIVE);
		createEAttribute(a4EClass, A4__ONE_PRIMITIVE_OPTIONAL);
		createEAttribute(a4EClass, A4__ONE_PRIMITIVE_NOT_CHANGEABLE);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_DOUBLE);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_UNIQUE);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_OPTIONAL);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_NOT_CHANGEABLE);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_ORDERED);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_ORDERED_UNIQUE);
		createEAttribute(a4EClass, A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE);
		createEReference(a4EClass, A4__ONE_BCHANGEABLE);
		createEReference(a4EClass, A4__ONE_BNOT_CHANGEABLE);
		createEReference(a4EClass, A4__ONE_BOPTIONAL);
		createEReference(a4EClass, A4__MANY_BS);
		createEReference(a4EClass, A4__MANY_BS_UNIQUE);
		createEReference(a4EClass, A4__MANY_BS_NOT_UNIQUE);
		createEReference(a4EClass, A4__MANY_BS_ORDERED);
		createEReference(a4EClass, A4__MANY_BS_ORDERED_UNIQUE);
		createEReference(a4EClass, A4__MANY_BS_NOT_ORDERED);
		createEReference(a4EClass, A4__MANY_BS_NOT_CHANGEABLE);

		b4HasConstantEClass = createEClass(B4_HAS_CONSTANT);

		c4EClass = createEClass(C4);
		createEAttribute(c4EClass, C4__PRIMITIVE);
		createEReference(c4EClass, C4__COMPLEX);

		d4EClass = createEClass(D4);
		createEAttribute(d4EClass, D4__ATTRIBUTE_BOOLEAN);
		createEAttribute(d4EClass, D4__ATTRIBUTE_BOOLEAN_OPTIONAL);
		createEAttribute(d4EClass, D4__ATTRIBUTE_DOUBLE);
		createEAttribute(d4EClass, D4__ATTRIBUTE_DOUBLE_OPTIONAL);
		createEAttribute(d4EClass, D4__ATTRIBUTE_FLOAT);
		createEAttribute(d4EClass, D4__ATTRIBUTE_FLOAT_OPTIONAL);
		createEAttribute(d4EClass, D4__ATTRIBUTE_INTEGER);
		createEAttribute(d4EClass, D4__ATTRIBUTE_INTEGER_OPTIONAL);
		createEAttribute(d4EClass, D4__ATTRIBUTE_LONG);
		createEAttribute(d4EClass, D4__ATTRIBUTE_LONG_OPTIONAL);
		createEAttribute(d4EClass, D4__ATTRIBUTE_STRING);
		createEAttribute(d4EClass, D4__ATTRIBUTE_STRING_OPTIONAL);

		b4EClass = createEClass(B4);
		createEAttribute(b4EClass, B4__ONE_PRIMITIVE);

		f4EClass = createEClass(F4);
		createEReference(f4EClass, F4__ONE_C);
		createEReference(f4EClass, F4__MANY_CS);
		createEReference(f4EClass, F4__MANY_CS_ORDERED);

		a4SubEClass = createEClass(A4_SUB);

		d4SubEClass = createEClass(D4_SUB);

		c4SubEClass = createEClass(C4_SUB);

		f4SubEClass = createEClass(F4_SUB);

		hasCsEClass = createEClass(HAS_CS);
		createEReference(hasCsEClass, HAS_CS__F);
		createEReference(hasCsEClass, HAS_CS__C);

		composesCsEClass = createEClass(COMPOSES_CS);
		createEReference(composesCsEClass, COMPOSES_CS__MY_F);
		createEReference(composesCsEClass, COMPOSES_CS__MY_CS);

		composesBEClass = createEClass(COMPOSES_B);
		createEReference(composesBEClass, COMPOSES_B__MY_B);
		createEReference(composesBEClass, COMPOSES_B__MY_F);

		composesCsOrderedEClass = createEClass(COMPOSES_CS_ORDERED);
		createEReference(composesCsOrderedEClass, COMPOSES_CS_ORDERED__MY_F);
		createEReference(composesCsOrderedEClass, COMPOSES_CS_ORDERED__MY_CS_ORDERED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		a4SubEClass.getESuperTypes().add(this.getA4());
		d4SubEClass.getESuperTypes().add(this.getD4());
		c4SubEClass.getESuperTypes().add(this.getC4());
		f4SubEClass.getESuperTypes().add(this.getF4());

		// Initialize classes and features; add operations and parameters
		initEClass(a4EClass, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, "A4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getA4_OnePrimitive(), ecorePackage.getEString(), "onePrimitive", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_OnePrimitiveOptional(), ecorePackage.getEString(), "onePrimitiveOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_OnePrimitiveNotChangeable(), ecorePackage.getEString(), "onePrimitiveNotChangeable", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitive(), ecorePackage.getEString(), "manyPrimitive", null, 1, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveDouble(), ecorePackage.getEDouble(), "manyPrimitiveDouble", null, 1, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveUnique(), ecorePackage.getEString(), "manyPrimitiveUnique", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveOptional(), ecorePackage.getEString(), "manyPrimitiveOptional", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveNotChangeable(), ecorePackage.getEString(), "manyPrimitiveNotChangeable", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveOrdered(), ecorePackage.getEString(), "manyPrimitiveOrdered", null, 1, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveOrderedUnique(), ecorePackage.getEString(), "manyPrimitiveOrderedUnique", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getA4_ManyPrimitiveOrderedNotChangeable(), ecorePackage.getEString(), "manyPrimitiveOrderedNotChangeable", null, 1, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_OneBChangeable(), this.getB4(), null, "oneBChangeable", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_OneBNotChangeable(), this.getB4(), null, "oneBNotChangeable", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_OneBOptional(), this.getB4(), null, "oneBOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBs(), this.getB4(), null, "manyBs", null, 1, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBsUnique(), this.getB4(), null, "manyBsUnique", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBsNotUnique(), this.getB4(), null, "manyBsNotUnique", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBsOrdered(), this.getB4(), null, "manyBsOrdered", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBsOrderedUnique(), this.getB4(), null, "manyBsOrderedUnique", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBsNotOrdered(), this.getB4(), null, "manyBsNotOrdered", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getA4_ManyBsNotChangeable(), this.getB4(), null, "manyBsNotChangeable", null, 0, -1, org.eclipse.emf.query2.test.mm.testcases.case004.A4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(b4HasConstantEClass, B4HasConstant.class, "B4HasConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(c4EClass, org.eclipse.emf.query2.test.mm.testcases.case004.C4.class, "C4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getC4_Primitive(), ecorePackage.getEString(), "primitive", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.C4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getC4_Complex(), this.getB4(), null, "complex", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.C4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(d4EClass, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, "D4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getD4_AttributeBoolean(), ecorePackage.getEBoolean(), "attributeBoolean", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeBooleanOptional(), ecorePackage.getEBooleanObject(), "attributeBooleanOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeDouble(), ecorePackage.getEDouble(), "attributeDouble", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeDoubleOptional(), ecorePackage.getEDoubleObject(), "attributeDoubleOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeFloat(), ecorePackage.getEFloat(), "attributeFloat", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeFloatOptional(), ecorePackage.getEFloatObject(), "attributeFloatOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeInteger(), ecorePackage.getEInt(), "attributeInteger", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeIntegerOptional(), ecorePackage.getEIntegerObject(), "attributeIntegerOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeLong(), ecorePackage.getELong(), "attributeLong", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeLongOptional(), ecorePackage.getELongObject(), "attributeLongOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeString(), ecorePackage.getEString(), "attributeString", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getD4_AttributeStringOptional(), ecorePackage.getEString(), "attributeStringOptional", null, 0, 1, org.eclipse.emf.query2.test.mm.testcases.case004.D4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(b4EClass, org.eclipse.emf.query2.test.mm.testcases.case004.B4.class, "B4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getB4_OnePrimitive(), ecorePackage.getEString(), "onePrimitive", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.B4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(f4EClass, org.eclipse.emf.query2.test.mm.testcases.case004.F4.class, "F4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getF4_OneC(), this.getC4(), null, "oneC", null, 1, 1, org.eclipse.emf.query2.test.mm.testcases.case004.F4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getF4_ManyCs(), this.getC4(), null, "manyCs", null, 0, 6, org.eclipse.emf.query2.test.mm.testcases.case004.F4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getF4_ManyCsOrdered(), this.getC4(), null, "manyCsOrdered", null, 2, 6, org.eclipse.emf.query2.test.mm.testcases.case004.F4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(a4SubEClass, A4Sub.class, "A4Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(d4SubEClass, D4Sub.class, "D4Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(c4SubEClass, C4Sub.class, "C4Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(f4SubEClass, F4Sub.class, "F4Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(hasCsEClass, hasCs.class, "hasCs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(gethasCs_F(), this.getF4(), null, "f", null, 1, 1, hasCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(gethasCs_C(), this.getC4(), null, "c", null, 1, -1, hasCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(composesCsEClass, composesCs.class, "composesCs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getcomposesCs_MyF(), this.getF4(), null, "myF", null, 1, 1, composesCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getcomposesCs_MyCs(), this.getC4(), null, "myCs", null, 1, -1, composesCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(composesBEClass, composesB.class, "composesB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getcomposesB_MyB(), this.getB4(), null, "myB", null, 1, 1, composesB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getcomposesB_MyF(), this.getF4(), null, "myF", null, 1, 1, composesB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(composesCsOrderedEClass, composesCsOrdered.class, "composesCsOrdered", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getcomposesCsOrdered_MyF(), this.getF4(), null, "myF", null, 1, 1, composesCsOrdered.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getcomposesCsOrdered_MyCsOrdered(), this.getC4(), null, "myCsOrdered", null, 1, -1, composesCsOrdered.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://sap.com/MOIN
		createMOINAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://sap.com/MOIN</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMOINAnnotations() {
		String source = "http://sap.com/MOIN"; //$NON-NLS-1$		
		addAnnotation
		  (a4EClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.A4", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A5BFE73C9EE91342E2330BAC6ECFF5FD7B", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false", //$NON-NLS-1$ //$NON-NLS-2$
			 "ova", "oneBChangeable,oneBNotChangeable,oneBOptional,manyBs,manyBsUnique,manyBsNotUnique,manyBsOrdered,manyBsOrderedUnique,manyBsNotOrdered,manyBsNotChangeable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_OneBChangeable(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A59E053A7CCB9140B33D738C63376B7BDB" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_OneBNotChangeable(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A5EB2E83B38E4644363B9CAE099F6033F7" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_OneBOptional(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A551FC35AC82334CAF1519B5ED9DDD2096" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBs(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A57DA8BB49CF5B47983FA1A45F5E91D2DE" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBsUnique(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A565D45E9A88DD4BA315E19173DF06DF60" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBsNotUnique(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A5693C70876E9E495D119EF9800F569335" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBsOrdered(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A543274D5F28604E88142CF00FFE5DBC62" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBsOrderedUnique(), 
		   source, 
		   new String[] {
			 "ovaMofId", "48074A15595702700C7E11DDA61E001558C93B47" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBsNotOrdered(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A5227DAD86E98C4A3F2D48AD7E8D700E98" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getA4_ManyBsNotChangeable(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A51D4A8A489392435B217AD4287C995D41" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (b4HasConstantEClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.B4HasConstant", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A5ECBF600F9C974CE028E99F7E71D897B9", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (c4EClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.C4", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A5D3165AD162A141EB0547FC4EA865B99D", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false", //$NON-NLS-1$ //$NON-NLS-2$
			 "ova", "complex" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getC4_Complex(), 
		   source, 
		   new String[] {
			 "ovaMofId", "4761229E3CA757E0A97511DCBB6F001558C93B47" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (d4EClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.D4", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A51C4DF4D33B9E466C1A02AC4DB4284CCF", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (b4EClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.B4", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A5CE8778345E6E45142026DF2289212782", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (f4EClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.F4", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A57E4CF493F2554D201E5B9259CB1A21D7", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false", //$NON-NLS-1$ //$NON-NLS-2$
			 "ova", "oneC,manyCs,manyCsOrdered" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getF4_OneC(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A51A63D23BE4E54B8621B9EEB51955EEB3" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getF4_ManyCs(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F120A538562EABE12843AB3230C31F8795F1E7" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getF4_ManyCsOrdered(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45F574532E5DE60511534D7226BCA43F235EFDF9" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (a4SubEClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.A4Sub", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "48DBA8AC5C55CFB08B1311DDAB760019992F8D38", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false", //$NON-NLS-1$ //$NON-NLS-2$
			 "ova", "oneBChangeable,oneBNotChangeable,oneBOptional,manyBs,manyBsUnique,manyBsNotUnique,manyBsOrdered,manyBsOrderedUnique,manyBsNotOrdered,manyBsNotChangeable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (d4SubEClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.D4Sub", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "48DBA8AC5C5644E08B1311DDA6FA0019992F8D38", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (c4SubEClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.C4Sub", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "48DCF7E128F905108BDB11DDB1C40019992F8D38", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false", //$NON-NLS-1$ //$NON-NLS-2$
			 "ova", "complex" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (f4SubEClass, 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.F4Sub", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "48DCF7E128F905118BDB11DDB8780019992F8D38", //$NON-NLS-1$ //$NON-NLS-2$
			 "isStructureType", "false", //$NON-NLS-1$ //$NON-NLS-2$
			 "ova", "oneC,manyCs,manyCsOrdered" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (gethasCs_F(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.hasCs", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A5E076DC0D97AA4A8F163B8EF194C6281F", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "0" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (gethasCs_C(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.hasCs", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F120A5E076DC0D97AA4A8F163B8EF194C6281F", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getcomposesCs_MyF(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.composesCs", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F5408B488ADA49AEFE4ECB2315B0BC92517FC7", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "0" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getcomposesCs_MyCs(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.composesCs", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F5408B488ADA49AEFE4ECB2315B0BC92517FC7", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getcomposesB_MyB(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.composesB", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F5408B0CC203861ACB47432D8EF68CCD4F5E39", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "0" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getcomposesB_MyF(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.composesB", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F5408B0CC203861ACB47432D8EF68CCD4F5E39", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "-1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getcomposesCsOrdered_MyF(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.composesCsOrdered", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F56B677CF18E3395C244F203B9EB5C2158434A", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "0" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getcomposesCsOrdered_MyCsOrdered(), 
		   source, 
		   new String[] {
			 "metamodels", "test.sap.com/tc/moin/metamodel/testcases[1.0.0]", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObject", "testcases.case004.composesCsOrdered", //$NON-NLS-1$ //$NON-NLS-2$
			 "metaObjectMofId", "45F56B677CF18E3395C244F203B9EB5C2158434A", //$NON-NLS-1$ //$NON-NLS-2$
			 "storedEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "compositeEnd", "0", //$NON-NLS-1$ //$NON-NLS-2$
			 "orderedEnd", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "exposedEndNumber", "1" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //Case004PackageImpl
