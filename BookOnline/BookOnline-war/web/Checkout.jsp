<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
</head>
<body>
    <h1>Checkout</h1>
    <h2>Order Summary</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <c:forEach items="${cartItems}" var="item">
            <tr>
                <td>${item.book.id}</td>
                <td>${item.book.title}</td>
                <td>${item.book.author}</td>
                <td>${item.book.price}</td>
                <td>${item.quantity}</td>
                <td>${item.book.price * item.quantity}</td>
            </tr>
        </c:forEach>
    </table>
    <p>Total Price: ${totalPrice}</p>
    <form action="confirmOrder" method="post">
        <input type="submit" value="Confirm Order">
    </form>
    <form action="cancelOrder" method="post">
        <input type="submit" value="Cancel Order">
    </form>
</body>
</html>
