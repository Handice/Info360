package com.infotrends.servlet;

/**
 * @author Tim
 */

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;

@Path("/Insert_PersonInfo")
public class Insert_PersonInfoServlet {
	/**
	 * 雿輻POST�寞�Insert�犖鞈�
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
	public Response postFromPath(@FormParam("account") String account,
			@FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("user_name") String username,
			@FormParam("emailaddress") String emailaddress,
			@FormParam("password") String password,
			@FormParam("employee_id") String employee_id,
			@FormParam("group_dbid") long group_dbid
//			@FormParam("group_name") String group_name,
//			@FormParam("group_state") int group_state
			) throws IOException {
		
		
		account = account.trim();
		first_name = first_name.trim();
		last_name = last_name.trim();
		username = username.trim();
		emailaddress = emailaddress.trim();
		password = password.trim();
		employee_id = employee_id.trim();
		
		
		
		
		
		
		
		
		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("status", Variable.POST_STATUS);
		cfg_person.setAccount(account);
		cfg_person.setFirst_name(first_name);
		cfg_person.setLast_name(last_name);
		cfg_person.setEmailaddress(emailaddress);;
	    cfg_person.setPassword(password);
		cfg_person.setUser_name(username);
		cfg_person.setEmployee_id(employee_id);
		try{
			MaintainService maintainService = new MaintainService();
			int personcount = maintainService.insert_PersonInfo(cfg_person);
			jsonObject.put("person_insertcount", personcount);
			if(group_dbid!=0){
				
				List<CFG_person> cfg_personlist = maintainService.query_Person_Account(cfg_person);
				CFG_group_person cfg_group_person = new CFG_group_person();
				cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
				cfg_group_person.setGroup_dbid(group_dbid);
				int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
				jsonObject.put("group_person_insertcount", grouppersoncount);
				/*
				CFG_group cfg_group = new CFG_group();
				cfg_group.setDbid(group_dbid);
				cfg_group.setName(group_name);
				cfg_group.setState(group_state);
				int groupcount = maintainService.insert_GroupInfo(cfg_group);
				jsonObject.put("group_insertcount", groupcount);
				*/
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