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
.factory('DictService', ['$http', '$q', function ($http, $q) {

  return {
	  
	  query : function(params) {  
		  var deferred = $q.defer();
		  
		  $http.post('../dict/getDictItemList',params).
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