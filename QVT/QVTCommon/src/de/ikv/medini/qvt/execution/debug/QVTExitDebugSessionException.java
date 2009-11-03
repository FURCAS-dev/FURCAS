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

package de.ikv.medini.qvt.execution.debug;

import de.ikv.medini.qvt.QvtProcessorImpl;

/**
 * Exception with which the engine execution is canceled by throwing it and bubble it to
 * {@link QvtProcessorImpl#evaluateQVT(java.io.Reader, String, boolean, String, Object[], java.util.Collection, uk.ac.kent.cs.kmf.util.ILog)} where it is finally catched
 * 
 * @author kiegeland
 * 
 */
public class QVTExitDebugSessionException extends RuntimeException {

}
