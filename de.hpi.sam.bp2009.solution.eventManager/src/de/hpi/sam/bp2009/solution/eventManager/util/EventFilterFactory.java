/**
 * 
 */
package de.hpi.sam.bp2009.solution.eventManager.util;


/**
 * @author Philipp Berger
 * 
 */
public class EventFilterFactory {

    static EventFilterFactory instance = new EventFilterFactory();

    /**
     * @return the singelton instance of the factory
     */
    public static EventFilterFactory getInstance() {
        return instance;
    }

    /**
     * private constructor for singelton
     */
    private EventFilterFactory() {
    }

}
