package com.sap.tc.moin.repository.jmigenerator.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * Manages a collection of checkers and executes the them in addition order.
 * 
 * @author D046220
 */
public abstract class CompositeMetaModelChecker implements MetaModelCheckerBuild {

    private List<MetaModelCheckerBuild> checkers = new LinkedList<MetaModelCheckerBuild>( );

    public void doCheck( Connection connection, Set<ModelPartition> partitions ) {

        for ( MetaModelCheckerBuild checker : checkers ) {
            checker.doCheck( connection, partitions );
        }
    }

    public void addChecker( MetaModelCheckerBuild checkerToBeAdded ) {

        checkers.add( checkerToBeAdded );
    }
}
