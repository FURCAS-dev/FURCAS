package com.sap.mi.fwk.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Translatable text accessor for <code>com.sap.mi.fwk</code>
 * 
 * @author d024127
 * 
 */
public class MiFwkMessages extends NLS {

	private static final String BUNDLE_NAME = "com.sap.mi.fwk.internal.messages.messages"; //$NON-NLS-1$

	public static String CommandManagerCore_conflictingConnections;

	public static String CommandManagerCore_connectionLocksModelPartitions;

	public static String ConnectionManager_CommandGroupNameListenerRegistration;

	public static String ConnectionManager_StatusErrorDuringSave;

	public static String MoinConstraintChecker_getting_deltas;
	public static String MoinConstraintChecker_checking_constraints;
	public static String MoinConstraintChecker_checking_consistency;

	public static String MoinOperation_StatusNothingToRedo;

	public static String MoinOperation_StatusNothingToUndo;

	public static String PartitionService_CommandNameAssignElements;

	public static String PartitionService_CommandNameDeleteElements;

	public static String PartitionService_CommandNameDeletePartition;

	public static String PartitionService_ConnectionNameDeletePartitions;

	public static String PartitionService_ProgressMessageDeleting;

	public static String PartitionService_StatusConnectionCreationFailed;

	public static String PartitionService_StatusDeletingDataFailed;

	/**
	 * initialize static pool
	 */
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, MiFwkMessages.class);
	}

	/**
	 * hidden constructor
	 */
	private MiFwkMessages() {
	}
}
