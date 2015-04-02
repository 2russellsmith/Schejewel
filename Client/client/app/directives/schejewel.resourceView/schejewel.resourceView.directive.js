'use strict';

angular.module('schejewelApp')
	.directive('schejewel.resourceView', function (Data) {
		return {
			templateUrl: 'app/directives/schejewel.resourceView/schejewel.resourceView.html',
			restrict: 'EA',
			link: function ($scope) {
				$scope.rawResourceData;
				var dateString = "2015-05-05"; //TODO: getToday
				Data.getResources(dateString).then(function(data) {
					console.log(data);
					$scope.rawResourceData = data;
					$scope.convertDataToCalendar();
					$scope.loadResourceButtons();
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

				$scope.colors = ['#0099CC', '#378006', '#ff0000', '#40e0d0', '#008000', '#468499', '#800000', '#0000ff', '#333333']
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

				$scope.addMinutes = function (time, minsToAdd) {
				function D(J){ return (J<10? '0':'') + J;};
				var piece = time.split(':');
				var mins = piece[0]*60 + +piece[1] + +minsToAdd;
				return D(mins%(24*60)/60 | 0) + ':' + D(mins%60);
				}

				$scope.convertDataToCalendar = function(){
					//move/convert rawResourceData to resourceData
					$scope.resourceData = []
					for(var i = 0; i < $scope.rawResourceData.length; i++){
						var newResourceEntry =  {};
						newResourceEntry.title = $scope.rawResourceData[i].name;
						newResourceEntry.start = $scope.rawResourceData[i].startDate + "T" + $scope.rawResourceData[i].startTime; //Weird date format uses 'T'
						var endTime = $scope.addMinutes($scope.rawResourceData[i].startTime, String($scope.rawResourceData[i].duration))
						newResourceEntry.end = $scope.rawResourceData[i].startDate + "T" + endTime + ":00";
						$scope.resourceData.push(newResourceEntry);
					}
				}

				$scope.createNewEventList = function(events, colorIndex){
					$scope.eventList = {events: []};
					for(var j = 0; j < events.length; j++){
						for(var i = 0; i < $scope.resourceData.length; i++){
							console.log($scope.resourceData[i].title + " "+ events[j].name);
							if($scope.resourceData[i].title === events[j].name){
								var event = $scope.resourceData[i];
								event.backgroundColor = $scope.colors[events[j].color];
								$scope.eventList.events.push(event);
							}
						}
					}
					$('#calendar').fullCalendar('removeEvents')
					$('#calendar').fullCalendar('removeEventSource', $scope.eventList);
					$('#calendar').fullCalendar('addEventSource', $scope.eventList);
					console.log($scope.eventList);
					$('#calendar').fullCalendar('refetchEvents');
				}

				$scope.loadResourceButtons = function(){
					for(var i = 0; i < $scope.resourceData.length; i++){
						console.log($scope.resourceData[i]);
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
						$('.buttonHolder').append('<button style="margin-bottom: 20px;" title = "' + i + '"class="resourceButton" value="'+ $scope.resourceList[i] +'">'+ $scope.resourceList[i] +'</button>');
					}
				}

				$(document).on( "click", '.resourceButton', function () {
					var alreadyIn = false;
					for(var i = 0; i < $scope.activeResources.length; i++){
						if($scope.activeResources[i].name === this.value){
							$scope.activeResources.splice(i, 1);
							alreadyIn = true;
						}
					}
					if(!alreadyIn){
						var nameColorPair = {name: "", color:-1};
						nameColorPair.name = this.value;
						nameColorPair.color = this.title;
						$scope.activeResources.push(nameColorPair);
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
			}
		};
	});
