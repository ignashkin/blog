<#import "parts/common.ftl" as c>

<@c.page>
<div class="blog-header">
    <h1 class="blog-title">Pet in my head</h1>
    <p class="lead blog-description">Я не знаю к чему приведет этот эксперимент..может я сумасшедший и меня закроют... Может...</p>
</div>
<div class="row">
    <#list posts as post>
    <div class="col-sm-8 blog-main">
        <div class="blog-post">
            <h2 class="blog-post-title">${post.title}</h2>
            <p class="blog-post-meta">${post.authorName}</p>
            <p>${post.text}</p>
            <span>${post.tag}</span>
        </div>
    </div>

    <#else>
    No post
</#list>
<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
    <div class="sidebar-module sidebar-module-inset">
        <h4> Возможно тут будет навигация</h4>
        <a class="btn btn-primary" href="/create">Create page</a>
        <p>Я не знаю какими качествами надо обладать, что бы полюбить фронтэнд</p>
    </div>
</div>
</div>
</@c.page>
