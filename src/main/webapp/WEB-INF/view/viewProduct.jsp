<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product detail</h1>
            <p class="lead">Szczegółowe informacje o produkcji</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${productId}.png" />" alt="image" width="100%"/>


                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                        <strong>Manufacture</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                   <h4>${product.productPrice} PLN</h4>
                    <br>
                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/product/productList"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                        <a href="<spring:url value="/cart/"/>"
                        class="btn btn-default"><spanc class ='glyphicon glyphicon-hand-right'></spanc>View Cart</a>

                    </p>
                </div>
            </div>

        </div>


        <script src="<c:url value="/resources/js/controller.js"/>"></script>

        <%@include file="/WEB-INF/view/template/footer.jsp"%>
