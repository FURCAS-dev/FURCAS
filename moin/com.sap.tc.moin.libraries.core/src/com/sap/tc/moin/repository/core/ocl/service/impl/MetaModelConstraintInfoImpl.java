package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.util.OclHelperFunctions;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * Constraint Information
 */
public class MetaModelConstraintInfoImpl implements OclMetaModelConstraintRegistration {

    private final String myName;

    private final List<String> myQualifiedName;

    private final String myOclExpression;

    private final Set<String> myConstrainedElements;

    private final int myHash;

    private final OclRegistrationSeverity severity;

    private final Set<String> myCategories = new TreeSet<String>( );

    private final List<OclExpression> constraintViolationExpressions = new ArrayList<OclExpression>( );

    private final MRI constraintMRI;

    /**
     * @param session Session
     * @param violationMessageExpressions Expressions
     * @param qualifiedName qualified name
     * @param oclExpression expression
     * @param theSeverity severity
     * @param categories categories
     * @param constrainedElements elements
     * @param constraint constraint
     */
    public MetaModelConstraintInfoImpl( CoreSession session, JmiList<OclExpression> violationMessageExpressions, List<String> qualifiedName, String oclExpression, OclRegistrationSeverity theSeverity, Set<String> categories, Set<String> constrainedElements, OclConstraintImpl constraint ) {

        this.myName = qualifiedName.toString( );
        this.myQualifiedName = qualifiedName;
        this.myOclExpression = oclExpression;
        this.myConstrainedElements = constrainedElements;
        this.myHash = constraint.refMofId( ).hashCode( );
        this.constraintMRI = constraint.get___Mri( );
        this.severity = theSeverity;
        this.myCategories.addAll( categories );
        if ( violationMessageExpressions != null ) {
            OclHelperFunctions.addAll( session, violationMessageExpressions, this.constraintViolationExpressions );
        }


    }

    public Set<String> getConstrainedElements( ) {

        return this.myConstrainedElements;
    }

    public String getName( ) {

        return this.myName;
    }

    public String getOclExpression( ) {

        return this.myOclExpression;
    }

    public List<String> getQualifiedName( ) {

        return this.myQualifiedName;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof OclRegistration ) {
            return ( this.hashCode( ) == obj.hashCode( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return this.myHash;
    }

    @Override
    public String toString( ) {

        return this.myName;
    }

    public OclRegistrationSeverity getSeverity( ) {

        return this.severity;
    }

    public OclRegistrationType getType( ) {

        return OclRegistrationType.Invariant;
    }

    public Set<String> getCategories( ) {

        return this.myCategories;
    }

    /**
     * @return the expressions for composing the messages
     */
    public List<OclExpression> getConstraintViolationMessageExpression( ) {

        return this.constraintViolationExpressions;
    }

    /**
     * @return the MRI of the constraint
     */
    public MRI getConstraintMRI( ) {

        return this.constraintMRI;
    }
}
