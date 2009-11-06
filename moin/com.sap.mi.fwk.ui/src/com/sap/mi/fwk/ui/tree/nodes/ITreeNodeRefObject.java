package com.sap.mi.fwk.ui.tree.nodes;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This interface is implemented by tree nodes which hold a value of type
 * {@link RefObject}. They can be adapted to type {@link RefObject} and
 * {@link Connection}.
 * <p>
 * This interface is not intended to be implemented by clients. Clients may
 * extend {@link TreeNodeRefObject} instead.
 * </p>
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 *              Clients should instead subclass one of the classes that
 *              implement this interface. Note that direct implementers of this
 *              interface outside of the framework will be broken in future
 *              releases when methods are added to this interface.
 * 
 * @see TreeNodeRefObject
 * 
 * @author d022960
 * 
 * @param <T>
 *            the java type of the value wrapped by this tree node
 */
public interface ITreeNodeRefObject<T extends RefObject> extends ITreeNode<T> {

}
