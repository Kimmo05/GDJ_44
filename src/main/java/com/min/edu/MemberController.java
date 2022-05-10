package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("mem")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private IMemberService iService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String LoginForm() {
		logger.info("Welcome LoginForm! 로그인 화면입니다.");
		
		
		return "loginForm";
	}
	
	
	//TODO 003 로그인 화면에서 비동기식 로그인 정보 확인 : Map 반환
		// Jackson databind 이 자동으로 Map 의 데이터를 JSON 의 형태로 변경하여 전송함
		@RequestMapping(value = "/loginCheckMap.do", method = RequestMethod.POST)
		public @ResponseBody Map<String, String> loginCheckMap(@RequestParam Map<String, Object> map){
			Map<String, String> rMap = new HashMap<String, String>();
			logger.info("Welcome! Member_Controller loginCheckMap : {}", map);
			MemberVo mVo = iService.loginMember(map);
			logger.info("Welcome! Member_Controller loginCheckMap 로그인 정보 : {}", mVo);
			if(mVo == null) {
				rMap.put("isc", "실패");
			}else {
				rMap.put("isc", "성공");
			}
			
			return rMap;
		}
		
		//TODO 004 로그인 정보가 Ajax로 확인된 후 @SessionAttribute 에 담고 첫 페이지가 되는 곳으로 이동
		@PostMapping(value = "/login.do")
		public String login(@RequestParam Map<String, Object> map, Model model) {
			logger.info("Welcome! Member_Controller login 로그인 정보 : {}", map);
			MemberVo mVo = iService.loginMember(map);
			model.addAttribute("mem", mVo);
			
//			return "boardList";
			return "redirect:/main.do";
		}
		
		//TODO 006 로그아웃
		@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
		public String logout( SessionStatus sessionStatus){
			logger.info("Welcome! Member_Controller login 로그아웃 전 : {}" );
			
			sessionStatus.setComplete();
			logger.info("Welcome! Member_Controller login 로그아웃 후 : {}");
			return "redirect:/loginForm.do";
		}	
	
}
