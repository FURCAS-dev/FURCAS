package de.hpi.sam.bp2009.eventManagerEvaluation;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;



public class ModifiedNaiveEM extends EventManagerNaive {

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
     */
    public ModifiedNaiveEM(ResourceSet set, Writer w) {
        super(set);
        this.writer = w;
        // TODO Auto-generated constructor stub
    }


    /* (non-Javadoc)
     * @see de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased#handleEMFEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    public void handleEMFEvent(Notification notification) {
        this.startHandleEvent=System.nanoTime();
        if(this.filterToListener.isEmpty()){
            return;
        }
        super.handleEMFEvent(notification);
        try {
            if(enabled)
                writer.write((System.nanoTime()-startHandleEvent)+",");
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
    int getRegisteredCount(){
        return this.filterToListener.size();
    }
}
