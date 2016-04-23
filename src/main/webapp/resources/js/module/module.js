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

     $routeProvider.when('/adminBlock',
        {
            templateUrl: 'adminBlock.html',
            controller: 'adminBlockController'
        });    

    $routeProvider.otherwise({redirectTo: '/home'});

});

angular.module('myApp')
    .directive('bsActiveLink', ['$location', function ($location) {
        return {
            restrict: 'A', //use as attribute
            replace: false,
            link: function (scope, elem) {
                //after the route has changed
                scope.$on("$routeChangeSuccess", function () {
                    var hrefs = ['/#' + $location.path(),
                        '#' + $location.path(), //html5: false
                        $location.path()]; //html5: true
                    angular.forEach(elem.find('a'), function (a) {
                        a = angular.element(a);
                        if (-1 !== hrefs.indexOf(a.attr('href'))) {
                            a.parent().addClass('active');
                        } else {
                            a.parent().removeClass('active');
                        };
                    });
                });
            }
        }
    }]);


