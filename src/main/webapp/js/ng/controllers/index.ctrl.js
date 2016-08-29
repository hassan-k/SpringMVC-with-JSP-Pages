(function () {

	var  appindexctrl = angular.module('index.ctrl',[])
 
	
	appindexctrl.controller("homeController", [ '$http', '$scope', '$routeParams', userSave]);
	 	
		function userSave($http, $scope,$routeParams){
	    	var urlBase = '/fispan/api';
			
	    	$scope.addNewUser = function (){
			   	$http.post(urlBase + '/user/create', {
			   		id:null,
	    	   		firstName: $scope.model.firstName,
	    	   		lastName:$scope.model.lastName,
	    	   		dateOfBirth:$scope.model.dateOfBirth
				 })
				 .success(function(data, status, headers) {
						alert("User added");
				  })
				  .error(function(data, status, headers) {
						alert(status);
				  });
	    	};

	}

	
	appindexctrl.controller('listController', ['$routeParams', 'userDataProvider', '$window', '$scope','$http', userListController]);

	 function userListController($routeParams, userDataProvider , $window ,$scope,$http) {
	 	 var ctrl = this;
	     var user;
	     var urlBase = '/fispan/api';
	     var promise = userDataProvider.getUsers();
	     promise.then(function(result) {
	         	ctrl.users = result;
	
	         },
	         function(error){
	             //failed to get the product - go back to list
	             //$window.location = "#/";
	        	 alert(error);
	         }
	       );
	     
	     $scope.deleteUser = function deleteUser(id){
	     	
	     	$http.get(urlBase + '/user/delete/' + id, {
	     		
	     	}).
				success(function(data, status, headers) {
					alert(data.message);
				});
	     };
	 }
	 
	 var convertDates = function(input) {
   	  for(var key in input) {
   	    if (!input.hasOwnProperty(key)) continue;

   	    if (typeof input[key] === "object") {
   	      convertDates(input[key]);
   	    } else {
   	      if (typeof input[key] === "string" && /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}$/.test(input[key])) {
   	        input[key] = new Date(input[key]);
   	      }
   	    }
   	  }
   	}

	
})();