package com.sap.mi.fwk.test.service.viewers;


/**
 * Interface intended to visit structured content, e.g. accessible via
 * IStructuredContentProvider. The result could be retrieved using the method
 * <code>getResult</code> or <code>getResultAsString</code>.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 *              Clients should instead subclass one of the classes that
 *              implement this interface. Note that direct implementers of this
 *              interface outside of the framework will be broken in future
 *              releases when methods are added to this interface.
 * 
 * @author d022960
 * 
 */
public interface IStructuredContentVisitor {
	/**
	 * Visits the given object and all its children. Multiple calls will not
	 * clear the result of a previous call.
	 * 
	 * @param inputElement
	 *            the instance to visit
	 */
	void visit(Object inputElement);

	/**
	 * Returns the result of the previous visit operation.
	 * 
	 * @return the result of the visit operation. The type is defined by the
	 *         concrete visitor implementation.
	 */
	Object getResult();

	/**
	 * Returns a textual representation of the previous visit operation.
	 * 
	 * @return the result of the visit operation as type <code>String</code>.
	 */
	String getResultAsString();
}
