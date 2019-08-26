<#import "parts/common.ftl" as c>

<@c.page>
<div class="blog-header">
    <h1 class="blog-title">Pet in my head</h1>
    <p class="lead blog-description">Я не знаю к чему приведет этот эксперимент..может я сумасшедший и меня закроют... Может...</p>
</div>
<div class="col-sm-8 blog-main">
    <#list posts as post>
    <div class="blog-post">
    <a href="./post/${post.slug}">
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
    <#else>
    No post
</#list>
</div>
</@c.page>
