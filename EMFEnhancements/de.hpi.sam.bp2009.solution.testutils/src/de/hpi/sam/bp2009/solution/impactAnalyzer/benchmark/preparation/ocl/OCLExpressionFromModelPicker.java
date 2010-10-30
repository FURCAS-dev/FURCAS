package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.Tuple.Pair;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * The {@link OCLExpressionFromModelPicker} extracts constraints out of the
 * NGPM meta model and parses them.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class OCLExpressionFromModelPicker implements OCLExpressionPicker {

    @Override
    public List<OCLExpressionWithContext> pickUpExpressions() {
        return pickUpExpressions(data.classes.ClassesPackage.eINSTANCE,
        	data.constraints.ConstraintsPackage.eINSTANCE, data.documents.DocumentsPackage.eINSTANCE,
        	data.generics.GenericsPackage.eINSTANCE, data.quantitystructure.QuantitystructurePackage.eINSTANCE,
        	data.timedependency.TimedependencyPackage.eINSTANCE, data.tuples.TuplesPackage.eINSTANCE,

        	dataaccess.analytics.AnalyticsPackage.eINSTANCE, dataaccess.expressions.ExpressionsPackage.eINSTANCE,
        	dataaccess.expressions.fp.FpPackage.eINSTANCE, dataaccess.expressions.literals.LiteralsPackage.eINSTANCE,
        	dataaccess.query.QueryPackage.eINSTANCE,

        	behavioral.actions.ActionsPackage.eINSTANCE, behavioral.bpdm.BpdmPackage.eINSTANCE,
        	behavioral.businesstasks.BusinesstasksPackage.eINSTANCE, behavioral.events.EventsPackage.eINSTANCE,
        	behavioral.rules.RulesPackage.eINSTANCE,

        	persistence.actions.ActionsPackage.eINSTANCE, persistence.expressions.ExpressionsPackage.eINSTANCE);
    }

    public List<OCLExpressionWithContext> pickUpExpressions(EPackage... packages){
        List<OCLExpressionWithContext> expressionSet = new ArrayList<OCLExpressionWithContext>(
                searchAndParseExpressions(packages).values());
        return expressionSet;
    }

    private LinkedHashMap<Pair<String, EClassifier>, OCLExpressionWithContext> searchAndParseExpressions(EPackage... ps) {
        LinkedHashMap<Pair<String, EClassifier>, OCLExpressionWithContext> allConstraints = new LinkedHashMap<Pair<String, EClassifier>, OCLExpressionWithContext>();
	EAnnotationOCLParser oclParser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
	for (EPackage pkg : ps) {
	    oclParser.traversalConvertOclAnnotations(pkg);
	}
	for (EPackage p : ps) {
	    for (EClassifier c : p.getEClassifiers()) {
		EAnnotation a = c.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		allConstraints = addConstraintToConstraintList(a, allConstraints, c);
		if (c instanceof EClass) {
		    for (EAttribute at : ((EClass) c).getEAttributes()) {
			a = at.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			allConstraints = addConstraintToConstraintList(a, allConstraints, c);
		    }
		}
	    }
	}
	return allConstraints;
    }

    private LinkedHashMap<Pair<String, EClassifier>, OCLExpressionWithContext> addConstraintToConstraintList(EAnnotation a,
            LinkedHashMap<Pair<String, EClassifier>, OCLExpressionWithContext> allConstraints, EClassifier c) {
	if (a == null)
	    return allConstraints;
	int index = 0;
	for (Entry<String, String> detail : a.getDetails()) {
	    String e = detail.getValue();
	    if (e == null) {
		break;
	    } else {
                EAnnotation astAnno = ((EModelElement)a.eContainer()).getEAnnotation(EcoreEnvironment.OCL_NAMESPACE_URI);
                OCLExpression expr = (OCLExpression) ((Constraint)astAnno.getContents().get(index)).getSpecification().getBodyExpression();
                allConstraints.put(new Pair<String, EClassifier>(e, c), new OCLExpressionWithContext(expr ,(EClass) c) );
            }
	    index++;
	}

	return allConstraints;
    }
}
