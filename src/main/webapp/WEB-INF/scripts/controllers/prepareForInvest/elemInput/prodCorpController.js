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
.controller('prodCorpCtrl', ['$scope','$state','DictService','ProductElemService','ngDialog',function($scope,$state,dictService, productElemService,ngDialog){
	
	$scope.intPayDateList = [];
	
	$scope.queryForDict = function()
	{
		dictService.query({type:'INTEREST_FREQUENCY'})
			.then(function(result){$scope.interestFrequencyList = result});
	}
	
	$scope.queryForDict();
	
	dictService.query({type:'RAISE_CREDIT'})
		.then(function(result){
				resList = [];
				for(var i = 0 ; i < result.length; ++i)
				{
					var res = {};
					res.id = result[i].key;
					res.name = result[i].value;
					resList.push(res);
				}
				
				$scope.options = resList;
			})
		.then(function(){$scope.selected_items = []});
	
	$scope.selected_items = [];
	
	$scope.onAddintPayDate = function()
	{
		var item = {};
		item.intPayDate = "20150101";
		$scope.intPayDateList.push(item);
	}

	$scope.onDelntPayDate = function(idx)
	{
		var index = idx - 1;
		$scope.intPayDateList.splice(idx,1);
	}
	
	$scope.onSelectTrade =function()
	{
		var dialog = ngDialog.openConfirm({ template: './popup/tradeInfo.html',
            className: 'ngdialog-theme-default ',
            closeByDocument:false,
            scope: $scope
        })
        .then(
        	function(resObj){
        		$scope.gTradeType = resObj.id;
        		
        		$scope.gTradeName = resObj.label;
            },
            function(reason){
            	alert('rejected, reason - ', reason);
            }
        );;  
	}
	
	$scope.$on('EVT_SAVE',function(){
		
		//event.stopPropagation();
		
		var raiseCreditSelectList = new Array($scope.selected_items.length)
		
		for(var i = 0; i < $scope.selected_items.length;++i)
		{
			raiseCreditSelectList[i] = $scope.selected_items[i].id;
		}
		
		var raiseCreditSelected = raiseCreditSelectList.join(',');
		
		var intPayDates = new Array($scope.intPayDateList.length);
		
		for(var i = 0; i < $scope.intPayDateList.length;++i)
		{
			intPayDates[i] = $scope.intPayDateList[i].intPayDate;
		}
		
		var intPayDatesStr = intPayDates.join(',');
		
		var eleObj = {interestFrequency:($scope.interestFrequency == undefined) ? '' :  $scope.interestFrequency.key,
					  listDate:$scope.listDate,
					  intPayDateList:intPayDatesStr,
					  raiseCreditSelectList:raiseCreditSelected,
					  raiseCreditDesc:$scope.raiseCreditDesc,
					  guarantee:$scope.guarantee,
					  guaranteeName:$scope.guaranteeName,
					  gTradeType:$scope.gTradeType,
					  gTradeName:$scope.gTradeName,
					  mortgageRatio:$scope.mortgageRatio,
					  custodian:$scope.custodian,
					  custodianName:$scope.custodianName,
					  superintendent:$scope.superintendent,
					  superintendentName:$scope.superintendentName,
					  fincConsultent:$scope.fincConsultent,
					  fincConsultentName:$scope.fincConsultentName,
					  otherCorp:$scope.otherCorp,
					  otherCorpName:$scope.otherCorpName
					  }
			
		$scope.setElement(eleObj);
		
		$scope.$emit('EVT_SAVE_DONE',{evtSrc:'corporation'});
		
	})
	
}]);
