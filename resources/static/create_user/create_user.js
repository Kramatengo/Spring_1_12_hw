angular.module('market-front').controller('createUserController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.createUser = function () {
        if ($scope.new_user == null) {
            alert('Форма не заполнена');
            return;
        }
        $http.post(contextPath + 'api/v1/reg_user', $scope.new_user)
            .then(function successCallback(response) {
                $scope.new_user = null;
                alert('Пользователь успешно создан');
                $location.path('/');
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
            });
    }
});