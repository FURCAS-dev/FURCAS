/**
 * <copyright>
 * </copyright>
 *
 * $Id: BookImpl.java,v 1.2 2009/10/09 20:08:22 bkolb Exp $
 */
package library.impl;

import library.Book;
import library.LibraryPackage;
import library.Manuscript;
import library.Person;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link library.impl.BookImpl#getBorrowedBy <em>Borrowed By</em>}</li>
 *   <li>{@link library.impl.BookImpl#getInstanceOf <em>Instance Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BookImpl extends EObjectImpl implements Book {
	/**
	 * The cached value of the '{@link #getBorrowedBy() <em>Borrowed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorrowedBy()
	 * @generated
	 * @ordered
	 */
	protected Person borrowedBy;

	/**
	 * The cached value of the '{@link #getInstanceOf() <em>Instance Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOf()
	 * @generated
	 * @ordered
	 */
	protected Manuscript instanceOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.BOOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getBorrowedBy() {
		if (borrowedBy != null && borrowedBy.eIsProxy()) {
			InternalEObject oldBorrowedBy = (InternalEObject)borrowedBy;
			borrowedBy = (Person)eResolveProxy(oldBorrowedBy);
			if (borrowedBy != oldBorrowedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.BOOK__BORROWED_BY, oldBorrowedBy, borrowedBy));
			}
		}
		return borrowedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetBorrowedBy() {
		return borrowedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorrowedBy(Person newBorrowedBy) {
		Person oldBorrowedBy = borrowedBy;
		borrowedBy = newBorrowedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__BORROWED_BY, oldBorrowedBy, borrowedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manuscript getInstanceOf() {
		if (instanceOf != null && instanceOf.eIsProxy()) {
			InternalEObject oldInstanceOf = (InternalEObject)instanceOf;
			instanceOf = (Manuscript)eResolveProxy(oldInstanceOf);
			if (instanceOf != oldInstanceOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.BOOK__INSTANCE_OF, oldInstanceOf, instanceOf));
			}
		}
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manuscript basicGetInstanceOf() {
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceOf(Manuscript newInstanceOf) {
		Manuscript oldInstanceOf = instanceOf;
		instanceOf = newInstanceOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__INSTANCE_OF, oldInstanceOf, instanceOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.BOOK__BORROWED_BY:
				if (resolve) return getBorrowedBy();
				return basicGetBorrowedBy();
			case LibraryPackage.BOOK__INSTANCE_OF:
				if (resolve) return getInstanceOf();
				return basicGetInstanceOf();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryPackage.BOOK__BORROWED_BY:
				setBorrowedBy((Person)newValue);
				return;
			case LibraryPackage.BOOK__INSTANCE_OF:
				setInstanceOf((Manuscript)newValue);
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
			case LibraryPackage.BOOK__BORROWED_BY:
				setBorrowedBy((Person)null);
				return;
			case LibraryPackage.BOOK__INSTANCE_OF:
				setInstanceOf((Manuscript)null);
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
			case LibraryPackage.BOOK__BORROWED_BY:
				return borrowedBy != null;
			case LibraryPackage.BOOK__INSTANCE_OF:
				return instanceOf != null;
		}
		return super.eIsSet(featureID);
	}

} //BookImpl
