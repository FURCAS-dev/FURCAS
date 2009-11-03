package com.sap.mi.textual.epi.builder;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.epi.Messages;
import com.sap.mi.textual.epi.conf.IProjectMetaRefConf;
import com.sap.mi.textual.epi.conf.ProjectMetaRefConfFactory;



/**
 * The Class SyntaxGenerationNature.
 */
public class SyntaxGenerationNature implements IProjectNature {

    /** ID of this project nature. */
    public static final String NATURE_ID = Activator.class.getPackage()
            .getName() + ".syntaxGenerationNature";

    /** The project. */
    private IProject project;

    /*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(SyntaxBuilder.BUILDER_ID)) {
				return;
			}
		}

		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 1, commands.length);
		ICommand command = desc.newCommand();
		command.setBuilderName(SyntaxBuilder.BUILDER_ID);
		newCommands[0] = command;
		desc.setBuildSpec(newCommands);
		project.setDescription(desc, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(SyntaxBuilder.BUILDER_ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i,
						commands.length - i - 1);
				description.setBuildSpec(newCommands);
				return;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

	/**
	 * returns the metamodelInfo for the metamodel configured for this project, or null if none is configured.
	 * 
	 * @return the meta model reference conf
	 * @throws CoreException 
	 */
	public IProjectMetaRefConf getMetaModelReferenceConf() {
//	    IProject tempproject = getProject();
//	    IFile file = tempproject.getFile("TCS.ecore");
//
//
//	    return new EcoreMetaProjectConf(file);
	    return getMetaModelReferenceConf(getProject());
	}

	/**
	 * Gets the meta model reference conf.
	 * 
	 * @param proj the proj
	 * 
	 * @return the meta model reference conf
	 */
	public static IProjectMetaRefConf getMetaModelReferenceConf(IProject proj) {
		
		IProjectMetaRefConf conf = null;
		
		try {
			conf = ProjectMetaRefConfFactory.getConfig(proj);
		} catch (CoreException e) {
			Activator.logError(e);
		}
		
//		MetaModelInfo metaInfo = null;
//		try {
//			
//			if(metamodelContainerName != null) {
//				metaInfo = MoinIntegrationHelper.getMetaModelInfo(metamodelContainerName);
//			}
//		} catch (CoreException e) {
//			Activator.logError(e);
//		}
		
		return conf;
	}
	
	/**
	 * returns the metamodelInfo for the metamodel configured for this project, or null if none is configured.
	 * 
	 * @param conf the conf
	 */
	public void setMetaModel(IProjectMetaRefConf conf) {
		try {
			ProjectMetaRefConfFactory.configure(getProject(), conf);
		} catch (CoreException e) {
			Activator.logError(e);
		}
	}

	/**
	 * helper method to get nature for any project, returns null in error cases 
	 * or when project does not have this nature.
	 * 
	 * @param project the project
	 * 
	 * @return the nature from project
	 */
    public static SyntaxGenerationNature getNatureFromProject(IProject project) {
        if (project != null) {
            IProjectNature nature = null;
            try {
				nature = project.getNature(SyntaxGenerationNature.NATURE_ID);
				
			} catch (CoreException e) {
				Activator.logError(e);
			}
			if (nature != null) {
				if (!(nature instanceof SyntaxGenerationNature)) {
                    Activator
                            .displayError(Messages.WorkbenchPropertyPage_Error_Nature_Conflict
                                    + SyntaxGenerationNature.NATURE_ID);
                }
				return (SyntaxGenerationNature) nature;
			}
		}
		return null;
	}

}

