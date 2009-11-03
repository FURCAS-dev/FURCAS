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

package de.ikv.medini.qvt.execution.debug.requests;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyFailure;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyGetValue;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTDebugStackFrame;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTStackFrameEvaluable;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTStackFrameVariable;

/**
 * Debugging request class to get the value of a variable
 * 
 * Always replies with {@link QVTDebugReplyGetValue} or {@link QVTDebugReplyFailure}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugRequestGetValue extends QVTDebugRequest {

	private QVTStackFrameEvaluable val;

	public QVTDebugRequestGetValue(QVTStackFrameEvaluable val) {
		this.val = val;
	}

	public String toString() {
		return "" + this.val;
	}

	public QVTStackFrameEvaluable getExpr() {
		return this.val;
	}

	static public OclAny evaluateOCL(IDebugAdapter debugAdapter, String expression, QVTDebugStackFrame stackFrame) {
		QvtProcessorImpl processor = debugAdapter.getQvtProcessor();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ILog logOcl = new OutputStreamLog(byteArrayOutputStream);
		Environment env = processor.environment();
		RuntimeEnvironment renv = new RuntimeEnvironmentImpl();
		if (stackFrame != null) {
			for (Iterator iter = stackFrame.getVariables().iterator(); iter.hasNext();) {
				QVTStackFrameVariable var = (QVTStackFrameVariable) iter.next();
				QVTDebugRequestGetValue varValueReply = new QVTDebugRequestGetValue(var);
				varValueReply.handleRequest(debugAdapter);
				if (varValueReply.getReply() instanceof QVTDebugReplyGetValue) {
					OclAny oclValue = ((QVTDebugReplyGetValue) varValueReply.getReply()).getValue();
					if (oclValue == null) {
						oclValue = processor.getStdLibAdapter().OclAny(null);
					}
					renv.setValue(var.getName(), oclValue);
					env = env.addVariableDeclaration(var.getName(), var.getDeclaredType(), Boolean.TRUE);
				}
			}
		}
		Object stateInfo = processor.saveSemanticStateInformation();
		try {
			List result;
			processor.setLineDelta(-1);
			try {
				if (stackFrame != null) {
					processor.setTransformationContext(stackFrame.getCurrentTransformation());
					processor.setDirectionContext(stackFrame.getCurrentDirection());
				}
				result = processor.evaluate("context OclVoid inv:\n" + expression, env, renv, logOcl);
			} finally {
				processor.setTransformationContext(null);
				processor.setDirectionContext(null);
				processor.setLineDelta(0);
			}
			if (logOcl.hasErrors()) {
				throw new RuntimeException(new String(byteArrayOutputStream.toByteArray()));
			} else if (result != null && result.size() >= 1) {
				OclAny oclValue = processor.getStdLibAdapter().OclAny(result.get(0));
				return oclValue;
			} else {
				throw new RuntimeException("Evaluation result is " + (result == null ? "null" : "empty"));
			}
		} finally {
			processor.restoreSemanticStateInformation(stateInfo);
		}

	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		try {
			OclAny oclValue = this.val.evaluate(debugAdapter);
			this.setReply(new QVTDebugReplyGetValue(oclValue));
		} catch (Throwable e) {
			this.setReply(new QVTDebugReplyFailure(e.getMessage()));
		}
	}
}
