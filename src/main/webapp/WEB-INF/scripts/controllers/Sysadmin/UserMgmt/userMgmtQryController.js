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
.controller('userQryCtrl', function($scope, $http){
	$scope.displayed = [];
	
	$scope.getUserList = function getUserList(tableState) {

		$scope.isLoading = true;

	    var pagination = tableState.pagination || {};
	    var search = tableState.search || {}; 

	    var params = search.predicateObject || {};  
	    params.start = pagination.start || 0;
	    params.number = pagination.number || 10;
	    $http({url:'../user/getUsersByCondition',params:params ,method:'GET'
	    	})
	    	.success(function(result,header,config,status){
	    		//响应成功
	    		$scope.displayed = result.data;
	    		tableState.pagination.numberOfPages = result.numberOfPages;//set the number of pages so the pagination can update
	    		$scope.isLoading = false;
	    	})
	    	.error(function(result,header,config,status){
	    		//处理响应失败
	    		alert('failed');
	    	});
	    
	  };
});
