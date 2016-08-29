<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="site-wrapper">
	<div class="row">
	    <div class="col-md-1"></div>
	    <div class="col-md-6">
			<p class="lead">
				<span class="ciclefina xlarg">Save/Edit User</span>
			</p>
		</div>
	</div>
	<div class="row">
		<div style="border-left:1px dotted #e3e3df;padding:20px;" >
				<div class="">
						<div class="form-group">
							<label for="firstName">First Name</label>
							<input type="text" class="form-control" id="firstName"  ng-model="model.firstName" placeholder="First Name" required="required">
			<%-- 				<span ng-show="!model.firstName">Sorry, the field is empty!</span>
                                <span ng-hide="!model.firstName"></span>   --%>
						</div>
						
						<div class="form-group">
							<label for="lastName">Last Name</label>
							<input type="text" class="form-control"  ng-model="model.lastName" id="lastName" placeholder="Last Name" required="required">
						</div>
						<div class="form-group">
							<label for="dateOfBirth">Date Of Birth</label>
							<input type="text" class="form-control"  ng-model="model.dateOfBirth" id="dateOfBirth" placeholder="Date Of Birth" required="required">
						</div>
				</div>
				<div style="padding:10px 1px 50px 1px;text-align: right;">
					<input type="button" id="btnCreate" class="btn btn-lg btn-success" value="addNewUser" ng-click="addNewUser()" >
					<a href="#/list" id="btnList" class="btn btn-lg  " >List</a>
				</div>
			</div>
	</div>
</div>
<script>
  $( function() {
    $( "#dateOfBirth" ).datepicker({
    	  dateFormat: "yy-mm-dd"
    });
  } );
  </script>