package com.sap.runlet.interpreter;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.LinkContainer;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

/**
 * Objects are structurally connected by links which are typed by associations. Each link has two
 * ends, at each of which it has one object whose type is a value or entity class. The type of an
 * object at an end has to conform with the type specified by the association end's type.
 * <p>
 * 
 * A link container is an in-memory cache of links created by an
 * {@link RunletInterpreter interpreter} and those loaded from a {@link Repository}. The link
 * container keeps track of the entities for which it has authoritative information regarding the
 * links attaching to them for a given snapshot and for a given remote association end. It also does
 * this for those entities/ends where no links exist in a given snapshot, just to ensure that if
 * asked again it knows that the empty link set is the authoritative answer and no round-trip to the
 * repository is required.
 * 
 * @author Axel Uhl (D043530)
 */
public class RunletLinkContainer extends LinkContainer<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    public RunletLinkContainer(Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository,
	    ModelAdapter<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> modelAdapter) {
	super(modelAdapter, repository);
    }
    
}
