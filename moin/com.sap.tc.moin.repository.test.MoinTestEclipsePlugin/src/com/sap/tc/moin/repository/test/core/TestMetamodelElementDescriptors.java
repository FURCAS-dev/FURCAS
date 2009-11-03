package com.sap.tc.moin.repository.test.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;

import org.junit.Test;

import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.OperationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.S8;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case008.inheritance.InheritancePackage;
import com.sap.tc.moin.testcases.case008.inheritance.SubStructure1;
import com.sap.tc.moin.testcases.case008.inheritance.SuperStructure1;

public class TestMetamodelElementDescriptors extends CoreMoinTest {

    @Test
    public void testMetamodelElementDescriptors( ) throws Exception {

        AttributeDescriptor<Attribute, ModelElement, String> annotation = MofClass.DESCRIPTORS.ANNOTATION( );
        assertNotNull( annotation );

        ReferenceDescriptor<Reference, Namespace, List<ModelElement>> contents = MofClass.DESCRIPTORS.CONTENTS( );
        assertNotNull( contents );

        OperationDescriptor<Operation, GeneralizableElement, List<GeneralizableElement>> allSupertypes = MofClass.DESCRIPTORS.ALL_SUPERTYPES( );
        assertNotNull( allSupertypes );

        Attribute attribute = getMOINConnection( ).getMetamodelElement( annotation );
        assertNotNull( attribute );
        assertEquals( attribute.refMofId( ), annotation.getMofId( ) );
        List<String> qualifiedName = attribute.getQualifiedName( );
        for ( int i = 0, n = qualifiedName.size( ); i < n; i++ ) {
            assertEquals( qualifiedName.get( i ), annotation.getQualifiedName( )[i] );
        }

        Reference reference = getMOINConnection( ).getMetamodelElement( contents );
        assertNotNull( reference );
        assertEquals( reference.refMofId( ), contents.getMofId( ) );
        qualifiedName = reference.getQualifiedName( );
        for ( int i = 0, n = qualifiedName.size( ); i < n; i++ ) {
            assertEquals( qualifiedName.get( i ), contents.getQualifiedName( )[i] );
        }

        Operation operation = getMOINConnection( ).getMetamodelElement( allSupertypes );
        assertNotNull( operation );
        assertEquals( operation.refMofId( ), allSupertypes.getMofId( ) );
        qualifiedName = operation.getQualifiedName( );
        for ( int i = 0, n = qualifiedName.size( ); i < n; i++ ) {
            assertEquals( qualifiedName.get( i ), allSupertypes.getQualifiedName( )[i] );
        }
    }

