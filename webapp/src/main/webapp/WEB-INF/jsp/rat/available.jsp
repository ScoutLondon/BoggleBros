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



            <c:forEach items="${ratList}" var="rat">
                <div class="card" style="width: 18rem;">
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
            </c:forEach>
</c:if>


<jsp:include page="../include/footer.jsp"/>