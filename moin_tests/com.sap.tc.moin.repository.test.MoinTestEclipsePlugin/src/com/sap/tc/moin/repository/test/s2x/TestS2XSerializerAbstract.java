package com.sap.tc.moin.repository.test.s2x;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.lib.internal.util.Constants;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.ui.internal.DiiUIConstants;
import com.sap.s2x.S2XDocument;
import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.primary.facility.test.ide.FacilityIdeMoinTest;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.test.fw.ide.IdeNwdiTestClientImpl;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.case001.Case001Package;
import com.sap.tc.moin.testcases.case019.Case019Package;
import com.sap.tc.moin.testcasesfoundation.case001f.A1f;
import com.sap.tc.moin.testcasesfoundation.case001f.Case001fPackage;
import com.sap.tc.moin.testcasesfoundation.case004f.Case004fPackage;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;
import com.sap.tc.moin.textverticalization.TranslatableText;
import com.sap.tc.moin.textverticalization.TranslatableTextFragment;

@SuppressWarnings( "nls" )
public abstract class TestS2XSerializerAbstract extends FacilityIdeMoinTest {

    protected static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    protected TextverticalizationPackage tvPackage = null;

    protected Case001Package case001Package = null;

    protected Case019Package case019Package = null;

    protected Case001fPackage case001fPackage = null;

