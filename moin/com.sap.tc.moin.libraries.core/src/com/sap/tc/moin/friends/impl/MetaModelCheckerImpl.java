package com.sap.tc.moin.friends.impl;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.tc.moin.friends.MetaModelChecker;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.core.checks.ModelElementNameAnalyzer;

public class MetaModelCheckerImpl implements MetaModelChecker {

    public NameViolation checkModelElementName( Connection connection, Namespace namespace, ModelElement modelElement ) {
        NameViolation violation = ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( connection, modelElement );
        if ( violation != null ) {
            return violation;
        }
        violation = ModelElementNameAnalyzer.analyzeModelElementNameUniquenessInNamespace( connection, namespace, modelElement, null );
        return violation;
    }

    public NameViolation checkModelElementName( Connection connection, Namespace namespace, String modelElementName ) {
        NameViolation violation = ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( modelElementName );
        if ( violation != null ) {
            return violation;
        }
        violation = ModelElementNameAnalyzer.analyzeModelElementNameUniquenessInNamespace( connection, namespace, null, modelElementName );
        return violation;
    }

    public NameViolation checkToplevelPackageName( Connection connection, CRI containerCri, MofPackage mofPackage ) {
        NameViolation violation = ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( connection, mofPackage );
        if ( violation != null ) {
            return violation;
        }
        violation = ModelElementNameAnalyzer.analyzeToplevelPackageNameUniquenessInContainer( connection, containerCri, mofPackage );
        return violation;
    }

    public NameViolation checkToplevelPackageName( Connection connection, CRI containerCri, String mofPackageName, String prefix ) {
        NameViolation violation = ModelElementNameAnalyzer.analyzeModelElementNameCorrectness( mofPackageName );
        if ( violation != null ) {
            return violation;
        }
        violation = ModelElementNameAnalyzer.analyzeToplevelPackageNameUniquenessInContainer( connection, containerCri, mofPackageName, prefix );
        return violation;
    }
}
