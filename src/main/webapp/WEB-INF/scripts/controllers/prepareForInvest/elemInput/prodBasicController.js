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
		
		dictService.query({type:'TRUST_SUB_TYPE'})
		.then(function(result){$scope.trustSubTypeList = result});
		
		dictService.query({type:'Y_OR_N'})
		.then(function(result){$scope.yesOrNoList = result});
	}
	
	$scope.queryForDict();
	
	$scope.onChangeProductType = function()
	{
		//var t = $scope.productType;
		productElemService.genProductID()
			.then(function(result){
				var proID = '';
				switch($scope.productType.key)
				{
					case '1':
						proID = 'DIDP' + result;
						break;
					case '2':
						proID = 'DRDP' + result;
						break;
					case '3':
						proID = 'DATP' + result;
						break;
					case '4':
						proID = 'SSAP' + result;
						break;
					case '5':
						proID = 'SPAP' + result;
						break;
					case '6':
						proID = 'SCLO' + result;
						break;
					case '7':
						proID = 'DBFP' + result;
						break;
					case '8':
						proID = 'DPIP' + result;
						break;
				}
				
				$scope.productId = proID;
			});
	}
	
	$scope.onChangeTrustSubType = function()
	{
		var t = $scope.trustSubType;
		var pi = $scope.productId;
		if($scope.trustSubType.key == '2'){
			$scope.productId = 'SATP' + pi.substring(4);
		}
		else{
			$scope.productId = 'DATP' + pi.substring(4);
		}
		 
		
	}
	
	$scope.$on('EVT_SAVE',function(){
		
		//event.stopPropagation();
		//var a = $scope.productType;
		
		var eleObj = {productId:$scope.productId,
				  productInnerId:$scope.productInnerId,
				  productName:$scope.productName,
				  productBriefName:$scope.productBriefName,
				  productType:($scope.productType == undefined) ? 1 :  $scope.productType.key,
				  trustSubType:($scope.trustSubType == undefined) ? 1 :  $scope.trustSubType.key,
				  needCreditVerify:($scope.needCreditVerify == undefined) ? 1 :  $scope.needCreditVerify.key,
				  needLawVerify:($scope.needLawVerify == undefined) ? 1 : $scope.needLawVerify.key
				  }
			
		$scope.setElement(eleObj);
		
		$scope.$emit('EVT_SAVE_DONE',{evtSrc:'basic'});
		
	})
	
}]);
