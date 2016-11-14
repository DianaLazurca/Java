<%-- 
    Document   : machineView_file
    Created on : Nov 5, 2016, 9:35:54 PM
    Author     : Diana-Stefania
--%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="startTime" required="false" %>
<%@ attribute name="endTime" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<fmt:setBundle basename='<%="i18n." +request.getAttribute("bundle")%>' />

<sql:setDataSource  var="timetable"
                    url="jdbc:mysql://localhost:3306/lab04?zeroDateTimeBehavior=convertToNull"
                    driver="com.mysql.jdbc.Driver"
                    user="root" password=""/>

<c:set var="machineID" value="${id}"/>
<c:choose>
<c:when test="${fn:length(startTime) > 0}">
    <c:set var="newStartTime1" value="${fn:replace(startTime,'-', ' ')}"/>
    <c:set var="newStartTime2" value="${fn:replace(newStartTime1,'.', '-')}"/>
    <c:choose>
        <c:when test="${fn:length(endTime) > 0}">
            <c:set var="newEndTime1" value="${fn:replace(endTime,'-', ' ')}"/>
            <c:set var="newEndTime2" value="${fn:replace(newEndTime1,'.', '-')}"/>

            <sql:query  var="result" dataSource="${timetable}"
                sql="select * from data where machineID = ? AND timestamp BETWEEN ? AND ?" >
            <sql:param value="${machineID}" />
            <sql:param value="${newStartTime1}" />
            <sql:param value="${newEndTime1}" />
            </sql:query>
        </c:when>
        <c:otherwise>
            <sql:query  var="result" dataSource="${timetable}"
                    sql="select * from data where machineID = ? AND timestamp > ?" >
                <sql:param value="${machineID}" />
                <sql:param value="${newStartTime1}" />
            </sql:query>
        </c:otherwise>
    </c:choose>
</c:when>
<c:otherwise>
    <sql:query  var="result" dataSource="${timetable}"
            sql="select * from data where machineID = ?" >
        <sql:param value="${machineID}" />
    </sql:query>
</c:otherwise>
</c:choose>

    <fmt:message key='table.machineID' var="machineID"/>
    <fmt:message key='table.productID' var="productID"/>
    <fmt:message key='table.quantity' var="quantity"/>
    <fmt:message key='table.price' var="price"/>
    <fmt:message key='table.pricequantity' var="pricequantity"/>
    <fmt:setLocale value="${requestScope.locale}"/>
    
    <fmt:message key='title'>
         <fmt:param value="${id}"/>
    </fmt:message>
    <table border="1" width="100%">
    <tr>
        <th>${machineID}</th>
        <th>${productID}</th>
        <th>${price}</th>
        <th>${quantity}</th>
        <th>${pricequantity}</th>
    </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
            <td><c:out value="${row.machineID}"/></td>
            <td><c:out value="${row.productID}"/></td>
            <td>
                <fmt:formatNumber var="i1" type="number" value="${row.price}" />
                <c:out value="${i1}"/>
            </td>
            <td>
                <fmt:formatNumber var="i2" type="number" value="${row.quantity}" />
                <c:out value="${i2}"/>
            </td>
            <td>
                <fmt:formatNumber var="i3" type="currency" value="${row.quantity * row.price }" />
                <c:out value="${i3}"/>
            </td>
            </tr>
        </c:forEach>
            
    </table>


    
    