<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info" >
        <div class="panel-heading">
            <div class="panel-title">Sign In</div>
            <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="/registration">Регистрация</a></div>
        </div>
        <@l.login "login" />
        <div class="form-group">
            <div class="col-md-12 control">
            </div>
        </div>
    </div>
</div>
</@c.page>