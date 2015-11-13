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
		  
		  $http.post('../role/getAllRoleList').
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