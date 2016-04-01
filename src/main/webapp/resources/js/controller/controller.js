'use strict';


myApp.controller('homeController', function () {
    
});

myApp.controller('crudController', ['$scope', '$http',
    function ($scope, $http) {

        // GET: {id}
        $scope.loaded = false;
        
        $scope.findById = function (findOptPost) {
            if(findOptPost>0){
                $http.get('/phone/'+findOptPost).success(function (data) {
                    $scope.phone = data;
                    $scope.loaded = true;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            }
        };       

        // GET: list
        $http.get('/phone').success(function (data) {
            $scope.phones = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });

        // PUT
        $scope.save = function (answer, answerForm) {
            if (answerForm.$valid) {
                $http.put('/phone', answer).success(function () {
                    {
                        $scope.answer.title = "";
                        $scope.answer.description = "";
                        $scope.answer.price = "";
                        console.log("put: success");

                        // repeat: get list
                        $http.get('/phone').success(function (data) {
                            $scope.phones = data;
                        }).error(function (data, status) {
                            console.log("код ответа: " + status);
                        });
                    }
                });
            }
        };

        //POST
        $scope.update = function (updateForm, selectOptPost) {
            if (updateForm.$valid) {

                $http.post('/phone', selectOptPost).success(function () {
                    console.log("post: success");

                    // repeat: get list
                    $http.get('/phone').success(function (data) {
                        $scope.phones = data;
                    }).error(function (data, status) {
                        console.log("код ответа: " + status);
                    });
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            }
        };

        //DELETE
        $scope.delete = function (selectOptDel) {
            if (selectOptDel > 0) {

                $http.delete('/phone/' + selectOptDel).success(function () {

                    // repeat: get list
                    $http.get('/phone').success(function (data) {
                        $scope.phones = data;
                    }).error(function (data, status) {
                        console.log("код ответа: " + status);
                    });
                });
            }
            else {
                console.log('Error');
            }
        };
    }
]);

myApp.controller('loginController', function () {


});
