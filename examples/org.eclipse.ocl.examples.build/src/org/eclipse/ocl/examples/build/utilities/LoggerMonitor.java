/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: LoggerMonitor.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicMonitor;

/**
 * Generates log INFIO messages for each sub task.
 */
public class LoggerMonitor extends BasicMonitor
{
	protected final Logger log;
	
	public LoggerMonitor(Logger log) {
		this.log = log;
	}

	public void subTask(String name) {
		log.info(/*"subTask " +*/ name);
	}
}