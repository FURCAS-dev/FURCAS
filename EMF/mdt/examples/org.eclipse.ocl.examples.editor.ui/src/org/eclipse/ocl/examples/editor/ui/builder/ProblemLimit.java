/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ProblemLimit.java,v 1.1 2010/03/11 14:51:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.builder;

import org.eclipse.core.resources.IMarker;

public class ProblemLimit
{
	@SuppressWarnings("serial")
	public static class LimitExceededException extends RuntimeException
	{
		public LimitExceededException(String message) {
			super(message);
		}
	}
	
	private int errorLimit = 0;
	private int warningLimit = 0;
	private int infoLimit = 0;
	
	private int errorCount = 0;
	private int warningCount = 0;
	private int infoCount = 0;

	public ProblemLimit(int errorLimit, int warningLimit, int infoLimit) {
		this.errorLimit = errorLimit;
		this.warningLimit = warningLimit;
		this.infoLimit = infoLimit;
	}
	
	/**
	 * Return the message if problem counts not yet been exceeded.
	 * <br>
	 * Return a replacement message as problem counts are exceeded.
	 * <br>
	 * Return null if problem counts have already been exceeded. 
	 */
	public String check(int severity, String message) {
		if (severity >= IMarker.SEVERITY_ERROR) {
			errorCount++;
			if (errorLimit > 0) {
				if (errorCount > errorLimit)
					return null;
				if (errorCount == errorLimit) {
					return "Too many errors";
				}
			}
		}
		if (severity >= IMarker.SEVERITY_WARNING) {
			warningCount++;
			if (warningLimit > 0) {
				if (warningCount > warningLimit)
					return null;
				if (warningCount == warningLimit) {
					return "Too many warnings or errors";
				}
			}
		}
		{
			infoCount++;
			if (infoLimit > 0) {
				if (infoCount > infoLimit)
					return null;
				if (infoCount == infoLimit) {
					return "Too many infos or warnings or errors";
				}
			}
		}
		return message;
	}
}