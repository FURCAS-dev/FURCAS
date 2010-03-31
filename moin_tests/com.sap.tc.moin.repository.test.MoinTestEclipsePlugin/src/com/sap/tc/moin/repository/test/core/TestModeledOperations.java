package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.DependsOn;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.testcases.case024.A24;
import com.sap.tc.moin.testcases.case024.Case024Package;

public class TestModeledOperations extends CoreMoinTest {

    private ModelPackage modelPackage = null;

    private MofClass namespace = null;

    private MofClass generalizableElement = null;

    private MofClass classifier = null;

    private MofClass associationEnd = null;

    private MofClass mofClass = null;

    private MofClass association = null;

    private MofClass operation = null;

    private DependsOn dependsOn = null;

    private AssociationEnd attachesToEndTag = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        modelPackage = (ModelPackage) getMOINConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        namespace = (MofClass) modelPackage.getNamespace( ).refMetaObject( );
        generalizableElement = (MofClass) modelPackage.getGeneralizableElement( ).refMetaObject( );
        classifier = (MofClass) modelPackage.getClassifier( ).refMetaObject( );
        associationEnd = (MofClass) modelPackage.getAssociationEnd( ).refMetaObject( );
        mofClass = (MofClass) modelPackage.getMofClass( ).refMetaObject( );
        association = (MofClass) modelPackage.getAssociation( ).refMetaObject( );
        operation = (MofClass) modelPackage.getOperation( ).refMetaObject( );
        dependsOn = modelPackage.getDependsOn( );
        List<ModelElement> attachesToEnds = ( (Association) modelPackage.getAttachesTo( ).refMetaObject( ) ).getContents( );
        for ( ModelElement end : attachesToEnds ) {
            if ( end.getName( ).equals( "tag" ) ) {
                attachesToEndTag = (AssociationEnd) end;
                break;
            }
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        modelPackage = null;
        namespace = null;
        generalizableElement = null;
        classifier = null;
        associationEnd = null;
        mofClass = null;
        association = null;
        operation = null;
        attachesToEndTag = null;
    }

    // Test of the operations of ModelElement
    @Test
    public void testQualifiedName( ) throws Exception {

        // The MOF class "AssociationEnd" has an attribute with the name "isChangeable" which has the qualified name Model.AssociationEnd.isChangeable
        Attribute isChangeable = (Attribute) associationEnd.lookupElement( "isChangeable" );
        List<String> qn = isChangeable.getQualifiedName( );
        assertTrue( "The qualified name of the attribte \"isChangeable\" of the MOF class \"AssociationEnd\" should be \"Model.AssociationEnd.isChangeable\", but it is " + qn, qn.get( 0 ).equals( "Model" ) && qn.get( 1 ).equals( "AssociationEnd" ) && qn.get( 2 ).equals( "isChangeable" ) );
    }

    @Test
    public void testFindRequiredElements( ) {

        Collection<String> kinds = new HashSet<String>( 1 );
        // the MOF association end "tag" of the association "AttachesTo" has the MOF class "Tag" as required element for the dependency kind "type definition"
        kinds.add( ModelElement.TYPEDEFINITIONDEP );
        Collection<ModelElement> requiredElements = attachesToEndTag.findRequiredElements( kinds, false );
        assertTrue( "The end \"tag\" of the MOF association \"AttachesTo\" should have exactly one required element, but is has " + requiredElements.size( ) + ".", requiredElements.size( ) == 1 );
        ModelElement requiredElement = (ModelElement) requiredElements.iterator( ).next( );
        assertTrue( "The required element of the end \"tag\" of the MOF association \"AttachesTo\" should be the MOF class \"Tag\", but it is the element \"" + requiredElement.getName( ) + "\".", requiredElement.getName( ).equals( "Tag" ) );
        // the MOF class "Operation" contains the attribute "isQuery" and the reference "exceptions", i.e. it depends on them concerning the dependency kind "contents"
        kinds.clear( );
        kinds.add( ModelElement.CONTENTSDEP );
        requiredElements = operation.findRequiredElements( kinds, false );
        assertTrue( "The MOF class \"Operation\" should at least depend on 2 model elements, but it depends only on " + requiredElements.size( ) + ".", requiredElements.size( ) >= 2 );
        boolean expectedAttributeFound = false;
        boolean expectedReferenceFound = false;
        for ( ModelElement modelElement : requiredElements ) {
            if ( modelElement instanceof Attribute && modelElement.getName( ).equals( "isQuery" ) ) {
                expectedAttributeFound = true;
            } else if ( modelElement instanceof Reference && modelElement.getName( ).equals( "exceptions" ) ) {
                expectedReferenceFound = true;
            }
        }
        assertTrue( "The MOF class \"Operation\" should depend on an attribute with the name \"isQuery\", but it doesn't.", expectedAttributeFound );
        assertTrue( "The MOF class \"Operation\" should depend on a reference with the name \"exceptions\", but it doesn't.", expectedReferenceFound );
        // the MOF class "Namespace" contains among others the operation "lookupElement" which contains, among others, the parameter "name" and the exception "NameNotFound"
        kinds.clear( );
        kinds.add( ModelElement.CONTENTSDEP );
        requiredElements = namespace.findRequiredElements( kinds, true );
        boolean expectedParameterFound = false;
        boolean expectedExceptionFound = false;
        for ( ModelElement modelElement : requiredElements ) {
            if ( modelElement instanceof Parameter && modelElement.getName( ).equals( "name" ) ) {
                expectedParameterFound = true;
            } else if ( modelElement instanceof MofException && modelElement.getName( ).equals( "NameNotFound" ) ) {
                expectedExceptionFound = true;
            }
        }
        assertTrue( "The MOF class \"Namespace\" should recursively depend on a parameter with the name \"name\", but it doesn't.", expectedParameterFound );
        assertTrue( "The MOF class \"Namespace\" should recursively depend on an exception with the name \"NameNotFound\", but it doesn't.", expectedExceptionFound );
    }

