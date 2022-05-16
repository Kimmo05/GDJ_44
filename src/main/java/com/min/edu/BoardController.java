package com.min.edu;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	IBoardService iService;
	//TODO 005 MemberController.java 64번째 줄(004)에서 Redirect 로 요청한 페이지
		//TODO 012 페이징 처리되는 BoardList
			@RequestMapping(value = "/boardList.do",method = RequestMethod.GET)
			   public String boardList(HttpSession session ,/*@SessionAttribute("mem2") MemberVo mVo*/Model model) {
				  MemberVo mVo =(MemberVo) session.getAttribute("mem");
			      log.info("Board_Controller boardList");
			      log.info("Board_Controller 세션 확인 : {} ",mVo);
			      
//			      List<BoardVo> lists = iService.selectBoardAll(mVo);
//			      model.addAttribute("lists",lists);
			      
			      List<BoardVo> lists = null;
			      RowNumVo rowVo = null;
			      
			      if(session.getAttribute("row") == null) {
			         //처음에 BoardList를 요청했을 경우
			         rowVo = new RowNumVo();
			      }else {
			         //두번째 요청부터는 Session의 값을 사용
			         rowVo = (RowNumVo)session.getAttribute("row");
			      }
			      //각 사용자의 권한에 따라서 실행되는 SErvice를 분기
			      if(mVo.getAuth().equals("ROLE_USER")) {
			         //TODO 012페이징 BoardList User
			         rowVo.setTotal(iService.userBoardListTotal());
			         lists = iService.userBoardListRow(rowVo);
			      }else if(mVo.getAuth().equals("ROLE_ADMIN")){
			         //TODO 012페이징 BoardList Admin
			         rowVo.setTotal(iService.adminBoardListTotal());
			         lists = iService.adminBoardListRow(rowVo);
			      }
			      model.addAttribute("lists", lists);
			      model.addAttribute("row", rowVo);
			      
			      return "boardList";
			   }
			   
}
