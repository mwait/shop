/**
 * Created by mc on 2016-02-28.
 */
var cartApp = angular.module('cartApp',[]);

cartApp.controller('cartCtrl', function($scope,$http){
    $scope.refreshCart=function(cartId){
        $http.get('/shop/rest/cart/'+$scope.cartId).success(function(data){
            $scope.cart=data;
        });
    };
    $scope.clearCart = function (){
        $http.delete('/shop/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId){
        $scope.cartId=cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId){
        $http.put('/shop/rest/cart/add/'+productId).success(function (data){
            $scope.refreshCart($http.get('/shop/rest/cart/cartId'));
            alert("Product successfuly added to the cart!")
        });
    };
    $scope.removeFromCart = function (productId){
        $http.put('/shop/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart()($http.get('/shop/rest/cart/cartId'));
        });
    };
});