package de.hpi.sam.bp2009.moin.impactAnalyzer.result.impl;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;

/**
 * The EvaluationUnit implementation
 */
public class EvaluationUnitImpl implements EvaluationUnit {

    private final OclStatement affectedStatement;

    private final Set<InstanceSet> instanceSets = new HashSet<InstanceSet>( );

    /**
     * @param theAffectedStatement {@link OclStatement}
     */
    public EvaluationUnitImpl( OclStatement theAffectedStatement ) {

        this.affectedStatement = theAffectedStatement;
    }

    /**
     * @return Returns the affectedStatement.
     */
    public OclStatement getAffectedStatement( ) {

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