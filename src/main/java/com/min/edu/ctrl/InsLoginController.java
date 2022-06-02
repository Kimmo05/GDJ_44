package com.min.edu.ctrl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping(value = "/ins/*")
public class InsLoginController {

	@Autowired
	IMemberService service;

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model,Authentication user) {
		log.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		System.out.println("SecurityContextHolder 에 등록된 정보 확인");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( auth != null) {
			
			System.out.println("Authentication getAuthorities: " + auth.getAuthorities().toString());
			System.out.println("Authentication getPrincipal: " + auth.getPrincipal());
			System.out.println("Authentication getName: " +auth.getName());
			System.out.println("Authentication getCredentials: " + auth.getCredentials());
			System.out.println("Authentication getDetails: " + auth.getDetails());
			System.out.println("Authentication isAuthenticated: " + auth.isAuthenticated());
			
		}
		return "main";
	}
	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {
		System.out.println("사용자로 로그인");
//		UserDetails userdto = (UserDetails) user.getPrincipal();
//		System.out.println("---------------"+userdto);
//		model.addAttribute("user", userdto.toString());
		  
		if (error != null) {
			model.addAttribute("msg", "로그인 에러");
		}

		if (logout != null) {
			model.addAttribute("msg", "로그아웃 성공");
		}
		
		if(user != null) {
			return "redirect:/ins/result.do";
		}
		System.out.println("로그인 페이지로 이동 합시다");
		return "loginForm";
	}

	@RequestMapping(value = "/loginCheckTraMap.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> loginCheckMap(@RequestParam Map<String, Object> map){
		Map<String, String> rMap = new HashMap<String, String>();
		log.info("********* Welcome Member_Controller loginCheckMap! : {} *********", map);
		MemberVo mVo = service.loginTra(map);
		log.info("********* Welcome! Member_Controller loginCheckMap 로그인 정보 : {} *********", mVo);
		if(mVo == null) {
			rMap.put("isc", "실패");
		}else {
			rMap.put("isc", "성공");
		}
		return rMap;
	}

	//로그인 완료 후 메인 페이지로 가는 매핑
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public String maingo(Authentication user, Model model , HttpSession session) {
		
		System.out.println("인증후  생성된 세션 확인");
		Enumeration<?> session_attributes = session.getAttributeNames();
		while(session_attributes.hasMoreElements()) {
	        String session_name  = session_attributes.nextElement().toString();
	        String session_value = session.getAttribute(session_name).toString();
	        System.out.println("세션키: "+ session_name);
	        System.out.println("세션값: " +session_value);
		}
		
		System.out.println("SecurityContextHolder 에 등록된 정보 확인");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( auth != null) {
			
			System.out.println("Authentication getAuthorities: " + auth.getAuthorities().toString());
			System.out.println("Authentication getPrincipal: " + auth.getPrincipal());
			System.out.println("Authentication getName: " +auth.getName());
			System.out.println("Authentication getCredentials: " + auth.getCredentials());
			System.out.println("Authentication getDetails: " + auth.getDetails());
			System.out.println("Authentication isAuthenticated: " + auth.isAuthenticated());
			
		}
	
//		UserDetails userdto = (UserDetails) auth.getDetails();
//		model.addAttribute("user", userdto.toString());
//		System.out.println(":::::::::::::::::::::::: " +auth.getPrincipal());
//		System.out.println("비밀번호 : " + userdto.getPassword());
		return "main";
	}


	//회원가입으로 가는 매핑
	@RequestMapping(value = "/singUpgo.do", method = RequestMethod.GET)
	public String SignUpgo() {
		return "register";
	}


	// 회원가입 성공 매핑
	@RequestMapping(value = "/singUpSc.do", method = RequestMethod.POST)
	public String maingo(@RequestParam Map<String, Object> map, Model model) {
		System.out.println("회원가입 정보"+map);
		service.traSignUp(map);
		return "loginForm";
	}
	
	//관리자 페이지
	@RequestMapping(value = "/admin/adminPage.do", method = RequestMethod.GET)
	public String adminPasge(Model model) {
		System.out.println("관리자 페이지");
		System.out.println();
		return "adminPage";
	}
	
	@RequestMapping(value = "/AuthError.do", method = RequestMethod.GET)
	public String AuthError(Model model) {
		return "AuthError";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/duplicateLogin.do", method = RequestMethod.GET)
	public String duplicateLogin() {
		return "duplicateLogin";
	}
	


}
