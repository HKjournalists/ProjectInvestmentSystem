angular.module('sbAdminApp')
.controller('dlgTradeInfoCtrl', ['$scope','$filter','DictService',function($scope,$filter,dictService){
	
	function createSubTree(node)
	{
		var res = [];
		
		if(node)
		{
			if(node.children.length > 0)
			{
				for(var i = 0 ; i < node.children.length ; ++i)
				{
					res.push({ "label" : node.children[i].nodeName, "id" : node.children[i].nodeCode, "i": i, "children": createSubTree(node.children[i]) });
				}
				
				return res;
			}
		}

	}


	var tradeTreeObj;

	
	dictService.queryTradeTree()
		.then(function(result){
			//tradeJsonStr = result;
			//treeFilter = $filter('tree');
			tradeTreeObj = angular.fromJson(result);
			//alert(jsonFilter(tradeTreeObj));
			var tree = createSubTree(tradeTreeObj.rootNode);
			//var tree = treeFilter(tradeTreeObj);
			$scope.treedata = tree;
	});
	
	
	
	
    $scope.showSelected = function(sel) 
    {
    	$scope.selectedNode = sel;
    }
	
}])
;