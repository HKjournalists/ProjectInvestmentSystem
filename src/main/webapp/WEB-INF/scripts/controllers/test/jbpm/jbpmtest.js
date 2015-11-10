angular.module('sbAdminApp')
.controller('jbpmTestCtrl', ['$scope','jbpmInfo',function($scope, jbpmInfo){
 
	$scope.query = function(){
		jbpmInfo.queryall().then(
				function(result){
					$scope.tasklist = result;
				})
				.then(jbpmInfo.queryTaskInWaiting())
				.then(function(result){
					$scope.taskinwaitinglist = result;
				});
		
		jbpmInfo.queryTaskInWaiting().then(
				function(result){
					$scope.taskinwaitinglist = result;
				},
				function(result){
					$scope.taskinwaitinglist = [];
				});
	};
	
	$scope.go = function(productid,taskid)
	{
//		jbpmInfo.go({a:Math.random(),WKF_TASK_ID:taskid,WKF_RPODUCT_ID:productid}).then(
//				function(result){
//					
//				},
//				function(result){
//				});
 
		jbpmInfo.go({a:Math.random(),WKF_TASK_ID:taskid,WKF_RPODUCT_ID:'NP20151030'})
			.then(jbpmInfo.queryall)
			.then(function(result){$scope.tasklist = result;})
			.then(jbpmInfo.queryTaskInWaiting())
			.then(function(result){$scope.taskinwaitinglist = result;});
	}
	
}])
//.factory('jbpmInfo', ['$http', '$q', function ($http, $q) {
//
//  return {
//
//	  queryTaskInWaiting : function() {  
//		  //var deferred = $q.defer();
//		  
//		  var promise = $http({method: 'GET', cache : false,url: '../jbpmtest/getTaskInWaiting',params:{a:Math.random(),user_id:'000881815'}}).  
//		  success(function(data, status, headers, config) {  
//			  deferred.resolve(data); 
//		  }).  
//		  error(function(data, status, headers, config) {  
//			  deferred.reject(data);  
//		  });  
//		  
//		  return promise;
//		  //return deferred.promise;  
//	  },
//	  
//	  queryall : function() {  
//		  //var deferred = $q.defer();
//		  
//		  var promise = $http({method: 'GET', cache : false,url: '../jbpmtest/getAllTask',params:{a:Math.random(),WKF_TASK_ID:8,WKF_RPODUCT_ID:'NPNA001'}}).  
//		  success(function(data, status, headers, config) {  
//			  deferred.resolve(data); 
//		  }).  
//		  error(function(data, status, headers, config) {  
//			  deferred.reject(data);  
//		  });  
//		  
//		  return promise;
//		  //return deferred.promise;  
//	  },
//	  
//	  go : function(params){
//		  //var deferred = $q.defer();
//		  
//		  var promise = $http({method: 'GET',cache:false, url: '../jbpmtest/start',params:params}).  
//		  success(function(data, status, headers, config) {  
//			  deferred.resolve(data); 
//		  }).  
//		  error(function(data, status, headers, config) {  
//			  deferred.reject(data);  
//		  });  
//		  
//		  return promise;
//		  //return deferred.promise; 
//	  }
//  };  
//}])
.factory('jbpmInfo', ['$http', '$q', function ($http, $q) {

  return {

	  queryTaskInWaiting : function() {  
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', cache : false,url: '../jbpmtest/getTaskInWaiting',params:{a:Math.random(),user_id:'000881815'}}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  queryall : function() {  
		  var deferred = $q.defer();
		  
		  $http({method: 'GET', cache : false,url: '../jbpmtest/getAllTask',params:{a:Math.random(),WKF_TASK_ID:8,WKF_RPODUCT_ID:'NPNA001'}}).  
		  success(function(data, status, headers, config) {  
			  deferred.resolve(data); 
		  }).  
		  error(function(data, status, headers, config) {  
			  deferred.reject(data);  
		  });  
		  
		  return deferred.promise;  
	  },
	  
	  go : function(params){
		  var deferred = $q.defer();
		  
		  $http({method: 'GET',cache:false, url: '../jbpmtest/start2',params:params}).  
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