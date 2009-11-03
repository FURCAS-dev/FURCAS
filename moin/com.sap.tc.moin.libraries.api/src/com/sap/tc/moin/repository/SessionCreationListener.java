package com.sap.tc.moin.repository;

/**
 * Callback interface for extensions of the <tt>sessionCreationListener</tt>
 * extension point of the MOIN Core libraries plugin.
 * 
 * @author Axel Uhl D043530
 *
 */
public interface SessionCreationListener {
    /**
     * Called by MOIN for registered listeners when a session has been created by
     * {@link Moin#createSession(com.sap.tc.moin.repository.cdam.CompoundClientSpec)},
     * just before the session is returned to the caller.
     * 
     * @param session the session created
     */
    void sessionCreated(Session session);
    
    /**
     * Notifies the listener that MOIN initialization has finished and MOIN is
     * ready to be used. This method is called just before MOIN is returned to
     * the first caller after initialization has finished.
     * 
     * @param moin the initialized MOIN
     */
    void moinInitialized(Moin moin);
}
