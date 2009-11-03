package com.sap.mi.fwk.ui.editor;

import org.eclipse.core.runtime.IAdaptable;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * Protocol for an editor working on MOIN model elements.
 * Not intended to be implemented directly.  Subclass {@link ModelEditor} if necessary.
 *      
 * @author d031150
 */
public interface IModelEditor extends IAdaptable {

    /**
     * Returns the connection the editor is working on. The locked {@link ModelPartition}s 
     * of this connection determine whether the editor is regarded as conflicting 
     * with other editors. Note: a call to this method creates a new connection if none is existing, 
     * and attaches the returned connection to the current thread.
     * 
     * @return a connection
     *      
     * @see #getConnection()
     */
    Connection getWorkingConnection();

    /**
     * Returns the connection the editor is working on. In opposition to {@link #getWorkingConnection()}
     * no lazy creation nor thread attaching is done.
     * 
     * @return a connection or <code>null</code> if the editor currently
     *      has no connection
     */
    Connection getConnection();

    /**
     * Via the adapter mechanism this editor may be queried for its UI representation 
     * (using <code>IEditorPart.class</code> as key) or other behavioral extensions.
     * 
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    Object getAdapter(Class adapter);

}
