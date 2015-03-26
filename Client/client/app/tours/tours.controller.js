'use strict';

angular.module('schejewelApp')
	.controller('ToursCtrl', function ($scope) {

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
			}]
		}, {

			title: 'Crab Fishing Tour',
			personCount: 58,
			events: [{
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
			}]
		}, {

			title: 'Crab Fishing Tour',
			personCount: 58,
			events: [{
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
				endTime: new Date(2015, 3, 3, 21, 0, 0),
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
				title: 'Go fishing',
				startTime: new Date(2015, 3, 3, 15, 0, 0),
				endTime: new Date(2015, 3, 3, 17, 0, 0),
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
				endTime: new Date(2015, 3, 3, 23, 0, 0),
				resources: [{
					name: 'Blue bus',
					id: 34523,
					contactNumber: '(493)403-4930'
				}]
			}]
		}];

	});
