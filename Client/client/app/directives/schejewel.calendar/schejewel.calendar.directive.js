'use strict';

angular.module('schejewelApp')
	.directive('schejewel.calendar', function () {
		return {
			templateUrl: 'app/directives/schejewel.calendar/schejewel.calendar.html',
			restrict: 'EA',
			scope: {
				visibleDirective: '='
			},
			link: function ($scope) {
				$('#calendar').fullCalendar({
					allDaySlot: false,
					dayClick: function (date, allDay, jsEvent, view) {
						angular.element($('#buttonNav')).scope().setVisible('resource');
						$scope.$apply();
					}
				});
			}
		};
	});
