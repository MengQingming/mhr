<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<script type="text/javascript" src="${ctx}/static/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.form.min.js"></script>

<script type="text/javascript">

	/** 登录 */
	function login(){
		var account = $('#accountId').val();
		var password = $('#passwordId').val();
		$.ajax({  
			type:'post',      
			url:'${ctx}/service/rest/app/user/login',  
			data:{
				'account':account,
				'password':password
			},  
			cache:false,  
			dataType:'json',  
			success:function(data){
				if(data!=null){
					$('#tokenId').val(data.token);
				}
				callback(data);
			}  
		});
	}
	
	function loginValidate(){
		var userTokenVal = $('#userTokenId').val();
		$.ajax({  
			type:'post',      
			url:'${ctx}/service/rest/app/user/query_login_user',  
			data:{
				'token':userTokenVal
			},  
			cache:false,  
			dataType:'json',  
			success:function(data){
				$('#validateText').text(JSON.stringify(data));
				callback(data);
			}  
		});
	}
	
	function callback(data){
		console.info(data)
	}
	
	$(function(){
        $("#feedbackForm").ajaxForm({
            //定义返回JSON数据，还包括xml和script格式
            dataType:'json',
            beforeSend: function() {
                //表单提交前做表单验证
            },
            success: function(data) {
                //提交成功后调用
                alert(JSON.stringify(data));
            }
        });
        
    });
	
	function showUrlImg(){
		var urlPath = $('#urlPathId').val();
		var imgSrc = '${ctx}/service/app/proxy/show_url_file?urlPath='+urlPath;
		$('#showUrlImgId').attr('src', imgSrc);
		$("#showUrlImgId").css('display','block');
	}
	
</script>
<body>
<div>
	<span style="font-size: 20px;">登录操作</span>
	<table>
		<tr>
			<td style="width:60px;">用户名</td>
			<td><input id="accountId" name="account" type="text" value="00003991" style="width:250px"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input id="passwordId" name="password" type="text" value="password" style="width:250px"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="登录" onclick="login();"/></td>
		</tr>
		<tr>
			<td>Token</td>
			<td><input id="tokenId" name="token" type="text" value="" style="width:250px"/></td>
		</tr>
	</table>
</div>
<br/><br/>

<div>
	<span style="font-size: 20px;">登录验证</span>
	<table>
		<tr>
			<td style="width:60px;">Token</td>
			<td><input id="userTokenId" name="token" type="text" value="" style="width:250px"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="验证登录" onclick="loginValidate();"/></td>
		</tr>
		<tr>
			<td>Result:</td>
			<td id="validateText"></td>
		</tr>
	</table>
</div>

<br/><br/>

<div>
	<span style="font-size: 20px;">文件上传</span>
	<form id="feedbackForm" action="${ctx}/service/app/user/sub_feedback" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td style="width:80px;">问题意见:</td>
			<td><textarea rows="5" cols="46" name="problem">很好，无意见</textarea></td>
		</tr>
		<tr>
			<td>图片多选:</td>
			<td><input type="file" name="p1" multiple="multiple"/></td>
		</tr>
		<tr>
			<td>联系方式:</td>
			<td><input type="text" name="contactWay" value="13565467655"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="上传" /></td>
		</tr>
	</table>
	</form>
</div>

<br/><br/>

<div>
	<span style="font-size: 20px;">显示内网图片</span>
	<table>
		<tr>
			<td style="width:80px;">内网地址:</td>
			<td><input type="text" name="urlPath" id="urlPathId" value="https://www.baidu.com/img/bd_logo1.png" style="width:350px"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" onclick="showUrlImg();" value="显示图片"/></td>
		</tr>
		<tr>
			<td colspan="2"><img id="showUrlImgId" src="" style="display: none"></td>
		</tr>
	</table>
</div>

<br/><br/>

<div>
	<span style="font-size: 20px;">内网文件下载</span>
	<form id="downloadUrlForm" action="${ctx}/service/app/proxy/download_url_file" method="post" >
	<table>
		<tr>
			<td style="width:80px;">内网地址:</td>
			<td><input type="text" name="urlPath" id="downloadUrlPathId" value="https://www.baidu.com/img/bd_logo1.png" style="width:350px"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="下传" /></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>