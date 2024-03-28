<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${cartItems}" var="item">
            <tr>
                <td>${item.book.id}</td>
                <td>${item.book.title}</td>
                <td>${item.book.author}</td>
                <td>${item.book.price}</td>
                <td>
                    <form action="updateCartItem" method="post">
                        <input type="hidden" name="itemId" value="${item.id}">
                        <input type="number" name="quantity" value="${item.quantity}">
                        <input type="submit" value="Update">
                    </form>
                </td>
                <td>${item.book.price * item.quantity}</td>
                <td><a href="removeCartItem?id=${item.id}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
    <p>Total Price: ${totalPrice}</p>
    <a href="Checkout.jsp">Proceed to Checkout</a>
</body>
</html>
