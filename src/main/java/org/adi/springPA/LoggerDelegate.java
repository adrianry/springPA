package org.adi.springPA;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.repository.ProcessDefinition;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
  
  //zugriff auf die engine und den repo service
  private ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
  private RepositoryService repositoryService = engine.getRepositoryService();
  private ProcessDefinition processDefinition;
  
  public void execute(DelegateExecution execution) throws Exception {
    
	//Query im RepoService um das zur aktuellen Instanz gehörende Diagram zu finden.
	processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(execution.getProcessDefinitionId()).singleResult();
	 
    LOGGER.info("\n \n ************************************************************************************************************** " +
            "\n  ... LoggerDelegate invoked by "
            + ", \n processName=" + processDefinition.getName()
            + ", \n activtyName='" + execution.getCurrentActivityName() + "'"
            + ", \n businessKey=" + execution.getProcessBusinessKey()
            + " \n ************************************************************************************************************** \n");
    
  }

}
