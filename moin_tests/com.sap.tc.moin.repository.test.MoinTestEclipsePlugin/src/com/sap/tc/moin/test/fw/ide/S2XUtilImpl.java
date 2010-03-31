package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;

import com.sap.s2x.S2XDocument;
import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcasesfoundation.case001f.A1f;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;
import com.sap.tc.moin.textverticalization.TranslatableText;

public class S2XUtilImpl implements S2XUtil {

    /** *********** Internals *********************************************** */

    private IdeRuntimeTestHelper _ideTestHelper;

    /** *********** Construction ******************************************** */

    public S2XUtilImpl( IdeRuntimeTestHelper ideRuntimeTestHelper ) {

        _ideTestHelper = ideRuntimeTestHelper;
    }

    /** *********** API ***************************************************** */
    public IFile getXlfFileHandle( IFile partitionFileHandle ) {

        IPath partitionPath = partitionFileHandle.getProjectRelativePath( );
        IPath xlfFilePath = partitionPath.addFileExtension( "xlf" ); //$NON-NLS-1$
        IFile xlfFileHandle = partitionFileHandle.getProject( ).getFile( xlfFilePath );
        return xlfFileHandle;
    }

    @SuppressWarnings( "unchecked" )
    public Collection<TranslationUnit> getTranslationUnits( File s2xFile ) throws Exception {

        S2XDocument doc = new S2XDocument( s2xFile );
        return doc.getTexts( );
    }

    public S2XDocument getS2XDocument( File s2xFile ) throws Exception {

        return new S2XDocument( s2xFile );
    }

    public TextverticalizationPackage getTextverticalizationPackage( Connection connection ) {

        TextverticalizationPackage textverticalizationPackage = connection.getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );
        return textverticalizationPackage;
    }

    public Command createCommandForExtendedPartitionOperations( final Connection connection, final Collection<S2XUtil.ExtendedPartitionOperation> extendedPartitionOperations ) {

        return new Command( connection ) {

            private Collection<PartitionOperation> _affectedPartitions = null;

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // Prepare the modifications:
                //( (IdePrimaryFacilityImpl) _ideTestHelper.getDefaultFacility( ) ).getVersioningService( ).prepareModification( getAffectedPartitions( ), IdeDii05VersioningServiceImpl.DARK );

                // Perform the modification described in extendedPartitionOperations:
                for ( S2XUtil.ExtendedPartitionOperation extendedPartitionOperation : extendedPartitionOperations ) {
                    ModelPartition partition = null;
                    switch ( extendedPartitionOperation.getOperation( ) ) {
                        case CREATE:
                            // dirty create partition and fill it with content without text
                            partition = connection.createPartition( extendedPartitionOperation.getPri( ) );
                            addContentWithoutText( partition );
                            break;

                        case CREATE_WITH_1_TEXT_ADDED:
                            // dirty create partition and fill it with content containing text
                            partition = connection.createPartition( extendedPartitionOperation.getPri( ) );
                            addContentWith1Text( connection, partition );
                            break;

                        case DELETE:
                            // dirty delete the partition with its content
                            partition = connection.getPartition( extendedPartitionOperation.getPri( ) );
                            partition.delete( );
                            break;

                        case EDIT:
                            // dirty edit the partition and do not change text (if any) and do not add text
                            partition = connection.getPartition( extendedPartitionOperation.getPri( ) );
                            addContentWithoutText( partition );
                            break;

                        case EDIT_WITH_TEXT_ADDED:
                            // dirty edit the partition and take care that text is added
                            partition = connection.getPartition( extendedPartitionOperation.getPri( ) );
                            addContentWith1Text( connection, partition );
                            break;

                        case EDIT_WITH_TEXT_REMOVED:
                            // dirty remove all model elements which contains text from the partition
                            partition = connection.getPartition( extendedPartitionOperation.getPri( ) );
                            removeAllContentWithText( connection, partition );
                            break;

                        default:
                            throw new UnsupportedOperationException( "Unknown operation: " + extendedPartitionOperation.getOperation( ) ); //$NON-NLS-1$
                    }

                }
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                if ( _affectedPartitions == null ) {
                    _affectedPartitions = new ArrayList<PartitionOperation>( extendedPartitionOperations.size( ) );
                    for ( S2XUtil.ExtendedPartitionOperation extendedPartitionOperation : extendedPartitionOperations ) {
                        _affectedPartitions.add( extendedPartitionOperation.getPartitionOperation( ) );
                    }
                }
                return _affectedPartitions;
            }

        };

    }

    /** **************** Internal ******************************************* */

    private void addContentWithoutText( ModelPartition partition ) {

        partition.createElement( A1.class );
    }

    private void addContentWith1Text( Connection connection, ModelPartition partition ) {

        TextverticalizationPackage textverticalizationPackage = getTextverticalizationPackage( connection );

        int maxWidth = 255;
        String originalText = "my dummy test text"; //$NON-NLS-1$
        String resName = "testResName"; //$NON-NLS-1$
        String resType = "button"; //$NON-NLS-1$
        boolean translate = true;
        TranslatableText translatableText = textverticalizationPackage.createTranslatableText( createStructureForTranslatableText( maxWidth, originalText, resName, resType, translate ) );
        A1f modelElementWithText = partition.createElement( A1f.class );
        modelElementWithText.setTranslatableText( translatableText );
    }

    private <T extends TranslatableText> StructureFieldContainer<T> createStructureForTranslatableText( int maxWidth, String originalText, String resName, String resType, boolean translate ) {

        StructureFieldContainer<T> ttc = new StructureFieldContainer<T>( );
        ttc.put( TranslatableText.DESCRIPTORS.MAX_WIDTH( ), maxWidth ).put( TranslatableText.DESCRIPTORS.ORIGINAL_TEXT( ), originalText );
        ttc.put( TranslatableText.DESCRIPTORS.RES_NAME( ), resName ).put( TranslatableText.DESCRIPTORS.RES_TYPE( ), resType );
        ttc.put( TranslatableText.DESCRIPTORS.TRANSLATE( ), translate );
        return ttc;
    }

    private void removeAllContentWithText( Connection connection, ModelPartition partition ) {

        Collection<Partitionable> elements = partition.getElements( );

        for ( Partitionable partitionable : elements ) {

            CorePartitionable unwrappedPartitionable = _ideTestHelper.getCorePartitionable( partitionable );
            if ( !( unwrappedPartitionable instanceof RefObject ) ) {
                continue;
            }
            RefObject wrappedRefObject = (RefObject) partitionable;
            RefObject unwrappedRefObject = (RefObject) unwrappedPartitionable;

            RefObject unwrappedRefMetaObject = unwrappedRefObject.refMetaObject( );
            if ( !( unwrappedRefMetaObject instanceof MofClass ) ) {
                continue;
            }
            MofClass mofClass = (MofClass) unwrappedRefMetaObject;

            CoreConnection unwrappedConnection = _ideTestHelper.getCoreConnection( connection );
            SpiSession spiSession = unwrappedConnection.getSession( );

            SpiJmiHelper spiJmiHelper = unwrappedConnection.getCoreJmiHelper( );

            if ( spiJmiHelper.hasTranslatableTextFragmentAttribute( spiSession, mofClass ) ) {
                wrappedRefObject.refDelete( );
            }
        }
    }

}
