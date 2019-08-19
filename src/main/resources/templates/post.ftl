<#import "parts/common.ftl" as c>

<@c.page>
<div class="blog-header">
    <h1 class="blog-title">Pet in my head</h1>
    <p class="lead blog-description">Я не знаю к чему приведет этот эксперимент..может я сумасшедший и меня закроют... Может...</p>
</div>
<#if message??>
<div class="alert alert-danger" role="alert">
    ${message}
</div>
</#if>
<div class="col-sm-8 blog-main">
    <div class="blog-post">
        <a href="${post.slug}">
            <h2 class="blog-post-title">${post.title}</h2>
        </a>
        <p class="blog-post-meta">${post.authorName}</p>
        <p>${post.text}</p>
        <div>
            <#if post.filename??>
            <img src="/img/${post.filename}">
        </#if>
    </div>
    <span class="blog-post-meta">${post.tag}</span>
    <hr/>
</div>
</div>
</@c.page>