package com.cetc32s.sdradar.basic.debug;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;

public class YNInfomationShowDig extends TitleAreaDialog {
	private String errorMsg;	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public YNInfomationShowDig(Shell parentShell, String errorMsg) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM);
		setHelpAvailable(false);
		this.errorMsg = errorMsg;		
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		// TODO Auto-generated method stub
		super.configureShell(newShell);
		newShell.setText("SDRadar IDE Information");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Information");
		setMessage("Information from SDRadar IDE.");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		List errorMsgList = new List(container, SWT.BORDER);
		errorMsgList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		errorMsgList.add(errorMsg);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {		
		org.eclipse.swt.widgets.Button button = createButton(parent, IDialogConstants.OK_ID, "Yes", true);
		button.setFocus();		
		createButton(parent, IDialogConstants.CANCEL_ID, "No", false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
