'use strict';

angular.module('schejewelApp')
	.directive('schejewel.tripView', function () {
		return {
			templateUrl: 'app/directives/schejewel.tripView/schejewel.tripView.html',
			restrict: 'EA',
			scope: {
				tours: '='
			},
			link: function ($scope) {
				$scope.dayHours = ['6:00', '6:30', '7:00', '7:30', '8:00', '8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '1:00', '1:30',
					'2:00', '2:30', '3:00', '3:30', '4:00', '4:30', '5:00', '5:30', '6:00 pm', '6:30 pm', '7:00 pm'
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

				$scope.titleStyle = function (events) {
					var top;
					var firstEvent = events[0];
					for (var i in events) {
						var ev = events[i];
						if (firstEvent && firstEvent.startTime) {
							if (firstEvent.startTime > ev.startTime) {
								firstEvent = ev;
							}
						}

					}
					if (events && events[0]) {
						top = getMinutesSince6(new Date(firstEvent.startTime));
					}
					return {
						position: 'absolute',
						top: top + 'px'
					};
				};


				$scope.hourStyle = function (index) {
					var top = (index * 30);

					return {
						position: 'absolute',
						top: top + 'px'
					};
				};

				$scope.tourColumns = [];

				var orderTours = function () {

				};

				var formatRows = function () {
					orderTours();
					for (var i in $scope.tours) {

					}
				};




				formatRows();
			}
		};
	});
