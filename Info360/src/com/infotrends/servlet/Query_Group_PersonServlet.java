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
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;

@Path("/Query_Group_PersonInfo")
public class Query_Group_PersonServlet {
	/**
	 * 使用POST方法
	 * 依據輸入
	 * @param person_dpid
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("GROUP_DBID")
	String g_dpid,
	@FormParam("PERSON_DBID")
	String p_dpid) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_group_person cfg_group_person = new CFG_group_person();
		
		jsonObject.put("Status", "POST Path");
		try{
			if (g_dpid.trim()!= "" && g_dpid != null && g_dpid.length()!=0) {
				
				long group_dpid = Long.parseLong(g_dpid);
				cfg_group_person.setGroup_dpid(group_dpid);
                MaintainService maintainService = new MaintainService();
				List<CFG_group_person> cfg_group_personlist = maintainService
						.query_Group_Person(cfg_group_person);
                for (int i = 0; i < cfg_group_personlist.size(); i++) {
					jsonObject.accumulate("GROUP_DBID", cfg_group_personlist
							.get(i).getGroup_dpid());
					jsonObject.accumulate("PERSON_DBID", cfg_group_personlist
							.get(i).getPerson_dpid());
				}
			}    
                if (p_dpid.trim()!= "" && p_dpid != null && p_dpid.length()!=0) {
    				
    				long person_dpid = Long.parseLong(p_dpid);
    				cfg_group_person.setPerson_dpid(person_dpid);
                    MaintainService maintainService = new MaintainService();
    				List<CFG_group_person> cfg_group_personlist = maintainService
    						.query_Group_Person(cfg_group_person);
                    for (int i = 0; i < cfg_group_personlist.size(); i++) {
    					jsonObject.accumulate("GROUP_DBID", cfg_group_personlist
    							.get(i).getGroup_dpid());
    					jsonObject.accumulate("PERSON_DBID", cfg_group_personlist
    							.get(i).getPerson_dpid());
    				}
			}if(g_dpid.length()==0 && p_dpid.length()==0){
				jsonObject.accumulate("Msg", "DPID請填入數字");
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


