package com.github.sh0hei.lifttt.resources;

import java.io.IOException;

import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.github.sh0hei.lifttt.core.GoogleDrive;
import com.google.api.client.util.Charsets;

@Path("/views")
public class ViewResource {
	@GET
	@Produces("text/html;charset=UTF-8")
	@Path("/login")
	public View freemarkerUTF8() {
		return new View("/views/login.ftl", Charsets.UTF_8) {
			
		};
	}
	
	@POST
	@Produces("text/html;charset=UTF-8")
	@Path("/timeline")
	public View timeLine() {
		GoogleDrive gd = new GoogleDrive();
		try {
			gd.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new View("/views/timeline.ftl", Charsets.UTF_8) {
			
		};
	}
}