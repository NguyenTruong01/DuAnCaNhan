const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-controller", function ($scope, $http) {
  $scope.cart = {
    items: [],
    add(id) {
      var item = this.items.find((item) => item.id == id);
      if (item) {
        item.qty++;
        this.saveToLocalStorage();
      } else {
        $http.get(`/rest/product/${id}`).then((resp) => {
          resp.data.qty = 1;
          this.items.push(resp.data);
          this.saveToLocalStorage();
        });
      }
    },
    saveToLocalStorage() {
      var json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);
    },
    get count() {
      return this.items
        .map((item) => item.qty)
        .reduce((total, qty) => (total += qty), 0);
    },
    get amount() {
      return this.items
        .map((item) => item.qty * item.price)
        .reduce((total, qty) => (total += qty), 0);
    },
    loadFormLocalStorage() {
      var json = localStorage.getItem("cart");
      this.items = json ? JSON.parse(json) : [];
    },
    remove(id) {
      var index = this.items.findIndex((item) => item.id == id);
      this.items.splice(index, 1);
      this.saveToLocalStorage();
    },
    clear() {
      this.items = [];
      this.saveToLocalStorage();
    },
  };
  $scope.cart.loadFormLocalStorage();
  $scope.order = {
    CreateDate: new Date(),
    Address: "",
    Accounts: { Username: $("#username").text().replace(/\s+/g, " ").trim() },
    get orderDetails() {
      return $scope.cart.items.map((item) => {
        return {
          product: { id: item.id },
          price: item.Price,
          quantity: item.qty,
        };
      });
    },
    purchase() {
      var order = angular.copy(this);
      $http
        .post("/rest/orders", order)
        .then((resp) => {
          alert("Đặt hàng thành công");
          $scope.cart.clear();
          location.href = "/order/detail/" + resp.data.Id;
        })
        .catch((error) => {
          alert("Đặt hàng lỗi");
          console.log(order);
          // console.log(error)
        });
    },
  };
});
