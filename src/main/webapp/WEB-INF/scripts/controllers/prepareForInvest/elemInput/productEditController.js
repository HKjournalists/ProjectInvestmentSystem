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
.controller('productEditCtrl', ['$scope','$state','ProductElemService',function($scope,$state, productElemService){
	
	
	
	$scope.onSwitch = function(tab)
	{
		$scope.tabType = tab;
	}

	
}]);
