<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тестовое задание - редактирование</title>
    <style type="text/css">
        .search td{border:0;}
        fieldset {
            border: 1px solid #dedede;
        }

        legend {
            font-size: 20px;
            text-transform: uppercase;
        }

        .error {
            color: red;
        }

        .resltTable {
            width: 50%;
            border-collapse: collapse;
            border-spacing: 0px;
        }

        .resltTable td, .resltTable th {
            border: 1px solid #565454;
        }
    </style>
</head>
<body>

<br>
<br>

<fieldset>
    <legend>Редактирование детали</legend>
    <form:form action="/save" method="post" modelAttribute="part">
        <table>
            <tr>
                <th>Название</th>
                <td>
                    <c:choose>
                        <c:when test="${part.id != null}">
                            <form:input path="id" type="hidden" />
                        </c:when>

                    </c:choose>

                    <form:input path="name" />
                    <form:errors path="name" cssClass="error" />
                </td>
                <th>Количество</th>
                <td>
                    <form:input path="qty" />
                    <form:errors path="qty" cssClass="error" />
                </td>
                <th>Обязательность</th>
                <td>
                    <form:checkbox path="required" />
                    <form:errors path="required" cssClass="error" />
                </td>
                <td><button type="submit">Изменить</button></td>
            </tr>
        </table>
    </form:form>
</fieldset>

</body>
</html>