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
.controller('prodIncomeCtrl', ['$scope','$state','DictService','ProductElemService',function($scope,$state,dictService, productElemService){
	
	$scope.queryForDict = function()
	{
		dictService.query({type:'PORT_RATING_TYPE'})
			.then(function(result){$scope.portRatingTypeList = result});
		
		dictService.query({type:'BENCH_YIELD_TYPE'})
		.then(function(result){$scope.benchYieldTypeList = result});
		
		dictService.query({type:'BENCH_YIELD_ADJUST'})
		.then(function(result){$scope.benchYieldAdjustList = result});
		
		dictService.query({type:'NET_PORT_RATING_ALGO'})
		.then(function(result){$scope.netPortRatingAlgoList = result});
	}
	
	$scope.queryForDict();
	
	$scope.$on('EVT_SAVE',function(){
		
		//event.stopPropagation();
		
		var eleObj = {portRatingType:($scope.portRatingType == undefined) ? '' :  $scope.portRatingType.key,
				  portRating:$scope.portRating,
				  benchYieldType:($scope.benchYieldType == undefined) ? '' :  $scope.benchYieldType.key,
				  benchYieldRatio:$scope.benchYieldRatio,
				  benchYieldAdjust:($scope.benchYieldAdjust == undefined) ? '' :  $scope.benchYieldAdjust.key,
				  interestMargin:$scope.interestMargin,
				  protRatingULimit:$scope.portRatingUpLimit,
				  protRatingLLimit:$scope.portRatingLowLimit,
				  curPortRating:$scope.curPortRating,
				  depositFee:$scope.depositFee,
				  superviseFee:$scope.superviseFee,
				  consultantFee:$scope.consultantFee,
				  otherFee:$scope.otherFee,
				  totalFee:$scope.totalFee,
				  netPortRating:$scope.netPortRating,
				  netPortRatingAlgo:($scope.netPortRatingAlgo == undefined) ? '' :  $scope.netPortRatingAlgo.key
				  }
			
		$scope.setElement(eleObj);
		
		$scope.$emit('EVT_SAVE_DONE',{evtSrc:'income'});
		
	})

}]);
