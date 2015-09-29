'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */

angular.module('sbAdminApp')
  .directive('sidebar',['$location',function() {
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
        $scope.menu=[{text:"系统管理",url:"eee",icon:"fa-sitemap",hasChild:true,
        	             Child:[{text:"用户管理",url:"dashboard.userManagement",icon:"fa-sitemap",hasChild:false},{text:"角色管理",url:"eee",icon:"fa-sitemap",hasChild:false},{text:"日志管理",url:"eee",icon:"fa-sitemap",hasChild:false}]},
                     {text:"投前准备",url:"eee",icon:"fa-sitemap",hasChild:true,Child:[{text:"用户管理",url:"dashboard.userManagement",icon:"fa-sitemap",hasChild:false},{text:"角色管理",url:"eee",icon:"fa-sitemap",hasChild:false},{text:"日志管理",url:"eee",icon:"fa-sitemap",hasChild:false}]},
                     {text:"投资审批",url:"eee",icon:"fa-sitemap",hasChild:true,Child:[{text:"用户管理",url:"dashboard.userManagement",icon:"fa-sitemap",hasChild:false},{text:"角色管理",url:"eee",icon:"fa-sitemap",hasChild:false},{text:"日志管理",url:"eee",icon:"fa-sitemap",hasChild:false}]},
                     {text:"投后管理",url:"eee",icon:"fa-sitemap",hasChild:true,Child:[{text:"用户管理",url:"dashboard.userManagement",icon:"fa-sitemap",hasChild:false},{text:"角色管理",url:"eee",icon:"fa-sitemap",hasChild:false},{text:"日志管理",url:"eee",icon:"fa-sitemap",hasChild:false}]},
        	        ];
      }
    }
  }]);