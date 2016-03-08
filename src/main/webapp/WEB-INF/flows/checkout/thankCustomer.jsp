<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class=""jumbotron">
    <div class="container">
        <h1>Thank you for you business!</h1>
        <p>You order will be shipped in two business days!</p>
    </div>
        </section>
        <section class="container">
          

       <p>
            <a href="<spring:url value="/"/>" class="btn btn-default">OK</a>
            </p>
        </section>
    </div>
</div>

<%@include file="/WEB-INF/view/template/footer.jsp"%>