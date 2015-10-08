(function(angular) {
	angular.module("myApp.controllers", []);
	angular.module("myApp.services", []);
	var myApp = angular.module("myApp", [ "ngRoute", "ngResource",
			"myApp.controllers", "myApp.services" ]);
	myApp.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/familyGroup/:familyId', {
			templateUrl : '/familyGroup.html',
			controller : 'FamilyGroupController'
		}).when('/peopleList', {
			templateUrl : '/peopleList.html',
			controller : 'AppController'
		}).when('/familyList', {
			templateUrl : '/familyList.html',
			controller : 'FamilyController'
		}).otherwise({
			redirectTo : '/peopleList'
		});
	} ]);

}(angular));