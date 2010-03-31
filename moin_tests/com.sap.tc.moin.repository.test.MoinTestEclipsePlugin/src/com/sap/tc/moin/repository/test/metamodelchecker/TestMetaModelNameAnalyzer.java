package com.sap.tc.moin.repository.test.metamodelchecker;

import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Tag;

import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.NameViolation.NameViolationErrorCode;
import com.sap.tc.moin.repository.core.checks.ModelElementNameAnalyzer;

/**
 * Test the metamodel name checker within the check framework
 */
@SuppressWarnings( "nls" )
public class TestMetaModelNameAnalyzer extends TestDefaultMetamodelChecker {

    protected static final String JMI_TAG_ID_SUBSTITUTE_NAME = "javax.jmi.substituteName";

    protected static final String JMI_TAG_ID_PACKAGE_PREFIX = "javax.jmi.packagePrefix";

    @Test
    public void testModelElementNames( ) {

        // a valid name
        checkValidModelElementName( "validName" );
        // a valid name with a digit
        checkValidModelElementName( "valid42Name" );
        // a valid name with an underscore
        checkValidModelElementName( "valid_Name" );
        // null is invalid
        checkInvalidModelElementName( (String) null, NameViolationErrorCode.MODEL_ELEMENT_NAME_IS_NULL );
        // "" is invalid
        checkInvalidModelElementName( "", NameViolationErrorCode.MODEL_ELEMENT_NAME_LENGTH_IS_NULL );
        // "#invalidName" is invalid
        checkInvalidModelElementName( "#invalidName", NameViolationErrorCode.MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER );
        // _invalidName is invalid
        checkInvalidModelElementName( "_invalidName", NameViolationErrorCode.MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER );
        // "42invalidName" is invalid
        checkInvalidModelElementName( "42invalidName", NameViolationErrorCode.MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER );
        // "class" is invalid
        checkInvalidModelElementName( "class", NameViolationErrorCode.MODEL_ELEMENT_NAME_IS_JAVA_KEYWORD );
        // "in#validName" is invalid
        checkInvalidModelElementName( "in#validName", NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE );
        //checks non-ascii characters
        // @Hello, H@ello
        checkInvalidModelElementName( "\u0040Hello", NameViolationErrorCode.MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER );
        checkInvalidModelElementName( "H\u0040ello", NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE );
    }

    @Test
    public void testModelElement( ) {

        // test without substitute
        Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
        operation.setName( "someValidName" );
        checkValidModelElement( operation );
        operation.setName( "name withspace" );
        checkInvalidModelElement( operation, NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE );
        operation.setName( "nameWith$SpecialCharacter" );
        checkInvalidModelElement( operation, NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE );
        operation.setName( "validname_withunderscore" );
        checkValidModelElement( operation );
        operation.setName( "invalid$name " );
    }

    @Test
    public void testEnumeration( ) {

        EnumerationType enumeration = (EnumerationType) modelPackage.getEnumerationType( ).refCreateInstance( );
        enumeration.setName( "enumeration" );
        enumeration.getLabels( ).add( "validLiteralName" );
        checkValidModelElement( enumeration );
        enumeration.getLabels( ).clear( );
        enumeration.getLabels( ).add( "invalid$LiteralName" );
        checkInvalidModelElement( enumeration, NameViolationErrorCode.ENUMERATION_LABEL_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE );
        enumeration.getLabels( ).clear( );
        // white spaces are allowed
        enumeration.getLabels( ).add( "with space" );
        checkValidModelElement( enumeration );
        enumeration.getLabels( ).clear( );
        // Java keywords are allowed
        enumeration.getLabels( ).add( "double" );
        checkValidModelElement( enumeration );
        enumeration.getLabels( ).clear( );
    }

    @Test
    public void testUniqueModelElementNamesInGeneralizableElement( ) {

        // we test uniqueness in a MofClass (i.e. in a GeneralizableElement)
        // a class with an attribute
        MofClass clazz = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        clazz.setName( "validName" );
        Attribute attribute = (Attribute) modelPackage.getAttribute( ).refCreateInstance( );
        attribute.setName( "uniqueName" );
        clazz.getContents( ).add( attribute );
        // we add another attribute with the same name
        Attribute attribute2 = (Attribute) modelPackage.getAttribute( ).refCreateInstance( );
        attribute2.setName( "uniqueName" );
        clazz.getContents( ).add( attribute2 );
        // the name is not unique in the namespace of the class
        checkNonUniqueName( attribute2, getMOINConnection( ).getNullPartition( ) );
    }

