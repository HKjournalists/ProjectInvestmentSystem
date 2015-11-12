'use strict';
/**
 * @ngdoc overview
 * @name sbAdminApp
 * @description
 * # sbAdminApp
 *
 * Main module of the application.
 */
angular
  .module('sbAdminApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'smart-table',
    'ngDialog',
    'treeControl'
  ],function($httpProvider){
	// Use x-www-form-urlencoded Content-Type
	  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
	 
	  /**
	   * The workhorse; converts an object to x-www-form-urlencoded serialization.
	   * @param {Object} obj
	   * @return {String}
	   */ 
	  var param = function(obj) {
	    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;
	      
	    for(name in obj) {
	      value = obj[name];
	        
	      if(value instanceof Array) {
	        for(i=0; i<value.length; ++i) {
	          subValue = value[i];
	          fullSubName = name + '[' + i + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value instanceof Object) {
	        for(subName in value) {
	          subValue = value[subName];
	          fullSubName = name + '[' + subName + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value !== undefined && value !== null)
	        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
	    }
	      
	    return query.length ? query.substr(0, query.length - 1) : query;
	  };
	 
	  // Override $http service's default transformRequest
	  $httpProvider.defaults.transformRequest = [function(data) {
	    return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
	  }];

  })
  .config(['$stateProvider','$urlRouterProvider','$ocLazyLoadProvider',function ($stateProvider,$urlRouterProvider,$ocLazyLoadProvider) {
    
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });

    $urlRouterProvider.otherwise('/dashboard/home');

    $stateProvider
      .state('dashboard', {
        url:'/dashboard',
        templateUrl: './home/main.html',
        resolve: {
            loadMyDirectives:function($ocLazyLoad){
                return $ocLazyLoad.load(
                {
                    name:'sbAdminApp',
                    files:[
                    '../scripts/directives/header/header.js',
                    '../scripts/directives/header/header-notification/header-notification.js',
                    '../scripts/directives/sidebar/sidebar.js',
                    '../scripts/directives/sidebar/sidebar-search/sidebar-search.js'
                    ]
                }),
                $ocLazyLoad.load(
                {
                   name:'toggle-switch',
                   files:["../bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                          "../bower_components/angular-toggle-switch/angular-toggle-switch.css"
                      ]
                }),
                $ocLazyLoad.load(
                {
                  name:'ngAnimate',
                  files:['../bower_components/angular-animate/angular-animate.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngCookies',
                  files:['../bower_components/angular-cookies/angular-cookies.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngResource',
                  files:['../bower_components/angular-resource/angular-resource.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngSanitize',
                  files:['../bower_components/angular-sanitize/angular-sanitize.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngTouch',
                  files:['../bower_components/angular-touch/angular-touch.js']
                })
            }
        }
    })
      .state('dashboard.home',{
        url:'/home',
        controller: 'homeCtrl',
        templateUrl:'./home/home.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'sbAdminApp',
              files:[
              '../scripts/controllers/home/home.js',
              '../scripts/controllers/home/taskinwait.js',
              '../scripts/factory/taskInWaitService.js',
              '../scripts/directives/timeline/timeline.js',
              '../scripts/directives/notifications/notifications.js',
              '../scripts/directives/chat/chat.js',
              '../scripts/directives/dashboard/stats/stats.js'
              ]
            })
          }
        }
      })
      .state('dashboard.form',{
        templateUrl:'./form.html',
        url:'/form'
    })
      .state('dashboard.blank',{
        templateUrl:'./pages/blank.html',
        url:'/blank'
    })
      .state('login',{
        templateUrl:'./pages/login.html',
        controller: 'loginController',
        url:'/login',
        resolve: {
                loadMyFiles:function($ocLazyLoad) {
                  return $ocLazyLoad.load({
                    name:'sbAdminApp',
                    files:['../scripts/controllers/login.js'
                    ]
                  })
                }
              }
    })
      .state('dashboard.chart',{
        templateUrl:'./chart.html',
        url:'/chart',
        controller:'ChartCtrl',
        resolve: {
          loadMyFile:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'chart.js',
              files:[
                '../bower_components/angular-chart.js/dist/angular-chart.min.js',
                '../bower_components/angular-chart.js/dist/angular-chart.css'
              ]
            }),
            $ocLazyLoad.load({
                name:'sbAdminApp',
                files:['../scripts/controllers/chartContoller.js']
            })
          }
        }
    })
      .state('dashboard.table',{
        templateUrl:'./table.html',
        url:'/table'
    })
      .state('dashboard.panels-wells',{
          templateUrl:'./ui-elements/panels-wells.html',
          url:'/panels-wells'
      })
      .state('dashboard.buttons',{
        templateUrl:'./ui-elements/buttons.html',
        url:'/buttons'
    })
      .state('dashboard.notifications',{
        templateUrl:'./ui-elements/notifications.html',
        url:'/notifications'
    })
      .state('dashboard.typography',{
       templateUrl:'./ui-elements/typography.html',
       url:'/typography'
   })
      .state('dashboard.icons',{
       templateUrl:'./ui-elements/icons.html',
       url:'/icons'   })
      .state('dashboard.grid',{
       templateUrl:'./ui-elements/grid.html',
       url:'/grid'
   })
    .state('dashboard.test',{
       templateUrl:'./test/jbpm/jbpmtest.html',
       url:'/test',
       controller: 'jbpmTestCtrl',
       resolve: {
           loadMyFiles:function($ocLazyLoad) {
             return $ocLazyLoad.load({
               name:'sbAdminApp',
               files:[
               '../scripts/controllers/test/jbpm/jbpmtest.js'
               ]
             })
           }
         }
     })
     
   .state('dashboard.userManagement',{
        url:'/userManagement',
        controller: 'userCtrl',
        templateUrl:'./sysAdmin/user/userManagement.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'sbAdminApp',
              files:[
              '../scripts/controllers/Sysadmin/UserMgmt/userMgmtContoller.js',
              '../scripts/controllers/Sysadmin/UserMgmt/userMgmtQryController.js',
              '../scripts/controllers/Sysadmin/UserMgmt/userMgmtEditController.js',
              '../scripts/directives/multiselect/multiselect.js',
              '../scripts/factory/userService.js',
              '../scripts/factory/roleService.js'
              ]
            })
          }
        }
      })
      .state('dashboard.product',{
        url:'/product',
        controller: 'productCtrl',
        templateUrl:'./prepareForInvest/elementInput/productList.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'sbAdminApp',
              files:[
              '../scripts/controllers/prepareForInvest/elemInput/productController.js', 
              '../scripts/factory/productElemService.js'
              ]
            })
          }
        }
      })
      .state('dashboard.productEdit',{
        url:'/productEdit/:productId',
        controller: 'productEditCtrl',
        templateUrl:'./prepareForInvest/elementInput/productEdit.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'sbAdminApp',
              files:[
              '../scripts/controllers/prepareForInvest/elemInput/productEditController.js',
              '../scripts/controllers/prepareForInvest/elemInput/prodBasicController.js',
              '../scripts/controllers/prepareForInvest/elemInput/prodInfoController.js', 
              '../scripts/controllers/prepareForInvest/elemInput/prodIncomeController.js', 
              '../scripts/controllers/prepareForInvest/elemInput/prodCorpController.js', 
              '../scripts/controllers/prepareForInvest/elemInput/prodCreditRatingController.js', 
              '../scripts/controllers/prepareForInvest/elemInput/prodOtherController.js', 
              '../scripts/controllers/popup/tradeInfoController.js', 
              '../scripts/factory/productElemService.js',
              '../scripts/factory/dictService.js',
              '../scripts/directives/multiselect/multiselect.js'
              ]
            })
          }
        }
      })
     .state('dashboard.sysConfig',{
        url:'/sysConfig',
        controller: 'sysConfigCtrl',
        templateUrl:'./sysAdmin/sysConfig/sysConfig.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'sbAdminApp',
              files:[
              '../scripts/controllers/Sysadmin/sysConfigController.js'
              ]
            })
          }
        }
      })
  }])

    
