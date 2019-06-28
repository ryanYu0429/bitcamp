package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {

	// Cookie 데이터를 Map에 저장해서 관리
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	// 생성자 : 초기화ㅓ -> request 객체에서 Cookie[] 배열을 받아서 cookieMap 에 저장하고 싶어
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		// 있는지 없는지 확인을 하고 있다면 map에 배열을 순차적으로 넣어준다.
		// 있는지 없는지~~~
		if (cookies != null && cookies.length > 0) {
			// 반복처리 : Cookie 객체를 Map에 저장
			for (int i = 0; i < cookies.length; i++) {
				// Map에 저장~
				Cookie c = cookies[i];

				cookieMap.put(c.getName(), c);

			}

		}

	}

	// 쿠키 생성하는 메소드를 Static으로 처리
	// 반환되는 Cookie타입 쿠키생성하는 메소드와 필요한 변수
	// 쿠키 생성하는 메소드 : 이름, 데이터 값
	public static Cookie createCookie(String name, String value) {
		Cookie c = new Cookie(name, value);
		return c;
	}

	// 오버로딩 : 이름, 데이터 값, 유효시간
	public static Cookie createCookie(String name, String value, int macAge) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(macAge);
		return c;
	}

	// 오버로딩 : 이름, 데이터 값, 유효시간, 경로
	public static Cookie createCookie(String name, String value, int macAge, String path) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(macAge);
		c.setPath(path);
		return c;
	}

	// 오버로딩 : 이름, 데이터 값, 유효시간, 경로, 도메인
	public static Cookie createCookie(String name, String value, int macAge, String path, String domain) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(macAge);
		c.setPath(path);
		c.setDomain(domain);
		return c;
	}
	
	// 쿠키 정보를 반환하는 메소드 (map에서 가져올꺼야)
	// static 처리하지 않는 이유 : map에 있는데이터는 instance데이터니까 instance method를 가져와야함
	// 쿠키 타입
	public Cookie getCookie(String name) {
		// key인 name의 값을 반환
		return cookieMap.get(name);
	}
	
	// 쿠키의 데이터를 반환하는 메소드
	// 쿠키 데이터는 String타입
	public String getValue(String name) {
		Cookie c = cookieMap.get(name);
		
		//null이면 return c.getValue();이 문제가됨
		if (c==null) {
			return null;
		}
		
		// return의 기능 : 메소드 종료 / 데이터 반환
		return c.getValue();
	}
	
	 public boolean exists(String name) {
		 // 존재하고 있을때 : true;
		 // 존재하지 않을때 : false;
		 return cookieMap.get(name) != null;
	 }

}
