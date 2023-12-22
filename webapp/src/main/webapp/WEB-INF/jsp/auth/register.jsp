<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Adopter Application</h1>
            </div>
        </div>
    </div>
</section>


<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="get" action="/auth/registerSubmit">

                    <div class="mt-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${form.email}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('email')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('email')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="text" class="form-control" id="password" name="password" value="${form.password}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('password')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('password')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${form.firstName}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('firstName')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('firstName')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('lastName')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('lastName')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="city" class="form-label">City</label>
                        <input type="text" class="form-control" id="city" name="city" value="${form.city}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('city')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('city')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="state" class="form-label">State</label>
                        <input type="text" class="form-control" id="state" name="state" value="${form.state}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('state')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('state')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="phone" class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('phone')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('phone')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="yearsExperience" class="form-label">Years of Rat-Keeping Experience</label>
                        <div class="form-check">
                                <input class="form-check-input" type="radio" name="yearsExperience" id="none" value="None" ${form.yearsExperience == 'None' ? 'checked' : ''}>
                                <label class="form-check-label" for="none">
                                    None
                                </label>
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="yearsExperience" id="oneTwoYears" value="1-2 years" ${form.yearsExperience == '1-2 years' ? 'checked' : ''}>
                                <label class="form-check-label" for="oneTwoYears">
                                    1-2 years
                                </label>
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="yearsExperience" id="twoPlusYears" value="2+ years" ${form.yearsExperience == '2+ years' ? 'checked' : ''}>
                                <label class="form-check-label" for="twoPlusYears">
                                    2+ years
                                </label>
                            </div>
                    </div>
                    <c:if test="${errors.hasFieldErrors('yearsExperience')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('yearsExperience')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="currentRatsDesc" class="form-label">Do you currently have rats in your home? If so, please include their ages, genders and disposition down below. If no, please type "no" below.</label>
                        <input type="text" class="form-control" id="currentRatsDesc" name="currentRatsDesc" value="${form.currentRatsDesc}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('currentRatsDesc')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('currentRatsDesc')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="careDesc" class="form-label">Below, please tell us a little about your care. What Food, Bedding and Caging will you be using?</label>
                        <input type="text" class="form-control" id="careDesc" name="careDesc" value="${form.careDesc}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('careDesc')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('careDesc')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="breederStatus" class="form-label">Please choose the answer that best describes you.</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="breederStatus" id="nonBreeder" value="Non-Breeder" ${form.breederStatus == 'Non-Breeder' ? 'checked' : ''}>
                            <label class="form-check-label" for="nonBreeder">
                                Pet home, No intention of breeding
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="breederStatus" id="breeder" value="Breeder" ${form.breederStatus == 'Breeder' ? 'checked' : ''}>
                            <label class="form-check-label" for="breeder">
                                Breeder home, I intend to breed
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="breederStatus" id="potentialBreeder" value="Potential Breeder" ${form.breederStatus == 'Potential Breeder' ? 'checked' : ''}>
                            <label class="form-check-label" for="potentialBreeder">
                                Pet home, Open to the idea of breeding
                            </label>
                        </div>
                    </div>
                    <c:if test="${errors.hasFieldErrors('breederStatus')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('breederStatus')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <div class="mt-3">
                        <label for="sexPref" class="form-label">Please choose the answer that best describes your preferences.</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sexPref" id="male" value="Male" ${form.sexPref == 'Male' ? 'checked' : ''}>
                            <label class="form-check-label" for="male">
                                I would like to adopt males
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sexPref" id="female" value="Female" ${form.sexPref == 'Female' ? 'checked' : ''}>
                            <label class="form-check-label" for="female">
                                I would like to adopt females
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sexPref" id="both" value="Both" ${form.sexPref == 'Both' ? 'checked' : ''}>
                            <label class="form-check-label" for="both">
                                I would like to adopt males and females
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="sexPref" id="unsure" value="Unsure" ${form.sexPref == 'Unsure' ? 'checked' : ''}>
                            <label class="form-check-label" for="unsure">
                                I am not sure whether I would like to adopt males or females
                            </label>
                        </div>

                    </div>
                    <c:if test="${errors.hasFieldErrors('sexPref')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('sexPref')}" var="error">
                                ${error.defaultMessage}<br>
                            </c:forEach>
                        </div>
                    </c:if>


                    <button type="submit" class="btn btn-primary mt-4">Submit</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>