    @Test
    public void testIsRequiredBecause( ) {

        String[] reason = new String[1];
        boolean isRequired = false;
        // the MOF Class directly subclasses the MOF Classifier, i.e. it depends on the MOF Classifier via the dependency kind "specialization"
        isRequired = mofClass.isRequiredBecause( classifier, reason );
        assertTrue( "The MOF class \"Classifier\" should be required by the MOF class \"Class\", but it isn't.", isRequired );
        assertTrue( "The dependency kind of the MOF class \"Class\" from MOF class \"Classifier\" should be \"" + ModelElement.SPECIALIZATIONDEP + "\", but it is \"" + reason[0] + "\".", reason[0].equals( ModelElement.SPECIALIZATIONDEP ) );
        // the MOF class indirectly (!) subclasses the MOF GeneralizableElement, i.e. it depends on the MOF GeneralizableElement via the dependency kind "indirect"
        isRequired = mofClass.isRequiredBecause( generalizableElement, reason );
        assertTrue( "The MOF class \"GeneralizableElement\" should be required by the MOF class \"Class\", but it isn't.", isRequired );
        assertTrue( "The dependency kind of the MOF class \"Class\" from MOF class \"GeneralizableElement\" should be \"" + ModelElement.INDIRECTDEP + "\", but it is \"" + reason[0] + "\".", reason[0].equals( ModelElement.INDIRECTDEP ) );
        // in MOF everything depends on everything, so let us create 2 classes, that do not depend on themselves
        MofClass clazz1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        clazz1.setName( "MyClass1" );
        MofClass clazz2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        clazz2.setName( "MyClass2" );
        isRequired = clazz1.isRequiredBecause( clazz2, reason );
        assertFalse( "The class \"MyClass1\" should not be required by the class \"MyClass2\", but it is.", isRequired );
        assertTrue( "The dependency kind of the class \"MyClass1\" from class \"MyClass2\" should be \"\", but it is \"" + reason[0] + "\".", reason[0].equals( "" ) );
    }

    @Test
    public void testIsFrozen( ) {

        // create a new class in a partition
        MofClass clazz = (MofClass) modelPackage.getMofClass( ).refCreateInstanceInPartition( getPartitionOne( ) );
        // an element is frozen if its partition is not editable and vice versa
        // The new class is in an editable partition and is therefore not frozen
        assertFalse( "The new class should not be frozen, but it is.", clazz.isFrozen( ) );
        // the partition of the MOF Class is in the metamodel data area which is by definition not editable, i.e. the MOF class is frozen
        assertTrue( "The MOF class \"Class\" should be frozen, but it isn't.", mofClass.isFrozen( ) );
    }

    @Test
    public void testIsVisible( ) {

        // everything is visible from everywhere
        // test it here with the MOF Class and the MOF Association, both should be visible by each other
        assertTrue( "The MOF class \"Association\" should be visible from the MOF class \"Class\", but it isn't.", mofClass.isVisible( association ) );
        assertTrue( "The MOF class \"Class\" should be visible from the MOF class \"Association\", but it isn't.", association.isVisible( mofClass ) );
    }

