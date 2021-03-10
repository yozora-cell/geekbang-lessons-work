<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>My Home Page</title>
</head>
<body>
<div class="container-lg">
    <p class="bg-primary">
    <h1>Welcome!</h1>
    </p>
    <p class="bg-success">
    <h2>${title}</h2>
    <p>${errMsg}</p>
    </p>
    <p>
        用户名: ${username}
    </p>
    <p>
        邮箱: ${email}
    </p>
</div>

</body>