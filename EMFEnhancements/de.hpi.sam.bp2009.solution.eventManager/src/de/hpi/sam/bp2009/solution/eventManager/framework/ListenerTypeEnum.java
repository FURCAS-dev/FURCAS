package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class is used to describe the type of a listener. There are 4 supported listener types:<br>
 * <ul>
 * <li><b>PreChange</b> listeners are notified before an atomic operation (like a JMI call) is executed. The preChange
 * listener has the possibility to veto such an action. Side effects are not allowed</li>
 * <li><b>PostChange</b> listeners are notified after an atomic operation (like a JMI call) is executed. The postChange
 * listener is allowed to perform side effects. Vetoes are not allowed.</li>
 * <li><b>PreCommit</b> listeners are notified after all atomic operations of a Command/Transaction have been
 * executed successfully and before the Command/Transaction is committed. This type of listener may veto a command, but
 * side effects to the repositry are not allowed.</li>
 * <li><b>Commit</b> listenres are notified when a command/transaction could be committed successfully. Of
 * course, no veto is possible at this point of time. Side effects to the repository are allowed, but they will not be
 * assigned to the current command/transaction.</li>
 * </ul>
 * These types can be combined if a listener wants to implement multiple roles.
 * 
 * @author Daniel Vocke (d044825)
 */
public class ListenerTypeEnum {

    private static final int preChange_int = 2;

    private static final int postChange_int = 4;

    private static final int preCommit_int = 8;

    private static final int postCommit_int = 16;

    public static final ListenerTypeEnum preChange = new ListenerTypeEnum(preChange_int,"PreChange");

    public static final ListenerTypeEnum postChange = new ListenerTypeEnum(postChange_int,"PostChange");

    public static final ListenerTypeEnum preCommit = new ListenerTypeEnum(preCommit_int,"PreCommit");

    public static final ListenerTypeEnum postCommit = new ListenerTypeEnum(postCommit_int,"PostCommit");

    public static final Collection<ListenerTypeEnum> allListenerTypes = new ArrayList<ListenerTypeEnum>(4);
    
    static{
        allListenerTypes.add(preChange);
        allListenerTypes.add(postChange);
        allListenerTypes.add(preCommit);
        allListenerTypes.add(postCommit);
    }
    
    private int myListenerTypes = 0;
    
    private String humanReadableRepresentation=null;
    
    private ListenerTypeEnum(Integer listenerType, String name) {        
        myListenerTypes = listenerType;
        humanReadableRepresentation=name+"-";        
    }

     public ListenerTypeEnum(ListenerTypeEnum... listenerTypes) {
        for (ListenerTypeEnum ltEnum : listenerTypes) {
            myListenerTypes += ltEnum.myListenerTypes;
            humanReadableRepresentation+=ltEnum.humanReadableRepresentation+"-";
        }
    }

    public boolean matches(ListenerTypeEnum other) {
        return (myListenerTypes & other.myListenerTypes) != 0;
    }

    public String toString() {
        return "ListenerType:"+humanReadableRepresentation+"Listener";
    }
}
