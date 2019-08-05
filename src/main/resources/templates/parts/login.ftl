
<#macro login path>
<div style="padding-top:30px" class="panel-body">
    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
    <form action="/${path}" method="post" id="loginform" class="form-horizontal" role="form">
        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email" required>
        </div>
        <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="login-password" type="password" class="form-control" name="password" placeholder="password" required>
        </div>
        <div class="input-group">
            <div class="checkbox">
                <label>
                    <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                </label>
            </div>
        </div>
        <div style="margin-top:10px" class="form-group">
            <!-- Button -->

            <div class="col-sm-12 controls">
                <input type="submit" class="btn btn-success" value="${path}"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />

    </form>
</div>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit"  class="btn btn-default" value="Выйти"/>
</form>
</#macro>