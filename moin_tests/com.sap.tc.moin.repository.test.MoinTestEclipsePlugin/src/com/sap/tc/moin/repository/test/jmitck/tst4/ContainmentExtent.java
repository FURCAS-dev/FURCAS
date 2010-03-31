package com.sap.tc.moin.repository.test.jmitck.tst4;

import java.util.Arrays;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.RepositoryLoader;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.ClassInTopLevel;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.ContainmentPackage;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.inner2containment.ClassInInner2;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.inner2containment.Inner2ContainmentPackage;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.ClassInInner;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.InnerContainmentPackage;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.deepcontainment.ClassInDeep;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.deepcontainment.DeepContainmentPackage;
import com.sap.tc.moin.repository.test.jmitck.tst5.importable.ClassInImportable;
import com.sap.tc.moin.repository.test.jmitck.tst5.importable.ImportablePackage;
import com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.ClassInInnerImportable;
import com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.ColorKindEnum;
import com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.InnerImportablePackage;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.ClassInPkg2;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.MultiInheriting;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Pkg2Package;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.pkg2basepkg.BaseClassInInnerPkg;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.pkg2basepkg.Pkg2BasePkgPackage;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.pkg2innerpkga.ClassAinInnerPkgA;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.pkg2innerpkga.Pkg2InnerPkgAPackage;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.pkg2innerpkgb.ClassBinInnerPkgB;
import com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.pkg2innerpkgb.Pkg2InnerPkgBPackage;
import com.sap.tc.moin.repository.test.jmitck.tst7.pkg1.ClassInPkg1;
import com.sap.tc.moin.repository.test.jmitck.tst7.pkg1.Pkg1Package;
import com.sap.tc.moin.repository.test.jmitck.tst7.pkg1.pkg1innerpkg.ClassInInnerPkg;
import com.sap.tc.moin.repository.test.jmitck.tst7.pkg1.pkg1innerpkg.Pkg1InnerPkgPackage;

/**
 * Provides a representation of the ContainmentPackage extent, with a number of
 * elements from the extent available as public fields.
 * <p>
 * The purpose of the Class is to allow multiple tests to create the same set of
 * elements in the extent, and directly access them as fields. Since the created
 * objects are in the extent, they are also available by navigating through the
 * RefPackages, RefClasses, etc. However, this Class is provided so (a) those
 * methods are not required (in case those very methods are being tested; and
 * (b) convenience, since JMI doesn't have much for "finder" methods or
 * mechanisms.
 */
@SuppressWarnings( "nls" )
public class ContainmentExtent {

    public ContainmentPackage containmentPkg;

    public ImportablePackage importablePkg;

    public InnerContainmentPackage innerContainmentPkg;

    public DeepContainmentPackage deepContainmentPkg;

    public Inner2ContainmentPackage inner2ContainmentPkg;

    public InnerImportablePackage innerImportablePkg;

    public Pkg1Package pkg1Pkg;

    public Pkg2Package pkg2Pkg;

    public Pkg1InnerPkgPackage pkg1InnerPkgPackage;

    public Pkg2BasePkgPackage pkg2BasePkgPackage;

    public Pkg2InnerPkgAPackage pkg2InnerPkgAPackage;

    public Pkg2InnerPkgBPackage pkg2InnerPkgBPackage;

    public RefClass classInTopLevelClass;

    public RefClass classInInnerClass;

    public ClassInTopLevel classInTopLevel1;

    public ClassInTopLevel classInTopLevel2;

    public ClassInInner classInInner1;

    public ClassInInner classInInner2;

    public RefClass classInDeepClass;

    public ClassInDeep classInDeep1;

    public ClassInDeep classInDeep2;

    public RefClass classInInner2Class;

    public ClassInInner2 classInInner2_1;

    public ClassInInner2 classInInner2_2;

    public RefClass classInImportableClass;

    public ClassInImportable classInImportable1;

    public ClassInImportable classInImportable2;

    public RefClass classInInnerImportableClass;

    public ClassInInnerImportable classInInnerImportable1;

    public ClassInInnerImportable classInInnerImportable2;

    public RefClass classInPkg1Class;

    public ClassInPkg1 classInPkg1;

    public RefClass classInInnerPkgClass;

    public ClassInInnerPkg classInInnerPkg;

    public RefClass classInPkg2Class;

    public ClassInPkg2 classInPkg2;

    public RefClass multiInheritingClass;

    public MultiInheriting multiInheriting;

    public RefClass baseClassInInnerPkgClass;

