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
.factory('RoleService', ['$http', '$q', function ($http, $q) {

  return {
	  
	  queryall : function() {  
		  var deferred = $q.defer();
		  
		  $http.post('../role/getAllRoleList',params).
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
.factory('UserService', ['$http', '$q', function ($http, $q) {

  return {
	  
	  queryBasicInfo : function(params) {  
		  var deferred = $q.defer();
		  
		  $http.post('../user/getUsersByCondition',params).
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
		  
		  $http.post('../user/getUserRoleList',params).
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
		  
		  $http.post('../user/deleteUser',params).
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
		  
		  $http.post('../user/saveUser',params).
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