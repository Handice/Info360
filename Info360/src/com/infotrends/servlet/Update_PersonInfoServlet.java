package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Update_PersonInfo")
public class Update_PersonInfoServlet {
	/**
	 * 使用POST方法
	 * 依據帳號更新個人資訊
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
			@FormParam("password") String password,
			@FormParam("group_dbid") long group_dbid
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", Variable.POST_STATUS);
		cfg_person.setAccount(account);
		cfg_person.setFirst_name(first_name);
		cfg_person.setLast_name(last_name);
		cfg_person.setEmailaddress(emailaddress);;
	    cfg_person.setPassword(password);
		cfg_person.setUser_name(user_name);
		int updatecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			updatecount = maintainService.update_PersonInfo(cfg_person);
			jsonObject.put("updatecount", updatecount);
			if(group_dbid!=0){
				List<CFG_person> cfg_personlist = maintainService.query_Person_Account(cfg_person);
				CFG_group_person cfg_group_person = new CFG_group_person();
				cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
				cfg_group_person.setGroup_dbid(group_dbid);
				int grouppersoncount = maintainService.update_Group_PersonInfo(cfg_group_person);
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
