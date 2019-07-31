<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div class="container">
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <label for="InputTitle">Заголовок</label>
            <input class="form-control" type="text" name="title" placeholder="Заголовок"/>
        </div>
        <div class="form-group">
            <label for="InputText">текст</label>
            <input  class="form-control" type="text" name="text" placeholder="текст" />
        </div>
        <div class="form-group">
            <label for="InputTag">Тэги</label>
            <input  class="form-control" type="text" name="tag" placeholder="Тэг" />
        </div>
        <button type="submit"  class="btn btn-primary">Добавить</button>
    </form>
<@l.logout/>
</div>
</@c.page>