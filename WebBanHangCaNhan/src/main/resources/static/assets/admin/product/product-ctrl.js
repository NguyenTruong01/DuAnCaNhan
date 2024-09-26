app.controller("productCtrl", function ($scope, $http) {
    $scope.items=[];
    $scope.cates=[];
    $scope.form={};
    $scope.initialize = function (){
        $http.get("/rest/product").then(resp =>{
            $scope.items = resp.data;
            $scope.items.forEach(item =>{
                item.createDate = new Date(item.createDate);
            })
        })
        $http.get("/rest/cates").then(resp =>{
            $scope.cates = resp.data;
        })

    }
    $scope.reset = function (){
        $scope.form={
            CreateDate: new Date(),
            image:'cloud-upload.jpg',
            Available:true,
        }
    }
    $scope.create= function (){
        var item = angular.copy($scope.form);
        $http.post(`/rest/product`,item).then(resp =>{
            resp.data.CreateDate = new Date(resp.data.CreateDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Them thanh cong");

        }).catch(error => {
            alert("loi them");
            console.log("error",error);
        })
    }
    $scope.update= function (){
        var item = angular.copy($scope.form);
        $http.put(`/rest/product/${item.id}`,item).then(resp =>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.reset();
            alert("Cap nhat thanh cong");

        }).catch(error => {
            alert("loi cap nhat");
            console.log("error",error);
        })
    }
    $scope.delete = function (item){

        $http.delete(`/rest/product/${item.id}`,item).then(resp =>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1)
            $scope.reset();
            alert("Xoa thanh cong");

        }).catch(error => {
            alert("loi Xoa");
            console.log("error",error);
        })
    }
    $scope.edit= function (item){
        if (typeof item.CreateDate === 'string') {
            item.CreateDate = new Date(item.CreateDate);
        }

        $scope.form = angular.copy(item);
        console.log(item.CreateDate)
        $(".nav-tabs a:eq(0)").tab("show");
    }

    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append("file", files[0]);
        $http
            .post("/rest/upload/images", data, {
                transformRequest: angular.identity,
                headers: { "Content-Type": undefined },
            })
            .then((resp) => {
                $scope.form.image = resp.data.name;
            })
            .catch((error) => {
                alert("Lỗi khi tải ảnh lên");
                console.log(error);
            });
    };
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            if (this.page > 0) {
                this.page--;
            }
        },
        next() {
            if (this.page < this.count - 1) {
                this.page++;
            }
        },
        last() {
            this.page = this.count - 1;
        },
    };

    $scope.initialize();
});
