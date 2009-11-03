package com.sap.river.interpreter.rucola;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.SnapshotIdentifier;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;
import com.sap.river.interpreter.util.Base64;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.NestedTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

/**
 * A Runlet Java Connector. Serves as a factory for {@link RucolaObject}s based on
 * {@link RiverObject}s and based on registrations of available facade types. One
 * such connector instance is tied to a single {@link RiverInterpreter interpreter}.
 * 
 * @author Axel Uhl D043530
 *
 */
public class Rucola {
    private RiverInterpreter interpreter;
    
    /**
     * Initializes a new {@link RiverInterpreter} with a new empty
     * {@link InMemoryRepository} and wraps it by a {@link Rucola} object.
     */
    public Rucola(Connection conn) {
	this(conn, new InMemoryRepository());
    }
    
    public Rucola(Connection conn, Repository repository) {
	this(new RiverInterpreter(conn, repository));
    }
    
    public Rucola(RiverInterpreter interpreter) {
	this.interpreter = interpreter;
    }

    protected RiverInterpreter getInterpreter() {
        return interpreter;
    }
    
    protected Connection getConnection() {
	return getInterpreter().getConnection();
    }

    protected RucolaObject createRucolaObjectForRiverObject(RiverObject o) {
	RucolaObject result;
	if (o == null) {
	    result = null;
	} else {
	    TypeDefinition td = o.getType();
	    if (td instanceof NestedTypeDefinition) {
		throw new RucolaException("Don't know yet how to represent NestedTypeDefinition-based objects in Rucola");
	    }
	    if (td instanceof ClassTypeDefinition) {
		ClassTypeDefinition ctd = (ClassTypeDefinition) td;
		if (ctd.getClazz().isValueType()) {
		    result = new Value(this, o);
		} else {
		    result = new Entity(this, o);
		}
	    } else if (td instanceof FunctionSignatureTypeDefinition) {
		result = new Function(this, o);
	    } else {
		throw new RucolaException("Don't know how to represent " + o + " in Rucola");
	    }
	}
	return result;
    }

    private Value wrapNativeObject(Object o, String runletNativeClassName) {
	// TODO cache class type definitions
	ClassTypeDefinition type = MetamodelUtils.createClassTypeDefinitionExactlyOne(getConnection(), MetamodelUtils.findClass(
		getConnection(), runletNativeClassName));
	type.assign___PartitionIncludingChildren(getTransientPartition());
	return new Value(this, new NativeObject(type, o, getInterpreter().getDefaultSnapshot(), getInterpreter()));
    }

    /**
     * If <tt>o</tt> is of a type that any of the specific <tt>wrap</tt> operations supports as
     * argument type, that specific operation is used to wrap <tt>o</tt> as a {@link RucolaObject}.
     * If <tt>o</tt> already happens to be a {@link RucolaObject} instance, it is returned unchanged.
     * If <tt>o</tt> is of unsupported, unwrappable type, a {@link RucolaException} is thrown.
     */
    protected RucolaObject wrap(Object o, TypeDefinition targetType) {
	if (o == null) {
	    if (targetType instanceof ClassTypeDefinition) {
		if (((ClassTypeDefinition) targetType).getClazz().isValueType()) {
		    return new Value(this, new EmptyObject(targetType));
		} else {
		    return new Entity(this, new EmptyObject(targetType));
		}
	    } else if (targetType instanceof FunctionSignatureTypeDefinition) {
		return new Function(this, new EmptyObject(targetType));
	    } else {
		throw new RucolaException("Don't know how to wrap null for target type "+targetType);
	    }
	}
	if (o instanceof RucolaObject) {
	    return (RucolaObject) o;
	} else if (o instanceof Boolean) {
	    return wrapNativeObject(o, "Boolean");
	} else if (o instanceof Integer) {
	    return wrapNativeObject(new Fraction((Integer) o), "Number");
	} else if (o instanceof Double) {
	    return wrapNativeObject(new Fraction(new BigDecimal((Double) o)), "Number");
	} else if (o instanceof Float) {
	    return wrapNativeObject(new Fraction(new BigDecimal((Float) o)), "Number");
	} else if (o instanceof Long) {
	    return wrapNativeObject(new Fraction((Long) o), "Number");
	} else if (o instanceof Fraction) {
	    return wrapNativeObject(o, "Number");
	} else if (o instanceof BigDecimal) {
	    return wrapNativeObject(new Fraction((BigDecimal) o), "Number");
	} else if (o instanceof BigInteger) {
	    return wrapNativeObject(new Fraction((BigInteger) o), "Number");
	} else if (o instanceof Date) {
	    return wrapNativeObject(o, "TimePoint");
	} else if (o instanceof String) {
	    return wrapNativeObject(o, "String");
	} else if (o instanceof Iterable) { // and not a RucolaObject because that was checked first
	    // TODO enable wrapping of Java collections into Rucola MultiObject instances
	    throw new RucolaException("Converting Java collections into Runlet multi-objects not supported yet");
	} else {
	    throw new RucolaException("Don't know how to wrap object "+o+" of type "+o.getClass().getName());
	}
    }
    
