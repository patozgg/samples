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

@Component("spinSerializer")
public class SerializeJSONFromJavaObject implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(SerializeJSONFromJavaObject.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... SpinSerializer invoked by "
            + "processDefinitionId=" + execution.getProcessDefinitionId()
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", activtyName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + " \n\n");
    
    //Creating and storing JSON in the global execution context
    Address address = new Address("12 High Street", 1234);
    Customer customer = new Customer("Jonny", address);
    
    ObjectValue typedCustomerValue =
    		  Variables.objectValue(customer).serializationDataFormat("application/json").create();

	execution.setVariable("customer", typedCustomerValue);
    
  }

}

class Customer {
	protected String name;
	protected Address address;
	  
	  Customer(String name, Address address) {
		  this.name = name;
		  this.address = address;
	  }

  	public String getName() {
  		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

}

class Address {
  protected String street;
  protected int postCode;

  Address(String street, int postCode) {
	  this.street = street;
	  this.postCode = postCode;
  }
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getPostCode() {
		return postCode;
	}
	
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	} 
}
