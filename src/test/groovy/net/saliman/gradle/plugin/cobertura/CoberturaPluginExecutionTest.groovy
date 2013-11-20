package net.saliman.gradle.plugin.cobertura

import org.gradle.tooling.GradleConnector
import org.gradle.tooling.ModelBuilder
import org.gradle.tooling.ProjectConnection
import org.gradle.tooling.model.GradleProject
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 11/18/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Steven C. Saliman
 */
class CoberturaPluginExecutionTest {
	ProjectConnection connection

	@Before
	void setUp() {
		connection = GradleConnector.newConnector()
		.forProjectDirectory(new File("testclient/calculator"))
		.connect()
	}

	@After
	void tearDown() {
		if ( connection != null ) {
			connection.close()
		}
	}


	@Test
	void execute() {
		def result = connection.newBuild()
						.withArguments("-m", "-b", "build.gradle")
						.forTasks("clean").run()
//		ModelBuilder gradleBuilder = connection.model(GradleProject.class);

		System.out.println("here")
	}
}
