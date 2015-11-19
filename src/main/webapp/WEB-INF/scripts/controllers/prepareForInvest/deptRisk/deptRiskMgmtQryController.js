'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description:dept risk verify management query controller
 * @CreatedBy:lufeng
 * @Date:2015.11.05
 * 
 */

angular.module('sbAdminApp')
.controller('deptRiskQryCtrl', ['$scope','$state','DeptRiskService',function($scope,$state, DeptRiskService){
	$scope.displayed = [];
	var params = {};
	$scope.getDeptRiskList = function getDeptRiskList(tableState) {
		$scope.isLoading = true;
		if(tableState.pagination != undefined){
			var search = tableState.search;
			var pagination = tableState.pagination;
			if(search != undefined && pagination != undefined){
				angular.extend(params,search.predicateObject,pagination);
			}
		}
		DeptRiskService.queryDeptRiskInfo(params).then(
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
	
	$scope.onSearch = function(){
		params.productId = $scope.productId == undefined ? null : $scope.productId ;
		params.productName = $scope.productName == undefined ? null : $scope.productName;
		params.productType = $scope.productType == undefined ? null : $scope.productType;
		
		DeptRiskService.queryDeptRiskInfo(params).then(
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
	}
	
	$scope.selectDeptRisk = function (deptRisk){	
		$scope.selectedDeptRisk = deptRisk;
	};
	
	$scope.isSelected = function (deptRisk) {
		return $scope.selectedDeptRisk === deptRisk;
	};
}]);
