package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.transactions.actions.DataTypeAttributeAddElementAction;
import com.sap.tc.moin.repository.core.transactions.actions.DataTypeAttributeChangeAction;
import com.sap.tc.moin.repository.core.transactions.actions.DataTypeAttributeChangeElementAction;
import com.sap.tc.moin.repository.core.transactions.actions.DataTypeAttributeRemoveElementAction;
import com.sap.tc.moin.repository.core.transactions.actions.EndStorageLinkRemoveAction;
import com.sap.tc.moin.repository.core.transactions.actions.InstanceDeleteAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionClearDirtyAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionDeleteAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionEnsureChangeAllowedAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionEnsureCreationAllowedAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionEnsureDeletionAllowedAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionEnsureEditingAllowedAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionLockObtainAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionLockReleaseAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionMarkDirtyAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionableAssignPartitionAction;
import com.sap.tc.moin.repository.core.transactions.actions.TransientPartitionDeleteAction;
import com.sap.tc.moin.repository.core.transactions.actions.UpdateConsistencyRegistryAction;
import com.sap.tc.moin.repository.transactions.actions.Action;

public class ActionDeleteComparator extends ClassListBasedComparator<Action> {

    private static List<Class<?>> actionClasses = new ArrayList<Class<?>>( 18 );

    public static final ActionDeleteComparator instance = new ActionDeleteComparator( );

    static {
        // When adding new action classes, remember to adapt the list size!!
        actionClasses.add( PartitionLockObtainAction.class );
        actionClasses.add( PartitionEnsureChangeAllowedAction.class );
        actionClasses.add( PartitionEnsureCreationAllowedAction.class );
        actionClasses.add( PartitionEnsureDeletionAllowedAction.class );
        actionClasses.add( PartitionEnsureEditingAllowedAction.class );
        actionClasses.add( DataTypeAttributeChangeAction.class );
        actionClasses.add( DataTypeAttributeRemoveElementAction.class );
        actionClasses.add( DataTypeAttributeAddElementAction.class );
        actionClasses.add( DataTypeAttributeChangeElementAction.class );
        actionClasses.add( EndStorageLinkRemoveAction.class );
        actionClasses.add( InstanceDeleteAction.class );
        actionClasses.add( PartitionableAssignPartitionAction.class );
        actionClasses.add( PartitionClearDirtyAction.class );
        actionClasses.add( PartitionMarkDirtyAction.class );
        actionClasses.add( PartitionLockReleaseAction.class );
        actionClasses.add( PartitionDeleteAction.class );
        actionClasses.add( TransientPartitionDeleteAction.class );
        actionClasses.add( UpdateConsistencyRegistryAction.class );
    }

    private ActionDeleteComparator( ) {

        super( actionClasses );
    }
}