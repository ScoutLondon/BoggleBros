<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">${ratList.size()} Rats Available Now!</h1>
            </div>
        </div>
    </div>
</section>

<c:if test="${not empty ratList}">
    <div class="container">
        <div class="row">
            <c:forEach items="${ratList}" var="rat">
                <div class="col-12 col-sm-6 col-md-4 col-lg-3 mb-4">
                    <div class="card">
                        <img src="${rat.photo1}" class="card-img-top" alt="${rat.name}">
                        <div class="card-body">
                            <h5 class="card-title">${rat.name}</h5>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Size: ${rat.size}</li>
                            <li class="list-group-item">Genes: ${rat.genes}</li>
                            <li class="list-group-item">Adoption Fee: $ ${rat.price}</li>
                        </ul>
                        <div class="card-body">
                            <a href="/reservation/create?id=${rat.id}" class="card-link">Reserve Me!</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>


<jsp:include page="../include/footer.jsp"/>