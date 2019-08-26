
<#macro login path isRegisterForm>
<div class="col-sm-8">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <#if !isRegisterForm>
                <div class="panel-title">Sign In</div>
                <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="/registration">Регистрация</a></div>
                <#else>
                <div class="panel-title">Sign Up</div>
                </#if>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                <form action="/${path}" method="post" id="loginform" role="form" class="form">
                    <div style="margin-bottom: 25px" class="form-group ${(usernameError??)?string('has-error','')} ">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input id="login-username" type="text" class="form-control " name="username" value="<#if user??>${user.username} </#if>" placeholder="username" >
                        </div>
                        <#if usernameError??>
                        <p class="help-block">${usernameError}</p>
                        </#if>
                    </div>
                    <div style="margin-bottom: 25px" class="form-group  ${(passwordError??)?string('has-error','')}">
                        <div  class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input id="login-password" type="password" class="form-control" name="password" placeholder="password" >
                        </div>
                        <#if passwordError??>
                        <p class="help-block has-error">${passwordError}</p>
                        </#if>
                    </div>
                    <#if isRegisterForm>
                    <div style="margin-bottom: 25px" class="form-group  ${(password2Error??)?string('has-error','')}">
                        <div  class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input id="login-password" type="password" class="form-control" name="password2" placeholder="Retype password" >
                        </div>
                        <#if password2Error??>
                        <p class="help-block has-error">${password2Error}</p>
                        </#if>
                    </div>
                    <div style="margin-bottom: 25px" class="form-group  ${(emailError??)?string('has-error','')}">
                        <div  class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input id="email" type="email" class="form-control" name="email" placeholder="some@some.com" >
                        </div>
                        <#if emailError??>
                        <p class="help-block has-error">${emailError}</p>
                        </#if>
                    </div>
                    </#if>
                    <div style="margin-top:10px" class="form-group">
                    <!-- Button -->
                        <div class="col-sm-12 controls">
                            <input type="submit" class="btn btn-success" value="${path}"/>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit"  class="btn btn-default" value="Выйти"/>
</form>
</#macro>