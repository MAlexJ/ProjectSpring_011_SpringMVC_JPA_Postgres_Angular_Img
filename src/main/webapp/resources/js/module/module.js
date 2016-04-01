'use strict';

// DRY роутинг в AngularJS:  https://habrahabr.ru/post/190958/
var myApp = angular.module('myApp', ["ngRoute"]).config(function ($routeProvider) {

    $routeProvider.when('/home',
        {
            templateUrl: 'home.html',
            controller: 'homeController'
        });

    $routeProvider.when('/crud',
        {
            templateUrl: 'crud.html',
            controller: 'crudController'
        });

    $routeProvider.when('/login',
        {
            templateUrl: 'login.html',
            controller: 'loginController'
        });

    $routeProvider.otherwise({redirectTo: '/home'});

});