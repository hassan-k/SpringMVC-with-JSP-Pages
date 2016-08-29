(function () {
    angular.module('index.config', ['ngRoute']).config(function ($routeProvider) {
        $routeProvider
        	.when('/',{
                templateUrl: "views/homeview.jsp" 
                ,controller: "homeController"
                ,controllerAs: "homeCtrl"
            })
            .when('/list',{
                templateUrl: "views/listview.jsp" 
                ,controller: "listController"
                ,controllerAs: "listCtrl"
            })
        	.otherwise({redirectTo:"/"});
    });
})();