    @Test
    public void testUniqueModelElementNamesInNamespace( ) {

        // we test uniqueness in an Operation (i.e. in a Namespace)
        // an operation with a parameter with multiplicity 1
        Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
        operation.setName( "validName" );
        Parameter parameter = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
        parameter.setName( "uniqueName" );
        parameter.setMultiplicity( multiplicity1To1 );
        operation.getContents( ).add( parameter );
        // we add another parameter with the same name
        Parameter parameter2 = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
        parameter2.setName( "uniqueName" );
        parameter2.setMultiplicity( multiplicity1To1 );
        operation.getContents( ).add( parameter2 );
        // the name is not unique in the namespace of the operation
        checkNonUniqueName( parameter2, getMOINConnection( ).getNullPartition( ) );
    }

    @Test
    public void testUniqueToplevelPackageNamesWithinOnePartition( ) throws Exception {

        // we test uniqueness of toplevel packages in a container with one single partition
        // create one toplevel package in a partition
        ModelPartition partition = getPartitionOne( );
        MofPackage samePackage1 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage1.setName( "samePackage" );
        partition.assignElement( samePackage1 );
        // now check the partition, the package name is unique
        checkUniqueName( samePackage1, partition );

        // create a second toplevel package with the same name and add it to the partition
        MofPackage samePackage2 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage2.setName( "samePackage" );
        partition.assignElement( samePackage2 );
        // now check the partition, the package name is not unique
        checkNonUniqueName( samePackage2, partition );

        // create a third toplevel package with the same name and with another prefix and add it to the partition
        MofPackage samePackage3 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage3.setName( "samePackage" );
        partition.assignElement( samePackage3 );
        // we give the third package a package prefix
        Tag packagePrefixTag = createPackagePrefixTag( "com.subpackage" );
        modelPackage.getAttachesTo( ).add( samePackage3, packagePrefixTag );
        // now check the partition, the package name is not unique
        checkNonUniqueName( samePackage3, partition );
    }

    @Test
    public void testUniqueToplevelPackageJavaNamesWithinOnePartition( ) throws Exception {

        ModelPartition partition = getPartitionOne( );
        // create two packages that collode in their Java names
        // one sub package with the name "samePackage" under the toplevel package "com" and
        // one toplevel package with the name "samePackage" and the package prefix "com"
        // first create the toplevel packages "com" and "samePackage"
        MofPackage com = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        com.setName( "com" );
        partition.assignElement( com );
        MofPackage samePackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage.setName( "samePackage" );
        partition.assignElement( samePackage );
        // now check the partition, the package name is unique
        checkUniqueName( samePackage, partition );
        // create now the package under the toplevel package "com"
        MofPackage subPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        subPackage.setName( "samePackage" );
        com.getContents( ).add( subPackage );
        // now give the toplevel package samePackage the prefix "com"
        Tag packagePrefixTag = createPackagePrefixTag( "com" );
        modelPackage.getAttachesTo( ).add( samePackage, packagePrefixTag );
        // now check the partition, the package name is not unique
        // because the sub package "samePackage" under "com" and the toplevel
        // package "samePackage" with the prefix "com" have now the same Java name
        checkNonUniqueName( samePackage, partition );
    }

    @Test
    public void testUniqueToplevelPackageNamesWithinTwoPartitions( ) throws Exception {

        // we test uniqueness of toplevel packages in a container with two separate partitions
        // create one toplevel package in a partition
        ModelPartition partition1 = getPartitionOne( );
        MofPackage samePackage1 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage1.setName( "samePackage" );
        partition1.assignElement( samePackage1 );
        // now check the partition, the package name is unique
        checkUniqueName( samePackage1, partition1 );

        // create another toplevel package in another partition with the same name as the package in the first partition
        ModelPartition partition2 = getPartitionTwo( );
        MofPackage samePackage2 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage2.setName( "samePackage" );
        partition2.assignElement( samePackage2 );
        // now check the second partition, the package name is not unique anymore in the container
        checkNonUniqueName( samePackage2, partition1, partition2 );
    }

