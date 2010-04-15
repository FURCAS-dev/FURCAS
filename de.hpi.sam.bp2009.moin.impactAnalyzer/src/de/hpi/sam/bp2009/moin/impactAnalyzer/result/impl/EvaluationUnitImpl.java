package de.hpi.sam.bp2009.moin.impactAnalyzer.result.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.ecore.Constraint;

import de.hpi.sam.bp2009.moin.impactAnalyzer.result.InstanceSet;

/**
 * The EvaluationUnit implementation
 */
public class EvaluationUnitImpl implements de.hpi.sam.bp2009.moin.impactAnalyzer.result.EvaluationUnit {

    private final Constraint affectedStatement;

    private final Set<InstanceSet> instanceSets = new HashSet<InstanceSet>( );

    /**
     * @param theAffectedStatement {@link OclStatement}
     */
    public EvaluationUnitImpl( Constraint theAffectedStatement ) {

        this.affectedStatement = theAffectedStatement;
    }

    /**
     * @return Returns the affectedStatement.
     */
    public Constraint getAffectedStatement( ) {

        return this.affectedStatement;
    }

    /**
     * @return Returns the instanceSet.
     */
    public Set<InstanceSet> getInstanceSets( ) {

        return this.instanceSets;
    }

    /**
     * @param instanceSet {@link InstanceSet}
     */
    public void addInstanceSet( InstanceSet instanceSet ) {

        this.instanceSets.add( instanceSet );
    }

}