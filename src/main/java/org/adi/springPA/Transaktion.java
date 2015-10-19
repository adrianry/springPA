package org.adi.springPA;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class Transaktion implements JavaDelegate {
	 
	  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	  
	  public void execute(DelegateExecution execution) throws Exception {
		  LOGGER.info("\n ******************************************************* \n Transaktion.class ist ausgeloest worden. \n ******************************************************* \n");
		  throw new BpmnError("ADIS_ERROR");
	  }

}
