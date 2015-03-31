'use strict';

angular.module('schejewelApp')
    .service('Data', function($q, $http) {
        var url = 'http://Default-Environment-69yjsdh6ez.elasticbeanstalk.com/api/';
        var mockToken = 'eyJleHBpcmVzIjoxNDI3MDY2MTAyODM1LCJhdXRob3JpdGllcyI6bnVsbCwidXNlcm5hbWUiOiJrZW50MTIzNEBnbWFpbC5jb20iLCJjb21wYW55SWQiOjEsInBhc3N3b3JkIjoiJDJhJDEwJDBUc21kZGNYZkVxVldjOVQyVFNnUWVESFBjVWlxZ2FJenpQQWtKR29UVUZEQWU3Y0JVbnFxIiwidXNlcklkIjoxN30=.zmURLPQQxDEARljnmYJg1oyHkWwA0mGFAuJH2UNfU9Q='

        return {
            getResources: function (milliseconds) {
                var deferred = $q.defer();
                if(milliseconds === undefined){
                  $http.defaults.headers.common['X-AUTH-TOKEN'] = mockToken;
                  $http.get(url + 'resource').success(function (data, status, headers, config) {
                      deferred.resolve(data);
                  })
                }
                else{
                  $http.defaults.headers.common['X-AUTH-TOKEN'] = mockToken;
                  console.log(url + 'resource'+'/'+milliseconds.getTime());
                  $http.get(url + 'resources'+''/*+milliseconds.getTime()*/).success(function (data, status, headers, config) {
                      deferred.resolve(data);
                  })
                }

                return deferred.promise
            },
            addTour: function (tourData) {
                var deferred = $q.defer();
                if(tourData === undefined){
                    return;
                }
                else{
                  $http.defaults.headers.common['X-AUTH-TOKEN'] = mockToken;
                  $http.post(url + 'tour/'+tourData).success(function (data, status, headers, config) {
                      deferred.resolve(data);
                  })
                }

                return deferred.promise
            }

        };
    });
