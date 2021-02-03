package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartRemoveService;
import vo.ActionForward;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		//장바구니에서 삭제처리하려는 항목 앞에 체크박스를 체크하여 삭제버튼을 클릭하면
		//장바구니에서 삭제처리
		//삭제하기 위해서 클릭한 강아지 정보를 배열에 대입
		String[] kindArray = request.getParameterValues("remove");
		
		DogCartRemoveService dogCartRemoveService = new DogCartRemoveService();
		dogCartRemoveService.cartRemove(request,kindArray);
		
		//삭제처리후 장바구니 리스트로 라다이렉트 처리
		ActionForward forward = new ActionForward("dogCartList.dog",true);
		
		return forward;
		
	}

}
