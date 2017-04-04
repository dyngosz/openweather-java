(function (angular) {

    'use strict';

    angular.module('App', ['ngRoute', 'ngResource'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when('/weather', {
                    templateUrl: 'app/views/weather.html',
                    controller: 'WeatherController'
                })
                .otherwise({
                    redirectTo: '/weather'
                });

        }])
})(window.angular);