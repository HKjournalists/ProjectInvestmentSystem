'use strict';

/**
 * @ngdoc factory
 * @CopyRight:icbc
 * @Description: filter defined by customer
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.11.03
 * 
 */
 
angular.module('sbAdminApp')
.filter('treeTransFilter',function(){
	
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
	
	return function(node)
	{
		var tree = createSubTree(node.rootNode);
		
		return tree;
	}
})