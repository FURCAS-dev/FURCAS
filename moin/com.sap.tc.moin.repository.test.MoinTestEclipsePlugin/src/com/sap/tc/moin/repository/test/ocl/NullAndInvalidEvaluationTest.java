package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;
import org.omg.ocl.expressions.OclExpression;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.company.Employee;
import com.sap.company.__impl.CompanyPackageImpl;
import com.sap.company.__impl.DepartmentImpl;
import com.sap.company.__impl.EmployeeImpl;
import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.ExpressionUndefinedException;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclTest;

public class NullAndInvalidEvaluationTest extends BaseOclTest {

    private CompanyPackageImpl companyPackage;

    private RefPackage[] parserPackages;

    @Test
    public void nullLiteralEvaluationToString( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );

            verify( parseAndEvaluateAsBoolean( "null.toString() = 'null'", employee, true ), "null.toString() = 'null'" );
        }
    }

    @Test
    public void nullLiteralEvaluationSize( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "null->size() = 0", employee, true ), "null->size() = 0" );
            verify( parseAndEvaluateAsBoolean( "null.asSet()->size() = 0", employee, true ), "null.asSet()->size() = 0" );
        }
    }

    @Test
    public void nullLiteralEvaluationEquals( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "null = null", employee, true ), "null = null" );
        }
    }

    @Test
    public void nullLiteralEvaluationIsUndefined( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "null.oclIsUndefined()", employee, true ), "null.oclIsUndefined() = true" );
        }
    }

    @Test
    public void nullLiteralEvaluationIsInvalid( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "null.oclIsInvalid()", employee, false ), "null.oclIsInvalid() = false" );
        }
    }

    @Test
    public void nullLiteralEvaluationAllInstances( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "OclVoid.allInstances()->size() = 1", employee, true ), "OclVoid.allInstances()->size() = 1" );
        }
    }

    @Test
    public void nullLiteralEvaluationIsKindOf( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "null.oclIsKindOf(OclVoid)", employee, true ), "null.oclIsKindOf(OclVoid) = true" );
            verify( parseAndEvaluateAsBoolean( "null.oclIsKindOf(OclInvalid)", employee, false ), "null.oclIsKindOf(OclInvalid) = false" );
            verify( parseAndEvaluateAsBoolean( "null.oclIsKindOf(Model::ModelElement)", employee, false ), "null.oclIsKindOf(ModelElement) = false" );
        }
    }

    @Test
    public void nullLiteralEvaluationOclAsType( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "null.oclAsType(OclVoid) = null", employee, true ), "null.oclAsType(OclVoid) = null" );
            verify( parseAndEvaluateAsBoolean( "null.oclAsType(OclInvalid) = null", employee, true ), "null.oclAsType(OclInvalid) = null" );
            verify( parseAndEvaluateAsBoolean( "null.oclAsType(String) = null", employee, true ), "null.oclAsType(String) = null" );
        }
    }

    @Test
    public void nullLiteralEvaluationParseIsKindOf( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // ParsingExceptions
            this.parseFail( "null.oclIsKindOf(null)", employee, this.parserPackages );
            // Why this?! this.parseFail("null.oclIsKindOf(String)", employee,
            // this.parserPackages);

        }
    }

    @Test
    public void nullLiteralEvaluationParseOclAsType( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // ParsingExceptions
            this.parseFail( "null.oclAsType(null)", employee, this.parserPackages );
            // Why this?! this.parseFail("null.oclAsType(String)", employee,
            // this.parserPackages);

        }
    }

    @Test
    public void invalidLiteralEvaluationParseIsKindOf( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // ParsingExceptions
            this.parseFail( "invalid.oclIsKindOf(invalid)", employee, this.parserPackages );
            // Why this?! this.parseFail("invalid.oclIsKindOf(String)",
            // employee, this.parserPackages);

        }
    }

    @Test
    public void invalidLiteralEvaluationParseOclAsType( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // ParsingExceptions
            this.parseFail( "invalid.oclAsType(invalid)", employee, this.parserPackages );
            // Why this?! this.parseFail("invalid.oclAsType(String)", employee,
            // this.parserPackages);

        }
    }

    @Test
    public void simpleNavigationWithNull( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.name should result in null
            verify( parseAndEvaluate( "self.name", employee, true, false ), "Simple navigation to initial association end did not result in null" );
            // self.name=null should result in true
            verify( parseAndEvaluateAsBoolean( "self.name=null", employee, true ), "Comparison of null and null failed" );

            ( (EmployeeImpl) employee ).setName( coreConnection, "SomeNiceName" );

            // self.name should not result in null
            verify( parseAndEvaluate( "self.name", employee, false, false ), "Simple navigation to non-initial association end did result in null" );
        }
    }

    @Test
    public void simpleNavigationWithOclIsUndefined( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.name.oclIsInvalid() should result in false
            verify( parseAndEvaluateAsBoolean( "self.name.oclIsInvalid()", employee, false ), "Comparison of null and invalid failed" );

            ( (EmployeeImpl) employee ).setName( coreConnection, "SomeNiceName" );

            // self.name.oclIsUndefined() should result in false
            verify( parseAndEvaluateAsBoolean( "self.name.oclIsUndefined()", employee, false ), "Comparison of not null and oclUndefined failed" );
        }
    }

    @Test
    public void simpleNavigationWithOclIsInvalid( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.name.oclIsInvalid() should result in false
            verify( parseAndEvaluateAsBoolean( "self.name.oclIsInvalid()", employee, false ), "Comparison of null and invalid failed" );

            ( (EmployeeImpl) employee ).setName( coreConnection, "SomeNiceName" );

            // self.name.oclIsInvalid() should result in false
            verify( parseAndEvaluateAsBoolean( "self.name.oclIsInvalid()", employee, false ), "Comparison of not null and invalid failed" );
        }
    }

    @Test
    public void simpleNavigationSize( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.name->size()=0 should result in true
            verify( parseAndEvaluateAsBoolean( "self.name->size()=0", employee, true ), "Comparison of null empty Set" );

            ( (EmployeeImpl) employee ).setName( coreConnection, "SomeNiceName" );

            // self.name->size()=1 should result in true
            verify( parseAndEvaluateAsBoolean( "self.name->size()=1", employee, true ), "Comparison of not null and non-empty Set failed" );
        }
    }

    @Test
    public void simpleNavigationEquality( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );

            ( (EmployeeImpl) employee ).setName( coreConnection, "SomeNiceName" );

            // self.name=null should be false
            verify( parseAndEvaluateAsBoolean( "self.name = null", employee, false ), "Comparison of not not null and null failed" );
            // self.name=null should be false (equivalent)
            verify( parseAndEvaluateAsBoolean( "self.name <> null", employee, true ), "Comparison of not null and null failed" );
        }
    }

    @Test
    public void objectValuedNavigationNotSetValue( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.employer should result in null
            verify( parseAndEvaluate( "self.employer", employee, true, false ), "Object navigation to initial association end did not result in null" );
            // self.employer=null should result in true
            verify( parseAndEvaluateAsBoolean( "self.employer=null", employee, true ), "Comparison of null and null failed" );
            // self.employer.name should result in Exception
            verify( parseAndEvaluate( "self.employer.name", employee, true, false ), "Comparison of null navigation and oclundefined failed" );
        }
    }

    @Test
    public void objectValuedNavigationNotSetValueOclIsUndefined( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );

            // self.employer.oclIsUndefined() should result in true
            verify( parseAndEvaluateAsBoolean( "self.employer.oclIsUndefined()", employee, true ), "Comparison of null and oclUndefined failed" );
            // self.employer.name.oclIsUndefined() Exception
            verify( parseAndEvaluateAsBoolean( "self.employer.name.oclIsUndefined()", employee, true ), "Comparison of null navigation and oclundefined failed" );
        }
    }

    @Test
    public void objectValuedNavigationNotSetValueOclIsInvalid( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.employer.oclIsInvalid() should result in false
            verify( parseAndEvaluateAsBoolean( "self.employer.oclIsUndefined()", employee, true ), "Comparison of null and oclundefined failed" );
            // self.employer.name.oclIsInvalid() should result Exception
            verify( parseAndEvaluate( "self.employer.name.oclIsUndefined()", employee, false, false ), "Navigation behind null should have failed" );
        }
    }

    @Test
    public void objectValuedNavigationNotSetValueSize( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            // self.employer->size()=0 should result in true
            verify( parseAndEvaluateAsBoolean( "self.employer->size()=0", employee, true ), "Comparison of null and empty Set" );
        }
    }

    @Test
    public void objectValuedNavigationSetValue( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            DepartmentImpl employer = (DepartmentImpl) getTestHelper( ).getCorePartitionable( coreConnection.getWrapper( ).createElementInPartition( Department.class, null ) );
            ( (EmployeeImpl) employee ).setEmployer( coreConnection, employer );

            // self.employer should not in null
            verify( parseAndEvaluate( "self.employer", employee, false, false ), "Object navigation to initial association end did not result in null" );
            // self.employer=null should result in false
            verify( parseAndEvaluateAsBoolean( "self.employer=null", employee, false ), "Comparison of null and null failed" );
            // self.employer.name should not result in null
            verify( parseAndEvaluate( "self.employer.name", employee, true, false ), "Comparison of null navigation and oclundefined failed" );
        }
    }

    @Test
    public void objectValuedNavigationSetValueOclIsUndefined( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            DepartmentImpl employer = (DepartmentImpl) getTestHelper( ).getCorePartitionable( coreConnection.getWrapper( ).createElementInPartition( Department.class, null ) );
            ( (EmployeeImpl) employee ).setEmployer( coreConnection, employer );

            // self.employer.oclIsUndefined() should result in false
            verify( parseAndEvaluateAsBoolean( "self.employer.oclIsUndefined()", employee, false ), "Comparison of null and oclUndefined failed" );

            // self.employer.name.oclIsUndefined() should result in true (it's
            // null)
            verify( parseAndEvaluateAsBoolean( "self.employer.name.oclIsUndefined()", employee, true ), "Comparison of null navigation and oclundefined failed" );

            // now set the employer's name
            ( (DepartmentImpl) employer ).setName( coreConnection, "Another nice name" );

            // self.employer.name.oclIsUndefined() should result in false
            verify( parseAndEvaluateAsBoolean( "self.employer.name.oclIsUndefined()", employee, false ), "Comparison of non-null navigation and oclundefined failed" );
        }
    }

    @Test
    public void objectValuedNavigationSetValueOclIsInvalid( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            DepartmentImpl employer = (DepartmentImpl) getTestHelper( ).getCorePartitionable( coreConnection.getWrapper( ).createElementInPartition( Department.class, null ) );
            ( (EmployeeImpl) employee ).setEmployer( coreConnection, employer );

            // self.employer.oclIsInvalid() should result in false
            verify( parseAndEvaluateAsBoolean( "self.employer.oclIsInvalid()", employee, false ), "Comparison of null and invalid failed" );

            // self.employer.name.oclIsInvalid() should result in false (it's
            // null)
            verify( parseAndEvaluateAsBoolean( "self.employer.name.oclIsInvalid()", employee, false ), "Comparison of null navigation and oclInvalid failed" );

            // now set the employer's name
            ( (DepartmentImpl) employer ).setName( coreConnection, "Another nice name" );

            verify( parseAndEvaluateAsBoolean( "self.employer.name.oclIsInvalid()", employee, false ), "Comparison of non-null navigation and oclInvalid failed" );

        }
    }

    @Test
    public void objectValuedNavigationSetValueSize( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            DepartmentImpl employer = (DepartmentImpl) getTestHelper( ).getCorePartitionable( coreConnection.getWrapper( ).createElementInPartition( Department.class, null ) );
            ( (EmployeeImpl) employee ).setEmployer( coreConnection, employer );

            // self.employer->size()=0 should result in false
            verify( parseAndEvaluateAsBoolean( "self.employer->size()=0", employee, false ), "Comparison of null empty Set" );
        }
    }

    @Test
    public void invalidEvaluationAllInstances( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "OclInvalid.allInstances()->size() = 1", employee, true ), "Invalid.allInstances()->size() = 1" );

        }
    }

    @Test
    public void invalidEvaluationDivisionByZeroParse( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            this.parse( "(3/0).oclIsInvalid()", employee, this.parserPackages );
            // verify(parseAndEvaluateAsBoolean("(3/0).oclIsInvalid()",
            // employee, true), "(3/0).oclIsInavlid() = true");

        }
    }

    // previously, division by zero was undefined. Now it is invalid (i.e., an
    // exception)
    @Test
    public void invalidEvaluationDivisionByZero( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            verify( parseAndEvaluateAsBoolean( "(3/0).oclIsInvalid()", employee, true ), "(3/0).oclIsInavlid() = true" );

        }
    }

    @Test
    public void invalidValueAfterDivisionByZero( ) {

        synchronized ( this.syncObjectForWrite ) {
            Employee myEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
            try {
                parseAndEvaluate( "3/0", employee );
                verify( false, "The expeced ExpressionUndefinedException was not thrown" );
            } catch ( ExpressionUndefinedException e ) {
                // this is the expected one
            }


        }
    }

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        CompanyPackage wrappedPackage = this.getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
        this.companyPackage = (CompanyPackageImpl) getTestHelper( ).getCorePartitionable( wrappedPackage );
        ModelPackage mp = (ModelPackage) this.coreConnection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        this.parserPackages = new RefPackage[] { this.companyPackage, mp };
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        this.companyPackage = null;
        this.parserPackages = null;
        super.afterTestMethod( );
    }

    private boolean parseAndEvaluate( String expression, RefObject evaluationContext, boolean nullExpected, boolean exceptionExpected ) {

        Collection<OclStatement> stmts = this.parse( expression, evaluationContext.refMetaObject( ), this.parserPackages );

        try {
            Object result = evaluateExpression( stmts.iterator( ).next( ).getExpression( ), evaluationContext );
            if ( !exceptionExpected ) {
                if ( nullExpected ) {
                    return result == null;
                }
                return result != null;
            }
        } catch ( ExpressionUndefinedException e ) {
            return exceptionExpected;
        }
        return false;
    }

    private boolean parseAndEvaluateAsBoolean( String expression, RefObject evaluationContext, boolean expectedResult ) {

        Collection<OclStatement> stmts = this.parse( expression, evaluationContext.refMetaObject( ), this.parserPackages );

        try {
            Boolean result = (Boolean) evaluateExpression( stmts.iterator( ).next( ).getExpression( ), evaluationContext );
            return result.booleanValue( ) == expectedResult;
        } catch ( Exception e ) {
            return false;
        }
    }

    private Object evaluateExpression( OclExpression expr, RefObject context ) throws ExpressionUndefinedException {

        OclAny self = OclFactory.instance( ).create( context );
        EvaluationContext evalCtx = new EvaluationContextImpl( self );
        try {
            ExpressionEvaluator exprEvaluator = ExpressionEvaluator.instance( );
            OclAny value = exprEvaluator.evaluate( coreConnection, expr, evalCtx );
            try {
                Object unWrappedValue = value.getWrappedObject( );

                return unWrappedValue;
            } catch ( InvalidValueException e ) {
                throw new ExpressionUndefinedException( OclServiceExceptions.EXPEVALUATESTOUNDEFINED );
            }
        } finally {
            // Reset the current context so that the current thread can create
            // a new one later if required.
            EvaluationContext.CurrentContext.reset( );
        }
    }

    private void parseAndEvaluate( String expression, RefObject evaluationContext ) throws ExpressionUndefinedException {

        Collection<OclStatement> stmts = this.parse( expression, evaluationContext.refMetaObject( ), this.parserPackages );

        evaluateExpression( stmts.iterator( ).next( ).getExpression( ), evaluationContext );
    }

}
