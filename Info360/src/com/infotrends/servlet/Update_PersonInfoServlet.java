package com.infotrends.servlet;

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
@Path("/Update_PersonInfo")
public class Update_PersonInfoServlet {
	/**
	 * 雿輻POST�寞�
	 * 靘�撣唾��湔�犖鞈�
	 * @param ACCOUNT
	 * @param FIRST_NAME
	 * @param LAST_NAME
	 * @param USER_NAME
	 * @param EMAILADDRESS
	 * @param PASSWORD
	 * @param USERNAME
	 * @return
	 * @throws IOException
	 */

	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("account") String account,
			@FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("user_name") String user_name,
			@FormParam("emailaddress") String emailaddress,
			@FormParam("password") String password
			) throws IOException {
		
		account = account.trim();
		first_name = first_name.trim();
		last_name = last_name.trim();
		user_name = user_name.trim();
		emailaddress = emailaddress.trim();
		password = password.trim();

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", "POST Path");
		cfg_person.setAccount(account);
		cfg_person.setFirst_name(first_name);
		cfg_person.setLast_name(last_name);
		cfg_person.setEmailaddress(emailaddress);;
	    cfg_person.setPassword(password);
		cfg_person.setUser_name(user_name);
		jsonObject.put("Status", "POST Path");
		int updatecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			updatecount = maintainService.update_PersonInfo(cfg_person);
			jsonObject.put("updatecount", updatecount);
			
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	
	
}
