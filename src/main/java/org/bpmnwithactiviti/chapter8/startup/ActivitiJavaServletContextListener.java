package org.bpmnwithactiviti.chapter8.startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

public class ActivitiJavaServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ProcessEngines.init();
		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
																.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?autoReconnect=true")
																.setJdbcDriver("com.mysql.jdbc.Driver")
																.setJdbcUsername("root")
																.setJdbcPassword("sf0701")
																.setJobExecutorActivate(true)
																.buildProcessEngine();
		ProcessEngines.registerProcessEngine(processEngine);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ProcessEngines.destroy();
	}

}
