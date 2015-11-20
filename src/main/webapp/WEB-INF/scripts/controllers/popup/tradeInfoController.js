angular.module('sbAdminApp')
.controller('dlgTradeInfoCtrl', ['$scope','$filter','DictService',function($scope,$filter,dictService){

	var tradeTreeObj;

	
	dictService.queryTradeTree()
		.then(function(result){
			
			tradeTreeObj = angular.fromJson(result);
			
			var tree = $filter('treeTransFilter')(tradeTreeObj);
			
			$scope.treedata = tree;
	});

    $scope.showSelected = function(sel) 
    {
    	$scope.selectedNode = sel;
    }
	
    $scope.onConfirm = function()
    {
    	$scope.confirm($scope.selectedNode);
    }
    
//	$scope.$on('ngDialog.opened', function (e, $dialog) {
//		alert('ngDialog opened: ' + $dialog.attr('id'));
//	});
}])

;