    private void checkValidModelElementName( String nameToCheck ) {

        assertTrue( "Name should be valid, but it isn't: " + nameToCheck, ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( nameToCheck ) == null );
    }

    private void checkInvalidModelElementName( String nameToCheck, NameViolationErrorCode errorCodeToCheck ) {

        NameViolation nameViolation = ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( nameToCheck );
        assertTrue( "Name \"" + nameToCheck + "\" should be invalid, but it is.", nameViolation != null );

        NameViolationErrorCode errorCode = nameViolation.getErrorCode( );
        assertTrue( "Name \"" + nameToCheck + "\" should be invalid, but it is.", errorCode != null );
        assertTrue( "Error code should be \"" + errorCodeToCheck + "\", but it is \"" + errorCode + "\".", errorCodeToCheck == errorCode );

        String description = nameViolation.getDescription( );
        String descriptionDefault = nameViolation.getDescription( Locale.getDefault( ) );
        assertTrue( "Error description should not be empty, but it is.", description != null && description.length( ) != 0 );
        assertTrue( "Error default description should not be empty, but it is.", descriptionDefault != null && descriptionDefault.length( ) != 0 );
    }

    private void checkValidModelElement( ModelElement modelElementToCheck ) {

        checker.doCheck( getMOINConnection( ).getNullPartition( ) );
        assertTrue( "Model element \"" + modelElementToCheck.getName( ) + "\" should be valid, but it isn't: " + modelElementToCheck.getName( ), checker.getNameViolationItems( ).size( ) == 0 );
    }

    private void checkInvalidModelElement( ModelElement modelElementToCheck, NameViolationErrorCode errorCodeToCheck ) {

        checker.doCheck( getMOINConnection( ).getNullPartition( ) );
        List<NameViolation> nameViolations = checker.getNameViolationItems( );
        assertTrue( "Model element \"" + modelElementToCheck.getName( ) + "\" should be invalid, but it is.", nameViolations.size( ) != 0 );

        NameViolation nameViolation = nameViolations.get( 0 );
        assertTrue( "Model element \"" + modelElementToCheck.getName( ) + "\" should be invalid, but it is.", nameViolation != null );

        NameViolationErrorCode errorCode = nameViolation.getErrorCode( );
        assertTrue( "Model element \"" + modelElementToCheck.getName( ) + "\" should be invalid, but it is.", errorCode != null );
        assertTrue( "Error code should be \"" + errorCodeToCheck + "\", but it is \"" + errorCode + "\".", errorCodeToCheck == errorCode );

        String description = nameViolation.getDescription( );
        String descriptionDefault = nameViolation.getDescription( Locale.getDefault( ) );
        assertTrue( "Error description should not be empty, but it is.", description != null && description.length( ) != 0 );
        assertTrue( "Error default description should not be empty, but it is.", descriptionDefault != null && descriptionDefault.length( ) != 0 );
    }

    private void checkUniqueName( ModelElement modelElement, ModelPartition... partitions ) {

        checker.doCheck( partitions );
        assertTrue( "Name should be unique, but it isn't: " + modelElement.getName( ), checker.getNameViolationItems( ).size( ) == 0 );
    }

    private void checkNonUniqueName( ModelElement modelElement, ModelPartition... partitions ) {

        checker.doCheck( partitions );
        assertFalse( "Name should be non unique, but it is: " + modelElement.getName( ), checker.getNameViolationItems( ).size( ) == 0 );
    }

    private Tag createSubstituteNameTag( String substituteName ) {

        Tag tag = (Tag) modelPackage.getTag( ).refCreateInstance( );
        tag.setName( "MySubstituteTag" );
        tag.setAnnotation( "This is my substitute name tag" );
        tag.setTagId( JMI_TAG_ID_SUBSTITUTE_NAME );
        tag.getValues( ).add( substituteName );
        return tag;
    }

    private Tag createPackagePrefixTag( String packagePrefix ) {

        Tag tag = (Tag) modelPackage.getTag( ).refCreateInstance( );
        tag.setName( "MyPrefixTag" );
        tag.setAnnotation( "This is my prefix tag" );
        tag.setTagId( JMI_TAG_ID_PACKAGE_PREFIX );
        tag.getValues( ).add( packagePrefix );
        return tag;
    }
}
