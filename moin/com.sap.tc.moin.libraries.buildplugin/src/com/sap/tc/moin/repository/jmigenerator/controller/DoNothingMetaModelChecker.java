package com.sap.tc.moin.repository.jmigenerator.controller;

import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;

public class DoNothingMetaModelChecker implements MetaModelCheckerBuild {

    public void doCheck( Connection connection, Set<ModelPartition> partitions ) {

    }
}
