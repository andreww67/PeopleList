(function(angular) {
	var PersonFactory = function($resource) {
		return $resource('/people/:id', {
			id : '@id'
		}, {
			update : {
				method : "PUT"
			},
			remove : {
				method : "DELETE"
			}
		});
	};
	PersonFactory.$inject = [ '$resource' ];
	angular.module("myApp.services").factory("Person", PersonFactory);

	var FamilyFactory = function($resource) {
		return $resource('/families/:id', {
			id : '@id'
		}, {
			update : {
				method : "PUT"
			},
			remove : {
				method : "DELETE"
			}
		});
	};

	FamilyFactory.$inject = [ '$resource' ];
	angular.module("myApp.services").factory("Family", FamilyFactory);

	var FamilyGroupFactory = function($http) {
		return {
		// getFamilies: function(callback) {
		//      $http.get('families/').success(callback);
		//  }
		//	getFamilyPeople: function(id) {
		//    $http.get('/families/'+id+'/getPeople');
		// }
		}
	};

	FamilyGroupFactory.$inject = [ '$http' ];
	angular.module("myApp.services").factory("FamilyGroup", FamilyGroupFactory);
}(angular));