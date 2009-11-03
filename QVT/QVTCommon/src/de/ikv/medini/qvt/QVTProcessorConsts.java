/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt;

import de.ikv.medini.qvt.execution.QvtSemanticTask;

/**
 * Class defining the properties and their values that are used to configure the QVT processor.
 * 
 * @author Joerg Kiegeland
 * @author Omar Ekine
 * 
 */
public final class QVTProcessorConsts {

	/**
	 * This property determines the directory used to find imported QVT files
	 */
	public static final String PROP_IMPORT_PATH = "importPath";

	/**
	 * This property determines if in debug mode or not. Values can be "true" or "false".
	 */
	public static final String PROP_DEBUG = "debug";

	/**
	 * This property determines if, when debug mode, every single {@link QvtSemanticTask} shall be logged. Values can be "true" or "false". Defaults to "false".
	 */
	public static final String PROP_DEBUG_TASKS = "debugTasks";

	/**
	 * This property determines if DLLs for JMI are debug mode or not. Values can be "true" or "false".
	 */
	public static final String PROP_DEBUG_DLL = "debugDLL";

	/**
	 * This property determines if transformation shall be debugged with the eclipse debug framework or not. Values can be "true" or "false". If set,
	 * {@link #PROP_TRANSFORMATION_PATH} must also be set.
	 */
	public static final String PROP_ECLIPSE_DEBUG = "eclipseDebug";

	/**
	 * This property determines if, when in debug mode, the transformation initially stopped to receive first requests or immediately resumes execution. Defaults to "false", i.e.
	 * the transformation intially stops. This flag also decides whether to resume execution if an exception occured.
	 */
	public static final String PROP_INITIALLY_RESUME_WHEN_DEBUGGING = "initiallyResume";

	/**
	 * This property determines the instantiated debug adapter class. The debug adapter class is only instantiated when {@link #PROP_ECLIPSE_DEBUG} is set.
	 */
	public static final String PROP_DEBUGADAPTER = "debugAdapter";

	/**
	 * This property determines whether traces shall be generated. Values can be "true" or "false". For "false", the traces meta model must exist
	 */
	public static final String PROP_DISABLE_TRACES = "traces";

	/**
	 * This property determines whether traces shall not be loaded when traces are enabled in general. Values can be "true" or "false". Default is "false".
	 */
	public static final String PROP_CLEAR_TRACES = "clearTraces";

	/**
	 * This property determines the instantiated trace adapter class
	 */
	public static final String PROP_TRACEADAPTER = "traceAdapter";

	/**
	 * This property is used to control whether target values are updated if they have been modified manually after the previous transformation. Values can be
	 * {@link #PROP_STRICT_SYCHRONIZATION_ON_VALUE} or {@link #PROP_STRICT_SYCHRONIZATION_OFF_VALUE}.
	 */
	public static final String PROP_STRICT_SYCHRONIZATION = "strictSynchronization";

	/**
	 * Value to turn on {@link #PROP_STRICT_SYCHRONIZATION} (true).
	 */
	public static final String PROP_STRICT_SYCHRONIZATION_ON_VALUE = "true";

	/**
	 * Value to turn off {@link #PROP_STRICT_SYCHRONIZATION} (false).
	 */
	public static final String PROP_STRICT_SYCHRONIZATION_OFF_VALUE = "false";

	/**
	 * Property used to define a metamodel specific delete operation called when an element in the target model is to be deleted. Value is the name of the operation.
	 */
	public static final String PROP_DELETE_OPERATION = "deleteOperation";

	/**
	 * Defines the path to a properties file containing a mapping to the traces metamodel used in JMI
	 */
	// public static final String PROP_TRACES_MAPPING = "traces.mapping";
	/**
	 * If this property is set, in-place transformations are explicitely handled as those, meaning that the transformation is iterated as long there are changes
	 */
	public static final String PROP_INPLACE = "inPlace";

	/**
	 * If this property is set, in-place transformations are explicitely handled as those, meaning that newly created elements are introduced as new candidates to source domains.
	 * This feature is not yet implemented!
	 */
	public static final String PROP_INPLACE_IN_ONE_TRANSFORMATION = "inPlaceInOneTransformation";

	/**
	 * If this property is set, transformations are not done transactional. Values can be "true" or "false". Defaults to "false".
	 */
	public static final String PROP_DISABLE_TRANSACTIONAL_MODE = "transactionalMode";

	/**
	 * The full file path of the transformation's QVT script (including file name and extension)
	 */
	public static final String PROP_TRANSFORMATION_PATH = "transformationPath";

	/**
	 * If set to a number >=1, relations are randomly applied. The number of relation tuples which create more than one model element is given by this number.
	 */
	public static final String PROP_RANDOMIZE = "randomize";

	/**
	 * Parses the model by using the QVT relations as grammar productions, deleting structures completely matched up by the source domains. If this property is set to "true",
	 * {@link #PROP_CLEAN} is set to "true" automatically.
	 */
	public static final String PROP_PARSE = "parse";

	/**
	 * If this property is set, target template variables are not bound per se in when clauses. Deprecated: This flag is not used by the engine anymore, instead, relations are
	 * tried to be evaluated in clean mode if possible (falling back to non-clean-mode at semantic errors)
	 */
	public static final String PROP_CLEAN = "clean";

}
