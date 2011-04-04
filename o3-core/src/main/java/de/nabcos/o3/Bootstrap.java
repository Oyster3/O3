package de.nabcos.o3;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;

import de.nabcos.o3.rest.Info;

public class Bootstrap extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new SitebricksModule() {

			@Override
			protected void configureSitebricks() {
				scan(Info.class.getPackage());
			}

		});
	}

}
