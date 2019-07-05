/**
 * 
 */

var app = angular.module('myModule', ['ngRoute']);
    app.config(function ($routeProvider) {
        $routeProvider
        .when('/', {
          templateUrl:'index.html'
        })
        .when('/landing',     {
        templateUrl:'landing.html'
        })
        .otherwise({
        redirectTo:'/'
        });
         });
    
         //Controller Part
          app.controller('myController', function( $scope, $http,$window) {
      	 
        	  $scope.loginformvisible=true;
        	  $scope.isVisible=false;
        	  $scope.pwdmsg="";
        	  $scope.userform = {
                  username : "",
                  password : "",
                  accno:"",
                  amount: ""
             }
              $scope.submit_userform = function() {
                
                	  var method = 'POST';
                	  var    url = 'rest/AccountService/onlinepayment';
                
                  $http({
                      method : method,
                      url : url,
                      data : angular.toJson($scope.userform),
                      headers : {
                          'Content-Type' : 'application/x-www-form-urlencoded'
                      }
                  }).then(function successCallback(response){
               	     $scope.resvalue=response.data;
               
    				 	 $scope.loginformvisible=false;
    				 	 $scope.isVisible=true;  
                    }, function errorCallback(response){
                        alert("Wrong Username or Password. Try Again");
                        console.log("POST-ing of data failed");
                   
		            });
                
              };
          });