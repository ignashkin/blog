<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div class="container">
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <label for="exampleInputEmail1">Login</label>
            <input class="form-control" type="text" name="title" placeholder="Заголовок"/>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input  class="form-control" type="text" name="text" placeholder="текст" />
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Tags</label>
            <input  class="form-control" type="text" name="tag" placeholder="Тэг" />
        </div>
        <button type="submit"  class="btn btn-primary">Добавить</button>
    </form>
<@l.logout/>
</div>
</@c.page>