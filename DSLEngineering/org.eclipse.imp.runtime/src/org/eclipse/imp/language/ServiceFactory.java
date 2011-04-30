/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.language;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.imp.editor.OutlineContentProviderBase;
import org.eclipse.imp.editor.OutlineLabelProvider.IElementImageProvider;
import org.eclipse.imp.indexing.IndexContributorBase;
import org.eclipse.imp.parser.IModelListener;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.IASTAdapter;
import org.eclipse.imp.services.IAnnotationHover;
import org.eclipse.imp.services.IAutoEditStrategy;
import org.eclipse.imp.services.ICompareNodeIdentifier;
import org.eclipse.imp.services.IContentProposer;
import org.eclipse.imp.services.IDocumentationProvider;
import org.eclipse.imp.services.IEntityImageDecorator;
import org.eclipse.imp.services.IEntityNameLocator;
import org.eclipse.imp.services.IFoldingUpdater;
import org.eclipse.imp.services.IHelpService;
import org.eclipse.imp.services.IHoverHelper;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.imp.services.ILanguageActionsContributor;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.imp.services.INavigationTargetFinder;
import org.eclipse.imp.services.IOccurrenceMarker;
import org.eclipse.imp.services.IOutliner;
import org.eclipse.imp.services.IRefactoringContributor;
import org.eclipse.imp.services.IReferenceResolver;
import org.eclipse.imp.services.ISourceFormatter;
import org.eclipse.imp.services.ISourceHyperlinkDetector;
import org.eclipse.imp.services.IToggleBreakpointsHandler;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.imp.utils.ExtensionException;
import org.eclipse.imp.utils.ExtensionFactory;

/**
 * This class stores language services. IMP services are configured with
 * language specific extension points. This registry provides implementations
 * for them. It finds the implementations by looking for Eclipse extensions for
 * IMP's extension points.
 * 
 * If IMP is extended with a new kind of language service, this class must be
 * extended.
 * 
 * The getter methods of this class return 'null' when a service does not exist
 * (i.e. an extension has not been provided yet)
 * 
 * The getter methods of this class will throw unchecked exceptions when the
 * extension implementations are not well formed.
 * 
 * The getter methods only load the extension implementations the first time
 * somebody asks for them. After that they are cached in the registry. This lazy
 * behavior is necessary to optimize the startup time of Eclipse.
 * 
 * @author jurgenv
 */
public class ServiceFactory {
    private static ServiceFactory sInstance;

    /**
     * The unqualified extension point ID for IMP language descriptors.
     */
    public static final String LANGUAGE_DESCRIPTION_POINT_ID = "languageDescription";

    /**
     * The qualified extension point ID for IMP language descriptors.
     */
    public static final String LANGUAGE_DESCRIPTION_QUALIFIED_POINT_ID = RuntimePlugin.IMP_RUNTIME + ".languageDescription";

    static final String AUTO_EDIT_STRATEGY_SERVICE = "autoEditStrategy";

	static final String ANNOTATION_HOVER_SERVICE = "annotationHover";

	static final String AST_ADAPTER_SERVICE = "astAdapter";

    static final String COMPARE_NODE_IDENTIFIER_SERVICE = "compareNodeIdentifier";

	static final String CONTENT_PROPOSER_SERVICE = "contentProposer";

    static final String CONTEXT_HELPER_SERVICE= "contextHelper";

	static final String DOCUMENTATION_PROVIDER_SERVICE = "documentationProvider";

	static final String EDITOR_ACTION_CONTRIBUTIONS_SERVICE = "editorActionContributions";

    static final String EDITOR_SERVICE= "editorService";

    static final String ENTITY_IMAGE_DECORATOR_SERVICE = "entityImageDecorator";

    static final String ENTITY_NAME_LOCATOR_SERVICE = "entityNameLocator";

	static final String FOLDING_UPDATER_SERVICE = "foldingUpdater";

	static final String FORMATTER_SERVICE = "formatter";

	static final String HOVER_HELPER_SERVICE = "hoverHelper";

	static final String HYPER_LINK_SERVICE = "hyperLink";

	static final String IMAGE_DECORATOR_SERVICE = "imageDecorator";

	static final String INDEX_CONTRIBUTOR_SERVICE = "indexContributor";

	static final String LABEL_PROVIDER_SERVICE = "labelProvider";

	static final String MODEL_LISTENER_SERVICE = "modelListener";

	static final String MODEL_TREE_BUILDER_SERVICE = "modelTreeBuilder";

