
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
.controller('prodOtherCtrl', ['$scope','$state','DictService','ProductElemService',function($scope,$state,dictService, productElemService){
	
	$scope.queryForDict = function()
	{
		dictService.query({type:'INVEST_INTENTION'})
			.then(function(result){$scope.investIntentionList = result});
		
		dictService.query({type:'INT_PAY_TYPE'})
		.then(function(result){$scope.intPayTypelist = result});
	}
	
	$scope.queryForDict();
	
	$scope.$on('EVT_SAVE',function(){
		
		var eleObj = {investIntention:($scope.investIntention == undefined) ? '' :$scope.investIntention.key,
				  fundUsage:$scope.fundUsage,
				  maturityDate:$scope.maturityDate,
				  putValue:$scope.putValue,
				  putDate:$scope.putDate,
				  redemptionValue:$scope.redemptionValue,
				  redemptionDate:$scope.redemptionDate,
				  intPayType:($scope.intPayType == undefined) ? '' :$scope.intPayType.key,
				  intDesc:$scope.intDesc,
				  publishDate:$scope.publishDate
				  }
			
		$scope.setElement(eleObj);
		
		$scope.$emit('EVT_SAVE_DONE',{evtSrc:'other'});
		
	})
	
}]);


