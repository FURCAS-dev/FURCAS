package com.sap.mi.fwk.ui.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Text accessor for plugin <code>com.sap.mi.fwk.ui</code>
 *
 * @author d031150
 */
public final class MiFwkUiMessages extends NLS {

	private static final String BUNDLE_NAME = "com.sap.mi.fwk.ui.internal.messages.messages"; //$NON-NLS-1$

	public static String DeleteElementHandler_confimtitleSingle;
	public static String DeleteElementHandler_confimtitleMultiple;
	public static String DeleteElementHandler_confirmmsgSingle;
	public static String DeleteElementHandler_confirmmsgMultiple;
	public static String DeleteElementsCmd_desc;

	public static String AbstractCommandHandler_CancelledMessage;

	public static String AbstractCommandHandler_creating;
	public static String AbstractCommandHandler_running;
	public static String AbstractCommandHandler_undoing;

	public static String AssignElementsDialog_title;
	public static String AssignElementsDialog_text_null;
	public static String AssignElementsDialog_text_null_transient;
	public static String AssignElementsDialog_text_transient;
	public static String AssignElementsDialog_clearButton_text;
	public static String AssignElementsDialog_deleteButton_text;
	public static String AssignElementsDialog_elementInfo_null;
	public static String AssignElementsDialog_elements_group;
	public static String AssignElementsDialog_inputDialog_partitionExists_error;
	public static String AssignElementsDialog_inputDialog_partitionInvalid_error;
	public static String AssignElementsDialog_inputDialog_text;
	public static String AssignElementsDialog_inputDialog_title;
	public static String AssignElementsDialog_newButton_text;
	public static String AssignElementsDialog_newButton_tooltip;
	public static String AssignElementsDialog_partitions_label;

	public static String ButtonMoveRefObjectInList_ButtonTextDown;

	public static String ButtonMoveRefObjectInList_ButtonTextUp;

	public static String ButtonMoveRefObjectInList_CommandGroupNameMove;

	public static String ConnectionManagerUI_createConnection_jobLabel;
	public static String ConnectionManagerUI_createDefaultConnection_jobLabel;

	public static String ConnectionManagerUI_Message_UI_Update;

	public static String ConsistencyResolutionGenerator_applyingResolution;

	public static String Clipboard_newPartitionCmd_label;
	public static String Clipboard_pasteCommand_label;
	public static String Clipboard_selectAssocDialog_msg;
	public static String Clipboard_selectAssocDialog_title;
	public static String Clipboard_conflictingPartitionDialog_conflict_error;
	public static String Clipboard_conflictingPartitionDialog_conflictInvalidPath_error;
	public static String Clipboard_conflictingPartitionDialog_msg;
	public static String Clipboard_conflictingPartitionDialog_title;

	public static String CopyObjectsAction_name;
	public static String PasteObjectsAction_name;

	public static String MetamodelManager_newWorkingSet_name;
	public static String MetamodelManager_status_deployed;
	public static String MetamodelManager_status_notDeployable;
	public static String MetamodelManager_status_notDeployed;
	public static String MetamodelManager_status_unknown;
	public static String MetamodelManager_status_versionConflict;

	public static String MmPropertySource_category;
	public static String MmPropertySource_containerName_label;
	public static String MmPropertySource_label_label;
	public static String MmPropertySource_location_label;
	public static String MmPropertySource_plugin_label;
	public static String MmPropertySource_status_label;
	public static String MmPropertySource_version_label;
	public static String MmPropertySource_elements;

	public static String MmWorkingSetPage_content_label;
	public static String MmWorkingSetPage_description;
	public static String MmWorkingSetPage_deselectAllButton_text;
	public static String MmWorkingSetPage_deselectAllButton_tooltip;
	public static String MmWorkingSetPage_name_empty_error;
	public static String MmWorkingSetPage_name_label;
	public static String MmWorkingSetPage_name_whitespace_error;
	public static String MmWorkingSetPage_noSet_info;
	public static String MmWorkingSetPage_pendingNode_label;
	public static String MmWorkingSetPage_selectAllButton_text;
	public static String MmWorkingSetPage_selectAllButton_tooltip;
	public static String MmWorkingSetPage_set_exists_error;
	public static String MmWorkingSetPage_task_fetching;
	public static String MmWorkingSetPage_title;

	public static String ModeEditor_pending_pageText;

	public static String ModelEditor_initEditor_jobLabel;
	public static String ModelEditor_pending_label;
	public static String ModelEditorInput_tooltip;
	public static String ModelEditorInput_objectNotFound;

	public static String RefObjectObservableValue_CommandNameValueChange;

	public static String RefObjectPropertySource_file_label;
	public static String RefObjectPropertySource_groupAttributes_label;
	public static String RefObjectPropertySource_groupPartition_label;
	public static String RefObjectPropertySource_id_label;
	public static String RefObjectPropertySource_metamodelPartition_value;
	public static String RefObjectPropertySource_nullPartition_value;
	public static String RefObjectPropertySource_partition_value;
	public static String RefObjectPropertySource_transientPartition_value;
	public static String RefObjectPropertySource_type_label;
	public static String RefObjectPropertySource_setAttributeCommand_name;
	public static String RefObjectPropertySource_invalidDouble_error;
	public static String RefObjectPropertySource_invalidFloat_error;
	public static String RefObjectPropertySource_invalidInt_error;
	public static String RefObjectPropertySource_invalidLong_error;

	public static String RefreshModelData_saveDialog_title;
	public static String RefreshModelData_saveDialog_text;
	public static String RefreshModelData_saveDialog_text_askAgain;
	public static String RefreshModelData_monitor_refreshing;
	public static String RefreshModelData_monitor_saving;

	public static String DeleteModelData_confirmDialog_text;
	public static String DeleteModelData_confirmDialog_title;

	public static String MarkerSelectionDialog_text;
	public static String MarkerSelectionDialog_title;

	public static String ProjectSelectionDialog_text;
	public static String ProjectSelectionDialog_title;

	public static String QuickfixSelectionDialog_text;
	public static String QuickfixSelectionDialog_title;

	public static String ModelEditorSavePreferencePage_mode_editor_save_operations;
	public static String ModelEditorSavePreferencePage_show_editor_save_dialog;

	public static String ModelEditorManager_startingEditor;

	public static String ModelEditorManagerSaveDialog_do_not_show_again;
	public static String ModelEditorManagerSaveDialog_press_ok_to_save;
	public static String ModelEditorManagerSaveDialog_save_conflicting_editors;
	public static String ModelEditorManagerSaveDialog_save_the_following_editors;

	public static String LoadingData_Label;

	public static String OpenEditorActionProvider_open;

	public static String OpenWithEditorActionProvider_openwith;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, MiFwkUiMessages.class);
	}

	private MiFwkUiMessages() {
	}
}
