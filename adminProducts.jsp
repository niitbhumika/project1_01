<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script type="text/javascript">

var app = angular.module('myApp', []);
 
function MyController($scope, $http) {
	 $scope.sortType = 'name'; // set the default sort type
	  $scope.sortReverse = false;  // set the default sort order
	  $scope.searchPTitle = '';
	  
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.prod = data;  
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });
        };
};
</script>
</head>
<body>
<div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">

  <form>
 <!--  Search option -->
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
       <input type="text" class="form-control" placeholder="Search Product Name" ng-model="searchPTitle">      
       </div>      
    </div>
  </form>
  <table class="table table-hover" style="min-width:1200px">
  <!--  Table header section -->
   <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'prod_id'; sortReverse = !sortReverse">
            Product Id 
            <span ng-show="sortType == 'prod_id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'prod_id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'prod_name'; sortReverse = !sortReverse">
            Product Name 
            <span ng-show="sortType == 'prod_name' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'prod_name' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'quantity'; sortReverse = !sortReverse">
          Quantity
            <span ng-show="sortType == 'quantity' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'quantity' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'prod_price'; sortReverse = !sortReverse">
          Price
            <span ng-show="sortType == 'prod_price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'prod_price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Image
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         </tr>
    </thead>
    
    <!-- showing product details -->
     <tbody>
      <tr ng-repeat="p1 in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
           		<td>{{p1.prod_id}}</td>
           		<td>{{p1.prod_name}}</td>
           		<td>{{p1.quantity}}</td>
           		<td>{{p1.prod_price}}</td>
           		<td><img src="resources/images/{{p1.prod_name}}.jpg" style="height:100px;width:100px"></td>
           		
   
       <td><a href="deleteProducts&{{p1.prod_id}}">Delete</a></td>
        <td><a href="updateProducts&{{p1.prod_id}}">Edit</a></td> 
 
     <td><a href="Productdetails?id={{p1.prod_id}}">View All</a></td>  
    
      </tr>
    </tbody> 
    
  </table>
  <center><h3 style="color:blue;"><a href="addProducts">Back</a></h3></center>
</body>
</html>


 <%@ include file="footer.jsp"%>


      