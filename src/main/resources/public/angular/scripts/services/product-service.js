angular.module('storeApp').service('ProductService',
    ['$http', '$log', 'ProductServiceUrl', function ($http, $log, ProductServiceUrl) {

        this.getAllProducts = function () {
            $log.info('retrieving all products');
            return $http.get(ProductServiceUrl);
        };

        this.addProduct = function (product) {
            $log.info('adding product ' + JSON.stringify(product));
            return $http.put(ProductServiceUrl + '/add', product);
        }

        this.removeProduct = function (index) {
            $log.info('removing product with index ' + index);
            return $http.delete(ProductServiceUrl + '/' + index);
        }
}]);
