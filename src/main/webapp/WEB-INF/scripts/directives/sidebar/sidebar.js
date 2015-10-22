'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */

angular.module('sbAdminApp')
  .directive('sidebar',['$location','menuService',function(menuService) {
    return {
      templateUrl:'../scripts/directives/sidebar/sidebar.html',
      restrict: 'E',
      replace: true,
      link:function($scope,iElem,iAttrs,ctrl){
        $scope.selectedMenu = 'dashboard';
        $scope.collapseVar = 0;
        $scope.multiCollapseVar = 0;
        $scope.check = function(x){
          
          if(x==$scope.collapseVar)
            $scope.collapseVar = 0;
          else
            $scope.collapseVar = x;
        };
        
        $scope.multiCheck = function(y){
          
          if(y==$scope.multiCollapseVar)
            $scope.multiCollapseVar = 0;
          else
            $scope.multiCollapseVar = y;
        };        	
      }
    }
  }])
  .controller('sidebarCtrl', ['$scope','menuService',function($scope, menuService){
	  menuService.queryall().then(
      		function(result){
      	$scope.menu= result;
      	$scope.fullmenu=result;
		},
		function(result){
			$scope.menu = [];
		});
  }])
.factory('menuService', ['$http', '$q', function ($http, $q) {
	  return {
		  test:function() {  return 'ttt';},
		  queryall : function() {  
			  var deferred = $q.defer();
			  $http({method: 'GET', url: '../MenuGenerater'}).  
			  success(function(data, status, headers, config) {  
				  deferred.resolve(data); 
			  }).  
			  error(function(data, status, headers, config) {  
				  deferred.reject(data);  
			  });  
			  
			  return deferred.promise;  
		  }
	  };  
	}]);