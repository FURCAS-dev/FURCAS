package com.sap.tc.moin.versioning.di.impl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.tc.moin.versioning.di.impl.messages"; //$NON-NLS-1$
	public static String CheckoutDialog_confirmCheckout_XGRP;
	public static String CheckoutDialog_doNotShowAgain_XCKL;
	public static String CheckoutDialog_filesToBeCreated_XTND;
	public static String CheckoutDialog_filesToBeDeleted_XTND;
	public static String CheckoutDialog_filesToBeEdited_XTND;
	public static String CheckoutDialog_filesToBeEditedExclusive_XTND;
	public static String CheckoutDialog_problemDetails_XGRP;
	public static String CheckoutDialog_proceed_XBUT;
	public static String CheckoutDialog_warningOtherCheckouters_YMSG;
	public static String PreparationCheckResult_ok_XMSG;
	public static String VersioningPreferencePage_showDialogBeforeCheckout_XCKL;
	public static String VersioningPreferencePage_title_XGRP;
	public static String VersioningServiceImpl_changelistMissing_XMSG;
    public static String VersioningServiceImpl_checkedOutByOtherUser_XMSG;
	public static String VersioningServiceImpl_checkedOutByOtherUsers_XMSG;
    public static String VersioningServiceImpl_checkingRepositoryStatesCanceled_XMSG;
    public static String VersioningServiceImpl_checkingRepositoryStatesInterrupted_XMSG;
	public static String VersioningServiceImpl_checkoutCanceled_XMSG;
    public static String VersioningServiceImpl_checkoutDialogErrorMessage_XMSG;
	public static String VersioningServiceImpl_checkoutDialogMessage_XMSG;
	public static String VersioningServiceImpl_checkoutFiles_XMSG;
	public static String VersioningServiceImpl_computingRepositoryStates_XMSG;
	public static String VersioningServiceImpl_DCNotModifiable_XMSG;
	public static String VersioningServiceImpl_errorGettingRepositoryState_XMSG;
	public static String VersioningServiceImpl_errorPrefix_XMSG;
	public static String VersioningServiceImpl_errorsOccuredOnCheckout_XMSG;
	public static String VersioningServiceImpl_errorsOnAdd_XMSG;
	public static String VersioningServiceImpl_errorsOnDeletion_XMSG;
	public static String VersioningServiceImpl_fileExists_XMSG;
	public static String VersioningServiceImpl_fileReadOnlyNotUnderSrcControl_XMSG;
	public static String VersioningServiceImpl_infoPrefix_XMSG;
	public static String VersioningServiceImpl_modificationNotPossible_XGRP;
	public static String VersioningServiceImpl_notSyncedToLatest_XMSG;
	public static String VersioningServiceImpl_performingRepositoryOperations_XMSG;
	public static String VersioningServiceImpl_preparationWasCanceled_XMSG;
    public static String VersioningServiceImpl_prepareCreate_XGRP;
	public static String VersioningServiceImpl_prepareDelete_XGRP;
	public static String VersioningServiceImpl_prepareEdit_XGRP;
	public static String VersioningServiceImpl_prepareEditExclusive_XGRP;
	public static String VersioningServiceImpl_checkoutDialogTitle_XGRP;
    public static String VersioningServiceImpl_logonFailed_XMSG;
	public static String VersioningServiceImpl_readOnlyFilesInNonDTRProject_XMSG;
	public static String VersioningServiceImpl_readOnlyPrefix_XMSG;
	public static String VersioningServiceImpl_RefreshingFiles_XMSG;
    public static String VersioningServiceImpl_RepositoryOperationsFailed_XMSG;
	public static String VersioningServiceImpl_warningPrefix_XMSG;
	public static String VersioningServiceImpl_writeablilityRequired_XMSG;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
