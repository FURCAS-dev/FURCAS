package com.sap.tc.moin.repository.test.ocl.ia;

import java.util.Collection;

import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.company.Division;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.company.__impl.CompanyPackageImpl;
import com.sap.company.__impl.DivisionImpl;
import com.sap.company.__impl.FreelanceImpl;
import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBag;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.ocl.ia.helper.BaseDepartmentTest;

/**
 * Regression test for commonsupertypes
 */
@SuppressWarnings( "nls" )
public class TestRegression extends BaseDepartmentTest {

    /**
     * This actually tests the
     * {@link OCLTypeChecker#commonSuperType(com.sap.tc.moin.repository.mmi.model.Classifier, com.sap.tc.moin.repository.mmi.model.Classifier)}
     * method
     */

    @Test
    public void testCommonSupertypes( ) {


        CompanyPackage pkg = getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
        CompanyPackageImpl pkgi = (CompanyPackageImpl) ( (Wrapper) pkg ).unwrap( );
        Freelance fl = (Freelance) getMOINConnection( ).getClass( Freelance.CLASS_DESCRIPTOR ).refCreateInstance( );
        FreelanceImpl fli = (FreelanceImpl) ( (Wrapper) fl ).unwrap( );
        Collection<OclStatement> stmts = this.parse( "let dSeq: Sequence(Boolean) = Sequence{true, false}in let iSeq: Sequence(Freelance) = Sequence{} in let mySeq = Sequence {dSeq, iSeq} in " + "mySeq->size() = 2", fli, new RefPackage[] { pkgi } );

    }

    @Test
    public void testCollectNull( ) throws Exception {


        synchronized ( this.syncObjectForWrite ) {

            Connection conn = getMOINConnection( );
            CoreConnection cconn = (CoreConnection) ( (Wrapper) conn ).unwrap( );

            CompanyPackage pkg = conn.getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
            CompanyPackageImpl pkgi = (CompanyPackageImpl) ( (Wrapper) pkg ).unwrap( );

            Division div = conn.createElement( Division.CLASS_DESCRIPTOR );
            DivisionImpl di = (DivisionImpl) ( (Wrapper) div ).unwrap( );

            Department d1 = conn.createElement( Department.CLASS_DESCRIPTOR );
            Employee d1e1 = conn.createElement( Employee.CLASS_DESCRIPTOR );
            d1e1.setName( "d1e1" );
            Employee d1e2 = conn.createElement( Employee.CLASS_DESCRIPTOR );
            d1.getEmployee( ).add( d1e1 );
            d1.getEmployee( ).add( d1e2 );

            Department d2 = conn.createElement( Department.CLASS_DESCRIPTOR );
            Employee d2e1 = conn.createElement( Employee.CLASS_DESCRIPTOR );
            Employee d2e2 = conn.createElement( Employee.CLASS_DESCRIPTOR );
            d2e2.setName( "d2e2" );
            d2.getEmployee( ).add( d2e1 );
            d2.getEmployee( ).add( d2e2 );

            div.getDepartment( ).add( d1 );
            div.getDepartment( ).add( d2 );


            MoinJmiCreator creator = new JmiCreator( cconn, true, cconn.getNullPartition( ) );

            IOclParser parser = OclParserFactory.create( creator );

            Collection<OclStatement> stmts = parser.parseString( "self.department.employee.name", di, new RefPackage[] { pkg } );

            ExpressionEvaluator eval = ExpressionEvaluator.instance( );

            EvaluationContext evalCtx = new EvaluationContextImpl( OclFactory.instance( ).create( div ) );
            try {

                ExpressionEvaluator exprEvaluator = ExpressionEvaluator.instance( );

                OclAny value = eval.evaluate( cconn, stmts.iterator( ).next( ).getExpression( ), evalCtx );

                if ( value instanceof OclBag ) {
                    verify( ( (OclBag) value ).getWrappedCollection( ).size( ) == 4, "Should contain 4 elements" );
                } else {
                    errorAndContinue( "Should evaluate to a Bag" );
                }

            } finally {
                // Reset the current context so that the current thread can create
                // a new one later if required.
                EvaluationContext.CurrentContext.reset( );
            }
        }


    }

}
