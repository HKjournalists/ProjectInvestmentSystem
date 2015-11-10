
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
}]);
