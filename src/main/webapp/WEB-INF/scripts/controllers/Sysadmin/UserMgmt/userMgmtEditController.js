'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:userEditCtrl
 * @description
 * @CreatedBy: Yuezhi.Liu
 * @Date: 20151005
 * # userEditCtrl
 * Controller of the sbAdminApp
 */


angular.module('sbAdminApp')
.controller('userEditCtrl', ['$scope', function($scope){
	
	$scope.user = {};
	
	$http({url:'../role/getAllRoleList',params:{},method:'GET'})
	.success(function(result,header,config,status){
		//响应成功
		$scope.options = result;

	})
	.error(function(result,header,config,status){
		//处理响应失败
		$scope.options = [];
		alert('get role list failed');
	});
			


//	$scope.options = [{"id": 1, "name": "Manager", "assignable": true},
//	                   {"id": 2, "name": "Developer", "assignable": true},
//	                   {"id": 3, "name": "Reporter", "assignable": true},
//	                   {"id": 4, "name": "Boss", "assignable": true},
//	                   {"id": 5, "name": "QA", "assignable": true},
//	                   {"id": 6, "name": "DEV", "assignable": true}];
	
	//alert(1);
	$scope.selected_items = [];
	
	$scope.pre_selected = [];
	
	$scope.save = function(){
		
	}
 

}]);
