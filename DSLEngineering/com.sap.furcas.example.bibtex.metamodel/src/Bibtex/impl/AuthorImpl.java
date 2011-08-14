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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Bibtex.impl.AuthorImpl#getName <em>Name</em>}</li>
 *   <li>{@link Bibtex.impl.AuthorImpl#getPublications <em>Publications</em>}</li>
 *   <li>{@link Bibtex.impl.AuthorImpl#getLiteraturedb <em>Literaturedb</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthorImpl extends EObjectImpl implements Author {
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
     * The cached value of the '{@link #getPublications() <em>Publications</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPublications()
     * @generated
     * @ordered
     */
    protected EList<Entry> publications;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AuthorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BibtexPackage.Literals.AUTHOR;
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
            eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.AUTHOR__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Entry> getPublications() {
        if (publications == null) {
            publications = new EObjectWithInverseResolvingEList.ManyInverse<Entry>(Entry.class, this, BibtexPackage.AUTHOR__PUBLICATIONS, BibtexPackage.ENTRY__AUTHOR);
        }
        return publications;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LiteratureDb getLiteraturedb() {
        if (eContainerFeatureID() != BibtexPackage.AUTHOR__LITERATUREDB) return null;
        return (LiteratureDb)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLiteraturedb(LiteratureDb newLiteraturedb, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newLiteraturedb, BibtexPackage.AUTHOR__LITERATUREDB, msgs);
        return msgs;
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLiteraturedb(LiteratureDb newLiteraturedb) {
        if (newLiteraturedb != eInternalContainer() || (eContainerFeatureID() != BibtexPackage.AUTHOR__LITERATUREDB && newLiteraturedb != null)) {
            if (EcoreUtil.isAncestor(this, newLiteraturedb))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newLiteraturedb != null)
                msgs = ((InternalEObject)newLiteraturedb).eInverseAdd(this, BibtexPackage.LITERATURE_DB__AUTHOR, LiteratureDb.class, msgs);
            msgs = basicSetLiteraturedb(newLiteraturedb, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.AUTHOR__LITERATUREDB, newLiteraturedb, newLiteraturedb));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BibtexPackage.AUTHOR__PUBLICATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPublications()).basicAdd(otherEnd, msgs);
            case BibtexPackage.AUTHOR__LITERATUREDB:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetLiteraturedb((LiteratureDb)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BibtexPackage.AUTHOR__PUBLICATIONS:
                return ((InternalEList<?>)getPublications()).basicRemove(otherEnd, msgs);
            case BibtexPackage.AUTHOR__LITERATUREDB:
                return basicSetLiteraturedb(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case BibtexPackage.AUTHOR__LITERATUREDB:
                return eInternalContainer().eInverseRemove(this, BibtexPackage.LITERATURE_DB__AUTHOR, LiteratureDb.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BibtexPackage.AUTHOR__NAME:
                return getName();
            case BibtexPackage.AUTHOR__PUBLICATIONS:
                return getPublications();
            case BibtexPackage.AUTHOR__LITERATUREDB:
                return getLiteraturedb();
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
            case BibtexPackage.AUTHOR__NAME:
                setName((String)newValue);
                return;
            case BibtexPackage.AUTHOR__PUBLICATIONS:
                getPublications().clear();
                getPublications().addAll((Collection<? extends Entry>)newValue);
                return;
            case BibtexPackage.AUTHOR__LITERATUREDB:
                setLiteraturedb((LiteratureDb)newValue);
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
            case BibtexPackage.AUTHOR__NAME:
                setName(NAME_EDEFAULT);
                return;
            case BibtexPackage.AUTHOR__PUBLICATIONS:
                getPublications().clear();
                return;
            case BibtexPackage.AUTHOR__LITERATUREDB:
                setLiteraturedb((LiteratureDb)null);
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
            case BibtexPackage.AUTHOR__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case BibtexPackage.AUTHOR__PUBLICATIONS:
                return publications != null && !publications.isEmpty();
            case BibtexPackage.AUTHOR__LITERATUREDB:
                return getLiteraturedb() != null;
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

} //AuthorImpl
