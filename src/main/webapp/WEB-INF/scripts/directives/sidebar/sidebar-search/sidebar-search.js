'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */

angular.module('sbAdminApp')
  .directive('sidebarSearch',['$timeout','$filter',function($timeout,$filter) {
    return {
      templateUrl:'../scripts/directives/sidebar/sidebar-search/sidebar-search.html',
      restrict: 'E',
      replace: true,
      scope: false,
      link:function($scope,$elem){
    	var promise = null;
    	var filter=$filter("menufilter");
        $scope.selectedMenu = 'home';
        $scope.OnSereash=function(){
            
            if (promise !== null) {
                $timeout.cancel(promise); 
              }
            promise = $timeout(function () {
            	$scope.menu=filter($scope.fullmenu,$scope.barSearch);
                promise = null;
              }, 400);
            if($scope.barSearch=="")
            	{
            	$scope.menu=$scope.fullmenu;
            	$timeout.cancel(promise);
            	}
              
        }
        $scope.OnSereashClick=function(){

        	$scope.menu=filter($scope.fullmenu,$scope.barSearch);
              
        }
      }
    }
}])
.filter('menufilter',function(){   
    return function(items,name){
               var searh=function(items,name)
               {
        		   var ret=[]
                   for(var i=0;i<items.length;i++)
            	   {
                   if(items[i].hasChild) ret=ret.concat(searh(items[i].Child,name));
                   else
            	   if(items[i].text.indexOf(name)!=-1) ret.push(items[i]);
            	   }
        		   return ret;
               }
               return searh(items,name);    
     }
});