    @Test
    public void testDescriptorsContainers( ) throws Exception {

        // Create field container for type "MultiplicityType"
        StructureFieldContainer<MultiplicityType> multCont = new StructureFieldContainer<MultiplicityType>( );

        // Fill Container with data
        multCont.put( MultiplicityType.DESCRIPTORS.IS_ORDERED( ), true ).put( MultiplicityType.DESCRIPTORS.LOWER( ), 1 ).put( MultiplicityType.DESCRIPTORS.UPPER( ), 4 ).put( MultiplicityType.DESCRIPTORS.IS_UNIQUE( ), false );

        // Check if all values are in
        Map<StructureFieldDescriptor<?, ? super MultiplicityType, ?>, Object> fields = multCont.getFields( );
        Set<StructureFieldDescriptor<?, ? super MultiplicityType, ?>> keySet = fields.keySet( );
        assertTrue( keySet.contains( MultiplicityType.DESCRIPTORS.IS_ORDERED( ) ) );
        assertTrue( keySet.contains( MultiplicityType.DESCRIPTORS.LOWER( ) ) );
        assertTrue( keySet.contains( MultiplicityType.DESCRIPTORS.UPPER( ) ) );
        assertTrue( keySet.contains( MultiplicityType.DESCRIPTORS.IS_UNIQUE( ) ) );

        assertEquals( fields.size( ), 4 );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.IS_ORDERED( ) ), true );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.LOWER( ) ), 1 );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.UPPER( ) ), 4 );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.IS_UNIQUE( ) ), false );

        // Check "Map" semantic -> If "put" is called again for field that is already in -> new value wins
        multCont.put( MultiplicityType.DESCRIPTORS.LOWER( ), 2 );
        assertEquals( fields.size( ), 4 );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.IS_ORDERED( ) ), true );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.LOWER( ) ), 2 );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.UPPER( ) ), 4 );
        assertEquals( fields.get( MultiplicityType.DESCRIPTORS.IS_UNIQUE( ) ), false );

        // Check usage of Structure Inheritance
        StructureFieldContainer<SubStructure1> subCont = new StructureFieldContainer<SubStructure1>( );
        subCont.put( SubStructure1.DESCRIPTORS.SUB_FIELD1( ), 1.1f );

        // First put in value via "SubStructure1"
        subCont.put( SubStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 1 );
        // Now change the value via same Descriptor accessed via SuperStructure1 
        subCont.put( SuperStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 2 );

        Map<StructureFieldDescriptor<?, ? super SubStructure1, ?>, Object> fieldsSub = subCont.getFields( );
        assertEquals( fieldsSub.size( ), 2 );
        assertEquals( fieldsSub.get( SubStructure1.DESCRIPTORS.SUB_FIELD1( ) ), 1.1f );
        assertEquals( fieldsSub.get( SubStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ) ), 2 );
        assertEquals( fieldsSub.get( SuperStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ) ), 2 );

        // Compile error that uncover wrong type usage
        // Un-comment the lines to see the compiler's message

        // 1) Wrong type of value: "IS_ORDERED( )" is boolean, given value is "int"
        // multCont.put( MultiplicityType.DESCRIPTORS.IS_ORDERED( ), 3 );

        // 2) Wrong type of value: "LOWER( )" is int, given value is "String"
        // multCont.put( MultiplicityType.DESCRIPTORS.LOWER( ), "Lower" );

        // 3) Wrong type of value: SUPER_FIELD1_FROM1( ). Type of "2" as "int" fits to "SUPER_FIELD1_FROM1( )",
        // but "SUPER_FIELD1_FROM1( )" does not belong to "MultiplicityType"
        // multCont.put( SubStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 2 );

    }

    @Test
    public void testDescriptorsContainersWithStructureCreation( ) throws Exception {

        // create a structure that is contained in a package
        Case008Package pakkage = getMOINConnection( ).getPackage( Case008Package.PACKAGE_DESCRIPTOR );
        StructureFieldContainer<T8> t8Cont = new StructureFieldContainer<T8>( );
        t8Cont.put( T8.DESCRIPTORS.FIELD1( ), 41 ).put( T8.DESCRIPTORS.FIELD2( ), "41" ); //$NON-NLS-1$
        StructureFieldContainer<S8> s8Cont = new StructureFieldContainer<S8>( );
        s8Cont.put( S8.DESCRIPTORS.FIELD1( ), 42 ).put( S8.DESCRIPTORS.FIELD2( ), "42" ).put( S8.DESCRIPTORS.STRUCTURE1( ), pakkage.createT8( t8Cont ) ); //$NON-NLS-1$
        S8 s8 = pakkage.createS8( s8Cont );
        // check the structure
        assertEquals( 42, s8.getField1( ) );
        assertEquals( "42", s8.getField2( ) ); //$NON-NLS-1$
        assertEquals( 41, s8.getStructure1( ).getField1( ) );
        assertEquals( "41", s8.getStructure1( ).getField2( ) ); //$NON-NLS-1$
    }

    @Test
    public void testDescriptorsContainersWithStructureCreationAndInheritance( ) throws Exception {

        // create a sub structure and set also super fields
        InheritancePackage pakkage = getMOINConnection( ).getPackage( InheritancePackage.PACKAGE_DESCRIPTOR );
        StructureFieldContainer<SubStructure1> subCont = new StructureFieldContainer<SubStructure1>( );
        subCont.put( SubStructure1.DESCRIPTORS.SUB_FIELD1( ), 42.0f ).put( SubStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 42 ).put( SubStructure1.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 43 );
        SubStructure1 sub = pakkage.createSubStructure1( subCont );
        // check the structure
        assertEquals( 42.0f, sub.getSubField1( ) );
        assertEquals( 42, sub.getSuperField1From1( ) );
        assertEquals( 43, sub.getSuperField2From1( ) );
    }

    @Test
    public void testDescriptorsContainersWithStructureCreationAndInitializers( ) throws Exception {

        // create a structure and don't set any field
        Case008Package pakkage = getMOINConnection( ).getPackage( Case008Package.PACKAGE_DESCRIPTOR );
        StructureFieldContainer<T8> t8Cont = new StructureFieldContainer<T8>( );
        // note that field1 is initialized in the metamodel by the integer value 42
        T8 t8 = pakkage.createT8( t8Cont );
        // check the structure, field1 is initialized
        assertEquals( 42, t8.getField1( ) );
    }

    @Test
    public void testDescriptorsContainersWithStructureCreationAndNullContainer( ) throws Exception {

        // create a structure with a null container
        Case008Package pakkage = getMOINConnection( ).getPackage( Case008Package.PACKAGE_DESCRIPTOR );
        S8 s8 = pakkage.createS8( null );
    }

    @Test
    public void testDescriptorsContainersWithStructureCreationAndEmptyContainer( ) throws Exception {

        // create a structure with an empty container
        Case008Package pakkage = getMOINConnection( ).getPackage( Case008Package.PACKAGE_DESCRIPTOR );
        StructureFieldContainer<S8> s8Cont = new StructureFieldContainer<S8>( );
        S8 s8 = pakkage.createS8( s8Cont );
    }

}
