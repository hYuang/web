package com.huang.alpha.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.huang.alpha.enums.Result;
import com.huang.alpha.model.Response;
import com.huang.alpha.util.FileUtil;

import io.swagger.annotations.Api;

@Api("poject info")
@RestController
@RequestMapping("/info")
public class ProjectInfoController {
	private final String  info = "info.json";
	
	@RequestMapping(name="/porject"  , method= {RequestMethod.GET})
	@ResponseBody
	public Response getProjectInfo() {
		Response response = new Response();
		try {
			String fileInfo = FileUtil.getFileContent(info);
			JSON data = JSON.parseObject(fileInfo);
			response.setData(data);
			response.setMsg(Result.SUCCESS.getValue());
			response.setMsg_code(Result.SUCCESS_CODE.getValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setData(null);
			response.setMsg(Result.FAIL.getValue());
			response.setMsg_code(Result.FAIL_CODE.getValue());
		}
		return response;
		
	}
}