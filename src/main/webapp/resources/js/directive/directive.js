'use strict';

// Загрузка файлов в AngularJS https://jsfiddle.net/JeJenny/ZG9re/
// https://habrahabr.ru/post/191464/
myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);


myApp.directive('imgRender', function () {
    return {
        restrict: 'AE',
        template: '<img src="data:image/png;base64,{{image.img}}">'
    }
});
