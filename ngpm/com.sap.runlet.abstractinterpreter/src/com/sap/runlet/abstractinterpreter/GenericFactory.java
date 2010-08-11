package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;

/**
 * For an object, such as a model element or a {@link RunletObject}, finds the
 * most specific {@link Class} registered with this factory to handle the
 * object.
 * <p>
 * 
 * Handling classes are registered for one or more concrete types. If this would
 * lead to an ambiguity for resolving handlers, an exception is thrown.
 * <p>
 * 
 * The factory chooses the handler that can handle the actual type of the object
 * passed to the factory and for which no other handler is registered for a type
 * to which the object conforms and that conforms to the type the chosen handler
 * can handle. In other words, the most specific handler is selected.
 * <p>
 * 
 * The specialization relation over the objects passed to this factory is
 * implemented by the {@link #getDirectSupertypes(Object)} method in subclasses
 * of this class.
 * 
 * @param <C>
 *            the class of which instances are the types of objects of type
 *            <tt>T</tt>. of the objects passed to this factory to determine a
 *            handler class for; on objects of this class, direct supertypes can
 *            be computed which defines a conformance relation for finding the
 *            most specific interpreter
 * @param <T>
 *            the type of the objects that handling classes can handle and of
 *            which the type can be determined by {@link #getType(Object)},
 *            returning a <tt>C</tt> object describing the <tt>T</tt> object's
 *            type. Example: <tt>Expression</tt> as the abstract superclass of
 *            all expressions (which would require <tt>C</tt> to be
 *            {@link MofClass} because it's the type description based on which
 *            the specialization hierarchy is constructed. In particular,
 *            elements passed to {@link #getHandlerFor(Object)} have to be
 *            at least of that type.
 * 
 * @param <H>
 *            the handler class's common base class; used as the return type of
 *            {@link #getHandlerClassFor(Object)}. All handler classes must have a
 *            public single-argument constructor with the argument's type being
 *            <tt>T</tt> or the specific subtype of <tt>T</tt>
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class GenericFactory<C, T, H> {
    private Map<C, Class<?>> registeredHandlerClasses;
    
    public GenericFactory() {
	registeredHandlerClasses = new HashMap<C, Class<?>>();
    }
    
    public void registerHandlerClass(Class<? extends H> handlerClass, C... classes) {
	// TODO ambiguity check
	for (C c:classes) {
	    registeredHandlerClasses.put(c, handlerClass);
	}
    }
    
    public void registerHandlerClass(Class<? extends H> handlerClass, C clazz) {
	// TODO ambiguity check
	registeredHandlerClasses.put(clazz, handlerClass);
    }
    
    @SuppressWarnings("unchecked")
    public H getHandlerFor(T object) throws SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
	H result = null;
	C clazz = getType(object);
	Class<?> interpreterClass = getHandlingClassForClass(clazz);
	if (interpreterClass != null) {
	    Constructor<? extends H> constructor =
		(Constructor<? extends H>) interpreterClass.getConstructors()[0];
	    result = constructor.newInstance(object);
	}
	return result;
    }

    abstract protected C getType(T object);
    
    protected Class<?> getHandlingClassForClass(C clazz) {
	Class<?> resultClass = registeredHandlerClasses.get(clazz);
	if (resultClass == null) {
	    for (C superclass:getDirectSupertypes(clazz)) {
		resultClass = getHandlingClassForClass(superclass);
		if (resultClass != null) {
		    return resultClass;
		}
	    }
	}
	return resultClass;
    }
    
    abstract protected Iterable<C> getDirectSupertypes(C c);
}
