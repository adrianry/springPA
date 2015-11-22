package org.adi.springPA;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.PreUndeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;

@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication  {

	private ProcessEngine processEngine;

	@PostDeploy
	public void startup(ProcessEngine engine) throws InterruptedException {
		this.processEngine = engine;
	    System.out.println("\n\n --------->process engine up with name:" + processEngine.getName()+"\n");
		
	    //Starte Prozessinstanzen
	    //*************************
	      //starteProzess();
			starteSimple();
	}


	public void starteSimple() throws InterruptedException {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = engine.getRuntimeService();

		ProcessInstance instance = runtimeService.startProcessInstanceByKey("simple-process","easy");
	}
	
	public void starteProzess() throws InterruptedException {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = engine.getRuntimeService();
		
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("springPA","nixkey");
		System.out.println("\n ---------> Instance erzeugt: " + instance.getId() + "\n");
		runtimeService.signalEventReceived("adisSignal");
		System.out.println("\n ---------> Signal gesendet! Schlafe fuer 30 sekunden \n");
		Thread.sleep(30000);
		System.out.println("\n ---------> Aufwachen und User Task erledigen! \n");
		TaskService taskservice = engine.getTaskService();
		Task task = taskservice.createTaskQuery().processInstanceId(instance.getId()).singleResult();
		task.setOwner("demo");
		task.setAssignee("demo");
		System.out.println("\n ---------> Task Owner: "+ task.getOwner() +" \n");
		System.out.println("\n ---------> Task Assignee: "+ task.getAssignee() +" \n");
		taskservice.complete(task.getId());
		System.out.println("\n ---------> Task erledigt und Methode starteProzess fertig! \n");
	}
	  
	@PreUndeploy
	public void stopAndUndeploy() {
		  System.out.println("\n\n ---------->stop and shutdown process application now\n" +
				  "\n");
	}
}