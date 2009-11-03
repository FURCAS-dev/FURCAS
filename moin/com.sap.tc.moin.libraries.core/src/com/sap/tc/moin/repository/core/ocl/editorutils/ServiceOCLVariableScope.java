package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.List;

import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;

import com.sap.tc.moin.ocl.parser.impl.env.OCLVariableScope;
import com.sap.tc.moin.repository.core.CoreConnection;


/**
 * Used in the {@link ServiceOCLEnvironment}
 */
public class ServiceOCLVariableScope extends OCLVariableScope {

    /**
     * @param connection the connection
     */
    public ServiceOCLVariableScope( CoreConnection connection ) {

        super( connection );

    }

    /**
     * @return the vairables declared in this scope
     */
    public List<VariableDeclarationInternal> getVarDecls( ) {

        return this.varDeclList;
    }

}