package com.infotrends.servlet;

/**
 * @author Lin
 */

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;

@Path("/Query_Person")
public class Query_PersonServlet {

	@GET
	@Produces("application/json")
	public Response getAll() throws JSONException {

		JSONObject jsonObject = new JSONObject();

		// Logic

		jsonObject.put("Status", "GET no Path");

		// String result = "@Produces(\"application/json\") Output: \n\nF to C
		// Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("{Str}")
	@GET
	@Produces("application/json")
	public Response getFromPath(@PathParam("Str")
	String EMPLOYEE_ID) throws JSONException {

		JSONObject jsonObject = new JSONObject();

		// Logic

		String DBID = "123123";
		String FIRST_NAME = "Hong-Lin";
		String LAST_NAME = "Tsai";
		String USER_NAME = "Lin";
		int IS_ADMIN = 0;
		int IS_AGENT = 1;
		int STATE = 2;

		jsonObject.put("Status", "GET Path");
		jsonObject.put("DBID", DBID);
		jsonObject.put("FIRST_NAME", FIRST_NAME);
		jsonObject.put("LAST_NAME", LAST_NAME);
		jsonObject.put("USER_NAME", USER_NAME);
		jsonObject.put("EMPLOYEE_ID", EMPLOYEE_ID);
		jsonObject.put("IS_ADMIN", IS_ADMIN);
		jsonObject.put("IS_AGENT", IS_AGENT);
		jsonObject.put("STATE", STATE);

		// String result = "@Produces(\"application/json\") Output: \n\nF to C
		// Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("EMPLOYEE_ID")
	String EMPLOYEE_ID) throws IOException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Status", "POST Path");
		try{
			MaintainService maintainService = new MaintainService();
			List<CFG_person> cfg_person = maintainService.Query_Person(EMPLOYEE_ID);
			
			jsonObject.put("DBID", cfg_person.get(0).getDbid());
			jsonObject.put("FIRST_NAME", cfg_person.get(0).getFirst_name());
			jsonObject.put("LAST_NAME", cfg_person.get(0).getLast_name());
			jsonObject.put("USER_NAME", cfg_person.get(0).getUser_name());
			jsonObject.put("EMPLOYEE_ID", cfg_person.get(0).getEmployee_id());
			jsonObject.put("IS_ADMIN", cfg_person.get(0).getIs_admin());
			jsonObject.put("IS_AGENT", cfg_person.get(0).getIs_agent());
			jsonObject.put("STATE", cfg_person.get(0).getState());
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}