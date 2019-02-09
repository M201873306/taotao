package com.taotao.testpagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	@Test
	public void testhelper() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper tbItemMapper = context.getBean(TbItemMapper.class);
		PageHelper.startPage(1, 3);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		List<TbItem> list2 = tbItemMapper.selectByExample(example);
		System.out.println("1:" + list.size());
		System.out.println("2:" + list2.size());
		PageInfo<TbItem> info = new PageInfo<>(list);
		System.out.println("info:" + info.getTotal());
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getId() + ":title-->" +tbItem.getTitle());
		}
		
	}
}
