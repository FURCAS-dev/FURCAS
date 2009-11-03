package com.sap.tc.moin.repository.core.generator.jmi.javamodel;

import java.util.ArrayList;
import java.util.List;

public class MethodSignature {

    private String methodName = ""; //$NON-NLS-1$

    private List parameterTypeNames = new ArrayList( );

    public MethodSignature( String aMethodName ) {

        methodName = aMethodName;
    }

    public void setParameterTypeNames( List theParameterTypeNames ) {

        parameterTypeNames = theParameterTypeNames;
    }

    public void addParameterTypeName( String aParameterTypeName ) {

        parameterTypeNames.add( aParameterTypeName );
    }

    public List getParameterTypeNames( ) {

        return parameterTypeNames;
    }

    public String getMethodName( ) {

        return methodName;
    }

    @Override
    public boolean equals( Object o ) {

        if ( o instanceof MethodSignature ) {
            MethodSignature s = (MethodSignature) o;
            String mn = s.getMethodName( );
            List tpn = s.getParameterTypeNames( );
            return methodName.equals( mn ) && parameterTypeNames.equals( tpn );
        } else {
            return false;
        }
    }

    @Override
    public int hashCode( ) {

        return 41 * ( methodName.hashCode( ) + parameterTypeNames.hashCode( ) );
    }
}