/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.util;

import de.hpi.sam.petriNet.*;

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
 * @see de.hpi.sam.petriNet.PetriNetPackage
 * @generated
 */
public class PetriNetValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final PetriNetValidator INSTANCE = new PetriNetValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "de.hpi.sam.petriNet";

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
    public PetriNetValidator() {
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
      return PetriNetPackage.eINSTANCE;
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
            case PetriNetPackage.PETRI_NET:
                return validatePetriNet((PetriNet)value, diagnostics, context);
            case PetriNetPackage.ELEMENT:
                return validateElement((Element)value, diagnostics, context);
            case PetriNetPackage.PLACE:
                return validatePlace((Place)value, diagnostics, context);
            case PetriNetPackage.TRANSITION:
                return validateTransition((Transition)value, diagnostics, context);
            case PetriNetPackage.ARC:
                return validateArc((Arc)value, diagnostics, context);
            case PetriNetPackage.NODE:
                return validateNode((Node)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePetriNet(PetriNet petriNet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(petriNet, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(petriNet, diagnostics, context);
        if (result || diagnostics != null) result &= validatePetriNet_modelName(petriNet, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the modelName constraint of '<em>Petri Net</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String PETRI_NET__MODEL_NAME__EEXPRESSION = "self.elements->notEmpty()";

    /**
     * Validates the modelName constraint of '<em>Petri Net</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePetriNet_modelName(PetriNet petriNet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (PetriNetPackage.Literals.PETRI_NET,
                 petriNet,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "modelName",
                 PETRI_NET__MODEL_NAME__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(element, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePlace(Place place, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(place, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(place, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(place, diagnostics, context);
        if (result || diagnostics != null) result &= validatePlace_numberOfTokens(place, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the numberOfTokens constraint of '<em>Place</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String PLACE__NUMBER_OF_TOKENS__EEXPRESSION = "self.noTokens > 3";

    /**
     * Validates the numberOfTokens constraint of '<em>Place</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePlace_numberOfTokens(Place place, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (PetriNetPackage.Literals.PLACE,
                 place,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "numberOfTokens",
                 PLACE__NUMBER_OF_TOKENS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTransition(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(transition, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateArc(Arc arc, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(arc, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNode(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(node, diagnostics, context);
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

} //PetriNetValidator
