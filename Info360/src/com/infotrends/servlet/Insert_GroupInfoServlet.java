package com.infotrends.servlet;

/**
 * @author Lin
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
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;

@Path("/Insert_GroupInfo")
public class Insert_GroupInfoServlet {
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
	public Response postFromPath(
			@FormParam("name") String name,
			@FormParam("state") int state,
			@FormParam("person_dbid") long person_dbid
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		cfg_group.setName(name);
		cfg_group.setState(state);
		try{
			MaintainService maintainService = new MaintainService();
			int groupcount = maintainService.insert_GroupInfo(cfg_group);
			jsonObject.put("group_insertcount", groupcount);
			if(person_dbid!=0){
				List<CFG_group> cfg_grouplist = maintainService.query_Group_name(cfg_group);
				CFG_group_person cfg_group_person = new CFG_group_person();
				cfg_group_person.setGroup_dbid(cfg_grouplist.get(0).getDbid());
				cfg_group_person.setPerson_dbid(person_dbid);
				int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
				jsonObject.put("group_person_insertcount", grouppersoncount);
				
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