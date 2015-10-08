(function(angular) {

	var AppController = function($scope, Person) {
		Person.query(function(response) {
			$scope.people = response ? response : [];
		});

		$scope.addPerson = function(name) {
			new Person({
				name : name
			}).$save(function(person) {
				$scope.people.push(person);
			});
			$scope.newPerson = "";
		};

		$scope.updatePerson = function(person) {
			person.$update();
		};

		$scope.deletePerson = function(person) {
			person.$remove(function() {
				$scope.people.splice($scope.people.indexOf(person), 1);
			});
		};
	};

	AppController.$inject = [ '$scope', 'Person' ];
	angular.module("myApp.controllers").controller("AppController",
			AppController);

	var FamilyController = function($scope, Family) {
		Family.query(function(response) {
			$scope.families = response ? response : [];
		});

		$scope.addFamily = function(name) {
			new Family({
				name : name
			}).$save(function(family) {
				$scope.families.push(family);
			});
			$scope.newFamily = "";
		};

		$scope.updateFamily = function(family) {
			family.$update();
		};

		$scope.deleteFamily = function(family) {
			family.$remove(function() {
				$scope.families.splice($scope.families.indexOf(family), 1);
			});
		};
	};

	FamilyController.$inject = [ '$scope', 'Family' ];
	angular.module("myApp.controllers").controller("FamilyController",
			FamilyController);

	var FamilyGroupController = function($http, $scope, $routeParams,
			FamilyGroup) {

		$scope.familyId = $routeParams.familyId;
		$http.get('http://localhost:8080/families/' + $scope.familyId).success(
				function(response) {
					$scope.family = response;
				});

		$http.get(
				'http://localhost:8080/families/' + $scope.familyId
						+ '/getPeople').success(function(response) {
			$scope.people = response;
		});

		$scope.addPerson = function(id, personId) {
			$http.post(
					'http://localhost:8080/families/' + id + '/addPerson/'
							+ personId).success(function(response) {
				$scope.people.push(response.person);
				$scope.personId = ""
			});
		};

	};
	FamilyGroupController.$inject = [ '$http', '$scope', '$routeParams',
			'FamilyGroup' ];
	angular.module("myApp.controllers").controller("FamilyGroupController",
			FamilyGroupController);

}(angular));