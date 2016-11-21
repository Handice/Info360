package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;
@Path("/Query_GroupInfo")
public class Query_GroupInfoServlet {
	/**
	 * 使用POST方法
	 * 依據輸入DBID有無查詢個人帳號資訊或全體帳號資訊
	 * @param DBID
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("dbid")
								int dbid) throws IOException {

		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		cfg_group.setDbid(dbid);
		jsonObject.put("status", Variable.POST_STATUS);
		
		try{
			MaintainService maintainService = new MaintainService();
			 List<CFG_group> cfg_grouplist = maintainService.query_Group(cfg_group);
	        if(dbid != 0){
	        	//撈取cfg_group_person關聯
	        	CFG_group_person cfg_group_person = new CFG_group_person();
	        	cfg_group_person.setGroup_dbid(cfg_grouplist.get(0).getDbid());
	        	List<CFG_group_person> cfg_person_grouplist = maintainService.query_Group_Person(cfg_group_person);
	        	
	        	JSONArray GroupPersonJsonArray = new JSONArray();
	        	JSONArray PersonJsonArray = new JSONArray();
		        for (int i = 0; i < cfg_person_grouplist.size(); i++) {
		        	JSONObject GroupPersonJsonObject = new JSONObject();
		        	GroupPersonJsonObject.put("person_dbid", cfg_person_grouplist.get(i).getPerson_dbid());
		        	GroupPersonJsonObject.put("group_dbid", cfg_person_grouplist.get(i).getGroup_dbid()); 
		        	
		        	GroupPersonJsonArray.put(GroupPersonJsonObject);
		        	
		        	//撈取cfg_person欄位
		        	CFG_person cfg_person = new CFG_person();
		        	cfg_person.setDbid((int)cfg_person_grouplist.get(i).getPerson_dbid());
				    List<CFG_person> cfg_personlist = maintainService.query_Person_DBID(cfg_person);
				    JSONObject PersonJsonObject = new JSONObject();
				    PersonJsonObject.put("dn", cfg_personlist.get(0).getDn());
		        	PersonJsonObject.put("dbid", cfg_personlist.get(0).getDbid());
		        	PersonJsonObject.put("createdatetime", cfg_personlist.get(0).getCreatedatetime());
		        	PersonJsonObject.put("account",    cfg_personlist.get(0).getAccount());
		        	PersonJsonObject.put("password", cfg_personlist.get(0).getPassword());
		        	PersonJsonObject.put("first_name", cfg_personlist.get(0).getFirst_name());
		        	PersonJsonObject.put("last_name",  cfg_personlist.get(0).getLast_name());
		        	PersonJsonObject.put("user_name",  cfg_personlist.get(0).getUser_name());
		        	PersonJsonObject.put("employee_id", cfg_personlist.get(0).getEmployee_id());
		        	PersonJsonObject.put("emailaddress", cfg_personlist.get(0).getEmailaddress());
		        	PersonJsonObject.put("state", cfg_personlist.get(0).getState()); 
		        	
		        	PersonJsonArray.put(PersonJsonObject);
		        }		
		        jsonObject.put("group_person", GroupPersonJsonArray);
		        jsonObject.put("person", PersonJsonArray);
	        }
			
	        JSONArray GroupJsonArray = new JSONArray();
	        for (int i = 0; i < cfg_grouplist.size(); i++) {
	        	JSONObject GroupJsonObject = new JSONObject();
	        	GroupJsonObject.accumulate("dbid", cfg_grouplist.get(i).getDbid());
			    GroupJsonObject.accumulate("name", cfg_grouplist.get(i).getName()); 
			    GroupJsonObject.accumulate("state", cfg_grouplist.get(i).getState());
	        	 
			    GroupJsonArray.put(GroupJsonObject);
	        }		
	        jsonObject.put("group", GroupJsonArray);
	        
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}
