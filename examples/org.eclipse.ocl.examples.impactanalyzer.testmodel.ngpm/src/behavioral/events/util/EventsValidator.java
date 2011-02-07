/**
 * <copyright>
 * </copyright>
 *
 * $Id: EventsValidator.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.events.util;

import behavioral.events.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see behavioral.events.EventsPackage
 * @generated
 */
public class EventsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final EventsValidator INSTANCE = new EventsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "behavioral.events";

	/**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventsValidator() {
        super();
    }

	/**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EPackage getEPackage() {
      return EventsPackage.eINSTANCE;
    }

	/**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case EventsPackage.SUBSCRIPTION:
                return validateSubscription((Subscription)value, diagnostics, context);
            case EventsPackage.EVENT_PRODUCER:
                return validateEventProducer((EventProducer)value, diagnostics, context);
            case EventsPackage.EVENT_FILTER:
                return validateEventFilter((EventFilter)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSubscription(Subscription subscription, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(subscription, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(subscription, diagnostics, context);
        if (result || diagnostics != null) result &= validateSubscription_SubscribingClassMatchProducer(subscription, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the SubscribingClassMatchProducer constraint of '<em>Subscription</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SUBSCRIPTION__SUBSCRIBING_CLASS_MATCH_PRODUCER__EEXPRESSION = "self.producer.notificationSignatures->forAll(ms:data::classes::MethodSignature |\r\n" +
        "    self.subscribingClass.allSignatures()->exists(s:data::classes::MethodSignature|s.conformsTo(ms)))";

	/**
     * Validates the SubscribingClassMatchProducer constraint of '<em>Subscription</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSubscription_SubscribingClassMatchProducer(Subscription subscription, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (EventsPackage.Literals.SUBSCRIPTION,
                 subscription,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SubscribingClassMatchProducer",
                 SUBSCRIPTION__SUBSCRIBING_CLASS_MATCH_PRODUCER__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateEventProducer(EventProducer eventProducer, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(eventProducer, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateEventFilter(EventFilter eventFilter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(eventFilter, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventFilter, diagnostics, context);
        if (result || diagnostics != null) result &= validateEventFilter_FilterBlockSignatureMatchNotificationSignature(eventFilter, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the FilterBlockSignatureMatchNotificationSignature constraint of '<em>Event Filter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String EVENT_FILTER__FILTER_BLOCK_SIGNATURE_MATCH_NOTIFICATION_SIGNATURE__EEXPRESSION = "self.subscription.producer.notificationSignatures->exists(ms:data::classes::MethodSignature |\r\n" +
        "    ms.conformsTo(self.test.getImplementedSignature()))";

	/**
     * Validates the FilterBlockSignatureMatchNotificationSignature constraint of '<em>Event Filter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateEventFilter_FilterBlockSignatureMatchNotificationSignature(EventFilter eventFilter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (EventsPackage.Literals.EVENT_FILTER,
                 eventFilter,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FilterBlockSignatureMatchNotificationSignature",
                 EVENT_FILTER__FILTER_BLOCK_SIGNATURE_MATCH_NOTIFICATION_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} //EventsValidator
