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
.controller('userEditCtrl', ['$scope','RoleInfo', function($scope,RoleInfo){
	
	
	$scope.user = {};
	$scope.$watch('operType',function()
			{
				var assignOption = function(result){
										$scope.options = result;
								   };
			
				if('add' == $scope.operType)
				{
					RoleInfo.queryall().then(assignOption(result),assignOption(result));
				}
				else if('edit' == $scope.operType)
				{
					RoleInfo.query().then(assignOption(result),assignOption(result));
				}
			});
	
	//alert(1);
	$scope.selected_items = [];
	
	$scope.pre_selected = [];
	
	$scope.save = function(){
		alert("save");
	}
 

	$scope.add = function(){
		
	}
}]);