    static final String MARK_OCCURRENCES_SERVICE = "markOccurrences";

    static final String NAVIGATION_TARGET_FINDER_SERVICE = "navigationTargetFinder";

	static final String OUTLINE_CONTENT_PROVIDER_SERVICE = "outlineContentProvider";

	static final String OUTLINER_SERVICE = "outliner";

	static final String PARSER_SERVICE = "parser";

	static final String PREFERENCES_SERVICE = "preferencesDialog";

	static final String PREFERENCES_SPECIFICATION = "preferencesSpecification";

	static final String REFACTORING_CONTRIBUTIONS_SERVICE = "refactoringContributions";

	static final String REFERENCE_RESOLVER_SERVICE = "referenceResolvers";

	static final String SYNTAX_PROPS_SERVICE = "syntaxProps";

    static final String TOGGLE_BREAKPOINTS_HANDLER_SERVICE= "toggleBreakpointHandler";

	static final String TOKEN_COLORER_SERVICE = "tokenColorer";

	static final String VIEWER_FILTER_SERVICE = "viewerFilter";

	/**
	 * The list of fully-qualified extension point IDs for all IMP language services.
	 * Does not include the language descriptor extension point ID.
	 */
	public static final List<String> ALL_SERVICES= new LinkedList<String>();

	static {
	    Class<ServiceFactory> clazz= ServiceFactory.class;
	    Field[] fields= clazz.getDeclaredFields();
	    for(int i= 0; i < fields.length; i++) {
            Field field= fields[i];
            if (field.getName().endsWith("_SERVICE") && Modifier.isStatic(field.getModifiers())) {
                try {
                    String val= (String) field.get(null);
                    ALL_SERVICES.add(RuntimePlugin.IMP_RUNTIME + "." + val);
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }
            }
        }
	}

	protected ServiceFactory() { }

    /**
     * Returns the {@link ServiceFactory}. IMP services are configured with
     * language specific extension points. This registry provides the
     * implementations for them. This class finds these implementations via
     * Eclipse's extension point mechanism.
     * 
     * @return
     */
    public static ServiceFactory getInstance() {
        if (sInstance == null) {
            sInstance = new ServiceFactory();
        }
        return sInstance;
    }
    
    public static ServiceFactory otherGetInstance() {
    	return sInstance;
    }

    public IAnnotationHover getAnnotationHover(Language lang) {
        try {
            return (IAnnotationHover) loadService(lang, ANNOTATION_HOVER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + ANNOTATION_HOVER_SERVICE + " does not implement IAnnotationHover",
                    e);
            return null;
        }
    }

    public IASTAdapter getASTAdapter(Language lang) {
        try {
            return (IASTAdapter) loadService(lang, AST_ADAPTER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + AST_ADAPTER_SERVICE + " does not implement IASTAdapter",
                    e);
            return null;
        }
    }

