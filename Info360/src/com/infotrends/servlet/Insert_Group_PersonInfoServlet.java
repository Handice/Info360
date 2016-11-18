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


@Path("/Insert_Group_PersonInfo")
public class Insert_Group_PersonInfoServlet {
	/**
	 * 使用POST方法Insert個人資料
	 * 
	 * @param GROUP_DBID
	 * @param PERSON_DBID
	 
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("GROUP_DBID") String gdbid,
			@FormParam("PERSON_DBID") String pdpid) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_group_person cfg_group_person = new CFG_group_person();
		jsonObject.put("Status", "POST Path");
		
		try{long group_dbid=Long.parseLong(gdbid);
			long person_dbid=Long.parseLong(pdpid);
			cfg_group_person.setGroup_dbid(group_dbid);
			cfg_group_person.setPerson_dbid(person_dbid);
			MaintainService maintainService = new MaintainService();
			int count = maintainService.insert_Person_GroupInfo(cfg_group_person);
			
			jsonObject.put("insertcount", count);
			
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}

