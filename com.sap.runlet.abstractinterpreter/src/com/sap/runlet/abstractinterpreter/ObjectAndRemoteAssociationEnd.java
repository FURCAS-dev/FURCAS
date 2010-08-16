package com.sap.runlet.abstractinterpreter;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

/**
 * A value-holder class for an object and a remote association end. Use instances
 * of this class as key for maps in which to store the links for navigating from the
 * <tt>object</tt> to the remote association end.
 * 
 * @author Axel Uhl (D043530)
 */
public class ObjectAndRemoteAssociationEnd<LinkMetaObject extends EObject,
					   LinkEndMetaObject extends EObject,
					   TypeUsage extends EObject,
					   ClassUsage extends TypeUsage,
					   MetaClass extends EObject> {
	private final ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> object;
	private final LinkEndMetaObject remoteAssociationEnd;
	private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;
	
	public ObjectAndRemoteAssociationEnd(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> object,
		LinkEndMetaObject remoteLinkEndMetaObject,
		ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	    this.object = object;
	    this.remoteAssociationEnd = remoteLinkEndMetaObject;
	    this.modelAdapter = modelAdapter;
	}
	private ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
	    return modelAdapter;
	}
	public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getObject() {
	    return object;
	}
	public LinkEndMetaObject getRemoteAssociationEnd() {
	    return remoteAssociationEnd;
	}
	public boolean equals(Object o) {
	    return (getObject() == null && ((ObjectAndRemoteAssociationEnd<?, ?, ?, ?, ?>) o).getObject() == null) ||
		    getObject() != null && getObject().equals(((ObjectAndRemoteAssociationEnd<?, ?, ?, ?, ?>) o).getObject()) &&
	    	getRemoteAssociationEnd().equals(((ObjectAndRemoteAssociationEnd<?, ?, ?, ?, ?>) o).getRemoteAssociationEnd());
	}
	public int hashCode() {
	    return ((getObject()==null)?0:getObject().hashCode()) ^ getRemoteAssociationEnd().hashCode();
	}
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append("ObjectAndRemoteLinkEndMetaObject from object ");
	    result.append(getObject());
	    result.append(" via association ");
	    result.append(getModelAdapter().getAssociationName(getModelAdapter().getAssociation(getRemoteAssociationEnd())));
	    result.append(" to end ");
	    result.append(getModelAdapter().getEndName(getRemoteAssociationEnd()));
	    result.append(" of type ");
	    result.append(getModelAdapter().getClassName(getModelAdapter().getEndType(getRemoteAssociationEnd())));
	    return result.toString();
	}
}

