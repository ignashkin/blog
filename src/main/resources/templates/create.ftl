<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<#if message??>
<div class="alert alert-success" role="alert">
    ${message}
</div>
</#if>
<div class="col-sm-8">
    <h1>Create post</h1>
    <form method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <label for="title">Заголовок</label>
            <input type="text" class="form-control" name="title" value="<#if post??>${post.title} </#if>" required  placeholder="Заголовок"/>
        </div>
        <div class="form-group ${(textError??)?string('has-error','')}">
            <label for="description">Текст</label>
            <textarea rows="15" class="form-control" id ="text"
                     name="text" ><#if post??>${post.text} </#if></textarea>
            <#if textError??>
            <span class="help-block">
                ${textError}
            </span>
            </#if>
        </div>
        <div class="form-group">
            <label for="description">Файл</label>
            <input type="file" class="form-control" name="file" />
        </div>
        <div class="form-group">
            <label for="InputTag">Тэги</label>
            <input  class="form-control" type="text" name="tag"  value="<#if post??>${post.tag} </#if>" placeholder="Тэги" />
        </div>
        <div class="form-group">
            <button type="submit"  class="btn btn-primary">Сохранить</button>
            </button>
            <button class="btn btn-default">
                Отмена
            </button>
        </div>
    </form>
    <@l.logout/>
    <span><a href="/user"> User list</a></span>
</div>
</@c.page>