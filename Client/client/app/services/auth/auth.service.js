'use strict';

angular.module('schejewelApp')
    .factory('Auth', function Auth($location, $rootScope, $http, $cookieStore, $q) {
        var currentUser = {};
        if ($cookieStore.get('token')) {
            currentUser = $cookieStore.get('token').user;
        }


        return {

            /**
             * Authenticate user and save token
             *
             * @param  {Object}   user     - login info
             * @param  {Function} callback - optional
             * @return {Promise}
             */
            login: function(user) {

                var deferred = $q.defer();

                $http.get('http://104.131.170.128:8080/alaska-excursions/api/login', {
                    headers: {
                        'Authorization': 'Basic ZW5jcnlwdEBnbWFpbC5jb206MTIzNA=='
                    }
                }).
                success(function(data) {
                    $cookieStore.put('token', data);
                    currentUser = data;
                    deferred.resolve(data);
                }).
                error(function(err) {
                    this.logout();
                    deferred.reject(err);
                }.bind(this));

                return deferred.promise;
            },

            /**
             * Delete access token and user info
             *
             * @param  {Function}
             */
            logout: function() {
                $cookieStore.remove('token');
                currentUser = {};
                $location.path('/login');
            },



            /**
             * Gets all available info on authenticated user
             *
             * @return {Object} user
             */
            getCurrentUser: function() {
                return currentUser;
            },





            /**
             * Get auth token
             */
            getToken: function() {
                return $cookieStore.get('token');
            },

            /**
             * Check if a user is logged in
             *
             * @return {Boolean}
             */
            isLoggedIn: function() {
                var deferred = $q.defer();
                deferred.resolve(!!currentUser.roles);
                return deferred.promise;
            },


        };
    });
