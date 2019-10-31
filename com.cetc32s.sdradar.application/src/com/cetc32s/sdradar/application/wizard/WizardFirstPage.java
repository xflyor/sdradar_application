package com.cetc32s.sdradar.application.wizard;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.cetc32s.sdradar.basic.path.SDRadarPath;
import com.cetc32s.sdradar.basic.resouces.SDRadarResouce;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class WizardFirstPage extends WizardPage {
	private Text projectNameText;
	private Text projectPathText;

	public WizardFirstPage() {
		super("New Application Project");
		setMessage("Project name must be specified.");
		setTitle("SDRadar Application");
	}
	
	@Override
	public boolean isPageComplete() {
		// TODO Auto-generated method stub
		if(projectNameText.getText().length()>0&&projectPathText.getText().length()>0)return true;
		else return false;
	}

	@Override
	public void createControl(Composite parent) {		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(container, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite.heightHint = 43;
		composite.setLayoutData(gd_composite);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Name:");		
		projectNameText = new Text(composite, SWT.BORDER);
		projectNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Path:");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.verticalSpacing = 0;
		gl_composite_1.marginHeight = 0;
		gl_composite_1.marginWidth = 0;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		projectPathText = new Text(composite_1, SWT.BORDER);

		projectPathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));		
		Button browserBtn = new Button(composite_1, SWT.NONE);	
		browserBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		browserBtn.setText("Browser");
		
		
		//init
		projectPathText.setText(SDRadarResouce.getWorkspacePath());
		
		projectNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				getContainer().updateButtons();
			}
		});
		
		projectPathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				getContainer().updateButtons();
			}
		});
		browserBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog directoryDialog = new DirectoryDialog(getShell());
				directoryDialog.setText("Select Project Path");
				directoryDialog.open();				
				String selectedPath = directoryDialog.getFilterPath();				
				if(selectedPath.length()>0)projectPathText.setText(SDRadarPath.modifyDirPath(selectedPath));				
			}
		});
	}
	
	public String getProjectName() {
		return projectNameText.getText();
		
	}
	
	public String getProjectPath() {
		return projectPathText.getText();
	}
}
