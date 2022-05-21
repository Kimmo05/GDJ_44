package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private IBoardService iService;
		
	//1) 게시글 전체조회
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(MemberVo mVo, Model model) {
		log.info("********* Welcome Board_Controller boardList! BoardController 전체조회 boardList *********");
		
		List<BoardVo> lists = iService.selectBoardAll(mVo);
//		for (BoardVo vo : lists) {			
//		}
		model.addAttribute("lists",lists);
		return "boardList";
	}
	
	//2) 게시글 상세조회
	@RequestMapping(value = "/detailBoard.do", method = RequestMethod.GET)
	public String selectBoardDetail(@RequestParam("seq") String id, Model model, String seq) {
		log.info("********* Welcome Board_Controller selectBoardDetail! BoardController 상세조회 getOneBoard *********");
		BoardVo vo = iService.selectBoardDetail(seq);
		model.addAttribute("vo", vo);
		return "detailBoard";
	}
	
	//3-1) 게시글 새글 등록 화면으로 이동
	@RequestMapping(value = "/boardWriteForm.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		log.info("********* Welcome Board_Controller boardWrite! 게시글 새글 등록 화면으로 이동합니다. *********");
//		return "boardWrite";
		return "register";
	}
   // 3-2) 게시글 새글 등록
//	 @RequestMapping(value = "/boardWrite.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView insertBoardRoot(@RequestParam Map<String, Object> map, @SessionAttribute("mem") MemberVo mVo, HttpServletRequest request,
//																		HttpServletResponse response, HttpSession httpSession) throws Exception {
//		iService.insertBoardRoot(map, request);
//		log.info("********* Welcome insertBoardRoot! 게시글 새글 등록 화면으로 이동합니다. *********");
//       log.debug("BoardController 새글 입력 insertBoardRoot", map);
//      
//       return "redirect:/boardList.do";
//	}
	
//    @RequestMapping(value = "/boardWrite.do", method = RequestMethod.POST)
//    public String insertBoardRoot(@RequestParam Map<String,Object> map,@SessionAttribute("mem") MemberVo mVo, HttpServletResponse response,
//    														HttpSession session, FileVo fileVo, Model model, BindingResult result) throws Exception {
//    	
//    	PrintWriter out = response.getWriter();
//    	map.put("id", mVo.getId());
//       log.info("BoardController 새글 입력 insertBoardRoot", map);
//       int n = iService.insertBoardRoot(map);
//       if(n>0) {
//          session.removeAttribute("row");
//          out.println("<script>alert('성공적으로 입력되었습니다'); location.href='./boardList.do'</script>;");
//       }else {
//    	  out.println("<script>alert('처리가 실패하였습니다'); location.href='./logout.do'</script>;");
//    	  out.flush();
//       }
//       return "redirect:/boardList.do";
//    }
	
	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.POST)
	public String write(BoardVo bVo, MultipartHttpServletRequest mpRequest) throws Exception {
		log.info("********* Welcome write! 글작성+첨부파일입니다. *********");
		iService.write(bVo, mpRequest);
		
		return "redirect:/boardList.do";
	}
  
    @RequestMapping(value = "/logout.do" , method = RequestMethod.GET)
    public String logout(HttpSession session) {
    	log.info("********* Welcome logout! 로그아웃합니다. *********");
    	session.invalidate();
    	return "redirect:/main.do";
    }


}
