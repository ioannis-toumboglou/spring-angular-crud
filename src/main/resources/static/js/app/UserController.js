'use strict';
 
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    $scope.user = {
    			 id: null, 
    			 name: '', 
    			 age: '', 
    			 email: ''
    			};
    $scope.users = [];
    
    $scope.submit = submit;
    $scope.edit = edit;
    $scope.remove = remove;
    $scope.reset = reset;
 
 
    fetchAllUsers();
 
    function fetchAllUsers() {
        UserService.fetchAllUsers()
            .then(
            function(d) {
            	$scope.users = d;
                console.log($scope.users);
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
    function createUser(user) {
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse) {
                console.error('Error while creating User');
            }
        );
    }
 
    function updateUser(user, id) {
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse) {
                console.error('Error while updating User');
            }
        );
    }
 
    function deleteUser(id) {
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse) {
                console.error('Error while deleting User');
            }
        );
    }
 
    function submit() {
        if ($scope.user.id === null) {
            console.log('Saving New User:', $scope.user);
            createUser($scope.user);
        } else {
            updateUser($scope.user, $scope.user.id);
            console.log('User updated with id:', $scope.user.id);
        }
        reset();
    }
 
    function edit(id) {
        console.log('Id to be edited:', id);
        for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === id) {
            	$scope.user = angular.copy($scope.users[i]);
                break;
            }
        }
    }
 
    function remove(id) {
        console.log('Id to be deleted:', id);
        if ($scope.user.id === id) { 
            reset();	//clean form if the user to be deleted is shown there.
        }
        deleteUser(id);
    }
 
    function reset() {
    	$scope.user={id:null, name:'', age:'', email:''};
        $scope.myForm.$setPristine();	//reset Form
    }
 
}]);