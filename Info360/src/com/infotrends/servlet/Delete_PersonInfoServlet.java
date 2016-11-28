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


@Path("/Delete_PersonInfo")
public class Delete_PersonInfoServlet {
	/**
	 * 雿輻POST�寞�
	 * 靘�撣唾���蝣潛��餃��芷�犖鞈�
	 * @param ACCOUNT
	 * @param PASSWORD
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(@FormParam("account") String account,
			@FormParam("password") String password
			) throws IOException {
		
		account = account.trim();
		password = password.trim();

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", "POST Path");
		cfg_person.setAccount(account);
		cfg_person.setPassword(password);
	
		
		int deletecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			deletecount = maintainService.delete_PersonInfo(cfg_person);
			jsonObject.put("deletecount", deletecount);
			
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
