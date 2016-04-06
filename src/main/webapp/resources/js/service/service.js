'use strict';

myApp.service('fileUpload', function ($http) {

    this.uploadFileToUrl = function (file, uploadUrl, img) {
        var fd = new FormData();
        fd.append('file', file);
        fd.append('type', img.radio);
        $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            });
    };

});
