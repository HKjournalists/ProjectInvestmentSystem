'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('sbAdminApp')
    .directive('stats',function() {
    	return {
  		templateUrl:'../scripts/directives/dashboard/stats/stats.html',
  		restrict:'E',
  		replace:true,
  		scope: {
        'model': '=',
        'comments': '@',
        'number': '@',
        'name': '@',
        'colour': '@',
        'details':'@',
        'type':'@',
        'goto':'@'
  		},
    	link: function($scope, $element, $attrs){
    		$scope.changeMode = function(mode)
    		{
    			data = {};
    			
    			data.mode = mode
    			
    			$scope.$emit('EVT_GOTO',data);
    		}
    	}
  		
  	}
  });
