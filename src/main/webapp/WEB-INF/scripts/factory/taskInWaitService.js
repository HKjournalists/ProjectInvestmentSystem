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
.factory('TaskInWaitService',['$http','$q',function($http, $q){
	
	return {
		getTasks: function(params){
			
			var deferred = $q.defer();
			params.rdm = Math.random();
			$http.post('../taskInWait/getTasks',params).
			success(function(data, status, headers, config){
				deferred.resolve(data);
			}).
			error(function(data, status, headers, config){
				deferred.reject(data);
			});
			
			return deferred.promise;
		},
	
		takeTask: function(params)
		{
			var deferred = $q.defer();
			
			$http.post('../taskInWait/takeTask',params).
			success(function(data, status, headers, config){
				deferred.resolve(data);
			}).
			error(function(data, status, headers, config){
				deferred.reject(data);
			});
			
			return deferred.promise;
		}
	};
}])