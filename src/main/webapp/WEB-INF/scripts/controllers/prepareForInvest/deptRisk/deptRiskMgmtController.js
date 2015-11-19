'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description:main controller of dept risk verify management 
 * @CreatedBy:lufeng
 * @Date:2015.11.05
 * 
 */


angular.module('sbAdminApp')
.controller('deptRiskCtrl',function($scope,$state){
	$scope.operType = "qry";
	//初始化项目类型－下拉框
	/*DeptRiskService.queryall().then(
		function(result){
			$scope.options = result;
		},
		function(result){
			$scope.options = [];
		});*/
	
	$scope.onEditDeptRisk = function onEditDeptRisk(deptRisk){
		$scope.eidtDeptRisk = deptRisk;
		$scope.operType = "edit";
	};
	
	$scope.onCancel = function(){
		$scope.operType = "qry";
		$state.reload();
	}
});
 

