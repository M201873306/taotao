package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemservice;
	//url:/item/list
	//method:get
	//参数：page,rows
	//返回值:json
	
	@RequestMapping(value="/item/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemservice.getItemList(page, rows);
		return result;
	}
}
