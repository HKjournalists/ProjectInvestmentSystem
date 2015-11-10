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
.controller('prodBasicCtrl', ['$scope','$state','DictService','ProductElemService',function($scope,$state, dictService,productElemService){
		
	//init
	$scope.onSwitch('basic');

	$scope.queryForDict = function()
	{
		dictService.query({type:'PRODUCT_TYPE'})
			.then(function(result){$scope.productTypeList = result});
	}
	
	$scope.queryForDict();
	
}]);
