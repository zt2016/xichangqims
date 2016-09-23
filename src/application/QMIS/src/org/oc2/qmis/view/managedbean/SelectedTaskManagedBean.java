package org.oc2.qmis.view.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.oc2.qmis.model.entity.TaskBase;

@ManagedBean(name = "selectedTaskManagedBean")
@SessionScoped
public class SelectedTaskManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5180479063885506442L;
	
	private TaskBase selected;

	public TaskBase getSelected() {
		return selected;
	}

	public void setSelected(TaskBase selected) {
		this.selected = selected;
	}

}
