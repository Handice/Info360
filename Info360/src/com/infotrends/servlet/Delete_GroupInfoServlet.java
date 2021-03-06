package com.infotrends.servlet;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;


@Path("/Delete_GroupInfo")
public class Delete_GroupInfoServlet {
	/**
	 * 使用POST方法
	 * 刪除群組資訊
	 * @param DBID
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(@FormParam("dbid") int dbid
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group= new CFG_group();
		jsonObject.put("Status", Variable.POST_STATUS);
		cfg_group.setDbid(dbid);
		
		try{
			MaintainService maintainService = new MaintainService();
			int deletegroupcount = maintainService.delete_GroupInfo(cfg_group);
			jsonObject.put("delete_groupcount", deletegroupcount);
			CFG_group_person cfg_group_person = new CFG_group_person();
			cfg_group_person.setGroup_dbid(dbid);
			int deletegrouppersoncount =maintainService.delete_Group_PersonInfo(cfg_group_person);
			jsonObject.put("delete_group_personcount", deletegrouppersoncount);
			
			
			
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
