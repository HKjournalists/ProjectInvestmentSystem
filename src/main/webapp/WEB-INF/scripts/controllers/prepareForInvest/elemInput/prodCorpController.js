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
	
	$scope.raiseCreditSelectList = [];
	
	$scope.onAddintPayDate = function()
	{
		var item = {};
		item.intPayDate = "20150101";
		$scope.intPayDateList.push(item);
	}

	$scope.onDelintPayDate = function(idx)
	{
		var index = idx - 1;
		$scope.intPayDateList.splice(idx,1);
	}
	
	$scope.showDialog = function()
	{
		ngDialog.open({ template: './popup/tradeInfo.html',//模式对话框内容为test.html  
            className: 'ngdialog-theme-default '
            //scope:$scope //将scope传给test.html,以便显示地址详细信息  
        });  
	}
	
}]);