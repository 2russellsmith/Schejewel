'use strict';

angular.module('schejewelApp')
	.directive('schejewel.tripView', function () {
		return {
			templateUrl: 'app/directives/schejewel.tripView/schejewel.tripView.html',
			restrict: 'EA',
			link: function ($scope) {
				$scope.dayHours = ['6:00', '6:30', '7:00', '7:30', '8:00', '8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '1:00', '1:30',
					'2:00', '2:30', '3:00', '3:30', '4:00', '4:30', '5:00', '5:30'
				];


				function getMinutesSince6(d) {
					var e = new Date(d);
					e.setHours(6);
					e.setMinutes(0);
					return Math.abs((e - d)) / 1000 / 60;
				}

				$scope.currentTimeStyle = function () {
					var top = getMinutesSince6(new Date()) + 83; //this 83 is the offset that the line needs to line up with the top of the page.  Probably not the best way to do it :/
					return {
						position: 'absolute',
						top: top
					};
				};

				$scope.fadeStyle = function (index, events) {
					var r = 200 - (index * 10);
					var g = 0 + (index * 25);
					var b = 0 + (index * 1);

					r = r >= 0 ? r : 0;
					g = g >= 0 ? g : 0;
					b = b >= 0 ? b : 0;

					var height = Math.abs(events[index].startTime - events[index].endTime) / 1000 / 60;

					var top = getMinutesSince6(new Date(events[index].startTime)) + 30;

					return {
						position: 'absolute',
						top: top + 'px',
						left: '0px',
						width: '100%',
						background: 'rgba(' + r + ', ' + r + ', ' + r + ', 1)',
						color: 'white',
						height: height + 'px'
					};
				};


				$scope.hourStyle = function (index) {
					var top = (index * 30);

					return {
						position: 'absolute',
						top: top + 'px'
					};
				};



				$scope.tours = [{
					title: 'Crab Fishing Tour',
					personCount: 58,
					events: [{
						title: 'Event 1',
						startTime: new Date(2015, 3, 3, 6, 0, 0),
						endTime: new Date(2015, 3, 3, 7, 0, 0),
					}, {
						title: 'Event 3',
						startTime: new Date(2015, 3, 3, 7, 0, 0),
						endTime: new Date(2015, 3, 3, 11, 0, 0),
					}, {
						title: 'Event 4',
						startTime: new Date(2015, 3, 3, 11, 0, 0),
						endTime: new Date(2015, 3, 3, 12, 0, 0),
					}, {
						title: 'Event 5',
						startTime: new Date(2015, 3, 3, 12, 0, 0),
						endTime: new Date(2015, 3, 3, 14, 0, 0),
					}, {
						title: 'Event 6',
						startTime: new Date(2015, 3, 3, 14, 0, 0),
						endTime: new Date(2015, 3, 3, 15, 0, 0),
					}, {
						title: 'Event 7',
						startTime: new Date(2015, 3, 3, 15, 0, 0),
						endTime: new Date(2015, 3, 3, 16, 0, 0),
					}, {
						title: 'Event 8',
						startTime: new Date(2015, 3, 3, 16, 0, 0),
						endTime: new Date(2015, 3, 3, 17, 0, 0),
					}, {
						title: 'Go fishing',
						startTime: new Date(2015, 3, 3, 17, 0, 0),
						endTime: new Date(2015, 3, 3, 18, 0, 0),
						resources: [{
							name: 'Blue bus',
							id: 34523,
							contactNumber: '(493)403-4930'
						}]
					}]
				}, {

					title: 'Crab Fishing Tour',
					personCount: 58,
					events: [{
						title: 'Event 1',
						startTime: new Date(2015, 3, 3, 6, 0, 0),
						endTime: new Date(2015, 3, 3, 7, 0, 0),
					}, {
						title: 'Event 2',
						startTime: new Date(2015, 3, 3, 7, 0, 0),
						endTime: new Date(2015, 3, 3, 9, 0, 0),
					}, {
						title: 'Event 3',
						startTime: new Date(2015, 3, 3, 9, 0, 0),
						endTime: new Date(2015, 3, 3, 11, 0, 0),
					}, {
						title: 'Event 4',
						startTime: new Date(2015, 3, 3, 11, 0, 0),
						endTime: new Date(2015, 3, 3, 12, 0, 0),
					}, {
						title: 'Event 5',
						startTime: new Date(2015, 3, 3, 12, 0, 0),
						endTime: new Date(2015, 3, 3, 14, 0, 0),
					}, {
						title: 'Event 6',
						startTime: new Date(2015, 3, 3, 14, 0, 0),
						endTime: new Date(2015, 3, 3, 15, 0, 0),
					}, {
						title: 'Event 7',
						startTime: new Date(2015, 3, 3, 15, 0, 0),
						endTime: new Date(2015, 3, 3, 16, 0, 0),
					}, {
						title: 'Event 8',
						startTime: new Date(2015, 3, 3, 16, 0, 0),
						endTime: new Date(2015, 3, 3, 17, 0, 0),
					}, {
						title: 'Go fishing',
						startTime: new Date(2015, 3, 3, 17, 0, 0),
						endTime: new Date(2015, 3, 3, 18, 0, 0),
						resources: [{
							name: 'Blue bus',
							id: 34523,
							contactNumber: '(493)403-4930'
						}]
					}]
				}, {

					title: 'Crab Fishing Tour',
					personCount: 58,
					events: [{
						title: 'Event 1',
						startTime: new Date(2015, 3, 3, 6, 0, 0),
						endTime: new Date(2015, 3, 3, 7, 0, 0),
					}, {
						title: 'Event 2',
						startTime: new Date(2015, 3, 3, 7, 0, 0),
						endTime: new Date(2015, 3, 3, 9, 0, 0),
					}, {
						title: 'Event 4',
						startTime: new Date(2015, 3, 3, 9, 0, 0),
						endTime: new Date(2015, 3, 3, 12, 0, 0),
					}, {
						title: 'Event 5',
						startTime: new Date(2015, 3, 3, 12, 0, 0),
						endTime: new Date(2015, 3, 3, 14, 0, 0),
					}, {
						title: 'Event 6',
						startTime: new Date(2015, 3, 3, 14, 0, 0),
						endTime: new Date(2015, 3, 3, 15, 0, 0),
					}, {
						title: 'Event 7',
						startTime: new Date(2015, 3, 3, 15, 0, 0),
						endTime: new Date(2015, 3, 3, 16, 0, 0),
					}, {
						title: 'Event 8',
						startTime: new Date(2015, 3, 3, 16, 0, 0),
						endTime: new Date(2015, 3, 3, 17, 0, 0),
					}, {
						title: 'Go fishing',
						startTime: new Date(2015, 3, 3, 17, 0, 0),
						endTime: new Date(2015, 3, 3, 18, 0, 0),
						resources: [{
							name: 'Blue bus',
							id: 34523,
							contactNumber: '(493)403-4930'
						}]
					}]
				}, {

					title: 'Crab Fishing Tour',
					personCount: 58,
					events: [{
						title: 'Event 1',
						startTime: new Date(2015, 3, 3, 6, 0, 0),
						endTime: new Date(2015, 3, 3, 7, 0, 0),
					}, {
						title: 'Event 2',
						startTime: new Date(2015, 3, 3, 7, 0, 0),
						endTime: new Date(2015, 3, 3, 9, 0, 0),
					}, {
						title: 'Event 3',
						startTime: new Date(2015, 3, 3, 9, 0, 0),
						endTime: new Date(2015, 3, 3, 11, 0, 0),
					}, {
						title: 'Event 4',
						startTime: new Date(2015, 3, 3, 11, 0, 0),
						endTime: new Date(2015, 3, 3, 12, 0, 0),
					}, {
						title: 'Event 5',
						startTime: new Date(2015, 3, 3, 12, 0, 0),
						endTime: new Date(2015, 3, 3, 14, 0, 0),
					}, {
						title: 'Event 6',
						startTime: new Date(2015, 3, 3, 14, 0, 0),
						endTime: new Date(2015, 3, 3, 15, 0, 0),
					}, {
						title: 'Event 7',
						startTime: new Date(2015, 3, 3, 15, 0, 0),
						endTime: new Date(2015, 3, 3, 16, 0, 0),
					}, {
						title: 'Event 8',
						startTime: new Date(2015, 3, 3, 16, 0, 0),
						endTime: new Date(2015, 3, 3, 17, 0, 0),
					}, {
						title: 'Go fishing',
						startTime: new Date(2015, 3, 3, 17, 0, 0),
						endTime: new Date(2015, 3, 3, 18, 0, 0),
						resources: [{
							name: 'Blue bus',
							id: 34523,
							contactNumber: '(493)403-4930'
						}]
					}]
				}, {

					title: 'Crab Fishing Tour',
					personCount: 58,
					events: [{
						title: 'Event 1',
						startTime: new Date(2015, 3, 3, 6, 0, 0),
						endTime: new Date(2015, 3, 3, 7, 0, 0),
					}, {
						title: 'Event 2',
						startTime: new Date(2015, 3, 3, 7, 0, 0),
						endTime: new Date(2015, 3, 3, 9, 0, 0),
					}, {
						title: 'Event 3',
						startTime: new Date(2015, 3, 3, 9, 0, 0),
						endTime: new Date(2015, 3, 3, 11, 0, 0),
					}, {
						title: 'Event 4',
						startTime: new Date(2015, 3, 3, 11, 0, 0),
						endTime: new Date(2015, 3, 3, 12, 0, 0),
					}, {
						title: 'Event 5',
						startTime: new Date(2015, 3, 3, 12, 0, 0),
						endTime: new Date(2015, 3, 3, 14, 0, 0),
					}, {
						title: 'Event 6',
						startTime: new Date(2015, 3, 3, 14, 0, 0),
						endTime: new Date(2015, 3, 3, 15, 0, 0),
					}, {
						title: 'Event 7',
						startTime: new Date(2015, 3, 3, 15, 0, 0),
						endTime: new Date(2015, 3, 3, 16, 0, 0),
					}, {
						title: 'Event 8',
						startTime: new Date(2015, 3, 3, 16, 0, 0),
						endTime: new Date(2015, 3, 3, 17, 0, 0),
					}, {
						title: 'Go fishing',
						startTime: new Date(2015, 3, 3, 17, 0, 0),
						endTime: new Date(2015, 3, 3, 18, 0, 0),
						resources: [{
							name: 'Blue bus',
							id: 34523,
							contactNumber: '(493)403-4930'
						}]
					}]
				}];
			}
		};
	});