    public Set<IAutoEditStrategy> getAutoEditStrategies(Language lang) {
        try {
            Set<ILanguageService> services = loadServices(lang, AUTO_EDIT_STRATEGY_SERVICE);
            Set<IAutoEditStrategy> autoEditStrategies = new HashSet<IAutoEditStrategy>();

            for (ILanguageService s : services) {
                autoEditStrategies.add((IAutoEditStrategy) s);
            }

            return autoEditStrategies;
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + AUTO_EDIT_STRATEGY_SERVICE + " does not implement IAutoEditStrategy",
                    e);
            return null;
        }
    }

    public ICompareNodeIdentifier getCompareNodeIdentifier(Language lang) {
        try {
            return (ICompareNodeIdentifier) loadService(lang, COMPARE_NODE_IDENTIFIER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + COMPARE_NODE_IDENTIFIER_SERVICE + " does not implement ICompareNodeIdentifier",
                    e);
            return null;
        }
    }

    public IContentProposer getContentProposer(Language lang) {
        try {
            return (IContentProposer) loadService(lang, CONTENT_PROPOSER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + CONTENT_PROPOSER_SERVICE + " does not implement IContentProposer",
                    e);
            return null;
        }
    }

    public IHelpService getContextHelper(Language lang) {
        try {
            return (IHelpService) loadService(lang, CONTEXT_HELPER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + CONTEXT_HELPER_SERVICE + " does not implement IHelpService",
                    e);
            return null;
        }
    }

    public IDocumentationProvider getDocumentationProvider(Language lang) {
        try {
            return (IDocumentationProvider) loadService(lang, DOCUMENTATION_PROVIDER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + DOCUMENTATION_PROVIDER_SERVICE + " does not implement IDocumentationProvider",
                    e);
            return null;
        }
    }

    public Set<IModelListener> getEditorServices(Language lang) {
        Set<IModelListener> result= new HashSet<IModelListener>();
        for(ILanguageService service: createExtensions(lang, EDITOR_SERVICE)) {
            result.add((IModelListener) service);
        }
        return result;
    }

    public IElementImageProvider getElementImageProvider(Language lang) {
        try {
            return (IElementImageProvider) loadService(lang, IMAGE_DECORATOR_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + IMAGE_DECORATOR_SERVICE + " does not implement IElementImageProvider",
                    e);
            return null;
        }
    }

    public IEntityImageDecorator getEntityImageDecorator(Language lang) {
        try {
            return (IEntityImageDecorator) loadService(lang, ENTITY_IMAGE_DECORATOR_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + ENTITY_IMAGE_DECORATOR_SERVICE + " does not implement IEntityImageDecorator",
                    e);
            return null;
        }
    }

    public IEntityNameLocator getEntityNameLocator(Language lang) {
        try {
            return (IEntityNameLocator) loadService(lang, ENTITY_NAME_LOCATOR_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + ENTITY_NAME_LOCATOR_SERVICE + " does not implement IEntityNameLocator",
                    e);
            return null;
        }
    }

    public IFoldingUpdater getFoldingUpdater(Language lang) {
        try {
            return (IFoldingUpdater) loadService(lang, FOLDING_UPDATER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + FOLDING_UPDATER_SERVICE + " does not implement IFoldingUpdater",
                    e);
            return null;
        }
    }

    public IHoverHelper getHoverHelper(Language lang) {
        try {
            return (IHoverHelper) loadService(lang, HOVER_HELPER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + HOVER_HELPER_SERVICE + " does not implement IHoverHelper",
                    e);
            return null;
        }
    }

    public IndexContributorBase getIndexContributor(Language lang) {
        try {
            return (IndexContributorBase) loadService(lang,
                    INDEX_CONTRIBUTOR_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + INDEX_CONTRIBUTOR_SERVICE + " does not implement IndexContributorBase",
                    e);
            return null;
        }
    }

    public ILabelProvider getLabelProvider(Language lang) {
        try {
            return (ILabelProvider) loadService(lang, LABEL_PROVIDER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + LABEL_PROVIDER_SERVICE + " does not implement ILabelProvider",
                    e);
            return null;
        }
    }

    public Set<ILanguageActionsContributor> getLanguageActionsContributors(
            Language lang) {
        try {
            Set<ILanguageService> services = loadServices(lang, EDITOR_ACTION_CONTRIBUTIONS_SERVICE);

            Set<ILanguageActionsContributor> actionContributors = new HashSet<ILanguageActionsContributor>();

            for (ILanguageService s : services) {
                actionContributors.add((ILanguageActionsContributor) s);
            }

            return actionContributors;
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + EDITOR_ACTION_CONTRIBUTIONS_SERVICE + " does not implement ILanguageActionConstributor",
                    e);
            return null;
        }
    }

    public IModelListener getModelListener(Language lang) {
        try {
            return (IModelListener) loadService(lang, MODEL_LISTENER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + MODEL_LISTENER_SERVICE + " does not implement IModelListener",
                    e);
            return null;
        }
    }

    public INavigationTargetFinder getNavigationTargetFinder(Language lang) {
        try {
            return (INavigationTargetFinder) loadService(lang, NAVIGATION_TARGET_FINDER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of NAVIGATION_TARGET_FINDER does not implement INavigationTargetFinder",
                    e);
            return null;
        }
    }

    public IOccurrenceMarker getOccurrenceMarker(Language lang) {
        try {
            return (IOccurrenceMarker) loadService(lang, MARK_OCCURRENCES_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + MARK_OCCURRENCES_SERVICE + " does not implement IOccurrenceMarker",
                    e);
            return null;
        }
    }

    public OutlineContentProviderBase getOutlineContentProvider(Language lang) {
        try {
            return (OutlineContentProviderBase) loadService(lang, OUTLINE_CONTENT_PROVIDER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + OUTLINE_CONTENT_PROVIDER_SERVICE + " does not implement OutlineContentProviderBase",
                    e);
            return null;
        }
    }

    public IOutliner getOutliner(Language lang) {
        try {
            return (IOutliner) loadService(lang, OUTLINER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + OUTLINER_SERVICE + " does not implement IOutliner",
                    e);
            return null;
        }
    }

    public IParseController getParseController(Language lang) {
        try {
            return (IParseController) loadService(lang, PARSER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + PARSER_SERVICE + " does not implement IParseController",
                    e);
            return null;
        }
    }

    public Set<IRefactoringContributor> getRefactoringContributors(Language lang) {
        try {
            Set<ILanguageService> services = loadServices(lang, REFACTORING_CONTRIBUTIONS_SERVICE);
            Set<IRefactoringContributor> refactoringContribs = new HashSet<IRefactoringContributor>();

            for (ILanguageService s : services) {
                refactoringContribs.add((IRefactoringContributor) s);
            }

            return refactoringContribs;
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + REFACTORING_CONTRIBUTIONS_SERVICE + " does not implement IRefactoringContributor",
                    e);
            return null;
        }
    }

    public IReferenceResolver getReferenceResolver(Language lang) {
        try {
            return (IReferenceResolver) loadService(lang, REFERENCE_RESOLVER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + REFERENCE_RESOLVER_SERVICE + " does not implement IReferenceResolver",
                    e);
            return null;
        }
    }

    public ISourceFormatter getSourceFormatter(Language lang) {
        try {
            return (ISourceFormatter) loadService(lang, FORMATTER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + FORMATTER_SERVICE + " does not implement ISourceFormatter",
                    e);
            return null;
        }
    }

    public ISourceHyperlinkDetector getSourceHyperlinkDetector(Language lang) {
        try {
            return (ISourceHyperlinkDetector) loadService(lang, HYPER_LINK_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + HYPER_LINK_SERVICE + " does not implement ISourceHyperlinkDetector",
                    e);
            return null;
        }
    }

    public ILanguageSyntaxProperties getSyntaxProperties(Language lang) {
        try {
            return (ILanguageSyntaxProperties) loadService(lang, SYNTAX_PROPS_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + SYNTAX_PROPS_SERVICE + " does not implement ILanguageSyntaxProperties",
                    e);
            return null;
        }
    }

    public IToggleBreakpointsHandler getToggleBreakpointsHandler(Language lang) {
        try {
            return (IToggleBreakpointsHandler) loadService(lang, TOGGLE_BREAKPOINTS_HANDLER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + TOGGLE_BREAKPOINTS_HANDLER_SERVICE + " does not implement IToggleBreakpointsHandler",
                    e);
            return null;
        }
    }

    public ITokenColorer getTokenColorer(Language lang) {
        try {
            return (ITokenColorer) loadService(lang, TOKEN_COLORER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + TOKEN_COLORER_SERVICE + " does not implement ITokenColorer",
                    e);
            return null;
        }
    }

    public TreeModelBuilderBase getTreeModelBuilder(Language lang) {
        try {
            return (TreeModelBuilderBase) loadService(lang, MODEL_TREE_BUILDER_SERVICE);
        } catch (ClassCastException e) {
            RuntimePlugin.getInstance().logException(
                    "Alleged implementation of " + MODEL_TREE_BUILDER_SERVICE + " does not implement TreeModelBuilderBase",
                    e);
            return null;
        }
    }

    private ILanguageService createExtension(Language lang, String id) {
        try {
            return ExtensionFactory.createServiceExtension(lang, id);
        } catch (ExtensionException e) {
            RuntimePlugin.getInstance().logException(
                    "Failed to create extension: " + id, e);
            return null;
        }
    }

    private Set<ILanguageService> createExtensions(Language lang, String id) {
        try {
          return ExtensionFactory.createServiceExtensionSet(lang, id);
        } 
        catch (ExtensionException e) {
            RuntimePlugin.getInstance().logException(
                    "Failed to create set of extensions for: " + id, e);
            return new HashSet<ILanguageService>();
        }
    }

    private Set<ILanguageService> loadServices(Language lang, String serviceId) {
        return createExtensions(lang, serviceId);
    }

    private ILanguageService loadService(Language lang, String name) {
        if (lang == null) {
            RuntimePlugin.getInstance().writeErrorMsg("Null language for service = " + name);
            return null;
        }
        if (name == null) {
            RuntimePlugin.getInstance().writeErrorMsg("Null service for language = " + lang);
            return null;
        }
        return createExtension(lang, name);
    }
}
