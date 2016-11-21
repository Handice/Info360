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


@Path("/Delete_PersonInfo")
public class Delete_PersonInfoServlet {
	/**
	 * 使用POST方法
	 * 依據帳號與密碼皆吻合刪除個人資訊
	 * @param ACCOUNT
	 * @param PASSWORD
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(@FormParam("dbid") int dbid,
			@FormParam("password") String password
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", Variable.POST_STATUS);
		//cfg_person.setAccount(account);
		//cfg_person.setPassword(password);
		cfg_person.setDbid(dbid);
		
		try{
			MaintainService maintainService = new MaintainService();
			List<CFG_person> cfg_personlist = maintainService.query_Person_DBID(cfg_person);
			if(password.trim().equals(cfg_personlist.get(0).getPassword().trim())){
				cfg_person.setPassword(password);
				int deletepersoncount = maintainService.delete_PersonInfo(cfg_person);
				jsonObject.put("delete_personcount", deletepersoncount);
				CFG_group_person cfg_group_person = new CFG_group_person();
				cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
				int deletegrouppersoncount =maintainService.delete_Group_PersonInfo(cfg_group_person);
				jsonObject.put("delete_group_personcount", deletegrouppersoncount);
			}else{
				jsonObject.put("error", "wrong password");
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
