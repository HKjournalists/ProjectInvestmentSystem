
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
.controller('prodCreditRatingCtrl', ['$scope','$state','DictService','ProductElemService',function($scope,$state,dictService, productElemService){
	
	$scope.queryForDict = function()
	{
		dictService.query({type:'RATING'})
			.then(function(result){$scope.ratingList = result});
		
		dictService.query({type:'RATING_ORG'})
		.then(function(result){$scope.ratingOrgList = result});
	}
	
	$scope.queryForDict();
	
	$scope.$on('EVT_SAVE',function(){
		
		//event.stopPropagation();
		
		var eleObj = {outerCompanyRate:($scope.outerCompanyRate == undefined) ? '' : $scope.outerCompanyRate.key,
				  outerCompanyRateSrc:($scope.outerCompanyRateSrc == undefined) ? '' : $scope.outerCompanyRateSrc.key,
				  innerCompanyRate:($scope.innerCompanyRate == undefined) ? '' : $scope.innerCompanyRate.key,
				  icbcCompanyRate:($scope.icbcCompanyRate == undefined) ? '' : $scope.icbcCompanyRate.key,
				  outerBondRate:($scope.outerBondRate == undefined) ? '' : $scope.outerBondRate.key,
				  outerBondRateSrc:($scope.outerBondRateSrc == undefined) ? '' : $scope.outerBondRateSrc.key,
				  innerBondRate:($scope.innerBondRate == undefined) ? '' : $scope.innerBondRate.key,
				  remark:$scope.remark
				  }
			
		$scope.setElement(eleObj);
		
		$scope.$emit('EVT_SAVE_DONE',{evtSrc:'creditrate'});
		
	})
	
	
	
}]);
