'use strict';

angular.module('schejewelApp')
	.directive('schejewel.resourceView', function (Data) {
		return {
			templateUrl: 'app/directives/schejewel.resourceView/schejewel.resourceView.html',
			restrict: 'EA',
			link: function ($scope) {
				var milliseconds = new Date();
				Data.getResources(milliseconds).then(function(data) {
            //console.log('data', data);
        });
				$scope.resourceData =
				[
					{
						title  : 'Bus1',
						start  : '2015-03-29T18:30:00',
						end  : '2015-03-29T20:30:00'
					},
					{
						title  : 'Bus2',
						start  : '2015-03-29T18:30:00',
						end  : '2015-03-29T20:30:00'
					}
				];

				$scope.activeResources = [];
				$scope.resourceList = [];

				$scope.colors = ['#40e0d0', '#378006', '#ff0000', '#0000ff', '#008000', '#468499', '#800000', '#333333']
				//$scope.calendarData = {start:2015-03-29T20:41:02+00:00, end:2015-03-29T20:41:06+00:0};
				$scope.eventList = {events:[]}
		    $scope.events =
				{
					events: [
				        {
				            title  : 'Bus1',
										start  : '2015-03-29T18:30:00',
										end  : '2015-03-29T20:30:00'
				        },
				        {
				            title  : 'Bus1',
										start  : '2015-03-29T06:30:00',
										end  : '2015-03-29T08:30:00'
				        },
				        {
				            title  : 'Bus1',
				            start  : '2015-03-29T12:30:00',
										end  : '2015-03-29T16:30:00'
				        },
								{
				            title  : 'Bus2',
				            start  : '2015-03-29T12:30:00',
										end  : '2015-03-29T17:00:00',
				        },
								{
				            title  : 'Bus2',
				            start  : '2015-03-29T08:30:00',
										end  : '2015-03-29T09:30:00',
				        },
								{
				            title  : 'Bus2',
				            start  : '2015-03-29T17:30:00',
										end  : '2015-03-29T18:00:00',
				        }
							]
				}

				$scope.convertDataToCalendar = function(){

				}

				$scope.createNewEventList = function(events){
					$scope.eventList = {events: []};
					for(var j = 0; j < events.length; j++){
						for(var i = 0; i < $scope.events.events.length; i++){
							if($scope.events.events[i].title === events[j]){
								var event = $scope.events.events[i];
								event.backgroundColor = $scope.colors[j];
								$scope.eventList.events.push(event);
							}
						}
					}
					$('#calendar').fullCalendar('removeEvents')
					$('#calendar').fullCalendar('removeEventSource', $scope.eventList);
					$('#calendar').fullCalendar('addEventSource', $scope.eventList);
					$('#calendar').fullCalendar('refetchEvents');
				}

				$scope.loadResourceButtons = function(){
					for(var i = 0; i < $scope.resourceData.length; i++){
						var newResource = true;
						for(var j = 0; j < $scope.resourceList.length; j++){
							if($scope.resourceData[i].title === $scope.resourceList[j]){
								newResource = false;
							}
						}
						if(newResource){
							$scope.resourceList.push($scope.resourceData[i].title);
						}
					}
					for(var i = 0; i < $scope.resourceList.length; i++){
						$('.buttonHolder').append('<button style="margin-bottom: 20px;" class="resourceButton" value="'+ $scope.resourceList[i] +'">'+ $scope.resourceList[i] +'</button>');
					}
				}

				angular.element(document).ready(function () {
					$scope.loadResourceButtons()
    		});

				$(document).on( "click", '.resourceButton', function () {
					var alreadyIn = false;
					for(var i = 0; i < $scope.activeResources.length; i++){
						if($scope.activeResources[i] === this.value){
							$scope.activeResources.splice(i, 1);
							alreadyIn = true;
						}
					}
					if(!alreadyIn){
						$scope.activeResources.push(this.value);
					}
					$scope.createNewEventList($scope.activeResources);
				});

				$('#calendar').fullCalendar({
					allDaySlot: false,
					defaultView: 'agendaDay',
					aspectRatio: 1.5,
					minTime: "06:00:00",
					events: $scope.eventList
				});

				/*$scope.dummyData = ['6:00', '6:30', '7:00', '7:30', '8:00', '8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '1:00', '1:30',
					'2:00', '2:30', '3:00', '3:30', '4:00', '4:30', '5:00', '5:30'
				];
				$scope.Columns = [{
					'resourceType': 'Bus1',
					'useTimes': [{
							'startTime': '11:00',
							'endTime': '11:30'
						},

						{
							'startTime': '13:00',
							'endTime': '13:30'
						}
					]
				}, {
					'resourceType': 'Bus2',
					'useTimes': [{
							'startTime': '11:00',
							'endTime': '11:30'
						},

						{
							'startTime': '13:00',
							'endTime': '13:30'
						}
					]
				}];



				$scope.calculateTimeStart = function (start) {
					var a = start.split(':'); // split it at the colons

					var minutes = (+a[0]) * 60 + (+a[1]) - 6 * 60 + 19;
					return minutes;
				};
				$scope.calculateTimeDuration = function (start, end) {
					var a = start.split(':'); // split it at the colons
					var b = end.split(':'); // split it at the colons
					var minutesA = (+a[0]) * 60 + (+a[1]);
					var minutesB = (+b[0]) * 60 + (+b[1]);
					var result = Number(minutesB) - Number(minutesA) - 1;
					return result.toString();
				};

				$scope.getStyle = function (start, end) {
					var response = {
						'top': $scope.calculateTimeStart(start) + 'px',
						'height': $scope.calculateTimeDuration(start, end) + 'px'
					};
					return response;
				};

				$scope.appear = function () {
					console.log("Appearing");
				};*/

			}
		};
	});
