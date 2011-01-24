/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Continuations.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;

public class Continuations implements Continuation<ModelElementCS>
{
	public static Continuation<?> combine(Continuation<?>... inputContinuations) {
		List<BasicContinuation<?>> continuations = null;
		Continuation<?> continuation = null;
		for (Continuation<?> inputContinuation : inputContinuations) {
			if (inputContinuation != null) {
				if (continuation == null) {
					continuation = inputContinuation;
				}
				else {
					if (continuations == null) {
						continuations = new ArrayList<BasicContinuation<?>>();
						continuation.addTo(continuations);
					}
					inputContinuation.addTo(continuations);
				}
			}		
		}
		return continuations != null ? new Continuations(continuations) : continuation;
	}

	private List<BasicContinuation<?>> continuations = new ArrayList<BasicContinuation<?>>();
	
	public Continuations() {
		this.continuations = null;
	}
	
	public Continuations(List<BasicContinuation<?>> continuations) {
		this.continuations = continuations;
	}

	public void add(BasicContinuation<?> continuation) {
		if (continuation != null) {
			if (continuations == null) {
				continuations = new ArrayList<BasicContinuation<?>>();
			}
			continuations.add(continuation);
		}
	}
	
	public void addTo(List<BasicContinuation<?>> simpleContinuations) {
		for (BasicContinuation<?> continuation : continuations) {
			continuation.addTo(simpleContinuations);
		}
	}
	
	public Continuation<?> getContinuation() {
		if ((continuations == null) || continuations.isEmpty()) {
			return null;
		}
		else if (continuations.size() == 1) {
			return continuations.get(0);
		}
		else {
			return this;
		}
	}
}