<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Office</title>
</head>
<style>
    .text, .textarea {
        margin-bottom: 1em;
    }

    .textarea {
        display: flex;
        flex-direction: column;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: stretch;
        max-width: 20rem;
    }

    span.red {
        color: red;
    }
</style>
<body>
    <a href="./office"><- Back</a>
    <h1>Add Office</h1>
    <hr>
    <form action="office" method="post">
        <div class="text">
            <label for="officeCode">Office code<span class="red">*</span>: </label>
            <input type="text" id="officeCode" name="officeCode" placeholder="1" required>
        </div>
        <div class="text">
            <label for="city">City<span class="red">*</span>: </label>
            <input type="text" id="city" name="city" placeholder="Bangkok" required>
        </div>
        <div class="text">
            <label for="phone">Phone number<span class="red">*</span>: </label>
            <input type="text" id="phone" name="phone" placeholder="+66 80 000 xxxx" required>
        </div>
        <div class="textarea">
            <label for="addressLine1">Address line 1<span class="red">*</span>: </label>
            <textarea id="addressLine1" name="addressLine1" required></textarea>
        </div>
        <div class="textarea">
            <label for="addressLine2">Address line 2: </label>
            <textarea id="addressLine2" name="addressLine2"></textarea>
        </div>
        <div class="text">
            <label for="state">State: </label>
            <input type="text" id="state" name="state">
        </div>
        <div class="text">
            <label for="country">Country<span class="red">*</span>: </label>
            <input type="text" id="country" name="country" placeholder="Thailand" required>
        </div>
        <div class="text">
            <label for="postalCode">Postal code<span class="red">*</span>: </label>
            <input type="text" id="postalCode" name="postalCode" placeholder="10220" required>
        </div>
        <div class="text">
            <label for="territory">Territory<span class="red">*</span>: </label>
            <input type="text" id="territory" name="territory" placeholder="TH" required>
        </div>
        <input type="submit" value="Submit to add office">
    </form>
</body>
</html>
