package org.adi.springPA;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Transaktion implements JavaDelegate {
	 
	  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	  
	  public void execute(DelegateExecution execution) throws Exception {
		  LOGGER.info("\n\n Transaktion.class ist ausgelöst worden. \n\n"); 
		  throw new BpmnError("ADIS_ERROR");
	  }

}