    protected Case004fPackage case004fPackage = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        tvPackage = getMoinConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );
        case001Package = getMoinConnection( ).getPackage( Case001Package.PACKAGE_DESCRIPTOR );
        case019Package = getMoinConnection( ).getPackage( Case019Package.PACKAGE_DESCRIPTOR );
        case001fPackage = getMoinConnection( ).getPackage( Case001fPackage.PACKAGE_DESCRIPTOR );
        case004fPackage = getMoinConnection( ).getPackage( Case004fPackage.PACKAGE_DESCRIPTOR );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        tvPackage = null;
        case001Package = null;
        case019Package = null;
        case001fPackage = null;
        case004fPackage = null;
    }

    public static <T extends TranslatableText> StructureFieldContainer<T> createStructureFieldContainer( T type, int maxWidth, String originalText, String resName, String resType, boolean translate ) {

        StructureFieldContainer<T> ttc = new StructureFieldContainer<T>( );
        ttc.put( TranslatableText.DESCRIPTORS.MAX_WIDTH( ), maxWidth ).put( TranslatableText.DESCRIPTORS.ORIGINAL_TEXT( ), originalText );
        ttc.put( TranslatableText.DESCRIPTORS.RES_TYPE( ), resType ).put( TranslatableText.DESCRIPTORS.RES_NAME( ), resName ).put( TranslatableText.DESCRIPTORS.TRANSLATE( ), translate );
        return ttc;
    }

    public static <T extends TranslatableTextFragment> StructureFieldContainer<T> createStructureFieldContainer( T type, int maxWidth, String originalText, String resType ) {

        StructureFieldContainer<T> ttc = new StructureFieldContainer<T>( );
        ttc.put( TranslatableTextFragment.DESCRIPTORS.MAX_WIDTH( ), maxWidth ).put( TranslatableTextFragment.DESCRIPTORS.ORIGINAL_TEXT( ), originalText ).put( TranslatableTextFragment.DESCRIPTORS.RES_TYPE( ), resType );
        return ttc;
    }

    protected File getS2XFileForPartition( PRI pri ) {

        // retrieve the S2X file, we need a saved partition file here
        IFile partitionFile = getIdeFacilityDispatcher( ).getFile( pri );
        // the S2X file name is equals to the partition file name plus the extension "xlf"
        return partitionFile.getRawLocation( ).makeAbsolute( ).addFileExtension( "xlf" ).toFile( );
    }

    protected ModelPartition getOrCreatePartitionAndSave( String partitionName ) throws Exception {

        // get or create the partition
        ModelPartition partition = _testClient1.getOrCreatePartition( partitionName );
        // save the partition and return it
        getMoinConnection( ).save( );
        return partition;
    }

    protected ModelPartition createEmptyPartitionAndSave( String partitionName ) throws Exception {

        // get or create the partition
        ModelPartition partition = _testClient1.getOrCreatePartitionStable( partitionName );
        // make it empty so that no texts are contained
        partition.deleteElements( );
        // save the partition and return it
        getMoinConnection( ).save( );
        return partition;
    }

    protected ModelPartition createEmptyPartitionAndSave( String partitionName, String locale, String ach ) throws Exception {

        // DC and partition specifics
        String dcVendor = IdeNwdiTestClientImpl.DEFAULT_DC.getVendor( );
        String dcName = IdeNwdiTestClientImpl.DEFAULT_DC.getName( );
        String fullDcName = MOIN_IDE_TEST_HELPER.getFullDCName( dcVendor, dcName );
        String partitionRootPath = IdeNwdiTestClientImpl.PARTITION_ROOT_PATH;
        // create the Eclipse project
        IProject eclipseProject = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinDCProject( dcVendor, dcName );
        // modify the DC locale and the application component hierarchy
        IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent( eclipseProject );
        MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).setDcLocale( dc, locale );
        MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).setDcAttribute( dc, DiiUIConstants.ATT_ACHASSIGNMENT, Constants.SAP_VENDOR, ach );
        // create the partition
        SpiClientSpec clientSpec = getClientSpec( eclipseProject );
        ModelPartition partition = createPartition( clientSpec, fullDcName, partitionRootPath + "/" + makePartitionName( partitionName ) );
        return partition;
    }

    protected File createEmptyS2XFileForPartition( PRI pri ) throws Exception {

        File s2xFile = getS2XFileForPartition( pri );
        // generate an empty S2X file
        new S2XDocument( ).store( s2xFile );
        return s2xFile;
    }

    protected boolean deleteS2XFileForPartition( PRI pri ) {

        return getS2XFileForPartition( pri ).delete( );
    }

    protected void assertEqualsContentsOfTranslationUnitAndTranslatableText( TranslationUnit translationUnit, TranslatableText translatableText ) {

        assertEquals( "The maximum length of the translation unit (" + translationUnit.getMaxwidth( ) + ") and the translatable text (" + translatableText.getMaxWidth( ) + ") are not equal.", translationUnit.getMaxwidth( ), Integer.toString( translatableText.getMaxWidth( ) ) );
        assertEquals( "The original text of the translation unit (" + translationUnit.getSource( ) + ") and the translatable text (" + translatableText.getOriginalText( ) + ") are not equal.", translationUnit.getSource( ), translatableText.getOriginalText( ) );
        assertEquals( "The resource name of the translation unit (" + translationUnit.getResname( ) + ") and the translatable text (" + translatableText.getResName( ) + ") are not equal.", translationUnit.getResname( ), translatableText.getResName( ) );
        assertEquals( "The resource type of the translation unit (" + translationUnit.getRestype( ) + ") and the translatable text (" + translatableText.getResType( ) + ") are not equal.", translationUnit.getRestype( ), translatableText.getResType( ) );
        assertEquals( "The translate flag of the translation unit (" + translationUnit.getTranslate( ) + ") and the translatable text (" + translatableText.isTranslate( ) + ") are not equal.", translationUnit.getTranslate( ), translatableText.isTranslate( ) ? "yes" : "no" );
    }

    protected TranslationUnit getTranslationUnitWithGivenId( Collection<TranslationUnit> translationUnits, String Id ) {

        for ( TranslationUnit translationUnit : translationUnits ) {
            if ( translationUnit.getID( ).equals( Id ) ) {
                return translationUnit;
            }
        }
        return null;
    }

    protected A1f createA1fInPartition( TranslatableText translatableText, ModelPartition partition ) {

        A1f a1f = partition.createElement( A1f.class );
        a1f.setTranslatableText( translatableText );
        return a1f;
    }

    protected boolean containsException( Throwable throwable, Class<?> exceptionClass ) {
        if ( throwable == null ) {
            return false;
        }
        if ( exceptionClass.isAssignableFrom( throwable.getClass( ) ) ) {
            return true;
        }
        return containsException( throwable.getCause( ), exceptionClass );
    }
}
