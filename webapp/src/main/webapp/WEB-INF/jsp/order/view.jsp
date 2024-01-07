<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">${reservationList.size()} Rats Ready To Adopt!</h1>
            </div>
        </div>
    </div>
</section>

<c:if test="${not empty reservationList}">



            <c:forEach items="${reservationList}" var="reservation">
                <div class="card" style="width: 18rem;">
                  <img src="${reservation.rat.photo1}" class="card-img-top" alt="${reservation.rat.name}">
                  <div class="card-body">
                    <h5 class="card-title">${reservation.rat.name}</h5>
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">Size: ${reservation.rat.size}</li>
                    <li class="list-group-item">Genes: ${reservation.rat.genes}</li>
                    <li class="list-group-item">Adoption Fee: $ ${reservation.rat.price}</li>
                  </ul>
                </div>
            </c:forEach>
</c:if>


<jsp:include page="../include/footer.jsp"/>