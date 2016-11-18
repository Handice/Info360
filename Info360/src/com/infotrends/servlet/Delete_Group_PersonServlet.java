package com.infotrends.servlet;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;

@Path("/Delete_Group_PersonInfo")
public class Delete_Group_PersonServlet {
	/**
	 * 使用POST方法
	 * 依據person_dpid刪除個人群組資訊
	 * @param PERSON_DBID
	 
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(@FormParam("PERSON_DBID") String p_dbid
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_group_person cfg_group_person = new CFG_group_person();
		jsonObject.put("Status", "POST Path");
	
		
		int deletecount=0;
		try{
			long person_dbid=Long.parseLong(p_dbid);
			cfg_group_person.setPerson_dbid(person_dbid);
			MaintainService maintainService = new MaintainService();
			deletecount =maintainService.delete_Group_PersonInfo(cfg_group_person); 
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

