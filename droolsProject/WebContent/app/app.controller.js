(function(){
	'use strict'
	
	angular.module('app')
		   .controller("appControler", appController);
		   
	appController.$inject = ['$window','$scope','Info'];
	function appController($window,$scope,Info) {
		
		$scope.trigerRule = function(){
			Info.save().then(function(response){
				$scope.paket1 = response.data.cenaPaketa1
				$scope.paket2 = response.data.cenaPaketa2
				$scope.paket3 = response.data.cenaPaketa3
			});
		}
	}
})();