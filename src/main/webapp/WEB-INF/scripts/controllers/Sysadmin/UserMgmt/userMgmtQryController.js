'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description:user management query controller
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.04
 * 
 */


angular.module('sbAdminApp')
.controller('userQryCtrl', ['$scope','$state','UserService',function($scope,$state, UserService){
	$scope.displayed = [];
	
	$scope.getUserList = function getUserList(tableState) {

		$scope.isLoading = true;

		var params = {};
		
		if(tableState.pagination != undefined)
		{
			var search = tableState.search;
			var pagination = tableState.pagination;
			
			if(search != undefined && pagination != undefined){
				
				angular.extend(params,search.predicateObject,pagination);
			}
			
			
		}
		
		UserService.queryBasicInfo(params).then(
	    function(result){
    		//响应成功
    		$scope.displayed = result.data;
    		
    		pagination.itemsByPage = 10;
    		
    		tableState.pagination.numberOfPages = Math.ceil(result.numberOfItems / pagination.itemsByPage);
    		
    		$scope.isLoading = false;
	    },
	    function(){
	    	alert('failed');
	    });
	    
	    
	};
	
	$scope.onDeleteUser = function(user){
		
		var params = {id:user.id};
		
		UserService.remove(params).then(
			    function(result){
		    		alert("remove " + user.id + " sucessfully");
		    		
		    		$state.reload();
			    },
			    function(){
			    	alert('failed');
			    });
		
		
	}
	
	$scope.selectUser = function (user){
		
		$scope.selectedUser = user;
	};
		
	$scope.isSelected = function (user) {
		
		return $scope.selectedUser === user;
	};
}]);
