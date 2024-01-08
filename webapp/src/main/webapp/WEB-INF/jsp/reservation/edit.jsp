<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Edit Reservation</h1>
            </div>
        </div>
    </div>
</section>


<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="post" action="/reservation/editSubmit">
                    <input type="hidden" name="id" value="${form.id}">
                    <input type="hidden" name="ratId" value="${form.ratId}">
                    <input type="hidden" name="orderId" value="${form.orderId}">
                    <div class="mt-3">
                        <label for="reservationStatus" class="form-label">Reservation Status</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="reservationStatus" id="pending" value="Pending" ${form.reservationStatus == 'Pending' ? 'checked' : ''}>
                            <label class="form-check-label" for="pending">
                                Pending
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="reservationStatus" id="denied" value="Denied" ${form.reservationStatus == 'Denied' ? 'checked' : ''}>
                            <label class="form-check-label" for="denied">
                                Denied
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="reservationStatus" id="approved" value="Approved" ${form.reservationStatus == 'Approved' ? 'checked' : ''}>
                            <label class="form-check-label" for="approved">
                                Approved
                            </label>
                        </div>
                    </div>
                    <c:if test="${errors.hasFieldErrors('reservationStatus')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('reservationStatus')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <button type="submit" id="submitButton" class="btn btn-primary mt-4">Submit</button>


                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>