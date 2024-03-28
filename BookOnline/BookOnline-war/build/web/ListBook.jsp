<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Books</title>
</head>
<body>
    <h1>List of Books</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td><a href="addToCart?id=${book.id}">Add to Cart</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
