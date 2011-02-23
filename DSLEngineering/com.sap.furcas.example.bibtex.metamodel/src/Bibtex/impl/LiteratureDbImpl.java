/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Bibtex.impl;

import Bibtex.Author;
import Bibtex.BibtexPackage;
import Bibtex.Entry;
import Bibtex.LiteratureDb;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literature Db</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Bibtex.impl.LiteratureDbImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link Bibtex.impl.LiteratureDbImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link Bibtex.impl.LiteratureDbImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteratureDbImpl extends EObjectImpl implements LiteratureDb {
    /**
     * The cached value of the '{@link #getAuthor() <em>Author</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected EList<Author> author;

    /**
     * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntries()
     * @generated
     * @ordered
     */
    protected EList<Entry> entries;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LiteratureDbImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BibtexPackage.Literals.LITERATURE_DB;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Author> getAuthor() {
        if (author == null) {
            author = new EObjectContainmentEList<Author>(Author.class, this, BibtexPackage.LITERATURE_DB__AUTHOR);
        }
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Entry> getEntries() {
        if (entries == null) {
            entries = new EObjectContainmentEList<Entry>(Entry.class, this, BibtexPackage.LITERATURE_DB__ENTRIES);
        }
        return entries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.LITERATURE_DB__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BibtexPackage.LITERATURE_DB__AUTHOR:
                return ((InternalEList<?>)getAuthor()).basicRemove(otherEnd, msgs);
            case BibtexPackage.LITERATURE_DB__ENTRIES:
                return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BibtexPackage.LITERATURE_DB__AUTHOR:
                return getAuthor();
            case BibtexPackage.LITERATURE_DB__ENTRIES:
                return getEntries();
            case BibtexPackage.LITERATURE_DB__NAME:
                return getName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BibtexPackage.LITERATURE_DB__AUTHOR:
                getAuthor().clear();
                getAuthor().addAll((Collection<? extends Author>)newValue);
                return;
            case BibtexPackage.LITERATURE_DB__ENTRIES:
                getEntries().clear();
                getEntries().addAll((Collection<? extends Entry>)newValue);
                return;
            case BibtexPackage.LITERATURE_DB__NAME:
                setName((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case BibtexPackage.LITERATURE_DB__AUTHOR:
                getAuthor().clear();
                return;
            case BibtexPackage.LITERATURE_DB__ENTRIES:
                getEntries().clear();
                return;
            case BibtexPackage.LITERATURE_DB__NAME:
                setName(NAME_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case BibtexPackage.LITERATURE_DB__AUTHOR:
                return author != null && !author.isEmpty();
            case BibtexPackage.LITERATURE_DB__ENTRIES:
                return entries != null && !entries.isEmpty();
            case BibtexPackage.LITERATURE_DB__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //LiteratureDbImpl
