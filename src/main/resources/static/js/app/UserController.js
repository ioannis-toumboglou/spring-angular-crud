'use strict';
 
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user = {
  			 id: null, 
  			 name: '', 
  			 age: '', 
  			 email: ''
  			};
    self.users = [];
    
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    $scope.isListEmpty = null;
 
 
    fetchAllUsers();
 
    function fetchAllUsers() {
        UserService.fetchAllUsers()
            .then(
            function(d) {
            	self.users = d.content;
            	$scope.isListEmpty = self.users[0].name ? false : true;
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
 
    function updateUser(user) {
    	let id = extractId(user);
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
        if (self.user.id === null) {
            createUser(self.user);
            console.log('Saving New User:', self.user);
        } else {
            updateUser(self.user);
            let id = extractId(self.user);
            console.log('User updated with id:', id);
        }
        reset();
    }
 
    function edit(user) {
    	let id = extractId(user);
        console.log('Id to be edited:', id);
        self.user = user;
        self.user.id = id;
    }
 
    function remove(user) {
    	let id = extractId(user);
        console.log('Id to be deleted:', id);
        if (self.user.id === id) { 
            reset();	//clean form if the user to be deleted is shown there.
        }
        deleteUser(id);
    }
 
    function reset() {
    	self.user = {id:null, name:'', age:'', email:''};
    	$scope.myForm.$setPristine();	//reset Form
    }
    
    function extractId(user) {
    	let url = user.links[1].href.split("/");
    	let id = url[url.length-1];
    	return id;
    }
}]);