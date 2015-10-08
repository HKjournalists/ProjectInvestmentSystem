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
.controller('userEditCtrl', ['$scope','RoleInfo','UserInfo', function($scope,RoleInfo,UserInfo){
	
	
	$scope.user = {};
	
	$scope.selected_items = [];
	
	$scope.$watch('eidtUser.id',function()
	{
		//init the role options list 
		RoleInfo.queryall().then(
			function(result){
				$scope.options = result;
			},
			function(result){
				$scope.options = [];
			});
		
		if('add' == $scope.operType)
		{
			$scope.selected_items = [];
			$scope.user = {};
			
		}
		else if('edit' == $scope.operType)
		{
			$scope.user = $scope.eidtUser;
			
			var params = {id:$scope.user.id};
			
			//init the user's role and make them selected
			UserInfo.queryRoleInfo(params).then(function(result){
										$scope.selected_items = result;
									},
									function(result){
										$scope.selected_items = [];
									});
		}
	});
	
	$scope.onSave = function(){
		
		var params = $scope.user;
		
		var roleidArray = new Array($scope.selected_items.length)
		
		for(var i = 0; i < $scope.selected_items.length;++i)
		{
			roleidArray[i] = $scope.selected_items[i].id;
		}
		
		params.role = roleidArray.join(',');
		
		UserInfo.save(params).then(
				function(){
					alert('save sucessfully');
					$.scope.onCancel();
				},
				function(){
					alert('save failed');
				});
	};
 
}]);
