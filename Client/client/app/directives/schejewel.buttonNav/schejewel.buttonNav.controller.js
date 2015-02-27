'use strict';

angular.module('schejewelApp')
    .controller('ButtonController', ['$scope', function($scope) {

        $scope.hidden = true;
        $scope.appear = function(){
            $scope.hidden = !$scope.hidden; 
             $scope.$apply();
        };
        $scope.Calendar = function(){
            $scope.ShowCalendarView();
            $scope.HideTripView();
            $scope.HideResourceView();
        }
        $scope.ResourceView = function(){
            $scope.ShowResourceView();
            $scope.HideTripView();
            $scope.HideCalendarView();
        }
        $scope.TripView = function(){
            $scope.ShowTripView();
            $scope.HideResourceView();
            $scope.HideCalendarView();
        }
        $scope.HideResourceView = function(){

        }
        $scope.ShowResourceView = function(){

        }
        $scope.HideTripView = function(){

        }
        $scope.ShowTripView = function(){

        }
        $scope.HideCalendarView = function(){
            $('#calendar').hide();
        }
        $scope.ShowCalendarView = function(){
            $('#calendar').show();
        }
}]);