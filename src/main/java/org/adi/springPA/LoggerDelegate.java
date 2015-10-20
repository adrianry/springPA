package org.adi.springPA;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n ************************************************************************************************************** " +
            "\n  ... LoggerDelegate invoked by "
            //+ "processDefinitionId=" + execution.getProcessDefinitionId()
            //+ ", activtyId=" + execution.getCurrentActivityId()
            + ", \n activtyName='" + execution.getCurrentActivityName() + "'"
            //+ ", processInstanceId=" + execution.getProcessInstanceId()
            + ", \n businessKey=" + execution.getProcessBusinessKey()
            //+ ", executionId=" + execution.getId()
            + " \n ************************************************************************************************************** \n");
    
  }

}
