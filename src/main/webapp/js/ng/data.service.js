(function () {
    angular.module('index').factory('userDataProvider', ['$http', '$q', '$log',  userDataProvider ]);  
        
    function userDataProvider($http,$q, $log){
        	var urlBase = '/fispan/api';
        	var _isInit = false;
        	var _users = [];
        	
        	var _isReady = function () {
                return _isInit;
            }
        	
            var _getUsers = function () {
            	var deferred = $q.defer(); 
            	//$http.get(urlBase + "data/user.json")
            	$http.get(urlBase + '/user/list/') 
            	 .then(
            		function (result) {
   	                    angular.copy(result.data, _users); //successful get
	                    _isInit = true;
	                    deferred.resolve(_users);
            		 },function (error) {
	                     $log.error('Fail to load');
	                     deferred.reject();
	                 });
                 return deferred.promise;
            }
            
            return {
            	users: _users,
            	getUsers:_getUsers,
            	isReady: _isReady
            }
        }
 

})();