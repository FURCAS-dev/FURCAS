/**
 * 
 */
package com.sap.furcas.builder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * 
 */
public class ProjectSyntaxHelper {

//    /**
//     * @param shell
//     * @param result
//     */
//    public static void openEditorOnResult(Shell shell, EObject result) {
//	// create ModelEditorInput
//	ModelObjectElementFactory fac = new ModelObjectElementFactory();
//	final ModelEditorInput eInput = fac.createEditorInput(result);
//
//	// open Editor using Editor Input
//
//	shell.getDisplay().asyncExec(new Runnable() {
//	    @Override
//	    public void run() {
//		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//		try {
//		    IDE.openEditor(page, eInput, "com.sap.mi.tcs.editor.ActionsEditor");
//		} catch (PartInitException e) {
//		    Activator.logError(e);
//		}
//	    }
//	});
//    }

    public static EObject createMapping(String content, ResourceSet connection, List<String> metaModelContainerNames,
	    ParserFacade tcsParserFacade) throws InvalidParserImplementationException, IOException,
	    UnknownProductionRuleException, ModelAdapterException {

	Set<URI> referencePRIs = new HashSet<URI>();

	if (metaModelContainerNames != null) {
	    for (String metaModelContainerName : metaModelContainerNames) {

		try {

		    // this fails during non-plugin Junit-tests
		    DeployedMetaProjectConf conf = new DeployedMetaProjectConf(metaModelContainerName, null);
		    referencePRIs.add(conf.getMetaLookUpForProject().getReferencePRIs());

		} catch (Exception e) {
		    // do nothing
		}

	    }

	    return createMapping(content, connection, referencePRIs, tcsParserFacade);
	}

	return null;
    }

    /**
     * @param content
     * @param connection
     * @param b
     * @return
     * @throws UnknownProductionRuleException
     * @throws IOException
     * @throws InvalidParserImplementationException
     * @throws ModelAdapterException
     */
    public static EObject createMapping(String content, ResourceSet connection, ParserFacade tcsParserFacade)
	    throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, ModelAdapterException {
	Set<URI> referencePRIs = new HashSet<URI>();
	try {
	    try {
		IProjectMetaRefConf conf = ProjectMetaRefConfFactory.getConfig(ModelAdapter.getInstance().getProject(connection));
		referencePRIs.add(conf.getMetaLookUpForProject().getReferencePRIs());
	    } catch (IllegalStateException e) {
		// no dsl nature
		// do nothing
	    }
	    return createMapping(content, connection, referencePRIs, tcsParserFacade);

	} catch (CoreException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public static EObject createMapping(String content, ResourceSet connection, Set<URI> referencePRIs)
	    throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, ModelAdapterException {
	return createMapping(content, connection, referencePRIs, null);
    }

    public static EObject createMapping(String content, ResourceSet connection, Set<URI> referencePRIs,
	    ParserFacade tcsParserFacade) throws InvalidParserImplementationException, IOException,
	    UnknownProductionRuleException, ModelAdapterException {
	Moin moin = connection.getSession().getMoin();
	Set<org.eclipse.emf.ecore.xml.type.internal.DataValue.URI> allReferencePRIs = new HashSet<URI>();
	allReferencePRIs.add(moin
		.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm"));
	allReferencePRIs.add(moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm"));

	allReferencePRIs.addAll(referencePRIs);

	ByteArrayInputStream input = new ByteArrayInputStream(content.getBytes());
	ModelInjectionResult result = TCS2MOINInjectorFacade.parseSyntaxDefinition(input, connection, allReferencePRIs, null,
		tcsParserFacade);

	return result.getSyntax();

    }

}
