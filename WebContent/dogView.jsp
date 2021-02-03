<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ page import="vo.Dog" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강아지정보 상세보기</title>
<style>
	#listForm{
		width:800px;
		border:3px solid green;
		margin:auto;
	}
	
	h2{
		text-align:center;
	}
	
	img{
		width:250px;
		height:250px;
		border:none;
	}
	
	#content_main{
		height:300px;
	}
	
	#content_left{
		width:400px;
		float:left;
	}
	
	#content_right{
		width:380px;
		float:left;
	}
	
	#commandList1{
		text-align:left;
	}
	
	#commandList2{
		text-align:right;
	}
	
	#desc{
		height:150px;
		background:violet;
	}
	
</style>
</head>
<body>
	<section id="listForm">
		<h2>${dog.kind}의 상세정보</h2>
		<section id="content_main">
			<section id="content_left">
				<img src="resources/images/${dog.image}"/>
			</section>
			<section id="content_right">
				<b>품종 : </b>${dog.kind}<br><br>
				<b>가격 : </b>
						<fmt:formatNumber type="number" maxFractionDigits="3"
										value="${dog.price}"/><br><br>
				<b>신장 : </b>${dog.height}<br><br>
				<b>체중 : </b>${dog.weight}<br><br>
				<b>원산지 : </b>${dog.country}<br><br>
				<b>내용 : </b>
				<p id="desc">
				${dog.content}<br>
				</p>	
			</section>
		</section>
		<div style="clear:both">
			<nav id="commandList1">
				<a href="dogList.dog">쇼핑계속하기</a></nav>
			<nav id="commandList2">	
				<a href="dogCartAdd.dog?id=${dog.id}">장바구니에 담기</a>
			</nav>			
		</div>
	</section>
	
</body>
</html>