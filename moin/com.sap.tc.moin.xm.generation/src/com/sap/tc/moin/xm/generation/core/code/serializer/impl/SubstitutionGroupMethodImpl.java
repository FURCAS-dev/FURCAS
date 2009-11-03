package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.ElementMethodNameAndParameterType;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.SubstitutionGroupMethod;


public class SubstitutionGroupMethodImpl implements SubstitutionGroupMethod {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, SubstitutionGroupMethodImpl.class );

    private final String methodName;

    private final QualifiedName qName;

    private final List<ElementMethodNameAndParameterType> calls = new ArrayList<ElementMethodNameAndParameterType>( 5 );

    /**
     * Constructor.
     * 
     * @param aMethodName method name
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public SubstitutionGroupMethodImpl( final String aMethodName, final QualifiedName substitutionGroupHead ) {

        if ( aMethodName == null ) {
            throw new MoinNullPointerException( "aMethodName" ); //$NON-NLS-1$
        }
        if ( substitutionGroupHead == null ) {
            throw new MoinNullPointerException( "substitutionGroupHead" ); //$NON-NLS-1$
        }
        this.methodName = aMethodName;
        this.qName = substitutionGroupHead;
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Template object for method {0} of substitution group head {1} created", new Object[] { this.getMethodName( ), this.qName.getQName( ) } ); //$NON-NLS-1$
        }
    }

    public List<ElementMethodNameAndParameterType> getMethodCalls( ) {

        return this.calls;
    }

    public String getMethodName( ) {

        return this.methodName;
    }

    public QualifiedName getSubstitutionGroupHead( ) {

        return this.qName;
    }

    @Override
    public String toString( ) {

        return this.getMethodName( );
    }

}
