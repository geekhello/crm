package com.crm.web.action;

import com.crm.domain.SysUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonTest {

	public static void main(String[] args) {
		String[] arr = new String[10];
		arr[0] = "{\"name\":\"zhangwei\",\"age\":20,\"sex\":\"male\",\"hobbit\":\"{read,read}\"}";
		//arr[1] = "{name:lisi,age:10,sex:male,hobbit:{play,draw,football}}";
		/*JSONObject jo = new JSONObject();
		jo.put("name", "zhangsan");
		jo.put("age", 20);
		jo.put("hobbit", "read");
		JSONArray ja = new JSONArray();
		ja.add(jo);*/
		/*JSONArray fromObject = JSONArray.fromObject(arr);
		Object object = JSONObject.fromObject(fromObject.get(0)).get("hobbit");
		JSONObject jo = new JSONObject();
		jo.put("userId", 1234l);
		jo.put("userName", "zhangwei");
		jo.put("userCode", "z0001");
		SysUser user = (SysUser)JSONObject.toBean(jo, SysUser.class);
		System.out.println(user.toString());*/
		
		SysUser user = new SysUser();
		user.setUserName("zhangsan");
		user.setUserCode("z0001");
		user.setUserPassword("123456");
		user.setUserState("1");
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(new String[]{"userPassword","userState"});
		JSONObject fromObject = JSONObject.fromObject(user, jc);
		System.out.println(fromObject);
	}
}
