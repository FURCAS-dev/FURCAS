package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;

import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

/**
 * Add support for the currently visible variables to the OclEnvironment
 */
public class ServiceOCLEnvironment extends OCLEnvironment {

    /**
     * @param theReport report
     * @param theJmiCreator {@link MoinJmiCreator}
     * @param theDefaultContext default context
     * @param contextPackage package
     * @param theDefaultPackages default packages
     * @param theModelElementsByName index
     * @param theModelElementsByOclQualifiedName qualified name
     */
    public ServiceOCLEnvironment( ProcessReport theReport, MoinJmiCreator theJmiCreator, RefObjectImpl theDefaultContext, MofPackageImpl contextPackage, Set<RefPackage> theDefaultPackages, Map<String, List<ModelElement>> theModelElementsByName,
        Map<String, ModelElement> theModelElementsByOclQualifiedName ) {

        super( theReport, theJmiCreator, theDefaultContext, contextPackage, theDefaultPackages, theModelElementsByName, theModelElementsByOclQualifiedName );

    }

    /**
     * @return the variables
     */
    public List<VariableDeclarationInternal> getVariables( ) {

        List<VariableDeclarationInternal> result = new ArrayList<VariableDeclarationInternal>( 0 );
        for ( int i = this.scopeStack.size( ) - 1; i > 1; i-- ) {
            // go through the stack from top to bottom
            ServiceOCLVariableScope s = (ServiceOCLVariableScope) this.scopeStack.get( i );
            result.addAll( s.getVarDecls( ) );
        }
        return result;
    }

    @Override
    public void enterNewVariableScope( ) {

        this.currentScope = new ServiceOCLVariableScope( getJmiCreator( ).getConnection( ) );
        this.scopeStack.push( this.currentScope );
    }

    /**
     * @param newReport the report
     */
    public void setReport( ProcessReport newReport ) {

        this.report = newReport;

    }

}