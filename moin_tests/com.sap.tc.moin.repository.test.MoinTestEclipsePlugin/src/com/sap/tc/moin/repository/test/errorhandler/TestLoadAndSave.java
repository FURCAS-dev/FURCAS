package com.sap.tc.moin.repository.test.errorhandler;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.junit.Test;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.cps.parser.PartitionParserImpl;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.S8;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcasesfoundation.case005f.__impl.A5fMigrationAttributeTypeTranslatableTextImpl;
import com.sap.tc.moin.textverticalization.TranslatableText;

@SuppressWarnings( "nls" )
public class TestLoadAndSave extends TestErrorHandlerAbstract {

    private SpiParserErrorHandler errorHandlerMofBak = null;

    private SpiParserErrorHandler errorHandlerTestcasesBak = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        errorHandlerMofBak = serializationManager.getParserErrorHandler( TestMetaModels.MOIN_MOF_CN, null );
        errorHandlerTestcasesBak = serializationManager.getParserErrorHandler( TestMetaModels.TESTCASES_CN, null );
        serializationManager.setParserErrorHandler( TestMetaModels.MOIN_MOF_CN, new ErrorHandlerMOF( ) );
        serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_CN, new ErrorHandlerTestcases( ) );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        if ( errorHandlerMofBak == null ) {
            serializationManager.removeParserErrorHandler( TestMetaModels.MOIN_MOF_CN );
        } else {
            serializationManager.setParserErrorHandler( TestMetaModels.MOIN_MOF_CN, errorHandlerMofBak );
        }
        if ( errorHandlerTestcasesBak == null ) {
            serializationManager.removeParserErrorHandler( TestMetaModels.TESTCASES_CN );
        } else {
            serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_CN, errorHandlerTestcasesBak );
        }
        super.afterTestMethod( );
    }

    @Test
    public void testMemoryState( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "partitionTestMemoryState" );
        // parse the partition
        parse( getContentOfPartitionWithOva( ), partition );
        // check the partition memory state
        assertTrue( partition.isMemoryStateDifferentFromPersistentStateAfterLoad( ) );
    }

    @Test
    public void testNoUnhandledErrors( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "partitionNoUnhandledErrors" );
        // parse the partition
        parse( getContentOfPartitionWithOva( ), partition );
        // check whether there were unhandled errors
        assertFalse( partition.hadUnhandledErrorsDuringLoad( ) );
    }

    private ByteArrayInputStream getContentOfPartitionWithOva( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases/foundation' i='1' v=''/>" );
        buf.append( "<C n='sap.com/tc/moin/textverticalization' i='2' v=''/>" );
        buf.append( "<M c='1' q='testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText' i='48FEDD2F3CDD1BABA00F11DD8C38001558C93B47' ova='translatableText,generalTranslatableText,specializedTranslatableText'/>" );
        buf.append( "<M c='2' q='textverticalization.Text' i='45ED9217C0E2D7BE5B284C5F163B938D8DD1D7C9'/>" );
        buf.append( "<textverticalization.Text m:c='2' m:i='491187372AA916C0AB2F11DDCB10001558C93B47' maxWidth='80' originalText='My original text' resType='button' translate='true' transUnitId='42' resName='BTN_42'/>" );
        buf.append( "<testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText m:c='1' m:i='491187372AA6A5C0AB2F11DDC89D001558C93B47' translatableText='491187372AA916C0AB2F11DDCB10001558C93B47'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    @Test
    public void testDeletedElement( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "partitionDeletedElement" );
        // parse the partition
        parse( getContentOfPartitionWithOva( ), partition );
        // check the partition content
        Collection<Partitionable> elements = partition.getElements( );
        // Check that the Text object is not part of the partition, i.e. that we only have the surrounding class
        // the error handler framework must have removed it, not the error handler
        assertEquals( "The partition read should contain 1 element, but it contains " + elements.size( ) + ".", 1, elements.size( ) );
        Partitionable element = elements.iterator( ).next( );
        assertTrue( "The element read should be of instance \"" + A5fMigrationAttributeTypeTranslatableTextImpl.class.getSimpleName( ) + "\", but it is of instance \"" + element.getClass( ).getSimpleName( ) + "\".", element instanceof A5fMigrationAttributeTypeTranslatableTextImpl );
    }

    @Test
    public void testWithOvaInformation( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "partitionWithOva" );
        // parse the partition
        parse( getContentOfPartitionWithOva( ), partition );
        // check the partition content
        A5fMigrationAttributeTypeTranslatableTextImpl a5f = (A5fMigrationAttributeTypeTranslatableTextImpl) partition.getElements( ).iterator( ).next( );
        TranslatableText translatableText = a5f.getTranslatableText( );
        assertEquals( "The translatable text original text should be \"My original text\", but it is \"" + translatableText.getOriginalText( ) + "\".", "My original text", translatableText.getOriginalText( ) );
    }

    @Test
    public void testWithoutOvaInformation( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "partitionWithOva" );
        // parse the partition
        parse( getContentOfPartitionWithoutOva( ), partition );
        // check the partition content
        A5fMigrationAttributeTypeTranslatableTextImpl a5f = (A5fMigrationAttributeTypeTranslatableTextImpl) partition.getElements( ).iterator( ).next( );
        TranslatableText translatableText = a5f.getTranslatableText( );
        assertEquals( "The translatable text original text should be \"My original text\", but it is \"" + translatableText.getOriginalText( ) + "\".", "My original text", translatableText.getOriginalText( ) );
    }

    private ByteArrayInputStream getContentOfPartitionWithoutOva( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases/foundation' i='1' v=''/>" );
        buf.append( "<C n='sap.com/tc/moin/textverticalization' i='2' v=''/>" );
        // missing 'ova' info !!!
        buf.append( "<M c='1' q='testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText' i='48FEDD2F3CDD1BABA00F11DD8C38001558C93B47' />" );
        buf.append( "<M c='2' q='textverticalization.Text' i='45ED9217C0E2D7BE5B284C5F163B938D8DD1D7C9'/>" );
        buf.append( "<textverticalization.Text m:c='2' m:i='491187372AA916C0AB2F11DDCB10001558C93B47' maxWidth='80' originalText='My original text' resType='button' translate='true' transUnitId='42' resName='BTN_42'/>" );
        buf.append( "<testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText m:c='1' m:i='491187372AA6A5C0AB2F11DDC89D001558C93B47' translatableText='491187372AA916C0AB2F11DDCB10001558C93B47'/>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    @Test
    public void testPartitionLoading( ) throws Exception {

        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "trans1" );
        SpiParserCallback callback = new CoreParserCallbackImpl( serializationManager, coreConnection.getSession( ), partition );
        new PartitionParserImpl( ).parse( getContentOfTestcasesPartition( ), callback, -1 );
        MofClass mc = null;
        AssociationEnd ae = null;
        A8 a8 = null;
        for ( Partitionable element : getMOINConnection( ).getPartition( partition.getPri( ) ).getElements( ) ) {
            if ( element instanceof MofClass ) {
                mc = (MofClass) element;
                assertTrue( mc.getVisibility( ) == VisibilityKindEnum.PUBLIC_VIS );
            } else if ( element instanceof AssociationEnd ) {
                ae = (AssociationEnd) element;
                MultiplicityType multiplicity = ae.getMultiplicity( );
                assertTrue( multiplicity != null );
                assertEquals( -1, multiplicity.getUpper( ) );
            } else if ( element instanceof A4 ) {
                assertEquals( "test1", ( (A4) element ).getOnePrimitive( ) );
                assertEquals( "test2", ( (A4) element ).getOnePrimitiveOptional( ) );
                assertEquals( "test3", ( (A4) element ).getOnePrimitiveNotChangeable( ) );
            } else if ( element instanceof A8 ) {
                a8 = (A8) element;
                S8 oneStructureS = a8.getOneStructureS( );
                assertEquals( 8, oneStructureS.getField1( ) );
                assertEquals( "StringValue", oneStructureS.getField2( ) );
                T8 structure1 = oneStructureS.getStructure1( );
                assertEquals( 33, structure1.getField1( ) );
                assertEquals( "T8Value", structure1.getField2( ) );
            }
        }
        assertEquals( 4, partition.getElements( ).size( ) ); // Model.Clazz not resolvable, thus 4 instead of 5!
        assertEquals( mc, ae.getType( ) );
        assertTrue( partition.isMemoryStateDifferentFromPersistentStateAfterLoad( ) );
        assertTrue( partition.hadUnhandledErrorsDuringLoad( ) );
    }

    private ByteArrayInputStream getContentOfTestcasesPartition( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='sap.com/tc/moin/mof_1.4' i='1' v='1.0'/>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases' i='2' v='1.0.0'/>" );
        // Simulate a change of both qualified name and MOF-ID for the class 'Model.Class' and 
        // for the class 'Model.AssociationEnd'.
        buf.append( "<M c='1' q='Model.Clazz' i='85ED2E29E9B8C271FD484D6E2F52CCB9570C451A'/>" );
        buf.append( "<M c='1' q='Model.AssociationEndOld' i='85ED2E294D5F42A5B94C462B13F4F76DE1C16DBF'/>" );
        // Simulate a change of both qualified name and MOF-ID for the association 'Model.IsOfType'.
        buf.append( "<M c='1' q='Model.IsOfTypeOld' i='85ED2E29DA5028C85512452C3856E282A65D065B' ce='-1' oe='-1'/>" );
        buf.append( "<M c='2' q='testcases.case004.A4' i='45F120A5BFE73C9EE91342E2330BAC6ECFF5FD7B' ova='oneBChangeable,oneBNotChangeable,oneBOptional,manyBs,manyBsUnique,manyBsNotUnique,manyBsOrdered,manyBsOrderedUnique,manyBsNotOrdered,manyBsNotChangeable'/>" );
        buf.append( "<M c='2' q='testcases.case004.B4' i='45F120A5CE8778345E6E45142026DF2289212782'/>" );
        buf.append( "<M c='2' q='testcases.case008.A8' i='45F120A5127A94999671491413379870E97DF87B'/>" );
        // Simulate a type change for attribute 'visibility' from String to EnumerationType.
        buf.append( "<Model.Clazz m:c='1' m:i='45ED2E29050B855406AE42C81E9EA97E02EFA276' name='Hugo' annotation='some annotation' isRoot='false' isLeaf='false' isAbstract='false' visibility='PUBLIC' isSingleton='false'/>" );
        buf.append( "<Model.AssociationEndOld m:c='1' m:i='45ED2E2904E5F994AC664FE90B429AA809AF4354' name='someEnd' annotation='' isNavigable='true' aggregation='none' isChangeable='true'>" );
        // Simulate a type change of the StructureField 'upper' from String to Integer
        buf.append( "<multiplicity lower='1' upper='UNBOUNDED' isOrdered='false' isUnique='true'/>" );
        buf.append( "</Model.AssociationEndOld>" );
        buf.append( "<testcases.case004.B4 m:c='2' m:i='483A8A318B5036202B0A11DDAF1F001B776FA658'/>" );
        // Simulate a rename of attribute 'onePrimitiveOld' to 'onePrimitive'.
        // Simulate a split of attribute 'onePrimitiveConcatenated' into the attributes 'onePrimitiveOptional' and 'onePrimitiveNotChangeable'.
        buf.append( "<testcases.case004.A4 m:c='2' m:i='483A8A318B5036352B0A11DDA267001B776FA658' onePrimitiveOld='test1' onePrimitiveConcatenated = 'test2|test3' oneBChangeable='483A8A318B5036202B0A11DDAF1F001B776FA658'>" );
        buf.append( "<manyPrimitive v='initial0'/>" );
        buf.append( "<manyPrimitive v='initial1'/>" );
        buf.append( "<manyPrimitive v='initial2'/>" );
        buf.append( "<manyPrimitive v='initial3'/>" );
        buf.append( "<manyPrimitive v='initial4'/>" );
        buf.append( "</testcases.case004.A4>" );
        buf.append( "<testcases.case008.A8 m:c='2' m:i='483A8A318B573B012B0A11DDB145001B776FA658'>" );
        buf.append( "<oneStructureS field1='8' field2='StringValue' structure1.field1='33' structure1.field2='T8Value'/>" );
        buf.append( "</testcases.case008.A8>" );
        buf.append( "<Model.IsOfTypeOld c='1'>" );
        buf.append( "<L f='45ED2E29050B855406AE42C81E9EA97E02EFA276' s='45ED2E2904E5F994AC664FE90B429AA809AF4354'/>" );
        buf.append( "</Model.IsOfTypeOld>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    @Test
    public void testAdditionOfStructureField( ) throws Exception {

        serializationManager.removeParserErrorHandler( TestMetaModels.MOIN_MOF_CN );
        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "trans1" );
        SpiParserCallback callback = new CoreParserCallbackImpl( serializationManager, coreConnection.getSession( ), partition );
        new PartitionParserImpl( ).parse( getContentOfPartitionWithAddedStructureField( ), callback, -1 );
        assertEquals( 1, partition.getElements( ).size( ) );
        AssociationEnd ae = (AssociationEnd) partition.getElements( ).iterator( ).next( );
        MultiplicityType multiplicity = ae.getMultiplicity( );
        assertNotNull( multiplicity );
        assertEquals( 0, multiplicity.getLower( ) ); // must be initialized to the Java default value of Integer
        assertFalse( partition.isMemoryStateDifferentFromPersistentStateAfterLoad( ) );
        assertFalse( partition.hadUnhandledErrorsDuringLoad( ) );
    }

    private ByteArrayInputStream getContentOfPartitionWithAddedStructureField( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='sap.com/tc/moin/mof_1.4' i='1' v='1.0'/>" );
        buf.append( "<M c='1' q='Model.AssociationEnd' i='45ED2E294D5F42A5B94C462B13F4F76DE1C16DBF'/>" );
        buf.append( "<Model.AssociationEnd m:c='1' m:i='45ED2E2904E5F994AC664FE90B429AA809AF4354' name='someEnd' annotation='' isNavigable='true' aggregation='none' isChangeable='true'>" );
        // Simulate the addition of the StructureField named 'lower'.
        buf.append( "<multiplicity upper='-1' isOrdered='false' isUnique='true'/>" );
        buf.append( "</Model.AssociationEnd>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    @Test
    public void testRemovalOfStructureField( ) throws Exception {

        serializationManager.removeParserErrorHandler( TestMetaModels.MOIN_MOF_CN );
        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "trans1" );
        SpiParserCallback callback = new CoreParserCallbackImpl( serializationManager, coreConnection.getSession( ), partition );
        new PartitionParserImpl( ).parse( getContentOfPartitionWithRemovedStructureField( ), callback, -1 );
        assertEquals( 1, partition.getElements( ).size( ) );
        AssociationEnd ae = (AssociationEnd) partition.getElements( ).iterator( ).next( );
        MultiplicityType multiplicity = ae.getMultiplicity( );
        assertNotNull( multiplicity );
        assertFalse( partition.isMemoryStateDifferentFromPersistentStateAfterLoad( ) );
        assertFalse( partition.hadUnhandledErrorsDuringLoad( ) );
    }

    private ByteArrayInputStream getContentOfPartitionWithRemovedStructureField( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='sap.com/tc/moin/mof_1.4' i='1' v='1.0'/>" );
        buf.append( "<M c='1' q='Model.AssociationEnd' i='45ED2E294D5F42A5B94C462B13F4F76DE1C16DBF'/>" );
        buf.append( "<Model.AssociationEnd m:c='1' m:i='45ED2E2904E5F994AC664FE90B429AA809AF4354' name='someEnd' annotation='' isNavigable='true' aggregation='none' isChangeable='true'>" );
        // Simulate the removal of the StructureField named 'obsolete'.
        buf.append( "<multiplicity lower='1' upper='-1' isOrdered='false' isUnique='true' obsolete='99'/>" );
        buf.append( "</Model.AssociationEnd>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    @Test
    public void testPartitionFormatV2( ) throws Exception {

        serializationManager.removeParserErrorHandler( TestMetaModels.MOIN_MOF_CN );
        CoreModelPartition partition = coreConnection.getOrCreateTransientPartitionNonTransactional( "trans1" );
        SpiParserCallback callback = new CoreParserCallbackImpl( serializationManager, coreConnection.getSession( ), partition );
        new PartitionParserImpl( ).parse( getContentOfV2Partition( ), callback, -1 );
        assertEquals( 2, partition.getElements( ).size( ) );
        AssociationEnd ae = null;
        A8 a8 = null;
        for ( Partitionable element : getMOINConnection( ).getPartition( partition.getPri( ) ).getElements( ) ) {
            if ( element instanceof AssociationEnd ) {
                ae = (AssociationEnd) element;
                MultiplicityType multiplicity = ae.getMultiplicity( );
                assertNotNull( multiplicity );
                assertEquals( -1, multiplicity.getUpper( ) );
            } else if ( element instanceof A8 ) {
                a8 = (A8) element;
                S8 oneStructureS = a8.getOneStructureS( );
                assertEquals( 8, oneStructureS.getField1( ) );
                assertEquals( "StringValue", oneStructureS.getField2( ) );
                T8 structure1 = oneStructureS.getStructure1( );
                assertEquals( 33, structure1.getField1( ) );
                assertEquals( "T8Value", structure1.getField2( ) );
            }
        }
        assertFalse( partition.isMemoryStateDifferentFromPersistentStateAfterLoad( ) );
        assertFalse( partition.hadUnhandledErrorsDuringLoad( ) );
        Map<CRI, String> usedMetamodels = partition.getUsedMetamodels( );
        assertEquals( 2, usedMetamodels.size( ) );
        CRI cri1 = getMOINConnection( ).getClass( MofClass.CLASS_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).getCri( );
        CRI cri2 = getMOINConnection( ).getPackage( Case008Package.PACKAGE_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).getCri( );
        assertTrue( usedMetamodels.containsKey( cri1 ) );
        assertTrue( usedMetamodels.containsKey( cri2 ) );
        assertEquals( "1.0", usedMetamodels.get( cri1 ) );
        assertEquals( "1.0.0", usedMetamodels.get( cri2 ) );
    }

    private ByteArrayInputStream getContentOfV2Partition( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin' version='2'>" );
        buf.append( "<M n='sap.com/tc/moin/mof_1.4' i='1' v='1.0'/>" );
        buf.append( "<M n='test.sap.com/tc/moin/metamodel/testcases' i='2' v='1.0.0'/>" );
        buf.append( "<C c='1' q='Model.AssociationEnd' i='45ED2E294D5F42A5B94C462B13F4F76DE1C16DBF'/>" );
        buf.append( "<S c='1' q='Model.MultiplicityType' i='45ED2E299F5225CD29E84EB0243ADAA73062CA12'/>" );
        buf.append( "<C c='2' q='testcases.case008.A8' i='45F120A5127A94999671491413379870E97DF87B'/>" );
        buf.append( "<S c='2' q='testcases.case008.S8' i='48201D2241442DE31B4A11DDBD9F00199904B925'/>" );
        buf.append( "<S c='2' q='testcases.case008.T8' i='48201D2241442DE61B4A11DD94EC00199904B925'/>" );
        buf.append( "<Model.AssociationEnd m:c='1' m:i='45ED2E2904E5F994AC664FE90B429AA809AF4354' name='someEnd' annotation='' isNavigable='true' aggregation='none' isChangeable='true'>" );
        buf.append( "<multiplicity m:t='Model.MultiplicityType' m:c='1' lower='1' upper='-1' isOrdered='false' isUnique='true'/>" );
        buf.append( "</Model.AssociationEnd>" );
        buf.append( "<testcases.case008.A8 m:c='2' m:i='483A8A318B573B012B0A11DDB145001B776FA658'>" );
        buf.append( "<oneStructureS m:t='testcases.case008.S8' m:c='2' field1='8' field2='StringValue' m:t2='testcases.case008.T8' m:c2='2' structure1.field1='33' structure1.field2='T8Value'/>" );
        buf.append( "</testcases.case008.A8>" );
        buf.append( "</Partition>" );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    static final class ErrorHandlerMOF extends SpiDefaultParserErrorHandler {

        @Override
        public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

            // Simulate an error handler failing to resolve the type 'Model.Clazz'. As a result, 'null' is returned, 
            // i.e. the Model.Clazz element in the test partition will not be instantiated.
            if ( dotSeparatedQualifiedName.equals( "Model.Clazz" ) ) {
                return callback.getType( typeMofId, TestMetaModels.MOIN_MOF_CN, "Model.Clazz2" ); // does not exist
            } else if ( dotSeparatedQualifiedName.equals( "Model.AssociationEndOld" ) ) {
                // Test the resolving without typeMofId.
                return callback.getClass( null /* typeMofId */, TestMetaModels.MOIN_MOF_CN, "Model.AssociationEnd" ); // exists
            }
            if ( dotSeparatedQualifiedName.equals( "Model.IsOfTypeOld" ) ) {
                // return callback.getAssociation( "45ED2E29DA5028C85512452C3856E282A65D065B", null, null ); // Model.IsOfType
                return callback.getAssociation( null, TestMetaModels.MOIN_MOF_CN, "Model.IsOfType" ); // Model.IsOfType
            }
            return null;
        }

        @Override
        public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            boolean handled = false;
            if ( element.get___Type( ).get___QualifiedName( ).equals( "Model.Class" ) ) {
                if ( attributeName.equals( "visibility" ) ) {
                    if ( "PUBLIC".equals( attributeValue ) ) {
                        element.add___PrimitiveOrEnumerationValue( attributeName, VisibilityKindEnum.PUBLIC_VIS.toString( ) );
                        handled = true;
                    }
                }
            } else if ( element.get___Type( ).get___QualifiedName( ).equals( "Model.AssociationEnd" ) ) {
                if ( attributeName.equals( "multiplicity" ) ) {
                    SpiStructuredValue value = (SpiStructuredValue) attributeValue;
                    if ( "UNBOUNDED".equals( value.get___FieldValue( "upper" ) ) ) {
                        value.set___FieldValue( "upper", "-1" );
                        element.add___StructuredValue( attributeName, value );
                        handled = true;
                    }
                }
            }
            return handled;
        }
    }

    private static final class ErrorHandlerTestcases extends SpiDefaultParserErrorHandler {

        @Override
        public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            boolean handled = false;
            if ( element.get___Type( ).get___QualifiedName( ).equals( "testcases.case004.A4" ) ) {
                if ( attributeName.equals( "onePrimitiveOld" ) ) {
                    element.add___PrimitiveOrEnumerationValue( "onePrimitive", (String) attributeValue );
                    handled = true;
                } else if ( attributeName.equals( "onePrimitiveConcatenated" ) ) {
                    String value = (String) attributeValue;
                    int pos = value.indexOf( '|' );
                    element.add___PrimitiveOrEnumerationValue( "onePrimitiveOptional", value.substring( 0, pos ) );
                    element.add___PrimitiveOrEnumerationValue( "onePrimitiveNotChangeable", value.substring( pos + 1 ) );
//                    SpiClass tagClass = callback.getClass( null, "sap.com/tc/moin/mof_1.4", "Model.Tag" );
//                    String calculatedMofId = callback.calculateElementMofId( tagClass, "TestCustomParser", new String[] { "a", "b", "c" } );
//                    callback.addElement( tagClass, calculatedMofId );
                    handled = true;
                }
            }
            return handled;
        }
    }
}