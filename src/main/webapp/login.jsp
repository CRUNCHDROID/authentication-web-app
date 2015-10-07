<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication</title>
    </head>
    <body>
        <h1>Authentication</h1>

        <form action="j_security_check" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td><label for="j_username">Username</label></td>
                        <td><input type="text" name="j_username" id="j_username"/></td>
                    </tr>
                    <tr>
                        <td><label for="j_password">Password</label></td>
                        <td><input type="password" name="j_password" id="j_password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Connexion"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
