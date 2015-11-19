'use strict';

/**
 * @ngdoc factory
 * @CopyRight:icbc
 * @Description:enclosure all the http-ajax invoking
 * @CreatedBy:lufeng
 * @Date:2015.10.05
 * 
 */
angular.module('sbAdminApp')
.factory('DeptRiskService', ['$http', '$q', function ($http, $q) {

  return {
	  
	  queryDeptRiskInfo : function(params) {  
		  var deferred = $q.defer();
		  $http.post('../deptrisk/getDeptRiskListByCondition',params).
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  onPreSave: function(params){
		  var deferred = $q.defer();
		  
		  $http.post('../deptrisk/onPreSave',params)
		  .success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  })
		  .error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });
		  
		  return deferred.promise; 
	  },
	  
	  verifyDeptRisk: function(params){
		  var deferred = $q.defer();
		  
		  $http.post('../deptrisk/verifyDeptRisk',params)
		  .success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  })
		  .error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });
		  
		  return deferred.promise; 
	  }
  };  
}]); 