package com.infotrends.servlet;

/**
 * @author Tim
 */

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;

@Path("/Insert_PersonInfo")
public class Insert_PersonInfoServlet {
	/**
	 * 使用POST方法Insert個人資料
	 * 
	 * @param ACCOUNT
	 * @param FIRST_NAME
	 * @param LAST_NAME
	 * @param USER_NAME
	 * @param EMAILADDRESS
	 * @param PASSWORD
	 * @param EMPLOYEE_ID
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("ACCOUNT") String account,
			@FormParam("FIRST_NAME") String first_name,
			@FormParam("LAST_NAME") String last_name,
			@FormParam("USER_NAME") String username,
			@FormParam("EMAILADDRESS") String emailaddress,
			@FormParam("PASSWORD") String password,
			@FormParam("EMPLOYEE_ID") String employee_id
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", "POST Path");
		cfg_person.setAccount(account);
		cfg_person.setFirst_name(first_name);
		cfg_person.setLast_name(last_name);
		cfg_person.setEmailaddress(emailaddress);;
	    cfg_person.setPassword(password);
		cfg_person.setUser_name(username);
		cfg_person.setEmployee_id(employee_id);
		try{
			MaintainService maintainService = new MaintainService();
			int count = maintainService.insert_PersonInfo(cfg_person);
			
			jsonObject.put("insertcount", count);
			
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}