'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description:main controller of user management 
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.04
 * 
 */


angular.module('sbAdminApp')
.controller('userCtrl',function($scope){
	$scope.operType = "qry";
	
	$scope.onEditUser = function onEditUser(user){
		$scope.eidtUser = user;
		$scope.operType = "edit";
	};
	
	$scope.onAddUser = function addUser(){
		$scope.eidtUser = {};
		$scope.eidtUser.id = "";
		$scope.operType = "add";
		
	};
	
	$scope.onCancel = function(){
		$scope.operType = "qry";
		//$route.reload();
	}
})


;
 

