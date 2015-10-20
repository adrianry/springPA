package org.adi.springPA;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.PreUndeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;

@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication  {

	private ProcessEngine processEngine;

	@PostDeploy
	public void startup(ProcessEngine engine) {
		this.processEngine = engine;
	    System.out.println("\n\n --------->process engine name:" + processEngine.getName()+"\n");
		starteProzess();
	}


	public void starteProzess(){
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = engine.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("springPA","nixkey");
		System.out.println("\n ---------> Instance erzeugt: " + instance.getId() + "\n");
		runtimeService.signalEventReceived("adisSignal");
		System.out.println("\n ---------> Signal gesendet! \n");
		System.out.println("\n ---------> Methode starteProzess fertig! \n");
	}
	  
	@PreUndeploy
	public void stopAndUndeploy() {
		  System.out.println("\n\n ---------->stop and shutdown process application now\n" +
				  "\n");
	}
}