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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;


import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

/**
 * The instance scope analysis's goal is to pre-compute steps for each {@link PropertyCallExp} subexpression in an OCL
 * expression's expression tree. These steps can each be a graph, referring to other potentially composite steps. The graph can
 * even be cyclic, as in the case for recursive operation calls.
 * <p>
 * 
 * During the analysis of the <em>traceback</em> paths, for each subexpression visited, the <code>StepType</code> objects for that
 * node is stored in this cache.
 * <p>
 * 
 * Don't re-use an instance of this class for analyzing more than one expression when those expressions are dynamically parsed
 * because in those cases, new operation calls are created dynamically which turn existing entries in the
 * {@link AbstractPathCache} for <tt>self</tt> and parameter expressions of the operation called invalid. Additionally, all
 * dependent paths would become invalid too. Identifying and removing those entries from a {@link AbstractPathCache} seems to
 * cause more effort than using a new {@link AbstractPathCache} object for each expression analyzed, particularly given the fact
 * that the step assembly only has to happen once per life-time of an {@link OCLExpression<EClassifier>} during
 * a session.
 * 
 */
public abstract class AbstractPathCache<StepType> {
    /**
     * Keys are OCL expressions for which a navigation path is cached, together with a list of tuple part names to be collected
     * during construction of that step. Only if this list is equal during construction then the step can be re-used. Example:
     * <p>
     * 
     * <pre>
     *     let a:Tuple{x1:X=self.myX1, x2:X=self.myX2} in
     *     Set{a.x1, a.x2}->collect(x | x.name)
     * </pre>
     * 
     * If this expression is analyzed for an attribute change event of an <tt>X.name</tt>, the iterator variable <tt>x</tt> is
     * traced back to the collect's source expression which is the collection literal. A branching step is created with one branch
     * for each of its literal parts. Both parts access a tuple part, one the <tt>x1</tt> part, the other the <tt>x2</tt> part of
     * the same tuple. For <tt>a.x1</tt> the tracer pushes "x1" onto the "stack" and constructs a tracer for the <tt>a</tt> source
     * expression. The {@link VariableExpTracer} finds the let expression and constructs the navigation path for the variable's
     * init expression. This, however, is the same {@link TupleLiteralExp} that will be found when tracing back the <tt>a</tt> in
     * <tt>a.x2</tt>. However, the first time the {@link TupleLiteralExpTracer} is constructed, it needs to descend into the
     * <tt>x1</tt> part's init expression whereas for the <tt>a.x2</tt> it needs to descend into <tt>x2</tt>'s init expression.
     * <p>
     * 
     * This shows that a navigation path can only be re-used if the request for its construction has an equal list of tuple
     * literal part names on the "stack" as the one cached.
     * <p>
     * 
     * The <tt>List<String></tt> element of the key pair may be <tt>null</tt>. It <em>must</em> be <tt>null</tt> instead of
     * passing an empty list to avoid ambiguities.
     */
    private final Map<Pair<OCLExpression, List<String>>, StepType> subexpressionToPath = new HashMap<Pair<OCLExpression, List<String>>, StepType>();

    /**
     * Can be used for certain metamodel queries such as finding all subclasses, but as well during an <code>allInstances</code>
     * query.
     */
    private final OppositeEndFinder oppositeEndFinder;
    
    private InstanceScopeAnalysis instanceScopeAnalysis;

    public AbstractPathCache(OppositeEndFinder oppositeEndFinder, InstanceScopeAnalysis instanceScopeAnalysis) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.instanceScopeAnalysis = instanceScopeAnalysis;
    }

    /**
     * Call only immediately after the constructor was called and only in case <code>null</code> was passed for
     * the constructor's <code>instanceScopeAnalysis</code> argument.
     */
    public void initInstanceScopeAnalysis(InstanceScopeAnalysis instanceScopeAnalysis) {
        if (this.instanceScopeAnalysis != null) {
            throw new IllegalStateException("instanceScopeAnalysis field on "+this+" already initialized");
        }
        this.instanceScopeAnalysis = instanceScopeAnalysis;
    }

    public InstanceScopeAnalysis getInstanceScopeAnalysis() {
        return instanceScopeAnalysis;
    }

    public OppositeEndFinder getOppositeEndFinder() {
        return oppositeEndFinder;
    }

    public StepType getPathForNode(OCLExpression subexpression, Stack<String> tupleLiteralPartNamesToLookFor) {
        return subexpressionToPath.get(new Pair<OCLExpression, List<String>>(subexpression,
                getTupleLiteralPartNamesToLookForAsList(tupleLiteralPartNamesToLookFor)));
    }

    /**
     * Also adds <code>path</code> to {@link #allSteps}. If the source type is <code>null</code> and the step is not
     * absolute, this path cache registers as a listener on the step (see
     * {@link StepType#addSourceTypeChangeListener(SourceTypeChangeListener)}. If the target type is <code>null</code>, this
     * path cache registers as target type listener on the step (see
     * {@link StepType#addTargetTypeChangeListener(TargetTypeChangeListener)}. If the step is not marked as always empty,
     * this path cache registers as listener for a change in the step's always-empty setting. If any of these change events are
     * received, the respective step is re-hashed into {@link #allSteps}.
     */
    public void put(OCLExpression subexpression, Stack<String> tupleLiteralPartNamesToLookFor, StepType path) {
        List<String> tupleLiteralPartNamesToLookForAsList = getTupleLiteralPartNamesToLookForAsList(tupleLiteralPartNamesToLookFor);
        subexpressionToPath.put(new Pair<OCLExpression, List<String>>(subexpression, tupleLiteralPartNamesToLookForAsList), path);
    }

    private static List<String> getTupleLiteralPartNamesToLookForAsList(Stack<String> tupleLiteralPartNamesToLookFor) {
        List<String> tupleLiteralPartNamesToLookForAsList;
        if (tupleLiteralPartNamesToLookFor == null || tupleLiteralPartNamesToLookFor.size() == 0) {
            tupleLiteralPartNamesToLookForAsList = null;
        } else {
            tupleLiteralPartNamesToLookForAsList = new ArrayList<String>();
            Iterator<String> it = tupleLiteralPartNamesToLookFor.listIterator();
            while(it.hasNext()){
                tupleLiteralPartNamesToLookForAsList.add(it.next());
            }
        }
        return tupleLiteralPartNamesToLookForAsList;
    }

    public StepType getOrCreateNavigationPath(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, OCLFactory oclFactory) {
        StepType result = getPathForNode(sourceExpression, tupleLiteralNamesToLookFor);
        if (result == null) {
            result = createStep(sourceExpression, context, operationBodyToCallMapper, tupleLiteralNamesToLookFor, oclFactory);
            put(sourceExpression, tupleLiteralNamesToLookFor, result);
        }
        return result;
    }

    protected abstract StepType createStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, OCLFactory oclFactory);

}
