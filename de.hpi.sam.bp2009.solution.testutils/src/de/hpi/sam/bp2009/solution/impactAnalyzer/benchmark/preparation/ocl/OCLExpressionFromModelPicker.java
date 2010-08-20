package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.OCLExpression;

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
    public Collection<OCLExpressionWithContext> pickUpExpressions() {
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

    public Collection<OCLExpressionWithContext> pickUpExpressions(EPackage... packages){
	Collection<OCLExpressionWithContext> expressionSet = searchAndParseExpressions(packages).values();

        Collection<OCLExpressionWithContext> result = new ArrayList<OCLExpressionWithContext>();
        result.addAll(expressionSet);
        return result;
    }

    private Map<String, OCLExpressionWithContext> searchAndParseExpressions(EPackage... ps) {
	Map<String, OCLExpressionWithContext> allConstraints = new HashMap<String, OCLExpressionWithContext>();
	EAnnotationOCLParser oclParser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
	for (EPackage pkg : ps) {
	    oclParser.traversalConvertOclAnnotations(pkg);
	}
	for (EPackage p : ps) {
	    for (EClassifier c : p.getEClassifiers()) {
		EAnnotation a = c.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
		allConstraints = addConstraintToConstraintList(a, allConstraints, c);
		if (c instanceof EClass) {
		    for (EAttribute at : ((EClass) c).getEAttributes()) {
			a = at.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
			allConstraints = addConstraintToConstraintList(a, allConstraints, c);
		    }
		}
	    }
	}
	return allConstraints;
    }

    private Map<String, OCLExpressionWithContext> addConstraintToConstraintList(EAnnotation a,
	    Map<String, OCLExpressionWithContext> allConstraints, EClassifier c) {
	if (a == null)
	    return allConstraints;
	int index = 0;
	for (Entry<String, String> detail : a.getDetails()) {
	    String e = detail.getValue();
	    if (e == null) {
		break;
	    } else {
		allConstraints.put(e, new OCLExpressionWithContext((OCLExpression) a.getContents().get(index), (EClass) c));
	    }
	    index++;
	}

	return allConstraints;
    }
}
