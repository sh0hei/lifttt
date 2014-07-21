package com.github.sh0hei.lifttt;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.github.sh0hei.lifttt.health.TemplateHealthCheck;
import com.github.sh0hei.lifttt.resources.LiftttResources;

public class LiftttApplication extends Application<LiftttConfiguration> {

	public static void main(String[] args) throws Exception {
		new LiftttApplication().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<LiftttConfiguration> bootstrap) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run(LiftttConfiguration configuration, Environment environment)
			throws Exception {
		final LiftttResources resources = new LiftttResources(
			configuration.getTemplate(),
			configuration.getDefaultName()
		);
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resources);
	}
}
