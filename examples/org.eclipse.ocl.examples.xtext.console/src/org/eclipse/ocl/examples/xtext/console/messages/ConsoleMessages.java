/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - rework of LPG OCL Console for Xtext
 *
 * </copyright>
 *
 * $Id: ConsoleMessages.java,v 1.2 2011/05/07 17:18:05 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.console.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class ConsoleMessages
{
	static {
		NLS.initializeMessages(ConsoleMessages.class.getName(), ConsoleMessages.class);
	}

	public static String CloseAction_Label;
	public static String CloseAction_Tip;
	public static String Console_Title;
	public static String Console_TitleWithContext;
	public static String Heading_Evaluating;
	public static String Heading_Results;
	public static String LoadAction_Label;
	public static String LoadAction_Tip;
	public static String LoadAction_Title;
	public static String LoadActionError_Title;
	public static String LoadActionWarning_Title;
	public static String LoadActionWarning_NoExpression;
	public static String LoadResourceAction_Tip;
	public static String Output_Exception;
//	public static String Progress_AST;
//	public static String Progress_CST;
	public static String Progress_Evaluating;
	public static String Progress_Extent;
	public static String Progress_Synchronising;
	public static String Progress_Title;
	public static String Result_EvaluationFailure;
	public static String Result_EvaluationTerminated;
	public static String Result_MappingFailure;
	public static String Result_NoExpression;
	public static String Result_Parsed;
	public static String Result_ParsingFailure;
	public static String SaveAction_Label;
	public static String SaveAction_Tip;
	public static String SaveAction_Title;
	public static String SaveActionError_Title;
	public static String SaveActionWarning_Title;
	public static String SaveActionWarning_NoExpression;
	public static String ValueFactory_Cancelable;

	/*	
	public static String console_noContext;
	public static String console_badContextForQuery;
	public static String console_badContextForConstraint;
	public static String console_loadResourceAction_label;
	public static String console_metamodelMenu;
	public static String console_metamodelTip;
	public static String console_metamodel_ecore;
	public static String console_metamodel_ecoreTip;
	public static String console_metamodel_uml;
	public static String console_metamodel_umlTip;
	public static String console_modelingLevel;
	public static String console_modelingLevelTip; */
}
