package de.hpi.sam.bp2009.eventManagerEvaluation;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased;

/**
 * 
 */

/**
 * @author Philipp
 *
 */
public class ModifiedTableEM extends EventManagerTableBased {

    private long startHandleEvent =0L;
    private Writer writer;
    private boolean enabled = true;

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @param set
     * @param writer 
     */
    public ModifiedTableEM(ResourceSet set, Writer writer) {
        super(set);
        this.writer= writer;
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased#handleEMFEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    public void handleEMFEvent(Notification notification) {
        if(notifierByListener.isEmpty()){
            return;
        }
        this.startHandleEvent=System.nanoTime();
        super.handleEMFEvent(notification);        
        try {
            if(this.enabled){
                writer.write((System.nanoTime()-startHandleEvent)+",");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        }

        
    }

    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased#unsubscribe(org.eclipse.emf.common.notify.Adapter)
     */
    @Override
    public boolean unsubscribe(Adapter caller) {
        // TODO Auto-generated methodunsubscribe stub
        return super.unsubscribe(caller);
        
    }
    
}
