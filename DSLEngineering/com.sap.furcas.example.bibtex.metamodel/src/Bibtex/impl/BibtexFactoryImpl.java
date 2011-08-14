/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Bibtex.impl;

import Bibtex.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BibtexFactoryImpl extends EFactoryImpl implements BibtexFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static BibtexFactory init() {
        try {
            BibtexFactory theBibtexFactory = (BibtexFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.sap.com/furcas/examples/bibtex"); 
            if (theBibtexFactory != null) {
                return theBibtexFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BibtexFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BibtexFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case BibtexPackage.LITERATURE_DB: return createLiteratureDb();
            case BibtexPackage.ENTRY: return createEntry();
            case BibtexPackage.AUTHOR: return createAuthor();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LiteratureDb createLiteratureDb() {
        LiteratureDbImpl literatureDb = new LiteratureDbImpl();
        return literatureDb;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Entry createEntry() {
        EntryImpl entry = new EntryImpl();
        return entry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Author createAuthor() {
        AuthorImpl author = new AuthorImpl();
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BibtexPackage getBibtexPackage() {
        return (BibtexPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static BibtexPackage getPackage() {
        return BibtexPackage.eINSTANCE;
    }

} //BibtexFactoryImpl
