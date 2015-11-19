'use strict';
/**
 * @ngdoc controller
 * @CopyRight:icbc
 * @Description:dept risk verify management edit controller
 * @CreatedBy:lufeng
 * @Date:2015.11.05
 * 
 */
angular.module('sbAdminApp')
.controller('deptRiskEditCtrl', ['$scope','$state','TaskInWaitService','DeptRiskService', function($scope,$state,TaskInWaitService,DeptRiskService){
	$scope.deptRisk = {};
	var params = {};
	$scope.$watch('eidtDeptRisk.taskId',function(){
		//初始化项目类型－下拉框
		/*DeptRiskService.queryall().then(
			function(result){
				$scope.options = result;
			},
			function(result){
				$scope.options = [];
			});*/
		if('edit' == $scope.operType){
			$scope.deptRisk = $scope.eidtDeptRisk;
			//检出时,如果项目操作状态是检出，则要先进行状态转换，将“检出”转为“处理”
			//var params = {taskId:$scope.deptRisk.taskId};
			params.taskId = $scope.deptRisk.taskId;
			if("1" == $scope.deptRisk.operFlag){
				//检出状态修改为处理状态
				TaskInWaitService.takeTask(params);
			}
			//给要审核的项目信息赋一些初始化的值
			$scope.deptRisk.compliance = "0";
			$scope.deptRisk.lawyer = "1";
			$scope.deptRisk.credit = "1";
		}
	});
	//暂存
	$scope.onPreSave = function(){
		var params = {};
		params.taskId = $scope.deptRisk.taskId;
		params.compliance = $scope.deptRisk.compliance;
		params.lawyer = $scope.deptRisk.lawyer;
		params.credit = $scope.deptRisk.credit;
		params.remark = $scope.deptRisk.remark;
		
		DeptRiskService.onPreSave(params)
		.then(function(){
					alert('save sucessfully');
					//重新加载数据
					$state.reload();
				},
			  function(){
					alert('save failed');
				}
		);
	};
	//保存，之后要做状态流转
	$scope.onSave = function(){
		var params = {};
		params.taskId = $scope.deptRisk.taskId;
		params.compliance = $scope.deptRisk.compliance;
		params.lawyer = $scope.deptRisk.lawyer;
		params.credit = $scope.deptRisk.credit;
		params.remark = $scope.deptRisk.remark;
		//驱动工作流参数
		params.WKF_TASK_ID = $scope.deptRisk.taskId;
		params.WKF_RPODUCT_ID = $scope.deptRisk.productId;
		
		DeptRiskService.verifyDeptRisk(params)
		.then(function(){
					alert('save sucessfully');
					//重新加载数据
					$state.reload();
				},
			  function(){
					alert('save failed');
				}
		);
	};
	
}]);
