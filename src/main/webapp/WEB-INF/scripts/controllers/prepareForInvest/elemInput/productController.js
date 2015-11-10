'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description: prodcut list query controller
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.04
 * 
 */


angular.module('sbAdminApp')
.controller('productCtrl', ['$scope','$state','ProductElemService',function($scope,$state, productElemService){
	
	$scope.displayed = [];
	
	var params = {};
	
	$scope.getProductList = function(tableState) {

		$scope.isLoading = true;

		if(tableState.pagination != undefined)
		{
			var search = tableState.search;
			var pagination = tableState.pagination;
			
			if(search != undefined && pagination != undefined){
				
				angular.extend(params,pagination);
			}
			
		}
		
		productElemService.query(params).then(
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
		
		productElemService.query(params).then(
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
	
	$scope.onAddProduct = function(){

		alert("add");
		$state.go('dashboard.productEdit', {product: 0});
	};
	
	$scope.onDeleteProduct = function(product){

		alert("delete");
//		var params = {id:user.id};
		
//		UserService.remove(params).then(
//			    function(result){
//		    		alert("remove " + user.id + " sucessfully");
//		    		
//		    		$state.reload();
//			    },
//			    function(){
//			    	alert('failed');
//			    });
		
	}

}]);
