package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_person;

import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
@Path("/Query_PersonInfo")
public class Query_PersonInfoServlet {
	/**
	 * 使用POST方法
	 * 依據輸入帳號有無查詢個人帳號資訊或全體帳號資訊
	 * @param ACCOUNT
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("ACCOUNT")
	String account) throws IOException {

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		cfg_person.setAccount(account);
		jsonObject.put("Status", "POST Path");
		try{
			MaintainService maintainService = new MaintainService();
	        List<CFG_person> cfg_personlist = maintainService.query_Person(cfg_person);
			
	        for (int i = 0; i < cfg_personlist.size(); i++) {
	        	jsonObject.accumulate("DN", cfg_personlist.get(i).getDn());
	        	jsonObject.accumulate("DBID", cfg_personlist.get(i).getDbid());
	        	jsonObject.accumulate("CREATEDATETIME", cfg_personlist.get(i).getCreatedatetime());
                jsonObject.accumulate("ACCOUNT",    cfg_personlist.get(i).getAccount());
                jsonObject.accumulate("PASSWORD", cfg_personlist.get(i).getPassword());
				jsonObject.accumulate("FIRST_NAME", cfg_personlist.get(i).getFirst_name());
				jsonObject.accumulate("LAST_NAME",  cfg_personlist.get(i).getLast_name());
				jsonObject.accumulate("USER_NAME",  cfg_personlist.get(i).getUser_name());
				jsonObject.accumulate("EMPLOYEE_ID", cfg_personlist.get(i).getEmployee_id());
				jsonObject.accumulate("EMAILADDRESS", cfg_personlist.get(i).getEmailaddress());
				jsonObject.accumulate("STATE", cfg_personlist.get(i).getState());
				
				    
				   
			
	        }		
			
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}
