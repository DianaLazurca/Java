<%-- 
    Document   : index
    Created on : Nov 5, 2016, 9:37:40 PM
    Author     : Diana-Stefania
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<fmt:setBundle basename='<%="i18n." +request.getAttribute("bundle")%>' />
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br><br>
        <fmt:message key='language.language'/>
        <a href="app?language=ro_RO" ><fmt:message key='language.romanian'/></a>
        <a href="app?language=en_US" ><fmt:message key='language.english'/></a>
        <a href="app?language=it_IT" ><fmt:message key='language.italian'/></a>
        
        <br>
        <br>
            <fmt:message key='newRequest'/>
            <ul>
                <li><a href="Service?timestamp=2016.10.25-16:00" >2016.10.25-16:00</a></li>
                <li><a href="Service?timestamp=2016.10.25-16:00" >2016.10.25-17:40</a></li>
            </ul>
        <br>
        <%--
        <h:dataView>
            <h:machineView id='M0010' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/>
            <h:machineView id='M0100' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/>
            <h:machineView id='M1010' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/>
            <h:machineView id='M0101' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/>
        </h:dataView> --%>
        
        <h:machineView id='M0000' startTime='2016.11.02-16:00' endTime='2016.11.25-17:40'/>
        <br>
        <h:machineView id='M0010' />
        <br>
        <h:machineView id='M0011' />
        <br>
        <h:machineView id='M0100' startTime='2016.11.02-16:00' endTime='2016.11.25-17:40'/>
        <br>
        <h:machineView id='M0101' startTime='2016.11.02-16:00' endTime='2016.11.25-17:40'/>
        <br>
        <h:machineView id='M0110'/>
        <br>
        <h:machineView id='M0111'/>
        <br>
        <h:machineView id='M1000' startTime='2016.11.02-16:00' endTime='2016.11.25-17:40'/>
        <br>
        <h:machineView id='M1010' />
        <br>
        <h:machineView id='M1011' />
        <br>
        <h:machineView id='M1100' startTime='2016.11.02-16:00' endTime='2016.11.25-17:40'/>
        <br>
        <h:machineView id='M1101' startTime='2016.11.02-16:00' endTime='2016.11.25-17:40'/>
        <br>
        <h:machineView id='M1110'/>
        <br>
        <h:machineView id='M1111'/>
        <%--
        <h:machineView id='M0100' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/>
        <h:machineView id='M1010' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/>
        <h:machineView id='M0101' startTime='2016.10.25-16:00' endTime='2016.10.25-17:40'/> --%>
        
    </body>
</html>
