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
.controller('userCtrl', function($scope){
	$scope.operType = "qry";
	
	$scope.addUser = function addUser(){
		$scope.operType = "add";
	};
	
	$scope.cancel = function(){
		$scope.operType = "qry";
	}
})


;
 

