<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"href="/">Home</a>
        </div>
        <div  id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="nav-item"><a href="/create">Create Post</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <#if user??>
                <li  class="nav-item"><a href="/user/profile">${name}</a></li>
                </#if>
                 <#if known>
                <li class="nav-item"><@l.logout/></li>
                <#else>
                <li class="nav-item"><a href="/login" class="btn btn-default">Войти</a></li>
                </#if>
            </ul>
        </div>
    </div>
</nav>
