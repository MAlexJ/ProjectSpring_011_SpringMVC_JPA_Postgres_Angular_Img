'use strict';

// DRY роутинг в AngularJS:  https://habrahabr.ru/post/190958/
var myApp = angular.module('myApp', ["ngRoute"]).config(function ($routeProvider) {

    // ************  Home Page  ******************  
    
    $routeProvider.when('/home',
        {
            templateUrl: 'home.html',
            controller: 'homeController'
        });
    
    // ************ Lesson Page ******************
    
    $routeProvider.when('/angular',
        {
            templateUrl: 'angular.html',
            controller: 'angularController'
        });

    $routeProvider.when('/java',
        {
            templateUrl: 'java.html',
            controller: 'javaController'
        });
    
    $routeProvider.when('/spring',
        {
            templateUrl: 'spring.html',
            controller: 'springController'
        });  
    
    $routeProvider.when('/postgres',
        {
            templateUrl: 'postgres.html',
            controller: 'postgresController'
        });   
    
    $routeProvider.when('/info',
        {
            templateUrl: 'info.html',
            controller: 'infoController'
        });    

    // ************  Admin Page ******************
    
    $routeProvider.when('/adminImage',
        {
            templateUrl: 'adminImage.html',
            controller: 'adminImageController'
        });

    $routeProvider.when('/adminArticle',
        {
            templateUrl: 'adminArticle.html',
            controller: 'adminArticleController'
        });

    // $routeProvider.when('/articleView/:category?/:id?',
    //     {
    //         templateUrl: 'articleView22.html',
    //         controller: 'articleViewController'
    //     });

    $routeProvider.otherwise({redirectTo: '/home'});

});

