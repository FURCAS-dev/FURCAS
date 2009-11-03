package com.sap.tc.moin.repository.ocl.notification;

import java.util.Locale;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

/**
 * The constraint violation information sent to deferred listeners when a
 * constraint violation is detected.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface DeferredConstraintViolationStatusItem {

    /**
     * Get registration information about the violated constraint including the
     * {@link OclRegistrationSeverity}.
     * <p>
     * In the case of metamodel constraints, this is actually an instance of
     * {@link OclMetaModelConstraintRegistration}.
     * 
     * @return registration information about the violated constraint
     */
    public OclRegistration getConstraintRegistration( );

    /**
     * @return the MRI for which the violation was detected
     */
    public MRI getOffendingMRI( );

    /**
     * Constraints may involve navigation along associations whithin a model. If
     * the navigation can not be performed because the association does not
     * exist, then the underlying OCL expression can not be evaluated. In that
     * case, the violation will be reported, even though semantically the
     * situation is somewhat different: a constraint violation was not detected,
     * but a non-violation could not be verified either.
     * <p>
     * For example, the "Car" object might have a constraint saying that the
     * number of wheels must be either 3 or 4. The OCL expression could look
     * something like this:
     * 
     * <pre>
     *               context Car inv numWheelsThreeOrFour:
     *               self.wheels-&gt;size() &gt;= 3 and self.wheels-&gt;size() &lt;= 4 
     * </pre>
     * Now let's assume the <code>wheels</code> attribute evaluates to
     * <code>null</code>, since the car was just created and does not have any
     * wheels. When trying to evaluate this expression, it will evaluate to an
     * undefined value. Technically, this is a constraint violation (it can not
     * be verified that the car has 3 or 4 wheels), but opposed to the situation
     * where the expression evaluates to <code>false</code>, the constraint
     * violation has not been positively detected. Similar situations will occur
     * if the expression is semantically incorrect.
     * 
     * @return true if an Exception occurred
     */
    public boolean oclExceptionOccurred( );

    /**
     * @return the {@link OclManagerException} if one was encountered or
     * <code>null</code>.
     */
    public OclManagerException getOclManagerException( );

    /**
     * Delegates to {@link #getConstraintViolationMessage(Locale)} using
     * {@link Locale#ENGLISH}
     * 
     * @return the constraint violation message
     */
    public String getConstraintViolationMessage( );

    /**
     * This defaults to the name of the registration (see
     * {@link #getConstraintRegistration()}. However, it is possible to add OCL
     * Expressions to meta models that are evaluated for creating this message.
     * If these expressions can not be evaluated, the name will be returned and
     * a trace message will be written.
     * 
     * @param locale the requested {@link Locale}
     * @return the constraint violation message
     */
    public String getConstraintViolationMessage( Locale locale );

    /**
     * Delegates to {@link #getConstraintViolationMessage(Locale)} using the
     * {@link Locale} as obtained from {@link MoinLocaleProvider}
     * 
     * @return the localized constraint violation message
     */
    public String getLocalizedConstraintViolationMessage( );

    /**
     * Creates the OclDebugger tree.
     * <p>
     * The OclDebugger allows to determine the actual values obtained for each
     * node of the expression tree which was created by the parser. In this
     * context, it can be helpful to analyze the reason for the detected
     * constraint violation.
     * 
     * @return the debugger tree root node
     * @throws OclManagerException if anything goes wrong during creation of the
     * tree
     */
    public OclDebuggerNode getDebuggerTree( ) throws OclManagerException;

}
