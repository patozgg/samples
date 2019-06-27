package com.camunda.forum.TenantIdentifier;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProvider;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderCaseInstanceContext;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderHistoricDecisionInstanceContext;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderProcessInstanceContext;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class SharedDefnintionTenant implements TenantIdProvider,ProcessEnginePlugin {

	 
	  public String provideTenantIdForProcessInstance(TenantIdProviderProcessInstanceContext ctx) {
		 
		  
	    return getTenantIdOfCurrentAuthentication();
	  }

	 
	  public String provideTenantIdForCaseInstance(TenantIdProviderCaseInstanceContext ctx) {
	    return getTenantIdOfCurrentAuthentication();
	  }

	
	  public String provideTenantIdForHistoricDecisionInstance(TenantIdProviderHistoricDecisionInstanceContext ctx) {
	    return getTenantIdOfCurrentAuthentication();
	  }

	  protected String getTenantIdOfCurrentAuthentication() {

	    IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
	    Authentication currentAuthentication = identityService.getCurrentAuthentication();
	   
	    if (currentAuthentication != null) {

	      List<String> tenantIds = currentAuthentication.getTenantIds();
	      if (tenantIds.size() == 1) {
	        return tenantIds.get(0);

	      } else if (tenantIds.isEmpty()) {
	        throw new IllegalStateException("no authenticated tenant");

	      } else {
	        throw new IllegalStateException("more than one authenticated tenant");
	      }

	    } else {
	      throw new IllegalStateException("no authentication");
	    }
	  }


	@Override
	public void postInit(ProcessEngineConfigurationImpl arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void postProcessEngineBuild(ProcessEngine arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void preInit(ProcessEngineConfigurationImpl arg0) {
		// TODO Auto-generated method stub
		
	}
	  
	
	  

	}