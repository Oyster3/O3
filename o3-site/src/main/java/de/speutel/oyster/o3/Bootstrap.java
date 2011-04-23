package de.speutel.oyster.o3;

import java.io.File;
import java.util.List;

import javax.inject.Named;
import javax.servlet.ServletContextEvent;

import org.sonatype.guice.bean.binders.SpaceModule;
import org.sonatype.guice.bean.reflect.URLClassSpace;
import org.sonatype.inject.BeanScanning;
import org.sonatype.sisu.sitebricks.SisuConfigurationModule;
import org.sonatype.sisu.sitebricks.SisuServletContextListener;
import org.sonatype.sisu.sitebricks.SisuSitebricksModule;

import com.google.inject.Binder;
import com.google.inject.Module;

@Named
public class Bootstrap extends SisuServletContextListener {

	private File webappDirectory;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		webappDirectory = new File(servletContextEvent.getServletContext().getRealPath("/"));

		super.contextInitialized(servletContextEvent);
	}

	@Override
	protected void installModules(List<Module> modules) {
		addModule(new Module() {

			public void configure(Binder binder) {
			}
		});
		addModule(new SpaceModule(new URLClassSpace(getClass().getClassLoader()), BeanScanning.ON));
		addModule(new SisuConfigurationModule(webappDirectory, "o3"));
		addModule(new SisuSitebricksModule(Package.class.getPackage()));
	}
}
