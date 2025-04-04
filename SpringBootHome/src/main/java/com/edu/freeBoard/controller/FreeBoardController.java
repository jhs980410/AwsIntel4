package com.edu.freeBoard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.edu.freeBoard.domain.FreeBoardVo;
import com.edu.freeBoard.service.FreeBoardService;
import com.edu.util.Paging;



@RestController
@RequestMapping("/freeBoard")
public class FreeBoardController {

	private Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	private final String logTitleMsg = "==자유게시판 Control==";
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView freeBoardList(@RequestParam(defaultValue = "1") int curPage) {
		logger.info(logTitleMsg);
		logger.info("RequestMethod.GET freeBoardList/ curPage: {}", curPage);
		
		int totalCount = freeBoardService.freeBoardSelectTotalCount();
		
		Paging pagingVo = new Paging(totalCount, curPage);
		
		int start = pagingVo.getPageBegin();
		int end = pagingVo.getPageEnd();
		
		List<FreeBoardVo> freeBoardList = 
			freeBoardService.freeBoardSelectList(start, end);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("pagingVo", pagingVo);
		
		ModelAndView mav = new ModelAndView("freeBoard/freeBoardListView");
		mav.addObject("freeBoardList", freeBoardList);
		mav.addObject("pagingMap", pagingMap);
		
		return mav;
	}
	
}
