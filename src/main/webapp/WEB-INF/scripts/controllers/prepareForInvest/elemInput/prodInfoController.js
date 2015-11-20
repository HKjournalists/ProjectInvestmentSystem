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
.controller('prodInfoCtrl', ['$scope','$filter','$state','DictService','ProductElemService','ngDialog',function($scope,$filter,$state,dictService, productElemService,ngDialog){
	
	$scope.repayPlanList = [];
	
	$scope.queryForDict = function()
	{
		dictService.query({type:'RIGHT_TYPE'})
			.then(function(result){$scope.rightTypeList = result});
		
		dictService.query({type:'Y_OR_N'})
		.then(function(result){$scope.isIncludeRightList = result});
	}
	
	$scope.queryForDict();
	
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

	$scope.onSelectTrade =function()
	{
		var dialog = ngDialog.openConfirm({ template: './popup/tradeInfo.html',//模式对话框内容为test.html  
            className: 'ngdialog-theme-default ',
            closeByDocument:false,
            scope: $scope
            //scope:$scope //将scope传给test.html,以便显示地址详细信息  
        })
        .then(
        	function(resObj){
        		$scope.dTradeType = resObj.id;
        		
        		$scope.dTradeName = resObj.label;
            },
            function(reason){
            	alert('rejected, reason - ', reason);
            }
        ); 
	}
	
	$scope.$on('EVT_SAVE',function(){
		
		//event.stopPropagation();
		
		var eleObj = {trustManager:$scope.trustManager,
				  trustManagerName:$scope.trustManagerName,
				  issuerCode:$scope.issuerCode,
				  issuerName:$scope.issuerName,
				  dTradeType:$scope.dTradeType,
				  dTradeName:$scope.dTradeName,
				  maturityYear:$scope.maturityYear,
				  issueScale:$scope.issueScale,
				  isIncludeRight:($scope.isIncludeRight == undefined) ? '' :  $scope.isIncludeRight.key,
				  rightType:($scope.rightType == undefined) ? '' : $scope.rightType.key,
				  rightDesc:$scope.rightDesc,
				  repayPlanList:$filter('json')($scope.repayPlanList)
				  }
			
		$scope.setElement(eleObj);
		
		$scope.$emit('EVT_SAVE_DONE',{evtSrc:'prodinfo'});
		
	})
	
}]);


