/**
 * 
 */
package org.eclipse.emf.ocl.internal.parser;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * @author cdamus
 *
 */
public class CompatibilityTypeResolver
		implements TypeResolver<EClassifier, EOperation, EStructuralFeature> {
	
	private final org.eclipse.emf.ocl.parser.TypeResolver oldStyle;
	private final Environment env;
	
	public CompatibilityTypeResolver(
			Environment env,
			org.eclipse.emf.ocl.parser.TypeResolver oldStyle) {
		this.oldStyle = oldStyle;
		this.env = env;
	}
	
	public Resource getResource() {
		return oldStyle.getResource();
	}

	public EClassifier resolve(EClassifier type) {
		return oldStyle.resolve(type);
	}

	public EOperation resolveAdditionalOperation(EClassifier owner,
			EOperation operation) {
		return oldStyle.resolveAdditionalOperation(owner, operation);
	}
	
	public List<EOperation> getAdditionalOperations(EClassifier owner) {
		// never called by the compatibility environment
		return ECollections.emptyEList();
	}

	public EStructuralFeature resolveAdditionalAttribute(EClassifier owner,
			EStructuralFeature property) {
		return oldStyle.resolveAdditionalProperty(owner, property);
	}
	
	public List<EStructuralFeature> getAdditionalAttributes(EClassifier owner) {
		// never called by the compatibility environment
		return ECollections.emptyEList();
	}

	public CollectionType<EClassifier, EOperation> resolveCollectionType(
			CollectionKind kind, EClassifier elementType) {
		return (CollectionType<EClassifier, EOperation>)
			CompatibilityUtil.getNewAS(env, oldStyle.resolveCollectionType(
				org.eclipse.emf.ocl.expressions.CollectionKind.getCompatibleKind(kind),
				(EClassifier) CompatibilityUtil.getOldAS(env, elementType)));
	}

	public MessageType<EClassifier, EOperation, EStructuralFeature> resolveOperationMessageType(
			EOperation operation) {
		return (MessageType<EClassifier, EOperation, EStructuralFeature>)
			CompatibilityUtil.getNewAS(env, oldStyle.resolveMessageType(operation));
	}

	public MessageType<EClassifier, EOperation, EStructuralFeature> resolveSignalMessageType(
			EClassifier signal) {
		return (MessageType<EClassifier, EOperation, EStructuralFeature>)
			CompatibilityUtil.getNewAS(env, oldStyle.resolveMessageType((EClass) signal));
	}

	public TupleType<EOperation, EStructuralFeature> resolveTupleType(
			EList<? extends TypedElement<EClassifier>> parts) {
		return (TupleType<EOperation, EStructuralFeature>)
			CompatibilityUtil.getNewAS(env, oldStyle.resolveTupleType(
					CompatibilityUtil.getOldAS(env, parts)));
	}

	public TypeType<EClassifier, EOperation> resolveTypeType(EClassifier type) {
		return (TypeType<EClassifier, EOperation>)
			CompatibilityUtil.getNewAS(env, oldStyle.resolveTypeType(
					(EClassifier) CompatibilityUtil.getOldAS(env, type)));
	}
}