    // Test of the operations of Namespace
    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testLookupElement()}
     */
    public void testLookupElement( ) {

    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testResolveQualifiedName()}
     */
    public void testResolveQualifiedName( ) {

    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testFindElementsByType()}
     */
    public void testFindElementsByType( ) {

    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testNameIsValid()}
     */
    public void testNameIsValid( ) {

    }

    // Test of the operations of GeneralizableElement
    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testAllSupertypes()}
     */
    public void testAllSupertypes( ) {

    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testLookupElementExtended()}
     */
    public void testLookupElementExtended( ) {

    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testFindElementsByTypeExtended()}
     */
    public void testFindElementsByTypeExtended( ) {

    }

    // Test of the operations of AssociationEnd
    /**
     * See
     * {@link com.sap.tc.moin.repository.test.core.TestMofRom#testOtherEnd()}
     */
    public void testOtherEnd( ) {

    }

    // Test of the operations of the derived association DependsOn
    @Test
    public void testDependent( ) throws Exception {

        // the MOF exception "NameNotResolved" is thrown, among others, by the operation "resolveQualifiedName" of the MOF class "Namespace"
        // i.e. "NameNotResolved" has "resolveQualifiedName" as dependent with the dependency kind "signature"
        // or equivalently, the exception "NameNotResolved" is the provider of "resolveQualifiedName",
        // or equivalently, the operation "resolveQualifiedName" depends on "NameNotResolved"
        MofException nameNotResolved = (MofException) namespace.lookupElement( "NameNotResolved" );
        Collection<ModelElement> dependent = dependsOn.getDependent( nameNotResolved );
        Operation expectedDependent = null;
        for ( ModelElement modelElement : dependent ) {
            if ( modelElement instanceof Operation && modelElement.getName( ).equals( "resolveQualifiedName" ) ) {
                expectedDependent = (Operation) modelElement;
                break;
            }
        }
        assertTrue( "The MOF exception \"NameNotResolved\" should have the operation \"resolveQualifiedName\" of the MOF class \"Namespace\" as one of its dependents, but it hasn't.", expectedDependent != null );
        String[] reason = new String[1];
        expectedDependent.isRequiredBecause( nameNotResolved, reason );
        assertTrue( "The dependency kind of the operation \"resolveQualifiedName\" of the MOF class \"Namespace\" from MOF exception \"NameNotResolved\" should be \"" + ModelElement.SIGNATUREDEP + "\", but it is \"" + reason[0] + "\".", reason[0].equals( ModelElement.SIGNATUREDEP ) );
    }

    @Test
    public void testProvider( ) {

        // the MOF association end "tag" of the association "AttachesTo" has the MOF class "Tag" as provider among others
        Collection<ModelElement> provider = dependsOn.getProvider( attachesToEndTag );
        MofClass expectedProvider = null;
        for ( ModelElement modelElement : provider ) {
            if ( modelElement instanceof MofClass && modelElement.getName( ).equals( "Tag" ) ) {
                expectedProvider = (MofClass) modelElement;
            }
        }
        assertTrue( "The end \"tag\" of the MOF association \"AttachesTo\" should have the MOF class \"Tag\" as one of its providers, but it hasn't.", expectedProvider != null );
        String[] reason = new String[1];
        attachesToEndTag.isRequiredBecause( expectedProvider, reason );
        assertTrue( "The dependency kind of the end \"tag\" of the MOF association \"AttachesTo\" from MOF class \"Tag\" should be \"" + ModelElement.TYPEDEFINITIONDEP + "\", but it is \"" + reason[0] + "\".", reason[0].equals( ModelElement.TYPEDEFINITIONDEP ) );
    }

    // Test of the operations of the derived association Exposes
    /**
     * See {@link com.sap.tc.moin.repository.test.core.TestMofRom#testExposes()}
     */
    public void testExposedEnd( ) {

    }

    /**
     * See {@link com.sap.tc.moin.repository.test.core.TestMofRom#testExposes()}
     */
    public void testReferrer( ) {

    }

    /**
     * See {@link com.sap.tc.moin.repository.test.core.TestMofRom#testExposes()}
     */
    public void testAddReferrerExposedEnd( ) {

    }

    /**
     * See {@link com.sap.tc.moin.repository.test.core.TestMofRom#testExposes()}
     */
    public void testRemoveReferrerExposedEnd( ) {

    }

    @Test
    public void testModeledOperationWithJmiCallsInside( ) throws Exception {

        A24 a24 = getPartitionOne( ).createElement( A24.class );
        a24.testJmiCalls( a24 );

        Connection c = getMOINConnection( );

        OclRegistryService regsrv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = regsrv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( Case024Package.PACKAGE_DESCRIPTOR );
        RefPackage[] types = new RefPackage[] { targetPackage };

        //Listener needs to be registered because otherwise the constraints are not checked at all
        DeferredConstraintViolationListener errorlistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                //nothing needs to be done
            }

        };

        String errorCategory = "MyErrorCategory";
        registry.registerDeferredConstraintViolationListenerForPartitions( errorCategory, errorlistener );
        RefClass a24Class = c.getClass( A24.CLASS_DESCRIPTOR );
        registry.createInvariantRegistration( "A24InvariantError", "inv: self.testJmiCalls(self)", OclRegistrationSeverity.Error, new String[] { errorCategory }, a24Class, types );

        A24 a24InNullPartition = c.createElementInPartition( A24.class, null );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( ( (Partitionable) a24InNullPartition ).get___Partition( ).getPri( ) );
        regsrv.analyzeModelPartitions( errorCategory, partitions );

    }
}
