/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCL.java,v 1.1 2007/01/25 18:39:26 cdamus Exp $
 */

package org.eclipse.ocl.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * UML metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on a 
 * {@link UMLEnvironmentFactory} instance using its own resource set.
 * <p>
 * The parser environments created by the UML environment factory support OCL
 * expressions at both the metamodel (M2) and user model (M1) levels.  For
 * user model constraints, use the classifier in the model as the context
 * classifier in invocations of this <code>OCL</code> or an {@link OCLHelper}
 * created by it.  For metamodel OCL (used, for example, to query the user
 * model, itself) use the metaclass of any element in the user model as the
 * context classifier.  A convenient way to obtain this metaclass is via the
 * {@link OCLUMLUtil#getMetaclass(org.eclipse.uml2.uml.Element)} method.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see UMLEnvironmentFactory
 */
public class OCL extends org.eclipse.ocl.OCL<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> {

    /**
     * Initializes me with an environment factory for the UML metamodel.
     *  
     * @param envFactory my environment factory
     */
	protected OCL(EnvironmentFactory<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> envFactory) {
		super(envFactory);
	}

    /**
     * Initializes me with an initial environment for the UML metamodel.
     * 
     * @param env my root environment
     */
	protected OCL(Environment<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> env) {
		super(env);
	}

    /**
     * Initializes me with an environment factory for the UML metamodel and
     * a resource from which to load my root environment.
     * 
     * @param envFactory my environment factory
     * @param resource my persisted root environment
     */
	protected OCL(EnvironmentFactory<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> envFactory,
			Resource resource) {
		super(envFactory, resource);
	}

    /**
     * Creates a new <code>OCL</code> using a new UML environment factory
     * that uses a private resource set and the global package registry for
     * looking up Ecore representations of UML packages.
     * 
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance() {
		return new OCL(new UMLEnvironmentFactory());
	}

    /**
     * Creates a new <code>OCL</code> using a new UML environment factory
     * that uses the specified resource set and its local package registry for
     * looking up Ecore representations of UML packages.
     * 
     * @param rset a resource set containing UML models
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(ResourceSet rset) {
		return new OCL(new UMLEnvironmentFactory(rset));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified UML environment
     * factory.
     * 
     * @param envFactory an environment factory for UML
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> envFactory) {
		
		return new OCL(envFactory);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified initial UML
     * environment.
     * 
     * @param env an environment for UML
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(Environment<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> env) {
		
		return new OCL(env);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified UML environment
     * factory and a resource from which to load the initial environment.
     * 
     * @param envFactory an environment factory for UML
     * @param resource the resource containing a persistent environment
     *    (which may be empty for an initially empty environment)
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory<
			Package, Classifier, Operation, Property,
			EnumerationLiteral, Parameter, State,
			CallOperationAction, SendSignalAction, Constraint,
			Class, EObject> envFactory,
			Resource resource) {
		
		return new OCL(envFactory, resource);
	}
    
    @Override
    public Helper createOCLHelper() {
       return new OCLHelperImpl(super.createOCLHelper());
    }
    
    /**
     * Convenient interface aliasing the type parameter substitutions for the
     * UML environment, for ease of typing.
     * 
     * @author Christian W. Damus (cdamus)
     */
    public static interface Helper extends OCLHelper<Classifier, Operation, Property, Constraint> {
        // no additional features
    }
}
