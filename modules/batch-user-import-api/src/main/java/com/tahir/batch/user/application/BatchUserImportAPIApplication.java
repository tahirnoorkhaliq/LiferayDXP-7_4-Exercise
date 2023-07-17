package com.tahir.batch.user.application;

import com.liferay.headless.batch.engine.client.dto.v1_0.ImportTask;
import com.liferay.headless.batch.engine.client.resource.v1_0.ImportTaskResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Tahir
 */
@Component(property = { 
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/batch-user",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=UserImport.Rest"
		}, 
		service = Application.class)
public class BatchUserImportAPIApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/importusers")
	@Produces("text/plain")
	public String ImportUsers() {		
		InputStream is = BatchUserImportAPIApplication.class.getClassLoader().getResourceAsStream("userloadtest.json");
		String usersJson = printInputStream(is);
		is = BatchUserImportAPIApplication.class.getClassLoader().getResourceAsStream("fieldNameMapping.json");
		String fieldNameMapping= printInputStream(is);
		System.out.println("Processing File"+usersJson+"\n fieldNameMapping "+fieldNameMapping);
		ImportTaskResource.Builder builder = ImportTaskResource.builder();
		ImportTaskResource importTaskResource = builder.authentication("test@liferay.com", "test").build();////.endpoint(host, port, scheme).builder.build();//
		
		try {
			ImportTask response = importTaskResource.postImportTask(
					String.valueOf("com.liferay.headless.admin.user.dto.v1_0.UserAccount"), null, "INSERT", null, null,
					"IMPORT_STRATEGY_ON_ERROR_CONTINUE", null, usersJson);
			System.out.println(response);
			return response.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			e.printStackTrace();
		}
		return "Error";
	}

	private static String printInputStream(InputStream is) {

		try {
			String text = new BufferedReader(
					new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
			System.out.println(text.length());
			return text;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}