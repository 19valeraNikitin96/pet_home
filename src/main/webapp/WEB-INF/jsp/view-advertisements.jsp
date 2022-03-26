<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Advertisements</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Pet name</th>
                    <th>Location</th>
                    <th>Date</th>
                    <th>Advertisement owner</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${advertisements}" var="ad">
                    <tr>
                        <td>${ad.petName}</td>
                        <td>${ad.location.city},${ad.location.district},${ad.location.street}</td>
                        <td>${ad.date.day}.${ad.date.month}.${ad.date.year}</td>
                        <td>First name: ${ad.user.firstname}; Username: ${ad.user.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>