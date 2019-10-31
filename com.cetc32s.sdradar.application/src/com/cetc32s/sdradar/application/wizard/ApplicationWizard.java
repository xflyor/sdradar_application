package com.cetc32s.sdradar.application.wizard;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.cetc32s.sdradar.basic.debug.YNInfomationShowDig;
import com.cetc32s.sdradar.basic.path.SDRadarPath;

public class ApplicationWizard extends BasicNewResourceWizard implements INewWizard {
	
	private WizardFirstPage projectNameAndPathPage;
	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		projectNameAndPathPage = new WizardFirstPage();
		addPage(projectNameAndPathPage);
	}
	
	
	
	@Override
	public void init(IWorkbench theWorkbench, IStructuredSelection currentSelection) {
		// TODO Auto-generated method stub
		super.init(theWorkbench, currentSelection);	
	
		setWindowTitle("New Application Project");
	
		
	}
	
	@Override
	public boolean performFinish() {
		//obtain baisc information of project
		String projectName = projectNameAndPathPage.getProjectName();
		String projectPath = projectNameAndPathPage.getProjectPath();
		createProject(projectName,projectPath);
	
		
		return true;
	}
	
	private void createProject(String name, String path) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		IProjectDescription projectDescription = workspace.newProjectDescription(name);
		IPath projectLocation = new Path(path+name);
		projectDescription.setLocation(projectLocation);
		try {
			IProject project = workspaceRoot.getProject(name);
			if(project.exists()) {
				YNInfomationShowDig ynInfomationShowDig = new YNInfomationShowDig(getShell(), 
						 name + " project already exists.Are you sure to delete?");
				int result = ynInfomationShowDig.open();
				if(result!=0)return;
				else project.delete(true, null);				
			}			
			project.create(projectDescription,null);
			project.open(null);				
			//add project file
			createProjectFile(project.getLocation().toString()+SDRadarPath.getFileSeparator()+project.getName()+".ral");
		
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
	
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private boolean createProjectFile(String path) {		
		if(path.length()<1)return false;
		
		File file = new File(path);
		if(file.exists())file.delete();		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return true;	
	}
	

}


/*IRunnableWithProgress oProgress = new IRunnableWithProgress() {	
@Override
public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
	// TODO Auto-generated method stub				
	monitor.beginTask("start create project......", 10);
	for(int i = 0; i < 10; i++) {
		if(monitor.isCanceled())return;
		//project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		TimeUnit.SECONDS.sleep(1);
		monitor.setTaskName("process->"+(new Integer(i+1)).toString());
		monitor.worked(i+1);
	}
	monitor.done();			
}
};

new ProgressMonitorDialog(getShell()).run(true, true, oProgress);*/
