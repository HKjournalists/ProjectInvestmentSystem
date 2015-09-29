'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('sbAdminApp')
  .controller('loginController', function($scope) {
	  $scope.userLogin=function($scope,$http){
	    var userEmail = $('#userLoginEmail').val();
		var userPwd = $('#userLoginPwd').val();
		
		var loginErrorMsg = $('#user-login-error-msg');
		if(userEmail == null) {
			$("#userLoginEmailError").show();
			return;
		} else {
			$("#userLoginEmailError").hide();
		}
		if(userPwd == null || userPwd == '') {
			$("#userLoginPwdError").show();
			return;
		} else {
			$("#userLoginPwdError").hide();
		}
		loginErrorMsg.html("<p style='color: white;'>正在向服务器提交您的信息，请稍后......</p>");
		loginErrorMsg.show();
		$.ajax({
			url : '../checkUserLogin',
			method : "POST",
			data : {
				userId : userEmail,
				userPwd : userPwd
			},
			cache : false,
			success : function(data) {
				if(data.error_code == '-1') {
					loginErrorMsg.html("<p style='color: #FD7A50;'>用户名或密码不能为空！</p>");
				} else if(data.error_code == '0') {
					var userType = parseInt(data.user_type);
					var path = '../views/index.html#/dashboard/home';
					loginErrorMsg.html("<p style='color: #419088;'>登陆成功！3秒后系统将自动转向后台页面......</p>");
					setTimeout(function(){loginErrorMsg.hide();window.location=path;}, 3000);
				} else if(data.error_code == '4') {
					$scope.companyUserEmail = userEmail;
					$scope.companyUserPwd = userPwd;
					loginErrorMsg.html("<p style='color: #419088;'>登陆成功，您还没有完成信息录入，5秒后系统将自动转向信息录入页面......</p>");
					setTimeout(function(){$location.path('/signup-steps');$scope.$apply();loginErrorMsg.hide();}, 3000);
				} else if(data.error_code == '100') {
					loginErrorMsg.html("<p style='color: #FD7A50;'>您注册的帐号正在审核中,请稍候重试!</p>");
				} else if(data.error_code == '102') {
					loginErrorMsg.html("<p style='color: #FD7A50;'>您注册的帐号没有通过审核,请联系管理员!</p>");
				} else if(data.error_code == '1' || data.error_code == '2') {
					loginErrorMsg.html("<p style='color: #FD7A50;'>" + data.error_message + "</p>");
				}
			},
			error : function() {
				loginErrorMsg.html("<p style='color: #FD7A50;'>服务器暂时不可用，请稍后重试！</p>");
			}
		});}
    
});