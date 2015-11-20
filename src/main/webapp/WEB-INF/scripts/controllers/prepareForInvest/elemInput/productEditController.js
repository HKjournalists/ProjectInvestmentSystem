'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description: prodcut list query controller
 * @CreatedBy:Yuezhi.Liu
 * @Date:2015.10.04
 * 
 */


angular.module('sbAdminApp')
.controller('productEditCtrl', ['$scope','$q','$filter','$state','ProductElemService',function($scope,$q,$filter,$state, productElemService){
	
	$scope.elementFlag = {basic:false,prodinfo:false,income:false,corporation:false,creditrate:false,other:false};
	
	$scope.element = {};
	
	var status = 1;
	
	$scope.onSwitch = function(tab)
	{
		$scope.tabType = tab;
	}

	$scope.setElement = function(obj)
	{
		for(var key in obj){
			
			$scope.element[key] = obj[key];
		}
		
		//var jsonStr = $filter('json')($scope.element);
		
		//alert(jsonStr);
	}
	
	$scope.onSave = function(){
		
		$scope.$broadcast('EVT_SAVE');
		
		status = 1;
	}
	
	$scope.$on('EVT_SAVE_DONE', function(event,data){
		//react on the location change here
		
		event.stopPropagation();
		
		var k = data.evtSrc;
		$scope.elementFlag[k] = true;
		
		var ret = false;
		
		for(var key in $scope.elementFlag){
			
			ret = $scope.elementFlag[key];
			
			if(ret != true){
				
				ret = false;
				
				break;
			}
		}
		
		if(ret == true){
			
			alert('done');
			$scope.element['status'] = status;
			productElemService.saveProductElement($scope.element);
			for(var key in $scope.elementFlag){
				
				$scope.elementFlag[key] = false;
				
			}
		}
			

	});
}]);
