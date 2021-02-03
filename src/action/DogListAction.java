package action;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogListService;
import vo.ActionForward;
import vo.Dog;

public class DogListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//강아지 리스트 하단에 오늘 본 강아지 목록을 표시하기 위해 선언
		ArrayList<String> todayImageList = new ArrayList<String>();
		//요청 시 선언된 쿠키정보를 가져온다.
		Cookie[] cookieArray = request.getCookies();
		
		//쿠키정보가 존재하면
		if(cookieArray != null) {
			
			//cookieArray[i].getName() : 쿠키명을 가져오는데 쿠키명이 today로 시작하면
			//오늘 본 강아지 목록에 추가처리를 한다.
			//cookieArray[i].getValue() : 쿠키 값
			for(int i=0;i<cookieArray.length;i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		DogListService dogListService = new DogListService();
		
		//강아지 전체 목록
		ArrayList<Dog> dogList = dogListService.getDogList();
		
		//클라이언트의 요청이 응답처리 될때까지 유효
		//강아지 전체 목록을 가지는 속성 선언
		request.setAttribute("dogList",dogList);
		//강아지 목록 중 오늘 본 강아지 목록을 속성으로 지정
		request.setAttribute("todayImageList",todayImageList);
		
		//강아지 전체 목록으로 이동
		ActionForward forward = new ActionForward("dogList.jsp",false);
		
		return forward;
		
	}

}