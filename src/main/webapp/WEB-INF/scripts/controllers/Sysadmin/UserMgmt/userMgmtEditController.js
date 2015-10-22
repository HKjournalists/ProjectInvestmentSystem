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
.controller('userEditCtrl', ['$scope','$location','RoleService','UserService', function($scope,$location,RoleService,UserService){
	
	
	$scope.user = {};
	
	$scope.selected_items = [];
	
	$scope.$watch('eidtUser.id',function()
	{
		//init the role options list 
		RoleService.queryall().then(
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
			UserService.queryRoleInfo(params).then(function(result){
										$scope.selected_items = result;
									},
									function(result){
										$scope.selected_items = [];
									});
		}
	});
	
	$scope.$on("$routeChangeSuccess", function () {
        alert(1);
    });
	
	$scope.onSave = function(){
		//UserService.test().then(function(){alert('save sucessfully');});
		
		var params = $scope.user;
		
		if($scope.selected_items.length == 0)
		{
			alert("请分配用户角色");
			return ;
		}
		
		var roleidArray = new Array($scope.selected_items.length)
		
		for(var i = 0; i < $scope.selected_items.length;++i)
		{
			roleidArray[i] = $scope.selected_items[i].id;
		}
		
		params.role = roleidArray.join(',');
		
		UserService.save(params)
		.then(function(){
					alert('save sucessfully');
					//$.scope.onCancel();
					$location.path("/views/index.html");
				},
			  function(){
					alert('save failed');
		});
		
		
	};
 
}]);
