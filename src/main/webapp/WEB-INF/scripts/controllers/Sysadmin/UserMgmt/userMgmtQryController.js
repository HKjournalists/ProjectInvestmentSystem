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
.controller('userQryCtrl', ['$scope','$location','UserService',function($scope,$location, UserService){
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
    		tableState.pagination.numberOfPages = result.numberOfItems / pagination.itemsByPage;
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
		    		
		    		$location.path("/views/index.html");
			    },
			    function(){
			    	alert('failed');
			    });
		
		
	}
}]);
