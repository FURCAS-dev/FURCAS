package com.sap.mi.fwk.ui.databinding.validation;

import java.util.Iterator;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.ObservableTracker;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.MultiValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;

/**
 * This validation status provider tracks the status of all model observables
 * and calls {@link #validate()} whenever one of the observed entities changes
 * its state. The model observables are determined on the basis of the given
 * collection of bindings - see
 * {@link #BindingScopedMultiValidator(IObservableCollection)}.
 * 
 * @author d022960
 * 
 */
public abstract class BindingScopedMultiValidator extends ValidationStatusProvider {

	// the actual validation logic
	private BindingScopedMultiValidatorImpl validationDelegate;

	/**
	 * Constructs a {@link BindingScopedMultiValidator} on the given bindings
	 * and default {@link Realm}.
	 * 
	 * @param bindings
	 *            the bindings to observe provided as an
	 *            {@link IObservableCollection}. The model observables are
	 *            determined generically using a {@link ObservableTracker}. In
	 *            case the corresponding model observable is a
	 *            {@link IObservableList} the implementation will recursively
	 *            check each of the entries in case the list contains instances
	 *            of {@link IObservable}
	 */
	public BindingScopedMultiValidator(IObservableCollection bindings) {
		this(Realm.getDefault(), bindings);
	}

	/**
	 * Constructs a {@link BindingScopedMultiValidator} on the given bindings
	 * and {@link Realm}.
	 * 
	 * @param realm
	 *            The {@link Realm} to use.
	 * @param bindings
	 *            the bindings to observe, provided as an
	 *            {@link IObservableCollection}. The model observables are
	 *            determined generically using a {@link ObservableTracker}. In
	 *            case the corresponding model observable is a
	 *            {@link IObservableList} the implementation will recursively
	 *            check each of the entries in case the list contains instances
	 *            of {@link IObservable}.
	 */
	public BindingScopedMultiValidator(Realm realm, IObservableCollection bindings) {
		Object elementType = bindings.getElementType();
		if (elementType == null && bindings.size() > 0) {
			elementType = bindings.iterator().next().getClass();
		}
		Assert.isLegal(elementType == null || !elementType.equals(Binding.class),
				"The given Collection does not contain instances of type Binding"); //$NON-NLS-1$
		Assert.isLegal(realm != null, "Realm must not be null"); //$NON-NLS-1$
		validationDelegate = new BindingScopedMultiValidatorImpl(realm, bindings, this);
	}

	/**
	 * Return the current validation status.
	 * <p>
	 * Note: To ensure that the validation status is kept current, the
	 * dependencies are calculated generically based on the given list of
	 * bindings. Thus you have to ensure that all bindings are established at
	 * the point of time this {@link BindingScopedMultiValidator} is
	 * instantiated. Each dependency observable must be in the same realm as the
	 * {@link MultiValidator}.
	 * 
	 * @return the current validation status.
	 */
	protected abstract IStatus validate();

	/**
	 * Disposes off this validator. Clients may override to dispose their own
	 * stuff but must call <code>super.dispose()</code>.
	 */
	@Override
	public void dispose() {
		validationDelegate.dispose();
		super.dispose();
	}

	/**
	 * Returns the model observables (if any) that are being tracked by this
	 * validation status provider.
	 * 
	 * @return an observable list of model {@link IObservable}s (may be empty)
	 */
	@Override
	public IObservableList getModels() {
		return validationDelegate.getModels();
	}

	/**
	 * Returns the list of target observables (if any) that are being tracked by
	 * this validation status provider.
	 * 
	 * @return an observable list of target {@link IObservable}s (may be empty)
	 */
	@Override
	public IObservableList getTargets() {
		return validationDelegate.getTargets();
	}

	/**
	 * Returns an {@link IObservableValue} whose value is always the current
	 * validation status of this validator. The returned observable is in the
	 * same {@link Realm} as this validator.
	 * 
	 * @return an {@link IObservableValue} whose value is always the current
	 *         validation status of this validator.
	 */
	@Override
	public IObservableValue getValidationStatus() {
		return validationDelegate.getValidationStatus();
	}

	/**
	 * Internal delegate for validation
	 */
	private class BindingScopedMultiValidatorImpl extends MultiValidator {

		private IObservableCollection bindings;
		private BindingScopedMultiValidator provider;
		private IStatus cachedStatus;

		public BindingScopedMultiValidatorImpl(Realm realm, IObservableCollection bindings, BindingScopedMultiValidator provider) {
			super(realm);
			this.bindings = bindings;
			this.provider = provider;
		}

		@Override
		protected IStatus validate() {
			for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
				Binding binding = (Binding) iterator.next();

				touch(binding.getModel());
			}
			IStatus status = provider.validate();
			if (!isStatusEqual(status, cachedStatus)) {
				cachedStatus = status;
			}
			return cachedStatus;
		}

		/**
		 * Tests whether to status objects are equal or not as the build in
		 * <code>isEqual</code> method just checks for equality on reference
		 * level.<br>
		 * Two instances are equal if all its members are equal.
		 * 
		 * @param first
		 *            the first status instance, maybe null
		 * @param second
		 *            the second status instance, maybe null
		 * @return true in case the given status objects are equal including
		 *         their children in case <code>isMultistatus</code> is true,
		 *         false otherwise
		 */
		private boolean isStatusEqual(IStatus first, IStatus second) {
			if (first == second) {
				return true;
			} else if (first == null && second != null) {
				return false;
			} else if (first != null && second == null) {
				return false;
			}
			if (first.getCode() == second.getCode()
					&& ((first.getException() != null && first.getException().equals(second.getException())) || (first.getException() == null && second
							.getException() == null))
					&& ((first.getMessage() != null && first.getMessage().equals(second.getMessage())) || (first.getMessage() == null && second
							.getMessage() == null))
					&& ((first.getPlugin() != null && first.getPlugin().equals(second.getPlugin())) || (first.getPlugin() == null && second
							.getPlugin() == null)) && first.getSeverity() == second.getSeverity()) {

				if (first.isMultiStatus() == second.isMultiStatus()) {
					IStatus[] statiFirst = first.getChildren();
					IStatus[] statiSecond = second.getChildren();

					if (statiFirst.length == statiSecond.length) {
						for (int i = 0; i < statiFirst.length; i++) {
							if (!isStatusEqual(statiFirst[i], statiSecond[i])) {
								return false;
							}
						}
						return true;
					}
				}
			}
			return false;
		}

		/**
		 * Touches all observables to register them for tracking.
		 */
		private void touch(Object observable) {
			// ignore IObservableMap - seems not to be relevant

			if (observable instanceof IObservableValue) {
				((IObservableValue) observable).getValue();
			} else if (observable instanceof IObservableList) {
				IObservableList list = (IObservableList) observable;
				if (list.getElementType() instanceof IObservable) {
					for (Iterator iterator = list.iterator(); iterator.hasNext();) {
						touch(iterator.next());
					}
				}
			} else if (observable instanceof IObservableSet) {
				IObservableSet set = (IObservableSet) observable;
				if (set.getElementType() instanceof IObservable) {
					for (Iterator iterator = set.iterator(); iterator.hasNext();) {
						touch(iterator.next());
					}
				}
			}
		}
	}
}
