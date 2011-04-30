package org.eclipse.imp.actions;

import org.eclipse.osgi.util.NLS;

public class ActionMessages extends NLS {
    private static final String BUNDLE_NAME= "org.eclipse.imp.actions.ActionMessages"; //$NON-NLS-1$

    public static String OpenAction_label;
    public static String OpenAction_tooltip;
    public static String OpenAction_description;
    public static String OpenAction_declaration_label;
    public static String OpenAction_select_element;

    public static String OpenAction_error_messageBadSelection;
    public static String OpenAction_error_title;
    public static String OpenAction_error_problem_opening_editor;
    public static String OpenAction_error_message;
    public static String OpenAction_error_messageProblems;
    public static String OpenAction_error_messageArgs;
    public static String OpenAction_multistatus_message;

    public static String RulerEnableDisableBreakpointAction_0;
    public static String RulerEnableDisableBreakpointAction_1;
    public static String RulerEnableDisableBreakpointAction_2;
    public static String RulerEnableDisableBreakpointAction_3;

    public static String NewWizardsActionGroup_new;

    private ActionMessages() {
        // no instance
    }

    static {
        NLS.initializeMessages(BUNDLE_NAME, ActionMessages.class);
    }
}
