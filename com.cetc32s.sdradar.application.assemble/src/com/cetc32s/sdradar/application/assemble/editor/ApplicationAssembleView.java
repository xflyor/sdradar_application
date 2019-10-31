package com.cetc32s.sdradar.application.assemble.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.cetc32s.sdradar.application.assemble.Activator;
import com.cetc32s.sdradar.application.assemble.model.device.DeviceModel;

public class ApplicationAssembleView extends GraphicalEditorWithPalette implements IEditorPart {
	
	private PaletteRoot root;
	private GraphicalViewer viewer;

	public ApplicationAssembleView() {
		//TODO Auto-generated constructor stub
		setEditDomain(new DefaultEditDomain(this));
	}
	
   @Override
	protected void configureGraphicalViewer() {
    	//该函数在initializeGraphicalViewer函数之前执行
    	super.configureGraphicalViewer();     	
       	
    } 

	@Override
	protected void initializeGraphicalViewer() {
		//TODO Auto-generated method stub
		
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		//TODO Auto-generated method stub
		root=new PaletteRoot();		
		PaletteGroup toolGroup =new PaletteGroup("Tools");

		ToolEntry tool=new SelectionToolEntry();
		toolGroup.add(tool);		
		root.setDefaultEntry(tool);

		tool=new MarqueeToolEntry();
		toolGroup.add(tool);		
	    root.add(toolGroup);   
	    
	    //Devices
 		PaletteDrawer devicesDrawer=new PaletteDrawer("Devices");		
 		ImageDescriptor devicesDescriptor= AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,null);
 		SimpleFactory deviceSimpleFactory = new SimpleFactory(DeviceModel.class);
 		CreationToolEntry halDeviceToolEntry = new CreationToolEntry("HalDevice", "Create New Device.",deviceSimpleFactory,devicesDescriptor,devicesDescriptor);
 		devicesDrawer.add(halDeviceToolEntry);
 		root.add(devicesDrawer); 		
 		
	    return root;
	}	


	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

}
