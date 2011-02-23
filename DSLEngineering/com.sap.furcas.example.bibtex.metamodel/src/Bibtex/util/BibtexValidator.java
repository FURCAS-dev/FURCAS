/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Bibtex.util;

import Bibtex.*;

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
 * @see Bibtex.BibtexPackage
 * @generated
 */
public class BibtexValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final BibtexValidator INSTANCE = new BibtexValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "Bibtex";

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
    public BibtexValidator() {
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
      return BibtexPackage.eINSTANCE;
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
            case BibtexPackage.LITERATURE_DB:
                return validateLiteratureDb((LiteratureDb)value, diagnostics, context);
            case BibtexPackage.ENTRY:
                return validateEntry((Entry)value, diagnostics, context);
            case BibtexPackage.AUTHOR:
                return validateAuthor((Author)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLiteratureDb(LiteratureDb literatureDb, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(literatureDb, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(literatureDb, diagnostics, context);
        if (result || diagnostics != null) result &= validateLiteratureDb_uniqueName(literatureDb, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the uniqueName constraint of '<em>Literature Db</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String LITERATURE_DB__UNIQUE_NAME__EEXPRESSION = "LiteratureDb.allInstances().name.entries->select(db | db.name = self.name)->size() = 1";

    /**
     * Validates the uniqueName constraint of '<em>Literature Db</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLiteratureDb_uniqueName(LiteratureDb literatureDb, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (BibtexPackage.Literals.LITERATURE_DB,
                 literatureDb,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "uniqueName",
                 LITERATURE_DB__UNIQUE_NAME__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEntry(Entry entry, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(entry, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entry, diagnostics, context);
        if (result || diagnostics != null) result &= validateEntry_uniqueID(entry, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the uniqueID constraint of '<em>Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String ENTRY__UNIQUE_ID__EEXPRESSION = "self.literaturedb.entries->select(e | e.id = self.id)->size() = 1";

    /**
     * Validates the uniqueID constraint of '<em>Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEntry_uniqueID(Entry entry, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (BibtexPackage.Literals.ENTRY,
                 entry,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "uniqueID",
                 ENTRY__UNIQUE_ID__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAuthor(Author author, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(author, diagnostics, context);
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

} //BibtexValidator
