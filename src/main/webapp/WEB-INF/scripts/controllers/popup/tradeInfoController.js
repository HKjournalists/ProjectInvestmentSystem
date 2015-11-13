angular.module('sbAdminApp')
.controller('dlgTradeInfoCtrl', ['$scope','$filter','DictService',function($scope,$filter,dictService){

	var tradeTreeObj;

	
	dictService.queryTradeTree()
		.then(function(result){
			//tradeJsonStr = result;
			//treeFilter = $filter('tree');
			tradeTreeObj = angular.fromJson(result);
			//alert(jsonFilter(tradeTreeObj));
			//var tree = createSubTree(tradeTreeObj.rootNode);
			var tree = $filter('treeTransFilter')(tradeTreeObj);
			$scope.treedata = tree;
	});
	
	
	
	
    $scope.showSelected = function(sel) 
    {
    	$scope.selectedNode = sel;
    }
	
}])

;