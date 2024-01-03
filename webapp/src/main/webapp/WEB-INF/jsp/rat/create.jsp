<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Create Rat</h1>
            </div>
        </div>
    </div>
</section>


<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="post" action="/rat/createSubmit" enctype="multipart/form-data">

                    <div class="mt-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" value="${form.name}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('name')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('name')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="genes" class="form-label">Genes</label>
                        <input type="text" class="form-control" id="genes" name="genes" value="${form.genes}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('genes')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('genes')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="birthday" class="form-label">Birthday</label>
                        <input type="date" class="form-control" id="birthday" name="birthday" value="${form.birthday}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('birthday')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('birthday')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="price" class="form-label">Price</label>
                        <input type="number" class="form-control" id="price" name="price" value="${form.price}" min="1">
                    </div>
                    <c:if test="${errors.hasFieldErrors('price')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('price')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="sex" class="form-label">Sex</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sex" id="female" value="Female" ${form.sex == 'Female' ? 'checked' : ''}>
                            <label class="form-check-label" for="female">
                                Female
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sex" id="male" value="Male" ${form.sex == 'Male' ? 'checked' : ''}>
                            <label class="form-check-label" for="male">
                                Male
                            </label>
                        </div>
                    </div>
                    <c:if test="${errors.hasFieldErrors('sex')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('sex')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="size" class="form-label">Size</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="size" id="standard" value="Standard" ${form.size == 'Standard' ? 'checked' : ''}>
                            <label class="form-check-label" for="standard">
                                Standard
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="size" id="dwarf" value="Dwarf" ${form.sex == 'Dwarf' ? 'checked' : ''}>
                            <label class="form-check-label" for="dwarf">
                                Dwarf
                            </label>
                        </div>
                    </div>
                    <c:if test="${errors.hasFieldErrors('size')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('size')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="ratStatus" class="form-label">Rat Status</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="ratStatus" id="unlisted" value="Unlisted" ${form.ratStatus == 'Unlisted' ? 'checked' : ''}>
                            <label class="form-check-label" for="unlisted">
                                Unlisted
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="ratStatus" id="listed" value="Listed" ${form.ratStatus == 'Listed' ? 'checked' : ''}>
                            <label class="form-check-label" for="listed">
                                Listed
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="ratStatus" id="available" value="Available" ${form.ratStatus == 'Available' ? 'checked' : ''}>
                            <label class="form-check-label" for="available">
                                Available
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="ratStatus" id="reserved" value="Reserved" ${form.ratStatus == 'Reserved' ? 'checked' : ''}>
                            <label class="form-check-label" for="reserved">
                                Reserved
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="ratStatus" id="delivered" value="Delivered" ${form.ratStatus == 'Delivered' ? 'checked' : ''}>
                            <label class="form-check-label" for="delivered">
                                Delivered
                            </label>
                        </div>
                    </div>
                    <c:if test="${errors.hasFieldErrors('ratStatus')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('ratStatus')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="photo1" class="form-label">Photo 1</label>
                        <input type="file" class="form-control" id="photo1" name="photo1">
                    </div>

                    <div class="mt-3">
                        <label for="photo2" class="form-label">Photo 2</label>
                        <input type="file" class="form-control" id="photo2" name="photo2">
                    </div>

                    <div class="mt-3">
                        <label for="photo3" class="form-label">Photo 3</label>
                        <input type="file" class="form-control" id="photo3" name="photo3">
                    </div>


                    <button type="submit" id="submitButton" class="btn btn-primary mt-4">Submit</button>


                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>