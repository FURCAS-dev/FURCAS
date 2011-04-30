/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.preferences;

/**
 * Class that defines the set of preference keys used by the IMP editor. These keys can be
 * used to define/query preference values at any of the levels IMP supports: "instance"
 * (aka workspace), "configuration" (i.e. an Eclipse installation), or "project" (for a
 * project-specific setting). For several of these, it is possible to define a language-
 * specific setting that overrides the global setting. The JavaDoc for each such field
 * indicates that fact.
 * <p>To access these and other preferences, use the IPreferencesService interface and
 * its implementation class, PreferencesService.
 * @see IPreferencesService
 * @see PreferencesService
 * @author rfuhrer@watson.ibm.com
 */
public class PreferenceConstants {
    public static final String P_EMIT_MESSAGES= "emitMessages";

    /**
     * A named preference that controls the width of a tab in spaces in the source editor.
     * Language-specific settings are supported for this preference.
     * <p>
     * Value is of type <code>Integer</code>.
     * </p>
     */
    public static final String P_TAB_WIDTH= "tabWidth";

    /**
     * A named preference that controls whether the editor should substitute spaces for tabs.
     * Can be overridden by a language-specific preference of the same key.
     * <p>
     * Value is of type <code>Boolean</code>.
     * </p>
     */
    public static final String P_SPACES_FOR_TABS= "spacesForTabs";

    /**
     * A named preference that controls the font to use in the source editor.
     * <p>
     * Value is of type <code>FontData</code>.
     * </p>
     */
    public static final String P_SOURCE_FONT= "sourceFont";

    /**
     * A named preference that controls whether to dump tokens to a console when parsing fails. For
     * diagnostic purposes.
     * <p>
     * Value is of type <code>Boolean</code>.
     * </p>
     */
    public static final String P_DUMP_TOKENS= "dumpTokens";

    /**
     * A named preference that controls whether the project explorer's selection is linked to the active editor.
     * <p>
     * Value is of type <code>Boolean</code>.
     * </p>
     */
    public static final String LINK_EXPLORER_TO_EDITOR= "org.eclipse.imp.ui.projects.linktoeditor"; //$NON-NLS-1$

    /**
     * A named preference that controls whether bracket matching highlighting is turned on or off.
     * <p>
     * Value is of type <code>Boolean</code>.
     * </p>
     */
    public static final String EDITOR_MATCHING_BRACKETS= "matchingBrackets"; //$NON-NLS-1$

    /**
     * A named preference that holds the color used to highlight matching brackets.
     * <p>
     * Value is of type <code>String</code>. A RGB color value encoded as a string 
     * using class <code>PreferenceConverter</code>
     * </p>
     * 
     * @see org.eclipse.jface.resource.StringConverter
     * @see org.eclipse.jface.preference.PreferenceConverter
     */
    public static final String EDITOR_MATCHING_BRACKETS_COLOR=  "matchingBracketsColor"; //$NON-NLS-1$

    /**
     * A named preference that controls whether "fences" (e.g. parens or braces) are automatically closed.
     * <p>
     * Value is of type <code>Boolean</code>.
     * </p>
     */
    public static final String EDITOR_CLOSE_FENCES= "closeFences"; //$NON-NLS-1$

    /**
     * A named preference that controls whether builders should emit diagnostics. Can be overridden
     * by a language-specific builder preference of the same key.
     * <p>
     * Value is of type <code>Boolean</code>.
     * </p>
     */
    public static final String P_EMIT_BUILDER_DIAGNOSTICS= "emitBuilderDiagnostics"; //$NON-NLS-1$

    private PreferenceConstants() { }
}
