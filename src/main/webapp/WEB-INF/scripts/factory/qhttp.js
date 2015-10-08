'use strict';

/**
 * @ngdoc factory
 * @CopyRight:icbc
 * @Description:enclosure all the http-ajax invoking
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.07
 * 
 */
angular.module('sbAdminApp')
.factory('RoleInfo', ['$http', '$q', function ($http, $q) {

  return {
	  
	  queryall : function() {  
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', url: '../role/getAllRoleList'}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  }
  };  
}])
.factory('UserInfo', ['$http', '$q', function ($http, $q) {

  return {
	  
	  queryBasicInfo : function(params) {  
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', url: '../user/getUsersByCondition',params:params}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  queryRoleInfo : function(params) {  
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', url: '../user/getUserRoleList',params:params}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },

	  remove: function(params){
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', url: '../user/deleteUser',params:params}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise; 
	  },
	  
	  save: function(params){
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', url: '../user/saveUser',params:params}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise; 
	  }
		  
  };  
}])
; 