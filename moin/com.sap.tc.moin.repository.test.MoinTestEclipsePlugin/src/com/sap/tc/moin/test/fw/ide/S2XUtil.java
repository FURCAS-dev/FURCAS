package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.IFile;

import com.sap.s2x.S2XDocument;
import com.sap.s2x.etc.TranslationUnit;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;

public interface S2XUtil {

    IFile getXlfFileHandle( IFile partitionFileHandle );

    Collection<TranslationUnit> getTranslationUnits( File s2xFile ) throws Exception;

    S2XDocument getS2XDocument( File s2xFile ) throws Exception;

    TextverticalizationPackage getTextverticalizationPackage( Connection connection );

    Command createCommandForExtendedPartitionOperations( final Connection connection, final Collection<S2XUtil.ExtendedPartitionOperation> extendedPartitionOperations );

    public static class ExtendedPartitionOperation {

        public enum Operation {
            CREATE, // dirty create the partition and fill it with content without text 
            CREATE_WITH_1_TEXT_ADDED, // dirty create the partition and fill it with content containing 1 text
            DELETE, // dirty delete the partition and its content
            EDIT, // dirty edit the partition and do not change text (if any) and do not add text
            EDIT_WITH_TEXT_ADDED, // dirty edit the partition and take care that text is added
            EDIT_WITH_TEXT_REMOVED; // dirty edit the partition and take care that the existing text (if any) is removed 
        }

        private final Operation _op;

        private final PartitionOperation _partitionOperation;

        public ExtendedPartitionOperation( Operation op, PRI pri ) {

            _op = op;

            PartitionOperation.Operation operation = null;
            switch ( op ) {
                case CREATE:
                case CREATE_WITH_1_TEXT_ADDED:
                    operation = PartitionOperation.Operation.CREATE;
                    break;
                case DELETE:
                    operation = PartitionOperation.Operation.DELETE;
                    break;
                case EDIT:
                case EDIT_WITH_TEXT_ADDED:
                case EDIT_WITH_TEXT_REMOVED:
                    operation = PartitionOperation.Operation.EDIT;
                    break;
                default:
                    operation = PartitionOperation.Operation.EDIT;
                    break;

            }
            _partitionOperation = new PartitionOperation( operation, pri );
        }

        public Operation getOperation( ) {

            return _op;
        }

        public PRI getPri( ) {

            return getPartitionOperation( ).getPartitionPri( );
        }

        public PartitionOperation getPartitionOperation( ) {

            return _partitionOperation;
        }
    }

}
