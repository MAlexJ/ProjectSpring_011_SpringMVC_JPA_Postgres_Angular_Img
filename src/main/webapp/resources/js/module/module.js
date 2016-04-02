'use strict';

// DRY роутинг в AngularJS:  https://habrahabr.ru/post/190958/
var myApp = angular.module('myApp', ["ngRoute"]).config(function ($routeProvider) {

    $routeProvider.when('/home',
        {
            templateUrl: 'home.html',
            controller: 'homeController'
        });

    $routeProvider.when('/article',
        {
            templateUrl: 'article.html',
            controller: 'articleController'
        });

    $routeProvider.when('/adminArticle',
        {
            templateUrl: 'adminArticle.html',
            controller: 'adminArticleController'
        });

    $routeProvider.otherwise({redirectTo: '/home'});

});