    public BaseClassInInnerPkg baseClassInInnerPkg;

    public RefClass classAinInnerPkgAClass;

    public ClassAinInnerPkgA classAinInnerPkgA;

    public RefClass classBinInnerPkgBClass;

    public ClassBinInnerPkgB classBinInnerPkgB;

    /**
     * Create a the instances of the ContainmentPackage extent represented by
     * the public fields of this class.
     * 
     * @param contPkg a <code>ContainmentPackage</code> for the extent
     * @return a <code>ContainmentExtent</code> an instance of this class, with
     * the fields assigned to the found RefBaseObjects andcreated instances.
     */
    public static ContainmentExtent makeExtent( ContainmentPackage contPkg ) {

        ContainmentExtent ce = new ContainmentExtent( );
        ce.createInstances( contPkg );
        return ce;
    }

    @SuppressWarnings( "deprecation" )
    private void createInstances( ContainmentPackage contPkg ) {

        this.containmentPkg = contPkg;
        importablePkg = (ImportablePackage) RepositoryLoader.getInstance( ).getVendorGenerator( ).createRefPackage( "Importable", "com.sap.tc.moin.repository.test.jmitck.tst5" );
        StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point> containerInnercontainmentPoint = new StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point>( );
        StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point> containerContainmentPoint = new StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point>( );
        StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.Point> containerInnerimportablePoint = new StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.Point>( );
        StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Point> containerPk2Point = new StructureFieldContainer<com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Point>( );
        //lifecycle-dependency
        innerContainmentPkg = containmentPkg.getInnerContainment( );
        deepContainmentPkg = innerContainmentPkg.getDeepContainment( );
        inner2ContainmentPkg = containmentPkg.getInner2Containment( );
        innerImportablePkg = importablePkg.getInnerImportable( );

        pkg1Pkg = containmentPkg.getPkg1( );
        pkg2Pkg = containmentPkg.getPkg2( );

        pkg1InnerPkgPackage = pkg1Pkg.getPkg1InnerPkg( );

        pkg2InnerPkgAPackage = pkg2Pkg.getPkg2InnerPkgA( );
        pkg2InnerPkgBPackage = pkg2Pkg.getPkg2InnerPkgB( );
        pkg2BasePkgPackage = pkg2Pkg.getPkg2BasePkg( );

        classInTopLevelClass = containmentPkg.getClassInTopLevel( );
        classInInnerClass = innerContainmentPkg.getClassInInner( );
        com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point p = null;

        classInTopLevel1 = (ClassInTopLevel) classInTopLevelClass.refCreateInstance( Arrays.asList( "Born into Highest Package", p ) );

        classInTopLevel2 = (ClassInTopLevel) classInTopLevelClass.refCreateInstance( Arrays.asList( "Also in the Highest Package", p ) );

        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.X( ), 9 );
        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.COLOR( ), ColorKindEnum.RED );
        com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point pt = innerContainmentPkg.createPoint( containerInnercontainmentPoint );

        classInInner1 = (ClassInInner) classInInnerClass.refCreateInstance( Arrays.asList( "Living in Inner Package", pt ) );
        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.X( ), 99 );
        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.COLOR( ), ColorKindEnum.RED );
        pt = innerContainmentPkg.createPoint( containerInnercontainmentPoint );
        classInInner2 = (ClassInInner) classInInnerClass.refCreateInstance( Arrays.asList( "Also in Inner Package", pt ) );

        classInDeepClass = deepContainmentPkg.getClassInDeep( );

        classInDeep1 = (ClassInDeep) classInDeepClass.refCreateInstance( Arrays.asList( "Born in Deep" ) );
        classInDeep2 = (ClassInDeep) classInDeepClass.refCreateInstance( Arrays.asList( "Also in Deep" ) );

        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.X( ), 44 );
        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.COLOR( ), ColorKindEnum.BLUE );
        pt = innerContainmentPkg.createPoint( containerInnercontainmentPoint );

        containerContainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point.DESCRIPTORS.X( ), 0 );
        containerContainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point.DESCRIPTORS.Y( ), pt );
        com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point point = containmentPkg.createPoint( containerContainmentPoint );
        classInInner2Class = inner2ContainmentPkg.getClassInInner2( );
        classInInner2_1 = (ClassInInner2) classInInner2Class.refCreateInstance( Arrays.asList( point ) );

        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.X( ), 66 );
        containerInnercontainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point.DESCRIPTORS.COLOR( ), ColorKindEnum.RED );
        containerContainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point.DESCRIPTORS.X( ), -1 );
        containerContainmentPoint.put( com.sap.tc.moin.repository.test.jmitck.tst4.containment.Point.DESCRIPTORS.Y( ), innerContainmentPkg.createPoint( containerInnercontainmentPoint ) );
        point = containmentPkg.createPoint( containerContainmentPoint );
        classInInner2_2 = (ClassInInner2) classInInner2Class.refCreateInstance( Arrays.asList( point ) );

        classInImportableClass = importablePkg.getClassInImportable( );
        containerInnerimportablePoint.put( com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.Point.DESCRIPTORS.X( ), 8 );
        containerInnerimportablePoint.put( com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.Point.DESCRIPTORS.Y( ), 8 );
        classInImportable1 = (ClassInImportable) classInImportableClass.refCreateInstance( Arrays.asList( "Importable Class", innerImportablePkg.createPoint( containerInnerimportablePoint ) ) );
        containerInnerimportablePoint.put( com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.Point.DESCRIPTORS.X( ), 88 );
        containerInnerimportablePoint.put( com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.Point.DESCRIPTORS.Y( ), 88 );
        classInImportable2 = (ClassInImportable) classInImportableClass.refCreateInstance( Arrays.asList( "Another Importable  Class", innerImportablePkg.createPoint( containerInnerimportablePoint ) ) );

        classInInnerImportableClass = innerImportablePkg.getClassInInnerImportable( );
        classInInnerImportable1 = (ClassInInnerImportable) classInInnerImportableClass.refCreateInstance( Arrays.asList( "Inner Importable Class" ) );
        classInInnerImportable2 = (ClassInInnerImportable) classInInnerImportableClass.refCreateInstance( Arrays.asList( "Another Inner Importable Class" ) );

        classInPkg1Class = pkg1Pkg.getClassInPkg1( );

        containerPk2Point.put( com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Point.DESCRIPTORS.X( ), 92 );
        containerPk2Point.put( com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Point.DESCRIPTORS.ISY( ), true );
        classInPkg1 = (ClassInPkg1) classInPkg1Class.refCreateInstance( Arrays.asList( "A Class with a point", pkg2Pkg.createPoint( containerPk2Point ) ) );

        classInInnerPkgClass = pkg1InnerPkgPackage.getClassInInnerPkg( );
        classInInnerPkg = (ClassInInnerPkg) classInInnerPkgClass.refCreateInstance( Arrays.asList( "deep in the cluster" ) );

        classInPkg2Class = pkg2Pkg.getClassInPkg2( );
        containerPk2Point.put( com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Point.DESCRIPTORS.X( ), 92 );
        containerPk2Point.put( com.sap.tc.moin.repository.test.jmitck.tst6.pkg2.Point.DESCRIPTORS.ISY( ), true );
        classInPkg2 = (ClassInPkg2) classInPkg2Class.refCreateInstance( Arrays.asList( "The class in pkg2", pkg2Pkg.createPoint( containerPk2Point ) ) );

        multiInheritingClass = pkg2Pkg.getMultiInheriting( );
        multiInheriting = (MultiInheriting) multiInheritingClass.refCreateInstance( Arrays.<Object> asList( "POW1", 123456, "private", 122.15f ) );

        baseClassInInnerPkgClass = pkg2BasePkgPackage.getBaseClassInInnerPkg( );
        baseClassInInnerPkg = (BaseClassInInnerPkg) baseClassInInnerPkgClass.refCreateInstance( Arrays.asList( "base, but not abstract" ) );
        classAinInnerPkgAClass = pkg2InnerPkgAPackage.getClassAinInnerPkgA( );

        classAinInnerPkgA = (ClassAinInnerPkgA) classAinInnerPkgAClass.refCreateInstance( Arrays.asList( "This POW", "general" ) );

        classBinInnerPkgBClass = pkg2InnerPkgBPackage.getClassBinInnerPkgB( );

        classBinInnerPkgB = (ClassBinInnerPkgB) classBinInnerPkgBClass.refCreateInstance( Arrays.<Object> asList( "Another POW", 1010101 ) );

        classInTopLevel1.getInnerThings( ).add( classInInner1 );
        classInTopLevel1.getAvailableByCluster( ).add( multiInheriting );
        classInInner1.getImportedInards( ).add( classInInnerImportable1 );
        classInDeep1.setWayOutOwner( classInTopLevel1 );
        classInInner2_1.getOtherSideInners( ).add( classInInner1 );
        classInInner2.setOuterOwner( classInTopLevel1 );
    }
}
