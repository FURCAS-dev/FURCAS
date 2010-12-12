/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.configuration;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackStep;

/**
 * Configures the {@link ImpactAnalyzer} and the {@link InstanceScopeAnalysis} components and choose between different
 * implementation styles. A singleton instance of this class is managed by {@link OptimizationActivation}. The following options
 * can be configured, either by invoking a setter or by passing the respective argument to the constructor:
 * 
 * <ul>
 * <li><b>deltaPropagationActive</b> (see {@link #isDeltaPropagationActive()} and {@link #setDeltaPropagationActive(boolean)}:
 * Tells if the instance scope analysis shall use a delta propagation and partial evaluation mechanism to decide early on if the
 * subexpression(s) immediately affected by the change may propagate the change all the way to the overall expression's evaluation
 * result. This will trigger OCL evaluations for subexpressions, some of which may fail for unknown variables, some of which may
 * prove that the subexpression where the change "hit" doesn't propagate the change, leaving the overall expression unchanged. By
 * and large, this saves significant efforts during re-evaluation as it reduces the set of context instances returned by
 * {@link ImpactAnalyzer#getContextObjects(org.eclipse.emf.common.notify.Notification)} for many cases. Our measurements show that
 * the additional efforts spent for the analysis gets amortized in all cases we have measured. Recommendation: set to
 * <code>true</code>.</li>
 * 
 * <li><b>tracebackStepISAActive</b>: (see {@link #isTracebackStepISAActive()} and {@link #setTracebackStepISAActive(boolean)}:
 * Currently, there are two fundamentally different implementation strategies for the instance scope analysis (see also
 * {@link InstanceScopeAnalysis}). One pre-computes one {@link TracebackStep step} object per (sub-)expression contained in the
 * OCL expression's AST and executes them when
 * {@link ImpactAnalyzer#getContextObjects(org.eclipse.emf.common.notify.Notification)} is invoked. This strategy lends itself
 * well for an additional early pruning of options related to the <b>unusedDetectionActive</b> option explained below. If
 * deselected by setting this option to <code>false</code>, a strategy is selected which materialized only those
 * {@link NavigationStep steps} that actually perform some navigation or filtering on the model graph. The construction of this
 * tree, according to our measurements, is slightly more expensive than the construction of the {@link TracebackStep more
 * elaborate} step graph. On average, the two perform fairly similar. The key difference, as already mentioned, is that only when
 * setting this option to <code>true</code>, the <b>unusedDetectionActive</b> option has any effect.</li>
 * 
 * <li><b>unusedDetectionActive</b> (see {@link #isUnusedDetectionActive()} and {@link #setUnusedDetectionActive(boolean)}:
 * Activates a performance improvement measure which aims to prove that the sub-expression where the change occurred is not used
 * under the variable/parameter/self settings inferred from the information delivered about the change in the change
 * {@link Notification}. For example, if a change occurs in an <code>else</code> branch of an <code>if</code>-expression and the
 * condition can be proven to evaluate to <code>true</code> based on the information taken from the {@link Notification}, this
 * proves that the subexpression that changed its value is not used in evaluating the overall expression. Therefore, the change
 * does not impact the overall expression at all. This technique involves some up-front cost for determining the various checks to
 * be performed. During {@link ImpactAnalyzer#getContextObjects(org.eclipse.emf.common.notify.Notification)} some additional cost
 * is incurred for evaluating sub-expressions (such as an <code>if</code>-expression's condition, as exemplified above). For
 * smaller models, performance seem to be on-par for both settings of this switch. We hope to prove that for certain cases where
 * we see really bad performance without this option being used, using it would significantly shrink the number of elements
 * considered to potentially have changed. This option can only be selected, if {@link #isTracebackStepISAActive()}
 * is <code>true</code>.</li>
 * 
 * <li><b>operationCallSelectionActive</b> (see {@link #isOperationCallSelectionActive()} and
 * {@link #setOperationCallSelectionActive(boolean)}: Activates a performance improvement measure which aims to minimize
 * the {@link OperationCallExp} considered when tracing back through a <code>self</code> or parameter variable inside an
 * operation body. Without this measure, all results obtained from tracing back through all possible calls to the
 * operation considered will be used. With the measure activated, while all results will be computed and cached,
 * only those specific to the call considered will be used further on. This makes the results crisper and smaller but
 * may consume a little more performance during evaluation time because results need to be keyed by {@link OperationCallExp}
 * expressions, causing more data structures to be maintained. This option can only be selected, if {@link #isTracebackStepISAActive()}
 * is <code>true</code>.</li>
 * </ul>
 * 
 */
public class ActivationOption {
    // Level 2 Optimizations
    private boolean isDeltaPropagationActive = true;
    private boolean isTracebackStepISAActive = true; // if set to false, NavigationStep method will be used
    private boolean isUnusedDetectionActive = true;
    private boolean isOperationCallSelectionActive = true;

    private final String optionDescription;

    public ActivationOption(boolean isDeltaPropagationActive, boolean isUnusedDetectionActive, boolean isTracebackStepISAActive,
            boolean isOperationCallSelectionActive, String description) {
	this.isDeltaPropagationActive = isDeltaPropagationActive;
	this.isUnusedDetectionActive = isUnusedDetectionActive;
	this.isTracebackStepISAActive = isTracebackStepISAActive;
	this.isOperationCallSelectionActive = isOperationCallSelectionActive;
	this.optionDescription = description;
    }

    public void setDeltaPropagationActive(boolean isDeltaPropagationActive) {
	this.isDeltaPropagationActive = isDeltaPropagationActive;
    }

    public boolean isDeltaPropagationActive() {
	return isDeltaPropagationActive;
    }

    public void setTracebackStepISAActive(boolean isTracebackStepISAActive){
        this.isTracebackStepISAActive = isTracebackStepISAActive;
    }
    
    public boolean isTracebackStepISAActive(){
        return isTracebackStepISAActive;
    }
    
    public boolean isUnusedDetectionActive() {
        return isUnusedDetectionActive;
    }

    public void setUnusedDetectionActive(boolean isUnusedDetectionActive) {
        this.isUnusedDetectionActive = isUnusedDetectionActive;
    }

    public boolean isOperationCallSelectionActive() {
        return isOperationCallSelectionActive;
    }
    
    public void setOperationCallSelectionActive(boolean isOperationCallSelectionActive) {
        this.isOperationCallSelectionActive = isOperationCallSelectionActive;
    }

    public String getActivationString() {
	StringBuffer activationInformation = new StringBuffer();
	
	activationInformation.append("[TM=");
	activationInformation.append(isTracebackStepISAActive);
	activationInformation.append("]");

	activationInformation.append("[DP=");
	activationInformation.append(isDeltaPropagationActive);
	activationInformation.append("]");

        activationInformation.append("[UD=");
        activationInformation.append(isUnusedDetectionActive);
        activationInformation.append("]");

	return activationInformation.toString();
    }

    // Level 3 Optimization
    // TODO: Add level 3 optimizations

    public String getOptionDescription() {
	return optionDescription;
    }

}
