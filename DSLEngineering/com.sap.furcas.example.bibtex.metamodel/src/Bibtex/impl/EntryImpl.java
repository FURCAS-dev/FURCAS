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
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Bibtex.impl.EntryImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link Bibtex.impl.EntryImpl#getId <em>Id</em>}</li>
 *   <li>{@link Bibtex.impl.EntryImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link Bibtex.impl.EntryImpl#getLiteraturedb <em>Literaturedb</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryImpl extends EObjectImpl implements Entry {
    /**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
    protected static final String TITLE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
    protected String title = TITLE_EDEFAULT;

    /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected static final String ID_EDEFAULT = "";

    /**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected String id = ID_EDEFAULT;

    /**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
    protected EList<Author> author;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EntryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return BibtexPackage.Literals.ENTRY;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getTitle() {
		return title;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ENTRY__TITLE, oldTitle, title));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getId() {
		return id;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ENTRY__ID, oldId, id));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Author> getAuthor() {
		if (author == null) {
			author = new EObjectWithInverseResolvingEList.ManyInverse<Author>(Author.class, this, BibtexPackage.ENTRY__AUTHOR, BibtexPackage.AUTHOR__PUBLICATIONS);
		}
		return author;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public LiteratureDb getLiteraturedb() {
		if (eContainerFeatureID() != BibtexPackage.ENTRY__LITERATUREDB) return null;
		return (LiteratureDb)eContainer();
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteraturedb(LiteratureDb newLiteraturedb, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLiteraturedb, BibtexPackage.ENTRY__LITERATUREDB, msgs);
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLiteraturedb(LiteratureDb newLiteraturedb) {
		if (newLiteraturedb != eInternalContainer() || (eContainerFeatureID() != BibtexPackage.ENTRY__LITERATUREDB && newLiteraturedb != null)) {
			if (EcoreUtil.isAncestor(this, newLiteraturedb))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLiteraturedb != null)
				msgs = ((InternalEObject)newLiteraturedb).eInverseAdd(this, BibtexPackage.LITERATURE_DB__ENTRIES, LiteratureDb.class, msgs);
			msgs = basicSetLiteraturedb(newLiteraturedb, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ENTRY__LITERATUREDB, newLiteraturedb, newLiteraturedb));
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
			case BibtexPackage.ENTRY__AUTHOR:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAuthor()).basicAdd(otherEnd, msgs);
			case BibtexPackage.ENTRY__LITERATUREDB:
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
			case BibtexPackage.ENTRY__AUTHOR:
				return ((InternalEList<?>)getAuthor()).basicRemove(otherEnd, msgs);
			case BibtexPackage.ENTRY__LITERATUREDB:
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
			case BibtexPackage.ENTRY__LITERATUREDB:
				return eInternalContainer().eInverseRemove(this, BibtexPackage.LITERATURE_DB__ENTRIES, LiteratureDb.class, msgs);
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
			case BibtexPackage.ENTRY__TITLE:
				return getTitle();
			case BibtexPackage.ENTRY__ID:
				return getId();
			case BibtexPackage.ENTRY__AUTHOR:
				return getAuthor();
			case BibtexPackage.ENTRY__LITERATUREDB:
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
			case BibtexPackage.ENTRY__TITLE:
				setTitle((String)newValue);
				return;
			case BibtexPackage.ENTRY__ID:
				setId((String)newValue);
				return;
			case BibtexPackage.ENTRY__AUTHOR:
				getAuthor().clear();
				getAuthor().addAll((Collection<? extends Author>)newValue);
				return;
			case BibtexPackage.ENTRY__LITERATUREDB:
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
			case BibtexPackage.ENTRY__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case BibtexPackage.ENTRY__ID:
				setId(ID_EDEFAULT);
				return;
			case BibtexPackage.ENTRY__AUTHOR:
				getAuthor().clear();
				return;
			case BibtexPackage.ENTRY__LITERATUREDB:
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
			case BibtexPackage.ENTRY__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case BibtexPackage.ENTRY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case BibtexPackage.ENTRY__AUTHOR:
				return author != null && !author.isEmpty();
			case BibtexPackage.ENTRY__LITERATUREDB:
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
		result.append(" (title: ");
		result.append(title);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //EntryImpl
