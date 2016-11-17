// Notice: the delete function here is a little special, it compares the to-deleted person's name and age with
// every record in the database, if there's any match, delete that record. It is implemented in this way for
// simplicity. A more appropriate way is to check every record's unique id.

var app = angular.module('AccountManagementSystem', []);
app.controller('AccountManagementController', function($scope, $http) {
	var urlBase="http://localhost:8080/AccountManagementSystem";
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	// define what part to show in index
    $scope.toggleIndex = true;
    $scope.toggleAdd = false;
    $scope.toggleEdit = false;
    // the input data
	$scope.name="";
	$scope.age="";
    // the selected edit data
	$scope.editedItem;
    $scope.editedName;
    $scope.editedAge;
	
    // get all tasks and display initially
//    $scope.records = [
//	                    {name:'Alice',age:42},
//	                    {name:'Bob',age:25},
//	                    {name:'Cali',age:35}
//                     ];
	$http.get(urlBase+'/persons').
	success(function(data) {
        $scope.records = data;
	});
    
	$scope.showAddPage = function showAddPage() {
	    $scope.toggleIndex = false;
	    $scope.toggleAdd = true;
	    $scope.toggleEdit = false;
	};
	
	$scope.showEditPage = function showEditPage(item) {
	    $scope.toggleIndex = false;
	    $scope.toggleAdd = false;
	    $scope.toggleEdit = true;
	    $scope.editedItem = item;
	    $scope.editedName = item.name;
	    $scope.editedAge = item.age;
	};
	
	$scope.back = function back() {
	    $scope.toggleIndex = true;
	    $scope.toggleAdd = false;
	    $scope.toggleEdit = false;
		$scope.name="";
		$scope.age="";
	};
	
	$scope.addRecord = function addRecord() {
		if($scope.name=="" || $scope.age==""){
			alert("Insufficient Data! Please provide values for name and age");
		}
		else {
			//$scope.records.push({name:$scope.name, age:$scope.age});
			$http.post(urlBase + '/persons/insert/' +$scope.name+'/'+$scope.age).
			  success(function(data) {
				 $scope.records = data;
				 alert("Record added!");
			    }).error(function(){alert("Add fail, please add a different person!")});
		}
		$scope.back();
	};
	
	$scope.deleteRecord = function deleteRecord(item) {
//		angular.forEach($scope.records, function(value, key) {
//			  if (value == item){
//				  $scope.records.splice(key,1);
//			  }
//		});
		var res = $http.delete(urlBase+'/persons/delete/'+item.name+'/'+item.age);
		res.success(function(data) {
			 $scope.records = data;
			 alert("Record deleted!");
		});
		res.error(function() {
			alert("Delete fail, record not found!");
		});
	};
	
	$scope.updateRecord = function updateRecord() {
		if($scope.name=="" || $scope.age==""){
			alert("Insufficient Data! Please provide values for name and age");
		}
		else {
//			angular.forEach($scope.records, function(value, key) {
//				  if (value == $scope.editedItem){
//					  $scope.records.splice(key,1,{name:$scope.name, age:$scope.age});
//				  }
//			});
			var obj = {name:$scope.name, age:$scope.age};
			var res = $http.put(urlBase+'/persons/update/'+$scope.editedName+'/'+$scope.editedAge, obj);
			res.success(function(data) {
				$scope.records = data;
				alert("Update success!");
			});
			res.error(function() {
				alert("Update fail!");
			});
		}
		$scope.back();
	};
});