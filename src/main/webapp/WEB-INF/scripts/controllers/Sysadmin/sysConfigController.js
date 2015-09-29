'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('sbAdminApp')
.controller('sysConfigCtrl', ['$scope', function (scope) {
	scope.getSettings=function($scope){
			$.ajax({
				url : '../getSysConfig',
				type : "POST",
				data : {
				},
				cache : false,
				success : function(data) {
					scope.oldSettings=data;
					scope.projectPayAlertDays=data.projectPayAlertDays;
				    scope.reportAlertDays=data.reportAlertDays;
				},
				error : function() {
				}
			});}
	
	scope.reset=function($scope){
		scope.projectPayAlertDays=scope.oldSettings.projectPayAlertDays;
	    scope.reportAlertDays=scope.oldSettings.reportAlertDays;}
	scope.saveChanges=function($scope){
		var loginErrorMsg = $('#setting-error-msg');
		$.ajax({
			url : '../setSysConfig',
			type : "POST",
			data : {projectPayAlertDays:'12',
				    reportAlertDays:'130'
			},
			cache : false,
			success : function(data) {
				loginErrorMsg.html("<p style='color: #419088;'>保存成功</p>");
			},
			error : function() {
				loginErrorMsg.html("<p style='color: #FD7A50;'>保存失败</p>");
			}
	     });
		}
}]);