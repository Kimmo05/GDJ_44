package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("mem")
public class MemberController {
	
	@Autowired
	private IMemberService iService;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "main";
	}
	
	//로그인 화면으로 이동
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String LoginForm() {
    	log.info("********* Member_Controller Welcome LoginForm! 로그인 화면으로 이동합니다. *********");
		return "loginForm";
	}
	
	//TODO 001 로그인 화면에서 비동기식 로그인 정보 확인 Map반환
	@RequestMapping(value = "/loginCheckMap.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> loginCheckMap(@RequestParam Map<String, Object> map){
		Map<String, String> rMap = new HashMap<String, String>();
		log.info("********* Welcome Member_Controller loginCheckMap! : {} *********", map);
		MemberVo mVo = iService.loginMember(map);
		log.info("********* Welcome! Member_Controller loginCheckMap 로그인 정보 : {} *********", mVo);
		if(mVo == null) {
			rMap.put("isc", "실패");
		}else {
			rMap.put("isc", "성공");
		}
		return rMap;
	}
	
	//TODO 002 로그인 정보가 Ajax로 확인된 후 @SessionAttribute 에 담고 첫 페이지가 되는 곳으로 이동
	@PostMapping(value = "/login.do")
	public String login(@RequestParam Map<String, Object> map, Model model) {
		log.info("********* Welcome! Member_Controller login 로그인 정보 : {} *********", map);
		MemberVo mVo = iService.loginMember(map);
		model.addAttribute("mem", mVo);
//		return "boardList";
		return "redirect:/main.do";
	}
	
	//drag and drop 화면으로 이동
	@RequestMapping(value = "/dragAndDrop.do", method = RequestMethod.GET)
	public String dragAndDrop() {
		log.info("********* Welcome dragAndDrop! dragAndDrop 화면으로 이동합니다. *********");
		return "dragAndDrop";
	}
	@RequestMapping(value = "/dragAndDrop1.do", method = RequestMethod.GET)
	public String dragAndDrop1() {
		log.info("Welcome dragAndDrop1! dragAndDrop1 화면으로 이동합니다.");
		return "dragAndDrop1";
	}
	@RequestMapping(value = "/dragAndDrop2.do", method = RequestMethod.GET)
	public String dragAndDrop2() {
		log.info("Welcome dragAndDrop2! dragAndDrop2 화면으로 이동합니다.");
		return "dragAndDrop2";
	}
	@RequestMapping(value = "/dragAndDrop3.do", method = RequestMethod.GET)
	public String dragAndDrop3() {
		log.info("Welcome dragAndDrop3! dragAndDrop3 화면으로 이동합니다.");
		return "dragAndDrop3";
	}
}
