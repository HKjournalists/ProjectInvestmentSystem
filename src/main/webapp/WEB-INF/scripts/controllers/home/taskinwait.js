'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description:taskinwaitCtrl
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.04
 * 
 */


angular.module('sbAdminApp')
.controller('taskinwaitCtrl',['$scope','$state','TaskInWaitService',function($scope,$state,TaskInWaitService){
	
	$scope.displayed = [];
	
	$scope._tableState = {};
	
	$scope.getTaskInWaiting = function(tableState) {

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

		TaskInWaitService.getTasks(params).then(
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
	
	$scope.onHandle = function(task)
	{
		params = {};
		params.taskId = task.taskId;
		
		TaskInWaitService.takeTask(params)
		.then(function(result){alert(result);},function(result){alert(result);})
	}
}])


;
 

