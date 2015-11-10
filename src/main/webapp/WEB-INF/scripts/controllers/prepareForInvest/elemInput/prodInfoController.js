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
.controller('prodInfoCtrl', ['$scope','$state','ProductElemService',function($scope,$state, productElemService){
	
	$scope.repayPlanList = [];
	
	$scope.onAddRepayPlan = function()
	{
		var repayPlan = {};
		repayPlan.eleRepayTime = "0";
		repayPlan.eleRepayAmt = "0";
		$scope.repayPlanList.push(repayPlan);
	}
	
	$scope.onDelRepayPlan = function(idx)
	{
		var index = idx - 1;
		$scope.repayPlanList.splice(idx,1);
	}

	
}]);


