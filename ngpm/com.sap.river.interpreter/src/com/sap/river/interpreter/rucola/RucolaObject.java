package com.sap.river.interpreter.rucola;

import java.util.Date;
import java.util.Iterator;

import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.Connection;

/**
 * A facade through which a Java client can access {@link RiverObject}s more easily.
 * 
 * @author Axel Uhl D043530
 *
 */
public class RucolaObject implements Iterable<RucolaObject> {
    private Rucola rucola;
    private RiverObject object;

    public RucolaObject(Rucola rucola, RiverObject object) {
	this.rucola = rucola;
	this.object = object;
    }
    
    protected RiverObject getObject() {
	return object;
    }
    
    /**
     * Assumes that the underlying object has a size of 1. This single object is returned.
     * Otherwise, an exception is thrown.<p>
     * 
     * TODO handle NestedTypeDefinition nested MultiObjects
     */
    protected RiverObject getSingleObject() {
	int size = getObject().size();
	if (size > 1) {
	    throw new RucolaException("Cannot pick single element from multi-object with "+getObject().size()+" elements");
	}
	if (size == 0) {
	    throw new RucolaException("Cannot pick single element from empty multi-object");
	}
	RiverObject result = getObject().flatten().iterator().next();
	return result;
    }

    public int size() {
	return getObject().size();
    }
    
    protected RiverInterpreter getInterpreter() {
	return rucola.getInterpreter();
    }
    
    protected Connection getConnection() {
	return rucola.getInterpreter().getConnection();
    }
    
    protected Rucola getRucola() {
	return rucola;
    }
    
    public Entity asEntity() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not an entity");
    }
    
    public Value asValue() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a value");
    }
    
    public String asString() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a String");
    }
    
    public Date asDate() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a Date");
    }
    
    public Fraction asFraction() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a Number");
    }
    
    public int asInt() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a Number or does not fit into an int");
    }

    public double asDouble() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a Number or does not fit into an int");
    }

    public float asFloat() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a Number or does not fit into an int");
    }

    public Function asFunction() {
	throw new RucolaException("RucolaObject of type "+getClass().getName()+" not a function");
    }
    
    public String toString() {
	return getObject().toString();
    }
    
    public boolean equals(Object o) {
	return getObject().equals(((RucolaObject) o).getObject());
    }
    
    public int hashCode() {
	return getObject().hashCode();
    }

    @Override
    public Iterator<RucolaObject> iterator() {
	final Iterator<RiverObject> iter = getObject().iterator();
	return new Iterator<RucolaObject>() {

	    @Override
	    public boolean hasNext() {
		return iter.hasNext();
	    }

	    @Override
	    public RucolaObject next() {
		RiverObject ro = iter.next();
		return getRucola().createRucolaObjectForRiverObject(ro);
	    }

	    @Override
	    public void remove() {
		iter.remove();
	    }
	    
	};
    }
}
