'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description: homeCtrl
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.04
 * 
 */


angular.module('sbAdminApp')
.controller('homeCtrl',['$scope','$state',function($scope,$state){
	
	$scope.mode = "taskinwait";

	
	$scope.$on('EVT_GOTO',function(event,data){

		event.stopPropagation();
		
		alert(data.mode);
		
		$scope.mode = data.mode;
	});
}])


;
 

