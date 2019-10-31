package com.cetc32s.sdradar.basic.debug;

import java.awt.Button;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

public class OkInformationListShowDig extends TitleAreaDialog {

	private ArrayList<String> msgList;
	private String title;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public OkInformationListShowDig(Shell parentShell,String title, ArrayList<String> msgList) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM);
		setHelpAvailable(false);	
		this.msgList = msgList;	
		this.title =title;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		// TODO Auto-generated method stub
		super.configureShell(newShell);
		newShell.setText("SCA Information");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("SDRadar IDE Information");
		setMessage(title);
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));		
		List list = new List(container, SWT.BORDER);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		for(int i = 0; i <msgList.size(); i++) {
			list.add(msgList.get(i));
		}		
		
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		org.eclipse.swt.widgets.Button btnOk = createButton(parent, IDialogConstants.OK_ID, "Yes", true);
		btnOk.setText("OK");
		btnOk.setFocus();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
