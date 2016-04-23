'use strict';

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

myApp.directive('imageType', function() {
    return {
        restrict: "E",
        scope: {},
        templateUrl:'imageType.html',
        controller: function($rootScope, $scope, $element, currentImages) {
            // $scope.contacts = $rootScope.GetContactTypes;
            $scope.imgData = currentImages.getImages();
            $scope.Delete = function(e) {
                //remove element and also destoy the scope that element
                $element.remove();
                $scope.$destroy();
            }
        }
    }
});
