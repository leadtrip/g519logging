<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Logging events</title>
</head>

<body>
    <table class="table table-bordered">
        <tr>
            <th>Event id</th>
            <th>Event timestamp</th>
            <th>Event message</th>
        </tr>
        <g:each in="${loggingEventList}" var="anEvent">
            <tr>
                <td>${anEvent.eventId}</td>
                <td>${anEvent.timestmp}</td>
                <td>${anEvent.formattedMessage}</td>
            </tr>
        </g:each>
    </table>
</body>
</html>