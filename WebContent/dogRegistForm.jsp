<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강아지 등록 폼</title>
<style>
	#registForm{
		width:600px;
		height:400px;
		border:3px solid blue;
		margin:auto;
	}
	
	h2{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:500px;
	}
	
	.td_left{
		width:130px;
		height:30px;
		background:yellow;
		text-align:center;
	}
	
	.td_right{
		width:200px;
		height:30px;
		background:green;
		text-align:left;
	}
	
	#commandCell1{
		text-align:left;
	}
	
	#commandCell2{
		text-align:right;
	}
	
</style>
</head>
<body>
	<section id="registForm">
		<header>
			<h2>개 정보 등록</h2>
		</header>
		<form name="writeForm" 
			  action="dogRegist.dog" 
			  method="post" enctype="multipart/form-data">
			  <table>
			  	<tr>
			  		<td colspan="2">
			  			<a href="dogList.dog">목록보기</a>
			  		</td>
			  	</tr>
			  	
			  	<tr>
			  		<td class="td_left">
			  			<label for="kind">품종</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="text" name="kind" id="kind" required="required"/>
			  		</td>
			  	</tr>
			  	<tr>
			  		<td class="td_left">
			  			<label for="nation">원산지</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="text" name="nation" id="nation" required="required"/>
			  		</td>
			  	</tr>			  	

			  	<tr>
			  		<td class="td_left">
			  			<label for="price">가격</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="text" name="price" id="price" required="required"/>
			  		</td>
			  	</tr>
			  				  	
			  	<tr>
			  		<td class="td_left">
			  			<label for="height">신장</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="text" name="height" id="height" required="required"/>
			  		</td>
			  	</tr>
			  	
			  	<tr>
			  		<td class="td_left">
			  			<label for="weight">체중</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="text" name="weight" id="weight" required="required"/>
			  		</td>
			  	</tr>
			  	
			  	<tr>
			  		<td class="td_left">
			  			<label for="content">글내용</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="text" name="content" id="content"/>
			  		</td>
			  	</tr>			  	
			  			
			  	<tr>
			  		<td class="td_left">
			  			<label for="image">상품이미지</label>
			  		</td>
			  		<td class="td_right">
			  			<input type="file" name="image" id="image"/>
			  		</td>
			  	</tr>				  				  	
			  	
				<tr>
					<td id="commandCell1"><br>
						<input type="submit" value="상품등록"/>
						<input type="reset" value="다시작성"/>
					</td>
					<td id="commandCell2"><br>
						<input type="button" value="상품목록보기"
							   onClick="window.location.href='dogList.dog'"/>
					</td>
				</tr>			  				  				  	
			  	
			  </table>
		</form>
	</section>
</body>
</html>