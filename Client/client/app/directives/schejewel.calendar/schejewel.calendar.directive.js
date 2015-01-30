'use strict';

angular.module('schejewelApp')
  .directive('schejewel.calendar', function () {
    return {
      templateUrl: 'app/directives/schejewel.calendar/schejewel.calendar.html',
      restrict: 'EA',
      link: function (scope, element, attrs) {
      }
    };
  });