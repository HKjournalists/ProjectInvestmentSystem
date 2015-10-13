'use strict';

/**
 * @ngdoc directive
 * @CopyRight:icbc
 * @Description:drop down multi-select directive
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.05
 * 
 */
angular.module('sbAdminApp')
.directive('dropdownMultiselect', function(){
   return {
       restrict: 'AE',
 
//       scope:{   
//    	   	pre_selected: '=',
//    	   	selected_items: '=',
//          options: '='
//       },
        

       template: "<div class='btn-group' ng-class='{open: open}'>" +
				 	"<button class='btn btn-primary'>请选择</button>" +
    	   			"<button class='btn btn-primary dropdown-toggle' ng-click='open=!open;openDropdown()'><span class='caret'></span></button>" +
    	   			"<ul class='dropdown-menu' aria-labelledby='dropdownMenu'>  " +
    					"<li><a ng-click='selectAll()'><i class='fa fa-check'></i> 全选</a></li>" +
    					"<li><a ng-click='deselectAll()'><i class='fa fa-times'></i> 重置</a></li>   "  +         
    					"<li class='divider'></li> " +
    					"<li ng-repeat='option in options'>" +
    					"<a ng-click='setSelectedItem()'>{{option.name}}<span ng-class='isChecked()'></span></a></li>"  +                                     
    				"</ul> " +
    			 "</div>" ,
    					
       link: function($scope, $element, $attrs){
           
    	   	//var clk = 0;
    	   
	   	    var _remove = function(_item)
		    {
				for(var i = 0 ; i < $scope.selected_items.length; i++)
				{
					if(_item.id == $scope.selected_items[i].id) 
					{
						$scope.selected_items.splice(i,1);
					}
				}
		    }
		    
	   	    var _append = function(_item)
		    {
	
		    	$scope.selected_items.push(_item);
	
		    }
		    
	   	    var _contains = function(_item)
		    {
		    	for(var i = 0 ; i < $scope.selected_items.length; i++)
		    	{
		    		if(_item.id == $scope.selected_items[i].id)
		    		{
		    			return true;
		    		}
		    	}
		    	
		    	return false;
		    }  
	    
    		$scope.selectAll = function(){
    			
    			$scope.selected_items = [];
    			
    			for(var i = 0 ; i < $scope.options.length; i++)
    			{
    				$scope.selected_items.push($scope.options[i]);
    			}
    		};
    		
    		$scope.deselectAll = function(){
    			
    			$scope.selected_items = [];
    		};
    		
    	    $scope.openDropdown = function(){
    	    	
    	    	//$scope.selected_items = [];
    	    		
//    	    	if($scope.selected_items.length == 0 && clk == 0)
//    	    	{
//    	        	for(var i = 0 ; i < $scope.pre_selected.length; i++)
//    	        	{
//    	        		$scope.selected_items.push($scope.pre_selected[i]);
//    	        	}
//    	    	}
//    	    	
//    	    	clk = 1;
    	    };      
    	    
    	    $scope.setSelectedItem = function(){
    	    	
    	    	var _option = this.option;
    	    	
    	    	if(_contains(_option))
    	    	{
    	    		_remove(_option)
    	    	}
    	    	else
    	    	{
    	    		_append(_option);
    	    	}
    	    };
    	    
    	    $scope.isChecked = function () {
    	    	
    	    	var _option = this.option;
    	    	
    	    	if(_contains(_option))
    	    	{
    	    		return 'fa fa-check';
    	    	}
    	    };
    	 
                             
       }
   } 
});