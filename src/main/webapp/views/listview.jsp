<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="site-wrapper">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<p class="lead">
				<span class="ciclefina xlarg">Users List</span>
			</p>
		</div>
	</div>
	<div class="well">
		<input type="text" placeholder="Search" ng-model="userSearch" class="form-control ng-pristine ng-valid ng-touched">
	</div>
	<div class="row">
		<div class="bs-example" data-example-id="hoverable-table">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Date Of Birth</th>
						<th>Commands</th>
					</tr>
				</thead>
				<tbody>
					 <tr ng-repeat="user in listCtrl.users | filter:  userSearch">
					 	<td>
					 		{{user.id}}
					 	</td>
				        <td>
				            {{user.firstName}} 
				        </td>
				        <td>
				            {{user.lastName}} 
				        </td>
				        <td>
				            {{user.dateOfBirth}} 
				        </td>
				        <td width='50'>
				        	<div class='col-lg-1'><a ng-href="#/list" ng-click="deleteUser(user.id)" ><span aria-hidden='true' class='margin glyphicon glyphicon-remove'></span></a></div>
				        	<div class='col-lg-1'><a ng-href="#/{{user.id}}" ng-click="editUser(user.id)" ><span aria-hidden='true' class='margin glyphicon glyphicon-new-window'></span></a></div>
				        </td >
				</tbody>
			</table>
		</div>
	</div>
	<div style="padding:10px 1px 50px 1px;text-align: right;">
			<a href="#/" id="btnHome" class="btn btn-lg  ">Home</a>
	</div>
</div>