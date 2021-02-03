package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartRemoveService {

	//kindArray : 장바구니에서 삭제하려고 선택한 춤종을 가지는 배열
	public void cartRemove(HttpServletRequest request,String[] kindArray) {
		
		HttpSession session = request.getSession();
		
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		//삭제하려는 품종을 반복하면서 장바구니에 있는 항목을 찾아서 삭제처리
		for(int i=0;i<kindArray.length;i++) {
			for(int j=0;j<cartList.size();j++) {
				
				if(cartList.get(j).getKind().equals(kindArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}
}
