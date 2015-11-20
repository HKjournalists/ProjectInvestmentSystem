'use strict';

/**
 * @ngdoc factory
 * @CopyRight:icbc
 * @Description:enclosure all the http-ajax invoking
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.11.03
 * 
 */
 
angular.module('sbAdminApp')
.factory('ProductElemService', ['$http', '$q', function ($http, $q) {

  return {
	  
	  query : function(params) {  
		  var deferred = $q.defer();
		  
		  $http.post('../productelem/getProductListByCondition',params).
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  genProductID : function() {  
		  var deferred = $q.defer();
		  
		  $http.post('../productelem/genProductId').
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  saveProductElement : function(params) {  
		  var deferred = $q.defer();
		  
		  $http.post('../productelem/saveProductElement',params).
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  queryProductElementById : function(params) {  
		  var deferred = $q.defer();
		  
		  $http.post('../productelem/queryProductElementById',params).
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