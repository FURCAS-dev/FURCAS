package com.sap.river.interpreter.rucola;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.util.Base64;

public class Entity extends ClassTypedObject {

    public Entity(Rucola rucola, RiverObject object) {
	super(rucola, object);
    }

    @Override
    public Entity asEntity() {
	return this;
    }

    /**
     * Retrieves an opaque ID string from this entity, assuming that this object
     * represents a single entity object and not a multi-object. The only
     * purpose for this ID is to marshal it, e.g., to clients who later want to
     * interact with the same entity in the same snapshot again.
     */
    public String getId() {
	/*
	 * The ID consists of the Base64-encoded serialization of foud objects:
	 *  * the classname
	 *  * the UUID
	 *  * the SnapshotIdentifier
	 *  * the persistent flag
	 */
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	ObjectOutputStream oos;
	try {
	    oos = new ObjectOutputStream(bos);
	    EntityObject eo = (EntityObject) getSingleObject();
	    oos.writeObject(eo.getType().getClazz().getName());
	    oos.writeObject(eo.getId());
	    oos.writeObject(eo.getOrigin());
	    oos.writeBoolean(eo.isPersistent());
	    oos.close();
	    return Base64.encode(bos.toByteArray());
	} catch (IOException e) {
	    throw new RucolaException("Internal error trying to serialize entity object "+getSingleObject(),
		    e);
	}
    }
}
