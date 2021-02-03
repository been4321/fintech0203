package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import dao.DogDAO;
import vo.Cart;
import vo.Dog;

public class DogCartAddService {
	
	//특정 강아지에 대한 정보를 가져온다.
	public Dog getCartDog(int id) {
		
		Connection con = getConnection();
		
		DogDAO dogDAO = DogDAO.getInstance();
		
		dogDAO.setConnection(con);
		
		Dog dog = dogDAO.selectDog(id);
		
		close(con);
		
		return dog;
	}
	
	//장바구니에 추가
	public void addCart(HttpServletRequest request,Dog cartDog) {
		//클라이언트의 요청 세션 영역 객체를 가져온다.
		HttpSession session = request.getSession();
		
		//cartList 세션 속성 값을 가져온다.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		//장바구니가 비어있는 경우 cartList 세션 속성 선언
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		
		for(int i=0;i<cartList.size();i++) {
			
			//만약 장바구니에 있는 동일한 품종을 선택한 경우 구매수량만 1증가시키고 종료
			if(cartDog.getKind().equals(cartList.get(i).getKind())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty() + 1);
				break;
			}
		}
		
		//장바구니에 처음으로 담긴 품종이면
		if(isNewCart) {
			
			//세션 ArrayList에 추가하기 위해서 Cart 인스턴스 생성
			Cart cart = new Cart();
			
			cart.setImage(cartDog.getImage());
			cart.setKind(cartDog.getKind());
			cart.setPrice(cartDog.getPrice());
			cart.setQty(1);
			
			//ArrayList 구조인 cartList에 추가
			cartList.add(cart);
		}
		
	}
}
