<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<script type="text/javascript" src="./js/app.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS</title>
</head>
<body>
	<h1>Welcome to Account Management System!</h1>
<div ng-app="AccountManagementSystem" ng-controller="AccountManagementController">
	
	<div id="indexPage" ng-show="toggleIndex">
		<h2>This is index page</h2>
		<div id="header">
			<button ng-click="showAddPage()">Add</button>
		</div>
		<div id="content">
			<table>
				<tr ng-repeat="e in records">
					<td>{{e.name}}</td>
					<td>{{e.age}}</td>
					<td><button ng-click="showEditPage(e)">Edit</button></td>
					<td><button ng-click="deleteRecord(e)">Delete</button></td>
				</tr>
			</table>
		</div>
	</div>
	
	<div id="addPage" ng-show="toggleAdd">
		<h2>This is add page</h2>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" ng-model="name"/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" ng-model="age"/></td>
			</tr>
			<tr>
				<td><br/><button ng-click="addRecord()">Add</button></td>
			</tr>
		</table>			
		<button ng-click="back()">Back</button>
	</div>
	
	<div id="editPage" ng-show="toggleEdit">
		<h2>This is edit page</h2>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" ng-model="name" placeholder="{{editedName}}"/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" ng-model="age" placeholder="{{editedAge}}"/></td>
			</tr>
			<tr>
				<td><br/><button ng-click="updateRecord()">Update</button></td>
			</tr>
		</table>
		<button ng-click="back()">Back</button>
	</div>
	
</div>

</body>
</html>