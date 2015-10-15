angular.module('sbAdminApp')
.controller('jbpmTestCtrl', ['$scope','jbpmInfo',function($scope, jbpmInfo){
	
//	jbpmInfo.start().then(
//			function(result){
//				
//			},
//			function(result){
//			});
//	
//	jbpmInfo.queryall().then(
//			function(result){
//				$scope.tasklist = result;
//			},
//			function(result){
//				$scope.tasklist = [];
//			});
//	
	$scope.query = function(){
		jbpmInfo.queryall().then(
				function(result){
					$scope.tasklist = result;
				},
				function(result){
					$scope.tasklist = [];
				});
	};
	
	$scope.go = function(productid,taskid)
	{
		jbpmInfo.go({a:Math.random(),WKF_TASK_ID:taskid,WKF_RPODUCT_ID:productid}).then(
				function(result){
					
				},
				function(result){
				});
	}
	
}])
.factory('jbpmInfo', ['$http', '$q', function ($http, $q) {

  return {
	  
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
		  
		  $http({method: 'GET',cache:false, url: '../jbpmtest/start',params:params}).  
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