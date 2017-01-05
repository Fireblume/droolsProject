(function(){
	'use strict'
	
	angular.module('app')
		   .controller("appController", appController);
		   
	appController.$inject = ['$window','$scope','Info'];
	function appController($window,$scope,Info) {
		
		$scope.trigerRule = function(){
			Info.save((JSON.stringify({proba : "proba"}), onSaveSuccess));
		}
		
		function onSaveSuccess (result) {
            $scope.paket1 = result.cenaPaketa1
			$scope.paket2 = result.cenaPaketa2
			$scope.paket3 = result.cenaPaketa3
        }
	}
})();