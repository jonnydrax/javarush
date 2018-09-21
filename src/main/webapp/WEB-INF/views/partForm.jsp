<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тестовое задание</title>
    <style type="text/css">

        a, a:visited, a:active {color:#0000FF;
            font-size: 10pt;}
        a:hover {color:#FF00FF;font-size: 10pt;}

        .search td, .search th{border:0 !important;}
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
            text-align: center;
        }

        .resltTable td.value {
            border: 1px solid #565454;
            text-align: left;
            padding: 10px;
        }

    </style>
</head>
<body>

<br>
<br>

<fieldset>
    <legend>Список деталей</legend>
    <table class="resltTable">
        <tr>
            <th>Наивенование
                <form action="/" method="get">
                <table class="search">
                    <tbody><tr>
                        <th>Поиск:</th>
                        <td>
                            <input name="n" type="text" value="${name == null || name.isEmpty() ? '' : name}">
                        </td>
                        <td><button type="submit">Найти</button></td>
                    </tr>
                    </tbody></table>
                </form>

            </th>
            <th>Необходимость<br>
                <c:choose>
                    <c:when test="${sort.equals(\"a\")}">
                        <b>все</b>
                    </c:when>
                    <c:otherwise>
                        <a href="?s=a">все</a>
                    </c:otherwise>
                </c:choose>
                -
                <c:choose>
                    <c:when test="${sort.equals(\"r\")}">
                        <b>необходимые</b>
                    </c:when>
                    <c:otherwise>
                <a href="?s=r">необходимые</a>
                    </c:otherwise>
                </c:choose>
                -
                <c:choose>
                    <c:when test="${sort.equals(\"o\")}">
                        <b>опциональные</b>
                    </c:when>
                    <c:otherwise>
                        <a href="?s=o">опциональные</a>
                    </c:otherwise>
                </c:choose>
            </th>
            <th>Количество</th>
        </tr>

        <c:choose>
            <c:when test="${parts.size() == 0}">
                <tr><td colspan="3">Ничего не найдено</td></tr>
            </c:when>
        </c:choose>

        <c:forEach items="${parts}" var="part">
            <tr>
                <td class="value">${part.name}<br/> <a href="/edit/${part.id}">редактировать</a> | <a href="/delete/${part.id}">удалить</a> </td>
                <td>${part.required == true ? "да" : "нет"}</td>
                <td>${part.qty}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" height="40" style="text-align: left;">
                        Страницы:

                <c:forEach var = "i" begin = "1" end = "${maxPage}">


                <c:choose>
                    <c:when test="${i == page}">
                        <b>${i}</b>
                    </c:when>
                    <c:otherwise>
                        <a href="?s=${sort}&p=${i}${name == null || name.isEmpty() ? '' : '&n='+name}">${i}</a>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${i != maxPage}">
                         -
                    </c:when>
                </c:choose>
                </c:forEach>

            </td>
        </tr>
        <tr>
            <td><b>Можно собрать:</b></td>
            <td>${totalComputers}</td>
            <td>компьютеров</td>
        </tr>

    </table>
</fieldset>
<br>
<br>
<fieldset>
    <legend>Добавление новой детали</legend>
    <form:form action="save" method="post" modelAttribute="part">
        <table>
            <tr>
                <th>Название</th>
                <td>
                    <form:input path="name" />
                </td>
                <th>Количество</th>
                <td>
                    <form:input path="qty" />
                </td>
                <th>Обязательность</th>
                <td>
                    <form:checkbox path="required" />
                </td>
                <td><button type="submit">Добавить</button></td>
            </tr>
        </table>
    </form:form>
</fieldset>

</body>
</html>