<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>My Home Page</title>
</head>
<body>
<div class="container-lg">
    <p>
    <div style="text-align: center">Hello,World 2021</div>
    </p>
    <p>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="toRegister()">用户注册</button>
    </p>
</div>

<script>
    function toRegister() {
        window.location.href = "/register";
    }
</script>
</body>