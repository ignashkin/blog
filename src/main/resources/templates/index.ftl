<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <#list posts as post>
            <div>
                <b>${post.title}</b>
                <span>${post.text}</span>
                <span>${post.tag}</span>
                <strong>${post.authorName}</strong>
            </div>
        <#else>
        No post
    </#list>
</div>
<a href="/create">Create page</a>
</@c.page>
