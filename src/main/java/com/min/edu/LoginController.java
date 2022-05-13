package com.min.edu;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.min.edu.oauth.NaverLoginBO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
	this.naverLoginBO = naverLoginBO;
	}
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("result", apiResult);
		return "main";
	}
	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/loginForm.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
	/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
	String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
	//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
	System.out.println("네이버:" + naverAuthUrl);
	//네이버
	model.addAttribute("url", naverAuthUrl);
	return "loginForm";
	}
	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
throws IOException, ParseException {
		System.out.println("---------네이버 로그인 callback -----------");
	OAuth2AccessToken oauthToken;
	oauthToken = naverLoginBO.getAccessToken(session, code, state);
	//1. 로그인 사용자 정보를 읽어온다.
	apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
	System.out.println("apiResult: "+apiResult);
	/** apiResult json 구조
	{"resultcode":"00",
	"message":"success",
	"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
	**/
	//2. String형식인 apiResult를 json형태로 바꿈
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(apiResult);
	JSONObject jsonObj = (JSONObject) obj;
	//3. 데이터 파싱
	//Top레벨 단계 _response 파싱
	JSONObject response_obj = (JSONObject)jsonObj.get("response");
	System.out.println("reponse_obj"+response_obj);
	//response의 nickname값 파싱
	String name = JSONObject.toJSONString(response_obj);
	System.out.println("파싱한값"+name);
	//4.파싱 닉네임 세션으로 저장
	session.setAttribute("sessionId",response_obj); //세션 생성
	System.out.println(session.getAttribute(name));
	model.addAttribute("result", apiResult);
	return "redirect:main.do";
	}
	//로그아웃
	@RequestMapping(value = "/logout.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session)throws IOException {
	System.out.println("여기는 logout");
	session.invalidate();
	return "redirect:main.do";
	}

}
