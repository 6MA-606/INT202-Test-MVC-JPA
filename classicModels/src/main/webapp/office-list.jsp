<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Office List</title>
</head>
<style>
    body {

        & .cardContainer {
            display: flex;
            flex-wrap: wrap;
            gap: 1.25rem;

            & .officeCard {
                border: 1px solid black;
                padding: 0.5rem 1.5rem;
                display: flex;
                flex-direction: column;
                min-width: 10rem;

                & .header {
                    font-weight: bold;
                    font-size: 1.2em;
                }
                & .tel {
                    opacity: 0.5;
                    margin-bottom: 0.5em;
                }
            }

            & .officeCard:hover {
                cursor: pointer;
                background-color: #eee;
            }
        }
    }
</style>
<body>
    <h1>Office List</h1>
    <hr>
    <div class="cardContainer">
        <c:forEach var="office" items="${requestScope.offices}">
            <div class="officeCard">
                <div class="header">
                    ${office.officeCode} ${office.city}
                </div>
                <div class="tel">
                    ${office.phone}
                </div>
                <div class="address">
                    ${office.addressLine1}
                </div>
                <form action="office" method="post">
                    <input type="hidden" name="deleteCode" value="${office.officeCode}">
                    <input type="submit" value="Delete">
                </form>
            </div>
        </c:forEach>
    </div>
    <hr>
    <button onclick="window.location = 'add-office.jsp'">Add Office</button>
</body>
</html>
