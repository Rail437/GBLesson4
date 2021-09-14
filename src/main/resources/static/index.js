angular.module('app', []).controller('indexController',

    function ($scope, $http) {

        const contextPath = 'http://localhost:8080';

        $scope.fillTable = function () {
            $http.get(contextPath + "/product")
                .then(function (resp) {
                    $scope.Products = resp.data
                })
        };

        $scope.removeProduct = function (id) {
            $http.delete(contextPath + '/product/' + id)
                .then(function (resp) {
                    $scope.fillTable()
                })
        }
        $scope.showForm = function() {
            $scope.message = "Show Form Button Clicked";
            console.log($scope.message);

            var modalInstance = $modal.open({
                templateUrl: 'modal-form.html',
                controller: ModalInstanceCtrl,
                scope: $scope,
                resolve: {
                    updateForm: function () {
                        return $scope.updateForm;
                    }
                }
            });

            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };

        $scope.saveProduct = function () {
            $http.post(contextPath + '/product', $scope.NewProduct)
                .then(function (resp) {
                    $scope.fillTable()
                });
        };

        $scope.fillTable()
    });
var ModalInstanceCtrl = function ($scope, $modalInstance, updateForm) {
    $scope.form = {}
    $scope.submitForm = function () {
        if ($scope.form.updateForm.$valid) {
            console.log('user form is in scope');
            $modalInstance.close('closed');
        } else {
            console.log('userform is not in scope');
        }
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
        $scope.fillTable();
    };
};