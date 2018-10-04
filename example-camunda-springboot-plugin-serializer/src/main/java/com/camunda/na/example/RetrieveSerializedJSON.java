package com.camunda.na.example;


import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

/**
 * This is an easy adapter implementation 
 * illustrating how a Java Delegate can be used 
 * from within a BPMN 2.0 Service Task.
 */

@Component("retrieveSerialized")
public class RetrieveSerializedJSON implements JavaDelegate {
 
	
	
  private final Logger LOGGER = Logger.getLogger(RetrieveSerializedJSON.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... SpinSerializer invoked by "
            + "processDefinitionId=" + execution.getProcessDefinitionId()
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", activtyName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + " \n\n");
   
    
    ObjectValue customer = execution.getVariableTyped("customer");
    String customerJson = customer.getValueSerialized();
    
    LOGGER.info(customerJson);
    
  }

}