    public void store(Entity e) {
	for (RiverObject ro : e.getObject().flatten()) {
	    getInterpreter().storeEntity((EntityObject) ro);
	}
    }
    
    public Value commit() {
	try {
	    return wrapNativeObject(getInterpreter().commit(), "Snapshot");
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
    
    private ModelPartition getTransientPartition() {
	return getConnection().getOrCreateTransientPartition("RucolaTransient_Thread"+Thread.currentThread().getId());
    }
    
    public Entity newEntity(String classname) {
	ClassTypeDefinition type = MetamodelUtils.createClassTypeDefinitionExactlyOne(getConnection(),
		MetamodelUtils.findClass(getConnection(), classname));
	type.assign___PartitionIncludingChildren(getTransientPartition());
	assert !type.getClazz().isValueType();
	EntityObject eo = getInterpreter().createEntityObject(type);
	return new Entity(this, eo);
    }
    
    /**
     * Pass an ID string that you obtained from {@link Entity#getId()} and you will be
     * given an entity referring to the same object in the snapshot identified by the
     * entity from which you obtained the ID.
     */
    public Entity getEntityById(String id) {
	/*
	 * The ID consists of the Base64-encoded serialization of foud objects:
	 *  * the classname
	 *  * the UUID
	 *  * the SnapshotIdentifier
	 *  * the persistent flag
	 */
	byte[] serializedEntityObject = Base64.decode(id);
	ObjectInputStream ois;
	try {
	    ois = new ObjectInputStream(new ByteArrayInputStream(serializedEntityObject));
	    String classname = (String) ois.readObject();
	    UUID uuid = (UUID) ois.readObject();
	    SnapshotIdentifier snapshotIdentifier = (SnapshotIdentifier) ois.readObject();
	    boolean isPersistent = ois.readBoolean();
	    ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(getConnection(),
		    MetamodelUtils.findClass(getConnection(), classname));
	    EntityObject result = new EntityObject(ctd, uuid, snapshotIdentifier);
	    result.setPersistent(isPersistent);
	    return new Entity(this, result);
	} catch (Exception e) {
	    throw new RucolaException("Invalid entity ID "+id, e);
	}
    }

    /**
     * Obtains a value of the class identified by <tt>classname</tt> that has no
     * equality-relevant association ends.
     */
    public Value value(String classname) {
	return value(classname, null);
    }    
    
    /**
     * Obtains a value of the class identified by <tt>classname</tt> with the equality-relevant
     * association ends identified by the keys of <tt>values</tt> set to the values of the
     * <tt>values</tt> map.<p>
     * 
     * The <tt>values</tt> argument may be <tt>null</tt> in case no equality-relevant
     * links shall be set on the value or the value class does not have any equality-relevant
     * association ends.
     */
    public Value value(String classname, Map<String, Object> values) {
	ClassTypeDefinition type = MetamodelUtils.createClassTypeDefinitionExactlyOne(getConnection(),
		MetamodelUtils.findClass(getConnection(), classname));
	type.assign___PartitionIncludingChildren(getTransientPartition());
	SapClass valueClass = type.getClazz();
	assert valueClass.isValueType();
	Collection<AssociationEnd> equalityRelevantEnds = valueClass.getEqualityRelevantAssociationEnds();
	Map<AssociationEnd, Collection<ClassTypedObject>> propertyValues =
		new HashMap<AssociationEnd, Collection<ClassTypedObject>>();
	if (values != null) {
	    for (AssociationEnd equalityRelevantEnd : equalityRelevantEnds) {
		AssociationEnd farEnd = equalityRelevantEnd.otherEnd();
		Object value = values.get(farEnd.getName());
		if (value != null) {
		    RucolaObject rucolaValue = wrap(value, farEnd.getType());
		    Collection<ClassTypedObject> riverValues = new ArrayList<ClassTypedObject>(1);
		    riverValues.add((ClassTypedObject) rucolaValue.getObject());
		    propertyValues.put(farEnd, riverValues);
		}
	    }
	}
	ValueObject result = getInterpreter().createValueObject(type, propertyValues);
	return new Value(this, result);
    }
}